# Java Exercises Interface

### 1. Write a Java program to create an interface Shape with the getArea() method. Create three classes Rectangle, Circle, and Triangle that implement the Shape interface. Implement the getArea() method for each of the three classes.

Write a Java program to create an interface Shape with the getArea() method. Create three classes Rectangle, Circle, and Triangle that implement the Shape interface. Implement the getArea() method for each of the three classes.

Sample Solution:

Java Code:
```java
// Shape.java
// This is an interface named 'Shape' that defines a contract for classes to implement.
public interface Shape {
    // Abstract method signature for getting the area of a shape.
    double getArea();
}

// Rectangle.java
// This is the 'Rectangle' class that implements the 'Shape' interface.

public class Rectangle implements Shape {
    // Private instance variables to store the dimensions of the rectangle.
    private double length;
    private double width;

    // Constructor for creating a Rectangle object with given length and width.
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementation of the 'getArea' method as required by the 'Shape' interface.
    @Override
    public double getArea() {
        // Calculate and return the area of the rectangle.
        return length * width;
    }
}
// Circle.java
// This is the 'Circle' class that implements the 'Shape' interface.

public class Circle implements Shape {
    // Private instance variable to store the radius of the circle.
    private double radius;

    // Constructor for creating a Circle object with a given radius.
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of the 'getArea' method as required by the 'Shape' interface.
    @Override
    public double getArea() {
        // Calculate and return the area of the circle using the formula: π * r^2.
        return Math.PI * radius * radius;
    }
}
// Triangle.java
// This is the 'Triangle' class that implements the 'Shape' interface.

public class Triangle implements Shape {
    // Private instance variables to store the base and height of the triangle.
    private double base;
    private double height;

    // Constructor for creating a Triangle object with a given base and height.
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Implementation of the 'getArea' method as required by the 'Shape' interface.
    @Override
    public double getArea() {
        // Calculate and return the area of the triangle using the formula: 0.5 * base * height.
        return 0.5 * base * height;
    }
}
// Main.java
// Main class that creates objects of Rectangle, Circle, and Triangle

public class Main {
    public static void main(String[] args) {
        // Create a Rectangle object with length=10 and width=12
        Rectangle rectangle = new Rectangle(10, 12);
        
        // Create a Circle object with radius=3
        Circle circle = new Circle(3);
        
        // Create a Triangle object with base=4 and height=6
        Triangle triangle = new Triangle(4, 6);

        // Print the area of the Rectangle
        System.out.println("Area of the Rectangle: " + rectangle.getArea());
        
        // Print the area of the Circle
        System.out.println("Area of the Circle: " + circle.getArea());
        
        // Print the area of the Triangle
        System.out.println("Area of the Triangle: " + triangle.getArea());
    }
}
```
Sample Output:

Area of the Rectangle: 120.0
Area of the Circle: 28.274333882308138
Area of the Triangle: 12.0 
### 2. Write a Java program to create a Animal interface with a method called bark() that takes no arguments and returns void. Create a Dog class that implements Animal and overrides speak() to print "Dog is barking".
Write a Java program to create a Animal interface with a method called bark() that takes no arguments and returns void. Create a Dog class that implements Animal and overrides speak() to print "Dog is barking".

Sample Solution:

Java Code:
```java
// Animal.java
// Interface Animal

// Declare the Animal interface
public interface Animal {
    // Declare the abstract method "bark" that classes implementing this interface must provide
    void bark();
}

// Dog.java
// Class Dog

// Declare the Dog class, which implements the Animal interface
public class Dog implements Animal {
    // Implement the "bark" method required by the Animal interface
    @Override
    public void bark() {
        // Print a message indicating that the Dog is barking
        System.out.println("Dog is barking!");
    }
}
// Main.java
// Class Main

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Dog class
        Dog dog = new Dog();
        
        // Call the "bark" method on the Dog instance
        dog.bark();
    }
}
```
Sample Output:

Dog is barking! 
Explanation:

This exercise defines an interface called "Animal" with a method bark() that takes no arguments and returns void. We then define a class called "Dog" that implements the "Animal" interface and overrides the bark() method to print "Dog is barking" to the console.


In the Main class we create an instance of the "Dog" class and call the bark() method, which should print 'Dog is barking' to the console.

### 3. Write a Java program to create an interface Flyable with a method called fly_obj(). Create three classes Spacecraft, Airplane, and Helicopter that implement the Flyable interface. Implement the fly_obj() method for each of the three classes.

Write a Java program to create an interface Flyable with a method called fly_obj(). Create three classes Spacecraft, Airplane, and Helicopter that implement the Flyable interface. Implement the fly_obj() method for each of the three classes.

Sample Solution:

Java Code:
```java
// Flyable.java
// Interface Flyable

// Declare the Flyable interface
interface Flyable {
    // Declare the abstract method "fly_obj" that classes implementing this interface must provide
    void fly_obj();
}

// Spacecraft.java
// Class Spacecraft

// Declare the Spacecraft class, which implements the Flyable interface
class Spacecraft implements Flyable {
    // Implement the "fly_obj" method required by the Flyable interface
    @Override
    public void fly_obj() {
        // Print a message indicating that the Spacecraft is flying
        System.out.println("Spacecraft is flying");
    }
}
// Airplane.java
// Class Airplane

// Declare the Airplane class, which implements the Flyable interface
class Airplane implements Flyable {
    // Implement the "fly_obj" method required by the Flyable interface
    @Override
    public void fly_obj() {
        // Print a message indicating that the Airplane is flying
        System.out.println("Airplane is flying");
    }
}
// Helicopter.java
// Class Helicopter

// Declare the Helicopter class, which implements the Flyable interface
class Helicopter implements Flyable {
    // Implement the "fly_obj" method required by the Flyable interface
    @Override
    public void fly_obj() {
        // Print a message indicating that the Helicopter is flying
        System.out.println("Helicopter is flying");
    }
}
// Main.java
// Class Main

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create an array of Flyable objects, including a Spacecraft, Airplane, and Helicopter
        Flyable[] flyingObjects = {new Spacecraft(), new Airplane(), new Helicopter()};

        // Iterate through the array and call the "fly_obj" method on each object
        for (Flyable obj : flyingObjects) {
            obj.fly_obj();
        }
    }
}
```
Sample Output:

Spacecraft is flying
Airplane is flying
Helicopter is flying

### 4. Write a Java programming to create a banking system with three classes - Bank, Account, SavingsAccount, and CurrentAccount. The bank should have a list of accounts and methods for adding them. Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances. SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.

Write a Java programming to create a banking system with three classes - Bank, Account, SavingsAccount, and CurrentAccount. The bank should have a list of accounts and methods for adding them. Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances. SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.

Sample Solution:

Java Code:
```java
// Account.java
// Interface Account

// Declare the Account interface
interface Account {
    // Declare the abstract method "deposit" to deposit a specified amount
    void deposit(double amount);

    // Declare the abstract method "withdraw" to withdraw a specified amount
    void withdraw(double amount);

    // Declare the abstract method "getBalance" to retrieve the current balance
    double getBalance();
}

// SavingsAccount.java
// Class SavingsAccount

// Declare the SavingsAccount class, which implements the Account interface
class SavingsAccount implements Account {
    // Declare private instance variables to store balance and interest rate
    private double balance;
    private double interestRate;

    // Constructor for initializing the balance and interest rate
    public SavingsAccount(double initialDeposit, double interestRate) {
        this.balance = initialDeposit;
        this.interestRate = interestRate;
    }

    // Implement the "deposit" method to add a specified amount to the balance
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    // Implement the "withdraw" method to subtract a specified amount from the balance
    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    // Implement the "getBalance" method to retrieve the current balance
    @Override
    public double getBalance() {
        return balance;
    }
   
    // Method to apply interest to the balance
    public void applyInterest() {
        // Applying interest rate (in percentage) to the balance for 1 year
        balance += balance * interestRate / 100;
    }
}
// CurrentAccount.java
// Class CurrentAccount

// Declare the CurrentAccount class, which implements the Account interface
class CurrentAccount implements Account {
    // Declare private instance variables to store balance and overdraft limit
    private double balance;
    private double overdraftLimit;

    // Constructor for initializing the balance and overdraft limit
    public CurrentAccount(double initialDeposit, double overdraftLimit) {
        this.balance = initialDeposit;
        this.overdraftLimit = overdraftLimit;
    }

    // Implement the "deposit" method to add a specified amount to the balance
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    // Implement the "withdraw" method to subtract a specified amount from the balance
    @Override
    public void withdraw(double amount) {
        // Check if the balance plus overdraft limit is sufficient to cover the withdrawal
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        }
    }

    // Implement the "getBalance" method to retrieve the current balance
    @Override
    public double getBalance() {
        return balance;
    }

    // Method to set the overdraft limit for the current account
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
// Bank.java
// Class Bank

// Import required libraries for List and ArrayList
import java.util.ArrayList;
import java.util.List;

// Declare the Bank class
class Bank {
    // Declare a private list to store accounts
    private List accounts;

    // Constructor for initializing the list of accounts
    public Bank() {
        accounts = new ArrayList<>();
    }

    // Method to add an account to the list of accounts
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to remove an account from the list of accounts
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    // Method to deposit a specified amount into an account
    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    // Method to withdraw a specified amount from an account
    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    // Method to print the balances of all accounts in the bank
    public void printAccountBalances() {
        for (Account account : accounts) {
            System.out.println("Account balance: " + account.getBalance());
        }
    }
}
// Main.java
// Class Main

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Bank class
        Bank bank = new Bank();
        
        // Create a SavingsAccount with an initial deposit and interest rate
        SavingsAccount savingsAccount = new SavingsAccount(1000.0, 1.25);
        System.out.println("Savings Account:\nInitial Deposit: $1000.00\nInterest rate: 1.25%");
        
        // Create a CurrentAccount with an initial deposit and overdraft limit
        CurrentAccount currentAccount = new CurrentAccount(5000.0, 1000.0);
        System.out.println("\nCurrent Account:\nInitial Deposit: $5000.00\nOverdraft Limit: $1000.00");
		
        // Add the SavingsAccount and CurrentAccount to the bank
		bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);
		
		System.out.println("\nNow deposit $100 to Savings Account.");
        // Deposit $100 into the SavingsAccount
        bank.deposit(savingsAccount, 100.0);
        System.out.println("Now deposit $500 to Current Account.");
		// Deposit $500 into the CurrentAccount
		bank.deposit(currentAccount, 500.0);
		
		System.out.println("Withdraw $150 from Savings Account.\n");
        // Withdraw $150 from the SavingsAccount
        bank.withdraw(savingsAccount, 150.0);
        System.out.println("\nSavings A/c and Current A/c.:");
		
        // Print the balances of all accounts in the bank
		bank.printAccountBalances();
		
        // Apply interest to the SavingsAccount
        savingsAccount.applyInterest();
        System.out.println("\nAfter applying interest on Savings A/c for 1 year:");
		System.out.println("Savings A/c and Current A/c.:");
		
        // Print the balances of all accounts in the bank after applying interest
        bank.printAccountBalances();
    }
}
```
Sample Output:

Savings Account:
Initial Deposit: $1000.00
Interest rate: 1.25%

Current Account:
Initial Deposit: $5000.00
OverdraftLimit: $1000.00

Now deposit $100 to Savings Account.
Now deposit $500 to Current Account.
Withdraw $150 from Savings Account.


Savings A/c and Current A/c.:
Account balance: 950.0
Account balance: 5500.0

After applying interest on Savings A/c for 1 year:
Savings A/c and Current A/c.:
Account balance: 961.875
Account balance: 5500.0

### 5. Write a Java program to create an interface Resizable with methods resizeWidth(int width) and resizeHeight(int height) that allow an object to be resized. Create a class Rectangle that implements the Resizable interface and implements the resize methods.

Write a Java program to create an interface Resizable with methods resizeWidth(int width) and resizeHeight(int height) that allow an object to be resized. Create a class Rectangle that implements the Resizable interface and implements the resize methods.

Sample Solution:

Java Code:
```java
// Resizable.java
// Interface Resizable

// Declare the Resizable interface
interface Resizable {
    // Declare the abstract method "resizeWidth" to resize the width
    void resizeWidth(int width);

    // Declare the abstract method "resizeHeight" to resize the height
    void resizeHeight(int height);
}

// Rectangle.java

// Declare the Rectangle class, which implements the Resizable interface
class Rectangle implements Resizable {
    // Declare private instance variables to store width and height
    private int width;
    private int height;

    // Constructor for initializing the width and height
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Implement the "resizeWidth" method to resize the width
    public void resizeWidth(int width) {
        this.width = width;
    }

    // Implement the "resizeHeight" method to resize the height
    public void resizeHeight(int height) {
        this.height = height;
    }

    // Method to print the current width and height of the rectangle
    public void printSize() {
        System.out.println("Width: " + width + ", Height: " + height);
    }
}
// Main.java

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Rectangle class with an initial size
        Rectangle rectangle = new Rectangle(100, 150);
        
        // Print the initial size of the rectangle
        rectangle.printSize();

        // Resize the rectangle by changing its width and height
        rectangle.resizeWidth(150);
        rectangle.resizeHeight(200);
        
        // Print the updated size of the rectangle
        rectangle.printSize();
    }
}
```
Sample Output:

Width: 100, Height: 150
Width: 150, Height: 200 
Explanation:

In the above exercise –

First, we define an interface "Resizable" with the methods resizeWidth(int width) and resizeHeight(int height) to allow an object to be resized.
The "Rectangle" class implements the Resizable interface and provides its own implementations of the resize methods. It also has a printSize() method to display the current rectangle size.
In the main() method, we create an instance of the "Rectangle" class and display its size. Then, we call the resizeWidth() and resizeHeight() methods to change the rectangle size.
Finally, we print the updated size.

### 6. Write a Java program to create an interface Drawable with a method draw() that takes no arguments and returns void. Create three classes Circle, Rectangle, and Triangle that implement the Drawable interface and override the draw() method to draw their respective shapes.

Write a Java program to create an interface Drawable with a method draw() that takes no arguments and returns void. Create three classes Circle, Rectangle, and Triangle that implement the Drawable interface and override the draw() method to draw their respective shapes.

Sample Solution:

Java Code:
```java
// Drawable.java

// Declare the Drawable interface
interface Drawable {
    // Declare the abstract method "draw" that classes implementing this interface must provide
    void draw();
} 

// Circle.java

// Import necessary libraries for graphics and user interface
import java.awt.*;
import javax.swing.*;

// Declare the Circle class, which implements the Drawable interface
class Circle implements Drawable {
    // Implement the "draw" method required by the Drawable interface
    public void draw() {
        // Create a new JFrame for displaying the circle
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Create a JPanel for custom drawing
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the drawing color to red and fill an oval
                g.setColor(Color.RED);
                g.fillOval(100, 100, 200, 200);
            }
        };

        // Add the panel to the frame
        frame.add(panel);
    }
}
// Rectangle.java

// Import necessary libraries for graphics and user interface
import java.awt.*;
import javax.swing.*;

// Declare the Rectangle class, which implements the Drawable interface
class Rectangle implements Drawable {
    // Implement the "draw" method required by the Drawable interface
    public void draw() {
        // Create a new JFrame for displaying the rectangle
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Create a JPanel for custom drawing
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the drawing color to blue and fill a rectangle
                g.setColor(Color.BLUE);
                g.fillRect(100, 100, 200, 200);
            }
        };

        // Add the panel to the frame
        frame.add(panel);
    }
} 
// Triangle.java

// Import necessary libraries for graphics and user interface
import java.awt.*;
import javax.swing.*;

// Declare the Triangle class, which implements the Drawable interface
class Triangle implements Drawable {
    // Implement the "draw" method required by the Drawable interface
    public void draw() {
        // Create a new JFrame for displaying the triangle
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Create a JPanel for custom drawing
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the drawing color to green and fill a polygon
                g.setColor(Color.GREEN);
                int[] xPoints = {
                    200,
                    100,
                    300
                };
                int[] yPoints = {
                    100,
                    300,
                    300
                };
                g.fillPolygon(xPoints, yPoints, 3);
            }
        };

        // Add the panel to the frame
        frame.add(panel);
    }
}
// Main.java

// Import necessary libraries for graphics and user interface
import java.awt.*;
import javax.swing.*;

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create instances of Drawable objects, which are Circle, Rectangle, and Triangle
        Drawable circle = new Circle();
        Drawable rectangle = new Rectangle();
        Drawable triangle = new Triangle();

        // Call the "draw" method to display each shape
        circle.draw();
        rectangle.draw();
        triangle.draw();
    }
}
```
Sample Output:

Output: Circle Java
Output: Rectangle Java
Output: Triangle Java
Explanation:

In the above exercise –

The "Circle", "Rectangle", and "Triangle" classes implement the Drawable interface and provide their own implementations of the draw() method. Each class overrides the draw() method to print a message indicating the shape being drawn. It may also include code to draw the shape.
In the main() method, we create instances of the Circle, Rectangle, and Triangle classes and assign them to variables of type Drawable. We then call the draw() method on each variable, which invokes the overridden implementation of the respective shape class.

### 7. Write a Java program to create an interface Sortable with a method sort() that sorts an array of integers in ascending order. Create two classes BubbleSort and SelectionSort that implement the Sortable interface and provide their own implementations of the sort() method.

Write a Java program to create an interface Sortable with a method sort() that sorts an array of integers in ascending order. Create two classes BubbleSort and SelectionSort that implement the Sortable interface and provide their own implementations of the sort() method.

Sample Solution:

Java Code:
```java
// Sortable.java

// Declare the Sortable interface
interface Sortable {
    // Declare the abstract method "sort" that classes implementing this interface must provide
    void sort(int[] arr);
}

// BubbleSort.java

// Declare the BubbleSort class, which implements the Sortable interface
class BubbleSort implements Sortable {
    // Implement the "sort" method required by the Sortable interface
    public void sort(int[] arr) {
        // Get the length of the array
        int n = arr.length;
        
        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparisons and swaps
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
// SelectionSort.java

// Declare the SelectionSort class, which implements the Sortable interface
class SelectionSort implements Sortable {
    // Implement the "sort" method required by the Sortable interface
    public void sort(int[] arr) {
        // Get the length of the array
        int n = arr.length;
        
        // Outer loop for the current element
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Inner loop to find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
// Main.java

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create an array of integers to be sorted
        int[] arr = {
            4,
            2,
            0,
            3,
            1,
            6,
            8
        };

        // Create an instance of BubbleSort and perform sorting
        Sortable bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.print("Bubble Sort: ");
        printArray(arr);

        // Create an instance of SelectionSort and perform sorting
        Sortable selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.print("Selection Sort: ");
        printArray(arr);
    }

    // Method to print the elements of an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```
Sample Output:

Bubble Sort: 0 1 2 3 4 6 8
Selection Sort: 0 1 2 3 4 6 8 
Explanation:

In the above exercise –

The "BubbleSort" class and "SelectionSort" class both implement the Sortable interface and provide their own implementations of the sort() method. The "BubbleSort" class uses the bubble sort algorithm, and the SelectionSort class uses the selection sort algorithm.


In the main() method, we create an array of integers and then create instances of the BubbleSort and SelectionSort classes. We call the sort() method on each instance, pass in the array, and then print the sorted array using the printArray() method.


### 8. Write a Java program to create an interface Playable with a method play() that takes no arguments and returns void. Create three classes Football, Volleyball, and Basketball that implement the Playable interface and override the play() method to play the respective sports.

Write a Java program to create an interface Playable with a method play() that takes no arguments and returns void. Create three classes  Football,  Volleyball, and  Basketball that implement the Playable interface and override the play() method to play the respective  sports.

Sample Solution:

Java Code:
```java
// Playable.java
// Declare the Playable interface
interface Playable {
    // Declare the abstract method "play" that classes implementing this interface must provide
    void play();
}

//Football.java
class Football implements Playable {
  public void play() {
    System.out.println("Playing football");
    // Add code to play football
  }
}
// Volleyball.java

// Declare the Volleyball class, which implements the Playable interface
class Volleyball implements Playable {
    // Implement the "play" method required by the Playable interface
    public void play() {
        // Print a message indicating that volleyball is being played
        System.out.println("Playing volleyball");
        // Additional code to play volleyball can be added here
    }
}
// Basketball.java

// Declare the Basketball class, which implements the Playable interface
class Basketball implements Playable {
    // Implement the "play" method required by the Playable interface
    public void play() {
        // Print a message indicating that basketball is being played
        System.out.println("Playing basketball");
        // Additional code to play basketball can be added here
    }
} 
// Main.java

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create instances of Playable objects for football, volleyball, and basketball
        Playable football = new Football();
        Playable volleyball = new Volleyball();
        Playable basketball = new Basketball();

        // Call the "play" method on each Playable object to play different sports
        football.play();
        volleyball.play();
        basketball.play();
    }
}
```
Sample Output:

Playing football
Playing volleyball
Playing basketball  
Explanation:

In the above exercise –

The " Football", "Volleyball", and "Basketball" classes implement the Playable interface and provide their own implementations of the play() method. Each class overrides the play() method to print a message indicating the sport being played. It may also include code to play the sport.
In the main() method, we create instances of the "Football", "Volleyball", and "Basketball" classes and assign them to variables of type Playable. We then call the play() method on each variable, which invokes the overridden implementation of the respective  sport class.
### 9. Write a Java program to create an interface Searchable with a method search(String keyword) that searches for a given keyword in a text document. Create two classes Document and WebPage that implement the Searchable interface and provide their own implementations of the search() method.

Write a Java program to create an interface Searchable with a method search(String keyword) that searches for a given keyword in a text document. Create two classes Document and WebPage that implement the Searchable interface and provide their own implementations of the search() method.

Sample Solution:

Java Code:
```java
// Searchable.java

// Declare the Searchable interface
interface Searchable {
    // Declare the abstract method "search" that classes implementing this interface must provide
    boolean search(String keyword);
}

// Document.java

// Declare the Document class, which implements the Searchable interface
class Document implements Searchable {
    // Declare a private instance variable to store the content of the document
    private String content;

    // Constructor for initializing the document's content
    public Document(String content) {
        this.content = content;
    }

    // Implement the "search" method required by the Searchable interface
    public boolean search(String keyword) {
        // Check if the content contains the specified keyword
        return content.contains(keyword);
    }
}
// WebPage.java

// Declare the WebPage class, which implements the Searchable interface
class WebPage implements Searchable {
    // Declare private instance variables to store the URL and HTML content
    private String url;
    private String htmlContent;

    // Constructor for initializing the URL and HTML content
    public WebPage(String url, String htmlContent) {
        this.url = url;
        this.htmlContent = htmlContent;
    }

    // Implement the "search" method required by the Searchable interface
    public boolean search(String keyword) {
        // Check if the HTML content contains the specified keyword
        return htmlContent.contains(keyword);
    }
}
// Main.java

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Document class with a sample content
        Document document = new Document("This is a sample document.");

        // Search for a keyword in the document and store the result
        boolean documentContainsKeyword = document.search("sample");

        // Print whether the document contains the keyword
        System.out.println("Document contains keyword 'sample': " + documentContainsKeyword);

        // Create an instance of the WebPage class with a sample URL and HTML content
        WebPage webPage = new WebPage("https://www.w3resource.com", "This is a sample webpage.");

        // Search for a keyword in the webpage and store the result
        boolean webPageContainsKeyword = webPage.search("webpage");

        // Print whether the webpage contains the keyword
        System.out.println("Webpage contains keyword 'webpage': " + webPageContainsKeyword);
    }
}
```
Sample Output:

Document contains keyword 'sample': true
Webpage contains keyword 'webpage': true
Explanation:

In the above exercise –

The "Document" class and "WebPage" class both implement the Searchable interface and provide their own implementations of the search() method. The "Document" class searches for the keyword in its content, and the WebPage class searches for the keyword in its HTML content.
In the main() method, we create an instance of the "Document" class and an instance of the WebPage class. We call the search() method on each instance, passing in a keyword, and storing the result in a boolean variable. Finally, we print the result to indicate whether the keyword was found in the document or web page.

### 10. Write a Java program to create an interface Encryptable with methods encrypt (String data) and decrypt (String encryptedData) that define encryption and decryption operations. Create two classes AES and RSA that implement the Encryptable interface and provide their own encryption and decryption algorithms.

Write a Java program to create an interface Encryptable with methods encrypt (String data) and decrypt (String encryptedData) that define encryption and decryption operations. Create two classes AES and RSA that implement the Encryptable interface and provide their own encryption and decryption algorithms.

Sample Solution:

Java Code:
```java
// Encryptable.java

// Declare the Encryptable interface
interface Encryptable {
    // Declare the abstract method "encrypt" that classes implementing this interface must provide
    String encrypt(String data);
    
    // Declare the abstract method "decrypt" that classes implementing this interface must provide
    String decrypt(String encryptedData);
}

// AES.java

// Import necessary libraries for cryptographic operations
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

// Declare the AES class, which implements the Encryptable interface
class AES implements Encryptable {
    // Define the AES algorithm as a constant
    private static final String AES_ALGORITHM = "AES";

    // Declare a SecretKey to store the encryption key
    private SecretKey secretKey;

    // Constructor to initialize the encryption key
    public AES() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(AES_ALGORITHM);
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement the "encrypt" method required by the Encryptable interface
    public String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Implement the "decrypt" method required by the Encryptable interface
    public String decrypt(String encryptedData) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
} 
// RSA.java

// Import necessary libraries for cryptographic operations
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

// Declare the RSA class, which implements the Encryptable interface
class RSA implements Encryptable {
    // Define the RSA algorithm as a constant
    private static final String RSA_ALGORITHM = "RSA";

    // Declare a KeyPair to store the public and private keys
    private KeyPair keyPair;

    // Constructor to generate a KeyPair for encryption and decryption
    public RSA() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA_ALGORITHM);
            keyGen.initialize(2048);
            keyPair = keyGen.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement the "encrypt" method required by the Encryptable interface
    public String encrypt(String data) {
        try {
            // Get the public key from the KeyPair
            PublicKey publicKey = keyPair.getPublic();
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Implement the "decrypt" method required by the Encryptable interface
    public String decrypt(String encryptedData) {
        try {
            // Get the private key from the KeyPair
            PrivateKey privateKey = keyPair.getPrivate();
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
} 
// Main.java

// Import necessary libraries for cryptographic operations
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

// Declare the Main class
public class Main {
    public static void main(String[] args) {
        // Create an instance of the AES class for encryption and decryption
        Encryptable aes = new AES();
        
        // Encrypt data using AES encryption and store the result
        String encryptedDataAES = aes.encrypt("Java Interface.");
        System.out.println("AES Encrypted: " + encryptedDataAES);
        
        // Decrypt the AES-encrypted data and store the result
        String decryptedDataAES = aes.decrypt(encryptedDataAES);
        System.out.println("AES Decrypted: " + decryptedDataAES);

        // Create an instance of the RSA class for encryption and decryption
        Encryptable rsa = new RSA();
        
        // Encrypt data using RSA encryption and store the result
        String encryptedDataRSA = rsa.encrypt("Java Interface.");
        System.out.println("RSA Encrypted: " + encryptedDataRSA);
        
        // Decrypt the RSA-encrypted data and store the result
        String decryptedDataRSA = rsa.decrypt(encryptedDataRSA);
        System.out.println("RSA Decrypted: " + decryptedDataRSA);
    }
}
```
Sample Output:

AES Encrypted: SIRcgpS5yDqD7/MhH6Q2pg==
AES Decrypted: Java Interface.
RSA Encrypted: ep7aeBcALwnW44f2YFl+XfWkCE8QNWblnUgOeXjI1u0gnz6pSLLZekff6wBQbujUDNjmgOYVgTyG2iGUpaH2pK5sIwH6W6vJFvIaNXb/2KzwkTYDtdpdEHV8aq+dzxKWZloID84ZQ3VUmvEa4DUpqOzrj3HhX1Lvob3jzMKQgarAMwMIF2v6Wz9O7Hfe7uURnioqGOYtCB/SyZyKOnxvwdQjoRcV+5lYnopXzMKxdvGQG1oKPaujwtiHUtLnehscw6YoSkigf9TtPQV/kEvpCj8Eq/25Ifa+2xVjLMAat3ZuBrovJoD3ESS9qVXemLO2RsVAS5ZMYvZ9ws+CIxGyGg==
RSA Decrypted: Java Interface.
Explanation:

In the above exercise –

The "AES" class and "RSA" class both implement the Encryptable interface and provide their own implementations of the encrypt() and decrypt() methods. The "AES" class performs AES encryption and decryption, while the "RSA" class performs RSA encryption and decryption.
In the main() method, we create instances of the "AES" and "RSA" classes. We then call the encrypt() method on each instance, passing in a string to encrypt, and storing the result in a variable. Finally, we call the decrypt() method on each instance, passing in the encrypted string, and printing the decrypted data.

### 11. Write a Java program to create an interface Sortable with a method sort (int[] array) that sorts an array of integers in descending order. Create two classes QuickSort and MergeSort that implement the Sortable interface and provide their own implementations of the sort() method.

Write a Java program to create an interface Sortable with a method sort (int[] array) that sorts an array of integers in descending order. Create two classes QuickSort and MergeSort that implement the Sortable interface and provide their own implementations of the sort() method.

Sample Solution:

Java Code:
```java
// Sortable.java

// Declare the Sortable interface
interface Sortable {
    // Declare the abstract method "sort" that classes implementing this interface must provide
    void sort(int[] array);
}

// QuickSort.java

// Declare the QuickSort class, which implements the Sortable interface
class QuickSort implements Sortable {
    // Implement the "sort" method required by the Sortable interface
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Helper method for the QuickSort algorithm
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Find the partition index using the "partition" method
            int partitionIndex = partition(array, low, high);
            
            // Recursively sort the sub-arrays before and after the partition index
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Helper method to partition the array
    private int partition(int[] array, int low, int high) {
        // Choose the pivot element, which is the element at the "high" index
        int pivot = array[high];
        int i = low - 1;

        // Iterate through the elements in the array
        for (int j = low; j < high; j++) {
            // If the current element is greater than or equal to the pivot, swap elements
            if (array[j] >= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at the (i + 1) index
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Return the partition index
        return i + 1;
    }
} 
// MergeSort.java

// Declare the MergeSort class, which implements the Sortable interface
class MergeSort implements Sortable {
    // Implement the "sort" method required by the Sortable interface
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    // Helper method for the MergeSort algorithm
    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            // Calculate the middle index
            int mid = (low + high) / 2;
            
            // Recursively sort the left and right sub-arrays
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            
            // Merge the sorted sub-arrays
            merge(array, low, mid, high);
        }
    }

    // Helper method to merge two sub-arrays
    private void merge(int[] array, int low, int mid, int high) {
        // Calculate the sizes of the left and right sub-arrays
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        // Create temporary arrays to hold the left and right sub-arrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy elements from the original array to the left and right sub-arrays
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[low + i];
        }

        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        // Merge the two sub-arrays back into the original array
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left and right sub-arrays
        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
} 
// Main.java

// Declare the Main class
public class Main {
  // Main method, the entry point of the program
  public static void main(String[] args) {
    // Create an array of integers
    int[] arr = {
      9,
      5,
      2,
      8,
      0,
      3,
      1,
      6
    };

    // Create an instance of QuickSort and use it to sort the array in descending order
    Sortable quickSort = new QuickSort();
    quickSort.sort(arr);
    
    // Print the sorted array using Quick Sort
    System.out.print("Quick Sort (Descending Order): ");
    printArray(arr);

    // Create another array of integers
    int[] arr2 = {
      9,
      5,
      2,
      8,
      0,
      3,
      1,
      6
    };
    
    // Create an instance of MergeSort and use it to sort the second array in descending order
    Sortable mergeSort = new MergeSort();
    mergeSort.sort(arr2);
    
    // Print the sorted array using Merge Sort
    System.out.print("Merge Sort (Descending Order): ");
    printArray(arr2);
  }

  // Helper method to print an array of integers
  private static void printArray(int[] arr) {
    for (int num: arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
```
Sample Output:

Quick Sort (Descending Order): 9 8 6 5 3 2 1 0
Merge Sort (Descending Order): 9 8 6 5 3 2 1 0
Explanation:

In the above exercise –

The "QuickSort" class and "MergeSort" class both implement the Sortable interface and provide their own implementations of the sort() method. The "QuickSort" class uses the quick sort algorithm, and the "MergeSort" class uses the merge sort algorithm.
In the main() method, we create an array of integers and then create instances of the "QuickSort" and "MergeSort" classes. We call the sort() method on each instance, pass in the array, and then print the sorted array using the printArray() method.
