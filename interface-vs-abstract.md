# Interface Vs Abstract Class After Java 8

With the introduction of concrete methods (default and static methods) to interfaces from Java 8, the gap between interface and abstract class has been reduced significantly. Now both can have concrete methods as well as abstract methods. But, still there exist some minute differences between them. In this article, we will try to list down the differences between interface and abstract class after Java 8.

## Differences Between Interface And Abstract Class After Java 8

1. **Fields**  
   Interface fields are public, static, and final by default. Interfaces still don’t support non-static and non-final variables. Interfaces can only have public, static, and final variables. On the other hand, an abstract class can have static as well as non-static and final as well as non-final variables. They also support private and protected variables along with public variables.

2. **Methods**  
   After Java 8, an interface can have default and static methods along with abstract methods. Interfaces don’t support final methods. But, abstract classes support final as well as non-final methods and static as well as non-static methods along with abstract methods. Also note that, only interfaces can have default methods. Abstract classes can’t have default methods.

3. **Constructors**  
   Interfaces can’t have constructors. Abstract classes can have any number of constructors.

4. **Member’s Accessibility**  
   All members of interfaces are public by default. Interfaces don’t support private and protected members. But, abstract classes support all types of members – private, protected, and public members.

5. **Multiple Inheritance**  
   A class can extend only one abstract class but can implement multiple interfaces. Thus, a class can inherit multiple properties from multiple sources only through interfaces, not through abstract classes.

## Interface Vs Abstract Class After Java 8

### Summary of Similarities and Differences

**Code Example**

```java
interface anyInterface {
    int i = 10; // By default, interface fields are public, static and final     
    void abstractMethod(); // Interface can have abstract method     
    default void defaultMethod() {
        System.out.println("Interface can have default method");
    }     
    static void staticMethod() {
        System.out.println("Interface can have static method");
    }     
    // No constructors in an interface     
    // No non-static and non-final variables in an interface     
    // No private fields and methods in an interface     
    // No protected fields and methods in an interface     
    // No final methods in an interface
}
 
abstract class anyAbstractClass {
    private int a; // Abstract class can have private field     
    protected int b; // Abstract class can have protected field     
    public int c; // Abstract class can have public field     
    static int d; // Abstract class can have static field     
    final int e = 10; // Abstract class can have final field     
    int f; // Abstract class can have non-static and non-final field     
    public anyAbstractClass() {
        System.out.println("Abstract class can have constructors");
    }      
    abstract void abstractMethod(); // Abstract class can have abstract method     
    private static void staticMethod() {
        System.out.println("Abstract class can have private and static method");
    }     
    public void nonStaticMethod() {
        System.out.println("Abstract class can have public and non-static method");
    }     
    protected void protectedMethod() {
        System.out.println("Abstract class can have protected method");
    }     
    final void finalMethod() {
        System.out.println("Abstract class can have final method");
    }     
    // No default method in an abstract class
}
```

## Java 8 Interface Changes: Default Methods And Static Methods

It has been a tough task for Java API developers to add new methods to current interfaces. Because, even if you add a single abstract method to an interface, all existing implementations of that interface have to be updated with the implementation of the new method. What if there exist hundreds or thousands of implementations of an interface? Even worse, what if you don’t have control over all of those implementations? To overcome such overhead, new features are introduced to interfaces from Java 8: default methods and static methods.

### Java 8 Interface Changes

From Java 8, interfaces can also have concrete methods, i.e., methods with a body along with abstract methods. This is the major change introduced to interfaces in Java 8 to help Java API developers to update and maintain the interfaces. The interfaces can have concrete methods either in the form of default methods or static methods.

#### A) Default Methods

1. **Definition With Example**  
   Default methods of an interface are the concrete methods, i.e., methods with a body for which implementing classes need not give implementation. They inherit default implementation. Default methods start with the modifier `default`.

   ```java
   interface InterfaceWithDefaultMethod {
       void abstractMethod(); // Abstract Method     
       default void defaultMethod() {
           System.out.println("It is a default method");
       }
   }
 
   class AnyClass implements InterfaceWithDefaultMethod {
       @Override
       public void abstractMethod() {
           System.out.println("Abstract Method implemented");
       }     
       // No need to implement defaultMethod()
   }
   ```

2. **Why Default Methods?**  
   Default methods are introduced to add extra features to current interfaces without disrupting their existing implementations. For example, `stream()` is a default method that is added to the `Collection` interface in Java 8. If `stream()` would have been added as an abstract method, then all classes implementing the `Collection` interface must have implemented the `stream()` method, which may have irritated existing users. Thanks to Java 8 default method feature, now it is a default method, and all implementations of the `Collection` interface inherit the default implementation of the `stream()` method.

3. **Three Rules To Solve Diamond Problem**  
   In Java, a class can extend only one class but can implement multiple interfaces. With the introduction of default methods, it is possible that your class inherits multiple methods with the same signature. In such scenarios, to solve the conflict, Java 8 specifies three rules to follow.

   - **Rule 1**: Select classes over interfaces  
     If your class inherits multiple methods with the same signature, then a method from the superclass is selected.

     ```java
     interface InterfaceOne {
         default void anyMethod() {
             System.out.println("Hi... From Interface One");
         }
     }
     
     interface InterfaceTwo extends InterfaceOne {
         @Override
         default void anyMethod() {
             System.out.println("Hi... From Interface Two");
         }
     }
     
     class ClassOne implements InterfaceOne, InterfaceTwo {
         @Override
         public void anyMethod() {
             System.out.println("Hi... From Class One");
         }
     }
     
     public class MyClass extends ClassOne implements InterfaceOne, InterfaceTwo {
         public static void main(String[] args) {
             new MyClass().anyMethod();
         }
     }
     ```

     **Output**:  
     `Hi... From Class One`

   - **Rule 2**: Select most specific interfaces than general interfaces  
     If your class doesn’t extend any class and inherits multiple methods with the same signature from multiple interfaces which belong to the same hierarchy, then a method from the most specific interface is selected.

     ```java
     interface InterfaceOne {
         default void anyMethod() {
             System.out.println("Hi... From Interface One");
         }
     }
     
     interface InterfaceTwo extends InterfaceOne {
         @Override
         default void anyMethod() {
             System.out.println("Hi... From Interface Two");
         }
     }
     
     public class MyClass implements InterfaceOne, InterfaceTwo {
         public static void main(String[] args) {
             new MyClass().anyMethod();
         }
     }
     ```

     **Output**:  
     `Hi... From Interface Two`

   - **Rule 3**: Use `InterfaceName.super.methodName()`  
     If your class doesn’t extend any class and inherits multiple methods with the same signature from multiple interfaces that don’t belong to the same hierarchy, then override that method and from within the body explicitly call the desired method as `InterfaceName.super.methodName()`.

     ```java
     interface InterfaceOne {
         default void anyMethod() {
             System.out.println("Hi... From Interface One");
         }
     }
     
     interface InterfaceTwo {
         default void anyMethod() {
             System.out.println("Hi... From Interface Two");
         }
     }
     
     public class MyClass implements InterfaceOne, InterfaceTwo {
         @Override
         public void anyMethod() {
             InterfaceOne.super.anyMethod();
         }     
         public static void main(String[] args) {
             new MyClass().anyMethod();
         }
     }
     ```

     **Output**:  
     `Hi... From Interface One`

#### B) Static Methods

1. **Definition With Example**  
   From Java 8, interfaces can also have static methods. Static methods are also concrete methods, but they can’t be implemented.

   ```java
   interface InterfaceWithDefaultAndStaticMethod {
       void abstractMethod(); // Abstract Method     
       default void defaultMethod() {
           System.out.println("It is a default method");
       }     
       static void staticMethod() {
           System.out.println("It is a static method");
       }
   }
 
   class AnyClass implements InterfaceWithDefaultAndStaticMethod {
       @Override
       public void abstractMethod() {
           System.out.println("Abstract Method implemented");
       }     
       // No need to implement defaultMethod()     
       // Can't implement staticMethod()
   }
   ```

2. **Why Static Methods?**  
   Java API developers have followed a pattern of supplying a utility class along with an interface to perform basic operations on such

 objects. But from Java 8, they have broken this pattern by introducing static methods to interfaces. With the introduction of static methods to interfaces, such utility classes will disappear and methods to perform basic operations will be kept as static methods in the interface itself.
```

Feel free to modify any parts as needed!
