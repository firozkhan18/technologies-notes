# Interview Questions for Java Developer

+ [OOP](#OOP) ![icon][done]
+ [Java Core](#java-core) ![icon][done]
+ [Java Collections Framework](#java-collections) ![icon][done]
+ [Java 8](#java-8) ![icon][done]
+ [I/O Streams in Java](#I-O-Streams-in-Java) ![icon][done]
+ [Serialization](#serialization) ![icon][done]
+ [Multithreading](#multithreading) ![icon][done]
+ [Servlets, JSP, JSTL](#servlets-jsp-jstl) ![icon][done]
+ [Databases](#databases) ![icon][done]
+ [SQL](#sql) ![icon][done]
+ [JDBC](#jdbc) ![icon][done]
+ [Testing](#testing) ![icon][done]
+ [Logging](#logging) ![icon][done]
+ [UML](#uml) ![icon][done]
+ [XML](#xml) ![icon][done]
+ [Design Patterns](#design-patterns) ![icon][done]
+ [Basics of HTML](#basics-of-html) ![icon][done]
+ [Basics of CSS](#basics-of-css) ![icon][done]
+ [Basics of Web](#basics-of-web) ![icon][done]
+ [Additional Materials](#additional-materials) ![icon][done]

[done]:done.png

## OOP
+ [What is _OOP_?](oop.md#What-is-OOP)
+ [Name the main principles of _OOP_.](oop.md#Name-the-main-principles-of-OOP)
+ [What is _“encapsulation”?](oop.md#What-is-encapsulation)
+ [What is _“inheritance”?](oop.md#What-is-inheritance)
+ [What is _“polymorphism”?](oop.md#What-is-polymorphism)
+ [What is _“abstraction”?](oop.md#What-is-abstraction)
+ [What does _“message passing”_ represent?](oop.md#What-does-message-passing-represent)
+ [Discuss the main concepts of OOP: _“class”_, _“object”_, _“interface”_.](oop.md#Discuss-the-main-concepts-of-OOP-class-object-interface)
+ [What are the advantages and disadvantages of the object-oriented approach in programming?](oop.md#What-are-the-advantages-and-disadvantages-of-the-object-oriented-approach-in-programming)
+ [What do the terms _“is a”_ and _“has a”_ imply in the context of OOP principles?](oop.md#What-do-the-terms-is-a-and-has-a-imply-in-the-context-of-OOP-principles)
+ [What is the difference between _composition_ and _aggregation_?](oop.md#What-is-the-difference-between-composition-and-aggregation)
+ [What is _static_ and _dynamic binding_?](oop.md#What-is-static-and-dynamic-binding)

[Back to Table of Contents](#Interview-Questions-for-Java-Developer)

**Java Core**

- What is the difference between JRE, JVM, and JDK?
- What are the different access modifiers?
- What does the final keyword mean?
- What are the default variable initialization values?
- What do you know about the main() function?
- What logical operations and operators do you know?
- What is a ternary selection operator?
- What bitwise operations do you know?
- Where and why is the abstract modifier used?
- Define the concept of "interface." What default modifiers do interface fields and methods have?
- How is an abstract class different from an interface? When should you use an abstract class and when should you use an interface?
- Why don't some interfaces define methods at all?
- Why can't I declare an interface method with a final modifier?
- Which has a higher level of abstraction – a class, an abstract class, or an interface?
- Can an object access a class private variable? If so, how?
- What is the order in which constructors and initialization blocks are invoked based on the class hierarchy?
- Why are initialization blocks needed and what are the types?
- To which Java constructs does the static modifier apply?
- Why does Java use static initialization blocks?
- What happens if an exception occurs in the initialization block?
- What exception is thrown when an error occurs in the class initialization block?
- Can a static method be overridden or overloaded?
- Can non-static methods overwhelm static methods?
- Is it possible to narrow the access level/return type when overriding a method?
- Is it possible to change the following when overriding a method: access modifier; return type; the type of argument or their number; argument names or their order; remove, add, or change the order of the elements in the throws section?
- How do I access the overridden methods of the parent class?
- Is it possible to declare a method abstract and static at the same time?
- What is the difference between an instance member of a class and a static member of a class?
- Where is the initialization of static/non-static fields allowed?
- What types of classes are there in Java?
- Tell us about nested classes. In what cases are they used?
- What is a "static class"?
- What are the features of using nested classes: static and internal? What is the difference between them?
- What is a "local class"? What are its features?
- What are "anonymous classes"? Where are they used?
- How do I access an external class field from a nested class?
- What is the assert operator used for?
- What is a garbage collector for?
- How does the garbage collector work?
- What types of garbage collectors are implemented in the HotSpot virtual machine?
- Describe the algorithm of some garbage collector implemented in the HotSpot virtual machine.
- What is finalize()? Why is it needed?
- What happens to the garbage collector if the finalize() method takes a significant amount of time to run, or if an exception is thrown during execution?
- What is the difference between final, finally, and finalize()?
- What is Heap and Stack memory in Java? What is the difference between them?
- Is it true that primitive data types are always stored on the stack and instances of reference data types are on the heap?
- How are variables passed to methods, by value or by reference?
- Tell us about type conversion. What is Downgrade and Type Upgrade?
- When can a ClassCastException be thrown in an application?
- What is autoboxing in Java and what are the rules for wrapping primitive types into wrapper classes?
- What are the features of the String class?
- What is a "string pool"?
- Why is String an immutable and finalized class?
- Why is char[] preferable to String for storing a password?
- Why is a string a popular key in a HashMap in Java?
- What does the intern() method do in the String class?
- Can strings be used in a switch construct?
- What is the main difference between String, StringBuffer, StringBuilder?
- What is the Object class? What methods does it have?
- Tell us about cloning objects.
- What is the difference between shallow and deep cloning?
- Which cloning method is preferable?
- Why is the clone() method declared in the Object class and not in the Cloneable interface?
- Define the concept of "constructor."
- What is the "default constructor"?
- What is the difference between the default constructors, the copy constructor, and the parameterized constructor?
- Where and how can you use a private builder?
- Tell us about loader classes and dynamic class loading.
- What is Reflection?
- Why do we need equals()? How is it different from ==?
- equals() gives rise to an equivalence relation. What are the properties of such a relation?
- If you want to override equals(), what conditions should be met for the overridden method?
- Rules for overriding the Object.equals() method.
- What is the relationship between hashCode() and equals()?
- If equals() is overridden, are there any other methods that should be overridden?
- What happens if I override equals() without overriding hashCode()? What problems can arise?
- How are the hashCode() and equals() methods implemented in the Object class?
- What is the hashCode() method for?
- Rules for overriding the Object.hashCode() method.
- Are there any guidelines on which fields should be used when calculating hashCode()?
- Can different objects have the same hashCode()?
- If the Point{int x, y;} class implements the equals(Object that) {(return this.x == that.x && this.y == that.y)} method, but makes the hash code in the form of int hashCode() {return x;}, will such points be placed and retrieved from the HashSet correctly?
- Can different objects (ref0 != ref1) have ref0.equals(ref1) == true?
- Can different references to the same object (ref0 == ref1) have ref0.equals(ref1) == false?
- Is it possible to implement the equals(Object that) method as {return this.hashCode() == that.hashCode()}?
- In equals(), you need to check that the equals(Object that) argument is of the same type as the object itself. What's the difference between this.getClass() == that.getClass() and that instanceof MyClass?
- Is it possible to implement the equals() method of the MyClass class like this: class MyClass {public boolean equals(MyClass that) {return this == that;}}?
- There is a class called Point{int x, y;}. Why is a hash code of 31 * x + y preferable to x + y?
- Describe the hierarchy of exceptions.
- What types of exceptions do you know in Java, how do they differ?
- What is a checked and unchecked exception?
- Which operator allows you to force an exception to be thrown?
- What does the throws keyword mean?
- How do you write your own ("user-defined") exception?
- What are the unchecked exceptions?
- What is Error?
- What do you know about OutOfMemoryError?
- Describe how the try-catch-finally block works.
- What is the try-with-resources mechanism?
- Is it possible to use a try-finally block (without catch)?
- Can a single catch block catch multiple exceptions at once?
- Is the finally block always executed?
- Are there situations where a finally block will fail?
- Can the main method throw an exception outside and, if so, where will the exception be handled?
- Suppose there is a method that can throw IOException and FileNotFoundException, in what sequence should the catch blocks go? How many catch blocks will be executed?
- What are generics?
- What is "internationalization" and "localization"?

--- 



