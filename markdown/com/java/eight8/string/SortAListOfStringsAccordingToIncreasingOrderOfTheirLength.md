# com\java\eight8\string\SortAListOfStringsAccordingToIncreasingOrderOfTheirLength.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAListOfStringsAccordingToIncreasingOrderOfTheirLength {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one", "four", "three", "six", "five");
		List<String> sortedByLength = strings.stream().sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		System.out.println(sortedByLength);
	}
}
```
