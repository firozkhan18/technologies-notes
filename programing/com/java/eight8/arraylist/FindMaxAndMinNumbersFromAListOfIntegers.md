# com\java\eight8\arraylist\FindMaxAndMinNumbersFromAListOfIntegers.java

```java
package com.java.eight8.arraylist;

import java.util.Arrays;
import java.util.List;

public class FindMaxAndMinNumbersFromAListOfIntegers {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 5, 15, 7, 20);
		int max = numbers.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
		int min = numbers.stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
		System.out.println(min + " and " + max);
	}
}
```
