# Java Exercises Encapsulation

Java Encapsulation:

An object's encapsulation allows it to hide its data and methods. It is one of the fundamental principles of object-oriented programming. Java classes encapsulate the fields and methods that define an object's state and actions. Encapsulation enables you to write reusable programs. It also enables you to restrict access only to public features of an object. Other fields and methods are private and can be used internally.

### 1. Write a Java program to create a class called Person with private instance variables name, age. and country. Provide public getter and setter methods to access and modify these variables.

Write a Java program to create a class called Person with private instance variables name, age. and country. Provide public getter and setter methods to access and modify these variables.

Sample Solution:

Java Code:
```java
// Person.java
// Person Class
class Person {
  private String name;
  private int age;
  private String country;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}

// Main.java
// Main Class
public class Main {
  public static void main(String[] args) {
    // Create an instance of Person
    Person person = new Person();

    // Set values using setter methods
    person.setName("Arthfael Viktorija");
    person.setAge(25);
    person.setCountry("USA");

    // Get values using getter methods
    String name = person.getName();
    int age = person.getAge();
    String country = person.getCountry();

    // Print the values
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Country: " + country);
  }
}
```
Sample Output:

Name: Arthfael Viktorija
Age: 25
Country: US
Explanation:

In the above exercise, the Person class encapsulates the private instance variables name, age, and country. These variables are declared private, which means they cannot be accessed outside the Person class.


To access and modify these private variables, public getter and setter methods are provided. The getter methods (getName(), getAge(), and getCountry()) allow other classes to retrieve the values of private variables. The setter methods (setName(), setAge(), and setCountry()) provide a way to modify the values of private variables.

In the Main class, an instance of the Person class is created using the Person constructor (Person person = new Person()). Then, the setter methods are used to set the values of the private variables name, age, and country.

To retrieve these values, the getter methods are called (String name = person.getName(), int age = person.getAge(), String country = person.getCountry()). Finally, the retrieved values are printed using System.out.println().

### 2. Write a Java program to create a class called BankAccount with private instance variables accountNumber and balance. Provide public getter and setter methods to access and modify these variables.

Write a Java program to create a class called BankAccount with private instance variables accountNumber and balance. Provide public getter and setter methods to access and modify these variables.

Sample Solution:

Java Code:
```java
// BankAccount.java
// BankAccount Class

class BankAccount {
  private String accountNumber;
  private double balance;

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
```
Explanation:

In the above code, we have a BankAccount class that encapsulates the private instance variables accountNumber and balance. By making these variables private, we ensure that they can only be accessed and modified through the public getter and setter methods.


The getter methods (getAccountNumber() and getBalance()) are public methods that provide access to private variables. They allow other classes to retrieve accountNumber and balance values. In this case, getAccountNumber() returns the value of accountNumber as a String, and getBalance() returns the value of balance as a double.

The setter methods (setAccountNumber() and setBalance()) are also public methods that modify private variables. Private variables are created by accepting parameters (String accountNumber and double balance). In this case, setAccountNumber() sets accountNumber value based on the provided argument. SetBalance() sets the balance value based on the provided argument.
```java
// Main.java
// Main Class

public class Main {
  public static void main(String[] args) {
    // Create an instance of BankAccount
    BankAccount account = new BankAccount();

    // Set values using setter methods
    account.setAccountNumber("SB-09876");
    account.setBalance(2000.0);

    // Get values using getter methods
    String accountNumber = account.getAccountNumber();
    double balance = account.getBalance();

    // Print the values
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Balance: " + balance);
  }
}
```
In the above Main class, an instance of the BankAccount class is created using the BankAccount constructor. The private variables accountNumber and balance are then set using the setter methods.

To retrieve these values, the getter methods are called (String accountNumber = account.getAccountNumber() and double balance = account.getBalance()). After retrieving the values, System.out.println () is used to print them ().

Sample Output:

Account Number: SB-09876
Balance: 2000.0

### 3. Write a Java program to create a class called Rectangle with private instance variables length and width. Provide public getter and setter methods to access and modify these variables.

Write a Java program to create a class called Rectangle with private instance variables length and width. Provide public getter and setter methods to access and modify these variables.

Sample Solution:

Java Code:
```java
// Rectangle.java
// Rectangle Class

class Rectangle {
  private double length;
  private double width;

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }
}

// Main.java
// Main Class
public class Main {
  public static void main(String[] args) {
    // Create an instance of Rectangle
    Rectangle rectangle = new Rectangle();

    // Set values using setter methods
    rectangle.setLength(6.7);
    rectangle.setWidth(12.0);

    // Get values using getter methods
    double length = rectangle.getLength();
    double width = rectangle.getWidth();

    // Print the values
    System.out.println("Length: " + length);
    System.out.println("Width: " + width);
  }
}
```
Sample Output:

Length: 6.7
Width: 12.0
Explanation:

In the above exercise,

the Rectangle class encapsulates the private instance variables length and width. The getLength() and getWidth() methods are public getter methods that allow other classes to access length and width values. The setLength() and setWidth() methods are public setter methods that allow other classes to modify length and width values.


In the Main class, an object rectangle of the Rectangle class is created. The setter methods (setLength() and setWidth()) are used to set length and width values. The getter methods (getLength() and getWidth()) are used to retrieve length and width values.

We then use System.out.println() statements to print the length and width values.

### 4. Write a Java program to create a class called Employee with private instance variables employee_id, employee_name, and employee_salary. Provide public getter and setter methods to access and modify the id and name variables, but provide a getter method for the salary variable that returns a formatted string.

Write a Java program to create a class called Employee with private instance variables employee_id, employee_name, and employee_salary. Provide public getter and setter methods to access and modify the id and name variables, but provide a getter method for the salary variable that returns a formatted string.

Sample Solution:

Java Code:
```java
// Employee.java
// Employee Class

class Employee {
  private int employee_id;
  private String employee_name;
  private double employee_salary;

  public int getEmployeeId() {
    return employee_id;
  }

  public void setEmployeeId(int employeeId) {
    this.employee_id = employeeId;
  }

  public String getEmployeeName() {
    return employee_name;
  }

  public void setEmployeeName(String employeeName) {
    this.employee_name = employeeName;
  }

  public double getEmployeeSalary() {
    return employee_salary;
  }

  public void setEmployeeSalary(double employeeSalary) {
    this.employee_salary = employeeSalary;
  }

  public String getFormattedSalary() {
    return String.format("$%.2f", employee_salary);
  }
}
```
Explanation:

In the aboove code, the Employee class encapsulates the private instance variables employee_id, employee_name, and employee_salary. The getEmployeeId() and getEmployeeName() methods are public getter methods that allow other classes to access employee_id and employee_name values, respectively. The setEmployeeId() and setEmployeeName() methods are public setter methods that allow other classes to modify employee_id and employee_name values.


The getEmployeeSalary() method is another public getter method that returns employee_salary. However, we have also added an additional method getFormattedSalary() that returns a formatted string representation of the salary. This method provides a formatted version of the salary value, adding a dollar sign and two decimal places.
```java
// Main.java
// Main Class

public class Main {
  public static void main(String[] args) {
    // Create an instance of Employee
    Employee employee = new Employee();

    // Set values using setter methods
    employee.setEmployeeId(15);
    employee.setEmployeeName("Caelius Dathan");
    employee.setEmployeeSalary(4900.0);

    // Get values using getter methods
    int employeeId = employee.getEmployeeId();
    String employeeName = employee.getEmployeeName();
    String formattedSalary = employee.getFormattedSalary();

    // Print the values
    System.out.println("Employee Details:");
    System.out.println("ID: " + employeeId);
    System.out.println("Name: " + employeeName);
    System.out.println("Salary: " + formattedSalary);
  }
}
```
In the Main class, an employee object within the Employee class is created. The setter methods (setEmployeeId(), setEmployeeName(), and setEmployeeSalary()) are used to set employee_id, employee_name, and employee_salary, respectively. The getter methods (getEmployeeId(), getEmployeeName(), and getFormattedSalary()) are used to retrieve employee_id, employee_name, and formatted salary, respectively.

Finally, System.out.println() statements print employee_id, employee_name, and formatted salary.

Sample Output:

Employee Details:
ID: 15
Name: Caelius Dathan
Salary: $4900.00

### 5. Write a Java program to create a class called Circle with a private instance variable radius. Provide public getter and setter methods to access and modify the radius variable. However, provide two methods called calculateArea() and calculatePerimeter() that return the calculated area and perimeter based on the current radius value.

Write a Java program to create a class called Circle with a private instance variable radius. Provide public getter and setter methods to access and modify the radius variable. However, provide two methods called calculateArea() and calculatePerimeter() that return the calculated area and perimeter based on the current radius value.

Sample Solution:

Java Code:
```java
// Circle.java
// Circle Class

class Circle {
  private double radius;

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  public double calculatePerimeter() {
    return 2 * Math.PI * radius;
  }
}
// Main.java
// Main Class

public class Main {
  public static void main(String[] args) {
    // Create an instance of Circle
    Circle circle = new Circle();

    // Set the radius using the setter method
    circle.setRadius(7.0);

    // Get the radius using the getter method
    double radius = circle.getRadius();

    // Calculate and print the area and perimeter
    double area = circle.calculateArea();
    double perimeter = circle.calculatePerimeter();

    System.out.println("Circle Radius: " + radius);
    System.out.println("Circle Area: " + area);
    System.out.println("Circle Perimeter: " + perimeter);
  }
}
```
Sample Output:

Circle Radius: 7.0
Circle Area: 153.93804002589985
Circle Perimeter: 43.982297150257104
Explanation:

In the above exercise,

In this code, the Circle class encapsulates the private instance variable radius. The getRadius() and setRadius() methods are public getter and setter methods that allow other classes to access and modify radius values, respectively.


Additionally, the Circle class provides two public methods calculateArea() and calculatePerimeter() that calculate and return the area and perimeter of the circle. These methods are based on the current radius value. These methods use the formula Math.PI*radius*radius for area calculation and 2*Math.PI*radius for perimeter calculation.

In the Main class, an object circle of the Circle class is created. The circle radius is set using the setRadius() method, and then retrieved using the getRadius() method.

The area and perimeter of the circle are calculated using the calculateArea() and calculatePerimeter() methods, respectively, and printed using System.out.println().

### 6. Write a Java program to create a class called Car with private instance variables company_name, model_name, year, and mileage. Provide public getter and setter methods to access and modify the company_name, model_name, and year variables. However, only provide a getter method for the mileage variable.

Write a Java program to create a class called  Car with private instance variables company_name, model_name, year, and mileage. Provide public getter and setter methods to access and modify the company_name, model_name, and year variables. However, only provide a getter method for the mileage variable.

Sample Solution:

Java Code:
```java
// Car.java
// Car Class

class Car {
  private String company_name;
  private String model_name;
  private int year;
  private double mileage;

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getModel_name() {
    return model_name;
  }

  public void setModel_name(String model_name) {
    this.model_name = model_name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public double getMileage() {
    return mileage;
  }
}
// Main.java
// Main Class

public class Main {
  public static void main(String[] args) {
    // Create an instance of Car
    Car car = new Car();

    // Set the values using the setter methods
    car.setCompany_name("Chevrolet");
    car.setModel_name("Cruze");
    car.setYear(2009);
    // mileage is not set using the setter method

    // Get the values using the getter methods
    String company_name = car.getCompany_name();
    String model_name = car.getModel_name();
    int year = car.getYear();
    double mileage = car.getMileage();

    // Print the values
    System.out.println("Company Name: " + company_name);
    System.out.println("Model Name: " + model_name);
    System.out.println("Year: " + year);
    System.out.println("Mileage: " + mileage);
  }
}
```
Sample Output:

Company Name: Chevrolet
Model Name: Cruze
Year: 2009
Mileage: 0.0
Explanation:

In this code, the  Car class encapsulates the private instance variables company_name, model_name, year, and mileage. The getCompany_name(), getModel_name(), and getYear() methods are public getter methods that allow other classes to access company_name, model_name, and year, respectively. The corresponding set methods are provided to modify these variables.


The getMileage() method is a public getter method that allows other classes to access mileage values. However, no setter method is provided for mileage, meaning it cannot be modified outside the  Car class.

In the Main class, an object  car of the Car class is created. Company_name, model_name, and year values are set using the respective setter methods, and then retrieved using the getter methods.

The mileage is then retrieved using the getMileage() method and printed using System.out.println().

### 7. Write a Java program to create a class called Student with private instance variables student_id, student_name, and grades. Provide public getter and setter methods to access and modify the student_id and student_name variables. However, provide a method called addGrade() that allows adding a grade to the grades variable while performing additional validation.

Write a Java program to create a class called Student with private instance variables student_id, student_name, and grades. Provide public getter and setter methods to access and modify the student_id and student_name variables. However, provide a method called addGrade() that allows adding a grade to the grades variable while performing additional validation.

Sample Solution:

Java Code:
```java
// Student.java
// Student Class

import java.util.ArrayList;
import java.util.List;

class Student {
  private int student_id;
  private String student_name;
  private List < Double > grades;

  public int getStudent_id() {
    return student_id;
  }

  public void setStudent_id(int student_id) {
    this.student_id = student_id;
  }

  public String getStudent_name() {
    return student_name;
  }

  public void setStudent_name(String student_name) {
    this.student_name = student_name;
  }

  public List < Double > getGrades() {
    return grades;
  }

  public void addGrade(double grade) {
    if (grades == null) {
      grades = new ArrayList < > ();
    }
    grades.add(grade);
  }
}
// Main.java
// Main Class
import java.util.ArrayList;
import java.util.List;
public class Main {
  public static void main(String[] args) {
    // Create an instance of Student
    Student student = new Student();

    // Set the values using the setter methods
    student.setStudent_id(1);
    student.setStudent_name("Nadia Hyakinthos");

    // Add grades using the addGrade() method
    student.addGrade(92.5);
    student.addGrade(89.0);
    student.addGrade(90.3);

    // Get the values using the getter methods
    int student_id = student.getStudent_id();
    String student_name = student.getStudent_name();
    List < Double > grades = student.getGrades();

    // Print the values
    System.out.println("Student ID: " + student_id);
    System.out.println("Student Name: " + student_name);
    System.out.println("Grades: " + grades);
  }
}
```
Sample Output:

Student ID: 1
Student Name: Nadia Hyakinthos
Grades: [92.5, 89.0, 90.3]
Explanation:

In the above exercise,

The Student class:

It defines a class called Student with private instance variables student_id, student_name, and grades.
The variables are marked as private, which means they can only be accessed within the Student class.
Public getter and setter methods are provided for student_id and student_name to access and modify these variables.
Additionally, a getter method is provided for the grades variable, which returns a list of double values.
There is also a method called addGrade() that allows adding grades to the grades list. It performs additional validation by checking if the grades list is null and initializing it if necessary.
The Main class:

It contains the main method, which serves as the entry point for the program.
An instance of the Student class is created using the new keyword.
The values of student_id and student_name are set using the setter methods.
Grades are added to the grades list using the addGrade() method.
The values of student_id, student_name, and grades are retrieved using the respective getter methods.
