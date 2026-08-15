# Vision & Scope: Spring Trainer Multi-Tenant Platform                                                                                                                                                       
                                                                                                                                                                                                                 
## 1. Business Opportunity & Problem Statement
  Small-to-medium gym managers face administrative fragmentation across member payment tracking, debt collection, and personalized workout routine distribution. Clients lack a modern, unified mobile interface to track routines, consult payment status, and reserve workout time slots.
                                                                                                                                                                                                                 
  **Spring Trainer** solves this by providing a SaaS multi-tenant platform:
  - **Gym Managers**: Access a PC Web administrative dashboard to manage clients, track debts, build routines, and configure gym capacity.
  - **Gym Clients**: Access an iOS/Android mobile app to view assigned routines, manage monthly subscriptions via Mercado Pago, and book training slots.
                                                                                                                                                                                                                 
---

## 2. Stakeholders & System Actors
                                                                                                                                                                                                                 
  ### Primary Actors
  - **Gym Manager / Trainer**: Administrative user operating from a desktop PC web interface. Manages clients, designs workout programs, and configures scheduling rules.
  - **Gym Client / Member**: End-user operating from a smartphone (iOS / Android). Views training routines, makes membership payments, and books workout slots.
                                                                                                                                                                                                                 
  ### Secondary Actors
  - **Mercado Pago Platform**: External payment gateway managing automated recurring subscriptions (PreApproval) and one-off monthly checkout sessions.
  - **Notification Service**: External push notification and transactional email gateway.
                                                                                                                                                                                                                 
  ---
                                                                                                                                                                                                                 
  ## 3. Scope Boundaries
  - **Tenancy**: Multi-tenant isolation. Each gym operates under its own tenant identifier/subdomain with isolated client lists and financial records.
  - **Client Capacity**: Optimized for gyms with up to 50 active clients per tenant instance.
  - **Platforms**:
    - Manager: Responsive PC Desktop Web application (React).
    - Client: Mobile application (Android Play Store / iOS App Store).
    - Backend: Spring Boot Multi-Tenant REST API service.
