# Popular Functions of Java Stream

## filter
`filter` removes elements that do not satisfy the predicate filter condition, retaining elements that do.

```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class CafeincodeExample {
    public static void main(String[] args) {
        var domains = Arrays.asList("cafeincode", "medium", "google");
        var filtered = domains.stream()
                .filter(item -> item.startsWith("c"))
                .peek(item -> System.out.println("Result: " + item))
                .collect(Collectors.toList());
    }
}
```
**Result:** `cafeincode`
### Stream `map` Methods

The `map` method is used to transform each element of the stream into another form. There are two primary variations:

1. **`map(Function<? super T, ? extends R> mapper)`**

   This method applies a function to each element of the stream, producing a new stream of transformed elements.

   **Example:**
   ```java
   import java.util.Arrays;
   import java.util.List;
   import java.util.stream.Collectors;

   public class MapExample {
       public static void main(String[] args) {
           List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

           // Convert each name to uppercase
           List<String> uppercaseNames = names.stream()
               .map(String::toUpperCase)
               .collect(Collectors.toList());

           System.out.println(uppercaseNames); // Output: [ALICE, BOB, CHARLIE]
       }
   }
   ```

2. **`flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`**

   This method transforms each element into a stream and then flattens the results into a single stream.

   **Example:**
   ```java
   import java.util.Arrays;
   import java.util.List;
   import java.util.stream.Collectors;

   public class FlatMapExample {
       public static void main(String[] args) {
           List<List<String>> listOfLists = Arrays.asList(
               Arrays.asList("a", "b"),
               Arrays.asList("c", "d"),
               Arrays.asList("e", "f")
           );

           // Flatten the list of lists into a single list
           List<String> flatList = listOfLists.stream()
               .flatMap(List::stream)
               .collect(Collectors.toList());

           System.out.println(flatList); // Output: [a, b, c, d, e, f]
       }
   }
   ```
When using the `map` function in Java Streams, it's essential to understand how to handle conditions and transformations effectively. The `map` function itself is used for applying a transformation function to each element in the stream. However, conditions can be managed inside the transformation function or combined with other stream operations.

### **Using Conditions Inside `map`**

While the `map` function does not directly handle conditions or filtering, you can incorporate conditions within the transformation function to achieve desired outcomes.

Here are some ways to incorporate conditions inside the `map` function:

#### 1. **Simple Conditional Logic**

You can use conditional logic within the `map` function to transform elements based on some condition.

**Example**: Transform a list of integers by squaring even numbers and keeping odd numbers unchanged.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> transformed = numbers.stream()
    .map(n -> n % 2 == 0 ? n * n : n)  // Square even numbers; keep odd numbers unchanged
    .collect(Collectors.toList());

System.out.println(transformed);  // Output: [1, 4, 3, 16, 5]
```

#### 2. **Complex Transformations Based on Conditions**

You can perform more complex transformations using multiple conditions inside the `map` function.

**Example**: Convert a list of strings to a specific format based on their length.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");

List<String> formattedNames = names.stream()
    .map(name -> {
        if (name.length() <= 3) {
            return name.toUpperCase();
        } else if (name.length() <= 6) {
            return name.toLowerCase();
        } else {
            return name;  // No change
        }
    })
    .collect(Collectors.toList());

System.out.println(formattedNames);  // Output: [ALICE, bob, charlie, Diana]
```

#### 3. **Combining `map` with `filter`**

Often, you combine `map` with `filter` to first filter elements based on conditions and then apply transformations.

**Example**: Convert only even numbers to their squares and keep odd numbers unchanged.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> transformed = numbers.stream()
    .filter(n -> n % 2 == 0)  // Filter even numbers
    .map(n -> n * n)  // Square the even numbers
    .collect(Collectors.toList());

System.out.println(transformed);  // Output: [4, 16]
```

#### 4. **Using Method References for Conditional Logic**

You can use method references in combination with conditions if the logic is encapsulated in a method.

**Example**: Using a static method to determine if a number is even and apply a transformation accordingly.

```java
public class NumberUtils {
    public static int transform(int number) {
        return number % 2 == 0 ? number * number : number;
    }
}

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> transformed = numbers.stream()
    .map(NumberUtils::transform)  // Apply transformation based on the condition inside the method
    .collect(Collectors.toList());

System.out.println(transformed);  // Output: [1, 4, 3, 16, 5]
```

### **Best Practices**

1. **Keep Logic Simple**:
   - While you can include conditional logic inside `map`, try to keep it as simple and readable as possible. Complex logic might be better handled in separate methods.

2. **Avoid Side Effects**:
   - Ensure that the conditional logic inside `map` does not produce side effects or alter external state.

3. **Combine with Other Operations**:
   - For more complex processing, combine `map` with `filter` and other intermediate operations to create a clear and efficient processing pipeline.

4. **Performance Considerations**:
   - Be mindful of performance, especially with complex transformations. Stream operations are lazy, but excessive complexity inside `map` can impact performance.

In summary, while the `map` function is designed for transforming elements, you can incorporate conditions within its transformation logic. For more structured or complex conditional transformations, consider combining `map` with other stream operations like `filter` or using method references for clarity and reusability.

### `Stream.map()` Function in Java

The `map` function is a fundamental intermediate operation in the Java Stream API. It is used to transform the elements of a stream into a new form.

#### **Definition**

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```

- **Generic Type Parameters**:
  - `T`: The type of elements in the original stream.
  - `R`: The type of elements in the resulting stream.

- **Parameters**:
  - `mapper`: A function that takes an element of type `T` and transforms it into an element of type `R`.

- **Returns**:
  - A new `Stream<R>` consisting of the transformed elements.

#### **Properties**

1. **Intermediate Operation**:
   - `map` is an intermediate operation, which means it returns a new stream and does not modify the original stream. It allows for the creation of a pipeline of operations.

2. **Lazy Evaluation**:
   - The `map` operation is lazy, meaning it does not perform any actual processing until a terminal operation is invoked. This allows for optimizations and efficient processing.

3. **Stateless**:
   - The `map` function does not depend on the state of the stream or any external state. It purely applies the transformation function to each element.

4. **Order Preservation**:
   - The `map` operation preserves the order of elements in the stream. If the original stream is ordered, the resulting stream will also be ordered.

5. **Non-Destructive**:
   - It does not modify the elements of the original stream but rather produces a new stream with transformed elements.

#### **Uses**

1. **Data Transformation**:
   - Use `map` to transform elements of a stream. For example, converting a list of strings to uppercase or extracting specific fields from objects.

   **Example**:
   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   List<String> upperCaseNames = names.stream()
                                      .map(String::toUpperCase)
                                      .collect(Collectors.toList());
   // Result: ["ALICE", "BOB", "CHARLIE"]
   ```

2. **Object Projection**:
   - Project or convert elements from one type to another. For example, extracting specific properties from objects.

   **Example**:
   ```java
   List<Employee> employees = Arrays.asList(
       new Employee(1, "Alice", 50000),
       new Employee(2, "Bob", 60000)
   );
   List<String> names = employees.stream()
                                 .map(Employee::getName)
                                 .collect(Collectors.toList());
   // Result: ["Alice", "Bob"]
   ```

3. **Complex Transformations**:
   - Perform more complex transformations by using lambda expressions or method references.

   **Example**:
   ```java
   List<String> sentences = Arrays.asList("hello world", "java streams");
   List<Integer> wordCounts = sentences.stream()
                                       .map(sentence -> sentence.split(" ").length)
                                       .collect(Collectors.toList());
   // Result: [2, 2]
   ```

4. **Data Conversion**:
   - Convert data from one representation to another, such as converting strings to integers or dates.

   **Example**:
   ```java
   List<String> numberStrings = Arrays.asList("1", "2", "3");
   List<Integer> numbers = numberStrings.stream()
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
   // Result: [1, 2, 3]
   ```

#### **Examples of `map` in Action**

1. **Basic Transformation**:
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
   List<Integer> squaredNumbers = numbers.stream()
                                          .map(n -> n * n)
                                          .collect(Collectors.toList());
   // Result: [1, 4, 9, 16]
   ```

2. **Extracting Fields**:
   ```java
   class Person {
       String name;
       int age;

       // Constructor, getters, setters
   }

   List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25));
   List<String> names = people.stream()
                              .map(Person::getName)
                              .collect(Collectors.toList());
   // Result: ["Alice", "Bob"]
   ```

3. **Mapping to Complex Objects**:
   ```java
   List<String> numbers = Arrays.asList("1", "2", "3");
   List<NumberWrapper> wrappers = numbers.stream()
                                         .map(NumberWrapper::new)
                                         .collect(Collectors.toList());
   // Result: List of NumberWrapper objects
   ```

#### **Common Mistakes**

1. **Assuming Mutability**:
   - `map` does not modify the original elements. Ensure the transformation logic is stateless and does not alter the original objects.

2. **Incompatible Types**:
   - Ensure the transformation function correctly converts between types, especially when using `map` with different data types.

In summary, the `map` function is a powerful tool for transforming and projecting data in streams. It supports a variety of transformations and is fundamental for processing data in a functional style using Java Streams.

## map
`map` is responsible for mapping each element in the stream to another data type through a specified function.

```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class CafeincodeExample {
    public static void main(String[] args) {
        var input = Arrays.asList("cafeincode", "medium", "google");
        var mapped = input.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Result: " + mapped);
    }
}
```
**Result:** `[CAFEINCODE, MEDIUM, GOOGLE]`

## flatMap
`flatMap` is used to process the elements of a stream and transform them into a new stream or a list of elements.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CafeincodeExample {
    public static void main(String[] args) {
        var nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        var flattenedNumbers = nestedNumbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Result: " + flattenedNumbers);
    }
}
```
**Result:** `[1, 2, 3, 4, 5, 6]`

## distinct
`distinct` removes duplicate elements from a stream.

```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class CafeincodeExample {
    public static void main(String[] args) {
        var numbers = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5);
        var distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Result: " + distinctNumbers);
    }
}
```
**Result:** `[1, 2, 3, 4, 5]`

## sorted
`sorted` sorts the elements of a stream.

```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class CafeincodeExample {
    public static void main(String[] args) {
        var numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        var sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Result: " + sortedNumbers);
    }
}
```
**Result:** `[1, 1, 2, 3, 4, 5, 5, 6, 9]`

## peek
`peek` is often used for debugging or logging operations on elements during stream processing.

```java
import java.util.stream.IntStream;

public class CafeincodeExample {
    public static void main(String[] args) {
        IntStream.range(1, 6)
                .peek(element -> System.out.println("Processing element: " + element))
                .map(CafeincodeExample::mapping)
                .forEach(System.out::println);
    }

    private static Integer mapping(Integer input) {
        return input * input;
    }
}
```
**Output:**
```
Processing element: 1
1
Processing element: 2
4
Processing element: 3
9
Processing element: 4
16
Processing element: 5
25
```

## limit
`limit` restricts the number of elements in a stream.

```java
import java.util.stream.IntStream;

public class CafeincodeExample {
    public static void main(String[] args) {
        IntStream.range(1, 100)
                .limit(5)
                .forEach(System.out::println);
    }
}
```
**Output:**
```
1
2
3
4
5
```

## skip
`skip` skips a certain number of elements in a stream.

```java
import java.util.stream.IntStream;

public class CafeincodeExample {
    public static void main(String[] args) {
        IntStream.range(1, 11)
                .skip(5)
                .forEach(System.out::println);
    }
}
```
**Output:**
```
6
7
8
9
10
```

## toArray
`toArray` converts a stream into an array.

```java
import java.util.stream.IntStream;

public class CafeincodeExample {
    public static void main(String[] args) {
        int[] numbers = IntStream.range(1, 6)
                .toArray();

        for (int number : numbers) {
            System.out.println("Result: " + number);
        }
    }
}
```
**Output:**
```
Result: 1
Result: 2
Result: 3
Result: 4
Result: 5
```

## reduce
`reduce` performs a transformation on the elements of the stream to calculate a final value.

```java
import java.util.Arrays;

public class CafeincodeExample {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var result = Arrays.stream(integers).reduce(0, Integer::sum);
        System.out.println("Result: " + result);
    }
}
```
**Result:** `55`

### Stream `collect` Methods

The `collect` method is a terminal operation that transforms the elements of a stream into a different form, typically a collection or a summary result. Here are some common `collect` methods:

1. **`collect(Collector<? super T, A, R> collector)`**

   This method performs a reduction operation on the elements of the stream using a `Collector`.

   **Examples:**

   - **`Collectors.toList()`**: Collects the elements into a `List`.

     ```java
     import java.util.Arrays;
     import java.util.List;
     import java.util.stream.Collectors;

     public class CollectToListExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

             List<String> collectedList = names.stream()
                 .collect(Collectors.toList());

             System.out.println(collectedList); // Output: [Alice, Bob, Charlie]
         }
     }
     ```

   - **`Collectors.toSet()`**: Collects the elements into a `Set`.

     ```java
     import java.util.Arrays;
     import java.util.Set;
     import java.util.stream.Collectors;

     public class CollectToSetExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Alice");

             Set<String> collectedSet = names.stream()
                 .collect(Collectors.toSet());

             System.out.println(collectedSet); // Output: [Alice, Bob]
         }
     }
     ```

   - **`Collectors.toMap`**: Collects the elements into a `Map`.

     ```java
     import java.util.Arrays;
     import java.util.Map;
     import java.util.function.Function;
     import java.util.stream.Collectors;

     public class CollectToMapExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

             Map<String, Integer> nameLengthMap = names.stream()
                 .collect(Collectors.toMap(
                     Function.identity(), // Key is the name itself
                     String::length        // Value is the length of the name
                 ));

             System.out.println(nameLengthMap); // Output: {Alice=5, Bob=3, Charlie=7}
         }
     }
     ```

   - **`Collectors.joining(CharSequence delimiter)`**: Concatenates the elements into a single `String` with a specified delimiter.

     ```java
     import java.util.Arrays;
     import java.util.List;
     import java.util.stream.Collectors;

     public class CollectJoiningExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

             String joinedNames = names.stream()
                 .collect(Collectors.joining(", "));

             System.out.println(joinedNames); // Output: Alice, Bob, Charlie
         }
     }
     ```

   - **`Collectors.groupingBy(Function<? super T, ? extends K>)`**: Groups the elements by a classifier function.

     ```java
     import java.util.Arrays;
     import java.util.List;
     import java.util.Map;
     import java.util.stream.Collectors;

     public class CollectGroupingByExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

             Map<Integer, List<String>> namesByLength = names.stream()
                 .collect(Collectors.groupingBy(String::length));

             System.out.println(namesByLength); // Output: {3=[Bob], 5=[Alice], 7=[Charlie], 4=[David]}
         }
     }
     ```

   - **`Collectors.partitioningBy(Predicate<? super T>)`**: Partitions the elements into two groups based on a predicate.

     ```java
     import java.util.Arrays;
     import java.util.List;
     import java.util.Map;
     import java.util.stream.Collectors;

     public class CollectPartitioningByExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

             Map<Boolean, List<String>> partitionedNames = names.stream()
                 .collect(Collectors.partitioningBy(name -> name.length() > 4));

             System.out.println(partitionedNames);
             // Output: {false=[Bob, David], true=[Alice, Charlie]}
         }
     }
     ```

   - **`Collectors.counting()`**: Counts the number of elements.

     ```java
     import java.util.Arrays;
     import java.util.List;
     import java.util.stream.Collectors;

     public class CollectCountingExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

             long count = names.stream()
                 .collect(Collectors.counting());

             System.out.println(count); // Output: 3
         }
     }
     ```

   - **`Collectors.summingInt(ToIntFunction<? super T>)`**: Sums the integer values of the elements.

     ```java
     import java.util.Arrays;
     import java.util.List;
     import java.util.stream.Collectors;

     public class CollectSummingIntExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

             int totalLength = names.stream()
                 .collect(Collectors.summingInt(String::length));

             System.out.println(totalLength); // Output: 15
         }
     }
     ```

   - **`Collectors.averagingDouble(ToDoubleFunction<? super T>)`**: Calculates the average of the double values of the elements.

     ```java
     import java.util.Arrays;
     import java.util.List;
     import java.util.stream.Collectors;

     public class CollectAveragingDoubleExample {
         public static void main(String[] args) {
             List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

             double averageLength = names.stream()
                 .collect(Collectors.averagingDouble(String::length));

             System.out.println(averageLength); // Output: 5.0
         }
     }
     ```

### Summary

- **`map`**:
  - `map(Function<? super T, ? extends R> mapper)`: Transforms elements.
  - `flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`: Transforms elements into a stream and flattens.

- **`collect`**:
  - `collect(Collector<? super T, A, R> collector)`: Collects results into a form like `List`, `Set`, `Map`, etc.
  - Common collectors include `toList`, `toSet`, `toMap`, `joining`, `groupingBy`, `partitioningBy`, `counting`, `summarizingInt`, `averagingDouble`, etc.
 
In Java Streams, the `collect` operation is a terminal operation that transforms the elements of a stream into a different form, typically a collection or a summary result. The `collect` method is highly versatile and is used to accumulate elements of a stream into various data structures or summary results.

### **Overview of `Stream.collect`**

**Definition**:
```java
<R, A> R collect(Collector<? super T, A, R> collector);
```

- **Generic Type Parameters**:
  - `T`: The type of elements in the stream.
  - `A`: The type of the intermediate accumulation result.
  - `R`: The type of the result of the collection.

- **Parameters**:
  - `collector`: A `Collector` that defines the accumulation strategy. It describes how to accumulate elements into a result.

- **Returns**:
  - The result of the collection operation, typically a collection or summary result.

### **Types of Collectors**

Java provides several built-in `Collector` implementations in the `Collectors` utility class, which cover common scenarios. Below are the main types of collectors and their uses:

#### 1. **To Collection Collectors**

- **`toList()`**
  - **Description**: Collects the elements into a `List`.
  - **Example**:
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    List<String> result = names.stream().collect(Collectors.toList());
    // Result: [Alice, Bob, Charlie]
    ```

- **`toSet()`**
  - **Description**: Collects the elements into a `Set`.
  - **Example**:
    ```java
    Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
    // Result: [Alice, Bob, Charlie] (order may vary)
    ```

- **`toMap`**
  - **Description**: Collects the elements into a `Map` using a key and value function.
  - **Example**:
    ```java
    Map<Integer, String> nameMap = names.stream()
        .collect(Collectors.toMap(String::length, Function.identity()));
    // Result: {5=Alice, 3=Bob, 7=Charlie}
    ```

#### 2. **Summary Statistics Collectors**

- **`counting()`**
  - **Description**: Counts the number of elements.
  - **Example**:
    ```java
    long count = names.stream().collect(Collectors.counting());
    // Result: 3
    ```

- **`summarizingInt`**
  - **Description**: Collects statistics (count, sum, min, average, max) for integers.
  - **Example**:
    ```java
    IntSummaryStatistics stats = names.stream()
        .mapToInt(String::length)
        .collect(Collectors.summarizingInt(length -> length));
    // Result: IntSummaryStatistics{count=3, sum=14, min=3, average=4.666667, max=7}
    ```

- **`summarizingDouble`**
  - **Description**: Collects statistics for doubles.
  - **Example**:
    ```java
    DoubleSummaryStatistics stats = names.stream()
        .mapToDouble(String::length)
        .collect(Collectors.summarizingDouble(length -> length));
    // Result: DoubleSummaryStatistics{count=3, sum=14.0, min=3.0, average=4.666667, max=7.0}
    ```

- **`summarizingLong`**
  - **Description**: Collects statistics for longs.
  - **Example**:
    ```java
    LongSummaryStatistics stats = names.stream()
        .mapToLong(String::length)
        .collect(Collectors.summarizingLong(length -> length));
    // Result: LongSummaryStatistics{count=3, sum=14, min=3, average=4.666667, max=7}
    ```

#### 3. **Joining Strings**

- **`joining()`**
  - **Description**: Concatenates the elements into a single `String`.
  - **Example**:
    ```java
    String joined = names.stream().collect(Collectors.joining(", "));
    // Result: "Alice, Bob, Charlie"
    ```

- **`joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)`**
  - **Description**: Concatenates the elements with a delimiter, prefix, and suffix.
  - **Example**:
    ```java
    String joined = names.stream().collect(Collectors.joining(", ", "[", "]"));
    // Result: "[Alice, Bob, Charlie]"
    ```

#### 4. **Partitioning and Grouping**

- **`partitioningBy(Predicate<? super T> predicate)`**
  - **Description**: Partitions the elements into two groups based on a predicate.
  - **Example**:
    ```java
    Map<Boolean, List<String>> partitioned = names.stream()
        .collect(Collectors.partitioningBy(name -> name.length() > 4));
    // Result: {false=[Bob], true=[Alice, Charlie]}
    ```

- **`groupingBy(Function<? super T, ? extends K> classifier)`**
  - **Description**: Groups elements by a classifier function.
  - **Example**:
    ```java
    Map<Integer, List<String>> groupedByLength = names.stream()
        .collect(Collectors.groupingBy(String::length));
    // Result: {3=[Bob], 5=[Alice], 7=[Charlie]}
    ```

- **`groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)`**
  - **Description**: Groups elements by a classifier function and applies a downstream collector.
  - **Example**:
    ```java
    Map<Integer, Set<String>> groupedByLengthWithSet = names.stream()
        .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    // Result: {3=[Bob], 5=[Alice], 7=[Charlie]}
    ```

#### 5. **Reducing**

- **`reducing(BinaryOperator<T> accumulator)`**
  - **Description**: Performs a reduction on the elements using an associative accumulation function.
  - **Example**:
    ```java
    Optional<String> concatenated = names.stream()
        .collect(Collectors.reducing((s1, s2) -> s1 + s2));
    // Result: Optional[AliceBobCharlie]
    ```

- **`reducing(T identity, BinaryOperator<T> accumulator)`**
  - **Description**: Performs a reduction with an identity value.
  - **Example**:
    ```java
    String concatenated = names.stream()
        .collect(Collectors.reducing("", (s1, s2) -> s1 + s2));
    // Result: AliceBobCharlie
    ```

### **Custom Collectors**

In addition to the standard collectors provided by `Collectors`, you can create custom collectors using the `Collector` interface.

**Example**: Custom collector to concatenate strings with a specific format.

```java
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.Collector.Characteristics;
import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;

public class CustomCollector {

    public static Collector<String, ?, String> customJoining(String delimiter) {
        return Collector.of(
            StringJoiner::new,
            (joiner, element) -> joiner.add(element),
            StringJoiner::merge,
            StringJoiner::toString,
            Collector.Characteristics.IDENTITY_FINISH
        );
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String result = names.stream()
                             .collect(customJoining(" | "));
        System.out.println(result);  // Output: Alice | Bob | Charlie
    }
}
```

### **Summary**

The `collect` operation in Java Streams is extremely versatile, allowing you to gather and transform stream elements into various forms such as collections, summary statistics, and custom results. Understanding the available collectors and their use cases will help you effectively process and accumulate data in your stream pipelines.

These methods provide a rich set of tools to process and transform collections in a functional style.
Sure! Here are several complex coding examples using the `map` and `collect` methods in Java Streams. These examples will showcase various `Collector` implementations and how to use them in different scenarios.

### 1. **Transforming Data and Collecting into Lists and Sets**

#### Example: Transform and Collect into a List of Transformed Objects

```java
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    // Constructor, getters, setters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class TransformAndCollect {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 30)
        );

        // Convert names to uppercase and collect into a List
        List<String> upperCaseNames = people.stream()
            .map(person -> person.getName().toUpperCase())
            .collect(Collectors.toList());

        System.out.println("Uppercase Names: " + upperCaseNames);

        // Collect unique ages into a Set
        Set<Integer> uniqueAges = people.stream()
            .map(Person::getAge)
            .collect(Collectors.toSet());

        System.out.println("Unique Ages: " + uniqueAges);
    }
}
```

### 2. **Grouping and Partitioning Data**

#### Example: Grouping by Age and Counting

```java
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    // Constructor, getters, setters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class GroupingAndCounting {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 30),
            new Person("Eve", 25)
        );

        // Group by age and count the number of people in each age group
        Map<Integer, Long> ageGroupCount = people.stream()
            .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        System.out.println("Age Group Count: " + ageGroupCount);
    }
}
```

#### Example: Partitioning by Age and Grouping

```java
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    // Constructor, getters, setters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class PartitioningAndGrouping {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 30),
            new Person("Eve", 25)
        );

        // Partition by age greater than 30
        Map<Boolean, List<Person>> partitionedByAge = people.stream()
            .collect(Collectors.partitioningBy(person -> person.getAge() > 30));

        System.out.println("Partitioned by Age > 30: " + partitionedByAge);

        // Group by age and collect names into a List
        Map<Integer, List<String>> namesByAge = people.stream()
            .collect(Collectors.groupingBy(
                Person::getAge,
                Collectors.mapping(Person::getName, Collectors.toList())
            ));

        System.out.println("Names by Age: " + namesByAge);
    }
}
```

### 3. **Collecting Statistics**

#### Example: Collecting Summary Statistics for Ages

```java
import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

class Person {
    private String name;
    private int age;

    // Constructor, getters, setters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class SummaryStatistics {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 30),
            new Person("Eve", 25)
        );

        // Collecting statistics for ages
        IntSummaryStatistics stats = people.stream()
            .mapToInt(Person::getAge)
            .collect(Collectors.summarizingInt(age -> age));

        System.out.println("Age Statistics: " + stats);
    }
}
```

#### Example: Calculating Average Salary by Department

```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    // Constructor, getters, setters
    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class AverageSalaryByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 50000, "HR"),
            new Employee(2, "Bob", 60000, "Engineering"),
            new Employee(3, "Charlie", 70000, "Engineering"),
            new Employee(4, "David", 55000, "HR"),
            new Employee(5, "Eve", 65000, "Marketing")
        );

        // Collect average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        System.out.println("Average Salary by Department: " + avgSalaryByDept);
    }
}
```

### 4. **Joining Strings**

#### Example: Joining Names with a Custom Delimiter

```java
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;

    // Constructor, getters, setters
    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}

public class JoiningStrings {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice"),
            new Person("Bob"),
            new Person("Charlie")
        );

        // Join names with a delimiter
        String namesJoined = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", ", "Names: ", "."));

        System.out.println(namesJoined);
    }
}
```

### 5. **Custom Collector**

#### Example: Custom Collector to Concatenate Strings with Prefix and Suffix

```java
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.StringJoiner;

public class CustomCollectorExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Custom collector
        Collector<String, ?, String> customJoining = Collector.of(
            () -> new StringJoiner(", ", "[", "]"),
            StringJoiner::add,
            StringJoiner::merge,
            StringJoiner::toString
        );

        String result = words.stream().collect(customJoining);

        System.out.println(result);  // Output: [apple, banana, cherry]
    }
}
```

## collect
`collect` collects the elements of a stream into a specific data structure.

```java
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        var list = stream.collect(Collectors.toList());
        System.out.println("Result: " + list);
    }
}
```
**Result:** `[1, 2, 3, 4, 5]`

### Summary

These examples demonstrate a variety of complex coding scenarios using the `map` and `collect` methods in Java Streams. Each example highlights different types of collectors, such as:

- Collecting into collections (`toList`, `toSet`, `toMap`)
- Grouping and partitioning data (`groupingBy`, `partitioningBy`)
- Calculating summary statistics (`summarizingInt`, `averagingDouble`)
- Joining elements into a single string (`joining`)
- Using custom collectors for specialized collection operations

## count
`count` counts the number of elements in a stream.

```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        var stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11);
        var count = stream.count();
        System.out.println("Result: " + count);
    }
}
```
**Result:** `10`

## anyMatch
`anyMatch` checks if at least one element satisfies the condition.

```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        var stream = Stream.of("apple", "banana", "orange", "grape", "kiwi");
        var anyMatch = stream.anyMatch(str -> str.startsWith("a"));

        if (anyMatch) {
            System.out.println("There are elements starting with the letter 'a' in Stream");
        } else {
            System.out.println("There are no elements starting with the letter 'a' in Stream");
        }
    }
}
```
**Result:** `There are elements starting with the letter 'a' in Stream`

## allMatch
`allMatch` checks if all elements satisfy the given condition.

```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        var stream = Stream.of(2, 4, 6, 8, 10);
        var allMatch = stream.allMatch(number -> number % 2 == 0);

        if (allMatch) {
            System.out.println("Result: All numbers in the Stream are divisible by 2");
        } else {
            System.out.println("Result: There is at least one number in the Stream that is not divisible by 2");
        }
    }
}
```
**Result:** `All numbers in the Stream are divisible by 2`

## noneMatch
`noneMatch` checks if all elements do not satisfy a condition.

```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        var stream = Stream.of(2, 4, 6, 8, 10);
        var noneMatch = stream.noneMatch(number -> number % 5 == 0);

        if (noneMatch) {
            System.out.println("Result: There are no numbers in the Stream that are divisible by 5");
        } else {
            System.out.println("Result: There is at least one number in the Stream that is divisible by 5");
        }
    }
}
```
**Result:** `There are no numbers in the Stream that are divisible by 5`

## findFirst
`findFirst` returns the first element in the stream.

```java
import java.util.Optional;
import java.util.stream.Stream;

public class CafeincodeExample {

    public static void main(String[] args) {
        var stream = Stream.of("apple", "banana", "cherry", "avocado", "blueberry");
        Optional<String> firstElement = stream.findFirst();
        if (firstElement.isPresent()) {
            System.out.println("Result: First element: " + firstElement.get());
        } else {
            System.out.println("Result: Stream is empty.");
        }
    }
}
```
**Result:** `First element: apple`

## findAny
`findAny` returns any element in the stream

```java
import java.util.Optional;
import java.util.stream.Stream;

public class CafeincodeExample {

    public static void main(String[] args) {
        var stream = Stream.of("apple", "banana", "cherry", "avocado", "blueberry");
        Optional<String> anyElement = stream.findAny();
        if (anyElement.isPresent()) {
            System.out.println("Result: Any element: " + anyElement.get());
        } else {
            System.out.println("Result: Stream is empty.");
        }
    }
}
```
**Result:** `First element: apple`

Certainly! Here's the provided Java examples formatted in Markdown:

### min returns the smallest word in the stream
```java
import java.util.Optional;
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        var stream = Stream.of(5, 2, 8, 1, 3);
        Optional<Integer> minElement = stream.min(Integer::compareTo);
        if (minElement.isPresent()) {
            System.out.println("Minimum element: " + minElement.get());
        } else {
            System.out.println("Stream is empty.");
        }
    }
}
```
Output:
```
Minimum element: 1
```

### max returns the largest element in the stream
```java
import java.util.Optional;
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        var stream = Stream.of(5, 2, 8, 1, 3);
        Optional<Integer> maxElement = stream.max(Integer::compareTo);
        if (maxElement.isPresent()) {
            System.out.println("Maximum element: " + maxElement.get());
        } else {
            System.out.println("Stream is empty.");
        }
    }
}
```
Output:
```
Maximum element: 8
```

### groupingBy is used to group elements in the stream according to a certain condition
```java
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        var stream = Stream.of("apple", "banana", "cherry", "avocado", "blueberry");
        var groupedByLength = stream.collect(Collectors.groupingBy(String::length));
        System.out.println("Result: " + groupedByLength);
    }
}
```
Output:
```
Result: {5=[apple], 6=[banana, cherry], 7=[avocado], 9=[blueberry]}
```

### partitioningBy is used to divide the stream elements into two groups based on a provided condition
```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> partitioned = stream.collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Even numbers: " + partitioned.get(true));
        System.out.println("Odd numbers: " + partitioned.get(false));
    }
}
```
Output:
```
Even numbers: [2, 4, 6, 8, 10] 
Odd numbers: [1, 3, 5, 7, 9]
```

### joining is used to combine stream elements into one string
```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class CafeincodeExample {
    public static void main(String[] args) {
        var data = Arrays.asList("apple", "banana", "cherry");
        String result = data.stream().collect(Collectors.joining(", "));
        System.out.println("Result: " + result);
    }
}
```
Output:
```
Result: apple, banana, cherry
```

### Iterate is used when it is necessary to create a sequence of values ​​generated according to a certain rule
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> evenNumbers = Stream.iterate(2, n -> n + 2).limit(5);
        evenNumbers.forEach(System.out::println);
    }
}
```
Output:
```
2
4
6
8
10
```

### of is used to create a stream from the elements provided as arguments
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("apple", "banana", "cherry");
        stream.forEach(System.out::println);
    }
}
```
Output:
```
apple 
banana 
cherry
```

### concat is used to concatenate two streams together
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("apple", "banana");
        Stream<String> stream2 = Stream.of("cherry", "grape");
        Stream<String> concatenatedStream = Stream.concat(stream1, stream2);
        concatenatedStream.forEach(System.out::println);
    }
}
```
Output:
```
apple
banana
cherry
grape
```

### unordered is used to specify that the stream will not follow the originally defined order
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> unorderedStream = stream.unordered();
        unorderedStream.forEach(System.out::println);
    }
}
```
Output (may vary):
```
1
2
3
4
5
```

### range is used to create a stream containing consecutive integers
```java
import java.util.stream.IntStream;

public class CafeincodeExample {
    public static void main(String[] args) {
        IntStream rangeStream = IntStream.range(1, 6);
        rangeStream.forEach(System.out::println);
    }
}
```
Output:
```
1
2
3
4
5
```

### rangeClosed is used to create a stream with integers in the range A to B
```java
import java.util.stream.IntStream;

public class CafeincodeExample {
    public static void main(String[] args) {
        IntStream rangeClosedStream = IntStream.rangeClosed(1, 5);
        rangeClosedStream.forEach(System.out::println);
    }
}
```
Output:
```
1
2
3
4
5
```

### generate is used to generate a stream by generating elements based on a provided supplier
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(() -> "Cafeincode").limit(3);
        stream.forEach(System.out::println);
    }
}
```
Output:
```
Cafeincode
Cafeincode
Cafeincode
```

### takeWhile is used to retrieve elements from a stream until a condition is no longer satisfied
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> takenStream = stream.takeWhile(n -> n <= 7);
        takenStream.forEach(System.out::println);
    }
}
```
Output:
```
1
2
3
4
5
6
7
```

### dropWhile is used to remove elements from a stream until a condition is no longer satisfied
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> droppedStream = stream.dropWhile(n -> n <= 6);
        droppedStream.forEach(System.out::println);
    }
}
```
Output:
```
7
8
9
10
```

### boxed is used to convert the elements of a stream from primitive types to boxed types
```java
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> boxedStream = intStream.boxed();
        boxedStream.forEach(System.out::println);
    }
}
```
Output:
```
1
2
3
4
5
6
7
8
```

### parallel used to convert a stream into a stream that can be processed in parallel
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> parallelStream = stream.parallel();
        parallelStream.forEach(System.out::println);
    }
}
```
Output (may vary):
```
3
5
4
2
1
```

### sequential used to convert a stream from parallel processing to sequential processing
```java
import java.util.stream.Stream;

public class CafeincodeExample {
    public static void main(String[] args) {
        Stream<Integer> parallelStream = Stream.of(1, 2, 3, 4, 5).parallel();
        Stream<Integer> sequentialStream = parallelStream.sequential();
        sequentialStream.forEach(System.out::println);
    }
}
```
Output:
```
1
2
3
4
5
```

### Best practice in using Java streams
- Best practices description (not executable code)
- Use streams properly for better code organization and readability.
- Avoid overusing parallel streams

Using streams properly makes your code more elegant, easier to see, and neater than the traditional coding style.

However, it must be said again and again, that too much of anything is not necessarily good. Overusing streams or confusing writing methods will also give you a real headache every time you debug.

So below are some best practices that I think should be applied to both make good use of it and avoid unnecessary abuse.

- When using a stream where multiple methods are continuously applied, put each function on a different line, it will be extremely useful when debugging.
- Use the methods I listed above `map()`, `filter()`, `reduce()`, `collect()`,... appropriately to perform operations on the stream
- Check for null during map and filter operations
- Avoid overusing parallel in the coding process, in many cases it does not achieve as much performance value as you think. If possible, just use the default sequential only.
- Name variables when used appropriately. Do not use variable names with the default letters a, b, and c because it will be difficult to understand when reading.
- Using Optional makes sense in cases where `findFirst` or `findAny` are used
- In reality, there will be many methods you need to re-implement rather than using the default, for example, sorted
- Use Peek to debug properly
- In the case of converting List to Map, you need to be careful to pay attention to duplicate keys
- Java streams use lazy evaluation (discussed in another article), which means elements are only calculated when necessary. You can use this to increase performance by avoiding unnecessary calculations.
