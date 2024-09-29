# com\java\eight8\array\SecondLargest2nd.java

```java
package com.java.eight8.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SecondLargest2nd {
	public static void main(String[] args) {
		int[] array = { 4, 8, 1, 9, 5, 3, 7 };

		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int num : array) {
			if (num > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = num;
			} else if (num > secondLargest && num < firstLargest) {
				secondLargest = num;
			}
		} 
		
		System.out.println("Second largest element in the array: " + secondLargest);
		
		int secondLargest1 = Arrays.stream(array)
                .boxed()
                .sorted((a, b) -> b.compareTo(a))
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow(null);

		System.out.println("Second largest1 element in the array: " + secondLargest1);
		
		int[] arr = {8, 12, 6, 20, 15};
		int secondLargest3 = IntStream.of(arr).boxed()
		                        .sorted(Comparator.reverseOrder())
		                        .distinct()
		                        .skip(1)
		                        .findFirst()
		                        .orElse(null);
		System.out.println("Second largest element: " + secondLargest3);
		
		int[] array2 = {5, 10, 7, 8, 2};
		int secondLargest2 = Arrays.stream(array2)
		        .boxed()
		        .sorted(Comparator.reverseOrder())
		        .distinct()
		        .skip(1)
		        .findFirst()
		        .orElseThrow(IllegalStateException::new);
		
		System.out.println("Second largest element: " + secondLargest2);
	}
}
```
