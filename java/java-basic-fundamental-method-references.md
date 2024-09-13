# Java 8 Method References

Java 8 method references are the shortened versions of lambda expressions calling a specific method. For example, lambda expression (Student s) -> s.getName() which is calling a method getName() of Student class can be shortened as Student::getName using Java 8 method references. Let’s see them in detail.


## Java 8 Method References :

1) Definition
Java 8 method references can be defined as shortened versions of lambda expressions calling a specific method. Method references are the easiest way to refer a method than the lambdas calling a specific method. Method references will enhance the readability of your code.

2) Syntax
a) Method reference to static method :

ClassName::MethodName

Use this syntax when you are referring to a static method.

ex : Integer::parseInt, Math::max

b) Method reference to instance method of an existing object :

ReferenceVariable::MethodName

Use this syntax when you are referring to an instance method of already existing object.

ex : s::getName

where ‘s’ is a reference variable referring to Student object which already exist.

c) Method reference to instance method of non-existing object :

ClassName::MethodName

Use this syntax when you are referring to an instance method by passing reference variables as an argument.

ex : (Student s) -> s.getName() can be written as Student::getName

3) Constructor References
You can also refer to the constructor of a class same as method references. Syntax for referring to constructor is,

ClassName::new

Ex : Student::new

4) Examples

## Java 8 method references

### lambdas and method reference equivalents

| Lambda Expression					     	| Equivalent Method References										|
|-------------------------|----------------------------|
| (String s)-> Integer.parseInt(s)			| Integer::parseInt 												|
| (String s)-> s.toLowerCase(s)				| String::toLowerCase												|
| (int i)-> System.out.println(i)			| System.out::println			 									|
| (String s) -> System.out.println(s)		| System.out::println			 									|
| (str, i) -> str.substring(i)				| String::substring			 										|
| (Student s)-> s.getName() 				| Student::getName													|
| (Apple a) -> a.getWeight()				| Apple::getWeight													|
| ()-> s.getName()  						| s::getName Where 's'referes to Student object which already exist.|
| () -> Thread.currentThread().dumpStack() 	| Thread.currentThread()::dumpStack									|
| ()-> new Student()						| Student::new              										|

You can think of method references as syntactic sugar for lambdas that refer only to a single
method because you write less to express the same thing.
```java
List<String> str = Arrays.asList("a","b","A","B");

str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));//Lambda Expression
//OR
str.sort(String::compareToIgnoreCase);//Method Reference
```	
a) Method reference to static method
```java
import java.util.function.Function;
 
public class Java8MethodReferences
{
    public static void main(String[] args) 
    {
        //Calling parseInt() method using lambda
         
        Function<String, Integer> lambdaFunction = (String s) -> Integer.parseInt(s);
        System.out.println(lambdaFunction.apply("12"));
         
        //Calling parseInt() method using method reference
         
        Function<String, Integer> referenceFunction = Integer::parseInt;
        System.out.println(referenceFunction.apply("12"));
    }
}
```
b) Method reference to instance method (ClassName::MethodName)
```java
import java.util.function.Function;
 
public class Java8MethodReferences
{
    public static void main(String[] args) 
    {
        //Calling toLowerCase() method using lambda
         
        Function<String, String> lambdaFunction = (String s) -> s.toLowerCase();
        System.out.println(lambdaFunction.apply("JAVA"));
         
        //Calling toLowerCase() method using method reference
         
        Function<String, String> referenceFunction = String::toLowerCase;
        System.out.println(referenceFunction.apply("JAVA"));
    }
}
```
c) Method reference to instance method (ReferenceVariable::MethodName)
```java
import java.util.function.Supplier;
 
class Company
{
    String name;
     
    public Company(String name) 
    {
        this.name = name;
    }
     
    public String getName()
    {
        return name;
    }
}
 
public class Java8MethodReferences
{
    public static void main(String[] args) 
    {
        Company c = new Company("My_Company");
         
        //Calling getName() of c using lambda
         
        Supplier<String> lambdaSupplier = () -> c.getName();
        System.out.println(lambdaSupplier.get());
         
        //Calling getName() of c using method reference
         
        Supplier<String> referenceSupplier = c::getName;
        System.out.println(referenceSupplier.get());
    }
}
```
d) Constructor References
```java
import java.util.function.Supplier;
 
class Company
{
     
}
 
public class Java8MethodReferences
{
    public static void main(String[] args) 
    {
        //Creating objects using lambda
         
        Supplier<Company> lambdaSupplier = () -> new Company();
        lambdaSupplier.get();
         
        //Creating objects using constructor references
         
        Supplier<Company> referenceSupplier = Company::new;
        referenceSupplier.get();
    }
}
```
# Recipe for constructing method references

### There are three main kinds of method references:

1. A method reference to a static method (for example, the method parseInt of Integer, written Integer::parseInt)
2. A method reference to an instance method of an arbitrary type (for example, the method length of a String, written String::length)
3. A method reference to an instance method of an existing object (for example, suppose you have a local variable expensiveTransaction that holds an object of type Transaction, which supports an instance method getValue; you can write expensiveTransaction::getValue)

The second and third kinds of method references may be a bit overwhelming at first. The idea with the second kind of method references such as String::length is that you’re referring to a method to an object that will be supplied as one of the parameters of the lambda. 

For example, the lambda expression (String s) -> s.toUpperCase() can be rewritten as String::toUpperCase.

But the third kind of method references refers to a situation when you’re calling a method in a lambda to an external object that already exists.

For example, the lambda expression () -> expensiveTransaction.getValue() can be rewritten as expensiveTransaction::getValue.
