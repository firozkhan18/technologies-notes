# Java 8 Interview Sample Coding Questions [Solution Improvement in progress]

This repository contains sample Java 8 coding questions that can be used for interview preparation. Each question focuses on a specific programming concept or problem-solving technique using Java 8 features.

## List of Questions

1. **Separate odd and even numbers in a list of integers**

    Given a list of integers, write a Java 8 program to separate the odd and even numbers into two separate lists.

2. **Remove duplicate elements from a list using Java 8 streams**

    Write a Java 8 program to remove duplicate elements from a list using the stream API and lambda expressions.

3. **Find the frequency of each character in a string using Java 8 streams**

    Write a Java 8 program to find the frequency of each character in a given string using the stream API and collectors.

4. **Find the frequency of each element in an array or a list**

    Write a Java 8 program to find the frequency of each element in an array or a list using streams and collectors.

5. **Sort a given list of decimals in reverse order**

    Write a Java 8 program to sort a given list of decimal numbers in reverse order.

6. **Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter**

    Given a list of strings, write a Java 8 program to join the strings with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.

7. **Print the numbers from a given list of integers that are multiples of 5**

    Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.

8. **Find the maximum and minimum of a list of integers**

    Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.

9. **Merge two unsorted arrays into a single sorted array using Java 8 streams**

    Write a Java 8 program to merge two unsorted arrays into a single sorted array using the stream API.

10. **Merge two unsorted arrays into a single sorted array without duplicates**

    Write a Java 8 program to merge two unsorted arrays into a single sorted array without duplicates.
11. **Get the three maximum and three minimum numbers from a given list of integers**

    Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers.

12. **Check if two strings are anagrams or not using Java 8 streams**

    Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.

13. **Find the sum of all digits of a number in Java 8**

    Write a Java 8 program to find the sum of all digits of a given number.

14. **Find the second largest number in an integer array**

    Write a Java 8 program to find the second largest number in an integer array.

15. **Sort a list of strings according to the increasing order of their length**

    Write a Java 8 program to sort a given list of strings according to the increasing order of their length.

16. **Find the sum and average of all elements in an integer array**

    Write a Java 8 program to find the sum and average of all elements in an integer array.

17. **Find the common elements between two arrays**

    Write a Java 8 program to find the common elements between two arrays using streams.

18. **Reverse each word of a string using Java 8 streams**

    Write a Java 8 program to reverse each word of a given string using the stream API and lambda expressions.

19. **Find the sum of the first 10 natural numbers**

    Write a Java 8 program to find the sum of the first 10 natural numbers using streams.

20. **Reverse an integer array**

    Write a Java 8 program to reverse an integer array.

21. **Print the first 10 even numbers**

    Write a Java 8 program to print the first 10 even numbers.

22. **Find the most repeated element in an array**

    Write a Java 8 program to find the most repeated element in an array.

23. **Check if a string is a palindrome using Java 8 streams**

    Write a Java 8 program to check if a given string is a palindrome using the stream API and lambda expressions.

24. **Find strings in a list that start with a number**

    Given a list of strings, write a Java 8 program to find the strings that start with a number.

25. **Extract duplicate elements from an array**

    Write a Java 8 program to extract duplicate elements from an array.

26. **Print duplicate characters in a string**

    Write a Java 8 program to print the duplicate characters in a string.

27. **Find the first repeated character in a string**

    Write a Java 8 program to find the first repeated character in a string.

28. **Find the first non-repeated character in a string**

    Write a Java 8 program to find the first non-repeated character in a string.

29. **Generate the Fibonacci series**

    Write a Java 8 program to generate the Fibonacci series.

30. **Print the first 10 odd numbers**

    Write a Java 8 program to print the first 10 odd numbers.

31. **Get the last element of an array**

    Write a Java 8 program to get the last element of an array.

32. **Calculate the age of a person in years**

    Write a Java 8 program to calculate the age of a person in years given their birthday.

```java
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.List.of;
import static java.util.stream.Collectors.*;

public class Sample {
    public static void main(String[] args) {

        /**
         * Separate odd and even numbers in a list of integers.
         *
         * Given a list of integers, write a Java 8 program to separate
         * the odd and even numbers into two separate lists.
         */

        separationOfEvenOddNumberInMap();
        separationOfEvenOddNumberInList();

        /**
         * Remove duplicate elements from a list using Java 8 streams
         *
         * Write a Java 8 program to remove duplicate elements from a list
         * using the stream API and lambda expressions.
         */

        removeDuplicateFromList();


        /**
         * Find the frequency of each character in a string using Java 8 streams
         *
         * Write a Java 8 program to find the frequency of each character in
         * a given string using the stream API and collectors.
         */
        characterFrequency();

        /**
         * Find the frequency of each element in an array or a list
         *
         * Write a Java 8 program to find the frequency of
         * each element in an array or a list using streams and collectors.
         */

        wordFrequency();

        /**
         * Sort a given list of decimals in reverse order
         *
         * Write a Java 8 program to sort a given list of decimal numbers in reverse order.
         */

        reverseSortedList();

        /**
         * Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
         *
         * Given a list of strings, write a Java 8 program to join the strings
         * with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.
         */

        joinListOfStrings();

        /**
         * Print the numbers from a given list of integers that are multiples of 5
         *
         * Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.
         */

        multipleOf5();

        /**
         * Find the maximum and minimum of a list of integers
         * Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.
         */

        minMaxFromList();

        /**
         * Merge two unsorted arrays into a single sorted array using Java 8 streams
         * Write a Java 8 program to merge two unsorted arrays into a single-sorted array using the stream API.
         */
        mergeUnsortedArrayIntoSorted();

        /**
         * Merge two unsorted arrays into a single sorted array without duplicates
         * Write a Java 8 program to merge two unsorted arrays into a single-sorted array without duplicates.
         */
        mergeUnsortedArrayIntoSortedWithoutDuplicate();

        /**
         * Get the three maximum and three minimum numbers from a given list of integers
         *
         * Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers.
         */

        min3max3();

        /**
         * Check if two strings are anagrams or not using Java 8 streams
         * Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.
         */

        isAnagram();
        isAnagram2();

        /**
         * Find the sum of all digits of a number in Java 8
         *
         * Write a Java 8 program to find the sum of all digits of a given number.
         *
         */
        sumOf();
        /**
         * Find the second-largest number in an integer array
         *
         * Write a Java 8 program to find the second-largest number in an integer array.
         */
        secondLargestNumberFromList();


        /**
         * Sort a list of strings according to the increasing order of their length
         *
         * Write a Java 8 program to sort a given list of strings according to the increasing order of their length.
         */
        sortByLengthOfList();
        /**
         * Find the sum and average of all elements in an integer array
         *
         * Write a Java 8 program to find the sum and average of all elements in an integer array.
         */

        calculateAndSumAndAverage();
        /**
         * Find the common elements between two arrays
         *
         * Write a Java 8 program to find the common elements between two arrays using streams.
         */
        commonElements();
        /**
         * Reverse each word of a string using Java 8 streams
         *
         * Write a Java 8 program to reverse each word of a given string using the stream API and lambda expressions
         */
        reverseEachWord();

        /**
         * Find the sum of the first 10 natural numbers
         *
         * Write a Java 8 program to find the sum of the first 10 natural numbers using streams.
         */

        int sumOf10NaturalNumber = IntStream.rangeClosed(1, 10)
                .sum();
        System.out.println(sumOf10NaturalNumber);

        /**
         * Reverse an integer array
         *
         * Write a Java 8 program to reverse an integer array.
         */
        reversedArray();

        /**
         * Find the most repeated element in an array
         *
         * Write a Java 8 program to find the most repeated element in an array.
         */

        mostRepeatedElement();

        /**
         * Check if a string is a palindrome using Java 8 streams
         *
         * Write a Java 8 program to check if a given string is a palindrome using the stream API and lambda expressions.
         */

        checkIsTheStringPalindrome();

        /**
         * Find strings in a list that start with a number
         *
         * Given a list of strings, write a Java 8 program to find the strings that start with a number.
         */

        stringsStartsWithNumber();

        /**
         * Extract duplicate elements from an array
         *
         * Write a Java 8 program to extract duplicate elements from an array.
         */

        extractDuplicateElements();

        /**
         * Print duplicate characters in a string
         * Write a Java 8 program to print the duplicate characters in a string.
         */

        duplicateCharactersInString();

        /**
         * Find the first repeated character in a string
         * Write a Java 8 program to find the first repeated character in a string.
         */
        firstRepeatedCharacter();

        /**
         * Find the first non-repeated character in a string
         *
         * Write a Java 8 program to find the first non-repeated character in a string.
         */
        firstNonRepeatingCharacter();

        /**
         * Generate the Fibonacci series
         *
         * Write a Java 8 program to generate the Fibonacci series.
         */
        generateFibonacciSeries();

        /**
         * Print the first 10 odd numbers
         *
         * Write a Java 8 program to print the first 10 odd numbers.
         */
        firstTenOddNumbers();

        /**
         * Get the last element of an array
         *
         * Write a Java 8 program to get the last element of an array.
         */

        lastElementInTheArray();

        /**
         * Calculate the age of a person in years
         *
         * Write a Java 8 program to calculate the age of a person in years given their birthday.
         */
        calculatePersonAgeInYear();

        /**
         * Find the missing number from an array
         *
         * Write a Java 7 program to find find the missing number from an array.
         */
               
        //### Method 1: Sum Formula

        //This method calculates the expected sum of numbers from `1` to `n` and subtracts the sum of the array elements to find the missing number.

        findMissingNumber();        
       
        //### Method 2: XOR Approach

        //This method uses XOR operations to find the missing number. The idea is to XOR all numbers from `1` to `n` and XOR all elements in the array. The result is the missing number.

        findMissingNumberXor();        

        //### Method 3: Set-Based Approach

        //This method uses a `HashSet` to find the missing number by tracking the numbers.

        findMissingNumberSet();
        
        /**
         * Find the missing number from an array
         *
         * Write a Java 8 program to find find the missing number from an array.
         */
        findMissingNumberFromArrayUsingIntStream();    
               
        findMissingNumberStream();
        findMissingNumberXorStream();
        findMissingNumberSetStream();
	
    }

    private static void calculatePersonAgeInYear() {
        LocalDate birthDate = LocalDate.of(1998, 8, 17);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        System.out.println("Age of the person is: " + age);
    }

    private static void lastElementInTheArray() {
        int[] intArray = {0,1,2,3,4,5};
        Integer lastElementInTheArray = Arrays.stream(intArray)
                .boxed()
                .reduce((first, second) -> second).orElse(-1);
        System.out.println("\nlast elements in the array " + lastElementInTheArray);
    }

    private static void firstTenOddNumbers() {
        Stream.iterate(1,i->i+2)
                .limit(10)
                .forEach(System.out::print);
    }

    private static void generateFibonacciSeries() {

        Stream.iterate(new int[]{0,1},t->new int[]{ t[1], t[0]+ t[1] })
                .limit(10)
                .map(t->t[0])
                .forEach(System.out::print);

        Function<int[], List<Integer>> intArraytoListOFInt = array -> Arrays.stream(array).boxed()
                .collect(toList());
        List<Integer> collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(intArraytoListOFInt)
                .flatMap(List::stream)
                .distinct()
                .collect(toList());
        System.out.println(collect);
    }

    private static void firstNonRepeatingCharacter() {
        String tempStr = "rohitrohi";
        System.out.println (Arrays.stream (tempStr.split (""))
                .filter (str -> tempStr.indexOf (str) == tempStr.lastIndexOf (str))
                .findFirst ()
                .orElse (""));

    }

    private static void checkIsTheStringPalindrome() {
        String str = "momd";
        String temp = str.replaceAll("\\s+", "").toLowerCase();
        System.out.println("is palindrome string " +IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1)));
    }

    private static void firstRepeatedCharacter() {
        String word = "rohttoh";
        System.out.println (Arrays.stream (word.split (""))
                .filter (str -> word.indexOf (str) != word.lastIndexOf (str))
                .findFirst ().orElse (""));
    }

    private static void duplicateCharactersInString() {
        String word = "rohttoh";
        System.out.println ("original String " + word);


        System.out.println (Arrays.stream (word.split (""))
        .filter (str -> word.indexOf (str) != word.lastIndexOf (str))
        .map (str -> str.charAt (0))
        .collect (toList ()));
    }

    private static void extractDuplicateElements() {
        List<Integer> duplicateElements = of(1, 2,2,2,3, 3, 4, 5,1,1,56, 7, 8, 9, 10);

        System.out.println("maxed Elements " + duplicateElements);

        List<Integer> extractDuplicateElements = duplicateElements.stream()
                .filter(element -> duplicateElements.indexOf(element)
                        != duplicateElements.lastIndexOf(element))
                .distinct()
                .collect(toList());


        System.out.println("extract duplicates elements from " + extractDuplicateElements);
    }

    private static void stringsStartsWithNumber() {
        String [] words= {"rohit","foo","nemo","target1","12Target","2robot"};

        System.out.println("original Strings " + Arrays.toString(words));

        List<String> stringStartNumber = Arrays.stream(words)
                 .filter(word -> Character.isDigit(word.charAt(0)))
                 .toList();
        System.out.println("strings started with a number " + stringStartNumber);
    }

    private static void mostRepeatedElement() {
        int [] elements = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};

        System.out.println("original Array" + Arrays.toString(elements));
        Function<Map<Integer, Long>, Integer> maxValuesKey = integerLongMap ->
                integerLongMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Integer.MAX_VALUE);

        Integer maxDuplicateValue = Arrays.stream(elements)
                .boxed()
                .collect(collectingAndThen(groupingBy(Function.identity(),
                        counting()), maxValuesKey));

        System.out.println("max duplicate value in the array "+maxDuplicateValue);
    }

    private static void reversedArray() {
        int [] numberArray ={1,2,3,4,5,6,7,8,9,10};
        System.out.println("original array" + Arrays.toString(numberArray));
        int[] reversedArray = IntStream.rangeClosed(1, numberArray.length)
                .map(number -> numberArray[numberArray.length - number])
                .toArray();
        System.out.println("reversedArray Array" + Arrays.toString(reversedArray));
    }

    private static void reverseEachWord() {
        String stmt = "java is OOP language";
        String reverseEachWord = Arrays.stream(stmt.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(joining(" "));
        System.out.println(reverseEachWord);
    }

    private static void commonElements() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> twoToTen = of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> commonElements = oneToTen.stream()
                .filter(twoToTen::contains)
                .toList();
        System.out.println(commonElements);
    }

    private static void calculateAndSumAndAverage() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntSummaryStatistics summaryStatistics = oneToTen.stream()
                .collect(summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getAverage());
    }

    private static void sortByLengthOfList() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        names.stream()
              .sorted(Comparator.comparingInt(String::length))
              .forEach(System.out::println);
    }

    private static void secondLargestNumberFromList() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer secondLarge = oneToTen.stream()
                .sorted(reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(Integer.MAX_VALUE);

        System.out.println(secondLarge);
    }

    private static void sumOf() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(oneToTen.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }

    private static boolean isAnagram2() {

        String string1 = "listen";
        String string2 = "silent";

        String join1 = Arrays.stream(string1.split(""))
                .sorted()
                .collect(joining(""));
        String join2 = Arrays.stream(string2.split(""))
                .sorted()
                .collect(joining(""));
        return join1.equals(join2);

    }

    private static void isAnagram() {
        char[] splitIt = "listen".toCharArray();
        char[] splitIt2 = "silent".toCharArray();

        Arrays.sort(splitIt);
        Arrays.sort(splitIt2);
        if (Arrays.equals(splitIt,splitIt2)) {
            System.out.println("is Anagram");
        }else{
            System.out.println("is not anagram");
        }

    }

    private static void min3max3() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> min3 = randomNumbers.stream()
                .sorted(Integer::compare)
                .limit(3)
                .collect(toList());

        List<Integer> max3 = randomNumbers.stream()
                .sorted((x, y) -> Integer.compare(y, x))
                .limit(3)
                .collect(toList());
        System.out.println(min3);
        System.out.println(max3);
    }

    private static void mergeUnsortedArrayIntoSortedWithoutDuplicate() {
        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int [] randomNumber2 = {4, 32, 2, 5, 6, 78, 98, 53, 90};

        System.out.println(Arrays.toString(IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2))
                .distinct()
                .toArray()));
    }

    private static void mergeUnsortedArrayIntoSorted() {
        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int [] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};

        int[] sortedArrayByMergingTwoArray = IntStream.concat(Arrays.stream(randomNumbers),
                Arrays.stream(randomNumber2)).sorted().toArray();
        System.out.println(Arrays.toString(sortedArrayByMergingTwoArray));
    }

    private static void minMaxFromList() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        Integer maxNumber = randomNumbers.stream()
                .max(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);
        Integer minValue = randomNumbers.stream()
                .min(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
        System.out.println(maxNumber);
        System.out.println(minValue);
        IntSummaryStatistics summaryStatistics = randomNumbers.stream()
                .collect(summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getAverage());
    }

    private static void multipleOf5() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> multipleOf5 = randomNumbers.stream()
                .filter(n -> n % 5 == 0)
                .collect(toList());
        System.out.println(multipleOf5);
    }

    private static void joinListOfStrings() {
        List<String> languageList = of("java", "c++", "c", "C sharp", "python", "kotlin", "scala");
        String joinWithPrefixSuffixAndDelimiter = languageList
                .stream()
                .collect(joining(",", "[", "]"));
        System.out.println(joinWithPrefixSuffixAndDelimiter);
    }

    private static void reverseSortedList() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        //this is throwing unsupportedOprerationException because we are
        // tries to sort ImmutableList that is not allowed .
        //   randomNumbers.sort(Comparator.reverseOrder());
        System.out.println(randomNumbers);
        List<Integer> sortInReverse = randomNumbers.stream()
                .sorted((x, y) -> Integer.compare(y, x)) // reverse sort
                .collect(toList());
        System.out.println(sortInReverse);

        List<Integer> sortListReverse = randomNumbers.stream()
                .sorted(reverseOrder())
                .collect(toList());
        System.out.println(sortListReverse);

    }

    private static void wordFrequency() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        Map<String, Long> frequencyWords = names.stream()
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(frequencyWords);
    }

    private static void characterFrequency() {
        String name = "rohitroh";
        Map<String, Long> characterFrequency = Arrays.stream(name.split(""))
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(characterFrequency);


        Map<Character, Long> collected = name.chars()
                .mapToObj(ch -> (char) ch)
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(collected);

        Map<String, Integer> countCharacter = Arrays.stream(name.split(""))
                .collect(groupingBy(Function.identity(),
                        collectingAndThen(counting(), Long::intValue)));
        System.out.println(countCharacter);
    }

    private static void removeDuplicateFromList() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> removeDuplicate = oneToTen.stream()
                .distinct()
                .collect(toList());

        System.out.println(removeDuplicate);
        Set<Integer> removeDuplicateWithoutOrder
                = oneToTen.stream()
                .collect(toSet());
        System.out.println(removeDuplicateWithoutOrder);

        List<Integer> uniqueElement = oneToTen
                .stream()
                .filter(number -> oneToTen.indexOf(number)
                        == oneToTen.lastIndexOf(number))
                .collect(toList());
        System.out.println(uniqueElement);
    }

    private static void separationOfEvenOddNumberInList() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Collection<List<Integer>> evenOddList = oneToTen.stream()
                .collect(collectingAndThen(partitioningBy(i -> i % 2 == 0),
                        Map::values));

        System.out.println(evenOddList);
    }

    private static void separationOfEvenOddNumberInMap() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> evenAddOddSeparation = oneToTen.stream()
                .collect(partitioningBy(i -> i % 2 == 0));

        System.out.println(evenAddOddSeparation);
    }

   public static void findMissingNumber() {
    	
    	int[] arr = {1, 2, 4, 5, 6}; // Example array with one number missing
    	
        int n = arr.length + 1; // As one number is missing
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }
        
        System.out.println("Missing numbers: " + (expectedSum - actualSum));
    }
    
   public static void findMissingNumberXor() {
    	
    	int[] arr = {1, 2, 4, 5, 6}; // Example array with one number missing
    	 
        int n = arr.length + 1; // As one number is missing
        int xorAll = 0;
        int xorArr = 0;

        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        for (int num : arr) {
            xorArr ^= num;
        }
        System.out.println("Missing numbers: " + (xorAll ^ xorArr));
    }
    
   public static void findMissingNumberSet() {
    	
    	int[] arr = {1, 2, 4, 5, 6}; // Example array with one number missing
    	
        int n = arr.length + 1; // As one number is missing
        HashSet<Integer> numSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            numSet.add(i);
        }

        for (int num : arr) {
            numSet.remove(num);
        }

       // The remaining number in the set
        System.out.println("Missing numbers: " + numSet.iterator().next());
    }
    
   private static void findMissingNumberFromArrayUsingIntStream() {
    	
    	int[] arry= { 1, 3, 5, 7, 9, 6, 8, 10 };

		// Find the min and max values in the array
		// int min1 = Arrays.stream(arry2).min().orElseThrow(NoSuchElementException::new);
		// System.out.println("min1 numbers: " + min1);
		// int max1 = Arrays.stream(arry2).max().orElseThrow(NoSuchElementException::new);
		// System.out.println("max1 numbers: " + max1);

		// Convert array to a Set for uniqueness and lookup
		Set<Integer> numbersSet = Arrays.stream(arry).boxed().collect(Collectors.toSet());

		// Generate numbers from min to max (inclusive) and find missing numbers
		List<Integer> missingNumbers = IntStream.rangeClosed(
						Arrays.stream(arry).min().getAsInt(), 
						Arrays.stream(arry).max().getAsInt()) // Generate numbers from min to max
				.boxed() // Convert to Stream<Integer>
				.filter(num -> !numbersSet.contains(num)) // Check if number is missing
				.collect(Collectors.toList()); // Collect into a List

		System.out.println("Missing numbers: " + missingNumbers);		
	}

   public static void findMissingNumberStream() {
    	
    	int[] arr = {1, 2, 4, 5, 6}; // Example array with one number missing
    	  
        int n = arr.length + 1;
        int expectedSum = IntStream.rangeClosed(1, n).sum();
        int actualSum = Arrays.stream(arr).sum();
                
        System.out.println("Missing numbers: " + (expectedSum - actualSum));
    }
    
   public static void findMissingNumberXorStream() {
    	
    	int[] arr = {1, 2, 4, 5, 6}; // Example array with one number missing
    	  
        int n = arr.length + 1;
        int xorAll = IntStream.rangeClosed(1, n).reduce(0, (a, b) -> a ^ b);
        int xorArr = Arrays.stream(arr).reduce(0, (a, b) -> a ^ b);
        
        System.out.println("Missing numbers: " + (xorAll ^ xorArr));
    }
    
   public static void findMissingNumberSetStream() {
    	
    	int[] arr = {1, 2, 4, 5, 6}; // Example array with one number missing
    	
        int n = arr.length + 1;
        Set<Integer> numSet = IntStream.rangeClosed(1, n)
                                       .boxed()
                                       .collect(Collectors.toSet());

        Arrays.stream(arr).forEach(numSet::remove);
        
        System.out.println("Missing numbers: " + numSet.iterator().next());
    }
}
```
Here’s a detailed comparison of the methods you mentioned in Java for creating streams and lists:

### 1. `Stream.of(1, 2, 3)`

- **Purpose**: Creates a `Stream` of integers.
- **Usage**: Useful for performing functional operations on sequences of elements.
- **Characteristics**:
  - **Stream**: Represents a sequence of elements that can be processed in parallel or sequentially.
  - **Operations**: Supports various stream operations like `map`, `filter`, `reduce`, etc.
  - **Immutable**: Streams do not modify the original data source but produce new results based on the operations.

```java
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.forEach(System.out::println); // Output: 1 2 3
    }
}
```

### 2. `IntStream.of(1, 2, 3)`

- **Purpose**: Creates an `IntStream` of integers.
- **Usage**: Similar to `Stream.of`, but specifically for primitive `int` values.
- **Characteristics**:
  - **IntStream**: A specialized stream for primitive `int` values, which avoids boxing overhead.
  - **Operations**: Supports similar operations as `Stream`, but for `int` values.
  - **Performance**: More efficient for numeric operations as it avoids boxing.

```java
import java.util.stream.IntStream;

public class Example {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3);
        intStream.forEach(System.out::println); // Output: 1 2 3
    }
}
```

### 3. `List.of(1, 2, 3)`

- **Purpose**: Creates an unmodifiable `List` of integers.
- **Usage**: Ideal for creating immutable lists in Java 9 and above.
- **Characteristics**:
  - **List**: Represents a collection of elements that can be accessed by index.
  - **Immutable**: The list cannot be modified after creation (no add/remove operations).
  - **Null Handling**: Does not accept `null` values.

```java
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        list.forEach(System.out::println); // Output: 1 2 3
    }
}
```

### 4. `Arrays.asList(1, 2, 3)`

- **Purpose**: Creates a fixed-size `List` backed by an array.
- **Usage**: Useful for creating lists from arrays or varargs.
- **Characteristics**:
  - **List**: Represents a collection of elements backed by an array.
  - **Fixed-size**: The list size cannot be changed (no add/remove operations), but elements can be modified.
  - **Null Handling**: Accepts `null` values.

```java
import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(System.out::println); // Output: 1 2 3
    }
}
```

### 5. `of(1, 2, 3)`

- **Purpose**: This is ambiguous without context. It might refer to custom utility methods or a specific library method.
- **Usage**: Could be used to create lists or other collections depending on the implementation.
- **Characteristics**: Depends on the specific implementation of the `of` method.

### Summary

- **Stream.of(1, 2, 3)**: Creates a `Stream` for functional-style operations.
- **IntStream.of(1, 2, 3)**: Creates an `IntStream` for primitive `int` values, more efficient for numeric operations.
- **List.of(1, 2, 3)**: Creates an immutable `List` of integers.
- **Arrays.asList(1, 2, 3)**: Creates a fixed-size `List` backed by an array.

Choose the method based on what you need: whether you need a `Stream` for processing sequences of elements, an `IntStream` for numeric operations, an immutable `List`, or a fixed-size list backed by an array.

In Java 9 and later, the `List.of(E... elements)` method is used to create immutable lists. When you use `List.of(1, 2, 3)`, you are invoking this static method from the `java.util.List` interface. Here’s a deeper look at `List.of()` and what it does:

### `List.of(E... elements)`

- **Purpose**: Creates an unmodifiable list containing the specified elements.
- **Usage**: This method is part of the `java.util.List` interface and was introduced in Java 9 to simplify the creation of immutable lists.
- **Characteristics**:
  - **Immutability**: The list created is immutable. Once created, you cannot add, remove, or modify elements in the list.
  - **Null Handling**: This method does not allow `null` elements. If any of the provided elements is `null`, it will throw a `NullPointerException`.
  - **Performance**: The implementation is optimized for small lists. For example, it uses different internal representations for lists with a few elements.

### Example Usage

Here’s how you can use `List.of()`:

```java
import java.util.List;

public class Example {
    public static void main(String[] args) {
        // Creating an immutable list using List.of()
        List<Integer> list = List.of(1, 2, 3);
        
        // Printing the list elements
        list.forEach(System.out::println); // Output: 1 2 3
        
        // Attempting to modify the list will result in UnsupportedOperationException
        // list.add(4); // Throws UnsupportedOperationException
        // list.remove(1); // Throws UnsupportedOperationException
    }
}
```

Similarily you can use `of()` by using `import static java.util.List.of`:

```java
import java.util.List;
import static java.util.List.of;

public class Example {
    public static void main(String[] args) {
        // Creating an immutable list using List.of()
        List<Integer> list = of(1, 2, 3);
        
        // Printing the list elements
        list.forEach(System.out::println); // Output: 1 2 3
        
        // Attempting to modify the list will result in UnsupportedOperationException
        // list.add(4); // Throws UnsupportedOperationException
        // list.remove(1); // Throws UnsupportedOperationException
    }
}
```
### Key Points

1. **Immutability**: The list returned by `List.of()` is immutable. You cannot change its contents. Any attempt to modify the list will result in an `UnsupportedOperationException`.

2. **Null Elements**: The method does not accept `null` values. If you pass `null` as one of the elements, it will throw a `NullPointerException`.

3. **Efficiency**: For a small number of elements, `List.of()` is efficient and uses an internal representation that avoids the overhead of a typical `ArrayList` or `LinkedList`.

4. **API Usage**: This method is particularly useful for creating simple immutable lists in a concise way without needing to use `Arrays.asList()` or other methods.

### Summary

The `List.of(E... elements)` method is a convenient and efficient way to create immutable lists in Java 9 and later. It ensures immutability and disallows `null` values, providing a straightforward API for list creation.

Your Java code snippet correctly demonstrates how to use the `List.of()` method to create an immutable list and handle its immutability. Here’s a quick overview of what each part does:

### Code Breakdown

```java
import java.util.List;
import static java.util.List.of;

public class Example {
    public static void main(String[] args) {
        // Creating an immutable list using List.of()
        List<Integer> list = of(1, 2, 3);
        
        // Printing the list elements
        list.forEach(System.out::println); // Output: 1 2 3
        
        // Attempting to modify the list will result in UnsupportedOperationException
        // list.add(4); // Throws UnsupportedOperationException
        // list.remove(1); // Throws UnsupportedOperationException
    }
}
```

### Explanation

1. **Imports and Static Import**:
   - `import java.util.List;`: Imports the `List` interface.
   - `import static java.util.List.of;`: Allows you to use the `of` method directly without qualifying it with `List.`.

2. **Creating the Immutable List**:
   - `List<Integer> list = of(1, 2, 3);`: Creates an immutable list with the elements `1`, `2`, and `3`. This is done using the `List.of()` method from Java 9 and later.

3. **Printing the List Elements**:
   - `list.forEach(System.out::println);`: Iterates over the elements of the list and prints each one. The output will be:
     ```
     1
     2
     3
     ```

4. **Attempting to Modify the List**:
   - The comments indicate that modifying the list (e.g., `list.add(4);` or `list.remove(1);`) will throw an `UnsupportedOperationException`. This is because the list created by `List.of()` is immutable.

### Additional Notes

- **Immutability**: The `List.of()` method returns an immutable list. This means:
  - You cannot add, remove, or update elements in this list.
  - Any attempt to modify the list will result in an `UnsupportedOperationException`.

- **Null Values**: If you attempt to create a list with `null` values, like `List.of(1, null, 3)`, a `NullPointerException` will be thrown.

- **Usage Context**: This method is ideal when you need to create a simple, fixed-size, immutable list, such as when defining constants or parameters that should not change.

Your example code is well-written and correctly demonstrates how to use `List.of()` in a Java 9+ environment. If you have any further questions or need more examples, feel free to ask!

Here’s a detailed comparison of `Stream.of()`, `IntStream.of()`, `List.of()`, and `Arrays.asList()` methods, including how they behave with `String` and `Character` arrays:

### `Stream.of()`, `IntStream.of()`, `List.of()`, and `Arrays.asList()`

1. **`Stream.of(1, 2, 3)`**
   - **Purpose**: Creates a `Stream` of integers.
   - **Usage**: Useful for performing functional-style operations (e.g., filtering, mapping) on sequences of elements.
   - **Characteristics**:
     - **Stream**: Represents a sequence of elements that can be processed in parallel or sequentially.
     - **Operations**: Supports stream operations such as `map`, `filter`, `reduce`, etc.
     - **Immutability**: Streams are not immutable; they do not modify the underlying data but create new results based on operations.

   ```java
   import java.util.stream.Stream;

   public class Example {
       public static void main(String[] args) {
           Stream<Integer> stream = Stream.of(1, 2, 3);
           stream.forEach(System.out::println); // Output: 1 2 3
       }
   }
   ```

2. **`IntStream.of(1, 2, 3)`**
   - **Purpose**: Creates an `IntStream` of primitive `int` values.
   - **Usage**: For numeric operations without boxing overhead.
   - **Characteristics**:
     - **IntStream**: A specialized stream for primitive `int` values.
     - **Operations**: Supports operations similar to `Stream`, but optimized for primitive types.
     - **Performance**: More efficient for numeric operations due to avoiding boxing/unboxing.

   ```java
   import java.util.stream.IntStream;

   public class Example {
       public static void main(String[] args) {
           IntStream intStream = IntStream.of(1, 2, 3);
           intStream.forEach(System.out::println); // Output: 1 2 3
       }
   }
   ```

3. **`List.of(1, 2, 3)`**
   - **Purpose**: Creates an immutable `List` containing the specified elements.
   - **Usage**: Ideal for creating fixed-size, immutable lists.
   - **Characteristics**:
     - **List**: Represents a collection of elements that can be accessed by index.
     - **Immutability**: The list cannot be modified after creation (e.g., no add/remove operations).
     - **Null Handling**: Does not accept `null` values.

   ```java
   import java.util.List;

   public class Example {
       public static void main(String[] args) {
           List<Integer> list = List.of(1, 2, 3);
           list.forEach(System.out::println); // Output: 1 2 3
       }
   }
   ```

4. **`Arrays.asList(1, 2, 3)`**
   - **Purpose**: Creates a fixed-size `List` backed by an array.
   - **Usage**: Converts arrays to lists or creates lists from varargs.
   - **Characteristics**:
     - **List**: Backed by the original array; modifications to the list affect the array and vice versa.
     - **Fixed-size**: You cannot change the size of the list (e.g., no add/remove operations), but you can modify the elements.
     - **Null Handling**: Accepts `null` values.

   ```java
   import java.util.Arrays;
   import java.util.List;

   public class Example {
       public static void main(String[] args) {
           List<Integer> list = Arrays.asList(1, 2, 3);
           list.forEach(System.out::println); // Output: 1 2 3
       }
   }
   ```

### Handling `String` and `Character` Arrays

1. **`Stream.of("a", "b", "c")`**
   - **Purpose**: Creates a `Stream` of `String` values.
   - **Usage**: For functional-style operations on sequences of `String` elements.

   ```java
   import java.util.stream.Stream;

   public class Example {
       public static void main(String[] args) {
           Stream<String> stream = Stream.of("a", "b", "c");
           stream.forEach(System.out::println); // Output: a b c
       }
   }
   ```

2. **`IntStream.of('a', 'b', 'c')`**
   - **Purpose**: Creates an `IntStream` of ASCII values (converted from `char` to `int`).
   - **Usage**: For numeric operations on character codes.
   - **Characteristics**: Characters are automatically converted to their integer ASCII values.

   ```java
   import java.util.stream.IntStream;

   public class Example {
       public static void main(String[] args) {
           IntStream intStream = IntStream.of('a', 'b', 'c');
           intStream.forEach(c -> System.out.println((char) c)); // Output: a b c
       }
   }
   ```

3. **`List.of("a", "b", "c")`**
   - **Purpose**: Creates an immutable `List` of `String` elements.
   - **Usage**: Creates an immutable list with `String` elements.

   ```java
   import java.util.List;

   public class Example {
       public static void main(String[] args) {
           List<String> list = List.of("a", "b", "c");
           list.forEach(System.out::println); // Output: a b c
       }
   }
   ```

4. **`Arrays.asList("a", "b", "c")`**
   - **Purpose**: Creates a fixed-size `List` backed by an array of `String` elements.
   - **Usage**: Converts a `String` array to a list or creates a list from varargs.

   ```java
   import java.util.Arrays;
   import java.util.List;

   public class Example {
       public static void main(String[] args) {
           List<String> list = Arrays.asList("a", "b", "c");
           list.forEach(System.out::println); // Output: a b c
       }
   }
   ```

### Summary

- **Stream.of()**: Creates a `Stream` for functional operations.
- **IntStream.of()**: Creates an `IntStream` for primitive `int` values, suitable for numeric operations.
- **List.of()**: Creates an immutable `List`.
- **Arrays.asList()**: Creates a fixed-size `List` backed by an array.

For `String` and `Character` arrays, the usage of these methods is similar, but be mindful of how `IntStream` interprets `char` values (as integer ASCII values).
