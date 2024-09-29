# com\java\eight8\array\PalindromeChecker.java

```java
package com.java.eight8.array;

import java.util.stream.IntStream;

//To check if a string is a palindrome using Java 7:
public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    public static void main(String[] args) {
        String str = "level";
        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
        
        String str1 = "madam";
        boolean isPalindrome = IntStream.range(0, str1.length() / 2)
                                        .allMatch(i -> str1.charAt(i) == str1.charAt(str1.length() - i - 1));
    }
}
```
