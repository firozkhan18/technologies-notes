
<details><summary><b>Java Collection Framework</b></summary>
	
The Java Collection Framework is a unified architecture for representing and manipulating collections of objects. It provides various classes and interfaces to work with data in a flexible and efficient manner. Here's a detailed overview:

## 1. **Core Interfaces**

### a. **Collection Interface**
- The root interface in the collection hierarchy. It defines basic operations such as adding, removing, and querying elements.

### b. **List Interface**
- An ordered collection (also known as a sequence) that can contain duplicate elements.
- Common implementations: 
  - **ArrayList**: Resizable array implementation; provides fast random access.
  - **LinkedList**: Doubly-linked list implementation; better for insertion and deletion operations.

**Example:**
```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
```

### c. **Set Interface**
- A collection that does not allow duplicate elements.
- Common implementations:
  - **HashSet**: Uses a hash table; no guaranteed order of elements.
  - **LinkedHashSet**: Maintains insertion order.
  - **TreeSet**: Implements a sorted set using a red-black tree; maintains natural ordering or a specified comparator.

**Example:**
```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.add("A"); // Duplicate, will not be added
```

### d. **Map Interface**
- An object that maps keys to values, where each key is unique.
- Common implementations:
  - **HashMap**: Uses a hash table; allows null keys and values; no guaranteed order.
  - **LinkedHashMap**: Maintains insertion order.
  - **TreeMap**: Implements a sorted map; keys are sorted according to their natural ordering or a specified comparator.

**Example:**
```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
```

### e. **Queue Interface**
- A collection designed for holding elements prior to processing.
- Common implementations:
  - **PriorityQueue**: Elements are ordered according to their natural ordering or a specified comparator.
  - **LinkedList**: Can be used as a queue as it implements the Queue interface.

**Example:**
```java
Queue<String> queue = new LinkedList<>();
queue.offer("A");
queue.offer("B");
String first = queue.poll(); // Retrieves and removes the head of the queue
```

## 2. **Key Classes**

### a. **ArrayList**
- Resizable array implementation of the List interface.
- Good for random access, but slower for insertions and deletions compared to linked lists.

### b. **LinkedList**
- Implements both List and Deque interfaces.
- Provides better performance for insertions and deletions.

### c. **HashSet**
- Implements Set using a hash table.
- Provides constant-time performance for basic operations.

### d. **TreeSet**
- Implements Set using a red-black tree.
- Allows sorted access.

### e. **HashMap**
- Implements Map using a hash table.
- Provides constant-time performance for get and put operations.

### f. **TreeMap**
- Implements Map using a red-black tree.
- Maintains order according to keys.

## 3. **Utility Classes**

### a. **Collections**
- A utility class that contains static methods for manipulating collections (e.g., sorting, searching).

**Example:**
```java
List<String> list = Arrays.asList("B", "A", "C");
Collections.sort(list); // Sorts the list
```

### b. **Arrays**
- A utility class that contains methods for manipulating arrays (e.g., sorting, searching).

**Example:**
```java
int[] numbers = {3, 1, 2};
Arrays.sort(numbers); // Sorts the array
```

## 4. **Important Features**

### a. **Generics**
- Collections use generics to provide type safety. For example, `List<String>` ensures that only strings can be added.

### b. **Iterators**
- Iterators allow you to traverse collections without exposing their underlying representation.

**Example:**
```java
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### c. **Streams API**
- Introduced in Java 8, the Streams API allows functional-style operations on collections, enabling filtering, mapping, and reducing.

**Example:**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println);
```

## 5. **Concurrent Collections**

Java provides thread-safe collections in the `java.util.concurrent` package, such as:

### a. **ConcurrentHashMap**
- A thread-safe variant of HashMap that allows concurrent reads and updates.

### b. **CopyOnWriteArrayList**
- A thread-safe variant of ArrayList where all mutative operations (add, set, etc.) are implemented by making a fresh copy of the underlying array.

### c. **BlockingQueue**
- An interface that represents a thread-safe queue that supports blocking operations.

**Example:**
```java
BlockingQueue<String> queue = new LinkedBlockingQueue<>();
queue.put("A"); // Blocks if the queue is full
String item = queue.take(); // Blocks if the queue is empty
```

## 6. **Common Operations**

- **Adding elements**: `add()`, `put()`
- **Removing elements**: `remove()`, `poll()`
- **Iterating**: Using `forEach`, `Iterator`
- **Sorting**: Using `Collections.sort()`, `stream().sorted()`
- **Searching**: Using `contains()`, `stream().filter()`

## Conclusion

The Java Collection Framework is a powerful and flexible set of classes and interfaces that simplifies the management of groups of objects. Understanding its structure and capabilities is essential for effective Java programming. If you have specific questions or need more examples, feel free to ask!


Java 8 introduced several significant enhancements to the `Map` interface, making it more powerful and easier to work with. Here are the key changes:

### 1. Default Methods
Java 8 added default methods to interfaces, allowing you to provide implementations directly within the interface. For `Map`, the following methods were added:

- **`forEach(BiConsumer<? super K,? super V> action)`**: This method iterates over each entry in the map and applies the given action.

  ```java
  Map<String, Integer> map = new HashMap<>();
  map.put("One", 1);
  map.put("Two", 2);
  
  map.forEach((key, value) -> System.out.println(key + ": " + value));
  ```

- **`getOrDefault(Object key, V defaultValue)`**: Returns the value associated with the key, or a default value if the key is not present.

  ```java
  int value = map.getOrDefault("Three", 0); // Returns 0
  ```

- **`remove(Object key, Object value)`**: Removes the entry for a key only if it is currently mapped to a specific value.

  ```java
  map.remove("One", 1); // Removes the entry if the value is 1
  ```

- **`replace(K key, V value)`**: Replaces the entry for a key only if it is currently mapped to some value.

  ```java
  map.replace("Two", 3); // Changes the value of "Two" to 3
  ```

- **`replace(K key, V oldValue, V newValue)`**: Replaces the entry for a key only if currently mapped to the specified value.

### 2. `Map.of()` and `Map.ofEntries()`
Java 9 introduced static factory methods for creating immutable maps. This is useful for quickly creating small maps without having to create a new `HashMap`.

```java
Map<String, Integer> immutableMap = Map.of("One", 1, "Two", 2);
Map<String, Integer> anotherImmutableMap = Map.ofEntries(
    Map.entry("Three", 3),
    Map.entry("Four", 4)
);
```

### 3. Stream Support
With the addition of the `Stream` API, you can easily transform maps and perform bulk operations:

- **`keySet().stream()`** or **`entrySet().stream()`** to create a stream of keys or entries, respectively.

```java
map.entrySet().stream()
    .filter(entry -> entry.getValue() > 1)
    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
```

### 4. `computeIfAbsent()` and `computeIfPresent()`
These methods allow for more concise and efficient manipulation of map entries:

- **`computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)`**: Computes a value for the given key if it is not already present.

  ```java
  map.computeIfAbsent("Three", k -> 3); // Adds "Three" with value 3 if not present
  ```

- **`computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)`**: Computes a new value if the key is present.

  ```java
  map.computeIfPresent("Two", (k, v) -> v + 1); // Increments the value of "Two"
  ```

### Summary
These enhancements make the `Map` interface in Java 8 and beyond more flexible and easier to use, especially when dealing with functional programming paradigms. They enable cleaner and more expressive code when working with collections in Java.

### ConcurrentHashMap in Java

`ConcurrentHashMap` is part of the `java.util.concurrent` package and is designed for concurrent access, allowing multiple threads to read and write without requiring explicit synchronization. It provides high concurrency while maintaining thread safety.

#### Key Features
- **Segmented Storage**: Divides the map into segments, allowing for concurrent reads and writes.
- **Lock-Free Reads**: Read operations can be performed without locking, improving performance.
- **Fine-Grained Locking**: Writes are synchronized on individual segments, allowing for higher throughput compared to a fully synchronized map.
- **No Nulls**: Does not allow null keys or values.

### Key Methods

Here are the main methods provided by `ConcurrentHashMap`:

1. **Constructor**
   - `ConcurrentHashMap()`: Initializes a default concurrent hash map.
   - `ConcurrentHashMap(int initialCapacity)`: Initializes with a specific initial capacity.
   - `ConcurrentHashMap(int initialCapacity, float loadFactor)`: Initializes with specific capacity and load factor.
   - `ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)`: Initializes with specific parameters.

2. **put() and putIfAbsent()**
   - `V put(K key, V value)`: Inserts or updates the value for the specified key.
   - `V putIfAbsent(K key, V value)`: Inserts the value if the key is not already associated with a value.

3. **get()**
   - `V get(Object key)`: Retrieves the value associated with the specified key.

4. **remove() and remove() with value**
   - `V remove(Object key)`: Removes the key (and its value) from the map.
   - `boolean remove(Object key, Object value)`: Removes the entry for the key only if it is currently mapped to the specified value.

5. **replace()**
   - `V replace(K key, V value)`: Replaces the entry for the specified key only if it is currently mapped to some value.
   - `boolean replace(K key, V oldValue, V newValue)`: Replaces the entry for the key only if it is currently mapped to the specified old value.

6. **computeIfAbsent()**
   - `V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)`: Computes a value if absent.

7. **computeIfPresent()**
   - `V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)`: Computes a new value if the key is present.

8. **forEach()**
   - `void forEach(BiConsumer<? super K,? super V> action)`: Performs the given action for each entry.

9. **size()**
   - `int size()`: Returns the number of key-value mappings.

### Example Code

Here’s an example of how to use `ConcurrentHashMap`:

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Adding elements
        map.put("One", 1);
        map.put("Two", 2);
        map.putIfAbsent("Three", 3);

        // Getting elements
        System.out.println("Value for key 'Two': " + map.get("Two"));

        // Removing an element
        map.remove("One");

        // Replacing an element
        map.replace("Two", 22);

        // Displaying elements
        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // Size of the map
        System.out.println("Size of map: " + map.size());
    }
}
```

### Common Interview Questions

1. **What is the difference between HashMap and ConcurrentHashMap?**
   - `HashMap` is not thread-safe, while `ConcurrentHashMap` is designed for concurrent access.
   - `HashMap` allows null keys/values; `ConcurrentHashMap` does not.

2. **How does ConcurrentHashMap achieve thread safety?**
   - It uses segmented locking and lock-free reads to manage concurrent access efficiently.

3. **Can you explain the putIfAbsent method?**
   - This method inserts the specified value if the key is not already present, allowing you to avoid overwriting existing values.

4. **What happens if two threads try to update the same key in a ConcurrentHashMap?**
   - The updates will be handled safely. Only one thread will succeed in updating the value, ensuring that the map remains in a consistent state.

### Coding Questions

1. **Implement a simple caching mechanism using ConcurrentHashMap.**
   - Create a cache class that uses `ConcurrentHashMap` to store and retrieve values.

2. **Count the frequency of words in a list using ConcurrentHashMap.**
   - Given a list of words, use `ConcurrentHashMap` to count how many times each word appears.

#### Example for Word Count

```java
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WordCountExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();

        words.parallelStream().forEach(word -> 
            wordCount.merge(word, 1, Integer::sum)
        );

        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}
```

In this example, we use `parallelStream` to process the list of words concurrently and `merge` to update the count in the `ConcurrentHashMap`. This allows for thread-safe updates without explicit synchronization.

Here’s a detailed explanation of the terms you mentioned, along with examples and key points.

### 1. Race Condition

**Definition**: A race condition occurs when two or more threads access shared data and try to change it simultaneously. This can lead to unpredictable results if proper synchronization is not implemented.

**Example**:

```java
class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount()); // May not be 2000 due to race condition
    }
}
```

### 2. Fail-Fast and Fail-Safe

**Fail-Fast**: Fail-fast systems immediately throw an error when they detect an inconsistency or an invalid state. This approach allows developers to identify issues early.

**Example**: Iterating over a `Collection` while modifying it.

```java
import java.util.ArrayList;
import java.util.List;

public class FailFastExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        for (String s : list) {
            if (s.equals("Two")) {
                list.remove(s); // Throws ConcurrentModificationException
            }
        }
    }
}
```

**Fail-Safe**: Fail-safe systems handle errors gracefully, allowing the program to continue functioning even if an issue arises.

**Example**: Using a `CopyOnWriteArrayList`, which is a thread-safe variant of `ArrayList`.

```java
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeExample {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        for (String s : list) {
            if (s.equals("Two")) {
                list.remove(s); // Does not throw an exception
            }
        }

        System.out.println(list); // Outputs: [One, Three]
    }
}
```

### 3. Diamond Problem

**Definition**: The diamond problem occurs in multiple inheritance scenarios when a class inherits from two classes that have a common superclass. This can lead to ambiguity in method resolution.

**Example**:

```java
interface A {
    default void show() {
        System.out.println("A's show");
    }
}

interface B extends A {
    default void show() {
        System.out.println("B's show");
    }
}

interface C extends A {
    default void show() {
        System.out.println("C's show");
    }
}

class D implements B, C {
    public void show() {
        B.super.show(); // Resolving ambiguity
    }
}

public class DiamondProblemExample {
    public static void main(String[] args) {
        D obj = new D();
        obj.show(); // Outputs: B's show
    }
}
```

### 4. Deadlock and Prevention

**Deadlock**: A situation where two or more threads are blocked forever, waiting for each other to release resources.

**Example of Deadlock**:

```java
class Resource {
    public synchronized void lockResource(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " locked " + this);
        resource.lockResource(this);
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        Thread t1 = new Thread(() -> resource1.lockResource(resource2));
        Thread t2 = new Thread(() -> resource2.lockResource(resource1));

        t1.start();
        t2.start();
    }
}
```

**Prevention Techniques**:
1. **Lock Ordering**: Always acquire locks in a specific order.
2. **Timeouts**: Use a timeout when trying to acquire a lock.
3. **Deadlock Detection**: Regularly check for deadlocks and recover.

### 5. Semaphore Snapshot

**Definition**: A semaphore is a synchronization primitive that restricts access to shared resources by maintaining a set number of permits. It can be used to control access to a resource pool.

**Example**:

```java
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " acquired a permit.");
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " released a permit.");
                    semaphore.release();
                }
            }).start();
        }
    }
}
```

### Summary

- **Race Condition**: Occurs when multiple threads modify shared data simultaneously, leading to unpredictable results.
- **Fail-Fast**: Immediately detects and reports inconsistencies; Fail-Safe: Continues operation despite errors.
- **Diamond Problem**: Ambiguity in multiple inheritance, resolved using specific interface methods.
- **Deadlock**: Threads waiting indefinitely for resources; prevention involves ordering and timeouts.
- **Semaphore**: Manages access to a limited number of resources, allowing concurrent processing. 

The `java.util.concurrent` package in Java provides a framework for managing concurrent programming, offering a set of classes and interfaces that simplify the development of multi-threaded applications. Here's a detailed breakdown of its core components:

### Key Components of `java.util.concurrent`

1. **Concurrency Utilities**: 
   - Provides utilities for managing and controlling concurrent operations.

2. **Executor Framework**:
   - Simplifies thread management and task execution.

3. **Synchronization Constructs**:
   - Tools for managing shared resources and ensuring thread safety.

4. **Concurrent Collections**:
   - Thread-safe variants of standard Java collections.

5. **Locks**:
   - More flexible locking mechanisms than synchronized blocks.

6. **Atomic Variables**:
   - Classes that provide lock-free thread-safe operations on single variables.

7. **Barriers, Latches, and Semaphores**:
   - Synchronization aids for controlling the execution flow of threads.

### Detailed Breakdown

#### 1. Executor Framework

The Executor framework abstracts the details of thread creation and management. It includes:

- **Executor Interface**: 
  - The basic interface for task execution.

- **ExecutorService Interface**:
  - Extends Executor, providing methods for managing lifecycle and task execution.

- **ThreadPoolExecutor**:
  - A powerful implementation that executes tasks using a pool of threads.

- **ScheduledExecutorService**:
  - An interface for scheduling tasks at a fixed rate or with a delay.

**Example**:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running.");
            });
        }
        
        executor.shutdown();
    }
}
```

#### 2. Synchronization Constructs

- **CountDownLatch**: 
  - A synchronization aid that allows one or more threads to wait until a set of operations completes.

- **CyclicBarrier**: 
  - Allows a set of threads to all wait for each other to reach a common barrier point.

- **Semaphore**: 
  - Controls access to a shared resource through counting.

**Example of CountDownLatch**:

```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("Task completed.");
                latch.countDown();
            }).start();
        }

        latch.await(); // Wait for all tasks to complete
        System.out.println("All tasks are completed.");
    }
}
```

#### 3. Concurrent Collections

The `java.util.concurrent` package provides thread-safe collections, including:

- **ConcurrentHashMap**: 
  - A hash table that allows concurrent access and updates.

- **CopyOnWriteArrayList**: 
  - A thread-safe variant of `ArrayList` that creates a new copy on each write operation.

- **BlockingQueue Interface**:
  - Provides a thread-safe queue with blocking operations (e.g., `ArrayBlockingQueue`, `LinkedBlockingQueue`).

**Example of ConcurrentHashMap**:

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
```

#### 4. Locks

- **ReentrantLock**: 
  - A versatile and powerful lock that provides advanced locking capabilities.

- **ReadWriteLock**: 
  - Allows multiple readers or one writer to access a resource.

**Example of ReentrantLock**:

```java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            System.out.println("Critical section");
        } finally {
            lock.unlock();
        }
    }
}
```

#### 5. Atomic Variables

Atomic classes provide a way to perform atomic operations on single variables without using synchronization.

- **AtomicInteger**, **AtomicLong**, **AtomicReference**:
  - These classes provide methods like `get()`, `set()`, and `incrementAndGet()`.

**Example**:

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        
        System.out.println("Initial Count: " + count.get());
        count.incrementAndGet();
        System.out.println("Count after increment: " + count.get());
    }
}
```

### Conclusion

The `java.util.concurrent` package provides a robust framework for building concurrent applications in Java. Its components, like the Executor framework, concurrent collections, synchronization aids, locks, and atomic variables, greatly simplify the complexity of managing multi-threaded environments. Understanding and effectively utilizing these tools can lead to better performance, improved resource management, and reduced potential for concurrency-related bugs.
This overview should give you a solid understanding of these concurrency concepts in Java!

</details>
<details><summary><b>Collectors</b></summary>

The `collect` method in Java's Stream API is used to accumulate the elements of a stream into a desired form, such as a collection or a single value. It takes a `Collector` as an argument, which defines the strategy for accumulating the elements. Here’s a detailed look at different ways to use the `collect` method, with examples and purposes for each approach:

### 1. **`toList()`**

**Purpose:** Collects the elements of the stream into a `List`.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToListExample {
    public static void main(String[] args) {
        List<String> list = Stream.of("apple", "banana", "cherry")
                                  .collect(Collectors.toList());
        System.out.println(list); // Output: [apple, banana, cherry]
    }
}
```

**Purpose:** Useful when you need a list of elements from a stream, often for further processing or iteration.

### 2. **`toSet()`**

**Purpose:** Collects the elements of the stream into a `Set`.

**Example:**

```java
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToSetExample {
    public static void main(String[] args) {
        Set<String> set = Stream.of("apple", "banana", "apple", "cherry")
                                .collect(Collectors.toSet());
        System.out.println(set); // Output: [banana, cherry, apple] (Order may vary)
    }
}
```

**Purpose:** Useful when you want to eliminate duplicate elements and ensure uniqueness.

### 3. **`toMap()`**

**Purpose:** Collects the elements of the stream into a `Map`. You need to provide two functions: one for the key and one for the value.

**Example:**

```java
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = Stream.of("apple", "banana", "cherry")
                                         .collect(Collectors.toMap(String::length, s -> s));
        System.out.println(map); // Output: {5=apple, 6=banana, 6=cherry}
    }
}
```

**Purpose:** Useful when you want to organize elements into key-value pairs. Ensure that keys are unique or handle key collisions.

### 4. **`joining()`**

**Purpose:** Concatenates the elements of the stream into a single `String`. You can specify a delimiter, a prefix, and a suffix.

**Example:**

```java
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample {
    public static void main(String[] args) {
        String result = Stream.of("apple", "banana", "cherry")
                              .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result); // Output: [apple, banana, cherry]
    }
}
```

**Purpose:** Useful for creating a single string from a collection of strings, with custom delimiters and/or surrounding characters.

### 5. **`groupingBy()`**

**Purpose:** Groups the elements of the stream by a classifier function and returns a `Map` where the keys are the result of applying the classifier function, and the values are lists of items.

**Example:**

```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByExample {
    public static void main(String[] args) {
        Map<Integer, List<String>> groupedByLength = Stream.of("apple", "banana", "cherry", "date")
                                                            .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength); // Output: {4=[date], 5=[apple], 6=[banana, cherry]}
    }
}
```

**Purpose:** Useful for grouping elements based on some criteria, such as length or category.

### 6. **`partitioningBy()`**

**Purpose:** Partitions the elements of the stream into two groups based on a predicate, and returns a `Map` with Boolean keys.

**Example:**

```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByExample {
    public static void main(String[] args) {
        Map<Boolean, List<String>> partitioned = Stream.of("apple", "banana", "cherry", "date")
                                                        .collect(Collectors.partitioningBy(s -> s.length() > 5));
        System.out.println(partitioned); // Output: {false=[apple, date], true=[banana, cherry]}
    }
}
```

**Purpose:** Useful for splitting data into two categories based on a condition, such as passing or failing a test.

### 7. **`counting()`**

**Purpose:** Counts the number of elements in the stream.

**Example:**

```java
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingExample {
    public static void main(String[] args) {
        long count = Stream.of("apple", "banana", "cherry", "date")
                           .collect(Collectors.counting());
        System.out.println(count); // Output: 4
    }
}
```

**Purpose:** Useful for counting the number of elements in a stream.

### 8. **`summarizingInt()`, `summarizingDouble()`, `summarizingLong()`**

**Purpose:** Collects statistics such as count, sum, min, average, and max for a numeric type.

**Example:**

```java
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummarizingExample {
    public static void main(String[] args) {
        IntSummaryStatistics stats = Stream.of("apple", "banana", "cherry", "date")
                                           .collect(Collectors.summarizingInt(String::length));
        System.out.println(stats); // Output: IntSummaryStatistics{count=4, sum=19, min=4, average=4.750000, max=6}
    }
}
```

**Purpose:** Useful for gathering aggregate statistics on numeric data.

### 9. **`reducing()`**

**Purpose:** Performs a reduction on the elements of the stream using an associative accumulation function and returns an `Optional`.

**Example:**

```java
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducingExample {
    public static void main(String[] args) {
        Optional<String> concatenated = Stream.of("apple", "banana", "cherry", "date")
                                              .collect(Collectors.reducing((s1, s2) -> s1 + s2));
        System.out.println(concatenated.get()); // Output: applebananacherrydate
    }
}
```

**Purpose:** Useful for combining elements into a single result, such as concatenating strings or summing numbers.

### 10. **`mapping()`**

**Purpose:** Applies a mapping function to each element of the stream and collects the results.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingExample {
    public static void main(String[] args) {
        List<Integer> lengths = Stream.of("apple", "banana", "cherry", "date")
                                      .collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println(lengths); // Output: [5, 6, 6, 4]
    }
}
```

**Purpose:** Useful for transforming the elements before collecting them into a result.

### 11. **`flatMapping()`**

**Purpose:** Applies a mapping function that returns a stream of values and flattens the resulting streams into a single stream.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<Character> characters = Stream.of("apple", "banana", "cherry")
                                           .collect(Collectors.flatMapping(s -> s.chars().mapToObj(c -> (char) c), Collectors.toList()));
        System.out.println(characters); // Output: [a, p, p, l, e, b, a, n, a, n, a, c, h, e, r, r, y]
    }
}
```

**Purpose:** Useful for dealing with streams of streams (nested collections) and merging them into a single stream.

### 12. **`collectingAndThen()`**

**Purpose:** Applies a finishing transformation to the result of the collection process.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingAndThenExample {
    public static void main(String[] args) {
        List<String> result = Stream.of("apple", "banana", "cherry")
                                    .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                                        list.add("date");
                                        return list;
                                    }));
        System.out.println(result); // Output: [apple, banana, cherry, date]
    }
}
```

**Purpose:** Useful for performing additional operations on the collected result, such as adding elements or performing final transformations.

### Summary

The `collect` method is a powerful tool in Java's Stream API for accumulating elements into various forms. Each `Collector` provides a different way to process and gather data, allowing for flexible and expressive data manipulation. Understanding these collectors and their purposes enables you to perform complex data transformations and aggregations effectively.

The `Collectors` class in Java is part of the `java.util.stream` package and provides a set of static methods that are used to create various types of `Collector` implementations. These collectors are used to accumulate elements of a stream into different forms, such as lists, sets, maps, or concatenated strings. Here’s an in-depth explanation of various `Collectors` methods, their purpose, and examples of how to use them.

### 1. `toList()`

**Purpose:** Collects the elements of a stream into a `List`.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToListExample {
    public static void main(String[] args) {
        List<String> list = Stream.of("a", "b", "c", "d")
                                  .collect(Collectors.toList());
        System.out.println(list); // Output: [a, b, c, d]
    }
}
```

### 2. `toSet()`

**Purpose:** Collects the elements of a stream into a `Set`.

**Example:**

```java
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToSetExample {
    public static void main(String[] args) {
        Set<String> set = Stream.of("a", "b", "c", "a")
                                .collect(Collectors.toSet());
        System.out.println(set); // Output: [a, b, c] (Order may vary)
    }
}
```

### 3. `toMap()`

**Purpose:** Collects the elements of a stream into a `Map`. You need to provide two functions: one to determine the key and one for the value.

**Example:**

```java
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = Stream.of("a", "b", "c")
                                         .collect(Collectors.toMap(String::length, s -> s));
        System.out.println(map); // Output: {1=a, 2=b, 3=c}
    }
}
```

### 4. `joining()`

**Purpose:** Concatenates the elements of a stream into a single `String`. You can also specify a delimiter, a prefix, and a suffix.

**Example:**

```java
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample {
    public static void main(String[] args) {
        String result = Stream.of("a", "b", "c")
                              .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result); // Output: [a, b, c]
    }
}
```

### 5. `groupingBy()`

**Purpose:** Groups the elements of a stream by a classifier function and returns a `Map` where the keys are the result of applying the classifier function, and the values are lists of items.

**Example:**

```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByExample {
    public static void main(String[] args) {
        Map<Integer, List<String>> groupedByLength = Stream.of("a", "bb", "ccc", "dd")
                                                            .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength); // Output: {1=[a], 2=[bb, dd], 3=[ccc]}
    }
}
```

### 6. `partitioningBy()`

**Purpose:** Partitions the elements of a stream into two groups based on a predicate and returns a `Map` with Boolean keys.

**Example:**

```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByExample {
    public static void main(String[] args) {
        Map<Boolean, List<String>> partitioned = Stream.of("a", "bb", "ccc", "dd")
                                                        .collect(Collectors.partitioningBy(s -> s.length() > 2));
        System.out.println(partitioned); // Output: {false=[a, bb, dd], true=[ccc]}
    }
}
```

### 7. `counting()`

**Purpose:** Counts the number of elements in the stream.

**Example:**

```java
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingExample {
    public static void main(String[] args) {
        long count = Stream.of("a", "b", "c", "d")
                           .collect(Collectors.counting());
        System.out.println(count); // Output: 4
    }
}
```

### 8. `summarizingInt()`, `summarizingDouble()`, `summarizingLong()`

**Purpose:** Collects statistics, such as count, sum, min, average, and max, for a particular numeric type.

**Example:**

```java
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummarizingExample {
    public static void main(String[] args) {
        IntSummaryStatistics stats = Stream.of("a", "bb", "ccc", "dddd")
                                           .collect(Collectors.summarizingInt(String::length));
        System.out.println(stats); // Output: IntSummaryStatistics{count=4, sum=10, min=1, average=2.500000, max=4}
    }
}
```

### 9. `reducing()`

**Purpose:** Performs a reduction on the elements of the stream using an associative accumulation function and returns an `Optional`.

**Example:**

```java
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducingExample {
    public static void main(String[] args) {
        Optional<String> concatenated = Stream.of("a", "b", "c", "d")
                                              .collect(Collectors.reducing((s1, s2) -> s1 + s2));
        System.out.println(concatenated.get()); // Output: abcd
    }
}
```

### 10. `mapping()`

**Purpose:** Applies a mapping function to each element of the stream and collects the results.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingExample {
    public static void main(String[] args) {
        List<Integer> lengths = Stream.of("a", "bb", "ccc", "dddd")
                                      .collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println(lengths); // Output: [1, 2, 3, 4]
    }
}
```

### 11. `flatMapping()`

**Purpose:** Applies a mapping function that returns a stream of values and flattens the resulting streams into a single stream.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<Character> characters = Stream.of("hello", "world")
                                           .collect(Collectors.flatMapping(s -> s.chars().mapToObj(c -> (char) c), Collectors.toList()));
        System.out.println(characters); // Output: [h, e, l, l, o, w, o, r, l, d]
    }
}
```

### 12. `collectingAndThen()`

**Purpose:** Applies a finishing transformation to the result of the collection process.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingAndThenExample {
    public static void main(String[] args) {
        List<String> result = Stream.of("a", "b", "c", "d")
                                    .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                                        list.add("e");
                                        return list;
                                    }));
        System.out.println(result); // Output: [a, b, c, d, e]
    }
}
```

### Summary

The `Collectors` class provides a wide range of methods to collect elements from streams into various forms, making it a powerful tool for working with data in Java. The choice of collector depends on the desired result, whether it’s aggregating data into a collection, calculating statistics, or performing transformations. Understanding these collectors and how to use them effectively can significantly improve the quality and efficiency of your data processing in Java.

</details>
<details><summary><b>Compartators</b></summary>

The `Comparator` interface in Java provides a way to compare two objects for ordering. It is used in various operations like sorting collections or streams. The `Comparator` interface has several default and static methods that are quite useful for different types of comparisons. Here's an overview of the methods available in `Comparator`, along with examples and explanations:

### 1. **`compare(T o1, T o2)`**

**Purpose:** Compares two objects for order. This is the primary method that needs to be implemented in custom comparators.

**Example:**

```java
import java.util.Comparator;

public class CompareExample {
    public static void main(String[] args) {
        Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();

        System.out.println(comparator.compare("apple", "banana")); // Output: -1 (apple is shorter than banana)
    }
}
```

**Purpose:** Determines the order of two objects based on custom logic, such as length, alphabetical order, etc.

### 2. **`reversed()`**

**Purpose:** Returns a comparator that imposes the reverse ordering of the original comparator.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ReversedExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        Comparator<String> reversedComparator = lengthComparator.reversed();

        list.sort(reversedComparator);
        System.out.println(list); // Output: [banana, cherry, apple]
    }
}
```

**Purpose:** Useful for sorting in descending order when you have a comparator for ascending order.

### 3. **`thenComparing(Comparator<? super T> other)`**

**Purpose:** Combines two comparators. It first compares using the current comparator, and if the result is zero, it uses the other comparator.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ThenComparingExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");

        Comparator<String> byLength = Comparator.comparingInt(String::length);
        Comparator<String> byAlphabet = Comparator.comparing(String::toString);

        list.sort(byLength.thenComparing(byAlphabet));
        System.out.println(list); // Output: [apple, apricot, banana, cherry]
    }
}
```

**Purpose:** Useful when you need to sort by one criterion and then by another if the first criteria are equal.

### 4. **`thenComparingInt(ToIntFunction<? super T> keyExtractor)`**

**Purpose:** Creates a comparator that first compares using the current comparator, and if the result is zero, compares using an `Int` key extracted from the objects.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ThenComparingIntExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");

        Comparator<String> byLength = Comparator.comparingInt(String::length);
        Comparator<String> byAsciiSum = Comparator.comparingInt(s -> s.chars().sum());

        list.sort(byLength.thenComparingInt(byAsciiSum));
        System.out.println(list); // Output: [apple, apricot, banana, cherry]
    }
}
```

**Purpose:** Useful for sorting primarily by length and secondarily by an integer property.

### 5. **`thenComparingLong(ToLongFunction<? super T> keyExtractor)`**

**Purpose:** Similar to `thenComparingInt`, but for `long` values.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ThenComparingLongExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");

        Comparator<String> byLength = Comparator.comparingInt(String::length);
        Comparator<String> byAsciiProduct = Comparator.comparingLong(s -> s.chars().asLongStream().reduce(1, (a, b) -> a * b));

        list.sort(byLength.thenComparingLong(byAsciiProduct));
        System.out.println(list); // Output: [apple, apricot, banana, cherry]
    }
}
```

**Purpose:** Useful for sorting primarily by length and secondarily by a long property.

### 6. **`thenComparingDouble(ToDoubleFunction<? super T> keyExtractor)`**

**Purpose:** Similar to `thenComparingInt`, but for `double` values.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ThenComparingDoubleExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");

        Comparator<String> byLength = Comparator.comparingInt(String::length);
        Comparator<String> byAverageAscii = Comparator.comparingDouble(s -> s.chars().average().orElse(0));

        list.sort(byLength.thenComparingDouble(byAverageAscii));
        System.out.println(list); // Output: [apple, apricot, banana, cherry]
    }
}
```

**Purpose:** Useful for sorting primarily by length and secondarily by a double property.

### 7. **`naturalOrder()`**

**Purpose:** Returns a comparator that compares objects in their natural order.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class NaturalOrderExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");

        list.sort(Comparator.naturalOrder());
        System.out.println(list); // Output: [apple, apricot, banana, cherry]
    }
}
```

**Purpose:** Useful for sorting elements in their natural order, such as alphabetical order for strings.

### 8. **`reverseOrder()`**

**Purpose:** Returns a comparator that imposes the reverse of the natural order.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ReverseOrderExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");

        list.sort(Comparator.reverseOrder());
        System.out.println(list); // Output: [cherry, banana, apricot, apple]
    }
}
```

**Purpose:** Useful for sorting elements in reverse natural order.

### 9. **`comparing(Function<? super T, ? extends U> keyExtractor)`**

**Purpose:** Creates a comparator that compares objects based on a function that extracts a key.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ComparingFunctionExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");

        Comparator<String> byLength = Comparator.comparing(String::length);
        list.sort(byLength);
        System.out.println(list); // Output: [apple, date, banana, cherry]
    }
}
```

**Purpose:** Useful for creating comparators based on a specific property of the objects.

### 10. **`comparingInt(ToIntFunction<? super T> keyExtractor)`**

**Purpose:** Creates a comparator that compares objects based on an integer key.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ComparingIntExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");

        Comparator<String> byLength = Comparator.comparingInt(String::length);
        list.sort(byLength);
        System.out.println(list); // Output: [date, apple, banana, cherry]
    }
}
```

**Purpose:** Useful for comparing objects based on an integer property.

### 11. **`comparingLong(ToLongFunction<? super T> keyExtractor)`**

**Purpose:** Creates a comparator that compares objects based on a long key.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ComparingLongExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");

        Comparator<String> byAsciiSum = Comparator.comparingLong(s -> s.chars().asLongStream().sum());
        list.sort(byAsciiSum);
        System.out.println(list); // Output: [date, apple, banana, cherry]
    }
}
```

**Purpose:** Useful for comparing objects based on a long property.

### 12. **`comparingDouble(ToDoubleFunction<? super T> keyExtractor)`**

**Purpose:** Creates a comparator that compares objects based on a double key.

**Example:**

```java
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class ComparingDoubleExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");

        Comparator<String> byAverageAscii = Comparator.comparingDouble(s -> s.chars().average().orElse(0));
        list

.sort(byAverageAscii);
        System.out.println(list); // Output: [date, apple, banana, cherry]
    }
}
```

**Purpose:** Useful for comparing objects based on a double property.

### Summary

The `Comparator` interface is a powerful tool for defining custom ordering for objects. It provides a variety of methods to create, reverse, chain, and transform comparators, making it flexible for sorting and comparing objects in various ways. Each method has specific use cases, allowing for fine-grained control over sorting behavior in collections and streams.

</details>
<details><summary><b>Important Features</b></summary>

</details>
