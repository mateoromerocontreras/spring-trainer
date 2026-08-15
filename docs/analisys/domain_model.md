# Domain Conceptual Model                                                                                                                                                                                    
                                                                                                                                                                                                                 
```mermaid
classDiagram
    direction TB
                                                                                                                                                                                                                 
        class GymTenant {                                                                                                                                                                                        
            +tenantCode: String                                                                                                                                                                                  
            +gymName: String                                                                                                                                                                                     
            +subdomain: String                                                                                                                                                                                   
            +slotBookingEnabled: Boolean                                                                                                                                                                         
            +cancellationWindowHours: Integer = 24                                                                                                                                                               
            +monthlyDebtCutoffDay: Integer = 10                                                                                                                                                                  
            +createdAt: DateTime                                                                                                                                                                                 
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class Manager {                                                                                                                                                                                          
            +email: String                                                                                                                                                                                       
            +fullName: String                                                                                                                                                                                    
            +phone: String                                                                                                                                                                                       
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class Client {                                                                                                                                                                                           
            +email: String                                                                                                                                                                                       
            +fullName: String                                                                                                                                                                                    
            +phone: String                                                                                                                                                                                       
            +emergencyContact: String                                                                                                                                                                            
            +enrollmentDate: Date                                                                                                                                                                                
            +accountStatus: AccountStatus                                                                                                                                                                        
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class MembershipPlan {                                                                                                                                                                                   
            +name: String                                                                                                                                                                                        
            +price: Decimal                                                                                                                                                                                      
            +billingPeriod: BillingPeriod                                                                                                                                                                        
            +description: String                                                                                                                                                                                 
            +isActive: Boolean                                                                                                                                                                                   
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class Subscription {                                                                                                                                                                                     
            +startDate: Date                                                                                                                                                                                     
            +currentPeriodEnd: Date                                                                                                                                                                              
            +status: SubscriptionStatus                                                                                                                                                                          
            +paymentType: PaymentType                                                                                                                                                                            
            +isInDebt: Boolean                                                                                                                                                                                   
            +externalMpPreApprovalId: String                                                                                                                                                                     
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class PaymentRecord {                                                                                                                                                                                    
            +amount: Decimal                                                                                                                                                                                     
            +paymentDate: DateTime                                                                                                                                                                               
            +status: PaymentStatus                                                                                                                                                                               
            +externalMpPaymentId: String                                                                                                                                                                         
            +paymentMethod: String                                                                                                                                                                               
            +invoiceNumber: String                                                                                                                                                                               
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class TrainingPlan {                                                                                                                                                                                     
            +title: String                                                                                                                                                                                       
            +goalObjective: String                                                                                                                                                                               
            +startDate: Date                                                                                                                                                                                     
            +endDate: Date                                                                                                                                                                                       
            +status: PlanStatus                                                                                                                                                                                  
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class RoutineDay {                                                                                                                                                                                       
            +dayName: String                                                                                                                                                                                     
            +orderIndex: Integer                                                                                                                                                                                 
            +targetMuscleGroup: String                                                                                                                                                                           
            +notes: String                                                                                                                                                                                       
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class ExerciseCatalogItem {                                                                                                                                                                              
            +name: String                                                                                                                                                                                        
            +muscleGroup: MuscleGroup                                                                                                                                                                            
            +description: String                                                                                                                                                                                 
            +referenceVideoUrl: String                                                                                                                                                                           
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class PlannedExercise {                                                                                                                                                                                  
            +customExerciseName: String                                                                                                                                                                          
            +targetSets: Integer                                                                                                                                                                                 
            +targetReps: String                                                                                                                                                                                  
            +targetWeightKg: Decimal                                                                                                                                                                             
            +restIntervalSeconds: Integer                                                                                                                                                                        
            +executionNotes: String                                                                                                                                                                              
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class TimeSlotSchedule {                                                                                                                                                                                 
            +dayOfWeek: DayOfWeek                                                                                                                                                                                
            +startTime: Time                                                                                                                                                                                     
            +endTime: Time                                                                                                                                                                                       
            +maxCapacity: Integer                                                                                                                                                                                
            +isActive: Boolean                                                                                                                                                                                   
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        class TimeSlotBooking {                                                                                                                                                                                  
            +bookingDate: Date                                                                                                                                                                                   
            +bookedAt: DateTime                                                                                                                                                                                  
            +status: BookingStatus                                                                                                                                                                               
            +priorityTier: PriorityTier                                                                                                                                                                          
        }                                                                                                                                                                                                        
                                                                                                                                                                                                                 
        %% Associations & Multiplicities                                                                                                                                                                         
        GymTenant "1" *-- "1..*" Manager : managed_by                                                                                                                                                            
        GymTenant "1" *-- "0..*" Client : enrolls                                                                                                                                                                
        GymTenant "1" *-- "1..*" MembershipPlan : offers                                                                                                                                                         
        GymTenant "1" *-- "0..*" ExerciseCatalogItem : maintains_catalog                                                                                                                                         
        GymTenant "1" *-- "0..*" TimeSlotSchedule : defines_schedule                                                                                                                                             
                                                                                                                                                                                                                 
        Client "1" -- "0..*" Subscription : holds                                                                                                                                                                
        Subscription "1" -- "1" MembershipPlan : based_on                                                                                                                                                        
        Subscription "1" *-- "0..*" PaymentRecord : logs_payments                                                                                                                                                
                                                                                                                                                                                                                 
        Manager "1" -- "0..*" TrainingPlan : authors                                                                                                                                                             
        Client "1" -- "0..*" TrainingPlan : assigned_to                                                                                                                                                          
        TrainingPlan "1" *-- "1..*" RoutineDay : consists_of                                                                                                                                                     
        RoutineDay "1" *-- "1..*" PlannedExercise : contains                                                                                                                                                     
        PlannedExercise "0..*" o-- "0..1" ExerciseCatalogItem : references_optional_catalog                                                                                                                      
                                                                                                                                                                                                                 
        TimeSlotSchedule "1" *-- "0..*" TimeSlotBooking : generates_sessions                                                                                                                                     
        Client "1" -- "0..*" TimeSlotBooking : reserves                                                                                                                                                          
```        
---
  ## Business Rules & Invariants
                                                                                                                                                                                                                 
- BR-01 (Tenant Boundary): An instance of Client, Subscription, TrainingPlan, or TimeSlotSchedule belongs strictly to one GymTenant.
- BR-02 (10th-of-Month Debt Cutoff): On day >10 of the month, if no approved PaymentRecord covers the current period, Subscription.isInDebt is set to TRUE.
- BR-03 (Priority Allocation): In-debt clients are granted LOW_PRIORITY bookings; up-to-date clients are granted HIGH_PRIORITY bookings.
- BR-04 (24-Hour Cancellation): Bookings can be cancelled without penalty up to 24 hours prior to TimeSlotSchedule.startTime.
- BR-05 (Hybrid Exercise Architecture): PlannedExercise can reference a standardized ExerciseCatalogItem or define a customExerciseName.


---