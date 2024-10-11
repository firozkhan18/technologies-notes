# Builder Design Pattern

The Builder Design Pattern is a creational pattern used in software design to construct a complex object step by step. It allows for the construction of a product in a step-by-step fashion, where the construction process can vary based on the type of product being built. This pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

![Builder Design Pattern](builder-Design-pattern)

## Important Topics for the Builder Design Pattern
- Components of the Builder Design Pattern
- Builder Design Pattern Example
- When to use Builder Design Pattern?
- When not to use Builder Design Pattern?

For an in-depth understanding of the Builder pattern, the System Design Course covers the principles behind the pattern and walks you through practical implementation techniques.

## Components of the Builder Design Pattern
1. **Product**: The complex object that the Builder pattern constructs. It consists of multiple components or parts, and its structure can vary based on the implementation. The Product is typically a class with attributes representing the different parts that the Builder constructs.
   
2. **Builder**: An interface that declares the construction steps for building a complex object. It includes methods for constructing individual parts of the product. By defining an interface, the Builder allows for the creation of different concrete builders that can produce variations of the product.
   
3. **ConcreteBuilder**: Classes that implement the Builder interface, providing specific implementations for building each part of the product. Each ConcreteBuilder is tailored to create a specific variation of the product and keeps track of the product being constructed.
   
4. **Director**: Responsible for managing the construction process of the complex object. It collaborates with a Builder without knowing the specific details about how each part of the object is constructed. It provides a high-level interface for constructing the product and managing the steps needed to create the complex object.
   
5. **Client**: The code that initiates the construction of the complex object. It creates a Builder object and passes it to the Director to initiate the construction process. The Client may retrieve the final product from the Builder after construction is complete.

## Builder Design Pattern Example

### Problem Statement
You are tasked with implementing a system for building custom computers. Each computer can have different configurations based on user preferences. The goal is to provide flexibility in creating computers with varying CPUs, RAM, and storage options.

### UML Class Diagram for Builder Design Pattern
![UML Class Diagram](UML-Class-Diagram-for-Builder-Design-Pattern)

### 1. Product (Computer)
```java
// Product
public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setRAM(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void displayInfo() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println();
    }
}
```

### 2. Builder
```java
// Builder interface
public interface Builder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    Computer getResult();
}
```

### 3. ConcreteBuilder
```java
// ConcreteBuilder
public class GamingComputerBuilder implements Builder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Gaming CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}
```

### 4. Director
```java
// Director
public class ComputerDirector {
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}
```

### 5. Client
```java
// Client
public class Main {
    public static void main(String[] args) {
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();

        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();

        gamingComputer.displayInfo();
    }
}
```

### Complete Combined Code for the Above Example
```java
public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setRAM(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void displayInfo() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println();
    }
}

public interface Builder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    Computer getResult();
}

public class GamingComputerBuilder implements Builder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Gaming CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

public class ComputerDirector {
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}

public class Main {
    public static void main(String[] args) {
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();

        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();

        gamingComputer.displayInfo();
    }
}
```

**Output:**
```
Computer Configuration:
CPU: Gaming CPU
RAM: 16GB DDR4
Storage: 1TB SSD
```

This code demonstrates the Builder design pattern where the `Computer` class is the product, `Builder` is the interface, `GamingComputerBuilder` is the concrete builder, `ComputerDirector` is the director, and the Client assembles the product using the builder and director.

## When to use Builder Design Pattern?
The Builder design pattern is used when you need to create complex objects with a large number of optional components or configuration parameters. This pattern is particularly useful in the following scenarios:

- **Complex Object Construction**: When an object has many optional components or configurations and you want to provide a clear separation between the construction process and the actual representation.
- **Step-by-Step Construction**: When the construction of an object involves a step-by-step process where different configurations or options need to be set at different stages.
- **Avoiding constructors with multiple parameters**: When the number of parameters in a constructor becomes too large, using telescoping constructors becomes unwieldy.
- **Immutable Objects**: When you want to create immutable objects, and the Builder pattern allows you to construct the object gradually before making it immutable.
- **Configurable Object Creation**: When you need to create objects with different configurations or variations, and you want a more flexible way to specify these configurations.
- **Common Interface for Multiple Representations**: When you want to provide a common interface for constructing different representations of an object.

## When not to use Builder Design Pattern?
While the Builder design pattern is beneficial, consider avoiding it in the following situations:

- **Simple Object Construction**: If the object has only a few simple parameters or configurations, using a builder might be overkill.
- **Performance Concerns**: In performance-critical applications, the overhead introduced by the Builder pattern might be a concern.
- **Immutable Objects with Final Fields**: If your language supports immutable objects with final fields and the structure is simple, constructors or static factory methods might be preferable.
- **Increased Code Complexity**: Introducing a builder class for every complex object can lead to increased code complexity if the object does not benefit significantly from step-by-step construction.
- **Tight Coupling with Product**: If the builder is tightly coupled with the product, changes to the product may require modifications to the builder, reducing flexibility and maintainability.
