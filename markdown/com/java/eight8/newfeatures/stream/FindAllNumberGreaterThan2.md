# com\java\eight8\newfeatures\stream\FindAllNumberGreaterThan2.java

```java
package com.java.eight8.newfeatures.stream;

import java.util.stream.IntStream;

public class FindAllNumberGreaterThan2 {

	public static void main(String[] args) {

		// Find all numbers greater than 2
		IntStream.of(1, 2, 3, 4, 5).filter(n-> n > 2).forEach(System.out::println);
	}

}
```
