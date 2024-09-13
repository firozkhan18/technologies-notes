# com\java\eight8\numbers\PrintFirstTenEvenNumber.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

public class PrintFirstTenEvenNumber {
	public static void main(String[] args) {
		IntStream.iterate(2, i -> i + 2).limit(10).forEach(System.out::println);
	}
}
```
