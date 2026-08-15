```markdown
    # Robustness Analysis & System Sequence Diagrams

    ## 1. Robustness BCE Model (Boundary - Control - Entity)
```
```mermaid
    flowchart LR
        subgraph Boundary ["<<boundary>>"]
            B_Reg["Mobile::RegistrationView"]
            B_Pay["Mobile::PaymentView"]
            B_Hook["Webhook::MercadoPagoController"]
            B_Plan["Web::TrainingPlanBuilder"]
            B_Book["Mobile::BookingView"]
        end

        subgraph Control ["<<control>>"]
            C_Auth["AuthenticationService"]
            C_Sub["SubscriptionBillingService"]
            C_Plan["TrainingPlanService"]
            C_Book["TimeSlotBookingService"]
        end

        subgraph Entity ["<<entity>>"]
            E_Client[("Client")]
            E_Sub[("Subscription")]
            E_Pay[("PaymentRecord")]
            E_Plan[("TrainingPlan")]
            E_Slot[("TimeSlotBooking")]
        end

        B_Reg --> C_Auth
        C_Auth --> E_Client
        C_Auth --> E_Sub

        B_Pay --> C_Sub
        B_Hook --> C_Sub
        C_Sub --> E_Sub
        C_Sub --> E_Pay

        B_Plan --> C_Plan
        C_Plan --> E_Plan

        B_Book --> C_Book
        C_Book --> E_Slot
        C_Book --> E_Sub
```
---
  ## 2. System Sequence Diagram (SSD): Mercado Pago Webhook & Debt Clearance
```mermaid
sequenceDiagram
        autonumber
        actor Client as Gym Client
        participant App as Mobile App
        participant System as Spring Trainer Backend
        participant MP as Mercado Pago Gateway
        
        Client->>App: Choose Plan & Pay (Recurring / Manual)
        App->>System: initiatePayment(tenantCode, planId, paymentMode)
        System->>MP: createPreferenceOrPreApproval(clientData, price)
        MP-->>System: checkoutUrl, externalId
        System-->>App: returnCheckoutSession(url)
        App->>MP: Execute Payment Authorization
        MP->>System: POST /api/webhooks/mercadopago (payment_id, status=approved)
        System->>MP: verifyPayment(payment_id)
        MP-->>System: paymentDetails(status: approved, amount)
        System->>System: recordPayment() & updateSubscription(isInDebt=false)
        System-->>App: Push Notification: "Payment Approved! Subscription Active"
```
---
  ## 3. System Sequence Diagram (SSD): Slot Reservation with Priority
```mermaid
sequenceDiagram
        autonumber
        actor Client as Gym Client
        participant App as Mobile App
        participant System as Spring Trainer Backend
        Client->>App: Request Slot Reservation (scheduleId, date)
        App->>System: bookSlot(scheduleId, date)
        System->>System: checkDebtStatus(clientId)
        System->>System: evaluateCapacityAndPriority(scheduleId, date)
        alt Client Up-to-Date
            System->>System: createBooking(priority: HIGH, status: CONFIRMED)
            System-->>App: reservationConfirmed(status: CONFIRMED)
        else Client In Debt
            alt Slots Available
                System->>System: createBooking(priority: LOW, status: CONFIRMED)
                System-->>App: reservationConfirmed(status: CONFIRMED_LOW_PRIORITY)
            else Capacity Full
                System->>System: createBooking(priority: LOW, status: WAITLISTED)
                System-->>App: reservationWaitlisted(message: "Standby queue")
            end
        end
```
---
