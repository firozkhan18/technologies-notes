### What is Java Class?
Java class is nothing but a template for the object you are going to create, or it’s a blueprint by using which we create an object. In simple words, we can say it’s a specification or a pattern which we define, and every object we define will follow that pattern.

### What does Java Class Consist?
When we create a class in Java, the first step is the keyword `class` followed by the name of the class (identifier). Next is the class body, which starts with curly braces `{}`, and between these, all things related to that class, including their properties and methods, will come here.

**Template**:
```
Class (name of the class) { (Here define members of class) }
```

### Access Level of Class:
Java class has mainly two types of access levels:
- **Default**: Class objects are accessible only inside the package.
- **Public**: Class objects are accessible in code in any package.

### What are Members of Class?
When we create a class, it’s totally incomplete without defining any member of this class, similar to how a family is incomplete if they have no members.

1. **Field**: Field is nothing but the property of the class or object which we are going to create. For example, if we are creating a class called `Computer`, it may have properties like `model`, `mem_size`, `hd_size`, `os_type`, etc.
  
2. **Method**: Method is nothing but the operation that an object can perform. It defines the behavior of the object and how it can interact with the outside world, e.g., `startMethod()`, `shutdownMethod()`.

### Access Level of Members:
Access level is nothing but where we can use the members of the class. Each field and method has an access level:
- **private**: Accessible only in this class.
- **package or default**: Accessible only in this package.
- **protected**: Accessible only in this package and in all subclasses of this class.
- **public**: Accessible everywhere this class is available.

### Real-world Example of Class in Java Programming:
In the real world, if we want to understand a class, everything of the same quality can be visualized as a class, e.g., men, women, birds, bicycles, cars, or we can say vehicles. The entire vehicle can make one class, having properties like `no_of_wheels`, `color`, `model`, `brand`, etc. We can think of methods like `changeGear()`, `speedOfVehicle()`, `applyBrake()`, etc., on that class. 

Similarly, all human beings can also be one class, with members like men, women, child, and methods like `isAlive()`, `isDeath()`. Again, we can make `Men` or `Women` a separate class and define their properties and methods accordingly. In short, in Java, every problem we encounter can be thought of in terms of class and object.

### One Java Class Example:
```java
class Stock {
    public String commodity;
    public double price;

    public void buy(int no_of_commodity) {}

    public boolean sell() {}
}
```
In this example, `Stock` is called the Class, and `commodity`, `price` are fields. The `buy()` and `sell()` methods are defined inside the class. To access elements of the class, you need to create an instance of the class `Stock`. You can create an instance using the keyword `new` as shown below:

```java
Stock highBetaStock = new Stock();
```

For calling methods of `Stock`, use the instance:
```java
highBetaStock.buy(1000);
highBetaStock.sell();
```

### Summary:
In short, in Java, everything must be thought of in terms of a Java class. It’s nothing but a template with its own members and methods for accessing those members. The visibility of each member is determined by the developer, specifying where they want to use those objects.

# How to Make Thread-Safe Code in Java

## Example of Non Thread-Safe Code in Java

Here is an example of non thread-safe code. Look at the code and find out why this code is not thread-safe.

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

The above example is not thread-safe because the `++` (increment operator) is not an atomic operation and can be broken down into read, update, and write operations. If multiple threads call `getCount()` at approximately the same time, each of these three operations may coincide or overlap with each other. For example, while thread 1 is updating the value, thread 2 reads and still gets the old value, which eventually lets thread 2 override thread 1's increment, resulting in a lost count because multiple threads called it concurrently.

## How to Make Code Thread-Safe in Java

There are multiple ways to make this code thread-safe in Java:

1. **Use synchronized keyword** in Java and lock the `getCount()` method so that only one thread can execute it at a time, which removes the possibility of coinciding or interleaving.

2. **Use Atomic Integer**, which makes this `++` operation atomic, and since atomic operations are thread-safe, it saves the cost of external synchronization.
   
### Here is a thread-safe version of the Counter class in Java:

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
### Important points about Thread-Safety in Java
Here are some points worth remembering to write thread safe code in Java, this knowledge also helps you to avoid some serious concurrency issues in Java like race condition or deadlock in Java:

- **Immutable objects** are by default thread-safe because their state cannot be modified once created. Since `String` is immutable in Java, it is inherently thread-safe.
- **Read-only or final variables** in Java are also thread-safe.
- **Locking** is one way of achieving thread-safety in Java.
- **Static variables**, if not synchronized properly, can become a major cause of thread-safety issues.
- Examples of thread-safe classes in Java: `Vector`, `Hashtable`, `ConcurrentHashMap`, `String`, etc.
- **Atomic operations** in Java are thread-safe (e.g., reading a 32-bit int from memory because it’s an atomic operation it can't interleave with other thread).
- **Local variables** are also thread-safe because each thread has its own copy, and using local variables is a good way to write thread-safe code.
- To avoid thread-safety issues, minimize sharing of objects between multiple threads.
- **Volatile keyword** in Java can also be used to instruct threads not to cache variables, reading from main memory, and can also instruct the JVM not to reorder or optimize code from a threading perspective.
  
### 2 ways to find if thread holds lock on object in Java
Here I am giving my answer and what I had discovered after interview

1. I thought about `IllegalMonitorStateException`, which `wait()` and `notify()` methods throw when they get called from a non-synchronized context. I said I would call `newspaper.wait()`, and if this call throws an exception, it means the thread in Java is not holding the lock; otherwise, the thread holds the lock.

2. Later, I discovered that there is a static method called `holdsLock(Object obj)` which returns true or false based on whether the thread holds the lock on the object passed.

## Wait vs Sleep vs Yield in Java

### Difference between Wait and Sleep in Java

The main difference between `wait` and `sleep` is that the `wait()` method releases the acquired monitor when the thread is waiting, while the `Thread.sleep()` method keeps the lock or monitor even if the thread is waiting. Also, the `wait` method in Java should be called from a synchronized method or block, while there is no such requirement for the `sleep()` method. 

Another difference is that `Thread.sleep()` is a static method and applies to the current thread, while `wait()` is an instance-specific method and only wakes up if some other thread calls the `notify` method on the same object. In the case of `sleep`, the sleeping thread immediately goes to the Runnable state after waking up, while in the case of `wait`, the waiting thread first acquires the lock and then goes into the Runnable state.

So based upon your need if you require a specified second of pause use sleep() method or if you want to implement inter-thread communication use wait method.

### Here is a list of differences between wait and sleep in Java:

- `wait` is called from synchronized context only, while `sleep` can be called without a synchronized block.
- `wait` is called on an Object, while `sleep` is called on a Thread.
- The waiting thread can be awoken by calling `notify` and `notifyAll`, while the sleeping thread cannot be awakened by calling the `notify` method.
- `wait` is normally done on a condition; the thread waits until a condition is true, while `sleep` is just to pause the thread.
- `wait` releases the lock on the object while waiting, while `sleep` doesn’t release the lock while waiting.

### Difference between yield and sleep in java

The major difference between `yield` and `sleep` in Java is that the `yield()` method pauses the currently executing thread temporarily, giving a chance to the remaining waiting threads of the same priority to execute. If there are no waiting threads or all the waiting threads have a lower priority, the same thread will continue its execution. The yielded thread's scheduling is decided by the thread scheduler, whose behavior is vendor-dependent. 

The `yield` method doesn’t guarantee that the current thread will pause or stop, but it guarantees that the CPU will be relinquished by the current Thread as a result of the call to `Thread.yield()`.

The `sleep` method in Java has two variants: one which takes milliseconds as the sleeping time, and the other which takes both milliseconds and nanoseconds for sleeping duration.
```
sleep(long millis)
or
sleep(long millis,int nanos)
```
Cause the currently executing thread to sleep for the specified number of milliseconds plus the specified number of nanoseconds.

### Example of Thread Sleep method in Java
Here is sample code example of Sleep Thread in Java. In this example we have put Main thread in Sleep for 1 second.
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
### Output:
```
main is going to sleep for 1 Second
Main Thread is woken now
```

### 10 points about Thread sleep() method in Java

Here are some important points to remember about the `sleep()` method of the Thread class in Java:

1. The `Thread.sleep()` method is used to pause execution, relinquish the CPU, and return it to the thread scheduler.
2. The `Thread.sleep()` method is a static method and always puts the current thread to sleep.
3. Java has two variants of the `sleep` method in the Thread class: one with one argument (milliseconds) and the other with two arguments (milliseconds and nanoseconds).
4. Unlike the `wait()` method in Java, the `sleep()` method of the Thread class doesn't relinquish the lock it has acquired.
5. The `sleep()` method throws `InterruptedException` if another thread interrupts a sleeping thread in Java.
6. With `sleep()` in Java, it is not guaranteed that when the sleeping thread wakes up, it will definitely get the CPU; instead, it goes to the Runnable state and competes for CPU with other threads.
7. There is a misconception about the `sleep` method in Java: calling `t.sleep()` will put Thread "t" into a sleeping state. That's not true because `Thread.sleep` is a static method; it always puts the current thread into a sleeping state and not thread "t".
   
### NoClassDefFoundError vs ClassNotFoundException
Before seeing the differences between ClassNotFoundException and NoClassDefFoundError let's see some similarities which are main reason of confusion between these two errors:

1. Both `NoClassDefFoundError` and `ClassNotFoundException` are related to the unavailability of a class at runtime.
2. Both `ClassNotFoundException` and `NoClassDefFoundError` are related to the Java classpath.

Now let's see the difference between NoClassDefFoundError and ClassNotFoundException:

1. **Cause of Occurrence**:
   - `ClassNotFoundException` occurs in Java if we try to load a class at runtime using `Class.forName()`, `ClassLoader.loadClass()`, or `ClassLoader.findSystemClass()` methods and the requested class is not available. Most of the time, it seems like we have the class in the classpath, but it turns out to be an issue related to the classpath, and the application may not be using the classpath that we think it was using. For example, the classpath defined in a JAR's manifest file will take precedence over the `CLASSPATH` or `-cp` option. For more details, see how classpath works in Java.
   - On the other hand, `NoClassDefFoundError` is slightly different from `ClassNotFoundException`; in this case, the culprit class was present during compile time, allowing the application to compile successfully and link correctly, but it is not available during runtime due to various reasons.

2. **Exception Type**:
   - `ClassNotFoundException` is a checked exception derived directly from the `java.lang.Exception` class, and you need to provide explicit handling for it.
   - `NoClassDefFoundError` is an error derived from `LinkageError`.

3. **ClassLoader Behavior**:
   - If you are using `ClassLoader` in Java and have two classloaders, trying to access a class loaded by another classloader will result in `ClassNotFoundException`.

4. **Loading Mechanism**:
   - `ClassNotFoundException` arises when there is explicit loading of a class by providing the name of the class at runtime using `ClassLoader.loadClass()` or `Class.forName()`, while `NoClassDefFoundError` is a result of implicit loading of a class due to a method call from that class or any variable access.


### Comparator vs Comparable in Java

Comparators and Comparable in Java are two interfaces used to implement sorting. It’s often required to sort objects stored in any collection classes like `ArrayList`, `HashSet`, or in an array, and that's when we need to use either the `compare()` or `compareTo()` method defined in `java.util.Comparator` and `java.lang.Comparable`.

Here are some common differences:

1. **Package Location**:
   - `Comparator` in Java is defined in the `java.util` package, while the `Comparable` interface is defined in the `java.lang` package, indicating that `Comparator` should be used as a utility to sort objects, while `Comparable` should be provided by default.

2. **Method Signature**:
   - The `Comparator` interface has the method `public int compare(Object o1, Object o2)`, which returns a negative integer, zero, or a positive integer depending on whether the first argument is less than, equal to, or greater than the second. 
   - The `Comparable` interface has the method `public int compareTo(Object o)`, which does the same comparison but compares "this" reference with the specified object.

3. **Logical Difference**:
   - `Comparator` compares two objects provided to it, while `Comparable` compares the "this" reference with the specified object. 

4. **Natural Ordering**:
   - `Comparable` is used to implement the natural ordering of objects. In the Java API, classes like `String`, `Date`, and wrapper classes implement the `Comparable` interface. It’s good practice to override `compareTo()` for value objects.

5. **Sorting Collections**:
   - If a class implements the `Comparable` interface, collections of that object, either `List` or `Array`, can be sorted automatically using `Collections.sort()` or `Arrays.sort()`, and objects will be sorted based on their natural order defined by the `compareTo()` method.

6. **Usage in Sorted Collections**:
   - Objects that implement `Comparable` can be used as keys in a `SortedMap` like `TreeMap` or elements in a `SortedSet` like `TreeSet`, without specifying any `Comparator`.

These were combination of some theoretical and practical differences between Comparator and Comparator interface in Java. It does help you to decide when to use Comparator vs Comparable but things will be more clear when we some best practices around using both of these interfaces.

### Example of using Comparator and Comparable in Java

In summary, if you want to sort objects based on natural order, use `Comparable`, and if you want to sort on some other attribute of an object, use `Comparator`. Let’s see a real-life coding example:

1. **Person Class**: Sort the `Person` based on `person_id`, which is the primary key in the database.
2. **Sort by Name**: Sort the `Person` based on their name.

For a `Person` class, sorting based on `person_id` can be treated as natural order sorting, while sorting based on the name field can be implemented using the `Comparator` interface. To sort based on `person_id`, we need to implement the `compareTo()` method.

```java
public class Person implements Comparable {
    private int person_id;
    private String name;
    
    /**
     * Compare current person with specified person
     * return zero if person_id for both persons is the same 
     * return negative if current person_id is less than the specified one
     * return positive if specified person_id is greater than the current one
     */
    @Override 
    public int compareTo(Object o) {
        Person p = (Person) o; 
        return this.person_id - p.person_id; // Corrected from 'o.person_id'
    }
    ...
}
```

> **Note**: Generally, you should not use the difference of integers to decide the output of `compareTo()` method as the result of integer subtraction can overflow. If you are sure both operands are positive, then it’s one of the quickest ways to compare two objects.

For sorting based on the person's name, we can implement the `compare(Object o1, Object o2)` method of the `Comparator` class.

```java
/**
 * Comparator implementation which sorts Person objects on person_id field
 */
public class SortByPerson_ID implements Comparator {

    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1; // Corrected from 'o' to 'o1'
        Person p2 = (Person) o2; // Corrected from 'o' to 'o2'
        return Integer.compare(p1.getPersonId(), p2.getPersonId());
    }
}
```

> **Note**: Instead of using the subtraction operator, it’s better to use the `Integer.compare()` method to avoid overflow issues.

Similar guidelines applies while implementing compare() method as well and instead of using subtraction operator, its better to use logical operator to compare whether two integers are equal to, less than or greater than. You can write several types of Java Comparator based upon your need for example  reverseComparator , ANDComparator , ORComparator etc which will return negative or positive number based upon logical results. String in Java even provides an special comparator called CASE_INSENSITIVE_ORDER, to perform case insensitive comparison of String objects.

### How to Compare String in Java

Strings are immutable in Java and one of the most used value classes. For comparing strings, we should not worry because `String` implements the `Comparable` interface and provides a lexicographic implementation for the `compareTo()` method, comparing two strings based on the contents of their characters in lexical order. You can call `String.compareTo(AnotherString)`, and Java will determine whether the specified string is greater than, equal to, or less than the current object.

### How to Compare Dates in Java

Dates are represented by the `java.util.Date` class in Java, and like `String`, `Date` also implements `Comparable`. They will be automatically sorted based on their natural ordering if stored in any sorted collection like `TreeSet` or `TreeMap`. If you explicitly want to compare two dates, you can call `Date.compareTo(AnotherDate)` method in Java.

### When to use Comparator and Comparable in Java
Here are some best practices and recommendations for when to use `Comparator` or `Comparable` in Java:

1. **Natural Sorting**: If there is a natural or default way of sorting an object during the development of a class, then use `Comparable`. This is intuitive; given the class name, people should be able to guess it correctly, like strings sorted chronologically, employees sorted by their ID, etc. If an object can be sorted in multiple ways, and the client specifies the sorting parameter, use the `Comparator` interface.

2. **External Sorting**: Sometimes, you may write code to sort objects of a class for which you are not the original author or do not have access to the code. In these cases, you cannot implement `Comparable`, and `Comparator` is the only way to sort those objects.

3. **Behavior in Sorted Collections**: Be aware of how those objects will behave when stored in `SortedSet` or `SortedMap` like `TreeSet` and `TreeMap`. If an object doesn't implement `Comparable`, always provide the corresponding `Comparator` when putting them into a `SortedMap`.

4. **Order of Comparison**: The order of comparison is very important while implementing `Comparable` or `Comparator` interfaces. For example, if you are sorting objects based on name, you can compare the first name or last name in any order, so decide it judiciously.

5. **Self-descriptive Comparators**: `Comparator` has the distinct advantage of being self-descriptive. For example, if you are writing a `Comparator` to compare two employees based on their salary, name it `SalaryComparator`, while for `compareTo()`, the name may not be as intuitive.

## Observer design Pattern Java Code Example

### What is Observer design Pattern?

The Observer design pattern in Java is an important pattern used to observe changes in an object. When a particular object's state changes, the observers are notified of this change. The object being observed is referred to as the **Subject**, while the classes that observe the subject are called **Observers**. This pattern is widely used in conjunction with the Model-View-Controller (MVC) design pattern, where changes in the model are propagated to the view to render modified information. 

### Problem which is solved by Observer Pattern:

The Observer pattern addresses the need for automatically updating dependent objects when the state of a particular object changes. This reduces coupling between objects. For instance, when a customer registers for a new phone connection, various departments (like verification and dispatch) are notified to carry out their tasks based on the customer's state.

### How Observer Design Pattern is implemented in Java;

Java provides built-in support for the Observer pattern in the `java.util` package, which contains interfaces and classes for this pattern:

- **Observer Interface**: Classes implementing this interface must be notified when the subject or observable object change its status. Update (Observable Ob, Object arg): This method is called when subject is changed.
- **Observable Class**: This is the subject that observers want to monitor.
- 
### Some Important Method:

- `addObserver(Observer o)`: Adds an observer to the set of observers for this  subject or observalbel object.
- `deleteObserver(Observer o)`: Removes an observer from the set  of observers.
- `hasChanged()`: Checks if the object has changed.
- `clearChanged()`: Indicates that the subject has no changes or that all observers have been notified when changes is made.
- `notifyObservers()`: Notifies all observers if the object has changed.
- 
### Code Example of Observer design pattern in Java:
Observer Design pattern is generic than how it is implemented in Java. You are free to choose java.util.Observable or java.util.Observer or writing your own Subject and Observer interface. I prefer having my own Subject and Observer interface and this is how I am going to write my Code Example of Observer design Pattern in java. Mine Example is very Simple you have a Loan on which interest rate is subject to change and when it changes, Loan notifies to Newspaper or Internet media to display new loan interest rate. To implement this we have a Subject interface which contains methods for adding, removing and notifying Observers and an Observer interface which contains update(int interest) method which will be called by Subject implementation when interest rate changes.

Below is a simple example where a `Loan` object notifies its observers (Newspaper and Internet) when its interest rate changes:

```java
import java.util.ArrayList;

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
        return bank;
    }

    public String getType() {
        return type;
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
            System.out.println("Notifying Observers on change in Loan interest rate");
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

class Internet implements Observer {
    @Override
    public void update(float interest) {
        System.out.println("Internet: Interest Rate updated, new Rate is: " + interest);
    }
}

public class ObserverTest {
    public static void main(String[] args) {
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
Main advantage is loose coupling between objects called observer and observable. The subject only know the list of observers it don’t care about how they have their implementation.All the observers are notified by subject in a single event call as Broadcast communication

- **Loose Coupling**: The subject knows only the list of observers, not their implementations.
- **Broadcast Communication**: All observers are notified with a single event call.

### Disadvantage of Observer Design Pattern in Java: 

- **Debugging Complexity**: The flow of control between observers and observable can complicate debugging, especially with chains of observers.
- **Memory Management**: The subject holds references to all the reference of all the observers, which can lead to memory issues if observers are not unregistered.

### What problem Builder pattern solves in Java
As I said earlier Builder pattern is a creational design pattern it means its solves problem related to object creation. Constructors in Java are used to create object and can take parameters required to create object. Problem starts when an Object can be created with lot of parameters, some of them may be mandatory and others may be optional. Consider a class which is used to create Cake, now you need number of item like egg, milk, flour to create cake. many of them are mandatory and some  of them are optional like cherry, fruits etc. If we are going to have overloaded constructor for different kind of cake then there will be many constructor and even worst they will accept many parameter.

The Builder pattern is a creational design pattern that addresses challenges related to object creation. When an object requires numerous parameters—some mandatory and others optional—overloaded constructors can become unwieldy and error-prone. For example, a `Cake` class might require mandatory ingredients like eggs and flour, and optional ingredients like cherries. Managing multiple constructors can lead to complexity and confusion.

### Problems with Traditional Constructors:
1. **Too Many Constructors**: Overloaded constructors can be hard to maintain.
2. **Error-Prone**: Similar parameter types (e.g., cups of sugar and butter) can lead to mistakes that are not caught at compile-time.

Error-Prone because many fields has same type e.g. sugar and and butter are in cups so instead of 2 cup sugar if you pass 2 cup butter, your compiler will not complain but will get a buttery cake with almost no sugar with high cost of wasting butter.
 
The Builder pattern simplifies this by allowing more readable and manageable object creation.

You can partially solve this problem by creating Cake and then adding ingredients but that will impose another problem of leaving Object on inconsistent state during building, ideally cake should not be available until its created. Both of these problem can be solved by using Builder design pattern in Java. Builder design pattern not only improves readability but also reduces chance of error by adding ingredients explicitly and making object available once fully constructed. 

## Example of Builder Design pattern in Java
We will use same example of creating Cake using Builder design pattern in Java. here we have static nested builder class inside Cake which is used to create object.

Here's an example of how to create a `Cake` using the Builder pattern:

```java
public class BuilderPatternExample {

    public static void main(String[] args) {
        // Creating a Cake object using the Builder pattern
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
    private final int vanilla;    // spoon
    private final double flour;    // cup
    private final double bakingPowder; // spoon
    private final double milk;      // cup
    private final int cherry;

    public static class Builder {

        private double sugar;   
        private double butter;  
        private int eggs;
        private int vanilla;     
        private double flour;   
        private double bakingPowder; 
        private double milk;  
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
    private Cake(Builder builder) {
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

### Output:
```
Cake{sugar=1.0, butter=0.5, eggs=2, vanilla=2, flour=1.5, bakingPowder=0.0, milk=0.5, cherry=0}
```
### Guidelines for Builder design pattern in Java
- 1) Make a static nested class called Builder inside the class whose object will be build by Builder. In this example its Cake.
- 2) Builder class will have exactly same set of fields as original class.
- 3) Builder class will expose method for adding ingredients e.g. sugar() in this example. each method will return same Builder object. Builder will be enriched with each method call.
- 4) Builder.build() method will copy all builder field values into actual class and return object of Item class.
- 5) Item class (class for which we are creating Builder) should have private constructor to create its object from build() method and prevent outsider to access its constructor.
```java
public class BuilderPatternExample {
  
    public static void main(String args[]) {
      
        //Creating object using Builder pattern in java
        Cake whiteCake = new Cake.Builder().sugar(1).butter(0.5).  eggs(2).vanila(2).flour(1.5). bakingpowder(0.75).milk(0.5).build();
      
        //Cake is ready to eat :)
        System.out.println(whiteCake);
    }
}

class Cake {

    private final double sugar;   //cup
    private final double butter;  //cup
    private final int eggs;
    private final int vanila;     //spoon
    private final double flour;   //cup
    private final double bakingpowder; //spoon
    private final double milk;  //cup
    private final int cherry;

    public static class Builder {

        private double sugar;   //cup
        private double butter;  //cup
        private int eggs;
        private int vanila;     //spoon
        private double flour;   //cup
        private double bakingpowder; //spoon
        private double milk;  //cup
        private int cherry;

        //builder methods for setting property
        public Builder sugar(double cup){this.sugar = cup; return this; }
        public Builder butter(double cup){this.butter = cup; return this; }
        public Builder eggs(int number){this.eggs = number; return this; }
        public Builder vanila(int spoon){this.vanila = spoon; return this; }
        public Builder flour(double cup){this.flour = cup; return this; }
        public Builder bakingpowder(double spoon){this.sugar = spoon; return this; }
        public Builder milk(double cup){this.milk = cup; return this; }
        public Builder cherry(int number){this.cherry = number; return this; }
      
      
        //return fully build object
        public Cake build() {
            return new Cake(this);
        }
    }

    //private constructor to enforce object creation through builder
    private Cake(Builder builder) {
        this.sugar = builder.sugar;
        this.butter = builder.butter;
        this.eggs = builder.eggs;
        this.vanila = builder.vanila;
        this.flour = builder.flour;
        this.bakingpowder = builder.bakingpowder;
        this.milk = builder.milk;
        this.cherry = builder.cherry;       
    }

    @Override
    public String toString() {
        return "Cake{" + "sugar=" + sugar + ", butter=" + butter + ", eggs=" + eggs + ", vanila=" + vanila + ", flour=" + flour + ", bakingpowder=" + bakingpowder + ", milk=" + milk + ", cherry=" + cherry + '}';

    } 
  
}
```
Output:
```
Cake{sugar=0.75, butter=0.5, eggs=2, vanila=2, flour=1.5, bakingpowder=0.0, milk=0.5, cherry=0}
```
### Builder design pattern in Java – Pros and Cons
Live everything Builder pattern also has some disadvantages, but if you look at below, advantages clearly outnumber disadvantages of Builder design pattern. Any way here are few advantages and disadvantage of Builder design pattern for creating objects in Java.

#### Advantages:
1. **Maintainability**: More manageable when there are many fields to create an object.
2. **Less Error-Prone**: Explicit method calls reduce the likelihood of passing incorrect parameters.
3. **Robustness**: Only fully constructed objects are available to clients.

#### Disadvantages:
1. **Verbosity and code duplication**: The pattern can lead to more code, as the builder must copy all fields from the original class.
   
### When to use Builder Design pattern in Java

Use the Builder pattern when the number of parameters required in a constructor exceeds four or five. Unlike the Factory pattern, which creates different implementations of the same interface, the Builder pattern is tied to its container class and only returns objects of that outer class.

### What is the Static Factory Method or Factory Design Pattern?

The Factory Design Pattern is a creational pattern used to create objects in Java, promoting loose coupling and high cohesion. It encapsulates the object creation logic, making it easier to change the way objects are created or introduce new objects without modifying existing code. In the "Gang of Four" (GoF) design patterns, the Factory Pattern is classified as a creation pattern. Factory should be an interface and clients first either creates factory or get factory which later used to create objects.

### Key Concepts:
- **Factory Interface:** This interface is implemented by concrete factory classes.
- **Client:** The class that uses the factory to create objects.

### Example of Static Factory Method in JDK:
Common examples include:
- `valueOf()` methods in wrapper classes (e.g., `Integer.valueOf(String)`).
- `getInstance()` methods for Singleton classes.
- `newInstance()` methods to create new instances.

### Example of static factory method in JDK
 Best Example of Factory method design pattern is valueOf() method which is there in String and wrapper classes like Integer and Boolean and used for type conversion i.e. from converting String to Integer or String to double in java..
Some more examples of factory method design pattern from JDK is :
valueOf() method which returns object created by factory equivalent to value of parameter passed.
getInstance() method which creates instance of Singleton class.
newInstance() method which is used to create and return new instance from factory method every time called.
getType() and newType() equivalent of getInstance() and newInstance() factory method but used when factory method resides in separate class.
### Problem which is solved by Factory method Pattern in Java
Whenever we talk about object oriented language it will based upon some concept like abstraction, polymorphism etc and on that encapsulation and delegation are important concept any design will be called good if task are delegated to different object and some kind of encapsulation is there.

Sometime our application or framework will not know that what kind of object it has to create at run-time it knows only the interface or abstract class and as we know we cannot create object of interface or abstract class so main problem is frame work knows when it has to create but don’t know what kind of object.

Whenever we create object using new() we violate principle of programming for interface rather than implementation which eventually result in inflexible code and difficult to change in maintenance. By using Factory design pattern in Java we get rid of this problem.
Another problem we can face is class needs to contain objects of other classes or class hierarchies within it; this can be very easily achieved by just using the new keyword and the class constructor. The problem with this approach is that it is a very hard coded approach to create objects as this creates dependency between the two classes.

So factory pattern solve this problem very easily by model an interface for creating an object which at creation time can let its subclasses decide which class to instantiate, Factory Pattern promotes loose coupling by eliminating the need to bind application-specific classes into the code. The factory methods are typically implemented as virtual methods, so this pattern is also referred to as the “Virtual Constructor”. These methods create the objects of the products or target classes.

1. **Decoupling:** It allows the framework or application to be decoupled from the concrete classes it uses. Instead of creating objects with `new`, it relies on factory methods, adhering to the principle of programming to an interface rather than an implementation.
2. **Dynamic Object Creation:** The application can instantiate subclasses at runtime, depending on provided data, without needing to know specific implementations.
   
### When to use Factory design pattern in Java
- Static Factory methods are common in frameworks where library code needs to create objects of types which may be sub classed by applications using the framework.        
- Some or all concrete products can be created in multiple ways, or we want to leave open the option that in the future there may be new ways to create the concrete product.
- Factory method is used when Products don't need to know how they are created.
- We  can use factory pattern where we have to create an object of any one of sub-classes depending on the data provided

- When the exact types of objects to create are not known until runtime.
- When creating objects of a class that might be subclassed.
- When the creation logic is complex and should be encapsulated.
  
### Code Example of Factory Design Pattern in Java:
Let’s see an example of how factory pattern is implemented in Code. We have requirement to create multiple currency e.g. INR, SGD, USD and code should be extensible to accommodate new Currency as well. Here we have made Currency as interface and all currency would be concrete implementation of Currency interface. Factory Class will create Currency based upon country and return concrete implementation which will be stored in interface type. This makes code dynamic and extensible.

### Here is complete code example of Factory pattern in Java:
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

// Factroy Class code
class CurrencyFactory {
       public static Currency createCurrency (String country) {
       if (country. equalsIgnoreCase ("India")){
              return new Rupee();
       }else if(country. equalsIgnoreCase ("Singapore")){
              return new SGDDollar();
       }else if(country. equalsIgnoreCase ("US")){
              return new USDollar();
        }
       throw new IllegalArgumentException("No such currency");
       }
}
// Factory client code
public class Factory {
       public static void main(String args[]) {
              String country = args[0];
              Currency rupee = CurrencyFactory.createCurrency(country);
              System.out.println(rupee.getSymbol());
       }
}
```
### Advantage of Factory method Pattern in Java:
Factory pattern in Java is heavily used everywhere including JDK, open source library and other frameworks.In following are main advantages of using Factory pattern in Java:
- 1) Factory method design pattern decouples the calling class from the target class, which result in less coupled and highly cohesive code?
E.g.: JDBC is a good example for this pattern; application code doesn't need to know what database it will be used with, so it doesn't know what database-specific driver classes it should use. Instead, it uses factory methods to get Connections, Statements, and other objects to work with. Which gives you flexibility to change your back-end database without changing your DAO layer in case you are using ANSI SQL features and not coded on DBMS specific feature?
- 2) Factory pattern in Java enables the subclasses to provide extended version of an object, because creating an object inside factory is more flexible than creating an object directly in the client. Since client is working on interface level any time you can enhance the implementation and return from Factory.
- 3) Another benefit of using Factory design pattern in Java is that it encourages consistency in Code since every time object is created using Factory rather than using different constructor at different client side.
- 4) Code written using Factory design pattern in Java is also easy to debug and troubleshoot because you have a centralized method for object creation and every client is getting object from same place.

1. **Decoupling:** It reduces dependencies between the client and concrete classes, leading to more maintainable code.
2. **Extensibility:** New types of objects can be added easily without modifying existing code.
3. **Centralized Object Creation:** It simplifies debugging and maintenance since all object creation logic is centralized.
   
### Some more advantages of factory method design pattern is:
- 1. Static factory method used in factory design pattern enforces use of Interface than implementation which itself a good practice. for example:
```java
Map synchronizedMap = Collections.synchronizedMap(new HashMap());
```
- 2. Since static factory method have return type as Interface, it allows you to replace implementation with better performance version in newer release.
- 3. Another advantage of static factory method pattern is that they can cache frequently used object and eliminate duplicate object creation. Boolean.valueOf() method is good example which caches true and false boolean value.
- 4. Factory method pattern is also recommended by Joshua Bloch in Effective Java.
- 5 Factory method pattern offers alternative way of creating object.
- 6. Factory pattern can also be used to hide information related to creation of object.

- **Encourages Interface Usage:** Promotes the use of interfaces over implementations.
- **Caching:** Static factory methods can cache frequently used objects, improving performance.
- **Flexibility:** Allows returning different implementations from the same factory method.

### Conclusion:
The Factory Design Pattern is essential for creating flexible and maintainable Java applications. It abstracts object creation, enabling better adherence to the principles of OOP, such as encapsulation and polymorphism. This pattern is widely used in various frameworks and libraries in Java, making it a fundamental concept for developers to master.

### Java Decorator Design Pattern
- What is decorator pattern in Java?
- When to use decorator pattern in Java?
- How to use decorator pattern in Java?
- Example of decorator design pattern
- Advantage and Disadvantage of decorator pattern in Java

### What is decorator design pattern in Java?

- Decorator design pattern is used to enhance the functionality of a particular object at run-time or dynamically.
- At the same time other instance of same class will not be affected by this so individual object gets the new behavior.
- Basically we wrap the original object through decorator object.
- Decorator design pattern is based on abstract classes and we derive concrete implementation from that classes,
- It’s a structural design pattern and most widely used.

- The Decorator Pattern is a structural design pattern used to enhance the functionality of an object dynamically at runtime.
- It allows individual objects to have different behaviors without affecting other instances of the same class.
- The original object is wrapped in a decorator object, which adds new behaviors.
- The pattern relies on abstract classes and concrete implementations, providing flexibility and reusability.
  
### Problem which is solved by Decorator Pattern:
Now the question is why this pattern has came into existence what is the problem with existing system, so the answer is if anyone wants to add some functionality to individual object or change the state of particular object at run time it is not possible what the possible is we can provide the specific behavior to all the object of that class at design time by the help of inheritance or using subclass, but Decorator pattern makes possible that we provide individual object of same class a specific behavior or state at run time. This doesn’t affect other object of same Class in Java.

- It addresses the limitation of adding functionality to individual objects at runtime, as traditional inheritance would apply changes to all instances.
- It provides a way to mix and match different functionalities to objects without creating an explosion of subclasses.

### When to use Decorator pattern in Java
- When sub classing is become impractical and we need large number of different possibilities to make independent object or we can say we have number of combination for an object.
- Secondly when we want to add functionality to individual object not to all object at run-time we use decorator design pattern.

- When subclassing becomes impractical due to a large number of combinations needed for different behaviors.
- When there's a need to add functionality to individual objects at runtime, rather than to all instances of a class.

### Code Example of decorator design pattern:
To better understand concept of decorator design pattern let see a code example using Decorator Pattern in Java. You can also look inside JDK and find what are classes and packages which are using decorator pattern.

Here's a practical example of the Decorator Pattern in Java, using currency representation:

```java
// Component in Decorator design pattern
public abstract class Currency {
    String description = "Unknown currency";

    public String getCurrencyDescription() {
        return description;
    }

    public abstract double cost(double value);
}

// Concrete Component
public class Rupee extends Currency {
    public Rupee() {
        description = "Indian Rupees";
    }

    public double cost(double value) {
        return value;
    }
}

// Another Concrete Component
public class Dollar extends Currency {
    public Dollar() {
        description = "Dollar";
    }

    public double cost(double value) {
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
        return currency.getCurrencyDescription() + " (USD)";
    }

    public double cost(double value) {
        return currency.cost(value); // Delegating the cost calculation
    }
}

// Another Concrete Decorator for SGD
public class SGDDecorator extends Decorator {
    Currency currency;

    public SGDDecorator(Currency currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return currency.getCurrencyDescription() + " (SGD)";
    }

    public double cost(double value) {
        return currency.cost(value); // Delegating the cost calculation
    }
}

// Test the Decorator Pattern
public class CurrencyCheck {
    public static void main(String[] args) {
        // Without decorators
        Currency curr1 = new Dollar();
        System.out.println(curr1.getCurrencyDescription() + ": " + curr1.cost(2.0));

        // Adding decorators
        Currency curr2 = new USDDecorator(new Dollar());
        System.out.println(curr2.getDescription() + ": " + curr2.cost(4.0));

        Currency curr3 = new SGDDecorator(new Dollar());
        System.out.println(curr3.getDescription() + ": " + curr3.cost(4.0));
    }
}
```
### Explanation of the code:
We can understand this in following term;
1. Component Interface: In our example Currency interface is component which used on its own or we need decorator for that.
2. Concrete Component: it implements Component and we add new behavior to this object at dynamically. Dollar and Rupee are the concrete implementation of currency.
3. Decorator: Decorator contains a HAS a Relationship in simple word we can say it has a instance variable that holds reference for component they implement same component which they are going to decorate. Here a Decorator is an abstract class which extends the currency.
4. Concrete Decorator: it’s an implementation of Decorator So USD Dollar and SGD Dollar are the implementation of Decorator contains instance variable for component interface or the thing which they are going to decorate.

1. **Component Interface:** The `Currency` class serves as the component interface that can be decorated.
2. **Concrete Components:** The `Rupee` and `Dollar` classes are implementations of the `Currency` interface.
3. **Decorator Class:** The `Decorator` abstract class extends `Currency` and includes a method for getting the description.
4. **Concrete Decorators:** The `USDDecorator` and `SGDDecorator` classes extend the `Decorator` class and add specific behavior while holding a reference to a `Currency` object.

#### Advantages of the Decorator Pattern:
1. **Flexibility:** The Decorator Pattern is more flexible than inheritance, allowing dynamic behavior changes at runtime.
2. **Enhanced Functionality:** It provides a way to add or modify functionality to objects without modifying the original object or class.

- Advantage of Decorator design Pattern in Java
In brief we see what the main advantages of using decorator design patterns are.
1. Decorator Pattern is flexible than inheritance because inheritance add responsibilities at compile time and it will add at run-time.
2. Decorator pattern enhance or modify the object functionality

#### Disadvantages of the Decorator Pattern:
1. **Complexity:** The pattern can introduce a lot of small objects, making the codebase harder to maintain and understand.
2. **Overhead:** Each decorator adds a level of indirection, which can introduce additional complexity and runtime overhead.
   
- Disadvantage
Main disadvantage of using Decorator Pattern in Java is that the code maintenance can be a problem as it provides a lot of similar kind of small objects (each decorator).

In summary, the Decorator Pattern is a powerful way to extend the behavior of objects dynamically and should be used when you need flexibility in enhancing functionality without affecting other instances.

### Differences between String, StringBuffer and StringBuilder in Java
String in Java
Before looking difference between String and StringBuffer or StringBuilder let’s see some fundamental properties of String Class in Java

- 1) String is immutable in Java:  String is by design immutable in Java you can check this post for reason. Immutability offers lot of benefit to the String class e.g. his hashcode value can be cached which makes it a faster hashmap key and one of the reason why String is a popular key in HashMap. Because String is final it can be safely shared between multiple threads  without any extrasynchronization. 
- 2) when we represent string in double quotes like "abcd" they are referred as String literal and String literals are created in String pools. When you compare two String literals using equality operator "==" it returns true because they are actually same instance of String. Anyway comparing object with equality operator is bad practice in Java and you should always use equals method to check equality.
- 3) "+" operator is overloaded for String and used to concatenated two string. Internally "+" operation is implemented using either StringBuffer or StringBuilder.
- 4) Strings are backed up by character Array and represented in UTF-16 format. By the way this behavior can cause memory leak in String because same character array is shared between source String and SubString which can prevent source String from being garbage collected. See How SubString works in Java for more details.
- 5) String class overrides equals() and hashcode() method and two Strings are considered to be equal if they contain exactly same character in same order and in same case. If you want ignore case comparison of two strings consider using equalsIgnoreCase() method. See  how to correctly override equals method in Java  to learn more about best practices on equals method. Another worth noting point is that equals method must be consistent with compareTo() method for String because SortedSet and SortedMap e.g. TreeMap uses compareTo method to compare String in Java.
- 7) toString() method provides String representation of any object and its declared in Object class and its recommended for other class to implement this and provide String representation.
- 8) String is represented using UTF-16 format in Java.
- 9) In Java you can create String from char array, byte array, another string, from StringBuffer or from StringBuilder. Java String class provides constructor for all of these.



#### String in Java
- **Immutability**: Strings are immutable, meaning once created, their values cannot be changed. Any operation that modifies a string results in the creation of a new string object.
- **String Pool**: Strings created using double quotes (e.g., `"abcd"`) are stored in a special area of memory called the String Pool. If two string literals are the same, they reference the same object.
- **Concatenation**: The `+` operator is overloaded for string concatenation, which is internally implemented using `StringBuffer` or `StringBuilder`.
- **Character Representation**: Strings are backed by a character array and are represented in UTF-16 format.
- **Memory Management**: The immutability can lead to memory inefficiencies due to the creation of many temporary string objects during operations like concatenation or substring extraction.

### Problem with String in Java
One of its biggest strength Immutability is also biggest problem of Java String if not used correctly. many a times we create a String and then perform a lot of operation on them e.g. converting string into uppercase, lowercase , getting substring out of it, concatenating with other string etc. Since String is an immutable class every time a new String is created and older one is discarded which creates lots of temporary garbage in heap. If String are created using String literal they remain in String pool. To resolve this problem Java provides us two Classes StringBuffer and StringBuilder. String Buffer is an older class but StringBuilder is relatively new and added in JDK 5.

#### String
- **Immutability**: Strings are immutable, meaning once a `String` object is created, its value cannot be changed. Any operation that seems to modify the string (like concatenation) actually creates a new `String` object.
- **Performance**: Due to immutability, using `String` for multiple modifications (like concatenation in loops) can lead to performance issues and increased memory usage, as many temporary objects are created.
- **Use Case**: Best suited for cases where the string value does not need to change.

#### StringBuffer
- **Mutability**: `StringBuffer` is mutable, allowing you to modify the contents without creating new objects. This makes it more efficient for scenarios where strings need to be altered frequently.
- **Thread Safety**: All public methods in `StringBuffer` are synchronized, making it thread-safe. However, this synchronization can introduce performance overhead.
- **Use Case**: Ideal for use in a multi-threaded environment where multiple threads might be modifying the same string.

#### StringBuilder
- **Mutability**: Like `StringBuffer`, `StringBuilder` is also mutable, allowing in-place modifications without creating new objects.
- **Thread Safety**: `StringBuilder` is not synchronized, which makes it faster than `StringBuffer` for single-threaded scenarios.
- **Use Case**: Preferred in single-threaded contexts or situations where thread safety is not a concern, due to better performance.

### Summary of Differences
| Feature                  | String                  | StringBuffer            | StringBuilder            |
|--------------------------|-------------------------|-------------------------|--------------------------|
| **Mutability**           | Immutable               | Mutable                 | Mutable                  |
| **Thread Safety**        | N/A                     | Synchronized (thread-safe) | Not synchronized (faster) |
| **Performance**          | Slower for modifications | Slower due to synchronization | Faster due to no synchronization |
| **Conversion to String** | Use `toString()` method | Use `toString()` method | Use `toString()` method  |
| **Use Cases**            | For constant string values | For multi-threaded scenarios | For performance in single-threaded contexts |

Understanding these differences is crucial for optimizing performance and ensuring thread safety in your Java applications.

### Differences between String and StringBuffer in Java
Main difference between String and StringBuffer is String is immutable while StringBuffer is mutable means you can modify a StringBuffer object once you created it without creating any new object. This mutable property makes StringBuffer an ideal choice for dealing with Strings in Java. You can convert a StringBuffer into String by its toString() method. String vs StringBuffer or what is difference between StringBuffer and String is one of the popular Java interview questions for either phone interview or first round. Now days they also include StringBuilder and ask String vs StringBuffer vs StringBuilder. So be preparing for that. In the next section we will see difference between StringBuffer and StringBuilder in Java.

#### StringBuffer vs. StringBuilder

StringBuffer is very good with mutable String but it has one disadvantage all its public methods are synchronized which makes it thread-safe but same time slow. In JDK 5 they provided similar class called StringBuilder in Java which is a copy of StringBuffer but without synchronization. Try to use StringBuilder whenever possible it performs better in most of cases than StringBuffer class. You can also use "+" for concatenating two string because "+" operation is internal implemented using either StringBuffer or StringBuilder in Java. If you see StringBuilder vs StringBuffer you will find that they are exactly similar and all API methods applicable to StringBuffer are also applicable to StringBuilder in Java. On the other hand String vs StringBuffer is completely different and there API is also completely different, same is true for StringBuilder vs String.

- **Mutability**: Both `StringBuffer` and `StringBuilder` are mutable, meaning their content can be modified without creating new objects.
- **Thread Safety**:
  - **StringBuffer**: Methods are synchronized, making it thread-safe but slower due to the overhead of synchronization.
  - **StringBuilder**: Not synchronized, thus faster but not thread-safe.
- **Performance**: `StringBuilder` is generally preferred for single-threaded scenarios because it offers better performance due to the lack of synchronization overhead.

#### Key Differences
| Feature                  | String                  | StringBuffer            | StringBuilder            |
|--------------------------|-------------------------|-------------------------|--------------------------|
| **Mutability**           | Immutable               | Mutable                 | Mutable                  |
| **Thread Safety**        | N/A                     | Synchronized (thread-safe) | Not synchronized (faster) |
| **Performance**          | Slower for multiple operations due to immutability | Slower due to synchronization | Faster due to no synchronization |
| **Use Cases**            | When immutability is required | When thread safety is required | For high-performance scenarios without thread safety |
| **API Methods**          | Different from `StringBuffer` and `StringBuilder` | Similar to `StringBuilder` | Similar to `StringBuffer` |

### Summary
- Use **String** when you need an immutable sequence of characters.
- Use **StringBuffer** when you need a mutable string and thread-safety is required.
- Use **StringBuilder** when you need a mutable string in a single-threaded context for better performance. 

In summary here are list of difference between StringBuffer, String and StringBuilder in Java :
1) String is immutable while StringBuffer and StringBuilder is mutable object.
2) StringBuffer is synchronized while StringBuilder is not which makes StringBuilder faster than StringBuffer.
3) Concatenation operator "+" is internal implemented using either StringBuffer or StringBuilder.
4) Use String if you require immutability, use Stringbuffer in java if you need mutable + thread-safety and use StringBuilder in Java if you require mutable + without thread-safety.
   
### Reason Why Wait , Notify and NotifyAll are in Object Class.
Here are some thoughts on why they should not be in Thread class which make sense to me :
- 1) Wait and notify is not just normal methods or synchronization utility, more than that they are communication mechanism between two threads in Java. And Object class is correct place to make them available for every object if this mechanism is not available via any java keyword like synchronized. Remember synchronized and wait notify are two different area and don’t confuse that they are same or related. Synchronized is to provide mutual exclusion and ensuring thread safety of Java class like race condition while wait and notify are communication mechanism between two thread.
- 2 ) Locks are made available on per Object basis, which is another reason wait and notify is declared in Object class rather then Thread class.
- 3) In Java in order to enter critical section of code, Threads needs lock and they wait for lock, they don't know which threads holds lock instead they just know the lock is hold by some thread and they should wait for lock instead of knowing which thread is inside the synchronized block and asking them to release lock. this analogy fits with wait and notify being on object class rather than thread in Java.

### Why wait notify and notifyAll called from synchronized block or method in Java

We use wait () and notify () or notifyAll () method mostly for inter-thread communication. One thread is waiting after checking a condition e.g. In Producer Consumer example Producer Thread is waiting if buffer is full and Consumer thread notify Producer thread after he creates a space in buffer by consuming an element. calling notify() or notifyAll() issues a notification to a single or multiple thread that a condition has changed and once notification thread leaves synchronized block , all the threads which are waiting fight for object lock on which they are waiting and lucky thread returns from wait() method after reacquiring the lock and proceed further. Let’s divide this whole operation in steps to see a possibility of race condition between wait () and notify () method in Java, we will use Produce Consumer thread example to understand the scenario better:
   - 1. The Producer thread tests the condition (buffer is full or not) and confirms that it must wait (after finding buffer is full).
   - 2. The Consumer thread sets the condition after consuming an element from buffer.
   - 3. The Consumer thread calls the notify () method; this goes unheard since the Producer thread is not yet waiting.
   - 4. The Producer thread calls the wait () method and goes into waiting state.

So due to race condition here we potential lost a notification and if we use buffer or just one element Produce thread will be waiting forever and your program will hang.

Now let's think how does this potential race condition get resolved? This race condition is resolved by using synchronized keyword and locking provided by java. In order to call the wait (), notify () or notifyAll () methods in Java, we must have obtained the lock for the object on which we're calling the method. Since the wait () method in Java also releases the lock prior to waiting and reacquires the lock prior to returning from the wait () method, we must use this lock to ensure that checking the condition (buffer is full or not) and setting the condition (taking element from buffer) is atomic which can be achieved by using synchronized method or block in Java.

I am not sure if this is what interviewer was actually expecting but this what I thought would at least make sense, please correct me If I wrong and let us know if there is any other convincing reason of calling wait(), notify() or notifyAll method in Java.

Just to summarize we call wait (), notify () or notifyAll method in Java from synchronized method or synchronized block in Java to avoid:
- 1) IllegalMonitorStateException in Java which will occur if we don't call wait (), notify () or notifyAll () method from synchronized context.
- 2) Any potential race condition between wait and notify method in Java.

### What is the difference between Enumeration and Iterator?

Only major difference between Enumeration and iterator is Iterator has a remove() method while Enumeration doesn't. Enumeration acts as Read-only interface, because it has the methods only to traverse and fetch the objects, where as by using Iterator we can manipulate the objects like adding and removing the objects from collection e.g. Arraylist.
Also Iterator is more secure and safe as compared to Enumeration because it  does not allow other thread to modify the collection object while some thread is iterating over it and throws ConcurrentModificationException. This is by far most important fact for me for deciding between Iterator vs Enumeration in Java.

In Summary both Enumeration and Iterator will give successive elements, but Iterator is new and improved version where method names are shorter, and has new method called remove. Here is a short comparison:

Enumeration
hasMoreElement()
nextElement()
N/A

Iterator
hasNext()
next()
remove()

So Enumeration is used whenever we want to make Collection objects as Read-only.

### Difference between fail-fast Iterator vs fail-safe Iterator in Java
- fail-fast Iterators in Java

As name suggest fail-fast Iterators fail as soon as they realized that structure of Collection has been changed since iteration has begun. Structural changes mean adding, removing or updating any element from collection while one thread is Iterating over that collection. fail-fast behaviour is implemented by keeping a modification count and if iteration thread realizes the change in modification count it throws ConcurrentModificationException.

Java doc says this is not a guaranteed behavior instead its done of "best effort basis", So application programming cannot rely on this behavior. Also since multiple threads are involved while updating and checking modification count and this check is done without synchronization, there is a chance that Iteration thread still sees a stale value and might not be able to detect any change done by parallel threads. Iterators returned by most of JDK1.4 collection are fail-fast including Vector, ArrayList, HashSet etc. to read more about Iterator see my post what is Iterator in Java.

- fail-safe Iterator in java
Contrary to fail-fast Iterator, fail-safe iterator doesn't throw any Exception if Collection is modified structurally while one thread is Iterating over it because they work on clone of Collection instead of original collection and that’s why they are called as fail-safe iterator. Iterator of CopyOnWriteArrayList is an example of fail-safe Iterator also iterators written by ConcurrentHashMap keySet is also fail-safe iterator and never throw ConcurrentModificationException in Java.

### How HashMap works in Java
How HashMap works in Java or sometime how get method work in HashMap is common questions on Java interviews now days. Almost everybody who worked in Java knows about HashMap, where to use HashMap or difference between Hashtable and HashMap then why this interview question becomes so special? Because of the depth it offers. It has become very popular java interview question in almost any senior or mid-senior level Java interviews. Investment banksmostly prefer to ask this question and sometime even ask to implement your own HashMap based upon your coding aptitude. Introduction of ConcurrentHashMap and other concurrent collections has also made these questions as starting point to delve into more advanced feature. Let’s start the journey.

### Questions start with simple statement 

"Have you used HashMap before" or”What is HashMap? Why do we use it “
Almost everybody answers this with yes and then interviewee keep talking about common facts about HashMap like HashMap accept null while Hashtable doesn't, HashMap is not synchronized, HashMap is fast and so on along with basics like its stores key and value pairs etc. This shows that person has used HashMap and quite familiar with the functionality HashMap offers but interview takes a sharp turn from here and next set of follow-up questions gets more detailed about fundamentals involved with HashMap in Java. Interviewer struck back with questions like

### "Do you Know how HashMap works in Java” or "How does get () method of HashMap works in Java"
And then you get answers like I don't bother its standard Java API, you better look code on Java source or Open JDK; I can find it out in Google at any time etc. But some interviewee definitely answer this and will say "HashMap works on principle of hashing, we have put(key, value) and get(key) method for storing and retrieving Objects from HashMap. When we pass Key and Value object to put() method on Java HashMap, HashMap implementation callshashCode method on Key object and applies returned hashcode into its own hashing function to find a bucket location for storing Entry object, important point to mention is that HashMap in Java stores both key and value object as Map.Entry in bucket which is essential to understand the retrieving logic. If people fails to recognize this and say it only stores Value in the bucket they will fail to explain the retrieving logic of any object stored in Java HashMap. This answer is very much acceptable and does make sense that interviewee has fair bit of knowledge on how hashing works and how HashMap works in Java. But this is just start of story and confusion increases when you put interviewee on scenarios faced by Java developers on day by day basis. Next question could be about collision detection and collision resolution in Java HashMap e.g. 

### "What will happen if two different objects have same hashcode?”
Now from here onwards real confusion starts, Sometime candidate will say that since hashcode is equal, both objects are equal and HashMap  will throw exception or not store them again etc, Then you might want to remind them about equals() and hashCode() contract  that two unequal object in Java can have same hashcode. Some will give up at this point and few will move ahead and say "Since hashcode is same, bucket location would be same and collision will occur in HashMap, Since HashMap use LinkedList to store object, this entry (object of Map.Entry comprise key and value) will be stored in LinkedList. Great this answer makes sense though there are many collision resolution methods available this is simplest and HashMap in Java does follow this. But story does not end here and interviewer asks

### "How will you retrieve Value object if two Keys will have same hashcode?”
Interviewee will say we will call get() method and then HashMap uses Key Object's hashcode to find out bucket location and retrieves Value object but then you need to remind him that there are two Value objects are stored in same bucket , so they will say about traversal in LinkedList until we find the value object , then you ask how do you identify value object because you don't  have value object to compare ,Until they know that HashMap  stores both Key and Value in LinkedList node or as Map.Entry they won't be able to resolve this issue and will try and fail.

But those bunch of people who remember this key information will say that after finding bucket location , we will call keys.equals() method to identify correct node in LinkedList and return associated value object for that key in Java HashMap . Perfect this is the correct answer.

In many cases interviewee fails at this stage because they get confused between hashCode() and equals() or keys and values object in Java HashMap  which is pretty obvious because they are dealing with the hashcode() in all previous questions and equals() come in picture only in case of retrieving value object from HashMap in Java. Some good developer point out here that using immutable, final object with proper equals() and hashcode() implementation would act as perfect Java HashMap  keys and improve performance of Java HashMap  by reducing collision. Immutability also allows caching there hashcode of different keys which makes overall retrieval process very fast and suggest that String and various wrapper classes e.g. Integer very good keys in Java HashMap.

Now if you clear this entire Java HashMap interview, you will be surprised by this very interesting question "What happens On HashMap in Java if the size of the HashMap exceeds a given threshold defined by load factor?” Until you know how HashMap works exactly you won't be able to answer this question. If the size of the Map exceeds a given threshold defined by load-factor e.g. if load factor is .75 it will act to re-size the map once it filled 75%. Similar to other collection classes like ArrayList, Java HashMap re-size itself by creating a new bucket array of size twice of previous size of HashMap, and then start putting every old element into that new bucket array. This process is called rehashing because it also applies hash function to find new bucket location. 

If you manage to answer this question on HashMap in Java you will be greeted by "do you see any problem with resizing of HashMap in Java”, you might not be able to pick the context and then he will try to give you hint about multiple thread accessing the Java HashMap and potentially looking for race condition on HashMap in Java. 

So the answer is Yes there is potential race condition exists while resizing HashMap in Java, if two thread at the same time found that now HashMap needs resizing and they both try to resizing. on the process of resizing of HashMap in Java , the element in bucket which is stored in linked list get reversed in order during their migration to new bucket because java HashMap  doesn't append the new element at tail instead it append new element at head to avoid tail traversing. If race condition happens then you will end up with an infinite loop. Though this point you can potentially argue that what the hell makes you think to use HashMap in multi-threaded environment to interviewer :)

### Few more question on HashMap in Java which is contributed by readers of Javarevisited blog:
- 1) Why String, Integer and other wrapper classes are considered good keys?
String, Integer and other wrapper classes are natural candidates of HashMap key, and String is most frequently used key as well because final, and overrides equals and hashcode() method. Other wrapper class also shares similar property. Immutabiility is required, in order to prevent changes on fields used to calculate hashCode() because if key object return different hashCode during insertion and retrieval than it won't be possible to get object from HashMap. Immutability is best as it offers other advantages as well like thread-safety, if you can keep your hashCode same by only making certain fields final, then you go for that as well. Since equals() and hashCode() method is used during reterival of value object from HashMap, it’s important that key object correctly override these methods and follow contact. If unequal object return different hashcode than chances of collision will be less which subsequently improve performance of HashMap.

- 2) Can we use any custom object as key in HashMap?
This is an extension of previous questions. Ofcourse you can use any Object as key in Java HashMap provided it follows equals and hashCode contract and its hashCode should not vary once the object is inserted into Map. If custom object is Immutable than this will be already taken care because you cannot change it once created.

- 3) Can we use ConcurrentHashMap in place of Hashtable?
This is another question which getting popular due to increasing popularity of ConcurrentHashMap. Since we know Hashtable is synchronized but ConcurrentHashMap provides better concurrency by only locking portion of map determined by concurrency level. ConcurrentHashMap is certainly introduced as Hashtable and can be used in place of it but Hashtable provide stronger thread-safety than ConcurrentHashMap. See my post difference between Hashtable and ConcurrentHashMap for more details.

Personally, I like this question because of its depth and number of concept it touches indirectly, if you look at questions asked during interview this HashMap questions has verified
•	Concept of hashing
•	Collision resolution in HashMap
•	Use of equals () and hashCode () and there importance in HashMap?
•	Benefit of immutable object?
•	Race condition on HashMap  in Java
•	Resizing of Java HashMap
Just to summarize here are the answers which does makes sense for above questions

### How HashMap works in Java
HashMap  works on principle of hashing, we have put() and get() method for storing and retrieving object form HashMap .When we pass an both key and value to put() method to store on HashMap , it uses key object hashcode() method to calculate hashcode and they by applying hashing on that hashcode it identifies bucket location for storing value object. While retrieving it uses key object equals method to find out correct key value pair and return value object associated with that key. HashMap uses linked list in case of collision and object will be stored in next node of linked list.
Also HashMap stores both key+value tuple in every node of linked list.

### What will happen if two different HashMap key objects have same hashcode?
They will be stored in same bucket but no next node of linked list. And keys equals () method will be used to identify correct key value pair in HashMap.

In terms of usage Java HashMap is very versatile and I have mostly used HashMap as cache in electronic trading application I have worked. Since finance domain used Java heavily and due to performance reason we need caching HashMap and ConcurrentHashMap comes as very handy there. You can also check following articles form Javarevisited to learn more about HashMap and Hashtable in Java:

### GET and POST method in HTTP and HTTPS Protocol
GET and POST method in HTTP and HTTPS are two most popular methods used to transfer data from client to server using HTTP (Hyper Text Transfer Protocol) protocol. Both GET and POST can be used to send request and receive response but there are significant difference between them. Difference between GET and POST in HTTP or HTTPS is also a popular interview question in JSP and any web programming interview. Since HTML is independent of any web server technology like Java, ASP or PHP and HTTP is core protocol in space of internet, importance of clear understanding of GET and POST method cannot be ignored. In this tutorial we will what is GET HTTP Request, What is POST HTTP Request, when to use GET and POST HTTP method and finally some difference between GET and POST method in HTTP protocol.

### What is GET HTTP Request in http
HTTP protocol supports several request method you can use while sending request using HTTP or HTTPS protocol. GET is one of them. As the name suggests GET method is to retrieve a page from HTTP Server. You can identify a GET request by looking method attribute on HTTP Request part. If you are using Netbeans IDE for Java web development you can enable HTTP Server monitor which can capture HTTP request and show details of request parameters, headers and other useful information. for GET HTTP request method will be GET for example almost all the URL which is accessible using link are accessed using HTTP Request. One important property of GET request is that any request parameter or query parameter is passed as URL encoded string, appended using "?" character which makes it non secure because whatever information you pass in URL String is visible to everybody. Though GET method has some very interesting and powerful use cases which we will see in next section: When to use GET HTTP Request?

### When to use HTTP GET request
As I said GET method is not secure and hence not a suitable choice for transferring confidential data but GET method is extremely useful for retrieving static content from web server. Here are some examples where using GET methods make sense:
1) There is no side effect of repeated request. For example clicking a link which points to another page. It doesn't matter if you click the link twice or thrice, this also gives chance browser of server to catch the response for faster retrieval.
2) You are not passing any sensitive and confidential information. Instead you just pass some configuration data or session id.
3) You want URL pointed by HTTP GET request to be bookmark-able.
4) Data requires to be sent to Server is not large and can safely accommodated in maximum length of URL supported by all browser. In general different browser has different character limit for URL length but having it under limit is good choice.
5) 
### What is POST HTTP method
POST HTTP request is denoted by method: POST in HTTP request. In POST method data is not sent as part of URL string to server instead in POST, data is sent as part of message body. Almost all authentication requests are sent via POST method in HTTP world. POST method is secure because data is not visible in URL String and can be safely encrypted using HTTPS for further security. All sensitive and confidential information sent to be server must go on POST request and via HTTPS (HTTP with SSL). POST method is also used for submitting information to server, any information which can alter state of application like adding item into shopping cart, making payments etc. here are some examples where you should consider using POST method in HTTP request:
1) Use POST if you are sending large data which cannot be fit into URL in case of GET.
2) Use POST method if you are passing sensitive and confidential information to server e.g. user_id, password, account number etc.
3) Use POST method if you are submitting data which can alter state of application e.g. adding items into cart for passing that cart for payment processing.
4) Use POST if you are writing secure application and don't want to show query parameters in URL.

### Difference between GET and POST method in HTTP Protocol
Most of the difference between GET and POST has been already discussed in their respective section. It all depends upon requirement when you want to choose GET and POST and knowledge of these differences help you to make that decision.
1) GET method passes request parameter in URL String while POST method passes request parameter in request body.
2) GET request can only pass limited amount of data while POST method can pass large amount of data to server.
3) GET request can be bookmarked and cached unlike POST requests.
4) GET is mostly used for view purpose (e.g. SQL SELECT) while POST is mainly use for update purpose (e.g. SQL INSERT or UPDATE).

### Difference between Thread and Runnable interface in Java
Thread vs Runnable in Java

Here are some of my thoughts on whether I should use Thread or Runnable for implementing task in Java, though you have another choice as "Callable" for implementing thread which we will discuss later.

1) Java doesn't support multiple inheritances, which means you can only extend one class in Java so once you extended Thread class you lost your chance and cannot extend or inherit another class in Java.
2) In Object oriented programming extending a class generally means adding new functionality, modifying or improving behaviours. If we are not making any modification on Thread than use Runnable interface instead.
3) Runnable interface represent a Task which can be executed by either plain Thread or Executors or any other means. So logical separation of Task as Runnable than Thread is good design decision.
4) Separating task as Runnable means we can reuse the task and also has liberty to execute it from different means. Since you cannot restart a Thread once it completes. Again Runnable vs Thread for task, Runnable are winner.
5) Java designer recognizes this and that's why Executors accept Runnable as Task and they have worker thread which executes those task.
6) Inheriting all Thread methods are additional overhead just for representing a Task which can be done easily with Runnable.

### Why Java doesn't support multiple inheritance
1) First reason is ambiguity around Diamond problem, consider a class A has foo() method and then B and C derived from A and has their own foo() implementation and now class D derive from B and C using multiple inheritance and if we refer just foo() compiler will not be able to decide which foo() it should invoke. This is also called Diamond problem because structure on this inheritance scenario is similar to 4 edge diamond, see below

         A foo()
           / \
          /   \
   foo() B     C foo()
          \   /
           \ /
            D
           foo()

In my opinion even if we remove the top head of diamond class A and allow multiple inheritances we will see this problem of ambiguity.

Sometimes if you give this reason to interviewer he asks if C++ can support multiple inheritance than why not Java. Hmmmmm in that case I would try to explain him the second reason which I have given below that it’s not because of technical difficulty but more too maintainable and clearer design was driving factor though this can only be confirmed by any of java designer and we can just speculate. Wikipedia link has some good explanation on how different language address problem arises due to diamond problem while using multiple inheritances.

2) Second and more convincing reason to me is that multiple inheritances does complicate the design and creates problem during casting, constructor chaining etc. and given that there are not many scenario on which you need multiple inheritance its wise decision to omit it for the sake of simplicity. Also java avoids this ambiguity by supporting single inheritance with interfaces. Since interface only have method declaration and doesn't provide any implementation there will only be just one implementation of specific method hence there would not be any ambiguity.

### What is Synchronization in Java
Synchronization in Java is an important concept since Java is a multi-threaded language where multiple threads run in parallel to complete program execution. In multi-threaded environment synchronization of Java object or synchronization of Java class becomes extremely important. Synchronization in Java is possible by using Java keywords "synchronized" and "volatile”. Concurrent access of shared objects in Java introduces to kind of errors: thread interference and memory consistency errors and to avoid these errors you need to properly synchronize your Java object to allow mutual exclusive access of critical section to two threads. By the way This Java Synchronization tutorial is in continuation of my article How HashMap works in Java  and difference between HashMap and Hashtable in Java  if you haven’t read already you may find some useful information based on my experience in Java Collections.

### Why do we need Synchronization in Java?
If your code is executing in multi-threaded environment, you need synchronization for objects, which are shared among multiple threads, to avoid any corruption of state or any kind of unexpected behavior. Synchronization in Java will only be needed if shared object is mutable. if your shared object is either read only or immutable object, than you don't need synchronization, despite running multiple threads. Same is true with what threads are doing with object if all the threads are only reading value then you don't require synchronization in Java. JVM guarantees that Java synchronized code will only be executed by one thread at a time. In Summary Java synchronized Keyword provides following functionality essential for concurrent programming : 

1) synchronized keyword in Java provides locking, which ensures mutual exclusive access of shared resource and prevent data race.

2) synchronized keyword also prevent reordering of code statement by compiler which can cause subtle concurrent issue if we don't use synchronized or volatile keyword.

3) synchronized keyword involve locking and unlocking. before entering into synchronized method or block thread needs to acquire the lock, at this point it reads data from main memory than cache and when it release the lock, it flushes write operation into main memory which eliminates memory inconsistency errors.

### Synchronized keyword in Java
Prior to Java 1.5 synchronized keyword was only way to provide synchronization of shared object in Java. Any code written by using  synchronized block or enclosed inside synchronized method will be mutually exclusive, and can only be executed by one thread at a time. You can have both static synchronized method and non static synchronized method and synchronized blocks in Java but we can not have synchronized variable in java. Using synchronized keyword with variable is illegal and will result in compilation error. Instead of synchronized variable in Java, you can have java volatile variable, which will instruct JVM threads to read value of volatile variable from main memory and don’t cache it locally. Block synchronization in Java is preferred over method synchronization in Java because by using block synchronization, you only need to lock the critical section of code instead of whole method. Since synchronization in Java comes with cost of performance, we need to synchronize only part of code which absolutely needs to be synchronized.

### Example of Synchronized Method in Java
Using synchronized keyword along with method is easy just apply synchronized keyword in front of method. What we need to take care is that static synchronized method locked on class object lock and non static synchronized method locks on current object (this). So it’s possible that both static and non static java synchronized method running in parallel.  This is the common mistake a naive developer do while writing Java synchronized code.
```java
public class Counter{

  private static int count = 0;

  public static synchronized int getCount(){
    return count;
  }

  public synchoronized setCount(int count){
     this.count = count;
  }

}
```

In this example of Java synchronization code is not properly synchronized because both getCount() and setCount() are not getting locked on same object and can run in parallel which may results in incorrect count. Here getCount() will lock in Counter.class object while setCount() will lock on current object (this). To make this code properly synchronized in Java you need to either make both method static or non static or use java synchronized block instead of java synchronized method.By the way this is one of the common mistake Java developers make while synchronizing their code.

### Example of Synchronized Block in Java
Using synchronized block in java is also similar to using synchronized keyword in methods. Only important thing to note here is that if object used to lock synchronized block of code, Singleton.class in below example is null then Java synchronized block will throw a NullPointerException.
public class Singleton{

private static volatile Singleton _instance;

public static Singleton getInstance(){
   if(_instance == null){
            synchronized(Singleton.class){
              if(_instance == null)
              _instance = new Singleton();
            }
   }
   return _instance;
}

This is a classic example of double checked locking in Singleton. In this example of Java synchronized code, we have made only critical section (part of code which is creating instance of singleton) synchronized and saved some performance. If you make whole method synchronized than every call of this method will be blocked, while you only need blocking to create singleton instance on first call. By the way, this is not the only way to write thread-safe singleton in Java. You can use Enum, or lazy loading to avoid thread-safety issue during instantiation. Even above code will not behave as expected because prior to Java 1.5, double checked locking was broker and even with volatile variable you can view half initialized object. Introduction of Java memory model and happens before guarantee in Java 5 solves this issue. To read more about Singleton in Java see that.

### Important points of synchronized keyword in Java
1. Synchronized keyword in Java is used to provide mutual exclusive access of a shared resource with multiple threads in Java. Synchronization in Java guarantees that, no two threads can execute a synchronized method which requires same lock simultaneously or concurrently.
2. You can use java synchronized keyword only on synchronized method or synchronized block.
3. Whenever a thread enters into java synchronized method or block it acquires a lock and whenever it leaves java synchronized method or block it releases the lock. Lock is released even if thread leaves synchronized method after completion or due to any Error or Exception.
4. Java Thread acquires an object level lock when it enters into an instance synchronized java method and acquires a class level lock when it enters into static synchronized java method.
5. Java synchronized keyword is re-entrant in nature it means if a java synchronized method calls another synchronized method which requires same lock then current thread which is holding lock can enter into that method without acquiring lock.
6. Java Synchronization will throw NullPointerException if object used in java synchronized block is null e.g. synchronized (myInstance) will throws java.lang.NullPointerException if myInstance is null.
7. One Major disadvantage of Java synchronized keyword is that it doesn't allow concurrent read, which can potentially limit scalability. By using concept of lock stripping and using different locks for reading and writing, you can overcome this limitation of synchronized in Java. You will be glad to know that java.util.concurrent.locks.ReentrantReadWriteLock provides ready made implementation of ReadWriteLock in Java.
8. One more limitation of java synchronized keyword is that it can only be used to control access of shared object within the same JVM. If you have more than one JVM and need to synchronized access to a shared file system or database, the Java synchronized keyword is not at all sufficient. You need to implement a kind of global lock for that.
9. Java synchronized keyword incurs performance cost. Synchronized method in Java is very slow and can degrade performance. So use synchronization in java when it absolutely requires and consider using java synchronized block for synchronizing critical section only.
10. Java synchronized block is better than java synchronized method in Java because by using synchronized block you can only lock critical section of code and avoid locking whole method which can possibly degrade performance. A good example of java synchronization around this concept is getInstance() method Singleton class. See here.
11. it’s possible that both static synchronized and non-static synchronized method can run simultaneously or concurrently because they lock on different object.
12. From java 5 after change in Java memory model reads and writes are atomic for all variables declared using volatile keyword (including long and double variables) and simple atomic variable access is more efficient instead of accessing these variables via synchronized java code. But it requires more care and attention from the programmer to avoid memory consistency errors.
13. Java synchronized code could result in deadlock or starvation while accessing by multiple thread if synchronization is not implemented correctly. To know how to avoid deadlock in java see here.
14. According to the Java language specification you cannot use Java synchronized keyword with constructor it’s illegal and result in compilation error. So you cannot synchronize constructor in Java which seems logical because other threads cannot see the object being created until the thread creating it has finished it.
15. You cannot apply java synchronized keyword with variables and cannot use java volatile keyword with method.
16. Java.util.concurrent.locks extends capability provided by java synchronized keyword for writing more sophisticated programs since they offer more capabilities e.g. Reentrancy and interruptible locks.
17. Java synchronized keyword also synchronizes memory. In fact java synchronized synchronizes the whole of thread memory with main memory.
18. Important method related to synchronization in Java are wait(), notify() and notifyAll() which is defined in Object class. Do you know why they are defined in java.lang.object class instead of java.lang.Thread? You can find some reasons, which make sense.

19. Do not synchronize on non-final field on synchronized block in Java. Because reference of non-final field may change any time and then different thread might synchronizing on different objects i.e. no synchronization at all. Example of synchronizing on non-final field:
```java
private String lock = new String("lock");
synchronized(lock){
System.out.println("locking on :"  + lock);
}
```
any if you write synchronized code like above in java you may get warning "Synchronization on non-final field"  in IDE like Netbeans and InteliJ

20. Its not recommended to use String object as lock in java synchronized block because string is immutable object and literal string and interned string gets stored in String pool. so by any chance if any other part of code or any third party library used same String as there lock then they both will be locked on same object despite being completely unrelated which could result in unexpected behaviour and bad performance. Instead of String object its advised to use new Object() for Synchronization in Java on synchronized block.
```java
private static final String LOCK = "lock";   //not recommended
private static final Object OBJ_LOCK = new Object(); //better

public void process() {
   synchronized(LOCK) {
      ........
   }
}
```
21. From Java library Calendar and SimpleDateFormat classes are not thread-safe and requires external synchronization in Java to be used in multi-threaded environment.  

Probably most important point about Synchronization in Java is that, in the absence of synchronized keyword or other construct e.g. volatile variable or atomic variable, compiler, JVM and hardware are free to make optimization, assumption, reordering or caching of code and data, which can cause subtle concurrency bugs in code. By introducing synchronization by using volatile, atomic variable or synchronized keyword, we instruct compiler and JVM to not to do that.

- Update 1: Recently I have been reading several Java Synchronization and Concurrency articles in internet and I come across jeremymanson's blog which works in google and has worked on JSR 133 Java Memory Model, I would recommend some of this blog post for every java developer, he has covered certain details about concurrent programming , synchronization and volatility in simple and easy to understand language, here is the link atomicity, visibility and ordering. 

- Update 2:  I am grateful to my readers, who has left some insightful comments on this post. They have shared lots of good information and experience and to provide them more exposure, I am including some of there comments on main article, to benefit new readers. 


Good comprehensive article about synchronized keyword in Java. to be honest I have never read all these details about synchronized block or method at one place. you may want to highlight some limitation of synchronized keyword in Java which is addressed by explicit locking using new concurrent package and Lock interface :

1. synchronized keyword doesn't allow separate locks for reading and writing. as we know that multiple thread can read without affecting thread-safety of class, synchronized keyword suffer performance due to contention in case of multiple reader and one or few writer.

 2. If one thread is waiting for lock then there is no way to time out, thread can wait indefinitely for lock.
 3. on similar note if thread is waiting for lock to acquire there is no way to interrupt the thread.
 
All these limitation of synchronized keyword is addressed and resolved by using ReadWriteLock and ReentrantLock in Java 5. 

Just my 2 cents on your great list of Java Synchronization facts and best practices :
 
1) synchronized keyword in internally implemented using two byte code instructions MonitorEnter and MonitorExit, this is generated by compiler. Compiler also ensures that there must be a MonitorExit for every MonitorEnter in different code path e.g. normal execution and abrupt execution, because of Exception.
2) java.util.concurrent package different locking mechanism than provided by synchronized keyword, they mostly used ReentrantLock, which internally use CAS operations, volatile variables and atomic variables to get better performance.
3) With synchronized keyword, you have to leave the lock, once you exist a synchronized method or block; there is no way you can take the lock to other method. java.util.concurrent.locks.ReentrantLock solves this problem by providing control for acquiring and releasing lock, which means you can acquire lock in method A and can release in method B, if they both needs to be locked in same object lock. Though this could be risky as compiler will neither check nor warn you about any accidental leak of locks. Which means, this can potentially block other threads, which are waiting for same lock?
4) Prefer ReentrantLock over synchronized keyword, it provides more control on lock acquisition, lock release and better performance compared to synchronized keyword.
 
5) Any thread trying to acquire lock using synchronized method will block indefinitely, until lock is available. Instead this, tryLock() method of java.util.concurrent.locks.ReentrantLock will not block if lock is not available.

### What is Encapsulation in Java
Encapsulation is nothing but protecting anything which is prone to change. Rational behind encapsulation is that if any functionality which is well encapsulated in code i.e. maintained in just one place and not scattered around code is easy to change. This can be better explained with a simple example of encapsulation in Java. We all know that constructor is used to create object in Java and constructor can accept argument. Suppose we have a class Loan has a constructor and then in various classes you have created instance of loan by using this constructor. Now requirements change and you need to include age of borrower as well while taking loan. Since this code is not well encapsulated i.e. not confined in one place you need to change everywhere you are calling this constructor i.e. for one change you need to modify several file instead of just one file which is more error prone and tedious, though it can be done with refactoring feature of advanced IDE wouldn't it be better if you only need to make change at one place? Yes that is possible if we encapsulate Loan creation logic in one method say createLoan() and client code call this method and this method internally crate Loan object. in this case you only need to modify this method instead of all client code.

Example of Encapsulation in Java
```java
class Loan{
    private int duration;  //private variables examples of encapsulation
    private String loan;
    private String borrower;
    private String salary;
   
    //public constructor can break encapsulation instead use factory method
    private Loan(int duration, String loan, String borrower, String salary){
        this.duration = duration;
        this.loan = loan;
        this.borrower = borrower;
        this.salary = salary;
    }
   
    //no argument consustructor omitted here
    
   // create loan can encapsulate loan creation logic
    public Loan createLoan(String loanType){
  
     //processing based on loan type and than returning loan object
      return loan;
    }
   
}
```
In this same example of Encapsulation in Java you see all member variables are made private so they are well encapsulated you can only change or access this variable directly inside this class. if you want to allow outside world to access these variables is better creating a getter and setter e.g. getLoan() that allows you to do any kind of validation, security check before return loan so it gives you complete control of whatever you want to do and single channel of access for client which is controlled and managed.

### Advantage of Encapsulation in Java and OOPS
Here are few advantages of using Encapsulation while writing code in Java or any Object oriented programming language:
1. Encapsulated Code is more flexible and easy to change with new requirements.
2. Encapsulation in Java makes unit testing easy.
3. Encapsulation in Java allows you to control who can access what.
4. Encapsulation also helps to write immutable class in Java which are a good choice in multi-threading environment.
5. Encapsulation reduce coupling of modules and increase cohesion inside a module because all piece of one thing are encapsulated in one place.
6. Encapsulation allows you to change one part of code without affecting other part of code.

### What should you encapsulate in code?
Anything which can be change and more likely to change in near future is candidate of Encapsulation. This also helps to write more specific and cohesive code. Example of this is object creation code, code which can be improved in future like sorting and searching logic.

### Design Pattern based on Encapsulation in Java
Many design pattern in Java uses encapsulation concept, one of them is Factory pattern which is used to create objects. Factory pattern is better choice than new operator for creating object of those classes whose creation logic can vary and also for creating different implementation of same interface. BorderFactory class of JDK is a good example of encapsulation in Java which creates different types of Border and encapsulates creation logic of Border. Singleton pattern in Java also encapsulate how you create instance by providing getInstance() method. Since object is created inside one class and not from any other place in code you can easily change how you create object without affect other part of code.

Important point’s about encapsulation in Java.
1. "Whatever changes encapsulate it" is a famous design principle.
2. Encapsulation helps in loose coupling and high cohesion of code.
3. Encapsulation in Java is achieved using access modifier private, protected and public.
4. Factory pattern, Singleton pattern in Java makes good use of Encapsulation.

### What is polymorphism in Java
Polymorphism is an Oops concept which advice use of common interface instead of concrete implementation while writing code. When we program for interface our code is capable of handling any new requirement or enhancement arise in near future due to new implementation of our common interface. If we don't use common interface and rely on concrete implementation, we always need to change and duplicate most of our code to support new implementation. It’s not only Java but other object oriented language like C++ also supports polymorphism and it comes as fundamental along with other OOPS concepts like Encapsulation , Abstraction and Inheritance.

### How Polymorphism supported in Java
Java has excellent support of polymorphism in terms of Inheritance, method overloading and method overriding. Method overriding allows Java to invoke method based on a particular object at run-time instead of declared type while coding. To get hold of concept let's see an example of polymorphism in Java:
```java
public class TradingSystem{
   public String getDescription(){
      return "electronic trading system";
   }
}
public class DirectMarketAccessSystem extends TradingSystem{
   public String getDescription(){
     return "direct market access system";
   }
}
public class CommodityTradingSystem extends TradingSystem{
   public String getDescription(){
     return "Futures trading system";
   }
}
```
Here we have a super class called TradingSystem and there two implementation DirectMarketAccessSystem and CommodityTradingSystem and here we will write code which is flexible enough to work with any future implementation of TradingSystem we can achieve this by using Polymorphism in Java which we will see in further example.

### Where to use Polymorphism in code
Probably this is the most important part of this Java Polymorphism tutorial and It’s good to know where you can use Polymorphism in Java while writing code. Its common practice to always replace concrete implementation with interface it’s not that easy and comes with practice but here are some common places where I check for polymorphism:

### 1) Method argument:
Always use super type in method argument that will give you leverage to pass any implementation while invoking method. For example:
```java
public void showDescription(TradingSystem tradingSystem){
   tradingSystem.description();
}
```
If you have used concrete implementation e.g. CommodityTradingSystem or DMATradingSystem then that code will require frequent changes whenever you add new Trading system.

### 2) Variable names:
Always use Super type while you are storing reference returned from any Factory method in Java, This gives you flexibility to accommodate any new implementation from Factory. Here is an example of polymorphism while writing Java code which you can use retrieving reference from Factory:
```java
String systemName = Configuration.getSystemName();
TradingSystem system = TradingSystemFactory.getSystem(systemName);
```
### 3) Return type of method
Return type of any method is another place where you should be using interface to take advantage of Polymorphism in Java. In fact this is a requirement of Factory design pattern in Java to use interface as return type for factory method.
```java
public TradingSystem getSystem(String name){
   //code to return appropriate implementation
}
```
### Method overloading and method overriding in Java
Method overloading and method overriding uses concept of Polymorphism in Java where method name remains same in two classes but actual method called by JVM depends upon object at run time and done by dynamic binding in Java. Java supports both overloading and overriding of methods. In case of overloading method signature changes while in case of overriding method signature remains same and binding and invocation of method is decided on runtime based on actual object. This facility allows Java programmer to write very flexibly and maintainable code using interfaces without worrying about concrete implementation. One disadvantage of using Polymorphism in code is that while reading code you don't know the actual type which annoys while you are looking to find bugs or trying to debug program. But if you do Java debugging in IDE you will definitely be able to see the actual object and the method call and variable associated with it.

### Parametric Polymorphism in Java
Java started to support parametric polymorphism with introduction of Generic in JDK1.5. Collection classes in JDK 1.5 are written using Generic Type which allows Collections to hold any type of object in run time without any change in code and this has been achieved by passing actual Type as parameter. For example see the below code of a parametric cache written using Generic which shows use of parametric polymorphism in Java. Read how to create Generic class and methods in Java for more details.
```java
interface cache{
  public void put(K key, V value);
  public V get(K key);
}
```
### What is abstract class in Java
An abstract class is something which is incomplete and you cannot create instance of abstract class. If you want to use it you need to make it complete or concrete by extending it. A class is called concrete if it does not contain any abstract method and implements all abstract method inherited from abstract class or interface it has implemented or extended. By the way Java has concept of abstract classes, abstract method but a variable cannot be abstract in Java. Popular example of abstract class in Java is ActionListener which has abstract method called actionPerformed(ActionEvent ae). This method is called when an ActionEvent is fired like when you click on JButton. Its common in java to attach ActionListener with JButton by implementing abstract method actionPerformed(ActionEvent ae) using Anonymous class, as shown in belowExample :
```java
JButton  ok = new JButton("OK");
ok.addActionListener(new ActionListener(){
           public void  actionPerformed(ActionEvent ae){
               //code to handle event
           }
});
```

An abstract method in Java doesn't have body, it’s just a declaration. In order to use abstract method you need to override that method in SubClass.

### So when do you use abstraction? (Most important in my view)
When you know something needs to be there but not sure how exactly it should look like.

E.g. when I am creating a class called Vehicle, I know there should be methods like start() and Stop() but don't know start and stop mechanism of every vehicle since they could have different start and stop mechanism e.g. some can be started by kick or some can be by pressing buttons .

The same concepts apply to interface in Java  also, which we will discuss in some other post.

So implementation of those start() and stop() methods should be left to their concrete implementation e.g. Scooter , MotorBike , Car etc.

In Java Interface is an another way of providing abstraction, Interfaces are by default abstract and only contains public static, final constant or abstract methods. It’s very common interview question is that where should we use abstract class and where should we use Java Interfaces in my view this is important to understand to design better Java application, you can go for java interface if you only know the name of methods your class should have e.g. for Server it should have start() and stop() method but we don't know how exactly these start and stop method will work. If you know some of the behaviours while designing class and that would remain common across all subclasses add that into abstract class. Interface like Runnable are good example of abstraction in Java which is used to abstract task executed by multiple thread.

### In Summary
1) Use abstraction if you know something needs to be in class but implementation of that varies.
2) In Java you cannot create instance of abstract class, its compiler error.
3) abstract is a keyword in java.
4) a class automatically becomes abstract class when any of its method declared as abstract.
5) abstract method doesn't have method body.
6) Variable cannot be made abstract, its only behaviour or methods which would be abstract.
7) If a class extends an abstract class or interface it has to provide implementation to all its abstract method to be a concrete class. Alternatively this class can also be abstract.

### Key Points about Interface in Java
In last section we saw what an interface in Java is and learned that interface provides abstraction in Java and its only way to achieve multiple inheritances at type level in Java. In this section we will see some important properties of interface in Java.

1. Interface in java is declared using keyword interface and it represent a Type like any Class in Java. A reference variable of type interface can point to any implementation of that interface in Java. It’s also a good Object oriented design principle to "program for interfaces than implementation" because when you use interface to declare reference variable, method return type or method argument you are flexible enough to accept any future implementation of that interface which could be much better and high performance alternative of current implementation. Similarly calling any method on interface doesn't tie you with any particular implementation and you can leverage benefit of better or improved implementation over time. This maintenance aspect of interface is also sought in various software design interview questions in Java.
2) All variables declared inside interface is implicitly public final variable or constants. which brings a useful case of using Interface for declaring Constants. We have used both Class and interface for storing application wide constants and advantage of using Interface was that you can implement interface and can directly access constants without referring them with class name which was the case earlier when Class is used for storing Constants. Though after introduction of static imports in Java 5 this approach doesn't offer any benefit over Class approach.
3) All methods declared inside Java Interfaces are implicitly public and abstract, even if you don't use public or abstract keyword. You cannot define any concrete method in interface. That's why interface is used to define contracts in terms of variables and methods and you can rely on its implementation for performing job.
4) In Java it’s legal for an interface to extend multiple interface. for example following code will run without any compilation error:
interface Session extends Serializable, Clonnable{ }
Here Session interface in Java is also a Serializable and Clonnable. This is not true for Class in Java and one Class can only extend at most another Class. In Java one Class can implement multiple interfaces. They are required to provide implementation of all methods declared inside interface or they can declare themselves as abstract class.

### Example of interface in Java
Java standard library itself has many inbuilt interfaces like Serializable, Clonnable, Runnable or Callable interface in Java.  Declaring interface is easy but making it correct in first attempt is hard but if you are in business of designing API then you need to get it right in first attempt because it’s not possible to modify interface once it released without breaking all its implementation. 

Here is an example of declaring interface in Java:
```java
 interface SessionIDCreator extends Serializable, Cloneable{
        String TYPE = "AUTOMATIC";
        int createSessionId();
    }
  
    class SerialSessionIDCreator implements SessionIDCreator{

        private int lastSessionId;
       
 @Override
        public int createSessionId() {
            return lastSessionId++;
        }
      
    }
```
In above example of interface in Java, SessionIDCreator is an interface while SerialSessionIDCreator is a implementation of interface. @Override annotation can be used on interface method from Java 6 onwards, so always try to use it. It’s one of those coding practice which should be in your code review checklist.

### When to use interface in Java
Interface is best choice for Type declaration or defining contract between multiple parties. If multiple programmers are working in different module of project they still use each other’s API by defining interface and not waiting for actual implementation to be ready. This brings us lot of flexibility and speed in terms of coding and development. Use of Interface also ensures best practices like "programming for interfaces than implementation" and results in more flexible and maintainable code. Though interface in Java is not the only one who provides higher level abstraction, you can also use abstract class but choosing between Interface in Java and abstract class is a skill.
### How do you detect deadlock in Java?
Though this could have many answers, my version is first I would look the code if I see nested synchronized block or calling one synchronized method from other or trying to get lock on different object then there is good chance of deadlock if developer is not very careful.

Other way is to find it when you actually get locked while running the application, try to take thread dump, in Linux you can do this by command "kill -3”, this will print status of all the thread in application log file and you can see which thread is locked on which object.

Other way is to use jconsole, jconsole will show you exactly which threads are getting locked and on which object.

Once you answer this, they may ask you to write code which will result in deadlock?
here is one of my version
```java
public void method1(){
synchronized(String.class){
System.out.println("Aquired lock on String.class object");

synchronized (Integer.class) {
System.out.println("Aquired lock on Integer.class object");
}
}
}

public void method2(){
synchronized(Integer.class){
System.out.println("Aquired lock on Integer.class object");

synchronized (String.class) {
System.out.println("Aquired lock on String.class object");
}
}
}
```
If method1() and method2() both will be called by two or many threads , there is a good chance of deadlock because if thead 1 aquires lock on Sting object while executing method1() and thread 2 acquires lock on Integer object while executing method2() both will be waiting for each other to release lock on Integer and String to proceed further which will never happen.

Now interviewer comes to final part, one of the most important in my view, How to fix deadlock? Or How to avoid deadlock in Java?

If you have looked above code carefully you may have figured out that real reason for deadlock is not multiple threads but the way they access lock, if you provide an ordered access then problem will be resolved, here is
the fixed version.
```java
public void method1(){
synchronized(Integer.class){
System.out.println("Aquired lock on Integer.class object");

synchronized (String.class) {
System.out.println("Aquired lock on String.class object");
}
}
}

public void method2(){
synchronized(Integer.class){
System.out.println("Aquired lock on Integer.class object");

synchronized (String.class) {
System.out.println("Aquired lock on String.class object");
}
}
}
```
Now there would not be any deadlock because both method is accessing lock on Integer and String object in same order . so if thread A acquires lock on Integer object , thread B will not proceed until thread A releases Integer lock , same way thread A will not be blocked even if thread B holds String lock because now thread B will not expect thread A to release Integer lock to proceed further.

### Difference between SendRedirect() and Forward() in JSP Servlet
- SendRedirect ():  
This method is declared in HttpServletResponse Interface.
Signature: void sendRedirect(String url)
This method is used to redirect client request to some other location for further processing, the new location is available on different server or different context. Our web container handles this and transfers the request using browser, and this request is visible in browser as a new request. Sometime this is also called as client side redirect.
- Forward():
This method is declared in RequestDispatcher Interface.
Signature: forward(ServletRequest request, ServletResponse response)
This method is used to pass the request to another resource for further processing within the same server, another resource could be any servlet, jsp page any kind of file.This process is taken care by web container when we call forward method request is sent to another resource without the client being informed, which resource will handle the request it has been mention on requestDispatcher object which we can get by two ways either using ServletContext or Request. This is also called server side redirect.
```java
RequestDispatcher rd = request.getRequestDispatcher("pathToResource");
  rd.forward(request, response);
Or
RequestDispatcher rd = servletContext.getRequestDispatcher("/pathToResource");
  rd.forward(request, response);
```
### Difference between SendRedirect and Forward
Now let’s see some difference between these two methods of servlet API in tabular format.
Forward()	SendRediret()
When we use forward method request is transfer to other resource within the same server for further processing.	In case of sendRedirect request is transfer to another resource to different domain or different server for futher processing.
In case of forward Web container handle all process internally and client or browser is not involved.
	When you use SendRedirect container transfers the request to client or browser so url given inside the sendRedirect method is visible as a new request to the client.
When forward is called on requestdispatherobject we pass request and response object so our old request object is present on new resource which is going to process our request	In case of SendRedirect call old request and response object is lost because it’s treated as new request by the browser.
Visually we are not able to see the forwarded address, it is transparent	In address bar we are able to see the new redirected address it’s not transparent.
Using forward () method is faster then send redirect.	SendRedirect is slower because one extra round trip is required because completely new request is created and old request object is lost. Two browser request required.
When we redirect using forward and we want to use same data in new resource we can use request.setAttribute () as we have request object available.	But in sendRedirect if we want to use we have to store the data in session or pass along with the URL.

### Example of forward and SendRedirect in JSP Servlet:
Any kind of online payment when we use merchant site will redirect us to net banking site which is completely new request it process our request and again redirect to merchant site?
In Banking Application when we do login normally we use forward method. In case of online banking we are asked for username and password if it’s a correct some another servlet or resource will handle the request otherwise request has been forwarded to error page.
### Which one is good?
Its depends upon the scenario that which method is more useful.
If you want control is transfer to new server or context and it is treated as completely new task then we go for Send Redirect.
Normally forward should be used if the operation can be safely repeated upon a browser reload of the web page will not affect the result.
Creating dynamic number of threads concurrently
You can certainly create an array of threads using a loop:
```java
 Thread[] threads = new Thread[10];
 for (int i = 0; i < threads.length; i++) {
     threads[i] = new Thread(new Runnable() {
         public void run() {
             // some code to run in parallel
         }
     });
     threads[i].start();
 }
But I would recommend using the builtin Java Executors. They do all of this for you are are easier to manage:
 // create a pool of threads, 10 max jobs will execute in parallel
 ExecutorService threadPool = Executors.newFixedThreadPool(10);
 // submit jobs to be executing by the pool
 for (int i = 0; i < NUM_JOBS_TO_CREATE; i++) {
    threadPool.submit(new Runnable() {
         public void run() {
             // some code to run in parallel
         }
     });
 }
 threadPool.shutdown();
```
A thread pool is a group of threads initially created that waits for jobs and executes them. The idea is to have the threads always existing, so that we won't have to pay overhead time for creating them every time. They are appropriate when we know there's a stream of jobs to process, even though there could be some time when there are no jobs.
Here's a nice diagram from Wikipedia:  
### Java Thread Pool Example using Executors and ThreadPoolExecutor
by Pankaj Kumar on January 18th, 2013 | Filed in: Core Java Tags: Concurrency
A thread pool manages the pool of worker threads, it contains a queue that keeps tasks waiting to get executed. A thread pool manages the collection of Runnable threads and worker threads execute Runnable from the queue.java.util.concurrent.Executors provide implementation ofjava.util.concurrent.Executor interface to create the thread pool in java.
Let’s write a simple program to explain it’s working.

First we need to have a Runnable class.
```java
01	package com.journaldev.threadpool;
02	 
03	public class WorkerThread implements Runnable {
04	 
05	    private String command;
06	 
07	    public WorkerThread(String s){
08	        this.command=s;
09	    }
10	 
11	    @Override
12	    public void run() {
13	        System.out.println(Thread.currentThread().getName()+' Start. Command = '+command);
14	        processCommand();
15	        System.out.println(Thread.currentThread().getName()+' End.');
16	    }
17	 
18	    private void processCommand() {
19	        try {
20	            Thread.sleep(5000);
21	        } catch (InterruptedException e) {
22	            e.printStackTrace();
23	        }
24	    }
25	 
26	    @Override
27	    public String toString(){
28	        return this.command;
29	    }
30	}
Here is the test program where we are creating fixed thread pool from Executors framework.
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.ExecutorService;
04	import java.util.concurrent.Executors;
05	 
06	public class SimpleThreadPool {
07	 
08	    public static void main(String[] args) {
09	        ExecutorService executor = Executors.newFixedThreadPool(5);
10	        for (int i = 0; i < 10; i++) {
11	            Runnable worker = new WorkerThread('' + i);
12	            executor.execute(worker);
13	          }
14	        executor.shutdown();
15	        while (!executor.isTerminated()) {
16	        }
17	        System.out.println('Finished all threads');
18	    }
19	 
20	}
```
In above program, we are creating fixed size thread pool of 5 worker threads. Then we are submitting 10 jobs to this pool, since the pool size is 5, it will start working on 5 jobs and other jobs will be in wait state, as soon as one of the job is finished, another job from the wait queue will be picked up by worker thread and get’s executed.
Here is the output of the above program.
```
01	pool-1-thread-2 Start. Command = 1
02	pool-1-thread-4 Start. Command = 3
03	pool-1-thread-1 Start. Command = 0
04	pool-1-thread-3 Start. Command = 2
05	pool-1-thread-5 Start. Command = 4
06	pool-1-thread-4 End.
07	pool-1-thread-5 End.
08	pool-1-thread-1 End.
09	pool-1-thread-3 End.
10	pool-1-thread-3 Start. Command = 8
11	pool-1-thread-2 End.
12	pool-1-thread-2 Start. Command = 9
13	pool-1-thread-1 Start. Command = 7
14	pool-1-thread-5 Start. Command = 6
15	pool-1-thread-4 Start. Command = 5
16	pool-1-thread-2 End.
17	pool-1-thread-4 End.
18	pool-1-thread-3 End.
19	pool-1-thread-5 End.
20	pool-1-thread-1 End.
21	Finished all threads
```
The output confirms that there are five threads in the pool named from “pool-1-thread-1? to “pool-1-thread-5? and they are responsible to execute the submitted tasks to the pool.
Executors class provide simple implementation of ExecutorService using ThreadPoolExecutor but ThreadPoolExecutor provides much more feature than that. We can specify the number of threads that will be alive when we create ThreadPoolExecutor instance and we can limit the size of thread pool and create our own RejectedExecutionHandler implementation to handle the jobs that can’t fit in the worker queue.
Here is our custom implementation of RejectedExecutionHandler interface.
```java
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.RejectedExecutionHandler;
04	import java.util.concurrent.ThreadPoolExecutor;
05	 
06	public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
07	 
08	    @Override
09	    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
10	        System.out.println(r.toString() + ' is rejected');
11	    }
12	 
13	}
```
ThreadPoolExecutor provides several methods using which we can find out the current state of executor, pool size, active thread count and task count. So I have a monitor thread that will print the executor information at certain time interval.
```java
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.ThreadPoolExecutor;
04	 
05	public class MyMonitorThread implements Runnable
06	{
07	    private ThreadPoolExecutor executor;
08	 
09	    private int seconds;
10	 
11	    private boolean run=true;
12	 
13	    public MyMonitorThread(ThreadPoolExecutor executor, int delay)
14	    {
15	        this.executor = executor;
16	        this.seconds=delay;
17	    }
18	 
19	    public void shutdown(){
20	        this.run=false;
21	    }
22	 
23	    @Override
24	    public void run()
25	    {
26	        while(run){
27	                System.out.println(
28	                    String.format('[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s',
29	                        this.executor.getPoolSize(),
30	                        this.executor.getCorePoolSize(),
31	                        this.executor.getActiveCount(),
32	                        this.executor.getCompletedTaskCount(),
33	                        this.executor.getTaskCount(),
34	                        this.executor.isShutdown(),
35	                        this.executor.isTerminated()));
36	                try {
37	                    Thread.sleep(seconds*1000);
38	                } catch (InterruptedException e) {
39	                    e.printStackTrace();
40	                }
41	        }
42	 
43	    }
44	}
Here is the thread pool implementation example using ThreadPoolExecutor.
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.ArrayBlockingQueue;
04	import java.util.concurrent.Executors;
05	import java.util.concurrent.ThreadFactory;
06	import java.util.concurrent.ThreadPoolExecutor;
07	import java.util.concurrent.TimeUnit;
08	 
09	public class WorkerPool {
10	 
11	    public static void main(String args[]) throws InterruptedException{
12	        //RejectedExecutionHandler implementation
13	        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
14	        //Get the ThreadFactory implementation to use
15	        ThreadFactory threadFactory = Executors.defaultThreadFactory();
16	        //creating the ThreadPoolExecutor
17	        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, newArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
18	        //start the monitoring thread
19	        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
20	        Thread monitorThread = new Thread(monitor);
21	        monitorThread.start();
22	        //submit work to the thread pool
23	        for(int i=0; i<10; i++){
24	            executorPool.execute(new WorkerThread('cmd'+i));
25	        }
26	 
27	        Thread.sleep(30000);
28	        //shut down the pool
29	        executorPool.shutdown();
30	        //shut down the monitor thread
31	        Thread.sleep(5000);
32	        monitor.shutdown();
33	 
34	    }
35	}
```
Notice that while initializing the ThreadPoolExecutor, we are keeping initial pool size as 2, maximum pool size to 4 and work queue size as 2. So if there are 4 running tasks and more tasks are submitted, the work queue will hold only 2 of them and rest of them will be handled by RejectedExecutionHandlerImpl.

Here is the output of above program that confirms above statement.
```
01	pool-1-thread-1 Start. Command = cmd0
02	pool-1-thread-4 Start. Command = cmd5
03	cmd6 is rejected
04	pool-1-thread-3 Start. Command = cmd4
05	pool-1-thread-2 Start. Command = cmd1
06	cmd7 is rejected
07	cmd8 is rejected
08	cmd9 is rejected
09	[monitor] [0/2] Active: 4, Completed: 0, Task: 6, isShutdown: false, isTerminated: false
10	[monitor] [4/2] Active: 4, Completed: 0, Task: 6, isShutdown: false, isTerminated: false
11	pool-1-thread-4 End.
12	pool-1-thread-1 End.
13	pool-1-thread-2 End.
14	pool-1-thread-3 End.
15	pool-1-thread-1 Start. Command = cmd3
16	pool-1-thread-4 Start. Command = cmd2
17	[monitor] [4/2] Active: 2, Completed: 4, Task: 6, isShutdown: false, isTerminated: false
18	[monitor] [4/2] Active: 2, Completed: 4, Task: 6, isShutdown: false, isTerminated: false
19	pool-1-thread-1 End.
20	pool-1-thread-4 End.
21	[monitor] [4/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
22	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
23	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
24	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
25	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
26	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
27	[monitor] [0/2] Active: 0, Completed: 6, Task: 6, isShutdown: true, isTerminated: true
28	[monitor] [0/2] Active: 0, Completed: 6, Task: 6, isShutdown: true, isTerminated: true
```
Notice the change in active, completed and total completed task count of the executor. We can invoke shutdown() method to finish execution of all the submitted tasks and terminate the thread pool.

### How to create Thread Pools using Java 1.5 Executor Framework - Example Tutorial
Java 1.5 introduced Thread pool in Java in form of Executor framework, which allows Java programmer to decouple submission of task to execution of task. If you are doing server side programming in Java than Thread pool is an important concept to maintain scalability, robustness and stability of system. For those, who are not familiar with thread pool in Java or concept of thread pool here is one liner, Thread pool in Java is pool of worker threads, which is ready to perform any task given to them, mostly in form of implementation of Runnable or Callable interface. Since Java supports multithreading in programming language itself, it allows multiple thread to run concurrently and perform parallel processing of task. In this article we will learn following things about thread pool in Java :
1.	What is Thread pool in Java?
2.	Why do we need Thread pool in Java ?
3.	What is Executor framework in Java 5?
4.	How to create fixed size thread pool using Executor framework in Java?
5.	Benefits of using Thread Pool in Java?

### What is Thread Pool in Java and why we need it
 
As I said Thread pool is pool of already created worker thread ready to do the job. Thread pool is one of essential facility any multi-threaded server side Java application requires. One example of using thread pool is creating a web server, which process client request. If you are familiar with socket programming than you know that ServerSocket.accept() is blocking method and blocks until a socket connection made. If only one thread is used to process client request, than it subsequently limit how many client can access server concurrently. In order to support large number of clients, you may decide to use one thread per request paradigm, in which each request is processed by separate Thread, but this require Thread to be created, when request arrived.  Since creation of Thread is time consuming process, it delays request processing. It also limits number of clients based upon how many thread per JVM is allowed, which is obviously a limited number. Thread pool solves this problem for you, It creates Thread and manage them. Instead of creating Thread and discarding them once task is done, thread-pool reuses threads in form of worker thread. Since Thread are usually created and pooled when application starts, your server can immediately start request processing, which can further improve server’s response time. Apart from this, there are several other benefits of using Thread pool in Java applications, which we will see in subsequent section. In short, we need thread pools to better mange threads and decoupling task submission from execution. Thread pool and Executor framework introduced in Java 5 is an excellent thread pool provided by library.

### Java Thread Pool - Executor Framework in Java 5
Java 5 introduced several useful features like Enum, Generics, Variable arguments and several concurrency collections and utilities like ConcurrentHashMap and BlockingQueue etc, It also introduced a full feature built-in Thread Pool framework commonly known as Executor framework. Core of this thread pool framework is Executor interface which defines abstraction of task execution with method execute(Runnable task) and ExecutorService which extends Executor to add various life-cycle and thread pool management facilities like shutting down thread pool. Executor framework also provides an static utility class called Executors ( similar to Collections) which provides several static factory method to create various type of Thread Pool implementation in Java e.g. fixed size thread pool, cached thread pool and scheduled thread pool. Runnable and Callable interface are used to represent task executed by worker thread managed in these Thread pools. Interesting point about Executor framework is that, it is based on Producer consumer design pattern, where application thread produces task and worker thread consumers or execute those task, So it also suffers with limitation of Producer consumer task like if production speed is substantially higher than consumption than you may run OutOfMemory because of queued task, of course only if your queue is unbounded.

### How to create fixed size thread pool using Executor framework in Java?
Creating fixed size thread pool using Java 5 Executor framework is pretty easy because of static factory methods provided by Executors class. All you need to do is define your task which you want to execute concurrently and than submit that task to ExecutorService. from them Thread pool will take care of how to execute that task, it can be executed by any free worker thread and if you are interested in result you can query Future object returned by submit()method. Executor framework also provides different kind of Thread Pool e.g. SingleThreadExecutor which creates just one worker thread or CachedThreadPool which creates worker threads as and when necessary. You can also check  Java documentation of Executor Framework for complete details of services provided by this API. Java concurrency in Practice also has couple of chapters dedicated to effective use of Java 5 Executor framework, which is worth reading for any senior Java developer.

### Example of Thread Pool in Java
Here is an example of Thread pool in Java, which uses Executor framework of Java 5 to create a fixed thread pool with number of worker thread as 10. It will then create task and submit that to Thread pool for execution:
```java
public class ThreadPoolExample {

    public static void main(String args[]) {
       ExecutorService service = Executors.newFixedThreadPool(10);
       for (int i =0; i<100; i++){
           service.submit(new Task(i));
       }
    }
  
}

final class Task implements Runnable{
    private int taskId;
  
    public Task(int id){
        this.taskId = id;
    }
  
    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId +" performed by " 
                           + Thread.currentThread().getName());
    }
  
}
```
Output:
```
Task ID : 0 performed by pool-1-thread-1
Task ID : 3 performed by pool-1-thread-4
Task ID : 2 performed by pool-1-thread-3
Task ID : 1 performed by pool-1-thread-2
Task ID : 5 performed by pool-1-thread-6
Task ID : 4 performed by pool-1-thread-5
```
If you look at output of this Java example you will find different threads from thread pool are executing tasks.

### Benefits of Thread Pool in Java
Thread Pool offers several benefit to Java application, biggest of them is separating submission of task to execution of task ,which result if more loose coupled and flexible design than tightly coupled create and execute pattern. Here are some more benefits of using Thread pool in Java:

1) Use of Thread Pool reduces response time by avoiding thread creation during request or task processing.
2) Use of Thread Pool allows you to change your execution policy as you need. you can go from single thread to multiple thread by just replacing ExecutorService implementation.

3) Thread Pool in Java application increases stability of system by creating a configured number of threads decided based on system load and available resource.

4) Thread Pool frees application developer from thread management stuff and allows to focus on business logic.

That's all on Thread pool in Java 5. we have seen what is thread pool in Java, what is executor framework in java 5, how to create thread pool in Java and some benefits of using thread pool in Java application. no doubt knowledge of thread pool is essential for a server side core Java developer and I suggest reading Java Threads and Concurrency Practice in Java to learn more about concurrency and thread pool. 

### Java Concurrency Tutorial: Thread Pools

Thread Pools are useful when you need to limit the number of threads running in your application at the same time. There is a performance overhead associated with starting a new thread, and each thread is also allocated some memory for its stack etc.

Instead of starting a new thread for every task to execute concurrently, the task can be passed to a thread pool. As soon as the pool has any idle threads the task is assigned to one of them and executed. Internally the tasks are inserted into a Blocking Queue which the threads in the pool are dequeuing from. When a new task is inserted into the queue one of the idle threads will dequeue it successfully and execute it. The rest of the idle threads in the pool will be blocked waiting to dequeue tasks.

Thread pools are often used in multi threaded servers. Each connection arriving at the server via the network is wrapped as a task and passed on to a thread pool. The threads in the thread pool will process the requests on the connections concurrently. A later trail will get into detail about implementing multithreaded servers in Java.

Java 5 comes with built in thread pools in the java.util.concurrent package, so you don't have to implement your own thread pool. Still it can be useful to know a bit about the implementation of a thread pool anyways.

Here is a simple thread pool implementation:
```java
01.public class ThreadPool {
02. 
03.private BlockingQueue taskQueue = null;
04.private List<PoolThread> threads = new ArrayList<PoolThread>();
05.private boolean isStopped = false;
06. 
07.public ThreadPool(int noOfThreads, int maxNoOfTasks){
08.taskQueue = new BlockingQueue(maxNoOfTasks);
09. 
10.for(int i=0; i<noOfThreads; i++){
11.threads.add(new PoolThread(taskQueue));
12.}
13.for(PoolThread thread : threads){
14.thread.start();
15.}
16.}
17. 
18.public void synchronized execute(Runnable task){
19.if(this.isStopped) throw
20.new IllegalStateException("ThreadPool is stopped");
21. 
22.this.taskQueue.enqueue(task);
23.}
24. 
25.public synchronized void stop(){
26.this.isStopped = true;
27.for(PoolThread thread : threads){
28.thread.stop();
29.}
30.}
31. 
32.}
```
```java
01.public class PoolThread extends Thread {
02. 
03.private BlockingQueue taskQueue = null;
04.private boolean       isStopped = false;
05. 
06.public PoolThread(BlockingQueue queue){
07.taskQueue = queue;
08.}
09. 
10.public void run(){
11.while(!isStopped()){
12.try{
13.Runnable runnable = (Runnable) taskQueue.dequeue();
14.runnable.run();
15.} catch(Exception e){
16.//log or otherwise report exception,
17.//but keep pool thread alive.
18.}
19.}
20.}
21. 
22.public synchronized void stop(){
23.isStopped = true;
24.this.interrupt(); //break pool thread out of dequeue() call.
25.}
26. 
27.public synchronized void isStopped(){
28.return isStopped;
29.}
30.}
```
The thread pool implementation consists of two parts. A ThreadPool class which is the public interface to the thread pool, and a PoolThread class which implements the threads that execute the tasks.

To execute a task the method ThreadPool.execute(Runnable r) is called with a Runnableimplementation as parameter. The Runnable is enqueued in the blocking queue internally, waiting to be dequeued.

The Runnable will be dequeued by an idle PoolThread and executed. You can see this in thePoolThread.run() method. After execution the PoolThread loops and tries to dequeue a task again, until stopped.

To stop the ThreadPool the method ThreadPool.stop() is called. The stop called is noted internally in the isStopped member. Then each thread in the pool is stopped by calling PoolThread.stop(). Notice how the execute() method will throw an IllegalStateException if execute() is called after stop() has been called.

The threads will stop after finishing any task they are currently executing. Notice the this.interrupt() call in PoolThread.stop(). This makes sure that a thread blocked in a wait() call inside thetaskQueue.dequeue() call breaks out of the wait() call, and leaves the dequeue() method call with anInterruptedException thrown. This exception is caught in the PoolThread.run() method, reported, and then the isStopped variable is checked. Since isStopped is now true, the PoolThread.run() will exit and the thread dies.

### Life Cycle of Thread – Understanding Thread States in Java

Understanding Life Cycle of Thread and Thread States are very important when you are working with Threads and programming for multi-threaded environment.
As we learned in last tutorial, we can create a java thread class by implementing Runnable interface or by extending Thread class, but to start a java thread, we first have to create the Thread object and call it’s start() method to execute run() method as a thread.

### Thread States
Below diagram shows different states of thread in java, note that we can create a thread in java and start it but how the thread states change from Runnable to Running to Blocked depends on the OS implementation of thread scheduler and java doesn’t have full control on that.
 
- New
When we create a new Thread object using new operator, thread state is New Thread. At this point, thread is not alive and it’s a state internal to Java programming.
- Runnable
When we call start() function on Thread object, it’s state is changed to Runnable and the control is given to Thread scheduler to finish it’s execution. Whether to run this thread instantly or keep it in runnable thread pool before running it depends on the OS implementation of thread scheduler.
- Running
When thread is executing, it’s state is changed to Running. Thread scheduler picks one of the thread from the runnable thread pool and change it’s state to Running and CPU starts executing this thread. A thread can change state to Runnable, Dead or Blocked from running state depends on time slicing, thread completion of run() method or waiting for some resources.
- Blocked/Waiting
A thread can be waiting for other thread to finish using thread join or it can be waiting for some resources to available, for example producer consumer problem or waiter notifier implementation or IO resources, then it’s state is changed to Waiting. Once the thread wait state is over, it’s state is changed to Runnable and it’s moved back to runnable thread pool.
- Dead
Once the thread finished executing, it’s state is changed to Dead and it’s considered to be not alive.
Above are the different states of thread and it’s good to know them and how thread changes it’s state.

### Java Daemon Thread Example

When we create a Thread in java, by default it’s a user thread and if it’s running JVM will not terminate the program. When a thread is marked as daemon thread, JVM doesn’t wait it to finish and as soon as all the user threads are finished, it terminates the program as well as all the associated daemon threads.
Thread.setDaemon(true) can be used to create a daemon thread in java. Let’s see a small example of java daemon thread.

JavaDaemonThread
```java
package com.journaldev.threads;
 
public class JavaDaemonThread {
 
    public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new DaemonThread(), "dt");
        dt.setDaemon(true);
        dt.start();
        //continue program
        Thread.sleep(30000);
        System.out.println("Finishing program");
    }
 
}
 
class DaemonThread implements Runnable{
 
    @Override
    public void run() {
        while(true){
            processSomething();
        }
    }
 
    private void processSomething() {
        try {
            System.out.println("Processing daemon thread");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
}
```
When we execute this program, JVM creates first user thread with main() function and then a daemon thread. When main function is finished, the program terminates and daemon thread is also shut down by JVM.
Here is the output of the above program.
```
Processing daemon thread
Processing daemon thread
Processing daemon thread
Processing daemon thread
Processing daemon thread
Processing daemon thread
Finishing program
```
If we don’t set the thread to be run as daemon thread, the program will never terminate even after main thread is finished it’s execution. Try commenting the statement to set thread as daemon thread and run the program.
Usually we create a daemon thread for functionalities that are not critical to system, for example logging thread or monitoring thread to capture the system resource details and their state.

### Dependency Injection Design Pattern in Java Example Tutorial
Dependency Injection design pattern allows us to remove the hard-coded dependencies and make our application loosely coupled, extendable and maintainable. We can implement dependency injection pattern to move the dependency resolution from compile-time to runtime.
Dependency injection pattern seems hard to grasp with theory, so I would take a simple example and then we will see how to use dependency injection pattern to achieve loose coupling and extendability in the application.

Let’s say we have an application where we consume EmailService to send emails. Normally we would implement this like below.

EmailService.java
```java
package com.journaldev.java.legacy;
 
public class EmailService {
 
    public void sendEmail(String message, String receiver){
        //logic to send email
        System.out.println("Email sent to "+receiver+ " with Message="+message);
    }
}
```
EmailService class holds the logic to send email message to the recipient email address. Our application code will be like below.

MyApplication.java
```java
package com.journaldev.java.legacy;
 
public class MyApplication {
 
    private EmailService email = new EmailService();
     
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.email.sendEmail(msg, rec);
    }
}
```
Our client code that will use MyApplication class to send email messages will be like below.

MyLegacyTest.java
```java
package com.journaldev.java.legacy;
 
public class MyLegacyTest {
 
    public static void main(String[] args) {
        MyApplication app = new MyApplication();
        app.processMessages("Hi Pankaj", "pankaj@abc.com");
    }
 
}
```
At first look, there seems nothing wrong with above implementation. But above code logic has certain limitations.
•	MyApplication class is responsible to initialize the email service and then use it. This leads to hard-coded dependency. If we want to switch to some other advanced email service in future, it will require code changes in MyApplication class. This makes our application hard to extend and if email service is used in multiple classes then that would be even more harder.
•	If we want to extend our application to provide additional messaging feature, such as SMS or Facebook message then we would need to write another application for that. This will involve code changes in application classes and in client classes too.
•	Testing the application will be very difficult since our application is directly creating the email service instance. There is no way we can mock these objects in our test classes.

One can argue that we can remove the email service instance creation from MyApplication class by having a constructor that requires email service as argument.

MyApplication.java
```java
package com.journaldev.java.legacy;
 
public class MyApplication {
 
    private EmailService email = null;
     
    public MyApplication(EmailService svc){
        this.email=svc;
    }
     
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.email.sendEmail(msg, rec);
    }
}
```
But in this case, we are asking client applications or test classes to initializing the email service that is not a good design decision.
Now let’s see how we can apply dependency injection pattern to solve all the problems with above implementation. Dependency Injection pattern requires at least following:
1.	Service components should be designed with base class or interface. It’s better to prefer interfaces or abstract classes that would define contract for the services.
2.	Consumer classes should be written in terms of service interface.
3.	Injector classes that will initialize the services and then the consumer classes.
### Service Components
For our case, we can have MessageService that will declare the contract for service implementations.

MessageService.java
```java
package com.journaldev.java.dependencyinjection.service;
 
public interface MessageService {
 
    void sendMessage(String msg, String rec);
}
```
Now let’s say we have Email and SMS services that implement above interfaces.

EmailServiceImpl.java
```java
package com.journaldev.java.dependencyinjection.service;
 
public class EmailServiceImpl implements MessageService {
 
    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send email
        System.out.println("Email sent to "+rec+ " with Message="+msg);
    }
 
}
```
SMSServiceImpl.java
```java
package com.journaldev.java.dependencyinjection.service;
 
public class SMSServiceImpl implements MessageService {
 
    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send SMS
        System.out.println("SMS sent to "+rec+ " with Message="+msg);
    }
 
}
``
Our services are ready and now we can write our consumer class.

Service Consumer
We are not required to have base interfaces for consumer classes but I will have a Consumer interface declaring contract for consumer classes.

Consumer.java
```java
package com.journaldev.java.dependencyinjection.consumer;
 
public interface Consumer {
 
    void processMessages(String msg, String rec);
}
```
My consumer class implementation is like below.

MyDIApplication.java
```java
package com.journaldev.java.dependencyinjection.consumer;
 
import com.journaldev.java.dependencyinjection.service.MessageService;
 
public class MyDIApplication implements Consumer{
 
    private MessageService service;
     
    public MyDIApplication(MessageService svc){
        this.service=svc;
    }
     
    @Override
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }
 
}
```
Notice that our application class is just using the service. It does not initialize the service that leads to better “separation of concerns“. Also use of service interface allows us to easily test the application by mocking the MessageService and bind the services at runtime rather than compile time.
Now we are ready to write injector classes that will initialize the service and also consumer classes.
### Injectors Classes
Let’s have an interface MessageServiceInjector with method declaration that returns the Consumer class.

MessageServiceInjector.java
```java
package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
 
public interface MessageServiceInjector {
 
    public Consumer getConsumer();
}
Now for every service, we will have to create injector classes like below.
EmailServiceInjector.java
package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.service.EmailServiceImpl;
 
public class EmailServiceInjector implements MessageServiceInjector {
 
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }
 
}
SMSServiceInjector.java
package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.service.SMSServiceImpl;
 
public class SMSServiceInjector implements MessageServiceInjector {
 
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }
 
}
Now let’s see how our client applications will use the application with a simple program.
MyMessageDITest.java
package com.journaldev.java.dependencyinjection.test;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.injector.EmailServiceInjector;
import com.journaldev.java.dependencyinjection.injector.MessageServiceInjector;
import com.journaldev.java.dependencyinjection.injector.SMSServiceInjector;
 
public class MyMessageDITest {
 
    public static void main(String[] args) {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        String phone = "4088888888";
        MessageServiceInjector injector = null;
        Consumer app = null;
         
        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);
         
        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }
 
}
```
As you can see that our application classes are responsible only for using the service. Service classes are created in injectors. Also if we have to further extend our application to allow facebook messaging, we will have to write Service classes and injector classes only.
So dependency injection implementation solved the problem with hard-coded dependency and helped us in making our application flexible and easy to extend. Now let’s see how easily we can test our application class by mocking the injector and service classes.
JUnit Test Case with Mock Injector and Service

MyDIApplicationJUnitTest.java
```java
package com.journaldev.java.dependencyinjection.test;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.injector.MessageServiceInjector;
import com.journaldev.java.dependencyinjection.service.MessageService;
 
public class MyDIApplicationJUnitTest {
 
    private MessageServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = new MessageServiceInjector() {
             
            @Override
            public Consumer getConsumer() {
                //mock the message service
                return new MyDIApplication(new MessageService() {
                     
                    @Override
                    public void sendMessage(String msg, String rec) {
                        System.out.println("Mock Message Service implementation");
                         
                    }
                });
            }
        };
    }
     
    @Test
    public void test() {
        Consumer consumer = injector.getConsumer();
        consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
    }
     
    @After
    public void tear(){
        injector = null;
    }
 
}
```
As you can see that I am using anonymous classes to mock the injector and service classes and I can easily test my application methods. I am using JUnit 4 for above test class, so make sure it’s in your project build path if you are running above test class.
We have used constructors to inject the dependencies in the application classes, another way is to use setter method to inject dependencies in application classes. For setter method dependency injection, our application class will be implemented like below.

MyDIApplication.java
```java
package com.journaldev.java.dependencyinjection.consumer;
 
import com.journaldev.java.dependencyinjection.service.MessageService;
 
public class MyDIApplication implements Consumer{
 
    private MessageService service;
     
    public MyDIApplication(){}
 
    //setter dependency injection   
    public void setService(MessageService service) {
        this.service = service;
    }
 
    @Override
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }
 
}
EmailServiceInjector.java
package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.service.EmailServiceImpl;
 
public class EmailServiceInjector implements MessageServiceInjector {
 
    @Override
    public Consumer getConsumer() {
        MyDIApplication app = new MyDIApplication();
        app.setService(new EmailServiceImpl());
        return app;
    }
 
}
```
One of the best example of setter dependency injection is Struts2 Servlet API Aware interfaces.

Whether to use Constructor based dependency injection or setter based is a design decision and depends on your requirements. For example, if my application can’t work at all without the service class then I would prefer constructor based DI or else I would go for setter method based DI to use it only when it’s really needed.

Dependency Injection is a way to achieve Inversion of control (IoC) in our application by moving objects binding from compile time to runtime. We can achieve IoC through Factory Pattern, Template Method Design Pattern, Strategy Pattern and Service Locator pattern too.

Spring, Google Guice and Java EE CDI frameworks facilitate the process of dependency injection through use of Java Reflection API and java annotations. All we need is to annotate the field, constructor or setter method and configure them in configuration xml files or classes.

### Benefits of Dependency Injection
Some of the benefits of using Dependency Injection are:
•	Separation of Concerns
•	Boilerplate Code reduction in application classes because all work to initialize dependencies is handled by the injector component
•	Configurable components makes application easily extendable
•	Unit testing is easy with mock objects
Disadvantages of Dependency Injection
Dependency injection has some disadvantages too:
•	If overused, it can lead to maintenance issues because effect of changes are known at runtime.
•	Dependency injection hides the service class dependencies that can lead to runtime errors that would have been caught at compile time.

### Spring IoC Container and Spring Bean Example Tutorial

Spring Framework is built on the Inversion of Control (IOC) principle. Dependency injection is the technique to implement IoC in applications. This article is aimed to explain core concepts of Spring IoC container and Spring Bean with example programs.
1.	Spring IoC Container
2.	Spring Bean
3.	Spring Bean Scopes
4.	Spring Bean Configuration
5.	Spring IoC and Bean Example Project
A.	XML Based Bean Configuration
B.	Annotation Based Bean Configuration
C.	Java Based Bean Configuration
### Spring IoC Container
Inversion of Control is the mechanism to achieve loose-coupling between Objects dependencies. To achieve loose coupling and dynamic binding of the objects at runtime, the objects define their dependencies that are being injected by other assembler objects. Spring IoC container is the program thatinjects dependencies into an object and make it ready for our use. We have already looked how we can use Spring Dependency Injection to implement IoC in our applications.

Spring Framework IoC container classes are part of org.springframework.beans andorg.springframework.context packages and provides us different ways to decouple the object dependencies.

BeanFactory is the root interface of Spring IoC container. ApplicationContext is the child interface ofBeanFactory interface that provide Spring’s AOP features, internationalization etc. Some of the useful child-interfaces of ApplicationContext are ConfigurableApplicationContext and WebApplicationContext. Spring Framework provides a number of useful ApplicationContext implementation classes that we can use to get the context and then the Spring Bean.

Some of the useful ApplicationContext implementations that we use are;

•	AnnotationConfigApplicationContext: If we are using Spring in standalone java applications and using annotations for Configuration, then we can use this to initialize the container and get the bean objects.
•	ClassPathXmlApplicationContext: If we have spring bean configuration xml file in standalone application, then we can use this class to load the file and get the container object.
•	FileSystemXmlApplicationContext: This is similar to ClassPathXmlApplicationContext except that the xml configuration file can be loaded from anywhere in the file system.
•	AnnotationConfigWebApplicationContext and XmlWebApplicationContext for web applications.
Usually if you are working on Spring MVC application and your application is configured to use Spring Framework, Spring IoC container gets initialized when application starts and when a bean is requested, the dependencies are injected automatically.
However for standalone application, you need to initialize the container somewhere in the application and then use it to get the spring beans.

### Spring Bean
Spring Bean is nothing special, any object in the Spring framework that we initialize through Spring container is called Spring Bean. Any normal Java POJO class can be a Spring Bean if it’s configured to be initialized via container by providing configuration metadata information.

### Spring Bean Scopes
There are five scopes defined for Spring Beans.
1.	singleton – Only one instance of the bean will be created for each container. This is the default scope for the spring beans. While using this scope, make sure bean doesn’t have shared instance variables otherwise it might lead to data inconsistency issues.
2.	prototype – A new instance will be created every time the bean is requested.
3.	request – This is same as prototype scope, however it’s meant to be used for web applications. A new instance of the bean will be created for each HTTP request.
4.	session – A new bean will be created for each HTTP session by the container.
5.	global-session – This is used to create global session beans for Portlet applications.
Spring Framework is extendable and we can create our own scopes too, however most of the times we are good with the scopes provided by the framework.

### Spring Bean Configuration
Spring Framework provide three ways to configure beans to be used in the application.
1.	Annotation Based Configuration – By using @Service or @Component annotations. Scope details can be provided with @Scope annotation.
2.	XML Based Configuration – By creating Spring Configuration XML file to configure the beans. If you are using Spring MVC framework, the xml based configuration can be loaded automatically by writing some boiler plate code in web.xml file.
3.	Java Based Configuration – Starting from Spring 3.0, we can configure Spring beans using java programs. Some important annotations used for java based configuration are @Configuration, @ComponentScan and @Bean.

### Spring IoC and Bean Example Project
Let’s look at the different aspects of Spring IoC container and Spring Bean configurations with a simple Spring project.
For my example, I am creating Spring MVC project in Spring Tool Suite. If you are new to Spring Tool Suite and Spring MVC, please read Spring MVC Tutorial with Spring Tool Suite.
The final project structure looks like below image.
 
Let’s look at different components one by one.

### XML Based Bean Configuration
MyBean is a simple Java POJO class.

MyBean.java
```java
package com.journaldev.spring.beans;
 
public class MyBean {
 
    private String name;
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     
}
```
### Spring Configuration XML File
```xml
servlet-context.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
 
    <!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
     
    <!-- Enables the Spring MVC @Controller programming model -->
    <annotation-driven />
 
    <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
    <resources mapping="/resources/**" location="/resources/" />
 
    <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
    <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <beans:property name="prefix" value="/WEB-INF/views/" />
        <beans:property name="suffix" value=".jsp" />
    </beans:bean>
     
    <context:component-scan base-package="com.journaldev.spring" />
     
    <beans:bean name="myBean" class="com.journaldev.spring.beans.MyBean" scope="singleton" ></beans:bean>
     
</beans:beans>
```
Notice that MyBean is configured using bean element with scope as singleton.
### Annotation Based Bean Configuration
MyAnnotatedBean.java
```java
package com.journaldev.spring.beans;
 
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
 
@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MyAnnotatedBean {
 
    private int empId;
 
    public int getEmpId() {
        return empId;
    }
 
    public void setEmpId(int empId) {
        this.empId = empId;
    }
     
}
```
MyAnnotatedBean is configured using @Service and scope is set to Request.

Controller Class
HomeController class will handle the HTTP requests for the home page of the application. We will inject our Spring beans to this controller class through WebApplicationContext container.

HomeController.java
```java
package com.journaldev.spring.controller;
 
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.journaldev.spring.beans.MyAnnotatedBean;
import com.journaldev.spring.beans.MyBean;
 
@Controller
@Scope("request")
public class HomeController {
         
    private MyBean myBean;
     
    private MyAnnotatedBean myAnnotatedBean;
 
    @Autowired
    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }
 
    @Autowired
    public void setMyAnnotatedBean(MyAnnotatedBean obj) {
        this.myAnnotatedBean = obj;
    }
     
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("MyBean hashcode="+myBean.hashCode());
        System.out.println("MyAnnotatedBean hashcode="+myAnnotatedBean.hashCode());
         
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
         
        String formattedDate = dateFormat.format(date);
         
        model.addAttribute("serverTime", formattedDate );
         
        return "home";
    }
     
}
```
### Deployment Descriptor
We need to configure our application for Spring Framework, so that the configuration metadata will get loaded and context will be initialized.

web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
 
    <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/root-context.xml</param-value>
    </context-param>
     
    <!-- Creates the Spring Container shared by all Servlets and Filters -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
 
    <!-- Processes application requests -->
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
         
    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
 
</web-app>
```
Almost all the configuration above is boiler-plate code generated by STS tool automatically.
### Run the Web Application
Now when you will launch the web application, the home page will get loaded and in the console following logs will be printed when you refresh the page multiple times.
```
MyBean hashcode=118267258
MyAnnotatedBean hashcode=1703899856
MyBean hashcode=118267258
MyAnnotatedBean hashcode=1115599742
MyBean hashcode=118267258
MyAnnotatedBean hashcode=516457106
```
Notice that MyBean is configured to be singleton, so the container is always returning the same instance and hashcode is always same. Similarly for each request, a new instance of MyAnnotatedBean is created with different hashcode.
Java Based Bean Configuration
For standalone applications, we can use annotation based as well as xml based configuration. The only requirement is to initialize the context somewhere in the program before we use it.

MyService.java
```java
package com.journaldev.spring.main;
 
import java.util.Date;
 
public class MyService {
 
    public void log(String msg){
        System.out.println(new Date()+"::"+msg);
    }
}
```
MyService is a simple java class with some methods.

MyConfiguration.java
```java
package com.journaldev.spring.main;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@ComponentScan(value="com.journaldev.spring.main")
public class MyConfiguration {
 
    @Bean
    public MyService getService(){
        return new MyService();
    }
}
```
The annotation based configuration class that will be used to initialize the Spring container.

MyMainClass.java
```java
package com.journaldev.spring.main;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
public class MyMainClass {
 
    public static void main(String[] args) {
         
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                MyConfiguration.class);
        MyService service = ctx.getBean(MyService.class);
         
        service.log("Hi");
         
        MyService newService = ctx.getBean(MyService.class);
        System.out.println("service hashcode="+service.hashCode());
        System.out.println("newService hashcode="+newService.hashCode());
        ctx.close();
    }
 
}
```
A simple test program where we are initializing the AnnotationConfigApplicationContext context and then using getBean() method to get the instance of MyService.

Notice that I am calling getBean method two times and printing the hashcode. Since there is no scope defined for MyService, it should be singleton and hence hashcode should be the same for both the instances.

When we run the above application, we get following console output confirming our understanding.
Sat Dec 28 22:49:18 PST 2013::Hi
service hashcode=678984726
newService hashcode=678984726

If you are looking for XML based configuration, just create the Spring XML config file and then initialize the context with following code snippet.
```java
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        MyService app = context.getBean(MyService.class);
```
That’s all for the Spring IoC container and Spring Bean Scopes and Configuration details. We will look into some more features of Spring Beans in future posts. Download the Spring Bean example project from below link and play around with it for better understanding.

### Java Serialization Example Tutorial, Serializable, serialVersionUID

Java Serialization was introduced in JDK 1.1 and it is one of the important feature of Core Java.
Java Serialization API allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage. Deserialization is the process of converting Object stream to actual Java Object to be used in our program. Java Synchronization process seems very easy to use at first but it comes with some trivial security and integrity issues that we will look in the later part of this article. We will look into following topics in this tutorial.
1.	Java Serializable Interface
2.	Class Refactoring with Serialization and serialVersionUID
3.	Java Externalizable Interface
4.	Java Serialization Methods
5.	Serialization with Inheritance
6.	Serialization Proxy Pattern
### Java Serializable Interface
If you want a class object to be serializable, all you need to do it implement the java.io.Serializableinterface. Serializable is a marker interface and has no fields or methods to implement. It’s like an Opt-In process through which we make our classes serializable.
Serialization process is implemented by ObjectInputStream and ObjectOutputStream, so all we need is a wrapper over them to either save it to file or send it over the network. Let’s see a simple Serialization example.

Employee.java
```java
package com.journaldev.serialization;
 
import java.io.Serializable;
 
public class Employee implements Serializable {
 
//  private static final long serialVersionUID = -6470090944414208496L;
     
    private String name;
    private int id;
    transient private int salary;
//  private String password;
     
    @Override
    public String toString(){
        return "Employee{name="+name+",id="+id+",salary="+salary+"}";
    }
     
    //getter and setter methods
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getSalary() {
        return salary;
    }
 
    public void setSalary(int salary) {
        this.salary = salary;
    }
 
//  public String getPassword() {
//      return password;
//  }
//
//  public void setPassword(String password) {
//      this.password = password;
//  }
     
}
```
Notice that it’s a simple java bean with some properties and getter-setter methods. If you want an object property to be not serialized to stream, you can use transient keyword like I have done with salary variable.
Now suppose we want to write our objects to file and then deserialize it from the same file. So we need utility methods that will use ObjectInputStream and ObjectOutputStream for serialization purposes.


SerializationUtil.java
```java
package com.journaldev.serialization;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
/**
 * A simple class with generic serialize and deserialize method implementations
 * 
 * @author pankaj
 * 
 */
public class SerializationUtil {
 
    // deserialize to Object from given file
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
 
    // serialize the given object and save it to file
    public static void serialize(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
 
        fos.close();
    }
 
}
```
Notice that the method arguments work with Object that is the base class of any java object. It’s written in this way to be generic in nature.
Now let’s write a test program to see Java Serialization in action.

SerializationTest.java
```java
package com.journaldev.serialization;
 
import java.io.IOException;
 
public class SerializationTest {
     
    public static void main(String[] args) {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);
         
        //serialize to file
        try {
            SerializationUtil.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
         
        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
         
        System.out.println("emp Object::"+emp);
        System.out.println("empNew Object::"+empNew);
    }
}
```
When we run above test program, we get following output.
```
emp Object::Employee{name=Pankaj,id=100,salary=5000}
empNew Object::Employee{name=Pankaj,id=100,salary=0}
```
Since salary is a transient variable, it’s value was not saved to file and hence not retrieved in the new object. Similarly static variable values are also not serialized since they belongs to class and not object.

### Class Refactoring with Serialization and serialVersionUID
Java Serialization permits some changes in the java class if they can be ignored. Some of the changes in class that will not affect the deserialization process are:
•	Adding new variables to the class
•	Changing the variables from transient to non-transient, for serialization it’s like having a new field.
•	Changing the variable from static to non-static, for serialization it’s like having a new field.
But for all these changes to work, the java class should have serialVersionUID defined for the class. Let’s write a test class just for deserialization of the already serialized file from previous test class.

DeserializationTest.java
```java
package com.journaldev.serialization;
 
import java.io.IOException;
 
public class DeserializationTest {
 
    public static void main(String[] args) {
 
        String fileName="employee.ser";
        Employee empNew = null;
         
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
         
        System.out.println("empNew Object::"+empNew);
         
    }
 
}
```
Now uncomment the “password” variable and it’s getter-setter methods from Employee class and run it. You will get below exception;

```
java.io.InvalidClassException: com.journaldev.serialization.Employee; local class incompatible: stream classdesc serialVersionUID = -6470090944414208496, local class serialVersionUID = -6234198221249432383
    at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:604)
    at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1601)
    at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1514)
    at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1750)
    at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1347)
    at java.io.ObjectInputStream.readObject(ObjectInputStream.java:369)
    at com.journaldev.serialization.SerializationUtil.deserialize(SerializationUtil.java:22)
    at com.journaldev.serialization.DeserializationTest.main(DeserializationTest.java:13)
empNew Object::null
```
The reason is clear that serialVersionUID of the previous class and new class are different. Actually if the class doesn’t define serialVersionUID, it’s getting calculated automatically and assigned to the class. Java uses class variables, methods, class name, package etc to generate this unique long number. If you are working with any IDE, you will automatically get a warning that “The serializable class Employee does not declare a static final serialVersionUID field of type long”.

We can use java utility “serialver” to generate the class serialVersionUID, for Employee class we can run it with below command.
1	SerializationExample/bin$serialver -classpath . com.journaldev.serialization.Employee
Note that it’s not required that the serial version is generated from this program itself, we can assign this value as we want. It just need to be there to let deserialization process know that the new class is the new version of the same class and should be deserialized of possible.

For example, uncomment only the serialVersionUID field from the Employee class and runSerializationTest program. Now uncomment the password field from Employee class and run theDeserializationTest program and you will see that the object stream is deserialized successfully because the change in Employee class is compatible with serialization process.

### Java Externalizable Interface
If you notice the serialization process, it’s done automatically. Sometimes we want to obscure the object data to maintain it’s integrity. We can do this by implementing java.io.Externalizable interface and provide implementation of writeExternal() and readExternal() methods to be used in serialization process.

Person.java
```java
package com.journaldev.externalization;
 
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
 
public class Person implements Externalizable{
 
    private int id;
    private String name;
    private String gender;
     
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name+"xyz");
        out.writeObject("abc"+gender);
    }
 
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        id=in.readInt();
        //read in the same order as written
        name=(String) in.readObject();
        if(!name.endsWith("xyz")) throw new IOException("corrupted data");
        name=name.substring(0, name.length()-3);
        gender=(String) in.readObject();
        if(!gender.startsWith("abc")) throw new IOException("corrupted data");
        gender=gender.substring(3);
    }
 
    @Override
    public String toString(){
        return "Person{id="+id+",name="+name+",gender="+gender+"}";
    }
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
}
```
Notice that I have changed the field values before converting it to Stream and then while reading reversed the changes. In this way, we can maintain data integrity of some sorts. We can throw exception if after reading the stream data, the integrity checks fail. Let’s write a test program to see it in action.

ExternalizationTest.java
```java
package com.journaldev.externalization;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class ExternalizationTest {
 
    public static void main(String[] args) {
         
        String fileName = "person.ser";
        Person person = new Person();
        person.setId(1);
        person.setName("Pankaj");
        person.setGender("Male");
         
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person p = (Person)ois.readObject();
            ois.close();
            System.out.println("Person Object Read="+p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
         
    }
 
}
```
When we run above program, we get following output.
1	Person Object Read=Person{id=1,name=Pankaj,gender=Male}
So which one is better to be used for serialization purpose. Actually it’s better to use Serializable interface and by the time we reach at the end of article, you will know why.
### Java Serialization Methods
We have seen that java serialization is automatic and all we need is implementing Serializable interface. The implementation is present in the ObjectInputStream and ObjectOutputStream classes. But what if we want to change the way we are saving data, for example we have some sensitive information in the object and before saving/retrieving we want to encrypt/decrypt it. That’s why there are four methods that we can provide in the class to change the serialization behavior.
If these methods are present in the class, they are used for serialization purposes.
1.	readObject(ObjectInputStream ois): If this method is present in the class, ObjectInputStream readObject() method will use this method for reading the object from stream.
2.	writeObject(ObjectOutputStream oos): If this method is present in the class, ObjectOutputStream writeObject() method will use this method for writing the object to stream. One of the common usage is to obscure the object variables to maintain data integrity.
3.	Object writeReplace(): If this method is present, then after serialization process this method is called and the object returned is serialized to the stream.
4.	Object readResolve(): If this method is present, then after deserialization process, this method is called to return the final object to the caller program. One of the usage of this method is to implement Singleton pattern with Serialized classes. Read more at Serialization and Singleton.
Usually while implementing above methods, it’s kept as private so that subclasses can’t override them. They are meant for serialization purpose only and keeping them private avoids any security issue.
### Serialization with Inheritance
Sometimes we need to extend a class that doesn’t implement Serializable interface. If we rely on the automatic serialization behavior and the superclass has some state, then they will not be converted to stream and hence not retrieved later on.
This is one place, where readObject() and writeObject() methods really help. By providing their implementation, we can save the super class state to the stream and then retrieve it later on. Let’s see this in action.

SuperClass.java
```java
package com.journaldev.serialization.inheritance;
 
public class SuperClass {
 
    private int id;
    private String value;
     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }   
}
```
SuperClass is a simple java bean but it’s not implementing Serializable interface.

SubClass.java
```java
package com.journaldev.serialization.inheritance;
 
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
public class SubClass extends SuperClass implements Serializable, ObjectInputValidation{
 
    private static final long serialVersionUID = -1322322139926390329L;
 
    private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
     
    @Override
    public String toString(){
        return "SubClass{id="+getId()+",value="+getValue()+",name="+getName()+"}";
    }
     
    //adding helper method for serialization to save/initialize super class state
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
        ois.defaultReadObject();
         
        //notice the order of read and write should be same
        setId(ois.readInt());
        setValue((String) ois.readObject());
         
    }
     
    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
         
        oos.writeInt(getId());
        oos.writeObject(getValue());
    }
 
    @Override
    public void validateObject() throws InvalidObjectException {
        //validate the object here
        if(name == null || "".equals(name)) throw new InvalidObjectException("name can't be null or empty");
        if(getId() <=0) throw new InvalidObjectException("ID can't be negative or zero");
    }
     
}
```
Notice that order of writing and reading the extra data to the stream should be same. We can put some logic in reading and writing data to make it secure.
Also notice that the class is implementing ObjectInputValidation interface. By implementingvalidateObject() method, we can put some business validations to make sure that the data integrity is not harmed.
Let’s write a test class and see if we can retrieve the super class state from serialized data or not.

InheritanceSerializationTest.java
```java
package com.journaldev.serialization.inheritance;
 
import java.io.IOException;
 
import com.journaldev.serialization.SerializationUtil;
 
public class InheritanceSerializationTest {
 
    public static void main(String[] args) {
        String fileName = "subclass.ser";
         
        SubClass subClass = new SubClass();
        subClass.setId(10);
        subClass.setValue("Data");
        subClass.setName("Pankaj");
         
        try {
            SerializationUtil.serialize(subClass, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
         
        try {
            SubClass subNew = (SubClass) SerializationUtil.deserialize(fileName);
            System.out.println("SubClass read = "+subNew);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
```
When we run above class, we get following output.
1	SubClass read = SubClass{id=10,value=Data,name=Pankaj}
So in this way, we can serialize super class state even though it’s not implementing Serializable interface. This strategy comes handy when the super class is a third-party class that we can’t change.
### Serialization Proxy Pattern
Java Serialization comes with some serious pitfalls such as;
•	The class structure can’t be changed a lot without breaking the serialization process. So even though we don’t need some variables later on, we need to keep them just for backward compatibility.
•	Serialization causes huge security risks, an attacker can change the stream sequence and cause harm to the system. For example, user role is serialized and an attacker change the stream value to make it admin and run malicious code.
Serialization Proxy pattern is a way to achieve greater security with Serialization. In this pattern, an inner private static class is used as a proxy class for serialization purpose. This class is designed in the way to maintain the state of the main class. This pattern is implemented by properly implementing readResolve()and writeReplace() methods.
Let us first write a class which implements serialization proxy pattern and then we will analyze it for better understanding.

Data.java
```java
package com.journaldev.serialization.proxy;
 
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
 
public class Data implements Serializable{
 
    private static final long serialVersionUID = 2087368867376448459L;
 
    private String data;
     
    public Data(String d){
        this.data=d;
    }
 
    public String getData() {
        return data;
    }
 
    public void setData(String data) {
        this.data = data;
    }
     
    @Override
    public String toString(){
        return "Data{data="+data+"}";
    }
     
    //serialization proxy class
    private static class DataProxy implements Serializable{
     
        private static final long serialVersionUID = 8333905273185436744L;
         
        private String dataProxy;
        private static final String PREFIX = "ABC";
        private static final String SUFFIX = "DEFG";
         
        public DataProxy(Data d){
            //obscuring data for security
            this.dataProxy = PREFIX + d.data + SUFFIX;
        }
         
        private Object readResolve() throws InvalidObjectException {
            if(dataProxy.startsWith(PREFIX) && dataProxy.endsWith(SUFFIX)){
            return new Data(dataProxy.substring(3, dataProxy.length() -4));
            }else throw new InvalidObjectException("data corrupted");
        }
         
    }
     
    //replacing serialized object to DataProxy object
    private Object writeReplace(){
        return new DataProxy(this);
    }
     
    private void readObject(ObjectInputStream ois) throws InvalidObjectException{
        throw new InvalidObjectException("Proxy is not used, something fishy");
    }
}
```
•	Both Data and DataProxy class should implement Serializable interface.
•	DataProxy should be able to maintain the state of Data object.
•	DataProxy is inner private static class, so that other classes can’t access it.
•	DataProxy should have a single constructor that takes Data as argument.
•	Data class should provide writeReplace() method returning DataProxy instance. So when Data object is serialized, the returned stream is of DataProxy class. However DataProxy class is not visible outside, so it can’t be used directly.
•	DataProxy class should implement readResolve() method returning Data object. So when Data class is deserialized, internally DataProxy is deserialized and when it’s readResolve() method is called, we get Data object.
•	Finally implement readObject() method in Data class and throw InvalidObjectException to avoid hackers attack trying to fabricate Data object stream and parse it.
Let’s write a small test to check whether implementation works or not.

SerializationProxyTest.java
```java
package com.journaldev.serialization.proxy;
 
import java.io.IOException;
 
import com.journaldev.serialization.SerializationUtil;
 
public class SerializationProxyTest {
 
    public static void main(String[] args) {
        String fileName = "data.ser";
         
        Data data = new Data("Pankaj");
         
        try {
            SerializationUtil.serialize(data, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            Data newData = (Data) SerializationUtil.deserialize(fileName);
            System.out.println(newData);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
```
When we run above class, we get below output in console.
1	Data{data=Pankaj}
If you will open the data.ser file, you can see that DataProxy object is saved as stream in the file.

### Why String is immutable or final in Java

String is one of the most used classes in any programming language. As we know that String is immutable and final in java and java runtime maintains a String pool that makes it a special class.
String immutable Benefits
1. String pool is possible only because String is immutable in java, this way Java Runtime saves a lot of java heap space because different String variables can refer to same String variable in the pool. If String would not have been immutable, then String interning would not have been possible because if any variable would have changed the value, it would have been reflected to other variables also.
2. If String is not immutable then it would cause severe security threat to the application. For example, database username, password are passed as String to get database connection and in socket programming host and port details passed as String. Since String is immutable it’s value can’t be changed otherwise any hacker could change the referenced value to cause security issues in the application.
3. Since String is immutable, it is safe for multithreading and a single String instance can be shared across different threads. This avoid the usage of synchronization for thread safety, Strings are implicitly thread safe.
4. Strings are used in java classloader and immutability provides security that correct class is getting loaded by Classloader. For example, think of an instance where you are trying to load java.sql.Connection class but the referenced value is changed to myhacked.Connection class that can do unwanted things to your database.
5. Since String is immutable, its hashcode is cached at the time of creation and it doesn’t need to be calculated again. This makes it a great candidate for key in a Map and it’s processing is fast than other HashMap key objects. This is why String is mostly used Object as HashMap keys.
Above are some of the reasons I could think of that shows benefits of String immutability. It’s a great feature of Java String class and makes it special.

http://www.journaldev.com/2452/java-serialization-example-tutorial-serializable-serialversionuid
http://www.journaldev.com/2461/spring-ioc-container-and-spring-bean-example-tutorial
http://www.journaldev.com/2394/dependency-injection-design-pattern-in-java-example-tutorial
http://www.journaldev.com/1016/java-thread-example-extending-thread-class-and-implementing-runnable-interface

