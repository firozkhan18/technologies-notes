# com\java\eight8\array\ArrayElementRemovalProgramOne.java

```java
package com.java.eight8.array;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

//How To Remove An Element At Specific Index From An Array?
//ArrayUtils.remove(T[] inputArray, int index) is used to remove an element at specific index from an array. 
//The following program demonstrates the same.

public class ArrayElementRemovalProgramOne {
	public static void main(String[] args) {
		// Define an array with elements
		String[] arrayBeforeRemoval = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six" };
		System.out.println("Array Before Removal");
		System.out.println("========================");
		System.out.println(Arrays.toString(arrayBeforeRemoval));
		System.out.println("========================");
		// Removing an element "Two" from arrayBeforeRemoval
		String[] arrayAfterRemoval = ArrayUtils.removeElement(arrayBeforeRemoval, "Two");
		System.out.println("Array After Removal");
		System.out.println("========================");
		System.out.println(Arrays.toString(arrayAfterRemoval));
	}
}
```
