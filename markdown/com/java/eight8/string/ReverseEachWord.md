# com\java\eight8\string\ReverseEachWord.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.stream.Collectors;

//Write a java program to reverse each word of a given string? For example, If “Java Concept Of The Day” is input string then output should be “avaJ tpecnoC fO ehT yaD”.
//How To Reverse Each Word Of A String In Java?
//Split the given inputString into words using split() method. Then take each individual word, reverse it and append to reverseString. Finally print reverseString. Below image shows code snippet of the same.
public class ReverseEachWord {
	static void reverseEachWordOfString(String inputString)
    {
        String[] words = inputString.split(" ");
         
        String reverseString = "";
         
        for (int i = 0; i < words.length; i++) 
        {
            String word = words[i];
             
            String reverseWord = "";
             
            for (int j = word.length()-1; j >= 0; j--) 
            {
                reverseWord = reverseWord + word.charAt(j);
            }
             
            reverseString = reverseString + reverseWord + " ";
        }
         
        System.out.println(inputString);
         
        System.out.println(reverseString);
         
        System.out.println("-------------------------");
    }
     
    public static void main(String[] args) 
    {
        reverseEachWordOfString("Java Concept Of The Day");
         
        reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts");
         
        reverseEachWordOfString("I am string not reversed");
         
        reverseEachWordOfString("Reverse Me");
        
        String str = "Hello World";
        String reversedWords = Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(reversedWords);
    }
}
```
