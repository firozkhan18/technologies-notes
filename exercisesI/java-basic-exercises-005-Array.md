# Java Exercises Array

Arrays in Java, conceptually, are no different than in other programming languages.

Arrays are contiguous memory locations storing only one type of item in a sequence.
Arrays provide index-based access i.e. the first element of the array is stored at the 0th index, 2nd element is stored on 1st index and so on.
Note that, in Java, arrays are also objects that inherit the Object class, and implement the Serializable as well as Cloneable interfaces.
We can store all kinds of primitive values or objects in an array.
Java supports single dimentional or multi-dimentional arrays, both. 
The java.util.Arrays class provides many useful static methods to work with arrays and perform common operations on them.

1\. Array Basics
----------------
*   [Initialize an Array](https://howtodoinjava.com/java/array/initializing-array/)
*   [Reverse an Array](https://howtodoinjava.com/java/array/reverse-an-array/)
*   [Comparing Two Arrays](https://howtodoinjava.com/java/array/checking-arrays-are-equal/)
*   [Printing an Array](https://howtodoinjava.com/java/array/print-array-elements/)
*   [Printing 2D Array](https://howtodoinjava.com/java/array/print-2d-array-matrix/)

2\. Array Operations
--------------------

*   [Concatenate Two Arrays in Java](https://howtodoinjava.com/java/array/concatenate-arrays/)
*   [Splitting an Array](https://howtodoinjava.com/java/array/split-arrays/)
*   [Joining Array Items with Seperator](https://howtodoinjava.com/java/array/join-string-array-example/)
*   [Resizing an Array](https://howtodoinjava.com/java/array/resizing-array/)
*   [Removing Items from Array](https://howtodoinjava.com/java/array/removing-items-from-array/)
*   [Remove Duplicates from Array](https://howtodoinjava.com/java/array/array-remove-duplicate-elements/)
*   [Union of Two Arrays](https://howtodoinjava.com/java/array/union-between-two-arrays/)
*   [Intersection of Two Arrays](https://howtodoinjava.com/java/array/intersection-between-arrays/)

3\. Searching and Sorting
-------------------------

*   [How to Check is Array Contains an Item](https://howtodoinjava.com/java/array/array-arraylist-contains-example/)
*   [Find Top N items in Array](https://howtodoinjava.com/java/array/finding-top-n-items/)
*   [Find Sum and Average of Array](https://howtodoinjava.com/java/array/sum-and-average-of-array/)
*   [Find Max/Min in Array](https://howtodoinjava.com/java/array/find-max-min-arrays/)
*   [Sorting an Array](https://howtodoinjava.com/java/sort/java-array-sorting/)
*   [Checking if array is already sorted?](https://howtodoinjava.com/java/array/check-sorted-array/)

4\. Conversions
---------------

* [Array of Primitives to Array to objects](https://howtodoinjava.com/java/array/convert-between-array-of-primitives-and-objects/)
* [Convert between Array and List](https://howtodoinjava.com/java/array/convert-between-list-and-array/)
* [Convert between Stream and Array](https://howtodoinjava.com/java/array/convert-between-stream-and-array/)
* [Java String to String Array](https://howtodoinjava.com/java/array/string-to-string-array/)
* [Convert a Primitive Array to List in Java](https://howtodoinjava.com/java/array/convert-primitive-array-to-list/)

5\. Advance Topics
------------------

*   [Java Array Clone](https://howtodoinjava.com/java/array/java-array-clone-shallow-copy/)
*   [Java Array Copy](https://howtodoinjava.com/java/array/array-copy/)
*   [Java Array Deep Copy](https://howtodoinjava.com/java/array/java-array-deep-copy-example/)
*   [Java Copy Array Range](https://howtodoinjava.com/java/array/copy-array-range/)


In Java, arrays can be initialized in several ways, including with and without the `new` keyword. Here’s a detailed explanation of the differences between these approaches:

### 1. Array Initialization with the `new` Keyword

When you use the `new` keyword, you explicitly allocate memory for the array and specify its size. This is the traditional way to initialize arrays.

#### Example:
```java
int[] numbers = new int[5];  // Creates an array of 5 integers
```

- **Memory Allocation**: Memory is allocated for the array of the specified size.
- **Default Values**: Elements of the array are initialized with default values (e.g., `0` for integers, `null` for objects).
- **Size Specification**: You need to specify the size of the array when you create it.

#### Initialization with Values:
```java
int[] numbers = new int[]{1, 2, 3, 4, 5};  // Creates an array with initial values
```

- **Memory Allocation**: Memory is allocated for the array with the exact size needed to hold the specified values.
- **Initial Values**: The array is directly initialized with the provided values.

### 2. Array Initialization Without the `new` Keyword

When you initialize an array without using the `new` keyword, you are typically using an array initializer, which is a shorthand for creating an array and initializing it in one step.

#### Example:
```java
int[] numbers = {1, 2, 3, 4, 5};  // Creates and initializes an array in one step
```

- **Memory Allocation**: Memory is allocated for the array with the exact size needed to hold the values provided.
- **Initial Values**: The array is initialized with the values directly.

### Key Differences

1. **Syntax**:
   - **With `new`**: `int[] numbers = new int[5];` or `int[] numbers = new int[]{1, 2, 3, 4, 5};`
   - **Without `new`**: `int[] numbers = {1, 2, 3, 4, 5};`

2. **Initialization**:
   - **With `new`**: Can initialize an array with default values or with values using `new int[]{...}`.
   - **Without `new`**: Directly initializes the array with the values provided.

3. **Size Specification**:
   - **With `new`**: You can specify the size explicitly when creating the array.
   - **Without `new`**: The size is implicitly determined by the number of elements provided in the initializer.

4. **Usage**:
   - **With `new`**: Useful when you want to create an empty array of a specific size and then populate it later.
   - **Without `new`**: Convenient for initializing an array with a known set of values in a single line.

### Examples of Usage:

1. **Creating and Filling Later**:
   ```java
   int[] array = new int[3];  // Create an array with 3 elements
   array[0] = 10;
   array[1] = 20;
   array[2] = 30;
   ```

2. **Direct Initialization**:
   ```java
   int[] array = {10, 20, 30};  // Create and initialize the array with values
   ```

In summary, the choice between using `new` or not often depends on whether you need to explicitly define the array size before initializing it or if you want a more concise way to initialize an array with specific values.

When it comes to performance between initializing an array with the `new` keyword versus using array initializers without `new`, the difference is generally minimal and often negligible in most practical scenarios. However, there are some considerations to be aware of:

### Performance Considerations

1. **Array Initialization Without `new`**:
   ```java
   int[] numbers = {1, 2, 3, 4, 5};
   ```
   - **Initialization**: This syntax creates and initializes the array in one step. The array is created and immediately populated with the specified values.
   - **Performance**: Since the array is created and initialized in a single step, it can be slightly more efficient in terms of execution time, as there is no need for a separate initialization phase. The Java compiler optimizes this form of initialization internally.

2. **Array Initialization With `new`**:
   ```java
   int[] numbers = new int[]{1, 2, 3, 4, 5};
   ```
   - **Initialization**: This syntax involves using the `new` keyword to allocate memory for the array and then initializing it with the provided values.
   - **Performance**: The performance impact is generally negligible. The array is created and initialized, but the syntax is slightly more verbose.

### Factors Affecting Performance

- **Array Size**: For small arrays, the performance difference between these two methods is negligible. For large arrays, the difference is still minimal, as most modern Java compilers and runtime environments are optimized to handle both forms efficiently.

- **Initialization Overhead**: The overhead of initializing an array with `new` followed by setting values versus initializing directly with values is generally minor. The key aspect is that Java’s compiler and JVM optimize both methods well.

- **Compiler Optimizations**: Modern Java compilers are quite good at optimizing array creation and initialization. The difference in performance due to the choice between these two methods is often too small to measure in most applications.

### General Recommendation

- **Readability and Maintainability**: Choose the initialization method that best fits the context and improves code readability. For example, if you have a set of known values and want to initialize the array directly, using the array initializer without `new` is more concise and readable.

- **Performance Impact**: Unless you are working in a performance-critical section of code and have determined through profiling that array initialization is a bottleneck, you are unlikely to see a significant performance difference between these two methods.

### Example Code Comparison

#### Initialization Without `new`:
```java
int[] numbers = {1, 2, 3, 4, 5};  // Direct and concise
```

#### Initialization With `new`:
```java
int[] numbers = new int[]{1, 2, 3, 4, 5};  // Slightly more verbose
```

### Conclusion

For most use cases, the choice between these initialization methods should be guided more by code clarity and readability rather than performance concerns. Both methods are efficient, and the performance difference is typically minimal. Use the method that best fits your coding style and the needs of your application.
It looks like HTML tags aren't working as you intended for new lines. Instead, I'll use simple code blocks and inline formatting to clearly present the information. Here's the table of `java.util.Arrays` methods with descriptions and example code:

| **Method**               | **Description**                                                                 | **Example Code**                                                      |
|--------------------------|---------------------------------------------------------------------------------|----------------------------------------------------------------------|
| `Arrays.sort`            | Sorts the specified array into ascending order.                                 |   <br> `int[] numbers = {3, 5, 1, 4, 2};  ` <br> `Arrays.sort(numbers);  ` <br> ` System.out.println(Arrays.toString(numbers)); ` <br> `// Output: [1, 2, 3, 4, 5] `|
| `Arrays.binarySearch`    | Searches for a specified element in a sorted array.                             |   <br> `int[] numbers = {1, 2, 3, 4, 5};  ` <br> `int index = Arrays.binarySearch(numbers, 3);  ` <br> ` System.out.println(index); ` <br> ` // Output: 2 `|
| `Arrays.copyOf`          | Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length. |   <br> `int[] original = {1, 2, 3};  ` <br> `int[] copy = Arrays.copyOf(original, 5); `  <br> ` System.out.println(Arrays.toString(copy)); ` <br> ` // Output: [1, 2, 3, 0, 0] `|
| `Arrays.copyOfRange`     | Copies the specified range of the specified array into a new array.             |   <br> `int[] original = {1, 2, 3, 4, 5};  ` <br> `int[] copy = Arrays.copyOfRange(original, 1, 4);  ` <br> ` System.out.println(Arrays.toString(copy)); ` <br> ` // Output: [2, 3, 4] `|
| `Arrays.fill`            | Fills the specified array with the specified value.                             |   <br> `int[] array = new int[5];  ` <br> `Arrays.fill(array, 10);  ` <br> ` System.out.println(Arrays.toString(array)); ` <br> ` // Output: [10, 10, 10, 10, 10] `|
| `Arrays.equals`          | Checks if two arrays are equal to each other.                                   |   <br> `int[] array1 = {1, 2, 3};  ` <br> `int[] array2 = {1, 2, 3};  ` <br> `boolean isEqual = Arrays.equals(array1, array2);  ` <br> ` System.out.println(isEqual); ` <br> `// Output: true `|
| `Arrays.deepEquals`      | Checks if two arrays are deeply equal to each other (useful for nested arrays). |   <br> `int[][] array1 = {{1, 2}, {3, 4}};  ` <br> `int[][] array2 = {{1, 2}, {3, 4}};  ` <br> `boolean isDeepEqual = Arrays.deepEquals(array1, array2);  ` <br> ` System.out.println(isDeepEqual); ` <br> ` // Output: true `|
| `Arrays.toString`        | Returns a string representation of the contents of the specified array.         |   <br> `int[] array = {1, 2, 3};  ` <br> ` System.out.println(Arrays.toString(array)); ` <br> ` // Output: [1, 2, 3] `|
| `Arrays.deepToString`    | Returns a string representation of the contents of the specified array, including nested arrays. |   <br> `int[][] array = {{1, 2}, {3, 4}};  ` <br> ` System.out.println(Arrays.deepToString(array)); ` <br> ` // Output: [[1, 2], [3, 4]] `|
| `Arrays.asList`          | Converts an array to a fixed-size list.                                         |   <br> `String[] array = {"a", "b", "c"};  ` <br> `List<String> list = Arrays.asList(array);  ` <br> ` System.out.println(list); ` <br> ` // Output: [a, b, c] `|
| `Arrays.stream`          | Returns a sequential `Stream` with the specified array as its source.           |   <br> `int[] array = {1, 2, 3};  ` <br> `int sum = Arrays.stream(array).sum();  ` <br> ` System.out.println(sum); ` <br> ` // Output: 6 `|
| `Arrays.parallelSort`    | Sorts the specified array into ascending order using parallel sort.             |   <br> `int[] numbers = {5, 4, 3, 2, 1};  ` <br> `Arrays.parallelSort(numbers);  ` <br> ` System.out.println(Arrays.toString(numbers)); ` <br> ` // Output: [1, 2, 3, 4, 5] `|

### Explanation of Key Methods

- **`Arrays.sort`**: Efficiently sorts arrays using dual-pivot quicksort (for primitives) or a stable sort (for objects).
- **`Arrays.binarySearch`**: Performs a binary search on a sorted array to find the index of a specific element.
- **`Arrays.copyOf`**: Creates a new array with a specified length and copies elements from the original array.
- **`Arrays.copyOfRange`**: Creates a new array containing a specified range of elements from the original array.
- **`Arrays.fill`**: Sets all elements of an array to a specified value.
- **`Arrays.equals`**: Checks if two arrays are identical in terms of length and contents.
- **`Arrays.deepEquals`**: Compares two arrays deeply, supporting nested arrays.
- **`Arrays.toString`**: Provides a string representation of a single-dimensional array.
- **`Arrays.deepToString`**: Provides a string representation of multi-dimensional arrays, recursively handling nested arrays.
- **`Arrays.asList`**: Converts an array to a fixed-size list for easier manipulation with collection APIs.
- **`Arrays.stream`**: Converts an array into a `Stream`, allowing for functional-style operations like filtering and mapping.
- **`Arrays.parallelSort`**: Sorts an array in parallel, which can be more efficient for large arrays.

These methods are useful tools for array manipulation and processing in Java, helping with sorting, searching, copying, and converting array data.

# Java Exercises Array Pragramming

### 1. Write a Java program to sort a numeric array and a string array.
```java
// Import the necessary class from the Java utility library.
import java.util.Arrays;

// Define a class named Exercise1.
public class Exercise1 {
    // The main method where the program execution starts.
    public static void main(String[] args) {
        
        // Declare and initialize an integer array.
        int[] my_array1 = {
            1789, 2035, 1899, 1456, 2013, 
            1458, 2458, 1254, 1472, 2365, 
            1456, 2165, 1457, 2456
        };
        
        // Declare and initialize a string array.
        String[] my_array2 = {
            "Java",
            "Python",
            "PHP",
            "C#",
            "C Programming",
            "C++"
        };        
        
        // Print the original numeric array.
        System.out.println("Original numeric array : " + Arrays.toString(my_array1));
        
        // Sort the numeric array in ascending order.
        Arrays.sort(my_array1);
        
        // Print the sorted numeric array.
        System.out.println("Sorted numeric array : " + Arrays.toString(my_array1));
        
        // Print the original string array.
        System.out.println("Original string array : " + Arrays.toString(my_array2));
        
        // Sort the string array in lexicographical (alphabetical) order.
        Arrays.sort(my_array2);
        
        // Print the sorted string array.
        System.out.println("Sorted string array : " + Arrays.toString(my_array2));
    }
}
```
Sample Output:

Original numeric array : [1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456] 
Sorted numeric array : [1254, 1456, 1456, 1457, 1458, 1472, 1789, 1899, 2013, 2035, 2165, 2365, 2456, 2458]   
Original string array : [Java, Python, PHP, C#, C Programming, C++]                                           
Sorted string array : [C Programming, C#, C++, Java, PHP, Python] 

### 2. Write a Java program to sum values of an array.
```java
// Define a class named Exercise2.
public class Exercise2 {
    // The main method where the program execution starts.
    public static void main(String[] args) {      
        // Declare and initialize an integer array.
        int my_array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Declare and initialize a variable to store the sum.
        int sum = 0;
        
        // Iterate over each element of the array using an enhanced for loop.
        for (int i : my_array)
            // Add each element to the sum.
            sum += i;
        
        // Print the sum of the array elements.
        System.out.println("The sum is " + sum);
    }
}
```
Sample Output:

The sum is 55 

### 3. Write a Java program to print the following grid.

Expected Output :

- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -                                                                                           
- - - - - - - - - -  
```java
// Define a class named Main.
public class Main {
    // The main method where the program execution starts.
    public static void main(String[] args) {   
        // Declare a two-dimensional integer array 'a' with dimensions 10x10.
        int[][] a = new int[10][10];    
        
        // Use nested loops to iterate over each row and column of the array.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Print each element of the array, ensuring a minimum width of 2 characters.
                System.out.printf("%2d ", a[i][j]);
            }
            // Move to the next line to represent a new row in the output.
            System.out.println();
        }
    }
}
```
Sample Output:

0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 
 0  0  0  0  0  0  0  0  0  0 

### 4. Write a Java program to calculate the average value of array elements.
```java
// Define a class named Exercise4.
public class Exercise4 {
    // The main method where the program execution starts.
    public static void main(String[] args) {   
        // Declare an integer array 'numbers' and initialize it with values.
        int[] numbers = new int[]{20, 30, 25, 35, -16, 60, -100};
        
        // Initialize a variable 'sum' to store the sum of array elements.
        int sum = 0;
        
        // Use a for loop to iterate over the elements of the 'numbers' array.
        for (int i = 0; i < numbers.length; i++) {
            // Add the current element to the sum.
            sum = sum + numbers[i];
        }
        
        // Calculate the average value by dividing the sum by the number of elements.
        double average = sum / numbers.length;
        
        // Print the calculated average value to the console.
        System.out.println("Average value of the array elements is : " + average); 
    }
}
```
Sample Output:

Average value of the array elements is : 7.0 

### 5. Write a Java program to test if an array contains a specific value.
```java
// Define a class named Exercise5.
public class Exercise5 {
   // Define a method 'contains' that checks if an integer array 'arr' contains a given 'item'.
   public static boolean contains(int[] arr, int item) {
      // Iterate through each element 'n' in the array 'arr'.
      for (int n : arr) {
         // Check if 'item' is equal to the current element 'n'.
         if (item == n) {
            // If a match is found, return 'true'.
            return true;
         }
      }
      // If no match is found, return 'false'.
      return false;
   }
   
   // The main method where the program execution starts.
   public static void main(String[] args) {
      // Declare an integer array 'my_array1' and initialize it with values.
      int[] my_array1 = {
         1789, 2035, 1899, 1456, 2013, 
         1458, 2458, 1254, 1472, 2365, 
         1456, 2265, 1457, 2456
      };
      
      // Check if the integer array 'my_array1' contains the item 2013 and print the result.
      System.out.println(contains(my_array1, 2013));
      
      // Check if the integer array 'my_array1' contains the item 2015 and print the result.
      System.out.println(contains(my_array1, 2015));
   }
}
```
Sample Output:

true                                                                                                       
false 

### 6. Write a Java program to find the index of an array element.
```java
import java.util.OptionalInt;
// Define a class named Main.
public class Main {
    // Define a method 'findIndex' that searches for an integer 't' in an integer array 'my_array'.
    public static OptionalInt findIndex(int[] my_array, int t) {
        // Check if the array is null and return an empty OptionalInt if it is.
        if (my_array == null)
            return OptionalInt.empty();
        // Get the length of the array.
        int len = my_array.length;
        int i = 0;
        // Iterate through the elements in the array.
        while (i < len) {
            // Check if the current element is equal to 't' and return its index as an OptionalInt if found.
            if (my_array[i] == t)
                return OptionalInt.of(i);
            else
                i = i + 1;
        }
        // If 't' is not found in the array, return an empty OptionalInt.
        return OptionalInt.empty();
    }
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare an integer array 'my_array' and initialize it with values.
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        // Find and print the index position of value 25 in the array.
        findIndex(my_array, 25).ifPresent(index -> System.out.println("Index position of 25 is: " + index));
        // Find and print the index position of value 877 in the array.
        findIndex(my_array, 877).ifPresent(index -> System.out.println("Index position of 877 is: " + index));
        // Find and print the index position of value 29 in the array.
        findIndex(my_array, 29).ifPresent(index -> System.out.println("Index position of 29 is: " + index));
    }
}
```
Sample Output:

Index position of 25 is: 0                                                                                    
Index position of 29 is: 8 
Note:

'java.util.OptionalInt' is a class introduced in Java 8 as part of the 'java.util' package. It is part of the broader 'java.util.Optional' family of classes, which includes 'OptionalInt', OptionalLong, and OptionalDouble for handling optional values of primitive types. The 'OptionalInt' class is designed to represent an optional 'int' value, meaning it can either contain an 'int' value or be empty. It is useful in cases where a method might not always produce a valid result. You want to make it clear that the results may not be available.


Some key methods provided by 'OptionalInt' include:

of(int value): Returns an 'OptionalInt' with the specified value if it is non-null; otherwise, it throws a 'NullPointerException'.
empty(): Returns an empty 'OptionalInt'.
isPresent(): Returns 'true' if there is a value present; otherwise, returns 'false'.
ifPresent(IntConsumer action): If a value is present, performs the given action with the value; otherwise, does nothing.
orElse(int other): Returns the value if present; otherwise, returns the specified other value.
By using 'OptionalInt', we can avoid using special values like -1 to represent the absence of a result. This makes our code more expressive and reducing misinterpretation.

### 7. Write a Java program to remove a specific element from an array.
```java
// Import the Arrays class from the java.util package.
import java.util.Arrays;

// Define a class named Exercise7.
public class Exercise7 {
 
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize an integer array 'my_array'.
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
   
        // Print the original array using Arrays.toString() method.
        System.out.println("Original Array : " + Arrays.toString(my_array));     
   
        // Define the index of the element to be removed (second element, index 1, value 14).
        int removeIndex = 1;

        // Loop to remove the element at the specified index.
        for (int i = removeIndex; i < my_array.length - 1; i++) {
            my_array[i] = my_array[i + 1];
        }
        
        // Print the modified array after removing the second element.
        System.out.println("After removing the second element: " + Arrays.toString(my_array));
    }
} 
```
Sample Output:

Original Array : [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]                                                     
After removing the second element: [25, 56, 15, 36, 56, 77, 18, 29, 49, 49] 

```java
public class RemoveElementFromArray {

    // Method to remove a specific element from an array
    public static int[] removeElement(int[] originalArray, int elementToRemove) {
        // Count occurrences of the element to remove
        int count = 0;
        for (int num : originalArray) {
            if (num == elementToRemove) {
                count++;
            }
        }

        // If the element is not found, return the original array
        if (count == 0) {
            return originalArray;
        }

        // Create a new array with a size reduced by the count of elements to be removed
        int[] newArray = new int[originalArray.length - count];
        int index = 0;

        // Copy elements that are not the one to be removed
        for (int num : originalArray) {
            if (num != elementToRemove) {
                newArray[index++] = num;
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 2, 5, 2, 6};
        int elementToRemove = 2;

        System.out.println("Original Array:");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] modifiedArray = removeElement(originalArray, elementToRemove);

        System.out.println("Array After Removing Element " + elementToRemove + ":");
        for (int num : modifiedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```
### 8. Write a Java program to copy an array by iterating the array.
```java
// Import the Arrays class from the java.util package.
import java.util.Arrays; 

// Define a class named Exercise8.
public class Exercise8 {
    
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize an integer array 'my_array'.
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        
        // Declare and initialize a new integer array 'new_array' with the same size.
        int[] new_array = new int[10];     
 
        // Print the source array using Arrays.toString() method.
        System.out.println("Source Array : " + Arrays.toString(my_array));     
        
        // Loop to copy elements from the source array to the new array.
        for (int i = 0; i < my_array.length; i++) {
            new_array[i] = my_array[i];
        }
        
        // Print the new array containing copied elements.
        System.out.println("New Array: " + Arrays.toString(new_array));
    }
}
```
Sample Output:

Source Array : [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]                                                       
New Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]

### 9. Write a Java program to insert an element (specific position) into an array.
```java
// Import the Arrays class from the java.util package.
import java.util.Arrays; 

// Define a class named Exercise9.
public class Exercise9 {
    
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize an integer array 'my_array'.
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        
        // Define the position where the new element will be inserted.
        int Index_position = 2;
        
        // Define the value of the new element to be inserted.
        int newValue = 5;

        // Print the original array using Arrays.toString() method.
        System.out.println("Original Array : " + Arrays.toString(my_array));     
        
        // Loop to shift elements to make space for the new element.
        for (int i = my_array.length - 1; i > Index_position; i--) {
            my_array[i] = my_array[i - 1];
        }
        
        // Insert the new element at the specified position.
        my_array[Index_position] = newValue;
        
        // Print the modified array with the new element.
        System.out.println("New Array: " + Arrays.toString(my_array));
    }
}
```
Sample Output:

Original Array : [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]                                                     
New Array: [25, 14, 5, 56, 15, 36, 56, 77, 18, 29] 

### 10. Write a Java program to find the maximum and minimum value of an array.
```java
// Import the Arrays class from the java.util package.
import java.util.Arrays; 

// Define a class named Exercise10.
public class Exercise10 {
    
    // Declare static variables to store the maximum and minimum values.
    static int max;
    static int min;

    // Define a method to calculate the maximum and minimum values in the array.
    public static void max_min(int my_array[]) {
        // Initialize max and min with the first element of the array.
        max = my_array[0];
        min = my_array[0];
        int len = my_array.length;

        // Iterate through the array in pairs.
        for (int i = 1; i < len - 1; i = i + 2) {
            // Check if there's only one element left in the pair.
            if (i + 1 > len) {
                // Update max and min based on the single element.
                if (my_array[i] > max) max = my_array[i];
                if (my_array[i] < min) min = my_array[i];
            }

            // Compare and update max and min within the pair of elements.
            if (my_array[i] > my_array[i + 1]) {
                if (my_array[i] > max) max = my_array[i];
                if (my_array[i + 1] < min) min = my_array[i + 1];
            }
            if (my_array[i] < my_array[i + 1]) {
                if (my_array[i] < min) min = my_array[i];
                if (my_array[i + 1] > max) max = my_array[i + 1];
            }
        }
    }

    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize an integer array 'my_array'.
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        
        // Call the max_min method to calculate the maximum and minimum values.
        max_min(my_array);
        
        // Print the original array using Arrays.toString() method.
        System.out.println("Original Array: " + Arrays.toString(my_array));
        
        // Print the maximum and minimum values.
        System.out.println("Maximum value for the above array = " + max);
        System.out.println("Minimum value for the above array = " + min);
    }
}
```
Sample Output:

Original Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]                                                     
 Maximum value for the above array = 77                                                                       
 Minimum value for the above array = 14 

### 11. Write a Java program to reverse an array of integer values.
```java
// Import the Arrays class from the java.util package.
import java.util.Arrays;

// Define a class named Exercise11.
public class Exercise11 {
    
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize an integer array 'my_array1'.
        int[] my_array1 = {
            1789, 2035, 1899, 1456, 2013, 
            1458, 2458, 1254, 1472, 2365, 
            1456, 2165, 1457, 2456
        };
        
        // Print the original array using Arrays.toString() method.
        System.out.println("Original array : " + Arrays.toString(my_array1));  
        
        // Iterate through the first half of the array and reverse its elements.
        for (int i = 0; i < my_array1.length / 2; i++) {
            // Swap the elements at positions 'i' and 'length - i - 1'.
            int temp = my_array1[i];
            my_array1[i] = my_array1[my_array1.length - i - 1];
            my_array1[my_array1.length - i - 1] = temp;
        }
        
        // Print the reversed array using Arrays.toString() method.
        System.out.println("Reverse array : " + Arrays.toString(my_array1));
    }
}
```
Sample Output:

Original array : [1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456]         
Reverse array : [2456, 1457, 2165, 1456, 2365, 1472, 1254, 2458, 1458, 2013, 1456, 1899, 2035, 1789]

### 12. Write a Java program to find duplicate values in an array of integer values.
```java
// Import the Arrays class from the java.util package.
import java.util.Arrays;

// Define a class named Exercise12.
public class Exercise12 {
    
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize an integer array 'my_array'.
        int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2};
 
        // Iterate through the elements of the array.
        for (int i = 0; i < my_array.length-1; i++) {
            for (int j = i+1; j < my_array.length; j++) {
                // Check if two elements are equal and not the same element.
                if ((my_array[i] == my_array[j]) && (i != j)) {
                    // If a duplicate is found, print the duplicate element.
                    System.out.println("Duplicate Element : " + my_array[j]);
                }
            }
        }
    }    
}
```
Sample Output:

Duplicate Element : 2                                                                                         
Duplicate Element : 5                                                                                         
Duplicate Element : 6

### 13. Write a Java program to find duplicate values in an array of string values.
```java
// Define a class named Exercise13.
public class Exercise13 {
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize a string array 'my_array'.
        String[] my_array = {"bcd", "abd", "jude", "bcd", "oiu", "gzw", "oiu"};
 
        // Iterate through the elements of the string array.
        for (int i = 0; i < my_array.length-1; i++) {
            for (int j = i+1; j < my_array.length; j++) {
                // Check if two string elements are equal and not the same element.
                if ((my_array[i].equals(my_array[j])) && (i != j)) {
                    // If a duplicate is found, print the duplicate element.
                    System.out.println("Duplicate Element is : " + my_array[j]);
                }
            }
        }
    }    
}
```
Sample Output:

Duplicate Element is : bcd                                                                                    
Duplicate Element is : oiu

### 14. Write a Java program to find common elements between two arrays (string values).
```java
// Import the necessary Java utilities package.
import java.util.*;

// Define a class named Exercise14.
public class Exercise14 {
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize two string arrays, array1 and array2.
        String[] array1 = {"Python", "JAVA", "PHP", "C#", "C++", "SQL"};
        String[] array2 = {"MySQL", "SQL", "SQLite", "Oracle", "PostgreSQL", "DB2", "JAVA"};

        // Print the original contents of array1 and array2.
        System.out.println("Array1 : " + Arrays.toString(array1));
        System.out.println("Array2 : " + Arrays.toString(array2));

        // Create a HashSet to store common elements.
        HashSet set = new HashSet();

        // Iterate through both arrays to find and store common elements.
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                // Check if elements in array1 and array2 are equal.
                if (array1[i].equals(array2[j])) {
                    // Add the common element to the HashSet.
                    set.add(array1[i]);
                }
            }
        }

        // Print the common elements.
        System.out.println("Common element : " + (set)); // OUTPUT: [SQL, JAVA]
    }
}
```
Sample Output:

Array1 : [Python, JAVA, PHP, C#, C++, SQL]                                                                    
Array2 : [MySQL, SQL, SQLite, Oracle, PostgreSQL, DB2, JAVA]                                                  
Common element is : [JAVA, SQL]

### 15. Write a Java program to find common elements between two integer arrays.
```java
// Import the necessary Java utilities package.
import java.util.Arrays;
// Define a class named Exercise15.
public class Exercise15 {
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Declare and initialize two integer arrays, array1 and array2.
        int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};

        // Print the original contents of array1 and array2.
        System.out.println("Array1 : " + Arrays.toString(array1));
        System.out.println("Array2 : " + Arrays.toString(array2));

        // Iterate through both arrays to find and print common elements.
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                // Check if elements in array1 and array2 are equal.
                if (array1[i] == (array2[j])) {
                    // Print the common element.
                    System.out.println("Common element is : " + (array1[i]));
                }
            }
        }
    }
}
```
Sample Output:

Array1 : [1, 2, 5, 5, 8, 9, 7, 10]                                                                            
Array2 : [1, 0, 6, 15, 6, 4, 7, 0]                                                                            
Common element is : 1                                                                                         
Common element is : 7

### 16. Write a Java program to remove duplicate elements from an array.
```java
// Import the necessary Java utilities package.
import java.util.Arrays;
 
// Define a class named Exercise16.
public class Exercise16 {
   // Define a method to find and print unique elements in an array.
   static void unique_array(int[] my_array) {
        System.out.println("Original Array : ");
         
        // Iterate through the original array and print its contents.
        for (int i = 0; i < my_array.length; i++) {
            System.out.print(my_array[i] + "\t");
        }
         
        // Assuming all elements in the input array are unique.
        int no_unique_elements = my_array.length;
         
        // Comparing each element with all other elements to find duplicates.
        for (int i = 0; i < no_unique_elements; i++) {
            for (int j = i + 1; j < no_unique_elements; j++) {
                // If any two elements are found equal (a duplicate is found).
                if (my_array[i] == my_array[j]) {
                    // Replace the duplicate element with the last unique element.
                    my_array[j] = my_array[no_unique_elements - 1];
                    no_unique_elements--;
                    j--;
                }
            }
        }
         
        // Copying only unique elements of my_array into array1.
        int[] array1 = Arrays.copyOf(my_array, no_unique_elements);
         
        // Printing the array with unique values.
        System.out.println();
        System.out.println("Array with unique values : ");
         
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
         
        System.out.println();
        System.out.println("---------------------------");
    }
     
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Call the unique_array method with two different sets of input arrays.
        unique_array(new int[] {0, 3, -2, 4, 3, 2});
        unique_array(new int[] {10, 22, 10, 20, 11, 22});
    }
}
```
Sample Output:

Original Array :                                                                                              
0       3       -2      4       3       2                                                                     
Array with unique values :                                                                                    
0       3       -2      4       2                                                                             
---------------------------                                                                                   
Original Array :                                                                                              
10      22      10      20      11      22                                                                    
Array with unique values :                                                                                    
10      22      11      20                                                                                    
---------------------------

### 17. Write a Java program to find the second largest element in an array.
```java
// Import the necessary Java utilities package.
import java.util.Arrays;

// Define a class named Main.
public class Main {
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Create an integer array with numeric values.
        int[] my_array = {
            10789, 2035, 1899, 1456, 2013, 
            1458, 2458, 1254, 1472, 2365, 
            1456, 2165, 1457, 2456};
        
        // Print the original numeric array.
        System.out.println("Original numeric array : " + Arrays.toString(my_array));
        
        // Sort the array to find the second largest value.
        Arrays.sort(my_array);
        
        // Initialize an index to the last element's index.
        int index = my_array.length - 1;
        
        // Find the second largest value by iterating from the end of the array.
        while (my_array[index] == my_array[my_array.length - 1]) {
            index--;
        }
        
        // Print the second largest value found.
        System.out.println("Second largest value: " + my_array[index]);
    }
}
```
Sample Output:

Original numeric array : [10789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456]
Second largest value: 2458

### 18. Write a Java program to find the second smallest element in an array.
```java
// Import the necessary Java utilities package.
import java.util.Arrays;

// Define a class named Exercise18.
public class Exercise18 {
    // The main method where the program execution starts.
    public static void main(String[] args) {
        // Create an integer array with numeric values.
        int[] my_array = {-1, 4, 0, 2, 7, -3};
        
        // Print the original numeric array.
        System.out.println("Original numeric array : " + Arrays.toString(my_array));
        
        // Initialize variables to find the minimum and second minimum values.
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        
        // Iterate through the array to find the second lowest number.
        for (int i = 0; i < my_array.length; i++) {
            if (my_array[i] == min) {
                // If the current element equals the minimum, update the second minimum.
                second_min = min;
            } else if (my_array[i] < min) {
                // If the current element is less than the minimum, update both minimum and second minimum.
                second_min = min;
                min = my_array[i];
            } else if (my_array[i] < second_min) {
                // If the current element is less than the second minimum, update the second minimum.
                second_min = my_array[i];
            }
        }

        // Print the second lowest number found.
        System.out.println("Second lowest number is : " + second_min);
    }
}
``` 
Sample Output:

Original numeric array : [-1, 4, 0, 2, 7, -3]                                                                 
Second lowest number is : -1 

### 19. Write a Java program to add two matrices of the same size.
```java
// Import the Java utility for reading input.
import java.util.Scanner;

// Define a class named Exercise19.
public class Exercise19 {
    public static void main(String args[]) {
        int m, n, c, d;
        
        // Create a new Scanner object to read user input.
        Scanner in = new Scanner(System.in);

        // Prompt the user to input the number of rows for the matrix.
        System.out.println("Input number of rows of the matrix");
        m = in.nextInt();
        
        // Prompt the user to input the number of columns for the matrix.
        System.out.println("Input number of columns of the matrix");
        n = in.nextInt();

        // Create two-dimensional arrays to store matrix data.
        int array1[][] = new int[m][n];
        int array2[][] = new int[m][n];
        int sum[][] = new int[m][n];

        // Prompt the user to input elements of the first matrix.
        System.out.println("Input elements of the first matrix");
        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                array1[c][d] = in.nextInt();
            }
        }

        // Prompt the user to input elements of the second matrix.
        System.out.println("Input elements of the second matrix");
        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                array2[c][d] = in.nextInt();
            }
        }

        // Calculate the sum of the matrices.
        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                sum[c][d] = array1[c][d] + array2[c][d];
            }
        }

        // Display the result, which is the sum of the matrices.
        System.out.println("Sum of the matrices:");
        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                System.out.print(sum[c][d] + "\t");
            }
            System.out.println();
        }
    }
}
```
Sample Output:

Input number of rows of matrix                                                                                
2                                                                                                
Input number of columns of matrix                                                                             
2                                                                                                
Input elements of first matrix                                                                                
1                                                                                                
2                                                                                                
3                                                                                                
4                                                                                                
Input the elements of second matrix                                                                           
5                                                                                                
6                                                                                                
7                                                                                                
8                                                                                                
Sum of the matrices:-                                                                                         
6       8                                                                                                
10      12 

### 20. Write a Java program to convert an array to an ArrayList.
```java
// Import the ArrayList and Arrays classes from the Java utility library.
import java.util.ArrayList;
import java.util.Arrays;

// Define a class named Exercise20.
public class Exercise20 {
    public static void main(String[] args) {
        // Create an array of strings.
        String[] my_array = new String[] {"Python", "JAVA", "PHP", "Perl", "C#", "C++"};

        // Create an ArrayList of strings and initialize it with the contents of the array.
        ArrayList list = new ArrayList(Arrays.asList(my_array));

        // Print the ArrayList to the console.
        System.out.println(list);
    }
}
```
Sample Output:

[Python, JAVA, PHP, Perl, C#, C++] 

### 21. Write a Java program to convert an ArrayList to an array.
```java
// Import the ArrayList and Arrays classes from the Java utility library.
import java.util.ArrayList;
import java.util.Arrays;

// Define a class named Exercise21.
public class Exercise21 {
    public static void main(String[] args) {
        // Create a new ArrayList of strings.
        ArrayList<String> list = new ArrayList<String>();

        // Add strings to the ArrayList.
        list.add("Python");
        list.add("Java");
        list.add("PHP");
        list.add("C#");
        list.add("C++");
        list.add("Perl");

        // Create a new string array with the same size as the ArrayList.
        String[] my_array = new String[list.size()];

        // Convert the ArrayList to an array and store it in my_array.
        list.toArray(my_array);

        // Iterate through the elements of the string array and print each element.
        for (String string : my_array) {
            System.out.println(string);
        }
    }
}
```
Sample Output:

Python                                                                                                
Java                                                                                                
PHP                                                                                                
C#                                                                                                
C++                                                                                                
Perl 

### 22. Write a Java program to find all pairs of elements in an array whose sum is equal to a specified number.
```java
// Define a class named Exercise22.
public class Exercise22 {
    // Create a static method named pairs_value that takes an integer array and an input number.
    static void pairs_value(int inputArray[], int inputNumber) {
        System.out.println("Pairs of elements and their sum : ");

        // Iterate through the elements of the inputArray.
        for (int i = 0; i < inputArray.length; i++) {
            // Iterate through the elements following the current i.
            for (int j = i + 1; j < inputArray.length; j++) {
                // Check if the sum of inputArray[i] and inputArray[j] equals the inputNumber.
                if (inputArray[i] + inputArray[j] == inputNumber) {
                    // Print the pair of elements and their sum.
                    System.out.println(inputArray[i] + " + " + inputArray[j] + " = " + inputNumber);
                }
            }
        }
    }

    // The main method for executing the program.
    public static void main(String[] args) {
        // Call the pairs_value method with a sample array and input number.
        pairs_value(new int[]{2, 7, 4, -5, 11, 5, 20}, 15);

        // Call the pairs_value method with another sample array and input number.
        pairs_value(new int[]{14, -15, 9, 16, 25, 45, 12, 8}, 30);
    }
}
```
Sample Output:

Pairs of elements and their sum :                                                                             
4 + 11 = 15                                                                                                
-5 + 20 = 15                                                                                                
Pairs of elements and their sum :                                                                             
14 + 16 = 30                                                                                                
-15 + 45 = 30 

### 23. Write a Java program to test two arrays' equality.
```java
// Define a class named Exercise23.
public class Exercise23 {
    // Create a static method named equality_checking_two_arrays that takes two integer arrays.
    static void equality_checking_two_arrays(int[] my_array1, int[] my_array2) {
        // Initialize a boolean variable to indicate whether the arrays are equal.
        boolean equalOrNot = true;

        // Check if the lengths of the two arrays are equal.
        if (my_array1.length == my_array2.length) {
            // Iterate through elements of both arrays.
            for (int i = 0; i < my_array1.length; i++) {
                // Check if the elements at the same position in both arrays are not equal.
                if (my_array1[i] != my_array2[i]) {
                    equalOrNot = false;
                }
            }
        } else {
            // If the lengths are not equal, set equalOrNot to false.
            equalOrNot = false;
        }

        // Check the value of equalOrNot and print whether the arrays are equal or not.
        if (equalOrNot) {
            System.out.println("Two arrays are equal.");
        } else {
            System.out.println("Two arrays are not equal.");
        }
    }

    // The main method for executing the program.
    public static void main(String[] args) {
        // Define three integer arrays for comparison.
        int[] array1 = {2, 5, 7, 9, 11};
        int[] array2 = {2, 5, 7, 8, 11};
        int[] array3 = {2, 5, 7, 9, 11};

        // Call the equality_checking_two_arrays method to compare array1 and array2.
        equality_checking_two_arrays(array1, array2);

        // Call the equality_checking_two_arrays method to compare array1 and array3.
        equality_checking_two_arrays(array1, array3);
    }
}
```
Sample Output:

Two arrays are not equal.                                                                                     
Two arrays are equal.

### 24. Write a Java program to find a missing number in an array.
```java
// Import the java.util package to use utility classes, including Scanner.
import java.util.*;

// Define a class named Exercise24.
public class Exercise24 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare variables for total number and an array of integers.
        int total_num;
        int[] numbers = new int[]{1, 2, 3, 4, 6, 7};

        // Assign the value 7 to the variable total_num.
        total_num = 7;

        // Calculate the expected sum of numbers using the arithmetic sum formula.
        int expected_num_sum = total_num * ((total_num + 1) / 2);

        // Initialize a variable to store the sum of numbers.
        int num_sum = 0;

        // Iterate through the elements of the 'numbers' array.
        for (int i : numbers) {
            // Add each element to the 'num_sum' variable.
            num_sum += i;
        }

        // Calculate the missing number by subtracting 'num_sum' from 'expected_num_sum'.
        System.out.print(expected_num_sum - num_sum);

        // Print a newline character to end the line.
        System.out.print("\n");
    }
}
```
Sample Data: 1,2,3,4,6,7

Sample Output:

                                                                              
5

### 25. Write a Java program to find common elements in three sorted (in non-decreasing order) arrays.
```java
// Import the java.util package to use utility classes, including ArrayList.
import java.util.*;

// Define a class named Exercise25.
public class Exercise25 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Create an ArrayList to store common elements.
        ArrayList common = new ArrayList();

        // Declare three arrays of integers.
        int array1[] = {2, 4, 8};
        int array2[] = {2, 3, 4, 8, 10, 16};
        int array3[] = {4, 8, 14, 40};

        // Initialize three index variables for each array.
        int x = 0, y = 0, z = 0;

        // Use a while loop to compare elements of the three arrays.
        while (x < array1.length && y < array2.length && z < array3.length) {
            // Check if the elements at the current positions in all arrays are equal.
            if (array1[x] == array2[y] && array2[y] == array3[z]) {
                // If they are equal, add the element to the 'common' ArrayList and increment all indices.
                common.add(array1[x]);
                x++;
                y++;
                z++;
            } else if (array1[x] < array2[y]) {
                // If the element in the first array is smaller, increment the index of the first array.
                x++;
            } else if (array2[y] < array3[z]) {
                // If the element in the second array is smaller, increment the index of the second array.
                y++;
            } else {
                // If the element in the third array is smaller, increment the index of the third array.
                z++;
            }
        }

        // Print the common elements found in the three sorted arrays.
        System.out.println("Common elements from three sorted (in non-decreasing order) arrays: ");
        System.out.println(common);
    }
}
```
Sample Data: array1 = 2, 4, 8
array2 = 2, 3, 4, 8, 10, 16
array3 = 4, 8, 14, 40

Sample Output:

                                                                              
Common elements from three sorted (in non-decreasing order ) arrays:   
[4, 8]

### 26. Write a Java program to move all 0's to the end of an array. Maintain the relative order of the other (non-zero) array elements.
```java
// Import the java.util package to use utility classes, including Arrays.
import java.util.*;

// Define a class named Exercise26.
public class Exercise26 {
    // The main method for executing the program.
    public static void main(String[] args) throws Exception {
        // Declare and initialize an array of integers.
        int[] array_nums = {0, 0, 1, 0, 3, 0, 5, 0, 6};
        int i = 0;

        // Print the original array.
        System.out.print("\nOriginal array: \n");
        for (int n : array_nums)
            System.out.print(n + "  ");

        // Use a loop to move zeros to the end of the array.
        for (int j = 0, l = array_nums.length; j < l;) {
            if (array_nums[j] == 0)
                j++;
            else {
                // Swap the non-zero element with the first available zero.
                int temp = array_nums[i];
                array_nums[i] = array_nums[j];
                array_nums[j] = temp;
                i++;
                j++;
            }
        }

        // Fill the remaining positions with zeros.
        while (i < array_nums.length)
            array_nums[i++] = 0;

        // Print the array after moving zeros to the end.
        System.out.print("\nAfter moving 0's to the end of the array: \n");
        for (int n : array_nums)
            System.out.print(n + "  ");
        System.out.print("\n");
    }
}
```
Sample Output:

                                                                              
Original array:                                                        
0  0  1  0  3  0  5  0  6                                              
After moving 0's to the end of the array:                              
1  3  5  6  0  0  0  0  0 

### 27. Write a Java program to find the number of even and odd integers in a given array of integers.
```java
// Import the java.util package to use utility classes, including Arrays.
import java.util.Arrays;

// Define a class named Exercise27.
public class Exercise27 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare and initialize an array of integers.
        int[] array_nums = {5, 7, 2, 4, 9};

        // Print the original array.
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Initialize a counter variable for even numbers.
        int ctr = 0;

        // Use a loop to iterate through the array elements and count even numbers.
        for (int i = 0; i < array_nums.length; i++) {
            if (array_nums[i] % 2 == 0)
                ctr++;
        }

        // Print the number of even and odd numbers in the array.
        System.out.println("Number of even numbers : " + ctr);
        System.out.println("Number of odd numbers  : " + (array_nums.length - ctr));
    }
}
```
Sample Output:

                                                                              
Original Array: [5, 7, 2, 4, 9]                                        
Number of even numbers : 2                                             
Number of odd numbers  : 3 

### 28. Write a Java program to get the difference between the largest and smallest values in an array of integers. The array must have a length of at least 1.
```java
// Import the java.util package to use utility classes, including Arrays.
import java.util.Arrays;

// Define a class named Exercise28.
public class Exercise28 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare and initialize an array of integers.
        int[] array_nums = {5, 7, 2, 4, 9};

        // Print the original array.
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Initialize variables to store the maximum and minimum values.
        int max_val = array_nums[0];
        int min = array_nums[0];

        // Use a loop to find the maximum and minimum values in the array.
        for (int i = 1; i < array_nums.length; i++) {
            if (array_nums[i] > max_val)
                max_val = array_nums[i];
            else if (array_nums[i] < min)
                min = array_nums[i];
        }

        // Calculate and print the difference between the largest and smallest values.
        System.out.println("Difference between the largest and smallest values of the said array: " + (max_val - min));
    }
}
```
Sample Output:

                                                                              
Original Array: [5, 7, 2, 4, 9]                                        
Difference between the largest and smallest values of the said array: 7

### 29. Write a Java program to compute the average value of an array of integers except the largest and smallest values.
```java
// Import the java.util package to use utility classes, including Arrays.
import java.util.*;

// Import the java.io package to use input and output classes.
import java.io.*;

// Define a class named Exercise29.
public class Exercise29 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare and initialize an array of integers.
        int[] array_nums = {5, 7, 2, 4, 9};

        // Print the original array.
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Initialize variables for maximum, minimum, and sum.
        int max = array_nums[0];
        int min = array_nums[0];
        float sum = array_nums[0];

        // Use a loop to find the maximum, minimum, and calculate the sum of the array elements.
        for (int i = 1; i < array_nums.length; i++) {
            sum += array_nums[i];
            if (array_nums[i] > max)
                max = array_nums[i];
            else if (array_nums[i] < min)
                min = array_nums[i];
        }

        // Calculate the average value of the array except for the largest and smallest values.
        float x = ((sum - max - min) / (array_nums.length - 2));

        // Print the calculated average value with two decimal places.
        System.out.printf("Compute the average value of an array of integers except the largest and smallest values: %.2f", x);

        // Print a new line.
        System.out.print("\n");
    }
}
```
Sample Output:

                                                                              
Original Array: [5, 7, 2, 4, 9]                                        
Compute the average value of an array of integers except the largest an
d smallest values: 5.33

### 30. Write a Java program to check if an array of integers is without 0 and -1.
```java
// Import the java.util package to use utility classes, including Arrays.
import java.util.*;

// Import the java.io package to use input and output classes.
import java.io.*;

// Define a class named Exercise30.
public class Exercise30 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare and initialize an array of integers.
        int[] array_nums = {50, 77, 12, 54, -11};

        // Print the original array.
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Call the test method with the array as an argument and print the result.
        System.out.println("Result: " + test(array_nums));
    }

    // Define a method named test that takes an array of integers as input.
    public static boolean test(int[] numbers) {
        // Use an enhanced for loop to iterate through the array elements.
        for (int number : numbers) {
            // Check if the current number is 0 or -1.
            if (number == 0 || number == -1) {
                // If any number is 0 or -1, return false.
                return false;
            }
        }
        // If no number is 0 or -1, return true.
        return true;
    }
}
```
Sample Output:

                                                                              
Original Array: [50, 77, 12, 54, -11]                                  
Result: true

### 31. Write a Java program to check if the sum of all the 10's in the array is exactly 30. Return false if the condition does not satisfy, otherwise true.
```java
// Import the java.util package to use utility classes, including Arrays.
import java.util.*;

// Import the java.io package to use input and output classes.
import java.io.*;

// Define a class named Exercise31.
public class Exercise31 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare and initialize an array of integers.
        int[] array_nums = {10, 77, 10, 54, -11, 10};

        // Print the original array.
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Define the search number and the fixed sum.
        int search_num = 10;
        int fixed_sum = 30;

        // Call the result method with the array, search number, and fixed sum as arguments and print the result.
        System.out.println("Result: " + result(array_nums, search_num, fixed_sum));
    }	

    // Define a method named result that takes an array of integers, a search number, and a fixed sum as inputs.
    public static boolean result(int[] numbers, int search_num, int fixed_sum) {
        // Initialize a temporary sum.
        int temp_sum = 0;

        // Use an enhanced for loop to iterate through the array elements.
        for (int number : numbers) {
            // Check if the current number is equal to the search number.
            if (number == search_num) {
                // Add the search number to the temporary sum.
                temp_sum += search_num;
            }

            // Check if the temporary sum exceeds the fixed sum.
            if (temp_sum > fixed_sum) {
                // If the sum exceeds the fixed sum, exit the loop.
                break;
            }
        }

        // Check if the temporary sum is equal to the fixed sum and return the result.
        return temp_sum == fixed_sum;
    }
}
```
Sample Output:

                                                                              
Original Array: [10, 77, 10, 54, -11, 10]                              
Result: true

### 32. Write a Java program to check if an array of integers contains two specified elements 65 and 77.
```java
// Import the java.util package to use utility classes, including Arrays.
import java.util.*;

// Import the java.io package to use input and output classes.
import java.io.*;

// Define a class named Exercise32.
public class Exercise32 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare and initialize an array of integers.
        int[] array_nums = {77, 77, 65, 65, 65, 77};

        // Print the original array.
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Define two numbers to be checked in the array.
        int num1 = 77;
        int num2 = 65;

        // Call the result method with the array and two numbers as arguments and print the result.
        System.out.println("Result: " + result(array_nums, num1, num2));
    }	

    // Define a method named result that takes an array of integers and two numbers as inputs.
    public static boolean result(int[] array_nums, int num1, int num2) {
        // Use an enhanced for loop to iterate through the array elements.
        for (int number : array_nums) {
            // Check if the current number is not equal to num1 and not equal to num2.
            boolean r = number != num1 && number != num2;
            // If the condition is met, return false.
            if (r) {
                return false;
            }
        }
        // If all elements in the array are either num1 or num2, return true.
        return true;
    }
}
```
Sample Output:

                                                                              
Original Array: [77, 77, 65, 65, 65, 77]                               
Result: true

### 33. Write a Java program to remove duplicate elements from a given array and return the updated array length.
Sample array: [20, 20, 30, 40, 50, 50, 50]
After removing the duplicate elements the program should return 4 as the new length of the array. 
```java
// Define a class named Exercise33.
public class Exercise33 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare an array of integers.
        int nums[] = {20, 20, 30, 40, 50, 50, 50};  

        // Print the original array length.
        System.out.println("Original array length: " + nums.length);

        // Print the elements of the array.
        System.out.print("Array elements are: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        // Calculate the new length of the array using the array_sort method and print it.
        System.out.println("\nThe new length of the array is: " + array_sort(nums));
    }

    // Define a method named array_sort that takes an array of integers as input.
    public static int array_sort(int[] nums) {
        // Initialize an index variable to 1.
        int index = 1;
        
        // Iterate through the array, starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is different from the previous element.
            if (nums[i] != nums[index - 1])
                // If different, update the element at the current index.
                nums[index++] = nums[i];
        }
        // Return the new length of the array.
        return index;
    }
}
```
Sample Output:

                                                                              
Original array length: 7                                               
Array elements are: 20 20 30 40 50 50 50                               
The new length of the array is: 4

### 34. Write a Java program to find the length of the longest consecutive elements sequence from an unsorted array of integers.
Sample array: [49, 1, 3, 200, 2, 4, 70, 5]
The longest consecutive elements sequence is [1, 2, 3, 4, 5], therefore the program will return its length 5. 
```java
// Import the HashSet class from the java.util package.
import java.util.HashSet;

// Define a class named Exercise34.
public class Exercise34 {    
    // The main method for executing the program.
    public static void main(String[] args) {
        // Declare an array of integers.
        int nums[] = {49, 1, 3, 200, 2, 4, 70, 5};  

        // Print the original array length.
        System.out.println("Original array length: " + nums.length);

        // Print the elements of the array.
        System.out.print("Array elements are: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        // Calculate the new length of the array using the longest_sequence method and print it.
        System.out.println("\nThe new length of the array is: " + longest_sequence(nums));   
    }
    
    // Define a method named longest_sequence that takes an array of integers as input.
    public static int longest_sequence(int[] nums) {
        // Create a HashSet to store unique values from the input array.
        final HashSet h_set = new HashSet();
        for (int i : nums) {
            h_set.add(i);
        }

        // Initialize a variable to store the length of the longest sequence.
        int longest_sequence_len = 0;

        // Iterate through the elements of the input array.
        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; h_set.contains(j); --j) {
                h_set.remove(j);
                ++length;
            }
            for (int j = i + 1; h_set.contains(j); ++j) {
                h_set.remove(j);
                ++length;
            }
            // Update the longest sequence length if a longer sequence is found.
            longest_sequence_len = Math.max(longest_sequence_len, length);
        }

        // Return the length of the longest sequence.
        return longest_sequence_len;
    }
}
```
Sample Output:

                                                                              
Original array length: 8                                               
Array elements are: 49 1 3 200 2 4 70 5                                
The new length of the array is: 5

### 35. Write a Java program to find the sum of the two elements of a given array equal to a given integer.
Sample array: [1,2,4,5,6]
Target value: 6. 
```java
/ Import the required classes from the java.util package.
import java.util.*;

// Define a class named Exercise35.
public class Exercise35 {
    // Define a method named two_sum_array_target that takes a List of integers and an integer as input.
    public static ArrayList<Integer> two_sum_array_target(final List<Integer> a, int b) {
        // Create a HashMap to store the difference between the target value and array elements.
        HashMap<Integer, Integer> my_map = new HashMap<Integer, Integer>();

        // Create an ArrayList to store the result indices.
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0); // Initialize the first index to 0.
        result.add(1); // Initialize the second index to 1.

        // Iterate through the elements of the input List.
        for (int i = 0; i < a.size(); i++) {
            if (my_map.containsKey(a.get(i))) {
                // If the current element's complement exists in the HashMap, update the result indices and break the loop.
                int index = my_map.get(a.get(i));
                result.set(0, index);
                result.set(1, i);
                break;
            } else {
                // Otherwise, calculate the difference between the target value and the current element and store it in the HashMap.
                my_map.put(b - a.get(i), i);
            }
        }

        // Return the result ArrayList containing the indices.
        return result;
    }

    // The main method for executing the program.
    public static void main(String[] args) {
        // Create an ArrayList of integers and add elements to it.
        ArrayList<Integer> my_array = new ArrayList<Integer>();
        my_array.add(1);
        my_array.add(2);
        my_array.add(4);
        my_array.add(5);
        my_array.add(6);
        int target = 6;

        // Call the two_sum_array_target method to find indices of elements that sum to the target value.
        ArrayList<Integer> result = two_sum_array_target(my_array, target);

        // Print the indices found in the result.
        for (int i : result) {
            System.out.print("Index: " + i + " ");
        }
    }
}
```
Sample Output:

                                                                              
Index: 1 Index: 2

### 36. Write a Java program to find all the distinct triplets such that the sum of all the three elements [x, y, z (x ≤ y ≤ z)] equal to a specified number.
Sample array: [1, -2, 0, 5, -1, -4]
Target value: 2. 
```java
// Import necessary classes from Java libraries.
import java.util.ArrayList;
import java.util.List;

// Define a class named Exercise36.
public class Exercise36 {
    // The main method for executing the program.
    public static void main(String[] args) {
        // Initialize an array of integers.
        int[] input = {1, -2, 0, 5, -1, -4};
        int target = 2;

        // Create an instance of Exercise36.
        Exercise36 r = new Exercise36();

        // Call the threeSum method and print the result.
        System.out.println(r.threeSum(input, target));
    }

    // Define a method named threeSum that takes an array of integers and an integer target as input.
    public List<List<Integer>> threeSum(int[] nums, int target) {
        // Create a List of Lists to store the triplets that sum up to the target.
        List<List<Integer>> my_List = new ArrayList<List<Integer>>();

        // Iterate through the elements of the input array.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    // Check if three distinct elements (i, j, k) sum up to the target.
                    if (i != j && j != k && i != k && (nums[i] + nums[j] + nums[k] == target)) {
                        // Create a List to store the triplet and add it to the result List.
                        List<Integer> inner_List = new ArrayList<Integer>(3);
                        inner_List.add(nums[i]);
                        inner_List.add(nums[j]);
                        inner_List.add(nums[k]);
                        my_List.add(inner_List);
                    }
                }
            }
        }

        // Return the List of triplets that satisfy the condition.
        return my_List;
    }
}
```
Sample Output:

                                                                              
[[1, 5, -4], [-2, 5, -1]] 

### 37. Write a Java program to create an array of its anti-diagonals from a given square matrix. 


Example:
Input :
1 2
3 4
Output:
[
[1],
[2, 3],
[4]
]
```java
//https://github.com/nagajyothi/Arrays/blob/master/Diagonal.java
// Import necessary Java libraries.
import java.util.*;

// Define a class named Exercise37.
public class Exercise37 {
    // A method to compute and return diagonal elements efficiently.
    public static ArrayList<ArrayList<Integer>> diagonalEfficient(ArrayList<ArrayList<Integer>> A) {
        // Create a list of lists to store the diagonal elements.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // Get the number of rows and columns in the 2D array.
        int m = A.size();
        int n = A.get(0).size();
        // Create a list to temporarily store diagonal elements.
        ArrayList<Integer> temp = new ArrayList<Integer>();
        // Add the first diagonal element to the result.
        temp.add(A.get(0).get(0));
        result.add(new ArrayList<Integer>(temp));
        
        // Iterate through the columns of the first row and add diagonal elements to the result.
        int i = 0;
        int j = i + 1;
        while (j < n) {
            int k = i;
            int l = j;
            temp.clear();
            while (k < m && l >= 0) {
                temp.add(A.get(k).get(l));
                k++;
                l--;
            }
            result.add(new ArrayList<Integer>(temp));
            j++;
        }
        
        // Iterate through the rows of the last column and add diagonal elements to the result.
        i = 1;
        j = n - 1;
        while (i < m) {
            int k = i;
            int l = j;
            temp.clear();
            while (k < m && l >= 0) {
                temp.add(A.get(k).get(l));
                k++;
                l--;
            }
            result.add(new ArrayList<Integer>(temp));
            i++;
        }
        
        // Clear the temporary list and return the result.
        temp.clear();
        return result;
    }

    // The main method for executing the program.
    public static void main(String[] args) {
        // Create a 2D array represented as a list of lists.
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(10);
        temp.add(20);
        temp.add(30);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(50);
        temp.add(60);
        temp.add(70);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(90);
        temp.add(100);
        temp.add(110);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        // Print the original 2D array.
        for (ArrayList<Integer> t : A) {
            System.out.println(t);
        }
        
        // Call the diagonalEfficient method and print the result.
        ArrayList<ArrayList<Integer>> result = diagonalEfficient(A);
        for (ArrayList<Integer> t : result) {
            System.out.println(t);
        }
    }
}
```
Sample Output:

                                                                             
[10, 20, 30]
[50, 60, 70]
[90, 100, 110]
[10]
[20, 50]
[30, 60, 90]
[70, 100]
[110]

### 38. Write a Java program to get the majority element from an array of integers containing duplicates.  

Majority element: A majority element is an element that appears more than n/2 times where n is the array size.
```java
// Import necessary Java libraries.
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Arrays; 

// Define a class named Main.
public class Main
{
    // The main method for executing the program.
  	public static void main (String[] args)
	{
		// Define an array to test for the majority element.
		int nums[] = { 1, 6, 6, 5, 7, 4, 1, 7, 7, 7, 7, 7, 7, 7, 2 };
        System.out.println("Original Array : " + Arrays.toString(nums));  
		// Call the MajorityElement method to find the majority element.
		int result = MajorityElement(nums);
		if (result != -1)
			System.out.println("Majority element is " + result);
		else
			System.out.println("Majority element does not exist");
	}
  
	// A method to find the majority element in an array.
	public static int MajorityElement(int arra1[])
	{
		int n = arra1.length;

		// Create a hash map to store element frequencies.
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
		// Calculate the frequency of each element in the map.
		for (int i = 0; i < n; i++)
		{
			if (map.get(arra1[i]) == null)
				map.put(arra1[i], 0);
			
			map.put(arra1[i], map.get(arra1[i]) + 1);
		}

		// Return the element if its count is more than n/2.
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pair = (Map.Entry)it.next();
			if ((int)pair.getValue() > n/2)
				return (int)pair.getKey();

			it.remove(); 
		}

		// No majority element found.
		return -1;
	}
}
```
Sample Output:

                                                                              
Original Array : [1, 6, 6, 5, 7, 4, 1, 7, 7, 7, 7, 7, 7, 7, 2]
Majority element is 7

### 39. Write a Java program to print all the LEADERS in the array.  
Note: An element is leader if it is greater than all the elements to its right side.
```java
// Import necessary Java libraries.
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Arrays; 

// Define a class named Main.
public class Main
{
    // The main method for executing the program.
    public static void main(String[] args)
    {
        // Define an array of integers.
        int arr[] = {10, 9, 14, 23, 15, 0, 9};
        int size = arr.length;
        
        // Loop through each element in the array.
        for (int i = 0; i < size; i++) 
        {
            int j;
            
            // Find the first element greater than or equal to arr[i].
            for (j = i + 1; j < size; j++) 
            {
                if (arr[i] <= arr[j])
                    break;
            }
            
            // If no greater element is found, print the current element.
            if (j == size) 
                System.out.print(arr[i] + " ");
        }
    }
}
```
Sample Output:

                                                                              
23 15 9

### 40. Write a Java program to find the two elements in a given array of positive and negative numbers such that their sum is close to zero.  
```java
// Import necessary Java libraries.
import java.util.*;
import java.lang.*;

// Define a class named Main.
public class Main
{
    // The main method for executing the program.
    public static void main(String[] args) 
    {
        // Define an array of integers.
        int arr[] = {1, 5, -4, 7, 8, -6};
        int size = arr.length;
        int l, r, min_sum, sum, min_l_num, min_r_num;

        // Check if the array has less than 2 elements.
        if(size < 2)
        {
            System.out.println("Invalid Input");
            return;
        }

        // Initialize variables to track the indices and minimum sum.
        min_l_num = 0;
        min_r_num = 1;
        min_sum = arr[0] + arr[1];

        // Nested loops to find the pair with the minimum sum.
        for(l = 0; l < size - 1; l++)
        {
            for(r = l+1; r < size; r++)
            {
                sum = arr[l] + arr[r];

                // Update min_sum and indices if a smaller sum is found.
                if(Math.abs(min_sum) > Math.abs(sum))
                {
                    min_sum = sum;
                    min_l_num = l;
                    min_r_num = r;
                }
            }
        }

        // Print the two elements whose sum is minimum.
        System.out.println("Two elements whose sum is minimum are " +
                            arr[min_l_num] + " and " + arr[min_r_num]);
    }
}
```
Sample Output:

                                                                              
Two elements whose sum is minimum are 5 and -4

### 41. Write a Java program to find the smallest and second smallest elements of a given array.  
```java
// Import necessary Java libraries.
import java.util.*;
import java.lang.*;

// Define a class named Main.
public class Main
{
    // The main method for executing the program.
    public static void main(String[] args) 
    {
        // Define an array of integers.
        int arr[] = {5, 7, -8, 5, 14, 1};
        
        int first_element, second_element, arr_size = arr.length;

        // Check if the array size is less than two.
        /* Return if the array size less than two */
        if (arr_size < 2)
        {
            System.out.println("Array size is less than two.");
            return;
        }

        // Initialize variables to find the first and second smallest elements.
        first_element = second_element = Integer.MAX_VALUE;
        
        // Loop through the array to find the smallest and second smallest elements.
        for (int i = 0; i < arr_size; i++)
        {
            /* Update both first and second if the current element is smaller than first. */
            if (arr[i] < first_element)
            {
                second_element = first_element;
                first_element = arr[i];
            }

            /* Update second if arr[i] is between first and second elements. */
            else if (arr[i] < second_element && arr[i] != first_element)
                second_element = arr[i];
        }
        
        // Check and print the results.
        if (second_element == Integer.MAX_VALUE)
            System.out.println("No second smallest element.");
        else
            System.out.println("The smallest element is " +
                               first_element + " and the second smallest element is " + second_element + ".");
    }
}
```
Sample Output:

                                                                              
The smallest element is -8 and second Smallest  element is 1.

### 42. Write a Java program to separate 0s and 1s in an array of 0s and 1s into left and right sides.  
```java
// Import necessary Java libraries.
import java.util.*;
import java.lang.*;

// Define a class named Main.
public class Main
{
    // The main method for executing the program.
    public static void main(String[] args) 
    {  
        // Define an array of integers containing 0s and 1s.
        int nums[] = {0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1};
        int i, nums_size = nums.length;
        int left = 0, right = nums_size - 1;
        
        // Print the original array.
        System.out.println("Original Array : " + Arrays.toString(nums));  

        // Perform segregation of 0s and 1s in the array.
        while (left < right) 
        {
            /* While 0 at the left, increment the left index. */
            while (nums[left] == 0 && left < right)
                left++;

            /* While we see 1 at the right, decrement the right index. */
            while (nums[right] == 1 && left < right)
                right--;

            if (left < right) 
            {
                // Swap 0 and 1 and increment left and decrement right.
                nums[left] = 0;
                nums[right] = 1;
                left++;
                right--;
            }
        }

        // Print the array after segregation.
        System.out.println("Array after segregation is : " + Arrays.toString(nums));  
    }
}
```
Sample Output:

                                                                              
Original Array : [0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1]
Array after segregation is : [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1]

### 43. Write a Java program to find all combinations of four elements of an array whose sum is equal to a given value.  
```java
// Import necessary Java libraries.
import java.util.*;
import java.lang.*;

// Define a class named Main.
public class Main
{
    // The main method for executing the program.
    public static void main(String[] args) 
    {  
        // Define an array of integers.
        int nums[] = {10, 20, 30, 40, 1, 2};
        int n = nums.length;
        
        // Define the target sum value.
        int s = 53;
        System.out.println("Given value: " + s);
        System.out.print("Combination of four elements:");

        // Find combinations of four elements that sum up to the given value.
        // Fix the first element.
        for (int i = 0; i < n - 3; i++) 
        {
            // Fix the second element.
            for (int j = i + 1; j < n - 2; j++) 
            {
                // Fix the third element.
                for (int k = j + 1; k < n - 1; k++) 
                {
                    // Find the fourth element.
                    for (int l = k + 1; l < n; l++) 
                    {
                        // Check if the sum of these four elements matches the target value.
                        if (nums[i] + nums[j] + nums[k] + nums[l] == s) 
                            System.out.print("\n" + nums[i] + " " + nums[j] + " " + nums[k] + " " + nums[l]);
                    }
                }
            }
        }
    }
}
```
Sample Output:

                                                                              
Given value: 53
Combination of four elements:
10 40 1 2
20 30 1 2

### 44. Write a Java program to count the number of possible triangles from a given unsorted array of positive integers.  
Note: The triangle inequality states that the sum of the lengths of any two sides of a triangle must be greater than or equal to the length of the third side.
```java
// Import necessary Java libraries.
import java.util.*;
import java.lang.*;

// Define a class named Main.
public class Main
{
    // The main method for executing the program.
    public static void main(String[] args) 
    {  
        // Define an array of integers.
        int nums[] = {6, 7, 9, 16, 25, 12, 30, 40};
        int n = nums.length;
        System.out.println("Original Array : " + Arrays.toString(nums));  

        // Sort the array elements in non-decreasing order.
        Arrays.sort(nums);
        
        // Initialize count of triangles.
        int ctr = 0;

        // Iterate through the array elements to count the number of triangles.
        for (int i = 0; i < n - 2; ++i)
        {
            int x = i + 2;

            for (int j = i + 1; j < n; ++j)
            {
                while (x < n && nums[i] + nums[j] > nums[x])
                    ++x;
                ctr += x - j - 1;
            }
        }

        System.out.println("Total number of triangles: " + ctr);
    }
}
```
Sample Output:

                                                                              
Original Array : [6, 7, 9, 16, 25, 12, 30, 40]
Total number of triangles:  17

### 45. Write a Java program to cyclically rotate a given array clockwise by one.  
```java
// Import the Arrays class to use the toString method for array display.
import java.util.Arrays;

// Define the Main class.
public class Main
{
    // Define an integer array named 'arra'.
    static int arra[] = new int[]{10, 20, 30, 40, 50, 60};

    // Define a method to rotate the array elements.
    static void rotate_array()
    {
        // Store the last element of the array in variable 'a'.
        int a = arra[arra.length - 1];
        int i;

        // Iterate through the array to shift elements to the right.
        for (i = arra.length - 1; i > 0; i--)
            arra[i] = arra[i - 1];

        // Set the first element of the array to 'a' (rotating it to the end).
        arra[0] = a;
    }

    // The main method for executing the program.
    public static void main(String[] args)
    {
        // Display the original array.
        System.out.println("Original array:");
        System.out.println(Arrays.toString(arra));

        // Call the rotate_array method to rotate the array.
        rotate_array();

        // Display the rotated array.
        System.out.println("Rotated array:");
        System.out.println(Arrays.toString(arra));
    }
}
```
Sample Output:

                                                                              
Original arraay:
[10, 20, 30, 40, 50, 60]
Rotated arraay:
[60, 10, 20, 30, 40, 50]

### 46. Write a Java program to check whether there is a pair with a specified sum in a given sorted and rotated array.  
```java
// Define the Main class.
public class Main
{
    // Define a method to check if there is a pair of elements in the array
    // that sum up to 'x'.
    static boolean sum_pair(int arr_int[], int n, int x)
    {
        int k;

        // Find the pivot point where the array is rotated.
        for (k = 0; k < n - 1; k++)
            if (arr_int[k] > arr_int[k + 1])
                break;

        int l = (k + 1) % n;
        int r = k;

        // Use two pointers approach to find a pair of elements with the sum 'x'.
        while (l != r)
        {
            if (arr_int[l] + arr_int[r] == x)
                return true;
            if (arr_int[l] + arr_int[r] < x)
                l = (l + 1) % n;
            else
                r = (n + r - 1) % n;
        }

        // If no pair is found, return false.
        return false;
    }

    // The main method for executing the program.
    public static void main(String[] args)
    {
        int arr_int[] = {22, 25, 17, 18, 19, 20};
        int sum = 42;
        int n = arr_int.length;

        // Check if there is a pair of elements in the array with the sum '42'.
        if (sum_pair(arr_int, n, sum))
            System.out.print("Array has a pair of elements with sum 42.");
        else
            System.out.print("Array has no pair with sum 42.");
    }
}
```
Sample Output:
                                                                              
Array has a pair of elements with sum 42.

### 47. Write a Java program to find the rotation count in a given rotated sorted array of integers.  
```java
// Define the Main class.
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    // Define a method to count the number of rotations in the sorted array.
    static int count_rotations(int arr_int[], int n)
    {
        int min_val = arr_int[0];
        int min_index = -1;
        
        // Iterate through the array to find the minimum element.
        for (int i = 0; i < n; i++)
        {
            if (min_val > arr_int[i])
            {
                min_val = arr_int[i];
                min_index = i;
            }
        }

        // Return the index of the minimum element, which is the count of rotations.
        return min_index;
    }
    
    // The main method for executing the program.
    public static void main(String[] args)
    {
        int arr_int[] = {35, 32, 30, 14, 18, 21, 27};
        // int arr_int[] = {35, 32, 14, 18, 21, 27};
        // int arr_int[] = {35, 14, 18, 21, 27};
        int n = arr_int.length;

        // Print the number of rotations in the sorted array.
        System.out.println(count_rotations(arr_int, n));
    }
}
```
Sample Output:
                                                                              
3

### 48. Write a Java program to arrange the elements of an array of integers so that all negative integers appear before all positive integers.  
```java
// Import the necessary Java utility class for working with arrays.
import java.util.Arrays;

// Define the Main class.
public class Main {

    // The main method for executing the program.
    public static void main(String[] args) {
        // Define an array of integers.
        int[] nums = {-4, 8, 6, -5, 6, -2, 1, 2, 3, -11};
        
        // Print the original array.
        System.out.println("Original Array: " + Arrays.toString(nums)); 
        
        // Call the sort_nums method to modify the array.
        sort_nums(nums);
        
        // Print the modified array.
        System.out.println("New Array: " + Arrays.toString(nums)); 
    }
    
    // Method to sort the numbers in the array based on their signs.
    public static void sort_nums(int[] nums){
        int pos_num = 0;
        int neg_num = 0;
        int i, j;
        int max = Integer.MIN_VALUE;

        // Count the positive and negative numbers and find the maximum value.
        for(i = 0; i < nums.length; i++){
            if(nums[i] < 0) neg_num++;
            else pos_num++;
            if(nums[i] > max) max = nums[i];
        }
        max++;

        // If there are no negative or positive numbers, return.
        if(neg_num == 0 || pos_num == 0) return;

        i = 0;
        j = 1;
        
        // Reorder the array.
        while(true){
            while(i <= neg_num && nums[i] < 0) i++;
            while(j < nums.length && nums[j] >= 0) j++;
            
            if(i > neg_num || j >= nums.length) break;
            
            nums[i] += max * (i + 1);
            swap_nums(nums, i, j);
        }

        i = nums.length - 1;
        
        // Adjust the values to their original range.
        while(i >= neg_num){
            int div = nums[i] / max;
            
            if(div == 0) i--;
            else{
                nums[i] %= max;
                swap_nums(nums, i, neg_num + div - 2); 
            }
        }
    }
    
    // Method to swap elements in the array.
    private static void swap_nums(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```
Sample Output:
                                                                              
Original Array: [-4, 8, 6, -5, 6, -2, 1, 2, 3, -11]
New Array: [-4, -5, -2, -11, 6, 6, 1, 2, 8, 3]

### 49. Write a Java program to arrange the elements of an array of integers so that all positive integers appear before all negative integers.  
```java
// Import the necessary Java utility class for working with arrays.
import java.util.Arrays;

// Define the Main class.
public class Main {

    // The main method for executing the program.
    public static void main(String[] args) {
        // Define an array of integers.
        int arra_nums[] = {-4, 8, 6, -5, 6, -2, 1, 2, 3, -11};
        
        // Print the original array.
        System.out.println("Original array: " + Arrays.toString(arra_nums)); 
        
        int j, temp, arr_size;

        // Get the size of the array.
        arr_size = arra_nums.length;

        for (int i = 0; i < arr_size; i++) {
            j = i;  
            
            // Shift positive numbers to the left and negative numbers to the right.
            while ((j > 0) && (arra_nums[j] > 0) && (arra_nums[j - 1] < 0)) {
                temp = arra_nums[j];
                arra_nums[j] = arra_nums[j - 1];
                arra_nums[j - 1] = temp;
                j--;
            }
        }

        // Print the modified array.
        System.out.println("New array: " + Arrays.toString(arra_nums)); 
    }       
}
```
Sample Output:

Original array : [-4, 8, 6, -5, 6, -2, 1, 2, 3, -11]
New array : [8, 6, 6, 1, 2, 3, -4, -5, -2, -11]

### 50. Write a Java program to sort an array of positive integers from an array. In the sorted array the value of the first element should be maximum, the second value should be a minimum, third should be the second maximum, the fourth should be the second minimum and so on.  

Write a Java program to sort an array of positive integers from an array. In the sorted array the value of the first element should be maximum, the second value should be a minimum, third should be the second maximum, the fourth should be the second minimum and so on.

Sample Pattern:

[100, 10, 90, 20, 80, 30, 70, 40, 60, 50]
Sample Solution:

Java Code:
```java
// Import the necessary Java utility class for working with arrays.
import java.util.Arrays;
 
// Define the Main class.
public class Main
{
    // A method to rearrange an array with alternating smaller and larger elements.
    static int[] rearrange(int[] new_arra, int n)
    {
        // Create a temporary array for the rearranged elements.
        int temp[] = new int[n];
     
        // Initialize pointers for the smallest and largest elements.
        int small_num = 0, large_num = n - 1;
        // Initialize a flag for alternating between small and large elements.
        boolean flag = true;
     
        // Iterate through the array and rearrange elements.
        for (int i = 0; i < n; i++)
        {
            if (flag)
                temp[i] = new_arra[large_num--];
            else
                temp[i] = new_arra[small_num++];
     
            // Toggle the flag to switch between small and large elements.
            flag = !flag;
        }
     
        return temp;
    }
 
    // The main method for executing the program.
    public static void main(String[] args) 
    {
        // Create an array of integers.
        int nums[] = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int result[];
         
        // Print the original array.
        System.out.println("Original Array ");
        System.out.println(Arrays.toString(nums));
         
        // Rearrange the array.
        result = rearrange(nums, nums.length);
         
        // Print the rearranged array.
        System.out.println("New Array ");
        System.out.println(Arrays.toString(result));
    }
}
```
Sample Output:
                                                                              
Original Array 
[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
New Array 
[100, 10, 90, 20, 80, 30, 70, 40, 60, 50]

### 51. Write a Java program that separates 0s on the left hand side and 1s on the right hand side from a random array of 0s and 1.  
```java
// Import the necessary Java utility class for working with arrays.
import java.util.Arrays;

// Define the Main class.
public class Main {
    public static void main(String[] args)
    {
        // Create an array of integers containing 0s and 1s.
        int arr[] = new int[]{ 0, 0, 1, 1, 0, 1, 1, 1, 0 };
        int result[];
        
        // Print the original array.
        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        // Get the length of the array.
        int n = arr.length;
 
        // Call the separate_0_1 method to separate 0s and 1s.
        result = separate_0_1(arr, n);
        
        // Print the rearranged array.
        System.out.println("New Array ");
        System.out.println(Arrays.toString(result));
    }
    
    // A method to separate 0s and 1s in an array.
    static int[] separate_0_1(int arr[], int n)
     {
        // Initialize a count to track the number of 0s.
        int count = 0;   
     
        // Count the number of 0s in the array.
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
        }
 
        // Set the first 'count' elements to 0.
        for (int i = 0; i < count; i++)
            arr[i] = 0;
 
        // Set the remaining elements to 1.
        for (int i = count; i < n; i++)
            arr[i] = 1;
    
        // Return the modified array.
        return arr;
     }       
}
```
Sample Output:
                                                                              
Original Array 
[0, 0, 1, 1, 0, 1, 1, 1, 0]
New Array 
[0, 0, 0, 0, 1, 1, 1, 1, 1]

### 52. Write a Java program to separate even and odd numbers from a given array of integers. Put all even numbers first, and then odd numbers.  
```java
// Import the necessary Java utility class for working with arrays.
import java.util.Arrays;

// Define the Main class.
public class Main {
	
    public static void main(String[] args)
    {
        // Create an array of integers.
        int nums[] = {20, 12, 23, 17, 7, 8, 10, 2, 1, 0};
        int result[];
        
        // Print the original array.
        System.out.println("Original Array ");
        System.out.println(Arrays.toString(nums));

        // Call the separate_odd_even method to separate odd and even numbers.
        result = separate_odd_even(nums);
 
        // Print the array after separation.
        System.out.print("Array after separation ");
        System.out.println(Arrays.toString(result));
    }
	
    // A method to separate odd and even numbers in an array.
    static int[] separate_odd_even(int arr[])
    {
        // Initialize left and right pointers.
        int left_side = 0, right_side = arr.length - 1;
        
        // Continue until the left pointer is less than the right pointer.
        while (left_side < right_side)
        {
            // Move the left pointer to the right until it points to an odd number.
            while (arr[left_side] % 2 == 0 && left_side < right_side)
                left_side++;
 
            // Move the right pointer to the left until it points to an even number.
            while (arr[right_side] % 2 == 1 && left_side < right_side)
                right_side--;
 
            // If the left pointer is still less than the right pointer, swap the elements.
            if (left_side < right_side)
            {
                int temp = arr[left_side];
                arr[left_side] = arr[right_side];
                arr[right_side] = temp;
                left_side++;
                right_side--;
            }
        }
        
        // Return the modified array.
        return arr;
    }
}
```
Sample Output:

                                                                              
Original Array 
[20, 12, 23, 17, 7, 8, 10, 2, 1, 0]
Array after separation [20, 12, 0, 2, 10, 8, 7, 17, 1, 23]

### 53. Write a Java program to replace every element with the next greatest element (from the right side) in a given array of integers.
There is no element next to the last element, therefore replace it with -1. 
```java
// Import the necessary Java input/output and utility classes.
import java.io.*;
import java.util.Arrays;

// Define the Main class.
public class Main {
   
    public static void main(String[] args)
    {
        // Create an array of integers.
        int nums[] = {45, 20, 100, 23, -5, 2, -6};
        int result[];
        
        // Print the original array.
        System.out.println("Original Array ");
        System.out.println(Arrays.toString(nums));

        // Call the next_greatest_num method to modify the array.
        result = next_greatest_num(nums);
        
        // Print the modified array.
        System.out.println("The modified array:");
        System.out.println(Arrays.toString(result));
    }

    // A method to modify the array by replacing each element with the next greatest number.
    static int[] next_greatest_num(int arr_nums[])
    {
        // Get the size of the array.
        int size = arr_nums.length;
        
        // Initialize the maximum element from the right side.
        int max_from_right_num = arr_nums[size - 1];
        
        // Set the last element of the array to -1.
        arr_nums[size - 1] = -1;

        // Iterate through the array from right to left.
        for (int i = size - 2; i >= 0; i--)
        {
            int temp = arr_nums[i];
            
            // Replace the current element with the maximum from the right side.
            arr_nums[i] = max_from_right_num;
            
            // Update the maximum from the right side if needed.
            if (max_from_right_num < temp)
                max_from_right_num = temp;
        }

        // Return the modified array.
        return arr_nums;
    } 
}
```
Sample Output:

                                                                              
Original Array 
[45, 20, 100, 23, -5, 2, -6]
The modified array:
[100, 100, 23, 2, 2, -6, -1]

### 54. Write a Java program to check if a given array contains a subarray with 0 sum.  

Example:
Input :
nums1= { 1, 2, -2, 3, 4, 5, 6 }
nums2 = { 1, 2, 3, 4, 5, 6 }
nums3 = { 1, 2, -3, 4, 5, 6 }
Output:
Does the said array contain a subarray with 0 sum: true
Does the said array contain a subarray with 0 sum: false
Does the said array contain a subarray with 0 sum: true
```java
// Import the necessary Java utility classes.
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

// Define a class named 'solution'.
class solution
{
    // A method to find if there exists a subarray with a sum of zero.
    public static Boolean find_subarray_sum_zero(int[] nums)
    {
        // Create a HashSet to store the cumulative sum of elements.
        Set set = new HashSet<>();
        set.add(0);
        int suba_sum = 0;

        // Iterate through the elements of the array.
        for (int i = 0; i < nums.length; i++)
        {            
            suba_sum += nums[i];

            // If the cumulative sum already exists in the set, return true.
            if (set.contains(suba_sum)) {
                return true;
            }
            
            // Add the cumulative sum to the set.
            set.add(suba_sum);
        }

        // If no subarray with a sum of zero is found, return false.
        return false;
    }

    public static void main (String[] args)
    {
        // Define an array 'nums1'.
        int[] nums1 = { 1, 2, -2, 3, 4, 5, 6 };
        System.out.println("Original array: " + Arrays.toString(nums1));
        
        // Check if the array contains a subarray with a sum of zero and print the result.
        System.out.println("Does the said array contain a subarray with 0 sum: " + find_subarray_sum_zero(nums1));

        // Define another array 'nums2'.
        int[] nums2 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("\nOriginal array: " + Arrays.toString(nums2));
        
        // Check if the array contains a subarray with a sum of zero and print the result.
        System.out.println("Does the said array contain a subarray with 0 sum: " + find_subarray_sum_zero(nums2));

        // Define yet another array 'nums3'.
        int[] nums3 = { 1, 2, -3, 4, 5, 6 };
        System.out.println("\nOriginal array: " + Arrays.toString(nums3));
        
        // Check if the array contains a subarray with a sum of zero and print the result.
        System.out.println("Does the said array contain a subarray with 0 sum: " + find_subarray_sum_zero(nums3));
    }
}
```
Sample Output:
                                                                              
Original array: [1, 2, -2, 3, 4, 5, 6]
Does the said array contain a subarray with 0 sum: true

Original array: [1, 2, 3, 4, 5, 6]
Does the said array contain a subarray with 0 sum: false

Original array: [1, 2, -3, 4, 5, 6]
Does the said array contain a subarray with 0 sum: true

### 55. Write a Java program to print all sub-arrays with 0 sum present in a given array of integers.  

Example:
Input :
nums1 = { 1, 3, -7, 3, 2, 3, 1, -3, -2, -2 }
nums2 = { 1, 2, -3, 4, 5, 6 }
nums3= { 1, 2, -2, 3, 4, 5, 6 }
Output:
Sub-arrays with 0 sum : [1, 3, -7, 3]
Sub-arrays with 0 sum : [3, -7, 3, 2, 3, 1, -3, -2]

Sub-arrays with 0 sum : [1, 2, -3]
Sub-arrays with 0 sum : [2, -2]
```java
// Import necessary Java classes.
import java.util.*;
import java.lang.*;

// Define a class named 'solution'.
class solution
{
    // A method to print all subarrays with a sum of zero.
    public static void print_all_Subarrays(int[] A)
    {
        // Create a list to store elements of subarrays.
        List<Integer> llist = new ArrayList<Integer>();

        // Iterate through the array.
        for (int i = 0; i < A.length; i++)
        {
            int sum = 0;
            llist.removeAll(llist);

            // Nested loop to find subarrays starting from index i.
            for (int j = i; j < A.length; j++)
            {
                sum += A[j];
                llist.add(A[j]);

                // If the sum of the subarray is zero, print it.
                if (sum == 0) {
                    System.out.println("Sub-arrays with 0 sum: " + llist.toString());
                }
            }
        }
    }

    public static void main (String[] args)
    {
        // Define an array 'nums1'.
        int[] nums1 = { 1, 3, -7, 3, 2, 3, 1, -3, -2, -2 };
        System.out.println("\nOriginal array: " + Arrays.toString(nums1));
        
        // Print all subarrays with a sum of zero for 'nums1'.
        print_all_Subarrays(nums1);
        
        // Define another array 'nums2'.
        int[] nums2 = { 1, 2, -3, 4, 5, 6 };
        System.out.println("\nOriginal array: " + Arrays.toString(nums2));
        
        // Print all subarrays with a sum of zero for 'nums2'.
        print_all_Subarrays(nums2);

        // Define yet another array 'nums3'.
        int[] nums3= { 1, 2, -2, 3, 4, 5, 6 };
        System.out.println("\nOriginal array: " + Arrays.toString(nums3));
        
        // Print all subarrays with a sum of zero for 'nums3'.
        print_all_Subarrays(nums3);
    }
}
```
Sample Output:
                                                                              
Original array: [1, 3, -7, 3, 2, 3, 1, -3, -2, -2]
Sub-arrays with 0 sum : [1, 3, -7, 3]
Sub-arrays with 0 sum : [3, -7, 3, 2, 3, 1, -3, -2]

Original array: [1, 2, -3, 4, 5, 6]
Sub-arrays with 0 sum : [1, 2, -3]

Original array: [1, 2, -2, 3, 4, 5, 6]
Sub-arrays with 0 sum : [2, -2]

### 56. Write a Java program to sort a binary array in linear time.  
From Wikipedia,
Linear time: An algorithm is said to take linear time, or O(n) time, if its time complexity is O(n). Informally, this means that the running time increases at most linearly with the size of the input. More precisely, this means that there is a constant c such that the running time is at most cn for every input of size n. For example, a procedure that adds up all elements of a list requires time proportional to the length of the list, if the adding time is constant, or, at least, bounded by a constant.
Linear time is the best possible time complexity in situations where the algorithm has to sequentially read its entire input. Therefore, much research has been invested into discovering algorithms exhibiting linear time or, at least, nearly linear time. This research includes both software and hardware methods. There are several hardware technologies which exploit parallelism to provide this. An example is content-addressable memory. This concept of linear time is used in string matching algorithms such as the Boyer–Moore algorithm and Ukkonen's algorithm.

Example:
Input :
b_nums[] = { 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 }
Output:
After sorting: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
```java
// Import the necessary Java class for working with arrays.
import java.util.Arrays;

// Define a class named 'solution'.
class solution
{
    // A method to sort binary numbers in an array.
    public static void sort_binary_nums(int[] b_nums)
    {
        int k = 0;

        // Iterate through the array to move all 0s to the front.
        for (int i = 0; i < b_nums.length; i++)
        {
            if (b_nums[i] == 0) {
                b_nums[k++] = 0;
            }
        }

        // Fill the remaining positions with 1s to sort the binary array.
        for (int i = k; i < b_nums.length; i++) {
            b_nums[k++] = 1;
        }
    }

    public static void main (String[] args)
    {
        // Define an array 'b_nums' containing binary numbers.
        int b_nums[] = { 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 };
        System.out.println("Original array: " + Arrays.toString(b_nums));

        // Sort the binary numbers in the array.
        sort_binary_nums(b_nums);
        System.out.println("After sorting: " + Arrays.toString(b_nums));
    }
}
```
Sample Output:
                                                                              
Original array: [0, 1, 1, 0, 1, 1, 0, 1, 0, 0]
After sorting: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

### 57. Write a Java program to check if a sub-array is formed by consecutive integers from a given array of integers.  

Example:
Input :
nums = { 2, 5, 0, 2, 1, 4, 3, 6, 1, 0 }
Output:
The largest sub-array is [1, 7]
Elements of the sub-array: 5 0 2 1 4 3 6
```java
// Import necessary Java classes.
import java.lang.Math;
import java.util.Arrays;

// Define a class named 'solution'.
class solution
{
    // A method to check if the elements in a sub-array are consecutive.
    static boolean is_consecutive(int nums[], int i, int j, int min, int max)
    {
        if (max - min != j - i) {
            return false;
        }

        // Create a boolean array to check for duplicates.
        boolean check[] = new boolean[j - i + 1];

        // Check each element in the sub-array.
        for (int k = i; k <= j; k++)
        {
            if (check[nums[k] - min]) {
                return false;
            }

            check[nums[k] - min] = true;
        }

        return true;
    }
    
    // A method to find and print the largest consecutive sub-array.
    public static void find_Max_SubArray(int[] nums)
    {
        int len = 1;
        int start = 0, end = 0;

        for (int i = 0; i < nums.length - 1; i++)
        {
            int min_val = nums[i], max_val = nums[i];

            for (int j = i + 1; j < nums.length; j++)
            {
                min_val = Math.min(min_val, nums[j]);
                max_val = Math.max(max_val, nums[j]);

                // Check if the sub-array is consecutive and larger.
                if (is_consecutive(nums, i, j, min_val, max_val))
                {
                    if (len < max_val - min_val + 1)
                    {
                        len = max_val - min_val + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        // Print the largest sub-array and its elements.
        System.out.println("The largest sub-array is [" + start + ", " + end + "]");
        System.out.print("Elements of the sub-array: ");
        for (int x = start; x <= end; x++)
        {
            System.out.print(nums[x] + " ");			
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 5, 0, 2, 1, 4, 3, 6, 1, 0 };
        System.out.println("Original array: " + Arrays.toString(nums));

        // Find and print the largest consecutive sub-array.
        find_Max_SubArray(nums);
    }
}
```
Sample Output:
                                                                            
Original array: [2, 5, 0, 2, 1, 4, 3, 6, 1, 0]
The largest sub-array is [1, 7]
Elements of the sub-array: 5 0 2 1 4 3 6 

### 58. Given two sorted arrays A and B of size p and q, write a Java program to merge elements of A with B by maintaining the sorted order i.e. fill A with first p smallest elements and fill B with remaining elements.  

Example:
Input :
int[] A = { 1, 5, 6, 7, 8, 10 }
int[] B = { 2, 4, 9 }
Output:
Sorted Arrays:
A: [1, 2, 4, 5, 6, 7]
B: [8, 9, 10]
```java
// Import necessary Java classes.
import java.util.Arrays;

// Define a class named 'solution'.
class solution
{
    // A method to merge two sorted arrays.
    public static void merge_sorted_arrays(int[] A, int p, int[] B, int q)
    {
        // Loop through the first array.
        for (int i = 0; i < p; i++)
        {
            if (A[i] > B[0])
            {
                // Swap elements if the current element in A is greater than the first element in B.
                int temp = A[i];
                A[i] = B[0];
                B[0] = temp;

                // Store the first element from B.
                int first_arr = B[0];
                int k;

                // Move elements in B to the right to insert first_arr in the correct position.
                for (k = 1; k < q && B[k] < first_arr; k++) {
                    B[k - 1] = B[k];
                }

                // Insert first_arr in the correct position in B.
                B[k - 1] = first_arr;
            }
        }
    }

    public static void main (String[] args)
    {
        int[] A = { 1, 5, 6, 7, 8, 10 };
        int[] B = { 2, 4, 9 };
        int p = A.length;
        int q = B.length;

        // Print the original arrays.
        System.out.println("Original Arrays:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));

        // Merge the sorted arrays A and B.
        merge_sorted_arrays(A, p, B, q);

        // Print the sorted arrays A and B after merging.
        System.out.println("\nSorted Arrays:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
    }
}
```
Sample Output:

Original Arrays:
A: [1, 5, 6, 7, 8, 10]
B: [2, 4, 9]

Sorted Arrays:
A: [1, 2, 4, 5, 6, 7]
B: [8, 9, 10]

### 59. Write a Java program to find the maximum product of two integers in a given array of integers.  

Example:
Input :
nums = { 2, 3, 5, 7, -7, 5, 8, -5 }
Output:
Pair is (7, 8), Maximum Product: 56
```java
// Import necessary Java classes.
import java.util.*;

// Define a class named 'solution'.
class solution
{
    // A method to find the pair of elements with the maximum product.
    public static void find_max_product(int[] nums)
    {
        int max_pair_product = Integer.MIN_VALUE;
        int max_i = -1, max_j = -1;

        // Loop through the array elements.
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                // Check if the product of elements at indices i and j is greater than the current maximum.
                if (max_pair_product < nums[i] * nums[j])
                {
                    max_pair_product = nums[i] * nums[j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        // Print the pair and maximum product.
        System.out.print("Pair is (" + nums[max_i] + ", " + nums[max_j] + "), Maximum Product: " + (nums[max_i] * nums[max_j]));
    }

    public static void main (String[] args)
    {
        int[] nums = { 2, 3, 5, 7, -7, 5, 8, -5 };
        System.out.println("\nOriginal array: "+Arrays.toString(nums));

        // Find and print the pair of elements with the maximum product.
        find_max_product(nums);
    }
}
```
Sample Output:

Original array: [2, 3, 5, 7, -7, 5, 8, -5]
Pair is (7, 8), Maximum Product: 56 

### 60. Write a Java program to shuffle a given array of integers.  

Example:
Input :
nums = { 1, 2, 3, 4, 5, 6 }
Output:
Shuffle Array: [4, 2, 6, 5, 1, 3]
```java
// Import necessary Java classes.
import java.util.Arrays;
import java.util.Random;

// Define a class named 'solution'.
class solution
{
    // A method to shuffle an array using the Fisher-Yates algorithm.
    public static void shuffle(int nums[])
    {
        for (int i = nums.length - 1; i >= 1; i--)
        {
            // Create a random number generator.
            Random rand = new Random();

            // Generate a random index j between 0 and i (inclusive).
            int j = rand.nextInt(i + 1);

            // Swap elements at indices i and j.
            swap_elements(nums, i, j);
        }
    }

    // A method to swap two elements in an array.
    private static void swap_elements(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String[] args)
    {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Original Array: "+Arrays.toString(nums));

        // Shuffle the array using the Fisher-Yates algorithm.
        shuffle(nums);

        System.out.println("Shuffled Array: "+Arrays.toString(nums));
    }
}
```
Sample Output:

Original Array: [1, 2, 3, 4, 5, 6]
Shuffle Array: [4, 2, 6, 5, 1, 3] 

### 61. Write a Java program to rearrange a given array of unique elements such that every second element of the array is greater than its left and right elements.  

Example:
Input :
nums= { 1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14 }
Output:
Array with every second element is greater than its left and right elements:
[1, 4, 2, 9, 3, 8, 5, 10, 7, 14, 12]
```java
// Import the necessary Java class.
import java.util.Arrays;

// Define a class named 'solution'.
class solution
{
    // A private method to swap two elements in an array.
    private static void swap_nums(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // A method to rearrange an array such that every second element is greater
    // than its left and right elements.
    public static void rearrange_Array_nums(int[] nums)
    {
        for (int i = 1; i < nums.length; i += 2)
        {
            // Check if the element to the left is greater and swap if needed.
            if (nums[i - 1] > nums[i]) {
                swap_nums(nums, i - 1, i);
            }

            // Check if the element to the right is greater and swap if needed.
            if (i + 1 < nums.length && nums[i + 1] > nums[i]) {
                swap_nums(nums, i + 1, i);
            }
        }
    }

    public static void main (String[] args)
    {
        int[] nums= { 1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14 };
        System.out.println("Original array:\n"+Arrays.toString(nums));

        // Rearrange the array so that every second element is greater than its
        // left and right elements.
        rearrange_Array_nums(nums);

        System.out.println("\nArray with every second element is greater than its left and right elements:\n"
                + Arrays.toString(nums));
    }
}
```
Sample Output:

Original array:
[1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14]

Array with every second element is greater than its left and right elements:
[1, 4, 2, 9, 3, 8, 5, 10, 7, 14, 12]

### 62. Write a Java program to find equilibrium indices in a given array of integers.  

Example:
Input :
nums = {-7, 1, 5, 2, -4, 3, 0}
Output:
Equilibrium indices found at : 3
Equilibrium indices found at : 6

An equilibrium index of a sequence is an index into the sequence such that the sum of elements at lower indices is equal to the sum of elements at higher indices.

For example, in a sequence A:
  A0 = -7
  A1 = 1
  A2 = 5
  A3 = 2
  A4 = -4
  A5 = 3
  A6 = 0
3 is an equilibrium index, because:

  A0 + A1 + A2 = A4 + A5 + A6
  
6 is also an equilibrium index, because:

  A0 + A1 + A2 + A3 + A4 + A5 = 0
  
(sum of zero elements is zero)

7 is not an equilibrium index, because it is not a valid index of sequence A.
Example:
Input :
nums = {-7, 1, 5, 2, -4, 3, 0}
Output:
Equilibrium indices found at : 3
Equilibrium indices found at : 6
Source: https://bit.ly/2ziUROQ
//Source: https://bit.ly/2ziUROQ
```java
// Import the necessary Java class.
import java.util.Arrays;

// Define a class named 'solution'.
public class solution {
    public static void main(String[] args) {
        // Initialize an array of integers.
        int[] nums = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Original array: " + Arrays.toString(nums));
        
        // Call the 'equlibrium_indices' method to find equilibrium indices.
        equlibrium_indices(nums);
    }

    public static void equlibrium_indices(int[] nums) {
        // Find the total sum of elements in the array.
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        // Initialize a running sum to keep track of the sum as we iterate.
        int runningSum = 0;

        // Iterate through the array to find equilibrium indices.
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            // Check if the current index is an equilibrium index.
            if (totalSum - runningSum - n == runningSum) {
                System.out.println("Equilibrium indices found at: " + i);
            }

            // Update the running sum as we move through the array.
            runningSum += n;
        }
    }
}
```
Sample Output:

Original array: [-7, 1, 5, 2, -4, 3, 0]
Equilibrium indices found at : 3
Equilibrium indices found at : 6
### 63. Write a Java program to replace each element of the array with the product of every other element in a given array of integers.  
Example:
Input :
nums1 = { 1, 2, 3, 4, 5, 6, 7}
nums2 = {0, 1, 2, 3, 4, 5, 6, 7}
Output:
Array with product of every other element:
[5040, 2520, 1680, 1260, 1008, 840, 720]
Array with product of every other element:
[5040, 0, 0, 0, 0, 0, 0, 0]
```java
// Import the necessary Java class.
import java.util.Arrays;

// Define a class named 'solution'.
class solution {
    // Method to find the product of every other element in an array.
    public static int[] find_Product_in_array(int[] nums) {
        int n = nums.length;

        // Initialize arrays to store left and right products.
        int[] left_element = new int[n];
        int[] right_element = new int[n];

        // Calculate left products.
        left_element[0] = 1;
        for (int i = 1; i < n; i++) {
            left_element[i] = nums[i - 1] * left_element[i - 1];
        }

        // Calculate right products.
        right_element[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            right_element[j] = nums[j + 1] * right_element[j + 1];
        }

        // Calculate the product of every other element.
        for (int i = 0; i < n; i++) {
            nums[i] = left_element[i] * right_element[i];
        }

        // Return the modified array.
        return nums;
    }

    // Main method to demonstrate finding product of every other element in arrays.
    public static void main(String[] args) {
        // Initialize an array.
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Original array:\n" + Arrays.toString(nums1));

        // Call the 'find_Product_in_array' method to calculate product and print the result.
        int[] result1 = find_Product_in_array(nums1);
        System.out.println("Array with product of every other element:\n" + Arrays.toString(result1));

        // Initialize another array.
        int[] nums2 = { 0, 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("\nOriginal array:\n" + Arrays.toString(nums2));

        // Call the method and print the result for the second array.
        int[] result2 = find_Product_in_array(nums2);
        System.out.println("Array with product of every other element:\n" + Arrays.toString(result2));
    }
}
```
Sample Output:

Original array:
[1, 2, 3, 4, 5, 6, 7]
Array with product of every other element:
[5040, 2520, 1680, 1260, 1008, 840, 720]

Original array:
[0, 1, 2, 3, 4, 5, 6, 7]
Array with product of every other element:
[5040, 0, 0, 0, 0, 0, 0, 0]

### 64. Write a Java program to find the Longest Bitonic Subarray in a given array.  

A bitonic subarray is a subarray of a given array where elements are first sorted in increasing order, then in decreasing order. A strictly increasing or strictly decreasing subarray is also accepted as bitonic subarray.

Example:
Input :
nums = { 4, 5, 9, 5, 6, 10, 11, 9, 6, 4, 5 }
Output:
The longest bitonic subarray is [3,9]
Elements of the said sub-array: 5 6 10 11 9 6 4
The length of longest bitonic subarray is 7
```java
// Import the necessary Java class.
import java.util.Arrays;

// Define a class named 'solution'.
class solution {
    // Method to find the length and elements of the longest bitonic subarray.
    public static int find_Bitonic_Subarray(int[] nums) {
        // Initialize arrays to store increasing and decreasing lengths.
        int[] incre_array = new int[nums.length];
        int[] decre_array = new int[nums.length];

        // Initialize the first element of the increasing array.
        incre_array[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            incre_array[i] = 1;
            // Calculate increasing lengths based on the previous element.
            if (nums[i - 1] < nums[i]) {
                incre_array[i] = incre_array[i - 1] + 1;
            }
        }

        // Initialize the last element of the decreasing array.
        decre_array[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            decre_array[i] = 1;
            // Calculate decreasing lengths based on the next element.
            if (nums[i] > nums[i + 1]) {
                decre_array[i] = decre_array[i + 1] + 1;
            }
        }

        int lbs_len = 1;
        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            // Calculate the longest bitonic subarray.
            if (lbs_len < incre_array[i] + decre_array[i] - 1) {
                lbs_len = incre_array[i] + decre_array[i] - 1;
                start = i - incre_array[i] + 1;
                end = i + decre_array[i] - 1;
            }
        }

        // Print the longest bitonic subarray.
        System.out.println("The longest bitonic subarray is [" + start + "," + end + "]");
        System.out.print("Elements of the said sub-array: ");
        for (int x = start; x <= end; x++) {
            System.out.print(nums[x] + " ");
        }

        System.out.println("\nThe length of the longest bitonic subarray is " + lbs_len);

        return lbs_len;
    }

    // Main method to demonstrate finding the longest bitonic subarray in an array.
    public static void main(String[] args) {
        // Initialize an array.
        int[] nums = { 4, 5, 9, 5, 6, 10, 11, 9, 6, 4, 5 };
        System.out.println("\nOriginal array: " + Arrays.toString(nums));

        // Call the 'find_Bitonic_Subarray' method to find and print the longest bitonic subarray.
        find_Bitonic_Subarray(nums);
    }
}
```
Sample Output:

Original array: [4, 5, 9, 5, 6, 10, 11, 9, 6, 4, 5]
The longest bitonic subarray is [3,9]
Elements of the said sub-array: 5 6 10 11 9 6 4 
The length of longest bitonic subarray is 7

### 65. Write a Java program to find the maximum difference between two elements in a given array of integers such that the smaller element appears before the larger element.  

Example:
Input :
nums = { 2, 3, 1, 7, 9, 5, 11, 3, 5 }
Output:
The maximum difference between two elements of the said array elements
10
```java
// Import the necessary Java class.
import java.util.Arrays;

// Define a class named 'solution'.
class solution {
    // Method to find the maximum difference between two elements in the array.
    public static int diff_between_two_elemnts(int[] nums) {
        // Initialize a variable to store the maximum difference.
        int diff_two_elemnts = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Update the maximum difference with the maximum of the current difference and the previous maximum.
                diff_two_elemnts = Integer.max(diff_two_elemnts, nums[j] - nums[i]);
            }
        }

        return diff_two_elemnts;
    }

    // Main method to demonstrate finding the maximum difference between two elements in an array.
    public static void main(String[] args) {
        // Initialize an array.
        int[] nums = { 2, 3, 1, 7, 9, 5, 11, 3, 5 };
        System.out.println("\nOriginal array: " + Arrays.toString(nums));

        // Call the 'diff_between_two_elemnts' method to find and print the maximum difference.
        System.out.print("The maximum difference between two elements of the said array elements\n" + diff_between_two_elemnts(nums));
    }
} 
```
Sample Output:

Original array: [2, 3, 1, 7, 9, 5, 11, 3, 5]
The maximum difference between two elements of the said array elements
10

### 66. Write a Java program to find a contiguous subarray within a given array of integers with the largest sum.  

In computer science, the maximum sum subarray problem is the task of finding a contiguous subarray with the largest sum, within a given one-dimensional array A[1...n] of numbers. Formally, the task is to find indices and with, such that the sum is as large as possible.


Example:
Input :
int[] A = {1, 2, -3, -4, 0, 6, 7, 8, 9}
Output:
The largest sum of contiguous sub-array: 30
```java
// Import the necessary Java class.
import java.util.Arrays;

// Define a class named 'solution'.
class solution {
    // Method to find the largest sum of a contiguous sub-array.
    public static int largest_sum(int[] A) {
        // Initialize variables for maximum element value and maximum ending here.
        int max_ele_val = 0;
        int max_end = 0;

        // Iterate through the elements in array 'A'.
        for (int i : A) {
            max_end = max_end + i;

            // Ensure that 'max_end' doesn't go below zero.
            max_end = Integer.max(max_end, 0);

            // Update 'max_ele_val' with the maximum value.
            max_ele_val = Integer.max(max_ele_val, max_end);
        }
        return max_ele_val;
    }

    // Main method to demonstrate finding the largest sum of a contiguous sub-array.
    public static void main(String[] args) {
        // Initialize an array.
        int[] A = {1, 2, -3, -4, 0, 6, 7, 8, 9};
        System.out.println("\nOriginal array: " + Arrays.toString(A));

        // Call the 'largest_sum' method to find and print the largest sum.
        System.out.println("The largest sum of a contiguous sub-array: " + largest_sum(A));
    }
} 
```
Sample Output:

Original array: [1, 2, -3, -4, 0, 6, 7, 8, 9]
The largest sum of contiguous sub-array: 30

### 67. Write a Java program to find the subarray with the largest sum in a given circular array of integers.  

Example:
Input :
nums1 = { 2, 1, -5, 4, -3, 1, -3, 4, -1 }
nums2 = { 1, -2, 3, 0, 7, 8, 1, 2, -3 }
Output:
The sum of subarray with the largest sum is 6
The sum of subarray with the largest sum is 21
```java
// Import the necessary Java class.
import java.util.Arrays;

// Define a class named 'solution'.
class solution {
    // Method to find the maximum sum of a subarray within a circular array.
    public static int max_Subarray_Sum_Circular(int[] nums) {
        int n = nums.length;
        int result = nums[0];  // Initialize 'result' with the first element.
        int sum = nums[0];     // Initialize 'sum' with the first element.

        // Iterate through the array starting from the second element.
        for (int i = 1; i < n; i++) {
            // Calculate the maximum of 'sum + nums[i]' and 'nums[i]' (Kadane's algorithm).
            sum = Math.max(sum + nums[i], nums[i]);
            // Update 'result' with the maximum value.
            result = Math.max(result, sum);
        }

        // Create arrays to store right sum and right max.
        int[] right_Sum = new int[n];
        int[] right_Max = new int[n];

        // Initialize the last elements of right sum and right max arrays.
        right_Sum[n - 1] = nums[n - 1];
        right_Max[n - 1] = nums[n - 1];

        // Iterate through the array in reverse order.
        for (int i = n - 2; i >= 0; i--) {
            // Calculate right sum and right max values.
            right_Sum[i] = right_Sum[i + 1] + nums[i];
            right_Max[i] = Math.max(right_Sum[i], right_Max[i + 1]);
        }

        int left_Sum = 0;  // Initialize the left sum.

        // Iterate through the array with a circular view, except the last two elements.
        for (int i = 0; i < n - 2; i++) {
            left_Sum += nums[i];
            // Update 'result' with the maximum of 'left_Sum + right_Max[i + 2]' and the current 'result'.
            result = Math.max(result, left_Sum + right_Max[i + 2]);
        }

        return result;
    }
	
    // Main method to demonstrate finding the maximum sum of a subarray in a circular array.
    public static void main(String[] args) {
        // Initialize two circular arrays.
        int[] nums1 = { 2, 1, -5, 4, -3, 1, -3, 4, -1 };
        int[] nums2 = { 1, -2, 3, 0, 7, 8, 1, 2, -3 };

        // Print the original circular arrays.
        System.out.println("\nOriginal circular array 1: " + Arrays.toString(nums1));
        System.out.println("The sum of subarray with the largest sum is " + max_Subarray_Sum_Circular(nums1));
        System.out.println("\nOriginal circular array 2: " + Arrays.toString(nums2));
        System.out.println("The sum of subarray with the largest sum is " + max_Subarray_Sum_Circular(nums2));
    }
}
```
Sample Output:

Original circular array: [2, 1, -5, 4, -3, 1, -3, 4, -1]
The sum of subarray with the largest sum is 6

Original circular array: [1, -2, 3, 0, 7, 8, 1, 2, -3]
The sum of subarray with the largest sum is 21

### 68. Write a Java program to create all possible permutations of a given array of distinct integers.  

Example:
Input :
nums1 = {1, 2, 3, 4}
nums2 = {1, 2, 3}
Output:
Possible permutations of the said array:
[1, 2, 3, 4]
[1, 2, 4, 3]
....
[4, 1, 3, 2]
[4, 1, 2, 3]
Possible permutations of the said array:
[1, 2, 3]
[1, 3, 2]
...
[3, 2, 1]
[3, 1, 2]

```java
// Import the necessary Java classes.
import java.util.*;
import java.util.List;

// Define the 'solution' class.
public class solution {
    // Main method to demonstrate permutation of arrays.
    public static void main(String[] args) throws Exception {
        // Initialize the first array.
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("\nOriginal array 1: " + Arrays.toString(nums1));
        // Calculate and display the permutations of the first array.
        List<List<Integer>> result1 = new solution().permute(nums1);
        System.out.println("\nPossible permutations of the first array:");
        result1.forEach(System.out::println);

        // Initialize the second array.
        int[] nums2 = {1, 2, 3};
        System.out.println("\nOriginal array 2: " + Arrays.toString(nums2));
        // Calculate and display the permutations of the second array.
        List<List<Integer>> result2 = new solution().permute(nums2);
        System.out.println("\nPossible permutations of the second array:");
        result2.forEach(System.out::println);
    }

    // Method to calculate permutations of an array.
    public List<List<Integer>>permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Permutation(0, nums, result);
        return result;
    }

    // Recursive method to generate permutations.
    private void Permutation(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
        } else {
            for (int j = i, l = nums.length; j < l; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                Permutation(i + 1, nums, result);
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
} 
```
Sample Output:

Original array: [1, 2, 3, 4]

Possible permutations of the said array:
[1, 2, 3, 4]
[1, 2, 4, 3]
[1, 3, 2, 4]
[1, 3, 4, 2]
[1, 4, 3, 2]
[1, 4, 2, 3]
[2, 1, 3, 4]
[2, 1, 4, 3]
[2, 3, 1, 4]
[2, 3, 4, 1]
[2, 4, 3, 1]
[2, 4, 1, 3]
[3, 2, 1, 4]
[3, 2, 4, 1]
[3, 1, 2, 4]
[3, 1, 4, 2]
[3, 4, 1, 2]
[3, 4, 2, 1]
[4, 2, 3, 1]
[4, 2, 1, 3]
[4, 3, 2, 1]
[4, 3, 1, 2]
[4, 1, 3, 2]
[4, 1, 2, 3]

Original array: [1, 2, 3]

Possible permutations of the said array:
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]
### 69. Write a Java program to find the minimum subarray sum of specified size in a given array of integers.  

Example:
Input :
nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10}
Output:
Sub-array size: 4
Sub-array from 0 to 3 and sum is: 10
```java
// Import the necessary Java classes.
import java.util.*;

// Define the 'solution' class.
class solution {
    // Method to find the subarray with the minimum sum of size 'k'.
    public static int[] find_min_subarray_sum(int[] nums, int k) {
        // Initialize variables to track the subarray sum and its minimum.
        int sub_arr_sum = 0;
        int min_sub_arr = Integer.MAX_VALUE;
        int last = 0;
        int[] result = new int[3]; // Store the result [start, end, min sum].

        // Iterate through the 'nums' array.
        for (int i = 0; i < nums.length; i++) {
            sub_arr_sum += nums[i];

            // Check if the subarray size 'k' is reached.
            if (i + 1 >= k) {
                // Update the minimum subarray sum and its endpoint.
                if (min_sub_arr > sub_arr_sum) {
                    min_sub_arr = sub_arr_sum;
                    last = i;
                }

                // Remove the contribution of the first element in the subarray.
                sub_arr_sum -= nums[i + 1 - k];
            }
        }

        // Store the results in the 'result' array.
        result[0] = last - k + 1; // Start index of the minimum subarray.
        result[1] = last; // End index of the minimum subarray.
        result[2] = min_sub_arr; // Minimum subarray sum.
        return result;
    }

    // Main method to demonstrate finding the minimum sum subarray.
    public static void main(String[] args) {
        // Initialize the 'nums' array and subarray size 'k'.
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 4;

        // Print the original array and subarray size.
        System.out.printf("\nOriginal array: " + Arrays.toString(nums));
        System.out.printf("\nSub-array size: %d", k);

        // Find and print the minimum sum subarray.
        int[] result = find_min_subarray_sum(nums, k);
        System.out.printf("\nSub-array from %d to %d and sum is: %d", result[0], result[1], result[2]);
    }
}
```
Sample Output:

Original array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Sub-array size: 4
Sub-array from 0 to 3 and sum is: 10

### 70. Write a Java program to find the smallest length of a contiguous subarray of which the sum is greater than or equal to a specified value. Return 0 instead.  

Example:
Input :
nums = {1, 2, 3, 4, 6}
Output:
Minimum length of a contiguous subarray of which the sum is 8, 2
```java
// Import the necessary Java classes.
import java.util.Arrays;

// Define the 'solution' class.
public class solution {
  public static void main(String[] args)
  {
    // Initialize the 'nums' array and the target sum 'm_len'.
    int[] nums = {1, 2, 3, 4, 6};
    int m_len = 8;

    // Find and store the minimum subarray length with a sum of 'm_len'.
    int result = min_SubArray_length(m_len, nums);

    // Print the original array and the minimum subarray length.
    System.out.printf("\nOriginal array: " + Arrays.toString(nums));
    System.out.printf("\nMinimum length of a contiguous subarray of which the sum is %d: %d", m_len, result);
  }

  public static int min_SubArray_length(int s, int[] nums) {
    // Initialize variables for sum, counter, and minimum length.
    int sum = 0, ctr = 0, min_len = Integer.MAX_VALUE;
    
    // Iterate through the 'nums' array.
    for (int i = 0, j = 0; j < nums.length; ) {
      // Check if the current element is greater than or equal to the target sum 's'.
      if (nums[j] >= s) {
        return 1; // A single element is sufficient.
      } else {
        // Update the sum and counter with the current element.
        sum += nums[j];
        ctr++;
        
        // Check if the current subarray sum is greater than or equal to 's'.
        if (sum >= s) {
          // Update the minimum length, then shrink the subarray from the front.
          min_len = Math.min(min_len, ctr);
          while (j > i) {
            sum -= nums[i];
            ctr--;
            i++;
            if (sum < s) break;
            min_len = Math.min(min_len, ctr);
          }
        }
      }
      j++;
    }
    
    // Check if the minimum length was updated, and return it.
    if (min_len == Integer.MAX_VALUE) {
      return 0; // No subarray found.
    }
    return min_len;
  }
}
```
Sample Output:

Original array: [1, 2, 3, 4, 6]
Minimum length of a contiguous subarray of which the sum is 8, 2

### 71. Write a Java program to find the largest number from a given list of non-negative integers.  

Example:
Input :
nums = {1, 2, 3, 0, 4, 6}
Output:
Largest number using the said array numbers: 643210
```java
// Import the necessary Java classes.
import java.util.*;

// Define the 'solution' class.
public class solution {

  // Define a method to find the largest number using an array of numbers.
  public static String largest_Numbers(int[] num) {
    // Convert the array of numbers to an array of strings.
    String[] array_nums = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
    
    // Sort the array of strings in descending order, considering their concatenated values.
    Arrays.sort(array_nums, (String str1, String str2) -> (str2 + str1).compareTo(str1 + str2));
    
    // Reduce the sorted array to find the largest number.
    return Arrays.stream(array_nums).reduce((a, b) -> a.equals("0") ? b : a + b).get();
  }	
	
  public static void main(String[] args)
  {
    // Initialize an array of numbers.
    int[] nums = {1, 2, 3, 0, 4, 6};
    
    // Print the original array and the largest number using the array elements.
    System.out.printf("\nOriginal array: " + Arrays.toString(nums));	
    System.out.printf("\nLargest number using the said array numbers: " + largest_Numbers(nums));
  }  
}
```
Sample Output:

Original array: [1, 2, 3, 0, 4, 6]
Largest number using the said array numbers: 643210

### 72. Write a Java program to find and print one continuous subarray (from a given array of integers) that if you only sort the said subarray in ascending order then the entire array will be sorted in ascending order.  

Example:
Input :
nums1 = {1, 2, 3, 0, 4, 6}
nums2 = { 1, 3, 2, 7, 5, 6, 4, 8}
Output:
Continuous subarray:
1 2 3 0
Continuous subarray:
3 2 7 5 6 4
```java
// Import the necessary Java classes.
import java.util.Arrays;

// Define the 'solution' class.
public class solution {
  // Define a method to find the minimum continuous subarray for sorting.
  public static int[] findUnsortedSubarray(int[] nums) {
    // Initialize an array to store the result, where result[0] represents the start index and result[1] represents the end index.
    int[] result = new int[2];
    
    // Get the length of the input array.
    int n = nums.length;
    
    // Initialize variables for the start and end indices and for finding the minimum and maximum values.
    int start = -1;
    int end = -2;
    int min = nums[n - 1];
    int max = nums[0];
    
    // Traverse the array to find the subarray that needs sorting.
    for (int i = 1; i < n; i++) {
      // Update the maximum and minimum values.
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[n - 1 - i]);
      
      // Check if the current element is less than the maximum value.
      if (nums[i] < max) {
        end = i;
      }
      
      // Check if the current element is greater than the minimum value.
      if (nums[n - 1 - i] > min) {
        start = n - 1 - i;
      }
    }
    
    // Update the result array with the start and end indices of the subarray to be sorted.
    result[0] = start;
    result[1] = end;

    // Return the result.
    return result;
  }
    
  public static void main(String[] args)
  {
    // Initialize the first array.
    int[] nums1 = {1, 2, 3, 0, 4, 6};
    System.out.printf("\nOriginal array: "+Arrays.toString(nums1));	

    // Find and print the continuous subarray that needs sorting.
    int[] result1 = findUnsortedSubarray(nums1);
    System.out.printf("\nContinuous subarray:\n");
    for (int i = result1[0]; i <= result1[1]; i++) {
        System.out.print(nums1[i] + " ");
    }

    // Initialize the second array.
    int[] nums2 = { 1, 3, 2, 7, 5, 6, 4, 8};
    System.out.printf("\n\nOriginal array: "+Arrays.toString(nums2));	
    System.out.printf("\nContinuous subarray:\n"); 

    // Find and print the continuous subarray that needs sorting.
    int[] result2 = findUnsortedSubarray(nums2);
    
    for (int i = result2[0]; i <= result2[1]; i++) {
        System.out.print(nums2[i] + " ");
    }
  }  
}
```
Sample Output:

Original array: [1, 2, 3, 0, 4, 6]
Continuous subarray:
1 2 3 0 

Original array: [1, 3, 2, 7, 5, 6, 4, 8]
Continuous subarray:
3 2 7 5 6 4 

### 73. Write a Java program to sort a given array of distinct integers where all its numbers are sorted except two numbers.  

Example:
Input :
nums1 = { 3, 5, 6, 9, 8, 7 }
nums2 = { 5, 0, 1, 2, 3, 4, -2 }
Output:
After sorting new array becomes: [3, 5, 6, 7, 8, 9]
After sorting new array becomes: [-2, 0, 1, 2, 3, 4, 5]
```java
// Import the necessary Java classes.
import java.util.Arrays;

// Define the 'solution' class.
class solution
{
    // Define a private method to sort the given array.
	private static int [] sort_Array(int[] nums)
	{
		// Initialize variables to track indices for swapping.
		int x = -1, y = -1;
		// Initialize a variable to store the previous element in the array.
		int prev = nums[0];

		// Traverse the array to find elements that need to be swapped.
		for (int i = 1; i < nums.length; i++)
		{
			// Compare the current element with the previous element.
			if (prev > nums[i])
			{
				// If this is the first unsorted pair, set x and y.
				if (x == -1) {
					x = i - 1;
					y = i;
				}
				// If a previous unsorted pair exists, update y.
				else {
					y = i;
				}
			}
			// Update the previous element.
			prev = nums[i];
		}

		// Call a private method to swap the elements at indices x and y.
		swap_nums(nums, x, y);
		// Return the sorted array.
		return nums;
	}

    // Define a private method to swap two elements in the array.
	private static void swap_nums(int[] a, int i, int j) {
		int temp_val = a[i];
		a[i] = a[j];
		a[j] = temp_val;
	}

    // Define the main method for running the program.
	public static void main(String[] args)
	{
		// Initialize the first array.
		int[] nums1 = { 3, 5, 6, 9, 8, 7 };
        System.out.println("\nOriginal array: "+Arrays.toString(nums1));
		// Call the sort_Array method to sort the array and print the result.
		int[] result1 = sort_Array(nums1);
		System.out.println("\nAfter sorting new array becomes: "+Arrays.toString(result1));

		// Initialize the second array.
		int[] nums2 = { 5, 0, 1, 2, 3, 4, -2 };
        System.out.println("\nOriginal array: "+Arrays.toString(nums2));
		// Call the sort_Array method to sort the array and print the result.
		int[] result2 = sort_Array(nums2);
		System.out.println("\nAfter sorting new array becomes: "+Arrays.toString(result2));
	}
}
```
Sample Output:

Original array: [3, 5, 6, 9, 8, 7]

After sorting new array becomes: [3, 5, 6, 7, 8, 9]

Original array: [5, 0, 1, 2, 3, 4, -2]

After sorting new array becomes: [-2, 0, 1, 2, 3, 4, 5]

### 74. Write a Java program to find all triplets equal to a given sum in an unsorted array of integers.  

Example:
Input :
nums = { 1, 6, 3, 0, 8, 4, 1, 7 }
Output:
Triplets of sum 7
(0 1 6)
(0 3 4)
```java
// Import the necessary Java classes.
import java.util.Arrays;
// Define the 'solution' class.
class solution {
    // Define a method to find and print all triplets with a given sum.
    public static void find_and_print_all_Triplets(int[] nums, int sum, int alen)
    {
        System.out.println("\nTriplets of sum " + sum);
        // Iterate through the array, leaving space for at least three elements.
        for (int i = 0; i <= alen - 3; i++)
        {
            int k = sum - nums[i];
            int l_index = i + 1, h_index = nums.length - 1;
            // Use a two-pointer approach to find triplets that sum up to 'k'.
            while (l_index < h_index)
            {
                if (nums[l_index] + nums[h_index] < k) {
                    l_index++;
                }
                else if (nums[l_index] + nums[h_index] > k) {
                    h_index--;
                }
                else {
                    // Print the triplet and adjust the pointers.
                    System.out.println("(" + nums[i] + " " + nums[l_index] + " " + nums[h_index] + ")");
                    l_index++;
                    h_index--;
                }
            }
        }
    }
    // Define the main method for running the program.
    public static void main(String[] args)
    {
        // Initialize the array and its length.
        int[] nums = { 1, 6, 3, 0, 8, 4, 1, 7 };
        int alen = nums.length;
        System.out.println("\nOriginal array: " + Arrays.toString(nums));
        // Sort the array in ascending order.
        Arrays.sort(nums);
        int sum = 7;
        // Call the 'find_and_print_all_Triplets' method to find and print triplets with the given sum.
        find_and_print_all_Triplets(nums, sum, alen);
    }
}
```
Sample Output:

Original array: [1, 6, 3, 0, 8, 4, 1, 7]

Triplets of sum 7
(0 1 6)
(0 3 4)

### 75. Write a Java program to calculate the largest gap between sorted elements of an array of integers.  

Example:
Original array: [23, -2, 45, 38, 12, 4, 6]
Largest gap between sorted elements of the said array: 15
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of numbers.
    //int[] nums = {1, 2 ,9, 0, 4, 6};
    int[] nums = {23, -2, 45, 38, 12, 4, 6};
    System.out.printf("\nOriginal array: " + Arrays.toString(nums));

    // Call the 'test' method to find the largest gap between sorted elements of the array.
    int result = test(nums);
    System.out.printf("\nLargest gap between sorted elements of the said array: " + result);
  }

  // Define the 'test' method to find the largest gap between sorted elements of the array.
  public static int test(int[] nums) {
    // Sort the 'nums' array in ascending order.
    Arrays.sort(nums);
    int max_val = 0;

    // Iterate through the sorted array and find the maximum gap between adjacent elements.
    for (int i = 0; i < nums.length - 1; i++) {
      max_val = Math.max(nums[i + 1] - nums[i], max_val);
    }
    return max_val;
  }
}
```
Sample Output:

Original array: [23, -2, 45, 38, 12, 4, 6]
Largest gap between sorted elements of the said array: 15

### 76. Write a Java program to determine whether numbers in an array can be rearranged so that each number appears exactly once in a consecutive list of numbers. Return true otherwise false.  

Example:
Original array: [1, 2, 5, 0, 4, 3, 6]
Check consecutive numbers in the said array!true
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of numbers.
    int[] nums = {1, 2 ,5, 0, 4, 3, 6};
    // int[] nums = {1, 2 ,5, 0, 3, 6, 7};
    System.out.printf("\nOriginal array: " + Arrays.toString(nums));

    // Call the 'test' method to check for consecutive numbers in the array.
    boolean result = test(nums);
    System.out.printf("\nCheck consecutive numbers in the said array! " + result);
  }

  // Define the 'test' method to check for consecutive numbers in the array.
  public static boolean test(int[] nums) {
    // Sort the 'nums' array in ascending order.
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      // Check if the current number and the next number are consecutive.
      if (nums[i] + 1 != nums[i + 1])
        return false;
    }
    return true;
  }
}
```
Sample Output:

Original array: [1, 2, 5, 0, 4, 3, 6]
Check consecutive numbers in the said array!true

Sample Solution-2:

Java Code:
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of numbers.
    int[] nums = {1, 2 ,5, 0, 3, 6, 7};
    // int[] nums = {1, 2 ,5, 0, 4, 3, 6};
    System.out.printf("\nOriginal array: " + Arrays.toString(nums));

    // Call the 'test' method to check for consecutive numbers in the array.
    boolean result = test(nums);
    System.out.printf("\nCheck consecutive numbers in the said array! " + result);
  }

  // Define the 'test' method to check for consecutive numbers in the array.
  public static boolean test(int[] nums) {
    // Sort the 'nums' array in ascending order.
    Arrays.sort(nums);
    // Check if the last number in the sorted array is equal to the first number plus the array length minus 1.
    return nums[nums.length - 1] == (nums[0] + nums.length - 1);
  }
}
```
Sample Output:

Original array: [1, 2, 5, 0, 3, 6, 7]
Check consecutive numbers in the said array!false

### 77. Write a Java program that checks whether an array of integers alternates between positive and negative values.  

Example:
Original array: [1, -2, 5, -4, 3, -6]
Check the said array of integers alternates between positive and negative values!true
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of numbers.
    int[] nums = {1, -2, 5, -4, 3, -6 };
    // Alternatively: int[] nums = {1, 2 ,5, 4, 3, 6};
    System.out.printf("\nOriginal array: " + Arrays.toString(nums));

    // Call the 'test' method to check if the array alternates between positive and negative values.
    boolean result = test(nums);
    System.out.printf("\nCheck the said array of integers alternates between positive and negative values! " + result);
  }

  // Define the 'test' method to check if the array alternates between positive and negative values.
  public static boolean test(int[] nums) {
    // Iterate through the elements in the 'nums' array.
    for (int n: nums) {
      // If any element is zero, return false.
      if (n == 0)
        return false;
    }
    // Iterate through the 'nums' array, starting from the second element.
    for (int i = 1; i < nums.length; i++) {
      // Check if there are consecutive positive or negative numbers; return false if found.
      if (nums[i - 1] > 0 && nums[i] > 0) {
        return false;
      } else if (nums[i - 1] < 0 && nums[i] < 0) {
        return false;
      }
    }
    // If no consecutive positive or negative numbers are found, return true.
    return true;
  }
}
```
Sample Output:

Original array: [1, -2, 5, -4, 3, -6]
Check the said array of integers alternates between positive and negative values!true

Sample Solution-2:

Java Code:
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of numbers.
    int[] nums = {
      1,
      -2,
      5,
      -4,
      3,
      -6
    };
    // Alternatively: int[] nums = {1, 2 ,5, 4, 3, 6};
    System.out.printf("\nOriginal array: " + Arrays.toString(nums));

    // Call the 'test' method to check if the array alternates between positive and negative values.
    boolean result = test(nums);
    System.out.printf("\nCheck the said array of integers alternates between positive and negative values! " + result);
  }

  // Define the 'test' method to check if the array alternates between positive and negative values.
  public static boolean test(int[] nums) {
    // Check if the array contains a single element with the value 0; return false in this case.
    if (nums.length == 1 && nums[0] == 0)
      return false;
    // Iterate through the 'nums' array.
    for (int i = 0; i < nums.length - 1; i++)
      // Check if the product of adjacent elements is non-negative (i.e., both positive or both negative); return false in this case.
      if (nums[i] * nums[i + 1] >= 0)
        return false;
    // If no consecutive elements with the same sign are found, return true.
    return true;
  }
}
```
Sample Output:

Original array: [1, -2, 5, -4, 3, -6]
Check the said array of integers alternates between positive and negative values!true
### 78. Write a Java program that checks whether an array is negative dominant or not. If the array is negative dominant return true otherwise false.  

Example:
Original array of numbers:
[1, -2, -5, -4, 3, -6]
Check Negative Dominance in the said array!true
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of numbers.
    int[] nums = {1, -2, -5, -4, 3, -6};
    // Alternative input arrays:
    // int[] nums = {1, 2, 5, -4, 3, -6};
    // int[] nums = {1, 2, -5, -4, -3, 6};
    System.out.printf("\nOriginal array of numbers:\n" + Arrays.toString(nums));

    // Call the 'test' method to check for negative dominance in the array.
    boolean result = test(nums);
    System.out.printf("\nCheck Negative Dominance in the said array! " + result);
  }

  // Define the 'test' method to check for negative dominance in the array.
  public static boolean test(int[] nums) {
    long count_negative, count_positive;
    // Remove duplicate values from the 'nums' array using the 'distinct' method.
    nums = Arrays.stream(nums).distinct().toArray();
    // Count the number of negative and positive elements in the array.
    count_negative = Arrays.stream(nums).filter(s -> s < 0).count();
    count_positive = Arrays.stream(nums).filter(s -> s > 0).count();
    // Return 'true' if there are more negative elements, indicating negative dominance.
    return count_negative > count_positive;
  }
} 
```
Sample Output:

Original array of numbers:
[1, -2, -5, -4, 3, -6]
Check Negative Dominance in the said array!true
Flowchart:

Flowchart: Negative Dominant.
Sample Solution-2:

Java Code:
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of numbers.
    int[] nums = {1, -2, -5, -4, 3, -6};
    // Alternative input arrays:
    // int[] nums = {1, 2, 5, -4, 3, -6};
    // int[] nums = {1, 2, -5, -4, -3, 6};
    System.out.printf("Original array of numbers:\n" + Arrays.toString(nums));

    // Call the 'test' method to check for negative dominance in the array.
    boolean result = test(nums);
    System.out.printf("\nCheck Negative Dominance in the said array! " + result);
  }

  // Define the 'test' method to check for negative dominance in the array.
  public static boolean test(int[] nums) {
    // Use IntStream to process the array and check for negative dominance.
    return IntStream.of(nums).distinct().filter(element -> element < 0).count() >
           IntStream.of(nums).distinct().filter(element -> element > 0).count();
  }
} 
```
Sample Output:

Original array of numbers:
[1, -2, -5, -4, 3, -6]
Check Negative Dominance in the said array!true

### 79. Write a Java program that returns the missing letter from an array of increasing letters (upper or lower). Assume there will always be one omission from the array.  

Example:
Original array of elements:
[p, r, s, t]
Missing letter in the said array: q
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of strings representing letters.
    // You can use one of these alternative 'str_arra' arrays by uncommenting them.
    // String[] str_arra = {"A", "B", "D", "E"};
    // String[] str_arra = {"a", "b", "c", "e"};
    String[] str_arra = {"p", "r", "s", "t"};
    System.out.printf("Original array of elements:\n" + Arrays.toString(str_arra));

    // Call the 'test' method to find the missing letter in the array.
    String result = test(str_arra);
    System.out.printf("\nMissing letter in the said array: " + result);
  }

  // Define the 'test' method to find the missing letter in the array.
  public static String test(String[] str_arra) {
    // Calculate the expected character code for the missing letter.
    int c = str_arra[0].charAt(0) + 1;
    
    // Iterate through the array and check for the missing letter.
    for (int i = 1; i < str_arra.length; i++, c++) {
      if (str_arra[i].charAt(0) != c) {
        return String.valueOf((char) c);
      }
    }
    
    // Return an empty string if no letter is missing.
    return "";
  }
} 
```
Sample Output:

Original array of elements:
[p, r, s, t]
Missing letter in the said array: q
Flowchart:

Flowchart: Missing letter from an array of increasing letters.
Sample Solution-2:

Java Code:
```java
// Import necessary Java classes.
import java.util.Scanner;
import java.util.Arrays;

// Define the 'Main' class.
public class Main {
  // Define the main method for running the program.
  public static void main(String[] args) {
    // Initialize an array of strings representing letters.
    // You can use one of these alternative 'str_arra' arrays by uncommenting them.
    String[] str_arra = {"A", "B", "D", "E"};
    // String[] str_arra = {"a", "b", "c", "e"};
    // String[] str_arra = {"p", "r", "s", "t"};
    
    // Print the original array of elements.
    System.out.printf("Original array of elements:\n" + Arrays.toString(str_arra));

    // Call the 'test' method to find the missing letter in the array.
    String result = test(str_arra);
    
    // Print the missing letter found in the array.
    System.out.printf("\nMissing letter in the said array: " + result);
  }

  // Define the 'test' method to find the missing letter in the array.
  public static String test(String[] str_arra) {
    // Iterate through the array to find the missing letter.
    for (int i = 0; i < str_arra.length - 1; i++) {
      // Check the difference between adjacent characters.
      if (str_arra[i + 1].charAt(0) - str_arra[i].charAt(0) > 1) {
        // Calculate and return the missing character as a string.
        String result_char = "" + (char)((int)str_arra[i].charAt(0) + 1);
        return result_char;
      }
    }
    
    // Return an empty string if no letter is missing.
    return "";
  }
}
```
Sample Output:

Original array of elements:
[A, B, D, E]
Missing letter in the said array: C
