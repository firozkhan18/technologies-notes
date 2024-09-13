# com\java\eight8\string\StringJava8ProgramsInStream.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class StringJava8ProgramsInStream {
	 public static void main(String[] args)
	    {
//		Reverse a string:
		 
		String input = "hello";
		String reversed = new StringBuilder(input).reverse().toString();
		System.out.println(reversed);
		//Check if a string is a palindrome:
		 
		String input1 = "madam";
		boolean isPalindrome = new StringBuilder(input).reverse().toString().equalsIgnoreCase(input1);
		System.out.println(isPalindrome);
		//Count the number of vowels and consonants in a string:
		 
		String input2 = "hello";
		long vowels = input2.chars().filter(c -> "aeiou".indexOf(c) != -1).count();
		long consonants = input.chars().filter(c -> "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1).count();
		System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
		//Find duplicate characters in a string:
		 
		String input3 = "hello";
		String duplicates = input3.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		        .entrySet().stream().filter(e -> e.getValue() > 1).map(e -> String.valueOf(e.getKey())).collect(Collectors.joining());
		System.out.println(duplicates);
		//Check if two strings are anagrams of each other:
		 
		String str1 = "listen";
		String str2 = "silent";
		boolean isAnagram = Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());
		System.out.println(isAnagram);
		//Remove all whitespace from a string:
		 
		String input4 = "hello world";
		String result = input4.chars().filter(c -> !Character.isWhitespace(c)).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
		System.out.println(result);
		//Find the longest substring without repeating characters:
		 
		String input5 = "abcabcbb";
		String longest = IntStream.range(0, input5.length()).mapToObj(i -> IntStream.range(i, input5.length())
		        .mapToObj(j -> input5.substring(i, j + 1)).filter(s -> s.chars().distinct().count() == s.length())
		        .max(Comparator.comparing(String::length)).orElse("")).max(Comparator.comparing(String::length)).orElse("");
		System.out.println(longest);
		//Check if a string contains only digits:
		 
		String input6 = "12345";
		boolean containsDigits = input6.chars().allMatch(Character::isDigit);
		System.out.println(containsDigits);
		//Find the first non-repeated character in a string:
		 
		String input7 = "hello";
		Optional<Character> firstNonRepeated = input7.chars().mapToObj(c -> (char) c).filter(c -> input7.indexOf(c) == input7.lastIndexOf(c)).findFirst();
		System.out.println(firstNonRepeated.orElse(' '));
		//Reverse words in a given string:
		 
		String input8 = "hello world";
		String reversedWords = Arrays.stream(input8.split(" ")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" "));
		System.out.println(reversedWords);
}
}
```
