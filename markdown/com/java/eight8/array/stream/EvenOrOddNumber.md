# com\java\eight8\array\stream\EvenOrOddNumber.java

```java
package com.java.eight8.array.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOrOddNumber {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean, List<Integer>> oddAndEvenMap = numbers.stream()
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));

		List<Integer> oddNumbers = oddAndEvenMap.get(false);
		List<Integer> evenNumbers = oddAndEvenMap.get(true);
		
		System.out.println("oddNumbers "+oddNumbers+" evenNumbers "+evenNumbers); 
	}
}
```
