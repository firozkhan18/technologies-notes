# com\java\eight8\array\stream\SmallestSecondSmallestElementInArray.java

```java
package com.java.eight8.array.stream;

import java.util.Arrays;

public class SmallestSecondSmallestElementInArray {
	private static void getSmallestSecondSmallestJava8(int[] inputArray) {
		System.out.println("Input Array : " + Arrays.toString(inputArray));
		System.out.println("Smallest And Second Smallest Elements Are :");
		// Java 8 Code
		Arrays.stream(inputArray).sorted().limit(2).forEach(System.out::println);
	}

	public static void main(String[] args) {
		getSmallestSecondSmallestJava8(new int[] { 17, 11, 23, 64, 41, 88, 35 });
		System.out.println("=====================================");
		getSmallestSecondSmallestJava8(new int[] { -9, 3, 36, -25, -9, 71, 0 });
		System.out.println("=====================================");
		getSmallestSecondSmallestJava8(new int[] { 21, 21, -18, -4, -11, 85, 7 });
	}
}
```
