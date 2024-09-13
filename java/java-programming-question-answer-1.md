# Java Programming Question Answer

<details>
<summary><b> 1. Program to find the sum of all elements in an array</b></summary>
    
```java
public class SumOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        for(int num : arr) {
            sum += num;
        }

        System.out.println("Sum of all elements in the array: " + sum);
    }
}
```

- Using Lambda:

```java
int[] array = {1, 2, 3, 4, 5};

int sum = Arrays.stream(array).sum();

System.out.println("Sum of all elements in the array: " + sum);
```
</details>
<details>
<summary><b> 2. Program to check if a given number is prime or not</b></summary>
    
```java
public class CheckPrimeNumber {
    public static void main(String[] args) {
        int num = 29;
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
```
</details>
<details>
<summary><b> 3. Program to reverse a string</b></summary>
    
```java
public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello World";
        StringBuilder reversedString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }
        System.out.println("Reversed string: " + reversedString.toString());
    }
}
```
</details>
<details>
<summary><b> 4. Program to find the factorial of a number</b></summary>
    
```java
public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + num + ": " + factorial);
    }
}
```
</details>
<details>
<summary><b> 5. Program to implement a stack in Java</b></summary>
    
```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
```
</details>
<details>
<summary><b> 6. Program to sort an array in ascending order</b></summary>
    
```java
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 7};
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
```
</details>
<details>
<summary><b> 7. Program to check if a string is a palindrome</b></summary>
    
```java
public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equals(reverse)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}
```
</details>
<details>
<summary><b> 8. Program to find the largest element in an array</b></summary>    
```java
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        int largest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("Largest element in the array: " + largest);
    }
}
```
- Using Lambda:

```java
int[] array = {1, 2, 3, 4, 5};

int max = Arrays.stream(array).max().getAsInt();

System.out.println("Largest element in the array: " + max);
```
</details>
<details>
<summary><b> 9. Program to implement a queue in Java</b></summary>
    
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
```
</details>
<details>
<summary><b> 10. Program to count the number of vowels in a string</b></summary>
    
```java
public class VowelCount {
    public static void main(String[] args) {
        String str = "Hello World";
        int count = 0;
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) >= 0) {
                count++;
            }
        }
        System.out.println("Number of vowels in the string: " + count);
    }
}
```
</details>
<details>
<summary><b> 11. Program to find the second largest element in an array</b></summary>
    
```java
import java.util.Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 6, 2};
        Arrays.sort(array);
        System.out.println("Second largest element in the array: " + array[array.length - 2]);
    }
}
```
```java
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        int firstLargest = arr[0];
        int secondLargest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if(arr[i] > secondLargest && arr[i] != firstLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Second largest element in the array: " + secondLargest);
    }
}
```

- Using Lambda:

```java
int[] array = {1, 3, 4, 2, 5};

int secondLargest = Arrays.stream(array)
        .boxed()
        .sorted(Collections.reverseOrder())
        .distinct()
        .skip(1)
        .findFirst()
        .get();

System.out.println("Second largest element in the array: " + secondLargest);
```

</details>
<details>
<summary><b> 12. Program to check if two strings are anagrams of each other</b></summary>
    
```java
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        boolean isAnagram = Arrays.equals(charArray1, charArray2);
        if (isAnagram) {
            System.out.println("Strings are anagrams.");
        } else {
            System.out.println("Strings are not anagrams.");
        }
    }
}
```
</details>
<details>
<summary><b> 13. Program to find the Fibonacci series up to a given number</b></summary>
    
```java
public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10;
        int a = 0, b = 1;
        System.out.print("Fibonacci series up to " + n + ": ");
        while (a <= n) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}
```

The Fibonacci series can be implemented in various ways in Java and Java 8. Here are several common approaches, including some that take advantage of features introduced in Java 8:

### 1. **Iterative Approach**

**Java:**
```java
public class FibonacciIterative {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        int a = 0, b = 1;
        
        System.out.print("Fibonacci Series: " + a + " " + b);
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
    }
}
```

**Explanation:**
- Uses a loop to calculate each Fibonacci number based on the previous two numbers.

### 2. **Recursive Approach**

**Java:**
```java
public class FibonacciRecursive {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
```

**Explanation:**
- Uses recursion to calculate the Fibonacci number. Note that this method is less efficient due to its exponential time complexity.

### 3. **Dynamic Programming Approach**

**Java:**
```java
public class FibonacciDP {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        for (int num : fib) {
            System.out.print(num + " ");
        }
    }
}
```

**Explanation:**
- Uses an array to store previously computed Fibonacci numbers to avoid redundant calculations.

### 4. **Matrix Exponentiation Approach**

**Java:**
```java
public class FibonacciMatrix {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    private static long fib(int n) {
        if (n == 0) return 0;
        long[][] result = {{1, 0}, {0, 1}};
        long[][] F = {{1, 1}, {1, 0}};
        
        while (n > 0) {
            if ((n & 1) == 1) multiply(result, F);
            multiply(F, F);
            n >>= 1;
        }
        
        return result[0][1];
    }

    private static void multiply(long[][] F, long[][] M) {
        long x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        long y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        long z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        long w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
        
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
```

**Explanation:**
- Uses matrix exponentiation to compute Fibonacci numbers efficiently. This method has a logarithmic time complexity.

### 5. **Java 8 Streams Approach**

**Java 8:**
```java
import java.util.stream.Stream;

public class FibonacciStream {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
              .limit(n)
              .map(t -> t[0])
              .forEach(fib -> System.out.print(fib + " "));
    }
}
```

**Explanation:**
- Uses Java 8 streams to generate and process Fibonacci numbers. `Stream.iterate` is used to create an infinite stream of Fibonacci pairs, which are then limited to `n` elements and processed.

### 6. **Java 8 Optional with Functional Style**

**Java 8:**
```java
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class FibonacciOptional {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        
        Function<Integer, Optional<Integer>> fibonacci = new Function<>() {
            private final int[] cache = new int[n + 1];

            {
                cache[0] = 0;
                cache[1] = 1;
            }

            @Override
            public Optional<Integer> apply(Integer i) {
                if (i < 0) return Optional.empty();
                if (i == 0) return Optional.of(0);
                if (i == 1) return Optional.of(1);
                if (cache[i] != 0 || i == 1) return Optional.of(cache[i]);
                
                cache[i] = apply(i - 1).orElse(0) + apply(i - 2).orElse(0);
                return Optional.of(cache[i]);
            }
        };
        
        Stream.iterate(0, i -> i + 1)
              .limit(n)
              .map(fibonacci)
              .map(Optional::get)
              .forEach(fib -> System.out.print(fib + " "));
    }
}
```

**Explanation:**
- Uses Java 8’s `Optional` and `Function` interface for functional-style Fibonacci computation. It combines caching (dynamic programming) with the functional style of Java 8.

### Summary

- **Iterative Approach:** Simple and efficient for small `n`.
- **Recursive Approach:** Easy to understand but inefficient for large `n` due to repeated calculations.
- **Dynamic Programming:** Efficient for larger `n` using memoization to avoid redundant calculations.
- **Matrix Exponentiation:** Very efficient with logarithmic time complexity.
- **Java 8 Streams:** Uses functional programming to generate Fibonacci numbers in a modern and expressive way.
- **Java 8 Optional and Functional Style:** Combines functional programming with caching for efficiency.

Each method has its own use case, depending on factors like code clarity, performance needs, and whether you're leveraging Java 8 features.

</details>
<details>
<summary><b> 14. Program to find the number of words in a string</b></summary>
    
```java
public class WordCount {
    public static void main(String[] args) {
        String str = "Hello World";
        String[] words = str.trim().split("\\s+");
        System.out.println("Number of words in the string: " + words.length);
    }
}
```
</details>
<details>
<summary><b> 15. Program to find the sum of digits of a number</b></summary>
    
```java
public class SumOfDigits {
    public static void main(String[] args) {
        int num = 12345;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }
}
```
</details>
<details>
<summary><b> 16. Program to concatenate two strings</b></summary>
    
```java
public class StringConcatenation {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String concatenated = str1 + " " + str2;
        System.out.println("Concatenated string: " + concatenated);
    }
}
```
</details>
<details>
<summary><b> 17. Program to find the index of a given element in an array</b></summary>
    
```java
public class ElementIndex {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 6, 2};
        int elementToFind = 6;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToFind) {
                index = i;
                break;
            }
        }
        System.out.println("Index of " + elementToFind + ": " + index);
    }
}
```
</details>
<details>
<summary><b> 18. Program to find the GCD of two numbers</b></summary>
    
```java
public class GCD {
    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 18;
        int gcd = findGCD(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + ": " + gcd);
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
```
</details>
<details>
<summary><b> 19. Program to find the intersection of two arrays</b></summary>
    
```java
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};
        Set<Integer> set = new HashSet<>();
        for (int num : array1) {
            set.add(num);
        }
        for (int num : array2) {
            if (set.contains(num)) {
                System.out.println("Intersection: " + num);
            }
        }
    }
}
```
</details>
<details>
<summary><b> 20. Program to find the power of a number using recursion</b></summary>
    
```java
public class PowerOfNumber {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        System.out.println("Power of " + base + " raised to " + exponent + ": " + power(base, exponent));
    }

    private static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}
```
</details>
<details>
<summary><b> 21. Remove duplicate elements from an array:</b></summary>
    
```java
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8};

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        int[] uniqueArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            uniqueArr[i] = list.get(i);
        }

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Array with duplicates removed: " + Arrays.toString(uniqueArr));
    }
}
```
</details>
<details>
<summary><b> 22. Convert a decimal number to binary:</b></summary>
    
```java
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = input.nextInt();
        
        System.out.println("Binary representation: " + Integer.toBinaryString(decimal));
    }
}
```
</details>
<details>
<summary><b> 23. Check if a given string is a valid palindrome or not:</b></summary>
    
```java
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        
        String reversed = new StringBuilder(str).reverse().toString();
        
        if (str.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
```
</details>
<details>
<summary><b> 24. Find the frequency of each element in an array:</b></summary>
    
```java
import java.util.*;

public class ElementFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 3, 6};

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println("Element: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }
}
```
</details>
<details> <summary><b> 25. Find the maximum subarray sum in an array:</b></summary>
    
```java
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, -3, 2, 1, -1};

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : arr) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Maximum subarray sum: " + maxSum);
    }
}
```
</details>
<details> <summary><b> 26. Binary to Decimal Conversion Program:</b></summary>
    
```java
import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = input.next();
        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Decimal equivalent: " + decimal);
    }
}
```
</details>
<details> <summary><b> 27. Factorial using Recursion Program:</b></summary>
    
```java
public class Factorial {
    public static void main(String[] args) {
        int num = 5; Number whose factorial is to be found
        long factorial = fact(num);
        System.out.println("Factorial of " + num + " is: " + factorial);
    }
    
    public static long fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }
}
```
</details>
<details>
<summary><b> 28. Perfect Number Program:</b></summary>
    
```java
public class PerfectNumber {
    public static void main(String[] args) {
        int num = 28; Number to check
        
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        
        if (sum == num) {
            System.out.println(num + " is a perfect number.");
        } else {
            System.out.println(num + " is not a perfect number.");
        }
    }
}
```
</details>
<details>
<summary><b> 29. Common Elements in Arrays Program:</b></summary>
    
```java
import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        
        System.out.print("Common elements: ");
        for (int num : arr2) {
            if (set.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
```
</details>
<details>
<summary><b> 30. Reverse of a Number Program:</b></summary>
    
```java
public class ReverseNumber {
    public static void main(String[] args) {
        int num = 12345; Number to reverse
        int reversed = 0;
        
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        
        System.out.println("Reversed number: " + reversed);
    }
}
```
</details>
<details>
<summary><b> 31. Program to check if a given number is an Armstrong number:</b></summary>

```java
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int originalNumber, remainder, result = 0;

        originalNumber = number;

        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, String.valueOf(number).length());
            originalNumber /= 10;
        }

        if (result == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}
```
</details>
<details>
<summary><b> 32. Program to find the missing number in a given array of integers:</b></summary>

```java
import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};

        int n = arr.length + 1;
        int total = n * (n + 1) / 2;
        int sum = Arrays.stream(arr).sum();

        System.out.println("Missing number is: " + (total - sum));
    }
}
```
</details>
<details>
<summary><b> 33. Program to implement a binary search algorithm:</b></summary>

```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 7;

        int index = binarySearch(arr, key);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
```
</details>
<details>
<summary><b> 34. Program to find the least common multiple (LCM) of two numbers:</b></summary>

```java
public class LCM {
    public static int findLCM(int a, int b) {
        int max = Math.max(a, b);
        int lcm = max;

        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                return lcm;
            }
            lcm += max;
        }
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 18;

        System.out.println("LCM of " + a + " and " + b + " is: " + findLCM(a, b));
    }
}
```
</details>
<details>
<summary><b> 35. Program to check if a string is a valid email address:</b></summary>

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String email = "example@gmail.com";

        if (isValidEmail(email)) {
            System.out.println("Valid email address");
        } else {
            System.out.println("Invalid email address");
        }
    }
}
```
</details>
<details>
<summary><b> 36. Program to find the length of the longest consecutive sequence of a given array:</b></summary>

```java
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : nums) {
            int length = 1;
            int current = num;
            while (set.contains(current + 1)) {
                current++;
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Length of longest consecutive sequence is: " + longestConsecutive(nums));
    }
}
```
</details>
<details>
<summary><b> 37. Program to find the roots of a quadratic equation:</b></summary>

```java
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coefficients of the quadratic equation (a, b, c):");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are real and different: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Roots are real and same: " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Roots are complex and different: " + realPart + " + " + imaginaryPart + "i and " + realPart + " - " + imaginaryPart + "i");
        }
    }
}
```
</details>
<details>
<summary><b> 38. Program to find the area of a circle:</b></summary>

```java
import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        final double PI = 3.14159;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();
        
        double area = PI * radius * radius;
        
        System.out.println("Area of the circle is: " + area);
    }
}
```
</details>
<details>
<summary><b> 39. Program to find the smallest element in an array:</b></summary>

```java
public class SmallestElementInArray {
    public static int findSmallestElement(int[] arr) {
        int smallest = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        
        return smallest;
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 3, 6};
        
        System.out.println("Smallest element in the array is: " + findSmallestElement(arr));
    }
}
```
```java
public class SmallestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        int smallest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        System.out.println("Smallest element in the array: " + smallest);
    }
}
```
- Using Lambda:

```java
int[] array = {5, 2, 3, 1, 4};

int min = Arrays.stream(array).min().getAsInt();

System.out.println("Smallest element in the array: " + min);
```

</details>
<details>
<summary><b> 40. Program to check if a given number is a palindrome:</b></summary>

```java
import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int originalNumber = number;
        int reversedNumber = 0;

        while (originalNumber != 0) {
            int remainder = originalNumber % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            originalNumber /= 10;
        }

        if (number == reversedNumber) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }
}
```
</details>
<details>
<summary><b> 41. Program to find the second largest element in an array:</b></summary>

```java
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 15};
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for(int num : arr) {
            if(num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if(num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }
        
        System.out.println("Second largest element in the array: " + secondLargest);
    }
}
```
</details>
<details>
<summary><b> 42. Program to check if two strings are anagrams of each other:</b></summary>

```java
import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
    
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        if(isAnagram(str1, str2)) {
            System.out.println("The strings are anagrams of each other.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }
}
```
</details>
<details>
<summary><b> 43. Program to find the Fibonacci series up to a given number:</b></summary>

```java
public class FibonacciSeries {
    public static void printFibonacci(int n) {
        int a = 0;
        int b = 1;
        int c;
        
        for(int i = 0; i < n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }
    
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci series up to " + n + " terms:");
        printFibonacci(n);
    }
}
```
</details>
<details>
<summary><b> 44. Program to find the number of words in a string:</b></summary>

```java
public class WordCount {
    public static int countWords(String str) {
        String[] words = str.split("\\s+");
        return words.length;
    }
    
    public static void main(String[] args) {
        String str = "Hello World, how are you?";
        System.out.println("Number of words in the string: " + countWords(str));
    }
}
```
</details>
<details>
<summary><b> 45. Program to find the sum of digits of a number:</b></summary>

```java
public class SumOfDigits {
    public static int sumOfDigits(int num) {
        int sum = 0;
        
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Sum of digits of " + num + ": " + sumOfDigits(num));
    }
}
```
</details>
<details>
<summary><b> 46. Program to concatenate two strings:</b></summary>

```java
public class ConcatenateStrings {
    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }
    
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Concatenated string: " + concatenateStrings(str1, str2));
    }
}
```
</details>
<details>
<summary><b> 47. Program to find the index of a given element in an array:</b></summary>

```java
public class ElementIndex {
    public static int findIndex(int[] arr, int element) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int element = 30;
        System.out.println("Index of element " + element + ": " + findIndex(arr, element));
    }
}
```
</details>
<details>
<summary><b> 48. Program to find the GCD of two numbers:</b></summary>

```java
public class GCD {
    public static int findGCD(int num1, int num2) {
        if(num2 == 0) {
            return num1;
        }
        
        return findGCD(num2, num1 % num2);
    }
    
    public static void main(String[] args) {
        int num1 = 36;
        int num2 = 48;
        System.out.println("GCD of " + num1 + " and " + num2 + ": " + findGCD(num1, num2));
    }
}
```
</details>
<details>
<summary><b> 49. Program to find the intersection of two arrays:</b></summary>

```java
import java.util.HashSet;

public class IntersectionOfArrays {
    public static void findIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(int num : arr1) {
            set1.add(num);
        }
        
        for(int num : arr2) {
            set2.add(num);
        }
        
        set1.retainAll(set2);
        
        System.out.println("Intersection of the two arrays: " + set1);
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {3, 6, 9};
        
        findIntersection(arr1, arr2);
    }
}
```
</details>
<details>
<summary><b> 50. Program to find the power of a number using recursion:</b></summary>

```java
public class PowerOfNumber {
    public static int power(int base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        
        return base * power(base, exponent - 1);
    }
    
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        System.out.println("Power of " + base + " raised to " + exponent + ": " + power(base, exponent));
    }
}
```
</details>
<details>
<summary><b> 51. Remove duplicates from an array</b></summary>
    
```java
import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 3, 5};

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int[] uniqueArr = new int[set.size()];
        int index = 0;
        for (int num : set) {
            uniqueArr[index++] = num;
        }

        System.out.println("Array with duplicates removed: " + Arrays.toString(uniqueArr));
    }
}
```
</details>
<details>
<summary><b> 52. Find the smallest element in an array</b></summary>
    
```java
public class SmallestElementInArray {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1, 9, 2};
        int smallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                smallest = num;
            }
        }

        System.out.println("Smallest element in the array: " + smallest);
    }
}
```
</details>
<details>
<summary><b> 53. Check if a given string is a valid palindrome or not</b></summary>

```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string is a valid palindrome.");
        } else {
            System.out.println("The string is not a valid palindrome.");
        }
    }
}
```
</details>
<details>
<summary><b> 54. Find the product of two matrices</b></summary>
```java
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] product = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Product of the two matrices:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```
</details>
<details>
<summary><b> 55. Reverse a linked list</b></summary>
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original linked list:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed linked list:");
        printList(head);
    }
}
```
</details>
<details>
<summary><b> 56. Find the missing number in an array of consecutive numbers</b></summary>
```java
public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        int n = arr.length + 1;
        int totalSum = (n * (n + 1)) / 2;
        int arrSum = 0;

        for (int num : arr) {
            arrSum += num;
        }

        int missingNumber = totalSum - arrSum;
        System.out.println("Missing number in the array: " + missingNumber);
    }
}
```
</details>
<details>
<summary><b> 57. Check if a number is a perfect number</b></summary>
```java
public class PerfectNumber {
    public static void main(String[] args) {
        int num = 28;
        int sum = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum == num) {
            System.out.println(num + " is a perfect number.");
        } else {
            System.out.println(num + " is not a perfect number.");
        }
    }
}
```
</details>
<details>
<summary><b> 58. Find the median of an array</b></summary>
```java
import java.util.Arrays;

public class MedianOfArray {
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7, 2};
        Arrays.sort(arr);

        double median;
        if (arr.length % 2 == 0) {
            median = (double) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
        } else {
            median = arr[arr.length / 2];
        }

        System.out.println("Median of the array: " + median);
    }
}
```
</details>
<details>
<summary><b> 59. Check if a string contains only digits</b></summary>
```java
public class OnlyDigitsInString {
    public static void main(String[] args) {
        String str = "12345";
        boolean onlyDigits = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                onlyDigits = false;
                break;
            }
        }

        if (onlyDigits) {
            System.out.println("The string contains only digits.");
        } else {
            System.out.println("The string does not contain only digits.");
        }
    }
}
```
</details>
<details>
<summary><b> 60. Find the LCM of two numbers</b></summary>
```java
public class LCM {
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 18;

        int lcm = findLCM(num1, num2);
        System.out.println("LCM of " + num1 + " and " + num2 + " is " + lcm);
    }
}
```
</details>
<details>
<summary><b> 61. Maximum Subarray Sum Program:</b></summary>

```java
public class MaxSubarraySum {
    public static int maxSubArraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(nums));
    }
}
```
</details>
<details>
<summary><b> 62. Binary Search Algorithm Program:</b></summary>

```java
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = binarySearch(nums, target);
        
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
```
</details>
<details> <summary><b> 63. Factorial using Recursion Program:</b></summary>

```java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    
    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial of " + number + " is: " + factorial(number));
    }
}
```
</details>
<details> <summary><b> 64. Remove Element from Array Program:</b></summary>

```java
import java.util.Arrays;

public class RemoveElementFromArray {
    public static int[] removeElement(int[] arr, int element) {
        return Arrays.stream(arr).filter(num -> num != element).toArray();
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int element = 3;
        
        int[] newArr = removeElement(arr, element);
        System.out.println("Array after removing element: " + Arrays.toString(newArr));
    }
}
```
</details>
<details> <summary><b> 65. Sum of Series Program:</b></summary>

```java
public class SumOfSeries {
    public static int sumOfSeries(int n) {
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum of series up to " + n + " is: " + sumOfSeries(n));
    }
}
```
</details>
<details> <summary><b> 66. Count Occurrences of Character in a String Program:</b></summary>

```java
public class CountCharacterOccurrences {
    public static int countCharacterOccurrences(String str, char c) {
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String str = "hello world";
        char c = 'o';
        System.out.println("Number of occurrences of '" + c + "': " + countCharacterOccurrences(str, c));
    }
}
```
</details>
<details> <summary><b> 67. Count Words in a Sentence Program:</b></summary>

```java
public class CountWordsInSentence {
    public static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }
    
    public static void main(String[] args) {
        String sentence = "This is a sample sentence.";
        System.out.println("Number of words in the sentence: " + countWords(sentence));
    }
}
```
</details>
<details> <summary><b> 68. Area of Circle Program:</b></summary>

```java
public class AreaOfCircle {
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    public static void main(String[] args) {
        double radius = 5.0;
        System.out.println("Area of circle with radius " + radius + " is: " + calculateArea(radius));
    }
}
```
</details>
<details> <summary><b> 69. Bubble Sort Program:</b></summary>

```java
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        
        bubbleSort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }
}
```
</details>
<details> <summary><b> 70. Decimal to Binary Conversion Program:</b></summary>

```java
public class DecimalToBinary {
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }
    
    public static void main(String[] args) {
        int decimal = 15;
        System.out.println("Binary representation of " + decimal + " is: " + decimalToBinary(decimal));
    }
}
```
</details>
<details> <summary><b> 71. Write a program to find the first non-repeated character in a string.</b></summary>

```java
public class FindFirstNonRepeatedChar {
    public static char findFirstNonRepeatedChar(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        
        return ' ';
    }
    
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("The first non-repeated character is: " + findFirstNonRepeatedChar(str));
    }
}
```
</details>
<details> <summary><b> 72. Write a program to implement a linked list.</b></summary>

```java
class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ImplementLinkedList {
    Node head;
    
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ImplementLinkedList list = new ImplementLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        
        list.display();
    }
}
```
</details>
<details> <summary><b> 73. Write a program to find the transpose of a matrix.</b></summary>

```java
public class FindMatrixTranspose {
    public static void transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        transposeMatrix(matrix);
    }
}
```
</details>
<details> <summary><b> 74. Write a program to find the average of an array.</b></summary>

```java
public class FindAverageOfArray {
    public static double findAverage(int[] arr) {
        int sum = 0;
        
        for (int num : arr) {
            sum += num;
        }
        
        return sum / (double) arr.length;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("The average of the array is: " + findAverage(arr));
    }
}
```
</details>
<details> <summary><b> 75. Write a program to find the sum of odd numbers in an array.</b></summary>

```java
public class FindSumOfOddNumbers {
    public static int findSumOfOddNumbers(int[] arr) {
        int sum = 0;
        
        for (int num : arr) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("The sum of odd numbers in the array is: " + findSumOfOddNumbers(arr));
    }
}
```
</details>
<details> <summary><b> 76. Write a program to find the number of occurrences of a word in a string.</b></summary>

```java
public class WordOccurrencesInString {
    public static int countOccurrences(String str, String word) {
        String[] words = str.split("\\s+");
        int count = 0;
        
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String str = "hello world hello";
        String word = "hello";
        System.out.println("Number of occurrences of the word '" + word + "': " + countOccurrences(str, word));
    }
}
```
</details>
<details> <summary><b> 77. Write a program to check if a number is an Armstrong number.</b></summary>

```java
public class ArmstrongNumberCheck {
    public static boolean isArmstrongNumber(int num) {
        int originalNum, remainder, result = 0;
        originalNum = num;
        
        while (originalNum != 0) {
            remainder = originalNum % 10;
            result += Math.pow(remainder, String.valueOf(num).length());
            originalNum /= 10;
        }
        
        return result == num;
    }
    
    public static void main(String[] args) {
        int num = 153;
        if (isArmstrongNumber(num)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
    }
}
```
</details>
<details> <summary><b> 78. Write a program to implement a selection sort algorithm.</b></summary>

```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(arr);
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```
</details>
<details> <summary><b> 79. Write a program to find the maximum and minimum element in an array.</b></summary>

```java
public class FindMaxMinInArray {
    public static void findMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        System.out.println("Maximum element in the array: " + max);
        System.out.println("Minimum element in the array: " + min);
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 5, 9, 2};
        findMaxMin(arr);
    }
}
```
</details>
<details> <summary><b> 80. Write a program to implement a merge sort algorithm.</b></summary>

```java
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];
        
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            rightArr[i - mid] = arr[i];
        }
        
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }
    
    public static void merge(int[] leftArr, int[] rightArr, int[] arr) {
        int i = 0, j = 0, k = 0;
        
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```
</details>
<details> <summary><b> 81. Count the number of prime numbers in a given range:</b></summary>
```java
public class PrimeNumberCount {
    
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int countPrimes(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int start = 1;
        int end = 100;
        
        System.out.println("Number of prime numbers between " + start + " and " + end + " is: " + countPrimes(start, end));
    }
}
```
</details>
<details> <summary><b> 82. Find the reverse of a linked list:</b></summary>
```java
class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {
    
    public Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
    
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        
        ReverseLinkedList obj = new ReverseLinkedList();
        System.out.println("Original Linked List:");
        obj.printList(head);
        
        head = obj.reverseList(head);
        System.out.println("\nReversed Linked List:");
        obj.printList(head);
    }
}
```
</details>
<details> <summary><b> 83. Convert a decimal number to hexadecimal:</b></summary>
```java
import java.util.Scanner;

public class DecimalToHexadecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        String hexadecimal = Integer.toHexString(decimal);
        
        System.out.println("Hexadecimal equivalent: " + hexadecimal);
    }
}
```

<details> <summary><b> 84. Find the largest palindrome made from the product of two 3-digit numbers:</b></summary>

```java
public class LargestPalindromeProduct {
    
    public static boolean isPalindrome(int num) {
        int reversedNum = 0, remainder, originalNum;
        
        originalNum = num;
        
        while (num != 0) {
            remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num /= 10;
        }
        
        return originalNum == reversedNum;
    }
    
    public static void main(String[] args) {
        int palindrome = 0;
        for (int i = 999; i > 100; i--) {
            for (int j = i; j > 100; j--) {
                int product = i * j;
                if (product < palindrome) {
                    break;
                }
                if (isPalindrome(product) && product > palindrome) {
                    palindrome = product;
                }
            }
        }
        
        System.out.println("Largest palindrome made from the product of two 3-digit numbers is: " + palindrome);
    }
}
```
</details>
<details> <summary><b> 85. Implement a quick sort algorithm:</b></summary>

```java
public class QuickSort {
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        
        quickSort(arr, 0, n - 1);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```
</details>
<details> <summary><b> 86. Find the sum of prime numbers up to a given number:</b></summary>

```java
public class SumOfPrimes {
    
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int sumOfPrimes(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Sum of prime numbers up to " + n + " is: " + sumOfPrimes(n));
    }
}
```
</details>
<details> <summary><b> 87. Generate a random number between a given range:</b></summary>

```java
import java.util.Random;

public class RandomNumberGenerator {
    
    public static void main(String[] args) {
        Random rand = new Random();
        int lowerbound = 10;
        int upperbound = 99;
        
        int randomNum = rand.nextInt(upperbound - lowerbound) + lowerbound;
        
        System.out.println("Random number between " + lowerbound + " and " + upperbound + " is: " + randomNum);
    }
}
```
</details>
<details> <summary><b> 88. Implement a binary tree:</b></summary>

```java
class Node {
    int data;
    Node left, right;
    
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;
    
    public void insert(int key) {
        root = insertRec(root, key);
    }
    
    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }
        
        return root;
    }
    
    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        tree.inorderTraversal(tree.root);
    }
}
```
</details>
<details> <summary><b> 89. Find the longest common prefix in an array of strings:</b></summary>

```java
public class LongestCommonPrefix {
    
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        
        return prefix;
    }
    
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }
}
```
</details>
<details> <summary><b> 90. Find the number of trailing zeroes in a factorial:</b></summary>

```java
import java.util.Scanner;

public class FactorialTrailingZeroes {
    
    public static int trailingZeroes(int n) {
        int count = 0;
        
        while (n > 0) {
            n = n/5;
            count += n;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        System.out.println("Number of trailing zeroes in factorial of " + num + " is: " + trailingZeroes(num));
    }
}
```
</details>
<details> <summary><b> 91. Heap sort algorithm implementation:</b></summary>

```java
public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
```
</details>
<details> <summary><b> 92. Longest palindrome substring in a string:</b></summary>

```java
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        String s = "babad";
        System.out.println("Longest palindrome substring: " + lps.longestPalindrome(s));
    }
}
```
</details>
<details> <summary><b> 93. Sum of all even numbers in an array:</b></summary>

```java
public class SumOfEvenNumbers {
    public int sumOfEven(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        SumOfEvenNumbers s = new SumOfEvenNumbers();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Sum of even numbers: " + s.sumOfEven(arr));
    }
}
```
</details>
<details> <summary><b> 94. Depth-First Search Algorithm:</b></summary>

```java
import java.util.*;

public class DFS {
    private boolean[] visited;
    private List<List<Integer>> graph;

    public DFS(int vertices) {
        visited = new boolean[vertices];
        graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("Depth First Search starting from vertex 2:");
        dfs.dfs(2);
    }
}
```
</details>
<details> <summary><b> 95. Find Kth Largest Element in an Array:</b></summary>

```java
import java.util.Arrays;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(k + "th largest element: " + kthLargestElement.findKthLargest(arr, k));
    }
}
```
</details>
<details> <summary><b> 96. Number of Ways to Climb Stairs:</b></summary>

```java
public class Staircase {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        Staircase staircase = new Staircase();
        int n = 4;
        System.out.println("Number of ways to climb " + n + " stairs: " + staircase.climbStairs(n));
    }
}
```
</details>
<details> <summary><b> 97. Breadth-First Search Algorithm:</b></summary>

```java
import java.util.*;

public class BFS {
    private boolean[] visited;
    private List<List<Integer>> graph;
    
    public BFS(int vertices) {
        visited = new boolean[vertices];
        graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }
    
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BFS bfs = new BFS(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        System.out.println("Breadth First Search starting from vertex 2:");
        bfs.bfs(2);
    }
}
```
</details>
<details> <summary><b> 98. Find Missing Element in Arithmetic Progression:</b></summary>

```java
public class MissingElement {
    public int findMissing(int[] arr) {
        int n = arr.length;
        int d = (arr[n-1] - arr[0]) / n;
        int missing = searchMissing(arr, d, 0, n - 1);
        return missing;
    }

    public int searchMissing(int[] arr, int d, int low, int high) {
        if (low >= high) return -1;

        int mid = low + (high - low) / 2;
        if (arr[mid+1] - arr[mid] != d) {
            return arr[mid] + d;
        }

        int left = searchMissing(arr, d, low, mid);
        int right = searchMissing(arr, d, mid + 1, high);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        MissingElement missingElement = new MissingElement();
        int[] arr = {2, 4, 6, 10, 12};
        System.out.println("Missing element in arithmetic progression: " + missingElement.findMissing(arr));
    }
}
```
</details>
<details> <summary><b> 99. Dijkstra's Algorithm:</b></summary>

```java
import java.util.*;

public class Dijkstra {
    
    private static final int V = 9;

    public void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        
        printSolution(dist);
    }

    public int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public void printSolution(int[] dist) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                        {4, 0, 8, 0, 0, 0, 0, 11, 0},
                        {0, 8, 0, 7, 0, 4, 0, 0, 2},
                        {0, 0, 7, 0, 9, 14, 0, 0, 0},
                        {0, 0, 0, 9, 0, 10, 0, 0, 0},
                        {0, 0, 4, 14, 10, 0, 2, 0, 0},
                        {0, 0, 0, 0, 0, 2, 0, 1, 6},
                        {8, 11, 0, 0, 0, 0, 1, 0, 7},
                        {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 0);
    }
}
```
</details>
<details> <summary><b> 100. Maximum Path Sum in Binary Tree:</b></summary>

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        maxPath(root);
        return maxSum;
    }

    public int maxPath(TreeNode node) {
        if (node == null) return 0;
        
        int left = Math.max(maxPath(node.left), 0);
        int right = Math.max(maxPath(node.right), 0);
        
        maxSum = Math.max(maxSum, node.val + left + right);
        
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println("Maximum path sum in binary tree: " + maxPathSum.maxPathSum(root));
    }
}
```
</details>
<details> <summary><b> 101. Write a program to implement a bellman-ford algorithm.</b></summary>

```java
public class BellmanFordAlgorithm {
    public void bellmanFord(int graph[][], int V, int E, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                if (dist[graph[j][0]] + graph[j][2] < dist[graph[j][1]]) {
                    dist[graph[j][1]] = dist[graph[j][0]] + graph[j][2];
                }
            }
        }

        for (int j = 0; j < E; j++) {
            int x = graph[j][0];
            int y = graph[j][1];
            int weight = graph[j][2];
            if (dist[x] != Integer.MAX_VALUE && dist[x] + weight < dist[y]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; Number of vertices in graph
        int E = 8; Number of edges in graph

        int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 }, { 1, 2, 3 }, { 1, 3, 2 }, { 1, 4, 2 }, { 3, 2, 5 }, { 3, 1, 1 },
                { 4, 3, -3 } };

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        bellmanFordAlgorithm.bellmanFord(graph, V, E, 0);
    }
}
```
</details>
<details> <summary><b> 102. Write a program to find the intersection of two linked lists.</b></summary>

```java
public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;

        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }

        return A;
    }
}
```
</details>
<details> <summary><b> 103. Write a program to find the longest increasing subsequence in an array.</b></summary>

```java
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
```
</details>
<details> <summary><b> 104. Write a program to implement a topological sort algorithm.</b></summary>

```java
import java.util.*;

public class TopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;

            for (int nextCourse : adjList.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }
}
```
</details>
<details> <summary><b> 105. Write a program to find the number of connected components in a graph.</b></summary>

```java
public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        for (int[] edge : edges) {
            int root1 = find(roots, edge[0]);
            int root2 = find(roots, edge[1]);
            if (root1 != root2) {
                roots[root1] = root2;
                n--;
            }
        }

        return n;
    }

    private int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
```
</details>
<details> <summary><b> 106. Write a program to find the maximum profit by buying and selling stocks.</b></summary>

```java
public class MaxProfitStocks {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
```
</details>
<details> <summary><b> 107. Write a program to implement a prim's algorithm.</b></summary>

```java
public class PrimsAlgorithm {
    public int minCost(int[][] graph) {
        int n = graph.length;
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        boolean[] mstSet = new boolean[n];

        for (int i = 0; i < n; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += key[i];
        }
        return result;
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
```
</details>
<details> <summary><b> 108. Write a program to find the longest common subsequence in two strings.</b></summary>

```java
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
```
</details>
<details> <summary><b> 109. Write a program to implement a Kruskal's algorithm.</b></summary>

```java
public class KruskalsAlgorithm {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }

    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public Edge[] kruskalMST(int V, Edge[] edges) {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int j = 0; j < V; j++) {
            subsets[j] = new Subset();
            subsets[j].parent = j;
            subsets[j].rank = 0;
        }

        while (e < V - 1) {
            Edge next_edge = edges[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        return result;
    }
}
```
</details>
<details> <summary><b> 110. Write a program to find the minimum spanning tree of a graph.</b></summary>

```java
import java.util.*;

public class MinimumSpanningTree {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    public int minCost(int[][] graph) {
        int n = graph.length;
        Edge[] edges = new Edge[n * (n - 1) / 2];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] != 0) {
                    Edge edge = new Edge();
                    edge.src = i;
                    edge.dest = j;
                    edge.weight = graph[i][j];
                    edges[k++] = edge;
                }
            }
        }

        Arrays.sort(edges);

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int result = 0;
        int e = 0;

        while (e < n - 1) {
            Edge next_edge = edges[e++];
            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result += next_edge.weight;
                union(parent, x, y);
            }
        }

        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
}
```
</details>
<details> <summary><b> 111. Implementing a trie data structure in Java:</b></summary>

```java
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.containsKey(c)) {
                current.put(c, new TrieNode());
            }
            current = current.get(c);
        }
        current.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.containsKey(c)) {
                current = current.get(c);
            } else {
                return null;
            }
        }
        return current;
    }

    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}

```
</details>
<details> <summary><b> 112. Finding the longest palindrome subsequence in a string in Java:</b></summary>

```java
public class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
```
</details>
<details> <summary><b> 113. Java program to implement a hash table:</b></summary>

```java
import java.util.HashMap;

public class HashTable {
    public static void main(String[] args) {
        HashMap<Integer, String> hashtable = new HashMap<>();
        
        hashtable.put(1, "Java");
        hashtable.put(2, "Python");
        hashtable.put(3, "C++");
        
        System.out.println("Hash Table: " + hashtable);
    }
}
```
</details>
<details> <summary><b> 114. Java program to implement a stack using queues:</b></summary>

```java
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(q1.size() > 1) {
            q2.add(q1.poll());
        }
        
        int popped = q1.poll();
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return popped;
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Popped element: " + stack.pop());
    }
}
```
</details>
<details> <summary><b> 115. Java program to find the maximum sum subarray using Kadane's algorithm:</b></summary>

```java
public class MaximumSumSubarray {
    public static int maxSumSubarray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Maximum sum subarray: " + maxSumSubarray(nums));
    }
}
```
</details>
<details> <summary><b> 116. Java program to implement an AVL tree:</b></summary>

```java
class Node {
    int data, height;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {
    Node root;
    
    Implement AVL tree operations
}
```
</details>
<details> <summary><b> 117. Java program to find the shortest path in a maze:</b></summary>

```java
public class ShortestPathInMaze {
    Implement shortest path in a maze algorithm
}
```
</details>
<details> <summary><b> 118. Java program to implement a disjoint-set data structure:</b></summary>

```java
class DisjointSet {
    private int[] parent;
    private int[] rank;
    
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }
}
```
</details>
<details> <summary><b> 119. Java program to find the longest repeating subsequence in a string:</b></summary>

```java
public class LongestRepeatingSubsequence {
    Implement longest repeating subsequence algorithm
}
```
</details>
<details> <summary><b> 120. Java program to implement a priority queue:</b></summary>

```java
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);
        
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
```
</details>
<details> <summary><b> 121. Program to find the longest common substring in two strings</b></summary>

```java
public class LongestCommonSubstring {
    public static String longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }
        
        return s1.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}
</details>
<details> <summary><b> 122. Program to implement a radix sort algorithm</b></summary>
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
```
</details>
<details> <summary><b> 123. Program to find the maximum number of non-overlapping intervals:</b></summary>

```java
import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class NonOverlappingIntervals {
    public int maxNonOverlappingIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.end));

        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3)};
        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        System.out.println(solution.maxNonOverlappingIntervals(intervals));
    }
}
```
</details>
<details> <summary><b> 124. Program to implement a segment tree:</b></summary>

```java
public class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];

        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }

        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int index, int val) {
        index += n;
        tree[index] = val;

        while (index > 1) {
            tree[index / 2] = tree[index] + tree[index ^ 1];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;

        while (left <= right) {
            if ((left & 1) == 1) {
                sum += tree[left++];
            }
            if ((right & 1) == 0) {
                sum += tree[right--];
            }
            left /= 2;
            right /= 2;
        }

        return sum;
    }
}
```
</details>
<details> <summary><b> 125. Program to find the maximum area of a histogram:</b></summary>

```java
import java.util.Stack;

public class MaxHistogramArea {
    public int maxHistogramArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);

            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxHistogramArea solution = new MaxHistogramArea();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.maxHistogramArea(heights));
    }
}
```
</details>
<details> <summary><b> 126. Program to implement Floyd-Warshall algorithm:</b></summary>

```java
public class FloydWarshall {
    public void shortestPath(int[][] graph) {
        int n = graph.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE
                            && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}
```
</details>
<details> <summary><b> 127. Program to find the longest word in a dictionary that can be formed from a set of letters:</b></summary>

```java
import java.util.HashSet;
import java.util.Set;

public class LongestWord {
    public String findLongestWord(String[] words, String letters) {
        Set<Character> set = new HashSet<>();
        for (char c : letters.toCharArray()) {
            set.add(c);
        }

        String result = "";

        for (String word : words) {
            int i = 0;
            for (char c : word.toCharArray()) {
                if (set.contains(c)) {
                    i++;
                } else {
                    break;
                }
            }

            if (i == word.length() && word.length() > result.length()) {
                result = word;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestWord solution = new LongestWord();
        String[] words = {"w","wo","wor","worl","world"};
        String letters = "worldabcefgh";
        System.out.println(solution.findLongestWord(words, letters));
    }
}
```
</details>
<details> <summary><b> 128. Program to check if a binary tree is balanced:</b></summary>

```java
public class BinaryTreeBalanced {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
```
</details>
<details> <summary><b> 129. Program to implement a hashmap from scratch:</b></summary>

```java
public class MyHashMap {
    private static final int SIZE = 10000;
    private Entry[] table;

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(int key, int value) {
        int index = key % SIZE;
        Entry newEntry = new Entry(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry prev = null;
            Entry current = table[index];

            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }

            prev.next = newEntry;
        }
    }

    public int get(int key) {
        int index = key % SIZE;

        if (table[index] == null) {
            return -1;
        }

        Entry current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;

        if (table[index] == null) {
            return;
        }

        Entry prev = null;
        Entry current = table[index];

        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        if (prev == null) {
            table[index] = current.next;
        } else {
            prev.next = current.next;
        }
    }

    private static class Entry {
        int key, value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
```
</details>
<details> <summary><b> 130. Program to find the maximum flow in a graph using Ford-Fulkerson algorithm:</b></summary>

```java
import java.util.LinkedList;

public class FordFulkerson {
    private static final int V = 6;

    public int fordFulkerson(int[][] graph, int source, int sink) {
        int maxFlow = 0;
        int[][] rGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                rGraph[i][j] = graph[i][j];
            }
        }

        int[] parent = new int[V];

        while (bfs(rGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private boolean bfs(int[][] rGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    if (v == sink) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 16, 13, 0, 0, 0}, {0, 0, 10, 12, 0, 0}, {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20}, {0, 0, 0, 7, 0, 4}, {0, 0, 0, 0, 0, 0}};
        FordFulkerson solution = new FordFulkerson();
        System.out.println("The maximum possible flow is: " + solution.fordFulkerson(graph, 0, 5));
    }
}
```
</details>
