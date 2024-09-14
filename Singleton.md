# Java Singleton Design Pattern- Commonly asked Interview Questions

Greetings everyone! Today, we’re exploring common interview questions concerning the Java Singleton design pattern, providing clear explanations alongside straightforward examples. These resources are specifically designed to aid individuals preparing for interviews. Whether you’re navigating technical interviews or seeking to enhance your understanding, this series aims to be a valuable asset in your journey toward success.

## 1. What is singleton class?
The Singleton design pattern, classified under Creational Design Patterns, ensures that only one instance of a class exists within the JVM and offers a singular access point for any other code to interact with it.

## 2. Where can we apply or use the singleton concept in real time?

Database Connection Pooling: Efficiently manage connections in multi-threaded environments for optimal database access.

Logger Objects: Ensure uniform logging across the application for debugging and monitoring purposes.

Configuration Management: Load configuration settings once from a file or database for easy access throughout the application.

Caching Mechanisms: Enhance performance by caching frequently accessed data, reducing the need for repeated computations or queries.

Thread Pooling: Effectively manage a pool of worker threads to handle concurrent task execution efficiently.

Hardware Interface Classes: Maintain single connections to hardware devices, preventing conflicts and resource wastage.

Global State Management: Centrally manage and update global state data, ensuring consistency and accessibility across the application.

## 3. What are the basic requirements for making class as a Singleton ?

Implementing the Singleton pattern involves several approaches, all sharing common concepts:

- A private constructor prevents external instantiation of the class.

- A private static variable holds the sole instance of the class.

- A public static method provides global access to retrieve the instance, serving as the entry point for external classes to obtain the singleton instance.

## 4. Give some examples of singleton design pattern used in Java JDK.

- java.awt.Desktop
- java.lang.System
- java.lang.Runtime
- java.util.logging.Logger
- java.security.Security

## 5. What is Eager initialization in Singleton ?

This approach involves creating an instance of a class well in advance of its immediate need, often during system startup.

In eager initialization for a singleton pattern, the instance is generated regardless of whether any other class requests it. Typically, this is achieved using a static variable, initialized during application startup.
```java
public class Singleton {

 private Singleton() {

 }

 private static final Singleton instance = new Singleton();

 public static Singleton getInstance() {
  return instance;
 }

}
```
## 6. What is Static Block Initialization Singleton?

The static block initialization method provides another approach to implement Singletons in Java. Similar to eager initialization, this method initializes the instance early, but it offers better exception handling features
```java
public class Singleton {

 private Singleton() {

 }

 private static Singleton instance;

 static {
  try {

   instance = new Singleton();

  } catch (Exception e) {
   throw new RuntimeException("Failed to create singleton instance");
  }
 }

 public static Singleton getInstance() {
  return instance;
 }

}
```
## 7. What is lazy initialization in Singleton ?

Lazy initialization means that we only create the single instance of a class when we actually need it for the first time. We don’t make it beforehand. This is useful when creating that instance takes a lot of time or needs special resources that we only want to use when necessary.
```java
public class Singleton {

 private Singleton() {

 }

 private static Singleton instance;

 public static Singleton getInstance() {
  if (instance == null) {
   return instance = new Singleton();
  }

  return instance;
 }

}
```
## 8. How to achieve the thread safety in Singleton?

To implement a Thread-Safe Singleton, the straightforward approach involves synchronizing the global access method. This ensures that multiple threads cannot create more than one instance by acquiring a lock before entering the getInstance() method.

```java
public class Singleton {

 private Singleton() {

 }

 private static Singleton instance;

 public synchronized static Singleton getInstance() {
  if (instance == null) {
   return instance = new Singleton();
  }

  return instance;
 }

}
```
## 9. What is double-checked locking in Singleton?

Considering the above code (Question no 8) Synchronizing the entire method can lead to performance degradation. Acquiring and releasing the lock with every call to getInstance() seems unnecessary. Initially, only a few calls need synchronization. For instance, if 5 threads attempt to call getInstance(), synchronization is only required for these threads. After the first object creation, subsequent threads receive the same object due to the null check in the if condition. Hence, optimization can be achieved using the double-checked locking principle, where a synchronized block is employed within the if condition, as illustrated below:

```java
public class Singleton {

 private Singleton() {

 }

 private static Singleton instance;

 public static Singleton getInstance() {

  if (instance == null) {

   synchronized (Singleton.class) {

    if (instance == null) {

     instance = new Singleton();

    }
   }

  }

  return instance;
 }

}
```
## 10. Explain Bill Pugh Singleton Implementation.

A Bill Pugh Singleton relies on the “initialization on demand holder” idiom, which employs inner classes and avoids synchronization constructs. It utilizes static blocks in a distinct manner and advocates for the usage of static inner classes.
```java
public class Singleton {

 private Singleton() {

 }

 private static class InnerSingleton {

  private static Singleton single = new Singleton();

 }

 public static Singleton getInstance() {
  return InnerSingleton.single;
 }

}
```
## 11. How to implement singleton using Enums?

In Java, you can implement the Singleton design pattern using enums. Enums in Java are inherently singletons because they can only have one instance per enumeration value. Here’s how you can implement a Singleton using enums
```java
public enum SingletonEnum {

 Instance;

 public void doSomething() {
  // Add your code here
 }

}
```
## 12. What are the different manners in which the Singleton Design pattern might encounter failure?

- Reflection
- Serialization and deserialization
- Cloning

## 13. Explain How reflection breaks the singleton design pattern with an example.

The Reflection API in Java enables the modification of a class’s runtime behaviour. Despite declaring the constructor as private in the Singleton implementations mentioned above, Reflection allows access to private constructors, thereby enabling the breaking of the singleton property of a class.
```java
public class Singleton {

 private Singleton() {

 }

 private static final Singleton instance = new Singleton();

 public static Singleton getInstance() {
  return instance;
 }

}
public class Test {

 public static void main(String[] args) {

  Singleton s1 = Singleton.getInstance();
  Singleton s2 = null;

  Constructor[] constructors = Singleton.class.getDeclaredConstructors();

  for (Constructor c : constructors) {

   c.setAccessible(true);
   try {
    s2 = (Singleton) c.newInstance();

    break;

   } catch (InstantiationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (IllegalAccessException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (IllegalArgumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }

  System.out.println("Hascode for S1 " + s1.hashCode());
  System.out.println("Hascode for S2 " + s2.hashCode());

 }

}
```
Image owned by Author
The output reveals that the two instances possess distinct hash codes, thereby undermining the Singleton pattern. To safeguard Singleton against reflection, a straightforward approach is to introduce an exception in the private constructor. This way, any attempt by reflection to access the private constructor will result in an error.

```java
public class Singleton {

 private Singleton() {

  if (Singleton.instance != null) {

   throw new InstantiationError("Object creation is not allowed");
  }

 }

 private static final Singleton instance = new Singleton();

 public static Singleton getInstance() {
  return instance;
 }

}
```
Image owned by Author
Another solution to safeguard Singleton against Reflection is by utilizing Enums (as mentioned in the previous question). Enums possess constructors that cannot be accessed via Reflection. The JVM internally manages the creation and invocation of enum constructors.

## 14. How Serialization and Deserialization impact the singleton design pattern and how to overcome the issue?

When a Singleton class implements the Serializable interface, it allows the object’s state to be saved and retrieved later using Deserialization. However, a challenge arises during Deserialization: a new instance of the class is created, thereby violating the Singleton pattern.

```java
public class Singleton {

 private Singleton() {

 }

 private static final Singleton instance = new Singleton();

 public static Singleton getInstance() {
  return instance;
 }

}



public class SingletonTest {

 public static void main(String[] args) {

  Singleton s1 = Singleton.getInstance();

  Singleton s2 = null;

  File file = new File("Test.txt");

  try {

   FileOutputStream fos = new FileOutputStream(file);
   ObjectOutputStream os = new ObjectOutputStream(fos);
   os.writeObject(s1);

   fos.close();
   os.close();

  } catch (Exception e) {
   e.printStackTrace();
  }

  try {

   FileInputStream fis = new FileInputStream(file);
   ObjectInputStream ois = new ObjectInputStream(fis);
   s2 = (Singleton) ois.readObject();
   fis.close();
   ois.close();

  } catch (Exception e) {
   e.printStackTrace();
  }

  System.out.println("Hashcode for S1 " + s1.hashCode());
  System.out.println("Hashcode for S2 " + s2.hashCode());

 }

}
```
## 15. How Cloning impacts the singleton design pattern and how to overcome the issue?

Cloning is used to create duplicate objects, essentially creating a copy of the original object. However, if we clone an instance of our Singleton class, a new instance will be created, consequently violating the Singleton pattern.
```java
public class Singleton implements Cloneable {

 private Singleton() {

 }

 private static final Singleton instance = new Singleton();

 public static Singleton getInstance() {
  return instance;
 }

 @Override
 protected Object clone() throws CloneNotSupportedException {

  return super.clone();
 }

}
public class SingletonTest {

 public static void main(String[] args) {

  Singleton s1 = Singleton.getInstance();
  Singleton s2 = null;
  try {
   s2 = (Singleton) s1.clone();

  } catch (CloneNotSupportedException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

  System.out.println("Hashcode for S1 " + s1.hashCode());
  System.out.println("Hashcode for S2 " + s2.hashCode());

 }

}
```
Image Owned by Author
As evident from the differing hashcodes of both instances, our Singleton pattern is compromised. To address this issue, we can override the clone method in our Singleton class. This overridden method can either return the same instance or throw a CloneNotSupportedException.
```java
public class Singleton implements Cloneable {
 private Singleton() {
 }
 private static final Singleton instance = new Singleton();
 public static Singleton getInstance() {
  return instance;
 }
 @Override
 protected Object clone() throws CloneNotSupportedException {
  return instance;
 }
}
```
Image Owned by Author
Thank you for taking the time to read my article until the end. I sincerely hope that you have gained valuable insights and knowledge from it. If you found the article enjoyable and informative, I kindly ask you to share it with your friends and colleagues.
