# com\java\eight8\arraylist\ListOfIntegersMultiplesBy5.java

```java
package com.java.eight8.arraylist;

import java.util.Arrays;
import java.util.List;

public class ListOfIntegersMultiplesBy5 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);
		numbers.stream().filter(num -> num % 5 == 0).forEach(System.out::println);
	}
}
```
