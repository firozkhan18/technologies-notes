# Java 8 Lambda Expressions

## 1) Definition

Java 8 Lambda Expressions can be defined as methods without names i.e anonymous functions. Like methods, they can have parameters, a body, a return type and possible list of exceptions that can be thrown. But unlike methods, neither they have names nor they are associated with any particular class.

**Lambda Expressions**: The Expression through which we can represnt an Anonymous Function.

* Anonymous: Nameless/Unknown
* Anonymous Function: A method who dont have any name or identifier

A **Lambda Expressions** is a short way to express a function in java. It allows us to write function inline and pass it as an argument to another function as well.

## 2) Lambda Syntax

Parameters &nbsp;&nbsp;&nbsp;&nbsp;   Expression  &nbsp;&nbsp;&nbsp;&nbsp;  Body

&nbsp;&nbsp;()&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println("Lambda Expression");

(Parameters) -> Expression

OR

(Parameters) -> { Statements }

Lambda syntax consist of three parts – list of parameters, an arrow mark and a body. The body of a lambda can be an expression or a set of statements. If it is set of statements, they must be enclosed within curly braces { }. Return type and possible list of exceptions that can be thrown are not explicitly mentioned in a lambda. They are implicitly applied.

## 3) Where To Use Lambda Expressions?

Lambda expressions are used where an instance of functional interface is expected (i.e. Lambda expressions only can be applicable for functional interface).

Functional interface is an interface which has only one abstract method. 

Functional interfaces can have any number of default and static methods. But, they must have only one abstract method. 

Comparator, Runnable, Comparable, Callable, and ActionListener are some examples of functional interfaces.

```java
@FunctionalInterface
public interface Comparator 
{
    int compare(T o1, T o2);       //Only one abstract method
}
 
@FunctionalInterface
public interface Runnable 
{
    public abstract void run();   //Only one abstract method
}
 
@FunctionalInterface
public interface ActionListener extends EventListener 
{
    public void actionPerformed(ActionEvent e);  //Only One abstract method
}
```
Before Java 8, anonymous inner classes are used to implement functional interfaces. After Java 8, you can use lambda expressions to implement functional interfaces.

## 4) How To Use Lambda Expressions?

Lambda expressions are used to implement functional interfaces. Before Java 8, anonymous inner classes are used to implement functional interfaces. Let’s explore this with some before Java 8 and after Java 8 code.

### Before Java 8 : Implementation of Comparator interface using anonymous inner class
```java
Comparator<Student> idComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getID()-s2.getID();
            }
        };
```
### After Java 8 : Implementation of Comaparator interface using lambda expressions
```java
Comparator<Student> idComparator = (Student s1, Student s2) -> s1.getID()-s2.getID();
```
### Before Java 8 : Implementation of Runnable interface using anonymous inner class
```java
Runnable r = new Runnable() {   
            @Override
            public void run() {
                System.out.println("Runnable Implementation Using Anonymous Inner Class");
            }
        };
```
### After Java 8 : Implementation of Runnable interface using lambda expressions
```java
Runnable r = () -> System.out.println("Runnable Implementation Using Lambda Expressions");
```
### Before Java 8 : Implementation Of ActionListener interface using anonymous inner class
```java
Label label = new Label();
         
Button button = new Button("Send");
         
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Sent");
    }
});
```
### After Java 8 : Implementation of ActionListener interface using lambda expressions
```java
Label label = new Label();
         
Button button = new Button("Send");
         
button.addActionListener((ActionEvent e) -> label.setText("Sent..."));
```
## 5) Lambdas As Inline Implementation Of Functional Interfaces

From the above examples, you can notice that lambdas instantiate functional interfaces and implement their abstract method in a single line. Before Java 8, anonymous inner classes are used for this purpose. But, they create lots of verbosity i.e you end up writing more lines of code than actually needed. Lambdas let you to write less code for same task.

## 6) Signature Of Lambda Expressions

The signature of lambda expressions can be derived from the signature of abstract method of functional interface.

For example,

run() method of Runnable interface accepts nothing and returns nothing. Then signature of lambda expression implementing Runnable interface will be () -> void.

actionPerformed() method of ActionListener interface takes one argument of type ActionEvent and returns void. Then signature of lambda expression for implementing ActionListener interface will be (ActionEvent) -> void.

compare() method of Comparator interface takes two arguments of type Object and returns int. Then signature of lambda expression for implementing Comparator interface will be (Object, Object) -> int.

## 7) Type Checking

The type of a variable or a parameter to which lambda expression is assigned or passed as an argument is called target type.

For example, if you are assigning a lambda to a Runnable type then its target type is Runnable. If you are passing a lambda to a method which takes ActionListener as an argument, then its target type is ActionListener.

Compiler uses this target type to check the type of parameters and return type of a lambda expression. For example,
```java
Runnable r = () -> System.out.println("Runnable Implementation Using Lambda Expressions");
```
In the above code, target type of lambda expression is Runnable. Compiler uses run() method of Runnable interface to check the type of parameters and return type of lambda expression.
```java
button.addActionListener((ActionEvent e) -> label.setText("Sent..."));
```
In the above code, target type of lambda expression is ActionListener. Compiler uses actionPerformed() method of ActionListener to check the type of parameters and return type of lambda expression.

## 8) Use Of Local Variables Inside Lambda Expression

You can use local variables inside a lambda expression just like anonymous inner classes provided they must be final or effectively final.

For example, the following code will show error because you are re-assigning new Label() to label.
```java
Label label = new Label();
         
Button button = new Button("Send");
         
button.addActionListener((ActionEvent e) -> label.setText("Sent..."));      //Compile Time Error
         
label = new Label();
```
## 9) Benefits Of Lambda Expressions

Lambda expressions let you to write more clear, concise and flexible code.
Lambda expressions removes verbosity and repetition of code.
## 10) Valid Lambda Expressions With Description

### Use case Examples of lambdas

| 			| Lambda Expressions								|
|------------------------------|------------------------------|
| A boolean expression				| (List<String> list) -> list.isEmpty()								|
| Creating objects					| () -> new Apple(10)												|
| Consuming from an object			| (Apple a) -> { System.out.println(a.getWeight()); }				|									|
| Select/extract from an object		| (String s) -> s.length()			 								|
| Combine two values				| (int a, int b) -> a * b											|
| Compare two objects  				| (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())	|

## Example:

```java

interface Calculator {
	// void switchOn();
	/* void sum(int input); */
	int substract(int i1, int i2);
}

class CalculatorImpl {

	public static void main(String[] args) {

		/*
		 * Calculator calculator = () -> System.out.println("Switch On");
		 * calculator.switchOn();
		 */

		/*
		 * Calculator calculator = (input) -> System.out.println("Sum : " + input);
		 * calculator.sum(394);
		 */

		Calculator calculator = (i1, i2) -> {
			if (i2 < i1) {
				throw new RuntimeException("message");
			} else {
				return i2 - i1;
			}
		};
		System.out.println(calculator.substract(8, 20));
	}
	// () -> {body};
}
```

## Real Time Example:

1) Create Pojo Class Book:
```java
public class Book {
	private int id;
	private String name;
	private int pages;

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
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pages=" + pages + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pages;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, int pages) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
	}
}
```
2) Create a DAO layer class BookDAO:

```java

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		books.add(new Book(101, "Core Java", 400));
		books.add(new Book(363, "Hibernate", 180));
		books.add(new Book(275, "Spring", 200));
		books.add(new Book(893, "WebService", 300));
		return books;
	}
}
```
3) Create a service class BookService for performing business logic:

- **Without Lambda Expressions**:

```java
import java.util.Collections;
import java.util.List;

public class BookService {

	public List<Book> getBooksinSort() {
		List<Book> books = new BookDAO().getBooks();
		Collections.sort(books, new MyComparator()));
		return books;
	}
	public static void main(String[] args) {
		System.out.println(new BookService().getBooksinSort());
	}
}

class MyComparator implements Comparator<Book> {

@Override
public int compare(Book o1, Book o2) {
    return o2.getName().compareTo(o1.getName());
}

```
- **Without Lambda Expressions and With Anonynous Function**:

```java
import java.util.Collections;
import java.util.List;

public class BookService {

	public List<Book> getBooksinSort() {
		List<Book> books = new BookDAO().getBooks();
		Collections.sort(books, new Comparator<Book>() {

		@Override
		public int compare(Book o1, Book o2) {
		    return o2.getName().compareTo(o1.getName());
		});
          return books;
	}
	public static void main(String[] args) {
		System.out.println(new BookService().getBooksinSort());
	}
}

/*
*class MyComparator implements Comparator<Book> {
*
*@Override
*public int compare(Book o1, Book o2) {
* return o2.getName().compareTo(o1.getName());
*}
*/

```
- **With Lambda Expressions**:

```java
import java.util.Collections;
import java.util.List;

public class BookService {

	public List<Book> getBooksinSort() {
		List<Book> books = new BookDAO().getBooks();
		Collections.sort(books, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return books;
	}

	public static void main(String[] args) {
		System.out.println(new BookService().getBooksinSort());
	}
}

```

In Java 8, **lambda expressions** were introduced as a way to provide a clear and concise syntax for writing anonymous methods (i.e., methods without a name). They are primarily used to implement functional interfaces (interfaces with a single abstract method), and they simplify the syntax for passing behavior as parameters.

### Key Characteristics of Lambda Expressions:
1. **Concise Syntax**: Lambda expressions allow you to write code more compactly, eliminating the need for boilerplate code (such as anonymous classes).
2. **Functional Interface**: A lambda expression works with functional interfaces, which are interfaces that contain exactly one abstract method. These interfaces are typically used to represent behavior that can be passed around as parameters to methods.
3. **First-Class Function**: Lambdas allow you to treat behavior as a parameter (e.g., passing functions as arguments to methods), making it easier to pass functionality around in Java.

### Basic Syntax of Lambda Expression:

The general syntax of a lambda expression is:

```java
(parameter1, parameter2, ...) -> expression
```

Alternatively, it can have a block of code as the body:

```java
(parameter1, parameter2, ...) -> {
    // body with multiple statements
}
```

### Example 1: Simple Lambda Expression

Suppose we have a functional interface:

```java
@FunctionalInterface
interface Greeting {
    void greet(String name);
}
```

Using a lambda expression to implement the interface:

```java
public class LambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement the greet method
        Greeting greeting = (name) -> System.out.println("Hello, " + name);
        greeting.greet("John");
    }
}
```

**Output**:

```
Hello, John
```

### Example 2: Lambda with Multiple Parameters

A lambda expression can take multiple parameters. Here's an example of adding two integers:

```java
@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using lambda expression to add two numbers
        MathOperation addition = (a, b) -> a + b;
        System.out.println("Addition: " + addition.operation(10, 5)); // Output: 15
    }
}
```

**Output**:

```
Addition: 15
```

### Example 3: Lambda Expression with Block of Code

When the lambda expression has more than one statement, it needs to be enclosed in braces `{}`.

```java
@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using lambda with a block of code
        MathOperation multiplication = (a, b) -> {
            int result = a * b;
            return result; // Return the result
        };
        System.out.println("Multiplication: " + multiplication.operation(10, 5)); // Output: 50
    }
}
```

**Output**:

```
Multiplication: 50
```

### Benefits of Lambda Expressions:
1. **Concise and Readable Code**: Lambda expressions allow you to write more concise and readable code, reducing the need for boilerplate code such as anonymous inner classes.
2. **Functional Programming**: Lambda expressions are a key part of functional programming in Java, enabling you to pass behavior as arguments and return values from methods more naturally.
3. **Parallel Processing**: Lambdas, combined with streams, make it easier to perform operations like filtering, mapping, and reducing data in parallel.

### Example 4: Lambda with `Streams` API

Java 8 introduced the `Streams` API, which allows you to perform functional-style operations on collections of objects.

```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using lambda with Streams API to filter and print names that start with 'A'
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(name -> System.out.println(name));
    }
}
```

**Output**:

```
Alice
```

### Example 5: Lambda with `Comparator`

Lambdas are frequently used with `Comparator` to sort collections:

```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 1, 4, 5);

        // Using lambda expression to sort the list
        numbers.sort((a, b) -> a.compareTo(b));

        System.out.println(numbers); // Output: [1, 2, 3, 4, 5]
    }
}
```

**Output**:

```
[1, 2, 3, 4, 5]
```

### Summary of Lambda Syntax:
- **Single parameter**: `(param) -> expression`
- **Multiple parameters**: `(param1, param2) -> expression`
- **Block of code**: `(param1, param2) -> { code }`
- **No parameter**: `() -> expression`

### Conclusion:
Lambda expressions in Java 8 are a powerful feature that simplifies the process of writing clean, efficient, and readable code. They enable functional programming capabilities by allowing you to pass behavior as parameters, work with `Streams`, and manipulate data in a concise way.


---

In Java 8, **lambda expressions** provide a way to write concise, functional-style code. A lambda expression essentially allows you to pass behavior as an argument to a method or store it in a variable. They are primarily used to define the implementation of the abstract method of a functional interface.

### Syntax of Lambda Expression:
The basic syntax of a lambda expression is:

```java
(parameters) -> expression
```

- **parameters**: The input parameters to the lambda function. If there is one parameter, you can omit the parentheses. If there are no parameters, use empty parentheses.
- **arrow (`->`)**: It separates the parameters and the body of the lambda expression.
- **expression**: The logic or behavior the lambda expression implements.

### Example of a Lambda Expression in Java:

1. **Simple Lambda Expression**
   ```java
   // Traditional way (Anonymous class)
   Runnable r1 = new Runnable() {
       @Override
       public void run() {
           System.out.println("Hello from Runnable!");
       }
   };

   // Using Lambda Expression
   Runnable r2 = () -> System.out.println("Hello from Runnable!");
   ```

   In this case, the lambda expression `() -> System.out.println("Hello from Runnable!")` represents a `Runnable` with no parameters and a single statement.

2. **Lambda Expression with Parameters**
   A more common example would be with functional interfaces that take parameters, like `Predicate`, `Function`, etc.

   ```java
   // Function interface example (accepts one parameter and returns a value)
   Function<Integer, Integer> square = (x) -> x * x;

   System.out.println(square.apply(4)); // Output: 16
   ```

3. **Lambda Expression with Multiple Parameters**
   You can pass multiple parameters to a lambda expression as well:

   ```java
   // Adding two integers
   BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

   System.out.println(add.apply(5, 3)); // Output: 8
   ```

4. **Using Lambda Expressions in Collections (Streams API)**
   Lambda expressions are particularly powerful when working with collections, especially with the new **Streams API** introduced in Java 8.

   ```java
   // Filtering even numbers from a list
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
   numbers.stream()
          .filter(n -> n % 2 == 0)
          .forEach(n -> System.out.println(n));
   ```

### Key Points to Remember:
- **Functional Interface**: Lambda expressions in Java work with functional interfaces (interfaces with a single abstract method). Examples include `Runnable`, `Comparator`, `Function`, `Predicate`, etc.
- **Type Inference**: The compiler can infer the type of parameters in lambda expressions. So, you don't always need to explicitly define the type (as long as the target type is clear).
  
   ```java
   // Type inference example
   Consumer<String> print = s -> System.out.println(s);
   ```

- **No `this` reference in lambda**: The `this` keyword in a lambda refers to the enclosing class, not the lambda expression itself. If you want to refer to the instance of the lambda expression, you can use the `LambdaClassName.this` syntax.

### Example of Functional Interfaces:

1. **Predicate (Functional Interface)**

   A `Predicate` takes one parameter and returns a boolean value.

   ```java
   Predicate<Integer> isEven = (n) -> n % 2 == 0;
   System.out.println(isEven.test(4)); // Output: true
   ```

2. **Consumer (Functional Interface)**

   A `Consumer` takes one parameter and does not return a value.

   ```java
   Consumer<String> printMessage = message -> System.out.println(message);
   printMessage.accept("Lambda Expression in Java 8");
   ```

3. **Supplier (Functional Interface)**

   A `Supplier` takes no parameters and returns a value.

   ```java
   Supplier<String> getMessage = () -> "Hello, Java 8!";
   System.out.println(getMessage.get());
   ```

### Conclusion:

Lambda expressions in Java 8 make code more concise and readable, particularly in functional-style programming. They are particularly useful when working with collections, handling concurrency, or dealing with APIs that expect functional interfaces.
