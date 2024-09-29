# Java Exercises Abstract

All  programming languages provide abstractions. It can be argued that the complexity of the problems you’re able to solve is directly related to the kind and quality of abstraction. An essential element of object-oriented programming is an abstraction. For more information read this article.

### 1. Write a Java program to create an abstract class Animal with an abstract method called sound(). Create subclasses Lion and Tiger that extend the Animal class and implement the sound() method to make a specific sound for each animal.

Write a Java program to create an abstract class Animal with an abstract method called sound(). Create subclasses Lion and Tiger that extend the Animal class and implement the sound() method to make a specific sound for each animal.

Above exercise represents the class structure and the relationship between the abstract class and its subclasses.

In the following code, the Animal class is shown as an abstract class with the abstract method sound(). The Lion and Tiger classes are subclasses of Animal and provide their own sound() implementations. The arrow indicates the inheritance relationship, where Lion and Tiger inherit from Animal.

Sample Solution:

Java Code:
```java
// Animal.java

// Define an abstract class named Animal
abstract class Animal {
    // Declare an abstract method named sound
    public abstract void sound();
}
```
The above code defines an abstract class named Animal. An abstract class is a class that cannot be instantiated on its own and must be subclassed. The Animal class contains an abstract method named sound(), which means any subclass of Animal must provide an implementation for the sound() method. Here is a brief explanation of each part:

abstract class Animal: This line defines an abstract class called Animal.
public abstract void sound();: This line declares an abstract method named sound that must be implemented by any concrete subclass of Animal.
```java
// Lion.java

// Define a subclass named Lion that extends Animal
class Lion extends Animal {
    // Override the abstract method sound from the Animal class
    @Override
    public void sound() {
        // Print "Lion roars!" to the console
        System.out.println("Lion roars!");
    }
}
```
The above code defines a subclass named Lion that extends the abstract class Animal. The Lion class provides an implementation for the abstract method sound() defined in the Animal class. Here's a brief explanation of each part:

class Lion extends Animal: This line declares that Lion is a subclass of Animal.
@Override: This annotation indicates that the following method overrides a method declared in a superclass.
public void sound(): This line defines the implementation of the abstract method sound() from the Animal class.
System.out.println("Lion roars!");: This line prints "Lion roars!" to the console, providing the specific behavior for the Lion class.

```java
// Tiger.java

// Define a subclass named Tiger that extends Animal
class Tiger extends Animal {
    // Override the abstract method sound from the Animal class
    @Override
    public void sound() {
        // Print "Tiger growls!" to the console
        System.out.println("Tiger growls!");
    }
}
```
The above code defines a subclass named Tiger that extends the abstract class Animal. The Tiger class provides an implementation for the abstract method sound() defined in the Animal class. Here's a brief explanation of each part:

class Tiger extends Animal: Declares that Tiger is a subclass of Animal.
@Override: Indicates that the following method overrides a method declared in a superclass.
public void sound(): Defines the implementation of the abstract method sound() from the Animal class.
System.out.println("Tiger growls!");: Prints "Tiger growls!" to the console, providing the specific behavior for the Tiger class.
```java
// Main.java

// Define the Main class
public class Main {
    // Main method to run the program
    public static void main(String[] args) {
        // Create an instance of Lion and assign it to an Animal reference
        Animal lion = new Lion();
        // Call the sound method on the Lion instance
        lion.sound(); // Output: Lion roars!

        // Create an instance of Tiger and assign it to an Animal reference
        Animal tiger = new Tiger();
        // Call the sound method on the Tiger instance
        tiger.sound(); // Output: Tiger growls!
    }
}
```
Output:

Lion roars!
Tiger growls!

### 2. Write a Java program to create an abstract class Shape with abstract methods calculateArea() and calculatePerimeter(). Create subclasses Circle and Triangle that extend the Shape class and implement the respective methods to calculate the area and perimeter of each shape.

Write a Java program to create an abstract class Shape with abstract methods calculateArea() and calculatePerimeter(). Create subclasses Circle and Triangle that extend the Shape class and implement the respective methods to calculate the area and perimeter of each shape.

In the following program Shape is the abstract base class with two abstract methods: calculateArea() and calculatePerimeter(). The Circle and Triangle classes are subclasses of Shape and provide their own implementations for abstract methods.

Sample Solution:

Java Code:
```java

// Shape.java

// Define an abstract class named Shape
abstract class Shape {
    // Declare an abstract method to calculate the area
    abstract double calculateArea();
    // Declare an abstract method to calculate the perimeter
    abstract double calculatePerimeter();
}

// Circle.java

// Define a subclass named Circle that extends Shape
class Circle extends Shape {
    // Declare a private double variable to store the radius
    private double radius;

    // Constructor that accepts a radius and sets it to the radius variable
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override the calculateArea method to compute the area of the circle
    @Override
    double calculateArea() {
        // Return the area using the formula π * radius^2
        return Math.PI * radius * radius;
    }

    // Override the calculatePerimeter method to compute the perimeter of the circle
    @Override
    double calculatePerimeter() {
        // Return the perimeter using the formula 2 * π * radius
        return 2 * Math.PI * radius;
    }
}
// Triangle.java

// Define a subclass named Triangle that extends Shape
class Triangle extends Shape {
    // Declare private double variables to store the sides of the triangle
    private double side1;
    private double side2;
    private double side3;

    // Constructor that accepts three sides and sets them to the corresponding variables
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Override the calculateArea method to compute the area of the triangle
    @Override
    double calculateArea() {
        // Calculate the semi-perimeter
        double s = (side1 + side2 + side3) / 2;
        // Return the area using Heron's formula
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Override the calculatePerimeter method to compute the perimeter of the triangle
    @Override
    double calculatePerimeter() {
        // Return the perimeter by summing up all the sides
        return side1 + side2 + side3;
    }
}
// Main.java

// Define the Main class
public class Main {
    // Main method to run the program
    public static void main(String[] args) {
        // Declare and initialize the radius for the circle
        double r = 4.0;
        // Create an instance of Circle with the specified radius
        Circle circle = new Circle(r);
        
        // Declare and initialize the sides for the triangle
        double ts1 = 3.0, ts2 = 4.0, ts3 = 5.0;
        // Create an instance of Triangle with the specified sides
        Triangle triangle = new Triangle(ts1, ts2, ts3);
        
        // Print the radius of the circle
        System.out.println("Radius of the Circle: " + r);
        // Print the area of the circle by calling the calculateArea method
        System.out.println("Area of the Circle: " + circle.calculateArea());
        // Print the perimeter of the circle by calling the calculatePerimeter method
        System.out.println("Perimeter of the Circle: " + circle.calculatePerimeter());
        
        // Print the sides of the triangle
        System.out.println("\nSides of the Triangle are: " + ts1 + ',' + ts2 + ',' + ts3);
        // Print the area of the triangle by calling the calculateArea method
        System.out.println("Area of the Triangle: " + triangle.calculateArea());
        // Print the perimeter of the triangle by calling the calculatePerimeter method
        System.out.println("Perimeter of the Triangle: " + triangle.calculatePerimeter());
    }
}
```
Output:

Radius of the Circle4.0
Area of the Circle: 50.26548245743669
Perimeter of the Circle: 25.132741228718345

Sides of the Traiangel are: 3.0,4.0,5.0
Area of the Triangle: 6.0
Perimeter of the Triangle: 12.0
### 3. Write a Java program to create an abstract class BankAccount with abstract methods deposit() and withdraw(). Create subclasses: SavingsAccount and CurrentAccount that extend the BankAccount class and implement the respective methods to handle deposits and withdrawals for each account type.

Write a Java program to create an abstract class BankAccount with abstract methods deposit() and withdraw(). Create subclasses: SavingsAccount and CurrentAccount that extend the BankAccount class and implement the respective methods to handle deposits and withdrawals for each account type.

In the following code, the BankAccount class is an abstract class with an abstract deposit() method and an abstract withdraw() method. It also has a private instance variable balance of type double and corresponding getter and setter methods. The SavingsAccount class and the CurrentAccount class are the subclasses that extend the BankAccount class. They implement the deposit() and withdraw() methods based on the specific rules for each account type.

Sample Solution:

Java Code:
```java

// BankAccount.java

// Define an abstract class named BankAccount
abstract class BankAccount {
    // Declare private variables for account number and balance
    private String accountNumber;
    private double balance;

    // Constructor that accepts account number and balance, and sets them to the corresponding variables
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Protected setter method for balance
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Declare an abstract method for depositing an amount
    public abstract void deposit(double amount);

    // Declare an abstract method for withdrawing an amount
    public abstract void withdraw(double amount);
}

// SavingsAccount.java

// Define a subclass named SavingsAccount that extends BankAccount
class SavingsAccount extends BankAccount {
    // Constructor that accepts account number and balance, and passes them to the superclass constructor
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Override the deposit method to add an amount to the balance
    @Override
    public void deposit(double amount) {
        // Update the balance by adding the deposit amount
        setBalance(getBalance() + amount);
        // Print a message indicating the deposit was successful
        System.out.println("Deposit of $" + amount + " successful. Current balance: $" + getBalance());
    }

    // Override the withdraw method to subtract an amount from the balance
    @Override
    public void withdraw(double amount) {
        // Check if the balance is sufficient for the withdrawal
        if (getBalance() >= amount) {
            // Update the balance by subtracting the withdrawal amount
            setBalance(getBalance() - amount);
            // Print a message indicating the withdrawal was successful
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + getBalance());
        } else {
            // Print a message indicating insufficient funds
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}
// CurrentAccount.java
// Subclass CurrentAccount

// Define CurrentAccount class that extends BankAccount
class CurrentAccount extends BankAccount {
    
    // Constructor to initialize account number and balance
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance); // Call superclass constructor with account number and balance
    }

    // Override deposit method from BankAccount
    @Override
    public void deposit(double amount) {
        // Add deposit amount to current balance
        setBalance(getBalance() + amount);
        // Print successful deposit message with updated balance
        System.out.println("Deposit of $" + amount + " successful. Current balance: $" + getBalance());
    }

    // Override withdraw method from BankAccount
    @Override
    public void withdraw(double amount) {
        // Check if there are sufficient funds for the withdrawal
        if (getBalance() >= amount) {
            // Subtract withdrawal amount from current balance
            setBalance(getBalance() - amount);
            // Print successful withdrawal message with updated balance
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + getBalance());
        } else {
            // Print insufficient funds message if withdrawal cannot be made
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}
// Main.java
// Subclass Main

// Define public class Main
public class Main {
    // Define the main method
    public static void main(String[] args) {
        // Declare double variables for initial balance, deposit amount, and withdrawal amount
        double ibal, damt, wamt;

        // Set initial balance for SavingsAccount
        ibal = 1000.00;
        // Create a new SavingsAccount object with the initial balance
        SavingsAccount savingsAccount = new SavingsAccount("SA001", ibal);
        // Print initial balance of SavingsAccount
        System.out.println("Savings A/c: Initial Balace: $" + ibal);

        // Set deposit amount
        damt = 500.00;
        // Deposit amount into SavingsAccount
        savingsAccount.deposit(damt);

        // Set first withdrawal amount
        wamt = 250.00;
        // Withdraw amount from SavingsAccount
        savingsAccount.withdraw(wamt);

        // Set second withdrawal amount
        wamt = 1600.00;
        // Print attempt to withdraw larger amount
        System.out.println("\nTry to withdraw: $" + wamt);
        // Attempt to withdraw larger amount from SavingsAccount
        savingsAccount.withdraw(wamt);

        // Print an empty line for separation
        System.out.println();

        // Set initial balance for CurrentAccount
        ibal = 5000.00;
        // Create a new CurrentAccount object with the initial balance
        CurrentAccount currentAccount = new CurrentAccount("CA001", ibal);
        // Print initial balance of CurrentAccount
        System.out.println("Current A/c: Initial Balace: $" + ibal);

        // Set deposit amount for CurrentAccount
        damt = 2500.00;
        // Deposit amount into CurrentAccount
        currentAccount.deposit(1000.0);

        // Set first withdrawal amount for CurrentAccount
        wamt = 1250.00;
        // Withdraw amount from CurrentAccount
        currentAccount.withdraw(3000.0);

        // Set second withdrawal amount for CurrentAccount
        wamt = 6000.00;
        // Print attempt to withdraw larger amount from CurrentAccount
        System.out.println("\nTry to withdraw: $" + wamt);
        // Attempt to withdraw larger amount from CurrentAccount
        savingsAccount.withdraw(wamt);
    }
}
```
Output:

Savings A/c: Initial Balace: $1000.0
Deposit of $500.0 successful. Current balance: $1500.0
Withdrawal of $250.0 successful. Current balance: $1250.0

Try to withdraw: $1600.0
Insufficient funds. Withdrawal failed.

Current A/c: Initial Balace: $5000.0
Deposit of $1000.0 successful. Current balance: $6000.0
Withdrawal of $3000.0 successful. Current balance: $3000.0

Try to withdraw: $6000.0
Insufficient funds. Withdrawal failed.

### 4. Write a Java program to create an abstract class Animal with abstract methods eat() and sleep(). Create subclasses Lion, Tiger, and Deer that extend the Animal class and implement the eat() and sleep() methods differently based on their specific behavior.

Write a Java program to create an abstract class Animal with abstract methods eat() and sleep(). Create subclasses Lion, Tiger, and Deer that extend the Animal class and implement the eat() and sleep() methods differently based on their specific behavior.

In this program, the Animal class is an abstract class that defines the abstract methods eat() and sleep(). The Lion, Tiger, and Deer classes extend the Animal class and provide their own implementations for the eat() and sleep() methods based on their specific behavior. The Main class demonstrates the usage of these classes by creating objects of each subclass and invoking the eat() and sleep() methods accordingly.

Sample Solution:

Java Code:
```java

// Animal.java
// Abstract class Animal

// Define abstract class Animal
abstract class Animal {
    // Declare abstract method eat
    public abstract void eat();
    // Declare abstract method sleep
    public abstract void sleep();
}

// Lion.java
// Subclass Lion

// Define class Lion that extends Animal
class Lion extends Animal {
    // Override the eat method from Animal
    @Override
    public void eat() {
        // Print what the lion eats
        System.out.println("Lion eats meat.");
    }

    // Override the sleep method from Animal
    @Override
    public void sleep() {
        // Print where the lion sleeps
        System.out.println("Lion sleeps on grassland.");
    }
}
// Tiger.java
// Subclass Tiger

// Define class Tiger that extends Animal
class Tiger extends Animal {
    // Override the eat method from Animal
    @Override
    public void eat() {
        // Print what the tiger eats
        System.out.println("Tiger eats meat and occasionally hunts in water.");
    }

    // Override the sleep method from Animal
    @Override
    public void sleep() {
        // Print where the tiger sleeps
        System.out.println("Tiger sleeps in a hidden spot.");
    }
} 
// Deer.java
// Subclass Deer

// Define class Deer that extends Animal
class Deer extends Animal {
    // Override the eat method from Animal
    @Override
    public void eat() {
        // Print what the deer eats
        System.out.println("Deer grazes on grass and leaves.");
    }

    // Override the sleep method from Animal
    @Override
    public void sleep() {
        // Print where the deer sleeps
        System.out.println("Deer sleeps in open fields.");
    }
}
// Main.java
// Subclass Main

// Define public class Main
public class Main {
    // Define the main method
    public static void main(String[] args) {
        // Create a new Lion object
        Lion lion = new Lion();
        // Call the eat method on the Lion object
        lion.eat();
        // Call the sleep method on the Lion object
        lion.sleep();

        // Print an empty line for separation
        System.out.println();

        // Create a new Tiger object
        Tiger tiger = new Tiger();
        // Call the eat method on the Tiger object
        tiger.eat();
        // Call the sleep method on the Tiger object
        tiger.sleep();

        // Print an empty line for separation
        System.out.println();

        // Create a new Deer object
        Deer deer = new Deer();
        // Call the eat method on the Deer object
        deer.eat();
        // Call the sleep method on the Deer object
        deer.sleep();
    }
}
```
Output:

Lion eats meat.
Lion sleeps on grassland.

Tiger eats meat and occasionally hunts in water.
Tiger sleeps in a hidden spot.

Deer grazes on grass and leaves.
Deer sleeps in open fields.
Explanation:

In this program, the Animal class is an abstract class that defines the abstract methods eat() and sleep(). The Lion, Tiger, and Deer classes extend the Animal class and provide their own implementations for the eat() and sleep() methods based on their specific behavior. The Main class demonstrates the usage of these classes by creating objects of each subclass and invoking the eat() and sleep() methods accordingly.

### 5. Write a Java program to create an abstract class Employee with abstract methods calculateSalary() and displayInfo(). Create subclasses Manager and Programmer that extend the Employee class and implement the respective methods to calculate salary and display information for each role.
Write a Java program to create an abstract class Employee with abstract methods calculateSalary() and displayInfo(). Create subclasses Manager and Programmer that extend the Employee class and implement the respective methods to calculate salary and display information for each role.

Sample Solution:

Java Code:
```java

// Employee.java
// Abstract class Employee

// Define abstract class Employee
abstract class Employee {
    // Declare protected variables for name and base salary
    protected String name;
    protected double baseSalary;

    // Constructor to initialize name and base salary
    public Employee(String name, double baseSalary) {
        this.name = name; // Set the name
        this.baseSalary = baseSalary; // Set the base salary
    }

    // Declare abstract method to calculate salary
    public abstract double calculateSalary();

    // Declare abstract method to display employee information
    public abstract void displayInfo();
} 

// Manager.java
// Subclass Manager

// Define class Manager that extends Employee
class Manager extends Employee {
    // Declare private variable for bonus
    private double bonus;

    // Constructor to initialize name, base salary, and bonus
    public Manager(String name, double baseSalary, double bonus) {
        // Call superclass constructor to set name and base salary
        super(name, baseSalary);
        this.bonus = bonus; // Set the bonus
    }

    // Override the calculateSalary method from Employee
    @Override
    public double calculateSalary() {
        // Return the total salary (base salary + bonus)
        return baseSalary + bonus;
    }

    // Override the displayInfo method from Employee
    @Override
    public void displayInfo() {
        // Print the manager's name
        System.out.println("Manager Name: " + name);
        // Print the base salary
        System.out.println("Base Salary: $" + baseSalary);
        // Print the bonus
        System.out.println("Bonus: $" + bonus);
        // Print the total salary
        System.out.println("Total Salary: $" + calculateSalary());
    }
}
// Programmer.java
// Class Programmer extending the Employee class
class Programmer extends Employee {
  // Private variable to store overtime hours
  private int overtimeHours;
  // Private variable to store hourly rate
  private double hourlyRate;

  // Constructor to initialize name, baseSalary, overtimeHours, and hourlyRate
  public Programmer(String name, double baseSalary, int overtimeHours, double hourlyRate) {
    // Calling the constructor of the superclass (Employee)
    super(name, baseSalary);
    // Setting the overtime hours
    this.overtimeHours = overtimeHours;
    // Setting the hourly rate
    this.hourlyRate = hourlyRate;
  }

  // Overriding the calculateSalary method
  @Override
  public double calculateSalary() {
    // Calculating the total salary by adding baseSalary and the product of overtimeHours and hourlyRate
    return baseSalary + (overtimeHours * hourlyRate);
  }

  // Overriding the displayInfo method
  @Override
  public void displayInfo() {
    // Printing the programmer's name
    System.out.println("Programmer Name: " + name);
    // Printing the base salary
    System.out.println("Base Salary: $" + baseSalary);
    // Printing the overtime hours
    System.out.println("Overtime Hours: " + overtimeHours);
    // Printing the hourly rate
    System.out.println("Hourly Rate: $" + hourlyRate);
    // Printing the total salary
    System.out.println("Total Salary: $" + calculateSalary());
  }
}
// Main.java
// Public class Main
public class Main {
  // Main method
  public static void main(String[] args) {
    // Creating an instance of Manager with name "Corona Cadogan", baseSalary 6000, and bonus 1000
    Employee manager = new Manager("Corona Cadogan", 6000, 1000);
    // Creating an instance of Programmer with name "Antal Nuka", baseSalary 5000, overtimeHours 20, and hourlyRate 25.0
    Employee programmer = new Programmer("Antal Nuka", 5000, 20, 25.0);

    // Calling displayInfo method on manager instance
    manager.displayInfo();
    // Printing a separator line
    System.out.println("---------------------");
    // Calling displayInfo method on programmer instance
    programmer.displayInfo();
  }
}
```
Output:

Manager Name: Corona Cadogan
Base Salary: $6000.0
Bonus: $1000.0
Total Salary: $7000.0
---------------------
Programmer Name: Antal Nuka
Base Salary: $5000.0
Overtime Hours: 20
Hourly Rate: $25.0
Total Salary: $5500.0
Explanation:

In the above exercise -

The abstract class "Employee" has two abstract methods: calculateSalary() and displayInfo(). The subclasses Manager and Programmer extend the Employee class and provide their own implementations of abstract methods.
The "Manager" class calculates the total salary by adding the bonus to the base salary, while the "Programmer" class calculates the total salary based on the number of overtime hours and the hourly rate.
In the main method, we create instances of Manager and Programmer, and then call the displayInfo() method on each object to display the information specific to each role.

### 6. Write a Java program to create an abstract class Shape3D with abstract methods calculateVolume() and calculateSurfaceArea(). Create subclasses Sphere and Cube that extend the Shape3D class and implement the respective methods to calculate the volume and surface area of each shape.
Write a Java program to create an abstract class Shape3D with abstract methods calculateVolume() and calculateSurfaceArea(). Create subclasses Sphere and Cube that extend the Shape3D class and implement the respective methods to calculate the volume and surface area of each shape.

Sample Solution:

Java Code:
```java

// Shape3D.java
// Abstract class Shape3D
abstract class Shape3D {
  // Abstract method to calculate volume
  public abstract double calculateVolume();

  // Abstract method to calculate surface area
  public abstract double calculateSurfaceArea();
} 

// Sphere.java
// Class Sphere extending Shape3D
class Sphere extends Shape3D {
  // Private variable to store radius
  private double radius;

  // Constructor to initialize radius
  public Sphere(double radius) {
    // Setting the radius value
    this.radius = radius;
  }

  // Overriding the calculateVolume method
  @Override
  public double calculateVolume() {
    // Calculating the volume of the sphere using the formula (4/3) * π * radius^3
    return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
  }

  // Overriding the calculateSurfaceArea method
  @Override
  public double calculateSurfaceArea() {
    // Calculating the surface area of the sphere using the formula 4 * π * radius^2
    return 4 * Math.PI * Math.pow(radius, 2);
  }
}
// Cube.java
// Class Cube extending Shape3D
class Cube extends Shape3D {
  // Private variable to store side length
  private double sideLength;

  // Constructor to initialize side length
  public Cube(double sideLength) {
    // Setting the side length value
    this.sideLength = sideLength;
  }

  // Overriding the calculateVolume method
  @Override
  public double calculateVolume() {
    // Calculating the volume of the cube using the formula sideLength^3
    return Math.pow(sideLength, 3);
  }

  // Overriding the calculateSurfaceArea method
  @Override
  public double calculateSurfaceArea() {
    // Calculating the surface area of the cube using the formula 6 * sideLength^2
    return 6 * Math.pow(sideLength, 2);
  }
} 
// Main.java
// Public class Main
public class Main {
  // Main method
  public static void main(String[] args) {
    // Creating an instance of Sphere with radius 7.0
    Shape3D sphere = new Sphere(7.0);
    // Creating an instance of Cube with side length 6.0
    Shape3D cube = new Cube(6.0);

    // Printing the volume of the sphere
    System.out.println("Sphere Volume: " + sphere.calculateVolume());
    // Printing the surface area of the sphere
    System.out.println("Sphere Surface Area: " + sphere.calculateSurfaceArea());

    // Printing the volume of the cube
    System.out.println("Cube Volume: " + cube.calculateVolume());
    // Printing the surface area of the cube
    System.out.println("Cube Surface Area: " + cube.calculateSurfaceArea());
  }
}
```
Output:

Sphere Volume: 1436.7550402417319
Sphere Surface Area: 615.7521601035994
Cube Volume: 216.0
Cube Surface Area: 216.0
Explanation:

In the above exercise -

The abstract class "Shape3D" has two methods calculateVolume() and calculateSurfaceArea(). The subclasses 'Sphere' and 'Cube' extend the Shape3D class and provide their own implementations for these abstract methods.
The "Sphere" class calculates the volume and surface area of a sphere using the given radius, while the Cube class calculates the volume and surface area of a cube using the given side length.
In the main method, we create instances of Sphere and Cube. We then call the calculateVolume() and calculateSurfaceArea() methods on each object to calculate and display the respective volume and surface area.

### 7. Write a Java program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine(). Create subclasses Car and Motorcycle that extend the Vehicle class and implement the respective methods to start and stop the engines for each vehicle type.

Write a Java program to create an abstract class  Vehicle with abstract methods startEngine() and stopEngine(). Create subclasses  Car and  Motorcycle that extend the  Vehicle class and implement the respective methods to start and stop the  engines for each vehicle type.

Sample Solution:

Java Code:
```java

// Vehicle.java
// Abstract class Vehicle
abstract class Vehicle {
  // Abstract method to start the engine
  public abstract void startEngine();

  // Abstract method to stop the engine
  public abstract void stopEngine();
} 

// Car.java
// Class Car extending Vehicle
class Car extends Vehicle {
  // Overriding the startEngine method
  @Override
  public void startEngine() {
    // Printing message to indicate engine start
    System.out.println("Car: Starting the engine...");
  }

  // Overriding the stopEngine method
  @Override
  public void stopEngine() {
    // Printing message to indicate engine stop
    System.out.println("Car: Stopping the engine...");
  }
} 
// Motorcycle.java
// Class Motorcycle extending Vehicle
class Motorcycle extends Vehicle {
  // Overriding the startEngine method
  @Override
  public void startEngine() {
    // Printing message to indicate engine start
    System.out.println("Motorcycle: Starting the engine...");
  }

  // Overriding the stopEngine method
  @Override
  public void stopEngine() {
    // Printing message to indicate engine stop
    System.out.println("Motorcycle: Stopping the engine...");
  }
} 
//Main.java
public class Main {
  // The main method, the entry point of the program
  public static void main(String[] args) {
    // Create an instance of Car as a Vehicle
    Vehicle car = new Car();
    // Create an instance of Motorcycle as a Vehicle
    Vehicle motorcycle = new Motorcycle();

    // Call the startEngine method on the car object
    car.startEngine();
    // Call the stopEngine method on the car object
    car.stopEngine();

    // Call the startEngine method on the motorcycle object
    motorcycle.startEngine();
    // Call the stopEngine method on the motorcycle object
    motorcycle.stopEngine();
  }
}
```
Output:

Car: Starting the engine...
Car: Stopping the engine...
Motorcycle: Starting the engine...
Motorcycle: Stopping the engine...
Explanation:

In the above exercise -

The abstract class " Vehicle" has two abstract methods: startEngine() and stopEngine(). The subclasses  Car and  Motorcycle extend the " Vehicle" class and provide their own implementations for these abstract methods.
The "Car" class starts and stops the car's engine, while the Motorcycle class starts and stops the motorcycle's engine.
In the main method, we create instances of Car and Motorcycle. We then call the startEngine() and stopEngine() methods on each object to start and stop the engines for both vehicle types.
### 8. Write a Java program to create an abstract class Person with abstract methods eat() and exercise(). Create subclasses Athlete and LazyPerson that extend the Person class and implement the respective methods to describe how each person eats and exercises.

Write a Java program to create an abstract class Person with abstract methods eat() and exercise(). Create subclasses Athlete and LazyPerson that extend the Person class and implement the respective methods to describe how each person eats and exercises.

Sample Solution:

Java Code:
```java

//Person.java
// Define an abstract class named Person
abstract class Person {
  // Declare an abstract method eat
  public abstract void eat();

  // Declare an abstract method exercise
  public abstract void exercise();
} 

//Athlete.java
// Define a class named Athlete that extends the Person class
class Athlete extends Person {
  // Override the eat method from the Person class
  @Override
  public void eat() {
    // Print a message about the athlete's diet
    System.out.println("Athlete: Include foods full of calcium, iron, potassium, and fiber.");
  }

  // Override the exercise method from the Person class
  @Override
  public void exercise() {
    // Print a message about the athlete's training
    System.out.println("Athlete: Training allows the body to gradually build up strength and endurance, improve skill levels and build motivation, ambition and confidence.");
  }
} 
//LazyPerson.java
// Define a class named LazyPerson that extends the Person class
class LazyPerson extends Person {
  // Override the eat method from the Person class
  @Override
  public void eat() {
    // Print a message about the lazy person's eating habits
    System.out.println("Couch Potato: Eating while watching TV also prolongs the time period that we're eating.");
  }

  // Override the exercise method from the Person class
  @Override
  public void exercise() {
    // Print a message about the lazy person's exercise habits
    System.out.println("Couch Potato: Rarely exercising or being physically active.");
  }
} 
//Main.java
// Define the Main class
public class Main {
  // The main method, the entry point of the program
  public static void main(String[] args) {
    // Create an instance of Athlete as a Person
    Person athlete = new Athlete();
    // Create an instance of LazyPerson as a Person
    Person lazyPerson = new LazyPerson();
    
    // Call the eat method on the athlete object
    athlete.eat();
    // Call the exercise method on the athlete object
    athlete.exercise();
    
    // Call the eat method on the lazyPerson object
    lazyPerson.eat();
    // Call the exercise method on the lazyPerson object
    lazyPerson.exercise();
  }
}
```
Output:

Athlete: Include foods full of calcium, iron, potassium, and fiber.
Athlete: Training allows the body to gradually build up strength and endurance, improve skill levels and build motivation, ambition and confidence.
Couch Potato: Eating while watching TV also prolongs the time period that we're eating.
Couch Potato: Rarely exercising or being physically active.
Explanation:

In the above exercise -

The abstract class "Person" with two abstract methods eat() and exercise(). The subclasses Athlete and CouchPotato extend the Person class and provide their own implementations for these abstract methods.
The "Athlete" class describes how an athlete eats a balanced diet and engages in regular intense workouts, while the "LazyPerson" class describes how a couch potato consumes junk food and snacks while rarely exercising or being physically active.
In the main method, we create instances of Athlete and LazyPerson, and then call the eat() and exercise() methods on each object to describe the eating and exercising habits of both types of people.
### 9. Write a Java program to create an abstract class Instrument with abstract methods play() and tune(). Create subclasses for Glockenspiel and Violin that extend the Instrument class and implement the respective methods to play and tune each instrument.

Write a Java program to create an abstract class  Instrument with abstract methods play() and tune(). Create subclasses for  Glockenspiel and  Violin that extend the  Instrument class and implement the respective methods to play and tune each  instrument.

Sample Solution:

Java Code:
```java

//Instrument.java
// Define an abstract class named Instrument
abstract class Instrument {
  // Declare an abstract method play
  public abstract void play();

  // Declare an abstract method tune
  public abstract void tune();
}

//Glockenspiel.java
// Define a class named Glockenspiel that extends the Instrument class
class Glockenspiel extends Instrument {
  // Override the play method from the Instrument class
  @Override
  public void play() {
    // Print a message about playing the glockenspiel
    System.out.println("Glockenspiel: Playing the notes on the metal bars.");
  }

  // Override the tune method from the Instrument class
  @Override
  public void tune() {
    // Print a message about tuning the glockenspiel
    System.out.println("Glockenspiel: Tuning the metal bars to the correct pitch.");
  }
} 
//Violin.java
// Define a class named Violin that extends the Instrument class
class Violin extends Instrument {
  // Override the play method from the Instrument class
  @Override
  public void play() {
    // Print a message about playing the violin
    System.out.println("Violin: Playing the strings with a bow or fingers.");
  }

  // Override the tune method from the Instrument class
  @Override
  public void tune() {
    // Print a message about tuning the violin
    System.out.println("Violin: Tuning the strings to the correct pitch.");
  }
}
//Main.java
// Define the Main class
public class Main {
  // The main method, the entry point of the program
  public static void main(String[] args) {
    // Create an instance of Glockenspiel as an Instrument
    Instrument glockenspiel = new Glockenspiel();
    // Create an instance of Violin as an Instrument
    Instrument violin = new Violin();

    // Call the play method on the glockenspiel object
    glockenspiel.play();
    // Call the tune method on the glockenspiel object
    glockenspiel.tune();

    // Call the play method on the violin object
    violin.play();
    // Call the tune method on the violin object
    violin.tune();
  }
}
```
Output:

Glockenspiel: Playing the notes on the metal bars.
Glockenspiel: Tuning the metal bars to the correct pitch.
Violin: Playing the strings with a bow or fingers.
Violin: Tuning the strings to the correct pitch.
Explanation:

In the above exercise -

The abstract class " Instrument" has two abstract methods: play() and tune(). The subclasses  Glockenspiel and  Violin extend the  Instrument class and provide their own implementations for these abstract methods.
The " Glockenspiel" class describes how a glockenspiel plays the notes on the metal bars and tunes them to the correct pitch, while the "Violin" class describes how a violin plays the strings with a bow or fingers and tunes the strings to the correct pitch.
In the main method, we create instances of Glockenspiel and Violin, and then call the play() and tune() methods on each object to demonstrate how each instrument plays and tunes.
### 10. Write a Java program to create an abstract class Shape2D with abstract methods draw() and resize(). Create subclasses Rectangle and Circle that extend the Shape2D class and implement the respective methods to draw and resize each shape.

Write a Java program to create an abstract class Shape2D with abstract methods draw() and resize(). Create subclasses Rectangle and Circle that extend the Shape2D class and implement the respective methods to draw and resize each shape.

Sample Solution:

Java Code:
```java

//Shape2D.java
// Define an abstract class named Shape2D
abstract class Shape2D {
  // Declare an abstract method draw
  public abstract void draw();

  // Declare an abstract method resize
  public abstract void resize();
} 

// Rectangle.java
// Define a class named Rectangle that extends Shape2D
class Rectangle extends Shape2D {

  // Override the draw method from Shape2D
  @Override
  // Implementation of the draw method that prints a message
  public void draw() {
    System.out.println("Rectangle: Drawing a rectangle.");
  }

  // Override the resize method from Shape2D
  @Override
  // Implementation of the resize method that prints a message
  public void resize() {
    System.out.println("Rectangle: Resizing the rectangle.");
  }
}
// Circle.java
// Define a class named Circle that extends Shape2D
class Circle extends Shape2D {

  // Override the draw method from Shape2D
  @Override
  // Implementation of the draw method that prints a message
  public void draw() {
    System.out.println("Circle: Drawing a circle.");
  }

  // Override the resize method from Shape2D
  @Override
  // Implementation of the resize method that prints a message
  public void resize() {
    System.out.println("Circle: Resizing the circle.");
  }
} 
// Main.java
// Define a public class named Main
public class Main {
  // Define the main method, which is the entry point of the program
  public static void main(String[] args) {
    // Create an instance of Rectangle and assign it to a Shape2D reference
    Shape2D rectangle = new Rectangle();
    // Create an instance of Circle and assign it to a Shape2D reference
    Shape2D circle = new Circle();

    // Call the draw method on the rectangle object
    rectangle.draw();
    // Call the resize method on the rectangle object
    rectangle.resize();

    // Call the draw method on the circle object
    circle.draw();
    // Call the resize method on the circle object
    circle.resize();
  }
}
``` 
Output:

Rectangle: Drawing a rectangle.
Rectangle: Resizing the rectangle.
Circle: Drawing a circle.
Circle: Resizing the circle.
Explanation:

In the above exercise -

The abstract class "Shape2D" has two abstract methods: draw() and resize(). The subclasses Rectangle and Circle extend the Shape2D class and provide their own implementations for these abstract methods.
The "Rectangle" class describes how to draw and resize a rectangle, while the "Circle" class describes how to draw and resize a circle.
In the main method, we create instances of Rectangle and Circle, and then call the draw() and resize() methods on each object to demonstrate how each shape is drawn and resized.
### 11. Write a Java program to create an abstract class Bird with abstract methods fly() and makeSound(). Create subclasses Eagle and Hawk that extend the Bird class and implement the respective methods to describe how each bird flies and makes a sound.
Write a Java program to create an abstract class Bird with abstract methods fly() and makeSound(). Create subclasses Eagle and Hawk that extend the Bird class and implement the respective methods to describe how each bird flies and makes a sound.

Sample Solution:

Java Code:
```java

// Bird.java
// Define an abstract class named Bird
abstract class Bird {
  // Declare an abstract method named fly
  public abstract void fly();

  // Declare an abstract method named makeSound
  public abstract void makeSound();
}

// Eagle.java
// Define a class named Eagle that extends Bird
class Eagle extends Bird {

  // Override the fly method from Bird
  @Override
  // Implementation of the fly method that prints a message
  public void fly() {
    System.out.println("Eagle: Flying high in the sky.");
  }

  // Override the makeSound method from Bird
  @Override
  // Implementation of the makeSound method that prints a message
  public void makeSound() {
    System.out.println("Eagle: Screech! Screech!");
  }
}
// Hawk.java
// Define a class named Hawk that extends Bird
class Hawk extends Bird {

  // Override the fly method from Bird
  @Override
  // Implementation of the fly method that prints a message
  public void fly() {
    System.out.println("Hawk: Soaring through the air.");
  }

  // Override the makeSound method from Bird
  @Override
  // Implementation of the makeSound method that prints a message
  public void makeSound() {
    System.out.println("Hawk: Caw! Caw!");
  }
} 
// Main.java
// Define a public class named Main
public class Main {
  // Define the main method, which is the entry point of the program
  public static void main(String[] args) {
    // Create an instance of Eagle and assign it to a Bird reference
    Bird eagle = new Eagle();
    // Create an instance of Hawk and assign it to a Bird reference
    Bird hawk = new Hawk();

    // Call the fly method on the eagle object
    eagle.fly();
    // Call the makeSound method on the eagle object
    eagle.makeSound();

    // Call the fly method on the hawk object
    hawk.fly();
    // Call the makeSound method on the hawk object
    hawk.makeSound();
  }
}
```
Output:

Eagle: Flying high in the sky.
Eagle: Screech! Screech!
Hawk: Soaring through the air.
Hawk: Caw! Caw!
Explanation:

In the above exercise -

The abstract class "Bird" has two abstract methods fly() and makeSound(). The subclasses Eagle and Hawk extend the Bird class and provide their own implementations for these abstract methods.
The "Eagle" class describes how an eagle flies high in the sky and makes a screeching sound, while the "Hawk" class describes how a hawk soars through the air and makes a cawing sound.
In the main method, we create instances of Eagle and Hawk, and then call the fly() and makeSound() methods on each object to describe how each bird flies and makes a sound.

### 12. Write a Java program to create an abstract class GeometricShape with abstract methods area() and perimeter(). Create subclasses Triangle and Square that extend the GeometricShape class and implement the respective methods to calculate the area and perimeter of each shape.

Write a Java program to create an abstract class GeometricShape with abstract methods area() and perimeter(). Create subclasses Triangle and Square that extend the GeometricShape class and implement the respective methods to calculate the area and perimeter of each shape.

Sample Solution:

Java Code:
```java

// GeometricShape.java
// Define an abstract class named GeometricShape
abstract class GeometricShape {
  // Declare an abstract method named area that returns a double
  public abstract double area();

  // Declare an abstract method named perimeter that returns a double
  public abstract double perimeter();
} 

// Triangle.java
// Define a class named Triangle that extends GeometricShape
class Triangle extends GeometricShape {
  // Declare private instance variables for the sides of the triangle
  private double side1;
  private double side2;
  private double side3;

  // Define a constructor that initializes the sides of the triangle
  public Triangle(double side1, double side2, double side3) {
    // Assign the parameters to the instance variables
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  // Override the area method from GeometricShape
  @Override
  // Implementation of the area method that calculates and returns the area of the triangle
  public double area() {
    // Calculate the semi-perimeter of the triangle
    double s = (side1 + side2 + side3) / 2;
    // Calculate and return the area using Heron's formula
    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
  }

  // Override the perimeter method from GeometricShape
  @Override
  // Implementation of the perimeter method that returns the perimeter of the triangle
  public double perimeter() {
    // Return the sum of the sides of the triangle
    return side1 + side2 + side3;
  }
} 
// Square.java
// Define a class named Square that extends GeometricShape
class Square extends GeometricShape {
  // Declare a private instance variable for the side of the square
  private double side;

  // Define a constructor that initializes the side of the square
  public Square(double side) {
    // Assign the parameter to the instance variable
    this.side = side;
  }

  // Override the area method from GeometricShape
  @Override
  // Implementation of the area method that calculates and returns the area of the square
  public double area() {
    // Calculate and return the area by squaring the side length
    return side * side;
  }

  // Override the perimeter method from GeometricShape
  @Override
  // Implementation of the perimeter method that returns the perimeter of the square
  public double perimeter() {
    // Calculate and return the perimeter by multiplying the side length by 4
    return 4 * side;
  }
} 
// Define the Main class
public class Main {
  // Main method: entry point of the program
  public static void main(String[] args) {
    // Create a Triangle object with sides 4, 5, and 6
    GeometricShape triangle = new Triangle(4, 5, 6);
    // Create a Square object with side length 6
    GeometricShape square = new Square(6);

    // Print the area of the triangle
    System.out.println("Triangle Area: " + triangle.area());
    // Print the perimeter of the triangle
    System.out.println("Triangle Perimeter: " + triangle.perimeter());

    // Print the area of the square
    System.out.println("Square Area: " + square.area());
    // Print the perimeter of the square
    System.out.println("Square Perimeter: " + square.perimeter());
  }
}
```
Output:

Triangle Area: 9.921567416492215
Triangle Perimeter: 15.0
Square Area: 36.0
Square Perimeter: 24.0
Explanation:

In the above exercise -

The abstract class GeometricShape has two abstract methods: area() and perimeter(). The subclasses Triangle and Square extend the GeometricShape class and provide their own implementations for these abstract methods.
The "Triangle" class calculates the area and perimeter of a triangle using its three sides, while the "Square" class calculates the area and perimeter of a square using its side length.
In the main method, we create instances of Triangle and Square, and then call the area() and perimeter() methods on each object to calculate and display the respective area and perimeter.
