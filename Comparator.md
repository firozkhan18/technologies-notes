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
