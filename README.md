# Spring Trainer - Software Engineering Workspace

This project is structured following the **Unified Process (UP / RUP)** methodology, managed by the **Systems Analyst & Software Architecture** agent.



## 🧭 Engineering Workflow

```mermaid 
flowchart
    subgraph INCEPTION ["1. Inception & Elicitation"]
      V[Vision & Scope]
      FR[Functional Reqs]
      NFR[Non-Functional Reqs FURPS+]
    end

    subgraph ANALYSIS ["2. Analysis Domain (Conceptual)"]
        UC[Use Cases & Specs]
        DM[Domain Class Model]
        SSD[System Sequence Diagrams]
        BCE[Robustness BCE Analysis]
    end
    
    subgraph DESIGN ["3. Design Domain (Technical Architecture)"]
        ARCH[Clean/Hexagonal Architecture]
        DCD[Design Class Diagrams]
        SD[Detailed Sequence Diagrams]
        DB[Data & Persistence Schema]
    end

    subgraph IMPLEMENTATION ["4. Construction"]
        CODE[Spring Boot Services & APIs]
        TEST[Unit & Integration Tests]
    end

```



## 📂 Documentation Directory

- [`docs/requirements/`](file:///home/mateoromero/Backend/spring-trainer/docs/requirements): Vision, FURPS+ Requirements, and User Stories.
- [`docs/analysis/`](file:///home/mateoromero/Backend/spring-trainer/docs/analysis): Conceptual Class Models, Use Case Specifications, SSDs.
- [`docs/design/`](file:///home/mateoromero/Backend/spring-trainer/docs/design): Architectural decisions, Design Class Diagrams, Sequence Diagrams, DB Schemas.
- [`docs/templates/`](file:///home/mateoromero/Backend/spring-trainer/docs/templates): Standardized UP engineering templates.
