# Java Stream

A Stream in Java can be defined as a sequence of elements from a source, such as arrays, List, Set or any other collection.

Streams are lazily operated, opposite to collections that must store all the values before it starts processing. Stream is conceptually a pipeline, in which elements are computed on demand.

This page lists down the related to Stream API and its related concepts.

<details>
<summary><b>1. Stream Basics</b></summary>
  
<details><summary><b>1.1 Introduction to Streams API</b></summary>

# Java Stream API

A Stream in Java can be defined as a sequence of elements from a source. The source of elements here refers to a Collection or Array that provides data to the Stream.

Java streams are designed in such a way that most of the stream operations (called intermediate operations) return a Stream. This helps to create a chain of stream operations. This is called a stream pipeline.
Java streams also support the aggregate or terminal operations on the elements. The aggregate operations are operations that allow us to express common manipulations on stream elements quickly and clearly, for example, finding the max or min element, finding the first element matching giving criteria, and so on.
Not that a stream maintains the same ordering of the elements as the ordering in the stream source.
### 1. What is a Stream?
All of us have watched online videos on YouTube. When we start watching a video, a small portion of the video file is first loaded into our computer and starts playing. we don’t need to download the complete video before we start watching it. This is called video streaming. At a very high level, we can think of the small portions of the video file as a stream and the whole video as a Collection.

At the granular level, the difference between a Collection and a Stream is when the things are computed. A Collection is an in-memory data structure that holds all the data structure’s values. Every element in the Collection has to be computed before it can be added to the Collection. While a Stream is conceptually a pipeline in which elements are computed on demand.
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Using a Stream to filter even numbers and then double them
List<Integer> evenNumber = numbers.stream()
    .filter(n -> n % 2 == 0)   // Filter even numbers
    .toList(); // Collect the results into a new list

System.out.println("Even Numbers List: " + evenNumber); // [2, 4, 6, 8, 10]
```
This concept gives rise to significant programming benefits. The idea is that a user will extract only the values they require from a Stream, and these elements are produced invisibly to the user, as and when required. This is a form of a producer-consumer relationship.

In Java, java.util.Stream interface represents a stream on which one or more operations can be performed.

Stream operations are either intermediate or terminal. The terminal operations return a result of a certain type, and intermediate operations return the stream itself so we can chain multiple methods in a row to perform the operation in multiple steps.
Streams are created on a source, e.g. a java.util.Collection like List or Set. The Map is not supported directly, we can create a stream of map keys, values or entries.
Stream operations can either be executed sequentially or in parallel. when performed parallelly, it is called a parallel stream.
Based on the above points, we can say that a Stream is:

Designed for lambdas or functional programming
Not a data structure to store objects
Do not support indexed access
Can easily be aggregated as arrays or lists
Lazy access supported
Parallelizable
### 2. Creating Streams
The given below ways are the most popular different ways to build streams from collections.

#### 2.1. Stream.of()
In the given example, we are creating a stream of a fixed number of integers.
```java
Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
stream.forEach(p -> System.out.println(p));
```
#### 2.2. Stream.of(array)
In the given example, we are creating a stream from the array. The elements in the stream are taken from the array.
```java
Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
stream.forEach(p -> System.out.println(p));
```
#### 2.3. List.stream()
In the given example, we are creating a stream from the List. The elements in the stream are taken from the List.
```java
List<Integer> list = new ArrayList<Integer>();

for(int i = 1; i< 10; i++){
      list.add(i);
}

Stream<Integer> stream = list.stream();
stream.forEach(p -> System.out.println(p));
```
#### 2.4. Stream.generate() or Stream.iterate()
In the given example, we are creating a stream from generated elements. This will produce a stream of 20 random numbers. We have restricted the elements count using limit() function.
```java
Stream<Integer> randomNumbers = Stream
      .generate(() -> (new Random()).nextInt(100));

randomNumbers.limit(20).forEach(System.out::println);
```
#### 2.5. Stream of String chars or tokens
In the given example, first, we create a stream from the characters of a given string. In the second part, we are creating the stream of tokens received from splitting from a string.
```java
IntStream stream = "12345_abcdefg".chars();
stream.forEach(p -> System.out.println(p));

//OR

Stream<String> stream = Stream.of("A$B$C".split("\\$"));
stream.forEach(p -> System.out.println(p));
```
There are some more ways also such as using Stream.Buider or using intermediate operations. We will learn about them in separate posts from time to time.

### 3. Stream Collectors
After performing the intermediate operations on elements in the stream, we can collect the processed elements again into a Collection using the stream Collector methods.

#### 3.1. Collect Stream Elements to a List
In the given example, first, we create a stream on integers 1 to 10. Then we process the stream elements to find all even numbers.

At last, we are collecting all even numbers into a List.
```java
List<Integer> list = new ArrayList<Integer>();
 
for(int i = 1; i< 10; i++){
      list.add(i);
}

Stream<Integer> stream = list.stream();
List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0)
                                    .collect(Collectors.toList());
System.out.print(evenNumbersList);
```
#### 3.2. Collect Stream Elements to an Array
The given example is similar to the first example shown above. The only difference is that we are collecting even numbers in an Array.
```java
List<Integer> list = new ArrayList<Integer>();
 
for(int i = 1; i< 10; i++){
      list.add(i);
}

Stream<Integer> stream = list.stream();
Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
System.out.print(evenNumbersArr);
```
There are plenty of other ways also to collect stream into a Set, Map or into multiple ways. Just go through Collectors class and try to keep them in mind.

### 4. Stream Operations
Stream abstraction has a long list of useful functions. Let us look at a few of them.

Before moving ahead, let us build a List of strings beforehand. We will build our examples on this list so that it is easy to relate and understand.
```java
List<String> memberNames = new ArrayList<>();
memberNames.add("Amitabh");
memberNames.add("Shekhar");
memberNames.add("Aman");
memberNames.add("Rahul");
memberNames.add("Shahrukh");
memberNames.add("Salman");
memberNames.add("Yana");
memberNames.add("Lokesh");
```
These core methods have been divided into 2 parts given below:

#### 4.1. Intermediate Operations
Intermediate operations return the stream itself so you can chain multiple methods calls in a row. Let’s learn important ones.

#### 4.1.1. Stream.filter()
The filter() method accepts a Predicate to filter all elements of the stream. This operation is intermediate, enabling us to call another stream operation (e.g. forEach()) on the result.
```java
memberNames.stream().filter((s) -> s.startsWith("A"))
                    .forEach(System.out::println);
```
Program Output:
```
Amitabh
Aman
```
#### 4.1.2. Stream.map()
The map() intermediate operation converts each element in the stream into another object via the given function.

The following example converts each string into an UPPERCASE string. But we can use map() to transform an object into another type as well.
```java
memberNames.stream().filter((s) -> s.startsWith("A"))
                  .map(String::toUpperCase)
                  .forEach(System.out::println);
```
Program Output:
```
AMITABH
AMAN
```
#### 4.1.2. Stream.sorted()
The sorted() method is an intermediate operation that returns a sorted view of the stream. The elements in the stream are sorted in natural order unless we pass a custom Comparator.
```java
memberNames.stream().sorted()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
```
Program Output:
```
AMAN
AMITABH
LOKESH
RAHUL
SALMAN
SHAHRUKH
SHEKHAR
YANA
```
Please note that the sorted() method only creates a sorted view of the stream without manipulating the ordering of the source Collection. In this example, the ordering of string in the memberNames is untouched.

#### 4.2. Terminal operations
Terminal operations return a result of a certain type after processing all the stream elements.

Once the terminal operation is invoked on a Stream, the iteration of the Stream and any of the chained streams will get started. Once the iteration is done, the result of the terminal operation is returned.

#### 4.2.1. Stream.forEach()
The forEach() method helps iterate over all stream elements and perform some operation on each of them. The operation to be performed is passed as the lambda expression.

memberNames.forEach(System.out::println);

#### 4.2.2. Stream.collect()
The collect() method is used to receive elements from steam and store them in a collection.
```java
List<String> memNamesInUppercase = memberNames.stream().sorted()
                            .map(String::toUpperCase)
                            .collect(Collectors.toList());

System.out.print(memNamesInUppercase);
```
Program Output:

[AMAN, AMITABH, LOKESH, RAHUL, SALMAN, SHAHRUKH, SHEKHAR, YANA]

#### 4.2.3. Stream.match()
Various matching operations can be used to check whether a given predicate matches the stream elements. All of these matching operations are terminal and return a boolean result.
```java
boolean matchedResult = memberNames.stream()
        .anyMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);     //true
 
matchedResult = memberNames.stream()
        .allMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);     //false
 
matchedResult = memberNames.stream()
        .noneMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);     //false
```
#### 4.2.4. Stream.count()
The count() is a terminal operation returning the number of elements in the stream as a long value.
```java
long totalMatched = memberNames.stream()
    .filter((s) -> s.startsWith("A"))
    .count();
 
System.out.println(totalMatched);     //2
```
#### 4.2.5. Stream.reduce()
The reduce() method performs a reduction on the elements of the stream with the given function. The result is an Optional holding the reduced value.

In the given example, we are reducing all the strings by concatenating them using a separator #.
```java
Optional<String> reduced = memberNames.stream()
        .reduce((s1,s2) -> s1 + "#" + s2);
 
reduced.ifPresent(System.out::println);
```
Program Output:

Amitabh#Shekhar#Aman#Rahul#Shahrukh#Salman#Yana#Lokesh

### 5. Short-circuit Operations
Though stream operations are performed on all elements inside a collection satisfying a Predicate, it is often desired to break the operation whenever a matching element is encountered during iteration.

In external iteration, we will do with the if-else block. In the internal iterations such as in streams, there are certain methods we can use for this purpose.

#### 5.1. Stream.anyMatch()
The anyMatch() will return true once a condition passed as predicate satisfies. Once a matching value is found, no more elements will be processed in the stream.

In the given example, as soon as a String is found starting with the letter 'A', the stream will end and the result will be returned.
```java
boolean matched = memberNames.stream()
        .anyMatch((s) -> s.startsWith("A"));
 
System.out.println(matched);    //true
```
#### 5.2. Stream.findFirst()
The findFirst() method will return the first element from the stream and then it will not process any more elements.
```java
String firstMatchedName = memberNames.stream()
            .filter((s) -> s.startsWith("L"))
            .findFirst()
                        .get();
 
System.out.println(firstMatchedName);    //Lokesh
```
### 6. Parallel Streams
With the Fork/Join framework added in Java SE 7, we have efficient machinery for implementing parallel operations in our applications.

But implementing a fork/join framework is a complex task, and if not done right; it is a source of complex multi-threading bugs that have the potential to crash the application. With the introduction of internal iterations, we got the possibility of operations to be done in parallel more efficiently.

To enable parallelism, all we have to do is to create a parallel stream, instead of a sequential stream. And to our surprise, this is really very easy.

In any of the above-listed stream examples, anytime we want to do a particular job using multiple threads in parallel cores, all we have to call parallelStream() method instead of stream() method.
```java
List<Integer> list = new ArrayList<Integer>();
for(int i = 1; i< 10; i++){
 list.add(i);
}

//Here creating a parallel stream
Stream<Integer> stream = list.parallelStream();  

Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
System.out.print(evenNumbersArr);
```
A key driver for Stream APIs is making parallelism more accessible to developers. While the Java platform provides strong support for concurrency and parallelism already, developers face unnecessary impediments in migrating their code from sequential to parallel as needed.

Therefore, it is important to encourage idioms that are both sequential- and parallel-friendly. This is facilitated by shifting the focus towards describing what computation should be performed rather than how it should be performed.

It is also important to strike the balance between making parallelism easier and not going so far as to make it invisible. Making parallelism transparent would introduce non-determinism and the possibility of data races where users might not expect it.

### 7. Stream Methods
#### 7.1 Creating Streams
- concat()
- empty()
- generate()
- iterate()
- of()
#### 7.2 Intermediate Operations
- [filter()](https://howtodoinjava.com/java8/java-stream-filter-example/)
- [map()](https://howtodoinjava.com/java8/stream-map-example/)
- [flatMap()](https://howtodoinjava.com/java8/stream-flatmap-example/)
- [distinct()](https://howtodoinjava.com/java8/java-stream-distinct-examples/)
- [sorted()](https://howtodoinjava.com/java8/stream-sorted-method/)
- [peek()](https://howtodoinjava.com/java8/java-stream-peek-example/)
- [limit()](https://howtodoinjava.com/java8/java-stream-limit-method-example/)
- [skip()](https://howtodoinjava.com/java8/stream-skip-example/)

#### 7.3. Terminal Operations
- [forEach()](https://howtodoinjava.com/java8/java-stream-foreach/)
- [forEachOrdered()](https://howtodoinjava.com/java8/java-stream-foreachordered/)
- [toArray()](https://howtodoinjava.com/java8/convert-stream-to-array/)
- reduce()
- collect()
- [min()](https://howtodoinjava.com/java8/java-stream-min/)
- [max()](https://howtodoinjava.com/java8/java-stream-max/)
- [count()](https://howtodoinjava.com/java8/stream-count-elements-example/)
- [anyMatch()](https://howtodoinjava.com/java8/stream-anymatch-example/)
- [allMatch()](https://howtodoinjava.com/java8/stream-allmatch-example/)
- [noneMatch()](https://howtodoinjava.com/java8/stream-nonematch-example/)
- [findFirst()](https://howtodoinjava.com/java8/stream-findfirst-findany/)
- [findAny()](https://howtodoinjava.com/java8/stream-findfirst-findany/)

### Real Time Example

1) Create DTO class Employee.
```java
public class Employee {

	private int id;
	private String name;
	private String dept;
	private long salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, String dept, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
```
2) Create DAO Layer

```java
import java.util.ArrayList;
import java.util.List;
//DAO layer
public class DataBase {

	public static List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(176, "Roshan", "IT", 600000));
		list.add(new Employee(388, "Bikash", "CIVIL", 900000));
		list.add(new Employee(470, "Bimal", "DEFENCE", 500000));
		list.add(new Employee(624, "Sourav", "CORE", 400000));
		list.add(new Employee(176, "Prakash", "SOCIAL", 1200000));
		return list;
	}

}
```
3) Create a Service class to perform business logic:
```java
import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

	public static List<Employee> evaluateTaxUsers(String input) {
		return (input.equalsIgnoreCase("tax")) ? DataBase.getEmployees().stream().filter(emp -> emp.getSalary() > 500000).collect(Collectors.toList()): DataBase.getEmployees().stream().filter(emp -> emp.getSalary() <= 500000).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		System.out.println(evaluateTaxUsers("tax"));
	}
}
```
</details>
<details><summary><b>1.2 Java 9 Stream API Improvements</b></summary>

# Java 9 Stream API Improvements

Learn new java 9 improvements in Stream API i.e. takeWhile / dropWhile methods, ofNullable and iterate methods with examples.

### Table of Contents

- Limiting Stream with takeWhile() and dropWhile() methods
- Overloaded Stream iterate method
- New Stream ofNullable() method

#### Limiting Stream with takeWhile() and dropWhile() methods
The new methods takeWhile and dropWhile allow you to get portions of a stream based on a predicate. Here a stream can be either ordered or unordered, so :

On an ordered stream, takeWhile returns the “longest prefix” of elements taken from the stream that match the given predicate, starting at the beginning of the stream.

On an un-ordered stream, takeWhile returns a subset of the stream’s elements that match the given predicate (but not all), starting at the beginning of the stream.

The dropWhile method does the opposite of takeWhile method.

On an ordered stream, dropWhile returns remaining items after the “longest prefix” that match the given predicate.
On an un-ordered stream, dropWhile returns remaining stream elements after dropping subset of elements that match the given predicate.

takeWhile and dropWhile Example

In this example, we have list of chars from ‘a’ to ‘i’. I want all chars which may appear before char ‘d’ in iteration.
```java
List<String> alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

List<String> subset1 = alphabets
        .stream()
        .takeWhile(s -> !s.equals("d"))
        .collect(Collectors.toList());

System.out.println(subset1);
```
> Output:

> [a, b, c]

As stated before, dropWhile acts opposite to takeWhile method so in above example, if used, it will return all characters which were left by takeWhile predicate.
> 
```java
List<String> alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

List<String> subset2 = alphabets
        .stream()
        .dropWhile(s -> !s.equals("d"))
        .collect(Collectors.toList());

System.out.println(subset2);
```
> Output:

> [d, e, f, g, h, i]

#### Overloaded Stream iterate method

iterate() methods used for creating a stream which starts with a single element (the seed), and subsequent elements are produced by successively applying the unary operator. The result is an infinite stream. To terminate the stream, a limit or some other short-circuiting function, like findFirst or findAny is used.

- The iterate method in Java 8 has the signature:

> static Stream iterate(final T seed, final UnaryOperator f)
In Java 9, new overloaded version of iterate takes a Predicate as the second argument:

> static Stream iterate(T seed, Predicate hasNext, UnaryOperator next)

Let’s see the difference is use of iterate method from java 8 to java 9.

```java
iterate method in Java 8
List<Integer> numbers = Stream.iterate(1, i -> i+1)
                            .limit(10)
                            .collect(Collectors.toList());
        
System.out.println(numbers);
```
> Output:

> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
- iterate method in Java 9
```java
List<Integer> numbers = Stream.iterate(1, i -> i <= 10 ,i -> i+1)
                                .collect(Collectors.toList());

System.out.println(numbers);
```
> Output:

> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
In above examples, the first stream is the Java 8 way of using iterate with a limit. The second one uses a Predicate as the second argument.

#### New Stream ofNullable() method
Until Java 8, you cannot have null value in a stream. It would have caused NullPointerException.

In Java 9, the ofNullable method lets you create a single-element stream which wraps a value if not null, or is an empty stream otherwise.
```java
Stream<String> stream = Stream.ofNullable("123");
System.out.println(stream.count());

stream = Stream.ofNullable(null);
System.out.println(stream.count());
```
> Output:

> 1
> 0
Here, the count method returns the number of non-empty elements in a stream.

Technically, Stream.ofNullable() is very similar to null condition check, when talking in context of stream API.
</details>
<details><summary><b>1.3 Creating Streams</b></summary>

## Creating Streams in Java

Learn to create streams of primitives and objects in Java using some most popular ways. We will learn to create finite as well as infinite streams.

### 1. Creating Finite Streams
#### 1.1. Empty Stream
We can use Stream.empty() method to create an empty stream.

> Stream<String> emptyStream = Stream.empty();

#### 1.2. From Values
In Java, the Stream.of() creates a stream of the supplied values as var-args, array or list.

> static <T> Stream<T> of(T... values);

Let us see a few examples to create a stream of values.
```java
Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);  //from var args

Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );  //from array

Employee[] arrayOfEmps = {
    new Employee(1, "A", LocalDate.of(1991, 1, 1), 10000d),
    new Employee(2, "B", LocalDate.of(1992, 1, 1), 20000d),
    new Employee(3, "C", LocalDate.of(1993, 1, 1), 30000d)
};

Stream<Employee> employeeStream = Stream.of(arrayOfEmps);
```
#### 1.3. From Collections
We can also get the stream from Java collection classes such as List, Map and Set.
```java
List<String> list = Arrays.asList("A", "B", "C", "D");
Stream<String> stream = list.stream();

Similarly, get a stream from Map.

Map<String, Integer> map = new HashMap<>();
map.put("A", 1);

Stream<String> keyStream = map.keySet().stream();
Stream<Integer> valStream = map.values().stream();
Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();
```
We can also get the stream using utility classes such as Arrays and Collections.
```java
String[] arr = { "A", "B", "C", "D" };

Stream<String> stream = Arrays.stream(arr);
```
#### 1.4. Stream.Builder
The Stream.Builder class follows the builder pattern where we add items to the stream in steps, and finally call the method build() to get the stream.
```java
Stream<String> streamBuilder = Stream.<String>builder()
                                            .add("A")
                                            .add("B")
                                            .build();

```
### 2. Creating Infinite Streams
Use the following methods to create infinite streams in Java.

- iterate(seed, function) – accepts two parameters – a seed which is the first term in the stream, and a function  to produce the value of the next item in the stream. We can limit the stream using the limit() method.
- generate(supplier) – accepts a Supplier that provides an infinite series of elements which are placed in the stream. The limit() method can then be called in the stream chain to stop the series after a certain number of elements. This is suitable for generating constant streams, streams of random elements, etc.
#### 2.1. Stream.iterate()
An example is to generate an infinite stream of even numbers starting from 0 using the iterate() function.
```java
Stream<Integer> infiniteEvenNumbers = Stream.iterate(0, n -> n + 2).limit(10);
```
#### 2.2. Stream.generate()
A similar example creates a stream of 10 random numbers between 0 and 99 using generate() function.
```java
Random rand = new Random();

Stream<Integer> stream =
    Stream.generate(() -> rand.nextInt(100)).limit(20);
```
</details>
<details><summary><b>1.4 Functional Interfaces</b></summary>

# Functional Interfaces in Java

Introduced in Java 8, a functional interface is simply an interface that has exactly one abstract method. Learn more about functional interfaces in this tutorial.

### 1. What is a Functional Interface?
#### 1.1. Only one abstract method is allowed
Functional interfaces are new additions in Java 8. As a rule, a functional interface can contain exactly one abstract method. These functional interfaces are also called Single Abstract Method interfaces (SAM Interfaces).

Apart from one abstract method, a functional interface can also have the following methods that do not count for defining it as a functional interface.

- Default methods
- Static methods
Public methods inherited from the Object class
#### 1.2. Implemented by Lambda Expressions
In Java, lambda expressions can be used to represent an instance of a functional interface. For example, Comparator interface is a functional interface.
```java
@FunctionalInterface
public interface Comparator<T> {
	int compare(T o1, T o2);
	boolean equals(Object obj);

	//and multiple default methods...
}
```
Comparator interface has only two abstract methods compare() and equals(). But equals() has been inherited from the Object class, so it is not counted. Other than these two methods, all other methods are default methods. So Comparator is qualified to be declared as a functional interface.

Java program to implement Comparator using a lambda expression.
```java
//Compare by Id
Comparator<Employee> compareById = Comparator.comparing(e -> e.getId());

Comparator<Employee> compareByFirstName = Comparator.comparing(e -> e.getFirstName());
```
### 2. @FunctionalInterface Annotation
Java 8 introduced the annotation @FunctionalInterface to mark an interface as a functional interface. The primary use of this annotation is for compiler-level errors when the interface violates the contracts of precisely one abstract method.

Note that using the annotation @FunctionalInterface is optional.

If the interface has one abstract method and does not have @FunctionalInterface annotation, the interface is still a functional interface, and it can be the target type for lambda expressions.

The presence of the annotation protects us from inadvertently changing a functional interface into a non-functional interface, as the compiler will catch it.

Let’s build our first functional interface. Note that methods in an interface are, by default, abstract.
```java
@FunctionalInterface
public interface MyFirstFunctionalInterface 
{
    public void firstWork();
}

Let’s try to add another abstract method:

@FunctionalInterface
public interface MyFirstFunctionalInterface 
{
    public void firstWork();
    public void doSomeMoreWork();   //error
}
```
The above code will result in a compiler error:

Unexpected @FunctionalInterface annotation
@FunctionalInterface ^ MyFirstFunctionalInterface is not a functional interface
multiple non-overriding abstract methods found in interface MyFirstFunctionalInterface
Functional-Interface-Error


### 3. Functional Interfaces in JDK
The following is a list of Java’s most commonly used functional interfaces.

- Runnable: contains only the run() method.
- Comparable: contains only the compareTo() method.
- ActionListener: contains only the actionPerformed() method.
- Callable: contains only the call() method.
- Predicate: a boolean-valued function that takes an argument and returns true or false.
- BiPredicate: a predicate with two arguments.
- Consumer: an operation that takes an argument, operates on it, and returns no result.
- BiConsumer: a consumer with two arguments.
- Supplier: a supplier that returns a value.
- Function<T, R>:  takes an argument of type T and returns a result of type R.
- BiFunction<T, U, R>: takes two arguments of types T and U and returns a result of type R.
  
### 4. Demo
Let’s see a quick example of creating and using functional interfaces in Java.

We are using a functional interface Function to create the formula for mathematical squares.

> Function<Integer, Integer> square = x -> x * x;

The Function interface has one abstract method apply() that we have implemented above. we can execute the above method as follows:

> System.out.println( square.apply(5) );  //Prints 25
</details>
<details><summary><b>1.5 Generic Functional Interfaces</b></summary>
	
# Generic Functional Interfaces in Java

Learn to create generic functional interfaces with and without type restrictions in Java 8 and later. Note that functional interfaces permit exactly one abstract method. These interfaces are also called Single Abstract Method interfaces (SAM Interfaces).

### 1. Without Type Restrictions
#### 1.1. Interface Definition
A functional interface can be defined that is generic for type X and has a functional method that accepts two arguments of type X and returns a value of type X.
```java
@FunctionalInterface
public interface ArgumentsProcessor<X>
{
    X process(X arg1, X arg2);
}
```
This interface can be used for any type i.e. ArgumentsProcessor<Integer>, ArgumentsProcessor<String> or ArgumentsProcessor<Employee>.

#### 1.2. Example
Java example to use generic functional interface with type Integer.
```java
ArgumentsProcessor<Integer> multiplyProcessor = new ArgumentsProcessor<Integer>() {
    @Override
    public Integer process(Integer arg1, Integer arg2)
    {
        return arg1 * arg2;
    }
};

System.out.println(multiplyProcessor.process(2,3));  	//6
```
Java example to use generic functional interface with type String.
```java
ArgumentsProcessor<String> appendProcessor = new ArgumentsProcessor<String>() {
    @Override
    public String process(String str1, String str2)
    {
        return str1  + " " + str2;
    }
};

System.out.println(appendProcessor.process("Hello", "World !!"));	//Hello World !!
```
### 2. With Type Restrictions
#### 2.1. Interface Definition
A functional interface can be defined that is restricted to certain types using extends keyword i.e. X extends Number.
```java
@FunctionalInterface
public interface ArgumentsProcesso<X extends Number>
{
    X process(X arg1, X arg2);
}
```
This interface can be used for any type i.e. ArgumentsProcessor<Integer>, ArgumentsProcessor<Double> but not for ArgumentsProcessor<String> or ArgumentsProcessor<Employee>.

In the above example, the permitted type must extend the Number class.

#### 2.2. Example
Java example to use generic functional interface with type Integer.
```java
ArgumentsProcessor<Double> doubleMultiplier = new ArgumentsProcessor<Double>() {
	@Override
	public Double process(Double arg1, Double arg2)
	{
	    return arg1 * arg2;
	} 
};

System.out.println(doubleMultiplier.process(4d, 6d));	//24.0
```
### 3. Specialized Functional Interfaces
Specialization is accomplished by extending or implementing the generic functional interface of one type. The resulting interface or class is not generic for that type.
```java
@FunctionalInterface
public interface ArgumentsProcessor<Integer>
{
    Integer process(Integer arg1, Integer arg2);
}

ArgumentsProcessor<Integer> intMultiplier = (i1, i2) -> i1 * i2;

System.out.println(intMultiplier.process(4, 5));	//20
```
</details>
<details><summary><b>1.6 Primitive Type Streams</b></summary>

# Primitive Type Streams in Java

Learn to create and operate on the streams of primitive types in Java with examples.

### 1. Primitives and Wrapper Classes
Java is not a true object-oriented programming language and supports primitive types that are not objects. We have 7 primitives in Java that are byte, short, int, long, double, float, char.

Java allows to wrap them in objects (wrapper classes) so these types can be represented as objects when required. The corresponding wrapper classes are Byte, Short, Integer, Long, Double, Float and Char.

The process of converting a primitive to an object is called auto-boxing and converting an object to a primitive is called unboxing.

### 2. Support for Primitive Streams
Java Stream API, similar to Collections API, has been designed to work upon objects and not primitive types.

The stream API has inbuilt support for representing primitive streams using the following specialized classes. All these classes support the sequential and parallel aggregate operations on stream items.

- IntStream : represents sequence of primitive int-valued elements.
- LongStream : represents sequence of primitive long-valued elements.
- DoubleStream : represents sequence of primitive double-valued elements.
These classes help in avoiding a lot of unnecessary object creation, auto-boxing and unboxing operations if we decide to do these operations on our own.

For other primitive types, Java does not provide similar stream support classes as it was not found useful to have so many classes. The int, long and double are very highly used types so support was added for them.

### 3. Creating Streams of Primitives
#### 3.1. Creating Stream of Specified Values
If we have a few specified values of int, long or double then we can create the stream using the of() factory method.
```java
IntStream stream = IntStream.of(1, 2, 3, 4, 5);
LongStream stream = LongStream.of(1, 2, 3, 4, 5);
DoubleStream stream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
```
#### 3.2. Stream.range() Fatory Method
The range() method returns a sequential ordered IntStream or LongStream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1.
```java
IntStream stream = IntStream.range(1, 10);  //1,2,3,4,5,6,7,8,9
LongStream stream = LongStream.range(10, 100);
```
A similar method rangeClosed() also returns a sequential ordered stream but the end item is inclusive in the stream.
```java
IntStream stream = IntStream.rangeClosed(1, 10);  //1,2,3,4,5,6,7,8,9,10
```
#### 3.3. Arrays.stream()
We can directly call the stream() method on an array that will return an instance of Stream class corresponding to the type of array.

For example, if we call array.stream() on an int[] then it will return an instance of IntStream.
```java
// int[] -> Stream
int[] array = new int[]{1, 2, 3, 4, 5};
IntStream stream = Arrays.stream(array);

// long[] -> Stream
long[] array = new long[]{1, 2, 3, 4, 5};
LongStream stream = Arrays.stream(array);

// double[] -> Stream
double[] array = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
DoubleStream stream = Arrays.stream(array);
```
#### 3.4. Stream mapToInt(), mapToLong() and mapToDouble()
Another technique to get the primitive stream is using the mapTo() function for the corresponding type.

For example, if we have a stream of Integer or any other type of object with a field of Integer type such as person’s age) then we can get the stream of all such values as a stream of int values.
```java
List<Integer> integerList = List.of(1, 2, 3, 4, 5);
IntStream stream = integerList.stream().mapToInt(i -> i);

Stream<Employee> streamOfEmployees = getEmployeeStream();
DoubleStream stream = streamOfEmployees.mapToDouble(e -> e.getSalary());
```
### 4. Finding Sum, Average, Max and Min
#### 4.1. Built-in Methods
All three classes, IntStream, LongStream and DoubleStream, consist of numerical values and it makes sense to provide built-in support for common aggregate operations on items of the stream.

These classes provide the following methods for these operations. The return types are corresponding to the type of the stream. The following methods are from IntStream class:

- sum() – returns the sum of items in the stream.
- average() – returns an OptionalDouble describing the arithmetic mean of items of the stream.
- max() – returns an OptionalInt describing the maximum item of the stream.
- min() – returns an OptionalInt describing the mimimum item of the stream.
- count() – returns the count of items in the stream.

Let’s see a few examples of how to use these methods.
```java
int max = IntStream.of(10, 18, 12, 70, 5)
  .max()
  .getAsInt();

double avg = IntStream.of(1, 2, 3, 4, 5)
  .average()
  .getAsDouble();

int sum = IntStream.range(1, 10)
  .sum();
```
#### 4.2. Summary Statistics
Another way to find the above statistical data is by using the summaryStatistics() method that returns one of the following classes:

- IntSummaryStatistics
- LongSummaryStatistics
- DoubleSummaryStatistics
  
Now we can use its methods to get the required value.

- getAverage()
- getCount()
- getMax()
- getMin()
- getSum()
```java
IntSummaryStatistics summary = IntStream.of(10, 18, 12, 70, 5)
    .summaryStatistics();

int max = summary.getMax();
```
### 5. Primitive Stream to Object Stream
Using the boxed() method, we can convert a primitive stream to an object stream of the corresponding type.

For example, to get Stream<Long> from a LongStream, we can call the boxed() method:
```java
Stream<Integer> boxedStream1 = IntStream.of(1, 2, 3, 4, 5).boxed();
Stream<Long> boxedStream = LongStream.of(1, 2, 3, 4, 5).boxed();
Stream<Double> boxedStream2 =
    DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).boxed();
```

## Primitive Type Streams in Java 8

### 1. Introduction
The Stream API was one of the key features added in Java 8.

Briefly, the API allows us to process collections and other sequences of elements – conveniently and more efficiently – by providing a declarative API.

### 2. Primitive Streams
Streams primarily work with collections of objects and not primitive types.

Fortunately, to provide a way to work with the three most used primitive types – int, long and double – the standard library includes three primitive-specialized implementations: IntStream, LongStream, and DoubleStream.

Primitive streams are limited mainly because of boxing overhead and because creating specialized streams for other primitives isn’t’ that useful in many cases.

### 3. Arithmetic Operations
Let’s start with a few interesting methods for heavily used arithmetic operations such as min, max, sum, and average:
```java
int[] integers = new int[] {20, 98, 12, 7, 35};
int min = Arrays.stream(integers)
  .min()
  .getAsInt(); // returns 7
```
Let’s now step through the code snippet above to understand what’s going on.

We created our IntStream by using java.util.Arrays.stream(int[]) and then used the min() method to get the lowest integer as java.util.OptionalInt and finally called getAsInt() to get the int value.

Another way to create an IntStream is using IntStream.of(int…). The max() method will return the greatest integer:
```java
int max = IntStream.of(20, 98, 12, 7, 35)
  .max()
  .getAsInt(); // returns 98
```
Next – to get the sum of integers we just call the sum() method and we don’t need to use getAsInt() since it already returns the result as an int value:
```java
int sum = IntStream.of(20, 98, 12, 7, 35).sum(); // returns 172
```
We invoke the average() method to get the average of integer values and as we can see, we should use getAsDouble() as it returns a value of type double.
```java
double avg = IntStream.of(20, 98, 12, 7, 35)
  .average()
  .getAsDouble(); // returns 34.4
```
### 4. Range
We can also create an IntStream based on a range:
```java
int sum = IntStream.range(1, 10)
  .sum(); // returns 45
int sum = IntStream.rangeClosed(1, 10)
  .sum(); // returns 55
```
As the code snippet above shows there are two ways to create a range of integer values range() and rangeClosed().

The difference is that the end of range() is exclusive while it is inclusive in rangeClosed().

Range methods are only available for IntStream and LongStream.

We can use range as a fancy form of a for-each loop:
```java
IntStream.rangeClosed(1, 5)
  .forEach(System.out::println);
```
What’s good at using them as a for-each loop replacement is that we can also take advantage of the parallel execution:
```java
IntStream.rangeClosed(1, 5)
  .parallel()
  .forEach(System.out::println);
```
As helpful as these fancy loops are it’s still better to use the traditional for-loops instead of the functional one for simple iterations because of simplicity, readability, and performance in some cases.

### 5. Boxing and Unboxing
There’re times when we need to convert primitive values to their wrapper equivalents.

In those cases, we can use the boxed() method:
```java
List<Integer> evenInts = IntStream.rangeClosed(1, 10)
  .filter(i -> i % 2 == 0)
  .boxed()
  .collect(Collectors.toList());
```
We can also convert from the wrapper class stream to the primitive stream:
```java
// returns 78
int sum = Arrays.asList(33,45)
  .stream()
  .mapToInt(i -> i)
  .sum();
```
We can always use mapToXxx and flatMapToXxx methods to create primitive streams.

### 6. Conclusion
Java Streams is a very powerful addition to the language. We’ve barely scratched the surface of primitive streams here, but, as you can already use them to be productive.

</details>
<details>
<summary><b>1.7 Using ‘if-else’ Conditions with Streams</b></summary>
	
# Using ‘if-else’ Conditions with Java Streams

Learn to use the if-else conditions logic using Java Stream API to filter the items from a collection based on certain conditions.

### 1. The ‘if-else‘ Condition as Consumer Implementation
The 'if-else' condition can be applied as a lambda expression in forEach() function in form of a Consumer action.

Consumer is a functional interface whose functional method is ‘void accept(Object)‘. It represents an operation that accepts a single input argument and returns no result.

In the given example, we are checking if a number is even then print a message, else print another message for an odd number.
```java
ArrayList<Integer> numberList 
    = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

Consumer<Integer> action = i -> {
    if (i % 2 == 0) {
        System.out.println("Even number :: " + i); //Or any other user action we want to do
    } else {
        System.out.println("Odd  number :: " + i);  //Or any other user action we want to do
    }
};

numberList.stream()
    .forEach(action);
```
We can perform any kind of operation on the stream items instead of just printing the items to the console, e.g. storing the items to two separate lists or passing the items to other method calls.
We can write as many if-else statements as required.
We can also write the pass the Consumer implementation as an inline lambda expression to the forEach() function.
```java
Arrays.asList(-1, 1, -2, 3, 4, -5, 6, 0).stream()
    .forEach(
        i -> {
          if (i == 0) {
            System.out.println("Number is 0");
          } else if (i > 0) {
            System.out.println("Positive Number");
          } else {
            System.out.println("Negative Number");
          }
        }
    );
```
### 2. The ‘if' Condition with Predicates
If we intend to apply only 'if' logic then we can pass the condition directly do the filter() function as a Predicate.

In the given example, we are checking if a number is an even number then printing a message.
```java
ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));


Predicate<Integer> isEven = i -> i % 2 == 0;
         
numberList.stream()
    .filter(isEven)
    .forEach(System.out::println);
```
Using one of the above given two methods, we can apply any combination of if-else conditions in Java 8 stream elements.

</details>
<details>
<summary><b>1.8 Creating Infinite Streams</b></summary>

# How to Create Infinite Streams in Java

Learn to generate an infinite stream of elements in Java. We will use Stream.generate() and Stream.iterate() methods to get infinite streams.

### 1. Overview
This is very important to note that Java Streams are lazy by design. So:

The generate() and iterate() methods are intermediate operations, so the actual element creation doesn’t begin until a terminal operation is invoked.
Be careful and use the limit() to restrict the number of elements in the stream, before invoking the terminal operation. Else the stream generation will continue infinitely.
Use iterate() method to create ordered stream elements, and generate() method to create unordered stream elements.
### 2. Infinite Streams with iterate() Method
#### 2.1. Method Syntax
Syntax
> static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)

The Stream.iterate() method returns an infinite sequential ordered stream. The first element (index 0) in the Stream will be the provided seed. For n > 0, the element at position n, will be the result of applying the function f to the element at position n - 1.

#### 2.2. Sequence of Integer Values
In the given example, we are creating an infinite stream of even numbers starting from 0. Then we collect the first 10 elements from the stream into a list.
```java
List<Integer> ints = IntStream.iterate(0, i -> i + 2)
            .mapToObj(Integer::valueOf)
            .limit(10)
            .collect(Collectors.toList());
```
### 3. Infinite Streams with generate() Method
#### 3.1. Method Syntax
static <T> Stream<T> generate(Supplier<T> s)

It returns an infinite sequential unordered stream where each element is generated by the provided Supplier. This is suitable for generating constant streams, streams of random elements, etc.

#### 3.2. Example – Stream of Random Numbers
The following example creates a stream of 10 random numbers between 0 and 99.
```java
List<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100))
                  .limit(10)
                  .collect(Collectors.toList());
```
#### 3.3. Example – Stream of Custom Objects
The following example creates an infinite stream of employees and takes the first 5 employees from the stream.
```java
List<Employee> employees = Stream.generate(Employee::create)
              .limit(5)
              .collect(Collectors.toList());
```
Where Employee class is this:
```java
import java.io.Serializable;
import java.util.Random;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Random r = new Random(Integer.MAX_VALUE);  

	private long id;
	private String name;
	private double salary;

	//All-args constructor, getters and setters are hidden for brevity

	public static Employee create() {
		//Get the employee id in more predictable manner
		//e.g. Max id present in databse + 1

		Employee obj = new Employee(r.nextInt(), "", 0.0d);
		return obj;
	}
}
```
</details>
<details>
<summary><b>1.9 Stream of Random Numbers</b></summary>

# Stream of Random Numbers in Java

Learn to get a Stream of random numbers in Java using the Random and SecureRandom classes.

### 1. The Random API
Java 8 release has added several methods to the Random class which can return a sequential stream of random numbers (integers, longs and doubles). The most widely used methods are:

- IntStream ints()
- LongStream longs()
- DoubleStream doubles()

All of the above methods have their overloaded forms. For example, ints() method has these overloaded forms.

- IntStream ints() – Returns an effectively unlimited stream of pseudorandom int values.
- IntStream ints(long streamSize) – Returns a stream producing the given number of pseudorandom int values.
- IntStream ints(int origin, int bound) – Returns an effectively unlimited stream of int values, each conforming to the given origin (inclusive) and bound (exclusive).
- IntStream ints(long streamSize, int origin, int bound) – Returns a stream producing the given number of pseudorandom int values, each conforming to the given origin (inclusive) and bound (exclusive).
### 2. Example of Stream of Random Numbers
Let’s learn to use the above-discussed methods to create a stream of random numbers.
```java
Random random = new Random();

//1
IntStream randStream = random.ints(5);
randStream.forEach(System.out::println);

//2
DoubleStream doubleStream = random.doubles(5, 0, 0.5);
doubleStream.forEach(System.out::println);

//collect to list
List<Long> longs = random.longs(5)
    .boxed()
    .collect(Collectors.toList());
```
### 3. Stream of Secure Random Numbers
To get the stream of secure random numbers (i.e. cryptographically strong random number), use the subclass SecureRandom. By default, SecureRandom uses the SHA1PRNG algorithm. The default constructor also uses this algorithm.

CSPRNG (cryptographically strong pseudo-random number generator) uses entropy, which is nothing but an unpredictable input (true random source). It might be a hardware random number generator or possibly some unpredictable system process, such as the timings events, interrupts etc.
```java
SecureRandom secureRandomGenerator = SecureRandom.getInstanceStrong();
 
//1. Get 128 random bytes
byte[] randomBytes = new byte[128];
secureRandomGenerator.nextBytes(randomBytes);
 
//2. Get random integer
int r = secureRandomGenerator.nextInt();
 
//3. Get random integer in range
int randInRange = secureRandomGenerator.nextInt(999999);
```
Please note that all the above-discussed methods (ints(), longs(), doubles() and their overloads) also work with the SecureRandom class.
```java
SecureRandom sRand = SecureRandom.getInstanceStrong();

IntStream randStream = sRand.ints(5);

randStream.forEach(System.out::println);
```
</details>
<details>
<summary><b>1.10 Boxed Streams</b></summary>

# Boxed Streams in Java

In Java, a boxed stream is a stream of the wrapper class instances to simulate a stream of primitives.

### 1. What is a Boxed Stream?
Java Stream API has been designed to work with objects, similar to Collections API. Streams do not treat the primitive types the same as objects.

In Stream API, a stream of primitives can be represented by the following 3 classes:

- IntStream
- LongStream
- DoubleStream

To convert from a stream of primitives to a stream of objects, these classes provide boxed() method that returns a Stream consisting of the elements of the given stream, each boxed to an object of the corresponding wrapper class.
```java
Stream<Integer> stream = IntStream.of(1, 2, 3, 4, 5).boxed();

Stream<Long> stream1 = LongStream.of(1, 2, 3, 4, 5).boxed();

Stream<Double> stream2 = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).boxed();
```
### 2. Need of Boxed Streams
Without boxing the stream items, we cannot perform the regular stream operations on them. For example, we cannot collect the int values to a list, directly.
```java
//Compilation issue
/*List<Integer> list = IntStream.of(1,2,3,4,5)
    .collect(Collectors.toList());*/
```
To make the above collecting process work, we must box the stream items first.
```java
//Works fine
List<Integer> list = IntStream.of(1,2,3,4,5)
    .boxed()
    .collect(Collectors.toList());
```
</details>
<details>
<summary><b>1.11 Stream of Dates</b></summary>
	
# Get all Dates between Two Dates as Stream

Date and time handling has always been a pain area for Java developers. The new Date-Time API added in Java 8 changed the way, we interact with date and time in Java.

New Date API is a very powerful and much-needed improvement. The only thing missing was, getting a stream of dates having some common difference between two subsequent dates (though it was possible there was no easy way).

Java 9 has introduced a new method LocalDate.datesUntil() that can give a stream on dates. Using datesUntil() makes it easy to create dates streams with a fixed offset.

### 1. LocalDate.datesUntil() Method (Java 9)
#### 1.1. Syntax

This method has two overloaded forms:

- startDate.datesUntil(endDate) : returns a sequential ordered stream of dates that starts from startDate (inclusive) and goes to endDate (exclusive) by an incremental step of 1 day.
- startDate.datesUntil(endDate, period) : same as above with a configured incremental step period.
  
> Stream<LocalDate> datesUntil(LocalDate end)
> Stream<LocalDate> datesUntil(LocalDate end, Period step)

#### 1.2. Example of Stream of Dates
Creating a stream of dates is very simple and straightforward as demonstrated in the given examples.

In this example, we are getting the dates for the next 3 consecutive days.
```java
LocalDate today = LocalDate.now();

Stream<LocalDate> next3Days = today.datesUntil(today.plusDays(3));

next3Days.forEach(System.out::println);
```
In the next example, we are getting the same day for the next 3 weeks.
```java
Stream<LocalDate> sameDayNext3Weeks = today
    .datesUntil(today.plusDays(21), Period.ofWeeks(1));

sameDayNext3Weeks.forEach(System.out::println);
```
### 2. Get Stream of Dates using Iteration (Java 8)
If you have still not adapted Java 9, then you can use the given below method to generate date streams.

Stream<LocalDate> nextThreeDays = Stream.iterate(today, d -> d.plusDays(1));

Once we have the stream, we can use the stream operations on the items.
```java
Stream<LocalDate> nextThreeDays = Stream.iterate(today, d -> d.plusDays(1));

List<LocalDate> list = nextThreeDays
    .limit(3)
    .collect(Collectors.toList());
```
</details>
<details>
<summary><b>1.12 Remove/Update Elements From List using Stream</b></summary>

# Java – Remove/Update Elements From List using Stream

Learn to remove and update elements of a Collection using Stream API in Java with examples. It is worth noting that each method shown below creates a new List, the original List is not modified after the processing.

### 1. Removing Elements using Stream
Removing the elements is very simple. We iterate over the Stream elements and filter out the elements that match a given Predicate passed to the Stream.filter() method.

In the following example, we are only selecting the employees whose names start with the character “A“. All other elements are removed from the stream.
```java
List<Employee> list = List.of(
    new Employee(1, "Alex", LocalDate.of(1990, 1, 2), 100d),
    new Employee(2, "Alok", LocalDate.of(1992, 1, 2), 200d),
    new Employee(3, "Brian", LocalDate.of(1994, 1, 2), 300d),
    new Employee(4, "Charles", LocalDate.of(1996, 1, 2), 400d));

List<Employee> modifiedList = list.stream()
    .filter(e -> e.getName().startsWith("A"))
    .collect(Collectors.toList());

//Employees whose names start with "A"
System.out.println(modifiedList);
```
The program output.
```
[
	Employee [id=1, name=Alex, dateOfBirth=1990-01-02, salary=100.0], 
	Employee [id=2, name=Alok, dateOfBirth=1992-01-02, salary=200.0]
]
```
### 2. Updating Elements using Stream
To update all elements or the matching elements from the Stream, we use the Stream.map() method and return a new Employee instance. All modified instances are collected into a new List.

In the following example, we are updating the salary for all employees by 100. The modified elements are collected into newList.
```java
List<Employee> list = List.of(
    new Employee(1, "Alex", LocalDate.of(1990, 1, 2), 100d),
    new Employee(2, "Alok", LocalDate.of(1992, 1, 2), 200d),
    new Employee(3, "Brian", LocalDate.of(1994, 1, 2), 300d),
    new Employee(4, "Charles", LocalDate.of(1996, 1, 2), 400d));

List<Employee> newList = list.stream()
    .map(e -> {
      e.setSalary(e.getSalary() + 100);
      return e;
    })
    .collect(Collectors.toList());

System.out.println(newList);
```
The program output.
```
[
	Employee [id=1, name=Alex, dateOfBirth=1990-01-02, salary=200.0], 
	Employee [id=2, name=Alok, dateOfBirth=1992-01-02, salary=300.0], 
	Employee [id=3, name=Brian, dateOfBirth=1994-01-02, salary=400.0], 
	Employee [id=4, name=Charles, dateOfBirth=1996-01-02, salary=500.0]
]
```
</details>
<details>
<summary><b>1.13 Iterate with Indices</b></summary>

# How to Iterate Over a Stream With Indices

Unlike the Collection elements, Stream elements cannot be accessed through indices, but there are still workarounds to get indices of the elements. In this Java tutorial, we will learn such few ways to iterate over Stream with indices.

### 1. Setup
For demo purposes, we are using the following Employee class.
```java
public class Employee {

    private String name;
    private String email;
    private int age;
}
```
And we will also initialize an array of new employee objects which we will convert into a stream and then filter it according to indices:
```java
Employee[] employees = {
    new Employee("Alexandru", "alexandru@gmail.com", 22),
    new Employee("Emanuela", "ema@gmail.com", 20),
    new Employee("George", "george@gmail.com", 32),
    new Employee("John", "john123@gmail.com", 25),
    new Employee("Liam", "liam123@gmail.com", 45),
    new Employee("Noah", "noah@outlook.com", 30),
    new Employee("Oliver", "oliver@yahoo.com", 47)
};
```
### 2. Using Custom Logic
For our first example, we will utilize the fact that our array elements can be accessed through indices. So, taking that in a sense, we will use the IntStream class to iterate over the numbers from 0 to the length of our array, filter them by the index, and map them with the corresponding Employee objects for the desired indices.

We can also collect the Employee instances in a new List if such a requirement exists.
```java
IntStream.range(0, employees.length)
        .filter(i -> i % 2 == 0)
        .mapToObj(i -> employees[i])
        .forEach(System.out::println);
```
We can also use an AtomicInteger to hold the index of the stream elements. Then, we will get a stream from array using the stream() function and map each element of the stream with an index using the map() method, where the index is brought from the AtomicInteger by incrementing every time with the help of getAndIncrement() function.
```java	
AtomicInteger index = new AtomicInteger();

Arrays.stream(employees)
        .map(i -> index.getAndIncrement())
        .filter(i -> i % 2 == 0)
        .map(i -> employees[i])
        .forEach(System.out::println);
```
### 3. Using StreamUtils
For this example, we will use StreamUtils class from the protonpack library.
```pom
<dependency>
    <groupId>com.codepoetics</groupId>
    <artifactId>protonpack</artifactId>
    <version>1.16</version>
</dependency>
```
Now we can use the zipWithIndex() function from the StreamUtils class. This function will take the elements and zip each value with its index to create a stream of indexed values. After calling the function, we will filter the elements by their index, map them to their value and print each element.
```java
StreamUtils.zipWithIndex(Arrays.stream(employees))
      .filter(e -> e.getIndex() % 2 == 0)
      .map(e -> e.getValue())
      .forEach(System.out::println);
```
### 3. Using StreamEx
Now we will use the EntryStream class from the StreamEx library.
```pom
<dependency>
    <groupId>one.util</groupId>
    <artifactId>streamex</artifactId>
    <version>0.8.1</version>
</dependency>
```
Now we can use the filterKeyValue() method to filter our values by their index. After that, we will take only the values and print them to the console.
```java
EntryStream.of(employees)
    .filterKeyValue((index, name) -> index % 2 == 0)
    .values()
    .forEach(System.out::println);
```
### 4. Using Guava’s Streams
Guava is a group of core Java libraries from Google that contains new collection classes (such as multimap and multiset) and more! It is widely utilized on most Java projects within Google and by many other companies.
```pom
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.0.1-jre</version>
</dependency>
````
We will use the mapWithIndex() function that returns a Stream that contains the results of applying the given function to the elements of the stream and their indexes in the stream. After applying the function, we will return null values for the odd indexes, and we will filter out them and print the result.
```java
Streams.mapWithIndex(Arrays.stream(employees),
          (emp, index) -> index % 2 ==0 ? emp : null)
  .filter(emp -> emp != null)
  .forEach(System.out::println);	
```
### 5. Iteration using Vavre‘s Stream
Vavr is a functional library for Java. It allows the reduction of the amount of code and increases the robustness.
```pom
<dependency>
    <groupId>io.vavr</groupId>
    <artifactId>vavr</artifactId>
    <version>0.10.4</version>
</dependency>
```
Now we can use the zipWithIndex() function that will traverse our stream and return a tuple that contains the value and the index of the value. Now we can easily filter out the elements based on the parity of the index and print it on the console.
```java
Stream.of(employees).zipWithIndex()
      .filter(tuple -> tuple._2 % 2 == 0)
      .map(tuple -> tuple._1)
      .forEach(System.out::println);
```
</details>
<details>
<summary><b>1.14 Stream has already been operated upon or closed Exception</b></summary>
	
# [Solved] “Stream has already been operated upon or closed” Exception

Java 8 Stream API is used to process data collections such as arrays, lists, and maps. If we often work with streams, we may have encountered the following error: java.lang.IllegalStateException: stream has already been operated upon or closed.

Let us examine the root cause of the problem and how to solve it.

### 1. Reason
The Java Streams process the collection items with 2 types of operations:

Intermediate operations: that help in method chaining and return a new Stream of processed items such as filter, sort, or map.
Aggregate or terminal operations: terminate the stream by performing common operations or reduction on them. After calling the terminal operation, the Stream is considered closed. For example, max, min or collect items into a list or set.
We can use the terminal operation on a Stream only once. Calling a terminal operation in a already closed Stream causes the IllegalStateException.

Let us understand with an example. In the following example, we are using the same Stream twice. First for getting the even numbers, and then for getting the odd numbers.
```java
Stream<Integer> numberStream = Stream.of(123, 234, 11, 57, 60, -4);

List<Integer> evenNumbers = numberStream
	.filter(integer -> integer % 2 == 0)
	.collect(Collectors.toList());

List<Integer> oddNumbers = numberStream
	.filter(integer -> integer % 2 == 1)    
	.collect(Collectors.toList());
```
> The program output.

> Even numbers:
> 234
> 60
> -4
> Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
> 	at java.base/java.util.stream.AbstractPipeline.<init>(AbstractPipeline.java:203)
> 	at java.base/java.util.stream.ReferencePipeline.<init>(ReferencePipeline.java:94)
> 	at java.base/java.util.stream.ReferencePipeline$StatelessOp.<init>(ReferencePipeline.java:696)
> 	at java.base/java.util.stream.ReferencePipeline$2.<init>(ReferencePipeline.java:165)
> 	at java.base/java.util.stream.ReferencePipeline.filter(ReferencePipeline.java:164)
>	at org.example.Main.main(Main.java:18)

Process finished with exit code 1

We can see that the first filtering operation on the stream was executed successfully, but the second operation returned an Exception. This is caused by the fact that the stream is consumed and closed by the first operation, more precisely by the collect() function.

When we started processing the Stream a second time, we get the exception with the message “stream has already been operated upon or closed”.

### 2. Solution
One solution for this problem would be creating a new stream every time before every stream processing, but there exists a more elegant method to handle this.

The Supplier interface is a functional interface that can be assigned using a lambda function. After initializing the supplier, we can use the get() function. The Supplier.get() returns a newly created Stream Object each time on which we can perform stream operations safely.
```java
Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(123, 234, 11, 57, 60, -4);

List<Integer> evenNumbers = streamSupplier.get()
        .filter(integer -> integer % 2 == 0)
        .collect(Collectors.toList());

List<Integer> oddNumbers = streamSupplier.get()
        .filter(integer -> integer % 2 == 1)
        .collect(Collectors.toList());
```
</details>
</details>

<details>
<summary><b>2. Stream Searching, Filtering and Sorting</b></summary>
<details>
<summary><b>2.1 Getting Distinct Stream Items by Comparing Multiple Fields</b></summary>

# Getting Distinct Stream Items by Comparing Multiple Fields

Learn to collect or count distinct objects from a stream where each object is distinct by comparing multiple fields in the class.

Java does not have direct support for finding such distinct items from the Stream where items should be distinct by multiple fields. So, we will create a custom Predicate for this purpose.

#### 1. Finding Distinct Items by Multiple Fields
Below given is a function that accepts varargs parameters and returns a Predicate instance. We can use this function to pass multiple key extractors (fields on which we want to filter the duplicates).

This function creates a List of field values and this List act as a single key for that Stream item. The list contains the values of fields to check distinct combinations.

Then these keys are inserted into a ConcurrentHashMap that allows only unique keys.
```java
Predicate distinctByKeys()
private static <T> Predicate<T> 
    distinctByKeys(final Function<? super T, ?>... keyExtractors) 
{
    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();
     
    return t -> 
    {
      final List<?> keys = Arrays.stream(keyExtractors)
                  .map(ke -> ke.apply(t))
                  .collect(Collectors.toList());
       
      return seen.putIfAbsent(keys, Boolean.TRUE) == null;
    };
}
```
In the given example, we are finding all persons having distinct ids and names. We should have only 3 records as output.

```java
Collection<Person> list = Arrays.asList(alex, brianOne, 
        brianTwo, lokeshOne,
        lokeshTwo, lokeshThree);

List<Person> distinctPersons = list.stream()
      .filter(distinctByKeys(Person::firstName, Person::lastName))
      .collect(Collectors.toList());
```
Here Person may be a class or record.
```java
record Person(Integer id, String firstName, String lastName, String email) {
}
```
#### 2. Distinct by Multiple Fields using Custom Key Class
Another possible approach is to have a custom class that represents the distinct key for the POJO class.

For the previous example, we can create a class CustomKey containing id and name values. The distinct elements from a list will be taken based on the distinct combination of values for all these fields.

In the given example, again, we are finding all records having unique ids and names. Note that in this approach, we are only replacing the List with CustomKey class.
```java
CustomKey.java
record CustomKey(String firstName, String lastName) {
  public CustomKey(final Person p) 
  {
    this(p.firstName(), p.lastName());
  }
}
```
Let us see how CustomKey::new is used for filtering the distinct elements from the list based on the given multiple fields.

```java
Collection<Person> list = Arrays.asList(alex, brianOne, 
    brianTwo, lokeshOne,
    lokeshTwo, lokeshThree);

List<Person> distinctPersons = list.stream()
      .filter(distinctByKeyClass(CustomKey::new))
      .collect(Collectors.toList());

//Method accepting Custom key class
public static <T> Predicate<T> 
    distinctByKeyClass(final Function<? super T, Object> keyExtractor) 
{
    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
}
```
</details>
<details>
<summary><b>2.2 Getting the Last Item of a Stream</b></summary>

# Getting the Last Item of a Stream

Learn to find the last element of a stream in Java. We will learn to use finite as well as infinite streams as well.

#### 1. Getting Last Item with Stream Reduction
The reduce() method uses the reduction technique on the elements of the Stream. To get the last element, it continues picking up the two elements of the stream and choosing the latter. This will go on until all elements are exhausted.

At the end of the reduction process, we will have the last element of the stream.

Get last element using reduce() method
```java
Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    .stream();
 
Integer lastElement = stream.reduce((first, second) -> second)
              .orElse(-1);
 
System.out.println(lastElement);  // Prints 9
```
The reduce() method returns an Optional which gives us the choice of what to do when an empty element is returned. For example, the stream itself might be empty.

If the Stream is empty
```java
Stream<Integer> emptyStream = Stream.empty(); 

//Return -1 if stream is empty
Integer lastElement = emptyStream.reduce((first, second) -> second)
                .orElse(-1);
 
System.out.println(lastElement);  //-1
 
//Throw IllegalStateException if stream is empty
 
Integer lastElement = emptyStream.reduce((first, second) -> second)
        .orElseThrow(() -> new IllegalStateException("no last element"));
```
Program output:

-1
```
Exception in thread "main" java.lang.IllegalStateException: no last element
	at com.howtodoinjava.core.streams.misc.GetLastElement.lambda$1(GetLastElement.java:19)
	at java.util.Optional.orElseThrow(Unknown Source)
	at com.howtodoinjava.core.streams.misc.GetLastElement.main(GetLastElement.java:19)
```
#### 2. Using Streams.findLast() from Guava
Streams.findLast() is really neat, readable, and provides good performance. It returns the last element of the specified stream, or Optional.empty() if the stream is empty.

Streams.findLast() example 
```java
Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    .stream();
 
Integer lastElement = Streams.findLast(stream2).orElse(-1);
 
System.out.println(lastElement);  // Prints 9
```
#### 3. Last Item from an Infinite streams
Can there be any last element in an infinite stream? No, there cannot be. So make sure that the stream is not infinite when we are trying to find the last element of the stream. None of the above-listed APIs will return any value or throw an exception.

In fact, the above solutions will not even return and halt the program execution completely.

Last Element of Infinite stream 
```java
Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
     
Integer lastElement = Streams.findLast(stream).orElse(-1);  // Halts the program
 
System.out.println(lastElement);
```
Use limit() to get a finite stream out of a given infinite stream.
```java
Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);

lastElement = infiniteStream.limit(100)
                .reduce((first, second) -> second)
                .orElse(-1);

System.out.println(lastElement);   //198
```
</details>

<details>
<summary><b>2.3 Get Object with Max Date From a List</b></summary>
  
# Java Stream – Get Object with Max Date From a List

Learn to get an object with the latest date (max date) from a Stream of custom objects. We will use a custom Comparator for comparing the Date values stored in the custom objects.

This example uses Employee class. We will create a program to get the youngest employee in a list of employees.

#### 1. Custom Comparator for Comparing Objects by Date
The LocalDate() implements the Comparable interface so it automatically supports the correct comparison logic for comparing the two LocalDate objects. We do not need to write our own comparison logic for this date comparison.

We need to write a custom Comparator that can compare the custom objects and compare their LocalDate value.

The given Comparator compares two given Employee objects by their age i.e. Date of birth.

Custom Object Comparator
```java
Comparator<Employee> employeeAgeComparator = Comparator
                .comparing(Employee::getDateOfBirth);
```
Use Comparator.reversed() method, we need to find the Min Date from the Stream.

#### 2. Getting Object with Max date using Stream.max()
Now we know what to compare, let us create a program to create a stream of Employee Objects and then pass the custom Comparator to the Stream.max() method.

Find Youngest Employee from a List
```
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
 
public class MaxDateExample 
{
    public static void main(final String[] args) 
    {
        Comparator<Employee> employeeAgeComparator = Comparator
                            .comparing(Employee::getDateOfBirth);
 
        Employee youngestEmployee = getEmployeeList().stream()
                                    .max(employeeAgeComparator)
                                    .get();
 
        System.out.println(youngestEmployee); //Prints Employee 'D'
    }
 
    private static List<Employee> getEmployeeList() 
    {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "A", LocalDate.of(1991, 1, 1), 30000));
        empList.add(new Employee(2, "B", LocalDate.of(1976, 7, 9), 30000));
        empList.add(new Employee(3, "C", LocalDate.of(1992, 8, 1), 50000));
        empList.add(new Employee(4, "D", LocalDate.of(2001, 3, 11), 50000));
        return empList;
    }
}
```
> Program Output:
```
Employee [id=4, name=D, dateOfBirth=2001-03-11, salary=50000.0]
```
In this way, we can get a custom object from a List of objects while comparing the date values from one of its fields.

</details>
<details>
<summary><b>2.4 Find, Count and Remove Duplicates</b></summary>
	
# Java Stream – Find, Count and Remove Duplicates

Few simple examples to find and count the duplicates in a Stream and remove those duplicates since Java 8. We will use ArrayList to provide a Stream of elements including duplicates.

### 1. Stream.distinct() – To Remove Duplicates
#### 1.1. Remove Duplicate Strings
The distinct() method returns a Stream consisting of the distinct elements of the given stream. The object equality is checked according to the object’s equals() method.

Find all distinct strings
```java
List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

// Get list without duplicates
List<String> distinctItems = list.stream()
                                    .distinct()
                                    .collect(Collectors.toList());

// Let's verify distinct elements
System.out.println(distinctItems);
```
Program output:

Output
[A, B, C, D]

#### 1.2. Remove Duplicate Custom Objects
The same syntax can be used to remove the duplicate objects from List. To do so, we need to be very careful about the object’s equals() method, because it will decide if an object is duplicate or unique.

Consider the below example where two Person instances are considered equal if both have the same id value.
```java
public class Person 
{
    private Integer id;
    private String fname;
    private String lname;
}
```
Let us see an example of how we can remove duplicate Person objects from a List.
```java
Get Distinct Objects using Default Equality
//Add some random persons
Collection<Person> list = Arrays.asList(p1, p2, p3, p4, p5, p6);

// Get distinct people by id
List<Person> distinctElements = list.stream()
        .distinct()
        .collect( Collectors.toList() );
```
To find all unique objects using a different equality condition, we can take the help of the following distinctByKey() method. For example, we are finding all unique objects by Person’s full name.
```java
Get Distinct Objects using Custom Equality
//Add some random persons
List<Person> list = Arrays.asList(p1, p2, p3, p4, p5, p6);

// Get distinct people by full name
List<Person> distinctPeople = list.stream()
              .filter( distinctByKey(p -> p.getFname() + " " + p.getLname()) )
              .collect( Collectors.toList() );

//********The distinctByKey() method need to be created**********

public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
{
  Map<Object, Boolean> map = new ConcurrentHashMap<>();
  return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
}
```
### 2. Collectors.toSet() – To Remove Duplicates
Another simple and very useful way is to store all the elements in a Set. Sets, by definition, store only distinct elements. Note that a Set stores distinct items by comparing the objects with equals() method.

Here, we cannot compare the objects using a custom equality condition.
```java
ArrayList<Integer> numbersList
= new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
 
Set<Integer> setWithoutDuplicates = numbersList.stream()
.collect(Collectors.toSet());
 
System.out.println(setWithoutDuplicates);
```
Program output:

[1, 2, 3, 4, 5, 6, 7, 8]

### 3. Collectors.toMap() – To Count Duplicates
Sometimes, we are interested in finding out which elements are duplicates and how many times they appeared in the original list. We can use a Map to store this information.

We have to iterate over the list, put the element as the Map key, and all its occurrences in the Map value.
```java
// ArrayList with duplicate elements
ArrayList<Integer> numbersList
= new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
 
Map<Integer, Long> elementCountMap = numbersList.stream()
.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
 
System.out.println(elementCountMap);
```
> Program output:

{1=2, 2=1, 3=3, 4=1, 5=1, 6=3, 7=1, 8=1}

</details>
<details>
<summary><b>2.5 Applying Multiple Conditions on Java Streams</b></summary>
	
# Java Stream Filter on Multiple Conditions using Predicates

Learn to filter the items of a stream using multiple conditions similar to nested if-else conditions with for-loop. Also, learn to process the filtered items by either collecting to a new List or calling a method on each item matching the provided filter conditions.

### 1. Creating Predicates using Lambda Expressions
In Java streams API, a filter is a Predicate instance (boolean-valued function). It can be thought of as an operator or function that returns a value that is either true or false.

I will recommend to create one predicate per filter condition always and giving it a meaningful name. Later, we can combine multiple such simple filters to create a complex predicate representing multiple conditions that we need to apply.

Use negate() to write the reverse/negative conditions so that a single predicate may serve true and false – both scenarios.
Use and() to combine two predicates for a logical AND operation.
Use or() to combine two predicates for a logical OR operation.

How to Create Predicates
```java
Predicate<Integer> isEven = i -> i%2 == 0;
Predicate<Integer> isOdd = i -> i%2 == 1;

//Or use negate() to reverse the condition
Predicate<Integer> isOdd = isEven.negate();  
 
Predicate<Employee> isAdult = e -> e.getAge() > 18;
Predicate<Account> isActive = a -> a.getStatus() == AccountStatus.ACTIVE;

Predicate<Employee> isAdultAndActive = isAdult.and(isActive);
Predicate<Employee> isAdultOrActive = isAdult.or(isActive);
Predicate<Employee> isAdultAndInactive = isAdult.and(isActive.negate());
```
Similarly, we can create as many simple and complex predicates as we require.

### 2. Using Predicates for Multiple Conditions
After creating simple and complex predicates, we can use them with Stream.filter() method.

The given below is a Java program to filter an employees list with multiple different conditions using predicates.

Multiple filters example
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
 
public class Main 
{
    public static void main(String[] args) 
    {
        List<Employee> employeeList = getEmployeesFromDataSource();
         
        //filter 1
        Predicate<Employee> isEmployeeActive = e -> e.getStatus() == EmployeeStatus.ACTIVE;
 
        //filter2
        Predicate<Employee> isAccountActive = e -> e.getAccount().getStatus() == AccountStatus.ACTIVE;
         
        //Active employees
        String result = employeeList.stream()
                .filter(isEmployeeActive)
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));
         
        System.out.println("Active employees = " + result);
         
        //Active employees with active accounts
        result = employeeList.stream()
                .filter(isEmployeeActive.and(isAccountActive))
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));
         
        System.out.println("Active employees with active accounts = " + result);
         
        //Active employees with inactive accounts
        result = employeeList.stream()
                .filter(isEmployeeActive.and(isAccountActive.negate()))
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));
         
        System.out.println("Active employees with inactive accounts = " + result);
         
        //Inactive employees with inactive accounts
        result = employeeList.stream()
                .filter(isEmployeeActive.negate().and(isAccountActive.negate()))
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));
         
        System.out.println("Inactive employees with inactive accounts = " + result);
    }
     
    private static List<Employee> getEmployeesFromDataSource() {
        List<Employee> employeeList = new ArrayList<>();
         
        employeeList.add(new Employee(1L, "A", "AA", EmployeeStatus.ACTIVE, 
            new Account(1001L, "Saving - 1001", "Saving", AccountStatus.ACTIVE)));
        employeeList.add(new Employee(2L, "B", "BB", EmployeeStatus.ACTIVE, 
            new Account(1002L, "Checking - 1002", "Checking", AccountStatus.ACTIVE)));
        employeeList.add(new Employee(3L, "C", "CC", EmployeeStatus.ACTIVE, 
            new Account(1003L, "Deposit - 1003", "Deposit", AccountStatus.ACTIVE)));
        employeeList.add(new Employee(4L, "D", "DD", EmployeeStatus.ACTIVE, 
            new Account(1004L, "Saving - 1004", "Saving", AccountStatus.INACTIVE)));
        employeeList.add(new Employee(5L, "E", "EE", EmployeeStatus.ACTIVE, 
            new Account(1005L, "Checking - 1005", "Checking", AccountStatus.INACTIVE)));
        employeeList.add(new Employee(6L, "F", "FF", EmployeeStatus.ACTIVE, 
            new Account(1006L, "Deposit - 1006", "Deposit", AccountStatus.BLOCKED)));
         
        return employeeList;
    }
}
```
Program output.

Output
Active employees = [1,2,3,4,5,6]
Active employees with active accounts = [1,2,3]
Active employees with inactive accounts = [4,5,6]
Inactive employees with inactive accounts = []

Clearly, we can create many more such simple predicates, and then we can combine them to make more complex conditions. These complex predicates can help in filtering the streams and getting the desired output.

</details>
<details>
<summary><b>2.6 Sorting a Stream by Multiple Fields</b></summary>
	
# Sorting a Stream by Multiple Fields in Java

Learn to sort the streams of objects by multiple fields using Comparators and Comparator.thenComparing() method. This method returns a lexicographic-order comparator with another comparator. It gives the same effect as SQL GROUP BY clause.

### 1. Creating Comparators for Multiple Fields
To sort on multiple fields, we must first create simple comparators for each field on which we want to sort the stream items. Then we chain these Comparator instances in the desired order to give GROUP BY effect on complete sorting behavior.

Note that Comparator provides a few other methods that we can use if they fit in the requirements.
```java
thenComparing(keyExtractor) :
thenComparing(comparator)
thenComparing(keyExtractor, comparator)
thenComparingDouble(keyExtractor)
thenComparingInt(keyExtractor)
thenComparingLong(keyExtractor)
Joining Multiple Comparators
//first name comparator
Comparator<Employee> compareByFirstName = Comparator.comparing( Employee::getFirstName );
 
//last name comparator
Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getLastName );
 
//Compare by first name and then last name (multiple fields)
Comparator<Employee> compareByFullName = compareByFirstName.thenComparing(compareByLastName);
 
//Using Comparator - pseudo code
list.stream().sorted( comparator ).collect();
```
### 2. Sorting with Complex Comparator
Given below is an example of using thenComparing() to create Comparator which is capable of sorting the employees’ list by their first name and last name.
```java
Sort by first name and last name
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
 
public class Main 
{
  public static void main(String[] args) 
  {
    ArrayList<Employee> employees = getUnsortedEmployeeList();
     
    //Compare by first name and then last name
    Comparator<Employee> compareByName = Comparator
                        .comparing(Employee::getFirstName)
                        .thenComparing(Employee::getLastName);
     
    List<Employee> sortedEmployees = employees.stream()
                    .sorted(compareByName)
                    .collect(Collectors.toList());
     
    System.out.println(sortedEmployees);
  }
 
  private static ArrayList<Employee> getUnsortedEmployeeList() 
  {
    ArrayList<Employee> list = new ArrayList<>();
    list.add( new Employee(2l, "Lokesh", "Gupta") );
    list.add( new Employee(1l, "Alex", "Gussin") );
    list.add( new Employee(4l, "Brian", "Sux") );
    list.add( new Employee(5l, "Neon", "Piper") );
    list.add( new Employee(3l, "David", "Beckham") );
    list.add( new Employee(7l, "Alex", "Beckham") );
    list.add( new Employee(6l, "Brian", "Suxena") );
        return list;
  }
}
```
Program Output.

Output
[E[id=7, firstName=Alex,  lastName=Beckham], 
E [id=1, firstName=Alex,  lastName=Gussin], 
E [id=4, firstName=Brian,   lastName=Sux], 
E [id=6, firstName=Brian,   lastName=Suxena], 
E [id=3, firstName=David,   lastName=Beckham], 
E [id=2, firstName=Lokesh,  lastName=Gupta], 
E [id=5, firstName=Neon,  lastName=Piper]]

### 3. Conclusion
Similar to the chained predicates, we can combine any number of Comparators to create any complex sorting logic and sort the Stream items with it.

</details>
<details>
<summary><b>2.7 Sorting Streams in Java</b></summary>
	
# How to Sort a Stream in Java

Learn to sort streams of numbers, strings and custom types in ascending (natural order) and descending orders (reverse order) in Java.

### 1. Basics of Sorting the Streams
The Stream interface provides the sorted() method that returns a stream consisting of the elements of a given stream, sorted according to the natural order. It is an overloaded method:

Stream sorted(): sorted according to natural order.
Stream sorted(comparator): sorted according to the provided Comparator.
Note that both methods are intermediate operations so we still need to call a terminal operation to trigger the sorting.

Pseudo Code
```java
Stream<Person> unsortedStream;

//Default Ordering

List<Person> sortedList = unsortedStream.sorted()
    .collect(Collectors.toList());

//Order by First Name

List<Person> sortedList = unsortedStream.sorted(Person::firstName)
    .collect(Collectors.toList());
```
### 2. Sorting Custom Types
For demonstration purposes, we are using the custom class Person. This class has only three fields: id, first name and last name.

By default, two persons are considered equal if their id is equal.

Default sorting is by id field

```java
import java.util.Objects;

public class Person implements Comparable<Person> { 

    private Integer id;
    private String fname;
    private String lname;

    //Constructor, Setters and Getters are hidden for brevity

    @Override
    public int compareTo(Person p) {
        return this.getId().compareTo(p.getId());
    }
}
```
#### 2.1. Default Sorting
By default, the sorted() method uses the Comparable.compareTo() method implemented by the Person class.

As Person class compares the instances using the value of id field, so when we sort the stream of Person instances – we get the instances sorted by id. The default sorting is in the natural order.

Natural Sorting

```java
Stream<Person> personStream = getPersonStream();

// Ascending Order
personStream.sorted() 
            .forEach(System.out::println);
```
Output
Person [id=1, fname=Lokesh, lname=Gupta]
Person [id=2, fname=Lokesh, lname=Gupta]
Person [id=3, fname=Brian, lname=Clooney]
Person [id=4, fname=Brian, lname=Clooney]
Person [id=5, fname=Lokesh, lname=Gupta]

The same is true for reverse sorting as well. we can sort the Person instances in reverse order by passing the reverse comparator obtained from Comparator.reverseOrder() method into the sorted() method.

Reverse Ordering
```java
Stream<Person> personStream = getPersonStream();

// Reverse Order
personStream.sorted(Comparator.reverseOrder()) 
            .forEach(System.out::println);
```
Output
Person [id=6, fname=Alex, lname=Kolen]
Person [id=5, fname=Lokesh, lname=Gupta]
Person [id=4, fname=Brian, lname=Clooney]
Person [id=3, fname=Brian, lname=Clooney]
Person [id=2, fname=Lokesh, lname=Gupta]
Person [id=1, fname=Lokesh, lname=Gupta]

#### 2.2. Custom Sorting
What if we want to sort the Person instances by their first name. The default sort does not support it, so we need to create our custom comparator.

```java
FirstNameSorter.java
import java.util.Comparator;
import com.howtodoinjava.core.streams.Person;

public class FirstNameSorter implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getFname() == null || p2.getFname() == null) {
            throw new IllegalArgumentException("Unnamed Person found in the system");
        }
       return p1.getFname().compareToIgnoreCase(p2.getFname());
    }
}
```
Now pass the FirstNameSorter instance to the sorted() method. This time, sorting will use the compare() method written in FirstNameSorter.
```java
Sorting with first name
List<Person> sortedList = personStream.sorted(new FirstNameSorter())
    .collect(Collectors.toList());

sortedList.forEach(System.out::println);
```
Output
Person [id=6, fname=Alex, lname=Kolen]
Person [id=4, fname=Brian, lname=Clooney]
Person [id=3, fname=Brian, lname=Clooney]
Person [id=1, fname=Lokesh, lname=Gupta]
Person [id=5, fname=Lokesh, lname=Gupta]
Person [id=2, fname=Lokesh, lname=Gupta]

Similarly, to sort the instances by the first name in reverse order, we can reverse any comparator using its reverse() method.

Reverse Sorting by First Name
```java
List<Person> reverseSortedList = personStream.sorted( new FirstNameSorter().reversed() )
                                        .collect(Collectors.toList());

reverseSortedList.forEach(System.out::println);
```
#### 2.3. Class cannot be cast to class java.lang.Comparable
Please note that if our custom class Person does not implement the Comparable interface then we will get the ClassCastException in runtime while doing the natural sorting.

Exception in thread "main" java.lang.ClassCastException: class com.howtodoinjava.core.streams.sort.Person
 cannot be cast to class java.lang.Comparable (com.howtodoinjava.core.streams.sort.Person is in unnamed
 module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	at java.base/java.util.Comparators $NaturalOrderComparator.compare(Comparators.java:47)
	at java.base/java.util.TimSort. countRunAndMakeAscending(TimSort.java:355)
	at java.base/java.util.TimSort. sort(TimSort.java:220)
	at java.base/java.util.Arrays. sort(Arrays.java:1307)

### 3. Sorting Stream of Numbers
#### 3.1. Ascending Order
Java programs to sort a stream of numbers using Stream.sorted() method.

Ascending sort example
```java
import java.util.stream.Stream;

public class Main
{
	public static void main(String[] args)
    {
		Stream<Integer> numStream = Stream.of(1,3,5,4,2);

		numStream.sorted()
				 .forEach(System.out::println);
    }
}
```
Program output.

Output
1
2
3
4
5

#### 3.2. Descending Order
To sort in reverse order, use Comparator.reverseOrder() in sorted() method.

Descending sort example
```java
import java.util.Comparator;
import java.util.stream.Stream;

public class Main
{
	public static void main(String[] args)
    {
		Stream<Integer> numStream = Stream.of(1,3,5,4,2);

		numStream.sorted( Comparator.reverseOrder() )
				 .forEach(System.out::println);
    }
}
```
### 4. Sorting Stream of Strings
Java programs to sort a stream of strings using Stream.sorted() method in ascending and descending order.

Sort stream of strings
```java
Stream<String> wordStream = Stream.of("A","C","E","B","D");

wordStream.sorted()									//ascending
		  .forEach(System.out::println);			

wordStream.sorted( Comparator.reverseOrder() )		//descending
		  .forEach(System.out::println);
```
Program output.

Output
A B C D E

E D C B A

- Pojo class
```java
public class Employee {

	private int id;
	private String name;
	private String dept;
	private long salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, String dept, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
```
- DAO layer

```java
import java.util.ArrayList;
import java.util.List;
public class DataBase {

	public static List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(176, "Roshan", "IT", 600000));
		list.add(new Employee(388, "Bikash", "CIVIL", 900000));
		list.add(new Employee(470, "Bimal", "DEFENCE", 500000));
		list.add(new Employee(624, "Sourav", "CORE", 400000));
		list.add(new Employee(176, "Prakash", "SOCIAL", 1200000));
		return list;
	}
}
```
- Sort a List using lambda:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);

		List<Employee> employees = DataBase.getEmployees();

		/*Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());// ascending
			}
		});*/
				
		Collections.sort(employees, ( o1,  o2) ->(int) (o1.getSalary() - o2.getSalary()));

		//System.out.println(employees);	
		
		//employees.stream().sorted(( o1,  o2) ->(int) (o2.getSalary() -
		//					o1.getSalary())).forEach(System.out::println);
		
		//employees.stream().sorted(Comparator.comparing(emp->emp.getSalary())).forEach(System.out::println);
		
		employees.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);

		/*
		 * Collections.sort(list);//ASSENDING Collections.reverse(list);
		 * System.out.println(list);
		 * 
		 * list.stream().sorted(Comparator.reverseOrder()).forEach(s->System.out.println
		 * (s));//descending
		 */
	}
}
```
- Sort a Map using lambda:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortMapDemo {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

		System.out.println(employeeMap);

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

		/*
		 * for (Entry<String, Integer> entry : entries) {
		 * System.out.println(entry.getKey() + "   " + entry.getValue()); }
		 */

		// map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("****************************");
		// map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed()))
				.forEach(System.out::println);

	}
}
```
</details>
<details>
<summary><b>2.8 Chaining Multiple Predicates in Java</b></summary>
	
# Chaining Multiple Predicates in Java

Learn to combine multiple Predicate instances aka chained predicates and perform ‘logical AND‘ and ‘logical OR‘ operations on the Stream filter() operation. Chained predicates are useful in filtering the stream items for multiple conditions.

### 1. How to Use Predicates
Predicates are used for filtering the items from a stream. For example, if a have a stream of strings and want to find all the strings starting with ‘A‘, we can create a Predicate using the lambda expression.

Predicate to filter all strings starting with A
```java
Predicate<String> startsWithA = s -> s.startsWith("A");
```
Now use this predicate with Stream.filter() method.

Using Predicate to Filter Stream Items
```java
List<String> list = Arrays.asList("Aa", "Bb", "Cc", "Dd", "Ab", "Bc");

Predicate<String> startsWithA = s -> s.startsWith("A");

List<String> items = list.stream()
  .filter(startsWithA)
  .collect(Collectors.toList());

System.out.println(items);
````
### 2. Predicate Chain
The first example is of a simple predicate or single condition. In real-world applications, we may be filtering the items on multiple conditions.

#### 2.1. Simple Example
A good way to apply such complex conditions is by combining multiple simple conditions to make one complex condition.

For example, if we want to get all strings that start with either A or B but it must not contain the letter ‘c‘. Lets create the Predicate for this:

All strings that start with either A or B but it must not contain the letter c
```java
Predicate<String> startsWithA = s -> s.startsWith("A");
Predicate<String> startsWithB = s -> s.startsWith("B");
Predicate<String> notContainsC = s -> !s.contains("c");

Predicate<String> complexPredicate = startsWithA.or(startsWithB)
  .and(notContainsC);
```
Note that for creating the negative conditions, we can use the method negate() on the position predicates.

negatedPredicate and notContainsC have the same effect
```java
Predicate<String> containsC = s -> s.contains("c");
Predicate<String> negatedPredicate = containsC.negate();

Predicate<String> notContainsC = s -> !s.contains("c");
```
In the above example, negatedPredicate and notContainsC will have the same effect on the filter() operation.

#### 2.2. The and() Method for Logical AND Operation
The and() method returns a composed predicate that represents a short-circuiting logical AND of given predicate and another.
When evaluating the composed predicate, if the first predicate is false, then the other predicate is not evaluated.
Any exceptions thrown during evaluation of either predicate are relayed to the caller; if evaluation of first predicate throws an exception, the other predicate will not be evaluated.
In the given example, we are finding all the employees whose id is less than 4 and salary is greater than 200.

id is less than 4 AND salary is greater than 200
```java
List<Employee> employeesList = Arrays.asList(
          new Employee(1, "Alex", 100),
          new Employee(2, "Brian", 200),
          new Employee(3, "Charles", 300),
          new Employee(4, "David", 400),
          new Employee(5, "Edward", 500),
          new Employee(6, "Frank", 600)
        );

Predicate<Employee> idLessThan4 = e -> e.getId() < 4;

Predicate<Employee> salaryGreaterThan200 = e -> e.getSalary() > 200;

List<Employee> filteredEmployees = employeesList.stream()
    .filter( idLessThan4.and( salaryGreaterThan200 ) )
    .collect(Collectors.toList());

System.out.println(filteredEmployees);
```
Program Output.

Output
[Employee [id=3, name=Charles, salary=300.0]]

#### 2.3. The or() Method for Logical OR Operation
The Predicate.or() method returns a composed predicate that represents a short-circuiting logical OR of given predicate and another predicate.
When evaluating the composed predicate, if the first predicate is true, then the other predicate is not evaluated.
Any exceptions thrown during evaluation of either predicate are relayed to the caller; if evaluation of first predicate throws an exception, the other predicate will not be evaluated.
In the given example, we are finding all the employees whose id is less than 2 or salary is greater than 500.

id is less than 2 OR salary is greater than 500
```java
List<Employee> employeesList = Arrays.asList(
              new Employee(1, "Alex", 100),
              new Employee(2, "Brian", 200),
              new Employee(3, "Charles", 300),
              new Employee(4, "David", 400),
              new Employee(5, "Edward", 500),
              new Employee(6, "Frank", 600)
            );

Predicate<Employee> idLessThan2 = e -> e.getId() < 2;

Predicate<Employee> salaryGreaterThan500 = e -> e.getSalary() > 500;

List<Employee> filteredEmployees = employeesList.stream()
        .filter( idLessThan2.or( salaryGreaterThan500 ) )
        .collect(Collectors.toList());

System.out.println(filteredEmployees);
```
Program output.

Output
[Employee [id=1, name=Alex, salary=100.0], 
Employee [id=6, name=Frank, salary=600.0]]

### 3. Conclusion
In this Java tutorial, we learned to create simple predicates and use them to filter the Stream items. Then we learned to combine multiple simple predicates to create complex predicates using and(), or() and negate() methods.

</details>
<details>
<summary><b>2.9 Negating a Predicate</b></summary>
	
# Negating a Predicate in Java

Learn to create a Predicate with the negating effect that will match all the elements not matching the original predicate. The negated predicate acts as a pass function and selects all the elements from the stream that were filtered out by the original predicate.

### 1. Predicate negate() Method
The Predicate.negate() method returns the logical negation of an existing predicate.
```java
Predicate<Integer> isEven = i -> i % 2 == 0;
     
Predicate<Integer> isOdd = isEven.negate();

Use these predicates as follows with the Stream filter() method.

List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 
Predicate<Integer> isEven = i -> i % 2 == 0;
 
Predicate<Integer> isOdd = Predicate.not( isEven );

List<Integer> evenNumbers = list.stream()
      .filter(isEven)
      .collect(Collectors.toList());
 
List<Integer> oddNumbers = list.stream()
    .filter(isOdd)
    .collect(Collectors.toList());
```
### 2. Predicate not() Method – Java 11
In Java 11, Predicate class has a new method not(). It returns a Predicate that is the negation of the supplied predicate.

Internally, this is accomplished by returning the result of the calling predicate.negate().
```java
Predicate<Integer> isEven = i -> i % 2 == 0;
     
Predicate<Integer> isOdd = Predicate.not( isEven );
```
</details>
<details>
<summary><b>2.10 Finding Max and Min from List using Streams</b></summary>
	
# Finding Max and Min from List using Streams

Learn to find min and max values from a List using Stream API e.g. a date, number, Char, String or an object. We will use the Comparator.comparing() for custom comparison logic.

### 1. Overview
We will be using the following functions to find the max and min values from the stream:

Stream.max(comparator) : It is a terminal operation that returns the maximum element of the stream according to the provided Comparator.
Stream.min(comparator) : It is a terminal operation that returns the minimum element of the stream according to the provided Comparator.
### 2. Finding Min or Max Date
To get max or min date from a stream of dates, you can use Comparator.comparing( LocalDate::toEpochDay ) Comparator. The toEpochDay() function returns the count of days since epoch i.e. 1970-01-01.
```java
LocalDate start = LocalDate.now();
LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
 
//Create stream of dates
List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());
 
// Get Min or Max Date
LocalDate maxDate = dates.stream()
              .max( Comparator.comparing( LocalDate::toEpochDay ) )
              .get();
 
LocalDate minDate = dates.stream()
              .min( Comparator.comparing( LocalDate::toEpochDay ) )
              .get();
```
Use the above program to find the earliest date or latest date from a list of dates.

### 3. Find Min or Max Number
To find min and max numbers from the stream of numbers, use Comparator.comparing( Integer::valueOf ) like comparators. The below example is for a stream of Integers.
```java
// Get Min or Max Number
Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
          .max(Comparator.comparing(Integer::valueOf))
          .get();
 
Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
          .min(Comparator.comparing(Integer::valueOf))
          .get();
```
### 4. Find Min or Max Char or String
To find min and max string or char from a stream of chars, use Comparator.comparing( String::valueOf ) like comparators.
```java
// Get Min or Max String/Char
String maxChar = Stream.of("H", "T", "D", "I", "J")
            .max(Comparator.comparing(String::valueOf))
            .get();
 
String minChar = Stream.of("H", "T", "D", "I", "J")
            .min(Comparator.comparing(String::valueOf))
            .get();
```
### 5. Find Min or Max Object by Field Value
The Object comparison involves creating our own custom comparator, first. For example, if I want to get the youngest employee from a stream of Employee objects, then my comparator will look like Comparator.comparing(Employee::getAge). Now use this comparator to get max or min employee object.

Java program to find max or min employee object by their age.
```java
Find max or min object by object property
List<Employee> employees = new ArrayList<Employee>();

//add few employees
 
Comparator<Employee> comparator = Comparator.comparing( Employee::getAge );
 
// Get Min or Max Object
Employee minObject = employees.stream().min(comparator).get();
Employee maxObject = employees.stream().max(comparator).get();
```
### 6. Conclusion
In this tutorial, we learned to find max value or min value from a list using the Java stream API and lambda expression. We also learned to find max or min objects such as max Date or String.

</details>
<details>
<summary><b>2.11 Java Stream count() Matches with filter()</b></summary>
	
# Java Stream count() Matches with filter()

Learn to count the matching items in the Stream that are passed by a specified filter expression. To count the items, we can use the following two methods and both are terminal operations and will give the same result.
```java
Stream.count()
Stream.collect(Collectors.counting())
```
### 1. Stream count() API
The Stream interface has a default method called count() that returns a long value indicating the number of matching items in the stream.
```java
long count()

To use the count() method, call it on any Stream instance.

Stream s = ...;

s.count();
//or
s.collect(Collectors.counting());
```
### 2. Counting Matches in Stream
Example 1: Counting all items in the Stream
In this example, we are counting the number of elements in different kinds of streams such as IntStream, LongStream.
```java
long count = Stream.of("how","to","do","in","java").count();	//5
 
long count = IntStream.of(1,2,3,4,5,6,7,8,9).count();   //9
```
Example 2: Counting items matching to Stream filter()
To count the matching items, we need to apply a filter expression or predicate to filter that will find the matching items and then we can use count() API to count the items.

In the given example, we are counting all the even numbers in the stream.
```java
long count = LongStream.of(1,2,3,4,5,6,7,8,9)
            .filter(i -> i%2 == 0)
            .count();
            //or
            //.collect(Collectors.counting())
```
</details>
<details>
<summary><b>2.12 Filter a Map by List of Keys</b></summary>
	
# How to Filter a Map by List of Keys in Java

Learn to filter a Map by keys or values using forEach() loop and Stream.filter() API in Java 8.

### 1. Setup
For the code examples, we will use the following Map of users. Map keys are Integer types, and Map values are User instances.
```java
Map<Integer, User> usersMap = Map.of(
    1, new User(1, "Alex"),
    2, new User(2, "Allen"),
    3, new User(3, "Brian"),
    4, new User(4, "Bob"),
    5, new User(5, "Charles"),
    6, new User(6, "David"),
    8, new User(7, "Don"),
    9, new User(8, "Dave"));
```
We will filter the Map against the following List of keys. The List can contain anything. We are storing user ids to keep the examples easy to understand.
```java
List<Integer> idList = List.of(1,3,5,7);
```
### 2. Filter a Map by List of Keys
Suppose we have a List of ids of users and we want to get the submap consisting of the users whose id is present in the List.

To do so, we will iterate over the Map‘s EntrySet. Then we will check for the id to be present in the List in the filter() function. Finally, we will collect the matching entry sets in a new Map using Collectors.toUnmodifiableMap().
```java
Map<Integer, User> filteredMap = usersMap.entrySet()
    .stream()
    .filter(entry -> idList.contains(entry.getKey()))
    .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

System.out.println(filteredMap);
```
The program output.

{1=User(id=1, name=Alex), 3=User(id=3, name=Brian), 5=User(id=5, name=Charles), 7=User(id=7, name=Don)}

If we want to change the evaluation criteria then we need to change the expression in the filter() function. For example, if we want to check for the User’s id into the List then change the filter() expression to as follows:

...
.filter(entry -> idList.contains(entry.getValue().getId()))
...

### 3. Filter a Map and Collect Values into a List
Another usecase can be when we want to filter the Map and collect values into a List for entrysets whose key is present in the List.
```java
List<User> usersList = usersMap.values()
    .stream()
    .filter(user -> idList.contains(user.getId()))
    .collect(Collectors.toUnmodifiableList());

System.out.println(usersList);
```
The program output.

[User(id=1, name=Alex), User(id=3, name=Brian), User(id=5, name=Charles), User(id=7, name=Don)]

### 4. Filter a Map using forEach()
We can also filter a Map using forEach() loop. The forEach loop takes a Consumer action that accepts a single input argument and returns no result.

In our case, we will pass the Map.Entry to the Consumer and match the key or value from the List item. If the Entry matches the condition, we will add the entry.getValue() to a new List.
```java
List<User> usersList = new ArrayList<>();
    
usersMap.entrySet().forEach( entry -> {
  if(idList.contains(entry.getValue().getId())) {
    usersList.add(entry.getValue());
  }
});

System.out.println(usersList);
```
The program output.

[User(id=1, name=Alex), User(id=3, name=Brian), User(id=5, name=Charles), User(id=7, name=Don)]

### 5. Conclusion
In this Java tutorial, we learned to filter a HashMap by keys or values and collect the matching Entry instances into a submap. We also learned to collect the values in a List after filtering the Map keys against a List using Stream.filter() and forEach() APIs.

</details>

</details>

<details>
<summary><b>3. Stream Collectors</b></summary>

 <details>
<summary><b>3.1 Stream Collectors</b></summary>
	 
# Java 8 Collectors

Java 8 Collectors mainly consist of three things – Stream.collect() method, Collector interface and Collectors class. 

- collect() method is a terminal operation in Stream interface.

- Collector is an interface in java.util.stream package. 

- Collectors class, also a member of java.util.stream package, is an utility class containing many static methods which perform some common reduction operations. 

Let’s go through them one by one.

### 1) Stream.collect() Method
collect() method is a terminal operation in Stream interface.

It is a special case of reduction operation called mutable reduction operation because it returns mutable result container such as List, Set or Map according to supplied Collector.
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
 
public class CollectorsExamples 
{
    public static void main(String[] args) 
    {
        List<Integer> numbers = Arrays.asList(8, 2, 5, 7, 3, 6);
         
        //collect() method returning List of OddNumbers
         
        List<Integer> oddNumbers = numbers.stream().filter(i -> i%2 != 0).collect(Collectors.toList());
         
        System.out.println(oddNumbers);
         
        //OUTPUT : [5, 7, 3]
    }
}
```
### 2) java.util.stream.Collector Interface

java.util.stream.Collector interface contains four functions that work together to accumulate input elements into a mutable result container and optionally performs a final transformation on the result. 

Those four functions are,

a) Supplier() : A function that creates and returns a new mutable result container.
b) accumulator() : A function that accumulates a value into a mutable result container.
c) combiner() : A function that accepts two partial results and merges them.
d) finisher() : A function that performs final transformation from the intermediate accumulation type to the final result type.

### 3) java.util.stream.Collectors Class

java.util.stream.Collectors class contains static factory methods which perform some common reduction operations such as accumulating elements into Collection, 
finding min, max, average, sum of elements etc. 
All the methods of Collectors class return Collector type which will be supplied to collect() method as an argument.

# Java 8 Collectors

Let’s see Collectors class methods one by one.

In the below coding examples, we will be using following Student class and studentList.

Student Class :

```java
class Student
{
    String name;
     
    int id;
     
    String subject;
     
    double percentage;
     
    public Student(String name, int id, String subject, double percentage) 
    {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }
     
    public String getName() 
    {
        return name;
    }
     
    public int getId() 
    {
        return id;
    }
     
    public String getSubject() 
    {
        return subject;
    }
     
    public double getPercentage() 
    {
        return percentage;
    }
     
    @Override
    public String toString() 
    {
        return name+"-"+id+"-"+subject+"-"+percentage;
    }
}
```
studentList :
```java
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
```
### 3.1) Collectors.toList() :

It returns a Collector which collects all input elements into a new List.

Example : Collecting top 3 performing students into List
```java
List<Student> top3Students = studentList.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).collect(Collectors.toList());
         
System.out.println(top3Students);
```         
> //Output :
         
> //[Vijay-19-Mathematics-92.8, Zevin-12-Computer Science-91.2, Asif-16-Mathematics-89.4]

### 3.2) Collectors.toSet() :

It returns a Collector which collects all input elements into a new Set.

Example : Collecting subjects offered into Set.
```java
Set<String> subjects = studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
         
System.out.println(subjects);
```         
> //Output :
         
> //[Economics, Literature, Computer Science, Mathematics, History]

### 3.3) Collectors.toMap() :

This method returns a Collector which collects input elements into a Map whose keys and values are the result of applying mapping functions to input elements.

Example : Collecting name and percentage of each student into a Map
```java
Map<String, Double> namePercentageMap = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPercentage));
         
System.out.println(namePercentageMap);
```         
> //Output :
         
> //{Asif=89.4, Vijay=92.8, Zevin=91.2, Harry=71.9, Xiano=71.5, Nihira=84.6, Soumya=77.5, Mitshu=73.5, Harish=83.7, Paul=78.9}

### 3.4) Collectors.toCollection() :

This method returns a Collector which collects all input elements into a new Collection.

Example : Collecting first 3 students into LinkedList
```java
LinkedList<Student> studentLinkedList = studentList.stream().limit(3).collect(Collectors.toCollection(LinkedList::new));
         
System.out.println(studentLinkedList);
```         
> //Output :
         
> //[Paul-11-Economics-78.9, Zevin-12-Computer Science-91.2, Harish-13-History-83.7]

### 3.5) Collectors.joining() :

This method returns a Collector which concatenates input elements separated by the specified delimiter.

Example : Collecting the names of all students joined as a string
```java
String namesJoined = studentList.stream().map(Student::getName).collect(Collectors.joining(", "));
         
System.out.println(namesJoined);
```         
> //Output :
         
> //Paul, Zevin, Harish, Xiano, Soumya, Asif, Nihira, Mitshu, Vijay, Harry

### 3.6) Collectors.counting() :

It returns a Collector that counts number of input elements.

Example : Counting number of students.
```java
Long studentCount = studentList.stream().collect(Collectors.counting());
         
System.out.println(studentCount);
```         
> //Output : 10

### 3.7) Collectors.maxBy() :

This method returns a Collector that collects largest element in a stream according to supplied Comparator.

Example : Collecting highest percentage.
```java
Optional<Double> highPercentage = studentList.stream().map(Student::getPercentage).collect(Collectors.maxBy(Comparator.naturalOrder()));
         
System.out.println(highPercentage);
```         
> //Output : Optional[92.8]

### 3.8) Collectors.minBy() :

This method returns a Collector which collects smallest element in a stream according to supplied Comparator.

Example : Collecting lowest percentage.
```java
Optional<Double> lowPercentage = studentList.stream().map(Student::getPercentage).collect(Collectors.minBy(Comparator.naturalOrder()));
         
System.out.println(lowPercentage);
```         
> //Output : Optional[71.5]

### 3.9) summingInt(), summingLong(), summingDouble()

These methods returns a Collector which collects sum of all input elements.

Example : Collecting sum of percentages
```java
Double sumOfPercentages = studentList.stream().collect(Collectors.summingDouble(Student::getPercentage));
         
System.out.println(sumOfPercentages);
```         
> //Output : 815.0

### 3.10) averagingInt(), averagingLong(), averagingDouble()

These methods return a Collector which collects average of input elements.

Example : Collecting average percentage
```java
Double averagePercentage = studentList.stream().collect(Collectors.averagingDouble(Student::getPercentage));
         
System.out.println(averagePercentage);
```         
> //Output : 81.5

### 3.11) summarizingInt(), summarizingLong(), summarizingDouble()

These methods return a special class called Int/Long/ DoubleSummaryStatistics which contain statistical information like sum, max, min, average etc of input elements.

Example : Extracting highest, lowest and average of percentage of students
```java
DoubleSummaryStatistics studentStats = studentList.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
         
System.out.println("Highest Percentage : "+studentStats.getMax());
         
System.out.println("Lowest Percentage : "+studentStats.getMin());
         
System.out.println("Average Percentage : "+studentStats.getAverage());
```         
> //Output :
         
> //Highest Percentage : 92.8
> 
> //Lowest Percentage : 71.5
> 
> //Average Percentage : 81.5

### 3.12) Collectors.groupingBy() :

This method groups the input elements according supplied classifier and returns the results in a Map.

Example : Grouping the students by subject
```java
Map<String, List<Student>> studentsGroupedBySubject = studentList.stream().collect(Collectors.groupingBy(Student::getSubject));
         
System.out.println(studentsGroupedBySubject);
```         
> //Output :
         
> //{Economics=[Paul-11-Economics-78.9, Soumya-15-Economics-77.5],
> 
> // Literature=[Xiano-14-Literature-71.5],
> 
> // Computer Science=[Zevin-12-Computer Science-91.2, Nihira-17-Computer Science-84.6],
> 
> // Mathematics=[Asif-16-Mathematics-89.4, Vijay-19-Mathematics-92.8],
> 
> // History=[Harish-13-History-83.7, Mitshu-18-History-73.5, Harry-20-History-71.9]}

### 3.13) Collectors.partitioningBy() :

This method partitions the input elements according to supplied Predicate and returns a Map<Boolean, List<T>>. Under the true key, you will find elements which match given Predicate and under the false key, you will find the elements which doesn’t match given Predicate.

Example : Partitioning the students who got above 80.0% from who don’t.
```java
Map<Boolean, List<Student>> studentspartionedByPercentage = studentList.stream().collect(Collectors.partitioningBy(student -> student.getPercentage() > 80.0));
         
System.out.println(studentspartionedByPercentage);
```         
> //Output :
         
> // {false=[Paul-11-Economics-78.9, Xiano-14-Literature-71.5, Soumya-15-Economics-77.5, Mitshu-18-History-73.5, Harry-20-History-71.9],
> 
> //  true=[Zevin-12-Computer Science-91.2, Harish-13-History-83.7, Asif-16-Mathematics-89.4, Nihira-17-Computer Science-84.6, Vijay-19-Mathematics-92.8]}

### 3.14) Collectors.collectingAndThen() :

This is a special method which lets you to perform one more action on the result after collecting the result.

Example : Collecting first three students into List and making it unmodifiable
```java
List<Student> first3Students = studentList.stream().limit(3).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
         
System.out.println(first3Students);
```         
> //Output :
         
> //[Paul-11-Economics-78.9, Zevin-12-Computer Science-91.2, Harish-13-History-83.7]

</details>	 
<details>
<summary><b>3.2 Collecting Stream Items into List</b></summary>
 
# Java Collect Stream to List (with Examples)

Learn to collect the items from a Stream into a List using different ways in Java. We will compare these different techniques so we can decide the best way for any kind of scenario.

Method	List Attributes	Java Version
List<T> list = stream.toList();	Unmodifiable List	Java 16+
List<T> list = stream.collect(Collectors.toUnmodifiableList());	Unmodifiable List
Stream cannot have null values	Java 10+
List<T> list = stream.collect(Collectors.toList());	Modifiable List	Java 8+
LinkedList<T> list = stream.collect(Collectors.toCollection(LinkedList::new));	Mutable LinkedList	Java 8+
ArrayList<T> list = stream.collect(Collectors.toCollection(ArrayList::new));	Mutable ArrayList	Java 8+
### 1. Different Ways to Collect Stream Items into List
There are primarily three ways to collect stream items into a list. Let’s compare them.

#### 1.1. Stream.toList()
The toList() method has been added in Java 16. It is a default method that collects the stream items into an unmodifiable List.
The returned list is an implementation of Collections.unmodifiableList(new ArrayList<>(Arrays.asList(stream.toArray()))) where stream represents the underlying Stream of items.
The order of the items in the list will be same as the order in stream, if there is any.
As the returned List is unmodifiable; calls to any mutator method will always cause UnsupportedOperationException to be thrown.
It is a terminal operation.
```java
Stream<String> tokenStream = Stream.of("A", "B", "C", "D");

List<String> tokenList = tokenStream.toList();
```
#### 1.2. Stream.collect(Collectors.toUnmodifiableList())
This method has been added in Java 10. It is a terminal operation that collects the stream items into an unmodifiable List.
The returned list is an instance of Collections.unmodifiableList() that is filled with stream items using JDK internal APIs able to access private methods of the JDK classes without using the reflection. In this case, the unmodifiable list is an implementation of SharedSecrets.getJavaUtilCollectionAccess().listFromTrustedArray(list.toArray()) where the list is an intermediate and mutable list of stream items.
The List does not allow the null values and the whole operation will throw the NullPointerException if there is a null value in the stream.
The order of items in the list is the same as the order of items in the stream, if there is any.
```java
Stream<String> tokenStream = Stream.of("A", "B", "C", "D");

List<String> tokenList = tokenStream.collect(Collectors.toUnmodifiableList());
```
#### 1.3. Stream.collect(Collectors.toList())
This method has been added in Java 8, along with the original Stream API. It is a terminal operation that collects the stream items into a mutable List.
The returned list is an instance of ArrayList class.
Similar to other versions, the order of the items in the mutable list will be same as the order in stream, if there is any.
```java
Stream<String> tokenStream = Stream.of("A", "B", "C", "D");

List<String> tokenList = tokenStream.collect(Collectors.toList());
```
### 2. Collecting Stream into LinkedList
Use the Collectors.toCollection(LinkedList::new) API along with Stream.collect() API for collecting the Stream items into a LinkedList.
```java
Stream<String> tokenStream = Arrays.asList("A", "B", "C", "D").stream();
     
List<String> tokenList = tokenStream
                .collect(Collectors.toCollection(LinkedList::new));
```
### 3. Filtering a Stream and Collect Items into a List
Sometimes we need to find only specific items from the Stream and then add only those items to List. Here, we can use Stream.filter() method to pass a predicate that will return only those items which match the given pre-condition.

In the given example, we are filtering all employees whose salary is less than 400. Then we are collecting those employees into a List.
```java
Stream<Employee> employeeStream = Stream.of(
          new Employee(1, "A", 100),
          new Employee(2, "B", 200),
          new Employee(3, "C", 300),
          new Employee(4, "D", 400),
          new Employee(5, "E", 500),
          new Employee(6, "F", 600));
 
List<Employee> employeeList = employeeStream
        .filter(e -> e.getSalary() < 400)
        .collect(Collectors.toList());
```
### 4. Collect Items from Infinite Stream into List
To convert an infinite stream into a list, we must limit the stream to a finite number of elements. Given example will work in the case of a stream of primitives.
```java
IntStream infiniteNumberStream = IntStream.iterate(1, i -> i+1);

List<Integer> integerlist = infiniteNumberStream.limit(10)
        .boxed()
        .collect(Collectors.toList());
```
### 5. Conclusion
In this tutorial, we learned the different ways to work with streams and collect the stream items in a List.

As a general guideline, we can use Stream.toList() for unmodifiable lists, and use the Stream.collect(Collectors.toList()) for modifiable lists.

To collect items in any other List types, we must use the Stream.collect(Collectors.toCollection(LinkedList::new)) version of the solutions.
</details>
<details>
<summary><b>3.3 Collecting Stream Items into Map</b></summary>

# Java Collectors.toMap(): Collecting Stream Items into Map

Learn to convert a Stream to Map i.e. collect the items from a Stream into Map using Collectors.toMap() and Collectors.groupingBy() methods.

### 1. Watch out for IllegalStateException
Please note that it is very important to know beforehand if the Stream elements will have a distinct value for the map key field or not. If map keys are duplicates and we use Collectors.toMap() method, we will get the IllegalStateException:
```
Error
Exception in thread "main" java.lang.IllegalStateException: 
	Duplicate key 3 (attempted merging values Item[id=3, name=Item3] and Item[id=3, name=Item3])
	at java.base/java.util.stream.Collectors.duplicateKeyException(Collectors.java:135)
```
### 2. Convert Stream to Map (without Duplicate Keys)
In this case, we must make sure that each key is unique in the Stream. After the process finishes, we will get a Map<K,V> where a specified key K is associated with only one single value V.

For the demo purpose, we are using a Stream of 3 items:
```java
Stream<Item> stream = Stream.of(

  new Item(1, "Item1"),
  new Item(2, "Item2"),
  new Item(3, "Item3")
);
```
We can convert the above Strem of Item instance into Map in two ways. The Map key will always be the Item Id but the Map value can be either the item value of the item itself.

In the following example, we are converting into Map<Long, String> such that:

Map Key – Item Id
Map Value – Item Name
Map<Long, String> mapWithValue = stream.collect(Collectors.toMap(Item::id, Item::name));

// {1=Item1, 2=Item2, 3=Item3}

In the next example, we are converting to Map<Long, Item> using the Function.identity() that returns the object itself as Map value.

Map<Long, Item> map = stream.collect(Collectors.toMap(Item::id, Function.identity()));

// {1=Item[id=1, name=Item1], 2=Item[id=2, name=Item2], 3=Item[id=3, name=Item3]}

### 3. Convert Stream to Map (with Duplicate Keys)
If the stream has items where Map keys are duplicates, there are two possible ways to handle it:

Collect all values in List and associate them with the Key
Choose only one value, and discard all other values for a Key
For the demo purpose, we are using a Stream of five items where three items have the duplicate key ‘3‘.
```java
Stream<Item> streamWithDuplicates = Stream.of(

  new Item(1, "Item1"),
  new Item(2, "Item2"),
  new Item(3, "Item3-1"),
  new Item(3, "Item3-2"),
  new Item(3, "Item3-3")
);
```
3.1. Collecting Stream to Map of Lists
In case, we want to store all values for a key in a List, we can use Collectors.groupingBy() to collect elements in Map<key, List<value>> format.

In the following example, we are collecting the items into Map of Lists i.e. Map<K, List<Item>>.
```java
Map<Long, List<Item>> mapWithList = streamWithDuplicates.collect(Collectors.groupingBy(Item::id));
```
The program output:

{
	1=[Item[id=1, name=Item1]], 
	2=[Item[id=2, name=Item2]], 
	3=[
			Item[id=3, name=Item3-1], 
			Item[id=3, name=Item3-2], 
			Item[id=3, name=Item3-3]
		]
}

We can convert the Stream to such that List contains the Item names i.e. Map<K, List<String>>.
```java
Map<Long, List<String>> mapWithGroupedValues = streamWithDuplicates
    .collect(
        Collectors.groupingBy(Item::id, 
        Collectors.mapping(Item::name, Collectors.toList())));
```
The program output:

{
	1=[Item1], 
	2=[Item2], 
	3=[Item3-1, Item3-2, Item3-3]
}

#### 3.2. Collecting Stream to Map with Discarding Duplicate Values
Another way is to to choose only one value from multiple values, and discard other values for any Key.

In our example, we may decide to choose the most recent name for the Map key i.e. item3-3 and discard the other values i.e. item3-1 and item3-2.

The following code uses the third parameter, mergeFunction, which when encountering conflicting values on a key, chooses which value must be associated with the key.
```java
Map<Long, Item> mapWithGrouping = streamWithDuplicates
    .collect(Collectors.toMap(Item::id, Function.identity(), (oldValue, newValue) -> newValue));
```
The program output:

{
	1=Item[id=1, name=Item1], 
	2=Item[id=2, name=Item2], 
	3=Item[id=3, name=Item3-3]
}

### 4. Maintaining Insertion Order or Sorting of keys
At times, we may want to maintain the order of key-value pairs in which they are inserted into the Map. The LinkedHashMap maintains such insertion order so we can use it to collect the Stream items.
```java
LinkedHashMap<Long, String> mapWithValueInInsertionOrder = stream
    .collect(Collectors.toMap(
    	Item::id, 
    	Item::name, 
    	(o, n) -> n, 
    	LinkedHashMap::new));
```
Similarly, if we want to apply and maintain the sorting order in the Map keys, we can use the TreeMap.
```java
TreeMap<Long, String> mapwithSortedKeys = stream
    .collect(Collectors.toMap(
    	Item::id, 
    	Item::name, 
    	(o, n) -> n, 
    	TreeMap::new));
```
### 5. Conclusion
This Java Stream tutorial discussed various ways to collect the stream items into a Map, or a Map of Lists. We saw the examples of each approach and their outputs for a better understanding of what each approach does to Stream items.

</details>
<details>
<summary><b>3.4 Collect a Java Stream to an Immutable Collection</b></summary>

# Collecting Stream Elements into Immutable Collection

In this tutorial, we’ll learn to collect the elements from a Java Stream into an immutable collection or unmodifiable collection.

### 1. Using Collectors.collectingAndThen() – Java 8
The Collectors.collectingAndThen() was introduced in Java 8 as part of lambda expression changes. This method takes two parameters a collector and a finishing function.
```java
Arrays.asList(1, 2, 3, 4, 5)
	.stream()
	.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
```
We can break the above function down into two steps:

Collectors.toList() will collect the Stream into a mutable List.
Collections.unmodifiableList() will convert the mutable List to an unmodifiable List of type java.util.Collections$UnmodifiableRandomAccessList.
We can write down both steps separately as follows:
```java
List<Integer> mutableList = Arrays.asList(1, 2, 3, 4, 5)
	.stream()
	.collect(Collectors.toList());
	
List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
```
See Also: Collecting Stream Items into List

### 2. Using Collectors.toUnmodifiableList() – Java 10
The Collectors.toUnmodifiableList() is a static function introduced in Java 10. This is a shortcut to the previous solution, which collects the Stream into an unmodifiable List in two steps.

It returns an object of type java.util.ImmutableCollections$ListN and will throw a NullPointerException if it encounters any null values. Note that ImmutableCollections is a container class for various immutable collections.
```java
var unmodifiableList = Stream.of(1, 2, 3, 4, 5)
	.collect(Collectors.toUnmodifiableList());
```
We can use Collectors.toUnmodifiableSet() will collect the Stream elemens into an unmodifiable Set.
```java
var unmodifiableSet = Stream.of(1, 2, 3, 4, 5)
	.collect(Collectors.toUnmodifiableSet());
```
Similarly, we can use Collectors.toUnmodifiableMap() to collect elements into an unmodifiable Map. It takes two parameters:

a key mapping function that would map the keys of the map
a value mapping function that would map the values of the corresponding keys.
In the following example, we will create a Map with the Integers in the List as keys and the square of the Integer as the value.
```java
var unmodifiableMap = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toUnmodifiableMap(i -> i, i -> i * i));
```
### 3. Using Stream.toList() – Java 16
With Java 16, Stream interface introduced a new default method toList() which gives back an immutable List.
```java
var unmodifiableList = Stream.of(1, 2, 3, 4, 5)
	.toList();
```
### 4. Using Google’s Guava Library
Since Guava is an external library, it will have to be added to your classpath. If you’re using Maven, add the Guava dependency as follows:
```pom
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.1-jre</version>
</dependency>
```
#### 4.1. Using ImmutableList.toImmutableList()
Starting with Guava v21.0, we can use ImmutableList.toImmutableList() static method which collects the elements into an Immutable List.

The ImmutableList.toImmutableList() method returns an object of type com.google.common.collect.RegularImmutableList and will throw a NullPointerException if it encounters any null values.
```java
var unmodifiableList = Stream.of(1, 2, 3, 4, 5)
	.collect(ImmutableList.toImmutableList());
```
#### 4.2. Using Collectors.collectingAndThen() with ImmutableList::copyOf
This approach is similar to the one described above. Here, instead, we use the ImmutableList::copyOf as the finishing function.
```java
var unmodifiableList = Stream.of(1, 2, 3, 4, 5)
	.collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
```
### 5. Immutable vs. Unmodifiable collections
Collections that do not support modification operations are referred to as unmodifiable. Unmodifiable collections are usually read-only views (wrappers) of other mutable collections. We can’t add, remove or clear them, but if we change the underlying collection, this collection’s view is also changed.

Collections that additionally guarantee that no change in the underlying collection object will be visible are referred to as immutable.

We can’t change immutable collections at all – they don’t wrap another collection – they have their own elements.

### 6. Conclusion
This Java Collections tutorial explored various ways to convert a Java Stream into an immutable collection. It is recommended to use the solution available in the latest Java version we are using.
</details>
<details>
<summary><b>3.5 Collectors groupingBy</b></summary>

# Java 8 Stream – Collectors GroupingBy with Examples

Learn to use Collectors.groupingBy() method to group and aggregate the Stream elements similar to ‘GROUP BY‘ clause in the SQL.
```java
Stream -> groupingBy() -> Map of elements after applying ‘group by’ operation
```
### 1. Collectors.groupingBy() Method
#### 1.1. Syntax
The groupingBy() method returns a Collector implementing a “GROUP BY” operation on Stream elements and returns the result as a Map.

Syntax
groupingBy(classifier)
groupingBy(classifier, collector)
groupingBy(classifier, supplier, collector)

We can pass the following arguments to this method:

classifier: maps input elements to map keys
collector: is the downstream reduction function. By default, Collectors.toList() is used which causes the grouped elements into a List.
supplier: provides a new empty Map into which the results will be inserted. By default, HashMap::new is used. We can use other maps such as TreeMap, LinkedHashMap or ConcurrentMap to insert additional behavior in the grouping process such as sorting.
#### 1.2. Using groupingByConcurrent() for Parallel Processing
We can use Collectors.groupingByConcurrent() if we wish to process the stream elements parallelly that uses the multi-core architecture of the machine and returns a ConcurrentMap. Except for concurrency, it works similarly to groupingBy() method.

Syntax
groupingByConcurrent(classifier)
groupingByConcurrent(classifier, collector)
groupingByConcurrent(classifier, supplier, collector)

### 2. Collectors groupingBy Examples
For the demo purposes, we are creating two records Person and Department as follows.
```java
record Person(int id, String name, double salary, Department department) {}
record Department(int id, String name) {}
```
And we are creating a List of persons that we will use to create Stream and collect the records in different groupings.
```java
List<Person> persons = List.of(
    new Person(1, "Alex", 100d, new Department(1, "HR")),
    new Person(2, "Brian", 200d, new Department(1, "HR")),
    new Person(3, "Charles", 900d, new Department(2, "Finance")),
    new Person(4, "David", 200d, new Department(2, "Finance")),
    new Person(5, "Edward", 200d, new Department(2, "Finance")),
    new Person(6, "Frank", 800d, new Department(3, "ADMIN")),
    new Person(7, "George", 900d, new Department(3, "ADMIN")));
```
### 2.1. Grouping By a Simple Condition
Let us start with a simple condition to understand the usage better. In the following example, we are grouping all the persons by department. This will create a Map<Department, List<Person>> where map key is department records and map value will be all the persons in that department.

Grouping all persons by department
```java
Map<Department, List<Person>> map = persons.stream().collect(groupingBy(Person::department));

System.out.println(map);
```
The program output.

{
	Department[id=2, name=Finance]=[
	Person[id=3, ...], 
	Person[id=4, ...], 
	Person[id=5, ...], 

	Department[id=3, name=ADMIN]=[
	Person[id=6, ...], 
	Person[id=7, ...], 

	Department[id=1, name=HR]=[
	Person[id=1, ...], 
	Person[id=2, ...]
}

Similarly, if we wish to collect only the person ids in all departments then we can use Collectors.mapping() to collect all the person ids in a List rather than collecting the person records.

Grouping all person ids by department
```java
Map<Department, List<Integer>> map = persons.stream()
        .collect(groupingBy(Person::department, mapping(Person::id, toList())));

System.out.println(map);
```
The program output.

{
	Department[id=2, name=Finance]=[3, 4, 5], 
	Department[id=3, name=ADMIN]=[6, 7], 
	Department[id=1, name=HR]=[1, 2]
}

#### 2.2. Grouping by Complex Condition
There may be cases when we have to apply a complex condition for grouping. In this case, the Map can represent the condition using a Java tuple and then group the matching elements as a List in Map value.

In the following example, we want to group on distinct departments and salary pairs. In the Map value, we will get a list of persons who have the same department and the same salary.

Group by distinct department and salary pairs
```java
Map<Object, List<Integer>> map = persons.stream()
    .collect(groupingBy(person -> new Pair<>(person.salary(), person.department()),
        mapping(Person::id, toList())));

System.out.println(map);
```
The program output clearly tells that persons 4 and 5 are in the same department and have the same salary.

{
	[900.0, Department[id=3, name=ADMIN]]=[7], 
	[800.0, Department[id=3, name=ADMIN]]=[6], 
	[200.0, Department[id=2, name=Finance]]=[4, 5], 
	[900.0, Department[id=2, name=Finance]]=[3], 
	[200.0, Department[id=1, name=HR]]=[2], 
	[100.0, Department[id=1, name=HR]]=[1]
}

#### 2.3. Grouping with Counting
We can also aggregate the values by performing other operations such as counting(), averaging() summing() etc. This helps in getting the reduction operation on Map values to produce a single value.

In the following example, we are counting all the persons in a department.

Count persons by department
```java
Map<Department, Long> map = persons.stream()
    .collect(groupingBy(Person::department, counting()));

System.out.println(map);
```
The program output.

{
	Department[id=2, name=Finance]=3, 
	Department[id=3, name=ADMIN]=2, 
	Department[id=1, name=HR]=2
}

In the same way, we can find count all the persons having the same salary.

Count persons with same salary
```java
Map<Double, Long> map = persons.stream()
    .collect(groupingBy(Person::salary, counting()));

System.out.println(map);
```
The program output.

{800.0=1, 200.0=3, 100.0=1, 900.0=2}

#### 2.4. Grouping with Average
It is possible to perform other aggregate operations such as finding the average salary in each department.

Average salary in each department
```java
Map<Department, Double> map = persons.stream()
    .collect(groupingBy(Person::department, averagingDouble(Person::salary)));

System.out.println(map);
```
The program output.

{
	Department[id=2, name=Finance]=433.3333333333333, 
	Department[id=3, name=ADMIN]=850.0, 
	Department[id=1, name=HR]=150.0
}

#### 2.5. Grouping with Max/Min
To find the maximum or minimum value for the grouped values, use maxBy() or minBy() collectors and pass the Comparator argument to compare the required field values.

In the following example, we are finding the max salaried person in each department.

Max salaried person in each department
```java
Map<Department, Optional<Person>> map = persons.stream()
    .collect(groupingBy(Person::department, maxBy(Comparator.comparingDouble(Person::salary))));

System.out.println(map);
```
The program output.

{
	Department[id=2, name=Finance]=Optional[Person[id=3, name=Charles, salary=900.0,...]],
	Department[id=3, name=ADMIN]=Optional[Person[id=7, name=George, salary=900.0, ...]], 
	Department[id=1, name=HR]=Optional[Person[id=2, name=Brian, salary=200.0, ...]]
}

#### 2.6. Grouping with Filtering
The Stream.filter() method filters out all the non-matching elements from the stream before passing it to the next operation. This may not be the desired solution.

Consider the following example where we are grouping all persons by the department; whose salary is greater than 300.

Filtering all persons with salary less than 300
```java
Map<Department, Long> map = persons.stream()
    .filter(p -> p.salary() > 300d)
    .collect(groupingBy(Person::department, counting()));

System.out.println(map);
```
The program output.

{
	Department[id=2, name=Finance]=1, 
	Department[id=3, name=ADMIN]=2
}

The above program output omits the department-1 altogether because there was no person matching the condition in that department. But if we want to list all such Map keys where there is no matching value exists then we can use Collectors.filtering() method that applies the filter while adding values in to Map.

Filtering all persons with salary less than 300
```java
Map<Department, Long> map = persons.stream()
    .collect(groupingBy(Person::department, filtering(p -> p.salary() > 300d, counting())));

System.out.println(map);
```
The program output. Now the department-1 is also listed with zero matching records.

{
	Department[id=2, name=Finance]=1, 
	Department[id=3, name=ADMIN]=2, 
	Department[id=1, name=HR]=0
}

### 3. Conclusion
The Collectors’s groupBy() method is excellent for grouping the Stream elements by various conditions and performing all kinds of aggregate operations on the Map values. We can use combinations of Collectors to perform any kind of grouping as shown in the above examples.
</details>
</details>
<details>
<summary><b>4. Stream Conversions</b></summary>

<details>
<summary><b>4.1 Converting Between Stream and Array</b></summary>

# Convert between Stream and Array in Java

Learn to convert a stream to an array and vice versa in Java. We will learn to convert for the primitives as well as the Object types.

## Quick Reference
```java
String[] stringArray = {"a", "b", "c", "d", "e"};

// array -> stream
Stream<String> strStream = Arrays.stream(stringArray);

// stream -> array
String[] stringArray = stream.toArray(String[]::new);
```
Note that Java Stream API provides the following specialized classes for the stream of primitives. These classes support many useful sequential and parallel aggregate operations such as sum() and average(). Consider using these classes to store a stream of primitives for better compatibility with other APIs.

IntStream – Stream of int values
LongStream – Stream of long values
DoubleStream – Stream of double values
### 1. Converting an Array to Stream
#### 1.1. Method Syntax
The primary method to convert an array to a stream of elements is Arrays.stream(). It is an overloaded method.

Stream<T> stream(T[] array) : returns a sequential Stream with the specified array as its source.
Stream<T> stream(T[] array, int start, int end) : returns a sequential Stream of array items from index positions start (inclusive) to end (exclusive).
Let’s under its usage with the following examples.

#### 1.2. Primitive Array to Stream
Java Program to convert int array to IntStream.
```java
int[] primitiveArray = {0,1,2,3,4};

IntStream intStream = Arrays.stream(primitiveArray);

Java Program to convert int array to Stream of Integer objects.

int[] primitiveArray = {0,1,2,3,4};

Stream<Integer> integerStream = Arrays.stream(primitiveArray).boxed();
```
#### 1.3. Object Array to Stream
Java program to convert an object array to a stream of objects. We can apply this approach to any type of object, including Java objects (String, Integer etc.) or custom objects (User, Employee etc.).
```java
String[] stringArray = {"a", "b", "c", "d", "e"};

Stream<String> strStream = Arrays.stream(stringArray);
```
### 2. Converting a Stream to Array
#### 2.1. Method Syntax
The primary method for converting a stream to an array is Stream.toArray(). It is also an overloaded method.

Object[] toArray() : returns an array containing the elements of a specified stream. By default, the return type of this method is Object[].
T[] toArray(IntFunction<T[]> generator) : returns an array containing the elements of this stream, using the provided generator function. The generator produces a new array of the desired type and the provided length.
Let us understand the usage of toArray() method with some examples.

#### 2.2. Stream to Primitive Array
Java program to get a stream of ints from IntStream.
```java
IntStream intStream = Arrays.stream(new int[]{1,2,3});

int[] primitiveArray = intStream.toArray();
```
Java program to convert a stream of Integers to primitive int array. Note that mapToInt() returns an instance of IntStream type. And IntStream.toArray() returns an int[]. This is the reason we are not using any generator function.
```java
Stream<Integer> integerStream = Arrays.stream(new Integer[]{1,2,3}); 

int[] primitiveArray = integerStream.mapToInt(i -> i).toArray();
```
#### 2.3. Stream to Object Array
Java program to convert a stream of objects to an array of objects. It applies to all Java classes and custom objects as well. By default, toArray() will return an Object[]. To get the String[], we are using the generator function String[]::new that creates an instance of String array.
```java
Stream<String> strStream = Arrays.stream(new String[]{});

String[] stringArray = strStream.toArray(String[]::new);
```
### 3. Conclusion
In this short tutorial, we learned to convert the stream of items to the array of items, including primitives and complex object types. We learned to use the Arrays.stream() and Stream.toArray() methods and their examples.
</details>  
<details>
<summary><b>4.2 Convert Iterable or Iterator to Stream</b></summary>

# Convert Iterable or Iterator to Stream in Java

Learn to convert Iterable or Iterator to Stream. It may be desired at times when we want to utilize excellent support of lambda expressions and collectors in Java Stream API.

### 1. Converting Iterable to Stream
The Iterables are useful but provide limited support for lambda expressions added in Java 8. To utilize full language features, it is desired to convert the iterable to stream.

To convert, we will use iterable.spliterator() method to get the Spliterator reference, which is then used to get the Stream using StreamSupport.stream(spliterator, isParallel) method.
```java
//Iterable
Iterable<String> iterable = Arrays.asList("a", "b", "c");
 
//Iterable -> Stream
//false means sequential stream
Stream<String> stream = StreamSupport.stream(iterable.spliterator(), false);
```
The above code is only linking the Stream to the Iterable but the actual iteration won’t happen until a terminal operation is executed.
The second argument in StreamSupport.stream() determines if the resulting Stream should be parallel or sequential. Set it true for a parallel stream and false for a sequential stream.
### 2. Converting Iterator to Stream – Java 8
The Iterator to Stream conversion follows the same path as Iterable to Stream.

The only difference is that the Iterator interface has no spliterator() method so we need to use Spliterators.spliteratorUnknownSize() method to get the spliterator. Rest everything is same.
```java
// Iterator
Iterator<String> iterator = Arrays.asList("a", "b", "c").listIterator();
                  
//Extra step to get Spliterator
Spliterator<String> splitItr = Spliterators
    .spliteratorUnknownSize(iterator, Spliterator.ORDERED);

// Iterator -> Stream
Stream<String> stream = StreamSupport.stream(splitItr, false);
```
### 3. Converting Iterator to Stream – Java 9
Java 9 has made the syntax a little easier and now we don’t need to use Spliterator it explicitly. Rather it uses a Predicate to decide when the elements shall be taken.
```java
// Iterator
Iterator<String> iterator = Arrays.asList("a", "b", "c")
                  .listIterator();

Stream<String> stream = Stream.generate(() -> null)
    .takeWhile(x -> iterator.hasNext())
    .map(n -> iterator.next());
```
</details>  
<details>
<summary><b>4.3 Collecting Stream of Primitives into Collection or Array</b></summary>

# Collecting Stream of Primitives into Collection or Array

Java Collectors class provides many static methods to collect items from a Stream and store them into a Collection. But these methods do not work with streams of primitives.

Works with Objects; But doesn't work with Primitives
```java
//It works perfect !!

List<String> strings = Stream.of("how", "to", "do", "in", "java")
            .collect(Collectors.toList());
 
//Compilation Error !!
IntStream.of(1,2,3,4,5).collect(Collectors.toList());
```
To convert the Stream of primitives to a Collection, we can adapt one of the following ways. Note that these methods can be applied to all three primitive streams i.e. IntStream, LongStream, and DoubleStream.

### 1. Collecting IntStream into Collection using Boxed Stream
Using boxed() method of IntStream, LongStream or DoubleStream e.g. IntStream.boxed(), we can get stream of wrapper objects which can be collected by Collectors methods.
```java
//Primitive Stream -> List
List<Integer> listOfIntegers = IntStream.of(1,2,3,4,5)
  .boxed()
  .collect(Collectors.toList());

List<Long> listOfLongs = LongStream.of(1,2,3,4,5)
  .boxed()
  .collect(Collectors.toList());

List<Double> listOfDoubles = DoubleStream.of(1.0,2.0,3.0,4.0,5.0)
  .boxed()
  .collect(Collectors.toList());
```
### 2. Collecting IntStream to List by Mapping to Objects
Another way is to manually to the boxing using IntStream.mapToObj(), IntStream.mapToLong() or IntStream.mapToDouble() methods. There are other similar methods in other stream classes, which you can use.
```java
//Primitive Stream -> List
List<Integer> listOfIntegers = IntStream.of(1,2,3,4,5)
  .mapToObj(Integer::valueOf)
  .collect(Collectors.toList());

List<Long> listOfLongs = LongStream.of(1,2,3,4,5)
  .mapToObj(Long::valueOf)
  .collect(Collectors.toList());

List<Double> listOfDoubles = DoubleStream.of(1.0,2.0,3.0,4.0,5.0)
  .mapToObj(Double::valueOf)
  .collect(Collectors.toList());
```
### 3. Collecting IntStream to Array
It is also useful to know how to convert the primitive stream to an array. Use IntStream.toArray() method to convert from int stream to array.
```java
int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();

long[] longArray = LongStream.of(1, 2, 3, 4, 5).toArray();

double[] doubleArray = DoubleStream.of(1, 2, 3, 4, 5).toArray();
```
Similarly, use toArray() function of LongStream or DoubleStream as well.
</details>
</details> 

<details>
<summary><b>5. Stream Operations</b></summary>

<details>
<summary><b>5.1 Append or Prepend Items to a Stream</b></summary>

# Append or Prepend Items to a Stream

Learn to add items to a Java Stream. Remember that a Stream is not a data structure or collection that can store values. To add items to an existing Stream, we need to :

Create a new Stream with items to be added
Concatenate with the first stream to get a merged stream.
### 1. Concatenating Streams
The Stream.concat(stream1, stream2) is used to merge two streams into one stream which consists of all the elements of both streams.

The concat(s1, s2) method creates a lazily concatenated stream whose elements are all the elements of the s1 followed by all the elements of the s2.
The resulting stream is ordered if both of the input streams are ordered.
The resulting stream is parallel if either of the input streams is parallel.
### 2. Examples of Adding Items
#### 2.1. Appending Items
To append items at the start of a Stream, create a new stream of items and pass the new Stream as the first method argument in the concat() method.
```java
Stream<Integer> stream = Stream.of(1, 2, 3, 4);
         
//Append 5 and 6 to the stream
Stream<Integer> appenededStream = Stream.concat(stream, Stream.of(5, 6));
 
//Verify Stream
appenededStream.forEach(System.out::print); //Prints 123456
```
#### 2.2. Prepending Items
To prepend the items at the end of a Stream, create a new stream of the items and pass the new Stream as the second method argument in the concat() method.
```java
Stream<Integer> stream = Stream.of(1, 2, 3, 4);
         
//Prepend 0 to the stream
Stream<Integer> prependedStream = Stream.concat(Stream.of(0), stream);
 
//Verify Stream
prependedStream.forEach(System.out::print); //Prints 01234
```
### 3. Conclusion
The Stream API provides lots of useful methods which can be used to solve many problems. In the above case, adding new objects to the Java stream has been demonstrated using the concat() API whose original purpose is to merge two streams.
</details>  
<details>
<summary><b>5.2 Merging Streams</b></summary>

# Java 8 Stream.concat(): How to Combine Streams?

The Java 8 Stream.concat() method merges two streams into one stream. The combined stream consists of all the elements of both streams.

If either of the streams is a parallel stream, the resulting stream will also be a parallel stream. Be careful when combining parallel and sequential streams because this may affect performance and behavior.

The concat() method is useful in the following usecases:

Combining results from different data sources.
Merging multiple streams into one for unified processing.
Concatenating static data with dynamically generated data.
### 1. Stream concat() Method
The concat() method is a static method in Stream class. Its method signature is:

static <T> Stream<T> concat(Stream<? extends T> firstStream, Stream<? extends T> secondStream)

It creates a lazily concatenated stream whose elements are all the elements of the firstStream followed by all the elements of the secondStream.
The resulting stream is ordered if both of the input streams are ordered.
The resulting stream is parallel if either of the input streams is parallel.
When the resulting stream is closed, the close handlers for both input streams are invoked.
### 2. Merge Two Streams using Stream.concat()
Java example to merge two streams of numbers – to obtain a stream that contains numbers from both streams.
```java
Stream<Integer> firstStream = Stream.of(1, 2, 3);
Stream<Integer> secondStream = Stream.of(4, 5, 6);
 
Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream);
 
System.out.println( resultingStream.toList() );   
```
Program Output.

[1, 2, 3, 4, 5, 6]

### 3. Combining Multiple Streams using Stream.concat()
Java example to merge four streams of numbers – to obtain a stream that contains numbers from all streams. Notice we have made a static import to Stream.concat() function which makes the code readable.
```java
Stream<Integer> first = Stream.of(1, 2);
Stream<Integer> second = Stream.of(3,4);
Stream<Integer> third = Stream.of(5, 6);
Stream<Integer> fourth = Stream.of(7,8);

Stream<Integer> resultingStream = Stream.concat(first, concat(second, concat(third, fourth)));

System.out.println( resultingStream.toList() );
```
Program Output.

[1, 2, 3, 4, 5, 6, 7, 8]

### 4. Combining Streams without Duplicate Elements
#### 4.1. Using distinct() with Primitives and Strings
While merging two streams, we can use distinct() API and the resulting stream will contain only the unique elements.
```java
Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5, 6);
Stream<Integer> secondStream = Stream.of(4, 5, 6, 7, 8, 9);

Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream).distinct();

System.out.println( resultingStream.toList() );
```
Program Output.

[1, 2, 3, 4, 5, 6, 7, 8, 9]

#### 4.2. Custom Equality Check for User-defined Objects
In case of merging streams of custom objects, we can drop the duplicate elements during stream iteration. We can use the distinctByKey() function created for java stream distinct by object property example.
```java
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class Main 
{
  public static void main(String[] args) 
  {
    Stream<Employee> stream1 = getEmployeeListOne().stream();
    Stream<Employee> stream2 = getEmployeeListTwo().stream();
     
    Stream<Employee> resultingStream = Stream.concat(stream1, stream2)
        .filter(distinctByKey(Employee::getFirstName));
     
    System.out.println( resultingStream.collect(Collectors.toList()) );
  }
   
  public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
  {
      Map<Object, Boolean> map = new ConcurrentHashMap<>();
      return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }
 
  private static ArrayList<Employee> getEmployeeListOne() 
  {
    ArrayList<Employee> list = new ArrayList<>();
    list.add( new Employee(1l, "Lokesh", "Gupta") );
    list.add( new Employee(5l, "Brian", "Piper") );
    list.add( new Employee(7l, "Charles", "Piper") );
    list.add( new Employee(6l, "David", "Beckham") );
        return list;
  }
   
  private static ArrayList<Employee> getEmployeeListTwo() 
  {
    ArrayList<Employee> list = new ArrayList<>();
    list.add( new Employee(2l, "Lokesh", "Gupta") );
    list.add( new Employee(4l, "Brian", "Piper") );
    list.add( new Employee(3l, "David", "Beckham") );
        return list;
  }
}
```
> Program Output.
```
[Employee [id=1, firstName=Lokesh, lastName=Gupta],
Employee [id=5, firstName=Brian, lastName=Piper],
Employee [id=7, firstName=Charles, lastName=Piper],
Employee [id=6, firstName=David, lastName=Beckham]]
```
</details>  
<details>
<summary><b>5.3 Java Stream reuse – Traverse stream multiple times?</b></summary>

# Java Stream Reuse – Consume Stream Multiple Times?

One of the main features of Java Streams is that they are designed to be consumed only once. Once a terminal operation is performed on a stream, it is considered consumed and cannot be reused. But many times, we need to perform different operations on the same stream.

So, is it possible to reuse streams in Java? Learn the alternative of Java stream reuse and how to handle situations where we need to consume a stream multiple times.

### 1. Can we reuse the Stream? The answer is ‘NO’.
Java streams, once consumed, can not be reused by default. As Java docs say clearly,

“A stream should be operated on (invoking an intermediate or terminal stream operation) only once. This rules out, for example, “forked” streams, where the same source feeds two or more pipelines, or multiple traversals of the same stream. A stream implementation may throw IllegalStateException if it detects that the stream is being reused.“

So the simple answer is: NO, we cannot reuse the streams or traverse the streams multiple times. Any attempt to do so will result in an error: “Stream has already been operated on or closed“.

### 2. Why the Streams cannot be Reused?
The streams are not reusable due to their internal structure and the nature of their operations, which are generally designed to be consumed and processed in a single pass.

If we observe its internals, a Stream represents a sequence of elements supporting sequential and parallel aggregate operations. Conceptually, a stream can be thought of as a pipeline of computational steps. The intermediate steps process the elements and return a new Stream, whereas the terminal steps trigger the actual processing of the elements.

In runtime, streams maintain the internal state during their execution. Once a terminal operation is performed, the internal state is consumed and the stream is considered closed. Allowing reuse would require additional mechanisms to reset the internal state and reinitialize the source which would complicate the design and reduce performance.

### 2. Alternative to Reuse a Stream
First of all, any implementation code that requires traversing the stream multiple times – isn’t efficient code and needs to be refactored.

The only usecase where we might want to create a source and get stream multiple times is – unit testing. In that case, we can always use the stream() method to create a new stream.
```java
List<Integer> tokens = Arrays.asList(1, 2, 3, 4, 5);
 
//first use
Optional<Integer> result = tokens.stream().max(Integer::compareTo);
System.out.println(result.get());
 
//second use
result = tokens.stream().min(Integer::compareTo);
System.out.println(result.get());
 
//third use
long count = tokens.stream().count();
System.out.println(count);
```
> Program output.

> 5
> 1
> 5
</details>  
</details>  


<details>
<summary><b>6. Stream API and Methods</b></summary>
	
<details>
<summary><b>6.1 Guide to IntStream in Java</b></summary>

# Guide to IntStream in Java

Java IntStream class is a specialization of Stream interface for int primitive. It represents a stream of primitive int-valued elements supporting sequential and parallel aggregate operations.

IntStream is part of the java.util.stream package and implements AutoCloseable and BaseStream interfaces.

### 1. Creating IntStream
There are several ways of creating an IntStream.

#### 1.1. With Specified Values
This function returns a sequential ordered stream whose elements are the specified values.

It comes in two versions i.e. single element stream and multiple values stream.

- IntStream of(int t) – Returns stream containing a single specified element.
- IntStream of(int... values) – Returns stream containing specified all elements.
- IntStream.of(10); 		//10
- IntStream.of(1, 2, 3); 	//1,2,3

#### 1.2. Generating ints in Range
The IntStream produced by range() methods is a sequential ordered stream of int values which is the equivalent sequence of increasing int values in a for-loop and value incremented by 1. This class supports two methods.

- range(int start, int end) – Returns a sequential ordered int stream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1.
- rangeClosed(int start, int end) – Returns a sequential ordered int stream from startInclusive (inclusive) to endInclusive (inclusive) by an incremental step of 1.
```java
IntStream.range(1, 5);  	//1,2,3,4

IntStream.rangeClosed(1, 5);  	//1,2,3,4,5
```
#### 1.3. Infinite Streams with Iteration
The iterator() function is useful for creating infinite streams. Also, we can use this method to produce streams where values are increment by any other value than 1.

Given example produces first 10 even numbers starting from 0.

IntStream.iterate(0, i -> i + 2).limit(10);	

//0,2,4,6,8,10,12,14,16,18

#### 1.4. Infinite Streams with IntSupplier
The generate() method looks a lot like iterator(), but differs by not calculating the int values by incrementing the previous value. Rather an IntSupplier is provided which is a functional interface is used to generate an infinite sequential unordered stream of int values.

Following example create a stream of 10 random numbers and then print them in the console.
```java
IntStream stream = IntStream
    .generate(() -> { return (int)(Math.random() * 10000); }); 

stream.limit(10).forEach(System.out::println);
```
### 2. Iterating Over Values
To loop through the elements, stream support the forEach() operation. To replace simple for-loop using IntStream, follow the same approach.
```java
IntStream.rangeClosed(0, 4)
			.forEach( System.out::println );
```
### 3. Filtering the Values
We can apply filtering on int values produced by the stream and use them in another function or collect them for further processing.

For example, we can iterate over int values and filter/collect all prime numbers up to a certain limit.
```java
IntStream stream = IntStream.range(1, 100); 

List<Integer> primes = stream.filter(ThisClass::isPrime)
			.boxed()
			.collect(Collectors.toList());

public static boolean isPrime(int i)
{
    IntPredicate isDivisible = index -> i % index == 0;
    return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
}
```
### 4. Converting IntStream to Array
Use IntStream.toArray() method to convert from the stream to int array.
```java
int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();
```
### 5. Converting IntStream to List
Collections in Java can not store the primitive values directly. They can store only instances/objects.

Using boxed() method of IntStream, we can get a stream of wrapper objects which can be collected by Collectors methods.
```java
List<Integer> list = IntStream.of(1,2,3,4,5)
            .boxed()
            .collect(Collectors.toList());
```
</details>
<details>
<summary><b>6.2 Streams peek() API</b></summary>

# Java Stream peek()

Java Stream peek() method returns a new Stream consisting of all the elements from the original Stream after applying a given Consumer action.

Note that the peek() method is an intermediate Stream operation so, to process the Stream elements through peek(), we must use a terminal operation. Using Stream.peek() without any terminal operation does nothing.

### 1. Stream peek() Method
#### 1.1. Usage
According to Java docs, the purpose of peek() method is to support debugging when we want to see the elements as they flow through the Stream processing pipeline.

We can call peek() method after every intermediate operation to see the effect of intermediate operation on the Stream elements.

> Pseudo Code
```java
Stream<T> stream = createStream();

stream.operationOne()
	.peek()
	.operationTwo()
	.peek()
	.terminalOperation();
```
#### 1.2. Method Syntax
The peek() returns a new Stream consisting of elements from the original Stream.

Here action is a non-interfering action to perform on the elements as they are consumed from the Stream. The result elements after performing the action are placed into the new Stream.

> Syntax
> Stream<T> peek(Consumer<? super T> action)

#### 1.3. Description
Stream peek() method is an intermediate operation.
It returns a Stream consisting of the elements of current stream.
It additionally perform the provided action on each element as elements.
For parallel stream pipelines, the action may be called at whatever time and in whatever thread the element is made available by the upstream operation.
If the action modifies shared state, it is itself responsible for providing the required synchronization.
peek() exists mainly to support debugging, where we want to see the elements as they flow past a certain point in a pipeline.
### 2. Stream peek() Examples
#### 2.1. Using peek() Without Terminal Operation
As mentioned above, Stream.peek() without any terminal operation does nothing.

Stream.peek() without terminal operation
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 
list.stream()
  .peek( System.out::println );   //prints nothing
```
#### 2.2. Using peek() with Terminal Operation
Java program to use peek() API to debug the Stream operations and log Stream elements as they are processed.

Stream.peek() with terminal operation
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
     
List<Integer> newList = list.stream()
      .peek(System.out::println)
      .collect(Collectors.toList());
 
System.out.println(newList);
```
> Program output.

> Output
> 1
> 2
> 3
> 4
> 5
> [1, 2, 3, 4, 5]

#### 3. Conclusion
Stream.peek() method can be useful in visualizing how the stream operations behave and understanding the implications and interactions of complex intermediate stream operations.

</details> 
<details>
<summary><b>6.3 Difference Between map() and flatMap()</b></summary>
	
# Java Stream map() vs. flatMap() with Examples

The Java 8 Stream interface contains the map() and flatMap() methods that process the elements of the current Stream and return a new Stream. Both methods are intermediate stream operations and serve distinct purposes.

In this article, we’ll explore the differences between these operations and discuss when to use one over the other.

### 1. Stream map(): One-to-One Operation
The map() operation is used to transform each element of a stream into another object using a given function. It returns a new stream containing the transformed elements in the same order as the original stream.

This transformation is one-to-one, meaning each input element produces exactly one output element. So, if there are N elements in the stream, the map() operation will produce a new stream of N elements.
```java
List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
 
List<Integer> listOfIntegers = listOfStrings.stream()
                                .map(Integer::valueOf)
                                .toList();
 
System.out.println(listOfIntegers);   //[1, 2, 3, 4, 5]
```
### 2. Stream flatMap(): One-to-Many Operation
The flatMap() operation is used when each element in the stream is transformed into multiple elements, often in the form of another collection or stream. The resulting elements are then flattened into a single stream.

This transformation is one-to-many, meaning an input element produces multiple output elements, later all flattened into a single Stream.

In more simple words, the flatMap() operation is a two-step process i.e. map() + flattening. In a broader sense, it helps convert Collection<Collection<Item>> to Collection<Item>.
```java
List<List<Integer>> listOfLists = Arrays.asList(
  Arrays.asList(1, 2, 3),
  Arrays.asList(4, 5),
  Arrays.asList(6, 7, 8)
);

List<Integer> flattenedList = listOfLists.stream()
      .flatMap(list -> list.stream())
      .toList();

System.out.println(flattenedList);    //[1, 2, 3, 4, 5, 6, 7, 8]
```
### 3. Differences between Stream map() and flatMap()
The main difference between map() and flatMap() is that map() only transforms the elements of this Stream, but flatMap() transforms and flattens, both.

flatMap() = map() + Flattening

Let’s compare these two operations using a table:

Aspect|	map()|	flatMap()|
--- |--- | --- |  
Transformation|	One-to-one transformation|	One-to-many transformation|
Input to Output|	1 input -> 1 output|	1 input -> n outputs (flattened)|
Output Sequence|	Preserves input sequence|	Flattens output|
When to Use|	Modify values, Extract properties|	Splitting string, Combining nested collections|
Common Usage|	Normal data transformations|	Handling nested structures|

Differences between Java 8 Map() Vs flatMap() :

map() | flatMap() | 
--- | --- |  
It processes stream of values. | It processes stream of stream of values. 
It does only mapping. | It performs mapping as well as flattening.
It’s mapper function produces single value for each input value. | It’s mapper function produces multiple values for each input value. 
It is a One-To-One mapping. | It is a One-To-Many mapping. 
Data Transformation : From Stream<T> to Stream<R> | Data Transformation : From Stream<Stream<T> to Stream<R> 
Use this method when the mapper function is producing a single value for each input value. | Use this method when the mapper function is producing multiple values for each input value. 

### 4. Usage of map() vs flatMap()
Use Stream.map() when we need to transform each element individually and the output has a one-to-one relationship with the input.

For example, we can write a program to find the date of birth of all employees in a stream of employees. For each employee in the Stream, we will have one date of birth as the output value extracted from the input Employee object.
```java
List<Employee> employees = ...;

List<LocalDate> datesOfBirth = employees.stream()
    .map(Employee::getDateOfBirth)
    .collect(Collectors.toList());
```
Use flatMap() when we need to transform each element into multiple elements, such as when dealing with nested collections.

For example, we may write a program to find all district words from all lines in a text file. The following example:

Reads a text file using Files.lines() to obtain a stream of lines.
The flatMap() operation transforms each line into a new Stream of words. This is the one-to-many transformation.
The words from all the streams are collected into a single Set and it is the flattening operation.
String filePath = "path/to/your/textfile.txt";
```java
Stream<String> lines = Files.lines(Paths.get(filePath));

Set<String> distinctWords = lines
  .flatMap(line -> Arrays.stream(line.split("\\s+")))
  .collect(Collectors.toSet());

System.out.println("Distinct words in the file: " + distinctWords);
```

### 5. Real Time Example:

- POJO class:
  
```java
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;

    public Customer() {
    }

    public Customer(int id, String name, String email, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
```
- Dao Layer:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDataBase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }
}
```
- Service Class:
```java
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {

        List<Customer> customers = EkartDataBase.getAll();

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping
        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        System.out.println(emails);

	//customer -> customer.getPhoneNumbers()  ->> one to many mapping
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<List<String>> phoneNumbers = customers.
                stream().map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);
    }
}
```
### 6. Conclusion
As discussed above, map() and flatMap(), both operations serve distinct purposes and are instrumental in streamlining data processing tasks. To keep things simpler, always remember that the map() operation is designed for one-to-one transformations, and conversely, the flatMap() operation handles one-to-many transformations.
</details> 
<details>
<summary><b>6.4 Stream findFirst() vs. findAny()</b></summary>
ava Stream findFirst() vs findAny(): What’s Difference?

Java Stream interface has two methods findFirst() and findAny() for retrieving elements from streams. Both method looks very much similar but they behave differently in certain conditions. At the high level:

findFirst(): Returns the first element in the stream.
findAny(): Returns any element from the stream which is useful in parallel processing.
In this post, learn the difference between findFirst() and findAny() methods.

### Quick Reference
```java
Stream.of("one", "two", "three", "four")
  .parallel()
  .findFirst()
  .ifPresent(System.out::println);  // one

Stream.of("one", "two", "three", "four")
  .parallel()
  .findAny()
  .ifPresent(System.out::println);  // three - it can change in every run
```
### 1. Stream findFirst()
The findFirst() method returns an Optional describing the first element of this stream, when the stream has:

defined encounter order – first element in encounter order in the stream.
no encounter order – any element may be returned.
Syntax
Optional<T> findFirst()

The above assumptions are valid for all sequential and parallel streams and the behavior of findFirst() will not change.
```java
//sequential stream
Stream.of("one", "two", "three", "four")
    .findFirst()
    .ifPresent(System.out::println);
 
//parallel stream
Stream.of("one", "two", "three", "four")
  .parallel()
  .findFirst()
  .ifPresent(System.out::println);
```
Program output.

one
one

### 2. Stream findAny()
The findAny() method returns an Optional describing any element of a stream, when the Stream has :

defined encounter order – any element may be returned.
no encounter order – any element may be returned.
The above theory is valid for all sequential and parallel streams and the behavior of findAny() will not change.

Stream.findAny() has been introduced for performance gain in the case of parallel streams, only.

Syntax
Optional<T> findAny()

In non-parallel streams, findAny() will return the first element in most of the cases but this behavior is not gauranteed.
```java
//sequential stream
Stream.of("one", "two", "three", "four")
    .findAny()
    .ifPresent(System.out::println);
 
//parallel stream
Stream.of("one", "two", "three", "four")
  .parallel()
  .findAny()
  .ifPresent(System.out::println);
```
Program output.

one
three

### 3. Differences between findFirst() vs findAny()
In this post, we learned the difference between findFirst() and findAny() methods in Java 8 Stream API. Let us quickly summarize the differences:

Feature	findFirst()	findAny()
Order Guarantee	Returns the first element in the encounter order of the stream.	May return any element from the stream, not necessarily the first, especially in parallel streams.
Performance	Might have a performance overhead in parallel streams due to maintaining encounter order.	Can be more efficient in parallel streams since it does not have to maintain encounter order.
When to Use	Use when the order matters and we need the first element, strictly.	Use when we don’t care which element is returned specially in parallel streams.
Example Usecases	– Retrieving the first element in a sorted list of transactions to identify the earliest transaction.
– Finding the highest priority task from a list of tasks ordered by priority.
– Fetching the first log entry from an ordered list to identify the initial state of a system.
– Getting the first data point from a time-series dataset to start the analysis.	– Fetching any element from a large dataset processed in parallel to quickly validate the presence of an item.
– Choosing any available server from a pool of servers to distribute the load evenly.
– Retrieving any sample data point from a large dataset for quick insights without caring about the order.
– Picking any element from a population for statistical sampling in data analysis.
### 4. Summary
In non-parallel streams, both may return the first element of the stream in most cases but findAny() does not offer any guarantee of this behavior.

Use findAny() to get any element from any parallel stream in a faster time. Else we can always use findFirst() it in most cases.
</details> 
<details>
<summary><b>6.5 Java Stream findAny()</b></summary>

# Java Stream findAny()

The Stream.findAny() returns an Optional describing any element of the specified stream if Stream is non-empty. It returns an empty Optional if the stream is empty.

In non-parallel streams, findAny() will return the first element in most cases, but this behavior is not guaranteed. The Stream.findAny() method has been introduced for performance gain in the case of parallel streams, only.

### 1. Syntax
Optional<T> findAny()
The findAny() method is a terminal short-circuiting operation.
The findAny() method returns an Optional.
The Optional contains the value as any element of the given stream, if Stream is non-empty. The returned element is the first element in most cases.
The Optional contains the empty value, if Stream is empty.
If the element selected is null, NullPointerException is thrown.
For all the sequential and parallel streams, it may return any element. The behavior of findAny() does not change by the parallelism of the Stream.
Similarly, there is no guaranteed behavioral difference in case of a stream has a defined encounter order or has no encounter order at all.
### 2. Stream.findAny() Example
In the given example, we are using the finaAny() method to get any element from the Stream. The method returns an Optional.

If the stream is empty, we get an empty optional.
```java
Optional optional = Stream.empty().findAny();
Assertions.assertTrue(optional.isEmpty());
```
For non-empty streams, we get an Optional with a value.
```java
Optional optional = Stream.of("one", "two", "three", "four").findAny();

Assertions.assertTrue(optional.isPresent());
Assertions.assertEquals("one", optional.get());
```
For parallel streams, the findAny() behaves the same as above, but the optional value is not predictable.
```java
Optional optional = Stream.of("one", "two", "three", "four").parallel().findAny();

Assertions.assertTrue(optional.isPresent());
```
### 3. Difference between findFirst() vs findAny()
In non-parallel streams, findFirst() and findAny(), both may return the first element of the Stream in most cases. But findAny() does not offer any guarantee of this behavior.

Use findAny() to get any element from any parallel stream in a faster time. Else we can always use findFirst() in most cases.
</details> 
<details>
<summary><b>6.6 Java Stream findFirst()</b></summary>

# Java Stream findFirst() Example

The Java 8 Stream.findFirst() is a terminal operation that returns an Optional describing the first element of the given stream if stream is non-empty, or an empty Optional if the stream is empty.

The findFirst() is used to retrieve the first occurrence of an element that matches certain criteria, and when the order of elements is important.

### 1. Stream findFirst()
The method signature for findFirst() is as follows:

Optional<T> findFirst();

The findAny() method is a terminal short-circuiting operation.
The findFirst() method returns an Optional.
The Optional contains the value as the first element of the given stream, if the stream is non-empty.
The Optional contains the empty value, if Stream is empty.
If the element selected is null, NullPointerException is thrown.
If Stream has defined encounter order, the findFirst() returns first element in encounter order.
If Stream has no encounter order, the findFirst() may return any element.
The above behavior is valid for all sequential and parallel streams. The behavior of findFirst() does not change by the parallelism of the Stream.
### 2. Stream findFirst() Example
In the given example, we are getting the first element from the Stream of strings. As soon as, we get the first element, the stream operation moves to Optional.ifPresent() method.

We print the first element using the method reference inside ifPresent() method.
```java
Stream.of("one", "two", "three", "four")
    .findFirst()
    .ifPresent(System.out::println);   // Prints 'one'
```
Similarly, we can use the findFirst() to get an element based on some condition. To apply the condition, we can use the filter() method.
```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

Optional<String> firstWordStartingWithC = words.stream()
        .filter(word -> word.startsWith("c"))
        .findFirst();

firstWordStartingWithC.ifPresent(word -> 
  System.out.println("First word starting with 'c': " + word));  // Prints 'cherry'
```
Making the stream parallel does not change the behavior.
```java
Stream.of("one", "two", "three", "four")
  .parallel()
  .findFirst()
  .ifPresent(System.out::println);  // Prints 'one'
```
### 3. Difference between findFirst() vs findAny()
In non-parallel streams, findFirst() and findAny(), both may return the first element of the Stream in most cases. But findAny() does not offer any guarantee of this behavior.

Use findAny() to get any element from any parallel stream in a faster time. Else we can always use findFirst() in most cases.
</details> 
<details>
<summary><b>6.7 Java Collectors teeing()</b></summary>

# Collectors teeing() Examples

The Collectors.teeing() is a new feature introduced in Java 12 as part of the Stream API enhancements. It allows two different collectors on a stream and then merges their results using a specified BiFunction.

Let us learn when and how to use the Collectors.teeing() method.

### 1. Purpose of teeing collector
The Collectors.teeing() method is useful when we want to simultaneously process a stream in two different ways and then combine their results. If not using the teeing() method, we would have processed the stream two times, teeing() allows to process in a single statement.

During stream processing, every element passed to the resulting collector is processed by both downstream collectors, then their results are merged using the specified merge function into the final result.

Please note that teeing() function helps perform a certain task in a single step. We can surely perform the given task in two steps if we do not use the teeing() function. It’s just a helper function that helps in reducing the verbosity.

### 2. Syntax
The syntax is as follows:

downstream1: The first collector.
downstream2: The second collector.
merger: A BiFunction to merge the results of the two collectors.
/**
* downstream1 - the first downstream collector
* downstream2 - the second downstream collector
* merger - the function which merges two results into the single one
* returns - a Collector which aggregates the results of two supplied collectors.
*/
```java
public static Collector teeing​ (Collector downstream1,
						Collector downstream2,
						BiFunction merger);
```
### 3. Using Collectors.teeing() to Find Max and Min
In this Collectors.teeing() example, we have a list of employees. We want to find out employees with maximum and minimum salaries in a single step.

The following Java program performs finding max and min operations, then collects both items in a Map.
```java
List<Employee> employeeList = List.of(
    new Employee(1, "A", 100),
    new Employee(2, "B", 200),
    new Employee(3, "C", 300),
    new Employee(4, "D", 400)); 

HashMap<String, Employee> result = employeeList.stream().collect( 
    Collectors.teeing(
        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
        Collectors.minBy(Comparator.comparing(Employee::getSalary)),
        (e1, e2) -> {
          HashMap<String, Employee> map = new HashMap();
          map.put("MAX", e1.get());
          map.put("MIN", e2.get());
          return map;
        }
    ));

System.out.println(result);
```
In the above example,

Collectors.maxBy is the first collector.
Collectors.minBy is the second collector.
Merger function produces the HashMap.
Program output.

{
	MIN=Employee [id=1, name=A, salary=100.0],
	MAX=Employee [id=4, name=D, salary=400.0]
}

### 4. Using Collectors.teeing() to Filter and Count
In this example, we will use the same set of employees. Here, we will find all employees with a salary greater than 200, and then we will also count the number of such employees.
```java
List<Employee> employeeList = List.of(
  new Employee(1, "A", 100),
  new Employee(2, "B", 200),
  new Employee(3, "C", 300),
  new Employee(4, "D", 400)); 

HashMap<String, Object> result = employeeList.stream().collect( 
  Collectors.teeing(
      Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
      Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()),
      (list, count) -> {
        HashMap<String, Object> map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return map;
      }
  ));

System.out.println(result);
```
Program output.

{
	count=2,
	list=[Employee [id=3, name=C, salary=300.0], Employee [id=4, name=D, salary=400.0]]
}

### 5. Using Collectors.teeing() to Average and Sum
Suppose we have a list of numbers and we want to calculate and print both the average and the sum of a list of integers.
```java
List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();

String result = numbers.stream().collect(
    Collectors.teeing(
        Collectors.averagingInt(Integer::intValue),
        Collectors.summingInt(Integer::intValue),
        (average, sum) -> String.format("Average: %.2f, Sum: %d", average, sum)
    )
);

System.out.println(result);
```
### 6. Conclusion
The above examples of Collectors.teeing() method are very simple and written for basic understanding. We need to use the function very specific to our own needs.

Simply remember that when we need to perform stream operation twice and collect results in two different collectors, consider using teeing() method. It will not always fit in the usecase, but it may be useful when it fits in.

</details> 
<details>
<summary><b>6.8 Java Stream concat()</b></summary>

# Java 8 Stream.concat(): How to Combine Streams?

The Java 8 Stream.concat() method merges two streams into one stream. The combined stream consists of all the elements of both streams.

If either of the streams is a parallel stream, the resulting stream will also be a parallel stream. Be careful when combining parallel and sequential streams because this may affect performance and behavior.

The concat() method is useful in the following usecases:

Combining results from different data sources.
Merging multiple streams into one for unified processing.
Concatenating static data with dynamically generated data.
### 1. Stream concat() Method
The concat() method is a static method in Stream class. Its method signature is:

> static <T> Stream<T> concat(Stream<? extends T> firstStream, Stream<? extends T> secondStream)

It creates a lazily concatenated stream whose elements are all the elements of the firstStream followed by all the elements of the secondStream.
The resulting stream is ordered if both of the input streams are ordered.
The resulting stream is parallel if either of the input streams is parallel.
When the resulting stream is closed, the close handlers for both input streams are invoked.
### 2. Merge Two Streams using Stream.concat()
Java example to merge two streams of numbers – to obtain a stream that contains numbers from both streams.
```java
Stream<Integer> firstStream = Stream.of(1, 2, 3);
Stream<Integer> secondStream = Stream.of(4, 5, 6);
 
Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream);
 
System.out.println( resultingStream.toList() );   
```
> Program Output.

> [1, 2, 3, 4, 5, 6]

### 3. Combining Multiple Streams using Stream.concat()
Java example to merge four streams of numbers – to obtain a stream that contains numbers from all streams. Notice we have made a static import to Stream.concat() function which makes the code readable.
```java
Stream<Integer> first = Stream.of(1, 2);
Stream<Integer> second = Stream.of(3,4);
Stream<Integer> third = Stream.of(5, 6);
Stream<Integer> fourth = Stream.of(7,8);

Stream<Integer> resultingStream = Stream.concat(first, concat(second, concat(third, fourth)));

System.out.println( resultingStream.toList() );
```
> Program Output.

> [1, 2, 3, 4, 5, 6, 7, 8]

### 4. Combining Streams without Duplicate Elements
#### 4.1. Using distinct() with Primitives and Strings
While merging two streams, we can use distinct() API and the resulting stream will contain only the unique elements.
```java
Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5, 6);
Stream<Integer> secondStream = Stream.of(4, 5, 6, 7, 8, 9);

Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream).distinct();

System.out.println( resultingStream.toList() );
```
> Program Output.

> [1, 2, 3, 4, 5, 6, 7, 8, 9]

#### 4.2. Custom Equality Check for User-defined Objects
In case of merging streams of custom objects, we can drop the duplicate elements during stream iteration. We can use the distinctByKey() function created for java stream distinct by object property example.
```java
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class Main 
{
  public static void main(String[] args) 
  {
    Stream<Employee> stream1 = getEmployeeListOne().stream();
    Stream<Employee> stream2 = getEmployeeListTwo().stream();
     
    Stream<Employee> resultingStream = Stream.concat(stream1, stream2)
        .filter(distinctByKey(Employee::getFirstName));
     
    System.out.println( resultingStream.collect(Collectors.toList()) );
  }
   
  public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
  {
      Map<Object, Boolean> map = new ConcurrentHashMap<>();
      return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }
 
  private static ArrayList<Employee> getEmployeeListOne() 
  {
    ArrayList<Employee> list = new ArrayList<>();
    list.add( new Employee(1l, "Lokesh", "Gupta") );
    list.add( new Employee(5l, "Brian", "Piper") );
    list.add( new Employee(7l, "Charles", "Piper") );
    list.add( new Employee(6l, "David", "Beckham") );
        return list;
  }
   
  private static ArrayList<Employee> getEmployeeListTwo() 
  {
    ArrayList<Employee> list = new ArrayList<>();
    list.add( new Employee(2l, "Lokesh", "Gupta") );
    list.add( new Employee(4l, "Brian", "Piper") );
    list.add( new Employee(3l, "David", "Beckham") );
        return list;
  }
}
```
> Program Output.
```
[Employee [id=1, firstName=Lokesh, lastName=Gupta],
Employee [id=5, firstName=Brian, lastName=Piper],
Employee [id=7, firstName=Charles, lastName=Piper],
Employee [id=6, firstName=David, lastName=Beckham]]
```
</details> 
 <details>
<summary><b>6.9 Java Stream toArray()</b></summary>

# Java Stream toArray() Example

Java 8 Stream.toArray() method is used to convert a stream into an array. In other words, toArray() accumulates the stream elements and returns them as an array.

In this tutorial, we will see multiple examples for collecting the Stream elements into an array.

### 1. Stream toArray() Method
The toArray() method returns an array containing the elements of the given stream. This is a terminal operation. It has two main variations:

> Object[] toArray()
> <T> T[]  toArray(IntFunction<T[]> generator)

The first method collects the elements of the stream into an array of Object.
The second method uses a generator function to produce a new array of the desired type and the provided length.
When working with parallel streams, the order of elements in the resulting array may not be predictable.

### 2. Stream toArray() Example
Example 1: Converting ‘Stream<String>‘ to ‘String[]‘
In the given example, we are converting a stream to an array using using toArray() API. It uses the String[]::new generator function for creating a new array of type String. This is equivalent to writing a lambda expression that creates a new String array, such as ‘size -> new String[size]‘.
```java
Stream<String> tokenStream = Stream.of("A", "B", "C", "D");
     
String[] tokenArray = tokenStream.toArray(String[]::new);
 
//Verification
System.out.println( Arrays.toString(tokenArray) );  
```
Program output.

[A, B, C, D]

Example 2: Converting Infinite Stream to Array
To convert an infinite stream into an array, we must limit the stream to a finite number of elements.

Infinite Stream of Integers
```java
IntStream infiniteNumberStream = IntStream.iterate(1, i -> i+1);
     
int[] intArray = infiniteNumberStream.limit(10).toArray();  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Infinite boxed stream of Integers
IntStream infiniteNumberStream = IntStream.iterate(1, i -> i+1);
 
Integer[] integerArray = infiniteNumberStream.limit(10)
          .boxed()
          .toArray(Integer[]::new);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```
Example 3: Stream, filter, and collect to an Array
Sometimes we need to find specific items in the stream and then add only those elements to the array. Here, we can use Stream.filter() method to pass a predicate that will return only those elements that match the pre-condition.
```java
List<Employee> employeeList = new ArrayList<>(Arrays.asList(
      new Employee(1, "A", 100),
      new Employee(2, "B", 200),
      new Employee(3, "C", 300),
      new Employee(4, "D", 400),
      new Employee(5, "E", 500),
      new Employee(6, "F", 600)));

Employee[] employeesArray = employeeList.stream()
    .filter(e -> e.getSalary() < 400)
    .toArray(Employee[]::new);

System.out.println(Arrays.toString(employeesArray));
```
Program output.

[Employee [id=1, name=A, salary=100.0],
Employee [id=2, name=B, salary=200.0],
Employee [id=3, name=C, salary=300.0]]

### 3. Summary
The Stream.toArray() method converts a stream into an array. The default toArray() returns an array of Object and the parameterized toArray(generator) returns an array of a specific type.

Be careful with parallel streams and the result may not be predictable.
</details> 
<details>
<summary><b>6.10 Java Stream noneMatch()</b></summary>

# Java Stream noneMatch()

Java Stream noneMatch() method is a short-circuiting terminal operation. The noneMatch() is used to check that Stream does not contain any element matching the provided Predicate.

### 1. Stream noneMatch() Method
#### 1.1. Syntax
boolean noneMatch(Predicate<? super T> predicate)

The noneMatch() returns:

true – if no element in the stream matches the given predicate, or the stream is empty.
false – if at least one element matches the given predicate.
Here predicate a non-interfering and stateless predicate to apply to elements of the stream.

It is short-circuiting operation. A terminal operation is short-circuiting if, when presented with infinite input, it may terminate in finite time.

#### 1.2. Description
The noneMatch() is a short-circuiting terminal operation.
It returns whether no element of the stream match the provided predicate.
It may not evaluate the predicate on all elements if not necessary for determining the result. The method returns true if no stream element matches the given predicate, else method returns false.
If the stream is empty then true is returned and the predicate is not evaluated.
It is pretty much opposite to method allMatch().
2. Stream noneMatch() Example
Java example of Stream.noneMatch() method to check if no element in the Stream contains any numeric/digit character.
```java
import java.util.stream.Stream;

public class Main
{
	public static void main(String[] args)
	{
		Stream<String> stream = Stream.of("one", "two", "three", "four");

		boolean match = stream.noneMatch( s -> s.contains("\\d+") );

		System.out.println(match);		//true
	}
}
```
> Program output.

> true

#### 3. Conclusion
Stream.noneMatch() method can be useful in certain cases where we need to run a check on all stream elements. For example, we can use noneMatch() function on a stream of Employee objects to validate that all employees are NOT below a certain age.
</details> 
<details>
<summary><b>6.11 Java Stream allMatch()</b></summary>

# Java Stream allMatch()

Java Stream allMatch() is a short-circuiting terminal operation that is used to check if all the elements in the stream satisfy the provided predicate.

### 1. Stream allMatch() Method
#### 1.1. Syntax
Syntax
boolean allMatch(Predicate<? super T> predicate)

Here predicate a non-interfering, stateless predicate to apply to all the elements of the stream.

The allMatch() method returns always a true or false, based on the result of the evaluation.

#### 1.2. Description
It is a short-circuiting terminal operation.
It returns whether all elements of this stream match the provided predicate.
May not evaluate the predicate on all elements if not necessary for determining the result. Method returns true if all stream elements match the given predicate, else method returns false.
If the stream is empty then true is returned and the predicate is not evaluated.
The difference between allMatch() and anyMatch() is that anyMatch() returns true if any of the elements in a stream matches the given predicate. When using allMatch(), all the elements must match the given predicate.
### 2. Stream allMatch() Examples
Let us look at a few examples of allMatch() menthod to understand its usage.

Example 1: Checking if Any Element Contains Numeric Characters
In the given example, none of the strings in the Stream contain any numeric character. The allMatch() checks this condition in all the strings and finally returns true.

Checking all elements in the stream
```java
Stream<String> stream = Stream.of("one", "two", "three", "four");

Predicate<String> containsDigit = s -> s.contains("\\d+") == false;

boolean match = stream.allMatch(containsDigit);

System.out.println(match);	
```
> Program output.

> Output
> true

Example 2: Stream.allMatch() with Multiple Conditions
To satisfy multiple conditions, create a composed predicate with two or more simple predicates.

In the given example, we have a list of Employee. We want to check if all the employees who are above the age of 50 – are earning above 40,000.

In the list, the employee "B" is earning below 40k and his age is above 50, so the result is false.

allMatch() with composed predicate

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
 
public class Main 
{
  public static void main(String[] args) 
  {
    Predicate<Employee> olderThan50 = e -> e.getAge() > 50;
    Predicate<Employee> earningMoreThan40K = e -> e.getSalary() > 40_000;
    Predicate<Employee> combinedCondition = olderThan50.and(earningMoreThan40K);
     
    boolean result = getEmployeeStream().allMatch(combinedCondition);
    System.out.println(result);
  }
   
  private static Stream<Employee> getEmployeeStream()
  {
    List<Employee> empList = new ArrayList<>();
    empList.add(new Employee(1, "A", 46, 30000));
    empList.add(new Employee(2, "B", 56, 30000));
    empList.add(new Employee(3, "C", 42, 50000));
    empList.add(new Employee(4, "D", 52, 50000));
    empList.add(new Employee(5, "E", 32, 80000));
    empList.add(new Employee(6, "F", 72, 80000));
     
    return empList.stream();
  }
}
 
@Data
@AllArgsConstructor
class Employee 
{
  private long id;
  private String name;
  private int age;
  private double salary;
}
```
Program output.

Output
false

### 3. Conclusion
Stream.allMatch() method can be useful in certain cases where we need to run a check on all stream elements.

For example, we can use allMatch() on a stream of Employee objects to validate if all employees are above a certain age.

It is short-circuiting operation. A terminal operation is short-circuiting if, when presented with infinite input, it may terminate in finite time.
</details> 
<details>
<summary><b>6.12 Java Stream anyMatch()</b></summary>

# Java Stream anyMatch()

Java Stream anyMatch(predicate) is a terminal short-circuit operation. It is used to check if the Stream contains at least one element that satisfies the given Predicate.

### 1. Stream anyMatch() API
#### 1.1. Syntax
Here predicate a non-interfering, stateless Predicate to apply to elements of the stream.

The anyMatch() method returns true if at least one element satisfies the condition provided by predicate, else false.

Syntax
boolean anyMatch(Predicate<? super T> predicate)

#### 1.2. Description
It is a short-circuiting terminal operation.
It returns whether any elements of this stream match the provided predicate.
May not evaluate the predicate on all elements if not necessary for determining the result. Method returns true as soon as first matching element is encountered.
If the stream is empty then false is returned and the predicate is not evaluated.
The difference between allMatch() and anyMatch() is that anyMatch() returns true if any of the elements in a stream matches the given predicate. When using allMatch(), all the elements must match the given predicate.
#### 2. Stream anyMatch() Examples
Example 1: Checking if Stream contains a Specific Element
In this Java example, we are using the anyMatch() method to check if the stream contains the string "four".

As we see that the stream contains the string, so the output of the example is true.

Checking if Stream contains an element
```java
Stream<String> stream = Stream.of("one", "two", "three", "four");

boolean match = stream.anyMatch(s -> s.contains("four"));

System.out.println(match);
```
Program output.

Output
true

Example 2: Stream.anyMatch() with Multiple Predicates
To satisfy multiple conditions, create a composed predicate with two or more simple predicates.

In the given example, we have a list of Employee. We want to check if there is an employee who is above the age of 50 – is earning above 40,000.

In the list, employees "D" and "F" are earning above 40k and their age is above 50, so the result is true.

Stream anyMatch() with multiple conditions
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;https://howtodoinjava.com/wp-admin/tools.php
import lombok.Data;
 
public class Main 
{
  public static void main(String[] args) 
  {
    Predicate<Employee> olderThan50 = e -> e.getAge() > 50;
    Predicate<Employee> earningMoreThan40K = e -> e.getSalary() > 40_000;
    Predicate<Employee> combinedCondition = olderThan50.and(earningMoreThan40K);
     
    boolean result = getEmployeeStream().anyMatch(combinedCondition);
    System.out.println(result);
  }
   
  private static Stream<Employee> getEmployeeStream()
  {
    List<Employee> empList = new ArrayList<>();
    empList.add(new Employee(1, "A", 46, 30000));
    empList.add(new Employee(2, "B", 56, 30000));
    empList.add(new Employee(3, "C", 42, 50000));
    empList.add(new Employee(4, "D", 52, 50000));
    empList.add(new Employee(5, "E", 32, 80000));
    empList.add(new Employee(6, "F", 72, 80000));
     
    return empList.stream();
  }
}
 
@Data
@AllArgsConstructor
class Employee 
{
  private long id;
  private String name;
  private int age;
  private double salary;
}
```
> Program output.

> Output
> true

### 3. Difference between anyMatch() vs contains()
Theoretically, there is no difference between anyMatch() and contains() when we want to check if an element exists in a List.

In some cases, parallelism feature of Streams may bring an advantage for really large lists, but we should not casually use the Stream.parallel() every time assuming that it may make things faster.

In fact, invoking parallel() may bring down the performance for small streams.

### 4. Conclusion
The anyMatch() method can be useful in certain cases where we need to check if there is at least one element in the stream.

The shorter version list.contains() also does the same thing and can be used instead.
</details> 
<details>
<summary><b>6.13 Java Stream skip()</b></summary>

# Java Stream skip()

Stream skip(n) method is used to skip the first 'n' elements from the given Stream.

The skip() method returns a new Stream consisting of the remaining elements of the original Stream, after the specified n elements have been discarded in the encounter order.

### 1. Stream skip() Method
#### 1.1. Method Syntax
> Syntax
> Stream<T> skip(long n)

The n is the number of leading elements to be discarded. It returns a new Stream consisting of elements picked from the original stream.

The method may throw IllegalArgumentException if n is negative.

#### 1.2. Description
Stream skip() method is stateful intermediate operation. Stateful operations, such as distinct and sorted, may incorporate state from previously seen elements when processing new elements.
Returns a stream consisting of the remaining elements of the stream after discarding the first n elements of the stream.
If the stream contains fewer than n elements then an empty stream will be returned.
Generally skip() is a cheap operation, it can be quite expensive on ordered parallel pipelines, especially for large values of n.
Using an unordered stream source (such as generate(Supplier)) or removing the ordering constraint with BaseStream.unordered() may result in significant speedups of skip() in parallel pipelines.
skip() skips the first n elements in the encounter order.
#### 2. Stream skip() Example
In this Java program, we are using the skip() method to skip the first 5 even numbers from an infinite stream of even numbers and then collect the next 10 even numbers into a new Stream.

Skip 5 and then collect 10 numbers
```java
Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);

List<Integer> newList = evenNumInfiniteStream
		.skip(5)
		.limit(10)
		.collect(Collectors.toList());
		
System.out.println(newList);
```
> Program output.

> [10, 12, 14, 16, 18, 20, 22, 24, 26, 28]
#### 3. Conclusion
The Stream skip() method can be useful in certain cases where we need to get the elements from a Stream but first, we need to skip a few elements from the Stream.

The fact, that skip() returns the elements in the encounter order, makes it very useful for normal business usecases as well.
</details> 
 <details>
<summary><b>6.14 Java Stream limit()</b></summary>
	 
# Java Stream limit()

Stream limit(n) is used to retrieve a number of elements from the Stream while the count must not be greater than n. The limit() method returns a new Stream consisting of the elements of the given stream, truncated to be no longer than maxSize in length.

### 1. Stream limit() Method
#### 1.1. Syntax
Syntax
Stream<T> limit(long maxSize)

Here maxSize the number of elements the stream should be limited to; and the method return value is a new Stream consisting of elements picked from the original stream.

#### 1.2. Description
Stream.limit() method is short-circuiting intermediate operation. An intermediate operation is short-circuiting if, when presented with infinite input, it may produce a finite stream as a result. Please note that a terminal operation is short-circuiting if, when presented with infinite input, it may terminate in finite time.
It returns a stream consisting of the maximum elements, no longer than given size in length, of current stream.
Generally, limit() is cheap operation but may sometimes be expensive if maxSize has a large value and stream is parallely processed.
Using an unordered stream source (such as generate(Supplier)) or removing the ordering constraint with BaseStream.unordered() may result in significant speedups of limit() in parallel pipelines.
limit() returns the first n elements in the encounter order.
### 2. Stream limit() Examples
Example 1: Getting first 10 even numbers from an infinite stream of even numbers
In the given below example, we are creating an infinite stream using iterate() method. Then we are taking the first 10 even numbers using the method limit(10).

Finally, we are collecting the even numbers from the stream into a List using collect(Collectors.toList()) method.

Collect first 10 even numbers
```java
Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);

List<Integer> newList = evenNumInfiniteStream.limit(10)
                                .collect(Collectors.toList());

System.out.println(newList);	
```
Program output.

Output
[0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

### 3. Difference between skip() and limit()
The limit(N) method returns first N elements in the encounter order of the Stream.
The skip(N) discards the first N elements of the Stream.
```java
List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    .skip(6)
    .collect(Collectors.toList());

System.out.println(newList);	//[7, 8, 9, 10]
```
### 4. Conclusion
Java 8 Stream limit() method can be useful in certain cases where we need to get the elements from a stream and the count of elements will be determined at runtime.

The fact, that it returns the elements in encounter order, makes it very useful for normal business usecases as well.
</details> 
 <details>
<summary><b>6.15 Java Stream peek()</b></summary>

# Java Stream peek()

Java Stream peek() method returns a new Stream consisting of all the elements from the original Stream after applying a given Consumer action.

Note that the peek() method is an intermediate Stream operation so, to process the Stream elements through peek(), we must use a terminal operation. Using Stream.peek() without any terminal operation does nothing.

### 1. Stream peek() Method
#### 1.1. Usage
According to Java docs, the purpose of peek() method is to support debugging when we want to see the elements as they flow through the Stream processing pipeline.

We can call peek() method after every intermediate operation to see the effect of intermediate operation on the Stream elements.

> Pseudo Code
```java
Stream<T> stream = createStream();

stream.operationOne()
	.peek()
	.operationTwo()
	.peek()
	.terminalOperation();
```
#### 1.2. Method Syntax
The peek() returns a new Stream consisting of elements from the original Stream.

Here action is a non-interfering action to perform on the elements as they are consumed from the Stream. The result elements after performing the action are placed into the new Stream.

> Syntax
> Stream<T> peek(Consumer<? super T> action)

#### 1.3. Description
Stream peek() method is an intermediate operation.
It returns a Stream consisting of the elements of current stream.
It additionally perform the provided action on each element as elements.
For parallel stream pipelines, the action may be called at whatever time and in whatever thread the element is made available by the upstream operation.
If the action modifies shared state, it is itself responsible for providing the required synchronization.
peek() exists mainly to support debugging, where we want to see the elements as they flow past a certain point in a pipeline.
### 2. Stream peek() Examples
#### 2.1. Using peek() Without Terminal Operation
As mentioned above, Stream.peek() without any terminal operation does nothing.
```java
Stream.peek() without terminal operation
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 
list.stream()
  .peek( System.out::println );   //prints nothing
```
#### 2.2. Using peek() with Terminal Operation
Java program to use peek() API to debug the Stream operations and log Stream elements as they are processed.
```java
Stream.peek() with terminal operation
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
     
List<Integer> newList = list.stream()
      .peek(System.out::println)
      .collect(Collectors.toList());
 
System.out.println(newList);
```
> Program output.

> Output
> 1
> 2
> 3
> 4
> 5
> [1, 2, 3, 4, 5]

#### 3. Conclusion
Stream.peek() method can be useful in visualizing how the stream operations behave and understanding the implications and interactions of complex intermediate stream operations.

Though it is entirely possible to alter the inner state of elements in the Stream, it is never recommended and shall be avoided.
</details> 
 <details>
<summary><b>6.16 Java Stream flatMap()</b></summary>

# Java Stream flatMap()

Java 8 Stream.flatMap() method is used to flatten a Stream of collections to a Stream of objects. During the flattening operation, the objects from all the collections in the original Stream are combined into a single collection

> Stream<Collection<Item>> —-> flatMap() —-> Stream<Item>

Quick Reference
```java
List<List<Integer>> listOfLists = Arrays.asList(
  Arrays.asList(1, 2, 3),
  Arrays.asList(4, 5),
  Arrays.asList(6, 7, 8)
);

List<Integer> flattenedList = listOfLists.stream()
  .flatMap(list -> list.stream())  // Flattening step
  .toList();

//Prints [1, 2, 3, 4, 5, 6, 7, 8]
System.out.println("Flattened list: " + flattenedList);
```
### 1. What is Flattening?
Imagine we have a bunch of boxes, and each box contains some items. Now, we want to take out all those items from the boxes and put them in a single box. That’s what flatMap() does with a stream. It takes objects from different collections in this stream A and puts all objects in a new Stream B.

In layman’s terms, flattening is referred to as merging multiple collections/arrays into one. Consider the following example.

In this example, we have an array of 3 arrays. After the flattening effect, we will have one result array with all the items from the 3 arrays.

Flattening Example
Before flattening 	: [[1, 2, 3], [4, 5], [6, 7, 8]]

After flattening 	: [1, 2, 3, 4, 5, 6, 7, 8]

In the following example, lines is a stream of lines in the file. Each line consists of multiple words. The words stream is a fattened version of all streams into a single stream – consisting of all the words in all the lines.

Flattening example 2
```java
Path path = ...;  //File Path

Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);

Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
```
### 2. Stream flatMap() Method
#### 2.1. Method Syntax
The stream flatMap() method has the following syntax.

> Syntax
> <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)

R represents the element type of the new stream.
mapper is a non-interfering, stateless function to apply to each element which produces a stream of new values.
The method returns a new stream of objects of type R.
#### 2.2. Features
The flatMap() is an intermediate operation and returns a new Stream.
It returns a Stream consisting of the results of replacing each element of the given stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
The mapper function used for transformation in flatMap() is a stateless function and returns only a stream of new values.
Each mapped Stream is closed after its contents have been placed into new Stream.
flatMap() operation flattens the stream; opposite to map() operation which does not apply flattening.
#### 3. Stream flatMap() Examples
Example 1: Converting Nested Lists into a Single List
Java 8 example of Stream.flatMap() function to get a single List containing all elements from a list of lists.

This program uses flatMap() operation to convert List<List<Integer>> to List<Integer>.

Merging Lists into a Single List
```java
List<Integer> list1 = Arrays.asList(1,2,3);
List<Integer> list2 = Arrays.asList(4,5,6);
List<Integer> list3 = Arrays.asList(7,8,9);
  
List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
 
List<Integer> listOfAllIntegers = listOfLists.stream()
          .flatMap(x -> x.stream())
          .collect(Collectors.toList());

System.out.println(listOfAllIntegers);
```
Program output.

Output
[1, 2, 3, 4, 5, 6, 7, 8, 9]

Example 2: Collecting Nested Arrays into a Single List
Java 8 example of Stream.flatMap() function to get a single List containing all elements from an array of arrays.

Merging Arrays into a Single List
```java
String[][] dataArray = new String[][]{{"a", "b"}, 
		{"c", "d"}, {"e", "f"}, {"g", "h"}};
         
List<String> listOfAllChars = Arrays.stream(dataArray)
              .flatMap(x -> Arrays.stream(x))
              .collect(Collectors.toList());

System.out.println(listOfAllChars);
```
> Program output.

> Output
> [a, b, c, d, e, f, g, h]

### 4. Flattening with IntStream, LongStream and DoubleStream
Stream interface has three more similar methods which produce IntStream, LongStream and DoubleStream respectively that are super helpful if the flattened stream consists only of numeric values such as long, int or doubles.

Similar flatMap() Methods
IntStream flatMapToInt(Function<? super T,? extends IntStream> mapper)
LongStream flatMapToLong(Function<? super T,? extends LongStream> mapper)
DoubleStream flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)

These classes provide convenient methods to perform mathematical operations on all the elements of the Stream, which is often required.

Consider the following example. We have a list of the list of numbers, and we want the sum of all the numbers.
```java
List<List<Integer>> listOfLists = Arrays.asList(
  Arrays.asList(1, 2, 3),
  Arrays.asList(4, 5),
  Arrays.asList(6, 7, 8)
);

int sum = listOfLists.stream()
  .flatMap(list -> list.stream()) // Flatten the list of lists
  .mapToInt(Integer::intValue) // Convert to IntStream
  .sum(); // Calculate the sum

System.out.println("Sum of all numbers: " + sum);  //36
```
</details> 
 <details>
<summary><b>6.17 Java Stream map()</b></summary>
	 
# Java Stream map()

Java 8 Stream.map() operation transforms the elements of a stream from one type to another. After the map() operation completes, for each element of type X in the current Stream, a new object of type Y is created and put in the new Stream.

Stream<ElementType> —> map() operation —> Stream<NewElementType>

### 1. When do we use Stream.map() Operation?
The map() operation is particularly useful for data manipulation and transformation tasks. Consider a few possible usecases to understand when map() can be applied:

During database migration, we may want to transform data from the old schema to the new schema. Using map(), we can define the field mappings between entities to copy their values.
Data cleansing can be done with map() when we read data from different sources and convert it to a standard format before processing it in a standard way.
In the MVC pattern, we can use map() to copy JPA entity data into VO objects for rendering the user views.
In the following example, we are using the map() to convert from Stream<PersonEntity> to Stream<PersonVO>

### Quick Reference
// Converting from Stream<PersonEntity> to Stream<PersonVO> and collecting into a new List
```java
List<PersonEntity> personEntityList = ...;  // A List of PersonEntity objects

List<PersonVO> personVoList = personEntityList.stream()
	.map(e -> createVoFromEntity(e))
	.toList();   

//The utility function called in the map operation
public static PersonVO createVoFromEntity(PersonEntity entity) { ... }
```
### 2. Stream map() Method
#### 2.1. Method Syntax
The Stream map() method has the following syntax.

Method Syntax
> <R> Stream<R> map(Function<? super T,? extends R> mapper)

R represents the element type of the new stream.
mapper is a non-interfering, stateless function to apply to each element which produces a stream of new values.
The method returns a new stream of objects of type R.
#### 2.2. Description
The map() is an intermediate operation. It returns a new Stream as return value.
The map() operation takes a Function, which is called for each value in the input stream and produces one result value sent to the output stream.
The mapper function used for transformation is a stateless function (does not store the information of previously processed objects) and returns only a single value.
The map() method is used when we want to convert a Stream of X to Stream of Y.
The mapped stream is closed after its contents have been placed into the new output stream.
map() operation does not flatten the stream as flatMap() operation does.
### 3. Stream map() Examples
Let us see a few more examples to understand it even better.

Example 1: Converting a Stream of Strings to a Stream of Integers
In this example, we will convert a Stream<String> to Stream<Integer>. Here the mapper function Integer::valueOf() takes one string from the Stream at a time, and converts the String to an Integer.

It then puts the Integer into another stream which is then collected using Collectors.toList().
```java
List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
 
List<Integer> listOfIntegers = listOfStrings.stream()
        .map(Integer::valueOf)
        .collect(Collectors.toList());
 
System.out.println(listOfIntegers);
```
> Program output.

> [1, 2, 3, 4, 5]

Example 2: Finding all distinct salaries among all employees
Java example to find all possible distinct salaries for a List of employees.
```java
List<Employee> employeesList = Arrays.asList(
                                    new Employee(1, "Alex", 100),
                                    new Employee(2, "Brian", 100),
                                    new Employee(3, "Charles", 200),
                                    new Employee(4, "David", 200),
                                    new Employee(5, "Edward", 300),
                                    new Employee(6, "Frank", 300)
                                );
  
List<Double> distinctSalaries = employeesList.stream()
                        .map( e -> e.getSalary() )
                        .distinct()
                        .collect(Collectors.toList());

System.out.println(distinctSalaries);
```
Program output.

[100.0, 200.0, 300.0]

### 4. Stream of Integers, Longs or Doubles [Special Case]
Stream interface has three more similar methods for numeric types and are often used to perform numerical calculations or conversions. These methods produce IntStream, LongStream and DoubleStream respectively.

Similar methods
> IntStream mapToInt(ToIntFunction<? super T> mapper)
> LongStream mapToLong(ToLongFunction<? super T> mapper)
> DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)

The benefit of using these classes is that they provide convenient methods to process the stream elements and perform mathematical/aggregate operations without the overhead of boxing and unboxing.

In the following example, we have a list of exam scores represented as strings, and we want to calculate the average score:
```java
List<String> scoresAsString = Arrays.asList("85", "92", "78", "90", "88");

double averageScore = scoresAsString.stream()
  .mapToInt(Integer::parseInt)	// Convert strings to integers using mapToInt()
  .average()		// Calculate the average of the integers
  .orElse(0.0);	// Use 0.0 if there are no scores

System.out.println("Average score: " + averageScore);
```
</details> 
 <details>
<summary><b>6.18 Java Stream min()</b></summary>

# Java Stream min()

The Stream min() method is used to select the minimum/smallest element in the Stream according to the Comparator used for comparing the elements.

The Comparator imposes a total ordering on the Stream elements which may not have a natural ordering.

### 1. Stream min() Method
#### 1.1. Method Syntax
The method takes a non-interfering, stateless Comparator to compare elements of the stream.
It returns an Optional describing the maximum element of the stream, or an empty Optional if the stream is empty.
The min() method throws NullPointerException if the minimum element found is null.
Method Syntax
Optional<T> min(Comparator<? super T> comparator)

#### 1.2. Description
This is a terminal operation. So stream cannot be used after this method is executed.
Returns the minimum/smallest element of this stream according to the provided Comparator.
This is a special case of a stream reduction.
The method argument shall be a non-interfering, stateless Comparator.
The method returns an Optional describing the smallest element of this stream, or an empty Optional if the stream is empty.
It may throw NullPointerException if the smallest element is null.
### 2. Stream min() Examples
Example 1: Finding Smallest Element with Lambda Expression
Java example to find the minimum number from a stream of numbers using comparator as lambda expression.

Select smallest element from stream
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

Optional<Integer> minNumber = list.stream()
            .min((i, j) -> i.compareTo(j));

System.out.println(minNumber.get());
```
Program output.

Output
1

Example 2: Finding Smallest Element with Comparator
Java example to find the minimum number from a stream of numbers using custom comparator.
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
 
Comparator<Integer> minComparator = new Comparator<Integer>() {
   
  @Override
  public int compare(Integer n1, Integer n2) {
    return n1.compareTo(n2);
  }
};

Optional<Integer> minNumber = list.stream()
            .min(minComparator);

System.out.println(minNumber.get());
```
Program output.

> Output
> 1
</details> 
 <details>
<summary><b>6.19 Java Stream max()</b></summary>

# Java Stream max()

The Stream max() method is used to select the largest element in the Stream according to the Comparator used for comparing the elements.

The Comparator imposes a total ordering on the Stream elements which may not have a natural ordering.

### 1. Stream max() Method
#### 1.1. Method Syntax
The method takes a non-interfering and stateless Comparator to compare elements of the stream.
It returns an Optional describing the maximum element of the stream, or an empty Optional if the stream is empty.
The max() method throws NullPointerException if the maximum element found is null.
Syntax
Optional<T> max(Comparator<? super T> comparator)

#### 1.2. Description
The max() method is a terminal operation. So the Stream cannot be used after this method has been executed.
It returns the maximum/largest element of this stream according to the provided Comparator.
This is a special case of a stream reduction.
The method argument shall be a non-interfering, stateless Comparator.
The method returns an Optional describing the maximum element of this stream, or an empty Optional if the stream is empty.
It may throw NullPointerException if the maximum element is null.
#### 2. Java Stream max() Example
Example 1: Largest element in the Stream with Lambda Expression
Java example to find the largest number from a stream of numbers using comparator as lambda expression.

Select largest element from stream
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

Optional<Integer> maxNumber = list.stream()
      .max((i, j) -> i.compareTo(j));

System.out.println(maxNumber.get());
```
Program output.

9

Example 2: Largest element in the Stream with Comparator
Java example to find the largest number from a stream of numbers using custom comparator.
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
 
Comparator<Integer> maxComparator = new Comparator<Integer>() {
   
  @Override
  public int compare(Integer n1, Integer n2) {
    return n1.compareTo(n2);
  }
};

Optional<Integer> maxNumber = list.stream()
      .max(maxComparator);

System.out.println(maxNumber.get());
```
> Program output.
> 9
</details> 
 <details>
<summary><b>6.20 Java Stream sorted()</b></summary>

# Java Stream sorted() Example with/without Comparator

Since Java 8, the sorted() method is part of the Stream API and is used to sort the elements of a stream. By default, elements are sorted in the natural order, but we can apply for a custom order using a Comparator.

#### Quick Reference
```java
//Default sorting
List sortedList = unsortedList.stream().sorted().toList();

//Custom Sorting
Comparator comparator = ...;
List sortedList = unsortedList.stream().sorted(comparator).toList();
```
### 1. Stream sort() is an Overloaded Method
The Stream interface provides two methods for sorting the elements:

sorted() – Provides the default sorting
sorted(Comparator) – Sorting based on the provided comparator.
#### 1.1. Stream sorted()
Syntax
Stream<T> sorted()

sorted() is a stateful intermediate operation that returns a new Stream.
It returns a stream consisting of the elements of this stream, sorted according to the natural order.
If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.
For ordered streams, the sort is stable.
For unordered streams, no stability guarantees are made.
#### 1.2. Stream sorted(comparator)
Syntax
Stream<T> sorted(Comparator<? super T> comparator)

This is a stateful intermediate operation that returns a new stream.
It returns a stream consisting of the elements of this stream, sorted according to the provided Comparator..
For ordered streams, the sort is stable.
For unordered streams, no stability guarantees are made.
### 2. Stream sorted() Examples
#### 2.1. Sorting Stream Elements in Natural Order
In the given Java example, we are sorting a List of integers in the natural order and printing them into the standard output.
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

List<Integer> sortedList = list.stream()
      .sorted()
      .collect(Collectors.toList());

System.out.println(sortedList);
```
Program output.

[1, 2, 3, 4, 5, 6, 7, 8, 9]

#### 2.2. Sorting Stream Elements in Reverse Order
In the given Java example, we are sorting a stream of integers in reverse order using a Comparator.reverseOrder() and printing them into the standard output.
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

List<Integer> sortedList = list.stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

System.out.println(sortedList);
```
> Program output.
> [9, 8, 7, 6, 5, 4, 3, 2, 1]

#### 2.3. Sort Stream Elements in Custom Order using Comparator
In the given Java example, we are sorting a stream of integers using a custom Comparator.
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
 
Comparator<Integer> reverseComparator = new Comparator<Integer>() {
  @Override
  public int compare(Integer i1, Integer i2) {
    return i2.compareTo(i1);
  }
}; 

List<Integer> sortedList = list.stream()
      .sorted(reverseComparator)
      .collect(Collectors.toList());

System.out.println(sortedList);
```
> Program output.
> [9, 8, 7, 6, 5, 4, 3, 2, 1]

#### 2.4. Stream Sorting using Lambda Expressions
Java example to sort a stream of integers in reverse order using lambda expression to specify the comparison logic.

We are rewriting the previous Comparator logic with an inline lambda expression.
```java
List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

List<Integer> sortedList = list.stream()
      .sorted( (i1, i2) -> i2.compareTo(i1) )
      .collect(Collectors.toList());

System.out.println(sortedList);
```
> Program output.
> [9, 8, 7, 6, 5, 4, 3, 2, 1]
</details> 
 <details>
<summary><b>6.21 Java Stream filter()</b></summary>

# Java Stream filter()

Learn to use Stream.filter(Predicate) method to traverse all the elements and filter all items which match a given condition through Predicate argument.

### 1. Stream filter() Method
The stream() method syntax is as follows:

Syntax
Stream<T> filter(Predicate<? super T> condition) 

Predicate is a functional interface and represents the condition to filter out the non-matching elements from the Stream.

filter() is a intermediate Stream operation.
It returns a Stream consisting of the elements of the given stream that match the given predicate.
The filter() argument should be stateless predicate which is applied to each element in the stream to determine if it should be included or not.
Predicate is a functional interface. So, we can also pass lambda expression also.
It returns a new Stream so we can use other operations applicable to any stream.
### 2. Java Stream filter() Examples
Recommended Reading
The given examples use the predicates to write filter conditions. Read Java Predicates to learn how to write predicates for the different requirements.

#### 2.1. Filtering a Stream using Lambda Expression
In this example, we are iterating over a stream of numbers. We will find all even numbers from the Stream and print them into Console.

The inline predicate ‘n -> n % 2 == 0‘ is a lambda expression.

Find even numbers in stream
```java
import java.util.Arrays;
import java.util.List;
 
public class Main 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 
        list.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}
```
> Program output.

> Output
> 2
> 4
> 6
> 8
> 10

#### 2.2. Filtering a Stream using Custom Predicate
This example is a rewrite of the first example. It uses Predicate class in place of the lambda expression, though both are the same things.

Note that we can write any condition inside the predicate, to match the business requirements.

Find even numbers from Stream using Predicateream
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
 
public class Main 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
         
        Predicate<Integer> condition = new Predicate<Integer>() 
        {
            @Override
            public boolean test(Integer n) {
                if (n % 2 == 0) {
                    return true;
                }
                return false;
            }
        };
 
        list.stream().filter(condition).forEach(System.out::println);
    }
}
```
> Program output.
> Output
> 2
> 4
> 6
> 8
> 10

#### 2.3. Filtering and Collecting into a List
We can use the collect(Collectors.toList()) method to collect the Stream of filtered elements into a List.

This example is again a rewrite of the first example. Here, we are collecting the even numbers into a List rather than printing them to the Console.

Collecting filtered items into a List
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
 
public class Main 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 
        List<Integer> evenNumbers = list.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
         
        System.out.println(evenNumbers);
    }
}
```
> Program output.
> Output
> [2, 4, 6, 8, 10]

#### 2.4. Stream filter() and map() Example
We can use the map() method to collect the stream elements and then convert each number to its square before collecting it to the List.

Find even numbers in stream and collect the squares
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
 
public class Main 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 
        List<Integer> evenNumbers = list.stream()
                    .filter(n -> n % 2 == 0)
                    .map(n -> n * n)
                    .collect(Collectors.toList());
         
        System.out.println(evenNumbers);
    }
}
```
> Program output.
> Output
> [4, 16, 36, 64, 100]

#### 2.5. Stream filter() with a method throwing Exception
The methods used in predicates return a boolean value. These methods generally do simple value comparisons and do not throw any Exception.

But, sometimes, we may need to deal with such methods which throw an exception and this method has to be used in the Predicate.

To solve this problem, we must use try-catch statement to catch the checked exception. Then we have a choice to either handle the exception or rethrow as an unchecked exception.

Given below is a code example to handle checked exceptions thrown from a method that has been used in a Predicate.
```java
List<Integer> evenNumbers = list.stream()
    .filter(a -> {
            try {
                return a.someMethodThrowingCheckedException();
            } catch (IOException e) {
                throw new UncheckedException(e);
            }
        })
    .collect(Collectors.toList());
```
</details> 
 <details>
<summary><b>6.22 Java Stream forEachOrdered()</b></summary>

# Java Stream forEachOrdered()

The Stream forEachOrdered() method is used to iterate over all the elements of the given Stream and to perform a Consumer action on each element of the Stream, in the encounter order of the Stream if the Stream has a defined encounter order.

### 1. Stream forEachOrdered() Method
#### 1.1. Method Syntax
The forEachOrdered() method syntax is as follows:

> Syntax
> void forEachOrdered(Consumer<? super T> action)

Here Consumer is a functional interface and action represents a non-interfering action to be performed on each element in the stream.

#### 1.2. Description
The forEachOrdered() method is a terminal operation. It means that it does not return an output of type Stream.
After forEachOrdered() is performed, the stream pipeline is considered consumed, and can no longer be used.
If we need to traverse the same data source again, we must return to the data source to get a new stream.
Performs an action for each element of this stream, in the encounter order of the stream if the stream has a defined encounter order.
Performing the action for one element happens-before performing the action for subsequent elements. But for any given element, the action may be performed in whatever Thread the library chooses.
### 2. Stream forEach() vs forEachOrdered()
The behavior of forEach() operation is explicitly non-deterministic. For parallel streams, forEach() operation does not guarantee to respect the encounter order of the Stream.

While the forEachOrdered() operation respects the encounter order of the stream if the stream has a defined encounter order. This behavior is also true for parallel streams as well as sequential streams.

We may lose the benefits of parallelism if we use forEachOrdered() with parallel Streams.

Let us understand with a Java program that iterates over a Stream of Integers and verifies encounter order.
```java
List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
 
list.stream().parallel().forEach( System.out::println );    //1
 
list.stream().parallel().forEachOrdered( System.out::println ); //2
```
Now, lets compare the output of both statements

//forEach()
> 6
> 10
> 8
> 4
> 2
 
//forEachOrdered()
> 2
> 4
> 6
> 8
> 10

### 3. Stream forEachOrdered() Examples
Example 1: Java program to iterate over Stream of Integers and to print into the Console
```java
List<Integer> list = Arrays.asList(2, 4, 6, 8, 10); 
 
list.stream()
    .forEachOrdered( System.out::println );
```
> Program output.
> 2
> 4
> 6
> 8
> 10

Example 2: Java program to iterate over Stream of Integers in reverse order
```java
List<Integer> list = Arrays.asList(2, 4, 6, 8, 10); 
 
list.stream()
  .sorted(Comparator.reverseOrder())
  .forEachOrdered(System.out::println);
```
> Program output.

> 10
> 8
> 6
> 4
> 2
</details> 
 <details>
<summary><b>6.23 Java Stream forEach()</b></summary>

# Java Stream forEach()

Java Stream forEach() method is used to iterate over all the elements of the given Stream and to perform an Consumer action on each element of the Stream.

The forEach() is a more concise way to write the for-each loop statements.

### 1. Stream forEach() Method
#### 1.1. Method Syntax
The forEach() method syntax is as follows:

> Syntax
> void forEach(Consumer<? super T> action)

Consumer is a functional interface and action represents a non-interfering action to be performed on each element in the Stream. It accepts an input and returns no result.

#### 1.2. Description
The forEach() method is a terminal operation. It means that it does not return an output of type Stream.
After forEach() is performed, the stream pipeline is considered consumed, and Stream can no longer be used.
If we need to traverse the same data source again (the collection backing the Stream), we must return to the data source to get a new stream.
For parallel streams, the forEach() operation does not guarantee the order of elements in the stream, as doing so would sacrifice the benefit of parallelism.
If the provided Consumer action accesses the shared state between the Stream elements the action is responsible for providing the required synchronization.
#### 2. Stream forEach() Examples
Example 1: Traversing the elements of a Stream and printing them
In this Java example, we are iterating over a Stream of Integers and printing all the integers to the standard output.

Stream forEach() Example
```java
List<Integer> list = Arrays.asList(2, 4, 6, 8, 10); 
Consumer<Integer> action = System.out::println;
 
list.stream()
    .forEach( action );
```
Note that we can write the above iteration using the enhanced for-loop as well.

Same iteration Using enhanced for loop
```java
for (Integer i : list) {
  System.out.println(i);
}
```
Example 2: Traversing the elements in reverse order and printing them
Java example to iterate over stream elements and print them in reverse order.

Stream forEach() in Reverse Order
```java
List<Integer> list = Arrays.asList(2, 4, 6, 8, 10); 
 
list.stream()
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println);
```
> Program output.

> 10
> 8
> 6
> 4
> 2

### 3. Conclusion
In this tutorial, we learned to use the forEach() method to iterate through all the elements of a Stream.

Though we can use the enhanced for-each loop for the iteration, the primary difference between the forEach() method and for-each loop is that the for-each loop is an external iterator, whereas the new forEach() method is an internal iterator.
</details> 
 <details>
<summary><b>6.24 Java Stream distinct()</b></summary>

# Java Stream distinct(): Get Unique Values from Stream

Added in Java 8, the Stream.distinct() method returns a new Stream consisting of the distinct elements from the given Stream. The distinct() operation removes duplicate elements from a stream, ensuring that only unique elements are retained in the resulting stream.

### Quick Reference
> List<T> distinctItems = stream.distinct().toList();

### 1. Stream.distinct() Method
The distict() is one such stateful intermediate operation that uses the state from previously seen elements from the Stream while processing the new items.

> Method Syntax
> Stream<T> distinct()

The distinct() returns the distinct elements from the given stream. For checking the equality of the stream elements, the equals() method is used.

The distinct() guarantees the ordering for the streams backed by an ordered collection. The element appearing first in the encounter order is preserved for ordered streams.

For unordered streams, no stability guarantees are made.
### 2. Find Distinct Elements in a Stream of Strings or Primitives
It is easy to find distinct items from a list of simple types such as String and wrapper classes. These classes implement the required equals() method, which compares the value stored in it.

In the given example, we have List of strings and we want to find all distinct strings from the List. We will use Stream to iterate over all the String elements and collect the distinct String elements into another List using Stream.collect() terminal operation.

Find all distinct strings
```java
Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
 
List<String> distinctChars = list.stream()
                        .distinct()
                        .collect(Collectors.toList());    //[A, B, C, D]
```
### 3. Stream Distincts By Field or Property
In real-world applications, we will be dealing with a stream of custom classes or complex types (representing some system entity).

By default, all Java objects inherit the equals() method from Object class. The default equals() method compares the references for checking the equality of two instances. So, it is highly recommended to override the equals() method and define custom logic for object equality. If we do not override the equals() method in our custom type, then we may see strange behavior while finding the distinct elements from a Stream.

#### 3.1. Override equals() to Define Object Equality
Let’s create a Person class for our example. It has three fields: id, fname and lname. Two persons are equal if their ids are the same. Do not forget to override the equals() method otherwise, the object equality will not work as expected.

Two Person are equal if their id is same
```java
public record Person(Integer id, String fname, String lname) {

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Person other = (Person) obj;
    return Objects.equals(id, other.id);
  }
}
```
#### 3.2. Demo
Let’s test the code. We will add a few duplicate person records in the List. Then we will use the Stream.distinct() method to find all instances of Person class with unique id.

Find distinct persons by id
```java
Person lokeshOne = new Person(1, "Lokesh", "Gupta");
Person lokeshTwo = new Person(1, "Lokesh", "Gupta");
Person lokeshThree = new Person(1, "Lokesh", "Gupta");
Person brianOne = new Person(2, "Brian", "Clooney");
Person brianTwo = new Person(2, "Brian", "Clooney");
Person alex = new Person(3, "Alex", "Kolen");
 
Collection<Person> list = Arrays.asList(alex, 
                                        brianOne, 
                                        brianTwo, 
                                        lokeshOne, 
                                        lokeshTwo, 
                                        lokeshThree);

// Get distinct people by id
List<Person> distinctElements = list.stream()
            .distinct()
            .collect( Collectors.toList() );

System.out.println( distinctElements );
```
> Program output:

> Output
> [
> Person [id=1, fname=Lokesh, lname=Gupta],
> Person [id=2, fname=Brian, lname=Clooney],
> Person [id=3, fname=Alex, lname=Kolen]
> ]

### 4. Find Distinct Items by Complex Keys or Multiple Fields
We may not always get distinct items based on the natural equality rules. Sometimes, business wants to find distinct items based on custom logic. For example, we may need to find all people who may have any id but their full name is the same. In this case, we must check the equality based on Person class’s fname and lname fields.

Java does not have any native API for finding distinct objects while comparing the objects using a provided user function. So we will create our own utility function and then use it.

We can use the information on the linked post to find the items that are distinct by multiple fields.

#### 4.1. Create distinctByKey() Method
The distinctByKey() function uses a ConcurrentHashMap instance to find out if there is an existing key with the same value – where the key is obtained from a function reference.

The parameter to this function is a lambda expression used to generate the map key for the comparison. If the used key is a custom type, do not forget to override the hashCode() and equals() method.

Utility function to find distinct by class field
```java
public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
{
    Map<Object, Boolean> map = new ConcurrentHashMap<>();
    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
}
```
We can pass any field-getter method as a method argument which will cause the field value to act as the key to the map.

#### 4.2. Demo
Check how we are using distinctByKey(p -> p.getFname() + " " + p.getLname()) in the filter() method.

Find all people who may have any id but their full name is the same
```java
Person lokeshOne = new Person(1, "Lokesh", "Gupta");
Person lokeshTwo = new Person(2, "Lokesh", "Gupta");
Person lokeshThree = new Person(3, "Lokesh", "Gupta");
Person brianOne = new Person(4, "Brian", "Clooney");
Person brianTwo = new Person(5, "Brian", "Clooney");
Person alex = new Person(6, "Alex", "Kolen");
 
Collection<Person> list = Arrays.asList(alex, 
                                        brianOne, 
                                        brianTwo, 
                                        lokeshOne, 
                                        lokeshTwo, 
                                        lokeshThree);

// Get distinct objects by key
List<Person> distinctElements = list.stream()
            .filter( distinctByKey(p -> p.getFname() + " " + p.getLname()) )
            .collect( Collectors.toList() );

System.out.println( distinctElements );
```
> Program Output:

> Output
> [
> Person [id=1, fname=Lokesh, lname=Gupta],
> Person [id=4, fname=Brian, lname=Clooney],
> Person [id=6, fname=Alex, lname=Kolen]
> ]

### 5. Conclusion
The primary purpose of Stream.distinct() is to eliminate duplicate elements from a given stream, guaranteeing that only distinct elements remain in the resulting stream. When applied to a stream, the distinct() operation leverages the equals() and hashCode() methods of the objects within the stream to identify and remove duplicates.

While filtering out duplicates, distinct() operation preserves the original order of elements in the stream.

</details> 
<details>
<summary><b>6.25 Java Stream map() and reduce()</b></summary>
	
- POJO Class :

```java
public class Employee {
    private int id;
    private String name;
    private String grade;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String grade, double salary) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

- DAO Layer
  
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

    public static List<Employee> getEmployees(){
      return  Stream.of(new Employee(101,"john","A",60000),
              new Employee(109,"peter","B",30000),
              new Employee(102,"mak","A",80000),
              new Employee(103,"kim","A",90000),
              new Employee(104,"json","C",15000))
              .collect(Collectors.toList());
    }
}
```

- Service Class
  
```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        int sum = 0;
        for (int no : numbers) {
            sum = sum + no;
        }
        System.out.println(sum);

        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodReference.get());

        Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(mulResult);

        Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxvalue);

        Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxvalueWithMethodReference);

        String longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(longestString);

        //get employee whose grade A
        //get salary
        double avgSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println(avgSalary);

        double sumSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .sum();
        System.out.println(sumSalary);
    }
}
```
</details> 
<details>
<summary><b>6.26 Java Stream ParallelStream</b></summary>

In Java 8, Streams provide a new way to work with collections of objects. Streams enable you to perform aggregate operations on collections of objects, such as filtering, mapping, and reducing. There are two types of Streams in Java 8: sequential and parallel streams.

**Sequential Stream**: A sequential stream processes the elements of a collection one by one in a linear order. This means that each element is processed in sequence before moving on to the next element. Sequential streams are useful when the order of processing is important, or when the operations are dependent on each other.

Example: Suppose you have a list of numbers and you want to find the sum of all the even numbers in the list using a sequential stream. Here is how you can do it:

 
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

int sum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

System.out.println("Sum of even numbers: " + sum);

**Parallel Stream**: A parallel stream processes the elements of a collection concurrently, dividing the workload among multiple threads. 

This can result in improved performance, particularly when working with large datasets that can be processed in parallel.

Example: Suppose you have a list of strings and you want to concatenate them into a single string using a parallel stream. Here is how you can do it:

List<String> words = Arrays.asList("hello", "world", "java", "stream");

String result = words.parallelStream()
                .reduce("", (str1, str2) -> str1 + " " + str2);

System.out.println("Concatenated string: " + result);

#### Sequential vs Parallel Stream:

Sequential streams are suitable for small datasets or operations where the order of processing is important.

Parallel streams are suitable for large datasets or operations that can be divided and processed concurrently.

Parallel streams may provide better performance, but they can also introduce complexity and require careful consideration of thread safety.

Overall, the choice between sequential and parallel streams in Java 8 depends on the specific requirements of your application and the characteristics of the dataset you are working with.

Sequential Stream | Parallel Stream |
----- | ----- |
Processes elements in a serial order | Processes elements concurrently |
Executes operations one after the other | Executes operations in parallel |
Recommended for small collections with fewer elements | Recommended for large collections with many elements | 
Useful when the order of processing is important | Useful when processing speed is more important than order|
Utilizes a single thread for processing | Utilizes multiple threads for processing |
Performance may be slower for large collections | Performance may be faster for large collections|
Less complex and easier to implement | More complex and may require additional handling for thread safety|

- POJO Class :

```java
public class Employee {
    private int id;
    private String name;
    private String grade;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String grade, double salary) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

- DAO Layer
  
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

    public static List<Employee> getEmployees(){
      return  Stream.of(new Employee(101,"john","A",60000),
              new Employee(109,"peter","B",30000),
              new Employee(102,"mak","A",80000),
              new Employee(103,"kim","A",90000),
              new Employee(104,"json","C",15000))
              .collect(Collectors.toList());
    }
}
```

- Service Class
  
```java
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        long start=0;
        long end=0;

        start=System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Plain stream took time : "+(end-start));

       System.out.println("============================================");

       start=System.currentTimeMillis();
       IntStream.range(1,100).parallel().forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Parallel stream took time : "+(end-start));

        IntStream.range(1,10).forEach(x->{
            System.out.println("Thread : "+Thread.currentThread().getName()+" : "+x);
        });

        IntStream.range(1,10).parallel().forEach(x->{
            System.out.println("Thread : "+Thread.currentThread().getName()+" : "+x);
        });

        List<Employee> employees = EmployeeDatabase.getEmployees();

        //normal
        start=System.currentTimeMillis();
        double salaryWithStream = employees.stream()
                .map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        end=System.currentTimeMillis();

        System.out.println("Normal stream execution time : "+(end-start)+" : Avg salary : "+salaryWithStream);

        start=System.currentTimeMillis();
        double salaryWithParallelStream = employees.parallelStream()
                .map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();

        end=System.currentTimeMillis();

        System.out.println("Parallel stream execution time : "+(end-start)+" : Avg salary : "+salaryWithParallelStream);
    }
}
```
</details> 
</details>  

<details>
<summary><b>7. Advance Topics</b></summary>

<details>
<summary><b>7.1 How To Debug Java Streams</b></summary>

# How To Debug Java Streams

Java Streams, added in Java 8, became popular very fast and are a powerful way to process collections of objects. A Stream is a sequence of objects from a source and supports chained methods to produce the desired result.

Debugging Java streams can be challenging. In this post, we will learn to debug the streams as their elements are processed in the chained method calls.

### 1. Why are Streams Hard to Debug?
Java 8 Streams may sometimes be difficult to debug. This happens because they require us to insert additional breakpoints and thoroughly analyze each transformation inside the stream.

For example, we have the Student class:
```java
public class Student {

    private String name;
    private String email;
    private Double grade;
    
    //getters, setters, constructor, toString method
}
```
We can create a list of students:
```java
List<Student> students = List.of(
    new Student("Alexandru","alex@gmail.com",5.6),
    new Student("Emmanuela","emma@yahoo.com",7.2),
    new Student("John","john@gmail.com",10.0),
    new Student("Andrew","andrew",6.2),
    new Student("Anna","anna@gmail.com",6.2)
);
```
Suppose, we want to get all the students in alphabetical order that have a valid email address and a passing grade. So we use the stream API operations:
```java
List<Student> newList = students.stream()
    .filter(student -> student.getEmail().endsWith("@gmail.com"))
    .filter(student -> student.getGrade() > 5.0)
    .sorted(Comparator.comparing(Student::getName))
    .collect(Collectors.toList());
```
After running the program we get only one student. So we want to debug the stream to see how it filters the students.

See Also: Guide to Java Stream API

### 2. Debug using peek() API
We can debug the stream using the peek() method to log the information about the data at every step. The peek() method returns a stream consisting of the elements of the source stream and performs the action requested by the client of each element.
```java
List<Student> newList = students.stream()
    .filter(student -> student.getEmail().endsWith("@gmail.com"))
    .peek(student -> System.out.println("Filtered 1 value:" + student))
    .filter(student -> student.getGrade() > 5.0)
    .peek(student -> System.out.println("Filtered 2 value:" + student))
    .sorted(Comparator.comparing(Student::getName))
    .collect(Collectors.toList());
```
Notice the program output. We can see that peek() method clearly prints the elements of the stream in the pipeline after each call to filter() method. We can see that 3 students pass the first filter and only one passes the second one too.
```java
Filtered 1 value:Student{name="Alexandru", email="alex@gmail.com", grade=2.6}
Filtered 1 value:Student{name="John", email="john@gmail.com", grade=10.0}
Filtered 2 value:Student{name="John", email="john@gmail.com", grade=10.0}
Filtered 1 value:Student{name="Anna", email="anna@gmail.com", grade=4.2}
```
### 3. Debug using IntelliJ Stream Debugger
The IntelliJ Stream Debugger is a hidden gem and is very easy to use. It allows you to visualize the stream. Let’s use this in our example.

For the first step, we will set a breakpoint on the stream.

Now we will run the program in debugging mode. The program will be suspended when the stream is created.

And now we will press the button “Trace Current Stream Chain”. A new tab will open, and here we can see how the stream does filter the data.

### 4. Conclusion
Streams may be seen as difficult to debug. But here the special methods of the Streams API, as well as the special tools of the IDEs that we use daily, come to our aid.
</details>   
<details>
<summary><b>7.2 Important Features of Streams</b></summary>

# Java 8 Stream Intermediate And Terminal Operations

Java 8 Stream has many operations which can be pipe lined together to get desired result. Some operations produce another stream as a result and some operations produce non-stream values as a result. The operations which return another stream as a result are called intermediate operations and the operations which return non-stream values like primitive or object or collection or return nothing are called terminal operations. In this post, we will see the differences between Java 8 Stream intermediate and terminal operations.

Also Read : Solving Real Time Queries Using Java 8 Features – Employee Management System

## Java 8 Stream Intermediate And Terminal Operations :
1) The main difference between intermediate and terminal operations is that intermediate operations return a stream as a result and terminal operations return non-stream values like primitive or object or collection or may not return anything.
2) As intermediate operations return another stream as a result, they can be chained together to form a pipeline of operations. Terminal operations can not be chained together.
3) Pipeline of operations may contain any number of intermediate operations, but there has to be only one terminal operation, that too at the end of pipeline.
4) Intermediate operations are lazily loaded. When you call intermediate operations, they are actually not executed. They are just stored in the memory and executed when the terminal operation is called on the stream.
5) As the names suggest, intermediate operations doesn’t give end result. They just transform one stream to another stream. On the other hand, terminal operations give end result.
6) Intermediate Operations :
map(), filter(), distinct(), sorted(), limit(), skip()
7) Terminal Operations :
forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()

## Below is the list of intermediate and terminal operations.


| Operation 	| Return Type 	       | Type Of Operation  |  What it does? 			| 
|---------------|----------------------|--------------------|-------------------------------------------------------------------|
| map() 		| Stream<T> 		   | Intermediate 		| Returns a stream consisting of results after applying given function to elements of the stream. 	   |
| filter() 		| Stream<T> 		   | Intermediate 		| Returns a stream of elements which satisfy the given predicate.|
| distinct()	| Stream<T> 		   | Intermediate 		| Returns a stream of unique elements.| 
| sorted() 		| Stream<T> 		   | Intermediate 		| Returns a stream consisting of elements sorted according to natural order. |
| limit() 		| Stream<T> 		   | Intermediate 		| Returns a stream containing first n elements.	| 
| skip() 		| Stream<T> 		   | Intermediate 		| Returns a stream after skipping first n elements.| 
|	|	|	|	|
| forEach() 	| void				   | Terminal 			| Performs an action on all elements of a stream.|
| toArray() 	| object[] 			   | Terminal 			| Returns an array containing elements of a stream.|
| reduce()		| type T 			   | Terminal 			| Performs reduction operation on elements of a stream using initial value and binary operation. 	   |
| collect()		| Container of type R  | Terminal 	 		| Returns mutable result container such as List or Set.| 
| min() 		| Optional<T>		   | Terminal 			| Returns minimum element in a stream wrapped in an Optional object. |
| max() 		| Optional<T>		   | Terminal 			| Returns maximum element in a stream wrapped in an Optional object.| 
| count() 		| Long 				   | Terminal			| Returns the number of elements in a stream. | 
| anyMatch() 	| Boolean 			   | Terminal 			| Returns true if any one element of a stream matches with given predicate.|
| allMatch()	| Boolean 			   | Terminal 			| Returns true if all the elements of a stream matches with given predicate.| 
| noneMatch() 	| Boolean		       | Terminal 			| Returns true only if all the elements of a stream doesn't match with given predicate.| 
| findFirst() 	| Optional<T> 		   | Terminal 			| Returns first element of a stream wrapped in an Optional object. | 
| findAny() 	| Optional<T> 		   | Terminal 			| Randomly returns any one element|


### Java 8 Stream Intermediate Vs Terminal Operations

| Intermediate Operations  | Terminal Operations |
|---------------|----------------------|
| They return stream.| They return non-stream values.|
| They can be chained together to form a pipeline of operations. | They can’t be chained together. |
| Pipeline of operations may contain any number of intermediate operations.| Pipeline of operations can have maximum one terminal operation, that too at the end. |
| Intermediate operations are lazily loaded. | Terminal operations are eagerly loaded.|
| They don’t produce end result. | They produce end result.|
| Examples :	filter(), map(), distinct(), sorted(), limit(), skip()	| Examples : forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()|

	
	
|Operation|Type	|Description|
|---------------|----------------|---------------|
|filter	|Stateless|Returns a new stream consisting of elements that match the given predicate.|
|map|Stateless|Returns a new stream consisting of the results of applying the given function to the elements of this stream.|
|flatMap|Stateless|Returns a new stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.|
|sorted|Stateful|Returns a stream consisting of the elements of this stream sorted according to the provided Comparator.|
|peek|Stateless|Returns a stream consisting of the elements of this stream additionally performing the provided action on each element as elements are consumed from the resulting stream.|
|limit|Stateless|Returns a stream consisting of the elements of this stream truncated to be no longer than the specified maximum size.|
|skip|Stateless|Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.|
		
|Operation	|		Type|		Description|
|---------------|----------------------|----------------------|
|forEach|Terminal|Performs an action for each element of this stream.|
|count|Terminal|Returns the count of elements in this stream.|
|reduce|Terminal|Performs a reduction on the elements of this stream using the provided identity value and accumulation function.|
|collect|Terminal|Performs a mutable reduction operation on the elements of this stream using a Collector.|
|anyMatch|Terminal|Returns whether any elements of this stream match the provided predicate.|
|allMatch|Terminal|Returns whether all elements of this stream match the provided predicate.|
|noneMatch|Terminal|Returns whether no elements of this stream match the provided predicate.|
|findFirst|Terminal|Returns an Optional describing the first element of this stream or an empty Optional if the stream is empty.|
|findAny|Terminal|Returns an Optional describing some element of the stream or an empty Optional if the stream is empty.|
|min|Terminal|Returns the minimum element of this stream according to the provided Comparator.|
|max|Terminal|Returns the maximum element of this stream according to the provided Comparator.|
|toArray|Terminal|Returns an array containing the elements of this stream.|


## The static factory methods of the Collectors class

| Factory method    | Returned type 				     | Used to 					| 
|-------------------|------------------------------------------------|------------------------------------------|
| toList 	    | List<T> 					     | Gather all the stream’s items in a List. Example use: List<Dish> dishes = menuStream.collect(toList());|
| toSet 	    | Set<T> 					     | Gather all the stream’s items in a Set, eliminating duplicates. Example use: Set<Dish> dishes = menuStream.collect(toSet());	|
| toCollection 		| Collection<T> | Gather all the stream’s items in the collection created by the provided supplier. Example use: Collection<Dish> dishes = menuStream.collect(toCollection(), ArrayList::new);			| 
| counting 			| Long 		| Count the number of items in the stream. Example use: long howManyDishes = menuStream.collect(counting());| 
| summingInt 		| Integer | Sum the values of an Integer property of the items in the stream.  Example use: int totalCalories = menuStream.collect(summingInt(Dish::getCalories));| 
| averagingInt 		| Double 	| Calculate the average value of an Integer property of the items in the stream. Example use: double avgCalories = menuStream.collect(averagingInt(Dish::getCalories)); | 
| summarizingInt 	| IntSummary-Statistics | Collect statistics regarding an Integer property of the items in the stream,	such as the maximum, minimum, total, and average. Example use: IntSummaryStatistics menuStatistics = menuStream.collect(summarizingInt(Dish::getCalories));	| 
| joining 			| String 	| Concatenate the strings resulting from the invocation of the toString method on each item of the stream. Example use: String shortMenu = menuStream.map(Dish::getName).collect(joining(", "));        		|
| maxBy 			| Optional<T> 	| An Optional wrapping the maximal element in this stream according to 	 the given comparator or Optional.empty() if the stream is empty. Example use: Optional<Dish> fattest = menuStream.collect(maxBy(comparingInt(Dish::getCalories)));	| 
| minBy 			| Optional<T> 		| An Optional wrapping the minimal element in this stream according to the given comparator or Optional.empty() if the stream is empty. 	Example use: Optional<Dish> lightest = menuStream.collect(minBy(comparingInt(Dish::getCalories)));	| 
| reducing 			| The type produced by the reduction operation 	 | Reduce the stream to a single value starting from an initial value used as accumulator and iteratively combining it with each item of the stream using a BinaryOperator.  Example use: int totalCalories = menuStream.collect(reducing(0, Dish::getCalories, Integer::sum));	| 
| collectingAndThen | The type returned by the transforming function | Wrap another collector and apply a transformation function to its result. Example use: int howManyDishes = menuStream.collect(collectingAndThen(toList(), List::size));		| 
| groupingBy 		| Map<K, List<T>> | Group the items in the stream based on the value of one of their properties and use those    values as keys in the resulting Map. Example use: Map<Dish.Type, List<Dish>> dishesByType = menuStream.collect(groupingBy(Dish::getType));| 
| partitioningBy 	| Map<Boolean, List<T>> | Partition the items in the stream based on the result of the application of a predicate to each of them. Example use: Map<Boolean, List<Dish>> vegetarianDishes =menuStream.collect(partitioningBy(Dish::isVegetarian));|
	

### 12 Common uses of Java Streams

Java Streams API was introduced in Java 8. Its aim is to provide a less verbose and concise way to carry out common operations on collections of objects.

Although it can be hard to get used to, the Java Streams API is very powerful and can be used to implement complex algorithms.

Table of Contents
Use cases
1. Filtering
2. Preprocessing
3. Conversion
4. Reduction
5. Grouping
6. Finding
7. Sorting
8. Partitioning
9. Counting
10. Range
11. Matching
12. Joining
Advantages of Streams

Some common use cases of the Java Streams API.

For those of us not proficient with the Streams API, the goal should be to keep these use cases in mind and whenever we come across one of them, we should try to implement them using Streams rather than the traditional way.

Let's establish some basics first.

stream() - creates a stream from a collection
collect() - collects the stream into an object. The object can be a collection, primitive, or a custom class.
Collectors - a class which provides (a lot of) static methods for collecting streams. We will use some of these below. Refer to the documentation for full reference.
These are the most popular stream operations and will be used in the rest of this tutorial.

## Use cases
Let's look at some use cases of streams:

## 1. Filtering
Used for removing values from a Collection based on a condition.
filter() method is used to filter the elements of a Collection based on a condition. Only matching elements are retained.
E.g. - Remove all odd numbers from a list.
```java
List<Integer> evenNumbers = originalList.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
```
## 2. Preprocessing
Useful when each value in the collection needs to be changed in place.
map() method is used to apply a function to each element of a Collection and return a new Collection of the computed values.
E.g. Convert each value to its square.
```java
List<Integer> squares = originalList.stream()
        .map(n -> n * n)
        .collect(Collectors.toList());
```
## 3. Conversion
Useful when we want to convert a Collection to another Collection.
There are multiple ways to achieve this and let's see them.
In general, as mentioned above, we can use map() and collect() methods to convert a Collection to another Collection.

Example 1. Create a Map from a List.

Convert a list of strings to a map of string and length.
```java
Map<String, Integer> wordLengths = words.stream()
        .collect(Collectors.toMap(
                word -> word,
                word -> word.length()));
```
Example 2. Convert list to sets.

This is a common use case for removing duplicates. Further, if we want to put the elements back to a list, we can use the stream() and collect() methods twice.

Convert a list of strings to a list of unique strings.
```java
// if we want to collect to a set
Set<String> uniqueWords = words.stream()
        .collect(Collectors.toSet());

// OR

// if we want to start and end as a list
List<String> uniqueWords = words.stream()
        .collect(Collectors.toSet()).stream().collect(Collectors.toList());
```
Example 3. Convert a list of Products to a list of their names. (Flattening)
```java
List<String> productNames = products.stream()
        .map(product -> product.getName())
        .collect(Collectors.toList());
```
## 4. Reduction
Reduce a Collection to a single value.
reduce() method is used to apply a function to each element of a Collection and return a single value.
Note that since the reduce() method returns a single value, it is not possible to use it to return a Collection.

E.g. Sum all the values in a list.
```java
int sum = numbers.stream()
        .reduce(0, (a, b) -> a + b);
```
## 5. Grouping
Group elements of a Collection based on a condition.
Collectors.groupingBy() method is used to group elements of a Collection based on a condition.
E.g. Group all products into lists of Products by their category.
```java
Map<String, List<Product>> productsByCategory = products.stream()
        .collect(Collectors.groupingBy(product -> product.getCategory()));
```
## 6. Finding
Finding the first or any element of a Collection which matches a condition.
findFirst() and findAny() methods are used to find the first or any element of a Collection which matches a condition.
This is typically similar to linear search.

E.g. Find the first word in a list which is longer than 5 characters.
```java
Optional<String> firstLongWord = words.stream()
        .filter(word -> word.length() > 5)
        .findFirst();
```
// Note that findFirst() and findAny() methods return Optional<T> objects.
## 7. Sorting
Sort elements of a Collection.
sorted() method is used to sort elements of a Collection.
In general, Collections.sort() is enough to sort a Collection. We can use sorted() specially if we want to follow it with another operation.

E.g. Sort a list of numbers in ascending order and then return the first k elements.
```java
List<Integer> topK = numbers.stream()
        .sorted()
        .limit(k)
        .collect(Collectors.toList());
```
## 8. Partitioning
Partition elements of a Collection based on a condition.
Collectors.partitioningBy() method is used to partition elements of a Collection based on a condition.
Partitioning is similar to grouping except it returns two Collections - one for elements matching the condition and one for elements not matching the condition.

E.g. Partition students into passing and failing.
```java
 Map<Boolean, List<Student>> passingFailing = students
        .stream()
        .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
```
## 9. Counting
Count the number of elements matching a condition.
count() method is used to count the number of elements matching a condition.
E.g. Count the number of words in a list which are longer than 5 characters.
```java
long count = words.stream()
        .filter(word -> word.length() > 5)
        .count();
```
## 10. Range
Create a range of values.
range() method is used to create a range of values.
There are special classes for creating streams of particular types - IntStream, LongStream, DoubleStream, and Stream.

These classes are useful when dealing with primitive numeric types. Internally, they use Arrays.stream() to create the stream.

E.g. Create an array of numbers from 0 to 10.
```java
int[] numbers = IntStream.range(0, 10).toArray();
```
## 11. Matching
Match elements of a Collection against a predicate(condition).
Methods such as anyMatch(), allMatch(), and noneMatch() are used to match elements of a Collection against a predicate and return a boolean value.
E.g. Check for products with a price greater than 10.
```java
// true when all elements match the predicate
boolean allMatch = products.stream()
        .allMatch(product -> product.getPrice() > 10);

// true when any element matches the predicate
boolean anyMatch = products.stream()
        .anyMatch(product -> product.getPrice() > 10);

// true when no elements match the predicate
boolean noneMatch = products.stream()
        .noneMatch(product -> product.getPrice() > 10);
```
## 12. Joining
Join elements of a Collection into a String.
Collectors.joining() method is used to join elements of a Collection into a String.
E.g. Join all the words in a list into a single string.
```java
String joinedWords = words.stream()
        .collect(Collectors.joining(" "));
```
Thats it for the common scenarios. There are other less common scenarios you can explore on your own:

- Parallel Streams
- Statistics
- Custom Collectors.
## Advantages of Streams
- Less Verbose Code - Reduces the amount of code needed to process a Collection.
- Lesser intermediate variables - Intermediate variables can be an opportunity to make mistakes. Having fewer of them can help us avoid unexpected bugs.
- Intuitive code - Some developers will disagree that streams are more intuitive than other methods. However, they are much more intuitive than other methods once we get used to them. Reading 5 lines to understand that we are filtering and removing products from a list isn't intuitive compared to reading just a filter() method.

## Java Streams By Example

In this blog, we are going to take a closer look at the Java 8 Streams API. We will mainly do so by means of examples. We will cover many operations and after reading this blog, you will have a very good basic understanding of the Streams API. Enjoy reading!

## 1. Introduction
The Streams API has been introduced in Java 8 and has been part of the Java language specification for several years by now. Nevertheless, it might be that Streams seem a bit magical to you. Therefore, we will cover the basic concepts of Streams and explain them with some examples.

It all starts with the java.util.stream package. The offical Java documentation for this package which contains some good reference documentation, can be found here. Some characteristics of Streams (taken from the official documentation) compared to Collections are:

Streams do not store data. Instead, they are a source for data.
Streams are functional in nature and this is probably why Streams are difficult to comprehend for most people. They produce a result, e.g. like a sum or a new Stream.
Streams are lazyness seeking. Operations can be intermediate or terminal. We will cover both in the next sections. Intermediate operations are always lazy. E.g. find the first occurrence of an element in the Stream. It is not necessary to inspect all elements of the Stream. Once the first occurrence has been found, the search can be ended.
Possibly unbounded. As long as the Stream produces data, the Stream will not end.
The elements of a Stream can only be visited once, just like an Iterator.
In the next sections we will cover how to create Streams, cover some intermediate operations and finally we will cover some terminal operations. The sources are available at GitHub.

## 2. Create a Stream Source
There are several ways for creating Streams. They can be created from a Collection, from an Array, from a file, etc. In this section, we will create some tests which will show you how to create Streams in varying ways. We will create the Stream and use the terminal operation collect in order to consume the Stream into a List. We do not perform any other operations on the Stream yet, we leave that for the other sections. At the end, we assert whether the List is identical to what we expect. The tests are located in the MyJavaStreams unit test.

## 2.1 Create a Stream From a Collection
Assume having a List of Strings named stringsList. We can just call the stream method of the List and then collect the results into a new List. Fairly simple and both lists are equal of course.
```java
private static final List<String> stringsList = Arrays.asList("a", "b", "c");
 
@Test
public void createStreamsFromCollection() {
    List<String> streamedStrings = stringsList.stream().collect(Collectors.toList());
    assertLinesMatch(stringsList, streamedStrings);
}
```
## 2.2 Create a Stream From Arrays
We can use Arrays.stream which takes an Array as an argument in order to create a Stream.
```java
@Test
public void createStreamsFromArrays() {
    List<String> streamedStrings = Arrays.stream(new String[]{"a", "b", "c"}).collect(Collectors.toList());
    assertLinesMatch(stringsList, streamedStrings);
}
```
## 2.3 Create a Stream From Stream.of
We can use Stream.of which takes the elements of the Stream as arguments in order to create a Stream.
```java
@Test
public void createStreamsFromStreamOf() {
    List<String> streamedStrings = Stream.of("a", "b", "c").collect(Collectors.toList());
    assertLinesMatch(stringsList, streamedStrings);
}
```
## 2.4 Create a Stream From IntStream
We can use IntStream.of which takes primitive integer values as arguments in order to create a Stream. DoubleStream.of and LongStream.of also can be used. Note that we use the terminal operation toArray in this case, this will return an array containing the elements of the Stream.
```java
@Test
public void createStreamsFromIntStream() {
    int[] streamedInts = IntStream.of(1, 2, 3).toArray();
    assertArrayEquals(new int[]{1, 2, 3}, streamedInts);
}
```
## 2.5 Create a Stream From a File
We can create a Stream from a file inputFile. The lines method of the BufferedReader class will stream the lines.
```java
@Test
public void createStreamsFromFile() {
    try {
        List<String> expectedLines = Arrays.asList("line1", "line2", "line3");
        BufferedReader reader = new BufferedReader(new FileReader(new File("test/com/mydeveloperplanet/inputfile.txt")));
        List<String> streamedLines = reader.lines().collect(Collectors.toList());
        assertLinesMatch(expectedLines, streamedLines);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
```
## 3. Intermediate operations
Streams become interesting when we can perform operations to them. The first category are intermediate operations. These operations return a new Stream but do not return a final result. The intermediate operations can be categorized into stateless operations, retaining no information about the previously processed element, and stateful operations which may need to process all of the elements before producing an intermediate result.

The complete list of operations which can be invoked, can be found in the Streams API.

In the folowing examples, we will make use of a Car object containing four parameters: id, brand, type and color. The Car object also contains getters and implementations for equals, hashCode and toString, which we do not list here for brevity, but it should be clear what these do.
```java
public class Car {
    private int id;
    private String brand;
    private String type;
    private String color;
 
    public Car (int id, String brand, String type, String color) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.color = color;
    }
    ...
}
```
In the unit test, we define four Car objects which we will use in the next examples:
```java
private static final Car volkswagenGolf = new Car(0, "Volkswagen", "Golf", "blue");
private static final Car skodaOctavia = new Car(1, "Skoda", "Octavia", "green");
private static final Car renaultKadjar = new Car(2, "Renault", "Kadjar", "red");
private static final Car volkswagenTiguan = new Car(3, "Volkswagen", "Tiguan", "red");
```
## 3.1 Stateless Operations
### 3.1.1 The Filter Operation
The filter operation allows us to create a new Stream based on a given Predicate. In the example, we first create a Stream of the 4 cars and create a new Stream with only the Volkswagen cars.
```java
@Test
public void filterStream() {
    List<Car> expectedCars = Arrays.asList(volkswagenGolf, volkswagenTiguan);
    List<Car> filteredCars = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                   .filter(car -> car.getBrand().equals("Volkswagen"))
                                   .collect(Collectors.toList());
    assertIterableEquals(expectedCars, filteredCars);
}
```
### 3.1.2 The map Operation
In all the previous examples, the types in the source Stream and the resulting Stream were always identical. Often, you want to apply a function on each element. E.g. if we want the resulting Stream to only contain the brands instead of the Car objects, we can use the map operation and apply the getBrand method to each element which results in a new Stream with only the brand names.
```java
@Test
public void mapStream() {
    List<String> expectedBrands = Arrays.asList("Volkswagen", "Skoda", "Renault", "Volkswagen");
    List<String> brands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                .map(Car::getBrand)
                                .collect(Collectors.toList());
    assertIterableEquals(expectedBrands, brands);
}
```
### 3.1.3 Combine filter and map operation
Of course, it is perfectly valid to combine operations and chain them in a Stream pipeline. In the next example, we filter in order to retrieve the Volkswagen cars and then use the map operation in order to retrieve only the colors. This way, we end up with a list containing the colors of the Volkswagen cars.
```java
@Test
public void filterMapStream() {
    List<String> expectedColors = Arrays.asList("blue", "red");
    List<String> volkswagenColors = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                          .filter(car -> car.getBrand().equals("Volkswagen"))
                                          .map(Car::getColor)
                                          .collect(Collectors.toList());
    assertIterableEquals(expectedColors, volkswagenColors);
}
```
## 3.2 Stateful Operations
### 3.2.1 The distinct Operation
The distinct operation will return a Stream containing only distinct elements based on equals method implementation of the elements. In the next example, we first retrieve a Stream of the brands and then perform the distinct operation to it. This results in a list of the three distinct brands we used.
```java
@Test
public void distinctStream() {
    List<String> expectedBrands = Arrays.asList("Volkswagen", "Skoda", "Renault");
    List<String> brands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                .map(Car::getBrand)
                                .distinct()
                                .collect(Collectors.toList());
    assertIterableEquals(expectedBrands, brands);
}
```
### 3.2.2 The sorted Operation
The sorted operation will sort the elements of the Stream according to their natural order. It is also possible to use a Comparator as an argument in order to have a more custom sorting. The next example will retrieve the brands from the Stream and sort them alphabetically.
```java
@Test
public void sortedStream() {
    List<String> expectedSortedBrands = Arrays.asList("Renault", "Skoda", "Volkswagen", "Volkswagen");
    List<String> brands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                .map(Car::getBrand)
                                .sorted()
                                .collect(Collectors.toList());
    assertIterableEquals(expectedSortedBrands, brands);
}
```
## 3.3 Peek For Debugging Purposes
The last intermediate operation we will discuss is the peek operation. This is a special one and is mainly intended to be used for debugging purposes. Peek will execute an action on the element when it is being consumed. Let’s take the combined filter and map example and add some peek operations to it in order to print the elements being consumed.
```java
@Test
public void peekStream() {
    List<String> expectedColors = Arrays.asList("blue", "red");
    List<String> volkswagenColors = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                          .filter(car -> car.getBrand().equals("Volkswagen"))
                                          .peek(e -> System.out.println("Filtered value: " + e))
                                          .map(Car::getColor)
                                          .peek(e -> System.out.println("Mapped value: " + e))
                                          .collect(Collectors.toList());
    assertIterableEquals(expectedColors, volkswagenColors);
}
```
The output of this test is:

Filtered value: Car{id=0, brand='Volkswagen', type='Golf', color='blue'}
Mapped value: blue
Filtered value: Car{id=3, brand='Volkswagen', type='Tiguan', color='red'}
Mapped value: red
## 4. Terminal Operations
In this section, we will cover some terminal operations.

### 4.1 The collect Operation
We already used the collect terminal operation in all of the previous examples. We always used the Collectors.toList argument in the collect operation. There are more options to use though. We will cover some in the next examples. The complete list can be found in the JavaDoc.

With Collectors.joining, we can concatenate the elements as String separated by a delimiter.
```java
@Test
public void collectJoinStream() {
    String expectedBrands = "Volkswagen;Skoda;Renault;Volkswagen";
    String joinedBrands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                .map(Car::getBrand)
                                .collect(Collectors.joining(";"));
    assertEquals(expectedBrands, joinedBrands);
}
```
With Collectors.summingInt, we can compute the sum of properties of elements. In our example, we just compute the sum of the id’s of the Cars.
```java
@Test
public void collectSummingIntStream() {
    int sumIds = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                       .collect(Collectors.summingInt(Car::getId));
   assertEquals(6, sumIds);
}
```
With Collectors.groupingBy, we can group elements in a Map. In our example, we group the elements based on the brand.
```java
@Test
public void collectGroupingByStream() {
    Map<String, List<Car>> expectedCars = new HashMap<>();
    expectedCars.put("Skoda", Arrays.asList(skodaOctavia));
    expectedCars.put("Renault", Arrays.asList(renaultKadjar));
    expectedCars.put("Volkswagen", Arrays.asList(volkswagenGolf, volkswagenTiguan));
 
    Map<String, List<Car>> groupedCars = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                                               .collect(Collectors.groupingBy(Car::getBrand));
    assertTrue(expectedCars.equals(groupedCars));
}
```
### 4.2 The reduce Operation
The reduce operation performs a reduction on the elements of a Stream. It uses an identity (i.e. starting value) and an accumalator function which performs the reduction. In our example, we perform a summation over the id’s of the elements, just like we did when we used the Collectors.summingInt collect operation.
```java
@Test
public void reduceStream() {
    int sumIds = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                       .map(Car::getId)
                       .reduce(0, Integer::sum);
    assertEquals(6, sumIds);
}
```
### 4.3 The forEach Operation
The forEach operation performs a function to every element. It is quite similar to the intermediate peek operation.
```java
@Test
public void forEachStream() {
    Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
          .forEach(System.out::println);
}
```
The outcome of this test is the following:
```java
Car{id=0, brand='Volkswagen', type='Golf', color='blue'}
Car{id=1, brand='Skoda', type='Octavia', color='green'}
Car{id=2, brand='Renault', type='Kadjar', color='red'}
Car{id=3, brand='Volkswagen', type='Tiguan', color='red'}
```
### 4.4 The count operation
The count operation counts the number of elements in the Stream.
```java
@Test
public void countStream() {
    long count = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan).count();
    assertEquals(4, count);
}
```
### 4.5 The max Operation
The max operation returns the maximum element of the Stream based on the given Comparator. In our example, we create a Stream of the id’s and retrieve the element with the highest id. Remark that this returns an Optional. We just provided an alternative value when the highest id could not be determined.
```java
@Test
public void maxStream() {
    int maxId = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                      .map(Car::getId)
                      .max((o1, o2) -> o1.compareTo(o2))
                      .orElse(-1);
    assertEquals(3, maxId);
}
```
### 5. Conclusion
The Java Streams API is very powerful and not very difficult to learn. It is very readable and removes boiler plate code. If you are not yet acquainted with the Streams API, just play around with the provided examples and you will be up to speed in no time. 
</details> 
<details>
<summary><b>7.3 Updated Version Of Streams</b></summary>

# Updated Version Of Streams
A stream is an API that defines a query on a source of values.
It's an abstraction of loops over values using a declarative API,
an API that describe the result you want and not how to compute it.

By example, to count the number of persons with a name starting by 'E',
one can write
```java
var names = List.of("Evan", "Helen", "Ebo");
var count = 0;
for(var name: names) {
  if (name.startsWith("E")) {
    count++;
  }
}
System.out.println(count);
```

But using a stream, it's simpler
```java
var names = List.of("Evan", "Helen", "Ebo");
var count = names.stream().filter(name -> name.startsWith("E")).count();
System.out.println(count);
```


### Why using streams instead of loops
The main reason is that it makes the code more readable,
obviously once you are used to read stream query,
- by allowing to easily compose operations
- by removing the declaration of intermediary local variables/states
  (the variable `count` in the example above).


## Sources
There are several ways to create a stream depending on the source
(The following examples are using `count()` to compute the number of values,
we will see later that the API is richer)

- stream of values
```java
var empty = Stream.empty();
var one = Stream.of(4);
var many = Stream.of("hello", "stream");
System.out.println("empty count " + empty.count());
System.out.println("one count " + one.count());
System.out.println("many count " + many.count());
```

- stream from a collection
```java
var listStream = List.of(1, 2, 3, 4).stream();
var mapStream = Map.of("bob", 3, "ana", 7).keySet().stream();
System.out.println("list count " + listStream.count());
System.out.println("map keys count " + mapStream.count());
```

- stream from a range
```java
var range = IntStream.range(0, 10);
System.out.println("range count " + range.count());
```


## Primitive version
Streams are represented by several classes, `java.util.stream.Stream` for a stream of objects and
`IntStream`, `DoubleStream` and `LongStream` for a stream of ints, doubles and longs.
```java
Stream<String> many = Stream.of("hello", "stream");
IntStream ints = IntStream.range(0, 10);
```

Using specialized classes for the numeric types:
- avoid boxing, an IntStream is more efficient than a Stream<Integer>
- `boxed()` convert to a Stream of wrapper
- offer supplementary numeric methods like, `min`, `max`, `sum()`, etc.

To sum of the values between [0, 10[
```java
var range = IntStream.range(0, 10);
System.out.println("range sum: " + range.sum());
```


## Filter, map and flatMap
The main transformation methods are `filter`, `map` and `reduce`.

### filtering
`filter()` take a function as parameter and keep in the stream the values
for which the function returned true.

```java
record Employee(String name, int age) { }
var employees = List.of(new Employee("bob", 55), new Employee("Ana", 32));
var youngCount = employees.stream().filter(e -> e.age() < 30).count();
System.out.println(youngCount);
```

### mapping
`map()` transforms a value to another value
```java
record Employee(String name, int age) { }
var employees = List.of(new Employee("Bob", 55), new Employee("Ana", 32));
var array = employees.stream().map(Employee::name).toArray();
System.out.println(Arrays.toString(array));
```

`map()` has variations (`mapToInt`, `mapToLong`, etc) to transform to numeric streams
```java
record Employee(String name, int age) { }
var employees = List.of(new Employee("bob", 55), new Employee("Ana", 32));
var average = employees.stream().mapToInt(Employee::age).average();
System.out.println(average);
```

### flatMap
`flatMap()` transforms one value to 0 to _n_ values
```java
record Friend(String name, List<String> pets) { }
var friends = List.of(new Friend("Bob", List.of()),
   new Friend("Ana", List.of("dog", "cat")),
   new Friend("Uno", List.of("rabbit"))
   );
System.out.println(friends.stream().flatMap(friends -> friends.pets().stream()).count());
```

Like map, flatMap has also variation to numeric streams
```java
record Friend(String name, List<Integer> kidAges) { }
var friends = List.of(new Friend("Bob", List.of(1, 3)),
   new Friend("Ana", List.of(15, 17)),
   new Friend("Uno", List.of())
   );
System.out.println(friends.stream().flatMapToInt(friends -> friends.kidAges().stream().mapToInt(x -> x)).average());
```

You can notice that while there is a method boxed() to transform a numeric stream to an object stream,
there is no method unboxToInt() equivalent because `mapToInt()` can be used instead.

### flatMap is a generalization of filter and map
`filter()` result in a stream with 0 or 1 value, `map()` result in a stream with one transformed value so
both can be simulated with `flatMap()`.
So instead of
```java
record Employee(String name, int age) { }
var employees = List.of(new Employee("Bob", 55), new Employee("Ana", 32));
System.out.println(employees.stream().filter(e -> e.age() < 30).count());
System.out.println(Arrays.toString(employees.stream().map(Employee::name).toArray()));
```

one can write
```java
System.out.println(employees.stream().flatMap(e -> (e.age() < 30)? Stream.of(e): Stream.empty()).count());
System.out.println(Arrays.toString(employees.stream().flatMap(e -> Stream.of(e.name())).toArray()));
```

While flatMap can simulate filter and map, please use `filter()` and `map()` directly because 
the code is more readable and they are implemented in a more effective way.


## Distinct, sorted, min and max
Like in SQL, you can ask to filter values to only have distinct values or sort
the value with a comparator.
`distinct()` or `sorted()` are operations that requires to store all the values
in an intermediary collection so they are not cheap.

`distinct()` ask for unique values
```java
System.out.println(IntStream.range(0, 10).map(x -> x / 2).distinct().count());
```

`sorted()` ask to sort the values with a comparator
```java
record Employee(String name, int age) { }
var employees = List.of(new Employee("Bob", 55), new Employee("Ana", 32));
var youngest = employees.stream().sorted(Comparator.comparingInt(Employee::age)).findFirst();
System.out.println(youngest);
```

The Stream API also provides `min()` and `max()` that are more efficient that sorting
all the values if you just want the minimum or the maximum
```java
var youngest = employees.stream().min(Comparator.comparingInt(Employee::age));
System.out.println(youngest);
var oldest = employees.stream().max(Comparator.comparingInt(Employee::age));
System.out.println(oldest);
```


## ForEach, reduce, collect and toArray

### forEach
Takes a consumer as parameter that is called for each values of the stream
This method is not used often because if you want to do a side effect on collection
using the method `collect` is easier.
```java
record Point(int x, int y) { }
var points = List.of(
  new Point(1, 2), new Point(2, 5), new Point(3, -1));
points.stream().filter(p -> p.x() <= 2).forEach(System.out::println);
```

Note: collections (`java.util.Collection`) already have a method `forEach()`,
so no need to create a stream if you don't want to do a transformation on the
elements of the collection 
```java
record Point(int x, int y) { }
var points = List.of(new Point(2, 5));
points.stream().forEach(System.out::println); // stupid !
points.forEach(System.out::println);  // better
```

### reduce
Reduce allows to reduce all the values of a stream to only one result
by applying iteratively the same accumulator function on each value of the stream.

There are two forms of reduce
- reduce the stream values
- reduce using projected values

reduce with the stream values
```java
record Point(int x, int y) { }
var points = List.of(
  new Point(1, 2), new Point(2, 5), new Point(3, -1));
var sum = points.stream().reduce((p1, p2) -> new Point(p1.x() + p2.x(), p1.x() + p2.x()));
System.out.println("sum " + sum);
```

You can notice that the result is an `Optional` because is the stream is empty, `reduce`
has no result to return

reduce using projected values
```java
record Point(int x, int y) { }
var points = List.of(
  new Point(1, 2), new Point(2, 5), new Point(3, -1));
var sumX = points.stream().reduce(0, (acc, p) -> acc + p.x(), Integer::sum);
System.out.println("sumX " + sumX);
```

The first argument is the initial accumulator value, this is also the value
returned is the stream is empty so this variation of reduce doesn't return an `Optional`. 
The last argument of `reduce()` is only used in parallel to aggregate the values
process on different threads (see below for more info on parallel streams).

### collect
reduce works well when the result is one value but not well when the result
is a list, a map or any data structures because collections are mutable
in Java.
For that, there is another mechanism, called `collect` that takes
a `Collector` as parameter and is tailored to create, mutate, merge and
optionally makes unmodifiable any mutable collections.

This section contains only a small number of example because there is a following chapter
dedicated to collector.

While you can create your own collector by implementing the interface `Collector`,
there are already more than 20 collectors available in the class `Collectors` 
```java
import java.util.stream.Collectors;
```

`toList()`: gather all values to a list
```java
var names = List.of("Bob", "Ana", "Elvis", "Emma", "Josh");
var endsWithA = names.stream().filter(name -> name.endsWith("a")).collect(Collectors.toList());
System.out.println(endsWithA);
```

`toUnmodifiableist()`: gather all values to an unmodifiable list
```java
var names = List.of("Bob", "Ana", "Elvis", "Emma", "Josh");
var uppercases = names.stream().map(String::toUpperCase).collect(Collectors.toUnmodifiableList());
System.out.println(uppercases);
```

`toMap()`: gather all values to a map
```java
var names = List.of("Bob", "Ana", "Elvis", "Emma", "Josh");
var uppercaseMap = names.stream().collect(Collectors.toMap(name -> name, String::toUpperCase));
System.out.println(uppercaseMap);
```

`joining()`: gather all strings to one string
```java
var names = List.of("Bob", "Ana", "Elvis", "Emma", "Josh");
var asString = names.stream().collect(Collectors.joining(", "));
System.out.println(asString);
```

`groupingBy()`: gather all values into a map of list of values 
```java
var names = List.of("Bob", "Ana", "Elvis", "Emma", "Josh");
var nameByLength = names.stream().collect(Collectors.groupingBy(String::length));
System.out.println(nameByLength);
```


### toArray
Because in Java, array are typed at runtime there are two ways to create an array
from a stream
- as an array of Object
- as an array of a specific type

As an array Object
```java
var names = List.of(14, 67, 32, 78);
Object[] array = names.stream().toArray();
System.out.println(Arrays.toString(array));
```

As an array of a specific type, passing the constructor as argument
```java
var names = List.of(14, 67, 32, 78);
Integer[] array = names.stream().toArray(Integer[]::new);
System.out.println(Arrays.toString(array));
```

Note that you can provide an array type with a more specific type
because the VM will do a runtime check when the values are inserted
The following example compiles but throws a ClassCastException at runtime
```java
List<Object> names = List.<Object>of(14, 67, 32, "boom !");
Integer[] array = names.stream().toArray(Integer[]::new);
```


## Infinite Stream
Streams can be infinite (like you can create an infinite loop),
and you have shortcut methods to stop the loop.

generate an infinite number of random values between [0, 10[ as String
```java
var random = new Random(0);
var stream = Stream.generate(() -> "" + random.nextInt(10));
System.out.println(stream.limit(5).collect(Collectors.toList()));
```

iterate over all the power of two values
```java
var stream = IntStream.iterate(1, x -> x* 2);
System.out.println(stream.limit(5).boxed().collect(Collectors.toList()));
```

### Shortcut method `limit()`
```java
var sum = IntStream.iterate(1, x -> x* 2).limit(10).sum();
System.out.println("sum: " + sum);
```

### Shortcut method `dropWhile()`
All lines after the one that starts with `#` have a length greater than 10
```java
var text = """
  # a line
  # another one
  a line that doesn't start with #
  """;
var result = text.lines().dropWhile(l -> l.startsWith("#")).allMatch(s -> s.length() > 10);
System.out.println(result);
```

### Shortcut method `takeWhile()`
Find the first words that have a length lesser than 5
```java
var list = List.of("foo", "bar", "baz", "whizzzz", "bob");
var result = list.stream().takeWhile(s -> s.length() < 5).collect(Collectors.joining(", "));
System.out.println(result);
```

## Sequential vs parallel API
By default stream are executed sequentially in the same thread (think CPU core if you don't know what a thread is).
You can ask to split the processing of the stream on several threads using `.parallel()`
Using `.parallel()` is usually slower because you have to first distribute the calculation
and at the end gather the results from several threads. As a rule of thumb, it only worth to use `.parallel()`
if either you have a lot of value (like 100_000 or more) or the calculation is slooow.

By example, if you want to calculate the square root (not a slow operation) on the first 1_000_000 values
and prints only the first 10 values
```java
import static java.util.stream.Collectors.toList;
var squareRoots = IntStream.range(0, 1_000_000).parallel().mapToDouble(Math::sqrt).toArray();
System.out.println(Arrays.stream(squareRoots).limit(10).boxed().collect(toList()));
```

### findAny()/findFirst(), forEach()/forEachOrdered()
Because a stream can be evaluated in parallel and maintaining a strict order in parallel cost a lot,
usual methods like `findAny()` or `forEach()` doesn't maintain the order on a parallel stream.
You have to use specialized method (resp `findFirst()` and `forEachOrdered()`) to maintain the order.


## Limitations

### Reusing stream objects
You can not reuse a stream for several queries
```java
var stream = Stream.of(1, 2, 3);
System.out.println(stream.count());
System.out.println(stream.count());
```

> One query, one stream !

### Source mutation
A stream can not modify the source from which it was created
The following example throws a ConcurrentModificationException
```java
var list = new ArrayList<>(List.of("foo", "bar"));
list.stream().map(String::toUpperCase).forEach(list::add); 
```

Use an iterator (in the example a `ListIterator`) for that
```java
var list = new ArrayList<>(List.of("foo", "bar"));
var it = list.listIterator();
while(it.hasNext()) {
  var value = it.next();
  it.add(value.toUpperCase());
}
System.out.println(list);
```

</details>
<details>
<summary><b>7.4 Java Stream Exception Handling</b></summary>
	
```java

import java.lang.annotation.Target;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("44", "373", "xyz");
        List<Integer> list1 = Arrays.asList(1,0);
       // list1.forEach(handleGenericException(s-> System.out.println(10/s),ArithmeticException.class));

       // list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)),NumberFormatException.class));

        // List<Integer> intList = list.stream().map(Integer::parseInt).collect(Collectors.toList());
        // System.out.println(intList);

        //handle exception for checkedException
        List<Integer> list2 = Arrays.asList(10,20);

        list2.forEach(handleCheckedExceptionConsumer(i->{
            Thread.sleep(i);
            System.out.println(i);
        }));
    }
    //approach -2

    public static void printList(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception ex) {
            System.out.println("exception : " + ex.getMessage());
        }
    }

    static Consumer<String> handleExceptionIfAny(Consumer<String> payload) {
        return obj -> {
            try {
                payload.accept(obj);
            } catch (Exception ex) {
                System.out.println("exception : " + ex.getMessage());
            }
        };
    }

    static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer,
                                                                                     Class<ExObj> exObjClass) {
        return obj -> {
            try {
                targetConsumer.accept(obj);
            } catch (Exception ex) {
                try {
                    ExObj exObj = exObjClass.cast(ex);
                    System.out.println("exception : " + exObj.getMessage());
                } catch (ClassCastException ecx) {
                    throw ex;
                }
            }
        };
    }

    static  <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target,Exception> handlerConsumer){
        return obj -> {
            try {
                handlerConsumer.accept(obj);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
```

```java

@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<Target,ExObj extends Exception> {

    public void accept(Target target) throws ExObj;
}
```
</details>
<details>
<summary><b>7.5 Java Stream Programs</b></summary>

### Program to convert Primitive Array to Stream in Java

An array is a group of like-typed variables that are referred to by a common name. An array can contain primitives data types as well as objects of a class depending on the definition of the array. In case of primitives data types, the actual values are stored in contiguous memory locations. In case of objects of a class, the actual objects are stored in heap segment.

A Primitive array is an array which is defined with the help of the primitive wrapper classes, instead of objects.
Example: Integer a = new Integer(4);

When a Primitive Array is converted into a Stream, primitive Streams will be obtained like IntStream, DoubleStream and LongStream.

- Examples:

Input: Double Array: [1.2, 2.4, 3.6, 4.8, 5.0]
Output: DoubleStream: [1.2, 2.4, 3.6, 4.8, 5.0]

Input: Integer Array: [1, 2, 3, 4, 5]
Output: IntStream: [1, 2, 3, 4, 5]

Below are methods to convert Primitive Array to Stream in Java:

### Using Arrays.stream():
Algorithm:

Get the Array to be converted.
Convert the array into Stream using Arrays.stream() method by passing the array as the parameter.
Return the formed Stream
Program:
```java
// Java Program to convert 
// Array to Stream 
  
import java.util.*; 
import java.util.stream.*; 
  
class GFG { 
  
    // Generic function to convert  
    // an Array to Stream 
    public static IntStream  
                convertArrayToStream(int array[]) 
    { 
  
        // Return the converted Stream 
        return Arrays.stream(array); 
    } 
  
    public static void main(String args[]) 
    { 
        // Create an Array 
        int[] array = new int[] { 3, 2, 5, 4, 1 }; 
  
        // Print the Array 
        System.out.println("Array: " 
                    + Arrays.toString(array)); 
  
        // convert the Array to Stream 
        IntStream stream = convertArrayToStream(array); 
  
        // Print the Stream 
        System.out.println("Stream: " 
                    + Arrays.toString(stream.toArray())); 
    } 
}
```
Output:
Array: [3, 2, 5, 4, 1]
Stream: [3, 2, 5, 4, 1]

### Using IntStream.of(): The IntStream.of() method creates a Stream directly with the primitive values or collection passed as the parameter.
Algorithm:

Get the Array to be converted.
Convert the array into Stream using IntStream.of() method by passing the array as the parameter.
Return the formed Stream
Program:
```java
// Java Program to convert 
// Array to Stream 
  
import java.util.*; 
import java.util.stream.*; 
  
class GFG { 
  
    // Generic function to convert  
    // an Array to Stream 
    public static IntStream  
               convertArrayToStream(int array[]) 
    { 
  
        // Return the converted Stream 
        return IntStream.of(array); 
    } 
  
    public static void main(String args[]) 
    { 
        // Create an Array 
        int[] array = new int[] { 3, 2, 5, 4, 1 }; 
  
        // Print the Array 
        System.out.println("Array: " 
                      + Arrays.toString(array)); 
  
        // convert the Array to Stream 
        IntStream stream = convertArrayToStream(array); 
  
        // Print the Stream 
        System.out.println("Stream: " 
                      + Arrays.toString(stream.toArray())); 
    } 
}
```
Output:
Array: [3, 2, 5, 4, 1]
Stream: [3, 2, 5, 4, 1]    
</details>
StreamSupport.stream() method, and get a Stream from the given Iterable object. It is easier to turn an Iterable into a Stream. Iterable has a default method spliterator(), which can be used to get a Spliterator instance, which can be in turn then converted to a Stream.

Note: The Iterable is not a instance of Collection, this method internally calls StreamSupport.stream() to get a sequential Stream from Spliterator else it simply calls Collection.stream() method.

Program:
```java
// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.*; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream(Iterable<T> iterable) 
    { 
  
        // Convert the iterator into a Stream 
        Stream<T> stream 
            = StreamSupport 
                  .stream(iterable.spliterator(), 
                          false); 
  
        // Iterate list first to last element 
        Iterator<T> it = stream.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the Iterable 
        Iterable<String> iterable 
            = Arrays.asList("a", "b", "c"); 
  
        // Get the Stream from the Iterable 
        getStream(iterable); 
    } 
} 
```
Output:
a b c

</details>
<details>
<summary><b>7.6 10 Ways of Java Stream creation</b></summary>
	
The Stream API, introduced in Java 8, it is used to process collections of objects. Stream is a sequence of objects, that supports many different methods which can be pipe lined to produce the desired result.

The features of Java stream are –

A stream is not a data structure alternatively it takes input from the Collections, Arrays or I/O channels.
A Streams does not change the original data structure, they only provide the result as the pipelined methods.
Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipe lined. Terminal operation mark the end of the stream and return the result.
### Different way to create Streams:

#### Using Collection
Approach:

Get the collection
Construct a Sequential Stream from the collection using Collection.stream() method
Print the Stream
Below is the implementation of the above approach:

Program:

// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream(List<T> list) 
    { 
  
        // Create stream object with the List 
        Stream<T> stream = list.stream(); 
  
        // Iterate list first to last element 
        Iterator<T> it = stream.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Create ArrayList of String 
        List<String> list = new ArrayList<>(); 
  
        // Add element in list 
        list.add("Geeks"); 
        list.add("for"); 
        list.add("Geeks"); 
  
        // Get the Stream from the List 
        getStream(list); 
    } 
} 
Output:
Geeks for Geeks
Create a stream from specified values
Stream.of(T…t) method can be used to create a stream with the specified t values, where t are the elements. This method returns a sequential Stream containing the t elements.

Below is the implementation of the above approach:

Program:

// Java program to create Stream from values 
  
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static void getStream() 
    { 
  
        // Create a stream from specified values 
        Stream<Integer> stream 
            = Stream.of(1, 2, 
                        3, 4, 
                        5, 6, 
                        7, 8, 
                        9); 
  
        // Displaying the sequential ordered stream 
        stream.forEach(p -> System.out.print(p + " ")); 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the Stream from the values 
        getStream(); 
    } 
} 
Output:
1 2 3 4 5 6 7 8 9
Create stream from an array:
The Stream.of() and Arrays.stream() are two commonly used methods for creating a sequential stream from a specified array. Both these methods returns a Stream when called with a non-primitive type T.
Integer array

#### Create stream using
Arrays.stream()
Program:

// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream(T[] arr) 
    { 
  
        // Create stream from an array 
        // using Arrays.stream() 
        Stream<T> streamOfArray 
            = Arrays.stream(arr); 
  
        // Iterate list first to last element 
        Iterator<T> it 
            = streamOfArray.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the array 
        String[] arr 
            = new String[] { "a", "b", "c" }; 
  
        // Get the Stream from the Array 
        getStream(arr); 
    } 
} 
Output:
a b c
#### Create stream using
Stream.of()

A non interfering action to be perform on elements as they are consumed from the stream and returns also a new stream.
Program:

// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream(T[] arr) 
    { 
  
        // Create stream from an array 
        // using Stream.of() 
        Stream<T> streamOfArray = Stream.of(arr); 
  
        // Iterate list first to last element 
        Iterator<T> it = streamOfArray.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the array 
        String[] arr 
            = new String[] { "a", "b", "c" }; 
  
        // Get the Stream from the Array 
        getStream(arr); 
    } 
} 
Output:
a b c
#### Create an empty stream using Stream.empty()
The empty() method is used upon creation to avoid returning null for streams with no element.

Program:

// Java program to create empty Stream 
  
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static void getStream() 
    { 
  
        // Create stream from an array using Stream.empty() 
        Stream<String> streamOfArray 
            = Stream.empty(); 
  
        // Iterate list first to last element 
        Iterator<String> it 
            = streamOfArray.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the empty Stream 
        getStream(); 
    } 
} 
Output:

#### Create a Stream using Stream.builder()
The builder() method is used when the desired type should be additionally specified in the right part of the statement, otherwise the build() method will create an instance of the Stream.

Program:

// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream() 
    { 
  
        // Create stream using Stream builder() 
        Stream.Builder<String> builder 
            = Stream.builder(); 
  
        // Adding elements in the stream of Strings 
        Stream<String> stream = builder.add("a") 
                                    .add("b") 
                                    .add("c") 
                                    .build(); 
  
        // Iterate list first to last element 
        Iterator<String> it = stream.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the Stream using Builder 
        getStream(); 
    } 
} 
Output:
a b c
#### Create an infinite Stream using Stream.iterate()
The iterate() method returns an infinite sequential ordered Stream produced by iterative application of a function f to an initial element seed. In below example, First element of the resulting stream is a first parameter of the iterate method. For creating every following element the function is applied to the previous element. In the example below the second element will be 4.

Program:

// Java program to create infinite Stream 
// using Stream.iterate() method 
  
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void
    getStream(int seedValue, int limitTerms) 
    { 
  
        // Create infinite stream 
        // using Stream.iterate() method 
        Stream.iterate(seedValue, 
                       (Integer n) -> n * n) 
            .limit(limitTerms) 
            .forEach(System.out::println); 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the seed value 
        int seedValue = 2; 
  
        // Get the limit for number of terms 
        int limitTerms = 5; 
  
        // Get the Stream from the function 
        getStream(seedValue, limitTerms); 
    } 
} 
Output:
2
4
16
256
65536
#### Create an infinite Stream using Stream.generate() method
The generate() method accepts a Supplier for generating elements and the resulting stream is infinite. So to restrict it, specify the desired size or the generate() method will work until it reaches the memory limit.

Program:

// Java program to create infinite Stream 
// using Stream.generate() method 
  
import java.util.*; 
import java.util.stream.*; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream(int limitTerms) 
    { 
  
        // Create infinite stream 
        // using Stream.generate() method 
        Stream.generate(Math::random) 
            .limit(limitTerms) 
            .forEach(System.out::println); 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the limit for number of terms 
        int limitTerms = 5; 
  
        // Get the Stream from the function 
        getStream(limitTerms); 
    } 
} 
Output:
0.2293502475696314
0.5650334795948209
0.3418138293253522
0.36831074763500116
0.4864408670097241
#### Create stream from a Pattern using Predicate
In java 8, the Predicate asPredicate() method of Pattern creates a predicate boolean-valued function that is used for pattern matching.

Program:

// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.*; 
import java.util.regex.Pattern; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static void
    getStream(List<String> list, Pattern p) 
    { 
  
        list.stream() 
            .filter(p.asPredicate()) 
            .forEach(System.out::println); 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Create ArrayList of String 
        // that is backed by the specified array 
        List<String> list 
            = Arrays 
                  .asList("Geeks", 
                          "For", 
                          "Geek", 
                          "GeeksForGeeks", 
                          "A Computer Portal"); 
  
        // Get the pattern 
        Pattern p = Pattern.compile("^G"); 
  
        // Get the Stream from the List matching Pattern 
        getStream(list, p); 
    } 
} 
Output:
Geeks
Geek
GeeksForGeeks
#### Create stream from Iterator
Iterators, in Java, are used in Collection Framework to retrieve elements one by one. Spliterator is the key to create the sequential stream. Hence in this method also, Spliterator is used. But in this method, the source of Spliterator is set to an Iterable created from the Iterator. So first the Iterable is created from the Iterator. Then the Spliterator is passed to the stream() method directly as Iterable.spliterator().

Program:

// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.*; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream(Iterator<T> itr) 
    { 
  
        // Convert the iterator into a Spliterator 
        Spliterator<T> spitr 
            = Spliterators 
                  .spliteratorUnknownSize(itr, 
                                          Spliterator.NONNULL); 
  
        // Convert spliterator into a sequential stream 
        Stream<T> stream 
            = StreamSupport.stream(spitr, false); 
  
        // Iterate list first to last element 
        Iterator<T> it = stream.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the Iterator 
        Iterator<String> iterator = Arrays 
                                        .asList("a", "b", "c") 
                                        .iterator(); 
  
        // Get the Stream from the Iterator 
        getStream(iterator); 
    } 
} 
Output:
a b c
#### Create stream from Iterable
Iterable interface is designed keeping in mind and does not provide any stream() method on its own. Simply it can be passed into StreamSupport.stream() method, and get a Stream from the given Iterable object. It is easier to turn an Iterable into a Stream. Iterable has a default method spliterator(), which can be used to get a Spliterator instance, which can be in turn then converted to a Stream.

Note: The Iterable is not a instance of Collection, this method internally calls StreamSupport.stream() to get a sequential Stream from Spliterator else it simply calls Collection.stream() method.

Program:

// Java program to create Stream from Collections 
  
import java.util.*; 
import java.util.stream.*; 
  
class GFG { 
  
    // Function convert a List into Stream 
    private static <T> void getStream(Iterable<T> iterable) 
    { 
  
        // Convert the iterator into a Stream 
        Stream<T> stream 
            = StreamSupport 
                  .stream(iterable.spliterator(), 
                          false); 
  
        // Iterate list first to last element 
        Iterator<T> it = stream.iterator(); 
  
        // Iterate stream object 
        while (it.hasNext()) { 
            System.out.print(it.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // Get the Iterable 
        Iterable<String> iterable 
            = Arrays.asList("a", "b", "c"); 
  
        // Get the Stream from the Iterable 
        getStream(iterable); 
    } 
} 
Output:
a b c

</details>
</details>   
