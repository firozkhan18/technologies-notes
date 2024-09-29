# com\java\eight8\arraylist\FindFrequencyOfEachElementInAnArrayOrList.java

```java
package com.java.eight8.arraylist;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfEachElementInAnArrayOrList {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
		Map<Integer, Long> frequencyMap = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequencyMap);
		
		String str = "hello world";
		Map<Character, Long> charFrequency = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charFrequency);
	}
}
```
