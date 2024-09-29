# com\java\eight8\array\stream\MostRepeatedElement.java

```java
package com.java.eight8.array.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedElement {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 1, 3, 3, 3 };
		int mostRepeatedElement = Arrays.stream(array).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElseThrow(IllegalStateException::new);
		System.out.println(mostRepeatedElement);
	}
}
```
