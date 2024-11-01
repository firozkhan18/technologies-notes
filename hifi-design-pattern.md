# Design patterns topic:

---

# Table of Contents

- [What is a "design pattern"?](#what-is-a-design-pattern)
- [What are the main characteristics of templates?](#what-are-the-main-characteristics-of-templates)
- [Types of design patterns](#types-of-design-patterns)
- [Give examples of key design patterns](#give-examples-of-key-design-patterns)
- [Give examples of generative design patterns](#give-examples-of-generative-design-patterns)
- [Give examples of structural design patterns](#give-examples-of-structural-design-patterns)
- [Give examples of behavioral design patterns](#give-examples-of-behavioral-design-patterns)
- [What is an "anti-pattern"? What anti-patterns do you know?](#what-is-an-anti-pattern-what-anti-patterns-do-you-know)
- [What is Dependency Injection?](#what-is-dependency-injection)

---

## What is a "design pattern"?
A design pattern is a proven and ready-to-use solution. It's not a class or a library but a language-agnostic approach that can be implemented differently across programming languages.

### Pros of using templates:
- Reduce development complexity with out-of-the-box abstractions.
- Facilitate communication between developers.
- Unify solution details across modules.
- Enable reuse of successful solutions.
- Assist in choosing the most suitable design option.

### Cons:
- Blind adherence to patterns can complicate the program.
- The urge to try a pattern without valid reasons.

---

## What are the main characteristics of templates?
- **Name**: Each template has a unique identifier.
- **Purpose**: The goal of the template.
- **Task**: The specific problem the template addresses.
- **Method of solution**: Proposed methods for problem-solving.
- **Participants**: Entities involved in the solution.
- **Consequences**: Results of using the template.
- **Implementation**: Possible ways to implement the template.

---

## Types of design patterns
- **Fundamental**: Basic building blocks used by other patterns.
- **Creational**: Abstracts the process of creating instances.
- **Structural**: Defines complex structures and modifies existing interfaces.
- **Behavioral**: Defines interactions between objects for flexibility.

---

## Give examples of key design patterns
- **Delegation pattern**: Transfers responsibility to related entities.
- **Functional design**: Ensures single responsibility with minimal side effects.
- **Immutable interface**: Creates unchangeable objects.
- **Marker interface**: Uses presence or absence as an attribute.
- **Property container**: Adds properties to an entity without extending it.
- **Event channel**: Centralizes event subscription and publication.

---

## Give examples of generative design patterns
- **Abstract factory**: Interface for creating related classes.
- **Builder**: Interface for creating complex objects.
- **Factory method**: Delegates object creation to subclasses.
- **Prototype**: Creates new objects by cloning existing ones.
- **Singleton**: Restricts a class to a single instance.

---

## Give examples of structural design patterns
- **Adapter**: Enables interaction between incompatible interfaces.
- **Bridge**: Separates interface from implementation.
- **Composite**: Combines similar objects into a single entity.
- **Decorator**: Enhances functionality without inheritance.
- **Facade**: Simplifies interaction with multiple classes.
- **Flyweight**: Shares instances to reduce memory usage.
- **Proxy**: Acts as an intermediary to control access.

---

## Give examples of behavioral design patterns
- **Chain of responsibility**: Organizes responsibility levels.
- **Command**: Encapsulates actions and parameters.
- **Interpreter**: Addresses common tasks.
- **Iterator**: Allows sequential access to elements.
- **Mediator**: Facilitates interactions while promoting loose coupling.
- **Memento**: Saves and restores object states.
- **Observer**: Notifies dependent objects of state changes.
- **State**: Changes behavior based on the object's state.
- **Strategy**: Encapsulates interchangeable algorithms.
- **Template method**: Defines a structure for algorithms, allowing customization.
- **Visitor**: Performs operations on objects without modifying their classes.

---

## What is an "anti-pattern"? What anti-patterns do you know?
An anti-pattern is a common but ineffective solution to a recurring problem.

### Common anti-patterns:
- **Poltergeists**: Classes with limited responsibility, often used to transfer information.
- **Big ball of mud**: A system lacking a recognizable structure.
- **God object**: Concentration of too many functions in a single part of the system.
- **Magic pushbutton**: Inappropriately simplistic interfaces for complex actions.
- **Race hazard**: Failing to account for unexpected event orders.

---

## What is Dependency Injection?
Dependency Injection is a software development pattern that promotes loosely coupled code by allowing objects to define their dependencies externally, enabling greater flexibility and easier testing.

---
