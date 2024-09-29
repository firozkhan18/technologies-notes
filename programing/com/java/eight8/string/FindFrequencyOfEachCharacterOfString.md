# com\java\eight8\string\FindFrequencyOfEachCharacterOfString.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfEachCharacterOfString {
	public static void main(String[] args) {
		String str = "hello world";
		Map<Character, Long> charFrequency = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charFrequency);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
		Map<Integer, Long> frequencyMap = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequencyMap);
	}
}
```
