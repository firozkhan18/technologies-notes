# com\java\eight8\newfeatures\collection\StudentClass.java

```java
package com.java.eight8.newfeatures.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentClass {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Paul", 11, "Economics", 78.9));
		studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
		studentList.add(new Student("Harish", 13, "History", 83.7));
		studentList.add(new Student("Xiano", 14, "Literature", 71.5));
		studentList.add(new Student("Soumya", 15, "Economics", 77.5));
		studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
		studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
		studentList.add(new Student("Mitshu", 18, "History", 73.5));
		studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
		studentList.add(new Student("Harry", 20, "History", 71.9));

		// 3.1) Collectors.toList() :
		// It returns a Collector which collects all input elements into a new List.
		// Example : Collecting top 3 performing students into List

		List<Student> top3Students = studentList.stream()
				.sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3)
				.collect(Collectors.toList());
		System.out.println(top3Students);

		// 3.2) Collectors.toSet() :
		// It returns a Collector which collects all input elements into a new Set.
		// Example : Collecting subjects offered into Set.

		Set<String> subjects = studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
		System.out.println(subjects);

		// 3.3) Collectors.toMap() :
		// This method returns a Collector which collects input elements into a Map
		// whose keys and values are the result of applying mapping functions to input
		// elements.
		// Example : Collecting name and percentage of each student into a Map

		Map<String, Double> namePercentageMap = studentList.stream()
				.collect(Collectors.toMap(Student::getName, Student::getPercentage));
		System.out.println(namePercentageMap);

		// 3.4) Collectors.toCollection() :
		// This method returns a Collector which collects all input elements into a new
		// Collection.
		// Example : Collecting first 3 students into LinkedList

		LinkedList<Student> studentLinkedList = studentList.stream().limit(3)
				.collect(Collectors.toCollection(LinkedList::new));
		System.out.println(studentLinkedList);

		// 3.5) Collectors.joining() :
		// This method returns a Collector which concatenates input elements separated
		// by the specified delimiter.
		// Example : Collecting the names of all students joined as a string

		String namesJoined = studentList.stream().map(Student::getName).collect(Collectors.joining(", "));
		System.out.println(namesJoined);

		// 3.6) Collectors.counting() :
		// It returns a Collector that counts number of input elements.
		// Example : Counting number of students.

		Long studentCount = studentList.stream().collect(Collectors.counting());
		System.out.println(studentCount);

		// 3.7) Collectors.maxBy() :
		// This method returns a Collector that collects largest element in a stream
		// according to supplied Comparator.
		// Example : Collecting highest percentage.

		Optional<Double> highPercentage = studentList.stream().map(Student::getPercentage)
				.collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println(highPercentage);

		// 3.8) Collectors.minBy() :
		// This method returns a Collector which collects smallest element in a stream
		// according to supplied Comparator.
		// Example : Collecting lowest percentage.

		Optional<Double> lowPercentage = studentList.stream().map(Student::getPercentage)
				.collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(lowPercentage);

		// 3.9) summingInt(), summingLong(), summingDouble()
		// These methods returns a Collector which collects sum of all input elements.
		// Example : Collecting sum of percentages

		Double sumOfPercentages = studentList.stream().collect(Collectors.summingDouble(Student::getPercentage));
		System.out.println(sumOfPercentages);

		// 3.10) averagingInt(), averagingLong(), averagingDouble()
		// These methods return a Collector which collects average of input elements.
		// Example : Collecting average percentage

		Double averagePercentage = studentList.stream().collect(Collectors.averagingDouble(Student::getPercentage));
		System.out.println(averagePercentage);

		// 3.11) summarizingInt(), summarizingLong(), summarizingDouble()
		// These methods return a special class called Int/Long/ DoubleSummaryStatistics
		// which contain statistical information like sum, max, min, average etc of
		// input elements.
		// Example : Extracting highest, lowest and average of percentage of students

		DoubleSummaryStatistics studentStats = studentList.stream()
				.collect(Collectors.summarizingDouble(Student::getPercentage));
		System.out.println("Highest Percentage : " + studentStats.getMax());
		System.out.println("Lowest Percentage : " + studentStats.getMin());
		System.out.println("Average Percentage : " + studentStats.getAverage());

		// 3.12) Collectors.groupingBy() :
		// This method groups the input elements according supplied classifier and
		// returns the results in a Map.
		// Example : Grouping the students by subject

		Map<String, List<Student>> studentsGroupedBySubject = studentList.stream()
				.collect(Collectors.groupingBy(Student::getSubject));
		System.out.println(studentsGroupedBySubject);

		// 3.13) Collectors.partitioningBy() :
		// This method partitions the input elements according to supplied Predicate and
		// returns a Map<Boolean, List<T>>. Under the true key, you will find elements
		// which match given Predicate and under the false key, you will find the
		// elements which doesn’t match given Predicate.
		// Example : Partitioning the students who got above 80.0% from who don’t.

		Map<Boolean, List<Student>> studentspartionedByPercentage = studentList.stream()
				.collect(Collectors.partitioningBy(student -> student.getPercentage() > 80.0));
		System.out.println(studentspartionedByPercentage);

		// 3.14) Collectors.collectingAndThen() :
		// This is a special method which lets you to perform one more action on the
		// result after collecting the result.
		// Example : Collecting first three students into List and making it
		// unmodifiable

		List<Student> first3Students = studentList.stream().limit(3)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(first3Students);
	}
}
```
