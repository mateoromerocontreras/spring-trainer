# Requirements Traceability Matrix
                                                                                                                                                                                                                 
| Requirement ID                | Use Case | Domain Entities Involved | Business Rule | Priority |
|:------------------------------| :--- | :--- | :--- | :--- |
| **FR-01** (Self-Registration) | `UC-01` | `GymTenant`, `Client`, `Subscription` | `BR-01` | Must Have |
| **FR-02** (Client Directory)  | `UC-06` | `Client`, `GymTenant` | `BR-01` | Must Have |
| **FR-03** (Debt Tracking)     | `UC-06` | `Subscription`, `PaymentRecord` | `BR-02` | Must Have |
| **FR-04** (MP Subscriptions)  | `UC-02` | `Subscription`, `PaymentRecord` | `BR-01`, `BR-02` | Must Have |
| **FR-05** (MP Manual Payment) | `UC-02` | `Subscription`, `PaymentRecord` | `BR-01`, `BR-02` | Must Have |
| **FR-06** (Webhook Handler)   | `UC-02` | `PaymentRecord`, `Subscription` | `BR-02` | Must Have |
| **FR-07** (Training Plan)     | `UC-03` | `TrainingPlan`, `RoutineDay`, `PlannedExercise` | `BR-01`, `BR-05` | Must Have |
| **FR-08** (Exercise Catalog)  | `UC-03` | `ExerciseCatalogItem`, `PlannedExercise` | `BR-05` | Should Have |
| **FR-09** (Routine View)      | `UC-03` | `TrainingPlan`, `RoutineDay`, `PlannedExercise` | `BR-01` | Must Have |
| **FR-10** (Slot Scheduling)   | `UC-04`, `UC-05` | `TimeSlotSchedule`, `GymTenant` | `BR-01` | Should Have |
| **FR-11** (Priority Booking)  | `UC-04` | `TimeSlotBooking`, `TimeSlotSchedule`, `Subscription` | `BR-03` | Should Have |
| **FR-12** (24h Cancellation)  | `UC-05` | `TimeSlotBooking`, `TimeSlotSchedule` | `BR-04` | Should Have | 
