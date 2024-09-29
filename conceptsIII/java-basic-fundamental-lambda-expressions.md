# Java 8 Lambda Expressions

## 1) Definition

Java 8 Lambda Expressions can be defined as methods without names i.e anonymous functions. Like methods, they can have parameters, a body, a return type and possible list of exceptions that can be thrown. But unlike methods, neither they have names nor they are associated with any particular class.

**Lambda Expressions**: The Expression through which we can represnt an Anonymous Function.

* Anonymous: Nameless/Unknown
* Anonymous Function: A method who dont have any name or identifier

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
