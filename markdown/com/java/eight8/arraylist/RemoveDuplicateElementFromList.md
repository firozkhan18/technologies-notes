# com\java\eight8\arraylist\RemoveDuplicateElementFromList.java

```java
package com.java.eight8.arraylist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateElementFromList {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
		List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println("distinctNumbers "+distinctNumbers);
	}
}
```
