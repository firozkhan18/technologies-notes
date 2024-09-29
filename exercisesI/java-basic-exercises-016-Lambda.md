# Java Exercises Lambda

Java 8 introduces several new language features designed to make it easier to write such blocks of code-the key feature being lambda expressions, also colloquially referred to as closures or anonymous methods. A lambda expression is just a shorter way of writing an implementation of a method for later execution.

### 1. Write a Java program to implement a lambda expression to find the sum of two integers.
```java
// SumCalculator.java 

interface SumCalculator {
    int sum(int a, int b);
}

// Main.java
public class Main {
    public static void main(String[] args) {
        SumCalculator sumCalculator = (x, y) -> x + y;
        int result = sumCalculator.sum(7, 6);
        System.out.println("Sum 7,6): " + result);
	result = sumCalculator.sum(15, -35);
        System.out.println("Sum 15, -35): " + result);
    }
}
```
Sample Output:

Sum 7,6): 13
Sum 15, -35): -20 
Explanation:

In the above exercise, a functional interface named SumCalculator is defined. This interface has a single abstract method called sum that takes two integer parameters and returns an integer result. The lambda expression (x, y) -> x + y is used to implement this method. It takes two integers, x and y, and returns their sum.


In the main method, an instance of the SumCalculator interface is created using the lambda expression and assigned to the variable sumCalculator. For calculating the sum, the sumCalculator is invoked with pairs of integer arguments. System.out.println prints the results to the console from the result variable.

### 2. Write a Java program to implement a lambda expression to check if a given string is empty.
```java
// Main.java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Lambda expression to check if a given string is empty
        Predicate isEmptyString = str -> str.isEmpty();

        // Test cases
        String str1 = ""; // empty string
        String str2 = "Java lambda expression!"; // non-empty string

        // Check if the strings are empty using the lambda expression
		System.out.println("String 1:" + str1);
        System.out.println("String 1 is empty: " + isEmptyString.test(str1));
        System.out.println("\nString 2:" + str2);
		System.out.println("String 2 is empty: " + isEmptyString.test(str2));
    }
}
```
Sample Output:

String 1:
String 1 is empty: true

String 2:Java lambda expression!
String 2 is empty: false
Explanation:

In the above exercise, we define a Predicate functional interface with a lambda expression to check if a given string is empty. The lambda expression uses the isEmpty() method of the String class to determine if the string is empty.


To check if the strings are empty, we create two test cases, str1 and str2, and use the test() method of the Predicate interface. On the console, the results are displayed.

### 3. Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
```java
// Main.java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List stringList = Arrays.asList("Red", "Green", "Blue", "PINK");

        // Print the original strings
        System.out.println("\nOriginal strings:");
        for (String str : stringList) {
            System.out.println(str);
        } 

        // Convert strings to lowercase using lambda expression
        stringList.replaceAll(str -> str.toLowerCase());

        // Print the list of lowercase strings
        System.out.println("\nLowercase strings:");
        for (String str : stringList) {
            System.out.println(str);
        }
		
		// Convert strings to uppercase using lambda expression
        stringList.replaceAll(str -> str.toUpperCase());

        // Print the list of uppercase strings
        System.out.println("\nUppercase strings:");
        for (String str : stringList) {
            System.out.println(str);
        }
    }
}
```
Sample Output:

Original strings:
Red
Green
Blue
PINK

Lowercase strings:
red
green
blue
pink

Uppercase strings:
RED
GREEN
BLUE
PINK
Explanation:

In the above exercise, we start by creating a list of strings stringList.


The replaceAll() method applies a lambda expression that converts each string in the list to uppercase using the toUpperCase() method. This lambda expression is (str -> str.toUpperCase()). After that, the replaceAll() method applies a lambda expression that converts each string in the list to lowercase using the toLowerCase method. This lambda expression is (str -> str.toLowerCase()).

### 4. Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
```java
// Main.java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers
        List nums = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);
        
		// Print the original numbers
        System.out.println("Original numbers:");
        for (int n : nums) {
            System.out.print(n+ " ");
        }		

        // Filter out even numbers using lambda expression
        List evenNumbers = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // Print the even numbers
        System.out.print("\nEven numbers:");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }

        // Filter out odd numbers using lambda expression
        List oddNumbers = nums.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        // Print the odd numbers
        System.out.print("\nOdd numbers:");
        for (int num : oddNumbers) {
            System.out.print(num + " ");
        }
    }
}
```
Sample Output:

Original numbers:
11 23 98 34 15 32 42 80 99 100
Even numbers:98 34 32 42 80 100
Odd numbers:11 23 15 99
Explanation:

At first create a list of integers called nums using the Arrays.asList() method and print the original list.


To filter out even numbers, we use the stream() method on the list nums to convert it into a stream. Now apply a lambda expression with the filter() method. The lambda expression (n -> n % 2 == 0) checks if a number is divisible by 2 (i.e., even). We collect the filtered even numbers into a new list using the collect() method with Collectors.toList().

To filter out odd numbers, we use a similar approach. We again use the stream() method on the nums list, apply a lambda expression (num -> num % 2 != 0) to check if a number is not divisible by 2 (i.e., odd), and collect the filtered odd numbers into a new list using collect() and Collectors.toList().

### 5. Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List colors = Arrays.asList("red", "green", "blue", "black", "pink");

        // Print the Original list of strings
        System.out.println("Original strings:");
        for (String str : colors) {
            System.out.print(str + ' ');
        }

        // Sort the list of strings in alphabetical order using lambda expression
        colors.sort((str1, str2) -> str1.compareToIgnoreCase(str2));

        // Print the sorted list of strings
        System.out.println("\nSorted strings:");
        for (String str : colors) {
            System.out.print(str + ' ');
        }
    }
}
```
Sample Output:

Original strings:
red green blue black pink
Sorted strings:
black blue green pink red
Explanation:

First create a list of strings called colors using the Arrays.asList() method and print the original list elements.


To sort the strings list alphabetically, we use the sort method on the colors list. The lambda expression (str1, str2) -> str1.compareToIgnoreCase(str2) is used as a comparator. It compares two strings lexicographically, ignoring the case, using the compareToIgnoreCase method.

After sorting the list, we print the sorted list of strings.

### 6. Write a Java program to implement a lambda expression to find the average of a list of doubles.
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of doubles
        List<Double> nums = Arrays.asList(3.5, 7.5, 4.3, 4.7, 5.1);
		// Print the list elements
        System.out.println("Original values: " + nums);

        // Calculate the average of the list using lambda expression
        double average = nums.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        // Print the average
        System.out.println("\nAverage of the original values: " + average);
    }
}
```
Sample Output:

Original values: [3.5, 7.5, 4.3, 4.7, 5.1]

Average of the original values: 5.0200000000000005
Explanation:

To calculate the average of the list, we use the stream() method on the nums list to convert it into a stream. Then, we use the mapToDouble() method to convert each Double object to its corresponding primitive double value. This step is necessary because the average() method operates on primitive double values.


Next, we call the average() method to calculate the average of the stream. If the stream is empty, we use orElse(0.0) to provide a default value of 0.0.

### 7. Write a Java program to implement a lambda expression to remove duplicates from a list of integers.
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers with duplicates
        List<Integer> nums = Arrays.asList(1, 2, 3, 3, 4, 3, 2, 5, 6, 1, 7, 7, 8, 10);
        // Print the list
        System.out.println("List elements " + nums);     
        // Remove duplicates using lambda expression
        List<Integer> unique_nums = new ArrayList<>();
        nums.stream()
                .distinct()
                .forEach(unique_nums::add);

        // Print the list without duplicates
        System.out.println("\nList elements without duplicates: " + unique_nums);
    }
}
```
Sample Output:

List elements [1, 2, 3, 3, 4, 3, 2, 5, 6, 1, 7, 7, 8, 10]

List elements without duplicates: [1, 2, 3, 4, 5, 6, 7, 8, 10]
Explanation:

In the above exercise we use the stream() method on the nums list to convert it into a stream. We call the distinct() method to filter out duplicate elements. The distinct() method ensures that only distinct elements are retained in the stream.


Finally, we use the forEach() method and a lambda expression unique_nums::add to add each unique element to the unique_nums list.

### 8. Write a lambda expression to implement a lambda expression to calculate the factorial of a given number.
```java
import java.util.function.LongUnaryOperator;

public class Main {
    public static void main(String[] args) {
        // Define the factorial lambda expression
        LongUnaryOperator factorial = n -> {
            long result = 1;
            for (long i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        // Calculate the factorial of a number using the lambda expression
        long n = 7;
        long factorial_result = factorial.applyAsLong(n);

        // Print the factorial result
        System.out.println("Factorial of " + n + " is: " + factorial_result);
    }
}
```
Sample Output:

Factorial of 7 is: 5040
Explanation:

In the above exercise, we define a lambda expression using the LongUnaryOperator functional interface. This interface represents an operation on a single long operand and produces a long result.


In the main method, we create an instance of the LongUnaryOperator using the lambda expression. Then, we specify the number for which the factorial should be calculated.

In order to calculate the factorial, we use the applyAsLong method of the lambda expression and pass the number as an argument. In the factorialResult variable, we store the result.

Lastly, we print the factorial result using System.out.println ().

### 9. Write a Java program to implement a lambda expression to create a lambda expression to check if a number is prime.
```java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Define the prime check lambda expression
        Predicate<Integer> is_Prime = n -> {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };

        // Check if a number is prime using the lambda expression
        int n = 17;
        boolean isPrimeResult = is_Prime.test(n);
        // Print the prime check result
        System.out.println(n + " is prime? " + isPrimeResult);
		// Check if a number is prime using the lambda expression
        n = 15;
        isPrimeResult = is_Prime.test(n);
        // Print the prime check result
        System.out.println("\n"+n + " is prime? " + isPrimeResult);
    }
}
```
Sample Output:

17 is prime? true

15 is prime? false
Explanation:

In the main method, we define a lambda expression using the Predicate<Integer>. This functional interface represents a predicate (boolean-valued function) of one argument.


The lambda expression checks if a given number n is prime. It first checks if the number is less than or equal to 1, returning false. Then, it uses a for loop to iterate from 2 to the square root of n. It checks if n is divisible by any number within this range. If it is, it gives false, indicating that the number is not prime. Otherwise, it returns true, indicating the number is prime.

After defining the lambda expression, we use it to check if a number is prime. We do this by calling the test method on the lambda expression and passing the number as an argument. The result is stored in the isPrimeResult variable, which is a boolean.

### 10. Write a Java program to implement a lambda expression to concatenate two strings.
```java
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        // Define the concatenate lambda expression
        BiFunction<String, String, String> concatenate = (str1, str2) -> str1 + str2;

        // Concatenate two strings using the lambda expression
        String string1 = "Good ";
        String string2 = "Morning!";
		System.out.println("Original strings: " + string1 + ", " +string2);
        String result = concatenate.apply(string1, string2);

        // Print the concatenated string
        System.out.println("\nConcatenated string: " + result);
    }
}
```
Sample Output:

Original strings: Good , Morning!

Concatenated string: Good Morning!
Explanation:

In the above exercise -

From the java.util.function package, we import the BiFunction functional interface.


In the main() method, we define a lambda expression using the BiFunction<String, String, String>. This functional interface represents a function that accepts two String arguments and produces a String result.

The lambda expression "concatenate" takes two strings str1 and str2 as input and concatenates them using the + operator.

After defining the lambda expression, we use it to concatenate two strings by calling the apply method on the lambda expression and passing the two strings as arguments. The result is stored in the result variable, which is a String.

### 11. Write a Java program to implement a lambda expression to find the maximum and minimum values in a list of integers.
```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> nums = Arrays.asList(12, 15, 0, 8, 7, 9, -6);
        System.out.println("Original values of the said array: "+nums); 
        // Find the maximum value using lambda expression
        Optional<Integer> max = nums.stream()
                .max((x, y) -> x.compareTo(y));

        // Find the minimum value using lambda expression
        Optional<Integer> min = nums.stream()
                .min((x, y) -> x.compareTo(y));

        // Print the maximum and minimum values
        System.out.println("Maximum value: " + max.orElse(null));
        System.out.println("Minimum value: " + min.orElse(null));
    }
}
```
Sample Output:

Original values of the said array: [12, 15, 0, 8, 7, 9, -6]
Maximum value: 15
Minimum value: -6
Explanation:

The first step is to import the necessary classes: Arrays, Lists, and Optionals.


Using Arrays.asList(), we create a list of integers named nums in the main method. The list contains several integer values.

To find the maximum value, we use the stream() method on the nums list to convert it into a stream. Then, we call the max() method on the stream and provide a lambda expression (x, y) -> x.compareTo(y) as a comparator. This lambda expression compares two integers x and y using the compareTo() method. This method returns a negative, zero, or positive value depending on the comparison result.

The max() method returns an Optional object that may contain the maximum value if it exists or an empty Optional if the stream is empty.

Similarly, we use the min() method on the stream with the same lambda expression to find the minimum value.

The max() and min() methods return Optional objects that may contain the maximum and minimum values, respectively.

Finally, we use the orElse() method on the Optional objects to retrieve the maximum and minimum values. If the Optional object is empty, we display null.

Lastly, we print the maximum and minimum values using System.out.println ().

### 12. Write a Java program to create a lambda expression to multiply and sum all elements in a list of integers.
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> nums = Arrays.asList(4, 2, 3, 6, 5, 1);
        System.out.println("Original array elements: " + nums);
        // Define the multiply and sum lambda expression
        int result = nums.stream()
                .reduce(1, (x, y) -> x * y)
                .intValue();

        // Print the result
        System.out.println("\nProduct of the list elements: " + result);

        // Calculate the sum of the list elements using lambda expression
        int sum = nums.stream()
                .reduce(0, (x, y) -> x + y)
                .intValue();

        // Print the sum
        System.out.println("\nSum of the list elements: " + sum);
    }
}
```
Sample Output:

Original array elements: [4, 2, 3, 6, 5, 1]

Product of the list elements: 720

Sum of the list elements: 21
Explanation:

Initially the necessary classes are imported: Arrays and Lists.


In the main method, we create a list of integers named nums using the Arrays.asList() method. The list contains several integer values.

We define a lambda expression (x, y) -> x * y using the reduce() method on the stream of nums. The lambda expression takes two integers x and y as input and multiplies them using the operator.

The reduce() method applies the lambda expression to each element in the stream, performing the multiplication operation. The initial reduction value is set to 1.

We store the multiplication result in the result variable, which is an integer.

Next, we calculate the sum of all elements in the list:

We define a lambda expression (x, y) -> x + y using the reduce() method on the stream of nums. The lambda expression takes two integers x and y as input and adds them using the + operator.

The reduce() method applies the lambda expression to each element in the stream, performing the addition operation. The initial reduction value is set to 0.

We store the sum result in the sum variable, which is an integer.

### 13. Write a Java program to implement a lambda expression to count words in a sentence.
```java
public class Main {
  public static void main(String[] args) {
    String text = "Java lambda expression.";
    System.out.println("Original string: " + text);
    WordCounter wordCounter = s -> s.split("\\s+").length;
    int ctr = wordCounter.countWords(text);
    System.out.println("Word count: " + ctr);
    text = "The quick brown fox jumps over the lazy dog.";
    System.out.println("\nOriginal string: " + text);
    wordCounter = s -> s.split("\\s+").length;
    ctr = wordCounter.countWords(text);
    System.out.println("Word count: " + ctr);
  }
}

@FunctionalInterface
interface WordCounter {
  int countWords(String text);
}
```
Sample Output:

Original string: Java lambda expression.
Word count: 3

Original string: The quick brown fox jumps over the lazy dog.
Word count: 9
Explanation:

In the above code the wordCounter variable is assigned a lambda expression that splits the input string by whitespace (\\s+) and counts the number of resulting substrings using the length method. The countWords method of the wordCounter instance is then called with the text string. The result is stored in the "ctr" variable. Finally, the word count is printed to the console.

### 14. Write a Java program to implement a lambda expression to check if a given string is a palindrome.
```java
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    // Define the palindrome check lambda expression
    Predicate < String > isPalindrome = str -> {
      String reversed = new StringBuilder(str).reverse().toString();
      return str.equals(reversed);
    };

    // Check if a string is a palindrome using the lambda expression
    String word1 = "Madam";
    boolean isPalindromeResult1 = isPalindrome.test(word1);
    System.out.println(word1 + " is a palindrome? " + isPalindromeResult1);

    String word2 = "radar";
    isPalindromeResult1 = isPalindrome.test(word2);
    System.out.println(word2 + " is a palindrome? " + isPalindromeResult1);

    String word3 = "defied";
    isPalindromeResult1 = isPalindrome.test(word3);
    System.out.println(word3 + " is a palindrome? " + isPalindromeResult1);
  }
}
```
Sample Output:

Madam is a palindrome? false
radar is a palindrome? true
defied is a palindrome? false

Explanation:

In the above exercise -

From the java.util.function package, we import Predicate.
In the main method, we define a lambda expression str -> { ... } to check if a string is a palindrome.
Inside the lambda expression, we create a reversed version of the input string by using a StringBuilder to reverse the characters. We convert it back to a string using toString().
Compare the original string with the reversed string using the equals() method. Return true if they are equal, indicating that the string is a palindrome. Otherwise, it returns false.
Create an instance of the Predicate interface called isPalindrome and assign the lambda expression to it.
Test the lambda expression by checking some strings are palindromes or not using the test() method on the isPalindrome predicate.

### 15. Write a Java program to implement a lambda expression to calculate the sum of squares of all odd and even numbers in a list.
```java
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Create a list of integers
    List < Integer > nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("Original list elements: " + nums);
    // Calculate the sum of squares of odd numbers using lambda expression
    int sum_squares_odd = nums.stream()
      .filter(n -> n % 2 != 0)
      .mapToInt(n -> n * n)
      .sum();

    // Calculate the sum of squares of even numbers using lambda expression
    int sum_squares_even = nums.stream()
      .filter(n -> n % 2 == 0)
      .mapToInt(n -> n * n)
      .sum();

    // Print the results
    System.out.println("\nSum of squares of odd numbers: " + sum_squares_odd);
    System.out.println("\nSum of squares of even numbers: " + sum_squares_even);
  }
}
```
Sample Output:

Original list elements: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Sum of squares of odd numbers: 165

Sum of squares of even numbers: 220
Explanation:

The necessary classes are imported: Arrays and Lists.


In the main method, we create a list of integers called nums using Arrays.asList().

A lambda expression is used to calculate the sum of squares of odd numbers:

Use the stream() method to create a stream of integers from the nums list.
Use the filter() method to filter out odd numbers by checking if the remainder of dividing the number by 2 is not equal to 0.
Use the mapToInt() method to square each odd number.
Use the sum() method to calculate the sum of squares of odd numbers.
Store the result in the variable sum_squares_odd.
A similar lambda expression is used to calculate the sum of squares of even numbers:

Use the filter() method to filter out even numbers by checking if the remainder of dividing the number by 2 is equal to 0.
Store the result in the variable sum_squares_even.
Finally, System.out.println() function prints the result.

### 16. Write a Java program to implement a lambda expression to check if a list of strings contains a specific word.
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    // Create a list of strings
    List < String > colors = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");

    // Specify the word to search for
    String searchColor = "Orange";

    // Check if the list contains the specified color using a lambda expression
    Predicate < String > containsWord = word -> word.equals(searchColor);
    boolean flag = colors.stream().anyMatch(containsWord);

    // Print the result
    System.out.println("Is the word " + searchColor + " present in the list? " + flag);

    // Specify the word to search for   
    String searchColor1 = "White";

    // Check if the list contains the specified color using a lambda expression
    Predicate < String > containsWord1 = word -> word.equals(searchColor1);
    flag = colors.stream().anyMatch(containsWord1);

    // Print the result
    System.out.println("\nIs the word " + searchColor1 + " present in the list? " + flag);
  }
}
```
Sample Output:

Is the word Orange present in the list? true

Is the word White present in the list? false
Explanation:

In the above exercise -

Import the necessary classes: Arrays, List, and Predicate.
In the main method, we create a list of strings called colors using Arrays.asList().
Specify the word we want to search for by assigning it to the variable searchColor.
Define a lambda expression to check if a string equals the searchColor using the Predicate functional interface. The lambda expression compares each string with the searchColor using the equals() method.
Use the stream() method on the colors list to create a stream of strings.
Use the anyMatch() method along with the containsWord predicate to check if any element in the stream matches the predicate.
The result of the anyMatch() operation is stored in the boolean variable flag.
Finally, we print the result, indicating whether the list contains the specified color.

### 17. Write a Java program to implement a lambda expression to find the length of the longest and smallest string in a list.
```java
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Create a list of colors
    List < String > colors = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");

    // Print the elements of the list
    System.out.println("Elements of the list: " + colors);

    // Find the length of the longest string using lambda expression
    int max_length = colors.stream()
      .mapToInt(String::length)
      .max()
      .orElse(0);
    // Print the length of the longest string
    System.out.println("Length of the longest string: " + max_length);

    // Find the length of the smallest string using lambda expression
    int min_length = colors.stream()
      .mapToInt(String::length)
      .min()
      .orElse(0);
    // Print the length of the smallest string
    System.out.println("Length of the smallest string: " + min_length);
  }
}
```
Sample Output:

Elements of the list: [Red, Green, Blue, Orange, Black]
Length of the longest string: 6
Length of the smallest string: 3
Explanation:

In the above exercise,

Import the necessary classes: Arrays and List.
In the main method, we create a list of colors called colors using Arrays.asList().
Use the stream() method on the colors list to create a stream of strings.
Use the mapToInt() method to map each string to its integer length.
The max() method is used to get the maximum length of a stream of integers.
The min() method is used to get the minimum length among a stream of integers.
The orElse() method is used to provide a default value of 0 in case the stream is empty.
Finally, we print the length of the longest and smallest string.

### 18. Write a Java program to implement a lambda expression to check if a given number is a perfect square.

Write a Java program to implement a lambda expression to check if a given number is a perfect square.

Note: A perfect square is an element of algebraic structure that is equal to the square of another element.

Sample Solution:

Java Code:
```java
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    // Define the perfect square check lambda expression
    Predicate < Integer > isPerfectSquare = n -> {
      int sqrt = (int) Math.sqrt(n);
      return sqrt * sqrt == n;
    };

    // Test the lambda expression with some numbers
    int N = 36;
    boolean result1 = isPerfectSquare.test(N);
    System.out.println(N + " is a perfect square? " + result1);

    N = 26;
    boolean result2 = isPerfectSquare.test(N);
    System.out.println(N + " is a perfect square? " + result2);

    N = 10000;
    boolean result3 = isPerfectSquare.test(N);
    System.out.println(N + " is a perfect square? " + result3);
  }
}
```
Sample Output:

36 is a perfect square? true
26 is a perfect square? false
10000 is a perfect square? true
Explanation:

In the above exercise,

Import the Predicate functional interface.
In the main method, we define the lambda expression isPerfectSquare, which takes an integer N.
The lambda expression checks if the square of the square root of n is equal to n. If it is, then N is a perfect square.
We test the lambda expression by calling the test method with different numbers.
Finally, we print the results to the console.

### 19. Write a Java program to implement a lambda expression to find the second largest and smallest element in an array.
```java
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    // Create an array of integers
    Integer[] nums = {
      1,
      7,
      18,
      25,
      77,
      300,
      101
    };
    System.out.println("Array elements: " + Arrays.toString(nums));
    // Find the second largest element using lambda expression
    Integer secondLargest = Arrays.stream(nums)
      .distinct()
      .sorted(Comparator.reverseOrder())
      .skip(1)
      .findFirst()
      .orElse(null);

    // Find the second smallest element using lambda expression
    Integer secondSmallest = Arrays.stream(nums)
      .distinct()
      .sorted()
      .skip(1)
      .findFirst()
      .orElse(null);

    // Print the results
    System.out.println("Second largest element: " + secondLargest);
    System.out.println("Second smallest element: " + secondSmallest);
  }
}
```
Sample Output:

Array elements: [1, 7, 18, 25, 77, 300, 101]
Second largest element: 101
Second smallest element: 7
Explanation:

In the above exercise,

Import the necessary classes Arrays and Comparator.
In the main method, we create an array of integers named numbers.
To find the second largest element:

Use the Arrays.stream method to convert the array into a stream of integers.
Apply the distinct operation to remove any duplicate elements.
Sort the elements in reverse order using Comparator.reverseOrder().
Skip the first element (the largest) using skip(1).
Find the first element remaining, which will be the second largest, using findFirst().
If the stream is empty, we return null using orElse(null).
The result is stored in the variable secondLargest.
To find the second smallest element:

Follow a similar process as above, but this time we sort the elements in ascending order using the default comparator.
The result is stored in the variable secondSmallest.
Finally, we print the second largest and second smallest elements to the console.

### 20. Write a Java program to implement a lambda expression to sort a list of objects based on a specific attribute.
```java
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Create a list of objects
    List < Student > student_list = new ArrayList < > ();
    student_list.add(new Student("Adriana Jamie", 15, "X"));
    student_list.add(new Student("Felix Uisdean", 15, "X"));
    student_list.add(new Student("Conceicao Palmira", 14, "X"));
    student_list.add(new Student("Jair Camila", 14, "X"));
    student_list.add(new Student("Micaela Rosana", 15, "X"));

    // Student details
    System.out.println("Student details:");
    for (Student Student: student_list) {
      System.out.println(Student.getName() + " - " + Student.getAge() + " - " + Student.getSClass());
    }

    // Sort the list based on age using lambda expression
    student_list.sort(Comparator.comparing(Student::getName));

    // Print the sorted list
    System.out.println("\nSorted list based on Student Name:");
    for (Student Student: student_list) {
      System.out.println(Student.getName() + " - " + Student.getAge() + " - " + Student.getSClass());
    }
  }
}

class Student {
  private String name, SClass;
  private int age;
  public Student(String name, int age, String SClass) {
    this.name = name;
    this.age = age;
    this.SClass = SClass;
  }
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
  public String getSClass() {
    return SClass;
  }
}
```
Sample Output:

Student details:
Adriana Jamie - 15 - X
Felix Uisdean - 15 - X
Conceicao Palmira - 14 - X
Jair Camila - 14 - X
Micaela Rosana - 15 - X

Sorted list based on Student Name:
Adriana Jamie - 15 - X
Conceicao Palmira - 14 - X
Felix Uisdean - 15 - X
Jair Camila - 14 - X
Micaela Rosana - 15 - X
Explanation:

In the above exercise,

A student's name, age, and class are represented in the Student class.
The main method creates a list called student_list to store Student objects.
A number of Student objects are added to the student_list by using the add method.
By using a lambda expression and the sort method, the student_list is sorted by name.
The lambda expression Comparator.comparing(Student::getName) specifies the attribute to compare, which is the student's name in this case.

### 21. Write a Java program to implement a lambda expression to calculate the sum of all prime numbers in a given range.

Write a Java program to implement a lambda expression to calculate the sum of all prime numbers in a given range.

Note: A prime number (or a prime) is a natural number greater than 1 that is not a product of two smaller natural numbers. A natural number greater than 1 that is not prime is called a composite number. For example, 5 is prime because the only ways of writing it as a product, 1 × 5 or 5 × 1, involve 5 itself. However, 4 is composite because it is a product (2 × 2) in which both numbers are smaller than 4. Primes are central in number theory because of the fundamental theorem of arithmetic: every natural number greater than 1 is either a prime itself or can be factorized as a product of primes that is unique up to their order.

Sample Solution:

Java Code:
```java
import java.util.stream.IntStream;

 public class Main {
   public static void main(String[] args) {
     int start_prime = 100;
     int end_prime = 200;

     // Calculate the sum of prime numbers using lambda expression
     int sumOfPrimes = IntStream.rangeClosed(start_prime, end_prime)
       .filter(Main::isPrime)
       .sum();
     System.out.println("Sum of prime numbers between " + start_prime + " and " + end_prime + ": " + sumOfPrimes);
   }
   // Lambda expression to check if a number is prime
   public static boolean isPrime(int number) {
     if (number <= 1) {
       return false;
     }
     for (int i = 2; i <= Math.sqrt(number); i++) {
       if (number % i == 0) {
         return false;
       }
     }
     return true;
   }
 }
 ```
Sample Output:

Sum of prime numbers between 100 and 200: 3167
Explanation:

In the above exercise,

The start_prime and end_primevariables define the range of numbers within which we want to calculate the sum of prime numbers.
The lambda expression Main::isPrime filters out non-prime numbers from the range of numbers.
The isPrime method is a lambda expression itself, which checks whether a given number is prime or not using a simple algorithm.b.

### 22. Write a Java program to implement a lambda expression to check if a list of strings are all uppercase or all lowercase or mixedcase.
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    List < String > strings = Arrays.asList("Java", "JAVA", "java");
    System.out.println("Array elements: " + strings);
    // Check if the list is all uppercase using lambda expression
    boolean isAllUppercase = checkCase(strings, s -> s.equals(s.toUpperCase()), String::toUpperCase);
    System.out.println("Is all uppercase? " + isAllUppercase);

    // Check if the list is all lowercase using lambda expression
    boolean isAllLowercase = checkCase(strings, s -> s.equals(s.toLowerCase()), String::toLowerCase);
    System.out.println("Is all lowercase? " + isAllLowercase);

    // Check if the list is mixed case
    boolean isMixedCase = !isAllUppercase && !isAllLowercase;
    System.out.println("Is mixed case? " + isMixedCase);

    List < String > strings1 = Arrays.asList("JAVA", "PYTHON", "ABC");
    System.out.println("\nArray elements: " + strings1);
    // Check if the list is all uppercase using lambda expression
    isAllUppercase = checkCase(strings1, s -> s.equals(s.toUpperCase()), String::toUpperCase);
    System.out.println("Is all uppercase? " + isAllUppercase);

    // Check if the list is all lowercase using lambda expression
    isAllLowercase = checkCase(strings1, s -> s.equals(s.toLowerCase()), String::toLowerCase);
    System.out.println("Is all lowercase? " + isAllLowercase);

    // Check if the list is mixed case
    isMixedCase = !isAllUppercase && !isAllLowercase;
    System.out.println("Is mixed case? " + isMixedCase);

    List < String > strings2 = Arrays.asList("java");
    System.out.println("\nArray elements: " + strings2);
    // Check if the list is all uppercase using lambda expression
    isAllUppercase = checkCase(strings2, s -> s.equals(s.toUpperCase()), String::toUpperCase);
    System.out.println("Is all uppercase? " + isAllUppercase);

    // Check if the list is all lowercase using lambda expression
    isAllLowercase = checkCase(strings2, s -> s.equals(s.toLowerCase()), String::toLowerCase);
    System.out.println("Is all lowercase? " + isAllLowercase);

    // Check if the list is mixed case
    isMixedCase = !isAllUppercase && !isAllLowercase;
    System.out.println("Is mixed case? " + isMixedCase);

  }
  public static boolean checkCase(List < String > strings, Predicate < String > checkFunction, Function < String, String > convertFunction) {
    String firstString = strings.get(0);
    String convertedString = convertFunction.apply(firstString);

    return strings.stream()
      .allMatch(s -> checkFunction.test(s));
  }
}
```
Sample Output:

Array elements: [Java, JAVA, java]
Is all uppercase? false
Is all lowercase? false
Is mixed case? true

Array elements: [JAVA, PYTHON, ABC]
Is all uppercase? true
Is all lowercase? false
Is mixed case? false

Array elements: [java]
Is all uppercase? false
Is all lowercase? true
Is mixed case? false
Explanation:

In the above exercise -

The main() method:

Creates a list of strings named strings.
Calls the checkCase method to perform case checks and prints the results.
The checkCase() method:

Takes three parameters: the list of strings to check, a Predicate<String> to define the case check condition, and a Function<String, String> to convert the first string for comparison.
Retrieves the first string from the list using strings.get(0) and assigns it to firstString.
Apply the conversion function convertFunction to firstString and assign the result to convertedString.
Use the stream() method in the strings list to create a stream of strings.
Apply the allMatch intermediate operation on the stream and provide a lambda expression as the condition to check if all strings satisfy the given predicate checkFunction.
Returns the result of the allMatch operation, which indicates whether all strings in the list pass the case check.

### 23. Write a Java program to implement a lambda expression to find the average length of strings in a list.
```java
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List <String> colors = Arrays.asList("Red", "Black", "White", "Orange", "Blue");
    System.out.println("List of colors: " + colors);

    double averageLength = calculateAverageLength(colors);
    System.out.println("Average length of colors(strings): " + averageLength);
  }

  public static double calculateAverageLength(List < String > strings) {
    return strings.stream()
      .mapToInt(String::length) // Convert each string to its length
      .average() // Calculate the average
      .orElse(0); // If the list is empty, return 0 as the default value
  }
}
```
Sample Output:

List of colors: [Red, Black, White, Orange, Blue]
Average length of colors(strings): 4.6
Explanation:

In the above exercise,

The main() method creates a list of strings (strings) containing four elements.


Following are the steps taken by the calculateAverageLength method when given a list of strings:

The stream() method is used on the strings list to create a stream of strings.
The mapToInt method converts each string to its length by using a method reference String::length.
The average method calculates the average length of the strings in the stream.
The orElse method is used to provide a default value of 0 if the list is empty.
The calculated average length is returned by the calculateAverageLength method and stored in the averageLength variable.

### 24. Write a Java program to implement a lambda expression to find the largest prime factor of a given number.
```java
import java.util.stream.LongStream;

public class Main {
  public static void main(String[] args) {
    int n = 176;
    System.out.println("Number: " + n);

    long largestPrimeFactor = findLargestPrimeFactor(n);
    System.out.println("Largest prime factor: " + largestPrimeFactor);
    n = 36;
    System.out.println("\nNumber: " + n);

    largestPrimeFactor = findLargestPrimeFactor(n);
    System.out.println("Largest prime factor: " + largestPrimeFactor);
  }

  public static long findLargestPrimeFactor(long n) {
    for (long i = (long) Math.sqrt(n); i >= 2; i--) {
      if (n % i == 0 && isPrime(i)) {
        return i;
      }
    }
    return n;
  }

  public static boolean isPrime(long number) {
    return LongStream.rangeClosed(2, (long) Math.sqrt(number))
      .allMatch(n -> number % n != 0);
  }
}
```
Sample Output:

Number: 176
Largest prime factor: 11

Number: 36
Largest prime factor: 3
Explanation:

Main() method:

Initializes a variable n with a value.
Calls the findLargestPrimeFactor() method to calculate the largest prime factor of n.
Prints the largest prime factor.
findLargestPrimeFactor(long n) method :

It takes a long integer n as input.
It iterates from the square root of n (converted to a long) downwards to 2.
Inside the loop, it checks if n is divisible by the current value of i and if i is a prime number by calling the isPrime method.
If both conditions are satisfied, it returns i, which is the largest prime factor.
If no prime factors are found, it returns the original number n.
isPrime(long number):

It takes a long integer number as input.
It uses a LongStream to generate a range of numbers from 2 to the square root of number, inclusive.
It checks if all numbers in the range satisfy the condition that number is not divisible evenly by any of them.
If all numbers in the range satisfy the condition, it returns true, indicating that number is a prime number.
If any number in the range divides number evenly, it returns false.

### 25. Write a Java program to implement a lambda expression to convert an integer to their corresponding binary representation.
```java
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    int n = 33;
    System.out.println("Number: " + n);

    Function < Integer, String > convertToBinary = num -> Integer.toBinaryString(num);
    String binaryRepresentation = convertToBinary.apply(n);
    System.out.println("Binary representation: " + binaryRepresentation);
    n = 747;
    System.out.println("\nNumber: " + n);
    convertToBinary = num -> Integer.toBinaryString(num);
    binaryRepresentation = convertToBinary.apply(n);
    System.out.println("Binary representation: " + binaryRepresentation);
  }
}
```
Sample Output:

Number: 33
Binary representation: 100001

Number: 747
Binary representation: 1011101011
Explanation:

In the above exercise the program uses the Integer.toBinaryString() method to convert an integer to its binary representation. The lambda expression allows you to encapsulate this conversion logic and use it as a function.

The lambda expression:

It takes an integer as input (num).
It uses the Integer.toBinaryString() method to convert the integer to its binary representation.
It returns the binary representation as a string.
