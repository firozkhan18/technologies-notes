# com\java\eight8\array\ArrayElementRemovalProgramFive.java

```java
package com.java.eight8.array;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
//How To Remove All Occurrences Of An Element From An Array?
//ArrayUtils.removeAllOccurences(T[] inputArray, T element) method removes all occurrences of a given element from an array.
public class ArrayElementRemovalProgramFive {
	public static void main(String[] args) {
		// Define an array with elements
		String[] arrayBeforeRemoval = new String[] { "Zero", "One", "Two", "Three", "Two", "Five", "Six" };
		System.out.println("Array Before Removal");
		System.out.println("========================");
		System.out.println(Arrays.toString(arrayBeforeRemoval));
		System.out.println("========================");
		// Removing all occurrences of an element "Two"
		String[] arrayAfterRemoval = ArrayUtils.removeAllOccurences(arrayBeforeRemoval, "Two");
		System.out.println("Array After Removal");
		System.out.println("========================");
		System.out.println(Arrays.toString(arrayAfterRemoval));
	}
}
```
