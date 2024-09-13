# com\java\eight8\arraylist\SortTheGivenListOfDecimalsInReverseOrder.java

```java
package com.java.eight8.arraylist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTheGivenListOfDecimalsInReverseOrder {
	public static void main(String[] args) {
		List<Double> decimals = Arrays.asList(3.5, 2.0, 1.6, 4.2);
		List<Double> sortedDecimals = decimals.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		System.out.println(decimals + " and " + sortedDecimals);
	}
}
```
