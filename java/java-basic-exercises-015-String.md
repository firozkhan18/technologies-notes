# Java Exercises String

### 1. Write a Java program to get the character at the given index within the string.

Sample Output:

Original String = Java Exercises!                                                                             
The character at position 0 is J                                                                              
The character at position 10 is i 
```java
// Define a public class named Exercise1.
public class Exercise1 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable "str" with the value "Java Exercises!".
        String str = "Java Exercises!";
        // Print the original string.
        System.out.println("Original String = " + str);

        // Get the character at positions 0 and 10.
        int index1 = str.charAt(0); // Get the ASCII value of the character at position 0.
        int index2 = str.charAt(10); // Get the ASCII value of the character at position 10.

        // Print out the results.
        System.out.println("The character at position 0 is " +
                (char)index1); // Print the character at position 0 by converting ASCII value to char.
        System.out.println("The character at position 10 is " +
                (char)index2); // Print the character at position 10 by converting ASCII value to char.
    }
}
```
Sample Output:

Original String = Java Exercises!                                                                             
The character at position 0 is J                                                                              
The character at position 10 is i 
### 2. Write a Java program to get the character (Unicode code point) at the given index within the string.

Sample Output:

Original String : w3resource.com                                                                              
Character(unicode point) = 51                                                                                 
Character(unicode point) = 101 
```java
// Define a public class named Exercise2.
public class Exercise2 {
    // Define the main method.
    public static void main(String[] args) {
  
        // Declare and initialize a string variable "str" with the value "w3resource.com".
        String str = "w3resource.com";
        // Print the original string.
        System.out.println("Original String : " + str);
        
        // Retrieve the Unicode code point at index 1 in the string.
        int val1 = str.codePointAt(1);
    
        // Retrieve the Unicode code point at index 9 in the string.
        int val2 = str.codePointAt(9);
        
        // Print the Unicode code point representing the character at index 1 in the string.
        System.out.println("Character(unicode point) = " + val1);
        // Print the Unicode code point representing the character at index 9 in the string.
        System.out.println("Character(unicode point) = " + val2);
    }
}
```
Sample Output:

Original String : w3resource.com                                                                              
Character(unicode point) = 51                                                                                 
Character(unicode point) = 101 
### 3. Write a Java program to get the character (Unicode code point) before the specified index within the string.

Sample Output:

Original String : w3resource.com                                                                              
Character(unicode point) = 119                                                                                
Character(unicode point) = 99
```java
// Define a public class named Exercise3.
public class Exercise3 {
    // Define the main method.
    public static void main(String[] args) {
  
        // Declare and initialize a string variable "str" with the value "w3resource.com".
        String str = "w3resource.com";
        // Print the original string.
        System.out.println("Original String : " + str);
        
        // Retrieve the Unicode code point before the character at index 1 in the string.
        int val1 = str.codePointBefore(1);
    
        // Retrieve the Unicode code point before the character at index 9 in the string.
        int val2 = str.codePointBefore(9);
        
        // Print the Unicode code point representing the character before index 1 in the string.
        System.out.println("Character(unicode point) = " + val1);
        // Print the Unicode code point representing the character before index 9 in the string.
        System.out.println("Character(unicode point) = " + val2);
    }
}
```
Sample Output:

Original String : w3resource.com                                                                              
Character(unicode point) = 119                                                                                
Character(unicode point) = 99
### 4. Write a Java program to count Unicode code points in the specified text range of a string.

Sample Output:

Original String : w3rsource.com                                                                               
Codepoint count = 9
```java
// Define a public class named Exercise4.
public class Exercise4 {
    // Define the main method.
    public static void main(String[] args) {
  
        // Declare and initialize a string variable "str" with the value "w3rsource.com".
        String str = "w3rsource.com";
        // Print the original string.
        System.out.println("Original String : " + str);
        
        // Count the number of Unicode code points from index 1 to index 10 in the string.
        int ctr = str.codePointCount(1, 10);
        
        // Print the count of Unicode code points from index 1 to index 10 in the string.
        System.out.println("Codepoint count = " + ctr);
    }
}
```
Sample Output:

Original String : w3rsource.com                                                                               
Codepoint count = 9
### 5. Write a Java program to compare two strings lexicographically.
Two strings are lexicographically equal if they are the same length and contain the same characters in the same positions.

Sample Output:

String 1: This is Exercise 1                                                                                  
String 2: This is Exercise 2                                                                                  
"This is Exercise 1" is less than "This is Exercise 2" 
```java
// Define a public class named Exercise5.
public class Exercise5 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables.
        String str1 = "This is Exercise 1";
        String str2 = "This is Exercise 2";
        
        // Print the first string.
        System.out.println("String 1: " + str1);
        // Print the second string.
        System.out.println("String 2: " + str2); 
       
        // Compare the two strings and get the comparison result.
        int result = str1.compareTo(str2);

        // Display the results of the comparison.
        if (result < 0) {
            // If the result is less than 0, print that the first string is less than the second.
            System.out.println("\"" + str1 + "\"" +
                " is less than " +
                "\"" + str2 + "\"");
        } else if (result == 0) {
            // If the result is 0, print that the first string is equal to the second.
            System.out.println("\"" + str1 + "\"" +
                " is equal to " +
                "\"" + str2 + "\"");
        } else { // if (result > 0)
            // If the result is greater than 0, print that the first string is greater than the second.
            System.out.println("\"" + str1 + "\"" +
                " is greater than " +
                "\"" + str2 + "\"");
        }
    }
}
```
Sample Output:

String 1: This is Exercise 1                                                                                  
String 2: This is Exercise 2                                                                                  
"This is Exercise 1" is less than "This is Exercise 2"
### 6. Write a Java program to compare two strings lexicographically, ignoring case differences.

Sample Output:

String 1: This is exercise 1                                                                                  
String 2: This is Exercise 1                                                                                  
"This is exercise 1" is equal to "This is Exercise 1"
```java
// Define a public class named Exercise6.
public class Exercise6 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables, str1 and str2.
        String str1 = "This is exercise 1";
        String str2 = "This is Exercise 1";
        
        // Print the first string.
        System.out.println("String 1: " + str1);
        // Print the second string.
        System.out.println("String 2: " + str2); 
       
        // Compare the two strings ignoring case sensitivity and get the result of the comparison.
        int result = str1.compareToIgnoreCase(str2);

        // Display the results of the comparison.
        if (result < 0) {
            // If str1 (ignoring case) is less than str2 (ignoring case).
            System.out.println("\"" + str1 + "\"" +
                " is less than " +
                "\"" + str2 + "\"");
        } else if (result == 0) {
            // If str1 (ignoring case) is equal to str2 (ignoring case).
            System.out.println("\"" + str1 + "\"" +
                " is equal to " +
                "\"" + str2 + "\"");
        } else { // if (result > 0)
            // If str1 (ignoring case) is greater than str2 (ignoring case).
            System.out.println("\"" + str1 + "\"" +
                " is greater than " +
                "\"" + str2 + "\"");
        }
    }
}
```
Sample Output:

String 1: This is exercise 1                                                                                  
String 2: This is Exercise 1                                                                                  
"This is exercise 1" is equal to "This is Exercise 1"
### 7. Write a Java program to concatenate a given string to the end of another string.

Sample Output:

String 1: PHP Exercises and                                                                                   
String 2: Python Exercises                                                                                    
The concatenated string: PHP Exercises and Python Exercises

```java
// Define a public class named Exercise7.
public class Exercise7 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables, str1 and str2.
        String str1 = "PHP Exercises and ";
        String str2 = "Python Exercises";
        
        // Print the first string.
        System.out.println("String 1: " + str1);
        // Print the second string.
        System.out.println("String 2: " + str2); 
       
        // Concatenate the two strings together and store the result in str3.
        String str3 = str1.concat(str2);

        // Display the newly concatenated string.
        System.out.println("The concatenated string: " + str3);
    }
}
```
Sample Output:

String 1: PHP Exercises and                                                                                   
String 2: Python Exercises                                                                                    
The concatenated string: PHP Exercises and Python Exercises
### 8. Write a Java program to test if a given string contains the specified sequence of char values.

Sample Output:

Original String: PHP Exercises and Python Exercises                                                           
Specified sequence of char values: and                                                                        
true 
```java
// Define a public class named Exercise8.
public class Exercise8 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables, str1 and str2.
        String str1 = "PHP Exercises and Python Exercises";
        String str2 = "and";
        
        // Print the original string.
        System.out.println("Original String: " + str1);
        // Print the specified sequence of char values.
        System.out.println("Specified sequence of char values: " + str2);
        
        // Check if str1 contains the sequence specified in str2 and print the result.
        System.out.println(str1.contains(str2));
    }
}
```
Sample Output:

Original String: PHP Exercises and Python Exercises                                                           
Specified sequence of char values: and                                                                        
true 
### 9. Write a Java program to compare a given string to the specified character sequence.

Sample Output:

Comparing example.com and example.com: true                                                                   
Comparing Example.com and example.com: false
```java
// Define a public class named Exercise9.
public class Exercise9 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables, str1 and str2.
        String str1 = "example.com", str2 = "Example.com";
        
        // Create a CharSequence object named cs with value "example.com".
        CharSequence cs = "example.com";
        
        // Compare str1 and cs for content equality and print the result.
        System.out.println("Comparing " + str1 + " and " + cs + ": " + str1.contentEquals(cs));
        
        // Compare str2 and cs for content equality and print the result.
        System.out.println("Comparing " + str2 + " and " + cs + ": " + str2.contentEquals(cs));
    }
}
```  
Sample Output:

Comparing example.com and example.com: true                                                                   
Comparing Example.com and example.com: false
### 10. Write a Java program to compare a given string to a specified string buffer.

Sample Output:

Comparing example.com and example.com: true                                                                   
Comparing Example.com and example.com: false 
```java
// Define a public class named Exercise10.
public class Exercise10 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables, str1 and str2.
        String str1 = "example.com", str2 = "Example.com";
        
        // Create a StringBuffer object strbuf initialized with the value of str1.
        StringBuffer strbuf = new StringBuffer(str1);
    
        // Compare str1 and strbuf for content equality and print the result.
        System.out.println("Comparing " + str1 + " and " + strbuf + ": " + str1.contentEquals(strbuf));
    
        // Compare str2 and strbuf for content equality and print the result.
        System.out.println("Comparing " + str2 + " and " + strbuf + ": " + str2.contentEquals(strbuf));
    }
}
```
Sample Output:

Comparing example.com and example.com: true                                                                   
Comparing Example.com and example.com: false 
### 11. Write a Java program to create a String object with a character array.

Sample Output:

The book contains 234 pages.
```java
// Define a public class named Exercise11.
public class Exercise11 {
    // Define the main method.
    public static void main(String[] args) {
        // Character array with data.
        char[] arr_num = new char[] { '1', '2', '3', '4' };

        // Create a String containing the contents of arr_num
        // starting at index 1 for length 3.
        String str = String.copyValueOf(arr_num, 1, 3);

        // Display the results of the new String.
        System.out.println("\nThe book contains " + str + " pages.\n");
    }
}
```
Sample Output:

The book contains 234 pages.
### 12. Write a Java program to check whether a given string ends with another string.

Sample Output:

"Python Exercises" ends with "se"? false                                                                      
"Python Exercise" ends with "se"? true
```java
// Define a public class named Exercise12.
public class Exercise12 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables, str1 and str2.
        String str1 = "Python Exercises";
        String str2 = "Python Exercise";

        // The String to check the above two Strings to see
        // if they end with this value (se).
        String end_str = "se";

        // Check if the first string ends with end_str.
        boolean ends1 = str1.endsWith(end_str);
        
        // Check if the second string ends with end_str.
        boolean ends2 = str2.endsWith(end_str);

        // Display the results of the endsWith calls.
        System.out.println("\"" + str1 + "\" ends with " +
            "\"" + end_str + "\"? " + ends1);
        System.out.println("\"" + str2 + "\" ends with " +
            "\"" + end_str + "\"? " + ends2);
    }
}
```
Sample Output:

"Python Exercises" ends with "se"? false                                                                      
"Python Exercise" ends with "se"? true
### 13. Write a Java program to check whether two String objects contain the same data.

Sample Output:

"Stephen Edwin King" equals "Walter Winchell"? false                                                          
"Stephen Edwin King" equals "Mike Royko"? false
```java
// Define a public class named Exercise13.
public class Exercise13 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize three string variables.
        String columnist1 = "Stephen Edwin King";
        String columnist2 = "Walter Winchell";
        String columnist3 = "Mike Royko";

        // Check if columnist1 is equal to columnist2.
        boolean equals1 = columnist1.equals(columnist2);
        
        // Check if columnist1 is equal to columnist3.
        boolean equals2 = columnist1.equals(columnist3);

        // Display the results of the equality checks.
        System.out.println("\"" + columnist1 + "\" equals \"" +
            columnist2 + "\"? " + equals1);
        System.out.println("\"" + columnist1 + "\" equals \"" +
            columnist3 + "\"? " + equals2);
    }
}
```
Sample Output:

"Stephen Edwin King" equals "Walter Winchell"? false                                                          
"Stephen Edwin King" equals "Mike Royko"? false
### 14. Write a Java program to compare a given string to another string, ignoring case considerations.

Sample Output:

"Stephen Edwin King" equals "Walter Winchell"? false                                                          
"Stephen Edwin King" equals "stephen edwin king"? true 
```java
// Define a public class named Exercise14.
public class Exercise14 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize three string variables.
        String columnist1 = "Stephen Edwin King";
        String columnist2 = "Walter Winchell";
        String columnist3 = "stephen edwin king";

        // Test if columnist1 is equal to columnist2 ignoring case.
        boolean equals1 = columnist1.equalsIgnoreCase(columnist2);
        
        // Test if columnist1 is equal to columnist3 ignoring case.
        boolean equals2 = columnist1.equalsIgnoreCase(columnist3);

        // Display the results of the equality checks.
        System.out.println("\"" + columnist1 + "\" equals \"" +
            columnist2 + "\"? " + equals1);
        System.out.println("\"" + columnist1 + "\" equals \"" +
            columnist3 + "\"? " + equals2);
    }
}
```
Sample Output:

"Stephen Edwin King" equals "Walter Winchell"? false                                                          
"Stephen Edwin King" equals "stephen edwin king"? true 
### 15. Write a Java program to print the current date and time in the specified format.

Sample Output:

Current Date and Time :                                                                                       
June 19, 2017                                                                                                 
3:13 pm 
N.B. : The current date and time will change according to your system date and time.
```java
// Import the Calendar class from the java.util package.
import java.util.Calendar;

// Define a public class named Exercise15.
public class Exercise15 {
    // Define the main method.
    public static void main(String[] args) {
        // Get an instance of the Calendar class representing the current date and time.
        Calendar c = Calendar.getInstance();
        
        // Print the message indicating current date and time.
        System.out.println("Current Date and Time :");

        // Print the formatted date (month day, year) using the specified format.
        System.out.format("%tB %te, %tY%n", c, c, c);
        
        // Print the formatted time (hour:minute am/pm) using the specified format.
        System.out.format("%tl:%tM %tp%n", c, c, c); 
    }
}
```
Sample Output:

Current Date and Time :                                                                                       
June 19, 2017                                                                                                 
3:13 pm 

### 16. Write a Java program to get the contents of a given string as a byte array.

Sample Output:

The new String equals This is a sample String.
```java
// Import the Calendar class from the java.util package.
import java.util.Calendar;

// Define a public class named Exercise16.
public class Exercise16 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "This is a sample String.";

        // Copy the contents of the string to a byte array.
        byte[] byte_arr = str.getBytes();

        // Create a new string using the contents of the byte array.
        String new_str = new String(byte_arr);

        // Display the contents of the byte array.
        System.out.println("\nThe new String equals " +
            new_str + "\n");
    }
}
```
Sample Output:

The new String equals This is a sample String.
### 17. Write a Java program to get the contents of a given string as a character array.

Sample Output:

The char array equals "[C@2a139a55"
```java
// Define a public class named Exercise17.
public class Exercise17 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "This is a sample string.";

        // Create a character array to hold copied characters.
        // Copy characters 4 through 10 from the 'str' string to the 'arr' array.
        // Start filling the 'arr' array from position 2.
        char[] arr = new char[] { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        str.getChars(4, 10, arr, 2);

        // Display the contents of the character array.
        System.out.println("The char array equals \"" +
            arr + "\"");
    }
}
```
Sample Output:

The char array equals "[C@2a139a55"
### 18. Write a Java program to create a distinct identifier for a given string.

Sample Output:
```java
The hash for Python Exercises. is 863132599 
// Define a public class named Exercise18.
public class Exercise18 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "Python Exercises.";

        // Get the hash code for the string.
        int hash_code = str.hashCode();

        // Display the hash code.
        System.out.println("The hash for " + str +
            " is " + hash_code);
    }
}
```
Sample Output:

The hash for Python Exercises. is 863132599 

### 19. Write a Java program to get the index of all the characters of the alphabet.

Sample Output:

a  b c  d e  f  g h i  j                                                                                     
=========================                                                                                     
36 10 7 40 2 16 42 1 6 20                                                                                     
                                                                                                   
k  l  m  n  o  p q  r  s  t                                                                                   
===========================                                                                                   
8 35 22 14 12 23 4 11 24 31                                                                                   

u  v  w  x  y  z                                                                                              
================                                                                                              
5 27 13 18 38 37

Sample string of all alphabet: "The quick brown fox jumps over the lazy dog."
```java
// Define a public class named Exercise19.
public class Exercise19 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "The quick brown fox jumps over the lazy dog.";

        // Get the index of all the characters of the alphabet
        // starting from the beginning of the String.
        int a = str.indexOf("a", 0);
        int b = str.indexOf("b", 0);
        int c = str.indexOf("c", 0);
        int d = str.indexOf("d", 0);
        int e = str.indexOf("e", 0);
        int f = str.indexOf("f", 0);
        int g = str.indexOf("g", 0);
        int h = str.indexOf("h", 0);
        int i = str.indexOf("i", 0);
        int j = str.indexOf("j", 0);
        int k = str.indexOf("k", 0);
        int l = str.indexOf("l", 0);
        int m = str.indexOf("m", 0);
        int n = str.indexOf("n", 0);
        int o = str.indexOf("o", 0);
        int p = str.indexOf("p", 0);
        int q = str.indexOf("q", 0);
        int r = str.indexOf("r", 0);
        int s = str.indexOf("s", 0);
        int t = str.indexOf("t", 0);
        int u = str.indexOf("u", 0);
        int v = str.indexOf("v", 0);
        int w = str.indexOf("w", 0);
        int x = str.indexOf("x", 0);
        int y = str.indexOf("y", 0);
        int z = str.indexOf("z", 0);

        // Display the results of all the indexOf method calls.
        System.out.println(" a  b c  d e  f  g h i  j");
        System.out.println("=========================");
        System.out.println(a + " " + b + " " + c + " " + d + " " +
                           e + " " + f + " " + g + " " + h + " " +
                           i + " " + j + "\n");

        System.out.println("k  l  m  n  o  p q  r  s  t");
        System.out.println("===========================");
        System.out.println(k + " " + l + " " + m + " " + n + " " +
                           o + " " + p + " " + q + " " + r + " " +
                           s + " " + t + "\n");

        System.out.println("u  v  w  x  y  z");
        System.out.println("================");
        System.out.println(u + " " + v + " " + w + " " + x + " " +
                           y + " " + z);
    }
}
```
Sample Output:

a  b c  d e  f  g h i  j                                                                                     
=========================                                                                                     
36 10 7 40 2 16 42 1 6 20                                                                                     
                                                                                                   
k  l  m  n  o  p q  r  s  t                                                                                   
===========================                                                                                   
8 35 22 14 12 23 4 11 24 31                                                                                   

u  v  w  x  y  z                                                                                              
================                                                                                              
5 27 13 18 38 37

### 20. Write a Java program to get the Canonical representation of the string object.

Sample Output:

str1 == str2? false                                                                                           
str1 == str3? true
```java
// Define a public class named Exercise20.
public class Exercise20 {
    // Define the main method.
    public static void main(String[] args) {
        // Create three strings in three different ways.
        String str1 = "Java Exercises"; // Creating a string using string literal
        String str2 = new StringBuffer("Java").append(" Exercises").toString(); // Creating a string using StringBuffer and converting it to string
        String str3 = str2.intern(); // Creating a string by interning str2

        // Determine which strings are equivalent using the ==
        // operator (as compared to calling equals(), which is
        // a more expensive operation.
        System.out.println("str1 == str2? " + (str1 == str2)); // Checking if str1 and str2 reference the same object
        System.out.println("str1 == str3? " + (str1 == str3)); // Checking if str1 and str3 reference the same object
    }
}
```
Sample Output:

str1 == str2? false                                                                                           
str1 == str3? true
### 21. Write a Java program to get the last index of a string within a string.

Sample Output:

 a  b c  d  e  f  g  h i  j                                                                                   
===========================                                                                                   
36 10 7 40 33 16 42 32 6 20                                                                                   
                                                                                                              
k  l  m  n  o  p q  r  s  t                                                                                   
===========================                                                                                   
8 35 22 14 41 23 4 29 24 31                                                                                   
                                                                                                              
 u  v  w  x  y  z                                                                                             
=================                                                                                             
21 27 13 18 38 37
Sample string of all alphabet: "The quick brown fox jumps over the lazy dog."
```java
// Define a public class named Exercise21.
public class Exercise21 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "The quick brown fox jumps over the lazy dog.";

        // Get the index of all the characters of the alphabet
        // starting from the end of the String towards the beginning.
        int a = str.lastIndexOf("a", str.length() - 1);
        int b = str.lastIndexOf("b", str.length() - 1);
        int c = str.lastIndexOf("c", str.length() - 1);
        int d = str.lastIndexOf("d", str.length() - 1);
        int e = str.lastIndexOf("e", str.length() - 1);
        int f = str.lastIndexOf("f", str.length() - 1);
        int g = str.lastIndexOf("g", str.length() - 1);
        int h = str.lastIndexOf("h", str.length() - 1);
        int i = str.lastIndexOf("i", str.length() - 1);
        int j = str.lastIndexOf("j", str.length() - 1);
        int k = str.lastIndexOf("k", str.length() - 1);
        int l = str.lastIndexOf("l", str.length() - 1);
        int m = str.lastIndexOf("m", str.length() - 1);
        int n = str.lastIndexOf("n", str.length() - 1);
        int o = str.lastIndexOf("o", str.length() - 1);
        int p = str.lastIndexOf("p", str.length() - 1);
        int q = str.lastIndexOf("q", str.length() - 1);
        int r = str.lastIndexOf("r", str.length() - 1);
        int s = str.lastIndexOf("s", str.length() - 1);
        int t = str.lastIndexOf("t", str.length() - 1);
        int u = str.lastIndexOf("u", str.length() - 1);
        int v = str.lastIndexOf("v", str.length() - 1);
        int w = str.lastIndexOf("w", str.length() - 1);
        int x = str.lastIndexOf("x", str.length() - 1);
        int y = str.lastIndexOf("y", str.length() - 1);
        int z = str.lastIndexOf("z", str.length() - 1);

        // Display the results of all the lastIndexOf method calls.
        System.out.println(" a  b c  d  e  f  g  h i  j");
        System.out.println("===========================");
        System.out.println(a + " " + b + " " + c + " " + d + " " +
                           e + " " + f + " " + g + " " + h + " " +
                           i + " " + j + "\n");

        System.out.println("k  l  m  n  o  p q  r  s  t");
        System.out.println("===========================");
        System.out.println(k + " " + l + " " + m + " " + n + " " +
                           o + " " + p + " " + q + " " + r + " " +
                           s + " " + t + "\n");

        System.out.println(" u  v  w  x  y  z");
        System.out.println("=================");
        System.out.println(u + " " + v + " " + w + " " + x + " " +
                           y + " " + z);
    }
}
```
Sample Output:

 a  b c  d  e  f  g  h i  j                                                                                   
===========================                                                                                   
36 10 7 40 33 16 42 32 6 20                                                                                   
                                                                                                              
k  l  m  n  o  p q  r  s  t                                                                                   
===========================                                                                                   
8 35 22 14 41 23 4 29 24 31                                                                                   
                                                                                                              
 u  v  w  x  y  z                                                                                             
=================                                                                                             
21 27 13 18 38 37

### 22. Write a Java program to get the length of a given string.

Sample Output:

The string length of 'example.com' is: 11
```java
// Define a public class named Exercise22.
public class Exercise22 {
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "example.com";
        
        // Get the length of the string 'str'.
        int len = str.length();
        
        // Display the length of the string.
        System.out.println("The string length of '" + str + "' is: " + len);
    }
}
```
Sample Output:

The string length of 'example.com' is: 11
### 23. Write a Java program to find out whether a region in the current string matches a region in another string.

Sample Output:

str1[0 - 7] == str2[28 - 35]? true                                                                            
str1[9 - 15] == str2[9 - 15]? false 
```java
// Define a public class named Exercise23.
public class Exercise23 {
  
    // Define the main method.
    public static void main(String[] args) {
        
        // Define two string variables.
        String str1 = "Shanghai Houston Colorado Alexandria";
        String str2 = "Alexandria Colorado Houston Shanghai";

        // Determine whether characters 0 through 7 in str1 
        // match characters 28 through 35 in str2.
        boolean match1 = str1.regionMatches(0, str2, 28, 8);

        // Determine whether characters 9 through 15 in str1 
        // match characters 9 through 15 in str2.
        boolean match2 = str1.regionMatches(9, str2, 9, 8);

        // Display the results of the regionMatches method calls.
        System.out.println("str1[0 - 7] == str2[28 - 35]? " + match1);
        System.out.println("str1[9 - 15] == str2[9 - 15]? " + match2);
    }
}
```
Sample Output:

str1[0 - 7] == str2[28 - 35]? true                                                                            
str1[9 - 15] == str2[9 - 15]? false 
### 24. Write a Java program to replace a specified character with another character.

Sample Output:

Original string: The quick brown fox jumps over the lazy dog.                                                 
New String: The quick brown fox jumps over the lazy fog.
```java
// Define a public class named Exercise24.
public class Exercise24 {
    
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "The quick brown fox jumps over the lazy dog.";

        // Replace all the 'd' characters with 'f' characters.
        String new_str = str.replace('d', 'f');

        // Display the original and modified strings for comparison.
        System.out.println("Original string: " + str);
        System.out.println("New String: " + new_str);
    }
}
```
Sample Output:

Original string: The quick brown fox jumps over the lazy dog.                                                 
New String: The quick brown fox jumps over the lazy fog.
### 25. Write a Java program to replace each substring of a given string that matches the given regular expression with the given replacement.

Sample string : "The quick brown fox jumps over the lazy dog."

In the above string replace all the fox with cat.

Sample Output:

Original string: The quick brown fox jumps over the lazy dog.                                                 
New String: The quick brown cat jumps over the lazy dog.         
```java
// Define a public class named Exercise25.
public class Exercise25 {
    
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "The quick brown fox jumps over the lazy dog.";

        // Replace all occurrences of 'fox' with 'cat'.
        String new_str = str.replaceAll("fox", "cat");
       
        // Display the original and modified strings for comparison.
        System.out.println("Original string: " + str);
        System.out.println("New String: " + new_str);
    }
}
```
Sample Output:

Original string: The quick brown fox jumps over the lazy dog.                                                 
New String: The quick brown cat jumps over the lazy dog.
### 26. Write a Java program to check whether a given string starts with another string.

Sample Output:

Red is favorite color. starts with Red? true                                                                  
Orange is also my favorite color. starts with Red? false
```java
// Define a public class named Exercise26.
public class Exercise26 {
    
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize two string variables.
        String str1 = "Red is favorite color.";
        String str2 = "Orange is also my favorite color.";

        // The String to check the above two Strings to see
        // if they start with this value (Red).
        String startStr = "Red";

        // Check if the first two Strings start with startStr.
        boolean starts1 = str1.startsWith(startStr);
        boolean starts2 = str2.startsWith(startStr);

        // Display the results of the startsWith calls.
        System.out.println(str1 + " starts with " +
             startStr + "? " + starts1);
        System.out.println(str2 + " starts with " +
             startStr + "? " + starts2);
    }
}
```
Sample Output:

Red is favorite color. starts with Red? true                                                                  
Orange is also my favorite color. starts with Red? false
### 27. Write a Java program to get a substring of a given string at two specified positions.

Sample Output:

old = The quick brown fox jumps over the lazy dog.                                                            
new = brown fox jumps
```java
// Define a public class named Exercise27.
public class Exercise27 {
    
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "The quick brown fox jumps over the lazy dog.";

        // Get a substring of the above string starting from
        // index 10 and ending at index 26.
        String new_str = str.substring(10, 26);

        // Display the original and the extracted substring for comparison.
        System.out.println("old = " + str);
        System.out.println("new = " + new_str);
    }
}
```
Sample Output:

old = The quick brown fox jumps over the lazy dog.                                                            
new = brown fox jumps
### 28. Write a Java program to create a character array containing a string.

Sample Output:

Java Exercises.
```java
// Define a public class named Exercise28.
public class Exercise28 {
    
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "Java Exercises.";

        // Convert the above string to a char array.
        char[] arr = str.toCharArray();

        // Display the contents of the char array.
        System.out.println(arr);
    }
}
```
Sample Output:

Java Exercises.
### 29. Write a Java program to convert all characters in a string to lowercase.

Sample Output:

Original String: The Quick BroWn FoX!                                                                         
String in lowercase: the quick brown fox!
```java
// Define a public class named Exercise29.
public class Exercise29 {
    
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "The Quick BroWn FoX!";

        // Convert the above string to all lowercase.
        String lowerStr = str.toLowerCase();

        // Display the original and lowercase strings for comparison.
        System.out.println("Original String: " + str);
        System.out.println("String in lowercase: " + lowerStr);
    }
}
```
Sample Output:

Original String: The Quick BroWn FoX!                                                                         
String in lowercase: the quick brown fox!
### 30. Write a Java program to convert all characters in a string to uppercase.

Sample Output:

Original String: The Quick BroWn FoX!                                                                         
String in uppercase: THE QUICK BROWN FOX!  
```java
// Define a public class named Exercise30.
public class Exercise30 {
    
    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = "The Quick BroWn FoX!";

        // Convert the above string to all uppercase.
        String upper_str = str.toUpperCase();

        // Display the original and uppercase strings for comparison.
        System.out.println("Original String: " + str);
        System.out.println("String in uppercase: " + upper_str);
    }
}
```
Sample Output:

Original String: The Quick BroWn FoX!                                                                         
String in uppercase: THE QUICK BROWN FOX! 
### 31. Write a Java program to trim leading or trailing whitespace from a given string.

Sample Output:

Original String:  Java Exercises                                                                              
New String: Java Exercises
```java
// Define a public class named Exercise31.
public class Exercise31 {

    // Define the main method.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str = " Java Exercises ";

        // Trim the whitespace from the front and back of the String.
        String new_str = str.trim();

        // Display the original and trimmed strings for comparison.
        System.out.println("Original String: " + str);
        System.out.println("New String: " + new_str);
    }
}
```
Sample Output:

Original String:  Java Exercises                                                                              
New String: Java Exercises
### 32. Write a Java program to find the longest Palindromic Substring within a string.

Sample Output:

The given string is: thequickbrownfoxxofnworbquickthe
The longest palindrome substring in the giv
en string is; brownfoxxofnworb
The length of the palindromic substring is: 16
```java
// Import the necessary Java utilities.
import java.util.*;

// Define a public class named Main.
public class Main {

    // Define a method to print the substring given start and end indices.
    static void printSubStr(String str1, int l, int h) {
        System.out.println(str1.substring(l, h + 1));
    }

    // Define a method to find the longest palindromic substring.
    static int longPalSubstr(String str1) {
        int n = str1.length();
        boolean table[][] = new boolean[n][n];
        int mLength = 1;

        // Fill the diagonal elements as true.
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        int strt = 0;

        // Check for palindromes of length 2.
        for (int i = 0; i < n - 1; ++i) {
            if (str1.charAt(i) == str1.charAt(i + 1)) {
                table[i][i + 1] = true;
                strt = i;
                mLength = 2;
            }
        }

        // Check for palindromes of length greater than 2.
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str1.charAt(i) == str1.charAt(j)) {
                    table[i][j] = true;

                    if (k > mLength) {
                        strt = i;
                        mLength = k;
                    }
                }
            }
        }

        // Print the longest palindromic substring.
        System.out.print("The longest palindrome substring in the given string is: ");
        printSubStr(str1, strt, strt + mLength - 1);
        return mLength;
    }

    // The main method to execute the code.
    public static void main(String[] args) {
        // Define the input string.
        String str1 = "thequickbrownfoxxofnworbquickthe";

        // Print the given string.
        System.out.println("The given string is: " + str1);

        // Find and print the length of the longest palindromic substring.
        System.out.println("The length of the palindromic substring is: " + longPalSubstr(str1));
    }
}
```
Sample Output:

The given string is: thequickbrownfoxxofnworbquickthe
The longest palindrome substring in the giv
en string is; brownfoxxofnworb
The length of the palindromic substring is: 16
### 33. Write a Java program to find all interleavings of given strings.

Sample Output:

The given strings are: WX  YZ
The interleavings strings are: 
YWZX
WYZX
YWXZ
WXYZ
YZWX
WYXZ
```java
// Import necessary Java utilities.
import java.util.HashSet;
import java.util.Set;

// Define a class named Main.
class Main {
    
    // Define a method to find all interleavings of two strings.
    public static void allInterleavings(String res, String P, String Q, Set out) {
        // If both strings are empty, add the result to the output set.
        if (P.length() == 0 && Q.length() == 0) {
            out.add(res);
            return;
        }
        
        // If string P is not empty, recursively call allInterleavings with the first character of P removed.
        if (P.length() > 0) {
            allInterleavings(res + P.charAt(0), P.substring(1), Q, out);
        }
        
        // If string Q is not empty, recursively call allInterleavings with the first character of Q removed.
        if (Q.length() > 0) {
            allInterleavings(res + Q.charAt(0), P, Q.substring(1), out);
        }
    }

    // The main method to execute the code.
    public static void main(String[] args) {
        // Define the input strings.
        String P = "WX";
        String Q = "YZ";

        // Print the given strings.
        System.out.println("The given strings are: " + P + "  " + Q);
        System.out.println("The interleavings strings are: ");

        // Create a HashSet to store unique interleavings.
        Set<String> out = new HashSet<>();

        // Call the allInterleavings method to generate interleavings of the input strings.
        allInterleavings("", P, Q, out);

        // Print all the generated interleavings using streams.
        out.stream().forEach(System.out::println);
    }
}
```
Sample Output:

The given strings are: WX  YZ
The interleavings strings are: 
YWZX
WYZX
YWXZ
WXYZ
YZWX
WYXZ
### 34. Write a Java program to find the second most frequent character in a given string.

Sample Output:

The given string is: successes
The second most frequent char in the string is: c
```java
// Import necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    // Define a constant representing the number of characters (ASCII).
    static final int NOOFCHARS = 256;

    // Define a method to find the second most frequent character in a string.
    static char get2ndMostFreq(String str1) {
        // Create an array to count occurrences of each character in the string.
        int[] ctr = new int[NOOFCHARS];
        int i;

        // Count occurrences of each character in the string.
        for (i = 0; i < str1.length(); i++) {
            (ctr[str1.charAt(i)])++;
        }

        // Variables to store indices of the first and second most frequent characters.
        int ctr_first = 0, ctr_second = 0;
        for (i = 0; i < NOOFCHARS; i++) {
            if (ctr[i] > ctr[ctr_first]) {
                ctr_second = ctr_first;
                ctr_first = i;
            } else if (ctr[i] > ctr[ctr_second] && ctr[i] != ctr[ctr_first]) {
                ctr_second = i;
            }
        }

        // Return the second most frequent character.
        return (char) ctr_second;
    }

    // The main method to execute the code.
    public static void main(String args[]) {
        // Define the input string.
        String str1 = "successes";
        System.out.println("The given string is: " + str1);

        // Get the second most frequent character from the input string.
        char res = get2ndMostFreq(str1);

        // Display the result.
        if (res != '\0') {
            System.out.println("The second most frequent char in the string is: " + res);
        } else {
            System.out.println("No second most frequent character found in the string.");
        }
    }
}
```
Sample Output:

The given string is: successes
The second most frequent char in the string is: c
### 35. Write a Java program to print all permutations of a given string with repetition.

Sample Output:

The given string is: PQR
The permuted strings are:
PPP
PPQ
PPR
...
RRP
RRQ
RRR
```java
// Import necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {

    // The main method to start the execution of the program.
    public static void main(String[] args) {
        // Call the permutationWithRepeation method with the given string "PQR".
        permutationWithRepeation("PQR");
    }

    // Method to find permutations with repetition of characters.
    private static void permutationWithRepeation(String str1) {
        // Print the given string.
        System.out.println("The given string is: PQR");
        // Print the message for the permuted strings.
        System.out.println("The permuted strings are:");
        // Call the showPermutation method to display the permutations.
        showPermutation(str1, "");
    }

    // Recursive method to generate and display permutations.
    private static void showPermutation(String str1, String newStringToPrint) {
        // If the length of the new string equals the length of the original string, print the new string.
        if (newStringToPrint.length() == str1.length()) {
            System.out.println(newStringToPrint);
            return;
        }

        // Iterate through the characters of the original string.
        for (int i = 0; i < str1.length(); i++) {
            // Recursively call showPermutation to append characters and generate permutations.
            showPermutation(str1, newStringToPrint + str1.charAt(i));
        }
    }
}
```
Sample Output:

The given string is: PQR
The permuted strings are:
PPP
PPQ
PPR
PQP
PQQ
PQR
PRP
PRQ
PRR
QPP
QPQ
QPR
QQP
QQQ
QQR
QRP
QRQ
QRR
RPP
RPQ
RPR
RQP
RQQ
RQR
RRP
RRQ
RRR
### 36. Write a Java program to check whether two strings interlive of a given string. Assuming that unique characters are present in both strings.

Sample Output:

The given string is: PMQNO
The interleaving strings are MNO and PQ
The given string is interleaving: true

The given string is: PNQMO
The interleaving strings are MNO and PQ
The given string is interleaving: false
```java
// Import necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    
    // The main method to start the execution of the program.
    public static void main(String args[]) {
        // Define three strings.
        String str1 = "MNO";
        String str2 = "PQ";
        String str3 = "PMQNO";
        
        // Print the given string and interleaving strings.
        System.out.println("The given string is: " + str3);
        System.out.println("The interleaving strings are " + str1 + " and " + str2);
        
        // Check if the given string is interleaving of str1 and str2, then print the result.
        System.out.println("The given string is interleaving: " + checkInterleaved(str1, str2, str3));
    }
    
    // Method to check if a string is interleaving of two other strings.
    private static boolean checkInterleaved(String str1, String str2, String CheckInString) {
        int i = 0, j = 0, k = 0;
        
        // If the length of concatenated str1 and str2 doesn't match the length of the checked string, return false.
        if (str1.length() + str2.length() != CheckInString.length()) {
            return false;
        }
        
        // Loop through the checked string.
        while (k < CheckInString.length()) {
            // Check if character at index i in str1 matches with character at index k in CheckInString.
            if (i < str1.length() && str1.charAt(i) == CheckInString.charAt(k)) {
                i++;
            }
            // Check if character at index j in str2 matches with character at index k in CheckInString.
            else if (j < str2.length() && str2.charAt(j) == CheckInString.charAt(k)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        
        // If lengths of str1, str2, and CheckInString don't match, return false.
        if (!(i == str1.length() && j == str2.length() && k == CheckInString.length())) {
            return false;
        }
        
        return true;
    }
}
```
Sample Output:

The given string is: PMQNO
The interleaving strings are MNO and PQ
The given string is interleaving: true

The given string is: PNQMO
The interleaving strings are MNO and PQ
The given string is interleaving: false
### 37. Write a Java program to find the length of the longest substring of a given string without repeating characters.

Sample Output:

Input String : pickoutthelongestsubstring
The longest substring : [u, b, s, t, r, i, n, g]
The longest Substring Length : 8
```java
import java.util.LinkedHashMap;
public class Main {
    // Method to find the longest substring with non-repeating characters
    static void longestSubstring(String inputString) {
        // Convert the inputString to a character array
        char[] arr1 = inputString.toCharArray();
        // Initialize variables to store the longest substring and its length
        String longestSubstring = "";
        int maxLength = 0;
        // Create a LinkedHashMap to store characters and their positions
        LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<>();
        // Loop through the character array
        for (int i = 0; i < arr1.length; i++) {
            char ch = arr1[i];
            // Check if the character is not already present in the charPosMap
            if (!charPosMap.containsKey(ch)) {
                // If not present, add the character and its position to the map
                charPosMap.put(ch, i);
            } else {
                // If the character is present, update the start position of the substring
                // to the position after the repeated character
                i = charPosMap.get(ch);
                // Clear the map to start anew for the next non-repeating substring
                charPosMap.clear();
            }
            // Check if the current substring length is greater than the stored length
            if (charPosMap.size() > maxLength) {
                // If yes, update the longest substring and its length
                maxLength = charPosMap.size();
                // Extract the substring from the inputString using start and end indices
                longestSubstring = inputString.substring(i - maxLength + 1, i + 1);
            }
        }
        // Print the original inputString, the longest substring found, and its length
        System.out.println("Input String: " + inputString);
        System.out.println("The longest substring: " + longestSubstring);
        System.out.println("The longest Substring Length: " + maxLength);
    }
    // Main method to execute the program
    public static void main(String[] args) {
        // Call the longestSubstring method with different input strings
        longestSubstring("pickoutthelongestsubstring");
        longestSubstring("ppppppppppppp");
        longestSubstring("Microsoft");
    }
}
```
Sample Output:

Input String: pickoutthelongestsubstring
The longest substring: ubstring
The longest Substring Length: 8
Input String: ppppppppppppp
The longest substring: p
The longest Substring Length: 1
Input String: Microsoft
The longest substring: Micros
The longest Substring Length: 6
### 38. Write a Java program to print the result of removing duplicates from a given string.

Sample Output:

The given string is: w3resource
After removing duplicates characters the new string is: w3resouc
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    
    // Main method to execute the program.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str1 = "w3resource";
        
        // Print the original string.
        System.out.println("The given string is: " + str1);
        
        // Print the new string after removing duplicate characters.
        System.out.println("After removing duplicates characters the new string is: " + removeDuplicateChars(str1));
    }
    
    // Method to remove duplicate characters from a string.
    private static String removeDuplicateChars(String sourceStr) {
        // Convert the input string to a character array.
        char[] arr1 = sourceStr.toCharArray();
        
        // Initialize an empty string to store the resulting string without duplicates.
        String targetStr = "";
        
        // Loop through each character in the character array.
        for (char value: arr1) {
            // Check if the character doesn't exist in the targetStr.
            if (targetStr.indexOf(value) == -1) {
                // If the character doesn't exist, add it to the targetStr.
                targetStr += value;
            }
        }
        
        // Return the resulting string without duplicates.
        return targetStr;
    }
}
```
Sample Output:

The given string is: w3resource
After removing duplicates characters the new string is: w3resouc
### 39. Write a Java program to find the first non-repeating character in a string.

Sample Output:

The given string is: gibblegabbler
The first non repeated character in String is: i
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    
    // Main method to execute the program.
    public static void main(String[] args) {
        // Declare and initialize a string variable.
        String str1 = "gibblegabbler";
        
        // Print the original string.
        System.out.println("The given string is: " + str1);
        
        // Loop through each character of the string.
        for (int i = 0; i < str1.length(); i++) {
            // Assume the character at index 'i' is unique initially.
            boolean unique = true;
            
            // Loop through the string again to compare characters.
            for (int j = 0; j < str1.length(); j++) {
                // Check if the characters at positions 'i' and 'j' are the same but not at the same index.
                if (i != j && str1.charAt(i) == str1.charAt(j)) {
                    // If found, set unique to false and break the loop.
                    unique = false;
                    break;
                }
            }
            
            // If the character at index 'i' is unique, print it and exit the loop.
            if (unique) {
                System.out.println("The first non-repeated character in the String is: " + str1.charAt(i));
                break;
            }
        }
    }
}
```
Sample Output:

The given string is: gibblegabbler
The first non repeated character in String is: i
### 40. Write a Java program to divide a string into n equal parts.

Sample Output:

The given string is: abcdefghijklmnopqrstuvwxy
The string divided into 5 parts and they are: 

abcde
fghij
klmno
pqrst
uvwxy
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
class Main {
    
    // Method to split the string into 'n' parts.
    static void splitString(String str1, int n) {
        // Get the length of the string.
        int str_size = str1.length();
        int part_size;
        
        // Check if the size of the string is divisible by 'n'.
        if (str_size % n != 0) {
            // If not divisible, print a message and return.
            System.out.println("The size of the given string is not divisible by " + n);
            return;
        } else {
            // If divisible, proceed to split the string.
            System.out.println("The given string is: " + str1);
            System.out.println("The string divided into " + n + " parts and they are: ");
            
            // Calculate the size of each part.
            part_size = str_size / n;
            
            // Loop through the string characters.
            for (int i = 0; i < str_size; i++) {
                // If the current index is a multiple of 'part_size', start a new line.
                if (i % part_size == 0)
                    System.out.println();
                // Print the character at the current index.
                System.out.print(str1.charAt(i));
            }
        }
    }
    
    // Main method to execute the program.
    public static void main(String[] args) {
        // Define a string and the number of parts to split.
        String str1 = "abcdefghijklmnopqrstuvwxy";
        int split_number = 5;
        
        // Call the method to split the string.
        splitString(str1, split_number);
    }
}
```
Sample Output:

The given string is: abcdefghijklmnopqrstuvwxy
The string divided into 5 parts and they are: 

abcde
fghij
klmno
pqrst
uvwxy
### 41. Write a Java program to remove duplicate characters from a given string that appear in another given string.

Sample Output:

The given string is: the quick brown fox
The given mask string is: queen

The new string is: 
th ick brow fox
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    
    // Main method to execute the program.
    public static void main(String[] args) {
        // Define two strings.
        String str1 = "the quick brown fox";
        String str2 = "queen";
        
        // Print the given strings.
        System.out.println("The given string is: " + str1);
        System.out.println("The given mask string is: " + str2);
        
        // Create a character array of the length of the first string.
        char arr[] = new char[str1.length()];
        
        // Create a character array to represent a mask of size 256 (ASCII characters).
        char[] mask = new char[256];
        
        // Loop through the characters of the mask string and count occurrences of each character.
        for (int i = 0; i < str2.length(); i++)
            mask[str2.charAt(i)]++;
        
        // Print a header for the new string.
        System.out.println("\nThe new string is: ");
        
        // Loop through the characters of the first string.
        for (int i = 0; i < str1.length(); i++) {
            // If the character at the current index in str1 is not found in str2 (mask is 0), print it.
            if (mask[str1.charAt(i)] == 0)
                System.out.print(str1.charAt(i));
        }
    }
}
```
Sample Output:

The given string is: the quick brown fox
The given mask string is: queen

The new string is: 
th ick brow fox
### 42. Write a Java program to print a list of items containing all characters of a given word.

Sample Output:

The given strings are: rabbit   bribe   dog   
The given word is: bib 

The strings containing all the letters of the given word are: 
rabbit
bribe
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
class Main {
    
    // Define a method to check if a given string contains all the letters of another string.
    static void checkExistance(String str1, String str_to_search) {
        int chk = 0; // Variable to check existence.
        char chhr = ' '; // Character variable.
        int[] a = new int[Character.MAX_VALUE + 1]; // Array to store character counts.

        // Loop through each character of the first string and count occurrences.
        for (int i = 0; i < str1.length(); i++) {
            chhr = str1.charAt(i);
            ++a[chhr];
        }
        
        // Loop through each character of the string to search.
        for (int i = 0; i < str_to_search.length(); i++) {
            chhr = str_to_search.charAt(i);
            if (a[chhr] >= 1)
                chk = 1; // Set check flag if character exists in the first string.
        }
        
        // If check flag is set, print the first string.
        if (chk == 1)
            System.out.println(str1);
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        // Create a list of strings.
        List < String > list = new ArrayList < String > ();
        list.add("rabbit");
        list.add("bribe");
        list.add("dog");

        // Print the given strings.
        System.out.print("The given strings are: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "   ");
        }
        
        // Print the given word.
        System.out.println("\nThe given word is: bib ");
        System.out.println("\nThe strings containing all the letters of the given word are: ");
        
        // Check each string in the list for the existence of letters from the given word.
        for (int j = 0; j < list.size(); j++) {
            checkExistance(list.get(j), "bib");
        }
    }
}
```
Sample Output:

The given strings are: rabbit   bribe   dog   
The given word is: bib 

The strings containing all the letters of the given word are: 
rabbit
bribe
### 43. Write a Java program to find the character in a string that occurs the most frequently.

Sample Output:

The given string is: test string
Max occurring character in the given string is: t
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    
    // Define a constant for the size of the character set.
    static final int N = 256;
    
    // Method to find the character with the maximum occurrence in the string.
    static char MaxOccuringChar(String str1) {
        int ctr[] = new int[N]; // Array to count occurrences of each character.
        int l = str1.length(); // Length of the given string.
        
        // Loop through the string to count occurrences of each character.
        for (int i = 0; i < l; i++)
            ctr[str1.charAt(i)]++;
        
        int max = -1; // Variable to store maximum occurrence.
        char result = ' '; // Variable to store the character with the maximum occurrence.

        // Loop through the string to find the character with the maximum occurrence.
        for (int i = 0; i < l; i++) {
            if (max < ctr[str1.charAt(i)]) {
                max = ctr[str1.charAt(i)];
                result = str1.charAt(i);
            }
        }

        return result; // Return the character with the maximum occurrence.
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        String str1 = "test string"; // Given input string.
        
        // Display the given string.
        System.out.println("The given string is: " + str1);
        
        // Display the character with the maximum occurrence in the given string.
        System.out.println("Max occurring character in the given string is: " + MaxOccuringChar(str1));
    }
}
```
Sample Output:

The given string is: test string
Max occurring character in the given string is: t
### 44. Write a Java program to reverse a string using recursion.

Sample Output:

The given string is: The quick brown fox jumps
The string in reverse order is:
spmuj xof nworb kciuq ehT
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
class Main {
    
    // Method to reverse a string recursively.
    void reverseString(String str1) {
        // Base case: if the string is null or has a length less than or equal to 1, print the string.
        if ((str1 == null) || (str1.length() <= 1))
            System.out.println(str1);
        else {
            // Print the last character of the string.
            System.out.print(str1.charAt(str1.length() - 1));
            
            // Recursive call to reverseString method by excluding the last character.
            reverseString(str1.substring(0, str1.length() - 1));
        }
    }
    
    // Main method to execute the program.
    public static void main(String[] args) {
        String str1 = "The quick brown fox jumps"; // Given input string.
        
        // Display the given string.
        System.out.println("The given string is: " + str1);
        
        // Display the string in reverse order.
        System.out.println("The string in reverse order is:");
        
        // Create an object of Main class to call the reverseString method.
        Main obj = new Main();
        obj.reverseString(str1);
    }
}
```
Sample Output:

The given string is: The quick brown fox jumps
The string in reverse order is:
spmuj xof nworb kciuq ehT
### 45. Write a Java program to reverse words in a given string.

Sample Output:

The given string is: Reverse words in a given string
The new string after reversed the words: string given a in words Reverse
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    
    // Method to reverse words in a given string.
    public static String WordsInReverse(String str1) {
        // Create a StringBuilder object and reverse the entire string.
        StringBuilder sb = new StringBuilder(str1);
        String StrRev = sb.reverse().toString();

        // Split the reversed string into words.
        String[] words = StrRev.split(" ");
        
        // Create a StringBuilder to store the reversed words.
        StringBuilder reverse = new StringBuilder();
        
        // Iterate through each word, reverse it, and append it to the result string.
        for (String tmp: words) {
            sb = new StringBuilder(tmp);
            reverse.append(sb.reverse() + " ");
        }
        
        // Remove the trailing space and return the reversed words string.
        reverse.deleteCharAt(reverse.length() - 1);
        return reverse.toString();
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        String str1 = "Reverse words in a given string"; // Given input string.
        
        // Display the given string.
        System.out.println("The given string is: " + str1);
        
        // Display the string after reversing the words.
        System.out.println("The new string after reversing the words: " + WordsInReverse(str1));
    }
}
```
Sample Output:

The given string is: Reverse words in a given string
The new string after reversed the words: string given a in words Reverse
### 46. Write a Java program to reverse every word in a string using methods.

Sample Output:

The given string is: This is a test string
The string reversed word by word is: 
sihT si a tset gnirts
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    
    // Method to reverse each word in a given string.
    public void reverseEachWordInString(String str1) {
        // Split the input string into individual words.
        String[] each_words = str1.split(" ");
        String revString = "";
        
        // Iterate through each word in the array.
        for (int i = 0; i < each_words.length; i++) {
            String word = each_words[i];
            String reverseWord = "";
            
            // Reverse each word character by character.
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            
            // Build the reversed string by appending the reversed word.
            revString = revString + reverseWord + " ";
        }
        
        // Display the string with reversed words.
        System.out.println(revString);
    }
    
    // Main method to execute the program.
    public static void main(String[] args) {
        // Create an object of the Main class.
        Main obj = new Main();
        String StrGiven = "This is a test string"; // Given input string.
        
        // Display the given input string.
        System.out.println("The given string is: " + StrGiven);
        System.out.println("The string reversed word by word is: ");
        
        // Call the method to reverse each word in the string.
        obj.reverseEachWordInString(StrGiven);
    }
}
```
Sample Output:

The given string is: This is a test string
The string reversed word by word is: 
sihT si a tset gnirts
### 47. Write a Java program to rearrange a string so that the same characters are positioned a distance away.

Sample Output:

The given string is: accessories
The string after arrange newly is: 
secrsecisao
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {

    // Define a constant value for character count.
    public static int MX = 26;

    // Define a class to store character frequency.
    static class freqOfChar {
        char c;
        int f;

        // Constructor for freqOfChar class.
        public freqOfChar(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        String strr = "accessories";
        System.out.println("The given string is: " + strr);
        System.out.println("The string after arranging newly is: ");
        String strg = charRearrange(strr, 4);
        if (strg != null)
            System.out.println(strg);
    }

    // Method to rearrange characters in a string based on frequency and distance k.
    public static String charRearrange(String strg, int k) {
        if (strg.length() <= 1) return strg;

        // Create an array of frequency of characters.
        freqOfChar[] chr_fre = new freqOfChar[MX];
        int ctr = 0;

        // Initialize the frequency array.
        for (int i = 0; i < MX; i++) {
            chr_fre[i] = new freqOfChar((char)('a' + i), 0);
        }

        // Calculate frequency of each character in the string.
        for (int i = 0; i < strg.length(); i++) {
            char ch = strg.charAt(i);
            chr_fre[ch - 'a'].f++;
            if (chr_fre[ch - 'a'].f == 1) ctr++;
        }

        // Build a max heap based on character frequencies.
        bldOfHeap(chr_fre, MX);

        // Create arrays to store rearranged characters and their occurrences.
        char[] str1 = new char[strg.length()];
        boolean[] occu = new boolean[strg.length()];

        // Rearrange characters according to frequency and distance k.
        for (int i = 0; i < ctr; i++) {
            freqOfChar chfreq = extractMax(chr_fre, MX - i);
            int ptr = i;
            while (occu[ptr]) ptr++;

            for (int j = 0; j < chfreq.f; j++) {
                if (ptr >= str1.length)
                    return null;
                str1[ptr] = chfreq.c;
                occu[ptr] = true;
                ptr += k;
            }
        }
        return new String(str1);
    }

    // Method to build a max heap.
    private static void bldOfHeap(freqOfChar[] chr_fre, int size) {
        int i = (size - 1) / 2;
        while (i >= 0) {
            maxHeapify(chr_fre, i, size);
            i--;
        }
    }

    // Method to swap two elements in the frequency array.
    private static void swap(freqOfChar cf1, freqOfChar cf2) {
        char c = cf1.c;
        int f = cf1.f;
        cf1.c = cf2.c;
        cf1.f = cf2.f;
        cf2.c = c;
        cf2.f = f;
    }

    // Method to maintain the max heap property.
    private static void maxHeapify(freqOfChar[] chr_fre, int node, int size) {
        int l = node * 2 + 1;
        int r = node * 2 + 2;
        int largest = node;
        if (l < size && chr_fre[l].f > chr_fre[node].f) {
            largest = l;
        }
        if (r < size && chr_fre[r].f > chr_fre[largest].f) {
            largest = r;
        }
        if (largest != node) {
            swap(chr_fre[node], chr_fre[largest]);
            maxHeapify(chr_fre, largest, size);
        }
    }

    // Method to extract the maximum frequency element from the heap.
    private static freqOfChar extractMax(freqOfChar[] chr_fre, int size) {
        freqOfChar max = chr_fre[0];
        chr_fre[0] = chr_fre[size - 1];
        chr_fre[size - 1] = null;
        maxHeapify(chr_fre, 0, size - 1);
        return max;
    }
}
```
Sample Output:

The given string is: accessories
The string after arrange newly is: 
secrsecisao
### 48. Write a Java program to remove "b" and "ac" from a given string.

Sample Output:

The given string is: abrambabasc
After removing the new string is: aramaasc
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {

    // Main method to execute the program.
    public static void main(String[] args) {
        // Define the input string.
        String strg = "abrambabasc";
        System.out.println("The given string is: " + strg);
        System.out.print("After removing the specified characters, the new string is: ");
        // Call the method to remove specific characters from the string.
        removeSetofCharacters(strg, "ac", "b");
    }

    // Method to remove specified characters from the given string.
    public static void removeSetofCharacters(String str, String ptn1, String ptn2) {
        // Get the length of the string and initialize variables.
        int n = str.length(), i;
        int ptr = 0;
        // Convert the string to a character array.
        char[] arr1 = str.toCharArray();

        // Loop through each character in the string.
        for (i = 0; i < n; ++i) {
            // Check conditions to remove characters based on the specified patterns.
            if (arr1[i] == 'b') {
                continue; // Skip 'b'.
            } else if (i + 1 < n && arr1[i] == 'a' && arr1[i + 1] == 'c') {
                ++i; // Skip 'ac'.
            } else {
                arr1[ptr++] = arr1[i]; // Copy character to the new position.
            }
        }

        // Create a new character array with the modified string.
        char[] ret = Arrays.copyOfRange(arr1, 0, ptr);
        // Convert the character array to a string and print the result.
        System.out.println(new String(ret));
    }
}
```
Sample Output:

The given string is: abrambabasc
After removing the new string is: aramaasc
### 49. Write a Java program to find the first non-repeating character from a stream of characters.

Sample Output:

String: godisgood
Reading: g
The first non-repeating character so far is:  g
Reading: o
The first non-repeating character so far is:  g
Reading: d
The first non-repeating character so far is:  g
Reading: i
The first non-repeating character so far is:  g
Reading: s
The first non-repeating character so far is:  g
Reading: g
The first non-repeating character so far is:  o
Reading: o
The first non-repeating character so far is:  d
Reading: o
The first non-repeating character so far is:  d
Reading: d
The first non-repeating character so far is:  i
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {

    // Main method to execute the program.
    public static void main(String[] args) {

        // Define the maximum number of characters.
        int MXCHAR = 256;

        // Create a list to store characters in a doubly linked list.
        List inDLL = new ArrayList();

        // Create a boolean array to check if a character is repeated.
        boolean[] repeatyn = new boolean[MXCHAR];

        // Define the input string.
        String chrstream = "godisgood";
        System.out.println("String: " + chrstream);

        // Loop through each character in the input string.
        for (int i = 0; i < chrstream.length(); i++) {

            // Get the character at the current index.
            char x = chrstream.charAt(i);
            System.out.println("Reading: " + x);

            // Check if the character is non-repeating.
            if (!repeatyn[x]) {
                // If the character is not repeated yet.
                if (!(inDLL.contains(x))) {
                    inDLL.add(x); // Add the character to the list.
                } else {
                    // If the character is already in the list, remove it and mark it as repeated.
                    inDLL.remove((Character) x);
                    repeatyn[x] = true;
                }
            }

            // Display the first non-repeating character encountered so far.
            if (inDLL.size() != 0) {
                System.out.print("The first non-repeating character so far is:  ");
                System.out.println(inDLL.get(0));
            }
        }
    }
}
```
Sample Output:

String: godisgood
Reading: g
The first non-repeating character so far is:  g
Reading: o
The first non-repeating character so far is:  g
Reading: d
The first non-repeating character so far is:  g
Reading: i
The first non-repeating character so far is:  g
Reading: s
The first non-repeating character so far is:  g
Reading: g
The first non-repeating character so far is:  o
Reading: o
The first non-repeating character so far is:  d
Reading: o
The first non-repeating character so far is:  d
Reading: d
The first non-repeating character so far is:  i
### 50. Write a Java program to find the lexicographic rank of a given string.

Sample Output:

The Given String is: BDCA
The Lexicographic rank of the given string is: 12
N.B.: Total possible permutations of BDCA are(lexicographic order) :
ABCD ABDC ACBD ACDB ADBC ADCB BACD BADC BCAD BCDA BDAC BDCA
1   2   3   4   5   6   7   8   9   10   11   12
The BDCA appear in 12 position of permutation (lexicographic order).
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
class Main {
  
  // Method to calculate factorial of a number recursively.
  public static int makefactorial(int n) {
    // If n is less than or equal to 2, return n. Otherwise, calculate n * factorial of (n - 1).
    return (n <= 2) ? n : n * makefactorial(n - 1);
  }

  // Method to calculate the lexicographic rank of a given string.
  public static int calcuLexicoRank(String str, int n) {
    // Counter for the rank initialized to 1.
    int ctrOfRank = 1;
    
    // Loop through each character in the string.
    for (int i = 0; i < n; i++) {
      int ctr = 0;
      
      // Compare the character at index i with subsequent characters.
      for (int j = i + 1; j <= n; j++) {
        // If the character at index i is greater than the character at index j, increment the counter.
        if (str.charAt(i) > str.charAt(j))
          ctr++;
      }
      
      // Calculate the lexicographic rank using the formula.
      ctrOfRank += ctr * makefactorial(n - i);
    }
    return ctrOfRank; // Return the calculated rank.
  }
  
  // Main method to execute the program.
  public static void main(String[] args) {
    String str = "BDCA";
    System.out.println("The Given String is: " + str);
    int n = str.length(); // Get the length of the string.
    // Display the lexicographic rank of the given string.
    System.out.print("The Lexicographic rank of the given string is: " + calcuLexicoRank(str, n - 1));
  }
}
```
Sample Output:

The Given String is: BDCA
The Lexicographic rank of the given string is: 12

### 51. Write a Java program to count and print all duplicates in the input string.

Sample Output:

The given string is: w3resource
The duplicate characters and counts are: 
e  appears  2  times
r  appears  2  times
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
public class Main {
    // Constant to represent the maximum number of characters (ASCII).
    static final int MAX_CHARS = 256;

    // Method to count the occurrences of each character in the string.
    static void CountCharacters(String str1, int[] ctr) {
        // Loop through the characters in the string.
        for (int i = 0; i < str1.length(); i++)
            ctr[str1.charAt(i)]++; // Increment the count for the corresponding character.
    }

    // Method to display the duplicate characters along with their counts.
    static void showDuplicates(String str1) {
        int ctr[] = new int[MAX_CHARS]; // Array to store character counts.
        CountCharacters(str1, ctr); // Count the characters in the string.

        // Loop through all ASCII characters.
        for (int i = 0; i < MAX_CHARS; i++) {
            // If the count of a character is greater than 1, it's a duplicate character.
            if (ctr[i] > 1)
                // Print the duplicate character and its count.
                System.out.printf("%c  appears  %d  times\n", i, ctr[i]);
        }
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        String str1 = "w3resource";
        System.out.println("The given string is: " + str1);
        System.out.println("The duplicate characters and counts are: ");
        showDuplicates(str1); // Display the duplicate characters and their counts.
    }
}
```
Sample Output:

The given string is: w3resource
The duplicate characters and counts are: 
e  appears  2  times
r  appears  2  times
### 52. Write a Java program to check if two given strings are rotations of each other.

Sample Output:

The given strings are: ABACD  and  CDABA

The concatination of 1st string twice is: ABACDABACD
The 2nd string CDABA  exists in the new string.

Strings are rotations of each other
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
class Main {
    // Method to check if one string is a rotation of another string.
    static boolean checkForRotation(String str1, String str2) {
        // Check if both strings have the same length and str2 is found in the concatenated str1+str1.
        return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        // Define two strings for comparison.
        String str1 = "ABACD";
        String str2 = "CDABA";

        // Print the given strings.
        System.out.println("The given strings are: " + str1 + "  and  " + str2);

        // Print the concatenation of the 1st string twice.
        System.out.println("\nThe concatenation of 1st string twice is: " + str1 + str1);

        // Check if the second string is a rotation of the first string.
        if (checkForRotation(str1, str2)) {
            // Print messages when the rotation is found.
            System.out.println("The 2nd string " + str2 + "  exists in the new string.");
            System.out.println("\nStrings are rotations of each other");
        } else {
            // Print messages when the rotation is not found.
            System.out.println("The 2nd string " + str2 + "  does not exist in the new string.");
            System.out.printf("\nStrings are not rotations of each other");
        }
    }
}
```
Sample Output:

The given strings are: ABACD  and  CDABA

The concatination of 1st string twice is: ABACDABACD
The 2nd string CDABA  exists in the new string.

Strings are rotations of each other
### 53. Write a Java program to match two strings where one string contains wildcard characters.

Sample Output:

The given string is: abcdhgh
The given pattern string is: abc*d?*
The given pattern is matching.
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
class Main {
    
    // Method to check for matching pattern using wildcard characters.
    public static boolean chkMatching(char[] str1, char[] patstr, int n, int m, boolean[][] lookup) {
        // Base case: Both strings are empty, return true.
        if (m < 0 && n < 0) {
            return true;
        } else if (m < 0) {
            // If pattern string is empty but main string is not, return false.
            return false;
        } else if (n < 0) {
            // If main string is empty but pattern string contains only '*', return true.
            for (int i = 0; i <= m; i++) {
                if (patstr[i] != '*') {
                    return false;
                }
            }
            return true;
        }
        
        // If lookup table at current indices has not been calculated yet.
        if (!lookup[m][n]) {
            if (patstr[m] == '*') {
                // If pattern contains '*', check for matching by moving in both directions in pattern.
                lookup[m][n] = chkMatching(str1, patstr, n - 1, m, lookup) ||
                                chkMatching(str1, patstr, n, m - 1, lookup);
            } else {
                // If characters at current positions match or are '?' (wildcard), move to the previous positions.
                if (patstr[m] != '?' && patstr[m] != str1[n]) {
                    lookup[m][n] = false;
                } else {
                    lookup[m][n] = chkMatching(str1, patstr, n - 1, m - 1, lookup);
                }
            }
        }
        return lookup[m][n];
    }
    
    // Main method to execute the program.
    public static void main(String[] args) {
        // Define two strings for comparison.
        String st1 = "abcdhgh";
        String st2 = "abc*d?*";
        System.out.println("The given string is: " + st1);
        System.out.println("The given pattern string is: " + st2);
        
        // Convert strings to char arrays for pattern matching.
        char[] str1 = st1.toCharArray();
        char[] patstr = st2.toCharArray();

        // Create a lookup table for memoization.
        boolean[][] lookup = new boolean[str1.length + 1][patstr.length + 1];
        
        // Check if the given pattern matches the string using the chkMatching method.
        if (chkMatching(str1, patstr, str1.length - 1, patstr.length - 1, lookup)) {
            System.out.println("The given pattern is matching.");
        } else {
            System.out.println("The given pattern is not matching.");
        }
    }
}
```
Sample Output:

The given string is: abcdhgh
The given pattern string is: abc*d?*
The given pattern is matching.
### 54. Write a Java program to find the smallest window in a string containing all characters in another string.

Sample Output:

The given string is: welcome to w3resource
Characters to find in the main sring are: tower
The smallest window which contains the finding characters is : to w3re
```java
// Importing necessary Java utilities.
import java.util.*;

// Define a class named Main.
class Main {

    // Method to find the smallest window in a string containing all characters of another string.
    public static String pickSubstring(String samp_str, String pat_str) {
        // Get the lengths of the given string and the pattern string.
        int ln1 = samp_str.length();
        int ln2 = pat_str.length();
        
        // Check if the given string is smaller than the pattern string.
        if (ln1 < ln2) {
            System.out.println("No such window can exist");
            return "";
        }
        
        // Initialize arrays to store character frequencies.
        int gvn_strg[] = new int[256];
        int pat_stgr[] = new int[256];
        
        // Count frequencies of characters in the pattern string.
        for (int i = 0; i < ln2; i++)
            pat_stgr[pat_str.charAt(i)]++;
        
        // Initialize variables for counting characters, starting index, and minimum length.
        int ctr = 0, start = 0, start_index = -1, min_length = Integer.MAX_VALUE;
        
        // Iterate through the given string.
        for (int j = 0; j < ln1; j++) {
            gvn_strg[samp_str.charAt(j)]++;
            
            // Update the counter if the current character in the given string is in the pattern.
            if (pat_stgr[samp_str.charAt(j)] != 0 && gvn_strg[samp_str.charAt(j)] <= pat_stgr[samp_str.charAt(j)])
                ctr++;
            
            // When all characters in the pattern are found in the given string.
            if (ctr == ln2) {
                while (gvn_strg[samp_str.charAt(start)] > pat_stgr[samp_str.charAt(start)] || pat_stgr[samp_str.charAt(start)] == 0) {
                    if (gvn_strg[samp_str.charAt(start)] > pat_stgr[samp_str.charAt(start)] || pat_stgr[samp_str.charAt(start)] == 0)
                        gvn_strg[samp_str.charAt(start)]--;
                    start++;
                }
                
                // Calculate the length of the window.
                int length_window = j - start + 1;
                
                // Update minimum length and start index.
                if (min_length > length_window) {
                    min_length = length_window;
                    start_index = start;
                }
            }
        }
        
        // If no window exists.
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }
        
        // Return the smallest window containing all characters of the pattern string.
        return samp_str.substring(start_index, start_index + min_length);
    }

    // Main method to execute the program.
    public static void main(String args[]) {
        // Define the main string and the pattern string.
        String str = "welcome to w3resource";
        String pat = "tower";
        System.out.println("The given string is: " + str);
        System.out.println("Characters to find in the main string are: " + pat);

        // Find and display the smallest window containing all characters of the pattern in the given string.
        System.out.print("The smallest window which contains the finding characters is : " + pickSubstring(str, pat));
    }
}
```
Sample Output:

The given string is: welcome to w3resource
Characters to find in the main string are: tower
The smallest window which contains the finding characters is : to w3re
### 55. Write a Java program to remove all adjacent duplicates recursively from a given string.

Sample Output:

The given string is: aabaarbarccrabmq
The new string after removing all adjacent duplicates is:
brmq
```java
// Import necessary Java utilities and packages.
import java.util.*;
import java.lang.*;
import java.io.*;

// Define a class named Main.
class Main {
    // Method to remove all adjacent duplicates from the string.
    public static void check(String str) {
        // Check if the length of the string is less than or equal to 1.
        if (str.length() <= 1) {
            // Print the string and return if the length is 1 or less.
            System.out.println(str);
            return;
        }

        // Initialize variables.
        String n = new String();
        int count = 0;

        // Loop through the string to remove adjacent duplicates.
        for (int i = 0; i < str.length(); i++) {
            // Check for adjacent duplicates and skip them.
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                if (i < str.length() - 2 && str.charAt(i) != str.charAt(i + 2))
                    i += 2;
                else
                    i++;
                count++;
            }

            // Add non-duplicate characters to the new string.
            if (i != str.length() - 1)
                n = n + str.charAt(i);
            else {
                if (i == str.length() - 1 && str.charAt(i) != str.charAt(i - 1))
                    n = n + str.charAt(i);
            }
        }

        // Recursively check for more adjacent duplicates.
        if (count > 0)
            check(n);
        else
            // Print the final string after removing adjacent duplicates.
            System.out.println(n);
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        // Define a sample string for testing.
        String ab = "aabaarbarccrabmq";
        System.out.println("The given string is: " + ab);
        System.out.println("The new string after removing all adjacent duplicates is:");

        // Call the check method to remove adjacent duplicates.
        check(ab);
    }
}
```
Sample Output:

The given string is: aabaarbarccrabmq
The new string after removing all adjacent duplicates is:
brmq
### 56. Write a Java program that appends two strings, omitting one character if the concatenation creates double characters.

Sample Output:

The given strings are: food  and  door
The string after concatination are: foodoor
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to concatenate two strings based on specific conditions
    public String conCat(String st1, String st2) {
        // Check if both strings are not empty and the last character of the first string matches the first character of the second string
        if (st1.length() != 0 && st2.length() != 0 && st1.charAt(st1.length() - 1) == st2.charAt(0))
            return st1 + st2.substring(1); // Concatenate the strings excluding the duplicate character
        return st1 + st2; // If no match or empty strings, concatenate the strings as they are
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        // Define two strings for concatenation
        String str1 = "food";
        String str2 = "door";

        // Display the given strings and the concatenated string using the conCat method
        System.out.println("The given strings are: " + str1 + " and " + str2);
        System.out.println("The string after concatenation is: " + m.conCat(str1, str2));
    }
}
```
Sample Output:

The given strings are: food  and  door
The string after concatination are: foodoor
### 57. Write a Java program to create a string from a given string by swapping the last two characters of the given string. The string length must be two or more.

Sample Output:

The given strings is: string
The string after swap last two characters are: strign
```java
import java.util.*;

// Define a class named Main
public class Main {
    
    // Method to swap the last two characters of a string
    public String lastTwo(String str) {
        // Check if the string has less than two characters, return the string as is
        if (str.length() < 2) return str;
        
        // Swap the last two characters of the string and return the modified string
        return str.substring(0, str.length() - 2) + str.charAt(str.length() - 1) + str.charAt(str.length() - 2);
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        // Define a string for swapping the last two characters
        String str1 = "string";

        // Display the given string and the string after swapping its last two characters using the lastTwo method
        System.out.println("The given string is: " + str1);
        System.out.println("The string after swapping the last two characters is: " + m.lastTwo(str1));
    }
}
```
Sample Output:

The given strings is: string
The string after swap last two characters are: strign
### 58. Write a Java program to read a string and return true if it ends with a specified string of length 2.

Sample Output:

The given strings is: string
The string containing ng at last: true

The given strings is: strign
The string containing ng at last: false
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if the string ends with 'ng'
    public boolean endsNg(String str) {
        int len = str.length(); // Calculate the length of the input string
        String ng = "ng"; // Define the string 'ng'

        // If the length of the input string is less than 2 characters, return false
        if (len < 2)
            return false;
        // If the last two characters of the input string match 'ng', return true
        else if (ng.equals(str.substring(len - 2, len)))
            return true;
        // Otherwise, return false
        else
            return false;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        // Define a string to check if it ends with 'ng'
        String str1 = "string";

        // Display the given string and whether it contains 'ng' at the end using the endsNg method
        System.out.println("The given string is: " + str1);
        System.out.println("Does the string contain 'ng' at the end? " + m.endsNg(str1));
    }
}
```
Sample Output:

The given strings is: string
The string containing ng at last: true

The given strings is: strign
The string containing ng at last: false
### 59. Write a Java program to read a string. If the string begins with "red" or "black" return that color string, otherwise return the empty string.

Sample Output:

The given strings is: blacksea
The string begins with the color: black
```java
import java.util.*;

// Define a class named Main
public class Main {
    
    // Method to pick a color from the beginning of the string
    public String pickColor(String str) {
        // Check if the string starts with "red", return "red" if true
        if (str.startsWith("red"))
            return "red";
        // Check if the string starts with "black", return "black" if true
        if (str.startsWith("black"))
            return "black";
        else
            return ""; // Return an empty string if the string doesn't start with "red" or "black"
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        // Define a string to check for the color at the beginning
        String str1 = "blacksea";

        // Display the given string and the color it begins with using the pickColor method
        System.out.println("The given string is: " + str1);
        System.out.println("The string begins with the color: " + m.pickColor(str1));
    }
}
```
Sample Output:

The given strings is: blacksea
The string begins with the color: black
### 60. Write a Java program to read two strings append them together and return the result. If the strings are different lengths, remove characters from the beginning of the longer string and make them equal lengths.

Sample Output:

The given strings is: Welcome and home
The new string is: comehome
```java
import java.util.*;

// Define a class named Main
public class Main {
    
    // Method to concatenate two strings while ensuring the minimum length
    public String minCat(String st1, String st2) {
        // Check if the lengths of the strings are equal
        if (st1.length() == st2.length())
            return st1 + st2; // If equal, concatenate the strings directly
        
        // Check if the length of the first string is greater than the length of the second string
        if (st1.length() > st2.length()) {
            int diff = st1.length() - st2.length(); // Calculate the length difference
            return st1.substring(diff, st1.length()) + st2; // Concatenate with adjusted lengths
        } else {
            int diff = st2.length() - st1.length(); // Calculate the length difference
            return st1 + st2.substring(diff, st2.length()); // Concatenate with adjusted lengths
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "Welcome"; // First string
        String str2 = "home";    // Second string
        
        // Display the given strings and the new concatenated string using the minCat method
        System.out.println("The given strings are: " + str1 + " and " + str2);
        System.out.println("The new string is: " + m.minCat(str1, str2));
    }
}
```
Sample Output:

The given strings is: Welcome and home
The new string is: comehome
### 61. Write a Java program to create a new string taking specified number of characters from first and last position of a given string.

Sample Output:

The given strings is: Welcome
The given numbers is: 3
The new string is: Welome
```java
import java.util.*;

// Define a class named Main
public class Main {
    
    // Method to return a string formed by taking 'n' characters from the beginning and 'n' characters from the end
    public String nTwice(String str, int n) {
        return str.substring(0, n) + str.substring(str.length() - n, str.length());
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "Welcome"; // String
        int n1 = 3; // Integer 'n'
        
        // Display the given string, the given number, and the new string formed using nTwice method
        System.out.println("The given strings is: " + str1);
        System.out.println("The given numbers is: " + n1);
        System.out.println("The new string is: " + m.nTwice(str1, n1));
    }
}
```
Sample Output:

The given strings is: Welcome
The given numbers is: 3
The new string is: Welome
### 62. Write a Java program to read a string and return true if "good" appears starting at index 0 or 1 in the given string.

Sample Output:

The given strings is: goodboy
The 'good' appear in the string is: true
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if the string contains 'good' either at the beginning or after the first character
    public boolean hasGood(String str) {
        if (str.length() < 4) // If the string length is less than 4, return false
            return false;
        else if ((str.substring(0, 4)).equals("good")) // If the substring from index 0 to 4 matches "good", return true
            return true;
        else if (str.length() > 4) { // If the string length is greater than 4
            if ((str.substring(1, 5)).equals("good")) // If the substring from index 1 to 5 matches "good", return true
                return true;
        }
        return false; // Return false if none of the conditions are met
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "goodboy"; // Input string

        // Display the given string and whether 'good' appears in the string using hasGood method
        System.out.println("The given strings is: " + str1);
        System.out.println("The 'good' appears in the string: " + m.hasGood(str1));
    }
}
```
Sample Output:

The given strings is: goodboy
The 'good' appear in the string is: true
### 63. Write a Java program to check whether the first two characters appear at the end of a given string.

Sample Output:

The given strings is: educated
The first two characters appear in the last is: true
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if the first two characters of a string appear at the end of the string
    public boolean firstInLast(String str) {
        if (str.length() < 2) // If the length of the string is less than 2, return false
            return false;
        else if (str.substring(0, 2).equals(str.substring(str.length() - 2, str.length())))
            // If the substring of the first two characters is equal to the substring of the last two characters, return true
            return true;
        else
            return false; // Otherwise, return false
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "educated"; // Input string

        // Display the given string and whether the first two characters appear at the end of the string using firstInLast method
        System.out.println("The given strings is: " + str1);
        System.out.println("The first two characters appear in the last: " + m.firstInLast(str1));
    }
}
```
Sample Output:

The given strings is: educated
The first two characters appear in the last is: true
### 64. Write a Java program to read a string. If a substring of length two appears at both its beginning and end, return a string without the substring at the beginning; otherwise, return the original string unchanged.

Sample Output:

The given strings is: educated
The new string is: ucated
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to return a modified string based on certain conditions
    public String withoutMacth(String str) {
        int len = str.length(); // Get the length of the input string

        if (len == 2) // If the length of the string is 2, return an empty string
            return "";
        if (len < 2) // If the length of the string is less than 2, return the original string
            return str;
        else {
            if (str.substring(0, 2).equals(str.substring(len - 2, len)))
                // If the substring of the first two characters is equal to the substring of the last two characters,
                // return a modified string excluding the first two characters
                return str.substring(2, len);
            else
                return str; // Otherwise, return the original string
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "educated"; // Input string

        // Display the given string and the new string using withoutMacth method
        System.out.println("The given strings is: " + str1);
        System.out.println("The new string is: " + m.withoutMacth(str1));
    }
}
```
Sample Output:

The given strings is: educated
The new string is: ucated
### 65. Write a Java program to read a given string and return the string without the first or last characters if they are the same, otherwise return the string without the characters.

Sample Output:

The given strings is: testcricket
The new string is: estcricke
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to exclude 't' character from the string based on certain conditions
    public String excludeT(String stng) {
        // If the length of the input string is 0, return the input string
        if (stng.length() == 0)
            return stng;

        // If the length of the input string is 1
        if (stng.length() == 1) {
            // If the string contains 't', return an empty string; otherwise, return the string itself
            if (stng.charAt(0) == 't')
                return "";
            else
                return stng;
        }

        // If the first character of the input string is 't', remove it from the string
        if (stng.charAt(0) == 't')
            stng = stng.substring(1, stng.length());

        // If the last character of the input string is 't', remove it from the string
        if (stng.charAt(stng.length() - 1) == 't')
            stng = stng.substring(0, stng.length() - 1);

        return stng; // Return the modified string
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "testcricket"; // Input string

        // Display the given string and the new string using excludeT method
        System.out.println("The given strings is: " + str1);
        System.out.println("The new string is: " + m.excludeT(str1));
    }
}
```
Sample Output:

The given strings is: testcricket
The new string is: estcricke
### 66. Write a Java program to read a string and return it without the first two characters. Keep the first character if it is 'g' and keep the second character if it is 'h'.

Sample Output:

The given strings is: goat
The new string is: gat

he given strings is: photo
The new string is: hoto

The given strings is: ghost
The new string is: ghost
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to exclude first 'g' and second 'h' characters from the input string
    public String exceptFirstTwo(String stng) {
        // Get the length of the input string
        int len = stng.length();
        String temp = ""; // Create an empty string

        // Iterate through each character in the input string
        for (int i = 0; i < len; i++) {
            // If the current index is 0 and the character is 'g', append 'g' to the temporary string
            if (i == 0 && stng.charAt(i) == 'g')
                temp += 'g';
            // If the current index is 1 and the character is 'h', append 'h' to the temporary string
            else if (i == 1 && stng.charAt(i) == 'h')
                temp += 'h';
            // If the current index is greater than 1, append the character to the temporary string
            else if (i > 1)
                temp += stng.charAt(i);
        }
        return temp; // Return the modified string
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "ghost"; // Input string

        // Display the given string and the new string using exceptFirstTwo method
        System.out.println("The given strings is: " + str1);
        System.out.println("The new string is: " + m.exceptFirstTwo(str1));
    }
}
```
Sample Output:

The given strings is: goat
The new string is: gat

he given strings is: photo
The new string is: hoto

The given strings is: ghost
The new string is: ghost
### 67. Write a Java program to read a string and remove the first two characters if one or both are equal to a specified character, otherwise leave them unchanged.

Sample Output:

The given strings is: oocyte
The new string is: cyte

The given strings is: boat
The new string is: bat

The given strings is: own
The new string is: wn
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to exclude 'x' characters at the first two positions from the input string
    public String exceptTwoO(String stng) {
        String temp = ""; // Create an empty string

        // Iterate through each character in the input string
        for (int i = 0; i < stng.length(); i++) {
            // If the current index is 0 and the character is not 'x', append the character to the temporary string
            if (i == 0 && stng.charAt(i) != 'x')
                temp += stng.charAt(i);
            // If the current index is 1 and the character is not 'x', append the character to the temporary string
            else if (i == 1 && stng.charAt(i) != 'x')
                temp += stng.charAt(i);
            // If the current index is greater than 1, append the character to the temporary string
            else if (i > 1)
                temp += stng.charAt(i);
        }
        return temp; // Return the modified string
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "xxcyte"; // Input string

        // Display the given string and the new string using exceptTwoO method
        System.out.println("The given strings is: " + str1);
        System.out.println("The new string is: " + m.exceptTwoO(str1));
    }
}
```
Sample Output:

The given strings is: xxcyte
The new string is: cyte
### 68. Write Java program to read a string and return after removing specified characters and their immediate left and right adjacent characters.

Sample Output:

The given strings is: test#string
The new string is: testring

The given strings is: test##string
The new string is: testring

The given strings is: test#the#string
The new string is: teshtring

```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to exclude '#' character considering some conditions from the input string
    public String excludeHash(String stng) {
        int len = stng.length(); // Get the length of the input string
        String resultString = ""; // Initialize an empty string to store the result

        // Iterate through each character in the input string
        for (int i = 0; i < len; i++) {
            // If the current character is the first character and it is not '#', append it to the resultString
            if (i == 0 && stng.charAt(i) != '#')
                resultString += stng.charAt(i);

            // If the current character is not '#' and the previous character and current character both are not '#', append it to the resultString
            if (i > 0 && stng.charAt(i) != '#' && stng.charAt(i - 1) != '#')
                resultString += stng.charAt(i);

            // If the current character is '#' and the previous character is not '#', remove the last character from resultString
            if (i > 0 && stng.charAt(i) == '#' && stng.charAt(i - 1) != '#')
                resultString = resultString.substring(0, resultString.length() - 1);
        }
        return resultString; // Return the modified string
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "test#string"; // Input string

        // Display the given string and the new string using excludeHash method
        System.out.println("The given strings is: " + str1);
        System.out.println("The new string is: " + m.excludeHash(str1));
    }
}
```
Sample Output:

The given strings is: test#string
The new string is: testring

The given strings is: test##string
The new string is: testring

The given strings is: test#the#string
The new string is: teshtring

### 69. Write a Java program to return the substring that is between the first and last appearance of the substring 'toast' in the given string, or return an empty string if the substring 'toast' does not exist.

Sample Output:

The given strings is: sweettoastbuttertoast
The new string is: butter
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to extract the middle of the bread based on certain conditions
    public String pickMiddleOfBread(String stng) {
        int len = stng.length(); // Get the length of the input string
        String tmpString = ""; // Initialize a temporary string variable
        String resultString = ""; // Initialize a result string variable
        int st = 0; // Initialize starting index
        int en = 0; // Initialize ending index
        boolean found = false; // Initialize a boolean variable indicating if "toast" is found

        // If the length of the input string is less than or equal to 10, return an empty string
        if (len <= 10)
            return "";

        // Iterate through the characters of the input string
        for (int i = 0; i < len - 4; i++) {
            tmpString = stng.substring(i, i + 5); // Extract a substring of length 5 starting at index 'i'

            // Check if the substring is "toast" and 'found' flag is true, update the ending index
            if (tmpString.equals("toast") && found == true)
                en = i;

            // Check if the substring is "toast" and 'found' flag is false, update the starting index and set 'found' flag to true
            if (tmpString.equals("toast") && found == false) {
                st = i + 5;
                found = true;
            }
        }

        // Extract the middle of the bread based on the starting and ending indices
        resultString = stng.substring(st, en);

        return resultString; // Return the result
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "sweettoastbuttertoast"; // Input string

        // Display the given string and the new string using pickMiddleOfBread method
        System.out.println("The given strings is: " + str1);
        System.out.println("The new string is: " + m.pickMiddleOfBread(str1));
    }
}
```
Sample Output:

The given strings is: sweettoastbuttertoast
The new string is: butter
### 70. Write a Java program that checks if a string has pq-balance if it contains at least one 'q' directly after each ‘p’. But a 'q' before the 'p' invalidates pq-balance.

Sample Output:

The given strings is: gfpmpnppqab
The string is pq-balanced? true

The given strings is: gfpmpnpqpab
The string is pq-balanced? false
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if the string is pq-balanced
    public boolean pqBalanceString(String stng) {
        Boolean p = false; // Initialize flag for 'p'
        Boolean q = false; // Initialize flag for 'q'
        int len = stng.length(); // Get the length of the input string

        // Iterate through the characters of the input string
        for (int i = 0; i < len; i++) {

            // Check if the current character is 'p' and 'q' flag is true, set 'p' flag to true and 'q' flag to false
            if (stng.charAt(i) == 'p' && q == true) {
                p = true;
                q = false;
            } else if (stng.charAt(i) == 'p') {
                p = true;
            }

            // Check if the current character is 'q' and 'p' flag is true, set 'q' flag to true
            if (stng.charAt(i) == 'q' && p == true)
                q = true;
        }

        // If 'p' flag is false, set 'q' flag to true
        if (p == false)
            q = true;

        return q; // Return the 'q' flag indicating pq-balance
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "gfpmpnppqab"; // Input string

        // Display the given string and whether it is pq-balanced using pqBalanceString method
        System.out.println("The given strings is: " + str1);
        System.out.println("The string is pq-balanced? " + m.pqBalanceString(str1));
    }
}
```
Sample Output:

The given strings is: gfpmpnppqab
The string is pq-balanced? true

The given strings is: gfpmpnpqpab
The string is pq-balanced? false
### 71. Write a Java program to check two given strings whether any of them appears at the end of the other string (ignore case sensitivity).

Sample Output:

The given strings are: xyz  and pqrxyz
Is one string appears at the end of other? true

The given strings are: pqrxyz  and xyz
Is one string appears at the end of other? true
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if one string appears at the end of the other string
    public boolean anyStringAtEnd(String stng1, String stng2) {
        stng1 = stng1.toLowerCase(); // Convert the first string to lowercase
        int aLen = stng1.length(); // Get the length of the first string

        stng2 = stng2.toLowerCase(); // Convert the second string to lowercase
        int bLen = stng2.length(); // Get the length of the second string

        // Check if the length of the first string is less than the length of the second string
        if (aLen < bLen) {
            // Extract a substring from the end of the second string, which is the length of the first string
            String temp = stng2.substring(bLen - aLen, bLen);

            // Compare the extracted substring with the first string and return true if they match, else return false
            if (temp.compareTo(stng1) == 0)
                return true;
            else
                return false;
        } else {
            // Extract a substring from the end of the first string, which is the length of the second string
            String temp = stng1.substring(aLen - bLen, aLen);

            // Compare the extracted substring with the second string and return true if they match, else return false
            if (temp.compareTo(stng2) == 0)
                return true;
            else
                return false;
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "pqrxyz"; // First input string
        String str2 = "xyz"; // Second input string

        // Display the given strings and check if one string appears at the end of the other using anyStringAtEnd method
        System.out.println("The given strings are: " + str1 + " and " + str2);
        System.out.println("Is one string appears at the end of the other? " + m.anyStringAtEnd(str1, str2));
    }
}
```
Sample Output:

The given strings are: xyz  and pqrxyz
Is one string appears at the end of other? true

The given strings are: pqrxyz  and xyz
Is one string appears at the end of other? true
### 72. Write a Java program to return true if a given string contains the string 'pop', but the middle 'o' also may contain another character.

Sample Output:

The given string is: dikchapop
Is p?p appear in the given string? true

The given string is: dikp$pdik
Is p?p appear in the given string? true
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if "p?p" pattern appears in the given string
    public boolean popInTheString(String stng) {
        int len = stng.length(); // Get the length of the input string

        // Iterate through the string up to the third-to-last character
        for (int i = 0; i < len - 2; i++) {
            // Check if the current character is 'p' and the character two positions ahead is also 'p'
            if (stng.charAt(i) == 'p' && stng.charAt(i + 2) == 'p') {
                return true; // Return true if "p?p" pattern is found
            }
        }
        return false; // Return false if the pattern is not found in the string
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "dikchapop"; // Input string to be checked

        // Display the given string and check if "p?p" pattern appears in the string using popInTheString method
        System.out.println("The given string is: " + str1);
        System.out.println("Does 'p?p' appear in the given string? " + m.popInTheString(str1));
    }
}
```
Sample Output:

The given string is: dikchapop
Is p?p appear in the given string? true

The given string is: dikp$pdik
Is p?p appear in the given string? true
### 73. Write a Java program to check whether a substring appears before a period(.) within a given string.

Sample Output:

The given strings is: testabc.test
Is 'abc' appear before period? true

The given string is: test.abctest
Is 'abc' appear before period? false
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if 'abc' appears before a period in the given string
    public Boolean abcBeforePeriod(String stng) {
        int len = stng.length(); // Get the length of the input string
        String abc = "abc"; // Create a string variable 'abc' to match against
        Boolean match = false; // Initialize a boolean variable 'match' to false

        if (len < 3)
            return false; // If the length of the string is less than 3, return false as 'abc' cannot appear

        for (int i = 0; i < len - 2; i++) {
            // Extract a substring of length 3 starting from the current index 'i'
            String temp = stng.substring(i, i + 3);

            // Check if the extracted substring matches 'abc' and it's at the beginning of the string
            if (temp.compareTo(abc) == 0 && i == 0)
                match = true;
            // Check if the extracted substring matches 'abc' and the character before it is not a period ('.')
            else if (temp.compareTo(abc) == 0 && stng.charAt(i - 1) != 46)
                match = true;
        }
        return match; // Return the boolean variable indicating if 'abc' appeared before a period
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "testabc.test"; // Input string to be checked

        // Display the given string and check if 'abc' appears before a period using abcBeforePeriod method
        System.out.println("The given string is: " + str1);
        System.out.println("Does 'abc' appear before a period? " + m.abcBeforePeriod(str1));
    }
}
```
Sample Output:

The given strings is: testabc.test
Is 'abc' appear before period? true

The given string is: test.abctest
Is 'abc' appear before period? false
### 74. Write a Java program to check whether a prefix string created using the first specific character in a given string appears somewhere else in the string.

Sample Output:

The given strings is: MrsJemsmrsam
The prefix string length is: 3
Is 'Mrs' appear else where in the string? false

The given string is: MrsJemsMrsam
The prefix string length is: 3
Is 'Mrs' appear else where in the string? true
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if a substring of length 'n_chr' appears elsewhere in the string
    public boolean nChrStringSomewhere(String stng, int n_chr) {
        int len = stng.length(); // Get the length of the input string

        // Extract the prefix substring of length 'n_chr' from the input string
        String pre_str = stng.substring(0, n_chr);

        for (int i = n_chr; i < len; i++) {
            // Check if 'n_chr' characters can be extracted starting from the current index 'i'
            if (n_chr + i <= len) {
                // Extract a substring of length 'n_chr' starting from index 'i'
                if (pre_str.equals(stng.substring(i, n_chr + i))) // Compare the extracted substring with the prefix
                    return true; // If a match is found, return true
            }
        }
        return false; // If no match is found, return false
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "MrsJemsMrsam"; // Input string to be checked
        int n = 3; // Define the length of the prefix to be checked
        String prechr = str1.substring(0, n); // Extract the prefix of length 'n' from the input string

        // Display the given string, prefix string length, and check if the prefix appears elsewhere in the string
        System.out.println("The given string is: " + str1);
        System.out.println("The prefix string length is: " + n);
        System.out.println("Does '" + prechr + "' appear elsewhere in the string? " + m.nChrStringSomewhere(str1, n));
    }
}
```
Sample Output:

The given strings is: MrsJemsmrsam
The prefix string length is: 3
Is 'Mrs' appear else where in the string? false

The given string is: MrsJemsMrsam
The prefix string length is: 3
Is 'Mrs' appear else where in the string? true
### 75. Write a Java program to check whether a given substring appears in the middle of another string. Here middle means the difference between the number of characters to the left and right of the given substring is not more than 1.

Sample Output:

The given string is: xxxabcxxxxx
Is abc appear in middle? false

The given string is: xxabcxxx
Is abc appear in middle? true
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to check if "abc" appears in the middle of the string
    public boolean abcInMiddle(String stng) {
        String abc = "abc"; // Define the substring to be checked
        int l = stng.length(); // Get the length of the input string
        int mid_pos = l / 2; // Calculate the middle position of the string

        if (l < 3)
            return false; // If the length is less than 3, "abc" cannot appear in the middle

        if (l % 2 != 0) { // If the length is odd
            if (abc.equals(stng.substring(mid_pos - 1, mid_pos + 2))) {
                return true; // If the substring from mid-1 to mid+1 matches "abc", return true
            } else {
                return false; // If not, return false
            }
        } else if (abc.equals(stng.substring(mid_pos - 1, mid_pos + 2)) || abc.equals(stng.substring(mid_pos - 2, mid_pos + 1))) {
            return true; // If the substring from mid-1 to mid+1 or mid-2 to mid matches "abc", return true
        } else {
            return false; // If not, return false
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "xxabcxxx"; // Input string to be checked
        System.out.println("The given string is: " + str1);
        System.out.println("Does 'abc' appear in the middle? " + m.abcInMiddle(str1)); // Display the result
    }
}
```
Sample Output:

The given string is: xxxabcxxxxx
Is abc appear in middle? false

The given string is: xxabcxxx
Is abc appear in middle? true
### 76. Write a Java program to count how many times the substring 'life' appears anywhere in a given string. Counting can also happen with the substring 'li?e', any character instead of 'f'.

Sample Output:

The given string is: liveonwildlife
The substring life or li?e appear number of times: 2
```java
import java.util.*;

// Define a class named Main
public class Main {

    // Method to count the number of times the substring "life" or "li?e" appears
    public int substringCounting(String stng) {
        int l = stng.length(); // Get the length of the input string
        int ctr = 0; // Initialize a counter variable to count occurrences
        String firsttwo = "li"; // Define the substring "li"
        String lastone = "e"; // Define the substring "e"

        if (l < 4)
            return 0; // If the length of the string is less than 4, return 0

        for (int i = 0; i < l - 3; i++) {
            // Check if the substring from i to i+2 matches "li" and i+3 matches "e"
            if (firsttwo.compareTo(stng.substring(i, i + 2)) == 0 && lastone.compareTo(stng.substring(i + 3, i + 4)) == 0)
                ctr++; // Increment the counter if the condition is satisfied
        }
        return ctr; // Return the total count of occurrences
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Main m = new Main(); // Create an instance of the Main class

        String str1 = "liveonwildlife"; // Input string to be checked
        System.out.println("The given string is: " + str1);
        System.out.println("The substring 'life' or 'li?e' appears number of times: " + m.substringCounting(str1)); // Display the result
    }
}
```
Sample Output:

The given string is: liveonwildlife
The substring life or li?e appear number of times: 2
### 77. Write a Java program to add a string with a specific number of times separated by a substring.

Sample Output:

The given strings are: try  and  best
Number to times to be repeat: 3
The new string is: trybesttrybesttry
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to concatenate strings with a separator 'ctr' times
  public String addBySeparator(String main_str, String sep_str, int ctr) {
    String new_word = ""; // Initialize an empty string to store the resulting word

    // Loop 'ctr' times to concatenate 'main_str' and 'sep_str' (except for the last iteration)
    for (int i = 0; i < ctr; i++) {
      if (i < ctr - 1)
        new_word += main_str + sep_str; // Concatenate 'main_str' and 'sep_str' if it's not the last iteration
      else
        new_word += main_str; // Concatenate 'main_str' only in the last iteration
    }
    return new_word; // Return the concatenated string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "try"; // First string
    String str2 = "best"; // Second string
    int ctr = 3; // Number of times to repeat the concatenation

    // Display the given strings and the number of times to repeat
    System.out.println("The given strings are: " + str1 + " and " + str2);
    System.out.println("Number of times to be repeated: " + ctr);

    // Display the resulting string after concatenation with a separator
    System.out.println("The new string is: " + m.addBySeparator(str1, str2, ctr));
  }
}
```
Sample Output:

The given strings are: try  and  best
Number to times to be repeat: 3
The new string is: trybesttrybesttry
### 78. Write a Java program to repeat a specific number of characters for a specific number of times from the last part of a given string.

Sample Output:

The given string is: string
The new string after repetition: inginging
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to repeat the last 'no_repeat' characters of a string 'stng' 'no_repeat' times
  public String lastNchrRepeat(String stng, int no_repeat) {
    int l = stng.length(); // Get the length of the given string 'stng'
    String new_word = ""; // Initialize an empty string to store the resulting word

    // Loop 'no_repeat' times to concatenate the last 'no_repeat' characters of 'stng' 'no_repeat' times
    for (int i = 0; i < no_repeat; i++) {
      new_word += stng.substring(l - no_repeat, l); // Extract the last 'no_repeat' characters of 'stng' and concatenate them to 'new_word'
    }
    return new_word; // Return the concatenated string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "string"; // Given string
    int no_char = 3; // Number of times to repeat the last characters

    // Display the given string and the number of times to repeat
    System.out.println("The given string is: " + str1);
    System.out.println("The new string after repetition: " + m.lastNchrRepeat(str1, no_char));
  }
}
```
Sample Output:

The given string is: string
The new string after repetition: inginging
### 79. Write a Java program to create a string from a given string. This is done after removing the 2nd character from the substring of length three starting with 'z' and ending with 'g' presents in the said string.

Sample Output:

The given string is: zzgkitandkatcaketoket
The new string is: zgkitandkatcaketoket
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to create a new string following the Kit-Kat pattern
  public String kitKatPattern(String stng) {
    int len = stng.length(); // Get the length of the given string 'stng'
    String newformstring = ""; // Initialize an empty string to store the new formed string

    // Loop through each character in the given string 'stng'
    for (int i = 0; i < len; i++) {
      newformstring += stng.substring(i, i + 1); // Add each character to the new formed string 'newformstring'

      // Check if the current character is neither the first nor the last character of the string
      if (i > 0 && i < len - 1) {
        // Check if the previous character is 'z' and the next character is 'g'
        if (stng.charAt(i - 1) == 'z' && stng.charAt(i + 1) == 'g') {
          newformstring = newformstring.substring(0, newformstring.length() - 1); // Remove the last character added to 'newformstring'
        }
      }
    }
    return newformstring; // Return the new formed string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "zzgkitandkatcaketoket"; // Given string

    // Display the given string and the new string formed following the Kit-Kat pattern
    System.out.println("The given string is: " + str1);
    System.out.println("The new string is: " + m.kitKatPattern(str1));
  }
}
```
Sample Output:

The given string is: zzgkitandkatcaketoket
The new string is: zgkitandkatcaketoket
### 80. Write a Java program to check whether the character immediately before and after a specified character is the same in a given string.

Sample Output:

The given string is: moon#night
The before and after character are same: true

The given string is: bat##ball
The before and after character are same: false

The given string is: #moon#night
The before and after character are same: true
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to check if characters before and after '#' are the same
  public boolean leftAndRightSame(String stng) {
    int l = stng.length(); // Get the length of the given string 'stng'
    boolean found = true; // Initialize a boolean variable 'found' as true

    // Loop through each character in the given string 'stng'
    for (int i = 0; i < l; i++) {
      String tmpString = stng.substring(i, i + 1); // Extract each character of 'stng' individually

      // Check if the character is '#', and it's not the first or last character
      if (tmpString.equals("#") && i > 0 && i < l - 1) {
        // Check if the character before '#' is equal to the character after '#'
        if (stng.charAt(i - 1) == stng.charAt(i + 1)) {
          found = true; // Set 'found' to true if characters before and after '#' are the same
        } else {
          found = false; // Set 'found' to false if characters before and after '#' are different
        }
      }
    }
    return found; // Return the result whether characters before and after '#' are the same or not
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "moon#night"; // Given string

    // Display the given string and the result of checking characters before and after '#'
    System.out.println("The given string is: " + str1);
    System.out.println("The before and after character are same: " + m.leftAndRightSame(str1));
  }
}
```
Sample Output:

The given string is: moon#night
The before and after character are same: true

The given string is: bat##ball
The before and after character are same: false

The given string is: #moon#night
The before and after character are same: true
### 81. Write a Java program to check whether two strings of length 3 and 4 appear the same number of times in a given string.

Sample Output:

The given string is: redcapmanwithbluecar
The appearance of red and blue are same: true
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to check the equal appearance of "red" and "blue" substrings in the given string 'stng'
  public boolean checkSameAppearance(String stng) {
    int l = stng.length(); // Get the length of the given string 'stng'
    int red = 0; // Initialize a counter for "red" substring occurrences
    int blue = 0; // Initialize a counter for "blue" substring occurrences

    // Loop to check for "red" substring occurrences
    for (int i = 0; i < l - 2; i++) {
      String tmp = stng.substring(i, i + 3); // Extract a substring of length 3 starting at index 'i'

      // Check if the extracted substring is equal to "red"
      if (tmp.compareTo("red") == 0)
        red++; // Increment the count of "red" substring occurrences
    }

    // Loop to check for "blue" substring occurrences
    for (int i = 0; i < l - 3; i++) {
      String tmp = stng.substring(i, i + 4); // Extract a substring of length 4 starting at index 'i'

      // Check if the extracted substring is equal to "blue"
      if (tmp.compareTo("blue") == 0)
        blue++; // Increment the count of "blue" substring occurrences
    }

    // Check if the count of "red" and "blue" substrings are the same
    if (red == blue)
      return true; // Return true if the counts are equal
    else
      return false; // Return false if the counts are not equal
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "redcapmanwithbluecar"; // Given string

    // Display the given string and the result of equal appearance of "red" and "blue" substrings
    System.out.println("The given string is: " + str1);
    System.out.println("The appearance of red and blue are same: " + m.checkSameAppearance(str1));
  }
}
```
Sample Output:

The given string is: redcapmanwithbluecar
The appearance of red and blue are same: true
### 82. Write a Java program to create a string containing every character twice of a given string.

Sample Output:

The given string is: welcome
The new string is: wweellccoommee
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to repeat each character in the given string 'stng' twice
  public String repeatAllTwice(String stng) {
    int l = stng.length(); // Get the length of the given string 'stng'
    String newstring = ""; // Initialize an empty string to store the new string

    // Loop through each character of the string
    for (int i = 0; i < l; i++) {
      // Append the character at index 'i' in 'stng' twice to the 'newstring'
      newstring += stng.substring(i, i + 1) + stng.substring(i, i + 1);
    }
    return newstring; // Return the new string with characters repeated twice
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "welcome"; // Given string

    // Display the given string and the new string with characters repeated twice
    System.out.println("The given string is: " + str1);
    System.out.println("The new string is: " + m.repeatAllTwice(str1));
  }
}
```
Sample Output:

The given string is: welcome
The new string is: wweellccoommee
### 83. Write a Java program to create a string from two given strings. This is so that each character of the two strings appears individually in the created string.

Sample Output:

The given strings  are: welcome  and  w3resource
The new string is: wwe3lrceosmoeurce
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to mix two strings 'stng1' and 'stng2' character-wise
  public String stringMixing(String stng1, String stng2) {
    int len1 = stng1.length(); // Get the length of the first string 'stng1'
    int len2 = stng2.length(); // Get the length of the second string 'stng2'
    int max_len = Math.max(len1, len2); // Find the maximum length between two strings
    String newstring = ""; // Initialize an empty string to store the mixed string

    // Loop through up to the maximum length of the two strings
    for (int i = 0; i < max_len; i++) {
      // Append the character at index 'i' in 'stng1' if it exists
      if (i <= len1 - 1)
        newstring += stng1.substring(i, i + 1);
      // Append the character at index 'i' in 'stng2' if it exists
      if (i <= len2 - 1)
        newstring += stng2.substring(i, i + 1);
    }
    return newstring; // Return the mixed string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "welcome"; // First string
    String str2 = "w3resource"; // Second string

    // Display the given strings and the new mixed string
    System.out.println("The given strings are: " + str1 + " and " + str2);
    System.out.println("The new string is: " + m.stringMixing(str1, str2));
  }
}
```
Sample Output:

The given strings  are: welcome  and  w3resource
The new string is: wwe3lrceosmoeurce
### 84. Write a Java program to make an original string made of p number of characters from the first character in a given string. This is followed by p-1 number of characters till p is greater than zero.

Sample Output:

The given string is: welcome
Number of repetition characters and repetition: 4
The new string is: welcwelwew
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to repeat the beginning characters of a string 'stng' 'n' times
  public String beginningRepetition(String stng, int n) {
    int l = stng.length(); // Get the length of the input string 'stng'
    String newstring = ""; // Initialize an empty string to store the new string
    
    // Loop 'n' times to repeat the beginning characters
    for (int i = n; n > 0; n--) {
      newstring += stng.substring(0, n); // Append the substring from index 0 to 'n' of 'stng' to 'newstring'
    }
    return newstring; // Return the new string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "welcome"; // Input string
    int rep_no = 4; // Number of repetitions

    // Display the given string, the number of repetitions, and the new string after repetition
    System.out.println("The given string is: " + str1);
    System.out.println("Number of repetition characters and repetition: " + rep_no);
    System.out.println("The new string is: " + m.beginningRepetition(str1, rep_no));
  }
}
```
Sample Output:

The given string is: welcome
Number of repetition characters and repetition: 4
The new string is: welcwelwew
### 85. Write a Java program to make up a string with each character before and after a non-empty substring whichever it appears in a non-empty given string.

Sample Output:

The given string are: weablcoabmeab  and ab
The new string is: elome
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to find the 'm_stng' occurrences around the 't_stng' string
  public String mAndTstring(String m_stng, String t_stng) {
    int m_st_len = m_stng.length(); // Get the length of the 'm_stng'
    int t_st_len = t_stng.length(); // Get the length of the 't_stng'
    String fin = ""; // Initialize an empty string to store the result

    // Loop through 'm_stng' to find occurrences of 't_stng'
    for (int i = 0; i < m_st_len - t_st_len + 1; i++) {
      String tmp = m_stng.substring(i, i + t_st_len); // Get a substring of 'm_stng' from 'i' to 'i+t_st_len'

      // Check if 'tmp' substring equals 't_stng'
      if (i > 0 && tmp.equals(t_stng)) {
        fin += m_stng.substring(i - 1, i); // Append the character before the 't_stng' occurrence
      }

      // Check if 'tmp' substring equals 't_stng' and not at the end of 'm_stng'
      if (i < m_st_len - t_st_len && tmp.equals(t_stng)) {
        fin += m_stng.substring(i + t_st_len, i + t_st_len + 1); // Append the character after the 't_stng' occurrence
      }
    }
    return fin; // Return the resulting string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "weablcoabmeab"; // Input string
    String str2 = "ab"; // String to find occurrences

    // Display the given strings and the new string after processing
    System.out.println("The given string are: " + str1 + "  and " + str2);
    System.out.println("The new string is: " + m.mAndTstring(str1, str2));
  }
}
```
Sample Output:

The given string are: weablcoabmeab  and ab
The new string is: elome
### 86. Write a Java program to count the number of triples (characters appearing three times in a row) in a given string.

Sample Output:

The given string is: welllcommmmeee
The number of triples in the string is: 4
```java
// Define a class named Main
public class Main {
  
  // Method to count the number of triples in the given string
  public int noOfTriples(String stng) {
    int l = stng.length(); // Get the length of the given string
    int ctr = 0; // Initialize a counter for triples
  
    // Loop through the string to check for triples
    for (int i = 0; i < l - 2; i++) {
      char tmp = stng.charAt(i); // Get the character at index 'i'

      // Check if the character at index 'i' is the same as the next two characters
      if (tmp == stng.charAt(i + 1) && tmp == stng.charAt(i + 2)) {
        ctr++; // Increment the counter if a triple is found
      }
    }
    return ctr; // Return the total count of triples
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "welllcommmmeee"; // Given input string

    // Display the given string and the number of triples in it
    System.out.println("The given string is: " + str1);
    System.out.println("The number of triples in the string is: " + m.noOfTriples(str1));
  }
}
```
Sample Output:

The given string is: welllcommmmeee
The number of triples in the string is: 4
### 87. Write a Java program to check whether a specified character is happy or not. A character is happy when the same character appears to its left or right in a string.

Sample Output:

The given string is: azzlea
Is z happy in the string: true

The given string is: azmzlea
Is z happy in the string: falses
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to check if 'z' is happy in the given string
  public boolean aCharacterIsHappy(String stng) {
    int l = stng.length(); // Get the length of the given string
    boolean char_happy = true; // Initialize a boolean variable to check 'z' happiness
    
    // Loop through the string to check each character
    for (int i = 0; i < l; i++) {
      if (stng.charAt(i) == 'z') { // Check if the current character is 'z'
        if (i > 0 && stng.charAt(i - 1) == 'z') {
          char_happy = true; // If the previous character is 'z', set 'z' as happy
        } else if (i < l - 1 && stng.charAt(i + 1) == 'z') {
          char_happy = true; // If the next character is 'z', set 'z' as happy
        } else {
          char_happy = false; // If 'z' does not have a neighboring 'z', set 'z' as not happy
        }
      }
    }
    return char_happy; // Return whether 'z' is happy or not
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "azzlea"; // Given input string

    // Display the given string and whether 'z' is happy in it
    System.out.println("The given string is: " + str1);
    System.out.println("Is Z happy in the string: " + m.aCharacterIsHappy(str1));
  }
}
```
Sample Output:

The given string is: azzlea
Is z happy in the string: true

The given string is: azmzlea
Is z happy in the string: falses
### 88. Write a Java program to return a string where every appearance of the lowercase word 'is' has been replaced with 'is not'.

Sample Output:

The given string is: it is a string
The new string is: it is not a string
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to replace 'is' with 'is not' in specific conditions
  public String wordReplaceBy(String stng) {
    String newstring = ""; // Initialize an empty string to store the modified string
    int l = stng.length(); // Get the length of the given string
    
    // Loop through the string to perform the word replacement
    for(int i = 0; i < l; i++) {
      // Check conditions to replace 'is' with 'is not'
      if(i - 1 >= 0 && Character.isLetter(stng.charAt(i - 1)) || i + 2 < l && Character.isLetter(stng.charAt(i + 2))) {
        newstring += stng.charAt(i); // Append the character if conditions don't meet for 'is'
      } else if(i + 1 < l && stng.substring(i, i + 2).equals("is")) {
        newstring += "is not"; // Replace 'is' with 'is not'
        i++; // Increment the index to skip the next character
      } else {
        newstring += stng.charAt(i); // Append the character if it doesn't match 'is'
      }
    }
    return newstring; // Return the modified string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "it is a string"; // Given input string

    // Display the given string and the modified string after word replacement
    System.out.println("The given string is: " + str1);
    System.out.println("The new string is: " + m.wordReplaceBy(str1));
  }
}
```
Sample Output:

The given string is: it is a string
The new string is: it is not a string
### 89. Write a Java program to calculate the sum of the numbers that appear in a given string.

Sample Output:

The given string is: it 15 is25 a 20string
The sum of numbers in the string is: 60
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to calculate the sum of numbers present in a string
  public int sumOfTheNumbers(String stng) {
    int l = stng.length(); // Get the length of the given string
    int sum = 0; // Initialize a variable to store the sum
    String temp = ""; // Initialize an empty string to store temporary numeric values

    // Loop through the string to find and sum the numbers
    for (int i = 0; i < l; i++) {
      // Check if the character is a digit
      if (Character.isDigit(stng.charAt(i))) {
        // If the next character is also a digit, add the current digit to the temporary string
        if (i < l - 1 && Character.isDigit(stng.charAt(i + 1))) {
          temp += stng.charAt(i);
        } else {
          // If the next character is not a digit or it's the end of the string, add the last digit to the temporary string
          temp += stng.charAt(i);
          // Convert the temporary string to an integer and add it to the sum
          sum += Integer.parseInt(temp);
          temp = ""; // Reset the temporary string for the next number
        }
      }
    }
    return sum; // Return the total sum of the numbers found in the string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "it 15 is25 a 20string"; // Given input string

    // Display the given string and the sum of the numbers present in it
    System.out.println("The given string is: " + str1);
    System.out.println("The sum of numbers in the string is: " + m.sumOfTheNumbers(str1));
  }
}
```
Sample Output:

The given string is: it 15 is25 a 20string
The sum of numbers in the string is: 60
### 90. Write a Java program to check the number of times the two substrings appearing anywhere in a string.

Sample Output:

The given string is: Thisisthethesis
Are the appearance of 'the' and 'is' equal? false
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to check the equality of appearances of "the" and "is" in the string
  public boolean isAndTheEquality(String stng) {
    int l = stng.length(); // Get the length of the given string
    int st_the = 0; // Initialize a counter for occurrences of "the"
    int st_is = 0; // Initialize a counter for occurrences of "is"

    // Loop through the string to find occurrences of "the" and "is"
    for (int i = 0; i < l; i++) {
      // Check for occurrences of "the" (a three-character substring)
      if (i < l - 2) {
        String tmp = stng.substring(i, i + 3);
        if (tmp.equals("the"))
          st_the++;
      }
      // Check for occurrences of "is" (a two-character substring)
      if (i < l - 1) {
        String tmp2 = stng.substring(i, i + 2);
        if (tmp2.equals("is"))
          st_is++;
      }
    }

    // Check if the counts of "the" and "is" occurrences are equal
    if (st_the == st_is)
      return true;
    else
      return false;
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "Thisisthethesis"; // Given input string

    // Display the given string and whether the appearances of "the" and "is" are equal
    System.out.println("The given string is: " + str1);
    System.out.println("Are the appearances of 'the' and 'is' equal? " + m.isAndTheEquality(str1));
  }
}
```
Sample Output:

The given string is: Thisisthethesis
Are the appearance of 'the' and 'is' equal? false
### 91. Write a Java program to count the number of words ending in 'm' or 'n' (not case sensitive) in a given text.

Sample Output:

The given string is: mam is in the room
The number of words ends eith m or n is: 3
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to count the number of words that end with 'm' or 'n'
  public int endWithmOrn(String stng) {
    int l = stng.length(); // Get the length of the given string
    int ctr = 0; // Initialize a counter for words ending with 'm' or 'n'

    stng = stng.toLowerCase(); // Convert the string to lowercase for uniformity

    // Loop through the string to find words ending with 'm' or 'n'
    for (int i = 0; i < l; i++) {
      // Check if the character is 'm' or 'n'
      if (stng.charAt(i) == 'm' || stng.charAt(i) == 'n') {
        // Check if it is at the end of the string or followed by a non-letter character
        if (i < l - 1 && !Character.isLetter(stng.charAt(i + 1)))
          ctr++;
        else if (i == l - 1)
          ctr++;
      }
    }
    return ctr; // Return the count of words ending with 'm' or 'n'
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "mam is in the room"; // Given input string

    // Display the given string and the number of words ending with 'm' or 'n'
    System.out.println("The given string is: " + str1);
    System.out.println("The number of words that end with 'm' or 'n' is: " + m.endWithmOrn(str1));
  }
}
```
Sample Output:

The given string is: mam is in the room
The number of words ends eith m or n is: 3
### 92. Write a Java program that returns a substring after removing all instances of remove string as given from the given main string.

Sample Output:

The main string is: This is the test string
The removable string is: st
The new string is: This is the te ring
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to remove occurrences of a string from another string
  public String removeString(String m_string, String r_string) {
    int m_st_len = m_string.length(); // Get the length of the main string
    int r_st_len = r_string.length(); // Get the length of the removable string
    String m_lower = m_string.toLowerCase(); // Convert the main string to lowercase
    String r_lower = r_string.toLowerCase(); // Convert the removable string to lowercase
    String f_string = ""; // Initialize a new string to store the modified string

    // Loop through the main string
    for (int i = 0; i < m_st_len; i++) {
      // Check if there are enough characters left in the main string to match the removable string
      if (i <= m_st_len - r_st_len) {
        String tmp = m_lower.substring(i, i + r_st_len); // Extract a substring for comparison
        if (!tmp.equals(r_lower))
          f_string += m_string.substring(i, i + 1); // Append the character to the new string
        else {
          i += r_st_len - 1; // Skip the removable string in the main string
        }
      } else {
        String tmp2 = m_lower.substring(i, i + 1); // Extract a single character for comparison
        if (!tmp2.equals(r_lower))
          f_string += m_string.substring(i, i + 1); // Append the character to the new string
      }
    }
    return f_string; // Return the modified string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "This is the test string"; // Given main string
    String str2 = "st"; // Given removable string

    // Display the main string, the removable string, and the modified string after removal
    System.out.println("The main string is: " + str1);
    System.out.println("The removable string is: " + str2);
    System.out.println("The new string is: " + m.removeString(str1, str2));
  }
}
```
Sample Output:

The main string is: This is the test string
The removable string is: st
The new string is: This is the te ring
### 93. Write a Java program to find the longest substring that appears at both ends of a given string.

Sample Output:

The given string is: playersplay
The longest substring in the string is: play
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to find the longest substring that appears at both ends of the given string
  public String appearInBothEnds(String stng) {
    int l = stng.length(); // Get the length of the given string
    String f_str = ""; // Initialize a string to store the found substring
    String tmp = ""; // Initialize a temporary string

    // Loop through the characters of the given string
    for (int i = 0; i < l; i++) {
      tmp += stng.charAt(i); // Add the current character to the temporary string
      int t_len = tmp.length(); // Get the length of the temporary string

      // Check if the temporary string is present both at the beginning and end of the main string
      if (i < l / 2 && tmp.equals(stng.substring(l - t_len, l))) {
        f_str = tmp; // Update the found substring if a match is found
      }
    }
    return f_str; // Return the longest substring appearing at both ends of the string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "playersplay"; // Given string
    // Display the given string and the longest substring appearing at both ends
    System.out.println("The given string is: " + str1);
    System.out.println("The longest substring in the string is: " + m.appearInBothEnds(str1));
  }
}
```
Sample Output:

The given string is: playersplay
The longest substring in the string is: play
### 94. Write a Java program to find the longest mirror image string at both ends of a given string.

Sample Output:

The given string is: rotavator
The longest mirror image string in the string is: rotavator
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to find the longest mirror image string in the given string
  public String endsWithMirrorImage(String stng) {
    int l = stng.length(); // Get the length of the given string
    String f_str = ""; // Initialize a string to store the longest mirror image string
    String t_str1 = ""; // Initialize temporary string 1
    String t_str2 = ""; // Initialize temporary string 2

    // Loop through the characters of the given string
    for (int i = 0; i < l; i++) {
      t_str1 += stng.substring(i, i + 1); // Add characters to temporary string 1
      t_str2 = ""; // Reset temporary string 2

      // Loop through the characters of temporary string 1 in reverse order
      for (int j = t_str1.length() - 1; j >= 0; j--) {
        t_str2 += t_str1.substring(j, j + 1); // Build temporary string 2 in reverse order

        // Check if temporary string 2 equals the mirror image at the end of the main string
        if (t_str2.equals(stng.substring(l - i - 1, l))) {
          f_str = t_str1; // Update the found string if a match is found
        }
      }
    }
    return f_str; // Return the longest mirror image string found
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "rotavator"; // Given string
    // Display the given string and the longest mirror image string
    System.out.println("The given string is: " + str1);
    System.out.println("The longest mirror image string in the string is: " + m.endsWithMirrorImage(str1));
  }
}
```
Sample Output:

The given string is: rotavator
The longest mirror image string in the string is: rotavator
### 95. Write a Java program to return the sum of the digits present in the given string. In the absence of digits, the sum is 0.

Sample Output:

The given string is: ab5c2d4ef12s
The sum of the digits in the string is: 14
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to calculate the sum of digits in the given string
  public int sumOfDigits(String stng) {
    int l = stng.length(); // Get the length of the given string
    int sum = 0; // Initialize the sum of digits

    // Loop through each character of the string
    for (int i = 0; i < l; i++) {
      // Check if the character at the current index is a digit
      if (Character.isDigit(stng.charAt(i))) {
        String tmp = stng.substring(i, i + 1); // Get the digit as a substring
        sum += Integer.parseInt(tmp); // Convert the digit to integer and add it to the sum
      }
    }
    return sum; // Return the total sum of digits in the string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "ab5c2d4ef12s"; // Given string
    // Display the given string and the sum of its digits
    System.out.println("The given string is: " + str1);
    System.out.println("The sum of the digits in the string is: " + m.sumOfDigits(str1));
  }
}
```
Sample Output:

The given string is: ab5c2d4ef12s
The sum of the digits in the string is: 14
### 96. Write a Java program to create a new string after removing a specified character from a given string. This is except the first and last position.

Sample Output:

The given string is: zebrazone
The new string is: zebraone
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to remove all occurrences of 'z' from the string
  public String removeAllZ(String stng) {
    String fin_str = ""; // Initialize an empty string to store the modified string
    int l = stng.length(); // Get the length of the given string

    // Loop through each character of the string
    for (int i = 0; i < l; i++) {
      char temp = stng.charAt(i); // Get the character at the current index

      // Check if the character is not 'z' or if it's the first or last character in the string
      if (!(i > 0 && i < l - 1 && temp == 'z')) {
        fin_str = fin_str + temp; // Append the character to the final string
      }
    }
    return fin_str; // Return the modified string with 'z' removed
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "zebrazone"; // Given string
    // Display the given string and the new string after removing 'z'
    System.out.println("The given string is: " + str1);
    System.out.println("The new string is: " + m.removeAllZ(str1));
  }
}
```
Sample Output:

The given string is: zebrazone
The new string is: zebraone
### 97. Write a Java program to return a string with characters at index positions 0,1,2,5,6,7, ... from a given string.

Sample Output:

The given string is: w3resource.com
The new string is: w3rour.co
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to extract pairs of characters from the string
  public String pairsToReturn(String stng) {
    String fin_str = ""; // Initialize an empty string to store the modified string
    
    // Loop through the string with a step size of 5
    for (int i = 0; i < stng.length(); i += 5) {
      int end = i + 3; // Set the end index for extracting pairs
      
      // Check if the calculated end index is greater than the string's length
      if (end > stng.length()) {
        end = stng.length(); // If yes, update the end index to the string's length
      }
      
      // Extract a pair of characters from the string and append it to the final string
      fin_str = fin_str + stng.substring(i, end);
    }
    return fin_str; // Return the modified string
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "w3resource.com"; // Given string
    // Display the given string and the new string after extracting pairs
    System.out.println("The given string is: " + str1);
    System.out.println("The new string is: " + m.pairsToReturn(str1));
  }
}
```
Sample Output:

The given string is: w3resource.com
The new string is: w3rour.co
### 98. Write a Java program to check whether the first instance of a given character is immediately followed by the same character in a given string.

Sample Output:

The given string is: fizzez
Is 'z' appear twice respectively? true
```java
import java.util.*;

// Define a class named Main
public class Main {
  
  // Method to check if 'z' appears twice in succession in the string
  boolean appearTwice(String stng) {
    int i = stng.indexOf("z"); // Get the index of the first occurrence of 'z'
    if (i == -1) return false; // If 'z' is not found, return false
    
    if (i + 1 >= stng.length()) return false; // If 'z' is at the end of the string, return false
    
    // Check if the character after the first 'z' is also 'z'
    return stng.substring(i + 1, i + 2).equals("z");
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "fizzez"; // Given string
    // Display the given string and whether 'z' appears twice respectively
    System.out.println("The given string is: " + str1);
    System.out.println("Is 'z' appear twice respectively? " + m.appearTwice(str1));
  }
}
```
Sample Output:

The given string is: fizzez
Is 'z' appear twice respectively? true
### 99. Write a Java program to return an updated string using every character of even position from a given string.

Sample Output:

The given string is: w3resource.com
The new string is: wrsuc.o
```java
import java.util.*;

// Define a class named Main
public class Main {

  // Method to create a new string using even-indexed characters from the given string
  public String makeWithEvenCharacters(String stng) {
    int len = stng.length(); // Get the length of the given string
    String fin_str = ""; // Initialize an empty string to store the result

    // Loop through the string, incrementing by 2 to get even-indexed characters
    for (int i = 0; i < len; i = i + 2) {
      fin_str += stng.charAt(i); // Concatenate even-indexed characters to the result string
    }

    return fin_str; // Return the final string containing even-indexed characters
  }

  // Main method to execute the program
  public static void main(String[] args) {
    Main m = new Main(); // Create an instance of the Main class

    String str1 = "w3resource.com"; // Given string
    // Display the given string and the new string with even-indexed characters
    System.out.println("The given string is: " + str1);
    System.out.println("The new string is: " + m.makeWithEvenCharacters(str1));
  }
}
```
Sample Output:

The given string is: w3resource.com
The new string is: wrsuc.o
### 100. Write a Java program to check if a given string contains another string. Returns true or false.

Sample Output:

Original string:
Java is the foundation for virtually every type of networked application and is the global standard for developing and  delivering embedded and mobile applications, games, Web-based content,  and enterprise software. With more than 9 million developers worldwide, Java enables you to efficiently develop, deploy and use exciting applications and services.

Is 'million' present in the said text?
true

Is 'millions' present in the said text?
false
```java
// Define a class named Main
public class Main {
    
    // The main method, entry point of the program
    public static void main(String[] args) {
        // Define the main string
        String main_string = "Java is the foundation for virtually every type of " +
            "networked application and is the global standard for developing and " +
            " delivering embedded and mobile applications, games, Web-based content, " +
            " and enterprise software. With more than 9 million developers worldwide," +
            " Java enables you to efficiently develop, deploy and use exciting applications and services.";

        // Display the original string
        System.out.println("Original string:");
        System.out.println(main_string);

        // Define two sub-strings to search within the main string
        String sub_string1 = "million";
        String sub_string2 = "millions";

        // Check if the first sub-string is present in the main string
        boolean result1 = is_present(main_string, sub_string1);
        System.out.println("\nIs '" + sub_string1 + "'" + " present in the said text?");
        System.out.println(result1);

        // Check if the second sub-string is present in the main string
        boolean result2 = is_present(main_string, sub_string2);
        System.out.println("\nIs '" + sub_string2 + "'" + " present in the said text?");
        System.out.println(result2);
    }

    // Method to check if a sub-string is present in the main string
    public static boolean is_present(String main_string, String sub_string) {
        // Check for null or empty strings
        if (main_string == null || sub_string == null || main_string.isEmpty() || sub_string.isEmpty()) {
            return false;
        }

        // Check if the sub-string exists in the main string
        return main_string.indexOf(sub_string) != -1;
    }
}
```
Sample Output:

Original string:
Java is the foundation for virtually every type of networked application and is the global standard for developing and  delivering embedded and mobile applications, games, Web-based content,  and enterprise software. With more than 9 million developers worldwide, Java enables you to efficiently develop, deploy and use exciting applications and services.

Is 'million' present in the said text?
true

Is 'millions' present in the said text?
false
### 101. Write a Java program to test if a string contains only digits. Returns true or false.

Sample Output:

First string:
131231231231231231231231231212312312
true

Second string:
13123123123Z1231231231231231212312312
false
```java
// Define a class named Main
public class Main {
    
    // The main method, entry point of the program
    public static void main(String[] args) {
        // Define two digit strings
        String digit_string1 = "131231231231231231231231231212312312";
        String digit_string2 = "13123123123Z1231231231231231212312312";

        // Display the first string
        System.out.println("First string:");
        System.out.println(digit_string1);
        // Check if the first string contains only digits
        boolean result1 = test_only_digits(digit_string1);
        System.out.println(result1);

        // Display the second string
        System.out.println("\nSecond string:");
        System.out.println(digit_string2);
        // Check if the second string contains only digits
        boolean result2 = test_only_digits(digit_string2);
        System.out.println(result2);
    }

    // Method to check if a string contains only digits
    public static boolean test_only_digits(String digit_string) {
        // Iterate through each character of the string
        for (int i = 0; i < digit_string.length(); i++) {
            // Check if the character is not a digit
            if (!Character.isDigit(digit_string.charAt(i))) {
                return false;
            }
        }
        // If all characters are digits, return true
        return true;
    }
}
```
Sample Output:

First string:
131231231231231231231231231212312312
true

Second string:
13123123123Z1231231231231231212312312
false
Flowchart:

Flowchart: Java String Exercises - Test if a given string contains only digits
Sample Solution-2:
```java
Main.java Code:

//MIT License: https://bit.ly/35gZLa3
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326";
    
    private static final String NOT_ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326A";
    
    public static void main(String[] args) {

        System.out.println("Input text with only digits: \n" + ONLY_DIGITS + "\n");
        System.out.println("Input text with other characters: \n" + NOT_ONLY_DIGITS + "\n");
                
        System.out.println("Character.isDigit() solution:");
        long startTimeV1 = System.nanoTime();
        
        boolean onlyDigitsV11 = Strings.containsOnlyDigitsV1(ONLY_DIGITS);
        boolean onlyDigitsV12 = Strings.containsOnlyDigitsV1(NOT_ONLY_DIGITS);
        
        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Contains only digits: " + onlyDigitsV11);
        System.out.println("Contains only digits: " + onlyDigitsV12);
        
        System.out.println();        
        System.out.println("String.matches() solution:");
        long startTimeV2 = System.nanoTime();
        
        boolean onlyDigitsV21 = Strings.containsOnlyDigitsV2(ONLY_DIGITS);
        boolean onlyDigitsV22 = Strings.containsOnlyDigitsV2(NOT_ONLY_DIGITS);
        
        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Contains only digits: " + onlyDigitsV21);
        System.out.println("Contains only digits: " + onlyDigitsV22);
        
        System.out.println();                
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();
        
        boolean onlyDigitsV31 = Strings.containsOnlyDigitsV3(ONLY_DIGITS);
        boolean onlyDigitsV32 = Strings.containsOnlyDigitsV3(NOT_ONLY_DIGITS);
        
        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Contains only digits: " + onlyDigitsV31);
        System.out.println("Contains only digits: " + onlyDigitsV32);        
    }
    
    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
    
}
Strings.java Code:

//MIT License: https://bit.ly/35gZLa3
public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    // Note: For Unicode supplementary characters use codePointAt() instead of charAt()
    //       and codePoints() instead of chars()
    
    public static boolean containsOnlyDigitsV1(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean containsOnlyDigitsV2(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }

        return str.matches("[0-9]+");
    }

    public static boolean containsOnlyDigitsV3(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }

        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }
}
```
Sample Output:

Input text with only digits: 
45566336754493420932877387482372374982374823749823283974232237238472392309230923849023848234580383485342234287943943094234745374657346578465783467843653748654376837463847654382382938793287492326

Input text with other characters: 
45566336754493420932877387482372374982374823749823283974232237238472392309230923849023848234580383485342234287943943094234745374657346578465783467843653748654376837463847654382382938793287492326A

Character.isDigit() solution:
Execution time: 1279465 ns (1 ms)
Contains only digits: true
Contains only digits: false

String.matches() solution:
Execution time: 2059497 ns (2 ms)
Contains only digits: true
Contains only digits: false

Java 8, functional-style solution:
Execution time: 114091339 ns (114 ms)
Contains only digits: true
Contains only digits: false
### 102. Write a Java program to convert a given string to int, long, floating and double.

Sample Output:

Convert String to int/Integer:
"1323" as int is 1323 and as Integer is 1323

Convert String to long/Long:
"13625478965325" as long is 13625478965325 and as Long is 13625478965325

Convert String to float/Float:
"25.135F" as float is 25.135 and as Float is 25.135

Convert String to double/Double:
"21.25478254D" as double is 21.25478254 and as Double is 21.25478254
false
```java
// Define a class named Main
public class Main {
    
    // The main method, entry point of the program
    public static void main(String[] args) {
        // Define strings to convert
        String STR_TO_INT = "1323";
        String STR_TO_LONG = "13625478965325";
        String STR_TO_FLOAT = "25.135F";
        String STR_TO_DOUBLE = "21.25478254D";
        
        // Convert String to int/Integer
        System.out.println("Convert String to int/Integer:");
        Integer toInt1 = Integer.valueOf(STR_TO_INT);
        int toInt2 = Integer.parseInt(STR_TO_INT);
        System.out.println("\"" + STR_TO_INT + "\"" + " as int is "
                + toInt1 + " and as Integer is " + toInt2);
                
        // Convert String to long/Long
        System.out.println("\nConvert String to long/Long:");
        Long toLong1 = Long.valueOf(STR_TO_LONG);
        long toLong2 = Long.parseLong(STR_TO_LONG);
        System.out.println("\"" + STR_TO_LONG + "\"" + " as long is "
                + toLong1 + " and as Long is " + toLong2);
        
        // Convert String to float/Float
        System.out.println("\nConvert String to float/Float:");
        Float toFloat1 = Float.valueOf(STR_TO_FLOAT);
        float toFloat2 = Float.parseFloat(STR_TO_FLOAT);
        System.out.println("\"" + STR_TO_FLOAT + "\"" + " as float is "
                + toFloat1 + " and as Float is " + toFloat2);
                
        // Convert String to double/Double
        System.out.println("\nConvert String to double/Double:");
        Double toDouble1 = Double.valueOf(STR_TO_DOUBLE);
        double toDouble2 = Double.parseDouble(STR_TO_DOUBLE);
        System.out.println("\"" + STR_TO_DOUBLE + "\"" + " as double is "
                + toDouble1 + " and as Double is " + toDouble2);
    }
}
```
Sample Output:

Convert String to int/Integer:
"1323" as int is 1323 and as Integer is 1323

Convert String to long/Long:
"13625478965325" as long is 13625478965325 and as Long is 13625478965325

Convert String to float/Float:
"25.135F" as float is 25.135 and as Float is 25.135

Convert String to double/Double:
"21.25478254D" as double is 21.25478254 and as Double is 21.25478254
false
### 103. Write a Java program to remove a specified character from a given string.

Sample Output:

Original string:
abcdefabcdeabcdaaa

Second string:
bcdefbcdebcd
```java
// Define a class named Main
public class Main {
    
    // The main method, entry point of the program
    public static void main(String[] args) {
        // Define the initial string and character to remove
        String str1 = "abcdefabcdeabcdaaa";
        char g_char = 'a';
        
        // Remove the given character from the string
        String result = remove_Character(str1, g_char);
        
        // Print the original string
        System.out.println("\nOriginal string:");
        System.out.println(str1);
        
        // Print the modified string after removing the character
        System.out.println("\nSecond string:");
        System.out.println(result);
    }
    
    // Method to remove a specific character from a string
    public static String remove_Character(String str1, char g_char) {
        // Check for null or empty input string
        if (str1 == null || str1.isEmpty()) {
            return "";
        }
        
        // Use StringBuilder to efficiently manipulate strings
        StringBuilder sb = new StringBuilder();
        
        // Convert input string to a character array for iteration
        char[] chArray = str1.toCharArray();
        
        // Iterate through the characters in the array
        for (int i = 0; i < chArray.length; i++) {
            // Append characters other than the given character to the StringBuilder
            if (chArray[i] != g_char) {
                sb.append(chArray[i]);
            }
        }
        
        // Convert StringBuilder to String and return the modified string
        return sb.toString();
    }
}
```
Sample Output:

Original string:
abcdefabcdeabcdaaa

Second string:
bcdefbcdebcd
### 104. Write a Java program to sort in ascending and descending order by the length of the given array of strings.

Sample Output:

Original unsorted colors: [Green, White, Black, Pink, Orange, Blue, Champagne, Indigo, Ivory]

Sorted color (descending order): [Champagne, Orange, Indigo, Green, White, Black, Ivory, Pink, Blue]

Sorted color (ascending order): [Pink, Blue, Green, White, Black, Ivory, Orange, Indigo, Champagne]
```java
// Import the Arrays class from java.util package
import java.util.Arrays;

// Define a class named Main
public class Main {
    
    // Define an array of strings
    private static String[] strs = {"Green", "White", "Black", "Pink", "Orange", "Blue", "Champagne", "Indigo", "Ivory"};
    
    // Define an enum to specify sorting direction
    public enum sort_asc_dsc {
        ASC, DESC
    }
    
    // The main method, entry point of the program
    public static void main(String[] args) {
        // Print the original unsorted colors
        System.out.println("\nOriginal unsorted colors: " + Arrays.toString(strs));
        
        // Sort the array in descending order by length
        sort_array_by_length(strs, sort_asc_dsc.DESC);
        System.out.println("\nSorted color (descending order): " + Arrays.toString(strs));
        
        // Sort the array in ascending order by length
        sort_array_by_length(strs, sort_asc_dsc.ASC);
        System.out.println("\nSorted color (ascending order): " + Arrays.toString(strs));            
    }
    
    // Method to sort the array of strings by length based on the specified direction
    public static void sort_array_by_length(String[] strs, sort_asc_dsc direction) {
        // Check for null or empty input or invalid direction
        if (strs == null || direction == null || strs.length == 0) {
            return;
        }
        
        // Sort the array based on the direction specified
        if (direction.equals(sort_asc_dsc.ASC)) {
            // Sort in ascending order by length
            Arrays.sort(strs, (String str1, String str2) -> Integer.compare(str1.length(), str2.length()));
        } else if (direction.equals(sort_asc_dsc.DESC)) {
            // Sort in descending order by length
            Arrays.sort(strs, (String str1, String str2) -> (-1) * Integer.compare(str1.length(), str2.length()));
        }
    }
}
```
Sample Output:

Original unsorted colors: [Green, White, Black, Pink, Orange, Blue, Champagne, Indigo, Ivory]

Sorted color (descending order): [Champagne, Orange, Indigo, Green, White, Black, Ivory, Pink, Blue]

Sorted color (ascending order): [Pink, Blue, Green, White, Black, Ivory, Orange, Indigo, Champagne]
### 105. Write a Java program to count the occurrences of a given string in another given string.

Sample Output:

aa' has occured 3 times in 'abcd abc aabc baa abcaa'
```java
// Importing Arrays class from java.util package
import java.util.Arrays;

// Main class declaration
public class Main {    
    // Main method, entry point of the program
    public static void main(String[] args) {
        // Define main string and sub string
        String main_string = "abcd abc aabc baa abcaa";
        String sub_string = "aa";
        
        // Count occurrences of sub string in main string using method count_sub_str_in_main_str
        int countV1 = count_sub_str_in_main_str(main_string, sub_string);
        
        // Print the count of occurrences of sub string in main string
        System.out.println(sub_string + "' has occured " + countV1 + " times in '" + main_string + "'");            
    }
    
    // Method to count occurrences of sub string in main string
    public static int count_sub_str_in_main_str(String main_string, String sub_string) {
        // Check for null strings
        if (main_string == null || sub_string == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }
        
        // Check for empty strings
        if (main_string.isEmpty() || sub_string.isEmpty()) {
            return 0;
        }
        
        // Initialize variables for position and counter
        int position = 0;
        int ctr = 0;
        int n = sub_string.length();
        
        // Loop to find occurrences of sub string in main string
        while ((position = main_string.indexOf(sub_string, position)) != -1) {
            position = position + n;
            ctr++;
        }
        return ctr;
    }
}
```
Sample Output:

aa' has occured 3 times in 'abcd abc aabc baa abcaa'
Flowchart:

Flowchart: Java String Exercises - Count the occurrences of a given string in another given string.
Count string in another string.
```java
Main.java Code:

//MIT License: https://bit.ly/35gZLa3
import java.time.Clock;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String STRING = "111111";
    private static final String SUBSTRING = "11";

    public static void main(String[] args) {

        Clock clock = Clock.systemUTC();
        long startTimeV1 = clock.millis();
        int countV1 = Strings.countStringInStringV1(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("V1: '" + SUBSTRING + "' has occured " + countV1 + " times in '" + STRING + "'");

        long startTimeV2 = clock.millis();
        int countV2 = Strings.countStringInStringV2(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("V2: '" + SUBSTRING + "' has occured " + countV2 + " times in '" + STRING + "'");

        long startTimeV3 = clock.millis();
        int countV3 = Strings.countStringInStringV3(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV3);
        System.out.println("V3: '" + SUBSTRING + "' has occured " + countV3 + " times in '" + STRING + "'");
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }

}
Strings.java Code:

//MIT License: https://bit.ly/35gZLa3
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int countStringInStringV1(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isEmpty() || toFind.isEmpty()) {
            return 0;
        }

        int position = 0;
        int count = 0;
        int n = toFind.length();

        while ((position = string.indexOf(toFind, position)) != -1) {
            position = position + n;
            count++;
        }

        return count;
    }

    public static int countStringInStringV2(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isEmpty() || toFind.isEmpty()) {
            return 0;
        }

        return string.split(Pattern.quote(toFind), -1).length - 1;
    }

    public static int countStringInStringV3(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isEmpty() || toFind.isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);

        int position = 0;
        int count = 0;
        while (matcher.find(position)) {           
            position = matcher.start() + 1;
            count++;
        }

        return count;
    }
}
```
Sample Output:

Execution time: 1 ms (0 s)
V1: '11' has occured 3 times in '111111'
Execution time: 2 ms (0 s)
V2: '11' has occured 3 times in '111111'
Execution time: 1 ms (0 s)
V3: '11' has occured 5 times in '111111'
### 106. Write a Java program to concatenate a given string with itself a given number of times.

Sample Output:

Original string: PHP

After repeating 7 times: PHPPHPPHPPHPPHPPHPPHP
```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str1 = "PHP"; // Declare and initialize a string variable
        System.out.println("Original string: " + str1); // Display the original string
        String resultV1 = repeat_str(str1, 7); // Call the repeat_str method with str1 and 7 as arguments
        System.out.println("\nAfter repeating 7 times: " + resultV1); // Display the result of repeating str1 7 times
    }

    public static String repeat_str(String str1, int n) {
        // Check if the input string is null or empty
        if (str1 == null || str1.isEmpty()) {
            return ""; // Return an empty string
        }
        
        // Check if n is less than or equal to 0
        if (n <= 0) {
            return str1; // Return the original string as n is 0 or negative
        }
        
        // Check if multiplying the length of str1 by n will exceed the maximum size of a String
        if (Integer.MAX_VALUE / n < str1.length()) {
            throw new OutOfMemoryError("Maximum size of a String will be exceeded"); // Throw an error
        }
        
        StringBuilder x = new StringBuilder(str1.length() * n); // Create a StringBuilder to store the result
        // Repeat the string n times and append it to the StringBuilder
        for (int i = 1; i <= n; i++) {
            x.append(str1);
        }
        return x.toString(); // Return the final repeated string
    }
}
```
Sample Output:

Original string: PHP

After repeating 7 times: PHPPHPPHPPHPPHPPHPPHP

### 107. Write a Java program to count occurrences of a certain character in a given string.

```java
//MIT License: https://bit.ly/35gZLa3
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";
    private static final char CHAR_TO_COUNT = 'u';

    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_TO_COUNT_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_TO_COUNT_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149

    public static void main(String[] args) {
        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("\n\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");

        System.out.println("replace() based solution:");
        long startTimeV1 = System.nanoTime();

        int countV1 = Strings
                .countOccurrencesOfACertainCharacterV1(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Character '" + CHAR_TO_COUNT + "' occured " + countV1 + " time(s)");

        System.out.println();
        System.out.println("charAt() based solution:");
        long startTimeV2 = System.nanoTime();

        int countV2 = Strings
                .countOccurrencesOfACertainCharacterV2(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Character '" + CHAR_TO_COUNT + "' occured " + countV2 + " time(s)");

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        long countV3 = Strings
                .countOccurrencesOfACertainCharacterV3(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Character '" + CHAR_TO_COUNT + "' occured " + countV3 + " time(s)");

        System.out.println("\n--------------------------------------\n");
        
        System.out.println("Input text: \n" + TEXT_CP + "\n");
        
        System.out.println("\n\nIncluding Unicode surrogate pairs examples:\n");

        System.out.println("replace() based solution:");
        long startTimeV4 = System.nanoTime();

        int countV4 = Strings
                .countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("Character '" + CHAR_TO_COUNT_CP + "' occured " + countV4 + " time(s)");

        System.out.println();
        System.out.println("replace() based solution:");
        long startTimeV5 = System.nanoTime();

        int countV5 = Strings
                .countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV5);
        System.out.println("Character '" + CHAR_TO_COUNT_CPS + "' occured " + countV5 + " time(s)");

        System.out.println();
        System.out.println("codePointAt() based solution:");
        long startTimeV6 = System.nanoTime();

        int countV6 = Strings
                .countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV6);
        System.out.println("Character '" + CHAR_TO_COUNT_CP + "' occured " + countV6 + " time(s)");

        System.out.println();
        System.out.println("codePointAt() based solution:");
        long startTimeV7 = System.nanoTime();

        int countV7 = Strings
                .countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV7);
        System.out.println("Character '" + CHAR_TO_COUNT_CPS + "' occured " + countV7 + " time(s)");

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV8 = System.nanoTime();

        long countV8 = Strings
                .countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV8);
        System.out.println("Character '" + CHAR_TO_COUNT_CP + "' occured " + countV8 + " time(s)");

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV9 = System.nanoTime();

        long countV9 = Strings
                .countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV9);
        System.out.println("Character '" + CHAR_TO_COUNT_CPS + "' occured " + countV9 + " time(s)");
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
Strings.java Code:

//MIT License: https://bit.ly/35gZLa3
public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int countOccurrencesOfACertainCharacterV1(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException            
            return -1;
        }

        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static int countOccurrencesOfACertainCharacterVCP1(String str, String ch) {

        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            // or throw IllegalArgumentException            
            return -1;
        }

        if (ch.codePointCount(0, ch.length()) > 1) {
            return -1; // there is more than 1 Unicode character in the given String
        }

        int result = str.length() - str.replace(ch, "").length();

        // if ch.length() return 2 then this is a Unicode surrogate pair
        return ch.length() == 2 ? result / 2 : result;
    }

    public static int countOccurrencesOfACertainCharacterV2(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return -1;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static int countOccurrencesOfACertainCharacterVCP2(String str, String ch) {

        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            // or throw IllegalArgumentException            
            return -1;
        }

        if (ch.codePointCount(0, ch.length()) > 1) {
            return -1; // there is more than 1 Unicode character in the given String
        }

        int count = 0;
        int codePoint = ch.codePointAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.codePointAt(i) == codePoint) {
                count++;
            }
        }

        return count;
    }

    public static long countOccurrencesOfACertainCharacterV3(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return -1;
        }

        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
    
    public static long countOccurrencesOfACertainCharacterVCP3(String str, String ch) {

        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            // or throw IllegalArgumentException            
            return -1;
        }

        if (ch.codePointCount(0, ch.length()) > 1) {
            return -1; // there is more than 1 Unicode character in the given String
        }

        int codePoint = ch.codePointAt(0);        
        
        return str.codePoints()
                .filter(c -> c == codePoint)
                .count();
    }
}
```
Sample Output:

Input text: 
My high school, the Illinois Mathematics and Science Academy, showed me that anything is possible and that you're never too young to think big. At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, or Fermilab. After graduating, I attended Stanford for a degree in economics and computer science.

ASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:

replace() based solution:
Execution time: 2451480 ns (2 ms)
Character 'u' occured 5 time(s)

charAt() based solution:
Execution time: 40343 ns (0 ms)
Character 'u' occured 5 time(s)

Java 8, functional-style solution:
Execution time: 156518104 ns (156 ms)
Character 'u' occured 5 time(s)

--------------------------------------

Input text: 
😍 I love 💕 you Ӝ so much 💕 😍



Including Unicode surrogate pairs examples:

replace() based solution:
Execution time: 97920 ns (0 ms)
Character 'Ӝ' occured 1 time(s)

replace() based solution:
Execution time: 403313 ns (0 ms)
Character '💕' occured 2 time(s)

codePointAt() based solution:
Execution time: 31224 ns (0 ms)
Character 'Ӝ' occured 1 time(s)

codePointAt() based solution:
Execution time: 25059 ns (0 ms)
Character '💕' occured 2 time(s)

Java 8, functional-style solution:
Execution time: 1735086 ns (1 ms)
Character 'Ӝ' occured 1 time(s)

Java 8, functional-style solution:
Execution time: 41650 ns (0 ms)
Character '💕' occured 2 time(s)
### 108. Write a Java program to check whether there are two consecutive (following each other continuously), identical letters in a given string.

Sample Output:

Original word: Follow
If there are two consecutive identical letters in the said string: true
Original word: Java
If there are two consecutive identical letters in the said string: false
Original word: Yellow
If there are two consecutive identical letters in the said string: true
```java
public class test {
    public static void main(String[] args) {
        String text = "Follow"; // Define a string 'text' with the value "Follow"
        System.out.println("Original word: " + text); // Display the original word
        
        // Check if there are two consecutive identical letters in the string and display the result
        System.out.println("If there are two consecutive identical letters in the said string: " + test(text));
        
        text = "Java"; // Change the value of 'text' to "Java"
        System.out.println("Original word: " + text); // Display the original word
        
        // Check if there are two consecutive identical letters in the string and display the result
        System.out.println("If there are two consecutive identical letters in the said string: " + test(text));
        
        text = "Yellow"; // Change the value of 'text' to "Yellow"
        System.out.println("Original word: " + text); // Display the original word
        
        // Check if there are two consecutive identical letters in the string and display the result
        System.out.println("If there are two consecutive identical letters in the said string: " + test(text));
    }

    // Method to test if there are two consecutive identical letters in the string
    public static boolean test(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) { // Check for consecutive identical letters
                return true; // Return true if two consecutive identical letters are found
            }
        }
        return false; // Return false if no consecutive identical letters are found
    }
}
```
Sample Output:

Original word: Follow
If there are two consecutive identical letters in the said string: true
Original word: Java
If there are two consecutive identical letters in the said string: false
Original word: Yellow
If there are two consecutive identical letters in the said string: true

Sample Solution-2:

Java Code:
```java
import java.util.stream.IntStream;

public class test {

    public static void main(String[] args) {
        String text = "Follow"; // Define a string 'text' with the value "Follow"
        System.out.println("Original word: " + text); // Display the original word
        
        // Check if there are two consecutive identical letters in the string and display the result
        System.out.println("If there are two consecutive identical letters in the said string: " + test(text));
        
        text = "Java"; // Change the value of 'text' to "Java"
        System.out.println("Original word: " + text); // Display the original word
        
        // Check if there are two consecutive identical letters in the string and display the result
        System.out.println("If there are two consecutive identical letters in the said string: " + test(text));
        
        text = "Yellow"; // Change the value of 'text' to "Yellow"
        System.out.println("Original word: " + text); // Display the original word
        
        // Check if there are two consecutive identical letters in the string and display the result
        System.out.println("If there are two consecutive identical letters in the said string: " + test(text));
    }

    // Method to test if there are two consecutive identical letters in the string using IntStream
    public static boolean test(String text) {
        return IntStream.range(0, text.length() - 1) // Generate a stream of integers from 0 to text.length()-1
                .anyMatch(n -> text.charAt(n) == text.charAt(n + 1)); // Check if any pair of consecutive letters are identical
    }
}
```
Sample Output:

Original word: Follow
If there are two consecutive identical letters in the said string: true
Original word: Java
If there are two consecutive identical letters in the said string: false
Original word: Yellow
If there are two consecutive identical letters in the said string: true
### 109. Write a Java program that reverses all odd-length words in a string.

Sample Output:

Original text: Check two consecutive identical letters in a given string

Reverses the words in the string that have odd lengths:
Check two consecutive identical letters ni a given gnirts

Original text: Create a Date object using the Calendar class

Reverses the words in the string that have odd lengths:
etaerC a etaD tcejbo using the radnelaC class
```java
public class Main {
    public static void main(String[] args) {
        // Define a string 'text' with a sentence
        String text = "Check two consecutive identical letters in a given string";
        System.out.println("Original text: " + text); // Display the original text
        
        // Reverse the words with odd lengths in the string and display the modified string
        System.out.println("\nReverses the words in the string that have odd lengths:\n" + test(text));
        
        // Change the value of 'text' to another sentence
        text = "Create a Date object using the Calendar class";
        System.out.println("\nOriginal text: " + text); // Display the original text
        
        // Reverse the words with odd lengths in the string and display the modified string
        System.out.println("\nReverses the words in the string that have odd lengths:\n" + test(text));
    }

    // Method to reverse words with odd lengths in a string
    public static String test(String str) {
        // Split the string into words using space as a delimiter
        String[] str_words = str.split(" ");
        
        // Iterate through each word in the array
        for (int i = 0; i < str_words.length; i++) {
            // Check if the length of the word is odd
            if (str_words[i].length() % 2 != 0) {
                // Reverse the word using StringBuilder and update the array element
                StringBuilder reverser = new StringBuilder(str_words[i]);
                str_words[i] = reverser.reverse().toString();
            }
        }
        
        // Join the modified words to form a string and return the result
        return String.join(" ", str_words);
    }
}
```
Sample Output:

Original text: Check two consecutive identical letters in a given string

Reverses the words in the string that have odd lengths:
kcehC owt evitucesnoc lacitnedi srettel in a nevig string

Original text: Create a Date object using the Calendar class

Reverses the words in the string that have odd lengths:
Create a Date object gnisu eht Calendar ssalc
### 110. Write a Java program to count the number of characters (alphanumeric only) that occur more than twice in a given string.

Sample Output:

Original String: abcdaa
Number of duplicate characters in the said String (Occurs more than twice.): 1

Original String: Create a Date Calendar.
Number of duplicate characters in the said String (Occurs more than twice.): 3
```java
public class Main {
    public static void main(String[] args) {
        // Define a string 'text' with certain characters
        String text = "abcdaa";
        System.out.println("Original String: " + text); // Display the original string
        
        // Count and display the number of duplicate characters occurring more than twice in the string
        System.out.println("Number of duplicate characters in the said String (Occurs more than twice.): " + test(text));
        
        // Change the value of 'text' to another string
        text = "Tergiversation";
        System.out.println("\nOriginal String: " + text); // Display the original string
        
        // Count and display the number of duplicate characters occurring more than twice in the string
        System.out.println("Number of duplicate characters in the said String (Occurs more than twice.): " + test(text));
    }

    // Method to count duplicate characters occurring more than twice in a string
    public static int test(String text) {
        int ctr = 0; // Counter to store the count of duplicate characters
        
        // Continue looping until the length of 'text' becomes zero
        while (text.length() > 0) {
            // Check if the count of a character (after removal) is more than 2 in the string
            if (text.length() - text.replaceAll(text.charAt(0) + "", "").length() > 2) {
                ctr++; // Increment the counter if duplicate characters are found more than twice
            }
            
            // Remove all occurrences of the first character from the string 'text'
            text = text.replaceAll(text.charAt(0) + "", "");
        }
        
        return ctr; // Return the count of duplicate characters occurring more than twice
    }
}
```
Sample Output:

Original String: abcdaa
Number of duplicate characters in the said String (Occurs more than twice.): 1

Original String: Tergiversation
Number of duplicate characters in the said String (Occurs more than twice.): 0

Sample Solution-2:

Java Code:
```java
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Define a string 'text' with certain characters
        String text = "abcdaa";
        System.out.println("Original String: " + text); // Display the original string
        
        // Count and display the number of duplicate characters occurring more than twice in the string
        System.out.println("Number of duplicate characters in the said String (Occurs more than twice.): " + test(text));
        
        // Change the value of 'text' to another string
        text = "Tergiversation";
        System.out.println("\nOriginal String: " + text); // Display the original string
        
        // Count and display the number of duplicate characters occurring more than twice in the string
        System.out.println("Number of duplicate characters in the said String (Occurs more than twice.): " + test(text));
    }

    // Method to count duplicate characters occurring more than twice in a string
    public static int test(String text) {
        return (int) text.chars() // Convert the string into an IntStream of characters
                .boxed() // Box each integer value into its corresponding Integer object
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Collect the characters into a map with their counts
                .values() // Get the values (counts) from the map
                .stream() // Convert the Collection into a Stream
                .filter(ctr -> ctr > 2) // Filter the counts to keep those occurring more than twice
                .count(); // Count the filtered occurrences
    }
}
```
Sample Output:

Original String: abcdaa
Number of duplicate characters in the said String (Occurs more than twice.): 1

Original String: Tergiversation
Number of duplicate characters in the said String (Occurs more than twice.): 0
### 111. Write a Java program that removes a specified word from given text. Return the updated string..

Sample Output:

Input a string: 
 Exercises Practice Solution
Input a word to remove: 
 Solution
New string, after removing the said word:
Exercises Practice 
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt the user to input a string and a word to remove
        System.out.println("Input a string: ");
        String text = myObj.nextLine(); // Read the input string
        System.out.println("Input a word to remove: ");
        String word = myObj.nextLine(); // Read the word to remove
        
        // Display the new string after removing the specified word
        System.out.println("New string, after removing the said word:\n" + test(text, word));
    }

    // Method to remove a specified word from a given string
    public static String test(String text, String word) {
        String result_str = text.replace(word, ""); // Replace occurrences of the word with an empty string
        result_str = result_str.replaceAll("\\s+", " "); // Remove extra spaces in the resultant string
        return result_str; // Return the modified string
    }
}
```
Sample Output:

Input a string: 
 Exercises Practice Solution
Input a word to remove: 
 Solution
New string, after removing the said word:
Exercises Practice 
Flowchart:

Flowchart: Java String Exercises - Remove a  word from a given text
Sample Solution-2:

Java Code:
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt the user to input a string and a word to remove
        System.out.println("Input a string: ");
        String text = myObj.nextLine(); // Read the input string
        System.out.println("Input a word to remove: ");
        String word = myObj.nextLine(); // Read the word to remove
        
        // Display the new string after removing the specified word
        System.out.println("New string, after removing the said word:\n" + test(text, word));
    }

    // Method to remove a specified word from a given string
    public static String test(String text, String word) {
        String result_str = text.replace(word, ""); // Replace occurrences of the word with an empty string
        result_str = result_str.replaceAll("\\s+", " "); // Remove extra spaces in the resultant string
        return result_str; // Return the modified string
    }
}
```
Sample Output:

Input a string: 
 Red Green Blue
Input a word to remove: 
 Green
New string, after removing the said word:
Red Blue
### 112. A string is created by using another string's letters. Letters are case sensitive. Write a Java program that checks the letters of the second string are present in the first string. Return true otherwise false.

Sample Output:

Input the first string: 
 Java
Input the second string: 
 Ja
Check first string contains letters from the second string:
true
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt the user to input the first and second strings
        System.out.println("Input the first string: ");
        String text = myObj.nextLine(); // Read the first string
        System.out.println("Input the second string: ");
        String word = myObj.nextLine(); // Read the second string
        
        // Check if the first string contains all letters from the second string
        System.out.println("Check first string contains letters from the second string:\n" + test(text, word));
    }

    // Method to check if the first string contains all letters from the second string
    public static boolean test(String first_string, String second_string) {
        if (second_string.length() > first_string.length()) return false; // If the second string is longer, return false
        if (second_string.isEmpty()) return true; // If the second string is empty, return true
        
        // Iterate through each character in the second string
        for (int i = 0; i < second_string.length(); i++) {
            // If the first string does not contain the current character from the second string, return false
            if (!first_string.contains(String.valueOf(second_string.charAt(i)))) {
                return false;
            }
        }
        return true; // Return true if all characters from the second string are found in the first string
    }
}
```
Sample Output:

Input the first string: 
 Java
Input the second string: 
 Ja
Check first string contains letters from the second string:
true
Flowchart:

Flowchart: Java String Exercises - Check first string contains letters from the second
Sample Solution-2:

Java Code:
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt the user to input the first and second strings
        System.out.println("Input the first string: ");
        String text = myObj.nextLine(); // Read the first string
        System.out.println("Input the second string: ");
        String word = myObj.nextLine(); // Read the second string
        
        // Check if the first string contains all letters from the second string
        System.out.println("Check first string contains letters from the second string:\n" + test(text, word));
    }

    // Method to check if the first string contains all letters from the second string
    public static boolean test(String first_string, String second_string) {
        for (int n = 0; n < second_string.length(); n++) // Loop through each character of the second string
            if (first_string.replaceFirst(second_string.substring(n, n + 1), "").equals(first_string)) // If the character from the second string is not found in the first string
                return false; // Return false
            else
                first_string = first_string.replaceFirst(second_string.substring(n, n + 1), ""); // Remove the character from the first string
        return true; // Return true if all characters from the second string are found in the first string
    }
}
```
Sample Output:

Input the first string: 
 Java
Input the second string: 
 Ja
Check first string contains letters from the second string:
true
