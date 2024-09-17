# Collection framework examples

### Add to in Array

```java
import java.util.Arrays;

public class JavaArrayToAddExample {

	public static void main(String[] args) {

		int[] values = new int[5];

		values[0] = 0;
		values[1] = 1;
		values[2] = 2;
		values[3] = 3;
		values[4] = 4;

		int[] newArray = new int[5 + 1];

		for (int i = 0; i < values.length; i++) {
			newArray[i] = values[i];
		}

		int newValue = 5;
		int newArraylength = newArray.length;
		newArray[newArraylength - 1] = newValue;
		
		System.out.println("Existing array values  " + Arrays.toString(values));
		System.out.println("New array values  " + Arrays.toString(newArray));

	}

}
```
Output:

```
Existing array values  [0, 1, 2, 3, 4]
New array values  [0, 1, 2, 3, 4, 5]

```
### Using ArrayList

```

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaArrayToAddInList {

	public static void main(String[] args) {

		Integer[] array = { 10, 20, 30, 40, 30, 40 };

		System.out.println("Initial array values " + Arrays.toString(array));

		List<Integer> integers = new ArrayList<>();

		for (int a : array) {
			integers.add(a);
		}

		int newValue = 50;

		integers.add(newValue);

		array = integers.toArray(array);

		System.out.println("Array after adding 50 value " + Arrays.toString(array));

	}
}
```

Output:

```
Initial array values [10, 20, 30, 40, 30, 40]
Array after adding 50 value [10, 20, 30, 40, 30, 40, 50] //list allows duplicate but element stored in insertion order

```

```java

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JavaArrayToAddInSet {

	public static void main(String[] args) {

		Integer[] array = { 10, 20, 30, 40, 30, 40 };

		System.out.println("Initial array values " + Arrays.toString(array));

		Set<Integer> integers = new HashSet<>();

		for (int a : array) {
			integers.add(a);
		}
		System.out.println("After adding in set values " + integers);

		int newValue = 50;

		integers.add(newValue);

		array = integers.toArray(array);

		System.out.println("Array after adding 50 value " + Arrays.toString(array));

	}
}
```
Output:

```
Initial array values [10, 20, 30, 40, 30, 40]
After adding in set values [20, 40, 10, 30] //set removed duplicate but no guarantee of order
Array after adding 50 value [50, 20, 40, 10, 30, null]

```

In Java, the behavior you’re seeing with the `HashSet` not maintaining the order of elements is expected and intentional. Here’s a detailed explanation of why this happens:

### Why Order is Not Maintained

1. **HashSet Characteristics**:
   - **No Order Guarantee**: A `HashSet` is a collection that does not guarantee any specific order of its elements. It uses a hash table for storage, which means that elements are placed into the set based on their hash codes.
   - **Hash-Based Storage**: When you add elements to a `HashSet`, they are stored in a way that optimizes lookup time rather than maintaining the order they were added in. The internal structure of the `HashSet` is a hash table, which does not preserve insertion order.

2. **Hash Function**:
   - The position of an element in the `HashSet` is determined by its hash code, which is derived from the element's `hashCode()` method. The ordering of elements in the set is based on these hash codes and not on the order of insertion.

### Example Explanation

Here’s your code for reference:
```java
Integer[] array = { 10, 20, 30, 40, 30, 40 };

System.out.println("Initial array values " + Arrays.toString(array));

Set<Integer> integers = new HashSet<>();

for (int a : array) {
    integers.add(a);
}
System.out.println("After adding in set values " + integers);
```

**Output**:
```
Initial array values [10, 20, 30, 40, 30, 40]
After adding in set values [20, 40, 10, 30]
```

- **Initial Array Values**: The original array has duplicate values and a specific insertion order.
- **Set Values**: When you add these values to a `HashSet`, the duplicates are removed (since `HashSet` does not allow duplicates), but the order in which the remaining unique elements are printed is not guaranteed.

### Alternative Collections for Order Preservation

If you need to maintain the order of insertion or any specific ordering, consider using the following alternatives:

1. **LinkedHashSet**:
   - **Maintains Insertion Order**: A `LinkedHashSet` maintains the order of elements as they are inserted. It uses a linked list internally to preserve the order.
   - **Usage Example**:
     ```java
     Set<Integer> integers = new LinkedHashSet<>(Arrays.asList(array));
     System.out.println("After adding in LinkedHashSet values " + integers);
     ```
   - This will preserve the order `[10, 20, 30, 40]`.

2. **TreeSet**:
   - **Sorted Order**: If you want the elements to be sorted according to their natural order (or a custom comparator), use a `TreeSet`.
   - **Usage Example**:
     ```java
     Set<Integer> integers = new TreeSet<>(Arrays.asList(array));
     System.out.println("After adding in TreeSet values " + integers);
     ```
   - This will sort the elements and output `[10, 20, 30, 40]`.

### Summary

- **`HashSet`** does not maintain any specific order of elements and uses a hash table for fast access.
- **`LinkedHashSet`** maintains the order of insertion.
- **`TreeSet`** sorts elements based on their natural order or a specified comparator.

Choose the appropriate set implementation based on whether you need order preservation or sorted order.


```java

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MergeAndRemoveDuplicates {
    public static void main(String[] args) {
        // Define the input arrays
        int[] arr1 = {3, 2, 1, 4, 5, 6, 8, 7, 6, 9};
        int[] arr2 = {8, 9, 10, 11, 12, 13, 15, 14, 15, 14, 16, 17};
        
        // Merge arrays
        int[] mergedArray = mergeArrays(arr1, arr2);
        
        // Remove duplicates
        int[] uniqueArray = removeDuplicates(mergedArray);
        
        // Print the result
        System.out.println("Merged and unique array: " + Arrays.toString(uniqueArray));
        
     // Merge arrays and remove duplicates using streams
        int[] uniqueArray1 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                                  .distinct()
                                  .sorted()
                                  .toArray();
        
        // Print the result
        System.out.println("Merged and unique array1: " + Arrays.toString(uniqueArray1));
    }

    // Method to merge two arrays
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // Create a new array with length equal to the sum of the two arrays
        int[] mergedArray = new int[arr1.length + arr2.length];
        
        // Copy the first array into the merged array
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        
        // Copy the second array into the merged array
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        
        return mergedArray;
    }

    // Method to remove duplicates from an array
    public static int[] removeDuplicates(int[] array) {
        // Create a Set to hold unique elements
        Set<Integer> set = new HashSet<>();
        
        // Add each element of the array to the Set
        for (int value : array) {
            set.add(value);
        }
        
        // Convert the Set back to an array
        int[] uniqueArray = new int[set.size()];
        int index = 0;
        for (int value : set) {
            uniqueArray[index++] = value;
        }
        
        return uniqueArray;
    }
}
```

### Boolean array

```java
public class BooleanArrayExample {

	public static void main(String[] args) {
		
		boolean[] array1 = {};

		boolean[] array2 = { false, true, true };

		boolean[] array3 = new boolean[5];

		System.out.println("array1 value - " + Arrays.toString(array1));
		System.out.println("array2 value - " + Arrays.toString(array2));
		System.out.println("array3 value - " + Arrays.toString(array3));
	}
}

```
Output:

```
array1 value - []
array2 value - [false, true, true]
array3 value - [false, false, false, false, false]//All intial values are false
```

```java

import java.util.Arrays;

public class BooleanArrayExample2 {

	public static void main(String[] args) {

		// way 1
		boolean[] array1 = { false, true, true };

		// way 2
		boolean[] array2 = new boolean[4];

		array2[0] = true;
		array2[1] = false;
		array2[2] = true;
		array2[3] = false;

		// way 3
		boolean[] array3 = new boolean[5];

		for (int i = 0; i < array3.length; i++) {
			array3[i] = i % 2 == 0;
		}

		System.out.println("array1 value - " + Arrays.toString(array1));
		System.out.println("array2 value - " + Arrays.toString(array2));
		System.out.println("array3 value - " + Arrays.toString(array3));

		System.out.println("array1[0] value - " + array1[0]);
		System.out.println("array2[1] value - " + array2[1]);
		System.out.println("array3 last index value - " + array3[array3.length - 1]);
		
		System.out.println("\nboolean array 3 all values using foreach ");
		for(boolean b : array3) {
			System.out.println(b);
		}

		boolean[] array4 = new boolean[4];

		System.out.println("Checking the default values of boolean array 4 with for each loop");
		for (boolean b : array4) {
			System.out.println(b);
		}

		boolean[] array5 = new boolean[5];

		System.out.println("Default value of array5 at index 1 is - " + array5[1]);

		System.out.println("Setting to true for all indexes of array 5 using simple for loop");
		for (int i = 0; i < array5.length; i++) {
			array5[i] = true;
		}
		System.out.println("Now Default value of array5 at index 1 is - " + array5[1]);

		boolean[] array6 = new boolean[5];

		System.out.println("Default values of array5 are " + Arrays.toString(array6));

		Arrays.fill(array6, true);

		System.out.println("New Default values of array5 are " + Arrays.toString(array6));
	}
}
```
Output:
```
array1 value - [false, true, true]
array2 value - [true, false, true, false]
array3 value - [true, false, true, false, true]

array1[0] value - false
array2[1] value - false
array3 last index value - true

boolean array 3 all values using foreach 
true
false
true
false
true

Checking the default values of boolean array 4 with for each loop
false
false
false
false

Default values of array5 are [false, false, false, false, false]
New Default values of array5 are [true, true, true, true, true]
```

```java

import java.util.Arrays;

public class BooleanArrayExample3 {

	public static void main(String[] args) {

		boolean[] array1 = {};
		System.out.println("array1 length - " + array1.length);

		boolean[] array2 = new boolean[2];
		System.out.println("array2 values - " + Arrays.toString(array2));

		for (int i = 0; i < array2.length; i++) {
			array2[i] = true;
		}

		System.out.println("New array2 values - " + Arrays.toString(array2));

		System.out.println("Acccessing array values by index - " + array2[1]);

		boolean[] array7 = new boolean[5];

		System.out.println("Default values of array7 are " + Arrays.toString(array7));

		Arrays.fill(array7, true);

		System.out.println("New Default values of array7 are " + Arrays.toString(array7));
	}
}
```
Output:

```
array1 length - 0
array2 values - [false, false]
New array2 values - [true, true]
Acccessing array values by index - true
Default values of array7 are [false, false, false, false, false]
New Default values of array7 are [true, true, true, true, true]
```
