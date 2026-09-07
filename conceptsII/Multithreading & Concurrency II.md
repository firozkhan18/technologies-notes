Java.util.concurrent.Executor interface with Examples
Last Updated :
9 Apr, 2026
The Executor interface in Java provides a high-level mechanism to execute tasks asynchronously without directly managing threads. It acts as a replacement for manually creating and controlling Thread objects. Executors submit Runnable tasks for execution and manage the underlying threads efficiently.

Simplifies thread management and decouples task submission from execution.
Can execute tasks in a new thread, pooled thread, or the calling thread.
Forms the foundation for higher-level concurrency utilities like ExecutorService and ScheduledExecutorService.
Declaration Syntax
public interface Executor {
void execute(Runnable command);
}





import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
​
public class ExecutorDemo {
public static void main(String[] args) {
ExecutorImp obj = new ExecutorImp();
try {
obj.execute(new NewThread());
} catch (RejectedExecutionException | NullPointerException exception) {
System.out.println(exception);
}
}
}
​
class ExecutorImp implements Executor {
@Override
public void execute(Runnable command) {
new Thread(command).start();  // Starts the task in a new thread
}
}
​
class NewThread implements Runnable {
@Override
public void run() {
System.out.println("Thread executed under an executor");
}
}

Output
Thread executed under an executor
Explanation: ExecutorImp implements the Executor interface and overrides execute() to run the task in a new thread. When execute() is called, the NewThread task runs and prints the message.

Executor Interface Class Hierarchy:
These are the common classes that implement Executor or its sub-interfaces to provide thread pooling and scheduling features.

executorinterface_hierarchy
Hierarchy
Implementing Classes
AbstractExecutorService: Base class implementing ExecutorService providing common methods.
ForkJoinPool: Executes tasks that can be broken into smaller subtasks (supports work-stealing).
ScheduledThreadPoolExecutor: Executes tasks after a given delay or periodically.
ThreadPoolExecutor: Manages a pool of worker threads for executing tasks efficiently.
Implementing Sub-Interfaces of Executor
The Executor interface has two main sub-interfaces that extend its functionality:

1. ExecutorService

Provides methods to manage thread life cycle, submit tasks, and get results.
Allows submitting both Runnable and Callable tasks.
2. ScheduledExecutorService

Extends ExecutorService to allow scheduling tasks with a delay or at fixed intervals.
Useful for periodic tasks like timers, scheduled updates, or repeated background jobs.
Method of Executor interface:
execute(Runnable command): Submits a task for execution. The task may run in a new thread, a thread pool, or the calling thread.





import java.util.concurrent.Executor;
​
public class MultiTaskExecutorDemo {
public static void main(String[] args) {
Executor executor = new SimpleExecutor();
​
// Submitting three tasks to executor
executor.execute(() -> System.out.println("Task 1 executed"));
executor.execute(() -> System.out.println("Task 2 executed"));
executor.execute(() -> System.out.println("Task 3 executed"));
}
}
​
// Custom executor implementing Executor interface
class SimpleExecutor implements Executor {
@Override
public void execute(Runnable task) {
new Thread(task).start(); // Runs each task in a separate thread
}
}

Output
Task 1 executed
Task 2 executed
Task 3 executed
Explanation: SimpleExecutor implements the Executor interface and overrides execute() to start each submitted task in a new thread. We submit three tasks using lambda expressions, and each prints a message asynchronously.

Callable vs Future in Java
Last Updated :
25 Apr, 2026
In Java, multithreading allows tasks to run concurrently, improving performance and responsiveness. Traditionally, developers used the Runnable interface to define tasks, but it has two major limitations: it cannot return a result and cannot throw checked exceptions. To overcome these, Java introduced the Callable and Future interfaces in Java 5.

Callable executes a task and returns a result with exception handling
Future represents the result of a Callable task and retrieves it later
Callable Interface
The Callable interface represents a task that can return a result and throw checked exceptions. It is an alternative to Runnable when a task needs to produce an output.

Defines the call() method for task execution
Allows checked exceptions during execution
Commonly used with Future to retrieve results




import java.util.concurrent.*;
​
public class CallableExample {
public static void main(String[] args) throws Exception {
ExecutorService executor = Executors.newSingleThreadExecutor();
​
Callable<Integer> task = () -> {
int sum = 0;
for (int i = 1; i <= 5; i++) sum += i;
return sum;  // returns result
};
​
Future<Integer> future = executor.submit(task);
​
System.out.println("Result: " + future.get());
executor.shutdown();
}
}

Output
Result: 15
Explanation: A Callable task is submitted to the executor. It calculates the sum of numbers from 1 to 5 and returns the result. The result is retrieved using future.get() after the task finishes.

Future Interface
The Future interface represents the outcome of an asynchronous task and allows you to interact with it after submission to an ExecutorService.

Acts as a handle to track task status
get() retrieves the result (blocks until completion)
isDone() checks if the task has finished




import java.util.concurrent.*;
​
public class CallableFutureExample {
public static void main(String[] args) {
ExecutorService executor = Executors.newSingleThreadExecutor();
​
Future<Integer> future = executor.submit(() -> 10 + 20);
​
try {
Integer result = future.get(); // waits but returns instantly
System.out.println("Result: " + result);
} catch (Exception e) {
e.printStackTrace();
} finally {
executor.shutdown();
}
}
}

Output
Result: 30
Explanation: This code creates a single-thread executor to run a task asynchronously using Callable. The task calculates the sum of 10 and 20, and the result is stored in a Future object. Using future.get(), the program retrieves the result (30), and finally shuts down the executor to free resources.

Callable vs Future
Table showing difference between callable and future.

Feature	Callable	Future
Purpose	Represents a task that returns a result	Represents the result of an asynchronous task
Return Type	Returns a result when executed	Holds the result returned by a Callable
Defined In	java.util.concurrent package	java.util.concurrent package
Execution	Submitted to ExecutorService	Returned by ExecutorService.submit()
Methods	Has one method call()	Has methods like get(), isDone(), cancel()
Exception Handling	Can throw checked exceptions	Handles results and exceptions after execution
Usage	Defines what to execute	Controls, monitors, and retrieves the result of a task


Thread Pool in Java
Last Updated :
15 Jun, 2026
A Thread Pool is a collection of reusable worker threads managed by an Executor Service. Depending on the implementation, a thread pool may maintain a fixed number of threads, dynamically create threads as needed, use a single worker thread, or schedule tasks for future execution. When a task is submitted:

If a thread is free, it immediately picks up the task and runs it.
If all threads are busy, the task waits in a queue until a thread becomes available.
After finishing a task, the thread does not die. It goes back to the pool and waits for the next task.
Real World Analogy
Think of a call center:

A company has 10 operators (thread pool size = 10).
When customers call, available operators handle them.
If all operators are busy, new customers wait in a queue until someone is free.
Operators don’t leave after one call, they stay and handle more calls.
Common Types of Thread Pools in Java
Thread Pool Type	Description
Fixed Thread Pool	Uses a fixed number of worker threads.
Cached Thread Pool	Creates threads as needed and reuses idle threads.
Single Thread Executor	Uses only one worker thread.
Scheduled Thread Pool	Executes tasks after a delay or periodically.
Work-Stealing Pool	Uses multiple queues to improve parallel task execution.
Thread Pool Initialization
When we initialize a thread pool:

A fixed number of worker threads are created (e.g., 3).
These threads are kept idle, waiting for tasks.
A task queue is set up to hold submitted tasks until a worker is free.
Thread Pool Working
Here is the step by step working of thread pool.

Step 1: Idle State
Tasks are submitted and placed in the Task Queue.
Worker threads exist but are idle until work arrives.
Thread-Pool-1
Thread Pool Initialization with size = 3 threads. Task Queue = 5
Step 2: Task Assignment
Each idle thread picks a task from the queue.
Example: Thread 1 -> Task 1, Thread 2 -> Task 2, Thread 3 -> Task 3
Remaining tasks (Task 4, Task 5) wait in the queue.
Thread-Pool-2
Thread Pool executing first three tasks
Step 3: Thread Reuse
Once a thread completes its current task, it becomes idle again.
It immediately takes the next waiting task from the queue.
Example: Thread 1 -> Task 4, Thread 2 -> Task 5, Thread 3 -> Idle (no tasks left)
Thread-Pool-3
Thread Pool executing task 4 and 5
Code Example: Simple Thread Pool

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Worker thread that executes tasks
class Worker extends Thread {
private final BlockingQueue<Runnable> taskQueue;
private static final Runnable POISON_PILL = () -> {};

    public Worker(BlockingQueue<Runnable> queue, String name) {
        super(name);
        this.taskQueue = queue;
    }

    public void run() {
        try {
            while (true) {
                Runnable task = taskQueue.take();

                if (task == POISON_PILL) {
                    break; // stop worker
                }

                try {
                    task.run();
                } catch (Exception e) {
                    System.out.println("Task error: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Thread Pool Implementation
class SimpleThreadPool {
private final BlockingQueue<Runnable> taskQueue;
private final Worker[] workers;
private volatile boolean isShutdown = false;
private static final Runnable POISON_PILL = () -> {};

    public SimpleThreadPool(int poolSize) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Worker[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker(taskQueue, "Worker-" + (i + 1));
            workers[i].start();
        }
    }

    // Submit task
    public void submit(Runnable task) throws InterruptedException {
        if (!isShutdown) {
            taskQueue.put(task); // safer than offer()
        } else {
            throw new IllegalStateException("ThreadPool is shutdown");
        }
    }

    // Shutdown pool gracefully
    public void shutdown() {
        isShutdown = true;

        // Send stop signal to all workers
        for (int i = 0; i < workers.length; i++) {
            try {
                taskQueue.put(POISON_PILL);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Wait for workers to finish
        for (Worker worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Test Program
public class ThreadPoolDemo {
public static void main(String[] args) {
SimpleThreadPool pool = new SimpleThreadPool(3);

        try {
            for (int i = 1; i <= 5; i++) {
                int taskId = i;

                pool.submit(() -> {
                    System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        pool.shutdown();
        System.out.println("All tasks completed.");
    }
}
Output:

Screenshot-2025-08-19-115518
Output
Benefits of Thread Pool
Better Performance: Threads are reused instead of being created and destroyed repeatedly.
Faster Response Time: Tasks don’t need to wait for a new thread to be created.
Reusability: Threads remain alive after finishing tasks and are reused for future tasks.
Resource Management: Limits the number of concurrent threads, preventing OutOfMemoryError or CPU overload.
Thread Pool methods
Here is the table of thread pool methods.

Method	Purpose
submit(Runnable task)	Adds a task into the queue for execution by worker threads.
shutdown()	Gracefully stops the thread pool → no new tasks accepted, workers stop after finishing current tasks.
shutdownNow() (optional)	Immediately interrupts workers and clears pending tasks.
getQueueSize() (optional)	Returns how many tasks are waiting in the queue.
getActiveCount() (optional)	Returns number of threads currently executing tasks.


ScheduledExecutorService Interface in Java
Last Updated :
9 Apr, 2026
ScheduledExecutorService is used to schedule tasks to run after a delay or at fixed intervals in Java. It is part of the java.util.concurrent package and extends ExecutorService. It helps in managing background and periodic task execution efficiently.

Executes tasks after delay or periodically
Uses thread pool for better performance
More flexible and reliable than Timer
Declaration
public interface ScheduledExecutorService extends ExecutorService





import java.util.concurrent.*;
import java.util.*;
import java.io.*;
​
class SchedulerExecutorServiceExample {

    public static void main(String[] args)
    {
        System.out.println(
            "A count-down-clock program that counts from 10 to 0");
​
// creating a ScheduledExecutorService object
ScheduledExecutorService scheduler
= Executors.newScheduledThreadPool(11);
​
// printing the current time
System.out.println(
"Current time : "
+ Calendar.getInstance().get(Calendar.SECOND));
​
// Scheduling the tasks
for (int i = 10; i >= 0; i--) {
scheduler.schedule(new Task(i), 10 - i,
TimeUnit.SECONDS);
}
​
// remember to shutdown the scheduler
// so that it no longer accepts
// any new tasks
scheduler.shutdown();
}
}
​
class Task implements Runnable {
private int num;
public Task(int num) { this.num = num; }
public void run()
{
System.out.println(
"Number " + num + " Current time : "
+ Calendar.getInstance().get(Calendar.SECOND));
}
}
Output:

A count-down-clock program that counts from 10 to 0
Current time : 28
Number 10 Current time : 28
Number 9 Current time : 29
Number 8 Current time : 30
Number 7 Current time : 31
Number 6 Current time : 32
Number 5 Current time : 33
Number 4 Current time : 34
Number 3 Current time : 35
Number 2 Current time : 36
Number 1 Current time : 37
Number 0 Current time : 38

Explanation: This example demonstrates a countdown clock from 10 to 0 using ScheduledExecutorService. A scheduler is created using Executors.newScheduledThreadPool(), and tasks are scheduled with delays of (10 - i) seconds.

Note: Execution time may vary depending on the system clock.

The Hierarchy of ScheduledExecutorService
It extends ExecutorService, which extends Executor, enabling scheduling of tasks with delays or at fixed intervals.

executor
ScheduledExecutorService
Implementing class: The implementing class of ScheduledExecutorService is ScheduledThreadPoolExecutor.

Creating a ScheduledExecutorService Object
ScheduledExecutorService is an interface, so it cannot be instantiated directly.
The Executors class (from java.util.concurrent package) provides factory methods to create its objects.
Factory (Overloaded)Methods of ScheduledExecutorService:
1.newScheduledThreadPool(int corePoolSize)
Creates a scheduled thread pool with the given corePoolSize
Returns a ScheduledExecutorService object
This object can be downcasted to ScheduledThreadPoolExecutor
Used to: Execute tasks after a delay and Execute tasks periodically
Syntax:

public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)


2. newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory)
   Creates a scheduled thread pool with the given corePoolSize
   Returns a ScheduledExecutorService object
   The ThreadFactory: Is used to create new threads and Allows customization (thread name, priority, etc.)
   Can also be downcasted to ScheduledThreadPoolExecutor
   Syntax:

public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory)

Methods of ScheduledExecutorService
METHOD

DESCRIPTION

schedule(Runnable command, long delay, TimeUnit unit)	Submits a one-shot task that becomes enabled after the given delay.
schedule​(Callable<V> callable, long delay, TimeUnit unit)	Submits a value-returning one-shot task that becomes enabled after the given delay.
scheduleAtFixedRate​(Runnable command, long initialDelay, long period, TimeUnit unit)	Submits a periodic action that becomes enabled first after the given initial delay, and subsequently with the given period; that is, executions will commence after initialDelay, then initialDelay + period, then initialDelay + 2 * period, and so on.
scheduleWithFixedDelay​(Runnable command, long initialDelay, long delay, TimeUnit unit)	Submits a periodic action that becomes enabled first after the given initial delay, and subsequently with the given delay between the termination of one execution and the commencement of the next.
Methods declared in interface java.util.concurrent.Executor
METHOD

DESCRIPTION

execute​(Runnable command)	Executes the given command at some time in the future.
Methods declared in interface java.util.concurrent.ExecutorService
METHOD

DESCRIPTION

awaitTermination​(long timeout, TimeUnit unit)	Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
invokeAll​(Collection<? extends Callable<T>> tasks)	Executes the given tasks, returning a list of Futures holding their status and results when all complete.
invokeAll​(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)	Executes the given tasks, returning a list of Futures holding their status and results when all complete or the timeout expires, whichever happens first.
invokeAny​(Collection<? extends Callable<T>> tasks)	Executes the given tasks, returning the result of one that has completed successfully (i.e., without throwing an exception), if any do.
invokeAny​(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)	Executes the given tasks, returning the result of one that has completed successfully (i.e., without throwing an exception), if any do before the given timeout elapses.
isShutdown()	Returns true if this executor has been shut down.
isTerminated()	Returns true if all tasks have completed following shut down.
shutdown()	Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
shutdownNow()	Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
submit​(Runnable task)	Submits a Runnable task for execution and returns a Future representing that task.
submit​(Runnable task, T result)	Submits a Runnable task for execution and returns a Future representing that task.
submit​(Callable<T> task)	Submits a value-returning task for execution and returns a Future representing the pending results of the task.


Java.util.concurrent.ExecutorService Interface with Examples
Last Updated :
13 May, 2022
The ExecutorService interface extends Executor by adding methods that help manage and control the execution of threads. It is defined in java.util.concurrent package. It defines methods that execute the threads that return results, a set of threads that determine the shutdown status. The ExecutorService interface is implemented in a utility class called Executors. It defines methods that provide an implementation of the ExecutorService interface and many other interfaces, with some default settings.

The class hierarchy is as follows:

--> java.util.concurrent Package
--> Interface ExecutorService Class

Note: ScheduledExecutorService is Implementing Sub-Interfaces and classes implemented are as follows:


AbstractExecutorService
ForkJoinPool
ScheduledThreadPoolExecutor
ThreadPoolExecutor
Methods in Executor Interface
Method	Action Performed
awaitTermination()	Waits for all the tasks to complete their execution after a shutdown request is found. It waits for the time specified by the timelimit argument
invokeAll()	Executes all the tasks contained in the collection. The list of Future objects is returned which contains the status and return values of the various tasks
invokeAny()	Executes all the tasks contained in the collection. On completion of any single task it returns its result and all the other tasks are canceled.
isShutdown()	Tells whether the invoking executor is shut down or not. Returns true if shutdown otherwise returns false
isTerminated()	Checks if all the tasks have been completed post-shutdown. Return true if completed, otherwise returns false.
shutdown()	Causes all the currently executing tasks to terminate after completion in the order in which they were started and rejects any new incoming tasks.
shutdownNow()	Forcefully terminates all the tasks, regardless of their current state i.e running, waiting, or ready. The lists of tasks were in a ready state in return.
submit()	Adds a task that returns a result to the list of executing tasks for execution. It returns a Future object which returns the result of the task after completion
Implementation: Executors


// Java Program to Demonstrate ExecutorService Interface

// Importing required classes
import java.util.concurrent.*;

// Class
// Main class
public class SimpleExecutor {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating objects of CountDownLatch class
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);

        // Creating objects of ExecutorService class
        ExecutorService es
            = Executors.newFixedThreadPool(2);

        // Display message only for better readability
        System.out.println("Starting");

        // Executing the tasks 
        es.execute(new MyThread(cd1, "A"));
        es.execute(new MyThread(cd2, "B"));
        es.execute(new MyThread(cd3, "C"));
        es.execute(new MyThread(cd4, "D"));

        // Try block to check for exceptions
        try {

            // Waiting for tasks to complete
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        }

        // Catch block to handle exceptions
        catch (InterruptedException e) {
          
            System.out.println(e);
        }

        // Making all current executing threads to terminate
        es.shutdown();

        // Display message only for better readability
        System.out.println("Done");
    }
}

// Class 2
// Helper class
class MyThread implements Runnable {

    // Class data members
    String name;
    CountDownLatch latch;

    // Constructor
    MyThread(CountDownLatch latch, String name)
    {

        // this keyword refers to current instance itself
        this.name = name;
        this.latch = latch;

        new Thread(this);
    }

    // Method
    // Called automatically when thread is started
    public void run()
    {

        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
Output:

Click to enlarge


Difference between ExecutorService execute() and submit() method in Java
Last Updated :
15 Jul, 2025
The ExecutorService interface extends Executor by adding methods that help manage and control the execution of threads. It is defined in java.util.concurrent package. It defines methods that execute the threads that return results, a set of threads and that determine the shutdown status. In this article, we will see the difference between the two such methods called execute() and submit().


In Java, in order to perform asynchronous tasks, the runnable interface is implemented. In order to do this, one such interface available is the Executor interface. The executor interface contains the execute() method. Apart from that, there is another interface available which is the ExecutorService interface which extends the executor interface. This interface contains the submit() method. The following image illustrates the relationship between these two interfaces.





Execute Method: This function executes the given command at some time in the future. The command may execute in a new thread, in a pooled thread, or in the calling thread, at the discretion of the Executor implementation. This method is a void method meaning it doesn't return any function. Once the task is assigned in the execute() method, we won't get any response and we can forget about the task. The following is an implementation of the execute method.





// Java program to demonstrate
// the behavior of the
// execute() method
​
import java.util.concurrent.*;
public class GFG {
​
public static void main(String[] args)
throws Exception
{
​
// Creating the object of the
// Executor Service
ExecutorService executorService
= Executors.newSingleThreadExecutor();
​
// execute() method cannot return
// anything because it's return type
// is void.
​
// By using execute(), we are accepting
// a Runnable task
executorService.execute(new Runnable() {
​
// Override the run method
public void run()
{
System.out.println(
"This is execute() "
+ "method example");
}
});
​
// This method performs all the
// previously submitted tasks
// before termination
executorService.shutdown();
}
}
Output:




Submit Method: This function executes the given command at some time in the future. The command may execute in a new thread, in a pooled thread, or in the calling thread, at the discretion of the Executor implementation. Unlike the execute method, this method returns a future. In Java, the future represents the result of an asynchronous computation. The future object is used to handle the task after the execution has started. Therefore, when we need the result of the execution, then we can use the submit() method of the future object. In order to get the result, we can use the get() methods on the Future. The get() method returns an object if we call the get() method before the task has completed, it will block until the result is ready and may throw checked exception or if the task is completed, then the future object holds a result which is returned which can then be used later. The following is an implementation of the submit method:





// Java program to demonstrate
// the behavior of the
// submit() method
​
import java.util.concurrent.*;
public class GFG {
public static void main(String[] args)
throws Exception
{
​
// Creating the object of the
// Executor service interface
ExecutorService executorService
= Executors.newFixedThreadPool(1);
​
// submit() method can return the
// result of the computation
// because it has a return type of Future.
​
// By using submit(), we are
// accepting a Callable task
Future obj
= executorService.submit(new Callable() {
​
// Overriding the call method
public Object call()
{
System.out.println(
"This is submit() "
+ "method example");
​
return "Returning Callable "
+ "Task Result";
}
});
​
// This method will return the result
// if the task has finished perfectly.
// The submit() method returns a
// Java Future object which is
// used to check when the Runnable
// has completed.
// As it implements Future,
// get() method is called
// to get the result
System.out.println(obj.get());
executorService.shutdown();
}
}
Output:



The following table demonstrates the difference between the execute method and the submit method:


Execute Method	Submit Method
This method is declared in the Executor interface.	This method is declared in the ExecutorService interface.
This method can accept only runnable task. 	This method can accept both runnable and callable tasks.
This method has a return type of void.	This method has a return type of Future.
This method is used when we are not bothered about the result but want the code to run in parallel by the worker threads of the thread pool.	This method is used when we care about the result and need it from the task which has been executed.



ScheduledThreadPoolExecutor Class in Java
Last Updated :
15 Jul, 2025
ScheduledThreadPoolExecutor class in Java is a subclass of ThreadPoolExecutor class defined in java.util.concurrent package. As it is clear from its name that this class is useful when we want to schedule tasks to run repeatedly or to run after a given delay for some future time.  It creates a fixed-sized Thread Pool. So when it is initiated, it needs to be given the corePoolSize (the number of threads in the Thread pool).

Class Hierarchy:

ScheduledThreadPoolExecutor-Class-in-Java
Constructors:

ScheduledThreadPoolExecutor(int corePoolSize) : Creates a new ScheduledThreadPoolExecutor object with the given pool size. It is to be noted that it creates a fixed-sized Thread Pool so once the corePoolSize is given, one can not increase the size of the Thread Pool.
ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) : Creates a new ScheduledThreadPoolExecutor object with the given parameters. The first parameter is the size of the Thread Pool and the second parameter is a ThreadFactory object that is used when the ScheduledThreadPoolExecutor creates a new thread.
ScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler): Creates a new ScheduledThreadPoolExecutor object with the given corePoolSize(ThreadPool size) and the handler that is used when the execution of a task is rejected (when the working queue is full or execution is blocked).
ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler): Creates a new ScheduledThreadPoolExecutor object with the given parameters.
Besides these constructors, there is another way to get a ScheduledThreadPoolExecutor object. We can use Executors.newScheduledThreadPool(int corePoolSize) factory method defined by Executors class. It returns a ScheduledExecutorService object which can be type-casted to ScheduledThreadPoolExecutor object.

ScheduledThreadPoolExecutor threadPool = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(4);

Example 1:





// Java program to demonstrates ScheduleThreadPoolExecutor
// class
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
​
class GFG {
public static void main(String[] args)
{
​
// Creating a ScheduledThreadPoolExecutor object
ScheduledThreadPoolExecutor threadPool
= new ScheduledThreadPoolExecutor(2);
​
// Creating two Runnable objects
Runnable task1 = new Command("task1");
Runnable task2 = new Command("task2");
​
// Printing the current time in seconds
System.out.println(
"Current time : "
+ Calendar.getInstance().get(Calendar.SECOND));
​
// Scheduling the first task which will execute
// after 2 seconds
threadPool.schedule(task1, 2, TimeUnit.SECONDS);
​
// Scheduling the second task which will execute
// after 5 seconds
threadPool.schedule(task2, 5, TimeUnit.SECONDS);
​
// Remember to shut sown the Thread Pool
threadPool.shutdown();
}
}
​
// Class that implements the Runnable interface
class Command implements Runnable {
String taskName;
public Command(String taskName)
{
this.taskName = taskName;
}
public void run()
{
System.out.println(
"Task name : " + this.taskName + " Current time: "
+ Calendar.getInstance().get(Calendar.SECOND));
}
}

Output :

Current time : 51
Task name : task1 Current time : 53
Task name : task2 Current time : 56
Here the first task is executed after a two seconds delay and the second task is executed after the five seconds.

Example 2:





// Java program to demonstrates ScheduleThreadPoolExecutor
// class
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
​
class GFG {
public static void main(String[] args)
{
​
// Creating a ScheduledThreadPoolExecutor object
ScheduledThreadPoolExecutor threadPool
= new ScheduledThreadPoolExecutor(2);
​
// Creating two Runnable objects
Runnable task1 = new Command("task1");
Runnable task2 = new Command("task2");
​
// Printing the current time in seconds
System.out.println(
"Current time:"
+ Calendar.getInstance().get(Calendar.SECOND));
​
// Scheduling the first task which will execute
// after 2 seconds and then repeats periodically with
// a period of 8 seconds
threadPool.scheduleAtFixedRate(task1, 2, 8,
TimeUnit.SECONDS);
​
// Scheduling the second task which will execute
// after 5 seconds and then there will be a delay of
// 5 seconds between the completion
// of one execution and the commencement of the next
// execution
threadPool.scheduleWithFixedDelay(task2, 5, 5,
TimeUnit.SECONDS);
​
// Wait for 30 seconds
try {
Thread.sleep(30000);
}
catch (Exception e) {
e.printStackTrace();
}
​
// Remember to shut sown the Thread Pool
threadPool.shutdown();
}
}
​
// Class that implements Runnable interface
class Command implements Runnable {
String taskName;
public Command(String taskName)
{
this.taskName = taskName;
}
public void run()
{
try {
System.out.println("Task name : "
+ this.taskName
+ " Current time : "
+ Calendar.getInstance().get(
Calendar.SECOND));
Thread.sleep(2000);
System.out.println("Executed : " + this.taskName
+ " Current time : "
+ Calendar.getInstance().get(
Calendar.SECOND));
}
catch (Exception e) {
e.printStackTrace();
}
}
}

Output :

Current time:26
Task name : task1 Current time : 28
Executed : task1 Current time : 30
Task name : task2 Current time : 31
Executed : task2 Current time : 33
Task name : task1 Current time : 36
Executed : task1 Current time : 38
Task name : task2 Current time : 38
Executed : task2 Current time : 40
Task name : task1 Current time : 44
Task name : task2 Current time : 45
Executed : task1 Current time : 46
Executed : task2 Current time : 47
Task name : task1 Current time : 52
Task name : task2 Current time : 52
Executed : task1 Current time : 54
Executed : task2 Current time : 54
Here, the first task will execute after the two seconds and then repeats periodically after the eight seconds. The second task will execute after the five seconds and then there will be a delay of five seconds between the completion of one execution and the commencement of the next execution.

Methods
METHOD

DESCRIPTION

decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task)	Modifies or replaces the task used to execute a callable.
decorateTask(Runnable runnable, RunnableScheduledFuture<V> task)	Modifies or replaces the task used to execute a runnable.
execute(Runnable command)	Executes command with zero required delay.
getContinueExistingPeriodicTasksAfterShutdownPolicy( )	Get the policy on whether to continue executing existing periodic tasks even when this executor has been shut down.
getExecuteExistingDelayedTasksAfterShutdownPolicy( )	Get the policy on whether to execute existing delayed tasks even when this executor has been shut down.
getQueue()	Returns the task queue used by this executor.
getRemoveOnCancelPolicy()	Gets the policy on whether cancelled tasks should be immediately removed from the work queue at the time of cancellation.
schedule(Callable<V> callable, long delay, TimeUnit unit)	Creates and executes a ScheduledFuture that becomes enabled after the given delay.
schedule(Runnable command, long delay, TimeUnit unit)	Creates and executes a one-shot action that becomes enabled after the given delay.
scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)	Creates and executes a periodic action that becomes enabled first after the given delay and subsequently with the given period.
scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)	Creates and executes a periodic action that becomes enabled after the given delay and subsequently with the given delay between the termination of one execution and commencement of the next execution.
setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value)	Sets the policy on whether to continue executing existing periodic tasks even when this executor has been shut down.
setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value)	Sets the policy on whether to execute existing delayed tasks even when this executor has been shut down.
setRemoveOnCancelPolicy()	Sets the policy on whether cancelled tasks should be immediately removed from the work queue at the time of cancellation.
shutdown()	Initiate an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
shutdownNow()	Attempts to stop all actively executing tasks halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
submit(Callable<T> task)	Submits a value returning task for execution and returns a future representing the pending results of the task.
submit(Runnable task)	Submits a runnable task for execution and returns a future representing that task.
submit(Runnable task, T result)	Submits a runnable task for execution and returns a future representing that task.


Callable interface in Java
Last Updated :
1 Nov, 2025
The Callable interface is a part of the java.util.concurrent package, introduced in Java 5. It represents a task that can be executed by multiple threads and return a result. Unlike the Runnable interface, Callable can return a value and throw checked exceptions.

Used with ExecutorService for asynchronous or concurrent execution.
The result of a Callable is obtained using a Future object.
It’s a functional interface, so you can use lambda expressions.
Syntax
public interface Callable<V> {
V call() throws Exception;
}

Here:

V -> The type of result returned by the call() method.
call() -> The method that performs the computation and returns a result. It can throw a checked exception.

import java.util.concurrent.*;

public class GFG{

    public static void main(String[] args) throws Exception{
        
        // Create an ExecutorService with a single thread
        ExecutorService executor
            = Executors.newSingleThreadExecutor();

        // Create a Callable task using Lambda Expression
        Callable<Integer> task = () ->{
            System.out.println("Calculating...");
            Thread.sleep(1000);
            return 10 * 2;
        };

        // Submit the task and get a Future object
        Future<Integer> future = executor.submit(task);

        // Retrieve the result from the Future
        System.out.println("Result: " + future.get());

        // Shutdown the executor
        executor.shutdown();
    }
}
Output:

output
output
Explanation:

A single-threaded ExecutorService is created to run a task.
The Callable task prints "Calculating...", waits 1 second, and returns 20.
The task is submitted using executor.submit(task), which returns a Future object.
future.get() waits for the task to finish and retrieves the result (20).
Finally, the executor is shut down to release resources.
Methods of Callable Interface
Although Callable has only one abstract method (call()), it works closely with the Future and ExecutorService interfaces.

V call(): It performs the task and returns a result of type V.
Future<V>: The Future object allows checking if the task is complete, getting the result, or canceling it.
ExecutorService.submit(Callable<V>): Submits a Callable task for execution and returns a Future representing the pending result.
Example: Multiple Callable Tasks





import java.util.*;
import java.util.concurrent.*;
​
public class GFG {
​
public static void main(String[] args) throws Exception{

        ExecutorService executor
            = Executors.newFixedThreadPool(3);
​
// Create multiple Callable tasks
List<Callable<String> > tasks
= List.of(()
-> "Task 1 completed",
()
-> "Task 2 completed",
() -> "Task 3 completed");
​
// Execute all tasks and get a list of Future
// objects
List<Future<String> > results
= executor.invokeAll(tasks);
​
// Print results
for (Future<String> f : results) {
System.out.println(f.get());
}
​
executor.shutdown();
}
}

Output
Task 1 completed
Task 2 completed
Task 3 completed
Explanation: All tasks are submitted together using invokeAll(). The method waits for all tasks to finish and then returns their results in the same order.

Runnable vs Callable
Feature	Runnable	Callable
Return Type	Does not return any value (void run())	Returns a value (V call())
Exception Handling	Cannot throw checked exceptions	Can throw checked exceptions
Method Used	void run()	V call()
Execution Method	Executed using Thread or Executor.execute()	Submitted using ExecutorService.submit() which returns a Future
Use Case	Used for tasks that just need to run	Used for tasks that need to return a result


Future Interface in Java
Last Updated :
1 Nov, 2025
The Future interface is a part of java.util.concurrent package, introduced in Java 5. It represents the result of an asynchronous computation, a value that will be available in the future after the task completes.

Future interface used to check the status of a task (completed, running, or cancelled).
It allows retrieving the result of a Callable once it’s done.
Supports cancellation of tasks that are still running.
Declaration
public interface Future<V>

Here, V -> The type of result returned by the asynchronous computation.


import java.util.concurrent.*;

public class GFG{

    public static void main(String[] args) throws Exception{

        // Create an ExecutorService
        ExecutorService executor
            = Executors.newSingleThreadExecutor();

        // Define a Callable task
        Callable<Integer> task = () ->
        {
            System.out.println("Processing...");
            Thread.sleep(1000);
            return 10 * 5;
        };

        // Submit the task and get a Future object
        Future<Integer> future = executor.submit(task);

        // Check if task is done
        System.out.println("Task completed? "
                           + future.isDone());

        // Retrieve the result
        System.out.println("Result: " + future.get());

        // Check again
        System.out.println("Task completed? "
                           + future.isDone());

        // Shutdown the executor
        executor.shutdown();
    }
}
Output:

output
output
Explanation:

A single-threaded executor is created to run a task.
The task sleeps for 1 second and returns 50.
Before completion, isDone() returns false.
After the result is retrieved using get(), it returns true.
Finally, the executor is shut down.
Methods of Future Interface
cancel(boolean mayInterruptIfRunning): Cancels the execution of the task if possible.
isCancelled(): Returns true if the task was cancelled before completion.
isDone(): Returns true if the task is completed or cancelled.
V get(): Waits (if needed) and returns the computed result.
V get(long timeout, TimeUnit unit): Waits up to the given time and returns the result if available.
Example: Canceling a Task


import java.util.concurrent.*;

public class GFG {

    public static void main(String[] args) throws Exception{

        ExecutorService executor
            = Executors.newSingleThreadExecutor();

        Callable<String> task = () ->
        {
            Thread.sleep(2000);
            return "Task Completed";
        };

        Future<String> future = executor.submit(task);

        // Cancel the task before it finishes
        boolean cancelled = future.cancel(true);
        System.out.println("Task cancelled? " + cancelled);

        executor.shutdown();
    }
}
Output:

output
output
Callable vs Future
Feature	Callable	Future
Purpose	Represents a task that returns a result	Represents the result of an asynchronous task
Return Type	Returns a result when executed	Holds the result of the Callable
Execution	Submitted to ExecutorService	Returned by ExecutorService.submit()
Methods	Has one method — call()	Has methods like get(), isDone(), cancel()
Usage	Defines what to execute	Controls and monitors the task execution

