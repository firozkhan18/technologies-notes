# com\java\eight8\newfeatures\lambda\ListOfDishes.java

```java
package com.java.eight8.newfeatures.lambda;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOfDishes {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		//  Get a stream from the list of dishes by calling the stream method on menu.			
		//	The data source is the list of dishes (the menu) and it provides a sequence of elements to the stream.		
		//	Next, you apply a series of data processing operations on the stream: filter, map, limit, and collect. 
		//	All these operations except collect return another stream so they can be connected to form a pipeline, which can be viewed as a query on the source.
        //	Finally, the collect operation starts processing the pipeline to return a result 
		//	(it’s different because it returns something other than a stream—here, a List). 
		//	No result is produced, and indeed no element from menu is even selected, until collect is invoked. 
		//	You can think of it as if the method invocations in the chain are queued up until collect is called.
		
		List<String> threeHighCaloricDishesnames = menu.stream()//  Get a stream from menu (the list of dishes).
				.filter(d -> d.getCalories() > 300) //Create a pipeline of operations: first filter high-calories dishes.
				.map(Dish::getName) // Get the names of the dishes.
				.limit(3)//Select only the first three.
				.collect(toList()); //Store the results in another List.
		System.out.println(threeHighCaloricDishesnames);
		
		List<String> title = Arrays.asList("Java8","In","Action");
		Stream<String> s = title.stream();
		s.forEach(System.out::println);//Print each word in the title
		//s.forEach(System.out::println);//java.lang.IllegalStateException: Stream has already been operated upon or closed.
	
		//Collections: external iteration with a for-each loop
		List<String> names = new ArrayList<>();
		for(Dish d: menu) {//explicitly iterate the list of menu sequentially.
			names.add(d.getName());//Extract the names and add it to an accumulator.
		}
		System.out.println(names);
		
		//Collections: external iteration using an iterator behind the scenes.
		Iterator<Dish> itr=menu.iterator();
		while(itr.hasNext()) { //Iterating Explicitly
			Dish d = itr.next();
			names.add(d.getName());
		}
		System.out.println(names);
		
		//Streams: internal iteration
		List<String> names1 =menu.stream().map(Dish::getName)
		.collect(toList());
		System.out.println(names1);
		
		//Intermediate operations
		List<String> names2 = menu.stream()//  Get a stream from menu (the list of dishes).
				.filter(d ->  //Create a pipeline of operations: first filter high-calories dishes.
						{
							System.out.println("Filtering "+ d.getName());
							return d.getCalories() > 300;
						})
				.map(d-> // Get the names of the dishes.
						{
							System.out.println("Mapping "+ d.getName());
							return d.getName();
						})
				.limit(3)//Select only the first three.
				.collect(toList()); //Store the results in another List.
		System.out.println(names2);
		
		//Terminal operations
		long count = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.distinct()
				.limit(3)
				.count();
		System.out.println(count);
		
		List<Dish> vegetarianDishes = new ArrayList<>();
		for(Dish d: menu){
			if(d.isVegetarian()){
				vegetarianDishes.add(d);
			}
		}
		System.out.println(vegetarianDishes);
		List<Dish> vegetarianDishes1 = menu.stream()
				.filter(Dish::isVegetarian)//A method reference to check if a dish is Vegetarian friendly.
				.collect(toList());
		System.out.println(vegetarianDishes1);
		
		//Filtering unique elements in a stream
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
					.filter(i -> i % 2 == 0)
					.distinct()
		.forEach(System.out::println);
		
		//Truncating a stream
		List<Dish> dishes = menu.stream()
							.filter(d -> d.getCalories() > 300)
							.limit(3)
							.collect(toList());
		System.out.println(dishes);
		
		//Skipping elements in a stream
		List<Dish> dishes1 = menu.stream()
							.filter(d -> d.getCalories() > 300)
							.skip(2)
							.collect(toList());
		System.out.println(dishes1);
		
		//How would you use streams to filter the first two meat dishes?
		//You can solve this problem by composing the methods filter and limit together and using
		//collect(toList()) to convert the stream into a list as follows:
		List<Dish> dishes3 = menu.stream()
							.filter(d -> d.getType() == Dish.Type.MEAT)
							.limit(2)
							.collect(toList());
		System.out.println(dishes3);	
	
		//Applying a function to each element of a stream
		
		//Streams support the method map, which takes a function as argument. The function is applied
		//to each element, mapping it into a new element (the word mapping is used because it has a
		//meaning similar to transforming but with the nuance of “creating a new version of” rather than
		//“modifying”). For example, in the following code you pass a method reference Dish::getName to
		//the map method to extract the names of the dishes in the stream:
			
		List<String> dishNames = menu.stream()
								.map(Dish::getName)
								.collect(toList());
		//Because the method getName returns a String, the stream outputted by the map method is of
		//type Stream<String>.
		System.out.println(dishNames);
		
		//The function to apply should take a word and return its length. You can solve this
		//problem as follows by passing a method reference String::length to map:
		
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream()
									.map(String::length)
									.collect(toList());
		System.out.println(wordLengths);
		
		//What if you wanted 	to find out the length of the name of each dish? 
		//You could do this by chaining another map as follows:
		List<Integer> dishNameLengths = menu.stream()
										.map(Dish::getName)
										.map(String::length)
										.collect(toList());
		System.out.println(dishNameLengths);
		
		//Flattening streams
		//how could you return a list of all the unique characters for a list of words? 
		//For example, given the list of words ["Hello", "World"] you’d like to return the list ["H", "e", "l", "o", "W", "r", "d"].
		//You might think that this is easy, that you can just map each word into a list of characters and then call distinct to filter duplicate characters. 
		
		//A first go could be like this:
		words.stream()
			.map(word -> word.split(""))
			.distinct()
			.collect(toList());
		System.out.println(words);
//		The problem with this approach is that the lambda passed to the map method returns a String[]
//		(an array of String) for each word. So the stream returned by the map method is actually of type
//		Stream<String[]>. What you really want is Stream<String> to represent a stream of characters.
		words.stream()
			.map(word -> word.split(""))
			.map(Arrays::stream)
			.distinct()
			.collect(toList());
		System.out.println(words);
//		The current solution still doesn’t work! This is because you now end up with a list of streams
//		(more precisely, Stream<Stream<String>>)! Indeed, you first convert each word into an array
//		of its individual letters and then make each array into a separate stream.
		//Using flatMap
		//You can fix this problem by using flatMap as follows:
		List<String> uniqueCharacter = words.stream()
										.map(word -> word.split(""))
										.flatMap(Arrays::stream)
										.distinct()
										.collect(toList());
		System.out.println(uniqueCharacter);
		
	//	Using the flatMap method has the effect of mapping each array not with a stream but with the
	//	contents of that stream. All the separate streams that were generated when using
	//	map(Arrays::stream) get amalgamated—flattened into a single stream.
		
		
	//	Given a list of numbers, how would you return a list of the square of each number? For
	//	example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
		
	//	You can solve this problem by using map with a lambda that takes a number and returns the
	//	square of the number:
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers1.stream()
								.map(n -> n * n)
								.collect(toList());
		System.out.println(squares);
		
	//	Given two lists of numbers, how would you return all pairs of numbers? For example, given a
	//	list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
	//	simplicity, you can represent a pair as an array with two elements.
		
	//	You could use two maps to iterate on the two lists and generate the pairs. But this would return
	//	a Stream<Stream<Integer[]>>. What you need to do is flatten the generated streams to result in
	//	a Stream<Integer[]>. This is what flatMap is for:
		
		List<Integer> numbers2 = Arrays.asList(1, 2, 3);
		List<Integer> numbers3 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers2.stream()
							.flatMap(i -> numbers3.stream()
							.map(j -> new int[]{i, j}))
							.collect(toList());
		
		System.out.println(pairs);
		
	//	How would you extend the previous example to return only pairs whose sum is divisible by 3?
	//	For example, (2, 4) and (3, 3) are valid.
		
	//	You saw earlier that filter can be used with a predicate to filter elements from a stream. Because
	//	after the flatMap operation you have a stream of int[] that represent a pair, you just need a
	//	predicate to check to see if the sum is divisible by 3:
		
		List<Integer> numbers4 = Arrays.asList(1, 2, 3);
		List<Integer> numbers5 = Arrays.asList(3, 4);
		List<int[]> pairs2 = numbers4.stream()
							.flatMap(i ->numbers5.stream()
							.filter(j -> (i + j) % 3 == 0)
							.map(j -> new int[]{i, j}))
							.collect(toList());
		
		System.out.println(pairs2);
		
	//	Checking to see if a predicate matches all elements
	//	The allMatch method works similarly to anyMatch but will check to see if all the elements of the
	//	stream match the given predicate. For example, you can use it to find out whether the menu is
	//	healthy (that is, all dishes are below 1000 calories):
		
		boolean isHealthy = menu.stream()
		.allMatch(d -> d.getCalories() < 1000);
		
		System.out.println(isHealthy);
		
		//noneMatch
	//	The opposite of allMatch is noneMatch. It ensures that no elements in the stream match the
	//	given predicate. For example, you could rewrite the previous example as follows using
	//	noneMatch:
		boolean isHealthy1 = menu.stream()
		.noneMatch(d -> d.getCalories() >= 1000);
	//	These three operations, anyMatch, allMatch, and noneMatch, make use of what we call
	//	short-circuiting, a stream version of the familiar Java short-circuiting && and || operators.
		System.out.println(isHealthy1);
		
	//	Finding an element
	//	The findAny method returns an arbitrary element of the current stream. It can be used in
	//	conjunction with other stream operations. For example, you may wish to find a dish that’s
	//	vegetarian. You can combine the filter method and findAny to express this query:
		
		Optional<Dish> dish = menu.stream()
				.filter(Dish::isVegetarian)
				.findAny();
		System.out.println(dish);
		
	//	Finding the first element
	//	Some streams have an encounter order that specifies the order in which items logically appear
	//	in the stream (for example, a stream generated from a List or from a sorted sequence of data).
	//	For such streams you may wish to find the first element. There’s the findFirst method for this,
	//	which works similarly to findAny. For example, the code that follows, given a list of numbers,
	//	finds the first square that’s divisible by 3:
		
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree =  someNumbers.stream()
														.map(x -> x * x)
														.filter(x -> x % 3 == 0)
														.findFirst(); // 9
		System.out.println(firstSquareDivisibleByThree);
		
	//	When to use findFirst and findAny
	//	You may wonder why we have both findFirst and findAny. The answer is parallelism. Finding
	//	the first element is more constraining in parallel. If you don’t care about which element is
	//	returned, use findAny because it’s less constraining when using parallel streams.
		
	//	Reducing
	//	So far, the terminal operations you’ve seen return a boolean (allMatch and so on), void
	//	(forEach), or an Optional object (findAny and so on). You’ve also been using collect to combine
	//	all elements in a stream into a List.
		
	//	Summing the elements
	//	Before we investigate how to use the reduce method, it helps to first see how you’d sum the
	//	elements of a list of numbers using a for-each loop:
		int sum = 0;
		for (int x : numbers) {
			sum += x;
		}
	//	Each element of numbers is combined iteratively with the addition operator to form a result.
	//	You reduce the list of numbers into one number by repeatedly using addition.
	//	There are two parameters in this code:
	//	The initial value of the sum variable, in this case 0
	//	The operation to combine all the elements of the list, in this case +
		
	//	You can sum all the elements of a stream as follows:
		int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
		
	//	reduce takes two arguments:
	//	An initial value, here 0.
	//	A BinaryOperator<T> to combine two elements and produce a new value; here you use the lambda (a, b) -> a + b.
	//	You could just as easily multiply all the elements by passing a different lambda, (a, b) -> a * b, to
	//	the reduce operation:
		
		int product1 = numbers.stream().reduce(1, (a, b) -> a * b);
		
	//  Using reduce to sum the numbers in a stream
		
	//	Let’s take an in-depth look into how the reduce operation happens to sum a stream of numbers.
	//	First, 0 is used as the first parameter of the lambda (a), and 4 is consumed from the stream and used as the second parameter (b). 
	//	0 + 4 produces 4, and it becomes the new accumulated value.
	//	Then the lambda is called again with the accumulated value and the next element of the stream, 5, which produces the new accumulated value, 9. 
	//	Moving forward, the lambda is called again with the accumulated value and the next element, 3, which produces 12. 
	//	Finally, the lambda is called with 12 and the last element of the stream, 9, which produces the final value, 21.
	//	You can make this code more concise by using a method reference. In Java 8 the Integer class now comes with a static sum method to add two numbers, which is just what you want instead
	//	of repeatedly writing out the same code as lambda:
		
		int sum2 = numbers.stream().reduce(0, Integer::sum);
		
//		No initial value
//		There’s also an overloaded variant of reduce that doesn’t take an initial value, but it returns an
//		Optional object:
		
		Optional<Integer> sum3 = numbers.stream().reduce((a, b) -> (a + b));
		
//		Why does it return an Optional<Integer>? Consider the case when the stream contains no
//		elements. The reduce operation can’t return a sum because it doesn’t have an initial value. This
//		is why the result is wrapped in an Optional object to indicate that the sum may be absent. Now
//		see what else you can do with reduce.
		
//		A reduce operation—calculating the maximum
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		
//		To calculate the minimum, you need to pass Integer.min to the reduce operation instead of
//		Integer.max:
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
//		You could have equally well used the lambda (x,y)->x<y?x:y instead of Integer::min, but the
//		latter is easier to read.
		
//		How would you count the number of dishes in a stream using the map and reduce methods?
		
//		You can solve this problem by mapping each element of a stream into the number 1 and then
//		summing them using reduce! This is equivalent to counting in order the number of elements in
//		the stream.
		
		int count1 = menu.stream()
				.map(d -> 1)
				.reduce(0, (a, b) -> a + b);
		System.out.println(count1);
		
//		The built-in method count to count the number of elements in the stream:
		long count2 = menu.stream().count();
		
		
//		Benefit of the reduce method and parallelism
		
//		The benefit of using reduce compared to the step-by-step iteration summation that you wrote earlier is that the iteration is abstracted using internal iteration, which enables the internal
//		implementation to choose to perform the reduce operation in parallel.
		
//		The iterative summation example involves shared updates to a sum variable, which doesn’t parallelize gracefully. 
		
//		If you add in the needed synchronization, you’ll likely discover that thread contention robs you of all the performance that parallelism was supposed to give you! Parallelizing this computation requires a different approach: partition the input, sum the partitions, and combine the sums.
//		But now the code is starting to look really different. 
		
//		You’ll see what this looks like in chapter 7 using the fork/join framework. But for now it’s important to realize that the mutable
//		accumulator pattern is a dead end for parallelization. You need a new pattern, and this is what reduce provides you. 
//		You’ll also see in chapter 7 that to sum all the elements in parallel using streams, there’s almost no modification to your code: stream() becomes parallelStream():
		int sum4 = numbers.parallelStream().reduce(0, Integer::sum);
		
		//Numeric streams
		//calculate the number of calories in the menu as follows:
		int calories = menu.stream()
						.map(Dish::getCalories)
						.reduce(0, Integer::sum);
		System.out.println(calories);
		
//		int calories1 = menu.stream()
//				.map(Dish::getCalories)
//				.sum();
		
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		System.out.println(intStream);
		Stream<Integer> stream = intStream.boxed();
		System.out.println(stream);
		
//		Optional class, which is a container that indicates the presence or absence of a value. 
//		Optional can be parameterized with reference types such as Integer, String, and so on. 
//		There’s a primitive specialized version of Optional as well for the three primitive stream specializations: 
//		OptionalInt, OptionalDouble, and OptionalLong.
		
		//find the maximal element of an IntStream by calling the max method, which returns an OptionalInt:
		OptionalInt maxCalories = menu.stream()
									.mapToInt(Dish::getCalories)
									.max();
		
		//You can now process the OptionalInt explicitly to define a default value if there’s no maximum:
		int max1 = maxCalories.orElse(1);
		
		//Numeric ranges
		
//		Java 8 introduces two static methods available on IntStream and LongStream to help generate such ranges: 
//		range and rangeClosed. 
//		Both methods take the starting value of the range as the first parameter and the end value of the range as the second parameter. 
//		But range is exclusive, whereas rangeClosed is inclusive.
		
//		Let’s look at an example:
		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 ==0);
		System.out.println(evenNumbers.count());
		//Generating tuples
//		stream.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//		.map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});

		//Generating b values
//		IntStream.rangeClosed(1, 100)
//		.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//		.boxed()
//		.map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
		
//		IntStream.rangeClosed(1, 100)
//		.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//		.mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
		
		//Generating a values		
		Stream<int[]> pythagoreanTriples1 = IntStream.rangeClosed(1, 100).boxed()
											.flatMap(a -> IntStream.rangeClosed(a, 100)
											.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
											.mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)}));
		//System.out.println(pythagoreanTriples1.count());
		pythagoreanTriples1.limit(5).forEach(t ->System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
//		First, you create a numeric range from 1 to 100 to generate
//		values for a. For each given value of a you’re creating a stream of triples. Mapping a value of a to
//		a stream of triples would result in a stream of streams! The flatMap method does the mapping
//		and also flattens all the generated streams of triples into a single stream. As a result you produce
//		a stream of triples. Note also that you change the range of b to be a to 100. There’s no need to
//		start the range at the value 1 because this would create duplicate triples (for example, (3, 4, 5)
//		and (4, 3, 5)).
		
		Stream<double[]> pythagoreanTriples3 = IntStream.rangeClosed(1, 100).boxed()
												.flatMap(a -> IntStream.rangeClosed(a, 100)				
												.mapToObj(b -> new double[]{a, b, (int)Math.sqrt(a * a + b * b)})
												.filter(t -> t[2] % 1 == 0));
		System.out.println(pythagoreanTriples3.count());
		
//		Streams from values
//		You can create a stream with explicit values by using the static method Stream.of, which can
//		take any number of parameters. For example, in the following code you create a stream of
//		strings directly using Stream.of. You then convert the strings to uppercase before printing them
//		one by one:
		Stream<String> stream1 = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream1.map(String::toUpperCase).forEach(System.out::println);
//		You can get an empty stream using the empty method as follows:
		Stream<String> emptyStream = Stream.empty();
		
//		Streams from arrays
		int[] numbers6 = {2,3,5,7,11,13};
		int sum5 = Arrays.stream(numbers6).sum();
		System.out.println(sum5);
		//Iterate
		//This code will produce the Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34....
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
				.limit(10)
				.map(t -> t[0])
				.forEach(System.out::println);
		//Generate
		Stream.generate(Math::random)
				.limit(5)
				.forEach(System.out::println);
		
		//Collecting data with streams
		
//		Finding maximum and minimum in a stream of values
		
//		Suppose you want to find the highest-calorie dish in the menu. You can use two collectors,
//		Collectors.maxBy and Collectors.minBy, to calculate the maximum or minimum value in a stream. 
//		These two collectors take a Comparator as argument to compare the elements in the stream. 
//		Here you create a Comparator comparing dishes based on their calorie content and pass it to Collectors.maxBy:
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish = menu.stream()
										.collect(maxBy(dishCaloriesComparator));
		System.out.println(mostCalorieDish);
		
//		find the total number of calories in your menu list with
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
//		The Collectors.summingLong and Collectors.summingDouble methods behave exactly the same way and can be used where the field to be summed is respectively a long or a double.
		
//		But there’s more to summarization than mere summing; also available is a
//		Collectors .averagingInt, together with its averagingLong and averagingDouble counterparts, to
//		calculate the average of the same set of numeric values:
		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println(avgCalories);
		
		int totalCalories1 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		System.out.println(totalCalories1);
		
		int totalCalories2 = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(totalCalories2);
		
		IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
//		Joining Strings
//		This means you can concatenate the names of all the dishes in the menu as follows:
		String shortMenu = menu.stream().map(Dish::getName).collect(joining());
		System.out.println(shortMenu);
		
//		You’d obtain the same result without needing to map over the original stream with a function
//		extracting the name from each dish:
//		String shortMenu1 = menu.stream().collect(joining());
//		System.out.println(shortMenu1);
		
//		Fortunately, the joining factory method has an overloaded version
//		that accepts a delimiter string between two consecutive elements, so you can obtain a
//		comma-separated list of the dishes’ names with
		String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(shortMenu2);	
		
//		Generalized summarization with reduction
		
//		Gather a list of all the Dishes of a menu stream:
		Stream<Dish> menuStream = menu.stream();
		List<Dish> dishes2 = menuStream.collect(new ToListCollector<Dish>());
		System.out.println(dishes2);
//		Characteristics method
		
//		Characteristics, returns an immutable set of Characteristics, defining the behavior of the collector—in particular providing hints about whether the stream can be reduced
//		in parallel and which optimizations are valid when doing so.
		
//		Characteristics is an enumeration containing three items:
		
//		 UNORDERED—The result of the reduction isn’t affected by the order in which the items in the stream are traversed and accumulated.
//		 CONCURRENT—The accumulator function can be called concurrently from multiple threads, and then this collector can perform a parallel reduction of the stream. 
//		If the collector isn’t also flagged as UNORDERED, it can perform a parallel reduction only when it’s applied to an unordered data source.
//		 IDENTITY_FINISH—This indicates the function returned by the finisher method is the identity one, and its application can be omitted. 
//		In this case, the accumulator object is directly used as the final result of the reduction process. This also implies that it’s safe to do an unchecked cast from the accumulator A to the result R.
		
//		In Java 8, Function.identity() is a static method in the java.util.function package that returns a Function that always returns its input argument.
//		This method is useful when you want to transform or map elements in a stream using a lambda expression but want to achieve a pass-through behavior in certain cases.
//		Here is an example code that demonstrates the usage of Function.identity():
		List<String> names3 = Arrays.asList("Alice", "Bob", "Charlie");

        // Using Function.identity() to perform a pass-through transformation
        List<String> transformedNames = names3.stream()
						                .map(Function.identity())
						                .collect(Collectors.toList());
        // Output the transformedNames
        System.out.println(transformedNames);
        
//      Grouping
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
        
//        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
//					        		.collect(groupingBy(dish -> {
//						        		if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//						        		else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//						        		else return CaloricLevel.FAT;
//					        		}));
        //Collecting data in subgroups
        
//        conjunction with groupingBy
        Map<Dish.Type, Long> typesCount = menu.stream()
        		.collect(groupingBy(Dish::getType, counting()));
        
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
        		.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
        		.collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
        		menu.stream().collect(
	        		groupingBy(Dish::getType, mapping(dish -> { 
	        			if (dish.getCalories() <= 400) return CaloricLevel.DIET;
	        			else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
	        			else return CaloricLevel.FAT; },
	        		toSet() )));
        
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType1 =
        		menu.stream().collect(
        		groupingBy(Dish::getType, mapping( dish -> { 
        				if (dish.getCalories() <= 400) return CaloricLevel.DIET;
		        		else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
		        		else return CaloricLevel.FAT; },
		        toCollection(HashSet::new) )));
        
        //Partitioning
        
       // List<Dish> vegetarianDishes = partitionedMenu.get(true);
        
        List<Dish> vegetarianDishes1 = menu.stream().filter(Dish::isVegetarian).collect(toList());
//        Advantages of partitioning
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
        		menu.stream().collect(
        		partitioningBy(Dish::isVegetarian,
        		collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
	}
}
```
