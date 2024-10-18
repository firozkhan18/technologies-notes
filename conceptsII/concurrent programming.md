# Java Concurrency Utilities - java.util.concurrent


Java 5 added a new package to the Java platform, the `java.util.concurrent` package. This package contains a set of classes that makes it easier to develop concurrent (multithreaded) applications in Java. Before this package was added, you would have to program your utility classes yourself.

## Table of Contents
Here is a list of the topics covered in this `java.util.concurrent` trail. This list (menu) is also present at the top right of every page in the trail.

- [Java BlockingQueue](#java-blockingqueue)
- [Java ArrayBlockingQueue](#java-arrayblockingqueue)
- [Java DelayQueue](#java-delayqueue)
- [Java LinkedBlockingQueue](#java-linkedblockingqueue)
- [Java PriorityBlockingQueue](#java-priorityblockingqueue)
- [Java SynchronousQueue](#java-synchronousqueue)
- [Java BlockingDeque](#java-blockingdeque)
- [Java LinkedBlockingDeque](#java-linkedblockingdeque)
- [Java ConcurrentMap](#java-concurrentmap)
- [Java ConcurrentNavigableMap](#java-concurrentnavigablemap)
- [Java CountDownLatch](#java-countdownlatch)
- [Java CyclicBarrier](#java-cyclicbarrier)
- [Java Exchanger](#java-exchanger)
- [Java Semaphore](#java-semaphore)
- [Java ExecutorService](#java-executorservice)
- [Java Callable](#java-callable)
- [Java Future](#java-future)
- [Java ThreadPoolExecutor](#java-threadpoolexecutor)
- [Java ScheduledExecutorService](#java-scheduledexecutorservice)
- [Java ForkJoinPool](#java-forkjoinpool)
- [Java Lock](#java-lock)
- [Java ReadWriteLock](#java-readwritelock)
- [Java AtomicInteger](#java-atomicinteger)
- [Java AtomicLong](#java-atomiclong)
- [Java AtomicReference](#java-atomicreference)
- [Java AtomicStampedReference](#java-atomicstampedreference)
- [Java AtomicIntegerArray](#java-atomicintegerarray)
- [Java AtomicLongArray](#java-atomiclongarray)
- [Java AtomicReferenceArray](#java-atomicreferencearray)



### BlockingQueue and Its Implementations

#### 1. BlockingQueue
- **Definition**: A thread-safe queue that supports operations that block when the queue is full or empty.
- **Methods**:
  - `put(E e)`: Adds the specified element, waiting if necessary for space to become available.
  - `take()`: Retrieves and removes the head of the queue, waiting if necessary until an element becomes available.

#### 2. ArrayBlockingQueue
- **Description**: A bounded blocking queue backed by an array.
- **Characteristics**:
  - Fixed capacity.
  - FIFO order for elements.
- **Usage**: Ideal for situations where you want to limit the number of elements in the queue.

#### 3. DelayQueue
- **Description**: A blocking queue where elements can only be taken when their specified delay has expired.
- **Characteristics**:
  - Uses a `Delayed` interface to specify delay times.
- **Usage**: Useful for scheduling tasks or events that should occur after a certain delay.

#### 4. LinkedBlockingQueue
- **Description**: A blocking queue backed by linked nodes, allowing optional bounded capacity.
- **Characteristics**:
  - Can be unbounded (default) or bounded (if specified).
  - Allows concurrent access by multiple threads.
- **Usage**: Good for handling producer-consumer scenarios where blocking behavior is required.

#### 5. PriorityBlockingQueue
- **Description**: An unbounded blocking queue that orders its elements based on their natural ordering or a provided comparator.
- **Characteristics**:
  - Not FIFO; elements are ordered according to priority.
- **Usage**: Suitable for scheduling tasks based on priority rather than arrival order.

### SynchronousQueue
- **Description**: A blocking queue that does not store elements.
- **Characteristics**:
  - Each `put` operation must wait for a corresponding `take` operation.
  - No capacity; effectively always empty.
- **Usage**: Often used in hand-off designs where one thread produces data and another consumes it immediately.

### BlockingDeque and Its Implementations

#### 1. BlockingDeque
- **Description**: An interface extending `BlockingQueue` to support operations on both ends of a deque.
- **Methods**: Includes methods like `addFirst`, `addLast`, `takeFirst`, and `takeLast`.

#### 2. LinkedBlockingDeque
- **Description**: An implementation of `BlockingDeque` backed by linked nodes.
- **Characteristics**:
  - Can be unbounded or bounded.
  - Allows concurrent access.
- **Usage**: Useful for scenarios requiring double-ended queue behavior with blocking operations.

### Concurrent Maps

#### 1. ConcurrentMap
- **Description**: An interface that provides thread-safe operations for map data structures without needing explicit synchronization.
- **Methods**: Includes methods like `putIfAbsent`, `remove`, and `replace`.

#### 2. ConcurrentNavigableMap
- **Description**: A subinterface of `ConcurrentMap` that provides navigation methods.
- **Characteristics**: Supports operations like `lowerEntry`, `floorEntry`, and `ceilingEntry`.

### Synchronization Primitives

#### 1. CountDownLatch
- **Description**: A synchronization aid that allows one or more threads to wait until a set of operations in other threads completes.
- **Usage**: Initialize with a count. Threads can call `await()` to block until the count reaches zero. Use `countDown()` to decrement the count.

#### 2. CyclicBarrier
- **Description**: A synchronization aid that allows a set of threads to wait for each other to reach a common barrier point.
- **Usage**: Initialize with a count. Threads call `await()` at the barrier point, and when the count reaches zero, all are released.

#### 3. Exchanger
- **Description**: A synchronization point at which threads can swap elements within pairs.
- **Usage**: Each thread calls `exchange()` to wait for another thread to swap data.

#### 4. Semaphore
- **Description**: A counting semaphore that controls access to a resource pool.
- **Usage**: Initialize with a number representing the available permits. Use `acquire()` to get a permit and `release()` to return one.

### Executor Framework

#### 1. ExecutorService
- **Description**: An interface that provides a higher-level replacement for managing threads.
- **Methods**: Includes methods like `submit()`, `invokeAll()`, and `shutdown()`.

#### 2. Callable
- **Description**: A functional interface similar to `Runnable`, but it can return a result and throw a checked exception.
- **Usage**: Useful for tasks that need to return a result.

#### 3. Future
- **Description**: Represents the result of an asynchronous computation.
- **Methods**: Includes `get()`, which retrieves the result, and `isDone()`, which checks if the computation is complete.

#### 4. ThreadPoolExecutor
- **Description**: A flexible implementation of `ExecutorService` that uses a pool of threads to execute tasks.
- **Characteristics**: Supports features like thread reuse, task queuing, and dynamic adjustment of pool size.

#### 5. ScheduledExecutorService
- **Description**: An interface that extends `ExecutorService` for scheduling tasks to run after a given delay or periodically.
- **Methods**: Includes `schedule()`, `scheduleAtFixedRate()`, and `scheduleWithFixedDelay()`.

### Fork/Join Framework

- **ForkJoinPool**: A specialized implementation of `ExecutorService` designed for parallelism, particularly for tasks that can be split into smaller subtasks (divide and conquer).
- **Characteristics**: Uses work-stealing algorithm, allowing idle threads to take on tasks from busy threads.

### Locking Mechanisms

#### 1. Lock
- **Description**: An interface providing a way to acquire and release locks explicitly.
- **Methods**: Includes `lock()`, `unlock()`, and `tryLock()`.

#### 2. ReadWriteLock
- **Description**: A pair of associated locks: one for read-only operations and one for write operations.
- **Characteristics**: Allows multiple threads to read concurrently but only one thread to write at a time.

### Atomic Variables

#### 1. AtomicInteger
- **Description**: An integer value that may be updated atomically.
- **Methods**: Includes `incrementAndGet()`, `decrementAndGet()`, and `compareAndSet()`.

#### 2. AtomicLong
- **Description**: A long value that may be updated atomically.
- **Methods**: Similar to `AtomicInteger`.

#### 3. AtomicReference
- **Description**: An object reference that may be updated atomically.
- **Methods**: Includes `get()`, `set()`, and `compareAndSet()`.

#### 4. AtomicStampedReference
- **Description**: An atomic reference that includes a version stamp to prevent stale updates.
- **Usage**: Useful for handling situations where you want to track updates.

#### 5. AtomicIntegerArray
- **Description**: An array of integers that supports atomic operations on individual elements.
- **Methods**: Includes `get()`, `set()`, and `incrementAndGet()`.

#### 6. AtomicLongArray
- **Description**: An array of long values that supports atomic operations.
- **Characteristics**: Similar to `AtomicIntegerArray`.

#### 7. AtomicReferenceArray
- **Description**: An array of object references that supports atomic operations.
- **Methods**: Includes `get()`, `set()`, and `compareAndSet()`.

### Conclusion
These concurrent structures and primitives in Java provide robust tools for building multi-threaded applications. They help manage complexity by ensuring thread safety and facilitating synchronization, which are critical for performance and correctness in concurrent programming. If you have specific use cases or examples you'd like to explore further, let me know!

---

# Java BlockingQueue

## Overview
The Java `BlockingQueue` interface, `java.util.concurrent.BlockingQueue`, represents a thread-safe queue for inserting and removing elements. Multiple threads can concurrently add and remove elements from a `BlockingQueue` without encountering concurrency issues.

The term "blocking queue" refers to its capability to block threads attempting to insert or take elements from the queue. For example, if a thread tries to take an element and the queue is empty, it will block until an element is available. The behavior depends on the methods called on the `BlockingQueue`.

## Java BlockingQueue Tutorial Video
If you prefer video, check out my video version of this tutorial: [Java BlockingQueue Tutorial](https://yourlink.com).

## BlockingQueue Implementations
Since `BlockingQueue` is an interface, you must use one of its implementations:
- `ArrayBlockingQueue`
- `DelayQueue`
- `LinkedBlockingQueue`
- `LinkedBlockingDeque`
- `LinkedTransferQueue`
- `PriorityBlockingQueue`
- `SynchronousQueue`

Click the links to learn more about each implementation.

## BlockingQueue Usage
A `BlockingQueue` is typically used in producer-consumer scenarios where one thread produces objects and another consumes them. The producing thread continues until the queue reaches its capacity, at which point it is blocked until a consumer removes an item.

### BlockingQueue Methods
The `BlockingQueue` interface has four sets of methods for inserting, removing, and examining elements, each with different behaviors if an operation cannot be completed immediately:

| Action | Throws Exception | Special Value | Blocks | Times Out |
|--------|------------------|---------------|--------|-----------|
| Insert | `add(o)`        | `offer(o)`    | `put(o)` | `offer(o, timeout, timeunit)` |
| Remove | `remove(o)`     | `poll()`      | `take()` | `poll(timeout, timeunit)` |
| Examine | `element()`     | `peek()`      | -      | - |

- **Throws Exception:** An exception is thrown if the operation fails.
- **Special Value:** A special value is returned (often `true` or `false`) if the operation fails.
- **Blocks:** The method blocks until the operation can be completed.
- **Times Out:** The method blocks until the operation can be completed or times out after a specified duration.

### Important Notes
- Null cannot be added to a `BlockingQueue`; attempting to do so will throw a `NullPointerException`.
- Elements can be accessed in various ways, including removing specific elements, though this is not efficient.

## Java BlockingQueue Example
Here’s an example using the `ArrayBlockingQueue` implementation:

```java
public class BlockingQueueExample {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}

class Producer implements Runnable {
    protected BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    protected BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

## BlockingQueue Methods
### `add()`
Adds an element if space is available; throws `IllegalStateException` if full.

### `offer()`
Adds an element if space is available; returns `false` if full.

### `offer(long millis, TimeUnit timeUnit)`
Adds an element if space becomes available within the timeout; returns `false` if not.

### `put()`
Inserts an element, blocking if necessary until space becomes available.

### `take()`
Removes and returns the first element; blocks if the queue is empty.

### `poll()`
Removes and returns the first element; returns `null` if empty.

### `poll(long timeMillis, TimeUnit timeUnit)`
Removes and returns the first element, waiting for a specified time; returns `null` if no element is available.

### `remove(Object o)`
Removes one instance of the specified element; returns `true` if successful.

### `peek()`
Returns the first element without removing it; returns `null` if empty.

### `element()`
Returns the first element without removing it; throws `NoSuchElementException` if empty.

### `contains(Object o)`
Returns `true` if the queue contains the specified object.

### `drainTo(Collection dest)`
Drains all elements to the specified collection.

### `drainTo(Collection dest, int maxElements)`
Drains up to `maxElements` to the specified collection.

### `size()`
Returns the number of elements in the queue.

### `remainingCapacity()`
Returns the remaining capacity of the queue.

---

Sure! Here are examples for some of the key concurrent structures and synchronization primitives in Java:

### 1. BlockingQueue Example: ArrayBlockingQueue

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Integer value = queue.take();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

### 2. CountDownLatch Example

```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            final int workerId = i + 1;
            new Thread(() -> {
                try {
                    Thread.sleep(1000); // Simulate work
                    System.out.println("Worker " + workerId + " finished.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await(); // Wait for all workers to finish
        System.out.println("All workers finished.");
    }
}
```

### 3. CyclicBarrier Example

```java
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        final int numberOfWorkers = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfWorkers, () -> System.out.println("All workers arrived at the barrier."));

        for (int i = 0; i < numberOfWorkers; i++) {
            final int workerId = i + 1;
            new Thread(() -> {
                try {
                    System.out.println("Worker " + workerId + " is working...");
                    Thread.sleep(1000); // Simulate work
                    barrier.await(); // Wait for other workers
                    System.out.println("Worker " + workerId + " passed the barrier.");
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
```

### 4. ExecutorService Example

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int taskId = i + 1;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running.");
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown(); // Shutdown the executor
    }
}
```

### 5. AtomicInteger Example

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicCount = new AtomicInteger(0);

        Thread incrementer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Incrementing: " + atomicCount.incrementAndGet());
            }
        });

        Thread decrementer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Decrementing: " + atomicCount.decrementAndGet());
            }
        });

        incrementer.start();
        decrementer.start();
    }
}
```

### 6. SynchronousQueue Example

```java
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        // Producer thread
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Producing: " + i);
                    queue.put(i); // Blocks until a consumer is ready
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Integer value = queue.take(); // Blocks until a producer is ready
                    System.out.println("Consuming: " + value);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
```

### Conclusion
These examples illustrate various concurrency mechanisms in Java, including blocking queues, synchronization aids, and atomic variables. You can run these snippets to see how they work in action. If you need further explanations or more examples, feel free to ask!

