[Interview Questions](README.md)

# Java Core

- [What is the difference between JRE, JVM, and JDK?](#what-is-the-difference-between-jre-jvm-and-jdk)
- [What are the different access modifiers?](#what-are-the-different-access-modifiers)
- [What does the final keyword mean?](#what-does-the-final-keyword-mean)
- [What are the default variable initialization values?](#what-are-the-default-variable-initialization-values)
- [What do you know about the main() function?](#what-do-you-know-about-the-main-function)
- [What logical operations and operators do you know?](#what-logical-operations-and-operators-do-you-know)
- [What is a ternary selection operator?](#what-is-a-ternary-selection-operator)
- [What bitwise operations do you know?](#what-bitwise-operations-do-you-know)
- [Where and why is the abstract modifier used?](#where-and-why-is-the-abstract-modifier-used)
- [Define the concept of "interface". What default modifiers do interface fields and methods have?](#define-the-concept-of-interface-what-default-modifiers-do-interface-fields-and-methods-have)
- [How is an abstract class different from an interface? When should you use an abstract class and when should you use an interface?](#how-is-an-abstract-class-different-from-an-interface-when-should-you-use-an-abstract-class-and-when-should-you-use-an-interface)
- [Why don't some interfaces define methods at all?](#why-dont-some-interfaces-define-methods-at-all)
- [Why can't I declare an interface method with a final modifier?](#why-cant-i-declare-an-interface-method-with-a-final-modifier)
- [Which has a higher level of abstraction – a class, an abstract class, or an interface?](#which-has-a-higher-level-of-abstraction--a-class-an-abstract-class-or-an-interface)
- [Can an object access a class member declared as private? If so, how?](#can-an-object-access-a-class-member-declared-as-private-if-so-how)
- [What is the order in which constructors and initialization blocks are invoked based on the class hierarchy?](#what-is-the-order-in-which-constructors-and-initialization-blocks-are-invoked-based-on-the-class-hierarchy)
- [Why are initialization blocks needed and what are the types?](#why-are-initialization-blocks-needed-and-what-are-the-types)
- [To which Java constructs does the static modifier apply?](#to-which-java-constructs-does-the-static-modifier-apply)
- [Why do Java use static initialization blocks?](#why-do-java-use-static-initialization-blocks)
- [What happens if an exception occurs in the initialization block?](#what-happens-if-an-exception-occurs-in-the-initialization-block)
- [What exception is thrown when an error occurs in the class initialization block?](#what-exception-is-thrown-when-an-error-occurs-in-the-class-initialization-block)
- [Can a static method be overridden or overloaded?](#can-a-static-method-be-overridden-or-overloaded)
- [Can non-static methods overwhelm static methods?](#can-non-static-methods-overwhelm-static-methods)
- [Is it possible to narrow the access level/return type when overriding a method?](#is-it-possible-to-narrow-the-access-levelreturn-type-when-overriding-a-method)
- [Is it possible to change: the access modifier, the return type, the type of argument or their number, the names of arguments or their order when overriding a method; remove, add, reorder the elements of the throws section?](#is-it-possible-to-change-the-access-modifier-the-return-type-the-type-of-argument-or-their-number-the-names-of-arguments-or-their-order-when-overriding-a-method-remove-add-reorder-the-elements-of-the-throws-section)
- [How do I access the overridden methods of the parent class?](#how-do-i-access-the-overridden-methods-of-the-parent-class)
- [Is it possible to declare a method abstract and static at the same time?](#is-it-possible-to-declare-a-method-abstract-and-static-at-the-same-time)
- [What is the difference between an instance member of a class and a static member of a class?](#what-is-the-difference-between-an-instance-member-of-a-class-and-a-static-member-of-a-class)
- [Where is initialization of static/non-static fields allowed?](#where-is-initialization-of-staticnon-static-fields-allowed)
- [What types of classes are there in Java?](#what-types-of-classes-are-there-in-java)
- [Tell us about nested classes. In what cases are they used?](#tell-us-about-nested-classes-in-what-cases-are-they-used)
- [What is a "static class"?](#what-is-a-static-class)
- [What are the features of using nested classes: static and internal? What is the difference between them?](#what-are-the-features-of-using-nested-classes-static-and-internal-what-is-the-difference-between-them)
- [What is a "local class"? What are its features?](#what-is-a-local-class-what-are-its-features)
- [What are "anonymous classes"? Where are they used?](#what-are-anonymous-classes-where-are-they-used)
- [How do I access an external class field from a nested class?](#how-do-i-access-an-external-class-field-from-a-nested-class)
- [What is the assert operator used for?](#what-is-the-assert-operator-used-for)
- [What is Heap and Stack memory in Java? What is the difference between them?](#what-is-heap-and-stack-memory-in-java-what-is-the-difference-between-them)
- [Is it true that primitive data types are always stored on the stack and instances of reference data types are on the heap?](#is-it-true-that-primitive-data-types-are-always-stored-on-the-stack-and-instances-of-reference-data-types-are-on-the-heap)
- [How are variables passed to methods, by value or by reference?](#how-are-variables-passed-to-methods-by-value-or-by-reference)
- [What is a garbage collector for?](#what-is-a-garbage-collector-for)
- [How does the garbage collector work?](#how-does-the-garbage-collector-work)
- [What types of garbage collectors are implemented in the HotSpot virtual machine?](#what-types-of-garbage-collectors-are-implemented-in-the-hotspot-virtual-machine)
- [Describe the algorithm of some garbage collector implemented in the HotSpot virtual machine.](#describe-the-algorithm-of-some-garbage-collector-implemented-in-the-hotspot-virtual-machine)
- [What is a "string pool"?](#what-is-a-string-pool)
- [What is finalize()? Why is it needed?](#what-is-finalize-why-is-it-needed)
- [What happens to the garbage collector if the finalize() method takes a significant amount of time to run, or if an exception is thrown during execution?](#what-happens-to-the-garbage-collector-if-the-finalize-method-takes-a-significant-amount-of-time-to-run-or-if-an-exception-is-thrown-during-execution)
- [What is the difference between final, finally, and finalize()?](#what-is-the-difference-between-final-finally-and-finalize)
- [Tell us about type conversion. What is Downgrade and Type Upgrade?](#tell-us-about-type-conversion-what-is-downgrade-and-type-upgrade)
- [When can a ClassCastException be thrown in an application?](#when-can-a-classcastexception-be-thrown-in-an-application)
- [What is autoboxing in Java and what are the rules for wrapping primitive types into wrapper classes?](#what-is-autoboxing-in-java-and-what-are-the-rules-for-wrapping-primitive-types-into-wrapper-classes)
- [What are the features of the String class?](#what-are-the-features-of-the-string-class)
- [Why is String an immutable and finalized class?](#why-is-string-an-immutable-and-finalized-class)
- [Why is char[] preferable to String for storing a password?](#why-is-char-preferable-to-string-for-storing-a-password)
- [Why is a string a popular key in a HashMap in Java?](#why-is-a-string-a-popular-key-in-a-hashmap-in-java)
- [What does the intern() method do in the String class?](#what-does-the-intern-method-do-in-the-string-class)
- [Can strings be used in a switch construct?](#can-strings-be-used-in-a-switch-construct)
- [What is the main difference between String, StringBuffer, StringBuilder?](#what-is-the-main-difference-between-string-stringbuffer-stringbuilder)
- [What is the Object class? What methods does it have?](#what-is-the-object-class-what-methods-does-it-have)
- [Define the concept of "constructor".](#define-the-concept-of-constructor)
- [What is the "default constructor"?](#what-is-the-default-constructor)
- [What is the difference between the default constructor, the copy constructor, and the parameter constructor?](#what-is-the-difference-between-the-default-constructor

-the-copy-constructor-and-the-parameter-constructor)
- [Where and how can you use a private builder?](#where-and-how-can-you-use-a-private-builder)
- [Tell us about loader classes and dynamic class loading.](#tell-us-about-loader-classes-and-dynamic-class-loading)
- [What is Reflection?](#what-is-reflection)
- [Why do we need equals(). How is it different from ==?](#why-do-we-need-equals-how-is-it-different-from-)
- [If you want to override equals(), what conditions should be met?](#if-you-want-to-override-equals-what-conditions-should-be-met)
- [What are the properties of the equivalence relation generated by equals()?](#what-are-the-properties-of-the-equivalence-relation-generated-by-equals)
- [Rules for overriding the Object.equals() method.](#rules-for-overriding-the-objectequals-method)
- [What is the relationship between hashCode() and equals()?](#what-is-the-relationship-between-hashcode-and-equals)
- [If equals() is overridden, are there any other methods that should be overridden?](#if-equals-is-overridden-are-there-any-other-methods-that-should-be-overridden)
- [What happens if I override equals() without overriding hashCode()? What problems can arise?](#what-happens-if-i-override-equals-without-overriding-hashcode-what-problems-can-arise)
- [How are the hashCode() and equals() methods implemented in the Object class?](#how-are-the-hashcode-and-equals-methods-implemented-in-the-object-class)
- [What is the hashCode() method for?](#what-is-the-hashcode-method-for)
- [What are the rules for overriding the Object.hashCode() method?](#what-are-the-rules-for-overriding-the-objecthashcode-method)
- [Are there any guidelines on which fields should be used when calculating hashCode()?](#are-there-any-guidelines-on-which-fields-should-be-used-when-calculating-hashcode)
- [Can different objects have the same hashCode()?](#can-different-objects-have-the-same-hashcode)
- [If the Point{int x, y;} class implements the equals(Object that) {(return this.x == that.x && this.y == that.y)} method, but makes the hash code in the form of int hashCode() {return x;}, will such points be correctly placed and retrieved from the HashSet?](#if-the-pointint-x-y-class-implements-the-equalsobject-that-return-this-x--that-x--this-y--that-y-method-but-makes-the-hash-code-in-the-form-of-int-hashcode-return-x-will-such-points-be-correctly-placed-and-retrieved-from-the-hashset)
- [Can different objects (ref0 != ref1) have ref0.equals(ref1) == true?](#can-different-objects-ref0-ref1-have-ref0equalsref1--true)
- [Can different references to the same object (ref0 == ref1) have ref0.equals(ref1) == false?](#can-different-references-to-the-same-object-ref0--ref1-have-ref0equalsref1--false)
- [Is it possible to implement the equals(Object that) method {return this.hashCode() == that.hashCode()}?](#is-it-possible-to-implement-the-equalsobject-that-method-return-this-hashcode--that-hashcode)
- [In equals(), you need to check that the equals(Object that) argument is of the same type as the object itself. What's the difference between this.getClass() == that.getClass() and that instanceof MyClass?](#in-equals-you-need-to-check-that-the-equalsobject-that-argument-is-of-the-same-type-as-the-object-itself-whats-the-difference-between-thisgetclass--thatgetclass-and-that-instanceof-myclass)
- [Is it possible to implement the equals() method of the MyClass class like this: class MyClass {public boolean equals(MyClass that) {return this == that;}}?](#is-it-possible-to-implement-the-equals-method-of-the-myclass-class-like-this-class-myclass-public-boolean-equals-myclass-that-return-this--that)
- [There is a class called Point{int x, y;}. Why is a hash code of 31*x+y preferable to x+y?](#there-is-a-class-called-pointint-x-y-why-is-a-hash-code-of-31x-y-preferable-to-x+y)
- [Tell us about cloning objects.](#tell-us-about-cloning-objects)
- [What is the difference between surface and deep cloning?](#what-is-the-difference-between-surface-and-deep-cloning)
- [Which cloning method is preferable?](#which-cloning-method-is-preferable)
- [Why is the clone() method declared in the Object class and not in the Cloneable interface?](#why-is-the-clone-method-declared-in-the-object-class-and-not-in-the-cloneable-interface)
- [Describe the hierarchy of exceptions.](#describe-the-hierarchy-of-exceptions)
- [What types of exceptions do you know in Java, how do they differ?](#what-types-of-exceptions-do-you-know-in-java-how-do-they-differ)
- [What is a checked and unchecked exception?](#what-is-a-checked-and-unchecked-exception)
- [Which operator allows you to force an exception to be thrown?](#which-operator-allows-you-to-force-an-exception-to-be-thrown)
- [What does the throws keyword mean?](#what-does-the-throws-keyword-mean)
- [How do you write your own ("user") exception?](#how-do-you-write-your-own-user-exception)
- [What are the unchecked exceptions?](#what-are-the-unchecked-exceptions)
- [What are Error class errors?](#what-are-error-class-errors)
- [What do you know about OutOfMemoryError?](#what-do-you-know-about-outofmemoryerror)
- [Describe how the try-catch-finally block works.](#describe-how-the-try-catch-finally-block-works)
- [What is the try-with-resources mechanism?](#what-is-the-try-with-resources-mechanism)
- [Is it possible to use a try-finally block (without catch)?](#is-it-possible-to-use-a-try-finally-block-without-catch)
- [Can a single catch block catch multiple exceptions at once?](#can-a-single-catch-block-catch-multiple-exceptions-at-once)
- [Is the finally block always executed?](#is-the-finally-block-always-executed)
- [Are there situations where a finally block will fail?](#are-there-situations-where-a-finally-block-will-fail)
- [Can the main() method throw an exception outside and, if so, where will the exception be handled?](#can-the-main-method-throw-an-exception-outside-and-if-so-where-will-the-exception-be-handled)
- [Suppose there is a method that can throw IOException and FileNotFoundException, in what sequence should the catch blocks go? How many catch blocks will be executed?](#suppose-there-is-a-method-that-can-throw-ioexception-and-filenotfoundexception-in-what-sequence-should-the-catch-blocks-go-how-many-catch-blocks-will-be-executed)
- [What are generics?](#what-are-generics)
- [What is "internationalization" and "localization"?](#what-is-internationalization-and-localization)

--- 


## What is the difference between JRE, JVM, and JDK?
The Java Virtual Machine (JVM) is the main part of the Java runtime environment (JRE). The Java Virtual Machine executes Java bytecode that is pre-generated from the Java source code by the Java compiler. The JVM can also be used to execute programs written in other programming languages.

The Java Runtime Environment (JRE) is the minimum required implementation of a virtual machine to run Java applications. It consists of the JVM and a standard set of Java class libraries.

JDK, Java Development Kit, is a JRE and a set of tools for developing applications in the Java language, including a Java compiler, standard Java class libraries, examples, documentation, and various utilities.

In short: JDK is an environment for developing programs in Java, which includes a JRE environment for running Java programs, which in turn contains a JVM - an interpreter of Java program code.

JRE, JVM, and JDK are key components of the Java ecosystem, each serving a distinct purpose:

1. **JVM (Java Virtual Machine)**: This is the virtual machine that executes Java bytecode. It manages memory, runs code, and interacts with the operating system. The JVM enables platform independence, as bytecode can run on any system with the appropriate JVM installed.

2. **JRE (Java Runtime Environment)**: This is the runtime environment for Java, which includes the JVM and a set of libraries necessary for running Java applications. The JRE does not contain development tools like compilers or debuggers; its purpose is to provide the environment for executing already compiled programs.

3. **JDK (Java Development Kit)**: This is the complete package for developing applications in Java. The JDK includes the JRE along with development tools such as the Java compiler (`javac`), debugger, and other utilities. It is intended for developers who write and compile Java code.

In summary:
- **JVM**: Executes bytecode.
- **JRE**: Contains the JVM and libraries for running programs.
- **JDK**: Includes the JRE and tools for development.
- 
[⬆️ Back to Top](#java-core) 

## What are the different access modifiers?
**Private**: Class members are only available within the class. A function word is used for designation.private

**default, package-private, package level**: Visibility of the class/class members only within the package. Is a default access modifier - special No designation required.

**protected**: Class members are available within the package and in the descendants. A function word is used for designation.protected

**public**: The class/class members are available to everyone. A function word is used for designation.public

The sequence of modifiers in ascending order of the level of closure: public, protected, default, private.

During inheritance, it is possible to change access modifiers towards greater visibility (to maintain compliance with Barbara Liskov's substitution principle).

[⬆️ Back to Top](#java-core) 

## What does the keyword say?final
A modifier can be applied to variables, method parameters, fields and methods of a class, or to the classes themselves.final

A class cannot have heirs;
A method cannot be overridden in descendant classes;
A field cannot change its value after initialization;
Method parameters cannot change their value within a method;
Local variables cannot be changed after they have been assigned a value.
[⬆️ Back to Top](#java-core) 

## What are the default variable initialization values?
Numbers are initialized or 00.0;
char — \u0000;
boolean — false;
Objects (including ) are .Stringnull
[⬆️ Back to Top](#java-core) 

## What do you know about the feature?main()
The method is the entry point into the program. An application can have several such methods. If the method is missing, then compilation is possible, but the error 'Error: Main method not found' will be received on startup.main()

public static void main(String[] args) {}
[⬆️ Back to Top](#java-core) 

What logical operations and operators do you know?
&: Boolean AND (AND);
&&: Abbreviated AND;
|: Boolean OR (OR);
||: Abbreviated OR;
^: Boolean XOR (exclusive OR);
!: Boolean unary NOT (НЕ);
&=: AND with assignment;
|=: OR with assignment;
^=: XOR with assignment;
==:Equally;
!=: Not equal;
?:: Ternary (ternary) conditional operator.
[⬆️ Back to Top](#java-core) 

## What is a ternary selection operator?
A ternary conditional operator is an operator that can replace some constructs of operators.?:if-then-else

The expression is written in the following form:

condition? Expression1 : Expression2

If it is executed, it is evaluated and its result becomes the result of the execution of the entire statement. If it is , then its value is calculated and becomes the result of the operator's work. Both operands and must return a value of the same (or compatible) type.условиевыражение1условиеfalseвыражение2выражение1выражение2

[⬆️ Back to Top](#java-core) 

## What bitwise operations do you know?
~: Bitwise unary operator NOT;
&: Bitwise AND;
&=: Bitwise AND with assignment;
|: Bitwise OR;
|=: Bitwise OR with assignment;
^: Bitwise exclusive XOR;
^=: Bitwise exclusive XOR with assignment;
>>: Shift to the right (division by 2 in the degree of shift);
>>=: Shift right with assignment;
>>>: Shift to the right without taking into account the sign;
>>>=: Shift to the right without taking into account the sign with assignment;
<<: Shift to the left (multiply by 2 in the degree of shift);
<<=: Shift left with assignment.
[⬆️ Back to Top](#java-core) 

## Where and for what is the modifier used?abstract
A class marked with a modifier is called an abstract class. Such classes can only act as ancestors for other classes. You are not allowed to create instances of the abstract class itself. At the same time, the heirs of an abstract class can be both other abstract classes and classes that allow the creation of objects.abstract

A method marked with a keyword is an abstract method, i.e. a method that does not have an implementation. If there is at least one abstract method in the class, then the entire class must be declared abstract.abstract

Using abstract classes and methods allows you to describe a pattern of an object that needs to be implemented in other classes. They themselves describe only a certain behavior common to all descendants.

[⬆️ Back to Top](#java-core) 

## Define the concept of "interface". What default modifiers do interface fields and methods have?
The keyword is used to create fully abstract classes. The main purpose of an interface is to define how we can use the class that implements it. The interface creator defines method names, argument lists, and return types, but does not implement their behavior. All methods are implicitly declared as .interfacepublic

Starting with Java 8, interfaces are allowed to host implementations of default and static methods.defaultstatic

The interface can also contain fields. In this case, they are automatically public, static, and immutable.publicstaticfinal

[⬆️ Back to Top](#java-core) 

## How is an abstract class different from an interface? When should you use an abstract class and when should you use an interface?
In Java, a class can implement multiple interfaces at the same time, but inherit from only one class.
Abstract classes are used only when the "is a" relationship type is present. Interfaces can be implemented by classes that are not related to each other.
An abstract class is a means to avoid writing repetitive code, a tool for partial implementation of behavior. An interface is a means of expressing the semantics of a class, a contract that describes capabilities. All interface methods are implicitly declared as or (since Java 8) as default implementation methods, and fields are .public abstractdefaultpublic static final
Interfaces allow you to create type structures without hierarchy.
Inheriting from the abstract, class "dissolves" its own individuality. By implementing the interface, it extends its own functionality.
Abstract classes contain a partial implementation that is augmented or extended in subclasses. At the same time, all subclasses are similar to each other in the part of the implementation inherited from the abstract class and differ only in the part of their own implementation of the abstract methods of the parent. Therefore, abstract classes are used in the case of building a hierarchy of classes of the same type, very similar to each other. In this case, inheriting from an abstract class that implements the default behavior of the object can be useful because it avoids writing repetitive code. In all other cases, it is better to use interfaces.

[⬆️ Back to Top](#java-core) 

## Why don't some interfaces define methods at all?
These are the so-called token interfaces. They simply indicate that the class is of a certain type. An example would be an interface that indicates that a class supports a cloning mechanism.Clonable

[⬆️ Back to Top](#java-core) 

## Why can't I declare an interface method with a modifier?final
In the case of interfaces, specifying a modifier is meaningless, because all methods of interfaces are implicitly declared as abstract, i.e. they cannot be executed without being implemented elsewhere, and this cannot be done if the method has the identifier .finalfinal

[⬆️ Back to Top](#java-core) 

## Which has a higher level of abstraction – a class, an abstract class, or an interface?
Interface.

[⬆️ Back to Top](#java-core) 

## Can an object access a class member declared as ? If so, how?private
Inside the class, access to a private variable is open without restrictions;
A nested class has full access to all (including private) members of the class that contains it;
Access to private variables from the outside can be organized through methods other than private ones, which are provided by the class developer. For example: and .getX()setX()
Through the reflection API mechanism:
class Victim { 
    private int field = 42;
}
//...
Victim victim = new Victim(); 
Field field = Victim.class.getDeclaredField("field"); 
field.setAccessible(true); 
int fieldValue = (int) field.get(victim);
//...
[⬆️ Back to Top](#java-core) 

## What is the order in which constructors and initialization blocks are invoked based on the class hierarchy?
First, all static blocks are called in order from the first static block of the root ancestor and up the chain of the hierarchy to the static blocks of the class itself.

Then, the non-static root ancestor initialization blocks, the root ancestor constructor, and so on are called, all the way up to the non-static blocks and the constructor of the class itself.

Parent static block(s) → Child static block(s) → Grandchild static block(s)

→ Parent non-static block(s) → Parent constructor →

→ Child non-static block(s) → Child constructor →

→ Grandchild non-static block(s) → Grandchild constructor

[⬆️ Back to Top](#java-core) 

## Why are initialization blocks needed and what are the types?
Initialization blocks are code enclosed in curly braces and placed inside a class outside of a method or constructor declaration.

There are static and non-static initialization blocks.
The initialization block is executed before the class is initialized by the class loader or the creation of a class object by using a constructor.
Multiple initialization blocks are executed in order in the class code.
The initialization block is capable of throwing exceptions if their declarations are listed in all class constructors.throws
An initialization block can also be created in an anonymous class.
[⬆️ Back to Top](#java-core) 

To which Java constructs does the modifier apply?static
Fields;
Methods;
nested classes;
members of the section.import
[⬆️ Back to Top](#java-core) 

## Why do Java use static initialization blocks?
Static initialization blocks are used to execute code that must run once when a class is initialized by the class loader, at the time before the class objects are created by the constructor. Such a block (as opposed to non-static blocks belonging to a particular class object) belongs only to the class itself (the metaclass object).Class

[⬆️ Back to Top](#java-core) 

## What happens if an exception occurs in the initialization block?
For non-static initialization blocks, if the throw of an exception is explicitly specified, it is required that the declarations of those exceptions be listed in all constructors of the class. Otherwise, there will be a compilation error. For a static block, throwing an exception explicitly results in a compilation error.throws

In other cases, the interaction with exceptions will take place in the same way as in any other place. The class will not be initialized if the error occurs in a static block and the class object will not be created if the error occurs in a non-static block.

[⬆️ Back to Top](#java-core) 

## What exception is thrown when an error occurs in the class initialization block?
If the exception that has arisen is the heir:RuntimeException

for static initialization blocks will be discarded java.lang.ExceptionInInitializerError;
For non-static ones, a source exception will be thrown.
If the exception that has arisen is the heir, then in both cases it will be thrown out. Exception: - Thread death. In this case, no exception will be thrown.Errorjava.lang.Errorjava.lang.ThreadDeath

[⬆️ Back to Top](#java-core) 

## Can a static method be overridden or overloaded?
Overloaded - yes. Everything works exactly the same as with regular methods - 2 static methods can have the same name if the number of their parameters or types is different.

Overridden - no. The choice of the static method to be called occurs early in binding (at the compile stage, not at the time of execution) and the parent method will always be executed, although syntactically overriding a static method is a perfectly correct language construct.

In general, it is recommended that static fields and methods be accessed through the class name rather than the object.

[⬆️ Back to Top](#java-core) 

## Can non-static methods overwhelm static methods?
Yes. As a result, you will get two different methods. Static will belong to a class and will be accessible through its name, and non-static will belong to a specific object and will be accessible through a method call to that object.

[⬆️ Back to Top](#java-core) 

## Is it possible to narrow the access level/return type when overriding a method?
Is it possible to change: the access modifier, the return type, the type of argument or their number, the names of arguments or their order when overriding a method; remove, add, change the order of section elements?throws
When overriding a method, narrowing the access modifier is not allowed, as this would violate Barbara Liskov's substitution principle. Expanding the level of access is possible.

You can change anything that doesn't prevent the compiler from understanding which method of the parent class is meant:

Changing the type of the return value when overriding a method is allowed only in the direction of narrowing the type (instead of the parent class - the descendant).
If you change the type, number, and order of arguments, instead of overriding, the method will be overloaded.
You don't have to specify a section of a method, but it's worth remembering that it remains valid if it's already defined on the method of the parent class. It is also possible to add new exceptions that are heirs to those already announced or exclusions. The order of such elements does not matter when overriding.throwsRuntimeException
[⬆️ Back to Top](#java-core) 

## How do I access the overridden methods of the parent class?
With a keyword, we can access any member of the parent class - a method or a field, as long as they are not defined with a modifier.superprivate

super.method();
[⬆️ Back to Top](#java-core) 

## Is it possible to declare a method abstract and static at the same time?
No. In this case, the compiler will throw an error: "Illegal combination of modifiers: 'abstract' and 'static'". The modifier says that the method will be implemented in another class, but instead indicates that this method will be available by the class name.abstractstatic

[⬆️ Back to Top](#java-core) 

## What is the difference between an instance member of a class and a static member of a class?
The modifier tells you that the method or field belongs to the class itself and can be accessed even without creating an instance of the class. Marked fields are initialized when the class is initialized. Methods declared as , have a number of limitations:staticstaticstatic

They can only call other static methods.
They should only access static variables.
They cannot refer to members of the or .thissuper
Unlike static fields, class instance fields belong to a specific object and can have different values for each. An instance method can only be called after the class object has been created first.

[⬆️ Back to Top](#java-core) 

## Where is initialization of static/non-static fields allowed?
Static fields can be initialized at declaration, in a static or non-static initialization block.
Non-static fields can be initialized at declaration, in a non-static initialization block, or in a constructor.
[⬆️ Back to Top](#java-core) 

## What types of classes are there in java?
Top level class:
Abstract class;
Final class.
Interfaces.
enum (enumeration).
Nested class:
Static nested class;
Member inner class;
Local inner class;
Anonymous inner class.
[⬆️ Back to Top](#java-core) 

## Tell us about nested classes. In what cases are they used?
A class is called a nested class if it is defined within another class. A nested class should be created only to serve the class that surrounds it. If a nested class is useful in some other context, it should become the top-level class. Nested classes have access to all (including private) fields and methods of an external class, but not vice versa. Because of this permission, the use of nested classes results in some encapsulation violation.

There are four categories of nested classes: + Static nested class; + Member inner class; + Local inner class; + Anonymous inner class.

Such class categories, with the exception of the first class, are also called Inner class. Internal classes are not associated with an outer class, but with an instance of an outer class.

Each of the categories has recommendations for its use. If a nested class needs to be visible outside of a single method, or if it is too long to fit comfortably within the boundaries of a single method, and if each instance of that class needs a reference to the instance that includes it, then a non-static inner class is used. In case a reference to a framing class is not required, it is better to make such a class static. If a class is only needed within a method and you want to instantiate that class only in that method, then the local class is used. If, in addition, the use of a class is limited to use only in one place and there is already a type that characterizes this class, then it is recommended to make it an anonymous class.

[⬆️ Back to Top](#java-core) 

## What is a "static class"?
It is a nested class declared using the . The modifier is not applicable to top-level classes.staticstatic

[⬆️ Back to Top](#java-core) 

## What are the features of using nested classes: static and internal? What is the difference between them?
Nested classes can access all members of the framing class, including private ones.
You do not need an external class object to create a static nested class object.
From a static nested class object, you cannot access non-static members of a framing class directly, but only by referencing an instance of an outer class.
Regular nested classes cannot contain static methods, initialization blocks, or classes. Static nested classes can.
A regular nested class object stores a reference to an external class object. There is no such link inside the static one. An instance of a framing class is accessed by specifying it after its name. For example:..thisOuter.this
[⬆️ Back to Top](#java-core) 

## What is a "local class"? What are its features?
A local inner class is a nested class that can be declared in any block where variables are allowed. Like simple Member inner classes, local classes have names and can be reused. Like anonymous classes, they have an instance surrounding them only when used in a non-static context.

Local classes have the following features:

Visible only within the block in which they are declared;
Cannot be declared as // or privatepublicprotectedstatic;
Cannot have static declarations (fields, methods, classes) inside them;
Have access to the fields and methods of the framing class;
Can access local variables and method parameters if they are declared with the .final
[⬆️ Back to Top](#java-core) 

## What are "anonymous classes"? Where are they used?
This is a nested local class with no name that can be declared anywhere in the enclosing class that allows the placement of expressions. An anonymous class is instantiated at the same time as it is declared. Depending on the location, an anonymous class behaves as either a static or non-static nested class—an instance of the surrounding class appears in a non-static context.

Anonymous classes have several limitations:

Their use is allowed only in one place of the program - the place of its creation;
Use is possible only if there is no need to refer to it after the instance is generated;
It implements only the methods of its interface or superclass, i.e. it cannot declare any new methods, since there is no named type to access them.
Anonymous classes are typically used to:

creating a function object, such as implementing an interface Comparator;
creating a process object, such as instances of the , and similar classes;ThreadRunnable
in the static generation method;
initialization of an open static field that corresponds to a complex type enumeration where a separate subclass is required for each instance in the enumeration.final
[⬆️ Back to Top](#java-core) 

## How do I access an external class field from a nested class?
A static nested class has direct access only to the static fields of the enclosing class.

A simple inner class can access any field in an outer class directly. If a nested class already has a field with the same literal, then such a field should be accessed through a reference to its copy. For example:.Outer.this.field

[⬆️ Back to Top](#java-core) 

## What is the operator used for?assert
Assert is a special construct that allows you to test assumptions about the values of arbitrary data at any point in the program. The assertion can automatically signal that invalid data has been detected, which usually causes the program to crash and indicate where the invalid data was detected.

Assertions make it much easier to isolate errors in your code. Even checking the results of the execution of obvious code can be useful in subsequent refactoring, after which the code may become less obvious and an error may creep into it.

Typically, approvals are left enabled during program development and testing, but are disabled in release versions of programs.

Because assertions can be removed at compile time or at runtime, they should not change the behavior of the program. If the behavior of the program can change as a result of the removal of the assert, then this is a clear sign of misuse of the assert. Thus, inside the assert, you cannot call methods that change the state of the program or the external environment of the program.

In Java, claims validation is implemented using the operator, which has the form:assert

assert [Выражение типа boolean]; or assert [Выражение типа boolean] : [Выражение любого типа, кроме void];

At runtime, if assertion verification is enabled, the value of the Boolean expression is evaluated, and if its result is , an exception is thrown. In the case of the second form of the operator, the expression after the colon specifies a detailed message about the error that occurred (the evaluated expression will be converted to a string and passed to the constructor).falsejava.lang.AssertionErrorassertAssertionError

[⬆️ Back to Top](#java-core) 

## What is Heap and Stack memory in Java? What is the difference between them?
Heap is used by the Java Runtime to allocate memory for objects and classes. The creation of a new object also occurs on the heap. This is also the area of work of the garbage collector. Any object created on the heap has global access and can be referenced from anywhere in the application.

A stack is an area of data storage, also located in shared random access memory (RAM). Whenever a method is called, a new block is created in stack memory that contains primitives and references to other objects in the method. As soon as a method finishes working, the block also stops being used, thereby granting access to the next method. The size of the stack memory is much smaller than the amount of memory on the heap. The stack in Java works according to the LIFO (Last-In-First-Out) scheme

Differences between Heap and Stack memory:

The heap is used by all parts of the application, while the stack is used by only one thread of the program's execution.
Whenever an object is created, it is always stored on the heap, and the stack memory contains only a reference to it. Stack memory contains only local variables of primitive types and references to objects on the heap.
Objects on the heap are accessible from anywhere in the program, while stack memory cannot be accessed by other threads.
Stack memory exists only for a short period of time when a program is running, and heap memory lives from the beginning to the end of the program.
If the stack memory is fully occupied, then the Java Runtime throws a . If the heap memory is full, an exception is thrown.java.lang.StackOverflowErrorjava.lang.OutOfMemoryError: Java Heap Space
The stack memory size is much smaller than the memory on the heap.
Because of the ease of memory allocation, stack memory is much faster than heap.
JVM options are also used to determine the initial and maximum memory size on the heap. For the stack, you can determine the memory size using the .-Xms-Xmx-Xss

[⬆️ Back to Top](#java-core) 

## Is it true that primitive data types are always stored on the stack and instances of reference data types are on the heap?
Not really. The primitive field of a class instance is not stored on the stack, but on the heap. Any object (anything that is explicitly or implicitly created using the operator) is stored on the heap.new

[⬆️ Back to Top](#java-core) 

## How are variables passed to methods, by value or by reference?
In Java, parameters are always passed only by value, which is defined as "copy the value and pass a copy". With primitives, this will be a copy of the content. With links - also a copy of the content, i.e. a copy of the link. At the same time, it is possible to change the internal members of reference types through such a copy, but the reference itself pointing to the instance is not.

[⬆️ Back to Top](#java-core) 

## What is a garbage collector for?
The Garbage Collector only needs to do two things:

Find garbage - unused objects. (An object is considered unused if none of the entities in the code currently running contain references to it, or if the chain of references that could have associated the object with some application entity is broken.)
To free memory from garbage.
There are two approaches to garbage detection:

Reference counting;
Tracing
Reference counting. The essence of this approach is that each object has a counter. The counter stores information about how many references point to an object. When the link is destroyed, the counter is decremented. If the counter value is zero, the object can be considered garbage. The main disadvantage of this approach is the difficulty of ensuring the accuracy of the meter. It is also difficult to detect circular dependencies (where two objects point to each other but no living object references them), which leads to memory leaks.

The main idea of the Tracing approach is that only those objects that we can reach from the GC Root and those objects that are accessible from a living object can be considered alive. Everything else is garbage.

There are 4 types of root points:

Local variables and method parameters;
Flows;
Static variables;
Links from JNI.
The simplest java application will have root points:

Local variables within a method and method parameters;main()main()
A thread that executes main();
Static variables of the class inside which the method resides.main()
Thus, if we represent all the objects and the references between them as a tree, then we need to go from the root nodes (points) along all the edges. At the same time, the nodes that we can get to are not garbage, all the rest are garbage. With this approach, cyclical dependencies are easily identified. HotSpot VM takes this approach.

There are two main methods for cleaning up memory from garbage:

Copying collectors
Mark-and-sweep
In the copying collectors approach, memory is divided into two parts "from-space" and "to-space", while the principle of operation is as follows:

Objects are created in "from-space";
When "from-space" is populated, the app is suspended;
The garbage collector starts. Living objects are found in "from-space" and copied to "to-space";
When all objects are copied, "from-space" is completely cleared;
"to-space" and "from-space" are swapped.
The main advantage of this approach is that objects densely clog up memory. Disadvantages of the approach:

The application must be stopped for the time necessary to complete the garbage collection cycle;
In the worst-case scenario (when all objects are alive), "form-space" and "to-space" will be required to be the same size.
The mark-and-sweep algorithm can be described as follows:

Objects are created in memory;
The moment you want to start the garbage collector, the application is suspended;
The collector traverses the object tree, marking living objects;
The collector goes through the entire memory, finding all unmarked pieces of memory and saving them in the "free list";
When new objects are created, they are created in the memory available in the "free list".
Disadvantages of this method:

The application is not running while garbage collection is in progress;
The stop time is directly related to the size of the memory and the number of objects;
If you do not use "compacting", the memory will not be used efficiently.
HotSpot VM garbage collectors use a combined Generational Garbage Collection approach that allows for different algorithms for different stages of garbage collection. This approach is based on the fact that:

most of the objects you create quickly become garbage;
There are few relationships between objects that were created in the past and newly created objects.
[⬆️ Back to Top](#java-core) 

## How does the garbage collector work?
The garbage collection mechanism is the process of freeing up space on the heap so that new objects can be added.

Objects are created using the operator, thereby assigning a reference to the object. To finish working with an object, you just need to stop referencing it, for example, by assigning a variable a reference to another object or value; stop executing a method so that its local variables will terminate naturally. Objects that are not referenced are called garbage, which will be deleted.newnull

The Java Virtual Machine uses a garbage collection mechanism to ensure that any object that has references remains in memory—any objects that are unreachable from the executable code because they are not referenced are deleted and the memory allotted to them is freed. More specifically, an object is not within the scope of the garbage collection process if it is reachable by a chain of references starting with the GC Root reference, which is the reference that exists directly in the code being executed.

Memory is freed by the garbage collector at its own "discretion". A program can successfully terminate without running out of free memory or even coming close to that point, and therefore it will never need the "services" of a garbage collector.

Garbage is collected automatically by the system, without user or programmer intervention, but that doesn't mean the process doesn't require attention at all. The need to create and delete a large number of objects has a significant impact on the performance of applications, and if program performance is an important factor, you should carefully consider decisions related to the creation of objects, which, in turn, will reduce the amount of garbage to be disposed of.

[⬆️ Back to Top](#java-core) 

## What types of garbage collectors are implemented in the HotSpot virtual machine?
The Java HotSpot VM provides developers with four different garbage collectors to choose from:

Serial is the simplest option for low-data, low-latency applications. At the moment, it is relatively rarely used, but on low-end computers, it can be selected by the virtual machine as the default collector. The use of Serial GC is enabled by the option.-XX:+UseSerialGC
Parallel - Inherits assembly approaches from the sequential collector, but adds parallelism to some operations, as well as the ability to automatically adjust to the required performance parameters. The parallel collector is enabled by the option.-XX:+UseParallelGC
Concurrent Mark Sweep (CMS) aims to reduce maximum latency by performing some of the garbage collection work in parallel with the main threads of the application. Suitable for handling relatively large amounts of data in memory. The use of CMS GC is enabled by the option.-XX:+UseConcMarkSweepGC
Garbage-First (G1) is designed to replace CMS, especially in server applications running on multiprocessor servers and operating large amounts of data. G1 is enabled by the Java option.-XX:+UseG1GC
[⬆️ Back to Top](#java-core) 

## Describe the algorithm of some garbage collector implemented in the HotSpot virtual machine.
Serial Garbage Collector was one of the first garbage collectors in HotSpot VM. While this collector is running, the application is suspended and continues to run only after the garbage collection stops.

The app's memory is divided into three spaces:

Young generation. Objects are created in this particular memory location.
Old generation. Objects that survive the "minor garbage collection" are moved to this memory area.
Permanent generation. This is where metadata about objects, Class data sharing (CDS), and String pool are stored. The Permanent area is divided into two: read-only and read-write. Obviously, in this case, the read-only area is never cleaned up by the garbage collector.
The Young generation memory area consists of three regions: Eden and two smaller Survivor spaces, To space and From space. Most objects are created in the Eden region, with the exception of very large objects that cannot be placed in it and are therefore immediately placed in the Old generation. Objects that have survived at least one garbage collection but have not yet reached the tenuring threshold to be moved to Old generation are moved to Survivor Spaces.

When the Young generation is populated, a minor collection process is started in this area, as opposed to a full collection process. It works like this: at the start of work, one of the Survivor spaces, To space, is empty, and the other, From space, contains objects that have survived previous builds. The garbage collector looks for live objects in Eden and copies them to To space, and then copies live "young" (i.e., not yet surviving a specified number of garbage collections) objects from From space to To space. Old objects from From space are moved to Old generation. After a light build, From space and To space switch roles, the Eden area becomes empty, and the number of objects in the Old generation increases.

If the To space is overflowing during the copying process, then the remaining live objects from Eden and From space that do not have enough space in the To space will be moved to the Old generation, regardless of how many garbage collections they survived.

Because this algorithm simply copies all living objects from one memory area to another, this garbage collector is called copying. Obviously, for a copy garbage collector to work, an application must always have a free area of memory to which live objects will be copied, and this algorithm can be applied to areas of memory that are relatively small in relation to the total size of the application's memory. Young generation meets this condition (by default, on client-type machines, this area occupies about 10% of the heap (the value may vary depending on the platform)).

However, for garbage collection in the Old generation, which occupies most of all memory, a different algorithm is used.

In Old generation, garbage collection occurs using the mark-sweep-compact algorithm, which consists of three phases. In the Mark phase, the garbage collector flags all living objects, then, in the Sweep phase, all unmarked objects are deleted, and in the Compact phase, all living objects are moved to the beginning of the Old generation, as a result of which the free memory after cleanup is a contiguous area. The compacting phase is done to avoid fragmentation and to simplify the memory allocation process in the Old generation.

When free memory is a contiguous area, then a very fast bump-the-pointer algorithm (about a dozen machine instructions) can be used to allocate memory for the object being created: the address of the beginning of free memory is stored in a special pointer, and when a request is received to create a new object, the code checks that there is enough space for the new object, and if so, it simply increments the pointer to the size of the object.

A sequential garbage collector is ideal for most applications that use up to 200 megabytes of heap, run on client-type machines, and do not have strict requirements for the amount of garbage collection time spent on garbage collection. At the same time, the stop-the-world model can cause long pauses in the application when using large amounts of memory. In addition, the sequential algorithm does not allow optimal use of the computer's computing resources, and the sequential garbage collector can become a bottleneck when running an application on multiprocessor machines.

[⬆️ Back to Top](#java-core) 

## What is a "string pool"?
A string pool is a set of rows stored in Heap.

String pooling is possible due to the immutability of strings in Java and the implementation of the idea of string internment;
String pooling helps save memory, but for the same reason, it takes longer to create a string;
When you use to create a row, then first you look for a row in the pool with the same value, if it is found, then just return a reference, otherwise a new row in the pool is created, and then a reference to it is returned;"
When you use the operator, a new object is created. You can then use the method to pool that row, or you can get a reference from the pool to another object with the same value;newStringintern()String
A string pool is an example of a Flyweight pattern.
[⬆️ Back to Top](#java-core) 

## What the? Why is it needed?finalize()
Calling the JVM method implements functionality similar to that of the C++ destructors used to clean up memory before returning to the operating system. This method is called when an object is destroyed by the garbage collector, and by overriding it is possible to program the actions necessary to correctly delete an instance of the class - for example, closing network connections, database connections, releasing locks on files, etc.finalize()finalize()

After this method is executed, the object must be recollected by the garbage collector (and this is considered a serious problem with the method because it prevents the garbage collector from freeing memory). Calling this method is not guaranteed because the application may be terminated before garbage collection is triggered.finalize()

The object will not necessarily be available for assembly right away - the method can save a reference to the object somewhere. Such a situation is called the "rebirth" of the object and is considered an anti-pattern. The main problem with this trick is that you can "revive" the object only 1 time.finalize()

[⬆️ Back to Top](#java-core) 

## What happens to the garbage collector if the method takes a significant amount of time to execute, or if an exception is thrown during execution?finalize()
The call itself takes place in a separate thread called Finalizer(), which is created when the virtual machine is started (in a static partition when the class is loaded). Methods are called sequentially in the order in which they were added to the list by the garbage collector. Accordingly, if one hangs, it will hang the Finalizer thread, but not the garbage collector. This means, in particular, that objects that do not have a method will be properly deleted, but objects that do will be added to the queue until the Finalizer thread is freed, the application is terminated, or memory runs out.finalize()java.lang.ref.Finalizer.FinalizerThreadFinalizerfinalize()finalize()finalize()

The same applies to in-process thrown exceptions: the Finalizer method on the thread ignores all exceptions thrown at runtime. Therefore, the occurrence of an exception will not affect the health of the garbage collector in any way.finalize()runFinalizer()finalize()

[⬆️ Back to Top](#java-core) 

## What is the difference between , and ?finalfinallyfinalize()
Modifier:final

A class cannot have heirs;
A method cannot be overridden in descendant classes;
A field cannot change its value after initialization;
Local variables cannot be changed once they have been assigned a value;
Method parameters cannot change their value within a method.
The operator guarantees that the code fragment defined in it will be executed regardless of what exceptions were raised and caught in the .finallytry-catch

The method is called before the garbage collector performs the object deletion.finalize()

[⬆️ Back to Top](#java-core) 

## Tell us about type conversion. What is Downgrade and Type Upgrade?
Java is a strongly typed programming language, which means that every expression and every variable has a well-defined type at the time of compilation. However, a casting mechanism has been defined - a way to convert the value of a variable of one type into the value of another type.

In Java, there are several types of casting:

Тождественное (identity). Преобразование выражения любого типа к точно такому же типу всегда допустимо и происходит автоматически.
Widening primitive. It means that there is a transition from a less capacious type to a more capacious one. For example, from type (length 1 byte) to type (length 4 bytes). Such conversions are secure in the sense that the new type is always guaranteed to contain all the data that was stored in the old type, and thus no data loss occurs. This type of cast is always valid and happens automatically.byteint
Narrowing primitive. Means that the transition is made from a more capacious type to a lower capacious type. With this conversion, there is a risk of losing data. For example, if a number of the type was greater than , then when it is converted to bits, the values of bits older than the eighth will be lost. In Java, such a conversion must be done explicitly, and any major bits that do not fit in the new type are simply discarded - no rounding or other actions are performed to obtain a more correct result.int127byte
Widening reference. It means an implicit bottom-up conversion of types or a transition from a more specific type to a less specific one, i.e. a transition from a descendant to an ancestor. It is always allowed and happens automatically.
Narrowing of the object type. It means descending casting, that is, bringing from ancestor to descendant (subtype). Possible only if the source variable is a subtype of the cast type. If there is a type mismatch at run time, an exception is thrown. Requires explicit type specification.ClassCastException
Conversion to String. Any type can be cast to a string, i.e. to an instance of the .String
Forbidden. Not all casts between arbitrary types are allowed. For example, prohibited conversions include casts from any reference type to a primitive type and vice versa (except for a conversion to a string). In addition, it is impossible to bring together classes that are on different branches of the inheritance tree, and so on.
When you cast reference types, nothing happens to the object itself, only the type of reference through which the object is accessed changes.

To check the possibility of casting, you need to use the operator:instanceof

Parent parent = new Child();
if (parent instanceof Child) {
    Child child = (Child) parent;
}
[⬆️ Back to Top](#java-core) 

When can an exception be thrown in an application?ClassCastException
ClassCastException (descendant) - an exception that will be thrown on a type conversion error.RuntimeException

[⬆️ Back to Top](#java-core) 

## What is autoboxing in Java and what are the rules for wrapping primitive types into wrapper classes?
Autopackaging is a mechanism for implicitly initializing objects of wrapper classes (, , , , , ) with the values of their corresponding original primitive types (, , ...), without explicitly using the class constructor.ByteShortIntegerLongFloatDoubleCharacterBooleanbyteshortint

Autopackaging occurs when you directly assign a primitive to a wrapper class (using the operator ), or when you pass a primitive to method parameters (the type of the wrapper class).=

Both variables of primitive types and compile-time constants (literals and -primitives) can be autopackaged into wrapper classes. At the same time, literals must be syntactically correct for initializing a variable of the original primitive type.final

Autopacking variable primitive types requires an exact match between the source primitive type and the wrapper class type. For example, trying to pack a variable of type to , without first explicitly casting it to will cause a compilation error.byteShortbyteshort

Autopackaging of primitive type constants allows for wider boundaries of matching. In this case, the compiler is able to implicitly expand/contract the type of primitives beforehand:

implicitly expanding/narrowing the original primitive type to the primitive type corresponding to the wrapper class (to convert to , the compiler first implicitly narrows to intByteintbyte)
Autopackage the primitive into the appropriate wrapper class. However, in this case, there are two additional restrictions: a) Assigning a primitive to a wrapper can only be done by an operator (you cannot pass such a primitive to method parameters without explicit casting) b) the type of the left operand must not be older than , the type of the right operand must not be older than: it is permissible to expand/contract in/from , to /from , to and only to contract from , from , from . All other options require explicit type conversion).=Characterintbyteshortbytecharshortcharbyteintshortintcharint
An additional feature of integer wrapper classes created by autopackaging constants in the range is that they are cached by the JVM. Therefore, such wrappers with the same values will be references to the same object.-128 ... +127

[⬆️ Back to Top](#java-core) 

## What are the features of the class?String
It is an immutable and finalized data type;
The JVM stores all objects in a row pool;String
A class object can be retrieved using double quotes;String
You can use the operator to concatenation strings;+
Starting with Java 7, strings can be used in the .switch
[⬆️ Back to Top](#java-core) 

## Why an immutable and finalized class?String
There are several advantages to string immutability:

String pooling is only possible because the string is immutable, so the VM saves more free space in Heap because different string variables point to the same variable in the pool. If the string were mutable, then interning the strings would not be possible, because changing the value of one variable would also affect the other variables referencing that string.
If the string is mutable, then it will become a serious threat to the security of the application. For example, the database user name and password are passed as a string to obtain a connection to the database, and in socket programming, the host and port details are passed as a string. Because the string is immutable, its value cannot be changed, otherwise an attacker could change the value of the reference and cause security issues for the application.
Immutability avoids synchronization: strings are thread-safe and a single string instance can be shared by different threads.
Strings are used by classloader, and immutability ensures that the class is loaded correctly.
Because the string is immutable, it is cached at the time of creation and there is no need to recalculate it. This makes the string a great candidate for the key, as it is faster to process.hashCode()HashMap
[⬆️ Back to Top](#java-core) 

## Why is it preferable to store a password?char[]String
From the moment of creation, the row remains in the pool until it is garbage collected. Therefore, even after the end of using the password, it continues to remain available in memory for some time and there is no way to avoid it. This poses a security risk, as anyone with access to the memory will be able to find the password in text. If you are using an array of characters to store a password, you can clear it as soon as you are done with the password, avoiding the security risk inherent in the string.

[⬆️ Back to Top](#java-core) 

## Why is a string a popular key in Java?HashMap
Because strings are immutable, their hash code is calculated and cached at the time of creation, without requiring recalculation in future use. Therefore, as a key, they will be processed faster.HashMap

[⬆️ Back to Top](#java-core) 

## What does the method do in the classroom?.intern()String
The method is used to store a row in a row pool or to retrieve a reference if such a row is already in the row.intern()

[⬆️ Back to Top](#java-core) 

## Is it possible to use strings in the construction?switch
Yes, starting with Java 7, strings can be used in the statement, earlier versions of Java do not support this. Herewith:switch

the strings involved are case-sensitive;
A method is used to compare the obtained value with the values, so to avoid it, it is worth considering checking on .equals()caseNullPointerExceptionnull
According to the Java 7 documentation for strings in , the Java compiler generates more efficient bytecode for strings in the construct than for concatenated - conditions.switchswitchifelse
[⬆️ Back to Top](#java-core) 

## What is the main difference between , , ?StringStringBufferStringBuilder
A class is immutable—you can't modify an object of such a class, you can only replace it with the creation of a new instance.String

The class is mutable - you should use it when you need to modify the content frequently.StringBufferStringBuffer

The class was added in Java 5 and is identical to the class in every way, except that it is out of sync and therefore its methods are much faster.StringBuilderStringBuffer

[⬆️ Back to Top](#java-core) 

## What is a class? What methods does it have?Object
Object it is the base class for all other objects in Java. Any class inherits from and accordingly inherits its methods:Object

public boolean equals(Object obj) – serves to compare objects by meaning; – returns the hash code for the object; —Returns a string representation of the feature. - Returns the feature class at runtime. - Creates and returns a copy of the object. - resumes the thread waiting for the monitor; - resumes all threads waiting for the monitor; - Stopping the thread that called the method until another thread calls the method or for this object. - Stopping the thread that called the method for a certain amount of time or until another thread calls the method or for that object. - Stopping the thread that called the method for a certain amount of time or until another thread calls the method or for that object. - Can be called by the garbage collector when an object is garbage collected.int hashCode()String toString()Class getClass()protected Object clone()void notify()void notifyAll()void wait()notify()notifyAll()void wait(long timeout)notify()notifyAll()void wait(long timeout, int nanos)notify()notifyAll()protected void finalize()

[⬆️ Back to Top](#java-core) 

## Define the concept of "constructor".
A constructor is a special method that does not have a return type and has the same name as the class in which it is used. The constructor is called when a new class object is created and defines the steps required to initialize it.

[⬆️ Back to Top](#java-core) 

## What is the "default constructor"?
If a class does not have a constructor defined, the compiler will generate a constructor without arguments, the so-called "default constructor".

public class ClassName() {}
If a class already has a constructor defined, the default constructor will not be created, and if it is needed, it must be explicitly described.

[⬆️ Back to Top](#java-core) 

## What is the difference between the default constructor, the copy constructor, and the parameter constructor?
The default constructor is missing any arguments. The copy constructor takes a pre-existing class object as an argument to create a clone of it. A parameter constructor has arguments in its signature (usually needed to initialize class fields).

[⬆️ Back to Top](#java-core) 

## Where and how can you use a private builder?
A private (keyword, hidden) constructor can be used by a public static method of generating objects of a given class. It is also allowed to be accessed by nested classes and can be used for their needs.private

[⬆️ Back to Top](#java-core) 

## Tell us about loader classes and dynamic class loading.
The basis of working with classes in Java is loader classes, which are regular Java objects that provide an interface for finding and creating a class object by its name while the application is running.

At the beginning of the program, 3 main class loaders are created:

A base bootloader (bootstrap/primordial). It loads the main system and internal classes of the JDK (Core API - packages ( and ) . It is important to note that the base loader is the "Native" or "Root" and part of the JVM, so it cannot be created inside the program code.java.*rt.jari18n.jar
Extension loader (extention). Loads various extension packages that reside in a directory or other directory described in the system parameter. This allows you to update and add new extensions without having to modify the settings of the apps you use. The extension loader is implemented by the .<JAVA_HOME>/lib/extjava.ext.dirssun.misc.Launcher$ExtClassLoader
system boot loader (system/application). Loads classes whose paths are specified in an environment variable or paths that are specified in the JVM startup command line after the or . The boot loader is implemented by the .CLASSPATH-classpath-cpsun.misc.Launcher$AppClassLoader
Class loaders are hierarchical: each of them (except the base one) has a parent loader and in most cases, before trying to load the class itself, it first sends a request to the parent loader to load the specified class. This delegation allows classes to be loaded with the loader that is closest to the base loader in the delegation hierarchy. As a result, classes will be searched in the sources in order they are trusted: first in the Core API library, then in the extensions folder, then in local .CLASSPATH

The process of loading a class consists of three parts:

Loading – this phase searches for and physically loads a class file in a specific source (depending on the loader). This process defines the basic in-memory representation of the class. At this stage, such concepts as "methods", "fields", etc. are not yet known.
Linking is a process that can be broken down into 3 parts:
Bytecode verification – verifies bytecode against the requirements defined in the JVM specification.
Class preparation—Creating and initializing the necessary structures used to represent the fields, methods, implemented interfaces, etc., defined in the loaded class.
Resolving—Loads the set of classes referenced by the class being loaded.
Initialization – calling static initialization blocks and assigning default values to the class fields.
Dynamic loading of classes in Java has a number of features:

lazy loading and binding of classes. Classes are loaded only when needed, which saves resources and distributes the load.
Checking the correctness of the loaded code (type safeness). All type-control activities are performed only at class load time, avoiding the overhead of code execution.
programmable boot. The user loader has complete control over the process of obtaining the requested class, whether to search for bytecode and create the class or delegate the creation to another loader. Additionally, it is possible to set different security attributes for loadable classes, thus allowing you to work with code from untrusted sources.
Multiple namespaces. Each loader has its own namespace for the classes it creates. Accordingly, the classes loaded by two different bootloaders based on shared bytecode will differ on the system.
There are several ways to trigger the loading of the required class:

explicit: call or (by default, the loader that created the current class is used, but it is also possible to explicitly specify the loader);ClassLoader.loadClass()Class.forName()
Implicit: When an application requires a class that has not been used before, the JVM initiates its loading.
[⬆️ Back to Top](#java-core) 

## What is Reflection?
Reflection is a mechanism for obtaining data about a program at runtime. In Java, Reflection is implemented using the Java Reflection API, which consists of the and .java.langjava.lang.reflect

Java Reflection API features:

Definition of the object class;
Get information about class modifiers, fields, methods, constructors, and superclasses;
Define the interfaces implemented by the class;
Creating an instance of a class;
Obtaining and setting the values of the object fields;
Calling object methods;
Create a new array.
[⬆️ Back to Top](#java-core) 

## Why do you need . How is it different from surgery?equals()==
Method - defines the equivalence relation of objects.equals()

When comparing objects using the references, the comparison occurs only between references. When comparing by overridden by the developer - by the internal state of the objects.==equals()

[⬆️ Back to Top](#java-core) 

## If you want to override what conditions must be met?equals()
What properties does the generated equivalence relation have?equals()
Reflexivity: For any reference to a value, will return xx.equals(x)true;
Symmetry: For any references to values and , should return , if and only if it returns .xyx.equals(y)truey.equals(x)true
Transitivity: for any references to values , and , if and return , then and return xyzx.equals(y)y.equals(z)truex.equals(z)true;
Consistency: For any references to values and , if called multiple times, a value will be returned continuously, or a value will be returned continuously, provided that no information used in the object comparison has changed.хух.equals(y)truefalse
For any non-null value reference, the expression must return .хх.equals(null)false

[⬆️ Back to Top](#java-core) 

## Rules for overriding the .Object.equals()

- Use an operator to check whether an argument is a reference to a specified object. If it is, return `true`. If the object being compared is `null`, return `false`.
  
- Use a statement and a method call to check if the argument is of the correct type. If it is not, return `false`.

- Cast the argument to the correct type. Since this operation follows validation, it is guaranteed to be safe.

- Iterate through all significant fields of the class and check that the value of each field in the current object matches the corresponding field value in the object being compared. If all checks pass, return `true`; otherwise, return `false`.

- At the end of the `equals()` method implementation, verify that the equivalence relation is reflexive, symmetric, transitive, and consistent. If any of these properties do not hold, adjust the method accordingly.

To implement an `equals()` method in Java that follows the best practices, you can use the following steps:

1. **Check if the argument is a reference to the specified object:** Use `==` to check if the object being compared is the same as the current instance. If so, return `true`.

    ```java
    if (this == obj) {
        return true;
    }
    ```

2. **Check if the argument is of the correct type:** Use `instanceof` to verify that the object is an instance of the correct class. If not, return `false`.

    ```java
    if (!(obj instanceof MyClass)) {
        return false;
    }
    ```

3. **Cast the argument to the correct type:** Since the previous check guarantees the type, you can safely cast the argument.

    ```java
    MyClass other = (MyClass) obj;
    ```

4. **Compare all relevant fields:** Iterate through all significant fields of the class, checking if their values are equal in both objects.

    ```java
    return this.field1.equals(other.field1) && this.field2.equals(other.field2);
    ```

5. **Final checks for equivalence properties:** Ensure that the `equals()` method satisfies reflexivity, symmetry, transitivity, and consistency. If not, adjust the implementation as necessary.

Here’s a complete example:

```java
@Override
public boolean equals(Object obj) {
    // Step 1: Check if both references point to the same object
    if (this == obj) {
        return true;
    }
    
    // Step 2: Check if the argument is of the correct type
    if (!(obj instanceof MyClass)) {
        return false;
    }
    
    // Step 3: Cast the argument
    MyClass other = (MyClass) obj;
    
    // Step 4: Compare relevant fields
    return this.field1.equals(other.field1) && this.field2.equals(other.field2;
}
```

By following these steps, your `equals()` method will be robust and conform to Java's standards for equality checking.

[⬆️ Back to Top](#java-core) 

## What is the relationship between hashCode() and equals()?

If overridden, are there any other methods that should be overridden?equals()
Equal objects must return the same hash codes. When overriding, you must also override the .equals()hashCode()

[⬆️ Back to Top](#java-core) 

## What happens if I override without overriding ? What problems can arise?equals()hashCode()
Classes and methods that use the rules of this contract may not work correctly. This can cause the key-value pair that was placed in it when using a new instance of the key not to be found in it.HashMap

[⬆️ Back to Top](#java-core) 

How are the methods implemented in the classroom as well?hashCode()equals()Object
The implementation of the method boils down to checking for the equality of two references:Object.equals()

public boolean equals(Object obj) {
  return (this == obj);
}
The implementation of the method is described as , i.e. defined by non-Java code and usually returns the address of the object in memory:Object.hashCode()native

public native int hashCode();
[⬆️ Back to Top](#java-core) 

## What is the method for?hashCode()
The method is required to compute the hash code passed as an input parameter to an object. In Java, it is an integer, in a broader sense, it is a fixed-length bit string obtained from an array of arbitrary length. This method is implemented in such a way that for the same input object, the hash code will always be the same. It should be understood that in Java, the set of possible hash codes is limited by the type , and the set of objects is unlimited. Because of this, it is quite possible that the hash codes of different objects may match:hashCode()int

if the hash codes are different, then the objects are guaranteed to be different;
If the hash codes are equal, then the objects may not necessarily be equal.
[⬆️ Back to Top](#java-core) 

## What are the rules for overriding a method?Object.hashCode()
Are there any guidelines on which fields should be used when counting?hashCode()
General advice: choose fields that are likely to differ. To do this, you need to use unique, preferably primitive fields, such as , . At the same time, you need to follow the rule, if the fields are involved in the calculation , then they must also be involved in the execution of .iduuidhashCode()equals()

[⬆️ Back to Top](#java-core) 

## Can different objects have the same ?hashCode()
Yes, they can. The method does not guarantee the uniqueness of the return value. A situation where different objects have the same hash codes is called a collision. The probability of a collision depends on the hash code generation algorithm used.hashCode()

[⬆️ Back to Top](#java-core) 

## If a class implements the method , but makes the hash code in the form , then will such points be correctly placed and retrieved from ?

Point{int x, y;}equals(Object that) {(return this.x == that.x && this.y == that.y)}int hashCode() {return x;}
HashSet
HashSet uses to store items. When you add an element to it, a hash code is calculated, which determines the position in the array where the new element will be inserted. All instances of the class will have the same hash code for all objects with the same , which will cause the hash of the table to degenerate into a list.HashMapHashMapPointx

In the event of a collision in the list, it is checked for the presence of an element in the list: . If an item is found, its value is overwritten. In our case, for different objects, the method will return . Accordingly, the new element will be successfully added to . The item will also be checked out successfully. However, the performance of such code will be low, and the benefits of table hashes will not be used.HashMape.hash == hash && ((k = e.key) == key || key.equals(k))equals()falseHashSet

[⬆️ Back to Top](#java-core) 

## Can different objects have ?(ref0 != ref1)ref0.equals(ref1) == true
Yes, they can. To do this, the .equals()

If the method is used, then for two references and the method will return if and only if both references point to the same object (i.e. returns).Object.equals()xytruex == ytrue

[⬆️ Back to Top](#java-core) 

## Can different references to the same object have ?(ref0 == ref1)ref0.equals(ref1) == false
In general, they can, if the method is implemented incorrectly and does not fulfill the reflexivity property: for any non-null references, the method must return .equals()xx.equals(x)true

[⬆️ Back to Top](#java-core) 

Is it possible to implement the method in this way?equals(Object that) {return this.hashCode() == that.hashCode()}
Strictly speaking, it is impossible, since the method does not guarantee the uniqueness of the value for each object. However, for comparing instances of a class, such code is acceptable, since the method in the class returns unique values for different objects (its calculation is based on the use of the object's address in memory).hashCode()ObjecthashCode()Object

[⬆️ Back to Top](#java-core) 

## B requires that the argument is of the same type as the object itself. What is the difference between and ?equals()equals(Object that)this.getClass() == that.getClass()that instanceof MyClass
The operator compares the object and the specified type. It can be used to check whether a given object is an instance of a class, or an instance of a child class, or an instance of a class that implements a specified interface.instanceof

this.getClass() == that.getClass() checks two classes for identity, so for the correct implementation of the method contract, you must use an exact comparison using the .equals()getClass()

[⬆️ Back to Top](#java-core) 

## Is it possible to implement a class method like this: ?equals()MyClassclass MyClass {public boolean equals(MyClass that) {return this == that;}}
You can implement it, but this method does not override the class method, but overloads it.equals()Object

[⬆️ Back to Top](#java-core) 

## There is a class. Why is a hash code in the form preferable to ?Point{int x, y;}31 * x + yx + y
The multiplier creates a dependence of the hash code value on the order of processing the fields, which ultimately generates a better hash function.

[⬆️ Back to Top](#java-core) 

## Tell us about cloning objects.
Using the assignment operator does not create a new object, but only copies the reference to the object. Thus, two references point to the same area of memory, to the same object. Object cloning is used to create a new object with the same state.

A class contains a method that performs a bitwise copy of an object in a derived class. However, you must first override the method as to be able to call it. In the overridden method, you should call the base version of the method that performs the actual cloning.Objectprotectedclone()clone()publicsuper.clone()

To finally make an object cloneable, the class must implement the . The interface does not contain methods, it is a tokenized interface, and its implementation ensures that the class method returns an exact copy of the object that called it, reproducing the values of all its fields. Otherwise, the method throws an exception. Note that when using this mechanism, the object is created without calling the constructor.CloneableCloneableclone()ObjectCloneNotSupportedException

This solution is effective only if the fields of the cloned object are values of base types and their wrappers or immutable object types. If the field of the cloned type is a mutable reference type, then a different approach is required for correct cloning. The reason is that when you create a copy of a field, the original and the copy are a reference to the same object. In this situation, you should also clone the class field object itself.

Such cloning is possible only if the class attribute type also implements the interface and overrides the . Because if it is otherwise, the method cannot be called because it is unavailable. It follows that if a class has a superclass, then in order to implement the mechanism for cloning the current descendant class, it is necessary to have a correct implementation of such a mechanism in the superclass. At the same time, you should not use declarations for fields of object types due to the impossibility of changing their values when implementing cloning.Cloneableclone()final

In addition to the built-in cloning mechanism in Java, you can use the following to clone an object:

Specialized copy constructor—A class describes a constructor that takes an object of the same class and initializes the fields of the created object with the field values of the passed object.
Factory method, which is a static method that returns an instance of its class.
Serialization mechanism - saving and subsequent restoration of an object to/from a byte stream.
[⬆️ Back to Top](#java-core) 

## What is the difference between surface and deep cloning?
Shallow copying copies as little information about an object as possible. By default, cloning in Java is superficial, i.e. the class is unaware of the structure of the class it is copying. This type of cloning is performed by the JVM according to the following rules:Object

If a class has only members of primitive types, then a completely new copy of the object will be created and a reference to that object will be returned.
If a class contains members of reference types in addition to members of primitive types, then references to objects of those classes are copied. Therefore, both objects will have the same references.
Deep copying duplicates absolutely all the information of the object:

There is no need to copy primitive data separately;
All members of a reference type in the original class must support cloning. For each such member, when an override of a method, the clone()super.clone();
If a class member does not support cloning, the clone method must create a new instance of that class and copy each class member with all its attributes to a new class object, one at a time.
[⬆️ Back to Top](#java-core) 

## Which cloning method is preferable?
The safest, and therefore preferred, method of cloning is to use a specialized copy constructor:

No inheritance errors (no need to worry that heirs will have new fields that will not be cloned via the clone());
The fields to be cloned are specified explicitly;
Ability to clone even fields.final
[⬆️ Back to Top](#java-core) 

Why is the method declared in the class and not in the interface?clone()ObjectCloneable
The method is declared in a class with a modifier specified to provide access to the standard mechanism for surface copying of objects. At the same time, it is also declared as , so that you cannot call this method on objects that do not override it. The interface itself is token (does not contain method declarations) and is only needed to indicate the very fact that this object is ready to be cloned. Calling an overridden method on a non-object will cause a .clone()ObjectnativeprotectedCloneableclone()CloneableCloneNotSupportedException

[⬆️ Back to Top](#java-core) 

## Describe the hierarchy of exceptions.
Exceptions are divided into several classes, but they all have a common ancestor, the class , whose descendants are the classes and .ThrowableExceptionError

Errors are more serious problems that, according to the Java specification, should not be handled in your own program, as they are related to JVM-level problems. For example, exceptions of this kind occur when the memory available to the virtual machine runs out.

Exceptions are the result of problems in a program that are in principle solvable, predictable, and can be eliminated within the program. For example, an integer has been divided by zero.

[⬆️ Back to Top](#java-core) 

## What types of exceptions do you know in Java, how do they differ? What is a checked and unchecked exception?
In Java, all exceptions are divided into two types:

checked exceptions must be handled as a block or described in a method signature (e.g. ). The presence of such a signature handler/modifier is checked at the time of compilation;catchIOException
unchecked, which include errors (e.g., ) that are not recommended to handle, and run-time exceptions represented by the class and its descendants (e.g., ), which may not be handled by the block and may not be described in the method signature.ErrorOutOfMemoryErrorRuntimeExceptionNullPointerExceptioncatch
[⬆️ Back to Top](#java-core) 

## Which operator allows you to force an exception to be thrown?
This is the operator:throw

throw new Exception();
[⬆️ Back to Top](#java-core) 

## What does the keyword say?throws
The modifier is written into the method signature and indicates that the method can potentially throw an exception with the specified type.throws

[⬆️ Back to Top](#java-core) 

## How do you write your own ("user") exception?
You must inherit from the base class of the required exception type (for example, from or ).ExceptionRuntimeException

class CustomException extends Exception {
    public CustomException() {
        super();
    }

    public CustomException(final String string) {
        super(string + " is invalid");
    }

    public CustomException(final Throwable cause) {
        super(cause);
    }
}
[⬆️ Back to Top](#java-core) 

## What are the unchecked exceptions?
The most common are: , , , , , , , , , .ArithmeticExceptionClassCastExceptionConcurrentModificationExceptionIllegalArgumentExceptionIllegalStateExceptionIndexOutOfBoundsExceptionNoSuchElementExceptionNullPointerExceptionUnsupportedOperationException

[⬆️ Back to Top](#java-core) 

## What are class errors?Error
Class errors are the most serious problems at the JVM level. For example, exceptions of this kind occur when the memory available to the virtual machine runs out. It is not forbidden to handle such errors, but it is not recommended to do so.Error

[⬆️ Back to Top](#java-core) 

What do you know about ?OutOfMemoryError
OutOfMemoryError is discarded when the Java virtual machine cannot create (place) an object due to lack of memory, and the garbage collector cannot free enough memory.

The memory area occupied by a java process consists of several parts. The type depends on which of them did not have enough space:OutOfMemoryError

java.lang.OutOfMemoryError: Java heap space: There is not enough space in the heap, namely in the area of memory in which objects created in the application programmatically are placed. Usually, the problem lies in a memory leak. The size is specified by the and parameters.-Xms-Xmx
java.lang.OutOfMemoryError: PermGen space: (prior to Java 8) This error occurs when there is not enough space in the Permanent region, the size of which is specified by the and .-XX:PermSize-XX:MaxPermSize
java.lang.OutOfMemoryError: GC overhead limit exceeded: This error can occur when both the first and second regions are full. It is due to the fact that there is not much memory left and the garbage collector is constantly working, trying to free up some space. This error can be disabled by using the .-XX:-UseGCOverheadLimit
java.lang.OutOfMemoryError: unable to create new native thread: Discarded when no new threads can be created.
[⬆️ Back to Top](#java-core) 

## Describe how the try-catch-finally block works.
try - This keyword is used to mark the beginning of a block of code that could potentially lead to an error. is a keyword to mark the beginning of a block of code designed to catch and handle exceptions when they occur. is a keyword to mark the beginning of a block of code that is optional. This block is placed after the last block. Control is passed to the block in any case, whether the exception was thrown or not.catchfinallycatchfinally

The general view of the exception handling structure is as follows:

try { 
    //код, который потенциально может привести к исключительной ситуации 
} 
catch(SomeException e ) { //в скобках указывается класс конкретной ожидаемой ошибки  
    //код обработки исключительной ситуации
} 
finally {
    //необязательный блок, код которого выполняется в любом случае
}
[⬆️ Back to Top](#java-core) 

## What is the try-with-resources mechanism?
This construct, which was introduced in Java 7, allows you to use the try-catch block without worrying about closing the resources used in this segment of code. Resources are declared in parentheses immediately after , and the compiler itself implicitly creates a partition in which the resources used in the block are released. Resources refer to entities that implement the .tryfinallyjava.lang.Autocloseable

General view of the structure:

try(/*объявление ресурсов*/) {
    //...
} catch(Exception ex) {
    //...
} finally {
    //...
}
It is worth noting that blocks and explicit are executed after the resources in the implicit .catchfinallyfinally

[⬆️ Back to Top](#java-core) 

## Is it possible to use the try-finally block (without)?catch
Such a record is acceptable, but there is not much point in such a record, it is still better to have a block in which the necessary exception will be handled.catch

[⬆️ Back to Top](#java-core) 

## Can a single block catch multiple exceptions at once?catch
In Java 7, a new language construct is available that allows you to catch multiple exceptions in a single block:catch

try {  
    //...
} catch(IOException | SQLException ex) {
    //...
}
[⬆️ Back to Top](#java-core) 

Is the block always executed?finally
The code in the block will always be executed, regardless of whether the exception is thrown or not.finally

[⬆️ Back to Top](#java-core) 

## Are there situations where a block will not be executed?finally
For example, when the JVM "dies" - in such a situation is unreachable and will not be executed, since there is a forced system exit from the program:finally

try { 
    System.exit(0); 
} catch(Exception e) { 
    e.printStackTrace(); 
} finally { }
[⬆️ Back to Top](#java-core) 

## Can the main() method throw an exception outside and, if so, where will the exception be handled?
It may also be uploaded to the Java Virtual Machine (JVM).

[⬆️ Back to Top](#java-core) 

## Suppose there is a method that can throw and in what sequence should the blocks go? How many blocks will be completed?IOExceptionFileNotFoundExceptioncatchcatch
As a general rule, you need to handle exceptions from "junior" to senior. That is, it cannot be put in the first block, otherwise all further blocks will not be able to process anything, because any exception will correspond to the handler.catch(Exception ex) {}catch()catch(Exception ex)

Thus, based on the fact that first you need to process , and then :FileNotFoundException extends IOExceptionFileNotFoundExceptionIOException

void method() {
    try {
        //...
    } catch (FileNotFoundException ex) {
        //...
    } catch (IOException ex) {
        //...
    }
}
[⬆️ Back to Top](#java-core) 

## What are generics?
Generics is a technical term that refers to a set of language properties that allow generic types and methods to be defined and used. Generalized types or methods differ from conventional ones in that they have typed parameters.

An example of using generic types is the Java Collection Framework. Thus, a class is a typical generalized type. It contains a parameter that represents the type of items that will be stored in the collection. Generic type objects are created by replacing parameterized types with real data types. Instead of just using , saying nothing about the type of item in the list, it is suggested to use an exact type indication, and so on.LinkedList<E>ELinkedListLinkedList<String>LinkedList<Integer>

[⬆️ Back to Top](#java-core) 

## What is "internationalization" and "localization"?
Internationalization is a way of creating applications in which they can be easily adapted for different audiences speaking different languages.

Localization is the adaptation of the application interface to several languages. Adding a new language can introduce certain difficulties in the localization of the interface.

[⬆️ Back to Top](#java-core) 

Interview Questions
