# com\java\eight8\string\JoinAListOfStrings.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinAListOfStrings {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one", "two", "three");
		String result = strings.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(result);
	}
}
```
