# com\java\eight8\newfeatures\stream\CountNumberOfElementsInIntStream.java

```java
package com.java.eight8.newfeatures.stream;

import java.util.stream.IntStream;

public class CountNumberOfElementsInIntStream {

	public static void main(String[] args) {

		// Count number of elements in IntStream
		long count = IntStream.of(1, 2, 3, 4, 5).count();
		System.out.println("Count: " + count);
	}

}
```
