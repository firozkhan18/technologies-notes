# Java Exercises Basic - 1

### 1. Write a Java program to print 'Hello' on screen and your name on a separate line.

Pictorial Presentation:

Java: Print hello and your name on a separate lines
Sample Solution:

Java Code:
```java
public class Exercise1 { 
    public static void main(String[] args) {
        // Print a greeting message to the console
        System.out.println("Hello\nAlexandra Abramov!");
    } 
}
```
Explanation:

In the exercise above

- The "main()" method is the program entry point.
- It uses System.out.println to print the message.
- The message consists of two lines: "Hello" and "Alexandra Abramov!" separated by a newline character (\n).
- When we run this Java program, we'll see this message displayed in the console or terminal.

Sample Output:

Hello                                                                                                      
Alexandra Abramov!
Flowchart:

Flowchart: Print hello and your name on a separate lines
Sample solution using input from the user:

Java Code:
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner input = new Scanner(System.in);
        // Prompt the user to input their first name
        System.out.print("Input your first name: ");
        String fname = input.next();
        // Prompt the user to input their last name
        System.out.print("Input your last name: ");
        String lname = input.next();
        // Output a greeting message with the user's full name
        System.out.println();
        System.out.println("Hello \n" + fname + " " + lname);
    }
}
```
Explanation:

In the exercise above -

- import java.util.Scanner;: This code imports the "Scanner" class, which allows the program to read input from the user.
- public class Main {: This code declares a class named "Main," and it contains the main method, which is the entry point of the program.
- public static void main(String[] args) {: This line defines the main method. Here's what each part means:
- public: This keyword indicates that the method can be accessed from outside the class.
- static: This keyword means that the method belongs to the class itself, not to a specific instance of the class.
- void: This specifies that the main method doesn't return any value.
- main: This is the name of the method.
- (String[] args): This is the method's parameter list, which accepts an array of strings. In this case, it's not used.
- Scanner input = new Scanner(System.in);: This code creates a Scanner object named input to read input from the console (user's keyboard).
- System.out.print("Input your first name: ");: This code prints a message to the console, asking the user to input their first name.
- String fname = input.next();: This code reads the user's input for their first name and stores it in the variable fname.
- System.out.print("Input your last name: ");: This code prints a message to the console, asking the user to input their last name.
- String lname = input.next();: This code reads the user's input for their last name and stores it in the variable lname.
- System.out.println();: This code prints a blank line to separate the output.
- System.out.println("Hello \n" + fname + " " + lname);: This code prints a greeting message to the console. It combines the user's full name with the text "Hello" and a newline character (\n) to create a formatted greeting message.

Sample Output:

Input your first name:  James 
Input your last name:  Smith

Hello 
James Smith

Expected Output :
Hello
Alexandra Abramov



### 2. Write a Java program to print the sum of two numbers.

```java
public class Exercise2 {
    public static void main(String[] args) {
        // Calculate the sum of 24 and 26
        int sum = 24 + 26;
        // Print the result of the addition
        System.out.println(sum);
    }
}
```
```java
import java.util.Scanner;
public class Main {
  public static void main(String[] args) 
  {
    // Create a Scanner object to read input from the user
    Scanner input = new Scanner(System.in);    
    // Prompt the user to input the first number
    System.out.print("Input the first number: ");    
    // Read and store the first number
    int num1 = input.nextInt();    
    // Prompt the user to input the second number
    System.out.print("Input the second number: ");    
    // Read and store the second number
    int num2 = input.nextInt();    
    // Calculate the sum of the two numbers
    int sum = num1 + num2;    
    // Display a blank line for separation
    System.out.println();    
    // Display the sum of the two numbers
    System.out.println("Sum: " + sum);
  }
}
```
Test Data:
74 + 36
Expected Output :
110



### 3. Write a Java program to divide two numbers and print them on the screen.
```java
public class Exercise3 {
    public static void main(String[] args) {
        // Calculate the result of the division 50/3
        int result = 50 / 3;

        // Print the result of the division
        System.out.println(result);
    }
}
```
```java
import java.util.Scanner;
public class Main {
  public static void main(String[] args) 
  {
    // Create a Scanner object to read input from the user
    Scanner input = new Scanner(System.in);    
    // Prompt the user to input the first number
    System.out.print("Input the first number: ");    
    // Read and store the first number
    int a = input.nextInt();    
    // Prompt the user to input the second number
    System.out.print("Input the second number: ");    
    // Read and store the second number
    int b = input.nextInt();    
    // Calculate the division of a and b
    int d = (a / b);    
    // Display a blank line for separation
    System.out.println();    
    // Display the result of the division
    System.out.println("The division of a and b is: " + d);
  }
}
```
Test Data :
50/3
Expected Output :
16



### 4. Write a Java program to print the results of the following operations.
```java
public class Exercise4 {
    public static void main(String[] args) {
        // Calculate and print the result of the expression: -5 + 8 * 6
        System.out.println(-5 + 8 * 6);

        // Calculate and print the result of the expression: (55 + 9) % 9
        System.out.println((55 + 9) % 9);

        // Calculate and print the result of the expression: 20 + -3 * 5 / 8
        System.out.println(20 + -3 * 5 / 8);

        // Calculate and print the result of the expression: 5 + 15 / 3 * 2 - 8 % 3
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
    }
}
```
```java
public class Main {
  public static void main(String[] args) {
    // Calculate and store the result of the expression: -5 + 8 * 6
    int w = -5 + 8 * 6;

    // Calculate and store the result of the expression: (55 + 9) % 9
    int x = (55 + 9) % 9;

    // Calculate and store the result of the expression: 20 + (-3 * 5 / 8)
    int y = 20 + (-3 * 5 / 8);

    // Calculate and store the result of the expression: 5 + 15 / 3 * 2 - 8 % 3
    int z = 5 + 15 / 3 * 2 - 8 % 3;

    // Print the calculated values, each on a new line
    System.out.print(w + "\n" + x + "\n" + y + "\n" + z);
  }
}
```
Test Data:
a. -5 + 8 * 6
b. (55+9) % 9
c. 20 + -3*5 / 8
d. 5 + 15 / 3 * 2 - 8 % 3
Expected Output :
43
1
19
13

### 5. Write a Java program that takes two numbers as input and displays the product of two numbers.
```java
import java.util.Scanner; 
public class Exercise5 { 
 public static void main(String[] args) {
  // Create a Scanner object to read input from the user
  Scanner in = new Scanner(System.in);   
  // Prompt the user to input the first number
  System.out.print("Input first number: ");
  // Read and store the first number
  int num1 = in.nextInt();   
  // Prompt the user to input the second number
  System.out.print("Input second number: ");
  // Read and store the second number   
  // Calculate the product of the two numbers and display the result
  System.out.println(num1 + " x " + num2 + " = " + num1 * num2);
 }
} 
```
Test Data:
Input first number: 25
Input second number: 5
Expected Output :
25 x 5 = 125

### 6. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers.

```java
public class Exercise6 {
 
 public static void main(String[] args) {
  // Create a Scanner object to read input from the user
  Scanner in = new Scanner(System.in);
   
  // Prompt the user to input the first number
  System.out.print("Input first number: ");
  // Read and store the first number
  int num1 = in.nextInt();
   
  // Prompt the user to input the second number
  System.out.print("Input second number: ");
  // Read and store the second number
   
  // Calculate and print the sum of the two numbers
  System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
   
  // Calculate and print the difference of the two numbers
  System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
   
  // Calculate and print the product of the two numbers
  System.out.println(num1 + " x " + num2 + " = " + (num1 * num2));
   
  // Calculate and print the division of the two numbers
  System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
 
  // Calculate and print the remainder of the division of the two numbers
  System.out.println(num1 + " mod " + num2 + " = " + (num1 % num2);
 }
} 
```
Explanation:

In the exercise above -

It takes two integer numbers as input from the user using the Scanner class.
```
Scanner in = new Scanner(System.in);
System.out.print("Input first number: ");
int num1 = in.nextInt();
System.out.print("Input second number: ");
System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); - It calculates and displays the sum of the two numbers.
System.out.println(num1 + " - " + num2 + " = " + (num1 - num2)); - It calculates and displays the difference between the two numbers.
System.out.println(num1 + " x " + num2 + " = " + (num1 * num2)); - It calculates and displays the product of the two numbers.
System.out.println(num1 + " / " + num2 + " = " + (num1 / num2)); - It calculates and displays the result of dividing the first number by the second number.
System.out.println(num1 + " mod " + num2 + " = " + (num1 % num2)); - It calculates and displays the remainder (modulus) when the first number is divided by the second number.
```

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  // Create a Scanner object to read input from the user
  Scanner scanner = new Scanner(System.in);
  
  // Prompt the user to input the first number
  System.out.println("Input the first number: ");
  
  // Read and store the first number
  int n1 = scanner.nextInt();
  
  // Prompt the user to input the second number
  System.out.println("Input the second number: ");
  
  // Read and store the second number
  
  // Calculate the sum of the two numbers
  int sum = n1 + n2;
  
  // Calculate the difference of the two numbers
  int minus = n1 - n2;
  
  // Calculate the product of the two numbers
  int multiply = n1 * n2;
  
  // Calculate the addition of the two numbers (Note: This comment may be a typo; it seems similar to the "sum" calculation)
  int subtract = n1 + n2;
  
  // Calculate the division of the two numbers
  int divide = n1 / n2;
  
  // Calculate the remainder when dividing the two numbers
  int rnums = n1 % n2;
  
  // Display the results of the calculations
  System.out.printf("Sum = %d\nMinus = %d\nMultiply = %d\nSubtract = %d\nDivide = %d\nRemainderOf2Numbers = %d\n ", sum, minus, multiply, subtract, divide, rnums);
 }
}
```
Test Data:
Input first number: 125
Input second number: 24
Expected Output :
125 + 24 = 149
125 - 24 = 101
125 x 24 = 3000
125 / 24 = 5
125 mod 24 = 5



### 7. Write a Java program that takes a number as input and prints its multiplication table up to 10.
```java
import java.util.Scanner;
 
public class Exercise7 {
 
 public static void main(String[] args) {
  // Create a Scanner object to read input from the user
  Scanner in = new Scanner(System.in);
   
  // Prompt the user to input a number
  System.out.print("Input a number: ");
  
  // Read and store the input number
  int num1 = in.nextInt();
   
  // Use a loop to calculate and print the multiplication table for the input number
  for (int i = 0; i < 10; i++) {
     // Calculate and print the result of num1 multiplied by (i+1)
     System.out.println(num1 + " x " + (i + 1) + " = " + (num1 * (i + 1)));
  }
 }
}
```
Explanation:

In the exercise above -

It takes an integer number as input from the user using the Scanner class.
It then enters a for loop that iterates 10 times (for values of i from 0 to 9).
Inside the loop, it calculates and prints the result of multiplying the input number by i+1, displaying a multiplication table for the input number from 1 to 10.
```java
import java.util.Scanner;

public class Main {

 public static void main(String[] args) {
  // Create a Scanner object to read input from the user
  Scanner in = new Scanner(System.in);
  
  // Prompt the user to input a number
  System.out.println("Input the Number: ");
  
  // Read and store the input number
  int n = in.nextInt();
  
  // Use a loop to generate and print the multiplication table for the input number
  for (int i = 1; i <= 10; i++) {
     // Calculate and print the result of n multiplied by i
     System.out.println(n + "*" + i + " = " + (n * i));
  }
 }
}
```
Test Data:
Input a number: 8
Expected Output :
8 x 1 = 8
8 x 2 = 16
8 x 3 = 24
...
8 x 10 = 80



### 8. Write a Java program to display the following pattern.
Sample Pattern :


   J    a   v     v  a                                                  
   J   a a   v   v  a a                                                 
J  J  aaaaa   V V  aaaaa                                                
 JJ  a     a   V  a     a

```java
 public class Exercise8 {
 
    public static void main(String[] args) {
        // Display the characters to form the text "Java" in a specific pattern
        System.out.println("   J    a   v     v  a ");
        System.out.println("   J   a a   v   v  a a");
        System.out.println("J  J  aaaaa   V V  aaaaa");
        System.out.println(" JJ  a     a   V  a     a");
    }
} 
```

### 9. Write a Java program to compute the specified expressions and print the output.
```java
public class Exercise9 {
 
    public static void main(String[] arg) {
        // Calculate and print the result of a mathematical expression
        System.out.println((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
    }
} 
```
Explanation:

The above Java code calculates and prints the result of the following mathematical expression:

(25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)

The code performs arithmetic operations, including multiplication, subtraction, and division, and displays the final result. In this case, the result will be printed to the console.

Test Data:
((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5))

Expected Output
2.138888888888889



### 10. Write a Java program to compute a specified formula.
```java
public class Exercise10 { 
    public static void main(String[] args) {
        // Calculate the result of an alternating series and store it in 'result'
        double result = 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11));
        
        // Print the calculated result
        System.out.println(result);
    }
}
```
Specified Formula :
4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11))
Expected Output
2.9760461760461765



### 11. Write a Java program to print the area and perimeter of a circle.
```java
public class Exercise11 {
    // Define a constant for the radius of the circle
    private static final double radius = 7.5;

    public static void main(String[] args) {
        // Calculate the perimeter of the circle using the constant radius
        double perimeter = 2 * Math.PI * radius;

        // Calculate the area of the circle using the constant radius
        double area = Math.PI * radius * radius;

        // Print the calculated perimeter and area
        System.out.println("Perimeter is = " + perimeter);
        System.out.println("Area is = " + area);
    }
}
```
Explanation:

In the exercise above -

The above Java code calculates and prints the perimeter and area of a circle with a given radius (in this case, a radius of 7.5 units). It uses mathematical constants and formulas for circles:

It calculates the perimeter (circumference) using the formula: 2 * Math.PI * radius;
It calculates the area using the formula: π * radius^2.
The perimeter and area values are then printed to the console.

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  // Create a Scanner object to read input from the user
  Scanner io = new Scanner(System.in);
  
  // Prompt the user to input the radius of the circle
  System.out.println("Input the radius of the circle: ");
  
  // Read and store the input radius
  double radius = io.nextDouble();
  
  // Calculate and print the perimeter of the circle
  System.out.println("Perimeter is = " + (2 * radius * Math.PI));
  
  // Calculate and print the area of the circle
  System.out.println("Area is = " + (Math.PI * radius * radius));
 }
}
```

Test Data:
Radius = 7.5
Expected Output
Perimeter is = 47.12388980384689
Area is = 176.71458676442586



### 12. Write a Java program that takes three numbers as input to calculate and print the average of the numbers.
```java
import java.util.Scanner;
 
public class Exercise12 {
 
 public static void main(String[] args) {
  // Create a Scanner object to read input from the user
  Scanner in = new Scanner(System.in);
   
  // Prompt the user to input the first number
  System.out.print("Input first number: ");
  
  // Read and store the first number
  int num1 = in.nextInt();
   
  // Prompt the user to input the second number
  System.out.print("Input second number: ");
  
  // Read and store the second number
  int num2 = in.nextInt();
   
  // Prompt the user to input the third number
  System.out.print("Input third number: ");
  
  // Read and store the third number
  int num3 = in.nextInt();
   
  // Prompt the user to input the fourth number
  System.out.print("Input fourth number: ");
  
  // Read and store the fourth number
  int num4 = in.nextInt();
  
  // Prompt the user to input the fifth number
  System.out.print("Enter fifth number: ");
  
  // Read and store the fifth number
  int num5 = in.nextInt();
   
  // Calculate and print the average of the five numbers
  System.out.println("Average of five numbers is: " + (num1 + num2 + num3 + num4 + num5) / 5);
 }
} 
```
Explanation:

In the exercise above -

It prompts the user to input five different numbers, one by one.
It reads and stores each number in separate variables: num1, num2, num3, num4, and num5.
It calculates the average of these five numbers by adding them together and dividing the sum by 5.
It displays the calculated average with the message "Average of five numbers is:" to the console.

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  // Initialize variables for sum and counting
  double num = 0;
  double x = 1;
  
  // Create a Scanner object to read input from the user
  Scanner sc = new Scanner(System.in);
  
  // Prompt the user to input the number (n) for which to calculate the average
  System.out.println("Input the number(n) you want to calculate the average: ");
  int n = sc.nextInt();
  
  // Use a loop to collect n numbers and calculate their sum
  while (x <= n) {
   System.out.println("Input number " + "(" + (int) x + ")" + ":");
   num += sc.nextInt();
   x += 1;
  }
  
  // Calculate the average of the collected numbers
  double avgn = (num / n);

  // Display the calculated average
  System.out.println("Average: " + avgn);
 }
}
```

### 13. Write a Java program to print the area and perimeter of a rectangle.
```java
public class Exercise13 { 
   public static void main(String[] strings) {
        // Define constants for the width and height of the rectangle
        final double width = 5.6;
        final double height = 8.5;

        // Calculate the perimeter of the rectangle
        double perimeter = 2 * (height + width);
		
        // Calculate the area of the rectangle
        double area = width * height;			

        // Print the calculated perimeter using placeholders for values
        System.out.printf("Perimeter is 2*(%.1f + %.1f) = %.2f \n", height, width, perimeter);

        // Print the calculated area using placeholders for values
        System.out.printf("Area is %.1f * %.1f = %.2f \n", width, height, area);
    }
}
```
Explanation:

In the exercise above -

Define constant values for the rectangle's width (5.6) and height (8.5).
Calculate the rectangle perimeter using the formula: 2 * (height + width).
Calculate the rectangle area using the formula: width * height.
Prints the perimeter and area values to the console using printf statements with formatted output to display the results with specific decimal precision.

Test Data:
Width = 5.5 Height = 8.5


Expected Output
Area is 5.6 * 8.5 = 47.60
Perimeter is 2 * (5.6 + 8.5) = 28.20



### 14. Write a Java program to print an American flag on the screen.
Expected Output

* * * * * * ==================================                          
 * * * * *  ==================================                          
* * * * * * ==================================                          
 * * * * *  ==================================                          
* * * * * * ==================================                          
 * * * * *  ==================================                          
* * * * * * ==================================                          
 * * * * *  ==================================                          
* * * * * * ==================================                          
==============================================                          
==============================================                          
==============================================                          
==============================================                          
==============================================                          
==============================================
```java
public class Main {
    public static void main(String[] args) {
        // Define pattern strings for the top and middle sections
        String p1 = "* * * * * * ==================================\n * * * * *  ==================================";
        String p2 = "==============================================";
        // Print the top section pattern 4 times
        for (int i = 0; i < 4; i++) {
            System.out.println(p1);
        }
        // Print the bottom section pattern once
        System.out.println("* * * * * * ==================================");
        // Print the middle section pattern 6 times
        for (int i = 0; i < 6; i++) {
            System.out.println(p2);
        }
    }
}
```
### 15. Write a Java program to swap two variables.

Java: Swapping two variables

Swapping two variables refers to mutually exchanging the values of the variables. Generally, this is done with the data in memory.

The simplest method to swap two variables is to use a third temporary variable :
```
define swap(a, b)
    temp := a
    a := b
    b := temp
```
```java
public class Exercise15 {
 
 public static void main(String[] args) {
   // Declare variables for the values to be swapped
   int a, b, temp;
   
   // Assign values to variables a and b
   a = 15;
   b = 27;
   
   // Print the values before swapping
   System.out.println("Before swapping : a, b = " + a + ", " + b);
   
   // Perform the swap using a temporary variable
   temp = a;
   a = b;
   b = temp;   
   
   // Print the values after swapping
   System.out.println("After swapping : a, b = " + a + ", " + b);
 }
}
```
Explanation:

In the exercise above -

Initialize two integer variables, 'a' with the value 15 and 'b' with the value 27.
Prints the original values of 'a' and 'b' before swapping.
Use a temporary variable temp to temporarily store the value of 'a'.
Assign the value of 'b' to 'a'.
Assign the value stored in temp (originally from a) to 'b'.
Finally, it prints the values of 'a' and 'b' after the swapping operation.
Without using third variable.

Sample Solution-2

Java Code:
```java
public class Exercise15 {
  public static void main(String[] args) {
     // Declare and initialize integer variables a and b
     int a, b;
     a = 15;
     b = 27;
     
     // Print the values before swapping
     System.out.println("Before swapping : a, b = " + a + ", " + b);
     
     // Perform the swap without using a temporary variable
     a = a + b;  // Add a and b and store the result in a
     b = a - b;  // Subtract the original b from the new a and store the result in b
     a = a - b;  // Subtract the new b from the updated a and store the result in a
     
     // Print the values after swapping
     System.out.println("After swapping : a, b = " + a + ", " + b);
  }
}
```
Explanation:

In the exercise above -

Initialize two integer variables, 'a' with the value 15 and 'b' with the value 27.
Prints the original values of 'a' and 'b' before swapping.
Use arithmetic operations to swap values without using a temporary variable:
a = a + b adds 'a' and 'b' and stores the sum in 'a'. Now, 'a' contains the sum of the original 'a' and 'b'.
b = a - b subtracts the original 'b' from the updated 'a' and stores the result in 'b'. Now, 'b' contains the original value of 'a'.
a = a - b subtracts the updated 'b' (which now contains the original value of 'a') from the updated 'a' and stores the result in 'a'. Now, 'a' contains the original value of 'b'.
Finally, it prints the values of 'a' and 'b' after the swapping operation.
    
### 16. Write a Java program to print a face.


Expected Output

 +"""""+                                                 
[| o o |]                                                
 |  ^  |                                                 
 | '-' |                                                 
 +-----+
```java
public class Exercise16 {
    public static void main(String[] args)
    {
        // Display a pattern to create an ASCII art representation of a simple face
        System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");
    }
}
```
Sample Solution (using array):

Java Code:

```java
public class Main {

 public static void main(String[] args) {
  // Create an array to store lines of an ASCII art representation
  String[] arra = new String[5];

  // Populate the array with lines to form an ASCII art representation of a simple face
  arra[0] = " +\"\"\"\"\"+ ";
  arra[1] = "[| o o |]";
  arra[2] = " |  ^  |";
  arra[3] = " | '-' |";
  arra[4] = " +-----+";

  // Use a loop to print each line of the ASCII art representation
  for (int i = 0; i < 5; i++) {
   System.out.println(arra[i]);
  }
 }
}
```

### 17. Write a Java program to add two binary numbers.

In digital electronics and mathematics, a binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 1 (one) and 0 (zero).

Test Data:
Input first binary number: 100010
Input second binary number: 110010

```java
import java.util.Scanner;

public class Exercise17 {
 public static void main(String[] args) {
  // Declare variables to store two binary numbers, an index, and a remainder
  long binary1, binary2;
  int i = 0, remainder = 0;
  
  // Create an array to store the sum of binary digits
  int[] sum = new int[20];
  
  // Create a Scanner object to read input from the user
  Scanner in = new Scanner(System.in);

  // Prompt the user to input the first binary number
  System.out.print("Input first binary number: ");
  binary1 = in.nextLong();
  
  // Prompt the user to input the second binary number
  System.out.print("Input second binary number: ");
  binary2 = in.nextLong();

  // Perform binary addition while there are digits in the binary numbers
  while (binary1 != 0 || binary2 != 0) 
  {
   // Calculate the sum of binary digits and update the remainder
   sum[i++] = (int)((binary1 % 10 + binary2 % 10 + remainder) % 2);
   remainder = (int)((binary1 % 10 + binary2 % 10 + remainder) / 2);
   binary1 = binary1 / 10;
   binary2 = binary2 / 10;
  }
  
  // If there is a remaining carry, add it to the sum
  if (remainder != 0) {
   sum[i++] = remainder;
  }
  
  // Decrement the index to prepare for printing
  --i;
  
  // Display the sum of the two binary numbers
  System.out.print("Sum of two binary numbers: ");
  while (i >= 0) {
   System.out.print(sum[i--]);
  }
  
  System.out.print("\n");  
 }
}
```
Explanation:

In the exercise above -

Initialize variables to store the two binary numbers ('binary1' and 'binary2'), an array 'sum' to store the sum, and other necessary variables.
Takes two binary numbers from the user using the "Scanner" class.
Next it enters a loop to perform binary addition from the least significant digit (rightmost) to the most significant digit (leftmost).
Calculate the sum of the corresponding digits from both binary numbers and any remainder from the previous addition.
Store the least significant digit of the sum in the 'sum' array.
Update the remainder and divide both input binary numbers by 10 to move to the next digit.
After the loop, if there's still a remainder left, it adds it to the 'sum' array.
Prints the sum of the two binary numbers by iterating through the 'sum' array from the most significant digit to the least significant digit.
The result is displayed as a binary number.

Input Data:
Input first binary number: 10
Input second binary number: 11
Expected Output

Sum of two binary numbers: 101


### 18. Write a Java program to multiply two binary numbers.

In digital electronics and  mathematics, a binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 1 (one) and 0 (zero).

Test Data:
Input first binary number: 110
Input second binary number: 101

Sample Solution:

Java Code:

```java
import java.util.Scanner;
public class Exercise18 {
 public static void main(String[] args) {
  // Declare variables to store two binary numbers and the product
  long binary1, binary2, multiply = 0;
  
  // Initialize digit and factor variables for processing binary2
  int digit, factor = 1;
  
  // Create a Scanner object to read input from the user
  Scanner in = new Scanner(System.in);
  
  // Prompt the user to input the first binary number
  System.out.print("Input the first binary number: ");
  binary1 = in.nextLong();
  
  // Prompt the user to input the second binary number
  System.out.print("Input the second binary number: ");
  binary2 = in.nextLong();
  
  // Process binary2 to calculate the product
  while (binary2 != 0) {
   digit = (int)(binary2 % 10);
   if (digit == 1) {
    binary1 = binary1 * factor;
    multiply = binaryproduct((int) binary1, (int) multiply);
   } else {
    binary1 = binary1 * factor;
   }
   binary2 = binary2 / 10;
   factor = 10;
  }
  
  // Display the product of the two binary numbers
  System.out.print("Product of two binary numbers: " + multiply + "\n");
 }

 // Method to calculate the product of two binary numbers
 static int binaryproduct(int binary1, int binary2) {
  int i = 0, remainder = 0;
  int[] sum = new int[20];
  int binary_prod_result = 0;

  while (binary1 != 0 || binary2 != 0) {
   sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
   remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
   binary1 = binary1 / 10;
   binary2 = binary2 / 10;
  }

  if (remainder != 0) {
   sum[i++] = remainder;
  }
  
  --i;
  
  while (i >= 0) {
   binary_prod_result = binary_prod_result * 10 + sum[i--];
  }

  return binary_prod_result;
 }
}
``` 

Explanation:

In the exercise above -

Initialize variables to store the two binary numbers ('binary1' and 'binary2'), the result 'multiply', and other necessary variables.
Take two binary numbers from the user using the Scanner class.
Next, it enters a loop to perform binary multiplication by considering the digits of the second binary number one by one from right to left.
For each digit in 'binary2', if it's 1, it multiplies 'binary1' by a factor. It computes the product using the "binaryproduct()" function.
The helper function "binaryproduct()" calculates the binary product of two numbers and returns the result.
If the digit in binary2 is 0, it still multiplies 'binary1' by the factor but doesn't perform the product calculation.
It updates 'binary2' by moving to the next digit (right to left) and adjusting the factor.
After the loop, it prints the product of the two binary numbers, which is stored in the multiply variable.

Input Data:
Input the first binary number: 10
Input the second binary number: 11
Expected Output

Product of two binary numbers: 110 


### 19. Write a Java program to convert an integer number to a binary number.

Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.

Binary number: In digital electronics and  mathematics, a binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 1 (one) and 0 (zero).

Test Data:
Input a Decimal Number : 5

Pictorial Presentation: of decimal to binary number

Java: Convert a decimal number to binary numbers
Java: Decimal number to binary numbers
Sample Solution:

Java Code:
```java		
import java.util.Scanner;

public class Exercise19 {
    public static void main(String args[]) {
        // Declare variables to store decimal number, quotient, and an array for binary digits
        int dec_num, quot, i = 1, j;
        int bin_num[] = new int[100];
        
        // Create a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);

        // Prompt the user to input a decimal number
        System.out.print("Input a Decimal Number: ");
        dec_num = scan.nextInt();

        // Initialize the quotient with the decimal number
        quot = dec_num;

        // Convert the decimal number to binary and store binary digits
        while (quot != 0) {
            bin_num[i++] = quot % 2;
            quot = quot / 2;
        }

        // Display the binary representation of the decimal number
        System.out.print("Binary number is: ");
        for (j = i - 1; j > 0; j--) {
            System.out.print(bin_num[j]);
        }
        System.out.print("\n");
    }
}
```
Explanation:

In the exercise above -

First the code takes an integer or decimal number ('dec_num') as input from the user using the "Scanner" class.
It initializes an array 'bin_num' to store the binary digits of the converted number and other necessary variables.
Next it enters a loop to perform the decimal-to-binary conversion:
In each iteration, it calculates the remainder of 'dec_num' when divided by 2 (which gives the least significant binary digit) and stores it in the 'bin_num' array.
It then updates 'dec_num' by dividing it by 2 (which effectively shifts it to the right).
The loop continues until 'dec_num' becomes zero, effectively converting the entire decimal number to binary.
After the loop, it prints the binary representation of the decimal number by iterating through the 'bin_num' array in reverse order (from the most significant digit to the least significant digit).

Input Data:
Input a Decimal Number : 5
Expected Output

Binary number is: 101 


### 20. Write a Java program to convert a decimal number to a hexadecimal number.

Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.

Hexadecimal number: Hexadecimal is a positional numeral system with a radix, or base, of 16. It uses sixteen distinct symbols, most often the symbols 0-9 to represent values zero to nine, and A, B, C, D, E, F (or alternatively a, b, c, d, e, f) to represent values ten to fifteen.

Test Data:
Input a decimal number: 15

Pictorial Presentation: Decimal to Hexadecimal number

Java: Convert a decimal number to hexadecimal number
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise20 {
    public static void main(String args[]) {
        // Declare variables to store decimal number and remainder
        int dec_num, rem;
        
        // Initialize an empty string for the hexadecimal number
        String hexdec_num = "";
        
        // Define the hexadecimal number digits
        char hex[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        
        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Prompt the user to input a decimal number
        System.out.print("Input a decimal number: ");
        dec_num = in.nextInt();

        // Convert the decimal number to hexadecimal
        while (dec_num > 0) {
            rem = dec_num % 16;
            hexdec_num = hex[rem] + hexdec_num;
            dec_num = dec_num / 16;
        }
        
        // Display the hexadecimal representation of the decimal number
        System.out.print("Hexadecimal number is: " + hexdec_num + "\n");
    }
}
```
Explanation:

In the exercise above -

It takes a decimal number ('dec_num') as input from the user using the "Scanner" class.
It initializes an empty string 'hexdec_num' to store the hexadecimal representation and defines an array 'hex' containing hexadecimal digits (0-9 and A-F).
It enters a loop to perform the decimal-to-hexadecimal conversion:
In each iteration, it calculates the remainder of 'dec_num' when divided by 16 (which gives the hexadecimal digit) and appends it to the 'hexdec_num' string.
It then updates 'dec_num' by dividing it by 16.
The loop continues until 'dec_num' becomes zero, effectively converting the entire decimal number to hexadecimal.
After the loop, it prints the hexadecimal representation of the decimal number stored in the 'hexdec_num' string.

Input Data:
Input a decimal number: 15
Expected Output

Hexadecimal number is : F 


### 21. Write a Java program to convert a decimal number to an octal number.

Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.

Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.

Pictorial Presentation: Decimal to Octal number

Java: Convert a decimal number to octal number
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise21 {
    public static void main(String args[]) {
        // Declare variables to store decimal number, remainder, quotient, and an array for octal digits
        int dec_num, rem, quot, i = 1, j;
        int oct_num[] = new int[100];
        
        // Create a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);

        // Prompt the user to input a decimal number
        System.out.print("Input a Decimal Number: ");
        dec_num = scan.nextInt();

        // Initialize the quotient with the decimal number
        quot = dec_num;

        // Convert the decimal number to octal and store octal digits
        while (quot != 0) {
            oct_num[i++] = quot % 8;
            quot = quot / 8;
        }

        // Display the octal representation of the decimal number
        System.out.print("Octal number is: ");
        for (j = i - 1; j > 0; j--) {
            System.out.print(oct_num[j]);
        }
        
        System.out.print("\n");
    }
}
```
Explanation:

In the exercise above -

It takes a decimal number ('dec_num') as input from the user using the "Scanner" class.
It initializes an array 'oct_num' to store the octal digits of the converted number and other necessary variables.
It enters a loop to perform the decimal-to-octal conversion:
In each iteration, it calculates the remainder of 'dec_num' when divided by 8 and stores it in the 'oct_num' array.
It then updates 'dec_num' by dividing it by 8 (which effectively shifts it to the right).
The loop continues until 'dec_num' becomes zero, effectively converting the entire decimal number to octal.
After the loop, it prints the octal representation of the decimal number by iterating through the 'oct_num' array in reverse order.

Input Data:
Input a Decimal Number: 15
Expected Output

Octal number is: 17  


### 22. Write a Java program to convert a binary number to a decimal number.

Binary number: A binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 1 (one) and 0 (zero).

Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.

Pictorial Presentation: Binary to Decimal number

Java: Convert a binary number to decimal number
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise22 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        
        // Declare variables to store binary and decimal numbers, remainder, and a multiplier
        long binaryNumber, decimalNumber = 0, j = 1, remainder;
        
        // Prompt the user to input a binary number
        System.out.print("Input a binary number: ");
        binaryNumber = sc.nextLong();

        // Convert the binary number to decimal
        while (binaryNumber != 0) {
            remainder = binaryNumber % 10;
            decimalNumber = decimalNumber + remainder * j;
            j = j * 2;
            binaryNumber = binaryNumber / 10;
        }
        
        // Display the decimal representation of the binary number
        System.out.println("Decimal Number: " + decimalNumber);
    }
}
```
Explanation:

In the exercise above -

It takes a binary number as input from the user using the "Scanner" class and stores it in the variable 'binaryNumber'.
It initializes a variable 'decimalNumber' to store the decimal equivalent and another variable 'j' as a multiplier, starting from 1.
It enters a loop to perform the binary-to-decimal conversion:
In each iteration, it calculates the remainder when the 'binaryNumber' is divided by 10 (which gives the least significant binary digit).
It then adds this remainder multiplied by the current value of 'j' to the 'decimalNumber'.
It multiplies 'j' by 2 to prepare for the next binary digit.
It updates 'binaryNumber' by removing the least significant digit (rightmost) and by dividing it by 10.
The loop continues until 'binaryNumber' becomes zero, effectively converting the entire binary number to decimal.
After the loop, it prints the decimal representation of the binary number stored in the 'decimalNumber' variable.

Input Data:
Input a binary number: 100
Expected Output

Decimal Number: 4 


### 23. Write a Java program to convert a binary number to a hexadecimal number.

Binary number: A binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 0(zero) and 1(one).

Hexadecimal number: This is a positional numeral system with a radix, or base, of 16. Hexadecimal uses sixteen distinct symbols, most often the symbols 0-9 to represent values zero to nine, and A, B, C, D, E, F (or alternatively a, b, c, d, e, f) to represent values ten to fifteen.

Test Data:
Input a binary number: 1101

Pictorial Presentation: Binary to Hexadecimal number

Java: Convert a binary number to hexadecimal number
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args) {
        // Declare an array to store hexadecimal digits, variables for calculation, and binary input
        int[] hex = new int[1000];
        int i = 1, j = 0, rem, dec = 0, bin;

        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Prompt the user to input a binary number
        System.out.print("Input a Binary Number: ");
        bin = in.nextInt();

        // Convert the binary number to decimal
        while (bin > 0) {
            rem = bin % 2;
            dec = dec + rem * i;
            i = i * 2;
            bin = bin / 10;
        }
        i = 0;

        // Convert the decimal number to hexadecimal
        while (dec != 0) {
            hex[i] = dec % 16;
            dec = dec / 16;
            i++;
        }

        // Display the hexadecimal value
        System.out.print("Hexadecimal value: ");
        for (j = i - 1; j >= 0; j--) {
            if (hex[j] > 9) {
                System.out.print((char)(hex[j] + 55));
            } else {
                System.out.print(hex[j]);
            }
        }
        System.out.print("\n");
    }
}
```
Explanation:

In the exercise above -

Initializes an array 'hex' to store the hexadecimal digits of the converted number, as well as other necessary variables.
It takes a binary number as input from the user using the "Scanner" class and stores it in the variable 'bin'.
It enters a loop to convert the binary number to decimal:
In each iteration, it calculates the remainder when the 'bin' is divided by 2 (which gives the least significant binary digit).
It adds this remainder multiplied by 'i' to the 'dec' variable to accumulate the decimal value.
It multiplies 'i' by 2 to prepare for the next binary digit.
It updates 'bin' by removing the least significant digit (rightmost) by dividing it by 10.
The loop continues until 'bin' becomes zero, effectively converting the entire binary number to decimal.
After converting to decimal, it enters another loop to convert the decimal number to hexadecimal:
In each iteration, it calculates the remainder when 'dec' is divided by 16 (which gives the least significant hexadecimal digit).
It stores this remainder in a 'hex' array.
It updates 'dec' by dividing it by 16 to move to the next hexadecimal digit.
Finally, it prints the hexadecimal representation of the original binary number by iterating through the 'hex' array in reverse order. It also handles hexadecimal digits greater than 9 by converting them to the corresponding letters A-F.

Input Data:
Input a Binary Number: 1101
Expected Output

HexaDecimal value: D


### 24. Write a Java program to convert a binary number to an octal number.

Binary number: A binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 0(zero) and 1(one).

Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.

Test Data:
Input a binary number: 111

Pictorial Presentation: Binary to Octal number

Java: Convert a binary number to a Octal number
Sample Solution:

Java Code:
```java
import java.util.*;

public class Exercise24 {
    public static void main(String[] args) {
        // Declare variables to store binary and decimal numbers, remainder, quotient, and an array for octal digits
        int binnum, binnum1, rem, decnum = 0, quot, i = 1, j;
        int octnum[] = new int[100];

        // Create a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);

        // Prompt the user to input a binary number
        System.out.print("Input a Binary Number : ");
        binnum = scan.nextInt();
        binnum1 = binnum;

        // Convert the binary number to decimal
        while (binnum > 0) {
            rem = binnum % 10;
            decnum = decnum + rem * i;
            i = i * 2;
            binnum = binnum / 10;
        }

        i = 1;
        quot = decnum;

        // Convert the decimal number to octal
        while (quot > 0) {
            octnum[i++] = quot % 8;
            quot = quot / 8;
        }

        // Display the equivalent octal value of the original binary number
        System.out.print("Equivalent Octal Value of " + binnum1 + " is :");
        for (j = i - 1; j > 0; j--) {
            System.out.print(octnum[j]);
        }
        System.out.print("\n");
    }
}
```
Explanation:

In the exercise above -

First, initialize an array 'octnum' to store the octal digits of the converted number and other necessary variables.
It takes a binary number as input from the user using the "Scanner" class and stores it in the variable 'binnum'.
Next it enters a loop to convert the binary number to decimal:
In each iteration, it calculates the remainder when 'binnum' is divided by 10 (which gives the least significant binary digit).
It adds this remainder multiplied by i to the 'decnum' variable to accumulate the decimal value.
It multiplies 'i' by 2 to prepare for the next binary digit.
It updates 'binnum' by removing the least significant digit (rightmost) and by dividing it by 10.
The loop continues until 'binnum' becomes zero, effectively converting the entire binary number to decimal.
After converting to decimal, it enters another loop to convert the decimal number to octal:
In each iteration, it calculates the remainder when 'decnum' is divided by 8 (which gives the least significant octal digit).
It stores this remainder in the 'octnum' array.
It updates 'decnum' by dividing it by 8 to move to the next octal digit.
Finally, it prints the octal representation of the original binary number by iterating through the 'octnum' array in reverse order.

Input Data:
Input a Binary Number: 111
Expected Output

Octal number: 7 


### 25. Write a Java program to convert a octal number to a decimal number.

Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.

Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.

Test Data:
Input any octal number: 10

Pictorial Presentation: Octal to Decimal number

Java: Convert a octal number to a decimal number
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise25 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);
        
        // Declare variables to store octal and decimal numbers, and an index counter
        long octal_num, decimal_num = 0;
        int i = 0;
        
        // Prompt the user to input an octal number
        System.out.print("Input any octal number: ");
        octal_num = in.nextLong();
        
        // Convert the octal number to decimal
        while (octal_num != 0) {
            decimal_num = (long)(decimal_num + (octal_num % 10) * Math.pow(8, i++));
            octal_num = octal_num / 10;
        }
        
        // Display the equivalent decimal number
        System.out.print("Equivalent decimal number: " + decimal_num + "\n");
    }
}
```
Explanation:

In the exercise above -

First, it takes an octal number as input from the user using the "Scanner" class and stores it in the variable 'octal_num'.
It initializes a variable 'decimal_num' to store the decimal equivalent and another variable 'i' to keep track of the position of each octal digit.
It enters a loop to perform the octal-to-decimal conversion:
In each iteration, it calculates the remainder when 'octal_num' is divided by 10 (which gives the least significant octal digit).
It multiplies this remainder by 8 raised to the power of 'i' and adds it to 'decimal_num' to accumulate the decimal value.
To move to the next octal digit, it increments i.
It updates 'octal_num' by removing the least significant digit (rightmost) by dividing it by 10.
The loop continues until 'octal_num' becomes zero, effectively converting the entire octal number to decimal.
After the loop, it prints the decimal representation of the original octal number stored in the ‘decimal_num’ variable.

Input Data:
Input any octal number: 10
Expected Output

Equivalent decimal number: 8


### 26. Write a Java program to convert a octal number to a binary number.

Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.

Binary number: A binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 1 (one) and 0 (zero).

Test Data:
Input any octal number: 7

Pictorial Presentation: Octal to Binary number

Java: Convert a octal number to a binary number
Sample Solution:

Java Code:

```java
import java.util.Scanner;

public class Exercise26 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);
        
        // Define an array to map octal digits to their binary equivalents
        int[] octal_numvalues = {0, 1, 10, 11, 100, 101, 110, 111};
        
        // Declare variables to store octal, temporary octal, and binary numbers, and a place value
        long octal_num, tempoctal_num, binary_num, place;
        int rem;
        
        // Prompt the user to input an octal number
        System.out.print("Input any octal number: ");
        octal_num = in.nextLong();
        tempoctal_num = octal_num;
        binary_num = 0;
        place = 1;
        
        // Convert the octal number to binary using the mapping array
        while (tempoctal_num != 0) {
            rem = (int)(tempoctal_num % 10);
            binary_num = octal_numvalues[rem] * place + binary_num;
            tempoctal_num /= 10;
            place *= 1000;
        }
        
        // Display the equivalent binary number
        System.out.print("Equivalent binary number: " + binary_num + "\n");
    }
}
```
Explanation:

In the exercise above -

First, it takes an octal number as input from the user using the "Scanner" class and stores it in the variable 'octal_num'.
It initializes an array 'octal_numvalues' to store the binary equivalents of octal digits (0 to 7).
It initializes variables 'tempoctal_num' to temporarily store the octal number, 'binary_num' to store the binary equivalent, 'place' to keep track of the position of each octal digit, and 'rem' to store the remainder when dividing 'tempoctal_num' by 10.
Next it enters a loop to perform the octal-to-binary conversion:
In each iteration, it calculates the remainder 'rem' when 'tempoctal_num' is divided by 10 (which gives the least significant octal digit).
It uses 'rem' to look up the binary equivalent from the 'octal_numvalues' array and adds it to 'binary_num', taking into account the appropriate place value.
It divides 'tempoctal_num' by 10 to remove the least significant digit (rightmost).
It updates the 'place' variable to move to the next group of three binary digits.
The loop continues until 'tempoctal_num' becomes zero, effectively converting the entire octal number to binary.
Finally (after the loop), it prints the binary representation of the original octal number stored in the 'binary_num' variable.

Input Data:
Input any octal number: 7
Expected Output

Equivalent binary number: 111 


### 27. Write a Java program to convert a octal number to a hexadecimal number.

Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.

Hexadecimal number: This is a positional numeral system with a radix, or base, of 16. Hexadecimal uses sixteen distinct symbols, most often the symbols 0-9 to represent values zero to nine, and A, B, C, D, E, F (or alternatively a, b, c, d, e, f) to represent values ten to fifteen.

Test Data:
Input any octal number: 100

Pictorial Presentation: Octal to Hexadecimal number

Java: Convert a octal number to a hexadecimal number
Sample Solution:

Java Code:

```java
public class Exercise27 {
    public static void main(String args[]) {
        // Declare variables to store octal number and its decimal and hexadecimal equivalents
        String octal_num, hex_num;
        int decnum;
        
        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to input an octal number
        System.out.print("Input an octal number : ");
        octal_num = in.nextLine();
        
        // Convert the octal number to its decimal equivalent using parseInt
        decnum = Integer.parseInt(octal_num, 8);
        
        // Convert the decimal number to its hexadecimal equivalent
        hex_num = Integer.toHexString(decnum);
        
        // Display the equivalent hexadecimal number
        System.out.print("Equivalent hexadecimal number: " + hex_num + "\n");
    }
}
```
Explanation:

In the exercise above -

First, it takes an octal number as input from the user using the "Scanner" class and stores it as a string in the variable 'octal_num'.
It uses the "Integer.parseInt()" method to convert the 'octal_num' string to an integer 'decnum', specifying base 8 (octal) as the input radix.
It then uses the "Integer.toHexString()" method to convert the 'decnum' to its hexadecimal representation and stores it in the 'hex_num' string.
Finally, it prints the hexadecimal representation of the original octal number stored in the 'hex_num' variable.

Input Data:
Input a octal number : 100
Expected Output

Equivalent hexadecimal number: 40


### 28. Write a Java program to convert a hexadecimal value into a decimal number.

Hexadecimal number: This is a positional numeral system with a radix, or base, of 16. Hexadecimal uses sixteen distinct symbols, most often the symbols 0-9 to represent values zero to nine, and A, B, C, D, E, F (or alternatively a, b, c, d, e, f) to represent values ten to fifteen.

Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.

Test Data:
Input any hexadecimal number: 25

Pictorial Presentation: Hexadecimal to Decimal number

Java: Convert a hexadecimal to a decimal number
Sample Solution:

Java Code:

```java
import java.util.Scanner;

public class Exercise28 {
    // Function to convert a hexadecimal string to a decimal integer
    public static int hex_to_decimal(String s) {
        // Define a string containing hexadecimal digits
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase(); // Convert the input string to uppercase
        int val = 0; // Initialize the decimal value to 0

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Get the current character
            int d = digits.indexOf(c); // Find the index of the character in the digits string
            val = 16 * val + d; // Update the decimal value using hexadecimal conversion
        }

        return val; // Return the decimal value
    }

    public static void main(String args[]) {
        String hexdec_num;
        int dec_num;
        Scanner scan = new Scanner(System.in);

        // Prompt the user to input a hexadecimal number
        System.out.print("Input a hexadecimal number: ");
        hexdec_num = scan.nextLine();

        // Call the hex_to_decimal function to convert the hexadecimal number to decimal
        dec_num = hex_to_decimal(hexdec_num);

        // Display the equivalent decimal number
        System.out.print("Equivalent decimal number is: " + dec_num + "\n");
    }
}
```
Explanation:

In the exercise above -

First, it defines a method "hex_to_decimal()" that takes a hexadecimal string 's' as input and converts it to its decimal equivalent.
The method initializes a string 'digits' containing the hexadecimal digits (0-9 and A-F) and ensures that the input string 's' is in uppercase to handle both uppercase and lowercase hexadecimal characters.
It initializes an integer variable 'val' to store the decimal value.
Next it iterates through each character 'c' in the input string 's' and finds the corresponding decimal value 'd' by looking up the index of 'c' in the 'digits' string.
It updates the 'val' by multiplying it by 16 and adding the decimal value 'd'.
The method returns the final decimal value 'val'.
In the "main()" function, it takes a hexadecimal number as input from the user using the "Scanner" class and stores it in the 'hexdec_num' string.
It calls the "hex_to_decimal()" method, passing 'hexdec_num' as an argument, to convert the hexadecimal string to its decimal equivalent and stores it in the 'dec_num' variable.
Finally, it prints the decimal representation of the original hexadecimal number stored in the 'dec_num' variable.

Input Data:
Input a hexadecimal number: 25
Expected Output

Equivalent decimal number is: 37


### 29. Write a Java program to convert a hexadecimal number into a binary number.

Hexadecimal number: This is a positional numeral system with a radix, or base, of 16. Hexadecimal uses sixteen distinct symbols, most often the symbols 0-9 to represent values zero to nine, and A, B, C, D, E, F (or alternatively a, b, c, d, e, f) to represent values ten to fifteen.

Binary number: A binary number is a number expressed in the base-2 numeral system or binary numeral system. This system uses only two symbols: typically 1 (one) and 0 (zero).

Test Data:
Input any hexadecimal number: 37

Pictorial Presentation: Hexadecimal to Binary number

Java: Convert a hexadecimal to a binary number
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise29 {
    // Function to convert a hexadecimal string to a decimal integer
    public static int hex_to_binary(String s) {
        // Define a string containing hexadecimal digits
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase(); // Convert the input string to uppercase
        int val = 0; // Initialize the decimal value to 0

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Get the current character
            int d = digits.indexOf(c); // Find the index of the character in the digits string
            val = 16 * val + d; // Update the decimal value using hexadecimal conversion
        }

        return val; // Return the decimal value
    }

    public static void main(String args[]) {
        String hexdec_num;
        int dec_num, i = 1, j;
        int bin_num[] = new int[100];
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter a hexadecimal number
        System.out.print("Enter Hexadecimal Number : ");
        hexdec_num = scan.nextLine();

        // Call the hex_to_binary function to convert the hexadecimal number to decimal
        dec_num = hex_to_binary(hexdec_num);

        // Convert the decimal number to binary
        while (dec_num != 0) {
            bin_num[i++] = dec_num % 2;
            dec_num = dec_num / 2;
        }

        // Display the equivalent binary number
        System.out.print("Equivalent Binary Number is: ");
        for (j = i - 1; j > 0; j--) {
            System.out.print(bin_num[j]);
        }

        System.out.print("\n");
    }
}
```
Explanation:

In the exercise above -

First, it defines a method "hex_to_decimal()" that takes a hexadecimal string 's' as input and converts it to its decimal equivalent.
The method initializes a string 'digits' containing the hexadecimal digits (0-9 and A-F) and ensures that the input string 's' is in uppercase to handle both uppercase and lowercase hexadecimal characters.
It initializes an integer variable 'val' to store the decimal value.
Next it iterates through each character 'c' in the input string 's' and finds the corresponding decimal value 'd' by looking up the index of 'c' in the 'digits' string.
It updates the 'val' by multiplying it by 16 and adding the decimal value 'd'.
The method returns the final decimal value 'val'.
In the "main()" function, it takes a hexadecimal number as input from the user using the "Scanner" class and stores it in the 'hexdec_num' string.
It calls the "hex_to_decimal()" method, passing 'hexdec_num' as an argument, to convert the hexadecimal string to its decimal equivalent and stores it in the 'dec_num' variable.
Finally, it prints the decimal representation of the original hexadecimal number stored in the 'dec_num' variable.

Input Data:
Enter Hexadecimal Number : 37
Expected Output

Equivalent Binary Number is: 110111


### 30. Write a Java program to convert a hexadecimal value into an octal number.

Hexadecimal number: This is a positional numeral system with a radix, or base, of 16. Hexadecimal uses sixteen distinct symbols, most often the symbols 0-9 to represent values zero to nine, and A, B, C, D, E, F (or alternatively a, b, c, d, e, f) to represent values ten to fifteen.

Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.

Test Data:
Input any hexadecimal number: 40

Pictorial Presentation: Hexadecimal to Octal number

Java: Convert a hexadecimal to a octal number
Sample Solution:

Java Code:

```java
import java.util.Scanner;

public class Main {
    // Function to convert a hexadecimal string to a decimal integer
    public static int hex_to_oct(String s) {
        // Define a string containing hexadecimal digits
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase(); // Convert the input string to uppercase
        int val = 0; // Initialize the decimal value to 0

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Get the current character
            int d = digits.indexOf(c); // Find the index of the character in the digits string
            val = 16 * val + d; // Update the decimal value using hexadecimal conversion
        }

        return val; // Return the decimal value
    }

    public static void main(String args[]) {
        String hexdec_num;
        int dec_num, i = 1, j;
        int octal_num[] = new int[100];
        Scanner in = new Scanner(System.in);

        // Prompt the user to input a hexadecimal number
        System.out.print("Input a hexadecimal number: ");
        hexdec_num = in.nextLine();

        // Call the hex_to_oct function to convert the hexadecimal number to decimal
        dec_num = hex_to_oct(hexdec_num);

        // Convert the decimal number to octal
        while (dec_num != 0) {
            octal_num[i++] = dec_num % 8;
            dec_num = dec_num / 8;
        }

        // Display the equivalent octal number
        System.out.print("Equivalent of octal number is: ");
        for (j = i - 1; j > 0; j--) {
            System.out.print(octal_num[j]);
        }

        System.out.print("\n");
    }
}
```
Explanation:

In the exercise above -

First, it defines a method "hex_to_oct()" that takes a hexadecimal string 's' as input and converts it to its decimal equivalent. It initializes a string 'digits' containing the hexadecimal digits (0-9 and A-F), ensures that the input string 's' is in uppercase, and iterates through the characters to compute the decimal value.
In the "main()" function, it takes a hexadecimal number as input from the user using the "Scanner" class and stores it in the 'hexdec_num' string.
It calls the " hex_to_oct ()" method, passing 'hexdec_num' as an argument, to convert the hexadecimal string to its decimal equivalent and stores it in the 'dec_num' variable.
Then, it converts the decimal number to octal:
It initializes an integer array 'octal_num' to store the octal digits.
It enters a loop to perform the decimal-to-octal conversion:
In each iteration, it calculates the remainder when 'dec_num' is divided by 8 (which gives the least significant octal digit).
It stores this remainder in the 'octal_num' array.
It updates 'dec_num' by dividing it by 8 to move to the next octal digit.
It uses 'i' to keep track of each octal digit's position.
Finally, it prints the octal representation of the original hexadecimal number by iterating through the 'octal_num' array in reverse order (from the most significant digit to the least significant digit).

Input Data:
Input a hexadecimal number: 40
Expected Output

Equivalent of octal number is: 100 


### 31. Write a Java program to check whether Java is installed on your computer.

```java
public class Exercise31 {
    public static void main(String[] args) {
        // Display Java version
        System.out.println("\nJava Version: " + System.getProperty("java.version"));
        
        // Display Java runtime version
        System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
        
        // Display Java home directory
        System.out.println("Java Home: " + System.getProperty("java.home"));
        
        // Display Java vendor name
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        
        // Display Java vendor URL
        System.out.println("Java Vendor URL: " + System.getProperty("java.vendor.url"));
        
        // Display Java class path
        System.out.println("Java Class Path: " + System.getProperty("java.class.path") + "\n");
    }
}
```
Explanation:

In the exercise above:

It uses System.getProperty() to access and retrieve specific Java system properties.
Finally, it prints the following information about the  Java runtime environment runtime environment:
Java Version: The Java version  installed on the system.
 Java Runtime Version: The Java Runtime Environment (JRE) used.
Java Home: The directory path to the Java installation directory.
Java Vendor: The Java runtime vendor or provider.
Java Vendor URL: The Java vendor's URL or website.
Java Class Path: The classpath, which specifies the directories and JAR files that the Java runtime should use when searching for classes and resources.

Expected Output

Java Version: 1.8.0_71                                                            
Java Runtime Version: 1.8.0_71-b15                                                
Java Home: /opt/jdk/jdk1.8.0_71/jre                                               
Java Vendor: Oracle Corporation                                                   
Java Vendor URL: http://Java.oracle.com/                                          
Java Class Path: .


### 32. Write a Java program to compare two numbers.

Pictorial Presentation:

Java Code:

```java
import java.util.Scanner;

public class Exercise32 {
    public static void main(String args[]) {
        // Create a Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);
        int number1; // First number to compare
        int number2; // Second number to compare

        // Prompt the user to input the first integer
        System.out.print("Input first integer: ");
        number1 = input.nextInt(); // Read the first number from the user

        // Prompt the user to input the second integer
        System.out.print("Input second integer: ");
        number2 = input.nextInt(); // Read the second number from the user

        // Compare and display the results
        if (number1 == number2)
            System.out.printf("%d == %d\n", number1, number2);
        if (number1 != number2)
            System.out.printf("%d != %d\n", number1, number2);
        if (number1 < number2)
            System.out.printf("%d < %d\n", number1, number2);
        if (number1 > number2)
            System.out.printf("%d > %d\n", number1, number2);
        if (number1 <= number2)
            System.out.printf("%d <= %d\n", number1, number2);
        if (number1 >= number2)
            System.out.printf("%d >= %d\n", number1, number2);
    }
}
```  

Explanation:

In the exercise above –

First, it uses the "Scanner" class to obtain input from the command window (user input).
It declares two integer variables 'number1' and 'number2' to store the two numbers provided by the user.
It prompts the user to input the first integer using System.out.print("Input first integer: ") and reads the input into 'number1'.
It prompts the user to input the second integer using System.out.print("Input second integer: ") and reads the input into 'number2'.
Next it performs a series of comparisons using if statements and prints the results using System.out.printf():
if (number1 == number2) checks if 'number1' is equal to 'number2' and prints a message if they are equal.
if (number1 != number2) checks if 'number1' is not equal to 'number2' and prints a message if they are not equal.
if (number1 < number2) checks if 'number1' is less than 'number2' and prints a message if 'number1' is less than 'number2'.
if (number1 > number2) checks if 'number1' is greater than 'number2' and prints a message if 'number1' is greater than 'number2'.
if (number1 <= number2) checks if 'number1' is less than or equal to 'number2' and prints a message accordingly.
if (number1 >= number2) checks if 'number1' is greater than or equal to number2 and prints a message accordingly.

Input Data:
Input first integer: 25
Input second integer: 39
Expected Output

25 != 39                                                                          
25 < 39                                                                           
25 <= 39


### 33. Write a Java program and compute the sum of an integer's digits.

```java
import java.util.Scanner;

public class Exercise33 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to input an integer
        System.out.print("Input an integer: ");
        
        // Read the integer from the user
        long n = input.nextLong();
        
        // Calculate and display the sum of the digits
        System.out.println("The sum of the digits is: " + sumDigits(n));
    }

    public static int sumDigits(long n) {
        int sum = 0;
        
        // Calculate the sum of the digits
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        
        return sum;
    }
}
```
Explanation:

In the exercise above -

It uses the Scanner class to obtain input from the user.
First, it prompts the user to input an integer using System.out.print("Input an integer: ") and reads the input into the variable 'n'.
It then calls a separate method named "sumDigits()" and passes the input integer n as an argument.
Inside the "sumDigits()" method:
It initializes an integer variable 'sum' to store the sum of the digits, starting with 0.
It enters a while loop that continues as long as 'n' is not equal to 0.
Inside the loop, it calculates the last digit of 'n' using the modulus operator (n % 10) and adds it to the 'sum' variable.
It then removes the last digit from 'n' by dividing it by 10 (n /= 10).
This process continues until all digits of the original number have been processed.
Finally, it returns the 'sum' containing the sum of the digits.
Finally, back in the "main()" method, it prints the result of the "sumDigits()" method, displaying the sum of the digits of the entered integer.

Input Data:
Input an integer: 25
Expected Output

The sum of the digits is: 7


### 34. Write a Java program to compute hexagon area.
```java
import java.util.Scanner;

public class Exercise34 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to input the length of a side of the hexagon
        System.out.print("Input the length of a side of the hexagon: ");
        
        // Read the length of a side from the user
        double s = input.nextDouble();
        
        // Calculate and display the area of the hexagon
        System.out.print("The area of the hexagon is: " + hexagonArea(s) + "\n");
    }

    public static double hexagonArea(double s) {
        // Calculate the area of a hexagon based on its side length
        return (6 * (s * s)) / (4 * Math.tan(Math.PI / 6));
    }
}
```
Explanation:

In the exercise above -

First it uses the "Scanner" class to obtain input from the user.
It prompts the user to input the length of a side of the hexagon using System.out.print("Input the length of a side of the hexagon: ") and reads the input into the variable 's'.
It then calls a separate method named "hexagonArea()" and passes the input length s as an argument.
Inside the "hexagonArea()" method:
It calculates the area of the hexagon using the formula (6 s^2) / (4 tan(π/6)), where s is the length of a side and tan(π/6) represents the tangent of 30 degrees (π/6 radians), which is a constant value.
It returns the calculated area as a double.
Finally, back in the "main()" method, it prints the result of the "hexagonArea()" method, displaying the area of the hexagon based on the user-provided side length.

Area of a hexagon = (6 * s^2)/(4*tan(π/6))
where s is the length of a side
Input Data:
Input the length of a side of the hexagon: 6
Expected Output

The area of the hexagon is: 93.53074360871938


### 35. Write a Java program to compute the area of a polygon.

Area of a polygon = (n*s^2)/(4*tan(π/n))
where n is n-sided polygon and s is the length of a side.

Test Data:
Input the number of sides on the polygon: 7
Input the length of one of the sides: 6

Pictorial Presentation: Area of Polygon

Java: Compute the area of a polygon
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise35 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to input the number of sides on the polygon
        System.out.print("Input the number of sides on the polygon: ");
        
        // Read the number of sides from the user
        int ns = input.nextInt();
        
        // Prompt the user to input the length of one of the sides
        System.out.print("Input the length of one of the sides: ");
        
        // Read the length of one side from the user
        double side = input.nextDouble();
        
        // Calculate and display the area of the polygon
        System.out.print("The area is: " + polygonArea(ns, side) + "\n");
    }
    
    public static double polygonArea(int ns, double side) {
        // Calculate the area of a polygon based on the number of sides and side length
        return (ns * (side * side)) / (4.0 * Math.tan((Math.PI / ns)));
    }
}
```
Explanation:

In the exercise above -

First, it uses the "Scanner" class to obtain user input.
The user is prompted to input the number of sides on the polygon using System.out.print("Input the number of sides on the polygon: "), and the input is read into the variable 'ns' as an integer.
The user is prompted to input the length of one of the sides of the polygon using System.out.print("Input the length of one of the sides: "), and the input is read into the variable 'side' as a double.
The code then calls a separate method named "polygonArea" and passes the number of sides ns and the side length 'side' as arguments.
Inside the "polygonArea()" method:
It calculates the area of the polygon using the formula (ns side^2) / (4 tan(π / ns)), where 'ns' is the number of sides, 'side' is the length of one side, and tan(π / ns) represents the tangent of the angle formed by each side of the polygon, given by π / ns.
The calculated area is returned as a double.
In the "main()" method, the result of the "polygonArea()" method is printed, displaying the area of the polygon based on the user-provided number of sides and side length.

Area of a polygon = (n*s^2)/(4*tan(π/n))
where n is n-sided polygon and s is the length of a side
Input Data:
Input the number of sides on the polygon: 7
Input the length of one of the sides: 6
Expected Output

The area is: 130.82084798405722


### 36. Write a Java program to compute the distance between two points on the earth's surface.

Distance between the two points [ (x1,y1) & (x2,y2)]
d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
Radius of the earth r = 6371.01 Kilometers

Test Data:
Input the latitude of coordinate 1: 25
Input the longitude of coordinate 1: 35
Input the latitude of coordinate 2: 52.5
Input the longitude of coordinate 2: 35.5

Pictorial Presentation:

Java: Compute the distance between two points on the surface of earth
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Exercise36 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to input the latitude and longitude of coordinate 1
        System.out.print("Input the latitude of coordinate 1: ");
        double lat1 = input.nextDouble();
        System.out.print("Input the longitude of coordinate 1: ");
        double lon1 = input.nextDouble();
        
        // Prompt the user to input the latitude and longitude of coordinate 2
        System.out.print("Input the latitude of coordinate 2: ");
        double lat2 = input.nextDouble();
        System.out.print("Input the longitude of coordinate 2: ");
        double lon2 = input.nextDouble();

        // Calculate and display the distance between the two coordinates
        System.out.print("The distance between those points is: " + distance_Between_LatLong(lat1, lon1, lat2, lon2) + " km\n");
    }

    // Points will be converted to radians before calculation
    public static double distance_Between_LatLong(double lat1, double lon1, double lat2, double lon2) {
        // Convert latitude and longitude to radians
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Earth's mean radius in kilometers
        double earthRadius = 6371.01;

        // Calculate the distance using the haversine formula
        return earthRadius * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    }
}
```
Explanation:

In the exercise above -

First, it uses the "Scanner" class to obtain user input.
The user is prompted to input the latitude and longitude of two coordinates:
Latitude and longitude of coordinate 1 are read into the variables 'lat1' and 'lon1'.
Latitude and longitude of coordinate 2 are read into the variables 'lat2' and 'lon2'.
The code then calls a separate method named "distance_Between_LatLong()" and passes the latitude and longitude values of both coordinates as arguments.
Inside the "distance_Between_LatLong()" method:
It converts latitude and longitude values from degrees to radians using the " Math.toRadians()" method to perform trigonometric calculations.
It calculates the distance between the two coordinates using the Haversine formula for calculating distances on a sphere.
The calculated distance is returned as a double, representing the distance in kilometers.
Finally, in the "main() method, the result of the "distance_Between_LatLong()" method is printed, displaying the distance between the two coordinates in kilometers.

Distance between the two points [ (x1,y1) & (x2,y2)]
d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
Radius of the earth r = 6371.01 Kilometers
Input Data:
Input the latitude of coordinate 1: 25
Input the longitude of coordinate 1: 35
Input the latitude of coordinate 2: 35.5
Input the longitude of coordinate 2: 25.5
Expected Output

The distance between those points is: 1480.0848451069087 km 


### 37. Write a Java program to reverse a string.

```java
import java.util.Scanner;

public class Exercise37 {
    public static void main(String[] args) {
        // Create a scanner to obtain input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to input a string
        System.out.print("Input a string: ");
        
        // Read the input string and convert it to a character array
        char[] letters = scanner.nextLine().toCharArray();
        
        // Display a message before printing the reversed string
        System.out.print("Reverse string: ");
        
        // Iterate through the character array in reverse order and print each character
        for (int i = letters.length - 1; i >= 0; i--) {
            System.out.print(letters[i]);
        }
        
        // Print a newline character to end the output line
        System.out.print("\n");
    }
}
```
Explanation:

In the exercise above -

First, it uses the "Scanner" class to obtain user input.
The user is prompted to input a string using System.out.print("Input a string: ").
The input string is read using scanner.nextLine() and converted to a character array using toCharArray(). This character array is stored in the 'letters' variable.
Next, the code enters a loop that iterates from the last character of the 'letters' array to the first character (in reverse order). Inside the loop, it prints each character, effectively reversing the string character by character.
Finally, a newline character is printed to ensure a clean output format.

Input Data:
Input a string: The quick brown fox
Expected Output

Reverse string: xof nworb kciuq ehT


### 38. Write a Java program to count letters, spaces, numbers and other characters in an input string.
```java
import java.util.Scanner;

public class Exercise38 {
    public static void main(String[] args) {
        // Define a test string containing letters, numbers, spaces, and other characters
        String test = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
        
        // Call the count method to analyze the characters in the test string
        count(test);
    }

    public static void count(String x) {
        // Convert the input string to a character array
        char[] ch = x.toCharArray();
        
        // Initialize counters for letters, spaces, numbers, and other characters
        int letter = 0;
        int space = 0;
        int num = 0;
        int other = 0;
        
        // Iterate through the character array to categorize characters
        for (int i = 0; i < x.length(); i++) {
            // Check if the character is a letter
            if (Character.isLetter(ch[i])) {
                letter++;
            }
            // Check if the character is a digit (number)
            else if (Character.isDigit(ch[i])) {
                num++;
            }
            // Check if the character is a space
            else if (Character.isSpaceChar(ch[i])) {
                space++;
            }
            // Character falls into the "other" category if none of the above conditions are met
            else {
                other++;
            }
        }
        
        // Display the original string
        System.out.println("The string is : Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33");
        
        // Display the counts of letters, spaces, numbers, and other characters
        System.out.println("letter: " + letter);
        System.out.println("space: " + space);
        System.out.println("number: " + num);
        System.out.println("other: " + other);
    }
} 
```
Explanation:

In the exercise above -

The string to be analyzed is stored in the 'test' variable.
The "count()" method takes a string 'x' as its parameter.
Inside the "count()" method, the "toCharArray()" method is used to convert the input string x into an array of characters 'ch'.
Four variables (letter, space, num, and other) are initialized to zero. These variables will be used to count the respective types of characters in the string.
A for loop iterates through each character in the 'ch' array.
Inside the loop, it checks the type of each character using various "Character" class methods like isLetter(), isDigit(), and isSpaceChar(). Depending on the type, it increments the corresponding counter variable (letter, num, space, or other).
Finally, it prints the original string and the counts of each character type.

Expected Output

The string is :  Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33
letter: 23                                               
space: 9                                                 
number: 10                                               
other: 6


### 39. Write a Java program to create and display a unique three-digit number using 1, 2, 3, 4. Also count how many three-digit numbers are there.
```java
import java.util.Scanner;

public class Exercise39 {
    public static void main(String[] args) {
        int amount = 0; // Initialize a counter for three-digit numbers
        
        // Iterate through three nested loops to generate all unique three-digit numbers
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    // Check if 'i,' 'j,' and 'k' are all different (not equal)
                    if (k != i && k != j && i != j) {
                        amount++; // Increment the counter
                        System.out.println(i + "" + j + "" + k); // Print the generated three-digit number
                    }
                }
            }
        }
        
        // Display the total number of generated three-digit numbers
        System.out.println("Total number of the three-digit-number is " + amount);
    }
}
```
Explanation:

In the exercise above -

First, the variable 'amount' is initialized to 0. This variable will be used to count the total number of three-digit numbers that meet the criteria.
The code uses three nested for loops to generate all possible combinations of three digits from 1 to 4.
The outermost loop iterates through the first digit (i) from 1 to 4.
The middle loop iterates through the second digit (j) from 1 to 4.
The innermost loop iterates through the third digit (k) from 1 to 4.
Within the innermost loop, there is a conditional check if(k != i && k != j && i != j). This condition ensures that 'i', 'j', and 'k' are all distinct digits, meaning they are not equal to each other. This avoids repetition in the generated numbers.
When a valid combination is found (i.e., three distinct digits), it increments the amount variable, prints the three-digit number in the format 'ijk', and moves on to the next combination.
Finally, all possible combinations are generated and counted, it prints the total number of three-digit numbers that meet the criteria.

Expected Output

123                                                      
124                                                      
...                                            
                                                   
431                                                      
432                                                      
Total number of the three-digit-number is 24


### 40. Write a Java program to list the available character sets in charset objects.
```java
import java.nio.charset.Charset;

public class Exercise40 {
    public static void main(String[] args) {
        System.out.println("List of available character sets: ");
        
        // Iterate through the available character sets and print their names
        for (String str : Charset.availableCharsets().keySet()) {
            System.out.println(str);
        }
    }
}
```
Explanation:

In the exercise above -

First, import the Charset class from the "java.nio.charset" package.
In the "main()" method, it prints the header "List of available character sets."
It uses a for-each loop to iterate through the keys (character set names) in the set of available character sets provided by Charset.availableCharsets().keySet().
Inside the loop, it prints each character set name on a separate line.
Finally, when you run the program, it will list and display the names of all available character sets (encodings) supported by your Java runtime environment.

Expected Output

List of available character sets:                                       
Big5                                                                    
Big5-HKSCS                                                              
CESU-8                                                                  
EUC-JP                                                                  
EUC-KR                                                                  
GB18030                                                                 
GB2312                                                                  
GBK                                                                     
                                                     
...                                            
                                                   
x-SJIS_0213                                                             
x-UTF-16LE-BOM                                                          
X-UTF-32BE-BOM                                                          
X-UTF-32LE-BOM                                                          
x-windows-50220                                                         
x-windows-50221                                                         
x-windows-874                                                           
x-windows-949                                                           
x-windows-950                                                           
x-windows-iso2022jp


### 41. Write a Java program to print the ASCII value of a given character.
```java
public class Exercise41 {
    public static void main(String[] args) {
        // Define an integer variable 'chr' and assign the ASCII value of 'Z' to it.
        int chr = 'Z';
        
        // Print the ASCII value of 'Z' to the console.
        System.out.println("The ASCII value of Z is: " + chr);
    }
}
```
Expected Output

The ASCII value of Z is :90


### 42. Write a Java program to input and display your password.
```java
import java.io.Console;

public class Example42 {
    public static void main(String[] args) {
        // Declare a Console variable 'cons'.
        Console cons;

        // Check if the system console is available.
        if ((cons = System.console()) != null) {
            // Declare a character array 'pass_ward' to store the password.
            char[] pass_ward = null;

            try {
                // Prompt the user to input their password.
                pass_ward = cons.readPassword("Input your Password:");

                // Display the password to the console.
                System.out.println("Your password was: " + new String(pass_ward));
            } finally {
                // Ensure that the password array is securely cleared.
                if (pass_ward != null) {
                    java.util.Arrays.fill(pass_ward, ' ');
                }
            }
        } else {
            // If the system console is not available, throw a runtime exception.
            throw new RuntimeException("Can't get the password... No console");
        }
    }
}
```
Expected Output

Input your Password:                                                    
Your password was: abc@123


### 43. Write a Java program to print the following string in a specific format (see output).
```java
public class Example43 {
    public static void main(String[] args) {
        // Display a pattern of a nursery rhyme.
        System.out.println("\nTwinkle, twinkle, little star, \n\tHow I wonder what you are! \n\t\tUp above the world so high, \n\t\tLike a diamond in the sky. \nTwinkle, twinkle, little star, \n\tHow I wonder what you are!\n\n");
    }
}
```
Sample Output

Twinkle, twinkle, little star,
	How I wonder what you are! 
		Up above the world so high,   		
		Like a diamond in the sky. 
Twinkle, twinkle, little star, 
	How I wonder what you are


### 44. Write a Java program that accepts an integer (n) and computes the value of n+nn+nnn.
```java
import java.util.Scanner;

public class Exercise44 {
    public static void main(String[] args) {
        int n;
        char s1, s2, s3;
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to input a number.
        System.out.print("Input number: ");
        n = in.nextInt();
        
        // Display the number in a specific pattern.
        System.out.printf("%d + %d%d  + %d%d%d\n", n, n, n, n, n, n);
    }
}
```
Sample Output:

Input number: 5                                                        
5 + 55  + 555


### 45. Write a Java program to find the size of a specified file.
```java
import java.util.Scanner;
import java.io.File;

public class Exercise45 {
    public static void main(String[] args) {
        // Display the file sizes in bytes for two files.
        System.out.println("/home/students/abc.txt  : " + new File("abc.txt").length() + " bytes");
        System.out.println("/home/students/test.txt : " + new File("test.txt").length() + " bytes");
    }
}
```
Sample Output:

/home/students/abc.txt  : 0 bytes                                      
/home/students/test.txt : 0 bytes 


### 46. Write a Java program to display system time.
```java
public class Exercise46 {
  
  public static void main(String[] args) {
         // Display the current date and time using System.currentTimeMillis()
         System.out.format("\nCurrent Date time: %tc%n\n", System.currentTimeMillis());
    }
}
```
Sample Output:

Current Date time: Fri Jun 16 14:17:40 IST 2017 


### 47. Write a Java program to display the current date and time in a specific format.
```java
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Exercise47 {

	public static void main(String args[]) {
		// Create a SimpleDateFormat with a specific date and time format
		SimpleDateFormat cdt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		
		// Set the time zone for the calendar to GMT
		cdt.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("GMT")));
		
		// Display the current date and time in the specified format
		System.out.println("\nNow: " + cdt.format(System.currentTimeMillis()));
	}
}
```
Sample Output:

Now: 2017/06/16 08:52:03.066 


### 48. Write a Java program to print odd numbers from 1 to 99. Prints one number per line.
```java
import java.util.*;

public class Exercise48 {
    public static void main(String[] args) {
        // Iterate through numbers from 1 to 99
        for (int i = 1; i < 100; i++) {
            // Check if the number is odd
            if (i % 2 != 0) {
                // Print the odd number
                System.out.println(i);
            }
        }
    }
}
```
Sample Output:

1                                                                      
3                                                                      
5                                                                      
7                                                                      
9                                                                      
11                                                                     
....                                                                     
                                                                    
91                                                                     
93                                                                     
95                                                                     
97                                                                     
99 


### 49. Write a Java program to accept a number and check whether the number is even or not. Prints 1 if the number is even or 0 if odd.
```java
import java.util.*;

public class Exercise49 {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to input a number
        System.out.print("Input a number: ");
        int n = in.nextInt();
        
        // Check if the number is even and print the result
        if (n % 2 == 0) {
            System.out.println(1); // If the number is even, print 1
        } else {
            System.out.println(0); // If the number is odd, print 0
        }
    }
}
```
Sample Output:

Input a number: 20                                                     
1


### 50. Write a Java program to print numbers between 1 and 100 divisible by 3, 5 and both.
```java
public class Exercise50 {
    public static void main(String args[]) {
        // Print numbers divided by 3
        System.out.println("\nDivided by 3: ");
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0)
                System.out.print(i + ", ");
        }

        // Print numbers divided by 5
        System.out.println("\n\nDivided by 5: ");
        for (int i = 1; i < 100; i++) {
            if (i % 5 == 0)
                System.out.print(i + ", ");
        }

        // Print numbers divided by both 3 and 5
        System.out.println("\n\nDivided by 3 & 5: ");
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.print(i + ", ");
        }
        System.out.println("\n");
    }
}
```
Sample Output:

Divided by 3:                                                          
3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57
, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99,              
                                                                       
Divided by 5:                                                          
5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 
95,                                                                    
                                                                       
Divided by 3 & 5:                                                      
15, 30, 45, 60, 75, 90,


### 51. Write a Java program to convert a string to an integer.
```java
import java.util.*;

public class Exercise51 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input a number (as a string)
        System.out.print("Input a number (string): ");

        // Read the input string and store it in str1
        String str1 = in.nextLine();

        // Parse the string as an integer
        int result = Integer.parseInt(str1);

        // Display the integer value
        System.out.printf("The integer value is: %d", result);

        // Print a new line for better formatting
        System.out.printf("\n");
    }
}
```
Sample Output:

Input a number(string): 25                                             
The integer value is: 25


### 52. Write a Java program to calculate the sum of two integers and return true if the sum is equal to a third integer.

```java
import java.util.*;

public class Exercise52 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to input the first number
        System.out.print("Input the first number: ");
        int x = in.nextInt();

        // Prompt the user to input the second number
        System.out.print("Input the second number: ");
        int y = in.nextInt();

        // Prompt the user to input the third number
        System.out.print("Input the third number: ");
        int z = in.nextInt();

        // Calculate the result using the sumoftwo function and display it
        System.out.print("The result is: " + sumoftwo(x, y, z));

        // Print a new line for better formatting
        System.out.print("\n");
    }
    
    // Function to check if the sum of two numbers equals the third number
    public static boolean sumoftwo(int p, int q, int r) {
        return ((p + q) == r || (q + r) == p || (r + p) == q);
    }
}
```

Sample Output:

Input the first number : 5                                             
Input the second number: 10                                            
Input the third number : 15                                            
The result is: true


### 53. Write a Java program that accepts three integers from the user. It returns true if the second number is higher than the first number and the third number is larger than the second number. If "abc" is true, the second number does not need to be larger than the first number.
```java
import java.util.*;

public class Exercise53 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to input the first number
        System.out.print("Input the first number: ");
        int x = in.nextInt();

        // Prompt the user to input the second number
        System.out.print("Input the second number: ");
        int y = in.nextInt();

        // Prompt the user to input the third number
        System.out.print("Input the third number: ");
        int z = in.nextInt();

        // Prompt the user to input a boolean value (true or false)
        System.out.print("Input a boolean value (true/false): ");
        boolean xyz = in.nextBoolean();

        // Calculate the result using the test function and display it
        System.out.print("The result is: " + test(x, y, z, xyz));

        // Print a new line for better formatting
        System.out.print("\n");
    }
    
    // Function to test conditions based on boolean input
    public static boolean test(int p, int q, int r, boolean xyz) {
        if (xyz)
            return (r > q);
        return (q > p && r > q);
    }
}
```
Sample Output:

Input the first number : 5                                             
Input the second number: 10                                            
Input the third number : 15                                            
The result is: true


### 54. Write a Java program that accepts three integers from the user and returns true if two or more of them (integers) have the same rightmost digit. The integers are non-negative.
```java
import java.util.*;

public class Exercise54 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input the first number
        System.out.print("Input the first number: ");
        int x = in.nextInt();

        // Prompt the user to input the second number
        System.out.print("Input the second number: ");
        int y = in.nextInt();

        // Prompt the user to input the third number
        System.out.print("Input the third number: ");
        int z = in.nextInt();

        // Prompt the user to input a boolean value (true or false)
        System.out.print("Input a boolean value (true/false): ");
        boolean xyz = in.nextBoolean();

        // Calculate the result using the test_last_digit function and display it
        System.out.print("The result is: " + test_last_digit(x, y, z, xyz));

        // Print a new line for better formatting
        System.out.print("\n");
    }

    // Function to test if any two numbers have the same last digit based on the boolean input
    public static boolean test_last_digit(int p, int q, int r, boolean xyz) {
        return (p % 10 == q % 10) || (p % 10 == r % 10) || (q % 10 == r % 10);
    }
}
```
Sample Output:

Input the first number : 5                                             
Input the second number: 10                                            
Input the third number : 15                                            
The result is: true


### 55. Write a Java program to convert seconds to hours, minutes and seconds.
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input the total seconds
        System.out.print("Input seconds: ");
        int seconds = in.nextInt();

        // Calculate the hours, minutes, and seconds
        int S = seconds % 60;  // Calculate the remaining seconds
        int H = seconds / 60;  // Convert total seconds to minutes
        int M = H % 60;         // Calculate the remaining minutes
        H = H / 60;            // Convert total minutes to hours

        // Display the time in the format HH:MM:SS
        System.out.print(H + ":" + M + ":" + S);

        // Print a new line for better formatting
        System.out.print("\n");
    }
}
```
Sample Output:

Input seconds: 86399                                                   
23:59:59


### 56. Write a Java program to find the number of values in a given range divisible by a given value.

Sample Data:
For example x = 5, y=20 and p =3, find the number of integers within the range x..y and that are divisible by p i.e. { i :x ≤ i ≤ y, i mod p = 0 }

Sample Solution:

Java Code:
```java
import java.util.*;

public class Exercise56 {
    public static void main(String[] args) {
        // Initialize variables x, y, and p
        int x = 5;
        int y = 20;
        int p = 3;

        // Call the result method and print the result
        System.out.println(result(x, y, p));
    }

    // Define a method to calculate the result based on x, y, and p
    public static int result(int x, int y, int p) {
        // Check if x is divisible by p
        if (x % p == 0) {
            // Calculate the result and return it
            return (y / p - x / p + 1);
        } else {
            // Calculate the result and return it
            return (y / p - x / p);
        }
    }
}
```
For example x = 5, y=20 and p =3, find the number of integers within the range x..y and that are divisible by p i.e. { i :x ≤ i ≤ y, i mod p = 0 }
Sample Output:

5


### 57. Write a Java program to accept an integer and count the factors of the number.
```java
import java.util.*;

public class Exercise57 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        System.out.print("Input an integer: ");
        
        // Read an integer from the user
        int x = in.nextInt();
        
        // Call the result method and print the result
        System.out.println(result(x));
    }

    // Define a method to calculate the number of divisors for a given integer
    public static int result(int num) {
        int ctr = 0;
        
        // Iterate from 1 to the square root of the input number
        for (int i = 1; i <= (int) Math.sqrt(num); i++) {
            // Check if 'i' is a divisor, and if it's not a perfect square
            if (num % i == 0 && i * i != num) {
                ctr += 2;  // Increase the count by 2
            } else if (i * i == num) {
                ctr++;  // If 'i' is a perfect square, increase the count by 1
            }
        }
        return ctr;  // Return the total count of divisors
    }
}
```
Sample Output:

Input an integer: 25                                                   
3


### 58. Write a Java program to capitalize the first letter of each word in a sentence.
```java
import java.util.*;

public class Exercise58 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Sentence: ");
        
        // Read a sentence from the user
        String line = in.nextLine();
        
        // Initialize an empty string to store the result in uppercase
        String upper_case_line = "";
        
        // Create a Scanner to process individual words in the sentence
        Scanner lineScan = new Scanner(line);
        
        // Iterate through the words in the sentence
        while (lineScan.hasNext()) {
            String word = lineScan.next();
            
            // Capitalize the first letter of each word and append it to the result
            upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        
        // Remove trailing space and print the result in uppercase
        System.out.println(upper_case_line.trim());
    }
}
```
Sample Output:

Input a Sentence: the quick brown fox jumps over the lazy dog.         
The Quick Brown Fox Jumps Over The Lazy Dog.


### 59. Write a Java program to convert a string into lowercase.
```java
import java.util.*;
public class Exercise59 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        System.out.print("Input a String: ");
        
        // Read a string from the user
        String line = in.nextLine();
        
        // Convert the string to lowercase
        line = line.toLowerCase();
        
        // Print the lowercase version of the input string
        System.out.println(line);
    }
}
```
Sample Output:

Input a String: THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.           
the quick brown fox jumps over the lazy dog.


### 60. Write a Java program to find the penultimate (next to the last) word in a sentence.
```java
import java.util.*;

public class Exercise60 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Sentence: ");
        
        // Read a sentence from the user
        String line = in.nextLine();
        
        // Split the sentence into words using one or more spaces as the delimiter
        String[] words = line.split("[ ]+");
        
        // Print the penultimate word from the array
        System.out.println("Penultimate word: " + words[words.length - 2]);
    }
}
```
Sample Output:

Input a String: The quick brown fox jumps over the lazy dog.
Penultimate word: lazy


### 61. Write a Java program to reverse a word.

```java
import java.util.*;

public class Exercise61 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        System.out.print("\nInput a word: ");
        
        // Read a word from the user
        String word = in.nextLine();
        
        // Trim any leading or trailing whitespaces
        word = word.trim();
        
        // Initialize an empty string for the reversed word
        String result = ""; 
        
        // Convert the word to a character array
        char[] ch = word.toCharArray();  
        
        // Reverse the word by iterating through the characters
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
        }
        
        // Print the reversed word
        System.out.println("Reverse word: " + result.trim()); 
    }
}
```
Sample Output:

Input a word: dsaf
Reverse word: fasd


### 62. Write a Java program that accepts three integer values and returns true if one is 20 or more less than the others' subtractions.
```java
import java.util.*;

public class Exercise62 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to input the first number
        System.out.print("Input the first number : ");
        int x = in.nextInt();  // Read and store the first number
        
        // Prompt the user to input the second number
        System.out.print("Input the second number: ");
        int y = in.nextInt();  // Read and store the second number
        
        // Prompt the user to input the third number
        System.out.print("Input the third number : ");
        int z = in.nextInt();  // Read and store the third number
        
        // Calculate and print the result of the condition
        // The condition checks if the absolute difference between the numbers is greater than or equal to 20
        System.out.println((Math.abs(x - y) >= 20 || Math.abs(y - z) >= 20 || Math.abs(z - x) >= 20));
    }
}
```
Sample Output:

Input the first number : 15                                            
Input the second number: 20                                            
Input the third number : 25                                            
false


### 63. Write a Java program that accepts two integer values from the user and returns the largest value. However if the two values are the same, return 0 and find the smallest value if the two values have the same remainder when divided by 6.

Write a Java program that accepts two integer values from the user and returns the largest value. However if the two values are the same, return 0 and find the smallest value if the two values have the same remainder when divided by 6.
Test Data:
Input the first number : 12
Input the second number: 13
Result: 13
Input the first number : 12
Input the second number: 12
Result: 0
Input the first number : 6
Input the second number: 18
Result: 6

Sample Solution:

Java Code:
```java
import java.util.*;

public class Exercise63 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input the first number
        System.out.print("Input the first number : ");
        int a = in.nextInt();  // Read and store the first number
        
        // Prompt the user to input the second number
        System.out.print("Input the second number: ");
        int b = in.nextInt();  // Read and store the second number

        // Call the result method with the two numbers and print the result
        System.out.println("Result: " + result(a, b));
    }

    // Define a method to calculate the result based on two input numbers
    public static int result(int x, int y) {
        // Check if the two numbers are equal
        if (x == y) {
            return 0;
        }
        
        // Check if the remainder when divided by 6 is the same for both numbers
        if (x % 6 == y % 6) {
            // If the remainder is the same, return the smaller number
            return (x < y) ? x : y;
        }
        
        // If the remainders are different, return the larger number
        return (x > y) ? x : y;
    }
} 
```
Sample Output:

Input the first number : 12                                            
Input the second number: 13                                            
Result: 13


### 64. Write a Java program that accepts two integer values between 25 and 75 and returns true if there is a common digit in both numbers.
```java
import java.util.*;

public class Exercise64 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input the first number
        System.out.print("Input the first number : ");
        int a = in.nextInt();  // Read and store the first number

        // Prompt the user to input the second number
        System.out.print("Input the second number: ");
        int b = in.nextInt();  // Read and store the second number

        // Call the common_digit method with the two numbers and print the result
        System.out.println("Result: " + common_digit(a, b));
    }

    // Define a method to check if there's a common digit between two numbers
    public static boolean common_digit(int p, int q) {
        // Check if p is less than 25 or q is greater than 75
        if (p < 25 || q > 75) {
            return false;
        }

        // Extract the last digit of each number
        int x = p % 10;
        int y = q % 10;

        // Remove the last digit from both numbers
        p /= 10;
        q /= 10;

        // Check if there's a common digit by comparing the remaining digits
        return (p == q || p == y || x == q || x == y);
    }
}
```
Sample Output:

Input the first number : 35                                            
Input the second number: 45                                            
Result: true


### 65. Write a Java program to calculate the modules of two numbers without using any inbuilt modulus operator.

Test data:
Input the first number : 5
Input the second number: 3
2
Input the first number : 19
Input the second number: 7
5

Sample Solution:

Java Code:
```java
import java.util.*;

public class Exercise65 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input the first number
        System.out.print("Input the first number : ");
        int a = in.nextInt();  // Read and store the first number

        // Prompt the user to input the second number
        System.out.print("Input the second number: ");
        int b = in.nextInt();  // Read and store the second number

        // Calculate the division result of a by b
        int divided = a / b;

        // Calculate the remainder of a divided by b
        int result = a - (divided * b);

        // Print the remainder
        System.out.println(result);
    }
} 
```
Sample Output:

Input the first number : 19                                            
Input the second number: 7                                             
5   


### 66. Write a Java program to compute the sum of the first 100 prime numbers.
```java
import java.util.*;

public class Exercise66 {
    public static void main(String[] args) {
        // Initialize variables for sum, counter, and the number 'n'
        int sum = 1;
        int ctr = 0;
        int n = 0;

        // Iterate while the counter is less than 100
        while (ctr < 100) {
            n++;

            // Check if the number is odd
            if (n % 2 != 0) {
                // If the number is prime, add it to the sum
                if (is_Prime(n)) {
                    sum += n;
                }
            }

            // Increment the counter
            ctr++;
        }

        // Print the sum of prime numbers up to 100
        System.out.println("\nSum of the prime numbers till 100: " + sum);
    }

    // Check if a number is prime
    public static boolean is_Prime(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```
Sample Output:

Sum of the first 100 prime numbers: 24133 


### 67. Write a Java program to insert a word in the middle of another string.
Insert "Tutorial" in the middle of "Python 3.0", so the result will be Python Tutorial 3.0.
```java
import java.lang.*;

public class Exercise67 {
    public static void main(String[] args) {
        // Define the main string and the word to insert
        String main_string = "Python 3.0";
        String word = "Tutorial";

        // Create a new string by concatenating substrings
        String result = main_string.substring(0, 7) + word + main_string.substring(6);

        // Print the resulting string
        System.out.println(result);
    }
}
```
Sample Output:

Python Tutorial 3.0


### 68. Write a Java program to create another string of 4 copies of the last 3 characters of the original string. The original string length must be 3 and above.
```java
import java.lang.*;

public class Exercise68 {
    public static void main(String[] args) {
        // Define the main string
        String main_string = "Python 3.0";

        // Extract the last three characters from the main string
        String last_three_chars = main_string.substring(main_string.length() - 3);

        // Repeat the last three characters four times and print the result
        System.out.println(last_three_chars + last_three_chars + last_three_chars + last_three_chars);
    }
}
```
Sample Output:

3.03.03.03.0 


### 69. Write a Java program to extract the first half of a even string.
```java
import java.lang.*;

public class Exercise69 {
    public static void main(String[] args) {
        // Define the main string
        String main_string = "Python";

        // Extract the substring from the beginning to the middle of the string
        String substring = main_string.substring(0, main_string.length() / 2);

        // Print the extracted substring
        System.out.println(substring);
    }
}
```
Test Data: Python
Sample Output:
Pyt


### 70. Write a Java program to create a string in the form of short_string + long_string + short_string from two strings. The strings must not have the same length.
```java
import java.lang.*;

public class Exercise70 {
    public static void main(String[] args) {
        // Define two strings
        String str1 = "Python";
        String str2 = "Tutorial";

        // Check the lengths of the strings
        if (str1.length() >= str2.length()) {
            // Concatenate the strings in the order: str2 + str1 + str2
            System.out.println(str2 + str1 + str2);
        } else {
            // Concatenate the strings in the order: str1 + str2 + str1
            System.out.println(str1 + str2 + str1);
        }
    }
}
```
Test Data: Str1 = Python
Str2 = Tutorial
Sample Output:

PythonTutorialPython


### 71. Write a Java program to create the concatenation of the two strings except removing the first character of each string. The length of the strings must be 1 and above.

```java
import java.lang.*;

public class Exercise71 {
    public static void main(String[] args) {
        // Define two strings
        String str1 = "Python";
        String str2 = "Tutorial";

        // Print the substrings of both strings, excluding the first character
        System.out.println(str1.substring(1) + str2.substring(1));
    }
}
```
Test Data: Str1 = Python
Str2 = Tutorial
Sample Output:

ythonutorial


### 72. Write a Java program to create a string taking the first three characters from a given string. If the string length is less than 3 use "#" as substitute characters.

Test Data: str1 = "Python"
str2 = " "

Sample Solution:

Java Code:

import java.lang.*;
```java
public class Exercise72 {
    public static void main(String[] args) {
        // Define an empty string
        String str1 = "";

        // Get the length of the string
        int len = str1.length();

        // Check the length of the string and take different actions based on its length
        if (len >= 3) {
            // If the string has three or more characters, print the first three characters
            System.out.println(str1.substring(0, 3));
        } else if (len == 1) {
            // If the string has only one character, add "##" to it and print
            System.out.println(str1.charAt(0) + "##");
        } else {
            // If the string is empty or has two characters, print "###"
            System.out.println("###");
        }
    }
}
```
Test Data: Str1 = " "
Sample Output:

###


### 73. Write a Java program to create a string taking the first and last characters from two given strings. If the length of each string is 0 use "#" for missing characters.
```java
import java.lang.*;

public class Exercise73 {
    public static void main(String[] args) {
        // Define two input strings
        String str1 = "Python";
        String str2 = "";

        // Get the length of the second string
        int length2 = str2.length();

        // Initialize a result string
        String result = "";

        // Check the length of the first string and append the first character (if available) or '#'
        result += (str1.length() >= 1) ? str1.charAt(0) : '#';

        // Check the length of the second string and append the last character (if available) or '#'
        result += (length2 >= 1) ? str2.charAt(length2 - 1) : '#';

        // Print the resulting string
        System.out.println(result);
    }
}
```
Test Data: str1 = "Python"
str2 = " "
Sample Output:

P#


### 74. Write a Java program to test if 10 appears as the first or last element of an array of integers. The array length must be broader than or equal to 2.
```java
import java.lang.*;

public class Exercise74 {
    public static void main(String[] args) {
        // Define an integer array
        int[] num_array = {10, -20, 0, 30, 40, 60, 10};
        
        // Check if the first or last element of the array is equal to 10
        boolean result = (num_array[0] == 10 || num_array[num_array.length - 1] == 10);

        // Print the result
        System.out.println(result);
    }
}
```
Sample Output:
Test Data: array = 10, -20, 0, 30, 40, 60, 10

true


### 75. Write a Java program to test if the first and last elements of an array of integers are the same. The array length must be broader than or equal to 2.
```java
import java.lang.*;

public class Exercise75 {
    public static void main(String[] args) {
        // Define an integer array
        int[] num_array = {50, -20, 0, 30, 40, 60, 10};
        
        // Check if the array has at least 2 elements and if the first and last elements are equal
        boolean result = (num_array.length >= 2 && num_array[0] == num_array[num_array.length - 1]);

        // Print the result
        System.out.println(result);
    }
}
```
Test Data: array = 50, -20, 0, 30, 40, 60, 10
Sample Output:

false


### 76. Write a Java program to test if the first and last element of two integer arrays are the same. The array length must be greater than or equal to 2.
```java
public class Main {
    public static void main(String[] args) {
        // Define two integer arrays (num_array1 and num_array2)
        
        // Example 1: Arrays with different first and last elements
        int[] num_array1 = {50, -20, 0, 30, 40, 60, 12};
        int[] num_array2 = {45, 20, 10, 20, 30, 50, 11};
        
        // Example 2: Arrays with the same first and last elements
        // int[] num_array1 = {50, -20, 0, 30, 40, 60, 50};
        // int[] num_array2 = {45, 20, 10, 20, 30, 50, 45};
        
        // Example 3: Arrays with lengths less than 2
        // int[] num_array1 = {50};
        // int[] num_array2 = {45};
        
        if (num_array1.length >= 2 && num_array2.length >= 2) {
            // Check if both arrays have lengths of at least 2 and if their first or last elements are equal
            System.out.println(num_array1[0] == num_array2[0] || num_array1[num_array1.length - 1] == num_array2[num_array2.length - 1]);
        } else {
            System.out.println("Array lengths less than 2.");
        }
    }
}
```
Test Data: array1 = 50, -20, 0, 30, 40, 60, 12
array2 = 45, 20, 10, 20, 30, 50, 11
Sample Output:

false


### 77. Write a Java program to create an array of length 2 from two integer arrays with three elements. The newly created array will contain the first and last elements from the two arrays.

```java
import java.util.Arrays;

public class Exercise77 {
    public static void main(String[] args) {
        // Define two integer arrays (array1 and array2)
        int[] array1 = {50, -20, 0};
        int[] array2 = {5, -50, 10};
        
        // Print the elements of array1
        System.out.println("Array1: " + Arrays.toString(array1));
        
        // Print the elements of array2
        System.out.println("Array2: " + Arrays.toString(array2));
        
        // Create a new array, array_new, with elements from array1 and array2
        int[] array_new = {array1[0], array2[2]};	
        
        // Print the elements of the new array, array_new
        System.out.println("New Array: " + Arrays.toString(array_new));
    }
}
```
Test Data: array1 = 50, -20, 0
array2 = 5, -50, 10
Sample Output:

Array1: [50, -20, 0]                                                   
Array2: [5, -50, 10]                                                   
New Array: [50, 10]


### 78. Write a Java program to test that a given array of integers of length 2 contains a 4 or a 7.
```java
import java.util.Arrays;

public class Exercise78 {
    public static void main(String[] args) {
        // Define an integer array, array_nums
        int[] array_nums = {5, 7};
        
        // Print the elements of the original array
        System.out.println("Original Array: " + Arrays.toString(array_nums)); 
        
        // Check if the first element of the array is 4 or 7 and print the result
        if (array_nums[0] == 4 || array_nums[0] == 7) {
            System.out.println("True");
        } else {
            // If the first element is not 4 or 7, check the second element and print the result
            System.out.println(array_nums[1] == 4 || array_nums[1] == 7);
        }
    }
}
```
Sample Output:

Original Array: [5, 7]                                                 
true 


### 79. Write a Java program to rotate an array (length 3) of integers in the left direction.

Write a Java program to rotate an array (length 3) of integers in the left direction.
Test Data: {20, 30, 40}
Expected output: {30, 40, 20}

Sample Solution:

Java Code:
```java
import java.util.Arrays;

public class Exercise79 {
    public static void main(String[] args) {
        // Define an integer array, array_nums
        int[] array_nums = {20, 30, 40};
        
        // Print the elements of the original array
        System.out.println("Original Array: " + Arrays.toString(array_nums)); 
        
        // Create a new array by rotating the elements of the original array
        int[] new_array_nums = {array_nums[1], array_nums[2], array_nums[0]};
        
        // Print the elements of the rotated array
        System.out.println("Rotated Array: " + Arrays.toString(new_array_nums)); 
    }
}
```
Sample Output:

Original Array: [20, 30, 40]                                           
Rotated Array: [30, 40, 20]


### 80. Write a Java program to get the largest value between the first and last elements of an array (length 3) of integers.
```java
import java.util.Arrays;

public class Exercise80 {
    public static void main(String[] args) {
        // Define an integer array, array_nums
        int[] array_nums = {20, 30, 40};
        
        // Print the elements of the original array
        System.out.println("Original Array: " + Arrays.toString(array_nums)); 
        
        // Initialize a variable, max_val, with the first element of the array
        int max_val = array_nums[0];
        
        // Check if the last element of the array is greater than max_val and update max_val if necessary
        if (array_nums[2] >= max_val)
            max_val = array_nums[2];
        
        // Print the larger value between the first and last elements of the array
        System.out.println("Larger value between first and last element: " + max_val); 
    }
}
```
Sample Output:

Original Array: [20, 30, 40]                                           
Larger value between first and last element: 40 


### 81. Write a Java program to swap the first and last elements of an array (length must be at least 1) and create another array.
```java
import java.util.Arrays;

public class Exercise81 {
    public static void main(String[] args) {
        // Define an integer array, array_nums
        int[] array_nums = {20, 30, 40};
        
        // Print the elements of the original array
        System.out.println("Original Array: " + Arrays.toString(array_nums)); 
        
        // Store the value of the first element in the variable x
        int x = array_nums[0];
        
        // Swap the first and last elements of the array
        array_nums[0] = array_nums[array_nums.length - 1];
        array_nums[array_nums.length - 1] = x;
        
        // Print the new array after swapping the first and last elements
        System.out.println("New array after swapping the first and last elements: " + Arrays.toString(array_nums));  
    }
}
```
Sample Output:

Original Array: [20, 30, 40]                                           
New array after swaping the first and last elements: [40, 30, 20] 


### 82. Write a Java program to find the largest element between the first, last, and middle values in an array of integers (even length).
```java
import java.util.Arrays;

public class Exercise82 {
    public static void main(String[] args) {
        // Define an integer array, array_nums
        int[] array_nums = {20, 30, 40, 50, 67};
        
        // Print the elements of the original array
        System.out.println("Original Array: " + Arrays.toString(array_nums)); 
        
        // Initialize a variable max_val with the value of the first element
        int max_val = array_nums[0];
        
        // Check if the last element is greater than max_val
        if (max_val <= array_nums[array_nums.length - 1])
            max_val = array_nums[array_nums.length - 1];
        
        // Check if the middle element is greater than max_val
        if (max_val <= array_nums[array_nums.length / 2])
            max_val = array_nums[array_nums.length / 2];
        
        // Print the largest element among the first, last, and middle values
        System.out.println("Largest element between first, last, and middle values: " + max_val);  
    }
}
```
Sample Output:

Original Array: [20, 30, 40, 50, 67]                                   
Largest element between first, last, and middle values: 67 


### 83. Write a Java program to multiply the corresponding elements of two integer arrays.
```java
import java.util.*;

public class Exercise83 {
    public static void main(String[] args) {	
        // Initialize a string to store the result
        String result = "";
        
        // Define two integer arrays
        int[] left_array = {1, 3, -5, 4};
        int[] right_array = {1, 4, -5, -2};
        
        // Print the elements of Array1
        System.out.println("\nArray1: " + Arrays.toString(left_array));  
        
        // Print the elements of Array2
        System.out.println("\nArray2: " + Arrays.toString(right_array)); 
        
        // Multiply corresponding elements from both arrays and build the result string
        for (int i = 0; i < left_array.length; i++) {
            int num1 = left_array[i];
            int num2 = right_array[i];
            result += Integer.toString(num1 * num2) + " "; 
        }
        
        // Print the result string
        System.out.println("\nResult: " + result);     
    }
}
```
Sample Output:

Array1: [1, 3, -5, 4]                                                  
                                                                       
Array2: [1, 4, -5, -2]                                                 
                                                                       
Result: 1 12 25 -8


### 84. Write a Java program to take the last three characters from a given string. It will add the three characters at both the front and back of the string. String length must be greater than three and more.

Write a Java program to take the last three characters from a given string. It will add the three characters at both the front and back of the string. String length must be greater than three and more.
Test data: " Python" will be "honPythonhon"

Pictorial Presentation:

Java Basic Exercises: Take the last three characters from a given string and add these characters at front and back of the string 
Sample Solution:

Java Code:
```java
import java.util.*;
import java.io.*;

public class Exercise84 {
    public static void main(String[] args) {
        // Initialize a string
        String string1 = "Python";
        
        // Define a subpart length
        int slength = 3;
        
        // Check if the subpart length is greater than the string length
        if (slength > string1.length()) {
            slength = string1.length(); // Limit it to the string length
        }

        // Get the subpart of the string from the last 3 characters
        String subpart = string1.substring(string1.length() - 3);
        
        // Print the result, which is the subpart followed by the original string and the subpart again
        System.out.println(subpart + string1 + subpart);
    }
}
```
Test data: "Python" will be "honPythonhon"
Sample Output:

honPythonhon


### 85. Write a Java program to check if a string starts with a specified word.

Sample Data: string1 = "Hello how are you?"

Pictorial Presentation:

Java Basic Exercises: Check if a string starts with a specified word 
Sample Solution:

Java Code:
```java
import java.util.*;
import java.io.*;

public class Exercise85 {
    public static void main(String[] args) {
        // Initialize a string
        String string1 = "Hello how are you?";
        
        // Check if the string starts with "Hello"
        boolean startsWithHello = string1.startsWith("Hello");
        
        // Print the result indicating whether the string starts with "Hello"
        System.out.println(startsWithHello);
    }
}
```
Sample Data: string1 = "Hello how are you?"
Sample Output:

true


### 86. Write a Java program starting with an integer n, divide it by 2 if it is even, or multiply it by 3 and add 1 if it is odd. Repeat the process until n = 1.

```java
Write a Java program starting with an integer n, divide it by 2 if it is even, or multiply it by 3 and add 1 if it is odd. Repeat the process until n = 1.

Sample Solution:

Java Code:

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Prompt the user to input the value of n
        System.out.println("Input the value of n: ");
        
        // Create a Scanner object to read user input
        Scanner in = new Scanner(System.in);
        
        // Read an integer from the user
        int n = in.nextInt();
        
        // Continue looping until n becomes 1
        while (n != 1) {
            // Check if n is even
            if (n % 2 == 0) {
                n = n / 2; // If even, divide n by 2
            } else {
                n = (3 * n + 1) / 2; // If odd, perform a calculation
            }
        }
        
        // Print the final value of n
        System.out.println("\nValue of n = " + n);
        
        // Close the Scanner
        in.close();
    }
}
```

### 87. Write a Java program that then reads an integer and calculates the sum of its digits and writes the number of each digit of the sum in English.
```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create a BufferedReader to read input from the user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int sum = 0;
            // Read a line of text from the user
            String str = br.readLine();
            char[] numStr = str.toCharArray();

            // Calculate the sum of the digits in the input number
            for (int i = 0; i < numStr.length; i++) {
                sum += numStr[i] - '0';
            }

            // Print the original number and call the print_number function
            System.out.println("Original Number: " + str);
            print_number(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print_number(int n) {
        int x;
        int y;
        int z;
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        // Print the sum of the digits of the number
        System.out.println("Sum of the digits of the said number: " + n);

        if (n < 10) {
            // If the number is less than 10, print the corresponding word
            System.out.println(number[n]);
        } else if (n < 100) {
            // If the number is less than 100, split it into tens and ones
            x = n / 10;
            y = n - x * 10;
            System.out.println("In English: " + number[x] + " " + number[y]);
        } else {
            // If the number is three digits, split it into hundreds, tens, and ones
            x = n / 100;
            y = (n - x * 100) / 10;
            z = n - x * 100 - y * 10;
            System.out.println("In English: " + number[x] + " " + number[y] + " " + number[z]);
        }
    }
}
```

### 88. Write a Java program to get the current system environment and system properties.
```java
import java.lang.*;

public class Exercise88 {
    public static void main(String[] args) {
        // Print a message indicating the display of the current system environment
        System.out.println("\nCurrent system environment:");

        // Retrieve and print the system environment variables using System.getenv()
        System.out.println(System.getenv());

        // Print a message indicating the display of the current system properties
        System.out.println("\n\nCurrent system properties:");

        // Retrieve and print the system properties using System.getProperties()
        System.out.println(System.getProperties());
    }
}
```

### 89. Write a Java program to check whether a security manager has already been established for the current application or not.

```java
import java.lang.*;

public class Exercise89 {
    public static void main(String[] args) {
        // Print a message indicating the display of the system security interface
        System.out.println("System security interface:");

        // Retrieve and print the system security manager using System.getSecurityManager()
        System.out.println(System.getSecurityManager());
    }
}
```

### 90. Write a Java program to get the value of environment variables PATH, TEMP, USERNAME.

```java
import java.lang.*;

public class Exercise90 {
    public static void main(String[] args) {
        // Display the value of the specified environment variable "PATH"
        System.out.println("\nEnvironment variable PATH: ");
        System.out.println(System.getenv("PATH"));

        // Display the value of the specified environment variable "TEMP"
        System.out.println("\nEnvironment variable TEMP: ");
        System.out.println(System.getenv("TEMP"));

        // Display the value of the specified environment variable "USERNAME"
        System.out.println("\nEnvironment variable USERNAME: ");
        System.out.println(System.getenv("USERNAME"));
    }
}
```
### 91. Write a Java program to measure how long code executes in nanoseconds.
```java
import java.lang.*;

public class Exercise91 {
    public static void main(String[] args) {    
        long startTime = System.nanoTime(); 
        
        // Sample program: Display the first 10 natural numbers.
        int i;
        System.out.println("The first 10 natural numbers are:\n");
        for (i = 1; i <= 10; i++) {      
            System.out.println(i);
        }
        
        // Calculate the elapsed time in nanoseconds.
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Estimated time (in nanoseconds) to get the first 10 natural numbers: " + estimatedTime);
    }
}
```

### 92. Write a Java program to count the number of even and odd elements in a given array of integers.
```java
import java.util.*;

public class Exercise92 {
    public static void main(String[] args) {
        // Initialize an array of integers
        int[] nums = {5, 7, 2, 4, 9};
        
        // Initialize counters for even and odd numbers
        int ctr_even = 0, ctr_odd = 0;
        
        // Display the original array
        System.out.println("Original Array: " + Arrays.toString(nums));

        // Iterate through the array to count even and odd numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // Increment the counter for even numbers
                ctr_even++;
            } else {
                // Increment the counter for odd numbers
                ctr_odd++;
            }
        }
        
        // Print the counts of even and odd elements in the array
        System.out.printf("\nNumber of even elements in the array: %d", ctr_even);
        System.out.printf("\nNumber of odd elements in the array: %d", ctr_odd);
        System.out.printf("\n");
    }
}
```

### 93. Write a Java program to test if an array of integers contains an element 10 next to 10 or an element 20 next to 20, but not both.
```java
import java.util.*;
public class Exercise93 {
    public static void main(String[] args) {
        // Define an array of integers
        int[] nums = {10, 10, 2, 4, 20, 20};
        
        // Initialize counters for even and odd numbers
        int ctr_even = 0, ctr_odd = 0;
        
        // Display the original array
        System.out.println("Original Array: " + Arrays.toString(nums));

        // Initialize boolean variables to check for specific patterns
        boolean found1010 = false;
        boolean found2020 = false;
        
        // Iterate through the array to find patterns (e.g., 1010 and 2020)
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 10 && nums[i + 1] == 10) {
                found1010 = true;
            }

            if (nums[i] == 20 && nums[i + 1] == 20) {
                found2020 = true;
            }
        }

        // Check if the patterns 1010 and 2020 were found and print the result
        System.out.printf(String.valueOf(found1010 != found2020));
        System.out.printf("\n");
    }
}
```

### 94. Write a Java program to rearrange all the elements of a given array of integers so that all the odd numbers come before all the even numbers.

```java
import java.util.*;

public class Exercise94 {
    public static void main(String[] args) {
        // Define an array of integers
        int[] array_nums = {1, 7, 8, 5, 7, 13, 0, 2, 4, 9};
        
        // Initialize an index variable to track even numbers
        int i = 0;

        // Display the original array
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Find the first odd number's index (i)
        while (i < array_nums.length && array_nums[i] % 2 == 0)
            i++;
        
        // Rearrange the array such that odd numbers come after even numbers
        for (int j = i + 1; j < array_nums.length; j++) {
            if (array_nums[j] % 2 != 0) {
                // Swap even and odd numbers
                int temp = array_nums[i];
                array_nums[i] = array_nums[j];
                array_nums[j] = temp;
                i++;
            }
        }

        // Display the modified array
        System.out.println("New Array: " + Arrays.toString(array_nums));
    }
}
```
### 95. Write a Java program to create an array (length # 0) of string values. The elements will contain "0", "1", "2" … through ... n-1.

```java
import java.util.*;

public class Exercise95 {
    public static void main(String[] args) {
        // Define the number of elements in the array
        int n = 5;
        
        // Create an array of strings with n elements
        String[] arr_string = new String[n];

        // Initialize the array with string representations of numbers
        for (int i = 0; i < n; i++) {
            arr_string[i] = String.valueOf(i);
        }

        // Display the new array
        System.out.println("New Array: " + Arrays.toString(arr_string));
    }
}
```
### 96. Write a Java program to check if there is a 10 in an array of integers with a 20 somewhere later on.

```java
import java.util.*;

public class Exercise96 {
    public static void main(String[] args) {
        int[] array_nums = {10, 70, 80, 50, 20, 13, 50};
        boolean testd = false; // Initialize a boolean variable for testing
        int result = 0; // Initialize a result variable to track the outcome
        int x = 10; // Define the first number to search for
        int y = 20; // Define the second number to search for

        // Iterate through the array
        for (int i = 0; i < array_nums.length; i++) {
            if (array_nums[i] == x)
                testd = true; // Set the boolean flag when x is found in the array

            // Check if both x and y are found in the array with specific conditions
            if (testd && array_nums[i] == y) {
                System.out.printf(String.valueOf(true)); // Print true when both x and y are found
                result = 1; // Set the result to 1
            }
        }

        // If result is still 0, it means y did not follow x in the array
        if (result == 0) {
            System.out.printf(String.valueOf(false)); // Print false
        }
        System.out.printf("\n"); // Add a newline character for formatting
    }
}
```

### 97. Write a Java program to check if an array of integers contains a specified number next to each other or two same numbers separated by one element.
```java
import java.util.*;

public class Exercise97 {
    public static void main(String[] args) {
        int[] array_nums = {10, 20, 10, 50, 20, 13, 50};
        //int[] array_nums = {10, 10, 50, 50, 20, 13, 50};
        boolean testd = false; // Initialize a boolean variable for testing
        int result = 0; // Initialize a result variable to track the outcome
        int x = 10; // Define the number to search for

        // Iterate through the array, considering pairs of adjacent elements
        for (int i = 0; i < array_nums.length - 1; i++) {
            if (array_nums[i] == x && array_nums[i + 1] == x) {
                System.out.printf(String.valueOf(true)); // Print true when consecutive x elements are found
                result = 1; // Set the result to 1
            }

            // Check if the element x is followed by another x with one element in between
            if (i <= array_nums.length - 3 && array_nums[i] == x && array_nums[i + 2] == x) {
                System.out.printf(String.valueOf(true)); // Print true when x elements are found with one element in between
                result = 1; // Set the result to 1
            }
        }

        // If result is still 0, it means the specific pattern was not found
        if (result == 0) {
            System.out.printf(String.valueOf(false)); // Print false
        }
        System.out.printf("\n"); // Add a newline character for formatting
    }
}
```

### 98. Write a Java program to check if the value 20 appears three times and no 20's are next to each other in the array of integers.

```java
import java.util.*;
public class Exercise98 {
    public static void main(String[] args) {
        int[] array_nums = {10, 20, 10, 20, 40, 13, 20};
        int count = 0; // Initialize a count variable to keep track of the number of occurrences of 20
        int result = 0; // Initialize a result variable to track the outcome

        // Check if the array has at least one element and if the first element is 20
        if (array_nums.length >= 1 && array_nums[0] == 20) {
            count++; // Increment the count if the first element is 20
        }

        // Iterate through the array, starting from the second element (index 1)
        for (int i = 1; i < array_nums.length; i++) {
            // Check if the previous element and the current element are both 20
            if (array_nums[i - 1] == 20 && array_nums[i] == 20) {
                System.out.printf(String.valueOf(false)); // Print false when consecutive 20 elements are found
                result = 1; // Set the result to 1
            }

            // Check if the current element is 20 and increment the count
            if (array_nums[i] == 20) {
                count++;
            }
        }

        // If result is still 0, it means the specific pattern was not found
        if (result == 0) {
            System.out.printf(String.valueOf(count == 3)); // Print true if count is equal to 3
        }
        System.out.printf("\n"); // Add a newline character for formatting
    }
}
```
### 99. Write a Java program that checks if a specified number appears in every pair of adjacent integers of a given array of integers.
```java
import java.util.*;

public class Exercise99 {
    public static void main(String[] args) {
        int[] array_nums = {10, 20, 10, 20, 40, 20, 50};
        int result = 0; // Initialize a result variable

        int x = 20; // The value to check for

        // Iterate through the array, stopping at the second-to-last element
        for (int i = 0; i < array_nums.length - 1; i++) {
            // Check if the current element and the next element are not equal to the value 'x'
            if (array_nums[i] != x && array_nums[i + 1] != x) {
                result = 1; // If the condition is met, set the result to 1
            }
        }

        // If result is still 0, it means no adjacent pairs without 'x' were found
        if (result == 0) {
            System.out.printf(String.valueOf(true)); // Print true
        } else {
            System.out.printf(String.valueOf(false)); // Print false
        }
    }
}
```

### 100. Write a Java program to count the elements that differ by 1 or less between two given arrays of integers with the same length.

```java
import java.util.*;

public class Exercise100 {
    public static void main(String[] args) {
        int[] array_nums1 = {10, 11, 10, 20, 43, 20, 50};
        int[] array_nums2 = {10, 13, 11, 20, 44, 30, 50};
        System.out.println("Array1: "+Arrays.toString(array_nums1)); 
        System.out.println("Array2: "+Arrays.toString(array_nums2)); 
        
        int ctr = 0; // Initialize a counter to keep track of the number of elements

        // Iterate through the arrays to compare elements at the same index
        for (int i = 0; i < array_nums1.length; i++) {
            // Check if the absolute difference between elements is less than or equal to 1
            // and the elements are not equal
            if (Math.abs(array_nums1[i] - array_nums2[i]) <= 1 && array_nums1[i] != array_nums2[i]) {
                ctr++; // If the condition is met, increment the counter
            }
        }
        
        System.out.printf("Number of elements: "+ctr); // Print the number of elements meeting the condition
        System.out.printf("\n");	 
    }
}
```

### 101. Write a Java program to determine whether the number 10 in a given array of integers exceeds 20.

```java
import java.util.*;

public class Exercise101 {
    public static void main(String[] args) {
        int[] array_nums = {10, 11, 10, 30, 45, 20, 33, 53};
        int result = 0;
        System.out.println("Original Array: "+Arrays.toString(array_nums));

        int ctr1 = 0; // Initialize a counter to count occurrences of value 10
        int ctr2 = 0; // Initialize a counter to count occurrences of value 20

        for(int i = 0; i < array_nums.length; i++) {
            if(array_nums[i] == 10)
                ctr1++; // Increment ctr1 when the element is equal to 10

            if(array_nums[i] == 20)
                ctr2++; // Increment ctr2 when the element is equal to 20
        }

        System.out.printf(String.valueOf(ctr1 > ctr2)); // Check if the count of 10 is greater than the count of 20
        System.out.printf("\n");
    }
}
```
### 102. Write a Java program to check if a specified array of integers contains 10 or 30.

```java
import java.util.*;

public class Exercise102 {
    public static void main(String[] args) {
        int[] array_nums = {11, 11, 13, 31, 45, 20, 33, 53};
        int result = 1; 
        System.out.println("Original Array: "+Arrays.toString(array_nums));

        // Iterate through the array
        for(int i = 0; i < array_nums.length; i++) {
            if(array_nums[i] == 10 || array_nums[i] == 30) {
                // If the element is equal to 10 or 30, set the result to 0
                result = 0;
            }
        }

        if (result == 1)
            System.out.printf(String.valueOf(false)); // If the result is 1, print false
        else
            System.out.printf(String.valueOf(true)); // If the result is not 1, print true
    }
}
```
### 103. Write a Java program to create an array from a given array of integers. The newly created array will contain elements from the given array after the last element value is 10.
```java
import java.util.*;

public class Exercise103 {
    public static void main(String[] args) {
        int[] array_nums = {11, 10, 13, 10, 45, 20, 33, 53};
        int result = 0; 
        System.out.println("Original Array: "+Arrays.toString(array_nums)); 

        int l = array_nums.length - 1;
        int[] new_array;

        // Find the last occurrence of 10 in the array
        while(array_nums[l] != 10)
            l--;

        // Create a new array with elements after the last 10
        new_array = new int[array_nums.length - 1 - l];
        for(int i = l + 1; i < array_nums.length; i++)
            new_array[i - l - 1] = array_nums[i];

        System.out.println("New Array: "+Arrays.toString(new_array)); 
    }
}
```

### 104. Write a Java program to create an array from a given array of integers. The newly created array will contain the elements from the given array before the last element value of 10.

```java
import java.util.*;
public class Exercise104 {
    public static void main(String[] args) {
        int[] array_nums = {11, 15, 13, 10, 45, 20, 33, 53};
        int result = 0; 
        System.out.println("Original Array: "+Arrays.toString(array_nums)); 
        
        int l = 0;
        int[] new_array;

        // Find the first occurrence of 10 in the array
        while(array_nums[l] != 10)
            l++;

        // Create a new array with elements before the first occurrence of 10
        new_array = new int[l];
        for(int i = 0; i < l; i++)
            new_array[i] = array_nums[i];

        System.out.println("New Array: "+Arrays.toString(new_array)); 
    }
}
```
### 105. Write a Java program to check if a group of numbers (l) at the start and end of a given array are the same.
```java
import java.util.*;

public class Exercise105 {
    public static void main(String[] args) {
        int[] array_nums = {11, 15, 13, 10, 45, 20, 11, 15};
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        int result = 0;
        int l = 2;
        int start = 0;
        int end = array_nums.length - l;
        
        // Check if the elements at corresponding positions within the range [start, end] are equal.
        for (; l > 0; l--) {
            if (array_nums[start] != array_nums[end]) {
                result = 1;
            } else {
                start++;
                end++;
            }
        }

        if (result == 1) {
            System.out.printf(String.valueOf(false));
        } else {
            System.out.printf(String.valueOf(true));
        }

        System.out.printf("\n");
    }
}
```

### 106. Write a Java program to create an array left shifted from a given array of integers.

```java
import java.util.*;

public class Exercise106 {
    public static void main(String[] args) {
        int[] array_nums = {11, 15, 13, 10, 45, 20};
        System.out.println("Original Array: "+Arrays.toString(array_nums)); 
        
        if (array_nums.length > 1) {
            int first = array_nums[0];

            // Shift elements to the left by one position
            for (int i = 1; i < array_nums.length; i++)
                array_nums[i - 1] = array_nums[i];

            // Move the first element to the end of the array
            array_nums[array_nums.length - 1] = first;

            System.out.println("New Array: "+Arrays.toString(array_nums)); 
        }
    }
}
```
### 107. Write a Java program to check if an array of integers contains three increasing adjacent numbers.
```java
import java.util.*;

public class Exercise107 {
    public static void main(String[] args) {
        // Initialize an integer array with some values
        int[] array_nums = {11, 12, 13, 14, 45, 20};

        // Print the original array
        System.out.println("Original Array: " + Arrays.toString(array_nums));

        // Initialize a result variable to 1
        int result = 1;

        // Iterate through the array to check for consecutive integers
        for (int i = 0; i <= array_nums.length - 3; i++) {
            // Check if the current number, the next, and the one after that are consecutive
            if (array_nums[i] + 1 == array_nums[i + 1] && array_nums[i + 1] + 1 == array_nums[i + 2]) {
                // If they are consecutive, set the result to 0
                result = 0;
            }
        }

        // Check the result and print either true or false
        if (result == 1) {
            System.out.printf(String.valueOf(false));
        } else {
            System.out.printf(String.valueOf(true));
        }

        // Print a newline character for formatting
        System.out.printf("\n");
    }
}
```

### 108. Write a Java program to add all the digits of a given positive integer until the result has a single digit.

```java
import java.util.Scanner;

public class Example108 {
    public static void main(String[] arg) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input a positive integer
        System.out.print("Input a positive integer: ");
        
        // Read the user's input as an integer
        int n = in.nextInt(); 

        if (n > 0) {
            // Check if n is a positive integer
            System.out.print("The single digit number is: " + (n == 0 ? 0 : (n % 9 == 0 ? 9 : n % 9)));
        }
        
        // Close the input scanner
        in.close();
        System.out.println("\n");  
    }
}
```
### 109. Write a Java program to form a staircase shape of n coins where every k-th row must have exactly k coins.
```java
Example 1:
n = 3
The coins can form the following rows:
$
$ $
We will return 2 rows.
Example 2:
n = 4
The coins can form the following rows:
$
$ $
$
We will return 2 rows as the 3rd row is incomplete.
Example 3:
n = 5
The coins can form the following rows:
$
$ $
$ $
We will return 2 rows as the 3rd row is incomplete.

Sample Solution:

Java Code:

import java.util.Scanner;

public class Example109 {
    public static void main(String[] arg) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to input a positive integer
        System.out.print("Input a positive integer: ");
        
        // Read the user's input as an integer
        int n = in.nextInt(); 

        if (n > 0) {
            // Check if n is a positive integer
            double sqrtResult = Math.sqrt(8 * (long) n + 1);  // Calculate the square root
            int numRows = (int) ((sqrtResult - 1) / 2);      // Calculate the number of rows
            System.out.println("Number of rows: " + numRows);
        }
        
        // Close the input scanner
        in.close();
    }	
}
```

### 110. Write a Java program to check whether the given integer is a power of 4 or not.

Pictorial Presentation:

Java Basic Exercises: Check whether a given integer is a power of 4 or not
Sample Solution:

Java Code:
```java
import java.util.Scanner;

public class Example110 {
    public static void main(String[] arg) {
        int test = 0; // Initialize a variable 'test' to 0
        Scanner in = new Scanner(System.in); // Create a Scanner object for user input

        System.out.print("Input a positive integer: "); // Prompt the user to input a positive integer
        
        int n = in.nextInt(); // Read the user's input as an integer 

        if (n < 1) {
            System.out.print(Boolean.toString(false)); // If n is less than 1, print "false" and set 'test' to 1
            test = 1;
        }

        if ((n & (n - 1)) != 0) {
            System.out.print(Boolean.toString(false)); // If n is not a power of 2, print "false" and set 'test' to 1
            test = 1;
        }

        if (test == 0) {
            System.out.print(Boolean.toString((n & 0x55555555) != 0)); // If 'test' is 0, check if n has odd bits set and print the result
        }

        System.out.print("\n"); // Print a new line
    }	
}
```
Given num = 64, return true. Given num = 6, return false.


### 111. Write a Java program to add two numbers without arithmetic operators.
Given x = 10 and y = 12; result = 22
```java
import java.util.Scanner;

public class Example111 {
    public static void main(String[] arg) {
        int x, y; // Declare two integer variables, 'x' and 'y'
        Scanner in = new Scanner(System.in); // Create a Scanner object for user input

        System.out.print("Input first number: "); // Prompt the user to input the first number
        x = in.nextInt(); // Read and store the first number from the user

        System.out.print("Input second number: "); // Prompt the user to input the second number
        y = in.nextInt(); // Read and store the second number from the user

        while (y != 0) {
            int carry = x & y; // Calculate the carry by bitwise AND operation between x and y
            x = x ^ y; // Calculate the sum without considering the carry by bitwise XOR operation
            y = carry << 1; // Calculate the carry for the next iteration by shifting it left by one position
        }

        System.out.print("Sum: " + x); // Print the sum of the two numbers
        System.out.print("\n"); // Print a new line
    }
}
```


### 112. Write a Java program to compute the number of trailing zeros in a factorial.
7! = 5040, therefore the output should be 1

```java
import java.util.Scanner;

public class Example112 {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in); // Create a Scanner object for user input
        System.out.print("Input a number: "); // Prompt the user to input a number
        int n = in.nextInt(); // Read and store the user's input as 'n'
        int n1 = n; // Create a copy of 'n' to preserve the original value
        long ctr = 0; // Initialize a variable 'ctr' to count trailing zeros

        while (n != 0) {
            ctr += n / 5; // Count the number of trailing zeros by dividing 'n' by 5 and accumulating the result
            n /= 5; // Reduce 'n' by dividing it by 5 for the next iteration
        }
        System.out.printf("Number of trailing zeros of the factorial %d is %d ", n1, ctr); // Print the result
        System.out.printf("\n"); // Print a new line
    }
}
```

### 113. Write a Java program to merge two given sorted arrays of integers and create another sorted array.
array1 = [1,2,3,4]
array2 = [2,5,7, 8]
result = [1,2,2,3,4,5,7,8]

```java
import java.util.*;

public class Example113 {
    public static void main(String[] arg) {
        // Declare two sorted integer arrays, array1 and array2
        // array1 has 'm' elements but is large enough to accommodate 'm+n' elements
        // array2 has 'n' elements
        
        // Declaration and instantiation of array1
        int array1[] = new int[8];
        
        // Initialize the first four elements of array1
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        array1[3] = 4;
        
        // Initialize array2
        int[] array2 = {2, 5, 7, 8};
        
        System.out.println("\nArray1: " + Arrays.toString(array1));
        System.out.println("\nArray2: " + Arrays.toString(array2));
        
        // Define variables m and n
        int m = 4, n = 4;
        
        // Initialize pointers for array1 (i) and array2 (j) and the index for merging (index)
        int i = m - 1, j = n - 1, index = m + n - 1;
        
        // Merge the two arrays into array1
        while (i >= 0 && j >= 0) {
            if (array1[i] > array2[j]) {
                array1[index--] = array1[i--];
            } else {
                array1[index--] = array2[j--];
            }
        }
        
        // Handle remaining elements in array1 (if any)
        while (i >= 0) {
            array1[index--] = array1[i--];
        }
        
        // Handle remaining elements in array2 (if any)
        while (j >= 0) {
            array1[index--] = array2[j--];
        }

        System.out.println("\nMerged array: " + Arrays.toString(array1));
    }
}
```

### 114. Write a Java program that rotates a string by an offset (rotate from left to right.

```java
import java.util.*;

public class Example114 {
    public static void main(String[] arg) {
        // Input string
        String str = "abcdef";
        
        // Convert the string to a character array
        char[] A = str.toCharArray();
        
        // Define the offset for rotation
        int offset = 3;
        
        // Calculate the length of the character array
        int len = A.length;
        
        // Ensure that the offset is within the bounds of the array
        offset %= len;
        
        // Reverse the first portion of the array
        reverse(A, 0, len - offset - 1);
        
        // Reverse the second portion of the array
        reverse(A, len - offset, len - 1);
        
        // Reverse the entire array to complete the rotation
        reverse(A, 0, len - 1);
        
        // Print the rotated array
        System.out.println("\n" + Arrays.toString(A));
    }

    // Helper function to reverse a portion of a character array
    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
```
### 115. Write a Java program to check if a positive number is a palindrome or not.
Input a positive integer: 151
Is 151 is a palindrome number?
true
```java
import java.util.*;

public class test {
    public static void main(String[] args) {
        int num;
        
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        
        // Prompt the user for a positive integer
        System.out.print("Input a positive integer: ");
        
        // Read the integer entered by the user
        int n = in.nextInt();
        
        // Display a message to check if the number is a palindrome
        System.out.printf("Is %d a palindrome number?\n", n);
        
        // Check if the number is a palindrome and print the result
        System.out.println(is_Palindrome(n));
    }

    // Function to reverse the digits of a number
    public static int reverse_nums(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return reverse;
    }

    // Function to check if a number is a palindrome
    public static boolean is_Palindrome(int n) {
        return (n == reverse_nums(n));
    }
}
```

### 116. Write a Java program that iterates integers from 1 to 100. For multiples of three print "Fizz" instead of the number and print "Buzz" for five. When the number is divided by three and five, print "fizz buzz".

```java
import java.util.*;

public class Exercise116 {
    public static void main(String[] args) {
        // Iterate from 1 to 100
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // Check if the number is divisible by both 3 and 5 (fizz buzz)
                System.out.printf("\n%d: fizz buzz", i);
            } else if (i % 5 == 0) {
                // Check if the number is divisible by 5 (buzz)
                System.out.printf("\n%d: buzz", i);
            } else if (i % 3 == 0) {
                // Check if the number is divisible by 3 (fizz)
                System.out.printf("\n%d: fizz", i);
            }
        }
        System.out.printf("\n");
    }
}
```
### 117. Write a Java program to compute the square root of a given number.
Input a positive integer: 25
Square root of 25 is: 5
```java
import java.util.*;

public class Exercise117 {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);

        // Prompt the user to input a positive integer
        System.out.print("Input a positive integer: ");
        int n = in.nextInt(); 

        // Print a message indicating the calculation about to take place
        System.out.printf("Square root of %d is: ", n);

        // Call the sqrt method to calculate the square root and print the result
        System.out.println(sqrt(n)); 
    }

    // Method to calculate the square root of a number
    private static int sqrt(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int a = 0;
        int b = num;

        // Perform a binary search to find the square root
        while (a <= b) {
            int mid = (a + b) >> 1;
            if (num / mid < mid) {
                b = mid - 1;
            } else {
                if (num / (mid + 1) <= mid) {
                    return mid;
                }
                a = mid + 1;
            }
        }
        return a;
    }
}
```

### 118. Write a Java program to get the first occurrence (Position starts from 0.) of a string within a given string.
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Define two strings, 's' and 't'
   		String s = "Python";
   		//String t = "Py";
   		  String t = "yt";
   		// String t = "ab";
        // Call the 'strStr' function with 's' and 't' as arguments and print the result
        System.out.printf(String.valueOf(strStr(s, t)));
    }

    public static int strStr(String source, String target) {
        // Check if either 'source' or 'target' is null
        if (source == null || target == null) {
            return -1; // Return -1 if either of them is null
        }
        
        // Check if 'target' is an empty string or is equal to 'source'
        if ("".equals(target) || source.equals(target)) {
            return 0; // Return 0 if 'target' is empty or equal to 'source'
        }
        
        int i = 0;
        int last = source.length() - target.length() + 1;

        // Iterate through 'source' while there are characters left to compare
        while (i < last) {
            if (source.charAt(i) == target.charAt(0)) {
                boolean equal = true;

                // Check if characters in 'source' match 'target' from the current position
                for (int j = 0; j < target.length() && equal; ++j) {
                    if (source.charAt(i + j) != target.charAt(j)) {
                        equal = false;
                    }
                }

                // If 'target' matches a substring of 'source', return the starting index
                if (equal) {
                    return i;
                }
            }
            ++i;
        }

        // If 'target' is not found in 'source', return -1
        return -1;
    }
}
```

### 119. Write a Java program to get the first occurrence (Position starts from 0.) of an element of a given array.
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare an array of integers 'nums' and an integer 'target'
        int nums[] = {2, 4, 6, 7, 8};
        int target = 7;
        
        // Initialize 'lower' to the start of the array and 'upper' to the end of the array
        int lower = 0;
        int upper = nums.length - 1;
        
        // Initialize 'index' to -1; it will store the position of the 'target'
        int index = -1;
        
        // Perform a binary search to find the 'target' in the 'nums' array
        while (lower <= upper) {
            // Calculate the middle index 'mid'
            int mid = (lower + upper) >> 1;
            
            // Check if 'nums[mid]' is equal to the 'target'
            if (nums[mid] == target) {
                index = mid; // Set 'index' to the position of the 'target'
            }
            
            // Adjust 'lower' and 'upper' based on the comparison with 'target'
            if (nums[mid] >= target) {
                upper = mid - 1; // Move 'upper' to the left half
            } else {
                lower = mid + 1; // Move 'lower' to the right half
            }
        }
        
        // Print the position of the 'target' in the array
        System.out.print("Position of " + target + " is " + index);
    }
}
```

### 120. Write a Java program that searches for a value in an m x n matrix.
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Initialize the 'target' value for searching
        int target = 0;
        
        // Create a 3x3 matrix and populate it with values
        int[][] matrix = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                matrix[row][col] = (1 + row * 3 + col);
            }
        }
        
        // Display the contents of the matrix
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(matrix[row][col] + " ");
                if (col == 2) {
                    System.out.println();
                }
            }
        }
        
        // Print the result of the 'searchMatrix' function
        System.out.print(Boolean.toString(searchMatrix(matrix, target)));
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Check if the matrix is empty or has no columns
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // Get the number of rows 'm' and columns 'n' in the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Initialize 'lower' and 'higher' for binary search
        int lower = 0;
        int higher = m * n - 1;
        
        // Perform binary search to find 'target' in the matrix
        while (lower <= higher) {
            int mid = (lower + higher) >> 1;
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            }
            if (val < target) {
                lower = mid + 1;
            } else {
                higher = mid - 1;
            }
        }
        
        // If 'target' is not found, return false
        return false;
    }
}
```

### 121. Write a Java program to reverse a linked list.
Example: For linked list 20->40->60->80, the reversed linked list is 80->60->40->20
```java
class LinkedList {
    // Static variable to store the head of the linked list
    static Node head;

    static class Node {
        int data;         // Data stored in the node
        Node next_node;   // Reference to the next node

        Node(int d) {
            data = d;
            next_node = null;
        }
    }

    // Function to reverse the linked list
    Node reverse(Node node) {
        Node prev_node = null;
        Node current_node = node;
        Node next_node = null;
        while (current_node != null) {
            next_node = current_node.next_node;
            current_node.next_node = prev_node;
            prev_node = current_node;
            current_node = next_node;
        }
        node = prev_node;
        return node;
    }

    // Function to print the elements of the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next_node;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Create a linked list with some initial values
        list.head = new Node(20);
        list.head.next_node = new Node(40);
        list.head.next_node.next_node = new Node(60);
        list.head.next_node.next_node.next_node = new Node(80);
        
        // Print the original linked list
        System.out.println("Original Linked list:");
        list.printList(head);
        
        // Reverse the linked list
        head = list.reverse(head);
        
        System.out.println("");
        // Print the reversed linked list
        System.out.println("Reversed Linked list:");
        list.printList(head);
    }
}
```

### 122. Write a Java program to find a contiguous subarray with the largest sum from a given array of integers.
Note: In computer science, the maximum subarray problem is the task of finding the contiguous subarray within a one-dimensional array of numbers which has the largest sum. For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6. The subarray should contain one integer at least. 

The subarray should contain one integer at least.

Pictorial Presentation:

Java Basic Exercises: Find a contiguous subarray with largest sum from a given array of integers
Sample Solution:

Java Code:
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Input array
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // Find and print the maximum subarray sum
        System.out.print(max_SubArray(nums)); 
    }

    public static int max_SubArray(int[] nums) {
        // Check if the input array is empty
        if (nums.length < 1) {
            return 0;
        }
        // Initialize variables to track the maximum sum, its start and end indices
        int max = nums[0];
        int max_Begin = 0;
        int max_End = 0;
        int begin = 0;
        int end = 0;
        int sum = 0;
        
        while (end < nums.length) {
            // Update the current sum with the value at the current end index
            sum += nums[end];
            if (sum < 0) {
                // If the current sum becomes negative, reset it and update the beginning index
                sum = 0;
                begin = end + 1;
            } else {
                // If the current sum is greater than the maximum, update the maximum
                if (sum > max) {
                    max = sum;
                    max_Begin = begin;
                    max_End = end;
                }
            }
            end++;
        }
        // Return the maximum sum of the subarray
        return max;
    }
}
```

### 123. Write a Java program to find the subarray with smallest sum from a given array of integers.
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to store integers
        ArrayList nums = new ArrayList();
        nums.add(-2);
        nums.add(1);
        nums.add(-3);
        nums.add(4);
        // Call the min_SubArray function and print the result
        System.out.print(min_SubArray(nums)); 
    }

    public static int min_SubArray(ArrayList nums) { 
        // Create an array to store the same integers for dynamic programming
        int[] nums1 = new int[nums.size()];
        nums1[0] = nums.get(0);
        // Initialize the minimum value to the first element
        int min = nums1[0];
        // Loop through the ArrayList to calculate minimum subarray sum
        for (int i = 1; i < nums.size(); ++i) {
            // Calculate the minimum of the current element and the sum of the previous subarray
            nums1[i] = Math.min(nums.get(i), nums.get(i) + nums1[i - 1]);
            // Update the minimum value if needed
            min = Math.min(min, nums1[i]);
        }
        // Return the minimum subarray sum
        return min;
    }
}
```

### 124. Write a Java program to find the index of a value in a sorted array. If the value does not find return the index where it would be if it were inserted in order.
Example:
[1, 2, 4, 5, 6] 5(target) -> 3(index)
[1, 2, 4, 5, 6] 0(target) -> 0(index)
[1, 2, 4, 5, 6] 7(target) -> 5(index)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create an array of integers
        int[] nums = {1, 2, 4, 5, 6};
       int target = 5;
     // target = 0;
     // target = 7;
     // Call the searchInsert function and print the result
        System.out.print(searchInsert(nums, target)); 
    }

    public static int searchInsert(int[] nums1, int target) {
        // Check if the input array is empty or null
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        // Initialize variables for binary search
        int start = 0;
        int end = nums1.length - 1;
        int mid = start + (end - start) / 2;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // Compare the middle element with the target
            if (nums1[mid] == target) {
                return mid;
            } else if (nums1[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        // Determine the insertion position based on binary search results
        if (nums1[start] >= target) {
            return start;
        } else if (nums1[start] < target && target <= nums1[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}
```

### 125. Write a Java program to get the preorder traversal of the values of the nodes in a binary tree.
Example:
    10
   / \
  20   30
 / \
40   50
Expected output: 10 20 40 50 30

```java
class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        // Constructor to create a new Node with the given item
        key = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;

    BinaryTree()
    {
        // Constructor to create an empty binary tree
        root = null;
    }

    void print_Preorder(Node node)
    {
        if (node == null)
            return;

        // Print the key of the current node
        System.out.print(node.key + " ");

        // Recursively print the left subtree in preorder
        print_Preorder(node.left);

        // Recursively print the right subtree in preorder
        print_Preorder(node.right);
    }

    void print_Preorder()  
    {   
        // Wrapper method to start printing the tree in preorder
        print_Preorder(root); 
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        
        // Create a binary tree with nodes and keys
        tree.root = new Node(55);
        tree.root.left = new Node(21);
        tree.root.right = new Node(80);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(29);
        tree.root.right.left = new Node(76);
        tree.root.right.right = new Node(91);

        // Display a message and initiate the preorder traversal
        System.out.println("Preorder traversal of binary tree is: ");
        tree.print_Preorder();
    }
}
```

### 126. Write a Java program to get the in-order traversal of its nodes' values in a binary tree.
    10
   / \
  20   30
 / \
40   50
Example:{10, 20, 30, 40, 50}
Output: 40 20 50 10 30
```java
class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        // Constructor to create a new Node with the given item
        key = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;

    BinaryTree()
    {
        // Constructor to create an empty binary tree
        root = null;
    }

    void print_Inorder(Node node)
    {
        if (node == null)
            return;

        // Recursively print the left subtree in inorder
        print_Inorder(node.left);

        // Print the key of the current node
        System.out.print(node.key + " ");

        // Recursively print the right subtree in inorder
        print_Inorder(node.right);
    }

    void print_Inorder()
    {     
        // Wrapper method to start printing the tree in inorder
        print_Inorder(root);     
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        // Create a binary tree with nodes and keys
        tree.root = new Node(55);
        tree.root.left = new Node(21);
        tree.root.right = new Node(80);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(29);
        tree.root.right.left = new Node(76);
        tree.root.right.right = new Node(91);

        // Display a message and initiate the inorder traversal
        System.out.println("\nInorder traversal of binary tree is: ");
        tree.print_Inorder(); 
    }
}
```

### 127. Write a Java program to get the Postorder traversal of its nodes' values in a binary tree.
    10
   / \
  20   30
 / \
40   50

```java
class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        // Constructor to create a new Node with the given item
        key = item;
        left = right = null;
    }
}

class BinaryTree
{
  // Root of Binary Tree
    Node root;

    BinaryTree()
    {
        // Constructor to create an empty binary tree
        root = null;
    }

 void print_Postorder(Node node)
    {
        if (node == null)
            return;

        // Recursively print the left subtree in postorder
        print_Postorder(node.left);

        // Recursively print the right subtree in postorder
        print_Postorder(node.right);

        // Print the key of the current node
        System.out.print(node.key + " ");
    }

 void print_Postorder()  
	{   
	   // Wrapper method to start printing the tree in postorder
	   print_Postorder(root);  
	}
        public static void main(String[] args)
    {
       BinaryTree tree = new BinaryTree();

        // Create a binary tree with nodes and keys
        tree.root = new Node(55);
        tree.root.left = new Node(21);
        tree.root.right = new Node(80);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(29);
        tree.root.right.left = new Node(76);
        tree.root.right.right = new Node(91);

        // Display a message and initiate the postorder traversal
        System.out.println("\nPostorder traversal of binary tree is: ");
        tree.print_Postorder();
    }
}
```
### 128. Write a Java program to calculate the median of a non-sorted array of integers.
Original array: [10, 2, 38, 22, 38, 23]
Median of the said array of integers: 30
Original array: [10, 2, 38, 23, 38, 23, 21]
Median of the said array of integers: 23

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Define and initialize an array of integers
        int[] nums = {10, 2, 38, 22, 38, 23};
        
        // Display the original array
        System.out.println("Original array: " + Arrays.toString(nums));
        
        // Calculate and display the median of the array
        System.out.println("Median of the said array of integers: " + getMedian(nums));
        
        // Define and initialize another array of integers
        int[] nums1 = {10, 2, 38, 23, 38, 23, 21};
        
        // Display the original array
        System.out.println("\nOriginal array: " + Arrays.toString(nums1));
        
        // Calculate and display the median of the second array
        System.out.println("Median of the said array of integers: " + getMedian(nums1));
    }

    public static int getMedian(int[] array) {
        // Check if the length of the array is even
        if (array.length % 2 == 0) {
            // Calculate the median for even-sized arrays
            int mid = array.length / 2;
            return (array[mid] + array[mid - 1]) / 2;
        }
        // Calculate the median for odd-sized arrays
        return array[array.length / 2];
    }
}
```

### 129. Write a Java program to find a number that appears only once in a given array of integers. All numbers occur twice.
Source Array : [10, 20, 10, 20, 30, 40, 40, 30, 50] 50 appears only once

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Define an array of integers
        int nums[] = {10, 20, 10, 20, 30, 40, 40, 30, 50};
        
        // Declare a variable to store the result
        int result;
        
        // Display the source array
        System.out.println("Source Array : " + Arrays.toString(nums));   
        
        // Calculate and display the number that appears only once
        result = getSingleNumber(nums);
        System.out.println("\n" + result + " appears only once.");
    }

    public static int getSingleNumber(int[] nums) {
        // Check if the array is null or empty
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // Initialize the result to 0
        int result = 0;
        
        // Calculate the number that appears only once using XOR (^) operator
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        
        // Return the result
        return result;
    }
}
```

### 130. Write a Java program to find the maximum depth of a given binary tree.
Sample Output: The Maximum depth of the binary tree is: 3

```java
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        // Constructor to initialize a node with given data
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public int maxDepth(Node root) {
        // Recursive function to calculate the maximum depth of the binary tree
        if (root == null)
            return 0;
        int left_Depth = maxDepth(root.left);
        int right_Depth = maxDepth(root.right);
        int bigger = Math.max(left_Depth, right_Depth);
        return bigger + 1;
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(55);
        tree.root.left = new Node(21);
        tree.root.right = new Node(80);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(29);
        tree.root.right.left = new Node(76);
        tree.root.right.right = new Node(91);

        // Create a binary tree and calculate its maximum depth
        System.out.println("The Maximum depth of the binary tree is: " + tree.maxDepth(tree.root));
    }
}
```
### 131. Write a Java program to find the updated length of a sorted array where each element appears only once (remove duplicates).
Original array: [1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7] The length of the original array is: 11 After removing duplicates, the new length of the array is: 7

```java
import java.util.Arrays;

class Solution {
    // Static method to remove duplicates from the given array
    static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int current_pos = 0;
        int moving_pos;
        for (moving_pos = 1; moving_pos < nums.length; moving_pos++) {
            // Check if the current element is different from the next element
            if (nums[current_pos] != nums[moving_pos]) {
                // If different, move the unique element to the next position in the array
                nums[current_pos + 1] = nums[moving_pos];
                current_pos++; // Increment the position for the unique element
            }
        }
        // The new length of the array is one more than the current position
        return current_pos + 1;
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7};
        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("The length of the original array is: " + nums.length);
        System.out.println("After removing duplicates, the new length of the array is: " + removeDuplicates(nums));
    }
}
```
### 132. Write a Java program to find the updated length of a given sorted array where duplicate elements appear at most twice.
Original array: [1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 7, 7]
The length of the original array is: 13
After removing duplicates, the new length of the array is: 10

```java
import java.util.Arrays;

class Solution {
    // Static method to remove duplicates from the given array, allowing at most two duplicates
    static int remove_Duplicates_twice(int[] nums) {
        // Check for invalid or empty input array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 1; // Initialize the index for the resulting array
        for (int i = 2; i < nums.length; i++) {
            // Check if the current element is different from the element at 'index',
            // or if it's the second occurrence of a duplicate, but not the third
            if (nums[i] != nums[index] || (nums[i] == nums[index] && nums[i] != nums[index - 1])) {
                index++; // Increment the index for the resulting array
                nums[index] = nums[i]; // Copy the unique or second occurrence of a duplicate element
            }
        }
        // The new length of the array is one more than the 'index'
        return index + 1;
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 7, 7};
        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("The length of the original array is: " + nums.length);
        System.out.println("After removing duplicates, the new length of the array is: " + remove_Duplicates_twice(nums));
    }
}
```
### 133. Write a Java program to find a path from top left to bottom in the right direction which minimizes the sum of all numbers along its path.
Note: Move either down or right at any point in time.
Sample Output: Sum of all numbers along its path: 13
```java
import java.util.*
public class Solution {
    // Static method to find the minimum path sum in a 2D grid
    public static int minPathSum(int[][] grid) {
        // Check for invalid or empty input grid
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid
        int[][] temp = new int[m][n]; // Temporary array to store minimum path sum

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[i][j] = grid[i][j]; // Initialize the starting point
                    continue;
                }

                // Calculate the minimum path sum from either the cell above or the cell on the left
                int from_up = i == 0 ? Integer.MAX_VALUE : temp[i - 1][j];
                int from_left = j == 0 ? Integer.MAX_VALUE : temp[i][j - 1];
                temp[i][j] = Math.min(from_up, from_left) + grid[i][j]; // Update the temporary array
            }
        }
        // Return the minimum path sum for the last cell
        return temp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // Example grid
        int[][] grid = new int[][] {{7, 4, 2},
                                    {0, 5, 6},
                                    {3, 1, 2}};
        
        System.out.println("Sum of all numbers along its path: " + minPathSum(grid));
    }	
}
```

### 134. Write a Java program to find distinct ways to climb to the top (n steps to reach the top) of stairs. Each time you climb, you can climb 1 or 2 steps.
Example: n = 5
a) 1+1+1+1+1 = 5 b) 1+1+1+2 = 5 c) 1+2+2 = 5 d) 2+2+1 = 5 e) 2+1+1+1 = 5 f) 2+1+2 = 5 g) 1+2+1+1 = 5 h) 1+1+2+1 = 5
Sample Output: Distinct ways can you climb to the top: 8
```java
import java.util.*
class Solution {
    // Static method to calculate the distinct ways to climb stairs
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1; // If there is 0 or 1 step, there is only 1 way to climb.
        }
        int[] s_case = new int[n + 1]; // Create an array to store the number of distinct ways for each step count.
        s_case[0] = 1; // There is 1 way to climb 0 steps.
        s_case[1] = 1; // There is 1 way to climb 1 step.
        for (int i = 2; i <= n; i++) {
            // Calculate the number of distinct ways for each step by adding the ways from the previous two steps.
            s_case[i] = s_case[i - 1] + s_case[i - 2];
        }
        return s_case[n]; // Return the number of distinct ways to climb n steps.
    }

    public static void main(String[] args) {
        int steps = 5; // The number of steps to climb
        System.out.println("Distinct ways can you climb to the top: " + climbStairs(steps));
    }
}
```

### 135. Write a Java program to remove duplicates from a sorted linked list.
Original List with duplicate elements:
12->12->13->14->15->15->16->17->17
After removing duplicates from the said list:
12->13->14->15->16->17

```java
class LinkedList {
	Node head; // Reference to the head node of the linked list

	/* Linked list Node */
	class Node {
		int data; // Data stored in the node
		Node next; // Reference to the next node

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method to remove duplicate elements from the linked list
	void remove_Duplicates() {
		Node current = head; // Initialize the current node to the head
		Node next_next; // Reference to the next of the next node

		if (head == null)
			return; // If the linked list is empty, return

		while (current.next != null) {
			if (current.data == current.next.data) {
				next_next = current.next.next;
				current.next = null; // Remove the duplicate node
				current.next = next_next; // Update the next reference
			} else
				current = current.next; // Move to the next node
		}
	}

	// Method to insert a new node at the front of the linked list
	public void push(int new_data) {
		Node new_node = new Node(new_data); // Create a new node
		new_node.next = head; // Set the next of the new node to the current head
		head = new_node; // Update the head to the new node
	}

	// Method to print the linked list
	void printList() {
		Node temp = head; // Initialize a temporary node with the head
		while (temp != null) {
			System.out.print(temp.data); // Print the data of the current node
			if (temp.next != null) {
				System.out.print("->"); // Print an arrow to indicate the next node
			}
			temp = temp.next; // Move to the next node
		}
		System.out.println(); // Print a new line to complete the list
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		LinkedList l_list = new LinkedList();
		
		// Insert data into the linked list
		l_list.push(17);
		l_list.push(17);
		l_list.push(16);
		l_list.push(15);
		l_list.push(15);
		l_list.push(14);
		l_list.push(13);
		l_list.push(12);
		l_list.push(12);
		
		System.out.println("Original List with duplicate elements:");
		l_list.printList();
		
		l_list.remove_Duplicates(); // Remove duplicates
		
		System.out.println("After removing duplicates from the said list:");
		l_list.printList();
	}
}
```

### 136. Write a Java program to find possible distinct paths from the top-left corner to the bottom-right corner of a given grid (m x n).
Note: You can move either down or right at any point in time.
Sample Output: Unique paths from top-left corner to bottom-right corner of the said grid: 3
```java
import java.util.*
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public static int unique_Paths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] grid = new int[m][n]; // Create a grid to store the number of unique paths

        // Nested loops to iterate through the grid
        for (int i = m - 1; i >= 0; --i) { // Start from the bottom row and move upwards
            for (int j = n - 1; j >= 0; --j) { // Start from the rightmost column and move leftwards
                grid[i][j] = get_Paths(grid, i, j); // Calculate the unique paths for the current cell
            }
        }
        return grid[0][0]; // The top-left corner now contains the total unique paths
    }
    
    // Helper function to calculate unique paths for a cell
    private static int get_Paths(int[][] grid, int i, int j) {
        if (i >= grid.length - 1 || j >= grid[0].length - 1) {
            return 1; // If at the rightmost column or bottom row, there is only one path
        }
        return grid[i][j + 1] + grid[i + 1][j]; // Sum the unique paths from the right and bottom cells
    }
    
    // Main method for testing the unique_Paths function
    public static void main(String[] args) {
		int m = 3;
		int n = 2;
		System.out.println("Unique paths from top-left corner to bottom-right corner of the said grid: "+unique_Paths(m, n));
	}		
}
```

### 137. Write a Java program to find possible unique paths considering some obstacles, from top-left corner to bottom-right corner of a given grid (m x n).
Note: You can move either down or right at any point in time and an obstacle and empty space is marked as 1 and 0 respectively in the grid.
Sample grid:
int[][] obstacle_Grid ={
{0, 0, 0},
{0, 1, 0},
{0, 0, 0},
};
Sample Output: Unique paths from top-left corner to bottom-right corner of the said grid (considering some obstacles): 2

```java
import java.util.*
public class Solution {
    public static int uniquePaths_With_obstacle_Grid(int[][] obstacle_Grid) {
        // Get the number of rows (m) in the obstacle grid
		int m = obstacle_Grid.length;
		if (m <= 0) {
			return 0;
		}
        // Get the number of columns (n) in the obstacle grid
		int n = obstacle_Grid[0].length;
		if (n <= 0) {
			return 0;
		}
        // Create a dynamic programming array to store unique paths
		int[][] dp = new int[m + 1][n + 1];
		dp[m][n - 1] = 1;

        // Nested loops to iterate through the grid
		for (int i = m - 1; i >= 0; --i) { // Start from the bottom row and move upwards
			for (int j = n - 1; j >= 0; --j) { // Start from the rightmost column and move leftwards
                // Calculate unique paths for the current cell based on obstacles
				dp[i][j] = (obstacle_Grid[i][j] == 0) ? dp[i + 1][j] + dp[i][j + 1] : 0;
			}
		}
        // Return the count of unique paths from top-left to bottom-right corner
		return dp[0][0];
	}
    
  // Main method for testing the uniquePaths_With_obstacle_Grid function
  public static void main(String[] args) {
		int[][] obstacle_Grid ={
            {0, 0, 0}, 
            {0, 1, 0}, 
            {0, 0, 0}, 
        };
		System.out.println("Unique paths from top-left corner to bottom-right corner of the said grid (considering some obstacles): "+uniquePaths_With_obstacle_Grid(obstacle_Grid));
	}		
}
```

### 138. Write a Java program to find the longest words in a dictionary.
Example-1:
{
"cat",
"flag",
"green",
"country",
"w3resource"
}
Result: "w3resource"
Example-2:
{
"cat",
"dog",
"red",
"is",
"am"
}
Result: "cat", "dog", "red"

```java
import java.util.*;

public class Solution {
    // Function to find and return the longest words in the given dictionary
    static ArrayList longestWords(String[] dictionary) {
        ArrayList list = new ArrayList();
        int longest_length = 0;

        // Iterate through each word in the dictionary
        for (String str : dictionary) {
            int length = str.length();
            
            // Check if the current word is longer than the previously found longest word(s)
            if (length > longest_length) {
                longest_length = length;
                list.clear(); // Clear the list as a new longest word is found
            }
            
            // If the current word has the same length as the longest word(s), add it to the list
            if (length == longest_length) {
                list.add(str);
            }
        }
        return list; // Return the list of longest words
    }
    
    public static void main(String[] args) {
        // Sample dictionary containing words
        // String[] dict = {"cat", "flag", "green", "country", "w3resource"};
        String[] dict = {"cat", "dog", "red", "is", "am"};

        // Print the original dictionary and the longest word(s)
        System.out.println("Original dictionary: " + Arrays.toString(dict));
        System.out.println("Longest word(s) of the above dictionary: " + longestWords(dict));
    }		
}
```

### 139. Write a Java program to get the index of the first and the last number of a subarray where the sum of numbers is zero. This is from a given array of integers.
Original Array : [1, 2, 3, -6, 5, 4]
Index of the subarray of the said array where the sum of numbers is zero: [0, 3]
```java
import java.util.*;

public class Solution {
    // Function to find the subarray with a sum of zero in the given array
    public static List<Integer> subarraySum(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        
        // Check if the input array is null or empty, and return an empty list if so
        if (nums == null || nums.length == 0) {
            return temp;
        }
        
        int pre_Sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(pre_Sum, -1);
        
        // Iterate through the elements of the input array
        for (int i = 0; i < nums.length; i++) {
            pre_Sum += nums[i];
            
            // Check if the current prefix sum already exists in the map
            if (map.containsKey(pre_Sum)) {
                temp.add(map.get(pre_Sum) + 1); // Add the start index of the subarray
                temp.add(i); // Add the end index of the subarray
                return temp; // Return the list of indices
            }
            
            // If the prefix sum is not found, add it to the map with its index
            map.put(pre_Sum, i);
        }
        
        return temp; // Return an empty list if no subarray with a sum of zero is found
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -6, 5, 4};

        // Print the original array and the indices of the subarray with a sum of zero
        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Index of the subarray of the said array where the sum of numbers is zero: " + subarraySum(nums));
    }		
}
```

### 140. Write a Java program to merge all overlapping intervals from a given collection of intervals.
Sample Output: 1 6
8 10
15 20

```java
import java.util.*;

public class Solution
{   
    public static void main (String[] args) throws java.lang.Exception
    {
        // Create an ArrayList of Interval objects
        ArrayList<Interval> x = new ArrayList<>();

        // Add intervals to the ArrayList
        x.add(new Interval(1, 3));
        x.add(new Interval(2, 6));
        x.add(new Interval(8, 10));
        x.add(new Interval(15, 18));
        x.add(new Interval(17, 20));

        // Merge overlapping intervals
        x = merge(x);

        // Print the merged intervals
        for(Interval i : x)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Check for the number of intervals
        if(intervals.size() == 0 || intervals.size() == 1)
            return intervals;

        // Sort the intervals based on the start values
        Collections.sort(intervals, new IntervalComparator());

        // Initialize the variables
        Interval first = intervals.get(0);
        int start = first.getStart();
        int end = first.getEnd();

        // Create a list for the merged intervals
        ArrayList<Interval> result = new ArrayList<Interval>();

        // Merge overlapping intervals
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.getStart() <= end) {
                end = Math.max(current.getEnd(), end);
            } else {
                result.add(new Interval(start, end));
                start = current.getStart();
                end = current.getEnd();
            }
        }

        // Add the last merged interval
        result.add(new Interval(start, end));
        return result;
    }
}

class Interval 
{
    private int start;
    private int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) 
    {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval i1, Interval i2)
    {
        // Compare intervals based on start values
        return i1.getStart() - i2.getStart();
    }
}
```
### 141. Write a Java program to check if a given string has all distinct characters.
Sample Output: Original String : xyyz
String has all unique characters: false
```java
import java.util.*;
public  class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public static boolean is_Unique_str(String str) {
        // Convert the input string to a character array
        char[] chars = str.toCharArray();
        
        // Sort the character array in lexicographical order
        Arrays.sort(chars);
        
        // Check for repeated characters in the sorted array
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == chars[i-1]) {
                return false;
            }
        }
        
        // If no repeated characters are found, the string is considered to have all unique characters
        return true;
    }
    
    public static void main(String[] args) {
        // Test case: Check if the string "xyyz" has all unique characters
        // Note: You can change the value of the 'str' variable for different input strings.
        String str = "xyyz";
        
        // Print the original string
        System.out.println("Original String : " + str);
        
        // Check if the string has all unique characters and print the result
        System.out.println("String has all unique characters: " + is_Unique_str(str));
    }   
}
```

### 142. Write a Java program to check if two strings are anagrams or not.
According to Wikipedia "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. For example, the word anagram can be rearranged into nag a ram, or the word binary into brainy."
Sample Output: String-1 : wxyz
String-2 : zyxw
Check if two given strings are anagrams or not?: true
```java
import java.util.*
public  class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
   public static boolean anagram_test(String str1, String str2) {
        // Check if either input string is null
        if (str1 == null || str2 == null) {
            return false;
        } 
        // Check if the lengths of the two strings are different
        else if (str1.length() != str2.length()) {
            return false;
        } 
        // Check if both strings are empty (an edge case)
        else if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }
        
        // Create an integer array to count character occurrences
        int[] count = new int[256];
        
        // Count character occurrences in both strings
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        
        // Check if all counts in the array are zero, indicating anagrams
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        
        // If all checks pass, the strings are anagrams
        return true;
    }
    
    public static void main(String[] args) {
        // Test case: Check if the strings "wxyz" and "zyxw" are anagrams
        String str1 = "wxyz";
        String str2 = "zyxw";
        
        // Print the original strings
        System.out.println("String-1 : " + str1);
        System.out.println("String-2 : " + str2);
        
        // Check if the two given strings are anagrams and print the result
        System.out.println("Check if two given strings are anagrams or not?: " + anagram_test(str1, str2));
    }   
}
```

### 143. Write a Java program to merge the two sorted linked lists.
Sample Output:
Merge Two Sorted ListsT:
1 2 3 7 9 13 40
```java
import java.util.*
public class Solution {
    public static void main(String[] args) {
        // Create two sorted linked lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(7);
        list1.next.next.next = new ListNode(9);
        list1.next.next.next.next = new ListNode(13);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(40);
        
        // Merge the two sorted lists and get the result
        ListNode head = mergeTwoLists(list1, list2);
		System.out.print("Merge Two Sorted Lists:\n");
        
        // Print the merged list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a new linked list for the merged result
        ListNode head = new ListNode(0);
        ListNode mlist = head;
        
        // Merge the two lists while maintaining the order
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mlist.next = new ListNode(list1.val);
                mlist = mlist.next;
                list1 = list1.next;
            } else {
                mlist.next = new ListNode(list2.val);
                mlist = mlist.next;
                list2 = list2.next;
            }
        }
        
        // Append any remaining elements from list1
        while (list1 != null) {
            mlist.next = new ListNode(list1.val);
            mlist = mlist.next;
            list1 = list1.next;
        }
        
        // Append any remaining elements from list2
        while (list2 != null) {
            mlist.next = new ListNode(list2.val);
            mlist = mlist.next;
            list2 = list2.next;
        }
        
        // Skip the dummy head node and return the merged list
        head = head.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
```

### 144. Write a Java program to remove all occurrences of a specified value in a given array of integers. Return the updated array length.
Sample Output:
Original array: [1, 4, 6, 7, 6, 2]
The length of the new array is: 4

```java
import java.util.*;

public class Solution {
    /**
     * Remove all occurrences of a given element from an array and return the new length.
     * @param nums: A list of integers
     * @param element: An integer to be removed
     * @return: The new length after removing the element
     */
    public static int removeElement(int[] nums, int elem) {
        int length = nums.length; // Get the initial length of the array
        if (length == 0) return 0; // If the array is empty, return 0 (no changes)
        
        int i = 0; // Initialize the index for the new array
        
        // Iterate through the original array
        for (int j = 0; j < length; j++) {
            if (nums[j] != elem) {
                // If the current element is not equal to the element to be removed
                // Copy it to the new position in the array
                nums[i] = nums[j];
                i++;
            }
        }
        
        // Replace elements beyond the new length with a sentinel value
        if (i < length) nums[i] = '\0';
        
        // Return the new length (the value of 'i')
        return i;
    }
    
    public static void main(String[] args) {
        int x = 6; // Element to be removed
        int[] nums = {1, 4, 6, 7, 6, 2}; // Original array
        System.out.println("Original array: " + Arrays.toString(nums));
        
        // Call the removeElement function and print the new length
        System.out.println("The length of the new array is: " + removeElement(nums, x));
    }
}
```
### 145. Write a Java program to remove the nth element from the end of a given list.
Sample Output:
Original node:
1 2 3 4 5
After removing 2nd element from end:
1 2 3 5
```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Create a linked list with five nodes (1, 2, 3, 4, 5)
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        
        // Copy the original linked list to 'o' for display
        ListNode o = h;
        System.out.println("Original node:");
        
        // Display the original linked list
        while (o != null) {
            System.out.print(o.val + " ");
            o = o.next;
        }
        
        System.out.println("\nAfter removing 2nd element from end:");
        
        // Call the removeNthFromEnd function and print the modified linked list
        ListNode head = removeNthFromEnd(h, 2);
    
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int size = 0;
        
        // Calculate the size of the linked list
        while (p != null) {
            size++;
            p = p.next;
        }
        
        // Check if the element to remove is the first one
        if (n == size) {  
            head = head.next;
        } else {
            int index = size - n;
            ListNode t = head;
            
            // Traverse to the node before the one to remove
            while (index > 1) {
                t = t.next;
                index--;
            }
            
            // Update the 'next' reference to skip the node to remove
            t.next = t.next.next;
        }
        
        return head; // Return the modified linked list
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
```

### 146. Write a Java program to convert an array of sorted items into a binary search tree. Maintain the minimal height of the tree.
Sample Output:
2
1
4
6
5
3
```java
public class Solution {
    public static void main(String[] args) {
        // Define an array of sorted integers
        int[] arr = {1, 2, 3, 4, 5, 6};
        
        // Convert the sorted array to a balanced binary search tree (BST)
        TreeNode root = sortedArrayToBST(arr);
        
        // Traverse the BST and print the values
        traverseTree(root);
    }

    public static TreeNode sortedArrayToBST(int[] arr) {
        if (arr.length == 0) return null;
        
        // Call the recursive function for creating the BST
        return creation(arr, 0, arr.length - 1);
    }

    private static TreeNode creation(int[] arr, int start, int end) {
        TreeNode node = new TreeNode(0);
        
        if (start == end - 1) {
            // If the range contains two elements, create the nodes accordingly
            node = new TreeNode(arr[start]);
            node.right = new TreeNode(arr[end]);
        } else if (start == end) {
            // If the range contains a single element, create a node
            return new TreeNode(arr[start]);
        } else {
            // Calculate the middle index of the range
            int mid = (start + end) / 2;
            
            // Set the value of the current node to the middle element
            node.val = arr[mid];
            
            // Recursively create left and right subtrees
            node.left = creation(arr, start, mid - 1);
            node.right = creation(arr, mid + 1, end);
        }
        return node;
    }

    private static void traverseTree(TreeNode root) {
        // Post-order traversal of the BST (left, right, root)
        if (root != null) {
            traverseTree(root.left);
            traverseTree(root.right);
            System.out.println(root.val);
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
```

### 147. Write a Java program to find the number of bits required to flip to convert two given integers.
Sample Output:
2
```java
import java.util.*
public class Solution {
    public static void main(String[] args) {
        // Test the bitSwapRequired function and print the result
        System.out.println(bitSwapRequired(27, 23));
    }

    public static int bitSwapRequired(int x, int y) {
        int ctr = 0; // Initialize a counter to keep track of bit differences

        // XOR the two integers (x and y) to find differing bits
        for (int z = x ^ y; z != 0; z = z >>> 1) {
            // Right shift 'z' by 1 bit and check the least significant bit
            ctr += z & 1; // If the least significant bit is 1, increment the counter
        }
        return ctr; // Return the total count of differing bits
    }
}
```

### 148. Write a Java program to find the index of the first unique character in a given string. Assume that there is at least one unique character in the string.
Sample Output:
Original String: wresource
First unique character of the above: 0
```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Test the first_Uniq_Char function and print the result
        String s = "wresource";
        System.out.println("Original String: " + s);
        System.out.println("First unique character of the above: " + first_Uniq_Char(s));
    }

    public static int first_Uniq_Char(String s) {
        int[] freq = new int[256]; // Create an array to store character frequencies (assuming ASCII characters)

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++; // Increment the count at the corresponding index in the array
        }

        // Iterate through the string to find the index of the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i; // Return the index of the first character with a frequency of 1
            }
        }

        return -1; // Return -1 if there are no unique characters
    }
}
```

### 149. Write a Java program to check if a given string is a permutation of another given string.
Sample Output:
Original strings: xxyz yxzx
true
```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Test the stringPermutation function and print the result
        String str1 = "xxyz";
        String str2 = "yxzx";
        System.out.println("Original strings: " + str1 + "  " + str2);
        System.out.println(stringPermutation(str1, str2));
    }

    public static boolean stringPermutation(String str1, String str2) {
        int[] arr = new int[500]; // Create an integer array to count character frequencies (assuming extended ASCII characters)

        // Count the frequency of characters in the first string
        for (int i = 0; i < str1.length(); i++) {
            arr[(int) str1.charAt(i)] += 1;
        }

        // Decrement the count of characters in the second string
        for (int i = 0; i < str2.length(); i++) {
            arr[(int) str2.charAt(i)] -= 1;
        }

        // Check if all character counts are zero, indicating a permutation
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false; // If any count is non-zero, return false
        }

        return true; // If all counts are zero, return true, indicating a permutation
    }
}
```

### 150. Write a Java program to test if a binary tree is a subtree of another binary tree.
Sample Output:
Original strings: xxyz yxzx
true

```java
import java.util.*
public class Solution {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public static boolean is_Subtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) return true; // If T2 is null, it's always a subtree (base case)
        if (T1 == null) return false; // If T1 is null but T2 is not, T2 can't be a subtree

        if (is_Same(T1, T2)) return true; // Check if the current subtrees are the same
        if (is_Subtree(T1.left, T2) || is_Subtree(T1.right, T2)) return true; // Check left and right subtrees

        return false; // If none of the above conditions match, T2 is not a subtree of T1
    }

    public static boolean is_Same(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2; // If one of the nodes is null, both should be null for them to be the same
        } else if (t1.val != t2.val) {
            return false; // If the values are different, the trees are not the same
        } else {
            // Recursively check the left and right subtrees for sameness
            return is_Same(t1.left, t2.left) && is_Same(t1.right, t2.right);
        }
    }

    public static void main(String[] args) {
        // Create two binary trees
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left  = t2;
        t1.right = t3;

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left  = n2;
        n1.right = n3;

        // Check if n1 is a subtree of t1 and print the result
        System.out.println(is_Subtree(t1, n1));
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
```
