### Java Multithreading Interview Questions

What is the difference between Process and Thread?
What are the benefits of multi-threaded programming?
What is difference between user Thread and daemon Thread?
How can we create a Thread in Java?
What are different states in lifecycle of Thread?
Can we call run() method of a Thread class?
How can we pause the execution of a Thread for specific time?
What do you understand about Thread Priority?
What is Thread Scheduler and Time Slicing?
What is context-switching in multi-threading?
How can we make sure main() is the last thread to finish in Java Program?
How does thread communicate with each other?
Why thread communication methods wait(), notify() and notifyAll() are in Object class?
Why wait(), notify() and notifyAll() methods have to be called from synchronized method or block?
Why Thread sleep() and yield() methods are static?
How can we achieve thread safety in Java?
What is volatile keyword in Java
Which is more preferred - Synchronized method or Synchronized block?
How to create daemon thread in Java?
What is ThreadLocal?
What is Thread Group? Why it’s advised not to use it?
What is Java Thread Dump, How can we get Java Thread dump of a Program?
What is Deadlock? How to analyze and avoid deadlock situation?
What is Java Timer Class? How to schedule a task to run after specific interval?
What is Thread Pool? How can we create Thread Pool in Java?
What will happen if we don’t override Thread class run() method?
Java Concurrency Interview Questions
What is atomic operation? What are atomic classes in Java Concurrency API?
What is Lock interface in Java Concurrency API? What are it’s benefits over synchronization?
What is Executors Framework?
What is BlockingQueue? How can we implement Producer-Consumer problem using Blocking Queue?
What is Callable and Future?
What is FutureTask class?
What are Concurrent Collection Classes?
What is Executors Class?
What are some of the improvements in Concurrency API in Java 8?

### Java Multithreading Interview Questions and Answers

What is the difference between Process and Thread?
A process is a self contained execution environment and it can be seen as a program or application whereas Thread is a single task of execution within the process. Java runtime environment runs as a single process which contains different classes and programs as processes. Thread can be called lightweight process. Thread requires less resources to create and exists in the process, thread shares the process resources.

What are the benefits of multi-threaded programming?
In Multi-Threaded programming, multiple threads are executing concurrently that improves the performance because CPU is not idle incase some thread is waiting to get some resources. Multiple threads share the heap memory, so it’s good to create multiple threads to execute some task rather than creating multiple processes. For example, Servlets are better in performance than CGI because Servlet support multi-threading but CGI doesn’t.

What is difference between user Thread and daemon Thread?
When we create a Thread in java program, it’s known as user thread. A daemon thread runs in background and doesn’t prevent JVM from terminating. When there are no user threads running, JVM shutdown the program and quits. A child thread created from daemon thread is also a daemon thread.

How can we create a Thread in Java?
There are two ways to create Thread in Java - first by implementing Runnable interface and then creating a Thread object from it and second is to extend the Thread Class. Read this post to learn more about creating threads in java.

What are different states in lifecycle of Thread?
When we create a Thread in java program, its state is New. Then we start the thread that change it's state to Runnable. Thread Scheduler is responsible to allocate CPU to threads in Runnable thread pool and change their state to Running. Other Thread states are Waiting, Blocked and Dead. Read this post to learn more about [life cycle of thread](/community/tutorials/thread-life-cycle-in-java-thread-states-in-java).
Can we call run() method of a Thread class?
Yes, we can call run() method of a Thread class but then it will behave like a normal method. To actually execute it in a Thread, we need to start it using **Thread.start()** method.
How can we pause the execution of a Thread for specific time?
We can use Thread class sleep() method to pause the execution of Thread for certain time. Note that this will not stop the processing of thread for specific time, once the thread awake from sleep, it's state gets changed to runnable and based on thread scheduling, it gets executed.
What do you understand about Thread Priority?
Every thread has a priority, usually higher priority thread gets precedence in execution but it depends on Thread Scheduler implementation that is OS dependent. We can specify the priority of thread but it doesn't guarantee that higher priority thread will get executed before lower priority thread. Thread priority is an _int_ whose value varies from 1 to 10 where 1 is the lowest priority thread and 10 is the highest priority thread.
What is Thread Scheduler and Time Slicing?
Thread Scheduler is the Operating System service that allocates the CPU time to the available runnable threads. Once we create and start a thread, it's execution depends on the implementation of Thread Scheduler. Time Slicing is the process to divide the available CPU time to the available runnable threads. Allocation of CPU time to threads can be based on thread priority or the thread waiting for longer time will get more priority in getting CPU time. Thread scheduling can't be controlled by java, so it's always better to control it from application itself.
What is context-switching in multi-threading?
Context Switching is the process of storing and restoring of CPU state so that Thread execution can be resumed from the same point at a later point of time. Context Switching is the essential feature for multitasking operating system and support for multi-threaded environment.
How can we make sure main() is the last thread to finish in Java Program?
We can use Thread join() method to make sure all the threads created by the program is dead before finishing the main function. Here is an article about [Thread join method](https://www.digitalocean.com/community/tutorials/java-thread-join-example).
How does thread communicate with each other?
When threads share resources, communication between Threads is important to coordinate their efforts. Object class wait(), notify() and notifyAll() methods allows threads to communicate about the lock status of a resource. Check this post to learn more about [thread wait, notify and notifyAll](https://www.digitalocean.com/community/tutorials/java-thread-wait-notify-and-notifyall-example).
Why thread communication methods wait(), notify() and notifyAll() are in Object class?
In Java every Object has a monitor and wait, notify methods are used to wait for the Object monitor or to notify other threads that Object monitor is free now. There is no monitor on threads in java and synchronization can be used with any Object, that's why it's part of Object class so that every class in java has these essential methods for inter thread communication.
Why wait(), notify() and notifyAll() methods have to be called from synchronized method or block?
When a Thread calls wait() on any Object, it must have the monitor on the Object that it will leave and goes in wait state until any other thread call notify() on this Object. Similarly when a thread calls notify() on any Object, it leaves the monitor on the Object and other waiting threads can get the monitor on the Object. Since all these methods require Thread to have the Object monitor, that can be achieved only by synchronization, they need to be called from synchronized method or block.
Why Thread sleep() and yield() methods are static?
Thread sleep() and yield() methods work on the currently executing thread. So there is no point in invoking these methods on some other threads that are in wait state. That’s why these methods are made static so that when this method is called statically, it works on the current executing thread and avoid confusion to the programmers who might think that they can invoke these methods on some non-running threads.
How can we achieve thread safety in Java?
There are several ways to achieve thread safety in java - synchronization, atomic concurrent classes, implementing concurrent Lock interface, using volatile keyword, using immutable classes and Thread safe classes. Learn more at [thread safety tutorial](https://www.digitalocean.com/)community/tutorials/thread-safety-in-java).
What is volatile keyword in Java
When we use volatile keyword with a variable, all the threads read it's value directly from the memory and don't cache it. This makes sure that the value read is the same as in the memory.
Which is more preferred - Synchronized method or Synchronized block?
Synchronized block is more preferred way because it doesn't lock the Object, synchronized methods lock the Object and if there are multiple synchronization blocks in the class, even though they are not related, it will stop them from execution and put them in wait state to get the lock on Object.
How to create daemon thread in Java?
Thread class setDaemon(true) can be used to create daemon thread in java. We need to call this method before calling start() method else it will throw IllegalThreadStateException.
What is ThreadLocal?
Java ThreadLocal is used to create thread-local variables. We know that all threads of an Object share it’s variables, so if the variable is not thread safe, we can use synchronization but if we want to avoid synchronization, we can use ThreadLocal variables. Every thread has its own ThreadLocal variable and they can use it gets () and set() methods to get the default value or change it’s value local to Thread. ThreadLocal instances are typically private static fields in classes that wish to associate the state with a thread. Check this post for small example program showing [ThreadLocal Example](https://www.digitalocean.com/community/tutorials/java-threadlocal-example).
What is Thread Group? Why it’s advised not to use it?
ThreadGroup is a class which was intended to provide information about a thread group. ThreadGroup API is weak and it doesn't have any functionality that is not provided by Thread. It has two main features - to get the list of active threads in a thread group and to set the uncaught exception handler for the thread. But Java 1.5 has added _setUncaughtExceptionHandler(UncaughtExceptionHandler eh)_ method using which we can add uncaught exception handler to the thread. So ThreadGroup is obsolete and hence not advised to use anymore.

```
t1.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){

@Override
public void uncaughtException(Thread t, Throwable e) {
    System.out.println("exception occured:"+e.getMessage());
}
            
});
```
What is Java Thread Dump, How can we get Java Thread dump of a Program?
A thread dump is a list of all the threads active in the JVM, thread dumps are very helpful in analyzing bottlenecks in the application and analyzing deadlock situations. There are many ways using which we can generate Thread dump - Using Profiler, Kill -3 command, jstack tool, etc. I prefer jstack tool to generate thread dump of a program because it's easy to use and comes with JDK installation. Since it's a terminal-based tool, we can create a script to generate thread dump at regular intervals to analyze it later on. Read this post to know more about [generating thread dump in java](https://www.digitalocean.com/community/tutorials/java-thread-dump-visualvm-jstack-kill-3-jcmd).
What is Deadlock? How to analyze and avoid deadlock situation?
Deadlock is a programming situation where two or more threads are blocked forever, this situation arises with at least two threads and two or more resources. To analyze a deadlock, we need to look at the java thread dump of the application, we need to look out for the threads with state as BLOCKED and then the resources it’s waiting to lock, every resource has a unique ID using which we can find which thread is already holding the lock on the object. Avoid Nested Locks, Lock Only What is Required and Avoid waiting indefinitely are common ways to avoid deadlock situation, read this post to learn how to [analyze deadlock in java](https://www.digitalocean.com/community/tutorials/deadlock-in-java-example) with a sample program.
What is Java Timer Class? How to schedule a task to run after the specified interval?
java.util.Timer is a utility class that can be used to schedule a thread to be executed at a certain time in future. Java Timer class can be used to schedule a task to be run one-time or to be run at regular intervals. java.util.TimerTask is an **[abstract class](https://www.digitalocean.com/community/tutorials/abstract-class-in-java "Abstract Class in Java with Example")** that implements Runnable interface and we need to extend this class to create our own TimerTask that can be scheduled using java Timer class. Check this post for [java Timer example](/community/tutorials/java-timer-timertask-example).
What is Thread Pool? How can we create Thread Pool in Java?
A thread pool manages the pool of worker threads, it contains a queue that keeps tasks waiting to get executed. A thread pool manages the collection of Runnable threads and worker threads execute Runnable from the queue. java.util.concurrent.Executors provide implementation of java.util.concurrent.Executor interface to create the thread pool in java. [Thread Pool Example](https://www.digitalocean.com/community/tutorials/threadpoolexecutor-java-thread-pool-example-executorservice) program shows how to create and use Thread Pool in java. Or read [ScheduledThreadPoolExecutor Example](https://www.digitalocean.com/community/tutorials/java-scheduler-scheduledexecutorservice-scheduledthreadpoolexecutor-example) to know how to schedule tasks after certain delay.
What will happen if we don’t override Thread class run() method?
Thread class run() method code is as shown below.

```
public void run() {
    if (target != null) {
        target.run();
    }
}
```

Above target set in the init() method of Thread class and if we create an instance of Thread class as `new TestThread()`, it's set to null. So nothing will happen if we don't override the run() method. Below is a simple example demonstrating this.

```
public class TestThread extends Thread {

	//not overriding Thread.run() method
	
	//main method, can be in other class too
	public static void main(String args[]){
		Thread t = new TestThread();
		System.out.println("Before starting thread");
		t.start();
		System.out.println("After starting thread");
	}
}
```

It will print only below output and terminate.

```
Before starting thread
After starting thread
```
Java Concurrency Interview Questions and Answers
What is atomic operation? What are atomic classes in Java Concurrency API?
Atomic operations are performed in a single unit of task without interference from other operations. Atomic operations are necessity in multi-threaded environment to avoid data inconsistency. int++ is not an atomic operation. So by the time one thread read its value and increment it by one, another thread has read the older value leading to the wrong result. To solve this issue, we will have to make sure that increment operation on count is atomic, we can do that using Synchronization but Java 5 java.util.concurrent.atomic provides wrapper classes for int and long that can be used to achieve this atomically without the usage of Synchronization. Go to this article to learn more about atomic concurrent classes.

What is Lock interface in Java Concurrency API? What are its benefits over synchronization?
Lock interface provides more extensive locking operations than can be obtained using synchronized methods and statements. They allow more flexible structuring, may have quite different properties and may support multiple associated Condition objects. The advantages of a lock are

it’s possible to make them fair
it’s possible to make a thread responsive to interruption while waiting on a Lock object.
it’s possible to try to acquire the lock, but return immediately or after a timeout if the lock can’t be acquired
it’s possible to acquire and release locks in different scopes, and in different orders
Read more at Java Lock Example.

What is Executors Framework?
In Java 5, Executor framework was introduced with the java.util.concurrent.Executor interface. The Executor framework is a framework for standardizing invocation, scheduling, execution, and control of asynchronous tasks according to a set of execution policies. Creating a lot many threads with no bounds to the maximum threshold can cause the application to run out of heap memory. So, creating a ThreadPool is a better solution as a finite number of threads can be pooled and reused. Executors framework facilitate the process of creating Thread pools in java. Check out this post to learn with example code to create thread pool using Executors framework.

What is BlockingQueue? How can we implement Producer-Consumer problem using Blocking Queue?
java.util.concurrent.BlockingQueue is a Queue that supports operations that wait for the queue to become non-empty when retrieving and removing an element, and wait for space to become available in the queue when adding an element. BlockingQueue doesn’t accept null values and throw NullPointerException if you try to store null value in the queue. BlockingQueue implementations are thread-safe. All queuing methods are atomic in nature and use internal locks or other forms of concurrency control. BlockingQueue interface is part of the Java collections framework and it’s primarily used for implementing the producer-consumer problem. Check this post for producer-consumer problem implementation using BlockingQueue.

What is Callable and Future?
Java 5 introduced java.util.concurrent.Callable interface in concurrency package that is similar to Runnable interface but it can return any Object and able to throw Exception. The Callable interface uses Generics to define the return type of Object. Executors class provide useful methods to execute Callable in a thread pool. Since callable tasks run in parallel, we have to wait for the returned Object. Callable tasks return java.util.concurrent.Future object. Using Future we can find out the status of the Callable task and get the returned Object. It provides the get() method that can wait for the Callable to finish and then return the result. Check this post for [Callable Future Example](/community/tutorials/java-callable-future-example).
What is FutureTask Class?
FutureTask is the base implementation class of Future interface and we can use it with Executors for asynchronous processing. Most of the time we don't need to use FutureTask class but it comes real handy if we want to override some of the methods of Future interface and want to keep most of the base implementation. We can just extend this class and override the methods according to our requirements. Check out **[Java FutureTask Example](https://www.digitalocean.com/community/tutorials/java-futuretask-example-program "Java FutureTask Example Program")** post to learn how to use it and what are different methods it has.
What are Concurrent Collection Classes?
Java Collection classes are fail-fast which means that if the Collection will be changed while some thread is traversing over it using iterator, the iterator.next() will throw ConcurrentModificationException. Concurrent Collection classes support full concurrency of retrievals and adjustable expected concurrency for updates. Major classes are ConcurrentHashMap, CopyOnWriteArrayList and CopyOnWriteArraySet, check this post to learn [how to avoid ConcurrentModificationException when using iterator](https://www.digitalocean.com/community/tutorials/java-util-concurrentmodificationexception).
What is Executors Class?
Executors class provide utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes. Executors class can be used to easily create Thread Pool in java, also this is the only class supporting execution of Callable implementations.
What are some of the improvements in Concurrency API in Java 8?
Some important concurrent API enhancements are:

-   ConcurrentHashMap compute(), forEach(), forEachEntry(), forEachKey(), forEachValue(), merge(), reduce() and search() methods.
-   CompletableFuture that may be explicitly completed (setting its value and status).
-   Executors newWorkStealingPool() method to create a work-stealing thread pool using all available processors as its target parallelism level.

**Recommended Read**: [Java 8 Features](https://www.digitalocean.com/community/tutorials/java-8-features-with-examples "Java 8 Features for Developers – lambdas, Functional interface, Stream and Time API")
That’s all for Java Thread and Concurrency interview questions, I have been adding more to this list. So bookmark the post for future reference.

Java 8 was released on 18th March 2014. That’s a long time ago but still many projects are running on Java 8. It’s because it was a major release with a lot of new features. Let’s look at all the exciting and major features of Java 8 with example code.

Quick Overview of Java 8 Features
Some of the important Java 8 features are;

forEach() method in Iterable interface
default and static methods in Interfaces
Functional Interfaces and Lambda Expressions
Java Stream API for Bulk Data Operations on Collections
Java Time API
Collection API improvements
Concurrency API improvements
Java IO improvements
Let’s have a brief look on these Java 8 features. I will provide some code snippets for better understanding the features in a simple way.

1. forEach() method in Iterable interface
Whenever we need to traverse through a Collection, we need to create an Iterator whose whole purpose is to iterate over, and then we have business logic in a loop for each of the elements in the Collection. We might get ConcurrentModificationException if the iterator is not used properly.

Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic. The forEach method takes java.util.function.Consumer object as an argument, so it helps in having our business logic at a separate location that we can reuse. Let’s see forEach usage with a simple example.

package com.journaldev.java8.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

public class Java8ForEachExample {

 public static void main(String[] args) {
  
  //creating sample Collection
  List<Integer> myList = new ArrayList<Integer>();
  for(int i=0; i<10; i++) myList.add(i);
  
  //traversing using Iterator
  Iterator<Integer> it = myList.iterator();
  while(it.hasNext()){
   Integer i = it.next();
   System.out.println("Iterator Value::"+i);
  }
  
  //traversing through forEach method of Iterable with anonymous class
  myList.forEach(new Consumer<Integer>() {

   public void accept(Integer t) {
    System.out.println("forEach anonymous class Value::"+t);
   }

  });
  
  //traversing with Consumer interface implementation
  MyConsumer action = new MyConsumer();
  myList.forEach(action);
  
 }

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

 public void accept(Integer t) {
  System.out.println("Consumer impl Value::"+t);
 }
}
The number of lines might increase but forEach method helps in having the logic for iteration and business logic at separate place resulting in higher separation of concern and cleaner code.

2. default and static methods in Interfaces
If you read forEach method details carefully, you will notice that it’s defined in Iterable interface but we know that interfaces can’t have a method body. From Java 8, interfaces are enhanced to have a method with implementation. We can use default and static keyword to create interfaces with method implementation. forEach method implementation in Iterable interface is:

default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }
}
We know that Java doesn’t provide multiple inheritance in Classes because it leads to Diamond Problem. So how it will be handled with interfaces now since interfaces are now similar to abstract classes?

The solution is that compiler will throw an exception in this scenario and we will have to provide implementation logic in the class implementing the interfaces.

package com.journaldev.java8.defaultmethod;

@FunctionalInterface
public interface Interface1 {

 void method1(String str);
 
 default void log(String str){
  System.out.println("I1 logging::"+str);
 }
 
 static void print(String str){
  System.out.println("Printing "+str);
 }
 
 //trying to override Object method gives compile-time error as
 //"A default method cannot override a method from java.lang.Object"
 
// default String toString(){
//  return "i1";
// }
 
}
package com.journaldev.java8.defaultmethod;

@FunctionalInterface
public interface Interface2 {

 void method2();
 
 default void log(String str){
  System.out.println("I2 logging::"+str);
 }

}
Notice that both the interfaces have a common method log() with implementation logic.

package com.journaldev.java8.defaultmethod;

public class MyClass implements Interface1, Interface2 {

 @Override
 public void method2() {
 }

 @Override
 public void method1(String str) {
 }

 //MyClass won't compile without having it's own log() implementation
 @Override
 public void log(String str){
  System.out.println("MyClass logging::"+str);
  Interface1.print("abc");
 }
 
}
As you can see that Interface1 has static method implementation that is used in MyClass.log() method implementation. Java 8 uses default and static methods heavily in Collection API and default methods are added so that our code remains backward compatible.

If any class in the hierarchy has a method with the same signature, then default methods become irrelevant. The Object is the base class, so if we have equals(), hashCode() default methods in the interface, it will become irrelevant. That’s why for better clarity, interfaces are not allowed to have Object default methods.

For complete details of interface changes in Java 8, please read Java 8 interface changes.

3. Functional Interfaces and Lambda Expressions
If you notice the above interface code, you will notice @FunctionalInterface annotation. Functional interfaces are a new concept introduced in Java 8. An interface with exactly one abstract method becomes a Functional Interface. We don’t need to use @FunctionalInterface annotation to mark an interface as a Functional Interface.

@FunctionalInterface annotation is a facility to avoid the accidental addition of abstract methods in the functional interfaces. You can think of it like @Override annotation and it’s best practice to use it. java.lang.Runnable with a single abstract method run() is a great example of a functional interface.

One of the major benefits of the functional interface is the possibility to use lambda expressions to instantiate them. We can instantiate an interface with an anonymous class but the code looks bulky.

Runnable r = new Runnable(){
   @Override
   public void run() {
    System.out.println("My Runnable");
   }};
Since functional interfaces have only one method, lambda expressions can easily provide the method implementation. We just need to provide method arguments and business logic. For example, we can write above implementation using lambda expression as:

Runnable r1 = () -> {
   System.out.println("My Runnable");
  };
If you have single statement in method implementation, we don’t need curly braces also. For example above Interface1 anonymous class can be instantiated using lambda as follows:

Interface1 i1 = (s) -> System.out.println(s);
  
i1.method1("abc");
So lambda expressions are a means to create anonymous classes of functional interfaces easily. There are no runtime benefits of using lambda expressions, so I will use it cautiously because I don’t mind writing a few extra lines of code.

A new package java.util.function has been added with bunch of functional interfaces to provide target types for lambda expressions and method references. Lambda expressions are a huge topic, I will write a separate article on that in the future.

You can read complete tutorial at Java 8 Lambda Expressions Tutorial.

4. Java Stream API for Bulk Data Operations on Collections
A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the collection. Stream API will allow sequential as well as parallel execution. This is one of the best features for me because I work a lot with Collections and usually with Big Data, we need to filter out them based on some conditions.

Collection interface has been extended with stream() and parallelStream() default methods to get the Stream for sequential and parallel execution. Let’s see their usage with a simple example.

package com.journaldev.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

 public static void main(String[] args) {
  
  List<Integer> myList = new ArrayList<>();
  for(int i=0; i<100; i++) myList.add(i);
  
  //sequential stream
  Stream<Integer> sequentialStream = myList.stream();
  
  //parallel stream
  Stream<Integer> parallelStream = myList.parallelStream();
  
  //using lambda with Stream API, filter example
  Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
  //using lambda in forEach
  highNums.forEach(p -> System.out.println("High Nums parallel="+p));
  
  Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
  highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

 }

}
If you will run above example code, you will get output like this:

High Nums parallel=91
High Nums parallel=96
High Nums parallel=93
High Nums parallel=98
High Nums parallel=94
High Nums parallel=95
High Nums parallel=97
High Nums parallel=92
High Nums parallel=99
High Nums sequential=91
High Nums sequential=92
High Nums sequential=93
High Nums sequential=94
High Nums sequential=95
High Nums sequential=96
High Nums sequential=97
High Nums sequential=98
High Nums sequential=99
Notice that parallel processing values are not in order, so parallel processing will be very helpful while working with huge collections.

Covering everything about Stream API is not possible in this post, you can read everything about Stream API at Java 8 Stream API Example Tutorial.

5. Java Time API
It has always been hard to work with Date, Time, and Time Zones in java. There was no standard approach or API in java for date and time in Java. One of the nice addition in Java 8 is the java.time package that will streamline the process of working with time in java.

Just by looking at Java Time API packages, I can sense that they will be very easy to use. It has some sub-packages java.time.format that provides classes to print and parse dates and times and java.time.zone provides support for time zones and their rules.

The new Time API prefers enums over integer constants for months and days of the week. One of the useful classes is DateTimeFormatter for converting DateTime objects to strings. For a complete tutorial, head over to Java Date Time API Example Tutorial.

6. Collection API improvements
We have already seen forEach() method and Stream API for collections. Some new methods added in Collection API are:

Iterator default method forEachRemaining(Consumer action) to perform the given action for each remaining element until all elements have been processed or the action throws an exception.
Collection default method removeIf(Predicate filter) to remove all of the elements of this collection that satisfy the given predicate.
Collection spliterator() method returning Spliterator instance that can be used to traverse elements sequentially or parallel.
Map replaceAll(), compute(), merge() methods.
Performance Improvement for HashMap class with Key Collisions
7. Concurrency API improvements
Some important concurrent API enhancements are:

ConcurrentHashMap compute(), forEach(), forEachEntry(), forEachKey(), forEachValue(), merge(), reduce() and search() methods.
CompletableFuture that may be explicitly completed (setting its value and status).
Executors newWorkStealingPool() method to create a work-stealing thread pool using all available processors as its target parallelism level.
8. Java IO improvements
Some IO improvements known to me are:

Files.list(Path dir) that returns a lazily populated Stream, the elements of which are the entries in the directory.
Files.lines(Path path) that reads all lines from a file as a Stream.
Files.find() that returns a Stream that is lazily populated with Path by searching for files in a file tree rooted at a given starting file.
BufferedReader.lines() that return a Stream, the elements of which are lines read from this BufferedReader.
Miscellaneous Java 8 Core API improvements
Some miscellaneous API improvements that might come handy are:

ThreadLocal static method withInitial(Supplier supplier) to create instances easily.
The Comparator interface has been extended with a lot of default and static methods for natural ordering, reverse order, etc.
min(), max() and sum() methods in Integer, Long and Double wrapper classes.
logicalAnd(), logicalOr() and logicalXor() methods in Boolean class.
ZipFile.stream() method to get an ordered Stream over the ZIP file entries. Entries appear in the Stream in the order they appear in the central directory of the ZIP file.
Several utility methods in Math class.
jjs command is added to invoke Nashorn Engine.
jdeps command is added to analyze class files
JDBC-ODBC Bridge has been removed.
PermGen memory space has been removed
