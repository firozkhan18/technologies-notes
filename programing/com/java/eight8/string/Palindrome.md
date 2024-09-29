# com\java\eight8\string\Palindrome.java

```java
package com.java.eight8.string;

import java.util.stream.IntStream;

public class Palindrome {

	public static void main(String[] args) {
		String str = "racecar";
		boolean isPalindrome = IntStream.range(0, str.length() / 2)
		        .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
		System.out.println(isPalindrome);
	}
}
```
