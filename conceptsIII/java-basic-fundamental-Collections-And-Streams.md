## Difference Between Collections And Streams In Java

Collections and Streams, both are conceptually two different things which are used for two different purposes. 
If the collections are used to store the data then the streams are used to perform operations on that data. 
In this article, we will discuss the difference between collections and streams in Java.

### Collections And Streams In Java :

### 1) Conceptual Difference

Collections are used to store and group the data in a particular data structure like List, Set or Map. But, streams are used to perform complex data processing operations like filtering, matching, mapping etc on stored data such as arrays, collections or I/O resources. That means, collections are mainly about data and streams are mainly about operations on data.


### //Usage of collections 
```java
//Collections are mainly used to store the data         
//Here, names are stored as List
         
List<String> names = new ArrayList<>();
         
names.add("Charlie");         
names.add("Douglas");         
names.add("Sundaraman");         
names.add("Charlie");         
names.add("Yuki");
```         
### //Usage of streams 
```java
//Streams are mainly used to perform operations on data         
//like selecting only unique names
         
names.stream().distinct().forEach(System.out::println);
```     
//Output :
         
//Charlie
//Douglas
//Sundaraman
//Yuki


### 2) Data Modification

You can add to or remove elements from collections. But, you can’t add to or remove elements from streams. 
Stream consumes a source, performs operations on it and returns a result. 
They don’t modify even the source also.
```java
List<String> names = Arrays.asList("Charlie", "Douglas", "Jacob");
         
//Adding elements to names         
names.add("Sundaraman");         
names.add("Yuki");         
//Removing elements from names         
names.remove(2);         

//getting stream of unique names         
Stream<String> uniqueNames = names.stream().distinct(); 
        
//You can't add or remove elements from stream         
//There are no such methods in Stream
```
### 3) External Iteration Vs Internal Iteration

The main specialty of Java 8 Streams is that you need not to worry about iteration while using streams. 
Streams perform iteration internally behind the scene for you. 
You just have to mention the operations to be performed on a source.

On the other hand, you have to do the iteration externally over collections using loops.
```java
List<String> names = new ArrayList<>();
                 
names.add("Charlie");                 
names.add("Douglas");                 
names.add("Sundaraman");                 
names.add("Charlie");                 
names.add("Yuki");
         
//External iteration of collections         
for (String name : names) 
{
    System.out.println(name);
}
```    
//Output :
         
//Charlie
//Douglas
//Sundaraman
//Charlie
//Yuki
         
//Internal iteration of streams. No for loops 
names.stream().map(String::toUpperCase).forEach(System.out::println);
                 
//Output :
                 
//CHARLIE
//DOUGLAS
//SUNDARAMAN
//CHARLIE
//YUKI

### 4) Traversal

Streams are traversable only once. If you traverse the stream once, it is said to be consumed. 
To traverse it again, you have to get new stream from the source again. But, collections can be traversed multiple times.
```java
List<Integer> numbers = Arrays.asList(4, 2, 8, 9, 5, 6, 7);
         
Stream<Integer> numbersGreaterThan5 = numbers.stream().filter(i -> i > 5);         
//Traversing numbersGreaterThan5 stream first time         
numbersGreaterThan5.forEach(System.out::println);         
//Second time traversal will throw error
         
//Error : stream has already been operated upon or closed         
numbersGreaterThan5.forEach(System.out::println);
```
### 5) Eager Construction Vs Lazy Construction

Collections are eagerly constructed i.e all the elements are computed at the beginning itself. 
But, streams are lazily constructed i.e intermediate operations are not evaluated until terminal operation is invoked.
```java
List<Integer> numbers = Arrays.asList(4, 2, 8, 9, 5, 6, 7);                 
numbers.stream().filter(i -> i >= 5).limit(3).forEach(System.out::println);
 
//Here, not all numbers are evaluated.
//numbers are evaluated until 3 numbers >= 5 are found.
   
//Output :
         
//8
//9
//5
```

### Difference Between Collections Vs Streams In Java :

| Collections 																	| Streams																					|
|-------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| Collections are mainly used to store and group the data.	 					| Streams are mainly used to perform operations on data.									|
| You can add or remove elements from collections.				 				| You can’t add or remove elements from streams. 											|
| Collections have to be iterated externally.									| Streams are internally iterated.													 	    |
| Collections can be traversed multiple times. 									| Streams are traversable only once.	 													|
| Collections are eagerly constructed.											| Streams are lazily constructed. 															|
| Ex : List, Set, Map…															| Ex : filtering, mapping, matching…													    |    
	
