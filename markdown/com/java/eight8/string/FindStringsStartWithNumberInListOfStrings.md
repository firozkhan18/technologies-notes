# com\java\eight8\string\FindStringsStartWithNumberInListOfStrings.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindStringsStartWithNumberInListOfStrings {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("1abc", "def", "2ghi", "jkl");
		List<String> stringsStartingWithNumber = strings.stream()
		        .filter(str -> Character.isDigit(str.charAt(0)))
		        .collect(Collectors.toList());
		System.out.println(stringsStartingWithNumber);
	}
}
```
