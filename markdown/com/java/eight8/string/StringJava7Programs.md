# com\java\eight8\string\StringJava7Programs.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.HashMap;

//1. Write a Java program to reverse a string. 
//2. Write a Java program to check if a string is a palindrome. 
//3. Write a Java program to count the number of vowels and consonants in a string. 
//4. Write a Java program to find the duplicate characters in a string. 
//5. Write a Java program to check if two strings are anagrams of each other. 
//6. Write a Java program to remove all whitespace from a string. 
//7. Write a Java program to find the longest substring without repeating characters. 
//8. Write a Java program to check if a string contains only digits. 
//9. Write a Java program to find the first non-repeated character in a string. 
//10. Write a Java program to reverse words in a given string.
//1. 
//
//```java
public class StringJava7Programs {
    public static void main(String[] args) {
        String str = "Hello World";
        StringBuilder reversed = new StringBuilder();
        
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        
        System.out.println("Reversed string: " + reversed.toString());
 
//```
//
//2. 

////```java
//public class Main {
//    public static void main(String[] args) {
        String str1 = "madam";
        
        String reversed1 = new StringBuilder(str1).reverse().toString();
        
        if (str1.equals(reversed1)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
//    }
//}
//```
//
//3. 
//
//```java
//public class Main {
//    public static void main(String[] args) {
        String str2 = "Hello World";
        int vowels = 0;
        int consonants = 0;
        
        for (char c : str2.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else if (c >= 'a' && c <= 'z') {
                consonants++;
            }
        }
        
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
//    }
//}
//```
//
//4. 
//
//```java
//import java.util.HashMap;
//
//public class Main {
//    public static void main(String[] args) {
        String str3 = "hello world";
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        for (char c : str3.toCharArray()) {
            if (charMap.containsKey(c)) {
                System.out.println("Duplicate character: " + c);
            } else {
                charMap.put(c, 1);
            }
        }
//    }
//}
//```
//
//5. 
//
//```java
//import java.util.Arrays;
//
//public class Main {
//    public static void main(String[] args) {
        String str4 = "listen";
        String str5 = "silent";
        
        char[] arr1 = str4.toCharArray();
        char[] arr2 = str5.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
//    }
//}
//```
//
//6. 
//
//```java
//public class Main {
//    public static void main(String[] args) {
        String str6 = "Hello World";
        
        String stringWithoutSpaces = str6.replaceAll("\\s", "");
        
        System.out.println("String without spaces: " + stringWithoutSpaces);
//    }
//}
//```
//
//7. 
//
//```java
//public class Main {
//    public static void main(String[] args) {
        String str7 = "abcabcbb";
        int maxLength = 0;
        
        for (int i = 0; i < str7.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str7.length(); j++) {
                if (sb.toString().contains(String.valueOf(str7.charAt(j)))) {
                    break;
                }
                sb.append(str7.charAt(j));
            }
            maxLength = Math.max(maxLength, sb.length());
        }
        
        System.out.println("Longest substring without repeating characters: " + maxLength);
//    }
//}
//```
//
//8. 
//
//```java
//public class Main {
//    public static void main(String[] args) {
        String str8 = "12345";
        
        if (str8.matches("[0-9]+")) {
            System.out.println("String contains only digits");
        } else {
            System.out.println("String contains characters other than digits");
        }
//    }
//}
//```
//
//9. 
//
//```java
//import java.util.HashMap;
//
//public class Main {
//    public static void main(String[] args) {
        String str9 = "hello world";
        HashMap<Character, Integer> charMap2 = new HashMap<>();
        
        for (char c : str9.toCharArray()) {
            if (charMap2.containsKey(c)) {
                charMap2.put(c, charMap2.get(c) + 1);
            } else {
                charMap2.put(c, 1);
            }
        }
        
        for (char c : str9.toCharArray()) {
            if (charMap2.get(c) == 1) {
                System.out.println("First non-repeated character: " + c);
                break;
            }
        }
//    }
//}
//```
//
//10. 
//
//```java
//public class Main {
//    public static void main(String[] args) {
        String str10 = "Hello World";
        String[] words = str10.split("\\s");
        StringBuilder reversed3 = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed3.append(words[i]).append(" ");
        }

        System.out.println("Reversed words in a string: " + reversed3.toString().trim());
    }
}
//```
```
