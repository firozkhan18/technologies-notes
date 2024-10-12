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

