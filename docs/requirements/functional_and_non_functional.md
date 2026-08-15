# Requirements Specification (FURPS+ Model)                                                                                                                                                                  
                                                                                                                                                                                                                 
## 1. Functional Requirements (FR)
                                                                                                                                                                                                                 
| ID | Feature / Capability | Description | Priority | Actor |
| :--- | :--- | :--- | :--- | :--- |
| **FR-01** | Multi-Tenant Self-Registration | Clients register freely via the mobile app by providing email, credentials, profile data, and selecting/entering the Gym Tenant code. | **Must Have** | Client |
| **FR-02** | Manager Client Directory | Manager views all enrolled clients with public info (Name, Email, Phone, Emergency Contact, Enrollment Date, Status). | **Must Have** | Manager |
| **FR-03** | Debt & Subscription Tracking | System calculates subscription status and debt flag automatically: clients who have not paid after the 10th of the month are marked `isInDebt = TRUE`. | **Must   Have** | System, Manager |
| **FR-04** | Mercado Pago Subscriptions | Clients can enroll in automated recurring credit card debits via Mercado Pago PreApproval. | **Must Have** | Client, Mercado Pago |
| **FR-05** | Mercado Pago Manual Payments | Clients can execute one-time manual monthly payments via Mercado Pago Checkout Preference. | **Must Have** | Client, Mercado Pago |
| **FR-06** | Webhook Payment Processing | System receives, verifies, and records Mercado Pago payment webhooks, instantly updating subscription status and clearing debts. | **Must Have** | Mercado Pago,System |
| **FR-07** | Training Plan Builder | Manager creates personalized training plans with custom routine days and planned exercises (sets, reps, weight, rest, notes). | **Must Have** | Manager |
| **FR-08** | Exercise Catalog Library | Manager can select exercises from a reusable catalog or define custom ad-hoc exercises. | **Should Have** | Manager |
| **FR-09** | Client Routine Consultation | Client consults their assigned active training plan and exercise execution details in the mobile app. | **Must Have** | Client |
| **FR-10** | Configurable Time-Slot Scheduling | Manager defines weekly time slots with max occupancy capacity (e.g., Monday 17:00-18:00, capacity: 5). | **Should Have** | Manager |
| **FR-11** | Priority Slot Booking | Clients reserve slots. Up-to-date clients receive high priority; in-debt clients are granted low priority / standby. | **Should Have** | Client |
| **FR-12** | 24-Hour Slot Cancellation | Clients can cancel a booked slot without penalty if performed at least 24 hours prior to the slot start time. | **Should Have** | Client |

---                                                                                                                                                                                                                 
## 2. Non-Functional Requirements (FURPS+)
                                                                                                                                                                                                                 
### 2.1 Functionality (Security & Auditing)
  - **NFR-F01 (Authentication)**: JWT (JSON Web Token) stateless authentication with BCrypt password hashing.
  - **NFR-F02 (Multi-Tenant Authorization)**: Every API request must resolve tenant context and enforce strict logical or schema isolation (`ROLE_MANAGER`, `ROLE_CLIENT`).
  - **NFR-F03 (Payment Security)**: Signature verification on all Mercado Pago webhook callbacks to prevent spoofing.
                                                                                                                                                                                                               
### 2.2 Usability (Human Factors)
  - **NFR-U01 (Mobile Ergonomics)**: Mobile interface optimized for one-handed operation and high readability during active workout sessions.
  - **NFR-U02 (Manager Dashboard)**: Desktop web interface with rapid filtering, search-as-you-type client lists, and drag-and-drop routine assembly.
                                                                                                                                                                                                                 
### 2.3 Reliability (Fault Tolerance & Durability)
  - **NFR-R01 (Idempotent Webhooks)**: Webhook handler must be strictly idempotent to prevent duplicate payment records.
  - **NFR-R02 (Data Durability)**: Automated daily database snapshots and transactional consistency (`@Transactional`) across payment and booking mutations.
                                                                                                                                                                                                                 
### 2.4 Performance (Capacity & Latency)
  - **NFR-P01 (Response Time)**: 95% of API requests (routine loading, profile fetch, booking) must complete in $< 200\text{ ms}$.
  - **NFR-P02 (Concurrency)**: Designed to handle 50 active clients per gym tenant simultaneously without resource contention.
                                                                                                                                                                                                                 
### 2.5 Supportability (Maintainability & Extensibility)
  - **NFR-S01 (Clean Architecture)**: Strict separation into Domain, Application, and Infrastructure layers in Spring Boot.
  - **NFR-S02 (Test Coverage)**: Minimum 80% line and branch coverage on business rules (debt evaluation, 24h cancellation, priority booking).
                                                                                                                                                                                                                 
### 2.6 Plus (+) Constraints
  - **Tech Stack**: Spring Boot (Java 17+ or Kotlin), React (Web Dashboard), React Native / Expo (iOS/Android).
  - **Payment Gateway**: Mercado Pago REST APIs & Webhooks.
