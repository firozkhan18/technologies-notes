# Immutable Classes in Java

In Java, an immutable object is one whose state can not be changed once created. Immutable objects are persistent views of their data without a direct option to change it. To change the state, we must create a new copy of such an object with the intended changes. 

In this post, we will learn immutability in detail, creating an immutable object and its advantages.

### 1. What is Immutability?
Immutability is a characteristic of Java objects that makes them immutable to future changes once they have been initialized. Its internal state cannot be changed in any way.

Take the example of java.lang.String class which is an immutable class. Once a String is created, there is no way we can change the content of that String. Every public API in String class returns a new String with the modified content. The original String always remains the same.
```java
String string = "test";
String newString = string.toLowerCase();  //Creates a new String
```
### 2. Immutability in Collections
Similarly, for Collections, Java provides a certain degree of immutability with three options:
```java
Unmodifiable collections
Immutable collection factory methods (Java 9+)
Immutable copies (Java 10+)
Collections.unmodifiableList(recordList);  //Unmodifiable list

List.of(new Record(1, "test"));  //Factory methods in Java 9

List.copyOf(recordList);  //Java 10
```
Note that such collections are only shallowly immutable, meaning that we can not add or remove any elements, but the collection elements themselves aren’t guaranteed to be immutable. If we hold the reference of a collection element, then we can change the element’s state without affecting the collection.

In the following example, we cannot add or remove the list items, but we can change the state of an existing item in the list.
```java
List<Record> list = List.of(new Record(1, "value"));
System.out.println(list);   //[Record(id=1, name=value)]

//list.add(new Record()); //UnsupportedOperationException

list.get(0).setName("modified-value");
System.out.println(list); //[Record(id=1, name=modified-value)]

@Data
@NoArgsConstructor
@AllArgsConstructor
class Record {
  long id;
  String name;
}
```
To ensure complete immutability, we must make sure that we only add immutable instances in the collections. This way, even if somebody gets a reference to an item in the collection, it cannot change anything.

### 3. How to Create an Immutable Class?
Java documentation itself has some guidelines identified to write immutable classes in this link. We will understand what these guidelines actually mean.

Do not provide setter methods. Setter methods are meant to change an object’s state, which we want to prevent here.
Make all fields final and private. Fields declared private will not be accessible outside the class, and making them final will ensure that we can not change them even accidentally.
Do not allow subclasses to override methods. The easiest way is to declare the class as final. Final classes in Java can not be extended.
Special attention to “immutable classes with mutable fields“. Always remember that member fields will be either mutable or immutable. Values of immutable members (primitives, wrapper classes, String etc) can be returned safely from the getter methods. For mutable members (POJO, collections etc), we must copy the content into a new Object before returning from the getter method.
Let us apply all the above rules to create an immutable custom class. Notice that we are returning a new copy of ArrayList from the getTokens() method. By doing so, we are hiding the original tokens list so no one can even get a reference of it and change it.
```java
final class Record {

  private final long id;
  private final String name;
  private final List<String> tokens;

  public Record(long id, String name, List<String> tokens) {
    this.id = id;
    this.name = name;
    this.tokens = tokens;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<String> getTokens() {
    return new ArrayList<>(tokens);
  }

  @Override
  public String toString() {
    return "Record{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", tokens=" + tokens +
        '}';
  }
}
```
Now it’s time to test our class. We tried to add a new item to the tokens list, but the original record and its list remain unchanged.
```java
ArrayList<String> tokens = new ArrayList<>();
tokens.add("active");

Record record = new Record(1, "value", tokens);
System.out.println(record);   //Record{id=1, name='value', tokens=[active]}

record.getTokens().add("new token"); 
System.out.println(record);   //Record{id=1, name='value', tokens=[active]}
```
### 4. Immutability with Java Records
Java records help reduce the boilerplate code by generating the constructors and getters at compile time. They can also help create immutable classes with very few lines of code.

For example, we can rewrite the above Record class as follows. Note that records generate the standard getters, so if we want to return a new copy of a mutable reference, we must override the corresponding method.
```java
record Record(long id, String name, List<String> tokens){

  public List<String> tokens() {
    return new ArrayList<>(tokens);
  }
}
```
Now let us test the immutability again.
```java
ArrayList<String> tokens = new ArrayList<>();
tokens.add("active");

Record record = new Record(1, "value", tokens);
System.out.println(record);   //Record{id=1, name='value', tokens=[active]}

record.tokens().add("new token");
System.out.println(record);   ////Record{id=1, name='value', tokens=[active]}
```
### 5. Immutable Classes in JDK
Apart from your written classes, JDK itself has lots of immutable classes. Given is such a list of immutable classes in Java.

- java.lang.String
- Wrapper classes such as Integer, Long, Double etc
- java.math.BigInteger and java.math.BigDecimal
- Unmodifiable collections such as Collections.singletonMap()
- java.lang.StackTraceElement
- Java enums
- java.util.Locale
- java.util.UUID
- Java 8 Date Time API – LocalDate, LocalTime etc.
- record types
### 6. Advantages
Immutable objects provide a lot of advantages over mutable objects. Let us discuss them.

- Predictability: guarantees that objects won’t change due to coding mistakes or by 3rd party libraries. As long as we reference a data structure, we know it is the same as at the time of its creation.
- Validity: is not needed to be tested again and again. Once we create the immutable object and test its validity once, we know that it will be valid indefinitely.
- Thread-safety: is achieved in the program as no thread can change immutable objects. It helps in writing code in a simple manner without accidentally corrupting the shared data objects.
- Cacheability: can be applied to immutable objects without worrying about state changes in the future. Optimization techniques, like memoization, are only possible with immutable data structures.
### 7. Conclusion
This tutorial taught us to create an immutable java class with mutable objects and immutable fields.

In Java, immutable classes are:

are simple to construct, test, and use
are automatically thread-safe and have no synchronization issues
do not need a copy constructor
do not need an implementation of clone()
allow hashCode() to use lazy initialization, and to cache its return value
do not need to be copied defensively when used as a field
make good Map keys and Set elements (these objects must not change state while in the collection)
have their class invariant established once upon construction, and it never needs to be checked again
always have “failure atomicity” (a term used by Joshua Bloch) : if an immutable object throws an exception, it’s never left in an undesirable or indeterminate state
We also saw the benefits which immutable classes bring in an application. As a design best practice, always aim to make your application Java classes to be immutable. In this way, you can always worry less about concurrency related defects in your program.
