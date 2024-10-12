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
