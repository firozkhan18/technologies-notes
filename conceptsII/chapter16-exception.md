# Exception

In Java, an exception is a mechanism to signal that the
execution of a method can not be performed
by example, trying to get a value of a list with an index equals to -1
```java
String valueAt(List<String> list, int index) {
  return list.get(index);
}
valueAt(List.of("hello"), -1);
```

an exception has
- a type that indicate the kind of error
- an error message that explain in English the issue
- a stacktrace which indicates where the exception was raised
  and the methods to reach that point

In our example, `java.lang.IndexOutOfBoundsException` is the type,
`Index: -1 Size: 1` is the message and
```
at ImmutableCollections$AbstractImmutableList.outOfBounds (ImmutableCollections.java:201)
at ImmutableCollections$List12.get (ImmutableCollections.java:418)
at valueAt (#1:2)
at (#2:1)
```
is the stacktrace


## `throw`
You can create (with `new`) and raise your own exception using the keyword `throw`
```java
String valueAt(List<String> list, int index) {
  if (index < 0 || index >= list.size()) {
    throw new IllegalArgumentException("invalid index " + index);
  }
  return list.get(index);
}
valueAt(List.of("hello"), -1);
```

The stacktrace is populated automatically when you create the exception
not where you throw it so it's a good idea to create the exception
not too far from where you throw it.
In the following example, the stacktrace will say that the exception
is created at `notTooFar (#5:2)`, on the second line, not at `notTooFar (#5:4)`.
```java
void notTooFar() {
  var exception = new RuntimeException("i'm created here");
  // an empty line
  throw exception;
}
notTooFar();
```


## Use existing exceptions
While you can create your own exception (see below),
usually we are re-using already existing exceptions.

Exceptions commonly used in Java
- NullPointerException if a reference is null
- IllegalArgumentException if an argument of a method is not valid
- IllegalStateException if the object state doesn't allow to proceed,
  by example if a file is closed, you can not read it
- AssertionError if a code that should not be reached has been reached

By example
```java
enum State { OK, NOT_OK }
void testState(State state) {
  switch(state) {
    case OK -> System.out.println("Cool !");
    case NOT_OK -> System.out.println("Not cool");
    default -> { throw new AssertionError("Danger, Will Robinson"); }
  }
}
```
here the AssertionError can only be thrown if the code if testState()
and the enum State disagree on set of possible values
By example, if a new state is added
```java
enum State { OK, NOT_OK, UNKNOWN }
testState(State.UNKNOWN);
```


## Recovering from an exception
In Java, you can recover from an exception using a `try/catch` block.
```java
URI uri;
try {
  uri = new URI("http://i'm a malformed uri");
} catch(URISyntaxException e) {
  // if the URI is malformed, used google by default
  uri = new URI("http://www.google.fr");
}
System.out.println(uri);
```

A common mistake is to write a `try/catch` in a method with an empty catch
or a catch that log/print a message instead of actually recovering from the
exception

As a rule of thumb, if you can not write something meaningful in the catch
block then you should not use a `try/catch`.


## Fighting with the compiler
For the compiler, there are two kinds of exceptions that are handled differently
- unchecked exception, you can throw them anywhere you want
- checked exception, you can only throw them if
  - you are inside a method that declare to throws that exception (or a supertype)
  - you are inside a try/catch block on that exception (or a supertype)

In Java, an exception that inherits from `RuntimeException` or `Error` are
unchecked exceptions, all the others are checked exceptions 

so this code doesn't compile because `IOException` inherits from `Exception`
and not `RuntimeException`. 
```java
/*
void hello() {
  Files.delete(Path.of("I don't exist"));
}
*/
```

A way to fix the issue is to use the keywords `throws` to ask the caller
of the method to deal with the exception, again the caller will have,
either by propagating it with a `throws` or recover from it with a `try/catch`.
```java
void hello() throws IOException {
  Files.delete(Path.of("I don't exist"));
}
```

As a rule of thumb, 99% of the time you want to propagate the exception,
and keep the number of `try/catch` as low as possible in your program,
so prefer `throws` to `try/catch`.


### When you can not use `throws`, wrap the exception

If a method has it's signature fixed because it overrides a method of an interface,
then you can not use `throws`

The following example doesn't compile because the method `run` of a `Runnable`
doesn't declare to `throws` `IOException` so the only solution seems to be
to use a `try/catch`.
```java
/*
var aRunnable = new Runnable() {
  public void run() {
    Files.delete(Path.of("I don't exist"));
  }
};
*/
```

So here, we have to use a `try/catch` but we still want to propagate the exception.
The trick is wrap the checked exception into an unchecked exception.
This trick is so common that the Java API already comes with existing
classes to wrap common checked exceptions. For `IOException`, the unchecked
equivalent is `UncheckedIOException`. 

```java
var aRunnable = new Runnable() {
  public void run() {
    try {
      Files.delete(Path.of("I don't exist"));
    } catch(IOException e) {
      // the way to recover, is to propagate it as an unchecked
      throw new UncheckedIOException(e);
    }
  }
};
aRunnable.run();
```

The exception `UndeclaredThrowableException` is used as the generic unchecked exception
to wrap any checked exception which do not have an unchecked equivalent.


## Create your own Exception

You can create your own exception by creating a class that inherits from `RuntimeException`
You should provide at least two constructors, one with a message and one with a message
and a cause.

```java
public class MyException extends RuntimeException {
  public MyException(String message) {
    super(message);
  }
  public MyException(String message, Throwable cause) {
    super(message, cause);
  }
}
throw new MyException("This is my exception");
```

But in general, don't ! Reuse existing commonly used exceptions.

# Java Exception Handling Concepts

Java exception handling is a powerful mechanism that helps manage errors and exceptional conditions in your programs. Below is a comprehensive overview of key concepts in Java exception handling.

# Table of Contents

  - [1. Basic try-catch-finally](#1-basic-try-catch-finally)
  - [2. Try With Resources](#2-try-with-resources)
  - [3. Catching Multiple Exceptions](#3-catching-multiple-exceptions)
  - [4. Exception Hierarchies](#4-exception-hierarchies)
  - [5. Checked or Unchecked Exceptions?](#5-checked-or-unchecked-exceptions)
  - [6. Exception Wrapping](#6-exception-wrapping)
  - [7. Fail Safe Exception Handling](#7-fail-safe-exception-handling)
  - [8. Pluggable Exception Handlers](#8-pluggable-exception-handlers)
  - [9. Where to Log Exceptions?](#9-where-to-log-exceptions)
  - [10. Validation: Throw Exceptions Early](#10-validation-throw-exceptions-early)
  - [11. Validation: Throw Exception or Return False](#11-validation-throw-exception-or-return-false)
  - [12. Exception Handling Templates](#12-exception-handling-templates)
  - [13. Exception Enrichment](#13-exception-enrichment)
  - [14. Execution Context](#14-execution-context)

## 1. Basic try-catch-finally
The `try-catch-finally` block is the foundation of Java's exception handling mechanism. It allows you to write code that can handle exceptions gracefully.

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Handle the exception
} finally {
    // Code that will run regardless of an exception
}
```

- **try**: The block of code that might throw an exception.
- **catch**: The block that handles the exception.
- **finally**: The block that executes after the try and catch blocks, used for cleanup.

## 2. Try With Resources
The `try-with-resources` statement is used for automatic resource management. It ensures that each resource is closed at the end of the statement.

```java
try (ResourceType resource = new ResourceType()) {
    // Use the resource
} catch (ExceptionType e) {
    // Handle exception
}
```

This feature simplifies code and reduces the chances of resource leaks.

## 3. Catching Multiple Exceptions
You can catch multiple exceptions in a single catch block, simplifying your code and reducing redundancy.

```java
try {
    // Code that may throw exceptions
} catch (IOException | SQLException e) {
    // Handle both IOException and SQLException
}
```

## 4. Exception Hierarchies
Java exceptions are organized in a hierarchy, with `Throwable` as the superclass. It has two main subclasses:
- **Error**: Represents serious issues that applications should not catch.
- **Exception**: Represents conditions that applications might want to catch.

Understanding the hierarchy helps in effective exception handling.

## 5. Checked or Unchecked Exceptions?
Exceptions in Java are classified into two types:
- **Checked Exceptions**: Must be declared in a method's `throws` clause or handled within the method. Examples include `IOException`, `SQLException`.
- **Unchecked Exceptions**: Do not need to be declared or caught. These include `RuntimeException` and its subclasses (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`).

## 6. Exception Wrapping
Exception wrapping involves catching an exception and throwing a new one, typically to add more context or to abstract the original exception.

```java
try {
    // Code that may throw an exception
} catch (IOException e) {
    throw new CustomException("Error occurred", e);
}
```

This technique helps in maintaining the stack trace of the original exception.

## 7. Fail Safe Exception Handling
Fail-safe exception handling ensures that the program can recover or exit gracefully when an exception occurs. It involves implementing strategies to handle exceptions without crashing the application.

## 8. Pluggable Exception Handlers
Pluggable exception handlers allow you to define custom behavior for specific exceptions at runtime. You can create and configure handlers that respond differently based on the context.

## 9. Where to Log Exceptions?
Logging exceptions is crucial for diagnosing problems. You can log exceptions in various places:
- **Catch blocks**: Log the exception immediately when caught.
- **Finally blocks**: Log cleanup failures.
- **Centralized logging framework**: Use libraries like Log4j or SLF4J for consistent logging across the application.

## 10. Validation: Throw Exceptions Early
Throwing exceptions early allows you to catch errors in their initial stages, preventing them from propagating further. This practice enhances code robustness and clarity.

```java
if (input == null) {
    throw new IllegalArgumentException("Input cannot be null");
}
```

## 11. Validation: Throw Exception or Return False
This approach involves deciding whether to throw an exception or return a false value when validation fails. It depends on the context:
- Use exceptions for critical errors.
- Return false for recoverable or non-critical conditions.

## 12. Exception Handling Templates
Using exception handling templates can standardize how exceptions are handled across your application. This can include:
- Logging formats
- Standard messages
- Response strategies

## 13. Exception Enrichment
Exception enrichment involves adding additional information to exceptions, such as context or specific error codes, before throwing them. This additional information can help in debugging and error tracking.

```java
catch (SQLException e) {
    throw new CustomException("Database operation failed: " + e.getMessage(), e);
}
```

## 14. Execution Context
The execution context can impact how exceptions are handled. For example, exceptions in asynchronous code or background threads may need special handling strategies, such as using callback methods or futures.

---
