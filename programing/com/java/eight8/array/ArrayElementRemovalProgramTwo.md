# com\java\eight8\array\ArrayElementRemovalProgramTwo.java

```java
package com.java.eight8.array;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

//How To Remove Specific Element From An Array?
//ArrayUtils.removeElement(T[] inputArray, T element) method removes a specific element from an array. 
//The following program removes an element “Two” from arrayBeforeRemoval.
public class ArrayElementRemovalProgramTwo {
	public static void main(String[] args) {
		// Define an array with elements
		String[] arrayBeforeRemoval = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six" };
		System.out.println("Array Before Removal");
		System.out.println("================================================");
		System.out.println(Arrays.toString(arrayBeforeRemoval));
		System.out.println("================================================");
		// Removing an element "Two" from arrayBeforeRemoval
		String[] arrayAfterRemoval = ArrayUtils.removeElement(arrayBeforeRemoval, "Two");
		System.out.println("Array After Removal");
		System.out.println("================================================");
		System.out.println(Arrays.toString(arrayAfterRemoval));
	}
}
```
