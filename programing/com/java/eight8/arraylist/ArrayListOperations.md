# com\java\eight8\arraylist\ArrayListOperations.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListOperations {

	public static void main(String[] args) {

		// 1) Explain the different ways of constructing an ArrayList
		ArrayList<String> list1 = new ArrayList<String>(); // Construct an empty ArrayList
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("Apple", "Banana", "Cherry")); // Construct an
	
		// 2) Increase the current capacity of an ArrayList
		list1.ensureCapacity(20); // Increase the capacity of list1 to 20

		// 3) Decrease the current capacity of an ArrayList to the current size
		list1.trimToSize();

		// 4) Find the number of elements present in an ArrayList
		int size = list2.size();
		System.out.println("Number of elements in list2: " + size);

		// 5) Check if the ArrayList is empty or not
		boolean isEmpty = list1.isEmpty();
		System.out.println("Is list1 empty? " + isEmpty);

		// 6) Check if a particular element is present in an ArrayList
		boolean containsElement = list2.contains("Banana");
		System.out.println("Does list2 contain 'Banana'? " + containsElement);

		// 7) Get the index of a particular element in an ArrayList
		int index = list2.indexOf("Cherry");
		System.out.println("Index of 'Cherry' in list2: " + index);

		// 8) Convert an ArrayList to Array
		String[] array = new String[list2.size()];
		array = list2.toArray(array);

		// 9) Retrieve an element from a particular position of an ArrayList
		String element = list2.get(1);
		System.out.println("Element at index 1 in list2: " + element);

		// 10) Replace a particular element in an ArrayList
		list2.set(0, "Mango");
		System.out.println("After replacing element at index 0 in list2: " + list2);

		// 11) Append an element at the end of an ArrayList
		list2.add("Kiwi");
		System.out.println("After appending 'Kiwi' to list2: " + list2);

		// 12) Insert an element at a particular position of an ArrayList
		list2.add(2, "Grapes");
		System.out.println("After inserting 'Grapes' at index 2 in list2: " + list2);

		// 13) Remove an element from a particular position of an ArrayList
		list2.remove(3);
		System.out.println("After removing element at index 3 in list2: " + list2);

		// 14) Remove a given element from an ArrayList
		list2.remove("Mango");
		System.out.println("After removing 'Mango' from list2: " + list2);

		// 15) Remove all elements of an ArrayList at once
		list2.clear();
		System.out.println("After clearing list2: " + list2);

		// 16) Retrieve a portion of an ArrayList
		ArrayList<String> sublist = new ArrayList<String>(list1.subList(1, 3));
		System.out.println("Sublist of list1: " + sublist);

		// 17) Join two ArrayLists
		ArrayList<String> newList = new ArrayList<String>();
		newList.addAll(list1);
		newList.addAll(list2);
		System.out.println("After joining list1 and list2: " + newList);

		// 18) Insert more than one element at a particular position of an ArrayList
		list1.addAll(1, Arrays.asList("Orange", "Pineapple"));
		System.out.println("After inserting 'Orange' and 'Pineapple' at index 1 in list1: " + list1);
	}
}
```
