```markdown
# What is Java Class?

A Java class is nothing but a template for the object you are going to create or it’s a blueprint using which we create an object. In simple words, we can say it’s a specification or a pattern which we define, and every object we define will follow that pattern.

## What does Java Class Consist?

- When we create a class in Java, the first step is the keyword `class` followed by the name of the class or identifier.
- Next is the class body, which starts with curly braces `{}`. Between these braces, all things related to that class—such as properties and methods—will be defined.

**Template:**
```
Class (name of the class) {
    (Here define member of class)
}
```

## Access Level of Class

Java classes have mainly two types of access levels:
- **Default**: Class objects are accessible only inside the package.
- **Public**: Class objects are accessible in code in any package.

## What are Members of Class?

When we create a class, it is incomplete without defining any members. Just as a family is incomplete if they have no members, a class must have:

- **Field**: A field is nothing but the property of the class or object. For example, if we create a class called `Computer`, its properties might include `model`, `mem_size`, `hd_size`, `os_type`, etc.
  
- **Method**: A method defines the operations that an object can perform. It defines the behavior of the object and how it can interact with the outside world. Examples include `startMethod()`, `shutdownMethod()`.

### Access Level of Members

Each field and method has an access level:
- **private**: Accessible only in this class.
- **package or default**: Accessible only in this package.
- **protected**: Accessible only in this package and in all subclasses of this class.
- **public**: Accessible everywhere this class is available.

## Real World Example of Class in Java Programming

In the real world, everything of the same quality can be visualized as a class, e.g., men, women, birds, bicycles, cars, or we can say vehicles. The entire vehicle will make one class with properties like `no_of_wheels`, `color`, `model`, `brand`, etc. We can think of methods like `changeGear()`, `speedOfVehicle()`, `applyBreak()`, etc., for that class.

Similarly, all human beings can be considered one class, with members being men, women, children, and methods like `isAlive()`, `isDead()`. We can also create separate classes for men and women and define their properties and methods accordingly. In short, in Java, every problem can be viewed in terms of class and object.

## One Java Class Example

```java
class Stock {
    public String commodity;
    public double price;

    public void buy(int noOfCommodity) {}
    public boolean sale() {}
}
```

In this example, `Stock` is called a class, and `commodity`, `price` are fields, while `buy()` and `sale()` are two methods defined inside the class. 

To access elements of the class, you need to create an instance of `Stock`. You can create an instance using the keyword `new` as shown below:

```java
Stock highBetaStock = new Stock();
```

To call methods of `Stock`, use the instance:

```java
highBetaStock.buy(1000);
highBetaStock.sale();
```

## Summary

In short, in Java, everything must be thought of in terms of Java classes. It’s a template that has its own members and methods for accessing those members. The visibility of each member is decided by the developer based on where they want to use those objects.

---

# How to Make Thread-Safe Code in Java

## Example of Non Thread-Safe Code in Java

Here is an example of non-thread-safe code. Look at the code and find out why this code is not thread-safe.

```java
public class Counter {
    private int count;

    // This method is not thread-safe because ++ is not an atomic operation
    public int getCount() {
        return count++;
    }
}
```

The above example is not thread-safe because the increment operator `++` is not atomic and can be broken down into read, update, and write operations. If multiple threads call `getCount()` at approximately the same time, each of these operations may coincide or overlap. For example, while thread 1 is updating the value, thread 2 reads and still gets the old value, which eventually leads to thread 2 overriding thread 1's increment, and one count is lost because multiple threads called it concurrently.

## How to Make Code Thread-Safe in Java

There are multiple ways to make this code thread-safe in Java:

1. **Use the synchronized keyword** in Java and lock the `getCount()` method so that only one thread can execute it at a time, which removes the possibility of coinciding or interleaving.

2. **Use Atomic Integer**, which makes this `++` operation atomic. Since atomic operations are thread-safe, they save the cost of external synchronization.

Here is a thread-safe version of the `Counter` class in Java:

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int count;
    AtomicInteger atomicCount = new AtomicInteger(0);

    // This method is thread-safe now because of locking and synchronization
    public synchronized int getCount() {
        return count++;
    }

    // This method is thread-safe because count is incremented atomically
    public int getCountAtomically() {
        return atomicCount.incrementAndGet();
    }
}
```

## Important Points about Thread-Safety in Java

Here are some points worth remembering to write thread-safe code in Java. This knowledge helps you avoid serious concurrency issues in Java like race conditions or deadlocks:

- Immutable objects are by default thread-safe because their state cannot be modified once created. Since `String` is immutable in Java, it's inherently thread-safe.
- Read-only or final variables in Java are also thread-safe.
- Locking is one way of achieving thread-safety in Java.
- Static variables, if not synchronized properly, can become a major cause of thread-safety issues.
- Examples of thread-safe classes in Java include `Vector`, `Hashtable`, `ConcurrentHashMap`, and `String`.
- Atomic operations in Java are thread-safe; for example, reading a 32-bit int from memory is atomic and can't interleave with other threads.
- Local variables are also thread-safe because each thread has its own copy. Using local variables is a good way to write thread-safe code in Java.
- To avoid thread-safety issues, minimize sharing of objects between multiple threads.
- The `volatile` keyword in Java can instruct a thread not to cache variables and read from main memory, and it can also instruct the JVM not to reorder or optimize code from a threading perspective.

## 2 Ways to Find if a Thread Holds Lock on an Object in Java

1. I thought about `IllegalMonitorStateException`, which `wait()` and `notify()` methods throw when they get called from a non-synchronized context. I said I would call `newspaper.wait()`, and if this call throws an exception, it means the thread is not holding the lock; otherwise, the thread holds the lock.

2. I later discovered that there is a static method called `holdsLock(Object obj)` which returns true or false based on whether the thread holds the lock on the object passed.

---

# Wait vs Sleep vs Yield in Java

## Difference between Wait and Sleep in Java

The main difference between `wait()` and `sleep()` is that the `wait()` method releases the acquired monitor when the thread is waiting, while the `Thread.sleep()` method keeps the lock or monitor even if the thread is waiting. 

Additionally:
- The `wait` method in Java should be called from a synchronized method or block, while there is no such requirement for the `sleep()` method.
- `Thread.sleep()` is a static method and applies to the current thread, while `wait()` is an instance-specific method and will only wake up if some other thread calls the `notify` method on the same object.
- In the case of `sleep`, the sleeping thread immediately goes to the Runnable state after waking up, while in the case of `wait`, the waiting thread first acquires the lock and then goes into the Runnable state.

Based on your needs, if you require a specified pause, use the `sleep()` method; if you want to implement inter-thread communication, use the `wait()` method.

### Differences Between Wait and Sleep in Java

- `wait` is called from a synchronized context only while `sleep` can be called without a synchronized block.
- `wait` is called on an Object while `sleep` is called on a Thread.
- A waiting thread can be awakened by calling `notify` and `notifyAll`, while a sleeping thread cannot be awakened by calling the `notify` method.
- `wait` is normally done on condition; the thread waits until a condition is true, while `sleep` is just to put your thread to sleep.
- `wait` releases the lock on the object while waiting, while `sleep` doesn’t release the lock while waiting.

## Difference Between Yield and Sleep in Java

The major difference between `yield()` and `sleep()` in Java is that the `yield()` method pauses the currently executing thread temporarily to give a chance to the remaining waiting threads of the same priority to execute. If there are no waiting threads or all the waiting threads have a lower priority, then the same thread will continue its execution.

The yielded thread's execution chance is decided by the thread scheduler, whose behavior is vendor-dependent. The `yield` method doesn’t guarantee that the

 current thread will pause or stop, but it guarantees that the CPU will be relinquished by the current thread as a result of calling `Thread.yield()`.

The `sleep` method in Java has two variants:
- One that takes milliseconds as sleeping time.
- Another that takes both milliseconds and nanoseconds for sleeping duration: `sleep(long millis)` or `sleep(long millis, int nanos)`.

### Example of Thread Sleep Method in Java

Here is a sample code example of the `sleep` method in Java. In this example, we have put the Main thread to sleep for 1 second.

```java
public class SleepTest {
    public static void main(String... args) {
        System.out.println(Thread.currentThread().getName() + " is going to sleep for 1 Second");
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread is woken now");
    }
}
```

### Output:
```
main is going to sleep for 1 Second
Main Thread is woken now
```

## 10 Points about Thread Sleep() Method in Java

1. The `Thread.sleep()` method is used to pause the execution, relinquish the CPU, and return it to the thread scheduler.
2. `Thread.sleep()` is a static method and always puts the current thread to sleep.
3. Java has two variants of the sleep method in the Thread class: one with one argument (milliseconds) and another with two arguments (milliseconds and nanoseconds).
4. Unlike the `wait()` method, the `sleep()` method of the Thread class doesn't relinquish the lock it has acquired.
5. The `sleep()` method throws `InterruptedException` if another thread interrupts a sleeping thread.
6. With `sleep()` in Java, it’s not guaranteed that when a sleeping thread wakes up, it will definitely get the CPU; instead, it goes to the Runnable state and competes for CPU with other threads.
7. There is a misconception that calling `t.sleep()` will put Thread "t" into a sleeping state; this is not true because `Thread.sleep()` is a static method and always puts the current thread into a sleeping state, not thread "t".
```

```markdown
# NoClassDefFoundError vs ClassNotFoundException

Before examining the differences between `ClassNotFoundException` and `NoClassDefFoundError`, let's explore some similarities that often lead to confusion between these two errors:

- Both `NoClassDefFoundError` and `ClassNotFoundException` are related to the unavailability of a class at runtime.
- Both are associated with the Java classpath.

## Differences Between NoClassDefFoundError and ClassNotFoundException

1. **Cause of Exception**:
   - `ClassNotFoundException` occurs when an application tries to load a class at runtime using methods like `Class.forName()`, `ClassLoader.loadClass()`, or `ClassLoader.findSystemClass()`, and the requested class is not available in the Java classpath.
   - In contrast, `NoClassDefFoundError` indicates that the class was present during compile time but is not available during runtime due to various reasons.

2. **Exception Type**:
   - `ClassNotFoundException` is a checked exception derived from `java.lang.Exception`, which requires explicit handling.
   - `NoClassDefFoundError` is an error derived from `LinkageError`.

3. **ClassLoader Behavior**:
   - If you use multiple class loaders and one tries to access a class loaded by another, it will result in a `ClassNotFoundException`.
   - `NoClassDefFoundError` is triggered by implicit loading of a class when its methods or variables are accessed, even if the class was previously loaded.

## Comparators and Comparable in Java

`Comparator` and `Comparable` are two interfaces used to implement sorting in Java. When sorting objects stored in collections like `ArrayList` or `HashSet`, we use either `compare()` or `compareTo()` method defined in `java.util.Comparator` and `java.lang.Comparable`.

### Comparator vs Comparable in Java

Here are some common differences that are useful for interviews:

1. **Package**:
   - `Comparator` is defined in the `java.util` package, while `Comparable` is defined in the `java.lang` package.

2. **Methods**:
   - `Comparator` has the method `public int compare(Object o1, Object o2)`, returning a negative integer, zero, or a positive integer based on the comparison.
   - `Comparable` has the method `public int compareTo(Object o)`, comparing "this" object with the specified object.

3. **Logical Comparison**:
   - `Comparator` compares two provided objects, while `Comparable` compares the "this" reference with the specified object.

4. **Natural Ordering**:
   - `Comparable` is used to implement the natural ordering of an object. Classes like `String`, `Date`, and wrapper classes implement `Comparable`.

5. **Automatic Sorting**:
   - Collections of objects implementing `Comparable` can be automatically sorted using `Collections.sort()` or `Arrays.sort()`.

### Example of Using Comparator and Comparable in Java

To demonstrate, consider a `Person` class sorted by `person_id` and `name`:

```java
public class Person implements Comparable<Person> {
    private int person_id;
    private String name;

    @Override
    public int compareTo(Person p) {
        return this.person_id - p.person_id; // Natural order
    }
}
```

For sorting by `name`, implement a `Comparator`:

```java
public class SortByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName()); // Sorting by name
    }
}
```

### Best Practices for Using Comparator and Comparable

- Use `Comparable` when a natural order exists for the object.
- Use `Comparator` when you need to define multiple ways to sort an object.
- When working with external classes where you cannot implement `Comparable`, `Comparator` is your solution.
- Ensure the order of comparison is clear and consistent.

## Observer Design Pattern in Java

### What is the Observer Design Pattern?

The Observer Design Pattern is used for notifying changes in one object (the Subject) to one or more observing objects (Observers). This pattern is prevalent in the Model-View-Controller (MVC) architecture.

### Implementation of Observer Design Pattern in Java

Java provides interfaces and methods for implementing this pattern in the `java.util` package. Here’s a simple implementation:

```java
interface Observer {
    void update(float interest);
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class Loan implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private float interest;

    public void setInterest(float interest) {
        this.interest = interest;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update(interest);
        }
    }
}

class Newspaper implements Observer {
    @Override
    public void update(float interest) {
        System.out.println("Newspaper: Interest Rate updated, new Rate is: " + interest);
    }
}
```

### Advantages and Disadvantages of Observer Design Pattern

**Advantages**:
- Loose coupling between the Subject and Observers.
- Broadcast communication allows multiple Observers to be notified simultaneously.

**Disadvantages**:
- Debugging can be complex due to implicit control flow.
- Potential memory issues if Observers are not unregistered.

## Builder Design Pattern in Java

### Problem Solved by the Builder Pattern

The Builder Pattern addresses problems related to object creation, especially when objects require many parameters, some mandatory and others optional. This pattern improves readability and reduces errors in constructing objects.

### Example of Builder Design Pattern in Java

```java
public class BuilderPatternExample {
    public static void main(String[] args) {
        Cake cake = new Cake.Builder()
                        .sugar(1)
                        .butter(0.5)
                        .eggs(2)
                        .build();
        System.out.println(cake);
    }
}

class Cake {
    private final double sugar;
    private final double butter;
    private final int eggs;

    private Cake(Builder builder) {
        this.sugar = builder.sugar;
        this.butter = builder.butter;
        this.eggs = builder.eggs;
    }

    public static class Builder {
        private double sugar;
        private double butter;
        private int eggs;

        public Builder sugar(double cup) {
            this.sugar = cup;
            return this;
        }

        public Builder butter(double cup) {
            this.butter = cup;
            return this;
        }

        public Builder eggs(int number) {
            this.eggs = number;
            return this;
        }

        public Cake build() {
            return new Cake(this);
        }
    }

    @Override
    public String toString() {
        return "Cake{" + "sugar=" + sugar + ", butter=" + butter + ", eggs=" + eggs + '}';
    }
}
```

### Output
```
Cake{sugar=1.0, butter=0.5, eggs=2}
```
```

Here's the complete markdown content, including the missing parts:

```markdown
# Builder Design Pattern in Java – Pros and Cons

The Builder pattern has several disadvantages, but the advantages clearly outweigh them. Below are the pros and cons of the Builder design pattern for creating objects in Java.

## Advantages
1. **More Maintainable**: If the number of fields required to create an object exceeds four or five, the Builder pattern enhances maintainability.
2. **Less Error-Prone**: Users are aware of what they are passing due to explicit method calls, reducing the likelihood of errors.
3. **More Robust**: Only fully constructed objects are available to the client, ensuring integrity.

## Disadvantages
1. **Verbose Code**: The Builder pattern can lead to verbose code and duplication since it requires copying all fields from the original or item class.

## When to Use Builder Design Pattern in Java
The Builder design pattern is a creational pattern and should be used when the number of parameters required in a constructor exceeds four or five. It’s essential not to confuse the Builder pattern with the Factory pattern; the Factory pattern can create different implementations of the same interface, whereas the Builder is tied to its container class and returns an object of the outer class.

## What is Static Factory Method or Factory Design Pattern
The Factory design pattern is used to create objects or classes in Java and provides loose coupling and high cohesion. It encapsulates the object creation logic, making it easier to change later if the object creation process changes or if new objects need to be introduced with a change in just one class. In the GoF pattern list, the Factory pattern is categorized as a Creation design pattern. The factory should be an interface, and clients should either create a factory or obtain one that will later be used to create objects.

### Example of Static Factory Method in JDK
A notable example of the Factory method design pattern is the `valueOf()` method in `String` and wrapper classes like `Integer` and `Boolean`, which is used for type conversion (e.g., from `String` to `Integer` or `String` to `Double`). Additional examples include:
- `getInstance()` method for creating instances of Singleton classes.
- `newInstance()` method for creating and returning new instances from the factory method each time it's called.

### Problems Solved by Factory Method Pattern in Java
In object-oriented languages, certain principles like abstraction and polymorphism are essential, and encapsulation and delegation are critical concepts. A well-designed system delegates tasks to different objects and incorporates encapsulation. However, frameworks often do not know what kind of object to create at runtime; they only know the interface or abstract class. Since we cannot instantiate interfaces or abstract classes, this creates a challenge. Using the `new` keyword directly violates the principle of programming to an interface rather than an implementation, resulting in inflexible code that is hard to maintain.

The Factory design pattern addresses this issue by modeling an interface for creating an object, allowing subclasses to decide which class to instantiate at creation time. It promotes loose coupling by eliminating the need to bind application-specific classes into the code. The factory methods are typically implemented as virtual methods, leading to the term "Virtual Constructor."

## When to Use Factory Design Pattern in Java
- Static Factory methods are common in frameworks where library code needs to create objects of types that may be subclassed by applications using the framework.
- If some or all concrete products can be created in multiple ways, or if future new creation methods may be desired.
- When products don't need to know how they are created.
- When creating an object of any one of the subclasses depends on the provided data.

### Code Example of Factory Design Pattern in Java
Here’s an example illustrating how the Factory pattern can be implemented in code to create multiple currency types (e.g., INR, SGD, USD), ensuring the code is extensible for new currencies.

```java
interface Currency {
    String getSymbol();
}

// Concrete Rupee Class
class Rupee implements Currency {
    @Override
    public String getSymbol() {
        return "Rs";
    }
}

// Concrete SGD Class
class SGDDollar implements Currency {
    @Override
    public String getSymbol() {
        return "SGD";
    }
}

// Concrete US Dollar Class
class USDollar implements Currency {
    @Override
    public String getSymbol() {
        return "USD";
    }
}

// Factory Class
class CurrencyFactory {
    public static Currency createCurrency(String country) {
        if (country.equalsIgnoreCase("India")) {
            return new Rupee();
        } else if (country.equalsIgnoreCase("Singapore")) {
            return new SGDDollar();
        } else if (country.equalsIgnoreCase("US")) {
            return new USDollar();
        }
        throw new IllegalArgumentException("No such currency");
    }
}

// Factory Client
public class Factory {
    public static void main(String args[]) {
        String country = args[0];
        Currency currency = CurrencyFactory.createCurrency(country);
        System.out.println(currency.getSymbol());
    }
}
```

## Advantages of Factory Method Pattern in Java
The Factory pattern is widely used across various frameworks, including JDK and open-source libraries. Key advantages include:
- **Decoupling**: The Factory method decouples the calling class from the target class, resulting in less coupled and highly cohesive code. For instance, JDBC doesn't require application code to know what database is being used.
- **Flexibility**: Subclasses can provide extended versions of an object. Creating an object within a factory is more flexible than direct creation in the client.
- **Consistency**: Promotes code consistency since every object is created using a factory rather than different constructors across clients.
- **Debugging**: Centralizes object creation, making code easier to debug and troubleshoot.
- **Interface Use**: Static factory methods enforce the use of interfaces, adhering to good practices.
- **Performance**: They can cache frequently used objects, eliminating duplicate object creation (e.g., `Boolean.valueOf()` caches true and false values).
- **Recommendation**: Recommended by Joshua Bloch in "Effective Java."

## Java Decorator Design Pattern
In this tutorial, we will cover:
- What is the decorator pattern in Java?
- When to use the decorator pattern in Java?
- How to use the decorator pattern in Java?
- Example of the decorator design pattern
- Advantages and disadvantages of the decorator pattern in Java

### What is the Decorator Design Pattern in Java?
- The Decorator design pattern enhances the functionality of a specific object at runtime or dynamically.
- Other instances of the same class remain unaffected, allowing individual objects to gain new behavior.
- It involves wrapping the original object through a decorator object.
- Based on abstract classes, concrete implementations are derived from them.
- It is a structural design pattern and widely used.

### Problems Solved by Decorator Pattern
The pattern allows adding functionality to individual objects dynamically, without affecting other instances of the same class. If a particular functionality is required for only some objects, the Decorator pattern provides a solution where specific behavior or state can be assigned at runtime.

### When to Use Decorator Pattern in Java
- When subclassing becomes impractical, leading to a large number of different possibilities for independent objects or combinations.
- To add functionality to individual objects at runtime.

### Code Example of Decorator Design Pattern
Below is a code example demonstrating the Decorator pattern in Java.

```java
// Component
public abstract class Currency {
    String description = "Unknown currency";

    public String getCurrencyDescription() {
        return description;
    }

    public abstract double cost(double value);
}

// Concrete Component
public class Rupee extends Currency {
    double value;

    public Rupee() {
        description = "Indian Rupees";
    }

    public double cost(double v) {
        value = v;
        return value;
    }
}

// Another Concrete Component
public class Dollar extends Currency {
    double value;

    public Dollar() {
        description = "Dollar";
    }

    public double cost(double v) {
        value = v;
        return value;
    }
}

// Decorator
public abstract class Decorator extends Currency {
    public abstract String getDescription();
}

// Concrete Decorator for USD
public class USDDecorator extends Decorator {
    Currency currency;

    public USDDecorator(Currency currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return currency.getCurrencyDescription() + ", it's US Dollar";
    }
}

// Another Concrete Decorator for SGD
public class SGDDecorator extends Decorator {
    Currency currency;

    public SGDDecorator(Currency currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return currency.getCurrencyDescription() + ", it's Singapore Dollar";
    }
}

// Main class to check currency
public class CurrencyCheck {
    public static void main(String[] args) {
        // Without adding decorators
        Currency curr = new Dollar();
        System.out.println(curr.getCurrencyDescription() + " dollar. " + curr.cost(2.0));

        // Adding decorators
        Currency curr2 = new USDDecorator(new Dollar());
        System.out.println(curr2.getDescription() + " dollar. " + curr2.cost(4.0));

        Currency curr3 = new SGDDecorator(new Dollar());
        System.out.println(curr3.getDescription() + " dollar. " + curr3.cost(4.0));
    }
}
```

### Explanation of the Code
- **Component Interface**: The `Currency` interface represents the component that can be decorated.
- **Concrete Component**: `Dollar` and `Rupee` are concrete implementations of the component that can be enhanced.
- **Decorator**: An abstract class that holds a reference to the component it decorates.
- **Concrete Decorators**: `USDDecorator` and `SGDDecorator` add specific behavior to the currency objects dynamically.

## Advantages of Decorator Design Pattern in Java
- **Flexibility**: More flexible than inheritance as it allows adding responsibilities at

 runtime.
- **Functionality Enhancement**: Modifies or enhances the functionality of objects dynamically.

## Disadvantage of Decorator Pattern
The main disadvantage is that maintaining the code can become a problem due to the proliferation of similar small objects (each decorator).

## Differences Between String, StringBuffer, and StringBuilder in Java

### String in Java
1. **Immutable**: Strings are immutable, allowing for benefits like cached hashcodes, making them efficient as `HashMap` keys.
2. **String Literals**: Defined with double quotes, created in the string pool.
3. **Comparison**: Using `==` on string literals returns true as they reference the same instance. Use `equals()` for proper comparisons.
4. **Concatenation**: The `+` operator is overloaded for string concatenation, internally using `StringBuffer` or `StringBuilder`.
5. **Character Array**: Backed by a character array and represented in UTF-16 format.
6. **Creation**: Strings can be created from various sources, including char arrays and other strings.
7. **Overridden Methods**: The `equals()` and `hashcode()` methods are overridden for proper comparison.

Here's the markdown content for the "Problem with String in Java" section:


### Problem with String in Java
One of the biggest strengths of Java's `String` class is its immutability, but this can also be a significant problem if not used correctly. Often, we create a `String` and then perform numerous operations on it, such as converting it to uppercase, lowercase, extracting substrings, or concatenating it with other strings. Since `String` is an immutable class, every operation creates a new `String`, discarding the older one. This leads to the creation of many temporary objects in the heap, resulting in increased memory usage and potential performance issues.

Additionally, `String` literals are stored in the String pool, which can further complicate memory management.

To address these problems, Java provides two alternative classes: `StringBuffer` and `StringBuilder`. 

- **StringBuffer**: This is the older class, designed for mutable strings, allowing modifications without creating new objects.
- **StringBuilder**: Introduced in JDK 5, `StringBuilder` offers similar functionality to `StringBuffer` but is not synchronized, making it more efficient for single-threaded scenarios.

Using `StringBuffer` or `StringBuilder` can significantly reduce memory overhead when performing multiple string operations.
```

Feel free to include this in your documentation!

Sure! Here's the content formatted in Markdown:

```markdown
# Differences between String and StringBuffer in Java

The main difference between `String` and `StringBuffer` is that `String` is immutable while `StringBuffer` is mutable. This means you can modify a `StringBuffer` object once you have created it without creating any new object. This mutable property makes `StringBuffer` an ideal choice for dealing with strings in Java. You can convert a `StringBuffer` into a `String` using its `toString()` method.

**String vs StringBuffer** or **what is the difference between StringBuffer and String** is one of the popular Java interview questions for either phone interviews or first rounds. Nowadays, they also include `StringBuilder` and ask about **String vs StringBuffer vs StringBuilder**, so be prepared for that. 

In the next section, we will see the difference between `StringBuffer` and `StringBuilder` in Java.

## Difference between StringBuilder and StringBuffer in Java

`StringBuffer` is very good with mutable strings, but it has one disadvantage: all its public methods are synchronized, which makes it thread-safe but, at the same time, slow. In JDK 5, a similar class called `StringBuilder` was introduced, which is a copy of `StringBuffer` but without synchronization. 

Try to use `StringBuilder` whenever possible; it performs better in most cases than the `StringBuffer` class. You can also use the `+` operator for concatenating two strings because the `+` operation is internally implemented using either `StringBuffer` or `StringBuilder` in Java. 

If you compare `StringBuilder` and `StringBuffer`, you will find that they are exactly similar, and all API methods applicable to `StringBuffer` are also applicable to `StringBuilder` in Java. On the other hand, **String vs StringBuffer** is completely different, and their APIs are also completely different; the same is true for **StringBuilder vs String**.

### Summary

In summary, here is a list of differences between `StringBuffer`, `String`, and `StringBuilder` in Java:

- `String` is immutable, while `StringBuffer` and `StringBuilder` are mutable objects.
- `StringBuffer` is synchronized while `StringBuilder` is not, which makes `StringBuilder` faster than `StringBuffer`.
- The concatenation operator `+` is internally implemented using either `StringBuffer` or `StringBuilder`.
- Use `String` if you require immutability, use `StringBuffer` if you need mutable + thread-safety, and use `StringBuilder` if you require mutable + without thread-safety.

---

# Reason Why wait(), notify(), and notifyAll() are in Object Class

Here are some thoughts on why they should not be in the `Thread` class, which makes sense to me:

1. `wait()` and `notify()` are not just normal methods or synchronization utilities; they are more than that—they are communication mechanisms between two threads in Java. The `Object` class is the correct place to make them available for every object if this mechanism is not available via any Java keyword like `synchronized`. Remember that `synchronized` and `wait`/`notify` are two different areas, and don’t confuse them as being the same or related. `synchronized` is to provide mutual exclusion and ensure thread safety, while `wait()` and `notify()` are communication mechanisms between threads.

2. Locks are made available on a per-object basis, which is another reason `wait()` and `notify()` are declared in the `Object` class rather than the `Thread` class.

In Java, in order to enter the critical section of code, threads need a lock and they wait for a lock. They don't know which thread holds the lock; instead, they just know that a lock is held by some thread and they should wait for that lock. This analogy fits with `wait()` and `notify()` being on the `Object` class rather than `Thread` in Java.

## Why wait(), notify(), and notifyAll() are called from synchronized blocks or methods in Java

We use `wait()` and `notify()` or `notifyAll()` methods mostly for inter-thread communication. One thread is waiting after checking a condition (e.g., in the Producer-Consumer example, the Producer thread is waiting if the buffer is full, and the Consumer thread notifies the Producer thread after creating space in the buffer by consuming an element). 

Calling `notify()` or `notifyAll()` issues a notification to a single or multiple threads that a condition has changed. Once the notifying thread leaves the synchronized block, all the threads that are waiting fight for the object lock on which they are waiting, and the lucky thread returns from the `wait()` method after reacquiring the lock and proceeds further.

Let’s divide this operation into steps to see a possibility of a race condition between `wait()` and `notify()` in Java, using the Producer-Consumer example to understand the scenario better:

1. The Producer thread tests the condition (whether the buffer is full or not) and confirms that it must wait (after finding the buffer is full).
2. The Consumer thread sets the condition after consuming an element from the buffer.
3. The Consumer thread calls the `notify()` method; this goes unheard since the Producer thread is not yet waiting.
4. The Producer thread calls the `wait()` method and goes into the waiting state.

Due to this race condition, there is a potential loss of notification, and if we use a buffer of just one element, the Producer thread will be waiting forever, causing your program to hang.

### Resolving Potential Race Condition

This potential race condition is resolved by using the `synchronized` keyword and the locking provided by Java. In order to call the `wait()`, `notify()`, or `notifyAll()` methods in Java, we must have obtained the lock for the object on which we're calling the method. Since the `wait()` method in Java also releases the lock prior to waiting and reacquires the lock before returning from the `wait()` method, we must use this lock to ensure that checking the condition (whether the buffer is full or not) and setting the condition (taking an element from the buffer) are atomic operations, which can be achieved using a synchronized method or block in Java.

I am not sure if this is what the interviewer was actually expecting, but this is what I thought would at least make sense. Please correct me if I'm wrong, and let us know if there is any other convincing reason for calling `wait()`, `notify()`, or `notifyAll()` methods in Java.

### Summary of Reasons

We call `wait()`, `notify()`, or `notifyAll()` methods in Java from synchronized methods or synchronized blocks to avoid:

- `IllegalMonitorStateException` in Java, which will occur if we don't call `wait()`, `notify()`, or `notifyAll()` methods from a synchronized context.
- Any potential race condition between `wait()` and `notify()` methods in Java.

---

# Difference between Enumeration and Iterator

The only major difference between `Enumeration` and `Iterator` is that `Iterator` has a `remove()` method while `Enumeration` doesn't. `Enumeration` acts as a read-only interface because it has methods only to traverse and fetch objects, whereas using `Iterator` allows manipulation of objects, such as adding and removing them from a collection (e.g., `ArrayList`). 

Also, `Iterator` is more secure and safe compared to `Enumeration` because it does not allow other threads to modify the collection object while some thread is iterating over it and throws `ConcurrentModificationException`.

In summary, both `Enumeration` and `Iterator` provide successive elements, but `Iterator` is a new and improved version where method names are shorter and includes a new method called `remove`. Here is a short comparison:

| Enumeration               | Iterator                  |
|---------------------------|---------------------------|
| `hasMoreElements()`       | `hasNext()`               |
| `nextElement()`           | `next()`                  |
| N/A                       | `remove()`                |

So, `Enumeration` is used whenever we want to make collection objects read-only.

---

# Difference between Fail-Fast Iterator and Fail-Safe Iterator in Java

## Fail-Fast Iterators in Java

As the name suggests, fail-fast iterators fail as soon as they realize that the structure of the collection has been changed since the iteration began. Structural changes mean adding, removing, or updating any element from the collection while one thread is iterating over that collection. 

Fail-fast behavior is implemented by keeping a modification count, and if the iteration thread detects a change in the modification count, it throws `ConcurrentModificationException`. The Java documentation states that this is not guaranteed behavior; instead, it is done on a "best effort basis," so application programming cannot rely on this behavior. 

Fail-fast iterators are returned by most of JDK1.4 collections, including `Vector`, `ArrayList`, and `HashSet`.

## Fail-Safe Iterators in Java

Contrary to fail-fast iterators, fail-safe iterators do not throw any exception if the collection is modified structurally while one thread is iterating over it because they work on a clone of the collection instead of the original collection. This is why they are called fail-safe iterators. 

An example of a fail-safe iterator is the iterator of `CopyOnWriteArrayList`. Iterators written by `ConcurrentHashMap`’s `keySet` are also fail-safe iterators and never throw `ConcurrentModificationException` in Java.

---

# How HashMap Works in Java

Understanding how `HashMap` works in Java, or how the `get()` method works in `HashMap`, is a common question in Java interviews nowadays. Almost everybody who has worked in Java knows about `HashMap`, its uses, and the difference between `

Hashtable` and `HashMap`. So why does this interview question become so special? Because of the depth it offers, it has become a very popular Java interview question in almost any senior or mid-senior level Java interviews.

## Introduction to HashMap

Questions usually start with simple statements like, "Have you used `HashMap` before?" or "What is `HashMap`? Why do we use it?" Almost everybody answers this with "yes," and then the interviewee continues to talk about common facts about `HashMap`, like how `HashMap` accepts null while `Hashtable` doesn't, that `HashMap` is not synchronized, and so on, along with the basics, such as how it stores key and value pairs.

This shows that the person has used `HashMap` and is quite familiar with the functionality it offers, but the interview takes a sharp turn from here, and the next set of follow-up questions gets more detailed about the fundamentals involved with `HashMap` in Java. 

### Common Interview Questions

1. **"Do you know how HashMap works in Java?"**
   - A good response would be: "HashMap works on the principle of hashing. We use the `put(key, value)` and `get(key)` methods for storing and retrieving objects from `HashMap`. When we pass a key and value object to the `put()` method on Java `HashMap`, it calls the `hashCode` method on the key object and applies the returned hashcode into its own hashing function to find a bucket location for storing the entry object. It’s important to mention that `HashMap` in Java stores both key and value objects as `Map.Entry` in the bucket, which is essential to understand the retrieval logic."

2. **"What will happen if two different objects have the same hashcode?"**
   - A typical answer would be that since the hashcode is equal, both objects are equal, which is incorrect. The candidate should mention that two unequal objects can have the same hashcode due to the `equals()` and `hashCode()` contract. 

3. **"How will you retrieve the value object if two keys have the same hashcode?"**
   - A candidate might say that we call the `get()` method, and then `HashMap` uses the key object's hashcode to find the bucket location and retrieve the value object. However, if there are two value objects stored in the same bucket, the candidate needs to clarify that the `equals()` method is called on the key to identify the correct node in the linked list and return the associated value object for that key.

4. **"What happens if the size of the HashMap exceeds a given threshold defined by the load factor?"**
   - The candidate should explain that if the size of the map exceeds the threshold defined by the load factor (e.g., 0.75), it will act to resize the map once it is filled to 75%. Similar to other collection classes like `ArrayList`, `HashMap` resizes itself by creating a new bucket array that is twice the size of the previous one and then starts putting every old element into that new bucket array. This process is called rehashing because it also applies the hash function to find the new bucket location.

5. **"Do you see any problem with resizing of HashMap in Java?"**
   - The candidate should recognize that there is a potential race condition while resizing `HashMap` in Java. If two threads find that `HashMap` needs resizing at the same time, both may attempt to resize, which can lead to the elements in the bucket being reversed in order during their migration to the new bucket. If a race condition occurs, this could potentially lead to an infinite loop.

### Additional Questions

- **Why are String, Integer, and other wrapper classes considered good keys?**
  - These are good candidates for `HashMap` keys because they are immutable, final, and override `equals()` and `hashCode()` methods properly. Immutability is required to prevent changes in fields used to calculate `hashCode()`, which is crucial for successful retrieval.

- **Can we use any custom object as a key in HashMap?**
  - Yes, any object can be used as a key in Java `HashMap` provided it follows the `equals` and `hashCode` contract, and its `hashCode` should not vary once the object is inserted into the map.

- **Can we use `ConcurrentHashMap` in place of `Hashtable`?**
  - Yes, `ConcurrentHashMap` is designed as a replacement for `Hashtable` and provides better concurrency by only locking a portion of the map determined by the concurrency level.

### Summary of Key Points

The questions surrounding `HashMap` in Java verify concepts such as:

- The principle of hashing
- Collision resolution in `HashMap`
- The use of `equals()` and `hashCode()` and their importance in `HashMap`
- The benefits of immutable objects
- Potential race conditions in `HashMap`
- Resizing behavior of `HashMap`

This overview covers the significant concepts and potential interview questions related to `String`, `StringBuffer`, `StringBuilder`, `wait()`, `notify()`, `Iterator`, `HashMap`, and their differences in Java.
```

Feel free to modify or add any additional sections as needed!
