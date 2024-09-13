# com\java\eight8\array\ArrayElementRemovalProgramFour.java

```java
package com.java.eight8.array;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
//How To Remove Multiple Specific Elements From An Array?
//ArrayUtils.removeElements(T[] inputArray, T … elements) method is used to remove multiple given elements from an array. 
//The following program demonstrates the same.
public class ArrayElementRemovalProgramFour {
	public static void main(String[] args) {
		// Define an array with elements
		String[] arrayBeforeRemoval = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six" };
		System.out.println("Array Before Removal");
		System.out.println("================================================");
		System.out.println(Arrays.toString(arrayBeforeRemoval));
		System.out.println("================================================");
		// Removing the elements "Two", "Four" and "Six"
		String[] arrayAfterRemoval = ArrayUtils.removeElements(arrayBeforeRemoval, "Two", "Four", "Six");
		System.out.println("Array After Removal");
		System.out.println("================================================");
		System.out.println(Arrays.toString(arrayAfterRemoval));
	}
}
```
