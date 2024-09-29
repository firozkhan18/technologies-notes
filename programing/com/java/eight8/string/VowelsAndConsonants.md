# com\java\eight8\string\VowelsAndConsonants.java

```java
package com.java.eight8.string;

//Count the number of vowels and consonants in a string:

/**
	The purpose of this Java program is to count the number of vowels and consonants in a given string.
	
	Steps:
	
	Take the input string from the user.
	Initialize variables to count the number of vowels and consonants.
	Use a loop to iterate through each character in the string.
	Check if the character is a vowel (a, e, i, o, u) or a consonant.
	Increment the respective counter.
	Finally, display the total count of vowels and consonants.
 *
 */
public class VowelsAndConsonants {
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }
        
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
    
    public static void main(String[] args) {
        String str = "Hello World";
        countVowelsAndConsonants(str);
        
        String str1 = "hello";
        long vowelCount = str1.chars()
                             .mapToObj(c -> (char) c)
                             .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                             .count();
        long consonantCount = str1.chars()
                                 .mapToObj(c -> (char) c)
                                 .filter(c -> "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1)
                                 .count();
        
        System.out.println("Number of vowels count: " + vowelCount);
        System.out.println("Number of consonants count: " + consonantCount);
    }
}
```
