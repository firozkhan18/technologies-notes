# Java Exercises Inheritance


Java Inheritance: In the Java language, classes can be derived from other classes, thereby inheriting fields and methods from those classes.

Definitions: A class that is derived from another class is called a subclass (also a derived class, extended class, or child class). The class from which the subclass is derived is called a superclass (also a base class or a parent class).

Excepting Object, which has no superclass, every class has one and only one direct superclass (single inheritance). In the absence of any other explicit superclass, every class is implicitly a subclass of Object.

Classes can be derived from classes that are derived from classes that are derived from classes, and so on, and ultimately derived from the topmost class, Object. Such a class is said to be descended from all the classes in the inheritance chain stretching back to Object.


[An  editor is available at the bottom of the page to write and execute the scripts. Go to the editor]

### 1. Write a Java program to create a class called Animal with a method called makeSound(). Create a subclass called Cat that overrides the makeSound() method to bark.

Write a Java program to create a class called Animal with a method called makeSound(). Create a subclass called Cat that overrides the makeSound() method to bark.

This exercise shows how inheritance works in Java  programming language. Inheritance allows you to create new classes based on existing classes, inheriting their attributes and behaviors. In this case, the 'Cat' class is a more specific implementation of the 'Animal' class, adding quarrel behavior.

Sample Solution:

Java Code:
```java
// Define a public class named Animal
public class Animal {
    // Define a public method named makeSound
    public void makeSound() {
        // Print "The animal makes a sound." to the console
        System.out.println("The animal makes a sound.");
    }
} 
```
The above code defines a Java class named "Animal". Within this class, there is a method called "makeSound()". When this method is called, it prints the message "The animal makes a sound." to the console. Essentially, this class serves as a blueprint for creating objects representing generic animals that can make a sound. However, the specific sound is not defined here.
```java
// Define a public class named Cat that extends Animal
public class Cat extends Animal {
    // Use the @Override annotation to indicate that this method overrides a method in the superclass
    @Override
    // Define the makeSound method
    public void makeSound() {
        // Print "The cat quarrels." to the console
        System.out.println("The cat quarrels.");
    }
}
```
The above code defines a Java class named "Cat" that extends another class called "Animal". Within the "Cat" class, there is a method called "makeSound()" that overrides the same method from the "Animal" class. When this method is called for a 'Cat' object, it prints the message "The cat quarrels." to the console. This means that 'Cat' is a specific type of 'Animal' and has its own unique sound, which is defined in this method.
```java
// Define a public class named Main
public class Main {
    // Define the main method
    public static void main(String[] args) {
        // Create an instance of Animal
        Animal animal = new Animal();
        // Create an instance of Cat
        Cat cat = new Cat();
        // Call the makeSound method on the animal instance
        animal.makeSound();
        // Call the makeSound method on the cat instance
        cat.makeSound();
    }
}
```
The above code defines a Java class named 'Main' with a 'main' method. Inside the 'main' method:

An 'Animal' object named 'animal' is created.

A 'Cat' object named 'cat' is created.

Both 'Animal' and 'Cat' are classes defined elsewhere in the code. They have a method called 'makeSound()'.


Then, the 'makeSound()' method is called on both the 'animal' and 'cat' objects:

'animal.makeSound()' calls the 'makeSound()' method of the 'Animal' class, which prints "The animal makes a sound." to the console.

'cat.makeSound()' calls the overridden 'makeSound()' method of the 'Cat' class, which prints "The cat quarrels." to the console.

Output:

The animal makes a sound.
The cat quarrels. 
Explanation:

The above exercise demonstrates Java programming inheritance. In this program, we create a base class called 'Animal' with a method named makeSound(). Then, you will create a subclass of 'Animal' called 'Cat' which inherits from 'Animal'. The 'Cat' class will override the makeSound() method and change it to make a quarrel sound.

### 2. Write a Java program to create a class called Vehicle with a method called drive(). Create a subclass called Car that overrides the drive() method to print "Repairing a car".

Write a Java program to create a class called  Vehicle with a method called drive(). Create a subclass called  Car that overrides the drive() method to print "Repairing a  car".

This program creates a class called ' Vehicle' with a method called drive() and a subclass called  Car that overrides the drive() method to print "Repairing a car".

Sample Solution:

Java Code:
```java
// Define the parent class Vehicle
class Vehicle {
    // Define a public method named drive
    public void drive() {
        // Print "Repairing a vehicle" to the console
        System.out.println("Repairing a vehicle");
    }
} 
```
The above code defines a Java class named Vehicle. Inside this class:


There is a method called drive(), which prints "Repairing a vehicle" to the console.
```java
// Define the child class Car that extends Vehicle
class Car extends Vehicle {
    // Use the @Override annotation to indicate that this method overrides a method in the superclass
    @Override
    // Define the drive method
    public void drive() {
        // Print "Repairing a car" to the console
        System.out.println("Repairing a car");
    }
}
```
The above code defines a Java class named  Car, which is a child class that extends the parent class  Vehicle. Inside this class:

There is a method named drive(), which overrides the drive() method from the parent class  Vehicle. The overridden method prints "Repairing a  car" to the console.
```java
// Define the main class
public class Main {
    // Define the main method
    public static void main(String[] args) {
        // Create an instance of Vehicle
        Vehicle vehicle = new Vehicle();
        // Create an instance of Car
        Car car = new Car();
        // Call the drive method on the vehicle instance
        vehicle.drive(); // Output: Repairing a vehicle
        // Call the drive method on the car instance
        car.drive(); // Output: Repairing a car
    }
}
```
In the exercise above -

An instance of the  Vehicle class is created and stored in the variable  vehicle.

An instance of the  Car class is created and stored in the variable car.

The drive() method is called on the vehicle object, resulting in the output "Repairing a vehicle."

The drive() method is called on the car object, resulting in the output "Repairing a car."

Output:

Repairing a vehicle
Repairing a car

Explanation:

In this program, we first define a parent class called Vehicle with a method called drive() which simply prints " Repairing a vehicle" to the console.

Then, we create a subclass called  Car that extends  Vehicle and overrides the drive() method to print " Repairing a  car" instead.

In the main() method, we create an instance of both the  Vehicle and  Car classes, and call the drive() method on each object. The output of the first call to drive() will be "Repairing a vehicle", while the output of the second call to drive() will be "Repairing a car", as defined in the Car class.

### 3. Write a Java program to create a class called Shape with a method called getArea(). Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.

Write a Java program to create a class called Shape with a method called getArea(). Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.

Sample Solution:

Java Code:
```java
// Define the parent class Shape
public class Shape {
    // Define a public method named getArea that returns a double
    public double getArea() {
        // Return 0.0 as the default area
        return 0.0;
    }
} 

// Define the child class Rectangle that extends Shape
public class Rectangle extends Shape {
    // Define private instance variables length and width
    private double length;
    private double width;
    
    // Define the constructor that takes length and width as parameters
    public Rectangle(double length, double width) {
        // Assign the length parameter to the instance variable length
        this.length = length;
        // Assign the width parameter to the instance variable width
        this.width = width;
    }
    
    // Use the @Override annotation to indicate that this method overrides a method in the superclass
    @Override
    // Define the getArea method that returns a double
    public double getArea() {
        // Return the area of the rectangle (length * width)
        return length * width;
    }
} 
// Define the main class
public class Main {
    // Define the main method
    public static void main(String[] args) {
        // Create an instance of Rectangle with length 3.0 and width 10.0
        Rectangle rectangle = new Rectangle(3.0, 10.0);
        // Call the getArea method on the rectangle instance and store the result in the area variable
        double area = rectangle.getArea();
        // Print the area of the rectangle to the console
        System.out.println("The area of the rectangle is: " + area);
    }
}
```
Output:

The area of the rectangle is: 30.0
Explanation:

In the above exercise, the Shape class has a single method called getArea() that returns a double value. The Rectangle class is a subclass of Shape and overrides the getArea() method to calculate the area of a rectangle using the formula length x width. The Rectangle class constructor sets length and width values.

### 4. Write a Java program to create a class called Employee with methods called work() and getSalary(). Create a subclass called HRManager that overrides the work() method and adds a new method called addEmployee().

Write a Java program to create a class called Employee with methods called work() and getSalary(). Create a subclass called HRManager that overrides the work() method and adds a new method called addEmployee().

Sample Solution:

Java Code:
```java
// Employee.java
// Parent class Employee
public class Employee {

    // Private field to store the salary of the employee
    private int salary;

    // Constructor to initialize the salary of the employee
    public Employee(int salary) {
        this.salary = salary;
    }

    // Method to simulate the employee working
    public void work() {
        // Print a message indicating the employee is working
        System.out.println("working as an employee!");
    }

    // Getter method to retrieve the salary of the employee
    public int getSalary() {
        return salary;
    }
} 

// HRManager.java
// Child class HRManager
public class HRManager extends Employee {

    // Constructor to initialize the salary of the HRManager
    public HRManager(int salary) {
        // Call the parent class constructor with the salary
        super(salary);
    }

    // Overridden method to simulate the HRManager working
    public void work() {
        // Print a message indicating the HRManager is managing employees
        System.out.println("\nManaging employees");
    }

    // Method to simulate adding a new employee
    public void addEmployee() {
        // Print a message indicating a new employee is being added
        System.out.println("\nAdding new employee!");
    }
}
// Main.java
// Main class
public class Main {

    // Main method
    public static void main(String[] args) {
        // Create an Employee object with a salary of 40000
        Employee emp = new Employee(40000);

        // Create an HRManager object with a salary of 70000
        HRManager mgr = new HRManager(70000);

        // Call the work method on the Employee object
        emp.work();

        // Print the salary of the Employee object
        System.out.println("Employee salary: " + emp.getSalary());

        // Call the work method on the HRManager object
        mgr.work();

        // Print the salary of the HRManager object
        System.out.println("Manager salary: " + mgr.getSalary());

        // Call the addEmployee method on the HRManager object
        mgr.addEmployee();
    }
}
```
Output:

working as an employee!
Employee salary: 40000

Managing employees
Manager salary: 70000

Adding new employee!
Explanation:

In the above exercise, the Employee class has a work() method that prints a message and a getSalary() method that returns the employee's salary. The HRManager subclass extends the Employee class and overrides the work() method to display a different message. It adds a method addEmployee() that prints a message indicating that a new employee is being added. The Main class creates an instance of Employee and HRManager, calls the work() and getSalary() methods, and also calls the addEmployee() method on the HRManager object.
### 5. Write a Java program to create a class known as "BankAccount" with methods called deposit() and withdraw(). Create a subclass called SavingsAccount that overrides the withdraw() method to prevent withdrawals if the account balance falls below one hundred.
Write a Java program to create a class known as "BankAccount" with methods called deposit() and withdraw(). Create a subclass called SavingsAccount that overrides the withdraw() method to prevent withdrawals if the account balance falls below one hundred.

Sample Solution:

Java Code:
```java
// BankAccount.java
// Parent class BankAccount

// Declare the BankAccount class
public class BankAccount {
    // Private field to store the account number
    private String accountNumber;

    // Private field to store the balance
    private double balance;

    // Constructor to initialize account number and balance
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        // Increase the balance by the deposit amount
        balance += amount;
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) {
        // Check if the balance is sufficient for the withdrawal
        if (balance >= amount) {
            // Decrease the balance by the withdrawal amount
            balance -= amount;
        } else {
            // Print a message if the balance is insufficient
            System.out.println("Insufficient balance");
        }
    }

    // Method to get the current balance
    public double getBalance() {
        // Return the current balance
        return balance;
    }
} 

// SavingsAccount.java
// Child class SavingsAccount

// Declare the SavingsAccount class, inheriting from BankAccount
public class SavingsAccount extends BankAccount {
    // Constructor to initialize account number and balance
    public SavingsAccount(String accountNumber, double balance) {
        // Call the parent class constructor
        super(accountNumber, balance);
    }

    // Override the withdraw method from the parent class
    @Override
    public void withdraw(double amount) {
        // Check if the withdrawal would cause the balance to drop below $100
        if (getBalance() - amount < 100) {
            // Print a message if the minimum balance requirement is not met
            System.out.println("Minimum balance of $100 required!");
        } else {
            // Call the parent class withdraw method
            super.withdraw(amount);
        }
    }
}
// Main.java
// Main class

// Define the Main class
public class Main {
    // Main method, entry point of the program
    public static void main(String[] args) {
        // Print message to indicate creation of a BankAccount object
        System.out.println("Create a Bank Account object (A/c No. BA1234) with initial balance of $500:");
        // Create a BankAccount object (A/c No. "BA1234") with initial balance of $500
        BankAccount BA1234 = new BankAccount("BA1234", 500);

        // Print message to indicate deposit action
        System.out.println("Deposit $1000 into account BA1234:");
        // Deposit $1000 into account BA1234
        BA1234.deposit(1000);
        // Print the new balance after deposit
        System.out.println("New balance after depositing $1000: $" + BA1234.getBalance());

        // Print message to indicate withdrawal action
        System.out.println("Withdraw $600 from account BA1234:");
        // Withdraw $600 from account BA1234
        BA1234.withdraw(600);
        // Print the new balance after withdrawal
        System.out.println("New balance after withdrawing $600: $" + BA1234.getBalance());

        // Print message to indicate creation of a SavingsAccount object
        System.out.println("\nCreate a SavingsAccount object (A/c No. SA1234) with initial balance of $450:");
        // Create a SavingsAccount object (A/c No. "SA1234") with initial balance of $450
        SavingsAccount SA1234 = new SavingsAccount("SA1234", 450);

        // Withdraw $300 from SA1234
        SA1234.withdraw(300);
        // Print the balance after attempting to withdraw $300
        System.out.println("Balance after trying to withdraw $300: $" + SA1234.getBalance());

        // Print message to indicate creation of another SavingsAccount object
        System.out.println("\nCreate a SavingsAccount object (A/c No. SA1000) with initial balance of $300:");
        // Create a SavingsAccount object (A/c No. "SA1000") with initial balance of $300
        SavingsAccount SA1000 = new SavingsAccount("SA1000", 300);

        // Print message to indicate withdrawal action
        System.out.println("Try to withdraw $250 from SA1000!");
        // Withdraw $250 from SA1000 (balance falls below $100)
        SA1000.withdraw(250);
        // Print the balance after attempting to withdraw $250
        System.out.println("Balance after trying to withdraw $250: $" + SA1000.getBalance());
    }
}
```
Output:

Create a Bank Account object (A/c No. BA1234) with initial balance of $500:
Deposit $1000 into account BA1234:
New balance after depositing $1000: $1500.0
Withdraw $600 from account BA1234:
New balance after withdrawing $600: $900.0

Create a SavingsAccount object (A/c No. SA1234) with initial balance of $450:
Balance after trying to withdraw $300: $150.0

Create a SavingsAccount object (A/c No. SA1000) with initial balance of $300:
Try to withdraw $250 from SA1000!
Minimum balance of $100 required!
Balance after trying to withdraw $250: $300.0
Explanation:

The BankAccount class has a constructor that takes account number and balance as arguments. It also has methods to deposit and withdraw money, and to check the account balance.

### 6. Write a Java program to create a class called Animal with a method named move(). Create a subclass called Cheetah that overrides the move() method to run.
Write a Java program to create a class called Animal with a method named move(). Create a subclass called Cheetah that overrides the move() method to run.

Sample Solution:

Java Code:
```java
// Animal.java
// Parent class Animal

// Define the Animal class
public class Animal {
    // Method to print a message indicating the animal moves
    public void move() {
        System.out.println("Animal moves");
    }
} 

// Cheetah.java
// Child class Cheetah

// Define the Cheetah class, inheriting from Animal
public class Cheetah extends Animal {
    // Override the move method to print a cheetah-specific message
    @Override
    public void move() {
        System.out.println("This cheetah is running!");
    }
}
// Main.java
// Main class

// Define the Main class
public class Main {
    // Main method to run the program
    public static void main(String[] args) {
        // Create an instance of Animal
        Animal animal = new Animal();
        // Call the move method on the Animal instance
        animal.move();
        
        // Create an instance of Cheetah
        Cheetah cheetah = new Cheetah();
        // Call the move method on the Cheetah instance
        cheetah.move();
    }
}
```
Output:

Animal moves
This cheetah is running!
Explanation:

In the above exercise, the Animal class has a single method called move(). This method simply prints a message to the console saying the animal is moving. The Cheetah class extends the Animal class and overrides the move() method to print a message that Cheetah is running.


In the Main class, we create an instance of the "Animal" class and call its move() method. This prints the "This animal is moving" message to the console. We also create an instance of the "Cheetah" class and call its move() method. This prints the "This cheetah is running" message to the console.

### 7. Write a Java program to create a class known as Person with methods called getFirstName() and getLastName(). Create a subclass called Employee that adds a new method named getEmployeeId() and overrides the getLastName() method to include the employee's job title.
Write a Java program to create a class known as Person with methods called getFirstName() and getLastName(). Create a subclass called Employee that adds a new method named getEmployeeId() and overrides the getLastName() method to include the employee's job title.

Sample Solution:

Java Code:
```java
// Person.java
// Parent class Person

// Define the Person class
public class Person {
    // Private fields for first name and last name
    private String firstName;
    private String lastName;

    // Constructor to initialize first name and last name
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to get the first name
    public String getFirstName() {
        return firstName;
    }

    // Method to get the last name
    public String getLastName() {
        return lastName;
    }
} 

// Employee.java
// Child class Employee

// Declare the Employee class which extends the Person class
public class Employee extends Person {
    
    // Private instance variable for employee ID
    private int employeeId;
    
    // Private instance variable for job title
    private String jobTitle;

    // Constructor for Employee class, taking first name, last name, employee ID, and job title as parameters
    public Employee(String firstName, String lastName, int employeeId, String jobTitle) {
        // Call the constructor of the superclass (Person) with first name and last name
        super(firstName, lastName);
        // Initialize the employeeId instance variable
        this.employeeId = employeeId;
        // Initialize the jobTitle instance variable
        this.jobTitle = jobTitle;
    }

    // Public method to get the employee ID
    public int getEmployeeId() {
        return employeeId;
    }

    // Override the getLastName method from the superclass (Person)
    @Override
    public String getLastName() {
        // Return the last name from the superclass combined with the job title
        return super.getLastName() + ", " + jobTitle;
    }
} 
// Main.java
// Main class

// Declare the Main class
public class Main {
    
    // Main method to execute the program
    public static void main(String[] args) {
        
        // Create an Employee object named employee1 with first name, last name, employee ID, and job title
        Employee employee1 = new Employee("Kortney", "Rosalee", 4451, "HR Manager");
        
        // Print the first name, last name with job title, and employee ID of employee1
        System.out.println(employee1.getFirstName() + " " + employee1.getLastName() + " (" + employee1.getEmployeeId() + ")");
        
        // Create an Employee object named employee2 with first name, last name, employee ID, and job title
        Employee employee2 = new Employee("Junior", "Philipa", 4452, "Software Manager");
        
        // Print the first name, last name with job title, and employee ID of employee2
        System.out.println(employee2.getFirstName() + " " + employee2.getLastName() + " (" + employee2.getEmployeeId() + ")");
    }
}
```
Output:

Kortney Rosalee, HR Manager (4451)
Junior Philipa, Software Manager (4452)
Explanation:

The Person class has two private instance variables, firstName and lastName, and two public methods, getFirstName() and getLastName(), that return the values of these variables.

### 8. Write a Java program to create a class called Shape with methods called getPerimeter() and getArea(). Create a subclass called Circle that overrides the getPerimeter() and getArea() methods to calculate the area and perimeter of a circle.

Write a Java program to create a class called Shape with methods called getPerimeter() and getArea(). Create a subclass called Circle that overrides the getPerimeter() and getArea() methods to calculate the area and perimeter of a circle.

Sample Solution:

Java Code:
```java
// Shape.java
// Parent class Shape

// Declare the Shape class
public class Shape {
    
    // Public method to get the perimeter of the shape, returning a default value of 0.0
    public double getPerimeter() {
        return 0.0;
    }

    // Public method to get the area of the shape, returning a default value of 0.0
    public double getArea() {
        return 0.0;
    }
}

// Circle.java
// Child class Circle

// Declare the Circle class which extends the Shape class
public class Circle extends Shape {
    
    // Private instance variable for the radius of the circle
    private double radius;

    // Constructor for the Circle class, taking the radius as a parameter
    public Circle(double radius) {
        // Initialize the radius instance variable
        this.radius = radius;
    }

    // Override the getPerimeter method from the superclass (Shape)
    @Override
    public double getPerimeter() {
        // Return the perimeter of the circle calculated as 2 * π * radius
        return 2 * Math.PI * radius;
    }

    // Override the getArea method from the superclass (Shape)
    @Override
    public double getArea() {
        // Return the area of the circle calculated as π * radius^2
        return Math.PI * radius * radius;
    }
}
// Main.java
// Main class

// Declare the Main class
public class Main {
    
    // Main method to execute the program
    public static void main(String[] args) {
        
        // Declare a double variable r and initialize it to 8.0
        double r = 8.0;
        
        // Create a Circle object named c1 with radius r
        Circle c1 = new Circle(r);
        
        // Print the radius of the circle c1
        System.out.println("Radius of the circle=" + r);
        
        // Print the perimeter of the circle c1
        System.out.println("Perimeter: " + c1.getPerimeter());
        
        // Print the area of the circle c1
        System.out.println("Area: " + c1.getArea());
        
        // Update the value of r to 3.2
        r = 3.2;
        
        // Create a Circle object named c2 with radius r
        Circle c2 = new Circle(r);
        
        // Print the radius of the circle c2
        System.out.println("\nRadius of the circle=" + r);
        
        // Print the perimeter of the circle c2
        System.out.println("Perimeter: " + c2.getPerimeter());
        
        // Print the area of the circle c2
        System.out.println("Area: " + c2.getArea());
    }
}
```
Output:

Radius of the circle=8.0
Perimeter: 50.26548245743669
Area: 201.06192982974676

Radius of the circle=3.2
Perimeter: 20.106192982974676
Area: 32.169908772759484 
Explanation:

In the above exercise, the Shape class is a base class that provides generic methods for calculating the perimeter and area of a shape. The Circle class is a subclass that extends Shape and overrides the getPerimeter() and getArea() methods to implement circle formulas.
### 9. Write a Java program to create a vehicle class hierarchy. The base class should be Vehicle, with subclasses Truck, Car and Motorcycle. Each subclass should have properties such as make, model, year, and fuel type. Implement methods for calculating fuel efficiency, distance traveled, and maximum speed.
Write a Java program to create a  vehicle class hierarchy. The base class should be  Vehicle, with subclasses  Truck,  Car and Motorcycle. Each subclass should have properties such as make, model, year, and  fuel type. Implement methods for calculating fuel efficiency, distance traveled, and maximum speed.

Sample Solution:

Java Code:
```java
// Vehicle.java
// Parent class Vehicle

// Declare the abstract class Vehicle
public abstract class Vehicle {
    
    // Private instance variable for the make of the vehicle
    private String make;
    
    // Private instance variable for the model of the vehicle
    private String model;
    
    // Private instance variable for the year of the vehicle
    private int year;
    
    // Private instance variable for the fuel type of the vehicle
    private String fuelType;
    
    // Private instance variable for the fuel efficiency of the vehicle
    private double fuelEfficiency;

    // Constructor for the Vehicle class, taking make, model, year, fuel type, and fuel efficiency as parameters
    public Vehicle(String make, String model, int year, String fuelType, double fuelEfficiency) {
        // Initialize the make instance variable
        this.make = make;
        // Initialize the model instance variable
        this.model = model;
        // Initialize the year instance variable
        this.year = year;
        // Initialize the fuelType instance variable
        this.fuelType = fuelType;
        // Initialize the fuelEfficiency instance variable
        this.fuelEfficiency = fuelEfficiency;
    }
    
    // Public method to get the make of the vehicle
    public String getMake() {
        return make;
    }

    // Public method to get the model of the vehicle
    public String getModel() {
        return model;
    }

    // Public method to get the year of the vehicle
    public int getYear() {
        return year;
    }

    // Public method to get the fuel type of the vehicle
    public String getFuelType() {
        return fuelType;
    }

    // Public method to get the fuel efficiency of the vehicle
    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    // Abstract method to calculate the fuel efficiency, to be implemented by subclasses
    public abstract double calculateFuelEfficiency();

    // Abstract method to calculate the distance traveled, to be implemented by subclasses
    public abstract double calculateDistanceTraveled();

    // Abstract method to get the maximum speed, to be implemented by subclasses
    public abstract double getMaxSpeed();
}
```
Explanation:

This is an abstract class that serves as the parent class for the other  vehicle classes. It contains five private instance variables (make, model, year, fuelType, and fuelEfficiency) and six public methods (a constructor, five getters for the instance variables, and three abstract methods). The abstract methods are meant to be overridden by child classes with specific implementations.
```java
// Truck.java
// Child class Truck

// Declare the Truck class which extends the Vehicle class
public class Truck extends Vehicle {
    
    // Private instance variable for the cargo capacity of the truck
    private double cargoCapacity;

    // Constructor for the Truck class, taking make, model, year, fuel type, fuel efficiency, and cargo capacity as parameters
    public Truck(String make, String model, int year, String fuelType, double fuelEfficiency, double cargoCapacity) {
        // Call the constructor of the superclass (Vehicle) with make, model, year, fuel type, and fuel efficiency
        super(make, model, year, fuelType, fuelEfficiency);
        // Initialize the cargoCapacity instance variable
        this.cargoCapacity = cargoCapacity;
    }
   
    // Public method to get the cargo capacity of the truck
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    // Override the calculateFuelEfficiency method from the superclass (Vehicle)
    @Override
    public double calculateFuelEfficiency() {
        // Implementation for fuel efficiency calculation for trucks
        return getFuelEfficiency() * (1.0 / (1.0 + (getCargoCapacity() / 1000.0)));
    }

    // Override the calculateDistanceTraveled method from the superclass (Vehicle)
    @Override
    public double calculateDistanceTraveled() {
        // Implementation for distance traveled calculation for trucks
        return calculateFuelEfficiency() * getFuelEfficiency();
    }

    // Override the getMaxSpeed method from the superclass (Vehicle)
    @Override
    public double getMaxSpeed() {
        // Implementation for maximum speed calculation for trucks
        return 80.0;
    }
}
```
Explanation:

The above class is a child class of  Vehicle and extends the  Vehicle class. It has an additional instance variable, cargoCapacity. The class has a constructor that accepts all the necessary parameters including cargo capacity. The class overrides the three abstract methods of the parent class and provides specific implementations of the methods.
```java
// Car.java
// Child class Car

// Declare the Car class which extends the Vehicle class
public class Car extends Vehicle {
    
    // Private instance variable for the number of seats in the car
    private int numSeats;

    // Constructor for the Car class, taking make, model, year, fuel type, fuel efficiency, and number of seats as parameters
    public Car(String make, String model, int year, String fuelType, double fuelEfficiency, int numSeats) {
        // Call the constructor of the superclass (Vehicle) with make, model, year, fuel type, and fuel efficiency
        super(make, model, year, fuelType, fuelEfficiency);
        // Initialize the numSeats instance variable
        this.numSeats = numSeats;
    }

    // Public method to get the number of seats in the car
    public int getNumSeats() {
        return numSeats;
    }

    // Override the calculateFuelEfficiency method from the superclass (Vehicle)
    @Override
    public double calculateFuelEfficiency() {
        // Implementation for fuel efficiency calculation for cars
        return getFuelEfficiency() * (1.0 / (1.0 + (getNumSeats() / 5.0)));
    }

    // Override the calculateDistanceTraveled method from the superclass (Vehicle)
    @Override
    public double calculateDistanceTraveled() {
        // Implementation for distance traveled calculation for cars
        return calculateFuelEfficiency() * getFuelEfficiency();
    }

    // Override the getMaxSpeed method from the superclass (Vehicle)
    @Override
    public double getMaxSpeed() {
        // Implementation for maximum speed calculation for cars
        return 120.0;
    }
}
```
Explanation:

The above class is another child class of  Vehicle and extends the  Vehicle class. It has an additional instance variable, numSeats. The class has a constructor that accepts all the necessary parameters including the number of seats. The class overrides the three abstract methods of the parent class and provides specific implementations of the methods.
```java
// Motorcycle.java
// Child class Motorcycle

// Declare the Motorcycle class which extends the Vehicle class
public class Motorcycle extends Vehicle {
    
    // Private instance variable for the engine displacement of the motorcycle
    private double engineDisplacement;

    // Constructor for the Motorcycle class, taking make, model, year, fuel type, and fuel efficiency as parameters
    public Motorcycle(String make, String model, int year, String fuelType, double fuelEfficiency) {
        // Call the constructor of the superclass (Vehicle) with make, model, year, fuel type, and fuel efficiency
        super(make, model, year, fuelType, fuelEfficiency);
        // Initialize the engineDisplacement instance variable (currently commented out)
        // this.engineDisplacement = engineDisplacement;
    }

    // Public method to get the engine displacement of the motorcycle
    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    // Override the calculateFuelEfficiency method from the superclass (Vehicle)
    @Override
    public double calculateFuelEfficiency() {
        // Implementation for fuel efficiency calculation for motorcycles
        return getFuelEfficiency() * (1.0 / (1.0 + (getEngineDisplacement() / 1000.0)));
    }

    // Override the calculateDistanceTraveled method from the superclass (Vehicle)
    @Override
    public double calculateDistanceTraveled() {
        // Implementation for distance traveled calculation for motorcycles
        return calculateFuelEfficiency() * getFuelEfficiency();
    }

    // Override the getMaxSpeed method from the superclass (Vehicle)
    @Override
    public double getMaxSpeed() {
        // Implementation for maximum speed calculation for motorcycles
        return 80.0;
    }
}
```
Explanation:

This is also a child class of  Vehicle and extends the  Vehicle class. It has an additional instance variable, engineDisplacement. The class has a constructor that accepts all the necessary parameters. The class overrides the three abstract methods of the parent class and provides specific implementations of the methods.
```java
// Main.java
// Main class

// Declare the Main class
public class Main {
    
    // Main method to execute the program
    public static void main(String[] args) {

        // Create an instance of the Truck class with make, model, year, fuel type, fuel efficiency, and cargo capacity
        Truck truck = new Truck("Tatra", "Tatra 810 4x4", 2020, "GASOLINE", 8.112, 4.5);

        // Create an instance of the Car class with make, model, year, fuel type, fuel efficiency, and number of seats
        Car car = new Car("Volkswagen", "Virtus", 2019, "HYBRID", 6.123, 8);

        // Create an instance of the Motorcycle class with make, model, year, fuel type, and fuel efficiency
        Motorcycle motorcycle = new Motorcycle("Massimo Motor", "Warrior200", 2018, "GASOLINE", 2.1);

        // Print the truck's model
        System.out.println("Truck Model: " + truck.getModel());
        // Print the truck's calculated fuel efficiency
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " mpg");
        // Print the truck's calculated distance traveled
        System.out.println("Distance Traveled: " + truck.calculateDistanceTraveled() + " miles");
        // Print the truck's maximum speed
        System.out.println("Max Speed: " + truck.getMaxSpeed() + " mph\n");

        // Print the car's model
        System.out.println("Car Model: " + car.getModel());
        // Print the car's calculated fuel efficiency
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " mpg");
        // Print the car's calculated distance traveled
        System.out.println("Distance Traveled: " + car.calculateDistanceTraveled() + " miles");
        // Print the car's maximum speed
        System.out.println("Max Speed: " + car.getMaxSpeed() + " mph\n");

        // Print the motorcycle's model
        System.out.println("Motorcycle Model: " + motorcycle.getModel());
        // Print the motorcycle's calculated fuel efficiency
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " mpg");
        // Print the motorcycle's calculated distance traveled
        System.out.println("Distance Traveled: " + motorcycle.calculateDistanceTraveled() + " miles");
        // Print the motorcycle's maximum speed
        System.out.println("Max Speed: " + motorcycle.getMaxSpeed() + " mph");
    }
}
```
Explanation:

The above class is the main class that contains the main method. It creates instances of each  vehicle type, sets their values, and then prints their respective details and calculations such as  fuel efficiency, distance traveled, and max speed.

Output:

Truck Model: Tatra 810 4x4
Fuel Efficiency: 8.075659532105526 mpg
Distance Traveled: 65.50975012444003 miles
Max Speed: 80.0 mph

Car Model: Virtus
Fuel Efficiency: 2.355 mpg
Distance Traveled: 14.419665 miles
Max Speed: 120.0 mph

Motorcycle Model: Warrior200
Fuel Efficiency: 2.1 mpg
Distance Traveled: 4.41 miles
Max Speed: 80.0 mph

### 10. Write a Java program that creates a class hierarchy for employees of a company. The base class should be Employee, with subclasses Manager, Developer, and  Programmer. Each subclass should have properties such as name, address, salary, and job title. Implement methods for calculating bonuses, generating performance reports, and managing projects.

Write a Java program that creates a class hierarchy for employees of a company. The base class should be Employee, with subclasses Manager, Developer, and Programmer. Each subclass should have properties such as name, address, salary, and job title. Implement methods for calculating bonuses, generating performance reports, and managing projects.

Sample Solution:

Java Code:
```java
// Class declaration for Employee
class Employee {
    // Private fields for the Employee class
    private String name;
    private String address;
    private double salary;
    private String jobTitle;

    // Constructor for the Employee class
    public Employee(String name, String address, double salary, String jobTitle) {
        // Initializing the name field
        this.name = name;
        // Initializing the address field
        this.address = address;
        // Initializing the salary field
        this.salary = salary;
        // Initializing the jobTitle field
        this.jobTitle = jobTitle;
    }

    // Getter method for the name field
    public String getName() {
        return name;
    }

    // Getter method for the address field
    public String getAddress() {
        return address;
    }

    // Getter method for the salary field
    public double getSalary() {
        return salary;
    }

    // Getter method for the jobTitle field
    public String getJobTitle() {
        return jobTitle;
    }

    // Method to calculate the bonus for the employee
    public double calculateBonus() {
        // Default implementation for bonus calculation
        return 0.0;
    }

    // Method to generate the performance report for the employee
    public String generatePerformanceReport() {
        // Default implementation for performance report
        return "No performance report available.";
    }
} 
```
Explanation:

Employee class: This class represents a generic employee with private instance variables 'name', 'address', 'salary', and 'jobTitle'. It also provides getter methods to access these private variables.
getName(): Returns the employee's name.
getAddress(): Returns the employee's address.
getSalary(): Returns the employee's salary.
getJobTitle(): Returns the employee's job title.
calculateBonus(): This method is used to calculate the bonus for an employee. In the base class, it provides a default implementation that returns 0.0. Subclasses can override this method to provide custom bonus calculation logic.
generatePerformanceReport(): This method generates a performance report for an employee. Similar to the bonus calculation, it provides a default implementation that returns "No performance report available." Subclasses can override this method to provide custom performance report generation logic.
This class is designed to be extended by subclasses like "Manager", "Developer", and "Programmer", which can provide their own implementations of bonus calculation and performance report generation as per their specific roles and responsibilities.
```java
// Class declaration for Manager which extends Employee
class Manager extends Employee {
    // Private field for the number of subordinates
    private int numberOfSubordinates;

    // Constructor for the Manager class
    public Manager(String name, String address, double salary, String jobTitle, int numberOfSubordinates) {
        // Calling the constructor of the superclass Employee
        super(name, address, salary, jobTitle);
        // Initializing the numberOfSubordinates field
        this.numberOfSubordinates = numberOfSubordinates;
    }

    // Getter method for the numberOfSubordinates field
    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    // Overridden method to calculate the bonus for the manager
    @Override
    public double calculateBonus() {
        // Custom implementation for bonus calculation for managers
        return getSalary() * 0.15;
    }

    // Overridden method to generate the performance report for the manager
    @Override
    public String generatePerformanceReport() {
        // Custom implementation for performance report for managers
        return "Performance report for Manager " + getName() + ": Excellent";
    }

    // Custom method for managing projects
    public void manageProject() {
        // Printing a message indicating the manager is managing a project
        System.out.println("Manager " + getName() + " is managing a project.");
    }
}
```
Explanation:

extends Employee: This line indicates that the "Manager" class inherits from the "Employee" class. It means that a Manager is a specialized type of Employee and inherits all the attributes and methods of the Employee class.
private int numberOfSubordinates: This instance variable represents the number of subordinates managed by the manager. It is specific to the "Manager" class and not present in the base "Employee" class.
public Manager(String name, String address, double salary, String jobTitle, int numberOfSubordinates): This is the constructor for the "Manager" class. It takes parameters for 'name', 'address', 'salary', 'jobTitle', and numberOfSubordinates, which are used to initialize the attributes inherited from the "Employee" class as well as the numberOfSubordinates specific to managers. The super(...) keyword is used to call the constructor of the superclass (Employee) to initialize its attributes.
public int getNumberOfSubordinates(): This method allows you to retrieve the number of subordinates managed by the manager.
@Override public double calculateBonus(): This method is marked with the @Override annotation, indicating that it is an overridden method from the superclass (Employee). The "calculateBonus()" method provides a custom implementation for bonus calculation for managers. In this case, it calculates the bonus as 15% of the manager's salary.
@Override public String generatePerformanceReport(): Similar to the "calculateBonus()" method, this method is also marked as an override and provides a custom implementation for generating a performance report for managers. It returns a specific performance report message for managers, including the manager's name and an "Excellent" rating.
public void manageProject(): This is a custom method specific to the "Manager" class. It simulates the action of a manager managing a project by printing a message to the console.

```java
// Class declaration for Developer which extends Employee
class Developer extends Employee {
    // Private field for the programming language
    private String programmingLanguage;

    // Constructor for the Developer class
    public Developer(String name, String address, double salary, String jobTitle, String programmingLanguage) {
        // Calling the constructor of the superclass Employee
        super(name, address, salary, jobTitle);
        // Initializing the programmingLanguage field
        this.programmingLanguage = programmingLanguage;
    }

    // Getter method for the programmingLanguage field
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    // Overridden method to calculate the bonus for the developer
    @Override
    public double calculateBonus() {
        // Custom implementation for bonus calculation for developers
        return getSalary() * 0.10;
    }

    // Overridden method to generate the performance report for the developer
    @Override
    public String generatePerformanceReport() {
        // Custom implementation for performance report for developers
        return "Performance report for Developer " + getName() + ": Good";
    }

    // Custom method for writing code
    public void writeCode() {
        // Printing a message indicating the developer is writing code
        System.out.println("Developer " + getName() + " is writing code in " + programmingLanguage);
    }
}
```
Explanation:

extends Employee: Similar to the "Manager" class, this line indicates that the Developer class inherits from the "Employee" class. It means that a 'Developer' is a specialized type of 'Employee' and inherits all the attributes and methods of the Employee class.
private String  programmingLanguage: This instance variable represents the  programming language that the developer specializes in. It is specific to the "Developer" class and not present in the base "Employee" class.
public Developer(String name, String address, double salary, String jobTitle, String  programmingLanguage): This is the constructor for the "Developer" class. It takes parameters for 'name', 'address', 'salary', 'jobTitle', and programmingLanguage, which are used to initialize the attributes inherited from the "Employee" class as well as the programmingLanguage specific to developers. The super(...) keyword is used to call the constructor of the superclass (Employee) to initialize its attributes.
public String getProgrammingLanguage(): This method allows you to retrieve the  programming language specialization of the developer.
@Override public double calculateBonus(): This method is marked with the @Override annotation, indicating that it is an overridden method from the superclass (Employee). The "calculateBonus()" method provides a custom implementation for bonus calculation for developers. In this case, it calculates the bonus as 10% of the developer's salary.
@Override public String generatePerformanceReport(): Similar to the "calculateBonus()" method, this method is also marked as an override and provides a custom implementation for generating a performance report for developers. It returns a specific performance report message for developers, including the developer's name and a "Good" rating.
public void writeCode(): This is a custom method specific to the "Developer" class. It simulates the action of a developer writing code in their specialized  programming language by printing a message to the console.

```java
// Class declaration for Programmer which extends Developer
class Programmer extends Developer {
    // Constructor for the Programmer class
    public Programmer(String name, String address, double salary, String programmingLanguage) {
        // Calling the constructor of the superclass Developer
        super(name, address, salary, "Programmer", programmingLanguage);
    }

    // Overridden method to calculate the bonus for the programmer
    @Override
    public double calculateBonus() {
        // Custom implementation for bonus calculation for programmers
        return getSalary() * 0.12;
    }

    // Overridden method to generate the performance report for the programmer
    @Override
    public String generatePerformanceReport() {
        // Custom implementation for performance report for programmers
        return "Performance report for Programmer " + getName() + ": Excellent";
    }

    // Custom method for debugging code
    public void debugCode() {
        // Printing a message indicating the programmer is debugging code
        System.out.println("Programmer " + getName() + " is debugging code in " + getProgrammingLanguage());
    }
}
```
Explanation:

extends Developer: This line indicates that the "Programmer" class inherits from the "Developer" class. It means that a 'Programmer' is a specialized type of 'Developer' and inherits all the attributes and methods of the Developer class.
public Programmer(String name, String address, double salary, String  programmingLanguage): This is the constructor for the "Programmer" class. It takes parameters for 'name', 'address', 'salary', and ' programmingLanguage'. It passes these parameters to the constructor of the superclass (Developer) using the super(...) keyword to initialize the attributes inherited from the "Developer" class. The 'jobTitle' parameter is set to "Programmer" to indicate the specific job title for programmers.
@Override public double calculateBonus(): This method is marked with the @Override annotation, indicating that it is an overridden method from the superclass (Developer). The "calculateBonus()" method provides a custom implementation for bonus calculation for programmers. In this case, it calculates the bonus as 12% of the programmer's salary.
@Override public String generatePerformanceReport(): Similar to the "calculateBonus()" method, this method is also marked as an override and provides a custom implementation for generating a performance report for programmers. It returns a specific performance report message for programmers, including the programmer's name and an "Excellent" rating.
public void debugCode(): This is a custom method specific to the "Programmer" class. It simulates the action of a programmer debugging code in their specialized  programming language by printing a message to the console.
```java
// Public class declaration for Main
public class Main {
    // Main method
    public static void main(String[] args) {
        // Creating an instance of Manager
        Manager manager = new Manager("Avril Aroldo", "1 ABC St", 80000.0, "Manager", 5);
        // Creating an instance of Developer
        Developer developer = new Developer("Iver Dipali", "2 PQR St", 72000.0, "Developer", "Java");
        // Creating an instance of Programmer
        Programmer programmer = new Programmer("Yaron Gabriel", "3 ABC St", 76000.0, "Python");

        // Printing the manager's bonus
        System.out.println("Manager's Bonus: $" + manager.calculateBonus());
        // Printing the developer's bonus
        System.out.println("Developer's Bonus: $" + developer.calculateBonus());
        // Printing the programmer's bonus
        System.out.println("Programmer's Bonus: $" + programmer.calculateBonus());

        // Printing the manager's performance report
        System.out.println(manager.generatePerformanceReport());
        // Printing the developer's performance report
        System.out.println(developer.generatePerformanceReport());
        // Printing the programmer's performance report
        System.out.println(programmer.generatePerformanceReport());

        // Manager managing a project
        manager.manageProject();
        // Developer writing code
        developer.writeCode();
        // Programmer debugging code
        programmer.debugCode();
    }
}
```
Explanation:

Creating Employee Objects:
Three employee objects are created: 'manager', 'developer', and 'programmer', each with their specific attributes such as name, address, salary, and job title.
manager is an instance of the "Manager" class.
developer is an instance of the "Developer" class.
programmer is an instance of the "Programmer" class.
Calculating Bonuses:
The program calls the "calculateBonus()" method for each employee type (manager, developer, and programmer) to calculate their respective bonuses.
The bonuses are displayed on the console.
Generating Performance Reports:
The program calls the "generatePerformanceReport()" method for each employee type (manager, developer, and programmer) to generate performance reports.
The performance reports are displayed on the console.
Specific Actions:
For each employee type, specific actions are performed:
manager uses the "manageProject()" method to simulate managing a project.
developer uses the "writeCode()" method to simulate writing code in a specific  programming language.
programmer uses the "debugCode()" method to simulate debugging code in a specific  programming language.
These actions are displayed on the console.
Output:

Manager's Bonus: $12000.0
Developer's Bonus: $7200.0
Programmer's Bonus: $9120.0
Performance report for Manager Avril Aroldo: Excellent
Performance report for Developer Iver Dipali: Good
Performance report for Programmer Yaron Gabriel: Excellent
Manager Avril Aroldo is managing a project.
Developer Iver Dipali is writing code in Java
Programmer Yaron Gabriel is debugging code in Python
