## Overview of the key features introduced in Java 8

# Table of Contents

1. [Lambda Expressions (Functional Programming)](#1-lambda-expressions-functional-programming)
2. [Functional Interfaces](#2-functional-interfaces)
3. [Method References](#3-method-references)
4. [Streams API](#4-streams-api)
5. [Optional Class](#5-optional-class)
6. [New Date and Time API (java.time)](#6-new-date-and-time-api-javatime)
7. [Nashorn JavaScript Engine](#7-nashorn-javascript-engine)
8. [Streams and Parallel Streams](#8-streams-and-parallel-streams)
9. [Collectors Class](#9-collectors-class)
10. [Type Annotations](#10-type-annotations)
11. [Improved Type Inference](#11-improved-type-inference)
12. [Marker Interface](#marker-interface)
13. [Metadata](#metadata)


## 1 **Object-Oriented Programming (OOP) Concepts in Depth**

Object-Oriented Programming (OOP) is a programming paradigm that is based on the concept of **objects**, which are instances of **classes** which can contain data and methods. Java is a fully object-oriented language, and its OOP principles facilitate modular and reusable code.  The four main pillars of OOP — **Encapsulation**, **Abstraction**, **Inheritance**, and **Polymorphism** — are foundational principles that guide the design and development of object-oriented software systems. Below is a deep dive into each of these principles:

---

### 1.1 Classes and Objects

- **Class**: A blueprint for creating objects. It defines properties (attributes) and behaviors (methods). For example:

    ```java
    public class Car {
        String color;
        String model;

        void drive() {
            System.out.println("The car is driving.");
        }
    }
    ```

---

- **Object**: An instance of a class. It represents a specific entity with state and behavior.

    ```java
    public class Main {
        public static void main(String[] args) {
            Car myCar = new Car(); // Creating an object of Car
            myCar.color = "Red";
            myCar.model = "Toyota";
            myCar.drive(); // Calling a method
        }
    }
    ```
---

### 1.2 Encapsulation

**Encapsulation** is the concept of **bundling the data (attributes)** and **methods (functions)** that operate on the data into a single unit, called a **class**. It also refers to restricting access to some of the object's components to protect the integrity of the object.

#### Key Aspects of Encapsulation:
- **Private Data**: The internal state of an object (its fields or attributes) is kept private and can only be accessed or modified through public methods (getters and setters).
- **Access Control**: Using access modifiers (`private`, `public`, `protected`), we can control access to the data and methods in a class.
- **Getter/Setter Methods**: Public methods are provided to retrieve (`get`) or modify (`set`) the values of private fields.

#### Example of Encapsulation in Java:
```java
public class Account {
    // Private fields (data)
    private double balance;

    // Constructor to initialize the Account object
    public Account(double balance) {
        this.balance = balance;
    }

    // Getter method to access the balance
    public double getBalance() {
        return balance;
    }

    // Setter method to modify the balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }
}
```

**Benefits of Encapsulation**:
- **Data Hiding**: It protects the object's internal state from unauthorized access.
- **Flexibility**: You can change the implementation of methods or attributes without affecting the external code that uses the class.
- **Code Maintainability**: Centralizes the logic for accessing or modifying an object’s data, making maintenance easier.


Encapsulation is the principle of bundling data (attributes) and methods that operate on the data within a single unit (class) and restricting access to some of the object's components. This is typically achieved using access modifiers:

- **Private**: Accessible only within the class.
- **Public**: Accessible from any other class.
- **Protected**: Accessible within the same package and subclasses.
- **Default**: Accessible only within the same package.

#### Example:

```java
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

---

### 1.3 Abstraction

**Abstraction** is the concept of **hiding the complexity** of the system and exposing only the necessary parts. It allows a programmer to focus on high-level functionality while hiding the implementation details.

#### Key Aspects of Abstraction:
- **Abstract Classes**: A class that cannot be instantiated on its own, but can be subclassed. It can contain abstract methods (without implementation) and concrete methods (with implementation).
- **Interfaces**: An interface is a contract that defines a set of abstract methods, which any implementing class must define. It allows for a form of abstraction by decoupling the interface (what an object can do) from its implementation (how it does it).

#### Example of Abstraction using an Abstract Class:
```java
abstract class Animal {
    // Abstract method (no implementation)
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println("The animal is sleeping.");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```

#### Example of Abstraction using an Interface:
```java
interface Shape {
    // Abstract method (no implementation)
    double area();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
```

**Benefits of Abstraction**:
- **Simplifies Complexity**: Allows the user to interact with high-level functionalities and ignore implementation details.
- **Separation of Concerns**: Separates the **what** from the **how**, ensuring that changes in implementation don’t affect the interface.
- **Improved Flexibility**: You can change the implementation of an abstract class or interface without affecting the system as long as the interface remains unchanged.

Abstraction is the concept of hiding complex implementation details and showing only the essential features of an object. This can be achieved using abstract classes and interfaces.

- **Abstract Class**: A class that cannot be instantiated and may contain abstract methods (methods without a body) and concrete methods.

    ```java
    abstract class Shape {
        abstract void draw(); // Abstract method
    }

    class Circle extends Shape {
        void draw() {
            System.out.println("Drawing a circle.");
        }
    }
    ```

- **Interface**: A reference type that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot contain instance fields.

    ```java
    interface Drawable {
        void draw(); // Abstract method
    }

    class Rectangle implements Drawable {
        public void draw() {
            System.out.println("Drawing a rectangle.");
        }
    }
    ```
---

### 1.4 Inheritance

**Inheritance** is the mechanism by which one class can **inherit properties and methods** from another class. This promotes **code reusability** and allows for hierarchical class relationships. A subclass (or child class) inherits from a superclass (or parent class), and can:
- Reuse code from the superclass.
- Override methods of the superclass to provide specialized behavior.
- Extend the functionality of the superclass by adding new methods or properties.

#### Key Aspects of Inheritance:
- **Single Inheritance**: A class can inherit from only one class (in Java).
- **Method Overriding**: A subclass can provide its own implementation of a method that is already defined in the superclass.
- **`super` keyword**: Used to call a superclass’s method or constructor from a subclass.

#### Example of Inheritance:
```java
class Animal {
    public void eat() {
        System.out.println("This animal is eating.");
    }
}

class Dog extends Animal {
    // Method overriding
    @Override
    public void eat() {
        System.out.println("This dog is eating.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();  // Output: This animal is eating.

        Dog dog = new Dog();
        dog.eat();  // Output: This dog is eating.
    }
}
```

**Benefits of Inheritance**:
- **Code Reusability**: Subclasses can reuse code from the superclass.
- **Extensibility**: You can easily extend existing code by creating new subclasses.
- **Hierarchy**: Inheritance establishes a natural hierarchy and relationship between classes (e.g., `Dog` is a type of `Animal`).


Inheritance is a mechanism that allows one class to inherit the properties and methods of another class. This promotes code reuse and establishes a hierarchy between classes.

- **Superclass (Parent class)**: The class whose properties and methods are inherited.
- **Subclass (Child class)**: The class that inherits from the superclass.

#### Example:

```java
public class Vehicle {
    void start() {
        System.out.println("Vehicle started.");
    }
}

public class Car extends Vehicle {
    void honk() {
        System.out.println("Car honks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start(); // Inherited method
        myCar.honk();  // Car's own method
    }
}
```
---

### 1.5 Polymorphism

**Polymorphism** means **many forms**, and it allows objects of different classes to be treated as objects of a common superclass. It is the ability for a method to perform different operations based on the object it is acting upon. Polymorphism is typically achieved via:
- **Method Overloading**: Same method name but different parameter types (compile-time polymorphism).
- **Method Overriding**: Same method name and parameters, but different implementations in the subclass (runtime polymorphism).

#### Key Aspects of Polymorphism:
- **Dynamic Method Dispatch (Runtime Polymorphism)**: In Java, polymorphism is commonly used via method overriding. The method that gets called is determined at runtime based on the object's actual type, not the reference type.
- **Compile-Time Polymorphism (Method Overloading)**: The method to call is determined at compile time based on method signatures.

#### Example of Polymorphism (Method Overriding):
```java
class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.sound();  // Output: Woof!

        Animal animal2 = new Cat();
        animal2.sound();  // Output: Meow!
    }
}
```

**Benefits of Polymorphism**:
- **Flexibility and Extensibility**: You can extend or modify the behavior of a class without altering its interface.
- **Code Simplification**: Polymorphism simplifies code by allowing one interface to be used for different implementations. This reduces the need for complex conditional statements (e.g., `if`-`else` chains).
- **Maintainability**: As the number of classes and behavior grow, polymorphism allows the system to remain flexible and easily maintainable.

Polymorphism allows methods to do different things based on the object that it is acting upon. It is mainly achieved through method overloading and method overriding.

- **Method Overloading**: Same method name with different parameters within the same class.

    ```java
    public class MathOperations {
        int add(int a, int b) {
            return a + b;
        }

        double add(double a, double b) {
            return a + b;
        }
    }
    ```

- **Method Overriding**: Subclass provides a specific implementation of a method already defined in its superclass.

    ```java
    public class Animal {
        void sound() {
            System.out.println("Animal makes a sound.");
        }
    }

    public class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks.");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Animal myDog = new Dog();
            myDog.sound(); // Output: Dog barks.
        }
    }
    ```

     
### 1.5.1 What is Polymorphism?

**Polymorphism** is a fundamental concept in object-oriented programming (OOP) that allows methods to do different things based on the object it is acting upon, even if they share the same name. It enables one interface to be used for a general class of actions. The specific action is determined by the exact nature of the situation, allowing for flexibility and the ability to extend functionality.

#### Types of Polymorphism

1. **Compile-time Polymorphism (Static Binding)**: Achieved through method overloading and operator overloading.
   - **Method Overloading**: Same method name with different parameters (type or number).
   
   ```java
   public class MathUtils {
       public int add(int a, int b) {
           return a + b;
       }

       public double add(double a, double b) {
           return a + b;
       }
   }
   ```

2. **Runtime Polymorphism (Dynamic Binding)**: Achieved through method overriding, where a subclass provides a specific implementation of a method that is already defined in its superclass.
   - **Method Overriding**: Same method signature but in a derived class.
   
   ```java
   class Animal {
       void sound() {
           System.out.println("Animal makes a sound");
       }
   }

   class Dog extends Animal {
       void sound() {
           System.out.println("Woof");
       }
   }

   class Cat extends Animal {
       void sound() {
           System.out.println("Meow");
       }
   }
   ```

### Interview Questions Related to Polymorphism

1. **Basic Questions**
   - **What is polymorphism? Explain with examples.**
   - **What are the differences between compile-time and runtime polymorphism?**
   - **Can you override a private method in Java? Why or why not?**

2. **Code-Based Questions**
   - **Write a code snippet demonstrating method overloading.**
   - **Write a code snippet demonstrating method overriding.**

3. **Advanced Questions**
   - **What will happen if you override a method in a subclass and change the return type?**
   - **Explain the concept of covariant return types in Java.**
   - **How does polymorphism contribute to code maintainability and flexibility?**

### Trick Questions

1. **What is the output of the following code?**
   ```java
   class Base {
       void show() {
           System.out.println("Base");
       }
   }

   class Derived extends Base {
       void show() {
           System.out.println("Derived");
       }

       void display() {
           show();
       }
   }

   public class Test {
       public static void main(String[] args) {
           Base obj = new Derived();
           obj.show();
       }
   }
   ```
   - **Answer**: The output will be `Derived`. This illustrates runtime polymorphism where the method call is resolved at runtime based on the object type, not the reference type.

2. **Can you use polymorphism with primitive data types? Why or why not?**
   - **Answer**: No, polymorphism applies to objects and their methods. Primitive types in Java do not support polymorphism since they are not objects and do not have methods.

3. **Can you achieve polymorphism with static methods? Explain your answer.**
   - **Answer**: No, static methods are bound at compile time, so they do not exhibit polymorphic behavior. They belong to the class rather than instances of the class.

### Conclusion

Understanding polymorphism is crucial for writing flexible and maintainable object-oriented code. Being able to explain the concept clearly and answer related questions, including tricky ones, can demonstrate your depth of knowledge during an interview. Practice explaining these concepts and writing sample code to prepare effectively!

### Conclusion

Polymorphism in Java allows you to define a common interface for multiple implementations, enabling flexibility and scalability. By leveraging Spring’s dependency injection and configuration features, you can effectively achieve polymorphism in your applications. 

Key steps include:

1. **Defining interfaces** for common behaviors.
2. **Implementing those interfaces** in various classes.
3. **Injecting the appropriate implementation** into your services using dependency injection, `@Qualifier`, or factory patterns.

This approach enhances code reusability and maintainability, making your application more modular and easier to test.

Sure! Here are detailed answers to the questions related to polymorphism in Java.

### Basic Questions

**1. What is polymorphism? Explain with examples.**

**Polymorphism** is a core concept in object-oriented programming (OOP) that allows objects to be treated as instances of their parent class or interface. It enables methods to perform different tasks based on the object that invokes them.

**Example:**
```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}

public class TestPolymorphism {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.sound(); // Outputs: Woof
        myCat.sound(); // Outputs: Meow
    }
}
```

---

**2. What are the differences between compile-time and runtime polymorphism?**

- **Compile-Time Polymorphism (Static Binding):**
  - Achieved through method overloading and operator overloading.
  - Resolved during compilation.
  - Example: Multiple methods with the same name but different parameter types or numbers.

- **Runtime Polymorphism (Dynamic Binding):**
  - Achieved through method overriding.
  - Resolved during runtime based on the object type.
  - Example: A parent class reference pointing to a child class object and invoking overridden methods.

---

**3. Can you override a private method in Java? Why or why not?**

No, you cannot override a private method in Java. Private methods are not accessible outside their own class, so subclasses do not inherit them. Consequently, even if you define a method with the same name in a subclass, it does not override the private method but instead creates a new method.

---

### Code-Based Questions

**4. Write a code snippet demonstrating method overloading.**

```java
class MathUtils {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }
}

public class OverloadingExample {
    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        System.out.println(math.add(2, 3));         // Outputs: 5
        System.out.println(math.add(2, 3, 4));      // Outputs: 9
        System.out.println(math.add(2.5, 3.5));     // Outputs: 6.0
    }
}
```

---

**5. Write a code snippet demonstrating method overriding.**

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car is starting");
    }
}

public class OverridingExample {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start(); // Outputs: Car is starting
    }
}
```

---

### Advanced Questions

**6. What will happen if you override a method in a subclass and change the return type?**

You can change the return type of an overridden method as long as the new return type is a subclass of the original return type (this is known as **covariant return types**). If the return type does not adhere to this rule, it will lead to a compile-time error.

**Example:**
```java
class Animal {
    Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    Dog getAnimal() { // Covariant return type
        return new Dog();
    }
}
```

---

**7. Explain the concept of covariant return types in Java.**

**Covariant return types** allow a subclass to override a method from its superclass and return a type that is a subclass of the original return type. This enhances the flexibility of the polymorphic behavior, enabling a more specific type to be returned in derived classes.

---

**8. How does polymorphism contribute to code maintainability and flexibility?**

Polymorphism enhances code maintainability and flexibility in several ways:

- **Decoupling**: By relying on interfaces or abstract classes, you can write code that interacts with objects without needing to know their concrete types. This decouples the code, making it easier to maintain.

- **Code Reusability**: Different implementations can be used interchangeably without changing the code that uses them, promoting code reuse.

- **Easier to Extend**: New implementations can be added with minimal changes to existing code. For example, adding a new type of `Animal` only requires creating a new class without modifying the existing logic.

- **Simplified Testing**: Testing becomes easier since you can mock or stub different implementations when writing unit tests.

By leveraging polymorphism, developers can create more robust and flexible applications that are easier to understand, extend, and maintain.

**[⬆ Back to Top](#table-of-contents)**

---
---

### **Other OOP Concepts in Java**

In addition to the main four pillars (Encapsulation, Abstraction, Inheritance, Polymorphism), OOP also involves several additional concepts and techniques:

### **Composition, Aggregation, and Association in Java**

In object-oriented programming, relationships between objects are an important concept. Three fundamental types of relationships in OOP are **Composition**, **Aggregation**, and **Association**. These relationships represent how objects interact or are related to one another in a system. Below, I’ll explain each of these relationships in depth, with examples and when to use them.

### 1.6 Composition (Has-A Relationship)

Composition is a design principle that allows for building complex objects by combining simpler ones. It is a **has-a** relationship where one object is a part of another.

```java
class Engine {
    public void start() {
        System.out.println("Engine starting");
    }
}

class Car {
    private Engine engine; // Car has an Engine

    public Car() {
        engine = new Engine();
    }

    public void start() {
        engine.start();  // Delegating the start operation to Engine
        System.out.println("Car started");
    }
}
```

**Benefits of Composition**:
- It offers more flexibility and a **loose coupling** between classes than inheritance.
- You can easily change the parts (components) of an object without modifying the entire object.

**Composition** is a type of association where one object **"owns"** or **"contains"** another object, and the contained object cannot exist independently without the parent object. It is also known as a **strong relationship** because if the parent object is destroyed, its contained objects are also destroyed.

In composition:
- The lifetime of the contained object is dependent on the parent object.
- It represents a **strong "Has-A"** relationship (i.e., "A House has Rooms").
- If the parent object is deleted, the contained object is deleted too.

#### **When to Use Composition**
- Use composition when you want to establish a **strong lifecycle dependency** between objects, where one object is a part of another.
- Common in real-world systems, like a **Car has an Engine** or a **Library has Books**.

#### **Example: Composition in Java**

```java
class Engine {
    private String engineType;

    public Engine(String engineType) {
        this.engineType = engineType;
    }

    public void start() {
        System.out.println("Engine starting...");
    }
}

class Car {
    private Engine engine;  // Car "has-a" Engine (Composition)

    public Car(String engineType) {
        engine = new Engine(engineType); // Car owns the Engine, hence it is created when Car is created
    }

    public void startCar() {
        engine.start();
        System.out.println("Car is ready to go.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("V8");
        myCar.startCar();  // Engine is created with the Car object and will be destroyed when Car is destroyed.
    }
}
```

**Explanation**:
- The `Car` class contains an `Engine` object, meaning that an engine cannot exist independently without a car.
- The engine is created when the car object is created, and the engine is destroyed when the car is destroyed (i.e., the engine's lifecycle is tied to the car).

**[⬆ Back to Top](#table-of-contents)**

---

### 1.7 Association

Association represents the relationship between two or more objects. There are different types of associations:
- **One-to-One**: One object is associated with exactly one object.
- **One-to-Many**: One object is associated with multiple objects.
- **Many-to-Many**: Multiple objects are associated with multiple objects.

**Association** is the **most general** relationship between objects. In association, two or more objects are connected, but neither object **owns** or **depends** on the other. This is the weakest form of relationship, meaning that both objects can exist independently of each other.

In association:
- Objects are related but have no strict lifecycle dependency.
- The relationship can be **bi-directional** (e.g., "A Teacher teaches a Student", where both Teacher and Student exist independently).

#### **When to Use Association**
- Use association when objects **interact** with each other, but there is **no ownership** or **dependency**.
- Common in scenarios like **A Teacher teaches a Student**, **A Car is driven by a Driver**.

#### **Example: Association in Java**

```java
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void study() {
        System.out.println(name + " is studying.");
    }
}

class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void teach() {
        System.out.println(name + " is teaching.");
    }

    public void teachStudent(Student student) {
        System.out.println(name + " is teaching " + student.name);
        student.study();  // Interaction between Teacher and Student
    }
}

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. John");
        Student student = new Student("Alice");

        teacher.teachStudent(student);  // Teacher and Student interact, but neither owns the other
    }
}
```

**Explanation**:
- The `Teacher` and `Student` objects are **associated** because they interact with each other (the teacher teaches the student), but neither object **owns** the other.
- Both objects can exist independently, and the teacher could teach multiple students, or the student could study with other teachers.

**[⬆ Back to Top](#table-of-contents)**

---

### 1.8 Aggregation

Aggregation is a special form of association that represents a "whole-part" relationship, where the "part" can exist independently of the "whole." It's a **Has-A** relationship with a more loosely-coupled structure than composition.

**Aggregation** is a **special form of Association** where one object **contains** or **references** another object, but the contained object can exist independently of the parent object. This is a **looser** relationship compared to composition.

In aggregation:
- The lifetime of the contained object does **not depend** on the parent object. It can exist on its own and may be shared across other objects.
- It represents a **"Has-A"** relationship, but with **independence** for the contained objects (e.g., "A University has Professors" but professors can exist independently of the university).

#### **When to Use Aggregation**
- Use aggregation when the contained objects have an **independent existence** and are **shared** among multiple parent objects.
- Common in cases like **A Department has Employees**, **A University has Professors** (Professors can be in multiple Universities).

#### **Example: Aggregation in Java**

```java
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public void teach() {
        System.out.println(name + " is teaching.");
    }
}

class University {
    private String universityName;
    private List<Professor> professors;  // University "has-a" Professors (Aggregation)

    public University(String universityName) {
        this.universityName = universityName;
        this.professors = new ArrayList<>();
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void showProfessors() {
        for (Professor professor : professors) {
            professor.teach();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Brown");

        University university = new University("Tech University");
        university.addProfessor(prof1);
        university.addProfessor(prof2);

        university.showProfessors();
    }
}
```

**Explanation**:
- In the `University` class, the professors can exist independently and can be added to multiple universities.
- If a university is destroyed, the professors are not destroyed — they can still exist independently of any university.

**[⬆ Back to Top](#table-of-contents)**

---

### Summary of OOP Concepts

- **Classes and Objects**: The foundation of OOP, where classes are blueprints for objects.
- **Encapsulation**: Bundles data and methods, restricting access to internal states.
- **Inheritance**: Enables classes to inherit properties and behaviors from other classes.
- **Polymorphism**: Allows methods to perform different functions based on the object context.
- **Abstraction**: Hides complex implementations and exposes only essential features.

These principles enable developers to build modular, maintainable, and scalable applications in Java. Understanding these concepts is crucial for effective programming and design in an object-oriented language.

### **Summary of When to Use Each Relationship**

| **Relationship Type** | **Description** | **When to Use** | **Example** |
|-----------------------|-----------------|-----------------|-------------|
| **Composition (Has-A)** | A strong **"Has-A"** relationship where the child object **cannot exist independently** of the parent object. | Use when the child object is **part of** the parent object and its lifecycle is tied to the parent object. | A **Car has an Engine**. If the car is destroyed, so is the engine. |
| **Aggregation**        | A **looser Has-A** relationship where the child object **can exist independently**. | Use when the child object can exist independently and might be **shared** across multiple objects. | A **University has Professors**, but professors can exist without the university. |
| **Association**        | A **general relationship** where objects are related but have no strict lifecycle dependency. | Use when objects **interact**, but neither is **dependent** on the other. | A **Teacher teaches a Student**, but neither owns the other. |

In practice, the choice between **composition**, **aggregation**, and **association** depends on the **lifetime** and **ownership** of the objects involved, and how closely related they are in your design.

### **Conclusion**

Object-Oriented Programming (OOP) is a paradigm that helps in organizing software around the concept of **objects** and **classes**, making it more modular, maintainable, and reusable. Understanding the four pillars of OOP (Encapsulation, Abstraction, Inheritance, and Polymorphism) is essential for designing and building robust systems. By applying these principles, developers can create software that is easier to extend, debug, and maintain over time.

**[⬆ Back to Top](#table-of-contents)**
---

## **Process-Oriented Object-Oriented and Functional Programming in Java**

Java, being a versatile language, supports various programming paradigms, including **process-oriented**, **object-oriented**, and **functional programming**. Each of these paradigms has different characteristics and advantages, and understanding how they can be applied in Java can help you write cleaner, more maintainable, and efficient code. 

Let's break down each programming paradigm and how they are implemented in Java.

---

### **1. Process-Oriented Programming (POP)**

#### **Definition:**
Process-oriented programming, often known as **procedural programming**, focuses on **sequences of instructions** or procedures that operate on data. The core concept in POP is that the logic of the program is divided into functions or procedures that manipulate data.

#### **Characteristics:**
- **Functions/Procedures**: Functions (or methods) are used to perform operations.
- **Global State**: Typically, data is shared across the program and is manipulated directly by functions.
- **Sequence of Steps**: The program is written as a sequence of steps that are executed one after another.

#### **In Java:**
Java is fundamentally an **object-oriented language**, but you can still use process-oriented programming with **procedural code** inside classes, using methods to define operations.

**Example:**

```java
public class ProcessOrientedExample {

    // Procedure to add two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Procedure to subtract two numbers
    public static int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        int resultAdd = add(5, 3);   // Process (method) call
        int resultSubtract = subtract(5, 3); // Process (method) call

        System.out.println("Addition Result: " + resultAdd);
        System.out.println("Subtraction Result: " + resultSubtract);
    }
}
```

- In this example, the focus is on defining **procedures** (`add` and `subtract`) that are called to perform operations. The program's logic is not inherently tied to objects, just functions.

#### **Limitations of POP:**
- Difficult to manage large codebases because of scattered data and procedures.
- Lacks abstraction and reuse features compared to OOP or functional paradigms.

**[⬆ Back to Top](#table-of-contents)**

---

### **2. Object-Oriented Programming (OOP)**

#### **Definition:**
Object-oriented programming (OOP) is a paradigm based on **objects** and **classes**. The key idea is to group related data and behavior into objects, and interact with these objects to perform actions. In Java, everything is primarily **object-oriented**.

#### **Core Principles of OOP**:
1. **Encapsulation**: Data and methods are bundled into classes. Only the necessary details are exposed to the outside world.
2. **Abstraction**: Hiding complex implementation details and exposing only essential features.
3. **Inheritance**: A class can inherit methods and fields from another class, enabling code reuse.
4. **Polymorphism**: The ability of a single function to operate on different types, or the ability to redefine a function in derived classes.

#### **In Java:**
Java is a fully object-oriented language, and OOP is the default paradigm. Most Java applications are designed using classes and objects.

**Example:**

```java
// A class defining a Car
class Car {
    // Fields
    private String model;
    private int year;

    // Constructor to initialize the Car object
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Model: " + model);
        System.out.println("Manufacturing Year: " + year);
    }

    // Method to start the car
    public void start() {
        System.out.println("The car has started.");
    }
}

public class OOPExample {

    public static void main(String[] args) {
        // Create an instance of the Car class (object)
        Car myCar = new Car("Tesla Model 3", 2022);
        
        // Call methods on the object
        myCar.displayDetails();
        myCar.start();
    }
}
```

In the example:
- The `Car` class defines a **blueprint** for creating car objects with attributes (`model`, `year`) and behaviors (`displayDetails()`, `start()`).
- The program uses the **object** (`myCar`) to interact with the car’s properties and methods.

#### **Advantages of OOP:**
- **Reusability**: Inheritance and polymorphism allow code to be reused and extended.
- **Maintainability**: Objects encapsulate related data and behavior, making code easier to manage.
- **Scalability**: OOP enables modeling of complex real-world entities, making it more suitable for large applications.

**[⬆ Back to Top](#table-of-contents)**

---

### **3. Functional Programming (FP)**

#### **Definition:**
Functional programming (FP) is a paradigm that treats computation as the evaluation of **mathematical functions** and avoids changing state or mutable data. FP emphasizes **immutable data**, **higher-order functions**, and **first-class functions**.

#### **Core Concepts of FP**:
1. **Immutability**: Data cannot be modified after it is created.
2. **Pure Functions**: Functions that return the same output for the same input and have no side effects.
3. **First-Class Functions**: Functions are treated as first-class citizens, meaning they can be assigned to variables, passed as arguments, and returned as values.
4. **Higher-Order Functions**: Functions that take other functions as arguments or return them as results.
5. **Declarative Code**: Focuses on describing what to do, rather than how to do it.

#### **In Java:**
Although Java is primarily object-oriented, starting from **Java 8**, it has incorporated many functional programming features, such as **lambda expressions**, **streams**, and **optional**. These features allow developers to write code in a functional style.

**Example:**

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {

    public static void main(String[] args) {
        // A list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Using functional programming with streams to filter and transform the list
        List<Integer> squaredEvens = numbers.stream()  // Convert list to stream
            .filter(n -> n % 2 == 0)                   // Keep even numbers
            .map(n -> n * n)                           // Square the numbers
            .collect(Collectors.toList());             // Collect the results into a list

        // Print the result
        System.out.println(squaredEvens);  // Output: [4, 16, 36]
    }
}
```

In this example:
- We use **streams** to transform and filter a list of numbers.
- The operation is **declarative** and focuses on what we want to do (filter and square) instead of how we do it.
- The data is **immutable**, and functions like `filter()` and `map()` return new modified streams instead of modifying the original list.

#### **Advantages of FP:**
- **Immutability**: Reduces side effects and makes programs easier to reason about.
- **Concurrency**: Because of immutability and lack of shared mutable state, functional programs are naturally easier to parallelize.
- **Modularity**: Higher-order functions and function composition make it easier to build and combine small reusable functions.

**[⬆ Back to Top](#table-of-contents)**

---

### **Comparison of Process-Oriented, OOP, and FP in Java**

| **Feature**                | **Process-Oriented Programming**  | **Object-Oriented Programming (OOP)**      | **Functional Programming (FP)**           |
|----------------------------|-----------------------------------|--------------------------------------------|-------------------------------------------|
| **Primary Focus**           | A sequence of procedures or tasks | Organizing code into classes and objects  | Treating computation as functions        |
| **State Handling**          | Global state, mutable data        | State is encapsulated within objects      | Immutable data, no side effects          |
| **Functions**               | Independent functions/procedures  | Methods tied to objects (encapsulation)   | First-class functions, higher-order      |
| **Data Management**         | Data is shared globally           | Data is private within objects            | Data is passed through functions (immutable) |
| **Concurrency Support**     | Difficult to parallelize          | Some concurrency support via threads      | Naturally more concurrent (due to immutability) |
| **Example Use Cases**       | Small, straightforward programs   | Complex applications with interrelated data | Complex data processing, transformations, and analytics |
| **Example Java Features**   | Methods in classes, procedural code | Classes, objects, inheritance, polymorphism | Lambdas, streams, `Optional`, `Map`, `Reduce` |

---

### **Conclusion:**
- **Process-Oriented Programming** in Java focuses on functions and procedures that perform tasks sequentially. It's simple but not ideal for complex systems.
- **Object-Oriented Programming (OOP)** is the main paradigm in Java and emphasizes organizing code around objects, which promotes modularity, reusability, and abstraction.
- **Functional Programming (FP)** in Java (introduced in Java 8) emphasizes immutability, stateless functions, and declarative code, offering benefits for writing clean, concise, and concurrent code.

By understanding these paradigms, Java developers can choose the appropriate approach depending on the problem at hand and mix them as necessary for building scalable and maintainable applications.

**[⬆ Back to Top](#table-of-contents)**

---
In Java, **access specifiers** and **non-access modifiers** are keywords used to define the visibility, accessibility, and behavior of classes, methods, variables, and constructors. Understanding how these work is essential for designing robust and maintainable applications. Below, I’ll provide a detailed overview of both access specifiers and non-access modifiers, along with examples.

### **Why Do We Need Functional Programming (FP)?**

Functional programming (FP) has gained significant traction in recent years, especially in languages like Java (since Java 8), JavaScript, Python, Scala, Haskell, and others. While object-oriented programming (OOP) remains dominant, there are several compelling reasons why you might want to use **functional programming** in your projects. Below are the key reasons **why FP is needed**:

### Why Use Functional Style Instead of OOP?

Functional programming (FP) and Object-Oriented Programming (OOP) are two distinct paradigms, each with its strengths. Here are reasons why functional style can be preferred:

1. **Simplicity and Clarity**: Functional programming focuses on pure functions and immutability, which can lead to simpler and more predictable code. Functions that don’t have side effects make it easier to understand program flow.

2. **Higher-Order Functions**: FP allows functions to be passed as parameters, returned from other functions, or stored in data structures, enabling powerful abstractions and code reuse.

3. **Conciseness**: Functional programming constructs like lambda expressions and streams can result in less boilerplate code. This can make code cleaner and easier to read.

4. **Parallelism**: FP constructs often lend themselves to parallel execution more naturally. For example, stream operations can be easily parallelized without changing the logic.

5. **Ease of Testing**: Pure functions (functions without side effects) are easier to test and reason about compared to methods in OOP that might rely on shared mutable state.

**[⬆ Back to Top](#table-of-contents)**

---

### 1. [Lambda Expressions (Functional Programming)](#lambda-expressions-functional-programming)

Lambda expressions in Java 8 provide a clear and concise way to express instances of **functional interfaces** (interfaces with a single abstract method). They enable you to write more compact, functional-style code by allowing behavior to be passed as an argument to methods or stored in variables. Essentially, lambda expressions are **anonymous functions** that can have parameters, a body, a return type, and throw exceptions, but they do not have names or belong to any specific class. This makes lambda expressions a powerful tool for implementing functional programming constructs in Java, simplifying code and promoting higher-order functions.

A **Lambda Expressions** is a short way to express a function in java. It allows us to write function inline and pass it as an argument to another function as well.

**Lambda Expressions**: The Expression through which we can represnt an Anonymous Function.

* Anonymous: Nameless/Unknown
* Anonymous Function: A method who dont have any name or identifier


### Syntax of Lambda Expression:
The basic syntax of a lambda expression is:

```java
(parameters) -> expression
```

- **parameters**: The input parameters to the lambda function. If there is one parameter, you can omit the parentheses. If there are no parameters, use empty parentheses.
- **arrow (`->`)**: It separates the parameters and the body of the lambda expression.
- **expression**: The logic or behavior the lambda expression implements.

### Example of a Lambda Expression in Java:

1. **Simple Lambda Expression**
   ```java
   // Traditional way (Anonymous class)
   Runnable r1 = new Runnable() {
       @Override
       public void run() {
           System.out.println("Hello from Runnable!");
       }
   };

   // Using Lambda Expression
   Runnable r2 = () -> System.out.println("Hello from Runnable!");
   ```

   In this case, the lambda expression `() -> System.out.println("Hello from Runnable!")` represents a `Runnable` with no parameters and a single statement.

   Lambda expressions allow you to pass behavior as a parameter to methods, making the code more flexible and readable.

2. **Lambda Expression with Parameters**
   A more common example would be with functional interfaces that take parameters, like `Predicate`, `Function`, etc.

   ```java
   // Function interface example (accepts one parameter and returns a value)
   Function<Integer, Integer> square = (x) -> x * x;

   System.out.println(square.apply(4)); // Output: 16
   ```

3. **Lambda Expression with Multiple Parameters**
   You can pass multiple parameters to a lambda expression as well:

   ```java
   // Adding two integers
   BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

   System.out.println(add.apply(5, 3)); // Output: 8
   ```

4. **Using Lambda Expressions in Collections (Streams API)**
   Lambda expressions are particularly powerful when working with collections, especially with the new **Streams API** introduced in Java 8.

   ```java
   // Filtering even numbers from a list
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
   numbers.stream()
          .filter(n -> n % 2 == 0)
          .forEach(n -> System.out.println(n));
   ```

### Key Points to Remember:
- **Functional Interface**: Lambda expressions in Java work with functional interfaces (interfaces with a single abstract method). Examples include `Runnable`, `Comparator`, `Function`, `Predicate`, etc.
- **Type Inference**: The compiler can infer the type of parameters in lambda expressions. So, you don't always need to explicitly define the type (as long as the target type is clear).
  
   ```java
   // Type inference example
   Consumer<String> print = s -> System.out.println(s);
   ```

- **No `this` reference in lambda**: The `this` keyword in a lambda refers to the enclosing class, not the lambda expression itself. If you want to refer to the instance of the lambda expression, you can use the `LambdaClassName.this` syntax.

### Example of Functional Interfaces:

1. **Predicate (Functional Interface)**

   A `Predicate` takes one parameter and returns a boolean value.

   ```java
   Predicate<Integer> isEven = (n) -> n % 2 == 0;
   System.out.println(isEven.test(4)); // Output: true
   ```

2. **Consumer (Functional Interface)**

   A `Consumer` takes one parameter and does not return a value.

   ```java
   Consumer<String> printMessage = message -> System.out.println(message);
   printMessage.accept("Lambda Expression in Java 8");
   ```

3. **Supplier (Functional Interface)**

   A `Supplier` takes no parameters and returns a value.

   ```java
   Supplier<String> getMessage = () -> "Hello, Java 8!";
   System.out.println(getMessage.get());
   ```

### Benefits of Lambda Expressions:
1. **Concise and Readable Code**: Lambda expressions allow you to write more concise and readable code, reducing the need for boilerplate code such as anonymous inner classes.
2. **Functional Programming**: Lambda expressions are a key part of functional programming in Java, enabling you to pass behavior as arguments and return values from methods more naturally.
3. **Parallel Processing**: Lambdas, combined with streams, make it easier to perform operations like filtering, mapping, and reducing data in parallel.

### Conclusion:

Lambda expressions in Java 8 make code more concise and readable, particularly in functional-style programming. They are particularly useful when working with collections, handling concurrency, or dealing with APIs that expect functional interfaces.

[More About Lambda](conceptsIII/java-basic-fundamental-lambda-expressions.md)

---
### 2. [Functional Interfaces](#functional-interfaces)

A **functional interface** is an interface with a single abstract method. It can have multiple default and static methods, but it must have one and only one abstract method.

- **Purpose**: Functional interfaces can be used as the target types for lambda expressions and method references.


In Java, a **functional interface** is an interface that has exactly one abstract method (method without a body). Functional interfaces are intended to be used primarily with lambda expressions, method references, and other functional-style constructs introduced in Java 8. These interfaces enable you to pass behavior as arguments to methods and support functional programming paradigms in Java.

### Key Characteristics of a Functional Interface:
1. **Single Abstract Method (SAM)**: A functional interface must have exactly one abstract method.
2. **Can have multiple default or static methods**: In addition to the single abstract method, a functional interface can have any number of **default** or **static** methods. These methods provide default behavior and do not affect the interface's functional status.
3. **Can be annotated with `@FunctionalInterface` (optional)**: The `@FunctionalInterface` annotation is not required, but it helps to explicitly declare that an interface is intended to be a functional interface. If you annotate a non-functional interface with `@FunctionalInterface`, the compiler will generate an error.

### Example of a Functional Interface:
Here's a simple example of a functional interface:

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void myMethod();  // Single abstract method

    // Default method (can be present, but doesn't interfere with SAM)
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }

    // Static method (can also be present)
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}
```

In the example above, `MyFunctionalInterface` has only **one abstract method** (`myMethod()`), which makes it a valid functional interface. It also has a default method (`defaultMethod()`) and a static method (`staticMethod()`), both of which are allowed in a functional interface.

### Using Functional Interfaces with Lambda Expressions:

A functional interface is often used with lambda expressions, which provide a concise way to implement its abstract method.

Example of using the functional interface `MyFunctionalInterface`:

```java
public class Main {
    public static void main(String[] args) {
        // Using lambda expression to implement the functional interface
        MyFunctionalInterface myFunc = () -> System.out.println("Hello from myMethod!");
        
        // Calling the method of the functional interface
        myFunc.myMethod();  // Output: Hello from myMethod!
        
        // Calling the default method
        myFunc.defaultMethod();  // Output: This is a default method.
        
        // Calling the static method
        MyFunctionalInterface.staticMethod();  // Output: This is a static method.
    }
}
```

In this example:
- We use a **lambda expression** (`() -> System.out.println("Hello from myMethod!")`) to provide an implementation for the abstract method `myMethod()` of `MyFunctionalInterface`.
- We also demonstrate calling a **default method** and **static method**, which are allowed in functional interfaces.

### Built-in Functional Interfaces in Java:

Java 8 introduced several built-in functional interfaces in the `java.util.function` package. These interfaces can be used with lambda expressions or method references. Here are some commonly used functional interfaces:

Common built-in functional interfaces in Java 8:
- **`Predicate<T>`**: Represents a boolean-valued function.
- **`Function<T, R>`**: Takes one argument and returns a result.
- **`Consumer<T>`**: Takes an argument and performs an action.
- **`Supplier<T>`**: Takes no argument and provides a result.
- **`BiFunction<T, U, R>`**: Takes two arguments and returns a result.
- 
1. **`Predicate<T>`**: Represents a boolean-valued function (test condition).
   ```java
   Predicate<Integer> isEven = (n) -> n % 2 == 0;
   System.out.println(isEven.test(4));  // Output: true
   ```

2. **`Function<T, R>`**: Represents a function that takes an argument of type `T` and returns a result of type `R`.
   ```java
   Function<Integer, String> toString = (n) -> "Number: " + n;
   System.out.println(toString.apply(5));  // Output: Number: 5
   ```

3. **`Consumer<T>`**: Represents an operation that accepts a single input argument and returns no result.
   ```java
   Consumer<String> printMessage = (message) -> System.out.println(message);
   printMessage.accept("Hello from Consumer!");  // Output: Hello from Consumer!
   ```

4. **`Supplier<T>`**: Represents a supplier of results, taking no arguments and returning a result.
   ```java
   Supplier<String> supplyMessage = () -> "Hello from Supplier!";
   System.out.println(supplyMessage.get());  // Output: Hello from Supplier!
   ```

5. **`BiFunction<T, U, R>`**: Represents a function that takes two arguments (`T` and `U`) and returns a result (`R`).
   ```java
   BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
   System.out.println(add.apply(3, 4));  // Output: 7
   ```

6. **`UnaryOperator<T>`**: A special case of `Function` where the input and output are of the same type.
   ```java
   UnaryOperator<Integer> square = (n) -> n * n;
   System.out.println(square.apply(5));  // Output: 25
   ```

7. **`BinaryOperator<T>`**: A special case of `BiFunction` where the two arguments and the result are of the same type.
   ```java
   BinaryOperator<Integer> addNumbers = (a, b) -> a + b;
   System.out.println(addNumbers.apply(5, 3));  // Output: 8
   ```

### The `@FunctionalInterface` Annotation:

While not required, it's a good practice to use the `@FunctionalInterface` annotation to explicitly mark an interface as a functional interface. The compiler will enforce the rule that the interface has only one abstract method, and if you add more than one, it will throw an error.

Example:

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void doSomething();  // Single abstract method

    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
}
```

The `@FunctionalInterface` annotation is optional, but it makes the code more readable and helps catch errors at compile-time if the interface is not a valid functional interface.

### Why Only One Abstract Method in a Functional Interface?

The primary reason why a **functional interface** must have exactly one abstract method is to ensure that it can be used as a **target type** for lambda expressions and method references. A lambda expression defines a single behavior or function, and it needs to map directly to one method. Having more than one abstract method in the interface would create ambiguity, making it unclear which method the lambda expression should implement.

#### Key Reasons:
1. **Simplicity**: A functional interface represents a single operation or behavior. If an interface had multiple abstract methods, it would no longer be possible to associate a single lambda expression with the interface, making it impossible to express a simple, concise operation.

   - **Single abstract method** → One behavior (function) → One lambda expression.
   - **Multiple abstract methods** → Ambiguity in behavior → Cannot be represented by a single lambda expression.

2. **Lambda Expression Semantics**: A lambda expression represents a function that implements a single abstract method. By restricting the interface to one abstract method, the lambda expression can be seen as implementing that method, leading to cleaner, more understandable code.

3. **Target Type for Lambda Expressions**: Java allows you to assign a lambda expression to a variable of a functional interface type, and the compiler can infer which abstract method to implement. If the interface had more than one abstract method, this would not be possible without some ambiguity in deciding which method the lambda should implement.

### Why Allow Default and Static Methods in Functional Interfaces?

While a functional interface must have exactly one abstract method, it is allowed to have **default** and **static** methods. The purpose of allowing default and static methods is to provide flexibility in how interfaces are designed and used, without breaking the contract of a functional interface.

#### 1. **Default Methods**:
   - **Definition**: A `default` method is a method with a body that provides a default implementation. It allows a class (or interface) implementing the interface to use the default behavior or override it if necessary.

   Java 8 allows you to define **default methods** in interfaces. These are methods with a default implementation, which means you can provide a default behavior in the interface itself without requiring implementing classes to override them.

   - **Why useful?** Default methods enable you to add new methods to existing interfaces without breaking existing code that implements those interfaces.
  
   - **Why Needed**:
     - **Extensibility**: Java 8 introduced **default methods** to enable interfaces to evolve over time. Without default methods, adding new methods to an existing interface would break existing implementations of that interface. With default methods, new methods can be added without requiring existing classes to implement them.
     - **Code Reusability**: Default methods can provide a default implementation of behavior that all implementing classes can share. For example, in a functional interface, you might want to provide a common implementation of a helper method that can be used by all implementing classes but still allow the main abstract method to be defined by the implementing class.
   
   - **Example**:
     ```java
     @FunctionalInterface
     public interface MyFunctionalInterface {
         void execute(); // Abstract method
        
         // Default method
         default void defaultMethod() {
             System.out.println("This is a default method.");
         }
     }
     ```
     In this example, the interface defines one abstract method (`execute`) and a `default` method (`defaultMethod`). The default method provides shared behavior for all classes that implement this interface.

#### 2. **Static Methods**:
   - **Definition**: A `static` method belongs to the interface itself rather than to instances of implementing classes. Static methods can be called without creating an instance of the interface.

   Java 8 also allows you to define **static methods** in interfaces. These are similar to static methods in classes, and they can be called without an instance of the interface.
   
   - **Why Needed**:
     - **Utility Methods**: Static methods can provide utility methods related to the interface but are not part of the instance-specific behavior. These methods are useful when you need to have behavior that is tied to the interface itself, rather than to a specific instance of a class implementing the interface.
     - **Code Organization**: They allow functionality that complements the abstract method(s) but doesn’t need to be overridden by implementing classes.
   
   - **Example**:
     ```java
     @FunctionalInterface
     public interface MyFunctionalInterface {
         void execute();  // Abstract method
        
         // Static method
         static void staticMethod() {
             System.out.println("This is a static method.");
         }
     }
     ```
     Here, `staticMethod()` is a static method of the interface, which can be called without an instance of `MyFunctionalInterface`. Static methods are not inherited by implementing classes but can be accessed directly from the interface.

### Why Do We Need Default and Static Methods?

- **Backward Compatibility**: In Java 8, interfaces were extended to support default and static methods to allow developers to **evolve interfaces** without breaking existing code. This is particularly useful in large codebases where interfaces have been in use for a long time and adding a new abstract method would require all implementing classes to provide a new implementation. Default and static methods allow new functionality to be added without breaking backward compatibility.
  
- **Separation of Concerns**: Default and static methods allow an interface to provide a **default implementation** of certain behaviors (without forcing all implementing classes to provide their own) and allow **utility methods** that may help in the context of that interface. These methods are optional, and implementing classes can either use the default behavior or override it if needed.
  
- **Encapsulation**: Static and default methods are a way to add additional functionality that is tied to the interface itself, not to individual objects. This helps separate concerns and keeps the interface focused on defining the abstract behavior, while still providing additional functionality where needed.

### Example: Using Default and Static Methods

Here’s an example that demonstrates both default and static methods within a functional interface:

```java
@FunctionalInterface
public interface Operation {
    int apply(int a, int b);  // Single abstract method

    // Default method providing a common behavior
    default void printResult(int result) {
        System.out.println("The result is: " + result);
    }

    // Static method providing utility
    static int add(int a, int b) {
        return a + b;
    }
}
```

- **Default Method (`printResult`)**: This method provides a default behavior that prints the result of an operation, but it can be overridden if necessary.
- **Static Method (`add`)**: This static method performs a simple addition operation, which can be called without an instance of `Operation`.

### Example Usage:

```java
public class Main {
    public static void main(String[] args) {
        // Lambda expression implementing the abstract method
        Operation addition = (a, b) -> a + b;

        // Calling the abstract method
        int result = addition.apply(5, 3);
        
        // Calling the default method
        addition.printResult(result);  // Output: The result is: 8

        // Calling the static method
        int staticResult = Operation.add(10, 20);
        System.out.println("Static add result: " + staticResult);  // Output: Static add result: 30
    }
}
```

### Conclusion:

A **functional interface** in Java 8 is an interface with a single abstract method, and it can be used with lambda expressions to provide a clean and concise way to represent behavior. Java 8's functional interfaces, especially those in the `java.util.function` package, have become an essential part of Java's functional programming features, making it easier to write code in a declarative and functional style.

- **Single Abstract Method**: The reason a functional interface must have only one abstract method is to ensure that it can represent a single, specific behavior, which is then implemented via a lambda expression or method reference. This makes lambda expressions and functional interfaces highly efficient and easy to use.
  
- **Default and Static Methods**: These are allowed in functional interfaces to provide additional functionality, enable interface evolution without breaking existing code, and support utility methods that are tied to the interface rather than an instance. Default methods enhance flexibility by providing common implementations, while static methods support utility operations.

In short, the combination of a single abstract method with optional default and static methods strikes a balance between **simplicity** (single abstract method) and **flexibility** (default and static methods), making functional interfaces powerful tools in Java's functional programming toolkit.

---

### 3. [Method References](#method-references)

Method references provide a shorthand syntax for calling methods directly using the `::` operator. They are often used in combination with streams and lambdas to make the code more readable.

**Example**:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println);  // Method reference to println
```

Method references can be used for:
- **Static methods**: `ClassName::staticMethod`
- **Instance methods**: `object::instanceMethod`
- **Constructor references**: `ClassName::new`

---

### 4. [Streams API](#streams-api)

The **Streams API** is one of the most powerful features in Java 8. It allows you to process sequences of elements (such as collections) in a functional style, enabling operations like filtering, mapping, and reducing in a clean and efficient way.

- **Key Operations**:
  - **Intermediate operations** (e.g., `filter()`, `map()`, `sorted()`) return a new stream.
  - **Terminal operations** (e.g., `collect()`, `forEach()`, `reduce()`) trigger the processing of the stream.

**Example**:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

names.stream()
     .filter(name -> name.length() > 3)
     .map(String::toUpperCase)
     .forEach(System.out::println);
```
This example filters names with more than 3 characters, converts them to uppercase, and prints them.

---


### 5. [Optional Class](#optional-class)

The **`Optional<T>`** class is a container object which may or may not contain a non-null value. It helps avoid `NullPointerException` by providing methods to handle the presence or absence of a value without explicitly checking for `null`.

- **Usage**: Instead of returning `null` for empty or missing values, return `Optional.empty()`.
  
**Example**:
```java
Optional<String> name = Optional.ofNullable(getName());
name.ifPresent(System.out::println);  // Prints if value is present, does nothing otherwise
```

---

### 6. [New Date and Time API (java.time)](#new-date-and-time-api-javatime)

Java 8 introduced a completely new **Date and Time API** under the `java.time` package, which addresses the flaws of the old `java.util.Date` and `java.util.Calendar`. It includes classes such as:
- **`LocalDate`**: For date without time.
- **`LocalTime`**: For time without date.
- **`LocalDateTime`**: For both date and time.
- **`ZonedDateTime`**: For date and time with timezone.
- **`Instant`**: For a point in time (timestamps).

**Example**:
```java
LocalDate date = LocalDate.now();
System.out.println(date);  // Prints the current date in ISO-8601 format (e.g., 2024-12-13)
```

---

### 7. [Nashorn JavaScript Engine](#nashorn-javascript-engine)

Java 8 introduced **Nashorn**, a much faster JavaScript engine than the previous Rhino engine. It allows you to embed JavaScript code within Java applications and execute it dynamically.

**Example**:
```java
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Hello from JavaScript in Java!')");
```

---

### 8. [Streams and Parallel Streams](#streams-and-parallel-streams)

Java 8 introduced the ability to perform **parallel processing** on collections using streams. This allows you to easily process data concurrently using the **parallelStream()** method.

**Example**:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.parallelStream()
                  .mapToInt(Integer::intValue)
                  .sum();
System.out.println(sum);  // The sum of numbers will be calculated in parallel
```

---

### 9. [Collectors Class](#collectors-class)

The **`Collectors`** class provides utility methods to perform common reduction operations, such as **collecting elements into collections** or **grouping** and **partitioning** data.

- **Example**:
  - `Collectors.toList()`
  - `Collectors.joining()`
  - `Collectors.groupingBy()`
  - `Collectors.partitioningBy()`

**Example**:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

Map<Integer, List<String>> groupedByLength = names.stream()
    .collect(Collectors.groupingBy(String::length));

System.out.println(groupedByLength);  // Group names by their length
```

---

### 10. [Type Annotations](#type-annotations)

Java 8 allows **type annotations** to be used in the program. This means you can apply annotations not only to variables, methods, and fields, but also to **type parameters** (e.g., generics).

**Example**:
```java
public class Example<T> {
    public void process(@NonNull T value) {
        // ...
    }
}
```

---

### 11. [Improved Type Inference](#improved-type-inference)

Java 8 introduced improved type inference with **diamond operator** (`<>`), which simplifies the creation of generics. This is useful when instantiating objects with generics.

**Example**:
```java
List<String> list = new ArrayList<>();  // Compiler infers the type (List<String>)
```

---

### 12. [Marker Interface](#marker-interface)

### What is a Marker Interface in Java?

A **marker interface** is an interface that has no methods or fields. Its sole purpose is to **mark** or **tag** a class with a specific property or behavior. Classes that implement the marker interface are considered to possess some special property or behavior, even though the interface itself doesn't define any methods.

In Java, a marker interface is used to indicate that a class should be treated in a certain way by the JVM or frameworks. The marker interface acts as a form of metadata or annotation for classes, but without any actual functionality.

#### Characteristics of Marker Interfaces:
- **No methods**: A marker interface does not declare any methods.
- **Used for tagging**: The primary purpose of a marker interface is to "mark" or "tag" a class with a special property or behavior.
- **Class-specific**: A class that implements a marker interface can be identified or treated differently based on the presence of that interface.

### Example of a Marker Interface

Here’s a simple example of a marker interface and its use:

#### Step 1: Define a Marker Interface
```java
public interface Serializable {
    // No methods here, it's just a marker interface
}
```

#### Step 2: Implement the Marker Interface in a Class
```java
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
}
```

In this example, `Serializable` is a marker interface. It doesn't contain any methods. The class `Person` implements this interface to indicate that objects of `Person` can be serialized.

#### Step 3: Use the Marker Interface (Marker Interface Checking)
The behavior or special processing related to the marker interface is typically implemented by the class or framework that recognizes the marker. For example, the `ObjectOutputStream` class in Java uses the `Serializable` marker interface to determine whether an object can be serialized.

```java
import java.io.*;

public class MarkerInterfaceExample {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Alice", 30);

        // Check if the object is serializable
        if (person instanceof Serializable) {
            // Perform serialization
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
                out.writeObject(person);
                System.out.println("Object is serialized!");
            }
        } else {
            System.out.println("Object is not serializable.");
        }
    }
}
```

In this example, we check if the `Person` object implements the `Serializable` marker interface before attempting to serialize it. If `Person` does not implement `Serializable`, it would throw a `java.io.NotSerializableException`.

### Why Use Marker Interfaces in Java?

Marker interfaces serve a very specific role in Java, and their use cases are somewhat niche. Here are some reasons why marker interfaces are used:

1. **Specialized Behavior or Metadata**:
   Marker interfaces are used to tag or annotate a class to indicate that it should be treated in a special way by the system, framework, or application. The presence of the marker interface signals the framework to apply specific logic to the object.

2. **Separation of Concerns**:
   By using a marker interface, you can separate concerns in your code. A class can have the behavior of a certain type without having to actually define it explicitly. This is useful when you want to define a contract or condition that is not necessarily tied to the behavior of the class.

3. **Type Checking and Validation**:
   Marker interfaces are commonly used to perform type checking. For example, in the case of Java's `Serializable` interface, classes that implement it can be serialized, and the system can easily check whether or not serialization is supported by simply checking if a class implements the marker interface.

4. **Polymorphism**:
   A marker interface enables polymorphic behavior in Java. For example, the `Cloneable` interface is a marker interface in Java. It allows any object that implements it to be cloned using the `Object.clone()` method. This gives objects the ability to be cloned, while the actual cloning logic is handled in the `Object` class (or other places that recognize the marker).

5. **Frameworks and Libraries**:
   Many Java frameworks use marker interfaces as a way to identify objects that need special processing or treatment. For example, the **Java Persistence API (JPA)** uses marker interfaces to mark certain classes as persistent entities that can be managed by the JPA.

6. **Implementation by Third-Party Libraries**:
   Marker interfaces are also used in third-party libraries to determine special processing for certain types of objects. For example, in Spring, custom marker interfaces may be used to mark beans for special processing during application context initialization.

---

### Common Examples of Marker Interfaces in Java

Here are some well-known examples of marker interfaces in Java:

1. **`Serializable`**:
   - **Purpose**: Marks a class as capable of being serialized (converted to a byte stream for storage or transmission).
   - **Example**: If a class implements the `Serializable` interface, it can be serialized using `ObjectOutputStream` and deserialized using `ObjectInputStream`.

2. **`Cloneable`**:
   - **Purpose**: Marks a class that can be cloned. The `Object` class has a `clone()` method, but it only works for classes that implement the `Cloneable` interface.
   - **Example**: If a class implements `Cloneable`, it can be cloned by calling `object.clone()`.

3. **`Remote`** (from RMI):
   - **Purpose**: Marks a class as being remote. Classes implementing the `Remote` interface can be used in remote method invocations (RMI).
   - **Example**: If a class implements `Remote`, it can be used for remote communication in distributed applications.

---

### Advantages of Marker Interfaces

1. **Separation of Concerns**:
   Marker interfaces allow you to define a separate contract without altering the underlying class hierarchy.

2. **Flexibility**:
   A class can implement a marker interface and be recognized by external frameworks or systems for specific processing, without having to change its core functionality.

3. **Improves Code Readability**:
   By using a marker interface, you make it clear that a class has a special meaning or purpose (e.g., being serializable, cloneable, or remote). This improves code readability by providing semantic meaning.

---

### Disadvantages of Marker Interfaces

1. **Lack of Information**:
   Marker interfaces don’t provide any method signatures, so they only mark classes without conveying any additional information. This may be limiting if more detailed metadata or behavior is required.

2. **Alternative Solutions**:
   In many cases, marker interfaces are now being replaced by **annotations** in modern Java. Annotations can provide more flexibility and can carry additional metadata (e.g., `@Entity` in JPA) as opposed to just marking a class. Annotations can also be used with reflection to inspect class properties at runtime.

3. **Overuse**:
   Relying heavily on marker interfaces may indicate an anti-pattern, as they don’t convey enough meaningful information by themselves. In some cases, it may be better to use annotations or explicit interfaces with methods.

---

### Conclusion

In summary, a **marker interface** is a special type of interface in Java that doesn't contain any methods but serves as a way to "mark" or "tag" classes with a particular property. While they are useful for certain scenarios (like serialization and cloning), they have largely been replaced or supplemented by **annotations** in modern Java development due to their flexibility and the additional information they can carry. Despite that, marker interfaces still remain a valuable concept in certain legacy systems and specific use cases.

---

### 13. [Metadata](#metadata)

The term **metadata** refers to **data about data**. In the context of programming, **metadata** provides additional information about a program's code, such as the structure of data, the behavior of objects, or the intended use of certain elements in the program. It's a way of attaching extra information to code elements like classes, methods, fields, or parameters, without affecting the actual logic of the code.

In Java, **metadata** is often used to describe the **annotations** or **marker interfaces** that convey extra information to the compiler, runtime, or framework. This metadata is typically used by external tools, libraries, or the runtime environment to modify behavior or to enforce certain conditions.

Let's break this down and clarify what we mean by **metadata** in different contexts:

---

### 1. **Metadata in Java (Using Annotations)**

**Annotations** in Java are a form of **metadata** that provide additional information about code elements such as classes, methods, fields, and parameters. They don't affect the actual logic of the code, but they can be used by frameworks or the JVM to influence behavior during compilation, runtime, or both.

#### Example: Using Annotations as Metadata

Annotations can be used to provide metadata that tells the framework how to handle a particular class, method, or field.

```java
import java.lang.annotation.*;

// Define a custom annotation as metadata
@Target(ElementType.METHOD)  // Applied to methods
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime
public @interface Test {
    String description() default "Test method";
}

public class MyTests {

    @Test(description = "This is a test method")
    public void testMethod() {
        System.out.println("Test method executed.");
    }
}
```

In this example, the `@Test` annotation is metadata that describes the `testMethod`. It doesn't impact the behavior of the method itself, but it can be used by a testing framework (like JUnit) to identify which methods should be executed as tests.

- **Metadata Purpose**: The `@Test` annotation is metadata that marks `testMethod` as a test method. It doesn't change how the method works, but it provides useful information to the testing framework.
- **Usage**: A testing framework might use reflection to find all methods annotated with `@Test` and execute them.

#### Types of Annotations Used as Metadata:
- **Built-in Annotations**:
  - `@Override`: Tells the compiler that a method is intended to override a method in a superclass.
  - `@Deprecated`: Marks a method or class as deprecated (should not be used in future versions).
  - `@SuppressWarnings`: Instructs the compiler to suppress specific warnings.

- **Custom Annotations**:
  - Developers can create custom annotations to provide specific metadata to tools or frameworks.

---

### 2. **Marker Interfaces as Metadata**

A **marker interface** is another form of metadata in Java, although it works differently from annotations. A marker interface is an interface that has no methods and is used to **mark** or **tag** a class with some special meaning. It provides metadata by associating specific behavior or characteristics with the class that implements it.

#### Example: Marker Interface as Metadata

```java
// Define a marker interface as metadata
public interface Serializable {}

// A class that implements the marker interface
public class Person implements Serializable {
    private String name;
    private int age;
}
```

In this case, the `Serializable` interface doesn't contain any methods, but it marks the `Person` class as something that can be serialized. External tools or libraries (like Java's `ObjectOutputStream`) can look for the `Serializable` interface as metadata and take specific actions based on its presence.

#### Why Is `Serializable` a Form of Metadata?
- It doesn't change the actual behavior of the `Person` class itself.
- The presence of the interface tells the `ObjectOutputStream` that the `Person` class can be serialized, influencing how objects are handled by Java's serialization mechanisms.

---

### 3. **How Metadata Influences Behavior in Java**

**Metadata** (whether through annotations or marker interfaces) often helps external frameworks, libraries, or the JVM to influence the program’s behavior. It can:
- Control compilation behavior (e.g., `@Override`).
- Provide runtime instructions (e.g., `@Entity` for JPA).
- Enable features in libraries or frameworks (e.g., Spring, Hibernate).

#### Example: Metadata with JPA (Java Persistence API)

In JPA, annotations like `@Entity` or `@Table` are used to provide metadata about how a class should be mapped to a database table.

```java
import javax.persistence.*;

// The @Entity annotation marks the class as a JPA entity
@Entity
@Table(name = "person_table")
public class Person {
    @Id
    private int id;

    private String name;
    private int age;

    // Getters and setters
}
```

- **Metadata Purpose**: The `@Entity` annotation marks the `Person` class as a persistent entity that should be mapped to a database table.
- **How It's Used**: The JPA provider (like Hibernate) uses this metadata to automatically generate SQL queries to store and retrieve instances of `Person` from the database.

---

### 4. **Reflection to Access Metadata**

In Java, you can use **reflection** to read metadata (such as annotations or interface implementations) at runtime. This enables dynamic behavior based on the metadata associated with classes, methods, or fields.

#### Example: Using Reflection to Read Annotations

```java
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String value();
}

public class MyTestClass {
    @Test(value = "This is a test method")
    public void testMethod() {
        System.out.println("Test method executed.");
    }
}

public class MetadataExample {
    public static void main(String[] args) throws Exception {
        // Using reflection to read metadata
        Method method = MyTestClass.class.getMethod("testMethod");
        
        if (method.isAnnotationPresent(Test.class)) {
            Test test = method.getAnnotation(Test.class);
            System.out.println("Test value: " + test.value());
        }
    }
}
```

- **Reflection**: Here, we use reflection to inspect the `Test` annotation on the `testMethod`. The metadata provides additional information (in this case, a description) about the method.

---

### 5. **Other Forms of Metadata in Java**

Java has several other ways to attach metadata to various program elements:

- **Generics**: Type parameters in generics provide metadata about the types used in a class or method.
  
  Example:
  ```java
  public class Box<T> {  // T is metadata describing the type of the Box
      private T value;
      public void setValue(T value) {
          this.value = value;
      }
  }
  ```

- **Documentation Comments (Javadoc)**: Javadoc comments (`/** ... */`) provide metadata that is used to generate API documentation.

---

### Conclusion

**Metadata** in Java provides additional information about code elements like classes, methods, or fields. It can influence how the code behaves during compilation or runtime without changing the actual logic of the code. 

- **Annotations** and **marker interfaces** are the primary forms of metadata in Java.
- **Annotations** are more flexible and can carry additional information (e.g., `@Entity` or `@Override`).
- **Marker interfaces** are simpler and only tag a class without adding behavior (e.g., `Serializable`).
- **Reflection** enables the inspection of metadata at runtime.

Metadata makes code more flexible, allows frameworks and libraries to offer more powerful functionality, and improves code clarity and documentation.
