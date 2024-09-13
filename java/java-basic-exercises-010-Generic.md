# Java Exercises Generic

Generic Methods:

Generic methods are methods that introduce their own type parameters. This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is declared. Static and non-static generic methods are allowed, as well as generic class constructors.

The syntax for a generic method includes a list of type parameters, inside angle brackets, which appears before the method's return type. For static generic methods, the type parameter section must appear before the method's return type

### 1. Write a Java program to create a generic method that takes two arrays of the same type and checks if they have the same elements in the same order.

```java
// ArrayCompare.java
// ArrayCompare Class
import java.util.Arrays;
public class ArrayCompare {
  public static < T > boolean compare_Arrays(T[] array1, T[] array2) {
    if (array1.length != array2.length) {
      return false;
    }

    for (int i = 0; i < array1.length; i++) {
      if (!array1[i].equals(array2[i])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Integer[] arr1 = {
      1,
      2,
      3,
      4
    };
    Integer[] arr2 = {
      1,
      2,
      4,
      4
    };
    Integer[] arr3 = {
      1,
      2,
      3,
      4
    };
    String[] arr4 = {
      "Java",
      "World"
    };
    String[] arr5 = {
      "JavaScript",
      "World"
    };
    String[] arr6 = {
      "Java",
      "World"
    };
    System.out.println("Original arrays:");
    System.out.println("arr1: " + Arrays.toString(arr1));
    System.out.println("arr2: " + Arrays.toString(arr2));
    System.out.println("arr3: " + Arrays.toString(arr3));
    System.out.println("arr4: " + Arrays.toString(arr4));
    System.out.println("arr5: " + Arrays.toString(arr5));
    System.out.println("arr6: " + Arrays.toString(arr6));
    System.out.println("\nCompare arr1 and arr2: " + compare_Arrays(arr1, arr2)); //false
    System.out.println("Compare arr1 and arr3: " + compare_Arrays(arr1, arr3)); //true
    System.out.println("Compare arr4 and arr5: " + compare_Arrays(arr4, arr5)); //false
    System.out.println("Compare arr4 and arr6: " + compare_Arrays(arr4, arr6)); //true     		
  }
}
```
Sample Output:

 Original arrays:
arr1: [1, 2, 3, 4]
arr2: [1, 2, 4, 4]
arr3: [1, 2, 3, 4]
arr4: [Java, World]
arr5: [JavaScript, World]
arr6: [Java, World]

Compare arr1 and arr2: false
Compare arr1 and arr3: true
Compare arr4 and arr5: false
Compare arr4 and arr6: true
Explanation:

In the above exercise, we define a generic method compareArrays() that takes two arrays of the same type T. The method compares the elements of both arrays using the equals() method. If any pair of elements at the same index is not equal, the method returns false. If all elements are equal and the array lengths are the same, the method returns true.


The main() method tests the compareArrays() method with integers and strings to demonstrate its functionality.

### 2. Write a Java program to create a generic method that takes a list of numbers and returns the sum of all the even and odd numbers.
```java
// EvenOddSumCalculator.java
// EvenOddSumCalculator Class
import java.util.List;
public class EvenOddSumCalculator {
  public static < T extends Number > void calculateNumberSum(List < T > numbers) {
    double evenSum = 0;
    double oddSum = 0;

    for (T number: numbers) {
      if (number.doubleValue() % 2 == 0) {
        evenSum += number.doubleValue();
      } else {
        oddSum += number.doubleValue();
      }
    }
    System.out.println("\nOriginal list of numbers: " + numbers);
    System.out.println("Sum of even numbers: " + evenSum);
    System.out.println("Sum of odd numbers: " + oddSum);
  }

  public static void main(String[] args) {
    List < Integer > integers = List.of(1, 2, 3, 4, 5, 6, 7);
    List < Double > doubles = List.of(2.0, 1.5, 4.5, 2.5, 1.5);

    calculateNumberSum(integers);
    calculateNumberSum(doubles);
  }
}
```
Sample Output:

 Original list of numbers: [1, 2, 3, 4, 5, 6, 7]
Sum of even numbers: 12.0
Sum of odd numbers: 16.0

Original list of numbers: [2.0, 1.5, 4.5, 2.5, 1.5]
Sum of even numbers: 2.0
Sum of odd numbers: 10.0
Explanation:

In the above exercise, we define a generic method calculateNumberSum() that takes a list of numbers as input. With the modulo operator %, the method iterates over the list and checks if each number is even or odd. If the number is even, it adds the value to the evenSum variable; otherwise, it adds the value to the oddSum variable.


Finally, the method prints out the sum of even and odd numbers.

In the main() method, we demonstrate the calculateNumberSum() method by passing two different lists: integers containing integers and doubles containing double values. For each list, the program calculates and prints the sum of even and odd numbers.

### 3. Write a Java program to create a generic method that takes a list of any type and a target element. It returns the index of the first occurrence of the target element in the list. Return -1 if the target element cannot be found.

Write a Java program to create a generic method that takes a list of any type and a target element. It returns the index of the first occurrence of the target element in the list. Return -1 if the target element cannot be found.

Sample Solution:

Java Code:
```java
// FindElement.java
// FindElement Class
import java.util.List;

public class FindElement {

  public static < T > int findIndexOfElement(List < T > list, T target) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(target)) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    List < Integer > numbers = List.of(1, 2, 3, 4, 5);
    List < String > colors = List.of("Red", "Green", "Blue", "Orange", "White");
    System.out.println("Original list elements:");
    System.out.println("Nums: " + numbers);
    System.out.println("Colors: " + colors);

    int index1 = findIndexOfElement(numbers, 3);
    System.out.println("\nIndex of 3 in numbers: " + index1); // Output: 2

    int index2 = findIndexOfElement(numbers, 6);
    System.out.println("Index of 6 in numbers: " + index2); // Output: -1

    int index3 = findIndexOfElement(colors, "Green");
    System.out.println("Index of \"Green\" in colors: " + index3); // Output: 1

    int index4 = findIndexOfElement(colors, "Black");
    System.out.println("Index of \"Black\" in colors: " + index4); // Output: -1
  }
}
```
Sample Output:

 Original list elements:
Nums: [1, 2, 3, 4, 5]
Colors: [Red, Green, Blue, Orange, White]

Index of 3 in numbers: 2
Index of 6 in numbers: -1
Index of "Green" in colors: 1
Index of "Black" in colors: -1
Explanation:

In the above exercise, we define a generic method findIndexOfElement() that takes a list list and a target element target as input. With a for loop, the method iterates over the list and checks if each element is equal to the target element. If a match is found, the method returns the index of the first occurrence. If the target element cannot be found, the method returns -1.


In the main() method, we demonstrate the findIndexOfElement() method by passing a list of integers (numbers) and a list of strings (words). We find the index of specific elements in the list and print the results.

### 4. Write a Java program to create a generic method that takes a list of any type and returns it as a new list with the elements in reverse order.

Write a Java program to create a generic method that takes a list of any type and returns it as a new list with the elements in reverse order.

Sample Solution:

Java Code:
```java
// ReverserList.java
// ReverserList Class
import java.util.ArrayList;
import java.util.List;

public class ReverserList {

  public static < T > List < T > reverseList(List < T > originalList) {
    List < T > reversedList = new ArrayList < > ();

    for (int i = originalList.size() - 1; i >= 0; i--) {
      reversedList.add(originalList.get(i));
    }

    return reversedList;
  }

  public static void main(String[] args) {
    List < Integer > numbers = List.of(1, 2, 3, 4, 5, 6);
    List < String > colors = List.of("Red", "Green", "Orange");

    List < Integer > reversedNumbers = reverseList(numbers);
    System.out.println("Original list of numbers: " + numbers);
    System.out.println("Reversed numbers: " + reversedNumbers); // Output: [6, 5, 4, 3, 2, 1]

    List < String > reversedWords = reverseList(colors);
    System.out.println("\nOriginal list of colors: " + colors);
    System.out.println("Reversed colors: " + reversedWords); // Output: [Orange, Green, Red]
  }
}
```
Sample Output:

 Original list of numbers: [1, 2, 3, 4, 5, 6]
Reversed numbers: [6, 5, 4, 3, 2, 1]

Original list of colors: [Red, Green, Orange]
Reversed colors: [Orange, Green, Red]
Explanation:

In this program, we define a generic method reverseList() that takes a list originalList as input. The method creates the reversedList from an ArrayList. It iterates over the originalList in reverse order using a for loop and adds each element to the reversedList with the add() method.

The method returns the reversedList at the end.

In the main() method, we demonstrate the reverseList() method by passing a list of integers (numbers) and a list of strings (words). We reverse the elements of each list and print the reversed list.

### 5. Write a Java program to create a generic method that takes two lists of the same type and merges them into a single list. This method alternates the elements of each list.

Write a Java program to create a generic method that takes two lists of the same type and merges them into a single list. This method alternates the elements of each list.

Sample Solution:

Java Code:
```java
// ReverserList.java
// ReverserList Class
import java.util.ArrayList;
import java.util.List;

public class Merge_two_lists {

  public static < T > List < T > mergeLists(List < T > list1, List < T > list2) {
    List < T > mergedList = new ArrayList < > ();

    int maxLength = Math.max(list1.size(), list2.size());
    for (int i = 0; i < maxLength; i++) {
      if (i < list1.size()) {
        mergedList.add(list1.get(i));
      }

      if (i < list2.size()) {
        mergedList.add(list2.get(i));
      }
    }

    return mergedList;
  }

  public static void main(String[] args) {
    List < Integer > nums1 = List.of(1, 3, 5, 7);
    List < Integer > nums2 = List.of(2, 4, 8, 10);
    System.out.println("List of numbers:");
    System.out.println(nums1);
    System.out.println(nums2);
    List < String > colors1 = List.of("Red", "Green", "Blue");
    List < String > colors2 = List.of("White", "Black", "Orange", "Pink");
    System.out.println("\nList of colors:");
    System.out.println(colors1);
    System.out.println(colors2);
    List < Integer > mergedNumbers = mergeLists(nums1, nums2);
    // Output:[1, 2, 3, 4, 5, 8, 7, 10]
    System.out.println("\nMerged Numbers: " + mergedNumbers);
    // Output:[Red, White, Green, Black, Blue, Orange, Pink]
    List < String > mergedWords = mergeLists(colors1, colors2);
    System.out.println("Merged Colors: " + mergedWords);
  }
}
```
Sample Output:

List of numbers:
[1, 3, 5, 7]
[2, 4, 8, 10]

List of colors:
[Red, Green, Blue]
[White, Black, Orange, Pink]

Merged Numbers: [1, 2, 3, 4, 5, 8, 7, 10]
Merged Colors: [Red, White, Green, Black, Blue, Orange, Pink]
Explanation:

In the above exercise, we define a generic method mergeLists() that takes two lists list1 and list2 as input. The method creates a newly created mergedList from an ArrayList. It iterates up to the maximum length of the two lists using a for loop. In each iteration, it checks if the index is within the bounds of each list. It adds the corresponding element to the mergedList using the add() method.

The method returns the mergedList at the end.

Using the main() method, we demonstrate the use of mergeLists() by passing two lists of integers (numbers1 and numbers2) and two lists of strings (words1 and words2). We merge the elements of each pair of lists and print the merged lists.

### 6. Write a Java program to create a generic method that takes a list of any type and a predicate. It returns an array list containing only elements that satisfy the predicate.

Write a Java program to create a generic method that takes a list of any type and a predicate. It returns an array list containing only elements that satisfy the predicate.

Sample Solution:

Java Code:
```java
// Filter_List_elements.java
// Filter_List_elements Class

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter_List_elements {

  public static < T > List < T > filterList(List < T > originalList, Predicate < T > predicate) {
    List < T > filteredList = new ArrayList < > ();

    for (T element: originalList) {
      if (predicate.test(element)) {
        filteredList.add(element);
      }
    }

    return filteredList;
  }

  public static void main(String[] args) {
    List < Integer > numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    System.out.println("Original list of numbers: " + numbers);
    // Filter even numbers
    List < Integer > evenNumbers = filterList(numbers, n -> n % 2 == 0);
    System.out.println("Even numbers: " + evenNumbers);

    // Filter odd numbers
    List < Integer > oddNumbers = filterList(numbers, n -> n % 2 != 0);
    System.out.println("Odd numbers: " + oddNumbers);

    List < String > colors = List.of("Red", "Green", "White", "Orange", "Black", "Pink");
    System.out.println("\nOriginal list of Colors: " + colors);
    // Filter colors starting with 'O'
    List < String > wordsStartingWithO = filterList(colors, color -> color.startsWith("O"));
    System.out.println("Colors starting with 'O': " + wordsStartingWithO);

    // Filter colors with length greater than 4
    List < String > wordsLengthGreaterThan4 = filterList(colors, color -> color.length() > 4);
    System.out.println("Colors with length greater than 4: " + wordsLengthGreaterThan4);
  }
}
```
Sample Output:

 Original list of numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
Even numbers: [2, 4, 6, 8, 10, 12]
Odd numbers: [1, 3, 5, 7, 9, 11]

Original list of Colors: [Red, Green, White, Orange, Black, Pink]
Colors starting with 'O': [Orange]
Colors with length greater than 4: [Green, White, Orange, Black]
Explanation:

In the above exercise, we define a generic method filterList() that takes a list originalList and a predicate "predicate" as input. The method creates a newly filteredList from an ArrayList. It iterates over the originalList using an enhanced for loop. It applies the predicate to each element using the test() method of the Predicate interface. Using the add() method, the element is added to the filteredList if it meets the predicate.

The method returns the filteredList at the end.

In the main() method, we demonstrate the filterList() method by passing a list of integers (numbers) and a list of strings (words). By applying different predicates, we filter elements from the lists and print the filtered lists.

### 7. Write a Java program to create a generic method that takes a map of any type and prints each key-value pair.
Write a Java program to create a generic method that takes a map of any type and prints each key-value pair.

Sample Solution:

Java Code:
```java
// Print_map_elements.java
// Print_map_elements Class

import java.util.HashMap;
import java.util.Map;

public class Print_map_elements {

  public static > K, V > void printMap(Map > K, V > map) {
    for (Map.Entry > K, V > entry: map.entrySet()) {
      K key = entry.getKey();
      V value = entry.getValue();
      System.out.println("Key: " + key + ", Value: " + value);
    }
  }

  public static void main(String[] args) {
    Map > String, Integer > colorMap = new HashMap > > ();
    colorMap.put("Red", 1);
    colorMap.put("Green", 2);
    colorMap.put("Blue", 3);

    System.out.println("Color Map:");
    printMap(colorMap);

    Map > String, String > capitalMap = new HashMap > > ();
    capitalMap.put("Germany ", "Berlin");
    capitalMap.put("USA", "Washington, D.C.");
    capitalMap.put("UK", "London");
    capitalMap.put("France", "Paris");

    System.out.println("\nCapital Map:");
    printMap(capitalMap);
  }
}
```
Sample Output:

Color Map:
Key: Red, Value: 1
Key: Blue, Value: 3
Key: Green, Value: 2

Capital Map:
Key: Germany , Value: Berlin
Key: USA, Value: Washington, D.C.
Key: UK, Value: London
Key: France, Value: Paris
Explanation:

In the above exercise, we define a generic method printMap() that takes a map "map" as input. The method iterates over the map's key-value pairs using a for-each loop and Map.Entry. For each entry, it retrieves the key and value using the getKey() and getValue() methods respectively. It then prints the key-value pair using System.out.println().


In the main() method, we demonstrate the printMap() method by passing a ColorMap containing mappings of number names to their values. We also pass a capitalMap containing mappings of country names to their capitals. We call the printMap() method for each map to print their respective key-value pairs.
