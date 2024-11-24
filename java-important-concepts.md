Your article on "10 JDK 7 Features to Revisit" is a great overview of key improvements introduced in Java 7, and it's a good reminder for developers to revisit these features before fully diving into Java 8. Here's a summary of the features with some brief clarifications and example code for those who may not be familiar with them:

### 1) **Type Inference with Diamond Operator**
Introduced in Java 7, the diamond operator (`<>`) enables more concise code by eliminating redundancy in generic type declarations, especially when initializing collections.

**Before Java 7:**
```java
Map<String, List<String>> employeeRecords = new HashMap<String, List<String>>();
List<Integer> primes = new ArrayList<Integer>();
```

**After Java 7:**
```java
Map<String, List<String>> employeeRecords = new HashMap<>();
List<Integer> primes = new ArrayList<>();
```

### 2) **String in Switch**
Java 7 allows you to use `String` as a case selector in a `switch` statement. This improves readability and performance compared to using `if-else` chains.

**Example:**
```java
String state = "NEW";
switch (state) {
    case "NEW": System.out.println("Order is in NEW state"); break;
    case "CANCELED": System.out.println("Order is Cancelled"); break;
    default: System.out.println("Invalid state");
}
```

### 3) **Automatic Resource Management (Try-With-Resources)**
Java 7 introduced a feature that automatically closes resources (like files or database connections) when they're no longer needed, reducing boilerplate code and preventing resource leaks.

**Before Java 7:**
```java
FileInputStream fin = null;
BufferedReader br = null;
try {
    fin = new FileInputStream("info.xml");
    br = new BufferedReader(new InputStreamReader(fin));
    String line = br.readLine();
    System.out.println(line);
} finally {
    if (fin != null) fin.close();
    if (br != null) br.close();
}
```

**After Java 7 (Try-With-Resources):**
```java
try (FileInputStream fin = new FileInputStream("info.xml");
     BufferedReader br = new BufferedReader(new InputStreamReader(fin))) {
    String line = br.readLine();
    System.out.println(line);
} catch (IOException ex) {
    ex.printStackTrace();
}
```

### 4) **Fork-Join Framework**
The Fork-Join framework provides an easy way to parallelize tasks, utilizing multiple processors to improve performance in multi-core systems.

**Example (RecursiveTask):**
```java
ForkJoinPool pool = new ForkJoinPool();
RecursiveTask<Integer> task = new RecursiveTask<>() {
    @Override
    protected Integer compute() {
        return 1 + 1; // Simple example of a recursive task
    }
};
int result = pool.invoke(task);
System.out.println(result); // 2
```

### 5) **Underscore in Numeric Literals**
In Java 7, underscores can be used in numeric literals to improve readability (e.g., for large numbers or financial calculations).

**Example:**
```java
int billion = 1_000_000_000;
long creditCardNumber = 1234_5678_9012_3456L;
double pi = 3.1415_9265;
```

### 6) **Catching Multiple Exception Types in One Catch Block**
In Java 7, you can catch multiple exception types in a single `catch` block using the `|` (pipe) operator.

**Example:**
```java
try {
    // some code that may throw multiple exceptions
} catch (IOException | SQLException ex) {
    ex.printStackTrace();
}
```

### 7) **Binary Literals with Prefix `0b`**
Java 7 introduced the ability to define binary literals using the `0b` or `0B` prefix, similar to other languages like C++.

**Example:**
```java
int mask = 0b0101_1100;
```

### 8) **Java NIO 2.0 (New File I/O API)**
Java 7 introduced a new set of APIs in the `java.nio.file` package, which offers more powerful file handling capabilities, such as better file path handling and directory watching.

**Example (Path API):**
```java
Path path = Paths.get("myfile.txt");
if (Files.exists(path)) {
    System.out.println("File exists!");
}
```

### 9) **G1 Garbage Collector**
The G1 garbage collector (introduced in Java 7) is designed for applications with large heap sizes. It's known for providing predictable performance and better memory management, especially in multi-core systems.

### 10) **More Precise Rethrowing of Exceptions**
Java 7 allows you to be more specific when rethrowing exceptions, making the code cleaner and more maintainable by catching only the required exception types.

**Before Java 7 (imprecise rethrow):**
```java
try {
    // some code
} catch (Exception ex) {
    throw ex; // Could be any type of Exception
}
```

**After Java 7 (precise rethrow):**
```java
try {
    // some code
} catch (IOException | ParseException ex) {
    throw ex; // Now you can rethrow specific types
}
```

---

These features all aimed to improve code readability, reduce boilerplate, and provide better performance and resource management. While many developers may focus on the newer features introduced in Java 8, revisiting these Java 7 features can make a noticeable difference in the quality and clarity of your codebase.

It looks like you're referencing a list of Java 8 tutorials to help readers dive deeper into the new features introduced in Java 8. Here’s a structured list of those tutorials, which can be quite helpful for Java developers looking to explore the core concepts of Java 8:

---

### **Related Java 8 Tutorials**

If you're interested in learning more about the new features in Java 8, check out these tutorials and articles that cover important concepts and practical examples:

1. **[20 Examples of Date and Time in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - Learn how to use the new `java.time` package in Java 8 to handle date and time more efficiently, replacing the older `java.util.Date` and `java.util.Calendar`.

2. **[How to Use the Stream Class in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - Explore how the `Stream` API helps process collections of objects in a functional style, allowing for operations like filtering, mapping, and reducing.

3. **[How to Use the `filter()` Method in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - A tutorial on using the `filter()` method to create a stream that includes only elements that satisfy a given predicate.

4. **[How to Use the `forEach()` Method in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - Learn how to apply the `forEach()` method to perform actions on each element of a stream or collection.

5. **[How to Join Strings in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - A guide on using the `String.join()` method introduced in Java 8 to join strings with a delimiter.

6. **[How to Convert List to Map in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - Learn how to convert a `List` to a `Map` using the `Collectors.toMap()` method from the `Stream` API.

7. **[How to Use the `peek()` Method in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - A tutorial on using the `peek()` method to perform intermediate operations without modifying the stream, useful for debugging.

8. **[5 Books to Learn Java 8 from Scratch](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - A collection of books that provide a thorough understanding of Java 8, including topics like lambdas, streams, and new date/time API.

9. **[How to Convert Stream to Array in Java 8](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
   - Learn how to convert a `Stream` into an array using the `toArray()` method in Java 8.

10. **[Java 8 Certification FAQ](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
    - A guide to help you prepare for the Java 8 certification exam, answering frequently asked questions and providing exam tips.

11. **[Java 8 Mock Exams and Practice Test](https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb)**
    - Practice Java 8 concepts with mock exams and practice questions to solidify your understanding of the new features.

---

These resources should give you a solid foundation for mastering Java 8 and its new features like lambdas, streams, and the new `java.time` API. Each tutorial is designed to help you understand the practical applications and nuances of these features, making your Java programming more efficient and modern.

## Java FileReader + BufferedReader Example

There are multiple ways to read a file in Java e.g. you can use a Scanner as we have seen in the last example, or you can use the BufferedReader class. The advantage of using a BufferedReader to read a text file is speed. It allows faster reading because of internal buffering provided by BufferedReader. Other Reader classes like FileReader access the file or disk every time you call the read() method but BufferedReader keeps 8KB worth of data in its internal buffer which you can read it without accessing the file multiple times. It's loaded when you access the file the first time for a subsequent read.

 The BufferedReader class is also a good example of a Decorator design pattern because it decorates existing readers e.g. FileReader to provide buffering, remember, the reading from file functionality still comes from the FileReader class.



One more advantage of using the BufferedReader for reading a text file is its ability to read the file line by line. It provides a readLine() method which can be used to read a text file line by line in Java.

The java.io.BufferedReader class provides 4 versions of the read() method to read data from a text file
- `read()` - to read a single character, this method returns an int, so you need to cast that to a character
- `read(char[] cbuf)` - to read characters into an array. This method will block until some input is available, an I/O error occurs, or the end of the stream is reached. This method either returns the number of characters read or -1 if the end of the file has been reached. The method comes from the Reader class.
- `read(CharBuffer cbuffer)` - to read characters into a CharBuffer, this is similar to the previous method except that it reads characters into a CharBuffer object instead of the array. This method also returns a total number of characters read or -1 if the end of the file has been reached. This method also belongs to java.io.Reader class.
- `read(char[] cbuf, int off, int len)` - to read characters into an array but gives you control where to store the characters read from a file. You can specify offset i.e. the indices to start and length, how many characters to store.
- `readLine()` - to read a line of text. You can use this method to read a file line by line in Java. A line is considered to be terminated by any one of a line feed ('\n'), a carriage return ('\r'), or a carriage return followed immediately by a line feed. This method returns a string containing the contents of the line, not including any line-termination characters, or null if the end of the stream has been reached. Many Java developer uses BufferedReader class just for this method.

Btw, from Java 8 onwards there are many ways to read a file line by line in Java e.g. you can use Files.lines() method to get all lines as Stream in Java and then you cannot only read them line by line but also you can also use Stream operations e.g. map(), flatMap(), filter(), etc to perform useful operations.

If you are not familiar with functional programming and Java 8 see these Java 8 tutorials to learn more about the basics of functional programming with Java 8 syntax.

How to read a text file using FileReader and BufferedReader
Here is our sample Java program to read a plain text file using BufferedReader. In this program, I have shown two examples of BufferedReader class, the first one reads file content into a character array and the second one reads the text file line by line.

If you notice carefully, while converting the character array to String, we have correctly used the offset and length because it might be possible that the array which you are using for storing content, may content dirty data from the previous read, as we are not cleaning it up after every read. 

That's the advantage of using offset and length, you don't need to clear or clean the array.  You can further see these free Java courses to learn more about file reading in Java.

```java
Java BufferedReader Example
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Java Program read a text file using BufferedReader.
 * It allows you to read file line by line or directly
 * into a character array. 
 */
public class BufferedReaderDemo {

  public static void main(String[] args) throws Exception {
    String filename = "newfile.txt";

    // reading text file into array
    try {
      FileReader textFileReader = new FileReader(filename);
      BufferedReader bufReader = new BufferedReader(textFileReader);

      char[] buffer = new char[8096];

      int numberOfCharsRead = bufReader.read(buffer); // read will be from
      // memory
      while (numberOfCharsRead != -1) {
        System.out.println(String.valueOf(buffer, 0, numberOfCharsRead));
        numberOfCharsRead = textFileReader.read(buffer);
      }

      bufReader.close();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // reading file line by line using BufferedReader
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
```
```
Output
[first line] hello
[second line] bye
[first line] hello
[second line] bye
```
You can see from the output that we have successfully read the text file. In the second example, since we have used the try-with-resource construct, you don't need to manually call the close() method of BufferedReader, it will automatically be called by Java. The catch clause is there to catch the IOException thrown by the close() method.


That's all about how to read a text file using BufferedReader in Java. As I said, there are two main reasons to use the BufferedReader class, first the buffering it provides which makes reading efficient, and second the readLine() method it gives, which allows you to read the text file line by line. 

### Java FileReader + BufferedReader Example

In Java, there are several ways to read a file. One of the most efficient ways is using the `BufferedReader` class. Compared to using a simple `FileReader`, `BufferedReader` provides significant performance improvements because it uses internal buffering to minimize the number of file read operations. This is especially useful when reading large files.

The `BufferedReader` class reads data in chunks into memory (default buffer size is 8KB), which reduces the number of I/O operations. This means you can read from the buffer instead of accessing the file repeatedly, making reading faster. Additionally, the `BufferedReader` class has a `readLine()` method that allows reading a file line-by-line, which is often useful when processing text files.

### Advantages of BufferedReader
1. **Efficiency**: BufferedReader improves the performance by buffering the input, meaning fewer read operations are required.
2. **Convenience**: It provides the `readLine()` method to read a file line-by-line, which is not directly available in `FileReader`.
3. **Decorator Pattern**: `BufferedReader` is a good example of the **Decorator** design pattern, as it wraps around existing readers like `FileReader` to provide additional functionality (buffering).

### `read()` Methods in BufferedReader
The `BufferedReader` class provides multiple ways to read data:
- `read()`: Reads a single character and returns an `int`. This value must be cast to a `char`.
- `read(char[] cbuf)`: Reads characters into a character array. Returns the number of characters read or `-1` if the end of the file is reached.
- `read(CharBuffer cbuffer)`: Similar to `read(char[])`, but reads into a `CharBuffer`.
- `read(char[] cbuf, int off, int len)`: Reads characters into an array with specified offset and length.
- `readLine()`: Reads a line of text, excluding line-termination characters. Returns `null` if the end of the file is reached.

### Example: Reading a File Using BufferedReader

Here’s an example that demonstrates how to read a file using `BufferedReader`. This example includes two methods:
1. **Reading into a character array**.
2. **Reading line-by-line**.

```java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Java Program to read a text file using BufferedReader.
 * It allows you to read file content into an array or line by line.
 */
public class BufferedReaderDemo {

  public static void main(String[] args) throws Exception {
    String filename = "newfile.txt";

    // Reading text file into array
    try {
      FileReader textFileReader = new FileReader(filename);
      BufferedReader bufReader = new BufferedReader(textFileReader);

      char[] buffer = new char[8096];  // Creating a buffer with 8KB capacity

      int numberOfCharsRead = bufReader.read(buffer);  // Read the first chunk of data
      while (numberOfCharsRead != -1) {
        System.out.println(String.valueOf(buffer, 0, numberOfCharsRead));  // Convert char array to string
        numberOfCharsRead = bufReader.read(buffer);  // Continue reading
      }

      bufReader.close();  // Close the reader after reading

    } catch (IOException e) {
      e.printStackTrace();
    }

    // Reading file line by line using BufferedReader
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);  // Print each line
        line = br.readLine();  // Read next line
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```

### Output Example:
Assuming `newfile.txt` contains:
```
[first line] hello
[second line] bye
```

The output of the above program would be:
```
[first line] hello
[second line] bye
[first line] hello
[second line] bye
```

### Explanation:
- **First block**: Reads the file content into a character array of size 8096 and prints the content as a string. The buffer size is large enough to hold multiple characters, and `read()` keeps reading from the file until the end of the file is reached (`-1`).
- **Second block**: Reads the file line by line using `readLine()`. The `try-with-resources` statement ensures that the `BufferedReader` is automatically closed when done.

### Key Points:
1. **Buffering**: The internal buffering makes it more efficient than `FileReader` alone, which accesses the file each time you read a character.
2. **Line-by-Line Reading**: `readLine()` simplifies reading files line by line, which is common when processing text data.
3. **Automatic Resource Management**: With the `try-with-resources` statement, the `BufferedReader` is automatically closed without needing explicit code to close it, reducing the risk of resource leaks.

### Conclusion
Using `BufferedReader` is an excellent choice for reading large files or when you need to read data line-by-line. It provides efficiency due to internal buffering and convenience with methods like `readLine()`. If you're working with text files in Java, this is often the most recommended approach.

For more modern Java (Java 8 and later), you can also consider using the `Files.lines()` method to read files into streams, which can be processed with functional programming techniques like `map()`, `filter()`, and `forEach()`.

### Related Java File Tutorials You May Like

If you're interested in more file handling examples in Java, here are some related tutorials that can help you work with files effectively in various ways:

1. **How to Write to a File Using BufferedWriter in Java?**  
   Learn how to use the `BufferedWriter` class to write data to a file. This tutorial will show you how to buffer your output and improve performance when writing large amounts of data to a file.  
   [Read more](https://www.java67.com/2016/08/how-to-write-to-file-using-bufferedwriter-in-java.html)

2. **How to Append Text to a File in Java?**  
   This tutorial explains how to append new content to an existing file, ensuring that new data is added at the end of the file instead of overwriting it.  
   [Read more](https://www.java67.com/2016/08/how-to-append-text-to-file-in-java.html)

3. **2 Ways to Read a Text File in Java?**  
   Here, you will find two different approaches to reading text files in Java: one using `BufferedReader` and the other using `Scanner`. The tutorial compares both methods.  
   [Read more](https://www.java67.com/2016/08/2-ways-to-read-a-text-file-in-java.html)

4. **How to Read InputStream as Stream in Java?**  
   Learn how to read an `InputStream` as a `Stream` in Java, which can be useful for processing large amounts of data efficiently in a functional style.  
   [Read more](https://www.java67.com/2016/08/how-to-read-inputstream-as-stream-in-java.html)

5. **How to Load Data from a CSV File in Java?**  
   This tutorial demonstrates how to read data from a CSV file and process it. It provides code examples for parsing CSV data in Java using simple libraries and methods.  
   [Read more](https://www.java67.com/2016/08/how-to-load-data-from-csv-file-in-java.html)

6. **How to Find the Highest Occurring Word from a File in Java?**  
   Discover how to read a file and identify the most frequently occurring word using Java's file I/O and data structures like `HashMap` and `Stream`.  
   [Read more](https://www.java67.com/2016/08/how-to-find-highest-occurring-word-from-file-in-java.html)

7. **How to Read/Write an XLSX File in Java?**  
   This guide shows you how to read and write to `.xlsx` files using libraries like Apache POI. It’s essential for working with Excel files in Java.  
   [Read more](https://www.java67.com/2016/08/how-to-readwrite-an-xlsx-file-in-java.html)

---

### Java 8 - Use Streams to Read Files

If you're using **Java 8 or later**, you can also take advantage of the `Files.lines()` method. This method returns a `Stream<String>` representing the lines of a file. You can then process these lines using functional operations like `map()`, `filter()`, and `forEach()`. This is a powerful way to process files lazily and efficiently, especially when dealing with large datasets.

Example:
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileWithStreams {
    public static void main(String[] args) {
        String filename = "newfile.txt";

        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            lines.filter(line -> line.contains("hello"))  // Example: filter lines containing 'hello'
                 .forEach(System.out::println);  // Print each line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, the file is read lazily, meaning the entire file is not loaded into memory at once. You can filter and process the data as you read each line.

---

**P.S.** If you're still working with earlier versions of Java (pre-Java 8), the traditional `BufferedReader` approach works great. But if you want to explore more efficient, modern methods of handling files, Java 8's `Streams` provide a powerful, functional-style approach for working with large files and datasets.

### How to Read a File in Java Using the `Scanner` Class

In this tutorial, we’ll discuss how to read files in Java using the `Scanner` class, which has been available since **Java 5**. The `Scanner` class is part of the `java.util` package and is typically used for parsing primitive types and strings from different input sources, including files. It's a very convenient and flexible option for reading files because you can specify custom delimiters to read data in various formats.

#### Advantages of Using `Scanner`:
- **Flexibility**: You can easily change delimiters (default is whitespace) to other characters such as commas or pipes using the `useDelimiter()` method.
- **Convenience**: Provides methods to read various data types like `int`, `double`, `String`, etc.
- **Simple to Use**: It doesn’t require complex setup compared to some other classes for file reading.

### How to Read a File Using `Scanner` – Example Code

Below is an example program that demonstrates how to read a text file line by line using the `Scanner` class in Java.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Java program to read files using the Scanner class in Java.
 * The java.util.Scanner class was added in Java 5 and offers a convenient method to read data.
 */
public class ScannerExample {

    public static void main(String args[]) throws FileNotFoundException {

        // Creating a File instance to reference the text file
        File textFile = new File("C:/temp/test.txt");

        // Creating a Scanner instance to read the file
        Scanner scanner = new Scanner(textFile);

        // Reading each line of the file using Scanner
        int lineNumber = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Line " + lineNumber + ": " + line);
            lineNumber++;
        }

        // Close the scanner to avoid resource leakage
        scanner.close();
    }
}
```

### Output Example:

Assuming the `test.txt` file contains the following text:

```
--------------------- START------
-----------------------------------------------
Java provides several ways to read files.
You can read a file using Scanner, FileReader,
FileInputStream, and BufferedReader.
This Java program shows how to read a file using java.util.Scanner.
--------------------- END-----------------------
---------------------------------
```

The output of the program will look like this:

```
Line 1: --------------------- START------
-----------------------------------------------
Line 2: Java provides several ways to read files.
Line 3: You can read a file using Scanner, FileReader,
Line 4: FileInputStream, and BufferedReader.
Line 5: This Java program shows how to read a file using java.util.Scanner.
Line 6: --------------------- END-----------------------
---------------------------------
```

### Explanation of the Code:
1. **File Instance**: A `File` object is created to represent the text file. The file path is provided as an argument (`C:/temp/test.txt`).
   
2. **Scanner Instance**: A `Scanner` instance is created with the file as the source. This allows us to read the file.

3. **Reading Lines**: The `Scanner` object reads each line of the file using the `nextLine()` method inside a `while` loop. The loop continues as long as there are more lines in the file (checked using `hasNextLine()`).

4. **Line Numbers**: A `lineNumber` variable is used to display which line of the file is being read.

5. **Closing the Scanner**: It’s important to close the `Scanner` object after reading the file to release system resources.

### Why Use `Scanner` for File Reading?

- **Convenient**: No need to deal with byte streams or manual buffering. The `Scanner` class handles it for you.
- **Customizable Delimiters**: You can specify custom delimiters (like commas or semicolons) to read files formatted in CSV or other delimited formats.
- **Supports Different Data Types**: `Scanner` can be used to read different data types (`String`, `int`, `double`, etc.), making it more versatile than traditional file reading methods like `BufferedReader`.

### Handling Exceptions
If the file doesn’t exist or there are issues opening it, a `FileNotFoundException` will be thrown. Always handle exceptions properly by using `throws` or a `try-catch` block.

```java
try {
    File textFile = new File("C:/temp/test.txt");
    Scanner scanner = new Scanner(textFile);
    while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
    }
    scanner.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```

### Other File IO Tutorials You May Find Helpful

1. **How to Write to a File Using `BufferedWriter`**  
   Learn how to use `BufferedWriter` for writing data to a file efficiently.

2. **How to Append Text to a File**  
   This tutorial shows how to append text to an existing file without overwriting its content.

3. **Reading a File Line by Line with `BufferedReader`**  
   Discover how to read a file line by line with `BufferedReader` for more performance-oriented tasks.

4. **How to Read a CSV File in Java**  
   Learn how to load and process data from a CSV file in Java.

5. **How to Parse and Read an XML File in Java**  
   This tutorial covers how to parse XML files using both DOM and SAX parsers in Java.

6. **How to Work with Properties Files**  
   Properties files are often used for configuration settings in Java. Learn how to read and write properties files in both text and XML formats.

---

### Conclusion

The `Scanner` class in Java is a straightforward and effective way to read text files. It’s a great choice for simpler file reading tasks, especially when you need flexibility in how data is parsed (using custom delimiters) or when you need to handle various data types from the file. For more complex tasks or larger files, you may want to consider other I/O classes such as `BufferedReader` or `Files.lines()` for Java 8 and later.

How to read XML File in Java
Here are a couple of ways to parse an XML file in Java. You will learn how to use JAXP and DOM parser to load the XML file in Java

1. JAXP - Java API for XML Parsing
Java provides extensive support for reading XML file, writing XML file and accessing any element from XML file. All XML parsing related classes and methods are inside JAXP. Though DOM related code comes from org.w3c.dom package. All XML parsers are in javax.xml.parsers package.we will see example of parsing xml files using JAXP API in next section.



2. Parse XML File in Java using DOM Parser
In this section, we will see how to parse xml files or how to read xml file using DOM XML Parser.DOM is a quick and easy way to parse xml files in Java and if you are doing it for testing its way to go. 

The only thing to concern is that XML files that need to be parsed must not be too large. You can also create xml file by using DOM parser and DocumentFactory Class in Java.

XML file for parsing in Java
Here is xml file Stocks.xml which contains some stocks and there price, quantity we will use this in our xml parsing example in Java.

<?xml version="1.0" encoding="UTF-8"?>
<stocks>
       <stock>
              <symbol>Citibank</symbol>
              <price>100</price>
              <quantity>1000</quantity>
       </stock>
       <stock>
              <symbol>Axis bank</symbol>
              <price>90</price>
              <quantity>2000</quantity>
       </stock>
</stocks>


3. Code Example of Parsing XML File in Java using DOM Parser
how to read or parse xml file in javaHere is a code example of parsing above xml file in Java using DOM parser:


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMExampleJava {

public static void main(String args[]) {
try {

File stocks = new File("Stocks.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(stocks);
doc.getDocumentElement().normalize();

System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());
NodeList nodes = doc.getElementsByTagName("stock");
System.out.println("==========================");

for (int i = 0; i < nodes.getLength(); i++) {
Node node = nodes.item(i);

if (node.getNodeType() == Node.ELEMENT_NODE) {
Element element = (Element) node;
System.out.println("Stock Symbol: " + getValue("symbol", element));
System.out.println("Stock Price: " + getValue("price", element));
System.out.println("Stock Quantity: " + getValue("quantity", element));
}
}
} catch (Exception ex) {
ex.printStackTrace();
}
}

private static String getValue(String tag, Element element) {
NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
Node node = (Node) nodes.item(0);
return node.getNodeValue();
}
}

Output:

root of xml file stocks
==========================
Stock Symbol: Citibank
Stock Price: 100
Stock Quantity: 1000
Stock Symbol: Axis bank
Stock Price: 90
Stock Quantity: 2000


That’s all on xml parsing in java for now. We have seen how to read and write xml files in Java and are now familiar with both DOM and SAX Parser in java. We will see more on xml in the coming days like reading xml elements via XPath and using xml beans etc. let me know if you have any doubt on xml parsing examples or in general with xml and Java.


Read more: https://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html#ixzz8hiY4ilia

How to read from and write to a text file in Java - Example Tutorial

Java has excellent support for reading from file and writing to file in Java. In the last post, we have seen how to create files and directories in Java and now we will see how to read content from files in java and how we will write text into file in Java. File provides a persistent solution to Java developers; in almost every Java application you need to store some of the data in persistent may be its user configuration, system configuration or related to state of the application but without persistence, no enterprise Java application can buildup. 


Normally Database is the preferred choice for storing data persistently but in high-frequency trading one doesn’t have the liberty to afford network latency to travel database and latency introduced by the database itself.

Though databases still offer the best choice for historical data, transactional details related to orders and trades are commonly stored in In-Memory files provided by Java.nio API.

Java NIO API also provides a faster way to read and write from a file in Java using FileChannel, after looking this way you can also try reading file using NIO API and FileChannel by following that example. 




How to read and write from a text file in Java
Though in this java file tutorial we are not talking about In Memory files, we will discuss plain old File classes and how to read and write into File in Java by using java.io package classes.

If we are working on a Standalone application then we have access to local file system and we can easily using the java API read and write on files, but we if we our application is running on browser based system then this will not work. If we are using input and output stream for reading and writing it’s very easy to understand. We have to follow three simple steps to achieve this task.

Ø       First get the File object
Ø       Create the File Stream from File object
Ø       Use this File Stream for reading or writing the data to the file in the file system.



Apart from this we need to remember some points which should be taken care at the time of reading and writing to the file in Java.

Ø       Always try to use reference of abstract classes or interfaces in place of implemented class or we can say concrete class it is a one of the good java practice also.
Ø       If needed use buffering  it’s a good practice because calling a read() method for single byte JVM will call the native operating system method and  calling a operating system method is expensive so Buffering will reduce this overhead from some extent.
Ø       If using buffer then mentions the buffer size also it will affect the read time and CPU time also.
Ø       Always Handle the Exceptions (IOException and FileNotFoundException)
Ø       Don’t forget to call close() method for resource which we are using such as File or Directory in Java. You can also use automatic resource management in JDK7 to automatically close any open resource in Java.


How to read from and write to a text file in Java - Example Tutorial



File read and write Example in Java
read and writ from text file in JavaNow we see a simple example of reading and writing binary data to a file in Java.


class FileStreamsReadnWrite {
public static void main(String[] args) {
try {
File stockInputFile = new File("C://stock/stockIn.txt");
File StockOutputFile = new File("C://stock/StockOut.txt");

                     /*
                      * Constructor of FileInputStream throws FileNotFoundException if
                      * the argument File does not exist.
                      */

FileInputStream fis = new FileInputStream(stockInputFile);
FileOutputStream fos = new FileOutputStream(StockOutputFile);
                     int count;

                     while ((count = fis.read()) != -1) {
                           fos.write(count);
                     }
                     fis.close();
                     fos.close();
              } catch (FileNotFoundException e) {
                     System.err.println("FileStreamsReadnWrite: " + e);
              } catch (IOException e) {
                     System.err.println("FileStreamsReadnWrite: " + e);
              }
       }
}



This is a very simple example where we are reading from stockInputfile and whatever contents are there we are writing that to stockoutput file one important point here is that FileInputStream should not be used to read character data file. It is meant for reading binary data such as an image file.

That’s all on how to read from a file in Java and writing data into a file in Java. It’s very important to understand the java.io package to get mastery in java and the best way is to write examples and simple programs and understand concepts.


Read more: https://javarevisited.blogspot.com/2011/12/read-and-write-text-file-java.html#ixzz8hiYNpsde

How to Change File Permissions in Java – Example Tutorial

Hello guys, In the last article, we saw how to check whether an application can access the file and perform any read-write or execute an operation on that file by using the inbuilt method provided by File Object. Now we deal with some more methods of file class which will use to provide some privileges to users so that they can perform read, write, and execute operations on the particular file. There are few more methods added with the new File API in Java 7, but in this tutorial, we will only learn about traditional ways to change the permission of a file from the Java program, which should work on all versions of JDK.

### Summary: How to Work with File Permissions in Java

Java provides built-in methods to set file permissions, such as read, write, and execute permissions. These methods can be used on both files and directories. Below, I’ll summarize how to set each of these permissions and give a simple example for each.

#### 1. **Setting Execute Permission on a File**
   - **Method:** `boolean setExecutable(boolean exe)` and `boolean setExecutable(boolean exe, boolean ownerOnly)`
   - **Usage:**
     - The first method grants or revokes execute permission to the owner of the file.
     - The second method can set execute permission for everyone or just the owner.
   - **Example Code:**
     ```java
     import java.io.File;

     public class SetExecuteTest {
         public static void main(String[] args) {
             File file = new File("C:/setExecuteTest.txt");

             if (file.exists()) {
                 boolean result = file.setExecutable(true);  // owner only
                 System.out.println("Set the owner's execute permission: " + result);
             } else {
                 System.out.println("File does not exist.");
             }

             if (file.exists()) {
                 boolean result = file.setExecutable(true, false);  // everyone
                 System.out.println("Set everyone's execute permission: " + result);
             } else {
                 System.out.println("File does not exist.");
             }
         }
     }
     ```

#### 2. **Setting Write Permission on a File**
   - **Method:** `boolean setWritable(boolean writable)` and `boolean setWritable(boolean writable, boolean ownerOnly)`
   - **Usage:**
     - The first method sets or revokes write permission for the owner of the file.
     - The second method sets write permission for everyone or just the owner.
   - **Example Code:**
     ```java
     import java.io.File;

     public class SetWritableTest {
         public static void main(String[] args) {
             File file = new File("C:/setWriteableTest.txt");

             if (file.exists()) {
                 boolean result = file.setWritable(true);  // owner only
                 System.out.println("Set the owner's write permission: " + result);
             } else {
                 System.out.println("File does not exist.");
             }

             if (file.exists()) {
                 boolean result = file.setWritable(true, false);  // everyone
                 System.out.println("Set everyone's write permission: " + result);
             } else {
                 System.out.println("File does not exist.");
             }
         }
     }
     ```

#### 3. **Setting Read Permission on a File**
   - **Method:** `boolean setReadable(boolean readable)` and `boolean setReadable(boolean readable, boolean ownerOnly)`
   - **Usage:**
     - The first method sets or revokes read permission for the owner of the file.
     - The second method sets read permission for everyone or just the owner.
   - **Example Code:**
     ```java
     import java.io.File;

     public class SetReadableTest {
         public static void main(String[] args) {
             File file = new File("C:/setReadableTest.txt");

             if (file.exists()) {
                 boolean result = file.setReadable(true);  // owner only
                 System.out.println("Set the owner's read permission: " + result);
             } else {
                 System.out.println("File does not exist.");
             }

             if (file.exists()) {
                 boolean result = file.setReadable(true, false);  // everyone
                 System.out.println("Set everyone's read permission: " + result);
             } else {
                 System.out.println("File does not exist.");
             }
         }
     }
     ```

#### 4. **Making a File or Directory Read-Only**
   - **Method:** `boolean setReadOnly()`
   - **Usage:** This method makes the file or directory read-only, preventing any modifications.
   - **Example Code:**
     ```java
     import java.io.File;

     public class SetReadOnlyTest {
         public static void main(String[] args) {
             File file = new File("C:/setReadOnlyTest.txt");

             if (file.exists()) {
                 boolean result = file.setReadOnly();
                 System.out.println("File set to read-only: " + result);
             } else {
                 System.out.println("File does not exist.");
             }
         }
     }
     ```

---

### **Storing Passwords Securely in Java: Why Use `char[]` Over `String`?**

In Java, storing sensitive information such as passwords requires caution. While `String` is commonly used to store text, it’s not ideal for sensitive data due to its immutability. This means once a password is stored as a `String`, it cannot be erased from memory.

**Key Reasons to Use `char[]` for Passwords:**
1. **Immutability of Strings**: Since strings in Java are immutable, once a password is assigned to a `String`, it stays in memory until it is garbage-collected. This can be risky, as the password could be exposed in a memory dump.
2. **Ability to Erase**: Unlike `String`, `char[]` is mutable, meaning you can modify or wipe its contents explicitly. After processing the password, you can zero out the array to ensure it’s not lingering in memory.
3. **JPasswordField**: Java's `JPasswordField` uses `char[]` for this reason and discourages the use of `getText()` (which returns a `String`) for passwords.

**Example Code:**
```java
// Using String (unsafe):
String password = "secret";

// Using char[] (secure):
char[] password = new char[] {'s', 'e', 'c', 'r', 'e', 't'};

// Securely clear password:
java.util.Arrays.fill(password, '0');
```

---

### **Lambda Expressions vs Anonymous Classes in Java**

Lambda expressions were introduced in Java 8 to simplify the syntax of anonymous classes. They allow for more concise and readable code, especially when passing a block of code as a parameter.

#### **Example: Sorting a List with `Comparator`**
In Java 7 and earlier, you’d use an anonymous class to define the comparator for sorting:
```java
Collections.sort(books, new Comparator<Book>() {
    public int compare(Book b1, Book b2) {
        return b1.price - b2.price;
    }
});
```
With Java 8, you can simplify this with a lambda expression:
```java
books.sort((b1, b2) -> b1.price - b2.price);
```
#### **Why Use Lambda Expressions?**
1. **Conciseness**: Lambda expressions remove the boilerplate code, making it easier to read and write.
2. **Reduced Memory Usage**: With lambda expressions, there’s no need to create a new class for each instance.
3. **Functional Style**: Lambda expressions support functional-style programming, making your code more expressive.

---

### **Sorting a Map by Keys in Java 8**

To sort a `Map` by keys, you can use the `Stream` API and collect the results into a `LinkedHashMap` to maintain order.

#### **Example: Sorting a Map by Keys**
```java
import java.util.*;

Map<String, Integer> budget = new HashMap<>();
budget.put("grocery", 150);
budget.put("utility", 130);
budget.put("miscellaneous", 90);
budget.put("rent", 1150);
budget.put("clothes", 120);
budget.put("transportation", 100);

Map<String, Integer> sorted = budget.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByKey())
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (e1, e2) -> e2, LinkedHashMap::new));

System.out.println("Sorted Map: " + sorted);
```
This will sort the `Map` by its keys and store the result in a `LinkedHashMap` to preserve the order.

---

### Conclusion

This tutorial covered how to work with file permissions (read, write, and execute) in Java, the benefits of using `char[]` over `String` for sensitive data, replacing anonymous classes with lambda expressions, and sorting a `Map` by keys in Java 8. By leveraging these methods and best practices, you can write more secure, efficient, and readable Java code.

### 6 Steps to Sort a Map by Keys in Java 8

Sorting a `Map` by keys in Java 8 is a straightforward process with the help of the Stream API. Here's a detailed breakdown of the steps:

1. **Get All Entries from the Map:**
   - Use the `entrySet()` method to obtain a `Set` view of the key-value pairs in the map.

2. **Create a Stream from the Set:**
   - Use the `stream()` method to create a stream of the map's entries, as `Set` inherits from `Collection`.

3. **Sort the Stream by Keys:**
   - Use the `sorted()` method to sort the entries. To sort by keys, you will use the `Map.Entry.comparingByKey()` comparator, which compares the map's keys in their natural order.

4. **Provide a Comparator (Optional for Custom Sorting):**
   - If you want to customize the sorting order, provide a comparator to the `sorted()` method. The `Map.Entry.comparingByKey()` method can be enhanced with a custom comparator.

5. **Collect the Results into a LinkedHashMap:**
   - Use the `collect()` method from the Stream API to gather the sorted entries into a `LinkedHashMap`. The `LinkedHashMap` preserves the order of insertion, making it ideal for this use case.

6. **Use `Collectors.toMap()` to Collect Entries:**
   - `Collectors.toMap()` collects the entries into a map. The method accepts key and value mapping functions and allows for handling key collisions if necessary.

### Java Code Example

Here’s a full Java program that demonstrates sorting a map by keys in ascending and descending order using Java 8 features:

```java
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class Java8MapSortExample {

    public static void main(String[] args) {
        
        // Step 1: Create a sample Map
        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellaneous", 90);

        System.out.println("Map before sorting: " + budget);

        // Step 2-6: Sort the map by keys in ascending order
        Map<String, Integer> sorted = budget
            .entrySet()
            .stream()
            .sorted(comparingByKey()) // Ascending order by default
            .collect(
                toMap(
                    Map.Entry::getKey, 
                    Map.Entry::getValue, 
                    (e1, e2) -> e2, 
                    LinkedHashMap::new
                )
            );

        System.out.println("Map after sorting by keys in ascending order: " + sorted);

        // Step 2-6: Sort the map by keys in descending order
        sorted = budget
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(comparingByKey())) // Descending order
            .collect(
                toMap(
                    Map.Entry::getKey, 
                    Map.Entry::getValue, 
                    (e1, e2) -> e2, 
                    LinkedHashMap::new
                )
            );

        System.out.println("Map after sorting by keys in descending order: " + sorted);
    }
}
```

### Output

```
Map before sorting: {grocery=150, utility=130, miscellaneous=90, rent=1150, clothes=120, transportation=100}
Map after sorting by keys in ascending order: {clothes=120, grocery=150, miscellaneous=90, rent=1150, transportation=100, utility=130}
Map after sorting by keys in descending order: {utility=130, transportation=100, rent=1150, miscellaneous=90, grocery=150, clothes=120}
```

### Explanation:

1. **Original Map:** 
   - Before sorting, the `Map` is unordered.
   
2. **Sorting by Keys (Ascending Order):**
   - The map entries are sorted based on the natural order of the keys, which are strings. In ascending order, "clothes" comes first, followed by "grocery," "miscellaneous," etc.
   
3. **Sorting by Keys (Descending Order):**
   - The map entries are sorted by keys in descending order using `Collections.reverseOrder()`. In this case, "utility" comes first, followed by "transportation," "rent," and so on.

### Key Points:
- **Natural Ordering:** By default, `Map.Entry.comparingByKey()` compares the keys using their natural ordering (e.g., alphabetically for strings).
- **Custom Ordering:** You can provide a custom comparator to `comparingByKey()` if you want to change the sorting order (e.g., by the length of the strings, case-insensitive, etc.).
- **LinkedHashMap:** The use of `LinkedHashMap` ensures that the order of the entries is preserved after sorting.

This approach leverages the full power of Java 8's Stream API and lambda expressions to create clean, concise, and readable code for sorting maps by keys.


Certainly! Below are Java Stream API-based solutions for the given problems:

### 1. **Fibonacci Series**  
```java
import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;  // Example input
        IntStream.range(0, n).map(i -> fib(i)).forEach(System.out::println);
    }

    private static int fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }
}
```

### 2. **Prime Number Check**  
```java
import java.util.stream.IntStream;

public class PrimeCheck {
    public static boolean isPrime(int n) {
        return n > 1 && IntStream.range(2, (int) Math.sqrt(n) + 1).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));  // true
    }
}
```

### 3. **String Palindrome**  
```java
import java.util.stream.IntStream;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        return IntStream.range(0, s.length() / 2)
                        .allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));  // true
    }
}
```

### 4. **Integer Palindrome**  
```java
public class IntegerPalindrome {
    public static boolean isPalindrome(int num) {
        int reversed = 0, original = num;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));  // true
    }
}
```

### 5. **Armstrong Number**  
```java
public class ArmstrongNumber {
    public static boolean isArmstrong(int num) {
        int digits = String.valueOf(num).length();
        int sum = String.valueOf(num).chars()
                                      .map(c -> (int) Math.pow(c - '0', digits))
                                      .sum();
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));  // true
    }
}
```

### 6. **Avoiding Deadlock in Java**  
This involves avoiding deadlocks by acquiring locks in a specific order, which doesn’t directly involve streams, but here's an example of a lock-acquisition order:
```java
class A {
    synchronized void methodA(B b) {
        b.lastMethod();
    }
    synchronized void lastMethod() {}
}

class B {
    synchronized void methodB(A a) {
        a.lastMethod();
    }
    synchronized void lastMethod() {}
}
```

### 7. **Factorial**  
```java
import java.util.stream.LongStream;

public class Factorial {
    public static long factorial(int n) {
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // 120
    }
}
```

### 8. **Reverse a String**  
```java
public class ReverseString {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));  // olleh
    }
}
```

### 9. **Remove Duplicates from an Array**  
```java
import java.util.stream.IntStream;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        return IntStream.of(arr).distinct().toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4};
        for (int num : removeDuplicates(arr)) {
            System.out.print(num + " ");  // 1 2 3 4
        }
    }
}
```

### 10. **Printing Patterns**  
```java
public class PrintPattern {
    public static void printPattern(int n) {
        IntStream.range(1, n + 1)
                 .forEach(i -> System.out.println(" ".repeat(n - i) + "*".repeat(i)));
    }

    public static void main(String[] args) {
        printPattern(5);
    }
}
```

### 11. **Print Repeated Characters of String**  
```java
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedChars {
    public static void printRepeatedChars(String str) {
        str.chars()
           .mapToObj(c -> (char) c)
           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
           .entrySet()
           .stream()
           .filter(entry -> entry.getValue() > 1)
           .forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void main(String[] args) {
        printRepeatedChars("programming");
    }
}
```

### 12. **GCD of Two Numbers**  
```java
import java.util.stream.IntStream;

public class GCD {
    public static int gcd(int a, int b) {
        return IntStream.rangeClosed(1, Math.min(a, b))
                        .filter(i -> a % i == 0 && b % i == 0)
                        .max()
                        .orElse(1);
    }

    public static void main(String[] args) {
        System.out.println(gcd(56, 98));  // 14
    }
}
```

### 13. **Square Root of a Number**  
```java
public class SquareRoot {
    public static double sqrt(double n) {
        return Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(25));  // 5.0
    }
}
```

### 14. **Reverse Array In Place**  
```java
import java.util.stream.IntStream;

public class ReverseArray {
    public static void reverseArray(int[] arr) {
        IntStream.range(0, arr.length / 2)
                 .forEach(i -> {
                     int temp = arr[i];
                     arr[i] = arr[arr.length - 1 - i];
                     arr[arr.length - 1 - i] = temp;
                 });
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");  // 5 4 3 2 1
        }
    }
}
```

### 15. **Reverse Words of a Sentence**  
```java
public class ReverseWords {
    public static String reverseWords(String sentence) {
        return String.join(" ", 
                           java.util.Arrays.stream(sentence.split(" "))
                                            .map(StringBuilder::new)
                                            .map(StringBuilder::reverse)
                                            .map(StringBuilder::toString)
                                            .toArray(String[]::new));
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Hello World"));  // "olleH dlroW"
    }
}
```

### 16. **Leap Year**  
```java
public class LeapYear {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(2024));  // true
    }
}
```

### 17. **Binary Search**  
```java
import java.util.Arrays;

public class BinarySearch {
    public static boolean binarySearch(int[] arr, int target) {
        return Arrays.stream(arr)
                     .anyMatch(i -> i == target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 3));  // true
    }
}
```

### 18. **String Anagram Check**  
```java
import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String s1, String s2) {
        return Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));  // true
    }
}
```

Certainly! Here are Java Stream API-based solutions for problems 19 to 50:

### 19. **Design a Vending Machine**  
This is an object-oriented design problem. The stream API might not be directly applicable, but we can show how to use streams in some part of the design, such as handling item availability or transactions.

```java
import java.util.*;

public class VendingMachine {
    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();

    public VendingMachine() {
        inventory.put("Soda", 10);
        inventory.put("Chips", 10);
        inventory.put("Candy", 10);
        prices.put("Soda", 1.50);
        prices.put("Chips", 1.00);
        prices.put("Candy", 0.75);
    }

    public void purchase(String item) {
        if (inventory.getOrDefault(item, 0) > 0) {
            inventory.put(item, inventory.get(item) - 1);
            System.out.println("Purchased " + item);
        } else {
            System.out.println("Item " + item + " is out of stock.");
        }
    }

    public void displayItems() {
        inventory.entrySet()
                 .stream()
                 .filter(entry -> entry.getValue() > 0)
                 .forEach(entry -> System.out.println(entry.getKey() + ": $" + prices.get(entry.getKey())));
    }

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.displayItems();
        vm.purchase("Soda");
    }
}
```

### 20. **Reverse a Number**  
```java
public class ReverseNumber {
    public static int reverse(int num) {
        return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345));  // 54321
    }
}
```

### 21. **First Non-repeated Character of a String**  
```java
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {
    public static Character firstNonRepeatedCharacter(String str) {
        return str.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                  .entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() == 1)
                  .map(Map.Entry::getKey)
                  .findFirst()
                  .orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("swiss"));  // 'w'
    }
}
```

### 22. **Finding Middle Element of Linked List in One Pass**  
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MiddleElement {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode middle = findMiddle(head);
        System.out.println(middle.val);  // 3
    }
}
```

### 23. **Pre-order Traversal (Binary Tree)**  
```java
import java.util.*;

public class PreOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }

    private static void preOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preOrderHelper(node.left, result);
            preOrderHelper(node.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> result = preOrderTraversal(root);
        System.out.println(result);  // [1, 2, 4, 5, 3]
    }
}
```

### 24. **Pre-order Traversal Without Recursion**  
```java
import java.util.*;

public class PreOrderTraversalIterative {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = preOrderTraversal(root);
        System.out.println(result);  // [1, 2, 3]
    }
}
```

### 25. **In-order Traversal (Binary Tree)**  
```java
import java.util.*;

public class InOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private static void inOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderHelper(node.left, result);
            result.add(node.val);
            inOrderHelper(node.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = inOrderTraversal(root);
        System.out.println(result);  // [2, 1, 3]
    }
}
```

### 26. **In-order Traversal Without Recursion**  
```java
import java.util.*;

public class InOrderTraversalIterative {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = inOrderTraversal(root);
        System.out.println(result);  // [2, 1, 3]
    }
}
```

### 27. **Post-order Traversal (Binary Tree)**  
```java
import java.util.*;

public class PostOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }

    private static void postOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            postOrderHelper(node.left, result);
            postOrderHelper(node.right, result);
            result.add(node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = postOrderTraversal(root);
        System.out.println(result);  // [2, 3, 1]
    }
}
```

### 28. **Post-order Traversal Without Recursion**  
```java
import java.util.*;

public class PostOrderTraversalIterative {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new Array

List<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> output = new Stack<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        while (!output.isEmpty()) {
            result.add(output.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = postOrderTraversal(root);
        System.out.println(result);  // [2, 3, 1]
    }
}
```

### 29. **Check if Binary Tree is Balanced**  
```java
public class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;  // Not balanced
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isBalanced(root));  // true
    }
}
```

### 30. **Check if Binary Tree is Symmetric**  
```java
public class SymmetricTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(isSymmetric(root));  // true
    }
}
```

### 31. **Find Lowest Common Ancestor in Binary Tree**  
```java
public class LowestCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val);  // 3
    }
}
```

### 32. **Count the Number of Set Bits in an Integer**  
```java
public class CountSetBits {
    public static int countSetBits(int num) {
        return Integer.bitCount(num);
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(29));  // 4
    }
}
```

### 33. **Find Missing Number in an Array**  
```java
public class MissingNumber {
    public static int findMissingNumber(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println(findMissingNumber(arr, 6));  // 3
    }
}
```

### 34. **Find All Pairs That Sum to a Specific Target**  
```java
import java.util.*;

public class FindPairs {
    public static void findPairs(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair: (" + complement + ", " + num + ")");
            }
            seen.add(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findPairs(arr, 5);  // Pair: (2, 3) Pair: (1, 4)
    }
}
```

### 35. **Find the Majority Element in an Array**  
```java
import java.util.*;

public class MajorityElement {
    public static int majorityElement(int[] arr) {
        int candidate = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = arr[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(majorityElement(arr));  // 4
    }
}
```

### 36. **Sort an Array of 0s, 1s, and 2s (Dutch National Flag Problem)**  
```java
public class Sort012 {
    public static void sort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low++, mid++);
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high--);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 0, 2};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");  // 0 0 1 1 2 2
        }
    }
}
```

### 37. **Find the First Duplicate in an Array**  
```java
import java.util.HashSet;

public class FirstDuplicate {
    public static int findFirstDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;  // No duplicates
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5};
        System.out.println(findFirstDuplicate(arr));  // 2
    }
}
```

### 38. **Find the Peak Element in an Array**  
```java
public class PeakElement {
    public static int findPeakElement(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return arr[0] > arr[arr.length - 1] ? arr[0] : arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1};
        System.out.println(findPeakElement(arr));  // 20
    }
}
```

### 39. **Find the Longest Substring Without Repeating Characters**  
```java
import java.util.*;

public class LongestSubstring {
    public static

 int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));  // 3
    }
}
```

### 40. **Find the Longest Palindromic Substring**  
```java
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));  // "bab"
    }
}
```

### 41. **Find All Anagrams in a String**  
```java
import java.util.*;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (sMap.equals(pMap)) result.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            sMap.put(s.charAt(i - p.length()), sMap.get(s.charAt(i - p.length())) - 1);
            if (sMap.get(s.charAt(i - p.length())) == 0) sMap.remove(s.charAt(i - p.length()));

            if (sMap.equals(pMap)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));  // [0, 6]
    }
}
```

### 42. **Find Duplicate Subtrees in a Binary Tree**  
```java
import java.util.*;

public class DuplicateSubtrees {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        serialize(root, map, result);
        return result;
    }

    private static String serialize(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) return "#";

        String left = serialize(node.left, map, result);
        String right = serialize(node.right, map, result);

        String subTree = left + "," + right + "," + node.val;

        map.put(subTree, map.getOrDefault(subTree, 0) + 1);
        if (map.get(subTree) == 2) result.add(node);

        return subTree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        
        List<TreeNode> duplicates = findDuplicateSubtrees(root);
        System.out.println(duplicates.size());  // 2
    }
}
```

### 43. **Merge Intervals**  
```java
import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));  // [1, 6] [8, 10] [15, 18]
        }
    }
}
```

### 44. **Find the Kth Largest Element in an Array**  
```java
import java.util.*;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));  // 5
    }
}
```

### 45. **Find the Subarray with the Maximum Sum**  
```java
public class MaxSubarraySum {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));  // 6
    }
}
```

### 46. **Find the Longest Increasing Subsequence**  
```java
import java.util.*;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));  // 4
    }
}
```

### 47. **Find the Longest Common Subsequence**  
```java
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else

 {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));  // 3
    }
}
```

Here are solutions for problems 48 to 50 using Java:

### 48. **Bucket Sort**  
```java
import java.util.*;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        if (arr == null || arr.length <= 1) return;

        // Step 1: Create empty buckets
        int n = arr.length;
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new List[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 2: Put elements in different buckets
        for (float num : arr) {
            int index = (int) (num * n); // Multiply by n to find the bucket
            buckets[index].add(num);
        }

        // Step 3: Sort individual buckets and concatenate
        int index = 0;
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.34f};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));  // [0.23, 0.32, 0.34, 0.42, 0.52]
    }
}
```

### 49. **Counting Sort**  
```java
import java.util.*;

public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;
        int[] count = new int[range];
        
        // Step 1: Count the occurrences of each element
        for (int num : arr) {
            count[num - min]++;
        }

        // Step 2: Update the array with sorted elements
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));  // [1, 2, 2, 3, 3, 4, 8]
    }
}
```

### 50. **Check if Two Strings are Rotations of Each Other**  
```java
public class StringRotation {
    public static boolean areRotations(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        // Step 1: Concatenate s1 with itself
        String concatenated = s1 + s1;

        // Step 2: Check if s2 is a substring of the concatenated string
        return concatenated.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(areRotations("abcde", "cdeab"));  // true
        System.out.println(areRotations("abc", "acb"));  // false
    }
}
```

### Explanation:
- **Bucket Sort**: This algorithm distributes the elements into several "buckets" and sorts each bucket individually (typically using another sorting algorithm like insertion sort or quicksort). Afterward, it concatenates all the sorted buckets.
  
- **Counting Sort**: A non-comparative sorting algorithm that counts the frequency of each distinct element in the array and uses this count to place the elements in their correct positions. It is particularly efficient when the range of input values is not large.

- **String Rotation Check**: This problem checks if one string is a rotation of another. By concatenating the first string with itself and checking if the second string is a substring of this concatenated string, we can efficiently determine if the two strings are rotations of each other.

Let me know if you need further explanations or modifications!











Here are the answers to the System Design and Java-related interview questions:

### 1. **Difference between JWT, OAuth, and SAML?**

- **JWT (JSON Web Token)**: A compact, URL-safe means of representing claims to be transferred between two parties. It is used for secure information exchange and typically used in stateless authentication. JWT is often used in conjunction with OAuth for securing APIs.

- **OAuth (Open Authorization)**: An open standard for authorization. OAuth allows a user to grant a third-party application limited access to their resources without sharing their credentials. It is used primarily for authorization and involves the exchange of tokens.

- **SAML (Security Assertion Markup Language)**: An XML-based framework for exchanging authentication and authorization data between parties, particularly between an identity provider and a service provider. SAML is often used in Single Sign-On (SSO) and federated identity scenarios.

### 2. **Reverse Proxy and Forward Proxy?**

- **Forward Proxy**: A proxy server that sits between client and server and acts on behalf of the client. It is typically used to access restricted websites or hide client IP addresses.
  
- **Reverse Proxy**: A proxy server that acts on behalf of the server. It accepts requests from clients and forwards them to the appropriate backend server. Common use cases include load balancing, caching, and securing the server by hiding its internal architecture.

### 3. **Horizontal Scaling and Vertical Scaling?**

- **Horizontal Scaling**: Adding more machines or instances to a system to distribute the load. This is typically used in distributed systems (e.g., cloud scaling) and offers better fault tolerance and load balancing.
  
- **Vertical Scaling**: Increasing the capacity of an individual machine, such as adding more CPU, memory, or storage. This is easier to implement but has limitations based on the hardware.

### 4. **Microservices and Monolithic Architecture?**

- **Monolithic Architecture**: A single unified codebase for the entire application. All components are tightly integrated, making it easier to manage in small systems but harder to scale, update, and maintain in large systems.
  
- **Microservices Architecture**: The application is split into multiple smaller services, each responsible for a specific business function. Microservices are independently deployable, scalable, and can be developed and maintained by different teams.

### 5. **What is Rate Limiter? How does it work?**

A **Rate Limiter** is a system used to control the amount of incoming traffic to a server. It prevents overuse of a resource by limiting how many requests can be made in a given time period (e.g., 100 requests per minute). Common strategies include:
- **Token Bucket**: Tokens are added to a bucket at a fixed rate. The client can make a request if a token is available.
- **Leaky Bucket**: Requests are added to a queue (bucket), and they leak at a fixed rate.

### 6. **API Gateway vs Load Balancer?**

- **API Gateway**: Acts as a reverse proxy to route requests to various microservices, and can handle cross-cutting concerns like authentication, authorization, logging, and rate-limiting.
  
- **Load Balancer**: Distributes incoming traffic across multiple servers to ensure that no single server is overwhelmed. It operates at the transport layer (Layer 4) or application layer (Layer 7).

### 7. **How does Single Sign-On (SSO) work?**

SSO allows a user to authenticate once and gain access to multiple applications without needing to log in again. The process generally involves:
- The user logs in to a central identity provider (IdP).
- The IdP issues a token (e.g., SAML, JWT).
- The user is granted access to other services that trust the IdP, without needing to log in again.

### 8. **How does Apache Kafka work? Why is it so fast?**

Kafka is a distributed streaming platform that can handle high throughput of data. It works by allowing producers to write messages to topics, and consumers to read messages from topics. Kafka is fast due to its:
- **Message batching**: Reduces overhead by sending messages in bulk.
- **Immutable logs**: Kafka writes data to logs that are never modified, which reduces locking and makes reads efficient.
- **Distributed nature**: Kafka's architecture allows it to scale horizontally, enabling high throughput.

### 9. **Difference between Kafka, ActiveMQ, and RabbitMQ?**

- **Kafka**: A distributed streaming platform used for high-throughput, fault-tolerant messaging. It is optimized for large-scale data pipelines and real-time analytics. Kafka is log-based and handles both high-throughput and real-time streams.

- **ActiveMQ**: A message broker that supports JMS (Java Message Service). It is primarily used for enterprise-level applications and provides features like persistence, message queues, and pub/sub messaging.

- **RabbitMQ**: An open-source message broker that supports multiple messaging protocols (AMQP, MQTT, STOMP). It is highly reliable and is often used in distributed systems for ensuring messages are delivered reliably.

---

### Method Overloading and Overriding in Java

**Method Overloading**:
- Occurs when multiple methods in the same class have the same name but differ in the number or types of parameters.
- Resolved at **compile time**.

**Method Overriding**:
- Occurs when a subclass provides a specific implementation for a method that is already defined in its superclass.
- Resolved at **runtime** (polymorphism).

### Common Interview Questions on Overloading and Overriding:

- **Can we overload static methods?**  
  Yes, static methods can be overloaded, but not overridden because static methods are resolved at compile time.

- **Can we override static methods?**  
  No, static methods are resolved at compile time, so they cannot be overridden. However, they can be **hidden**.

- **Can we overload the main method?**  
  Yes, the main method can be overloaded, but only the standard `public static void main(String[] args)` is called by the JVM.

- **Can we override a final method?**  
  No, final methods cannot be overridden because they are marked as "not allowed to be modified."

- **Can we change the return type while overriding a method?**  
  You cannot change the return type of a method during overriding, except in the case of covariant return types (where the return type can be a subclass of the original method’s return type).

These questions test understanding of fundamental OOP concepts, especially polymorphism (through method overloading and overriding), which is a core concept in Java.

### **Java Interview Questions on Collections and Multithreading**

Here is a detailed explanation of the Java interview questions related to Collections and Multithreading, along with answers to common questions that could be asked in interviews:

---

### **Top 10 Java Collection Interview Questions**

1. **What is the difference between `Hashtable` and `HashMap` in Java?**
   - **`Hashtable`** is synchronized and thread-safe, meaning it can be safely accessed by multiple threads. However, its thread-safety can lead to performance issues in multi-threaded environments.
   - **`HashMap`** is not synchronized and therefore not thread-safe. It allows `null` values and `null` keys, unlike `Hashtable`, which does not allow `null` values or keys.

2. **What is the difference between `Hashtable` and `ConcurrentHashMap` in Java?**
   - Both are thread-safe, but **`ConcurrentHashMap`** provides better scalability and performance. It locks only the specific segments of the map, rather than locking the entire map, as `Hashtable` does.
   - **`ConcurrentHashMap`** allows concurrent reads and updates to different parts of the map, making it more efficient in multi-threaded environments.

3. **What is the difference between `Iterator` and `Enumeration` in Java?**
   - **`Iterator`** was introduced in Java 1.2 and is more powerful than `Enumeration`. It allows the removal of elements during iteration (`remove()` method).
   - **`Enumeration`** is an older interface (introduced in Java 1.0) and does not support removing elements.

4. **What is the difference between a fail-safe and fail-fast iterator in Java?**
   - A **fail-fast iterator** immediately throws a `ConcurrentModificationException` if the collection is modified while iterating.
   - A **fail-safe iterator** (e.g., `CopyOnWriteArrayList`) works on a copy of the collection, so it does not throw exceptions if the collection is modified during iteration.

5. **How does `HashMap` work internally in Java?**
   - `HashMap` uses an array of buckets to store the key-value pairs. It calculates a hash of the key and uses it to find the appropriate bucket. If multiple keys hash to the same bucket, a linked list (or balanced tree structure in the case of many collisions) is used to resolve the collision.

6. **Can you write code to traverse a `Map` in Java in 4 ways?**
   - You can iterate over a `Map` using:
     - `forEach` method in Java 8+.
     - Using `entrySet()` with a `for-each` loop.
     - Using `keySet()` with a `for-each` loop.
     - Using `values()` to iterate over the values of the map.

7. **What is the difference between `Vector` and `ArrayList` in Java?**
   - **`ArrayList`** is not synchronized, meaning it is not thread-safe but offers better performance for single-threaded applications.
   - **`Vector`** is synchronized, making it thread-safe, but this synchronization comes with a performance overhead.

8. **What is the difference between `ArrayList` and `LinkedList` in Java?**
   - **`ArrayList`** uses a dynamic array to store elements, providing fast random access (`O(1)`) but slow insertions and deletions (`O(n)`).
   - **`LinkedList`** uses a doubly linked list to store elements, providing fast insertions and deletions (`O(1)`) but slower random access (`O(n)`).

9. **What is the difference between `List` and `Set` in Java?**
   - **`List`** allows duplicate elements and maintains insertion order (e.g., `ArrayList`, `LinkedList`).
   - **`Set`** does not allow duplicates and does not guarantee any order (e.g., `HashSet`, `TreeSet`).

10. **How do you find if `ArrayList` contains duplicates or not?**
    - You can use a `HashSet` to check for duplicates. If any element is already in the `Set`, then it's a duplicate.

---

### **Top 10 Java Threading and Concurrency Interview Questions**

1. **What is the difference between the `start()` and `run()` method in Java threads?**
   - The **`start()`** method creates a new thread and invokes the `run()` method on that thread. If you call the `run()` method directly, the code inside it will execute on the current thread, not a new one.

2. **Write code to avoid deadlock in Java where N threads are accessing N shared resources?**
   - Deadlocks occur when two or more threads are blocked forever, waiting for each other to release resources. To avoid deadlocks:
     - Always acquire locks in the same order across all threads.
     - Use `ReentrantLock` with `tryLock()` for timeout-based deadlock prevention.

3. **Which one is better to implement a thread in Java: extending `Thread` class or implementing `Runnable`?**
   - **`Runnable`** is generally preferred as it allows the class to extend another class while implementing the `Runnable` interface, offering better flexibility.

4. **What is busy spinning? Why will you use busy spinning as a wait strategy?**
   - **Busy spinning** involves a thread continuously checking a condition in a loop without releasing the CPU, useful in situations where a condition is likely to become true quickly (e.g., within a microsecond). It's used in low-latency systems.

5. **What is the difference between `CountDownLatch` and `CyclicBarrier` in Java?**
   - **`CountDownLatch`** is one-time use, and once the count reaches zero, it cannot be reused.
   - **`CyclicBarrier`** can be reused after all threads have reached the barrier.

6. **What is the difference between `wait()` and `sleep()` in Java?**
   - **`wait()`** releases the lock and must be called from a synchronized block or method.
   - **`sleep()`** pauses the thread for a specified time without releasing the lock.

7. **How do you solve the producer-consumer problem in Java?**
   - You can solve the producer-consumer problem using:
     - `wait()` and `notify()` with a shared queue.
     - `BlockingQueue` for easier management of thread-safe producer-consumer queues.

8. **Why is `ConcurrentHashMap` faster than `Hashtable` in Java?**
   - **`ConcurrentHashMap`** is faster because it locks only specific segments for updates, allowing for lock-free reads, unlike **`Hashtable`**, which locks the entire map during updates.

9. **What is the difference between `submit()` and `execute()` methods of `Executor` and `ExecutorService` in Java?**
   - **`submit()`** returns a `Future` object, allowing you to get the result of the task or handle exceptions.
   - **`execute()`** does not return a result or allow for exception handling.

10. **How do you share data between two threads in Java?**
    - You can use shared objects or concurrent collections like `BlockingQueue` or `Atomic` variables. Make sure to synchronize access to shared data to avoid race conditions.

---

### **Deadlock in Java**

1. **How do you detect deadlock in Java?**
   - A deadlock can be detected using a thread dump, which you can generate with commands like `kill -3` on Unix-like systems. Tools like **VisualVM** or **jConsole** can also help analyze thread dumps and detect deadlocks.

2. **Write a Java program that will result in a deadlock?**
   Here's an example of a deadlock scenario:
   ```java
   public class DeadLockDemo {
       public void method1() {
           synchronized (String.class) {
               synchronized (Integer.class) {
                   System.out.println("Acquired both locks");
               }
           }
       }

       public void method2() {
           synchronized (Integer.class) {
               synchronized (String.class) {
                   System.out.println("Acquired both locks");
               }
           }
       }
   }
   ```
   If both `method1()` and `method2()` are called from two different threads, they will deadlock.

3. **How do you avoid deadlock in Java?**
   - To avoid deadlock, you can ensure that all threads acquire locks in the same order.
   - Another strategy is using **`ReentrantLock`** with `tryLock()` for timeout-based approaches.

   Example of avoiding deadlock by acquiring locks in the same order:
   ```java
   public class DeadLockAvoided {
       public void method1() {
           synchronized (Integer.class) {
               synchronized (String.class) {
                   System.out.println("Acquired both locks");
               }
           }
       }

       public void method2() {
           synchronized (Integer.class) {
               synchronized (String.class) {
                   System.out.println("Acquired both locks");
               }
           }
       }
   }
   ```

---
### Explanation of Key Concepts from the Text

#### **1. `ConcurrentHashMap` in Java**
`ConcurrentHashMap` is a thread-safe collection class in Java, designed to handle concurrent access by multiple threads without significant performance degradation. It is introduced in Java 1.5 as an alternative to `Hashtable` and `synchronizedMap`. The key features of `ConcurrentHashMap` are:

- **Segmented Locking**: Unlike `Hashtable`, which locks the entire map during update operations, `ConcurrentHashMap` divides the map into segments, each of which is locked individually. This allows multiple threads to read from different segments concurrently without blocking each other.
- **Concurrency Level**: The default concurrency level is 16, meaning the map is divided into 16 parts. This can be adjusted when constructing a `ConcurrentHashMap`.
- **Thread-Safety**: It supports concurrent reads and safe write operations, making it highly suitable for multi-threaded environments.
- **No Null Keys or Values**: Unlike `HashMap`, `ConcurrentHashMap` does not allow null keys or values.
- **Fail-Safe Iteration**: The iterator returned by `keySet()` and other collection views of `ConcurrentHashMap` is weakly consistent, meaning it doesn't throw a `ConcurrentModificationException` even if the map is modified during iteration.

#### **2. How `ConcurrentHashMap` Works**
- **Internal Structure**: The map is divided into segments based on the concurrency level. Each segment is independently locked, allowing for concurrent updates to different segments without interference.
- **Concurrency in Action**: Multiple threads can perform `get()` and other read operations without locking the entire map, which enhances performance. Write operations (like `put()`, `remove()`) lock only the relevant segment.
- **Weak Consistency**: Read operations might not immediately reflect changes made by other threads, and iterators may not reflect the most recent changes to the map. However, `ConcurrentHashMap` is fail-safe, meaning it doesn't throw exceptions if the map is modified during iteration.

#### **3. `putIfAbsent()` Method**
- The `putIfAbsent()` method is an atomic operation that inserts a key-value pair if the key is absent in the map, and returns the existing value if the key is already present. This method prevents race conditions, which can occur if multiple threads attempt to insert the same key at the same time.

#### **4. When to Use `ConcurrentHashMap`**
- **Best Use Cases**: It's ideal when you have multiple readers and fewer writers. If there are more writers or if writers equal the number of readers, the performance benefits diminish, and it behaves similarly to `synchronizedMap` or `Hashtable`.
- **Common Applications**: Suitable for caches or other concurrent data structures where read-heavy operations are expected.

#### **5. Key Characteristics of `ConcurrentHashMap`**
- **Locking Mechanism**: It only locks a portion of the map, not the entire map, which allows for better concurrency than `Hashtable`.
- **Fail-Safe Iterators**: Iterators do not throw `ConcurrentModificationException` and are weakly consistent.
- **No Nulls**: `ConcurrentHashMap` doesn't allow null keys or values, unlike `HashMap`.
- **Optimized for Concurrency**: It is designed for situations where multiple threads are reading and writing to the map concurrently.

---

### Differences Between TCP and UDP Protocols

#### **TCP (Transmission Control Protocol) vs UDP (User Datagram Protocol)**
- **Connection-Oriented vs Connectionless**: TCP is connection-oriented, ensuring that a connection is established before any data is transferred. UDP is connectionless and does not guarantee delivery.
- **Reliability**: TCP ensures that data is delivered in order and retransmits lost packets. UDP does not guarantee packet delivery, order, or reliability.
- **Use Cases**: TCP is used in scenarios where data reliability is crucial, such as file transfers, web browsing, etc. UDP is used in applications like video streaming, online games, or VoIP, where speed is more important than reliability.
- **Performance**: TCP has higher overhead due to the need for connection establishment, acknowledgment, and retransmission of lost packets. UDP is faster because it does not have these features.
  
#### **TCP Handshake**
The TCP handshake is a three-step process for establishing a connection:
1. **SYN**: The client sends a synchronization request to the server.
2. **SYN-ACK**: The server acknowledges the client's request.
3. **ACK**: The client acknowledges the server's response, and the connection is established.

#### **Reliable Transmission in UDP**
While UDP itself doesn't guarantee delivery, reliability can be implemented on top of it. For example:
- **Sequence Numbers**: Sequence numbers can be used to detect lost packets and request retransmissions.
- **Acknowledgments and Retransmissions**: If a packet is lost, the receiver can request the sender to retransmit the lost packet.

#### **Multicast Transmission**
- **Multicasting** refers to the transmission of data from one sender to multiple receivers simultaneously. UDP is used for multicast because it supports broadcasting data to multiple destinations at once without needing separate connections to each one. TCP is unsuitable for multicast since it's designed for point-to-point communication.

#### **Sliding Window Protocol**
The **Sliding Window Protocol** is used in TCP for flow control, ensuring that packets are transmitted sequentially and reliably. It uses a "window" to allow a certain number of packets to be sent before requiring an acknowledgment.

#### **TIME_WAIT State**
The **TIME_WAIT state** occurs in TCP when a connection is closed. It is required to ensure that any delayed packets are properly handled and do not interfere with new connections. It can lead to resource exhaustion if too many connections stay in the TIME_WAIT state.

---

### Conclusion

- `ConcurrentHashMap` is an essential data structure for concurrent applications in Java. It optimizes performance by allowing concurrent reads and minimizing lock contention.
- TCP and UDP are fundamental protocols in networking. TCP ensures reliability and ordered delivery, while UDP is faster and used for applications where speed is more important than reliability.


Here’s a summary of the Kubernetes interview questions and answers that you've provided. This article is structured into three main sections: basic Kubernetes concepts, architecture-related questions, and multiple-choice questions for practical exposure. The goal is to help prepare for interviews, especially for DevOps Engineers, Developers, and anyone working with Kubernetes.

---

### 1. **Basic Kubernetes Interview Questions**

1. **What is Kubernetes?**
   - Kubernetes is an open-source platform for managing, scaling, and deploying containerized applications. It provides a robust solution for container orchestration, allowing containers to communicate and work together across multiple hosts.

2. **How is Kubernetes similar to Docker?**
   - Docker is used to create containers and manage their lifecycle, while Kubernetes provides orchestration for managing multiple containers, ensuring that they can interact with one another, scale, and be deployed efficiently across nodes.

3. **What is Container Orchestration?**
   - Container orchestration refers to the management of multiple containers so that they work together as a unified system. Kubernetes handles this by providing the infrastructure to automate deployment, scaling, and management.

4. **Why do you need Container Orchestration?**
   - Container orchestration is crucial when managing microservices across multiple containers. Without it, managing communication, scaling, and failure recovery would become a complex and error-prone task.

5. **What are some features of Kubernetes?**
   - Key features include automated scheduling, self-healing (auto-restarting or rescheduling containers), automated rollouts and rollbacks, horizontal scaling, and load balancing.

6. **What is the Containerized Deployment process in Kubernetes?**
   - Kubernetes allows containerized applications to be deployed and managed across various cloud platforms and virtual machines. It handles the orchestration, scaling, and load balancing without the need for complex configurations.

7. **What is Google Container Engine (GKE)?**
   - Google Container Engine is a platform for managing Docker containers and clusters within Google Cloud. It is based on Kubernetes and provides tools to manage containers at scale.

8. **What is Heapster?**
   - Heapster is a data aggregator in a Kubernetes cluster that collects metrics and monitoring data for the nodes, pods, and containers running within the cluster.

9. **What is Kubectl?**
   - `kubectl` is the command-line tool used to interact with a Kubernetes cluster. It allows users to create, manage, and delete Kubernetes resources, as well as troubleshoot and gather cluster metrics.

10. **What is Minikube?**
    - Minikube is a tool that runs a single-node Kubernetes cluster locally on a developer's machine, making it easier to test and develop with Kubernetes.

---

### 2. **Kubernetes Architecture Interview Questions**

11. **What is Kube-proxy?**
    - Kube-proxy is a network proxy that runs on each node in a Kubernetes cluster, responsible for load balancing traffic to services and maintaining network rules for services.

12. **What are the components of Kubernetes Architecture?**
    - Kubernetes consists of two primary components:
      - **Master Node**: Manages the Kubernetes cluster, containing the API server, controller manager, and scheduler.
      - **Worker Node**: Runs the actual applications in containers (pods), managed by the master node.

13. **How does the master node work in Kubernetes?**
    - The master node manages the cluster, handles the orchestration, and ensures the desired state of the cluster is met. It contains components like the Kube-apiserver, Kube-controller-manager, and Kube-scheduler.

14. **What do you know about the Kubernetes controller manager?**
    - The controller manager runs controllers that monitor and manage the state of Kubernetes resources. It ensures that the desired state (e.g., number of replicas, node health) is maintained.

15. **What is ETCD?**
    - ETCD is a distributed key-value store used in Kubernetes to store configuration data and the state of the cluster. It ensures the consistency of data across the cluster.

16. **How does the Load Balancer work in Kubernetes?**
    - Kubernetes uses two types of load balancers: internal load balancers (for traffic within the cluster) and external load balancers (for routing external traffic to services).

17. **What is Ingress Network?**
    - Ingress is an API object that manages external access to services in a Kubernetes cluster, usually HTTP. It defines rules for routing external requests to services.

18. **What are the different types of services Kubernetes offers?**
    - **ClusterIP**: Exposes a service internally within the cluster.
    - **NodePort**: Exposes a service on each node’s IP at a static port.
    - **LoadBalancer**: Exposes a service externally through a cloud provider's load balancer.
    - **ExternalName**: Maps the service to an external DNS name.

---

### 3. **Multiple-Choice Questions**

19. **Where is Kubernetes Cluster data stored?**
    - A) Kube-apiserver  
    - B) Kubelet  
    - C) **ETCD** (Correct)  
    - D) None of the above

20. **Which of the following is a Kubernetes Controller?**
    - A) Replicaset  
    - B) Deployment  
    - C) Rolling Updates  
    - D) **Both A and B** (Correct)

21. **Which of the following are core Kubernetes objects?**
    - A) Pods  
    - B) Services  
    - C) Volumes  
    - D) **All of the above** (Correct)

22. **On which node does the Kube-proxy run?**
    - A) Master Node  
    - B) Worker Node  
    - C) **Both A and B** (Correct)  
    - D) None of the above

23. **Which of the following was introduced in Kubernetes version 1.8?**
    - A) **Taints and Tolerations** (Correct)  
    - B) Cluster Level Logging  
    - C) Secrets  
    - D) Federated Clusters

24. **Which handler is invoked by Kubelet to check if a container's IP address is open or not?**
    - A) HTTPGetAction  
    - B) ExecAction  
    - C) **TCPSocketAction** (Correct)  
    - D) None of the Above

---

This collection of questions covers essential topics in Kubernetes, ranging from basic concepts to architectural details and practical usage. Studying these should help improve your understanding of Kubernetes and better prepare you for interviews in DevOps and cloud computing environments.

Here’s a summary and explanation of the key **Object-Oriented Programming (OOP) concepts** in Java, along with **SOLID design principles** that are often discussed in Java interviews:

---

### **OOP Concepts Interview Questions and Answers**

1. **What is Method Overloading?**
   - **Answer**: Method overloading occurs when multiple methods with the same name exist in a class, but they differ in the number or type of parameters. Overloading is resolved at **compile-time**.
   
2. **What is Method Overriding?**
   - **Answer**: Method overriding happens when a subclass provides its own specific implementation of a method that is already defined in its superclass. Overriding is resolved at **runtime** based on the actual object type.

3. **What is Method Hiding?**
   - **Answer**: When a static method in the subclass has the same signature as a static method in the superclass, it hides the superclass's method. This happens with static methods, which are resolved at **compile-time**.

4. **Is Java a Pure Object-Oriented Language?**
   - **Answer**: No, Java is not purely object-oriented because it includes primitive types like `int`, `char`, and allows for static methods which do not require objects to be invoked.

5. **What are the Rules of Method Overloading and Overriding?**
   - **Answer**: Overloading rules include having a different parameter list (number or type). For overriding, the method signature must remain the same, and it cannot throw exceptions higher in the hierarchy than the overridden method.

6. **Difference Between Overloading and Overriding?**
   - **Answer**: 
     - Overloading: Resolved at **compile-time**.
     - Overriding: Resolved at **runtime** based on the actual object type.

7. **Can We Overload a Static Method?**
   - **Answer**: Yes, static methods can be overloaded based on different method signatures.

8. **Can We Override a Static Method?**
   - **Answer**: No, static methods cannot be overridden because they are resolved at compile-time based on the reference type.

9. **Can We Prevent Overriding without Using the `final` Modifier?**
   - **Answer**: Yes, methods can be prevented from being overridden by making them `private`, `static`, or `final`.

10. **Can We Override a Private Method?**
    - **Answer**: No, private methods cannot be overridden as they are not visible to subclasses.

11. **What is Covariant Method Overriding?**
    - **Answer**: This allows the overriding method to return a more specific type (a subclass of the original return type) than the overridden method. Introduced in **Java 5**.

12. **Can We Change the Return Type When Overriding a Method?**
    - **Answer**: Yes, since Java 5, covariant method overriding allows changing the return type to a subclass type.

13. **Can We Change the Argument List of an Overriding Method?**
    - **Answer**: No, the argument list must remain the same for both the overriding and overridden methods.

14. **Can We Override a Method that Throws Runtime Exceptions?**
    - **Answer**: Yes, unchecked exceptions (e.g., `RuntimeException`) can be thrown by overriding methods without restrictions.

15. **How to Call a Superclass's Overridden Method?**
    - **Answer**: Use the `super` keyword to invoke the superclass's version of an overridden method.

16. **Can We Override a Non-static Method as Static?**
    - **Answer**: No, a non-static method cannot be overridden as static.

17. **Can We Override a Final Method?**
    - **Answer**: No, final methods cannot be overridden.

18. **Can We Have Non-Abstract Methods Inside an Interface?**
    - **Answer**: Yes, from **Java 8 onwards**, interfaces can have default and static methods with implementations.

19. **What is a Default Method in Java 8?**
    - **Answer**: A default method is a method with a body that can be added to interfaces without breaking existing implementations. It provides default functionality.

20. **What is an Abstract Class in Java?**
    - **Answer**: An abstract class is a class that cannot be instantiated and is meant to be subclassed. It may contain abstract methods (methods without implementation) and non-abstract methods (with implementation).

21. **What is an Interface in Java?**
    - **Answer**: An interface defines a contract that classes must adhere to. It only specifies method signatures without providing implementations. Interfaces allow for multiple inheritance in Java.

22. **Difference Between Abstract Class and Interface?**
    - **Answer**: Abstract classes can have non-abstract methods, while interfaces (before Java 8) can only have abstract methods. Since Java 8, interfaces can have default and static methods as well.

23. **Can a Class Be Abstract Without Abstract Methods?**
    - **Answer**: Yes, a class can be abstract even without any abstract methods, though it typically serves to provide shared functionality for subclasses.

24. **Can a Class Be Both Final and Abstract?**
    - **Answer**: No, a class cannot be both final and abstract. A final class cannot be subclassed, and an abstract class is meant to be subclassed.

25. **Can We Overload or Override the `main()` Method?**
    - **Answer**: We can overload the `main()` method, but we cannot override it because `main()` is static.

26. **What is the Difference Between Polymorphism, Overloading, and Overriding?**
    - **Answer**:
      - Polymorphism is the ability of an object to take many forms.
      - Overloading is compile-time polymorphism.
      - Overriding is runtime polymorphism.

27. **Can an Interface Extend Multiple Interfaces?**
    - **Answer**: Yes, an interface can extend multiple interfaces in Java.

28. **Can a Class Extend Multiple Classes?**
    - **Answer**: No, Java does not support multiple inheritance for classes, but a class can implement multiple interfaces.

29. **What is the Difference Between Abstraction and Polymorphism?**
    - **Answer**: Abstraction hides the complex reality, while polymorphism allows for different behaviors depending on the object.

---

### **SOLID Design Principles**

1. **Single Responsibility Principle (SRP)**:
   - A class should have only one reason to change, meaning it should have only one responsibility.

2. **Open/Closed Principle (OCP)**:
   - Software entities (classes, modules, functions) should be open for extension but closed for modification. This can be achieved via inheritance or interfaces.

3. **Liskov Substitution Principle (LSP)**:
   - Objects of a subclass should be able to replace objects of the superclass without affecting the correctness of the program.

4. **Interface Segregation Principle (ISP)**:
   - Clients should not be forced to depend on interfaces they do not use. It encourages the design of small, specific interfaces.

5. **Dependency Inversion Principle (DIP)**:
   - High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

---

These concepts form the foundation of OOP in Java and are essential for designing robust, maintainable, and scalable software systems.

The article you’ve provided covers a range of **Object-Oriented Design (OOD) principles** that are crucial for building maintainable, flexible, and scalable software. Here's a breakdown of the core principles mentioned in the article, along with explanations and examples where appropriate:

---

### 1. **DRY (Don't Repeat Yourself)**

This principle emphasizes avoiding the duplication of code. If you find the same piece of logic repeated in multiple places, it’s a good practice to refactor it into a separate method or class. The DRY principle improves maintainability by reducing the risk of errors during future changes.

- **Example**: If you're validating `OrderID` in multiple classes, create a separate utility method for validation instead of repeating the same logic.

#### Key Benefit:
- Reduces the risk of bugs when changes need to be made.
  
---

### 2. **Encapsulate What Changes**

Encapsulation is the principle of restricting direct access to some of an object's components and instead providing methods to access them. The idea is to isolate the parts of the system that are likely to change and protect other parts from being affected.

- **Example**: In Java, make variables `private` and expose them via `getter` and `setter` methods. This way, you can change the internal implementation without affecting external classes.

#### Key Benefit:
- Easy to modify and extend.
- Protects the rest of the system from frequent changes.

---

### 3. **Open Closed Principle (OCP)**

The Open-Closed Principle states that software entities (classes, modules, functions) should be open for extension but closed for modification. This means you can add new functionality without altering existing code.

- **Example**: If you’re working with shapes (e.g., `Circle`, `Rectangle`), instead of modifying a method every time you add a new shape, you can extend the `Shape` class and implement new behaviors.

#### Key Benefit:
- Avoids breaking existing functionality when adding new features.

---

### 4. **Single Responsibility Principle (SRP)**

Each class should have only one reason to change. In other words, a class should have only one job or responsibility. This reduces the risk of introducing bugs when you modify a class for a new feature.

- **Example**: If you have a class that handles both user authentication and database transactions, you should split it into two classes—one for authentication and another for database operations.

#### Key Benefit:
- Makes classes easier to maintain and test.

---

### 5. **Dependency Injection (DI) or Inversion of Control (IoC)**

This principle suggests that you should not create your dependencies; instead, they should be provided to you. Dependency Injection helps decouple the code by passing dependencies through constructors, setters, or interfaces.

- **Example**: In a Spring Framework-based application, a service class like `UserService` might rely on a repository class. Instead of creating the repository within the service, the Spring container injects it.

#### Key Benefit:
- Decouples components and makes code more testable and maintainable.

---

### 6. **Favor Composition over Inheritance**

Composition allows you to change behavior at runtime by adding new behaviors dynamically. It’s considered more flexible than inheritance, which is static.

- **Example**: Instead of creating subclasses for different kinds of animals (e.g., `Dog`, `Cat`, etc.), create a `Pet` interface and use composition to define shared behaviors.

#### Key Benefit:
- Promotes flexibility and reuse of components without tight coupling.

---

### 7. **Liskov Substitution Principle (LSP)**

According to LSP, objects of a subclass should be able to replace objects of the superclass without affecting the behavior of the program. This principle ensures that the derived class enhances functionality rather than diminishing it.

- **Example**: If a class `Bird` has a method `fly()`, a subclass `Penguin` should not override this method to make it throw an exception because penguins cannot fly.

#### Key Benefit:
- Ensures that subclass behavior is predictable and does not break the system.

---

### 8. **Interface Segregation Principle (ISP)**

A client should not be forced to implement an interface it doesn’t use. This principle encourages creating smaller, more focused interfaces instead of large, monolithic ones.

- **Example**: If a `Printer` interface has methods for both `print` and `scan`, but some classes only need `print` functionality, split the interface into two: `Printer` and `Scanner`.

#### Key Benefit:
- Reduces unnecessary implementation and makes code easier to maintain.

---

### 9. **Programming for Interface, Not Implementation**

This principle encourages using interfaces rather than concrete classes in your code. Programming against an interface allows your code to be more flexible and easier to adapt to future changes.

- **Example**: Instead of declaring a variable as a `Dog`, declare it as an `Animal`. This way, the code can work with any `Animal` type, not just `Dog`.

#### Key Benefit:
- Promotes flexibility and loose coupling.

---

### 10. **Delegation Principle**

Instead of performing all actions yourself, delegate the responsibilities to other classes. This principle helps to reduce the complexity within a class and promotes separation of concerns.

- **Example**: In Java, the `equals()` and `hashCode()` methods are typically delegated to another class or utility to perform comparisons, rather than writing custom comparison logic within every class.

#### Key Benefit:
- Avoids redundant code and simplifies modifications.

---

### **Conclusion**

Applying these **Object-Oriented Design Principles** can significantly improve the quality, maintainability, and scalability of your software. Whether you’re developing a small application or working on large-scale enterprise systems, adhering to these principles helps create code that is flexible and easier to manage. 

For developers, mastering these principles not only improves coding skills but also makes it easier to work in teams, build reusable components, and adapt to future changes in technology and business requirements.

If you want to go deeper into these principles, exploring design patterns such as **Factory**, **Singleton**, **Observer**, etc., and understanding **SOLID principles** will give you an edge in writing efficient, maintainable code.

### 50 Essential Topics for SQL and Database Interview Questions

Here’s a curated list of essential SQL and database topics, including key concepts like normalization, indexing, joins, stored procedures, and constraints, that programmers should prepare for SQL and database-related interviews. Interviewers typically ask a range of questions, from basic to complex, based on these fundamental topics. A good interviewee should be able to demonstrate both knowledge and problem-solving skills in these areas.

#### Top 50 SQL and Database Phone Interview Questions & Answers:

1. **Difference between UNION and UNION ALL in SQL?**  
   - **Answer**: `UNION` removes duplicates, while `UNION ALL` includes duplicates. Both are used to combine the results of multiple SELECT queries.

2. **Difference between WHERE and HAVING clause in SQL?**  
   - **Answer**: `WHERE` filters rows before aggregation, whereas `HAVING` filters groups after aggregation.

3. **Clustered vs Non-clustered Indexes?**  
   - **Answer**: A clustered index defines the physical order of data rows in a table. A non-clustered index creates a separate structure to speed up data retrieval.

4. **Find the second-highest salary without TOP or LIMIT?**  
   - **Answer**: Use a correlated subquery to find the second-highest salary:
     ```sql
     SELECT MAX(Salary) 
     FROM Employee 
     WHERE Salary < (SELECT MAX(Salary) FROM Employee);
     ```

5. **How to find duplicate rows in a database?**  
   - **Answer**: Use `GROUP BY` and `HAVING COUNT(*) > 1` to find duplicate rows.

6. **Correlated vs Non-correlated subquery?**  
   - **Answer**: A correlated subquery refers to a value from the outer query, while a non-correlated subquery does not.

7. **How many clustered indexes can a table have?**  
   - **Answer**: A table can have only one clustered index, as it defines the physical order of data.

8. **PRIMARY Key vs UNIQUE Key?**  
   - **Answer**: A `PRIMARY KEY` uniquely identifies records and doesn't allow NULL values. A `UNIQUE KEY` also ensures uniqueness but allows one NULL value.

9. **View vs Materialized View?**  
   - **Answer**: A `VIEW` is a virtual table that is recalculated every time it is queried, while a `MATERIALIZED VIEW` stores the result set physically for faster access.

10. **Difference between TRUNCATE, DELETE, and DROP?**  
    - **Answer**: `DELETE` removes rows and logs each deletion, `TRUNCATE` removes all rows without logging, and `DROP` removes the entire table.

11. **Referential Integrity in a relational database?**  
    - **Answer**: Ensures that relationships between tables are maintained by deleting or updating related rows in child tables when a record is modified in the parent table.

12. **What is Normalization?**  
    - **Answer**: Normalization is the process of organizing data to reduce redundancy and improve data integrity.

13. **1NF, 2NF, and 3NF?**  
    - **Answer**:  
      - **1NF**: Ensures that the table has no repeating groups and every field contains atomic values.  
      - **2NF**: Removes partial dependency (all non-key attributes depend on the whole key).  
      - **3NF**: Ensures that non-key attributes are not transitively dependent on the primary key.

14. **ISNULL() vs COALESCE() in SQL Server?**  
    - **Answer**: `ISNULL()` replaces NULL with a specified value, while `COALESCE()` returns the first non-NULL expression.

15. **Ensure values between 1 and 5 in a column?**  
    - **Answer**: Use a `CHECK` constraint:
      ```sql
      ALTER TABLE MyTable
      ADD CONSTRAINT chk_values CHECK (MyColumn BETWEEN 1 AND 5);
      ```

16. **CHAR vs VARCHAR?**  
    - **Answer**: `CHAR` is fixed-length, while `VARCHAR` is variable-length.

17. **VARCHAR vs NVARCHAR?**  
    - **Answer**: `NVARCHAR` supports Unicode characters, while `VARCHAR` does not.

18. **Get Day, Month, and Year from a date?**  
    - **Answer**: Use `DATEPART()` function in SQL Server:
      ```sql
      SELECT DATEPART(DAY, GetDate()), DATEPART(MONTH, GetDate()), DATEPART(YEAR, GetDate());
      ```

19. **How to check if a date is valid in SQL?**  
    - **Answer**: You can use `TRY_CAST()` or `TRY_CONVERT()` to check if a value can be converted to a date.

20. **LEFT OUTER JOIN vs INNER JOIN?**  
    - **Answer**: `INNER JOIN` returns only matching rows, while `LEFT OUTER JOIN` returns all rows from the left table and matching rows from the right table.

21. **SELF JOIN in SQL?**  
    - **Answer**: A self-join is when a table is joined to itself. Example: Find employees who are managers in the same table.

22. **Departments and Employees Query?**  
    - **Answer**: Find all departments and the number of employees in each:
      ```sql
      SELECT DepartmentName, COUNT(EmployeeID)
      FROM Employees
      GROUP BY DepartmentName;
      ```

23. **COUNT(*), COUNT(1), and COUNT(column_name)?**  
    - **Answer**: `COUNT(*)` counts all rows, including NULLs. `COUNT(1)` counts rows but doesn’t include NULLs for any specific column, and `COUNT(column_name)` counts non-NULL values in that column.

24. **What are Database Statistics?**  
    - **Answer**: Database statistics provide information about the distribution of data within the database, which helps the query optimizer to generate efficient query plans.

25. **Does the order of columns in a compound index matter?**  
    - **Answer**: Yes, the order affects how the index is used. For example, an index on `(book_id, active)` is not the same as `(active, book_id)`.

26. **Usage of _ and % in SQL?**  
    - **Answer**: `_` matches exactly one character, while `%` matches zero or more characters in a `LIKE` clause.

27. **How to force a query to use a specific index?**  
    - **Answer**: Use query hints to specify which index to use, e.g., `WITH (INDEX(index_name))`.

28. **Which is faster: index seek, index scan, or table scan?**  
    - **Answer**: An index seek is the fastest, followed by an index scan, and table scan is the slowest.

29. **NULL = NULL returns in SQL?**  
    - **Answer**: It returns `UNKNOWN`. In SQL, NULL values are not equal to each other.

30. **SQL Query for NULL values in a column?**  
    - **Answer**: Use `IS NULL` to check for NULL values:
      ```sql
      SELECT * FROM Employees WHERE EMP_NAME IS NULL;
      ```

31. **What is a Temp Table?**  
    - **Answer**: A temp table exists only during the session and is deleted when the session ends.

32. **Fastest way to empty a table?**  
    - **Answer**: Use the `TRUNCATE` command for faster performance than `DELETE`.

33. **What is an Identity Column?**  
    - **Answer**: An identity column auto-increments with each insert, often used for primary keys.

34. **Return identity value from a table with a trigger?**  
    - **Answer**: Use the `@@IDENTITY` function to return the last identity value inserted.

35. **How to return a value from a stored procedure?**  
    - **Answer**: Use `OUTPUT` parameters or `RETURN` statement.

36. **Returning VARCHAR from a stored procedure?**  
    - **Answer**: Use an `OUTPUT` parameter to return a VARCHAR value.

37. **Best data type for values between 1 and 250?**  
    - **Answer**: Use `TINYINT`, which stores values between 0 and 255.

38. **LEFT vs RIGHT OUTER JOIN?**  
    - **Answer**: A `LEFT OUTER JOIN` includes all records from the left table, while a `RIGHT OUTER JOIN` includes all records from the right table.

39. **SQL Query for last names starting with 'T'?**  
    - **Answer**:
      ```sql
      SELECT LastName FROM Employees WHERE LastName LIKE 'T%';
      ```

40. **Select all rows where the date is '20211002'?**  
    - **Answer**: Use `WHERE DateColumn = '20211002'`.

41. **Local vs Global Temporary Tables in SQL Server?**  
    - **Answer**: Local temp tables are available only to the session that created them, while global temp tables are accessible by any session.

42. **Create a copy of a table in SQL Server?**  
    - **Answer**: Use `SELECT INTO` to create a copy:
      ```sql
      SELECT * INTO NewTable FROM OriginalTable;
      ```

43. **Change the data type of a column?**  
    - **Answer**: Use `ALTER TABLE`:
      ```sql
      ALTER TABLE MyTable ALTER COLUMN ColumnName

 NEW_DATA_TYPE;
      ```

44. **Best data type for monetary values?**  
    - **Answer**: Use `DECIMAL` or `MONEY` types for monetary values.

45. **What does SELECT 3/2 return?**  
    - **Answer**: It returns `1` because integer division truncates the decimal.

46. **Max value of Decimal(6, 5)?**  
    - **Answer**: The maximum value is `0.99999`, as it allows 1 digit before the decimal and 5 digits after.

47. **Query for `ID != 101` where `ID` has NULL values?**  
    - **Answer**: It will not return rows where `ID` is NULL, because `NULL != 101` is not true. Use `IS NULL` for those cases.

48. **Favorite SQL book?**  
    - **Answer**: "Head First SQL" or "Joe Celko’s SQL Puzzles" for advanced SQL skills.

49. **Two SQL best practices?**  
    - **Answer**: Regular indexing and query optimization.

50. **Isolation levels in SQL Server?**  
    - **Answer**: The isolation levels include `Read Uncommitted`, `Read Committed`, `Repeatable Read`, `Serializable`, and `Snapshot`.

These topics and answers will help you prepare for a wide range of SQL and database interview questions.


Below are the solutions for the SQL query problems listed based on the provided Employee and Department data model:

### 1. **Employee names who have a bigger salary than their manager**
```sql
SELECT E.emp_name
FROM Employee E
JOIN Employee M ON E.mngr_id = M.emp_id
WHERE E.salary > M.salary;
```
**Explanation**: The query joins the `Employee` table with itself to compare employees with their managers. We check if an employee's salary is greater than their manager's salary.

---

### 2. **Employees who have the biggest salary in their Department**
```sql
SELECT E.emp_name
FROM Employee E
WHERE E.salary = (
  SELECT MAX(salary)
  FROM Employee
  WHERE dept_id = E.dept_id
);
```
**Explanation**: This query selects employees whose salary equals the maximum salary in their department by using a correlated subquery.

---

### 3. **Departments that have less than 3 people**
```sql
SELECT D.dept_name
FROM Department D
JOIN Employee E ON D.dept_id = E.dept_id
GROUP BY D.dept_name
HAVING COUNT(E.emp_id) < 3;
```
**Explanation**: This query finds departments with fewer than 3 employees by joining the `Department` and `Employee` tables and using the `HAVING` clause to filter based on employee count.

---

### 4. **All Departments along with the number of people there**
```sql
SELECT D.dept_name, COUNT(E.emp_id) AS num_employees
FROM Department D
LEFT JOIN Employee E ON D.dept_id = E.dept_id
GROUP BY D.dept_name;
```
**Explanation**: This query lists all departments and the number of employees in each department. We use a `LEFT JOIN` to ensure that departments with no employees are included with a count of 0.

---

### 5. **Employees who don't have a manager in the same department**
```sql
SELECT E.emp_name
FROM Employee E
LEFT JOIN Employee M ON E.mngr_id = M.emp_id AND E.dept_id = M.dept_id
WHERE M.emp_id IS NULL;
```
**Explanation**: The query selects employees who do not have a manager in the same department. The `LEFT JOIN` ensures that we can find employees with no corresponding manager in the same department (where `M.emp_id` is `NULL`).

---

### 6. **All Departments along with the total salary of employees in each**
```sql
SELECT D.dept_name, SUM(E.salary) AS total_salary
FROM Department D
JOIN Employee E ON D.dept_id = E.dept_id
GROUP BY D.dept_name;
```
**Explanation**: This query calculates the total salary for each department by summing up the salaries of employees in that department.

---

### 7. **Find the second highest salary of Employee**
```sql
SELECT MAX(salary) AS second_highest_salary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);
```
**Explanation**: This query finds the second-highest salary by selecting the maximum salary that is less than the highest salary. It uses a subquery to get the highest salary.

---

### 8. **Find all duplicate records from a table**
```sql
SELECT emp_id, emp_name, dept_id, salary, COUNT(*)
FROM Employee
GROUP BY emp_id, emp_name, dept_id, salary
HAVING COUNT(*) > 1;
```
**Explanation**: This query finds duplicate records by grouping rows with the same values and counting how many times they appear. It returns rows where the count is greater than 1.

---

### 9. **Copy all rows of a table**
```sql
INSERT INTO Employee (emp_id, dept_id, mngr_id, emp_name, salary)
SELECT emp_id, dept_id, mngr_id, emp_name, salary
FROM Employee;
```
**Explanation**: This query copies all rows from the `Employee` table into itself. You can modify it to copy data into another table if needed.

---

### 10. **Join more than two tables in SQL**
```sql
SELECT E.emp_name, D.dept_name, M.emp_name AS manager_name
FROM Employee E
JOIN Department D ON E.dept_id = D.dept_id
LEFT JOIN Employee M ON E.mngr_id = M.emp_id;
```
**Explanation**: This query demonstrates how to join multiple tables: `Employee` with `Department`, and also `Employee` with itself (to get manager names) using `LEFT JOIN`.

---

### 11. **Find 2nd highest salary without using a correlated subquery**
```sql
SELECT MAX(salary) AS second_highest_salary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);
```
**Explanation**: This solution is similar to the previous one, but uses a different approach. The query gets the second-highest salary by filtering out the highest salary with a subquery.

---

### 12. **Find all Customers who have never ordered**
```sql
SELECT C.customer_id, C.customer_name
FROM Customer C
LEFT JOIN Orders O ON C.customer_id = O.customer_id
WHERE O.order_id IS NULL;
```
**Explanation**: This query finds customers who have never placed an order by performing a `LEFT JOIN` between the `Customer` and `Orders` tables and selecting those where the `order_id` is `NULL`.

---

These are the SQL queries for solving common interview problems. Ensure that you understand the logic behind each query and try writing them on your own before referring to the solutions.








Difference between row_number(), rank() and dense_rank() window functions in SQL

Though all three are ranking functions in SQL, also known as a window function in Microsoft SQL Server, the difference between rank(), dense_rank(), and row_number() comes when you have ties on ranking i.e. duplicate records. For example, if you are ranking employees by their salaries then what would be the rank of two employees of the same salaries? It depends on which ranking function you are using like row_number, rank, or dense_rank.




The row_number() function always generates a unique ranking even with duplicate records i.e. if the ORDER BY clause cannot distinguish between two rows, it will still give them different rankings, though which record will come earlier or later is decided randomly like in our example two employees Shane and Rick have the same salary and has row number 4 and 5, this is random, if you run again, Shane might come 5th.



The rank() and dense_rank() will give the same ranking to rows that cannot be distinguished by the order by clause, but dense_rank will always generate a contiguous sequence of ranks like (1,2,3,...), whereas rank() will leave gaps after two or more rows with the same rank (think "Olympic Games": if two athletes win the gold medal, there is no second place, only third).  You can also see the  Querying Microsoft SQL Server course on Udemy to learn more about how to rank and dense_rank break ties.

Surprisingly all these functions behave similarly in Microsoft SQL Server and Oracle, at least at the high level, so if you have used them in MSSQL, you can also use it on Oracle 11g or other versions.



By the way, if you are new to Microsoft SQL Server and T-SQL then I also suggest you join a comprehensive course to learn SQL Server fundamentals and how to work with T-SQL. If you need a recommendation then I suggest you go through the Microsoft SQL for Beginners online course by Brewster Knowlton on Udemy. It's a great course to start with T-SQL and SQL queries in SQL Server.

Here are solutions for common SQL query problems based on your practice interview questions, including various approaches for finding the **Nth highest salary** using different SQL techniques.

---

### 1. **SQL Query to Show Employees (Names) Who Have a Bigger Salary Than Their Manager**

**Solution:**
```sql
SELECT a.emp_name 
FROM Employee a 
JOIN Employee b ON a.mngr_id = b.emp_id 
WHERE a.salary > b.salary;
```
**Explanation:**  
We are joining the `Employee` table with itself using aliases `a` and `b`. This allows us to compare an employee's salary (`a.salary`) with their manager's salary (`b.salary`). If the employee’s salary is higher than the manager's, the employee is selected.

---

### 2. **SQL Query to Find Employees Who Have the Biggest Salary in Their Department**

**Solution:**
```sql
SELECT a.emp_name, a.dept_id
FROM Employee a 
JOIN (
    SELECT a.dept_id, MAX(salary) AS max_salary
    FROM Employee a 
    JOIN Department b ON a.dept_id = b.dept_id
    GROUP BY a.dept_id
) b ON a.salary = b.max_salary AND a.dept_id = b.dept_id;
```
**Explanation:**  
This query first calculates the highest salary (`MAX(salary)`) in each department using a subquery. Then, it joins the `Employee` table to find employees whose salary matches the highest salary in their department.

---

### 3. **SQL Query to List Departments That Have Less Than 3 People in It**

**Solution:**
```sql
SELECT dept_id, COUNT(emp_name) AS 'Number of Employee'
FROM Employee
GROUP BY dept_id
HAVING COUNT(emp_name) < 3;
```
**Explanation:**  
This query groups employees by `dept_id` and counts the number of employees in each department. Using the `HAVING` clause, we filter departments that have fewer than 3 employees.

---

### 4. **SQL Query to Show All Departments Along with the Number of People There**

**Solution:**
```sql
SELECT b.dept_name, COUNT(a.dept_id) AS 'Number of Employee'
FROM Employee a
FULL OUTER JOIN Department b ON a.dept_id = b.dept_id
GROUP BY b.dept_name;
```
**Explanation:**  
We use a `FULL OUTER JOIN` to include all departments, even those with no employees. The query counts the number of employees per department, and departments without employees will have a count of 0.

---

### 5. **SQL Query to Show All Employees Who Don’t Have a Manager in the Same Department**

**Solution:**
```sql
SELECT a.emp_name
FROM Employee a 
JOIN Employee b ON a.mngr_id = b.emp_id
WHERE a.dept_id != b.dept_id;
```
**Explanation:**  
We join the `Employee` table to itself, comparing employees to their managers. The `WHERE` clause ensures that only employees whose manager is not in the same department are selected.

---

### 6. **SQL Query to List All Departments Along With the Total Salary of That Department**

**Solution:**
```sql
SELECT b.dept_name, SUM(a.salary) AS 'Total Salary'
FROM Employee a
FULL OUTER JOIN Department b ON a.dept_id = b.dept_id
GROUP BY b.dept_name;
```
**Explanation:**  
This query calculates the total salary of employees in each department. A `FULL OUTER JOIN` is used to ensure that departments without employees (i.e., no salaries) are still included in the result.

---

### 7. **Find the Nth Highest Salary Using Correlated Subquery**

**Solution: (For N = 2)**
```sql
SELECT name, salary
FROM Employee e1
WHERE 2 - 1 = (SELECT COUNT(DISTINCT salary) FROM Employee e2 WHERE e2.salary > e1.salary);
```
**Explanation:**  
This correlated subquery calculates the Nth highest salary by comparing the salary in the outer query (`e1`) with the distinct salaries in the subquery (`e2`). The subquery counts how many salaries are greater than the current salary in the outer query. For the second-highest salary, `N-1` equals `1`.

---

### 8. **Find the 2nd Highest Salary Using the `TOP` Keyword in SQL Server**

**Solution:**
```sql
SELECT TOP 1 salary
FROM (
    SELECT DISTINCT TOP 2 salary
    FROM Employee
    ORDER BY salary DESC
) AS temp
ORDER BY salary;
```
**Explanation:**  
This query first selects the top 2 distinct salaries in descending order and then selects the top salary from that result set, which will be the second-highest salary.

---

### 9. **Find the Nth Highest Salary in MySQL Using `LIMIT`**

**Solution: (For N = 3)**
```sql
SELECT salary 
FROM Employee
ORDER BY salary DESC
LIMIT 2, 1;
```
**Explanation:**  
In MySQL, we can use the `LIMIT` clause to specify the Nth highest salary. The syntax `LIMIT N-1, 1` selects the Nth row from the ordered result set. For the 3rd highest salary, we use `LIMIT 2, 1`.

---

### 10. **Find the Nth Highest Salary in Oracle Using `ROW_NUMBER()`**

**Solution: (For N = 2)**
```sql
SELECT * 
FROM (
    SELECT e.*, ROW_NUMBER() OVER (ORDER BY salary DESC) AS rn 
    FROM Employee e
)
WHERE rn = 2;
```
**Explanation:**  
The `ROW_NUMBER()` function assigns a unique row number to each row ordered by salary in descending order. The outer query selects the row where the `ROW_NUMBER` equals N (in this case, 2 for the second-highest salary).

---

### 11. **Find the Nth Highest Salary Using `RANK()` (Oracle)**

**Solution: (For N = 2)**
```sql
SELECT *
FROM (
    SELECT e.*, RANK() OVER (ORDER BY salary DESC) AS rank 
    FROM Employee e
)
WHERE rank = 2;
```
**Explanation:**  
The `RANK()` function assigns a rank to each row based on the salary in descending order. The outer query filters the result to return the employee(s) with the second-highest salary. Note that `RANK()` can handle ties (i.e., if multiple employees have the same salary).

---

### Conclusion:
- For finding the **Nth highest salary**, different databases offer different approaches, such as using correlated subqueries, `TOP` in SQL Server, `LIMIT` in MySQL, or `ROW_NUMBER()` and `RANK()` in Oracle.
- Understanding the problem's context, such as how duplicates are handled, and the specific SQL dialect you're working with, will guide you to the most efficient solution.





These queries test your SQL skill on Joins, both INNER and OUTER join, filtering records by using WHERE and HAVING clause, grouping records using GROUP BY clause, calculating the sum, average, and counting records using an aggregate function like AVG(), SUM(), and COUNT(), searching records using wildcards in LIKE operator, searching records in a bound using BETWEEN and IN clause, DATE and TIME queries, etc. 

If you have faced any interesting SQL query or you have any problem and searching for a solution, you can post it here for everyone's benefit.

### SQL Query for Ranking Employees using `ROW_NUMBER()`, `RANK()`, and `DENSE_RANK()`

Below is an SQL schema and queries for ranking employees based on their salaries using the `ROW_NUMBER()`, `RANK()`, and `DENSE_RANK()` window functions. This example demonstrates the key differences between the three functions when handling ties.

#### Step 1: Create the Temporary `#Employee` Table

```sql
IF OBJECT_ID('tempdb..#Employee') IS NOT NULL
    DROP TABLE #Employee;

CREATE TABLE #Employee (
    name VARCHAR(10),
    salary INT
);

-- Insert sample data
INSERT INTO #Employee (name, salary) VALUES ('Rick', 3000);
INSERT INTO #Employee (name, salary) VALUES ('John', 4000);
INSERT INTO #Employee (name, salary) VALUES ('Shane', 3000);
INSERT INTO #Employee (name, salary) VALUES ('Peter', 5000);
INSERT INTO #Employee (name, salary) VALUES ('Jackob', 7000);
INSERT INTO #Employee (name, salary) VALUES ('Sid', 1000);
```

#### Step 2: Use `ROW_NUMBER()`

The `ROW_NUMBER()` function assigns a unique number to each row, even if there are ties in the salary column. It does not account for ranking gaps.

```sql
SELECT 
    name,
    salary,
    ROW_NUMBER() OVER (ORDER BY salary DESC) AS row_number
FROM #Employee;
```

**Output:**

| name   | salary | row_number |
|--------|--------|------------|
| Jackob | 7000   | 1          |
| Peter  | 5000   | 2          |
| John   | 4000   | 3          |
| Shane  | 3000   | 4          |
| Rick   | 3000   | 5          |
| Sid    | 1000   | 6          |

Explanation: `ROW_NUMBER()` generates unique row numbers for each employee, even when there are ties in salary. In this case, Shane and Rick both have the same salary but receive distinct row numbers (4 and 5).

#### Step 3: Use `RANK()`

The `RANK()` function assigns the same rank to rows with equal values, but leaves a gap in the ranking sequence for the next unique value.

```sql
SELECT 
    name,
    salary,
    RANK() OVER (ORDER BY salary DESC) AS rank
FROM #Employee;
```

**Output:**

| name   | salary | rank |
|--------|--------|------|
| Jackob | 7000   | 1    |
| Peter  | 5000   | 2    |
| John   | 4000   | 3    |
| Shane  | 3000   | 4    |
| Rick   | 3000   | 4    |
| Sid    | 1000   | 6    |

Explanation: `RANK()` assigns the same rank (4) to Shane and Rick, but the next rank is 6, leaving a gap in the sequence after a tie.

#### Step 4: Use `DENSE_RANK()`

The `DENSE_RANK()` function also assigns the same rank to tied rows but does not leave gaps in the ranking sequence.

```sql
SELECT 
    name,
    salary,
    DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_rank
FROM #Employee;
```

**Output:**

| name   | salary | dense_rank |
|--------|--------|------------|
| Jackob | 7000   | 1          |
| Peter  | 5000   | 2          |
| John   | 4000   | 3          |
| Shane  | 3000   | 4          |
| Rick   | 3000   | 4          |
| Sid    | 1000   | 5          |

Explanation: `DENSE_RANK()` also assigns the same rank (4) to Shane and Rick, but the next rank is 5, without any gaps in the ranking.

#### Step 5: Compare Results

To compare all three ranking functions in one query:

```sql
SELECT 
    name,
    salary,
    ROW_NUMBER() OVER (ORDER BY salary DESC) AS row_number,
    RANK() OVER (ORDER BY salary DESC) AS rank,
    DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_rank
FROM #Employee;
```

**Output:**

| name   | salary | row_number | rank | dense_rank |
|--------|--------|------------|------|------------|
| Jackob | 7000   | 1          | 1    | 1          |
| Peter  | 5000   | 2          | 2    | 2          |
| John   | 4000   | 3          | 3    | 3          |
| Shane  | 3000   | 4          | 4    | 4          |
| Rick   | 3000   | 5          | 4    | 4          |
| Sid    | 1000   | 6          | 6    | 5          |

### Key Differences:

1. **`ROW_NUMBER()`**:
   - Generates a unique number for each row.
   - Even if there are ties, each row gets a unique rank (no gaps).
   
2. **`RANK()`**:
   - Assigns the same rank to tied rows.
   - Leaves a gap in the rank sequence after a tie.
   
3. **`DENSE_RANK()`**:
   - Assigns the same rank to tied rows.
   - Does not leave a gap in the rank sequence after a tie (ranks are dense).

### Conclusion:
- Use `ROW_NUMBER()` when you need a unique ranking for each row regardless of ties.
- Use `RANK()` when you want tied rows to have the same rank, but with a gap in the ranking sequence for the next distinct value.
- Use `DENSE_RANK()` when you want tied rows to have the same rank, with no gaps in the sequence.

These differences are particularly important when dealing with ordered data, such as salaries, in business applications or competitive ranking systems.
Here are the most common SQL query interview questions and answers that are often asked in technical job interviews:

### 1. **SQL Query to Find the Second Highest Salary of an Employee**
   - **Answer**: You can find the second highest salary using a subquery:
     ```sql
     SELECT MAX(Salary) 
     FROM Employee 
     WHERE Salary NOT IN (SELECT MAX(Salary) FROM Employee);
     ```

### 2. **SQL Query to Find Max Salary from Each Department**
   - **Answer**: Use `GROUP BY` with `MAX()`:
     ```sql
     SELECT DeptID, MAX(Salary) 
     FROM Employee 
     GROUP BY DeptID;
     ```

     To display the department name instead of `DeptID`, you can join the `Employee` table with the `Department` table:
     ```sql
     SELECT DeptName, MAX(Salary)
     FROM Employee e
     RIGHT JOIN Department d ON e.DeptID = d.DeptID
     GROUP BY DeptName;
     ```

### 3. **SQL Query to Display the Current Date**
   - **Answer**: Use `GETDATE()` in SQL Server:
     ```sql
     SELECT GETDATE();
     ```

### 4. **SQL Query to Check if a Date is in a Given Format**
   - **Answer**: Use the `ISDATE()` function in SQL Server:
     ```sql
     SELECT ISDATE('01/08/13') AS "MM/DD/YY";
     ```

### 5. **SQL Query to Find Employees Whose DOB is Between 01/01/1960 and 31/12/1975**
   - **Answer**:
     ```sql
     SELECT DISTINCT EmpName
     FROM Employees 
     WHERE DOB BETWEEN '1960-01-01' AND '1975-12-31';
     ```

### 6. **SQL Query to Find the Number of Employees According to Gender Whose DOB is Between 01/01/1960 and 31/12/1975**
   - **Answer**:
     ```sql
     SELECT COUNT(*), sex 
     FROM Employees  
     WHERE DOB BETWEEN '1960-01-01' AND '1975-12-31'
     GROUP BY sex;
     ```

### 7. **SQL Query to Find Employees with Salary >= 10000**
   - **Answer**:
     ```sql
     SELECT EmpName 
     FROM Employees 
     WHERE Salary >= 10000;
     ```

### 8. **SQL Query to Find Employees Whose Name Starts with ‘M’**
   - **Answer**:
     ```sql
     SELECT * FROM Employees 
     WHERE EmpName LIKE 'M%';
     ```

### 9. **SQL Query to Find Employees Whose Name Contains the Word "Joe" (Case-Insensitive)**
   - **Answer**: Use `UPPER()` and `LIKE`:
     ```sql
     SELECT * FROM Employees 
     WHERE UPPER(EmpName) LIKE '%JOE%';
     ```

### 10. **SQL Query to Extract the Year from a Date**
   - **Answer**:
     ```sql
     SELECT YEAR(GETDATE()) AS "Year";
     ```

### 11. **SQL Query to Find Duplicate Rows and Delete Them**
   - **Answer**:
     To select duplicates:
     ```sql
     SELECT * 
     FROM emp a 
     WHERE rowid = (SELECT MAX(rowid) 
                    FROM EMP b 
                    WHERE a.empno = b.empno);
     ```
     To delete duplicates:
     ```sql
     DELETE FROM emp a 
     WHERE rowid != (SELECT MAX(rowid) 
                     FROM emp b 
                     WHERE a.empno = b.empno);
     ```

### 12. **SQL Query to Find Students Whose Marks are Greater Than the Average Marks**
   - **Answer**:
     ```sql
     SELECT student, marks
     FROM table
     WHERE marks > (SELECT AVG(marks) FROM table);
     ```

### 13. **SQL Query to Find Employees Who Are Also Managers**
   - **Answer**: Use self-join:
     ```sql
     SELECT e.name, m.name 
     FROM Employee e, Employee m 
     WHERE e.mgr_id = m.emp_id;
     ```

     To include employees without managers, use `LEFT OUTER JOIN`:
     ```sql
     SELECT e.name, m.name 
     FROM Employee e
     LEFT JOIN Employee m ON e.mgr_id = m.emp_id;
     ```

### 14. **Will a Composite Index Be Used if Only Two Columns are Given in the WHERE Clause?**
   - **Answer**: The index will be used only if the first columns of the composite index are provided. For example, if the index is on `(EmpId, EmpFirstName, EmpLastName)`, the query:
     ```sql
     SELECT * FROM Employee WHERE EmpId = 2 AND EmpFirstName = 'Radhe';
     ```
     will use the index because `EmpId` is the first column.

### 15. **How to Use EXISTS and NOT EXISTS in SQL?**
   - **Scenario**: Finding customers who have never ordered anything:
     - **Using `NOT EXISTS`**:
       ```sql
       SELECT C.Name 
       FROM Customers C 
       WHERE NOT EXISTS (SELECT 1 FROM Orders O WHERE C.Id = O.CustomerId);
       ```

   - **Using `LEFT JOIN` (alternative)**:
     ```sql
     SELECT C.Name
     FROM Customers C
     LEFT JOIN Orders O ON C.Id = O.CustomerId
     WHERE O.CustomerId IS NULL;
     ```

   - **Using `NOT IN` (alternative)**:
     ```sql
     SELECT A.Name
     FROM Customers A
     WHERE A.Id NOT IN (SELECT B.CustomerId FROM Orders B);
     ```

### 16. **SQL Query to Find the Number of Rows in a Table**
   - **Answer**:
     ```sql
     SELECT COUNT(*) FROM table_name;
     ```

### 17. **SQL Query to Find the Maximum, Minimum, and Average Salary in a Department**
   - **Answer**:
     ```sql
     SELECT DeptID, MAX(Salary), MIN(Salary), AVG(Salary)
     FROM Employee
     GROUP BY DeptID;
     ```

### 18. **SQL Query to Find Employees with a Specific Pattern in Their Name**
   - **Answer**: Use `LIKE` with a wildcard:
     ```sql
     SELECT * FROM Employees 
     WHERE EmpName LIKE '%John%';
     ```

### 19. **SQL Query to Update Employee Salary by 10%**
   - **Answer**:
     ```sql
     UPDATE Employees
     SET Salary = Salary * 1.10
     WHERE DeptID = 1;
     ```

### 20. **SQL Query to Delete Employees Who Have Not Been Assigned to Any Department**
   - **Answer**:
     ```sql
     DELETE FROM Employees 
     WHERE DeptID IS NULL;
     ```

These questions and answers cover a range of SQL concepts, from basic querying to more advanced topics like subqueries, joins, and functions. Practicing these will help prepare for SQL interviews.

### Difference Between Self Join and Equi Join in SQL (with INNER JOIN Example)

#### **1. Self Join**
- A **Self Join** is a type of join where a table is joined to itself.
- It is commonly used when you want to relate rows within the same table based on some relationship or condition.
- You can use **table aliases** to differentiate between the two instances of the same table.

#### Example Use Case of Self Join:
Let’s consider an **Employee** table where each employee may have a manager, and the manager's employee ID is stored in the `mgr_id` column.

Here's how to find employees who are managers in a self join:
```sql
SELECT DISTINCT e.emp_id, e.emp_name 
FROM employee e 
JOIN employee m ON e.emp_id = m.mgr_id;
```
- In this query, the table **employee** is aliased as **e** for employees and **m** for managers. The join condition is where an employee's ID matches the manager's ID in another instance of the **employee** table.
- This is an example of a **self-join** where we join the table to itself.

#### **2. Equi Join**
- An **Equi Join** is a type of join where two tables are joined based on equality. This is a general concept and can occur in various types of joins like **INNER JOIN**, **LEFT JOIN**, etc.
- The distinguishing feature of an Equi Join is that it uses the equality operator `=` in the **join predicate** (the condition for the join).
- While an Equi Join could involve multiple tables, it can also be used in a **self join** when the condition for joining is based on equality.

#### Example Use Case of Equi Join:
In the **Employee** table, if we want to find all employees and their managers, we can use an Equi Join as follows:
```sql
SELECT e.emp_id, e.emp_name, m.emp_name AS manager_name
FROM employee e
JOIN employee m ON e.mgr_id = m.emp_id;
```
- This query finds each employee along with their manager’s name. The `ON e.mgr_id = m.emp_id` is an **Equi Join** condition because it uses the equality operator to match the `mgr_id` from the employee table to the `emp_id` of another instance of the employee table.

#### **Key Differences Between Self Join and Equi Join**
- **Self Join**:
  - Involves joining **one table** to itself.
  - Typically used to establish relationships between rows in the same table, such as finding hierarchical relationships (e.g., employee-manager relationships).
  - Requires the use of **aliases** to differentiate between instances of the same table.

- **Equi Join**:
  - Involves **two or more tables** being joined using the equality operator (`=`).
  - The join predicate specifically involves matching equal values between columns from different tables or different instances of the same table.
  - An **Equi Join** can be used in any type of join, such as **INNER JOIN**, **LEFT JOIN**, etc., and can also be part of a **Self Join** if the join condition uses equality.

#### **Summary of Key Concepts**
- **Self Join**: A join where a table is joined with itself, typically used for relationships within the same table.
- **Equi Join**: A join where equality (`=`) is used as the join condition between columns from two tables (or two instances of the same table), and can be applied in any join type (INNER, OUTER, etc.).

In the example provided in the article, the query:
```sql
SELECT DISTINCT e.emp_id, e.emp_name
FROM employee e 
JOIN employee m ON e.emp_id = m.mgr_id;
```
is both a **Self Join** and an **Equi Join**, because:
- It joins **one table to itself** (Self Join).
- It uses the equality operator (`=`) as the condition in the join (Equi Join).

So, **Self Join** and **Equi Join** can overlap in certain situations, but they are conceptually different: a self join is about joining a table to itself, while an equi join refers to the use of the equality condition to match rows from different tables.

### Referential Integrity in SQL: Overview and MySQL Example

**Referential Integrity** ensures that relationships between tables remain consistent. It is maintained through **foreign key constraints**, which prevent the insertion of invalid data into the child table based on the parent table’s data. This means that a record in the child table must reference an existing record in the parent table. If the data does not conform to this rule, the insert or update will fail.

### Key Points:
- **Foreign Keys** link child tables to parent tables.
- Referential Integrity ensures that no orphaned records are left in the child table, which would otherwise have no corresponding parent.
- For example, if a child table (`Order`) references a parent table (`Customer`), a new order cannot be created without a corresponding customer.

### Example of Referential Integrity in MySQL

#### Step 1: Create Parent and Child Tables
Consider two tables: **Department** (parent) and **Employee** (child). The `Employee` table has a foreign key that references the `Department` table.

```sql
CREATE TABLE Department (
    dept_id INT NOT NULL,
    dept_name VARCHAR(256),
    PRIMARY KEY (dept_id)
) ENGINE=INNODB;

CREATE TABLE Employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(256),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id) ON DELETE CASCADE
) ENGINE=INNODB;
```

- `dept_id` in **Employee** is a foreign key referencing `dept_id` in **Department**.
- The `ON DELETE CASCADE` clause ensures that if a record in the parent table (`Department`) is deleted, all corresponding child records in the `Employee` table are automatically deleted.

#### Step 2: Insert Data into Parent Table
Insert a record into the **Department** table.

```sql
INSERT INTO Department VALUES (1, 'Sales');
```

#### Step 3: Insert Data into Child Table
Now, attempt to insert a record into the **Employee** table with a `dept_id` that does not exist in the **Department** table.

```sql
INSERT INTO Employee VALUES (101, 'Rajeev', 2);
```

**Error**: 

```
ERROR 1452 (23000): Cannot ADD OR UPDATE a child row: a FOREIGN KEY constraint fails (`test`.`employee`, CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE)
```

This failure occurs because there is no department with `dept_id = 2` in the parent **Department** table. Referential Integrity prevents this invalid insert.

#### Step 4: Correct Insert into Child Table
Now, insert a valid record where the `dept_id` exists in the **Department** table.

```sql
INSERT INTO Employee VALUES (101, 'Rajeev', 1);
```

This query succeeds because `dept_id = 1` exists in the **Department** table.

#### Step 5: Delete Record in Parent Table
If you delete the record from the **Department** table, all related records in the **Employee** table will also be deleted due to the `ON DELETE CASCADE` rule.

```sql
DELETE FROM Department WHERE dept_id = 1;
```

Check the **Employee** table to confirm:

```sql
SELECT * FROM Employee;
```

The result will be empty because the employee with `dept_id = 1` has been deleted automatically.

### Advantages of Referential Integrity

1. **Prevents Invalid Data**: Prevents inserting records with invalid foreign key values (e.g., an employee without a valid department).
2. **Automatic Cleanup**: Automatically deletes or updates child records when the parent record is deleted or updated (using **CASCADE**).
3. **Maintains Data Consistency**: Ensures that relationships between tables are always valid.

---

### Joining Three Tables in SQL

To join three tables in a single query, you use the `JOIN` clause to combine data from multiple tables based on their relationships.

#### General Syntax for Joining Three Tables:

```sql
SELECT t1.column_name, t2.column_name, t3.column_name
FROM table1 t1
JOIN table2 t2 ON t1.primary_key = t2.foreign_key
JOIN table3 t3 ON t2.primary_key = t3.foreign_key;
```

#### Example: Joining Employee, Register, and Department Tables

Consider the following tables:
- **Employee**: Stores employee data (`emp_id` as primary key).
- **Department**: Stores department data (`dept_id` as primary key).
- **Register**: Links employees and departments (stores `emp_id` and `dept_id` as foreign keys).

```sql
SELECT * FROM Employee;
-- Result:
-- +--------+----------+--------+
-- | emp_id | emp_name | salary |
-- +--------+----------+--------+
-- | 1      | James    | 2000   |
-- | 2      | Jack     | 4000   |
-- | 3      | Henry    | 6000   |
-- | 4      | Tom      | 8000   |
-- +--------+----------+--------+

SELECT * FROM Department;
-- Result:
-- +---------+-----------+
-- | dept_id | dept_name |
-- +---------+-----------+
-- | 101     | Sales     |
-- | 102     | Marketing |
-- | 103     | Finance   |
-- +---------+-----------+

SELECT * FROM Register;
-- Result:
-- +--------+---------+
-- | emp_id | dept_id |
-- +--------+---------+
-- | 1      | 101     |
-- | 2      | 102     |
-- | 3      | 103     |
-- | 4      | 102     |
-- +--------+---------+
```

Now, to join these tables and display the employee names along with their respective department names:

```sql
SELECT emp_name, dept_name
FROM Employee e
JOIN Register r ON e.emp_id = r.emp_id
JOIN Department d ON r.dept_id = d.dept_id;
```

**Result**:
```
+----------+-----------+
| emp_name | dept_name |
+----------+-----------+
| James    | Sales     |
| Jack     | Marketing |
| Henry    | Finance   |
| Tom      | Marketing |
+----------+-----------+
```

Here:
- First, the **Employee** table is joined with the **Register** table on `emp_id`.
- Then, the **Register** table is joined with the **Department** table on `dept_id`.

This is a simple example of joining three tables, and the query can be extended to include more tables as needed.

### Conclusion

- **Referential Integrity** ensures the validity of data relationships between parent and child tables, preventing errors like inserting invalid foreign keys or orphaned records.
- **SQL Joins** help retrieve data from multiple tables based on defined relationships, and mastering them is crucial for complex queries, especially in relational databases like MySQL.

Both concepts are fundamental for maintaining clean, reliable data in a relational database system.

### Difference Between WHERE and HAVING Clause in SQL

The `WHERE` and `HAVING` clauses are both used to filter data in SQL, but they serve different purposes and are used in different scenarios. Here's a breakdown of their differences:

### 1. **Purpose**:

- **WHERE Clause**: 
  - The `WHERE` clause filters records **before** any grouping takes place. It applies conditions to rows before any aggregation or grouping occurs.
  - It is used for filtering rows at the **individual record level** (non-aggregated data).

- **HAVING Clause**:
  - The `HAVING` clause filters records **after** grouping has occurred. It applies conditions to the grouped data.
  - It is used for filtering on **aggregated data**, such as the result of `COUNT()`, `SUM()`, `AVG()`, etc.

### 2. **Usage with GROUP BY**:
- **WHERE** can be used without `GROUP BY` and can filter records before the grouping happens. It works on individual rows.
- **HAVING** is **only used with GROUP BY** (though it can be used without `GROUP BY` in certain cases). It filters records after grouping and applies conditions to aggregate functions.

### 3. **Aggregates**:
- **WHERE** cannot filter on aggregate functions like `COUNT()`, `SUM()`, `AVG()`, `MIN()`, or `MAX()`. It only works with the individual row-level data.
- **HAVING** can filter on aggregate functions because it is applied after the data has been grouped and aggregated.

### 4. **Execution Order**:
- **WHERE** is executed **before** the `GROUP BY` clause.
- **HAVING** is executed **after** the `GROUP BY` clause.

### 5. **Index Usage**:
- **WHERE** can utilize indexes to improve query performance (for non-aggregated columns).
- **HAVING** does not typically use indexes because it's applied after the aggregation is performed.

### 6. **Syntax Example**:
```sql
-- WHERE example (no GROUP BY)
SELECT * 
FROM Employees
WHERE salary > 50000;

-- WHERE with GROUP BY (filters before grouping)
SELECT department, AVG(salary)
FROM Employees
WHERE salary > 50000
GROUP BY department;

-- HAVING example (filters after grouping)
SELECT department, AVG(salary)
FROM Employees
GROUP BY department
HAVING AVG(salary) > 50000;
```

### 7. **Performance Considerations**:
- **WHERE** generally performs better than **HAVING** because it filters the rows before the grouping and aggregation, thus reducing the number of rows that need to be processed.
- **HAVING** is used to filter the results **after** grouping, which can be less efficient as it requires processing of more data before applying the filter.

### 8. **Use Case Example**:

Consider a `Sales` table:

| product_id | product_name | quantity | price  |
|------------|--------------|----------|--------|
| 1          | Widget       | 100      | 15.99  |
| 2          | Gadget       | 150      | 22.99  |
| 3          | Doodad       | 200      | 10.99  |
| 4          | Gizmo        | 50       | 25.99  |

#### Query to find products with total sales above $1000:
```sql
SELECT product_name, SUM(quantity * price) AS total_sales
FROM Sales
GROUP BY product_name
HAVING SUM(quantity * price) > 1000;
```

- **WHERE clause** can filter out rows before the aggregation:
  ```sql
  SELECT product_name, SUM(quantity * price) AS total_sales
  FROM Sales
  WHERE price > 15
  GROUP BY product_name
  HAVING SUM(quantity * price) > 1000;
  ```
  
- Here, the **WHERE** clause filters rows before grouping based on the `price` condition, and the **HAVING** clause filters out groups that do not meet the total sales condition.

### Summary of Differences:

| Aspect                | WHERE                          | HAVING                          |
|-----------------------|--------------------------------|---------------------------------|
| **Purpose**           | Filters rows before grouping   | Filters rows after grouping     |
| **Used with**         | SELECT, UPDATE, DELETE         | SELECT (with GROUP BY)          |
| **Aggregate Functions** | Cannot use aggregate functions | Can use aggregate functions     |
| **Execution Order**   | Executed before `GROUP BY`     | Executed after `GROUP BY`       |
| **Index Usage**       | Can use indexes                | Does not use indexes            |

### When to Use:
- Use **WHERE** when you want to filter rows before any aggregation or grouping is applied (e.g., filtering records based on column values).
- Use **HAVING** when you need to filter on aggregated results (e.g., filtering groups that meet certain conditions, such as the count of records or sum of values).

By understanding these differences, you can decide which clause to use depending on the type of filtering you need to perform in your SQL queries.

### **Difference Between UNION vs UNION ALL in SQL**

Both `UNION` and `UNION ALL` are used to combine the results of two or more `SELECT` queries. While they serve the same purpose, they have key differences that affect the results they return, their performance, and how they handle duplicates.

#### **1. Duplicates Handling:**
   - **UNION**: Removes duplicate rows from the result set. This means that if the same row appears in both queries, only one instance of that row will be included in the final result.
   - **UNION ALL**: Includes all rows from both queries, including duplicates. If a row appears in both queries, it will appear twice in the result.

   **Example:**
   - Query 1 returns: `1, 2, 3`
   - Query 2 returns: `3, 4, 5`

   - **Using `UNION`:**  
     Result: `1, 2, 3, 4, 5`  
     (The duplicate `3` is removed.)
   
   - **Using `UNION ALL`:**  
     Result: `1, 2, 3, 3, 4, 5`  
     (Duplicates are retained.)

#### **2. Performance:**
   - **UNION**: Generally slower because it performs an additional operation to eliminate duplicates from the result set. This involves sorting and comparing the rows.
   - **UNION ALL**: Faster because it doesn't perform the duplicate removal step. It simply concatenates the result sets of both queries.

   **Why is `UNION ALL` faster?**
   - It doesn't require extra computation to remove duplicates, making it more efficient when dealing with large datasets.

#### **3. Use Cases:**
   - **UNION**: Preferred when you need a result set that contains only unique rows. This is useful when you're combining data from different tables or queries where duplicates would not be meaningful, such as in reports or analytics.
   - **UNION ALL**: Ideal when you want to include all rows, including duplicates. It's useful when you're combining datasets and every row counts, such as in data warehousing or auditing applications.

#### **4. Query Structure:**
   Both `UNION` and `UNION ALL` require that the `SELECT` queries being combined must:
   - Have the same number of columns in the result set.
   - The columns in each query must have compatible data types.

   **Example of Using `UNION`:**
   ```sql
   SELECT emp_id, emp_name FROM employees
   UNION
   SELECT customer_id, customer_name FROM customers;
   ```

   **Example of Using `UNION ALL`:**
   ```sql
   SELECT emp_id, emp_name FROM employees
   UNION ALL
   SELECT customer_id, customer_name FROM customers;
   ```

#### **5. Performance Considerations (Bandwidth and Data Transfer):**
   - While `UNION ALL` is faster in terms of query execution because it doesn't remove duplicates, it can potentially transfer more data over the network (due to duplicates), which may impact performance in distributed systems with limited bandwidth.

### **Summary of Key Differences Between UNION and UNION ALL:**

| **Feature**             | **UNION**                         | **UNION ALL**                     |
|-------------------------|-----------------------------------|-----------------------------------|
| **Duplicates**          | Removes duplicates                | Keeps duplicates                  |
| **Performance**         | Slower (due to duplicate removal)  | Faster (no duplicate removal)     |
| **Use Case**            | When unique results are required  | When all results, including duplicates, are needed |
| **Query Execution**    | More resources for sorting/removal | Less resources required for execution |
| **Result Set**          | Returns only distinct rows        | Returns all rows, including duplicates |

---

### **Example of UNION and UNION ALL in SQL:**

**Scenario:**
Suppose we have two tables, `Employee` and `Customer`, both containing information about individuals, with some overlap. We will combine the results using both `UNION` and `UNION ALL` to observe the differences.

#### **Sample Data:**

**Employee Table:**
| emp_id | emp_name  |
|--------|-----------|
| 1      | John      |
| 2      | Jane      |

**Customer Table:**
| customer_id | customer_name |
|-------------|---------------|
| 2           | Jane          |
| 3           | Jake          |

#### **Query using `UNION`:**

```sql
SELECT emp_id AS id, emp_name AS name FROM Employee
UNION
SELECT customer_id AS id, customer_name AS name FROM Customer;
```

**Result using `UNION`:**
| id | name   |
|----|--------|
| 1  | John   |
| 2  | Jane   |
| 3  | Jake   |

- **Explanation:** The `UNION` operator removes the duplicate row for `Jane` (ID 2).

#### **Query using `UNION ALL`:**

```sql
SELECT emp_id AS id, emp_name AS name FROM Employee
UNION ALL
SELECT customer_id AS id, customer_name AS name FROM Customer;
```

**Result using `UNION ALL`:**
| id | name   |
|----|--------|
| 1  | John   |
| 2  | Jane   |
| 2  | Jane   |
| 3  | Jake   |

- **Explanation:** The `UNION ALL` operator keeps the duplicate row for `Jane` (ID 2) since both `Employee` and `Customer` tables contain the same data for that row.

### **Conclusion:**
- Use **`UNION`** when you need distinct rows and when duplicate rows can be discarded.
- Use **`UNION ALL`** when you need to keep all rows, including duplicates, and when performance is a priority. 

Both of these operations are widely supported across major database systems like MySQL, PostgreSQL, SQL Server, and Oracle, and understanding their differences is crucial for optimizing your queries and ensuring the correctness of your results.


Here are 20+ ArrayList-related interview questions with answers commonly asked in Java programming interviews:

---

### 1. **How to remove duplicates from an ArrayList in Java?**
**Answer**:  
To remove duplicates from an `ArrayList`, you can convert it to a `Set` and then back to an `ArrayList`, since `Set` does not allow duplicates.

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 4));
Set<Integer> set = new HashSet<>(list); // Remove duplicates
list = new ArrayList<>(set); // Convert back to ArrayList
```
If maintaining the order of the elements is important, you can use `LinkedHashSet`:
```java
Set<Integer> set = new LinkedHashSet<>(list); // Maintains order
```

---

### 2. **How to reverse an ArrayList in Java?**
**Answer**:  
You can reverse an `ArrayList` using the `Collections.reverse()` method.

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
Collections.reverse(list);
System.out.println(list); // Output: [5, 4, 3, 2, 1]
```

Alternatively, you can manually reverse the list by iterating through it in reverse order and adding elements to a new list.

---

### 3. **Difference between an array and an ArrayList in Java?**
**Answer**:  
- **Array**: Fixed size, can hold elements of a specific type only, elements are indexed from 0.
- **ArrayList**: Dynamic size, can grow or shrink as needed, part of Java Collections Framework, can hold any type of object (generics).

---

### 4. **How to synchronize ArrayList in Java?**
**Answer**:  
You can synchronize an `ArrayList` using the `Collections.synchronizedList()` method:

```java
List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
```

This makes the `ArrayList` thread-safe.

---

### 5. **When to use ArrayList and LinkedList in Java?**
**Answer**:  
- **ArrayList** is best for frequent random access and searching operations (`O(1)` time complexity). However, adding/removing elements in the middle can be slow (`O(n)` time complexity).
- **LinkedList** is best for adding/removing elements frequently at the beginning or middle of the list (`O(1)` time complexity for these operations). However, random access is slower (`O(n)` time complexity).

---

### 6. **Difference between ArrayList and HashSet in Java?**
**Answer**:  
- **ArrayList**: Allows duplicates, maintains insertion order, indexed by position.
- **HashSet**: Does not allow duplicates, does not maintain any specific order of elements.

---

### 7. **How to loop over an ArrayList in Java?**
**Answer**:  
You can loop over an `ArrayList` in several ways:

1. Using a for loop:
   ```java
   for (int i = 0; i < list.size(); i++) {
       System.out.println(list.get(i));
   }
   ```

2. Using an `Iterator`:
   ```java
   Iterator<Integer> iterator = list.iterator();
   while (iterator.hasNext()) {
       System.out.println(iterator.next());
   }
   ```

3. Using the enhanced for loop (for-each loop):
   ```java
   for (Integer num : list) {
       System.out.println(num);
   }
   ```

---

### 8. **Difference between Vector and ArrayList in Java?**
**Answer**:  
- **ArrayList** is not synchronized and is generally faster for non-threaded use cases.
- **Vector** is synchronized, making it thread-safe but slower due to the overhead of synchronization.

---

### 9. **How to create and initialize an ArrayList in one line?**
**Answer**:  
You can use `Arrays.asList()` method to initialize an `ArrayList` in one line:

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
```

However, note that this creates a fixed-size list (backed by an array) which cannot be resized.

---

### 10. **How to sort an ArrayList in Java?**
**Answer**:  
You can sort an `ArrayList` using `Collections.sort()`:

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 3));
Collections.sort(list);
System.out.println(list); // Output: [1, 2, 3, 5, 8]
```

If you want to sort in custom order, you can use a `Comparator`:

```java
Collections.sort(list, Comparator.reverseOrder());
```

---

### 11. **Difference between HashMap and ArrayList in Java?**
**Answer**:  
- **HashMap**: Stores key-value pairs, uses keys to access the values, does not allow duplicate keys, and does not maintain order.
- **ArrayList**: Stores a list of objects, accessed by index, allows duplicates, and maintains insertion order.

---

### 12. **How to use ArrayList in Java?**
**Answer**:  
You can use `ArrayList` by creating an instance and adding elements:

```java
ArrayList<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");
list.add("C++");
```

You can then access elements via the index:

```java
System.out.println(list.get(0)); // Output: Java
```

---

### 13. **How to convert an ArrayList to a String in Java?**
**Answer**:  
You can convert an `ArrayList` to a string using `toString()`:

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
String result = list.toString();
System.out.println(result); // Output: [1, 2, 3, 4, 5]
```

For a comma-separated string, use Java 8's `String.join()`:

```java
String result = String.join(",", list.stream().map(String::valueOf).toArray(String[]::new));
System.out.println(result); // Output: 1,2,3,4,5
```

---

### 14. **How to get a sublist from an ArrayList in Java?**
**Answer**:  
You can get a sublist using the `subList()` method:

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
List<Integer> sublist = list.subList(1, 4); // Index 1 to 3
System.out.println(sublist); // Output: [2, 3, 4]
```

---

### 15. **Difference between `length()` of an array and `size()` of ArrayList in Java?**
**Answer**:  
- **Array**: `length` refers to the capacity (fixed number of elements) of the array.
- **ArrayList**: `size()` returns the number of elements currently stored in the list.

---

### 16. **What is `CopyOnWriteArrayList` in Java?**
**Answer**:  
`CopyOnWriteArrayList` is a thread-safe variant of `ArrayList`. It is optimized for scenarios where reads vastly outnumber writes. Instead of locking the list, it creates a new copy of the list for each modification (write operation), ensuring that readers do not block each other.

---

### 17. **How to remove objects from an ArrayList in Java?**
**Answer**:  
You can remove an element from an `ArrayList` by either index or object:

- By index:
  ```java
  list.remove(2); // Removes the element at index 2
  ```

- By object:
  ```java
  list.remove(Integer.valueOf(3)); // Removes the element with value 3
  ```

---

### 18. **How to make an ArrayList read-only in Java?**
**Answer**:  
You can make an `ArrayList` read-only using `Collections.unmodifiableList()`:

```java
List<Integer> readOnlyList = Collections.unmodifiableList(list);
```

This prevents any modifications (like `add()` or `remove()`) to the list.

---

### 19. **How to sort an ArrayList in descending order in Java?**
**Answer**:  
You can sort in descending order using `Collections.sort()` with a custom comparator:

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 8, 1));
Collections.sort(list, Comparator.reverseOrder());
System.out.println(list); // Output: [8, 5, 3, 1]
```

---

### 20. **How to check if an ArrayList contains a specific element in Java?**
**Answer**:  
You can check if an element exists in an `ArrayList` using the `contains()` method:

```java
ArrayList<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
boolean containsJava = list.contains("Java");
System.out.println(containsJava); // Output: true
```

--- 

And, if you need more ArrayList questions for practice then here is a list of new ArrayList questions to answer:

How do you add multiple string values to an Arraylist in Java?
How to convert Arraylist to XML in Java?
How to print string array list in java?
How do you create an Arraylist in Excel in Java?
How to write an Arraylist of objects to a text file in Java?
How to remove special characters from Arraylist in Java?
How do you make a generic Arraylist in Java?
How to iterate an Arraylist inside a Hashmap using Java?
How to get key and value from Arraylist in Java?
How to find even numbers in an Arraylist in Java?
How to convert Arraynode to Arraylist in Java?
How do you initialize a two dimensional Arraylist in Java?
How to parse JSON Arraylist in Java?
How to retrieve object values from Arraylist in Java 8?
How to check if an Arraylist is sorted in Java?
How to find the difference between two Arraylists in Java?
How to convert Arraylist to CSV in Java?
How to sort 2 Arraylist in Java?
How do you add two values to an Arraylist in Java?
How to get key from Arraylist in Java?
How do you write a loop for an Arraylist in Java?
How do you declare an Arraylist variable in Java?
What is the size of empty Arraylist in Java?
How do you add a unique element to an Arraylist in Java?
How do you remove blank spaces from an Arraylist in Java?
How to print duplicate values in Arraylist in Java?
How to get an Arraylist from another method in Java?
How do you implement an Arraylist in Java?
How do you remove duplicate employee objects from Arraylist in Java?
How do you write an Arraylist to a text file in Java?
How do you remove one element from an Arraylist in Java?
How do you add an Arraylist to a string array in Java?
How do you create an Arraylist of a class object in Java?
How to inherit Arraylist in Java?
How do you fill an array list in java?
How do you make an Arraylist an array in Java?
How to compare two Arraylists of different size in Java?
How to validate Arraylist in Java?
How to compare two Arraylist of objects in Java and find difference?
Can Arraylist be static in Java?
How do you remove square brackets from an Arraylist in Java?
How to get specific object from Arraylist in Java 8?
How do you create an Arraylist list in Java?
How do you initialize an Arraylist of objects in Java?
How to iterate Arraylist of Linkedhashmap in Java?
How to add elements to an Arraylist in Java using for loop?
How do you fill an Arraylist in Java?
How to write an Arraylist to a CSV file in Java?
What is the initial size of Arraylist in Java?
How do you add elements to an Arraylist for a loop in Java?
How do you pass an Arraylist as an argument in Java?
How to assign values to an Arraylist in Java?
How do you assign a value to an Arraylist in Java?
How do you add an Arraylist to an array in Java?
How many elements can an Arraylist hold Java?
How do you return an Arraylist to a string in Java?
How do you add different objects to an Arraylist in Java?
How to store array list in java?
How do you add a key value pair to an Arraylist in Java?
How to Add Employee object to Arraylist in Java?
How do you make an Arraylist anonymous in Java?
How to get user input in Arraylist in Java?
How do I change the order of an arraylist in Java?
How to get value from Arraylist of objects in Java?
How do you process an Arraylist in Java?
How do you make an Arraylist immutable in Java?
How to store Arraylist data into Excel in Java?
How do you add an int to an Arraylist in Java?
How to process Arraylist in Java?
How to add object array to Arraylist in Java?
How do you assign a string value to an Arraylist in Java?
How to get input from user in Arraylist in Java?
What does Arraylist mean in Java?
How to create a float Arraylist in Java?
How to add employee objects to Arraylist in Java?
How to override equals method in Arraylist Java?

Here’s a comprehensive guide to addressing each of the tasks and questions related to `ArrayList` in Java:

### 1. **Add Multiple String Values to an ArrayList**

You can use the `addAll()` method to add multiple elements to an `ArrayList`.

```java
import java.util.ArrayList;
import java.util.Arrays;

public class AddMultipleStrings {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println(list);
    }
}
```

### 2. **Convert ArrayList to XML**

To convert an `ArrayList` to XML, you can use a library like JAXB or manually construct the XML using string manipulation.

**Using JAXB:**

```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;

public class ArrayListToXML {
    public static void main(String[] args) throws JAXBException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        
        JAXBContext context = JAXBContext.newInstance(ArrayList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(list, System.out);
    }
}
```

### 3. **Print String ArrayList**

```java
import java.util.ArrayList;

public class PrintArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.forEach(System.out::println);
    }
}
```

### 4. **Create an ArrayList in Excel**

To create an `ArrayList` in Excel, you generally use libraries like Apache POI.

```java
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToExcel {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        
        int rowNum = 0;
        for (String item : list) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(item);
        }

        try (FileOutputStream fileOut = new FileOutputStream("list.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
    }
}
```

### 5. **Write ArrayList of Objects to a Text File**

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteArrayListToFile {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("list.txt"))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
        }
    }
}
```

### 6. **Remove Special Characters from ArrayList**

```java
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RemoveSpecialCharacters {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ap!ple");
        list.add("Ba@na-na");

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        for (int i = 0; i < list.size(); i++) {
            list.set(i, pattern.matcher(list.get(i)).replaceAll(""));
        }

        System.out.println(list);
    }
}
```

### 7. **Create a Generic ArrayList**

```java
import java.util.ArrayList;

public class GenericArrayList {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Integer> integerList = new ArrayList<>();
        
        stringList.add("Hello");
        integerList.add(123);
        
        System.out.println(stringList);
        System.out.println(integerList);
    }
}
```

### 8. **Iterate an ArrayList Inside a HashMap**

```java
import java.util.ArrayList;
import java.util.HashMap;

public class IterateArrayListInHashMap {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        map.put("Numbers", values);

        for (ArrayList<Integer> list : map.values()) {
            for (Integer num : list) {
                System.out.println(num);
            }
        }
    }
}
```

### 9. **Get Key and Value from ArrayList**

You generally access keys and values in `Map` objects rather than `ArrayList`. If you meant to get elements from a list:

```java
import java.util.ArrayList;

public class GetKeyValueFromArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index: " + i + ", Value: " + list.get(i));
        }
    }
}
```

### 10. **Find Even Numbers in an ArrayList**

```java
import java.util.ArrayList;

public class FindEvenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.stream()
            .filter(num -> num % 2 == 0)
            .forEach(System.out::println);
    }
}
```

### 11. **Convert ArrayNode to ArrayList**

Assuming you're using Jackson for JSON processing:

```java
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayNodeToArrayList {
    public static void main(String[] args) throws IOException {
        String json = "[\"Apple\", \"Banana\", \"Cherry\"]";
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = (ArrayNode) mapper.readTree(json);

        List<String> list = new ArrayList<>();
        Iterator<JsonNode> elements = arrayNode.elements();
        while (elements.hasNext()) {
            list.add(elements.next().asText());
        }

        System.out.println(list);
    }
}
```

### 12. **Initialize a Two-Dimensional ArrayList**

```java
import java.util.ArrayList;

public class TwoDimensionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> twoDList = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(i * j);
            }
            twoDList.add(row);
        }

        System.out.println(twoDList);
    }
}
```

### 13. **Parse JSON ArrayList**

Using Jackson library:

```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJSONArrayList {
    public static void main(String[] args) throws IOException {
        String json = "[\"Apple\", \"Banana\", \"Cherry\"]";
        ObjectMapper mapper = new ObjectMapper();

        List<String> list = mapper.readValue(json, new TypeReference<ArrayList<String>>() {});
        System.out.println(list);
    }
}
```

### 14. **Retrieve Object Values from ArrayList in Java 8**

Using streams:

```java
import java.util.ArrayList;
import java.util.List;

public class RetrieveValues {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        
        list.forEach(System.out::println);
    }
}
```

### 15. **Check if an ArrayList is Sorted**

```java
import java.util.ArrayList;
import java.util.Collections;

public class CheckIfSorted {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        boolean isSorted = list.stream()
                               .sorted()
                               .toList()
                               .equals(list);
        System.out.println("Is sorted: " + isSorted);
    }
}
```

### 16. **Find the Difference Between Two ArrayLists**

```java
import java.util.ArrayList;
import java.util.List;

public class DifferenceBetweenLists {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        
        List<String> list2 = new ArrayList<>();
        list2.add("Banana");
        list2.add("Cherry");
        
       

 List<String> diff = new ArrayList<>(list1);
        diff.removeAll(list2);
        System.out.println("Difference: " + diff);
    }
}
```

### 17. **Convert ArrayList to CSV**

```java
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayListToCSV {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        try (FileWriter writer = new FileWriter("list.csv")) {
            for (String item : list) {
                writer.write(item + "\n");
            }
        }
    }
}
```

### 18. **Sort Two ArrayLists**

```java
import java.util.ArrayList;
import java.util.Collections;

public class SortTwoArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(1);
        
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        System.out.println("Sorted list1: " + list1);
        System.out.println("Sorted list2: " + list2);
    }
}
```

### 19. **Add Two Values to an ArrayList**

```java
import java.util.ArrayList;

public class AddTwoValues {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
    }
}
```

### 20. **Get Key from ArrayList**

If you meant elements or index:

```java
import java.util.ArrayList;

public class GetElementFromArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        System.out.println("Element at index 1: " + list.get(1));
    }
}
```

### 21. **Write a Loop for an ArrayList**

```java
import java.util.ArrayList;

public class LoopArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        
        for (String item : list) {
            System.out.println(item);
        }
    }
}
```

### 22. **Declare an ArrayList Variable**

```java
import java.util.ArrayList;

public class DeclareArrayListVariable {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
    }
}
```

### 23. **Size of Empty ArrayList**

```java
import java.util.ArrayList;

public class SizeOfEmptyArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Size: " + list.size()); // Output: 0
    }
}
```

### 24. **Add a Unique Element to an ArrayList**

Use a `Set` to ensure uniqueness before adding to the `ArrayList`.

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AddUniqueElement {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        
        String newElement = "Apple";
        if (set.add(newElement)) { // Only add if it's not already present
            list.add(newElement);
        }
        System.out.println(list);
    }
}
```

### 25. **Remove Blank Spaces from an ArrayList**

```java
import java.util.ArrayList;
import java.util.List;

public class RemoveBlankSpaces {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple ");
        list.add(" Banana");
        list.add(" Cherry ");

        list.replaceAll(String::trim);
        System.out.println(list);
    }
}
```

### 26. **Print Duplicate Values in ArrayList**

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintDuplicates {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");

        Set<String> duplicates = new HashSet<>();
        Set<String> unique = new HashSet<>();
        for (String item : list) {
            if (!unique.add(item)) {
                duplicates.add(item);
            }
        }

        System.out.println("Duplicates: " + duplicates);
    }
}
```

### 27. **Get an ArrayList from Another Method**

```java
import java.util.ArrayList;

public class ArrayListFromMethod {
    public static void main(String[] args) {
        ArrayList<String> list = getList();
        System.out.println(list);
    }

    public static ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        return list;
    }
}
```

### 28. **Implement an ArrayList**

`ArrayList` is a part of Java Collections Framework, and you typically use it directly without implementing it. 

### 29. **Remove Duplicate Employee Objects from ArrayList**

Assuming `Employee` class properly overrides `equals` and `hashCode`:

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Employee {
    String name;
    // Constructor, equals, hashCode omitted

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

public class RemoveDuplicateEmployees {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alice"));
        list.add(new Employee("Bob"));
        list.add(new Employee("Alice"));

        Set<Employee> unique = new HashSet<>(list);
        list = new ArrayList<>(unique);

        System.out.println(list);
    }
}
```

### 30. **Write an ArrayList to a Text File**

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteArrayListToTextFile {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("list.txt"))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
        }
    }
}
```

### 31. **Remove One Element from ArrayList**

```java
import java.util.ArrayList;

public class RemoveElementFromArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.remove("Banana");
        System.out.println(list);
    }
}
```

### 32. **Add an ArrayList to a String Array**

```java
import java.util.ArrayList;

public class AddArrayListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        String[] array = list.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }
    }
}
```

### 33. **Create an ArrayList of a Class Object**

```java
import java.util.ArrayList;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class ArrayListOfClass {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Alice"));
        list.add(new Person("Bob"));
        System.out.println(list);
    }
}
```

### 34. **Inherit ArrayList in Java**

You typically extend `ArrayList` if you need additional behavior.

```java
import java.util.ArrayList;

public class CustomArrayList<E> extends ArrayList<E> {
    // Add custom methods or override existing methods
}

public class InheritArrayList {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);
    }
}
```

### 35. **Fill an ArrayList**

```java
import java.util.ArrayList;

public class FillArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("

Item " + i);
        }
        System.out.println(list);
    }
}
```

### 36. **Make an ArrayList an Array**

```java
import java.util.ArrayList;

public class ArrayListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        String[] array = list.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }
    }
}
```

### 37. **Compare Two ArrayLists of Different Sizes**

```java
import java.util.ArrayList;
import java.util.List;

public class CompareArrayLists {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        
        List<String> list2 = new ArrayList<>();
        list2.add("Apple");
        list2.add("Banana");

        boolean isEqual = list1.size() == list2.size() && list1.containsAll(list2);
        System.out.println("Lists are equal: " + isEqual);
    }
}
```

### 38. **Validate ArrayList**

Validation typically involves checking contents or properties.

```java
import java.util.ArrayList;

public class ValidateArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        boolean isValid = !list.isEmpty();
        System.out.println("List is valid: " + isValid);
    }
}
```

### 39. **Compare Two ArrayLists of Objects and Find Difference**

```java
import java.util.ArrayList;
import java.util.List;

public class CompareArrayListsOfObjects {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("Alice"));
        list1.add(new Person("Bob"));

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Bob"));
        list2.add(new Person("Charlie"));

        List<Person> diff = new ArrayList<>(list1);
        diff.removeAll(list2);
        System.out.println("Difference: " + diff);
    }
}
```

### 40. **Can ArrayList be Static in Java?**

Yes, an `ArrayList` can be static if it is defined within a static context (e.g., inside a static method or a static class).

```java
import java.util.ArrayList;

public class StaticArrayList {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);
    }
}
```

### 41. **Remove Square Brackets from ArrayList**

```java
import java.util.ArrayList;

public class RemoveBrackets {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        String result = list.toString();
        result = result.replaceAll("\\[|\\]", "");
        System.out.println(result);
    }
}
```

### 42. **Get Specific Object from ArrayList in Java 8**

```java
import java.util.ArrayList;
import java.util.Optional;

public class GetSpecificObject {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        Optional<String> result = list.stream()
                                      .filter(item -> item.equals("Banana"))
                                      .findFirst();
        result.ifPresent(System.out::println);
    }
}
```

### 43. **Create an ArrayList List in Java**

```java
import java.util.ArrayList;
import java.util.List;

public class CreateArrayListList {
    public static void main(String[] args) {
        List<ArrayList<String>> listOfLists = new ArrayList<>();
        
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Banana");
        
        listOfLists.add(list1);
        listOfLists.add(list2);
        
        System.out.println(listOfLists);
    }
}
```

### 44. **Initialize an ArrayList of Objects**

```java
import java.util.ArrayList;

public class InitializeArrayListOfObjects {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Alice"));
        list.add(new Person("Bob"));
        System.out.println(list);
    }
}
```

### 45. **Iterate ArrayList of LinkedHashMap**

```java
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class IterateArrayListOfLinkedHashMap {
    public static void main(String[] args) {
        ArrayList<LinkedHashMap<String, String>> list = new ArrayList<>();
        
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>();
        map1.put("Key1", "Value1");
        list.add(map1);

        LinkedHashMap<String, String> map2 = new LinkedHashMap<>();
        map2.put("Key2", "Value2");
        list.add(map2);

        for (LinkedHashMap<String, String> map : list) {
            map.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }
}
```

### 46. **Add Elements to ArrayList Using For Loop**

```java
import java.util.ArrayList;

public class AddElementsUsingForLoop {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
```

### 47. **Fill an ArrayList in Java**

```java
import java.util.ArrayList;

public class FillArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println(list);
    }
}
```

### 48. **Write an ArrayList to a CSV File**

```java
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteArrayListToCSVFile {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        try (FileWriter writer = new FileWriter("list.csv")) {
            for (String item : list) {
                writer.append(item).append("\n");
            }
        }
    }
}
```

### 49. **Initial Size of ArrayList**

The initial size of an `ArrayList` is 10 by default.

```java
import java.util.ArrayList;

public class InitialSizeOfArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Initial size: " + list.size()); // Output: 0
    }
}
```

### 50. **Add Elements to ArrayList for a Loop**

```java
import java.util.ArrayList;

public class AddElementsForLoop {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Item " + i);
        }
        System.out.println(list);
    }
}
```

### 51. **Pass an ArrayList as an Argument**

```java
import java.util.ArrayList;

public class PassArrayListAsArgument {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        printList(list);
    }

    public static void printList(ArrayList<String> list) {
        list.forEach(System.out::println);
    }
}
```

### 52. **Assign Values to an ArrayList**

```java
import java.util.ArrayList;

public class AssignValuesToArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);
    }
}
```

### 53. **Assign a Value to an ArrayList**

```java
import java.util.ArrayList;

public class AssignValueToArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.set(0, "Orange"); // Update the first element
        System.out.println(list);
    }
}
```

### 54. **Add an ArrayList to an Array**

```java
import java.util.ArrayList;

public class AddArrayListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        String[] array = list.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }
    }
}
```

### 55. **How Many Elements Can an ArrayList Hold**

An `ArrayList` can hold a very large number of elements, limited by memory constraints.

### 56. **Return an ArrayList to a String**

```java
import java.util.ArrayList;
import java

.util.StringJoiner;

public class ArrayListToString {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        String result = String.join(", ", list);
        System.out.println(result);
    }
}
```

### 57. **Remove Elements from an ArrayList by Index**

```java
import java.util.ArrayList;

public class RemoveElementsByIndex {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.remove(0); // Removes "Apple"
        System.out.println(list);
    }
}
```

### 58. **Replace an Element in ArrayList**

```java
import java.util.ArrayList;

public class ReplaceElementInArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.set(1, "Cherry"); // Replace "Banana" with "Cherry"
        System.out.println(list);
    }
}
```

### 59. **Add Value to ArrayList**

```java
import java.util.ArrayList;

public class AddValueToArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        System.out.println(list);
    }
}
```

### 60. **ArrayList with Default Value**

```java
import java.util.ArrayList;

public class ArrayListWithDefaultValue {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Default");
        System.out.println(list);
    }
}
```

### 61. **Create an Empty ArrayList**

```java
import java.util.ArrayList;

public class CreateEmptyArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);
    }
}
```

### 62. **Count Values in an ArrayList**

```java
import java.util.ArrayList;

public class CountValuesInArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        System.out.println("Count: " + list.size());
    }
}
```

### 63. **ArrayList to a String Array**

```java
import java.util.ArrayList;

public class ArrayListToStringArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        String[] array = list.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }
    }
}
```

### 64. **Get Value from ArrayList**

```java
import java.util.ArrayList;

public class GetValueFromArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        System.out.println("Value at index 1: " + list.get(1));
    }
}
```

### 65. **Copy ArrayList to Another ArrayList**

```java
import java.util.ArrayList;

public class CopyArrayList {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println(list2);
    }
}
```

### 66. **Clear ArrayList**

```java
import java.util.ArrayList;

public class ClearArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        list.clear();
        System.out.println("List after clear: " + list);
    }
}
```

### 67. **Add an Element to the End of ArrayList**

```java
import java.util.ArrayList;

public class AddElementToEnd {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println(list);
    }
}
```

### 68. **Print ArrayList Elements**

```java
import java.util.ArrayList;

public class PrintArrayListElements {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        for (String item : list) {
            System.out.println(item);
        }
    }
}
```

### 69. **Initialize ArrayList with Values**

```java
import java.util.ArrayList;

public class InitializeArrayListWithValues {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);
    }
}
```

### 70. **Combine Two ArrayLists**

```java
import java.util.ArrayList;

public class CombineArrayLists {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Banana");

        list1.addAll(list2);
        System.out.println(list1);
    }
}
```

### 71. **Find Largest Value in ArrayList**

```java
import java.util.ArrayList;

public class FindLargestValue {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);

        int max = list.stream().max(Integer::compareTo).orElseThrow();
        System.out.println("Largest value: " + max);
    }
}
```

### 72. **Find Smallest Value in ArrayList**

```java
import java.util.ArrayList;

public class FindSmallestValue {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);

        int min = list.stream().min(Integer::compareTo).orElseThrow();
        System.out.println("Smallest value: " + min);
    }
}
```

### 73. **Sort an ArrayList**

```java
import java.util.ArrayList;
import java.util.Collections;

public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");

        Collections.sort(list);
        System.out.println(list);
    }
}
```

### 74. **Find Index of Element in ArrayList**

```java
import java.util.ArrayList;

public class FindIndexInArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        int index = list.indexOf("Banana");
        System.out.println("Index of Banana: " + index);
    }
}
```

### 75. **Check if ArrayList Contains an Element**

```java
import java.util.ArrayList;

public class CheckIfArrayListContains {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        boolean contains = list.contains("Banana");
        System.out.println("Contains Banana: " + contains);
    }
}
```

### 76. **Replace All Occurrences of an Element**

```java
import java.util.ArrayList;

public class ReplaceAllOccurrences {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");

        list.replaceAll(s -> s.equals("Apple") ? "Orange" : s);
        System.out.println(list);
    }
}
```

### 77. **ArrayList Methods**

Common `ArrayList` methods include `add()`, `remove()`, `get()`, `set()`, `clear()`, `size()`, `isEmpty()`, `contains()`, `indexOf()`, and `toArray()`.

### 78. **ArrayList to JSON**

Using a library like Jackson or Gson is the common approach.

Using Gson:

```java
import com.google.gson.Gson;
import java.util.ArrayList;

public class ArrayListToJson {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
```

### 79. **Find Common Elements in Two ArrayLists**

```java
import java.util.ArrayList;
import java.util.List;

public class FindCommonElements {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        List<String> list2 = new ArrayList<>();
        list2.add("Banana");
        list2.add("Cherry");

        list1.retainAll(list2);
        System

.out.println("Common elements: " + list1);
    }
}
```

### 80. **Remove Duplicates from ArrayList**

```java
import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");

        HashSet<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

        System.out.println(list);
    }
}
```

### 81. **Check if ArrayList is Empty**

```java
import java.util.ArrayList;

public class CheckIfEmpty {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Is empty: " + list.isEmpty());
    }
}
```

### 82. **ArrayList to LinkedList**

```java
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListToLinkedList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");

        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        System.out.println(linkedList);
    }
}
```

### 83. **Convert ArrayList to a HashSet**

```java
import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListToHashSet {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        HashSet<String> set = new HashSet<>(list);
        System.out.println(set);
    }
}
```

### 84. **Initialize ArrayList in Constructor**

```java
import java.util.ArrayList;

public class InitializeArrayListInConstructor {
    ArrayList<String> list;

    public InitializeArrayListInConstructor() {
        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
    }

    public static void main(String[] args) {
        InitializeArrayListInConstructor obj = new InitializeArrayListInConstructor();
        System.out.println(obj.list);
    }
}
```

### 85. **Check Size of ArrayList**

```java
import java.util.ArrayList;

public class CheckSizeOfArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        System.out.println("Size of list: " + list.size());
    }
}
```

### 86. **Print ArrayList Using Streams**

```java
import java.util.ArrayList;

public class PrintArrayListUsingStreams {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        list.stream().forEach(System.out::println);
    }
}
```

### 87. **Create ArrayList from Array**

```java
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToArrayList {
    public static void main(String[] args) {
        String[] array = {"Apple", "Banana"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);
    }
}
```

### 88. **ArrayList Initialization with Size**

```java
import java.util.ArrayList;

public class ArrayListInitializationWithSize {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(10);
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);
    }
}
```

### 89. **Add Multiple Elements to ArrayList**

```java
import java.util.ArrayList;

public class AddMultipleElements {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        ArrayList<String> moreItems = new ArrayList<>();
        moreItems.add("Date");
        moreItems.add("Elderberry");

        list.addAll(moreItems);
        System.out.println(list);
    }
}
```

### 90. **Print ArrayList in a Single Line**

```java
import java.util.ArrayList;

public class PrintArrayListSingleLine {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        System.out.println(list);
    }
}
```

### 91. **Iterate ArrayList Using Iterator**

```java
import java.util.ArrayList;
import java.util.Iterator;

public class IterateArrayListUsingIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

### 92. **Find First Occurrence of an Element**

```java
import java.util.ArrayList;

public class FindFirstOccurrence {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");

        int index = list.indexOf("Apple");
        System.out.println("First occurrence of Apple: " + index);
    }
}
```

### 93. **Find Last Occurrence of an Element**

```java
import java.util.ArrayList;

public class FindLastOccurrence {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");

        int index = list.lastIndexOf("Apple");
        System.out.println("Last occurrence of Apple: " + index);
    }
}
```

### 94. **Convert ArrayList to Object Array**

```java
import java.util.ArrayList;

public class ArrayListToObjectArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        Object[] array = list.toArray();
        for (Object obj : array) {
            System.out.println(obj);
        }
    }
}
```

### 95. **ArrayList Contains Element**

```java
import java.util.ArrayList;

public class ArrayListContainsElement {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        boolean contains = list.contains("Apple");
        System.out.println("List contains Apple: " + contains);
    }
}
```

### 96. **Print ArrayList Elements with Index**

```java
import java.util.ArrayList;

public class PrintArrayListWithIndex {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }
    }
}
```

### 97. **Create a Thread-safe ArrayList**

Use `Collections.synchronizedList()` to create a thread-safe version of `ArrayList`.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeArrayList {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("Apple");
        list.add("Banana");

        synchronized (list) {
            for (String item : list) {
                System.out.println(item);
            }
        }
    }
}
```

### 98. **Remove All Elements from ArrayList**

```java
import java.util.ArrayList;

public class RemoveAllElements {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        list.clear();
        System.out.println("List after removing all elements: " + list);
    }
}
```

### 99. **Initialize ArrayList with Default Values**

```java
import java.util.ArrayList;

public class InitializeArrayListWithDefaults {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Default");
        }
        System.out.println(list);
    }
}
```

### 100. **Find Elements in ArrayList that Start with a Specific Letter**

```java
import java.util.ArrayList;

public class FindElementsStartingWith {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Avocado");

        list.stream()
            .filter(s -> s.startsWith("A"))
            .forEach(System.out::println);
    }
}
```
Read more: https://www.java67.com/2015/06/20-java-arraylist-interview-questions.html#ixzz8himTFcWz

How do you reverse a given string in place? (solution)
How do you print duplicate characters from a string? (solution)
How do you check if two strings are anagrams of each other? (solution)
How do you find all the permutations of a string? (solution)
How can a given string be reversed using recursion? (solution)
How do you check if a string contains only digits? (solution)
How do you find duplicate characters in a given string? (solution)
How do you count a number of vowels and consonants in a given string? (solution)
How do you count the occurrence of a given character in a string? (solution)
How do you print the first non-repeated character from a string? (solution)
How do you convert a given String into int like the atoi()? (solution)
How do you reverse words in a given sentence without using any library method? (solution)
How do you check if two strings are a rotation of each other? (solution)
How do you check if a given string is a palindrome? (solution)
How do you find the length of the longest substring without repeating characters? (solution)
Given string str, How do you find the longest palindromic substring in str? (solution)
How to convert a byte array to String? (solution)
how to remove the duplicate character from String? (solution)
How to find the maximum occurring character in given String? (solution)
How do you remove a given character from String? (solution)

Here are solutions for the common string manipulation problems in Java:

### 1. **Reverse a Given String In-Place**

```java
public class ReverseStringInPlace {
    public static void main(String[] args) {
        String str = "hello";
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        String reversed = new String(chars);
        System.out.println(reversed);
    }
}
```

### 2. **Print Duplicate Characters from a String**

```java
import java.util.HashMap;
import java.util.Map;

public class PrintDuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate character: " + entry.getKey());
            }
        }
    }
}
```

### 3. **Check if Two Strings Are Anagrams of Each Other**

```java
import java.util.Arrays;

public class CheckAnagrams {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        if (str1.length() != str2.length()) {
            System.out.println("Not Anagrams");
            return;
        }
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }
}
```

### 4. **Find All Permutations of a String**

```java
import java.util.HashSet;
import java.util.Set;

public class FindPermutations {
    public static void main(String[] args) {
        String str = "abc";
        Set<String> permutations = new HashSet<>();
        permute(str, 0, str.length() - 1, permutations);
        System.out.println(permutations);
    }
    
    public static void permute(String str, int l, int r, Set<String> permutations) {
        if (l == r) {
            permutations.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r, permutations);
                str = swap(str, l, i); // backtrack
            }
        }
    }
    
    public static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
```

### 5. **Reverse a String Using Recursion**

```java
public class ReverseStringRecursion {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = reverse(str);
        System.out.println(reversed);
    }
    
    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
```

### 6. **Check if a String Contains Only Digits**

```java
public class CheckDigitsOnly {
    public static void main(String[] args) {
        String str = "12345";
        boolean isDigits = str.chars().allMatch(Character::isDigit);
        System.out.println("Contains only digits: " + isDigits);
    }
}
```

### 7. **Find Duplicate Characters in a Given String**

```java
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                duplicates.add(c);
            } else {
                seen.add(c);
            }
        }
        
        System.out.println("Duplicate characters: " + duplicates);
    }
}
```

### 8. **Count Number of Vowels and Consonants in a Given String**

```java
public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        String str = "hello world";
        int vowels = 0;
        int consonants = 0;
        
        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
```

### 9. **Count the Occurrence of a Given Character in a String**

```java
public class CountCharacterOccurrence {
    public static void main(String[] args) {
        String str = "hello world";
        char charToCount = 'o';
        long count = str.chars().filter(c -> c == charToCount).count();
        System.out.println("Occurrences of '" + charToCount + "': " + count);
    }
}
```

### 10. **Print the First Non-Repeated Character from a String**

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String str = "swiss";
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeated character: " + entry.getKey());
                break;
            }
        }
    }
}
```

### 11. **Convert a Given String into Int (Like `atoi()` in C)**

```java
public class StringToInt {
    public static void main(String[] args) {
        String str = "12345";
        try {
            int num = Integer.parseInt(str);
            System.out.println("Converted integer: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }
}
```

### 12. **Reverse Words in a Given Sentence Without Using Any Library Method**

```java
public class ReverseWordsInSentence {
    public static void main(String[] args) {
        String sentence = "Hello World";
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            if (i != 0) {
                reversedSentence.append(" ");
            }
        }
        
        System.out.println(reversedSentence.toString());
    }
}
```

### 13. **Check if Two Strings Are Rotations of Each Other**

```java
public class CheckRotations {
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        
        if (str1.length() != str2.length()) {
            System.out.println("Not rotations");
            return;
        }
        
        String combined = str1 + str1;
        if (combined.contains(str2)) {
            System.out.println("Rotations");
        } else {
            System.out.println("Not rotations");
        }
    }
}
```

### 14. **Check if a Given String is a Palindrome**

```java
public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "racecar";
        String reversed = new StringBuilder(str).reverse().toString();
        
        if (str.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
```

### 15. **Find the Length of the Longest Substring Without Repeating Characters**

```java
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int maxLength = 0;
        int start = 0;
        Set<Character> charSet = new HashSet<>();
        
        for (int end = 0; end < str.length(); end++) {
            while (charSet.contains(str.charAt(end))) {
                charSet.remove(str.charAt(start++));
            }
            charSet.add(str.charAt(end));
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        System.out.println("Length of longest substring: " + maxLength);
    }
}
```

### 

16. **Find the Longest Palindromic Substring**

```java
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";
        String longest = "";
        
        for (int i = 0; i < str.length(); i++) {
            String oddPalindrome = expandAroundCenter(str, i, i);
            String evenPalindrome = expandAroundCenter(str, i, i + 1);
            
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        
        System.out.println("Longest palindromic substring: " + longest);
    }
    
    private static String expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
```

### 17. **Convert a Byte Array to String**

```java
public class ByteArrayToString {
    public static void main(String[] args) {
        byte[] byteArray = {72, 101, 108, 108, 111}; // corresponds to "Hello"
        String str = new String(byteArray);
        System.out.println("Converted string: " + str);
    }
}
```

### 18. **Remove Duplicate Characters from a String**

```java
public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (seen.add(c)) {
                result.append(c);
            }
        }
        
        System.out.println("String after removing duplicates: " + result.toString());
    }
}
```

### 19. **Find the Maximum Occurring Character in a Given String**

```java
import java.util.HashMap;
import java.util.Map;

public class MaxOccurringCharacter {
    public static void main(String[] args) {
        String str = "programming";
        Map<Character, Integer> charCountMap = new HashMap<>();
        int maxCount = 0;
        char maxChar = ' ';
        
        for (char c : str.toCharArray()) {
            int count = charCountMap.getOrDefault(c, 0) + 1;
            charCountMap.put(c, count);
            if (count > maxCount) {
                maxCount = count;
                maxChar = c;
            }
        }
        
        System.out.println("Maximum occurring character: " + maxChar);
    }
}
```

### 20. **Remove a Given Character from a String**

```java
public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "hello world";
        char charToRemove = 'o';
        String result = str.replace(Character.toString(charToRemove), "");
        System.out.println("String after removal: " + result);
    }
}
```

These solutions cover a range of common string manipulation tasks and showcase how to approach these problems in Java.


Here are solutions for a few of the array-related coding problems from the list you provided. I'll focus on explaining the approach and then provide Java code for each problem.

### 1. **Find the Missing Number in an Array of Numbers from 1 to 100**

**Approach**:
You can solve this problem using the formula for the sum of the first `n` integers. The sum of numbers from 1 to 100 is `sum = n * (n + 1) / 2`, where `n = 100`. You can calculate the sum of the array and subtract it from the expected sum to find the missing number.

**Java Code**:
```java
public class MissingNumber {
    public static int findMissingNumber(int[] arr) {
        int n = 100; // As the numbers range from 1 to 100
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : arr) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10}; // Example array with 7 missing
        System.out.println("Missing number: " + findMissingNumber(arr)); // Output: 7
    }
}
```

### 2. **Find Duplicate Number in an Array**

**Approach**:
You can use the sum difference approach similar to the missing number problem, but here you are looking for a repeated number in a range from 0 to `n-2`. Another efficient way is to use Floyd's Tortoise and Hare algorithm (Cycle Detection) if you want to avoid additional space usage.

**Java Code** (using the sum difference approach):
```java
public class FindDuplicate {
    public static int findDuplicate(int[] arr) {
        int n = arr.length;
        int expectedSum = (n - 1) * (n - 2) / 2;  // Sum of numbers from 0 to n-2
        int actualSum = 0;
        
        for (int num : arr) {
            actualSum += num;
        }
        
        return actualSum - expectedSum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 2, 3}; // Example array with duplicate number 3
        System.out.println("Duplicate number: " + findDuplicate(arr)); // Output: 3
    }
}
```

### 3. **Check if an Array Contains a Number**

**Approach**:
- If the array is sorted, you can use binary search (O(log n)).
- If the array is unsorted, you would perform a linear search (O(n)).

**Java Code** (for unsorted array with linear search):
```java
public class CheckNumber {
    public static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 5, 1}; // Example array
        int target = 3;
        System.out.println("Contains " + target + ": " + contains(arr, target)); // Output: true
    }
}
```

### 4. **Find Largest and Smallest Number in an Unsorted Array**

**Approach**:
You can do this in one pass by initializing two variables (`largest` and `smallest`) and updating them as you traverse through the array.

**Java Code**:
```java
public class FindLargestSmallest {
    public static int[] findLargestSmallest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > largest) largest = num;
            if (num < smallest) smallest = num;
        }

        return new int[]{largest, smallest};
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 34, 45, -6, 7};
        int[] result = findLargestSmallest(arr);
        System.out.println("Largest: " + result[0] + ", Smallest: " + result[1]);
    }
}
```

### 5. **Find All Pairs in an Array Whose Sum is Equal to a Given Number**

**Approach**:
A straightforward solution involves using two loops to check all pairs. However, a more efficient approach is to use a HashSet to track the elements you've already seen.

**Java Code**:
```java
import java.util.HashSet;

public class FindPairs {
    public static void findPairs(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            int complement = sum - num;
            if (set.contains(complement)) {
                System.out.println("Pair: (" + num + ", " + complement + ")");
            }
            set.add(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int sum = 7;
        findPairs(arr, sum);
    }
}
```

### 6. **Remove Duplicates from an Array**

**Approach**:
You can use a HashSet to keep track of the unique elements and overwrite the array with the unique elements.

**Java Code**:
```java
import java.util.HashSet;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int index = 0;

        for (int num : arr) {
            if (!set.contains(num)) {
                set.add(num);
                arr[index++] = num;
            }
        }

        // Resize the array to only contain the unique elements
        int[] uniqueArr = new int[set.size()];
        System.arraycopy(arr, 0, uniqueArr, 0, set.size());
        return uniqueArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4};
        int[] result = removeDuplicates(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
```

### 7. **Sort an Array In-Place Using QuickSort Algorithm**

**Approach**:
QuickSort is a divide-and-conquer algorithm that selects a pivot and partitions the array into elements smaller and greater than the pivot, then recursively sorts the sub-arrays.

**Java Code**:
```java
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

Here are the solutions for array problems numbered 8 to 30, based on your provided list:

---

### 8. **How to sort an array in place using QuickSort algorithm?**

**Solution:**

```java
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
```

---

### 9. **Write a program to find intersection of two sorted arrays in Java?**

**Solution:**

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        int[] arr1 = {21, 34, 41, 22, 35};
        int[] arr2 = {61, 34, 45, 21, 11};
        System.out.println(findIntersection(arr1, arr2));
    }
}
```

---

### 10. **There is an array with every element repeated twice except one. Find that element?**

**Solution:**

```java
public class SingleNonRepeatedElement {
    public static int findSingle(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;  // XOR operation
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(findSingle(arr)); // Output: 3
    }
}
```

---

### 11. **How to find kth smallest element in unsorted array?**

**Solution (using Quickselect):**

```java
import java.util.Random;

public class KthSmallestElement {
    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        Random rand = new Random();
        int pivotIndex = rand.nextInt(right - left + 1) + left;
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 2; // 2nd smallest element
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));
    }
}
```

---

### 12. **How to find kth largest element in unsorted array?**

**Solution:**

The solution is similar to the one for the kth smallest element; just pass `n-k` to find the kth largest element.

---

### 13. **How to find common elements in three sorted arrays?**

**Solution:**

```java
import java.util.ArrayList;
import java.util.List;

public class CommonElementsInThreeSortedArrays {
    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> common = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                common.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(findCommonElements(arr1, arr2, arr3));
    }
}
```

---

### 14. **How to find the first repeating element in an array of integers?**

**Solution:**

```java
import java.util.HashSet;

public class FirstRepeatingElement {
    public static int findFirstRepeating(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                return num; // First repeating element
            }
        }
        return -1; // No repetition
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(findFirstRepeating(arr)); // Output: 3
    }
}
```

---

### 15. **How to find first non-repeating element in array of integers?**

**Solution:**

```java
import java.util.HashMap;

public class FirstNonRepeatingElement {
    public static int findFirstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return -1; // No non-repeating element
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(findFirstNonRepeating(arr)); // Output: 10
    }
}
```

---

### 16. **How to find top two numbers from an integer array?**

**Solution:**

```java
public class TopTwoNumbers {
    public static void findTopTwo(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        System.out.println("Top two numbers: " + first + ", " + second);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 4, 45, 99};
        findTopTwo(arr);
    }
}
```

---

### 17. **How to find the smallest positive integer value that cannot be represented as sum of any subset of a given array?**

**Solution:**

```java
import java.util.Arrays;

public class SmallestNonRepresentableSum {
    public static int findSmallest(int[] arr) {
        Arrays.sort

(arr);
        int smallest = 1; // The smallest sum we can represent so far
        
        for (int num : arr) {
            if (num > smallest) {
                break;
            }
            smallest += num;
        }
        return smallest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 5, 6};
        System.out.println(findSmallest(arr)); // Output: 18
    }
}
```

---

### 18. **Find longest consecutive subsequence in an array of integers?**

**Solution:**

```java
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int findLongestConsecutiveSubsequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : arr) {
            if (!set.contains(num - 1)) {  // Starting point of a sequence
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(findLongestConsecutiveSubsequence(arr)); // Output: 4
    }
}
```

---

Here are the solutions for array problems numbered 19 to 30:

---

### 19. **Find the missing number in a given integer array of 1 to N.**

**Solution:**

```java
public class MissingNumber {
    public static int findMissingNumber(int[] arr, int n) {
        int totalSum = n * (n + 1) / 2; // Sum of first N natural numbers
        int arrSum = 0;

        for (int num : arr) {
            arrSum += num;
        }

        return totalSum - arrSum; // Missing number is the difference
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5}; // N is 5
        int n = 5;
        System.out.println(findMissingNumber(arr, n)); // Output: 4
    }
}
```

---

### 20. **How to find duplicate numbers in an array?**

**Solution:**

```java
import java.util.HashSet;

public class FindDuplicates {
    public static void findDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                System.out.println("Duplicate found: " + num);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        findDuplicates(arr);
    }
}
```

---

### 21. **How to rotate an array by `k` positions?**

**Solution (using reversal algorithm):**

```java
public class RotateArray {
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is larger than the length of the array

        // Reverse the whole array
        reverse(arr, 0, n - 1);
        // Reverse the first part
        reverse(arr, 0, k - 1);
        // Reverse the second part
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(arr, k);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

### 22. **How to move all zeros to the end of an array without changing the order of non-zero elements?**

**Solution:**

```java
public class MoveZeros {
    public static void moveZerosToEnd(int[] arr) {
        int nonZeroIndex = 0;

        // Move non-zero elements to the front
        for (int num : arr) {
            if (num != 0) {
                arr[nonZeroIndex++] = num;
            }
        }

        // Fill the rest of the array with zeros
        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 9, 0, 3, 12};
        moveZerosToEnd(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

### 23. **How to find the majority element (appears more than `n/2` times) in an array?**

**Solution (using Boyer-Moore Voting Algorithm):**

```java
public class MajorityElement {
    public static int majorityElement(int[] arr) {
        int candidate = -1, count = 0;

        // Find potential candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Verify if the candidate is the majority element
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return (count > arr.length / 2) ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(majorityElement(arr)); // Output: 4
    }
}
```

---

### 24. **How to find the second largest element in an array?**

**Solution:**

```java
public class SecondLargestElement {
    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8};
        System.out.println(findSecondLargest(arr)); // Output: 10
    }
}
```

---

### 25. **How to find the longest increasing subsequence in an array?**

**Solution (using Dynamic Programming):**

```java
public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        // Initialize dp array
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  // Every element is a subsequence of length 1
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(longestIncreasingSubsequence(arr)); // Output: 6
    }
}
```

---

### 26. **How to find the minimum difference between any two elements in an array?**

**Solution:**

```java
import java.util.Arrays;

public class MinDifference {
    public static int findMinDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 19, 18, 25};
        System.out.println(findMinDifference(arr)); // Output: 1
    }
}
```

---

### 27. **How to find the maximum product of two integers in an array?**

**Solution:**

```java
public class MaxProduct {
    public static int findMaxProduct(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return max1 * max2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 9, 7};
        System.out.println(findMaxProduct(arr)); // Output: 63 (9 * 7)
    }
}
```

---

### 28. **How to rearrange positive and negative numbers in an array?**

**Solution (Alternating Positive and Negative):**

```java
public class RearrangePositiveNegative {
    public static void rearrange(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int num : arr) {
            if (num >= 0) {
                if (posIndex < n) {
                    result[posIndex] = num;
                    posIndex += 2;
                }
            } else {
                if (negIndex < n) {
                    result[negIndex] = num;
                    negIndex += 2;
                }
            }
        }

        // Copy result back to original array
        System.arraycopy(result, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, -2

, 3, -4, 5, -6};
        rearrange(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

### 29. **Find the subarray with the largest sum (Kadane's Algorithm)**

**Solution:**

```java
public class MaximumSubarraySum {
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(arr)); // Output: 6
    }
}
```

---

### 30. **Find if an array is a subset of another array.**

**Solution:**

```java
import java.util.HashSet;

public class ArraySubset {
    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            if (!set.contains(num)) {
                return false; // Element not found in arr1
            }
        }

        return true; // All elements of arr2 are in arr1
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        System.out.println(isSubset(arr1, arr2)); // Output: true
    }
}
```

---



50 Common Algorithms Interview Questions
Without any further ado, here is my list of some of the most frequently asked coding interview questions from programming job interviews:

1. Array Coding and Data Structures Interview Questions
An array is the most fundamental data structure, which stores elements at a contiguous memory location. It is also one of the darling topics of
interviewers and you will hear a lot of questions about an array in any coding interview, e.g. reversing an array, sorting the array, or searching elements on the array.

The key benefit of an array data structure is that it offers fast O(1) search if you know the index, but adding and removing an element from an array is slow because you cannot change the size of the array once it’s created.

In order to create a shorter or longer array, you need to create a new array and copy all elements from old to new.

The key to solving array-based questions is having a good knowledge of array data structure as well as basic programming constructors such as loop, recursion, and fundamental operators.

Here are some of the popular array-based coding interview questions for your practice:

How do you find the missing number in a given integer array of 1 to 100? (solution)
How do you find the duplicate number on a given integer array? (solution)
How do you find the largest and smallest number in an unsorted integer array? (solution)
How do you find all pairs of an integer array whose sum is equal to a given number? (solution)
How do you find duplicate numbers in an array if it contains multiple duplicates? (solution)
How are duplicates removed from a given array in Java? (solution)
How is an integer array sorted in place using the quicksort algorithm? (solution)
How do you remove duplicates from an array in place? (solution)
How do you reverse an array in place in Java? (solution)
How are duplicates removed from an array without using any library? (solution)
These questions will not only help you to develop your problem-solving skills but also improve your knowledge of array data structure.

If you need more advanced questions based upon array then you can see also see The Coding Interview Bootcamp: Algorithms + Data Structures, a bootcamp style course on algorithms, especially designed for
interview preparation to get a job on technical giants like Google,
Microsoft, Apple, Facebook etc.

And, if you feel 10 is not enough questions and you need more practice, then you can also check out this list of 30 array questions.

2. Linked List Programming Interview Questions
A linked list is another common data structure that complements the array data structure. Similar to the array, it is also a linear data structure and
stores elements in a linear fashion.

However, unlike the array, it doesn’t store them in contiguous locations; instead, they are scattered everywhere in memory, which is connected to each other using nodes.

A linked list is nothing but a list of nodes where each node contains the value stored and the address of the next node.

Because of this structure, it’s easy to add and remove elements in a linked list, as you just need to change the link instead of creating the array, but the search is difficult and often requires O(n) time to find an element in the singly linked list.

This article provides more information on the difference between an array and linked list data structures.

It also comes in varieties like a singly linked list, which allows you to traverse in one direction (forward or reverse); a doubly linked list,
which allows you to traverse in both directions (forward and backward);
and finally, the circular linked list, which forms a circle.

In order to solve linked list-based questions, a good knowledge of recursion is important, because a linked list is a recursive data structure.

If you take one node from a linked list, the remaining data structure is
still a linked list, and because of that, many linked list problems have
simpler recursive solutions than iterative ones.

Here are some of the most common and popular linked list interview questions and their solutions:

How do you find the middle element of a singly linked list in one pass? (solution)
How do you check if a given linked list contains a cycle? How do you find the starting node of the cycle? (solution)
How do you reverse a linked list? (solution)
How do you reverse a singly linked list without recursion? (solution)
How are duplicate nodes removed in an unsorted linked list? (solution)
How do you find the length of a singly linked list? (solution)
How do you find the third node from the end in a singly linked list? (solution)
How do you find the sum of two linked lists using Stack? (solution)
These questions will help you to develop your problem-solving skills as well
as improve your knowledge of the linked list data structure.

If you are having trouble solving these linked list coding questions then I
suggest you refresh your data structure and algorithms skill by going
through Data Structures and Algorithms: Deep Dive Using Java course.

You can also check out this list of 30 linked list interview questions for more practice questions.

3. String Coding Interview Questions
Along with array and linked list data structures, a string is another popular
topic on programming job interviews. I have never participated in a
coding interview where no string-based questions were asked.

A good thing about the string is that if you know the array, you can solve string-based questions easily because strings are nothing but a character array.

So all the techniques you learn by solving array-based coding questions
can be used to solve string programming questions as well.

Here is my list of frequently asked string coding questions from programming job interviews:

How do you print duplicate characters from a string? (solution)
How do you check if two strings are anagrams of each other? (solution)
How do you print the first non-repeated character from a string? (solution)
How can a given string be reversed using recursion? (solution)
How do you check if a string contains only digits? (solution)
How are duplicate characters found in a string? (solution)
How do you count a number of vowels and consonants in a given string? (solution)
How do you count the occurrence of a given character in a string? (solution)
How do you find all permutations of a string? (solution)
How do you reverse words in a given sentence without using any library method? (solution)
How do you check if two strings are a rotation of each other? (solution)
How do you check if a given string is a palindrome? (solution)

Here are solutions to the string manipulation problems you’ve mentioned:

### 1. **Print Duplicate Characters from a String**

```java
import java.util.HashMap;
import java.util.Map;

public class PrintDuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        System.out.println("Duplicate characters:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
```

### 2. **Check if Two Strings Are Anagrams of Each Other**

```java
import java.util.Arrays;

public class CheckAnagrams {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        if (str1.length() != str2.length()) {
            System.out.println("Not Anagrams");
            return;
        }
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }
}
```

### 3. **Print the First Non-Repeated Character from a String**

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String str = "swiss";
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeated character: " + entry.getKey());
                break;
            }
        }
    }
}
```

### 4. **Reverse a Given String Using Recursion**

```java
public class ReverseStringRecursion {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = reverse(str);
        System.out.println(reversed);
    }
    
    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
```

### 5. **Check if a String Contains Only Digits**

```java
public class CheckDigitsOnly {
    public static void main(String[] args) {
        String str = "12345";
        boolean isDigits = str.chars().allMatch(Character::isDigit);
        System.out.println("Contains only digits: " + isDigits);
    }
}
```

### 6. **Find Duplicate Characters in a String**

```java
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                duplicates.add(c);
            } else {
                seen.add(c);
            }
        }
        
        System.out.println("Duplicate characters: " + duplicates);
    }
}
```

### 7. **Count Number of Vowels and Consonants in a Given String**

```java
public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        String str = "hello world";
        int vowels = 0;
        int consonants = 0;
        
        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
```

### 8. **Count the Occurrence of a Given Character in a String**

```java
public class CountCharacterOccurrence {
    public static void main(String[] args) {
        String str = "hello world";
        char charToCount = 'o';
        long count = str.chars().filter(c -> c == charToCount).count();
        System.out.println("Occurrences of '" + charToCount + "': " + count);
    }
}
```

### 9. **Find All Permutations of a String**

```java
import java.util.HashSet;
import java.util.Set;

public class FindPermutations {
    public static void main(String[] args) {
        String str = "abc";
        Set<String> permutations = new HashSet<>();
        permute(str, 0, str.length() - 1, permutations);
        System.out.println(permutations);
    }
    
    public static void permute(String str, int l, int r, Set<String> permutations) {
        if (l == r) {
            permutations.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r, permutations);
                str = swap(str, l, i); // backtrack
            }
        }
    }
    
    public static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
```

### 10. **Reverse Words in a Given Sentence Without Using Any Library Method**

```java
public class ReverseWordsInSentence {
    public static void main(String[] args) {
        String sentence = "Hello World";
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            if (i != 0) {
                reversedSentence.append(" ");
            }
        }
        
        System.out.println(reversedSentence.toString());
    }
}
```

### 11. **Check if Two Strings Are Rotations of Each Other**

```java
public class CheckRotations {
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        
        if (str1.length() != str2.length()) {
            System.out.println("Not rotations");
            return;
        }
        
        String combined = str1 + str1;
        if (combined.contains(str2)) {
            System.out.println("Rotations");
        } else {
            System.out.println("Not rotations");
        }
    }
}
```

### 12. **Check if a Given String is a Palindrome**

```java
public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "racecar";
        String reversed = new StringBuilder(str).reverse().toString();
        
        if (str.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
```

These solutions provide a variety of techniques to handle common string manipulation tasks in Java.

These questions help improve your knowledge of string as a data structure. If you can solve all these String questions without any help then you are in good shape.

For more advanced questions, I suggest you solve problems given in the Algorithm Design Manual by Steven Skiena, a book with the toughest algorithm questions.

If you need more practice, here is another list of 20 string coding questions.

4. Binary Tree Coding Interview Questions
So far, we have looked at only the linear data structure, but all
information in the real world cannot be represented in linear fashion,
and that’s where tree data structure helps.

Tree data structure is a data structure that allows you to store your data in a hierarchical fashion. Depending on how you store data, there are different types of trees, such as a binary tree, where each node has, at most, two child nodes.a

Along with its close cousin binary search tree, it’s also one of the most popular tree data structures. Therefore, you will find a lot of questions based on them, such as how to traverse them, count nodes, find depth, and check if they are balanced or not.

A key point to solving binary tree questions is a strong knowledge of theory, e.g. what is the size or depth of the binary tree, what is a leaf, and
what is a node, as well as an understanding of the popular traversing
algorithms, e.g. pre-, post-, and in-order traversal.

Here is a list of popular binary tree-based coding questions from software engineer or developer job interviews:

How is a binary search tree implemented? (solution)
How do you perform preorder traversal in a given binary tree? (solution)
How do you traverse a given binary tree in preorder without recursion? (solution)
How do you perform an inorder traversal in a given binary tree? (solution)
How do you print all nodes of a given binary tree using inorder traversal without recursion? (solution)
How do you implement a postorder traversal algorithm? (solution)
How do you traverse a binary tree in postorder traversal without recursion? (solution)
How are all leaves of a binary search tree printed? (solution)
How do you count a number of leaf nodes in a given binary tree? (solution)
How do you perform a binary search in a given array? (solution)

Here are detailed implementations and explanations for various tree traversal methods and operations:

### 1. **Binary Search Tree (BST) Implementation**

In Java, a Binary Search Tree (BST) can be implemented using a class for nodes and a class for the BST itself. 

```java
class TreeNode {
    int value;
    TreeNode left, right;
    
    TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;
    
    // Insert a new value into the BST
    void insert(int value) {
        root = insertRec(root, value);
    }
    
    TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        
        return root;
    }
    
    // Inorder traversal
    void inorder() {
        inorderRec(root);
    }
    
    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}
```

### 2. **Preorder Traversal of a Binary Tree**

#### Recursive Preorder Traversal

```java
class BinaryTree {
    TreeNode root;
    
    void preorder() {
        preorderRec(root);
    }
    
    void preorderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }
}
```

#### Iterative Preorder Traversal

```java
import java.util.Stack;

class BinaryTreeIterativePreorder {
    TreeNode root;
    
    void preorder() {
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }
}
```

### 3. **Inorder Traversal of a Binary Tree**

#### Recursive Inorder Traversal

```java
class BinaryTreeInorder {
    TreeNode root;
    
    void inorder() {
        inorderRec(root);
    }
    
    void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.value + " ");
            inorderRec(node.right);
        }
    }
}
```

#### Iterative Inorder Traversal

```java
import java.util.Stack;

class BinaryTreeIterativeInorder {
    TreeNode root;
    
    void inorder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }
}
```

### 4. **Postorder Traversal of a Binary Tree**

#### Recursive Postorder Traversal

```java
class BinaryTreePostorder {
    TreeNode root;
    
    void postorder() {
        postorderRec(root);
    }
    
    void postorderRec(TreeNode node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.value + " ");
        }
    }
}
```

#### Iterative Postorder Traversal

```java
import java.util.Stack;

class BinaryTreeIterativePostorder {
    TreeNode root;
    
    void postorder() {
        if (root == null) return;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }
}
```

### 5. **Print All Leaves of a Binary Search Tree**

```java
class PrintLeaves {
    TreeNode root;
    
    void printLeaves() {
        printLeavesRec(root);
    }
    
    void printLeavesRec(TreeNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.print(node.value + " ");
            }
            printLeavesRec(node.left);
            printLeavesRec(node.right);
        }
    }
}
```

### 6. **Count Number of Leaf Nodes in a Binary Tree**

```java
class CountLeaves {
    TreeNode root;
    
    int countLeaves() {
        return countLeavesRec(root);
    }
    
    int countLeavesRec(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        
        return countLeavesRec(node.left) + countLeavesRec(node.right);
    }
}
```

### 7. **Binary Search in a Given Array**

```java
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        int result = binarySearch(arr, 0, arr.length - 1, target);
        
        if (result == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
    
    static int binarySearch(int[] arr, int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) return binarySearch(arr, left, mid - 1, target);
            
            return binarySearch(arr, mid + 1, right, target);
        }
        
        return -1;
    }
}
```

These solutions provide implementations for various common tree and array operations, showcasing both recursive and iterative approaches where applicable.

If you feel that your understanding of binary tree coding is inadequate
and you can’t solve these questions on your own, I suggest you go back
and pick a good data structure and algorithm course like From 0 to 1: Data Structures & Algorithms in Java.

If you need some more recommendations, here is my list of useful data structure algorithm books and courses to start with.

5. Miscellaneous Coding Interview Questions
Apart from data structure-based questions, most of the programming job
interviews also ask algorithm, design, bit manipulation, and general
logic-based questions, which I’ll describe in this section.

It’s important that you practice these concepts because sometimes they
become tricky to solve in the actual interview. Having practiced them
before not only makes you familiar with them but also gives you more
confidence in explaining the solution to the interviewer.

How is a bubble sort algorithm implemented? (solution)
How is an iterative quicksort algorithm implemented? (solution)
How do you implement an insertion sort algorithm? (solution)
How is a merge sort algorithm implemented? (solution)
How do you implement a bucket sort algorithm? (solution)
How do you implement a counting sort algorithm? (solution)
How is a radix sort algorithm implemented? (solution)
How do you swap two numbers without using the third variable? (solution)
How do you check if two rectangles overlap with each other? (solution)
How do you design a vending machine? (solution)

Here are detailed implementations and explanations for various sorting algorithms, number swapping, rectangle overlap checks, and designing a vending machine:

### 1. **Bubble Sort Algorithm**

Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

```java
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```

### 2. **Iterative Quicksort Algorithm**

Quicksort is a divide-and-conquer algorithm that sorts by partitioning an array into smaller sub-arrays.

```java
import java.util.Stack;

public class IterativeQuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        iterativeQuickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void iterativeQuickSort(int[] arr, int left, int right) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{left, right});
        
        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int l = range[0];
            int r = range[1];
            
            if (l < r) {
                int p = partition(arr, l, r);
                
                stack.push(new int[]{l, p - 1});
                stack.push(new int[]{p + 1, r});
            }
        }
    }
    
    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        
        return i + 1;
    }
}
```

### 3. **Insertion Sort Algorithm**

Insertion Sort builds the final sorted array one item at a time, with each new item being inserted into its proper place.

```java
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
```

### 4. **Merge Sort Algorithm**

Merge Sort is a divide-and-conquer algorithm that divides the array into halves, sorts them, and then merges them.

```java
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        
        int i = 0, j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        
        while (i < n1) {
            arr[k++] = L[i++];
        }
        
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
```

### 5. **Bucket Sort Algorithm**

Bucket Sort distributes the elements into a number of buckets, then sorts these buckets individually.

```java
import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {0.897, 0.565, 0.656, 0.123, 0.665, 0.343};
        bucketSort(arr);
        System.out.println("Sorted array:");
        for (double num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void bucketSort(double[] arr) {
        int n = arr.length;
        if (n <= 0) return;
        
        // Create buckets
        @SuppressWarnings("unchecked")
        double[][] buckets = new double[n][0];
        
        // Put array elements in different buckets
        for (double num : arr) {
            int index = (int) (num * n);
            buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length + 1);
            buckets[index][buckets[index].length - 1] = num;
        }
        
        // Sort each bucket and put back to array
        int pos = 0;
        for (double[] bucket : buckets) {
            Arrays.sort(bucket);
            for (double num : bucket) {
                arr[pos++] = num;
            }
        }
    }
}
```

### 6. **Counting Sort Algorithm**

Counting Sort counts the occurrences of each distinct element and uses this count to place elements in the sorted order.

```java
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];
        
        for (int num : arr) {
            count[num]++;
        }
        
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}
```

### 7. **Radix Sort Algorithm**

Radix Sort processes each digit of the number. It is a non-comparative integer sorting algorithm.

```java
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1;
        
        while (max / exp > 0) {
            countingSortForRadix(arr, exp);
            exp *= 10;
        }
    }
    
    static void countingSortForRadix(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        Arrays.fill(count, 0);
        
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        for (

int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        System.arraycopy(output, 0, arr, 0, n);
    }
}
```

### 8. **Swapping Two Numbers Without Using a Third Variable**

```java
public class SwapNumbers {
    public static void main(String[] args) {
        int a = 10, b = 20;
        
        // Swapping using arithmetic operations
        a = a + b;
        b = a - b;
        a = a - b;
        
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}
```

### 9. **Check if Two Rectangles Overlap**

To check if two rectangles overlap, use their coordinates and dimensions.

```java
public class RectangleOverlap {
    public static void main(String[] args) {
        int[] rect1 = {0, 0, 10, 10}; // x1, y1, x2, y2
        int[] rect2 = {5, 5, 15, 15};
        
        boolean result = doRectanglesOverlap(rect1, rect2);
        System.out.println("Do the rectangles overlap? " + result);
    }
    
    static boolean doRectanglesOverlap(int[] rect1, int[] rect2) {
        // Check if one rectangle is to the left of the other
        if (rect1[0] >= rect2[2] || rect2[0] >= rect1[2]) return false;
        
        // Check if one rectangle is above the other
        if (rect1[1] >= rect2[3] || rect2[1] >= rect1[3]) return false;
        
        return true;
    }
}
```

### 10. **Design a Vending Machine**

A basic vending machine can be implemented by simulating a real-world machine with items, prices, and methods to handle user interactions.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<String, Integer> items;
    private int balance;
    
    public VendingMachine() {
        items = new HashMap<>();
        items.put("Soda", 120);
        items.put("Chips", 50);
        items.put("Candy", 75);
        balance = 0;
    }
    
    public void insertMoney(int amount) {
        balance += amount;
        System.out.println("Balance: " + balance);
    }
    
    public void selectItem(String item) {
        if (!items.containsKey(item)) {
            System.out.println("Item not available.");
            return;
        }
        
        int price = items.get(item);
        if (balance < price) {
            System.out.println("Insufficient balance.");
            return;
        }
        
        balance -= price;
        System.out.println("Dispensing " + item);
        System.out.println("Remaining balance: " + balance);
    }
    
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Insert Money");
            System.out.println("2. Select Item");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter amount:");
                    int amount = scanner.nextInt();
                    machine.insertMoney(amount);
                    break;
                case 2:
                    System.out.println("Enter item name:");
                    String item = scanner.next();
                    machine.selectItem(item);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
```

This solution provides the basic implementation and example usage for various sorting algorithms, number swapping, rectangle overlap checks, and a simple vending machine design in Java.

### When to Use `ArrayList` vs. `LinkedList` in Java

**ArrayList** and **LinkedList** are two commonly used implementations of the `List` interface in Java. While they share many characteristics, such as supporting ordered collections, allowing duplicates, and being index-based, their internal implementations differ significantly, which affects their performance characteristics. 

Here's a detailed guide on when to use **ArrayList** vs **LinkedList**:

---

### 1. **Underlying Data Structure**

- **ArrayList** is backed by a **dynamic array**. It stores elements in contiguous memory locations, meaning it offers fast access to elements by index (`O(1)` time complexity for retrieval).
  
- **LinkedList** is backed by a **doubly linked list**. It stores elements in nodes, where each node contains a reference to the next and previous node. As a result, accessing an element by index requires traversal (`O(n)` time complexity).

**When to use:**
- Use `ArrayList` when you need fast random access by index and when your application requires frequent reads of elements.
- Use `LinkedList` if you need to frequently add or remove elements from the beginning or middle of the list (since `ArrayList` will require shifting elements).

---

### 2. **Insertion and Deletion**

- **ArrayList**: Adding or removing elements in the **middle** or **start** of the list takes **O(n)** time, because elements need to be shifted to accommodate the changes.
  
- **LinkedList**: Adding or removing elements at the **beginning** or **middle** takes **O(1)** time (once you have a reference to the node). However, accessing the position of insertion/deletion takes **O(n)** time because you need to traverse the list.

**When to use:**
- Use `ArrayList` if your application involves more **frequent random access** and **less frequent insertions or deletions**.
- Use `LinkedList` if your application requires frequent insertions or deletions, especially from the **beginning** or **middle** of the list.

---

### 3. **Memory Usage**

- **ArrayList**: Uses a **contiguous block of memory** for storing elements, which can sometimes cause resizing overhead when the array runs out of space. If resizing occurs (for example, when adding an element to a full list), it requires copying the entire array to a new one.
  
- **LinkedList**: Each element in a `LinkedList` is stored in a **separate node** that holds references to the next and previous elements. This extra overhead for each node means it generally consumes **more memory** per element than an `ArrayList`.

**When to use:**
- Use `ArrayList` when memory consumption is a concern, especially if the list is not frequently resized.
- Use `LinkedList` when you need constant-time insertions and deletions, and memory consumption isn't a critical factor.

---

### 4. **Performance: Iteration**

- **ArrayList**: Iterating through an `ArrayList` is generally **faster** because elements are stored in contiguous memory locations, making better use of CPU cache.
  
- **LinkedList**: Iterating through a `LinkedList` is generally **slower** since it requires following pointers from one node to the next.

**When to use:**
- Use `ArrayList` when you expect to **iterate over the collection frequently**.
- Use `LinkedList` when the list size is large and **random access is less important**, but you still need frequent modifications like insertions and deletions.

---

### 5. **Accessing Elements by Index**

- **ArrayList**: Provides **O(1)** time complexity for getting an element at a particular index due to its array-based structure.
  
- **LinkedList**: Provides **O(n)** time complexity for getting an element by index, because it needs to traverse the list from the beginning or the end (whichever is closer).

**When to use:**
- Use `ArrayList` when **random access** is a frequent operation in your program.
- Avoid `LinkedList` if your program requires a lot of direct index-based access to elements.

---

### 6. **Deque Operations**

- **LinkedList**: Implements the `Deque` interface (Double-ended queue). This means it can efficiently add or remove elements from both the **head** and **tail** of the list with **O(1)** time complexity for both operations.

- **ArrayList**: Does not directly support efficient deque operations. Adding or removing elements from the beginning or middle can cause shifting of elements.

**When to use:**
- Use `LinkedList` when your application needs to perform frequent operations at both ends of the list, such as a **queue** or **stack**.

---

### 7. **Iteration Performance:**

- Both `ArrayList` and `LinkedList` have **O(n)** time complexity for iteration (where `n` is the number of elements). However, `ArrayList` tends to perform better in iteration because it benefits from **locality of reference** (elements are stored in contiguous memory), whereas `LinkedList` has **pointer dereferencing overhead**.

**When to use:**
- If you need to **iterate frequently** and the collection size is large, use `ArrayList` for better performance.

---

### **Summary of When to Use `ArrayList` vs `LinkedList`:**

| **Operation**                        | **ArrayList**                               | **LinkedList**                                |
|--------------------------------------|--------------------------------------------|---------------------------------------------|
| **Access by index**                 | O(1)                                       | O(n)                                        |
| **Add/remove from the end**          | O(1) (amortized, except resize)            | O(1)                                        |
| **Add/remove from the start/middle** | O(n) (shift elements)                     | O(1) (if node is known) or O(n) (for search) |
| **Memory usage**                     | Less memory (no node overhead)             | More memory (due to node storage)            |
| **Iteration**                        | Faster (contiguous memory)                 | Slower (pointer dereferencing)               |
| **Deque operations**                 | Not efficient                              | Efficient (supports `addFirst`, `removeFirst`, etc.) |
| **Use case**                         | Frequent access, minimal modifications     | Frequent insertions/removals (especially from ends) |

---

### **When to Prefer `ArrayList`:**
- When you need fast **random access**.
- When your operations involve **more reads** than writes.
- When you need **low memory overhead** and efficient iteration.

### **When to Prefer `LinkedList`:**
- When you need frequent **insertions and deletions**, especially at the beginning or middle of the list.
- When your application involves **queue-like** operations (using `Deque` interface).
- When **memory is not a concern** and you require constant-time additions/removals from the ends.

In most cases, `ArrayList` is a better default choice unless your specific use case (e.g., frequent additions/removals from the middle or ends of the list) favors `LinkedList`.


When to use ArrayList vs LinkedList in Java? [Answered]

When to use ArrayList or LinkedList in Java is one of the most popular Java interview questions and also asked as a difference between ArrayList and LinkedList. Earlier, I have shared common Java collections interview questions and in this article, I will explain the difference between them. ArrayList and LinkedList are two popular concrete implementations of the List interface from Java's popular Collection framework. Being List implementation both ArrayList and LinkedList are ordered, the index-based and allows duplicate. Despite being from the same type of hierarchy there are a lot of differences between these two classes which makes them popular among Java interviewers.

The main difference between ArrayList vs LinkedList is that the former is backed by an array while the latter is based upon the linked list data structure, which makes the performance of add(), remove(), contains(), and iterator() different for both ArrayList and LinkedList.

The difference between ArrayList and LinkedList is also an important Java collection interview question, as much popular as Vector vs ArrayList or HashMap vs HashSet in Java. Sometimes this is also asked as for when to use LinkedList and when to use ArrayList in Java. 

In this Java collection tutorial, we will compare LinkedList vs ArrayList on various parameters which will help us to decide when to use ArrayList over LinkedList in Java. 

Btw, we will not focus on the array and linked list data structure much, which is subject to data structure and algorithm, we'll only focus on the Java implementations of these data structures which are ArrayList and LinkedList. 

If you want to learn more about the array and linked list data structure itself, I suggest you check Data Structures and Algorithms: Deep Dive Using Java course by Tim Buchalaka on Udemy.

It explains essential data structure in Java programming language and most importantly teaches you when to use which data structure, a good refresher for those who are preparing for coding interviews too. 

When to use ArrayList vs LinkedList in Java
Before comparing differences between ArrayList and LinkedList, let's see What is common between ArrayList and LinkedList in Java :

1) Both ArrayList and LinkedList are an implementation of the List interface, which means you can pass either ArrayList or LinkedList if a method accepts the java.util.List interface. 

Btw, if you are new to Java's collections framework then I suggest you first go through Java Fundamentals: Collections by Richard Warburton. It's an online Java course on Pluralsight, which you can avail of free by signing their 10-day free trial. IMHO, it's worth going through that course to learn Java collections in the right way. 

When to use ArrayList vs LinkedList in Java


2) Both ArrayList and LinkedList are not synchronized, which means you can not share them between multiple threads without external synchronization. See here to know How to make ArrayList synchronized in Java.

3) ArrayList and LinkedList are ordered collection e.g. they maintain insertion order of elements i.e. the first element will be added to the first position.


4) ArrayList and LinkedList also allow duplicates and null, unlike any other List implementation e.g. Vector.

5) An iterator of both LinkedList and ArrayList are fail-fast which means they will throw ConcurrentModificationException if a collection is modified structurally once the Iterator is created. They are different than CopyOnWriteArrayList whose Iterator is fail-safe.

Difference between LinkedList and ArrayList in Java
Now let's see some differences between ArrayList and LinkedList and when to use ArrayList and LinkedList in Java.

1. Underlying Data Structure
The first difference between ArrayList and LinkedList comes with the fact that ArrayList is backed by Array while LinkedList is backed by LinkedList. This will lead to further differences in performance.

2. LinkedList implements Deque
Another difference between ArrayList and LinkedList is that apart from the List interface, LinkedList also implements the Deque interface, which provides first in first out operations for add() and poll() and several other Deque functions. 

Also, LinkedList is implemented as a doubly-linked list and for index-based operation, navigation can happen from either end (see Complete Java MasterClass).

3. Adding elements in ArrayList
Adding an element in ArrayList is O(1) operation if it doesn't trigger re-size of Array, in which case it becomes O(log(n)), On the other hand, appending an element in LinkedList is O(1) operation, as it doesn't require any navigation.

4. Removing an element from a position
In order to remove an element from a particular index e.g. by calling remove(index), ArrayList performs a copy operation which makes it close to O(n) while LinkedList needs to traverse to that point which also makes it O(n/2), as it can traverse from either direction based upon proximity.

5. Iterating over ArrayList or LinkedList
Iteration is the O(n) operation for both LinkedList and ArrayList where n is a number of an element.

6. Retrieving element from a position
The get(index) operation is O(1) in ArrayList while its O(n/2) in LinkedList, as it needs to traverse till that entry. Though, in Big O notation O(n/2) is just O(n) because we ignore constants there. 

If you want to learn more about how to calculate time and space complexity for your algorithms using Big O notation, I recommend reading Grokking Algorithms by Aditya Bhargava, one of the most interesting books on this topic I have read ever. 

Difference between linked list and arraylist in Java

7. Memory
LinkedList uses a wrapper object, Entry, which is a static nested class for storing data and two nodes next and previous while ArrayList just stores data in Array. 

So memory requirement seems less in the case of ArrayList than LinkedList except for the case where Array performs the re-size operation when it copies content from one Array to another. 

If Array is large enough it may take a lot of memory at that point and trigger Garbage collection, which can slow response time.

From all the above differences between ArrayList vs LinkedList, It looks like ArrayList is the better choice than LinkedList in almost all cases, except when you do a frequent add() operation than remove(), or get(). 

It's easier to modify a linked list than ArrayList, especially if you are adding or removing elements from start or end because the linked list internally keeps references of those positions and they are accessible in O(1) time. 

In other words, you don't need to traverse through the linked list to reach the position where you want to add elements, in that case, addition becomes an O(n) operation. For example, inserting or deleting an element in the middle of a linked list.  

In my opinion, use ArrayList over LinkedList for most of the practical purposes in Java

Read more: https://www.java67.com/2012/12/difference-between-arraylist-vs-LinkedList-java.html#ixzz8hiql6tHi

Difference between HashMap and LinkedHashMap in Java

Difference between LinkedHashMap and HashMap in Java
HashMap and LinkedHashMap are two of the most commonly used Map implementation in Java. The main difference between HashMap and LinkedHashMap is that LinkedHashMap maintains the insertion order of keys, the order in which keys are inserted into LinkedHashMap. On the other hand, HashMap doesn't maintain any order or keys, or values. In terms of performance, there is not much difference between HashMap and LinkedHashMap but yes LinkedHashMap has more memory footprint than HashMap to maintain doubly LinkedList which it uses to keep track of the insertion order of keys. 



Sometimes you notice that HashMap also returns elements in order e.g. before Java 8 when you use the Integer key and then iterate over Map, you would see it returning entries in a particular order, but those are not guaranteed. 


Any code which is dependent upon ordering provided by HashMap will likely break in a future release when that behavior changes.

LinkedHashMap and HashMap in Java - Similarities
There are a lot of similarities between LinkedHashMap and HashMap in Java, as they both implement Map interface.  let's have a look :


1. Thread safety
 Both LinkedHashMap and HashMap are not synchronized and subject to race conditions if shared between multiple threads without proper synchronization. You can also use Collections.synchronizedMap() for making them synchronized.


2. Fail Fast Iterator
Iterator returned by HashMap and LinkedHashMap is fail-fast in nature.


3. Performance

The performance of HashMap and LinkedHashMap are similar also.




Difference between LinkedHashMap and HashMap in Java
Now let's see some differences between LinkedHashMap and HashMap in Java:


1. Order
The first and foremost difference between LinkedHashMap and HashMap is order, HashMap doesn't maintain any order while LinkedHashMap maintains the insertion order of elements in Java.


2. Memory Requirement
LinkedHashMap also requires more memory than HashMap because of this ordering feature. As I said before LinkedHashMap uses doubly LinkedList to keep the order of elements.


3. Class Hierarchy
 LinkedHashMap actually extends HashMap and implements the Map interface.

Here is how LinkedHashMap is implemented in Java, which is also important to understand for Java developers. 


Difference between HashMap and LinkedHashMap in Java




Few things to note, while using LinkedHashMap in Java 
Here are a couple of important things to note while using LinkedHashMap in Java :


1. Default ordering provided by LinkedHashMap is the order on which key is inserted, known as insertion order, but LinkedHashMap can be created with another ordering called access order, which is defined by accessing entries.

2. Re-entering a mapping, doesn't alter the insertion order of LinkedHashMap. For example, if you already have mapping for a key, and want to update its value by calling put(key, newValue), the insertion order of LinkedHashMap will remain the same.

3. Access order is affected by calling get(key), put(key, value), or putAll(). When a particular entry is accessed, it moves towards the end of the doubly linked list, maintained by LinkedHashMap.

4. LinkedHashMap can be used to create an LRU cache in Java. Since in LRU or Least Recently Used Cache, the oldest non accessed entry is removed, which is the head of the doubly linked list maintained by LinkedHashMap.

5. Iterator of LinkedHashMap returns elements in the order e.g. either insertion order or access order.

6. LinkedHashMap also provides a method called removeEldestEntry(), which is protected, and default implementation return false. If overridden, an implementation can return true to remove the oldest entry, when a new entry is added.

Given the insertion order guarantee of LinkedHashMap, It's a good compromise between HashMap and TreeMap in Java because with TreeMap you get increased cost of iteration due to sorting and performance drops on to log(n) level from constant time. That's all about the difference between LinkedHashMap and HashMap in Java.


Read more: https://www.java67.com/2012/08/difference-between-hashmap-and-LinkedHashMap-Java.html#ixzz8hir8soxi

Difference between ArrayList and HashSet in Java? Answer with Example

ArrayList vs HashSet Java
The main difference between ArrayList and HashSet is that one is a List implementation while the other is a Set implementation. It means all the differences between a List data structure and a Set data structure also apply to this pair. For example, List implementations are ordered, it stores the element in the order they were added, while Set implementation doesn't provide such a guarantee. Similarly, since List provides Random access, you can access any element directly if you know the index, but Set doesn't provide such a facility. 

You need to Iterate through the whole collection to get access to any elements. We will see a couple of more differences in this Java tutorial. 


By the way ArrayList and HashSet are the two most common Collection classes used in Java programming language and before discussing the difference between ArrayList vs HashSet, let's see some similarities between them :



Similarities ArrayList and HashSet
Here are couple of similarities between ArrayList and HashSet in Java:

1) Both ArrayList and HashSet are non synchronized collection classes and not meant to be used in multi-threading and concurrent environments. You can make ArrayList and HashSet synchronized by using Collections.synchroinzedCollection() just like we make ArrayList and HashSet read-only other days.

2) Both ArrayList and HashSet can be traversed using Iterator. This is in fact a preferred way if you want to perform operations on all elements.

3) Iterator of ArrayList and HashSet both are fail-fast, i.e. they will throw ConcurrentModificationException if ArrayList or HashSet is modified structurally once Iterator has been created.

Now let's see some differences between ArrayList and HashSet in Java 






Difference between ArrayList vs HashSet in Java
Here are a couple of differences between ArrayList and HashSet in Java:

1. First and most important difference between ArrayList and HashSet is that ArrayList implements List interface while HashSet implements Set interface in Java.

2. Another difference between ArrayList and HashSet is that ArrayList allows duplicates while HashSet doesn't allow duplicates. This is the side effect of first difference and property of implementing List and Set interface.

3. The differences between ArrayList and HashSet is that ArrayList is an ordered collection and maintains insertion order of elements while HashSet is an unordered collection and doesn't maintain any order.

4. The difference between ArrayList and HashSet is that ArrayList is backed by an Array while HashSet is backed by a HashMap instance. See how HashSet internally works in Java for more details.

5. Fifth difference between HashSet and ArrayList is that it's index-based you can retrieve objects by calling get(index) or remove objects by calling remove(index) while HashSet is completely object-based. HashSet also doesn't provide the get() method.


ArrayList and HashSet Example in Java
Here's an example that demonstrates the difference between ArrayList and HashSet:

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArrayListVsHashSetExample {
    public static void main(String[] args) {
        // Example using ArrayList
        ArrayList<String> arrayList = new ArrayList<>();

        // Adding elements to ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        arrayList.add("Apple"); // Duplicate element

        // Displaying elements of ArrayList
        System.out.println("ArrayList Elements:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        // Example using HashSet
        HashSet<String> hashSet = new HashSet<>();

        // Adding elements to HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); // Duplicate element (ignored in a HashSet)

        // Displaying elements of HashSet using Iterator
        System.out.println("\nHashSet Elements:");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

In the example, you can observe that the ArrayList allows the addition of duplicate elements, while the HashSet automatically ignores duplicates. The order of elements in the ArrayList is maintained, whereas the HashSet does not guarantee any specific order when iterating over elements.

Here is a nice summary of the differences between ArrayList and HashSet in Java:

Difference between ArrayList and HashSet in Java


That's all on the difference between ArrayList and HashSet. these differences help you to decide where to use ArrayList and where to use HashSet in Java. in terms of performance between ArrayList and HashSet, choose what suits best to you. the raw array has fasted among them.


Read more: https://www.java67.com/2012/07/difference-between-arraylist-hashset-in-java.html#ixzz8hirQd9En

Difference between TreeMap and TreeSet in Java? Answer

Difference between TreeSet and TreeMap in Java
The main difference between TreeMap and TreeSet is that TreeMap is an implementation of Map interface while TreeSet is an implementation of the Set interface. There are some similarities between both TreeMap and TreeSet and few differences as well. In this Java tutorial, we will first see similarities between TreeMap and TreeSet, and then you will learn some differences between TreeMap and TreeSet in Java. 



The key point to remember about TreeMap and TreeSet is that they use compareTo() or compare() method to compare object, So if uses put a String object in TreeSet of Integers, add() method will throw ClassCastException at runtime prior to Java 5.

From Java 5 you can use Generics to avoid this happening by declaring TreeMap and TreeSet with parametrized version. If you want to master the Java Collection framework by heart, you can see the Java Generics and Collection book by Maurice Naftalin, one of the best works on the Java Collections framework.



Similarities between TreeMap and TreeSet in Java
Here is a list of similarities between TreeMap and TreeSet in Java:

1. Both TreeMap and TreeSet are sorted data structures, which means they keep their element in predefined Sorted order. Sorting order can be natural sorting order defined by Comparable interface or custom sorting Order defined by Comparator interface. 

Both TreeMap and TreeSet has overloaded constructor which accepts a Comparator, if provided all elements inside TreeSet or TreeMap will be compared and Sorted using this Comparator.


2. Both TreeSet and TreeMap implements base interfaces e.g. TreeSet implements Collection and Set interface so that they can be passed to a method where a Collection is expected and TreeMap implements java.util.Map interface, which means you can pass it when a Map is expected.

3. TreeSet is practically implemented using TreeMap instance, similar to HashSet which is internally backed by HashMap instance. See my post Internal Implementation of HashSet to learn more. 

4. Both TreeMap and TreeSet are non-synchronized Collections, hence can not be shared between multiple threads. You can make both TreeSet and TreeMap synchronized by wrapping them into the Synchronized collection by calling Collections.synchroinzedMap() method.


5. Iterator returned by TreeMap and TreeSet are fail-fast, which means they will throw ConcurrentModificationException when TreeMap or TreeSet is modified structurally once Iterator is created. this fail-fast behavior is not guaranteed but works in the best effort.


6. Both TreeMap and TreeSet are slower than there Hash counterpart like HashSet and HashMap and instead of providing constant-time performance for add, remove, and get operation they provide performance in O(log(n)) order.

Difference between TreeMap and TreeSet in Java




TreeSet vs TreeMap in Java
Now let's see some differences between TreeSet vs TreeMap in Java:

1. Major difference between TreeSet and TreeMap is that TreeSet implements Set interface while TreeMap implements Map interface in Java.


2.Second difference between TreeMap and TreeSet is the way they store objects. TreeSet stores only one object while TreeMap uses two objects called key and Value. Objects in TreeSet are sorted while keys in TreeMap remain in sorted order.


3. Third difference between TreeSet and TreeMap is that, former implements NavigableSet while later implements NavigableMap in Java.


4. Fourth difference is that duplicate objects are not allowed in TreeSet but duplicates values are allowed in TreeMap.


That's all on the difference between TreeSet and TreeMap in Java. Both provide sorting but their usage is different. TreeMap is used to keep mappings between key and values in sorted order while TreeSet is used to keep just one element in sorted order. 

TreeSet also doesn't allow duplicates but TreeMap does allow duplicate values. If you find any other significant difference between TreeMap and TreeSet then please post as a comment.


Read more: https://www.java67.com/2012/08/difference-between-treemap-and-treeset-java.html#ixzz8hirYwR7X

Difference between HashSet and TreeSet in Java

Difference between HashSet and TreeSet in Java
There are several differences between a HashSet and a TreeSet are similar to what we discussed as a difference between TreeMap and HashMap. Anyway, Set and Map are two completely different interfaces so we will revisit those differences here. Probably the most important difference between HashSet and TreeSet is the performance. HashSet is faster than TreeSet which means if you need performance use HashSet but HashSet doesn't provide any kind of ordering so if you need ordering then you need to switch to TreeSet which provides sorting of keys. 

Sorting can be natural order defined by a Comparable interface or any particular order defined by a Comparator interface in Java.



Apart from the differences between HashSet and TreeSet, there are some common things between them. let's see what is common between HashSet and TreeSet in Java.

 By the way, this is one of the popular Java collection interview questions much like ArrayList vs Vector and Hashtable vs HashMap. If you are going for any Java programming interview, it's worth preparing.



What is Common in HashSet and TreeSet in Java
As I said there are a lot of things that are common between HashSet and TreeSet in Java, let’s have a look:

1)Both HashSet and TreeSet implements java.util.Set interface which means they follow contract of Set interface and doesn't allow any duplicates.

2)Both HashSet and TreeSet are not thread-safe and not synchronized. Though you can make them synchronized by using the Collections.synchronizedSet() method.

3) The third similarity between TreeSet and HashSet is that Iterator of both classes is fail-fast in nature. They will throw ConcurrentModificationException if Iterator is modified once Iterator is created. this is not guaranteed and application code should not rely on this code but Java makes best effort to fail as soon as it detects a structural change in underlying Set.



HashSet vs TreeSet in Java
Now let's see a couple of differences between HashSet vs TreeSet in Java. This is enough to decide whether you should use HashSet or TreeSet in a given scenario.

1) The first major difference between HashSet and TreeSet is performance. HashSet is faster than TreeSet and should be the preferred choice if sorting of elements is not required. TreeSet is internally backed by a Red-Black tree. For a detailed description of the Red-Black Tree, you should read a good book on data structure and algorithms like Introduction to Algorithms by Thomas Corman.

The performance difference comes from the underlying data structure used by TreeSet and HashSet i.e. a tree and a hash table. Adding an element of a tree is slower than adding it to a hash table but it is still much faster than adding it into the right place in the linked list or array. 

If the tree contains n elements, then an average log2N comparisons are required to find the correct position for a new element. For example, if the tree contains 1000 elements then adding a new element requires about 10 comparisons.


2) Second difference between HashSet and TreeSet is that HashSet allows null object but TreeSet doesn't allow null Object and throw NullPointerException, Why, because TreeSet uses compareTo() method to compare keys and compareTo() will throw java.lang.NullPointerException as shown in below example :

HashSet<String> hashSet = new HashSet<String>();
hashSet.add("Java");
hashSet.add(null);
       
TreeSet<String> treeSet = new TreeSet<String>();
treeSet.add("C++");
treeSet.add(null); //Java.lang.NullPointerException
Output:
Exception in thread "main" java.lang.NullPointerException
        at java.util.TreeMap.put(TreeMap.java:541)
        at java.util.TreeSet.add(TreeSet.java:238)
        at test.CollectionTest.main(CollectionTest.java:27)
Java Result: 1


3) Another significant difference between HashSet and TreeSet is that HashSet is backed by HashMap while TreeSet is backed by TreeMap in Java.


4) One more difference between HashSet and TreeSet which is worth remembering is that HashSet uses equals() method to compare two objects in Set and for detecting duplicates while TreeSet uses the compareTo() method for the same purpose. 

If equals() and compareTo() are not consistent, i.e. for two equal object equals should return true while compareTo() should return zero then it will break the contract of Set interface and will allow duplicates in Set implementations like TreeSet


5) Now the most important difference between HashSet and TreeSet is ordering. HashSet doesn't guarantee any order while TreeSet maintains objects in the Sorted order defined by either Comparable or Comparator method in Java.

Here is a nice summary slide of key differences between TreeSet and HashSet in Java, which compares both of these collections on ordering, sorting, performance, underlying data structure, the method used for duplicate detection, and how they are implemented in JDK.




That's all on the difference between HashSet and TreeSet in Java. Use HashSet if you don't need sorting and looking for better performance while TreeSet is the first choice if you need to maintain objects in sorted order in Java. Both of them will not allow duplicates and maintain a unique set of elements. 


Read more: https://www.java67.com/2012/08/difference-between-hashset-and-treeset-java.html#ixzz8hirhXG00


5 Difference between Hashtable vs HashMap in Java? Answer

Hashtable vs HashMap in Java
Hashtable and HashMap are two hash-based collections in Java and are used to store objects as key-value pairs. Despite being hash-based and similar in functionality there is a significant difference between Hashtable and HashMap and without understanding those differences if you use Hashtable in place of HashMap then you may run into series of subtle programs which is hard to find and debug. Unlike the Difference between ArrayList and HashMap, Differences between Hashtable and HashMap are more subtle because both are similar kinds of collections. Before seeing the difference between HashMap and Hashtable let's see some common things between HashMap and Hashtable in Java.





Similarities between Hashtable and HashMap in Java
There are a lot of similar things between Hashtable and HashMap in Java which is good to know and these also helps to find exactly what is different between HashMap and Hashtable in Java:

1. Common Parent
Both Hashtable and HashMap implements java.util.Map interface.

2. Common Underlying data structure
Hashtable and HashMap both are hash-based collections and works on the principle of hashing.

3. Common SLA
 Hashtable and HashMap both provide constant-time performance for the put and get method if objects are distributed uniformly across buckets.


4. Common Framework
From JDK 4 both Hashtable and HashMap are part of the Java collection framework.





Difference between Hashtable and HashMap in Java
Despite being so similar there are some differences between Hashtable and HashMap in Java which separates them completely, let's have a look :

1. Thread safety
The first and most significant difference between Hashtable and HashMap is that HashMap is not thread-safe while Hashtable is a thread-safe collection.

2. Performance
The second important difference between Hashtable and HashMap is performance since HashMap is not synchronized it perform better than Hashtable.

3. Old vs New

The third difference on Hashtable vs HashMap is that Hashtable is an obsolete class and you should be using ConcurrentHashMap in place of Hashtable in Java.

4. Synchronized
Hashtable is a synchronized collection but HashMap is not. All methods of Hashtable are synchronized to prevent multithreading issues. 

5. Null Key
Since Hashtable is a synchronized collection it doesn't allow Null keys but HashMap does allow null keys and values. 

6. Fail fast (Iteraotr vs Enumeration)
Enumeration is used to iterate over keys and values in Hashtable which is not fail-fast, while Iterator is used to go over keys and values in HashMap and its fail-fast. 

Here is all the difference between HashMap and Hashtable in the nice tabular format: 



That's all about HashMap vs Hashtable in Java. These were some important differences between Hashtable and HashMap in Java. If you know any other difference which is not included here then feels free to add them in the comment section. Remember this is an important question on Java interview and good to prepare it well.


Read more: https://www.java67.com/2012/08/5-difference-between-hashtable-hashmap-Java-collection.html#ixzz8his4W25Y

How to Sort HashMap in Java based on Keys and Values

HashMap is not meant to keep entries in sorted order, but if you have to sort HashMap based upon keys or values, you can do that in Java. Sorting HashMap on keys is quite easy, all you need to do is to create a TreeMap by copying entries from HashMap. TreeMap is an implementation of SortedMap and keeps keys in their natural order or a custom order specified by Comparator provided while creating TreeMap. This means you can process entries of HashMap in sorted order but you cannot pass a HashMap containing mappings in a specific order, this is just not possible because HashMap doesn't guarantee any order.



On other hand, sorting HashMap by values is rather complex because there is no direct method to support that operation. You need to write code for that. In order to sort HashMap by values you can first create a Comparator, which can compare two entries based on values. 

Then get the Set of entries from Map, convert Set to List, and use Collections.sort(List) method to sort your list of entries by values by passing your customized value comparator. This is similar to how you sort an ArrayList in Java. 


Half of the job is done by now. Now create a new LinkedHashMap and add sorted entries into that. Since LinkedHashMap guarantees insertion order of mappings, you will finally have a Map where contents are sorted by values.


5 Steps to sort HashMap by values
One difference between sorting HashMap by keys and values is that it can contain duplicate values by not duplicate keys. You cannot use TreeMap here because it only sorts entries by keys. In this case, you need to :
Get all entries by calling entrySet() method of Map
Create a custom Comparator to sort entries based upon values
Convert entry set to list
Sort entry list by using Collections.sort() method by passing your value comparator
Create a LinkedHashMap by adding entries in sorted order.





Steps to sort HashMap by keys
There are two ways to sort HashMap by keys, first by using TreeMap and second by using LinkedHashMap. If you want to sort using TreeMap then it's simple, just create a TreeMap by copying the content of HashMap. 


On the other hand, if you want to create a LinkedHashMap then you first need to get a key set, convert that Set to a List, sort that List, and then add them into LHM in the same order. Remember HashMap can contain one null key but duplicate keys are not allowed.






HashMap Sorting by Keys and Values in Java Example
Here is our sample Java program to sort a HashMap first by keys and then by values. This program is divided into two part, the first part sorts HashMap by keys, and the second part sorts it by values. The second part is more tricky the first part as there is no native Map implementation that supports any order for values. 

In order to sort a HashMap by values, we had to create our own Comparator implementation which compares each entry by values to arrange them in a particular order. You can see that our valueComparator overrides compare() method and accepts two entries. Later it retrieves values from those entries and compare them and return result. 


Since there is no method in Java Collection API to sort Map, we need to use Collections.sort() method which accepts a List. This involves creating a temporary ArrayList with entries for sorting purpose and then again copying entries from sorted ArrayList to a new LinkedHashMap to keep them in sorted order. 

Finally, we create a HashMap from that LinkedHashMap, which is what we needed.

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * How to sort HashMap in Java by keys and values. 
 * HashMap doesn't guarantee any order, so you cannot rely on it, even if
 * it appear that it storing entries in a particular order, because
 * it may not be available in future version e.g. earlier HashMap stores
 * integer keys on the order they are inserted but from Java 8 it has changed.
 * 
 * @author WINDOWS 8
 */

public class HashMapSorting{

    public static void main(String args[]) throws ParseException {
        
        // let's create a map with Java releases and their code names
        HashMap<String, String> codenames = new HashMap<String, String>();
        
        codenames.put("JDK 1.1.4", "Sparkler");
        codenames.put("J2SE 1.2", "Playground");
        codenames.put("J2SE 1.3", "Kestrel");
        codenames.put("J2SE 1.4", "Merlin");
        codenames.put("J2SE 5.0", "Tiger");
        codenames.put("Java SE 6", "Mustang");
        codenames.put("Java SE 7", "Dolphin");
        
        System.out.println("HashMap before sorting, random order ");
        Set<Entry<String, String>> entries = codenames.entrySet();
       
        for(Entry<String, String> entry : entries){
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
        
        // Now let's sort HashMap by keys first 
        // all you need to do is create a TreeMap with mappings of HashMap
        // TreeMap keeps all entries in sorted order
        TreeMap<String, String> sorted = new TreeMap<>(codenames);
        Set<Entry<String, String>> mappings = sorted.entrySet();
        
        System.out.println("HashMap after sorting by keys in ascending order ");
        for(Entry<String, String> mapping : mappings){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
        
        
        // Now let's sort the HashMap by values
        // there is no direct way to sort HashMap by values but you
        // can do this by writing your own comparator, which takes
        // Map.Entry object and arrange them in order increasing 
        // or decreasing by values.
        
        Comparator<Entry<String, String>> valueComparator 
               = new Comparator<Entry<String,String>>() {
            
            @Override
            public int compare(Entry<String, String> e1, Entry<String, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };
        
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<String, String>> listOfEntries 
                  = new ArrayList<Entry<String, String>>(entries);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<String, String> sortedByValue 
                    = new LinkedHashMap<String, String>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<String, String> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("HashMap after sorting entries by values ");
        Set<Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();
        
        for(Entry<String, String> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
    }

    
}

Output:
HashMap before sorting, random order 
Java SE 7 ==> Dolphin
J2SE 1.2 ==> Playground
Java SE 6 ==> Mustang
J2SE 5.0 ==> Tiger
J2SE 1.3 ==> Kestrel
J2SE 1.4 ==> Merlin
JDK 1.1.4 ==> Sparkler
HashMap after sorting by keys in ascending order 
J2SE 1.2 ==> Playground
J2SE 1.3 ==> Kestrel
J2SE 1.4 ==> Merlin
J2SE 5.0 ==> Tiger
JDK 1.1.4 ==> Sparkler
Java SE 6 ==> Mustang
Java SE 7 ==> Dolphin
HashMap after sorting entries by values 
Java SE 7 ==> Dolphin
J2SE 1.3 ==> Kestrel
J2SE 1.4 ==> Merlin
Java SE 6 ==> Mustang
J2SE 1.2 ==> Playground
JDK 1.1.4 ==> Sparkler
J2SE 5.0 ==> Tiger

That's all about how to sort HashMap by keys and values in Java. Remember, HashMap is not intended to keep entries in sorted order, so if you have a requirement to always keep entries in a particular order, don't use HashMap instead use TreeMap or LinkedHashMap. 

This method should only be used to cater to Adhoc needs where you receive a HashMap from some part of legacy code and you have to sort it first to process entries. If you have control of creating the Map initially prefer the right implementation of Map than just HashMap.

And, now is the quiz time? Does sorting a HashMap really make sense? Shouldn't you be using TreeMap or LinkedHashMap if you need to keep your data in sorted order of keys? 


Read more: https://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html#ixzz8hj3fd3ge

How to Convert a LinkedList to an Array in Java? Example

You can convert a LinkedList to an array in Java by using the toArray() method of the java.util.LinkedList class. The toArray() method accepts an array of relevant type to store contents of LinkedList. It stores the elements in the array in the same order they are currently inside the LinkedList. By using the toArray() method you can convert any type of LinkedList e.g. Integer, String or Float to any type of Array, only catch is this you cannot convert a LinkedList to an array of primitives i.e. a LinkedList of Integer cannot be converted into an array of ints by using toArray() method, but you can convert it to an array of Integer objects, that's perfectly Ok.



Similarly, you can convert a LinkedList of Double to an array of Double and LinkedList of Float objects to an array of Float objects in Java.

Btw, the Java Collection framework is vast as it contains so many classes for different purposes. The best way to master the Collection framework is to pick up a good book and follow it from start to end like Java Generics and Collection, which provides comprehensive coverage of all important classes of Java Collection framework like ArrayList, Vector, HashMap, HashSet, etc.

Alternatively, you can also follow a good core Java course like The Complete Java MasterClass, which also coverers changes made in Java 8  like lambda expression and streams, which has completely changed how you use Collection classes in Java.

The bottom line is that a good knowledge of the Java Collection framework is essential for any Java programmer. In fact, these classes are the bread and butter of Java programming and you will often find them using in your day-to-day programming tasks.




Important points about toArray() methods
Since the toArray() method is used to convert LinkedList to an array in Java, it's important to learn more about it. In fact, you can use this method to convert any type of list to an array in Java as I have previously discussed while we are converting ArrayList to an array in Java.

Let's revise some of the important points about this useful method:

1) This method returns an array containing all of the elements in the given linked list in the same sequence i.e. it keeps the order intact. This is possible because LinkedList implements java.util.List interface which is an ordered collection and guarantees insertion order of elements.

2) The toArray() method expects the caller to provide an array of a specified type, but it's also smart enough to make some adjustments into length.



3) If the given array is not big enough to store all elements of the LinkedList a new array is created of the same runtime type and size of the LinkedList.

4) If the given array is bigger than the linked list then spare buckets are set to null. You can use them to determine the true length of the array if you know that list cannot contain null elements.

If you are interested in learning more about this method or in general, the Java Collection framework, I strongly suggest you join the Java Fundamentals: Collections course on Pluralsight. One of the most comprehensive courses on this topic.

How to Convert LinkedList to Array in Java? Example





Java Program to convert LinkedList to an array
Here is a sample Java program that shows you can convert a LinkedList to an array in Java. This program contains two examples, the first one converts a LinkedList of String to an array and the second one converts the LinkedList of Integer to an array of Integer.

As I have said, you cannot convert LinkedList of wrapper objects to an array of primitive objects e.g. LinkedList of Double cannot be converted to an array of double primitives, for that you need to loop through the list and manually insert each element into an array to take advantage of autoboxing.



Btw, after Java 8, you can also use the map() method to convert a list of Integer objects into an array of Integer objects.

Btw, If you are yet to start Java 8 then I suggest you take a look a these free Java 8 courses to start with. It's very important for a Java developer to get familiar with Java 8 changes.

Anyway, here is our sample program to convert a LinkedList to an array of the same type in Java:

import java.util.Arrays;
import java.util.LinkedList;


public class LinkedListToArray {

public static void main(String args[]){

// creating and initializing a LinkedList of String
LinkedList<String> listOfBooks = new LinkedList<>();
listOfBooks.add("Effective Java");
listOfBooks.add("Clean Code");
listOfBooks.add("Clean Coder");

// printing the contents of LinkedList before conversion
System.out.println("LinkedList: " + listOfBooks);

// Converting the LinkedList to array
String[] arrayOfBooks = listOfBooks.toArray(new String[listOfBooks.size()]);


// printing contents of array after conversion
System.out.println("String array: " + Arrays.toString(arrayOfBooks));


// Second example - Creating LinkedList of Integers
LinkedList<Integer> listOfScores = new LinkedList<>();
listOfScores.add(100);
listOfScores.add(171);
listOfScores.add(264);

// printiing LinkedList
System.out.println("LinkedList: " + listOfScores);

// converting LinkedList of Integer to array of integers
// int[] score = listOfScores.toArray(new int[listOfScores.size()]);
// compile time error
Integer[] scores = listOfScores.toArray(new Integer[listOfScores.size()]); 
// this is ok

// printing array
System.out.println("Integer array: " + Arrays.toString(scores));
}
}

Output:
LinkedList: [Effective Java, Clean Code, Clean Coder]
String array: [Effective Java, Clean Code, Clean Coder]
LinkedList: [100, 171, 264]
Integer array: [100, 171, 264]


That's all about how to convert a LinkedList to the array in Java. Just remember that you can use the toArray() method for this conversion. It also maintains the order of elements and can create a new array if a given array is not big enough to store all elements.


Read more: https://www.java67.com/2016/02/how-to-convert-linkedlist-to-array-in-java.html#ixzz8hj3s0hyr

How to find First and Last element in LinkedList Java? Doubly linked list Example

In this article, you will learn how to get the first and last element of a linked list with the help of getFirst() and getLast() of the LinkedList class. If you have programming or even gone to a computer science course you probably know what is a linked list? It's a data structure that allows you to store objects in such a way that you can don't need a big chunk of contiguous memory like another popular data structure array. It works perfectly even if you have a fragmented heap. LinkedList is Java's implementation of this fundamental data structure. 



There are two types of linked list, singly and doubly linked list, and Java's LinkedList is a doubly linked list. If you are wondering what is difference between a singly and doubly linked list, well in singly linked list you can traverse only in one direction from head to tail, or from first to last element because every node has address of only next node. 

While in a doubly linked list, every node has reference to both previous and next node, thus allows you to traverse in both directions, from head to tail and backward. You can verify this by yourself by looking at the code of java.util.LinkedList in Eclipse, just use shortcut Ctrl + T and type the name, if you have added Java source code in Eclipse, it will open the class. 

You will find that LinkedList class in Java has a private static class called Node, which has reference to both the previous and next node.

For those, who can't see the code of LinkedList, here is the snippet of the Node class.


private static class Node {
        E item;
        Node next;
        Node prev;

        Node(Node prev, E element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

You can clearly see that Node has reference to two other nodes, which makes LinkedList a doubly linked list and allows you to traverse in both direction, from first to last and vice-versa.


Getting First and the Last Element of LinkedList in Java - Example
Here is our sample Java program to find the first and last object from LinkedList in Java. We will be using Java's Collection framework API to get our done. In this example, I have created a  linked list of String to store different programming languages.  You can store objects into LinkedList by calling add() method. 

This method encapsulates data into a private static nested class Node, which represent a node in a doubly linked list and keep reference of both previous and next node in linked list. Also this method adds the new element at the end of linked list i.e. on the tail, which means last method you add into linked list will be the last element in the LinkedList itself. 

The angle bracket you see while creating instance of LinkedList is known as diamond operator, added backed in Java 7 and help you to avoid declaring types on right hand side of assignment operator as well. The compiler can now infer it by looking at left-hand side. You should use it every time you are using JDK 1.7 to reduce at least a little bit of boiler plate coding.


Doubly linked list in Java



Now coming back to our task, how do we retrieve the first and last element from linked list? Of course we don't know which elements are added, unlike this example, where we know. 

Since a linked list is a sequential data structure, by looking at how you add elements you can guess which one is first and which one is last, but this example is more for situation, where you receive a linked list from other part of your application and need to find first and last element.

LinkedList has getFirst() and getLast() method to retrieve first and last element from LinkedList in Java. I would have liked just first() and last() method but anyway.

import java.util.LinkedList;

/**
 * Java program to find first and last element of linked list in Java.
 */
public class LinkedListDemo{

    public static void main(String args[]) {

        LinkedList programmingLanguages = new LinkedList<>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Perl");
        programmingLanguages.add("Ruby");
        programmingLanguages.add("Python");
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("C#");
        programmingLanguages.add("Scala");
       
        // getting first element of linked list in Java
        String first = programmingLanguages.getFirst();
        System.out.printf("First element of LinkedList is : %s %n", first);
     
        // getting last element from linked list in Java
        String last = programmingLanguages.getLast();
        System.out.printf("Last element of LinkedList is  : %s %n", last);
    }
 
}

Output:
First element of LinkedList is : Java
Last element of LinkedList is  : Scala

That's all about how to find first and last node of a linked list in Java. Remember, Java's implementation of linked list data structure is a doubly linked list, which means each node has reference to both previous and next node. You can iterate over LinkedList but iterator doesn't guarantee any order, so beware of that as well.


Read more: https://javarevisited.blogspot.com/2015/02/how-to-find-first-and-last-element-of.html#ixzz8hj4Dw55l

How to find Middle Element of Linked List in Java in Single Pass

ow do you find the middle element of LinkedList in one pass is a programming question often asked Java and non-Java programmers in telephonic Interview. This question is similar to checking palindrome or calculating the factorial, where the Interviewer sometimes also asks to write code. In order to answer this question candidate must be familiar with the LinkedList data structure i.e. In the case of the singly LinkedList, each node of Linked List contains data and pointer, which is the address of the next Linked List and the last element of Singly Linked List points towards the null. Since in order to find the middle element of the Linked List you need to find the length of the linked list, which is counting elements till the end i.e. until you find the last element of the Linked List.




What makes this data structure Interview question interesting is that you need to find the middle element of LinkedList in one pass and you don’t know the length of LinkedList.

This is where candidates' logical ability puts into the test,  whether he is familiar with space and time trade-off or not etc.

As if you think carefully you can solve this problem by using two pointers as mentioned in my last post on How to find the length of the Singly Linked List in Java.

By using two pointers, incrementing one at each iteration and other at every second iteration. When the first pointer will point at end of Linked List, the second pointer will be pointing at a middle node of the Linked List.  

In fact, this two pointer approach can solve multiple similar problems like how to find the third node from last in a Linked List in one Iteration or how to find an Nth element from last in a Linked List. In this Java programming tutorial, we will see a Java program that finds the middle element of Linked List in one Iteration.

Btw, if you are new to Algorithms and Data Structure and not familiar with an essential data structure like a linked list, array or binary tree then  I suggest you go through a good, comprehensive online course like Data Structures and Algorithms: Deep Dive Using Java to learn the basics and brush up the fundamentals.





How to Find Middle Element of LinkedList in One Pass
Here is a complete Java program to find the middle node of Linked List in Java. Remember LinkedList class here is our custom class and don’t confuse this class with java.util.LinkedList is a popular Collection class in Java.

In this Java program, our class LinkedList represents a linked list data structure that contains a collection of the node and has a head and tail.

Each node contains data and addresses part. The main method of LinkedListTest class is used to simulate the problem, where we created Linked List and added few elements on it and then iterate over them to find the middle element of linked list in one pass in Java.

If you want to learn more about linked list data structure and different types of linked lists like a singly linked list, doubly linked list, circularly linked list et all then you can also check the Algorithms and Data Structures - Part 1 and 2 courses on Pluralsight. One of the better course to learn data structure and algorithms.



Btw, you would need a Pluralsight membership to access this course. If you are not a member, you can still access this course by using the 10-day free pass provided by Pluralsight to explorer its portal and online courses.




Java Program to Find the Middle Node of a Linked list in a Single-pass
Here is our complete Java program to find the middle node of a singly linked list in just one pass, it uses two-pointer pattern, also known as fast and slow pointer or hare and tortoise pattern  to solve this coding problem:

import test.LinkedList.Node;

/**
 * Java program to find middle element of linked list in one pass.
 * In order to find middle element of a linked list
 * we need to find the length first but since we can only
 * traverse linked list one time, we will have to use two pointers
 * one which we will increment on each iteration while 
 * other which will be incremented every second iteration.
 * So when the first pointer will point to the end of a
 * linked list, second will be pointing to the middle
 * element of a linked list
 *
 * @author Javin Paul
 */
public class LinkedListTest {
 
 
    public static void main(String args[]) {
        //creating LinkedList with 5 elements including head
      LinkedList linkedList = new LinkedList();
      LinkedList.Node head = linkedList.head();
      linkedList.add( new LinkedList.Node("1"));
      linkedList.add( new LinkedList.Node("2"));
      linkedList.add( new LinkedList.Node("3"));
      linkedList.add( new LinkedList.Node("4"));
   
      //finding middle element of LinkedList in single pass
      LinkedList.Node current = head;
      int length = 0;
      LinkedList.Node middle = head;
   
      while(current.next() != null){
          length++;
          if(length%2 ==0){
              middle = middle.next();
          }
          current = current.next();
      }
    
      if(length%2 == 1){
          middle = middle.next();
      }


      System.out.println("length of LinkedList: " + length);
      System.out.println("middle element of LinkedList : "                                  + middle);
     
    }
 
}

class LinkedList{
    private Node head;
    private Node tail;
 
    public LinkedList(){
        this.head = new Node("head");
        tail = head;
    }
 
    public Node head(){
        return head;
    }
 
    public void add(Node node){
        tail.next = node;
        tail = node;
    }
 
    public static class Node{
        private Node next;
        private String data;

        public Node(String data){
            this.data = data;
        }
     
        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
     
        public String toString(){
            return this.data;
        }
    }
}

Output:
length of LinkedList: 4
the middle element of LinkedList: 2




That’s all on How to find the middle element of LinkedList in one pass. As I said this is a good interview question to separate programmers from non-programmers. Also, the technique mentioned here to find the middle node of LinkedList can be used to find the 3rd element from Last or nth element from last in a LinkedList as well.


Read more: https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html#ixzz8hj4MWE2G

Difference between LinkedList and ArrayList in Java

LinkedList and ArrayList both implement List Interface but how they work internally is where the differences lie. The main difference between ArrayList and LinkedList is that ArrayList is implemented using a resizable array while LinkedList is implemented using doubly LinkedList. ArrayList is more popular among Java programmers than LinkedList as there are few scenarios on which LinkedList is a suitable collection than ArrayList. In this article, we will see some differences between LinkedList and ArrayList and try to find out when and where to use LinkedList over ArrayList.




LinkedList vs ArrayList in Java
All the differences between LinkedList and ArrayList have their root in the difference between Array and LinkedList data structure. If you are familiar with Array and LinkedList data structure you will most likely derive the following differences between them:

1. Since Array is an index based data-structure searching or getting element from Array with index is pretty fast. Array provides O(1) performance for get(index) method but remove is costly in ArrayList as you need to rearrange all elements. 

On the Other hand, LinkedList doesn't provide Random or index-based access and you need to iterate over the linked list to retrieve any element which is of order O(n).

2. Insertions are easy and fast in LinkedList as compared to ArrayList because there is no risk of resizing the array and copying content to the new array if the array gets full which makes adding into ArrayList of O(n) in the worst case while adding is O(1) operation in LinkedList in Java. ArrayList also needs to update its index if you insert something anywhere except at the end of the array.

3. Removal is like insertions better in LinkedList than ArrayList.

4. LinkedList has more memory overhead than ArrayList because in ArrayList each index only holds an actual object (data) but in the case of LinkedList, each node holds both data and address of the next and previous node.



When to use LinkedList and ArrayList in Java?
As I said LinkedList is not as popular as ArrayList but still, there are situations where a LinkedList is a better choice than ArrayList in Java. Use LinkedList in Java if:

1. Your application can live without Random access. Because if you need nth element in LinkedList you need to first traverse up to nth element O(n) and then you get data from that node.

2. Your application is more insertion and deletion driver and you insert or remove more than retrieval. Since insertion or removal doesn't involve resizing it's much faster than ArrayList.

And, if you need to know more diffrences betwen ArrayList and LinkedList in Java then here is a nice talbe which you can refer:

Difference between LinkedList vs ArrayList in Java? Answer



Difference between LinkedList and ArrayList in JavaThat’s all on the difference between ArrayList and LinkedList in Java. Use ArrayList in Java for all their situation where you need non-synchronized index-based access. ArrayList is fast and easy to use, just try to minimize array resizing by constructing ArrayList with a proper initial size.


Read more: https://javarevisited.blogspot.com/2012/02/difference-between-linkedlist-vs.html#ixzz8hj4i1MIs

How to search a LinkedList in Java? Example

You can search an element inside LinkedList in Java by using indexOf() and lastIndexOf() methods. Though LinkedList doesn't support random search like ArrayList, you can still go through the list, check each element and find out whether it's an interesting element or not. Since java.util.LinkedList is an implementation of a doubly-linked list, these two methods are quite handy to search from either end e.g. indexOf() method starts the search from the head and returns an element's position while lastIndexOf() starts the search from the tail. Though the position is not relative to the ends, they are always calculated from the head. 

You can also use these two methods to find out duplicate elements. If an element has appeared twice in the linked list then the indexOf() and lastIndexOf() method will return different positions for that because it will be found at different positions from head and tail. 



For unique elements, both these methods will return the same position.

In this article, you will see examples of both indexOf() and lastIndexOf() methods to search a given element inside LinkedList. As I said before since LinkedList doesn't support random search and searching an element requires list traversal, which means time complexity will be O(n).

Also, If you are good in Java but lacks data structure and algorithm skills, I strongly suggest reading Data Structures and Algorithm Analysis in Java by Mark A. Wiess. It's a great book to build your foundation on data structure and algorithms using Java programming language.





Java Program to search element inside linked list
Here is our sample program to search a given node inside LinkedList in Java.  We first build our linked list of numbers and insert 1003 twice to make it a duplicate number. Later we have used the indexOf() and lastIndexOf() method to search for a duplicate element like 1003 and a unique element  1002 inside the linked list. 

From the result, you can see that indexOf() starts the search from the first element and that's why it found 1003 at the 3rd position, which is index 2. On the other hand, lastIndexOf() starts the search from the last element and that's why it found 1003 at 6th position i.e. index 5.

Here is a sample doubly linked list data structure :

How to search nodes inside LinkedList in Java


and here is our example to search duplicate and unique nodes inside LinkedList in Java.

import java.util.LinkedList;

/**
 * Java Program to search an element inside LinkedList.
 * LinkedList doesn't provide random search and 
 * time complexity of searching is O(n)
 * 
 * @author java67
 */

public class LinkedListSearch {

    public static void main(String args[]) {

       LinkedList<Integer> ints = new LinkedList<>();
        ints.add(1001);
        ints.add(1002);
        ints.add(1003);
        ints.add(1004);
        ints.add(1005);
        ints.add(1003);
        
        
        // let's search a duplicate element in linked list
        // for duplicate elements indexOf() and lastIndexOf() will
        // return different indexes.
        System.out.println("First index of 1003 is : " + ints.indexOf(1003));
        System.out.println("Last index of 1003 is : " + ints.lastIndexOf(1003));
        

        // let's search an element which is not appeared twice
        // for unique elements both indexOf() and lastIndexOf() will return
        // same position
        System.out.println("First index of 1002 is : " + ints.indexOf(1002));
        System.out.println("Last index of 1002 is : " + ints.lastIndexOf(1002));

    }

}

Output :
First index of 1003 is : 2
Last index of 1003 is : 5
First index of 1002 is : 1
Last index of 1002 is : 1


From the output, you can also see those duplicate nodes has two different positions returned by indexOf() and lastIndexOf() method while for unique elements both methods return the same index.

Btw, If you are good in Java but lacks data structure and algorithm skills, I strongly suggest reading Data Structures and Algorithm Analysis in Java by Mark A. Wiess. It's a great book to build your foundation on data structure and algorithms using Java programming language.


That's all about how to search an element inside LinkedList in Java. Searching an element requires traversing the list from either end, for example from head to tail or tail to head, which is what indexOf() and lastIndexOf() method does. 

You can use any of these methods to find out the index of a given element in Java, but just remember that if the element is repeated then both methods can return different indices.


If you like this tutorial and interested to learn more about linked list data structure in Java, You can also check the following Java LinkedList tutorials :
How to add elements at the first and last position in LinkedList in Java? [example]
The difference between LinkedList and ArrayList in Java? [answer]
Top 5 data structures from Java Collections framework? [article]
How to implement a linked list in Java? [solution]
How to find the middle node of the linked list in one pass? [solution]
How do you find the length of a singly linked list in Java? [solution]
What is the difference between a linked list and an array in Java? [answer]
How to find the first and last element from LinkedList in Java? [example]
How to check if the linked list contains a loop in Java? [solution]

And, now is the quiz time, what is difference between an ArrayList and a LinkedList in Java? Can you pass an ArrayList to a method which is expecting a LinkedList in Java?


Read more: https://www.java67.com/2015/07/how-to-search-element-inside-linkedlist-java-example.html#ixzz8hj4wwsVb

How to Reverse an Array in place in Java? Example Solution

It's relatively easy to reverse an array if you have the luxury to use another array, but how would you reverse an array if a temporary buffer is not allowed? This is one of the testing array interview questions, which often proved tricky for Java and other beginner Programmers. But, don't worry, I'll tell you how you can solve this problem without losing your cool. Well, you can also reverse an array in place without using an additional buffer. If you know how to access array elements and how to loop over an array in Java using traditional for loop, you can easily solve this problem without using additional space or in-place as described in many Algorithms books and courses, and on Coding interviews.



All you need to do is a loop over the array from start to the middle element and swap the first element to the last, second element to the second last until you reach the middle element. Once you reach the middle element, your array is already sorted, and that too without using any additional space or in-place as asked in this question.

You can even use this algorithm to reverse a String in Java as well. After all, a String is backed by a character array in Java and other programming languages like C and C++.  This is as simple as it could be, but you know, this is also the fastest way to reverse an array in Java.

In general, Data structure and Algorithm questions like ones based upon the array, linked list, binary tree, hash table, and searching/sorting algorithms are very important for programming job interviews and you should have a good knowledge of them.

If you feel that your data structure and algorithm skills are lacking or you want to learn them from scratch, I suggest you join a comprehensive course like Data Structures and Algorithms: Deep Dive Using Java on Udemy, which will teach you all of these and much more useful stuff on Algorithms. It's one of my favorite courses on this topic.





How to Reverse an array in-place in Java
In the last section, I have explained to you the logic or algorithm to reverse an array in place, now is the time to convert that algorithm into pseudo-code and then real code in Java. You will also calculate the time and space complexity of our solution, which is often required in Interviews as well as in the real world to meet your performance SLA.

So, let's see an example of how you can reverse an array of String in Java in place.

This program doesn't use a temporary buffer or another array, instead, it just loops over the array and swaps elements like starting from the first element, it swaps the first to last, second to the second last, until it reaches the middle of the array.

At this point all elements are already swapped, so your array is fully reversed.



This is a simple algorithm and time complexity is O(n/2) or O(n) because it needs to iterate over almost half the elements and perform n/2 swapping as well. The space complexity of the algorithm is O(1) because no matter how big the array is, it requires the same space.

Obviously, all-in-place algorithms have constant space complexity. Btw, if you have trouble understanding Big O notation and how to calculate the time and space complexity of any arbitrary algorithm then I suggest you check out Algorithms and Data Structures - Part 1 and 2 courses on Pluralsight, which will teach you the technique of calculating these numbers.

Fastest way to reverse array in place in Java







Java Program to Reverse an array of String in place
Here is our Java program which implements this algorithm to sort a string array. You can use this algorithm to sort any kind of array like a boolean array, int array, String array, or any custom object array.

This is also the fastest way to reverse an array in Java. It cannot be faster than this because we are only accessing an array which is a constant time operation. The only thing you can optimize is to minimize swapping. Do you know any other way to make this algorithm faster? If yes, then please let us know.

If you want to solve this problem by using recursion instead of the iterative way (using for loop), you can customize your algorithm like below:

package coding;

import java.util.Arrays;

/**
 * Java Program to reverse array in place. Time complexity is O(n)
  *You cannot use additional buffer but one or two variables are fine.
 *
 * @author WINDOWS 8
 *
 */
public class ReverseArrayInPlace {
   
    public static void main(String args[]){
       
        String[] names = {"John", "Jammy", "Luke"};
        System.out.println("original array: " + Arrays.toString(names) );
       
        // reversing array with three elements
        reverse(names);
        System.out.println("reversed array: " + Arrays.toString(names) );
       
        String[] test = {"John"};
        System.out.println("original array: " + Arrays.toString(test) );
       
        // testing reverse array function with array of just one element
        reverse(test);
        System.out.println("reversed array: " + Arrays.toString(test) );
    }

    /**
     * Java Method to reverse String array in place
     *
     * @param array
     */
    public static void reverse(String[] array) {

        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

    }

}

Output :
original array: [John, Jammy, Luke]
reversed array: [Luke, Jammy, John]
original array: [John]
reversed array: [John]

You can see from the output that our program is working fine for an odd number of elements. I haven't tested it for all kinds of input like reversing an array of the even number of elements, but I expect it to work.

Please drop a note, if you find any bug or issue and the program is not working for any input.




That's all about how to reverse an array in place in Java. This is one of the essential coding exercises for Java programmers learning data structure and algorithms. Remember, it's an in-place algorithm hence, the space complexity is O(1) and the time complexity of this solution is O(n). This is also the fastest way to reverse the array in Java.


Read more: https://www.java67.com/2016/01/java-program-to-reverse-array-in-place.html#ixzz8hj57C6Y7

How to reverse a linked list in Java using Recursion and Iteration (Loop) - Example

This is one of the class coding problems from Programming job interviews. It may seem easy to reverse a linked list but when you go around doing the actual task, it's not that easy, especially for first-timers. There are a couple of algorithms exists to reverse a singly linked list in Java, like you can use the three-pointers approach or solve this problem using a Stack, or simply using Recursion without the external stack. As I had pointed out in the earlier post about the linked list, that reversing a linked list is one of the most popular linked list-based data structure interview question. This means, you just can't afford to prepare this one, before going for any programming interview. Despite being so common, It's not easy to solve this problem on the fly.




Many Java programmers struggle to reverse a linked list using both recursion and iteration, which makes this question very useful for filtering programmers who can code and who are not so good with coding.

Indeed, this is one of the confusing algorithms to understand and it's not easy to grasp, especially if you haven't practiced linked list based questions like finding middle node of linked list in one pass or inserting and removing an element from the linked list data structure.



Since Java programmer gets a linked list implementation in the form of the java.util.LinkedList, they never bother to do this exercise by hand. Yes, there are some exceptions but many Java programmer doesn't focus enough on data structure and hand-coding, which is really important to improve your problem-solving skills for the interview.

So, when it comes to design a whole system using Object-oriented analysis and design like implementing a vending machine in Java, sometimes they fail to choose the correct data structure and devising simple algorithms.

Before going for a programming/coding interview, It's absolutely necessary to do as much practice in data structure and algorithm as possible to take advantage of all the knowledge available. You can also join a comprehensive Data Structure and Algorithms course like Data Structures and Algorithms: Deep Dive Using Java on Udemy to fill the gaps in your understanding.

This will improve your thinking ability, problem-solving skill and you will be more comfortable with dealing with the unknown set of problems. This advice is irrespective of whether you are a Java, C++, or Python developer.





Java Program to Reverse a singly linked list using recursion and Iteration
A linked list is a data structure which contains nodes, every node keep data and pointer to the next node. This way linked list grows and can store as many elements as much memory allows it. It's not like an array that requires a contiguous chunk of memory because here node can be stored at any memory location.

This structure means, adding and removing elements in a linked list is easy but searching an element is expensive because you need to traverse the entire list to find the element. It doesn't help even if you know that element is the 5th node or 6th node because you cannot access them by index like an array.

This is the biggest difference between an array and a linked list data structure. In the array, searching the index is O(1) operation but in linked list searching is O(n) operation.

It is said that a picture is worth a thousand word and it is very true in the case of problem-solving and understanding algorithms. If you are a visual learner, I strongly suggest checking out the Visualizing Data Structures and Algorithms in Java course which explains all fundamental data structures and algorithms with animations and interesting diagrams.  Here are a diagram and a flowchart to reverse a singly linked list using recursion.

How to Reverse a linked list in Java using Recursion and Loops

It divides the list into two parts first node and rest of the list, and then link rest to head in reverse order. It then recursively applies the same division until it reaches the last node, at that point whole linked list, is reversed.

Coming back to our code which represents a singly linked list in Java (see the next section), with limited operations. I have already removed some non-relevant code for performing different operations on a linked list like checking if the linked list is cyclic or not, inserting an element at the middle, and removing the element. Since we don't need this code for reversing a linked list, I have simply deleted them for now.



This class is similar to the SinglyLinkedList class, which we have seen in how to implement a linked list in Java using generics (see here), with two more methods for reversing linked list using iteration and recursion.

The reverseRecursively() method reverses the linked list using recursion. It uses the call stack to store data, and once we reached tail, which becomes the new head for the reversed linked list, it starts adding nodes in reverse order. Look at some comments around those methods, which will make you understand the algorithm of reversing the linked list better.

The reverseIteratively() method reverses the linked list using the three-pointers approach and using loops, that's why it is called an iterative solution. It traverses through the linked list and adding nodes at the beginning of the singly linked list in each iteration. It uses three reference variables (pointers) to keep track of previous, current, and next nodes.

Btw, If you are not very familiar with a linked list data structure or want to learn more about linked list data structure, you should first read a good course on data structure and algorithm like Algorithms and Data Structures - Part 1 and 2 on Pluralsight, one of the best course to learn data structure and algorithms.

How to Reverse a linked list in Java using Recursion



Java Class to Represent Singly Linked List
Here is our Java program to solve this problem. As I said, it contains a class to represent a singly linked list and it contains another class that has the main method for testing. That class creates an instance of a linked list and then call relevant methods to reverse the linked list by using iteration and recursion. 

/**
  * Java Class to represent singly linked list for demonstration purpose.
  * In order to understand How to reverse linked list, focus on two methods
  * reverseIteratively() and reverseRecursively().

  * @author Javin Paul
  */
public class SinglyLinkedList {
    private Node head;  // Head is the first node in linked list

    public void append(T data){
        if(head == null){
            head = new Node(data);
            return;
        }
        tail().next = new Node(data);
    }
 
    private Node tail() {
        Node tail = head;
     
        // Find last element of linked list known as tail
        while(tail.next != null){
            tail = tail.next;
        }      
        return tail;
     
    }

 
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while(current != null){
           sb.append(current).append("-->");
           current = current.next;
        }    
        if(sb.length() &gt;=3){
            sb.delete(sb.length() - 3, sb.length()); 
            // to remove --> from last node
        }
     
        return sb.toString();
    }

    /**
      * Reverse linked list using 3 pointers approach in O(n) time
      * It basically creates a new list by reversing direction, and
      * subsequently insert the element at the start of the list.
      */
    public void reverseIteratively() {
        Node current = head;
        Node previous = null;
        Node forward = null;
     
        // traversing linked list until there is no more element
        while(current.next != null){
         
            // Saving reference of next node, since we are changing current node
            forward = current.next;
         
            // Inserting node at start of new list
            current.next = previous;
            previous = current;
         
            // Advancing to next node
            current = forward;
        }
     
        head = current;
        head.next = previous;
    }
 
    /*
     * Reverse a singly linked list using recursion. In recursion Stack is
     * used to store data.   
     * 1. Traverse linked list till we find the tail, 
     * that would be new head for reversed linked list.
     */
    private Node reverseRecursively(Node node){
       Node newHead;
     
       //base case - tail of original linked list
       if((node.next == null)){
           return node;
       }
       newHead = reverseRecursively(node.next);
     
       //reverse the link e.g. C->D->null will be null       
       node.next.next = node;
       node.next = null;    
       return newHead;
    }
  
    public void reverseRecursively(){
        head = reverseRecursively(head);
    }  
 
   private static class Node {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
 
}



Test Class
Here is our test class, which will test both methods of reversing a linked list, reverseIteratively() and reverseRecursively(). You have first created a singly linked list with 6 nodes A-B-C-D-E-F and first reversed them iteratively using 3 points approach and later reversed the same list recursively.

Since the same instance of the singly linked list is reversed two times, you can see in the output that the final list is the same as the original linked list.


/**
  * Java program to test code of reversing singly linked list in Java.
  * This test class test both iterative and recursive solution. Since
  * the same list is first reversed using loops, and then again using recursion.
  * You can see that final output is same as original linked list.

  * @author Javin Paul
  */
public class SinglyLinkedListTest {

    public static void main(String args[]) {
       SinglyLinkedList linkedlist = getDefaultList();
       System.out.println("linked list before reversing : " + linkedlist);     
       linkedlist.reverseIteratively();     
       System.out.println("linked list after reversing : " + linkedlist);
       linkedlist.reverseRecursively();
       System.out.println("linked list after reversing recursively: "
                                   + linkedlist);
           
    }
  
     private static SinglyLinkedList getDefaultList(){
        SinglyLinkedList linkedlist = new SinglyLinkedList();       
        linkedlist.append("A"); linkedlist.append("B"); linkedlist.append("C");
        linkedlist.append("D"); linkedlist.append("E"); linkedlist.append("F");
        return linkedlist;
    }
  
}

Output:
linked list before reversing : A-->B-->C-->D-->E-->F
linked list after reversing : F-->E-->D-->C-->B-->A
linked list after reversing recursively: A-->B-->C-->D-->E-->F


That's all on how to reverse a linked list in Java. We have seen two approaches to reverse a singly linked list, first using Iterations, which involves 3 pointers or reference variable; and second, which reversed linked list using recursion.


Read more: https://javarevisited.blogspot.com/2017/03/how-to-reverse-linked-list-in-java-using-iteration-and-recursion.html#ixzz8hj5TMTxe

How to Find all Pairs in Array of Integers Whose sum is Equal to a Given Number in Java? Solution Example

Practicing coding problems are very important to do well in any programming interview. You should at your best on data structures like an array, linked list, and string to clear any programming interview and believe me, you can not do this in one day or one week. It's rather a long process of learning through coding, and that's where these small coding problems help. Today, we are going to look at another interesting programming question from the array; write a program to find all pairs of integers whose sum is equal to a given number. For example, if the input integer array is {2, 6, 3, 9, 11} and the given sum is 9, the output should be {6,3}.




Sounds simple? maybe, but this exact question has appeared in a technical interview at Amazon, Microsoft, Facebook, and a couple of other Fortune five tech companies in the past. Many of you might already hear about this question and some of you may already know the solution to this problem as well, but it's not enough to know just the answer.

In a programming interview, many things matter apart from the correct solution. For example, the first thing the Interviewer looks at is whether a candidate can ask the right questions or not. So before jumping straight to coding, spare a second or two to think about the problem and clear any doubt you may have.

For example, you can ask the following questions based upon the problem statement given above :
Does the array contain only positive or negative numbers?
What if the same pair repeats twice, should we print it every time?
Is the reverse of the pair is acceptable e.g. can we print both (4,1) and (1,4) if the given sum is 5.
Do we need to print only a distinct pair? does (3, 3) is a valid pair forgiven sum of 6?
How big the array is?
Many programmers are afraid to ask questions instead they like to assume about it, but during coding interviews IMHO it's always better to ask questions. First, it shows that you have not mugged the answer and second it demonstrates that you have the ability to think through a problem, which is a very important quality of any professional programmer.

Now let's go back to the question, for simplicity we can assume that we just need to print a pair of integers once or twice depending upon their occurrence, but the pair has to be distinct, (2,2) or (3, 3) is not valid pair.




3 Solutions to Find Pair Of Integers in Array whose Sum is Given Number
The first solution which comes to my mind is our friend brute-force, naive but genuine. You take one number from the array and then loop through an array and output pairs which are equal to a given sum. You do this for all numbers in the first array, as shown in the following Java program :

1. Brute Force Solution

import java.util.Arrays;

/**
 * Java Program to find pairs on integer array whose sum is equal to k
 * 
 * @author WINDOWS 8
 */
public class ProblemInArray{

    public static void main(String args[]) {
        int[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
        int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
        prettyPrint(numbers, 7);
        prettyPrint(numbersWithDuplicates, 7);
    }

    /**
     * Prints all pair of integer values from given array whose sum is 
     * is equal to given number.
     * complexity of this solution is O(n^2)
     */
    public static void printPairs(int[] array, int sum) {

        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];

                if ((first + second) == sum) {
                    System.out.printf("(%d, %d) %n", first, second);
                }
            }

        }
    }
    /**
     * Utility method to print input and output for better explanation.
     */
    public static void prettyPrint(int[] givenArray, int givenSum){
        System.out.println("Given array : " + Arrays.toString(givenArray));
        System.out.println("Given sum : " + givenSum);
        System.out.println("Integer numbers, whose sum is equal to value : "
                                + givenSum);
        printPairs(givenArray, givenSum);
    }

}

Output:
Given sum : 7
Integer numbers, whose sum is equal to value : 7
(2, 5) 
(4, 3) 
Given array : [2, 4, 3, 5, 6, -2, 4, 7, 8, 9]
Given sum : 7
Integer numbers, whose sum is equal to value : 7
(2, 5) 
(4, 3) 
(3, 4) 
(-2, 9) 

This solution is correct but its time complexity is very hight, O(n^2), which means the Interviewer will surely ask you to improve your answer and come up with a solution whose complexity is either O(1), O(n) or O(nLog(n)). So let's dig deeper to improve this answer. In order to find two numbers in an array whose sum equals a given value, we probably don't need to compare each number with other.

What we can do here is to store all numbers in a hashtable and just check if it contains second value in a pair. For example, if a given sum is 4 and one number in pair is 3, then other must be 1 or -7. Do you remember the first question we asked, if array only contains positive numbers then we don't need to check for negative values in Map. How is this solution better than previous one? It would require less comparisons.

Only N to iterate through array and insert values in a Set because add() and contains() both O(1) operation in the hash table. So total complexity of the solution would be O(N). Here is a Java program that find the pair of values in the array whose sum is equal to k using Hashtable or Set. 

In this program we have also written a utility method to generate random numbers in a given range in Java. You can use this method for testing with random inputs.



By the way, random numbers are only good for demonstration, don't use them in your unit test. One more good thing you can learn from printPairsUsingSet() method is pre validation, checking if inputs are valid to proceed further.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find two elements in an array that sum to k.
 * 
 * @author WINDOWS 8
 */
public class ArraySumUsingSet {

    public static void main(String args[]) {
       prettyPrint(getRandomArray(9), 11);
       prettyPrint(getRandomArray(10), 12);
    }

    /**
     * Given an array of integers finds two elements in the array 
     * whose sum is equal to n.
     * @param numbers
     * @param n
     */
    public static void printPairsUsingSet(int[] numbers, int n){
        if(numbers.length < 2){
            return;
        }        
        Set set = new HashSet(numbers.length);
        
        for(int value : numbers){
            int target = n - value;
            
            // if target number is not in set then add
            if(!set.contains(target)){
                set.add(value);
            }else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }
    }
    
    /*
     * Utility method to find two elements in an array that sum to k.
     */
    public static void prettyPrint(int[] random, int k){
        System.out.println("Random Integer array : " + Arrays.toString(random));
        System.out.println("Sum : " + k);
        System.out.println("pair of numbers from an array whose sum equals "
                                     + k);
        printPairsUsingSet(random, k);
    }
    
    /**
     * Utility method to return random array of Integers in a range of 0 to 15
     */
    public static int[] getRandomArray(int length){
        int[] randoms = new int[length];
        for(int i=0; i<length; i++){
            randoms[i] = (int) (Math.random()*15);
        }
        return randoms;
    }

}

Output:
Random Integer array : [0, 14, 0, 4, 7, 8, 3, 5, 7]
Sum : 11
pair of numbers from an array whose sum equals 11
(7, 4) 
(3, 8) 
(7, 4) 
Random Integer array : [10, 9, 5, 9, 0, 10, 2, 10, 1, 9]
Sum : 12
pair of numbers from an array whose sum equals 12
(2, 10) 

How to find two integers in Java array whose sum equal to given number


One more thing, here we are using HashSet but since HashSet in Java internally uses HashMap, it would not make any difference if use either of those data structure.By the this solution has few constraints, first it would need additional space of order O(n) to store numbers in Hashtable or Set, so you need additional space which could be problem if array is very large (remember the question we asked before writing solution).

For a large array, you need a solution that doesn't require additional space, also known as in-place solution. If the interviewer will ask you how do you find if two values in an array sum to a given value without any additional space, first solution will also not work because it's complexity is too high and it would too long to sort a large array. A solution with complexity e.g. O(n), O(logN) or O(NLongN) should work though.

A more efficient in-place solution would be to sort the array and use two pointers to scan through array from both direction i.e. beginning and end. If sum of both the values are equal to given number then we output the pair and advance them. If the sum of two numbers is less than k then we increase the left pointer, else if the sum is greater than k we decrement the right pointer, until both pointers meet at some part of the array.

The complexity of this solution would be O(NlogN) due to sorting. Remember to use a in-place sorting algorithm like quicksort to sort the array as we don't have additional space. Thankfully, Arrays.sort() method uses a two pivot quicksort algorithm to sort array of primitives.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all pairs on integer array whose sum is equal to k
 * 
 * @author WINDOWS 7
 */
public class PrintArrayPairs {

    public static void main(String args[]) {
       prettyPrint( new int[]{ 12, 14, 17, 15, 19, 20, -11}, 9);
       prettyPrint( new int[]{ 2, 4, 7, 5, 9, 10, -1}, 9);
    }

    /**
     * Given a number finds two numbers from an array so that
     * the sum is equal to that number k.
     * @param numbers
     * @param k
     */
    public static void printPairsUsingTwoPointers(int[] numbers, int k){
        if(numbers.length < 2){
            return;
        }
        Arrays.sort(numbers);
        
        int left = 0; int right = numbers.length -1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == k){
                System.out.printf("(%d, %d) %n", numbers[left],
                                    numbers[right]);
                left = left + 1;
                right = right -1;
                
            }else if(sum < k){
                left = left +1;
                
            }else if (sum > k) {
                right = right -1;
            }
        }
       
    }
    
    /*
     * Utility method to print two elements in an array that sum to k.
     */
    public static void prettyPrint(int[] random, int k){
        System.out.println("input int array : " + Arrays.toString(random));
        System.out.println("All pairs in an array of integers 
                          whose sum is equal to a given value " + k);
        printPairsUsingTwoPointers(random, k);
    }
    
}

Output :
input int array : [12, 14, 17, 15, 19, 20, -11]
All pairs in an array of integers whose sum is equal to a given value 9
(-11, 20) 
input int array : [2, 4, 7, 5, 9, 10, -1]
All pairs in an array of integers whose sum is equal to a given value 9
(-1, 10) 
(2, 7) 
(4, 5) 


That's all on this array based interview question to find all pairs in an array of integers whose sum is equal to a given integer. We have seen three ways to solve this problem starting from the simplest brute-force solution to acceptable O(N) with additional space and O(NLogN) in place.

If anyone like to do some more practice, I would suggest writing JUnit test cases for this problem, given a set of constraints that only a unique pair needs to be printed even if array contains duplicated and find bugs on these solutions.

Alternatively, you can also try to solve its cousin question, given an array of integers check whether there are 3 numbers that sum up to 0 or a given number. Remember more fun is in the journey than reaching the destination :)

Related Data Structure and Algorithm Interview Questions from Javarevisited Blog
Difference between array and linked list data structure? (answer)
Difference between a binary tree and binary search tree? (answer)
How to reverse a linked list in Java using iteration and recursion? (solution)
How to reverse an array in place in Java? (solution)
How to find all permutations of a String in Java? (solution)
How to reverse a String in place in Java? (solution)
How to remove duplicate elements from an array without using Collections? (solution)
Top 5 Books on Data Structure and Algorithms for Java Developers (books)
Top 5 books on Programming/Coding Interviews (list)

Exercises : 
1) Write JUnit tests for this problem and check if each of these solutions passes those tests.
2) Come up with a better solution in terms of time and space complexity?
3) Find boundary conditions on which this solution breaks.


Read more: https://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html#ixzz8hj5m2ZN3

How to Find Missing Number in a Sorted Array in Java [Solved]

Today's coding problem is not very new, it's an age-old classic Programming interview Question. You have a sorted array containing n - 1 unique number starting from 0 to n - 1. There is only one number missing in this range and you need to find that out. I mean you need to write a Java method to find the missing number and print its value in the console. Some of you might have seen this question before, but if you have not been asked this question before, what is the first approach comes into your mind to solve this question? Since only one number is missing, many programmers come up with the approach of iterating over the array, and comparing each element with the expected one like the first element should be 0, the second element should be 1, and so on.



Though this will solve the problem, it will cost you O(n) time. I mean time complexity of your solution would be O(n) which is not good for a big array, like with 100 million entries. What can you do to improve performance?

The key here is that you already have a sorted array, do you think our earlier solution is taking full advantage of this knowledge, well it is but not fully. 

What it is doing is performing a linear search which is costing O(n), but if you do a binary search, which of course needs a sorted array, we can reduce the time taken in the range of O(logN).

Since numbers are in the range from 0 to n - 1 and are sorted, the first number till the missing one should be the same as their indexes. I mean if 0 is not missing, then it must be in the first index, I mean at 0.

If you generalize this, you will find out that if the missing number is k then all numbers less than k are located in an array with indexes the same as their value.

Also, number k + 1 will be located at index k, and number k + 2 will be located at index k + 1. What does this mean? Well, it means that the missing number is the first cell whose value is not the same as its index. So our problem reduces to search in an array to find the first cell, whose value is not the same as its index.

You can easily find out this by using the binary search algorithm in O(logN) time. Our solution implements this logic to find the missing integer in a sorted array in Java. You can use this solution to find the missing number in an array of numbers 1-1000 or 1 -100.



This problem also shows that having a good knowledge of fundamental data structure is essential to solve any coding problems. Therefore, you must spend some time brushing up your Data Structure skills before you go for an interview. If you need a course, I highly recommend Data Structure and  Algorithms in Java: Deep Dive on Udemy. It's both comprehensive and enjoyable and also very affordable. You can buy it for just $10 on Udemy sale.






How to Find Missing Number in Sorted Array- Solution 
Here is our complete solution to this problem. As discussed in the first paragraph, the solution is based upon a binary search algorithm and that's why its complexity is in logarithmic order. If you asked this question in the interview, you must write production-quality code, which means is handling invalid input and boundary conditions.

In our method, we are checking whether the array is not null and empty before proceeding further. If you are not familiar with the binary search algorithm then this diagram will help you with how does it work. In binary search, instead of starting from the front, we start from the middle element.

If the middle element is greater than the expected number is on the left-hand side of a middle element (lower array), otherwise, it is on the right-hand side (higher array). So in each iteration, we end up reducing our problem set by half.



So in the start, if you have 16 elements in the array, next iteration you only need to search in 8 elements and subsequently 4 and 2, this is how we get O(logN) complexity. This problem also shows that knowledge of coding patterns is very important for coding interviews.

If you know the pattern you can solve many unseen problems and that's why you should spend some time solving coding problems to build that pattern recognition logic in your mind. A course like Grokking the Coding Interview: Patterns for Coding Questions is really a godsend course for someone who wants to master these patterns. It will teach you 15 popular coding patterns to interview questions which means you can tackle most of the unseen problems during interviews.

Java Program to find missing number in a sorted integer array in Java




Java Program to find the missing number in a sorted Integer array
And, here is our code example to find the missing integer in a sorted array or series.

import java.util.Arrays;
/**
 * Java Program to find the missing number in a sorted array 
 * with integers in range 0 to n -1
 *
 * @author Javin Paul
 */
public class MissingNumberFinder {

    public static void main(String args[]) {

        System.out.println("Test #1 : Missing number in sorted array ");
        int[] input = new int[]{1, 2, 3, 4, 6};
        int missing = missingNumberFromSortedArray(input);
        System.out.println("Missing number from array : " 
                  + Arrays.toString(input) + " is : " + missing);

    }


    public static int missingNumberFromSortedArray(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            throw new IllegalArgumentException("Null or Empty array not permitted");
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = (right + left) >> 1;
            if (numbers[middle] != middle) {
                if (middle == 0 || numbers[middle - 1] == middle - 1) {
                    return middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        throw new RuntimeException("No missing number");
    }
}

Output:
Test #1 : Missing number in sorted array
Missing number from array : [1, 2, 3, 4, 6] is : 0


Read more: https://www.java67.com/2014/12/how-to-find-missing-number-in-sorted.html#ixzz8hj69HbwY

[Solved] 2 Ways to Find Duplicate Elements in a given Array in Java - Example

Hello guys, today, you will learn how to solve another popular coding problem. You have given an array of objects, which could be an array of integers and or an array of Strings or any object which implements the Comparable interface. How would you find duplicate elements from an array? Can you solve this problem in O(n) complexity? This is actually one of the frequently asked coding questions from Java interviews. There are multiple ways to solve this problem, and you will learn two popular ways here, first the brute force way, which involves comparing each element with every other element, and other which uses a hash table-like data structure to reduce the time complexity of the problem from quadratic to linear, of course by trading off some space complexity.



This also shows how by using a suitable data structure, you can come up with a better algorithm to solve a problem. That's why a good knowledge of Data Structure and Algorithms are very important for all programmers.

If you are new to the programming world or want to refresh your knowledge about essential data structures like an array, string, linked list, hash table, binary tree, balanced tree, stack, queue, priority queue, etc then I suggest you go through a comprehensive data structure and algorithms course.

According to Data Structures and Algorithms: Deep Dive Using Java course  learning all essential data structures and algorithms like searching, sorting, and graph-based algorithms can make you better developer and also help in cracking coding interviews. 






How to find duplicates in a given array on O(n^2)
In the first solution, we compare each element of the array to every other element. If it matches then its duplicate and if it doesn't, then there are no duplicates. This is also known as a brute force algorithm to find duplicate objects from Java array.

The time complexity of this problem is O(n^2) or quadratic. When you give this solution to your interviewer, he will surely ask you to come up with O(n) time complexity algorithm, which we will see next.



Here is the code to find duplicate elements using a brute force algorithm in Java:
In this program, instead of printing the duplicate elements, we have stored them in a Set and returned from the method, but if the interviewer doesn't ask you to return duplicates, then you can simply print them into the console as I have done in next solution.

public static Set<Integer> findDuplicates(int[] input) {
        Set<Integer> duplicates = new HashSet<Integer>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    // duplicate element found
                    duplicates.add(input[i]);
                    break;
                }
            }
        }

        return duplicates;
    }


If you are preparing for programming job interviews, then I also suggest you take a look at the Grokking the Coding Interview: Patterns for Coding Questions course on Educative, which contains many popular patterns for solving coding problems. This means you don't need to solve 100+ Leedcode problems but just need to learn a few patterns which are applicable to many programming problems.
How to find duplicate elements in an Array - Java





How to Find duplicates in array in O(n) time Complexity
The second solution demonstrates how you can use a suitable data structure to come up with a better algorithm to solve the same problem. If you know, in Java, the Set interface doesn't allow duplicates, and it's based upon hash table data structure, so insertion takes O(1) time in the average case.

By using HashSet, a general-purpose Set implementation, we can find duplicates in O(n) time. All you need to do is iterate over an array using advanced for loop and insert every element into HashSet. Since it allows only unique elements, add() method will fail and return false when you try to add duplicates.



Bingo, you have to find the duplicate element, just print them off to console, as shown in the following program:

public static <T extends Comparable<T>> void getDuplicates(T[] array) {
        Set<T> dupes = new HashSet<T>();
        for (T i : array) {
            if (!dupes.add(i)) {
                System.out.println("Duplicate element in array is : " + i);
            }
        }

    }
This solution also demonstrates how you can use Generics to write type-safe code in Java. This method will work on any type of Java array, like Array with Integer, Array with String or any object which implements Comparable interface, but will not work with a primitive array because they are not objects in Java.

If you are preparing for programming job interviews, then I also suggest you take a look at the Cracking the Coding Interview book by Gayle McDowell, which contains 189 programming questions and solutions, good enough to do well on any programming job interviews like Java, C++, Python or Ruby.

How to find duplicate elements in Java array coding



Java Program to find duplicate elements in Java using Generics
Here is the Java program to combine both solutions, you can try running this solution on Eclipse IDE and see how it works. You can also write the JUnit test to see our solution work in all cases, especially corner cases like an empty array, array with null, etc.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static java.lang.System.*;

/**
 * Java Program to find duplicate elements in an array. In this program, you
 * will learn two solution to find duplicate elements in integer array e.g.
 * brute force, by using HashSet data structure.
 * 
 * @author java67
 */

public class DuplicatesFromArray{

    public static void main(String args[]) {
        int[] withDuplicates = { 1, 2, 3, 1, 2, 3, 4, 5, 3, 6 };
        Set<Integer> duplicates = findDuplicates(withDuplicates);
        out.println("input array is : " + Arrays.toString(withDuplicates));
        out.println("Duplicate elements found in array are : " + duplicates);

        // now calling our generic method to find duplicates        
        String[] myArray = { "ab", "cd", "ab", "de", "cd" };
        out.println("input string array is : " + Arrays.toString(myArray));
        getDuplicates(myArray);
    }

    /**
     * Complexity of this solution is O(n^2)
     * 
     * @param input
     * @return
     */
    public static Set<Integer> findDuplicates(int[] input) {
        Set<Integer> duplicates = new HashSet<Integer>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    // duplicate element found
                    duplicates.add(input[i]);
                    break;
                }
            }
        }

        return duplicates;
    }

    /**
     * Generic method to find duplicates in array. Complexity of this method is
     * O(n) because we are using HashSet data structure.
     * 
     * @param array
     * @return
     */
    public static <T extends Comparable<T>> void getDuplicates(T[] array) {
        Set<T> dupes = new HashSet<T>();
        for (T i : array) {
            if (!dupes.add(i)) {
                System.out.println("Duplicate element in array is : " + i);
            }
        }

    }

}

Output :
input array is : [1, 2, 3, 1, 2, 3, 4, 5, 3, 6]
Duplicate elements found in array are : [1, 2, 3]
input string array is : [ab, cd, ab, de, cd]
Duplicate element in array is : ab
Duplicate element in array is : cd

That's all about how to find duplicate elements in an array. You have now learned two ways to solve this problem in Java. The first solution is the brute force algorithm, which is demonstrated by finding duplicate elements on integer array, but you can use the logic to find a duplicate on any kind of array. The second solution uses the HashSet data structure to reduce the time complexity from O(n^2) to O(n), and it also shows you can write generic methods to find duplicates on any object array.


Read more: https://www.java67.com/2015/10/2-ways-to-find-duplicate-elements-in-java-array.html#ixzz8hj6NmF90

How to Check if Given Number is Prime in Java - With Example

Hello guys, today, we are going to discuss one of the most common programming exercises for beginners is, write a program to check if a given number is prime or not? There are many ways to check if a number is prime or not, but the most common of them is the trial division, which is what we will see in this tutorial. In my opinion, these kinds of programs are their first steps towards algorithmic understanding. You first come up with a solution, which is driven by the fact that prime numbers are natural numbers, that are not divisible by any positive number other than 1 and themselves. Then, you write a for loop to check every number, starting from 1 to a given number, to see if the given number is divisible by any positive number or not. This leads you to the solution.



Then you find some more the fact that there is no need to check till N-1, where N is the number we are checking for primeness, and checking till the square root of N is enough. This reduces a lot of time, especially while checking a large number is prime or not.

Further, you come to know that if it's not divisible by 2, then there is no need to checking for any other even number, and you increment the counter by 2 instead of 1. So in a way, you learn how to optimize your solution by taking advantage of the facts available.

After this, you can try something like the Fibonacci series or maybe finding factorial of a number in Java to do some more practice on programming. This will not only teach you language basics like loops, control statements like if-else, use of arithmetic, and relational operator but also helps to develop programming logic.

By the way, you can even take this problem of checking if a number is prime or not, to the next level, by trying to implement different algorithms for finding primes like the sieve of Atkin or sieve of Eratosthenes. In fact, in programming challenges, you often need to build your prime number cache up to a specific number to progress further in finding a solution.

Btw, if you need to refresh your Data Structure and algorithm skills to solve those problems, then I highly recommend checking out Data Structures and Algorithms: Deep Dive Using Java course on Udemy. It's a hands-on course and covers all essential data structures. It's also very affordable, and you can get in just $10 on Udemy flash sales, which happen every now and then.




How to Find if a Given Integer Number is a Prime Number or Not?
Now, we'll understand our Java program to see if a given integer number is prime or not. As I said, a number is called a prime number if it's only divisible by 1 or itself, which means the prime number doesn't have any positive divisor other than itself. There are many ways to check if the number is prime or not or generating a list of primes.



The most straightforward of them is known as trial division, which is a natural way of finding prime. In the trial division, you divide. It consists of testing whether n is a multiple of any integer between 2 and sqrt{n}.

In this program, I have presented three solutions or methods to check if the number is prime. The first solution is the implementation of the trial division, where we are checking from 2 to sqrt(n); we are using java.lang.Math class for calculating the square root.

Since this function returns double, we need to cast the result back into an integer. Our second method of checking if a number is prime or not is a little bit optimized than this as it doesn't check division by even numbers other than two.   The third method is most optimized for all three methods of prime number checking.



Btw, if you are also preparing for coding interviews or improving your algorithmic skill then I suggest you take a look at this wonderful course from Educative, Grokking the Coding Interview: Patterns for Coding Questions.

This is one of its kind courses that will not just teach you to solve the problem but also the pattern behind them, which means you can remember those patterns and apply them to many problems. A great way to build your coding and problem-solving skills.

How to check if Given number is prime in Java




Prime Number Checker in Java
And, here is the complete Java program to check if a given number is prime or not. This question is also asked on written tests and interviews as to how to print prime numbers from 1 to 100  or finding the prime factor of a number in Java.  And,  there is another exercise for you to do after this is checking if a number is Armstrong's number or not.


import java.util.Scanner;
/**
 * Java Program to check if a number is Prime or Not. This program accepts a
 * number from command prompt and check if it is prime or not. 
 *
 * @author  http://java67.blogspot.com
 */
public class PrimeTester {

    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int number = Integer.MAX_VALUE;
        System.out.println("Enter number to check if prime or not ");
        while (number != 0) {
            number = scnr.nextInt();
            System.out.printf("Does %d is prime? %s %s  %s %n", number,
                    isPrime(number), isPrimeOrNot(number), isPrimeNumber(number));
        }
    }


    /*
     * Java method to check if an integer number is prime or not.
     * @return true if number is prime, else false
     */
    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }


    /*
     * Second version of isPrimeNumber method, with improvement like not
     * checking for division by even number, if its not divisible by 2.
     */
    public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    /*
     * Third way to check if a number is prime or not.
     */
    public static String isPrimeOrNot(int num) {
        if (num < 0) {
            return "not valid";
        }
        if (num == 0 || num == 1) {
            return "not prime";
        }
        if (num == 2 || num == 3) {
            return "prime number";
        }
        if ((num * num - 1) % 24 == 0) {
            return "prime";
        } else {
            return "not prime";
        }
    }
}

Output
Enter number to check if prime or not
2? Does 2 is prime? true prime number  true
3? Does 3 is prime? true prime number  true
4? Does 4 is prime? false not prime  false
5? Does 5 is prime? true prime  true
6? Does 6 is prime? false not prime  false
7? Does 7 is prime? true prime  true
17? Does 17 is prime? true prime  true
21? Does 21 is prime? false not prime  false
131? Does 131 is prime? true prime  true
139? Does 139 is prime? true prime  true


That's all in this program about how to check if a number is prime or not. The number must be an integer, as the concept of prime is only for natural numbers and not for floating-point numbers. As I said, there are a couple of more algorithms for checking if a number is prime or not, and some of the algorithms are optimized for finding prime numbers.

It is imperative for every programmer to know at least one fast way of finding a prime number, as this trial division is not fast enough for real-world problems. I suggest exploring the sieve of Atkin and the sieve of Eratosthenes's way of finding prime numbers.


Read more: https://www.java67.com/2014/01/how-to-check-if-given-number-is-prime.html#ixzz8hj6oZy7t

How to Find Highest Repeating Word from a File in Java [Word Count Solution]

Hello guys, if you are looking for a Java program to print the word and their count from a given file then you have come to the right place. Earlier, I have shared 100+ Data Strucutre and Algorithms Problems from interviews and in this article, I will show you how to find worlds and their count from a given file in Java. How to find the word and their count from a text file is another frequently asked coding question from Java interviews. The logic to solve this problem is similar to what we have seen in how to find duplicate words in a String, where we iterate through string and store word and their count on a hash table and increment them whenever we encounter the same word. 

In the first step, you need to build a word Map by reading the contents of a Text File. This Map should contain words as a key and their count as value. Once you have this Map ready, you can simply sort the Map based upon values. 




Btw, If you don't know how to sort a Map on values, see this tutorial first. It will teach you how to sort  HashMap on values in Java.

Now getting key and value sorted should be easy, but remember HashMap doesn't maintain order, so you need to use a List to keep the entry in sorted order.

Once you got this list, you can simply loop over the list and print each key and value from the entry. This way, you can also create a table of words and their count in decreasing order.  This problem is sometimes also asked to print all words and their count in tabular format.

By the way, if you are new to Java Programming and not familiar with essential Data Structure and their implementation on Collection Farmwork then I highly recommend you to join a comprehensive Java course like The Complete Java Masterclass by Tim Buchalaka and his team on Udemy. This 80+ hour course is the most comprehensive and up-to-date course to learn Java online.







How to find the highest repeated word from a File in Java
Here is the Java program to find the duplicate word which has occurred a maximum number of times in a file. You can also print the frequency of words from highest to lowest because you have the Map, which contains the word and their count in sorted order. All you need to do is iterate over each entry of Map and print the keys and values.

The most important part of this solution is sorting all entries. Since Map.Entry doesn't implement the Comparable interface, we need to write our own custom Comparator to sort the entries.

If you look at my implementation, I am comparing entries on their values because that's what we want. Many programmers say that why not use the LinkedHashMap class? but remember, the LinkedHashMap class keeps the keys in sorted order, not the values. So you need this special Comparator to compare values and store them in List.

Here is one approach to solving this problem using the map-reduce technique. If you are not familiar with map-reduce and functional programming in Java then I highly recommend you to join Learn Java Functional Programming with Lambdas & Streams course on Udemy. It's a great course to learn essential Functional Programming concepts and methods like map, flatmap, reduce, and filter in Java. 

How to find word and their count from a file in Java



Java Program to Print word and their counts from a File
Here is our complete Java program to find and print the world their count from a given file. It also prints the world with the highest and lowest occurrence characters from the file as asked in given problem. 
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
/**
 * Java program to find count of repeated words in a file.
 *
 * @author
 */
public class Problem {

    public static void main(String args[]) {
        Map<String, Integer> wordMap = buildWordMap("C:/temp/words.txt");
        List<Entry<String, Integer>> list 
                  = sortByValueInDecreasingOrder(wordMap);
        System.out.println("List of repeated word from file and their count");
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " => "
                            + entry.getValue());
            }
        }
    }

    public static Map<String, Integer> buildWordMap(String fileName) {
        // Using diamond operator for clean code
        Map<String, Integer> wordMap = new HashMap<>();
        // Using try-with-resource statement for automatic resource management
        try (FileInputStream fis = new FileInputStream(fileName);
                DataInputStream dis = new DataInputStream(fis);
                BufferedReader br = new BufferedReader(
                                     new InputStreamReader(dis))) {
            // words are separated by whitespace
            Pattern pattern = Pattern.compile("\\s+");
            String line = null;
            while ((line = br.readLine()) != null) {
                // do this if case sensitivity is not required i.e. Java = java
                line = line.toLowerCase();
                String[] words = pattern.split(line);
                for (String word : words) {
                    if (wordMap.containsKey(word)) {
                        wordMap.put(word, (wordMap.get(word) + 1));
                    } else {
                        wordMap.put(word, 1);
                    }
                }
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return wordMap;
    }

    public static List<Entry<String, Integer>> sortByValueInDecreasingOrder(
                                 Map<String, Integer> wordMap) {
        Set<Entry<String, Integer>> entries = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, 
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }
}

Output:
List of repeated word from file and their count
its => 2
of => 2
programming => 2
java => 2
language => 2


Tips for Solving Highest Repeating Characters Count Problem and Things to Remember
If your writing code on interviews make sure they are production quality code, which means you must handle as many errors as possible, you must write unit tests, you must comment on the code and you do proper resource management. Here are a couple of more points to remember:



1. Close files and streams once you are through with it, see this tutorial to learn the right way to close the stream. If you are in Java 7, just use the try-with-resource statement.

2. Since the size of the file is not specified, the interviewer may grill you on cases like What happens if the file is large? With a large file, your program will run out of memory and throw java.lang.OutOfMemory: Java Heap space.

One solution for this is to do this task in chunks like first read 20% content, find the maximum repeated word on that, then read the next 20% content, and find repeated maximum by taking the previous maximum into consideration. This way, you don't need to store all words in memory and you can process any arbitrary length file.

3. Always use Generics for type safety. It will ensure that your program is correct at compile time rather than throwing Type related exceptions at runtime. 


That's all on how to find repeated words from a file and print their count. You can apply the same technique to find duplicate words in a String. Since now you have a sorted list of words and their count, you can also find the maximum, minimum, or repeated words which has counted more than the specified number.


Read more: https://www.java67.com/2015/10/java-program-to-find-repeated-words-and-count.html#ixzz8hj7Bglw2

How to Remove Duplicates from ArrayList in Java [Example]

ArrayList is the most popular implementation of the List interface from Java's Collection framework, but it allows duplicates. Though there is another collection called Set which is primarily designed to store unique elements, there are situations when you receive a List like ArrayList in your code and you need to ensure that it doesn't contain any duplicate before processing. Since with ArrayList you cannot guarantee uniqueness, there is no other choice but to remove repeated elements from ArrayList. 

There are multiple ways to do this, you can follow the approach we used for removing duplicates from array in Java, where we loop through array and inserting each element in a Set, which ensures that we discard duplicate because Set doesn't allow them to insert, or you can also use remove method of ArrayList to get rid of them, once you found that those are duplicates.



Btw, the simplest approach to remove repeated objects from ArrayList is to copy them to a Set e.g. HashSet and then copy it back to ArrayList. This will remove all duplicates without writing any more code.



One thing to noted is that, if original order of elements in ArrayList is important for you, as List maintains insertion order, you should use LinkedHashSet because HashSet doesn't provide any ordering guarantee.

If you are using deleting duplicates while iterating, make sure you use Iterator's remove() method and not the ArrayList one to avoid ConcurrentModificationException.  In this tutorial we will see this approach to remove duplicates.





Java Program to Remove duplicates from ArrayList
Here is our sample program to learn how to remove duplicates from ArrayList. The steps followed in the below example are:
Copying all the elements of ArrayList to LinkedHashSet. Why we choose LinkedHashSet? Because it removes duplicates and maintains the insertion order.
Emptying the ArrayList, you can use clear() method to remove all elements of ArrayList and start fresh. 
Copying all the elements of LinkedHashSet (non-duplicate elements) to the ArrayList. 

Please find below the complete code :

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * Java Program to remove repeated elements from ArrayList in Java.
 *
 * @author WINDOWS 8
 */

public class ArrayListDuplicateDemo{
 
   
    public static void main(String args[]){
   
        // creating ArrayList with duplicate elements
        List<Integer> primes = new ArrayList<Integer>();
       
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);  //duplicate
        primes.add(7);
        primes.add(11);
       
        // let's print arraylist with duplicate
        System.out.println("list of prime numbers : " + primes);
       
        // Now let's remove duplicate element without affecting order
        // LinkedHashSet will guaranteed the order and since it's set
        // it will not allow us to insert duplicates.
        // repeated elements will automatically filtered.
       
        Set<Integer> primesWithoutDuplicates
                   = new LinkedHashSet<Integer>(primes);
       
        // now let's clear the ArrayList so that we can 
        // copy all elements from LinkedHashSet
        primes.clear();
       
        // copying elements but without any duplicates
        primes.addAll(primesWithoutDuplicates);
       
        System.out.println("list of primes without duplicates : " + primes);
       
    }
 
}

Output
list of prime numbers : [2, 3, 5, 7, 7, 11]
list of primes without duplicates : [2, 3, 5, 7, 11]


In this example, you can see we have created an ArrayList and added numbers into it, all prime numbers. We added '7' twice, so that it become duplicate. Now we print the ArrayList and you can see that it contains number 7 twice.

How to remove duplicates from ArrayList in Java


After that we created a LinkedHashSet from our ArrayList, clear our original ArrayList and then added all elements from set to the list. This time we should not have any duplicates because Set doesn't allow them and they should have filtered when elements copied from ArrayList to HashSet by Java. This is proved by printing the ArrayList again, now it doesn't contain 7 twice, but only once.

That's all about how to remove duplicates from ArrayList in Java. Though there are multiple ways to do this, I think using LinkedHashSet is the simplest one because its simple and also preserve the order of elements.


Read more: https://www.java67.com/2015/03/how-to-remove-duplicates-from-arraylist.html#ixzz8hj7cnc00

How to check is given String is a Palindrome in Java using Recursion

In this tutorial, you will learn how to check if a string is a palindrome in Java using Recursion. A String is nothing but a collection of characters like "Java," and String literals are encoded in double-quotes in Java. A String is said to be a palindrome if the reverse of String is equal to itself like "aba" is a palindrome because the opposite of "aba" is also "aba", but "abc" is not a palindrome because the reverse of "abc" is "cba" which is not equal. Recursion means solving a problem by writing a function which calls itself. In order to check if String is a palindrome in Java, we need a function that can reverse the String.



Once you have the original and reversed String, all you need to do is check if they are equal to each other or not. If they are equal then String is palindrome or not. You can write this reverse() function by using either for loop or by using Recursion.



If you remember, I already shared the logic of reversing String in my earlier post,  how to reverse String in Java using Iteration and Recursion. Here we will use the same logic to check if String is palindrome or not.

By the way, if you are preparing for coding interviews and looking for some coding problem to get hands-on practice, I suggest you take a look at Data Structures and Algorithms: Deep Dive Using Java by Tim Buchalaka and his team on Udemy.

This is a beautiful course, which contains lots of natural and medium difficulty level coding problems, which will not only help you to prepare for an interview but also develop your programming logic and Data Structure, and Algorithms skills. It's also very affordable and you can buy in just $10 on many Udemy sales which happen every now and then.





Java Program to check if String is Palindrome Using Recursion
Here is our Java program, which checks if a given String is palindrome or not. The program is simple, and here are steps to find palindrome String :

1) Reverse the given String
2) Check if the reverse of String is equal to itself; if yes, then given String is a palindrome.

In our solution, we have a static method isPalindromeString(String text), which accepts a String. It then calls the reverse(String text) method to reverse this String. This method uses Recursion to reverse String. This function first checks if the given String is null or empty, if yes then it returns the same String because they don't require to be reversed.




After this validation, it extracts the last character of String and passes rest or String using substring() method to this method itself, hence the recursive solution. The validation also servers as base case because, after every step, String keeps getting reduced, and eventually it will become empty, there your function will stop Recursion and will use String concatenation to concatenate all character in reverse order. Finally, this method returns the reverse of String.

When the call to reverse() returns back, isPalindromeString(String text) uses the equals() method to check if the reverse of String is equal to the original String or not, if yes then it returns true, which also means String is a palindrome.

As I said if you are looking for more coding-based problems you can also always check the Grokking the Coding Interview: Patterns for Coding Questions course on Educative, one of the great courses to build coding sense and pattern recognition required to clear programming interviews.

How to check if String is palindrome in Java using recursion


How to check if String is Palindrome in Java using Recursion
Here is the complete Java program to check if the given String is palindrome or not. In this program, we have used Recursion to first reverse the String and then check if both original and reversed String is the same or not.

package test;

/**
 * Java program to show you how to check if a String is palindrome or not.
 * An String is said to be palindrome if it is equal to itself after reversing.
 * In this program, you will learn how to check 
 * if a string is a palindrome in java using recursion
 * and for loop both. 
 *
 * @author Javin
 */
public class PalindromeTest {

   
    public static void main(String args[]) {
        System.out.println("Is aaa palindrom?: " 
                             + isPalindromString("aaa"));
        System.out.println("Is abc palindrom?: " 
                             + isPalindromString("abc"));
       
        System.out.println("Is bbbb palindrom?: "
                             + isPalindromString("bbbb"));
        System.out.println("Is defg palindrom?: " 
                             + isPalindromString("defg"));
     
       
    }

    /**
     * Java method to check if given String is Palindrome
     * @param text
     * @return true if text is palindrome, otherwise false
     */
    public static boolean isPalindromString(String text){
       String reverse = reverse(text);
       if(text.equals(reverse)){
           return true;
       }
     
       return false;
    }
   
    /**
     * Java method to reverse String using recursion
     * @param input
     * @return reversed String of input
     */
    public static String reverse(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
       
        return input.charAt(input.length()- 1) 
                   + reverse(input.substring(0, input.length() - 1));
    }
   
}

Output
Is aaa palindrom?: true
Is abc palindrom?: false
Is bbbb palindrom?: true
Is defg palindrom?: false


And,  if you are looking for more coding-based problems you can also always check the Cracking the Coding Interview: 150 Programming Questions and Solutions, one of the great books to build the coding sense required to clear programming interviews.

How to find if a String is Palindrome in Java



How to check if String is Palindrome using StringBuffer and For loop
You can also solve this problem by retrieving the character array from String using the toCharArray() and using a for loop and StringBuffer. All you need to do is iterate through the character array from end to start i.e. from the last index to the first index and append those characters into the StringBuffer object. Once this is done, just call the toString() method of StringBuffer, it's your reversed String.

Here is how your code will look like :


import java.util.Scanner;

/**
 * How to check if String is palindrome in Java 
 * using StringBuffer and for loop.
 * 
 * @author java67
 */

public class Palindrome{

    public static void main(String args[]) {
       
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a String");
        String input = reader.nextLine();
        
        System.out.printf("Is %s a palindrome? : %b %n", 
                              input, isPalindrome(input));
        
        
        System.out.println("Please enter another String");
        input = reader.nextLine();
        
        System.out.printf("Is %s a palindrome? : %b %n", 
                              input, isPalindrome(input));
        
        reader.close();
        

    }

    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(array[i]);
        }

        String reverseOfString = sb.toString();

        return input.equals(reverseOfString);
    }

}


That's all about how to check for palindrome in Java. You have learned how to find if a given String is palindrome using Recursion as well by using StringBuffer and for a loop. More importantly, you have done it by developing your own logic and writing your own code i.e. not taking help from a third-party library.


Read more: https://www.java67.com/2015/06/how-to-check-is-string-is-palindrome-in.html#ixzz8hj8Osdzx

How to Find Duplicate Characters in String [Java Coding Problems]

Hello guys, today's programming exercise is to write a program to find repeated characters in a String. For example, if given input to your program is "Java", it should print all duplicates characters, i.e. characters appear more than once in String and their count like a = 2 because of character 'a' has appeared twice in String "Java". This is also a very popular coding question on the various level of Java interviews and written tests, where you need to write code. On the difficulty level, this question is at par with the prime numbers or Fibonacci series, which are also very popular on junior level Java programming interviews and it's expected from every programmer to know how to solve them.



I personally like this exercise because it gives beginners an opportunity to familiarize themselves with the concept of Map data structure, which allows you to store mappings in the form of key and value.

Since Map and Hash table data structure is heavily used in any enterprise Java application, good knowledge of this data structure is highly desirable among any level of Java programmers.

By the way, there are a couple of variants of this problem, which you may want to look at before going for an interview.

Sometimes an interviewer will ask you to read a file and print all duplicate characters and their count, core logic will remain the same, all you need to do is demonstrate how much you know about File IO in Java, like streaming file if it's very large rather than reading the whole file in memory.

Btw, a basic knowledge of data structure and algorithms is needed and if you need to brush up then do so. If you need a resource, I highly recommend checking out Data Structures and Algorithms: Deep Dive Using Java course on Udemy. It's a hands-on course and covers all essential data structures. It's also very affordable and you can get in just $10 on Udemy flash sales which happens every now and then.





Java Program to find Repeated Characters of String [Solution]
The standard way to solve this problem is to get the character array from String, iterate through that and build a Map with character and their count. Then iterate through that Map and print characters which have appeared more than once. So you actually need two loops to do the job, the first loop to build the map and the second loop to print characters and counts.

If you look at the below example, there is only one static method called the printDuplicateCharacters(), which does both these jobs. We first got the character array from String by calling toCharArray().

Next, we are using HashMap to store characters and their count. We use the containsKey() method to check if the key, which is a character that already exists or not already exists we get the old count from HashMap by calling the get() method and store it back after incrementing it by 1.




Once we build our Map with each character and count, the next task is to loop through Map and check each entry, if the count, which is the value of Entry is greater than 1, then that character has occurred more than once. You can now print duplicate characters or do whatever you want with them.

By the way, if you are preparing for coding interviews then I highly recommend you to join Grokking the Coding Interview: Patterns for Coding Questions course on Educative. This is an interactive, text-based coding course to learn 15 essential coding patterns like sliding window, merge interval, fast and slow pointers, etc which can be used to solve 100+ coding problems, and you can get it just for $14.9 per month membership. 

How to Find Duplicate Characters in String


And, here is the complete Java program to find duplicate characters in a given String. 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
* Java Program to find duplicate characters in String.
*
*
* @author http://java67.blogspot.com
*/
public class FindDuplicateCharacters{

    public static void main(String args[]) {
        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");
    }

    /*
     * Find all duplicate characters in a String and print each of them.
     */
    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();

        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }

}

Output
List of duplicate characters in String 'Programming'
g : 2
r : 2
m : 2
List of duplicate characters in String 'Combination'
n : 2
o : 2
i : 2
List of duplicate characters in String 'Java'


Read more: https://www.java67.com/2014/03/how-to-find-duplicate-characters-in-String-Java-program.html#ixzz8hj8lDMfS

How to find Factorial in Java using Recursion and Iteration - Example Tutorial

Hello guys, if you are looking for a Java program to calculate factorial with and without recursion then you have come to the right place. Factorial is a common programming exercise that is great to learn to code and how to program. When I teach Java to new people, I often start with coding problems like prime numbers, Fibonacci series, and factorial because they help you to develop a coding sense and teach you how to write a program initially. In order to calculate factorial, you just need to know the factorial concepts from Mathematics, and rest I will explain this simple Java programming tutorial. 

If you come from a Maths background then you know that the factorial of a number is number*(factorial of number -1), once you know that, your next task is how to convert that formula into a computer program and that's what you will learn in this article. 



We will use Java programming constructs like variables, operators, methods, and algorithms like recursion and loops to calculate the factorial of a number in Java, but before that let's get the problem statement right. 

Problem: Write a Java program to calculate the factorial of a given number in Java, using both recursion and iteration.

Solution:  We will use this formula to calculate factorial in this  Java tutorial. Since factorial is a naturally recursive operation, it makes sense to first use recursion to solve this problem which is great and we'll also do the same but just remember that it's not always the best way to solve problems in the real world. 

Iteration provides a more robust way, but don't worry you will learn how to calculate factorial with and without recursion in Java.


By the way, the factorial of numbers grows very quickly and even the largest integral data type in Java long is not able to hold factorial of anything or above 50. In such cases, you can use BigInteger or long or data type which has theoretically no limit and can be used to represent very large integral numbers.




How to Calculate Factorial in Java? Example Tutorial
Without wasting any more of your time, let's jump into the two solutions we can use to calculate factorials in Java. In the first solution, we will use recursion, where a method calls itself for repetition, and in the second solution, we will use loops like for and while loop to achieve repetition. This is also known as iteration because you iterate or perform the same task again and again. 

Solution 1: Factorial using recursion
In order to create a recursive solution, you would need a base case where the program terminates and repetition stops.  In this problem, the base case is factorial of 1, which is 1 so when your function calls factorial(1) you can simply return 1 without doing any calculation. 

And, if the given number is greater than 1, we keep applying the factorial formula and recursive calling the same factorial with n - 1 as shown below :
 public static long factorial(int number){        
        //base case - factorial of 0 or 1 is 1
        if(number <=1){
            return 1;
        }        
        return number*factorial(number - 1);
    }
Once input becomes 1 the method stopped recursive call and return 1. From there onward method stack started to roll down and finally factorial of a number is calculated and returned. 



Solution 2: Factorial without Recursion
As I said instead of using recursion and calling the factorial method again you can also use for loop to calculate factorial because !n = n*(n-1)*(n-2).....*1, which can easily be implemented using the loop as shown below :
public static long factorial(long input){
        long factorial = 1L;
        for(long i= input; i > 0; i--){
            factorial = factorial * i;
        }
        
        return factorial;
    }
You can see that we start with the number and multiply it with the factorial which is initialized with 1 then we reduce the number by 1 until the number becomes 1, which is nothing but n*(n-1)*(n-2).....*1.




Java Program to calculate Factorial with and without Recursion
Here is our complete solution to this problem. You can see that I have created two factorial() methods, one accepts an int and return long like long factorial(int number), while the other accepts a long and returns a long factorial i.e. long factorial(long number). 

How to calculate factorial in Java using recursion


Since their parameter type is different they are two different methods also known as overloaded methods. The first method uses recursion to calculate factorial while the second method uses iteration to calculate factorial.

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Java Program to calculate factorial using iteration and recursion
 * 
 * @author WINDOWS 8
 *
 */
public class FactorialTest {

    public static void main(String args[]) {
       
        System.out.println("factorial of 1 using recursion : " 
                  + factorial(1));
        System.out.println("factorial of 1 using iteration : " 
                  + factorial(1L));
        
        System.out.println("factorial of 5 using recursion : " 
                          + factorial(5));
        System.out.println("factorial of 5 using loop : "  
                             + factorial(5L));       
        
        System.out.println("factorial of 7 using recursive algorithm : "
                      + factorial(7));
        System.out.println("factorial of 7 using iterative algorithm : " 
                      + factorial(7L)); 
        
    }

  
    /**
     * Java method to calculate factorial of given integer using recursion.
     * @param number
     * @return factorial of number
     */
    public static long factorial(int number){
        
        //base case - factorial of 0 or 1 is 1
        if(number <=1){
            return 1;
        }
        
        return number*factorial(number - 1);
    }
    
    /**
     * Java method to calculate factorial of given number using iteration
     * @param input
     * @return factorial of input
     */
    public static long factorial(long input){
        long factorial = 1L;
        for(long i= input; i > 0; i--){
            factorial = factorial * i;
        }
        
        return factorial;
    }
    
}

Output :
factorial of 1 using recursion : 1
factorial of 1 using iteration : 1
factorial of 5 using recursion : 120
factorial of 5 using loop : 120
factorial of 7 using recursive algorithm : 5040
factorial of 7 using iterative algorithm : 5040


That's all about how to calculate the factorial of a number in Java using both recursion and iteration. This problem is often used to teach programming, particularly recursion in schools and colleges, and it's a good one as well. Just remember that even though recursive solutions are small and clear they are prone to throw StackOverFlowException, hence not suitable for production code. Iteration or use of for loop results in a more robust solution.


Read more: https://www.java67.com/2015/09/factorial-in-java-using-recursion-and-loop.html#ixzz8hj9Lgetq

How to Reverse words in String Java? [Solution]

Hello guys, if you are wondering how to reverse words in a given String in Java then you have come to the right place. Earlier, I have shared 75 Programming interview questions and In this Java Coding tutorial, you will learn how to reverse words in String. It's also one of the popular coding questions, so you will also learn how to take a requirement, how to fill gaps in the requirement by asking the right question. A String is nothing but a sentence, which may contain multiple works, or just contain a single word or it may be empty. Your program must produce a String that contains the word in reverse order, for example, if the given input is "Java is Great" then your program should return "Great is Java".  



Now, if you are a good programmer then you should have some right questions for the Interviewer. Never assume you know everything, even if it looks like a simple problem.

Always remember "Devil is in detail". Also asking a question, not only fill the gaps in requirement but also help you to make an impression.

One question the candidate should definitely ask is, what constitutes a word here? For the purpose of this program, the word is nothing but a sequence of non-space characters. Another good question you can ask to Interview is about input like is it possible for input string to contain leading or trailing spaces?

Yes, it's possible. However, your reversed string should not any contain leading or trailing spaces.

One more important question for the Interviewer is about spacing between words, is it possible to have multiple spaces between two words? Yes, it could be possible but you can reduce them to a single space in the reversed string.





Reversing the order of words in a Sentence in Java - Solution
Here is our Java solution to this problem. It's simple and straightforward.  In this code example, I have shown two ways to reverse words in a String, first one is using, Java's regular expression support to split the string into spaces and then using the reverse() method of Collections utility class. 

Once you split the String using regex "\\s", it will return you an array of words. It will also handle words separated by multiple spaces, so you don't need to worry.



Once you got the array, you can create an ArrayList from an array, and then you are eligible to use Collections.reverse() method. 


This will reverse your ArrayList and you will have all the words in reverse order, now all you need to do is concatenate multiple String by iterating over ArrayList.

I have used StringBuilder for concatenating String here. Also make sure to specify size, because resizing of StringBuilder is costly as it involves the creation of a new array and copying content from the old to the new array.

As I said earlier, for more coding problems from programming interviews, you can also check the Grokking the Coding Interview: Patterns for Coding Questions, one of the best resources to learn essential coding patterns like sliding window, merge interval, fast and slow pointers, etc which can be used to solve 100+ Leetcode problems. 

How to Reverse words in String Java



The second method to reverse words in a given string is, even more, easier, instead of using the Collections.reverse() method, I have just used the traditional for loop and started looping over array from the end and performing String concatenation. 

This way, you even don't need to convert your String array to ArrayList of String. This solution is more memory efficient and faster than the previous one.

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
/**
 * Java Program to reverse words in String. There are multiple way to solve this
 * problem. you can either use any collection class like List and reverse the
 * List and later create reverse String by joining individual words.
 *
 * @author Javin Paul
 */
public class Testing {
 
  public static void main(String args[]) {
 
  }
 
  /*
  * Method to reverse words in String in Java
  */
  public static String reverseWords(String sentence) {
    List< String> words = Arrays.asList(sentence.split("\\s"));
    Collections.reverse(words);
    StringBuilder sb = new StringBuilder(sentence.length());
 
    for (int i = words.size() - 1; i >= 0; i--) {
      sb.append(words.get(i));
      sb.append(' ');
    }
 
    return sb.toString().trim();
   }
 
  public static String reverseString(String line) {
    if (line.trim().isEmpty()) {
      return line;
    }
 
    StringBuilder reverse = new StringBuilder();
    String[] sa = line.trim().split("\\s");
 
     for (int i = sa.length - 1; i >= 0; i--) {
        reverse.append(sa[i]);
        reverse.append(' ');
     }
 
     return reverse.toString().trim();
   }
 }
}


Read more: https://www.java67.com/2015/06/how-to-reverse-words-in-string-java.html#ixzz8hj9w4NmS

How to Find Duplicate Characters in String [Java Coding Problems]

Hello guys, today's programming exercise is to write a program to find repeated characters in a String. For example, if given input to your program is "Java", it should print all duplicates characters, i.e. characters appear more than once in String and their count like a = 2 because of character 'a' has appeared twice in String "Java". This is also a very popular coding question on the various level of Java interviews and written tests, where you need to write code. On the difficulty level, this question is at par with the prime numbers or Fibonacci series, which are also very popular on junior level Java programming interviews and it's expected from every programmer to know how to solve them.



I personally like this exercise because it gives beginners an opportunity to familiarize themselves with the concept of Map data structure, which allows you to store mappings in the form of key and value.

Since Map and Hash table data structure is heavily used in any enterprise Java application, good knowledge of this data structure is highly desirable among any level of Java programmers.

By the way, there are a couple of variants of this problem, which you may want to look at before going for an interview.

Sometimes an interviewer will ask you to read a file and print all duplicate characters and their count, core logic will remain the same, all you need to do is demonstrate how much you know about File IO in Java, like streaming file if it's very large rather than reading the whole file in memory.

Btw, a basic knowledge of data structure and algorithms is needed and if you need to brush up then do so. If you need a resource, I highly recommend checking out Data Structures and Algorithms: Deep Dive Using Java course on Udemy. It's a hands-on course and covers all essential data structures. It's also very affordable and you can get in just $10 on Udemy flash sales which happens every now and then.





Java Program to find Repeated Characters of String [Solution]
The standard way to solve this problem is to get the character array from String, iterate through that and build a Map with character and their count. Then iterate through that Map and print characters which have appeared more than once. So you actually need two loops to do the job, the first loop to build the map and the second loop to print characters and counts.

If you look at the below example, there is only one static method called the printDuplicateCharacters(), which does both these jobs. We first got the character array from String by calling toCharArray().



Next, we are using HashMap to store characters and their count. We use the containsKey() method to check if the key, which is a character that already exists or not already exists we get the old count from HashMap by calling the get() method and store it back after incrementing it by 1.



Once we build our Map with each character and count, the next task is to loop through Map and check each entry, if the count, which is the value of Entry is greater than 1, then that character has occurred more than once. You can now print duplicate characters or do whatever you want with them.

By the way, if you are preparing for coding interviews then I highly recommend you to join Grokking the Coding Interview: Patterns for Coding Questions course on Educative. This is an interactive, text-based coding course to learn 15 essential coding patterns like sliding window, merge interval, fast and slow pointers, etc which can be used to solve 100+ coding problems, and you can get it just for $14.9 per month membership. 

How to Find Duplicate Characters in String


And, here is the complete Java program to find duplicate characters in a given String. 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
* Java Program to find duplicate characters in String.
*
*
* @author http://java67.blogspot.com
*/
public class FindDuplicateCharacters{

    public static void main(String args[]) {
        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");
    }

    /*
     * Find all duplicate characters in a String and print each of them.
     */
    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();

        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }

}

Output
List of duplicate characters in String 'Programming'
g : 2
r : 2
m : 2
List of duplicate characters in String 'Combination'
n : 2
o : 2
i : 2
List of duplicate characters in String 'Java'


Read more: https://www.java67.com/2014/03/how-to-find-duplicate-characters-in-String-Java-program.html#ixzz8hjA0mwrM

How to Reverse an Integer in Java without converting to String? Example and Solution

Hello guys, LeetCode has a problem reversing digits of an integer number without using any library method like the reverse() method of StringBuffer. In LeetCode, you can solve this problem with many different languages like Java, C, C++, C#, Python, Ruby, and even JavaScript. Btw, in the article, you will learn how to solve this problem in Java. Before approaching a solution let's first read the problem statement :



Reverse digits of an integer.

Example 1: x = 123, return 321
Example 2: x = -123, return -321

The problem looks simple but it's not simple there are many things you need to consider in order to produce a solution that is accepted by LeetCode, which has thousands of test cases to test your solution.

For example, you need to consider not just a positive integer but also a negative integer. Remember, a positive integer can also be written using the + sign, so you need to handle that as well. If the integer's last digit is 0, what should the output be? I mean, cases such as 10, 100.

If the return type of method is an integer then you can simply return 1, it's perfectly ok, but if the return type of method is String then you may need to return 001 or 0001. For the purpose of this solution, we expect our method to return an integer, so 1 is fine.

By the way, if you are preparing for coding interviews then you should be prepared for such kinds of questions. According to Leetcode, this is one of the common coding problems from Google interviews.





How to Reverse digits of an Integer in Java without converting to String?
Here are my algorithms to solve this problem of reversing integer numbers without using any direct library method. 

The crux of this problem is how to use division and modulo operators in Java to get the last digit of a number and get rid of the last digit as well.

If you remember, I have shared this trick before when I was explaining how to use a modulo operator in Java. This is a really neat trick and will help you to solve many programming problems where you need to divide numbers into individual digits.

When you divide a number by 10, you get rid of the last digit, for example, 211/10 will give you 21, and 21/10 will give you 2, so you got rid of the last 2 digits by dividing your number by 10 twice.

Similarly, you can use the number modulo 10 to get the last digit of the number, for example, 221%10 will return 1, which is the last digit and 22%10 will return 2, which is the last digit of 22. You can apply this logic until you processed the last digit.

How to Reverse digits of an Integer in Java without converting to String?


Now the question comes, how do you arrange those digits in reverse order? Well, you can use just the opposite, I mean, multiplication and addition to creating a new number with digits of the old number in reverse order.  I have used the following logic to assemble digits into reverse order :

reverse = reverse * 10 + lastDigit;

You can see by multiplying a number by 10 you increase the number of digits by 1 and then add the last digit. For negative numbers, we multiply it by -1 to first make it positive and then apply the same logic, while returning numbers we just multiply it by -1 again to convert the reversed number into negative.



This kind of little trick really helps to solve coding problems during interviews and in your day-to-day life. If you want to learn more of such patterns to boost your problem-solving skills then I also suggest you check out Grokking the Coding Interview: Patterns for Coding Questions course on Educative.

best course to learn coding patterns for interviews

This course will teach you 6 essential coding patterns like Sliding Window, Two Pointers, Fast and Slow Pointers, Merge Intervals, Cyclic Sort, and Top K elements that can help you to solve zones of frequently asked coding problems.  This is very good for preparing coding interviews as well as improving your coding skills.



Java Program to reverse an Integer without using String
Here is our complete Java program to reverse a given Integer without using String. As explained in the above paragraph, I have used the Arithmetic and modulus operator to solve this problem.

import java.util.Scanner;

/**
 * Java Program to reverse Integer in Java, number can be negative.
 * Example 1:  x = 123, return 321
 * Example 2:  x = -123, return -321
 *
 * @author Javin Paul
 */

public class ReverseInteger{

    public static void main(String args[]) {
        int input = 5678;
        int output = reverseInteger(5678);
        System.out.println("Input : " + input + " Output : " + output);
    }

    /*
     * Java method to reverse an integer value. there are couple of 
     * corner cases
     * which this method doesn't handle e.g. integer overflow.
     */
    public static int reverseInteger(int number) {
        boolean isNegative = number < 0 ? true : false;
        if(isNegative){
            number = number * -1;
        }
        int reverse = 0;
        int lastDigit = 0;

        while (number >= 1) {
            lastDigit = number % 10; // gives you last digit
            reverse = reverse * 10 + lastDigit;
            number = number / 10; // get rid of last digit
        }

        return isNegative == true? reverse*-1 : reverse;
    }

}

Result :
Input : 5678 Output : 8765

You can see that output is the just reverse of input. The first digit has exchanged position with the last digit, the second with the second last, and so on.


Read more: https://www.java67.com/2015/08/how-to-reverse-integer-in-java-leetcode-solution.html#ixzz8hjAP9zM6

How to check leap year in Java - program example

Write a Java program to find if a year is a leap year or not is a standard Java programming exercise during various Java programming courses on schools, colleges, and various training institutes both online and offline,  along with other popular homework's e.g. printing Fibonacci numbers, checking palindromes, or finding prime numbers. Just to recap a leap year is a year with 366 days which is 1 extra day than a normal year. This extra day comes in the month of February and on leap year Feb month has 29 days than normal 28 days. If you are following then you might know that leap year comes in an interval of 4 years. This year 2012 is a leap year and Feb has 29 days, you can check.




Now if you are in programming before you might be familiar that there is standard logic to find leap year i.e. if a year is multiple of 400 or multiple of 4 but not multiple of 100 then it's a leap year. In addition to this standard logic, you can also use Java's Date, Time, and Calendar API to check how many days any year has and by comparing that number with 365 you can find whether that year is a leap year or not. 

In this Java programming tutorial, we will both of these examples to check if a year is a leap year or not.

And, if you are new to Coding and Programming then I also suggest you check out these free Programming courses to learn programming basics like operators, functions, classes, loops, etc in Java, Python, JavaScript, and other popular programming languages.



Java program to check if a year is a leap year
Here is a complete code example of a Java program to find out whether a year is a leap year or not. isLeapYear(int year) method uses Calendar API to get the maximum number of days in that year and compare that with 365. If the year contains more than 365 days, it's a leap year. The second method doesLeapYear(int year) uses programming logic to find if a year is a leap or not.

How to check leap year in Java - program example




How to check if a year is a leap year in Java
Here is our complete Java program to test if a given year is a leap year or not. 

package test;

import java.util.Calendar;

/**
 *
 * Java program to find if a year is a leap year or not.
 * A leap year is a year that contains 366 days, which is 1 day more than the normal 365 day year.
 * Leap year comes in an interval of 4 years. In Gregorian
 * calendar in leap year February has 29 days which is 1 day more than 28 day in a normal year.
 *
 * @author
 */
public class LeapYearProgram {
 
 
    public static void main(String args[]) {
 
        //Testing some leap and non-leap year using Java library code
        System.err.println("Is 2000 a leap year ? : " + isLeapYear(2000));
        System.err.println("Is 2012 a leap year ? : " + isLeapYear(2012));
        System.err.println("Is 1901 a leap year ? : " + isLeapYear(1901));
        System.err.println("Is 1900 a leap year ? : " + isLeapYear(1900));
     
     
        //Checking leap year without using library or API and applying logic
        System.err.println("Does 2000 a leap year : " + doesLeapYear(2000));
        System.err.println("Does 2012 a leap year : " + doesLeapYear(2012));
        System.err.println("Does 1901 a leap year : " + doesLeapYear(1901));
        System.err.println("Does 1900 a leap year : " + doesLeapYear(1900));
    }  
 
 
   /*
     * This method checks whether a year is a leap or not by using Java Date
     * and Time API. Calendar class has a utility method to return maximum
     * number of days in a year which can be used to check if its
     * greater than 365 or not
     */
   public static boolean isLeapYear(int year){
       Calendar cal = Calendar.getInstance(); //gets Calendar based on local timezone and locale
       cal.set(Calendar.YEAR, year); //setting the calendar year
       int noOfDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
     
       if(noOfDays > 365){
           return true;
       }
     
       return false;
   }
 
   /*
    * This method uses standard logic to check leap year in Java.
    * A year is a leap year if its multiple of 400 or multiple of 4 but not 100
    */
   public static boolean doesLeapYear(int year){
       return (year%400 == 0) || ((year%100) != 0 && (year%4 == 0));
   }
}

Output:
Is 2000 a leap year ? : true
Is 2012 a leap year ? : true
Is 1901 a leap year ? : false
Is 1900 a leap year ? : false
Does 2000 a leap year : true
Does 2012 a leap year : true
Does 1901 a leap year : false
Does 1900 a leap year : false


Read more: https://www.java67.com/2012/12/how-to-check-leap-year-in-java-program.html#ixzz8hjAUccRt

Bubble sort in Java - Program to sort an Integer Array [Example]

Bubble sort is one of the classic sorting algorithms,s which is used to explain sorting during various computer and engineering courses. Because of its algorithmic nature and simplicity, it's often used in various Java and C++ programming exercises. You may expect questions like the Write Java program to sort integer arrays using bubble sort during any programming interview. Since algorithmic questions are always tricky questions and not easy to code. Even the simplest of them can lead to confusion, especially if you are not gifted with a natural programming head. I have seen many developers fumble if asked to code on the spot. That's why it's advisable to do algorithmic and logical programming during training and learning programming and OOPS to get this skill of converting logic into code.



Let's come back to Bubble sort, In the Bubble sort algorithm we sort an unsorted array by starting from the first element and comparing it with the adjacent element. If the former is greater than later then we swap and by doing this we get the largest number at the end after the first iteration. 

So in order to sort n elements you require n-1 iteration and almost n-1 comparison. To recap here is the logic for the bubble sort sorting algorithm :

1) Start comparing a[0] to a[1]

2) If a[0] > a[1] then swap numbers e.g. a[0]=a[1] and a[1]=a[0]

3) compare a[1] to a[2] and repeat till you compare last pair

4) This is referred to as one pass and at the end of the first pass largest, the number is at last position and already sorted.

5) Just repeat this comparison again starting from a[0] but this time going till second last pair only







How to sort integer array using bubble sort in Java
Here is a complete code example of a bubble sort in Java. It uses the same algorithm as explained in the first pass, it uses two loops. The inner loop is used to compare adjacent elements and the outer loop is used to perform Iteration. because of using two loops, it results in an order of n^2 which is not great in terms of performance. 

If you are using Array List instead of the array then you can sort them using Collections.sort method for better performance, for details, check How to sort Array List in ascending and descending order.


Bubble sort is a good sorting algorithm to start with but you also need to learn more difficult and useful ones like QuickSort, MergeSort, HeapSort, as well as some advanced constant time, also known as O(n) sorting algorithms like Radix Sort, Bucket Sort, and Counting Sort if you want to do well on technical interviews. 

If you are preparing for coding interviews then I suggest you double down into Algorithms as it takes time to develop the coding sense. I also recommend you check out Grokking the Coding Interview: Patterns for Coding Questions on Educative, an interactive portal for coding interviews to learn some useful patterns which can help you to solve many common coding problems. 

Bubble sort in Java - program to sort integer array



Anyway, Now, let's see the Java program which implements this bubble sort logic to sort unsorted integer arrays.



package test;

import java.util.Arrays;

/**
 * Java program to sort integer array using bubble sort sorting algorithm.
 * bubble sort is one of the simplest sorting algorithm but performance
 * of bubble sort is not good, it's average and worst-case performance
 * ranges in O(n2) and that's why it is not used to sort a large set of
 * unsorted data. Bubble sort can be used for educational and testing
 * purpose to sort a small number of data to avoid the performance penalty.
 * This program is also a good example of how to print contents of Array in Java
 *
 * @author http://java67.blogspot.com
 */
public class BubbleSort {
 
 
    public static void main(String args[]) {
        //testing our bubble sort method in Java
        int[] unsorted = {32, 39,21, 45, 23, 3};
        bubbleSort(unsorted);
     
        //one more testing of our bubble sort code logic in Java
        int[] test = { 5, 3, 2, 1};
        bubbleSort(test);
     
    }  
 
    /*
     * In bubble sort we need n-1 iteration to sort n elements
     * at end of first iteration larget number is sorted and subsequently numbers smaller
     * than that.
     */
    public static void bubbleSort(int[] unsorted){
        System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));
     
        // Outer loop - need n-1 iteration to sort n elements
        for(int i=0; i<unsorted.length -1; i++){
         
            //Inner loop to perform the comparison and swapping between adjacent numbers
            //After each iteration one index from last is sorted
            for(int j= 1; j<unsorted.length -i; j++){
             
                //If the current number is greater than swap those two
                if(unsorted[j-1] > unsorted[j]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(unsorted));
        }
    }

}

Output:
unsorted array before sorting : [32, 39, 21, 45, 23, 3]
unsorted array after 1 pass [32, 21, 39, 23, 3, 45]:
unsorted array after 2 pass [21, 32, 23, 3, 39, 45]:
unsorted array after 3 pass [21, 23, 3, 32, 39, 45]:
unsorted array after 4 pass [21, 3, 23, 32, 39, 45]:
unsorted array after 5 pass [3, 21, 23, 32, 39, 45]:
unsorted array before sorting : [5, 3, 2, 1]
unsorted array after 1 pass [3, 2, 1, 5]:
unsorted array after 2 pass [2, 1, 3, 5]:
unsorted array after 3 pass [1, 2, 3, 5]


Java program for Bubble sort algorithm with exampleThat's all on How to sort integer array using Bubble sort in Java. We have seen a complete Java program for bubble sort and also printed output after each pass or iteration if you look carefully you will find that after each pass largest number gets sorted and the number of comparisons decreased. 

As I said Bubble sort is not a high-performance sorting algorithm and you should by using Collection.sort() method from standard Java library to sort Collections or Arrays.sort() to sort Array in Java. 

Also this the program demonstrates How to print contents of Array using Arrays.toString() as an array in Java doesn’t override toString and simply printing array using System.out.println(array) will only show default toString from java.lang.Object class instead of the contents of the array.


Read more: https://www.java67.com/2012/12/bubble-sort-in-java-program-to-sort-integer-array-example.html#ixzz8hjAh0hBE

QuickSort Algorithm Example in Java using Recursion - Tutorial

The Quicksort algorithm is one of the very popular sorting algorithms in programming, often used to sort a large array of numbers. Though there is numerous algorithm available to sort a list of objects, including integer, string, and floating-point number, quicksort is best for general purpose. It's a divide and conquers algorithm, where we divide the given array with respect to a particular element, known as 'pivot' such that the lower partition of the array is less than the pivot and upper partition elements of the array are higher than the pivot.
The Quicksort is also one of the best examples of recursion, a key programming technique to solve Algorithmic problems. This algorithm is naturally recursive because it sorts the large list by dividing it into smaller sub-list and then applying the same algorithm to those.



The base case of recursion is when a list contains either one or zero elements, in that case, they are already sorted. Quicksort is well ahead with primitive sorting algorithms like Insertion sort, selection sort, and Bubble sort. The average time complexity of quicksort is O(N log N), while in the worst case its performance is similar to bubble sort, I mean O(n^2).

Apparently, the worst case of quicksort is the best case of insertion sort, where they have to sort an already sorted list. In this article, we will learn how to implement a quicksort algorithm in Java using recursion.

We will also learn how quicksort works, and how it sorts a large list of unsorted numbers. In the last section, we will revisit some important things about quicksort.

Btw, if you are new to the Data Structure and Algorithm field and not familiar with essential searching and sorting algorithms like Quicksort, I suggest you take a look at the Data Structures and Algorithms: Deep Dive Using Java course on Udemy. One of the better courses to master algorithms and data structure in quick time.





1. How do the QuickSort Algorithm works?
An old saying is, a picture is worth more than a thousand words. This is completely true in the case of understanding how the sorting algorithm works.

In the past, I have understood Insertion sort, Bubble sort, and Radix sort much better by following a diagram rather than reading about it.

That's why I am sharing this diagram which explains how the quicksort algorithm works, how it sort a list of integers. It's similar to a flowchart but doesn't use the notation flowchart uses, instead it practically shows how sorting happens.

Once you go through this diagram, read the explanation, it will make more sense.

How to implement QuickSort in Java - Working Example



As I told before QuickSort is a recursive algorithm, it divides the big list into smaller list around pivot until those lists are individually sorted. The first step of the Quicksort algorithm is to determine pivot, it's general practice to choose the middle element of the array as a pivot, but you are free to choose any index.

Now you have two lists, the next step is to ensure that the left partition only contains numbers less than the pivot and the right partition only contains numbers greater than the pivot.



We start the pointer from the left and right of the pivot, and as soon as the left pointer encounter 4, it stops because 4 is greater than 3. Similarly, the right pointer stops at 3 because all numbers on the right side of the list are greater than 3.



Now it's time to swap, so 3 takes place of 4 and vice-versa. Now, we move the pointer to one more step, since 2 > 3, the left pointer shifts but since 4 > 3, it stopped.

Since the left point is also past the right pointer it stopped. Now if we repeat this process one more time, the list will be sorted. If you still don't get the algorithm then I suggest you join the Visualizing Data Structures and Algorithms in Java course on Udemy. A special course that will teach you data structures and algorithms in Java through animations and implementations.

QuickSort Algorithm in Java




2. The Concept of  Pivot and Partition
Though we often select a middle element of the array as a pivot, there is no such rule and pivot can be an element of the given array. You can even consider the first element as the pivot in every partition.

It's experienced that choice of pivot affects the distribution of the elements in partitioning and affects the complexity of the quicksort algorithm.

As per the rule of partition, numbers in the lower partition should be less than the pivot and upper partition numbers should be higher than the pivot. The running time of partition logic is linear.





3. The complexity of Quicksort Algorithm Explained
On average Quicksort Algorithm has the complexity of O(NlogN) and in the worst case, it has O(n²) when the elements of the input array are already sorted in ascending or descending order.

The good thing about Quicksort is that it's an in-place algorithm, which means it does not take any additional space, except those used by method stack.

By the way, there are some tricks to improve the performance of quicksort, even in the worst case. As suggested in one of the best algorithm design books, The Algorithm Design Manual, by Steven Skiena, you can apply the following recommendation to improve your quicksort algorithm implementation.

3.1. Randomization
You can avoid the worst-case performance of O(n²) when sorting nearly-sorted data by random permutation of keys. Though it incurs some cost of permutation still gives better performance than O(n²)

3.2. Leave small sub-arrays for Insertion sort
finish Quicksort recursion and switch to insertion sort when fewer than 20 elements:

There is a drawback of using recursion to implement a quicksort algorithm, It will not scale because JVM has no tail call optimization, it will simply grow the method call stack to something proportional to the array to sort, and it will fail for the very large array.



Btw, if you have trouble understanding how we calculate the time and space complexity of an algorithm or solution, I suggest you check out Algorithms and Data Structures - Part 1 and 2, a two-part series in Pluralsight to learn how to calculate time complexity. It's an excellent course for beginners.

QuickSort Algorithm Example in Java using Recursion




4. Java Program to Sort Integer Array using QuickSort Algorithm
Here is our recursive implementation of the QuickSort sorting algorithm. We have used it to sort an array of randomly distributed integers. We have two sets of inputs, one which doesn't contain any repeated numbers and the other which contains duplicates.

The Logic of quicksort is encapsulated in method recursiveQuickSort(int[] array, int startIdx, int endIdx) and partition(int[] array, int left, int right), which implements partitioning logic.

In order to hide implementation details, we have only exposed a convenient static utility method called quickSort(int[] array), which takes an integer array and sorts that in place.

package test;

import java.util.Arrays;


/**
* Java program to Sort integer array using QuickSort algorithm using recursion.
* Recursive QuickSort algorithm, partitioned list into two parts by a pivot,
* and then recursively sorts each list.
* @author Javin Paul
*/
public class QuickSort{

    public static void main(String args[]) {

        int[] input = { 23, 31, 1, 21, 36, 72};
        System.out.println("Before sorting : " + Arrays.toString(input));
        quickSort(input); // sort the integer array using quick sort algorithm
        System.out.println("After sorting : " + Arrays.toString(input));
     
        // input with duplicates
        int[] withDuplicates = { 11, 14, 16, 12, 11, 15};
        System.out.println("Before sorting : " 
                              + Arrays.toString(withDuplicates));
        quickSort(withDuplicates); // sort the array using quick sort algorithm
        System.out.println("After sorting : " 
                              + Arrays.toString(withDuplicates));
    }

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java
     * @param array
     */
    public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    /**
     * Recursive quicksort logic
     *
     * @param array input array
     * @param startIdx start index of the array
     * @param endIdx end index of the array
     */
    public static void recursiveQuickSort(int[] array, int startIdx, 
                                                        int endIdx) {
     
        int idx = partition(array, startIdx, endIdx);

        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }

    /**
     * Divides array from pivot, left side contains elements less than
     * Pivot while right side contains elements greater than pivot.
     *
     * @param array array to partitioned
     * @param left lower bound of the array
     * @param right upper bound of the array
     * @return the partition index
     */
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }
}

Output:
Before sorting : [23, 31, 1, 21, 36, 72]
After sorting : [1, 21, 23, 31, 36, 72]
Before sorting : [11, 14, 16, 12, 11, 15]
After sorting : [11, 11, 12, 14, 15, 16]





5. Things to know about QuickSort Algorithm in Java
As I said, QuickSort is one of the most popular sorting algorithms between programmers, maybe just next to Bubble sort, which is ironically the worst algorithm to sort a large list of numbers. But one thing is common between QuickSort and Bubble Sort, do you know what? In the worst case, both have the complexity of O(n^2).

5.1 QuickSort is a divide and conquers algorithm, which means it sort a large array of numbers by dividing them into a smaller array and then individually sorting them (conquer).

5.2 Average case complexity of Quicksort is O(n log(n)) and the worst-case complexity of Quicksort is O(n²).

5.3 Quicksort is a comparison sort and, inefficient implementations, it's not a stable sort, which means equal numbers may not retain their original position after sorting.

5.4 Quicksort algorithm can be implemented in-place, which means no additional space will be required. This makes it suitable to sort a large array of numbers.

5.5 The Arrays.sort() method in Java uses quicksort to sort an array of primitives like an array of integers or float and uses Mergesort to sot objects like an array of String.


Read more: https://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html#ixzz8hjAn3q00

1. Array-based Programming Interview Questions
If you ask me just one topic to prepare really well for coding interviews, I would pick the array. It's one of the essential data structures and favorite darling of coding interviews. There are so many popular coding interview questions that are based upon the array, some of them are easy and some are tough but you can be sure that you will see some questions based upon the array in your next programming job interview.

If you don't know, an array is a data structure that holds other objects like String, int, float, etc. It holds them in a contiguous location in memory which makes them easily searchable and retrieval in O(1) time using the index.

Insertion and deletion of an array are tough because you cannot change the size of an array once created and you need to create a new array and copy elements from old to new.



Anyway, here are some of the most popular array-based coding interview questions for your preparation:

1. How to find the missing number in a given integer array of 1 to 100? (solution)

2. How to find the duplicate number on a given integer array? (solution)

3. How to find the largest and smallest number in an unsorted integer array? (solution)

4. How to find all pairs of integer arrays whose sum is equal to a given number? (solution)

5. How to find duplicate numbers in an array if it contains multiple duplicates? (solution)

6. How to remove duplicates from a given array in Java? (solution)

7. How to sort an integer array in place using the QuickSort algorithm? (solution)

8. How to remove duplicates from an array in place? (solution)

9. How to reverse an array in place in Java? (solution)

10. How to find multiple missing numbers in a given integer array with duplicates? (solution)

I have linked all the solutions but you should try to solve them by yourself before looking at the solution, especially if you have time. That's the only sure way to learn to program by solving these coding questions.

If you find these questions difficult to solve then once again I suggest you first refresh your knowledge of fundamental data structures like an array by going through a comprehensive course. If you need recommendations, Algorithms, and Data Structures Part 1 and Part 2 by Robert Harvick are two of the best course to start with. You will also learn about Big(O) notation and how to calculate time and space complexity.

Array based Programming Interview Questions Answers


If you think these 10 questions from the array are not enough and you are interested in solving more array-based programming problems then you can also check out these 30 array-based coding questions for more practice.



2. String-based Coding Interview Questions
After array, String is the next popular topic on Programming job interviews, but if you have a good understanding of array then you can easily deal with String programming questions because String is nothing but a character array.

The string is implemented differently in a different programming language like in C it's a NULL-terminated character array but in Java, it's an object. However, you can still get access to the underlying array to apply your logic.

Here is a list of some of the frequently asked coding questions which are based on String. Though some of them are quite old, you can still expect this in your programming job interview:

11. How to Print duplicate characters from String? (solution)

12. How to check if two Strings are anagrams of each other? (solution)

13. How to print the first non-repeated character from String? (solution)

14. How to reverse a given string using recursion? (solution)

15. How to check if a string contains only digits? (solution)

16. How to find duplicate characters in a String? (solution)

17. How to count a number of vowels and consonants in a given String? (solution)

18. How to count the occurrence of a given character in String? (solution)

19. How to find all permutations of String? (solution)

20. How to reverse words in a given sentence without using any library method? (solution)

21. How to check if two String is a rotation of each other? (solution)

22. How to check if the given String is Palindrome? (solution)

Similar to an array, I have also linked to a solution for all of these String problems but if you want to get most of this article, you better solve these questions without looking at the answers. Only when you are stuck and running out-of-time, you can look at the solution.

And, if you find these frequently asked String problems difficult to solve, maybe it's time to go back to the drawing board and learn the fundamentals of String data structure again.  If you need resources then Data Structures and Algorithms Specialization on Coursera is one of the best online resources you can use to make your foundations rock solid.

Top 50 Coding Interview Questions


You can also learn from it by comparing your solution with the solution I have given. It's not necessarily to be the same but you can learn a lot by comparing them and if you need more practice, here is another list of 20 String algorithm questions and this list of 21 String coding problems21 String coding problems for tech interviews. 



3. Linked list based Programming Interview Questions
Along with array and string, a linked list is another popular data structure in the programming world as well as on coding interviews. You will find a lot of questions on a linked list like reversing a linked list, adding a new element, removing an element from the middle, etc.

It's also the counterpart of an array data structure. While array stores elements on contiguous memory locations, the linked list stores them at different locations and finds them by storing their address. a linked list is made of nodes, an internal data structure that holds the value as well as the address of the next node.

Because of its structure, it's easier to add and remove elements from the linked list like on O(1) time if you are adding or removing from the head but the search is equally difficult and takes O(n) time, as you have to literally walk through each element.

Anyway, here is a collection of some of the simple and tricky linked list based coding questions for your practice:

23. How to find the middle element of a singly linked list in one pass? (solution)

24. How to check if a given linked list contains a cycle? How to find the starting node of the cycle? (solution)

25. How to reverse a linked list? (solution)

26. How to reverse a single linked list without recursion? (solution)

27. How to remove duplicate nodes in an unsorted linked list? (solution)

28. How to find the length of a singly linked list? (solution)

29. How to find the 3rd node from the end in a singly linked list? (solution)

30. How do you find the sum of two linked lists using Stack? (program)

Similar to array and string, I have also linked to all the solutions but you should only look at them once you solved the problem on your own or you feel stuck.

A key to solving the linked list is a good understanding of recursion because a linked list is a naturally recursive data structure, for example, if you take one node out of the linked list, the result is another linked list, but many programmers struggle to understand recursion.

That was the case with me as well but after practice and visualizing how recursion really works, I overcome that deficiency. If you are in the same boat, I strongly suggest you go through a visual course like Visualizing Data Structures and Algorithms in Java to learn Recursion and data structure. That will help you a lot in your thought process and problem-solving skills.

Top 75 Programming Interview Questions and Solutions

Once you understand recursion, most of the linked list based problems have an easy recursive solution than their iterative version. And if you need more practice, here is another list of 30 linked list programming questions for your reference.



4. Binary Tree-based Coding Interview Questions
A tree is another popular data structure in the programming world and coding interviews. Unlike array and linked list, which are considered linear data structures, a tree is considered a hierarchical data structure and used to arrange information in hierarchical order.

There are a lot of different types of trees e.g. a binary tree, binary search tree, AVL tree, Red-Black tree, etc but Binary tree and Binary search trees are also known as BST are two of the most popular ones and most of the questions are based upon them.

Some questions are also based upon theoretical knowledge of tree data structure e.g. finding the height of the tree, finding leaf nodes, checking if the tree is balanced or not, etc, hence you should also spend some time learning the basics, along with practicing coding questions.

Anyway, here is a list of popular binary tree and binary search tree based coding questions to practice before your job interview:

30. Can you write a program to implement a binary search tree?  (solution)



31. How do you perform Pre-order traversal in a given binary tree? (solution)

32. Write a Program to traverse a given binary tree in Pre-order without recursion (solution)

33. How to perform an In order traversal in a given binary tree? (solution)

34. How to print all nodes of a given binary tree using inorder traversal without recursion (solution)

35. How to implement a Post-order traversal algorithm? (solution)

36. How to traverse a binary tree in Postorder traversal without recursion (solution)

37. How to Print all leaves of a binary search tree? (solution)

38. How to count a number of leaf nodes in a given binary tree? (solution)

39. How to perform a binary search in a given array? (solution)

Like an array, linked list, and string questions, I have also linked to all solutions for binary tree questions but you should only look at them once you have tried it yourself.

One trick I would like to share with you while solving tree questions is to remember that, similar to a linked list, the tree is also a recursive data structure and most of the tree based problems has an easy recursive solution.

For example, a subtree is also a tree which means you can apply the same steps to a subtree can devise a recursive solution. In the above list, many popular tree algorithms e.g. pre-order, post-order, in-order are implemented recursively as well as iterative.

If you don't feel confident to solve these problems and want to refresh your knowledge of binary tree and other data structure before attempting these questions, then you should check out Data Structures and Algorithms: Deep Dive Using Java from Udemy.

Top 75 Essential Programming Interview Questions to Crack Any Coding Interview




5. Miscellaneous Programming Interview Questions
Even though data structure-based questions make the bulk of the Coding Interview, there are always some questions from topics like sorting algorithms, bit manipulation, software design, Dynamic Programming, and other logical and tricky questions.

In this list below, you will find most of the common searching and sort questions as well as a couple of design and bit manipulation questions.

40. How to implement the Bubble Sort algorithm? (solution)

41. How to implement Iterative Quicksort Algorithm? (solution)

42. How to implement the Insertion Sort Algorithm? (solution)

43. How to implement Merge Sort Algorithm? (solution)

44. How to implement the Bucket Sort Algorithm? (solution)

45. How to implement the Counting Sort Algorithm? (solution)

46. How to implement Radix Sort Algorithm? (solution)

47. How to swap two numbers without using the third variable? (solution)

48. How to check if two rectangles overlap with each other? (solution)

49. How to design a Vending Machine? (solution)

50. How to implement an LRU Cache in your favorite programming language? (solution)

51. How to check if a given number is a Palindrome? (solution)

52. How do you check if a given number is an Armstrong number? (solution)

53. How do you find all prime factors of a given number? (solution)

54. How do you check if a given number is positive or negative in Java? (solution)

55. How to find the largest prime factor of a given integral number? (solution)

56. Write a Program to print all prime numbers up to a given number? (solution)

57. Write a Program to print Floyd's triangle? (solution)

58. Write a Program to print Pascal's triangle? (solution)

59. How to calculate the square root of a given number? (solution)

60. How to check if the given number is a prime number? (solution)

61. How to implement the Sieve of Eratosthenes Algorithm? (solution)

62. How to add two numbers without using the plus operator in Java? (solution)

63. Write a Program to subtract two binary numbers? (solution)

64. Write a Program to transpose a Matrix? (solution)

65. Write a Program to add or subtract two Matrices? (solution)

66. Write a Program to multiply two Matrices in Java? (solution)

67. How to calculate the average of all numbers in a given array? (solution)

68. How to check if a given number is even/odd without using an Arithmetic operator? (solution)

69. Write a Program to find the GCD of two numbers using Euclid's Algorithm? (solution)

70.  How to find the number of 1s (the Set bit) in a given Bit Sequence? (solution)

71. Write a Program to a given Pyramid structure? (solution)

72. How to find the highest repeating world from a given file in Java? (solution)

73. How to reverse a given Integer in Java? (solution)

74. How to convert a decimal number to binary in Java? (solution)

75. How to check if a given year is a leap year in Java? (solution)

Like previous topics, I have provided links to a solution but you should only look at them once you tried to solve the questions yourself. That's important for learning.



5. System Design Interview Questions
In last few years, System design and Software design questions have become an integral part of coding interviews. Either you will be asked a tough question like how to design WhatsApp or YouTube or asked theory questions like what is difference between load balancer and API gateway but you will get few questions on this topic. 

Keeping that in mind, I am sharing popular System design questions for Programming and Software Engineering Job interviews. This contains both System design basics questions as well as System design problems from interviews:


76. What is Rate Limiter? How does it work? (answer)


77. How does Single Sign On (SSO) works? (answer)


78. How does Apache Kafka works? why it so fast? (answer)


79. Difference between Kafka, ActiveMQ, and RabbitMQ? (answer)


80. Difference between API Gateway vs Load Balancer? [solution] 

81. Difference between JWT, OAuth, and SAML? (answer)

82. What is difference between Reverse Proxy and Forward Proxy? (answer)


83. What is Horizontal scaling and vertical scaling? (answer)


84. What is difference Microservices and Monolithic architecture? (Answer)


And, now let's see System design problems from Programming job interviews where you will be asked to design real world apps like WhatsApp, YouTube, Twitter, Instagram, etc


85. How do you design Vending Machine in Java [solution]

86. How to Design URL Shortener like TinyURL [solution]

87. Please give high and level design of WhatsApp (solution)

88. Please Design YouTube and implement your favorite feature [solution]

89. How do you design a trade aggregator or portfolio manager? (solution)

90.  How to design Parking Garage [solution]

91. Can you design a bounded buffer in Java? (solution)

82. Can you walk through design Text Storage Service like Pastebin? [solution]

93. How are you going to design Content Delivery Network (CDN) ? [solution]

94. how do you design Google Map? (Solution)

95. Design Instagram [solution]
In this question you can choose which feature to implement, I suggest you should start with simple one like uploading photos and sharing them in your feed.


Read more: https://www.java67.com/2018/05/top-75-programming-interview-questions-answers.html#ixzz8hjB5E2SF

How to Reverse String in Java with or without StringBuffer Example

Reverse String in Java
There are many ways to reverse a given String in Java. For example, you can use rich Java API to quickly reverse the contents of any String object. Java library provides StringBuffer and StringBuilder class with the reverse() method which can be used to reverse String in Java. Since converting between String and StringBuffer or StringBuilder is very easy it's the easiest way available to reverse String in Java. But, in a coding interview, you may not be allowed to use the JDK API methods to solve this problem. That's why, writing a Java program to reverse String in Java without StringBuffer is one of the popular Java String interview questions, which requires you to reverse String by applying logic and by not using API methods.



Since reverse is a recursive job, you can use recursion as well as a loop to reverse String in Java. In this Java tutorial, you will learn how to reverse String using StringBuffer, StringBuilder, and using a pure loop with logic.

Btw, if you are preparing for coding interviews then a  good knowledge of techniques like Recursion, Dynamic Programming, Greedy Algorithms, and essential data structures like an array, string, linked list, binary tree, stack, queue, etc are very important.

You should put a decent amount of time into brushing these skills before going for any coding interview or taking calls for any telephonic interviews. If you need resources, I recommend Data Structures and Algorithms: Deep Dive Using Java to brush up your Data structure and algorithms skills. This is a great and very affordable course on Udemy which you can buy for just $10 on Udemy sales which happens every now and then. 





Algorithm to Reverse String in Java
Here are the algorithm and codes to reverse a given String in Java without using StringBuffer or any other API methods. The method below shows you how to reverse the String, which you can further reuse to check if the given String is Palindrome or not.

How to Reverse String in Java with or without StringBuffer Example



After initial input validation, we are just iterating through String, starting from end to start and generating a reverse String.

If you want to master the art of solving these kinds of coding problems then Grokking the Coding Interview: Patterns for Coding Questions on Educative is an excellent course to join. This course will teach you how to identify a pattern among different coding problems and use that skill to solve unknown problems that are asked in a coding interview on companies like Google, Amazon, and Microsoft.

How to Reverse String in Java with or without StringBuffer Example



Java Program to Reverse String in Java
Java program to reverse String in Java without StringBuffer or StringBuilderHere is my complete code program to reverse any String in Java. In the main method, we have first used StringBuffer and StringBuilder to reverse the contents of String, and then we wrote our own logic to reverse String.

This uses the toCharArray() method of String class which returns the character array of String. By looping through the character array and appending it into an empty String we can get a reversed String in Java, as shown in the following example.

You can also check How to reverse String with recursion in Java if you want to see the recursive code. let's see the complete Java program for this beautiful Java programming exercise.


/**
 *
 * Java program to reverse String in Java.
 * There are multiple ways to reverse
 * String in Java, you can either take help of standard
 * Java API StringBuffer to reverse String in Java.
 * StringBuffer has a reverse() method which returns StringBuffer
 * with reversed contents. 
 *
 * On the other hand, you can also reverse it by applying your
 * own logic, if asked to reverse String without
 * using StringBuffer in Java. 
 *
 * By the way you can also use StringBuilder to reverse
 * String in Java. StringBuilder is non-thread-safe
 * version of StringBuffer and provides similar API.
 * You can use StringBuilder's reverse()
 * method to reverse content and then convert it back to String
 *
 * @author http://java67.blogspot.com
 */
public class StringReverseExample {
 
 
    public static void main(String args[]) {
     
        //quick wasy to reverse String in Java - Use StringBuffer
        String word = "HelloWorld";
        String reverse = new StringBuffer(word).reverse().toString();
        System.out.printf(" original String : %s ,
               reversed String %s  %n", word, reverse);
     
        //another quick to reverse String in Java - use StringBuilder
        word = "WakeUp";
        reverse = new StringBuilder(word).reverse().toString();
        System.out.printf(" original String : %s ,
             reversed String %s %n", word, reverse);
     
        // one way to reverse String without using
        // StringBuffer or StringBuilder is writing
        // own utility method
        word = "Band";
        reverse = reverse(word);
        System.out.printf(" original String : %s ,
                            reversed String %s %n",
                               word, reverse);
    }  
 
 
    public static String reverse(String source){
        if(source == null || source.isEmpty()){
            return source;
        }      
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }
     
        return reverse;
    }
   
}

Output:
original String: HelloWorld, reversed String dlroWolleH
original String: WakeUp, reversed String pUekaW
original String: Band, reversed String dnaB



Read more: https://www.java67.com/2012/12/how-to-reverse-string-in-java-stringbuffer-stringbuilder.html#ixzz8hjBAttXE

Insertion Sort Algorithm in Java with Example

Insertion sort is another simple sorting algorithm like Bubble Sort. You may not have realized but you must have used Insertion sort in a lot of places in your life. One of the best examples of Insertion sort in the real-world is, how you sort your hand in playing cards. You pick one card from the deck, you assume it's sorted, and then we insert subsequent cards in their proper position. For example, if your first card is Jack, and the next card is Queen then you put the queen after Jack. Now if the next card is King, we put it after the queen, and if we get 9, we put it before jack.



So if you look closely, Insertion sort is a perfect sorting algorithm to insert a new value into an already sorted array. That's why the best-case complexity of insertion sort is O(n), in which case you can just insert a new number in the already sorted list of integers.



Another thing to keep in mind is the size of the list, insertion sort is very good for small list or array, but not so for a large list, where QuickSort, MergeSort, and HeapSort rules.

Let's see one more example of insertion sort from real life. Have you noticed, how do tailors arrange customers' shirts in their wardrobe, according to size. So they insert a new shirt at the proper position, for that, they shift existing shirts until they find the proper place.

If you consider wardrobe as an array and shirts as an element, you will find out that we need to shift existing elements to find the right place for the new element. This is the core of the insertion sort algorithm, if you understand these examples, even you can come up with a step-by-step coding algorithm to sort an array of an integer using insertion sort in Java.

In this article, we will learn that by first understanding insertion sort with flowchart and by walking through an example. After that writing, a Java method to do insertion sort will be very easy.

Btw, If you are a complete beginner into data structure and algorithms then I suggest you join a comprehensive course like Data Structures and Algorithms: Deep Dive Using Java on Udemy, which will not only teach you the Insertion sort algorithms but also other essential data structure and sorting algorithms. It's one of my favorite courses on this topic





How the Insertion Sort Algorithm works
If you know how to sort a hand of cards, you know how insertion sort works; but for many programmers, it's not easy to translate real-world knowledge into a working code example.

This is where natural programming ability comes into play. A good programmer has the ability to code any algorithm and convert a real-life example to an algorithm.

Now, how do you sort an array of an integer using this algorithm? You can say that we can treat this array as a deck of cards, and we will use another array to pick and place an element from one place to another. Well, that will work, but it's a waste of space (memory) because what you are doing is comparing and shifting, which can also be done in place in the same array.

Here is the step by step guide to coding insertion sort algorithm in Java:



1) Consider the first element is sorted and it's in the proper place, that is index 0 for your array.

2) Now go to the second element (index 1 in the array), and compare it with what is in your hand (the part of the array, which is already sorted). This means you compare this element going backward towards index zero.

3) If the current number is smaller than the previous number (which is in the proper place), we need to put our current number before that. How will we do that? Well for that we need to shift the existing number.

But what if there is another element that is greater than our current element? It means we need to continue comparing until we found a proper place for our current number, which again means current number> existing number or we are at the start of the list (index 0 in the array).



4) You need to repeat this process for all the numbers in the list. Once you finish that, you have a sorted list or array.

In short, insertion sort is all about finding the proper place for the current number. Once you find the proper place, you need to shift the existing element to make a place for this new number.  If you want to learn more about Insertion sort and other sorting algorithms, you can also see the course Algorithms and Data Structures - Part 1 and 2 or a good book like Algorithms in Nutshell which is fantastic course to learn important Computer Science Algorithms.

http://www.amazon.com/Algorithms-Nutshell-In-OReilly/dp/059651624X?tag=javamysqlanta-20




A Visual Explanation of Insertion Sort Algorithm
It's said that "A picture is worth a thousand words", this is quite true in the case of understanding sorting algorithms. Earlier we had seen how easy it was to understand the QuickSort algorithm using a GIF image, and now we will again learn how Insertion sort works by following this diagram, It becomes extremely easy to explain how insertion sort works with this example.

Here we have an integer array of both positive and negative numbers in random order. Our task is to sort this unsorted array using Insertion Sort in ascending order, which means the smallest element should be at the start of the array and the largest element must be at the end of the array.




To start working we assume that our first element is in the proper position (remember the first card in your hand) and start with the second integer, which is  -5. Now we compare it with 7, since - 5 is less than 7, we first move 7 in place of -5.

After this, we don't need to compare -5 with any other number because we have reached the left boundary so we will put -5 at the current place. Now, we pick the third element which is 2. We compare 2 with 7 and found that 2 is also less than 7, which means 7 shifted in place of 2.

Next, we compare 2 with -5, now 2 is greater than -5 so we insert it at this place. After this, we pick the fourth element which is 16. Since 16 is greater than 7, no need to shift anyone, 16 will remain in its place.

Now last element 4, it is less than 16 to 16 will move in place of 4, next we compare 4 with 7, again 4 is less than so 7 will be shifted, after this we compare 4 with 2, wow it's greater than 2, so we have found a proper place for 4. We insert 4 there. Now there is no more element to process an array, so our array is now sorted.

Explanation of How Insertion Sort Algorithm works

You can see that at the last step our array is sorted in increasing order, starting from - 5 and ending at 16.

By the way, algorithms can be better understood by looking at a flowchart or a real example with numbers or by joining a good online course like Visualizing Data Structures and Algorithms in Java, which is also a great way to learn basic data structure and algorithms.


Insertion Sort in Java with Example
It's very easy to implement Insertion sort in Java.  All you need to do is to iterate over the array and find the proper position of each element, for that you need to shift the element and you can do it by swapping. The logic of sorting integer array using the insertion sort algorithm is inside method insertionSort(int[]).

In Java you can also sort any object e.g. String using this algorithm, all you need to do is to use a Comparable interface because that will provide you mechanism to compare two objects. Now instead of using > (greater than) or < (less than) operator, we need to use compareTo() method.



For this, we have decided to overload our insertionSort() method, where an overloaded version takes an Object array instead of an int array. Both methods sort elements using insertion sort logic.

By the way, in the real world, you don't need to reinvent the wheel, java.util.Arrays class provides several utility methods to operate upon arrays and one of them is sort.

There is a couple of overloaded version of sort() method available to sort primitive and object arrays. This method uses double-pivot QuickSort to sort the primitive array and MergeSort to sort object array.

Anyway, here is our complete code example to run the Insertion sort in Java. If you are using Eclipse IDE then just copy-paste the code in the src folder of your Java project and Eclipse will create packages and source files with the same name by itself. All you need to do is that run it as a Java program.


import java.util.Arrays;

/**
 * Java program to sort an array using Insertion sort algorithm.
 * Insertion sort works great with already sorted, small arrays but 
 * not suitable for large array with random order.
 *
 * @author Javin Paul
 */
public class InsertionSort {

  public static void main(String args[]) {

  // getting unsorted integer array for sorting
  int[] randomOrder = getRandomArray(9);
  System.out.println("Random Integer array before Sorting : " 
                          + Arrays.toString(randomOrder));

  // sorting array using insertion sort in Java
  insertionSort(randomOrder);
  System.out.println("Sorted array uisng insretion sort : " 
                            + Arrays.toString(randomOrder));

  // one more example of sorting array using insertion sort
  randomOrder = getRandomArray(7);
  System.out.println("Before Sorting : " + Arrays.toString(randomOrder));
  insertionSort(randomOrder);
  System.out.println("After Sorting : " + Arrays.toString(randomOrder));

  // Sorting String array using Insertion Sort in Java
  String[] cities = {"London", "Paris", "Tokyo", "NewYork", "Chicago"};
  System.out.println("String array before sorting : "
                           + Arrays.toString(cities));
  insertionSort(cities);

  System.out.println("String array after sorting : " 
                           + Arrays.toString(cities));
  }

  public static int[] getRandomArray(int length) {
    int[] numbers = new int[length];
    for (int i = 0; i < length; i++) {
      numbers[i] = (int) (Math.random() * 100);
    }
    return numbers;
  }

  /*
  * Java implementation of insertion sort algorithm to sort
  * an integer array.
  */
  public static void insertionSort(int[] array) {
  // insertion sort starts from second element
  for (int i = 1; i < array.length; i++) {
    int numberToInsert = array[i];

    int compareIndex = i;
    while (compareIndex > 0 && array[compareIndex - 1] > numberToInsert) {
       array[compareIndex] = array[compareIndex - 1]; // shifting element
       compareIndex--; // moving backwards, towards index 0
    }

    // compareIndex now denotes proper place for number to be sorted
     array[compareIndex] = numberToInsert;
   }
 }

  /*
  * Method to Sort String array using insertion sort in Java.
  * This can also sort any object array which implements
  * Comparable interface.
  */
  public static void insertionSort(Comparable[] objArray) {
  // insertion sort starts from second element
  for (int i = 1; i < objArray.length; i++) {
      Comparable objectToSort = objArray[i];

      int j = i;
      while (j > 0 && objArray[j - 1].compareTo(objectToSort) > 1) {
         objArray[j] = objArray[j - 1];
         j--;
      }
     objArray[j] = objectToSort;
   }
 }

}

Output:
Random Integer array before Sorting : [74, 87, 27, 6, 25, 94, 53, 91, 15]
Sorted array uisng insretion sort : [6, 15, 25, 27, 53, 74, 87, 91, 94]
Before Sorting : [71, 5, 60, 19, 4, 78, 42]
After Sorting : [4, 5, 19, 42, 60, 71, 78]
String array before sorting : [London, Paris, Tokyo, NewYork, Chicago]
String array after sorting : [Chicago, London, NewYork, Paris, Tokyo]


Another useful thing to learn from this example is how to generate Random numbers in Java. You can see that our getRandomArray(int length) method creates a random array of a given length.

This uses the static utility method Math.random() which returns a double value between 0.0 to 0.1, if you need to convert it to an integer, in the range of 0 to 99, you need to multiply it with 100. After that, you can cast it to int to get rid of decimals.

That's all about the Insertion sort in Java. It's one of the really beautiful algorithms and works best for the already sorted list. It has lots of practical uses but has limitations also. You should not use Insertion sort for sorting a big list of numbers, as its best-case performance is in order of O(n), which can be very high for a list of say 1 million integers.

To short those lists, you need sorting algorithms that have logarithmic complexity e.g. quicksort, mergesort, or heapsort, which provides the best-case complexity of O(nLogn), because log reduces the power of 10^n into n like 1 million will become 10^6 means 6.

In order to remember the Insertion sort algorithm, just remember how you sort your hand in poker or any card game. If that is tough, just remember how you arrange your shirts in the wardrobe.


Read more: https://www.java67.com/2014/09/insertion-sort-in-java-with-example.html#ixzz8hjBV76OE

[Solved] 2 Ways to Find Duplicate Elements in a given Array in Java - Example

Hello guys, today, you will learn how to solve another popular coding problem. You have given an array of objects, which could be an array of integers and or an array of Strings or any object which implements the Comparable interface. How would you find duplicate elements from an array? Can you solve this problem in O(n) complexity? This is actually one of the frequently asked coding questions from Java interviews. There are multiple ways to solve this problem, and you will learn two popular ways here, first the brute force way, which involves comparing each element with every other element, and other which uses a hash table-like data structure to reduce the time complexity of the problem from quadratic to linear, of course by trading off some space complexity.


This also shows how by using a suitable data structure, you can come up with a better algorithm to solve a problem. That's why a good knowledge of Data Structure and Algorithms are very important for all programmers.

If you are new to the programming world or want to refresh your knowledge about essential data structures like an array, string, linked list, hash table, binary tree, balanced tree, stack, queue, priority queue, etc then I suggest you go through a comprehensive data structure and algorithms course.

According to Data Structures and Algorithms: Deep Dive Using Java course  learning all essential data structures and algorithms like searching, sorting, and graph-based algorithms can make you better developer and also help in cracking coding interviews. 






How to find duplicates in a given array on O(n^2)
In the first solution, we compare each element of the array to every other element. If it matches then its duplicate and if it doesn't, then there are no duplicates. This is also known as a brute force algorithm to find duplicate objects from Java array.

The time complexity of this problem is O(n^2) or quadratic. When you give this solution to your interviewer, he will surely ask you to come up with O(n) time complexity algorithm, which we will see next.

Here is the code to find duplicate elements using a brute force algorithm in Java:
In this program, instead of printing the duplicate elements, we have stored them in a Set and returned from the method, but if the interviewer doesn't ask you to return duplicates, then you can simply print them into the console as I have done in next solution.

public static Set<Integer> findDuplicates(int[] input) {
        Set<Integer> duplicates = new HashSet<Integer>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    // duplicate element found
                    duplicates.add(input[i]);
                    break;
                }
            }
        }

        return duplicates;
    }


If you are preparing for programming job interviews, then I also suggest you take a look at the Grokking the Coding Interview: Patterns for Coding Questions course on Educative, which contains many popular patterns for solving coding problems. This means you don't need to solve 100+ Leedcode problems but just need to learn a few patterns which are applicable to many programming problems.
How to find duplicate elements in an Array - Java





How to Find duplicates in array in O(n) time Complexity
The second solution demonstrates how you can use a suitable data structure to come up with a better algorithm to solve the same problem. If you know, in Java, the Set interface doesn't allow duplicates, and it's based upon hash table data structure, so insertion takes O(1) time in the average case.



By using HashSet, a general-purpose Set implementation, we can find duplicates in O(n) time. All you need to do is iterate over an array using advanced for loop and insert every element into HashSet. Since it allows only unique elements, add() method will fail and return false when you try to add duplicates.



Bingo, you have to find the duplicate element, just print them off to console, as shown in the following program:

public static <T extends Comparable<T>> void getDuplicates(T[] array) {
        Set<T> dupes = new HashSet<T>();
        for (T i : array) {
            if (!dupes.add(i)) {
                System.out.println("Duplicate element in array is : " + i);
            }
        }

    }
This solution also demonstrates how you can use Generics to write type-safe code in Java. This method will work on any type of Java array, like Array with Integer, Array with String or any object which implements Comparable interface, but will not work with a primitive array because they are not objects in Java.

If you are preparing for programming job interviews, then I also suggest you take a look at the Cracking the Coding Interview book by Gayle McDowell, which contains 189 programming questions and solutions, good enough to do well on any programming job interviews like Java, C++, Python or Ruby.

How to find duplicate elements in Java array coding



Java Program to find duplicate elements in Java using Generics
Here is the Java program to combine both solutions, you can try running this solution on Eclipse IDE and see how it works. You can also write the JUnit test to see our solution work in all cases, especially corner cases like an empty array, array with null, etc.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static java.lang.System.*;

/**
 * Java Program to find duplicate elements in an array. In this program, you
 * will learn two solution to find duplicate elements in integer array e.g.
 * brute force, by using HashSet data structure.
 * 
 * @author java67
 */

public class DuplicatesFromArray{

    public static void main(String args[]) {
        int[] withDuplicates = { 1, 2, 3, 1, 2, 3, 4, 5, 3, 6 };
        Set<Integer> duplicates = findDuplicates(withDuplicates);
        out.println("input array is : " + Arrays.toString(withDuplicates));
        out.println("Duplicate elements found in array are : " + duplicates);

        // now calling our generic method to find duplicates        
        String[] myArray = { "ab", "cd", "ab", "de", "cd" };
        out.println("input string array is : " + Arrays.toString(myArray));
        getDuplicates(myArray);
    }

    /**
     * Complexity of this solution is O(n^2)
     * 
     * @param input
     * @return
     */
    public static Set<Integer> findDuplicates(int[] input) {
        Set<Integer> duplicates = new HashSet<Integer>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    // duplicate element found
                    duplicates.add(input[i]);
                    break;
                }
            }
        }

        return duplicates;
    }

    /**
     * Generic method to find duplicates in array. Complexity of this method is
     * O(n) because we are using HashSet data structure.
     * 
     * @param array
     * @return
     */
    public static <T extends Comparable<T>> void getDuplicates(T[] array) {
        Set<T> dupes = new HashSet<T>();
        for (T i : array) {
            if (!dupes.add(i)) {
                System.out.println("Duplicate element in array is : " + i);
            }
        }

    }

}

Output :
input array is : [1, 2, 3, 1, 2, 3, 4, 5, 3, 6]
Duplicate elements found in array are : [1, 2, 3]
input string array is : [ab, cd, ab, de, cd]
Duplicate element in array is : ab
Duplicate element in array is : cd

That's all about how to find duplicate elements in an array. You have now learned two ways to solve this problem in Java. The first solution is the brute force algorithm, which is demonstrated by finding duplicate elements on integer array, but you can use the logic to find a duplicate on any kind of array. The second solution uses the HashSet data structure to reduce the time complexity from O(n^2) to O(n), and it also shows you can write generic methods to find duplicates on any object array.


Read more: https://www.java67.com/2015/10/2-ways-to-find-duplicate-elements-in-java-array.html#ixzz8hjBcbhKy

How to check if Array contains given Number or String in Java [ Linear Search vs Binary Search]

Hello guys, one of the common coding questions from Java interviews is how to test if an Array contains a certain value or not? This is a simple question, but sometimes interview pressure makes candidates nervous. In this article, you'll learn how to solve this problem using different approaches. Since an array in Java doesn't have any inbuilt method for searching values, interviewers prefer to ask this question, to see how a candidate deals with such a situation. If you have good knowledge of Java API, then you will immediately come to know that there are alternatives available like using the binarySearch() method of Java Java .util.Arrays class or taking advantage of ArrayList contains method by first converting your array to ArrayList.


If you come up with those solutions, the Interviewer will surely ask you to write down a method to search an element in an array without using any library method. For that, you need to remember your Data structure and algorithm classes. You can easily solve this question if you know the linear search or binary search algorithm.

Linear search is very simple to implement, all you need to do is loop through the array and check each value if that is the one or not.



Binary search is a little tricky but not too difficult either, the recursive solution is very natural as well. In this tutorial, though I have given two solutions, one is using ArrayList, and the second is using linear search, leaving binary search an exercise for you. But you must remember to sort the array before using binary search.

That's where a good knowledge of essential Data Structures and Algorithms comes to the rescue. I strongly suggest every Java developer brush up on their Data structure and algorithm skills before going for any kind of programming interview. If you need a resource, I recommend Data Structures and Algorithms: Deep Dive Using Java course by Tim Buchalaka on Udemy.

It's very affordable and covers all essential data structures like the array, linked list, binary tree, hash table, stack, queue, and others.





How to check if an array contains a given value in Java?
To give you some more idea of the problem, let's see an example first; suppose you have a String[] with values like so:

public static final String[] names = new String[] {"Java","JEE","Scala","C++"};

Given the String name, you need to return true or false, depending upon whether names contain that value or not. By the way, here is a full example of how to search a number on an integer array and searching for a name on String array, in case you need any help.



This example contains two methods isExists() and contains(), which returns true if the value is present in the array. The first method uses contains() method of ArrayList by first converting given an array to ArrayList, while the second method simply uses a linear search algorithm to search on a Java array.

By the way, to make the question more challenging, I usually asked the candidate to write a parametric method using generic so that it will work for any type of object array in Java. If you are interested, you can try solving that version as well.



In case, if you are not familiar with Generics and writing Parametric class and methods in Java then I suggest you join a comprehensive Java course like The Complete Java Masterclass on Udemy to learn Generics better. It's very important for writing production-quality Java code.


How to test if an Array contains a value in Java - Linear Search





Java Program to Search String or Integer in Given Array
Without wasting any more of your time, here is our complete Java program to search any given String or integer value in the given array. If you are using Eclipse IDE, just copy-paste the code and run it, you don't need to create a Java source file, Eclipse will take care of that, provided you have selected a Java project.



import java.util.Arrays;
/**
* Java Program to check if an array contains a value or not. Basically this program tells you
* how to search for an element in array, it could be an integer number or String value. 
*
* @author Javin Paul
*/
public class ArrayTest{

    public static void main(String args[]) {

        //test our method to see if array contains a certain value or not
        Integer[] input = new Integer[]{1, 2, 3, 4, 5};
        System.out.printf("Does array %s has %s?  %b %n",
                          Arrays.toString(input), 5, isExists(input, 5));
        System.out.printf("Does array %s contains %s?  %b %n", 
                          Arrays.toString(input), 5, contains(input, 5));
        System.out.printf("Does array %s has %s?  %b %n", 
                          Arrays.toString(input), 6, isExists(input, 6));
        System.out.printf("Does Integer array %s contains %s?  %b %n", 
                          Arrays.toString(input), 6, contains(input, 6));

        String[] names = new String[]{"JP", "KP", "RP", "OP", "SP"};
        System.out.printf("Does array %s has %s?  %b %n", 
                          Arrays.toString(names), "JP", isExists(names, "JP"));
        System.out.printf("Does String array %s contains %s?  %b %n", 
                          Arrays.toString(names), "JP", contains(names, "JP"));
        System.out.printf("Does array of names %s has %s?  %b %n",
                          Arrays.toString(names), "MP", isExists(names, "MP"));
        System.out.printf("Does array %s contains %s?  %b %n",
                          Arrays.toString(names), "UP", contains(names, "UP"));

    }

    /**
     * Function to test if Array contains a certain value or not. 
     * This method take advantage of
     * contains() method of ArrayList class, by converting array to ArrayList.
     *
     * @return true if array contains 
     */
    public static <T> boolean isExists(final T[] array, final T object) {
        return Arrays.asList(array).contains(object);
    }


   /**
     * Another method to search an item in Java array. 
     * This method loop through array and use
     * equals() method to search element. This actually performs 
     * a linear search over array in Java
     *
     *@return true if array has provided value.
     */
    public static <T> boolean contains(final T[] array, final T v) {
        for (final T e : array) {
            if (e == v || v != null && v.equals(e)) {
                return true;
            }
        }

        return false;
    }

}

Output:
Does array [1, 2, 3, 4, 5] has 5?  true
Does array [1, 2, 3, 4, 5] contains 5?  true
Does array [1, 2, 3, 4, 5] has 6?  false
Does Integer array [1, 2, 3, 4, 5] contains 6?  false
Does array [JP, KP, RP, OP, SP] has JP?  true
Does String array [JP, KP, RP, OP, SP] contains JP?  true
Does array of names [JP, KP, RP, OP, SP] has MP?  false
Does array [JP, KP, RP, OP, SP] contains UP?  false

You can see the result as true or false if the array contains a particular value or not. Like in the first output array contains 5 so the result is true, but in the third example, the array doesn't contain 6, so the result is false.

How to check if array contains a particular value in Java



That's all on how to find if an array contains a particular value or not. As I told you, if you are allowed to use Java API, then you can either use the binarySearch() method of Java Java .util.Arrays class or you can simply convert your array to ArrayList and then call its contains() method.

If using Java API or any third party is not allowed, then you can write your own function to search an element in an array using either binary search or linear search method. If you write binary search, then be prepared with both iterative and recursive methods, as the Interviewer will more likely to ask both of them.


Read more: https://www.java67.com/2014/11/how-to-test-if-array-contains-certain-value-in-java.html#ixzz8hjBpkt4p


How to Remove an Element from Array in Java with Example

There is no direct way to remove elements from an Array in Java. Though Array in Java objects, it doesn't provide any methods to add(), remove(), or search an element in Array. This is the reason Collection classes like ArrayList and HashSet are very popular. Thanks to Apache Commons Utils, You can use their ArrayUtils class to remove an element from the array more easily than by doing it yourself. One thing to remember is that Arrays are fixed size in Java, once you create an array you can not change their size, which means removing or deleting an item doesn't reduce the size of the array. This is, in fact, the main difference between Array and ArrayList in Java.



What you need to do is create a new array and copy the remaining content of this array into a new array using System.arrayCopy() or any other means. In fact, all other APIs and functions you will use do this but then you don't need to reinvent the wheel. 

For an Object or Reference array, you can also convert Array to List and then remove a particular object and convert List back to the array. One way to avoid this hassle is by using ArrayList instead of Array in the first place.

Btw, if you are a complete beginner in the Java world and don't know much about Java API, particularly the Java Collection framework which provides ready-made classes for common data structure like an array, list, set, hash table, stack, queue, etc, I suggest you to first go through these free Java courses from Coursera and Udemy.



It's one of the most comprehensive courses and covers Java from length to breadth. It's also the most up-to-date course and recently updated for the latest Java version.





How to delete an element from Array in Java
Here is a complete code example of how to remove an element from Array in Java. In this example, we have used a primitive array, particularly int array and Apache commons ArrayUtils to remove an integer based on its index.

The ArrayUtils also provided several overloaded remove() methods for the different types of primitive arrays like int, long, float, and double.

Btw, if you are not familiar with array data structure itself, like it stores elements in a contiguous memory location, provides fast search capability in O(1) time if you know the index and adding and removing elements is very difficult then I also suggest you go through a comprehensive data structure and algorithm course like Data Structures and Algorithms: Deep Dive Using Java on Udemy.

How to Remove an Element from Array in Java with Example


It's one of the most important topics and you just cannot afford to ignore it. This is also your first step towards becoming the better computer Programmer you always wanted to be.

Anyway, here is our Java program to delete an array from a primitive array in Java:

import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * Java program to show how to remove element from Array in Java
 * This program shows How to use Apache Commons ArrayUtils
 * to delete elements from primitive array.
 *
 * @author http://java67.com
 */
public class RemoveObjectFromArray{

    public static void main(String args[]) {
                 
        //let's create an array for demonstration purpose
        int[] test = new int[] { 101, 102, 103, 104, 105};
     
        System.out.println("Original Array : size : "
                               + test.length );
        System.out.println("Contents : " + Arrays.toString(test));
     
        // let's remove or delete an element from an Array
        // using Apache Commons ArrayUtils
        test = ArrayUtils.remove(test, 2); //removing element at index 2
     
        // Size of an array must be 1 less than the original array
        // after deleting an element
        System.out.println("Size of the array after
                  removing an element  : " + test.length);
        System.out.println("Content of Array after
                 removing an object : " + Arrays.toString(test));
     
    }
 
}

Output:
Original Array: size: 5
Contents : [101, 102, 103, 104, 105]
Size of the array after removing an element: 4
Content of Array after removing an object : [101, 102, 104, 105]


Read more: https://www.java67.com/2012/12/how-to-remove-element-from-array-in-java-example.html#ixzz8hjBwmeRv

How to find largest and smallest number from integer array - Java Solution

Hello guys, if you have gone through any coding interview or have done some professional Software development then you know that a good understanding of array data structure is crucial for any software developer but it doesn't come for free, you need to spend time and effort. The best way to develop this understanding by solving coding problems and there are lots of programming exercises beginners can do. One of them is writing a program to find the smallest and largest number in an integer array. Java programmers are no different than others, so they can do this program in Java, not just to understand array but also different relational operators available in Java.  



In this program, you need to write a method, yes we call the function a method in Java, which will accept an integer array and then print the largest and smallest number from that array. Use of any third-party library or API method is not allowed, which means you need to do this exercise by using essential tools of Java programming language, which includes operators, control statements, keywords, and some classes from java.lang package.

This problem is also known as finding maximum and minimum numbers in an array, and the technique mentioned here can be used in any other programming language as well. As a bonus point, you can also write JUnit test cases to test your method, I have not done so and relied on a simple main method to test my code to show the output and keep it short, essential for any example or demo.

Btw, if you preparing for a programming job interview, then let me repeat that a good knowledge of essential data structures like an array, linked list, binary tree, the hash table goes a long way in doing well on the interview. You should spend some time learning those and filling gaps in your understanding.






Java Program to find the smallest and largest number in an integer array 
Here is a full code example of a Java program to find the smallest and largest number from an integer array. You can create a Java source file with the name MaximumMinimumArrayDemo.java and copy code there to compile and execute it in your favorite IDE. 

If you don't have an IDE setup, you can also compile and run this program by following the steps I have shown on HelloWorld in Java.

If you look at the code here, we have created a method called the largestAndSmallest(int[] numbers)  to print the largest and smallest number from the int array passed to the program.  We have used two variables largest and smallest, to store the maximum and minimum values from the array.



Initially, the largest is initialized with Integer.MIN_VALUE and smallest are initialized with Integer.MAX_VALUE.In each iteration of the loop, we compare the current number with the largest and smallest and update them accordingly.

Since if a number is larger than the largest, it can't be smaller than the smallest, which means you don't need to check if the first condition is true, that's why we have used if-else code block, where else part will only execute if the first condition is not true.

Here is another logical diagram or flow chart to find the largest element from an array in Java, here instead of assigning the variable with Integer.MAX_VALUE, we have assigned the first element from the array.

How to find maximum and minimum number from integer array Java



Since the array doesn't override the toString method in Java, we have used Arrays.toString() to print the contents of an array. Remember, this function is outside of core logic, so it's ok to use it. Since this is a static method, we can directly call this from the main method in Java, and so does our test code.

We pass the random array to this method and see if the largest and smallest number returned by the method is correct or not. For automated testing, a Unit test is better, but for a demonstration, you can use the main method.

Btw, if you preparing for a programming job interview, then don't forget to check the Cracking the Coding Interview book. It contains 189 Programming Questions and Solutions, which is more than enough for many coding interviews.


Java Program to find the largest and smallest element in an array:
Here is the Java program I am talking about. This shows you how to find the maximum and minimum number in a given array in Java, without using any library method. 
import java.util.Arrays;
/**
 * Java program to find largest and smallest number from an array in Java.
 * You cannot use any library method both from Java and third-party library.
 *
 * @author http://java67.com
 */
public class MaximumMinimumArrayDemo{

    public static void main(String args[]) {
        largestAndSmallest(new int[]{-20, 34, 21, -87, 92,
                             Integer.MAX_VALUE});
        largestAndSmallest(new int[]{10, Integer.MIN_VALUE, -2});
        largestAndSmallest(new int[]{Integer.MAX_VALUE, 40,
                             Integer.MAX_VALUE});
        largestAndSmallest(new int[]{1, -1, 0});
    }

    public static void largestAndSmallest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            } else if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("Given integer array : " + Arrays.toString(numbers));
        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }
}
Output:
Given integer array : [-20, 34, 21, -87, 92, 2147483647]
Largest number in array is : 2147483647
Smallest number in array is : -87
Given integer array : [10, -2147483648, -2]
Largest number in array is : 10
Smallest number in array is : -2147483648
Given integer array : [2147483647, 40, 2147483647]
Largest number in array is : 2147483647
Smallest number in array is : 40
Given integer array : [1, -1, 0]
Largest number in array is : 1
Smallest number in array is : -1


Read more: https://www.java67.com/2014/02/how-to-find-largest-and-smallest-number-array-in-java.html#ixzz8hjCEUBJ5

1. Problem - How to Find more than missing numbers in Array with Duplicates?
You have given an integer array of size N. Array contains numbers from 1 to N-1 but a couple of numbers are missing in an array which also contains duplicates.

Write a Java program to print the missing number from the sequence.



For example, if the given array is {1, 1, 2, 3, 5, 5, 7, 9, 9, 9} then it has length 10 and contains a number from 1 to 9. In this case, missing numbers are 4, 6, and 8.



2. The solution to finding missing numbers from the given array
When you see the question is to find the missing number in an array, you might think about our earlier solution of calculating the sum of all the numbers and deducting it from the expected sum to find the missing number, but unfortunately, that will not work in this situation because more than one number is missing as well it contains duplicates.

In this case, we need to use a different approach, something like a roll-call you would have seen in your school.

The teacher has a register with the names of all students, he goes through the list and marks absences on red. We can use the same approach to find all the missing numbers in the list.

We can use an array as register and it's an index as names of the numbers. You need to loop through the given array and tick marking all the numbers which are present by storing one of their respective indices. For example, if the first number in the given array is 5 (since the array is not sorted) then we store 1 on index 5 e.g. register[5] = 1



Once we have gone through all the numbers is given, we can go through our register array and print all the indices where the value is zero. These are absentees or missing numbers.



This solution is also safe from duplicates because if a number comes once or twice we just store 1 on the respective index.

Btw, if you are not familiar with array and essential data structure like a linked list, binary tree, and hash table, I suggest you first go through Data Structures and Algorithms: Deep Dive Using Java to build a foundation.

Find Multiple Missing Integers in Given Array of Numbers with Duplicates in Java?



3. Code
Now that we know how to solve this problem of missing numbers in unsorted integer array with duplicates, it's time to turn this solution into the code and working Java program.

/*
 * Java Program to find missing numbers in an integer
 * array with duplicates. Array may contains more
 * than one duplicates.
 * 
 * input: {1, 1, 2, 3, 5, 5, 7, 9, 9, 9};
 * output: 4, 6, 8
 */
public class Hello {

  public static void main(String[] args) {

    // given input
    int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };

    // let's create another array with same length
    // by default all index will contain zero
    // default value for int variable

    int[] register = new int[input.length];

    // now let's iterate over given array to
    // mark all present numbers in our register
    // array

    for (int i : input) {
      register[i] = 1;
    }

    // now, let's print all the absentees
    System.out.println("missing numbers in given array");

    for (int i = 1; i < register.length; i++) {
      if (register[i] == 0) {
        System.out.println(i);
      }
    }
  }

}
Output
missing numbers in given array
4
6
8


This is the simplest Java program to solve this problem. You can see that we have hardcoded the input array but you can also modify the program to get input from the user by using Scanner class as shown in this example.

The code is exactly the same as a solution, we created another array by copying length from the original array and used it mark numbers that are present.



Since array indices are also an integer and they are in the range of input values we can leverage them to use both as data and metadata. Had the array contains a number which is not in the range of 1 to N-1 then we couldn't have used an array. If you want to know more about the array data structure, you can also see Algorithms and Data Structures - Part 1 and 2 courses on Pluralsight.

Here is the summary of the algorithm and code in a slide for better understanding:





4. Analysis and Explanation of Logic
Now, the time is to analyze our solution to find the CPU and Memory complexity using Big O notation. If you look at the code then you will find that we are creating another array with the same size which means it has memory or space complexity of O(n).

This means if the array is too big like contains all the numbers in the integer range then we would a lot more memory which may not be available and our program could throw OutOfMemoryError in Java. This is even more possible because array needs a contiguous chunk of memory.

So, if we can remove the additional array which is not really holding anything and find a way to just store missing numbers which is quite less than all the numbers that we can improve this solution, something for you guys to think.



For time complexity, you can see that we iterate through the whole array to mark all present numbers and then iterate again to another array of the same length to find absentees. This means the time complexity of this solution is O(n) + O(n) or O(2N) which is in Big O Notation still O(n).

Read more: https://javarevisited.blogspot.com/2018/04/how-to-find-k-missing-numbers-in-array-java.html#ixzz8hjCOWB9Z


1. How to find the missing number in integer array of 1 to 100? (solution)
This is one of the most simple array problems you will see, mostly asked in a telephonic round of Interview. You have given an integer array which contains numbers from 1 to 100 but one number is missing, you need to write a Java program to find that missing number in an array. 

You cannot use any open source library or Java API method which solves this problem. 

One trick to solve this problem is to calculate sum of all numbers in the array and compare with expected sum, the difference would be the missing number.

Array Interview Questions and Answer Java C++



2. How to find duplicate number on Integer array in Java? (solution)
An array contains n numbers ranging from 0 to n-2. There is exactly one number is repeated in the array. You need to write a program to find that duplicate number. For example, if an array with length 6 contains numbers {0, 3, 1, 2, 3}, then duplicated number is 3. 

Actually, this problem is very similar to previous one and you can apply the same trick of comparing actual sum of an array to expected sum of series to find out that duplicate. 

This is generally asked as follow-up question of previous problem.




3. How to check if array contains a number in Java? (solution)
Another interesting array problem, because array doesn't provide any built-in method to check if any number exists or not. This problem is essentially how to search an element in the array. There are two options sequential search or binary search. 

You should ask the interviewer about whether an array is sorted or not, if the array is sorted then you can use binary search to check if given number is present in an array or not. The complexity of binary search is O(logN). 

BTW, if interviewer says that array is not sorted then you can still sort and perform binary search otherwise you can use sequential search. Time complexity of sequential search in array is O(n).


4. How to find largest and smallest number in unsorted array? (solution)
This is a rather simple array interview question. You have given an unsorted integer array and you need to find the largest and smallest element in the array. 

Of course, you can sort the array and then pick the top and bottom element but that would cost you O(NLogN) because of sorting, getting element in array with index is O(1) operation.


5. How to find all pairs on integer array whose sum is equal to given number? (solution)
This is an intermediate level of array coding question, it's neither too easy nor too difficult. You have given an integer array and a number, you need to write a program to find all elements in the array whose sum is equal to the given number. 

Remember, the array may contain both positive and negative numbers, so your solution should consider that. 

Don't forget to write unit test though, even if the interviewer is not asked for it, that would separate you from a lot of developers. Unit testing is always expected from a professional developer.


6.   How to find repeated numbers in an array if it contains multiple duplicates? (solution)
This is actually the follow-up question of problem 2, how to find a duplicate number on integer array. In that case, an array contains only one duplicate but what if it contains multiple duplicates? 

Suppose, an array contains n numbers ranging from 0 to n-1 and there are 5 duplicates on it, how do you find it? You can use the approach, we have learned in similar String based problem of finding repeated characters in given String.


7. Write a program to remove duplicates from array in Java? (solution)
This is another follow-up question from problem 2 and 6. You have given an array which contains duplicates, could be one or more. You need to write a program to remove all duplicates from array in Java. 

For example if given array is {1, 2, 1, 2, 3, 4, 5} then your program should return an array which contains just {1, 2, 3, 4, 5}. 

This array question is also comes at intermediate category because there is no way to delete an element from an array. If substituting with another value is not an option then you need to create another array to mimic deletion.



8. How to sort an array in place using QuickSort algorithm? (solution)
You will often see sorting problems on array related questions because sorting mostly happen on array data structure. 

You need to write a program to implement in place quick sort algorithm in Java. You can implement either recursive or iterative quicksort, it's your choice but you cannot use additional buffer, array or list, you must sort array in place.


9.   Write a program to find intersection of two sorted arrays in Java? (solution)
Another interesting array interview question, where you need to treat the array as Set. Your task is to write a function in your favorite language e.g. Java, Python, C or C++ to return the intersection of two sorted arrays.

 For example, if the two sorted arrays as input are {21, 34, 41, 22, 35} and {61, 34, 45, 21, 11}, it should return an intersection array with numbers {34, 21}, For the sake of this problem you can assume that numbers in each integer array are unique.


10. There is an array with every element repeated twice except one. Find that element? (solution)
This is an interesting array coding problem, just opposite of question related to finding duplicates in array. Here you need to find the unique number which is not repeated twice. 

For example if given array is {1, 1, 2, 2, 3, 4, 4, 5, 5} then your program should return 3. Also, don't forget to write couple of unit test for your solution. This program is quite similar to finding the first non-repeated character on String because you can treat String as character array and use the same algorithm to solve this problem. 

Java Array Interview Question Answer


11. How to find kth smallest element in unsorted array? (solution)
You are given an unsorted array of numbers and k, you need to find the kth smallest number in the array. For example if given array is {1, 2, 3, 9, 4} and k=2 then you need to find the 2nd smallest number in the array, which is 2. 

One way to solve this problem is to sort the array in ascending order then pick the k-1th element, that would be your kth smallest number in array because array index starts at zero, but can you do better? 

Once you are able to solve this array coding question, you can solve many similar questions easily e.g. our next question.


12. How to find kth largest element in unsorted array? (solution)
This problem is exactly same as previous question with only difference being finding kth largest element instead of kth smallest number. For example if given array is {10, 20, 30, 50, 40} and k = 3 then your program should return 30 because 30 is the 3rd largest number in array. 

You can also solve this problem by sorting the array in decreasing order and picking k-1th element. I often seen this array question on Java interviews with 2 to 3 years experienced guys.




13 How to find common elements in three sorted array? (solution)
Now we are coming on territory of tough array questions. Given three arrays sorted in non-decreasing order, print all common elements in these arrays.

Examples:
input1 = {1, 5, 10, 20, 40, 80}
input2 = {6, 7, 20, 80, 100}
input3 = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80


14. How find the first repeating element in an array of integers? (solution)
Given an array of integers, find the first repeating element in it. We need to find the element that occurs more than once and whose index of the first occurrence is smallest.

Examples:

Input:  input [] = {10, 5, 3, 4, 3, 5, 6}
Output: 5 [5 is the first element that repeats]


15. How to find first non-repeating element in array of integers? (solution)
This array interview question is exactly opposite of previous problem, In that you need to find first repeating element while in this you need to find first non-repeating element. I am sure you can use similar approach to solve this problem, just need to consider non repeating element though.


16. How to find top two numbers from an integer array? (solution)
This is another one of the easy array questions you will find on telephonic round of Interviews, but its also little bit tricky. You are asked to find top two numbers not just the top or highest numbers? Can you think of how you would do it without sorting? before looking at solution.


17. How to find the smallest positive integer value that cannot be represented as sum of any subset of a given array? (solution)
This is another tough array question you will see on Amazon, Microsoft or Google. You have given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value that cannot be represented as sum of elements of any subset of given set. 

What makes it more challenging is expected time complexity of O(n).

Examples:

Input: {1, 3, 6, 10, 11, 15};
Output: 2


18. How to rearrange array in alternating positive and negative number? (solution)
Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. 

If there are more negative numbers, they too appear in the end of the array. This is also a difficult array problem to solve and you need lot of practice to solve this kind of problems in real interviews, especially when you see it first time. 

If you have time constraint then always attempt these kind of questions once you are done with easier ones. 

Example:

Input: {1, 2, 3, -4, -1, 4}
Output: {-4, 1, -1, 2, 3, 4}

Input: {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} 




19. How to find if there is a sub array with sum equal to zero? (solution)
There is whole set of array related questions which are based upon sub-array or only selective elements of array e.g. from some range, this is one of such problem. Here you are given an array of positive and negative numbers, find if there is a sub-array with 0 sum.

Examples:

Input: {4, 2, -3, 1, 6}
Output: true 

There is a sub-array with zero sum from index 1 to 3.

20. How to remove duplicates from array in place? (solution)
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]. 

When you see a questions which asked you do to sorting or task in place, it means you cannot use additional array or buffer, but using couple of variables is fine.


21. How to remove a given element from array in Java? (solution)
This is another array coding questions similar to previous one. Here you don't have to find and remove duplicates but a given number. In this problem you are given an array and a value, remove all instances of that value in place and return the new length. The order of elements can be changed. It doesn't matter what you leave beyond the new length. 


22. How to merge sorted array? (solution)
Given two sorted integer arrays A and B, merge B into A as one sorted array. You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively. This is another intermediate array coding question, its not as simple as previous one but neither very difficult.


23. How to find sub array with maximum sum in an array of positive and negative number? (solution)
Another array coding question based upon sub-array. Here you have to find the contiguous sub-array within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6. 


24. How to find sub array with largest product in array of both positive and negative number? (solution) 
In this problem, your task is to write a program in Java or C++ to find the contiguous sub-array within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 


25. Write a program to find length of longest consecutive sequence in array of integers? (solution)
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],

The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Challenging part of this question is that your algorithm should run in O(n) complexity. 


26. How to find minimum value in a rotated sorted array? (solution)
This is another advanced level array coding question and you should only attempt this one, once you have solved the easier ones. Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array. One follow-up question of this question is What if duplicates are allowed? Would this affect the run-time complexity? How and why?




27. Given an array of of size n and a number k, find all elements that appear more than n/k times? (solution)
Another tough array based coding questions from Interviews. You are given an array of size n, find all elements in array that appear more than n/k times. For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times. There are two elements that appear more than two times, 2 and 3.

1. Returns the largest sum of contiguous integers in the array
Example: if the input is (-10, 2, 3, -2, 0, 5, -15), the largest sum is 8

2. Return the sum two largest integers in an array

3. Given an array of integers write a program that will determine if any two numbers add up to a specified number N. Do this without using hash tables


28. How to reverse array in place in Java? (solution)
Now let's see one of the most frequently asked array interview question. You need to write a program which accepts an integer array and your program needs to reverse that array in place, which means you cannot use additional buffer or array, but one or two variables will be fine. 

Of course you cannot use any open source library or Java API method to directly solve this problem, you need to create your own logic. 

Here is one such logic to solve this problem :


Array Coding Interview Questions and Answers


29. Difference between array and linked list data structure? (answer)
This is a theoretical questions from phone interviews. There are several differences between array and linked list e.g. array stores element in contiguous memory location while linked list stores at random places, this means linked list better utilizes the places. 

Consequently, its possible to have large linked list in limited memory environment compare to array of same size. Advantage of using array is random access it provides if you know the index, while in linked list you need to search an element by traversing which is O(n) operation.


30. How to check if array contains a duplicate number? (answer)
This may look a repeated question because we have already done similar question, but in this question, most from Java interviews, you need to write a contains() like method from Collections, which returns true or false if you pass an element and it is repeated or not.


Read more: https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html#ixzz8hjCdyQm3

How to Remove Duplicates from Array without Using Java Collection API? Example

This is a coding question recently asked to one of my readers in a Java Technical interview on investment bank. The question was to remove duplicates from an integer array without using any collection API classes like Set, HashSet, TreeSet or LinkedHashSet, which can make this task trivial. In general, if you need to do this for any project work, I suggest better using the Set interface, particularly LinkedHashSet, because that also keeps the order on which elements are inserted into Set. Why Set? because it doesn't allow duplicates and if you insert duplicate the add() method of Set interface will return false. 



Now coming to this coding problem, only from a technical interview perspective, you need to do this using either loops or recursion,  depending upon what is your strongest area. 

In this article, I am sharing a naïve solution, which has lots of limitations to be considered as production quality code, it's not the best solution but still a solution to start with. 

The main problem, while dealing with an array is not finding duplicates, it's about removing them. Since an array is a static, fixed-length data structure, you can not change its length of array once created. 

This means, deleting an element from an array requires creating a new array and copying content into that array.

If your input array contains lots of duplicates then this may result in lots of temporary arrays. It also increases the cost of copying content, which can be very bad. Given this restriction, you need to come out with a strategy to minimize both memory and CPU requirements.




Java Program to remove duplicates from integer array without Collection
In this program, we have not used any collection class to remove duplicates, earlier, I had shown you a way to remove duplicates from ArrayList, which was using LinkedHashSet. You can still use that solution if the interviewer doesn't mention it without Collection specifically.

All you need to do is to convert your array into ArrayList first then subsequently create a LinkedHashSet from that ArrayList. 

In this example, we are removing duplicates from the array by not copying them into the result array, this solution is not actually deleting duplicates instead it replacing them with the default value i.e. zero.

How to Remove Duplicates from Array Without Using Java Collection API? Example


Now, let's see our Java solution for removing duplicates from integer array:

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java program to remove duplicates from this array. You don't
 * need to physically delete duplicate elements, replacing with null, or
 * empty or default value is ok.
 *
 * @author http://javarevisited.blogspot.com
 */
public class TechnicalInterviewTest {

    private static final Logger logger = LoggerFactory.getLogger(TechnicalInterviewTest.class);

    public static void main(String args[]) {

        int[][] test = new int[][]{
            {1, 1, 2, 2, 3, 4, 5},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
        }
    }

    /*
     * Method to remove duplicates from array in Java, without using
     * Collection classes e.g. Set or ArrayList. Algorithm for this
     * method is simple, it first sort the array and then compare adjacent
     * objects, leaving out duplicates, which is already in the result.
     */
    public static int[] removeDuplicates(int[] numbersWithDuplicates) {

        // Sorting array to bring duplicates together      
        Arrays.sort(numbersWithDuplicates);     
      
        int[] result = new int[numbersWithDuplicates.length];
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;

    }
}

Output :
Array with Duplicates       : [1, 1, 2, 2, 3, 4, 5]
After removing duplicates   : [1, 0, 2, 0, 3, 4, 5]
Array with Duplicates       : [1, 1, 1, 1, 1, 1, 1]
After removing duplicates   : [1, 0, 0, 0, 0, 0, 0]
Array with Duplicates       : [1, 2, 3, 4, 5, 6, 7]
After removing duplicates   : [1, 2, 3, 4, 5, 6, 7]
Array with Duplicates       : [1, 2, 1, 1, 1, 1, 1]
After removing duplicates   : [1, 0, 0, 0, 0, 0, 2]

That's all about how to remove duplicates from an array in Java without using the Collection class. As I said before, this solution is not perfect and has some serious limitations, which is an exercise for you to find out, but it should work in coding interview

Java Program to remove duplicates from Integer array without CollectionOne hint I can give is that the array itself can contain default values as duplicates e.g. 0 for int, even if you use any Magic number like Integer.MAX_VALUE, you can not be certain that they will not be part of the input.

Regarding removing duplicates permanently from the result array, one approach could be to count a number of duplicates and then create an array of the right size i.e. length - duplicates, and then copying content from the intermediate result array to the final array, leaving out elements which are marked duplicate.


Read more: https://javarevisited.blogspot.com/2014/01/how-to-remove-duplicates-from-array-java-without-collection-API.html#ixzz8hjCmEj2H

5 Differences between an array and linked list in Java

The difference between an array and a linked list is one of the frequently asked data structure and algorithm interview questions and you might have seen it before on your telephonic or face-to-face interview. It is also a very popular question during practical exams in Computer Science degree courses like B.E. and B.Tech. It's very simple and easy to answer but you just can't afford to miss this question in an interview. Both array and linked list are two of the most popular and fundamental data structures in Computer Science and Programming, and Java supports both of them.



One of the traits of a good programmer is extensive knowledge of data structure and algorithm and that's why it's very important for you to learn the difference between array and linked list data structure and understand when to use an array over a linked list and vice-versa.

Though this discussion is valid from C/C++ and other programming language perspectives, I'll give you examples and explanations in Java.

Remember, here we will not talk about ArrayList vs LinkedList in Java which is another popular core Java interview question, Instead, here we will talk about array and linked list data structure from a coding/programming interview perspective.

Btw, both are very similar because of java.util.ArrayList is based upon array and java.util.LinkedList is based upon the linked-list data structure. Once you understand these data structures you can easily answer the previous question and explain when you will use ArrayList over LinkedList and vice-versa.

Btw, If you are not familiar with basic data structures like an array, linked list, binary tree, string, etc then I suggest you first join a comprehensive data structure course like Data Structures and Algorithms: Deep Dive Using Java, which will explain all these data structures in good detail.





Difference between Array vs Linked List in Java
Here is my list of some key differences between an array and a linked list in Java. Don't try to remember these differences, instead, try to understand that by learning how array and linked list are actually implemented in any programming langue like Java or C++.

Once you understand how array and the linked list are implemented and work in any programming language e.g. Java, you can easily figure out these differences.

1. Flexibility
A linked list is more flexible than an array data structure because you can change the size of the linked list once created which is not possible with an array.

A linked list can also grow unlimited but the array cannot grow beyond its size. This is one of the most fundamental differences between an array and a linked list is that the length of the array cannot be changed once created but you can add unlimited elements into a linked list unless memory is not a constraint.


2. Memory utilization
One more significant difference between the linked list and array data structure comes from a memory perspective. the array requires a contiguous chunk of memory, which means if you want to create a large array and even if memory is available you may fail because there is no single chunk of memory that is big enough for your array.

This is a huge restriction and that's why any large array should be created at the very start of an application when you have a big chunk of memory available.



A linked list is more flexible in terms of memory as well. Since the linked list doesn't need a contiguous chunk of memory and nodes of a linked list can be scattered all around heap memory, it's possible to store more elements in the linked list than an array if you have fragmented heap space.

In short, a linked list is a better data structure for memory utilization than an array. You can also see Algorithms and Data Structures - Part 1 and 2 to learn more about the linked list data structure.

array vs linked list



3. Memory required
linked list data structure requires slightly more memory than an array because apart from data i.e. the element you store, the linked list node also stores the address of the next node.

In Java, the linked list also has object metadata overhead because each node of the linked list is an object. In short, an array requires less memory than a linked list for storing the same number of elements. See a good book in a data structure like the Algorithms 4th Edition by Robert Sedgewick for more details.

Difference between an array and linked list  data strucutre


The examples in this book are given in Java programming language, which makes it an ideal book for any Java developer.


4. Performance
Another key difference between an array and linked list data structure comes from a performance perspective, which is also the main factor to decide when to use the array over the linked list in Java.

An array gives O(1) performance for the searching element when you know the index but the linked list search is in order of O(n). So if you need fast retrieval and you know the index then you should use an array.



When it comes to the performance of adding and deleting elements then a linked list stores better than an array because adding into head or tail is O(1) operation if you have the necessary pointer but adding at a random position is O(n).


With an array, adding or removing is difficult because it requires rearranging all other elements as well.


Difference between Array and Linked List Data Structure in Java





5. Dimension and types
One of the structural differences between the linked list and array comes from their variety. The array can be multi-dimensional in Java which makes it an ideal data structure for representing matrices, 2D plain, 2D game board, terrain, etc.

On the other hand, a linked list has just one dimension but it also comes in two flavors, a singly linked list, and a doubly linked list.



The Singly linked list holds the address of the next node only and thus allows you to move only in one direction i.e. forward but the doubly linked list contains two points, one for storing the address of the next node and the other for storing the address of the previous node. Which means it allows you to traverse in both forward and backward directions.

Here is a nice summary of some key differences between array and singly linked list data structure in Java:

Difference between Array vs singly Linked List Data Structure in Java


Read more: https://www.java67.com/2017/06/5-difference-between-array-and-linked.html#ixzz8hjCsEZ3j

21 Java final modifier Interview Questions
So, what are we waiting for? let's start with the first question in this list:


1. What is the use of the final keyword in Java?
The final keyword can be used with a class, method, and variables. If it is used with class then it prevents inheritance by not allowing you to create subclasses. If it is used with methods then it prevents overriding, you cannot override a final method in Java. If it is used with variables then they are treated as constant because you cannot change their value once assigned. See here to learn more about the final modifier in Java.




2. Can we make a variable final in Java? What is different between a normal variable and final variable?
Yes, you can make a variable final in Java. The difference between normal variable and final variable comes from multiple assignments. you can re-assign value to a normal variable but you cannot change the value of a final variable once assigned. See here to learn more about when to make a variable final in Java.


3) Can we make a method final in Java? explain the difference between normal method and final method
Yes, you can make a method final in Java. The difference is in the fact that you can override a non-final method, provided it'st not private and static but you cannot override a final method in Java. See here to learn more about when to make a method final in Java.


4) Can we make local variable final in Java?
Yes, you can make local variable final in Java. In fact, this was mandatory, if you want to access the local variable inside an Anonymous class until Java 8. From Java 8 onward, you don't need to make it final but make sure you don't change the value once assigned. This is also known as an effectively final variable in Java. See Java SE 8 for Really Impatient by Cay S. Horstmann to learn more about the effectively final variable in Java.

Java Final Keyword Interview Questions and Answers


5) What is a blank final field or variable in Java?
Java allows you to create a final member variable without assignment but requires you to assign the value in either static initializer block, if member variable is static or inside every constructor, if member variable is non-static. The final variable without assignment or value is called blank final variable, the compiler will ensure that this field is initialized in every path of execution. See here to learn more about the blank final variable in Java.




6) Can you change the state of the object to which a final reference variable is pointing?
Yes, you can change the state of the object referred by a final variable. This is one of the tricky concept in Java and often cause subtle errors. One of the most common examples of this is Collection classes e.g. ArrayList or HashMap referenced by a final variable. You can still add, remove and update elements but you cannot change the final variable to point to another collection. This is different then immutable or read-only collection in Java, where you cannot perform any add, remove or update operation once created.


7) Can we make an array final in Java? Can you change its elements?
Yes, you can make an array final in Java and you can change it's elements as well. This is actually the follow-up to the previous question, both array and collection classes can be made final and you can still change their elements.



8) Can you make a Collection final in Java e.g. ArrayList? What is the impact?
Yes, you can make a Collection final in Java. The impact is nothing but the final variable cannot be swapped with another Collection, but you can still add, remove and update elements in ArrayList or any collection classes. This is again related to previous two questions. See Big Java: Early Objects to learn more about this concept.




9) What is the difference between abstract method and final method in Java?
The abstract method is incomplete while the final method is regarded as complete. The only way to use an abstract method is by overriding it, but you cannot override a final method in Java. You should also remember that a method cannot be both abstract and final in Java because both are opposite to each other.


10) What is the use of final class in Java?
You make a class final when you think it's complete and nobody should alter the feature by creating a subclass. Generally, security sensitive classes are made final in Java e.g. String. Another reason is performance, compiler, and JIT both can make a lot of assumption if a class is final because they know overriding or polymorphism will not come into the picture.

Top 21 Java Final Modifier (Keyword) Interview Questions and Answers


11) Can you overload a final method in Java?
Yes, you can overload a final method in Java, remember overloading is different than overriding and you only need to declare the method with the same name in the same class but different method signature for overloading. See rules of method overloading to learn more about overloading in Java.


12) Can you override a final method in Java?
No, you cannot override a final in Java. You make a method final in Java to prevent overriding, so no question of further allowing overriding.


13) Can we make a static method final in Java?
Yes, you can make a static method final in Java, nothing prevents you making a static method from being a final one as well. In fact, they both go hand in hand.


14) Can we make an abstract method final in Java?
No, you cannot make an abstract method final in Java because, in order to use an abstract method, you must override it but the final method cannot be overridden in Java. The compiler will flag an error if you use both abstract and final keyword together with class or method in Java. See Core Java Volume 1 - Fundamentals to learn more about rules of Java programming.


15) Can we use non-final local variables inside an Anonymous class?


Yes and No, it's not allowed until Java 7, from Java 8 onward you can use a non-final local variable inside an anonymous or local inner class, provided it's effectively final, which means it's not changed after initialized. See here to learn more about the effectively final concept in Java 8.


16) Can you declare Constructor as final in Java?
No, Constructors cannot be made final in Java. The compiler will throw an error if you try to make a constructor final in Java. See here to learn more about constructor in Java.


17) What is constant in Java?
A static final variable is known as constant in Java. They are also known as a compile time constant because of their value at the time of compilation. They are also inlined at the client end, means if you are using a static final variable then its value will be copied to your class at compile time. Which also means that you need to recompile all the classes which use the static final variable, whenever you change the value of a static final field. This has the potential to create subtle bugs. Read Java Coding Guidelines to avoid such mistakes.


18) Are static final variables are thread-safe?
There are two types of static final variables, primitive, and reference. Initialization of all static final variables is thread safe because it's done in static initializer block. Similarly primitive static final variable is also thread-safe because you cannot modify their value once created, but reference static final variable may or may not be thread-safe. If the object to which your final variable is referring is Immutable or thread-safe then it is otherwise not.


19) Can a class be abstract and final at the same time?
No, it's not possible because the only way to use abstract class is by extending it and creating a concrete subclass, while it's not possible to extend a final class in Java.


20) When to make a method final in Java?
You make a method final when you know that it's complete and you want to ensure that it should not be overridden. One of the examples of a final method is template methods from the Template design pattern, which outlines the algorithm. That method should be final so that sub-classes cannot change the algorithm, they are only allowed to customize individual steps which are represented by the abstract method.


21. When to make a class final in Java?
You make a class final when you don't want anyone should extend it. This is mainly done due to security reasons because it also hampers the extensibility of your program. A couple of examples of final classes in JDK is String, Integer, and other wrapper class. See here to learn more about why the String class is made final in Java.

Read more: https://javarevisited.blogspot.com/2016/09/21-java-final-modifier-keyword-interview-questions-answers.html#ixzz8hjD4OWb6

https://medium.com/javarevisited/20-array-coding-problems-and-questions-from-programming-interviews-869b475b9121

you find the missing number in a given integer array of 1 to 100? (solution)
How do you find the duplicate number on a given integer array? (solution)
How do you find the largest and smallest number in an unsorted integer array? (solution)
How do you find all pairs of an integer array whose sum is equal to a given number? (solution)
How do you find duplicate numbers in an array if it contains multiple duplicates? (solution)
How to remove duplicates from a given array in Java? (solution)
How do you search a target value in a rotated array? (solution)
Given an unsorted array of integers, find the length of the longest consecutive elements sequence? (solution)
How is an integer array sorted in place using the quicksort algorithm? (solution)
How do you remove duplicates from an array in place? (solution)
How do you reverse an array in place in Java? (solution)
How are duplicates removed from an array without using any library? (solution)
How to convert a byte array to String? (solution)
What is the difference between an array and a linked list? (answer)
How do you perform a binary search in a given array? (solution)
How to find a median of two sorts arrays? (solution)
How to rotate an array left and right by a given number K? (solution)
How do you find duplicates from an unsorted array? (solution)
Given an array of integers sorted in ascending order, find the starting and ending position of a given value? (solution)
Given an integer array, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum? (solution)

https://medium.com/javarevisited/top-21-string-programming-interview-questions-for-beginners-and-experienced-developers-56037048de45

How do you reverse a given string in place? (solution)
How do you print duplicate characters from a string? (solution)
How do you check if two strings are anagrams of each other? (solution)
How do you find all the permutations of a string? (solution)
How can a given string be reversed using recursion? (solution)
How do you check if a string contains only digits? (solution)
How do you find duplicate characters in a given string? (solution)
How do you count a number of vowels and consonants in a given string? (solution)
How do you count the occurrence of a given character in a string? (solution)
How do you print the first non-repeated character from a string? (solution)
How do you convert a given String into int like the atoi()? (solution)
How do you reverse words in a given sentence without using any library method? (solution)
How do you check if two strings are a rotation of each other? (solution)
How do you check if a given string is a palindrome? (solution)
How do you find the length of the longest substring without repeating characters? (solution)
Given string str, How do you find the longest palindromic substring in str? (solution)
How to convert a byte array to String? (solution)
how to remove the duplicate character from String? (solution)
How to find the maximum occurring character in given String? (solution)
How do you remove a given character from String? (solution)
Given an array of strings, find the most frequent word in a given array, I mean, the string that appears the most in the array. In the case of a tie, ​the string that is the smallest (lexicographically) ​is printed. (solution)

https://medium.com/javarevisited/20-binary-tree-algorithms-problems-from-coding-interviews-c5e5a384df30

How is a binary search tree implemented? (solution)
How do you perform preorder traversal in a given binary tree? (solution)
How do you traverse a given binary tree in preorder without recursion? (solution)
How do you perform an inorder traversal in a given binary tree? (solution)
How do you print all nodes of a given binary tree using inorder traversal without recursion? (solution)
How do you implement a postorder traversal algorithm? (solution)
How do you traverse a binary tree in postorder traversal without recursion? (solution)
How are all leaves of a binary search tree printed? (solution)
How do you count the number of leaf nodes in a given binary tree? (solution)
How do you perform a binary search in a given array? (solution)
How do you convert a given binary tree to double linked list in Java? (solution)
Write a program to find a depth of a given binary tree in Java? (solution)
What is the difference between binary and binary search trees? (answer)
What is a self-balanced tree? (answer)
What is the AVL Tree? (answer)
You have given a BST, where two nodes are swapped? How do you recover the original BST? (solution)
How do you convert a binary tree to a binary search tree in Java? (solution)
Find the largest BST subtree of a given binary tree in Java? (solution)
Write a Java program to connect nodes at the same level as a binary tree? (solution)
What is a Trie data structure? (answer)
What is the difference between the Binary tree and Trie? (answer)
How to check if a given binary tree is a BST? (solution)
How to count number of leaf nodes in a given binary tree (solution)
How to print leaf nodes of a given binary tree in Java? (solution)
How to check if a given node exists in binary tree? (solution)
How to find the Kth smallest element in a binary search tree? (solution)
How to find maximum sum level in a given binary tree? (solution)
How to find lowest common ancestor of a binary tree in Java? (solution)

21 Frequently asked Java Inheritance Interview Questions and Answers
Here is my list of some interview questions based upon Inheritance OOP concept asked in various Java interviews. It's very useful for beginners, freshers, and junior Java programmers, but intermediate Java developers can also benefit from some advanced questions shared in this article e.g. position of multiple inheritances in Java after JDK 1.8 release, which allows you to write code inside interface in the form of default methods or explaining Liskov substitution principle.


Question 1: What is Inheritance in Java? (detailed answer)
Answer: Inheritance is an Object oriented feature which allows a class to inherit behavior and data from other class. For example, a class Car can extend basic feature of Vehicle class by using Inheritance. 

One of the most intuitive examples of Inheritance in the real world is Father-Son relationship, where Son inherit Father's property. If you don't know, Inheritance is the quick way to become rich :)


Question 2: What are different types of Inheritance supported by Java? (detailed answer)


Answer: Java supports single Inheritance, multi-level inheritance and at some extent multiple inheritances because Java allows a class to only extend another class, but an interface in Java can extend multiple inheritances.

Types of Inheritance in Java



Question 3: Why multiple Inheritance is not supported by Java? (detailed answer)
Answer: Java is introduced after C++ and Java designer didn't want to take some C++ feature which is confusing and not essential. They think multiple inheritances is one of them which doesn't justify complexity and confusion it introduces. You can also check why multiple inheritances are not supported in Java for more reasons and discussion around this.




Question 4: Why Inheritance is used by Java Programmers? (detailed answer)
Answer: Inheritance is used for code reuse and leveraging Polymorphism by creating a type hierarchy. It's better to use Inheritance for type declaration but for code reuse composition is a better option because it's more flexible. See this article for learning more about why Composition is better than Inheritance.


Question 5: How to use Inheritance in Java? (detailed answer)
Answer: You can use Inheritance in Java by extending classes and implementing interfaces. Java provides two keywords extends and implements to achieve inheritance.  A class which is derived from another class is known as a subclass and an interface which is derived from another interface is called subinterface. A class which implements an interface is known as implementation.



Question 6: What is the syntax of Inheritance? (detailed answer)
Answer: You can use either extends of implements keyword to implement Inheritance in Java.  A class extends another class using extends keyword, an interface can extend another interface using extend keyword, and a class can implement an interface using implements keyword in Java.


Question 7: What is the difference between Inheritance and Encapsulation? (detailed answer)


Answer: Inheritance is an object oriented concept which creates a parent-child relationship. It is one of the ways to reuse the code written for parent class but it also forms the basis of Polymorphism. On the other hand, Encapsulation is an object oriented concept which is used to hide the internal details of a class e.g. HashMap encapsulate how to store elements and how to calculate hash values.


Question 8: What is the difference between Inheritance and Abstraction? (detailed answer)
Answer: Abstraction is an object oriented concept which is used to simply things by abstracting details. It helps in the designing system. On the other hand, Inheritance allows code reuse. You can reuse the functionality you have already coded by using Inheritance. See Head First Object Oriented Analysis and Design for more details.

Java Inheritance Interview Questions Answers



Question 9: What is the difference between Polymorphism and Inheritance? (detailed answer)
Answer: Both Polymorphism and Inheritance goes hand on hand, they help each other to achieve their goal. Polymorphism allows flexibility, you can choose which code to run at runtime by overriding.  See the detailed answer for more details.




Question 10: What is the difference between Composition and Inheritance in OOP? (detailed answer)
Answer: One of the good question to check the candidate's object-oriented programming skills. There are several differences between Composition and Inheritance in Java, some of them are following:



1. The Composition is more flexible because you can change the implementation at runtime by calling setXXX() method, but Inheritance cannot be changed i.e. you cannot ask a class to implement another class at runtime.

2. Composition builds HAS-A relationship while Inheritance builds IS-A relationship e.g. A Room HAS A Fan, but Mango IS-A Fruit.

3. The parent-child relationship is best represented using Inheritance but If you just want to use the services of another class use Composition. For more differences see 5 reasons to favor composition over Inheritance.

Java Inheritance Interview Questions and Answers



11. Can we override static method in Java? (detailed answer)
No, you cannot override a static method in Java because it's resolved at compile time. In order for overriding to work, a method should be virtual and resolved at runtime because objects are only available at runtime. This is one of the tricky Java questions, where interviewer tries to confuse you. A programmer is never sure about whether they can override or overload a static method in Java.


12. Can we overload a static method in Java? (detailed answer)
Yes, you can overload a static method in Java. Overloading has nothing to do with runtime but the signature of each method must be different. In Java, to change the method signature, you must change either number of arguments, type of arguments or order of arguments.


13. Can we override a private method in Java? (detailed answer)
No,  you cannot override a private method in Java because the private method is not inherited by the subclass in Java, which is essential for overriding. In fact, a private method is not visible to anyone outside the class and, more importantly, a call to the private method is resolved at compile time by using Type information as opposed to runtime by using the actual object.


Question 14: What is method hiding in Java? (detailed answer)
Answer: Since the static method cannot be overridden in Java, but if you declare the same static method in subclass then that would hide the method from the superclass. It means, if you call that method from subclass then the one in the subclass will be invoked but if you call the same method from superclass then the one in superclass will be invoked. This is known as method hiding in Java.


Question 15: Can a class implement more than one interface in Java? (detailed answer)
Yes, A class can implement more than one interface in Java e.g. A class can be both Comparable and Serializable at the same time. This is why the interface should be the best use for defining Type as described in Effective Java. This feature allows one class to play a polymorphic role in the program.


Question 16: Can a class extends more than one class in Java? (detailed answer)
Answer: No, a class can only extend just one more class in Java.  Though Every class also, by default extend the java.lang.Object class in Java.


Question 17: Can an interface extends more than one interface in Java? (answer)
Answer: Yes, unlike classes, an interface can extend more than one interface in Java. There are several example of this behavior in JDK itself e.g. java.util.List interface extends both Collection and Iterable interface to tell that it is a Collection as well as it allows iteration via Iterator.


18: What will happen if a class extends two interfaces and they both have a method with same name and signature? (detailed answer)
In this case, a conflict will arise because the compiler will not able to link a method call due to ambiguity. You will get a compile time error in Java.


Question 19: Can we pass an object of a subclass to a method expecting an object of the super class? (answer)
Answer: Yes, you can pass that because subclass and superclass are related to each other by Inheritance which provides IS-A property.  I mean Banana is a Fruit so you can pass banana if somebody expect fruit. Now there are scenario, where you can't do e.g. when subclass violates the Liskov Substitution principle i.e. you cannot pass a plastic banana to someone expecting fruit :-), The eat() function will throw exception.

Liskov Substitution Principle in Java


Question 20: What is the Liskov substitution principle? (detailed answer)
Answer: The Liskov substitution principle is one of the five object-oriented design principles, collectively know as SOLID principles. 

This design principle is L of SOLID acronym. The Liskov substitution principle states that in an object oriented program if a function or method is expecting an object of base class then  it should work fine with a derived class object as well. If it cannot function properly with derived class object then the derived class is violating the Liskov Substitution principle.

For example, if a method is expecting a List you can also pass ArrayList or LinkedList and it should work just fine because ArrayList and LinkedList both follow Liskov Substitution Principle, but the java.sql.Date which is a subclass of java.util.Date in Java violates Liskov Substitution Principle because you cannot pass an object of java.sql.Date class to a method which is expecting an object of java.util.Date, Why? because all time-related method will throw java.lang.UnsupportedOperationException.

Here is another example of violating The Liskov Substitution Principle, Square is a special type of Rectangle whose adjacent sides are equal but making Square extending Rectangle violates LSP principle. For more details on SOLID design principles, read Clean Code by Rober C. Martin, the inventor of SOLID principles.

Inheritance Object Oriented Programming Questions




Question 21: How to call a method of a subclass, if you are holding an object of the subclass in a reference variable of type superclass? (answer)
Answer: You can call a method of the subclass by first casting the object hold by reference variable of  superclass into the subclass. Once you hold the object in subclass reference type, you can call methods from the subclass. See how type casting works in Java for more details.


Read more: https://www.java67.com/2016/03/top-21-java-inheritance-interview-Questions-Answer-Programming.html#ixzz8hjE4jDge

Top 95 Coding Interview Questions for Programmers
Here is my list of some of the most popular coding questions to crack any programming job interview.

The questions are more like you find in the popular book Cracking the Coding Interview by Gayle Lakmann Mcdowell,  one of the essential books to do well on a Job interview, but more focus on Data Structure and Coding rather than touching every single possible topic required for a programming job interview like SQL, UNIX, Database, Networking, etc, for that, you need to read books and you can find many good titles here.

We'll start the list by first exploring array-based questions like finding pairs whose sum is given a number and then move to string-based questions, linked list-based questions, binary tree questions, and finally tackler other topics.


1. Array-based Programming Interview Questions
If you ask me just one topic to prepare really well for coding interviews, I would pick the array. It's one of the essential data structures and favorite darling of coding interviews. There are so many popular coding interview questions that are based upon the array, some of them are easy and some are tough but you can be sure that you will see some questions based upon the array in your next programming job interview.

If you don't know, an array is a data structure that holds other objects like String, int, float, etc. It holds them in a contiguous location in memory which makes them easily searchable and retrieval in O(1) time using the index.



Insertion and deletion of an array are tough because you cannot change the size of an array once created and you need to create a new array and copy elements from old to new.

Anyway, here are some of the most popular array-based coding interview questions for your preparation:

1. How to find the missing number in a given integer array of 1 to 100? (solution)

2. How to find the duplicate number on a given integer array? (solution)

3. How to find the largest and smallest number in an unsorted integer array? (solution)



4. How to find all pairs of integer arrays whose sum is equal to a given number? (solution)

5. How to find duplicate numbers in an array if it contains multiple duplicates? (solution)

6. How to remove duplicates from a given array in Java? (solution)

7. How to sort an integer array in place using the QuickSort algorithm? (solution)

8. How to remove duplicates from an array in place? (solution)

9. How to reverse an array in place in Java? (solution)

10. How to find multiple missing numbers in a given integer array with duplicates? (solution)

I have linked all the solutions but you should try to solve them by yourself before looking at the solution, especially if you have time. That's the only sure way to learn to program by solving these coding questions.



If you find these questions difficult to solve then once again I suggest you first refresh your knowledge of fundamental data structures like an array by going through a comprehensive course. If you need recommendations, Algorithms, and Data Structures Part 1 and Part 2 by Robert Harvick are two of the best course to start with. You will also learn about Big(O) notation and how to calculate time and space complexity.

Array based Programming Interview Questions Answers


If you think these 10 questions from the array are not enough and you are interested in solving more array-based programming problems then you can also check out these 30 array-based coding questions for more practice.



2. String-based Coding Interview Questions
After array, String is the next popular topic on Programming job interviews, but if you have a good understanding of array then you can easily deal with String programming questions because String is nothing but a character array.

The string is implemented differently in a different programming language like in C it's a NULL-terminated character array but in Java, it's an object. However, you can still get access to the underlying array to apply your logic.



Here is a list of some of the frequently asked coding questions which are based on String. Though some of them are quite old, you can still expect this in your programming job interview:

11. How to Print duplicate characters from String? (solution)

12. How to check if two Strings are anagrams of each other? (solution)

13. How to print the first non-repeated character from String? (solution)

14. How to reverse a given string using recursion? (solution)

15. How to check if a string contains only digits? (solution)

16. How to find duplicate characters in a String? (solution)

17. How to count a number of vowels and consonants in a given String? (solution)

18. How to count the occurrence of a given character in String? (solution)

19. How to find all permutations of String? (solution)

20. How to reverse words in a given sentence without using any library method? (solution)

21. How to check if two String is a rotation of each other? (solution)

22. How to check if the given String is Palindrome? (solution)

Similar to an array, I have also linked to a solution for all of these String problems but if you want to get most of this article, you better solve these questions without looking at the answers. Only when you are stuck and running out-of-time, you can look at the solution.

And, if you find these frequently asked String problems difficult to solve, maybe it's time to go back to the drawing board and learn the fundamentals of String data structure again.  If you need resources then Data Structures and Algorithms Specialization on Coursera is one of the best online resources you can use to make your foundations rock solid.

Top 50 Coding Interview Questions


You can also learn from it by comparing your solution with the solution I have given. It's not necessarily to be the same but you can learn a lot by comparing them and if you need more practice, here is another list of 20 String algorithm questions and this list of 21 String coding problems21 String coding problems for tech interviews. 



3. Linked list based Programming Interview Questions
Along with array and string, a linked list is another popular data structure in the programming world as well as on coding interviews. You will find a lot of questions on a linked list like reversing a linked list, adding a new element, removing an element from the middle, etc.

It's also the counterpart of an array data structure. While array stores elements on contiguous memory locations, the linked list stores them at different locations and finds them by storing their address. a linked list is made of nodes, an internal data structure that holds the value as well as the address of the next node.

Because of its structure, it's easier to add and remove elements from the linked list like on O(1) time if you are adding or removing from the head but the search is equally difficult and takes O(n) time, as you have to literally walk through each element.

Anyway, here is a collection of some of the simple and tricky linked list based coding questions for your practice:

23. How to find the middle element of a singly linked list in one pass? (solution)

24. How to check if a given linked list contains a cycle? How to find the starting node of the cycle? (solution)

25. How to reverse a linked list? (solution)

26. How to reverse a single linked list without recursion? (solution)

27. How to remove duplicate nodes in an unsorted linked list? (solution)

28. How to find the length of a singly linked list? (solution)

29. How to find the 3rd node from the end in a singly linked list? (solution)

30. How do you find the sum of two linked lists using Stack? (program)

Similar to array and string, I have also linked to all the solutions but you should only look at them once you solved the problem on your own or you feel stuck.

A key to solving the linked list is a good understanding of recursion because a linked list is a naturally recursive data structure, for example, if you take one node out of the linked list, the result is another linked list, but many programmers struggle to understand recursion.

That was the case with me as well but after practice and visualizing how recursion really works, I overcome that deficiency. If you are in the same boat, I strongly suggest you go through a visual course like Visualizing Data Structures and Algorithms in Java to learn Recursion and data structure. That will help you a lot in your thought process and problem-solving skills.

Top 75 Programming Interview Questions and Solutions

Once you understand recursion, most of the linked list based problems have an easy recursive solution than their iterative version. And if you need more practice, here is another list of 30 linked list programming questions for your reference.



4. Binary Tree-based Coding Interview Questions
A tree is another popular data structure in the programming world and coding interviews. Unlike array and linked list, which are considered linear data structures, a tree is considered a hierarchical data structure and used to arrange information in hierarchical order.

There are a lot of different types of trees e.g. a binary tree, binary search tree, AVL tree, Red-Black tree, etc but Binary tree and Binary search trees are also known as BST are two of the most popular ones and most of the questions are based upon them.

Some questions are also based upon theoretical knowledge of tree data structure e.g. finding the height of the tree, finding leaf nodes, checking if the tree is balanced or not, etc, hence you should also spend some time learning the basics, along with practicing coding questions.

Anyway, here is a list of popular binary tree and binary search tree based coding questions to practice before your job interview:

30. Can you write a program to implement a binary search tree?  (solution)



31. How do you perform Pre-order traversal in a given binary tree? (solution)

32. Write a Program to traverse a given binary tree in Pre-order without recursion (solution)

33. How to perform an In order traversal in a given binary tree? (solution)

34. How to print all nodes of a given binary tree using inorder traversal without recursion (solution)

35. How to implement a Post-order traversal algorithm? (solution)

36. How to traverse a binary tree in Postorder traversal without recursion (solution)

37. How to Print all leaves of a binary search tree? (solution)

38. How to count a number of leaf nodes in a given binary tree? (solution)

39. How to perform a binary search in a given array? (solution)

Like an array, linked list, and string questions, I have also linked to all solutions for binary tree questions but you should only look at them once you have tried it yourself.

One trick I would like to share with you while solving tree questions is to remember that, similar to a linked list, the tree is also a recursive data structure and most of the tree based problems has an easy recursive solution.

For example, a subtree is also a tree which means you can apply the same steps to a subtree can devise a recursive solution. In the above list, many popular tree algorithms e.g. pre-order, post-order, in-order are implemented recursively as well as iterative.

If you don't feel confident to solve these problems and want to refresh your knowledge of binary tree and other data structure before attempting these questions, then you should check out Data Structures and Algorithms: Deep Dive Using Java from Udemy.

Top 75 Essential Programming Interview Questions to Crack Any Coding Interview




5. Miscellaneous Programming Interview Questions
Even though data structure-based questions make the bulk of the Coding Interview, there are always some questions from topics like sorting algorithms, bit manipulation, software design, Dynamic Programming, and other logical and tricky questions.

In this list below, you will find most of the common searching and sort questions as well as a couple of design and bit manipulation questions.

40. How to implement the Bubble Sort algorithm? (solution)

41. How to implement Iterative Quicksort Algorithm? (solution)

42. How to implement the Insertion Sort Algorithm? (solution)

43. How to implement Merge Sort Algorithm? (solution)

44. How to implement the Bucket Sort Algorithm? (solution)

45. How to implement the Counting Sort Algorithm? (solution)

46. How to implement Radix Sort Algorithm? (solution)

47. How to swap two numbers without using the third variable? (solution)

48. How to check if two rectangles overlap with each other? (solution)

49. How to design a Vending Machine? (solution)

50. How to implement an LRU Cache in your favorite programming language? (solution)

51. How to check if a given number is a Palindrome? (solution)

52. How do you check if a given number is an Armstrong number? (solution)

53. How do you find all prime factors of a given number? (solution)

54. How do you check if a given number is positive or negative in Java? (solution)

55. How to find the largest prime factor of a given integral number? (solution)

56. Write a Program to print all prime numbers up to a given number? (solution)

57. Write a Program to print Floyd's triangle? (solution)

58. Write a Program to print Pascal's triangle? (solution)

59. How to calculate the square root of a given number? (solution)

60. How to check if the given number is a prime number? (solution)

61. How to implement the Sieve of Eratosthenes Algorithm? (solution)

62. How to add two numbers without using the plus operator in Java? (solution)

63. Write a Program to subtract two binary numbers? (solution)

64. Write a Program to transpose a Matrix? (solution)

65. Write a Program to add or subtract two Matrices? (solution)

66. Write a Program to multiply two Matrices in Java? (solution)

67. How to calculate the average of all numbers in a given array? (solution)

68. How to check if a given number is even/odd without using an Arithmetic operator? (solution)

69. Write a Program to find the GCD of two numbers using Euclid's Algorithm? (solution)

70.  How to find the number of 1s (the Set bit) in a given Bit Sequence? (solution)

71. Write a Program to a given Pyramid structure? (solution)

72. How to find the highest repeating world from a given file in Java? (solution)

73. How to reverse a given Integer in Java? (solution)

74. How to convert a decimal number to binary in Java? (solution)

75. How to check if a given year is a leap year in Java? (solution)

Like previous topics, I have provided links to a solution but you should only look at them once you tried to solve the questions yourself. That's important for learning.



5. System Design Interview Questions
In last few years, System design and Software design questions have become an integral part of coding interviews. Either you will be asked a tough question like how to design WhatsApp or YouTube or asked theory questions like what is difference between load balancer and API gateway but you will get few questions on this topic. 

Keeping that in mind, I am sharing popular System design questions for Programming and Software Engineering Job interviews. This contains both System design basics questions as well as System design problems from interviews:


76. What is Rate Limiter? How does it work? (answer)


77. How does Single Sign On (SSO) works? (answer)


78. How does Apache Kafka works? why it so fast? (answer)


79. Difference between Kafka, ActiveMQ, and RabbitMQ? (answer)


80. Difference between API Gateway vs Load Balancer? [solution] 

81. Difference between JWT, OAuth, and SAML? (answer)

82. What is difference between Reverse Proxy and Forward Proxy? (answer)


83. What is Horizontal scaling and vertical scaling? (answer)


84. What is difference Microservices and Monolithic architecture? (Answer)


And, now let's see System design problems from Programming job interviews where you will be asked to design real world apps like WhatsApp, YouTube, Twitter, Instagram, etc


85. How do you design Vending Machine in Java [solution]

86. How to Design URL Shortener like TinyURL [solution]

87. Please give high and level design of WhatsApp (solution)

88. Please Design YouTube and implement your favorite feature [solution]

89. How do you design a trade aggregator or portfolio manager? (solution)

90.  How to design Parking Garage [solution]

91. Can you design a bounded buffer in Java? (solution)

82. Can you walk through design Text Storage Service like Pastebin? [solution]

93. How are you going to design Content Delivery Network (CDN) ? [solution]

94. how do you design Google Map? (Solution)

95. Design Instagram [solution]
In this question you can choose which feature to implement, I suggest you should start with simple one like uploading photos and sharing them in your feed. 

Also, here is a nice diagram which shows high-level design of Instagram app from DesignGuru, one of my favorite place to prepare for System design interviews. Their Grokking the System Design Interview course is also the most popular resource for system design interviews. 




Read more: https://www.java67.com/2018/05/top-75-programming-interview-questions-answers.html#ixzz8hjEJIHk0


5 Main Method Interview Questions with Answers
Now that we have seen some common Java interview questions related to the main method, let's find out their answer and understand some key Java concepts related to the main method. 

1. Can you overload the main in Java?
Yes you can overload the main method in Java, nothing wrong with this but Java will only call your specific main method, i.e. main method with the following signature:
public static void main(String[] args) or public static void main(String args...) which is the main method as variable argument method and only supported post-Java 5 world.


2. Can you override main in Java?
No, you can not override the main method in Java, Why? because main is a static method and in Java static method is bonded during compile time and you can not override the static method in Java. If you declare a method with the same name and signature it's called method hiding.

3. Can you make the main final in Java?
Of course, you can make the main method final in Java. JVM has no issue with that. Unlike any final method, you can not override main in Java.


4. Can you make the main synchronized in Java?
Yes, the main can be synchronized in Java, a synchronized modifier is allowed in the main signature and you can make your main method synchronized in Java.


5. How to call a non-static method from main in Java?
This question applies not only to main but all static methods in Java. Since nonstatic methods can not be called from static context directly, you need to first create an Object as a local variable and then you can call a non-static method using that object, as shown in the following example:

10 points about Main method in Java


Now, let's see a Java Program to see how to call a non-static method from a static method like the main method in Java. 


import java.util.Date;


/**
 * Java program to show how to call non-static method from the static method in Java
 *
 * @author http://java67.blogspot.com
 */
public class StaticTest {

    public static void main(String args[]) {
     
        // calling non static method from main in Java
        //printCurrentTime(); //compile time error - can not call non static method from main
     
        StaticTest test = new StaticTest();
        test.printCurrentTime();
     
    }
 
 
    public void printCurrentTime(){
       System.out.println(new Date());
    }
}

Output:
Tue Nov 06 19:07:54 IST 2012


Summary
Here are some important points about the main method in Java which every Java Programmer should know and remember:
The main() method is a static method
You can overload the main() method in Java.
You cannot override a main() method in Java
You can make the main method final in Java
You can make the main method synchronized in Java.
You cannot call a non-static method from main in Java. 


Read more: https://www.java67.com/2016/01/main-method-interview-questions-in-java-answers.html#ixzz8hjEeBRoa

Java Array Concept Interview Questions
Here are some interview questions based upon the array data structure in Java. You need to have good knowledge of how an array is implemented and work in Java to answer these questions.

Since an array is one of the most used data structures, it's expected from programmers of all levels (including beginners and experienced) to have a good grasp of array concepts.

These questions are mostly asked in a telephonic round of Java interviews. Your answer to these questions must be focused and to the point, without any added syntactic sugar.


Question 1: What is an array? Can you change the size of the array once created? [answer]
An array is a fundamental data structure to store objects and primitive values. You have different types of array, like 1-dimension, 2-dimension, and N-dimensional array. No, you cannot change the size of the array once created. If you need a dynamic array, consider using the ArrayList class, which can resize itself.

Array concept interview questions and answers in Java




Question 2: Can you store String in an array of Integer in Java? compile-time error or runtime exception? [answer]
This is a tricky question. The answer is both yes and no. You cannot store a string in an array of primitive int, it will result in a compile-time error as shown below, but if you create an array of Object and assign String[] to it and then try to store Integer object on it.

The compiler won't be able to detect that and it will throw ArrayStoreExcpetion at runtime.

int[] primes = new int[10];
primes[0] = "a";  //compile time error
        
Object[] names = new String[3];
names[0] = new Integer(0); // ArrayStoreException at runtime



Question 3: What is the difference between ArrayIndexOutfOBounds and ArrayStoreException? [answer]
The ArrayIndexOutOfBoundsException comes when your code tries to access an invalid index for a given array, like a negative index or higher index than length - 1. While, ArrayStoreException comes when you have stored an element of a type other than the type of array, as shown in the above example.


Question 4: Can you use Generics with an array? [answer]
No, you cannot use the Generic feature with an array, that's why sometimes List is a better choice over an array in Java, which is also recommended by Joshua Bloch in his class Java book, Effective Java, a must-read for writing good code in Java.





Question 5 : Is it legal to initialize an array int i[] = {1, 2, 3, 4, 5}; [answer]
Yes, it's perfectly legal. You can create and initialize an array in the same line in Java.


Question 6: Difference between b[] and []b  in Java? [answer]
You can declare an array in Java by either prefixing or suffixing[] with a variable. There is not much difference between them if you are not creating more than one variable in one line, but if you do then it creates different types of variables, as shown in the following example :

int a[], b; // first is int array, second is just int variable
int[] c, d; // both c and d are integer array


Question 7: What is a two-dimensional array in Java? [answer]
An array of the array in Java.  You can declare them like int[][] primes = new int[3][3] which is a matrix of 3x3.


Question 8: Do you have a three-dimensional array in Java? [answer]
Yes, Java supports the N-dimensional array. Actually, a multi-dimensional array in Java is nothing but an array of array, for example, a two-dimensional array is just an array of a one-dimensional array.


Question 9: How to iterate over an array in Java? [answer]
You can either use classical for loop with the index or advanced foreach loop introduced in Java 5 to iterate over an array in Java. If you need the index to select some element or do something else, use for loop otherwise advanced foreach loop is better. It's less error-prone as you don't need to deal with the index.


Question 10: What is the difference between an array and a linked list? [answer]
One key difference between an array and linked list data structure is, Array requires contiguous memory for its element but linked list elements can be scattered in memory, which means it would be difficult to create a big array but your linked list can grow easily.

An array is good for searching elements if you know the index, but adding and removing elements in an array is expensive as compared to the linked list.  If you are interested, you can further check out Data Structures and Algorithms: Deep Dive Using Java course on Udemy to learn more about basic data structure and algorithms.

What is the difference between an array and a linked list?



Question 11: How to sort an array in Java? [answer]
You can sort an array in Java by using the Arrays.sort() method. Arrays is a utility class that contains lots of static utility methods to operate on arrays. This method is overloaded and you can optionally provide a Comparator implementation to sort the array in a custom order.


Question 12: How to copy an array in Java? [answer]
You can either manually copy elements of an array by iterating over them, or you can use System.arrayCopy() method to copy elements from one array to another. This is a powerful method that provides fast copy and also allows you to copy the entire or part of the array.


Question 13: How to access elements of an array in Java? [answer]
You can access elements of an array using the index in Java. It starts from 0, so the first element is stored in location zero and the last element has an index length - 1. Trying to access an invalid index in Java, like a negative index or index higher than size will result in ArrayIndexOutOfBoundsException in Java.


Question 14: How to search an array to check if an element exists there? [answer]
You can search an element inside an array by using either a linear search or binary search. Later is faster but you need to sort the array before performing a binary search on it.

The Arrays class from the java.util package provides a binarySearch() method to search an element in an array. Alternatively, you can also convert the array to ArrayList and use its contains() method to find out if an element exists or not.



But, if you want to do it without using an API method, you can also check out this post to implement the binary search algorithm in Java.






Question 15: Can you make an array volatile in Java? [answer]
This is another tricky question in Java. Yes, you can make an array volatile in Java, but you only make the variable that is pointing to array volatile. If an array is changed by replacing individual elements that happen before the guarantee provided by volatile variables will not hold.

Anyway, if you are seriously preparing for a Java interview then you have to do more than just preparing for array-based questions. I suggest you take a look at this Java Interview Guide, which contains 200+ Java questions and answers, good enough to clear any Java interview.


Question 16: Where does an array stored in memory? [answer]
An array is created in the heap space of JVM memory. Since an array is an object in Java, even if you create an array locally inside a method or block, an object is always allocated memory from the heap.

Read more: https://www.java67.com/2015/07/array-concepts-interview-questions-answers-java.html#ixzz8hjExMMHw

SQL query to find second maximum salary of Employee
In this section, we will write SQL queries to get the second highest salary of Employees. Before writing query its good to be familiar with the schema as well as data in table. Here is the Employee table we will be using this SQL example:

mysql> SELECT * FROM Employee;
+--------+----------+---------+--------+
| emp_id | emp_name | dept_id | salary |
+--------+----------+---------+--------+
| 1      | James    | 10      |   2000 |
| 2      | Jack     | 10      |   4000 |
| 3      | Henry    | 11      |   6000 |
| 4      | Tom      | 11      |   8000 |
+--------+----------+---------+--------+
4 rows IN SET (0.00 sec)

If you look at data, you will find that the second maximum salary, in this case, is 6000, and the employee name is Henry. 

Now let’s see some SQL examples to find out this second maximum salary.




Second maximum salary using subquery and IN clause
Sub queries in SQL are great tool for this kind of scenario, here we first select maximum salary and then another maximum excluding result of subquery. To learn more about Subquery see correlate and non-correlate subquery in SQL

mysql> SELECT max(salary) FROM Employee WHERE salary NOT IN (SELECT max(salary) FROM Employee);
+-------------+
| max(salary) |
+-------------+
|        6000 |
+-------------+
1 row IN SET (0.00 sec)

Here is another SQL query to find second highest salary using subquery and < operator instead of IN clause:

mysql> SELECT max(salary) FROM Employee WHERE salary < (SELECT max(salary) FROM Employee);
+-------------+
| max(salary) |
+-------------+
|        6000 |
+-------------+
1 row IN SET (0.00 sec)

Both of above SQL example will work on all database including Oracle, MySQL, Sybase and SQL Server as they are written using standard SQL keywords. But sometime you can also use database specific features like TOP keyword of SQL Server or Sybase database to find out second highest salary of Employee.

how to find second highest salary in SQL




Second highest salary using the TOP keyword of Sybase or SQL Server database
TOP keyword of Sybase and SQL Server database is used to select top record or row of any result set, by carefully using TOP keyword you can find out second maximum or Nth maximum salary as shown below.

SELECT TOP 1 salary FROM ( SELECT TOP 2 salary FROM employees ORDER BY salary DESC) AS emp ORDER BY salary ASC

Here is what this SQL query is doing : First find out top 2 salary from Employee  table and list them in descending order, Now second highest salary of employee is at top so just take that value. 

Though you need to keep in mind of using distinct keyword if there are more than one employee with top salary, because in that case same salary will be repeated and TOP 2 may list same salary twice.

Second highest salary using the TOP keyword of Sybase or SQL Server database



Second maximum salary using LIMIT keyword of MYSQL database
SQL Query to find second highest or maximum salary of EmployeeLIMIT keyword of MySQL database is little bit similar with TOP keyword of SQL Server database and allows to take only certain rows from result set. If you look at below SQL example, its very much similar to SQL Server TOP keyword example.

mysql> SELECT salary  FROM (SELECT salary FROM Employee ORDER BY salary DESC LIMIT 2) AS emp ORDER BY salary LIMIT 1;
+--------+
| salary |
+--------+
|   6000 |
+--------+
1 row IN SET (0.00 sec)


Read more: https://javarevisited.blogspot.com/2012/12/how-to-find-second-highest-or-maximum-salary-sql.html#ixzz8hjFZmrmY

Question 1. Can Enum implement an interface in Java?
Yes, Enum can implement an interface in Java. Since enum is a type, similar to class and interface, it can implement an interface. This gives a lot of flexibility to use Enum as a specialized implementation in some cases. You can further see here an example of Enum implementing an interface in Java.


Question 2. Can we use Enum in the switch case in Java?
Yes, you can use Enum in the Switch case in Java, in fact, that's one of the main advantages of using Enum. Since Enum instances are compile-time constant, you can safely use them inside switch and case statements. 

Here is an example of using our DayOfWeek enum in switch case :





Enum and Switch cases go well with each other, especially if Enum has a relatively small number of fixed constants like 7 days in a week, 12 months in a year, etc, See here for another example of using the switch case with Enum in Java.



Question 3. How do you create Enum without any instance? Is it possible without compile-time error?
This is one of those tricky Java question, which Interviewer love to ask. Since Enum is viewed as a collection of a well-defined fixed number of instances like Days of Week, Month in a Year, having an Enum without any instance, may seem awkward. 

But yes, you can create Enum without any instance in Java, say for creating a utility class. This is another innovative way of using Enum in Java. 

Here is the code

public enum MessageUtil{
;  // required to avoid compiler error, also signifies no instance

public static boolean isValid() {
        throw new UnsupportedOperationException("Not supported yet.");
}

}

Btw, if you are preparing for a Java interview then I also recommend you to check out Educative's Ace the Java Coding Interview track where you will find a lot of courses to prepare essential Java topics for just $14 monthly ($39 dollars usual price). 

best Java interview preparation course





Question 4. Can we override toString() method for Enum? What happens if we don't?
Of course, you can override toString in Enum, as like any other class it also extends java.lang.Object and has toString() method available, but even if you don't override, you will not going to regret it much, because the abstract base class of enum does that for you and return name, which is the name of the enum instance itself. here is the code of the toString() method from the Enum class :

 public String toString() {
        return name;
 }

name is set, when compiler emits code for creating enum in response to instance declaration in enum class itself, along with setting ordinal, as visible in this constructor of enum from java.lang.Enum class :

protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
}

This is the only constructor of creating enum, which is called by code, generated by the compiler in response to enum type declaration in Java program.


Question 5) Can we create an instance of Enum outside of Enum itself? If Not, Why?
Java Enum Interview Questions with Answers for ProgrammersNo, you can not create enum instances outside of the Enum boundary, because Enum doesn't have any public constructor, and the compiler doesn't allow you to provide any public constructor in Enum. Since the compiler generates a lot of code in response to the enum type declaration, it doesn’t allow public constructors inside Enum, which enforces declaring enum instances inside Enum itself.




Question 6. Can we declare Constructor inside Enum in Java?
This is asked along with the previous question on Java Enum. Yes, you can, but remember you can only declare either private or package-private constructor inside enum. public and protected constructors are not permitted inside the enum. See here for a code example.


Question 7. What is the difference in comparing Enum with the == and equals() method?
I have already discussed this question in my post with a similar title, see here.



Question 8. What does the ordinal() method do in Enum?
The ordinal method returns the order in which Enum instances are declared inside Enum. For example in a DayOfWeek Enum, you can declare days in the order they come e.g.

public enum DayOfWeek{
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

here if we call DayOfWeek.MONDAY.ordinal() it will return 0, which means it's the first instance. This ordering can be very useful to represent actual real-world ordering i.e. declaring TUESDAY after MONDAY ensures that it came after MONDAY and before WEDNESDAY. 

Similarly, you can use an enum to represent the Month of the year in the order they come e.g. FEBRUARY after JANUARY and before MARCH. 

All user-defined enum inherit this method from java.lang.Enum abstract class, and it's set by the compiler, when it internally calls the protected constructor of java.lang.Enum, which accepts name and ordinal.





Question 9. Can we use Enum with TreeSet or TreeMap in Java?
This is a really interesting question on Java Enum, I would love to ask this to gauge knowledge of Enum. Until you know about java.lang.Enum and has looked at its code.

It's more likely that you don't know that Enum implements a Comparable interface, which is the main requirement to be used in Sorted Collection like TreeSet and TreeMap. Since Enum by default impalement Comparable interface, they can be safely used inside TreeSet or TreeMap in Java.


Question 10.  What is difference between ordinal() and compareTo() in Enum?
This is a follow-up to the previous question on Java Enum. Actually, compareTo() mimic ordering provided by the ordinal() method, which is the natural order of Enum. 

In short Enum constraints are compared in the order they are declared. Also, worth remembering is that enum constants are only comparable to other enum constants of the same enum type. Comparing the enum constant of one type to another type will result in a compiler error.


Question 11. Can Enum extend a class in Java?
No, Enum can not extend the class in Java. Surprised, because I just said it's a type as a class or interface in Java. Well, this is why this question is a good follow-up question to the previous Enum interview question. 

Since all Enum by default extends abstract base class java.lang.Enum, obviously they can not extend another class, because Java doesn't support multiple inheritances for classes. Because of extending java.lang.Enum class, all enum gets methods like ordinal(), values() or valueOf().


Question 12. How to iterate over all instances of an Enum?
Well, if you have explored java.lang.Enum, you know that there is a values() method that returns an array of all enum constants. Since every enum type implicitly extends java.lang.Enum, they get these values() method. By using, this you can iterate over all enum constants of a certain type. See here for an Enum values Example in Java for iterating over Enum using values() and foreach loop.






Question 13. What are the advantages and disadvantages of using Enum as Singleton?
Enum provides you a quick shortcut to implement the Singleton design pattern, and ever since it's mentioned in Effective Java, it's been a popular choice as well. 

On the face, Enum Singleton looks very promising and handles a lot of stuff for you e.g. controlled instance creation, Serialization safety, and on top of that, it’s extremely easy to create thread-safe Singleton using Enum. You don’t need to worry about double-checked locking and volatile variables anymore. See here to know about the pros and cons of using Enum as Singleton in Java.


Question 14. What is the advantage of using Enum over enum int pattern and enum String pattern?
If you have been coding for more than 5 years, and have coded in JDK 1.3 and 1.4, you must be familiar with Enum String pattern and enum int pattern, where we used public static final constants to represent a collection of a well known fixed number of things like DayOfWeek. 

There were a lot of problems with that approach like you don't have a dedicated enum type Since it's a String variable, which represents days of the week, it can take any arbitrary value. Similarly, the enum int pattern can take any arbitrary value, the compiler doesn't prevent those. 

By using Enum, you get this type-safety and compiler checking for you. There are a couple of good items on this topic in Effective Java, which is once again, a must-read for any Java developer.




Question 15. How to convert a String to Enum in Java?
This is a day-to-day ask, given the popularity of String and Enum in Java application development. The best way for converting Enum to String is to declare a factory method inside Enum itself, which should take String argument and return an Enum. You can choose to ignore the case as well. See here for a code example of String to Enum conversion in Java.


Read more: https://www.java67.com/2013/07/15-java-enum-interview-questions-amswers-for-experienced-programmers.html#ixzz8hjFs8sKQ

https://hackernoon.com/50-data-structure-and-algorithms-interview-questions-for-programmers-b4b1ac61f5b0


**What is Default or Defender Methods in Java 8? Tutorial Example

Whenever someone talks about Java 8, the first thing they speak about is lambda expression and how lambda expression has changed the way you use Collections API today. In truth, lambda expression would not be that useful had language not been enhanced to support default methods on Java Interface. Also known as virtual extension or defender methods, they allow you to declare a non-abstract method inside the Java interface. This means, finally you can add new methods without breaking all classes, which implements a certain interface. This opens a new path for enhancing and evolving the existing Collection API to take advantage of lambda expressions. For example, now you can iterate over all elements of Collection in just one line, as opposed to four lines it requires you to do prior to Java 8.



The forEach is a default method declared inside java.lang.Iterable, which allows Java to iterate over collection internally and execute action asked by the client. Since now iteration is internally handled by Java, they can do a lot of things that were not possible earlier like parallel iteration.

Parallel libraries are long been due on the Java platform to leverage the immense power of multiple CPUs available to modern servers. Since handling parallelism on the client-side is both difficult and error-prone, programmers have been asking for libraries, which can do things in parallel, leaving you to only define what to do, instead of how to do.

Bulk data operation, like applying logic on each or some elements of a Collection was possible because of default methods like forEach.

In this article, we will learn what is the default method, will see few examples of the default method on the custom interface and from JDK itself, understand how differences between abstract class and the interface in Java 8 are reduced due to the introduction of defender methods and finally answer some frequently asked questions on Java 8 default methods. So fasten your seat belt and be ready for a short ride on Java 8 default methods.




What is Default or Defender Methods of Java 8?
Default methods, also known as virtual extension methods or defender methods is a non-abstract method, which can be declared inside an interface in Java. If you have been using an interface in Java then you know that it’s not possible to change the structure of the interface, without breaking its implementations, once it's published.

This means you cannot add new methods on the existing interface like java.util.Map or java.util.List which is used heavily in almost all Java programs.

This was a serious limitation and was affecting the fluent use of lambda expression with Collections API. Since one of the common use cases of a lambda expression is to apply some operation to each element of Collection, it is not possible until you have a method, which allows you to iterate over List.

For example, adding a method like forEach() inside java.util.List would have broken all List implementation exists in Java world, and that's why the idea of default method was introduced.



This way, you can declare a concrete method inside an interface without breaking its clients. Since introducing this means, an interface is no more completely abstract, a few rules in the compiler is needed to ensure that it wouldn't create the diamond problem, one of the reasons Java doesn't support multiple inheritances.

Reserve keyword default is used to make a method default inside interface, it’s not mandatory for an implementer to override Java 8 default methods, but it can if it wishes to.

Also, no special bytecode instruction is provided for calling default methods, It will make use of existing invokeinterface, invokevirtual, and invokespecial bytecode method instructions.



If you want to learn more about Java 8 features like lambda expression, Stream API, and new Date and Time API, then the What's New in Java 8 course on Pluralsight is a good starting point to quickly become familiar with these essential Java 8 features.

What is Default or Defender Methods of Java 8 - Tutorial Example



Why Default Methods was Introduced in Java 8
The lambda expression in Java is of SAM type, which means a type of Single abstract method, interface like Comparable, Comparator, and Runnable fits this bill and were an obvious candidate to be used in a lambda expression, but another use case of using lambdas is allowing to operate them over each element of Collection.

Since so far the collection doesn't know how to iterate over themselves, adding a method like forEach() on Collection or List interface would have broken all existing implementation, so they thought about a Virtual extension or defender methods. This means you can finally declare a non-abstract method inside the interface, without breaking its client.



Had they introduced Java 8 lambda expression without default method like forEach() on java.lang.Iterable, It wouldn't help in the development of parallel libraries, which is the core intention of introducing lambda expression to exploit the capability of multiple CPUs available in modern computers.

So in a sense, the default method was critical to support the development of bulk data operations with a lambda expression. If you want to learn more about bulk data operation and Stream API, I suggest you go through the Java Streams API Developer Guide on Udemy, one of the hands-on courses to learn and master Stream API of Java 8.

what is the purpose of default method in Java



Default Method Example in Java 8
Here is a simple example of an interface, which has implemented Java 8 default methods. You need to download JDK 8 to run this program.

There are a lot of interesting things to note about this example, first of all, did you notice that class TextParser neither implements parse() method not declared as abstract, but it still compiles fine. This is possible because parse() is a default method, had Parser contains another method, which was not a defender method, TextParser either has to override that method or declare itself as abstract.



The next interesting thing is what happens if the parse() method is called with an instance of TextParser class? Well, it will call the default implementation provided in the interface itself. Next is our class XMLParser, which does override parse(), which means it’s possible to override default methods in Java.

Now if you invoke the default method with an instance of subclass e.g. XMLParser, it will invoke the overridden method, as shown in the output.

interface Parser{   
    default void parse(){
        System.out.println("default Parsing logic");
    }
}

class TextParser implements Parser{ 
    // No compile time error, because parse is default method
    //inherit default implementation of parse
}

public class XMLParser implements Parser{
   
    @Override
    public void parse(){
        System.out.println("Parsing XML files");
    }
   
    public static void main(String args[]){
        Parser p = new TextParser();
        p.parse();
       
        p = new XMLParser();
        p.parse();
    }
}

Output:
default Parsing logic
Parsing XML files


Let's take another real example of default methods, which is probably the most popular one, which connects default methods to lambda expressions. The forEach method is defined as a default method inside java.lang.Iterable class as shown below :

public interface Iterable<T> {
    Iterator<T> iterator();
 
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
}

Since List implements a Collection interface, which in turn implements Iterable, this allows you to write the following kind of code, which operates on each element.  This code print each element from a list :

List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
numbers.forEach(System.out::println);

The forEach() is just an example. The JDK designers have added several useful methods in existing interfaces e.g. sort() in List and removeIf() in Collection. There are a couple in the Map interface as well. You should check a good Java book like Java 8 in Action to find out more about such important methods.
Java 8 Default Methods On Interface


That's all about what is default methods in Java 8, Why default or defender methods were added in Java programming language, and how default methods work. Though they are instrumental in the evolution of lambda expression and Collections API in Java 8, they are not something, which should be used every day.

Treat your interface as a pure interface and only add default methods, if it becomes really necessary, keep it as your last option, not the first one, similar to how they have been used in Java 8. Remember Java 8 is not supporting multiple inheritances of classes, and even with the default method, the compiler will ensure it won't cause ambiguity to avoid the diamond problem.

To take full advantage of lambda expression and default methods, take a look at Java 8 API docs to see which interfaces are enhanced with default methods and How you can use them with a lambda expression.


Read more: https://www.java67.com/2017/08/java-8-default-methods-on-interface-example.html#ixzz8hjGCCPbh

How to Join Multiple Strings in Java 8 - String join() Example

Hello guys, I have been writing about the new features of Java SE 8 for quite some time. Initially, my focus areas on much talked about lambda expressions and streams, but slowly I realized that Java 8 is not just about them, it's much more than that. It has many more new features and API enhancements that will help Java developers in their day-to-day job as much as lambdas and streams. One of such less talked features is the ability to join multiple String objects into one separated with any delimiter. It has added a class called StringJoiner in java.util package which we have seen earlier, but it has also added a new method on String class, the join() method, which finally allows you to join Strings in Java.



You might have faced scenarios in the past where you have a list of String or an array of String and you want to join them by a comma.

Unfortunately, Java didn't have anything like Android's TextUtils.join() or JavaScript's Array.join() method which can join String on a delimiter.

Finally, the wait is over. JDK 8 has introduced a join() method which you can use to join any number of arbitrary String, an array of String, or a list of String by a delimiter.

Similar to String.split(), it is also a static method and you can call it String.join(). It has two overloaded versions, one accepts a delimiter and number of String objects as variable arguments and the other accepts a delimiter and an Iterable to join elements from array and list.

In this article, I'll show you a couple of examples of how to use the join() method of String class to join Strings in Java 8 and you can always look back to these free Java courses to understand more about these little gems from Java 8. It's one of the best courses to learn Java and also most up-to-date, recently updated for the Java 11 version.




How to join Multiple String Objects in Java 8? Example
You can use the String.join() method to join a number of String literals, String objects, String elements from an array, or String elements from List, Set, or any collection because it accepts an Iterable.

This means all classes which implement this interface can use this join() method to join individual objects. You can also pass the delimiter of your choices like a comma, semicolon, pipe, or colon characters.

Here is an example of String.join() to join String literals by PIPE character

String banks = String.join("|", "Citibank", "Bank of America", "Chase");
System.out.println("banks: " + banks);

Output
banks: Citibank|Bank of America|Chase

You can see that the final String contains all three String literals separated by the PIPE delimiter.



here is another example to join all elements of a List by commas

List<String> payCompanies = Arrays.asList("Apple pay", "Samsung Pay", "Paypal");
String wallats = String.join(",", payCompanies);
System.out.println("electronic wallats : " + wallats);

Output
electronic wallets : Apple pay,Samsung Pay,Paypal

and here is the last example of String.join() to join elements of an array in Java:

String[] typesOfCards = {"Credit card", "Debit card", "Master Card"};
String cards = String.join(",", typesOfCards );
System.out.println("cards: " + cards);

Output
cards: Credit card,Debit card,Master Card

You can see that the final String is a combination of all the individual String and they are separated by a comma. This is really handy and you end up using it quite often. Btw, if you want to know more about such gems from Java 8 release then I also suggest you join these best Java 8 to Java 13 courses to learn new features. 

How Join Multiple String into One in Java 8 - String.join() Example




Java Program to join String - Example
Here is our complete Java program to demonstrate other features of the String.join() method. It's a static method similar to split, so you can directly call them on String literal or just pass the String values you want to join.  

The program contains three examples, first to join arbitrary String literals, second to join elements from the list of String, and third to join elements from an array.

package test;

import java.util.Arrays;

/**
 * Java Program to demonstrate how to use StringJoiner and String.join)( method
 * to join individual String and String form list and array.
 */
public class Test {

  public static void main(String[] args) {

    // Joining arbitrary number of String
    String combined = String.join(" and ", "LinkedIn", "Microsoft");
    System.out.println("string joined by and : " + combined);

    // joining elements from a list of String
    String joined = String
        .join("|", Arrays.asList("Java", "Android", "Oracle"));
    System.out.println("String joined by pipe from list : " + joined);

    // joining String elements of an array
    String[] biggies = { "Apple", "Google", "Amazon" };
    String fromArray = String.join(",", biggies);
    System.out.println("String joined by comma from array: " + fromArray);

  }

}

Output
string joined by and : LinkedIn and Microsoft
String joined by pipe from list : Java|Android|Oracle
String joined by comma from array: Apple,Google,Amazon


That's all about how to use String.join() method in Java 8 to join String. Now, no need to use any third-party library like Google Guava or Apache commons, you can join String by just using JDK itself. If you come across any other detail about the String.join() method, please let us know. It's one of the interesting methods which will be soon as popular as String.split() is at the moment.


Read more: https://www.java67.com/2016/08/java-8-stringjoin-example.html#ixzz8hjGJofxn

convert a List to Map in Java
Now, let's see different ways to solve this problem in the pre-JDK 8 worlds and in Java 8. This comparative analysis will help you to learn the concept and Java 8 API better.



1. Before Java 8
Here is how you can convert a List to Map in Java 5, 6 or 7:

private Map<String, Choice> toMap(List books) {
        final Map hashMap = new HashMap<>();
        for (final Book book : books) {
            hashMap.put(book.getISBN(), book);
        }
        return hashMap;
    }

You can see we have iterated through the List using enhanced for loop of Java 5 and put each element into a HashMap, where ISBN code is the key, and the book object itself is the value. This is the best way to convert a List to Map in pre-JDK 8 worlds. It's clear, concise, and self-explanatory, but iterative.


2. Java 8 using Lambdas
Now, let's see how we can do the same in Java 8 by using lambda expression and Stream API, here is my first attempt:

Map<String, Book> result  = books.stream()
            .collect(Collectors.toMap(book -> book.getISBN, book -> book));

In the above code example, the stream() method returns a stream of Book object from the list, and then I have used collect() method of Stream class to collect all elements. All the magic of how to collect elements happening in this method.

I have passed the method Collectors.toMap(), which means elements will be collected in a Map, where the key will be ISBN code and value will be the object itself. We have used a lambda expression to simplify the code.





3. Using Java 8 method reference
You can further simplify the code in Java 8 by using method reference, as shown below:

Map<String, Book> result =  books.stream()
        .collect(Collectors.toMap(Book::getISBN, b -> b));

Here we have called the getISBN() method using method reference instead of using a lambda expression.


You can further remove the last remaining lambda expression from this code, where we are passing the object itself by using Function.identify() method in Java 8 when the value of the Map is the object itself, as shown below:

Map<String, Book> result = choices.stream()
        .collect(Collectors.toMap(Book::getISBN, Function.identity()))

What does identify function do here? It's just a substitute of b ->b and you can use if you want to pass the object itself. See Java SE 8 for Really Impatient book to learn more about Function.identity() method.

10 Examples of converting List to Map with duplicates




How to convert a List with Duplicates into Map in JDK 8
What if the List has duplicates? When you are converting List to Map, you must pay attention to a different characteristic of these two collection classes, a List allows duplicate elements, but Map doesn't allow duplicate keys. What will happen if you try to convert a List with duplicate elements into a Map in Java 8?

Well, the above method will throw IllegalStateException as shown in the following example:

List cards = Arrays.asList("Visa", "MasterCard", "American Express", "Visa");
Map cards2Length = cards.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

Exception in thread "main" java.lang.IllegalStateException: Duplicate key 4
 at java.util.stream.Collectors.lambda$throwingMerger$90(Collectors.java:133)


 at java.util.stream.Collectors$$Lambda$3/1555009629.apply(Unknown Source)
 at java.util.HashMap.merge(HashMap.java:1245)
 at java.util.stream.Collectors.lambda$toMap$148(Collectors.java:1320)
 at java.util.stream.Collectors$$Lambda$5/258952499.accept(Unknown Source)
 at java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169)
 at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:948)
 at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:512)
 at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:502)


 at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
 at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
 at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:499)
 at Java8Demo.main(Java8Demo.java:20)

This exception is suggesting that 4th element of the List is a duplicate key. Now how do you solve this problem? Well, Java 8 has provided another overloaded version of Collectors.toMap() function which accepts a merge function to decide what to do in case of the duplicate key. If you use that version, instead of throwing an exception, Collector will use that merge function to resolve a conflict.

In the following example, I have used that version and instructed to use the first object in case of the duplicate key, the lambda expression (e1, e2) -> e1 is suggesting that.



You can do whatever you want e.g. you can combine the keys or choose any one of them.

List cards = Arrays.asList("Visa", "MasterCard", "American Express", "Visa");
System.out.println("list: " + cards);
        
Map cards2Length = cards.stream()
                .collect(Collectors.toMap(Function.identity(),
                            String::length, (e1, e2) -> e1));
System.out.println("map: " + cards2Length);

Output:
list: [Visa, MasterCard, American Express, Visa] 
 map: {American Express=16, Visa=4, MasterCard=10}

You can see that the List contains 4 elements but our Map contains only three mappings because one of the elements "Visa" is duplicate. The Collector only kept the first reference of "Visa" and discarded the second one. Alternatively, you can also remove duplicates from the List before converting it to Map as shown here.

How to convert a List to map and keep order



How to Preserve Order of Elements when converting a List to Map
Remember I said that Map returned by the Collectors.toMap() is a just a simple implementation of Map interface and because Map doesn't guarantee the order of mappings, you will likely lose the ordering of elements provided by the List interface.

If you really need elements in Map in the same order they were in the List, you can use another version of the Collectors.toMap() method which accepts four parameters and the last one of them is to ask for a specific Map implementation e.g. HashMap or LinkedHaashMap.



Since LinkedHashMap maintains the insertion order of elements (see here), you can collection elements in the LinkedHashMap as shown in the following example:

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Java Program to convert a List to map in Java 8.
 * This example shows a trick to preserve order of element
 * in the list while converting to Map using LinkedHashMap. 
 */
public class Java8Demo {

    public static void main(String args[]) {

        List<String> hostingProviders = Arrays.asList("Bluehost",
                       "GoDaddy", "Amazon AWS", "LiquidWeb", "FatCow");
        System.out.println("list: " + hostingProviders);

        Map<String, Integer> cards2Length = hostingProviders.stream()
                .collect(Collectors.toMap(Function.identity(),
                                String::length,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
        System.out.println("map: " + cards2Length);

    }

}

Output:
list: [Bluehost, GoDaddy, Amazon AWS, LiquidWeb, FatCow]
map: {Bluehost=8, GoDaddy=7, Amazon AWS=10, LiquidWeb=9, FatCow=6}

You can see that order of elements in both List and Map is exactly the same. So use this version of the Collectors.toMap() method if you want to preserve the ordering of elements in the Map.




That's all about how to convert a List to Map in Java 8 using lambda expression and Streams. You can see it's much easier and concise using the lambda expression. Just remember that the Map returned by the Collectors.toMap() is not your regular HashMap, it is just a  class that implements the Map interface. It will not preserve the order of elements if you want to keep the order the same as in the original list then use the LinkedHashMap as shown in the last example.



Also, don't forget to provide a merge function if you are not sure about whether your List will contain duplicates or not. It will prevent the IllegalStateException you get when your List contains duplicates and you want to convert it to a Map, which doesn't allow duplicate keys.

Read more: https://javarevisited.blogspot.com/2016/04/10-examples-of-converting-list-to-map.html#ixzz8hjGRtIhf

Difference between Abstract class vs Interface  in Java 8
Prima facia, in Java 8, an interface looks like an abstract class and one can reason about, can we use an interface with default methods in place of an abstract class in Java?

Well, I believe they are for two different purposes and we will learn more once we start using Java 8 regularly, but following the semantics difference between abstract class and interface with default method will guide you further :

1) Abstract classes are classes, so they are not restricted to other restrictions of the interface in Java, like abstract class can have the state, but you cannot have the state on the interface in Java.

2) Another semantic difference between an interface with default methods and an abstract class is that you can define constructors inside an abstract class, but you cannot define constructors inside an interface in Java.

In reality, default or defender methods are introduced to maintain backward compatibility and the same time making Collection API more suitable to be used inside key Java 8 features like lambda expressions.

Without adding default methods, it wasn't possible to declare any new method on the existing interface in Java without breaking all classes which implement it, but because of the default method, you can now better evolve your API.

They defend your code against implementing new methods hence they are also called defender methods. If you want to know more about default methods or new changes in Java 8 in general, I suggest you check out these Java 8 to Java 21 courses from sites like Udemy and Pluralsight. 

Difference between Abstract class and Interface  in Java 8



That's all about the difference between an Abstract class and an Interface in Java 8. Though I certainly agree that the difference between abstract class and the interface has reduced with the introduction of default methods, as well as allowing static methods inside the interface and their usage will evolve once Java 8 becomes a mainstream Java development version, but you must remember that an abstract class is a class and an interface is an interface.

The key difference is that an abstract class can maintain a state but the interface cannot, and an abstract class can also have a constructor that is not allowed inside the interface even in Java 8. If you are designing API then use interface and if you are abstracting both state and behavior then use an abstract class.

Read more: https://www.java67.com/2017/08/difference-between-abstract-class-and-interface-in-java8.html#ixzz8hjGXU7q5

Difference between array and Hashtable or HashMap in Java

A couple of days back someone asked me about the difference between an array and a hashtable, though this is a generic data structure and programming question, I'll answer it from both a general programming perspective as well on Java perspective where Hashtable is not just a data structure but also a class from Java Collection API. Even though both array and hashtable data structure are intended for fast search i.e. constant time search operation also known as O(1) search, the fundamental difference between them is that array require an index while hash table requires a key which could be another object. 

Actually, the hash table is an extension of the array where the hash function is used to convert the key into an index required by the array, which is further used to locate the element in the internal array. Yes, a Hashtable or HashMap is also backed by an array, but that's not the full story. 

It also uses a linked list and binary tree data structure to deal with collision and maintain acceptable performance. In this article, you will learn about both structural and performance differences between array and hashtable in Java. 

Let's now compare array in Java with the Hashtable or HashMap class in Java. Most of the differences are also valid for general array vs hash table data structure in computer science programming. Hash table data structure is also known as dictionary in Python and Map in many other programming languages. 









Difference between Array vs hash table in Java
Now, let's see some more details to understand the difference between Array and Hashtable in Java: 



1. Index based vs  Key Based

The first and foremost difference between a hash table and the array is that array needs an index while the hash table needs a key to search the value. 



2. Fixed Capacity vs Dynamic Capacity

The second difference is that array has a fixed capacity but the hashtable can accommodate more elements than the capacity on the internal array by using chaining and a linked list. 



3. Performance

The third difference between a hash table and the array is that the array always gives you O(1) performance if you know the index but hash table performance can be O(n) in the worst case where due to collision you need to traverse through linked list to find the correct value object. 


This has been slightly improved now when JDK uses binary tree instead of linked list from Java 8 and worst-case performance is now pegged to O(logN)

Difference between array and Hashtable or HashMap in Java





4. Usage

 Array stores just one object but the hash table stores mapping, I mean pair of key and value objects. 



5. Sorting

Array doesn't enforce any requirement on storing objects but hash tables usually require the key object to implement some interface so that it can calculate hash values. For example, in Java, we have Hashtable and HashMap classes in java.util package which is our general-purpose hash table data structure requires key objects to implement equals() and hashcode() method.



6. Collision

There is a collision in the array but collision is possible in the hash table



7. Synchronization

the array is not synchronized and cannot be made synchronized but Hashtable is synchronized in Java.



Similarities

Now that we have seen some differences between array and hash table data structure, now let's see some similarities. 

1. both are linear data structure

2. hashtable is internally backed by an array

3. both provide fast search performance when a search is by key or index.  



That's all about the difference between array and hash table data structure in Java. I have used the Hashtable class as a representative of hash table data structure in Java but you can put HashMap, ConcurrentHashMap or any other Map implementation in place of Hashtable and most of the differences will be valid. 



Read more: https://www.java67.com/2021/08/difference-between-array-and-hashtable.html#ixzz8hjGgtFsr


How to get the first and last item in an array in Java? Example Tutorial

Firstly, before going about finding the first and the last item of an array in java. We need to fully understand what an array is and how it works. What then is an Array? An array is a data structure in java that holds values of the same type with its length specified right from creation time. Think of a container, like a crate of eggs or coke. What I am trying to say is that when you are creating your array, the items coming in must be the same as you have specified as length and you must specify how many items are coming. If you have stated that the items coming are integers, so it is and no other data type (e.g string, char e.t.c) can be there and vice versa. Or you can say an array is a collection of similar type of elements which has contiguous memory location.


Oftentimes you may have to work on a task whereby you will have to store a large number of values during the execution of a program. for instance, you need to read 50 numbers, calculate their average, and find out how many numbers are above the average, and how many numbers are below average.



Your program first reads the numbers and calculates their average, then compares each number with the average to determine whether it is above the average or below. To accomplish this task, the numbers must all be stored in variables.



You have to declare 50 variables and repeatedly write almost identical code 50 times. Writing a program this way would be impractical.





How to get the first and last item in an array in Java?
So, how do you solve this problem? An efficient, organized approach is needed. Java and most other high-level languages provide a data structure, the array, which stores a fixed-size sequential collection of elements of the same type. In the present case, you can store all 50 numbers into an array and access them through a single array variable.


Java array is an object which contains elements of a similar data type. Additionally, The elements of an array are stored in a contiguous memory location. It is a data structure where we store similar elements. We can store only a fixed set of elements in a Java array. 



In Java, an array is an object of a dynamically generated class. Java array inherits the Object class and implements the Serializable as well as Cloneable interfaces. We can store primitive values or objects in an array in Java

How do you create an array?



Int [] num = new int [5];

In these previous lines of codes, you are creating an array of integer numbers with the variable name "num" and you are assigning it to a new integer of length 5. meaning that the items coming can only be an integer and it has to be 5. anything that does not correlate with what you have specified results to compilation error.

In an array you can access each element through its index, the index number starts from zero. So the first element is index num 0, the second element is index num 1, and the third element is index num 2, and on and on as you can see above.

If you want to get the total number of the index you will do length - 1 because the length you specified at creation time is 5 and because the indexes start from 0, not 1. so, the length of the indexes is 4.
 

There are two types of array.

Single Dimensional Array
Multidimensional Array


you can loop through the array elements with the for loop, and use the length property to specify how many times the loop should run.

 

Note:

 Array indexing always starts with zero, Not 1. Please don’t forget.

 Array knows its length.







Array Methods in java.

An Array is a class in java or it is pretty to say an object a reference type by nature that can hold either primitive types of values or reference types. There are methods readily available in java arrays that you can call to use at any time:
Arrays.toString() : This method prints an array
Arrays.asList(): This method takes an array and converts it to list
Arrays.sort(): This method sorts an array.
Arrays.compare(): This method compares two different arrays.
Arrays.fill(): This method populates an empty array with the items you put in the method.
Arrays.equals(): This method checks if two arrays are equal.
Arrays.copyOf(): This method makes another copy of the same array you use this method on.

E.t.c.



How to get the first and last item in an array in Java? Example Tutorial



Let’s check a few lines of codes, we want to find the first and the last element in an array!

 

public class Code{
public static void main(String args[]){
 int a[]=new int[5];
 a={1,2,3,4,5};
 int size=a.length;
 System.out.println("First element of an array is" +a[0]);
 System.out.println("Last element of an array is "+a[size-1]);
 }
 }


Line 1 is a class declaration. And 3 is the main method. An array was created in line 5 with values initialized to them at creation. The array’s length method was called and stored inside variable size, line 8 prints the first element, and line 9 prints the last element.

OUTPUT:
The first element of an array is 1

The last element of an array is 5


How do find the largest and smallest number in an array? (solution)
How to find prime factors of an integer in Java? (solution)
How to check if LinkedList contains any cycle in Java? (solution)
Write a Program to remove duplicates from the array without using Collection API? (program)
Write a program to check if a number is Prime or not? (solution)
Write a method to count occurrences of  a character in String? (Solution)
How to find a Fibonacci sequence upto a given Number? (solution)
How to check if a number is Armstrong number or not? (solution)
Write a method to remove duplicates from ArrayList in Java? (Solution)
Write a program to check if a number is Palindrome or not? (program)
Write a program to check if Array contains duplicate number or not? (Solution)
How to calculate Sum of Digits of a number in Java? (Solution)
How to prevent Deadlock in Java? (solution)
How to reverse String in Java without using API methods? (Solution)
Write a method to check if two String are Anagram of each other? (method)
Write a function to find the middle element of linked list in one pass? (solution)
How to solve Producer-Consumer Problem in Java. (solution)
Write a program to find first non repeated characters from String in Java? (program)
How to check if a number is binary in Java? (answer)
Write a Program to Check if a number is Power of Two or not? (program)
How to find a largest prime factor of a number in Java? (solution)
How to calculate factorial using recursion in Java? (algorithm)
How to declare and initialize two dimensional array in Java? (solution)
Write a program to find missing number in a sorted array? (algorithm)
How to search element in array in Java? (solution)
10 Points about Array in Java? (must know facts)
How to find top two maximum on integer array in Java? (solution)
How to sort array using bubble sort algorithm? (algorithm)


Read more: https://www.java67.com/2021/12/how-to-get-first-and-last-item-in-array.html#ixzz8hjH2Ai1L

What is try with resource in Java? Example tutorial

In Java we normally use resources like file, network connection, socket connection, database connection etc ,dealing with resources is not a difficult task but what if after using the resources programmers forget to close the resources. As we know in Java everything is Object so if we forget to close or shut down the resource its responsibility of GC that will recollect it when its no longer used but we can reduce resource exhaustion by explicitly closing the resources as soon we done with our job with the resources. Some resources like database connection are very precious and would surely run out of resources if waited for finalization. Many database servers only accept a certain number of connections so if forget to close properly will create problem.
 


So JDK 7 come with the solution of try with resource also called automatic resource management where when try block ended automatically it will close or release our resource. Let see one example how to use try with resource in JDK 7

The try-with-resources statement is a feature introduced in Java 7. It simplifies the resource management and improves the code readability by automatically closing the resources that are opened in a try block. In this article, we will learn how to use try-with-resources in Java to handle resources like file streams, database connections, and network sockets. We will also discuss the benefits of using try-with-resources over traditional try-catch-finally blocks.


How to Use try with resource in Java - JDK 7
Here's an example of using try with resources in Java
public void readFile(String fileName) throws IOException {
    try (FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader = new BufferedReader(fileReader)) {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}



In this example, we're reading from a file using a FileReader and a BufferedReader. Instead of manually closing these resources, we're using try with resources to automatically close them once the block of code inside the try statement completes. This helps to ensure that the resources are properly released and avoids potential resource leaks.

Here is another example of using try-with-resource statement in Java:


What is try with resource in Java? Example tutorial



Difference between try-with-resource and try-catch-finally pattern in Java
Yes, there are several benefits of using the try-with-resources statement over the traditional try-catch-finally block:

1. Simplified Code

The try-with-resources statement simplifies code by reducing the number of lines required to create, use, and close a resource.

2. Automatic Resource Management
When a try block is exited, the resources are automatically closed. There is no need to explicitly close the resources, reducing the risk of resource leaks.

3. Exception Handling
The try-with-resources statement ensures that any exceptions thrown when closing resources are handled correctly. If an exception is thrown when closing a resource, it will be suppressed, and any exceptions thrown in the try block will still be thrown.

4. Support for Multiple Resources
The try-with-resources statement supports managing multiple resources in a single statement, further simplifying code and reducing the chance of errors.

Overall, the try-with-resources statement is a significant improvement over the traditional try-catch-finally block when dealing with resources in Java. It is more concise, less error-prone, and handles exceptions more efficiently. Though you must note that your resource must implement AutoCloseable interface in order to be used inside try-with-resource statement. This concept is also frequently tested on Java interviews. 



That's all about what is try with resource in Java and how to use it for automatica resource management in Java. The try-with-resources statement in Java simplifies the process of handling resources by eliminating the need for explicit finally blocks. This reduces the amount of code and makes it easier to read and maintain. 

Additionally, it ensures that resources are always properly closed, even in the presence of exceptions. The try-with-resources statement is a great addition to Java 7 and is highly recommended for use in any code that deals with resources such as files, sockets, and database connections.


Read more: https://www.java67.com/2012/12/how-to-use-try-with-resource-in-java.html#ixzz8hjHDs9j1

How to write to a File with try-with-resource in Java? Example Tutorial

Hello Java programmers and all people learning Java, if you are familiar with try-wit-resource statement then you know that its a great language functionality and tool to open files, sockets, streams, and network connections or any resource which are require closing. Before try-with-resource was introduce in Java 7, Java developers have to manually write try catch finally block to close the connections for both success and failure cases to prevent resource leak but it was also tricky and many programmer make mistakes which actually resulted in resource leaks. One common example of that is running out of file descriptors which is used for both opening file and socket in Java.  

If you have worked with web servers like Tomcat and Weblogic then you may have seen the dreaded java.net.SocketException: Too many files open java.io.IOException  which is a popular case of resource leak. 



I have explained that on my earlier post about right way to close streams in Java, but try-with-resource really makes it easy to use resources like files and sockets in Java as you don't need to manually close them anymore, try-with-resource will take care of it. 

This means you also don't need to write code which can hinder business logic and bloat your codebase.  All in all, this result in better and more cleaner and readable code. 



How to write file using try-with-resource in Java? Example
Here is a code example of writing a file using try-with-resource statement in Java. In this program, I have opened file inside try() statement and as long as Resource implement AutoCloseable interface, try-with-resource functionality in Java will take care of closing it.  

This functionality is also known as ARM or Automatic Resource management in Java and you need minimum JDK 7 to us this language feature, its not available in Java 6 and earlier version.

package dto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * How to write to a file using try-with-resource statement
 * in Java. 
 * 
 * @author java67
 */

public class Helloworld {

    public static void main(String args[]) {

        // Writing to a file using try-with-resource statement in Java
        // This means any resource opened in try statement will be
        // automatically closed by Java. 
        // This is valid for all classes which implements AutoCloseable
        // interface. JDBC 4.1 classes are also retrofitted to implement
        // AutoCloseable so that they can be used with try-with-resource
        // statement in Java. 
        
        try (FileWriter writer = new FileWriter("programming.txt");
             BufferedWriter bwr = new BufferedWriter(writer);) {
            
            bwr.write("Java");
            bwr.write("\n");
            bwr.write("C++");
            bwr.write("\n");
            bwr.write("JavaScript");
            bwr.close();
            System.out.println("succesfully written to a file");
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        
    }

}


You can see that how we have opened resource inside try(), it looks like function arguments 

   try (FileWriter writer = new FileWriter("programming.txt");
             BufferedWriter bwr = new BufferedWriter(writer);) {
You can also see that we can open multiple resources as long as they are separated by semi-colon. If you notice, we only have catch block and there is no finally block in the end because we don't really need any code for closing these resources, they will be automatically be closed when the code inside try block is finished.

How to write File with try-with-resource in Java? Example Tutorial



Important points about try with resource functionality in Java:
Here are a couple of worth remembering points about this awesome functionality in Java:

1. This functionality is known as try-with-resource or Automatic resource management, ARM in Java which is obvious because it care of closing resources. 

2. Only requirement for this functionality is that resource must be opened inside try statement and they must implement AutoCloseable interface, without this it will not work. 

3. You can still use finally block with try and catch but its not mandatory.



That's all about how to use try-with-resource statement in Java. This should be now the standard way to open resources in Java which require closing. The basic requirement is that the resource like InputStream, File, or Socket must implement AutoCloseable statement. As long as they do, try-with-resource functionality will close them. 



Read more: https://www.java67.com/2023/01/how-to-write-file-in-java-with-try.html#ixzz8hjHK7gS0

10 points on TCP/IP Protocol, Java Programmers should Know

TCP/IP is one of the most important protocol as its backbone of HTTP, internet and most of the communication happens today. It's also important from technical interview perspective, you might have already seen difference between TCP and UDP multiple time during interviews ( I have seen). I believe every programmer, not just Java developer should know what is TCP/IP protocol? How it works and the below points I am going to mention. These are basic points and most of you already know but during Interview I have found many developers who doesn't really know what TCP/IP offers and how it works and what are the pros and cons of TCP/IP protocol. That's where, I think this article will help you. Anyway, let's jump into technical details now. 




10 points on TCP/IP Protocol, Java Programmers Should Know
Here are the 10 essential point about TCP/IP protocol every programmer should know and remember. 

1) TCP/IP is a Connection oriented Protocol, which means connection is established before sending data. Here is how TCP/IP works and how connections are established. 





2) TCP/IP maintains order of data, which means receiver will receive data in same order as sender has sent to them. This prevents lots of out-of-order handling in application.

3) TCP/IP provides delivery guarantee, which means no message is lost in transit. TCP/IP achieves this guarantee by acknowledgement. When Sender sends data, a TCP packet, it waits for receiver’s ack. If no ack received than it sends the data again, till then it holds data in its buffer. When receiver responds, it also indicate size of unused buffer and receive window, to say how much more data it can accept.



4) Each TCP/IP connection is identified by combination of local IP, local port, remote IP address and remote port. You can use netstat command to see all TCP/IP connection for a host. netstat works in both windows and Linux.

$ netstat -na | grep tcp
tcp        0      0 0.0.0.0:7500                0.0.0.0:*                   LISTEN    
tcp        0      0 127.0.0.1:36655             127.0.0.1:1521   

Since TCP connection also has different state, you can use them to find only ESTABLISHED connection or Server connection, which are listening. You can check netstat command to learn more options.


5) TCP No Delay and Naggle's algorithm
This question was asked to me during an interview with a big investment bank where I was interviewing for a low latency Java developer role, mainly working with FIX protocol or developing similar protocol.  You now might have guessed it that its related to performance. 

Yes, Nagle's algorithm is a way of improving the efficiency of TCP/IP networks by reducing the number of packets that need to be sent over the network and its controlled using an option called TCP_NODELAY. 

6) TIME_WAIT state
This is one of the state of socket which you will see when you query using Linux commands like netstat. You will mostly see the state with TCP connection and not with UDP connections because there are no states used in UDP, this column is usually blank.  TIME_WAIT state means  the socket is waiting after close to handle packets still in the network.

7) Congestion control
TCP protocol also does congestion control which means it doesn't operate in full speed at the start instead it slowly increased the speed depending upon how receiver is performing to avoid congestion and exhausting bandwidth. 

8) TCP States
Here are the different states on which a TCP Socket can be. 
       ESTABLISHED
              The socket has an established connection.
       SYN_SENT
              The socket is actively attempting to establish a connection.
       SYN_RECV
              A connection request has been received from the network.
       FIN_WAIT1
              The socket is closed, and the connection is shutting down.
       FIN_WAIT2
              Connection is closed, and the socket is waiting for a shutdown from the remote end.
       TIME_WAIT
              TIME_WAIT state means  the socket is waiting after close to handle packets still in the network.
       CLOSED The socket is not being used.
       CLOSE_WAIT
              The remote end has shut down, waiting for the socket to close.
       LAST_ACK
              The remote end has shut down, and the socket is closed. Waiting for acknowledgement.
       LISTEN The socket is listening for incoming connections.  Such sockets are not included in the output unless you specify the --listening  (-l)  or
              --all (-a) option.
       CLOSING
              Both sockets are shut down but we still don't have all our data sent.
       UNKNOWN
              The state of the socket is unknown.


9) netstat
You can see this article about how to use netstat command to find TCP connections as well as process id of the process which opens that connection. 



10) sliding window protocol
This is another key concept associated with TCP connection and a useful algorithms to know. As per Wikipedia, A sliding window protocol is a feature of packet-based data transmission protocols. Sliding window protocols are used where reliable in-order delivery of packets is required, such as in the data link layer (OSI layer 2) as well as in the Transmission Control Protocol (TCP).


Read more: https://www.java67.com/2015/03/10-points-on-tcpip-protocol-java.html#ixzz8hjHRDugg


8 Examples of Primitive Data Types In Java (int, long, boolean, float, double, byte, char, and short)

Hello guys, Data types are first few things you should learn when you start learning a programming language and when it comes to learn Java, there are 8 primitive data types which you should know. These are divided into three categories, numeric, text, and boolean values. Numeric data types can be further divided into two like natural numbers and floating pointing numbers. But, Before we get to a list of the 10 examples of primitive data types in Java, let me tell you a little bit more about what the primitive data types are.  There are essentially 8 primitive data types in Java. They are int, byte, short, long, float, double, boolean, and char. The primitive data types are not considered objects and represent raw values. These primitive data types are also stored directly on the stack.






8 Examples Of Primitive Data Types In Java
In Java, int data type is used for a 32-bit integer value, char is used for a 16-bit character, boolean is used for a true or false value, short is used for a 16-bit integer value, and so on and so forth. 
In this list, we have compiled all of the primitive data types in Java along with some examples. Keep reading to find out more. 

1. int
int is actually one of the most commonly used primitive data types in Java. It is also known as an integer and can hold a wide range of non-fractional number values. What you need to understand is that Java stores int using 32 bits of memory. 

What this means is that it can represent values from -2,147,483,648 (-2^31) to 2,147,483,647 (2^31-1). Sounds amazing, right?

It is very simple to declare an int in Java. 

int x = 424_242;

int y;

By default, the value of an unassigned int will be 0. It is also possible to define an int in a method. But then, you must assign a value to the variable before you can use it.  You can also easily perform any of the arithmetic operations on int. But you need to keep in mind that decimal values will be removed from the variable value when you perform calculations. 

2. byte
A byte is very similar to an int. The key difference is that a byte only takes up 8 bits of memory. As you can see, we call it a byte because it is basically made up of 8 bits. Since the memory size of a byte is really small, it can only store values between -128 (-2^7) and 127 (2^7 – 1).

It is very easy to declare a byte in Java:

byte b = 100;

byte empty;

primitive data types in Java with range and size


3. short
You can think of short as basically a compromise between int and byte. A short is made up of 16 bits of memory; so it is larger than a byte but smaller than an int. A short is able to store values from -32,768(-2^15) to 32,767(2^15 – 1). You can declare a short in Java like this:

short s = 20_020;

short s;

The default value of a short is also 0.

4. long
A long is another primitive data type that is related to int. You can think of long as basically the big brother of int. A long makes use of a massive 64 bits of memory. This makes it possible for long to hold a larger set of possible values.  

A long can store values between -9,223,372,036,854,775,808 (-2^63) and 9,223,372,036,854,775,807 (2^63 – 1).

The default value of a long is also 0. You can declare a long in Java with the following syntax:

long l = 1_234_567_890;

long l;
8 Examples Of Primitive Data Types In Java




5. float
The float type is used to represent basic fractional numbers in Java. It is very precise up to 6 decimal points. After that. the number can become less precise and more of an estimate. 

Just like int, a float is also stored in 32 bits of memory. But since it deals with decimal points, the range of a float is different from an int. It can store values between 1.40239846 x 10-45, and 3.40282347 x 1038.

You can see below how to declare a float type in Java:

float f = 3.45f;

float f;

6. double
A double type in Java can be seen as the big brother of the float type. It is stored in 64 bits of memory and offers double the precision in the case of decimal numbers. It can represent a much larger range of possible numbers. But, the precision of a float is not unlimited. 

The range of a double type in Java is between  4.9406564584124654 x 10-324 and 1.7976931348623157 x 10308. That range can also be positive or negative.

It is very easy to declare a double in Java:

double d = 3.13457599923384753929348D;

double d;

Just like float, the default value of a double type is 0.0. 

how to convert primitive data types in Java


7. boolean
A boolean is actually one of the most simple primitive data types in Java. As you may already know, a boolean can contain only 2 values: true or false. A boolean is stored in just one bit of data. But, for convenience, Java stores a boolean in a single byte instead of just a bit.  It is very easy to declare a boolean in Java:

boolean b = true;

boolean b;

The default value of a boolean is false. The boolean type is actually the cornerstone of controlling the flow of programs. You can also use the boolean type on other operators. 

8. char 
Now we come to the final entry in the list of primitive data types in Java: char. It is also called a character and is stored in 16 bits of memory that represent a Unicode-encoded character. The range of a char type is from 0 to 65,535. This represents \u0000' to ‘\uffff' in Unicode. You can declare a char in Java with the following syntax:

char c = 'a';

char c = 65;

char c;

When you are defining variables in Java, you can use any literal character and it will automatically get transformed into the respective Unicode encoding. The default value of a character type is /u0000'. 


Read more: https://www.java67.com/2022/11/examples-of-primitive-data-types-in-java.html#ixzz8hjHbucq8

How to Find Lowest Common Ancestor of a Binary Tree in Java? Example Tutorial

Hello guys, if you are wondering how to find the lowest common ancestor of a binary tree in Java then you are at the right place. Earlier, I have shared 40+ binary tree questions and today I am going to share solution of one of the popular binary tree question here. To find the lowest common ancestor of a binary tree in java requires that we run through a binary search tree and how it operates.  What then is a binary search tree? A Binary tree is a data structure in which each node can have at most two children. That is, each node in the binary tree will have data, left child and right child. The first node of the tree is called the Root.

Below is the image of the Binary search tree, the first circle with 15 is called the root node and it has two children, left and right nodes with the values,10 and 20 respectively. Node 10 has two children too with 5 and 13 as values. The left child of node 10 does not have any child but, the right node with value 13 has two children nodes 12 and 14 respectively.
How to Find Lowest Common Ancestor of a Binary Tree in Java? Example Tutorial
Fig 1.0: Finding the lowest common ancestor.

There are some important things to note when determining is if a tree is a binary tree or not, which are :

 All data in the nodes of the left sub-tree are lesser than the right.


 In the Children nodes, all data on the left are lesser than the right.

 All data in the nodes of the left sub-tree is lesser than the root

 All data in the nodes of the right sub-tree is greater than the root.

 So, with all these bullet points you can determine if a tree is a binary tree or not.

Now, before looking into codes what do we mean by the lowest common ancestor? Let’s see.

The lowest common ancestor is defined between two nodes n1 and n2 as the lowest node in T that has both n1 and n2 as descendants(where we allow a node to be a descendant of itself). 

Or we can say The lowest common Ancestor (LCA) of two nodes and in a rooted tree is the lowest (deepest) node that is an ancestor of both and remember that an ancestor of a node in a rooted tree is any node that lies on the path from the root to (including).

Note the following:

· All of the node’s values will be unique.

· node1 and node2 are different and both values will exist in the binary tree.

· You can use extra memory, helper functions, and can modify the node structure but, you can’t add a parent pointer.








Java Program to find the Lowest Common Ancestor of a Binary Tree
We would be looking at how to find the lowest common ancestor of a binary search tree in java. I'm sure the picture above communicates something about the problem we are about to solve. Let's check some codes!

public class LowestCommonAncestor {
static class Node {
int data;
Node left, right;
public Node(int data) {
this.data = data;
left = right = null;
}
}
public static int LCA(Node root, int n1, int n2) {
if (root == null) {
return -1;
}
Node current= root;
int lca = -1;
while (current != null) {
if (current.data < n1 && current.data < n2) {
// LCA is present in the right sub tree
current = current.right;
} else if (current.data > n1 &¤t.data > n2) {
// LCA is present in left sub tree
current = current.left;
} else {
lca = current.data;
break;
}
}
return lca;
}
public static void main(String[] args) {
LowestCommonAncestor.Node root = new LowestCommonAncestor.Node(20);
root.left = new LowestCommonAncestor.Node(11);
root.right = new LowestCommonAncestor.Node(24);
root.right.left = new LowestCommonAncestor.Node(21);
root.right.right = new LowestCommonAncestor.Node(35);
root.right.right.left = new LowestCommonAncestor.Node(32);
root.right.right.right = new LowestCommonAncestor.Node(40);
System.out.println(LCA(root, 24, 40));
System.out.println(LCA(root, 11, 21));
System.out.println(LCA(root, 32, 40));
}
}
OUTPUT:

24

20

35


Line 1 was the class declaration with an embedded Node class with instance variables: data of type int, right, and left of type node respectively. Constructor was declared in line 5 that takes in parameter “data” of type int and was assigned to the instance variable in line 6. In line 7, right was assigned to left, and null was assigned to the right. 

In other words, it means left is null. The method LCA was declared in line 10 with three parameters which are the root of type node, int n1, and n2 respectively. If the root is null then it should return -1 in line 12. 

Line 14 stored the root parameter into the variable "current" of the type node. Variable "lca" of type int was set to -1 too. 

So, from line 17, inasmuch as the root is not null it would proceed to check if the data in the current node is less than n1 and n2 and if so current.right is assigned to current(which means  "lca" is present in the right sub-tree) else, if the data in the current node is greater than n1 and n2, current.left is assigned to current(which means  "lca" is present in the left sub-tree). 


But if the two conditions are not met. Variable "lca" should still hold current.data. Line 25 breaks the loop and "lca" was returned in line 28

The main method starts from line 30 and line 31 created the instance of the “LowestCommonAncestor” class, with the value of 20 as the root.

Line 32 to line 37 were adding data to the nodes as specified from the root whether left or right. Line 38,39 and 40 called the method “LCA” respectively and was printed out.


Read more: https://www.java67.com/2022/01/how-to-find-lowest-common-ancestor-of.html#ixzz8hjHym0AY

Read more: https://www.java67.com/2021/12/how-to-get-first-and-last-item-in-array.html#ixzz8hjGyaLYf
