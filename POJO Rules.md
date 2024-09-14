A POJO (Plain Old Java Object) class is a simple Java object that follows certain conventions to make it easy to use, maintain, and serialize. While there aren't strict rules, adhering to the common conventions for POJOs is a good practice. Here are some key conventions and rules to follow when creating a POJO class:

### 1. **Public No-Argument Constructor**

- **Rule:** The class should have a public no-argument constructor. This allows for easy instantiation and is often required for frameworks and libraries (like serialization frameworks, dependency injection frameworks, etc.).
  
  ```java
  public class Person {
      private String name;
      private int age;

      // No-argument constructor
      public Person() {
      }

      // Parameterized constructor
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
  }
  ```

### 2. **Private Fields**

- **Rule:** Fields should be private to enforce encapsulation. This means that the data within the object should be accessed and modified only through public methods.
  
  ```java
  public class Person {
      private String name;
      private int age;
      
      // Getters and setters
  }
  ```

### 3. **Public Getter and Setter Methods**

- **Rule:** Provide public getter and setter methods for accessing and updating private fields. These methods allow controlled access to the fields.
  
  ```java
  public class Person {
      private String name;
      private int age;

      // Getter for name
      public String getName() {
          return name;
      }

      // Setter for name
      public void setName(String name) {
          this.name = name;
      }

      // Getter for age
      public int getAge() {
          return age;
      }

      // Setter for age
      public void setAge(int age) {
          this.age = age;
      }
  }
  ```

### 4. **Override `toString()`, `equals()`, and `hashCode()` Methods**

- **Rule:** Override these methods to provide meaningful string representation, equality checks, and hash code generation for your objects.
  
  ```java
  @Override
  public String toString() {
      return "Person{name='" + name + "', age=" + age + "}";
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person person = (Person) o;
      return age == person.age && Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
      return Objects.hash(name, age);
  }
  ```

### 5. **Serializable (Optional)**

- **Rule:** If the class needs to be serialized (e.g., saved to a file or sent over a network), it should implement the `Serializable` interface. Ensure that the class handles serialization properly, particularly if the class contains non-serializable fields.
  
  ```java
  public class Person implements Serializable {
      private static final long serialVersionUID = 1L;
      private String name;
      private int age;
      
      // Getters, setters, and other methods
  }
  ```

### 6. **No Business Logic**

- **Rule:** A POJO should only contain fields and methods to access or modify those fields. It should not contain business logic or complex methods. Business logic should be separated into other classes or services.

### 7. **Immutability (Optional but Preferred)**

- **Rule:** If the POJO is intended to be immutable (i.e., its state cannot be changed once created), ensure that fields are final and the class provides no setters. Immutable objects are often preferred in many applications because they are inherently thread-safe and easier to reason about.
  
  ```java
  public final class Person {
      private final String name;
      private final int age;

      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }

      public String getName() {
          return name;
      }

      public int getAge() {
          return age;
      }
  }
  ```

### Summary of POJO Rules

1. **Public no-argument constructor** for easy instantiation.
2. **Private fields** to enforce encapsulation.
3. **Public getter and setter methods** for accessing and modifying private fields.
4. **Override `toString()`, `equals()`, and `hashCode()`** methods for meaningful operations.
5. **Implement `Serializable`** if the class needs to support serialization.
6. **No business logic**—keep the POJO simple.
7. **Immutability** is optional but can be preferred for certain use cases.

By following these conventions, you ensure that your POJO classes are straightforward, maintainable, and compatible with various Java frameworks and libraries.
