# Java Exercises OOP

Object-oriented  programming: Object-oriented  programming (OOP) is a programming paradigm based on the concept of "objects", which can contain data and code. The data is in the form of fields (often known as attributes or properties), and the code is in the form of procedures (often known as methods).

A Java class file is a file (with the .class filename extension) containing Java bytecode that can be executed on the  Java Virtual Machine (JVM JVM). A Java class file is usually produced by a Java  compiler from Java programming language source files (.java files) containing Java classes (alternatively, other JVM languages can also be used to create class files).
If a source file has more than one class, each class is  compiled into a separate class file.

### 1. Write a Java program to create a class called "Person" with a name and age attribute. Create two instances of the "Person" class, set their attributes using the constructor, and print their name and age.

Write a Java program to create a class called "Person" with a name and age attribute. Create two instances of the "Person" class, set their attributes using the constructor, and print their name and age.

Sample Solution:

Java Code:
```java
 // Define the Person class
public class Person {
    // Declare a private variable to store the name of the person
    private String name;
    // Declare a private variable to store the age of the person
    private int age;

    // Constructor for the Person class that initializes the name and age variables
    public Person(String name, int age) {
        // Set the name variable to the provided name parameter
        this.name = name;
        // Set the age variable to the provided age parameter
        this.age = age;
    }

    // Method to retrieve the name of the person
    public String getName() {
        // Return the value of the name variable
        return name;
    }

    // Method to retrieve the age of the person
    public int getAge() {
        // Return the value of the age variable
        return age;
    }

    // Method to set the name of the person
    public void setName(String name) {
        // Set the name variable to the provided name parameter
        this.name = name;
    }

    // Method to set the age of the person
    public void setAge(int age) {
        // Set the age variable to the provided age parameter
        this.age = age;
    }
}
```
The above class has two private attributes: name and age, and a constructor that initializes these attributes with the values passed as arguments. It also has a getter method to access the attributes.
```java
// Define the Main class
public class Main {
    // Define the main method which is the entry point of the program
    public static void main(String[] args) {
        // Create an instance of the Person class with the name "Ean Craig" and age 11
        Person person1 = new Person("Ean Craig", 11);
        // Create another instance of the Person class with the name "Evan Ross" and age 12
        Person person2 = new Person("Evan Ross", 12);

        // Print the name and age of person1 to the console
        System.out.println(person1.getName() + " is " + person1.getAge() + " years old.");
        // Print the name and age of person2 to the console
        System.out.println(person2.getName() + " is " + person2.getAge() + " years old.\n");

        // Modify the age of person1 using the setter methods
        person1.setAge(14);
        // Modify the name and age of person2 using the setter methods
        person2.setName("Lewis Jordan");
        person2.setAge(12);
        System.out.println("Set new age and name:");
        // Print the updated name and age of person1 to the console
        System.out.println(person1.getName() + " is now " + person1.getAge() + " years old.");
        // Print the updated name and age of person2 to the console
        System.out.println(person2.getName() + " is now " + person2.getAge() + " years old.");
    }
}
```
In the above example, we create two instances of the "Person" class, set their attributes with the constructor, and print their name and age using the getter methods. We also modify the attributes using the setter methods and print the updated values.

Sample Output:

Ean Craig is 11 years old.
Evan Ross is 12 years old.

Set new age and name:
Ean Craig is now 14 years old.
Lewis Jordan is now 12 years old.

### 2. Write a Java program to create a class called "Dog" with a name and breed attribute. Create two instances of the "Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.

Write a Java program to create a class called " Dog" with a name and breed attribute. Create two instances of the " Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.

Sample Solution:

Java Code:
```java
// Define the Dog class
public class Dog {
    // Declare a private variable to store the name of the dog
    private String name;
    // Declare a private variable to store the breed of the dog
    private String breed;

    // Constructor for the Dog class that initializes the name and breed variables
    public Dog(String name, String breed) {
        // Set the name variable to the provided name parameter
        this.name = name;
        // Set the breed variable to the provided breed parameter
        this.breed = breed;
    }

    // Method to retrieve the name of the dog
    public String getName() {
        // Return the value of the name variable
        return name;
    }

    // Method to set the name of the dog
    public void setName(String name) {
        // Set the name variable to the provided name parameter
        this.name = name;
    }

    // Method to retrieve the breed of the dog
    public String getBreed() {
        // Return the value of the breed variable
        return breed;
    }

    // Method to set the breed of the dog
    public void setBreed(String breed) {
        // Set the breed variable to the provided breed parameter
        this.breed = breed;
    }
} 
```
The above class has two private attributes: ‘name’ and ‘breed’, and a constructor that initializes these attributes with the values passed as arguments. It also has getter and setter methods to access and modify these attributes.
```java
// Define the Main class
public class Main {
    // Define the main method which is the entry point of the program
    public static void main(String[] args) {
        // Create an instance of the Dog class with the name "Buddy" and breed "Golden Retriever"
        Dog dog1 = new Dog("Buddy", "Golden Retriever");
        // Create another instance of the Dog class with the name "Charlie" and breed "Bulldog"
        Dog dog2 = new Dog("Charlie", "Bulldog");

        // Print the name and breed of dog1 to the console
        System.out.println(dog1.getName() + " is a " + dog1.getBreed() + ".");
        // Print the name and breed of dog2 to the console
        System.out.println(dog2.getName() + " is a " + dog2.getBreed() + ".");

        // Print a message indicating that the breed of dog1 and the name of dog2 will be changed
        System.out.println("\nSet the new Breed of dog1 and new name of dog2:");
        // Change the breed of dog1 to "Labrador Retriever"
        dog1.setBreed("Labrador Retriever");
        // Change the name of dog2 to "Daisy"
        dog2.setName("Daisy");

        // Print the updated name and breed of dog1 to the console
        System.out.println(dog1.getName() + " is now a " + dog1.getBreed() + ".");
        // Print the updated name and breed of dog2 to the console
        System.out.println(dog2.getName() + " is now a " + dog2.getBreed() + ".");
    }
}
```
In the above example code, we create two instances of the " Dog" class, set their attributes through the constructor, and print their name and breed using the getter methods. We also modify the attributes using the setter methods and print the updated values.

Sample Output:

Buddy is a Golden Retriever.
Charlie is a Bulldog.

Set the new Breed of dog1 and new name of dog2:
Buddy is now a Labrador Retriever.
Daisy is now a Bulldog.

### 3. Write a Java program to create a class called "Rectangle" with width and height attributes. Calculate the area and perimeter of the rectangle.

Write a Java program to create a class called "Rectangle" with width and height attributes. Calculate the area and perimeter of the rectangle.

Sample Solution:

Java Code:
```java
// Define the Rectangle class
public class Rectangle {
    // Declare a private variable to store the width of the rectangle
    private double width;
    // Declare a private variable to store the height of the rectangle
    private double height;

    // Constructor for the Rectangle class that initializes the width and height variables
    public Rectangle(double width, double height) {
        // Set the width variable to the provided width parameter
        this.width = width;
        // Set the height variable to the provided height parameter
        this.height = height;
    }

    // Method to retrieve the width of the rectangle
    public double getWidth() {
        // Return the value of the width variable
        return width;
    }

    // Method to set the width of the rectangle
    public void setWidth(double width) {
        // Set the width variable to the provided width parameter
        this.width = width;
    }

    // Method to retrieve the height of the rectangle
    public double getHeight() {
        // Return the value of the height variable
        return height;
    }

    // Method to set the height of the rectangle
    public void setHeight(double height) {
        // Set the height variable to the provided height parameter
        this.height = height;
    }

    // Method to calculate and return the area of the rectangle
    public double getArea() {
        // Calculate the area by multiplying width and height, and return the result
        return width * height;
    }

    // Method to calculate and return the perimeter of the rectangle
    public double getPerimeter() {
        // Calculate the perimeter by adding width and height, multiplying by 2, and return the result
        return 2 * (width + height);
    }
}
```
The above class has two private attributes: 'width' and 'height', a constructor that initializes these attributes with the values passed as arguments, and getter and setter methods to access and modify these attributes. It also has two methods 'getArea()' and 'getPerimeter() ' to calculate the area and perimeter of the rectangle.
```java
// Define the Main class
public class Main {
    // Define the main method which is the entry point of the program
    public static void main(String[] args) {
        // Create an instance of the Rectangle class with the width 7 and height 12
        Rectangle rectangle = new Rectangle(7, 12);

        // Print the area of the rectangle to the console
        System.out.println("The area of the rectangle is " + rectangle.getArea());
        // Print the perimeter of the rectangle to the console
        System.out.println("The perimeter of the rectangle is " + rectangle.getPerimeter());

        // Set a new width for the rectangle
        rectangle.setWidth(6);
        // Set a new height for the rectangle
        rectangle.setHeight(12);

        // Print the updated area of the rectangle to the console
        System.out.println("\nThe area of the rectangle is now " + rectangle.getArea());
        // Print the updated perimeter of the rectangle to the console
        System.out.println("The perimeter of the rectangle is now " + rectangle.getPerimeter());
    }
}
```
In the Main() function we create an instance of the "Rectangle" class with a width of 7 and a height of 12, and call its methods to calculate the area and perimeter. We then modify the width and height using the setter methods and print the updated rectangle area and perimeter.

Sample Output:

The area of the rectangle is 84.0
The perimeter of the rectangle is 38.0

The area of the rectangle is now 72.0
The perimeter of the rectangle is now 36.0

### 4. Write a Java program to create a class called "Circle" with a radius attribute. You can access and modify this attribute. Calculate the area and circumference of the circle.

Write a Java program to create a class called "Circle" with a radius attribute. You can access and modify this attribute. Calculate the area and circumference of the circle.

Sample Solution:

Java Code:
```java
// Define the Circle class
public class Circle {
    // Declare a private variable to store the radius of the circle
    private double radius;

    // Constructor for the Circle class that initializes the radius variable
    public Circle(double radius) {
        // Set the radius variable to the provided radius parameter
        this.radius = radius;
    }

    // Method to retrieve the radius of the circle
    public double getRadius() {
        // Return the value of the radius variable
        return radius;
    }

    // Method to set the radius of the circle
    public void setRadius(double radius) {
        // Set the radius variable to the provided radius parameter
        this.radius = radius;
    }

    // Method to calculate and return the area of the circle
    public double getArea() {
        // Calculate the area using the formula π * radius^2 and return the result
        return Math.PI * radius * radius;
    }

    // Method to calculate and return the circumference of the circle
    public double getCircumference() {
        // Calculate the circumference using the formula 2 * π * radius and return the result
        return 2 * Math.PI * radius;
    }
} 
```
The above "Circle" class has a private attribute 'radius', a constructor that initializes this attribute with the value passed as an argument, and getter and setter methods to access and modify this attribute. It also calculates circle area and circumference using methods.
```java
// Define the Main class
public class Main {
    // Define the main method which is the entry point of the program
    public static void main(String[] args) {
        // Declare an integer variable r and initialize it with the value 5
        int r = 5;
        // Create an instance of the Circle class with the radius r
        Circle circle = new Circle(r);
        // Print the radius of the circle to the console
        System.out.println("Radius of the circle is " + r);
        // Print the area of the circle to the console
        System.out.println("The area of the circle is " + circle.getArea());
        // Print the circumference of the circle to the console
        System.out.println("The circumference of the circle is " + circle.getCircumference());
        // Update the radius variable r to 8
        r = 8;
        // Set the radius of the circle to the new value of r
        circle.setRadius(r);
        // Print the updated radius of the circle to the console
        System.out.println("\nRadius of the circle is " + r);
        // Print the updated area of the circle to the console
        System.out.println("The area of the circle is now " + circle.getArea());
        // Print the updated circumference of the circle to the console
        System.out.println("The circumference of the circle is now " + circle.getCircumference());
    }
}
```
In the above main() function, we create an instance of the "Circle" class with a radius of 5, and call its methods to calculate the area and circumference. We then modify the radius using the setter method and print the updated area and circumference.

Sample Output:

Radius of the circle is 5
The area of the circle is 78.53981633974483
The circumference of the circle is 31.41592653589793

Radius of the circle is 8
The area of the circle is now 201.06192982974676
The circumference of the circle is now 50.26548245743669

### 5. Write a Java program to create a class called "Book" with attributes for title, author, and ISBN, and methods to add and remove books from a collection.

Write a Java program to create a class called "Book" with attributes for title, author, and ISBN, and methods to add and remove books from a collection.

Sample Solution:

Java Code:
```java
//Book.java
// Import the ArrayList class from the java.util package
import java.util.ArrayList;

// Define the Book class
public class Book {
    // Declare a private variable to store the title of the book
    private String title;
    // Declare a private variable to store the author of the book
    private String author;
    // Declare a private variable to store the ISBN of the book
    private String ISBN;
    // Declare a static ArrayList to store the collection of Book objects
    private static ArrayList<Book> bookCollection = new ArrayList<Book>();

    // Constructor for the Book class that initializes the title, author, and ISBN variables
    public Book(String title, String author, String ISBN) {
        // Set the title variable to the provided title parameter
        this.title = title;
        // Set the author variable to the provided author parameter
        this.author = author;
        // Set the ISBN variable to the provided ISBN parameter
        this.ISBN = ISBN;
    }

    // Method to retrieve the title of the book
    public String get_Title() {
        // Return the value of the title variable
        return title;
    }

    // Method to set the title of the book
    public void set_Title(String title) {
        // Set the title variable to the provided title parameter
        this.title = title;
    }

    // Method to retrieve the author of the book
    public String get_Author() {
        // Return the value of the author variable
        return author;
    }

    // Method to set the author of the book
    public void set_Author(String author) {
        // Set the author variable to the provided author parameter
        this.author = author;
    }

    // Method to retrieve the ISBN of the book
    public String get_ISBN() {
        // Return the value of the ISBN variable
        return ISBN;
    }

    // Method to set the ISBN of the book
    public void set_ISBN(String ISBN) {
        // Set the ISBN variable to the provided ISBN parameter
        this.ISBN = ISBN;
    }

    // Static method to add a book to the book collection
    public static void add_Book(Book book) {
        // Add the provided book object to the bookCollection ArrayList
        bookCollection.add(book);
    }

    // Static method to remove a book from the book collection
    public static void remove_Book(Book book) {
        // Remove the provided book object from the bookCollection ArrayList
        bookCollection.remove(book);
    }

    // Static method to retrieve the entire book collection
    public static ArrayList<Book> get_BookCollection() {
        // Return the bookCollection ArrayList
        return bookCollection;
    }
}
```
The above class has three private attributes: title, author and ISBN. It has a constructor that initializes these attributes with the values passed as arguments, and getter and setter methods to access and modify these attributes. It also has static methods to add and remove books from a collection, and a static method to get the book collection.
```java
//Main.java
// Import the ArrayList class from the java.util package
import java.util.ArrayList;

// Define the Main class
public class Main {
    // Define the main method which is the entry point of the program
    public static void main(String[] args) {
        // Create an instance of the Book class with the title "The C Programming Language", author "Dennis Ritchie, Brian Kernighan", and ISBN "9780131101630"
        Book book1 = new Book("The C Programming Language", "Dennis Ritchie, Brian Kernighan", "9780131101630");
        // Create another instance of the Book class with the title "An Introduction to Python", author "Guido van Rossum", and ISBN "9355423489"
        Book book2 = new Book("An Introduction to Python", "Guido van Rossum", "9355423489");
        
        // Add book1 to the book collection
        Book.add_Book(book1);
        // Add book2 to the book collection
        Book.add_Book(book2);
        
        // Retrieve the book collection and store it in an ArrayList named bookCollection
        ArrayList<Book> bookCollection = Book.get_BookCollection();
        
        // Print a heading for the list of books
        System.out.println("List of books:");
        
        // Iterate over each book in the bookCollection
        for (Book book : bookCollection) {
            // Print the title, author, and ISBN of each book
            System.out.println(book.get_Title() + " by " + book.get_Author() + ", ISBN: " + book.get_ISBN());
        }
        
        // Remove book1 from the book collection
        Book.remove_Book(book1);
        
        // Print a message indicating that book1 has been removed
        System.out.println("\nAfter removing " + book1.get_Title() + ":");
        
        // Print a heading for the updated list of books
        System.out.println("List of books:");
        
        // Iterate over each book in the bookCollection
        for (Book book : bookCollection) {
            // Print the title, author, and ISBN of each book
            System.out.println(book.get_Title() + " by " + book.get_Author() + ", ISBN: " + book.get_ISBN());
        }
    }
}
```
In this example code, we create two instances of the "Book" class and add them to the collection with the ‘addBook’ method. We then print the title, author, and ISBN of each book in the collection using a for loop. We also remove book1 from the collection using the ‘removeBook’ method and print the updated collection.

Sample Output:

List of books:
The C Programming Language by Dennis Ritchie, Brian Kernighan, ISBN: 9780131101630
An Introduction to Python by Guido van Rossum, ISBN: 9355423489

After removing The C Programming Language:
List of books:
An Introduction to Python by Guido van Rossum, ISBN: 9355423489

### 6. Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.

Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.

Sample Solution:

Java Code:
```java
//Employee.java
// Define the Employee class
public class Employee {
    // Declare a private variable to store the name of the employee
    private String name;
    // Declare a private variable to store the job title of the employee
    private String jobTitle;
    // Declare a private variable to store the salary of the employee
    private double salary;

    // Constructor for the Employee class that initializes the name, job title, and salary variables
    public Employee(String name, String jobTitle, double salary) {
        // Set the name variable to the provided name parameter
        this.name = name;
        // Set the jobTitle variable to the provided jobTitle parameter
        this.jobTitle = jobTitle;
        // Set the salary variable to the provided salary parameter
        this.salary = salary;
    }

    // Method to retrieve the name of the employee
    public String getName() {
        // Return the value of the name variable
        return name;
    }

    // Method to set the name of the employee
    public void setName(String name) {
        // Set the name variable to the provided name parameter
        this.name = name;
    }

    // Method to retrieve the job title of the employee
    public String getJobTitle() {
        // Return the value of the jobTitle variable
        return jobTitle;
    }

    // Method to set the job title of the employee
    public void setJobTitle(String jobTitle) {
        // Set the jobTitle variable to the provided jobTitle parameter
        this.jobTitle = jobTitle;
    }

    // Method to retrieve the salary of the employee
    public double getSalary() {
        // Return the value of the salary variable
        return salary;
    }

    // Method to set the salary of the employee
    public void setSalary(double salary) {
        // Set the salary variable to the provided salary parameter
        this.salary = salary;
    }

    // Method to raise the salary of the employee by a given percentage
    public void raiseSalary(double percentage) {
        // Calculate the new salary by increasing the current salary by the given percentage
        salary = salary + salary * percentage / 100;
    }

    // Method to print the details of the employee
    public void printEmployeeDetails() {
        // Print the name of the employee
        System.out.println("Name: " + name);
        // Print the job title of the employee
        System.out.println("Job Title: " + jobTitle);
        // Print the salary of the employee
        System.out.println("Salary: " + salary);
    }
}
```
The above class has three private attributes: name, jobTitle, and salary. It has a constructor that initializes these attributes with the values passed as arguments. It also has getter and setter methods to access and modify these attributes. In addition, it provides methods for raising salaries by a certain percentage and printing employee information.
```java
// Main.java
// Define the Main class
public class Main {
    // Define the main method which is the entry point of the program
    public static void main(String[] args) {

        // Create an instance of the Employee class with the name "Franziska Waltraud", job title "HR Manager", and salary 40000
        Employee employee1 = new Employee("Franziska Waltraud", "HR Manager", 40000);
        // Create another instance of the Employee class with the name "Hubertus Andrea", job title "Software Engineer", and salary 60000
        Employee employee2 = new Employee("Hubertus Andrea", "Software Engineer", 60000);

        // Print a heading for the employee details section
        System.out.println("\nEmployee Details:");
        // Print the details of employee1
        employee1.printEmployeeDetails();
        // Print the details of employee2
        employee2.printEmployeeDetails();

        // Raise the salary of employee1 by 8%
        employee1.raiseSalary(8);
        // Raise the salary of employee2 by 12%
        employee2.raiseSalary(12);

        // Print a heading indicating that the salaries have been raised
        System.out.println("\nAfter raising salary:");
        // Print a heading for the salary raise details of employee1
        System.out.println("\n8% for 'Franziska Waltraud':");
        // Print the updated details of employee1
        employee1.printEmployeeDetails();
        // Print a heading for the salary raise details of employee2
        System.out.println("\n12% for 'Hubertus Andrea':");
        // Print the updated details of employee2
        employee2.printEmployeeDetails();
    }
}
```
In the above example code, we create two instances of the "Employee" class and print their details using the ’printEmployeeDetails()’ method. We then raise their salary using the ‘raiseSalary()’ method and print the updated details of the employees.

Sample Output:

Employee Details:
Name: Franziska Waltraud
Job Title: HR Manager
Salary: 40000.0
Name: Hubertus Andrea
Job Title: Software Engineer
Salary: 60000.0

After raising salary:

8% for 'Franziska Waltraud':
Name: Franziska Waltraud
Job Title: HR Manager
Salary: 43200.0

12% for 'Hubertus Andrea':
Name: Hubertus Andrea
Job Title: Software Engineer
Salary: 67200.0

### 7. Write a Java program to create a class called "Bank" with a collection of accounts and methods to add and remove accounts, and to deposit and withdraw money. Also define a class called "Account" to maintain account details of a particular customer.

Write a Java program to create a class called "Bank" with a collection of accounts and methods to add and remove accounts, and to deposit and withdraw money. Also define a class called "Account" to maintain account details of a particular customer.

Sample Solution:

Java Code:
```java
// Account.java
// Define the Account class
public class Account {
    // Declare a private variable to store the name of the account holder
    private String name;
    // Declare a private variable to store the account number
    private String accountNumber;
    // Declare a private variable to store the balance of the account
    private double balance;

    // Constructor for the Account class that initializes the name, account number, and balance variables
    public Account(String name, String accountNumber, double balance) {
        // Set the name variable to the provided name parameter
        this.name = name;
        // Set the accountNumber variable to the provided accountNumber parameter
        this.accountNumber = accountNumber;
        // Set the balance variable to the provided balance parameter
        this.balance = balance;
    }

    // Method to retrieve the name of the account holder
    public String getName() {
        // Return the value of the name variable
        return name;
    }

    // Method to set the name of the account holder
    public void setName(String name) {
        // Set the name variable to the provided name parameter
        this.name = name;
    }

    // Method to retrieve the account number
    public String getAccountNumber() {
        // Return the value of the accountNumber variable
        return accountNumber;
    }

    // Method to set the account number
    public void setAccountNumber(String accountNumber) {
        // Set the accountNumber variable to the provided accountNumber parameter
        this.accountNumber = accountNumber;
    }

    // Method to retrieve the balance of the account
    public double getBalance() {
        // Return the value of the balance variable
        return balance;
    }

    // Method to set the balance of the account
    public void setBalance(double balance) {
        // Set the balance variable to the provided balance parameter
        this.balance = balance;
    }

    // Method to deposit a specified amount into the account
    public void deposit(double amount) {
        // Increase the balance by the specified amount
        balance += amount;
    }

    // Method to withdraw a specified amount from the account
    public void withdraw(double amount) {
        // Decrease the balance by the specified amount
        balance -= amount;
    }

    // Method to retrieve the account information
    public String getAccountInfo() {
        // Return a string containing the name, account number, and balance
        return "Name: " + name + ", Account Number: " + accountNumber + ", Balance: " + balance;
    }
}
```
The above class has three private attributes: name, accountNumber and balance. There are several methods to deposit, withdraw, maintain balance in an individual account, print account details and more.
```java
// Bank.java
// Import the ArrayList class from the Java Collections Framework
import java.util.ArrayList;

// Define the Bank class
public class Bank {

  // Declare an ArrayList to store Account objects
  private ArrayList<Account> accounts;

  // Constructor for the Bank class
  public Bank() {
    // Initialize the accounts ArrayList
    accounts = new ArrayList<Account>();
  }

  // Method to add an Account to the accounts list
  public void addAccount(Account account) {
    // Add the given account to the accounts ArrayList
    accounts.add(account);
  }

  // Method to remove an Account from the accounts list
  public void removeAccount(Account account) {
    // Remove the given account from the accounts ArrayList
    accounts.remove(account);
  }

  // Method to deposit money into a specific Account
  public void depositMoney(Account account, double amount) {
    // Call the deposit method on the given account with the specified amount
    account.deposit(amount);
  }

  // Method to withdraw money from a specific Account
  public void withdrawMoney(Account account, double amount) {
    // Call the withdraw method on the given account with the specified amount
    account.withdraw(amount);
  }

  // Method to get the list of all accounts
  public ArrayList<Account> getAccounts() {
    // Return the accounts ArrayList
    return accounts;
  }
}
```
The above class has a private accounts attribute, a constructor that initializes this attribute as an empty array list. It also has methods to add and remove accounts from the collection, and to deposit and withdraw money from an account.
```java
// Main.java
// Import the ArrayList class from the Java Collections Framework
import java.util.ArrayList;

// Define the Main class
public class Main {
  
  // Main method, the entry point of the Java application
  public static void main(String[] args) {
    
    // Create a new Bank object
    Bank bank = new Bank();

    // Create three new Account objects with initial details
    Account account1 = new Account("Peter Irmgard", "C0011", 5000);
    Account account2 = new Account("Katja Ruedi", "C0121", 4500);
    Account account3 = new Account("Marcella Gebhard", "C0222", 20000);

    // Add the three accounts to the bank
    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.addAccount(account3);

    // Retrieve the list of accounts from the bank
    ArrayList<Account> accounts = bank.getAccounts();

    // Loop through each account in the accounts list
    for (Account account: accounts) {
      // Print the account information for each account
      System.out.println(account.getAccountInfo());
    }

    // Print a message indicating the start of a deposit transaction
    System.out.println("\nAfter depositing 1000 into account1:");
    // Deposit 1000 into account1
    bank.depositMoney(account1, 1000);
    // Print the updated account information for account1
    System.out.println(account1.getAccountInfo());

    // Print a message indicating no transaction for account2
    System.out.println("No transaction in account2:");
    // Print the account information for account2
    System.out.println(account2.getAccountInfo());

    // Print a message indicating the start of a withdrawal transaction
    System.out.println("After withdrawing 5000 from account3:");
    // Withdraw 5000 from account3
    bank.withdrawMoney(account3, 5000);
    // Print the updated account information for account3
    System.out.println(account3.getAccountInfo());
  }
}
```
In the above example code, we create an instance of the "Bank" class and three instances of the "Account" class, and add them to the collection through the ‘addAccount’ method. We then print the account information for each account in the collection using a for loop. We also deposit 1000 into account1 using the ‘depositMoney’ method, and withdraw 5000 from account3 using the ‘withdrawMoney’ method. We also print the updated account information. Account2 has no transaction.

Sample Output:

Name: Peter Irmgard, Account Number: C0011, Balance: 5000.0
Name: Katja Ruedi, Account Number: C0121, Balance: 4500.0
Name: Marcella Gebhard, Account Number: C0222, Balance: 20000.0

After depositing 1000 into account1:
Name: Peter Irmgard, Account Number: C0011, Balance: 6000.0
No transaction in account2:
Name: Katja Ruedi, Account Number: C0121, Balance: 4500.0
After withdrawing 5000 from account3:
Name: Marcella Gebhard, Account Number: C0222, Balance: 15000.0

### 8. Write a Java program to create class called "TrafficLight" with attributes for color and duration, and methods to change the color and check for red or green.

Write a Java program to create class called "TrafficLight" with attributes for color and duration, and methods to change the color and check for red or green.

Sample Solution:

Java Code:
```java
//TrafficLight.java
// Define the TrafficLight class
public class TrafficLight {
  
  // Declare a private variable to store the color of the traffic light
  private String color;
  
  // Declare a private variable to store the duration of the traffic light in seconds
  private int duration;

  // Constructor for the TrafficLight class
  public TrafficLight(String color, int duration) {
    // Initialize the color of the traffic light
    this.color = color;
    
    // Initialize the duration of the traffic light
    this.duration = duration;
  }

  // Method to change the color of the traffic light
  public void changeColor(String newColor) {
    // Update the color variable to the new color
    color = newColor;
  }

  // Method to check if the traffic light is red
  public boolean isRed() {
    // Return true if the color is red, otherwise return false
    return color.equals("red");
  }

  // Method to check if the traffic light is green
  public boolean isGreen() {
    // Return true if the color is green, otherwise return false
    return color.equals("green");
  }

  // Method to get the duration of the traffic light
  public int getDuration() {
    // Return the duration value
    return duration;
  }

  // Method to set the duration of the traffic light
  public void setDuration(int duration) {
    // Update the duration variable to the new value
    this.duration = duration;
  }
}
```
The above class has two private attributes: ‘color’ and ‘duration’. A constructor initializes these attributes with the values passed as arguments, and getter and setter methods to access and modify these attributes. It also has methods to change the ‘color’, and to check if the  light is red or green.
```java
//Main.java
// Define the Main class
public class Main {
  
  // Main method, the entry point of the Java application
  public static void main(String[] args) {
    
    // Create a new TrafficLight object with initial color "red" and duration 30 seconds
    TrafficLight light = new TrafficLight("red", 30);

    // Print whether the traffic light is red
    System.out.println("The light is red: " + light.isRed());
    
    // Print whether the traffic light is green
    System.out.println("The light is green: " + light.isGreen());

    // Change the color of the traffic light to "green"
    light.changeColor("green");

    // Print whether the traffic light is now green
    System.out.println("The light is now green: " + light.isGreen());
    
    // Print the duration of the traffic light
    System.out.println("The light duration is: " + light.getDuration());
    
    // Set a new duration for the traffic light to 20 seconds
    light.setDuration(20);
    
    // Print the updated duration of the traffic light
    System.out.println("The light duration is now: " + light.getDuration());
  }
}
```
In the above example code, we create an instance of the "TrafficLight" class with the color "red" and a duration of 30 seconds. We then print whether the  light is red or green using the “isRed” and “isGreen” methods. We change the  light color to "green" through the “changeColor” method, and display whether the light is now green. We also print the light duration using the “getDuration” method, and change the duration to 60 seconds with the “setDuration” method.

Sample Output:

The light is red: true
The light is green: false
The light is now green: true
The light duration is: 30
The light duration is now: 20

### 9. Write a Java program to create a class called "Employee" with a name, salary, and hire date attributes, and a method to calculate years of service.

Write a Java program to create a class called "Employee" with a name, salary, and hire date attributes, and a method to calculate years of service.

Sample Solution:

Java Code:
```java
// Employee.java
// Import the LocalDate class from the java.time package
import java.time.LocalDate;

// Import the Period class from the java.time package
import java.time.Period;

// Define the Employee class
public class Employee {
  
  // Declare a private variable to store the name of the employee
  private String name;
  
  // Declare a private variable to store the salary of the employee
  private double salary;
  
  // Declare a private variable to store the hire date of the employee
  private LocalDate hireDate;

  // Constructor for the Employee class
  public Employee(String name, double salary, LocalDate hireDate) {
    // Initialize the name of the employee
    this.name = name;
    
    // Initialize the salary of the employee
    this.salary = salary;
    
    // Initialize the hire date of the employee
    this.hireDate = hireDate;
  }

  // Method to get the name of the employee
  public String getName() {
    // Return the name of the employee
    return name;
  }

  // Method to set the name of the employee
  public void setName(String name) {
    // Update the name variable to the new value
    this.name = name;
  }

  // Method to get the salary of the employee
  public double getSalary() {
    // Return the salary of the employee
    return salary;
  }

  // Method to set the salary of the employee
  public void setSalary(double salary) {
    // Update the salary variable to the new value
    this.salary = salary;
  }

  // Method to get the hire date of the employee
  public LocalDate getHireDate() {
    // Return the hire date of the employee
    return hireDate;
  }

  // Method to set the hire date of the employee
  public void setHireDate(LocalDate hireDate) {
    // Update the hire date variable to the new value
    this.hireDate = hireDate;
  }

  // Method to calculate the years of service of the employee
  public int getYearsOfService() {
    // Calculate the period between the hire date and the current date, and return the number of years
    return Period.between(hireDate, LocalDate.now()).getYears();
  }

  // Method to print the details of the employee
  public void printEmployeeDetails() {
    // Print the name of the employee
    System.out.println("\nName: " + name);
    
    // Print the salary of the employee
    System.out.println("Salary: " + salary);
    
    // Print the hire date of the employee
    System.out.println("Hire Date: " + hireDate);
  }
}
```
In the above Employee class, there are three private attributes: name, salary, and hireDate, a constructor that initializes these attributes with the values passed as arguments, and getter and setter methods to access and modify these attributes.


There is a method “getYearsOfService()” to calculate years of service between the hire date and the current date, and returns the number of years as an integer value.
```java
// Main.java
// Import the LocalDate class from the java.time package
import java.time.LocalDate;

// Define the Main class
public class Main {
  
  // Main method, the entry point of the Java application
  public static void main(String[] args) {
    
    // Create a new Employee object named employee1 with name "Roberta Petrus", salary 50000, and hire date "2021-04-01"
    Employee employee1 = new Employee("Roberta Petrus", 50000, LocalDate.parse("2021-04-01"));
    
    // Create a new Employee object named employee2 with name "Loyd Blair", salary 70000, and hire date "2015-04-01"
    Employee employee2 = new Employee("Loyd Blair", 70000, LocalDate.parse("2015-04-01"));
    
    // Create a new Employee object named employee3 with name "Magdalena Artemon", salary 50000, and hire date "2011-01-15"
    Employee employee3 = new Employee("Magdalena Artemon", 50000, LocalDate.parse("2011-01-15"));

    // Print the details of employee1
    employee1.printEmployeeDetails();
    
    // Print the years of service of employee1
    System.out.println("Years of Service: " + employee1.getYearsOfService());
    
    // Print the details of employee2
    employee2.printEmployeeDetails();
    
    // Print the years of service of employee2
    System.out.println("Years of Service: " + employee2.getYearsOfService());
    
    // Print the details of employee3
    employee3.printEmployeeDetails();
    
    // Print the years of service of employee3
    System.out.println("Years of Service: " + employee3.getYearsOfService());
  }
}
```
In the above main() function, we create three instances of the "Employee" class, and print their name, salary, hire date, and years of service using the appropriate methods.

Sample Output:

Name: Roberta Petrus
Salary: 50000.0
HireDate: 2021-04-01
Years of Service: 2

Name: Loyd Blair
Salary: 70000.0
HireDate: 2015-04-01
Years of Service: 8

Name: Magdalena Artemon
Salary: 50000.0
HireDate: 2011-01-15
Years of Service: 12

### 10. Write a Java program to create a class called "Student" with a name, grade, and courses attributes, and methods to add and remove courses.

Write a Java program to create a class called "Student" with a name, grade, and courses attributes, and methods to add and remove courses.

Sample Solution:

Java Code:
```java
 // Student.java
// Import the ArrayList class from the Java Collections Framework
import java.util.ArrayList;

// Define the Student class
public class Student {
  
  // Declare a private variable to store the name of the student
  private String name;
  
  // Declare a private variable to store the grade of the student
  private int grade;
  
  // Declare a private ArrayList to store the courses of the student
  private ArrayList courses;

  // Constructor for the Student class
  public Student(String name, int grade) {
    // Initialize the name of the student
    this.name = name;
    
    // Initialize the grade of the student
    this.grade = grade;
    
    // Initialize the courses ArrayList
    this.courses = new ArrayList();
  }

  // Method to get the name of the student
  public String getName() {
    // Return the name of the student
    return name;
  }

  // Method to get the grade of the student
  public int getGrade() {
    // Return the grade of the student
    return grade;
  }

  // Method to get the courses of the student
  public ArrayList getCourses() {
    // Return the courses ArrayList
    return courses;
  }

  // Method to add a course to the student's course list
  public void addCourse(String course) {
    // Add the given course to the courses ArrayList
    courses.add(course);
  }

  // Method to remove a course from the student's course list
  public void removeCourse(String course) {
    // Remove the given course from the courses ArrayList
    courses.remove(course);
  }

  // Method to print the details of the student
  public void printStudentDetails() {
    // Print the name of the student
    System.out.println("Name: " + name);
    
    // Print the grade of the student
    System.out.println("Grade: " + grade);
  }
}
```
The above "Student" class has three private attributes: 'name', 'grade', and 'courses'. The 'name' and 'grade' attributes are initialized in the constructor with the values passed as arguments. The 'courses' attribute is initialized as an empty array list. There are getter methods for the 'name', 'grade', and 'courses' attributes. There are also methods to add and remove courses from the 'courses' attribute.
```java
// Main.java

// Define the Main class
public class Main {
  
  // Main method, the entry point of the Java application
  public static void main(String[] args) {
    
    // Create a new Student object named student1 with name "Carolus Vitali" and grade 11
    Student student1 = new Student("Carolus Vitali", 11);
    
    // Create a new Student object named student2 with name "Nakeisha Uhuru" and grade 10
    Student student2 = new Student("Nakeisha Uhuru", 10);
    
    // Create a new Student object named student3 with name "Gabriella Cherice" and grade 10
    Student student3 = new Student("Gabriella Cherice", 10);
    
    // Print a header for student details
    System.out.println("Student Details:");
    
    // Print the details of student1
    student1.printStudentDetails();
    
    // Print the details of student2
    student2.printStudentDetails();
    
    // Print the details of student3
    student3.printStudentDetails();
    
    // Print a message indicating courses are being added for student1
    System.out.println("Adding courses for " + student1.getName());
    
    // Add the course "Math" to student1's courses
    student1.addCourse("Math");
    
    // Add the course "Science" to student1's courses
    student1.addCourse("Science");
    
    // Add the course "English" to student1's courses
    student1.addCourse("English");
    
    // Print student1's name and their list of courses
    System.out.println(student1.getName() + "'s courses: " + student1.getCourses());

    // Print a message indicating courses are being added for student2
    System.out.println("\nAdding courses for " + student2.getName());
    
    // Add the course "History" to student2's courses
    student2.addCourse("History");
    
    // Add the course "Geography" to student2's courses
    student2.addCourse("Geography");
    
    // Add the course "English" to student2's courses
    student2.addCourse("English");
    
    // Print student2's name and their list of courses
    System.out.println(student2.getName() + "'s courses: " + student2.getCourses());
    
    // Print a message indicating the course "Science" is being removed for student1
    System.out.println("\nRemoving 'Science' course for " + student1.getName());
    
    // Remove the course "Science" from student1's courses
    student1.removeCourse("Science");
    
    // Print student1's name and their updated list of courses
    System.out.println(student1.getName() + "'s courses: " + student1.getCourses());
  }
}
```
The above Main class creates three instances of the Student class, adds courses to their courses list using the “addCourse()” method, and prints out the list of courses for each student using the “getCourses()” method. It then removes a course for student1 using the ‘removeCourse()’ method, and prints out the updated list of courses for student1.

Sample Output:

Student Details:
Name: Carolus Vitali
Grade: 11
Name: Nakeisha Uhuru
Grade: 10
Name: Gabriella Cherice
Grade: 10
Adding courses for Carolus Vitali
Carolus Vitali's courses: [Math, Science, English]

Adding courses for Nakeisha Uhuru
Nakeisha Uhuru's courses: [History, Geography, English]

Removing 'Science' course for Carolus Vitali
Carolus Vitali's courses: [Math, English]

### 11. Write a Java program to create a class called "Library" with a collection of books and methods to add and remove books.

Write a Java program to create a class called " Library" with a collection of books and methods to add and remove books.

Sample Solution:

Java Code:
```java
// Book.java
// Define the Book class
public class Book {
  // Private field to store the title of the book
  private String title;
  // Private field to store the author of the book
  private String author;

  // Constructor to initialize the title and author fields
  public Book(String title, String author) {
    // Assign the title parameter to the title field
    this.title = title;
    // Assign the author parameter to the author field
    this.author = author;
  }

  // Getter method for the title field
  public String getTitle() {
    // Return the value of the title field
    return title;
  }

  // Setter method for the title field
  public void setTitle(String title) {
    // Assign the title parameter to the title field
    this.title = title;
  }

  // Getter method for the author field
  public String getAuthor() {
    // Return the value of the author field
    return author;
  }

  // Setter method for the author field
  public void setAuthor(String author) {
    // Assign the author parameter to the author field
    this.author = author;
  }
} 
```
The above class has two private attributes, "title" and "author". It has a constructor that takes two arguments, the title and author of the book, and initializes the corresponding attributes. It also has getter and setter methods to access and modify the title and author attributes.
```java
// Library.java
// Import the ArrayList class from the java.util package
import java.util.ArrayList;

// Define the Library class
public class Library {
  // Private field to store a list of Book objects
  private ArrayList<Book> books;

  // Constructor to initialize the books field
  public Library() {
    // Create a new ArrayList to hold Book objects
    books = new ArrayList<Book>();
  }

  // Method to add a Book to the books list
  public void addBook(Book book) {
    // Add the specified book to the books list
    books.add(book);
  }

  // Method to remove a Book from the books list
  public void removeBook(Book book) {
    // Remove the specified book from the books list
    books.remove(book);
  }

  // Method to get the list of books
  public ArrayList<Book> getBooks() {
    // Return the list of books
    return books;
  }
}
```
The above " Library" class has a private books attribute, which is an ArrayList of Book objects. The  Library constructor initializes this attribute as an empty list. The "addBook()" method adds a Book object to the books list, while the “removeBook()” method removes a Book object from the list. The “getBooks()” method returns the books list.
```java
// Main.java

// Define the Main class
public class Main {
  // Main method, entry point of the program
  public static void main(String[] args) {
    // Create a new instance of the Library class
    Library library = new Library();

    // Create new Book objects with title and author
    Book book1 = new Book("Adventures of Tom Sawyer", "Mark Twain");
    Book book2 = new Book("Ben Hur", "Lewis Wallace");
    Book book3 = new Book("Time Machine", "H.G. Wells");
    Book book4 = new Book("Anna Karenina", "Leo Tolstoy");

    // Add the books to the library
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addBook(book4);

    // Print a message to indicate the books in the library
    System.out.println("Books in the library:");
    // Iterate through the list of books in the library
    for (Book book : library.getBooks()) {
      // Print the title and author of each book
      System.out.println(book.getTitle() + " by " + book.getAuthor());
    }

    // Remove a book from the library
    library.removeBook(book2);
    // Print a message to indicate the books in the library after removal
    System.out.println("\nBooks in the library after removing " + book2.getTitle() + ":");
    // Iterate through the updated list of books in the library
    for (Book book : library.getBooks()) {
      // Print the title and author of each book
      System.out.println(book.getTitle() + " by " + book.getAuthor());
    }
  }
}
```
In the above class, we create an instance of the  Library class and add two Book objects to the collection using the “addBook()” method. We then display the books in the  library using the “displayBooks()” method. We remove one of the books using the “removeBook()” method and display the updated collection of books in the  library.

Sample Output:

Books in the library:
Adventures of Tom Sawyer by Mark Twain
Ben Hur by Lewis Wallace
Time Machine by H.G. Wells
Anna Karenina by Leo Tolstoy

Books in the library after removing Ben Hur:
Adventures of Tom Sawyer by Mark Twain
Time Machine by H.G. Wells
Anna Karenina by Leo Tolstoy

### 12. Write a Java program to create a class called "Airplane" with a flight number, destination, and departure time attributes, and methods to check flight status and delay.

Write a Java program to create a class called "Airplane" with a flight number, destination, and departure time attributes, and methods to check flight status and delay.

Sample Solution:

Java Code:
```java
// Airplane.java
// Import the LocalTime class from the java.time package
import java.time.LocalTime;

// Define the Airplane class
public class Airplane {
  // Private field to store the flight number
  private String flightNumber;
  // Private field to store the destination
  private String destination;
  // Private field to store the scheduled departure time
  private LocalTime scheduledDeparture;
  // Private field to store the delay time in minutes
  private int delayTime;

  // Constructor to initialize the flight number, destination, and scheduled departure time
  public Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
    // Assign the flight number parameter to the flightNumber field
    this.flightNumber = flightNumber;
    // Assign the destination parameter to the destination field
    this.destination = destination;
    // Assign the scheduled departure time parameter to the scheduledDeparture field
    this.scheduledDeparture = scheduledDeparture;
    // Initialize the delay time to 0
    this.delayTime = 0;
  }

  // Getter method for the flight number
  public String getFlightNumber() {
    // Return the value of the flightNumber field
    return flightNumber;
  }

  // Setter method for the flight number
  public void setFlightNumber(String flightNumber) {
    // Assign the flight number parameter to the flightNumber field
    this.flightNumber = flightNumber;
  }

  // Getter method for the destination
  public String getDestination() {
    // Return the value of the destination field
    return destination;
  }

  // Setter method for the destination
  public void setDestination(String destination) {
    // Assign the destination parameter to the destination field
    this.destination = destination;
  }

  // Getter method for the scheduled departure time
  public LocalTime getScheduledDeparture() {
    // Return the value of the scheduledDeparture field
    return scheduledDeparture;
  }

  // Setter method for the scheduled departure time
  public void setScheduledDeparture(LocalTime scheduledDeparture) {
    // Assign the scheduled departure time parameter to the scheduledDeparture field
    this.scheduledDeparture = scheduledDeparture;
  }

  // Getter method for the delay time
  public int getDelayTime() {
    // Return the value of the delayTime field
    return delayTime;
  }

  // Method to set a delay and update the scheduled departure time
  public void delay(int minutes) {
    // Assign the delay time parameter to the delayTime field
    this.delayTime = minutes;
    // Update the scheduled departure time by adding the delay time
    this.scheduledDeparture = this.scheduledDeparture.plusMinutes(minutes);
  }

  // Method to check the status of the flight
  public void checkStatus() {
    // Check if there is no delay
    if (delayTime == 0) {
      // Print a message indicating the flight is on time
      System.out.println("Flight " + flightNumber + " is on time.");
    } else {
      // Print a message indicating the flight is delayed
      System.out.println("Flight " + flightNumber + " is delayed by " + delayTime + " minutes.");
    }
  }
} 
```
The above class represents an airplane with a flight number, destination, and scheduled departure time. It has getter and setter methods for these attributes. The class also two methods "delay()" and "checkStatus()" to delay the flight and check its status. The "delay()" method takes an integer value representing the number of minutes the flight will be delayed and updates the scheduled departure time accordingly. By using “checkStatus()” method, you can determine whether the flight has been delayed or is on time.
```java
// Import the LocalTime class from the java.time package
import java.time.LocalTime;

// Define the Main class
public class Main {
  // Main method, entry point of the program
  public static void main(String[] args) {
    // Create a new Airplane object with flight number "CDE345", destination "London", and departure time 10:30
    Airplane flight1 = new Airplane("CDE345", "London", LocalTime.of(10, 30));
    // Create a new Airplane object with flight number "KUI765", destination "New York", and departure time 14:00
    Airplane flight2 = new Airplane("KUI765", "New York", LocalTime.of(14, 0));
    // Create a new Airplane object with flight number "JUY456", destination "Paris", and departure time 14:00
    Airplane flight3 = new Airplane("JUY456", "Paris", LocalTime.of(14, 0));
    // Print the initial flight status
    System.out.println("Flight Status:");
    // Check and print the status of flight1
    flight1.checkStatus();
    // Check and print the status of flight2
    flight2.checkStatus();
    // Check and print the status of flight3
    flight3.checkStatus();
    // Delay flight1 by 40 minutes
    flight1.delay(40);
    // Delay flight2 by 110 minutes
    flight2.delay(110);
    // Print the current flight status after delays
    System.out.println("\nCurrent Flight Status:");
    // Check and print the status of flight1
    flight1.checkStatus();
    // Check and print the status of flight2
    flight2.checkStatus();
    // Check and print the status of flight3
    flight3.checkStatus();
  }
}
```
In the main() function, we create three "Airplane" objects and set flight numbers, destinations and scheduled departure times. It then calls the "checkStatus()" method to display the initial flight status of each flight. The program then delays flight1 and flight2 by calling the "delay()" method on these objects, and then calls the "checkStatus()" method again to display the updated flight status of each flight.

Sample Output:

Flight Status:
Flight CDE345 is on time.
Flight KUI765 is on time.
Flight JUY456 is on time.

Current Flight Status:
Flight CDE345 is delayed by 40 minutes.
Flight KUI765 is delayed by 110 minutes.
Flight JUY456 is on time.

### 13. Write a Java program to create a class called "Inventory" with a collection of products and methods to add and remove products, and to check for low inventory.

Write a Java program to create a class called "Inventory" with a collection of products and methods to add and remove products, and to check for low inventory.

Sample Solution:

Java Code:
```java
// Product.java
// Define the Product class
public class Product {
  // Private field to store the name of the product
  private String name;
  // Private field to store the quantity of the product
  private int quantity;

  // Constructor to initialize the name and quantity of the product
  public Product(String name, int quantity) {
    // Assign the name parameter to the name field
    this.name = name;
    // Assign the quantity parameter to the quantity field
    this.quantity = quantity;
  }

  // Getter method for the name field
  public String getName() {
    // Return the value of the name field
    return name;
  }

  // Setter method for the name field
  public void setName(String name) {
    // Assign the name parameter to the name field
    this.name = name;
  }

  // Getter method for the quantity field
  public int getQuantity() {
    // Return the value of the quantity field
    return quantity;
  }

  // Setter method for the quantity field
  public void setQuantity(int quantity) {
    // Assign the quantity parameter to the quantity field
    this.quantity = quantity;
  }
}
```
In the above code, we create a class called "Product" with two private attributes, "name" and "quantity". We also create a constructor to initialize these attributes and getter and setter methods to access and modify them.
```java
// Inventory.java
// Import the ArrayList class from the java.util package
import java.util.ArrayList;

// Define the Inventory class
public class Inventory {
  // Private field to store a list of Product objects
  private ArrayList<Product> products;

  // Constructor to initialize the products field
  public Inventory() {
    // Create a new ArrayList to hold Product objects
    products = new ArrayList<Product>();
  }

  // Method to add a Product to the products list
  public void addProduct(Product product) {
    // Add the specified product to the products list
    products.add(product);
  }

  // Method to remove a Product from the products list
  public void removeProduct(Product product) {
    // Remove the specified product from the products list
    products.remove(product);
  }

  // Method to check for low inventory products
  public void checkLowInventory() {
    // Iterate through the list of products
    for (Product product : products) {
      // Check if the product quantity is less than or equal to 100
      if (product.getQuantity() <= 100) {
        // Print a message indicating the product is running low on inventory
        System.out.println(product.getName() + " is running low on inventory. Current quantity: " + product.getQuantity());
      }
    }
  }
}
```
Here we create a class called "Inventory" with a private attribute "products", which is an ArrayList of Product objects. We also create a constructor to initialize this attribute as an empty list and methods to add and remove products from the list. Additionally, we create a method called "checkLowInventory()" to check for low inventory levels in the products list.
```java
// Main.java
// Define the Main class
public class Main {
  // Main method, entry point of the program
  public static void main(String[] args) {
    // Create a new instance of the Inventory class
    Inventory inventory = new Inventory();
    
    // Create new Product objects with name and quantity
    Product product1 = new Product("LED TV", 200);
    Product product2 = new Product("Mobile", 80);
    Product product3 = new Product("Tablet", 50);
    
    // Print a message indicating products are being added to the inventory
    System.out.println("Add three products in inventory:");
    
    // Add the products to the inventory
    inventory.addProduct(product1);
    inventory.addProduct(product2);
    inventory.addProduct(product3);
    
    // Print a message indicating low inventory check
    System.out.println("\nCheck low inventory:");
    
    // Check and print products with low inventory
    inventory.checkLowInventory();
    
    // Print a message indicating a product is being removed from the inventory
    System.out.println("\nRemove Tablet from the inventory!");
    
    // Remove the Tablet product from the inventory
    inventory.removeProduct(product3);
    
    // Print a message indicating another low inventory check
    System.out.println("\nAgain check low inventory:");
    
    // Check and print products with low inventory again
    inventory.checkLowInventory();
  }
}
```
In the "Main" class, we create an instance of the Inventory class and add three Product objects to the list. We then call the "checkLowInventory()" method to check for low inventory levels. Next, we remove one of the products from the list and call the "checkLowInventory()" method again to see if there are any other low inventory levels.

Sample Output:

Add three products in inventory:

Check low inventory:
Mobile is running low on inventory. Current quantity: 80
Tablet is running low on inventory. Current quantity: 50

Remove Tablet from the inventory!

Again check low inventory:
Mobile is running low on inventory. Current quantity: 80

### 14. Write a Java program to create a class called "School" with attributes for students, teachers, and classes, and methods to add and remove students and teachers, and to create classes.

Write a Java program to create a class called "School" with attributes for students, teachers, and classes, and methods to add and remove students and teachers, and to create classes.

Sample Solution:

Java Code:
```java
// School.java
// Import the ArrayList class from the java.util package
import java.util.ArrayList;

// Define the School class
public class School {
  // Private field to store a list of Student objects
  private ArrayList<Student> students;
  // Private field to store a list of Teacher objects
  private ArrayList<Teacher> teachers;
  // Private field to store a list of SchoolClass objects
  private ArrayList<SchoolClass> classes;

  // Constructor to initialize the students, teachers, and classes fields
  public School() {
    // Create a new ArrayList to hold Student objects
    this.students = new ArrayList<Student>();
    // Create a new ArrayList to hold Teacher objects
    this.teachers = new ArrayList<Teacher>();
    // Create a new ArrayList to hold SchoolClass objects
    this.classes = new ArrayList<SchoolClass>();
  }

  // Method to add a Student to the students list
  public void addStudent(Student student) {
    // Add the specified student to the students list
    students.add(student);
  }

  // Method to remove a Student from the students list
  public void removeStudent(Student student) {
    // Remove the specified student from the students list
    students.remove(student);
  }

  // Method to add a Teacher to the teachers list
  public void addTeacher(Teacher teacher) {
    // Add the specified teacher to the teachers list
    teachers.add(teacher);
  }

  // Method to remove a Teacher from the teachers list
  public void removeTeacher(Teacher teacher) {
    // Remove the specified teacher from the teachers list
    teachers.remove(teacher);
  }

  // Method to add a SchoolClass to the classes list
  public void addClass(SchoolClass schoolClass) {
    // Add the specified school class to the classes list
    classes.add(schoolClass);
  }

  // Method to remove a SchoolClass from the classes list
  public void removeClass(SchoolClass schoolClass) {
    // Remove the specified school class from the classes list
    classes.remove(schoolClass);
  }

  // Method to get the list of students
  public ArrayList<Student> getStudents() {
    // Return the list of students
    return students;
  }

  // Method to get the list of teachers
  public ArrayList<Teacher> getTeachers() {
    // Return the list of teachers
    return teachers;
  }

  // Method to get the list of classes
  public ArrayList<SchoolClass> getClasses() {
    // Return the list of classes
    return classes;
  }
}
```
The above "School" class represents a school with students, teachers, and classes. It has three ArrayList attributes to store Student, Teacher, and SchoolClass objects. The constructor initializes these ArrayLists as empty lists. It has methods to add and remove students, teachers, and classes from their respective ArrayLists. It also has getter methods to access ArrayLists of students, teachers, and classes.
```java
// Student.java
// Define the Student class
public class Student {
  // Private field to store the name of the student
  private String name;
  // Private field to store the age of the student
  private int age;

  // Constructor to initialize the name and age of the student
  public Student(String name, int age) {
    // Assign the name parameter to the name field
    this.name = name;
    // Assign the age parameter to the age field
    this.age = age;
  }

  // Getter method for the name field
  public String getName() {
    // Return the value of the name field
    return name;
  }

  // Setter method for the name field
  public void setName(String name) {
    // Assign the name parameter to the name field
    this.name = name;
  }

  // Getter method for the age field
  public int getAge() {
    // Return the value of the age field
    return age;
  }

  // Setter method for the age field
  public void setAge(int age) {
    // Assign the age parameter to the age field
    this.age = age;
  }
}
```
The "Student" class represents a student with a name and an age. It has a constructor that takes two arguments, name and age, and initializes the corresponding attributes. It also has getter and setter methods to access and modify name and age attributes.
```java
// Teacher.class
// Define the Teacher class
public class Teacher {
  // Private field to store the name of the teacher
  private String name;
  // Private field to store the subject of the teacher
  private String subject;

  // Constructor to initialize the name and subject of the teacher
  public Teacher(String name, String subject) {
    // Assign the name parameter to the name field
    this.name = name;
    // Assign the subject parameter to the subject field
    this.subject = subject;
  }

  // Getter method for the name field
  public String getName() {
    // Return the value of the name field
    return name;
  }

  // Setter method for the name field
  public void setName(String name) {
    // Assign the name parameter to the name field
    this.name = name;
  }

  // Getter method for the subject field
  public String getSubject() {
    // Return the value of the subject field
    return subject;
  }

  // Setter method for the subject field
  public void setSubject(String subject) {
    // Assign the subject parameter to the subject field
    this.subject = subject;
  }
}
```
The Teacher class represents a teacher in a school. It has two private attributes: name (teacher's name) and subject (Subject the teacher teaches). The class has a constructor that takes two arguments, the teacher's name and subject, and initializes the corresponding attributes. It also has getter and setter methods to access and modify the name and subject attributes.
```java
// SchoolClass.java
// Import the ArrayList class from the java.util package
import java.util.ArrayList;

// Define the SchoolClass class
public class SchoolClass {
  // Private field to store the name of the class
  private String className;
  // Private field to store the teacher of the class
  private Teacher teacher;
  // Private field to store a list of Student objects
  private ArrayList<Student> students;

  // Constructor to initialize the className, teacher, and students fields
  public SchoolClass(String className, Teacher teacher) {
    // Assign the className parameter to the className field
    this.className = className;
    // Assign the teacher parameter to the teacher field
    this.teacher = teacher;
    // Create a new ArrayList to hold Student objects
    this.students = new ArrayList<Student>();
  }

  // Getter method for the className field
  public String getClassName() {
    // Return the value of the className field
    return className;
  }

  // Setter method for the className field
  public void setClassName(String className) {
    // Assign the className parameter to the className field
    this.className = className;
  }

  // Getter method for the teacher field
  public Teacher getTeacher() {
    // Return the value of the teacher field
    return teacher;
  }

  // Setter method for the teacher field
  public void setTeacher(Teacher teacher) {
    // Assign the teacher parameter to the teacher field
    this.teacher = teacher;
  }

  // Getter method for the students field
  public ArrayList<Student> getStudents() {
    // Return the list of students
    return students;
  }

  // Method to add a Student to the students list
  public void addStudent(Student student) {
    // Add the specified student to the students list
    students.add(student);
  }

  // Method to remove a Student from the students list
  public void removeStudent(Student student) {
    // Remove the specified student from the students list
    students.remove(student);
  }
}
```
The SchoolClass class represents a class in a school. It has a private attribute className to store the name of the class and another private attribute teacher of type Teacher to store the teacher of the class. It also has a private attribute students of type ArrayList to store the students enrolled in the class. The constructor takes two arguments: className and teacher, and initializes these attributes.


The class has getter and setter methods for className and teacher. It also has methods addStudent and removeStudent to add and remove a student from the students list. The getStudents method returns the list of students in the class.
```java
//Main.java
// Import the ArrayList class from the java.util package
import java.util.ArrayList;

// Define the Main class
public class Main {
  // Main method, entry point of the program
  public static void main(String[] args) {
    // Create a new instance of the School class
    School school = new School();
    
    // Create new Student objects with name and age
    Student student1 = new Student("Mats Yatzil", 15);
    Student student2 = new Student("Karolina Ralf", 16);
    Student student3 = new Student("Felicie Anuschka", 16);
    Student student4 = new Student("Norbert Micha", 15);
    
    // Add the students to the school
    school.addStudent(student1);
    school.addStudent(student2);
    school.addStudent(student3);
    school.addStudent(student4);
    
    // Create new Teacher objects with name and subject
    Teacher teacher1 = new Teacher("Jens Amalia", "Math");
    Teacher teacher2 = new Teacher("Elise Giiwedin", "English");
    Teacher teacher3 = new Teacher("Angelika Lotta", "Science");
    
    // Add the teachers to the school
    school.addTeacher(teacher1);
    school.addTeacher(teacher2);
    school.addTeacher(teacher3);

    // Create new SchoolClass objects with class name and teacher
    SchoolClass mathClass = new SchoolClass("Mathematics", teacher1);
    // Add students to the math class
    mathClass.addStudent(student1);
    mathClass.addStudent(student2);
    mathClass.addStudent(student3);
    mathClass.addStudent(student4);

    SchoolClass englishClass = new SchoolClass("English", teacher2);
    // Add students to the English class
    englishClass.addStudent(student1);
    englishClass.addStudent(student2);
    englishClass.addStudent(student3);

    SchoolClass scienceClass = new SchoolClass("Science", teacher3);
    // Add students to the Science class
    scienceClass.addStudent(student1);
    scienceClass.addStudent(student2);
    scienceClass.addStudent(student3);
    scienceClass.addStudent(student4);

    // Add the classes to the school
    school.addClass(mathClass);
    school.addClass(englishClass);
    school.addClass(scienceClass);

    // Print general school information
    System.out.println("School information:");
    System.out.println("Number of students: " + school.getStudents().size());
    System.out.println("Number of teachers: " + school.getTeachers().size());
    System.out.println("Number of classes: " + school.getClasses().size());
    System.out.println();

    // Print math class information
    System.out.println("Math class information:");
    System.out.println("Class name: " + mathClass.getClassName());
    System.out.println("Teacher: " + mathClass.getTeacher().getName());
    System.out.println("Number of students: " + mathClass.getStudents().size());
    System.out.println();

    // Print English class information
    System.out.println("English class information:");
    System.out.println("Class name: " + englishClass.getClassName());
    System.out.println("Teacher: " + englishClass.getTeacher().getName());
    System.out.println("Number of students: " + englishClass.getStudents().size());
    System.out.println();
    
    // Print Science class information
    System.out.println("Science class information:");
    System.out.println("Class name: " + scienceClass.getClassName());
    System.out.println("Teacher: " + scienceClass.getTeacher().getName());
    System.out.println("Number of students: " + scienceClass.getStudents().size());
    System.out.println();

    // Remove a student, a teacher, and a class from the school
    school.removeStudent(student1);
    school.removeTeacher(teacher2);
    school.removeClass(mathClass);

    // Print updated school information after removal
    System.out.println("School information after removing one student, teacher and class:");
    System.out.println("Number of students: " + school.getStudents().size());
    System.out.println("Number of teachers: " + school.getTeachers().size());
    System.out.println("Number of classes: " + school.getClasses().size());
  }
}
```
The "Main" class is the program entry point. It creates objects of the "School", "Student", "Teacher", and "SchoolClass" classes to demonstrate the school system's functionality. It adds students, teachers, and classes to the school object using its respective methods. It then retrieves and prints information about the number of students, teachers, and classes in the school. It also prints the details of each class, including the name of the class, the teacher's name, and the number of students in each class. Finally, it removes one student, one teacher, and one class from the school and prints updated information about the school.

Sample Output:

School information:
Number of students: 4
Number of teachers: 3
Number of classes: 3

Math class information:
Class name: Mathematics
Teacher: Jens Amalia
Number of students: 4

English class information:
Class name: English
Teacher: Elise Giiwedin
Number of students: 3

Science class information:
Class name: Science
Teacher: Angelika Lotta
Number of students: 4

School information after removing one student, teacher and Class:
Number of students: 3
Number of teachers: 2
Number of classes: 2

### 15. Write a Java program to create a class called "MusicLibrary" with a collection of songs and methods to add and remove songs, and to play a random song.

Write a Java program to create a class called "MusicLibrary" with a collection of songs and methods to add and remove songs, and to play a random song.

Sample Solution:

Java Code:
```java
// MusicLibrary.java
// Import the ArrayList class from the Java utility package
import java.util.ArrayList;
// Import the Random class from the Java utility package
import java.util.Random;

// Define the MusicLibrary class
public class MusicLibrary {

    // Declare a private field to store a list of Song objects
    private ArrayList<Song> songs;

    // Constructor to initialize the songs list
    public MusicLibrary() {
        // Create a new ArrayList to hold Song objects
        songs = new ArrayList<Song>();
    }

    // Method to add a song to the library
    public void addSong(Song song) {
        // Add the provided song to the songs list
        songs.add(song);
    }

    // Method to remove a song from the library
    public void removeSong(Song song) {
        // Remove the provided song from the songs list
        songs.remove(song);
    }

    // Method to get the list of all songs in the library
    public ArrayList<Song> getSongs() {
        // Return the list of songs
        return songs;
    }

    // Method to play a random song from the library
    public void playRandomSong() {
        // Get the number of songs in the library
        int size = songs.size();

        // Check if the library is empty
        if (size == 0) {
            // Print a message if there are no songs to play
            System.out.println("No songs in the library.");
            return; // Exit the method
        }

        // Create a new Random object to generate a random number
        Random rand = new Random();

        // Generate a random index within the range of the songs list
        int index = rand.nextInt(size);

        // Print the title and artist of the randomly selected song
        System.out.println("Now playing: " + songs.get(index).getTitle() + " by " + songs.get(index).getArtist());
    }
}
```
The above “MusicLibrary” class represents a  library of songs. It uses an ArrayList to store the songs, and provides methods to add and remove songs from the  library. It also has a method to get a list of all the songs in the library, and a method to play a random song from the library.
```java
// Song.java
// Define the Song class
public class Song {

    // Private fields to store the title and artist of the song
    private String title;
    private String artist;

    // Constructor to initialize the title and artist fields
    public Song(String title, String artist) {
        this.title = title;  // Set the title field to the provided title
        this.artist = artist;  // Set the artist field to the provided artist
    }

    // Getter method to retrieve the title of the song
    public String getTitle() {
        return title;  // Return the value of the title field
    }

    // Setter method to update the title of the song
    public void setTitle(String title) {
        this.title = title;  // Set the title field to the provided title
    }

    // Getter method to retrieve the artist of the song
    public String getArtist() {
        return artist;  // Return the value of the artist field
    }

    // Setter method to update the artist of the song
    public void setArtist(String artist) {
        this.artist = artist;  // Set the artist field to the provided artist
    }
}
```
The “Song” class represents a song in a  music  library. It has two private instance variables, the title and the artist, and a constructor that takes these two variables as parameters. The class also provides getters and setters for the title and artist variables, allowing the client code to access and modify the song information.
```java
// Main.java
// Import the ArrayList class from the Java utility package
import java.util.ArrayList;

// Define the Main class
public class Main {

    // The main method - the entry point of the Java application
    public static void main(String[] args) {

        // Create a new instance of the MusicLibrary class
        MusicLibrary library = new MusicLibrary();

        // Add songs to the music library
        library.addSong(new Song("Midnight Train to Georgia", "Gladys Knight & the Pips"));
        library.addSong(new Song("Stairway to Heaven", "Led Zeppelin"));
        library.addSong(new Song("Imagine", "John Lennon"));
        library.addSong(new Song("All by Myself", "Eric Carmen"));
        library.addSong(new Song("What'd I Say", "Ray Charles"));
        library.addSong(new Song("Walking in Memphis", "Marc Cohn"));
        library.addSong(new Song("In the Air Tonight", "Phil Collins"));

        // Print all songs in the music library
        System.out.println("All songs:");

        // Iterate through each song in the library and print its title and artist
        for (Song song : library.getSongs()) {
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }

        // Print a message indicating a random song will be played
        System.out.println("\n**Playing Random Song**");

        // Play and print a random song from the library three times
        library.playRandomSong();
        System.out.println();
        library.playRandomSong();
        System.out.println();
        library.playRandomSong();
    }
}
```
The Main class creates an instance of MusicLibrary and adds several Song objects to it. It then retrieves and prints out the list of all songs in the  library. Finally, it calls the playRandomSong() method of the MusicLibrary object three times to play a random song each time, printing out the details of the played song.

Sample Output:

All songs:
Midnight Train to Georgia by Gladys Knight & the Pips
Stairway to Heaven by Led Zeppelin
Imagine by John Lennon
All by Myself by Eric Carmen
What'd I Say by Ray Charles
Walking in Memphis by Marc Cohn
In the Air Tonight by Phil Collins

**Playing Random Song**
Now playing: Imagine by John Lennon

Now playing: Midnight Train to Georgia by Gladys Knight & the Pips

Now playing: What'd I Say by Ray Charles

### 16. Write a Java program to create a class called "Shape" with abstract methods for calculating area and perimeter, and subclasses for "Rectangle", "Circle", and "Triangle".

Write a Java program to create a class called "Shape" with abstract methods for calculating area and perimeter, and subclasses for "Rectangle", "Circle", and "Triangle".

Note: An abstract class is a class that is declared abstract—it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.

An abstract method is a method that is declared without an implementation (without braces, and followed by a semicolon).

Sample Solution:

Java Code:
```java
//Shape.java
// Define the Shape class as an abstract class
public abstract class Shape {

    // Abstract method to get the area of the shape
    // This method must be implemented by any subclass of Shape
    public abstract double getArea();

    // Abstract method to get the perimeter of the shape
    // This method must be implemented by any subclass of Shape
    public abstract double getPerimeter();
} 
```
The above "Shape" class is an abstract class that defines the basic properties and behaviours of a geometric shape. It contains two abstract methods, "getArea()" and "getPerimeter()", which are to be implemented by its subclasses. Since the class is abstract, it cannot be instantiated on its own, but it provides a framework for other classes to extend and implement its methods.
```java
//Rectangle.java
// Define the Rectangle class, which extends the Shape class
public class Rectangle extends Shape {

    // Private fields to store the length and width of the rectangle
    private double length;
    private double width;

    // Constructor to initialize the length and width of the rectangle
    public Rectangle(double length, double width) {
        this.length = length; // Set the length field to the provided length
        this.width = width; // Set the width field to the provided width
    }

    // Method to calculate and return the area of the rectangle
    public double getArea() {
        return length * width; // Calculate the area by multiplying length and width
    }

    // Method to calculate and return the perimeter of the rectangle
    public double getPerimeter() {
        return 2 * (length + width); // Calculate the perimeter using the formula 2 * (length + width)
    }
}
```
The above code represents a class called ‘Rectangle’ that extends the ‘Shape’ abstract class. The ‘Rectangle’ class has two instance variables, ‘length’ and ‘width’, and a constructor that initializes these variables. It also has methods to calculate the area and perimeter of a rectangle using the ‘getArea()’ and ‘getPerimeter()’ methods respectively. The ‘getArea()’ method returns the product of the length and width variables while the ‘getPerimeter()’ method returns twice the sum of the length and width variables.
```java
// Circle.java

// Define the Circle class, which extends the Shape class
public class Circle extends Shape {

    // Private field to store the radius of the circle
    private double radius;

    // Constructor to initialize the radius of the circle
    public Circle(double radius) {
        this.radius = radius; // Set the radius field to the provided radius
    }

    // Method to calculate and return the area of the circle
    public double getArea() {
        return Math.PI * radius * radius; // Calculate the area using the formula π * radius^2
    }

    // Method to calculate and return the perimeter (circumference) of the circle
    public double getPerimeter() {
        return 2 * Math.PI * radius; // Calculate the perimeter using the formula 2 * π * radius
    }
}
```
The "Circle" class is a subclass of the abstract "Shape" class. It has a private instance variable for the radius of the circle. It implements abstract methods for calculating the area and perimeter of the circle. The area is calculated by multiplying the square of the radius by pi. The perimeter is calculated by multiplying the radius by twice pi value.
```java
// Triangle.java

// Define the Triangle class, which extends the Shape class
public class Triangle extends Shape {

    // Private fields to store the sides of the triangle
    private double side1;
    private double side2;
    private double side3;

    // Constructor to initialize the sides of the triangle
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1; // Set the side1 field to the provided side1
        this.side2 = side2; // Set the side2 field to the provided side2
        this.side3 = side3; // Set the side3 field to the provided side3
    }

    // Method to calculate and return the area of the triangle
    public double getArea() {
        double s = (side1 + side2 + side3) / 2; // Calculate the semi-perimeter
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Calculate the area using Heron's formula
    }

    // Method to calculate and return the perimeter of the triangle
    public double getPerimeter() {
        return side1 + side2 + side3; // Calculate the perimeter by summing the sides
    }
}
```
The "Triangle" class is a subclass of the "Shape" abstract class that represents a triangle shape. It has three instance variables to store the length of its three sides. It has a constructor that takes these three sides as parameters. The class provides implementations of the abstract methods "getArea()" and "getPerimeter()" to calculate the area and perimeter of the triangle based on its three sides using standard formulas.
```java
// Define the Main class
public class Main {
    
    // The main method - the entry point of the Java application
    public static void main(String[] args) {
        
        // Create a rectangle shape with length 10 and width 12
        Shape rectangle = new Rectangle(10, 12);
        
        // Create a circle shape with radius 5
        Shape circle = new Circle(5);
        
        // Create a triangle shape with sides 7, 8, and 6
        Shape triangle = new Triangle(7, 8, 6);

        // Print the header for the area and perimeter calculations
        System.out.println("\nArea and perimeter of various shapes:");
        
        // Print the details and calculations for the rectangle
        System.out.println("\nRectangle: Length-10, Width-12");
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        // Print the details and calculations for the circle
        System.out.println("\nCircle: Radius-5");
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        // Print the details and calculations for the triangle
        System.out.println("\nTriangle: Side1-7, Side2-8, Side3-6");
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
    }
}
```
The Main class creates instances of different shape objects including a rectangle, circle, and triangle. It then calls methods to calculate the area and perimeter of each shape and displays the results in the console.

Sample Output:

Area and perimeter of various shapes:

Rectangle: Length-10, Width-12
Area: 120.0
Perimeter: 44.0

Circle: Radius-5
Area: 78.53981633974483
Perimeter: 31.41592653589793

Triangle: Side1-7, Side2-8, Side3-6
Area: 20.33316256758894
Perimeter: 21.0

### 17. Write a Java program to create a class called "Movie" with attributes for title, director, actors, and reviews, and methods for adding and retrieving reviews.

Write a Java program to create a class called "Movie" with attributes for title, director, actors, and reviews, and methods for adding and retrieving reviews.

Sample Solution:

Java Code:
```java
// Movie.java

// Import the ArrayList class from the Java utility package
import java.util.ArrayList;

// Define the Movie class
public class Movie {

    // Private fields to store the title, director, actors, and reviews of the movie
    private String title;
    private String director;
    private ArrayList<String> actors;
    private ArrayList<Review> reviews;

    // Constructor to initialize the title, director, and actors of the movie
    public Movie(String title, String director, ArrayList<String> actors) {
        this.title = title; // Set the title field to the provided title
        this.director = director; // Set the director field to the provided director
        this.actors = actors; // Set the actors field to the provided list of actors
        this.reviews = new ArrayList<Review>(); // Initialize the reviews list as an empty ArrayList
    }

    // Method to add a review to the movie
    public void addReview(Review review) {
        this.reviews.add(review); // Add the provided review to the reviews list
    }

    // Method to get the list of all reviews for the movie
    public ArrayList<Review> getReviews() {
        return this.reviews; // Return the list of reviews
    }

    // Method to get the title of the movie
    public String getTitle() {
        return this.title; // Return the value of the title field
    }

    // Method to get the director of the movie
    public String getDirector() {
        return this.director; // Return the value of the director field
    }

    // Method to get the list of actors in the movie
    public ArrayList<String> getActors() {
        return this.actors; // Return the list of actors
    }
}
```
The above Java class has instance variables for the movie's title, director, actors, and reviews. The class constructor takes in the movie's title, director, and actors as parameters, and initializes the instance variables. The class also has methods to add a review to the movie's reviews list. It can retrieve the reviews list, and the movie's title, director, and actors. The reviews list is an ArrayList of Review objects, created outside of this class. These objects are added to the reviews list using the addReview() method.
```java
// Review.java

// Define the Review class
class Review {

    // Private fields to store the review text, reviewer name, and rating
    private String reviewText;
    private String reviewerName;
    private double rating;

    // Constructor to initialize the review text, reviewer name, and rating
    public Review(String reviewText, String reviewerName, double rating) {
        this.reviewText = reviewText; // Set the reviewText field to the provided review text
        this.reviewerName = reviewerName; // Set the reviewerName field to the provided reviewer name
        this.rating = rating; // Set the rating field to the provided rating
    }

    // Method to get the review text
    public String getReviewText() {
        return reviewText; // Return the value of the reviewText field
    }

    // Method to get the reviewer name
    public String getReviewerName() {
        return reviewerName; // Return the value of the reviewerName field
    }

    // Method to get the rating
    public double getRating() {
        return rating; // Return the value of the rating field
    }
}
```
The Review class represents a movie review, with attributes such as the review text, the reviewer's name, and the rating given to the movie. It has a constructor that takes these attributes as parameters and sets them as instance variables. The class also has three getter methods to retrieve review text, reviewer name, and rating.
```java
// Main.java
// Import the ArrayList and Arrays classes from the Java utility package
import java.util.ArrayList;
import java.util.Arrays;

// Define the Main class
public class Main {
  
  // The main method - the entry point of the Java application
  public static void main(String[] args) {
    
    // Create a movie object for "Titanic"
    Movie movie1 = new Movie("Titanic", "James Cameron",
      new ArrayList(Arrays.asList("Leonardo DiCaprio", "Kate Winslet")));

    // Create review objects
    Review review1 = new Review("Great movie!", "Irvine Rolf", 4.5);
    Review review2 = new Review("Highly recommended!", "Ashkii Karlheinz", 4.5);
    Review review3 = new Review("A classic that never gets old.", "Nele Athol", 4.0);
    Review review4 = new Review("Great movie!", "Cipactli Anselma", 4.0);
    Review review5 = new Review("Highly recommended!", "Martin Nadine", 4.0);

    // Add reviews to movie1
    movie1.addReview(review1);
    movie1.addReview(review2);
    movie1.addReview(review3);
    movie1.addReview(review4);

    // Create a movie object for "The Godfather"
    Movie movie2 = new Movie("The Godfather", "Francis Ford Coppola",
      new ArrayList(Arrays.asList("Marlon Brando", "Al Pacino", "James Caan")));

    // Display all the reviews for "Titanic"
    System.out.println("\nReviews for '" + movie1.getTitle() + "':");
    for (Review review : movie1.getReviews()) {
      System.out.println(review.getReviewText() + " by " + review.getReviewerName() + " - " + review.getRating());
    }

    // Add reviews to movie2
    movie2.addReview(review1);
    movie2.addReview(review4);
    movie2.addReview(review5);

    // Display all the reviews for "The Godfather"
    System.out.println("\nReviews for '" + movie2.getTitle() + "':");
    for (Review review : movie2.getReviews()) {
      System.out.println(review.getReviewText() + " by " + review.getReviewerName() + " - " + review.getRating());
    }
  }
}
```
The Main class is the entry point for the program. It creates two Movie objects: movie1 and movie2. It also creates five Review objects: review1, review2, review3, review4, and review5.


movie1 represents the movie "Titanic" directed by James Cameron and starring Leonardo DiCaprio and Kate Winslet. It adds four reviews to its reviews ArrayList.


movie2 represents the movie "The Godfather" directed by Francis Ford Coppola and starring Marlon Brando, Al Pacino, and James Caan. It adds three reviews to its reviews ArrayList.

The Main class then displays all the reviews for movie1 and movie2 by iterating over their reviews ArrayList and printing out the review text, reviewer name, and rating.

Sample Output:

Reviews for 'Titanic':
Great movie! by Irvine Rolf - 4.5
Highly recommended! by Ashkii Karlheinz - 4.5
A classic that never gets old. by Nele Athol - 4.0
Great movie! by Cipactli Anselma - 4.0

Reviews for 'The Godfather':
Great movie! by Irvine Rolf - 4.5
Great movie! by Cipactli Anselma - 4.0
Highly recommended! by Martin Nadine - 4.0

### 18. Write a Java program to create a class called "Restaurant" with attributes for menu items, prices, and ratings, and methods to add and remove items, and to calculate average rating.

Write a Java program to create a class called "Restaurant" with attributes for menu items, prices, and ratings, and methods to add and remove items, and to calculate average rating.

Sample Solution:

Java Code:
```java
// Restaurant.java
// Import the ArrayList class
import java.util.ArrayList;

// Define the Restaurant class
public class Restaurant {
  // Declare ArrayLists to store menu items, prices, ratings, and item counts
  private ArrayList menuItems;
  private ArrayList prices;
  private ArrayList ratings;
  private ArrayList itemCounts;

  // Constructor to initialize the ArrayLists
  public Restaurant() {
    // Initialize the menuItems ArrayList
    this.menuItems = new ArrayList();
    // Initialize the prices ArrayList
    this.prices = new ArrayList();
    // Initialize the ratings ArrayList
    this.ratings = new ArrayList();
    // Initialize the itemCounts ArrayList
    this.itemCounts = new ArrayList();
  }

  // Method to add an item to the menu
  public void addItem(String item, double price) {
    // Add the item to the menuItems ArrayList
    this.menuItems.add(item);
    // Add the price to the prices ArrayList
    this.prices.add(price);
    // Initialize the rating for the item to 0
    this.ratings.add(0);
    // Initialize the item count for the item to 0
    this.itemCounts.add(0);
  }

  // Method to remove an item from the menu
  public void removeItem(String item) {
    // Get the index of the item in the menuItems ArrayList
    int index = this.menuItems.indexOf(item);
    // If the item exists in the menu
    if (index >= 0) {
      // Remove the item from the menuItems ArrayList
      this.menuItems.remove(index);
      // Remove the corresponding price from the prices ArrayList
      this.prices.remove(index);
      // Remove the corresponding rating from the ratings ArrayList
      this.ratings.remove(index);
      // Remove the corresponding item count from the itemCounts ArrayList
      this.itemCounts.remove(index);
    }
  }

  // Method to add a rating to an item
  public void addRating(String item, int rating) {
    // Get the index of the item in the menuItems ArrayList
    int index = this.menuItems.indexOf(item);
    // If the item exists in the menu
    if (index >= 0) {
      // Get the current rating of the item
      int currentRating = this.ratings.get(index);
      // Get the current item count of the item
      int totalCount = this.itemCounts.get(index);
      // Update the rating of the item
      this.ratings.set(index, currentRating + rating);
      // Update the item count of the item
      this.itemCounts.set(index, totalCount + 1);
    }
  }

  // Method to get the average rating of an item
  public double getAverageRating(String item) {
    // Get the index of the item in the menuItems ArrayList
    int index = this.menuItems.indexOf(item);
    // If the item exists in the menu
    if (index >= 0) {
      // Get the total rating of the item
      int totalRating = this.ratings.get(index);
      // Get the item count of the item
      int itemCount = this.itemCounts.get(index);
      // Calculate and return the average rating of the item
      return itemCount > 0 ? (double) totalRating / itemCount : 0.0;
    } else {
      // Return 0.0 if the item does not exist in the menu
      return 0.0;
    }
  }

  // Method to display the menu
  public void displayMenu() {
    // Loop through the menuItems ArrayList
    for (int i = 0; i < menuItems.size(); i++) {
      // Print the item and its price
      System.out.println(menuItems.get(i) + ": $" + prices.get(i));
    }
  }

  // Method to calculate the average rating of all items
  public double calculateAverageRating() {
    // Initialize totalRating to 0
    double totalRating = 0;
    // Initialize numRatings to 0
    int numRatings = 0;
    // Loop through the ratings ArrayList
    for (int i = 0; i < ratings.size(); i++) {
      // Add the rating to totalRating
      totalRating += ratings.get(i);
      // Increment numRatings
      numRatings++;
    }
    // Calculate and return the average rating
    return numRatings > 0 ? totalRating / numRatings : 0.0;
  }
}
```
The above Java class defines a restaurant with menu items, prices, and ratings. It has a constructor that initializes three ArrayLists for the menu items, prices, and ratings. It also has methods to add and remove items from the menu and add ratings for each item. The class also includes a method to calculate the average rating for a given menu item. It also includes a method to display the current menu.
```java
// Main.java
// Define the Main class
public class Main {
  // Main method, the entry point of the application
  public static void main(String[] args) {
    // Create a new Restaurant object
    Restaurant restaurant = new Restaurant();
    // Add a Burger item with a price of $8.99 to the menu
    restaurant.addItem("Burger", 8.99);
    // Add a Pizza item with a price of $10.99 to the menu
    restaurant.addItem("Pizza", 10.99);
    // Add a Salad item with a price of $6.00 to the menu
    restaurant.addItem("Salad", 6.00);

    // Print the menu header
    System.out.println("Menu: Item & Price");
    // Display the menu items and their prices
    restaurant.displayMenu();

    // Add a rating of 4 to the Burger item
    restaurant.addRating("Burger", 4);
    // Add a rating of 5 to the Burger item
    restaurant.addRating("Burger", 5);
    // Add a rating of 3 to the Pizza item
    restaurant.addRating("Pizza", 3);
    // Add a rating of 4 to the Pizza item
    restaurant.addRating("Pizza", 4);
    // Add a rating of 2 to the Salad item
    restaurant.addRating("Salad", 2);

    // Get the average rating for the Burger item
    double averageRating = restaurant.getAverageRating("Burger");
    // Print the average rating for the Burger item
    System.out.println("\nAverage rating for Burger: " + averageRating);
    // Get the average rating for the Pizza item
    averageRating = restaurant.getAverageRating("Pizza");
    // Print the average rating for the Pizza item
    System.out.println("Average rating for Pizza: " + averageRating);
    // Get the average rating for the Salad item
    averageRating = restaurant.getAverageRating("Salad");
    // Print the average rating for the Salad item
    System.out.println("Average rating for Salad: " + averageRating);
    // Print the overall average rating for all items
    System.out.println("Average rating: " + restaurant.calculateAverageRating());

    // Print a message indicating that the Pizza item will be removed
    System.out.println("\nRemove 'Pizza' from the above menu.");
    // Remove the Pizza item from the menu
    restaurant.removeItem("Pizza");
    // Print the updated menu header
    System.out.println("\nUpdated menu:");
    // Display the updated menu items and their prices
    restaurant.displayMenu();
  }
}
```
The Main class contains the main function that creates an object of the Restaurant class and calls its methods to add, remove, and display menu items, as well as add ratings and calculate average ratings for those items.

Sample Output:

Menu:
Burger: $8.99
Pizza: $10.99
Salad: $6.0
Average rating: 4.666666666666667
Remove 'Pizza' from the above menu.

Updated menu:
Burger: $8.99
Salad: $6.0

### 19. Write a Java program to create a class with methods to search for flights and hotels, and to book and cancel reservations.

Write a Java program to create a class with methods to search for flights and hotels, and to book and cancel reservations.

Sample Solution:

Java Code:
```java
// TravelApp.java
// Import the ArrayList class
import java.util.ArrayList;
// Import the Random class
import java.util.Random;

// Define the TravelApp class
public class TravelApp {
  // Declare an ArrayList to store flights
  private ArrayList flights;
  // Declare an ArrayList to store hotels
  private ArrayList hotels;

  // Constructor to initialize the ArrayLists
  public TravelApp() {
    // Initialize the flights ArrayList
    this.flights = new ArrayList();
    // Initialize the hotels ArrayList
    this.hotels = new ArrayList();
  }

  // Method to search for flights
  public void searchFlights(String origin, String destination, String date, int numPassengers) {
    // Print the search details for flights
    System.out.println("Searching for flights from " + origin + " to " + destination + " on " + date + " for " + numPassengers + " passengers.");
  }

  // Method to search for hotels
  public void searchHotels(String location, String checkIn, String checkOut, int numGuests) {
    // Print the search details for hotels
    System.out.println("Searching for hotels in " + location + " from " + checkIn + " to " + checkOut + " for " + numGuests + " guests.");
  }

  // Method to book a flight
  public void bookFlight(int flightNumber, String passengerName, String origin, String destination, String date, int numPassengers, double price) {
    // Create a new Flight object with the provided details
    Flight flight = new Flight(flightNumber, passengerName, origin, destination, date, numPassengers, price);
    // Generate a confirmation number
    int confirmationNumber = generateConfirmationNumber();
    // Set the confirmation number for the flight
    flight.setConfirmationNumber(confirmationNumber);
    // Add the flight to the flights ArrayList
    this.flights.add(flight);
    // Print the confirmation number for the booked flight
    System.out.println("Flight booked! Confirmation number: " + confirmationNumber);
  }

  // Method to book a hotel
  public void bookHotel(int hotelId, String guestName, String location, String checkIn, String checkOut, int numGuests, double price) {
    // Create a new Hotel object with the provided details
    Hotel hotel = new Hotel(hotelId, guestName, location, checkIn, checkOut, numGuests, price);
    // Generate a confirmation number
    int confirmationNumber = generateConfirmationNumber();
    // Set the confirmation number for the hotel
    hotel.setConfirmationNumber(confirmationNumber);
    // Add the hotel to the hotels ArrayList
    this.hotels.add(hotel);
    // Print the confirmation number for the booked hotel
    System.out.println("Hotel booked! Confirmation number: " + confirmationNumber);
  }

  // Method to cancel a reservation
  public void cancelReservation(int confirmationNumber) {
    // Loop through the flights ArrayList to find the reservation
    for (Flight flight : this.flights) {
      // If the confirmation number matches, remove the flight reservation
      if (flight.getConfirmationNumber() == confirmationNumber) {
        this.flights.remove(flight);
        // Print the cancellation message for the flight
        System.out.println("Flight reservation with confirmation number " + confirmationNumber + " cancelled.");
        return;
      }
    }
    // Loop through the hotels ArrayList to find the reservation
    for (Hotel hotel : this.hotels) {
      // If the confirmation number matches, remove the hotel reservation
      if (hotel.getConfirmationNumber() == confirmationNumber) {
        this.hotels.remove(hotel);
        // Print the cancellation message for the hotel
        System.out.println("Hotel reservation with confirmation number " + confirmationNumber + " cancelled.");
        return;
      }
    }
    // Print a message if no reservation is found with the provided confirmation number
    System.out.println("No reservation found with confirmation number " + confirmationNumber + ".");
  }

  // Method to generate a random 6-digit confirmation number
  private int generateConfirmationNumber() {
    // Create a Random object
    Random rand = new Random();
    // Generate and return a random 6-digit number
    return rand.nextInt(900000) + 100000;
  }
} 
```
The above Java class is used for searching and booking flights and hotels, as well as cancelling reservations. It contains methods to search for flights and hotels based on specific criteria, book flights and hotels by creating new Flight and Hotel objects, cancel reservations by confirmation number, and generate a random confirmation number using the Random class in Java. It also contains private instance variables to store ArrayLists of Flight and Hotel objects that represent the current reservations.
```java
// Flight.java
// Define the Flight class
public class Flight {
    // Declare an integer variable to store the flight number
    private int flightNumber;
    // Declare a string variable to store the passenger name
    private String passengerName;
    // Declare a string variable to store the origin of the flight
    private String origin;
    // Declare a string variable to store the destination of the flight
    private String destination;
    // Declare a string variable to store the date of the flight
    private String date;
    // Declare an integer variable to store the number of passengers
    private int numPassengers;
    // Declare a double variable to store the price of the flight
    private double price;
    // Declare an integer variable to store the confirmation number
    private int confirmationNumber;

    // Constructor to initialize the Flight object with provided details
    public Flight(int flightNumber, String passengerName, String origin, String destination, String date, int numPassengers, double price) {
        // Initialize the flight number
        this.flightNumber = flightNumber;
        // Initialize the passenger name
        this.passengerName = passengerName;
        // Initialize the origin of the flight
        this.origin = origin;
        // Initialize the destination of the flight
        this.destination = destination;
        // Initialize the date of the flight
        this.date = date;
        // Initialize the number of passengers
        this.numPassengers = numPassengers;
        // Initialize the price of the flight
        this.price = price;
    }

    // Method to get the flight number
    public int getFlightNumber() {
        return flightNumber;
    }

    // Method to get the passenger name
    public String getPassengerName() {
        return passengerName;
    }

    // Method to get the origin of the flight
    public String getOrigin() {
        return origin;
    }

    // Method to get the destination of the flight
    public String getDestination() {
        return destination;
    }

    // Method to get the date of the flight
    public String getDate() {
        return date;
    }

    // Method to get the number of passengers
    public int getNumPassengers() {
        return numPassengers;
    }

    // Method to get the price of the flight
    public double getPrice() {
        return price;
    }

    // Method to get the confirmation number
    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    // Method to set the confirmation number
    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
```
The above “Flight” class represents a flight. It has flight number, passenger name, origin, destination, date, number of passengers, price, and confirmation number. It has a constructor to create a Flight object and getters and setters to access and modify the object's properties. The confirmation number is set after a flight is booked to identify a reservation.
```java
// Hotel.java
// Define the Hotel class
public class Hotel {
  // Declare an integer variable to store the hotel ID
  private int hotelId;
  // Declare a string variable to store the guest name
  private String name;
  // Declare a string variable to store the location of the hotel
  private String location;
  // Declare a string variable to store the check-in date
  private String checkIn;
  // Declare a string variable to store the check-out date
  private String checkOut;
  // Declare an integer variable to store the number of guests
  private int numGuests;
  // Declare a double variable to store the price of the stay
  private double price;
  // Declare an integer variable to store the confirmation number
  private int confirmationNumber;

  // Constructor to initialize the Hotel object with provided details
  public Hotel(int hotelId, String name, String location, String checkIn, String checkOut, int numGuests, double price) {
    // Initialize the hotel ID
    this.hotelId = hotelId;
    // Initialize the guest name
    this.name = name;
    // Initialize the location of the hotel
    this.location = location;
    // Initialize the check-in date
    this.checkIn = checkIn;
    // Initialize the check-out date
    this.checkOut = checkOut;
    // Initialize the number of guests
    this.numGuests = numGuests;
    // Initialize the price of the stay
    this.price = price;
  }

  // Method to get the hotel ID
  public int getHotelId() {
    return hotelId;
  }

  // Method to get the guest name
  public String getName() {
    return name;
  }

  // Method to get the location of the hotel
  public String getLocation() {
    return location;
  }

  // Method to get the check-in date
  public String getCheckIn() {
    return checkIn;
  }

  // Method to get the check-out date
  public String getCheckOut() {
    return checkOut;
  }

  // Method to get the price of the stay
  public double getPrice() {
    return price;
  }

  // Method to get the number of guests
  public int getNumGuests() {
    return numGuests;
  }

  // Method to get the confirmation number
  public int getConfirmationNumber() {
    return confirmationNumber;
  }

  // Method to set the confirmation number
  public void setConfirmationNumber(int confirmationNumber) {
    this.confirmationNumber = confirmationNumber;
  }
}
```
The above “Hotel” class represents a hotel, with an ID, a name, a location, a check-in date, a check-out date, a number of guests, a price, and a confirmation number. It contains a constructor that initializes these properties, as well as getter and setter methods for each property. The confirmation number is randomly generated and set through the setter method.
```java
// Main.java
// Define the Main class
public class Main {
  // Main method, the entry point of the application
  public static void main(String[] args) {
    // Create a new TravelApp object
    TravelApp app = new TravelApp();
    // Search for flights from New York to London on 2022-09-01 for 1 passenger
    app.searchFlights("New York", "London", "2022-09-01", 1);
    // Search for hotels in London from 2022-08-01 to 2022-09-05 for 2 guests
    app.searchHotels("London", "2022-08-01", "2022-09-05", 2);
    // Book a flight with flight number 12345670 for Martin Nadine from New York to London on 2022-08-01 for 1 passenger with a price of $700.00
    app.bookFlight(12345670, "Martin Nadine", "New York", "London", "2022-08-01", 1, 700.00);
    // Book a flight with flight number 67843513 for Jennifer Ulrike from New York to London on 2022-08-01 for 1 passenger with a price of $655.00
    app.bookFlight(67843513, "Jennifer Ulrike", "New York", "London", "2022-08-01", 1, 655.00);
    // Book a hotel with hotel ID 98765432 for Martin Nadine in London from 2022-09-01 to 2022-09-05 for 1 guest with a price of $100.00
    app.bookHotel(98765432, "Martin Nadine", "London", "2022-09-01", "2022-09-05", 1, 100.00);
    // Cancel the reservation with confirmation number 12345670
    app.cancelReservation(12345670);
  }
}
```
In the main() method of the above class, an instance of the “TravelApp” class is created. Several methods of the “TravelApp” class are called to perform various tasks related to travel. These tasks include searching for flights and hotels, booking flights and hotels, and cancelling reservations.


In particular, the “searchFlights()” method is called with the arguments "New York", "London", "2022-09-01", and 1, to search for flights from New York to London on September 1, 2022 for one passenger. Similarly, the “searchHotels()” method is called with the arguments "London", "2022-08-01", "2022-09-05", and 2, to search for hotels in London from August 1, 2022 to September 5, 2022 for two guests.


Then, two flights and one hotel are booked using the “bookFlight()” and “bookHotel()” methods respectively, with different arguments. Finally, a reservation for one of the flights is cancelled using the “cancelReservation()” method with the argument 12345670.

Sample Output:

Searching for flights from New York to London on 2022-09-01 for 1 passengers.
Searching for hotels in London from 2022-08-01 to 2022-09-05 for 2 guests.
Flight booked! Confirmation number: 528140
Flight booked! Confirmation number: 664315
Hotel booked! Confirmation number: 392396
No reservation found with confirmation number 12345670.

### 20. Write a Java program to create a class called "BankAccount" with attributes for account number, account holder's name, and balance. Include methods for depositing and withdrawing money, as well as checking the balance. Create a subclass called "SavingsAccount" that adds an interest rate attribute and a method to apply interest.

Write a Java program to create a class called "BankAccount" with attributes for account number, account holder's name, and balance. Include methods for depositing and withdrawing money, as well as checking the balance. Create a subclass called "SavingsAccount" that adds an interest rate attribute and a method to apply interest.

Sample Solution:

Java Code:
```java
BankAccount.java

// Define the BankAccount class
public class BankAccount {

    // Attribute for account number
    private String accountNumber;
    
    // Attribute for account holder's name
    private String accountHolderName;
    
    // Attribute for account balance
    private double balance;

    // Constructor to initialize BankAccount object
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }

    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }
}
```
The above Java code defines a BankAccount class with three attributes: accountNumber, accountHolderName, and balance. It includes a constructor to initialize these attributes when an object of this class is created. The class also provides methods to:

Deposit money (deposit): Adds a specified amount to the balance if the amount is positive.
Withdraw money (withdraw): Subtracts a specified amount from the balance if the amount is positive and does not exceed the current balance.
Check balance (checkBalance): Returns the current balance.
Get account number (getAccountNumber): Returns the account number.
Get the account holder's name (getAccountHolderName): Returns the account holder's name.
```java
SavingsAccount.java

// Define the SavingsAccount subclass that extends BankAccount
class SavingsAccount extends BankAccount {

    // Attribute for interest rate
    private double interestRate;

    // Constructor to initialize SavingsAccount object
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance); // Call the constructor of the superclass
        this.interestRate = interestRate;
    }

    // Method to apply interest to the balance
    public void applyInterest() {
        double interest = checkBalance() * interestRate / 100; // Calculate interest
        deposit(interest); // Add interest to the balance
        System.out.println("Interest applied: " + interest + ". New balance: " + checkBalance());
    }

    // Getter method for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter method for interest rate
    public void setInterestRate(double interestRate) {
        if (interestRate > 0) {
            this.interestRate = interestRate;
        } else {
            System.out.println("Interest rate must be positive.");
        }
    }
}
```
The above Java code defines a SavingsAccount class that extends the BankAccount class, inheriting its attributes and methods. The SavingsAccount class adds a new attribute, interestRate, which represents the interest rate for the savings account. The class includes:

Constructor: Initializes the SavingsAccount object with the account number, account holder's name, initial balance, and interest rate by calling the superclass (BankAccount) constructor for the common attributes.
Method to apply interest (applyInterest): Calculates interest based on the current balance and interest rate, then deposits interest into the account.
Getter method for interest rate (getInterestRate): Returns the current interest rate.
Setter method for interest rate (setInterestRate): Updates the interest rate if the provided rate is positive, ensuring it is a valid interest rate.
```java
Main.java

// Main class to test the BankAccount and SavingsAccount classes
public class Main {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account = new BankAccount("123456789", "Henri Lionel", 1000.0);
		System.out.println("Current balance: " + account.checkBalance()); // Check balance
        account.deposit(4000.0); // Deposit money
        account.withdraw(3000.0); // Withdraw money
        System.out.println("Current balance: " + account.checkBalance()); // Check balance

        // Create a SavingsAccount object
        SavingsAccount savings = new SavingsAccount("888888888", "Amphitrite Jun", 2000.0, 5.0);
        savings.applyInterest(); // Apply interest
        System.out.println("Savings account balance: " + savings.checkBalance()); // Check balance
    }
}
```
The above Java code defines a Main class with a main method to test the BankAccount and SavingsAccount classes. The main method demonstrates the creation and usage of these classes:

Create a BankAccount object: An instance of BankAccount is created with the account number "123456789", account holder's name "Henri Lionel", and an initial balance of 1000.0. The current balance is printed.
Deposit money: 4000.0 is deposited into the BankAccount.
Withdraw money: 3000.0 is withdrawn from the BankAccount.
Check balance: The current balance is printed again.
Create a SavingsAccount object: An instance of SavingsAccount is created with the account number "888888888", account holder's name "Amphitrite Jun", an initial balance of 2000.0, and an interest rate of 5.0.
Apply interest: Interest is applied to the SavingsAccount, and the new balance is printed.
This code tests the functionality of depositing, withdrawing, and applying interest in bank accounts.

Sample Output:

Current balance: 1000.0
Deposited: 4000.0. New balance: 5000.0
Withdrew: 3000.0. New balance: 2000.0
Current balance: 2000.0
Deposited: 100.0. New balance: 2100.0
Interest applied: 100.0. New balance: 2100.0
Savings account balance: 2100.0

### 21. Write a Java program to create a class called "Vehicle" with attributes for make, model, and year. Create subclasses "Car" and "Truck" that add specific attributes like trunk size for cars and payload capacity for trucks. Implement a method to display vehicle details in each subclass.

Write a Java program to create a class called "Vehicle" with attributes for make, model, and year. Create subclasses "Car" and "Truck" that add specific attributes like trunk size for cars and payload capacity for trucks. Implement a method to display vehicle details in each subclass.

Sample Solution:

Java Code:
```java
Vehicle.java

// Define the Vehicle class
public class Vehicle {

    // Attribute for make of the vehicle
    private String make;
    
    // Attribute for model of the vehicle
    private String model;
    
    // Attribute for year of the vehicle
    private int year;

    // Constructor to initialize Vehicle object
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    // Getter method for make
    public String getMake() {
        return make;
    }

    // Getter method for model
    public String getModel() {
        return model;
    }

    // Getter method for year
    public int getYear() {
        return year;
    }
}
```
The above Java code defines a Vehicle class with attributes for the make, model, and year of the vehicle. It includes:

Attributes: Private fields for make, model, and year.
Constructor: A constructor that initializes these attributes.
Method to display details (displayDetails): Prints the vehicle's make, model, and year.
Getter methods: getMake(), getModel(), and getYear() methods return the values of the make, model, and year attributes, respectively.
This class provides a basic blueprint for a vehicle with methods to access and display its details.
```java
Car.java

// Define the Car subclass that extends Vehicle
class Car extends Vehicle {

    // Attribute for trunk size of the car
    private double trunkSize;

    // Constructor to initialize Car object
    public Car(String make, String model, int year, double trunkSize) {
        super(make, model, year); // Call the constructor of the superclass
        this.trunkSize = trunkSize;
    }

    // Override the displayDetails method to include trunk size
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the superclass method
        System.out.println("Trunk Size: " + trunkSize + " cubic feet");
    }

    // Getter method for trunk size
    public double getTrunkSize() {
        return trunkSize;
    }

    // Setter method for trunk size
    public void setTrunkSize(double trunkSize) {
        if (trunkSize > 0) {
            this.trunkSize = trunkSize;
        } else {
            System.out.println("Trunk size must be positive.");
        }
    }
}
```
This Java code defines a 'Car' subclass that extends the Vehicle class, adding an additional attribute and behavior specific to cars:

Attribute: trunkSize to store the size of the car's trunk in cubic feet.
Constructor: Initializes the 'Car' object with make, model, year, and trunk size. It calls the constructor of the Vehicle superclass to initialize the common attributes.
Method to display details (displayDetails): Overrides the displayDetails method from the Vehicle class to include the trunk size. It first calls the superclass method to display common vehicle details, then adds the trunk size.
Getter and Setter methods: getTrunkSize() returns the trunk size, and setTrunkSize() updates the trunk size if the value is positive.
This subclass enhances the Vehicle class by adding a specific feature for cars and overriding the method to display complete car details.
```java
Truck.java

// Define the Truck subclass that extends Vehicle
class Truck extends Vehicle {

    // Attribute for payload capacity of the truck
    private double payloadCapacity;

    // Constructor to initialize Truck object
    public Truck(String make, String model, int year, double payloadCapacity) {
        super(make, model, year); // Call the constructor of the superclass
        this.payloadCapacity = payloadCapacity;
    }

    // Override the displayDetails method to include payload capacity
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the superclass method
        System.out.println("Payload Capacity: " + payloadCapacity + " tons");
    }

    // Getter method for payload capacity
    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    // Setter method for payload capacity
    public void setPayloadCapacity(double payloadCapacity) {
        if (payloadCapacity > 0) {
            this.payloadCapacity = payloadCapacity;
        } else {
            System.out.println("Payload capacity must be positive.");
        }
    }
}
```
The above Java code defines a 'Truck' subclass that extends the Vehicle class, adding an attribute specific to trucks:

Attribute: payloadCapacity to store the truck's payload capacity in tons.
Constructor: Initializes the Truck object with make, model, year, and payload capacity. It calls the constructor of the Vehicle superclass to initialize the common attributes.
Method to display details (displayDetails): Overrides the displayDetails method from the Vehicle class to include the payload capacity. It first calls the superclass method to display common vehicle details, then adds the payload capacity.
Getter and Setter methods: getPayloadCapacity() returns the payload capacity, and setPayloadCapacity() updates the payload capacity if the value is positive.
This subclass extends the Vehicle class by adding a specific feature for trucks and overriding the method to display complete truck details.
```java
Main.java

// Main class to test the Vehicle, Car, and Truck classes
public class Main {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Suzuki", "Swift", 2015, 15.1);
        car.displayDetails(); // Display car details

        // Create a Truck object
        Truck truck = new Truck("Ford", "F-150", 2016, 3.5);
        truck.displayDetails(); // Display truck details
    }
}
```
The above Java code defines a Main class with a main method used to test the Vehicle, Car, and Truck classes:

Car Object Creation: An instance of the Car class is created with the make "Suzuki", model "Swift", year 2015, and trunk size 15.1 cubic feet. The displayDetails method is called to print the details of the car.
Truck Object Creation: An instance of the Truck class is created with the make "Ford", model "F-150", year 2016, and payload capacity 3.5 tons. The displayDetails method is called to print the details of the truck.
This code tests the functionality of the Vehicle, Car, and Truck classes by creating instances of each and displaying their details.

Sample Output:

Vehicle Details:
Make: Suzuki
Model: Swift
Year: 2015
Trunk Size: 15.1 cubic feet
Vehicle Details:
Make: Ford
Model: F-150
Year: 2016
Payload Capacity: 3.5 tons

### 22. Write a Java program to create a class called "Customer" with attributes for name, email, and purchase history. Implement methods to add purchases to the history and calculate total expenditure. Create a subclass "LoyalCustomer" that adds a discount rate attribute and a method to apply the discount.

Write a Java program to create a class called "Customer" with attributes for name, email, and purchase history. Implement methods to add purchases to the history and calculate total expenditure. Create a subclass "LoyalCustomer" that adds a discount rate attribute and a method to apply the discount.

Sample Solution:

Java Code:
```java
Customer.java

// Define the Customer class
// Import necessary classes
import java.util.ArrayList;
import java.util.List;
public class Customer {
    // Attributes for the customer's name, email, and purchase history
    private String name;
    private String email;
    private List<Double> purchaseHistory;

    // Constructor to initialize the customer's name and email
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchaseHistory = new ArrayList<>();  // Initialize purchase history as an empty list
    }

    // Method to add a purchase to the purchase history
    public void addPurchase(double amount) {
        purchaseHistory.add(amount);
    }

    // Method to calculate the total expenditure
    public double calculateTotalExpenditure() {
        double total = 0;
        // Loop through each purchase and sum up the amounts
        for (double purchase : purchaseHistory) {
            total += purchase;
        }
        return total;
    }

    // Getters for the name and email attributes
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Getter for the purchase history
    public List<Double> getPurchaseHistory() {
        return purchaseHistory;
    }
}
```

Explanation:

Customer Class:

The Customer class has attributes for customer name, email, and purchase history.
The constructor initializes with the name, email, and an empty purchase history.
"addPurchase()" method adds a purchase amount to the purchase history.
"calculateTotalExpenditure()" method calculates the total amount spent by summing up the purchase history.
Getters provide access to the customer's name, email, and purchase history.
```java
LoyalCustomer.java

// Define the LoyalCustomer subclass that extends the Customer class
// Import necessary classes
import java.util.ArrayList;
import java.util.List;
class LoyalCustomer extends Customer {
    // Attribute for the discount rate
    private double discountRate;

    // Constructor to initialize the LoyalCustomer with name, email, and discount rate
    public LoyalCustomer(String name, String email, double discountRate) {
        super(name, email);  // Call the superclass constructor
        this.discountRate = discountRate;
    }

    // Method to apply the discount to a given amount
    public double applyDiscount(double amount) {
        return amount - (amount * discountRate / 100);
    }

    // Override the addPurchase method to apply the discount before adding the purchase
    @Override
    public void addPurchase(double amount) {
        double discountedAmount = applyDiscount(amount);
        super.addPurchase(discountedAmount);  // Call the superclass method to add the discounted amount
    }

    // Getter for the discount rate
    public double getDiscountRate() {
        return discountRate;
    }

    // Setter for the discount rate
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
```
Explanation:

LoyalCustomer Subclass:

The LoyalCustomer class extends the Customer class and adds a discountRate attribute.
The constructor initializes the LoyalCustomer with a discount rate, in addition to the attributes inherited from Customer.
"applyDiscount()" method calculates the discounted amount.
"addPurchase()" method overrides the superclass method to apply the discount before adding the purchase.
Getter and setter methods provide access to the discount rate.
```java
Main.java

// Main class to test the Customer and LoyalCustomer classes
// Import necessary classes
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Create a regular customer
        Customer customer1 = new Customer("Talisha Dion", "talisha@example.com");
        customer1.addPurchase(200);
        customer1.addPurchase(300);
        System.out.println("Total expenditure for " + customer1.getName() + ": " + customer1.calculateTotalExpenditure());

        // Create a loyal customer with a discount rate
        LoyalCustomer loyalCustomer = new LoyalCustomer("Fulchard Sofya", "fulchard@example.com", 10); // 10% discount
        loyalCustomer.addPurchase(200);
        loyalCustomer.addPurchase(300);
        System.out.println("Total expenditure for " + loyalCustomer.getName() + " after discount: " + loyalCustomer.calculateTotalExpenditure());
    }
}
```
Explanation:

Main Class:

The Main class contains the main method to test the functionality.
It creates instances of Customer and LoyalCustomer, adds purchases, and prints their total expenditure.
Output:

Total expenditure for Talisha Dion: 500.0
Total expenditure for Fulchard Sofya after discount: 450.0

### 23. Write a Java program to create a class called "Course" with attributes for course name, instructor, and credits. Create a subclass "OnlineCourse" that adds attributes for platform and duration. Implement methods to display course details and check if the course is eligible for a certificate based on duration.

Write a Java program to create a class called "Course" with attributes for course name, instructor, and credits. Create a subclass "OnlineCourse" that adds attributes for platform and duration. Implement methods to display course details and check if the course is eligible for a certificate based on duration.

Sample Solution:

Java Code:
```java
Course.java

// Define the Course class
public class Course {
    // Attributes for the course name, instructor, and credits
    private String courseName;
    private String instructor;
    private int credits;

    // Constructor to initialize the Course object
    public Course(String courseName, String instructor, int credits) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }

    // Method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Credits: " + credits);
    }

    // Getter for course name
    public String getCourseName() {
        return courseName;
    }

    // Getter for instructor
    public String getInstructor() {
        return instructor;
    }

    // Getter for credits
    public int getCredits() {
        return credits;
    }
}
```
Explanation:

Course Class:

Attributes: courseName, instructor, and credits.
Constructor: Initializes the attributes.
displayCourseDetails(): Prints the course details.
Getters: Methods to get the values of the attributes.
```java
OnlineCourse.java

// Define the OnlineCourse subclass that extends the Course class
class OnlineCourse extends Course {
    // Additional attributes for the platform and duration
    private String platform;
    private int duration; // duration in hours

    // Constructor to initialize the OnlineCourse object
    public OnlineCourse(String courseName, String instructor, int credits, String platform, int duration) {
        super(courseName, instructor, credits); // Call the superclass constructor
        this.platform = platform;
        this.duration = duration;
    }

    // Method to display course details, including platform and duration
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails(); // Call the superclass method to display common details
        System.out.println("Platform: " + platform);
        System.out.println("Duration: " + duration + " hours");
    }

    // Method to check if the course is eligible for a certificate based on duration
    public boolean isEligibleForCertificate() {
        // Assume that a course is eligible for a certificate if its duration is at least 10 hours
        return duration >= 10;
    }

    // Getter for platform
    public String getPlatform() {
        return platform;
    }

    // Getter for duration
    public int getDuration() {
        return duration;
    }
}
```
Explanation:

OnlineCourse Class:

Extends Course.
Additional Attributes: platform and duration.
Constructor: Initializes the attributes, calling the superclass constructor for the common attributes.
displayCourseDetails(): Overridden to include additional details specific to online courses.
isEligibleForCertificate(): Checks if the course duration is at least 10 hours to be eligible for a certificate.
Getters: Methods to get the values of the additional attributes.
```java
Main.java

// Main class to test the Course and OnlineCourse classes
public class Main {
    public static void main(String[] args) {
        // Create a Course object
        Course course = new Course("Java Programming", "Dr. Timaios Pliny", 4);
        course.displayCourseDetails();
        System.out.println();

        // Create an OnlineCourse object
        OnlineCourse onlineCourse = new OnlineCourse("Advanced Java", "Prof. Isacco Lyuba", 4, "Google", 10);
        onlineCourse.displayCourseDetails();
        System.out.println("Eligible for Certificate: " + onlineCourse.isEligibleForCertificate());
    }
}
```
Explanation:

Main Class:

Creates instances of Course and OnlineCourse and demonstrates the usage of their methods.
Output:

Course Name: Java Programming
Instructor: Dr. Timaios Pliny
Credits: 4

Course Name: Advanced Java
Instructor: Prof. Isacco Lyuba
Credits: 4
Platform:  Google
Duration: 10 hours
Eligible for Certificate: true

### 24. Write a Java program to create a class called "ElectronicsProduct" with attributes for product ID, name, and price. Implement methods to apply a discount and calculate the final price. Create a subclass " WashingMachine" that adds a warranty period attribute and a method to extend the warranty.

Write a Java program to create a class called "ElectronicsProduct" with attributes for product ID, name, and price. Implement methods to apply a discount and calculate the final price. Create a subclass " WashingMachine" that adds a warranty period attribute and a method to extend the warranty.

Sample Solution:

Java Code:
```java
ElectronicsProduct.java

// Define the ElectronicsProduct class
public class ElectronicsProduct {
    // Attributes for the product ID, name, and price
    private String productId;
    private String name;
    private double price;

    // Constructor to initialize the ElectronicsProduct object
    public ElectronicsProduct(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Method to apply a discount to the product price
    public void applyDiscount(double discountPercentage) {
        // Calculate the discount amount
        double discountAmount = price * discountPercentage / 100;
        // Subtract the discount amount from the original price
        price -= discountAmount;
    }

    // Method to calculate the final price after discount
    public double getFinalPrice() {
        // Return the current price which may have been discounted
        return price;
    }

    // Getter for product ID
    public String getProductId() {
        return productId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }
}
```
Explanation:

ElectronicsProduct Class:

Attributes: productId, name, and price.
Constructor: Initializes the attributes.
applyDiscount(double discountPercentage): Applies a discount to the product price.
getFinalPrice(): Returns the final price after the discount.
Getters: Methods to get the values of the attributes.
```java
WashingMachine.java

// Define the WashingMachine subclass that extends ElectronicsProduct
class WashingMachine extends ElectronicsProduct {
    // Additional attribute for the warranty period
    private int warrantyPeriod; // in months

    // Constructor to initialize the WashingMachine object
    public WashingMachine(String productId, String name, double price, int warrantyPeriod) {
        // Call the superclass constructor to initialize common attributes
        super(productId, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    // Method to extend the warranty period
    public void extendWarranty(int additionalMonths) {
        // Add the additional months to the current warranty period
        warrantyPeriod += additionalMonths;
    }

    // Getter for warranty period
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    // Override the display method to include warranty period
    @Override
    public void applyDiscount(double discountPercentage) {
        // Call the superclass method to apply the discount
        super.applyDiscount(discountPercentage);
        // Display a message indicating the discount was applied
        System.out.println("Discount applied to Washing Machine: " + getName());
    }
}
```
Explanation:

WashingMachine Class:

Extends ElectronicsProduct.
Additional Attribute: warrantyPeriod.
Constructor: Initializes the attributes, calling the superclass constructor for the common attributes.
extendWarranty(int additionalMonths): Extends the warranty period by the given
```java
Main.java

// Main class to test the ElectronicsProduct and WashingMachine classes
public class Main {
    public static void main(String[] args) {
        // Create an ElectronicsProduct object
        ElectronicsProduct product = new ElectronicsProduct("WM123", "Washing Machine", 1.00);
        // Apply a discount and display the final price
        product.applyDiscount(10);
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Name: " + product.getName());
        System.out.println("Price after discount: $" + product.getFinalPrice());
        System.out.println();

        // Create a WashingMachine object
        WashingMachine washingMachine = new WashingMachine("W456", "Front Load Washing Machine", 800.00, 24);
        // Apply a discount and display the final price
        washingMachine.applyDiscount(15);
        System.out.println("Product ID: " + washingMachine.getProductId());
        System.out.println("Name: " + washingMachine.getName());
        System.out.println("Price after discount: $" + washingMachine.getFinalPrice());
        // Display the warranty period
        System.out.println("Warranty period: " + washingMachine.getWarrantyPeriod() + " months");

        // Extend the warranty period and display the new warranty period
        washingMachine.extendWarranty(12);
        System.out.println("Warranty period after extension: " + washingMachine.getWarrantyPeriod() + " months");
    }
}
```
Explanation:

Main Class:

Creates instances of ElectronicsProduct and WashingMachine and demonstrates the usage of their methods.
Output:

Product ID: WM123
Name: Washing Machine
Price after discount: $900.0

Discount applied to Washing Machine: Front Load Washing Machine
Product ID: W456
Name: Front Load Washing Machine
Price after discount: $680.0
Warranty period: 24 months
Warranty period after extension: 36 months

### 25. Write a Java program to create a class called "Building" with attributes for address, number of floors, and total area. Create subclasses "ResidentialBuilding" and "CommercialBuilding" that add specific attributes like number of apartments for residential and office space for commercial buildings. Implement a method to calculate the total rent for each subclass.

Write a Java program to create a class called "Building" with attributes for address, number of floors, and total area. Create subclasses "ResidentialBuilding" and "CommercialBuilding" that add specific attributes like number of apartments for residential and office space for commercial buildings. Implement a method to calculate the total rent for each subclass.

Sample Solution:

Java Code:
```java
Building.java

// Import necessary packages
import java.util.ArrayList;
import java.util.List;

// Define the Building class
class Building {
    // Attributes for the Building class
    String address;
    int numberOfFloors;
    double totalArea;

    // Constructor for the Building class
    public Building(String address, int numberOfFloors, double totalArea) {
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.totalArea = totalArea;
    }

    // Method to display basic information about the building
    public void displayInfo() {
        System.out.println("Address: " + address);
        System.out.println("Number of Floors: " + numberOfFloors);
        System.out.println("Total Area: " + totalArea + " sq meters");
    }
}
```
Explanation:

The above Java code defines a "Building class" with three attributes: address, numberOfFloors, and totalArea. It includes a constructor to initialize these attributes and a method displayInfo() to print the building's information. The import statements at the top are prepared for possible use of ArrayList and List classes, although they are not utilized in the provided code segment.
```java
ResidentialBuilding.java

// Define the ResidentialBuilding class that extends Building
class ResidentialBuilding extends Building {
    // Additional attribute for ResidentialBuilding
    int numberOfApartments;
    double rentPerApartment;

    // Constructor for the ResidentialBuilding class
    public ResidentialBuilding(String address, int numberOfFloors, double totalArea, int numberOfApartments, double rentPerApartment) {
        super(address, numberOfFloors, totalArea); // Call the constructor of the superclass
        this.numberOfApartments = numberOfApartments;
        this.rentPerApartment = rentPerApartment;
    }

    // Method to calculate total rent for ResidentialBuilding
    public double calculateTotalRent() {
        return numberOfApartments * rentPerApartment;
    }

    // Override the displayInfo method to include additional details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Apartments: " + numberOfApartments);
        System.out.println("Rent per Apartment: $" + rentPerApartment);
        System.out.println("Total Rent: $" + calculateTotalRent());
    }
}
```
Explanation:

The above Java code defines a "ResidentialBuilding class" that extends the Building class. It adds two additional attributes: numberOfApartments and rentPerApartment. The constructor initializes these attributes along with those inherited from Building. The method calculateTotalRent() computes the total rent based on the number of apartments and the rent per apartment. The displayInfo() method is overridden to include details specific to residential buildings, in addition to the information from the "Building class".
```java
CommercialBuilding.java

// Define the CommercialBuilding class that extends Building
class CommercialBuilding extends Building {
    // Additional attribute for CommercialBuilding
    double officeSpace; // in square meters
    double rentPerSquareMeter;

    // Constructor for the CommercialBuilding class
    public CommercialBuilding(String address, int numberOfFloors, double totalArea, double officeSpace, double rentPerSquareMeter) {
        super(address, numberOfFloors, totalArea); // Call the constructor of the superclass
        this.officeSpace = officeSpace;
        this.rentPerSquareMeter = rentPerSquareMeter;
    }

    // Method to calculate total rent for CommercialBuilding
    public double calculateTotalRent() {
        return officeSpace * rentPerSquareMeter;
    }

    // Override the displayInfo method to include additional details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Office Space: " + officeSpace + " sq meters");
        System.out.println("Rent per Square Meter: $" + rentPerSquareMeter);
        System.out.println("Total Rent: $" + calculateTotalRent());
    }
}
```
Explanation:

The above Java code defines a "CommercialBuilding class" that extends the Building class. It adds two additional attributes: officeSpace (in square meters) and rentPerSquareMeter. The constructor initializes these attributes along with those inherited from Building. The method calculateTotalRent() computes the total rent based on the office space and rent per square meter. The displayInfo() method is overridden to include details specific to commercial buildings, in addition to the information from the Building class.
```java
Main.java

// Main class to test the Building, ResidentialBuilding, and CommercialBuilding classes
public class Main {
    public static void main(String[] args) {
        // Create an instance of ResidentialBuilding
        ResidentialBuilding residentialBuilding = new ResidentialBuilding("99 ABC Street.", 10, 2500.0, 20, 1000.0);

        // Create an instance of CommercialBuilding
        CommercialBuilding commercialBuilding = new CommercialBuilding("100 PQR Business Avenue.", 15, 4500.0, 3000.0, 20.0);

        // Display information about the residential building
        System.out.println("Residential Building Info:");
        residentialBuilding.displayInfo();

        // Display information about the commercial building
        System.out.println("\nCommercial Building Info:");
        commercialBuilding.displayInfo();
    }
}
```
Explanation:

The above Java code defines the Main class to test the "Building", "ResidentialBuilding", and "CommercialBuilding" classes. In the main method, it performs the following actions:

Creates an instance of ResidentialBuilding with specified attributes.
Creates an instance of CommercialBuilding with specified attributes.
Prints information about the residential building using the displayInfo() method.
Prints information about the commercial building using the displayInfo() method.
The code demonstrates how to instantiate and utilize the "ResidentialBuilding" and "CommercialBuilding" classes.

Output:

Residential Building Info:
Address: 99 ABC Street.
Number of Floors: 10
Total Area: 2500.0 sq meters
Number of Apartments: 20
Rent per Apartment: $1000.0
Total Rent: $20000.0

Commercial Building Info:
Address: 100 PQR Business Avenue.
Number of Floors: 15
Total Area: 4500.0 sq meters
Office Space: 3000.0 sq meters
Rent per Square Meter: $20.0
Total Rent: $60000.0

### 26. Write a Java program to create a class called "Event" with attributes for event name, date, and location. Create subclasses "Seminar" and "MusicalPerformance" that add specific attributes like number of speakers for seminars and performer list for concerts. Implement methods to display event details and check for conflicts in the event schedule.

Write a Java program to create a class called "Event" with attributes for event name, date, and location. Create subclasses "Seminar" and "MusicalPerformance" that add specific attributes like number of speakers for seminars and performer list for concerts. Implement methods to display event details and check for conflicts in the event schedule.

Sample Solution:

Java Code:
```java
Event.java

import java.util.Date;

// Define the Event class
class Event {
    String eventName;
    Date date;
    String location;

    public Event(String eventName, Date date, String location) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
    }

    public void displayDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Location: " + location);
    }

    public boolean isConflict(Event otherEvent) {
        return this.date.equals(otherEvent.date) && this.location.equals(otherEvent.location);
    }
}
```
Explanation:

Import statement: Imports the Date class from java.util.
Class definition: Defines the Event class.
Attributes: Declares three attributes: eventName (String), date (Date), and location (String).
Constructor: Initializes the eventName, date, and location attributes.
displayDetails() method: Prints the event's name, date, and location.
isConflict() method: Checks if the current event conflicts with another event by comparing their dates and locations.
```java
Seminar.java

import java.util.Date;
import java.util.List;
// Define the Seminar class that extends Event
class Seminar extends Event {
    int numberOfSpeakers;

    public Seminar(String eventName, Date date, String location, int numberOfSpeakers) {
        super(eventName, date, location);
        this.numberOfSpeakers = numberOfSpeakers;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Speakers: " + numberOfSpeakers);
    }
}
```
Explanation:

Import statements: Imports the 'Date' and 'List' classes from java.util.
Class definition: Defines the Seminar class, which extends the Event class.
Additional attribute: Declares 'numberOfSpeakers' (int) specific to the Seminar class.
Constructor: Initializes eventName, date, location (inherited from Event), and numberOfSpeakers.
Override displayDetails() method: Calls the displayDetails() method of the Event class and adds the number of speakers to the output.
```java
MusicalPerformance.java

import java.util.List;
import java.util.Date;
// Define the MusicalPerformance class that extends Event
class MusicalPerformance extends Event {
    List performers;

    public MusicalPerformance(String eventName, Date date, String location, List performers) {
        super(eventName, date, location);
        this.performers = performers;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Performers: " + String.join(", ", performers));
    }
}
```
Explanation:

Import statements: Imports the 'List' and 'Date' classes from java.util.
Class definition: Defines the MusicalPerformance class, which extends the Event class.
Additional attribute: Declares performers (List of Strings) specific to the MusicalPerformance class.
Constructor: Initializes eventName, date, location (inherited from Event), and performers.
Override displayDetails() method: Calls the displayDetails() method of the Event class and adds the list of performers to the output, formatted as a comma-separated string using String.join().
```java
Main.java

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Main class to test the Event, Seminar, and MusicalPerformance classes
public class Main {
    public static void main(String[] args) {
        
		// Create different dates to avoid conflict
		// Create a date for testing
        Date date = new Date();

        // Create an instance of Seminar
        Seminar seminar = new Seminar("Space Conference", date, "Convention Center", 5);

        // Create an instance of MusicalPerformance
        List performers = new ArrayList<>();
        performers.add("Band A");
        performers.add("Band B");
        MusicalPerformance concert = new MusicalPerformance("Winter Fest", date, "Convention Center", performers);

        // Display details of the seminar
        System.out.println("Seminar Details:");
        seminar.displayDetails();

        // Display details of the musical performance
        System.out.println("\nMusical Performance Details:");
        concert.displayDetails();

        // Check for scheduling conflict
        if (seminar.isConflict(concert)) {
            System.out.println("\nConflict detected: Both events are scheduled at the same time and location.");
        } else {
            System.out.println("\nNo conflict: Events are scheduled at different times or locations.");
        }
    }
}
```
Explanation:

Import statements: Import the 'ArrayList', 'Date', and 'List' classes from java.util.
Main class definition: Defines the Main class to test the Event, Seminar, and 'MusicalPerformance' classes.
main method: Contains the main logic for testing.
Import statements: Import the 'ArrayList', 'Date', and 'List' classes from java.util.
Create a date instance: Initializes a Date object for testing.
Create an instance of Seminar: Instantiates a Seminar object with specific attributes.
Create an instance of MusicalPerformance:
Import statements: Import the 'ArrayList', 'Date', and 'List' classes from java.util.
Initializes a list of performers.
Instantiates a MusicalPerformance object with specific attributes.
Display details of the seminar: Calls the 'displayDetails()' method on the seminar object.
Display details of the musical performance: Calls the 'displayDetails()' method on the concert object.
Check for scheduling conflict: Uses the isConflict() method to determine if the seminar and concert are scheduled at the same time and location, and prints an appropriate message based on the result.
Output:

Seminar Details:
Event Name: Space Conference
Date: Sat Jun 08 08:05:33 IST 2024
Location: Convention Center
Number of Speakers: 5

Musical Performance Details:
Event Name: Winter Fest
Date: Sat Jun 08 08:05:33 IST 2024
Location: Convention Center
Performers: Band A, Band B
Conflict detected: Both events are scheduled at the same time and location.


### 27. Write a Java program to create a class called "CustomerOrder" with attributes for order ID, customer, and order date. Create a subclass "OnlineOrder" that adds attributes for delivery address and tracking number. Implement methods to calculate delivery time based on the address and update the tracking status.

Write a Java program to create a class called "CustomerOrder" with attributes for order ID, customer, and order date. Create a subclass "OnlineOrder" that adds attributes for delivery address and tracking number. Implement methods to calculate delivery time based on the address and update the tracking status.

Sample Solution:

Java Code:
```java
CustomerOrder.java

// Import necessary classes for date handling
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Define the CustomerOrder class
public class CustomerOrder {
    // Attributes for order ID, customer, and order date
    private String orderId;
    private String customer;
    private LocalDate orderDate;

    // Constructor to initialize the CustomerOrder object
    public CustomerOrder(String orderId, String customer, LocalDate orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    // Getter for order ID
    public String getOrderId() {
        return orderId;
    }

    // Getter for customer
    public String getCustomer() {
        return customer;
    }

    // Getter for order date
    public LocalDate getOrderDate() {
        return orderDate;
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer);
        System.out.println("Order Date: " + orderDate);
    }
}
```
Explanation:

CustomerOrder Class:

Attributes: orderId, customer, and orderDate.
Constructor: Initializes the attributes.
Methods:
displayOrderDetails(): Displays the order details.
Getters: getOrderId(), getCustomer(), getOrderDate().
```java
OnlineOrder.java

// Import necessary classes for date handling
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
// Define the OnlineOrder subclass that extends CustomerOrder
class OnlineOrder extends CustomerOrder {
    // Additional attributes for delivery address and tracking number
    private String deliveryAddress;
    private String trackingNumber;

    // Constructor to initialize the OnlineOrder object
    public OnlineOrder(String orderId, String customer, LocalDate orderDate, String deliveryAddress, String trackingNumber) {
        // Call the superclass constructor to initialize common attributes
        super(orderId, customer, orderDate);
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
    }

    // Getter for delivery address
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    // Getter for tracking number
    public String getTrackingNumber() {
        return trackingNumber;
    }

    // Method to calculate delivery time based on the address (dummy logic for demonstration)
    public int calculateDeliveryTime() {
        // Dummy logic: Assuming delivery time is based on the length of the address string
        return deliveryAddress.length() % 10 + 1; // Just a placeholder logic
    }

    // Method to update the tracking status (dummy logic for demonstration)
    public void updateTrackingStatus(String newStatus) {
        // Dummy logic: Print the updated tracking status
        System.out.println("Tracking Number: " + trackingNumber + " - Status: " + newStatus);
    }

    // Override the displayOrderDetails method to include additional details
    @Override
    public void displayOrderDetails() {
        // Call the superclass method to display common details
        super.displayOrderDetails();
        // Display additional details for online order
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Tracking Number: " + trackingNumber);
    }
}
```
Explanation:

OnlineOrder Subclass:

Extends CustomerOrder.
Additional Attributes: deliveryAddress and trackingNumber.
Constructor: Initializes the attributes, calling the superclass constructor for the common attributes.
Methods:
calculateDeliveryTime(): Dummy logic to calculate delivery time based on the address.
updateTrackingStatus(String newStatus): Dummy logic to update the tracking status.
Overrides displayOrderDetails() to include additional details for online orders.
Getters: getDeliveryAddress(), getTrackingNumber().
```java
Main.java

// Import necessary classes for date handling
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
// Main class to test the CustomerOrder and OnlineOrder classes
public class Main {
    public static void main(String[] args) {
        // Create a CustomerOrder object
        CustomerOrder order = new CustomerOrder("ORD023", "Asih Wanjiku", LocalDate.now());
        // Display the order details
        order.displayOrderDetails();
        System.out.println();

        // Create an OnlineOrder object
        OnlineOrder onlineOrder = new OnlineOrder("ORD034", "Kai Biserka", LocalDate.now(), "123 ABC Street, Springfield", "STR455");
        // Display the online order details
        onlineOrder.displayOrderDetails();
        // Calculate and display the delivery time
        int deliveryTime = onlineOrder.calculateDeliveryTime();
        System.out.println("Estimated Delivery Time: " + deliveryTime + " days");
        // Update and display the tracking status
        onlineOrder.updateTrackingStatus("In Transit");
    }
}
```
Explanation:

Main Method:
public static void main(String[] args): The entry point of the program.
Creating a CustomerOrder Object:
CustomerOrder order = new CustomerOrder("ORD023", "Asih Wanjiku", LocalDate.now());: Creates a CustomerOrder object with order ID "ORD023", customer name "Asih Wanjiku", and the current date.
Displaying CustomerOrder Details:
order.displayOrderDetails();: Calls the method to display details of the CustomerOrder object.
System.out.println();: Prints an empty line for separation.
Creating an OnlineOrder Object:
OnlineOrder onlineOrder = new OnlineOrder("ORD034", "Kai Biserka", LocalDate.now(), "123 ABC Street, Springfield", "STR455");: Creates an OnlineOrder object with order ID "ORD034", customer name "Kai Biserka", current date, delivery address "123 ABC Street, Springfield", and tracking number "STR455".
Displaying OnlineOrder Details:
onlineOrder.displayOrderDetails();: Calls the method to display details of the OnlineOrder object.
Calculating and Displaying Delivery Time:
int deliveryTime = onlineOrder.calculateDeliveryTime();: Calls the method to calculate the delivery time based on the delivery address.
System.out.println("Estimated Delivery Time: " + deliveryTime + " days");: Prints the estimated delivery time.
Updating and Displaying Tracking Status:
onlineOrder.updateTrackingStatus("In Transit");: Calls the method to update the tracking status to "In Transit".
Output:

Order ID: ORD023
Customer: Asih Wanjiku
Order Date: 2024-06-10

Order ID: ORD034
Customer: Kai Biserka
Order Date: 2024-06-10
Delivery Address: 123 ABC Street, Springfield
Tracking Number: STR455
Estimated Delivery Time: 8 days
Tracking Number: STR455 - Status: In Transit

### 28. Write a Java program to create a class called "Reservation" with attributes for reservation ID, customer name, and date. Create subclasses "ResortReservation" and "RailwayReservation" that add specific attributes like room number for hotels and seat number for flights. Implement methods to check reservation status and modify reservation details.

Write a Java program to create a class called "Reservation" with attributes for reservation ID, customer name, and date. Create subclasses "ResortReservation" and "RailwayReservation" that add specific attributes like room number for hotels and seat number for flights. Implement methods to check reservation status and modify reservation details.

Sample Solution:

Java Code:
```java
Reservation.java

// Import necessary classes for date handling
import java.time.LocalDate;

// Define the Reservation class
public class Reservation {
    // Attributes for reservation ID, customer name, and date
    private String reservationId;
    private String customerName;
    private LocalDate date;

    // Constructor to initialize the Reservation object
    public Reservation(String reservationId, String customerName, LocalDate date) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.date = date;
    }

    // Method to check reservation status
    public void checkReservationStatus() {
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Date: " + date);
        System.out.println("Status: Confirmed");
    }

    // Method to modify reservation details
    public void modifyReservation(String newCustomerName, LocalDate newDate) {
        this.customerName = newCustomerName;
        this.date = newDate;
        System.out.println("Reservation modified successfully.");
    }

    // Getters for the attributes
    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getDate() {
        return date;
    }
}
```
Explanation:

Define the Reservation class: The Reservation class represents a generic reservation.
Attributes for reservation ID, customer name, and date:
private String reservationId: Stores the reservation ID.
private String customerName: Stores the customer's name.
private LocalDate date: Stores the reservation date.
Constructor to initialize the Reservation object: Initializes the reservationId, customerName, and date attributes with the provided values.
Method to check reservation status:
public void checkReservationStatus(): Prints the reservation ID, customer name, date, and a status message ("Confirmed") to the console.
Method to modify reservation details:
public void modifyReservation(String newCustomerName, LocalDate newDate): Updates the customerName and date attributes with the new values provided and prints a confirmation message to the console.
Getters for the attributes:
public String getReservationId(): Returns the reservation ID.
public String getCustomerName(): Returns the customer's name.
public LocalDate getDate(): Returns the reservation date.
```java
ResortReservation.java

// Import necessary classes for date handling
import java.time.LocalDate;
// Define the ResortReservation subclass that extends Reservation
public class ResortReservation extends Reservation {
    // Additional attribute for the room number
    private int roomNumber;

    // Constructor to initialize the ResortReservation object
    public ResortReservation(String reservationId, String customerName, LocalDate date, int roomNumber) {
        super(reservationId, customerName, date); // Call the superclass constructor
        this.roomNumber = roomNumber;
    }

    // Method to check reservation status including room number
    @Override
    public void checkReservationStatus() {
        super.checkReservationStatus(); // Call the superclass method
        System.out.println("Room Number: " + roomNumber);
    }

    // Method to modify reservation details including room number
    public void modifyReservation(String newCustomerName, LocalDate newDate, int newRoomNumber) {
        super.modifyReservation(newCustomerName, newDate); // Call the superclass method
        this.roomNumber = newRoomNumber;
        System.out.println("Room Number updated successfully.");
    }

    // Getter for the room number
    public int getRoomNumber() {
        return roomNumber;
    }
}
```
Explanation:

Define the ResortReservation subclass that extends Reservation: The ResortReservation class is defined as a subclass of Reservation, inheriting its attributes and methods.
Additional attribute for the room number:
private int roomNumber: Stores the room number specific to resort reservations.
Constructor to initialize the ResortReservation object:
Initializes the reservationId, customerName, and date attributes by calling the superclass (Reservation) constructor.
Initializes the roomNumber attribute with the provided value.
Method to check reservation status including room number:
@Override: Indicates that this method overrides the checkReservationStatus method from the Reservation class.
public void checkReservationStatus(): Calls the superclass method to print the reservation details and then prints the room number.
Method to modify reservation details including room number:
public void modifyReservation(String newCustomerName, LocalDate newDate, int newRoomNumber): Updates the customerName and date attributes by calling the superclass method and updates the roomNumber attribute with the new value. Prints a confirmation message for the room number update.
Getter for the room number:
public int getRoomNumber(): Returns the room number.
```java
RailwayReservation.java

// Import necessary classes for date handling
import java.time.LocalDate;
// Define the RailwayReservation subclass that extends Reservation
public class RailwayReservation extends Reservation {
    // Additional attribute for the seat number
    private int seatNumber;

    // Constructor to initialize the RailwayReservation object
    public RailwayReservation(String reservationId, String customerName, LocalDate date, int seatNumber) {
        super(reservationId, customerName, date); // Call the superclass constructor
        this.seatNumber = seatNumber;
    }

    // Method to check reservation status including seat number
    @Override
    public void checkReservationStatus() {
        super.checkReservationStatus(); // Call the superclass method
        System.out.println("Seat Number: " + seatNumber);
    }

    // Method to modify reservation details including seat number
    public void modifyReservation(String newCustomerName, LocalDate newDate, int newSeatNumber) {
        super.modifyReservation(newCustomerName, newDate); // Call the superclass method
        this.seatNumber = newSeatNumber;
        System.out.println("Seat Number updated successfully.");
    }

    // Getter for the seat number
    public int getSeatNumber() {
        return seatNumber;
    }
}
```
Explanation:

Define the RailwayReservation subclass that extends Reservation: The RailwayReservation class is defined as a subclass of Reservation, inheriting its attributes and methods.
Additional attribute for the seat number:
private int seatNumber: Defines an attribute to store the seat number specific to railway reservations.
Constructor to initialize the RailwayReservation object:
Calls the superclass (Reservation) constructor to initialize reservationId, customerName, and date.
Initializes the seatNumber attribute with the provided value.
Method to check reservation status including seat number:
@Override: Indicates this method overrides the checkReservationStatus method from the Reservation class.
Calls the superclass method to print the general reservation details and then prints the seat number.
Method to modify reservation details including seat number:
Updates customerName and date by calling the superclass method.
Updates the seatNumber attribute with the new value and prints a confirmation message for the seat number update.
Getter for the seat number:
public int getSeatNumber(): Returns the seat number attribute.
```java
Main.java

// Import necessary classes for date handling
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a ResortReservation object
        ResortReservation resortReservation = new ResortReservation("RSV001", "Celestino Aspasia", LocalDate.now(), 101);
        // Display the resort reservation details and status
        resortReservation.checkReservationStatus();
        System.out.println();
        
        // Modify the resort reservation details
        resortReservation.modifyReservation("Celestino Aspasia", LocalDate.of(2024, 6, 15), 102);
        resortReservation.checkReservationStatus();
        System.out.println();

        // Create a RailwayReservation object
        RailwayReservation railwayReservation = new RailwayReservation("RSV002", "John Paul Pythios", LocalDate.now(), 22);
        // Display the railway reservation details and status
        railwayReservation.checkReservationStatus();
        System.out.println();
        
        // Modify the railway reservation details
        railwayReservation.modifyReservation("Bob Smith", LocalDate.of(2024, 6, 20), 23);
        railwayReservation.checkReservationStatus();
    }
}
```
Explanation:

Define the Main class:
Contains the main method to test the functionality of ResortReservation and RailwayReservation.
Create a ResortReservation object:
Initializes a ResortReservation object with reservation ID "RSV001", customer name "Celestino Aspasia", current date, and room number 101.
Display the resort reservation details and status:
Calls checkReservationStatus to display the reservation details including room number.
Modify the resort reservation details:
Calls modifyReservation to update the customer name, date to June 15, 2024, and room number to 102.
Displays the updated reservation details and status by calling checkReservationStatus again.
Create a RailwayReservation object:
Initializes a RailwayReservation object with reservation ID "RSV002", customer name "John Paul Pythios", current date, and seat number 22.
Display the railway reservation details and status:
Calls checkReservationStatus to display the reservation details including seat number.
Modify the railway reservation details:
Calls modifyReservation to update the customer name to "Bob Smith", date to June 20, 2024, and seat number to 23.
Displays the updated reservation details and status by calling checkReservationStatus again.
Output:

Reservation ID: RSV001
Customer Name: Celestino Aspasia
Date: 2021-06-10
Status: Confirmed
Room Number: 101

Reservation modified successfully.
Room Number updated successfully.
Reservation ID: RSV001
Customer Name: Celestino Aspasia
Date: 2021-06-15
Status: Confirmed
Room Number: 102

Reservation ID: RSV002
Customer Name: John Paul Pythios
Date: 2021-06-10
Status: Confirmed
Seat Number: 22

Reservation modified successfully.
Seat Number updated successfully.
Reservation ID: RSV002
Customer Name: Bob Smith
Date: 2021-06-20
Status: Confirmed
Seat Number: 23

### 29. Write a Java program to create a class called "Pet" with attributes for name, species, and age. Create subclasses "Dog" and "Bird" that add specific attributes like favorite toy for dogs and wing span for birds. Implement methods to display pet details and calculate the pet's age in human years.

Write a Java program to create a class called " Pet" with attributes for name, species, and age. Create subclasses " Dog" and "Bird" that add specific attributes like favorite toy for  dogs and wing span for birds. Implement methods to display  pet details and calculate the  pet's age in human years.

Sample Solution:

Java Code:
```java
Pet.java

// Define the Pet class
class Pet {
    // Attributes for the Pet class
    String name;
    String species;
    int age;

    // Constructor for the Pet class
    public Pet(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    // Method to display pet details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age + " years");
    }

    // Method to calculate pet's age in human years
    public int calculateHumanAge() {
        if (species.equals("Dog")) {
            return age * 7;
        } else {
            // Assuming bird's age in human years is the same as actual age
            return age;
        }
    }
}
```
Explanation:

Class definition: Defines the  Pet class.
Attributes: Declares three attributes: name (String), species (String), and age (int).
Constructor: Initializes the name, species, and age attributes with provided values.
displayDetails() method: Prints the  pet's name, species, and age to the console.
calculateHumanAge() method:
Check if the species is " Dog".
If true, returns the  pet's age multiplied by 7 ( dog's age in human years).
Otherwise, returns the actual age (assuming birds' age in human years is the same as their actual age).
```java
Dog.java

// Define the Dog class that extends Pet
class Dog extends Pet {
    // Additional attribute for Dog
    String favoriteToy;

    // Constructor for the Dog class
    public Dog(String name, int age, String favoriteToy) {
        super(name, "Dog", age); // Call the constructor of the superclass
        this.favoriteToy = favoriteToy;
    }

    // Override the displayDetails method to include favorite toy
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Favorite Toy: " + favoriteToy);
    }
}
```
Explanation:

Class definition: Defines the  Dog class, which extends the  Pet class.
Additional attribute: Declares favoriteToy (String) specific to the  Dog class.
Constructor:
Initializes the name, age, and favoriteToy attributes.
Override displayDetails() method:
Calls the displayDetails() method of the Pet class.
Adds a line to print the dog's favorite toy.
```java
Bird.java

// Define the Bird class that extends Pet
class Bird extends Pet {
    // Additional attribute for Bird
    double wingSpan;

    // Constructor for the Bird class
    public Bird(String name, int age, double wingSpan) {
        super(name, "Bird", age); // Call the constructor of the superclass
        this.wingSpan = wingSpan;
    }

    // Override the displayDetails method to include wing span
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Wing Span: " + wingSpan + " meters");
    }
}
```
Explanation:

Class definition: Defines the Bird class, which extends the  Pet class.
Additional attribute: Declares wingSpan (double) specific to the Bird class.
Constructor:
Initializes the name, age, and wingSpan attributes.
Calls the superclass constructor with name, "Bird" (as species), and age.
Override displayDetails() method:
Calls the displayDetails() method of the  Pet class.
Add a line to print the bird's wing span in meters.
```java
Main.java

// Main class to test the Pet, Dog, and Bird classes
public class Main {
    public static void main(String[] args) {
        // Create an instance of Dog
        Dog dog = new Dog("Cooper", 3, "Ball");

        // Create an instance of Bird
        Bird bird = new Bird("Pelican", 2, 0.5);

        // Display details of the dog
        System.out.println("Dog Details:");
        dog.displayDetails();
        System.out.println("Dog's age in human years: " + dog.calculateHumanAge());

        // Display details of the bird
        System.out.println("\nBird Details:");
        bird.displayDetails();
        System.out.println("Bird's age in human years: " + bird.calculateHumanAge());
    }
}
```
Explanation:

Class definition: Defines the Main class to test the  Pet,  Dog, and Bird classes.
main method: Contains the main logic for testing.
Create an instance of  Dog: Instantiates a Dog object named "Cooper" with age 3 and favorite toy "Ball".
Create an instance of Bird: Instantiates a Bird object named "Pelican" with age 2 and a wing span of 0.5 meters.
Display details of the  dog:
Prints "Dog Details:" to the console.
Calls dog.displayDetails() to print the dog's details.
Calls dog.calculateHumanAge() to print the dog's age in human years.
Display details of the bird:
Prints "\nBird Details:" to the console.
Calls bird.displayDetails() to print the bird's details.
Calls bird.calculateHumanAge() to print the bird's age in human years.
Output:

Dog Details:
Name: Cooper
Species: Dog
Age: 3 years
Favorite Toy: Ball
Dog's age in human years: 21

Bird Details:
Name: Pelican
Species: Bird
Age: 2 years
Wing Span: 0.5 meters
Bird's age in human years: 2

### 30. Write a Java program to create a class called "GymMembership" with attributes for member name, membership type, and duration. Create a subclass "PremiumMembership" that adds attributes for personal trainer availability and spa access. Implement methods to calculate membership fees and check for special offers based on membership type.

Write a Java program to create a class called "GymMembership" with attributes for member name, membership type, and duration. Create a subclass "PremiumMembership" that adds attributes for personal trainer availability and spa access. Implement methods to calculate membership fees and check for special offers based on membership type.

Sample Solution:

Java Code:
```java
GymMembership.java

// Define the GymMembership class
class GymMembership {
    // Attributes for GymMembership
    String memberName;
    String membershipType;
    int duration; // in months

    // Constructor for GymMembership
    public GymMembership(String memberName, String membershipType, int duration) {
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.duration = duration;
    }

    // Method to calculate membership fees
    public double calculateFees() {
        double baseFee = 50.0; // Base fee per month
        return baseFee * duration;
    }

    // Method to check for special offers
    public String checkSpecialOffers() {
        if (membershipType.equalsIgnoreCase("annual")) {
            return "10% discount on annual membership.";
        } else {
            return "No special offers available.";
        }
    }

    // Method to display membership details
    public void displayDetails() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Membership Fees: $" + calculateFees());
        System.out.println("Special Offers: " + checkSpecialOffers());
    }
}
```
Explanation:

Class definition: Defines the GymMembership class.
Attributes: Declares three attributes: memberName (String), membershipType (String), and duration (int, in months).
Constructor: Initializes the memberName, membershipType, and duration attributes with provided values.
calculateFees() method:
Sets a base fee of $50.0 per month.
Returns the total fee by multiplying the base fee with the duration in months.
checkSpecialOffers() method:
Checks if the membership type is "annual".
Returns a 10% discount message if the membership type is annual.
Returns a message indicating no special offers for other membership types.
displayDetails() method:
Prints the member's name, membership type, and duration.
Calls calculateFees() to print the total membership fees.
Calls checkSpecialOffers() to print any applicable special offers.
```java
PremiumMembership.java

// Define the PremiumMembership class that extends GymMembership
class PremiumMembership extends GymMembership {
    // Additional attributes for PremiumMembership
    boolean personalTrainerAvailable;
    boolean spaAccess;

    // Constructor for PremiumMembership
    public PremiumMembership(String memberName, String membershipType, int duration, boolean personalTrainerAvailable, boolean spaAccess) {
        super(memberName, membershipType, duration);
        this.personalTrainerAvailable = personalTrainerAvailable;
        this.spaAccess = spaAccess;
    }

    // Override the calculateFees method to include additional costs
    @Override
    public double calculateFees() {
        double baseFee = super.calculateFees();
        double additionalFee = 0.0;

        if (personalTrainerAvailable) {
            additionalFee += 30.0 * duration; // Additional fee per month for personal trainer
        }
        if (spaAccess) {
            additionalFee += 20.0 * duration; // Additional fee per month for spa access
        }
        return baseFee + additionalFee;
    }

    // Override the displayDetails method to include premium details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Personal Trainer Available: " + (personalTrainerAvailable ? "Yes" : "No"));
        System.out.println("Spa Access: " + (spaAccess ? "Yes" : "No"));
    }
}
```
Explanation:

Class definition: Defines the PremiumMembership class, which extends GymMembership.
Additional attributes: Declares two attributes: personalTrainerAvailable (boolean) and spaAccess (boolean).
Constructor:
Calls the superclass (GymMembership) constructor to initialize memberName, membershipType, and duration.
Initializes personalTrainerAvailable and spaAccess attributes with provided values.
Override calculateFees() method:
Calls the superclass method super.calculateFees() to get the base fee.
Adds additional fees if personalTrainerAvailable and spaAccess are true.
Returns the total fee, which includes the base fee and any additional fees.
Override displayDetails() method:
Calls the superclass method super.displayDetails() to display base details.
Adds lines to print whether a personal trainer is available and whether spa access is available.
```java
Main.java

// Main class to test the GymMembership and PremiumMembership classes
public class Main {
    public static void main(String[] args) {
        // Create an instance of GymMembership
        GymMembership basicMember = new GymMembership("Njeri Inka", "Monthly", 6);

        // Create an instance of PremiumMembership
        PremiumMembership premiumMember = new PremiumMembership("Willy Diantha", "Annual", 12, true, true);

        // Display details of the basic membership
        System.out.println("Basic Membership Details:");
        basicMember.displayDetails();

        // Display details of the premium membership
        System.out.println("\nPremium Membership Details:");
        premiumMember.displayDetails();
    }
}
```
Explanation:

Class definition: Defines the Main class to test GymMembership and PremiumMembership classes.
main method: Entry point of the program.
Create an instance of GymMembership:
Instantiates a GymMembership object named basicMember.
Initializes with memberName as "Njeri Inka", membershipType as "Monthly", and duration as 6 months.
Create an instance of PremiumMembership:
Instantiates a PremiumMembership object named premiumMember.
Initializes with memberName as "Willy Diantha", membershipType as "Annual", duration as 12 months, personalTrainerAvailable as true, and spaAccess as true.
Display details of the basic membership:
Prints "Basic Membership Details:" to the console.
Calls basicMember.displayDetails() to print the details of the basic membership.
Display details of the premium membership:
Prints "\nPremium Membership Details:" to the console.
Calls premiumMember.displayDetails() to print the details of the premium membership.
Output:

Basic Membership Details:
Member Name: Njeri Inka
Membership Type: Monthly
Duration: 6 months
Membership Fees: $300.0
Special Offers: No special offers available.

Premium Membership Details:
Member Name: Willy Diantha
Membership Type: Annual
Duration: 12 months
Membership Fees: $1200.0
Special Offers: 10% discount on annual membership.
Personal Trainer Available: Yes
Spa Access: Yes
