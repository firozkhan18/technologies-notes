<details><summary><b>Collection Framework</b></summary>

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
