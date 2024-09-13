# Java Exercises Stream

Processing Data with  Java SE 8 Streams:

Stream is a sequence of elements from a source that supports aggregate operations. Let’s break it down:

Sequence of elements: A stream provides an interface to a sequenced set of values of a specific element type. However, streams don’t actually store elements; they are computed on demand.
Source: Streams consume from a data-providing source such as collections, arrays, or I/O resources.
Aggregate operations: Streams support SQL-like operations and common operations from functional  programing languages, such as filter, map, reduce, find, match, sorted, and so on.
### 1. Write a Java program to calculate the average of a list of integers using streams.

Write a Java program to calculate the average of a list of integers using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List < Integer > nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36);
    System.out.println("List of numbers: " + nums);

    // Calculate the average using streams
    double average = nums.stream()
      .mapToDouble(Integer::doubleValue)
      .average()
      .orElse(0.0);

    System.out.println("Average value of the said numbers: " + average);
  }
}
```
Sample Output:

List of numbers: [1, 3, 6, 8, 10, 18, 36]
Average value of the said numbers: 11.714285714285714 
Explanation:

In the above exercise, we have a list of integers (1, 3, 6, 8, 10, 18, 36). Using streams, we convert each integer to a double using the mapToDouble method and calculate the average through the average() method, and finally retrieve the average value using the orElse method in case the stream is empty. The average value is then printed to the console.

### 2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.

Write a Java program to convert a list of strings to uppercase or lowercase using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List < String > colors = Arrays.asList("RED", "grEEn", "white", "Orange", "pink");
    System.out.println("List of strings: " + colors);
    // Convert strings to uppercase using streams
    List < String > uppercaseStrings = colors.stream()
      .map(String::toUpperCase)
      .collect(Collectors.toList());

    System.out.println("\nUppercase Strings: " + uppercaseStrings);

    // Convert strings to lowercase using streams
    List < String > lowercaseStrings = colors.stream()
      .map(String::toLowerCase)
      .collect(Collectors.toList());

    System.out.println("Lowercase Strings: " + lowercaseStrings);
  }
}
```
Sample Output:

List of strings: [RED, grEEn, white, Orange, pink]

Uppercase Strings: [RED, GREEN, WHITE, ORANGE, PINK]
Lowercase Strings: [red, green, white, orange, pink] 
Explanation:

In the above exercises, we have a list of strings containing ("RED", "grEEn", "white", "Orange", "pink"). Using streams. First convert the strings to uppercase by calling the toUpperCase method on each string, and then collect the results into a new list using the collect method. Similarly, convert the strings to lowercase by calling the toLowerCase method on each string. Finally, the uppercase and lowercase lists are printed to the console.

### 3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.

Write a Java program to calculate the sum of all even, odd numbers in a list using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.List;

public class NumberSum {
  public static void main(String[] args) {
    List < Integer > numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Sum of even numbers
    int sumOfEvens = numbers.stream()
      .filter(num -> num % 2 == 0)
      .mapToInt(Integer::intValue)
      .sum();

    System.out.println("Sum of even numbers: " + sumOfEvens);

    // Sum of odd numbers
    int sumOfOdds = numbers.stream()
      .filter(num -> num % 2 != 0)
      .mapToInt(Integer::intValue)
      .sum();

    System.out.println("Sum of odd numbers: " + sumOfOdds);
  }
}
```
Sample Output:

List of numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14]

Sum of even numbers: 56
Sum of odd numbers: 25
Explanation:

In the above exercise, we have a list of integers [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]. Using streams, we can filter the even numbers by applying a filter with the condition num % 2 == 0, and then sum them using the sum method. Similarly, filter odd numbers by applying a filter with the condition num % 2 != 0, and then sum them. Finally, the sums of even and odd numbers are printed to the console.

### 4. Write a Java program to remove all duplicate elements from a list using streams.

Write a Java program to remove all duplicate elements from a list using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List < Integer > nums = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
    System.out.println("Original List of numbers: " + nums);
    // Remove duplicates
    List < Integer > distinctNumbers = nums.stream()
      .distinct()
      .collect(Collectors.toList());
    System.out.println("After removing duplicates from the said list: " + distinctNumbers);
  }
}
```
Sample Output:

Original List of numbers: [10, 23, 22, 23, 24, 24, 33, 15, 26, 15]
After removing duplicates from the said list: [10, 23, 22, 24, 33, 15, 26]
Explanation:

In the above exercise,

The list of numbers is defined as nums and initialized with the Arrays.asList method.
The distinct method is applied to the stream of numbers using the stream method on the nums list.
This operation removes duplicate elements from the stream.
The resulting stream is collected back into a list using the collect method with Collectors.toList().

### 5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.

Write a Java program to count the number of strings in a list that start with a specific letter using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List < String > colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
    System.out.println("Original list of strings (colors): " + colors);
    char startingLetter = 'B';
    // Count strings starting with a specific letter
    long ctr = colors.stream()
      .filter(s -> s.startsWith(String.valueOf(startingLetter)))
      .count();
    System.out.println("\nNumber of colors starting with '" + startingLetter + "': " + ctr);
    char startingLetter1 = 'Y';
    // Count strings starting with a specific letter
    ctr = colors.stream()
      .filter(s -> s.startsWith(String.valueOf(startingLetter1)))
      .count();
    System.out.println("\nNumber of colors starting with '" + startingLetter1 + "': " + ctr);
  }
}
```
Sample Output:

Original list of strings (colors): [Red, Green, Blue, Pink, Brown]

Number of colors starting with 'B': 2

Number of colors starting with 'Y': 0
Explanation:

In the above exercise, we have a list of strings ("Red", "Green", "Blue", "Pink", "Brown"). We want to count the number of strings that start with a specific letter, which is defined by the startingLetter variable (in this case, 'a').


Using streams, we call the filter() method to filter out only strings that start with the specified letter. Then, we use the count() method to get the count of those filtered strings. Finally, the original list and the count of strings starting with the specific letter are printed to the console.

### 6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.

Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List < String > colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
    System.out.println("Original List of strings(colors): " + colors);
    // Sort strings in ascending order
    List < String > ascendingOrder = colors.stream()
      .sorted()
      .collect(Collectors.toList());

    // Sort strings in descending order
    List < String > descendingOrder = colors.stream()
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());

    System.out.println("\nSorted in Ascending Order: " + ascendingOrder);
    System.out.println("\nSorted in Descending Order: " + descendingOrder);
  }
}
```
Sample Output:

Original List of strings(colors): [Red, Green, Blue, Pink, Brown]

Sorted in Ascending Order: [Blue, Brown, Green, Pink, Red]

Sorted in Descending Order: [Red, Pink, Green, Brown, Blue]
Explanation:

In the above exercise,

Using streams, we call the sorted() method without passing any comparator to sort the strings in ascending order based on their natural order (lexicographically). We collect the sorted strings into a new list using the toList() method.


To sort the strings in descending order, we pass Comparator.reverseOrder() as the comparator to the sorted() method. This reverses the natural order and sorts the strings in descending order.

### 7. Write a Java program to find the maximum and minimum values in a list of integers using streams.

Write a Java program to find the maximum and minimum values in a list of integers using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List < Integer > nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
    System.out.println("Original list of numbers: " + nums);
    // Find the maximum value
    Integer max_val = nums.stream()
      .max(Integer::compare)
      .orElse(null);

    // Find the minimum value
    Integer min_val = nums.stream()
      .min(Integer::compare)
      .orElse(null);

    System.out.println("\nMaximum value of the said list: " + max_val);
    System.out.println("\nMinimum value of the said list: " + min_val);
  }
}
```
Sample Output:

Original list of numbers: [1, 17, 54, 14, 14, 33, 45, -11]

Maximum value of the said list: 54

Minimum value of the said list: -11
Explanation:

In the above exercise,

We create a list of integers (nums) and use streams to find the maximum value using the max() method and the minimum value using the min() method. The orElse method handles the case when the list is empty. Finally, we print the maximum and minimum values.

### 8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.
Write a Java program to find the second smallest and largest elements in a list of integers using streams.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List < Integer > nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
    System.out.println("List of numbers: " + nums);
    // Find the second smallest element
    Integer secondSmallest = nums.stream()
      .distinct()
      .sorted()
      .skip(1)
      .findFirst()
      .orElse(null);

    // Find the second largest element
    Integer secondLargest = nums.stream()
      .distinct()
      .sorted((a, b) -> Integer.compare(b, a))
      .skip(1)
      .findFirst()
      .orElse(null);

    System.out.println("\nSecond smallest element: " + secondSmallest);
    System.out.println("\nSecond largest element: " + secondLargest);
  }
}
```
Sample Output:

List of numbers: [1, 17, 54, 14, 14, 33, 45, -11]

Second smallest element: 1

Second largest element: 45
Explanation:

In the above exercise,

We create a list of integers (numbers) and use streams to find the second smallest element by applying distinct, sorting the elements in ascending order, skipping the first element, and locating the first element. Similarly, we find the second largest element by sorting the elements in descending order. The orElse method handles the case when the list is empty or there are no second smallest/largest elements.
