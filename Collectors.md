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
