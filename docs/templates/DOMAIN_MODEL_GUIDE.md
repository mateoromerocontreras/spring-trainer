# Domain Model & Conceptual Class Modeling Guidelines

## Objective
Capture real-world concepts, business entities, associations, and domain attributes independent of software technology (no getters/setters, no database IDs as foreign key columns, no framework types).

---

## 1. Notation & Structure
- **Conceptual Classes**: Nouns representing meaningful domain abstractions (e.g., `Trainer`, `TrainingPlan`, `Exercise`, `WorkoutSession`).
- **Attributes**: Key descriptive properties (e.g., `name: String`, `durationMinutes: Integer`, `targetHeartRate: Range`).
- **Associations & Multiplicities**:
  - `1` (Exactly one)
  - `0..1` (Zero or one)
  - `1..*` (One or more)
  - `*` or `0..*` (Zero or more)
- **Relationships**:
  - Association (`--`)
  - Aggregation (`o--`)
  - Composition (`*--`)
  - Generalization / Inheritance (`<|--`)

---

## 2. Mermaid Domain Class Diagram Example

```mermaid
classDiagram
    direction TB

    class Trainer {
        +fullName: String
        +specialty: String
        +certificationLevel: String
    }

    class Trainee {
        +fullName: String
        +fitnessLevel: FitnessLevel
        +goals: List~String~
    }

    class TrainingPlan {
        +title: String
        +objective: String
        +startDate: Date
        +endDate: Date
        +status: PlanStatus
    }

    class WorkoutSession {
        +sessionDate: DateTime
        +durationMinutes: Integer
        +intensity: IntensityLevel
        +notes: String
    }

    class Exercise {
        +name: String
        +targetMuscleGroup: MuscleGroup
        +defaultSets: Integer
        +defaultReps: Integer
    }

    Trainer "1" -- "0..*" TrainingPlan : creates
    TrainingPlan "1" -- "1" Trainee : assigned_to
    TrainingPlan "1" *-- "1..*" WorkoutSession : composed_of
    WorkoutSession "1" o-- "1..*" Exercise : includes
```
