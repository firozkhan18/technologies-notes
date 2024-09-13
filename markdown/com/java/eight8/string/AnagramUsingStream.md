# com\java\eight8\string\AnagramUsingStream.java

```java
package com.java.eight8.string;

import java.util.Arrays;

public class AnagramUsingStream {
	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";

		boolean areAnagrams = Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());
		System.out.println(areAnagrams);
	}
}
```
