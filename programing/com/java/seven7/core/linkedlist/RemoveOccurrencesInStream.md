# com\java\seven7\core\linkedlist\RemoveOccurrencesInStream.java

```java
package com.java.seven7.core.linkedlist;

import java.util.Arrays;
import java.util.stream.IntStream;

//To remove the first occurrence and last occurrence of a given element using streams in Java, 
//you can filter the array using a Predicate that skips the first and last occurrence indices
public class RemoveOccurrencesInStream {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 2, 5, 6, 2, 7 };
		int elementToRemove = 2;

		int firstIndex = IntStream.range(0, arr.length).filter(i -> arr[i] == elementToRemove).findFirst().orElse(-1);

		int lastIndex = IntStream.range(0, arr.length).filter(i -> arr[i] == elementToRemove).reduce((a, b) -> b)
				.orElse(-1);

		int[] newArr = IntStream.range(0, arr.length).filter(i -> i < firstIndex || i > lastIndex).map(i -> arr[i])
				.toArray();

		System.out.println("Original Array: " + Arrays.toString(arr));
		System.out.println("Element to remove: " + elementToRemove);
		System.out.println("New Array: " + Arrays.toString(newArr));
	}
}
```
