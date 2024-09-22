Sure! Here’s a concise Java Object-Oriented Programming (OOP) cheat sheet:

### Java Object-Oriented Programming Cheat Sheet

Java is an Object-Oriented language as it is modeled and organized around objects rather than actions; and data rather than logic. It simplifies software development and maintenance by providing some very intriguing features. Object-Oriented Programming in Java aims to implement real-world entities such as objects, classes, abstraction, inheritance, polymorphism, and many more.

#### Classes & Objects
- **Class**: A class in Java is a blueprint which includes all your data. A class contains fields (variables) and methods to describe the behavior of an object.

  ```java
  class Test {
      // member variables  // class body
      // methods
  }
  ```

- **Object**: An object is a major element in a class which has a state and behavior. It is an instance of a class which can access your data. The ‘new’ keyword is used to create the object.
  An instance of a class created using the `new` keyword.
  
  ```java
  //Declaring and Initializing an object
  Test t = new Test();
  ```

#### Constructors

A constructor is a block of code that initializes a newly created object. It is similar to a method in Java but doesn’t have any return type and its name is the same as the class name. There are 3 types of constructors:

- Default Constructor (No-Argument Constructor)
- Parameterized Constructor

- **Default Constructor**: This constructor is created by default by the java compiler at the time of class creation if no other constructor is declared in the class. Sometimes its also called no-argument constructor as it doesn’t contain any parameters.

No parameters, created by the compiler if none are defined.

  ```java
  class Test {
      public Test() { }
  }
  ```
- **Parameterized Constructor**: This constructor is called parameterized as it contains one or more parameters. It is used to provide different values to the distinct objects at the time of their creation.

Accepts parameters to initialize objects.

  ```java
  public class Test {
      int appId; 
      String appName;  
      Test(int id, String name) {
          this.appId = id;
          this.appName = name; 
      }
  }
  ```
  ```
  public class Test {
   int appId; 
   String appName;  
   //parameterized constructor with two parameters
   Test(int id, String name) {
      this.appId = id;
      this.appName = name; 
  } 
  void info() {
   System.out.println("Id: "+appId+" Name: "+appName);
  }
  public static void main(String args[]){ 
   Test obj1 = new Test(11001,"Facebook"); 
   Test obj2 = new Test(23003,"Instagram"); 
   obj1.info(); 
   obj2.info(); 
   }
  }
```

#### Modifiers

- **Access Modifiers**: Java access modifiers specify the scope of accessibility of a data member, method, constructor or class.
                        Control visibility (e.g., `public`, `private`, `protected`).
- **Non-Access Modifiers**: The non-access modifiers in Java, do not change the accessibility of variables and methods rather they provide special properties.
                            These modifiers can alter the behavior of elements as well.
                            Provide additional properties (e.g., `static`, `final`, `abstract`).

#### Inheritance

Inheritance is the property of a child/derived/subclass which allows it to inherit the properties(data members) and functionalities(methods) from its parent/base/superclass.

All objects have the Object class as their top parent.
Methods can be overridden but attributes can not.
To call a parent class constructor, super() is used.
Java supports 5 types of inheritance:

- **Types**:
  - **Single**: One parent. A class inherits the properties of a single parent class.
  - **Multi-Level**: Chain of classes. In multi-level inheritance, one class has more than one parent class but at different levels of inheritance
  - **Hierarchical**: One parent, multiple children. In hierarchical inheritance, one parent can have one or more child/sub/derived classes.
  - **Hybrid**: Combination of types. Hybrid Inheritance is the combination of more than one type of inheritance in a single program, for example, you can combine a multilevel inheritance with a hierarchical inheritance.
  - **Multiple**: Not supported directly (use interfaces). Multiple inheritance is not supported in Java as it leads to the diamond problem. The diamond problem is an ambiguity where the compiler doesn’t know which superclass method to execute in case the superclasses has a method with the same name.
 
```java
class A { }
class B extends A { }
class C extends B { }  // Multi-level
```
** But multiple inheritance in Java can be achieved using interfaces.

#### Polymorphism

Polymorphism is the ability of a variable, function or an object to take multiple forms. It allows you to define one interface or method and have multiple implementations. There are two types of polymorphism in Java.

- **Compile-Time**: Achieved via method overloading. Also called static binding, as the type of the object is determined at the compile time by the compiler itself.

  Example: Method Overloading
  
  ```java
  class Calculator {
      static int add(int a, int b) { return a + b; }
      static double add(double a, double b) { return a + b; }
  }
  ```

  ```java
  class Calculator {
    static int add(int a, int b){
      return a+b;
    }
    static double add( double a, double b){
      return a+b;
    }
    public static void main(String args[]){
      System.out.println(Calculator.add(123,17));
      System.out.println(Calculator.add(18.3,1.9));
    }
  }
```
- **Runtime**: Achieved via method overriding. Also called dynamic binding as the overridden method is resolved at runtime rather than compile-time. In this, a reference variable is used to call an overridden method of a superclass at run time. Example: Method Overriding.

  ```java
  class Mobile {
      void sms() { System.out.println("Mobile class"); }
  }
  class OnePlus extends Mobile {
      void sms() { System.out.println("OnePlus class"); }
  }
  ```
  ```java
    public class Mobile{
      void sms(){
        System.out.println("Mobile class");
      }
    }
    //Extending the Mobile class
    public class OnePlus extends Mobile{
      //Overriding sms() of Mobile class
      void sms(){
      System.out.println(" OnePlus class");
    }
    public static void main(String[] args)
    {
      OnePlus smsObj= new OnePlus();
      smsObj.sms();
    }
  }
 ```

#### Abstraction
- **Abstract Class**: Can have abstract and non-abstract methods.

- Ways To Achieve Abstraction
Abstraction is the process of hiding the details and showing only the necessary things to the user. You can achieve abstraction in two ways in Java:

Using Abstract Class (0–100%)
Using Interface (100%)

  ```java
  public abstract class MyAbstractClass {
      public abstract void abstractMethod();
  }
  ```
**Abstract Class** is a class which is declared with an abstract keyword and cannot be instantiated. Few pointers to create an abstract class:

- It can contain abstract and non-abstract methods.
- It can contain constructors and static methods as well.
- It can contain final methods which force the subclass not to change the body of the method.

- **Interface**: Contains abstract methods; classes implement interfaces.

An interface in java is a blueprint of a class that contains static constants and abstract methods. It represents the IS-A relation. You need to implement an interface to use its methods or constants.
  
  ```java
  public interface Bike {
      void start();
  }
  ```

  ```java

  //Creating an Interface
  public interface Bike { public void start(); }
  //Creating classes to implement Bike interface
  class Honda implements Bike{
    public void start() { System.out.println("Honda Bike"); }
  }
  class Apache implements Bike{
    public void start() { System.out.println("Apache Bike"); }
  }
  class Rider{
    public static void main(String args[]){ 
      Bike b1=new Honda(); 
      b1.start();
      Bike b2=new Apache();
      b2.start(); 
    }
  }
  ```

#### Encapsulation
- **Encapsulation**: Bundles data and methods. Encapsulation is a process of binding your data and code together as a single unit using getter and setter methods.
  - Use `private` fields and public getter/setter methods.

You need to perform two steps to achieve encapsulation:

Declare the variables of a class as private.
Provide public setter and getter methods to modify and view the values of the variables.

  ```java
  public class Artist {
      private String name;
      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
  }
  ```

  ```java
  public class Artist {
    private String name;
    //getter method
    public String getName() { return name; }
    //setter method
    public void setName(String name) { this.name = name; }
  }
  public class Show{
    public static void main(String[] args){
    //creating instance of the encapsulated class
    Artist s=new Artist(); 
    //setting value in the name member 
    s.setName("V"); 
    //getting value of the name member 
    System.out.println(s.getName()); 
    }
}
  ```

#### Association, Aggregation, and Composition

- **Association**: Relationship between classes (e.g., one-to-one, one-to-many).
  
**Association** is the relation between two different classes that is established via their objects. Association can be in many forms:

- One-to-One
- One-to-Many
- Many-to-One
- Many-to-Many.

- **Aggregation**: A "has-a" relationship; both entities can exist independently.

**Aggregation** is a special form of Association which represents the Has-A relationship. It is an uni-directional Association where both the entries can survive individually.

- **Composition**: A strong "part-of" relationship; the part cannot exist without the whole.

**Composition** is a more restrictive form of aggregation that makes two entities highly dependent on each other. It represents the part-of relationship where the composed object cannot exist without the other entity.

### Key Concepts
- **Inheritance** allows reusability and the creation of hierarchical relationships.
- **Polymorphism** enables flexibility and dynamic method resolution.
- **Abstraction** simplifies code by hiding complexity.
- **Encapsulation** protects data and maintains integrity.
