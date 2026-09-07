Java Multithreading : Multithreading in Java is a feature that allows multiple tasks to run concurrently within the same program. Instead of executing one task at a time, Java enables parallel execution using lightweight threads. This makes applications more efficient, faster and responsive in real-world scenarios like servers, games and chat systems.

Key Features of Multithreading
A thread is the smallest unit of execution in Java.
Threads share the same memory space but run independently.
Java provides the Thread class and Runnable interface to create threads.
Multithreading ensures better CPU utilization by executing tasks simultaneously.
Synchronization is needed to prevent data inconsistency when threads share resources.
Example: Suppose a restaurant kitchen where multiple chefs are working simultaneously on different dishes. This setup ensures faster service and better CPU (chef) utilization, just like threads in Java.

Example: Java Program to illustrate Creation and execution of a thread via start() and run() method in Single inheritance

```java
class MyThread1 extends Thread {
public void run()
{
System.out.println("Thread1 is running");
}
}

class MyThread2 extends Thread {
public void run()
{
System.out.println("Thread2 is running");
}
}
class GFG {
public static void main(String[] args)
{
MyThread1 obj1 = new MyThread1();
MyThread2 obj2 = new MyThread2();
obj1.start();
obj2.start();
}
}
```
Output
```
Thread1 is running
Thread2 is running
```
**Introduction to Multithreading**

Multithreading allows concurrent execution of two or more parts of a program for maximum CPU usage. It improves application performance and responsiveness.

**Introduction**

**Multithreading in Java**

Multithreading in Java is a feature that enables a program to run multiple threads simultaneously, allowing tasks to execute in parallel and utilize the CPU more efficiently. A thread is a lightweight, independent unit of execution inside a program (process).

* Threads allow parallel execution of tasks.
* A process can have multiple threads.
* Each thread runs independently but shares the same memory.

**Example** : Imagine a restaurant kitchen. Multiple chefs (threads) are preparing different dishes at the same time. This speeds up service and utilizes all available resources (CPU).

main_program_restaurant_manager_
Multithreading
Different Ways to Create Threads
Threads can be created by using two mechanisms:

**1. Extending the Thread class**
We create a class that extends Thread and override its run() method to define the task. Then, we make an object of this class and call start(), which automatically calls run() and begins the thread’s execution.

Example: Restaurant Kitchen (Extending Thread)
```java
class CookingTask extends Thread {
private String task;
​
CookingTask(String task) {
this.task = task;
}
​
public void run() {
System.out.println(task + " is being prepared by " +
Thread.currentThread().getName());
}
}
​
public class Restaurant {
public static void main(String[] args) {
Thread t1 = new CookingTask("Pasta");
Thread t2 = new CookingTask("Salad");
Thread t3 = new CookingTask("Dessert");
Thread t4 = new CookingTask("Rice");
​
t1.start();
t2.start();
t3.start();
t4.start();
}
}
```
Note: The order of thread execution may vary on each run because thread scheduling is non-deterministic.


Output
```
Rice is being prepared by Thread-3
Pasta is being prepared by Thread-0
Dessert is being prepared by Thread-2
Salad is being prepared by Thread-1
```
*Explanation*:

We created multiple threads (t1–t4) using the CookingTask class.
Each thread represents a dish being prepared.
Calling start() creates a new thread with its own call stack and internally invokes the run() method. This allows threads to run concurrently with the main thread and each other.
**2.Implementing the Runnable Interface**
   We create a new class which implements java.lang.Runnable interface and define the run() method there. Then we instantiate a Thread object and call start() method on this object.

Example: Restaurant Kitchen (Runnable Interface)
```java
class CookingJob implements Runnable {
private String task;
​
CookingJob(String task) {
this.task = task;
}
​
public void run() {
System.out.println(task + " is being prepared by " +
Thread.currentThread().getName());
}
}
​
public class RestaurantRunnable {
public static void main(String[] args) {
Thread t1 = new Thread(new CookingJob("Soup"));
Thread t2 = new Thread(new CookingJob("Pizza"));
Thread t3 = new Thread(new CookingJob("Burger"));
​
t1.start();
t2.start();
t3.start();
}
}
```
Note: The order of thread execution may vary on each run because thread scheduling is non-deterministic.


Output
```
Burger is being prepared by Thread-2
Pizza is being prepared by Thread-1
Soup is being prepared by Thread-0
```
Explanation:

Cooking job implements Runnable and overrides run().
We pass a Runnable object to the Thread constructor.
Calling start() creates a new thread with its own call stack and internally invokes the run() method. This allows threads to run concurrently with the main thread and each other.

**Best Use Cases for Thread and Runnable**
Use extends Thread: if your class does not extend any other class.
Use implements Runnable: if your class already extends another class (preferred because Java doesn’t support multiple inheritance).

**Advantages of Multithreading in Java**

**Improved Performance**: Multiple tasks can run simultaneously, reducing execution time.
**Efficient CPU Utilization**: Threads keep the CPU busy by running tasks in parallel.
**Responsiveness**: Applications (like GUIs) remain responsive while performing background tasks.
**Resource Sharing**: Threads within the same process share memory and resources, avoiding duplication.
**Better User Experience**: Smooth execution of tasks like file downloads, animations, and real-time updates.

Multithreading allows concurrent execution of two or more parts of a program for maximum CPU usage. It improves application performance and responsiveness.



**Multiprocessing vs. Multithreading**

**Difference between Multiprocessing and Multithreading**

Multiprocessing and multithreading are techniques used to enhance application performance through parallel execution. They help systems handle multiple tasks efficiently by utilizing CPU resources effectively.

Enable faster execution of tasks.
Improve overall system performance.
Support parallel processing of tasks.

**Multiprocessing**

Multiprocessing is a system that has more than one or two processors. In Multiprocessing, CPUs are added to increase the computing speed of the system. Because of Multiprocessing, There are many processes are executed simultaneously. Explore more about similar topics.

**Multiprocessing is classified into two categories**:


* Symmetric Multiprocessing
* Asymmetric Multiprocessing

**multiprocessing**

* Advantages

Increases computing power by utilizing multiple processors.
Suitable for tasks that require heavy computational power.

* Disadvantages

Process creation is time-consuming.

Each process has its own address space, which can lead to higher memory usage.

**Multithreading**

Multithreading is a system in which multiple threads are created of a process for increasing the computing speed of the system. In multithreading, many threads of a process are executed simultaneously and process creation in multithreading is done according to economical.

Multiple threads run within the same process
Shares memory, so communication is faster

multithreading

* Advantages
More efficient than multiprocessing for tasks within a single process.
Threads share a common address space, which is memory-efficient.

* Disadvantages
Not classified into categories like multiprocessing.
Thread creation is economical but can lead to synchronization issues.

**Multiprocessing Vs Multithreading**

| Multiprocessing	| Multithreading |
| In multiprocessing, CPUs are added for increasing computing power.	| While In multithreading, many threads are created of a single process for increasing computing power.|
| In multiprocessing, Many processes are executed simultaneously.	| While in multithreading, many threads of a process are executed simultaneously.|
| Multiprocessing are classified into Symmetric and Asymmetric.	| While multithreading is not classified in any categories.|
| In multiprocessing, Process creation is a time-consuming process.	| While in multithreading, process creation is according to economical.|
| In multiprocessing, every process ownes a separate address space.	| While in multithreading, a common address space is shared by all the threads.|

*Processes vs Threads*

A process is an independent program in execution, while a thread is a lightweight sub-process. Understanding their differences is key to mastering concurrency.

*Process vs. Thread*
Process vs Thread

Modern operating systems are designed to handle multiple tasks efficiently while maintaining good performance and responsiveness. These are mainly achieved through processes and threads.

Process is the Independent program with its own memory
Thread is small unit of a process sharing same memory
Process
Process is a program that is currently in execution within an operating system. It operates in an independent environment and is managed by the OS for proper scheduling and execution. Processes form the basis of program execution in a multitasking system. Its Properties are:

Each process has a unique Process ID (PID) for identification.
Every process moves through different states such as new, ready, running, waiting, and terminated.
Processes communicate with each other using Inter-Process Communication (IPC) methods.
12
Process
Thread
Thread is a smallest unit of execution within a process. It enables a program to perform multiple tasks concurrently while sharing the same memory and resources. Threads improve application performance and responsiveness in multitasking environments. Its properties are:

Each thread has its own Thread ID (TID) for identification.
A thread also moves through states such as new, runnable, running, waiting, and terminated.
Threads within the same process share memory and resources, enabling faster communication.
Context switching can occur between threads to allow multiple tasks to execute efficiently.
thread
Thread
Similarities Between Threads and Processes
Units of Execution: Both are execution units within an operating system and are part of process management.
OS Scheduling & Preemption: Both are scheduled by the operating system for fair CPU allocation, and can be preempted for multitasking.
Own Execution Context: Each has its own execution context, including program counter, CPU registers, and stack space.
Creation During Runtime: Both can create child entities during their execution lifecycle.
Communication & Resource Release: Both can communicate using IPC mechanisms, and upon termination, their allocated resources are released back to the operating system
Process vs Thread
Process	Thread
Program in execution	Part of a process
Takes more time to create & terminate	Takes less time to create & terminate
Context switching is slow	Context switching is fast
Heavyweight	Lightweight
Less efficient communication	More efficient communication
Blocking one process doesn’t affect others	Blocking a user-level thread may block all
Uses system calls	Created using APIs (may not need OS call)
Has its own PCB, stack, address space	Shares PCB & address space, has own TCB & stack
Does not share data	Shares data with other threads



Java Thread Model

Java Threads

A thread in Java is the smallest unit of execution within a process. Threads allow multiple tasks to execute concurrently while sharing the resources of the same process. Threads are commonly used for tasks such as background processing, file operations, network requests, and handling multiple client requests.

Threads share the memory and resources of their process.
Java provides the Thread class and Runnable interface for creating threads.
Create Threads
There are two traditional ways to create a thread in Java:

Thread
Thread-Creation
1. By Extending Thread Class
   Create a class that extends Thread. Override the run() method, this is where you put the code that the thread should execute. Then create an object of your class and call the start() method. This will internally call run() in a new thread.






import java.io.*;
import java.util.*;
​
class MyThread extends Thread{

    // initiated run method for Thread
    public void run(){
        
        String str = "Thread Started Running...";
        System.out.println(str);
    }
}
​
public class Geeks{

    public static void main(String args[]){
        
        MyThread t1 = new MyThread();
        t1.start();
    }
}

Output
Thread Started Running...
Explanation:

MyThread extends the Thread class.
The run() method contains the task performed by the thread.
t1 creates a thread object.
start() starts a new thread.
The JVM then invokes the run() method on that new thread.
2. Using Runnable Interface
   Create a class that implements Runnable. Override the run() method, this contains the code for the thread. Then create a Thread object, pass your Runnable object to it and call start().





import java.io.*;
import java.util.*;
​
class MyThread implements Runnable{

    // Method to start Thread
    public void run(){
        
        String str = "Thread is Running Successfully";
        System.out.println(str);
    }
​
}
​
public class Geeks{

    public static void main(String[] args){
        
        MyThread g1 = new MyThread();
      
        // initializing Thread Object
        Thread t1 = new Thread(g1);
        
        // Running Thread
        t1.start();
    }
}

Output
Thread is Running Successfully
Explanation:

MyTask implements Runnable.
The run() method defines the task.
A MyTask object is created.
The object is passed to the Thread constructor.
start() creates a new thread and executes run().
Note: Extend Thread when when you don’t need to extend any other class. Implement Runnable when your class already extends another class (preferred in most cases).

Thread vs Runnable
Feature	Extending Thread	Implementing Runnable
Approach	Extend Thread	Implement Runnable
Task and thread	Combined	Separated
Can extend another class?	No	Yes
Reusability	Less flexible	More flexible
Recommended	For simple specialized thread behavior	Preferred for defining a task
Life Cycle of a Thread
During its thread life cycle, a Java thread transitions through several states from creation to termination.

New State
Runnable State
Blocked State
Waiting State
Timed Waiting State
Terminated State
Lifecycle-and-States-of-a-Thread-in-Java-1
Thread Life Cycle
Running Threads
There are two methods used for running Threads in Java:

run() Method: Contains the code for the thread. Calling it directly behaves like a normal method call.
start() Method: Launches a new thread and internally calls run() concurrently.
Example: Using Thread Class and Runnable Interface





// Thread class implementation
class ThreadImpl extends Thread{

    @Override
    public void run(){
        
        // Output: Thread Class Running
        System.out.println("Thread Class Running");
    }
}
​
// Runnable interface implementation
class RunnableThread implements Runnable{

    @Override
    public void run(){
        
        // Output: Runnable Thread Running
        System.out.println("Runnable Thread Running");
    }
}
​
public class Geeks{

    public static void main(String[] args){
        
        // Create and start Thread class thread
        ThreadImpl t1 = new ThreadImpl();
        t1.start();
​
// Create and start Runnable interface thread
RunnableThread r = new RunnableThread();
Thread t2 = new Thread(r);
t2.start();
​
// Wait for both threads to complete
try {
t1.join(); // Wait for t1
t2.join(); // Wait for t2
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}

Output
Thread Class Running
Runnable Thread Running
Note: We use start() to launch a new thread, which then calls the run() method in parallel. If we call run() directly, it works like a normal method call and no new thread is created.

Java Thread Class
The Thread class is used to create and control threads in Java. Each object of this class represents a single thread of execution.

Syntax
public class Thread extends Object implements Runnable

Advantages of Threads
Improved performance: Multiple threads can execute tasks concurrently.
Better resource utilization: Threads share the same memory and resources.
Responsive applications: UI applications remain responsive while performing background tasks.
Suggested Quiz
What will happen if two threads try to acquire two locks in opposite order?


class A {
synchronized void method1(B b) {
b.last();
}
synchronized void last() {}
}

class B {
synchronized void method1(A a) {
a.last();
}
synchronized void last() {}
}

Thread Class and Runnable Interface
In Java, threads can be created either by extending the Thread class or by implementing the Runnable interface. Both approaches have different use cases.

Thread Class

Java Thread Class
A thread is the smallest unit of execution within a program, allowing multiple tasks to run concurrently. In Java, threads help improve performance by enabling parallel execution.

Created using the Thread class or Runnable interface
Starts execution with start() which internally calls run()
Enables concurrent execution of multiple tasks
Note: Every class that is used as a thread must implement Runnable interface and override its run method.

Syntax
public class Thread extends Object implements Runnable

Constructors of Thread Class
Constructor 	Action Performed
Thread()	Allocates a new Thread object.
Thread(Runnable target)	Allocates a new Thread object.
Thread(Runnable target, String name)	Allocates a new Thread object.
Thread(String name)	Allocates a new Thread object.
Thread(ThreadGroup group, Runnable target)	Allocates a new Thread object.
Thread(ThreadGroup group, Runnable target, String name)	Allocates a new Thread object so that it has targeted as its run object, has the specified name as its name, and belongs to the thread group referred to by a group.
Thread(ThreadGroup group, Runnable target, String name, long stackSize)	Allocates a new Thread object so that it has targeted as its run object, has the specified name as its name, and belongs to the thread group referred to by group, and has the specified stack size.
Thread(ThreadGroup group, String name)	Allocates a new Thread object.
Example: Java program to demonstrate usage of Thread class





class MyThread extends Thread
{
// Overriding the run method
@Override
public void run()
{
for (int i = 0; i < 5; i++)
{
System.out.println(Thread.currentThread().getName()
+ " - Count : " + i);

            try {
                // Sleep for 500 milliseconds
                Thread.sleep(500); 
            } 
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
​
// Main Class
public class Geeks
{
public static void main(String[] args)
{
MyThread thread1 = new MyThread();
MyThread thread2 = new MyThread();
​
thread1.setName("Thread 1");
thread2.setName("Thread 2");
​
// Start thread 1
thread1.start();

        // Start thread 2
        thread2.start(); 
    }
}
Output:
Thread 1 - Count : 0
Thread 2 - Count : 0
Thread 1 - Count : 1
Thread 2 - Count : 1
Thread 1 - Count : 2
Thread 2 - Count : 2
Thread 1 - Count : 3
Thread 2 - Count : 3
Thread 2 - Count : 4
Thread 1 - Count : 4

Note: Execution of the thread is not according to the sequence, it can be executed in any sequence Thread 1 then Thread 2 , or Thread 2 then Thread 1.

Methods of Thread Class
Methods	Action Performed
activeCount()	Returns an estimate of the number of active threads in the current thread's thread group and its subgroups
checkAccess()	Determines if the currently running thread has permission to modify this thread
clone()	Throws CloneNotSupportedException as a Thread can not be meaningfully cloned
currentThread()	Returns a reference to the currently executing thread object
dumpStack()	Prints a stack trace of the current thread to the standard error stream
enumerate(Thread[] tarray)	Copies into the specified array every active thread in the current thread's thread group and its subgroups
getAllStackTraces()	Returns a map of stack traces for all live threads
getContextClassLoader()	Returns the context ClassLoader for this Thread
getDefaultUncaughtExceptionHandler()	Returns the default handler invoked when a thread abruptly terminates due to an uncaught exception
getId()	Returns the identifier of this Thread
getName()	Returns this thread's name
getPriority()	Returns this thread's priority
getStackTrace()	Returns an array of stack trace elements representing the stack dump of this thread
getState()	Returns the state of this thread
getThreadGroup()	Returns the thread group to which this thread belongs
getUncaughtExceptionHandler()	Returns the handler invoked when this thread abruptly terminates due to an uncaught exception
holdsLock(Object obj)	Returns true if and only if the current thread holds the monitor lock on the specified object
interrupt()	Interrupts this thread
interrupted()	Tests whether the current thread has been interrupted
isAlive()	Tests if this thread is alive
isDaemon()	Tests if this thread is a daemon thread
isInterrupted()	Tests whether this thread has been interrupted
join()	Waits for this thread to die
join(long millis)	Waits at most millis milliseconds for this thread to die
run()	If this thread was constructed using a separate Runnable run object, then that Runnable object's run method is called; otherwise, this method does nothing and returns
setContextClassLoader(ClassLoader cl)	Sets the context ClassLoader for this Thread
setDaemon(boolean on)	Marks this thread as either a daemon thread or a user thread
setDefaultUncaughtExceptionHandler( Thread.UncaughtExceptionHandler eh)	Set the default handler invoked when a thread abruptly terminates due to an uncaught exception, and no other handler has been defined for that thread
setName(String name)	Changes the name of this thread to be equal to the argument name.
setUncaughtExceptionHandler( Thread.UncaughtExceptionHandler eh)	Set the handler invoked when this thread abruptly terminates due to an uncaught exception
setPriority(int newPriority)	Changes the priority of this thread
sleep(long millis)	Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds, subject to the precision and accuracy of system timers and schedulers
start()	Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread
toString()	Returns a string representation of this thread, including the thread's name, priority, and thread group
yield()	A hint to the scheduler that the current thread is willing to yield its current use of a processor
Methods Inherited from java. lang.Object Class
equals()
finalize()
getClass()
hashCode()
notify()
notifyAll()
toString()
wait()
Suggested Quiz
What will be the output of the following code?


class MyThread extends Thread {
public void run() {
System.out.println("Thread is running");
}

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.run();
    }
}


Runnable Interface
Create a Thread

Java Program to Create a Thread

A thread is a lightweight unit of execution that allows a Java program to perform multiple tasks concurrently. Java provides built-in support for multithreading, enabling efficient use of CPU resources and improved application performance.

Threads share the same memory and resources of a process.
The main thread starts automatically when a Java program begins execution.
New threads can be created to execute tasks independently and concurrently.
Creating Threads in Java
There are multiple ways to create threads in Java:

Thread Class
The Thread class is used to create and manage threads in Java. By extending this class and overriding the run() method, a new thread can execute a task independently.

Extends the Object class and implements the Runnable interface.
start() creates a new thread and invokes the run() method.
Suitable for simple thread creation tasks.
The start() method starts a new thread and moves it from the New state to the Runnable state. When scheduled by the JVM, it automatically executes the run() method.

Syntax:

class MyThread extends Thread {
public void run() {
// task to perform
}

}

MyThread t = new MyThread();
t.start();

Implementation:





// Extending Thread in Class
import java.io.*;
​
// Class inheriting Thread class
class MyThread extends Thread
{
// Overriding the run method
@Override
public void run(){
System.out.print("Welcome to GeeksforGeeks.");
}
}
​
class Geeks
{
public static void main(String[] args)
{
// Creating thread
MyThread t1 = new MyThread();

        // Starting thread
        t1.start(); 
    }
}

Output
Welcome to GeeksforGeeks.
Runnable Interface
The Runnable interface is used to define a task that can be executed by a thread. It contains a single method, run(), which holds the code to be executed.

Contains only one method: run().
Separates task logic from thread creation.
Supports multiple inheritance since it is an interface.
Note: A class implements Runnable and the task runs when a thread executes its run() method.

Syntax:

class MyTask implements Runnable {
public void run() {
// task to perform
}
}

Thread t = new Thread(new MyTask());

t.start();

Implementation:





// Implementing Runnable Interface
import java.io.*;
​
// Class inheriting Runnable interface
class RunnableClass implements Runnable
{
// Override run method
@Override
public void run()
{
System.out.println("Inside run method");
}
}
​
class Geeks
{
public static void main(String args[])
{
// Create an object of Runnable target
RunnableClass gfg = new RunnableClass();
​
// Pass the runnable reference to Thread
Thread t = new Thread( gfg , "gfg");
​
// Start the thread
t.start();
​
// Get the name of the thread
System.out.println(t.getName());

          System.out.println(t.currentThread().getName());
    }
}

Output
gfg
main
Inside run method
Using Lambda Expressions
Lambda expressions provide a concise way to create and run threads, especially when the task is small and simple.

Reduces boilerplate code.
Best for short and simple tasks.
Works with the Runnable interface.
Note: Lambda expressions allow defining the thread task directly without creating a separate class.

Syntax:

Thread t = new Thread(() -> {
// task to perform
});
t.start();

Implementation:





// Using Lambda Method to Create Thread
import java.io.*;
​
class Geeks
{
public static void main (String[] args)
{
// Lambda Thread Created
Thread thread1 = new Thread(() -> {

            // Operations Performed for thread1
            System.out.println("Lambda Thread running");
        });
      
        // Running the Thread
        thread1.start(); 
    }
}

Output
Lambda Thread running
Using ExecutorService (for Managing Thread Pools)
ExecutorService is a framework that manages and executes threads through a thread pool. It provides a more efficient and scalable approach to multithreading than creating threads manually.

Uses a pool of reusable threads.
Simplifies thread management.
Suitable for executing multiple tasks concurrently.
Note: ExecutorService manages thread creation and execution automatically, improving performance and resource usage.

Syntax:

import java.util.concurrent.*;
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.execute(() -> {
// task to perform
});
executor.shutdown();

Implementation:





// Using ExecutorService
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
​
public class Geeks
{
public static void main(String[] args)
{

        // Create a thread pool with 2 threads
        ExecutorService threads = Executors.newFixedThreadPool(2); 
​
// Submitting Threads as Runnable

        threads.submit(() -> {
            System.out.println("Task 1 is running in " + Thread.currentThread().getName());
        });
​
threads.submit(() -> {
System.out.println("Task 2 is running in " + Thread.currentThread().getName());
});
​
// Shutdown the threads/executor
threads.shutdown();
}
}

Output
Task 1 is running in pool-1-thread-1
Task 2 is running in pool-1-thread-2

Thread Lifecycle
A thread passes through different states like New, Runnable, Running, Waiting and Terminated. The lifecycle is managed by the JVM and thread scheduler.

Lifecycle and States

Lifecycle and States of a Thread in Java

The lifecycle of a thread in Java describes the different states a thread goes through from its creation until its execution is completed.

A thread moves between different states during its lifetime.
Thread methods such as start(), sleep(), wait(), and join() can cause state transitions.
Understanding thread states helps in debugging and managing multithreaded applications.
Thread Lifecycle
A thread generally moves through the following states:

Lifecycle-and-States-of-a-Thread-in-Java

1. New
   A thread is in the NEW state when its Thread object has been created but the start() method has not yet been called.

public static final Thread.State NEW

2. Runnable
   Thread state for a runnable thread. A thread in the runnable state is executing in the Java virtual machine but it may be waiting for other resources from the operating system such as a processor.

public static final Thread.State RUNNABLE

3. Blocked
   A thread is in the blocked state when it is waiting to acquire a lock that is currently held by another thread.

public static final Thread.State BLOCKED

4. Waiting
   Thread state for a waiting thread. A thread is in the waiting state due to calling one of the following methods:

Object.wait with no timeout
Thread.join with no timeout
LockSupport.park
public static final Thread.State WAITING

5. Timed Waiting
   Thread state for a waiting thread with a specified waiting time. A thread is in the timed waiting state due to calling one of the following methods with a specified positive waiting time:

Thread.sleep
Object.wait with timeout
Thread.join with timeout
LockSupport.parkNanos
LockSupport.parkUntil
public static final Thread.State TIMED_WAITING

6. Terminated
   Thread state for a terminated thread. The thread has completed execution.

public static final Thread.State TERMINATED

Important Thread Methods and States
Method	Effect
start()	Starts a new thread and moves it from NEW toward RUNNABLE
sleep()	Puts the current thread into TIMED_WAITING
wait()	Releases the monitor and puts the thread into WAITING
join()	Makes one thread wait for another thread to finish
interrupt()	Requests interruption; the resulting state depends on what the thread is doing
getState()	Returns the current thread state
Note: Calling run() directly does not start a new thread. It executes run() like a normal method call in the current thread. Use start() to create a new thread of execution.

WAITING Vs TIMED_WAITING
WAITING	TIMED_WAITING
Waits indefinitely	Waits for a specified time
wait()	sleep()
join()	join(timeout)
LockSupport.park()	wait(timeout)
No timeout is specified	Timeout is specified
Example: Demonstrate thread states using a ticket booking scenario


class TicketBooking implements Runnable {
@Override
public void run() {

        try {
            
            // Timed waiting
            Thread.sleep(200); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of bookingThread while mainThread is waiting: " +
                TicketSystem.mainThread.getState());

        try {
            
            // Another timed waiting
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TicketSystem implements Runnable {
public static Thread mainThread;
public static TicketSystem ticketSystem;

    @Override
    public void run() {
        TicketBooking booking = new TicketBooking();
        Thread bookingThread = new Thread(booking);

        System.out.println("State after creating bookingThread: " + bookingThread.getState());

        bookingThread.start();
        System.out.println("State after starting bookingThread: " + bookingThread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after sleeping bookingThread: " + bookingThread.getState());

        try {
            
            // Moves mainThread to waiting state
            bookingThread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after bookingThread finishes: " + bookingThread.getState());
    }

    public static void main(String[] args) {
        ticketSystem = new TicketSystem();
        mainThread = new Thread(ticketSystem);

        System.out.println("State after creating mainThread: " + mainThread.getState());

        mainThread.start();
        System.out.println("State after starting mainThread: " + mainThread.getState());
    }
}
Output:

Output
Explanation:

When a new thread is created, the thread is in the NEW state. When the start() method is called on a thread, the thread scheduler moves it to the Runnable state.
Whenever the join() method is called on a thread instance, the main thread goes to Waiting for the booking thread to complete.
Once the thread's run method completes, its state becomes Terminated.
Advantages of Understanding Thread Lifecycle
Helps understand how threads behave during execution.
Makes it easier to manage multiple threads efficiently.
Helps identify why a thread is waiting or blocked.
Makes debugging multithreaded applications easier.
Helps prevent unnecessary resource usage.
Improves understanding of thread synchronization.
Helps choose the appropriate thread method for a particular task.
Makes it easier to identify and resolve thread-related issues.


Thread Scheduler
Thread Scheduling

Thread scheduling refers to the mechanism that decides which thread will run and access system resources at a particular time. It ensures efficient CPU utilization and smooth execution of multiple threads. It operates at two levels.

The first level involves mapping user-level threads (ULT) to kernel-level threads (KLT) using lightweight processes (LWP), usually handled by the application or runtime system.
The second level involves the operating system scheduler, which manages kernel-level threads and assigns CPU time to perform various system tasks.
Thread scheduling is influenced by factors such as thread priority, scheduling algorithms, and system load. It also helps improve responsiveness, fairness, and overall system performance in a multithreaded environment.

Lightweight Process (LWP)
Light-weight process are threads in the user space that acts as an interface for the ULT to access the physical CPU resources. Thread library schedules which thread of a process to run on which LWP and how long. The number of LWPs created by the thread library depends on the type of application.


If an LWP is blocked during an I/O operation, it cannot execute its thread. To run other ULTs, the thread library creates and schedules another LWP.
Therefore, in I/O-bound applications, the number of LWPs is equal to the number of ULTs.
In CPU-bound applications, the number of LWPs depends on the application requirements. It is not necessary to have one LWP for each ULT in CPU-bound cases.
Each LWP is associated with a separate kernel-level thread (KLT).
Lightweight Process

In real-time, the first boundary of thread scheduling is beyond specifying the scheduling policy and the priority. It requires two controls to be specified for the User level threads:

Contention scope
Allocation domain
Contention Scope
The word contention here refers to the competition or fight among the User level threads to access the kernel resources. Thus, this control defines the extent to which contention takes place. It is defined by the application developer using the thread library. It is classified as-

Process Contention Scope (PCS) :
The contention takes place among threads within a same process. The thread library schedules the high-prioritized PCS thread to access the resources via available LWPs (priority as specified by the application developer during thread creation).
System Contention Scope (SCS) :
The contention takes place among all threads in the system. In this case, every SCS thread is associated to each LWP by the thread library and are scheduled by the system scheduler to access the kernel resources.

In LINUX and UNIX operating systems, the POSIX Pthread library provides a function Pthread_attr_setscope to define the type of contention scope for a thread during its creation.
int Pthread_attr_setscope(pthread_attr_t *attr, int scope)
The first parameter denotes to which thread within the process the scope is defined.
The second parameter defines the scope of contention for the thread pointed. It takes two values.


PTHREAD_SCOPE_SYSTEM
PTHREAD_SCOPE_PROCESS
If the scope value specified is not supported by the system, then the function returns ENOTSUP.

Allocation Domain
The allocation domain is a set of one or more resources for which a thread is competing. In a multicore system, there may be one or more allocation domains where each consists of one or more cores.

One ULT can be a part of one or more allocation domain.
Due to this high complexity in dealing with hardware and software architectural interfaces, this control is not specified.
The multicore system will have an interface that affects the allocation domain of a thread.
Consider an operating system with three processes (P1, P2, P3) and 10 user-level threads (T1–T10) in a single allocation domain. The total CPU resources are shared among the processes, and allocation depends on contention scope, scheduling policy, thread priority, and both the thread library and system scheduler.

Kernel Space
In this case, the contention for allocation domain takes place as follows:

Process P1
PCS threads (T1, T2, T3) of process P1 compete among themselves and may share LWPs. The thread library uses preemptive priority scheduling, allowing higher-priority threads to preempt lower-priority ones within the same process. However, threads cannot preempt threads from other processes. If priorities are equal, the system scheduler decides the allocation of ULTs to LWPs.

Process P2
SCS threads (T4, T5) of process P2 compete with process P1 as a whole and with SCS threads (T8, T9, T10) and PCS threads (T6, T7) of process P3. The system scheduler allocates CPU resources by treating each as a separate entity. In this case, the thread library does not control the scheduling of ULTs to kernel resources.

Process P3
In a combination of PCS and SCS threads, if the system scheduler allocates 50% CPU to process P3, it may split it into 25% for PCS threads (T6, T7) and 25% for SCS threads (T8, T9, T10). PCS threads are scheduled by the thread library based on priority, while SCS threads are scheduled by the system scheduler and access kernel resources through separate LWPs and KLTs.

Note:

For every system call to access the kernel resources, a Kernel Level thread is created
and associated to separate LWP by the system scheduler.
Number of Kernel Level Threads = Total Number of LWP
Total Number of LWP = Number of LWP for SCS + Number of LWP for PCS
Number of LWP for SCS = Number of SCS threads
Number of LWP for PCS = Depends on application developer
Here,

Number of SCS threads = 5
Number of LWP for PCS = 3
Number of SCS threads = 5
Number of LWP for SCS = 5
Total Number of LWP   = 8 (=5+3)
Number of Kernel Level Threads = 8
Advantages of PCS over SCS
If all threads are PCS, context switching, synchronization, and scheduling occur in user space, reducing system calls and improving performance.
PCS is cheaper than SCS.
PCS threads share one or more LWPs, while each SCS thread is mapped to a separate LWP and KLT.
The number of LWPs and KLTs increases with SCS threads, adding kernel complexity and limiting their number.
Multiple allocation domains make scheduling and synchronization more complex, especially when an SCS thread belongs to multiple domains.
The second boundary of thread scheduling involves CPU scheduling by the system scheduler. The scheduler considers each kernel-level thread as a separate process and provides access to the kernel resources.


Thread Methods
Java provides built-in methods like start(), run(), sleep() and join() to manage thread execution and control its behavior.

start() Method

What does start() function do in multithreading in Java

In Java, threads enable concurrent execution of multiple tasks within a program. They help improve performance and responsiveness in applications.

Threads can be created by extending the Thread class or implementing the Runnable interface, both requiring the run() method.
Use the start() method to begin execution, as it internally calls run() and creates a new thread.
start() Method
The purpose of start() is to create a separate call stack for the thread. A separate call stack is created by it, and then run() is called by JVM. The main purpose of the start() method is to create a separate call stack for a new thread. When start() is invoked:

JVM creates a new thread.
A separate call stack is allocated for that thread.
The JVM internally calls the run() method.
Because of this, multiple threads can execute simultaneously.


Example: Java code to see that all threads are pushed on same stack if we use run() instead of start().


class ThreadTest extends Thread
{
public void run()
{
try
{
// Displaying the thread that is running
System.out.println ("Thread " +
Thread.currentThread().getId() +
" is running");

    }
    catch (Exception e)
    {
      // Throwing an exception
      System.out.println ("Exception is caught");
    }
}
}

// Main Class
public class Main
{
public static void main(String[] args)
{
int n = 8;
for (int i=0; i<n; i++)
{
ThreadTest object = new ThreadTest();

      // start() is replaced with run() for
      // seeing the purpose of start
      object.run();
    }
}
}
Output:

Thread 1 is running
Thread 1 is running
Thread 1 is running
Thread 1 is running
Thread 1 is running
Thread 1 is running
Thread 1 is running
Thread 1 is running

Explanation: Calling run() directly executes the method in the main thread, so no new thread is created and the same thread ID is printed every time. Since there is no multithreading, all 8 executions run sequentially in a single call stack.


suspend() Method

Temporarily Stop a Thread in Java

In Java, sometimes a thread needs to pause its execution for a specific period of time before continuing its work. This can be done using the Thread.sleep() method, which temporarily suspends the current thread.

The time is provided in milliseconds.
It throws an InterruptedException, so it must be handled using try-catch.
Note: suspend() method is deprecated in the latest Java version.

Syntax:

public final void suspend()


class GFG extends Thread {
public void run() {
for (int i = 1; i < 5; i++) {
try {
// thread to sleep for 5 milliseconds
Thread.sleep(5);
System.out.println("Currently running - "
+ Thread.currentThread().getName());
} catch (InterruptedException e) {
System.out.println(e);
}
System.out.println(i);
}
}

    public static void main(String args[]) {
        // creating three threads
        GFG t1 = new GFG();
        GFG t2 = new GFG();
        GFG t3 = new GFG();

        // start threads
        t1.start();
        t2.start();
        t3.start(); // removed suspend()
    }
}
Output

Thread 2 is suspended
Explanation: Three threads (t1, t2, t3) are created and started, so they run concurrently and execute the run() method independently. Each thread prints its name and numbers 1–4 with a small delay, so the output appears interleaved and in random order due to multithreading.

Note: Thread t2 can be resumed by resume() method.

stop() Method

Killing threads in Java

A Thread in Java stops automatically after run() completes, but sometimes we need to stop it manually. Deprecated methods like stop(), suspend(), and resume() are unsafe, so modern approaches provide safer ways to control thread termination.

Proper thread termination helps avoid memory leaks and deadlocks
Modern methods improve stability and reliability of applications
Modern ways to stop thread
1. Using Boolean Flag
   A boolean flag can be used to control thread execution, but when the flag is shared between multiple threads it should be declared volatile (or protected using synchronization). Otherwise, visibility issues may occur and the thread may not see updates made by another thread.

Simple and easy way to control thread lifecycle
Avoids unsafe thread termination
Suitable when thread is doing continuous work in loop




class MyThread implements Runnable {
​
// Volatile flag to stop the thread safely
private volatile boolean exit;
​
private String name;
Thread t;
​
MyThread(String threadName) {
name = threadName;
t = new Thread(this, name);
System.out.println("New thread: " + t);
exit = false;
​
// Start the thread
t.start();
}
​
// Thread execution starts here
public void run() {
int i = 0;
​
while (!exit) {
System.out.println(name + ": " + i);
i++;
​
try {
Thread.sleep(100);
} catch (InterruptedException e) {
System.out.println("Caught: " + e);
}
}
​
System.out.println(name + " Stopped.");
}
​
// Method to stop the thread
public void stopThread() {
exit = true;
}
}
​
// Main class
public class Main {
​
public static void main(String[] args) {
​
// Create two threads
MyThread t1 = new MyThread("First Thread");
MyThread t2 = new MyThread("Second Thread");
​
try {
Thread.sleep(500);
​
// Stop both threads
t1.stopThread();
t2.stopThread();
​
Thread.sleep(500);
} catch (InterruptedException e) {
System.out.println("Caught: " + e);
}
​
System.out.println("Exiting the main thread");
}
}

Output
New thread: Thread[First  thread, 5, main]
New thread: Thread[Second thread, 5, main]
First  thread: 0
Second thread: 0
First  thread: 1
Second thread: 1
First  thread: 2
Second thread: 2
First  thread: 3
Second thread: 3
First  thread: 4
Second thread: 4
First  thread: 5
Second thread Stopped.
First  thread Stopped.
Exiting the main Thread
Explanation: Output can be variable everytime. By using a flag we can stop a thread whenever we want to and we can prevent unwanted run-time errors.

2. Using Volatile Boolean Flag
   A volatile boolean flag is used when multiple threads access the same variable. Without volatile, threads may cache the variable value locally, causing visibility issues. Using volatile ensures that changes made by one thread are immediately visible to others.

Ensures visibility of changes across threads
Prevents infinite loops caused by cached values
Makes multi-threaded code more reliable.

public class Main {

    // static used here
    // because a non-static variable
    // cannot be referenced
    // from a static context

    // exit variable to stop both
    // the main and inside threads
    static boolean exit = false;

    public static void main(String[] args)
    {
        System.out.println("started main thread..");

        // a thread inside main thread
        new Thread() {
            public void run()
            {
                System.out.println("started inside thread..");

                // inside thread caches the value of exit,
                // so changes made to exit are not visible here
                while (!exit) // will run infinitely
                {
                }

                // this will not be printed.
                System.out.println("exiting inside thread..");
            }
        }.start();

        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            System.out.println("Caught :" + e);
        }

        // so that we can stop the threads
        exit = true;
        System.out.println("exiting main thread..");
    }
}
Runtime Errors:

Time Limit Exceeded

Output:

started main thread.. started inside thread.. exiting main thread..

Explanation : The inside thread does not see the updated value of exit due to a visibility problem, so it keeps looping infinitely while the main thread exits.


The code runs into an infinite loop because the inside thread cannot see updates made to the exit variable. This happens due to local caching. Using volatile ensures the updated value is visible to all threads and prevents this issue.





public class Main {
​
// static used here because
// a non-static variable cannot be referenced
// from a static context
​
// exit variable to stop both
// the main and inside threads
static volatile boolean exit = false;
public static void main(String[] args)
{
​
System.out.println("started main thread..");
​
// a thread inside main thread
new Thread() {
public void run()
{
​
// changes made to exit
// in main thread are visible here
System.out.println("started inside thread..");
​
// will not run infinitely
while (!exit) {
}
​
// this will be printed
System.out.println("exiting inside thread..");
}
}.start();
​
try {
Thread.sleep(500);
}
catch (InterruptedException e) {
System.out.println("Caught :" + e);
}
​
// so that we can stop the threads
exit = true;
System.out.println("exiting main thread..");
}
}

Output
started main thread..
started inside thread..
exiting main thread..
exiting inside thread..
Explanation: The volatile keyword ensures that changes to exit made by the main thread are visible to the inside thread, allowing it to exit the loop and terminate properly.

Note: Using volatile prevents infinite loops by ensuring changes are visible to all threads, making the code thread-safe.

Note: Any variable shared between threads and modified by one thread should be declared volatile or accessed through synchronized blocks to guarantee visibility. A plain boolean flag may not work reliably in all JVM implementations.

3. Using Thread.interrupt()
   The interrupt() method is used to signal a thread that it should stop its execution. It sets an internal interrupt flag, which the thread can check and handle appropriately. It is consider the best way for stopping the thread.

Sets interrupt flag instead of forcing stop
Works well with blocking methods like sleep()




class MyThread implements Runnable {
​
Thread t;
​
MyThread()
{
t = new Thread(this);
System.out.println("New thread: " + t);
t.start(); // Starting the thread
}
​
// execution of thread starts from run() method
public void run()
{
while (!Thread.interrupted()) {
System.out.println("Thread is running");
}
System.out.println("Thread has stopped.");
}
}
​
// Main class
public class Main {
public static void main(String args[])
{
// creating objects t1 of MyThread
MyThread t1 = new MyThread();
​
try {
Thread.sleep(1);
​
// t1 is an object of MyThread
// which has an object t
// which is of type Thread
t1.t.interrupt();
​
Thread.sleep(5);
}
catch (InterruptedException e) {
System.out.println("Caught:" + e);
}
System.out.println("Exiting the main Thread");
}
}

Output
New thread: Thread[Thread-0, 5, main]
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread is running
Thread has stopped.
Exiting the main Thread
Explanation :The thread runs in a loop printing "Thread is running" until it is interrupted. When interrupt() is called from the main method, the loop stops, the thread ends, and the main thread prints "Exiting the main Thread".

Note: The output may vary every time.

sleep() Method

Java Thread.sleep() Method

The Thread.sleep() method in Java is used to pause the execution of the currently running thread for a specified amount of time. After the sleep duration ends, the thread becomes runnable again and continues execution based on thread scheduling.

Throws InterruptedException if another thread interrupts during sleep.
Actual sleep duration may vary based on system load; higher load increases sleep time.

public class SleepDemo {
public static void main(String[] args) throws InterruptedException {
for (int i = 0; i < 3; i++) {
System.out.print(i + " ");
Thread.sleep(1000);
}
}
}
Output:

0 1 2

Explanation: The main thread prints numbers from 0 to 2, and after each print, Thread.sleep(1000) pauses execution for 1 second. This results in a visible delay between each output.

Syntax
There are 2 variations of the sleep() method in Java Thread. These are:

public static void sleep(long millis)
public static void sleep(long millis, int nanos)

Parameters:

millis: Duration of time in milliseconds for which thread will sleep
nanos: This is the additional time in nanoseconds for which we want the thread to sleep. It ranges from 0 to 999999..
Common Examples of Thread.sleep()
Example 1: Using Thread.sleep() Method for Main Thread


import java.io.*;
import java.lang.Thread;

class Geeks
{
public static void main(String[] args)
{
// we use throws keyword followed by exception
// name for throwing the exception
try {
for (int i = 0; i < 5; i++) {

                // sleep the main thread for 1 sec
                // for every loop runs
                Thread.sleep(1000);
              
                System.out.print(i+" ");
            }
        }
        catch (Exception e) {
            // catching the exception
            System.out.println(e);
        }
    }
}
Output:

0 1 2 3 4
Explanation: The main thread runs the loop and prints numbers from 0 to 2, pausing for 1 second after each print using Thread.sleep(1000). After the pause, the thread resumes execution and continues the loop.

Example 2: Using Thread.sleep() method for Custom thread


import java.lang.Thread;

// Class extending the Thread Class
class MyThread extends Thread
{
// Overriding the run method
@Override
public void run()
{
// use throws keyword followed by exception
// name for throwing the exception
try {
for (int i = 0; i < 5; i++) {

                // method will sleep the thread
                Thread.sleep(1000);
              
                System.out.print(i+" ");
            }
        }
        catch (Exception e) {
            // catching the exception
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        // created thread
        MyThread obj = new MyThread();
        obj.start();
    }
}
Output:

0 1 2 3 4
Explanation: MyThread extends the Thread class and overrides the run() method to print numbers from 0 to 4, pausing for 1 second in each iteration using Thread.sleep(1000). The sleep call is wrapped in a try-catch block to handle InterruptedException, after which the thread resumes execution.

Example 3: IllegalArgumentException when sleep time is Negative





import java.lang.Thread;
​
class Geeks
{
public static void main(String[] args)
{
// Use throws keyword followed by exception
// name for throwing the exception
try {
for (int i = 0; i < 5; i++) {

                // this will throw the
                // IllegalArgumentException
                Thread.sleep(-100);
              
                // Printing the value of the variable
                System.out.println(i);
            }
        }
        catch (Exception e) {
            // Catching the exception
            System.out.println(e);
        }
    }
}

Output
java.lang.IllegalArgumentException: timeout value is negative
Explanation: Passing a negative value to Thread.sleep() is invalid, so Java immediately throws an IllegalArgumentException. This ensures that the sleep duration is always non-negative.

join() Method

Joining Threads in Java

In Java, threads allow concurrent execution of multiple tasks, improving performance and responsiveness. Sometimes, one thread needs to wait for another thread to finish its execution. java.lang. Thread class provides the join() method which allows one thread to wait until another thread completes its execution.

Used to achieved using the join() method of the Thread class.
When multiple threads use join(), its overloaded versions allow specifying a waiting time
join() Method
The join() method is used to pause the execution of the current thread until the thread on which it is called completes.

The current thread goes into a waiting state
It waits until the target thread finishes execution
Execution resumes after the thread is terminated
Helps in maintaining proper sequence between threads
Syntax:

public final void join()

Overloaded Versions of join() Method
1. join()
   The join() method is used to make the current thread wait until the target thread completely finishes its execution. Waits until the thread completely finishes

Syntax:

public final void join()

2. join(long millis)
   It will put the current thread on wait until the thread on which it is called is dead or wait for the specified time (milliseconds).Waits for a specified time or until the thread finishes

Syntax:

public final synchronized void join(long millis)

3. join(long millis, int nanos)
   It will put the current thread on wait until the thread on which it is called is dead or wait for the specified time (milliseconds + nanos). Waits for a specified time (milliseconds + nanoseconds) or until completion

Syntax:

public final synchronized void join(long millis, int nanos)

Example: Java program to explain the concept of joining a thread.


import java.io.*;

// Creating thread by creating the
// objects of that class
class ThreadJoining extends Thread
{
@Override
public void run()
{
for (int i = 0; i < 2; i++)
{
try
{
Thread.sleep(500);
System.out.println("Current Thread: "
+ Thread.currentThread().getName());
}

            catch(Exception ex)
            {
                System.out.println("Exception has" +
                                " been caught" + ex);
            }
            System.out.println(i);
        }
    }
}

class GFG
{
public static void main (String[] args)
{

        // creating two threads
        ThreadJoining t1 = new ThreadJoining();
        ThreadJoining t2 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        // thread t1 starts
        t1.start();

        // starts second thread after when
        // first thread t1 has died.
        try
        {
            System.out.println("Current Thread: "
                  + Thread.currentThread().getName());
            t1.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has " +
                                "been caught" + ex);
        }

        // t2 starts
        t2.start();

        // starts t3 after when thread t2 has died.
        try
        {
            System.out.println("Current Thread: "
                 + Thread.currentThread().getName());
            t2.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has been" +
                                    " caught" + ex);
        }
        
        // t3 starts
        t3.start();
        
        // After t2 has dead, t3 starts
        try
        {
            System.out.println("Current Thread: "
                 + Thread.currentThread().getName());
            t3.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has been" +
                                    " caught" + ex);
        }
    }
}

// This code is modified by Susobhan Akhuli
Output:

Current Thread: main
Current Thread: Thread-0
0
Current Thread: Thread-0
1
Current Thread: main
Current Thread: Thread-1
0
Current Thread: Thread-1
1
Current Thread: main
Current Thread: Thread-2
0
Current Thread: Thread-2
1
In the above example we can see clearly second thread t2 starts after first thread t1 has died and t3 will start its execution after second thread t2 has died

Thread Priorities
Threads can be assigned priorities to influence scheduling decisions. Higher priority threads are given preference by the thread scheduler.

Introduction

Java Thread Priority in Multithreading

Java supports multithreading, where multiple threads run concurrently and the Thread Scheduler decides their execution order. Each thread is assigned a priority (1–10) that influences scheduling but does not guarantee execution order.

Changing priority does not guarantee faster execution or immediate scheduling
Higher-priority threads are generally preferred by the scheduler
Actual execution order depends on the JVM and underlying OS




class SimpleThread extends Thread {
public void run() {
System.out.println(getName() + " is running with priority " + getPriority());
}
}
​
public class GFG {
public static void main(String[] args) {
SimpleThread t1 = new SimpleThread();
SimpleThread t2 = new SimpleThread();
​
t1.setName("HighPriorityThread");
t2.setName("LowPriorityThread");
​
t1.setPriority(Thread.MAX_PRIORITY); // 10
t2.setPriority(Thread.MIN_PRIORITY); // 1
​
t1.start();
t2.start();
}
}

Output
LowPriorityThread is running with priority 1
HighPriorityThread is running with priority 10
Explanation:

Two threads are created: HighPriorityThread and LowPriorityThread.
HighPriorityThread is assigned maximum priority (10), and LowPriorityThread gets minimum priority (1).
When start() is called, both threads run concurrently.
Higher-priority threads may get more CPU time, but the actual execution order is not guaranteed because it depends on the JVM and the OS scheduler.
Thread Priority Constants
java_thread_priority
Java provides three constant values in the Thread class:

Thread.MIN_PRIORITY (1): Lowest possible priority for a thread.
Thread.NORM_PRIORITY (5): Default priority assigned to a thread.
Thread.MAX_PRIORITY (10): Highest possible priority for a thread.
Setting and Getting Thread Priority
We can use the following methods of the Thread class to manage thread priority:

setPriority(int newPriority): This method is used to set the priority of a thread.
getPriority(): This method is used to returns the current priority of the thread.




class MyThread extends Thread {
​
public MyThread(String name){
super(name);

    }
​
public void run()
{
​
System.out.println(
Thread.currentThread().getName()
+ " with priority "
+ Thread.currentThread().getPriority());
}
}
​
public class Geeks{
public static void main(String[] args){

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");
​
// Setting thread priorities
t1.setPriority(Thread.MIN_PRIORITY); // 1
t2.setPriority(Thread.NORM_PRIORITY); // 5
t3.setPriority(Thread.MAX_PRIORITY); // 10
​
// Start threads
t1.start();
t2.start();
t3.start();
}
}

Output
Thread-2 with priority 5
Thread-1 with priority 1
Thread-3 with priority 10
Explanation: The program creates three threads, assigns them different priorities (1, 5, and 10), and starts them using start(). Each thread runs concurrently and prints its name and priority, but the execution order is not fixed and depends on the scheduler.

Note: The output order may vary because thread scheduling depends on the JVM and the underlying operating system.

If multiple threads have the same priority, their execution order is decided by the thread scheduler. The example below demonstrates this, followed by an explanation of the output for better conceptual and practical understanding.





class MyThread extends Thread{

    public void run(){
        
        System.out.println(getName()
                           + " is running with priority "
                           + getPriority());
    }
​
public static void main(String[] args){

        // Set main thread priority
        Thread.currentThread().setPriority(5);
​
// Create two threads
MyThread t1 = new MyThread();
MyThread t2 = new MyThread();
​
// Both threads inherit main thread priority (5)
System.out.println("t1 priority: "
+ t1.getPriority());
System.out.println("t2 priority: "
+ t2.getPriority());
​
// Start threads
t1.start();
t2.start();
}
}

Output
t1 priority: 5
t2 priority: 5
Thread-1 is running with priority 5
Thread-0 is running with priority 5
Explanation: The main thread sets its priority to 5, and both t1 and t2 inherit this priority when created. When start() is called, both threads run concurrently and print their details, and since they have the same priority, their execution order depends on the OS scheduler.

setName()

Java Naming a Thread and Fetching Name of Current Thread

In Java, a thread is a lightweight process, and assigning meaningful names to threads improves readability and debugging. By default, threads are named as Thread-0, Thread-1, etc., but we can customize these names.

Thread names help in debugging and tracking execution
Names can be set during creation or later using methods
Improves code clarity in multithreaded applications
Methods to Set the Thread Name
There are two ways by which we can set the name either be it directly or indirectly which we will be peeking through.

1. Using Constructor
   It is a direct method of naming threads in Java, each thread has a name that is: Thread-0, Thread-1, Thread-2,....so on. So, let us check the direct method to set the name of the Thread.


Example: Setting the thread name at the time of creation and also bypassing the thread's name as an argument.





class MyThread extends Thread {
​
// Parameterized constructor
MyThread(String name){

        // Call to constructor of the Thread class
        // as super keyword refers to parent class
        super(name);
    }
​
// run() method for thread
@Override
public void run(){
System.out.println("Thread is running..");
}
}
​
// Driver Class
class Geeks
{
public static void main(String[] args)
{
// Creating two threads
MyThread t1 = new MyThread("geek1");
MyThread t2 = new MyThread("geek2");
​
// Getting the names of Threads
System.out.println("Thread 1: " + t1.getName());
System.out.println("Thread 2: " + t2.getName());
​
// Starting threads using start() method
t1.start();
t2.start();
}
}

Output
Thread 1: geek1
Thread 2: geek2
Thread is running..
Thread is running..
2. Using setName() method of Thread class
   We can set(change) the thread's name by calling the setName method on that thread object. It will change the name of a thread.

Syntax:

public final void setName(String name)

Parameter: A string that specifies the thread name





class ThreadNaming extends Thread {
​
// override the run method
@Override
public void run() {
System.out.println("Thread is running..");
}
}
​
// Main class
class Geeks
{
public static void main(String[] args)
{
// Creating Threads
ThreadNaming t1 = new ThreadNaming();
ThreadNaming t2 = new ThreadNaming();
​
// Fetching the above created threads names
// using getName() method
System.out.println("Thread 1: " + t1.getName());
System.out.println("Thread 2: " + t2.getName());
​
// Starting threads using start() method
t1.start();
t2.start();
​
// Now changing the name of threads
t1.setName("geeksforgeeks");
t2.setName("geeksquiz");
​
// Again getting the new names of threads
System.out.println("Thread names after changing"
+ " the thread names");
​
// Printing the above names
System.out.println("New Thread 1 name:  " + t1.getName());
System.out.println("New Thread 2 name: " + t2.getName());
}
}

Output
Thread 1: Thread-0
Thread 2: Thread-1
Thread is running..
Thread names after changing the thread names
New Thread 1 name:  geeksforgeeks
New Thread 2 name: geeksquiz
Thread is running..
How to Fetch the Name of the Current Thread?
Now let us dwell on fetching the name of the current thread. We can fetch the current thread name at the time of creating the thread and bypassing the thread’s name as an argument.

Syntax:

public static Thread currentThread()

Package: java.lang.Thread
Return Type: It returns a reference to the currently executing thread.




import java.io.*;
​
// Helper class extending to Thread class
class ThreadNaming extends Thread {
​
// override run method for the thread
@Override
public void run()
{
System.out.println("Fetching current thread name.");
​
// Getting the current thread name
// using getname() method
System.out.println(Thread.currentThread().getName());
}
}
​
// Driver Class
class Geeks
{
public static void main(String[] args)
{
// Creating two threads inside main() method
ThreadNaming t1 = new ThreadNaming();
ThreadNaming t2 = new ThreadNaming();
​
// Starting threads using start() method which
// automatically calls run() method
t1.start();
t2.start();
}
}

Output
Fetching current thread name.
Thread-0
Fetching current thread name.
Thread-1

Thread Naming (Java)
Suggested Quiz
What will be the output of the following code?


class MyThread extends Thread {
public void run() {
System.out.println(Thread.currentThread().getName());
}

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("CustomThread");
        t1.start();
    }
}

getName()

Method Class | getName() Method in Java

The getName() method of the Thread class is used to retrieve the name of a thread. It helps in identifying threads during execution, especially useful for debugging and logging in multithreaded applications.

Returns the name of the current thread
Commonly used for debugging and logging
Default thread names are like Thread-0, Thread-1, etc.




class MyThread extends Thread {
public void run() {
System.out.println("Thread name: " + getName());
}
​
public static void main(String[] args) {
MyThread t1 = new MyThread();
t1.start();
}
}

Output
Thread name: Thread-0
Explanation: The getName() method fetches and prints the name of the thread. If no custom name is set, it displays the default thread name.

Syntax
public final String getName()

Example: Program to check whether class contains a certain specific method.





import java.lang.reflect.Method;
​
public class GFG {
​
// Main method
public static void main(String[] args)
{
​
String checkMethod = "method1";
​
try {
// create class object
Class classobj = democlass.class;
​
// get list of methods
Method[] methods = classobj.getMethods();
​
// get the name of every method present in the list
for (Method method : methods) {
​
String MethodName = method.getName();
if (MethodName.equals(checkMethod)) {
System.out.println("Class Object Contains"
+ " Method whose name is "
+ MethodName);
}
}
}
catch (Exception e) {
e.printStackTrace();
}
}
}
// a simple class
class democlass {
​
public int method1()
{
return 24;
}
​
public String method2()
{
return "Happy hours";
}
​
public void method3()
{
System.out.println("Happy hours");
}
}

Output
Class Object Contains Method whose name is method1
Explanation: Above program uses Java Reflection (Class and Method) to retrieve all methods of a class at runtime. It then checks whether a method with the name "method1" exists and prints a message if found.

Suggested Quiz
What will be the output of the following code?


class MyThread extends Thread {
public void run() {
System.out.println(Thread.currentThread().getName());
}

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("CustomThread");
        t1.start();
    }
}

Synchronization
Synchronization ensures that multiple threads do not interfere with each other while accessing shared resources. It helps prevent data inconsistency and race conditions.

Introduction

Synchronization in Java

Synchronization is used to control the execution of multiple processes or threads so that shared resources are accessed in a proper and orderly manner. It helps avoid conflicts and ensures correct results when many tasks run at the same time.

It controls the access of shared resources.
It avoids data inconsistency.
It ensures proper execution of processes.
Ways to Achieve Synchronization
There are three main ways to achieve synchronization.

synchronizatin
1. Synchronized Methods
   Synchronized methods are used to lock an entire method so that only one thread can execute it at a time for a particular object. This ensures safe access to shared data but may reduce performance due to full method locking.

Locks the whole method, not just a part of it.
Uses the object-level lock (instance lock).




class Counter{

    // Shared variable
    private int c = 0; 
​
// Synchronized method to increment counter
public synchronized void inc(){
c++;

    }
​
// Synchronized method to get counter value
public synchronized int get(){
return c;

    }
}
​
public class Geeks{

    public static void main(String[] args){
        
        // Shared resource
        Counter cnt = new Counter(); 
​
Thread t1 = new Thread(() -> {
for (int i = 0; i < 1000; i++)
cnt.inc();
});
​
Thread t2 = new Thread(() -> {
for (int i = 0; i < 1000; i++)
cnt.inc();
});
​
t1.start();
t2.start();
​
try {
t1.join();
t2.join();
}
catch (InterruptedException e) {
e.printStackTrace();
}
​
System.out.println("Counter: " + cnt.get());
}
}

Output
Counter: 2000
Explanation: Both threads increment the same counter concurrently. Since the inc() and get() methods are synchronized, only one thread can access them at a time, ensuring the correct final count.

2. Synchronized Blocks
   Synchronized blocks allow locking only a specific section of code instead of the entire method. This makes the program more efficient by reducing the scope of synchronization.

Locks only the critical section of code, not the entire method.
Provides better performance due to fine-grained control.




class Counter{
​
private int c = 0;
​
public void inc(){
​
// Synchronize only this block
synchronized (this) { c++; }
}
​
public int get() { return c; }
}
​
public class Geeks {
​
public static void main(String[] args)
throws InterruptedException{

        Counter cnt = new Counter();
​
Thread t1 = new Thread(() -> {
for (int i = 0; i < 1000; i++)
cnt.inc();
});
​
Thread t2 = new Thread(() -> {
for (int i = 0; i < 1000; i++)
cnt.inc();
});
​
t1.start();
t2.start();
t1.join();
t2.join();
​
System.out.println("Counter: " + cnt.get());
}
}

Output
Counter: 2000
Explanation: The synchronized block ensures mutual exclusion only for the increment statement, reducing the locking overhead.

3. Static Synchronization
   Static synchronization is used when static data or methods need to be protected in a multithreaded environment. It ensures that only one thread can access the class-level resource at a time.

Locks at the class level instead of the object level.
Shared across all instances of the class.




class Table{

    synchronized static void printTable(int n){
        
        for (int i = 1; i <=3; i++){
            
            System.out.println(n * i);
            try {
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
​
class Thread1 extends Thread{

    public void run() {
        Table.printTable(1);
    }
}
​
class Thread2 extends Thread {
public void run() {
Table.printTable(10);
}
}
​
public class GFG{

    public static void main(String[] args){
        
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}

Output
1
2
3
10
20
30
Explanation: Both threads t1 and t2 call the static synchronized method printTable(). The lock is applied to the Table.class object, ensuring that only one thread can access the method at a time, even if no object instance is shared.

Types of Synchronization
There are two type of synchronizations in Java which are listed below:

1. Process Synchronization
   Process synchronization is a fundamental concept in operating systems that ensures multiple processes or threads can execute safely while sharing common resources. Process Synchronization is a technique used to coordinate the execution of multiple processes. It ensures that the shared resources are safe and in order.

Prevents race conditions by controlling access to shared resources.
Ensures data consistency and integrity in concurrent execution.
Uses mechanisms like semaphores, mutex locks, and monitors for coordination.




class BankAccount{
​
// Shared resource (bank balance)
private int balance = 1000;
​
// Synchronized method for deposit operation
public synchronized void deposit(int amount){

        balance += amount;
        System.out.println("Deposited: " + amount
                           + ", Balance: " + balance);
    }
​
// Synchronized method for withdrawal operation
public synchronized void withdraw(int amount){

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount
                               + ", Balance: " + balance);
        }
        else {
            System.out.println(
                "Insufficient balance to withdraw: "
                + amount);
        }
    }
​
public int getBalance() { return balance; }
}
​
// Main class
public class Geeks{

    public static void main(String[] args){
        
        BankAccount account
            = new BankAccount(); // Shared resource
​
// Thread 1 to deposit money into the account
Thread t1 = new Thread(() -> {
for (int i = 0; i < 3; i++) {
account.deposit(200);
try {
Thread.sleep(50); // Simulate some delay
}
catch (InterruptedException e) {
e.printStackTrace();
}
}
});
​
// Thread 2 to withdraw money from the account
Thread t2 = new Thread(() -> {
for (int i = 0; i < 3; i++) {
account.withdraw(100);
try {
Thread.sleep(
100); // Simulate some delay
}
catch (InterruptedException e) {
e.printStackTrace();
}
}
});
​
// Start both threads
t1.start();
t2.start();
​
// Wait for threads to finish
try {
t1.join();
t2.join();
}
catch (InterruptedException e) {
e.printStackTrace();
}
​
// Print final balance
System.out.println("Final Balance: "
+ account.getBalance());
}
}

Output
Deposited: 200, Balance: 1200
Withdrawn: 100, Balance: 1100
Deposited: 200, Balance: 1300
Deposited: 200, Balance: 1500
Withdrawn: 100, Balance: 1400
Withdrawn: 100, Balance: 1300
Final Balance: 1300
Explanation: Two threads perform deposit and withdrawal operations simultaneously. The synchronized methods prevent race conditions, ensuring consistent balance updates.

2. Thread Synchronization in Java
   Thread Synchronization is used to coordinate and ordering of the execution of the threads in a multi-threaded program. There are two types of thread synchronization are mentioned below:

Mutual Exclusive
Cooperation (Inter-thread communication in Java)
Example: Ticket Booking System





class TicketBooking{

    // Shared resource (available tickets)
    private int availableTickets
        = 10; 
​
// Synchronized method for booking tickets
public synchronized void bookTicket(int tickets){

        if (availableTickets >= tickets){
            
            availableTickets -= tickets;
            System.out.println(
                "Booked " + tickets
                + " tickets, Remaining tickets: "
                + availableTickets);
        }
        else{
            System.out.println(
                "Not enough tickets available to book "
                + tickets);
        }
    }
​
public int getAvailableTickets(){

        return availableTickets;
    }
}
​
public class Geeks{

    public static void main(String[] args){
        
        // Shared resource
        TicketBooking booking
            = new TicketBooking(); 
​
// Thread 1 to book tickets
Thread t1 = new Thread(() -> {
for (int i = 0; i < 2; i++) {

                // Trying to book 2
                // tickets each time
                booking.bookTicket(2); 
                                       
                try{
                    
                    // Simulate delay
                    Thread.sleep(50); 
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
​
// Thread 2 to book tickets
Thread t2 = new Thread(() -> {
for (int i = 0; i < 2; i++){

                // Trying to book 3
                // tickets each time
                booking.bookTicket(3); 
                                       
                try{
                    
                    // Simulate delay
                    Thread.sleep(40);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
​
// Start both threads
t1.start();
t2.start();
​
// Wait for threads to finish
try {
t1.join();
t2.join();
}
catch (InterruptedException e) {
e.printStackTrace();
}
​
// Print final remaining tickets
System.out.println("Final Available Tickets: "
+ booking.getAvailableTickets());
}
}

Output
Booked 2 tickets, Remaining tickets: 8
Booked 3 tickets, Remaining tickets: 5
Booked 3 tickets, Remaining tickets: 2
Booked 2 tickets, Remaining tickets: 0
Final Available Tickets: 0
Explanation: The synchronized bookTicket() method ensures that only one thread books tickets at a time, preventing overbooking and ensuring correct availability.

Volatile Keyword
The volatile keyword in Java ensures that all threads have a consistent view of a variable's value. It prevents caching of the variable's value by threads, ensuring that updates to the variable are immediately visible to other threads.

Working of Volatile Modifier:

It applies only to variables.
volatile guarantees visibility i.e. any write to a volatile variable is immediately visible to other threads.
It does not guarantee atomicity, meaning operations like count++ (read-modify-write operations) can still result in inconsistent values




class Counter {
private volatile boolean running = true;
​
public void stop() {
running = false;
}
​
public void start() {
new Thread(() -> {
while (running) {
System.out.println("Running...");
try {
Thread.sleep(200);
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
}
}
System.out.println("Stopped.");
}).start();
}
}
​
public class Geeks {
public static void main(String[] args) throws InterruptedException {
Counter counter = new Counter();
counter.start();
​
Thread.sleep(600); // Let it run briefly
counter.stop();    // Then stop the thread
}
}

Output
Running...
Running...
Running...
Stopped.
Explanation: The volatile variable running ensures that updates made by one thread (in stop()) are visible to the thread running the loop in start().

Volatile vs Synchronized
volatile	synchronized
Ensures visibility of changes across threads	Ensures visibility along with mutual exclusion
Does not use any locking	Uses intrinsic locking mechanism
Not thread-safe for complex operations	Fully thread-safe
Does not guarantee atomicity	Guarantees atomic operations
Lightweight and faster	Heavyweight and slower due to locking
Used for simple flags or variables	Used for critical sections like counters or transactions


Importance of Thread Synchronization

Importance of Thread Synchronization in Java

Thread synchronization in Java is a mechanism used to control the access of multiple threads to shared resources to avoid data inconsistency. It ensures that only one thread executes a critical section at a time, preventing race conditions.

Achieved using synchronized keyword, locks, and other concurrency utilities.
Helps prevent thread interference and memory consistency errors.
Supports coordination using methods like wait(), notify(), and notifyAll().
Real-world Example
Imagine multiple computers connected to a single printer:

If two computers send print jobs simultaneously, the printer might mix their outputs and that leads to invalid results.
Similarly, threads accessing the same resource without coordination can produce inconsistent data.
Thread Priorities
In Java, thread priorities determine the execution order, allowing higher-priority threads to preempt lower ones and access resources first. However, when threads of equal priority compete for the same resource, conflicts can lead to inconsistent or erroneous outcomes.

Mechanisms for Thread Synchronization
Thread synchronization ensures only one thread executes at a time while others wait.
It helps prevent thread interference and data inconsistency issues.
Implemented using locks/monitors in Java.
A monitor (object lock) allows only one thread to access a resource at a time.
When a thread acquires a lock, other threads are blocked until the lock is released.
Other threads remain in a waiting state until the current thread exits the critical section.
Types of Thread Synchronization
Thread synchronization are of two types:

Mutual Exclusion
Inter-Thread Communication
Mutual Exclusion
While sharing any resource, this will keep the thread interfering with one another i.e. mutual exclusive. We can achieve this via

Synchronized Method
Synchronized Block
Static Synchronization
1. Synchronized Method

We can declare a method as synchronized using the synchronized keyword. This will make the code written inside the method thread-safe so that no other thread will execute while the resource is shared.

Implementation:

We will be proposing prints the two threads simultaneously showing the asynchronous behavior without thread synchronization.

Example 1: Here, we will use non-synchronized method.


// Extending Thread class
public class PrintTest extends Thread {

    // Non synchronized Code
    // Method 1
    public void printThread(int n)
    {
        // This loop will print the 
        // currently executed thread
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + n
                               + " is working...");

            // Try block to check for exceptions
            try {

                // Pause the execution of current thread
                // for 0.600 seconds using sleep() method
                Thread.sleep(600);
            }

            // Catch block to handle the exceptions
            catch (Exception ex) {

                // Overriding existing toString() method and
                // prints exception if occur
                System.out.println(ex.toString());
            }
        }

        // Display message for better readability
        System.out.println("--------------------------");

        try {

            // Pause the execution of current  thread
            // for 0.1000 millisecond or 1sec using sleep
            // method
            Thread.sleep(1000);
        }

        catch (Exception ex) {

            // Printing the exception
            System.out.println(ex.toString());
        }
    }
}

// Class 2
// Helper class extending Thread Class
public class Thread1 extends Thread {

    // Declaring variable of type Class1
    PrintTest test;

    // Constructor for class1
    Thread1(PrintTest p) { test = p; }

    // run() method of this class for
    // entry point for thread1
    public void run()
    {

        // Calling method  1 as in above class
        test.printThread(1);
    }
}

// Class 3
// Helper class extending Thread Class
public class Thread2 extends Thread {

    // Declaring variable of type Class1
    PrintTest test;

    // Constructor for class2
    Thread2(PrintTest p) { test = p; }

    // run() method of this class for
    // entry point for thread2
    public void run() { test.printThread(2); }
}

// Class 4
// Main class
public class SynchroTest {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating object of class 1 inside main() method
        PrintTest p = new PrintTest();

        // Passing the same object of class PrintTest to
        // both threads
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);

        // Start executing the threads
        // using start() method
        t1.start();
        t2.start();

        // This will print both the threads  simultaneously
    }
}
Output:

Now using synchronized method, it will lock the object for the shared resource and gives the consistent output.

Example 2: Below example, lock the object for the shared resource.


public class PrintTest extends Thread {

    // synchronized method will lock the object and
    // releases when thread is terminated 
    synchronized public void printThread(int n)
    {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + n
                               + " is working...");

            try {

                // pause the execution of current  thread
                // for 600 millisecond
                Thread.sleep(600);
            }
            catch (Exception ex) {
              
                // overrides toString() method  and prints
                // exception if occur
                System.out.println(ex.toString());
            }
        }
        System.out.println("--------------------------");
        try {

            // pause the execution of current  thread for
            // 1000 millisecond
            Thread.sleep(1000);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

// creating thread1 extending Thread Class
public class Thread1 extends Thread {

    PrintTest test;
    Thread1(PrintTest p) { test = p; }

    public void run() // entry point for thread1
    {

        test.printThread(1);
    }
}

// creating thread2 extending Thread Class
public class Thread2 extends Thread {

    PrintTest test;
    Thread2(PrintTest p) { test = p; }
    public void run()  // entry point for thread2
    {
        test.printThread(2);
    }
}

public class SynchroTest {
public static void main(String[] args)
{
PrintTest p = new PrintTest();

        // passing the same object of class PrintTest to
        // both threads    
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);
      
        // start function will execute the threads
        t1.start();
        t2.start();
    }
}
Output:

2. Synchronized Block

If we declare a block as synchronized, only the code which is written inside that block is executed sequentially not the complete code. This is used when we want sequential access to some part of code or to synchronize some part of code.

Syntax:

synchronized (object reference)
{    
// Insert code here
}

Example:


class PrintTest extends Thread {

    // To print the thread
    public void printThread(int n)
    {

        // Making synchronized block that 
        // makes the block synchronized
        synchronized (this)
        {

            // Iterating using for loop
            for (int i = 1; i <= 10; i++) {

                System.out.println("Thread " + n
                                   + " is working...");

                // Try block to check for exceptions
                try {

                    // Making thread to pause for 0.6
                    // seconds
                    Thread.sleep(600);
                }

                // Catch block to handle exceptions
                catch (Exception ex) {

                    System.out.println(ex.toString());
                }
            }
        }

        System.out.println("--------------------------");

        try {

            // Making thread t osleep for 1 sec
            Thread.sleep(1000);
        }

        catch (Exception ex) {

            System.out.println(ex.toString());
        }
    }
}

// Helper class extending Thread class
class Thread1 extends Thread {

    PrintTest test;
    Thread1(PrintTest p) { test = p; }

    public void run() { test.printThread(1); }
}

// Helper class extending Thread class
class Thread2 extends Thread {

    PrintTest test;
    Thread2(PrintTest p) { test = p; }

    public void run() { test.printThread(2); }
}

// Main class
class SynchroTest {

    public static void main(String[] args) {

        // Creating instance for class 1 inside main()
        PrintTest p = new PrintTest();

        // Creating threads and
        // passing same object
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);

        // Starting these thread using start() method
        t1.start();
        t2.start();
    }
}
Output:

3. Static Synchronization

In this, the synchronized method is declared as "static" which means the lock or monitor is applied on the class not on the object so that only one thread will access the class at a time.

Example:


class PrintTest extends Thread {

    // Static synchronization locks the class PrintTest
    synchronized public static void printThread(int n)
    {

        for (int i = 1; i <= 10; i++) {

            System.out.println("Thread " + n
                               + " is working...");

            // Try block to check for exceptions
            try {

                // making thread to sleep for 0.6 seconds
                Thread.sleep(600);
            }

            // Catch block to handle the exceptions
            catch (Exception ex) {

                System.out.println(ex.toString());
            }
        }

        System.out.println("--------------------------");

        try {
            Thread.sleep(1000);
        }

        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

// Helper class extending Thread class
class Thread1 extends Thread {

    // run() method for thread
    public void run()
    {

        // Passing the class not the object
        PrintTest.printThread(1);
    }
}

// Helper class extending Thread class
class Thread2 extends Thread {

    public void run()
    {

        // Passing the class not the object
        PrintTest.printThread(2);
    }
}

// Main class
class SynchroTest {

    public static void main(String[] args)
    {

        // No shared object
        // Creating objects of class 2 and 3 that
        // are extending to Thread class
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        // Starting thread with help of start() method
        t1.start();
        t2.start();
    }
}

Synchronized methods & synchronized blocks

Java Method and Block Synchronization

Synchronization in Java is used to control access to shared resources in a multithreaded environment. It ensures that only one thread executes a critical section at a time, preventing data inconsistency.

Can be applied to methods or specific blocks of code
Method synchronization locks the entire method
Block synchronization locks only the critical section
Types of Synchronization
Synchronization in Java can be applied in different ways depending on the level of control required. It helps manage thread access to shared resources efficiently.

1. Method Synchronization
   To synchronize a method, add the synchronized keyword. This ensures that only one thread can execute the method at a time.

Example: Unsynchronized Method





class Line {
public void getLine() {
for (int i = 0; i < 3; i++) {
System.out.println(i);
try { Thread.sleep(100); }
catch (Exception e) { System.out.println(e); }
}
}
}
​
class Train extends Thread {
Line line;
Train(Line line) { this.line = line; }
public void run() { line.getLine(); }
}
​
public class Geeks {
public static void main(String[] args) {
Line obj = new Line();
Train t1 = new Train(obj);
Train t2 = new Train(obj);
t1.start();
t2.start();
}
}
Output:

0
0
1
2
1
2

Explanation: Threads t1 and t2 access the method concurrently, causing mixed output.

Example: Synchronized Method





class Line {
synchronized public void getLine() {
for (int i = 0; i < 3; i++) {
System.out.println(i);
try { Thread.sleep(100); }
catch (Exception e) { System.out.println(e); }
}
}
}
​
class Train extends Thread {
Line line;
Train(Line line) { this.line = line; }
public void run() { line.getLine(); }
}
​
public class Geeks {
public static void main(String[] args) {
Line obj = new Line();
Train t1 = new Train(obj);
Train t2 = new Train(obj);
t1.start();
t2.start();
}
}

Output
0
1
2
0
1
2
Explanation: Only one thread executes the method at a time, ensuring data consistency.

2. Block Synchronization
   Block synchronization is used when only part of a method contains critical code. This improves performance by allowing threads to execute non-critical code concurrently.

Example: Synchronized Block





import java.util.*;
​
class Geek {
String name = "";
public int count = 0;
​
public void geekName(String geek, List<String> list) {
synchronized(this) {
name = geek;
count++;
}
list.add(geek);
}
}
​
public class GFG {
public static void main(String[] args) {
Geek gk = new Geek();
List<String> list = new ArrayList<>();
gk.geekName("Mohit", list);
System.out.println(gk.name);
}
}

Output
Mohit
Explanation: Only the block updating name and count is synchronized. Adding names to the list runs concurrently.

Method vs Block Synchronization
Feature	Method Synchronization	Block Synchronization
Scope	Locks the entire method	Locks only the specific block of code
Performance	Can cause unnecessary blocking for non-critical code	More efficient, only critical sections are synchronized
Lock	Acquires the lock on the method’s object	Acquires the lock on the object or class specified in the block
Flexibility	Less flexible, entire method is locked	More flexible, allows selective synchronization
Important Points
A thread entering a synchronized method/block acquires a lock, it releases it upon exit.
Instance methods/blocks: Acquire object-level lock.
Static methods/blocks: Acquire class-level lock.
Synchronization on null objects throws NullPointerException.
wait(), notify(), and notifyAll() are key methods in synchronization.
Avoid synchronizing non-final fields to prevent threads from locking different objects.
synchronized keyword cannot be applied to variables.
Advantages
Ensures mutual exclusion for shared resources in multithreaded programs.
Both synchronized instance and static methods can run concurrently because they lock different objects.
Limitations
Prevents concurrent reads, limiting concurrency.
Synchronized methods can degrade performance. Prefer block synchronization for critical sections only.

Static synchronization

Static Synchronization in Java

Synchronization is the potential to regulate the access of multiple threads to any shared resource. Synchronization in Java is essential for reliable communication between threads. It is achieved in Java with the use of synchronized keywords.

It is only for methods that are at the Object level.
If a method or block is synchronized, then it requires an object-level lock to start execution.
Use synchronized keywords when it is required and try to use synchronized blocks.
Static Synchronization
Static synchronization in Java is used to control access to shared resources at the class level. It ensures that only one thread can execute a static synchronized method at a time, regardless of the number of objects.

Provides a class-level lock instead of object-level lock
Only one thread can execute the static synchronized method at a time
Maintains proper synchronization even when multiple objects are created
Syntax:

static synchronized void methodName() {
// code
}

Note: When a class has both synchronized and static synchronized methods they can run parallelly ,as those two methods require different locks.

Let us assume that there are 6 threads. The order of execution will be

Example - 6 Threads in Java
The complete declarations of methods are:

Here t1,t2... t6 are the thread names

t1.method1(): public static synchronized void method1() . Starts execution as it attains class level lock of Manager class.
t2.method1(): public static synchronized void method2().Wait for its time to start execution, as it is a static synchronized method, it requires a class level lock,  as t1 has already acquired class level lock t2 must wait until t1 execution.
t3.method2() :public static void method3() .Waits as it requires class level lock, so it must wait until t1 releases the lock.
t4.method3() : public synchronized int method4() .Starts execution as it is static methods requires no lock
t5.method4() : public String method5()starts execution as it is instance or(normal) level synchronized method and requires object level lock, so it attains object level lock.
t6.method5() :starts execution as it is an instance method or a normal method
Example: Java program of multithreading with static synchronized


class Display
{
public static synchronized void wish(String name)
{
for(int i=0;i<3;i++)
{
System.out.print("Good Morning: ");
System.out.println(name);
try{
Thread.sleep(2000);
}
catch(InterruptedException e)
{
}
}
}
}

class MyThread extends Thread{
Display d;
String name;
MyThread(Display d,String name)
{
this.d=d;
this.name=name;
}
public void run()
{
d.wish(name);
}
}

class Main{
public static void main(String arg[])
{
Display d1=new Display();
Display d2=new Display();
MyThread t1=new MyThread(d1,"Dhoni");
MyThread t2=new MyThread(d2,"Yuvaraj");
t1.start();
t2.start();
}
}
Note: Each wish will be printed after a gap of 2000 ms.

Output

First time of execution:
Good Morning: Dhoni
Good Morning: Dhoni
Good Morning: Dhoni
Good Morning: Yuvaraj
Good Morning: Yuvaraj
Good Morning: Yuvaraj

Second time of execution:
Good Morning: Yuvaraj
Good Morning: Yuvaraj
Good Morning: Yuvaraj
Good Morning: Dhoni
Good Morning: Dhoni
Good Morning: Dhoni
Explanation
The wish() method is declared static synchronized, so it locks on the class-level lock and allows only one thread to execute it at a time.
Even though two different objects (d1 and d2) are used, both threads share the same class lock, so execution is sequential.
As a result, one thread completes printing all “Good Morning” messages before the other thread starts.
Difference between Synchronized and Static Synchronized in Java
Synchronized	Static Synchronized
It requires an object-level lock.	It requires a class-level lock.
Its method need not be declared static.	Its method needs to be declared static.
It is used regularly.	It is not used regularly.
A different instance is created for each object.	Only one instance for the entire program.

object level lock

Object Level Lock in Java

Object-level locking in Java controls concurrent access at the instance level, ensuring safe interaction with object data in multithreaded environments. It allows threads to coordinate execution when working on the same object. This mechanism helps maintain consistency without affecting other object instances.

Applied using synchronized on non-static methods or blocks
Ensures mutual exclusion only for threads accessing the same object
Other threads must wait until the lock is released
Methods of Object Level Lock
There are different ways we can lock the object in the thread as below:

Method 1:

public class GeekClass{   
public synchronized void GeekMethod(){}
}

Method 2:

public class GeekClass {
public void GeekMethod(){      
synchronized (this)         {       
// other thread safe code         }   
}
}

Method 3:


public class DemoClass {   
private final Object lock = new Object();   
public void demoMethod(){      
synchronized (lock)         {     
// other thread safe code         }  
}
}

Example : Java program to illustrate Object lock concept





// Class
// Extending Runnable interface
class Geek implements Runnable {
​
// Method of this class
public void run() { Lock(); }
​
// Synchronization of non-static methods
// (object lock) as different synchronized
// non-static methods are called in both threads
​
// Then both threads need to acquire the object lock
// After one is acquired, the other thread must wait
// for one thread to finish the executing
// before the other thread starts to execute.
public void Lock()
{
System.out.println(
Thread.currentThread().getName());
synchronized (this)
{
System.out.println(
"in block "
+ Thread.currentThread().getName());
System.out.println(
"in block "
+ Thread.currentThread().getName()
+ " end");
}
}
​
// Main driver method
public static void main(String[] args)
{
// Creating an object of above class
// in the main() method
Geek g = new Geek();
​
// Sharing the same object across two Threads
​
// Here, t1 takes g
Thread t1 = new Thread(g);

        // Here, t2 takes g
        Thread t2 = new Thread(g);
​
// Creating another object of above class
Geek g1 = new Geek();
​
// Here, t3 takes g1
Thread t3 = new Thread(g1);
​
// setname() method is used to change
// name of the thread
t1.setName("t1");
t2.setName("t2");
t3.setName("t3");
​
// start() method beginning the execution of threads
// as JVM calls the run() method of thread
t1.start();
t2.start();
t3.start();
}
}

Output
t1
t2
t3
in block t1
in block t3
in block t3 end
in block t1 end
in block t2
in block t2 end

Explanation:

Threads t1 and t2 share the same object (g), so they compete for the same object lock and execute the synchronized block one at a time
Thread t3 uses a different object (g1), so it gets a separate lock and can execute independently
This shows that object-level lock works per object, not per class

class level lock

Class Level Lock in Java

Class level lock is a lock on the Class object, used when working with static synchronized methods or blocks. Only one thread can execute any static synchronized code of a class at a time, regardless of number of objects.
It is mainly used to protect shared static data.

Lock is applied on the class, not on objects (common for all instances).
Achieved using static synchronized methods or synchronized(ClassName.class) block.
Ensures only one thread executes static synchronized code at a time.
Methods of Class Level Lock
1. Using the synchronized static method
   This method automatically acquires the class-level lock when a thread enters it. Only one thread can execute any static synchronized method of the class at a time.

Lock is on ClassName.class
Applied directly using static synchronized
Simple and automatic locking




class Geek implements Runnable {
​
// Method 1
// @Override
public void run() { Lock(); }
​
// Method 2
// Method is static
public static synchronized void Lock()
{
// Gwetting the name of current thread by using
// getName() method to get name of the thread and
// currentThread() to get the current thread
System.out.println(
Thread.currentThread().getName());
​
// class level lock
synchronized (Geek.class)
{
System.out.println(
"in block "
+ Thread.currentThread().getName());
System.out.println(
"in block "
+ Thread.currentThread().getName()
+ " end");
}
}
​
// Method 3
// Main driver method
public static void main(String[] args)
{
// Creating an object of above class
// in the main() method
Geek g1 = new Geek();
​
// Sharing the same object across two Threads
​
// Creating an object of thread class where
// t1 takes g1
Thread t1 = new Thread(g1);
​
// Creating an object of thread class where
// t2 takes g1
Thread t2 = new Thread(g1);
​
// Creating second object of above class
// in the main() method
Geek g2 = new Geek();
​
// Creating an object of thread class where
// t3 takes g2
Thread t3 = new Thread(g2);
​
// setName() method is used to set name to the
// thread
t1.setName("t1");
t2.setName("t2");
t3.setName("t3");
​
// start() method is used for initiating the current
// thread
t1.start();
t2.start();
t3.start();
}
}

Output
t1
in block t1
in block t1 end
t3
in block t3
in block t3 end
t2
in block t2
in block t2 end
2. Using synchronized block method
   This method uses a block where the class object is explicitly locked using ClassName.class. It allows better control by synchronizing only specific code.

Lock is on ClassName.class
Uses synchronized(ClassName.class)
More flexible than method-level synchronization.

class Geek implements Runnable {

    // Method 1
    // @Override
    public void run()
    {
        // Acquire lock on .class reference
        synchronized (Geek.class)

        // ClassName is name of the class containing method.
        {
            {
                System.out.println(
                    Thread.currentThread().getName());

                System.out.println(
                    "in block "
                    + Thread.currentThread().getName());
                System.out.println(
                    "in block "
                    + Thread.currentThread().getName()
                    + " end");
            }
        }

        // Method 2
        // Main driver method
        public static void main(String[] args)
        {
            // Creating an object of above class
            // in the main() method
            Geek g1 = new Geek();

            // Creating an object of thread class i.e Thread
            // 1 where t1 takes g1 object
            Thread t1 = new Thread(g1);
            // Here, creating Thread 2 where t2 takes g1
            // object
            Thread t2 = new Thread(g1); 

            // Creating another object of above class
            // in the main() method
            Geek g2 = new Geek();
          
            // Now Creating Thread 3 where t3 takes g2 object
            Thread t3 = new Thread(g2);

            // Ginving custom names to above 3 threads
            // using the setName() method
            t1.setName("t1");
            t2.setName("t2");
            t3.setName("t3");

            // start() method is used to begin execution of
            // threads
            t1.start();
            t2.start();
            t3.start();
        }
    }
Output:

t1
in block t1
in block t1 end
t3
in block t3
in block t3 end
t2
in block t2
in block t2 end
Output explanation: Thread t1 acquired the class lock by entering the synchronized block. Other threads waited until t1 released the lock

Inter-thread Communication
Threads can communicate using methods like wait(), notify() and notifyAll(). This enables coordination between multiple threads.

Introduction

Inter-thread Communication in Java

Inter-thread communication in Java enables threads to coordinate their execution by signaling each other during runtime. It is mainly used when multiple threads depend on shared resources or need to work in a specific sequence.

Helps avoid busy waiting and improves resource utilization
Ensures proper execution order among dependent threads
Commonly used in producer-consumer type problems
Note: Inter-thread communication is also known as Cooperation in Java.

Polling
Polling is the process of repeatedly checking a condition in a loop until it becomes true. Once the condition is satisfied, the required action is performed. It is commonly used when one thread waits for another to produce or update data.

Problem with Polling
Wastes CPU cycles due to continuous condition checking
Reduces efficiency and slows down overall execution
Keeps the thread busy instead of allowing other tasks to run
How Java Multithreading Handle Polling
Java avoids polling by using built-in communication methods that allow threads to wait efficiently instead of continuously checking a condition. These methods are defined in the Object class and must be used within a synchronized context.

wait(): Releases the lock and puts the thread into a waiting state until notified
notify(): Wakes up one waiting thread (does not release the lock immediately)
notifyAll(): Wakes up all waiting threads on the same object
The image below demonstrates the concept of Thread Synchronization and Inter-Thread Communication in Java

Java Multithreading Tackles Polling
Producer-Consumer Problem
The Producer-Consumer problem involves two threads where one (producer) adds data to a shared queue and the other (consumer) removes data from it. Proper coordination is required to ensure the producer doesn’t add when the queue is full and the consumer doesn’t remove when it’s empty.

Uses wait(), notify(), and notifyAll() for synchronization
Ensures efficient communication between producer and consumer threads
Prevents issues like data inconsistency and unnecessary waiting
Example: A simple Java program to demonstrate the three methods. Please note that this program might only run in offline IDEs as it contains taking input at several points.


import java.util.LinkedList;
import java.util.Queue;

public class Geeks {

    // Shared queue used by both producer and consumer
    private static final Queue<Integer> queue = new LinkedList<>();
    
    // Maximum capacity of the queue
    private static final int CAPACITY = 10;

    // Producer task
    private static final Runnable producer = new Runnable() {
        public void run() {
            while (true) {
                synchronized (queue) {
                    
                    // Wait if the queue is full
                    while (queue.size() == CAPACITY) {
                        try {
                            System.out.println("Queue is at max capacity");
                            queue.wait(); // Release the lock and wait
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Add item to the queue
                    queue.add(10);
                    System.out.println("Added 10 to the queue");
                    queue.notifyAll(); // Notify all waiting consumers
                    try {
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    // Consumer task
    private static final Runnable consumer = new Runnable() {
        public void run() {
            while (true) {
                synchronized (queue) {
                    
                    // Wait if the queue is empty
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("Queue is empty, waiting");
                            queue.wait(); // Release the lock and wait
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Remove item from the queue
                    System.out.println("Removed " + queue.remove() + " from the queue");
                    queue.notifyAll(); // Notify all waiting producers
                    try {
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public static void main(String[] args) {
        System.out.println("Main thread started");
        
        // Create and start the producer thread
        Thread producerThread = new Thread(producer, "Producer");
        
        // Create and start the consumer thread
        Thread consumerThread = new Thread(consumer, "Consumer");
        producerThread.start();
        consumerThread.start();
        System.out.println("Main thread exiting");
    }
}
Output:
Main thread started
Main thread exiting
Queue is empty, waiting
Added 10 to the queue
Removed 10 from the queue
Queue is empty, waiting
Added 10 to the queue
Removed 10 from the queue
...
Explanation: The program uses a shared queue for communication between producer and consumer threads. The producer adds items and waits if the queue is full, while the consumer removes items and waits if it is empty. Synchronization ensures only one thread accesses the queue at a time. The wait() method pauses execution until notified, and notifyAll() wakes up waiting threads. Both threads run continuously, with Thread.sleep() simulating processing delay.

wait()

wait() Method in Java With Examples

In Java, the wait() method is used for inter-thread communication, allowing threads to coordinate execution. It pauses a thread and releases the lock so that other threads can perform tasks. The thread resumes only when notified using notify() or notifyAll().

The current thread releases the lock on the object
The thread enters a waiting (sleep) state
Another thread can acquire the lock and perform operations
notify() wakes one waiting thread
notifyAll() wakes all waiting threads
After notification, the thread resumes execution
Example: GunFight has 40 bullets; fire() uses wait() when empty, and reload() refills bullets and calls notify() to resume the thread.





class GunFight {
private int bullets = 40;
​
// This method fires the number of bullets that are
// passed it. When the bullet in magazine becomes zero,
// it calls the wait() method and releases the lock.
synchronized public void fire(int bulletsToBeFired)
{
for (int i = 1; i <= bulletsToBeFired; i++) {
if (bullets == 0) {
System.out.println(i - 1
+ " bullets fired and "
+ bullets + " remains");
System.out.println(
"Invoking the wait() method");
try {
wait();
}
catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(
"Continuing the fire after reloading");
}
​
bullets--;
}
System.out.println(
"The firing process is complete");
}
​
// reload() increases the bullets by 40 everytime it is
// invoked and calls the notify() method which wakes up
// the thread that was sent to sleep using wait() inside
// of fire() method
synchronized public void reload()
{
System.out.println(
"Reloading the magazine and resuming "
+ "the thread using notify()");
bullets += 40;
notify();
}
}
​
public class WaitDemo extends Thread {
public static void main(String[] args)
{
​
GunFight gf = new GunFight();
​
// Creating a new thread and invoking
// our fire() method on it
new Thread() {
@Override public void run() { gf.fire(60); }
}.start();
​
// Creating a new thread and invoking
// our reload method on it
new Thread() {
@Override public void run() { gf.reload(); }
}.start();
}
}

Output
40 bullets fired and 0 remains
Invoking the wait() method
Reloading the magazine and resuming the thread using notify()
Continuing the fire after reloading
The firing process is complete
Syntax:

public final void wait() throws InterruptedException

Exceptions

InterruptedException - if any thread interrupted the current thread before or while the current thread was waiting for a notification.
IllegalMonitorStateException - if the current thread is not the owner of the object's monitor.


notify() and notifyAll()

Difference Between notify() and notifyAll() in Java

In Java, notify() and notifyAll() are used in inter-thread communication to wake up threads waiting on an object’s monitor. Both are part of the Object class but differ in how many threads they wake. The notify() and notifyAll() methods with wait() methods are used for communication between the threads.

notify() wakes up only one waiting thread, while notifyAll() wakes all waiting threads
notify() is more efficient but may cause thread starvation, whereas notifyAll() avoids starvation
notify() Method
The notify() method in Java is used for inter-thread communication to wake up a thread that is waiting on an object’s monitor. It is defined in the Object class and works with wait() inside synchronized blocks.

Wakes up one randomly selected waiting thread
Does not release the lock immediately after calling
Must be used inside a synchronized method or block

class Geek1 extends Thread {
public void run()
{
synchronized (this)
{
System.out.println(
Thread.currentThread().getName()
+ "...starts");
try {
this.wait();
}
catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(
Thread.currentThread().getName()
+ "...notified");
}
}
}
class Geek2 extends Thread {
Geek1 geeks1;

    Geek2(Geek1 geeks1){ 
      this.geeks1 = geeks1; 
    }
  
    public void run()
    {
        synchronized (this.geeks1)
        {
            System.out.println(
                Thread.currentThread().getName()
                + "...starts");

            try {
                this.geeks1.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                Thread.currentThread().getName()
                + "...notified");
        }
    }
}
class Geek3 extends Thread {
Geek1 geeks1;
Geek3(Geek1 geeks1) { this.geeks1 = geeks1; }
public void run()
{
synchronized (this.geeks1)
{
System.out.println(
Thread.currentThread().getName()
+ "...starts");
this.geeks1.notify();
System.out.println(
Thread.currentThread().getName()
+ "...notified");
}
}
}
class MainClass {
public static void main(String[] args)
throws InterruptedException
{

        Geek1 geeks1 = new Geek1();
        Geek2 geeks2 = new Geek2(geeks1);
        Geek3 geeks3 = new Geek3(geeks1);
        Thread t1 = new Thread(geeks1, "Thread-1");
        Thread t2 = new Thread(geeks2, "Thread-2");
        Thread t3 = new Thread(geeks3, "Thread-3");
        t1.start();
        t2.start();
        Thread.sleep(100);
        t3.start();
    }
}
Output:

Thread-1...start
Thread-2...starts
Thread-3...starts
Thread-3...notified
Thread-1...notified
notifyAll() Method
The notifyAll() method in Java is used for inter-thread communication to wake up all threads waiting on an object’s monitor. It is defined in the Object class and is typically used when multiple threads need to resume execution.

Wakes up all waiting threads on the same object
Threads compete to re-acquire the lock before continuing
Must be called inside a synchronized method or block




class Geek1 extends Thread {
public void run()
{
synchronized (this)
{
System.out.println(
Thread.currentThread().getName()
+ "...starts");
try {
this.wait();
}
catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(
Thread.currentThread().getName()
+ "...notified");
}
}
}
class Geek2 extends Thread {
Geek1 geeks1;

    Geek2(Geek1 geeks1){ 
      this.geeks1 = geeks1; 
    }
  
    public void run()
    {
        synchronized (this.geeks1)
        {
            System.out.println(
                Thread.currentThread().getName()
                + "...starts");
​
try {
this.geeks1.wait();
}
catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(
Thread.currentThread().getName()
+ "...notified");
}
}
}
class Geek3 extends Thread {
Geek1 geeks1;
Geek3(Geek1 geeks1) { this.geeks1 = geeks1; }
public void run()
{
synchronized (this.geeks1)
{
System.out.println(
Thread.currentThread().getName()
+ "...starts");
​
this.geeks1.notifyAll();
System.out.println(
Thread.currentThread().getName()
+ "...notified");
}
}
}
class MainClass {
public static void main(String[] args)
throws InterruptedException
{
​
Geek1 geeks1 = new Geek1();
Geek2 geeks2 = new Geek2(geeks1);
Geek3 geeks3 = new Geek3(geeks1);
Thread t1 = new Thread(geeks1, "Thread-1");
Thread t2 = new Thread(geeks2, "Thread-2");
Thread t3 = new Thread(geeks3, "Thread-3");
t1.start();
t2.start();
Thread.sleep(100);
t3.start();
}
}

Output
Thread-1...starts
Thread-2...starts
Thread-3...starts
Thread-3...notified
Thread-1...notified
Thread-2...notified
notify() Vs notifyAll() Method
Feature	notify()	notifyAll()
Threads Woken	Wakes one waiting thread	Wakes all waiting threads
Selection	Thread is randomly selected	All threads are notified
Performance	More efficient	Less efficient (more overhead)
Risk	May cause thread starvation	Avoids starvation
Execution	Only one thread proceeds	Multiple threads compete for lock
Use Case	When only one thread needs to run	When all waiting threads should run

Deadlock
Deadlock occurs when two or more threads wait indefinitely for resources locked by each other. Java provides techniques to avoid and resolve deadlocks.

Introduction

Deadlock in Java Multithreading

Deadlock is a situation in multithreading where two or more threads are permanently blocked because each one is waiting for the other to release a required lock. In simple terms, threads get stuck forever, and the program never continues.

Each thread holds a lock and waits for another lock held by a different thread.
This creates a circular wait, causing the application to freeze indefinitely.
Example: Below is a simple example demonstrating a deadlock condition in Java.


// Utility class to pause thread execution
class Util {
static void sleep(long millis)
{
try {
Thread.sleep(millis);
}
catch (InterruptedException e) {
e.printStackTrace();
}
}
}
// this class is shared by both threads
class Shared {

    // first synchronized method
    synchronized void test1(Shared s2)
    {
        System.out.println(Thread.currentThread().getName()
                           + " enters test1 of " + this);
        Util.sleep(1000);
      
        // Trying to call test2 on another object
        s2.test2();
        System.out.println(Thread.currentThread().getName()
                           + " exits test1 of " + this);
    }
  
    // Second synchronized method
    synchronized void test2()
    {
        System.out.println(Thread.currentThread().getName()
                           + " enters test2 of " + this);
        Util.sleep(1000);
      
        // taking object lock of s1 enters into test1 method
        System.out.println(Thread.currentThread().getName()
                           + " exits test2 of " + this);
    }
}

class Thread1 extends Thread {
private Shared s1;
private Shared s2;

    // constructor to initialize fields
    public Thread1(Shared s1, Shared s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }
  
    // run method to start a thread
    @Override public void run() { s1.test1(s2); }
}

class Thread2 extends Thread {
private Shared s1;
private Shared s2;

    // constructor to initialize fields
    public Thread2(Shared s1, Shared s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }
  
    // run method to start a thread
    @Override public void run() { s2.test1(s1); }
}
public class Geeks {

// In this class deadlock occurs
public static void main(String[] args)
{
// creating one object
Shared s1 = new Shared();
Shared s2 = new Shared();

        // creating first thread and starting it
        Thread1 t1 = new Thread1(s1, s2);
        t1.setName("Thread1");
        t1.start();
      
        // creating second thread and starting it
        Thread2 t2 = new Thread2(s1, s2);
        t2.setName("Thread2");
        t2.start();
        Util.sleep(2000);
    }
}
Output:

Output
Output
Note: It is not recommended to run the program in an online IDE. We can run the above source code locally, but it gets stuck in a deadlock, preventing execution.

Explanation:

Thread t1 starts by acquiring a lock on the s1 and enters the test1() method of s1.
Thread t2 starts by acquiring a lock on the s2 and enters the test1() method of s2.
In the test1() method both threads try to acquire locks on each other's objects but the locks are already held by the other thread causing both threads to wait indefinitely for the other to release the lock.
Neither test1() nor test2() methods complete execution and the program remains stuck in the deadlock state.
Locks in Java
In Java, locks are mechanisms used to control access to shared resources in a multithreaded environment. Below is the diagrammatic representation of how Locks work and prevent Deadlock conditions.

thread
Locks in Java
Detecting Deadlocks
We can detect deadlocks in a running Java program using the following steps:

1. List the active Java processes:

jps -l

Response:

List of Running Thread
Response
This will list the running Java processes and also mention that there is a deadlock if we want to generate a thread dump.

2. Identify the process ID (PID) of the target program and run:

jcmd <PID> Thread.print          // replace PID with the process ID

Replace <PID> with the process ID from the list provided by jps -l. This command outputs the state of the threads, which you can then analyze for deadlocks.

After running the above two commands, we can see deadlock occurs:

As we can see it is mentioned that found 1 deadlock.

Preventing Deadlocks
We can avoid deadlock conditions by knowing its possibilities. It's a very complex process and not easy to catch. Still, if we try, we can avoid this. There are some methods by which we can avoid this condition. We can't completely remove its possibility but we can reduce it.

Avoid Nested Locks: This is the main reason for deadlock. Mainly happens when we give locks to multiple threads. Avoid giving lock to multiple threads if we already have given to one.
Avoid Unnecessary Locks: We should have lock only those members who are required. Having a lock on unnecessarily can lead to deadlock.
Using thread join: Deadlock condition appears when one thread is waiting for the other to finish. If this condition occurs we can use Thread. Join the with the maximum time you think the execution will take.

Deadlock example and prevention techniques

Deadlock Prevention

Deadlock prevention is a strategy used in computer systems to ensure that different processes can run smoothly without getting stuck waiting for each other forever. Think of it like a traffic system where cars (processes) must move through intersections (resources) without getting into a gridlock.

Deadlock can only happen if all four of the following conditions are met simultaneously:

Mutual Exclusion
Hold and Wait
No Preemption
Circular Wait
1. Eliminate Mutual Exclusion
   Some resources, like a printer, are inherently non-sharable, so this condition is difficult to break.
   However, sharable resources like read-only files can be accessed by multiple processes at the same time.
   For non-sharable resources, prevention through this method is not possible.
   Mutual Exclusion in Synchronization - GeeksforGeeks
2. Eliminate Hold and Wait
   Hold and wait is a condition in which a process holds one resource while simultaneously waiting for another resource that is being held by a different process. The process cannot continue until it gets all the required resources.

HoldWait
Hold & Wait
There are two ways to eliminate hold and wait:

By eliminating wait: The process specifies the resources it requires in advance so that it does not have to wait for allocation after execution starts.
For Example, Process1 declares in advance that it requires both Resource1 and Resource2.
By eliminating hold: The process has to release all resources it is currently holding before making a new request.
For Example: Process1 must release Resource2 and Resource3 before requesting Resource1.
3. Eliminate No Preemption
   No preemption means resources can’t be taken away once allocated. To prevent this:

Processes must release resources voluntarily: A process gives up resources once it finishes using them.
Avoid partial allocation: If a process requests resources that are unavailable, it must release all currently held resources and wait until all required resources are free.
4. Eliminate Circular Wait
   Circular wait happens when processes form a cycle, each waiting for a resource held by the next. To prevent this:

Impose a strict ordering on resources.
Assign each resource a unique number.
Processes can only request resources in increasing order of their numbers.
This prevents cycles, as no process can go backwards in numbering.


Thread Safety
Thread safety ensures correct program execution when multiple threads access shared data. Techniques include synchronized, volatile and ThreadLocal.

Using Synchronization

Using Volatile Keyword
volatile Keyword in Java

The volatile keyword in Java is used to ensure that changes made to a variable are immediately visible to all threads. It is commonly used in multithreading to maintain data consistency without full synchronization.

Ensures visibility of shared variables across threads by preventing caching issues.
Does not provide atomicity, so it is not suitable for operations like increment (count++).
Syntax:

volatile dataType variableName;





class SharedData {
volatile boolean flag = false;
}
​
class MyThread extends Thread {
SharedData data;
​
MyThread(SharedData data) {
this.data = data;
}
​
public void run() {
while (!data.flag) {
// waiting
}
System.out.println("Flag changed!");
}
}
​
public class Geeks{
public static void main(String[] args) throws Exception {
SharedData data = new SharedData();
MyThread t = new MyThread(data);
t.start();
​
Thread.sleep(1000);
data.flag = true;
}
}
Output:

out
Explanation:

The thread keeps running in the while (!data.flag) loop.
After 1 second, the main thread sets flag = true.
Because flag is volatile, the change is immediately visible.
The loop exits, and the message "Flag changed!" is printed.
When to Use volatile
For boolean flags (e.g., stop thread signal)
For status indicators
When only one thread writes and others read
When no compound operations are involved (like increment)
Volatile vs Synchronized
Feature	volatile	synchronized
Purpose	Ensures visibility of variables	Ensures visibility + atomicity
Thread Safety	Partial (only visibility)	Full thread safety
Atomicity	Not guaranteed	Guaranteed
Locking	No locking	Uses intrinsic lock (monitor)
Performance	Faster (lightweight)	Slower (due to locking overhead)
Use Case	Flags, status variables	Critical sections, shared resources

Using Atomic Variable

Atomic Variables in Java with Examples

Atomic is a type of variable that performs read, write and update in a single uninterruptible step, ensuring thread-safe operations and preventing race conditions

It ensures data consistency without using synchronization or locks.
It improves performance through non-blocking, lock-free operations.
Simplify thread-safe programming for common operations like increment and compare-and-set.
Example: Without AtomicInteger





class Counter {
static int count = 0;
}
​
public class Geeks{
​
public static void main(String[] args) throws InterruptedException {
​
Runnable task = () -> {
for (int i = 0; i < 100000; i++) {
Counter.count++;
}
};
​
Thread t1 = new Thread(task);
Thread t2 = new Thread(task);
​
t1.start();
t2.start();
​
t1.join();
t2.join();
​
System.out.println("Final Count = " + Counter.count);
}
}

Output
Final Count = 179864
Explanation:

Both threads update the same shared variable.
The count++ operation is not atomic.
Multiple threads may read the same value simultaneously before either writes back the updated value.
As a result, some increments are lost.
This situation is known as a race condition.
Example: With AtomicInteger





import java.util.concurrent.atomic.AtomicInteger;
​
public class Geeks{
​
static AtomicInteger count = new AtomicInteger(0);
​
public static void main(String[] args) throws InterruptedException {
​
Runnable task = () -> {
for (int i = 0; i < 100000; i++) {
count.incrementAndGet();
}
};
​
Thread t1 = new Thread(task);
Thread t2 = new Thread(task);
​
t1.start();
t2.start();
​
t1.join();
t2.join();
​
System.out.println("Final Count = " + count.get());
}
}

Output
Final Count = 200000
Explanation:

Both threads update the same shared AtomicInteger.
The incrementAndGet() method performs the increment atomically.
No thread can interfere while the operation is being performed.
No increments are lost.
The final count is always correct.
How Atomic Variables Work
Atomic variables internally use a hardware-supported algorithm called Compare-And-Swap (CAS). CAS works in three steps:

Read the current value.
Compare it with the expected value.
If both values match, update the value atomically.
If another thread changes the value before the update occurs, the operation fails and is retried automatically. This allows atomic variables to provide thread safety without using explicit locks.

Types of Atomic Variables in Java
Below are some commonly used atomic variable types in Java.

types_of_atomic_variables
Types of Atomic Variables
1. AtomicInteger
   AtomicInteger provides atomic operations (increment, decrement, add, etc.) on integer values without synchronization.





import java.util.concurrent.atomic.AtomicInteger;
​
public class GFG{

    public static void main(String[] args){
        
        AtomicInteger count = new AtomicInteger(5);
​
count.incrementAndGet(); // 6
count.addAndGet(3); // 9
​
System.out.println("Final Value: " + count.get());
}
}

Output
Final Value: 9
2. AtomicLong
   AtomicLong supports atomic operations on long values for thread-safe numeric computations.





import java.util.concurrent.atomic.AtomicLong;
​
public class GFG{

    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong(100);
​
// adds 50, returns old value
counter.getAndAdd(50);  
System.out.println("Updated Value: " + counter.get());
}
}

Output
Updated Value: 150
3. AtomicBoolean
   AtomicBoolean represents a boolean value that can be atomically updated for safe flag-based operations.





import java.util.concurrent.atomic.AtomicBoolean;
​
public class GFG {
​
private static AtomicBoolean flag
= new AtomicBoolean(false);
​
public static void main(String[] args)
{
if (flag.compareAndSet(false, true)) {
System.out.println(
"Operation performed only once!");
}
else {
System.out.println("Already performed!");
}
}
}

Output
Operation performed only once!
4. AtomicReference
   AtomicReference allows atomic read and write of object references, useful for non-primitive data.





import java.util.concurrent.atomic.AtomicReference;
​
public class GFG{

    public static void main(String[] args){
        
        AtomicReference<String> message
            = new AtomicReference<>("Hello");
​
message.compareAndSet("Hello",
"Hi, from AtomicReference!");
​
System.out.println("Current Message: "
+ message.get());
}
}

Output
Current Message: Hi, from AtomicReference!
5. AtomicIntegerArray
   AtomicIntegerArray enables atomic operations on elements of an integer array for thread-safe updates.





import java.util.concurrent.atomic.AtomicIntegerArray;
​
public class GFG {
public static void main(String[] args)
{
AtomicIntegerArray numbers
= new AtomicIntegerArray(new int[] { 1, 2, 3 });
​
numbers.incrementAndGet(
1); // Increment element at index 1
​
System.out.println("Array after update: "
+ numbers);
System.out.println("Value at index 1: "
+ numbers.get(1));
}
}

Output
Array after update: [1, 3, 3]
Value at index 1: 3
Commonly used methods in Atomic classes
Method	Description
get()	Returns the current value.
set(value)	Sets the value to the given value.
getAndSet(value)	Atomically sets a new value and returns the old one.
incrementAndGet()	Increments the value by one and returns the updated value.
getAndIncrement()	Increments the value by one and returns the previous value.
decrementAndGet()	Decrements the value by one and returns the updated value.
addAndGet(delta)	Adds the specified value and returns the updated result.
getAndAdd(delta)	Adds the specified value and returns the previous result.
compareAndSet(expected, update)	Atomically updates the value only if it equals the expected value.
lazySet(value)	Eventually sets the value (may be delayed for performance).


Using Final Keyword

final Keyword in Java

In Java, the final keyword is used to restrict changes and make code more secure and predictable. It can be applied to variables, methods, and classes to prevent modification, overriding, or inheritance. This helps in creating constant values, stable methods, and immutable classes.

Final variable cannot be changed once assigned
Final method cannot be overridden
Final class cannot be inherited
The following are different contexts where the final is used:

final
final keyword
Characteristics of final keyword in Java
Final variables hold a value that cannot be reassigned after initialization.
Final methods cannot be overridden by subclasses.
Final classes cannot be extended.
Initialization rules require that a final variable must be assigned exactly once either at declaration or inside constructors or initializer blocks.
Reference final variables cannot change which object they point to though the internal state of the object can change.
Static final variables represent constants shared across all objects.
Blank final variables are declared without initialization and must be assigned once before use.
Local final variables inside methods must be initialized within their block.
Ways we use the final keyword in Java
The final keyword is used in exactly 3 main contexts:

1. Final Variable
   A variable declared with final becomes constant after one assignment.





public class Geeks{

    public static void main(String[] args) {
        final double PI = 3.14159;
        System.out.println("Value of PI: " + PI);
    }
}

Output
Value of PI: 3.14159
Types of Final Variables
A variable declared with final becomes constant after one assignment.

1. final Variable

final int THRESHOLD = 5;

2. Blank final Variable

final int THRESHOLD;

Note: A static final variable must be initialized either at the point of declaration or in a static initialization block.

3. Static final Variable

static final double PI = 3.141592653589793;

4. Static Blank final Variable

static final double PI;

static {

    PI = 3.141592653589793;

}

Reference Final Variable
A final reference cannot refer to a new object though the object it points to can change internally.





class Geeks {
public static void main(String[] args) {
final StringBuilder sb = new StringBuilder("Geeks");
System.out.println(sb);
sb.append("ForGeeks");
System.out.println(sb);
}
}

Output
Geeks
GeeksForGeeks
This shows that a final reference cannot point to a different object, but the internal state of the object it points to can still be modified.

Reassigning a Final Variable (Error)

class Geeks {
static final int CAPACITY = 4;

    public static void main(String[] args) {
        CAPACITY = 5; // compile-time error
    }
}
Output:

Final Variable Throwing Compile-time Error

Local Final Variable
A local final variable must be assigned once.





class Geeks {
public static void main(String[] args) {
final int i;
i = 20;
System.out.println(i);
}
}

Output
20
2. Final class
   A class declared as final cannot be extended. A final class cannot be inherited, meaning no other class can extend it. This is commonly used for security or when the implementation should remain unchanged, such as in core classes like String.

Prevents inheritance, ensuring the class behavior cannot be modified
Commonly used for immutable and secure classes

final class A {
// fields and methods
}

// Illegal
class B extends A { }
Final classes are useful when creating immutable classes such as String or wrapper classes.

3. Final Method
   When a method is declared with final keyword, it is called a final method in Java.A final method, on the other hand, can be inherited but cannot be overridden by subclasses, ensuring that the original implementation remains intact.

Cannot be overridden in subclasses
Helps maintain consistent behavior across all derived classes

class A {
final void m1() {
System.out.println("Final method");
}
}

class B extends A {
void m1() { } // compile-time error
}
Advantages of final Keyword
Supports immutability by preventing reassignment
Helps compiler and JVM optimize code in some scenarios
Makes behavior predictable since values or methods stay unchanged
Prevents accidental or unauthorized modification of critical logic
Preserves API contracts by avoiding unwanted overriding

Daemon Threads
Daemon threads are background threads that run to support user threads and automatically terminate when all user threads finish execution.

User vs Daemon Thread

Difference Between Daemon Threads and User Threads In Java

In Java, threads are classified into User Threads and Daemon Threads based on their role in program execution. Understanding the difference between them is important for managing background tasks and application lifecycle.

Threads are categorized based on their role in application execution (foreground or background)
User threads perform primary tasks, while daemon threads run in the background
Daemon threads terminate automatically when user threads finish
Daemon Threads
Daemon threads are background threads that provide support services to user threads. They do not prevent the JVM from exiting when all user threads have completed execution.

Run in the background to support user threads
Automatically terminate when user threads end
Created using setDaemon(true) method




class DaemonThreadExample extends Thread{

    public void run(){
        
        while (true) {
            System.out.println("Daemon thread running...");
        }
    }
​
public static void main(String[] args){

        DaemonThreadExample t1 = new DaemonThreadExample();
        
        // Set as daemon thread
        t1.setDaemon(true); 
        t1.start();
​
System.out.println("Main thread ends");
}
}

Output
Main thread ends
Daemon thread running...
Daemon thread running...
Daemon thread running...
Daemon thread running...
Daemon thread running...
Daemon thread running...
Daemon thread running...
Daemon t...
User Threads
User threads are the main threads that perform the core operations of a program. The JVM continues execution as long as at least one user thread is running.

Perform primary tasks of the application
JVM waits for user threads to finish
Created by default when a thread is instantiated




class UserThreadExample extends Thread{

    public void run(){
        
        System.out.println("User thread is running");
    }
​
public static void main(String[] args) {
UserThreadExample t1 = new UserThreadExample();
t1.start(); // By default, it is a user thread
}
}

Output
User thread is running
Daemon Threads Vs User Threads
Feature	User Thread	Daemon Thread


Purpose	Performs main application tasks	Handles background/support tasks
JVM Behavior	JVM waits for completion	JVM does not wait
Execution	Keeps application running	Stops when user threads end
Creation	Created by default	Must be set using setDaemon(true)
Example	Main thread, worker threads	Garbage Collector, background services


setDaemon()

Java Daemon Thread

A daemon thread is a background thread in Java that supports user threads and does not prevent the JVM from exiting when all user threads finish. It is ideal for background tasks like monitoring, logging, and cleanup.

Runs in the background to support user (non-daemon) threads.
JVM exits automatically when all user threads finish.
Created using the Thread class and marked as daemon with setDaemon(true).
setDaemon(true) must be called before starting the thread, or it throws IllegalThreadStateException.
Common examples: Garbage Collector (GC) and Finalizer Thread.




class MyDaemonThread extends Thread {
public void run() {
System.out.println(getName() + " is running as a daemon thread.");
}
}
​
public class GFG {
public static void main(String[] args) throws InterruptedException {
MyDaemonThread t1 = new MyDaemonThread();
t1.setDaemon(true);  // mark as daemon
t1.setName("Daemon-1");
t1.start();
​
// Give JVM a moment to run daemon thread
Thread.sleep(100);
​
System.out.println("Main thread ends.");
}
}

Output
Daemon-1 is running as a daemon thread.
Main thread ends.
Explanation:

t1 is marked as a daemon thread using setDaemon(true).
Thread.sleep(100) ensures the JVM gives the daemon thread a chance to execute before the main thread finishes.
Once the main thread ends, the JVM terminates all daemon threads automatically.
Syntax
Thread t = new Thread();
t.setDaemon(true); // Mark thread as daemon
t.start();

Methods Used
void setDaemon(boolean on): Marks a thread as daemon or user thread. Must be called before start().
boolean isDaemon(): Checks whether a thread is daemon.
Creating a Daemon Thread




public class DaemonExample extends Thread {
public void run() {
if (Thread.currentThread().isDaemon()) {
System.out.println("Daemon thread running...");
} else {
System.out.println("User thread running...");
}
}
​
public static void main(String[] args) {
DaemonExample t1 = new DaemonExample();
DaemonExample t2 = new DaemonExample();
​
t1.setDaemon(true);  // must be set before start()
​
t1.start();
t2.start();
}
}

Output
Daemon thread running...
User thread running...
Behavior of Daemon Thread




public class DaemonBehavior extends Thread {
public void run() {
while (true) {
System.out.println("Daemon thread running...");
}
}
​
public static void main(String[] args) {
DaemonBehavior t = new DaemonBehavior();
t.setDaemon(true);
t.start();
​
System.out.println("Main (user) thread ends...");
}
}

Output
Main (user) thread ends...
Daemon thread running...
Daemon thread running...
Daemon thread running...
Daemon thread running...
The JVM ends immediately after the main thread finishes, even though the daemon thread is still running.

Notes:

A thread inherits the daemon status of the thread that creates it.
Daemon threads should not be used for tasks requiring completion, such as writing to a file or updating a database.
JVM terminates all daemon threads abruptly without performing cleanup operations.
Use Cases
Garbage Collection: The Garbage Collector (GC) in Java runs as a daemon thread.
Background Monitoring: Daemon threads can monitor the state of application components, resources, or connections.
Logging and Auditing Services: Daemon threads can be used to log background activities continuously.
Cleanup Operations: Daemon threads may periodically clear temporary files, release unused resources, or perform cache cleanup.
Scheduler or Timer Tasks: Background schedulers often use daemon threads to trigger tasks at fixed intervals.


Mutual Exclusion in Synchronization

During concurrent execution of processes, processes need to enter the critical section (or the section of the program shared across processes) at times for execution. It might happen that because of the execution of multiple processes at once, the values stored in the critical section become inconsistent. In other words, the values depend on the sequence of execution of instructions - also known as a race condition. The primary task of process synchronization is to get rid of race conditions while executing the critical section.

What is Mutual Exclusion?
Mutual Exclusion is a property of process synchronization that states that "no two processes can exist in the critical section at any given point of time". The term was first coined by Dijkstra. Any process synchronization technique being used must satisfy the property of mutual exclusion, without which it would not be possible to get rid of a race condition.

The need for mutual exclusion comes with concurrency. There are several kinds of concurrent execution:



Interrupt handlers
Interleaved, preemptively scheduled processes/threads
Multiprocessor clusters, with shared memory
Distributed systems
Mutual exclusion methods are used in concurrent programming to avoid the simultaneous use of a common resource, such as a global variable, by pieces of computer code called critical sections.

The requirement of mutual exclusion is that when process P1 is accessing a shared resource R1, another process should not be able to access resource R1 until process P1 has finished its operation with resource R1.

Examples of such resources include files, I/O devices such as printers, and shared data structures.

Conditions Required for Mutual Exclusion
According to the following four criteria, mutual exclusion is applicable:

When using shared resources, it is important to ensure mutual exclusion between various processes. There cannot be two processes running simultaneously in either of their critical sections.
It is not advisable to make assumptions about the relative speeds of the unstable processes.
For access to the critical section, a process that is outside of it must not obstruct another process.
Its critical section must be accessible by multiple processes in a finite amount of time; multiple processes should never be kept waiting in an infinite loop.
Approaches To Implementing Mutual Exclusion
Software Method: Leave the responsibility to the processes themselves. These methods are usually highly error-prone and carry high overheads.
Hardware Method: Special-purpose machine instructions are used for accessing shared resources. This method is faster but cannot provide a complete solution. Hardware solutions cannot give guarantee the absence of deadlock and starvation.
Programming Language Method: Provide support through the operating system or through the programming language.
Requirements of Mutual Exclusion
At any time, only one process is allowed to enter its critical section.
The solution is implemented purely in software on a machine.
A process remains inside its critical section for a bounded time only.
No assumption can be made about the relative speeds of asynchronous concurrent processes.
A process cannot prevent any other process from entering into a critical section.
A process must not be indefinitely postponed from entering its critical section.
In order to understand mutual exclusion, let's take an example.

What is a Need of Mutual Exclusion?
An easy way to visualize the significance of mutual exclusion is to imagine a linked list of several items, with the fourth and fifth items needing to be removed. By changing the previous node's next reference to point to the succeeding node, the node that lies between the other two nodes is deleted.

To put it simply, whenever node "i" wants to be removed, node "with - 1"'s subsequent reference is changed to point to node "ith + 1" at that time. Two distinct nodes can be removed by two threads at the same time when a shared linked list is being used by many threads. This occurs when the first thread modifies node "ith - 1" next reference, pointing towards the node "ith + 1," and the second thread modifies node "ith" next reference, pointing towards the node "ith + 2." Although both nodes have been removed, the linked list's required state has not yet been reached because node "i + 1" still exists in the list because node "ith - 1" next reference still points to it.

Now, this situation is called a race condition. Race conditions can be prevented by mutual exclusion so that updates at the same time cannot happen to the very bit about the list.

Example:

In the clothes section of a supermarket, two people are shopping for clothes.

Mutual-Exclusion Example

Boy, A decides upon some clothes to buy and heads to the changing room to try them out. Now, while boy A is inside the changing room, there is an 'occupied' sign on it - indicating that no one else can come in. Boy B has to use the changing room too, so she has to wait till boy A is done using the changing room.

Mutual-Exclusion-Example

Once boy A comes out of the changing room, the sign on it changes from 'occupied' to 'vacant' - indicating that another person can use it. Hence, boy B proceeds to use the changing room, while the sign displays 'occupied' again.

The changing room is nothing but the critical section, boy A and boy B are two different processes, while the sign outside the changing room indicates the process synchronization mechanism being used.

Mutual-Exclusion Example

Conclusion
In conclusion, mutual exclusion is a key concept in synchronization that ensures only one process accesses a shared resource at a time. This prevents conflicts and data corruption, making sure that processes run smoothly and correctly. By using mutual exclusion mechanisms, we can create stable and reliable systems that handle multiple processes efficiently.


Deadlock vs Starvation in OS

Deadlock and starvation are two different process-scheduling problems. In a deadlock, processes wait forever because each is holding a resource the other needs. In starvation, some processes wait indefinitely because higher-priority processes monopolise resources.

Deadlock
Deadlock is a condition in an operating system where two or more processes are permanently blocked because each process is waiting for a resource that is held by another process, forming a circular waiting chain, and none of them can proceed.

The 4 conditions for Deadlock:

Mutual Exclusion → Resources cannot be shared.
Hold and Wait → A process holds one resource and waits for another.
No Preemption → Resources cannot be forcibly taken back.
Circular Wait → A circular chain of processes waiting.
Deadlock
Example:

Two cars on a narrow bridge:

Car A enters from left → blocks Car B
Car B enters from right → blocks Car A
Both need the other to move back, but neither can → Deadlock.
Starvation
Starvation is a state that prevents lower-precedence processes from getting the resources. Starvation arises when procedures with critical importance keep on utilizing the resources frequently. Starvation can be cured using a technique that is regarded as aging.

In aging, priority of process increases with time and thus guarantees that poor processes will equally run in the system.

The 4 common causes:

Priority-Based Scheduling – cause of starvation
Indefinite Blocking – cause of starvation
Continuous High-Priority Arrival – cause of starvation
Unequal Resource Allocation – cause of starvation
Priority
Starvation
Example:

CPU Scheduling in a Server

A server uses priority scheduling to handle tasks.
If high-priority requests keep coming from premium users, low-priority tasks (free users) may never get CPU time → Starvation.
Deadlock	                                           Starvation
All processes keep waiting for each other to complete and none get executed	High priority processes keep executing and low priority processes are blocked
Resources are blocked by the processes	Resources are continuously utilized by high priority processes
Necessary conditions Mutual Exclusion, Hold and Wait, No preemption, Circular Wait	Poor implementation of scheduling causes starvation like purely based on priority or random selection.
Also known as Circular wait	Also known as lived lock
It can be prevented by avoiding the necessary conditions for deadlock	It can be prevented by Aging



Concurrency Utilities (java.util.concurrent)
The concurrency package provides tools like Executors, Callable, Future and Thread Pools. These simplify managing multithreaded applications.

Introduction
Callable and Future
Thread Pools
ScheduledExecutorService
