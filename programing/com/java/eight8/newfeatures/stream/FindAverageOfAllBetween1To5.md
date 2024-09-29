# com\java\eight8\newfeatures\stream\FindAverageOfAllBetween1To5.java

```java
package com.java.eight8.newfeatures.stream;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class FindAverageOfAllBetween1To5 {

	public static void main(String[] args) {

		// Find average of all between 1 to 5
		OptionalDouble average = IntStream.of(1, 2, 3).average();
		System.out.println("Average: " + average.getAsDouble());
	}

}
```
