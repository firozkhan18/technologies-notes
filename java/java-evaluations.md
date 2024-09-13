# Java Evaluations

## Moving from Java 6 to Java 8

### Java 8

Many of us are working on Java projects which have started some years ago. It is likely that those projects are implemented in Java 5 or 6 and are planned or already migrated to the latest version of Java. The most obvious reasons for moving from Java 6 to Java 8 are new language features and security improvements. Aside to this, Java 8 is a bigger milestone in the Java programming language history and brings Java development to a completely new level.

You can jump in and start coding in Java 8 using your previous Java programming experience. Code will compile, for sure. Java 8 is backward compatible with previous versions. But you will not be able to get advantage of the new features and new concepts without taking some time to explore and learn about them. There are many web sites describing new Java 8 features in detail, I would like here just to briefly list them. But, before that, I would recall important Java 7 features, which you may not had a chance to use, but could be quite handy.

### Migrating from Java 6 to Java 8
In the company I work for, we have couple of projects still running under Java version 6. Recently we have tried to migrate to the latest Java 8 version. In general, the migration passed quite smooth. Few Spring framework configuration files had to be updated (most probably because we should update Spring version, too). Few tweaks here and there and – we were able to run the projects.

So, the migration should not be an issue. But, what next? Will your project and your team have benefits of switching to the latest platform version? When we are talking in a general context – yes, for sure. You will have immediate benefits of the Java improvements in compiler, performance, security etc. But you will not be able to fully utilize the platform, if you are not aware of the features it’s offering. On the other side, for some cases, implementing stuff in the “old way” could still be the best approach. So, there is no need to rush. You should give yourself and your team a time to adopt and get familiar with the new language features. That way you will get experience how and when it makes sense to use those.

Below are a list of important features of Java 7 and Java 8 versions you should be aware of.

### Java 7 Features
Java 7It took 5 years from when Java SE 6 was released in December 2006 until Java SE 7 first release in July 2011. Java 7 main focus was at reducing language verbosity, making it easier for developers to write code.Through Project Coin a set of language enhancements were introduced. The most important features are:

<details>
<summary><b>Diamond “<>” Operator</b></summary>

In Java 5 Generics were introduced which help developers to write type safe collections. But Generics can sometimes be too verbose. For example, in Java 5 and 6 you define a Map of String keys and Set of Strings as values like this:
```java
Map<String, Set<String>> rowsMap = new HashMap<String, Set<String>>();
Java 7 improved on type inference for generic instance creation and diamond operator is introduced. Code above you can write as:

Map<String, Set<String>> rowsMap = new HashMap<strong><></strong>();
```
</details>
<details>
<summary><b>Strings in switch Statement</b></summary>

 if your code has to execute different statements based on the input string, you usually end up with a bunch of if-else_if-else statements to test for each value. Example:
```java
if (country.equals("UK") || country.equals("US")) {
    System.out.printlin("Hi!");
} else if (country.equals("DE")) {
    System.out.printlin("Hallo!");
} else if (country.equals("FR")) {
    System.out.printlin("Bonjour!");
} else {
    System.out.printlin("Hello!");
}
Java 7 added support to use also Strings with switch command:

switch (country) {
    case "UK":
    case "US":
        System.out.printlin("Hi!");
        break;
    case "DE":
        System.out.printlin("Hallo!");
        break;
    case "FR":
        System.out.printlin("Bonjour!");
        break;
    default:
        System.out.printlin("Hello!");
}
```
</details>
<details>
<summary><b>Multi-catch similar exceptions</b></summary>

 There are cases when you have to catch multiple exceptions but you execute the same action for each of them:
```java
try {
   // code which throws FileNotFoundException
} catch (FileNotFoundException fnfo) {
    fnfo.printStackTrace();
} catch (IOException ioe) {
    ioe.printStackTrace();
}
Java 7 gives you the possibility to have a single catch handler for multiple exceptions:

try {
   // code which throws FileNotFoundException
} catch (IOException | FileNotFoundException fnfo) {
    fnfo.printStackTrace();
}
```
</details>
<details>
<summary><b>Automatic Resource Closing</b></summary>

 Before Java 7, we had to use finally block and explicitly close a resource, regardless if this resource was used or an exception were raised into the code. By automatism we all know that for each resource, e.g. FileInputStream we should write code into finally block to explicitly close the resource:
```java
File file = new File("somefile.txt");
FileInputStream fis = null;

try {
   fis = new FileInputStream(file);

   System.out.println("Total file size (in bytes) : "
      + fis.available());

   int content;
   while ((content = fis.read()) != -1) {
      System.out.print((char) content);
   }

} catch (IOException e) {
	e.printStackTrace();
} finally {
   try {
      if (fis != null)
         fis.close();
   } catch (IOException ex) {
      ex.printStackTrace();
   }
}
```
In Java 7 there is try-with-resource feature. If a resource implements java.lang.AutoCloseable, which includes all objects implementing java.io.Closeable, will be auto closed if they are created within try statement:
```java
File file = new File("somefile.txt");

try (FileInputStream fis = new FileInputStream(file)) {
   System.out.println("Total file size (in bytes) : "
      + fis.available());

   int content;
   while ((content = fis.read()) != -1) {
      System.out.print((char) content);
   }

} catch (IOException e) {
	e.printStackTrace();
}
```
</details>
<details>
<summary><b>Underscore in Numerical Literals</b></summary>

In order to improve readability of large numeric literals (integer and floating-point), since java 7 you can insert underscores “_” between digits. In general, you can put underscore at any place, except at the beginning, at the end and right after the decimal point. Here are some examples how it can be used:
```java
int million = 1_000_000;
long creaditCardNumber = 1234_5678_9012_3456L;
float num = 1.2345_6789f;
```
</details>
<details>
<summary><b>Binary Literals with Prefix “0b”</b></summary>

 In Java 7 you can specify the value of integral types (byte, short, int and long) in a binary form, with prefix “0b" (or "0B"). Example:

int maskBytes = 0b11001100;

// using underscore for improved readability
int veryLongMask = 0b1101_1000_1101_0001;
Note: Before Java 7, you were able to specify octal values with prefix “O” and hexadecimal values with prefix “Ox” or “OX“.

</details>
<details>
<summary><b>Other features</b></summary>

 Apart from reducing language verbosity, Java 7 brings few other important features:

- Garbage First (G1) – new garbage collector algorithm. It performs clean-up where there is most garbage. To achieve this it split Java heap memory into multiple regions, as opposed to 3 regions in the prior to Java 7 version (new, old and permgen).
- Java NIO 2.0 – New package java.nio.file is introduced in Java 7 and provides comprehensive support for file I/O and for accessing the default file system. E.g. instead of java.io.File you can use java.nio.file.Path class:
- Path path = Paths.get("c:\\data\\myfile.txt");
- More precise Exception rethrow – Java 7 compiler performs more precise analysis of rethrown exceptions than earlier releases of java. This enables you to specify more specific exception types in the throws clause of a method declaration. See an example here.
- Fork Join Framework -The fork/join framework is an implementation of the ExecutorService interface that allows you to take advantage of multiple processors available in modern servers. It is designed for work that can be broken into smaller pieces recursively. The goal is to use all the available processing power to enhance the performance of your application. The fork join framework is distinct because it uses a work-stealing algorithm, which is very different than producer consumer algorithm. See here for more information.
Note that fork/join framework will be (is) used in Java 8 as an infrastructure for parallel streams and is therefor very important to understand properly.
</details>
<details>
<summary><b>Garbage First (G1) garbage collector</b></summary>
</details>
<details>
<summary><b>Java NIO 2.0</b></summary>
</details>
<details>
<summary><b>More precise Exception rethrow</b></summary>

Previously, rethrowing an exception was treated as throwing the type of the catch parameter. For example, let's say that your try block could throw a ParseException or an IOException. To intercept all exceptions and rethrow them, you would have to catch Exception and declare your method as throwing an Exception. This is "imprecise rethrow", because you are throwing a general Exception type (instead of specific ones) and statements calling your method need to catch this general Exception.
This is illustrated below:

```java
//imprecise rethrow.
//must use "throws Exception"
public static void imprecise() throws Exception{
    try {
        new SimpleDateFormat("yyyyMMdd").parse("foo");
        new FileReader("file.txt").read();
    } catch (Exception e) {
        System.out.println("Caught exception: " + e.getMessage());
        throw e;
    }
}
```
However, in Java 7, you can be more precise about the exception types being rethrown from a method. If you rethrow an exception from a catch block, you are actually throwing an exception type which:
the try block can throw,
no previous catch clause handles, and
is a subtype of one of the types in the declaration of the catch parameter
This leads to improved checking for rethrown exceptions. You can be more precise about the exceptions being thrown from the method and you can handle them a lot better at the calling site.
```java
//java 7: precise rethrow.
//no longer "throws Exception"
public static void precise() throws ParseException, IOException{
    try {
        new SimpleDateFormat("yyyyMMdd").parse("foo");
        new FileReader("file.txt").read();
    } catch (Exception e) {
        System.out.println("Caught exception: " + e.getMessage());
        throw e;
    }
}
 
//this example handles ParseException
public static void precise2() throws IOException{
    try {
        new SimpleDateFormat("yyyyMMdd").parse("foo");
        new FileReader("file.txt").read();
    } catch(ParseException e){
        System.out.println("Parse Exception");
    }catch (Exception e) {
        System.out.println("Caught exception: " + e.getMessage());
        throw e;
    }
}
```
(Note: Early documentation of this feature, states that you have to use a final modifier on the catch parameter, but this restriction was lifted later on, so is not necessary.)
</details>
<details>
<summary><b>Fork Join Framework</b></summary>
</details>

### Java 8 New Features
java 6 to java 8Java SE 8 was officially released in March 2014. The idea of the new language upgrade is to further improve and make writing code more efficiently and less verbose. Since multi-core processors are present everywhere today, one another important aspect of Java 8 is to simplify writing parallel (multi-threading) code easier and less error prone. It also brings functional programming possibilities to the core language.

Moving from Java 7 or Java 6 to Java 8 could be not that straightforward. If you would like to utilize the new features and programming concepts (paradigms) offered by the language, you will most probably need to do some reading, take an online course or so. There is a great book Java 8 in Action, published by Manning, which explains all the new Java 8 features with a lot of examples and explanations. But, in order to understand more functional programming concepts I would recommend Functional Programming Principles in Scala (coursera.org free online course) by Martin Odersky. You will learn Scala, too, but the focus is why and how to do functional programming. Note that Java 8 does not support all the functional programming features offered by Scala (or other purely functional programming languages, like Haskell). It is still far from ideal, but most of the things are there which a standard Java project would require. At least I have that impression.

Here are Java SE 8 important new features (all the features are listed here):

<details>
<summary><b>Lambda Expressions</b></summary>

 A lambda expressions is the biggest language change in Java 8. Lambdas can be understood as a concise representation of an anonymous function that can be passed around: it doesn’t have a name, but it has a list of parameters, a body, a return type, and also possibly a lit of exceptions that can be thrown.
```java
(argtype arg...) -> { return some expression.. probably using these arguments }
Examples:

// simple Lambda function to add two ints
(int x, int y) -> x + y

// lambda expression used as a comparator
Comparator<Apple> byWeight = 
    (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

// Defining Runnable by Lambda expression
Runnable java8Runner = () -> {
    System.out.println("I am running");
};
```
See more examples in my other post related to Internal Iterations in Java 8. For more information check the official documentation.
</details>
<details>
<summary><b>Functional Interfaces</b></summary>

Language designers put a lot of thought on how to make already existing functionality lambda-friendly. As a result, the concept of functional interfaces has emerged. The function interface is an interface with just one single method. As such, it may be implicitly converted to a lambda expression. The java.lang.Runnable and java.util.Comparator are two great examples of functional interfaces. You’ll notice that in Java 8 those classes are annotated with @FunctionInterface. Note that the compiler will treat any interface meeting the definition of a functional interface as a functional interface regardless of whether or not a FunctionalInterface annotation is present on the interface declaration.

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
Note that default and static methods do not break the functional interface contract and may be declared. See below more info about Interface default and static methods.
</details>
<details>
<summary><b>Method References</b></summary>

 Method references provide the useful syntax to refer directly to exiting methods or constructors of Java classes or objects (instances). With conjunction of Lambdas expressions, method references make the language constructs look compact and concise, leaving off boilerplate.

There are four kinds of method references:

Kind	Example
Reference to a static method	ContainingClass::staticMethodName
Reference to an instance method of a particular object	containingObject::instanceMethodName
Reference to an instance method of an arbitrary object of a particular type	ContainingType::methodName
Reference to a constructor	ClassName::new
```java
class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
        
    public int compareByAge(Person a, Person b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
}
ComparisonProvider myComparisonProvider = new ComparisonProvider();
Arrays.sort(personsArray, myComparisonProvider::compareByName);
```
</details>
<details>
<summary><b>Interface Default and Static Methods</b></summary>

 In order to help library designers to evolve their APIs in a backward-compatible way, Java 8 introduces the possibility for an interface to have default methods. Default methods start with a default keyword and contain a body like class methods do.
```java
private interface Defaulable {
    // Interfaces now allow default methods, the implementer may or 
    // may not implement (override) them.
    default String notRequired() { 
        return "Default implementation"; 
    }        
}
        
private static class DefaultableImpl implements Defaulable {
}
    
private static class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
```
Additionally, interfaces can have implementation code in static methods, too.

</details>
<details>
<summary><b>Streams API</b></summary>

A stream is a iterator that allows a single run over the collection it is called on. Along with Lambdas, this is another noteworthy feature to watch out for. You can use streams to perform functional operations like filer or map/reduce over collections which can be streamed as individual elements using Stream objects. Streams can run sequentially or parallely as desired. The parallel mode makes use of fork/join framework and can leverage power of multiple cores. Check java.util.stream.Stream API for more details.
```java
Collection<Widget> widgets = ...

int sum = widgets.stream()
    .filter(w -> w.getColor() == RED)
    .mapToInt(w -> w.getWeight())
    .sum();
```
</details>
<details>
<summary><b>Optional</b></summary>

The famous NullPointerException is by far the most popular cause of Java application failures. Long time ago the great Google Guava project introduced the Optionals as a solution to NullPointerExceptions, discouraging codebase pollution with null checks and encouraging developers to write cleaner code. Inspired by Google Guava, the Optional is now a part of Java 8 library.
Optional is just a container: it can hold a value of some type T or just be null. It provides a lot of useful methods so the explicit null checks have no excuse anymore. Please refer to official Java 8 documentation for more details.
</details>
<details>
<summary><b>New Date/Time API</b></summary>

 The Date/Time API is a new and improved date and time API for Java. It is moved to java.time package and Joda time format is followed. Another good thing is that in most classes are Threadsafe and immutable. There are many static methods you can use directly. For every date-time manipulation there is probably already implemented method to use. The new java.time package contains all the classes for date, time, date/time, time zones, instants, duration, and clocks manipulation. Example classes:

Clock provides access to the current instant, date and time using a time-zone.
LocaleDate holds only the date part without a time-zone in the ISO-8601 calendar system.
LocaleTime holds only the time part without time-zone in the ISO-8601 calendar system.
The LocalDateTime combines together LocaleDate and LocalTime and holds a date with time but without a time-zone in the ISO-8601 calendar system.
ZonedDateTime holds a date with time and with a time-zone in the ISO-8601 calendar system.
Duration class represents an amount of time in terms of seconds and nanoseconds. It makes very easy to compute the different between two dates.
Examples:
```java
// Get the local date
final LocalDate date = LocalDate.now();

// Get the local time
final LocalTime time = LocalTime.now();

// Get the local date/time
final LocalDateTime datetime = LocalDateTime.now();


// Get duration between two dates
final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

final Duration duration = Duration.between( from, to );
```
</details>
<details>
<summary><b>CompletableFuture</b></summary>

The Future interface was introduced in Java 5 to model a result made available at some point in time (asynchronous computation). CompletableFuture is to Future what Stream is to Collection. CompletableFutures use lambda expressions to provide a declarative API that offers the possibility of easily defining a recipe that combines and composes different synchronous and asynchronous tasks to perform a complex operation in the most effective way. For more information see this post.
</details>
<details>
<summary><b>Repeating Annotations and Extended Annotations Support</b></summary>

Java Annotations are nowadays very popular and widely used by different Java frameworks. However, there were one limitation that a single annotation can be used only once at one place. Java 8 adds support to mark annotation as repeatable. The repeating annotations should be themselves annotated with @Repeatable annotation. Here is an example from JavaCodeGeeks:
```java
package com.javacodegeeks.java8.repeatable.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }
    
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };
    
    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {        
    }
    
    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }
}
```
In addition to this, Java 8 extends the context where annotation might be used. Now, it is possible to annotate mostly everything: local variables, generic types, super-classes and implementing interfaces, even the method’s exceptions declaration. How this can be useful, read this article.
</details>
<details>
<summary><b>Better Type Inference</b></summary>

Java 8 compiler is further improved in “auto discovering” (inference) the types of variables used into the code, comparing to Java 7. It is a step ahead for cleaner and more-readable code. More info here.
</details>
<details>
<summary><b>Reflection API Supports Method Parameter Names</b></summary>

In Java 8 there is a support for reading method parameter names in runtime. There is a new method in Reflection API Parameter.getName(). In order that method parameters names are available into your classes, you will have to compile your code with javac option -parameters.
</details>
<details>
<summary><b>Base64</b></summary>

 Since Java 8, Base64 encoding support is a standard Java library. java.util.Base64 class has methods for encoding and decoding, including basic encoding, url encoding and mime encoding. Example:
```java
String encoded = Base64.getEncoder()
    .encodeToString("text to encode".getBytes(StandardCharsets.UTF_8));
```
</details>
<details>
<summary><b>Parallel Arrays</b></summary>
	
Java 8 release adds a lot of new methods to allow parallel arrays processing. The purpose is to speed up bulk processing of an Array on a multi-core hardware. The methods are: Arrays.parallelPrefix, Arrays.parallelSetAll and Arrays.parallelSort. All three methods have additional different variants, related to array type, with supplied Comparator for sorting etc.
</details>
<details>
<summary><b>java.util.concurrent Improvements</b></summary>

New methods have been added to the java.util.concurrent.ConcurrentHashMap class to support aggregate operations based on the newly added streams facility and lambda expressions. One interesting new method is ConcurrentHashMap.computeIfAbsent(key, mappingFunction) method. If the specified key is not already associated with a value, attempts to compute its value using the given mapping function and enters it into this map unless null.

Also, new methods have been added to the java.util.concurrent.ForkJoinPool class to support a common pool.

The new java.util.concurrent.locks.StampedLock class has been added to provide a capability-based lock with three modes for controlling read/write access.

New classes have been added to the java.util.concurrent.atomic package: DoubleAccumulator, DoubleAdder, DoubleAccumulator, LongAdder.
</details>
<details>
<summary><b>Nashorn JavaScript engine</b></summary>

Nashorn is a JavaScript engine which allows you to run JavaScript code on a JVM.
```java
ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName("JavaScript");

System.out.println(engine.eval("function f() { return 1; }; f() + 1;"));
// returns: 2
```
</details>
<details>
<summary><b>Class dependency analyzer: jdeps</b></summary>

Since Java 8 Update 11, there is a new Java command line tool Java Dependency Analysis Tool (jdeps), which can help you understand dependencies in your code base. Here is an example (see more at GitHub Gist):
```
jdeps -v Deps.class 
Deps.class -> /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre/lib/rt.jar
   Deps (Deps.class)
      -> java.io.PrintStream                                
      -> java.lang.Math                                     
      -> java.lang.Object                                   
      -> java.lang.String                                   
      -> java.lang.System                                   
      -> java.util.HashSet
```
</details>
<details>
<summary><b>JVM changes: Metaspace instead of PermGen</b></summary>

The JDK 8 HotSpot JVM is now using native memory for the representation of class metadata and is called Metaspace; similar to the Oracle JRockit and IBM JVM’s. This means there will no longer see good old friend java.lang.OutOfMemoryError: PermGen. If you do not specify Max amount of memory to be used for class metadata it will be dynamically extended by the JVM, if needed. Though, it seems that we would still need to take care about class metadata allocated memory. Read more at Java 8: From PermGen to Metaspace.
</details>
