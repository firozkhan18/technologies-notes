# com\java\eight8\array\ArrayElementRemovalProgramThree.java

```java
package com.java.eight8.array;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

//How To Remove Multiple Elements At Different Indices From An Array?
//ArrayUtils.removeAll(T[] inputArray, int … indices) method removes multiple elements at different indices from an array. 
//The below program removes elements at index 1, 3 and 5 from arrayBeforeRemoval.
public class ArrayElementRemovalProgramThree {
	public static void main(String[] args) {
		// Define an array with elements
		String[] arrayBeforeRemoval = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six" };
		System.out.println("Array Before Removal");
		System.out.println("================================================");
		System.out.println(Arrays.toString(arrayBeforeRemoval));
		System.out.println("================================================");
		// Removing elements at index 1, 3, 5
		String[] arrayAfterRemoval = ArrayUtils.removeAll(arrayBeforeRemoval, 1, 3, 5);
		System.out.println("Array After Removal");
		System.out.println("================================================");
		System.out.println(Arrays.toString(arrayAfterRemoval));
	}
}
```
