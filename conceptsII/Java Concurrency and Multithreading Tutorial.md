# Java Concurrency and Multithreading Tutorial

## Java Concurrency Tutorial Videos
- [Java Concurrency & Multithreading - Video Playlist](link-to-your-video-playlist)

## What is Multithreading?
Multithreading allows multiple threads of execution within a single application, effectively enabling concurrent execution. Each thread can be thought of as a separate CPU executing parts of the program simultaneously.

### Key Points:
- A thread shares CPU time, meaning a single CPU can execute multiple threads by switching between them.
- Threads can also run on different CPUs or CPU cores, enhancing performance.

## Why Multithreading?
### Benefits of Multithreading:
1. **Better Utilization of a Single CPU**
   - While one thread waits for a response (e.g., network request), another can use the CPU for other tasks.
  
2. **Better Utilization of Multiple CPUs or CPU Cores**
   - Multiple threads enable the application to utilize all available CPU resources effectively.

3. **Better User Experience with Responsiveness**
   - Background threads can handle tasks (like network requests) without freezing the GUI, improving user experience.

4. **Better User Experience with Fairness**
   - Multithreading allows fairer resource sharing among users, preventing one long task from monopolizing the CPU.

## Multithreading vs. Multitasking
- **Multitasking**: Multiple programs (tasks) executed by switching the CPU's focus among them. Early systems often struggled to manage multiple programs due to limited resources.
  
- **Multithreading**: Multiple threads execute within a single program, allowing for more efficient execution and resource utilization.

## Challenges of Multithreading
Multithreading can enhance performance but introduces complexity:
- Threads share the same memory space, leading to potential errors.
- Proper precautions are necessary to manage shared resources to avoid unpredictable behaviors.

## Multithreading and Concurrency in Java
Java has supported multithreading since its inception, making it a key focus for developers. This tutorial will cover various aspects of concurrency and multithreading in Java, addressing common challenges and solutions.

### Concurrency Models
Java initially adopted a **shared state concurrency model**, where multiple threads share objects. This can lead to complex concurrency problems. An alternative **shared nothing** model avoids these issues by ensuring threads do not share data.

## Java Concurrency Study Guide
For those new to Java concurrency, follow this structured study plan:

### General Concurrency and Multithreading Theory:
- Benefits of Multithreading
- Costs of Multithreading
- Concurrency Models
- Concurrency vs. Parallelism

### Basics of Java Concurrency:
- Creating and Starting Java Threads
- Race Conditions and Critical Sections
- Thread Safety and Shared Resources
- Java Memory Model
- Synchronized Blocks and the `volatile` Keyword
- Java ThreadLocal and Signaling

### Common Problems in Java Concurrency:
- Deadlock and Prevention
- Starvation and Fairness
- False Sharing and Thread Congestion

### Concurrency Constructs in Java:
- Locks, Read/Write Locks, Semaphores
- Blocking Queues
- Thread Pools

### Java Concurrency Utilities:
- Overview of `java.util.concurrent`

### Further Topics:
- Anatomy of a Synchronizer
- Non-blocking Algorithms
- Amdahl's Law

---

# Multithreading Benefits

The most significant benefits of multithreading are:

1. Better CPU utilization
2. Simpler program design in some situations
3. More responsive programs
4. More fair distribution of CPU resources

---

## Better CPU Utilization
Consider an application that reads and processes files from the local file system. If reading a file takes 5 seconds and processing it takes 2 seconds, the total time for two files processed sequentially would be:

- 5 seconds reading file A  
- 2 seconds processing file A  
- 5 seconds reading file B  
- 2 seconds processing file B  
-----------------------  
**Total: 14 seconds**

In this scenario, the CPU is mostly idle while waiting for disk I/O. By reordering the operations, we can improve CPU utilization:

- 5 seconds reading file A  
- 5 seconds reading file B + 2 seconds processing file A  
- 2 seconds processing file B  
-----------------------  
**Total: 12 seconds**

In this case, while the CPU waits for the second file to be read, it processes the first file, leading to better overall CPU usage. This principle applies not just to disk I/O, but also to network I/O and user input, which are often slower than CPU and memory operations.

---

## Simpler Program Design
If you were to implement the above operation in a single-threaded application, you would need to manage the reading and processing states for each file. However, using multithreading allows you to create a thread for each file, simplifying the design:

- Each thread reads and processes a single file, blocking only while waiting for I/O.
- This keeps the CPU busy processing parts of files that have already been read, improving both CPU and disk utilization.

---

## More Responsive Programs
Multithreading can also enhance application responsiveness. For instance, in a server application:

```java
while (server is active) {
    listen for request;
    process request;
}
```

If processing a request takes a long time, new requests cannot be handled until the current one is complete. A better design uses a worker thread to handle requests:

```java
while (server is active) {
    listen for request;
    hand request to worker thread;
}
```

This allows the server thread to return to listening sooner, enabling it to accept new requests and become more responsive. The same applies to GUI applications where long tasks can be offloaded to worker threads, keeping the UI responsive.

---

## More Fair Distribution of CPU Resources
In a server scenario where a single long request can block others, multithreading allows for better resource distribution. Instead of a single-threaded server:

- If one request takes 10 seconds, all following requests must wait until it's processed.

With multithreading, the server can process multiple requests concurrently. Even if one request is slow, faster requests can be handled without delay, improving overall responsiveness. When only the slow request is present, the CPU can still be allocated solely to it.

---

# Multithreading Costs

## More Complex Design
While some parts of a multithreaded application can be simpler than a single-threaded application, others introduce significant complexity. Specifically, code executed by multiple threads that accesses shared data requires careful management. Thread interaction can be intricate, and errors arising from incorrect thread synchronization are often difficult to detect, reproduce, and fix.

## Context Switching Overhead
When a CPU switches from executing one thread to another, it must save the current thread's state (including local data and program pointers) and load the next thread's state. This process is known as a **context switch**. Context switching is resource-intensive, and excessive switching can degrade performance.

For more details on context switching, you can refer to [Wikipedia](http://en.wikipedia.org/wiki/Context_switch).

## Increased Resource Consumption
Each thread consumes system resources, including CPU time and memory for its stack. Additionally, the operating system requires resources to manage these threads. For example, creating a program with 100 threads that merely waits can lead to significant memory usage. This overhead should be considered when designing applications with many threads.

---

# Concurrency Models

## Concurrency Models and Distributed System Similarities
The concurrency models described here are similar to architectures used in distributed systems. In concurrent systems, threads communicate with each other, while in distributed systems, processes do so (often on different computers). Although the probability of failure may be lower in concurrent systems, they can experience similar issues like CPU or network card failures. Thus, concurrency models often borrow ideas from distributed systems.

## Shared State vs. Separate State
- **Shared State**: Threads share data, which can lead to race conditions and deadlocks.
- **Separate State**: Threads do not share data, communicating instead through immutable objects or copies, thus avoiding many concurrency problems.

## Parallel Workers
In the **parallel workers model**, jobs are assigned to different workers who complete the full job in parallel. This model is commonly used in Java applications.

### Parallel Workers Advantages
- **Simplicity**: Easy to understand and scale by adding more workers.
  
### Parallel Workers Disadvantages
- **Complexity with Shared State**: Managing access to shared data can become complicated, leading to issues like contention and deadlocks.
- **Stateless Workers**: Workers re-read shared state, which can slow performance.
- **Nondeterministic Job Ordering**: The order of job execution can vary, complicating system reasoning.

## Assembly Line
The **assembly line concurrency model** organizes workers like an assembly line in a factory, where each worker performs part of a job and forwards it to the next.

### Reactive, Event Driven Systems
These systems react to events, such as incoming requests. Popular platforms include Vert.x, Akka, and Node.js.

### Actors vs. Channels
- **Actors**: Workers communicate by sending messages asynchronously.
- **Channels**: Workers publish messages on channels, allowing others to listen without direct knowledge of the sender.

### Assembly Line Advantages
- **No Shared State**: Workers can be implemented without concurrency issues.
- **Stateful Workers**: Workers can keep data in memory, improving performance.
- **Better Hardware Conformity**: Single-threaded code often aligns better with hardware capabilities.
- **Job Ordering**: Possible to guarantee job order for easier state management.

### Assembly Line Disadvantages
- **Code Complexity**: Execution is spread over multiple workers, making it harder to trace the code.
- **Callback Hell**: Nested callbacks can complicate code readability and data access.

## Functional Parallelism
This model uses function calls, treating them as independent agents. It allows for parallel execution but requires careful coordination of function calls across CPUs.

## Which Concurrency Model is Best?
The best model depends on the system requirements:
- Use the **parallel worker model** for naturally parallel, independent jobs.
- For jobs that are not independent, the **assembly line model** offers more advantages.

For modern applications, exploring platforms like Vert.x may provide a better edge compared to traditional Java EE approaches.

---

# Same-threading

## Single-threaded and Same-threaded Designs Tutorial Video
If you prefer video, I have a video version of this tutorial here: [Single-threaded and Same-threaded Designs](#).

## Why Single-threaded Systems?
Single-threaded systems are gaining popularity because their concurrency models are much simpler than multi-threaded systems. They do not share any state (objects/data) with other threads, enabling the use of non-concurrent data structures and better utilization of CPU and CPU caches.

However, single-threaded systems do not fully utilize modern CPUs, which often come with multiple cores. A single-threaded system can only utilize one core.

## Same-threading: Single-threading Scaled Out
To utilize all the cores in a CPU, a single-threaded system can be scaled out to run multiple instances in parallel.

### One Thread Per CPU
Typically, a same-threaded system runs one thread per CPU core. For example, if a computer has four cores, it would run four instances of the same-threaded system.

### No Shared State
The key distinction between same-threaded and traditional multi-threaded systems is that the threads in a same-threaded system do not share state. There is no shared memory or concurrent data structures, which allows each thread to behave like a single-threaded system.

### Load Distribution
To effectively distribute the workload among single-threaded instances, you must implement a strategy that ensures no single thread is overwhelmed with work.

## Single-threaded Microservices
Microservices are a great fit for same-threaded systems. Each microservice can operate in single-threaded mode, allowing multiple services to run on the same machine, each utilizing one CPU thread.

## Services With Sharded Data
If your system requires data sharing, consider sharding your database. Sharding involves dividing data across multiple databases, ensuring related data resides together.

## Thread Communication
In a same-threaded system, threads communicate through message passing. For instance, if Thread A sends a message to Thread B, it generates a byte sequence that Thread B can copy and read. This ensures that Thread A cannot modify the message while Thread B processes it.

### Thread Communication Illustration
![Thread communication via messaging in a same-threaded system.](#)

## Simpler Concurrency Model
Each thread in a same-threaded system can be implemented as if it were single-threaded. This simplifies the internal concurrency model, eliminating concerns about concurrent data structures and their associated problems.

## Illustrations
Here are illustrations to help visualize the differences between system types:

1. **Single-threaded System**
   ![A single-threaded system.](#)

2. **Multi-threaded System**
   ![A multi-threaded system.](#)

3. **Same-threaded System**
   ![A same-threaded system with 2 threads with separate data, communicating by passing messages to each other.](#)

## Thread Ops for Java
[Thread Ops for Java](#) is an open-source toolkit designed to help implement separate state same-threaded systems. It provides tools for starting and stopping individual threads, as well as achieving concurrency within a single thread. If you're interested in same-threaded application designs, consider exploring Thread Ops further.

---

# Single-threaded Concurrency

## Overview
Single-threaded concurrency allows a single thread to make progress on multiple tasks simultaneously by switching between them. This approach contrasts with classic multi-threaded concurrency, where each task typically runs in its own thread. This tutorial explores the benefits, challenges, and designs of single-threaded concurrency.

## Single-threaded Concurrency is Still New Ground
Research on single-threaded concurrency is limited, with most existing frameworks (like Node.js and Netty) using event loops. While effective, these models may not suit all workloads, prompting the need for alternative designs.

## Classic Multi-threaded Concurrency
In classic multi-threaded designs, tasks are assigned to separate threads. Each thread executes one task at a time, leading to potential concurrency issues such as race conditions and deadlocks when tasks share data.

## Single-threaded or Same-threaded Concurrency
In a single-threaded concurrency design, you manage task switching yourself. You can also scale to multiple threads where each behaves as an isolated single-threaded system, referred to as a same-threaded architecture.

## Benefits of Single-threaded Concurrency
### Full Thread Visibility
Single-threaded designs avoid visibility issues associated with multi-threaded systems, ensuring that updates to shared data structures are immediately visible.

### No Race Conditions
With only one thread accessing data at a time, race conditions are eliminated.

### Control Over Task Switching
You decide when to switch tasks, allowing for sensible states before switching and enabling optimized chunk sizes for work increments.

### Control Over Task Prioritization
You can prioritize tasks by controlling the amount of CPU time allocated to each task, allowing more important tasks to progress faster.

## Challenges of Single-threaded Concurrency
### Implementation Required
You must implement task switching, which requires knowledge and adds some complexity to your codebase. However, reusable designs can minimize overhead.

### Blocking Operations
Blocking operations can hinder progress, requiring you to handle such tasks in background threads, reverting to multi-threading for those specific cases.

### Single CPU Utilization
A single thread can only utilize one CPU. To take advantage of multi-core systems, you need to scale up to a same-threaded design.

## Single-threaded Concurrency Designs
### Thread Loops
Thread loops are common in long-running applications, where the main thread waits for input, processes it, and repeats the cycle.

### Pausing the Thread Loop
To conserve CPU resources, a thread can "sleep" during idle periods, reducing unnecessary CPU usage.

### Agents
Agents are components that perform the application logic. They can run for various durations and are responsible for executing tasks.

### Task Switching
To allow progress on multiple tasks, each task must be split into smaller increments, enabling the thread to switch between them effectively.

#### Increment Size Balancing
Tasks must be divided into appropriately sized increments to ensure fair CPU time distribution.

#### Prioritized Execution
You can implement prioritization by specifying how many increments each task should execute before switching.

#### Agent Parking
Agents waiting for asynchronous operations can "park" themselves to avoid unnecessary calls until the operation completes.

## Scaling Single-threaded Concurrency
To utilize multiple CPUs, scale your design to include multiple threads, each designed as a single-threaded system. This approach allows you to maintain the simplicity of single-threaded concurrency while benefiting from multi-core systems.

## Event Loops vs. Thread Loops
### Event Loops
In event loops, the control flow is dictated by incoming events, limiting application flexibility.

### Thread Loops
Thread loops provide more control, allowing the application to manage tasks and handle events at its discretion. This enables backpressure and more efficient use of CPU time.

## Conclusion
Single-threaded concurrency offers a simpler alternative to multi-threaded designs, avoiding many concurrency issues. While challenges exist, thoughtful design can harness its benefits effectively.

---
# Concurrency vs. Parallelism

## Introduction
The terms **concurrency** and **parallelism** are often used interchangeably in discussions about multithreaded applications, but they refer to distinct concepts. This tutorial clarifies these differences within the context of a single application.

## Concurrency
Concurrency refers to an application's ability to make progress on multiple tasks simultaneously (or seemingly so). When a computer has a single CPU, it cannot execute tasks at the exact same time but can switch between them quickly, creating the illusion of simultaneous execution.

**Illustration**: In a single-threaded application, the CPU rapidly switches between tasks, allowing them to progress concurrently.

## Parallel Execution
Parallel execution occurs when a system has multiple CPUs or cores, enabling it to process multiple tasks simultaneously. This allows different threads to run at the same time, achieving true parallelism.

**Illustration**: Each CPU executes its assigned thread, processing tasks simultaneously.

## Parallel Concurrent Execution
This combines both concepts: multiple threads are distributed among multiple CPUs. Threads running on the same CPU execute concurrently, while those on different CPUs run in parallel.

**Illustration**: Threads assigned to different CPUs operate simultaneously, while those on the same CPU may switch between tasks.

## Parallelism
Parallelism is a specific approach where a task is divided into smaller subtasks that can be processed simultaneously. For effective parallelism, these subtasks should run on separate threads across different CPUs or cores.

**Illustration**: A larger task split into smaller parts, with each part handled by a different thread on separate CPUs.

## Combinations of Concurrency and Parallelism
### 1. Concurrent, Not Parallel
An application can make progress on multiple tasks concurrently without executing them in parallel. This occurs when a single-threaded program switches between tasks without using multiple threads.

### 2. Parallel, Not Concurrent
An application may execute one task at a time while breaking it into smaller subtasks that run in parallel. Each task is completed before the next begins.

### 3. Neither Concurrent Nor Parallel
In this scenario, an application works on one task at a time without breaking it into subtasks, typical of simple command-line applications.

### 4. Concurrent and Parallel
An application can exhibit both characteristics:
- **Simple Parallel Concurrent Execution**: Multiple threads running on multiple CPUs.
- **Concurrent and Parallel Execution**: The application processes multiple tasks concurrently, while also breaking each task into subtasks that can run in parallel.

## Conclusion
Understanding the distinction between concurrency and parallelism is crucial for designing efficient applications. Both concepts can coexist and complement each other, but their combined use requires careful analysis to avoid potential performance issues. Always measure and analyze before adopting a concurrent parallel model to ensure it suits your application's needs.

---
# Creating and Starting Java Threads

## Introduction
In Java, threads act like virtual CPUs that execute code concurrently within an application. The Java Virtual Machine (JVM) creates a main thread to run the `main()` method, and developers can create additional threads to run parts of the application in parallel.

## Creating and Starting Threads
To create a thread in Java, you can use the following code:

```java
Thread thread = new Thread();
```

To start the thread, call its `start()` method:

```java
thread.start();
```

This code does not specify any task for the thread, so it will terminate immediately.

## Defining What a Thread Executes
There are two main ways to define what code a thread should run:

### 1. Subclassing Thread
You can create a subclass of `Thread` and override its `run()` method. For example:

```java
public class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread running");
    }
}

// Creating and starting the thread
MyThread myThread = new MyThread();
myThread.start();
```

### 2. Implementing Runnable
Alternatively, you can implement the `Runnable` interface, which has a single method `run()`. Here’s how to do it:

#### Java Class Implements Runnable
```java
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("MyRunnable running");
    }
}

// Creating and starting the thread
Runnable runnable = new MyRunnable();
Thread thread = new Thread(runnable);
thread.start();
```

#### Anonymous Implementation of Runnable
You can also create an anonymous implementation:

```java
Runnable myRunnable = new Runnable() {
    public void run() {
        System.out.println("Runnable running");
    }
};

Thread thread = new Thread(myRunnable);
thread.start();
```

#### Java Lambda Implementation of Runnable
With Java 8 and later, you can use a lambda expression:

```java
Runnable runnable = () -> {
    System.out.println("Lambda Runnable running");
};

Thread thread = new Thread(runnable);
thread.start();
```

### Subclass vs. Runnable
Both methods are valid, but using `Runnable` is often preferred for flexibility, especially when working with thread pools.

### Common Pitfall: Calling run() Instead of start()
A common mistake is to call the `run()` method directly, which executes it in the current thread rather than starting a new one:

```java
Thread newThread = new Thread(new MyRunnable());
newThread.run(); // This will NOT start a new thread!
```

To properly start a new thread, use:

```java
newThread.start();
```

## Thread Names
You can name threads for easier identification:

```java
Thread thread = new Thread("New Thread") {
    public void run() {
        System.out.println("run by: " + getName());
    }
};
thread.start();
```

You can also specify a thread name when using a `Runnable`:

```java
Runnable runnable = new MyRunnable();
Thread thread = new Thread(runnable, "New Thread");
thread.start();
```

## Thread.currentThread()
Use `Thread.currentThread()` to obtain the current thread’s reference:

```java
Thread thread = Thread.currentThread();
String threadName = thread.getName();
```

## Java Thread Example
Here’s a simple example that starts multiple threads:

```java
public class ThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }
}
```

## Pause a Thread
You can pause a thread using `Thread.sleep()`:

```java
try {
    Thread.sleep(10000); // Sleep for 10 seconds
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

## Stop a Thread
Instead of using the deprecated `stop()` method, implement a stopping mechanism:

```java
public class MyRunnable implements Runnable {
    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return !doStop;
    }

    @Override
    public void run() {
        while (keepRunning()) {
            System.out.println("Running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Stopping the thread
public class MyRunnableMain {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        try {
            Thread.sleep(10000); // Main thread sleeps for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myRunnable.doStop(); // Signal to stop the thread
    }
}
```

## Daemon Threads
Daemon threads do not prevent the JVM from exiting when the main thread finishes. Set a thread as a daemon using `setDaemon(true)`:

```java
Thread thread = new Thread(() -> {
    System.out.println("Daemon Thread running.");
});
thread.setDaemon(true);
thread.start();

// Ensure the main thread waits for the daemon thread to execute
try {
    thread.join();
} catch (InterruptedException e) {
    throw new RuntimeException(e);
}
```

## Conclusion
Java threads provide a powerful way to perform concurrent operations. Understanding how to create, start, manage, and stop threads is essential for developing efficient multithreaded applications.

---

# Java Virtual Threads

## Introduction
Java virtual threads, introduced in Java 19, offer a new lightweight threading model that allows applications to handle many more concurrent tasks with less resource overhead compared to traditional platform threads. This is especially useful for applications that require extensive blocking I/O operations, such as making multiple network calls or database connections.

## Virtual Threads Overview
Virtual threads are executed on platform threads, which in turn run on the operating system's threads. Each platform thread can only execute one virtual thread at a time. When a virtual thread performs a blocking operation, it is "unmounted" from the platform thread, allowing that thread to run another virtual thread.

### Key Concepts:
- **Virtual Threads and Platform Threads**: Virtual threads are lightweight and managed by platform threads. While a platform thread executes a virtual thread, it is said to be "mounted" to that thread.
- **Blocking Operations**: If a virtual thread makes a blocking call (like a network request), it gets unmounted, allowing the platform thread to execute another virtual thread.
- **Pinning**: Some operations can "pin" a virtual thread to a platform thread, preventing the platform thread from switching to another virtual thread until the blocking call completes.

## Creating a Java Virtual Thread
You can create a virtual thread using the `Thread.ofVirtual()` factory method. Here’s a simple example:

### Starting a Virtual Thread
```java
Runnable runnable = () -> {
    for (int i = 0; i < 10; i++) {
        System.out.println("Index: " + i);
    }
};

Thread vThread = Thread.ofVirtual().start(runnable);
```

### Creating an Unstarted Virtual Thread
If you want to create a virtual thread without starting it immediately, use `unstarted()`:
```java
Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable);
vThreadUnstarted.start();  // Start the virtual thread later
```

## Joining a Virtual Thread
Just like platform threads, you can join a virtual thread to wait for its completion:
```java
vThread.join();  // Blocks until the virtual thread finishes
```

## ExecutorService Using Virtual Threads
You can also create an `ExecutorService` that utilizes virtual threads for task execution. This allows you to manage and execute multiple tasks efficiently without the overhead of traditional threading models.

## Conclusion
Java virtual threads provide a powerful way to handle concurrency, especially in I/O-bound applications. While they are still a preview feature, they represent a significant advancement in Java's concurrency model, making it easier to develop high-performance applications that can handle numerous simultaneous operations. Keep an eye on future Java updates, as features and behaviors related to virtual threads may evolve.

---
# Race Conditions and Critical Sections

## Overview
A **race condition** is a concurrency issue that occurs when multiple threads access shared data and attempt to change it simultaneously. The outcome of this execution can differ based on the timing of thread execution. A **critical section** is a part of the code where shared resources are accessed, and it's crucial to manage access to prevent race conditions.

## Two Types of Race Conditions
Race conditions typically manifest in two patterns:
1. **Read-Modify-Write**
2. **Check-Then-Act**

### 1. Read-Modify-Write
In this pattern, threads read a shared variable, modify it, and write it back. A race condition occurs when multiple threads read the same value and then write back different modified values.

**Example:**
```java
public class Counter {
    protected long count = 0;

    public void add(long value) {
        this.count = this.count + value;
    }
}
```
If two threads (A and B) execute `add()` simultaneously, they may read the same initial value and overwrite each other's updates, leading to incorrect results.

### 2. Check-Then-Act
In this scenario, threads check a condition and act based on that check, which can lead to race conditions if two threads evaluate the condition simultaneously.

**Example:**
```java
public class CheckThenActExample {
    public void checkThenAct(Map<String, String> sharedMap) {
        if (sharedMap.containsKey("key")) {
            String val = sharedMap.remove("key");
            if (val == null) {
                System.out.println("Value for 'key' was null");
            }
        } else {
            sharedMap.put("key", "value");
        }
    }
}
```
If multiple threads invoke `checkThenAct()` at the same time, they may see the key exists, and then only one will succeed in removing it, leading to inconsistent behavior.

## Preventing Race Conditions
To avoid race conditions, ensure critical sections are executed atomically. This can be achieved through various synchronization mechanisms:

1. **Synchronized Blocks**: Use `synchronized` to control access to critical sections.
2. **Locks**: Utilize explicit locks (`ReentrantLock`, etc.) for finer control.
3. **Atomic Variables**: Use classes from `java.util.concurrent.atomic` for operations that require atomicity.

### Example of Synchronized Block
```java
public class SafeCounter {
    private long count = 0;

    public synchronized void add(long value) {
        this.count += value;
    }
}
```

## Critical Section Throughput
When dealing with critical sections, performance can be affected by contention. If critical sections are too large, they may block threads unnecessarily. Consider breaking down critical sections into smaller parts to improve throughput.

### Example of Improved Throughput
```java
public class TwoSums {
    private int sum1 = 0;
    private int sum2 = 0;
    private final Object sum1Lock = new Object();
    private final Object sum2Lock = new Object();

    public void add(int val1, int val2) {
        synchronized (sum1Lock) {
            this.sum1 += val1;
        }
        synchronized (sum2Lock) {
            this.sum2 += val2;
        }
    }
}
```
In this example, separate locks for `sum1` and `sum2` allow multiple threads to update them concurrently, reducing contention and improving performance.

## Conclusion
Understanding race conditions and critical sections is essential for developing robust multithreaded applications. By implementing proper synchronization techniques, you can effectively manage shared resources, ensuring correct program behavior and improving application performance.

---

# Thread Pools

## Introduction to Thread Pools
A thread pool is a collection of threads that can be reused to execute multiple tasks. This approach avoids the overhead associated with creating a new thread for each task, leading to better performance and resource management. 

Using a thread pool allows you to control the number of active threads at any time, preventing resource exhaustion, especially in systems with limited memory (RAM). If too many threads are active simultaneously, it can slow down your system due to excessive resource consumption.

This tutorial will explain how thread pools work, their use cases, and how to implement a Java thread pool. Java provides a built-in thread pool through the `ExecutorService`, so you can use it without implementing your own. However, creating your own thread pool can be a valuable learning experience.

## How a Thread Pool Works
Instead of creating a new thread for every task, tasks are submitted to a thread pool. When idle threads are available, they execute the tasks. Internally, tasks are stored in a **BlockingQueue**, and idle threads dequeue and execute them as they become available.

### Thread Pool Illustration
![Thread Pool Illustration](link-to-your-image)

## Thread Pool Use Cases
Thread pools are commonly used in multithreaded servers. Each network connection is treated as a task and processed concurrently by the threads in the pool. Later sections will delve into implementing multithreaded servers in Java.

## Built-in Java Thread Pool
Java includes built-in thread pools in the `java.util.concurrent` package, eliminating the need to create your own. For more details, check the documentation on `ExecutorService`. However, understanding how to implement a thread pool can be beneficial.

## Java Thread Pool Implementation
Here's a simple thread pool implementation using `BlockingQueue`, introduced in Java 5.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);

        for (int i = 0; i < noOfThreads; i++) {
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
            runnables.add(poolThreadRunnable);
        }
        for (PoolThreadRunnable runnable : runnables) {
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) throw new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (PoolThreadRunnable runnable : runnables) {
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### PoolThreadRunnable Class
The `PoolThreadRunnable` class implements `Runnable` to execute tasks from the queue.

```java
import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {
    private Thread thread = null;
    private BlockingQueue<Runnable> taskQueue = null;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
        taskQueue = queue;
    }

    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped()) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (Exception e) {
                // Log or handle the exception, but keep the pool thread alive.
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.thread.interrupt(); // Interrupt if blocked
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
```

## Example of Using the Thread Pool
Here’s how to use the `ThreadPool` class:

```java
public class ThreadPoolMain {
    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            threadPool.execute(() -> {
                String message = Thread.currentThread().getName() + ": Task " + taskNo;
                System.out.println(message);
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
```

### Conclusion
The thread pool implementation consists of two parts: the `ThreadPool` class, which serves as the public interface, and the `PoolThreadRunnable` class, which handles the execution of tasks. 

To submit a task, call `ThreadPool.execute(Runnable r)`. The task is added to the queue and executed by an available thread. The `stop()` method halts the thread pool, ensuring all threads complete their current tasks before terminating.

This understanding of thread pools can greatly enhance your ability to manage concurrency in Java applications!
