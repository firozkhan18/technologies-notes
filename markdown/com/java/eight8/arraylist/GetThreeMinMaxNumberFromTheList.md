# com\java\eight8\arraylist\GetThreeMinMaxNumberFromTheList.java

```java
package com.java.eight8.arraylist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetThreeMinMaxNumberFromTheList {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 5, 15, 7, 20);
		List<Integer> top3Max = numbers.stream()
		        .sorted(Comparator.reverseOrder())
		        .limit(3)
		        .collect(Collectors.toList());

		List<Integer> top3Min = numbers.stream()
		        .sorted()
		        .limit(3)
		        .collect(Collectors.toList());
		
		System.out.println(top3Max + " and " + top3Min);
	}
}
```
