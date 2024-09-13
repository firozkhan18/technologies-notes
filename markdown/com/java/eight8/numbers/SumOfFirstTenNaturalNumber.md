# com\java\eight8\numbers\SumOfFirstTenNaturalNumber.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

public class SumOfFirstTenNaturalNumber {
	public static void main(String[] args) {
		int sumOfFirst10NaturalNumbers = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sumOfFirst10NaturalNumbers);
	}
}
```
