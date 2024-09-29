# Java Exercises Recursive

### 1. Write a Java recursive method to calculate the factorial of a given positive integer.

```java
public class FactorialCalculator {

  public static int calculateFactorial(int n) {
    // Base case: factorial of 0 is 1
    if (n == 0) {
      return 1;
    }

    // Recursive case: multiply n with factorial of (n-1)
    return n * calculateFactorial(n - 1);
  }

  public static void main(String[] args) {
    int number = 7;
    int factorial = calculateFactorial(number);
    System.out.println("Factorial of " + number + " is: " + factorial);
    number = 12;
    factorial = calculateFactorial(number);
    System.out.println("\nFactorial of " + number + " is: " + factorial);
  }
}
```
> Sample Output:

> Factorial of 7 is: 5040

> Factorial of 12 is: 479001600

Explanation:

In the above exercises -

First, we define a class "FactorialCalculator" that includes a recursive method calculateFactorial() to calculate the factorial of a given positive integer n.

The calculateFactorial() method follows the recursive factorial definition. It has two cases:

*Base case*: If n is 0, it returns 1. This is the termination condition for recursion.

*Recursive case*: For any positive n, it multiplies n with the factorial of n-1. This step is repeated recursively until n reaches 0.

In the main() method, we demonstrate the calculateFactorial() method by calculating the factorial of 7 and 12.

### 2. Write a Java recursive method to calculate the sum of all numbers from 1 to n.
```java
public class SumCalculator {

  public static int calculateSum(int n) {
    // Base case: sum of 0 is 0
    if (n == 0) {
      return 0;
    }

    // Recursive case: add n with the sum of (n-1)
    return n + calculateSum(n - 1);
  }

  public static void main(String[] args) {
    int number = 7;
    int sum = calculateSum(number);
    System.out.println("Sum of numbers from 1 to " + number + " is: " + sum);
  }
}
```
> Sample Output:

> Sum of numbers from 1 to 7 is: 28

Explanation:

In the above exercises -

The calculateSum() method follows the recursive definition of the sum. It has two cases:

*Base case*: If the input n is 0, it returns 0. This is the termination condition for recursion.

*Recursive case*: For any positive n, it adds n with the sum of the numbers from 1 to n-1. This step is repeated recursively until n reaches 0

In the main() method, we demonstrate the calculateSum() method by calculating the sum of numbers from 1 to 7 and printing the result.

### 3. Write a Java recursive method to calculate the nth Fibonacci number.
```java
public class FibonacciCalculator {

  public static int calculateFibonacci(int n) {
    // Base case: Fibonacci numbers at positions 0 and 1 are 0 and 1, respectively
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    // Recursive case: sum of the previous two Fibonacci numbers
    return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
  }

  public static void main(String[] args) {
    int position = 0;
    int fibonacciNumber = calculateFibonacci(position);
    System.out.println("The Fibonacci number at position " + position + " is: " + fibonacciNumber);
    position = 3;
    fibonacciNumber = calculateFibonacci(position);
    System.out.println("\nThe Fibonacci number at position " + position + " is: " + fibonacciNumber);
    position = 9;
    fibonacciNumber = calculateFibonacci(position);
    System.out.println("\nThe Fibonacci number at position " + position + " is: " + fibonacciNumber);
  }
}
```
> Sample Output:

> The Fibonacci number at position 0 is: 0

> The Fibonacci number at position 3 is: 2

> The Fibonacci number at position 9 is: 34

Explanation:

In the above exercises -

The "calculateFibonacci()" method follows the recursive definition of the Fibonacci sequence. It has two cases:

case 1: If n is 0, it returns 0.
case 2: If n is 1, it returns 1.
These are the termination conditions for recursion.


For any positive n greater than 1, the method recursively calculates the Fibonacci number by summing the previous two Fibonacci numbers (calculated using the same method). This process is repeated until n reaches one of the base cases.

In the main() method, we demonstrate the calculateFibonacci() method by calculating the Fibonacci number at position 8 and printing the result.

### 4. Write a Java recursive method to check if a given string is a palindrome.
```java
public class PalindromeChecker {

  public static boolean isPalindrome(String str) {
    // Base case: an empty string or a string with one character is a palindrome
    if (str.length() <= 1) {
      return true;
    }

    // Recursive case: check if the first and last characters are equal,
    // and recursively check if the substring between them is a palindrome
    char firstChar = str.charAt(0);
    char lastChar = str.charAt(str.length() - 1);

    if (firstChar != lastChar) {
      return false;
    }

    String remainingSubstring = str.substring(1, str.length() - 1);
    return isPalindrome(remainingSubstring);
  }

  public static void main(String[] args) {
    String palindrome1 = "madam";
    boolean isPalindrome1 = isPalindrome(palindrome1);
    System.out.println(palindrome1 + " is a palindrome: " + isPalindrome1);

    String palindrome2 = "level";
    boolean isPalindrome2 = isPalindrome(palindrome2);
    System.out.println(palindrome2 + " is a palindrome: " + isPalindrome2);

    String notPalindrome = "java";
    boolean isPalindrome3 = isPalindrome(notPalindrome);
    System.out.println(notPalindrome + " is a palindrome: " + isPalindrome3);
  }
}
```
> Sample Output:

> madam is a palindrome: true
> 
> level is a palindrome: true
> 
> java is a palindrome: false

Explanation:

In the above exercises -

We define a class "PalindromeChecker" that includes a recursive method isPalindrome() to check if a given string str is a palindrome.

The isPalindrome() method has two cases:

*Base case*: If the string length is 0 or 1, it returns true because an empty string or a string with one character is considered a palindrome.

*Recursive case*: It compares the first and last characters of the string. If they are not equal, it returns false. Otherwise, it extracts the remaining substring between the first and last characters, and recursively checks if this substring is a palindrome. This process continues until the string is reduced to an empty string or one character.

In the main() method, we demonstrate the isPalindrome() method by checking if different strings are palindromes and printing the results.

### 5. Write a Java recursive method to calculate the exponentiation of a number (base) raised to a power (exponent).
```java
public class ExponentiationCalculator {

  public static double calculateExponentiation(double base, int exponent) {
    // Base case: any number raised to the power of 0 is 1
    if (exponent == 0) {
      return 1;
    }

    // Recursive case: multiply the base with the exponentiation of (base, exponent-1)
    return base * calculateExponentiation(base, exponent - 1);
  }

  public static void main(String[] args) {
    double base = 3.5;
    int exponent = 4;
    double result = calculateExponentiation(base, exponent);
    System.out.println(base + " raised to the power of " + exponent + " is: " + result);
  }
}
```
> Sample Output:

> 3.5 raised to the power of 4 is: 150.0625

Explanation:

In the above exercises -

The "calculateExponentiation()" method follows the recursive definition of exponentiation. It has two cases:

*Base case*: If the exponent is 0, it returns 1. This is because any number raised to the power of 0 is equal to 1.

*Recursive case*: For any positive exponent "exponent", it multiplies the base with the exponentiation of the same base raised to the power of exponent-1. This process is repeated recursively until the exponent reaches 0.

In the main() method, we demonstrate the calculateExponentiation() method by calculating the exponentiation of a base number (3.5) raised to a power (4) and printing the result.

### 6. Write a Java recursive method to reverse a given string.
```java
public class StringReverser {

  public static String reverseString(String str) {
    // Base case: if the string is empty or has only one character, it is already reversed
    if (str.isEmpty() || str.length() == 1) {
      return str;
    }

    // Recursive case: reverse the substring starting from the second character and concatenate the first character
    return reverseString(str.substring(1)) + str.charAt(0);
  }

  public static void main(String[] args) {
    String input = "Java, World!";
    String reversed = reverseString(input);
    System.out.println("Original string: " + input);
    System.out.println("Reversed string: " + reversed);
  }
}
```
> Sample Output:

> Original string: Java, World!
> Reversed string: !dlroW ,avaJ

Explanation:

In the above exercises -

First, we define a class "StringReverser" that includes a recursive method reverseString() to reverse a given string str.

The reverseString() method has two cases:

*Base case*: If the string is empty or has only one character, it is already reversed, so we return the original string.

*Recursive case*: For any string with length greater than 1, we recursively reverse the substring starting with the second character and concatenate the first character at the end. This process continues until the string is reduced to an empty string or one character.

In the main() method, we demonstrate the reverseString() method by reversing the string "Java, World!" and printing both the original and reversed strings.

### 7. Write a Java recursive method to find the greatest common divisor (GCD) of two numbers.
```java
public class GCDCalculator {

  public static int calculateGCD(int num1, int num2) {
    // Base case: if the second number is 0, the GCD is the first number
    if (num2 == 0) {
      return num1;
    }

    // Recursive case: calculate the GCD by recursively calling the method with num2 as the new num1 and the remainder as num2
    int remainder = num1 % num2;
    return calculateGCD(num2, remainder);
  }

  public static void main(String[] args) {
    int number1 = 16;
    int number2 = 18;
    int gcd = calculateGCD(number1, number2);
    System.out.println("The GCD of " + number1 + " and " + number2 + " is: " + gcd);
  }
}
```
> Sample Output:

> The GCD of 16 and 18 is: 2

Explanation:

In the above exercises -

First, we define a class GCDCalculator that includes a recursive method calculateGCD() to find the greatest common divisor (GCD) of two numbers.

The calculateGCD() method follows the recursive GCD definition. It has two cases:

*Base case*: If the second number (num2) is 0, the GCD is the first number (num1). This is because any number divided by 0 is the number itself.

*Recursive case*: For any two numbers (num1 and num2), we calculate the remainder when num1 is divided by num2. We then recursively call the method with num2 as the new num1 and the remainder as num2. This process continues until num2 reaches 0.

In the main() method, we demonstrate the calculateGCD() method by finding the GCD of two numbers (16 and 18) and printing the result.

### 8. Write a Java recursive method to count the number of occurrences of a specific element in an array.
```java
public class ArrayElementCounter {

  public static < T > int countOccurrences(T[] arr, T target) {
    return countOccurrences(arr, target, 0);
  }

  private static < T > int countOccurrences(T[] arr, T target, int index) {
    // Base case: if the index reaches the end of the array, return 0
    if (index == arr.length) {
      return 0;
    }

    // Recursive case: check if the element at the current index is equal to the target,
    // and recursively call the method with the next index and add 1 if it is equal
    int count = countOccurrences(arr, target, index + 1);
    if (arr[index].equals(target)) {
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    Integer[] numbers = {
      10,
      20,
      30,
      40,
      20,
      50,
      20,
      60
    };
    int target = 20;
    int occurrences = countOccurrences(numbers, target);
    System.out.println("The number of occurrences of " + target + " in the array is: " + occurrences);
  }
}
```
> Sample Output:

> The number of occurrences of 20 in the array is: 3

Explanation:

In the above exercises -

First, we define a class "ArrayElementCounter" that includes a recursive method countOccurrences() to count the number of occurrences of a specific element target in an array arr.

The countOccurrences() method has two cases:

*Base case*: If the index reaches the end of the array (index == arr.length), we return 0 as there are no more elements to check.

*Recursive case*: For any index that is within the bounds of the array, we check if the element at that index is equal to the target. We then recursively call the method with the next index and add 1 to the count if the element is equal to the target. This process continues until we reach the end of the array.

In the main() method, we demonstrate the usage of the countOccurrences() method by counting the number of occurrences of the number 20 in the array {10, 20, 30, 40, 20, 50, 20, 60}and printing the result.

### 9. Write a Java recursive method to find the sum of all odd numbers in an array.
```java
public class OddNumberSumCalculator {

  public static int calculateOddNumberSum(int[] arr) {
    return calculateOddNumberSum(arr, 0);
  }

  private static int calculateOddNumberSum(int[] arr, int index) {
    // Base case: if the index reaches the end of the array, return 0
    if (index == arr.length) {
      return 0;
    }

    // Recursive case: check if the element at the current index is odd,
    // and recursively call the method with the next index and add the current element if it is odd
    int sum = calculateOddNumberSum(arr, index + 1);
    if (arr[index] % 2 != 0) {
      sum += arr[index];
    }

    return sum;
  }

  public static void main(String[] args) {
    int[] numbers = {
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9
    };
    int sum = calculateOddNumberSum(numbers);
    System.out.println("The sum of all odd numbers in the array is: " + sum);
  }
}
```
> Sample Output:

> The sum of all odd numbers in the array is: 25

Explanation:

In the above exercises -

First, we define a class OddNumberSumCalculator that includes a recursive method calculateOddNumberSum() to find the sum of all odd numbers in an array.

The calculateOddNumberSum() method has two cases:

*Base case*: If the index reaches the end of the array (index == arr.length), we return 0 as there are no more elements to check.

*Recursive case*: For any index that is within the bounds of the array, we check if the element at that index is odd. We then recursively call the method with the next index and add the current element to the sum if it is odd. This process continues until we reach the end of the array.

In the main() method, we demonstrate the calculateOddNumberSum() method by finding the sum of all odd numbers in the array [1, 2, 3, 4, 5, 6, 7, 8, 9] and printing the result.

### 10. Write a Java recursive method to find the length of a given string.
```java
public class StringLengthCalculator {

  public static int calculateStringLength(String str) {
    // Base case: if the string is empty, the length is 0
    if (str.isEmpty()) {
      return 0;
    }

    // Recursive case: remove the first character of the 
    // string and recursively call the method
    // with the remaining substring, and add 1 to the length
    return 1 + calculateStringLength(str.substring(1));
  }

  public static void main(String[] args) {
    String input = "Java Exercises!";
    int length = calculateStringLength(input);
    System.out.println("The length of the string \"" + input + "\" is: " + length);
  }
}
```
> Sample Output:

> The length of the string "Java Exercises!" is: 15

Explanation:

In the above exercises -

First, we define a class "StringLengthCalculator" that includes a recursive method calculateStringLength() to find the length of a given string str.

The calculateStringLength() method has two cases:

*Base case*: If the string is empty (str.isEmpty()), we return 0 as the length of an empty string is 0.

*Recursive case*: For any non-empty string, we remove the first character using str.substring(1) and recursively call the method with the remaining substring. We then add 1 to the length calculated from the recursive call. This process continues until the string is reduced to an empty string.

In the main() method, we demonstrate the calculateStringLength() method by finding the length of the string " Hello, World!" and printing the result.

### 11. Write a Java recursive method to generate all possible permutations of a given string.
```java
import java.util.ArrayList;
import java.util.List;

public class StringPermutationGenerator {

  public static List < String > generatePermutations(String str) {
    List < String > permutations = new ArrayList < > ();
    generatePermutationsHelper(str, "", permutations);
    return permutations;
  }

  private static void generatePermutationsHelper(String str, String current, List < String > permutations) {
    // Base case: if the string is empty, add the current permutation to the list
    if (str.isEmpty()) {
      permutations.add(current);
      return;
    }

    // Recursive case: for each character in the string, generate permutations by
    // appending the character to the current permutation, and recursively call the method
    // with the remaining characters as the new string
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String remaining = str.substring(0, i) + str.substring(i + 1);
      generatePermutationsHelper(remaining, current + ch, permutations);
    }
  }

  public static void main(String[] args) {
    String input = "abc";
    List < String > permutations = generatePermutations(input);
    System.out.println("Permutations of \"" + input + "\":");
    for (String permutation: permutations) {
      System.out.println(permutation);
    }
  }
}
```
> Sample Output:

> Permutations of "abc":
> abc
> acb
> bac
> bca
> cab
> cba

Explanation:

In the above exercises -

First, we define a class "StringPermutationGenerator" that includes a recursive method generatePermutations() to generate all possible permutations of a given string str.

The generatePermutations() method has two cases:

*Base case*: If the string is empty (str.isEmpty()), we add the current permutation (current) to the list of permutations.

*Recursive case*: For any non-empty string, we iterate through each character in the string and generate permutations by appending the character to the current permutation. We then recursively call the method with the remaining characters as the new string. This process continues until the string is reduced to an empty string.

In the main() method, we demonstrate the generatePermutations() method by generating all possible permutations of the string "abc" and printing the result.

### 12. Write a Java recursive method to find the maximum element in an array.
```java
import java.util.Arrays;
public class ArrayMaxElementFinder {

  public static int findMaxElement(int[] arr) {
    return findMaxElement(arr, 0, arr.length - 1);
  }

  private static int findMaxElement(int[] arr, int left, int right) {
    // Base case: if the left and right indices are equal, 
    // we have a single element and return it as the maximum
    if (left == right) {
      return arr[left];
    }

    // Recursive case: divide the array into two halves, recursively 
    //find the maximum in each half,and return the greater of the 
    // two maximums
    int mid = (left + right) / 2;
    int maxLeft = findMaxElement(arr, left, mid);
    int maxRight = findMaxElement(arr, mid + 1, right);

    return Math.max(maxLeft, maxRight);
  }

  public static void main(String[] args) {
    int[] array = {
      34,
      45,
      34,
      23,
      56,
      62,
      27,
      55
    };
    System.out.println("Original Array: " + Arrays.toString(array));
    int maxElement = findMaxElement(array);
    System.out.println("The maximum element in the array is: " + maxElement);
  }
```
> Sample Output:

> Original Array: [34, 45, 34, 23, 56, 62, 27, 55]
> The maximum element in the array is: 62

Explanation:

In the above exercises -

First, we define a class ArrayMaxElementFinder that includes a recursive method findMaxElement() to find the maximum element in an array.

The findMaxElement() method has two cases:

*Base case*: If the left and right indices are equal, we have a single element and return it as the maximum element.

*Recursive case*: For any array with more than one element, we divide the array into two halves by finding the middle index. We then recursively find the maximum element in each half by calling the method with the appropriate indices. Finally, we return the higher value of the two maximums obtained from the recursive calls.

In the main() method, we demonstrate the findMaxElement() method by finding the maximum element in the array [34, 45, 34, 23, 56, 62, 27, 55] and printing the result.

### 13. Write a Java recursive method to calculate the product of all numbers in an array.
```java
public class ArrayProductCalculator {

  public static int calculateProduct(int[] arr) {
    return calculateProduct(arr, 0, arr.length - 1);
  }

  private static int calculateProduct(int[] arr, int left, int right) {
    // Base case: if the left and right indices are equal, 
    // return the single element as the product

    if (left == right) {
      return arr[left];
    }

    // Recursive case: divide the array into two halves, recursively 
    // calculate the product in each half,and return the product of 
    //the two calculated products

    int mid = (left + right) / 2;
    int productLeft = calculateProduct(arr, left, mid);
    int productRight = calculateProduct(arr, mid + 1, right);

    return productLeft * productRight;
  }

  public static void main(String[] args) {
    int[] array = {
      1,
      3,
      5,
      7
    };
    int product = calculateProduct(array);
    System.out.println("The product of all numbers in the array is: " + product);
  }
}
```
> Sample Output:

> The product of all numbers in the array is: 105

Explanation:

In the above exercises -

We define a class "ArrayProductCalculator" that includes a recursive method calculateProduct() to calculate the product of all numbers in an array.

The calculateProduct() method has two cases:

*Base case*: If the left and right indices are equal, we have a single element and return it as the product.

*Recursive case*: For any array with more than one element, we divide the array into two halves by finding the middle index. We then recursively calculate the product in each half by calling the method with the appropriate indices. Finally, we return the product of the two calculated products obtained from the recursive calls.

In the main() method, we demonstrate the calculateProduct() method by calculating the product of all numbers in the array [1, 3, 5, 7] and printing the result.

### 14. Write a Java recursive method to find the sum of the digits of a given integer.
```java
public class DigitSumCalculator {

  public static int calculateDigitSum(int number) {
    // Base case: if the number is a single digit, return the number itself
    if (number < 10) {
      return number;
    }

    // Recursive case: calculate the sum of the last digit and the digit sum of the remaining number
    int lastDigit = number % 10;
    int remainingNumber = number / 10;

    return lastDigit + calculateDigitSum(remainingNumber);
  }

  public static void main(String[] args) {
    int number = 123456;
    int digitSum = calculateDigitSum(number);
    System.out.println("The sum of the digits of " + number + " is: " + digitSum);
  }
}
```
> Sample Output:

> The sum of the digits of 123456 is: 21

Explanation:

In the above exercises -

First, we define a class "DigitSumCalculator" that includes a recursive method calculateDigitSum() to find the sum of the digits of a given integer number.

The calculateDigitSum() method has two cases:

*Base case*: If the number is a single digit (less than 10), we return the number itself as the sum of its digits.

*Recursive case*: For any number with more than one digit, we calculate the last digit by taking the number modulo 10. We then calculate the sum of the last digit and the digit sum of the remaining number obtained by dividing the number by 10. This process continues until the number is reduced to a single digit.

In the main() method, we demonstrate the calculateDigitSum() method by finding the sum of the digits of the number 12345 and printing the result.

### 15. Write a Java recursive method to check if a given array is sorted in ascending order.

```java
import java.util.Arrays;
public class ArraySortChecker {

  public static boolean isSorted(int[] arr) {
    return isSorted(arr, 0);
  }

  private static boolean isSorted(int[] arr, int index) {
    // Base case: if the index reaches the end of the array, 
    // the array is sorted
    if (index == arr.length - 1) {
      return true;
    }

    // Recursive case: check if the element at the current index 
    // is greater than the next element,
    // and recursively call the method with the next index
    if (arr[index] > arr[index + 1]) {
      return false;
    }

    return isSorted(arr, index + 1);
  }

  public static void main(String[] args) {
    int[] array1 = {
      1,
      2,
      3,
      4,
      5
    };
    System.out.println("Original Array: " + Arrays.toString(array1));
    boolean sorted1 = isSorted(array1);
    System.out.println("Is array1 sorted in ascending order? " + sorted1); // Output: true

    int[] array2 = {
      4,
      5,
      3,
      2,
      1
    };
    System.out.println("Original Array: " + Arrays.toString(array2));
    boolean sorted2 = isSorted(array2);
    System.out.println("Is array2 sorted in ascending order? " + sorted2); // Output: false
  }
}
```
> Sample Output:

> Original Array: [1, 2, 3, 4, 5]
> Is array1 sorted in ascending order? true
> Original Array: [4, 5, 3, 2, 1]
> Is array2 sorted in ascending order? false

Explanation:

In the above exercises -

First, we define a class "ArraySortChecker" that includes a recursive method isSorted() to check if a given array arr is sorted in ascending order.

The isSorted() method has two cases:

*Base case*: If the index reaches the end of the array (index == arr.length - 1), we have traversed the entire array and return true to indicate that the array is sorted.

*Recursive case*: For any index that is within the bounds of the array, we check if the element at that index is greater than the next element. If it is, we return false to indicate that the array is not sorted. Otherwise, we recursively call the method with the next index.

In the main() method, we demonstrate the usage of the isSorted() method by checking if two arrays (array1 and array2) are sorted in ascending order and printing the results.
