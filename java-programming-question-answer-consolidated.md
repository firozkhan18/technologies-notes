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


Here's a Java 7 and Java 8 implementations for the given problems. Each section includes code for both Java 7 and Java 8.


# Java Coding Examples (Java 7 and Java 8)

<details><summary><b>1. Find the sum of all elements in an array</b></summary>

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

<details><summary><b>2. Check if a given number is prime or not</b></summary>

**Java 7:**
```java
public class PrimeNumber {
    public static void main(String[] args) {
        int number = 29;
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
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

<details><summary><b>3. Reverse a string</b></summary>

**Java 7:**
```java
public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = new StringBuilder(str).reverse().toString();
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

<details><summary><b>4. Find the factorial of a number</b></summary>

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
public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        int result = IntStream.rangeClosed(1, number)
                             .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial: " + result);
    }
}
```
</details>

<details><summary><b>5. Implement a stack in Java</b></summary>

**Java 7:**
```java
import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stack = new ArrayList<>();

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println("Pop: " + stack.pop());
    }
}
```

**Java 8:**
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
    private Deque<Integer> stack = new ArrayDeque<>();

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println("Pop: " + stack.pop());
    }
}
```
</details>

<details><summary><b>6. Sort an array in ascending order</b></summary>

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
        int[] sortedArray = Arrays.stream(array)
                                  .sorted()
                                  .toArray();
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}
```
</details>

<details><summary><b>7. Check if a string is a palindrome</b></summary>

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

<details><summary><b>8. Implement a queue in Java</b></summary>

**Java 7:**
```java
import java.util.LinkedList;

public class Queue {
    private LinkedList<Integer> queue = new LinkedList<>();

    public void enqueue(int value) {
        queue.addLast(value);
    }

    public int dequeue() {
        if (queue.isEmpty()) throw new RuntimeException("Queue is empty");
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
```

**Java 8:**
```java
import java.util.ArrayDeque;
import java.util.Queue;

public class Queue {
    private Queue<Integer> queue = new ArrayDeque<>();

    public void enqueue(int value) {
        queue.add(value);
    }

    public int dequeue() {
        if (queue.isEmpty()) throw new RuntimeException("Queue is empty");
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
```
</details>

<details><summary><b>9. Count the number of vowels in a string</b></summary>

**Java 7:**
```java
public class CountVowels {
    public static void main(String[] args) {
        String str = "Hello World";
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
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
        String str = "Hello World";
        long count = str.chars()
                        .mapToObj(c -> (char) c)
                        .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                        .count();
        System.out.println("Number of vowels: " + count);
    }
}
```
</details>

<details><summary><b>10. Find the second largest element in an array</b></summary>

**Java 7:**
```java
public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {10, 5, 20, 15};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int

 num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }
        System.out.println("Second Largest: " + secondLargest);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {10, 5, 20, 15};
        int secondLargest = Arrays.stream(array)
                                  .distinct()
                                  .sorted()
                                  .skip(Math.max(0, array.length - 2))
                                  .findFirst()
                                  .orElseThrow(() -> new RuntimeException("Array does not have enough distinct elements"));
        System.out.println("Second Largest: " + secondLargest);
    }
}
```
</details>

<details><summary><b>11. Check if two strings are anagrams of each other</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        boolean isAnagram = Arrays.equals(array1, array2);
        System.out.println("Are Anagrams: " + isAnagram);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class Anagram {
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

<details><summary><b>12. Find the Fibonacci series up to a given number</b></summary>

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
        IntStream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                 .limit(n)
                 .map(f -> f[0])
                 .forEach(f -> System.out.print(f + " "));
    }
}
```
</details>

<details><summary><b>13. Find the number of words in a string</b></summary>

**Java 7:**
```java
public class WordCount {
    public static void main(String[] args) {
        String str = "Hello world, this is a test";
        String[] words = str.split("\\s+");
        System.out.println("Number of words: " + words.length);
    }
}
```

**Java 8:**
```java
public class WordCount {
    public static void main(String[] args) {
        String str = "Hello world, this is a test";
        long count = str.chars()
                        .mapToObj(c -> (char) c)
                        .filter(c -> Character.isWhitespace(c))
                        .count() + 1; // Adding 1 for the last word
        System.out.println("Number of words: " + count);
    }
}
```
</details>

<details><summary><b>14. Find the sum of digits of a number</b></summary>

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
        System.out.println("Sum of digits: " + sum);
    }
}
```

**Java 8:**
```java
public class SumOfDigits {
    public static void main(String[] args) {
        int number = 12345;
        int sum = String.valueOf(number)
                        .chars()
                        .map(c -> c - '0')
                        .sum();
        System.out.println("Sum of digits: " + sum);
    }
}
```
</details>

<details><summary><b>15. Concatenate two strings</b></summary>

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

<details><summary><b>16. Find the index of a given element in an array</b></summary>

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
        System.out.println("Index of element: " + index);
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
        System.out.println("Index of element: " + index);
    }
}
```
</details>

<details><summary><b>17. Find the GCD of two numbers</b></summary>

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

<details><summary><b>18. Find the intersection of two arrays</b></summary>

**Java 7:**
```java
import java.util.HashSet;

public class Intersection {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }
        HashSet<Integer> intersection = new HashSet<>();
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
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        Set<Integer> set1 = Arrays.stream(array1).boxed().collect(Collectors.toSet());
        Set<Integer> intersection = Arrays.stream(array2)
                                          .boxed()
                                          .filter(set1::contains)
                                          .collect(Collectors.toSet());
        System.out.println("Intersection: " + intersection);
    }
}
```
</details>

<details><summary><b>19. Find the power of a number using recursion</b></summary>

**Java 7:**
```java
public class Power {
    public static

 void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = power(base, exponent);
        System.out.println("Result: " + result);
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}
```

**Java 8:**
```java
public class Power {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = (int) Math.pow(base, exponent);
        System.out.println("Result: " + result);
    }
}
```
</details>

<details><summary><b>20. Remove duplicate elements from an array</b></summary>

**Java 7:**
```java
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        HashSet<Integer> set = new HashSet<>();
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
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        Set<Integer> uniqueSet = Arrays.stream(array)
                                       .boxed()
                                       .collect(Collectors.toSet());
        System.out.println("Array without duplicates: " + uniqueSet);
    }
}
```
</details>

<details><summary><b>21. Convert a decimal number to binary</b></summary>

**Java 7:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 10;
        String binary = Integer.toBinaryString(decimal);
        System.out.println("Binary: " + binary);
    }
}
```

**Java 8:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 10;
        String binary = Integer.toBinaryString(decimal);
        System.out.println("Binary: " + binary);
    }
}
```
</details>

<details><summary><b>22. Check if a given string is a valid palindrome or not</b></summary>

**Java 7:**
```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        boolean isPalindrome = cleanStr.equals(reversed);
        System.out.println("Is Valid Palindrome: " + isPalindrome);
    }
}
```

**Java 8:**
```java
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
        System.out.println("Is Valid Palindrome: " + isPalindrome);
    }
}
```
</details>

<details><summary><b>23. Find the frequency of each element in an array</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.Map;

public class Frequency {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3, 4};
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Frequency Map: " + frequencyMap);
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
        int[] array = {1, 2, 2, 3, 3, 3, 4};
        Map<Integer, Long> frequencyMap = Arrays.stream(array)
                                                .boxed()
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency Map: " + frequencyMap);
    }
}
```
</details>

<details><summary><b>24. Binary to Decimal Conversion Program</b></summary>

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

<details><summary><b>25. Factorial using Recursion Program</b></summary>

**Java 7:**
```java
public class FactorialRecursion {
    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial: " + result);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
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

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
```
</details>

<details><summary><b>26. Perfect Number Program</b></summary>

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
public class PerfectNumber {
    public static void main(String[] args) {
        int number = 28;
        boolean isPerfect = IntStream.range(1, number)
                                     .filter(i -> number % i == 0)
                                     .sum() == number;
        System.out.println("Is Perfect Number: " + isPerfect);
    }
}
```
</details>

<details><summary><b>27. Common Elements in Arrays Program</b></summary>

**Java 7:**
```java
import java.util.HashSet;

public class CommonElements {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {3, 4, 5, 6};
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }
        HashSet<Integer> common = new HashSet<>();
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
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {3, 4, 5, 6};
        Set<Integer> common = Arrays.stream(array1)
                                    .boxed()
                                    .filter(num -> Arrays.stream(array2).anyMatch(num2 -> num2 == num))
                                    .collect(Collectors.toSet());
        System.out.println("Common Elements: " + common);
    }
}
```
</details>

<details><summary><b>28. Reverse of a Number Program</b></summary>

**Java 7:**
```java
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345;
        int reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10;
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
        int number = 

12345;
        int reversed = Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
        System.out.println("Reversed Number: " + reversed);
    }
}
```
</details>

<details><summary><b>29. Sum of N Natural Numbers Program</b></summary>

**Java 7:**
```java
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        int n = 10;
        int sum = n * (n + 1) / 2;
        System.out.println("Sum of first " + n + " natural numbers: " + sum);
    }
}
```

**Java 8:**
```java
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        int n = 10;
        int sum = IntStream.rangeClosed(1, n).sum();
        System.out.println("Sum of first " + n + " natural numbers: " + sum);
    }
}
```
</details>

<details><summary><b>30. LCM of Two Numbers Program</b></summary>

**Java 7:**
```java
public class LCM {
    public static void main(String[] args) {
        int a = 12;
        int b = 15;
        int lcm = (a > b) ? a : b;
        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                break;
            }
            lcm++;
        }
        System.out.println("LCM: " + lcm);
    }
}
```

**Java 8:**
```java
public class LCM {
    public static void main(String[] args) {
        int a = 12;
        int b = 15;
        int lcm = IntStream.iterate(Math.max(a, b), i -> i + 1)
                           .filter(i -> i % a == 0 && i % b == 0)
                           .findFirst()
                           .orElse(-1);
        System.out.println("LCM: " + lcm);
    }
}
```
</details>
<details><summary><b>31. Implement a binary search algorithm</b></summary>

**Java 7:**
```java
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = binarySearch(array, target);
        System.out.println("Index of " + target + ": " + result);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = Arrays.binarySearch(array, target);
        System.out.println("Index of " + target + ": " + result);
    }
}
```
</details>

<details><summary><b>32. Find the least common multiple (LCM) of two numbers</b></summary>

**Java 7:**
```java
public class LCM {
    public static void main(String[] args) {
        int a = 12;
        int b = 15;
        int lcm = (a > b) ? a : b;
        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                break;
            }
            lcm++;
        }
        System.out.println("LCM: " + lcm);
    }
}
```

**Java 8:**
```java
public class LCM {
    public static void main(String[] args) {
        int a = 12;
        int b = 15;
        int lcm = IntStream.iterate(Math.max(a, b), i -> i + 1)
                           .filter(i -> i % a == 0 && i % b == 0)
                           .findFirst()
                           .orElse(-1);
        System.out.println("LCM: " + lcm);
    }
}
```
</details>

<details><summary><b>33. Check if a string is a valid email address</b></summary>

**Java 7:**
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static void main(String[] args) {
        String email = "example@example.com";
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean isValid = matcher.matches();
        System.out.println("Is Valid Email: " + isValid);
    }
}
```

**Java 8:**
```java
import java.util.regex.Pattern;

public class ValidateEmail {
    public static void main(String[] args) {
        String email = "example@example.com";
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValid = Pattern.matches(regex, email);
        System.out.println("Is Valid Email: " + isValid);
    }
}
```
</details>

<details><summary><b>34. Find the length of the longest consecutive sequence of a given array</b></summary>

**Java 7:**
```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence: " + longestConsecutive(array));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence: " +
            Arrays.stream(array)
                  .boxed()
                  .collect(Collectors.toCollection(HashSet::new))
                  .stream()
                  .mapToInt(num -> {
                      if (numSet.contains(num - 1)) return 0;
                      int currentNum = num;
                      int currentStreak = 1;
                      while (numSet.contains(currentNum + 1)) {
                          currentNum += 1;
                          currentStreak += 1;
                      }
                      return currentStreak;
                  })
                  .max()
                  .orElse(0)
        );
    }
}
```
</details>

<details><summary><b>35. Find the roots of a quadratic equation</b></summary>

**Java 7:**
```java
public class QuadraticRoots {
    public static void main(String[] args) {
        double a = 1;
        double b = -3;
        double c = 2;
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Root is: " + root);
        } else {
            System.out.println("No real roots");
        }
    }
}
```

**Java 8:**
```java
public class QuadraticRoots {
    public static void main(String[] args) {
        double a = 1;
        double b = -3;
        double c = 2;
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Root is: " + root);
        } else {
            System.out.println("No real roots");
        }
    }
}
```
</details>

<details><summary><b>36. Find the area of a circle</b></summary>

**Java 7:**
```java
public class CircleArea {
    public static void main(String[] args) {
        double radius = 5;
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle: " + area);
    }
}
```

**Java 8:**
```java
public class CircleArea {
    public static void main(String[] args) {
        double radius = 5;
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle: " + area);
    }
}
```
</details>

<details><summary><b>37. Find the product of two matrices</b></summary>

**Java 7:**
```java
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{7, 8}, {9, 10}, {11, 12}};

        int[][] result = multiplyMatrices(matrix1, matrix2);
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1

 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{7, 8}, {9, 10}, {11, 12}};

        int[][] result = IntStream.range(0, matrix1.length)
            .mapToObj(i -> IntStream.range(0, matrix2[0].length)
                .map(j -> IntStream.range(0, matrix1[0].length)
                    .map(k -> matrix1[i][k] * matrix2[k][j])
                    .sum())
                .toArray())
            .toArray(int[][]::new);

        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
```
</details>

<details><summary><b>38. Find the median of an array</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class MedianOfArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 6, 7, 8, 9};
        Arrays.sort(array);

        double median;
        int length = array.length;
        if (length % 2 == 0) {
            median = (array[length / 2 - 1] + array[length / 2]) / 2.0;
        } else {
            median = array[length / 2];
        }

        System.out.println("Median: " + median);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class MedianOfArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 6, 7, 8, 9};
        Arrays.sort(array);

        double median = (array.length % 2 == 0) 
            ? (Arrays.stream(array).skip(array.length / 2 - 1).limit(2).average().orElse(0))
            : array[array.length / 2];

        System.out.println("Median: " + median);
    }
}
```
</details>

<details><summary><b>39. Binary Search Algorithm Program</b></summary>

**Java 7:**
```java
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = binarySearch(array, target);
        System.out.println("Index of " + target + ": " + result);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = Arrays.binarySearch(array, target);
        System.out.println("Index of " + target + ": " + result);
    }
}
```
</details>

<details><summary><b>40. Remove Element from Array Program</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int elementToRemove = 4;
        int[] newArray = removeElement(array, elementToRemove);
        System.out.println("Array after removal: " + Arrays.toString(newArray));
    }

    public static int[] removeElement(int[] array, int element) {
        return Arrays.stream(array)
                     .filter(x -> x != element)
                     .toArray();
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int elementToRemove = 4;
        int[] newArray = Arrays.stream(array)
                               .filter(x -> x != elementToRemove)
                               .toArray();
        System.out.println("Array after removal: " + Arrays.toString(newArray));
    }
}
```
</details>
<details><summary><b>41. Sum of Series Program</b></summary>

**Java 7:**
```java
public class SumOfSeries {
    public static void main(String[] args) {
        int n = 5; // Sum of series 1 + 2 + 3 + ... + n
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of series: " + sum);
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class SumOfSeries {
    public static void main(String[] args) {
        int n = 5; // Sum of series 1 + 2 + 3 + ... + n
        int sum = IntStream.rangeClosed(1, n).sum();
        System.out.println("Sum of series: " + sum);
    }
}
```
</details>

<details><summary><b>42. Count Occurrences of Character in a String Program</b></summary>

**Java 7:**
```java
public class CountCharacter {
    public static void main(String[] args) {
        String str = "hello world";
        char charToCount = 'o';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charToCount) {
                count++;
            }
        }
        System.out.println("Occurrences of '" + charToCount + "': " + count);
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class CountCharacter {
    public static void main(String[] args) {
        String str = "hello world";
        char charToCount = 'o';
        long count = str.chars().filter(c -> c == charToCount).count();
        System.out.println("Occurrences of '" + charToCount + "': " + count);
    }
}
```
</details>

<details><summary><b>43. Count Words in a Sentence Program</b></summary>

**Java 7:**
```java
public class CountWords {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence.";
        String[] words = sentence.split("\\s+");
        System.out.println("Number of words: " + words.length);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class CountWords {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence.";
        long wordCount = Arrays.stream(sentence.split("\\s+")).count();
        System.out.println("Number of words: " + wordCount);
    }
}
```
</details>

<details><summary><b>44. Bubble Sort Program</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        bubbleSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] sortedArray = IntStream.range(0, array.length)
            .boxed()
            .sorted((i, j) -> Integer.compare(array[i], array[j]))
            .mapToInt(i -> array[i])
            .toArray();
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
```
</details>

<details><summary><b>45. Decimal to Binary Conversion Program</b></summary>

**Java 7:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 29;
        String binary = Integer.toBinaryString(decimal);
        System.out.println("Binary representation: " + binary);
    }
}
```

**Java 8:**
```java
public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 29;
        String binary = Integer.toBinaryString(decimal);
        System.out.println("Binary representation: " + binary);
    }
}
```
</details>

<details><summary><b>46. Implement a linked list</b></summary>

**Java 7:**
```java
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList();
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(System.out::print);
        System.out.println();
    }
}
```
</details>

<details><summary><b>47. Find the transpose of a matrix</b></summary>

**Java 7:**
```java
public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] transpose = transposeMatrix(matrix);
        for (int[] row : transpose) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] transpose = IntStream.range(0, matrix[0].length)
            .mapToObj(j -> IntStream.range(0, matrix.length)
                .map(i -> matrix[i][j])
                .toArray())
            .toArray(int[][]::new);
        Arrays.stream(transpose).map(Arrays::toString).forEach(System.out::println);
    }
}
```
</details>

<details><summary><b>48. Find the average of an array</b></summary>

**Java 7:**
```java
public class AverageOfArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        double average = calculateAverage(array);
        System.out.println("Average: " + average);
    }

    public static double calculateAverage(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class AverageOfArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        double average = Arrays.stream(array).average().orElse(0);
        System.out.println("Average: " + average);
    }
}
```
</details>

<details><summary><b>49. Find the sum of odd numbers in an array</b></summary>

**Java 7:**
```java
public class SumOfOddNumbers {
    public static void main(String[] args) {
        int[] array = {1, 2, 3,

 4, 5, 6};
        int sum = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        System.out.println("Sum of odd numbers: " + sum);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = Arrays.stream(array).filter(num -> num % 2 != 0).sum();
        System.out.println("Sum of odd numbers: " + sum);
    }
}
```
</details>

<details><summary><b>50. Implement a selection Sort algorithm</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        selectionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        int[] sortedArray = IntStream.range(0, array.length)
            .boxed()
            .sorted((i, j) -> Integer.compare(array[i], array[j]))
            .mapToInt(i -> array[i])
            .toArray();
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
```
</details>

<details><summary><b>51. Find the maximum and minimum element in an array</b></summary>

**Java 7:**
```java
public class MaxMinElement {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8, 6};
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class MaxMinElement {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8, 6};
        int max = Arrays.stream(array).max().orElseThrow();
        int min = Arrays.stream(array).min().orElseThrow();
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }
}
```
</details>

<details><summary><b>52. Implement a Merge Sort algorithm</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < n1) {
            array[k++] = L[i++];
        }

        while (j < n2) {
            array[k++] = R[j++];
        }
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        int[] sortedArray = mergeSort(array);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
```
</details>

<details><summary><b>53. Count the number of prime numbers in a given range</b></summary>

**Java 7:**
```java
public class CountPrimes {
    public static void main(String[] args) {
        int start = 10;
        int end = 50;
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println("Number of prime numbers: " + count);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class CountPrimes {
    public static void main(String[] args) {
        int start = 10;
        int end = 50;
        long count = IntStream.rangeClosed(start, end)
                              .filter(CountPrimes::isPrime)
                              .count();
        System.out.println("Number of prime numbers: " + count);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        return IntStream.rangeClosed(3, (int) Math.sqrt(num))
                        .filter(i -> i % 2 != 0)
                        .noneMatch(i -> num % i == 0);
    }
}
```
</details>

<details><summary><b>54. Convert a decimal number to hexadecimal</b></summary>

**Java 7:**
```java
public class DecimalToHexadecimal {
    public static void main(String[] args) {
        int decimal = 255;
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();
        System.out.println("Hexadecimal representation: " + hexadecimal);
    }
}
```

**Java 8:**
```java
public class DecimalToHexadecimal {
    public static void main(String[] args) {
        int decimal = 255;
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();
        System.out.println("Hexadecimal representation: " + hexadecimal);
    }
}
```
</details>

<details><summary><b>55. Implement a quick Sort algorithm</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {10, 7, 8,

 9, 1, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
```
</details>

<details><summary><b>56. Find the sum of prime numbers up to a given number</b></summary>

**Java 7:**
```java
public class SumOfPrimes {
    public static void main(String[] args) {
        int limit = 10;
        int sum = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        System.out.println("Sum of prime numbers: " + sum);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class SumOfPrimes {
    public static void main(String[] args) {
        int limit = 10;
        int sum = IntStream.rangeClosed(2, limit)
                           .filter(SumOfPrimes::isPrime)
                           .sum();
        System.out.println("Sum of prime numbers: " + sum);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        return IntStream.rangeClosed(3, (int) Math.sqrt(num))
                        .filter(i -> i % 2 != 0)
                        .noneMatch(i -> num % i == 0);
    }
}
```
</details>

<details><summary><b>57. Generate a random number between a given range</b></summary>

**Java 7:**
```java
import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
    }
}
```

**Java 8:**
```java
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
    }
}
```
</details>

<details><summary><b>58. Implement a binary tree</b></summary>

**Java 7:**
```java
public class BinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
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
        tree.inorder();
    }
}
```

**Java 8:**
```java
import java.util.function.Consumer;

public class BinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder(Consumer<Integer> action) {
        inorderRec(root, action);
    }

    private void inorderRec(Node root, Consumer<Integer> action) {
        if (root != null) {
            inorderRec(root.left, action);
            action.accept(root.data);
            inorderRec(root.right, action);
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
        tree.inorder(System.out::print);
    }
}
```
</details>

<details><summary><b>59. Find the longest common prefix in an array of strings</b></summary>

**Java 7:**
```java
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Optional;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return Arrays.stream(strs)
                     .reduce((s

1, s2) -> {
                         int i = 0;
                         while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
                             i++;
                         }
                         return s1.substring(0, i);
                     }).orElse("");
    }
}
```
</details>

<details><summary><b>60. Find the middle element of a linked list</b></summary>

**Java 7:**
```java
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void printMiddle() {
        Node slow = head;
        Node fast = head;
        if (head != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            System.out.println("Middle element is " + slow.data);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        list.printMiddle();
    }
}
```

**Java 8:**
```java
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void printMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("Middle element is " + slow.data);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        list.printMiddle();
    }
}
```
</details>
<details><summary><b>61. Heap Sort algorithm Implementation</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        heapSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        heapSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
```
</details>

<details><summary><b>62. Longest palindrome substring in a string</b></summary>

**Java 7:**
```java
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("Longest palindrome substring: " + result);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
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

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```

**Java 8:**
```java
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("Longest palindrome substring: " + result);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int[] result = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int[] len1 = expandAroundCenter(s, i, i);
            int[] len2 = expandAroundCenter(s, i, i + 1);
            int[] len = len1[1] > len2[1] ? len1 : len2;
            if (len[1] > result[1]) {
                result = len;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    private static int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}
```
</details>

<details><summary><b>63. Sum of all even numbers in an array</b></summary>

**Java 7:**
```java
public class SumOfEvens {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        System.out.println("Sum of all even numbers: " + sum);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SumOfEvens {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = Arrays.stream(array)
                         .filter(num -> num % 2 == 0)
                         .sum();
        System.out.println("Sum of all even numbers: " + sum);
    }
}
```
</details>

<details><summary><b>64. Depth-First Search Algorithm</b></summary>

**Java 7:**
```java
import java.util.*;

public class DFS {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int v, int w) {
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");
        List<Integer> edges = graph.get(v);
        if (edges != null) {
            for (int neighbor : edges) {
                if (!visited.contains(neighbor)) {
                    dfsUtil(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.dfs(1);
    }
}
```

**Java 8:**
```java
import java.util.*;

public class DFS {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int v, int w) {
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");
        graph.getOrDefault(v, Collections.emptyList())
              .stream()
              .filter(neighbor -> !visited.contains(neighbor))
              .forEach(neighbor -> dfsUtil(neighbor, visited));
    }

    public static void main(String[] args) {
        DFS graph = new DFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.dfs(1);
    }
}
```
</details>

<details><summary><b>65. Find Kth Largest Element in an Array</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class KthLargest {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(array, k);
        System.out.println("The " + k + "th largest element is " + result);
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class KthLargest {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = Arrays.stream(array)
                            .boxed()
                            .sorted((a, b) -> b - a)
                            .skip(k - 1)
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("K is out of bounds"));
        System.out.println("The " + k + "th largest element is " + result);
    }
}
```
</details>

<details><summary><b>66. Number of Ways to Climb Stairs</b></summary>

**Java 7:**
```java
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

**Java 8:**
```java
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }

    public static int climbStairs(int n) {
        return (n <= 1) ? 1 : climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```
</details>

<details><summary><b>67. Breadth-First Search Algorithm</b></summary>

**Java 7:**
```java
import java.util.*;

public class BFS {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int v, int w) {
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            List<Integer> edges = graph.get(node);
            if (edges != null) {
                for (int neighbor : edges) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.bfs(1);
    }
}
```

**Java 8:**
```java
import java.util.*;

public class BFS {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int v, int w) {
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            graph.getOrDefault(node, Collections.emptyList())
                  .stream()
                  .filter(neighbor -> !visited.contains(neighbor))
                  .forEach(neighbor -> {
                      visited.add(neighbor);
                      queue.add(neighbor);
                  });
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.bfs(1);
    }
}
```
</details>

<details><summary><b>68. Find Missing Element in Arithmetic Progression</b></summary>

**Java 7:**
```java
public class MissingElement {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 15};
        int missing = findMissingElement(array);
        System.out.println("Missing element is " + missing);
    }

    public static int findMissingElement(int[] array) {
        int n = array.length + 1;
        int diff = (array[array.length - 1] - array[0]) / n;
        int expected = array[0];
        for (int num : array) {
            if (num != expected) {
                return expected;
            }
            expected += diff;
        }
        return -1; // No missing element
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class MissingElement {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 15};
        int missing = findMissingElement(array);
        System.out.println("Missing element is " + missing);
    }

    public static int findMissingElement(int[] array) {
        int n = array.length + 1;
        int diff = (array[array.length - 1] - array[0]) / n;
        return IntStream.range(0, array.length)
                        .map(i -> array[0] + i * diff)
                        .filter(expected -> expected != array[i])
                        .findFirst()
                        .orElse(-1);
    }
}
```
</details>

<details><summary><b>69. Dijkstra's Algorithm</b></summary>

**Java 7:**
```java
import java.util.*;

public class DijkstraAlgorithm {
    private final Map<Integer, List<Edge>> graph = new HashMap<>();

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void addEdge(int source, int destination, int weight) {
        graph.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
    }

    public void dijkstra(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        pq.add(new Node(start, 0));
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Edge edge : graph.getOrDefault(node.id, Collections.emptyList())) {
                int newDist = node.distance + edge.weight;
                if (newDist < distances.getOrDefault(edge.destination, Integer.MAX_VALUE)) {
                    distances.put(edge.destination, newDist);
                    pq.add(new Node(edge.destination, newDist));
                }
            }
        }

        System.out.println("Shortest distances from start node:");
        distances.forEach((key, value) -> System.out.println("Node " + key + ": " + value));
    }

    static class Node {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm();
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 1);
        graph.dijkstra(1);
    }
}
```

**Java 8:**
```java
import java.util.*;

public class DijkstraAlgorithm {
    private final Map<Integer, List<Edge>> graph = new HashMap<>();

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void addEdge(int source, int destination, int weight) {
        graph.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge

(destination, weight));
    }

    public void dijkstra(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        pq.add(new Node(start, 0));
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            graph.getOrDefault(node.id, Collections.emptyList())
                 .forEach(edge -> {
                     int newDist = node.distance + edge.weight;
                     if (newDist < distances.getOrDefault(edge.destination, Integer.MAX_VALUE)) {
                         distances.put(edge.destination, newDist);
                         pq.add(new Node(edge.destination, newDist));
                     }
                 });
        }

        System.out.println("Shortest distances from start node:");
        distances.forEach((key, value) -> System.out.println("Node " + key + ": " + value));
    }

    static class Node {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm();
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 1);
        graph.dijkstra(1);
    }
}
```
</details>

<details><summary><b>70. Maximum Path Sum in Binary Tree</b></summary>

**Java 7:**
```java
public class MaxPathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPath(root);
        return maxSum;
    }

    private int calculateMaxPath(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(calculateMaxPath(node.left), 0);
        int right = Math.max(calculateMaxPath(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxPathSum solution = new MaxPathSum();
        System.out.println("Maximum path sum: " + solution.maxPathSum(root));
    }
}
```

**Java 8:**
```java
public class MaxPathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPath(root);
        return maxSum;
    }

    private int calculateMaxPath(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(calculateMaxPath(node.left), 0);
        int right = Math.max(calculateMaxPath(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxPathSum solution = new MaxPathSum();
        System.out.println("Maximum path sum: " + solution.maxPathSum(root));
    }
}
```
</details>

<details><summary><b>71. Implement a Bellman-Ford algorithm</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class BellmanFord {
    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = {
            new Edge(0, 1, -1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 3),
            new Edge(1, 3, 2),
            new Edge(1, 4, 2),
            new Edge(3, 2, 5),
            new Edge(3, 1, 1),
            new Edge(4, 3, -3)
        };

        BellmanFord bf = new BellmanFord();
        bf.bellmanFord(vertices, edges, 0);
    }

    public void bellmanFord(int vertices, Edge[] edges, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance to " + i + ": " + dist[i]);
        }
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class BellmanFord {
    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = {
            new Edge(0, 1, -1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 3),
            new Edge(1, 3, 2),
            new Edge(1, 4, 2),
            new Edge(3, 2, 5),
            new Edge(3, 1, 1),
            new Edge(4, 3, -3)
        };

        BellmanFord bf = new BellmanFord();
        bf.bellmanFord(vertices, edges, 0);
    }

    public void bellmanFord(int vertices, Edge[] edges, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        IntStream.range(0, vertices - 1).forEach(i -> 
            Arrays.stream(edges).forEach(edge -> {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            })
        );

        boolean hasNegativeCycle = Arrays.stream(edges)
                                         .anyMatch(edge -> dist[edge.u] != Integer.MAX_VALUE &&
                                                            dist[edge.u] + edge.weight < dist[edge.v]);
        if (hasNegativeCycle) {
            System.out.println("Graph contains negative weight cycle");
            return;
        }

        System.out.println("Shortest distances from source:");
        IntStream.range(0, dist.length)
                 .forEach(i -> System.out.println("Distance to " + i + ": " + dist[i]));
    }
}
```
</details>

<details><summary><b>72. Find the intersection of two linked lists</b></summary>

**Java 7:**
```java
public class LinkedListIntersection {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(9);
        headB.next = new ListNode(8);


        headB.next.next = headA.next.next.next;

        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.println("Intersection node value: " + (intersection != null ? intersection.val : "No intersection"));
    }
}
```

**Java 8:**
```java
public class LinkedListIntersection {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(9);
        headB.next = new ListNode(8);
        headB.next.next = headA.next.next.next;

        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.println("Intersection node value: " + (intersection != null ? intersection.val : "No intersection"));
    }
}
```
</details>

<details><summary><b>73. Find the first missing positive integer</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int result = findFirstMissingPositive(nums);
        System.out.println("The first missing positive integer is " + result);
    }

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int result = findFirstMissingPositive(nums);
        System.out.println("The first missing positive integer is " + result);
    }

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        IntStream.range(0, n).forEach(i -> {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        });

        return IntStream.range(0, n)
                        .filter(i -> nums[i] != i + 1)
                        .findFirst()
                        .map(i -> i + 1)
                        .orElse(n + 1);
    }
}
```
</details>

<details><summary><b>74. Minimum Window Substring</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Minimum window substring is " + result);
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int required = tCount.size();
        int left = 0, right = 0, formed = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCount.put(c, windowCount.get(c) - 1);
                if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
```

**Java 8:**
```java
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Minimum window substring is " + result);
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> tCount = new HashMap<>();
        t.chars().forEach(c -> tCount.put((char)c, tCount.getOrDefault((char)c, 0) + 1));

        int required = tCount.size();
        Map<Character, Integer> windowCount = new HashMap<>();
        int[] ans = {-1, 0, 0};

        for (int left = 0, right = 0, formed = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && windowCount.get(c).equals(tCount.get(c))) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCount.put(c, windowCount.get(c) - 1);
                if (tCount.containsKey(c) && windowCount.get(c) < tCount.get(c)) {
                    formed--;
                }
                left++;
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
```
</details>
<details><summary><b>75. Find the number of connected components in a graph</b></summary>

**Java 7:**
```java
import java.util.*;

public class ConnectedComponents {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public int countComponents() {
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponents cc = new ConnectedComponents();
        cc.addEdge(0, 1);
        cc.addEdge(1, 2);
        cc.addEdge(3, 4);
        System.out.println("Number of connected components: " + cc.countComponents());
    }
}
```

**Java 8:**
```java
import java.util.*;
import java.util.stream.IntStream;

public class ConnectedComponents {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public long countComponents() {
        Set<Integer> visited = new HashSet<>();
        return graph.keySet().stream()
                    .filter(node -> !visited.contains(node))
                    .peek(node -> dfs(node, visited))
                    .count();
    }

    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);
        graph.getOrDefault(node, Collections.emptyList())
             .forEach(neighbor -> {
                 if (!visited.contains(neighbor)) {
                     dfs(neighbor, visited);
                 }
             });
    }

    public static void main(String[] args) {
        ConnectedComponents cc = new ConnectedComponents();
        cc.addEdge(0, 1);
        cc.addEdge(1, 2);
        cc.addEdge(3, 4);
        System.out.println("Number of connected components: " + cc.countComponents());
    }
}
```
</details>

<details><summary><b>76. Find the maximum profit by buying and selling stocks</b></summary>

**Java 7:**
```java
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit is " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit is " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        final int[] minPrice = {Integer.MAX_VALUE};
        final int[] maxProfit = {0};

        IntStream.of(prices).forEach(price -> {
            if (price < minPrice[0]) {
                minPrice[0] = price;
            } else {
                maxProfit[0] = Math.max(maxProfit[0], price - minPrice[0]);
            }
        });

        return maxProfit[0];
    }
}
```
</details>

<details><summary><b>77. Implement Prim's algorithm</b></summary>

**Java 7:**
```java
import java.util.*;

public class PrimsAlgorithm {
    private Map<Integer, List<Edge>> graph = new HashMap<>();

    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) { this.dest = dest; this.weight = weight; }
    }

    public void addEdge(int src, int dest, int weight) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
        graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, weight));
    }

    public void prims(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Integer> visited = new HashSet<>();
        pq.addAll(graph.getOrDefault(start, Collections.emptyList()));

        int totalWeight = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited.contains(edge.dest)) continue;
            visited.add(edge.dest);
            totalWeight += edge.weight;

            for (Edge nextEdge : graph.getOrDefault(edge.dest, Collections.emptyList())) {
                if (!visited.contains(nextEdge.dest)) {
                    pq.add(nextEdge);
                }
            }
        }

        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        PrimsAlgorithm graph = new PrimsAlgorithm();
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        graph.prims(0);
    }
}
```

**Java 8:**
```java
import java.util.*;

public class PrimsAlgorithm {
    private Map<Integer, List<Edge>> graph = new HashMap<>();

    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) { this.dest = dest; this.weight = weight; }
    }

    public void addEdge(int src, int dest, int weight) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
        graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, weight));
    }

    public void prims(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Integer> visited = new HashSet<>();
        pq.addAll(graph.getOrDefault(start, Collections.emptyList()));

        final int[] totalWeight = {0};
        pq.forEach(edge -> {
            if (visited.contains(edge.dest)) return;
            visited.add(edge.dest);
            totalWeight[0] += edge.weight;
            graph.getOrDefault(edge.dest, Collections.emptyList())
                .stream()
                .filter(nextEdge -> !visited.contains(nextEdge.dest))
                .forEach(pq::add);
        });

        System.out.println("Total weight of MST: " + totalWeight[0]);
    }

    public static void main(String[] args) {
        PrimsAlgorithm graph = new PrimsAlgorithm();
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        graph.prims(0);
    }
}
```
</details>

<details><summary><b>78. Find the longest common subsequence in two strings</b></summary>

**Java 7:**
```java
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int result = longestCommonSubsequence(s1, s2);
        System.out.println("Length of LCS is " + result);
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "

ace";
        int result = longestCommonSubsequence(s1, s2);
        System.out.println("Length of LCS is " + result);
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        IntStream.range(1, m + 1).forEach(i -> IntStream.range(1, n + 1).forEach(j -> {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }));

        return dp[m][n];
    }
}
```
</details>

<details><summary><b>79. Implement Kruskal's algorithm</b></summary>

**Java 7:**
```java
import java.util.*;

public class KruskalAlgorithm {
    private class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private int[] parent;
    private int[] rank;

    private void makeSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int find(int u) {
        if (u != parent[u]) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    private void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public void kruskal(int n, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        makeSet(n);
        int mstWeight = 0;

        for (Edge edge : edges) {
            if (find(edge.src) != find(edge.dest)) {
                union(edge.src, edge.dest);
                mstWeight += edge.weight;
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm();
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        );

        graph.kruskal(4, edges);
    }
}
```

**Java 8:**
```java
import java.util.*;

public class KruskalAlgorithm {
    private class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private int[] parent;
    private int[] rank;

    private void makeSet(int n) {
        parent = new int[n];
        rank = new int[n];
        IntStream.range(0, n).forEach(i -> {
            parent[i] = i;
            rank[i] = 0;
        });
    }

    private int find(int u) {
        if (u != parent[u]) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    private void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public void kruskal(int n, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        makeSet(n);
        final int[] mstWeight = {0};

        edges.stream().filter(edge -> find(edge.src) != find(edge.dest))
             .forEach(edge -> {
                 union(edge.src, edge.dest);
                 mstWeight[0] += edge.weight;
             });

        System.out.println("Total weight of MST: " + mstWeight[0]);
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm();
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        );

        graph.kruskal(4, edges);
    }
}
```
</details>

<details><summary><b>80. Find the minimum spanning tree of a graph</b></summary>

**Java 7:**
```java
import java.util.*;

public class MinimumSpanningTree {
    private class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public void kruskal(int n, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        int[] parent = new int[n];
        int[] rank = new int[n];
        IntStream.range(0, n).forEach(i -> parent[i] = i);

        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            int root1 = find(edge.src, parent);
            int root2 = find(edge.dest, parent);

            if (root1 != root2) {
                mst.add(edge);
                mstWeight += edge.weight;
                union(root1, root2, parent, rank);
            }
        }

        System.out.println("Edges in the MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    private int find(int u, int[] parent) {
        if (parent[u] != u) {
            parent[u] = find(parent[u], parent);
        }
        return parent[u];
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public static void main(String[] args) {
        MinimumSpanningTree graph = new MinimumSpanningTree();
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        );

        graph.kruskal(4, edges);
    }
}
```

**Java 8:**
```java
import java.util.*;

public class MinimumSpanningTree {
    private class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public void kruskal(int n, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        int[] parent = new int[n];
        int[] rank = new int[n];
        IntStream.range(0, n).forEach(i -> parent[i] = i);

        List<Edge> mst = new ArrayList<>();
        final int[] mstWeight = {0};

        edges.stream().filter(edge -> find(edge.src, parent) != find(edge.dest, parent))
             .forEach(edge -> {
                 mst.add(edge);
                 mstWeight[0] += edge.weight;
                 union(find(edge.src, parent), find(edge.dest, parent), parent, rank);
             });

        System.out.println("Edges in the MST:");
        mst.forEach(edge -> System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight));
        System.out.println("Total weight of MST: " + mstWeight[0]);
    }



    private int find(int u, int[] parent) {
        if (parent[u] != u) {
            parent[u] = find(parent[u], parent);
        }
        return parent[u];
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public static void main(String[] args) {
        MinimumSpanningTree graph = new MinimumSpanningTree();
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        );

        graph.kruskal(4, edges);
    }
}
```
</details>
<details><summary><b>81. Implementing a trie data structure in Java</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("hell")); // false
        System.out.println(trie.startsWith("hell")); // true
    }
}
```

**Java 8:**
```java
import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("hell")); // false
        System.out.println(trie.startsWith("hell")); // true
    }
}
```
</details>

<details><summary><b>82. Finding the longest palindrome subsequence in a string in Java</b></summary>

**Java 7:**
```java
public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println("Length of LPS is " + longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
```

**Java 8:**
```java
public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println("Length of LPS is " + longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        IntStream.range(0, n).forEach(i -> dp[i][i] = 1);

        for (int cl = 2; cl <= n; cl++) {
            IntStream.range(0, n - cl + 1).forEach(i -> {
                int j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            });
        }

        return dp[0][n - 1];
    }
}
```
</details>

<details><summary><b>83. Implement a hash table</b></summary>

**Java 7:**
```java
import java.util.LinkedList;

public class HashTable {
    private static final int SIZE = 16;
    private LinkedList<Entry>[] table;

    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, String value) {
        int index = key.hashCode() % SIZE;
        LinkedList<Entry> bucket = table[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public String get(String key) {
        int index = key.hashCode() % SIZE;
        LinkedList<Entry> bucket = table[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put("name", "Alice");
        System.out.println(ht.get("name")); // Alice
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;

public class HashTable {
    private static final int SIZE = 16;
    private LinkedList<Entry>[] table;

    public HashTable() {
        table = new LinkedList[SIZE];
        IntStream.range(0, SIZE).forEach(i -> table[i] = new LinkedList<>());
    }

    private class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, String value) {
        int index = key.hashCode() % SIZE;
        LinkedList<Entry> bucket = table[index];
        Optional<Entry> existing = bucket.stream().filter(entry -> entry.key.equals(key)).findFirst();
        if (existing.isPresent()) {
            existing.get().value = value;
        } else {
            bucket.add(new Entry(key, value));
        }
    }

    public String get(String key) {
        int index = key.hashCode() % SIZE;
        LinkedList<Entry> bucket = table[index];
        return bucket.stream()
                     .filter(entry -> entry.key.equals(key))
                     .map(entry -> entry.value)
                     .findFirst()
                     .orElse(null);
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put("name", "Alice");
        System.out.println(ht.get("name")); // Alice
    }
}
```
</details>

<details><summary><b>84. Implement a stack using queues</b></summary>

**Java 7:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int top = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public int top() {
        while (queue1.size()

 > 1) {
            queue2.add(queue1.poll());
        }
        int top = queue1.peek();
        queue2.add(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.empty()); // false
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        IntStream.range(0, queue1.size() - 1).forEach(i -> queue2.add(queue1.poll()));
        int top = queue1.poll();
        swapQueues();
        return top;
    }

    public int top() {
        IntStream.range(0, queue1.size() - 1).forEach(i -> queue2.add(queue1.poll()));
        int top = queue1.peek();
        queue2.add(queue1.poll());
        swapQueues();
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.empty()); // false
    }
}
```
</details>

<details><summary><b>85. Find the maximum sum subarray using Kadane's algorithm</b></summary>

**Java 7:**
```java
public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum of subarray: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum of subarray: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        return Arrays.stream(nums)
                     .boxed()
                     .reduce(new int[]{nums[0], nums[0]}, (acc, num) -> {
                         int maxCurrent = Math.max(num, acc[0] + num);
                         return new int[]{maxCurrent, Math.max(maxCurrent, acc[1])};
                     })[1];
    }
}
```
</details>

<details><summary><b>86. Find the maximum subarray sum in an array</b></summary>

**Java 7:**
```java
public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubArraySum(nums));
    }

    public static int maxSubArraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubArraySum(nums));
    }

    public static int maxSubArraySum(int[] nums) {
        return Arrays.stream(nums)
                     .boxed()
                     .reduce(new int[]{nums[0], nums[0]}, (acc, num) -> {
                         int currentSum = Math.max(num, acc[0] + num);
                         return new int[]{currentSum, Math.max(currentSum, acc[1])};
                     })[1];
    }
}
```
</details>

<details><summary><b>87. Implement an AVL tree</b></summary>

**Java 7:**
```java
public class AVLTree {
    private class Node {
        int key;
        Node left, right;
        int height;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    private int height(Node N) {
        return N == null ? 0 : N.height;
    }

    private int getBalance(Node N) {
        return N == null ? 0 : height(N.left) - height(N.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
    }
}
```

**Java 8:**
```java
public class AVLTree {
    private class Node {
        int key;
        Node left, right;
        int height;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    private int height(Node N) {
        return N == null ? 0 : N.height;
    }

    private int getBalance(Node N) {
        return N == null ? 0 : height(N.left) - height(N.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (

node == null) return new Node(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
    }
}
```
</details>

<details><summary><b>88. Find the shortest path in a maze</b></summary>

**Java 7:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {
    private static final int ROW = 5;
    private static final int COL = 5;

    private static class Point {
        int x, y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static boolean isValid(int[][] maze, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && maze[row][col] == 1 && !visited[row][col];
    }

    public static int shortestPath(int[][] maze, Point src, Point dest) {
        if (maze[src.x][src.y] == 0 || maze[dest.x][dest.y] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[ROW][COL];
        visited[src.x][src.y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(src);

        int[] rowNum = {-1, 1, 0, 0};
        int[] colNum = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == dest.x && curr.y == dest.y) {
                return curr.distance;
            }

            for (int i = 0; i < 4; i++) {
                int row = curr.x + rowNum[i];
                int col = curr.y + colNum[i];

                if (isValid(maze, visited, row, col)) {
                    visited[row][col] = true;
                    queue.add(new Point(row, col, curr.distance + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 0, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1}
        };

        Point src = new Point(0, 0, 0);
        Point dest = new Point(4, 4, 0);
        System.out.println("Shortest Path Length: " + shortestPath(maze, src, dest));
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {
    private static final int ROW = 5;
    private static final int COL = 5;

    private static class Point {
        int x, y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static boolean isValid(int[][] maze, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && maze[row][col] == 1 && !visited[row][col];
    }

    public static int shortestPath(int[][] maze, Point src, Point dest) {
        if (maze[src.x][src.y] == 0 || maze[dest.x][dest.y] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[ROW][COL];
        visited[src.x][src.y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(src);

        int[] rowNum = {-1, 1, 0, 0};
        int[] colNum = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == dest.x && curr.y == dest.y) {
                return curr.distance;
            }

            IntStream.range(0, 4).forEach(i -> {
                int row = curr.x + rowNum[i];
                int col = curr.y + colNum[i];

                if (isValid(maze, visited, row, col)) {
                    visited[row][col] = true;
                    queue.add(new Point(row, col, curr.distance + 1));
                }
            });
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 0, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1}
        };

        Point src = new Point(0, 0, 0);
        Point dest = new Point(4, 4, 0);
        System.out.println("Shortest Path Length: " + shortestPath(maze, src, dest));
    }
}
```
</details>

<details><summary><b>89. Implement a disjoint-set data structure</b></summary>

**Java 7:**
```java
public class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);
        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        System.out.println(ds.find(0)); // 2
        System.out.println(ds.find(3)); // 4
    }
}
```

**Java 8:**
```java
public class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = IntStream.range(0, size).toArray();
        rank = new int[size];
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);
        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        System.out.println(ds.find(0)); // 2
        System.out.println(ds.find(3)); // 4
    }
}
```
</details>

<details><summary><b>90. Determine if a graph is bipartite</b></summary>

**Java 7:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !bfs(graph, i, color)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph();
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        System.out.println("Is bipartite: " + bg.isBipartite(graph));
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        return IntStream.range(0, n)
                        .allMatch(i -> color[i] != -1 || bfs(graph, i, color));
    }

    private boolean bfs(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph();
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        System.out.println("Is bipartite: " + bg.isBipartite(graph));
    }
}
```
</details>
<details><summary><b>91. Implement a priority queue</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class PriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    public void insert(int key) {
        if (size == capacity) {
            throw new IllegalStateException("Priority queue is full");
        }

        heap[size] = key;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return max;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(3);
        pq.insert(5);
        pq.insert(9);
        pq.insert(1);

        System.out.println("Extracted max: " + pq.extractMax());
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.PriorityQueue;

public class CustomPriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public CustomPriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    public void insert(int key) {
        if (size == capacity) {
            throw new IllegalStateException("Priority queue is full");
        }

        heap[size] = key;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return max;
    }

    public static void main(String[] args) {
        CustomPriorityQueue pq = new CustomPriorityQueue(10);
        pq.insert(3);
        pq.insert(5);
        pq.insert(9);
        pq.insert(1);

        System.out.println("Extracted max: " + pq.extractMax());
    }
}
```
</details>

<details><summary><b>92. Find the longest common substring in two strings</b></summary>

**Java 7:**
```java
public class LongestCommonSubstring {
    public static String longestCommonSubstring(String s1, String s2) {
        int maxLength = 0;
        int endIndex = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        return s1.substring(endIndex - maxLength, endIndex);
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "zabcf";
        System.out.println("Longest common substring: " + longestCommonSubstring(s1, s2));
    }
}
```

**Java 8:**
```java
public class LongestCommonSubstring {
    public static String longestCommonSubstring(String s1, String s2) {
        int maxLength = 0;
        int endIndex = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        return s1.substring(endIndex - maxLength, endIndex);
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "zabcf";
        System.out.println("Longest common substring: " + longestCommonSubstring(s1, s2));
    }
}
```
</details>

<details><summary><b>93. Find the maximum number of non-overlapping intervals</b></summary>

**Java 7:**
```java
import java.util.Arrays;
import java.util.Comparator;

public class MaxNonOverlappingIntervals {
    public static int maxNonOverlappingIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 1;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {6, 8}};
        System.out.println("Maximum number of non-overlapping intervals: " + maxNonOverlappingIntervals(intervals));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class MaxNonOverlappingIntervals {
    public static int maxNonOverlappingIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {6, 8}};
        System.out.println("Maximum number of non-overlapping intervals: " + maxNonOverlappingIntervals(intervals));
    }
}
```
</details>

<details><summary><b>94. Implement a segment tree</b></summary>

**Java 7:**
```java
public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[2 * n];
        buildTree(arr);
    }

    private void buildTree(int[] arr) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int value) {
        index += n;
        tree[index] = value;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[2 * index] + tree[2 * index + 1];
        }
    }

    public int query(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left++];
            }
            if (right % 2 == 0) {
                sum += tree[right--];
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println("Sum of range (1, 3): " + st.query(1, 3));
        st.update(1, 10);
        System.out.println("Sum of range (1, 3) after update: " + st.query(1, 3));
    }
}
```

**Java 8:**
```java
public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[2 * n];
        buildTree(arr);
    }

    private void buildTree(int[] arr) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int value) {
        index += n;
        tree[index] = value;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[2 * index] + tree[2 * index + 1];
        }
    }

    public int query(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left++];
            }
            if (right % 2 == 0) {
                sum += tree[right--];
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println("Sum of range (1, 3): " + st.query(1, 3));
        st.update(1, 10);
        System.out.println("Sum of range (1, 3) after update: " + st.query(1, 3));
    }
}
```
</details>

<details><summary><b>95. Find the maximum area of a histogram</b></summary>

**Java 7:**
```java
import java.util.Stack;

public class MaxHistogramArea {
    public static int maxHistogramArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                int topOfStack = stack.pop();
                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Maximum area of histogram: " + maxHistogramArea(heights));
    }
}
```

**Java 8:**
```java
import java.util.Stack;

public class MaxHistogramArea {
    public static int maxHistogramArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                int topOfStack = stack.pop();
                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Maximum area of histogram: " + maxHistogramArea(heights));
    }
}
```
</details>

<details><summary><b>96. Implement Floyd-Warshall algorithm</b></summary>

**Java 7:**
```java
public class FloydWarshall {
    public static void floydWarshall(int[][] graph) {
        int V = graph.length;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        printSolution(graph);
    }

    private static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, Integer.MAX_VALUE, 7},
            {8, 0, 2, Integer.MAX_VALUE},
            {5, Integer.MAX_VALUE, 0, 1},
            {2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        floydWarshall(graph);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class FloydWarshall {
    public static void floydWarshall(int[][] graph) {
        int V = graph.length;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        printSolution(graph);
    }

    private static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, Integer.MAX_VALUE, 7},
            {8, 0, 2, Integer.MAX_VALUE},
            {5, Integer.MAX_VALUE

, 0, 1},
            {2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        floydWarshall(graph);
    }
}
```
</details>

<details><summary><b>97. Find the longest word in a dictionary that can be formed from a set of letters</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;

public class LongestWordFromLetters {
    public static String findLongestWord(Set<String> dictionary, Set<Character> letters) {
        String longestWord = "";

        for (String word : dictionary) {
            if (canFormWord(word, letters) && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    private static boolean canFormWord(String word, Set<Character> letters) {
        Set<Character> letterSet = new HashSet<>(letters);
        for (char c : word.toCharArray()) {
            if (!letterSet.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("banana");
        dictionary.add("grape");
        dictionary.add("kiwi");

        Set<Character> letters = new HashSet<>();
        letters.add('a');
        letters.add('p');
        letters.add('l');
        letters.add('e');

        System.out.println("Longest word that can be formed: " + findLongestWord(dictionary, letters));
    }
}
```

**Java 8:**
```java
import java.util.Set;
import java.util.HashSet;

public class LongestWordFromLetters {
    public static String findLongestWord(Set<String> dictionary, Set<Character> letters) {
        return dictionary.stream()
            .filter(word -> canFormWord(word, letters))
            .max((word1, word2) -> Integer.compare(word1.length(), word2.length()))
            .orElse("");
    }

    private static boolean canFormWord(String word, Set<Character> letters) {
        Set<Character> letterSet = new HashSet<>(letters);
        return word.chars().allMatch(c -> letterSet.contains((char) c));
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("banana");
        dictionary.add("grape");
        dictionary.add("kiwi");

        Set<Character> letters = new HashSet<>();
        letters.add('a');
        letters.add('p');
        letters.add('l');
        letters.add('e');

        System.out.println("Longest word that can be formed: " + findLongestWord(dictionary, letters));
    }
}
```
</details>

<details><summary><b>98. Check if a binary tree is balanced</b></summary>

**Java 7:**
```java
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Is the tree balanced? " + isBalanced(root));
    }
}
```

**Java 8:**
```java
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Is the tree balanced? " + isBalanced(root));
    }
}
```
</details>

<details><summary><b>99. Implement a hashmap from scratch</b></summary>

**Java 7:**
```java
import java.util.LinkedList;

class HashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    public HashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'two': " + map.get("two"));
    }
}
```

**Java 8:**
```java
import java.util.LinkedList;

public class HashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    public HashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        bucket.stream()
              .filter(entry -> entry.key.equals(key))
              .findFirst()
              .ifPresentOrElse(
                  entry -> entry.value = value,
                  () -> bucket.add(new Entry<>(key, value))
              );
    }

    public V get(K key) {
        int index = hash(key);
        return table[index].stream()
                          .filter(entry -> entry.key.equals(key))
                          .map(entry -> entry.value)
                          .findFirst()
                          .orElse(null);
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'two': " + map.get("two"));
    }
}
```
</details>

<details><summary><b>100. Find the maximum flow in a graph using Ford-Fulkerson algorithm</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class FordFulkerson {
    private static final int V = 6;

    private boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];
        Arrays.fill(parent, -1);
        visited[s] = true;

        int[] queue = new int[V];
        int front = 0, rear = 0;
        queue[rear++] = s;

        while (front < rear) {
            int u = queue[front++];
            for (int v = 0; v < V; v++) {
                if (!

visited[v] && rGraph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue[rear++] = v;
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false;
    }

    public int fordFulkerson(int[][] graph, int s, int t) {
        int[][] rGraph = new int[V][V];
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[V];
        int maxFlow = 0;

        while (bfs(rGraph, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 9, 14, 0},
            {0, 0, 9, 0, 7, 0},
            {0, 0, 14, 7, 0, 4},
            {0, 0, 0, 0, 4, 0}
        };

        FordFulkerson ff = new FordFulkerson();
        System.out.println("Maximum flow: " + ff.fordFulkerson(graph, 0, 5));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    private static final int V = 6;

    private boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];
        Arrays.fill(parent, -1);
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    if (v == t) {
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

    public int fordFulkerson(int[][] graph, int s, int t) {
        int[][] rGraph = Arrays.copyOf(graph, graph.length);
        int[] parent = new int[V];
        int maxFlow = 0;

        while (bfs(rGraph, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 9, 14, 0},
            {0, 0, 9, 0, 7, 0},
            {0, 0, 14, 7, 0, 4},
            {0, 0, 0, 0, 4, 0}
        };

        FordFulkerson ff = new FordFulkerson();
        System.out.println("Maximum flow: " + ff.fordFulkerson(graph, 0, 5));
    }
}
```
</details>
<details><summary><b>101. Find the largest element in an array</b></summary>

**Java 7:**
```java
public class LargestElement {
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Largest element: " + findLargest(arr));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class LargestElement {
    public static int findLargest(int[] arr) {
        return Arrays.stream(arr).max().orElseThrow(NoSuchElementException::new);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Largest element: " + findLargest(arr));
    }
}
```
</details>

<details><summary><b>102. Find the smallest element in an array</b></summary>

**Java 7:**
```java
public class SmallestElement {
    public static int findSmallest(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Smallest element: " + findSmallest(arr));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SmallestElement {
    public static int findSmallest(int[] arr) {
        return Arrays.stream(arr).min().orElseThrow(NoSuchElementException::new);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Smallest element: " + findSmallest(arr));
    }
}
```
</details>

<details><summary><b>103. Find the second smallest element in an array</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class SecondSmallestElement {
    public static int findSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Second smallest element: " + findSecondSmallest(arr));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SecondSmallestElement {
    public static int findSecondSmallest(int[] arr) {
        return Arrays.stream(arr).distinct().sorted().skip(1).findFirst().orElseThrow(NoSuchElementException::new);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Second smallest element: " + findSecondSmallest(arr));
    }
}
```
</details>

<details><summary><b>104. Check if an array is sorted in ascending order</b></summary>

**Java 7:**
```java
public class ArraySortedAscending {
    public static boolean isSortedAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array is sorted ascending: " + isSortedAscending(arr));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class ArraySortedAscending {
    public static boolean isSortedAscending(int[] arr) {
        return IntStream.range(1, arr.length)
                        .allMatch(i -> arr[i - 1] <= arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array is sorted ascending: " + isSortedAscending(arr));
    }
}
```
</details>

<details><summary><b>105. Check if an array is sorted in descending order</b></summary>

**Java 7:**
```java
public class ArraySortedDescending {
    public static boolean isSortedDescending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("Array is sorted descending: " + isSortedDescending(arr));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class ArraySortedDescending {
    public static boolean isSortedDescending(int[] arr) {
        return IntStream.range(1, arr.length)
                        .allMatch(i -> arr[i - 1] >= arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("Array is sorted descending: " + isSortedDescending(arr));
    }
}
```
</details>

<details><summary><b>106. Separate odd and even numbers in a list of integers</b></summary>

**Java 7:**
```java
import java.util.ArrayList;
import java.util.List;

public class SeparateOddEven {
    public static void separateOddEven(List<Integer> numbers) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }
        System.out.println("Odds: " + odds);
        System.out.println("Evens: " + evens);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        separateOddEven(numbers);
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class SeparateOddEven {
    public static void separateOddEven(List<Integer> numbers) {
        List<Integer> odds = numbers.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        List<Integer> evens = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

        System.out.println("Odds: " + odds);
        System.out.println("Evens: " + evens);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        separateOddEven(numbers);
    }
}
```
</details>

<details><summary><b>107. Remove duplicate elements from a list using Java 8 streams</b></summary>

**Java 7:**
```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3, 4, 4, 5);
        System.out.println("List without duplicates: " + removeDuplicates(list));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3, 4, 4, 5);
        System.out.println("List without duplicates: " + removeDuplicates(list));
    }
}
```
</details>

<details><summary><b>108. Find frequency of each character in a string using

 Java 8 streams</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {
    public static Map<Character, Integer> getCharacterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String str = "characterfrequency";
        System.out.println("Character frequencies: " + getCharacterFrequency(str));
    }
}
```

**Java 8:**
```java
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static Map<Character, Long> getCharacterFrequency(String str) {
        return str.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        String str = "characterfrequency";
        System.out.println("Character frequencies: " + getCharacterFrequency(str));
    }
}
```
</details>

<details><summary><b>109. Find frequency of each element in an array or a list</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
    public static Map<Integer, Integer> getFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        System.out.println("Element frequencies: " + getFrequency(arr));
    }
}
```

**Java 8:**
```java
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyOfElements {
    public static Map<Integer, Long> getFrequency(int[] arr) {
        return IntStream.of(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        System.out.println("Element frequencies: " + getFrequency(arr));
    }
}
```
</details>

<details><summary><b>110. Sort a given list of decimals in reverse order</b></summary>

**Java 7:**
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDecimals {
    public static void sortInReverse(List<Double> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(1.1, 3.3, 2.2, 4.4));
        sortInReverse(list);
        System.out.println("Sorted list in reverse order: " + list);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDecimals {
    public static void sortInReverse(List<Double> list) {
        list.sort(Collections.reverseOrder());
    }

    public static void main(String[] args) {
        List<Double> list = Arrays.asList(1.1, 3.3, 2.2, 4.4);
        sortInReverse(list);
        System.out.println("Sorted list in reverse order: " + list);
    }
}
```
</details>

<details><summary><b>111. Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter</b></summary>

**Java 7:**
```java
import java.util.List;

public class JoinStrings {
    public static String joinWithBrackets(List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry");
        System.out.println("Joined string: " + joinWithBrackets(list));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.StringJoiner;

public class JoinStrings {
    public static String joinWithBrackets(List<String> list) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        list.forEach(sj::add);
        return sj.toString();
    }

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry");
        System.out.println("Joined string: " + joinWithBrackets(list));
    }
}
```
</details>

<details><summary><b>112. Print the numbers from a given list of integers that are multiples of a given number</b></summary>

**Java 7:**
```java
import java.util.List;

public class PrintMultiples {
    public static void printMultiples(List<Integer> list, int divisor) {
        for (int num : list) {
            if (num % divisor == 0) {
                System.out.println(num);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        int divisor = 2;
        System.out.println("Multiples of " + divisor + ":");
        printMultiples(list, divisor);
    }
}
```

**Java 8:**
```java
import java.util.List;

public class PrintMultiples {
    public static void printMultiples(List<Integer> list, int divisor) {
        list.stream()
            .filter(num -> num % divisor == 0)
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        int divisor = 2;
        System.out.println("Multiples of " + divisor + ":");
        printMultiples(list, divisor);
    }
}
```
</details>

<details><summary><b>113. Find maximum and minimum of a list of integers</b></summary>

**Java 7:**
```java
import java.util.Collections;
import java.util.List;

public class MaxMinFinder {
    public static void findMaxMin(List<Integer> list) {
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 2, 8, 1, 3);
        findMaxMin(list);
    }
}
```

**Java 8:**
```java
import java.util.List;

public class MaxMinFinder {
    public static void findMaxMin(List<Integer> list) {
        int max = list.stream().mapToInt(Integer::intValue).max().orElseThrow(NoSuchElementException::new);
        int min = list.stream().mapToInt(Integer::intValue).min().orElseThrow(NoSuchElementException::new);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 2, 8, 1, 3);
        findMaxMin(list);
    }
}
```
</details>

<details><summary><b>114. Merge two unsorted arrays into a single sorted array using Java 8 streams</b></summary>

**Java 7:**
```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MergeAndSortArrays {
    public static int[] mergeAndSort(int[] arr1, int[] arr2) {
        Set<Integer> set = new TreeSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9};
        int[] arr2 = {1, 6, 8};
        System.out.println("Merged and sorted array: " + Arrays.toString(mergeAndSort(arr1, arr2)));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeAndSortArrays {
    public static int[] mergeAndSort(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                        .distinct

()
                        .sorted()
                        .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9};
        int[] arr2 = {1, 6, 8};
        System.out.println("Merged and sorted array: " + Arrays.toString(mergeAndSort(arr1, arr2)));
    }
}
```
</details>

<details><summary><b>115. Get three maximum numbers and three minimum numbers from a given list of integers</b></summary>

**Java 7:**
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeMaxMin {
    public static void getThreeMaxMin(List<Integer> list) {
        Collections.sort(list);
        List<Integer> min = list.subList(0, 3);
        List<Integer> max = list.subList(list.size() - 3, list.size());
        System.out.println("Three minimum numbers: " + min);
        System.out.println("Three maximum numbers: " + max);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 1, 7, 3, 8, 6, 2, 9);
        getThreeMaxMin(list);
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeMaxMin {
    public static void getThreeMaxMin(List<Integer> list) {
        List<Integer> sortedList = list.stream()
                                       .sorted()
                                       .collect(Collectors.toList());
        List<Integer> min = sortedList.stream().limit(3).collect(Collectors.toList());
        List<Integer> max = sortedList.stream().skip(sortedList.size() - 3).collect(Collectors.toList());
        System.out.println("Three minimum numbers: " + min);
        System.out.println("Three maximum numbers: " + max);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 1, 7, 3, 8, 6, 2, 9);
        getThreeMaxMin(list);
    }
}
```
</details>

<details><summary><b>116. Check if two strings are anagrams or not using Java 8 streams</b></summary>

**Java 7:**
```java
import java.util.Arrays;

public class AnagramCheck {
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Are anagrams: " + areAnagrams(str1, str2));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class AnagramCheck {
    public static boolean areAnagrams(String str1, String str2) {
        return Arrays.equals(
            str1.chars().sorted().toArray(),
            str2.chars().sorted().toArray()
        );
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Are anagrams: " + areAnagrams(str1, str2));
    }
}
```
</details>

<details><summary><b>117. Find sum of all digits of a number in Java 8</b></summary>

**Java 7:**
```java
public class SumOfDigits {
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int number = 1234;
        System.out.println("Sum of digits: " + sumOfDigits(number));
    }
}
```

**Java 8:**
```java
public class SumOfDigits {
    public static int sumOfDigits(int number) {
        return Integer.toString(number).chars()
                                     .map(Character::getNumericValue)
                                     .sum();
    }

    public static void main(String[] args) {
        int number = 1234;
        System.out.println("Sum of digits: " + sumOfDigits(number));
    }
}
```
</details>

<details><summary><b>118. Find second largest number in an integer array</b></summary>

**Java 7:**
```java
public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Second largest number: " + findSecondLargest(arr));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
        return Arrays.stream(arr)
                     .distinct()
                     .sorted()
                     .skip(arr.length - 2)
                     .findFirst()
                     .orElseThrow(NoSuchElementException::new);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 8, 6};
        System.out.println("Second largest number: " + findSecondLargest(arr));
    }
}
```
</details>

<details><summary><b>119. Sort a list of strings according to the increasing order of their length</b></summary>

**Java 7:**
```java
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByLength {
    public static void sortByLength(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry", "date");
        sortByLength(list);
        System.out.println("Sorted by length: " + list);
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class SortByLength {
    public static void sortByLength(List<String> list) {
        List<String> sortedList = list.stream()
                                      .sorted(Comparator.comparingInt(String::length))
                                      .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedList);
    }

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry", "date");
        sortByLength(list);
    }
}
```
</details>

<details><summary><b>120. Find the sum and average of all elements in an integer array</b></summary>

**Java 7:**
```java
public class SumAndAverage {
    public static void calculateSumAndAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        calculateSumAndAverage(arr);
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class SumAndAverage {
    public static void calculateSumAndAverage(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        double average = Arrays.stream(arr).average().orElse(0.0);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        calculateSumAndAverage(arr);
    }
}
```
</details>

<details><summary><b>121. Find common elements between two arrays</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static Set<Integer> findCommon(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }
        for (int num : arr2) {
            if (set1.contains(num)) {
                common.add(num);
            }
        }
        return common;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4,

 5, 6, 7, 8};
        System.out.println("Common elements: " + findCommon(arr1, arr2));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElements {
    public static Set<Integer> findCommon(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        return Arrays.stream(arr2)
                     .boxed()
                     .filter(set1::contains)
                     .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};
        System.out.println("Common elements: " + findCommon(arr1, arr2));
    }
}
```
</details>

<details><summary><b>122. Remove duplicate elements from a list of integers</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3, 4, 4, 5);
        System.out.println("List after removing duplicates: " + removeDuplicates(list));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3, 4, 4, 5);
        System.out.println("List after removing duplicates: " + removeDuplicates(list));
    }
}
```
</details>

<details><summary><b>123. Convert a list of integers to a comma-separated string</b></summary>

**Java 7:**
```java
import java.util.List;

public class ListToString {
    public static String convertToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println("Comma-separated string: " + convertToString(list));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class ListToString {
    public static String convertToString(List<Integer> list) {
        return list.stream()
                   .map(String::valueOf)
                   .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println("Comma-separated string: " + convertToString(list));
    }
}
```
</details>

<details><summary><b>124. Find the largest and smallest number in a list of integers</b></summary>

**Java 7:**
```java
import java.util.Collections;
import java.util.List;

public class MaxMinFinder {
    public static void findMaxMin(List<Integer> list) {
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 2, 8, 1, 3);
        findMaxMin(list);
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class MaxMinFinder {
    public static void findMaxMin(List<Integer> list) {
        int max = list.stream().mapToInt(Integer::intValue).max().orElseThrow(NoSuchElementException::new);
        int min = list.stream().mapToInt(Integer::intValue).min().orElseThrow(NoSuchElementException::new);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 2, 8, 1, 3);
        findMaxMin(list);
    }
}
```
</details>

<details><summary><b>125. Check if a given list of integers contains only even numbers</b></summary>

**Java 7:**
```java
import java.util.List;

public class CheckEvenNumbers {
    public static boolean containsOnlyEven(List<Integer> list) {
        for (int num : list) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 6, 8);
        System.out.println("Contains only even numbers: " + containsOnlyEven(list));
    }
}
```

**Java 8:**
```java
import java.util.List;

public class CheckEvenNumbers {
    public static boolean containsOnlyEven(List<Integer> list) {
        return list.stream().allMatch(num -> num % 2 == 0);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 6, 8);
        System.out.println("Contains only even numbers: " + containsOnlyEven(list));
    }
}
```
</details>

<details><summary><b>126. Print elements of a list in reverse order</b></summary>

**Java 7:**
```java
import java.util.Collections;
import java.util.List;

public class PrintReverse {
    public static void printInReverse(List<Integer> list) {
        Collections.reverse(list);
        for (int num : list) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        printInReverse(list);
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintReverse {
    public static void printInReverse(List<Integer> list) {
        list.stream()
            .collect(Collectors.toCollection(LinkedList::new))
            .descendingIterator()
            .forEachRemaining(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        printInReverse(list);
    }
}
```
</details>

<details><summary><b>127. Remove all occurrences of a specific element from a list</b></summary>

**Java 7:**
```java
import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
    public static void removeElement(List<Integer> list, int element) {
        list.removeIf(num -> num == element);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 2, 5));
        removeElement(list, 2);
        System.out.println("List after removal: " + list);
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class RemoveElement {
    public static List<Integer> removeElement(List<Integer> list, int element) {
        return list.stream()
                   .filter(num -> num != element)
                   .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 2, 5);
        List<Integer> updatedList = removeElement(list, 2);
        System.out.println("List after removal: " + updatedList);
    }
}
```
</details>

<details><summary><b>128. Find the intersection of two lists</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListIntersection {
    public static Set<Integer> findIntersection(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> intersection = new HashSet<>();
        for (int num : list2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(4, 5, 6, 7

, 8);
        System.out.println("Intersection: " + findIntersection(list1, list2));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListIntersection {
    public static Set<Integer> findIntersection(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = list1.stream().collect(Collectors.toSet());
        return list2.stream().filter(set1::contains).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(4, 5, 6, 7, 8);
        System.out.println("Intersection: " + findIntersection(list1, list2));
    }
}
```
</details>

<details><summary><b>129. Find the union of two lists</b></summary>

**Java 7:**
```java
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUnion {
    public static Set<Integer> findUnion(List<Integer> list1, List<Integer> list2) {
        Set<Integer> union = new HashSet<>(list1);
        union.addAll(list2);
        return union;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(4, 5, 6, 7, 8);
        System.out.println("Union: " + findUnion(list1, list2));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListUnion {
    public static Set<Integer> findUnion(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                    .collect(Collectors.toSet())
                    .addAll(list2.stream().collect(Collectors.toSet()));
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(4, 5, 6, 7, 8);
        System.out.println("Union: " + findUnion(list1, list2));
    }
}
```
</details>

<details><summary><b>130. Find the frequency of each element in a list</b></summary>

**Java 7:**
```java
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementFrequency {
    public static Map<Integer, Integer> findFrequency(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3, 3, 3);
        System.out.println("Element frequencies: " + findFrequency(list));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ElementFrequency {
    public static Map<Integer, Long> findFrequency(List<Integer> list) {
        return list.stream()
                   .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3, 3, 3);
        System.out.println("Element frequencies: " + findFrequency(list));
    }
}
```
</details>
<details><summary><b>131. Find first non-repeated character in a string</b></summary>

**Java 7:**
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static char findFirstNonRepeated(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No non-repeated character found");
    }

    public static void main(String[] args) {
        String str = "swiss";
        System.out.println("First non-repeated character: " + findFirstNonRepeated(str));
    }
}
```

**Java 8:**
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static char findFirstNonRepeated(String str) {
        return str.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum, LinkedHashMap::new))
                  .entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() == 1)
                  .map(Map.Entry::getKey)
                  .findFirst()
                  .orElseThrow(() -> new RuntimeException("No non-repeated character found"));
    }

    public static void main(String[] args) {
        String str = "swiss";
        System.out.println("First non-repeated character: " + findFirstNonRepeated(str));
    }
}
```
</details>

<details><summary><b>132. Generate the Fibonacci series</b></summary>

**Java 7:**
```java
import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {
    public static List<Integer> generateFibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fibonacci.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci series: " + generateFibonacci(n));
    }
}
```

**Java 8:**
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSeries {
    public static List<Integer> generateFibonacci(int n) {
        return Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                     .limit(n)
                     .map(f -> f[0])
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci series: " + generateFibonacci(n));
    }
}
```
</details>

<details><summary><b>133. Print the first odd numbers</b></summary>

**Java 7:**
```java
public class FirstOddNumbers {
    public static void printFirstOddNumbers(int n) {
        int count = 0;
        int num = 1;
        while (count < n) {
            System.out.println(num);
            num += 2;
            count++;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("First " + n + " odd numbers:");
        printFirstOddNumbers(n);
    }
}
```

**Java 8:**
```java
import java.util.stream.IntStream;

public class FirstOddNumbers {
    public static void printFirstOddNumbers(int n) {
        IntStream.iterate(1, i -> i + 2)
                 .limit(n)
                 .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("First " + n + " odd numbers:");
        printFirstOddNumbers(n);
    }
}
```
</details>

<details><summary><b>134. Get the last element of an array</b></summary>

**Java 7:**
```java
public class LastElement {
    public static <T> T getLastElement(T[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Array is empty");
        }
        return array[array.length - 1];
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println("Last element: " + getLastElement(array));
    }
}
```

**Java 8:**
```java
import java.util.Arrays;

public class LastElement {
    public static <T> T getLastElement(T[] array) {
        return Arrays.stream(array)
                     .reduce((first, second) -> second)
                     .orElseThrow(() -> new RuntimeException("Array is empty"));
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println("Last element: " + getLastElement(array));
    }
}
```
</details>

<details><summary><b>135. Calculate the age of a person in years given their birthday</b></summary>

**Java 7:**
```java
import java.util.Calendar;
import java.util.Date;

public class CalculateAge {
    public static int calculateAge(Date birthDate) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
            (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.SEPTEMBER, 15);
        Date birthDate = cal.getTime();
        System.out.println("Age: " + calculateAge(birthDate));
    }
}
```

**Java 8:**
```java
import java.time.LocalDate;
import java.time.Period;

public class CalculateAge {
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1990, 9, 15);
        System.out.println("Age: " + calculateAge(birthDate));
    }
}
```
</details>
