# Coding Example

```java
package com.coding.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingExample {

	public static void main(String[] args) {

		// 1. Array Basics

		// # Initialize an Array

		// Initialize an array of integers
		int[] numbers = { 1, 2, 3, 4, 5 };
		System.out.println("Array initialized: ");
		for (int number : numbers) {
			System.out.print(number + " ");
		}

		// # Reverse an Array

		int[] numbers1 = { 1, 2, 3, 4, 5 };
		int[] reversed = new int[numbers1.length];
		for (int i = 0; i < numbers1.length; i++) {
			reversed[i] = numbers1[numbers1.length - 1 - i];
		}
		System.out.println("Reversed array: ");
		for (int number : reversed) {
			System.out.print(number + " ");
		}

		// # Comparing Two Arrays

		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 1, 2, 3 };

		boolean areEqual = Arrays.equals(array1, array2);
		System.out.println("Arrays equal: " + areEqual);

		// # Printing an Array

		int[] numbers2 = { 1, 2, 3, 4, 5 };
		System.out.println("Array: " + Arrays.toString(numbers2));

		// # Printing 2D Array

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}

		// 2. Array Operations

		// # Concatenate Two Arrays

		int[] array3 = { 1, 2, 3 };
		int[] array4 = { 4, 5, 6 };
		int[] result1 = new int[array3.length + array4.length];
		System.arraycopy(array3, 0, result1, 0, array3.length);
		System.arraycopy(array4, 0, result1, array3.length, array4.length);
		System.out.println("Concatenated array: " + Arrays.toString(result1));

		// # Splitting an Array

		int[] numbers3 = { 1, 2, 3, 4, 5, 6 };
		int mid = numbers3.length / 2;
		int[] firstHalf = Arrays.copyOfRange(numbers3, 0, mid);
		int[] secondHalf = Arrays.copyOfRange(numbers3, mid, numbers3.length);
		System.out.println("First half: " + Arrays.toString(firstHalf));
		System.out.println("Second half: " + Arrays.toString(secondHalf));

		// # Joining Array Items with Separator

		String[] items = { "Apple", "Banana", "Cherry" };
		String result2 = Arrays.stream(items).collect(Collectors.joining(", "));
		System.out.println("Joined array: " + result2);

		// # Resizing an Array

		int[] original = { 1, 2, 3 };
		int[] resized = Arrays.copyOf(original, 5);
		System.out.println("Resized array: " + Arrays.toString(resized));

		// # Removing Items from Array

		int[] original1 = { 1, 2, 3, 4, 5 };
		int indexToRemove = 2; // Removing element at index 2 (value 3)
		int[] result3 = new int[original1.length - 1];
		for (int i = 0, j = 0; i < original1.length; i++) {
			if (i != indexToRemove) {
				result3[j++] = original1[i];
			}
		}
		System.out.println("Array after removal: " + Arrays.toString(result3));

		// # Remove Duplicates from Array

		int[] numbers4 = { 1, 2, 2, 3, 4, 4, 5 };
		Set<Integer> set = new HashSet<>();
		for (int number : numbers4) {
			set.add(number);
		}
		int[] uniqueNumbers = set.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("Array without duplicates: " + Arrays.toString(uniqueNumbers));

		// # Union of Two Arrays

		int[] array11 = { 1, 2, 3 };
		int[] array21 = { 3, 4, 5 };
		Set<Integer> set1 = new HashSet<>();
		for (int number : array11)
			set1.add(number);
		for (int number : array21)
			set.add(number);
		int[] union = set.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("Union of arrays: " + Arrays.toString(union));

		// # Intersection of Two Arrays

		int[] array12 = { 1, 2, 3 };
		int[] array22 = { 2, 3, 4 };
		Set<Integer> set12 = new HashSet<>();
		Set<Integer> set22 = new HashSet<>();
		for (int number : array12)
			set12.add(number);
		for (int number : array22)
			set22.add(number);
		set12.retainAll(set22);
		int[] intersection = set12.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("Intersection of arrays: " + Arrays.toString(intersection));

		// 3. Searching and Sorting

		// # How to Check if Array Contains an Item

		int[] numbers5 = { 1, 2, 3, 4, 5 };
		int itemToFind = 3;
		boolean contains = Arrays.stream(numbers5).anyMatch(n -> n == itemToFind);
		System.out.println("Array contains " + itemToFind + ": " + contains);

		// # Find Top N Items in Array

		int[] numbers6 = { 10, 20, 30, 40, 50 };
		int n = 3;
		int[] topN = Arrays.copyOfRange(numbers6, numbers6.length - n, numbers6.length);
		Arrays.sort(topN);
		System.out.println("Top " + n + " items: " + Arrays.toString(topN));

		// # Find Sum and Average of Array

		int[] numbers7 = { 1, 2, 3, 4, 5 };
		int sum = Arrays.stream(numbers7).sum();
		double average = Arrays.stream(numbers7).average().orElse(0.0);
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + average);

		// # Find Max/Min in Array

		int[] numbers8 = { 1, 2, 3, 4, 5 };
		int max = Arrays.stream(numbers8).max().orElseThrow();
		int min = Arrays.stream(numbers8).min().orElseThrow();
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);

		// # Sorting an Array

		int[] numbers9 = { 5, 3, 8, 1, 2 };
		Arrays.sort(numbers9);
		System.out.println("Sorted array: " + Arrays.toString(numbers9));

		// # Checking if Array is Already Sorted

		int[] numbers10 = { 1, 2, 3, 4, 5 };
		boolean isSorted = true;
		for (int i = 1; i < numbers10.length; i++) {
			if (numbers10[i - 1] > numbers10[i]) {
				isSorted = false;
				break;
			}
		}
		System.out.println("Array is sorted: " + isSorted);

		// 4. Conversions

		// # Array of Primitives to Array of Objects

		int[] primitiveArray = { 1, 2, 3 };
		Integer[] objectArray = Arrays.stream(primitiveArray).boxed().toArray(Integer[]::new);
		System.out.println("Array of Objects: " + Arrays.toString(objectArray));

		// # Convert Between Array and List

		String[] array = { "Apple", "Banana", "Cherry" };
		List<String> list = Arrays.asList(array);
		System.out.println("List: " + list);

		String[] newArray = list.toArray(new String[0]);
		System.out.println("Array: " + Arrays.toString(newArray));

		// # Convert Between Stream and Array

		Stream<String> stream = Stream.of("Apple", "Banana", "Cherry");
		String[] array6 = stream.toArray(String[]::new);
		System.out.println("Array: " + Arrays.toString(array6));

		Stream<String> newStream = Arrays.stream(array6);
		System.out.println("Stream: " + newStream.collect(Collectors.toList()));

		// # Java String to String Array

		String str = "Apple,Banana,Cherry";
		String[] array7 = str.split(",");
		System.out.println("Array: " + Arrays.toString(array));

		// # Convert a Primitive Array to List in Java

		int[] primitiveArray2 = { 1, 2, 3 };
		List<Integer> list2 = Arrays.stream(primitiveArray2).boxed().collect(Collectors.toList());
		System.out.println("List: " + list2);

		// 5. Advanced Topics

		// # Java Array Clone

		int[] original5 = { 1, 2, 3, 4, 5 };
		int[] clone = original5.clone();
		System.out.println("Original array: " + Arrays.toString(original5));
		System.out.println("Cloned array: " + Arrays.toString(clone));

		// # Java Array Copy

		int[] original6 = { 1, 2, 3, 4, 5 };
		int[] copy = new int[original6.length];
		System.arraycopy(original6, 0, copy, 0, original6.length);
		System.out.println("Original array: " + Arrays.toString(original6));
		System.out.println("Copied array: " + Arrays.toString(copy));

		// # Java Array Deep Copy

		int[][] original7 = { { 1, 2 }, { 3, 4 } };
		int[][] deepCopy = Arrays.stream(original7).map(int[]::clone).toArray(int[][]::new);
		System.out.println("Original array: " + Arrays.deepToString(original7));
		System.out.println("Deep copied array: " + Arrays.deepToString(deepCopy));

		// # Java Copy Array Range

		int[] original8 = { 1, 2, 3, 4, 5 };
		int[] range = Arrays.copyOfRange(original8, 1, 4); // Elements from index 1 to 3
		System.out.println("Array range: " + Arrays.toString(range));

		// # Missing Number Sum Formula IntStream
		int[] numbers11 = { 1, 3, 4, 5, 6, 8, 10, 9 };

		int n1 = 10; // The maximum number in the sequence

		// Create a set with all numbers from 1 to n
		Set<Integer> allNumbers = IntStream.rangeClosed(1, n1).boxed().collect(Collectors.toSet());

		// Remove all present numbers from the set
		Set<Integer> missingNumbers = IntStream.of(numbers11).boxed().collect(Collectors.toSet());

		// Find the missing numbers by retaining only those not in the present numbers
		// set
		allNumbers.removeAll(missingNumbers);

		System.out.println("The missing numbers are: " + allNumbers);

		// 1. Count the occurrences of each word in a Array of strings using streams.

		String[] words = { "apple", "banana", "apple", "orange", "banana", "apple" };

		Map<String, Long> collect = Arrays.asList(words).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(collect);

		// 2. Write a program to find the longest string in a list of strings using
		// streams.

		List<String> list3 = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");

		Optional<String> max3 = list3.stream().max(Comparator.comparingInt(String::length));

		System.out.println(max3.get());

		// 3. Given a list of integers, remove duplicates and keep them in the
		// descending order using streams.

		List<Integer> numbers30 = Arrays.asList(1, 2, 3, 2, 4, 5, 1);

		List<Integer> collect1 = numbers30.stream().distinct()
				.sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());

		System.out.println(collect1);

		// 4. Write a program to find the average of a list of doubles using streams.

		List<Double> doubles = Arrays.asList(1.2, 3.5, 2.8, 4.1, 5.7);
		OptionalDouble average2 = doubles.stream().mapToDouble(Double::doubleValue).average();
		System.out.println(average2.getAsDouble());

		// 5. Merge two lists of integers and remove duplicates using streams.

		List<Integer> list13 = Arrays.asList(1, 2, 3);
		List<Integer> list23 = Arrays.asList(3, 4, 5);

		List<Integer> collect2 = Stream.concat(list13.stream(), list23.stream()).distinct()
				.collect(Collectors.toList());
		System.out.println(collect2);

		// 6. Given a list of strings, concatenate them into a single string using
		// streams.

		List<String> list33 = Arrays.asList("Hello", " ", "world", "!");

		String collect3 = list33.stream().collect(Collectors.joining());
		System.out.println(collect3);

		// 7. Write a program to find the first non-repeating character in a string
		// using streams.

		String str3 = "abacdbef";

		Optional<Character> firstNonRepeatingChar = str3.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1L).map(Map.Entry::getKey).findFirst();

		System.out.println(firstNonRepeatingChar.get());

		// 8. Given a list of strings, remove all strings that contain a specific
		// character using streams.

		List<String> list4 = Arrays.asList("apple", "banana", "orange", "kiwi");
		char specificChar = 'a';

		List<String> collect4 = list4.stream().filter(s -> !s.contains(String.valueOf(specificChar)))
				.collect(Collectors.toList());

		System.out.println(collect4);

		// 9. Given a list of integers, partition them into two groups: odd and even,
		// using streams.

		List<Integer> numbers23 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean, List<Integer>> oddEvenPartition = numbers23.stream()
				.collect(Collectors.partitioningBy(n3 -> n3 % 2 == 0));

		System.out.println(oddEvenPartition);

		// 10. Given an array of integers, find the kth largest element.

		List<Integer> list5 = Arrays.asList(1, 12, 44, 32, 52, 81, 59, 84, 72, 37);

		int k = 4;

		Integer num = list5.stream().sorted(Comparator.reverseOrder()).limit(k).skip(k - 1).findFirst().orElse(-1);
		System.out.println(num);

		// 11. Write a program to perform cube on list elements and filter numbers
		// greater than 50

		List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
		integerList.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);

		// 12. Given a list of strings, find the count of strings starting with a
		// vowels.

		List<String> list6 = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");
		long count = list6.stream().filter(s -> "aeiouAEIOU".contains(String.valueOf(s.charAt(0)))).count();
		System.out.println(count);

		// 13.Given a list of strings, find the longest palindrome string.

		List<String> list7 = List.of("level", "hello", "radar", "world", "madam", "java", "Malayalam");

		String str2 = list7.stream().filter(s -> new StringBuilder(s).reverse().toString().equalsIgnoreCase(s))
				.max(Comparator.comparingInt(String::length)).orElse("");

		System.out.println(str2);

		// 14. Given a list of integers, find the product of all non-negative integers.

		List<Integer> integerList2 = Arrays.asList(4, 5, -6, 7, -1, 2, -3);

		long longNumber = integerList2.stream().filter(num2 -> num2 >= 0).mapToLong(Integer::longValue).reduce(1,
				(a, b) -> a * b);

		System.out.println(longNumber);

		List<Student> list8 = Arrays.asList(
				new Student(1, "Aditya", "Mall", 30, "Male", "Mechanical Engineering", 2014, "Mumbai", 122),
				new Student(2, "Pulkith", "Singh", 26, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankita", "Patil", 25, "Female", "Computer Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Darshan", "Mukd", 23, "Male", "Instrumentation Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Satyam", "Pandey", 26, "Male", "Biotech Engineering", 2017, "Mumbai", 98));

		// 1. Group the students by department names.
		Map<String, List<Student>> collect8 = list8.stream().collect(Collectors.groupingBy(Student::getDepartmantName));

		System.out.println("Students grouped by Department " + collect8);
		// 2. Find the count of students in each department.

		Map<String, Long> collect9 = list8.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		System.out.println("Count of Students in each Department" + collect9);
		// 3. Find all departments names.

		List<String> deptName = list8.stream().map(t -> t.getDepartmantName()).distinct().collect(Collectors.toList());

		System.out.println("Deaprtment Names " + deptName);
		// 4. Find the list of students whose age is less than 25.

		List<Student> collect10 = list8.stream().filter(t -> t.getAge() < 25).collect(Collectors.toList());

		System.out.println("List of Students whose Age is leass than 25 " + collect10);
		// 5. Find the max age of students.

		OptionalInt max1 = list8.stream().mapToInt(t -> t.getAge()).max();

		System.out.println("Max age of students " + max1.getAsInt());
		// 6. Find the average age of male and female students.

		Map<String, Double> collect11 = list8.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
		System.out.println("Average age of Male and Female students " + collect11);
		// 7. Find the young student in all departments.

		int min4 = list8.stream().mapToInt(Student::getAge).min().getAsInt();

		System.out.println("Minimum age of student is " + min4);

		// or

		Student student = list8.stream().min(Comparator.comparing(Student::getAge)).get();

		System.out.println("Young student is " + student);
		// 8. Find the senior female student in all departments.

		int seniorStudent = list8.stream().filter(t -> t.getGender().equals("Female")).mapToInt(Student::getAge).max()
				.getAsInt();

		System.out.println("Senior Female student is " + seniorStudent);

		// OR

		Student student2 = list8.stream().filter(t -> t.getGender().equals("Female"))
				.max(Comparator.comparing(Student::getAge)).get();

		System.out.println("Senior Female student is " + student2);
		// 9. Find the list of students whose rank is between 50 and 100.

		List<Student> collect12 = list8.stream().filter(t -> t.getRank() > 50 && t.getRank() < 100)
				.collect(Collectors.toList());

		System.out.println("students whose rank is between 50 and 100 " + collect);
		// 10. Find the department who is having maximum number of students.

		Entry<String, Long> entry = list8.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();

		System.out.println("Department having maximum number of students " + entry);
		// 11. Find the Students who stays in Mumbai and sort them by their names.

		List<Student> collect13 = list8.stream().filter(t -> t.getCity().equals("Mumbai"))
				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());

		System.out.println(collect13);
		// 12. Find the total count of students.

		long count2 = list8.stream().count();

		System.out.println("Total count " + count2);
		// 13. Find the average rank in all departments.

		Map<String, Double> collect14 = list8.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));

		System.out.println("Average ranks " + collect14);
		// 14. Find the highest rank in each department.

		Map<String, Optional<Student>> collect15 = list8.stream().collect(Collectors
				.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))));

		System.out.println(collect15);
		// 15. Find the list of students , which are sorted by their rank.

		List<Student> collect16 = list8.stream().sorted(Comparator.comparing(Student::getRank))
				.collect(Collectors.toList());

		System.out.println(collect16);
		// 16. Find the second highest rank student.

		Student student3 = list8.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();

		System.out.println("Student " + student3);
		// 17. Find the ranks of students in all department in ascending order.

		Map<String, List<Student>> collect17 = list8.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName,
						Collectors.collectingAndThen(Collectors.toList(), list9 -> list9.stream()
								.sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList()))));
		System.out.println(collect17);

		String occurance = "I am a java developer";
		Map<Character, Long> output = occurance.chars().mapToObj(c -> (char) c).filter(Character::isLetter)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("output:" + output);

		List<String> words1 = List.of("apple", "banana", "cherry", "date", "elderberry");

		// Partition strings based on length
		Map<Boolean, List<String>> partitioned = words1.stream()
				.collect(Collectors.partitioningBy(word -> word.length() > 5));

		System.out.println("Words with more than 5 characters: " + partitioned.get(true));
		System.out.println("Words with 5 or fewer characters: " + partitioned.get(false));

		List<Integer> numbers14 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Partition numbers into even and odd
		Map<Boolean, List<Integer>> partitioned1 = numbers14.stream().collect(Collectors.partitioningBy(n4 -> n4 % 2 == 0));

		System.out.println("Even numbers: " + partitioned1.get(true));
		System.out.println("Odd numbers: " + partitioned1.get(false));

		// Initialize the int array
		int[] numbers15 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// Convert int[] to Stream<Integer>
		Map<Boolean, List<Integer>> partitioned2 = IntStream.of(numbers15).boxed() // Convert IntStream to
																					// Stream<Integer>
				.collect(Collectors.partitioningBy(n4 -> n4 % 2 == 0));

		// Print the results
		System.out.println("Even numbers: " + partitioned2.get(true));
		System.out.println("Odd numbers: " + partitioned2.get(false));

		List<String> list15 = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
		System.out.println(list15); // Output: [a, b, c, d]

		Set<String> set15 = Stream.of("a", "b", "c", "a").collect(Collectors.toSet());
		System.out.println(set15); // Output: [a, b, c] (Order may vary)

//		Map<Integer, String> map0 = Stream.of("a", "b", "c").distinct().collect(Collectors.toMap(String::length, s1 -> s1));
//		System.out.println("outpumap0: "+map0); // Output: {1=a, 2=b, 3=c}
//		
		Map<Integer, String> map1 = Stream.of("a", "b", "c").distinct() // Remove duplicates if any
				.collect(Collectors.toMap(String::length, s -> s, (existing, replacement) -> existing)); // Keep the
																											// existing
																											// value

		System.out.println("outpumap1: " + map1); // Output: {1=a, 2=b, 3=c

		Map<Integer, String> map5 = Stream.of("a", "b", "c", "d", "e")
				.collect(Collectors.toMap(String::length, s -> s, (existing, replacement) -> replacement)); // Keep the
																											// replacement
																											// value

		System.out.println("Output map5: " + map5);

//		Map<Integer, String> map2 = Stream.of("apple", "banana", "cherry")
//		.collect(Collectors.toMap(String::length, s -> s));
//System.out.println(map2); // Output: {5=apple, 6=banana, 6=cherry}

		String result = Stream.of("a", "b", "c").collect(Collectors.joining(", ", "[", "]"));
		System.out.println(result); // Output: [a, b, c]

		Map<Integer, List<String>> groupedByLength = Stream.of("a", "bb", "ccc", "dd")
				.collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength); // Output: {1=[a], 2=[bb, dd], 3=[ccc]}

		Map<Boolean, List<String>> partitioned15 = Stream.of("a", "bb", "ccc", "dd")
				.collect(Collectors.partitioningBy(s -> s.length() > 2));
		System.out.println(partitioned15); // Output: {false=[a, bb, dd], true=[ccc]}

		long count4 = Stream.of("a", "b", "c", "d").collect(Collectors.counting());
		System.out.println(count4); // Output: 4

		IntSummaryStatistics stats = Stream.of("a", "bb", "ccc", "dddd")
				.collect(Collectors.summarizingInt(String::length));
		System.out.println(stats); // Output: IntSummaryStatistics{count=4, sum=10, min=1, average=2.500000, max=4}

		Optional<String> concatenated = Stream.of("a", "b", "c", "d").collect(Collectors.reducing((s1, s2) -> s1 + s2));
		System.out.println(concatenated.get()); // Output: abcd

		List<Integer> lengths = Stream.of("a", "bb", "ccc", "dddd")
				.collect(Collectors.mapping(String::length, Collectors.toList()));
		System.out.println(lengths); // Output: [1, 2, 3, 4]

		List<Character> characters = Stream.of("hello", "world")
				.collect(Collectors.flatMapping(s -> s.chars().mapToObj(c -> (char) c), Collectors.toList()));
		System.out.println(characters); // Output: [h, e, l, l, o, w, o, r, l, d]

		List<String> result15 = Stream.of("a", "b", "c", "d")
				.collect(Collectors.collectingAndThen(Collectors.toList(), list1 -> {
					list1.add("e");
					return list1;
				}));
		System.out.println(result15); // Output: [a, b, c, d, e]

		List<String> list25 = Stream.of("apple", "banana", "cherry").collect(Collectors.toList());
		System.out.println(list25); // Output: [apple, banana, cherry]

		Set<String> set2 = Stream.of("apple", "banana", "apple", "cherry").collect(Collectors.toSet());
		System.out.println(set2); // Output: [banana, cherry, apple] (Order may vary)

//		Map<Integer, String> map2 = Stream.of("apple", "banana", "cherry")
//				.collect(Collectors.toMap(String::length, s -> s));
//		System.out.println(map2); // Output: {5=apple, 6=banana, 6=cherry}

		Map<Integer, String> map2 = Stream.of("apple", "banana", "cherry")
				.collect(Collectors.toMap(String::length, s -> s, (existing, replacement) -> existing)); // Keep the
																											// existing
																											// value

		System.out.println("outpumap2: " + map2); // Output: {5=apple, 6=banana, 6=cherry}

		String result25 = Stream.of("apple", "banana", "cherry").collect(Collectors.joining(", ", "[", "]"));
		System.out.println(result25); // Output: [apple, banana, cherry]

		Map<Integer, List<String>> groupedByLength1 = Stream.of("apple", "banana", "cherry", "date")
				.collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength1); // Output: {4=[date], 5=[apple], 6=[banana, cherry]}

		Map<Boolean, List<String>> partitioned25 = Stream.of("apple", "banana", "cherry", "date")
				.collect(Collectors.partitioningBy(s -> s.length() > 5));
		System.out.println(partitioned25); // Output: {false=[apple, date], true=[banana, cherry]}

		long count25 = Stream.of("apple", "banana", "cherry", "date").collect(Collectors.counting());
		System.out.println(count25); // Output: 4

		IntSummaryStatistics stats2 = Stream.of("apple", "banana", "cherry", "date")
				.collect(Collectors.summarizingInt(String::length));
		System.out.println(stats2); // Output: IntSummaryStatistics{count=4, sum=19, min=4, average=4.750000, max=6}

		Optional<String> concatenated2 = Stream.of("apple", "banana", "cherry", "date")
				.collect(Collectors.reducing((s1, s2) -> s1 + s2));
		System.out.println(concatenated2.get()); // Output: applebananacherrydate

		List<Integer> lengths2 = Stream.of("apple", "banana", "cherry", "date")
				.collect(Collectors.mapping(String::length, Collectors.toList()));
		System.out.println(lengths2); // Output: [5, 6, 6, 4]

		List<Character> characters2 = Stream.of("apple", "banana", "cherry")
				.collect(Collectors.flatMapping(s -> s.chars().mapToObj(c -> (char) c), Collectors.toList()));
		System.out.println(characters2); // Output: [a, p, p, l, e, b, a, n, a, n, a, c, h, e, r, r, y]

		List<String> result35 = Stream.of("apple", "banana", "cherry")
				.collect(Collectors.collectingAndThen(Collectors.toList(), list31 -> {
					list31.add("date");
					return list31;
				}));
		System.out.println(result35); // Output: [apple, banana, cherry, date

		int[] array15 = { 1, 2, 3, 4, 5 };
		int[] array25 = { 4, 5, 6, 7, 8 };

		// Convert arrays to sets
		Set<Integer> set16 = Arrays.stream(array15).boxed().collect(Collectors.toSet());
		Set<Integer> set25 = Arrays.stream(array25).boxed().collect(Collectors.toSet());

		// Find intersection
		set1.retainAll(set25);

		System.out.println("Common values1: " + set16);

		// Find common elements using streams
		Set<Integer> commonValues1 = Arrays.stream(array1).boxed()
				.filter(value -> Arrays.stream(array2).anyMatch(val -> val == value)).collect(Collectors.toSet());

		System.out.println("Common values2: " + commonValues1);

		int[] array51 = { 1, 2, 3, 4, 5 };
		int[] array61 = { 4, 5, 6, 7, 8 };
		int[] array71 = { 5, 8, 9, 10 };

		// Convert arrays to sets
		Set<Integer> set5 = Arrays.stream(array51).boxed().collect(Collectors.toSet());
		Set<Integer> set6 = Arrays.stream(array61).boxed().collect(Collectors.toSet());
		Set<Integer> set7 = Arrays.stream(array71).boxed().collect(Collectors.toSet());

		// Find common values among three sets
		set5.retainAll(set6);
		set5.retainAll(set7);

		System.out.println("Common values3: " + set5);

		// Find common elements among three arrays using streams
		Set<Integer> commonValues4 = Arrays.stream(array51).boxed()
				.filter(value -> Arrays.stream(array61).anyMatch(val -> val == value))
				.filter(value -> Arrays.stream(array71).anyMatch(val -> val == value)).collect(Collectors.toSet());

		System.out.println("Common values4: " + commonValues4);

		int[] arry = new int[] { 1, 3, 5, 2, 4, 7, 9, 6, 8, 10 };

		// Convert the array to a stream and process it
		List<Integer> rearrangedList = IntStream.of(arry).boxed() // Convert int to Integer
				.collect(Collectors.partitioningBy(num1 -> num1 % 2 == 0)) // Partition into even and odd
				.values().stream() // Get the collection of lists
				.flatMap(List::stream) // Flatten the lists into a single stream
				.collect(Collectors.toList()); // Collect into a List
		System.out.println(rearrangedList);
		// Copy the rearranged list back into the original array
		for (int i = 0; i < arry.length; i++) {
			arry[i] = rearrangedList.get(i);
		}

		// Print the rearranged array
		System.out.println(Arrays.toString(arry));

		List<Integer> rearrangedList1 = IntStream.of(arry).boxed() // Convert int to Integer
				.collect(Collectors.partitioningBy(num1 -> num1 % 2 == 0)) // Partition into even and odd
				.entrySet().stream() // Stream of Map.Entry<Boolean, List<Integer>>
				.sorted(Map.Entry.comparingByKey()) // Optional: sort entries by key (false -> true)
				.map(Map.Entry::getValue) // Extract the List<Integer> from each Map.Entry
				.flatMap(List::stream) // Flatten the lists into a single stream
				.collect(Collectors.toList()); // Collect into a List
		System.out.println(rearrangedList1);

		int[] arry1 = { 1, 3, 5, 4, 7, 9, 6, 8 }; // Example array

		// Convert array to Set for quick lookup
		Set<Integer> set17 = Arrays.stream(arry1).boxed().collect(Collectors.toSet());
		List<int[]> numbers17 = List.of(arry1);
		// Find the min and max values in the array
		int min17 = Arrays.stream(arry1).min().orElseThrow(NoSuchElementException::new);
		int max17 = Arrays.stream(arry1).max().orElseThrow(NoSuchElementException::new);

		int count17 = (int) Arrays.stream(arry1).count();
		System.out.println("Count numbers: " + count);
		// Generate full range and filter missing numbers
		List<Integer> missingNumbers17 = IntStream.rangeClosed(min17, max17) // Generate numbers from min to max (inclusive)
				.boxed() // Convert to Stream<Integer>
				.filter(num1 -> !set.contains(num1)) // Filter out numbers present in the set
				.collect(Collectors.toList()); // Collect into a List

		System.out.println("Missing numbers: " + missingNumbers);

		int[] arry2 = { 1, 3, 5, 4, 7, 9, 6, 8 };

		// Find the min and max values in the array
		int min18 = Arrays.stream(arry2).min().orElseThrow(NoSuchElementException::new);
		int max18 = Arrays.stream(arry2).max().orElseThrow(NoSuchElementException::new);

		// Convert array to an ArrayList for lookup
		List<Integer> numbersList = Arrays.stream(arry2).boxed().distinct().collect(Collectors.toList());

		// Generate numbers from min to max (inclusive) and find missing numbers
		List<Integer> missingNumbers1 = IntStream.rangeClosed(min18, max18) // Generate numbers from min to max
				.boxed() // Convert to Stream<Integer>
				.filter(num1 -> !numbersList.contains(num1)) // Check if number is missing
				.collect(Collectors.toList()); // Collect into a List

		System.out.println("Missing numbers: " + missingNumbers1);

		int[] numbers19 = { 1, 2, 3, 4, 5, 2, 6, 3, 7 };

		Set<Integer> seen = new HashSet<>();
		Set<Integer> duplicates = new HashSet<>();

		for (int number : numbers19) {
			if (!seen.add(number)) {
				duplicates.add(number);
			}
		}

		System.out.println("Duplicates1: " + duplicates);

		Map<Integer, Long> countMap = Arrays.stream(numbers).boxed() // Convert int to Integer
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Set<Integer> duplicates1 = countMap.entrySet().stream().filter(entry1 -> entry1.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toSet());

		System.out.println("Duplicates2: " + duplicates1);

		Map<Integer, Long> countMap3 = Arrays.stream(numbers).boxed() // Convert int to Integer
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Integer> duplicates3 = countMap3.entrySet().stream().filter(entry1 -> entry1.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println("Duplicates3: " + duplicates3);

		String[] strings = { "apple", "banana", "orange", "apple", "banana", "grape" };

		Set<String> seen2 = new HashSet<>();
		Set<String> duplicates2 = new HashSet<>();

		for (String str1 : strings) {
			if (!seen2.add(str1)) {
				duplicates2.add(str1);
			}
		}

		System.out.println("Duplicates4: " + duplicates2);

		Map<String, Long> countMap2 = Arrays.stream(strings)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Set<String> duplicates4 = countMap2.entrySet().stream().filter(entry1 -> entry1.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toSet());

		System.out.println("Duplicates5: " + duplicates4);

		Map<String, Long> countMap4 = Arrays.stream(strings)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Set<String> duplicates5 = countMap4.entrySet().stream().filter(entry1 -> entry1.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toSet());

		System.out.println("Duplicates6: " + duplicates5);

		int[] arry21 = { 1, 3, 5, 7, 9, 6, 8, 10 };

		// Find the min and max values in the array
//			        int min1 = Arrays.stream(arry2).min().orElseThrow(NoSuchElementException::new);
//			        System.out.println("min1 numbers: " + min1);
//			        int max1 = Arrays.stream(arry2).max().orElseThrow(NoSuchElementException::new);
//			        System.out.println("max1 numbers: " + max1);

		// Convert array to a Set for uniqueness and lookup
		Set<Integer> numbersSet = Arrays.stream(arry21).boxed().collect(Collectors.toSet());

		// Generate numbers from min to max (inclusive) and find missing numbers
		List<Integer> missingNumbers11 = IntStream
				.rangeClosed(Arrays.stream(arry21).min().getAsInt(), Arrays.stream(arry21).max().getAsInt()) // Generate
																											// numbers
																											// from min
																											// to max
				.boxed() // Convert to Stream<Integer>
				.filter(num1 -> !numbersSet.contains(num1)) // Check if number is missing
				.collect(Collectors.toList()); // Collect into a List

		System.out.println("Missing numbers: " + missingNumbers11);

		String original11 = "Hello, World!";
		String reversed11 = new StringBuilder(original11).reverse().toString();
		System.out.println("Reversed String: " + reversed11);
		// ===========================================================
		String original12 = "Hello, World!";
		char[] charArray = original12.toCharArray();
		int left = 0;
		int right = charArray.length - 1;

		while (left < right) {
			char temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;
			left++;
			right--;
		}

		String reversed1 = new String(charArray);
		System.out.println("Reversed String: " + reversed1);

		// ===========================================================

		int[] array13 = { 1, 2, 3, 4, 5 };
		int left1 = 0;
		int right1 = array13.length - 1;

		while (left < right1) {
			int temp = array13[left1];
			array13[left1] = array13[right1];
			array13[right1] = temp;
			left1++;
			right1--;
		}

		System.out.println("Reversed Array: " + Arrays.toString(array13));

		// ===========================================================

		Integer[] array23 = { 1, 2, 3, 4, 5 };
		List<Integer> list14 = Arrays.asList(array23);
		Collections.reverse(list14);

		// Convert list back to array
		array23 = list14.toArray(new Integer[0]);
		System.out.println("Reversed Array: " + Arrays.toString(array23));

		String str4 = "ABC";
		List<String> permutations = new ArrayList<>();
		generatePermutations(str4.toCharArray(), 0, permutations);

		// Print permutations
		permutations.forEach(System.out::println);
	}

	private static void generatePermutations(char[] str, int index, List<String> permutations) {
		if (index == str.length - 1) {
			permutations.add(new String(str));
		} else {
			for (int i = index; i < str.length; i++) {
				swap(str, index, i);
				generatePermutations(str, index + 1, permutations);
				swap(str, index, i); // backtrack
			}
		}
	}

	private static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

}
```
```
Array initialized: 
1 2 3 4 5 Reversed array: 
5 4 3 2 1 Arrays equal: true
Array: [1, 2, 3, 4, 5]
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]
Concatenated array: [1, 2, 3, 4, 5, 6]
First half: [1, 2, 3]
Second half: [4, 5, 6]
Joined array: Apple, Banana, Cherry
Resized array: [1, 2, 3, 0, 0]
Array after removal: [1, 2, 4, 5]
Array without duplicates: [1, 2, 3, 4, 5]
Union of arrays: [1, 2, 3, 4, 5]
Intersection of arrays: [2, 3]
Array contains 3: true
Top 3 items: [30, 40, 50]
Sum: 15
Average: 3.0
Max: 5
Min: 1
Sorted array: [1, 2, 3, 5, 8]
Array is sorted: true
Array of Objects: [1, 2, 3]
List: [Apple, Banana, Cherry]
Array: [Apple, Banana, Cherry]
Array: [Apple, Banana, Cherry]
Stream: [Apple, Banana, Cherry]
Array: [Apple, Banana, Cherry]
List: [1, 2, 3]
Original array: [1, 2, 3, 4, 5]
Cloned array: [1, 2, 3, 4, 5]
Original array: [1, 2, 3, 4, 5]
Copied array: [1, 2, 3, 4, 5]
Original array: [[1, 2], [3, 4]]
Deep copied array: [[1, 2], [3, 4]]
Array range: [2, 3, 4]
The missing numbers are: [2, 7]
{orange=1, banana=2, apple=3}
strawberry
[5, 4, 3, 2, 1]
3.46
[1, 2, 3, 4, 5]
Hello world!
c
[kiwi]
{false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8]}
59
64
125
216
343
2
Malayalam
280
Students grouped by Department {Electronics Engineering=[Student [id=7, firstName=Arun, lastName=Vittal, age=26, gender=Male, departmantName=Electronics Engineering, joinedYear=2014, city=Karnataka, rank=324]], Instrumentation Engineering=[Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12]], Biotech Engineering=[Student [id=10, firstName=Satyam, lastName=Pandey, age=26, gender=Male, departmantName=Biotech Engineering, joinedYear=2017, city=Mumbai, rank=98]], Mechanical Engineering=[Student [id=1, firstName=Aditya, lastName=Mall, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Mumbai, rank=122], Student [id=4, firstName=Satish, lastName=Malaghan, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Kerala, rank=26], Student [id=6, firstName=Chetan, lastName=Star, age=24, gender=Male, departmantName=Mechanical Engineering, joinedYear=2023, city=Karnataka, rank=90]], Computer Engineering=[Student [id=2, firstName=Pulkith, lastName=Singh, age=26, gender=Male, departmantName=Computer Engineering, joinedYear=2018, city=Delhi, rank=67], Student [id=3, firstName=Ankita, lastName=Patil, age=25, gender=Female, departmantName=Computer Engineering, joinedYear=2019, city=Kerala, rank=164], Student [id=8, firstName=Nam, lastName=Dev, age=31, gender=Male, departmantName=Computer Engineering, joinedYear=2014, city=Karnataka, rank=433], Student [id=9, firstName=Sonu, lastName=Shankar, age=27, gender=Female, departmantName=Computer Engineering, joinedYear=2018, city=Karnataka, rank=7]]}
Count of Students in each Department{Electronics Engineering=1, Instrumentation Engineering=1, Biotech Engineering=1, Mechanical Engineering=3, Computer Engineering=4}
Deaprtment Names [Mechanical Engineering, Computer Engineering, Instrumentation Engineering, Electronics Engineering, Biotech Engineering]
List of Students whose Age is leass than 25 [Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12], Student [id=6, firstName=Chetan, lastName=Star, age=24, gender=Male, departmantName=Mechanical Engineering, joinedYear=2023, city=Karnataka, rank=90]]
Max age of students 31
Average age of Male and Female students {Female=26.0, Male=27.0}
Minimum age of student is 23
Young student is Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12]
Senior Female student is 27
Senior Female student is Student [id=9, firstName=Sonu, lastName=Shankar, age=27, gender=Female, departmantName=Computer Engineering, joinedYear=2018, city=Karnataka, rank=7]
students whose rank is between 50 and 100 {orange=1, banana=2, apple=3}
Department having maximum number of students Computer Engineering=4
[Student [id=1, firstName=Aditya, lastName=Mall, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Mumbai, rank=122], Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12], Student [id=10, firstName=Satyam, lastName=Pandey, age=26, gender=Male, departmantName=Biotech Engineering, joinedYear=2017, city=Mumbai, rank=98]]
Total count 10
Average ranks {Electronics Engineering=324.0, Instrumentation Engineering=12.0, Biotech Engineering=98.0, Mechanical Engineering=79.33333333333333, Computer Engineering=167.75}
{Electronics Engineering=Optional[Student [id=7, firstName=Arun, lastName=Vittal, age=26, gender=Male, departmantName=Electronics Engineering, joinedYear=2014, city=Karnataka, rank=324]], Instrumentation Engineering=Optional[Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12]], Biotech Engineering=Optional[Student [id=10, firstName=Satyam, lastName=Pandey, age=26, gender=Male, departmantName=Biotech Engineering, joinedYear=2017, city=Mumbai, rank=98]], Mechanical Engineering=Optional[Student [id=4, firstName=Satish, lastName=Malaghan, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Kerala, rank=26]], Computer Engineering=Optional[Student [id=9, firstName=Sonu, lastName=Shankar, age=27, gender=Female, departmantName=Computer Engineering, joinedYear=2018, city=Karnataka, rank=7]]}
[Student [id=9, firstName=Sonu, lastName=Shankar, age=27, gender=Female, departmantName=Computer Engineering, joinedYear=2018, city=Karnataka, rank=7], Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12], Student [id=4, firstName=Satish, lastName=Malaghan, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Kerala, rank=26], Student [id=2, firstName=Pulkith, lastName=Singh, age=26, gender=Male, departmantName=Computer Engineering, joinedYear=2018, city=Delhi, rank=67], Student [id=6, firstName=Chetan, lastName=Star, age=24, gender=Male, departmantName=Mechanical Engineering, joinedYear=2023, city=Karnataka, rank=90], Student [id=10, firstName=Satyam, lastName=Pandey, age=26, gender=Male, departmantName=Biotech Engineering, joinedYear=2017, city=Mumbai, rank=98], Student [id=1, firstName=Aditya, lastName=Mall, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Mumbai, rank=122], Student [id=3, firstName=Ankita, lastName=Patil, age=25, gender=Female, departmantName=Computer Engineering, joinedYear=2019, city=Kerala, rank=164], Student [id=7, firstName=Arun, lastName=Vittal, age=26, gender=Male, departmantName=Electronics Engineering, joinedYear=2014, city=Karnataka, rank=324], Student [id=8, firstName=Nam, lastName=Dev, age=31, gender=Male, departmantName=Computer Engineering, joinedYear=2014, city=Karnataka, rank=433]]
Student Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12]
{Electronics Engineering=[Student [id=7, firstName=Arun, lastName=Vittal, age=26, gender=Male, departmantName=Electronics Engineering, joinedYear=2014, city=Karnataka, rank=324]], Instrumentation Engineering=[Student [id=5, firstName=Darshan, lastName=Mukd, age=23, gender=Male, departmantName=Instrumentation Engineering, joinedYear=2022, city=Mumbai, rank=12]], Biotech Engineering=[Student [id=10, firstName=Satyam, lastName=Pandey, age=26, gender=Male, departmantName=Biotech Engineering, joinedYear=2017, city=Mumbai, rank=98]], Mechanical Engineering=[Student [id=4, firstName=Satish, lastName=Malaghan, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Kerala, rank=26], Student [id=6, firstName=Chetan, lastName=Star, age=24, gender=Male, departmantName=Mechanical Engineering, joinedYear=2023, city=Karnataka, rank=90], Student [id=1, firstName=Aditya, lastName=Mall, age=30, gender=Male, departmantName=Mechanical Engineering, joinedYear=2014, city=Mumbai, rank=122]], Computer Engineering=[Student [id=9, firstName=Sonu, lastName=Shankar, age=27, gender=Female, departmantName=Computer Engineering, joinedYear=2018, city=Karnataka, rank=7], Student [id=2, firstName=Pulkith, lastName=Singh, age=26, gender=Male, departmantName=Computer Engineering, joinedYear=2018, city=Delhi, rank=67], Student [id=3, firstName=Ankita, lastName=Patil, age=25, gender=Female, departmantName=Computer Engineering, joinedYear=2019, city=Kerala, rank=164], Student [id=8, firstName=Nam, lastName=Dev, age=31, gender=Male, departmantName=Computer Engineering, joinedYear=2014, city=Karnataka, rank=433]]}
output:{p=1, a=4, r=1, d=1, e=3, v=2, I=1, j=1, l=1, m=1, o=1}
Words with more than 5 characters: [banana, cherry, elderberry]
Words with 5 or fewer characters: [apple, date]
Even numbers: [2, 4, 6, 8, 10]
Odd numbers: [1, 3, 5, 7, 9]
Even numbers: [2, 4, 6, 8, 10]
Odd numbers: [1, 3, 5, 7, 9]
[a, b, c, d]
[a, b, c]
outpumap1: {1=a}
Output map5: {1=e}
[a, b, c]
{1=[a], 2=[bb, dd], 3=[ccc]}
{false=[a, bb, dd], true=[ccc]}
4
IntSummaryStatistics{count=4, sum=10, min=1, average=2.500000, max=4}
abcd
[1, 2, 3, 4]
[h, e, l, l, o, w, o, r, l, d]
[a, b, c, d, e]
[apple, banana, cherry]
[banana, apple, cherry]
outpumap2: {5=apple, 6=banana}
[apple, banana, cherry]
{4=[date], 5=[apple], 6=[banana, cherry]}
{false=[apple, date], true=[banana, cherry]}
4
IntSummaryStatistics{count=4, sum=21, min=4, average=5.250000, max=6}
applebananacherrydate
[5, 6, 6, 4]
[a, p, p, l, e, b, a, n, a, n, a, c, h, e, r, r, y]
[apple, banana, cherry, date]
Common values1: [1, 2, 3, 4, 5]
Common values2: [1, 2, 3]
Common values3: [5]
Common values4: [5]
[1, 3, 5, 7, 9, 2, 4, 6, 8, 10]
[1, 3, 5, 7, 9, 2, 4, 6, 8, 10]
[1, 3, 5, 7, 9, 2, 4, 6, 8, 10]
Count numbers: 2
Missing numbers: [1, 3, 4, 5, 6, 8, 9, 10]
Missing numbers: [2]
Duplicates1: [2, 3]
Duplicates2: []
Duplicates3: []
Duplicates4: [banana, apple]
Duplicates5: [banana, apple]
Duplicates6: [banana, apple]
Missing numbers: [2, 4]
Reversed String: !dlroW ,olleH
Reversed String: !dlroW ,olleH
Reversed Array: [1, 2, 3, 4, 5]
Reversed Array: [5, 4, 3, 2, 1]
ABC
ACB
BAC
BCA
CBA
CAB
```
