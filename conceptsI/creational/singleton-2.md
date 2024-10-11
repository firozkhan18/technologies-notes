# Singleton Method Design Pattern

## What is Singleton Method Design Pattern?
The Singleton method or Singleton Design pattern is one of the simplest design patterns. It ensures a class only has one instance and provides a global point of access to it.

To master design patterns like Singleton, consider enrolling in the System Design Course, which covers design patterns in-depth and demonstrates their practical applications in software development.

## When to use Singleton Method Design Pattern?
Use the Singleton method Design Pattern when:
- There must be exactly one instance of a class, and it must be accessible to clients from a well-known access point.
- The sole instance should be extensible by subclassing, and clients should be able to use an extended instance without modifying.
- Singleton classes are used for logging, driver objects, caching, thread pool, and database connections.

## Initialization Types of Singleton
Singleton class can be instantiated by two methods:
- **Early initialization**: In this method, the class is initialized whether it is to be used or not. The main advantage is its simplicity, but the drawback is that the class is always initialized.
- **Lazy initialization**: In this method, the class is initialized only when it is required. It can save resources by avoiding instantiation when not needed. This method is generally used when creating a singleton class.

## Key Component of Singleton Method Design Pattern:
### 1. Static Member
The Singleton pattern employs a static member within the class. This static member ensures that memory is allocated only once, preserving the single instance of the Singleton class.

```java
// Static member to hold the single instance
private static Singleton instance;
```

### 2. Private Constructor
The Singleton pattern incorporates a private constructor, which serves as a barricade against external attempts to create instances of the Singleton class.

```java
// Private constructor to prevent external instantiation
class Singleton {
    private Singleton() {
        // Initialization code here
    }
}
```

### 3. Static Factory Method
A crucial aspect of the Singleton pattern is the presence of a static factory method. This method acts as a gateway, providing a global point of access to the Singleton object.

```java
// Static factory method for global access
public static Singleton getInstance() {
    if (instance == null) {
        instance = new Singleton();
    }
    return instance;
}
```

## Implementation of Singleton Method Design Pattern
The implementation of a Singleton Design Pattern is described in the following class diagram:

The implementation of the Singleton Design pattern is very simple and consists of a single class. To ensure that the singleton instance is unique, all singleton constructors should be made private. Global access is done through a static method that can be globally accessed to a single instance as shown in the code.

```java
import java.io.*;

class Singleton {
    // static class
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton is Instantiated.");
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public static void doSomething() {
        System.out.println("Something is Done.");
    }
}

class GFG {
    public static void main(String[] args) {
        Singleton.getInstance().doSomething();
    }
}
```

### Output
```
Singleton is Instantiated.
Something is Done.
```

The `getInstance` method checks whether the instance is null. If the instance is not null, it means the object was created before; otherwise, it creates it using the `new` operator.

## Different Ways to Implement Singleton Method Design Pattern
Sometimes we need to have only one instance of our class, for example, a single DB connection shared by multiple objects, as creating a separate DB connection for every object may be costly. Similarly, there can be a single configuration manager or error manager in an application that handles all problems instead of creating multiple managers.

### Method 1 – Classic Implementation
```java
class Singleton {
    private static Singleton obj;

    // private constructor to force use of getInstance() to create Singleton object
    private Singleton() {}

    public static Singleton getInstance() {
        if (obj == null)
            obj = new Singleton();
        return obj;
    }
}
```
Here we have declared `getInstance()` static so that we can call it without instantiating the class. The first time `getInstance()` is called, it creates a new singleton object, and after that, it just returns the same object. Note: Singleton obj is not created until we need it and call the `getInstance()` method. This is called lazy instantiation. The main problem with the above method is that it is not thread-safe.

### Method 2 – Synchronized Implementation
```java
class Singleton {
    private static Singleton obj;

    private Singleton() {}

    // Only one thread can execute this at a time
    public static synchronized Singleton getInstance() {
        if (obj == null)
            obj = new Singleton();
        return obj;
    }
}
```
Using synchronized makes sure that only one thread at a time can execute `getInstance()`. The main disadvantage of this method is that using synchronized every time while creating the singleton object is expensive and may decrease the performance of your program.

### Method 3 – Eager Instantiation
```java
class Singleton {
    private static Singleton obj = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return obj;
    }
}
```
Here we have created an instance of a singleton in a static initializer. JVM executes a static initializer when the class is loaded, hence this is guaranteed to be thread-safe. Use this method only when your singleton class is light and is used throughout the execution of your program.

### Method 4 – Double Checked Locking
```java
class Singleton {
    private static volatile Singleton obj = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (obj == null) {
            // To make thread safe
            synchronized (Singleton.class) {
                // check again as multiple threads can reach above step
                if (obj == null)
                    obj = new Singleton();
            }
        }
        return obj;
    }
}
```
We have declared the `obj` volatile, which ensures that multiple threads offer the `obj` variable correctly when it is being initialized to the Singleton instance. This method drastically reduces the overhead of calling the synchronized method every time.

### Method 5 – Instantiation through Inner Class
```java
public class Singleton {
    private Singleton() {
        System.out.println("Instance created");
    }

    private static class SingletonInner {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInner.INSTANCE;
    }
}
```
In the above code, we have a private static inner class `SingletonInner` that holds the singleton instance. The inner class is loaded only when `getInstance()` is called, ensuring that the instance is initialized only once.

## Use Case of Pattern Singleton Method
- **Database Connections**: In applications where creating and managing database connections is an expensive operation, a Singleton can be used to maintain a single database connection throughout the application.
- **Configuration Management**: When you have global configuration settings that need to be accessed by various components of the application, a Singleton configuration manager can provide a single point of access to these settings.
- **GUI Components**: For graphical user interface (GUI) components or controllers, a Singleton can help manage the state and actions of the UI, providing a single point of control.
- **Device Managers**: In embedded systems or applications interacting with hardware devices, a Singleton can be used to manage and control access to hardware devices to avoid conflicts.
- **Printing Service**: In systems that involve printing documents or reports, a Singleton printing service can coordinate and manage print jobs, ensuring efficient use of printing resources.

## Advantages of Singleton Method Design Pattern:
- **Solves Name Collisions**: In scenarios where a single point of control is needed to avoid naming conflicts or collisions, the Singleton pattern ensures that there is only one instance with a unique name.
- **Eager or Lazy Initialization**: The Singleton pattern supports both eager initialization (creating the instance when the class is loaded) and lazy initialization (creating the instance when it is first requested), providing flexibility based on the use case.
- **Thread Safety**: Properly implemented Singleton patterns can provide thread safety, ensuring that the instance is created atomically and that multiple threads do not inadvertently create duplicate instances.
- **Reduced Memory Footprint**: In applications where resource consumption is critical, the Singleton pattern can contribute to a reduced memory footprint by ensuring that there is only one instance of the class.

## Disadvantages of Singleton Design Pattern
- **Testing Difficulties**: Because Singletons introduce global state, unit testing can become challenging. Testing one component in isolation may be more complicated if it relies on a Singleton, as the state of the Singleton may affect the outcome of tests.
- **Concurrency Issues**: In a multi-threaded environment, there can be issues related to the creation and initialization of the Singleton instance. If multiple threads attempt to create the Singleton simultaneously, it can result in race conditions.
- **Limited Extensibility**: The Singleton pattern can make code less extensible. If you later decide that you need multiple instances of the class or want to change the instantiation logic, it may require significant refactoring.
- **Global Dependency**: The Singleton pattern creates a global dependency, making it harder to replace the Singleton with an alternative implementation or to use dependency injection for providing instances.
- **Hard to Subclass**: Subclassing a Singleton can be challenging. Because the constructor is typically private, extending a Singleton requires additional care and may not follow standard inheritance patterns.
- **Lifecycle Management**: The Singleton pattern may not handle scenarios where the instance needs to be explicitly destroyed or reset. Managing the lifecycle of the Singleton

 can become a concern.
- **Global Access Point Abuse**: While a global access point is an advantage, it can also be abused. Developers might be tempted to use the Singleton for everything, leading to an overuse of global state and a less modular design.

## Conclusion
It's important for some classes to have exactly one instance. Although there can be many printers in a system, there should be only one printer spooler. There should be only one file system and one window manager. A digital filter will have one A/D converter. An accounting system will be dedicated to serving one company. 

The Singleton pattern ensures that a class has only one instance and that the instance is easily accessible. A global variable makes an object accessible, but it doesn’t keep you from instantiating multiple objects. A better solution is to make the class itself responsible for keeping track of its sole instance and providing a way to access it.

Feel free to copy and use it as needed!
