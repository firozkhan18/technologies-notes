# Java Exercises Multithreading

https://www.w3resource.com/java-exercises/multithreading/index.php
### 1. Write a Java program to create and start multiple threads that increment a shared counter variable concurrently.

```java
//IncrementThread.java
public class IncrementThread extends Thread {
  private Counter counter;
  private int incrementsPerThread;
  public IncrementThread(Counter counter, int incrementsPerThread) {
    this.counter = counter;
    this.incrementsPerThread = incrementsPerThread;
  }
  @Override
  public void run() {
    for (int i = 0; i < incrementsPerThread; i++) {
      counter.increment();
    }
  }
}
//Counter.java
public class Counter {
  private int count = 0;

  public synchronized void increment() {
    count++;
  }
  public int getCount() {
    return count;
  }
}

//Main.java
public class Main {
  public static void main(String[] args) {
    Counter counter = new Counter();
    int numThreads = 6;
    int incrementsPerThread = 10000;
    IncrementThread[] threads = new IncrementThread[numThreads];

    // Create and start the threads
    for (int i = 0; i < numThreads; i++) {
      threads[i] = new IncrementThread(counter, incrementsPerThread);
      threads[i].start();
    }

    // Wait for all threads to finish
    try {
      for (IncrementThread thread: threads) {
        thread.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print the final count
    System.out.println("Final count: " + counter.getCount());
  }
}
```
Sample Output:

Final count: 60000
Explanation:

In the above exercise -

First, we define a "Counter" class that represents a shared counter variable. It has a synchronized increment() method that increments the counter variable by one.
Next we define an "IncrementThread" class that extends Thread. Each IncrementThread instance increments the shared counter by a specified number of increments.
In the Main class, we create a 'Counter' object, specify the number of threads and increments per thread, and create an array of 'IncrementThread' objects. We then iterate over the array, creating and starting each thread.
After starting all the threads, we use the join() method to wait for each thread to finish before proceeding. After all threads have finished, we print the shared counter's final count.

### 2. Write a Java program to create a producer-consumer scenario using the wait() and notify() methods for thread synchronization.
```java
// ProducerConsumer.java
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
  private static final int BUFFER_SIZE = 5;
  private static final Queue < Integer > buffer = new LinkedList < > ();

  public static void main(String[] args) {
    Thread producerThread = new Thread(new Producer());
    Thread consumerThread = new Thread(new Consumer());

    producerThread.start();
    consumerThread.start();
  }

  static class Producer implements Runnable {
    public void run() {
      int value = 0;
      while (true) {
        synchronized(buffer) {
          // Wait if the buffer is full
          while (buffer.size() == BUFFER_SIZE) {
            try {
              buffer.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

          System.out.println("Producer produced: " + value);
          buffer.add(value++);

          // Notify the consumer that an item is produced
          buffer.notify();

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  static class Consumer implements Runnable {
    public void run() {
      while (true) {
        synchronized(buffer) {
          // Wait if the buffer is empty
          while (buffer.isEmpty()) {
            try {
              buffer.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

          int value = buffer.poll();
          System.out.println("Consumer consumed: " + value);

          // Notify the producer that an item is consumed
          buffer.notify();

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
```
Sample Output:

Producer produced: 0
Producer produced: 1
Consumer consumed: 0
Consumer consumed: 1
Producer produced: 2
Producer produced: 3
Producer produced: 4
Producer produced: 5
Producer produced: 6
Consumer consumed: 2
Consumer consumed: 3
Consumer consumed: 4
Consumer consumed: 5
Consumer consumed: 6
Producer produced: 7
Producer produced: 8
Producer produced: 9
Producer produced: 10
Producer produced: 11
................................... 
...................................

Explanation:

In the above exercise -

The "Producer" class implements the Runnable interface and represents the producer thread. It continuously produces items by adding values to the shared buffer. When the buffer is full, the producer waits until the consumer consumes an item and notifies it.
The "Consumer" class also implements the Runnable interface and represents the consumer thread. It continuously consumes items by removing values from the shared buffer. As soon as the buffer is empty, the consumer uses the wait() method to wait until a new item is produced by the producer.
In the main() method, we create instances of the Producer and Consumer classes as separate threads and start them concurrently.

### 3. Write a Java program that uses the ReentrantLock class to synchronize access to a shared resource among multiple threads.

A reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit monitor lock accessed using synchronized methods and statements, but with extended capabilities.

A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it. A thread invoking lock will return, successfully acquiring the lock, when the lock is not owned by another thread. The method will return immediately if the current thread already owns the lock. This can be checked using methods isHeldByCurrentThread(), and getHoldCount().

Write a Java program that uses the ReentrantLock class to synchronize access to a shared resource among multiple threads.

Sample Solution:

Java Code:
```java
// SharedResourceExercise.java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceExercise {
  private static final int NUM_THREADS = 3;
  private static final int NUM_ITERATIONS = 5;

  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    SharedResource sharedResource = new SharedResource();

    Thread[] threads = new Thread[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++) {
      threads[i] = new Thread(new Worker(lock, sharedResource));
      threads[i].start();
    }

    try {
      for (Thread thread: threads) {
        thread.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static class Worker implements Runnable {
    private Lock lock;
    private SharedResource sharedResource;

    public Worker(Lock lock, SharedResource sharedResource) {
      this.lock = lock;
      this.sharedResource = sharedResource;
    }

    public void run() {
      for (int i = 0; i < NUM_ITERATIONS; i++) {
        lock.lock();
        try {
          sharedResource.doWork();
        } finally {
          lock.unlock();
        }
      }
    }
  }

  static class SharedResource {
    public void doWork() {
      String threadName = Thread.currentThread().getName();
      System.out.println("Thread-> " + threadName + " is performing work.");
      // Perform work on the shared resource
    }
  }
}
```
Sample Output:

Thread-> Thread-0 is performing work.
Thread-> Thread-0 is performing work.
Thread-> Thread-0 is performing work.
Thread-> Thread-0 is performing work.
Thread-> Thread-0 is performing work.
Thread-> Thread-1 is performing work.
Thread-> Thread-1 is performing work.
Thread-> Thread-1 is performing work.
Thread-> Thread-1 is performing work.
Thread-> Thread-1 is performing work.
Thread-> Thread-2 is performing work.
Thread-> Thread-2 is performing work.
Thread-> Thread-2 is performing work.
Thread-> Thread-2 is performing work.
Thread-> Thread-2 is performing work.
Explanation:

In the above exercise -

The "SharedResourceExercise" class represents the main program. It creates an instance of the ReentrantLock class as the lock object and an instance of the "SharedResource" class as the shared resource object.
The "Worker" class implements the Runnable interface and represents the worker thread. Each worker thread acquires the lock using the lock() method before accessing the shared resource's doWork() method. After performing the work, the thread releases the lock using the unlock() method.
The "SharedResource" class represents shared resources. In this example, the doWork() method simulates work on the shared resource.
In the main() method, we create an array of worker threads, start them concurrently, and wait for them to finish using the join() method.

### 4. Write a Java program to demonstrate Semaphore usage for thread synchronization.

In computer science, a semaphore is a variable or abstract data type used to control access to a common resource by multiple threads and avoid critical section problems in a concurrent system such as a multitasking operating system. Semaphores are a type of synchronization primitive.

Write a Java program to demonstrate Semaphore usage for thread synchronization.

Sample Solution:

Java Code:
```java
//SemaphoreExercise.java
import java.util.concurrent.Semaphore;

public class SemaphoreExercise {
  private static final int NUM_THREADS = 5;
  private static final int NUM_PERMITS = 2;

  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(NUM_PERMITS);

    Thread[] threads = new Thread[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++) {
      threads[i] = new Thread(new Worker(semaphore));
      threads[i].start();
    }

    try {
      for (Thread thread: threads) {
        thread.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static class Worker implements Runnable {
    private Semaphore semaphore;

    public Worker(Semaphore semaphore) {
      this.semaphore = semaphore;
    }

    public void run() {
      try {
        semaphore.acquire();

        // Perform work that requires the semaphore
        System.out.println("Thread " + Thread.currentThread().getName() + " acquired the semaphore.");
        Thread.sleep(2000); // Simulating work
        System.out.println("Thread " + Thread.currentThread().getName() + " released the semaphore.");

        semaphore.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
```
Sample Output:

Thread Thread-0 acquired the semaphore.
Thread Thread-1 acquired the semaphore.
Thread Thread-0 released the semaphore.
Thread Thread-1 released the semaphore.
Thread Thread-2 acquired the semaphore.
Thread Thread-3 acquired the semaphore.
Thread Thread-3 released the semaphore.
Thread Thread-2 released the semaphore.
Thread Thread-4 acquired the semaphore.
Thread Thread-4 released the semaphore.
Explanation:

In the above exercise -

The "SemaphoreExercise" class represents the main program. It creates an instance of "Semaphore" with a specified number of permits (NUM_PERMITS).
The "Worker" class implements the Runnable interface and represents a worker thread. Each worker thread acquires a permit from the semaphore using the acquire() method. It performs some work that requires the semaphore, and then releases the permit using the release() method.
In the main() method, we create an array of worker threads, start them concurrently, and wait for them to finish using the join() method.

### 5. Write a Java program to showcase the usage of the CyclicBarrier class for thread synchronization.

A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point. CyclicBarriers are useful in programs involving a fixed sized party of threads that must occasionally wait for each other. The barrier is called cyclic because it can be re-used after the waiting threads are released.

A CyclicBarrier supports an optional Runnable command that is run once per barrier point, after the last thread in the party arrives, but before any threads are released. This barrier action is useful for updating shared-state before any of the parties continue.

Write a Java program to showcase the usage of the CyclicBarrier class for thread synchronization.

Sample Solution:

Java Code:
```java
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExercise {
  private static final int NUM_THREADS = 3;
  private static final CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, new BarrierAction());

  public static void main(String[] args) {
    Thread[] threads = new Thread[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++) {
      threads[i] = new Thread(new Worker());
      threads[i].start();
    }

    try {
      for (Thread thread: threads) {
        thread.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static class Worker implements Runnable {
    public void run() {
      try {
        System.out.println("Thread " + Thread.currentThread().getName() + " is waiting at the barrier.");
        barrier.await();

        // Perform work after reaching the barrier

        System.out.println("Thread " + Thread.currentThread().getName() + " has crossed the barrier and continued execution.");
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  static class BarrierAction implements Runnable {
    public void run() {
      System.out.println("Barrier reached! All threads have arrived at the barrier.");
    }
  }
}
```
Sample Output:

Thread Thread-2 is waiting at the barrier.
Thread Thread-0 is waiting at the barrier.
Thread Thread-1 is waiting at the barrier.
Barrier reached! All threads have arrived at the barrier.
Thread Thread-0 has crossed the barrier and continued execution.
Thread Thread-1 has crossed the barrier and continued execution.
Thread Thread-2 has crossed the barrier and continued execution.
Explanation:

In the above exercise -

The "CyclicBarrierExample" class represents the main program. It creates an instance of the CyclicBarrier class with the number of parties set to NUM_THREADS, and a BarrierAction object as the barrier action to be executed when all threads reach the barrier.
The "Worker" class implements the Runnable interface and represents the worker thread. Each worker thread waits at the barrier using await(). Once all threads reach the barrier, the barrier action is executed, and all threads continue with their execution.
The BarrierAction class represents the barrier action to be executed when all threads reach the barrier. In this example, it simply prints a message indicating that the barrier has been reached.
In the main() method, we create an array of worker threads, start them concurrently, and wait for them to finish using the join() method.

### 6. Write a Java program that uses the CountDownLatch class to synchronize the start and finish of multiple threads.

A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.

A CountDownLatch is initialized with a given count. The await methods block until the current count reaches zero due to invocations of the countDown() method, after which all waiting threads are released and any subsequent invocations of await return immediately. This is a one-shot phenomenon -- the count cannot be reset. If you need a version that resets the count, consider using a CyclicBarrier.

A CountDownLatch is a versatile synchronization tool and can be used for a number of purposes. A CountDownLatch initialized with a count of one serves as a simple on/off latch, or gate: all threads invoking await wait at the gate until it is opened by a thread invoking countDown(). A CountDownLatch initialized to N can be used to make one thread wait until N threads have completed some action, or some action has been completed N times.

A useful property of a CountDownLatch is that it doesn't require that threads calling countDown wait for the count to reach zero before proceeding, it simply prevents any thread from proceeding past an await until all threads could pass.

Write a Java program that uses the CountDownLatch class to synchronize the start and finish of multiple threads.

Sample Solution:

Java Code:
```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExercise {
  private static final int NUM_THREADS = 3;
  private static final CountDownLatch startLatch = new CountDownLatch(1);
  private static final CountDownLatch finishLatch = new CountDownLatch(NUM_THREADS);

  public static void main(String[] args) {
    Thread[] threads = new Thread[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++) {
      threads[i] = new Thread(new Worker());
      threads[i].start();
    }

    // Allow threads to start simultaneously
    startLatch.countDown();

    try {
      finishLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("All threads have finished their work.");
  }

  static class Worker implements Runnable {
    public void run() {
      try {
        startLatch.await();

        // Perform work

        System.out.println("Thread " + Thread.currentThread().getName() + " has finished its work.");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        finishLatch.countDown();
      }
    }
  }
}
```
Sample Output:

Thread Thread-0 has finished its work.
Thread Thread-1 has finished its work.
Thread Thread-2 has finished its work.
All threads have finished their work.
Explanation:

In the above exercise -

The "CountDownLatchExample" class represents the main program. It creates two instances of CountDownLatch: startLatch with an initial count of 1 to synchronize the start of all threads, and finishLatch with an initial count equal to the number of threads to synchronize the finish of all threads.
The "Worker" class implements the Runnable interface and represents the worker thread. Each worker thread waits at the startLatch using the await() method until the latch is counted down to zero. Once the latch is counted down, all threads start simultaneously. After completing their work, each thread counts down the finishLatch using the countDown() method.
In the main() method, we create an array of worker threads, start them concurrently, and allow them to start simultaneously. We do this by counting down the startLatch using the countDown() method. We then wait for all threads to finish their work by using the await() method on the finishLatch. Finally, we print a message indicating that all threads have finished their work.
The program output shows the completion of each thread's work and the final message indicates that all threads have finished.

### 7. Write a Java program to illustrate the usage of the ReadWriteLock interface for concurrent read-write access to a shared resource.

A ReadWriteLock maintains a pair of associated locks, one for read-only operations and one for writing. The read lock may be held simultaneously by multiple reader threads, so long as there are no writers. The write lock is exclusive.

All ReadWriteLock implementations must guarantee that the memory synchronization effects of writeLock operations (as specified in the Lock interface) also hold with respect to the associated readLock. That is, a thread successfully acquiring the read lock will see all updates made upon previous release of the write lock.

A read-write lock allows for a greater level of concurrency in accessing shared data than that permitted by a mutual exclusion lock. It exploits the fact that while only a single thread at a time (a writer thread) can modify the shared data, in many cases any number of threads can concurrently read the data (hence reader threads). In theory, the increase in concurrency permitted by the use of a read-write lock will lead to performance improvements over the use of a mutual exclusion lock. In practice this increase in concurrency will only be fully realized on a multi-processor, and then only if the access patterns for the shared data are suitable.

Write a Java program to illustrate the usage of the ReadWriteLock interface for concurrent read-write access to a shared resource.

Sample Solution:

Java Code:
```java
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExercise {
  private static final int NUM_READERS = 3;
  private static final int NUM_WRITERS = 2;

  public static void main(String[] args) {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    SharedResource sharedResource = new SharedResource();

    // Create and start the reader threads
    for (int i = 0; i < NUM_READERS; i++) {
      Thread readerThread = new Thread(new Reader(lock, sharedResource));
      readerThread.start();
    }

    // Create and start the writer threads
    for (int i = 0; i < NUM_WRITERS; i++) {
      Thread writerThread = new Thread(new Writer(lock, sharedResource));
      writerThread.start();
    }
  }

  static class Reader implements Runnable {
    private ReadWriteLock lock;
    private SharedResource sharedResource;

    public Reader(ReadWriteLock lock, SharedResource sharedResource) {
      this.lock = lock;
      this.sharedResource = sharedResource;
    }

    public void run() {
      while (true) {
        lock.readLock().lock();

        // Read from the shared resource
        System.out.println("Reader " + Thread.currentThread().getName() + " reads: " + sharedResource.read());

        lock.readLock().unlock();

        // Delay between consecutive reads
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Writer implements Runnable {
    private ReadWriteLock lock;
    private SharedResource sharedResource;
    private int counter = 0;

    public Writer(ReadWriteLock lock, SharedResource sharedResource) {
      this.lock = lock;
      this.sharedResource = sharedResource;
    }

    public void run() {
      while (true) {
        lock.writeLock().lock();

        // Write to the shared resource
        sharedResource.write("Writer " + Thread.currentThread().getName() + " writes: " + counter++);

        lock.writeLock().unlock();

        // Delay between consecutive writes
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class SharedResource {
    private String data;

    public String read() {
      return data;
    }

    public void write(String data) {
      this.data = data;
    }
  }
}
```
Sample Output:

Reader Thread-2 reads: null
Reader Thread-0 reads: null
Reader Thread-1 reads: null
Reader Thread-2 reads: Writer Thread-4 writes: 0
Reader Thread-0 reads: Writer Thread-4 writes: 0
Reader Thread-1 reads: Writer Thread-4 writes: 0
Reader Thread-2 reads: Writer Thread-4 writes: 1
Reader Thread-0 reads: Writer Thread-4 writes: 1
Reader Thread-1 reads: Writer Thread-4 writes: 1
Reader Thread-2 reads: Writer Thread-4 writes: 1
Reader Thread-1 reads: Writer Thread-4 writes: 1
Reader Thread-0 reads: Writer Thread-4 writes: 1
Reader Thread-1 reads: Writer Thread-4 writes: 2
Explanation:

In the above exercise -

The "ReadWriteLockExample" class represents the main program. It creates an instance of the "ReentrantReadWriteLock" class, which implements the ReadWriteLock interface, and an instance of the SharedResource class.
The "Reader" class implements the Runnable interface and represents a reader thread. Each reader thread acquires the read lock using the readLock() method, reads from the shared resource, and then releases the read lock using the unlock() method. Readers can read from the shared resource concurrently without blocking each other.
The "Writer" class implements the Runnable interface and represents a writer thread. Each writer thread acquires the write lock using the writeLock() method, writes to the shared resource, and then releases the write lock using the unlock() method. Only one writer can write to the shared resource at a time, and writers block readers and other writers.
The "SharedResource" class represents shared resources. In this example, it has a read() method to read from the shared resource and a write() method to write to the shared resource.
In the main() method, we create and start multiple reader threads and writer threads. Readers can read concurrently from the shared resource, and writers can write one at a time while blocking readers and other writers.

### 8. Write a Java program demonstrating how to access a map concurrently using the ConcurrentHashMap class.

ConcurrentHashMap:

A hash table supporting full concurrency of retrievals and high expected concurrency for updates. This class obeys the same functional specification as Hashtable, and includes versions of methods corresponding to each method of Hashtable. However, even though all operations are thread-safe, retrieval operations do not entail locking, and there is not any support for locking the entire table in a way that prevents all access. This class is fully interoperable with Hashtable in programs that rely on its thread safety but not on its synchronization details.

Write a Java program demonstrating how to access a map concurrently using the ConcurrentHashMap class.

Sample Solution:

Java Code:
```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExercise {
  public static void main(String[] args) {
    ConcurrentHashMap < String, Integer > map = new ConcurrentHashMap < > ();

    // Create and start the writer threads
    Thread writerThread1 = new Thread(new Writer(map, "Thread-1", 1));
    Thread writerThread2 = new Thread(new Writer(map, "Thread-2", 2));
    writerThread1.start();
    writerThread2.start();

    // Create and start the reader threads
    Thread readerThread1 = new Thread(new Reader(map, "Thread-1"));
    Thread readerThread2 = new Thread(new Reader(map, "Thread-2"));
    readerThread1.start();
    readerThread2.start();
  }

  static class Writer implements Runnable {
    private ConcurrentHashMap < String, Integer > map;
    private String threadName;
    private int value;

    public Writer(ConcurrentHashMap < String, Integer > map, String threadName, int value) {
      this.map = map;
      this.threadName = threadName;
      this.value = value;
    }

    public void run() {
      for (int i = 0; i < 5; i++) {
        map.put(threadName, value);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Reader implements Runnable {
    private ConcurrentHashMap < String, Integer > map;
    private String threadName;

    public Reader(ConcurrentHashMap < String, Integer > map, String threadName) {
      this.map = map;
      this.threadName = threadName;
    }

    public void run() {
      for (int i = 0; i < 5; i++) {
        Integer value = map.get(threadName);
        System.out.println("Thread " + threadName + " read value: " + value);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
```
Sample Output:

Thread Thread-1 read value: 1
Thread Thread-2 read value: 2
Thread Thread-1 read value: 1
Thread Thread-2 read value: 2
Thread Thread-2 read value: 2
Thread Thread-1 read value: 1
Thread Thread-1 read value: 1
Thread Thread-2 read value: 2
Thread Thread-1 read value: 1
Thread Thread-2 read value: 2
Explanation:

In the above exercise:

The "ConcurrentHashMapExercise" class represents the main program. It creates an ConcurrentHashMap instance called map.
The "Writer" class implements the Runnable interface and represents a writer thread. Each writer thread puts key-value pairs into the map using the put() method. In this example, each writer thread puts its thread name as the key and an incrementing value as the value.
The "Reader" class implements the Runnable interface and represents a reader thread. Each reader thread gets the value associated with its thread name from the map using the get() method. It then prints the value.
In the main() method, we create and start two writer threads and two reader threads. Writers put key-value pairs into the map, and readers get the values from the map. Since ConcurrentHashMap supports concurrent access, writers and readers can access the map simultaneously without explicit synchronization.

### 9. Write a Java program that utilizes the ConcurrentLinkedQueue class to implement a thread-safe queue.

ConcurrentLinkedQueue:

An unbounded thread-safe queue based on linked nodes. This queue orders elements FIFO (first-in-first-out). The head of the queue is that element that has been on the queue the longest time. The tail of the queue is that element that has been on the queue the shortest time. New elements are inserted at the tail of the queue, and the queue retrieval operations obtain elements at the head of the queue. A ConcurrentLinkedQueue is an appropriate choice when many threads will share access to a common collection. Like most other concurrent collection implementations, this class does not permit the use of null elements.

This implementation employs an efficient non-blocking algorithm based on one described in Simple, Fast, and Practical Non-Blocking and Blocking Concurrent Queue Algorithms by Maged M. Michael and Michael L. Scott.

Iterators are weakly consistent, returning elements reflecting the state of the queue at some point at or since the creation of the iterator. They do not throw ConcurrentModificationException, and may proceed concurrently with other operations. Elements contained in the queue since the creation of the iterator will be returned exactly once.


Write a Java program that utilizes the ConcurrentLinkedQueue class to implement a thread-safe queue.

Sample Solution:

Java Code:
```java
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExercise {
  public static void main(String[] args) {
    ConcurrentLinkedQueue < String > queue = new ConcurrentLinkedQueue < > ();

    // Create and start the producer threads
    Thread producerThread1 = new Thread(new Producer(queue, "Producer-1"));
    Thread producerThread2 = new Thread(new Producer(queue, "Producer-2"));
    producerThread1.start();
    producerThread2.start();

    // Create and start the consumer threads
    Thread consumerThread1 = new Thread(new Consumer(queue, "Consumer-1"));
    Thread consumerThread2 = new Thread(new Consumer(queue, "Consumer-2"));
    consumerThread1.start();
    consumerThread2.start();
  }

  static class Producer implements Runnable {
    private ConcurrentLinkedQueue < String > queue;
    private String producerName;
    private int counter;

    public Producer(ConcurrentLinkedQueue < String > queue, String producerName) {
      this.queue = queue;
      this.producerName = producerName;
      this.counter = 0;
    }

    public void run() {
      while (true) {
        String item = producerName + "-Item-" + counter++;
        queue.offer(item);
        System.out.println("Produced: " + item);

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Consumer implements Runnable {
    private ConcurrentLinkedQueue < String > queue;
    private String consumerName;

    public Consumer(ConcurrentLinkedQueue < String > queue, String consumerName) {
      this.queue = queue;
      this.consumerName = consumerName;
    }

    public void run() {
      while (true) {
        String item = queue.poll();
        if (item != null) {
          System.out.println(consumerName + " consumed: " + item);
        }

        try {
          Thread.sleep(1500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
```
Sample Output:

Produced: Producer-2-Item-0
Produced: Producer-1-Item-0
Produced: Producer-2-Item-1
Produced: Producer-1-Item-1
Consumer-2 consumed: Producer-1-Item-0
Consumer-1 consumed: Producer-2-Item-0
Produced: Producer-2-Item-2
Produced: Producer-1-Item-2
Produced: Producer-1-Item-3
Produced: Producer-2-Item-3
.................................................
.................................................
.................................................

Explanation:

In the above exercise -

The "ConcurrentQueueExample" class represents the main program. It creates an instance of ConcurrentLinkedQueue called a queue.
The "Producer" class implements the Runnable interface and represents a producer thread. Each producer thread generates a unique item using the producer name and a counter. It adds it to the queue using the offer() method.
The "Consumer" class implements the Runnable interface and represents a consumer thread. Consumer threads retrieve items from the queue using the poll() method and prints it.
In the main() method, we create and start two producer threads and two consumer threads. Producers add items to the queue, and consumers retrieve and print them. Since ConcurrentLinkedQueue is thread-safe, multiple producers and consumers can access the queue concurrently without explicit synchronization.

### 10. Write a Java program to showcase the usage of the Phaser class for coordination and synchronization of multiple threads.

class Phaser: A reusable synchronization barrier, similar in functionality to CyclicBarrier and CountDownLatch but supporting more flexible usage.

Write a Java program to showcase the usage of the Phaser class for coordination and synchronization of multiple threads.

Sample Solution:

Java Code:
```java
import java.util.concurrent.Phaser;

public class PhaserExercise {

  public static void main(String[] args) {
    // Create a Phaser with 4 registered parties
    Phaser phaser = new Phaser(4);

    // Create and start three worker threads
    Thread thread1 = new Thread(new Worker(phaser, "Thread 1"));
    Thread thread2 = new Thread(new Worker(phaser, "Thread 2"));
    Thread thread3 = new Thread(new Worker(phaser, "Thread 3"));
    Thread thread4 = new Thread(new Worker(phaser, "Thread 4"));
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    // Wait for all threads to complete
    phaser.awaitAdvance(phaser.getPhase());

    System.out.println("All threads have completed their tasks.");
  }

  static class Worker implements Runnable {
    private final Phaser phaser;
    private final String name;

    public Worker(Phaser phaser, String name) {
      this.phaser = phaser;
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println(name + " starting phase 1");
      phaser.arriveAndAwaitAdvance(); // Wait for all threads to reach this point

      // Perform phase 1 tasks
      System.out.println(name + " performing phase 1 tasks");

      // Wait for all threads to complete phase 1
      phaser.arriveAndAwaitAdvance();

      System.out.println(name + " starting phase 2");
      phaser.arriveAndAwaitAdvance(); // Wait for all threads to reach this point

      // Perform phase 2 tasks
      System.out.println(name + " performing phase 2 tasks");

      // Wait for all threads to complete phase 2
      phaser.arriveAndAwaitAdvance();

      System.out.println(name + " completed all phases");
      phaser.arriveAndDeregister(); // Deregister from the Phaser
    }
  }
}
```
Sample Output:

Thread 4 starting phase 1
Thread 1 starting phase 1
Thread 2 starting phase 1
Thread 3 starting phase 1
All threads have completed their tasks.
Thread 3 performing phase 1 tasks
Thread 4 performing phase 1 tasks
Thread 2 performing phase 1 tasks
Thread 1 performing phase 1 tasks
Thread 1 starting phase 2
Thread 2 starting phase 2
Thread 3 starting phase 2
Thread 4 starting phase 2
Thread 4 performing phase 2 tasks
Thread 1 performing phase 2 tasks
Thread 3 performing phase 2 tasks
Thread 2 performing phase 2 tasks
Thread 2 completed all phases
Thread 4 completed all phases
Thread 3 completed all phases
Thread 1 completed all phases
Explanation:

In the above exercise, we create a Phaser with 4 registered parties (threads) and start three worker threads. Each worker thread passes through two phases, and the Phaser ensures that all threads reach specific synchronization points before proceeding to the next phase. Once all threads have completed their tasks, the program outputs a message indicating completion.


The Phaser class provides coordination and synchronization by using methods like arriveAndAwaitAdvance() to wait for all parties to arrive at a specific phase. It also uses arriveAndDeregister() to indicate completion and deregister from the Phaser.

### 11. Write a Java program that utilizes the Exchanger class for exchanging data between two threads.
```java
import java.util.concurrent.Exchanger;

public class ExchangerExercise {

  public static void main(String[] args) {
    Exchanger < String > exchanger = new Exchanger < > ();

    // Create and start two worker threads
    Thread thread1 = new Thread(new Worker(exchanger, "Data from Thread 1"));
    Thread thread2 = new Thread(new Worker(exchanger, "Data from Thread 2"));
    thread1.start();
    thread2.start();
  }

  static class Worker implements Runnable {
    private final Exchanger < String > exchanger;
    private final String data;

    public Worker(Exchanger < String > exchanger, String data) {
      this.exchanger = exchanger;
      this.data = data;
    }

    @Override
    public void run() {
      try {
        System.out.println(Thread.currentThread().getName() + " sending data: " + data);
        String receivedData = exchanger.exchange(data); // Exchange data with the other thread

        System.out.println(Thread.currentThread().getName() + " received data: " + receivedData);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
```
Sample Output:

Thread-1 sending data: Data from Thread 2
Thread-0 sending data: Data from Thread 1
Thread-0 received data: Data from Thread 2
Thread-1 received data: Data from Thread 1
Explanation:

In the above exercise, we create an Exchanger<String> instance for exchanging data between two threads. Each worker thread sends its own data and receives it from the other thread using the exchange() method of the Exchanger. The threads will block until both threads arrive at the exchange point.


When we run this program, you'll see that each thread sends its own data and receives the data sent by the other thread through the Exchanger. This demonstrates the exchange of data between two threads.

### 12. Write a Java program to demonstrate the usage of the Callable and Future interfaces for executing tasks asynchronously and obtaining their results.
```java
import java.util.concurrent.*;

public class CallableFutureExercise {

  public static void main(String[] args) {
    // Create a thread pool with a single worker thread
    ExecutorService executor = Executors.newSingleThreadExecutor();

    // Submit a Callable task to the executor
    Future < String > future = executor.submit(new Task());

    // Perform other operations while the task is executing

    try {
      // Wait for the task to complete and get the result
      String result = future.get();

      System.out.println("Task result: " + result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    // Shutdown the executor
    executor.shutdown();
  }

  static class Task implements Callable < String > {
    @Override
    public String call() throws Exception {
      // Perform the task and return the result
      Thread.sleep(2000); // Simulate some time-consuming operation
      return "Task completed!";
    }
  }
}
```
Sample Output:

Task result: Task completed!
Explanation:

In the above exercise -

First we create a Callable task called "Task" that performs a time-consuming operation and returns a String result. We then create an ExecutorService with a single worker thread using the Executors.newSingleThreadExecutor() method.
We submit the Task to the executor using the submit() method, which returns a Future object representing the task result. We can continue performing other operations while the task executes.
To obtain the result of the task, we call the get() method on the Future object. This method blocks until the task is complete and returns the result. We handle possible exceptions like InterruptedException and ExecutionException that may occur during the execution or retrieval of the result.
Finally, we shutdown the executor using the shutdown() method to release its resources.

### 13. Write a Java program that uses the ScheduledExecutorService interface to schedule tasks for execution at a specified time or with a fixed delay.

```java
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExercise {

  public static void main(String[] args) {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    // Schedule a task to run after a delay of 2 seconds
    executor.schedule(new Task(), 2, TimeUnit.SECONDS);

    // Schedule a task to run after a delay of 3 seconds and repeat every 5 seconds
    executor.scheduleAtFixedRate(new Task(), 3, 5, TimeUnit.SECONDS);

    // Wait for scheduled tasks to complete
    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Shutdown the executor
    executor.shutdown();
  }

  static class Task implements Runnable {
    @Override
    public void run() {
      System.out.println("Task executed at: " + new Date());
    }
  }
}
```
Sample Output:

Task executed at: Wed Jul 15 08:25:12 IST 2020
Task executed at: Wed Jul 15 08:25:13 IST 2020
Task executed at: Wed Jul 15 08:25:18 IST 2020
Task executed at: Wed Jul 15 08:25:23 IST 2020
Explanation:

In the above exercise -

First, we create a ScheduledExecutorService using Executors.newScheduledThreadPool(1) to create a thread pool with a single worker thread.
Schedule a task to run after a delay of 2 seconds using the schedule() method. This task is executed only once.
Next schedule a task to run after a delay of 3 seconds and repeat every 5 seconds using the scheduleAtFixedRate() method. This task is executed repeatedly at a fixed rate.
To allow scheduled tasks to execute, we use Thread.sleep() to pause the main thread for 15 seconds.
Finally, we shutdown the executor using the shutdown() method to release its resources.

### 14. Write a Java program to demonstrate the usage of the ForkJoinPool class for parallel execution of recursive tasks.
```java
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExercise {

  public static void main(String[] args) {
    int[] array = {
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10
    };

    ForkJoinPool forkJoinPool = new ForkJoinPool();

    int sum = forkJoinPool.invoke(new SumTask(array, 0, array.length));

    System.out.println("Sum: " + sum);
  }

  static class SumTask extends RecursiveTask < Integer > {
    private final int[] array;
    private final int start;
    private final int end;

    public SumTask(int[] array, int start, int end) {
      this.array = array;
      this.start = start;
      this.end = end;
    }

    @Override
    protected Integer compute() {
      if (end - start <= 2) {
        int sum = 0;
        for (int i = start; i < end; i++) {
          sum += array[i];
        }
        return sum;
      } else {
        int mid = start + (end - start) / 2;

        SumTask leftTask = new SumTask(array, start, mid);
        SumTask rightTask = new SumTask(array, mid, end);

        invokeAll(leftTask, rightTask);

        return leftTask.join() + rightTask.join();
      }
    }
  }
}
```
Sample Output:

Sum: 55
Explanation:

In the above exercise -

"SumTask" is a subclass of RecursiveTask<Integer>, where Integer is the result type. It takes an array, a start index, and an end index as input parameters.
In the compute() method, if the subarray size is small enough (in this case, 2 or fewer elements), it is possible to compute directly the sum of the subarray and return the result.
Otherwise, we split the subarray into two halves and created two new SumTask instances for each half. We then use the invokeAll() method to submit both tasks to the ForkJoinPool for parallel execution. Finally, we return the sum of the results of both tasks using the join() method.
The invoke() method is used to start the computation and retrieve the result. In this case, we store the sum in the sum variable and print it.
When we run this program, the sum of the array elements is computed in parallel using the ForkJoinPool.

### 15. Write a Java program that utilizes the StampedLock class for optimizing concurrent read-write access to a shared resource.
```java
import java.util.concurrent.locks.StampedLock;

public class StampedLockExercise {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Start multiple reader threads
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int value = sharedResource.getValue();
                System.out.println("Reader thread: " + Thread.currentThread().getName() + ", value: " + value);
            }).start();
        }

        // Start a writer thread
        new Thread(() -> {
            sharedResource.setValue(42);
            System.out.println("Writer thread: " + Thread.currentThread().getName() + " set value to 42");
        }).start();
    }

    static class SharedResource {
        private int value;
        private final StampedLock lock = new StampedLock();

        public int getValue() {
            long stamp = lock.tryOptimisticRead(); // Optimistically acquire a read lock

            int currentValue = value;

            if (!lock.validate(stamp)) { // Check for concurrent write
                stamp = lock.readLock(); // Upgrade to a read lock
                try {
                    currentValue = value;
                } finally {
                    lock.unlockRead(stamp); // Release the read lock
                }
            }

            return currentValue;
        }

        public void setValue(int value) {
            long stamp = lock.writeLock(); // Acquire a write lock

            try {
                this.value = value;
            } finally {
                lock.unlockWrite(stamp); // Release the write lock
            }
        }
    }
}
```
Sample Output:

Writer thread: Thread-5 set value to 42
Reader thread: Thread-4, value: 0
Reader thread: Thread-0, value: 0
Reader thread: Thread-1, value: 0
Reader thread: Thread-2, value: 0
Reader thread: Thread-3, value: 0
Explanation:

In the above exercise -

The "SharedResource" class uses a StampedLock to provide concurrent read-write access to the shared resource while optimizing for reads. Multiple reader threads can concurrently access the value without blocking each other.
The "getValue()" method demonstrates optimistic read locking. It first acquires an optimistic read lock using tryOptimisticRead(). If the lock is valid, it retrieves the current value without explicitly acquiring a read lock. If the lock is not valid (indicating a concurrent write), it upgrades to a read lock using readLock() and retrieves the value. Finally, it releases the read lock using unlockRead().
The "setValue()" method acquires a write lock using writeLock() to update the value. Once the update is complete, it releases the write lock using unlockWrite().
In the main() method, multiple reader threads are started concurrently, each accessing the shared resource using getValue(). Additionally, a writer thread sets the value using setValue().
When you run this program, you'll see that the reader threads can access the value concurrently without blocking each other. In addition, the writer thread can update the value exclusively.

