
# Java Exercises Exception

Java Exceptions to handle errors:

Java programming language uses exceptions to handle errors and other exceptional events. An exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions.

This section covers how to catch and handle exceptions. It includes try, catch, and finally block, as well as chained exceptions and logging exercises.


### 1. Write a Java program that throws an exception and catch it using a try-catch block.

```java
public class Exception_Example {
  public static void main(String[] args) {
    try {
      int result = divideNumbers(5, 0);
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
  public static int divideNumbers(int dividend, int divisor) {
    if (divisor == 0) {
      throw new ArithmeticException("Cannot divide the given number by zero!");
    }
    return dividend / divisor;
  }
}
```
Sample Output:

Error: Cannot divide the given number by zero!
Explanation:

In the above exercise, the divideNumbers method takes two integers as input and checks if the divisor is zero. If the divisor is zero, it throws an ArithmeticException with the message "Cannot divide the given number by zero!"


In the main method, we call the divideNumbers method with 10 as the dividend and 0 as the divisor. Since the divisor is zero, it throws an exception. Using a try-catch block, we catch the exception and print the error message "Error: Cannot divide by zero".

### 2. Write a Java program to create a method that takes an integer as a parameter and throws an exception if the number is odd.
```java
public class Exception_OddNumber {
  public static void main(String[] args) {
    int n = 18;
    trynumber(n);
    n = 7;
    trynumber(n);
  }

  public static void trynumber(int n) {
    try {
      checkEvenNumber(n);
      System.out.println(n + " is even.");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void checkEvenNumber(int number) {
    if (number % 2 != 0) {
      throw new IllegalArgumentException(number + " is odd.");
    }
  }
}
```
Sample Output:

18 is even.
Error: 7 is odd.
Explanation:

In the above exercise,

The Exception_OddNumber class is the main class.
In the main method, an integer n is declared and assigned 18. The trynumber method is then called with n as an argument.
The trynumber method handles the exception. It contains a try-catch block. Inside the try block, the method checkEvenNumber is called, passing n as an argument. If the number is even, the message "[number] is even." is printed.
If an exception occurs in the try block, it is caught by the catch block, which handles IllegalArgumentException. In this case, the error message "Error: [exception message]" is printed.
After the first call to trynumber(n), the value of n is updated to 7, and the trynumber method is called again. This time, since 7 is an odd number, an exception is thrown.
The checkEvenNumber method checks if a given number is even or odd. If the number is odd, it throws an IllegalArgumentException with the message "[number] is odd."


### 3. Write a Java program to create a method that reads a file and throws an exception if the file is not found.
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Read {
  public static void main(String[] args) {
    try {
      readFile("test1.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void readFile(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);

    // Read and process the contents of the file
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      System.out.println(line);
    }

    scanner.close();
  }
}
```
Sample Output:

Error: test1.txt (The system cannot find the file specified)
Explanation:

In the above exercise,

In this program, we have a method called readFile that takes a fileName parameter. To read the contents of the file, it creates a Scanner object using the File class.
In the main method, we call the readFile method and provide the name of the file we want to read. If the file is not found, a FileNotFoundException is thrown.
In the readFile method, we declare a File object and initialize it with the given fileName. We then create a Scanner object using the file. If the file is not found, a FileNotFoundException is thrown.
A try-catch block is used in the main method to catch the FileNotFoundException and print an error message.

### 4. Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers are positive.
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Read {
  public static void main(String[] args) {
    try {
      readFile("test1.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void readFile(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);

    // Read and process the contents of the file
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      System.out.println(line);
    }

    scanner.close();
  }
}
```
### 5. Write a Java program that reads a file and throws an exception if the file is empty.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Empty_File_Check {
  public static void main(String[] args) {
    try {
      checkFileNotEmpty("test1.txt");
      System.out.println("File is not empty.");
    } catch (FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (EmptyFileException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void checkFileNotEmpty(String fileName) throws FileNotFoundException, EmptyFileException {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);

    if (!scanner.hasNextLine()) {
      scanner.close();
      throw new EmptyFileException("File is empty.");
    }

    scanner.close();
  }
}

class EmptyFileException extends Exception {
  public EmptyFileException(String message) {
    super(message);
  }
}
```

### 6. Write a Java program that reads a list of integers from the user and throws an exception if any numbers are duplicates.

```java
import java.util.*;

public class Duplicate_Number_Check {
  public static void main(String[] args) {
    try {
      List < Integer > numbers = readNumbersFromUser();
      checkDuplicates(numbers);
      System.out.println("No duplicate numbers!");
    } catch (Duplicate_Number_Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static List < Integer > readNumbersFromUser() {
    List < Integer > numbers = new ArrayList < > ();
    Scanner scanner = new Scanner(System.in);

    System.out.print("How many numbers do you want to input? ");
    int count = scanner.nextInt();

    System.out.println("Input the integers:");
    for (int i = 0; i < count; i++) {
      int num = scanner.nextInt();
      numbers.add(num);
    }

    scanner.close();
    return numbers;
  }

  public static void checkDuplicates(List < Integer > numbers) throws Duplicate_Number_Exception {
    Set < Integer > uniqueNumbers = new HashSet < > ();

    for (int num: numbers) {
      if (uniqueNumbers.contains(num)) {
        throw new Duplicate_Number_Exception("Duplicate number found: " + num);
      }
      uniqueNumbers.add(num);
    }
  }
}
class Duplicate_Number_Exception extends Exception {
  public Duplicate_Number_Exception(String message) {
    super(message);
  }
}
```

### 7. Write a Java program to create a method that takes a string as input and throws an exception if the string does not contain vowels.

```java
public class Vowel_Check {
  public static void main(String[] args) {
    try {
      String text = "Java handling and managing exceptions ";
      // String text = "Typy gyps fly.";
      System.out.println("Original string: " + text);
      checkVowels(text);
      System.out.println("String contains vowels.");
    } catch (NoVowelsException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void checkVowels(String text) throws NoVowelsException {
    boolean containsVowels = false;
    String vowels = "aeiouAEIOU";

    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (vowels.contains(String.valueOf(ch))) {
        containsVowels = true;
        break;
      }
    }
    if (!containsVowels) {
      throw new NoVowelsException("String does not contain any vowels.");
    }
  }
}
class NoVowelsException extends Exception {
  public NoVowelsException(String message) {
    super(message);
  }
}
```
