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

### Array Sort

```java

package com.javaprogramto.models;

public class Employee {

    private int id;
    private String fullName;
    private int age;

    public Employee(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
```
```java
package com.javaprogramto.arrays.comparator;

import java.util.Arrays;

import com.Employee;

public class ArraysSortComparatorExample {

	public static void main(String[] args) {

		Employee[] empArray = new Employee[5];

		empArray[0] = new Employee(100, "Malik Mona", 30);
		empArray[1] = new Employee(105, "A Z", 35);
		empArray[2] = new Employee(102, "B Z", 33);
		empArray[3] = new Employee(103, "C Z", 31);
		empArray[4] = new Employee(104, "D Z", 34);

		System.out.println("emp array before sort - ");
		Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

		Arrays.sort(empArray);

		System.out.println("emp array after sort - ");
		Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

	}

}
```
Output:

```
emp array before sort - 
Employee{id=100, fullName='Malik Mona', age=30}
Employee{id=105, fullName='A Z', age=35}
Employee{id=102, fullName='B Z', age=33}
Employee{id=103, fullName='C Z', age=31}
Employee{id=104, fullName='D Z', age=34}
Exception in thread "main" java.lang.ClassCastException: class com.javaprogramto.models.Employee cannot be cast to class java.lang.Comparable (com.javaprogramto.models.Employee is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	at java.base/java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
	at java.base/java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
	at java.base/java.util.Arrays.sort(Arrays.java:1041)
	at com.javaprogramto.arrays.comparator.ArraysSortComparatorExample.main(ArraysSortComparatorExample.java:22)

```
//Implementing Comparable: The Employee class must implement Comparable<Employee>, and you override the compareTo method to provide the logic for comparing Employee objects. In this example, the natural ordering is based on the age field.
//
//Using Comparator: Instead of modifying the Employee class, you can define a Comparator to sort Employee objects based on specific fields. In the example provided, we used Comparator.comparingInt to sort by the age field.
```
The `ClassCastException` you're encountering occurs because the `Employee` class does not implement the `Comparable` interface, and you’re trying to use a sorting method that requires the objects to be comparable. Here's a detailed explanation of why this happens and how to resolve it:

### Understanding the Error

The `ClassCastException` indicates that the sorting method you’re using expects objects to be comparable, but your `Employee` class does not implement `Comparable`.

- **`java.lang.Comparable`**: This interface is used to define a natural ordering for objects of a class. If a class implements `Comparable`, it must override the `compareTo` method to provide a way to compare instances of the class.
- **`Arrays.sort()`**: When you use `Arrays.sort()` without providing a comparator, it relies on the objects being `Comparable`. Since `Employee` does not implement `Comparable`, this method cannot determine how to sort the `Employee` objects.

### Solution

There are two main ways to resolve this issue:

1. **Implement the `Comparable` Interface in `Employee` Class**:
   Implement the `Comparable<Employee>` interface in your `Employee` class and override the `compareTo` method to define the natural ordering of `Employee` objects.

   ```java
   public class Employee implements Comparable<Employee> {
       private int id;
       private String fullName;
       private int age;

       // Constructor, getters, setters

       @Override
       public int compareTo(Employee other) {
           // Define the natural ordering; for example, by age
           return Integer.compare(this.age, other.age);
       }

       @Override
       public String toString() {
           return "Employee{id=" + id + ", fullName='" + fullName + "', age=" + age + "}";
       }
   }
   ```

   Then you can sort the array of `Employee` objects using `Arrays.sort()` without a custom comparator:

   ```java
   Employee[] empArray = {
       new Employee(100, "Malik Mona", 30),
       new Employee(105, "A Z", 35),
       new Employee(102, "B Z", 33),
       new Employee(103, "C Z", 31),
       new Employee(104, "D Z", 34)
   };

   System.out.println("Before sort: " + Arrays.toString(empArray));

   Arrays.sort(empArray);

   System.out.println("After sort: " + Arrays.toString(empArray));
   ```

2. **Provide a Comparator**:
   If you do not want to modify the `Employee` class or need custom sorting that doesn't fit into the natural ordering, you can use a `Comparator` instead. This is useful for one-off sorts or different sorting criteria.

   ```java
   Employee[] empArray = {
       new Employee(100, "Malik Mona", 30),
       new Employee(105, "A Z", 35),
       new Employee(102, "B Z", 33),
       new Employee(103, "C Z", 31),
       new Employee(104, "D Z", 34)
   };

   System.out.println("Before sort: " + Arrays.toString(empArray));

   Arrays.sort(empArray, Comparator.comparingInt(Employee::getAge));

   System.out.println("After sort: " + Arrays.toString(empArray));
   ```

   In this example, `Comparator.comparingInt(Employee::getAge)` creates a comparator that sorts employees by age.

### Summary

- **Implementing `Comparable`**: Modify the `Employee` class to implement `Comparable<Employee>` if you want a natural ordering for sorting.
- **Using `Comparator`**: Use `Comparator` if you need custom sorting criteria without modifying the `Employee` class.

Both approaches are valid, and the choice depends on whether you want to define a natural order for `Employee` objects or need specific sorting logic.

```java

public class Employee implements Comparable<Employee> {
    private int id;
    private String fullName;
    private int age;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	

    public Employee(int id, String fullName, int age) {
	this.id = id;
	this.fullName = fullName;
	this.age = age;
    }

    @Override
    public String toString() {
	return "Employee{id=" + id + ", fullName='" + fullName + "', age=" + age + "}";
    }

    @Override
    public int compareTo(Employee1 other) {
	// Define the natural ordering based on age
	return Integer.compare(this.age, other.age);
    }

    // Getters and setters (if needed)
}
```
```java

import java.util.Arrays;
import java.util.Comparator;//Using Comparator

public class ArraysSortComparatorExample {

    public static void main(String[] args) {
        Employee1[] empArray = new Employee1[5];

        empArray[0] = new Employee(100, "Malik Mona", 30);
        empArray[1] = new Employee(105, "A Z", 35);
        empArray[2] = new Employee(102, "B Z", 33);
        empArray[3] = new Employee(103, "C Z", 31);
        empArray[4] = new Employee(104, "D Z", 34);

        System.out.println("emp array before sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

        Arrays.sort(empArray);

        System.out.println("emp array after sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));
        
        System.out.println("emp array before sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

        // Sort by age using Comparator -1
        Arrays.sort(empArray, Comparator.comparingInt(emp -> emp.getAge()));
        
        // Sort by age using Comparator and getter method -2
        // Arrays.sort(empArray, Comparator.comparingInt(Employee::getAge));

        System.out.println("emp array after sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));
    }
}
```
Output:
```
emp array before sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=105, fullName='A Z', age=35}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=104, fullName='D Z', age=34}
emp array after sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=104, fullName='D Z', age=34}
Employee1{id=105, fullName='A Z', age=35}
emp array before sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=104, fullName='D Z', age=34}
Employee1{id=105, fullName='A Z', age=35}
emp array after sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=104, fullName='D Z', age=34}
Employee1{id=105, fullName='A Z', age=35}
```

```java

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraySortReverse {

	public static void main(String[] args) {

		// Array Integers

		Integer[] ints = new Integer[5];
		ints[0] = 20;
		ints[1] = 50;
		ints[2] = 40;
		ints[3] = 10;
		ints[4] = 30;

		System.out.println("Integer array before sort - " + Arrays.toString(ints));
		
		Arrays.sort(ints, Collections.reverseOrder());

		System.out.println("Integer array after sort - " + Arrays.toString(ints));

               // Array Int Primitive

		int[] ints1 = new int[5];
		ints1[0] = 20;
		ints1[1] = 50;
		ints1[2] = 40;
		ints1[3] = 10;
		ints1[4] = 30;
		
		List<Integer> stream= IntStream.of(ints1).boxed()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		System.out.println("Integer array after sort - " + stream.toString());
		Stream<Integer> stream1= IntStream.of(ints1).boxed()
				.distinct()
				.sorted(Comparator.reverseOrder());
		
		stream1.forEach(e->System.out.println(e));

		//String Array

		String[] stringArray = new String[5];
		stringArray[0] = "G";
		stringArray[1] = "Z";
		stringArray[2] = "A";
		stringArray[3] = "N";
		stringArray[4] = "I";

		System.out.println("String array before sort - " + Arrays.toString(stringArray));
		Arrays.sort(stringArray, Collections.reverseOrder());

		System.out.println("String array after sort - " + Arrays.toString(stringArray));
		
		String[] stringArray1 = {"G","Z","A","N","I"};
		
		System.out.println("String array before sort - " + Arrays.toString(stringArray1));
		Arrays.sort(stringArray1, Collections.reverseOrder());

		System.out.println("String array after sort - " + Arrays.toString(stringArray1));

		//Array Of Custom Object
		Employee[] empArray = new Employee[5];
		empArray[0] = new Employee(500, "A", "2000");
		empArray[1] = new Employee(300, "B", "2001");
		empArray[2] = new Employee(200, "C", "2002");
		empArray[3] = new Employee(400, "D", "2003");
		empArray[4] = new Employee(100, "E", "2004");

		System.out.println("Employee array before sort ");
		for (Employee e : empArray) {
			System.out.println(e);
		}
		Arrays.sort(empArray, Collections.reverseOrder());

		System.out.println("\n" + "Employee array after sort");
		for (Employee e : empArray) {
			System.out.println(e);
		}
	}
}

class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String dateOfJoin;

	public Employee(int id, String name, String dateOfJoin) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfJoin = dateOfJoin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfJoin=" + dateOfJoin + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.getId()).compareTo(o.getId());
	}

}
```
