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
# How To Stop A Thread In Java?

How do you stop a thread in Java? This has become a popular question in Java interviews, especially since the `stop()` method has been deprecated for safety reasons. Interviewers are often interested in the logic you will use to stop a thread. There are two main ways to stop a thread in Java:

1. Using a boolean variable
2. Using the `interrupt()` method

In this post, we will discuss both methods.

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
