### What is Java Class?
A Java class is a template for the objects you are going to create; it’s a blueprint from which you create an object. In simple terms, we can say it’s a specification or pattern that we define, and every object we create will follow that pattern.

### What does Java Class Consist of?
- When we create a class in Java, the first step is the keyword `class`, followed by the name of the class (identifier).
- Next is the class body, which starts with curly braces `{}`. Between these braces, we define all the properties and methods related to that class.

**Template:**
```java
Class (name of the class) {
    // (Define members of the class here)
}
```

### Access Level of Class
Java classes have mainly two types of access levels:
- **Default**: Class objects are accessible only inside the package.
- **Public**: Class objects are accessible in code in any package.

### What are Members of a Class?
A class is incomplete without defining its members, just like a family is incomplete without its members.
- **Field**: A field is the property of the class or object being created. For example, if we create a class called `Computer`, its properties might include `model`, `mem_size`, `hd_size`, `os_type`, etc.
- **Method**: A method defines the operations that an object can perform. It defines the behavior of the object and how it can interact with the outside world. Examples: `startMethod()`, `shutdownMethod()`.
- **Access Level of Members**: Each field and method has an access level:
  - `private`: Accessible only within this class.
  - `package` or `default`: Accessible only within this package.
  - `protected`: Accessible only within this package and in all subclasses of this class.
  - `public`: Accessible everywhere this class is available.

### Real World Example of Class in Java Programming
In the real world, we can visualize a class as representing everything of the same quality, such as men, women, birds, bicycles, cars, or vehicles. 

For instance, the entire vehicle class would have properties like `no_of_wheels`, `color`, `model`, `brand`, etc. Methods could include `changeGear()`, `speedOfVehicle()`, `applyBrake()`, etc. Similarly, all human beings can be considered one class, with members like men, women, and children. Methods such as `isAlive()` and `isDead()` could define their behaviors. We can also create separate classes for Men and Women, defining their properties and methods accordingly.

In short, in Java, every problem we encounter can be thought of in terms of classes and objects.

### One Java Class Example
```java
class Stock {
    public String commodity;
    public double price;

    public void buy(int no_of_commodity) {
        // Buying logic
    }

    public boolean sale() {
        // Selling logic
        return true;
    }
}
```
In this example, `Stock` is the class, and `commodity` and `price` are fields. The methods `buy()` and `sale()` are defined inside the class. To access elements of the class, you need to create an instance of the `Stock` class. You can create an instance using the `new` keyword as shown below:

```java
Stock highBetaStock = new Stock();
```

To call methods of `Stock`, use the instance:
```java
highBetaStock.buy(1000);
highBetaStock.sale();
```

### Summary
In short, in Java, everything must be thought of in terms of classes. A class is a template that has its own members and methods for accessing those members. Each member has its own visibility, which is decided by the developer based on where they want to use those objects.

### How to Make Thread-Safe Code in Java

#### Example of Non Thread-Safe Code in Java

Here is an example of non thread-safe code, look at the code and find out why this code is not thread safe?

```java
/*
 * Non Thread-Safe Class in Java
 */
public class Counter {  
    private int count;  
    /*
     * This method is not thread-safe because ++ is not an atomic operation
     */
    public int getCount(){
        return count++;
    }
}
```
Above example is not thread-safe because `++` (increment operator) is not an atomic operation and can be broken down into read, update, and write operations. If multiple threads call `getCount()` approximately at the same time, each of these three operations may coincide or overlap with each other. For example, while thread 1 is updating the value, thread 2 reads and still gets the old value, which eventually lets thread 2 override thread 1's increment, and one count is lost because multiple threads called it concurrently.

### How to Make Code Thread-Safe in Java

There are multiple ways to make this code thread safe in Java:

1. Use the `synchronized` keyword in Java and lock the `getCount()` method so that only one thread can execute it at a time, which removes the possibility of coinciding or interleaving.
2. Use `AtomicInteger`, which makes this `++` operation atomic, and since atomic operations are thread-safe, it saves the cost of external synchronization.

Here is a thread-safe version of the Counter class in Java:

```java
/*
 * Thread-Safe Example in Java
 */
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int count;
    AtomicInteger atomicCount = new AtomicInteger(0);
    
    /*
     * This method is thread-safe now because of locking and synchronization
     */
    public synchronized int getCount(){
        return count++;
    }  
    
    /*
     * This method is thread-safe because count is incremented atomically
     */
    public int getCountAtomically(){
        return atomicCount.incrementAndGet();
    }
}
```

### Important Points about Thread-Safety in Java
Here are some points worth remembering to write thread-safe code in Java. This knowledge also helps you avoid some serious concurrency issues in Java, like race conditions or deadlocks:

1. Immutable objects are by default thread-safe because their state cannot be modified once created. Since String is immutable in Java, it’s inherently thread-safe.
2. Read-only or final variables in Java are also thread-safe.
3. Locking is one way of achieving thread-safety in Java.
4. Static variables, if not synchronized properly, become a major cause of thread-safety issues.
5. Examples of thread-safe classes in Java: `Vector`, `Hashtable`, `ConcurrentHashMap`, `String`, etc.
6. Atomic operations in Java are thread-safe, e.g., reading a 32-bit int from memory because it’s an atomic operation; it can't interleave with other threads.
7. Local variables are also thread-safe because each thread has its own copy, and using local variables is a good way to write thread-safe code in Java.
8. To avoid thread-safety issues, minimize sharing of objects between multiple threads.
9. The `volatile` keyword in Java can also be used to instruct threads not to cache variables and read from main memory. It can also instruct the JVM not to reorder or optimize code from a threading perspective.

### 2 Ways to Find if a Thread Holds Lock on an Object in Java
Here are my thoughts and discoveries after an interview:

1. I thought about `IllegalMonitorStateException`, which `wait()` and `notify()` methods throw when they are called from a non-synchronized context. So I said I would call `newspaper.wait()` and if this call throws an exception, it means the thread in Java is not holding the lock; otherwise, the thread holds the lock.
2. Later, I discovered that there is a static method called `holdsLock(Object obj)` that returns true or false based on whether a thread holds a lock on the object passed.

### Wait vs Sleep vs Yield in Java

#### Difference between Wait and Sleep in Java
The main difference between `wait()` and `sleep()` is that the `wait()` method releases the acquired monitor when the thread is waiting, while the `Thread.sleep()` method keeps the lock or monitor even if the thread is waiting. Additionally, the `wait` method in Java should be called from a synchronized method or block, while there is no such requirement for the `sleep()` method. Another difference is that `Thread.sleep()` is a static method and applies to the current thread, while `wait()` is an instance-specific method and only wakes up if some other thread calls the `notify` method on the same object. 

Furthermore, in the case of `sleep`, the sleeping thread immediately goes to the Runnable state after waking up, while in the case of `wait`, the waiting thread first acquires the lock and then goes into the Runnable state. So, based on your need, if you require a specified second of pause, use the `sleep()` method, or if you want to implement inter-thread communication, use the `wait` method.

Here is a list of differences between `wait` and `sleep` in Java:

1. `wait` is called from a synchronized context only, while `sleep` can be called without a synchronized block. (See Why `wait` and `notify` needs to be called from a synchronized method for more details.)
2. `wait` is called on an Object while `sleep` is called on a Thread. (See Why `wait` and `notify` are defined in the Object class instead of Thread.)
3. A waiting thread can be awakened by calling `notify` and `notifyAll`, while a sleeping thread cannot be awakened by calling the notify method.
4. `wait` is normally done on a condition; a thread waits until a condition is true, while `sleep` is just to put your thread to sleep.
5. `wait` releases the lock on the object while waiting, while `sleep` doesn’t release the lock while waiting.

### Difference between Yield and Sleep in Java
The major difference between `yield` and `sleep` in Java is that the `yield()` method pauses the currently executing thread temporarily to give a chance to the remaining waiting threads of the same priority to execute. If there are no waiting threads, or if all the waiting threads have a lower priority, then the same thread will continue its execution. The yielded thread’s next execution chance is determined by the thread scheduler, whose behavior is vendor-dependent. The `yield` method doesn’t guarantee that the current thread will pause or stop, but it guarantees that the CPU will be relinquished by the current thread as a result of the call to `Thread.yield()` method in Java.

The `sleep` method in Java has two variants: one that takes milliseconds as sleeping time and another that takes both milliseconds and nanoseconds for sleeping duration.

- `sleep(long millis)`
- `sleep(long millis, int nanos)`

These cause the currently executing thread to sleep for the specified number of milliseconds plus the specified number of nanoseconds.

### Example of Thread Sleep Method in Java
Here is a sample code example of the Sleep Thread in Java. In this example, we have put the Main thread to sleep for 1 second.
```java
/*
 * Example of Thread Sleep method in Java
 */
public class SleepTest {
      
       public static void main(String... args){
              System.out.println(Thread.currentThread().getName() + " is going to sleep for 1 Second");
              try {
                     Thread.currentThread().sleep(1000);
              } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
              System.out.println("Main Thread is woken now");
       }
}
```
**Output:**
```
main is going to sleep for 1 Second
Main Thread is woken now
```

### 10 Points about Thread sleep() Method in Java
Here are some important points to remember about the `sleep()` method of the Thread Class in Java:
1. `Thread.sleep()` method is used to pause execution, relinquish the CPU, and return it to the thread scheduler.
2. `Thread.sleep()` method is a static method and always puts the current thread to sleep.
3. Java has two variants of the sleep method in the Thread class: one with one argument that takes milliseconds as the duration for sleep, and another method with two arguments, one for milliseconds and the other for nanoseconds.
4. Unlike the `wait()` method in Java, the `sleep()` method of the Thread class doesn't relinquish the lock it has acquired.
5. The `sleep()` method throws an `InterruptedException` if another thread interrupts a sleeping thread in Java.
6. With `sleep()` in Java, it’s not guaranteed that when the sleeping thread wakes up, it will definitely get the CPU. Instead, it will go to the Runnable state and compete for CPU with other threads.
7. There is a misconception about the `sleep` method in Java that calling `t.sleep()` will put Thread "t" into the sleeping state. That's not true because `Thread.sleep` is a static method; it always puts the current thread into the sleeping state and not thread "t".

### NoClassDefFoundError vs ClassNotFoundException
Before seeing the differences between `ClassNotFoundException` and `NoClassDefFoundError`, let's look at some similarities that are the main reasons for confusion between these two errors:

1. Both `NoClassDefFoundError` and `ClassNotFoundException` are related to the unavailability of a class at runtime.
2. Both `ClassNotFoundException

` and `NoClassDefFoundError` are related to the Java classpath.

Now let's see the difference between `NoClassDefFoundError` and `ClassNotFoundException`:

1. `ClassNotFoundException` occurs in Java if we try to load a class at runtime using `Class.forName()`, `ClassLoader.loadClass()`, or `ClassLoader.findSystemClass()` method, and the requested class is not available in Java. Most of the time, it seems like we have the class in the classpath, but it turns out to be an issue related to the classpath. The application may not be using the classpath that we think it is using (e.g., classpath defined in a jar's manifest file takes precedence over the `CLASSPATH` or `-cp` option). For more details, see "How classpath works in Java." On the other hand, `NoClassDefFoundError` is different; in this case, the culprit class was present during compile time, allowing the application to compile and link successfully but not available during runtime due to various reasons.
2. `ClassNotFoundException` is a checked Exception derived directly from `java.lang.Exception` class, and you need to provide explicit handling for it, while `NoClassDefFoundError` is an Error derived from `LinkageError`.
3. If you are using `ClassLoader` in Java and have two class loaders, if a ClassLoader tries to access a class loaded by another class loader, it will result in `ClassNotFoundException`.
4. `ClassNotFoundException` arises when there is explicit loading of a class involved by providing the name of the class at runtime using `ClassLoader.loadClass` or `Class.forName`, while `NoClassDefFoundError` is a result of implicit loading of a class because of a method call from that class or any variable access.

### Comparator vs Comparable in Java

Comparators and Comparable in Java are two interfaces used to implement sorting in Java. It’s often required to sort objects stored in any collection classes like ArrayList, HashSet, or in arrays. That’s when we need to use either `compare()` or `compareTo()` method defined in `java.util.Comparator` and `java.lang.Comparable`.

Here are some common differences worth remembering for interviews:

1. **Package Definition**: Comparator in Java is defined in the `java.util` package, while Comparable is defined in the `java.lang` package, indicating that Comparator is a utility for sorting, whereas Comparable provides default sorting.
  
2. **Method Definition**: The Comparator interface has the method `public int compare(Object o1, Object o2)`, which returns a negative integer, zero, or a positive integer based on the comparison. In contrast, Comparable has the method `public int compareTo(Object o)`, which compares "this" object with the specified object.

3. **Comparison Logic**: Comparator compares two objects provided to it, while Comparable compares "this" reference with the specified object.

4. **Natural Ordering**: Comparable is used to implement the natural ordering of an object. In Java API, String, Date, and wrapper classes implement Comparable. It’s always a good practice to override `compareTo()` for value objects.

5. **Automatic Sorting**: If a class implements the Comparable interface, collections of that object (either List or Array) can be sorted automatically using `Collections.sort()` or `Arrays.sort()` based on their natural order defined by the `compareTo()` method.

6. **Use as Keys**: Objects implementing Comparable can be used as keys in a SortedMap like TreeMap or elements in a SortedSet like TreeSet without specifying any Comparator.

These are a mix of theoretical and practical differences between the Comparator and Comparable interfaces in Java. This will help you decide when to use Comparator vs Comparable. Let’s see an example of using both:

### Example of Using Comparator and Comparable in Java

In summary, if you want to sort objects based on natural order, use Comparable. If you want to sort by some other attribute, use Comparator. 

**Person Class Example**:
1. Sort the Person based on `person_id`, which is a primary key in the database.
2. Sort the Person based on their name.

For a Person class, sorting based on `person_id` can be treated as natural order sorting, while sorting based on the name field can be implemented using the Comparator interface. 

**Sorting by person_id using Comparable**:
```java
public class Person implements Comparable {
    private int person_id;
    private String name;

    /**
     * Compare current person with specified person.
     * Return zero if person_id for both persons is the same.
     * Return negative if current person_id is less than specified one.
     * Return positive if specified person_id is greater than specified one.
     */
    @Override 
    public int compareTo(Object o) {
        Person p = (Person) o; 
        return this.person_id - p.person_id;
    }
    // other methods...
}
```
*Note: Generally, you should avoid using the difference of integers to decide the output of `compareTo()` as it can overflow. But if you're sure both operands are positive, it’s one of the quickest ways to compare two objects.*

**Sorting by name using Comparator**:
```java
/**
 * Comparator implementation which sorts Person objects on person_id field.
 */
public class SortByPerson_ID implements Comparator {

    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2; 
        return p1.getPersonId() - p2.getPersonId();
    }
}
```
*Similar guidelines apply while implementing `compare()` method. Instead of using subtraction, it’s better to use logical operators to compare whether two integers are equal to, less than, or greater than.*

### How to Compare String in Java

String is immutable in Java and one of the most used value classes. For comparing Strings, you don’t need to worry because String implements Comparable and provides a lexicographic implementation for the `compareTo` method. You just need to call `String.compareTo(AnotherString)`, and Java will determine whether the specified String is greater than, equal to, or less than the current object.

### How to Compare Dates in Java

Dates are represented by `java.util.Date` class in Java. Like String, Date also implements Comparable, so they will be automatically sorted based on their natural ordering if stored in any sorted collection like TreeSet or TreeMap. To explicitly compare two dates, you can call `Date.compareTo(AnotherDate)` method, which will tell you whether the specified date is greater than, equal to, or less than the current date.

### When to Use Comparator and Comparable in Java

Here are some best practices and recommendations on when to use Comparator or Comparable in Java:

1. If there is a natural or default way of sorting an object that already exists during the development of the class, then use Comparable. This is intuitive, and given the class name, people should be able to guess correctly (e.g., Strings are sorted chronologically, Employees can be sorted by their ID, etc.). If an object can be sorted in multiple ways and the client specifies on which parameter sorting should take place, then use the Comparator interface.

2. Sometimes you write code to sort objects of a class for which you are not the original author, or you don't have access to the code. In these cases, you cannot implement Comparable, and Comparator is the only way to sort those objects.

3. Be aware of how those objects will behave if stored in SortedSet or SortedMap like TreeSet and TreeMap. If an object doesn't implement Comparable, always provide a corresponding Comparator when putting them into a SortedMap.

4. The order of comparison is very important while implementing Comparable or Comparator interface. For example, if you are sorting an object based on name, you can compare first name or last name in any order, so decide judiciously.

5. Comparator has the distinct advantage of being self-descriptive. For example, if you are writing a Comparator to compare two Employees based on their salary, name that comparator as `SalaryComparator`. 

## Observer Design Pattern Java Code Example

### What is Observer Design Pattern?
The Observer design pattern in Java is a crucial pattern used to observe changes in objects. If you want to be notified of changes in a particular object, you can observe that object, and the changes will be communicated to you. The object being observed is referred to as the **Subject**, and the classes that observe the subject are called **Observers**. This is a powerful pattern used heavily in conjunction with the Model-View-Controller (MVC) design pattern, where changes in the model are propagated to the view, allowing it to render updated information. The Observer pattern is a popular topic in Java interviews, especially for mid-senior to senior levels.

### Problem Solved by Observer Pattern:
If there's a requirement where a specific object changes its state and based on these changes, some or a group of objects need to change their state automatically, the Observer pattern can be implemented to reduce coupling between objects. 

In real-world scenarios, consider when you subscribe to a new phone connection. Whenever a customer registers with a company, all other departments are notified accordingly, and depending on the state, they perform their jobs, like verifying the customer's address and dispatching the welcome kit.

### How Observer Design Pattern is Implemented in Java
Java simplifies the implementation of this pattern. In the `java.util` package, you can find interfaces, classes, and methods for implementing this pattern.

**Public Interface Observer:**
- Any class implementing this interface must be notified when the subject or observable object changes its status.
- `update(Observable ob, Object arg)`: This method is called when the subject changes.

**Class Observable:**
- It acts as the subject that observers want to monitor.

### Some Important Methods:
- `addObserver(Observer o)`: Adds observers to the set of observers for this subject or observable object.
- `deleteObserver(Observer o)`: Deletes observers from the set of observers.
- `hasChanged()`: Checks if the object has changed.
- `clearChanged()`: Indicates that the subject has no changes or that all observers have been notified of the changes.
- `notifyObservers()`: Notifies all observers if the object has changed.

### Code Example of Observer Design Pattern in Java:
The Observer design pattern is quite generic in how it can be implemented in Java. You can use `java.util.Observable` or `java.util.Observer`, or you can create your own Subject and Observer interfaces. I prefer creating my own interfaces, as illustrated in the following example:

In this example, we have a Loan object that can change its interest rate. When it changes, the Loan notifies the Newspaper or Internet media to display the new loan interest rate. The implementation includes a Subject interface with methods for adding, removing, and notifying Observers, and an Observer interface containing the `update(int interest)` method that gets called when the interest rate changes.

```java
import java.util.ArrayList;

interface Observer {
    public void update(float interest);
}

interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}

class Loan implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private String type;
    private float interest;
    private String bank;

    public Loan(String type, float interest, String bank) {
        this.type = type;
        this.interest = interest;
        this.bank = bank;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
        notifyObservers();
    }

    public String getBank() {
        return this.bank;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            System.out.println("Notifying Observers of change in Loan interest rate");
            ob.update(this.interest);
        }
    }
}

class Newspaper implements Observer {
    @Override
    public void update(float interest) {
        System.out.println("Newspaper: Interest Rate updated, new Rate is: " + interest);
    }
}

class Internet implements Observer {
    @Override
    public void update(float interest) {
        System.out.println("Internet: Interest Rate updated, new Rate is: " + interest);
    }
}

public class ObserverTest {
    public static void main(String args[]) {
        Newspaper printMedia = new Newspaper();
        Internet onlineMedia = new Internet();
        Loan personalLoan = new Loan("Personal Loan", 12.5f, "Standard Chartered");
        personalLoan.registerObserver(printMedia);
        personalLoan.registerObserver(onlineMedia);
        personalLoan.setInterest(3.5f);
    }
}
```

### Advantage of Observer Design Pattern in Java:
The main advantage is loose coupling between the observer and observable objects. The subject only knows the list of observers; it does not care about their implementation. All observers are notified by the subject in a single event call, similar to broadcast communication.

### Disadvantages of Observer Design Pattern in Java:
- Debugging can be challenging if issues arise, as the control flow is implicit between observers and the observable. If there’s a chain of observers, debugging becomes more complex.
- Memory management can be an issue since the subject holds references to all observers. If we do not unregister observers, it may lead to memory issues.

---

## What Problem Builder Pattern Solves in Java
The Builder pattern is a creational design pattern that addresses object creation problems. Constructors in Java are used to create objects and can take parameters required for that purpose. However, problems arise when an object can be created with many parameters, some mandatory and others optional. 

For example, consider a class used to create a Cake. You need various ingredients like eggs, milk, and flour, some of which are mandatory, while others, like cherries and fruits, are optional. Overloaded constructors for different types of cakes can lead to too many constructors and potential errors.

### Problems:
1. Too many constructors to maintain.
2. Error-prone due to many fields of the same type (e.g., sugar and butter are both in cups).

You can partially solve this by creating a Cake and then adding ingredients, but this approach can leave the object in an inconsistent state during building. Ideally, the cake should not be available until it is fully created. Both problems can be solved using the Builder design pattern, which improves readability and reduces the chance of error by adding ingredients explicitly and ensuring the object is only available once fully constructed.

## Example of Builder Design Pattern in Java
We will continue with the cake example, using the Builder design pattern. Here, we have a static nested Builder class inside the Cake class, which is used to create the object.

### Guidelines for Builder Design Pattern in Java
1. Create a static nested class called Builder inside the class whose object will be built (in this example, it's Cake).
2. The Builder class will have the same set of fields as the original class.
3. The Builder class will expose methods for adding ingredients (e.g., `sugar()`). Each method will return the same Builder object, allowing for chaining.
4. The `build()` method will copy all builder field values into the actual class and return an object of the Item class.
5. The Item class (the class for which we are creating the Builder) should have a private constructor to enforce object creation through the builder.

```java
public class BuilderPatternExample {
  
    public static void main(String args[]) {
        // Creating object using Builder pattern in Java
        Cake whiteCake = new Cake.Builder()
            .sugar(1)
            .butter(0.5)
            .eggs(2)
            .vanilla(2)
            .flour(1.5)
            .bakingPowder(0.75)
            .milk(0.5)
            .build();

        // Cake is ready to eat :)
        System.out.println(whiteCake);
    }
}

class Cake {

    private final double sugar;   // cup
    private final double butter;  // cup
    private final int eggs;
    private final int vanilla;     // spoon
    private final double flour;   // cup
    private final double bakingPowder; // spoon
    private final double milk;  // cup
    private final int cherry;

    public static class Builder {

        private double sugar;   // cup
        private double butter;  // cup
        private int eggs;
        private int vanilla;     // spoon
        private double flour;   // cup
        private double bakingPowder; // spoon
        private double milk;  // cup
        private int cherry;

        // Builder methods for setting properties
        public Builder sugar(double cup) { this.sugar = cup; return this; }
        public Builder butter(double cup) { this.butter = cup; return this; }
        public Builder eggs(int number) { this.eggs = number; return this; }
        public Builder vanilla(int spoon) { this.vanilla = spoon; return this; }
        public Builder flour(double cup) { this.flour = cup; return this; }
        public Builder bakingPowder(double spoon) { this.bakingPowder = spoon; return this; }
        public Builder milk(double cup) { this.milk = cup; return this; }
        public Builder cherry(int number) { this.cherry = number; return this; }
      
        // Return fully built object
        public Cake build() {
            return new Cake(this);
        }
    }

    // Private constructor to enforce object creation through builder
    private

 Cake(Builder builder) {
        this.sugar = builder.sugar;
        this.butter = builder.butter;
        this.eggs = builder.eggs;
        this.vanilla = builder.vanilla;
        this.flour = builder.flour;
        this.bakingPowder = builder.bakingPowder;
        this.milk = builder.milk;
        this.cherry = builder.cherry;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "sugar=" + sugar +
                ", butter=" + butter +
                ", eggs=" + eggs +
                ", vanilla=" + vanilla +
                ", flour=" + flour +
                ", bakingPowder=" + bakingPowder +
                ", milk=" + milk +
                ", cherry=" + cherry +
                '}';
    }
}
```

# Builder Design Pattern in Java

## Pros and Cons of the Builder Design Pattern
The Builder pattern has several advantages that often outweigh its disadvantages:

### Advantages:
1. **Maintainability**: More maintainable when the number of fields required to create an object exceeds four or five.
2. **Less Error-Prone**: Reduces errors as users explicitly know what they are passing through method calls.
3. **Robustness**: Ensures that only fully constructed objects are available to clients.

### Disadvantages:
1. **Verbosity**: Can lead to verbose code and duplication since the Builder needs to copy all fields from the original or item class.

## When to Use the Builder Design Pattern
The Builder pattern is a creational pattern that is ideal when the number of parameters required in the constructor is more than four or five. It's important to distinguish between the Builder and Factory patterns; while Factory can create different implementations of the same interface, Builder is tied to its container class and returns only the object of the outer class.

---

# Factory Design Pattern in Java

## What is the Factory Design Pattern?
The Factory pattern is used to create objects in Java and provides loose coupling and high cohesion. It encapsulates the object creation logic, making it easier to change how objects are created or to introduce new objects with minimal changes.

## Example of Static Factory Method in JDK
A common example of the Factory method design pattern is the `valueOf()` method in the `String` and wrapper classes like `Integer` and `Boolean`, which are used for type conversion.

### Other Examples Include:
- `getInstance()` method for creating instances of Singleton classes.
- `newInstance()` method for creating new instances each time it's called.

## Problems Solved by the Factory Method Pattern
- **Object Creation**: When the application or framework does not know what kind of object to create at runtime, it can only be aware of the interface or abstract class.
- **Hard-Coded Dependencies**: Factory pattern addresses the problem of hard-coded object creation, promoting loose coupling by eliminating the need to bind application-specific classes into the code.

## When to Use the Factory Design Pattern
- Common in frameworks where the library code needs to create objects that may be subclassed by applications.
- When the concrete products can be created in multiple ways, or there may be future extensions for creating concrete products.
- When products don't need to know how they are created.
- When creating an object of a subclass based on provided data.

### Code Example of Factory Design Pattern in Java
Here's a code example to demonstrate the Factory pattern for creating different currency types:

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

// Concrete USD Class
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

// Factory Client Code
public class Factory {
    public static void main(String args[]) {
        String country = args[0];
        Currency currency = CurrencyFactory.createCurrency(country);
        System.out.println(currency.getSymbol());
    }
}
```

### Advantages of the Factory Method Pattern
- **Decoupling**: Decouples the calling class from the target class, resulting in less coupled and more cohesive code. For example, JDBC allows the application code to interact with different database types without knowing the specifics of the database drivers.
- **Flexibility**: Enables subclasses to provide extended versions of an object.
- **Consistency**: Promotes consistent object creation since all objects are created through the factory.
- **Ease of Debugging**: Centralized object creation makes it easier to debug and troubleshoot.

### Additional Advantages of Factory Method Pattern
- Encourages the use of interfaces rather than implementations, enhancing flexibility.
- Allows for replacement of implementations without altering client code.
- Can cache frequently used objects, reducing duplication (e.g., `Boolean.valueOf()` method).
- Recommended by industry experts, including Joshua Bloch in "Effective Java."
- Offers an alternative way of creating objects and can hide information related to object creation.

### Conclusion:
The Builder design pattern not only provides a flexible solution for constructing complex objects but also enhances code readability. The resulting code is easy to maintain, avoids errors, and allows a clean separation between construction and representation.


### Builder Design Pattern in Java – Pros and Cons
Like everything, the Builder pattern also has some disadvantages, but if you look below, the advantages clearly outnumber the disadvantages. Here are a few advantages and disadvantages of the Builder design pattern for creating objects in Java.

- Advantages:
    - 1) More maintainable if the number of fields required to create an object is more than 4 or 5.
    - 2) Less error-prone as the user will know what they are passing because of explicit method calls.
    - 3) More robust as only fully constructed objects will be available to the client.

- Disadvantages:
    - 1) Verbose and code duplication as Builder needs to copy all fields from the Original or Item class.

### When to Use Builder Design Pattern in Java
The Builder Design pattern is a creational pattern and should be used when the number of parameters required in the constructor is more than manageable, usually 4 or at most 5. Don't confuse the Builder with the Factory pattern; there is an obvious difference between the Builder and Factory patterns, as Factory can be used to create different implementations of the same interface, but Builder is tied to its Container class and only returns an object of the outer class.

### What is Static Factory Method or Factory Design Pattern
The Factory design pattern is used to create objects or classes in Java, providing loose coupling and high cohesion. The Factory pattern encapsulates the object creation logic, making it easy to change it later when you change how an object gets created or even introduce a new object with just a change in one class. In the GOF pattern list, the Factory pattern is listed as a Creation design pattern. The Factory should be an interface, and clients first either create a factory or get a factory, which is later used to create objects.

### Example of Static Factory Method in JDK
The best example of the Factory method design pattern is the `valueOf()` method, which is in the String and wrapper classes like Integer and Boolean, and is used for type conversion (i.e., converting String to Integer or String to double in Java). Some more examples of the factory method design pattern from JDK are:
- `valueOf()` method, which returns an object created by a factory equivalent to the value of the parameter passed.
- `getInstance()` method, which creates an instance of the Singleton class.
- `newInstance()` method, which is used to create and return a new instance from the factory method every time it's called.
- `getType()` and `newType()`, equivalent to `getInstance()` and `newInstance()` factory methods but used when the factory method resides in a separate class.

### Problem Solved by Factory Method Pattern in Java
Whenever we talk about object-oriented languages, it is based upon concepts like abstraction and polymorphism, with encapsulation and delegation as important concepts. Any design will be considered good if tasks are delegated to different objects and some kind of encapsulation is present.

Sometimes our application or framework does not know what kind of object it has to create at runtime; it knows only the interface or abstract class, and as we know, we cannot create an object of an interface or abstract class. So the main problem is that the framework knows when it has to create but doesn’t know what kind of object.

Whenever we create an object using `new()`, we violate the principle of programming for interfaces rather than implementations, which eventually results in inflexible code that is difficult to maintain. By using the Factory design pattern in Java, we can resolve this problem. 

Another problem we may face is when a class needs to contain objects of other classes or class hierarchies within it; this can be easily achieved by just using the `new` keyword and the class constructor. The issue with this approach is that it is a very hard-coded way to create objects, creating a dependency between the two classes.

So, the factory pattern solves this problem easily by modeling an interface for creating an object that, at creation time, can let its subclasses decide which class to instantiate. The Factory Pattern promotes loose coupling by eliminating the need to bind application-specific classes into the code. The factory methods are typically implemented as virtual methods, so this pattern is also referred to as the “Virtual Constructor.” These methods create the objects of the products or target classes.

### When to Use Factory Design Pattern in Java
- Static Factory methods are common in frameworks where library code needs to create objects of types that may be subclassed by applications using the framework.
- Some or all concrete products can be created in multiple ways, or we want to leave open the option that in the future there may be new ways to create the concrete product.
- The factory method is used when products don't need to know how they are created.
- We can use the factory pattern where we have to create an object of any one of the subclasses depending on the data provided.

### Code Example of Factory Design Pattern in Java
Let’s see an example of how the factory pattern is implemented in code. We have a requirement to create multiple currencies (e.g., INR, SGD, USD), and the code should be extensible to accommodate new currencies as well. Here, we have made `Currency` an interface, and all currency implementations are concrete implementations of the `Currency` interface. The Factory Class will create a `Currency` based on the country and return the concrete implementation, which will be stored in an interface type. This makes the code dynamic and extensible.

### Here is the complete code example of the Factory pattern in Java:
```java
interface Currency {
       String getSymbol();
}
// Concrete Rupee Class code
class Rupee implements Currency {
       @Override
       public String getSymbol() {
              return "Rs";
       }
}
// Concrete SGD class Code
class SGDDollar implements Currency {
       @Override
       public String getSymbol() {
              return "SGD";
       }
}
// Concrete US Dollar code
class USDollar implements Currency {
       @Override
       public String getSymbol() {
              return "USD";
       }
}

// Factory Class code
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
// Factory client code
public class Factory {
       public static void main(String args[]) {
              String country = args[0];
              Currency currency = CurrencyFactory.createCurrency(country);
              System.out.println(currency.getSymbol());
       }
}
```
### Advantages of Factory Method Pattern in Java
The Factory pattern in Java is heavily used everywhere, including JDK, open-source libraries, and other frameworks. The following are the main advantages of using the Factory pattern in Java:
- 1) The Factory method design pattern decouples the calling class from the target class, resulting in less coupled and highly cohesive code. 
   E.g.: JDBC is a good example for this pattern; application code doesn't need to know what database it will use, so it doesn't know what database-specific driver classes it should use. Instead, it uses factory methods to get Connections, Statements, and other objects to work with, allowing flexibility to change the back-end database without changing the DAO layer if you are using ANSI SQL features and not coded on DBMS-specific features.
- 2) The Factory pattern in Java enables subclasses to provide extended versions of an object because creating an object inside the factory is more flexible than creating an object directly in the client. Since the client is working on the interface level, any time you can enhance the implementation and return from the Factory.
- 3) Another benefit of using the Factory design pattern in Java is that it encourages consistency in code since every time an object is created using the Factory rather than using different constructors at different client sides.
- 4) Code written using the Factory design pattern in Java is also easy to debug and troubleshoot because you have a centralized method for object creation, and every client is getting an object from the same place.

### Some More Advantages of Factory Method Design Pattern:
- 1. Static factory methods used in the Factory design pattern enforce the use of interfaces rather than implementations, which is a good practice. For example:
  `Map synchronizedMap = Collections.synchronizedMap(new HashMap());`
- 2. Since static factory methods have a return type as an interface, they allow you to replace the implementation with a better performance version in newer releases.
- 3. Another advantage of the static factory method pattern is that they can cache frequently used objects and eliminate duplicate object creation. The `Boolean.valueOf()` method is a good example, which caches true and false boolean values.
- 4. The Factory method pattern is also recommended by Joshua Bloch in "Effective Java."
- 5. The Factory method pattern offers an alternative way of creating objects.
- 6. The Factory pattern can also be used to hide information related to the creation of objects.

---

## What is Singleton Design Pattern in Java?
The Singleton design pattern is a creational pattern that restricts a class to a single instance and provides a global point of access to it. The singleton pattern is widely used in situations where one instance is sufficient to coordinate actions across a system. 

### Use Cases for Singleton Pattern:
1. **Database Connection Pooling**: Managing connections to a database, ensuring that there is a single instance handling all requests.
2. **Logging**: A single logger instance that handles all logging throughout the application.
3. **Configuration**: Ensuring that all parts of an application access the same configuration settings.

### Implementation of Singleton Pattern in Java
The Singleton pattern can be implemented in several ways, including:
1. **Eager Initialization**
2. **Lazy Initialization**
3. **Thread-Safe Singleton**

Here’s a simple thread-safe implementation of the Singleton design pattern using the lazy initialization approach.

```java
class Singleton {
    // Private static instance of the class
    private static Singleton instance;

    // Private constructor to restrict instantiation from outside the class
    private Singleton() {
    }

    // Public static method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### Advantages of Singleton Pattern:
1. Controlled access to a single instance, thus ensuring consistent state across the application.
2. Saves memory and resources as only one instance is created.

### Disadvantages of Singleton Pattern:
1. It can introduce global state in your application, which may lead to difficulties in testing and debugging.
2. Can be less flexible, as you cannot easily subclass a Singleton class.

### Conclusion
Understanding the Observer, Builder, and Singleton design patterns in Java is essential for creating efficient and maintainable code. Each pattern has its use cases, benefits, and drawbacks, making them suitable for different scenarios in software development.

### Java Decorator Design Pattern
- What is decorator pattern in Java?
- When to use decorator pattern in Java?
- How to use decorator pattern in Java?
- Example of decorator design pattern
- Advantage and Disadvantage of decorator pattern in Java

### What is decorator design pattern in Java?
- Decorator design pattern is used to enhance the functionality of a particular object at run-time or dynamically.
- At the same time, other instances of the same class will not be affected by this, so individual objects get the new behavior.
- Basically, we wrap the original object through a decorator object.
- Decorator design pattern is based on abstract classes, and we derive concrete implementations from those classes.
- It’s a structural design pattern and is most widely used.

### Problem which is solved by Decorator Pattern:
If anyone wants to add some functionality to an individual object or change the state of a particular object at runtime, it is not possible with traditional subclassing. Decorator pattern makes it possible to provide individual objects of the same class a specific behavior or state at runtime, without affecting other objects of the same class.

### When to use Decorator pattern in Java
- When subclassing becomes impractical and we need a large number of different possibilities to make independent objects.
- When we want to add functionality to individual objects, not to all objects at runtime.

### Code Example of decorator design pattern:
```java
// Component on Decorator design pattern
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
        description = "Indian rupees";
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

// Concrete Decorator
public class USDDecorator extends Decorator {
    Currency currency; 
    public USDDecorator(Currency currency) {
        this.currency = currency;
    }
    public String getDescription() {
        return currency.getDescription() + " ,its US Dollar";
    }
}

// Another Concrete Decorator
public class SGDDecorator extends Decorator {
    Currency currency;
    public SGDDecorator(Currency currency) {
        this.currency = currency;
    }
    public String getDescription() {
        return currency.getDescription() + " ,its Singapore Dollar";
    }
}

// Currency Check
public class CurrencyCheck {
    public static void main(String[] args) {
        // without adding decorators
        Currency curr = new Dollar();
        System.out.println(curr.getDescription() + " dollar. " + curr.cost(2.0));  
        
        // adding decorators
        Currency curr2 = new USDDecorator(new Dollar());
        System.out.println(curr2.getDescription() + " dollar. " + curr2.cost(4.0));

        Currency curr3 = new SGDDecorator(new Dollar());
        System.out.println(curr3.getDescription() + " dollar. " + curr3.cost(4.0));
    }
}
```

### Explanation of the code:
1. **Component Interface**: In our example, the `Currency` interface is the component which is used on its own or needs a decorator for that.
2. **Concrete Component**: Implements the component and we add new behavior to this object dynamically. `Dollar` and `Rupee` are the concrete implementations of currency.
3. **Decorator**: Decorator contains a HAS-a relationship; it has an instance variable that holds a reference for the component. Here, a Decorator is an abstract class that extends the currency.
4. **Concrete Decorator**: Implementation of the Decorator, e.g., `USDDecorator` and `SGDDecorator`, which contains an instance variable for the component interface.

### Advantages of Decorator design Pattern in Java
1. Decorator Pattern is more flexible than inheritance because inheritance adds responsibilities at compile time while the decorator adds them at run-time.
2. Decorator pattern enhances or modifies the object's functionality.

### Disadvantages
The main disadvantage of using the Decorator Pattern in Java is that code maintenance can become problematic as it provides many similar small objects (each decorator).

### Differences between String, StringBuffer, and StringBuilder in Java
**String in Java**
1. **Immutable**: Strings are immutable in Java. Their hashcode value can be cached, making them faster as hashmap keys.
2. **String Literals**: Created in String pools; using `==` for comparison checks reference equality.
3. **Concatenation**: The `+` operator is overloaded for Strings, implemented using `StringBuffer` or `StringBuilder`.
4. **Character Array**: Strings are backed by a character array, represented in UTF-16 format.
5. **Equality**: Strings are equal if they have the same characters in the same order and case.
6. **toString()**: Provides a String representation of an object.

### Problem with String in Java
Immutability can lead to temporary garbage in heap if many operations are performed on strings. This is why Java provides `StringBuffer` and `StringBuilder`.

### Differences between String and StringBuffer in Java
- **String**: Immutable.
- **StringBuffer**: Mutable, allowing modifications without creating new objects.

### Difference between StringBuilder and StringBuffer in Java
`StringBuffer` is synchronized, making it thread-safe but slower. `StringBuilder` is a newer class (added in JDK 5) that is not synchronized, thus performing better.

### Summary
1. **Immutability**: String is immutable; StringBuffer and StringBuilder are mutable.
2. **Synchronization**: StringBuffer is synchronized, StringBuilder is not.
3. **Concatenation**: `+` operator is implemented using either StringBuffer or StringBuilder.
4. **Usage**: Use String for immutability, StringBuffer for mutable + thread-safety, and StringBuilder for mutable + without thread-safety.

### Reason Why Wait, Notify, and NotifyAll are in Object Class
1. **Communication Mechanism**: Wait and notify are communication mechanisms between threads, making Object class the correct place for them.
2. **Locks**: Locks are available on a per-object basis, justifying their presence in the Object class.
3. **Critical Section**: Threads need a lock to enter critical sections, waiting on the object lock.

### Why wait, notify, and notifyAll are called from synchronized block or method in Java
We use these methods for inter-thread communication, where one thread waits after checking a condition, and another thread notifies it after the condition changes. This process needs to be atomic to avoid race conditions, which is achieved by using synchronized methods or blocks.

### Summary of calling wait(), notify(), or notifyAll() from synchronized context
1. **Avoid IllegalMonitorStateException**: Occurs if we don't call these methods from a synchronized context.
2. **Prevent Race Conditions**: Ensures proper synchronization between threads.
