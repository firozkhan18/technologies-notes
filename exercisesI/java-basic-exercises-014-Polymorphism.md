# Java Exercises Polymorphism

Polymorphism

In Core, Java Polymorphism is one of easy concept to understand. Polymorphism definition is that Poly means many and morphos means forms. It describes the feature of languages that allows the same word or symbol to be interpreted correctly in different situations based on the context. There are two types of Polymorphism available in Java. For example, in English, the verb “run” means different things if you use it with “a footrace,” a “business,” or “a computer.” You understand the meaning of “run” based on the other words used with it. Check out this article for more information.

### 1. Write a Java program to create a base class Animal (Animal Family) with a method called Sound(). Create two subclasses Bird and Cat. Override the Sound() method in each subclass to make a specific sound for each animal.

Write a Java program to create a base class Animal (Animal Family) with a method called Sound(). Create two subclasses Bird and Cat. Override the Sound() method in each subclass to make a specific sound for each animal.

In the given exercise, here is a simple diagram illustrating polymorphism implementation:

Polymorphism: Animal Class with Bird and Cat Subclasses for Specific Sounds
In the above diagram, we have a base class Animal with the makeSound() method. It serves as the superclass for two subclasses, Bird and Cat. Both subclasses override the makeSound() method to provide their own sound implementations.

Sample Solution:

Java Code:
```java
// Animal.java
// Base class Animal

public class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

// Bird.java
// Subclass Bird

public class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The bird chirps");
    }
}
// Cat.java
// Subclass Cat

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows");
    }
}
// Main.java
// Main class

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird();
        Cat cat = new Cat();

        animal.makeSound(); // Output: The animal makes a sound
        bird.makeSound();   // Output: The bird chirps
        cat.makeSound();    // Output: The cat meows
    }
}
```
Sample Output:

The animal makes a sound
The bird chirps
The cat meows

### 2. Write a Java program to create a class Vehicle with a method called speedUp(). Create two subclasses Car and Bicycle. Override the speedUp() method in each subclass to increase the vehicle's speed differently.

Write a Java program to create a class Vehicle with a method called speedUp(). Create two subclasses Car and  Bicycle. Override the speedUp() method in each subclass to increase the vehicle's speed differently.

In the given exercise, here is a simple diagram illustrating polymorphism implementation:

Polymorphism: Vehicle Class with Car and Bicycle Subclasses for Speed Control
In the above diagram, Vehicle is the base class, and Car and  Motorcycle are the subclasses. The arrow represents the inheritance relationship, indicating that Car and  Motorcycle inherit from Vehicle.


Since both Car and Motorcycle are subclasses of Vehicle, they inherit the speed field and the speedUp() method. However, they override the speedUp() method to provide their own implementation.


This polymorphic relationship allows objects of type Car and Motorcycle to be treated as objects of type Vehicle. This means that you can use a Car or Motorcycle object where a Vehicle object is expected, which enables flexibility and code reuse.

Sample Solution:

Java Code:
```java
// Vehicle.java
// Base class Vehicle

class Vehicle {
    private int speed;

    public void speedUp() {
        speed += 10;
    }

    public int getSpeed() {
        return speed;
    }
}

// Car.java
// Subclass Car

class Car extends Vehicle {
    @Override
    public void speedUp() {
        super.speedUp();
        System.out.println("\nCar speed increased by 22 units.");
    }
} 
// Motorcycle.java
// Subclass Motorcycle

class Motorcycle extends Vehicle {
    @Override
    public void speedUp() {
        super.speedUp();
        System.out.println("Motorcycle speed increased by 12 units");
    }
}
// Main.java
// Main class

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();
        System.out.println("Car initial speed: " + car.getSpeed());
        System.out.println("Motorcycle initial speed: " + motorcycle.getSpeed());
        car.speedUp();
        motorcycle.speedUp();
        System.out.println("\nCar speed after speeding up: " + car.getSpeed());
        System.out.println("Motorcycle speed after speeding up: " + motorcycle.getSpeed());
    }
}
```
Sample Output:

Car initial speed: 0
Motorcycle initial speed: 0

Car speed increased by 22 units.
Motorcycle speed increased by 12 units

Car speed after speeding up: 10
Motorcycle speed after speeding up: 10

### 3. Write a Java program to create a base class Shape with a method called calculateArea(). Create three subclasses: Circle, Rectangle, and Triangle. Override the calculateArea() method in each subclass to calculate and return the shape's area.

Write a Java program to create a base class Shape with a method called calculateArea(). Create three subclasses: Circle, Rectangle, and Triangle. Override the calculateArea() method in each subclass to calculate and return the shape's area.

In the given exercise, here is a simple diagram illustrating polymorphism implementation:

Polymorphism: Shape Class with Circle, Rectangle, and Triangle Subclasses for Area Calculation
In the above diagram, the Shape class is the base class, and it has a single method calculateArea(). The Circle, Rectangle, and Triangle classes inherit from the Shape class and override the calculateArea() method.


This diagram visually represents the class structure and the polymorphism relationship between the classes involved in the implementation.

Sample Solution:

Java Code:
```java
// Shape.java
// Base class Shape
public class Shape {
    public double calculateArea() {
        return 0; // Default implementation returns 0
    }
}

// Circle.java
// Subclass Circle
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // Calculate area of circle
    }
}
// Rectangle.java
// Subclass Rectangle
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height; // Calculate area of rectangle
    }
}
// Triangle.java
// Subclass Triangle
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height; // Calculate area of triangle
    }
}
// Main.java
// Main class
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        System.out.println("Area of Circle: " + circle.calculateArea());

        Rectangle rectangle = new Rectangle(12, 34);
        System.out.println("\nArea of Rectangle: " + rectangle.calculateArea());

        Triangle triangle = new Triangle(5, 9);
        System.out.println("\nArea of Triangle: " + triangle.calculateArea());
    }
}
```
Sample Output:

Area of Circle: 50.26548245743669

Area of Rectangle: 408.0

Area of Triangle: 22.5

### 4. Write a Java program to create a class Employee with a method called calculateSalary(). Create two subclasses Manager and Programmer. In each subclass, override the calculateSalary() method to calculate and return the salary based on their specific roles.

Write a Java program to create a class Employee with a method called calculateSalary(). Create two subclasses Manager and Programmer. In each subclass, override the calculateSalary() method to calculate and return the salary based on their specific roles.

In the given exercise, here is a simple diagram illustrating polymorphism implementation:

Polymorphism: Employee Class with Manager and Programmer Subclasses for Salary Calculation
In the above diagram, the Employee class is the base class, and it has two subclasses, Manager and Programmer. The Employee class has private instance variables name and role, along with getter methods for retrieving their values. It also has a method calculateSalary() which returns a double.


The diagram demonstrates the inheritance relationship between the classes and how the calculateSalary() method is polymorphically overridden in the subclasses.

Sample Solution:

Java Code:
```java
// Employee.java
// Base class Employee
class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double calculateSalary() {
        return 0.0;
    }
}

// Manager.java
// Subclass Manager
class Manager extends Employee {
    private double baseSalary;
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, "Manager");
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}
// Programmer.java
// Subclass Programmer
class Programmer extends Employee {
    private double baseSalary;
    private double overtimePay;

    public Programmer(String name, double baseSalary, double overtimePay) {
        super(name, "Programmer");
        this.baseSalary = baseSalary;
        this.overtimePay = overtimePay;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + overtimePay;
    }
}
// Main.java
// Main class
public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Manager("Lilo Heidi", 7500.0, 1500.0);
        Employee emp2 = new Programmer("Margrit Cathrin", 5000.0, 600.0);

        System.out.println("Manager: " + emp1.getName() + "\nRole: " + emp1.getRole() + "\nSalary: $" + emp1.calculateSalary());
        System.out.println("\nProgrammer: " + emp2.getName() + "\nRole: " + emp2.getRole() + "\nSalary: $" + emp2.calculateSalary());
    }
}
```
Sample Output:

Manager: Lilo Heidi
Role: Manager
Salary: $9000.0

Programmer: Margrit Cathrin
Role: Programmer
Salary: $5600.0

### 5. Write a Java program to create a base class Sports with a method called play(). Create three subclasses: Football, Basketball, and Rugby. Override the play() method in each subclass to play a specific statement for each sport.

Write a Java program to create a base class Sports with a method called play(). Create three subclasses: Football, Basketball, and Rugby. Override the play() method in each subclass to play a specific statement for each sport.

In the given exercise, here is a simple diagram illustrating polymorphism implementation:

Polymorphism: Sports Class with Football, Basketball, and Rugby Subclasses for Playing Statements
In the above diagram, the Sports class is the base class with a play() method. The Football, Basketball, and Rugby classes are subclasses that inherit from the Sports class and override the play() method to provide their specific implementation.

Sample Solution:

Java Code:
```java
// Sports.java
// Base class Sports
class Sports {
    public void play() {
        System.out.println("Playing a sport...\n");
    }
}

// Football.java
// Subclass Football
class Football extends Sports {
    @Override
    public void play() {
        System.out.println("Playing football...");
    }
}
// Basketball.java
// Subclass Basketball
class Basketball extends Sports {
    @Override
    public void play() {
        System.out.println("Playing basketball...");
    }
}
// Rugby.java
// Subclass Rugby

class Rugby extends Sports {
    @Override
    public void play() {
        System.out.println("Playing rugby...");
    }
}
// Main.java
// Main class
public class Main {
    public static void main(String[] args) {
        Sports sports = new Sports();
        Football football = new Football();
        Basketball basketball = new Basketball();
        Rugby rugby = new Rugby();

        sports.play();
        football.play();
        basketball.play();
        rugby.play();
    }
}
```
Sample Output:

Playing a sport...

Playing football...
Playing basketball...
Playing rugby...

### 6. Write a Java program to create a class Shape with methods getArea() and getPerimeter(). Create three subclasses: Circle, Rectangle, and Triangle. Override the getArea() and getPerimeter() methods in each subclass to calculate and return the area and perimeter of the respective shapes.

Write a Java program to create a class Shape with methods getArea() and getPerimeter(). Create three subclasses: Circle, Rectangle, and Triangle. Override the getArea() and getPerimeter() methods in each subclass to calculate and return the area and perimeter of the respective shapes.

In the given exercise, here is a simple diagram illustrating polymorphism implementation:

Polymorphism: Shape Class with Circle, Rectangle, and Triangle Subclasses for Area and Perimeter Calculation
In the above diagram, the Circle, Rectangle, and Triangle classes have the getArea() and getPerimeter() methods. These methods allow them to calculate and return the area and perimeter specific to each shape.

Sample Solution:

Java Code:
```java
// Shape.java
// Base class Shape
abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
}

// Circle.java
// Subclass Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
// Rectangle.java
// Subclass Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
// Triangle.java
// Subclass Triangle

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}
// Main.java
// Main class
public class Main {
    public static void main(String[] args) {
		double r = 4.0;
        Circle circle = new Circle(r);
		double rs1 = 4.0, rs2 = 6.0;
		double ts1 = 3.0, ts2 = 4.0, ts3 = 5.0;
        Rectangle rectangle = new Rectangle(rs1, rs2);
        Triangle triangle = new Triangle(ts1, ts2, ts3);
        System.out.println("Radius of the Circle"+r);
        System.out.println("Area of the Circle: " + circle.getArea());
        System.out.println("Perimeter of the Circle: " + circle.getPerimeter());
		System.out.println("\nSides of the rectangle are: "+rs1+','+rs2);
        System.out.println("Area of the Rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of the Rectangle: " + rectangle.getPerimeter());
		System.out.println("\nSides of the Traiangel are: "+ts1+','+ts2+','+ts3);
        System.out.println("Area of the Triangle: " + triangle.getArea());
        System.out.println("Perimeter of the Triangle: " + triangle.getPerimeter());
    }
}
```
Sample Output:

Radius of the Circle4.0
Area of the Circle: 50.26548245743669
Perimeter of the Circle: 25.132741228718345

Sides of the rectangle are: 4.0,6.0
Area of the Rectangle: 24.0
Perimeter of the Rectangle: 20.0

Sides of the Traiangel are: 3.0,4.0,5.0
Area of the Triangle: 6.0
Perimeter of the Triangle: 12.0

### 7. Write a Java program to create a base class Animal with methods move() and makeSound(). Create two subclasses Bird and Panthera. Override the move() method in each subclass to describe how each animal moves. Also, override the makeSound() method in each subclass to make a specific sound for each animal.
Write a Java program to create a base class Animal with methods move() and makeSound(). Create two subclasses Bird and Panthera. Override the move() method in each subclass to describe how each animal moves. Also, override the makeSound() method in each subclass to make a specific sound for each animal.

Sample Solution:

Java Code:
```java
//Animal.java
class Animal {
  public void move() {
    System.out.println("Animal moves");
  }

  public void makeSound() {
    System.out.println("Animal makes a sound");
  }
}

//Bird.java

class Bird extends Animal {
  @Override
  public void move() {
    System.out.println("Bird flies");
  }

  @Override
  public void makeSound() {
    System.out.println("Bird chirps");
  }
}
//Panthera.java

class Panthera extends Animal {
  @Override
  public void move() {
    System.out.println("Panthera walks");
  }

  @Override
  public void makeSound() {
    System.out.println("Panthera roars");
  }
}
//Main.java
public class Main {
  public static void main(String[] args) {
    Animal bird = new Bird();
    Animal panthera = new Panthera();

    performAction(bird);
    performAction(panthera);
  }

  public static void performAction(Animal animal) {
    animal.move();
    animal.makeSound();
  }
}
```
Sample Output:

Bird flies
Bird chirps
Panthera walks
Panthera roars
Explanation:

We have the "Animal" class as the base class, and "Bird" and "Panthera" are its subclasses. Each subclass overrides the move() and makeSound() methods to provide their specific implementations.


In the "Main" class, we have a static method performAction(Animal animal) that takes an object of the base class Animal as a parameter. Inside this method, we call the move() and makeSound() methods on the animal object. Since the performAction method takes an Animal type parameter, it can accept Bird and Panthera objects.

### 8. Write a Java program to create a base class Shape with methods draw() and calculateArea(). Create three subclasses: Circle, Square, and Triangle. Override the draw() method in each subclass to draw the respective shape, and override the calculateArea() method to calculate and return the area of each shape.
Write a Java program to create a base class Shape with methods draw() and calculateArea(). Create three subclasses: Circle, Square, and Triangle. Override the draw() method in each subclass to draw the respective shape, and override the calculateArea() method to calculate and return the area of each shape.

Sample Solution:

Java Code:
```java
//Shape.java
abstract class Shape {
  public abstract void draw();

  public abstract double calculateArea();
}

//Circle.java

class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public void draw() {
    System.out.println("Drawing a circle");
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }
}
//Square.java

class Square extends Shape {
  private double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public void draw() {
    System.out.println("Drawing a square");
  }

  @Override
  public double calculateArea() {
    return side * side;
  }
}
//Triangle.java
class Triangle extends Shape {
  private double base;
  private double height;

  public Triangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  @Override
  public void draw() {
    System.out.println("Drawing a triangle");
  }

  @Override
  public double calculateArea() {
    return 0.5 * base * height;
  }
}
//Main.java
public class Main {
  public static void main(String[] args) {
    Shape circle = new Circle(7.0);
    Shape square = new Square(12.0);
    Shape triangle = new Triangle(5.0, 3.0);

    drawShapeAndCalculateArea(circle);
    drawShapeAndCalculateArea(square);
    drawShapeAndCalculateArea(triangle);
  }

  public static void drawShapeAndCalculateArea(Shape shape) {
    shape.draw();
    double area = shape.calculateArea();
    System.out.println("Area: " + area);
  }
}
```
Sample Output:

Drawing a circle
Area: 153.93804002589985
Drawing a square
Area: 144.0
Drawing a triangle
Area: 7.5
Explanation:

In the above exercise -

"Shape" is the base abstract class, with Circle, Square, and Triangle as its subclasses. Each subclass overrides the draw() method to provide their specific shape drawing implementation. It also overrides the calculateArea() method to calculate and return the area of each shape.
In the "Main()" class, we have a static method drawShapeAndCalculateArea(Shape shape) that takes an object of the base class Shape as a parameter. Inside this method, we call the draw() and calculateArea() methods on the shape object. Since the drawShapeAndCalculateArea method takes a Shape type parameter, it can accept objects of all three subclasses: Circle, Square, and Triangle, thanks to polymorphism.

### 9. Write a Java program to create a base class BankAccount with methods deposit() and withdraw(). Create two subclasses SavingsAccount and CheckingAccount. Override the withdraw() method in each subclass to impose different withdrawal limits and fees.

Write a Java program to create a base class BankAccount with methods deposit() and withdraw(). Create two subclasses SavingsAccount and CheckingAccount. Override the withdraw() method in each subclass to impose different withdrawal limits and fees.

Sample Solution:

Java Code:
```java
//BankAccount.java
class BankAccount {
  private double balance;

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
    } else {
      System.out.println("Insufficient funds.");
    }
  }
}

//SavingsAccount.java

class SavingsAccount extends BankAccount {
  private double withdrawalLimit;

  public SavingsAccount(double initialBalance, double withdrawalLimit) {
    super(initialBalance);
    this.withdrawalLimit = withdrawalLimit;
  }

  @Override
  public void withdraw(double amount) {
    if (amount <= withdrawalLimit) {
      super.withdraw(amount);
    } else {
      System.out.println("Withdrawal limit exceeded.");
    }
  }
}
//CheckingAccount.java
class CheckingAccount extends BankAccount {
  private double overdraftFee;

  public CheckingAccount(double initialBalance, double overdraftFee) {
    super(initialBalance);
    this.overdraftFee = overdraftFee;
  }

  @Override
  public void withdraw(double amount) {
    if (amount <= getBalance()) {
      super.withdraw(amount);
    } else {
      System.out.println("Overdraft fee applied.");
      super.withdraw(amount + overdraftFee);
    }
  }
}
//Main.java
public class Main {
  public static void main(String[] args) {
    BankAccount savingsAccount = new SavingsAccount(2000, 650);
    BankAccount checkingAccount = new CheckingAccount(1000, 100);

    withdrawFromAccount(savingsAccount, 300);
    withdrawFromAccount(checkingAccount, 250);

    System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
    System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
  }

  public static void withdrawFromAccount(BankAccount account, double amount) {
    account.withdraw(amount);
  }
}
```
Sample Output:

Savings Account Balance: 1700.0
Checking Account Balance: 750.0
Explanation:

In the above exercise -

The "BankAccount" class is the base class, and SavingsAccount and CheckingAccount are its subclasses. Each subclass overrides the withdraw() method to impose different withdrawal limits and fees based on their specific rules.
In the "Main" class, we have a static method withdrawFromAccount(BankAccount account, double amount) that takes an object of the base class BankAccount as a parameter. Inside this method, we call the withdraw() method on the account object. Since the withdrawFromAccount method takes a BankAccount type parameter, it can accept SavingsAccount and CheckingAccount objects, thanks to polymorphism.

### 10. Write a Java program to create a base class Animal with methods eat() and sound(). Create three subclasses: Lion, Tiger, and Panther. Override the eat() method in each subclass to describe what each animal eats. In addition, override the sound() method to make a specific sound for each animal.

Write a Java program to create a base class Animal with methods eat() and sound(). Create three subclasses: Lion, Tiger, and Panther. Override the eat() method in each subclass to describe what each animal eats. In addition, override the sound() method to make a specific sound for each animal.

Sample Solution:

Java Code:
```java
//Animal.java
class Animal {
  public void eat() {
    System.out.println("Animal eats.");
  }

  public void sound() {
    System.out.println("Animal makes a sound.");
  }
}

//Lion.java
class Lion extends Animal {
  @Override
  public void eat() {
    System.out.println("Lion eats meat.");
  }

  @Override
  public void sound() {
    System.out.println("Lion roars.");
  }
}
//Tiger.java
class Tiger extends Animal {
  @Override
  public void eat() {
    System.out.println("Tiger eats meat and sometimes fish.");
  }

  @Override
  public void sound() {
    System.out.println("Tiger growls.");
  }
}
//Panther.java
class Panther extends Animal {
  @Override
  public void eat() {
    System.out.println("Panther eats meat and small mammals.");
  }

  @Override
  public void sound() {
    System.out.println("Panther purrs and sometimes hisses.");
  }
}
//Main.java
public class Main {
  public static void main(String[] args) {
    Animal lion = new Lion();
    Animal tiger = new Tiger();
    Animal panther = new Panther();

    lion.eat();
    lion.sound();

    tiger.eat();
    tiger.sound();

    panther.eat();
    panther.sound();
  }
}
```
Sample Output:

Lion eats meat.
Lion roars.
Tiger eats meat and sometimes fish.
Tiger growls.
Panther eats meat and small mammals.
Panther purrs and sometimes hisses.
Explanation:

In the above exercise -

The "Animal" class is the base class and 'Lion', 'Tiger', and 'Panther' are its subclasses. Each subclass overrides the eat() method to describe what each animal eats and the sound() method to make a specific sound for each animal.
In the main() method, we create instances of Lion, Tiger, and Panther. We then call the eat() and sound() methods on these objects. Since these methods are overridden in the subclasses, the appropriate behavior for each animal will be displayed when we run the program.

### 11. Write a Java program to create a base class Vehicle with methods startEngine() and stopEngine(). Create two subclasses Car and Motorcycle. Override the startEngine() and stopEngine() methods in each subclass to start and stop the engines differently.

Write a Java program to create a base class  Vehicle with methods startEngine() and stopEngine(). Create two subclasses  Car and  Motorcycle. Override the startEngine() and stopEngine() methods in each subclass to start and stop the  engines differently.

Sample Solution:

Java Code:
```java
//Vehicle.java
abstract class Vehicle {
  public abstract void startEngine();

  public abstract void stopEngine();
}

//Car.java
class Car extends Vehicle {
  @Override
  public void startEngine() {
    System.out.println("Car engine started with a key.");
  }

  @Override
  public void stopEngine() {
    System.out.println("Car engine stopped when the key was turned off.");
  }
}
//Motorcycle.java
class Motorcycle extends Vehicle {
  @Override
  public void startEngine() {
    System.out.println("Motorcycle engine started with a kick-start.");
  }

  @Override
  public void stopEngine() {
    System.out.println("Motorcycle engine stopped when ignition was turned off.");
  }
}
//Main.java
public class Main {
  public static void main(String[] args) {
    Vehicle car = new Car();
    Vehicle motorcycle = new Motorcycle();

    startAndStopEngine(car);
    startAndStopEngine(motorcycle);
  }

  public static void startAndStopEngine(Vehicle vehicle) {
    vehicle.startEngine();
    vehicle.stopEngine();
  }
}
```
Sample Output:

Car engine started with a key.
Car engine stopped when the key was turned off.
Motorcycle engine started with a kick-start.
Motorcycle engine stopped when ignition was turned off.
Explanation:

In the above exercise -

The " Vehicle" class is the base abstract class, and Car and Motorcycle are its concrete subclasses. Each subclass overrides the startEngine() and stopEngine() methods to provide different ways of starting and stopping the engines based on the vehicle type.
In the Main class, we have a static method startAndStopEngine(Vehicle vehicle) that takes an object of the base class Vehicle as a parameter. Inside this method, we call the startEngine() and stopEngine() methods on the  vehicle object. Since the startAndStopEngine method takes a  Vehicle type parameter, it can accept  Car and  Motorcycle objects,

### 12. Write a Java program to create a base class Shape with methods draw() and calculateArea(). Create two subclasses Circle and Cylinder. Override the draw() method in each subclass to draw the respective shape. In addition, override the calculateArea() method in the Cylinder subclass to calculate and return the total surface area of the cylinder.

Write a Java program to create a base class Shape with methods draw() and calculateArea(). Create two subclasses Circle and Cylinder. Override the draw() method in each subclass to draw the respective shape. In addition, override the calculateArea() method in the Cylinder subclass to calculate and return the total surface area of the cylinder.

Sample Solution:

Java Code:
```java
//Shape.java
abstract class Shape {
  public abstract void draw();

  public abstract double calculateArea();
}

//Circle.java
class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public void draw() {
    System.out.println("Drawing a circle");
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  protected double getRadius() {
    return radius;
  }
}
//Cylinder.java
class Cylinder extends Circle {
  private double height;

  public Cylinder(double radius, double height) {
    super(radius);
    this.height = height;
  }

  @Override
  public void draw() {
    System.out.println("Drawing a cylinder");
  }

  @Override
  public double calculateArea() {
    // Calculate the total surface area of the cylinder (including the circular top and bottom)
    double circleArea = super.calculateArea();
    double sideArea = 2 * Math.PI * getRadius() * height;
    return 2 * circleArea + sideArea;
  }
}
//Main.java
public class Main {
  public static void main(String[] args) {
    Shape circle = new Circle(7.0);
    Shape cylinder = new Cylinder(4.0, 9.0);

    drawShapeAndCalculateArea(circle);
    drawShapeAndCalculateArea(cylinder);
  }

  public static void drawShapeAndCalculateArea(Shape shape) {
    shape.draw();
    double area = shape.calculateArea();
    System.out.println("Area: " + area);
  }
}
```
Sample Output:

Drawing a circle
Area: 153.93804002589985
Drawing a cylinder
Area: 326.7256359733385
Explanation:

In the above exercise -

The "Shape" class is the base abstract class, and Circle and Cylinder are its concrete subclasses. Each subclass overrides the draw() method to draw the respective shape and the calculateArea() method to calculate and return the area of each shape.
In the "Main" class, we have a static method drawShapeAndCalculateArea(Shape shape) that takes an object of the base class Shape as a parameter. Inside this method, we call the draw() and calculateArea() methods on the shape object. Since the drawShapeAndCalculateArea method takes a Shape type parameter, it can accept Circle and Cylinder objects.
