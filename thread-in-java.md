# Complete Tutorial on Threads and Concurrency in Java

## Table of Contents

1. [Introduction to Threads](#introduction-to-threads)
2. [Creating Threads](#creating-threads)
   - [Extending the Thread Class](#extending-the-thread-class)
   - [Implementing the Runnable Interface](#implementing-the-runnable-interface)
3. [Thread Lifecycle](#thread-lifecycle)
4. [Thread States](#thread-states)
5. [Thread Synchronization](#thread-synchronization)
   - [Synchronized Methods](#synchronized-methods)
   - [Synchronized Blocks](#synchronized-blocks)
6. [Concurrency Utilities](#concurrency-utilities)
   - [Executors](#executors)
   - [Callable and Future](#callable-and-future)
   - [Locks](#locks)
7. [Thread Safety](#thread-safety)
8. [Best Practices](#best-practices)
9. [Conclusion](#conclusion)

# In-Depth Guide to the Executor Framework in Java

1. [Introduction to the Executor Framework](#introduction-to-the-executor-framework)
2. [Key Interfaces](#key-interfaces)
   - [Executor](#executor)
   - [ExecutorService](#executorservice)
   - [ScheduledExecutorService](#scheduledexecutorservice)
   - [Callable](#callable)
3. [Core Classes](#core-classes)
   - [ThreadPoolExecutor](#threadpoolexecutor)
   - [ScheduledThreadPoolExecutor](#scheduledthreadpoolexecutor)
   - [Executors Utility Class](#executors-utility-class)
4. [Creating Executors](#creating-executors)
   - [Fixed Thread Pool](#fixed-thread-pool)
   - [Cached Thread Pool](#cached-thread-pool)
   - [Single Thread Executor](#single-thread-executor)
   - [Scheduled Executor](#scheduled-executor)
5. [Using Callable and Future](#using-callable-and-future)
6. [Handling Tasks with Executors](#handling-tasks-with-executors)
   - [Submitting Tasks](#submitting-tasks)
   - [Shutting Down Executors](#shutting-down-executors)
7. [Error Handling in Executors](#error-handling-in-executors)
8. [Best Practices](#best-practices)
9. [Conclusion](#conclusion)

In this post, we will discuss both methods.

# In-Depth Guide to Concurrency and the Executors Framework in Java

## Table of Contents

1. [Introduction to Concurrency](#introduction-to-concurrency)
2. [Understanding Threads](#understanding-threads)
   - [Thread Lifecycle](#thread-lifecycle)
   - [Thread States](#thread-states)
3. [Introduction to the Executors Framework](#introduction-to-the-executors-framework)
4. [Key Interfaces in the Executors Framework](#key-interfaces-in-the-executors-framework)
   - [Executor](#executor)
   - [ExecutorService](#executorservice)
   - [ScheduledExecutorService](#scheduledexecutorservice)
   - [Callable](#callable)
5. [Core Classes in the Executors Framework](#core-classes-in-the-executors-framework)
   - [ThreadPoolExecutor](#threadpoolexecutor)
   - [ScheduledThreadPoolExecutor](#scheduledthreadpoolexecutor)
   - [Executors Utility Class](#executors-utility-class)
6. [Creating Executors](#creating-executors)
   - [Fixed Thread Pool](#fixed-thread-pool)
   - [Cached Thread Pool](#cached-thread-pool)
   - [Single Thread Executor](#single-thread-executor)
   - [Scheduled Executor](#scheduled-executor)
7. [Using Callable and Future](#using-callable-and-future)
8. [Handling Tasks with Executors](#handling-tasks-with-executors)
   - [Submitting Tasks](#submitting-tasks)
   - [Shutting Down Executors](#shutting-down-executors)
9. [Error Handling in Executors](#error-handling-in-executors)
10. [Concurrency Utilities](#concurrency-utilities)
    - [Locks](#locks)
    - [Concurrent Collections](#concurrent-collections)
11. [Best Practices](#best-practices)
12. [Conclusion](#conclusion)

## Introduction to Threads

In Java, a thread is a lightweight process that allows concurrent execution of two or more parts of a program. Each thread has its own stack, but shares the heap memory with other threads. This is useful for tasks that can run independently and can improve the performance of applications, especially those that are I/O bound or have long-running computations.

## Creating Threads

### Extending the Thread Class

You can create a thread by extending the `Thread` class and overriding its `run()` method.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Starts the thread
    }
}
```

### Implementing the Runnable Interface

Alternatively, you can implement the `Runnable` interface, which allows you to define a thread without extending the `Thread` class.

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable thread is running.");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start(); // Starts the thread
    }
}
```

## Thread Lifecycle

A thread can exist in various states during its lifecycle. The lifecycle of a thread is managed by the Java Virtual Machine (JVM) and includes:

1. **New**: The thread is created but not yet started.
2. **Runnable**: The thread is ready to run and is waiting for CPU time.
3. **Blocked**: The thread is waiting for a resource that is currently held by another thread.
4. **Waiting**: The thread is waiting indefinitely for another thread to perform a particular action.
5. **Timed Waiting**: The thread is waiting for another thread to perform an action for up to a specified waiting time.
6. **Terminated**: The thread has completed its execution.

## Thread States

You can get the current state of a thread using the `getState()` method.

```java
Thread thread = new Thread(new MyRunnable());
System.out.println("Thread state: " + thread.getState()); // NEW
thread.start();
System.out.println("Thread state: " + thread.getState()); // RUNNABLE
```

## Thread Synchronization

To prevent thread interference and ensure data consistency, you need to synchronize access to shared resources.

### Synchronized Methods

You can declare a method as synchronized, which ensures that only one thread can execute it at a time.

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
}
```

### Synchronized Blocks

Synchronized blocks offer more fine-grained control over synchronization by allowing you to synchronize only a portion of a method.

```java
public void increment() {
    synchronized (this) {
        count++;
    }
}
```

## Concurrency Utilities

Java provides a rich set of concurrency utilities in the `java.util.concurrent` package.

### Executors

The `Executor` framework simplifies thread management by abstracting thread creation and management.

```java
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submit(new MyRunnable());
executor.shutdown();
```

### Callable and Future

Unlike `Runnable`, `Callable` can return a result and throw checked exceptions.

```java
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        return 42; // Some computation
    }
}

ExecutorService executor = Executors.newFixedThreadPool(1);
Future<Integer> future = executor.submit(new MyCallable());
System.out.println(future.get()); // Blocks until result is available
executor.shutdown();
```

### Locks

Explicit locks provide more flexibility than synchronized methods and blocks.

```java
Lock lock = new ReentrantLock();
lock.lock();
try {
    // critical section
} finally {
    lock.unlock();
}
```

## Thread Safety

Thread safety ensures that shared data is accessed and modified safely by multiple threads. Common strategies for achieving thread safety include:

- **Immutable Objects**: Objects that cannot be modified after creation.
- **Thread-Local Variables**: Variables that are accessible only by the thread that created them.
- **Using Concurrency Utilities**: Classes like `ConcurrentHashMap`, `CopyOnWriteArrayList`, etc.

## Best Practices

- Use higher-level concurrency utilities like `Executors` instead of managing threads manually.
- Minimize shared mutable data.
- Keep synchronized blocks and methods as short as possible.
- Use `volatile` keyword for variables that are accessed by multiple threads without synchronization.

## Conclusion

Java's threading and concurrency model allows developers to create robust applications that can perform multiple tasks simultaneously. By understanding the concepts of threads, synchronization, and concurrency utilities, you can effectively manage resources and ensure the thread safety of your applications. Always remember to follow best practices to create efficient and maintainable multithreaded applications.

## Introduction to the Executor Framework

The Executor Framework, introduced in Java 5, provides a higher-level API for managing threads and asynchronous task execution. It decouples task submission from the mechanics of how each task will be run, including details like thread pooling, task scheduling, and resource management. This framework simplifies the complexities of thread management, making it easier to write concurrent applications.

## Key Interfaces

### Executor

The `Executor` interface is the simplest interface for task execution. It has a single method, `execute(Runnable command)`, that accepts a `Runnable` task for execution.

```java
public interface Executor {
    void execute(Runnable command);
}
```

### ExecutorService

The `ExecutorService` interface extends `Executor` and adds more features, such as lifecycle management, task submission, and retrieving results.

```java
public interface ExecutorService extends Executor {
    <T> Future<T> submit(Callable<T> task);
    Future<?> submit(Runnable task);
    List<Runnable> shutdownNow();
    void shutdown();
}
```

### ScheduledExecutorService

The `ScheduledExecutorService` interface extends `ExecutorService` to support the execution of tasks after a given delay or periodically.

```java
public interface ScheduledExecutorService extends ExecutorService {
    ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
    ScheduledFuture<?> schedule(Callable<V> callable, long delay, TimeUnit unit);
    ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
    ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
}
```

### Callable

The `Callable` interface is similar to `Runnable` but can return a result and throw checked exceptions.

```java
public interface Callable<V> {
    V call() throws Exception;
}
```

## Core Classes

### ThreadPoolExecutor

The `ThreadPoolExecutor` class is a versatile implementation of the `ExecutorService` interface. It provides thread pooling capabilities and allows for fine-tuning of thread pool parameters.

```java
public class ThreadPoolExecutor extends AbstractExecutorService {
    // Constructors and methods for core functionality
}
```

**Key Parameters:**
- `corePoolSize`: Number of threads to keep in the pool.
- `maximumPoolSize`: Maximum number of threads allowed in the pool.
- `keepAliveTime`: Time for which excess idle threads will wait for new tasks.
- `BlockingQueue<Runnable> workQueue`: Queue for holding tasks before they are executed.

### ScheduledThreadPoolExecutor

The `ScheduledThreadPoolExecutor` is a subclass of `ThreadPoolExecutor` that implements the `ScheduledExecutorService` interface. It supports both periodic and delayed execution of tasks.

```java
public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor {
    // Constructors and methods for scheduling tasks
}
```

### Executors Utility Class

The `Executors` utility class provides factory methods for creating different types of executor services.

```java
public class Executors {
    public static ExecutorService newFixedThreadPool(int nThreads);
    public static ExecutorService newCachedThreadPool();
    public static ExecutorService newSingleThreadExecutor();
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize);
}
```

## Creating Executors

### Fixed Thread Pool

A fixed-size thread pool that reuses a fixed number of threads.

```java
ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
```

### Cached Thread Pool

A thread pool that creates new threads as needed and reuses previously constructed threads when they are available.

```java
ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
```

### Single Thread Executor

An executor that uses a single worker thread to execute tasks. This is useful when you want to ensure that tasks are executed sequentially.

```java
ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
```

### Scheduled Executor

A scheduled executor that can be used for executing tasks with a fixed delay or at a specified rate.

```java
ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);
```

## Using Callable and Future

You can use `Callable` with `ExecutorService` to submit tasks that return results.

```java
Callable<Integer> task = () -> {
    // Simulate some computation
    return 42;
};

Future<Integer> future = executorService.submit(task);
Integer result = future.get(); // Blocks until the result is available
```

## Handling Tasks with Executors

### Submitting Tasks

You can submit tasks using the `submit()` method of `ExecutorService`.

```java
Runnable task = () -> System.out.println("Running a task");
Future<?> future = executorService.submit(task);
```

### Shutting Down Executors

It’s important to properly shut down the executor to release resources. You can do this using the `shutdown()` method.

```java
executorService.shutdown(); // Initiates an orderly shutdown
try {
    if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        executorService.shutdownNow(); // Force shutdown if tasks are not finished
    }
} catch (InterruptedException e) {
    executorService.shutdownNow(); // Re-cancel if the current thread is interrupted
}
```

## Error Handling in Executors

When using `Callable`, exceptions thrown within the task can be retrieved via the `Future` object. 

```java
try {
    Integer result = future.get(); // This will throw ExecutionException if the task fails
} catch (ExecutionException e) {
    System.out.println("Task failed with exception: " + e.getCause());
}
```

## Best Practices

1. **Use Thread Pooling**: Avoid creating new threads for every task. Use thread pools to manage threads efficiently.
2. **Shutdown Executors**: Always shutdown executors properly to avoid resource leaks.
3. **Handle Exceptions**: Always check for exceptions when using `Future` to ensure that task failures are handled.
4. **Choose the Right Executor**: Depending on the use case, choose the appropriate type of executor (fixed, cached, single-threaded, scheduled).
5. **Avoid Blocking Calls**: Be cautious with blocking calls in executor tasks, as they can lead to performance issues.

## Conclusion

The Executor Framework in Java simplifies the management of concurrent tasks and thread execution. By providing a higher-level abstraction over thread management, it allows developers to focus on the logic of their applications rather than the intricacies of thread lifecycle management. Understanding the different types of executors, how to submit tasks, and proper error handling will enable you to build efficient and robust concurrent applications.

# How To Stop A Thread In Java?

How do you stop a thread in Java? This has become a popular question in Java interviews, especially since the `stop()` method has been deprecated for safety reasons. Interviewers are often interested in the logic you will use to stop a thread. There are two main ways to stop a thread in Java:

1. Using a boolean variable
2. Using the `interrupt()` method

## Introduction to Concurrency

Concurrency refers to the ability of a program to execute multiple tasks simultaneously. In Java, this is achieved through multithreading, which allows several threads to run in parallel. Concurrency is essential for improving the efficiency of applications, especially those that are I/O-bound or require parallel processing.

## Understanding Threads

### Thread Lifecycle

A thread undergoes several states during its lifecycle, managed by the Java Virtual Machine (JVM):

1. **New**: The thread is created but not yet started.
2. **Runnable**: The thread is ready to run and is waiting for CPU time.
3. **Blocked**: The thread is waiting for a resource held by another thread.
4. **Waiting**: The thread is waiting indefinitely for another thread to perform a particular action.
5. **Timed Waiting**: The thread is waiting for another thread to perform an action for up to a specified time.
6. **Terminated**: The thread has completed its execution.

### Thread States

You can check the current state of a thread using the `getState()` method.

```java
Thread thread = new Thread(new MyRunnable());
System.out.println("Thread state: " + thread.getState()); // NEW
thread.start();
System.out.println("Thread state: " + thread.getState()); // RUNNABLE
```

## Introduction to the Executors Framework

The Executors Framework, introduced in Java 5, provides a higher-level API for managing threads and executing tasks asynchronously. It decouples task submission from the mechanics of how each task will be run, including thread pooling, scheduling, and resource management.

## Key Interfaces in the Executors Framework

### Executor

The `Executor` interface is the simplest interface for task execution. It has a single method, `execute(Runnable command)`, that accepts a `Runnable` task for execution.

```java
public interface Executor {
    void execute(Runnable command);
}
```

### ExecutorService

The `ExecutorService` interface extends `Executor` and adds methods for lifecycle management, task submission, and result retrieval.

```java
public interface ExecutorService extends Executor {
    <T> Future<T> submit(Callable<T> task);
    Future<?> submit(Runnable task);
    List<Runnable> shutdownNow();
    void shutdown();
}
```

### ScheduledExecutorService

The `ScheduledExecutorService` interface extends `ExecutorService` to support delayed and periodic task execution.

```java
public interface ScheduledExecutorService extends ExecutorService {
    ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
    ScheduledFuture<?> schedule(Callable<V> callable, long delay, TimeUnit unit);
    ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
    ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
}
```

### Callable

The `Callable` interface represents a task that can return a result and can throw checked exceptions.

```java
public interface Callable<V> {
    V call() throws Exception;
}
```

## Core Classes in the Executors Framework

### ThreadPoolExecutor

The `ThreadPoolExecutor` class is a versatile implementation of the `ExecutorService` interface, providing thread pooling capabilities.

**Key Parameters:**
- `corePoolSize`: Number of threads to keep in the pool.
- `maximumPoolSize`: Maximum number of threads allowed in the pool.
- `keepAliveTime`: Time for which excess idle threads will wait for new tasks.
- `BlockingQueue<Runnable> workQueue`: Queue for holding tasks before they are executed.

### ScheduledThreadPoolExecutor

The `ScheduledThreadPoolExecutor` is a subclass of `ThreadPoolExecutor` that implements the `ScheduledExecutorService` interface, allowing for scheduling tasks.

### Executors Utility Class

The `Executors` utility class provides factory methods for creating different types of executor services.

```java
public class Executors {
    public static ExecutorService newFixedThreadPool(int nThreads);
    public static ExecutorService newCachedThreadPool();
    public static ExecutorService newSingleThreadExecutor();
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize);
}
```

## Creating Executors

### Fixed Thread Pool

A fixed-size thread pool that reuses a fixed number of threads.

```java
ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
```

### Cached Thread Pool

A thread pool that creates new threads as needed and reuses previously constructed threads.

```java
ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
```

### Single Thread Executor

An executor that uses a single worker thread to execute tasks.

```java
ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
```

### Scheduled Executor

A scheduled executor that can be used for executing tasks with a fixed delay or at a specified rate.

```java
ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);
```

## Using Callable and Future

You can use `Callable` with `ExecutorService` to submit tasks that return results.

```java
Callable<Integer> task = () -> {
    // Simulate some computation
    return 42;
};

Future<Integer> future = executorService.submit(task);
Integer result = future.get(); // Blocks until the result is available
```

## Handling Tasks with Executors

### Submitting Tasks

You can submit tasks using the `submit()` method of `ExecutorService`.

```java
Runnable task = () -> System.out.println("Running a task");
Future<?> future = executorService.submit(task);
```

### Shutting Down Executors

It’s important to properly shut down the executor to release resources.

```java
executorService.shutdown(); // Initiates an orderly shutdown
try {
    if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        executorService.shutdownNow(); // Force shutdown if tasks are not finished
    }
} catch (InterruptedException e) {
    executorService.shutdownNow(); // Re-cancel if the current thread is interrupted
}
```

## Error Handling in Executors

When using `Callable`, exceptions thrown within the task can be retrieved via the `Future` object. 

```java
try {
    Integer result = future.get(); // This will throw ExecutionException if the task fails
} catch (ExecutionException e) {
    System.out.println("Task failed with exception: " + e.getCause());
}
```

## Concurrency Utilities

Java provides various utilities in the `java.util.concurrent` package to aid in concurrency:

### Locks

Locks provide more control than synchronized methods and blocks, allowing finer granularity and greater flexibility.

```java
Lock lock = new ReentrantLock();
lock.lock();
try {
    // Critical section
} finally {
    lock.unlock();
}
```

### Concurrent Collections

Java offers thread-safe collections like `ConcurrentHashMap`, `CopyOnWriteArrayList`, and others designed for concurrent access.

```java
ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("key", 1);
```

## Best Practices

1. **Use Thread Pooling**: Prefer using executor services over manual thread management.
2. **Shutdown Executors**: Always ensure proper shutdown to release resources.
3. **Handle Exceptions**: Be prepared to handle exceptions when using `Future`.
4. **Choose the Right Executor**: Select the appropriate type of executor based on the workload.
5. **Avoid Blocking Calls**: Minimize blocking operations within tasks to improve throughput.

## Conclusion

The Executors Framework in Java significantly simplifies the complexities of thread management and concurrency. By providing a higher-level abstraction, it allows developers to focus on the application's logic while efficiently managing task execution. Understanding the various components of the Executors Framework and concurrency utilities is essential for building scalable and robust concurrent applications in Java.
## How To Stop A Thread In Java Using A Boolean Variable

In this method, we declare a boolean variable called `flag` in the thread. Initially, we set this flag to `true`. We keep the task to be performed in a `while` loop inside the `run()` method, which continues to run until the flag becomes `false`. We define a `stopRunning()` method that sets the flag to `false`, effectively stopping the thread. Additionally, we declare the flag as `volatile` to ensure that the thread reads its value from main memory, ensuring it always gets the updated value.

```java
class MyThread extends Thread {
    // Initially setting the flag as true
    private volatile boolean flag = true;

    // This method will set flag to false
    public void stopRunning() {
        flag = false;
    }

    @Override
    public void run() {
        // Keep the task in while loop
        // This will make the thread continue to run until flag becomes false
        while (flag) {
            System.out.println("I am running....");
        }
        System.out.println("Stopped Running....");
    }
}

public class MainClass {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Call stopRunning() method whenever you want to stop the thread
        thread.stopRunning();
    }
}
```

### Output:

```
I am running….
I am running….
...
I am running….
Stopped Running….
```

## How To Stop A Thread In Java Using the `interrupt()` Method

In this method, we use the `interrupt()` method to stop a thread. Whenever you call the `interrupt()` method on a thread, it sets the interrupted status of the thread. This status can be checked using the `interrupted()` method. The status is then used in a `while` loop to stop the thread.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("I am running....");
        }
        System.out.println("Stopped Running.....");
    }
}

public class MainClass {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Interrupting the thread
        thread.interrupt();
    }
}
```

### Output:

```
I am running….
I am running….
...
I am running….
Stopped Running….
``` 

Both methods provide effective ways to manage thread lifecycle in Java, but using `interrupt()` is generally preferred in modern Java programming practices.
