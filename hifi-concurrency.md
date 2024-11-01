Interview Questions

# Interview Questions

## Table of Contents

- [Multithreading](#multithreading)
  - [Tell us about the Java memory model?](#tell-us-about-the-java-memory-model)
  - [What is "thread safety"?](#what-is-thread-safety)
  - [What is the difference between "competition" and "parallelism"?](#what-is-the-difference-between-competition-and-parallelism)
  - [What is "cooperative multitasking"? What type of multitasking does Java use? What is the reason for this choice?](#what-is-cooperative-multitasking)
  - [What is ordering, as-if-serial semantics, sequential consistency, visibility, atomicity, happens-before, mutual exclusion, safe publication?](#what-is-ordering-as-if-serial-semantics-sequential-consistency-visibility-atomicity-happens-before-mutual-exclusion-safe-publication)
  - [What is the difference between a process and a flow?](#what-is-the-difference-between-a-process-and-a-flow)
  - [What are "green streams" and are they in Java?](#what-are-green-streams-and-are-they-in-java)
  - [How can I create a flow?](#how-can-i-create-a-flow)
  - [What is the difference between Thread and Runnable?](#what-is-the-difference-between-thread-and-runnable)
  - [What is the difference between the start() and run() methods?](#what-is-the-difference-between-the-start-and-run-methods)
  - [How do I force a flow to start?](#how-do-i-force-a-flow-to-start)
  - [What is a "monitor" in Java?](#what-is-a-monitor-in-java)
  - [Define the concept of "synchronization".](#define-the-concept-of-synchronization)
  - [What are the different ways to synchronize in Java?](#what-are-the-different-ways-to-synchronize-in-java)
  - [What states can a thread be in?](#what-states-can-a-thread-be-in)
  - [Can I create new instances of a class while the static synchronized method is running?](#can-i-create-new-instances-of-a-class-while-the-static-synchronized-method-is-running)
  - [Why do you need a private mutex?](#why-do-you-need-a-private-mutex)
  - [How do the wait() and notify()/notifyAll() methods work?](#how-do-the-wait-and-notifynotifyall-methods-work)
  - [What is the difference between notify() and notifyAll()?](#what-is-the-difference-between-notify-and-notifyall)
  - [Why are the wait() and notify() methods called only in a synchronized block?](#why-are-the-wait-and-notify-methods-called-only-in-a-synchronized-block)
  - [What is the difference between the wait() method with and without the parameter?](#what-is-the-difference-between-the-wait-method-with-and-without-the-parameter)
  - [What is the difference between the Thread.sleep() and Thread.yield() methods?](#what-is-the-difference-between-the-threadsleep-and-threadyield-methods)
  - [How does the Thread.join() method work?](#how-does-the-threadjoin-method-work)
  - [What is deadlock?](#what-is-deadlock)
  - [What is livelock?](#what-is-livelock)
  - [How do I check if a thread is holding a monitor for a specific resource?](#how-do-i-check-if-a-thread-is-holding-a-monitor-for-a-specific-resource)
  - [On which object does synchronization occur when the static synchronized method is called?](#on-which-object-does-synchronization-occur-when-the-static-synchronized-method-is-called)
  - [What is the keyword volatile, synchronized, transient, native used for?](#what-is-the-keyword-volatile-synchronized-transient-native-used-for)
  - [What are the differences between volatile and atomic variables?](#what-are-the-differences-between-volatile-and-atomic-variables)
  - [What are the differences between java.util.concurrent.Atomic*.compareAndSwap() and java.util.concurrent.Atomic*.weakCompareAndSwap()?](#what-are-the-differences-between-javautilconcurrentatomiccompareandswap-and-javautilconcurrentatomicweakcompareandswap)
  - [What does "flow priority" mean?](#what-does-flow-priority-mean)
  - [What are "daemon threads"?](#what-are-daemon-threads)
  - [Can I make the main thread of a program a daemon?](#can-i-make-the-main-thread-of-a-program-a-daemon)
  - [What does it mean to "put to sleep" the thread?](#what-does-it-mean-to-put-to-sleep-the-thread)
  - [What is the difference between the Runnable and Callable interfaces?](#what-is-the-difference-between-the-runnable-and-callable-interfaces)
  - [What is FutureTask?](#what-is-futuretask)
  - [What are the differences between CyclicBarrier and CountDownLatch?](#what-are-the-differences-between-cyclicbarrier-and-countdownlatch)
  - [What is a race condition?](#what-is-a-race-condition)
  - [Is there a way to solve the race condition problem?](#is-there-a-way-to-solve-the-race-condition-problem)
  - [How to stop the thread?](#how-to-stop-the-thread)
  - [Why is it not recommended to use the Thread.stop() method?](#why-is-it-not-recommended-to-use-the-threadstop-method)
  - [What happens when an exception is thrown in a thread?](#what-happens-when-an-exception-is-thrown-in-a-thread)
  - [What is the difference between interrupted() and isInterrupted()?](#what-is-the-difference-between-interrupted-and-isinterrupted)
  - [What is a "thread pool"?](#what-is-a-thread-pool)
  - [What size should a thread pool be?](#what-size-should-a-thread-pool-be)
  - [What happens if the thread pool queue is already full, but a new task is submitted?](#what-happens-if-the-thread-pool-queue-is-already-full-but-a-new-task-is-submitted)
  - [What is the difference between the submit() and execute() methods of a thread pool?](#what-is-the-difference-between-the-submit-and-execute-methods-of-a-thread-pool)
  - [What are the differences between a stack and a heap in terms of multithreading?](#what-are-the-differences-between-a-stack-and-a-heap-in-terms-of-multithreading)
  - [How do I share data between two threads?](#how-do-i-share-data-between-two-threads)
  - [What JVM startup option is used to control the size of a thread's stack?](#what-jvm-startup-option-is-used-to-control-the-size-of-a-threads-stack)
  - [How do I get a thread dump?](#how-do-i-get-a-thread-dump)
  - [What is a ThreadLocal variable?](#what-is-a-threadlocal-variable)
  - [What are the differences between synchronized and ReentrantLock?](#what-are-the-differences-between-synchronized-and-reentrantlock)
  - [What is ReadWriteLock?](#what-is-readwritelock)
  - [What is the "blocking method"?](#what-is-the-blocking-method)
  - [What is a "Fork/Join framework"?](#what-is-a-forkjoin-framework)
  - [What is Semaphore?](#what-is-semaphore)
  - [What is a double-checked locking Singleton?](#what-is-a-double-checked-locking-singleton)
  - [How do I create a thread-safe Singleton?](#how-do-i-create-a-thread-safe-singleton)
  - [Why are immutable objects useful?](#why-are-immutable-objects-useful)
  - [What is a busy spin?](#what-is-a-busy-spin)
  - [List the principles you follow in multithreaded programming?](#list-the-principles-you-follow-in-multithreaded-programming)
  - [Which of the following statements about threads is incorrect?](#which-of-the-following-statements-about-threads-is-incorrect)
  - [Are there 3 threads T1, T2, and T3? How to implement execution in the sequence T1, T2, T3?](#are-there-3-threads-t1-t2-and-t3-how-to-implement-execution-in-the-sequence-t1-t2-t3)
  - [Write a minimum non-blocking stack (there are only two methods, push() and pop()).](#write-a-minimum-non-blocking-stack-there-are-only-two-methods-push-and-pop)
  - [Write a minimal non-blocking stack (there are only two methods, push() and pop()) using Semaphore.](#write-a-minimal-non-blocking-stack-there-are-only-two-methods-push-and-pop-using-semaphore)
  - [Write a minimal non-blocking ArrayList (there are four methods in total: add(), get(), remove(), size()).](#write-a-minimal-non-blocking-arraylist-there-are-four-methods-in-total-add-get-remove-size)
  - [Write a thread-safe implementation of the

 class with a non-blocking BigInteger next() method that returns sequence elements: [1, 2, 4, 8, 16, ...].](#write-a-thread-safe-implementation-of-the-class-with-a-non-blocking-biginteger-next-method-that-returns-sequence-elements-1-2-4-8-16)
  - [Write the simplest multithreaded bounded buffer using synchronized.](#write-the-simplest-multithreaded-bounded-buffer-using-synchronized)
  - [Write the simplest multithreaded bounded buffer using ReentrantLock.](#write-the-simplest-multithreaded-bounded-buffer-using-reentrantlock)



### Tell us about the Java memory model?
The Java Memory Model (JMM) defines how threads interact through memory and establishes rules for visibility and ordering of operations. It specifies how and when changes made by one thread become visible to others. Key concepts include:

- **Visibility**: Ensures that changes made by one thread are visible to others, which can be achieved using synchronized blocks or the `volatile` keyword.
- **Atomicity**: Ensures that a series of operations appear to be instantaneous to other threads. Certain operations (like reading or writing a single variable) are atomic, while others are not.
- **Ordering**: JMM allows compilers and processors to reorder instructions for optimization. However, the "happens-before" relationship is critical for establishing a predictable order of execution.

### What is "thread safety"?
Thread safety is a property of a program or a data structure that guarantees safe execution by multiple threads. In a thread-safe environment, shared data is accessed in a way that prevents race conditions and ensures consistency. Techniques to achieve thread safety include:

- **Synchronization**: Using `synchronized` blocks or methods.
- **Locking**: Employing classes like `ReentrantLock`.
- **Immutable Objects**: Creating objects whose state cannot change after construction.
- **Concurrent Collections**: Utilizing Java's built-in classes like `ConcurrentHashMap`.

### What is the difference between "competition" and "parallelism"?
- **Competition**: Refers to multiple threads attempting to access shared resources, which can lead to issues like race conditions if not managed properly.
- **Parallelism**: Involves running multiple threads simultaneously to perform tasks, often on different cores of a CPU, improving performance for computationally intensive tasks.

### What is "cooperative multitasking"? What type of multitasking does Java use? What is the reason for this choice?
- **Cooperative Multitasking**: Threads voluntarily yield control periodically or when idle, allowing other threads to run.
- **Java's Approach**: Java primarily uses preemptive multitasking, where the scheduler can interrupt and switch threads as needed. This choice enhances responsiveness and better resource utilization but requires careful management of shared resources to avoid issues like deadlock.

### What is ordering, as-if-serial semantics, sequential consistency, visibility, atomicity, happens-before, mutual exclusion, safe publication?
- **Ordering**: Refers to the sequence in which operations are executed and observed by threads.
- **As-if-serial Semantics**: The results of executing concurrent programs should be the same as if they were executed in some sequential order.
- **Sequential Consistency**: A stronger condition where the result of execution is as if all operations were executed in a sequential order.
- **Visibility**: Ensures that changes made by one thread are seen by others.
- **Atomicity**: Ensures that operations are completed without interruption.
- **Happens-before Relationship**: Guarantees that memory writes by one specific statement are visible to another specific statement.
- **Mutual Exclusion**: Ensures that only one thread can access a resource at a time.
- **Safe Publication**: The process of ensuring that an object is safely visible to other threads after being published.

### What is the difference between a process and a thread?
- **Process**: A process is an independent program in execution with its own memory space. Processes do not share memory, which provides protection but incurs overhead for inter-process communication.
- **Thread**: A thread is a lightweight sub-process that shares the same memory space as other threads in the same process. This makes context switching between threads faster but raises issues around synchronization and data consistency.

### What are "green threads" and are they in Java?
- **Green Threads**: These are threads that are scheduled by the Java Virtual Machine (JVM) rather than the operating system. They are primarily used in environments where the OS does not support native threads.
- **Java's Current Implementation**: Modern versions of Java utilize native threads provided by the operating system for thread management, which allows better performance and resource utilization.

### How can I create a flow?
In Java, a flow can be created using the `Thread` class or implementing the `Runnable` interface. Example:

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running.");
    }
}

// Creating a thread
Thread thread = new Thread(new MyRunnable());
thread.start();
```

### What is the difference between Thread and Runnable?
- **Thread**: A class that represents a thread of execution. It can be instantiated directly, and it has methods like `start()` and `run()`.
- **Runnable**: An interface that can be implemented by any class. It allows for the separation of thread execution logic from the thread management. Using `Runnable` is often preferred for better flexibility.

### What is the difference between the start() and run() methods?
- **start()**: This method creates a new thread and invokes the `run()` method in that new thread.
- **run()**: This method contains the code that defines what the thread will do. If `run()` is called directly (instead of through `start()`), it will execute in the current thread, not in a new one.

### How do I force a flow to start?
You cannot force a thread to start; you must call the `start()` method on the `Thread` instance. The thread's state will change from NEW to RUNNABLE, allowing the scheduler to pick it up.

### What is a "monitor" in Java?
A monitor is a synchronization construct that allows threads to safely access shared resources. Every object in Java can be a monitor. When a thread enters a synchronized block or method, it acquires the monitor lock associated with that object, preventing other threads from entering synchronized blocks on the same object.

### Define the concept of "synchronization".
Synchronization is a mechanism to control access to shared resources by multiple threads. It ensures that only one thread can access a resource at a time, preventing data corruption and ensuring thread safety. In Java, synchronization can be achieved using synchronized methods, synchronized blocks, or explicit locks.

### What are the different ways to synchronize in Java?
- **Synchronized methods**: Methods declared with the `synchronized` keyword.
- **Synchronized blocks**: Blocks of code that require synchronization, allowing for finer control over locking.
- **ReentrantLock**: A class that provides more flexible locking mechanisms than synchronized blocks.
- **ReadWriteLock**: Allows concurrent read access while still enforcing exclusive write access.
- **Semaphore**: Controls access to a resource by maintaining a set number of permits.

### What states can a thread be in?
A thread can be in several states:
- **NEW**: The thread is created but not yet started.
- **RUNNABLE**: The thread is ready to run and waiting for CPU time.
- **BLOCKED**: The thread is blocked waiting for a monitor lock to enter a synchronized block/method.
- **WAITING**: The thread is waiting indefinitely for another thread to perform a particular action.
- **TIMED_WAITING**: The thread is waiting for another thread to perform an action for up to a specified waiting time.
- **TERMINATED**: The thread has completed its execution.

### Can I create new instances of a class while the static synchronized method is running?
Yes, you can create new instances of a class while a static synchronized method is running, provided those instances are not using the same lock. However, operations that require synchronization on the same class or instance will be blocked until the synchronized method completes.

### Why do you need a private mutex?
A private mutex (or lock) is used to restrict access to a resource to only the threads that need it. By using a private mutex, you can ensure that the resource is only accessed by intended threads, preventing unintended interference and enhancing thread safety.

### How do the wait() and notify()/notifyAll() methods work?
- **wait()**: Causes the current thread to release the lock it holds and enter a waiting state until another thread invokes notify or notifyAll on the same object.
- **notify()**: Wakes up a single thread that is waiting on the object's monitor.
- **notifyAll()**: Wakes up all threads waiting on the object's monitor. 

These methods must be called from within a synchronized block.

### What is the difference between notify() and notifyAll()?
- **notify()**: Wakes up one waiting thread. If multiple threads are waiting, the choice of which thread to wake is non-deterministic.
- **notifyAll()**: Wakes up all waiting threads. This can lead to contention as multiple threads may compete for the monitor.

### Why are the wait() and notify() methods called only in a synchronized block?
These methods need to be called while holding the object's monitor to ensure that the thread has exclusive access to the object's state. This prevents inconsistencies that could arise from other threads modifying the state while the current thread is waiting or being notified.

### What is the difference between the wait() method with and without the parameter?
- **wait()**: Causes the thread to wait indefinitely until notified.
- **wait(long timeout)**: Causes the thread to wait for a specified period. If the thread is not notified within that time, it will automatically wake up.

### What is the difference between the Thread.sleep() and Thread.yield() methods?
- **Thread.sleep(millis)**: Causes the current thread to pause execution for a specified time, releasing the CPU but not releasing any locks it holds.
- **Thread.yield()**: Suggests to the thread scheduler that the current thread is willing to yield its current use of the CPU. This may allow other threads to run, but it does not

 guarantee that they will.

### How does the Thread.join() method work?
The `join()` method allows one thread to wait for the completion of another thread. When `join()` is called on a thread, the calling thread will block until the specified thread completes its execution.

### What is deadlock?
Deadlock occurs when two or more threads are blocked forever, each waiting for a resource held by another thread. To avoid deadlocks, you can use techniques like:

- **Lock ordering**: Always acquire locks in a consistent order.
- **Timeouts**: Set timeouts on lock attempts to avoid waiting indefinitely.
- **Deadlock detection**: Implement mechanisms to detect deadlocks and recover.

### What is livelock?
Livelock is a situation where threads are not blocked but are continuously changing states in response to each other without making progress. Unlike deadlock, threads are active but unable to complete their tasks.

### How do I check if a thread is holding a monitor for a specific resource?
You can use the `Thread.getState()` method to check the state of a thread, but there's no direct way in Java to check if a specific thread holds a monitor. However, using tools like JVisualVM or profilers can help analyze thread states and monitor locks.

### On which object does synchronization occur when the static synchronized method is called?
When a static synchronized method is called, synchronization occurs on the Class object itself (i.e., `ClassName.class`). This means that all static synchronized methods of a class are synchronized on the same monitor.

### What is the keyword volatile, synchronized, transient, native used for?
- **volatile**: Indicates that a variable's value will be modified by different threads. It ensures visibility of changes to variables across threads.
- **synchronized**: Used to declare synchronized methods or blocks to prevent concurrent access.
- **transient**: Prevents serialization of a variable, meaning it will not be saved when the object is serialized.
- **native**: Indicates that a method is implemented in native code (e.g., C or C++) and not in Java.

### What are the differences between volatile and atomic variables?
- **volatile**: Ensures visibility of changes to variables across threads but does not guarantee atomicity for compound actions (e.g., incrementing).
- **Atomic variables** (like `AtomicInteger`): Provide methods that are thread-safe and atomic, ensuring both visibility and atomicity for compound actions.

### What are the differences between `java.util.concurrent.Atomic*.compareAndSwap()` and `java.util.concurrent.Atomic*.weakCompareAndSwap()`?
- **compareAndSwap**: A strong compare-and-swap operation that updates the variable only if it matches the expected value.
- **weakCompareAndSwap**: A more relaxed version that may succeed even if the expected value is not strictly followed. It may be less efficient but can offer better performance in certain cases.

### What does "thread priority" mean?
Thread priority is a hint to the thread scheduler about the relative importance of threads. A higher priority thread is generally executed before lower priority threads, but actual behavior may vary across different JVM implementations and operating systems.

### What are "daemon threads"?
Daemon threads are low-priority threads that run in the background and do not prevent the JVM from exiting when the program finishes. They are typically used for background tasks, such as garbage collection.

### Can I make the main thread of a program a daemon?
No, the main thread cannot be set as a daemon thread. Once the main thread is started, it is treated as a user thread, and daemon threads are only threads that run in the background.

### What does it mean to "put to sleep" the thread?
"Putting to sleep" a thread means pausing its execution for a specified duration. This can be achieved using the `Thread.sleep(milliseconds)` method, which releases the CPU but keeps the thread alive.

### What is the difference between the Runnable and Callable interfaces?
- **Runnable**: Represents a task that does not return a result and cannot throw a checked exception.
- **Callable**: Represents a task that can return a result and can throw checked exceptions. It is used with the `Future` interface to retrieve results asynchronously.

### What is FutureTask?
`FutureTask` is a class that implements `Runnable` and `Future`. It represents a cancellable asynchronous computation. It can be used to manage the lifecycle of a task, including checking if it’s completed, cancelling it, and retrieving the result.

### What are the differences between CyclicBarrier and CountDownLatch?
- **CyclicBarrier**: A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point. It can be reused after the waiting threads have been released.
- **CountDownLatch**: A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes. It cannot be reused once the count reaches zero.

### What is a race condition?
A race condition occurs when two or more threads access shared data and try to change it at the same time. The final outcome depends on the timing of how the threads are scheduled, leading to unpredictable results.

### Is there a way to solve the race condition problem?
Race conditions can be solved using various synchronization techniques, such as:
- **Locks**: Use `ReentrantLock` or other locking mechanisms.
- **Synchronized blocks/methods**: Ensure that only one thread can access critical sections at a time.
- **Atomic variables**: Use atomic classes that ensure operations are performed atomically.

### How to stop the thread?
To stop a thread safely:
- Use a flag: Set a boolean variable that the thread checks periodically to determine if it should terminate.
- Avoid using `Thread.stop()`, as it can lead to inconsistent states.

### Why is it not recommended to use the Thread.stop() method?
`Thread.stop()` is deprecated because it forcibly terminates a thread, leading to potential issues like resource leaks and data corruption. It does not give the thread a chance to release resources or perform cleanup.

### What happens when an exception is thrown in a thread?
When an uncaught exception is thrown in a thread, it terminates that thread and invokes the `uncaughtException()` method of the `Thread.UncaughtExceptionHandler` if set. If not handled, the exception may not affect other threads.

### What is the difference between interrupted() and isInterrupted()?
- **interrupt()**: Used to signal a thread that it should stop what it's doing and handle the interrupt. It sets the interrupt flag.
- **isInterrupted()**: Checks whether the thread has been interrupted without clearing the interrupt status. It returns true if the thread was interrupted.

### What is a "thread pool"?
A thread pool is a collection of pre-initialized threads that are ready to execute tasks. It helps manage thread creation and resource usage, reducing the overhead of creating and destroying threads.

### What size should a thread pool be?
The optimal size of a thread pool depends on the application's nature, the number of available CPU cores, and the types of tasks being executed. A common rule is to set the pool size to the number of available processors multiplied by a factor based on the task's workload.

### What happens if the thread pool queue is already full, but a new task is submitted?
If the thread pool's queue is full and a new task is submitted, the behavior depends on the rejection policy configured for the thread pool. Common policies include:
- **AbortPolicy**: Throws a `RejectedExecutionException`.
- **CallerRunsPolicy**: Executes the task in the calling thread.
- **DiscardPolicy**: Silently discards the task.

### What is the difference between the submit() and execute() methods of a thread pool?
- **execute()**: Accepts a `Runnable` task for execution but does not return a result or allow for exceptions to be caught.
- **submit()**: Accepts a `Callable` or `Runnable` task and returns a `Future` object, allowing the caller to retrieve the result or handle exceptions.

### What are the differences between a stack and a heap in terms of multithreading?
- **Stack**: Each thread has its own stack for storing method calls, local variables, and return addresses. The stack is thread-safe since each thread has its own.
- **Heap**: The heap is shared among all threads and is where objects are allocated. Proper synchronization is required to prevent concurrent access issues.

### How do I share data between two threads?
Data can be shared between threads using:
- **Shared variables**: Declared as `volatile` or managed with synchronization.
- **Data structures**: Use concurrent collections like `ConcurrentHashMap`.
- **Thread-safe classes**: Use classes that ensure thread-safe operations.

### What JVM startup option is used to control the size of a thread's stack?
The `-Xss` option can be used to set the thread stack size. For example, `-Xss512k` sets the stack size to 512 kilobytes.

### How do I get a thread dump?
A thread dump can be obtained using:
- **jstack**: A command-line utility that comes with the JDK, used to generate thread dumps of a running Java application.
- **JVisualVM**: A graphical tool for monitoring and profiling Java applications that can also capture thread dumps.

### What is a ThreadLocal variable?
`ThreadLocal` is a class that provides thread-local variables. Each thread accessing a `ThreadLocal` variable has its own, independently initialized copy of the variable. This is useful for maintaining user sessions or database connections.

### What are the differences between synchronized and ReentrantLock?
- **Synchronized**: Built-in Java synchronization mechanism that is simpler to use but less flexible. It automatically releases locks when a thread exits the synchronized block.
- **ReentrantLock**: A more flexible locking mechanism that allows features like try-lock

, timed lock attempts, and interruptible lock acquisition.

### What is ReadWriteLock?
`ReadWriteLock` is an interface that allows multiple threads to read a shared resource concurrently while ensuring exclusive access for write operations. It has two locks: one for reading and one for writing.

### What is the "blocking method"?
A blocking method is a method that causes the calling thread to wait until a condition is met or a resource becomes available. Examples include `Object.wait()`, `Thread.join()`, and methods that involve acquiring a lock.

### What is a "Fork/Join framework"?
The Fork/Join framework is a Java concurrency framework designed to take advantage of multiple processors by dividing tasks into smaller sub-tasks that can be processed in parallel. It uses the `ForkJoinPool` class, which manages a pool of worker threads.

### What is Semaphore?
A `Semaphore` is a synchronization aid that maintains a set number of permits, allowing threads to acquire or release permits. It is used to control access to a limited number of resources.

### What is a double-checked locking Singleton?
Double-checked locking is a design pattern used to implement the Singleton pattern in a thread-safe manner. It checks if the instance is null twice—once before acquiring the lock and once after—to minimize synchronization overhead.

### How do I create a thread-safe Singleton?
To create a thread-safe Singleton:
1. Use a private static instance.
2. Create a private constructor.
3. Use synchronized methods or blocks or utilize the Bill Pugh Singleton design (using an inner static helper class).

### Why are immutable objects useful?
Immutable objects are beneficial in multithreading because their state cannot change after creation. This makes them inherently thread-safe, preventing issues related to shared mutable state.

### What is a busy spin?
A busy spin is a loop that continuously checks for a condition to become true, effectively consuming CPU cycles while waiting. It is generally inefficient and can lead to performance issues.

### List the principles you follow in multithreaded programming?
- Minimize shared mutable state.
- Use proper synchronization.
- Favor immutability when possible.
- Prefer higher-level concurrency abstractions (like `ExecutorService`) over manual thread management.
- Avoid deadlocks through careful lock ordering and timeout policies.
- Test thoroughly for concurrency issues.

### Which of the following statements about threads is incorrect?
This question is subjective and would require specific statements to evaluate their correctness.

### Are there 3 threads T1, T2, and T3? How to implement execution in the sequence T1, T2, T3?
You can use `Thread.join()` to ensure that T1 completes before T2 starts, and T2 completes before T3 starts:

```java
Thread t1 = new Thread(() -> { /* T1 logic */ });
Thread t2 = new Thread(() -> { /* T2 logic */ });
Thread t3 = new Thread(() -> { /* T3 logic */ });

t1.start();
t1.join(); // Wait for T1 to finish

t2.start();
t2.join(); // Wait for T2 to finish

t3.start();
```

### Write a minimum non-blocking stack (there are only two methods, push() and pop()).
Here’s a simple implementation using `AtomicReference`:

```java
import java.util.concurrent.atomic.AtomicReference;

class NonBlockingStack<T> {
    private final AtomicReference<Node<T>> head = new AtomicReference<>();

    private static class Node<T> {
        final T value;
        final Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        Node<T> newHead = new Node<>(value, head.get());
        while (!head.compareAndSet(newHead.next, newHead)) {
            newHead = new Node<>(value, head.get());
        }
    }

    public T pop() {
        Node<T> currentHead;
        do {
            currentHead = head.get();
            if (currentHead == null) return null; // Stack is empty
        } while (!head.compareAndSet(currentHead, currentHead.next));
        return currentHead.value;
    }
}
```

### Write a minimal non-blocking stack (there are only two methods, push() and pop()) using Semaphore.
Using `Semaphore` to limit access can be implemented but is not typical for a stack. A simple example is as follows:

```java
import java.util.concurrent.Semaphore;

class SemaphoreStack<T> {
    private final Object[] stack;
    private int top = -1;
    private final Semaphore semaphore;

    public SemaphoreStack(int size) {
        stack = new Object[size];
        semaphore = new Semaphore(size);
    }

    public void push(T value) throws InterruptedException {
        semaphore.acquire();
        stack[++top] = value;
    }

    public T pop() {
        if (top < 0) return null; // Stack is empty
        T value = (T) stack[top--];
        semaphore.release();
        return value;
    }
}
```

### Write a minimal non-blocking ArrayList (there are four methods in total: add(), get(), remove(), size()).
Here’s a simple non-blocking implementation using `AtomicInteger`:

```java
import java.util.concurrent.atomic.AtomicInteger;

class NonBlockingArrayList<T> {
    private Object[] array = new Object[10];
    private final AtomicInteger size = new AtomicInteger(0);

    public void add(T value) {
        int index = size.get();
        if (index >= array.length) {
            // Resize logic can be added
            return;
        }
        array[index] = value;
        size.incrementAndGet();
    }

    public T get(int index) {
        if (index < 0 || index >= size.get()) return null;
        return (T) array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size.get()) return null;
        T value = (T) array[index];
        // Shift elements left
        System.arraycopy(array, index + 1, array, index, size.get() - index - 1);
        size.decrementAndGet();
        return value;
    }

    public int size() {
        return size.get();
    }
}
```

### Write a thread-safe implementation of the class with a non-blocking BigInteger next() method that returns sequence elements: [1, 2, 4, 8, 16, ...].
This implementation uses `AtomicLong` for thread safety:

```java
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

class NonBlockingSequence {
    private final AtomicLong current = new AtomicLong(1);

    public BigInteger next() {
        return BigInteger.valueOf(current.getAndUpdate(n -> n * 2));
    }
}
```

### Write the simplest multithreaded bounded buffer using synchronized.
Here’s a simple bounded buffer using synchronized methods:

```java
class BoundedBuffer<T> {
    private final Object[] buffer;
    private int count, in, out;

    public BoundedBuffer(int size) {
        buffer = new Object[size];
        count = in = out = 0;
    }

    public synchronized void put(T value) throws InterruptedException {
        while (count == buffer.length) {
            wait(); // Buffer is full
        }
        buffer[in] = value;
        in = (in + 1) % buffer.length;
        count++;
        notifyAll(); // Notify consumers
    }

    public synchronized T take() throws InterruptedException {
        while (count == 0) {
            wait(); // Buffer is empty
        }
        T value = (T) buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        notifyAll(); // Notify producers
        return value;
    }
}
```

### Write the simplest multithreaded bounded buffer using ReentrantLock.
Here’s a bounded buffer using `ReentrantLock`:

```java
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class BoundedBufferLock<T> {
    private final Object[] buffer;
    private int count, in, out;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public BoundedBufferLock(int size) {
        buffer = new Object[size];
        count = in = out = 0;
    }

    public void put(T value) throws InterruptedException {
        lock.lock();
        try {
            while (count == buffer.length) {
                notFull.await(); // Buffer is full
            }
            buffer[in] = value;
            in = (in + 1) % buffer.length;
            count++;
            notEmpty.signal(); // Notify consumers
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // Buffer is empty
            }
            T value = (T) buffer[out];
            out = (out + 1) % buffer.length;
            count--;
            notFull.signal(); // Notify producers
            return value;
        } finally {
            lock.unlock();
        }
    }
}
```



Tell us about the Java memory model?
The Java Memory Model (JMM) describes the behavior of threads in the Java runtime. It is part of the semantics of the Java language, a set of rules that describe the execution of multithreaded programs and rules by which threads can communicate with each other through main memory.

Formally, the memory model defines a set of interthreaded communication actions (these actions include, in particular, reading and writing a variable, capturing and freeing a monitor, reading and writing a volatile variable, starting a new thread), and the memory model defines the relationship between these actions -happens-before - an abstraction denoting that if an operation X is related by a happens-before relationship to an operation Y, then all the code that follows operation Ythat runs on one thread sees all the changes made by the other thread before operation X.

There are a few basic rules for the happens-before relationship:

Within a single thread, any operation happens-before any operation that follows it in the source code;
Unlock: happens-before to capture the same monitor (lock);
Exit the block/method happens-before entering the block/method on the same monitor;synchronizedsynchronized
Writing the happens-before field, reading the same field;volatilevolatile
Terminating an instance method of the happens-before class exiting the method or returning an instance of the same thread by the method;run()Threadjoin()falseisAlive()
Calling the method of an instance of the happens-before class, the beginning of the method of an instance of the same thread;start()Threadrun()
The completion of the happens-before constructor is the beginning of the method of this class;finalize()
Calling the method on the happens-before thread when the thread detects that the method was called either by throwing an exception or by using the or methods.interrupt()InterruptedExceptionisInterrupted()interrupted()
The happens-before relationship is transitive, i.e. if X happens-before Y, and Y happens-before Z, then X happens-before Z.
A monitor release/capture and a write/read to a variable are related by a happens-before relationship only if the operations are performed on the same instance of the object.volatile
Only two threads participate in the happens-before relationship, and nothing can be said about the behavior of the other threads until each has a happens-before relationship with the other thread.
There are several main areas related to the memory model:

Visibility. One thread may at some point temporarily store the value of some fields not in main memory, but in registers or the local cache of the processor, so that a second thread running on a different processor, reading from main memory, may not see the latest changes to the field. Conversely, if a thread has been working with registers and local caches for a period of time, reading data from there, it may not immediately see the changes made by another thread to main memory.

The following Java keywords are relevant to the issue of visibility: , , .synchronizedvolatilefinal

From Java's point of view, all variables (except for local variables declared inside a method) are stored in main memory, which is accessible to all threads, and each thread has local memory, where it stores copies of the variables it is working with, and when the program is executed, the thread works only with those copies. It should be noted that this description is not an implementation requirement, but just a model that explains the behavior of the program, so the local memory does not necessarily act as cache memory, it can be processor registers or threads may not have local memory at all.

When a thread enters a method or block, it updates the contents of local memory, and when it exits a method or block, the thread writes the changes made in local memory to the master memory. This behavior of methods and blocks follows from the rules for the "happens before" relationship: since all memory operations occur before the monitor is freed, and the monitor is released before the monitor is captured, all memory operations that were performed by the thread before exiting the block should be visible to any thread that enters the block for the same monitor. It is very important that this rule only works if the threads are synchronized using the same monitor!synchronizedsynchronizedsynchronizedsynchronizedsynchronized

As for variables, such variables are written to main memory, bypassing local memory. and the variable is also read from main memory, that is, the value of the variable cannot be stored in registers or local memory of the thread, and the operation of reading this variable is guaranteed to return the last value written to it.volatilevolatile

The memory model also defines additional keyword semantics related to visibility: once an object has been created correctly, any thread can see the values of its fields without additional synchronization. "Correctly created" means that the reference to the object being created should not be used until the object constructor has completed. The presence of such semantics for the keyword allows the creation of immutable objects containing only fields, such objects can be freely transferred between streams without ensuring synchronization during transmission.finalfinalfinalfinal

There is one problem with fields: the implementation allows the values of such fields to be changed after the object is created (this can be done, for example, using the reflection mechanism). If the value of a field is a constant whose value is known at the time of compilation, changes to such a field may have no effect, since the compiler may have replaced the references to this variable with a constant. The specification also allows for other optimizations related to fields, for example, reads of a variable can be reordered with operations that could potentially modify such a variable. So it's a good idea to change the object fields only inside the constructor, otherwise the behavior isn't specified.finalfinalfinalfinalfinal

Reordering. To increase performance, the processor/compiler may rearrange some instructions/operations. More precisely, from the point of view of a thread watching the execution of operations on another thread, operations may not be executed in the order in which they appear in the source code. The same effect can occur when one thread puts the results of the first operation into a register or local cache, and the result of the second operation goes directly to main memory. Then the second thread, accessing the main memory, can first see the result of the second operation, and only then the first, when all registers or caches are synchronized with the main memory. Another reason for reordering may be that the processor may decide to change the order of operations if, for example, it thinks that such a sequence will execute faster.

The issue of reordering is also governed by a set of rules for the "happens before" relationship, and these rules have a consequence regarding the order of operations used in practice: the reads and writes of variables cannot be reordered with the reads and writes of other and non-variables. This consequence makes it possible to use the variable as a flag to signal the completion of an action. Otherwise, the rules regarding the order of operations ensure that operations are ordered for a particular set of cases (such as capturing and releasing a monitor), leaving the compiler and processor free to optimize in all other cases.volatilevolatilevolatilevolatile

to the table of contents

What is "thread safety"?
Thread safety is a property of an object or code that ensures that when executed or used by multiple threads, the code will behave as intended. For example, a thread-safe counter will not miss any count, even if the same instance of that counter is used by multiple threads.

to the table of contents

What is the difference between "competition" and "parallelism"?
Competition is a way of solving many problems at the same time.

Signs:

Having multiple control threads (e.g., Thread in Java, coroutine in Kotlin), if there is only one control thread, then there can be no concurrent execution
Non-deterministic execution result. The result depends on random events, implementation, and how the synchronization was performed. Even if each thread is fully deterministic, the final result will be non-deterministic
Concurrency is a way of doing different parts of the same task.

Signs:

Does not necessarily have multiple control flows
It can lead to a deterministic result, for example, the result of multiplying each element of an array by a number does not change if it is multiplied in parts in parallel.
to the table of contents

What is "cooperative multitasking"? What type of multitasking does Java use? What is the reason for this choice?
Cooperative multitasking is a way of dividing CPU time between threads, in which each thread is required to give control to the next one voluntarily.

The advantages of this approach are ease of implementation, lower overhead for context switching.

Disadvantages - if one thread hangs or behaves incorrectly, then the entire system freezes and other threads will never get control.

Java uses preemptive multitasking, in which the decision to switch between threads in a process is made by the operating system.

Unlike cooperative multitasking, control of the operating system is transferred regardless of the state of running applications, so that individual hung threads of the process, as a rule, do not "suspend" the entire system. Regular switching between tasks also improves the responsiveness of the application and makes it faster to free up resources that are no longer in use.

In implementation, preemptive multitasking differs from cooperative multitasking, in particular, in that it requires system interrupt processing from a hardware timer.

to the table of contents

What is ordering, as-if-serial semantics, sequential consistency, visibility, atomicity, happens-before, mutual exclusion, safe publication?
ordering mechanism, which determines when one thread can see the out-of-order order of another thread's instructions. To improve performance, the CPU can reorder CPU instructions and execute them in an arbitrary order until no differences are visible to the thread inside. The guarantee provided by this mechanism is called as-if-serial semantics.

sequential consistency is the same as as-if-serial semantics, ensuring that within a single thread the side effects of all operations are as if all operations are performed sequentially.

Visibility determines when actions in one thread become visible from another thread.

happens-before - a logical constraint on the order in which the program's instructions are executed. If it is specified that writing to a variable and its subsequent reading are related through this dependency, then no matter how the instructions are reordered during execution, at the time of reading, all the results related to the writing process are already recorded and visible.

atomicity — atomicity of operations. An atomic operation appears to be a single and indivisible processor instruction that can be either already executed or not yet executed.

Mutual exclusion is a mechanism that ensures that a thread has exclusive access to a resource. Used to prevent concurrent access to a shared resource. Only one thread can own such a resource at a time. The simplest example: .synchronized(obj) { … }

safe publication? - Showing objects to other threads in the current stream without violating visibility constraints. Methods of such publication in Java:

static{} Initializer;
volatile Variables;
atomic Variables;
Persistence in a shared variable that is properly protected using synchronizers or other constructs that create a read/write memory barriersynchronized();
final variables in a shared object that has been correctly initialized.
to the table of contents

What is the difference between a process and a flow?
Process: A runtime instance of a program, an independent object that is allocated system resources (such as CPU time and memory). Each process runs in a separate address space: one process cannot access the variables and data structures of another. If a process wants to access other people's resources, it must use interprocess communication. These can be pipelines, files, communication channels between computers, and more.

For each process, the OS creates what is known as a "virtual address space" to which the process has direct access. This space belongs to the process, contains only its data, and is at its complete disposal. The operating system is responsible for how the virtual space of the process is projected onto physical memory.

Thread is a certain way of executing a process that determines the sequence of code execution in a process. Flows are always created in the context of a process, and their entire life takes place only within its boundaries. Threads can execute the same code and manipulate the same data, and they can share kernel object handles because the handle table is not created in separate threads, but in processes. Because threads consume significantly fewer resources than processes, it is more cost-effective to create additional threads and avoid creating new processes while doing work.

to the table of contents

What are "green streams" and are they in Java?
Green threads are threads emulated by a virtual machine or runtime. The creation of a green flow does not imply the creation of an actual OS flow.

The Java Virtual Machine takes care of switching between different green threads, and the machine itself runs as a single OS thread. This has several advantages. OS threads are relatively expensive in most POSIX systems. In addition, switching between native threads is much slower than switching between green threads.

This all means that in some situations, green threads are much more profitable than native threads. A system can support many more green threads than OS threads. For example, it is much more practical to run a new green thread for a new HTTP connection to a web server, rather than creating a new native thread.

However, there are also disadvantages. The biggest one is that you can't execute two threads at the same time. Since there is only one native thread, it is the only one that is called by the OS scheduler. Even if you have multiple processors and multiple green threads, only one processor can call green thread. And that's because, from the point of view of the OS task scheduler, it all looks like a single thread.

As of version 1.2, Java supports native threads, and they have been used by default ever since.

to the table of contents

How can I create a flow?
Create a child of a class and override its method Threadrun();
Create a class object by passing it an instance of the class that implements the . This interface contains a method that will be executed on the new thread. A thread will end execution when its .ThreadRunnablerun()run()
Call a method on an instance of the class that implements the interface, passing it an instance of the class that implements the interface or (contains a method that describes the execution logic) as a parameter.submit()ExecutorServiceRunnableCallablecall()
to the table of contents

What is the difference between ?ThreadRunnable
Thread is a class, a kind of superstructure on top of the physical flow.

Runnable is an interface that represents an abstraction over the task being performed.

In addition to helping to solve the problem of multiple inheritance, the undoubted advantage of using it is that it allows you to logically separate the logic of the task execution from the direct control of the thread.Runnable

to the table of contents

What is the difference between the methods and ?start()run()
Even though it calls a method within itself, it is not the same as simply calling . If called as a normal method, then it is called on the same thread and no new thread is started as it is when you call the .start()run()run()run()start()

to the table of contents

How do I force a flow to start?
Nohow. In Java, there is absolutely no way to force a thread to start. This is controlled by the JVM and Java does not provide any API to manage this process.

to the table of contents

What is a "monitor" in Java?
A monitor, mutex is a means of providing access control to a resource. A monitor can have a maximum of one owner at any given time. Therefore, if someone is using a resource and has captured the monitor to provide sole access, then someone else who wants to use the same resource must wait for the monitor to become available, capture it, and only then start using the resource.

It is convenient to think of the monitor as the id of the object that captured it. If this id is equal to 0, the resource is free. If not 0, the resource is busy. You can get in line and wait for his release.

In Java, each instance of an object has a monitor that is controlled directly by the virtual machine. It is used as follows: any non-static -method, when called, first of all tries to capture the monitor of the object from which it is called (which it can refer to as ). If it succeeds, the method is executed. If not, the stream stops and waits for the monitor to be released.synchronizedthis

to the table of contents

Define the concept of "synchronization".
Synchronization is the process that allows threads to run in parallel.

In Java, all objects have a single lock, so that only one thread can access critical code in an object at a time. This synchronization helps prevent damage to the object's state. If a thread has acquired a lock, no other thread can enter the synchronized code until the lock is released. When the thread that owns the lock exits the synchronized code, the lock is released. Now another thread can acquire the lock on the object and execute the synchronized code. If a thread attempts to acquire a lock on an object while another thread owns the lock, the thread enters the Lock state until the lock is released.

to the table of contents

What are the different ways to synchronize in Java?
System synchronization using wait()/notify(). A thread that waits for any conditions to be met calls the object the method after capturing its monitor. At this point, its work is suspended. Another thread can call a method on the same object (again, after capturing the object's monitor), as a result of which the thread waiting on the object "wakes up" and continues its execution. In both cases, the monitor must be captured explicitly, through the -block, because the / methods are not synchronized!wait()notify()synchronizedwait()notify()

System synchronization using join(). The method called on an instance of the class allows the current thread to stop until the thread associated with that instance finishes its work.join()Thread

Using classes from the java.util.concurrent package, which provides a set of classes for interthreaded communication. Examples of such classes are , etc. The concept of this approach is to use atomic operations and variables.LockSemaphore

to the table of contents

What states can a thread be in?
Threads can be in one of the following states:

New. Once an instance of a thread is created, it remains in the New state until the . In this state, the stream is not considered alive.start()
Runnable. A thread enters the Healthy state when the . A thread can also enter this state from the Running state or from the Blocked state. When a stream is in this state, it is considered alive.start()
Running. A thread moves from the Healthy state to the Running state when the Thread Scheduler selects it as currently running.
Alive, but not runnable. A stream can be live, but not healthy for several reasons:
Waiting. The thread enters the Wait state by calling the . A call or can move a thread from a Waiting state to a Healthy state.wait()notify()notifyAll()
Sleeping. The method puts the thread into a Sleep state for a specified amount of time in milliseconds.sleep()
Blocked. A thread can enter this state while waiting for a resource such as I/O, or because another object is locked. In this case, the thread enters the Healthy state when the resource becomes available.
Dead. A thread is considered dead when its method is fully executed. A dead thread cannot enter any other state, even if the .run()start()
to the table of contents

Can I create new instances of a class while the method is running?static synchronized
Yes, you can create new instances of the class, because static fields do not belong to instances of the class.

to the table of contents

Why do you need a mutex?private
An object to be synchronized is made so that third-party code cannot synchronize to it and accidentally acquire a deadlock.private

to the table of contents

How do the and / methods work?wait()notify()notifyAll()
These methods are thinned out for the class and are designed for threads to communicate with each other during interthreaded synchronization.Object

wait(): frees the monitor and puts the calling thread in a waiting state until another thread calls the notify()/notifyAll();
notify(): continues the thread that previously had the wait();
notifyAll(): resumes all threads that previously had the .wait()
When the , method is called, the thread releases the lock on the object and transitions from the Running state to the Waiting state. The method signals one of the threads waiting on the object to enter the Runnable state. However, it is not possible to determine which of the waiting threads should become healthy. The method causes all waiting threads for the object to return to the Runnable state. If no thread is waiting on the method, then nothing happens when called or nothing happens.wait()notify()notifyAll()wait()notify()notifyAll()

A thread can call methods or on a particular object only if it currently has a lock on that object. , and should only be called from synchronized code.wait()notify()wait()notify()notifyAll()

to the table of contents

What is the difference between and ?notify()notifyAll()
The fact is that several threads can "hang" on the method of one monitor at once. When called, only one of them comes out and tries to capture the monitor, and then continues from the next one after the operator. Which of them will come out is not known in advance. And when called, all hanging threads exit the stream, and they all try to capture the monitor. It is clear that at any given time, the monitor can be captured by only one thread, and the others are waiting for their turn. The order of the queue is determined by the Java thread scheduler.wait()notify()wait()wait()notifyAll()wait()wait()

to the table of contents

Why are and methods called only in a synchronized block?wait()notify()
The monitor must be captured explicitly (via the -block) because the methods are not synchronized.synchronizedwait()notify()

to the table of contents

What is the difference between working with and without a parameter?wait()
wait()

Without parameters, releases the monitor and puts the calling thread in a waiting state until another thread calls the / method,notify()notifyAll()
with parameters will make the thread wait a given amount of time or call to /.notify()notifyAll()
to the table of contents

What is the difference between the methods and ?Thread.sleep()Thread.yield()
The method causes a thread to move from a running state to a runnable state, allowing other threads to become active. But the next thread you choose to run may not be different.yield()

The method causes the current thread to fall asleep for a specified amount of time, and the state changes from running to waiting.sleep()

to the table of contents

How does the method work?Thread.join()
When a thread calls for another thread, the currently running thread will wait until the other thread it joins is terminated:join()

void join()        
void join(long millis) 
void join(long millis, int nanos) 
to the table of contents

What is deadlock?
Deadlock is a phenomenon in which all threads are in standby mode. Occurs when the following states are reached:

Mutual exclusion: At least one resource is in indivisible mode, and therefore only one thread can use the resource at any given time.
Holds and waits: A thread holds at least one resource and requests additional resources that are held by other threads.
No pre-cleanup: The operating system does not reassign resources: if they are already occupied, they should be given to holding threads immediately.
Circular waiting: A thread waits for another thread to release a resource, which in turn waits for the resource locked by the first thread to be released.
The simplest way to avoid deadlock is to avoid cyclical waiting. This can be achieved by retrieving the shared resource monitors in a certain order and releasing them in reverse order.

to the table of contents

What is livelock?
Livelock is a type of deadlock in which multiple threads do useless work, getting stuck in a loop when trying to get some resources. At the same time, their states are constantly changing depending on each other. There is no actual error, but the efficiency of the system drops to 0. Often occurs as a result of attempts to prevent deadlock.

A real-life example of a livelock is when two people meet in a narrow hallway and each of them, trying to be polite, steps aside, and so they move endlessly from side to side, with absolutely no movement in the direction they want.

to the table of contents

How do I check if a thread is holding a monitor for a specific resource?
The method returns when the current thread holds the monitor at a particular object.Thread.holdsLock(lock)true

to the table of contents

On which object does synchronization occur when the method is called?static synchronized
A synchronized static method does not have access to , but it does have access to an object of the class, which is present in a single instance and acts as a monitor for synchronizing static methods. Thus, the following construction:thisClass

public class SomeClass {

    public static synchronized void someMethod() {
        //code
    }
}
is equivalent to this:

public class SomeClass {

    public static void someMethod(){
        synchronized(SomeClass.class){
            //code
        }
    }
}
to the table of contents

What is the keyword , , , , ?volatilesynchronizedtransientnative
Volatile - This modifier forces threads to disable access optimization and use a single instance of the variable. If the variable is of a primitive type, this will be enough to ensure thread safety. If the variable is a reference to an object, only the value of this reference will be synchronized. However, the data contained in the object will not be synchronized!

synchronized is a reserved word that allows you to achieve synchronization in methods or blocks of code marked with it.

Keywords have nothing to do with multithreading, the first is used to specify class fields that do not need to be serialized, and the second signals that the method is implemented in platform-specific code.transientnative

to the table of contents

What are the differences between and Atomic variables?volatile
volatile forces the use of a single instance of a variable, but does not guarantee atomicity. For example, an operation will not become atomic simply because . On the other hand, it provides an atomic method to perform such complex operations atomically, such as atomic replacement of an increment operator, it can be used to atomically increment the current value by one. Atomic versions are constructed in a similar way for other types of data.count++countvolatileclass AtomicIntegergetAndIncrement()

to the table of contents

What are the differences between and .java.util.concurrent.Atomic*.compareAndSwap()java.util.concurrent.Atomic*.weakCompareAndSwap()
weakCompareAndSwap() does not create a memory barrier and does not guarantee happens-before;
weakCompareAndSwap() highly dependent on cache/CPU, and can return for no apparent reason;false
weakCompareAndSwap(), which is lighter, but not supported by all architectures and not always effective.
to the table of contents

What does "flow priority" mean?
Thread priorities are used by the thread scheduler to decide when which thread will be allowed to run. In theory, high-priority threads get more CPU time than low-priority threads. In practice, the amount of CPU time a thread receives often depends on several factors besides its priority.

To set the priority of a thread, you use the class method: . The value varies from to . The default priority is .Threadfinal void setPriority(int level)levelThread.MIN_PRIORITY = 1Thread.MAX_PRIORITY = 10Thread.NORM_PRlORITY = 5

You can get the current priority value of a thread by calling the method: on an instance of the .final int getPriority()Thread

to the table of contents

What are "demon flows"?
Daemon threads run in the background along with the program, but are not an integral part of the program. If a process can run against the background of the main threads of execution and its activity is to serve the main threads of the application, then such a process can be started as a daemon thread using the method called on the thread before it starts. The method allows you to determine whether the specified thread is a daemon or not. A basic property of daemon threads is the ability of the main application thread to terminate the daemon thread (as opposed to normal threads) with the end of the method code, regardless of the fact that the daemon thread is still running.setDaemon(boolean value)boolean isDaemon()main()

to the table of contents

Can I make the main thread of a program a daemon?
No. Daemon threads allow you to describe background processes that are only needed to serve the main threads of execution and cannot exist without them.

to the table of contents

What does it mean to "put to sleep" the stream?
This means to pause it for a certain period of time by calling a static method during its execution, passing the required amount of time in milliseconds as a parameter. Before this time has elapsed, the thread can be brought out of the waiting state by an outcast call.Thread.sleep()interrupt()InterruptedException

to the table of contents

What is the difference between the two interfaces and ?RunnableCallable
The interface appeared in Java 1.0, and the interface was introduced in Java 5.0 as part of the RunnableCallablejava.util.concurrent;
Classes that implement an interface to perform a task must implement the . Classes that implement an interface - the Runnablerun()Callablecall();
The method does not return any value, it returns an object that can contain the result of the calculations;Runnable.run()Callable.call()Future
A method cannot throw checked exceptions, whereas a method can.run()call()
to the table of contents

What the?FutureTask
FutureTask is a cancelable asynchronous computation in a parallel Java application. This class provides a basic implementation, with methods for starting and stopping a computation, methods for querying the status of a computation, and retrieving the results. The result can only be retrieved when the computation is complete, the retrieval method will be blocked if the computation is not yet complete. Objects can be used to wrap and . Because it implements , it can be delegated to execution.FutureFutureTaskCallableRunnableFutureTaskRunnableExecutor

to the table of contents

What are the differences between and ?CyclicBarrierCountDownLatch
CountDownLatch (countdown lock) provides the ability for any number of threads in a block of code to wait until a certain number of operations running on other threads have completed before they are "released" to continue their activities. The constructor must be passed the number of operations that must be performed in order for the lock to "release" blocked threads.CountDownLatch(int count)

An example from life is the gathering of an excursion group: until a certain number of people are gathered, the excursion will not begin.CountDownLatch

CyclicBarrier implements the Barrier synchronization pattern. A circular barrier is a synchronization point at which a specified number of concurrent threads meet and are blocked. Once all the profit streams are executed, the optional action is performed (or not executed if the barrier was initialized without it), and, once it is executed, the barrier breaks and the waiting flows are "released". In the constructors of the barrier, the number of parties that must "meet" and, optionally, the action that must occur when the parties meet, but before they are "released".CyclicBarrier(int parties)CyclicBarrier(int parties, Runnable barrierAction)

CyclicBarrier is an alternative to the method that "collects" streams only after they have been executed.join()

CyclicBarrier Similar to , but the main difference between them is that the "lock" can only be used once, after its counter reaches zero, while the "barrier" can be used repeatedly, even after it "breaks".CountDownLatch

to the table of contents

What is a race condition?
Race condition is a design error in a multithreaded system or application in which this work is directly dependent on the order in which the threads are executed. A race condition occurs when a thread that is supposed to execute at the beginning loses the race and another thread executes first: the behavior of the code changes, resulting in unterminated errors.

to the table of contents

Is there a way to solve the race condition problem?
Common solutions:

Using a local copy is copying a shared variable to a local stream variable. This method works only when there is only one variable and the copying is done atomically (in a single machine instruction), the use of .volatile
Synchronization - Operations on the shared resource occur in a synchronized block (when using the keyword).synchronized
Method Combination - The above methods can be combined by copying "dangerous" variables in a synchronized block. On the one hand, this removes the limitation on atomicity, on the other hand, it allows you to get rid of too large synchronized blocks.
There are no obvious ways to identify and correct race conditions. The best way to get rid of racing is to properly design your multitasking system.

to the table of contents

How to stop the flow?
At the moment, Java has adopted a notification thread stop order (although JDK 1.0 has several methods that control thread execution, such as , and - in subsequent versions of the JDK, all of which have been marked as deadlock because of potential deadlock threats).stop()suspend()resume()deprecated

To stop the flow correctly, you can use the - class method. This method sets some internal interrupt status flag. You can then check the status of this flag using the or method (for the current thread). The method can also wake a thread from a waiting or hibernation state. That is, if the or – methods were called on the thread, the current state will be aborted and an exception will be thrown. In this case, the flag is not displayed.Threadinterrupt()isInterrupted()Thread.interrupted()interrupt()sleep()wait()InterruptedException

The scheme of action in this case is as follows:

Implement a flow.
In the thread, periodically check the interrupt status through a call to .isInterrupted()
If the flag state has changed or an exception has been thrown while waiting/hibernating, then the thread is being stopped from the outside.
Make a decision – to continue working (if for some reason it is impossible to stop) or to release the resources blocked by the thread and finish the execution.
A possible problem that is present in this approach is locks on streaming I/O. If a thread is blocked from reading data, the call will not bring it out of this state. Solutions here differ depending on the type of data source. If the read comes from a file, a long-term lock is extremely unlikely, and then you can just wait for the . If the read is somehow network-related, it is worth using non-blocking I/O from Java NIO.interrupt()read()

The second option for implementing the stop method (as well as suspending) is to make your own analogue of . That is, declare flags in the stream class to stop and/or suspend and set them by calling predetermined methods from the outside. The method of action remains the same – check the setting of flags and make decisions when changing them. Disadvantages of this approach. First, threads in a waiting state cannot be "revived" in this way. Secondly, setting a flag by one thread does not mean that the second thread will immediately see it. To improve performance, the virtual machine uses the thread's data cache, which means that the second thread's variable can be updated indefinitely (although a valid solution would be to declare the flag variable as ).interrupt()volatile

to the table of contents

Why is it not recommended to use the method?Thread.stop()
When a thread is forcibly stopped (suspended), it terminates the thread at a non-determined execution location, making it completely unclear what to do with the resources it owns. A thread can open a network connection - what do you do with data that hasn't been read yet? Where is the guarantee that after the further start of the stream (in case of suspension) it will be able to read them? If a thread has locked a shared resource, how do you release the lock, and will forcing it break the consistency of the system? The same can be extended to the case of a database connection: if the thread is stopped in the middle of a transaction, who will close it? Who will unlock resources and how?stop()

to the table of contents

What happens when an exception is thrown in a thread?
If the exception is not caught, the stream "dies" (turns into dead).
If an uncaught exception handler is installed, it will take over. is an interface defined as a nested interface for other handlers called when a thread suddenly stops due to an uncaught exception. In the event that a thread is about to stop because of an uncaught exception, the JVM checks for it using , and if it does, it will call the method on it, passing the thread and the exception as arguments.Thread.UncaughtExceptionHandlerUncaughtExceptionHandlerThread.getUncaughtExceptionHandler()uncaughtException()
to the table of contents

What is the difference between and ?interrupted()isInterrupted()
The thread abort mechanism in Java is implemented using an internal flag known as the interrupt status. Terminating a thread by a call sets this flag. The and methods allow you to check whether the thread is interrupted.Thread.interrupt()Thread.interrupted()isInterrupted()

When an interrupted thread checks for interrupt status by calling a static method, the interrupt status is reset.Thread.interrupted()

A non-static method is used by one thread to check the interrupt status of another thread without changing the interrupt flag.isInterrupted()

to the table of contents

What is a "thread pool"?
Creating a flow is a time-consuming and resource-consuming operation. The number of threads that can be started within a single process is also limited. To avoid these problems and generally manage multiple threads more efficiently, Java implemented a thread pool mechanism, which is created during the start of the application and then threads are taken and reused from it to process requests. Thus, it becomes possible not to lose threads, to balance the application in terms of the number of threads and the frequency of their creation.

Starting with Java 1.5, the Java API provides a framework that allows you to create different types of thread pool:Executor

Executor - simplified pool interface, contains one method for passing a task for execution;
ExecutorService - advanced pool interface, with the ability to terminate all threads;
AbstractExecutorService - the base class of the pool that implements the ExecutorService;
Executors - A thread pool-related object factory, including the creation of basic pool types.
ThreadPoolExecutor - a thread pool with flexible configuration, can serve as a base class for non-standard pools;
ForkJoinPool - a pool for performing tasks of the ForkJoinTask;
... and others.
Methods for creating pools:Executors

newCachedThreadPool() - If there is a free thread, then the task is executed in it, otherwise a new thread is added to the pool. Threads that are not used for more than a minute are terminated and will be deleted from the cache. The pool size is unlimited. Designed to perform many small asynchronous tasks;
newCachedThreadPool(ThreadFactory threadFactory) - similar to the previous one, but with its own flow factory;
newFixedThreadPool(int nThreads) - Creates a pool for the specified number of threads. If new tasks are added when all threads are active, they will be saved to the queue for execution later. If one of the threads terminated due to an error, another thread will start in its place. Threads live until the pool is explicitly closed by the .shutdown()
newFixedThreadPool(int nThreads, ThreadFactory threadFactory) - similar to the previous one, but with its own flow factory;
newSingleThreadScheduledExecutor() - Single-threaded pool with the ability to execute a task after a specified amount of time or run periodically. If the thread was terminated due to any errors, then a new thread will be created to perform the next task.
newSingleThreadScheduledExecutor(ThreadFactory threadFactory) - similar to the previous one, but with its own flow factory;
newScheduledThreadPool(int corePoolSize) - a pool to perform tasks after a specified time or periodically;
newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory) - similar to the previous one, but with its own flow factory;
unconfigurableExecutorService(ExecutorService executor) - Wrapper on the pool, which prohibits changing its configuration;
to the table of contents

What size should a thread pool be?
When adjusting the size of the thread pool, it is important to avoid two mistakes: too few threads (the queue for execution will grow, consuming a lot of memory) or too many threads (slowing down the entire system due to frequent context switches).

The optimal size of the thread pool depends on the number of available processors and the nature of the tasks in the production queue. On an N-processor system, for a worker queue that will only perform computationally rate-constrained tasks, you can achieve maximum CPU utilization with a thread pool that contains N or N+1 threads. For tasks that may be waiting for I/O (input-output) to be performed—for example, a task that reads an HTTP request from a socket—it may be necessary to increase the size of the pool beyond the number of available processors, because not all threads will run all the time. Using profiling, you can estimate the ratio of time-out () to processing time () for a typical query. If we call this ratio , then an N-processor system will need approximately threads to fully utilize the processors.WTSTWT/STN*(1 + WT/ST)

CPU usage is not the only factor that is important when adjusting the size of the thread pool. As the thread pool grows, you may encounter constraints on the scheduler, available memory, or other system resources, such as the number of sockets, open file handles, or database communication channels.

to the table of contents

What happens if the thread pool queue is already full, but a new task is submitted?
If the thread pool queue is full, the submitted task will be "rejected." For example, the method y throws , after which .submit()ThreadPoolExecutorRejectedExecutionExceptionRejectedExecutionHandler

to the table of contents

What is the difference between thread pool and thread pool methods?submit()execute()
Both methods are ways to submit a task to the thread pool, but there is a slight difference between the two.

execute(Runnable command) is defined in the interface and executes the given task and does not return anything.Executor

submit() is an overloaded method defined in the interface. It is able to accept tasks of types and return an object that can be used to control and control the execution process, obtaining its result.ExecutorServiceRunnableCallableFuture

to the table of contents

What are the differences between a stack and a heap in terms of multithreading?
A stack is a memory area that is closely related to threads. Each thread has its own stack that stores local variables, method parameters, and the call stack. A variable stored on the stack of one thread is not visible to another.

Heap is a shared memory area that is shared among all threads. Objects, whether local or of any other level, are created on the heap. To improve performance, a thread typically caches values from the heap to its stack, in which case the keyword is used to indicate to the thread that a variable should be read from the heap.volatile

to the table of contents

How do I share data between two streams?
Data can be shared between streams using a common object or parallel data structures, such as .BlockingQueue

to the table of contents

What JVM startup option is used to control the size of a thread's stack?
-Xss

to the table of contents

How do I get a stream dump?
Java runtimes based on HotSpot generate only a dump in HPROF format. The developer has several interactive methods for generating dumps and one method for generating dumps based on events.

Interactive methods:

Usage: If the command-line option is set for the executing application, an HPROF dump is generated along with a stream dump when an event occurs or (usually generated with a kill -3) that is initiated through the console. This option may not be available in some versions. In this case, you can try to use the following option: Ctrl+Break-XX:+HeapDumpOnCtrlBreakCtrl+BreakSIGQUIT-Xrunhprof:format=b,file=heapdump.hprof
Using the jmap tool: The jmap utility, which is included with the JDK directory, allows you to request an HPROF dump from an executable process./bin/
Using the operating system: To create a kernel file, you can use the non-destructive gcore command or the destructive kill -6 or kill -11 commands. Then, extract the heap dump from the kernel file using the jmap utility.
Using the JConsole tool. The operation is exposed in JConsole as an MBean component. This operation requests the generation of a dump in HPROF format.dumpHeapHotSpotDiagnostic
Event-based method:

Event : If the command line option is set for a running application, an HPROF dump is generated when an error occurs. This is an ideal method for "production" systems, as it is practically mandatory for diagnosing memory problems and does not come with constant overhead in terms of performance. In older releases of the HotSpot-based Java runtimes, this event does not have a limit on the number of heap dumps per JVM; Newer releases allow no more than one heap dump for this event per JVM run.OutOfMemoryError-XX:+HeapDumpOnOutOfMemoryErrorOutOfMemoryError
to the table of contents

What is a ThreadLocal variable?
ThreadLocal - a class that allows having one variable to have a different value for each of the threads.

Each thread - i.e. an instance of a class - has an associated ThreadLocal variable table. The keys of the table are references to objects of the class, and the values are references to objects "captured" by ThreadLocal variables, i.e. ThreadLocal variables differ from regular variables in that each thread has its own, individually initialized instance of the variable. The value can be accessed through the or .ThreadThreadLocalget()set()

For example, if we declare a ThreadLocal variable: . And then, in the thread, make , then the key of the table will be the reference to the object, and the value will be the reference to the object. At the same time, it is possible to "put" a different value inside the other stream.ThreadLocal<Object> locals = new ThreadLocal<Object>();locals.set(myObject)localsmyObjectlocals

Note that it is the object references that isolate, not the objects themselves. If thread-isolated references point to the same object, collisions are possible.ThreadLocal

It is also important to note that since ThreadLocal variables are isolated in threads, then the initialization of such a variable must occur on the same thread in which it will be used. It is a mistake to initialize such a variable (method call) on the main thread of the application, because in this case the value passed in the method will be "captured" for the main thread, and when the method is called on the target thread, it will be returned.set()set()get()null

to the table of contents

What are the differences between and ?synchronizedReentrantLock
Java 5 introduces an interface that provides more efficient and fine-grained control over resource locking. is a common implementation that provides with the same basic behavior and semantics as , but advanced features such as lock polling, lock waiting for a specified duration, and interruptible lock waiting. In addition, it offers a much higher efficiency of functioning in a highly competitive environment.LockReentrantLockLockLocksynchronized

What is a reentrant lock? Just that there's a data collection count associated with the lock, and if the thread that holds the lock acquires it again, the data reflects the increase, and then you have to release the lock twice to actually unlock. This is analogous to synchronized semantics; If a thread enters a synchronous block protected by a monitor that already belongs to the thread, the thread will be allowed to continue functioning, and the lock will not be released, when the thread exits the second (or subsequent) Synchronized block, it will be released only when it exits the first synchronized block that it entered while protected by the monitor.

Lock lock = new ReentrantLock();

lock.lock();
try { 
  // update object state
}
finally {
  lock.unlock(); 
}
The implementation is much more scalable in a controversy environment than the . This means that when many threads are vying for lock rights, the total throughput is usually better for . The JVM takes less time to sequence threads and more time to execute.ReentrantLocksynchronizedReentrantLocksynchronized
In (as in other implementations), the lock must be released in the block (otherwise, if protected code threw an exception, the lock would not be released). By using synchronization, the JVM ensures that locks are automatically released.ReentrantLockLockfinally
To summarize, when there is no or very little competition for blocking, it may be faster. If there is a noticeable competition for access to the resource, it is likely to give some kind of advantage.synchronizedReentrantLock

to the table of contents

What the?ReadWriteLock
ReadWriteLock is an interface that extends the basic interface. It is used to improve performance in a multithreaded process and operates on a pair of related locks (one for reads and one for writes). A read lock can be held by multiple readers at the same time until a writer appears. Recording lock is exclusive.Lock

There is an interface implementing class that supports up to 65535 write locks and up to as many read locks.ReadWriteLockReentrantReadWriteLock

ReadWriteLock rwLock = new ReentrantReadWriteLock();
Lock rLock = rwLock.readLock();
Lock wLock = rwLock.writeLock();

wLock.lock();
try {
    // exclusive write
} finally {
    wLock.unlock();
}
        
rLock.lock();
try {
    // shared reading
} finally {
    rLock.unlock();
}        
to the table of contents

What is the "blocking method"?
Blocking method – A method that is blocked until the job is executed, for example, method y is blocked while waiting for a client to connect. Here, blocking means that control will not return to the calling method until the job is executed. There are also asynchronous or non-blocking methods that can complete before the task is executed.accept()ServerSocket

to the table of contents

What is a "Fork/Join framework"?
The Fork/Join framework, introduced in JDK 7, is a set of classes and interfaces that take advantage of the multiprocessor architecture of modern computers. It is designed to perform tasks that can be recursively broken down into small subtasks that can be solved in parallel.

Fork stage: A large task is divided into several smaller subtasks, which in turn are also broken down into smaller ones. And so on until the problem becomes trivial and solvable in a sequential way.
Join stage: next (optionally) there is a process of "convolution" - the solutions of subproblems are combined in some way until the solution of the whole problem is obtained.
The solution of all subtasks (including the division into subtasks itself) takes place in parallel.

For some tasks, the Join stage is not required. For example, for parallel QuickSort, the array is recursively divided into smaller and smaller ranges until it degenerates into a trivial case of 1 element. Although, in a sense, Join will be necessary here as well, because you still need to wait until all the subtasks are finished.

Another great advantage of this framework is that it uses a work-stealing algorithm: threads that have completed their own subtasks can "steal" subtasks from other threads that are still busy.

to the table of contents

What the?Semaphore
Semaphore is a new type of synchronizer: a semaphore with a counter that implements the Semaphore synchronization pattern. Access is controlled using a counter: the initial value of the counter is set in the constructor when creating a synchronizer, when a thread enters a given block of code, the value of the counter decreases by one, when the thread leaves it, it increases. If the counter value is zero, the current thread is blocked until someone exits the protected block. Semaphore is used to protect expensive resources that are available in limited quantities, such as a database connection in a pool.

to the table of contents

What is a double checked locking Singleton?
double checked locking Singleton is one way to create a thread-safe class that implements the Singleton pattern. This method attempts to optimize performance by locking only when a singleton instance is created for the first time.

class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    static DoubleCheckedLockingSingleton getInstance() {
        DoubleCheckedLockingSingleton current = instance;
        if (current == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                current = instance;

                if (current == null) {
                    instance = current = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return current;
    }
}
It should be noted that the requirement is mandatory. The problem with Double Checked Lock lies in the Java memory model, more specifically in the order in which objects are created, where it is possible for another thread to acquire and start using (based on the condition that the pointer is not null) an incompletely constructed object. Although this problem was partially resolved in JDK 1.5, the recommendation to use Double Chesked Lock for Double Chesked still applies.volatilevoloatile

к оглавлению

Как создать потокобезопасный Singleton?
Static field
public class Singleton {
	public static final Singleton INSTANCE = new Singleton();
}
Enum
public enum Singleton {
	INSTANCE;
}
Synchronized Accessor
public class Singleton {
	private static Singleton instance;
	
	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
Double Checked Locking & volatile
public class Singleton {
        private static volatile Singleton instance;
	
        public static Singleton getInstance() {
		Singleton localInstance = instance;
		if (localInstance == null) {
			synchronized (Singleton.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new Singleton();
				}
			}
		}
		return localInstance;
	}
}
On Demand Holder Idiom
public class Singleton {
		
	public static class SingletonHolder {
		public static final Singleton HOLDER_INSTANCE = new Singleton();
	}
		
	public static Singleton getInstance() {
		return SingletonHolder.HOLDER_INSTANCE;
	}
}
to the table of contents

Why are immutable objects useful?
Immutability helps make it easier to write multithreaded code. An immutable object can be used without any synchronization. Unfortunately, Java does not have an annotation that makes an object immutable, for this developers need to create a class with the necessary characteristics themselves. To do this, it is necessary to follow some general principles: initialization of all fields only in the constructor, the absence of methods that make changes to the fields of the class, the absence of reference leaks, the organization of a separate storage of copies of modifiable objects, etc.@ImmutablesetX()

to the table of contents

What is a busy spin?
Busy spin is a technique that programmers use to make a thread wait under a certain condition. Unlike traditional methods, or , which involve yielding CPU time, this method executes an empty loop instead of yielding. This is necessary in order to preserve the processor cache, because in multi-core systems, there is a possibility that the suspended thread will continue its execution on another core, and this will entail rebuilding the state of the processor cache, which is a rather expensive procedure.wait()sleep()yield()

to the table of contents

List the principles you follow in multithreaded programming?
When writing multithreaded programs, you should follow certain rules that help ensure decent performance of the application, combined with convenient debugging and ease of further code maintenance.

Always give meaningful names to your streams. The process of debugging, finding errors, or tracking an exception in multithreaded code is quite a difficult task. , or much more informative than , and . The name should reflect the task that the thread is performing.OrderProcessorQuoteProcessorTradeProcessorThread1Thread2Thread3
Avoid blocking or try to scale down the sync. Locking is costly, and context switching is even more resource-intensive. Try to avoid synchronization and blocking as much as possible, and keep the critical section as small as necessary. Therefore, a synchronized block is always preferable to a synchronized method, adding that you have absolute control over the scope of the lock.
Handle flow interruption with the utmost care. There is nothing worse than a resource or system that remains locked in an unconfirmed state due to an unconfirmed transaction.
Remember to handle exceptions. Discarded should be adequately treated, not just suppressed. Also, do not neglect. When using a thread pool, you need to remember that it often just "swallows" exceptions. So, if you have submitted for execution, you must place the task execution code inside the block. If you queue the pool, you must ensure that the result of execution is always retrieved by the locking device, so that if it occurs, it is possible to re-throw the exception that has occurred.InterruptedExceptionThread.UncaughtExceptionHandlerRunnabletry-catchCallableget()
Between the and and synchronizers, you should select synchronizers. First, synchronizers like , , or make it easier to write code. It is very difficult to implement a complex control flow using and . Secondly, these classes are written and maintained by real masters of their craft and there is a chance that in future versions of the JDK they will be optimized internally or replaced by a more powerful external implementation.wait()notify()CountDownLatchSemaphoreCyclicBarrierExchangerwait()notify()
Almost always using Concurrent collection is more profitable than using Synchronized collection, because the former are more modern (using all the language innovations available at the time of their writing) and scalable than their synchronized counterparts.
to the table of contents

Which of the following statements about flows is incorrect?
If a method is called twice for the same object, an exception is thrown at run time.start()Thread
The order in which the threads were started may not be the same as the order in which they were actually executed.
If a method is called directly on an object, an exception is thrown at run time.run()Thread
If a method is called on a thread while the synchronized code is being executed, the lock is not released.sleep()
Correct answer: 3. If the method is called directly on the object, no exception is thrown at runtime. However, code written in the method will be executed by the current thread, not the new thread. Therefore, the correct way to start a thread is to call the method that causes a new thread to execute the method.run()Threadrun()start()run()

Calling the method twice on the same object will cause an exception to be thrown at runtime, so statement 1 is true. Statement 2 is true because the order in which threads run is determined by the Thread Scheduler, regardless of which thread is started first. Proposition 4 is true because the thread will not release the locks it holds when it enters the Wait state.start()ThreadIllegalThreadStateException

to the table of contents

Are there 3 streams T1, T2 and T3? How to implement execution in the sequence T1, T2, T3?
This sequence of execution can be achieved in many ways, such as simply using the method to start a thread when another thread has already finished executing. To implement a given sequence, you need to start the last thread first, and then call the method in reverse order, that is, T3 calls , and T2 calls , so T1 will finish first and T3 last.join()join()Т2.joinТ1.join

to the table of contents

Write a minimum non-blocking stack (there are only two methods, and ).push()pop()
class NonBlockingStack<T> {
    private final AtomicReference<Element> head = new AtomicReference<>(null);

    Stack<T> push(final T value) {
        final Element current = new Element();
        current.value = value;
        Element recent;
        do {
            recent = head.get();
            current.previous = recent;
        } while (!head.compareAndSet(recent, current));
        return this;
    }

    T pop() {
        Element result;
        Element previous;
        do {
            result = head.get();
            if (result == null) {
                return null;
            }
            previous = result.previous;
        } while (!head.compareAndSet(result, previous));
        return result.value;
    }

    private class Element {
        private T value;
        private Element previous;
    }
}
to the table of contents

Write a minimal non-blocking stack (only two methods, and ) using .push()pop()Semaphore
class SemaphoreStack<T> {
    private final Semaphore semaphore = new Semaphore(1);
    private Node<T> head = null;

    SemaphoreStack<T> push(T value) {
        semaphore.acquireUninterruptibly();
        try {
            head = new Node<>(value, head);
        } finally {
            semaphore.release();
        }

        return this;
    }

    T pop() {
        semaphore.acquireUninterruptibly();
        try {
            Node<T> current = head;
            if (current != null) {
                head = head.next;
                return current.value;
            }
            return null;
        } finally {
            semaphore.release();
        }
    }

    private static class Node<E> {
        private final E value;
        private final Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
to the table of contents

Write a minimal nonblocking ArrayList (there are four methods in total, , , , ).add()get()remove()size()
class NonBlockingArrayList<T> {
    private volatile Object[] content = new Object[0];

    NonBlockingArrayList<T> add(T item) {
        return add(content.length, item);
    }

    NonBlockingArrayList<T> add(int index, T item) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        boolean needsModification = index > content.length - 1;
        if (!needsModification) {
            if (item == null) {
                needsModification = content[index] != null;
            } else {
                needsModification = item.equals(content[index]);
            }
        }
        if (needsModification) {
            final Object[] renewed = Arrays.copyOf(content, Math.max(content.length, index + 1));
            renewed[index] = item;
            content = renewed;
        }
        return this;
    }

    NonBlockingArrayList<T> remove(int index) {
        if (index < 0 || index >= content.length) {
            throw new IllegalArgumentException();
        }
        int size = content.length - 1;
        final Object[] renewed = new Object[size];
        System.arraycopy(content, 0, renewed, 0, index);
        if (index + 1 < size) {
            System.arraycopy(content, index + 1, renewed, index, size - index);
        }
        content = renewed;
        return this;
    }

    T get(int index) {
        return (T) content[index];
    }

    int size() {
        return content.length;
    }
}
to the table of contents

Write a thread-safe class implementation with a nonblocking method that returns sequence elements: .BigInteger next()[1, 2, 4, 8, 16, ...]
class PowerOfTwo {
    private AtomicReference<BigInteger> current = new AtomicReference<>(null);
    
    BigInteger next() {
        BigInteger recent, next;
        do {
            recent = current.get();
            next = (recent == null) ? BigInteger.valueOf(1) : recent.shiftLeft(1);
        } while (!current.compareAndSet(recent, next));
        return next;
    }
}
to the table of contents

Write the simplest multithreaded bounded buffer using .synchronized
class QueueSynchronized<T> {
    private volatile int size = 0;
    private final Object[] content;
    private final int capacity;

    private int out;
    private int in;

    private final Object isEmpty = new Object();
    private final Object isFull = new Object();

    QueueSynchronized(final int capacity) {
        this.capacity = capacity;
        content = new Object[this.capacity];
        out = 0;
        in = 0;
        size = 0;
    }

    private int cycleInc(int index) {
        return (++index == capacity)
                ? 0
                : index;
    }

    @SuppressWarnings("unchecked")
    T get() throws InterruptedException {
        if (size == 0) {
            synchronized (isEmpty) {
                while (size < 1) {
                    isEmpty.wait();
                }
            }
        }
        try {
            synchronized (this) {
                final Object value = content[out];
                content[out] = null;
                if (size > 1) {
                    out = cycleInc(out);
                } 
                size--;
                return (T) value;
            }
        } finally {
            synchronized (isFull) {
                isFull.notify();
            }
        }
    }

    QueueSynchronized<T> put(T value) throws InterruptedException {
        if (size == capacity) {
            synchronized (isFull) {
                while (size == capacity) {
                    isFull.wait();
                }
            }
        }
        synchronized (this) {
            if (size == 0) {
                content[in] = value;
            } else {
                in = cycleInc(in);
                content[in] = value;
            }
            size++;
        }
        synchronized (isEmpty) {
            isEmpty.notify();
        }
        return this;
    }
}
to the table of contents

Write the simplest multithreaded bounded buffer using .ReentrantLock
class QueueReentrantLock<T> {

    private volatile int size = 0;
    private final Object[] content;
    private final int capacity;

    private int out;
    private int in;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition isEmpty = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    QueueReentrantLock(int capacity) {
        try {
            lock.lock();
            this.capacity = capacity;
            content = new Object[capacity];
            out = 0;
            in = 0;
        } finally {
            lock.unlock();
        }
    }

    private int cycleInc(int index) {
        return (++index == capacity)
                ? 0
                : index;
    }

    @SuppressWarnings("unchecked")
    T get() throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (size == 0) {
                while (size < 1) {
                    isEmpty.await();
                }
            }
            final Object value = content[out];
            content[out] = null;
            if (size > 1) {
                out = cycleInc(out);
            }
            size--;
            isFull.signal();
            return (T) value;
        } finally {
            lock.unlock();
        }
    }

    QueueReentrantLock<T> put(T value) throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (size == capacity) {
                while (size == capacity) {
                    isFull.await();
                }
            }
            if (size == 0) {
                content[in] = value;
            } else {
                in = cycleInc(in);
                content[in] = value;
            }
            size++;
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
        return this;
    }
}
to the table of contents
