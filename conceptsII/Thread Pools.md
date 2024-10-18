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
