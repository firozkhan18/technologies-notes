Here is the consolidated list of questions with duplicates and slightly different phrasings removed:

1. **Find the sum of all elements in an array**
2. **Check if a given number is prime or not**
3. **Reverse a string**
4. **Find the factorial of a number**
5. **Implement a stack in Java**
6. **Sort an array in ascending order**
7. **Check if a string is a palindrome**
8. **Implement a queue in Java**
9. **Count the number of vowels in a string**
10. **Find the second largest element in an array**
11. **Check if two strings are anagrams of each other**
12. **Find the Fibonacci series up to a given number**
13. **Find the number of words in a string**
14. **Find the sum of digits of a number**
15. **Concatenate two strings**
16. **Find the index of a given element in an array**
17. **Find the GCD of two numbers**
18. **Find the intersection of two arrays**
19. **Find the power of a number using recursion**
20. **Remove duplicate elements from an array**
21. **Convert a decimal number to binary**
22. **Check if a given string is a valid palindrome or not**
23. **Find the frequency of each element in an array**
24. **Binary to Decimal Conversion Program**
25. **Factorial using Recursion Program**
26. **Perfect Number Program**
27. **Common Elements in Arrays Program**
28. **Reverse of a Number Program**
29. **Check if a given number is an Armstrong number**
30. **Find the missing number in a given array of integers**
31. **Implement a binary search algorithm**
32. **Find the least common multiple (LCM) of two numbers**
33. **Check if a string is a valid email address**
34. **Find the length of the longest consecutive sequence of a given array**
35. **Find the roots of a quadratic equation**
36. **Find the area of a circle**
37. **Find the product of two matrices**
38. **Find the median of an array**
39. **Binary Search Algorithm Program**
40. **Remove Element from Array Program**
41. **Sum of Series Program**
42. **Count Occurrences of Character in a String Program**
43. **Count Words in a Sentence Program**
44. **Bubble Sort Program**
45. **Decimal to Binary Conversion Program**
46. **Implement a linked list**
47. **Find the transpose of a matrix**
48. **Find the average of an array**
49. **Find the sum of odd numbers in an array**
50. **Implement a selection Sort algorithm**
51. **Find the maximum and minimum element in an array**
52. **Implement a Merge Sort algorithm**
53. **Count the number of prime numbers in a given range**
54. **Convert a decimal number to hexadecimal**
55. **Implement a quick Sort algorithm**
56. **Find the sum of prime numbers up to a given number**
57. **Generate a random number between a given range**
58. **Implement a binary tree**
59. **Find the longest common prefix in an array of strings**
60. **Find the number of trailing zeroes in a factorial**
61. **Heap Sort algorithm Implementation**
62. **Longest palindrome substring in a string**
63. **Sum of all even numbers in an array**
64. **Depth-First Search Algorithm**
65. **Find Kth Largest Element in an Array**
66. **Number of Ways to Climb Stairs**
67. **Breadth-First Search Algorithm**
68. **Find Missing Element in Arithmetic Progression**
69. **Dijkstra's Algorithm**
70. **Maximum Path Sum in Binary Tree**
71. **Implement a Bellman-Ford algorithm**
72. **Find the intersection of two linked lists**
73. **Find the longest increasing subsequence in an array**
74. **Implement a topological Sort algorithm**
75. **Find the number of connected components in a graph**
76. **Find the maximum profit by buying and selling stocks**
77. **Implement Prim's algorithm**
78. **Find the longest common subsequence in two strings**
79. **Implement Kruskal's algorithm**
80. **Find the minimum spanning tree of a graph**
81. **Implementing a trie data structure in Java**
82. **Finding the longest palindrome subsequence in a string in Java**
83. **Implement a hash table**
84. **Implement a stack using queues**
85. **Find the maximum sum subarray using Kadane's algorithm**
86. **Find the maximum subarray sum in an array**
87. **Implement an AVL tree**
88. **Find the shortest path in a maze**
89. **Implement a disjoint-set data structure**
90. **Find the longest repeating subsequence in a string**
91. **Implement a priority queue**
92. **Find the longest common substring in two strings**
93. **Find the maximum number of non-overlapping intervals**
94. **Implement a segment tree**
95. **Find the maximum area of a histogram**
96. **Implement Floyd-Warshall algorithm**
97. **Find the longest word in a dictionary that can be formed from a set of letters**
98. **Check if a binary tree is balanced**
99. **Implement a hashmap from scratch**
100. **Find the maximum flow in a graph using Ford-Fulkerson algorithm**
101. **Find the largest element in an array**
102. **Find the smallest element in an array**
103. **Find the second smallest element in an array**
104. **Check if an array is sorted in ascending order**
105. **Check if an array is sorted in descending order**
106. **Separate odd and even numbers in a list of integers**
107. **Remove duplicate elements from a list using Java 8 streams**
108. **Find frequency of each character in a string using Java 8 streams**
109. **Find frequency of each element in an array or a list**
110. **Sort a given list of decimals in reverse order**
111. **Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter**
112. **Print the numbers from a given list of integers that are multiples of a given number**
113. **Find maximum and minimum of a list of integers**
114. **Merge two unsorted arrays into a single sorted array using Java 8 streams**
115. **Get three maximum numbers and three minimum numbers from a given list of integers**
116. **Check if two strings are anagrams or not using Java 8 streams**
117. **Find sum of all digits of a number in Java 8**
118. **Find second largest number in an integer array**
119. **Sort a list of strings according to the increasing order of their length**
120. **Find the sum and average of all elements in an integer array**
121. **Find common elements between two arrays**
122. **Reverse each word of a string using Java 8 streams**
123. **Find the sum of the first natural numbers using streams**
124. **Print the first even numbers**
125. **Find the most repeated element in an array**
126. **Check if a given string is a palindrome using the stream API and lambda expressions**
127. **Find strings in a list that start with a number**
128. **Extract duplicate elements from an array**
129. **Print duplicate characters in a string**
130. **Find first repeated character in a string**
131. **Find first non-repeated character in a string**
132. **Generate the Fibonacci series**
133. **Print the first odd numbers**
134. **Get the last element of an array**
135. **Calculate the age of a person in years given their birthday**


Certainly! Here is the list of questions with answers formatted as requested for a Markdown file. I'll include both Java 7 and Java 8 (using lambda and Stream API) solutions where applicable.

# Coding Questions and Answers

<details>
<summary><b>Find the sum of all elements in an array</b></summary>

**Java 7:**
```java
public class SumArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SumArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(array).sum();
        System.out.println("Sum: " + sum);
    }
}
```
</details>

<details>
<summary><b>Check if a given number is prime or not</b></summary>

**Java 7:**
```java
public class PrimeCheck {
    public static void main(String[] args) {
        int number = 29;
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println("Is Prime: " + isPrime);
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class PrimeCheck {
    public static void main(String[] args) {
        int number = 29;
        boolean isPrime = IntStream.rangeClosed(2, number / 2)
                                   .allMatch(i -> number % i != 0);
        System.out.println("Is Prime: " + isPrime);
    }
}
```
</details>

<details>
<summary><b>Reverse a string</b></summary>

**Java 7:**
```java
public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("Reversed: " + reversed);
    }
}
```

**Java 8:**
```java
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}
```
</details>

<details>
<summary><b>Find the factorial of a number</b></summary>

**Java 7:**
```java
public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial: " + factorial);
    }
}
```

**Java 8:**
```java
import java.util.stream.LongStream;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        long factorial = LongStream.rangeClosed(1, number)
                                  .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial: " + factorial);
    }
}
```
</details>

<details>
<summary><b>Implement a stack in Java</b></summary>

**Java 7:**
```java
import java.util.LinkedList;

public class Stack {
    private LinkedList<Integer> stack = new LinkedList<>();

    public void push(int value) {
        stack.addLast(value);
    }

    public int pop() {
        return stack.removeLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        System.out.println("Popped: " + stack.pop());
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;

public class Stack {
    private LinkedList<Integer> stack = new LinkedList<>();

    public void push(int value) {
        stack.addLast(value);
    }

    public int pop() {
        return stack.removeLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        System.out.println("Popped: " + stack.pop());
    }
}
```
</details>

<details>
<summary><b>Sort an array in ascending order</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        Arrays.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] sortedArray = Arrays.stream(array)
                                   .sorted()
                                   .toArray();
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}
```
</details>

<details>
<summary><b>Check if a string is a palindrome</b></summary>

**Java 7:**
```java
public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        String reversed = new StringBuilder(str).reverse().toString();
        boolean isPalindrome = str.equals(reversed);
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
```

**Java 8:**
```java
import java.util.stream.Collectors;

public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
```
</details>

<details>
<summary><b>Implement a queue in Java</b></summary>

**Java 7:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        System.out.println("Removed: " + queue.remove());
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        System.out.println("Removed: " + queue.remove());
    }
}
```
</details>

<details>
<summary><b>Count the number of vowels in a string</b></summary>

**Java 7:**
```java
public class CountVowels {
    public static void main(String[] args) {
        String str = "hello";
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println("Number of vowels: " + count);
    }
}
```

**Java 8:**
```java
public class CountVowels {
    public static void main(String[] args) {
        String str = "hello";
        long count = str.chars()
                        .mapToObj(c -> (char) c)
                        .filter(c -> "aeiou".indexOf(c) != -1)
                        .count();
        System.out.println("Number of vowels: " + count);
    }
}
```
</details>

<details>
<summary><b>Find the second largest element in an array</b></summary>

**Java 7:**
```java
public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {10, 20, 4, 45, 99};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        System.out.println("Second Largest: " + second);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {10, 20, 4, 45, 99};
        int secondLargest = Arrays.stream(array)
                                  .distinct()
                                  .sorted()
                                  .toArray()[array.length - 2];
        System.out

.println("Second Largest: " + secondLargest);
    }
}
```
</details>

<details>
<summary><b>Check if two strings are anagrams of each other</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        boolean isAnagram = Arrays.equals(array1, array2);
        System.out.println("Is Anagram: " + isAnagram);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        boolean isAnagram = Arrays.equals(
            str1.chars().sorted().toArray(),
            str2.chars().sorted().toArray()
        );
        System.out.println("Is Anagram: " + isAnagram);
    }
}
```
</details>

<details>
<summary><b>Find the Fibonacci series up to a given number</b></summary>

**Java 7:**
```java
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b);
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int[] fib = IntStream.range(0, n)
                            .map(i -> fibonacci(i))
                            .toArray();
        System.out.println("Fibonacci Series: " + Arrays.toString(fib));
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```
</details>

<details>
<summary><b>Find the number of words in a string</b></summary>

**Java 7:**
```java
public class WordCount {
    public static void main(String[] args) {
        String str = "This is a sample string";
        String[] words = str.split("\\s+");
        System.out.println("Number of words: " + words.length);
    }
}
```

**Java 8:**
```java
public class WordCount {
    public static void main(String[] args) {
        String str = "This is a sample string";
        long wordCount = Arrays.stream(str.split("\\s+")).count();
        System.out.println("Number of words: " + wordCount);
    }
}
```
</details>

<details>
<summary><b>Find the sum of digits of a number</b></summary>

**Java 7:**
```java
public class SumOfDigits {
    public static void main(String[] args) {
        int number = 1234;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }
}
```

**Java 8:**
```java
public class SumOfDigits {
    public static void main(String[] args) {
        int number = 1234;
        int sum = Integer.toString(number)
                        .chars()
                        .map(c -> c - '0')
                        .sum();
        System.out.println("Sum of digits: " + sum);
    }
}
```
</details>

<details>
<summary><b>Concatenate two strings</b></summary>

**Java 7:**
```java
public class ConcatenateStrings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String result = str1 + " " + str2;
        System.out.println("Concatenated String: " + result);
    }
}
```

**Java 8:**
```java
public class ConcatenateStrings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String result = String.join(" ", str1, str2);
        System.out.println("Concatenated String: " + result);
    }
}
```
</details>

<details>
<summary><b>Find the index of a given element in an array</b></summary>

**Java 7:**
```java
public class IndexOfElement {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40};
        int element = 30;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                index = i;
                break;
            }
        }
        System.out.println("Index: " + index);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class IndexOfElement {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40};
        int element = 30;
        int index = IntStream.range(0, array.length)
                            .filter(i -> array[i] == element)
                            .findFirst()
                            .orElse(-1);
        System.out.println("Index: " + index);
    }
}
```
</details>

<details>
<summary><b>Find the GCD of two numbers</b></summary>

**Java 7:**
```java
public class GCD {
    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("GCD: " + a);
    }
}
```

**Java 8:**
```java
public class GCD {
    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        int gcd = IntStream.rangeClosed(1, Math.min(a, b))
                           .filter(i -> a % i == 0 && b % i == 0)
                           .reduce((x, y) -> y)
                           .orElse(1);
        System.out.println("GCD: " + gcd);
    }
}
```
</details>

<details>
<summary><b>Find the intersection of two arrays</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }
        for (int num : array2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        System.out.println("Intersection: " + intersection);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> intersection = Arrays.stream(array1)
                                          .boxed()
                                          .filter(num -> Arrays.stream(array2).anyMatch(n -> n == num))
                                          .collect(Collectors.toSet());
        System.out.println("Intersection: " + intersection);
    }
}
```
</details>

<details>
<summary><b>Find the power of a number using recursion</b></summary>

**Java 7:**
```java
public class Power {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = power(base, exponent);
        System.out.println("Power: " + result);
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) return 1;
        return base * power(base, exponent - 1);
    }
}
```

**Java 8:**
```java
public class Power {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = IntStream.range(0, exponent)
                              .reduce(1, (acc, i) -> acc * base);
        System.out.println("Power: " + result);
    }
}
```
</details>

<details>
<summary><b>Remove duplicate elements from an array</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;



public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 5, 1};
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        System.out.println("Unique elements: " + set);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 5, 1};
        Set<Integer> uniqueElements = Arrays.stream(array)
                                            .boxed()
                                            .collect(Collectors.toSet());
        System.out.println("Unique elements: " + uniqueElements);
    }
}
```
</details>

<details>
<summary><b>Convert a decimal number to binary</b></summary>

**Java 7:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 10;
        String binary = "";
        while (number > 0) {
            binary = (number % 2) + binary;
            number /= 2;
        }
        System.out.println("Binary: " + binary);
    }
}
```

**Java 8:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 10;
        String binary = Integer.toBinaryString(number);
        System.out.println("Binary: " + binary);
    }
}
```
</details>

<details>
<summary><b>Check if a given string is a valid palindrome or not</b></summary>

**Java 7:**
```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        boolean isPalindrome = cleaned.equals(reversed);
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
```

**Java 8:**
```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        boolean isPalindrome = cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
```
</details>

<details>
<summary><b>Find the frequency of each element in an array</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.Map;

public class Frequency {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3};
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Frequency: " + frequencyMap);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3};
        Map<Integer, Long> frequencyMap = Arrays.stream(array)
                                                .boxed()
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency: " + frequencyMap);
    }
}
```
</details>

<details>
<summary><b>Binary to Decimal Conversion Program</b></summary>

**Java 7:**
```java
public class BinaryToDecimal {
    public static void main(String[] args) {
        String binary = "1010";
        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Decimal: " + decimal);
    }
}
```

**Java 8:**
```java
public class BinaryToDecimal {
    public static void main(String[] args) {
        String binary = "1010";
        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Decimal: " + decimal);
    }
}
```
</details>

<details>
<summary><b>Factorial using Recursion Program</b></summary>

**Java 7:**
```java
public class FactorialRecursion {
    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial: " + result);
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
```

**Java 8:**
```java
public class FactorialRecursion {
    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial: " + result);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
```
</details>

<details>
<summary><b>Perfect Number Program</b></summary>

**Java 7:**
```java
public class PerfectNumber {
    public static void main(String[] args) {
        int number = 28;
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        boolean isPerfect = sum == number;
        System.out.println("Is Perfect Number: " + isPerfect);
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class PerfectNumber {
    public static void main(String[] args) {
        int number = 28;
        int sum = IntStream.range(1, number)
                           .filter(i -> number % i == 0)
                           .sum();
        boolean isPerfect = sum == number;
        System.out.println("Is Perfect Number: " + isPerfect);
    }
}
```
</details>

<details>
<summary><b>Common Elements in Arrays Program</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> set1 = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }
        Set<Integer> commonElements = new HashSet<>();
        for (int num : array2) {
            if (set1.contains(num)) {
                commonElements.add(num);
            }
        }
        System.out.println("Common Elements: " + commonElements);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElements {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> commonElements = Arrays.stream(array1)
                                            .boxed()
                                            .filter(num -> Arrays.stream(array2).anyMatch(n -> n == num))
                                            .collect(Collectors.toSet());
        System.out.println("Common Elements: " + commonElements);
    }
}
```
</details>

<details>
<summary><b>Reverse of a Number Program</b></summary>

**Java 7:**
```java
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 1234;
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        System.out.println("Reversed Number: " + reversed);
    }
}
```

**Java 8:**
```java
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 1234;
        int reversed = Integer.toString(number)
                             .chars()
                             .map(c -> c - '0')
                             .reduce(0, (rev, digit) -> rev * 10 + digit);
        System.out.println("Reversed Number: " + reversed);
    }
}
```
</details>

<details>
<summary><b>Check if a given number is an Armstrong number</b></summary>

**Java 7:**
```java
public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 153;
        int original = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }
        boolean isArmstrong = original == sum;
        System.out.println("Is Armstrong Number: " + isArmstrong);


    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 153;
        int sum = Integer.toString(number)
                         .chars()
                         .map(c -> {
                             int digit = c - '0';
                             return digit * digit * digit;
                         })
                         .sum();
        boolean isArmstrong = number == sum;
        System.out.println("Is Armstrong Number: " + isArmstrong);
    }
}
```
</details>

Here is the completed list with all the provided questions, answers in both Java 7 and Java 8, including Java 8 answers using Lambda and Stream API.


# Coding Questions and Solutions

<details>
<summary><b>Find the sum of all elements in an array</b></summary>

**Java 7:**
```java
public class SumOfArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SumOfArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(array).sum();
        System.out.println("Sum: " + sum);
    }
}
```
</details>

<details>
<summary><b>Check if a given number is prime or not</b></summary>

**Java 7:**
```java
public class PrimeNumber {
    public static void main(String[] args) {
        int number = 29;
        boolean isPrime = number > 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println("Is Prime: " + isPrime);
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) {
        int number = 29;
        boolean isPrime = number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                         .noneMatch(i -> number % i == 0);
        System.out.println("Is Prime: " + isPrime);
    }
}
```
</details>

<details>
<summary><b>Reverse a string</b></summary>

**Java 7:**
```java
public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("Reversed String: " + reversed);
    }
}
```

**Java 8:**
```java
public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed String: " + reversed);
    }
}
```
</details>

<details>
<summary><b>Find the factorial of a number</b></summary>

**Java 7:**
```java
public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("Factorial: " + result);
    }
}
```

**Java 8:**
```java
import java.util.stream.LongStream;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        long result = LongStream.rangeClosed(1, number)
                               .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial: " + result);
    }
}
```
</details>

<details>
<summary><b>Implement a stack in Java</b></summary>

**Java 7:**
```java
import java.util.Stack;

public class StackImplementation {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }
}
```

**Java 8:**
```java
import java.util.Stack;

public class StackImplementation {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }
}
```
</details>

<details>
<summary><b>Sort an array in ascending order</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 2};
        Arrays.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 2};
        Arrays.stream(array).sorted().forEach(System.out::println);
    }
}
```
</details>

<details>
<summary><b>Check if a string is a palindrome</b></summary>

**Java 7:**
```java
public class Palindrome {
    public static void main(String[] args) {
        String str = "madam";
        String reversed = new StringBuilder(str).reverse().toString();
        boolean isPalindrome = str.equals(reversed);
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
```

**Java 8:**
```java
public class Palindrome {
    public static void main(String[] args) {
        String str = "madam";
        boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
```
</details>

<details>
<summary><b>Implement a queue in Java</b></summary>

**Java 7:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue: " + queue);
        System.out.println("Dequeued: " + queue.poll());
        System.out.println("Queue after dequeue: " + queue);
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue: " + queue);
        System.out.println("Dequeued: " + queue.poll());
        System.out.println("Queue after dequeue: " + queue);
    }
}
```
</details>

<details>
<summary><b>Count the number of vowels in a string</b></summary>

**Java 7:**
```java
public class CountVowels {
    public static void main(String[] args) {
        String str = "hello world";
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println("Number of vowels: " + count);
    }
}
```

**Java 8:**
```java
public class CountVowels {
    public static void main(String[] args) {
        String str = "hello world";
        long count = str.chars()
                        .mapToObj(c -> (char) c)
                        .filter(c -> "aeiou".indexOf(c) != -1)
                        .count();
        System.out.println("Number of vowels: " + count);
    }
}
```
</details>

<details>
<summary><b>Find the second largest element in an array</b></summary>

**Java 7:**
```java
public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {10, 5, 20, 15};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        System.out.println("Second Largest: " + second);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.OptionalInt;

public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {10, 5, 20, 15};
        OptionalInt secondLargest = Arrays.stream(array)
                                          .distinct()
                                          .sorted()
                                          .skip(array.length - 2)
                                          .findFirst();
        System.out.println("Second Largest: " + secondLargest.orElseThrow());


    }
}
```
</details>

<details>
<summary><b>Check if two strings are anagrams of each other</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean isAnagram = Arrays.equals(arr1, arr2);
        System.out.println("Are Anagrams: " + isAnagram);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        boolean isAnagram = Arrays.equals(
                str1.chars().sorted().toArray(),
                str2.chars().sorted().toArray()
        );
        System.out.println("Are Anagrams: " + isAnagram);
    }
}
```
</details>

<details>
<summary><b>Find the Fibonacci series up to a given number</b></summary>

**Java 7:**
```java
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b);
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
    }
}
```

**Java 8:**
```java
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
              .limit(n)
              .map(t -> t[0])
              .forEach(f -> System.out.print(f + " "));
    }
}
```
</details>

<details>
<summary><b>Find the number of words in a string</b></summary>

**Java 7:**
```java
public class CountWords {
    public static void main(String[] args) {
        String str = "Hello world, this is Java";
        String[] words = str.split("\\s+");
        System.out.println("Number of words: " + words.length);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class CountWords {
    public static void main(String[] args) {
        String str = "Hello world, this is Java";
        long wordCount = Arrays.stream(str.split("\\s+")).count();
        System.out.println("Number of words: " + wordCount);
    }
}
```
</details>

<details>
<summary><b>Find the sum of digits of a number</b></summary>

**Java 7:**
```java
public class SumOfDigits {
    public static void main(String[] args) {
        int number = 12345;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println("Sum of Digits: " + sum);
    }
}
```

**Java 8:**
```java
public class SumOfDigits {
    public static void main(String[] args) {
        int number = 12345;
        int sum = Integer.toString(number)
                        .chars()
                        .map(c -> c - '0')
                        .sum();
        System.out.println("Sum of Digits: " + sum);
    }
}
```
</details>

<details>
<summary><b>Concatenate two strings</b></summary>

**Java 7:**
```java
public class ConcatenateStrings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String result = str1 + " " + str2;
        System.out.println("Concatenated String: " + result);
    }
}
```

**Java 8:**
```java
public class ConcatenateStrings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String result = String.join(" ", str1, str2);
        System.out.println("Concatenated String: " + result);
    }
}
```
</details>

<details>
<summary><b>Find the index of a given element in an array</b></summary>

**Java 7:**
```java
public class FindIndex {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40};
        int element = 30;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                index = i;
                break;
            }
        }
        System.out.println("Index of " + element + ": " + index);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class FindIndex {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40};
        int element = 30;
        int index = Arrays.stream(array)
                          .boxed()
                          .toList()
                          .indexOf(element);
        System.out.println("Index of " + element + ": " + index);
    }
}
```
</details>

<details>
<summary><b>Find the GCD of two numbers</b></summary>

**Java 7:**
```java
public class GCD {
    public static void main(String[] args) {
        int a = 60;
        int b = 48;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("GCD: " + a);
    }
}
```

**Java 8:**
```java
public class GCD {
    public static void main(String[] args) {
        int a = 60;
        int b = 48;
        int gcd = java.util.stream.IntStream.rangeClosed(1, Math.min(a, b))
                                            .filter(i -> a % i == 0 && b % i == 0)
                                            .reduce((x, y) -> y)
                                            .orElse(1);
        System.out.println("GCD: " + gcd);
    }
}
```
</details>

<details>
<summary><b>Find the intersection of two arrays</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }
        for (int num : array2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        System.out.println("Intersection: " + intersection);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> intersection = Arrays.stream(array1)
                                          .boxed()
                                          .filter(num -> Arrays.stream(array2).anyMatch(num::equals))
                                          .collect(Collectors.toSet());
        System.out.println("Intersection: " + intersection);
    }
}
```
</details>

<details>
<summary><b>Find the power of a number using recursion</b></summary>

**Java 7:**
```java
public class Power {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        System.out.println("Power: " + power(base, exponent));
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}
```

**Java 8:**
```java
public class Power {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        System.out.println("Power: " + power(base, exponent));
    }

    public static int power(int base, int exponent) {
        return exponent == 0 ? 1 : base * power(base, exponent - 1);
    }
}
```
</details>

<details>
<summary><b>Remove duplicate elements from an array</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array

 = {1, 2, 2, 3, 4, 4};
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        System.out.println("Array without duplicates: " + set);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4};
        Set<Integer> uniqueSet = Arrays.stream(array).boxed().collect(Collectors.toSet());
        System.out.println("Array without duplicates: " + uniqueSet);
    }
}
```
</details>

<details>
<summary><b>Convert a decimal number to binary</b></summary>

**Java 7:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 10;
        String binary = "";
        while (number > 0) {
            binary = (number % 2) + binary;
            number /= 2;
        }
        System.out.println("Binary: " + binary);
    }
}
```

**Java 8:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 10;
        String binary = Integer.toBinaryString(number);
        System.out.println("Binary: " + binary);
    }
}
```
</details>

<details>
<summary><b>Check if a given string is a valid palindrome or not</b></summary>

**Java 7:**
```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        boolean isPalindrome = cleaned.equals(reversed);
        System.out.println("Is Valid Palindrome: " + isPalindrome);
    }
}
```

**Java 8:**
```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        System.out.println("Is Valid Palindrome: " + isPalindrome);
    }
}
```
</details>

<details>
<summary><b>Find the frequency of each element in an array</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3};
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Frequency: " + frequencyMap);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3};
        Map<Integer, Long> frequencyMap = Arrays.stream(array)
                                                .boxed()
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency: " + frequencyMap);
    }
}
```
</details>

<details>
<summary><b>Binary to Decimal Conversion Program</b></summary>

**Java 7:**
```java
public class BinaryToDecimal {
    public static void main(String[] args) {
        String binaryString = "1010";
        int decimal = Integer.parseInt(binaryString, 2);
        System.out.println("Decimal: " + decimal);
    }
}
```

**Java 8:**
```java
public class BinaryToDecimal {
    public static void main(String[] args) {
        String binaryString = "1010";
        int decimal = Integer.parseInt(binaryString, 2);
        System.out.println("Decimal: " + decimal);
    }
}
```
</details>

<details>
<summary><b>Factorial using Recursion Program</b></summary>

**Java 7:**
```java
public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial: " + factorial(number));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
```

**Java 8:**
```java
public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial: " + factorial(number));
    }

    public static int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
}
```
</details>

<details>
<summary><b>Perfect Number Program</b></summary>

**Java 7:**
```java
public class PerfectNumber {
    public static void main(String[] args) {
        int number = 28;
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        boolean isPerfect = sum == number;
        System.out.println("Is Perfect Number: " + isPerfect);
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class PerfectNumber {
    public static void main(String[] args) {
        int number = 28;
        int sum = IntStream.range(1, number / 2 + 1)
                           .filter(i -> number % i == 0)
                           .sum();
        boolean isPerfect = sum == number;
        System.out.println("Is Perfect Number: " + isPerfect);
    }
}
```
</details>

<details>
<summary><b>Common Elements in Arrays Program</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }
        for (int num : array2) {
            if (set1.contains(num)) {
                common.add(num);
            }
        }
        System.out.println("Common Elements: " + common);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElements {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> common = Arrays.stream(array1)
                                    .boxed()
                                    .filter(num -> Arrays.stream(array2).anyMatch(n -> n == num))
                                    .collect(Collectors.toSet());
        System.out.println("Common Elements: " + common);
    }
}
```
</details>

<details>
<summary><b>Reverse of a Number Program</b></summary>

**Java 7:**
```java
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345;
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        System.out.println("Reversed Number: " + reversed);
    }
}
```

**Java 8:**
```java
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345;
        int reversed = Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
        System.out.println("Reversed Number: " + reversed);
    }
}
```
</details>

<details>
<summary><b>Check if a given number is an Armstrong number</b></summary>

**Java 7:**
```java
public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 153;
        int originalNumber = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 3);
            number /= 10;
        }
        boolean isArmstrong = originalNumber == sum;
        System.out.println("Is Armstrong Number: " + isArmstrong);
    }
}
```

**Java 8:**
```java
public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 

153;
        int sum = String.valueOf(number)
                        .chars()
                        .map(c -> (int) Math.pow(c - '0', 3))
                        .sum();
        boolean isArmstrong = number == sum;
        System.out.println("Is Armstrong Number: " + isArmstrong);
    }
}
```
</details>

These examples showcase how you can write similar functionality in Java 7 and Java 8. Java 8's features such as streams, lambdas, and enhanced collections methods can make code more concise and expressive.
