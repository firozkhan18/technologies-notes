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
# Thread Safety and Shared Resources

## Overview
Thread safety refers to code that can be safely executed by multiple threads simultaneously without causing race conditions. Understanding what resources Java threads share is crucial for ensuring thread-safe behavior.

## Local Variables
Local variables are stored in each thread's own stack, meaning they are not shared between threads. Thus, local primitive variables are inherently thread-safe.

### Example of Thread-Safe Local Variable
```java
public void someMethod() {
    long threadSafeInt = 0;
    threadSafeInt++;
}
```
In this example, each thread has its own `threadSafeInt`, making it thread-safe.

## Local Object References
Local references to objects differ from local primitives. While the reference itself is not shared, the object it points to resides in the shared heap.

### Conditions for Thread Safety with Local Objects
- If an object created within a method does not escape that method (i.e., it is not returned or made accessible to other threads), it is thread-safe.

### Example of Thread-Safe Local Object
```java
public void someMethod() {
    LocalObject localObject = new LocalObject();
    localObject.callMethod();
    method2(localObject);
}

public void method2(LocalObject localObject) {
    localObject.setValue("value");
}
```
In this case, `localObject` is confined to `someMethod()`, ensuring thread safety as it cannot be accessed by other threads.

## Object Member Variables
Object member variables (fields) are stored on the heap and can lead to race conditions if accessed by multiple threads simultaneously.

### Example of Non-Thread-Safe Code
```java
public class NotThreadSafe {
    StringBuilder builder = new StringBuilder();

    public void add(String text) {
        this.builder.append(text);
    }
}

// Shared instance leads to race conditions
NotThreadSafe sharedInstance = new NotThreadSafe();
new Thread(new MyRunnable(sharedInstance)).start();
new Thread(new MyRunnable(sharedInstance)).start();
```
In this example, two threads modifying the same `NotThreadSafe` instance can result in race conditions.

### Thread-Safe Usage of Non-Thread-Safe Objects
```java
new Thread(new MyRunnable(new NotThreadSafe())).start();
new Thread(new MyRunnable(new NotThreadSafe())).start();
```
By using separate instances, each thread operates independently, avoiding race conditions.

## The Thread Control Escape Rule
To assess whether your resource access is thread-safe, consider the **Thread Control Escape Rule**:
- If a resource is created, used, and disposed of within the same thread's control, and never escapes that control, it is thread-safe.

### Application of the Rule
- Resources include objects, arrays, file handles, database connections, etc.
- Even if a resource is managed thread-safely, if it references shared resources, the overall thread safety may be compromised.

### Example of Potential Race Condition with Shared Resources
```java
// Two threads operating on a shared database resource
Thread 1 checks if record X exists.
Thread 2 checks if record X exists.
Thread 1 inserts record X.
Thread 2 inserts record X.
```
In this scenario, both threads may attempt to insert the same record, leading to data integrity issues.

## Conclusion
Understanding thread safety involves recognizing how local variables, local object references, and member variables interact in a multithreaded context. The Thread Control Escape Rule helps determine the safety of resource usage. Always consider both the direct management of objects and their implications on shared resources to ensure robust thread-safe programming.

---
# Thread Safety and Immutability

## Overview
Thread safety can be achieved through immutability, meaning that shared objects cannot be modified after their creation. This helps prevent race conditions, which occur when multiple threads access the same resource, especially when writing to it.

## Creating Immutable Objects
An immutable object is one whose state cannot be changed after it is created. Here’s an example of an immutable class:

### Example of an Immutable Class
```java
public class ImmutableValue {
    private final int value;

    public ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public ImmutableValue add(int valueToAdd) {
        return new ImmutableValue(this.value + valueToAdd);
    }
}
```
In this `ImmutableValue` class:
- The `value` is set only once in the constructor.
- There are no setter methods, ensuring that the value cannot be changed after creation.
- The `add` method returns a new instance instead of modifying the existing instance.

## The Reference is not Thread Safe!
While the immutable object itself is thread-safe, the reference to that object may not be. Consider the following example:

### Example of Non-Thread-Safe Reference
```java
public class Calculator {
    private ImmutableValue currentValue = null;

    public ImmutableValue getValue() {
        return currentValue;
    }

    public void setValue(ImmutableValue newValue) {
        this.currentValue = newValue;
    }

    public void add(int newValue) {
        this.currentValue = this.currentValue.add(newValue);
    }
}
```
In this `Calculator` class:
- The reference `currentValue` can be changed by both the `setValue` and `add` methods.
- Even though `ImmutableValue` is thread-safe, the `Calculator` class is not, because it allows changing the reference to different `ImmutableValue` instances.

## Making the Calculator Class Thread Safe
To ensure thread safety in the `Calculator` class, you can synchronize its methods:

### Example of Synchronized Methods
```java
public class Calculator {
    private ImmutableValue currentValue = null;

    public synchronized ImmutableValue getValue() {
        return currentValue;
    }

    public synchronized void setValue(ImmutableValue newValue) {
        this.currentValue = newValue;
    }

    public synchronized void add(int newValue) {
        this.currentValue = this.currentValue.add(newValue);
    }
}
```
By adding the `synchronized` keyword:
- Only one thread can execute any of these methods at a time, ensuring that the reference to `currentValue` is modified safely.

## Conclusion
Immutability is a powerful way to achieve thread safety in Java, as it prevents state changes that could lead to race conditions. However, when using immutable objects, it’s crucial to manage the references to those objects carefully to maintain thread safety. Synchronizing access to mutable references ensures that shared resources are accessed safely in a multithreaded environment.

---
# Java Memory Model

## Overview
The Java Memory Model (JMM) defines how the Java Virtual Machine (JVM) interacts with memory, particularly regarding how threads see shared variables and how synchronization is managed. Understanding the JMM is crucial for writing correct concurrent Java programs.

### Key Concepts
1. **Thread Stacks and Heap**: Each thread has its own stack containing local variables, while shared objects are stored in the heap. Local variables are not visible to other threads, whereas objects on the heap can be accessed by any thread with a reference.

2. **Visibility**: Changes made to shared variables by one thread may not be immediately visible to other threads due to caching mechanisms at the hardware level.

3. **Race Conditions**: Occur when multiple threads access shared variables concurrently and at least one thread modifies them, leading to unpredictable behavior.

## Internal Java Memory Model
### Memory Structure
- **Thread Stack**: Contains local variables and method call information. Each thread's local variables are isolated and not shared.
- **Heap**: Stores all objects, including the member variables of these objects. Objects are shared among threads.

#### Diagram Overview
- Local variables (primitive types and references) are stored on the thread stack.
- Objects themselves are stored on the heap. 
- Each thread has its own version of local variables, but shared objects are accessed via references pointing to the same memory location.

### Example
```java
public class MyRunnable implements Runnable {
    public void run() {
        methodOne();
    }

    public void methodOne() {
        int localVariable1 = 45; // Local to thread
        MySharedObject localVariable2 = MySharedObject.sharedInstance; // Points to shared object
        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99); // Unique per thread
    }
}
```

## Hardware Memory Architecture
Modern hardware architecture may include multiple CPUs and cache layers, leading to potential inconsistencies in how variables are accessed and updated. CPUs may use registers and cache for faster access to data, complicating visibility between threads.

### Memory Access
- **Registers**: Fast, in-CPU memory.
- **Cache Memory**: Faster than RAM but slower than registers. 
- **Main Memory (RAM)**: Where all variables ultimately reside.

## Bridging JMM and Hardware Memory
### Visibility Issues
Without proper synchronization or the use of `volatile`, changes made to a shared object by one thread may not be visible to others due to caching in CPU registers or cache memory.

### Race Conditions
Race conditions occur when multiple threads modify shared data without proper synchronization. This can lead to unexpected results because threads may read stale data from their local caches.

### Solutions
- **Volatile Keyword**: Ensures a variable is always read from and written back to main memory, providing visibility guarantees.
- **Synchronized Blocks**: Ensures that only one thread can access a critical section of code at a time, flushing variables to and from main memory correctly.

### Example of Race Condition
```java
public class Counter {
    private int count = 0;

    public void increment() {
        count++; // This can lead to race conditions
    }
}
```

If two threads call `increment()` simultaneously, both may read the same value of `count` before either writes back the incremented value, resulting in a lost update.

## Conclusion
Understanding the Java Memory Model is essential for designing robust concurrent applications. Proper synchronization and visibility management are critical to avoiding race conditions and ensuring that all threads see the correct state of shared data. Using constructs like `volatile` and synchronized blocks helps bridge the gap between the Java memory model and the underlying hardware architecture.

---
# Java Happens Before Guarantee

The **Java Happens Before Guarantee** is crucial for understanding the visibility and ordering of variable accesses in a multithreaded environment. It establishes a framework that allows developers to reason about the execution order of statements across threads, ensuring that changes made by one thread become visible to others under specific conditions.

## Overview of Instruction Reordering

Modern CPUs can execute independent instructions out of order to improve performance. However, this can lead to inconsistencies in a multithreaded context if one thread updates a variable while another thread reads it. The **happens-before** relationship helps mitigate this issue by providing guarantees on the visibility of variables.

### Example of Instruction Reordering

Consider two independent instructions:

```java
a = b + c;  // Independent instruction
d = e + f;  // Independent instruction
```

These can be executed in parallel. However, if one instruction depends on the result of another, reordering can lead to incorrect results:

```java
a = b + c;  // Must complete before
d = a + e;  // This instruction
```

### Problems in Multi-CPU Systems

In a multi-CPU environment, instruction reordering can introduce problems. Consider the following class:

```java
public class FrameExchanger {
    private long framesStoredCount = 0;
    private long framesTakenCount = 0;
    private boolean hasNewFrame = false;
    private Frame frame = null;

    public void storeFrame(Frame frame) {
        this.frame = frame;
        this.framesStoredCount++;
        this.hasNewFrame = true;
    }

    public Frame takeFrame() {
        while (!hasNewFrame) {
            // busy wait
        }
        Frame newFrame = this.frame;
        this.framesTakenCount++;
        this.hasNewFrame = false;
        return newFrame;
    }
}
```

In this example, if the JVM reorders the `storeFrame` method, it can lead to incorrect behavior, where the drawing thread might process an old frame.

## Java Volatile Visibility Guarantee

The `volatile` keyword in Java provides visibility guarantees. When a volatile variable is written, all variables visible to that thread at the time of the write are synchronized to main memory. This ensures that any thread reading the volatile variable sees the most recent values of those variables.

### Write Visibility Guarantee

When you write to a volatile variable, it ensures that all other variables visible to that thread are also synchronized to main memory:

```java
this.nonVolatileVarA = 34;
this.nonVolatileVarB = new String("Text");
this.volatileVarC = 300;  // Volatile write
```

### Read Visibility Guarantee

When reading a volatile variable, it ensures that all variables visible to the thread are refreshed from main memory:

```java
c = other.volatileVarC;  // Volatile read
b = other.nonVolatileB;
a = other.nonVolatileA;
```

## Happens Before Guarantees

### For Volatile Writes

A write to a volatile variable guarantees that all prior writes to non-volatile variables happen before the write to the volatile variable. This means:

```java
this.frame = frame;         // Non-volatile write
this.framesStoredCount++;   // Non-volatile write
this.hasNewFrame = true;    // Volatile write
```

The first two writes cannot be reordered after the last volatile write.

### For Volatile Reads

A read of a volatile variable guarantees that any subsequent reads of volatile or non-volatile variables happen after the read. This means:

```java
int a = this.volatileVarA;  // Volatile read
int b = this.nonVolatileVarB;  // Must happen after
int c = this.nonVolatileVarC;  // Must happen after
```

## Java Synchronized Visibility Guarantee

The `synchronized` keyword provides similar visibility guarantees to `volatile`, but with a slightly different mechanism.

### Entry Visibility Guarantee

When a thread enters a synchronized block, all variables visible to that thread are refreshed from main memory:

```java
public void get(Values v) {
    synchronized (this) {
        v.valC = this.valC;  // Ensured to be up-to-date
    }
}
```

### Exit Visibility Guarantee

When a thread exits a synchronized block, all changed variables are flushed to main memory:

```java
public void set(Values v) {
    this.valA = v.valA;
    this.valB = v.valB;
    synchronized (this) {
        this.valC = v.valC;  // Ensured to be flushed
    }
}
```

## Conclusion

Understanding the Java Happens Before Guarantee is essential for writing correct multithreaded applications. It helps prevent issues caused by instruction reordering and ensures that threads see the most up-to-date values of shared variables. By leveraging `volatile` and `synchronized`, developers can create robust and efficient concurrent programs.

---

### Java Synchronized Blocks

**Java Synchronized Tutorial Video**
- A video version of this tutorial is available for those who prefer visual learning.

**Java Concurrency Utilities**
- The synchronized mechanism is Java's initial approach for synchronizing access to shared objects among multiple threads. However, with the introduction of Java 5, a range of concurrency utility classes were added to provide more refined concurrency control.

**The Java Synchronized Keyword**
- Synchronized blocks are denoted with the `synchronized` keyword and can only be executed by one thread at a time based on the object they are synchronized on. Other threads attempting to enter the block will be blocked until the current thread exits.

**Types of Synchronized Blocks:**
1. **Synchronized Instance Methods**
   - Synchronized on the object instance:
     ```java
     public synchronized void add(int value) {
         this.count += value;
     }
     ```
   - Only one thread per instance can execute synchronized methods.

2. **Synchronized Static Methods**
   - Synchronized on the class object:
     ```java
     public static synchronized void add(int value) {
         count += value;
     }
     ```
   - Only one thread can execute any static synchronized method in the class at a time.

3. **Synchronized Blocks in Instance Methods**
   - You can synchronize specific code blocks within methods:
     ```java
     public void add(int value) {
         synchronized(this) {
             this.count += value;
         }
     }
     ```
   - Ensures that only one thread can execute the synchronized block at a time.

4. **Synchronized Blocks in Static Methods**
   - Similar to instance methods but synchronized on the class object:
     ```java
     public static void log2(String msg1, String msg2) {
         synchronized(MyClass.class) {
             log.writeln(msg1);
             log.writeln(msg2);
         }
     }
     ```

5. **Synchronized Blocks in Lambda Expressions**
   - Synchronized blocks can also be included in lambda expressions:
     ```java
     Consumer<String> func = (String param) -> {
         synchronized(SynchronizedExample.class) {
             // Code here
         }
     };
     ```

**Java Synchronized Example**
- Example of synchronizing thread access to a shared instance:
  ```java
  public class Counter {
      public synchronized void add(long value) {
          this.count += value;
      }
  }
  ```

**Synchronized and Data Visibility**
- The synchronized keyword ensures that all changes made by a thread are visible to other threads once it exits a synchronized block.

**Synchronized and Instruction Reordering**
- The synchronized keyword also prevents reordering of instructions that could lead to unexpected behavior in multi-threaded environments.

**What Objects to Synchronize On**
- It is advisable to avoid synchronizing on String objects or primitive type wrappers due to potential optimization issues. Instead, use `this` or `new Object()` as monitor objects.

**Synchronized Block Limitations and Alternatives**
- Synchronized blocks allow only one thread at a time, which may not be ideal for all scenarios. Alternatives include Read/Write Locks, Semaphores, or using volatile variables for single-writer, multiple-reader situations.

**Synchronized Block Performance Overhead**
- There is a performance cost associated with entering and exiting synchronized blocks, so it’s best to minimize the scope of synchronization to necessary operations.

**Synchronized Block Reentrance**
- A thread can reenter a synchronized block it holds the lock on, allowing for recursive calls without deadlock as long as the lock is held by the same thread.

**Synchronized Blocks in Cluster Setups**
- Synchronized blocks only prevent access from threads within the same JVM. For synchronization across multiple JVMs, other mechanisms are required.

---
# Java Volatile Keyword: A Comprehensive Guide

## Overview
The `volatile` keyword in Java is used to indicate that a variable's value will be modified by different threads. It ensures that all reads and writes to the variable go directly to and from the main memory, thus avoiding caching issues in CPU registers. This article delves into the nuances of the `volatile` keyword, including its guarantees, visibility issues, and when to use it effectively.

## 1. Variable Visibility Problems
In a multithreaded environment, threads may not see the latest changes made to variables by other threads due to caching mechanisms. For example, if Thread 1 increments a counter without declaring it as `volatile`, Thread 2 may not read the updated value from main memory, leading to inconsistent results.

### Example:
```java
public class SharedObject {
    public int counter = 0;
}
```

## 2. The Java Volatile Visibility Guarantee
Declaring a variable as `volatile` ensures that all writes to that variable are immediately visible to other threads. This means that Thread 2 will see the updates made by Thread 1 without delay.

### Example:
```java
public class SharedObject {
    public volatile int counter = 0;
}
```

## 3. Full Volatile Visibility Guarantee
The visibility guarantee extends beyond the `volatile` variable itself. If one thread writes to a `volatile` variable, all variables visible to that thread before the write will be visible to any thread that reads that `volatile` variable afterward.

### Example:
```java
public class MyClass {
    private int years;
    private int months;
    private volatile int days;

    public void update(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }
}
```

## 4. Instruction Reordering Challenges
Java allows the JVM and CPU to reorder instructions for performance optimizations. This can lead to issues when volatile variables are involved. The `volatile` keyword prevents certain reordering, ensuring that operations before the volatile write are completed before the volatile write occurs.

## 5. The Java Volatile Happens-Before Guarantee
The `volatile` keyword provides a "happens-before" guarantee, which ensures the order of operations concerning volatile variables:

- Writes to a volatile variable happen before subsequent reads of that variable by any thread.
- This guarantee prevents critical sections from being reordered in a way that would compromise data consistency.

## 6. Volatile is Not Always Enough
While `volatile` ensures visibility, it does not guarantee atomicity. If multiple threads read and write to a shared variable, simply marking it as `volatile` is insufficient.

### Example Scenario:
If Thread 1 reads a shared counter, increments it, and then writes it back, while Thread 2 does the same, both may read the same initial value, leading to incorrect results.

## 7. When is Volatile Enough?
Using `volatile` is adequate when:
- One thread writes to a variable and other threads only read it.
- No computations depend on the previous value of the variable.

However, if operations depend on the current state of the variable, use `synchronized` blocks or atomic classes from `java.util.concurrent`.

## 8. Performance Considerations of Volatile
Reading from and writing to volatile variables incurs a performance cost since these operations interact directly with main memory. This is slower compared to accessing local CPU registers. Hence, `volatile` should be used judiciously.

## Conclusion
The `volatile` keyword is a powerful tool in Java for handling variable visibility across threads. Understanding its guarantees and limitations is essential for developing reliable multithreaded applications. Use it when visibility is crucial but remember that for atomic operations, synchronization mechanisms are necessary.

---
## CPU Cache Coherence in Java Concurrency

In Java concurrency, it's important to understand the interaction between threads, memory, and CPU caches. When a thread writes to a volatile variable or exits a synchronized block, it flushes certain variables from CPU registers, but the process is more nuanced than a simple write to main memory.

### What Actually Happens

When a thread writes to a volatile variable or exits a synchronized block, the following occurs:

1. **Flush to CPU Cache**: The variables in the thread's CPU registers are flushed to the CPU cache rather than directly to main memory. This allows for faster access by the CPU.

2. **Cache Coherence Protocols**: The motherboard's hardware employs cache coherence protocols to ensure that any changes made in one CPU's cache are visible to other CPUs. This maintains consistency across multiple cores.

3. **Possible Delayed Flush to Main Memory**: The system might not immediately write these flushed variables to main memory. Instead, they can stay in the CPU cache until needed for other data, optimizing performance.

### Implications for Developers

As a developer, you don't need to manage these low-level details of CPU cache coherence. The hardware handles it effectively, balancing the need for speed with data consistency. While there is some performance overhead from these coherence operations, it is generally preferable to direct memory writes.

### Visualization

To clarify:

- **Incorrect Understanding**: It's a common misconception that volatile writes flush data directly to main memory.
- **Correct Understanding**: Instead, data is flushed from CPU registers to the CPU cache, where coherence protocols manage visibility among other CPUs.

### Conclusion

Understanding CPU cache coherence enhances your grasp of Java's concurrency model, particularly around the volatile keyword and synchronized blocks. While you don’t have to worry about the intricacies of cache coherence, knowing how it operates can help you write more efficient concurrent programs.

---
# False Sharing in Java

False sharing occurs when multiple threads write to different variables that reside within the same CPU cache line, leading to performance issues. This tutorial explores false sharing, its impact on performance, and strategies to mitigate it.

## What is False Sharing?

False sharing happens when two threads running on different CPUs write to different variables that are stored in the same CPU cache line. When one thread modifies its variable, the entire cache line is invalidated in the other thread’s cache, requiring it to reload the cache line, even if it doesn't need the modified variable. 

### Illustration

![False Sharing Illustration](link-to-image)

### Cache Lines

- **Cache Line Size**: Typically, a cache line consists of 64 bytes. When CPUs fetch data, they retrieve entire cache lines instead of individual bytes, which can lead to false sharing if multiple variables are stored within the same line.
  
### Cache Line Invalidation

When a CPU writes to a variable, that cache line becomes "dirty" and needs to be synchronized across other CPUs, leading to cache line invalidation. This process incurs a performance penalty because the CPU must wait for the cache line to be refreshed.

## Performance Penalty of False Sharing

The performance degradation arises because of frequent cache line invalidations and reloads. This results in wasted CPU cycles as threads spend time waiting for cache lines to be refreshed instead of executing instructions.

## Java Code Example

### Example of False Sharing

Here’s a simple example that demonstrates false sharing:

```java
public class Counter {
    public volatile long count1 = 0;
    public volatile long count2 = 0;
}

public class FalseSharingExample {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        long iterations = 1_000_000_000;

        Thread thread1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (long i = 0; i < iterations; i++) {
                counter1.count1++;
            }
            System.out.println("Thread 1 time: " + (System.currentTimeMillis() - startTime));
        });

        Thread thread2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (long i = 0; i < iterations; i++) {
                counter1.count2++;
            }
            System.out.println("Thread 2 time: " + (System.currentTimeMillis() - startTime));
        });

        thread1.start();
        thread2.start();
    }
}
```

### Improved Performance by Avoiding False Sharing

To avoid false sharing, ensure that counters are stored in separate objects:

```java
public class FalseSharingFixed {
    public static void main(String[] args) {
        Counter counter1 = new Counter(); // Separate instances
        Counter counter2 = new Counter();
        long iterations = 1_000_000_000;

        // Similar thread code as above...
    }
}
```

## Fixing False Sharing Problems

To fix false sharing, you need to ensure that variables accessed by different threads do not share the same cache line. 

### Using the @Contended Annotation

Java provides the `@Contended` annotation (available from Java 8) to help mitigate false sharing by adding padding around variables:

```java
public class Counter1 {
    @jdk.internal.vm.annotation.Contended
    public volatile long count1 = 0;
    public volatile long count2 = 0;
}
```

### Grouping Fields

You can group fields using the `@Contended` annotation to keep them close while ensuring padding between different groups:

```java
public class GroupedCounter {
    @jdk.internal.vm.annotation.Contended("group1")
    public volatile long count1 = 0;
    
    @jdk.internal.vm.annotation.Contended("group1")
    public volatile long count2 = 0;
    
    @jdk.internal.vm.annotation.Contended("group2")
    public volatile long count3 = 0;
}
```

### Configuring Padding Size

By default, `@Contended` adds 128 bytes of padding. You can configure this padding size with a JVM argument:

```
-XX:ContendedPaddingWidth=64
```

Adjusting this value can optimize performance based on your CPU's cache line size.

## Conclusion

False sharing can significantly impact performance in concurrent Java applications. Understanding how it occurs and implementing strategies to prevent it, such as using the `@Contended` annotation or separating variables into different objects, can lead to more efficient multi-threaded applications.

---
# Java ThreadLocal Tutorial

The `ThreadLocal` class in Java allows you to create variables that are accessible only by the thread that created them. This makes it easier to create thread-safe code without using synchronization, as each thread maintains its own value.

## Creating a ThreadLocal

You can create a `ThreadLocal` instance like any other object:

```java
private ThreadLocal<String> threadLocal = new ThreadLocal<>();
```

Each thread can now set and get its own value from this `ThreadLocal`.

## Setting and Getting Values

### Set ThreadLocal Value

To set a value, use the `set()` method:

```java
threadLocal.set("A thread local value");
```

### Get ThreadLocal Value

To retrieve the value, use the `get()` method:

```java
String threadLocalValue = threadLocal.get();
```

### Remove ThreadLocal Value

To remove the value from a `ThreadLocal`, call the `remove()` method:

```java
threadLocal.remove();
```

## Generic ThreadLocal

You can specify a type for `ThreadLocal`:

```java
private ThreadLocal<String> myThreadLocal = new ThreadLocal<>();
```

Now you can store only `String` values without typecasting:

```java
myThreadLocal.set("Hello ThreadLocal");
String threadLocalValue = myThreadLocal.get();
```

## Initial ThreadLocal Value

### Override initialValue()

You can set an initial value for a `ThreadLocal` by subclassing it and overriding the `initialValue()` method:

```java
private ThreadLocal<String> myThreadLocal = new ThreadLocal<String>() {
    @Override
    protected String initialValue() {
        return String.valueOf(System.currentTimeMillis());
    }
};
```

### Provide a Supplier Implementation

You can also use the `withInitial(Supplier)` method to set an initial value:

```java
ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> String.valueOf(System.currentTimeMillis()));
```

## Lazy Setting of ThreadLocal Value

In cases where the initial value isn't available at the time of `ThreadLocal` creation, you can set it lazily:

```java
public class MyDateFormatter {
    private ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<>();

    public String format(Date date) {
        SimpleDateFormat sdf = getThreadLocalSimpleDateFormat();
        return sdf.format(date);
    }

    private SimpleDateFormat getThreadLocalSimpleDateFormat() {
        SimpleDateFormat sdf = simpleDateFormatThreadLocal.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormatThreadLocal.set(sdf);
        }
        return sdf;
    }
}
```

## Using ThreadLocal with Thread Pool or ExecutorService

Using `ThreadLocal` with a thread pool or `ExecutorService` is straightforward. Each thread in the pool will maintain its own value.

## Full ThreadLocal Example

Here's a complete example demonstrating `ThreadLocal`:

```java
public class ThreadLocalExample {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

public class MyRunnable implements Runnable {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocal.get());
    }
}
```

In this example, each thread sets its own value in `ThreadLocal`, and they cannot see each other's values.

## InheritableThreadLocal

`InheritableThreadLocal` is a subclass of `ThreadLocal` that allows child threads to inherit the value from the parent thread:

```java
public class InheritableThreadLocalExample {
    public static void main(String[] args) {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            inheritableThreadLocal.set("Parent Thread Value");
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });

        thread1.start();
    }
}
```

In this example, the child thread can access the value set by the parent thread in `InheritableThreadLocal`, but a normal `ThreadLocal` value remains inaccessible to child threads.

## Conclusion

The `ThreadLocal` class is a powerful feature for maintaining thread-specific data without explicit synchronization. Understanding how to use `ThreadLocal` and `InheritableThreadLocal` can greatly enhance the thread-safety and performance of your Java applications.

---
# Java Thread Signaling Tutorial

Java provides a robust mechanism for thread signaling through the `wait()`, `notify()`, and `notifyAll()` methods, which are part of the `Object` class. This functionality enables threads to communicate, allowing one thread to wait for a signal from another.

## Key Concepts

### wait(), notify(), and notifyAll()

- **wait()**: Causes the current thread to wait until another thread invokes `notify()` or `notifyAll()` on the same object.
- **notify()**: Wakes up a single thread that is waiting on this object's monitor.
- **notifyAll()**: Wakes up all threads waiting on this object's monitor.

These methods must be called from within a synchronized block on the object whose monitor is being used.

### Example Implementation

Here’s a simple example demonstrating how to use these methods for inter-thread communication:

```java
public class MonitorObject {}

public class MyWaitNotify {
    private final MonitorObject myMonitorObject = new MonitorObject();

    public void doWait() {
        synchronized (myMonitorObject) {
            try {
                myMonitorObject.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }

    public void doNotify() {
        synchronized (myMonitorObject) {
            myMonitorObject.notify();
        }
    }
}
```

### How It Works

1. **Thread A** calls `doWait()`, entering a synchronized block and invoking `wait()` on `myMonitorObject`. This thread is now blocked until another thread calls `notify()` or `notifyAll()` on the same object.
2. **Thread B** calls `doNotify()`, also entering a synchronized block. It then calls `notify()`, waking up one waiting thread (if any) from the wait state.

## Missed Signals

If `notify()` is called when no threads are waiting, the signal is lost. To prevent this, you can use a member variable to track whether a signal was sent:

```java
public class MyWaitNotify2 {
    private final MonitorObject myMonitorObject = new MonitorObject();
    private boolean wasSignalled = false;

    public void doWait() {
        synchronized (myMonitorObject) {
            while (!wasSignalled) {
                try {
                    myMonitorObject.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            wasSignalled = false; // Clear the signal
        }
    }

    public void doNotify() {
        synchronized (myMonitorObject) {
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
}
```

### Spurious Wakeups

Threads can wake up without a call to `notify()` or `notifyAll()`, known as spurious wakeups. To guard against this, use a while loop instead of an if statement when checking the signal:

```java
public class MyWaitNotify3 {
    private final MonitorObject myMonitorObject = new MonitorObject();
    private boolean wasSignalled = false;

    public void doWait() {
        synchronized (myMonitorObject) {
            while (!wasSignalled) {
                try {
                    myMonitorObject.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            wasSignalled = false; // Clear the signal
        }
    }

    public void doNotify() {
        synchronized (myMonitorObject) {
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
}
```

## Multiple Threads Waiting for the Same Signals

Using a while loop also helps manage multiple threads. If several threads are waiting and one is notified, only that thread will proceed. Others will recheck the signal, and if it’s cleared, they will go back to waiting.

## Avoiding Common Pitfalls

### Don't Call wait() on Constant Strings or Global Objects

Using global objects or constant strings for signaling can lead to unintended behavior, as these objects may be shared across different instances. For example:

```java
public class MyWaitNotifyBad {
    private final String myMonitorObject = ""; // Problematic!

    public void doWait() {
        synchronized (myMonitorObject) {
            while (!wasSignalled) {
                try {
                    myMonitorObject.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            wasSignalled = false; // Clear the signal
        }
    }

    public void doNotify() {
        synchronized (myMonitorObject) {
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
}
```

This is dangerous because the same string literal may be used across different instances, leading to missed signals. Always use a unique object for synchronization.

## Conclusion

Understanding and correctly implementing thread signaling in Java is crucial for building responsive multi-threaded applications. By leveraging `wait()`, `notify()`, and `notifyAll()`, along with careful management of synchronization, you can effectively manage inter-thread communication and avoid common pitfalls.

---
# Thread Deadlock in Java

Deadlock is a situation in concurrent programming where two or more threads are blocked forever, each waiting for the other to release a resource. This typically occurs when multiple threads need the same locks but acquire them in different orders.

## Understanding Deadlock

### Basic Example

Consider two threads and two resources (locks), A and B:

- **Thread 1** locks A and then tries to lock B.
- **Thread 2** locks B and then tries to lock A.

This results in a deadlock:

- **Thread 1** is waiting for B (which is locked by Thread 2).
- **Thread 2** is waiting for A (which is locked by Thread 1).

### Visualization

```
Thread 1  -> locks A
            -> waits for B

Thread 2  -> locks B
            -> waits for A
```

### Code Example

Here's a Java example demonstrating a potential deadlock scenario using a `TreeNode` class:

```java
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    TreeNode parent = null;  
    List<TreeNode> children = new ArrayList<>();

    public synchronized void addChild(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
    }

    public synchronized void addChildOnly(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent) {
        this.parent = parent;
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent = parent;
    }
}
```

### Deadlock Scenario

If **Thread 1** executes `parent.addChild(child)` while **Thread 2** executes `child.setParent(parent)` at the same time, the following sequence occurs:

1. **Thread 1** locks `parent` to execute `addChild`.
2. **Thread 2** locks `child` to execute `setParent`.
3. **Thread 1** then tries to call `setParentOnly` on `child` but is blocked because `child` is locked by **Thread 2**.
4. **Thread 2** tries to call `addChildOnly` on `parent`, which is locked by **Thread 1**.

Both threads are now waiting on each other indefinitely.

## More Complicated Deadlocks

Deadlocks can involve more than two threads, making them even harder to detect. Consider four threads in a deadlock:

1. **Thread 1** locks A and waits for B.
2. **Thread 2** locks B and waits for C.
3. **Thread 3** locks C and waits for D.
4. **Thread 4** locks D and waits for A.

This creates a circular wait condition:

- **Thread 1** -> **Thread 2** -> **Thread 3** -> **Thread 4** -> back to **Thread 1**.

## Database Deadlocks

Deadlocks are not limited to threads. They can also occur in database transactions. Here’s how:

1. **Transaction 1** locks Record 1 for update.
2. **Transaction 2** locks Record 2 for update.
3. **Transaction 1** tries to lock Record 2.
4. **Transaction 2** tries to lock Record 1.

Both transactions are now waiting on each other, resulting in a deadlock. Since locks are taken during various requests and not all required locks are known ahead of time, detecting and preventing deadlocks can be quite challenging in database systems.

## Preventing Deadlocks

To minimize the risk of deadlocks, consider the following strategies:

1. **Lock Ordering**: Always acquire locks in a consistent order across threads.
2. **Lock Timeout**: Implement a timeout mechanism where a thread will stop waiting after a certain period and retry.
3. **Deadlock Detection**: Use algorithms to periodically check for deadlocks and resolve them if detected.
4. **Resource Allocation Graphs**: Maintain a graph to track resource allocation and avoid circular waits.

Understanding and managing deadlocks is crucial in developing robust multi-threaded applications, ensuring that your program runs smoothly without indefinite blocking.

---
# Deadlock Prevention in Java

Deadlock prevention techniques are essential in multi-threaded programming to ensure that threads do not get stuck waiting indefinitely for resources held by each other. Here are three effective strategies:

## 1. Lock Ordering

**Concept**: To prevent deadlock, ensure that all threads acquire locks in a predetermined order. This way, if every thread follows the same locking sequence, circular wait conditions cannot arise.

### Example:
- **Thread 1**:
  - Lock A
  - Lock B

- **Thread 2**:
  - Lock A
  - Lock C

- **Thread 3**:
  - Lock A
  - Lock B
  - Lock C

By enforcing that all threads must acquire lock A before B or C, you can prevent deadlocks.

### Implementation Tips:
- Establish a global order for locks that all threads adhere to.
- Use enumerated types or constants to represent lock order, making it clear and less error-prone.

## 2. Lock Timeout

**Concept**: Set a timeout for lock acquisition attempts. If a thread cannot obtain the required lock within a specified time, it gives up, releases any locks it holds, waits for a random time, and retries. This method can help avoid deadlocks by reducing contention among threads.

### Example:
1. **Thread 1** locks A.
2. **Thread 2** locks B.
3. **Thread 1** tries to lock B but times out.
4. **Thread 1** releases A and waits before retrying.
5. **Thread 2** tries to lock A but also times out.
6. **Thread 2** releases B and waits before retrying.

### Implementation Tips:
- Use custom lock classes or concurrency utilities from `java.util.concurrent` for implementing timeouts.
- Ensure to handle cases where locks may take longer to release.

## 3. Deadlock Detection

**Concept**: When prevention strategies are not feasible, use detection mechanisms to identify deadlocks. This involves monitoring the locks held by threads and the locks they are requesting.

### Process:
- Maintain a data structure (like a graph) to track the relationships between threads and locks.
- When a thread requests a lock, check if it’s already held by another thread.
- If a thread is blocked, traverse the graph to see if it forms a cycle.

### Graph Representation:
Imagine a graph where:
- Nodes represent threads.
- Directed edges represent lock requests.

If there is a cycle in this graph, a deadlock exists.

### Handling Detected Deadlocks:
1. **Backoff and Retry**: Release all locks and wait before retrying, similar to lock timeout but specifically for detected deadlocks.
2. **Priority Assignment**: Assign priorities to threads. If a deadlock is detected, allow only the lowest priority thread to back off, enabling others to continue.

### Implementation Tips:
- Regularly check for deadlocks in long-running applications.
- Use tools or libraries that can help visualize lock acquisition and detect deadlocks automatically.

## Summary

Implementing effective deadlock prevention strategies is crucial in Java multi-threading:

- **Lock Ordering** ensures consistent lock acquisition order.
- **Lock Timeout** allows threads to back off and retry, reducing contention.
- **Deadlock Detection** identifies and resolves deadlocks when they occur.

By using these techniques, you can significantly improve the robustness of your concurrent applications, reducing the likelihood of deadlock situations.

---
# Starvation and Fairness in Java

Starvation occurs when a thread is perpetually denied the CPU time it needs to execute, typically due to resource allocation policies that favor other threads. This can lead to performance issues and responsiveness problems in multi-threaded applications. Fairness, on the other hand, ensures that all threads are given a reasonable opportunity to execute, thus mitigating starvation.

## Causes of Starvation in Java

1. **Thread Priority**: 
   - In Java, threads can be assigned priorities (1 to 10). Higher-priority threads can consume most of the CPU time, causing lower-priority threads to starve. 
   - It is often advisable to leave thread priorities at their default levels to avoid such issues.

2. **Blocked Threads**: 
   - When multiple threads contend for access to synchronized blocks, the JVM does not guarantee which thread will get access next. A thread may remain blocked indefinitely if other threads continuously acquire the lock first.

3. **Indefinite Waiting**: 
   - Threads waiting on an object using `wait()` may be starved if `notify()` is always called on other waiting threads. This leads to scenarios where a thread is never awakened to continue its execution.

## Implementing Fairness in Java

While achieving perfect fairness is challenging, Java provides mechanisms to enhance fairness in synchronization.

### Using Locks Instead of Synchronized Blocks

Using explicit locks can help manage fairness better than synchronized methods or blocks. Below is an example of a custom lock implementation.

#### Basic Lock Implementation

```java
public class Lock {
    private boolean isLocked = false;
    private Thread lockingThread = null;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        notify();
    }
}
```

This simple lock implementation does not ensure fairness, as there is no guarantee of which waiting thread will acquire the lock next.

### A Fair Lock Implementation

To implement a fair lock, we can use a queue to manage waiting threads. Below is a fair lock implementation:

```java
import java.util.ArrayList;
import java.util.List;

public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        synchronized (this) {
            waitingThreads.add(queueObject);
        }

        while (true) {
            synchronized (this) {
                if (!isLocked && waitingThreads.get(0) == queueObject) {
                    isLocked = true;
                    waitingThreads.remove(0);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            queueObject.doWait();
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (!waitingThreads.isEmpty()) {
            waitingThreads.get(0).doNotify();
        }
    }
}

class QueueObject {
    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            wait();
        }
        isNotified = false;
    }

    public synchronized void doNotify() {
        isNotified = true;
        notify();
    }
}
```

### Key Features of FairLock:
- **Queue Management**: Threads calling `lock()` are queued, ensuring that only the first thread in line can proceed.
- **Single Notification**: Instead of notifying all waiting threads, only the next thread in the queue is awakened.
- **Avoiding Missed Signals**: By managing wait states within a dedicated `QueueObject`, we can prevent missed signals that may occur if a thread is preempted just before calling `wait()`.

## A Note on Performance

While a fair lock ensures better access control and reduces the chances of starvation, it comes with some performance overhead compared to simpler lock implementations. The impact of this overhead depends on:
- The length of time the critical section takes to execute.
- How often the lock is contended.

In high-contention scenarios, the overhead may be negligible relative to the benefits of reduced starvation and improved responsiveness.

## Conclusion

Implementing fairness in Java threading involves addressing the causes of starvation through careful management of lock acquisition. By utilizing fair lock implementations, you can significantly improve thread behavior, ensuring that all threads have a chance to execute without indefinitely waiting.

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
