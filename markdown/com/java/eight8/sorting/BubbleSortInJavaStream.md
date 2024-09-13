# com\java\eight8\sorting\BubbleSortInJavaStream.java

```java
package com.java.eight8.sorting;

import java.util.Arrays;

public class BubbleSortInJavaStream {
	public static void main(String[] args) {
		int inputArray[] = new int[] { 7, 4, 9, 2, 5 };

		System.out.println("Input Array : " + Arrays.toString(inputArray));

//		This line of code takes an input array inputArray, converts it to a stream using Arrays.stream(inputArray), 
//		boxes each element of the stream using boxed(), sorts the elements using sorted(), 
//		maps each element to an integer using mapToInt(Integer::intValue), 
//		and finally converts the stream to an array of integers using toArray(). 
//		The result is stored in the sortedArray variable. 
//		This entire line of code essentially takes an input array, sorts it in ascending order, 
//		and stores the sorted elements in a new integer array.
		int sortedArray[] = Arrays.stream(inputArray).boxed().sorted().mapToInt(Integer::intValue).toArray();

		System.out.println("Sorted Array : " + Arrays.toString(sortedArray));
	}
}
```
