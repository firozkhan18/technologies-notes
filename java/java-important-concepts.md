## 10 JDK 7 Features to Revisit, Before You Welcome Java 8 - Examples

It's been almost a month since Java 8 is released and I am sure all of you are exploring new features of JDK 8. But, before you completely delve into Java 8, it’s time to revisit some of the cool features introduced on Java 7. If you remember, Java 6 was nothing on the feature, it was all about JVM changes and performance, but JDK 7 did introduce some cool features which improved the developer's day to day task. Why I am writing this post now? Why I am talking about Java 1. 7, when everybody is talking about Java 8? Well I think, not all Java developers are familiar with changes introduced in JDK 7, and what time can be better to revisit an earlier version than before welcoming a new version.

I don't see automatic resource management used by developers in daily life, even after IDE's has got the content assist for that. Though I see programmers using String in Switch and Diamond operator for type inference, again there is very little known about the fork-join framework,  catching multiple exceptions in one catch block or using underscore on numeric literals.

So I took this opportunity to write a summary sort of post to revise these convenient changes and adopt them into our daily programming life. There are a couple of good changes on NIO and new File API, and lots of other at the API level, which is also worth looking at. I am sure combined with Java 8 lambda expression, these features will result in a much better and cleaner code.

### 10 Best JDK 7 Features Every Java developer should learn 
Here are my favorite features from Java 7 release which every Java developer should learn:
### 1) Type inference
Before JDK 1.7 introduce a new operator <<, known as diamond operator to making type inference available for constructors as well. Prior to Java 7, type inference is only available for methods, and Joshua Bloch has rightly predicted in Effective Java 2nd Edition, it’s now available for constructor as well.

Prior JDK 7, you type more to specify types on both left and right hand side of object creation expression, but now it only needed on left hand side, as shown in below example.

Prior JDK 7
```java
Map<String, List<String>> employeeRecords =  new HashMap<String, List<String>>();
List<Integer> primes = new ArrayList<Integer>();
```
In JDK 7
```java
Map<String, List<String>> employeeRecords =  new HashMap<>();
List<Integer> primes = new ArrayList<>();
```
So you have to type less in Java 7, while working with Collections, where we heavily use Generics. See here for more detailed information on diamond operator in Java.


### 2) String in Switch
Before JDK 7, only integral types can be used as selector for switch-case statement. In JDK 7, you can use a String object as the selector. For example,
```java
String state = "NEW";

switch (day) {
   case "NEW": System.out.println("Order is in NEW state"); break;
   case "CANCELED": System.out.println("Order is Cancelled"); break;
   case "REPLACE": System.out.println("Order is replaced successfully"); break;
   case "FILLED": System.out.println("Order is filled"); break;
   default: System.out.println("Invalid");

}
```
equals() and hashcode() method from java.lang.String is used in comparison, which is case-sensitive. Benefit of using String in switch is that, Java compiler can generate more efficient code than using nested if-then-else statement. See here for more detailed information of how to use String on Switch case statement.


### 3) Automatic Resource Management
Before JDK 7, we need to use a finally block, to ensure that a resource is closed regardless of whether the try statement completes normally or abruptly, for example while reading files and streams, we need to close them into finally block, which result in lots of boiler plate and messy code, as shown below :
```java
public static void main(String args[]) {
        FileInputStream fin = null;
        BufferedReader br = null;
        try {
            fin = new FileInputStream("info.xml");
            br = new BufferedReader(new InputStreamReader(fin));
            if (br.ready()) {
                String line1 = br.readLine();
                System.out.println(line1);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Info.xml is not found");
        } catch (IOException ex) {
            System.out.println("Can't read the file");
        } finally {
            try {
                if (fin != null) fin.close();
                if (br != null) br.close();
            } catch (IOException ie) {
                System.out.println("Failed to close files");
            }
        }
    }
```
Look at this code, how many lines of boiler codes?

Now in Java 7, you can use try-with-resources feature to automatically close resources, which implements AutoClosable and Closeable interface e.g. Streams, Files, Socket handles database connections, etc.

JDK 7 introduces a try-with-resources statement, which ensures that each of the resources in try(resources) is closed at the end of the statement by calling close() method of AutoClosable. Now same example in Java 7 will look like below, a much concise and cleaner code :
```java
public static void main(String args[]) {
       try (FileInputStream fin = new FileInputStream("info.xml");
  BufferedReader br = new BufferedReader(new InputStreamReader(fin));) {
  if (br.ready()) {
   String line1 = br.readLine();
   System.out.println(line1);
  }
 } catch (FileNotFoundException ex) {
  System.out.println("Info.xml is not found");
 } catch (IOException ex) {
  System.out.println("Can't read the file");
 }
}
```
Since Java is taking care of closing opened resources including files and streams, may be no more leaking of file descriptors and probably an end to file descriptor error. Even JDBC 4.1 is retrofitted as AutoClosable too.

### 4) Fork Join Framework
The fork/join framework is an implementation of the ExecutorService interface that allows you to take advantage of multiple processors available in modern servers. It is designed for work that can be broken into smaller pieces recursively.

The goal is to use all the available processing power to enhance the performance of your application. As with any ExecutorService implementation, the fork/join framework distributes tasks to worker threads in a thread pool.

The fork-join framework is distinct because it uses a work-stealing algorithm, which is very different than producer consumer algorithm. Worker threads that run out of things to do can steal tasks from other threads that are still busy.

The centre of the fork/join framework is the ForkJoinPool class, an extension of the AbstractExecutorService class. ForkJoinPool implements the core work-stealing algorithm and can execute ForkJoinTask processes.

You can wrap code in a ForkJoinTask subclass like RecursiveTask (which can return a result) or RecursiveAction. See here for some more information on fork join framework in Java.


### 5) Underscore in Numeric literals
In JDK 7, you could insert underscore(s) '_' in between the digits in an numeric literals (integral and floating-point literals) to improve readability. This is especially valuable for people who uses large numbers in source files, may be useful in finance and computing domains. For example,
```java
int billion = 1_000_000_000;  // 10^9
long creditCardNumber =  1234_4567_8901_2345L; //16 digit number
long ssn = 777_99_8888L;
double pi = 3.1415_9265;
float  pif = 3.14_15_92_65f;
```
You can put underscore at convenient points to make it more readable, for examples for large amounts putting underscore between three digits make sense, and for credit card numbers, which are 16 digit long, putting underscore after 4th digit make sense, as they are printed in cards. By the way remember that you cannot put underscore, just after decimal number or at the beginning or at the end of number. For example, following numeric literals are invalid, because of wrong placement of underscore:
```java
double pi = 3._1415_9265; // underscore just after decimal point
long creditcardNum = 1234_4567_8901_2345_L; //underscore at the end of number
long ssn = _777_99_8888L; //undersocre at the beginning
```
See my post about how to use underscore on numeric literals for more information and use case.

### 6) Catching Multiple Exception Type in Single Catch Block
In JDK 7, a single catch block can handle more than one exception types.

For example, before JDK 7, you need two catch blocks to catch two exception types although both perform identical task:
```java
try {

   ......

} catch(ClassNotFoundException ex) {
   ex.printStackTrace();
} catch(SQLException ex) {
   ex.printStackTrace();
}
```
In JDK 7, you could use one single catch block, with exception types separated by '|'.
```java
try {

   ......

} catch(ClassNotFoundException|SQLException ex) {

   ex.printStackTrace();

}
```
By the way, just remember that Alternatives in a multi-catch statement cannot be related by subclassing. For example, a multi-catch statement like below will throw compile time error :
```java
try {

   ......

} catch (FileNotFoundException | IOException ex) {

   ex.printStackTrace();

}
```
Alternatives in a multi-catch statement cannot be related by sub classing, it will throw an error at compile time :
java.io.FileNotFoundException is a subclass of alternative java.io.IOException
        at Test.main(Test.java:18)

see here to learn more about improved exception handling in Java SE 7.


### 7) Binary Literals with prefix "0b"
In JDK 7, you can express literal values in binary with prefix '0b' (or '0B') for integral types (byte, short, int and long), similar to C/C++ language. Before JDK 7, you can only use octal values (with prefix '0') or hexadecimal values (with prefix '0x' or '0X').
```java
int mask = 0b01010000101;
```

or even better
```java
int binary = 0B0101_0000_1010_0010_1101_0000_1010_0010;
```

### 8) Java NIO 2.0
Java SE 7 introduced java.nio.file package and its related package, java.nio.file.attribute, provide comprehensive support for file I/O, and for accessing the default file system. It also introduced the Path class which allows you to represent any path in the operating system.

New File system API complements the older one and provides several useful method checking, deleting copying, and moving files. for example, now you can check if a file is hidden in Java. You can also create symbolic and hard links from Java code.

The JDK 7 new file API is also capable of searching for files using wild cards. You also get support to watch a directory for changes. I would recommend checking the Java doc of a new file package to learn more about this interesting useful feature.


### 9) G1 Garbage Collector
JDK 7 introduced a new Garbage Collector known as G1 Garbage Collection, which is a short form of garbage first. G1 garbage collector performs clean-up where there is most garbage. To achieve this it split Java heap memory into multiple regions as opposed to 3 regions in the prior to Java 7 version (new, old and permgen space). It's said that G1 is quite predictable and provides greater throughput for memory-intensive applications.


### 10) More Precise Rethrowing of Exception
The Java SE 7 compiler performs more precise analysis of re-thrown exceptions than earlier releases of Java SE. This enables you to specify more specific exception types in the throws clause of a method declaration. before JDK 7, re-throwing an exception was treated as throwing the type of the catch parameter. For example, if your try block can throw ParseException as well as IOException.

In order to catch all exceptions and rethrow them, you would have to catch Exception and declare your method as throwing an Exception. This is sort of obscure non-precise throw, because you are throwing a general Exception type (instead of specific ones) and statements calling your method need to catch this general Exception. This will be more clear by seeing the following example of exception handling in code prior to Java 1.7
```java
public void obscure() throws Exception{
    try {
        new FileInputStream("abc.txt").read();
        new SimpleDateFormat("ddMMyyyy").parse("12-03-2014");        
    } catch (Exception ex) {
        System.out.println("Caught exception: " + ex.getMessage());
        throw ex;
    }
}
```
From JDK 7 onwards you can be more precise while declaring the type of Exception in throws clause of any method. This precision in determining which Exception is thrown from the fact that, If you re-throw an exception from a catch block, you are actually throwing an exception type which:

   1) your try block can throw,
   2) has not handled by any previous catch block, and
   3) is a subtype of one of the Exception declared as catch parameter

This leads to improved checking for re-thrown exceptions. You can be more precise about the exceptions being thrown from the method and you can handle them a lot better at client-side, as shown in the following example :
```java
public void precise() throws ParseException, IOException {
    try {
        new FileInputStream("abc.txt").read();
        new SimpleDateFormat("ddMMyyyy").parse("12-03-2014");        
    } catch (Exception ex) {
        System.out.println("Caught exception: " + ex.getMessage());
        throw ex;
    }
}
```
The Java SE 7 compiler allows you to specify the exception types ParseException and IOException in the throws clause in the preciese() method declaration because you can re-throw an exception that is a super-type of any of the types declared in the throws, we are throwing java.lang.Exception, which is super class of all checked Exception. Also in some places you will see final keyword with catch parameter, but that is not mandatory any more.

That's all about what you can revise in JDK 7. All these new features of Java 7 are very helpful in your goal towards clean code and developer productivity. With lambda expression introduced in Java 8, this goal to cleaner code in Java has reached another milestone. Let me know, if you think I have left out any useful feature of Java 1.7, which you think should be here.


Related Java 8 Tutorials
If you are interested in learning more about new features of Java 8,here are my earlier articles covering some of the important concepts of Java 8:
20 Examples of Date and Time in Java 8 (tutorial)
How to use Stream class in Java 8 (tutorial)
How to use filter() method in Java 8 (tutorial)
How to use forEach() method in Java 8 (example)
How to join String in Java 8 (example)
How to convert List to Map in Java 8 (solution)
How to use peek() method in Java 8 (example)
5 Books to Learn Java 8 from Scratch (books)
How to convert stream to array in Java 8 (tutorial)
Java 8 Certification FAQ (guide)
Java 8 Mock Exams and Practice Test (test)


Read more: https://javarevisited.blogspot.com/2014/04/10-jdk-7-features-to-revisit-before-you.html#ixzz8hiOboANb

## Java FileReader + BufferedReader Example

There are multiple ways to read a file in Java e.g. you can use a Scanner as we have seen in the last example, or you can use the BufferedReader class. The advantage of using a BufferedReader to read a text file is speed. It allows faster reading because of internal buffering provided by BufferedReader. Other Reader classes like FileReader access the file or disk every time you call the read() method but BufferedReader keeps 8KB worth of data in its internal buffer which you can read it without accessing the file multiple times. It's loaded when you access the file the first time for a subsequent read.

 The BufferedReader class is also a good example of a Decorator design pattern because it decorates existing readers e.g. FileReader to provide buffering, remember, the reading from file functionality still comes from the FileReader class.
PauseUnmute
Fullscreen

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


Related Java File tutorials you may like
How to write to a file using BufferedWriter in Java? (solution)
How to append text to a file in Java? (solution)
2 ways to read a text file in Java? (solution)
How to read InputStream as Stream in Java? (example)
How to load data from a CSV file in Java? (example)
How to find the highest occurring word from a file in Java? (solution)
How to read/write an XLSX file in Java? (solution)

P. S. - If you running in Java 8, you can also use streams to lazily read the file content by using the Files.lines() method which returns a Stream of String from a text file. You can then perform operations like map() and filter() on file content.


Read more: https://www.java67.com/2016/08/BufferedReader-Example-how-to-read-text-file-in-java.html#ixzz8hiOC3UAG

## How to read file in Java using Scanner Example - text files

### Reading a file with Scanner
From Java 5 onwards java.util.Scanner class can be used to read file in Java. Earlier we have seen examples of reading file in Java using FileInputStream and reading file line by line using BufferedInputStream and in this Java tutorial, we will See How can we use Scanner to read files in Java. Scanner is a utility class in java.util package and provides several convenient methods to read int, long, String, double etc from a source which can be an InputStream, a file, or a String itself.

 As noted on How to get input from User, Scanner is also an easy way to read user input using System.in (InputStream) as the source. The main advantage of using Scanner for reading files is that it allows you to change delimiter using the useDelimiter() method, So you can use any other delimiter like comma, pipe instead of white space.

### How to Read File in Java - Scanner Example
How to read file in Java 5 using Scanner with ExampleIn this Java program, we have used java.util.Scanner to read file line by line in Java. We have first created a File instance to represent a text file in Java and then we passed this File instance to java.util.Scanner for scanning. 

The scanner provides methods like hasNextLine() and readNextLine() which can be used to read file line by line. It's advised to check for next line before reading next the line to avoid NoSuchElementException in Java.  

Here is the complete code example of using Scanner to read text files in Java :

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * Java program to read files using Scanner class in Java.
 * java.util.Scanner is added on Java 5 and offers a convenient method to read data
 *
 * @author
 */
public class ScannerExample {

    public static void main(String args[]) throws FileNotFoundException {
 
        //creating File instance to reference text file in Java
        File text = new File("C:/temp/test.txt");
     
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
     
        //Reading each line of the file using Scanner class
        int lineNumber = 1;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
        }      
   
    }  
 
}
```
```
Output:
line 1 :--------------------- START------
-----------------------------------------------
line 2 :Java provides several way to read files.
line 3 :You can read file using Scanner, FileReader,
FileInputStream and BufferedReader.
line 4 :This Java program shows How to read file using java.util.Scanner class.
line 5 :--------------------- END-----------------------
---------------------------------
```
This is the content of test.txt file exception line numbers. You see it doesn't require much coding to read file in Java using Scanner. You just need to create an instance of Scanner and you are ready to read file.

Other Java IO tutorials you may like
What is memory mapped file in Java
How to parse XML File using DOM parser
How to read properties file in Java
How to read XML file in Java using JDOM library
How to find hidden files in Java with Example
How to set File permissions in Java

Read more: https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html#ixzz8hiR70n7z

## Why use Memory Mapped File or MapppedByteBuffer in Java? Example

Memory Mapped Files in Java is a rather new java concept for many programmers and developers, though it’s been there from JDK 1.4 along with java.nio package. Java IO has been considerably fast after the introduction of NIO and memory-mapped file offers the fastest IO operation possible in Java, that's the main reason of Why high-performance Java application should use Memory Mapped files for persisting data. It's already quite popular in the high-frequency trading space, where the electronic trading system needs to be super fast and one-way latency to exchange has to be on the sub-microsecond level.

IO has always been a concern for performance-sensitive applications and memory-mapped file allows you to directly read from memory and write into memory by using direct and non-direct byte buffers. 

The key advantage of  Memory Mapped File is that the operating system takes care of reading and writing and even if your program crashed just after writing into memory. OS will take care of writing content to File. 

One more notable advantage is shared memory, memory-mapped files can be accessed by more than one process and can act as shared memory with extremely low latency. See Peter's comment also in the comment section.

Earlier we have seen how to read xml files in Java and how to read a text file in java and in this Java IO tutorial we gonna look at what is a memory-mapped file, how to read and write from a memory-mapped file, and important points related to Memory Mapped Files.

And, If you are new to the Java world then I also recommend you go through these advanced core Java courses to learn Java in a better and more structured way. This is one of the best and up-to-date courses to learn Java online.

### What is Memory Mapped File and IO in Java
memory mapped file and io in java read write exampleMemory mapped files are special files in Java which allows Java program to access contents  directly from memory, this is achieved by mapping whole file or portion of file into memory and operating system takes care of loading page requested and writing into file while application only deals with memory which results in very fast IO operations. Memory used to load Memory mapped file is outside of Java heap Space. Java programming language supports memory mapped file with java.nio package and has MappedByteBuffer to read and write from memory.

### Advantage and Disadvantage of Memory Mapped file
Possibly main advantage of Memory Mapped IO is performance, which is important to build high frequency electronic trading system. Memory Mapped Files are way faster than standard file access via normal IO. Another big advantage of memory mapped IO is that it allows you to load potentially larger file which is not otherwise accessible. Experiments shows that memory mapped IO performs better with large files. 

Though it has disadvantage in terms of increasing number of page faults. Since operating system only loads a portion of file into memory if a page requested is not present in memory than it would result in page fault Most of major operating system like Windows platform, UNIX, Solaris and other UNIX like operating system supports memory mapped IO and with 64 bit architecture you can map almost any file into memory and access it directly using Java programming language. 

Another advantages is that the file can be shared, giving you shared memory between processes and can be more than 10x lower latency than using a Socket over loopback.

MappedByteBuffer Read Write Example in Java
Below example will show you how to read and write from memory mapped file in Java. We have used RandomAccesFile to open a File and then mapped it to memory using FileChannel's map() method, map method takes three parameter modes, start, and length of the region to be mapped. It returns MapppedByteBuffer which is a ByteBuffer for dealing with memory mapped file.

```java
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

  public class MemoryMappedFileInJava {

    private static int count = 10485760; //10 MB

    public static void main(String[] args) throws Exception {

        RandomAccessFile memoryMappedFile = new RandomAccessFile("largeFile.txt", "rw");

        //Mapping a file into memory

        MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);

        //Writing into Memory Mapped File
        for (int i = 0; i < count; i++) {
            out.put((byte) 'A');
        }

        System.out.println("Writing to Memory Mapped File is completed");     

        //reading from memory file in Java
        for (int i = 0; i < 10 ; i++) {
            System.out.print((char) out.get(i));
        }

        System.out.println("Reading from Memory Mapped File is completed");

    }

}
```

### Important Points about Memory Mapped File and IO in Java
To summarize the post here is quick summary of memory mapped files and IO in Java:

- 1. Java supports Memory mapped IO with java.nio package.
- 2. Memory mapped files is used in performance sensitive application e.g. high frequency electronic trading platforms.
- 3. By using memory mapped IO you can load portion of large files in memory.
- 4. Memory mapped file can result in page fault if requested page is not in memory.
- 5. Ability to map a region of file in memory depends on addressable size of memory. In a 32 bit machine you can not access beyond 4GB or 2^32.
- 6. Memory mapped IO is much faster than Stream IO in Java.
- 7. Memory used to load File is outside of Java heap and reside on shared memory which allow two different process to access File. By the way this depends upon, whether you are using direct or non-direct byte buffer.
- 8. Reading and writing on memory mapped file are done by operating system, so even if your Java Program crash after putting content into memory it will make to disk, until OS is fine.
- 9. Prefer Direct Byte buffer over Non Direct Buffer for higher performance.
- 10. Don't call MappedByteBuffer.force() method to often, this method is meant to force operating system to write content of memory into disk, So if you call force() method each time you write into memory mapped file, you will not see true benefit of using mapped byte buffer, instead it will be similar to disk IO.
- 11. In case of power failure or host failure, there is a slim chance that the content of the memory mapped file is not written into the disk, which means you could lose critical data.
- 12. MappedByteBuffer and file mapping remain valid until buffer is garbage collected. sun.misc.Cleaner is probably the only option available to clear memory mapped file.

That’s all on memory mapped file and memory mapped IO in Java. Its pretty useful concept and I encourage you to learn more about it. If you are working on high frequency trading space than memory mapped file is quite common there.

Read more: https://javarevisited.blogspot.com/2012/01/memorymapped-file-and-io-in-java.html#ixzz8hiS3BzuX

How to read Properties File in Java – XML and Text Example Tutorial

Reading and writing properties file in Java is a little different than reading or writing text file in Java or reading xml files in Java using xml parsers like DOM because Java provides the special provision to the properties file. For those who are not familiar with Properties files in java, It is used to represent configuration values like JDBC connectivity parameter or user preference settings and has been a primary source of injecting configuration on Java applications.  Properties file in Java is a text file that stores data in the form of key and value, key being known as property. Java allows you to read the value of the property by providing its name which makes it easy to access configuration settings. Many application like Spring and Spring Boot also uses property file for configurations for example application.properties is commonly used to setup Spring boot. 



Two more popular examples of properties file are jdbc.properties often used to store database connection settings like URL, username, and password, and log4j.properties file which settings for java logging using log4j. 

There are also many frameworks that use Java properties files like Struts, Spring, Displaytag, etc. Another advantage of using properties files is that you can represent data either in xml format or in properties format. xml format will be particularly useful if you are sharing configuration or settings with some external tool that understands only XML. 



In this article, we will see how to read and write into Properties files in Java in both xml and text format.

And, If you are new to Java Programming then I also recommend you go through these Java online courses on Udemy to learn Java in a better and more structured way. This is one of the best and up-to-date courses to learn Java online.

How to read Properties File in Java – XML and Text Example Tutorial




Reading values from Java Properties File
example of How to read Properties File in Java – XML and Text formatHere is a sample code example of reading a properties file in Java. In this example, we will read a property from jdbc.properties file which contains database connection settings, you might have already used that.

Anyway, it contains username, password, and jdbc driver class name as a key-value format. We will read these values from the Java program using java.util.Properties class which represents properties file in Java program.



jdbc.username=test
jdbc.password=unknown
jdbc.driver=com.mysql.jdbc.Driver

Code Examples of Reading Properties File in Java

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    public static void main(String args[]) throws FileNotFoundException, IOException {

        //Reading properties file in Java example
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("c:/jdbc.properties");
     
        //loading properties from a property file
        props.load(fis);

        //reading property
        String username = props.getProperty("jdbc.username");
        String driver = props.getProperty("jdbc.driver");
        System.out.println("jdbc.username: " + username);
        System.out.println("jdbc.driver: " + driver);

    }
}

Output:
jdbc.username: test
jdbc.driver: com.mysql.jdbc.Driver


If you read any property which is not specified in the properties file then you will props.getProperty() will return null. 

Now let's see another example of reading property files from xml format. as you know properties file in java can be represented in xml format and Java provides a convenient method called loadFromXML() to load properties from xml file. here is a quick example of parsing xml properties file and reading data.


How to Read Property file in XML format – Java
In the earlier section, we have seen a sample working code example of reading properties file (.properties) but as I said earlier you can also define property in xml format this method is also very popular among various Java logging frameworks e.g. log4j, and also among others. 

In this section, we will see how to read property file which is written in xml format. If you see the code not many changes instead of  Properties. load() we are using Properties.loadFromXML() and then the rest of the stuff of getting property and printing its value is the same as in the last example.

By the way here is our sample java properties file in xml format, which defined two entries with key jdbc.username and jdbc.password.


<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
   <properties> <entry key="jdbc.username">root</entry>
        <entry key="jdbc.password">mysql</entry>
   </properties>

And here is a Java program that will read XML properties file in Java:

public static void main(String args[]) throws FileNotFoundException, IOException {

        //Reading properties file in Java example
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("c:/properties.xml");
     
        //loading properties from properties file
        props.loadFromXML(fis);

        //reading property
        String username = props.getProperty("jdbc.username");
        System.out.println("jdbc.username: " + username);
     
}

output:
jdbc.username: root


We have seen how to read properties files in java, In both text and xml format. Properties file are immensely helpful for providing settings and configuration data to any Java program. Text properties file can only represent linear values but xml properties file can also represent hierarchical values which makes Properties file preferred choice in logging frameworks.


Read more: https://javarevisited.blogspot.com/2012/03/how-to-read-properties-file-in-java-xml.html#ixzz8hiXZ7BL5

How to Parse or Read XML File in Java >> XML Tutorial Example

How to parse xml files in Java or how to read xml files in java is one of common need of a Java Developer working with an enterprise Java application which uses XML for data representation, messaging, and data transfer. Java has good support to handle XML files and XML Documents and you can read XML Files in Java, create or write to XML file in Java by using various XML parsers available. Reading XML file is a little bit different than reading text or binary files in Java but it uses the same concept of File class.



Universal acceptability of XML and Java has helped them to grow together and they have a lot of things common in between just like Java is platform independence, XML provides data that is also platform-independent. You can use XML to transfer data between a legacy application written in C or C++ and Java.


What is important to work with XML in Java is the correct understanding of XML Parser, Basic knowledge of XML documents, etc. In this Java XML Tutorial, we will see how to parse an XML File by using both DOM  XML Parser. 

We will also see the difference between DOM and SAX parser in XML and other basics related to XML parsing in Java. I thought about this article after sharing my XPath notes in Java.






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
PlayUnmute
Fullscreen


How to set Execute Permission on File in Java
 boolean setExecutable(boolean exe, boolean owneronly) : This method is used to set the execute permission for the owner  of the file and also we can provide every user execute permission using this method, if the operation is successful then this method returns true.

This method is overloaded in this class if we want to provide execute permission only to the owner we can also use method  boolean setExecutable(boolean exe).

Here is a code example of setting or changing execute permission on File in Java. you can also change execute permission on directory similarly. In Unix, if a directory doesn't have to execute permission means you can not go inside that directory.









import java.io.File;
public class SetExecuteTest{

       public static void main(String[] args)throws SecurityException {

        File file = new File("C:/setExecuteTest.txt");

        if (file.exists()) {
            boolean bval = file.setExecutable(true);
            System.out.println("set the owner's execute permission: "+ bval);
        } else {
            System.out.println("File cannot exists: ");
        }

       if (file.exists()) {
            boolean bval = file.setExecutable(true,false);
            System.out.println("set the everybody execute permission: "+ bval);
        } else {
            System.out.println("File cannot exists: ");
        }
    }
}




Btw, if you don't remember all the file permission or forgot how to make a file read only or only group access, here is a nice diagram to recap what are different file permissions in UNIX or Linux environment:

How to Change File Permissions in Java – Example Tutorial





How to set Write Permission on File in Java
how to change or set file permissions in java code exampleboolean setWriteable(boolean write,boolean owneronly) : This method is used to set the write permission for the owner of the file, and also we can provide every user write permission using this method ,if the operation is successful then this method returns true. 

This method is overloaded and if we want to provide write permission only to the owner of the file we can use instead boolean setWritable(boolean write).

here is a code example of setting write permission to a file in Java. same code can also be used to change write permission from a Java File.

import java.io.File;


public class SetWritableTest{

       public static void main(String[] args)throws SecurityException {

        File file = new File("C:/setWriteableTest.txt");
        
        //set write permission on file only for owner
        if (file.exists()) {
            boolean bval = file.setWritable(true);
             System.out.println("set the owner's write permission: "+ bval);
        } else {
             System.out.println("File cannot exists: ");
        }

        //Set write permission on File for all.
        if (file.exists()) {
            boolean bval = file.setWritable(true,false);
            System.out.println("set the every user write permission: "+ bval);
        } else {
            System.out.println("File cannot exists: ");
        }


    }
}

How to set Read Permission on File in Java
boolean setReadable(boolean read,boolean owneronly) : This method is used to set the read permission for the owner of the file and also we can provide every user read permission using this method,if the operation is successful then this method returns true. This method is overloaded and if we want to provide read permission only to the owner we can use instead boolean setReadable(boolean read).

here is a complete code example to set write permission on File in Java. this code can also be used change write permission of a file in Java.

import java.io.File;
public class SetReadableTest{

       public static void main(String[] args)throws SecurityException {

        File file = new File("C:/setReadableTest.txt");
        if (file.exists()) {

            boolean bval = file.setReadable(true);
            System.out.println("set the Owner Read permission: "+ bval);
        } else {
            System.out.println("File cannot exists: ");
        }

       if (file.exists()) {
            boolean bval = file.setReadable(true,false);
            System.out.println("set the every user Read permission: "+ bval);
        } else {
            System.out.println("File cannot exists: ");
        }
    }
}


How to make a directory read-only in Java
boolean setReadOnly() : This method is used to make the file or directory read-only if we call this method on any file then no write operation can not be performed on that file.

import java.io.*;

public class SetReadOnlyTest{
      public static void main(String[] args)throws SecurityException {
           
        File file = new File("C:/setReadOnlyTest.txt");
        if (file.exists()) {
            boolean bval = file.setReadOnly();
            System.out.println("Read opearation is permitted: "+bval);
        } else {
            System.out.println("File cannot exists: ");
        }

    }
}


Read more: https://javarevisited.blogspot.com/2012/01/change-file-permissions-java-change.html#ixzz8hiYlA9OJ

Why character array is better than String for Storing password in Java? Example

Why character array is better than String for storing a password in Java was a recent question asked to one of my friends in a java interview. he was interviewing for a Technical lead position and has over 6 years of experience. Both Character array and String can be used to store text data but choosing one over the other is a difficult question if you haven't faced the situation already. But as my friend said any question related to String must have a clue on a special property of Strings like immutability and he used that to convince the interviewer. here we will explore some reasons why should you use char[] for storing passwords than String.




character array over string storing password javaThis article is in continuation of my earlier interview question post on String e.g. Why String is immutable in Java or How Substring can cause a memory leak in Java if you haven't read those you may find them interesting.


Here are a few reasons which make sense to believe that character array is a better choice for storing the password in Java than String:

1) Since Strings are immutable in Java if you store the password as plain text it will be available in memory until the Garbage collector clears it and since String is used in the String pool for reusability there is a pretty high chance that it will remain in memory for a long duration, which poses a security threat. 

Since anyone who has access to memory dump can find the password in clear text and that's another reason you should always use an encrypted password than plain text. Since Strings are immutable there is no way the contents of Strings can be changed because any change will produce new String, while if you char[] you can still set all his elements as blank or zero. So Storing the password in a character array clearly mitigates security risk of stealing passwords.

2) Java itself recommends using getPassword() method of JPasswordField which returns a char[] and deprecated getText() method which returns password in clear text stating security reason. Its good to follow advice from Java team and adhering to a standard rather than going against it.



3) With String there is always a risk of printing plain text in a log file or console but if use Array you won't print contents of the array instead its memory location gets printed. though not a real reason still makes sense.

String strPassword="Unknown";
char[] charPassword= new char[]{'U','n','k','w','o','n'};
System.out.println("String password: " + strPassword);
System.out.println("Character password: " + charPassword);

String password: Unknown
Character password: [C@110b053


That's all on why character array is a better choice than String for storing passwords in Java.  Though using char[] is not just enough you need to erase content to be more secure. I also suggest working with hash'd or encrypted password instead of plain text and clearing it from memory as soon as authentication is completed.


Read more: https://javarevisited.blogspot.com/2012/03/why-character-array-is-better-than.html#ixzz8hiYz9MLH

How to replace Anonymous Class to Lambda Expression in Java 8? Example Tutorial

Hello guys, you may be thinking why I am talking about Anonymous class now when many Java programmers have already switched to Java 8 and many have already moved on from Anonymous class to Lambda expression in? Well, I am doing it because I am seeing many Java programmers who find it difficult to write and read code using lambda expression in new Java 8 way. It's also my own experience that if you know the problem first, you can better understand the solution (lambda expression). Some of you might remember, the opening scene of MI 2 (Mission Impossible 2), when Nekhorovich says to Dimitri that "Every search for a hero must begin with something that every hero requires, a villain. Therefore, in our search for a hero, Belairiform, we created the monster, Chimera". 

Well, Anonymous class is not that sort of monster but it is one of the reason which makes lambda expression hero of Java 8.  Though Anonymous class is not the only reason lambda expression was introduced in Java, it provides you a nice problem solution analogue to understand the use of lambda expression in Java and how it can help in writing cleaner, more readable code.


If you know the purpose of Anonymous class in Java, which is a way to pass a block of dynamic code to a function, you will understand the purpose of lambda expression too and this is what you will learn here. In this article, I'll show you three very common Java examples using Anonymous class which will help you to learn and understand lambda expression better.



PlayUnmute
Fullscreen

3 Examples of Anonymous Class which can be replaced with Lambda Expression
Here are three common examples where I have used Anonymous class in past and which can be better written using Lambda expression and method reference in Java:



1. Sorting a List using Comparator
One of the most common place where you might have seen Anonymous class in Java is while sorting list of objects. Suppose you have a list of Books and you want to sort them on price. You use Collections.sort() method which requires code to compare object because it does know sorting but doesn't know how to compare objects. 


Now, how do you pass a block of code to a function in Java? You just can't. Java is an object-oriented language, so you must wrap the code inside a method and then wrap the method inside a class, and then create an object and pass that object to the function. This is painful isn't it?

Anonymous class solved that problem by doing all that on the fly as shown in following example, but it has its own problems which is why Lambda expression was introduced and we will see it in this article:

import java.util.*;

class Book {
    int price;
    String title;

    public Book(int price, String title) {
        this.price = price;
        this.title = title;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book(100, "Building Microservices"),
            new Book(200, "Microservices in Action"),
            new Book(50, "Effective Java")
        );

        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.price - b2.price;
            }
        });

        for (Book b : books) {
            System.out.println(b.title + " - $" + b.price);
        }
    }
}

The above Java program creates a Book class with two properties: price and title. Then, it creates a list of Book objects, sorts it using a custom Comparator object defined as an anonymous class, and prints the sorted books.

If you look at the code of Anonymous class, you will find that only useful code which method needed was the comparison logic e.g. book1.getPrice()-> book2.getPrice() but you write a lot more code to facilitate that. 


This boiler code makes your code ugly and less readable. Lambda expression solves this problem by removing all that boiler plat and only passing the crux of the code which matter, as shown below.
Other important examples of using Anonymous class in Java are running code on separate thread and handling Events on GUI which I will explain later when I will update this article. 

3 Examples of Anonymous Class to Learn Lambda Expression better in Java 8




Important points about Anonymous class and Lambda expression in Java
Now, let's revise important points about both Anonymous class and Lambda Expression in Java:

1. Like it says, Anonymous class is a class without name i.e. Anonymous, hence it cannot be reused.

2. Anonymous class was one of the way to pass code to a method e.g. Collections.sort() which requires code for comparison, Runnable.run() which requires code to be run on separate thread, and Button.actionPerformed() which requires code to be executed when a button is clicked.



3. Lambda expression makes it easy to pass a block of code to a function by removing all the boiler plate surrounding it due to object-oriented nature of Java programming language. This block of code is also refer as Anonymous function, similar to what JavaScript has.

4. You can also view lambda expression as method e.g. (int x, int y) ->> x + y is a method where left hand side is argument passed to method and right hand side is the code method execute and return the result of computation. 

Since Java is strongly typed language, you can further take out type definition e.g. int, which reduces this lambda expression to x, y->> x + y. The return statement is also omitted as lambda expression implicitly return value.


5. You can use lambda expression instead of Anonymous class in Java 8. This will make your code more expressive, clear and concise. It will also reduce memory footprint of compiled code because a new class will not be created for Anonymous class every time you use them.


That's all about common example of Anonymous class in Java which can be used to learn Lambda expression better. Once you understand what Anonymous class do and why we used it Java e.g. for passing some code to a function, you will immediately realize what lambda expression is doing. This is way better than understanding lambda expression by reading tutorials on syntax and trying to write lambdas. 

Once you understand purpose, syntax will flow naturally to you. Though, Anonymous class was not the only reason lambda expression was introduced, it also help to write functional style code in Java 8. I suggest you to read Java 8 in Action to learn more about motivation behind lambda expression and what it offer to Java world apart from solving the problem of Anonymous class.



Read more: https://www.java67.com/2023/01/3-examples-of-anonymous-class-to-lambda.html#ixzz8hiZL1cke

How to sort a Map by keys in Java 8 - Example Tutorial

Hello Java friends, In the last article, I have shown you how to sort a Map by values in Java 8, and in this tutorial, you will learn how to sort a Map by keys like a HashMap, ConcurrentHashMap, LinkedHashMap, or even Hashtable. Theoretically, you cannot sort a Map because it doesn't provide any ordering guarantee. For example, when you iterate over a HashMap, you don't know in which order entries will be traversed because HashMap doesn't provide any ordering. Then, how can you sort a Map which doesn't support order? Well, you can't and that's why you only sort entries of HashMap but you don't store the result back into HasMap or any other Map which doesn't support ordering. If you do so, then sorting will be lost.



Here is an example of incorrect sorting.

 Here even after sorting the Map, we are doing the mistake of storing the result back into a Map that doesn't provide any ordering guarantee, hence the result is an unordered map even after sorting.

Map sorted = budget
.entrySet()
.stream()
.sorted(comparingByKey())
.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2));

Here is the output to confirm what I said:
map before sorting: {grocery=150, utility=130, miscellaneous=90,
 rent=1150, clothes=120, transportation=100}
map after sorting by keys: {grocery=150, utility=130, miscellaneous=90,
 rent=1150, clothes=120, transportation=100}

If Map was sorted then the "clothes" should have come first ahead of "grocery". The mistake was blindly relying on toMap() method of the Collectors class. This class provides no guarantee of what kind of Map will be used to collect those elements. 

Since Map interface doesn't guarantee order, they are also not bound to store elements in any order. The same goes true for Set also, they also doesn't guarantee any order and only List is the collection which guarantees order. In fact, this is the most important difference between List, Set, and Map in Java. 



However, it's easy to solve this problem because the Collectors class also provides an overloaded version of toMap() class which allows you to instruct which kind of Map should be used to store those entries. 

You can use a LinkedHashMap to store mappings to preserve the sorting order because LinkedHashMap keeps keys in the order they were added. 

Here is the modified code which sorts a Map in the order of keys:

Map sorted = budget
.entrySet()
.stream()
.sorted(comparingByKey())
.collect(toMap(e -> e.getKey(), e -> e.getValue(),
(e1, e2) -> e2), LinkedHashMap::new));

The code passed into to toMap() method is interesting, the first parameter is used as a key, the second is used as a value and the third is used to break ties i.e. if two entries are equal then which entries will be chosen is decided by the third parameter, here we are using the second entry. 

The fourth parameter is the important one, which uses a constructor reference to tell Collector that copying a LinkedHashMap should be used. 






6 Steps to sort a Map by keys in Java 8
Here are the high-level steps you can take to sort a Map e.g. HashMap, Hashtable, ConcurentHashMap, or LinkedHashMap to sort them in the ascending and descending order of their keys:

1) Get all entries by calling the Map.entrySet() method

2) Get a stream of entries by calling the stream() method, which Set inherit from the Collection interface.

3) Sort all entries of Stream by calling the sorted() method.

4) In order to sort them by keys, provide a Comparator to a sorted() method that sorts entries by keys. This can be done by calling Map.Entry.comparingKey() method returns a Comparator which compares keys in their natural order.

5) Store the result of sorting in a LinkedHashMap by using the collect() method of Stream class.

6) Use Collectors.toMap() method to collect sorted entries into LinkedHashMap

Here is a block diagram which shows all the steps to sort a Map by key in Java:

6 Steps to sort a Map by keys in Java 8







Java Program to sort a Map by keys in JDK 8
Here is the complete Java program to sort Map e.g. HashMap by keys in JDK 8. In this example, you will learn to sort Map by both lambda expression and method reference. 

We'll also use new classes e.g. Stream and new methods added into Map.Entry class to sort all entries by their Map and store the result into a LinkedHashMap.

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

/*
* Java Program to sort a Map by keys in Java 8
* 
*/
public class Java8Demo{

public static void main(String[] args) throws Exception {

// a Map with string keys and integer values
Map<String, Integer> budget = new HashMap<>();
budget.put("clothes", 120);
budget.put("grocery", 150);
budget.put("transportation", 100);
budget.put("utility", 130);
budget.put("rent", 1150);
budget.put("miscellneous", 90);

System.out.println("map before sorting: " + budget);

// let's sort this map by keys first
Map<String, Integer> sorted = budget
.entrySet()
.stream()
.sorted(comparingByKey())
.collect(
toMap(e -> e.getKey(), e -> e.getValue(),
(e1, e2) -> e2, LinkedHashMap::new));

System.out.println("map after sorting by keys: " + sorted);

// above code can be cleaned a bit by using method reference
sorted = budget
.entrySet()
.stream()
.sorted(comparingByKey())
.collect(
toMap(Map.Entry::getKey, Map.Entry::getValue,
(e1, e2) -> e2, LinkedHashMap::new));


// now let's sort the map in decreasing order of keys
sorted = budget
.entrySet()
.stream()
.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
.collect(
toMap(Map.Entry::getKey, Map.Entry::getValue,
(e1, e2) -> e2, LinkedHashMap::new));

System.out.println("map after sorting by keys in descending order: " + sorted);
}

}

Output
map before sorting: {grocery=150, utility=130, miscellneous=90, 
       rent=1150, clothes=120, transportation=100}
map after sorting by keys: {clothes=120, grocery=150, miscellaneous=90, 
       rent=1150, transportation=100, utility=130}
map after sorting by keys in descending order: {utility=130, 
       transportation=100, rent=1150, miscellaneous=90, grocery=150, clothes=120}


You can see that initially map was not sorted but it is later sorted in the order of keys, which are a string and that's why clothes come ahead of the grocery. 

Similarly, when we sorted the map in descending order, clothes come last.

This proves that our sorting code is working fine.


If you want more sophistication and customization you can do that at the Comparator level and you can provide additional Comparator to comparingKey() method, which by default compare keys in their natural order.

For example, if a key were not String but a user object e.g. a Book, then you could have sorted the book by title, author, or price by providing the corresponding comparator to comparingKey() method of java.util.Map.Entry class. Both comparingKey() and comparingValue() are overloaded to accept a Comparator. 

Here is a nice diagram which shows both unsorted map and two sorted map which are sorted by key in ascending and descending order in Java:

How to sort a Map by keys in Java 8 - Example Tutorial




That's all about how to sort a Map by keys in Java 8. The simplest way to achieve this is by using the sorted() method of Stream and the newly added comparingKey() method of Map.Entry class. The stream sorts all elements and then depending upon your need, you can either print entries in sorted order or store them in an ordered map.

For example, LinkedHashMap, or a sorted map like TreeMap. You can also sort entries in their reverse order by just reversing the Comparator using the Collections.reverseOrder() method or Comparator.reversed() method of Java 8.


Read more: https://javarevisited.blogspot.com/2017/07/how-to-sort-map-by-keys-in-java-8.html#ixzz8hiZiGx1u

Top 21 Java HashMap Interview Questions and Answers

The java.util.HashMap is one of the workhorses of JDK. Along with ArrayList, it is one of the most used classes from Java's collection framework. There is hardly a real-world Java project, where I haven't seen the use of HashMap. It is an implementation of hash table data structure, and it's not a surprise that HashMap is so useful, as someone has rightly said, "if you could have just one data structure, make it a hash table". The hash table data structure allows you to search for a value in O(1) time if you have a key. In Java, several implementations of hash table data structures exist like Hashtable, ConcurrentHashMap, LinkedHashMap, etc. but HashMap is your general-purpose map.


Though, if you have a special need, you can use other hash table implementations available in JDK. For example, if you want to preserve the order of mapping, then you can consider using LinkedHashMap. If you wish to keep mappings sorted, then you can use TreeMap, which is a sorted map implementation.

Similarly, if you need a hash table implementation that is thread-safe and can be used in a concurrent application without compromising the Scalability, then consider using a ConcurrentHashMap from JDK 5.

Btw, if you are new to the Java world and JDK API in particular, I suggest you first go through an online Java course like the ones I have recommended in my list of best free core Java courses.  That will not only help you to do well on interviews but also help you to understand the fundamentals better.






Java HashMap Interview Questions
Here is my list of HashMap questions from Java Interviews. This list includes questions based on the internal implementation of HashMap, the Map API, how you use HashMap, and standard best practices while using HashMap in a Java application.


1. How does the put() method of HashMap works in Java? (answer)
The put() method of HashMap works in the principle of hashing. It is responsible for storing an object into the backend array. The hashcode() method is used in conjunction with a hash function to find the correct location for the object into the bucket. If a collision occurs, then the entry object which contains both key and value is added to a linked list, and that linked list is stored into the bucket location.


2. What is the requirement for an object to be used as a key or value in HashMap? (answer)
The key or value object must implement the equals() and hashcode() method. The hash code is used when you insert the key object into the map while equals are used when you try to retrieve a value from the map.



3. What will happen if you try to store a key that is already present in HashMap? (answer)
If you store an existing key in the HashMap, then it will override the old value with the new value, and put() will return the old value. There will not be any exception or error.


4. Can you store a null key in Java HashMap? (answer)
Yes, HashMap allows one null key, which is stored at the first location of bucket array e.g., bucket[0] = value. The HashMap doesn't call hashCode() on the null key because it will throw NullPointerException, hence when a user call the get() method with null, then the value of the first index is returned.



5. Can you store a null value inside HashMap in Java? (answer)
Yes, HashMap also allows null value; you can store as many null values as you want, as shown in the hashmap example post in this blog.



6. How does HashMap handle collisions in Java? (answer)

The java.util.HashMap uses chaining to handle collisions, which means new entries, an object which contains both key and values, are stored in a linked list along with the existing value, and then that linked list is stored in the bucket location.

In the worst case, where all key has the same hashcode, your hash table will be turned into a linked list, and searching a value will take O(n) time as opposed to O(1) time.



If you want to learn more about hash table data structure, I suggest you consult a good data structure and algorithm course like these best data structures and algorithms courses, which not only cover basic data structure like an array, linked list, binary tree, and hash table but also advanced concepts like O(n) sorting algorithms, Radix sort, Counting sort, etc.

Top 21 Java HashMap Interview Questions and Answers



7. Which data structure HashMap represents? (answer)
The HashMap is an implementation of hash table data structure, which is idle for mapping one value to other like id to name as you can search for value in O(1) time if you have the key.



8. Which data structure is used to implement HashMap in Java? (answer)
Even though HashMap represents a hash table, it is internally implemented by using an array and linked list data structure in JDK.  The array data structure is used as a bucket, while a linked list is used to store all mappings which land in the same bucket. From Java 8 onwards, the linked list is dynamically replaced by binary search tree, once a number of elements in the linked list cross a certain threshold to improve performance.



9. Can you store a duplicate key in HashMap? (answer)
No, you cannot insert duplicate keys in HashMap, it doesn't allow duplicate keys. If you try to insert an existing key with the new or same value, then it will override the old value, but the size of HashMap will not change i.e., it will remain the same. This is one of the reasons when you get all keys from the HashMap by calling keySet(). It returns a Set, not a Collection because Set doesn't allow duplicates.



10. Can you store the duplicate value in Java HashMap? (answer)
Yes, you can put duplicate values in HashMap of Java. It allows duplicate values; that's why when you retrieve all values from the Hashmap by calling the values() method, it returns a Collection and not a Set. Worth noting is that it doesn't return List because HashMap doesn't provide any ordering guarantee for key or value.



If you want to explore, you can also see these online Java Collections courses to learn more about fundamental properties of different collections in Java, like List, Set, and Map.

Java HashMap Interview Questions and Answers


11. Is HashMap thread-safe in Java? (answer)
No, HashMap is not a thread-safe in Java. You should not share a HashMap with multiple threads if one or more thread is modifying the HashMap e.g., inserting or removing a map. Though, you can easily share a read-only HashMap.


12. What will happen if you use HashMap in a multithreaded Java application? (answer)
If you use HashMap in a multithreaded environment in such a way that multiple threads structurally modify the map like add, remove or modify mapping, then the internal data structure of HashMap may get corrupt like some links may go missing, some may point to incorrect entries, and the map itself may become completely useless. Hence, it is advised not to use HashMap in the concurrent application; instead, you should use a thread-safe map e.g., ConcurrentHashMap or Hashtable.


13. What are the different ways to iterate over HashMap in Java? (answer)
Here are some of the ways to iterate over HashMap in Java:
by using keySet and iterator
by using entrySet and iterator
by using entrySet and enhanced for loop
by using keySet and get() method

You can see this article for an example of each of these ways to traverse a HashMap in Java.


14. How do you remove a mapping while iterating over HashMap in Java? (answer)
Even though HashMap provides a remove() method to remove a key and a key/value pair, you cannot use them to remove a mapping while traversing a HashMap. Instead, you need to use the Iterator's remove method to remove a mapping as shown in the following example:

Iterator itr = map.entrySet().iterator();

while(itr.hasNext()){
  Map.Entry current = itr.next();

  if(current.getKey().equals("matching"){
     itr.remove(); // this will remove the current entry.
  }
}

You can see that we have used Iterator.remove() method to remove the current entry while traversing the map. See this article to learn more about it.


15. In which order mappings are stored in HashMap? (answer)
Random order because HashMap doesn't provide any ordering guarantee for keys, values, or entries. When you iterate over a HashMap, you may get a different order every time you iterate over it.





16. Can you sort HashMap in Java? (answer)
No, you cannot sort a HashMap because, unlike List, it is not an ordered collection. Albeit, you can sort contents of HashMap by keys, values, or by entries by sorting and then storing the result into an ordered map like LinkedHashMap or a sorted map e.g., TreeMap.


17. What is the load factor in HashMap? (answer)
A load factor is a number that controls the resizing of HashMap when a number of elements in the HashMap cross the load factor as if the load factor is 0.75 and when becoming more than 75% full then resizing trigger which involves array copy.


18. How does resize happens in HashMap? (answer)
The resizing happens when the map becomes full or when the size of the map crosses the load factor. For example, if the load factor is 0.75 and then becomes more than 75% full, then resizing trigger, which involves an array copy. First, the size of the bucket is doubled, and then old entries are copied into a new bucket.


19. How many entries you can store in HashMap? What is the maximum limit? (answer)
There is no maximum limit for HashMap, you can store as many entries as you want because when you run out of the bucket, entries will be added to a linked list which can support an infinite number of entries, of course until you exhaust all the memory you have.

Btw, the size() method of HashMap return an int, which has a limit, once a number of entries cross the limit, size() will overflow, and if your program relies on that, then it will break.



This issue has been addressed in JDK 8 by introducing a new method called mappingCount(), which returns a long value. So, you should use mappingCount() for large maps. See Java SE 8 for Really Impatient to learn more about new methods introduced in existing interfaces in JDK 8.

Top 10 Java HashMap Interview Questions and Answers



21. What is the difference between the capacity and size of HashMap in Java? (answer)

The capacity denotes how many entries HashMap can store, and size denotes how many mappings or key/value pair is currently present.


21. What will happen if two different keys of HashMap return the same hashcode()? (answer)
If two keys of HashMap return the same hash code, then they will end up in the same bucket; hence collision will occur. They will be stored in a linked list together.


Read more: https://www.java67.com/2017/08/top-10-java-hashmap-interview-questions.html#ixzz8hia1tgIG

Top 50 Java Programs from Coding Interviews
Here is a big list of Java programs for Job Interviews. As I said, it includes questions from problem-solving, linked list, array, string, matrix, bitwise operators and other miscellaneous parts of programming. Once you are gone through these questions, you can handle a good number of questions on real Job interviews.

1. Fibonacci series (solution)
Write a simple Java program which will print Fibonacci series, e.g. 1 1 2 3 5 8 13 ... . up to a given number. We prepare for cross questions like using iteration over recursion and how to optimize the solution using caching and memoization.

2. A prime number (solution)
Write a Java program to check if a given number is prime or not. Remember, a prime number is a number which is not divisible by any other number, e.g. 3, 5, 7, 11, 13, 17, etc. Be prepared for cross, e.g. checking till the square root of a number, etc.

3. String Palindrome (solution)
You need to write a simple Java program to check if a given String is palindrome or not. A Palindrome is a String which is equal to the reverse of itself, e.g., "Bob" is a palindrome because of the reverse of "Bob" is also "Bob."  

Though be prepared with both recursive and iterative solution of this problem. The interviewer may ask you to solve without using any library method, e.g. indexOf() or subString() so be prepared for that.



4. Integer Palindrome (solution)
This is generally asked as follow-up or alternative of the previous program. This time you need to check if given Integer is palindrome or not. An integer is called palindrome if it's equal to its reverse, e.g. 1001 is a palindrome, but 1234 is not because the reverse of 1234 is 4321 which is not equal to 1234. You can use divide by 10 to reduce the number and modulus 10 to get the last digit. This trick is used to solve this problem.

5. Armstrong number (solution)
A number is called an Armstrong number if it is equal to the cube of its every digit. For example, 153 is an Armstrong number because of 153= 1+ 125+27, which is equal to 1^3+5^3+3^3. You need to write a program to check if the given number is Armstrong number or not.


6. Avoiding deadlock in Java (solution)
This is one of the interesting programs from Java Interviews, mostly asked to 2 to 3 years of experienced programmers or higher. The interviewer simply asked you to write code where a resource is accessed by multiple threads. 

You need to write code in such a way that no deadlock should occur. The trick to solving this problem is acquiring resources in order and release them in reverse order, e.g. first acquire resource R1 and only if you have got R1 to go for R2. This way, you can avoid deadlock.


7. Factorial (solution)
This is one of the simplest programs you can expect in interviews. It is generally asked to see if you can code or not. Sometimes interviewer may also ask about changing a recursive solution to iterative one or vice-versa.

8. Reverse a String (solution)
This problem is similar to the String Palindrome problem we have discussed above. If you can solve that problem, you can solve this as well. You can use indexOf() or substring() to reverse a String or alternatively, convert the problem to reverse an array by operating on character array instead of String. 


9. Remove duplicates from an array (solution)
Write a program to remove duplicates from an array in Java without using the Java Collection API. The array can be an array of String, Integer or Character, your solution should be independent of the type of array. If you want to practice more array-based questions, then see this list of top 30 array interview questions from Java interviews.


10. Printing patterns (solutions)
In this exercise you will be asked to print various kind of patterns like printing star patterns or printing pyramid patterns. Another common coding problem is printing left and right triangle of stars or numbers which require use of nested loops in Java. 


11. Print repeated characters of String? (solution)
This is another common coding interview questions where you need to print repeated characters like AAABBCCCC. You can solve this coding problem to learn about how to use loops and how to use break and continue to control the loop in Java. 


12. GCD of two numbers (solution)
GCD also known as Greatest Common divisor is a number which can fully divide the given two numbers. You can solve this problem either with brute force algorithms or you can also use Euclid's algorithm to find the GCD of two given numbers. 


13. The square root of a number (solution)
You need to write a program to calculate the square root of a number without using the Math.sqrt() function of JDK. You need to write your logic and method to calculate the square root. You can though use the popular algorithm, like Newton's method.


14. Reverse array in place (solution)
This one is my favorite coding exercise and I have asked this question multiple time on coding interviews. In place algorithms are quite useful while dealing with large data sets, for example if you have to reverse an array with 1 million objects then its very expensive to create another array of same size, at that time, this in place algorithm is a better choice. 

15. Reverse words of a sentence (solution)

16. Leap year (solution)

17. Binary search (solution)

18. String Anagram (solution)
Write a program to check if two given String is Anagram of each other. Your function should return true if two Strings are Anagram, false otherwise. A string is said to be an anagram if it contains the same characters and same length, but in a different order, e.g. army and Mary are anagrams. You can ignore cases for this problem, but you should clarify that from your interview.



19. Design a Vending Machine (solution)
This one of the popular OOAD (object-oriented analysis and design) question from Java Interviews. You will be given 3 hours to design and code a vending machine satisfying some of the business requirements. You also need to write unit tests to prove your code satisfy those requirements. You can see this article for more object-oriented analysis questions.

20. Reverse a number (solution)

21. The first non-repeated character of String (solution)

22. Finding Middle element of linked list in one pass (solution)

23. Pre-order traversal (solution)

24. Pre-order traversal without recursion (solution)

25. In order traversal (solution)

26. In order traversal without recursion (solution)

27. Post-order traversal (solution)

28. Postorder traversal without recursion (solution)

29. Print all leaves of a binary tree (solution)


30. Sort array using quicksort (solution)
You need to write a Java program to sort an array of integers using a quick sort algorithm. You cannot use any library method, e.g. JDK or a third party library, which means, you need to first implement the quicksort algorithm and then sort the array.


31. Insertion sort (solution)
Write a program to implement the insertion sort algorithm in Java. The program should take an unsorted array and sort it using insertion sort algorithm Also explain the best case and worst case time and space complexity of the Insertion sort algorithm.

32. Bubble sort (solution)
Write a program to implement the bubble sort algorithm in Java. You can use basic operators and functions, but sorting functions from Java API is not allowed.

33. Transpose a matrix (solution)

34. Print all permutations of String (solution)
Write a Java program to print all permutations of a given String. For example, if given String is "GOD" then your program should print all 6 permutations of this string, e.g. "GOD," "OGD," "DOG," "GDO," "ODG," and "DGO."

Java Programming Interview Questions for 2 to 3 years


35. Reverse a String in place (solution)

36. Adding two matrices in Java (solution)

37. Matrix multiplication (solution)

38. Removal all white space from String (solution)

39. Reverse a linked list (solution)
Write a program to reverse a singly linked list in Java. You can use iteration and recursion to solve this problem, but you should reverse a linked list in place.

Java Programming Interview Questions for experienced


40. Find the length of the linked list (solution)
Just write a program in Java to find the length of a singly linked list in one pass, i.e. in just one iteration of a singly linked list.


41. Check if a linked list has a loop (solution)
Write a program to check if given linked list has a loop or not. Sometimes a linked list get corrupt, and two nodes point to the same node, which forms the loop or cycle in the linked list.

42. Find the start of loop in a linked list (solution)
This is the extension of previous problem, once you are able to detect a loop in the linked list, the node where you deduct the loop becomes the starting point. 

43. Find the middle element of a linked list (solution)
You can find the middle element of a linked list by using two pointer coding interview patterns or slow and fast pointer approach where one pointer will be slow and move one step at a time and other will be fast and move two steps at a time. This way when first pointer will reach the end of the list, the second pointer will be at the middle element of the linked list. 

44. Find the 3rd element from the tail linked list (solution)
You need to write a program to find the 3rd element from the tail of a singly linked list. You need to solve this problem without iterating twice. If you want more linked list questions, you can see the article about frequently asked linked list interview questions.

Java Coding Interview Questions



44. Convert a linked list to a binary tree (solution)
It's possible to convert a doubly-linked list to a binary tree, you need to write a Java program which takes a doubly-linked list and returns a binary tree.


45. Sort a linked list (solution)
You need to given an unsorted linked list, and you need to write a program in Java to sort them in ascending order of the values in each node.


46. Iterative Quicksort (solution)
You need to write a Java program to implement quicksort sorting algorithm without recursion. You can use essential JDK classes and programming constructs, but recursion is not allowed.


46. Bucket sort (solution)
This program is increasingly getting popular on Java interview because it sorts a given array in linear time. Though there is a lot of prerequisites, e.g. you must know the maximum value present in the array, it is a very interesting problem from interview point of view. 

You need to write a program to implement a bucket sort algorithm in Java.



47. Counting sort (solution)
This is another problem which is similar to the previous one because counting sort is also a linear sorting algorithm. Just remember that bucket sort, and counting sort are different algorithms, so it's also good to state how they are different.


48. Check if two string rotation of each other
Write a program which accepts two given String and checks if they are the rotation of each. If they then return true otherwise return false. A String is said to be a rotation of other string if they contain same characters and the sequence is rotated across any character, e.g. "dabc" is a rotation of "abcd" but "dbac" is not.  If you want to practice more string-based questions, you can also see my list of 20 String-based algorithm questions from Java interviews.


49. LRU cache in Java (solution)
Write a program to implement an LRU cache in Java.  An LRU cache means Least Recently Used Cache which removes the least recently used element if the cache is full. You can use the  LinkedHashMap to implement LRU cache in Java.

Java Programming Interview Questions



50. Merge sort (solution)
Implement the merge sort algorithm in Java. You can write a recursive or iterative solution, whichever you like. You also need to explain the time and space complexity for the best, worst, and average case. If you need hint, Merge sort is based on divide and conquer technique, where you divide a big array or list into small parts and then sort them individually and then merge it. 

Java Programs from Programming Interviews


Now, let's see a couple of System deign questions which you can also prepare for programming interviews:

1. Difference between JWT, OAuth, and SAML? (answer)

2. Reverse Proxy and Forward Proxy? (answer)

3. Horizontal scaling and vertical scaling? (answer)

4. Microservices and Monolithic architecture? (Answer)

5. What is Rate Limiter? How does it work? (answer)

6. API Gateway vs Load Balancer? [solution] 

7. How does Single Sign On (SSO) works? (answer)

8. How does Apache Kafka works? why it so fast? (answer)

9. Difference between Kafka, ActiveMQ, and RabbitMQ? (answer)


That's all about top 50 programs from Java interviews. You can practice these Java programs even if you are not preparing for any Job interview. They not only help you to do well on your programming job interviews but also on learning how to code and developing your programming skill and coding sense.

These small programs touch several important areas, e.g. popular data structures like an array, linked list, binary tree, binary search tree, string, etc., popular algorithms, e.g. sieve of the Eratosthenes algorithm for generating primes, the Euclidean algorithm for calculating LCM, and GCF, Fibonacci sequence, printing patterns and so on.


Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz8hiankN5z

Java and OOP Overloading and Overriding Interview Questions
Ok, let's start with questions. Here is my list of 17 method overloading and overriding interview question which covers basics as well as some tricky parts of overloading and overriding. You can also write some code to test the concept and see when the compiler gives an error and which method is get called at run-time.




1) What is method overloading in Java?
If you have two methods which do the same thing it's better they have the same name, but two methods cannot have the same name until you overload them. 

So overloading is a process of declaring two methods with the same name but different method signature like System.out which is object of PrintStream class has several println() method to print different data types e.g. byte, short, int, char, float and double. All of them are called the overloaded method. 

Overloaded method calls are resolved during compile time in Java and they must have different method signatures. See here to learn more about method overloading in Java.


2) What is method overriding in Java?
Method overriding is another way to define a method with same name but different code but it must be in subclass. Overriding is based upon run-time Polymorphism as method calls are resolved at run-time depending upon actual object.  

For example if a variable of type Parent holds an object of Child class then method invoked will be from child class and not parent class, provides its overridden. 

In order to override a method, you must follow rules of method overriding which means declaring method with same signature in sub class. See here to learn more about method overriding in Java.


3) What is method hiding in Java?
static method cannot be overriding in Java because their method calls are resolved at compile time but it didn't prevent you from declaring method with same name in sub class. In this case we say that method in sub class has hidden static method from parent class. 


If you have a case where variable of Parent class is pointing to object of Child class then also static method from Parent class is called because overloading is resolved at compile time. See here to learn more about method hiding in Java.


4) What are the rules of overloading a method in Java?
One and only rule of method overloading in Java is that the method signature of all overloaded method must be different. 

Method signature is changed by changing either number of method arguments, or type of method arguments e.g. System.out.println() method is overloaded to accept different primitive types like int, short, byte, float etc.

They all accept just one argument but their type is different. You can also change method signature by changing order of method argument but that often leads to ambiguous code so better to be avoided. See here for full list of rules.


5) Difference between method overloading and overriding?
The fundamental difference between overloading and overriding is that formerly took place during compile time while later took place during run-time. 

Due to this reason, its only possible to overload virtual methods in Java. You cannot overload methods which are resolved during compile time e.g. private, static and final method cannot be overridden in Java. 



Also, rules of method overloading and overriding are different, for example in order to overload a method its method signature must be different but for the overriding method, it must be the same. See this image to learn more difference between overriding and overloading in Java.

Method overloading and overriding interview questions and answers


6) Can we overload static method in Java?
Yes, its possible to overload static method in Java. You can declare as many static method with same name as you want until all of them have different method signature. Remember, return type is not part of method signature, so they must have either different number of arguments, or different type of argument. 

There is a third option also which changes order of argument but I suggest not to do that because it often result in the ambiguous method call. It's very important to follow these best practices while overloading a static method in Java.


7) Can we override static method in Java?
No, you cannot override static method in Java because they are resolved and bonded during compile time. Since overriding is a run-time activity and if a method call is already resolved at compile time then it will not take place and that's why it's not possible to override static method in Java. 

But, you can define another static method of same signature in sub class, this is known as method hiding. Actual method called will depends upon the type of class and not on type of object as its the case with overriding. See here to learn more about why you cannot override static method in Java.


8) Can you prevent overriding a method without using final modifier?
Yes, there are some funky ways to prevent method overriding in Java. Though final modifier is only for that purpose you can use private keyword to prevent method overriding. How? If you remember correctly, in order to override a method, the class must be extensible. 


If you make the constructor of parent class private then its not possible to extend that class because its constructor will not be accessible in sub class, which is automatically invoked by sub class constructor, hence its not possible to override any method from that class. 

This technique is used in Singleton design pattern, where constructor is purposefully made private and a static getInstance() method is provided to access singleton instance. See here to learn more techniques to prevent method overriding in Java.


9) Can we override a private method in Java?
No, you cannot override private method in Java. Since private methods are not visible outside the class, they are not available in sub-class hence they cannot be overridden. By the way, how about overriding a private method inside an Inner class? Is it possible? See here to learn more why you cannot override private method in Java.


10) What is covariant method overriding?
One of the rule of method overriding is that return type of overriding method must be same as overridden method but this restriction is relaxed little bit from Java 1.5 and now overridden method can return sub class of return type of original method. 

This relaxation is known as co-variant method overriding and it allows you to remove casting at client end. 

One of the best examples of this comes when you override clone() method. Original Object.clone() method returns Object which needs to cast, but with co-variant method overriding you can directly return relevant type e.g. Date class returns object of java.util.Date instead of java.lang.Object. See here to learn more about co-variant method overriding in Java.


11) Can we change argument list of overridden method?
No, you cannot change the argument list of overridden method in Java. An overriding method must have same signature as original method. Only return type can be changed that to only to sub type of return type of original method.


12) Can we change return type of method in subclass while overriding?
No, you cannot change the return type of method during overriding. It would be violation of rules of overriding. Though from Java 5 onward you can replace the return type with sub type e.g. if original method has return type as java.lang.Object then you can change return type of overridden method as any type e.g. clone() method. This is also known as co-variant method overriding in Java.


13) Can we override a method which throws run-time exception without throws clause?
Yes, you can. There is no restriction on throwing RuntimeException from overriding method. So if your original method throws NullPointerException than its not necessary to throw NPE from overriding method as well.


14) How do you call super class version of an overriding method in sub class?
You can call it using super keyword. For example if you have a method calculate() in both parent and child class then from child class you can invoke parent class method calculate() as super.calculate(). It's very similar to calling super class constructor from sub class as shown here.


15) What are rules of method overriding in Java?
Some rules of method overriding are following :
Overriding method cannot throw higher exception than overridden one, but that's only true for checked exception.
Overriding method cannot restrict access of overridden method e.g. if original method is public then overriding method must be public, but it can expand access e.g. if original method is protected than overriding method can be protected or public.
See here for full list of rules of method overriding in Java.


16) Can we override a non-static method as static in Java?
No, its not possible to define a non-static method of same name as static method in parent class, its compile time error in Java. See here to learn more about the overriding static method in Java.


17) Can we override the constructor in Java?
No, you cannot override constructors in Java because they are not inherited. Remember, we are talking about overriding here not overloading, you can overload construct but you cannot override them.


Overriding always happens in child class and since constructors are not inherited and their name is always the same as the class name it's not possible to override them in Java, to learn more about constructors see here


18) Can we override a final method in Java?
No, you cannot override a final method in Java. Trying to override a final method in a subclass will result in a compile-time error. Actually making a method final is signal to all developer that this method is not for inheritance and it should be used in its present form. You generally make a method final due to security reasons, to learn more see here.


19) Can you overload or override the main method in Java?
Since main() is a static method in Java, it follows rules associated with the static method, which means you can overload the main method but you cannot override it. 

By the way, even if you overload the main method, JVM will always call the standard public static void main(String args[]) method to start your program, if you want to call your overloaded method you need to do it explicitly in your code as shown here.


That's all about some Java interview questions from method overloading and overriding concept. I must admit it a tricky concept to master. I have seen even experienced developers struggling to solve quiz and multiple-choice questions based upon overloading and overriding. 


Read more: https://www.java67.com/2015/08/top-10-method-overloading-overriding-interview-questions-answers-java.html#ixzz8hib6hutt


1. What is the difference between Hashtable and HashMap in Java?
This Java collection interview question is I guess the most popular one. Most of Java programmer who has at least 2 years of experience has seen this question on core Java interview. Well, there is much difference between them but most important is thread-safety, HashMap is not thread-safe while Hashtable is a thread-safe collection.

Btw, If you want to learn more about essential Collection classes like HashMap and Hashtable then I highly recommend you check Java Fundamentals: Collections course by Richard Warburton on Pluralsight. It's a great course to learn about the Java Collection Framework in general. 

Top 10 Java Collection interview Questions Answers for Beginners


2. What is the difference between Hashtable and ConcurrentHashMap in Java?
Another frequently asked Java collection interview question post-Java 5 world which introduced Concurrent Collection classes like ConcurrentHashMap and CopyOnWriteArrayList along with Concurrency utilities like CyclicBarrier and CountDownLatch.

Well, both Hashtable and ConcurrentHashMap are thread-safe here but later provide more scalability than the former. You can further see the Difference between ConcurrentHashMap and Hashtable in Java for the answer to this Java collection interview question.


3. What is the difference between Iterator and Enumeration in Java?
One of the classic interview Questions asked on the Java collection framework, Which is pretty old and a programmer who has been working in Java for 4 to 6 years must have seen this question before. Well, Iterator and ListIterator in Java is a new way to iterator collection in Java and provides the ability to remove an object while traversing while Enumeration doesn't allow you to remove the object.  You can further see Iterator vs Enumeration in Java for more differences between both of them.


4. What is the Difference between fail-safe and fail-fast Iterator in Java?
This is a relatively new Java collection interview question because the concept of a fail-safe iterator is come along with ConcurrentHashMap and CopyOnWriteArrayList. See the Difference between fail-safe and fail-fast Iterator in Java for the answer to this Java collection question.


5. How HashMap works internally in Java?
One of the most frequently asked Java interview questions to experience Java programmer with 4 to 5 years of experience. I have seen this question on big companies like Morgan Stanley, JP Morgan, Nomura, and other banks like Barclays Capital. See How HashMap works internally in Java for a detailed answer to this Java collection interview question.


6. Can you write code to traverse Map in Java in 4 ways?
Another Java collection question appears as part of the Java Coding interview question and appeared in many interviews. As you know there are multiple ways to traverse or iterate Map in Java e.g. for loop, while loop using Iterator etc. 4 ways to iterator Map in Java has detailed explanation and sample code which is sufficient to answer this Java collection framework interview question.


7. What is the difference between Vector and ArrayList in Java?
Java Collection Interview Questions Answers | Java Collection FAQAlong with the Difference between HashMap and Hashtable, this Java collection interview question is probably second in the list of frequently asked questions on the Java collection framework. Both ArrayList and Vector implement List interface from Java 4 but they have differences including synchronization, See the difference between Vector and ArrayList in Java for the complete answer of this collection interview question in Java.


8. What is the difference between ArrayList and LinkedList in Java?
A follow-up question is asked in response to the previous Java collection interview question. Here also both LinkedList and ArrayList are List implementations but their internal data structure is different, one is derived from Array while the other is derived from LinkedList. See LinkedList vs ArrayList in Java to answer this Java Collection interview question.


9. What is the difference between List and Set in Java?
List vs Set is one of the most important concepts to understand in the Java Collection framework and this Java collection interview question focuses on that. The most important difference between them is that List allows duplicates and maintain insertion order while Set doesn't allow duplicates and doesn't maintain any order. See the Difference between Set and List in Java to see more differences between them.

Here is also a nice summary of different collection classes in Java:

Java Collection interview Questions Answers



10. How do you find if ArrayList contains duplicates or not?
Since List allows duplicates this becomes a follow-up question of earlier Java collection framework interview question. See How to check if ArrayList contains duplicates or not for the answer of this Java collection question.


Read more: https://www.java67.com/2012/09/java-collection-interview-questions.html#ixzz8hibewzag

1. What is the difference between the start and run method in Java Thread? (answer)
This thread interview question is also asked as if the start() method eventually calls the run() method then why do you need to call the start() method, why not call the run() method directly. well, the reason is that because start method creates a new thread and calls the code written inside the run method on a new thread while calling the run method executes that code on the same thread. You can also see the article start vs run method in Java for more details.




2. Write code to avoid deadlock in Java where N threads are accessing N shared resources? (answer)
This is a classic Java multithreading interview question, which appears on almost every list of Java thread questions. This question is based on risks and issues faced by parallel programs without proper synchronization or incorrect synchronization.

This question explores the concept of looking and best practices on acquiring and releasing the lock on shared resources. By the way, it's been covered in many places as well and I suggest reading  How to prevent deadlock in Java, not only for a detailed answer to this Java multithreading question but also to learn how to prevent deadlock in Java.

thread interview questions for experience Java programmers





3. Which one is better to implement thread in Java? extending Thread class or implementing Runnable? (answer)
Well, this is another frequently asked question on any Java thread interview. Essentially these are two ways to implement Thread in Java, by extending the java.lang.Thread class or by implementing the java. lang.Runnable interface.

By extending the class you are using your chance to extend one any only one class as Java does not support multiple inheritances, by implementing a Runnable interface you can still extend another class. So extending Runnable or even Callable is a better choice. You can also see the Runnable vs Thread class in Java for more answers to these questions.

Given its simplicity and fact-based nature, this question mostly appears on either telephonic rounds or initial screening rounds. Key points to mention, while answering this question includes multiple Inheritance at the class level and separation of defining a task and execution of a task. Runnable only represents a task, while Thread represents both tasks and their execution.




4. What is Busy Spinning? Why will you use Busy Spinning as a wait strategy? (answer)
This is one of the advanced concurrency interview questions in Java and only asked to experienced and senior Java developers, with lots of concurrent coding experience under the belt. By the way, the concept of busy spinning is not new, but its usage with multi-core processors has risen recently.

The busy waiting is a wait strategy, where one thread waits for a condition to become true, but instead of calling the wait or sleep method and releasing the CPU, it just spins. This is particularly useful if the condition is going to be true quite quickly i.e. in a millisecond or microsecond.

The advantage of not releasing CPU is that all cached data and instruction remain unaffected, which may be lost, had this thread is suspended on one core and brought back to another thread. If you can answer this question, that rest assured of a good impression.


5. What is the difference between CountDownLatch and CyclicBarrier in Java? (answer)
CountDownLatch and CyclicBarrier in Java are two important concurrency utility which is added on Java 5 Concurrency API. Both are used to implement scenarios, where one thread has to wait for another thread before starting processing but there is a difference between them.

The key point to mention, while answering this question is that CountDownLatch is not reusable once the count reaches zero, while CyclicBarrier can be reused even after the barrier is broken.

You can also see my previous article difference between CyclicBarrier and CountDownLatch in Java for a more detailed answer to this concurrency interview question and a real-life example of where to use these concurrency utilities.




6. What is the difference between wait and sleep in Java? (method)
One more classic Java multithreading question from the telephonic round of interviews. The key point to mention while answering this question is to mention that wait will release the lock and must be called from the synchronized context, while sleep will only pause the thread for some time and keep the lock.

By the way, both methods throw IntrupptedException and can be interrupted, which can lead to some follow-up questions like, can we awake a sleeping or waiting for a thread in Java? You can also read a detailed answer on my post of the same title here.

thread interview questions with answers



7. How do you solve the producer-consumer problem in Java? (solution)
One of my favorite questions during any Java multithreading interview, Almost half of the concurrency problems can be categorized in the producer-consumer pattern. There are basically two ways to solve this problem in Java, One by using the wait and notify method and the other by using BlockingQueue in Java.  later is easy to implement and a good choice if you are coding in Java 5.

The key points to mention, while answering this question is the thread-safety and blocking nature of BlockingQueue and how that helps, while writing concurrent code.

You can also expect lots of follow-up questions including, what happens if you have multiple Producer threads or multiple consumers, what will happen if a producer is faster than a consumer thread, or vice-versa. You can also see this link for an example of how to code producer-consumer design in Java using a blocking queue



8. Why is ConcurrentHashMap faster than Hashtable in Java? (answer)
ConcurrentHashMap is introduced as an alternative to Hashtable in Java 5, it is faster because of its design. ConcurrentHashMap divides the whole map into different segments and only locks a particular segment during the update operation, instead of Hashtable, which locks the whole Map.

The ConcurrentHashMap also provides a lock-free read, which is not possible in Hashtable, because of this and lock striping, ConcurrentHashMap is faster than Hashtable, especially when the number of the reader is more than the number of writers.

In order to better answer this popular Java concurrency interview question, I suggest reading my post about the internal working of ConcurrentHashMap in Java.






9. What is the difference between the submit() and execute() method of Executor and ExecutorService in Java? (answer)
The main difference between submitting and execute methods from the ExecutorService interface is that the former returns a result in the form of a Future object, while the latter doesn't return a result. 


By the way, both are used to submit a task to thread pool in Java but one is defined in the Executor interface, while the other is added into the ExecutorService interface. This multithreading interview question is also asked in the first round of Java interviews.


10. How do you share data between two threads in Java? (answer)
One more Java multithreading question from the telephonic round of interviews. You can share data between threads by using shared objects or shared data structures like Queue. Depending upon, what you are using, you need to provide the thread-safety guarantee, and one way of providing thread-safety is using a synchronized keyword.

If you use concurrent collection classes from Java 5 e.g. BlockingQueue, you can easily share data without being bothered about thread safety and inter-thread communication. I like this thread question, because of its simplicity and effectiveness. This also leads further follow-up questions on issues that arise due to sharing data between threads e.g. race conditions.



11. What is ReentrantLock in Java? Have you used it before? (answer)
ReentrantLock is an alternative to the synchronized keyword in Java, it is introduced to handle some of the limitations of synchronized keywords. Many concurrency utility classes and concurrent collection classes from Java 5, including ConcurrentHashMap use ReentrantLock, to leverage optimization.

The ReentrantLock mostly uses an atomic variable and faster CAS operation to provide better performance. Key points to mention are the difference between ReentrantLock and synchronized keywords in Java, which includes the ability to acquire lock interruptibly, timeout feature while waiting for a lock, etc.



 ReentrantLock also gives the option to create a fair lock in Java. Once again a very good Java concurrency interview question for experienced Java programmers. Courses like Java Multithreading for Senior Engineering Interviews course from Educative. also help you to prepare better and answer to the point.

thread, concurrency and multi-threading questions for experienced Java programmers



12. What is ReadWriteLock in Java? What is the benefit of using ReadWriteLock in Java? (answer)
This is usually a follow-up question of previous Java concurrency questions. The  ReadWriteLock is again based upon the concept of lock striping, one of the advanced thread-safety mechanisms that advocates separating locks for reading and writing operations (see Java Concurrency in Practice Bundle by Heinz Kabutz for more details).

If you have noticed before, reading operation can be done without locking if there is no writer and that can hugely improve the performance of any application. The ReadWriteLock leverages this idea and provides policies to allow maximum concurrency level. Java Concurrency API also provides an implementation of this concept as ReentrantReadWriteLock.

Depending upon the Interviewer and experience of the candidate, you can even expect to provide your own implementation of ReadWriteLock, so be prepared for that as well.

Here is a nice diagram that clearly explains the working of read-write lock in Java:

Java Multithreading and Concurrency Interview Questions with Answers


Read more: https://www.java67.com/2012/08/5-thread-interview-questions-answers-in.html#ixzz8hibztSYl

How to avoid deadlock in Java? Example Tutorial and Tips

How to avoid deadlock in Java? Is one of the popular Java interview question and flavor of the season for multi-threading, asked mostly at a senior level with lots of follow up questions. Even though the problem looks very basic but most of the Java developers get stuck once you start going deep. Interview questions start with, "What is a deadlock?" The answer is simple when two or more threads are waiting for each other to release the resource they need (lock) and get stuck for infinite time, the situation is called deadlock. It will only happen in the case of multitasking or multi-threading.



Btw, if you are serious about mastering Java multi-threading and concurrency then I also suggest you take a look at the Java Multithreading, Concurrency, and Performance Optimization course by Michael Pogrebinsky on Udemy. It's an advanced course to become an expert in Multithreading, concurrency, and Parallel programming in Java with a strong emphasis on high performance


How do you detect deadlock in Java?
Though this could have many answers, my version is; first I would look at the code if I see a nested synchronized block or calling one synchronized method from other, or trying to get a lock on a different object then there is a good chance of deadlock if a developer is not very careful.

Another way is to find it when you actually get dead-locked while running the application, try to take a thread dump, in Linux you can do this by the command "kill -3", this will print status of all threads in an application log file, and you can see which thread is locked on which object.

You can analyze that thread dump with using tools like fastthread.io which allows you to upload your thread dump and analyze it.

Another way is to use the jConsole/VisualVM, it will show you exactly which threads are getting locked and on which object.

If you are interested to learn about troubleshooting tools and processes to analyze your thread dump, I suggest you take a look at Analyzing Java Thread Dumps course on Pluralsight by Uriah Levy. An advanced practical course to learn more about Java thread dumps, and familiarize you with other popular advanced troubleshooting tools.




I also suggest you join the Java Concurrency in Practice Bundle by Heinz Kabutz, one of the most advanced course material to master concurrency and multi-threading in Java. It's based on the classic Java Concurrency in Practice book by Brian Goetz, which is a recommended reading for every Java developer.


Write a Java program that will result in deadlock?
Once you answer the earlier question, they may ask you to write code which will result in a deadlock in Java?

here is one of my version

/**
 * Java program to create a deadlock by imposing circular wait.
 * 
 * @author WINDOWS 8
 *
 */
public class DeadLockDemo {

    /*
     * This method request two locks, first String and then Integer
     */
    public void method1() {
        synchronized (String.class) {
            System.out.println("Aquired lock on String.class object");

            synchronized (Integer.class) {
                System.out.println("Aquired lock on Integer.class object");
            }
        }
    }

    /*
     * This method also requests same two lock but in exactly
     * Opposite order i.e. first Integer and then String. 
     * This creates potential deadlock, if one thread holds String lock
     * and other holds Integer lock and they wait for each other, forever.
     */
    public void method2() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }
}


If method1() and method2() both will be called by two or many threads, there is a good chance of deadlock because if thread 1 acquires lock on String object while executing method1() and thread 2 acquires lock on Integer object while running method2() both will be waiting for each other to release the lock on Integer and String to proceed further which will never happen.

This diagram precisely demonstrates our program, where one thread holds a lock on one object and waiting for other object locks which are owned by other thread.

How do you avoid deadlock in Java?


You can see that Thread 1 wants the lock on object 2 which is held by Thread 2, and Thread 2 wants a lock on Object 1 which is held by Thread 1. Since no thread is willing to give up, there is a deadlock, and the Java program is stuck.

The idea is that you should know the right way to use common concurrent patterns, and if you are not familiar with them then Applying Concurrency and Multi-threading to Common Java Patterns by Jose Paumard is a good starting point to learn.



How to avoid deadlock in Java?
Now the interviewer comes to the final part, one of the most important in my view; How do you fix a deadlock in code? Or How to avoid deadlock in Java?



If you have looked above code carefully, then you may have figured out that real reason for the deadlock is not multiple threads but the way they are requesting a lock, if you provide ordered access then the problem will be resolved.



Here is my fixed version, which avoids deadlock by avoiding circular wait with no preemption, one of the four conditions which need for deadlock.

public class DeadLockFixed {

    /**
     * Both method are now requesting lock in same order, 
     * first Integer and then String.
     * You could have also done reverse e.g. first String and then Integer,
     * both will solve the problem, as long as both method are requesting lock
     * in consistent order.
     */
    public void method1() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

    public void method2() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }
}


Now there would not be any deadlock because both methods are accessing lock on Integer and String class literal in the same order. So, if thread A acquires a lock on Integer object, thread B will not proceed until thread A releases Integer lock, same way thread A will not be blocked even if thread B holds String lock because now thread B will not expect thread A to release Integer lock to proceed further.


Read more: https://javarevisited.blogspot.com/2018/08/how-to-avoid-deadlock-in-java-threads.html#ixzz8hicQQTML

How to use ConcurrentHashMap in Java - Example Tutorial and Working

ConcurrentHashMap in Java is introduced as an alternative of Hashtable in Java 1.5 as part of the Java concurrency package. Prior to Java 1.5 if you need a Map implementation, which can be safely used in a concurrent and multi-threaded Java program, then, you only have Hashtable or synchronized Map because HashMap is not thread-safe. With ConcurrentHashMap, now you have a better choice; because not only it can be safely used in the concurrent multi-threaded environment but also provides better performance over Hashtable and synchronizedMap.



ConcurrentHashMap performs better than the earlier two because it only locks a portion of Map, instead of the whole Map, which is the case with Hashtable and synchronized Map. CHM allows concurred to read operations and at the same time maintains integrity by synchronizing write operations.

 We have seen the basics of ConcurrentHashMap on Top 5 Java Concurrent Collections from JDK 5 and 6 and in this Java tutorial, we will learn:

Ø       How ConcurrentHashMap works in Java or how it is implemented in Java.
Ø       When to use ConcurrentHashMap in Java
Ø       ConcurrentHashMap examples in Java
Ø       And some important properties of CHM.


And, If you are new to the Java world then I also recommend you go through these free online Java courses from Udemy to learn Java in a better and more structured way. This is one of the best and up-to-date courses to learn Java online.

How ConcurrentHashMap is implemented in Java
ConcurrentHashMap is introduced as an alternative of Hashtable and provided all functions supported by Hashtable with an additional feature called "concurrency level", which allows ConcurrentHashMap to partition Map. ConcurrentHashMap allows multiple readers to read concurrently without any blocking. 

This is achieved by partitioning Map into different parts based on concurrency level and locking only a portion of Map during updates. The default concurrency level is 16, and accordingly, Map is divided into 16 part and each part is governed with a different lock. 

This means, 16 threads can operate on Map simultaneously until they are operating on a different part of Map. This makes ConcurrentHashMap high performance despite keeping thread-safety intact.  Though, it comes with a caveat. Since update operations like put(), remove(), putAll() or clear() is not synchronized, concurrent retrieval may not reflect most recent change on Map.





In the case of putAll() or clear(), which operates on the whole Map, the concurrent read may reflect insertion and removal of only some entries. Another important point to remember is iteration over CHM, Iterator returned by keySet of ConcurrentHashMap are weekly consistent and they only reflect the state of ConcurrentHashMap and certain point and may not reflect any recent change. Iterator of ConcurrentHashMap's keySet area also fail-safe and doesn’t throw ConcurrentModificationExceptoin..

Default concurrency level is 16 and can be changed, by providing a number that makes sense and works for you while creating ConcurrentHashMap. Since concurrency level is used for internal sizing and indicates a number of concurrent update without contention, so, if you just have few writers or thread to update Map keeping it low is much better. ConcurrentHashMap also uses ReentrantLock to internally lock its segments.

Internal implementation of ConcurrentHashMap in Java

And, If you are new to the Java world then I also recommend you go through these best Java online courses from Udemy and Coursera to learn Java in a better and more structured way. This is one of the best and up-to-date courses to learn Java online.



ConcurrentHashMap putifAbsent example in Java
ConcurrentHashMap examples are similar to Hashtable examples, we have seen earlier,  but worth knowing is the use of putIfAbsent() method. Many times we need to insert entry into Map if it's not present already, and we wrote following kind of code:

synchronized(map){
  if (map.get(key) == null){
      return map.put(key, value);
  } else{
      return map.get(key);
  }
}

Though this code will work fine in HashMap and Hashtable, This won't work in ConcurrentHashMap; because, during put operation whole map is not locked, and while one thread is putting value, other thread's get() call can still return null which results in one thread overriding value inserted by other thread. 

Of course, you can wrap the whole code in the synchronized block and make it thread-safe but that will only make your code single-threaded. ConcurrentHashMap provides putIfAbsent(key, value) which does the same thing but atomically and thus eliminates the above race condition. 


See Core Java for Inpatients for more details about how to use this method effectively:


ConcurrentHashMap putIfAbsent() example in Java



When to use ConcurrentHashMap in Java
Java ConcurrentHashMap Example Tutorial and internal working
ConcurrentHashMap is best suited when you have multiple readers and a few writers. If writers outnumber the reader, or the writer is equal to the reader, then the performance of ConcurrentHashMap effectively reduces to synchronized map or Hashtable. Performance of CHM drops, because you got to lock all portions of Map, and effectively each reader will wait for another writer, operating on that portion of Map. ConcurrentHashMap is a good choice for caches, which can be initialized during application startup and later accessed by many request processing threads. 

As JavaDoc states, CHM is also a good replacement of Hashtable and should be used whenever possible, keeping in mind, that CHM provides a slightly weaker form of synchronization than Hashtable.




Summary
Now we know What is ConcurrentHashMap in Java and when to use ConcurrentHashMap, it’s time to know and revise some important points about CHM in Java.

1. ConcurrentHashMap allows concurrent read and thread-safe update operation.

2. During the update operation, ConcurrentHashMap only locks a portion of Map instead of whole Map.

3. The concurrent update is achieved by internally dividing Map into the small portion which is defined by concurrency level.

4. Choose concurrency level carefully as a significantly higher number can be a waste of time and space and the lower number may introduce thread contention in case writers over number concurrency level.

5. All operations of ConcurrentHashMap are thread-safe.

6. Since ConcurrentHashMap implementation doesn't lock the whole Map, there is chance of read overlapping with update operations like put() and remove(). In that case, result returned by get() method will reflect the most recently completed operation from there start.

7. Iterator returned by ConcurrentHashMap is weekly consistent, fail-safe and never throw ConcurrentModificationException. In Java.

8. ConcurrentHashMap doesn't allow null as key or value.

9. You can use ConcurrentHashMap in place of Hashtable but with caution as CHM doesn't lock the whole Map.

10. During putAll() and clear() operations, the concurrent read may only reflect the insertion or deletion of some entries.


Read more: https://javarevisited.blogspot.com/2013/02/concurrenthashmap-in-java-example-tutorial-working.html#ixzz8hicitcPl

1. What is difference between TCP and UDP protocol? 
There are many differences between TCP (Transmission Control Protocol) and UDP (User Datagram Protocol), but the main is TCP is connection-oriented, while UDP is connectionless. This means TCP provides guaranteed delivery of messages in the order they are sent, while UDP doesn't provide any delivery guarantee.

Because of this guarantee, TCP is slower than UDP, as it needs to perform more work. TCP is best suited for the message, which you can't afford to lose, like. order and trade messages in electronic trading, wire transfer in banking and finance, etc. UDP is more suited for media transmission, where the loss of one packet, known as datagrams is affordable and doesn't affect the quality of service.

This answer is enough for most of the interviews, but you need to be more detailed when you are interviewing as Java developer for a high-frequency trading desk. Some of the points which many candidates forget to mention is about order and data boundary.

In TCP, messages are guaranteed to be delivered in the same order as they are sent but data boundary is not preserved, which means multiple messages can be combined and sent together, or receiver may receive one part of the message in one packet and other parts of the message in next packet.

Though the application will receive the full message and in the same order. TCP protocol will do the assembling of message for you. On the other hand, UDP sends a full message in a datagram packet, if clients receive the packet it is guaranteed that it will get the full message, but there is no guarantee that the packet will come in the same order they are sent.

In short, you must mention the following differences between TCP and UDP protocol while answering during the interview :
TCP is guaranteed delivery, UDP is not guaranteed.
TCP guarantees order of messages, UDP doesn't.
Data boundary is not preserved in TCP, but UDP preserves it.
TCP is slower compared to UDP.
for a more detailed answer, see my post 9 differences between TCP and UDP protocol.



2. How does TCP handshake works? 
Three messages are exchanged as part of TCP head-shake e.g. Initiator sends SYN,  upon receiving this Listener sends SYN-ACK, and finally, initiator replied with ACK, at this point TCP connection is moved to ESTABLISHED state. This process is easily understandable by looking at the following diagram.

Java Networking Interview Questions and Answers





3. How do you implement reliable transmission in UDP protocol? 
This is usually a follow-up to the previous interview question. Though UDP doesn't provide a delivery guarantee at the protocol level, you can introduce your own logic to maintain reliable messaging e.g. by introducing sequence numbers and retransmission.

If the receiver finds that it has missed a sequence number, it can ask for a replay of that message from the Server. TRDP protocol, which is used Tibco Rendezvous (a popular high speed messaging middle-ware) uses UDP for faster messaging and provides reliability guarantee by using sequence number and retransmission.


4. What is Network Byte Order? How do two hosts communicate if they have different byte-ordering? There are two ways to store two bytes in memory, little-endian (least significant byte at the starting address) and big-endian (most significant byte at the starting address). They are collectively known as host byte order. 

For example, an Intel processor stores the 32-bit integer as four consecutive bytes in memory in the order 1-2-3-4, where 1 is the most significant byte.

IBM PowerPC processors would store the integer in the byte order 4-3-2-1. Networking protocols such as TCP are based on a specific network byte order, which uses big-endian byte ordering. If two machines are communicating with each other and they have different byte ordering, they are converted to network byte order before sending or after receiving.

Therefore, a little-endian micro-controller sending to a UDP/IP network must swap the order in which bytes appear within multi-byte values before the values are sent onto the network, and just swap the order in which bytes appear in multi-byte values received from the network before the values are used. In short, you can also say network byte order is the standard of storing bytes during transmission, and it uses a big-endian byte ordering mechanism.

What is Network Byte Order?




5. What is Nagle's algorithm?
If the interviewer is testing your knowledge of TCP/IP protocol then it's very rare for him not to ask this question. Nagle's algorithm is a way of improving the performance of TCP/IP protocol and networks by reducing the number of TCP packets that need to be sent over the network. It works by buffering small packets until the buffer reaches Maximum Segment Size.

Since small packets, which contain only 1 or 2 bytes of data, has more overhead in terms of TCP header, which is 40 bytes. These small packets can also lead to congestion in a slow network. Nagle's algorithm tries to improve the efficiency of TCP protocol by buffering them, to send a larger packet.

Also, Nagle's algorithm has a negative effect on non-small writes, so if you are writing large data on packets then it's better to disable Nagle's algorithm. 

In general, Nagle's algorithm is a defense against the careless application, which sends lots of small packets to the network, but it will not benefit or have a negative effect on well-written applications, which properly takes care of buffering.

Here is also a nice diagram which explains the network traffic with and without Nagle's algorithm:


What is Nagle's algorithm?




6. What is TCP_NODELAY? 
TCP_NODELAY is an option to disable Nagle's algorithm, provided by various TCP implementations. Since Nagle's algorithm performs badly with the TCP delayed acknowledgment algorithm, it's better to disable Nagle's when you are doing the write-write-read operation.

Where a read after two successive writes on the socket may get delayed up to 500 milliseconds until the second write has reached the destination. 

If latency is more concerned over bandwidth usage like in a network-based multi-player game, the user wants to see action from other players immediately, it's better to bypass Nagle's delay by using the TCP_NODELAY flag.


7. What is multicasting or multicast transmission? Which Protocol is generally used for multicast? TCP or UDP? 
Multi-casting or multicast transmission is one too many distributions, where the message is delivered to a group of subscribers simultaneously in a single transmission from the publisher. Copies of messages are automatically created in other network elements e.g. Routers, but only when the topology of a network requires it.

Tibco Rendezvous supports multicast transmission. Multi-casting can only be implemented using UDP because it sends full data as a datagram package, which can be replicated and delivered to other subscribers. Since TCP is a point-to-point protocol, it can not deliver messages to multiple subscribers, until it has the link between each of them.

Though UDP is not reliable, and messages may be lost or delivered out of order. Reliable multicast protocols such as Pragmatic General Multicast (PGM) have been developed to add loss detection and retransmission on top of IP multicast. 

IP multicast is widely deployed in enterprises, commercial stock exchanges, and multimedia content delivery networks. Common enterprise use of IP multicast is for IPTV applications 

Here is a nice diagram which explains how multicasting works:

What is multicasting or multicast transmission?




8. What is the difference between Topic and Queue in JMS? 
The main difference between Topic and Queue in Java Messaging Service is that Queue is used for point to point communication  which is generally one to one, while publisher is used for publish and subscribe communication which is one to many. 

You should use Topic to send messages when we have multiple consumers to consumer messages. If we set up multiple listener threads to consume messages from Queue, each message will be dispatched to only one thread and not all threads. On the other hand in the case of Topic, each subscriber gets its own copy of the message.

What is the difference between Topic and Queue in JMS?





9. What is the difference between IO and NIO in Java?
The main difference between NIO and IO is that NIO provides asynchronous, non-blocking IO, which is critical to write faster and scalable networking systems. While most of the utility from IO classes are blocking and slow. 

NIO takes advantage of asynchronous system calls in UNIX systems such as select() system call for network sockets. Using select(), an application can monitor several resources at the same time and can also poll for network activity without blocking. 

The select() system call identifies if data is pending or not, then read() or write() may be used knowing that they will complete immediately.

What is the difference between IO and NIO in Java?




10. How do you write a multi-threaded server in Java?
A multi-threaded server is one that can serve multiple clients without blocking. Java provides excellent support to developers such as servers. Prior to Java 1.4,  you can write a multi-threaded server using traditional socket IO and threads. 

This had a severe limitation on scalability because it creates a new thread for each connection and you can only create a fixed number of threads, depending upon the machine's and platform's capability.

Though this design can be improved by using thread pools and worker threads, it is still a resource-intensive design. After JDK 1.4 and NIO's introduction, writing scalable and multi-threaded servers become a bit easier. You can easily create it in a single thread by using Selector, which takes advantage of the asynchronous and non-blocking IO model of Java NIO.

How do you write a multi-threaded server in Java?




11. What is the ephemeral port?
In TCP/IP connection usually contains four things, Server IP, Server port, Client IP, and Client Port. Out of these four, 3 are well known most of the time, what is not known is client port, this is where ephemeral ports come into the picture.

Ephemeral ports are dynamic ports assigned by your machine's IP stack, from a specified range, known as the ephemeral port range, when a client connection explicitly doesn't specify a port number.

These are short-lived, temporary ports, which can be reused once the connection is closed, but most of IP software doesn't reuse ephemeral port until the whole range is exhausted. Similar to TCP, UDP protocol also uses an ephemeral port, while sending datagram. 

In Linux ephemeral port range is from 32768 to 61000, while in windows default ephemeral port range is 1025 to 5000. The similarly different operating system has different ephemeral port ranges



12. What is the sliding window protocol? 
Sliding window protocol is a technique for controlling transmitted data packets between two network computers where reliable and sequential delivery of data packets is required, such as provided by the Transmission Control Protocol (TCP). 

In the sliding window technique, each packet includes a unique consecutive sequence number, which is used by the receiving computer to place data in the correct order. The objective of the sliding window technique is to use the sequence numbers to avoid duplicate data and to request missing data

What is the sliding window protocol?




13. When do you get the "too many files open" error? 
Just like File connection, Socket Connection also needs file descriptors, Since every machine has a limited number of file descriptors, it's possible that they may run out of file descriptors. When it happens, you will see a "too many files open" error. You can check how many file descriptor per process is allowed on UNIX based system by executing ulimit -n command or simply count entries on /proc//fd/


14. What is TIME_WAIT state in TCP protocol? When does a socket connection go to TIME_WAIT state? 
When one end of TCP Connection closes it by making a system call, it goes into TIME_WAIT state. Since TCP packets can arrive in the wrong order, the port must not be closed immediately to allow late packets to arrive. That's why that end of TCP connection goes into TIME_WAIT state. 

For example, if a client closes a socket connection then it will go to TIME_WAIT state, similarly, if the server closes the connection then you will see TIME_WAIT there. You can check the status of your TCP and UDP sockets by using these networking commands in UNIX.


15. What will happen if you have too many socket connections in the TIME_WAIT state on the Server? 
When a socket connection or port goes into the TIME_WAIT state, it doesn't release the file descriptor associated with it. The file descriptor is only released when the TIME_WAIT state is gone i.e. after some specified configured time. If too many connections are in the TIME_WAIT state then your Server may ran out of file descriptors and start throwing "too many files open" error, and stop accepting new connections.


That's all about in this list of networking and socket programming interview questions and answers. Though I have originally intended this list for Java programmers it is equally useful for any programmer.

In fact, this is the bare minimum knowledge of sockets and protocols every programmer should have. I have found that C and C++ programmers are better at answering these questions than the average Java programmers.

One reason for this may be because Java programmers have got so many useful libraries like Apache MINA, which does all the low-level work for them. Anyway, knowledge of fundamentals is very important and everything else is just an excuse, but at some point, I also recommend using tried and tested libraries like Apache MINA for production code.


Read more: https://javarevisited.blogspot.com/2014/08/socket-programming-networking-interview-questions-answers-Java.html#ixzz8hid0eVOe



20 Kubernetes Interview Questions with Answers
For easy access, I have divided this article into three sections. The first section consists of basic Kubernetes interview questions. In this section, you will learn about topics like Autoscaling, Load Balancing, and Data Volumes. 

The second section consists of  interview questions related to the architecture of Kubernetes. This section covers topics like Kube-proxy and master node.


The third section deals with some multiple-choice questions. Here, you will get some practical exposure as well as enhance your quick thinking.  I have also tried to cover to basic kubectl command you can use to interact with pods and services

I have no doubt that the interview questions in this article will help you to land your dream job. 


1. Basic Kubernetes Interview Questions
This section focus on essential Kubernetes concepts and interview questions based upon that. 

1. What is Kubernetes?
Kubernetes is basically a container-management tool that is open-source and can scale, descale, and deploy containers. It is similar to Docker and was introduced by Google. This means that it has an interactive community and works well with all the cloud providers. We can say that Kubernetes is not just a containerization platform, but a platform that provides multi-container management solutions.




2. How is Kubernetes similar to Docker?
A Docker image can be used to build runtime containers and it also provides lifecycle management of containers. Kubernetes come in when these individual containers need to communicate with each other. What this essentially means is that Docker can be used to build individual containers and Kubernetes can be used to allow these individual containers to communicate with each other. Another important thing to note here is that containers running on multiple hosts can be connected to each other and linked using Kubernetes. 

3. What is Container Orchestration?
Container Orchestration effectively means that all the services inside the individual containers are working together seamlessly to meet the needs of the server. There are many microservices inside each container, and it is impossible for these microservices to communicate with each other without Container Orchestration. Container Orchestration creates harmony among containers by seamlessly allowing individual containers to work together and met the goal of a single server. 




4. Why do you need Container Orchestration?
When you have 4 or 5 microservices that perform various tasks for a single application, you can put these microservices inside separate containers. But you need to make sure that these containers interact with each other. So Container Orchestration becomes useful in such cases.

Basically, Container Orchestration is essential for making sure that containers communicate effortlessly with each other. There are also many challenges that can crop up if you do not use Container Orchestration. So Container Orchestration can be used to overcome these challenges.

5. What are some features of Kubernetes?
Kubernetes offer some amazing features like Automated Scheduling, Self-Healing Capabilities, Automated Rollouts and Rollbacks, Horizontal Scaling, and Load Balancing.
The automated scheduler can be used for launching containers on cluster nodes.
Self-Healing Capabilities allow rescheduling, restarting, and replacing of dead containers.
Kubernetes also supports automated rollouts and rollbacks for containers.
Kubernetes can also scale up and scale down applications according to your requirements. 

6. What is the Containerized Deployment process in Kubernetes?
Kubernetes is basically cloud-agnostic. What this means is that it can run on basically any cloud provider. This effectively simplifies the process of Containerized Deployment since the is no need for anything big like multiple hosts for load balancing.
 
Kubernetes can also run on any cloud platform since it is cloud-agnostic. For example, if you have a number of containers running on multiple hosts, all of these containers may have to communicate with each other. For this, you need something big that can be used for load balancing, scaling, and monitoring the containers.
7. What is Google Container Engine?
Google Container Engine is a managing platform for Docker Containers and clusters. It is open-source and supports only those containers that run inside Google's own cloud services. 
Google Container Engine is also known as GKE. One important thing to note here is that the Google Container Engine supports only those containers that run on its own public cloud platforms. 
Kubernetes questions for DevOps Engineers and DEvelopers

Bonus Questions
1. What is Heapster?
Heapster is basically a data aggregator that is present cluster-wide. It is provided by Kubelet running on each node. It can also be seen as a container management tool that Kubernetes supports natively. It runs just like any other pod on the cluster. What this means is that it discovers all the nodes in a cluster and queries usage information from the Kubernetes cluster present on every node. 

2. What is Kubectl?
Kubectl can be seen as a platform that can be used for passing commands to the cluster. It also provides the CLI command for running Kubernetes commands against the Kubernetes cluster. It also has various ways and means for creating and managing the Kubernetes component.   

3. What is Minikube?
Minikube can be seen as a tool that makes it easier to run Kubernetes locally. It runs a single-node Kubernetes cluster inside a virtual machine.

4. What is Kubelet?
Kubelet is basically an agent service that runs on each and every node and also allows communication between the slave and the master. It essentially works on the description of containers that are provided to it in the PodSpec. It also makes sure that the containers that are described in the PodSpec are healthy and running.  

5. What can you tell us about a node in Kubernetes?
A node in the Kubernetes cluster can be seen as the main worker machine. Nodes are also known as minions. Nodes can run on physical machines or virtual machines. It provides all the necessary services for running pods. Nodes in the Kubernetes system are managed by masters. 


2. Kubernetes Architecture Interview Questions
8. What can you tell us about Kube-proxy?
Kube-proxy is basically a network proxy that is made up of configured services in Kubernetes API. It runs on each and every node and can do packet forwarding across multiple services. 
Kube-proxy can also run on each and every node. It can do simple TCP/UDP packet forwarding all across the backend network service. A Docker-linkable compatible environment can also provide the various IPs and ports that can be opened using a proxy.
9. What can you tell us about the different components of Kubernetes Architecture?
Kubernetes architecture is made up of 2 main components - the master node and the worker node. The master node is made up of the Kube-controller-manager, Kube-apiserver, and the Kube-scheduler. The worker node has kubelet and Kube proxy.

10. How does the master node work in Kubernetes?
The nodes are made up of containers and the Kubernetes master controls these nodes. The individual containers are housed inside pods and each pod can have a number of these containers. The Kube-apiserver makes sure that there is communication between the pods and the master node.
The Kubernetes master controls all the nodes and the containers that are present inside the nodes. The individual containers are housed inside pods. Inside each pod, you can have a large number of containers depending on your requirements. These pods can be deployed using the user interface or the command-line interface. 
The pods are allocated to different nodes based on the resource requirements. The Kube-apiserver can be used for making sure that there is always communication between the Kubernetes node and the master component. 


11. What do you know about the Kubernetes controller manager?
The controller manager is basically a daemon that embeds controllers and works in namespace creation and garbage collection. It is also responsible for communicating with the API server and managing the end-points. 
The master node runs multiple control processes. But all these processes are compiled together to run as a single process. This process is known as the Kubernetes controller manager. The Kubernetes controller manager is responsible for communicating with the API server and making sure that the end-points are managed. 
There are different types of controller managers running on the master node.
The node controller manages the status of a node like creation, updating, or deletion. 
The replication controller maintains the number of pods for each and every replication object. 
The service account and token controller can be used for creating default accounts as well as API access tokens for creating new namespaces. 
The endpoints controller takes care of all the endpoint objects like services and pods.  
12. What is ETCD?
ETCD is a distributed key-value store that coordinates distributed work. It is written in the Go programming language. It stores the configuration data of the Kubernetes cluster. ETCD can also be used for storing the configuration data of the Kubernetes cluster that represents the state of a cluster at any point in time. 

13. How does the Load Balancer work in Kubernetes?
A load balancer is a common and standard way of exposing service. Kubernetes offer customers two types of load balancer - the internal load balancer and the external load balancer. The internal load balancer allocates pods with the necessary configuration while the external load balancer directs the traffic from the external load. 

14. What is Ingress Network?
Ingress Network is basically a collection of rules that is an entry point to any Kubernetes cluster. It is an API object that manages access to the services inside a cluster. It is the most powerful way of exposing service. 

Bonus Questions
1. What are the different types of services Kubernetes offer?
The Cluster IP can be used for exposing the service on a cluster-internal IP. It means that the service will only be reachable from within the cluster. This is the default service type. 
The Node Port can be used for exposing the service on each node's IP at a static port. A Cluster IP service to which a Node Port service will route is automatically created.
The Load Balancer exposes the service externally by making use of a cloud provider's load balancer. Services to which the external load balancer will route are automatically created. 
The External Name maps the service to all the contents of the external name. There is no proxying of any kind during this setup. 

3. Multiple-Choice Questions
15. Where is the Kubernetes Cluster data stored?
A. Kube-apiserver
B. Kubelet
C. ETCD (Correct)
D. None of the above

16. Which of the following is a Kubernetes Controller?
A. Replicaset
B. Deployment
C. Rolling Updates
D. Both A and B (Correct)

Top 20 Kubernetes Interview Questions with Answers


17. Which of the following are core Kubernetes objects?
A. Pods
B. Services
C. Volumes
D. All of the above (Correct)

18. On which node does the Kube-proxy run?
A. Master Node
B. Worker Node
C. Both A and B (Correct)
D. None of the above

19. Which of the following was introduced in Kubernetes version 1.8?
A. Taints and Tolerations (Correct)
B. Cluster Level Logging
C. Secrets
D. Federated Clusters
20. Which handler is invoked by Kubelet to check if a container's IP address is open or not?
A. HTTPGetAction
B. ExecAction
C. TCPSocketAction (Correct)
D. None of the ABove


Read more: https://javarevisited.blogspot.com/2022/05/kubernetes-interview-questions-answers.html#ixzz8hidMukt0

30 OOPS Interview Questions in Java with Answers
In this article, I am going to share with you some OOPS concept-based Java interview questions that I have collected from friends and colleagues and they have seen in various Java interviews on different companies. They are mostly asked at first a few rounds like on screening round or on the telephonic round.



If you are a senior Java developer then you already know the answers to this question and I suggest you practice more on object-oriented analysis and design skills i.e. how to do code against a specification. If you are a fresher and junior Java developer with 2 to 3 years of experience then you must revise these questions, learn if you don't know to do well on your Java Job interviews.



1. What is method overloading in OOP or Java? (answer)
It's one of the oldest OOPS concept questions, I have seen it 10 years ago and still see it now. When we have multiple methods with the same name but different functionality then it's called method overloading. For example. System.out.println() is overloaded as we have a 6 or 7 println() method each accepting a different type of parameter.


2. What is the method overriding in OOP or Java? (answer)
It's one of the magic of object-oriented programming where the method is chosen based upon an object at runtime. In order for method overriding, we need Inheritance and Polymorphism, as we need a method with the same signature in both superclass and subclass. A call to such a method is resolved at runtime depending upon the actual object and not the type o variable. See the answer for a more detailed discussion.


3. What is the method of hiding in Java? (answer)
When you declare two static methods with the same name and signature in both superclass and subclass then they hide each other i.e. a call to the method in the subclass will call the static method declared in that class and a call to the same method is superclass is resolved to the static method declared in the super-class.


4. Is Java a pure object-oriented language? if not why? (answer)
Java is not a pure object-oriented programming language e.g. there are many things you can do without objects e.g. static methods. Also, primitive variables are not objects in Java. See the answer for a more detailed explanation.




5. What are the rules of method overloading and overriding in Java? (answer)
One of the most important rules of method overloading in Java is that the method signature should be different i.e. either the number of arguments or the type of arguments. Simply changing the return type of two methods will not result in overloading, instead, the compiler will throw an error. 

On the other hand, method overriding has more rules e.g. name and return type must be the same, method signature should also be the same, the overloaded method cannot throw a higher exception, etc. See the answer for a full list of rules related to method overloading and overriding in Java.


6. The difference between method overloading and overriding? (answer)
Several differences but the most important one is that method overloading is resolved at compile-time and method overriding is resolved at runtime. The compiler only used the class information for method overloading, but it needs to know the object to resolved overridden method calls. This diagram explains the difference quite well, though:

Object Oriented Programming Interview Questions and Answers


7. Can we overload a static method in Java? (answer)
Yes, you can overload a static method in Java. You can declare as many static methods of the same name as you wish provided all of them have different method signatures. See the answer for a more detailed explanation and code example.



8. Can we override the static method in Java? (answer)
No, you cannot override a static method because it's not bounded to an object. Instead, static methods belong to a class and are resolved at compile time using the type of reference variable. But, Yes, you can declare the same static method in a subclass, which will result in method hiding i.e. if you use the reference variable of type subclass then the new method will be called, but if you use the reference variable of superclass then the old method will be called.


9. Can we prevent overriding a method without using the final modifier? (answer)
Yes, you can prevent the method overriding in Java without using the final modifier. In fact, there are several ways to accomplish it e.g. you can mark the method as private or static, those cannot be overridden.


10. Can we override a private method in Java? (answer)
No, you cannot. Since the private method is only accessible and visible inside the class they are declared, it's not possible to override them in subclasses. Though, you can override them inside the inner class as they are accessible there.


11. What is the covariant method overriding in Java? (answer)
In the covariant method overriding, the overriding method can return the subclass of the object returned by the original or overridden method. This concept was introduced in Java 1.5 (Tiger) version and it's very helpful in case the original method is returning a general type like Object class, because, then by using the covariant method overriding you can return a more suitable object and prevent client-side typecasting. One of the practical use of this concept is when you override the clone() method in Java.




12. Can we change the return type of method to subclass while overriding? (answer)
Yes, you can, but only from Java 5 onward. This feature is known as covariant method overriding and it was introduced in JDK 5 release. This is immensely helpful if the original method return super-class like the clone() method returns a java.lang.Object. By using this, you can directly return the actual type, preventing client-side type-casting of the result.


13. Can we change the argument list of an overriding method? (answer)
No, you cannot. The argument list is part of the method signature and both overriding and overridden methods must have the same signature.


14. Can we override a method that throws runtime exception without throws clause? (answer)
Yes, there is no restriction on unchecked exceptions while overriding. On the other hand, in the case of a checked exception, an overriding exception cannot throw a checked exception which comes higher in type hierarchy e.g. if the original method is throwing IOException then the overriding method cannot throw java.lang.Exception or java. lang.Throwable.


15. How do you call a superclass version of an overriding method in a subclass? (answer)
You can call a superclass version of an overriding method in the subclass by using the super keyword. For example to call the toString() method from java.lang.Object class, you can call super.toString().


16. Can we override a non-static method as static in Java? (answer)
Yes, you can override the non-static method in Java, no problem on them but it should not be private or final :)


17. Can we override the final method in Java? (answer)
No, you cannot override a final method in Java, the final keyword with the method is to prevent method overriding. You use the final when you don't want subclass changing the logic of your method by overriding it due to security reasons. This is why the String class is final in Java. This concept is also used in the template design patterns where the template method is made final to prevent overriding.




18. Can we have a non-abstract method inside an interface? (answer)
From Java 8 onward you can have a non-abstract method inside the interface, prior to that it was not allowed as all method was implicitly public abstract. From JDK 8, you can add static and default methods inside an interface.


19. What is the default method of Java 8? (answer)
The default method, also known as the extension method is a new type of method which you can add to the interface now. These methods have implementation and are intended to be used by default. By using this method, JDK 8 managed to provide common functionality related to lambda expression and stream API without breaking all the clients who implement their interfaces. If you look at Java 8 API documentation you will find several useful default methods on key Java interfaces like Iterator, Map, etc.


20. What is an abstract class in Java? (answer)
An abstract class is a class that is incomplete. You cannot create an instance of an abstract class in Java. They are provided to define default behavior and ensured that client of that class should adore to those contract which is defined inside the abstract class. In order to use it, you must extend and implement their abstract methods. BTW, in Java, a class can be abstract without specifying any abstract method.


21. What is an interface in Java? What is the real use of an interface? (answer)
As an abstract class, the interface is also there to specify the contract of an API. It supports the OOP abstraction concept as it defines only abstract behavior. It will tell that your program will give output but how is left to implementers. The real use of the interface to define types to leverage Polymorphism. See the answer for a more detailed explanation and discussion.


22. The difference between Abstract class and interface? (answer)
In Java, the key difference is that the abstract class can contain a non-abstract method but the interface cannot, but from Java 8 onward interface can also contain static and default methods that are non-abstract. See the answer for a more detailed discussion as I have described a lot of points there.

Java Object Oriented Programming questions for experienced


23. Can we make a class abstract without an abstract method? (answer)
Yes, just add abstract keyword on the class definition and your class will become abstract.


24. Can we make a class both final and abstract at the same time? (answer)
No, you cannot apply both final and abstract keywords to the class at the same time because they are exactly the opposite of each other. A final class in Java cannot be extended and you cannot use an abstract class without extending and making it a concrete class. As per Java specification, the compiler will throw an error if you try to make a class abstract and final at the same time.


25. Can we overload or override the main method in Java? (answer)
No, since main() is a static method, you can only overload it, you cannot override it because the static method is resolved at compile time without needing object information hence we cannot override the main method in Java.




26. What is the difference between Polymorphism, Overloading, and Overriding? (answer)
This is a slightly tricky OOP concept question because Polymorphism is the real concept behind both Overloading and Overriding. Overloading is compiled time Polymorphism and Overriding is Runtime Polymorphism.


27. Can an interface extend more than one interface in Java?
Yes, an interface can extend more than one interface in Java, it's perfectly valid.


28. Can a class extend more than one class in Java?
No, a class can only extend another class because Java doesn't support multiple inheritances but yes, it can implement multiple interfaces.


29. What is the difference between abstraction and polymorphism in Java? (answer)
Abstraction generalizes the concept and Polymorphism allows you to use different implementations without changing your code. This diagram explains the abstraction quite well, though:

Java OOP Concepts Interview Questions and Answers



8 Object-Oriented Design Principle and pattern Interview Questions
Now let's see some OOPS concept questions based on the SOLID design principles and GOF design patterns that take advantage of the OOPS concept discussed here.

1. What problem is solved by the Strategy pattern in Java? (answer)
Strategy pattern allows you to introduce a new algorithm or new strategy without changing the code which uses that algorithm. For example, the Collections.sort() method which sorts the list of the object uses the Strategy pattern to compare objects. Since every object uses a different comparison strategy you can compare various objects differently without changing the sort method.


2. Which OOP concept Decorator design Pattern is based upon? (answer)
The decorator pattern takes advantage of Composition to provide new features without modifying the original class. A very good to-the-point question for the telephonic round. This is quite clear from the UML diagram of the Decorator pattern, as you can see the Component is associated with a Decorator.

OOP design pattern interview questions answers


3. When to use the Singleton design pattern in Java? (answer)
When you need just one instance of a class and want that to be globally available then you can use the Singleton pattern. It's not free of cost though because it increases the coupling between classes and makes them hard to test. This is one of the oldest design pattern questions from Java interviews. Please see the answer for a more detailed discussion.


4. What is the difference between State and Strategy Patterns? (answer)
Though the structure or class diagram of the State and Strategy pattern is the same, their intent is completely different. The state pattern is used to do something specific depending upon the state while Strategy allows you to switch between algorithms without changing the code which uses it.


5. What is the difference between Association, Aggregation, and Composition in OOP? (answer)
When an object is related to another object is called association. It has two forms, aggregation, and composition. the former is the loose form of association where the related object can survive individually while later is a stronger form of association where a related object cannot survive individually. For example, the city is an aggregation of people but is the composition of body parts.





6. What is the difference between Decorator, Proxy, and Adapter patterns in Java? (answer)
Again they look similar because their structure or class diagram is very similar but their intent is quite different. The Decorator adds additional functionality without touching the class, Proxy provides access control, and an Adapter is used to make two incompatible interfaces work together. 


7. What is the 5 objects oriented design principle from SOLID? (answer)
SOLID is the term given by Uncle Bob in his classic book, the Clean Code, one of the must-read books for programmers. In SOLID each character stands for one design principle:
S for Single Responsibility Principle
O for Open closed design principle
L for Liskov substitution principle
I for Interface segregation principle
D for Dependency inversion principle

OOP Java Interview Questions for 2 years experienced


8. What is the difference between Composition and Inheritance in OOP? (answer)
This is another great OOPS concept question because it tests what matters, both of them are very important from a class design perspective. Though both Composition and Inheritance allow you to reuse code, formerly is more flexible than later.

Composition allows the class to get an additional feature at runtime, but Inheritance is static. You can not change the feature at runtime by substitution of a new implementation. See the answer for a more detailed discussion.


Read more: https://www.java67.com/2015/12/top-30-oops-concept-interview-questions-answers-java.html#ixzz8hidtifSz

10 Object-Oriented and SOLID Desing Principles for Programmers
Though the best way of learning any design principle or pattern is a real-world example and understanding the consequences of violating that design principle, the subject of this article is Introducing Object-oriented design principles for Java Programmers, who are either not exposed to it or in the learning phase. 

Object Oriented Design Principles in Java Programming


I personally think each of these OOP and SOLID design principle needs an article to explain them clearly, and I will definitely try to do that here, but for now, just get yourself ready for a quick bike ride on design principle town :)


1. DRY (Don't repeat yourself)
Our first object-oriented design principle is DRY, as the name suggests DRY (don't repeat yourself) means don't write duplicate code, instead use Abstraction to abstract common things in one place. If you have a block of code in more than two places, consider making it a separate method, or if you use a hard-coded value more than one time, make them public final constant.

The benefit of this Object-oriented design principle is in maintenance. It's important not to abuse it, duplication is not for code, but for functionality. It means if you used standard code to validate OrderID and SSN, it doesn’t mean they are the same, or they will remain the same in the future.

By using standard code for two different functionality or thing, you tightly couple them forever, and when your OrderId changes its format, your SSN validation code will break.

So beware of such coupling and just don’t combine anything which uses similar code but is not related. You can further check out the Basics of Software Architecture & Design Patterns in Java course on Udemy to learn more about writing the right code and best practices to follow while designing a system. 

Object Oriented Design Principles Java Programmer should know





2. Encapsulate What Changes
Only one thing is constant in the software field, and that is "Change," So encapsulate the code you expect or suspect to be changed in the future. The benefit of this OOP Design principle is that It's easy to test and maintain proper encapsulated code.

If you are coding in Java, then follow the principle of making variables and methods private by default and increasing access step by step, like from private to protected and not public.

Several of the design patterns in Java uses Encapsulation, the Factory design pattern is one example of Encapsulation that encapsulates object creation code and provides flexibility to introduce a new product later with no impact on existing code.

Btw, if you are interested in learning more about design patterns in Java and Object-Oriented Programming, then you must check this Design Pattern Library course Pluralsight. It's one of the best collections of design patterns and advice on how to use them in the real world.

SOLID design principles for programmers





3. Open Closed Design Principle
Classes, methods, or functions should be Open for extension (new functionality) and Closed for modification. This is another beautiful SOLID design principle, which prevents someone from changing already tried and tested code.


Ideally, if you are adding new functionality only, then your code should be tested, and that's the goal of the Open Closed Design principle. By the way, the Open-Closed principle is "O" from the SOLID acronym.

Open Closed Design Principle



4. Single Responsibility Principle (SRP)
Single Responsibility Principle is another SOLID design principle, and represent  "S" on the SOLID acronym. As per SRP, there should not be more than one reason for a class to change, or a class should always handle single functionality.

If you put more than one functionality in one Class in Java, it introduces coupling between two functionality, and even if you change one feature, there is a chance you broke coupled functionality,  which requires another round of testing to avoid any surprise on the production environment.

You can further see the SOLID Principles of Object-Oriented Design and Architecture course on Udemy for more real-world examples and to learn about patterns that are based on this principle.

Single Responsibility Principle (SRP)




5. Dependency Injection or Inversion principle
Don't ask for dependency; it will be provided to you by the framework. This has been very well implemented in the Spring framework, the beauty of this design principle is that any class which is injected by the DI framework is easy to test with the mock object and more comfortable to maintain because object creation code is centralized in the framework and the client code is not littered with that.

Dependency Injection or Inversion principle


There are multiple ways to implemented Dependency injection like using bytecode instrumentation, which some AOP (Aspect Oriented Programming) framework like AspectJ does, or by using proxies just like used in Spring. See this example of the IOC and DI design pattern to learn more about this SOLID design principle. It represents "D" on the SOLID acronym.



6. Favor Composition over Inheritance
Always favor composition over inheritance, if possible. Some of you may argue this, but I found that Composition is a lot more flexible than Inheritance.

Composition allows changing the behavior of a class at run-time by setting property during run-time, and by using Interfaces to compose a class, we use polymorphism, which provides flexibility to replace with better implementation at any time.

Favor Composition over Inheritance



Even the classic book Effective Java advises favoring composition over inheritance. See here to learn more about why your Composition is better than Inheritance for reusing code and functionality. 


7. Liskov Substitution Principle (LSP)
According to the Liskov Substitution Principle, Subtypes must be substitutable for supertype, i.e. methods or functions which use superclass type must be able to work with the object of subclass without any issue".

 LSP is closely related to the Single responsibility principle and Interface Segregation Principle. If a class has more functionality, then the subclass might not support some of the functionality and does violate LSP.

Liskov Substitution Principle (LSP)


In order to follow LSP SOLID design principle, derived class or subclass must enhance functionality, but not reduce them. LSP represents "L" on the SOLID acronym.  If you are interested in a more real-world example, then the SOLID Principles of Object-Oriented Design course on Pluralsight is an excellent course to start with. 

Btw, you would need a Pluralsight membership to get access to this course, which costs around $29 per month or $299 annually (14% discount).

If you don't have Pluralsight membership, I encourage you to get one because it allows you to access their 5000+ online courses on all the latest topics like front-end and back-end development, machine learning, etc. It also includes interactive quizzes, exercises, and the most recent certification material.

It's more like Netflix for Software Developers, and Since learning is an integral part of our job, Pluralsight membership is a great way to stay ahead of your competition.

They also provide a 10-day free trial without any commitment, which is a great way to not just access this course for free but also to check the quality of courses before joining Pluralsight.


8. Interface Segregation Principle (ISP)
The Interface Segregation Principle states that a client should not implement an interface if it doesn't use that. This happens mostly when one interface contains more than one functionality, and the client only needs one functionality and no other.

Interface design is a tricky job because once you release your interface, you can not change it without breaking all implementation.

Interface Segregation Principle (ISP)


Another benefit of this design principle in Java is, the interface has the disadvantage of implementing all methods before any class can use it, so having single functionality means less method to implement. If you don't get the benefit of the interface in coding, then I suggest you read my blog post, the real usage of an interface in Java to learn more. 


9. Programming for Interface not implementation
Always program for the interface and not for application; this will lead to flexible code that can work with any new implementation of the interface.

So use interface type on variables, return types of method, or argument type of methods in Java.


This has been advised in many Java books, including in Effective Java and Head First design pattern book.

Programming for Interface not implementation code example




10. Delegation principles
Don't do all stuff by yourself,  delegate it to the respective class. Classical example of delegation design principle is equals() and hashCode() method in Java. In order to compare two objects for equality, we ask the class itself to make a comparison instead of the Client class doing that check.

The key benefit of this design principle is no duplication of code and pretty easy to modify behavior. Event delegation is another example of this principle, where an event is delegated to handlers for handling. 

Delegation principle in Java example


Summary
All these object-oriented design principles help you write flexible and better code by striving for high cohesion and low coupling. The theory is the first step, but what is most important is to develop the ability to find out when to apply these design principles.


Read more: https://javarevisited.blogspot.com/2018/07/10-object-oriented-design-principles.html#ixzz8hiePSPN7


50 Essential Topics for SQL and Database Interview Questions
Here is a list of essential topics programmers should prepare for SQL and Database interview questions. The list includes most essential SQL and database concepts like normalization, index, aggregation, joins stored procedure, and constraints. 

Interviewer normally asks 20 to 25 questions to get a feel of overall skill of candidate, sometimes they purposefully include a tough question, couple of tricky one but mostly questions based upon fundamentals. You will usually see questions from the following topics in any SQL phone interview:
Database fundamental like Normalization, Referential Integrity
Database Relationship like one to one, one to many, and many to many
Different types of keys like Primary key, Unique key, Candidate key, etc
Database indexes like how they work, benefits, disadvantages, etc
The SQL query to extract records from tables
SQL Join
Database indexes
Question about a particular database like Oracle, SQL Server, MySQL, or PostgreSQL
Triggers
Temporary table
Stored procedures
Views
Query Optimization
Group By clause and aggregate function
CRUD operation like INSERT, UPDATE, DELETE
SQL clause based questions like TRUNCATE, DROP, etc
CONSTRAINTS like CHECK constraint, PRIMARY key constraints
I have tried to include as many good questions as possible from the above topics, to make them useful resources for all levels of SQL developers and DBA like beginners to experienced programmers having 2 to 5 years of experience.

Top 50 SQL and Database Phone Interview Questions Answers

As I mentioned, on phone interviews, Interviewers are usually in hurry, they want to hear the correct and concise answer, and not blah blah blah answers, because of that I have kept answers short and sweet. One more reason for keeping your answer short and specific is to avoid getting shot by providing additional information which is not accurate.

At the same time, It's also hard for any SQL developer to go through five-page articles to revise some 30 most frequently asked SQL questions, keep answers to the point helps them a lot.

So, let's start our journey with these beautiful databases and SQL interview questions, I am sure you will also learn new things as well. 

1. Difference between UNION and UNION ALL in SQL?  (answer)
hint  - UNION doesn't include duplicate records, UNION ALL does. Both can be used to combine results from multiple queries. 

2. Difference between WHERE and HAVING clause in SQL?  (answer)
hint - in case of WHERE filtering applies before aggregation while in case of HAVING, filtering applies after aggregation

3. Describe the difference between clustered and non-clustered indexes in a database?  (answer)
hint - clustered index defined the order in which data is physically stored in the table. Since data can be sorted in only one way physically, there is only one clustered index per table and that's usually the primary key. You can have multiple non-clustered indexes to speed up your queries. 

4. Write an SQL query to find the second highest salary of an employee without using TOP or LIMIT?  (answer)
You can use correlated queries to solve this problem.

5. How to find duplicate rows in the database?  (answer)

6. Difference between correlated and non-correlated subquery in SQL?  (answer)

7. How many clustered indexes you can have in a table?  (answer)
This is a tricky question, you can only have one clustered index per table. 

8. Difference between the PRIMARY key and the UNIQUE key constraint in SQL?  (answer)

9. Difference between view and materialized view in SQL?  (answer)

10. Difference between TRUNCATE, DELETE and DROP in SQL?  (answer)
delete removes record but also put an entry into log segment so you can roll back, truncate removes all rows of a table without logging each record on log segment, DROP removes table itself. 

11. What is Referential Integrity in a relational database?  (answer)
It's a rule which ensures that when a record is deleted from the primary table, all associated records are deleted from the related table. It ensures data integrity.

12. What is Normalization?  (answer)
A way to avoid duplication of data in tables. 

13. When a table is said to be in 1NF, 2nd NF, and 3rd NF?  (answer)

14. Describe the difference between ISNULL() and COALESCE() in SQL Server?  (answer)

15. How do you ensure that only values between 1 to 5 are allowed in an integer column?  (answer)

16. Difference between CHAR and VARCHAR data types in SQL?  (answer)
CHAR is fixed length, VARCHAR is variable length

17. Difference between VARCHAR and NVARCHAR in SQL Server?  (answer)
NVARCHAR supports Unicode 

18. How do you get Day, Month, and Year from a date in SQL Server?  (answer)
By using the DATEPART() function

19. How to check if a date is valid in SQL?  (answer)

20. Difference between LEFT OUTER JOIN and INNER JOIN in SQL?  (answer)

21. What is SELF JOIN in SQL?  (answer)
When we join two instances of tables it's called self-join. For example, if the table contains employee name and role then you can use self join to find all employees who are managers.

22. In a classical Employee and Department relationship, write SQL query to print all departments and number of employees on each department.   (answer)

23. Difference between COUNT(*), COUNT(1), and COUNT(column_name) in SQL? 
COUNT(*) includes null values while counting but  COUNT(1), and COUNT(column_name) doesn't take null values into consideration during counting. 

24. What is Database statistics? How it affects the performance of your Query?

25. Suppose you have to create a compound index in a table, involving two columns like book_id and active. Now you can create them as either (book_id, active) or (active, book_id), do you think the order of columns in an index matter? How it will affect your SQL queries?  


26. What do _ and  % are used in the SQL query?
They are used in the LIKE operators while writing SQL queries. The underscore is used to match one character, while % is used for any number of characters. 

27. How do you ensure that a particular SQL query will use a particular Index?  (answer)
You can use SQL hints for that purpose. 


28. In SQL Server, which one is fastest and slowest between an index seek, an index scan, and table scan?  (answer)
In a general, the table scan is slower than the index scan and index seek. Your goal should be to write queries that can take advantage of the index by using index scan and index seek for faster retrieval. You can use the SQL EXPLAIN command to retrieve the query plans and find out whether indexes are used for your query or not. 


29. What does NULL = NULL will return in SQL?  (answer)
This is another tricky question to check your knowledge about NULLs in SQL. I think it will return unknown in SQL Server. But different Databases may return different values, it will not be true though. You can try running this query on SQL Server, MySQL, PostgreSQL, and Oracle to see if you get the same response or different response. 


30. Write SQL query to find all rows where EMP_NAME, a VARCHAR column is NULL?  
This is a simple question often asked beginners to check whether they know how to check for NULL in SQL or not. The trick here is to use "IS NULL" instead of the "=" operator to find all rows where EMP_NAME is NULL.

Here is the SQL query for this question:

$ SELECT EMP_NAME FROM Employee where EMP_NAME IS NULL


31. What is the temp table?  (answer)
A temp table or a temporary table is a base table that is not stored in the database and only exists while the current database session is active. Once the database connection is closed, all temp tables are lost. They may look similar to view but they are not. A view exists only for a single query but you can use a temporary table as a regular table until your session is active. 


32. What is the fastest way to empty or clear a table?  (answer)
You can use the truncate command to empty or clear the table. It's faster than delete because it doesn't log each deleted entry on a log, that's why you cannot roll back it. So be careful while using truncate to clear or empty a table. 

33. What is an identity column in SQL Server? How do you return an identity value from a table?  (answer)

34. How do you return an identity value from a table with a trigger? 
In SQL Server, you can use a function like @@IDENTITY  to generate identity values. 

Example - SELECT @@IDENTITY AS 'Identity';  

35. How do you return a value from a stored procedure? 
In SQL Server, you can either use the OUTPUT parameter or use the return statement to return a value from a stored procedure. 

36. How do you return a VARCHAR value from a stored procedure?  
hint - using OUTPUT parameter return clause 

37. If you have a column that will only have values between 1 and 250 what data type will you use? 
If you are using SQL Server database then you can use the TINYINT datatype which can accommodate numbers between 0 and 255 and it needs 1 byte for storage. 

This question is asked to test your knowledge of SQL data type and whether you can choose the right data type for a given requirement or not. Your goal should be to use a data type that can accommodate a given range. You can also ask questions that whether it's fixed or it can change in the future. 


38. Difference between LEFT and RIGHT OUTER JOIN in SQL?  (answer)
Both are outer joins, in LEFT outer join, all rows from the left side table will be included, and only matching rows from the other side of the table are included. In case of  RIGHT outer join, all rows of the right side of the table on join condition are included. 

39. Can you write an SQL query to select all last names that start with 'T'?  (answer)

40. How would you select all rows where the date is 20211002?  (answer)

41. What is the difference between a local and global temporary table in SQL Server?  (answer)

42. How do you create a copy of a table in SQL Server?  (answer)

43. How do you change the data type of a column in a table in SQL?  (answer)

44. What data type should you use to store monetary values in a table?  (answer)

45. What does SELECT 3/2 will return? 1 or 1.5?  (answer)

46. What is the maximum value that Decimal(6, 5) can hold in SQL Server?  (answer)

47. If you have a table with one integer column ID, and it has three values 101, 201, and NULL? What will the following SQL query SELECT * FROM TestTable where ID !=101 will return?  (answer)

48. What is your favorite SQL book?  (answer)
This one is an easy question and the interviewer just wants to know whether you have read any book or not. You can name the SQL book you have read, if you haven't read any SQL book so far then I highly recommend you to read Head First SQL if you are learning SQL from scratch and Joe Celko's SQL Puzzles if you already know SQL and looking for some SQL puzzles to test your SQL query skills. 

best book to improve SQL query skills



49. Tell me two SQL best practices you follow?  (answer)
hint - creating indexes and using them on SQL queries, normalization, and updating statistics regularly. 

50. What is the different ISOLATION level in the Microsoft SQL Server database?  (answer)

51. If you create a local temp table and then call a proc is the temp table available inside the proc?  (answer)

52. Which date format is the only safe one to use when passing dates as strings?  (answer)

53. How do you suppress rows affected messages when executing an insert statement in SQL Server?  (answer)

54. Difference between ANSI-89 and ANSI-92 syntax of writing SQL Join?  (answer)

55.  Differences between IN and EXISTS (and NOT IN, and NOT EXISTS) in SQL? (answer)


Read more: https://javarevisited.blogspot.com/2021/05/sql-and-database-phone-interview-questions.html#ixzz8hig3CRWH

12 SQL Query Problems with Solutions for Technical Interview 
It's time to write SQL queries now. This section contains 6 SQL query Interview questions that will test many of your SQL skills like joins, grouping, and aggregating data, how you handle nulls in SQL etc. It doesn't test all skills e.g. correlated subqueries, but you can take a look at questions like how to find Nth highest salary of employees to learn that.

This section contains 12 data problems for which you need to write SQL queries, the solution is provided in the next section but I suggest you try to solve these problems first before looking at the solution. 

Also we will use classic Employee and Department data model as shown in following ERD Diagram

Employee department table ERD diagram SQL


And, here are the SQL query problems which you need to solve based upon above schema:

1. Can you write an SQL query to show Employee (names) who have a bigger salary than their manager?

2. Write an SQL query to find Employees who have the biggest salary in their Department?

3. Write an SQL query to list Departments that have less than 3 people in it?

4. Write an SQL query to show all Departments along with the number of people there?

5. Can you write an SQL query to show all Employees that don't have a manager in the same department?

6. Can you write SQL query to list all Departments along with the total salary there?

7. Can you write an SQL query to find the second highest salary of Employee? (solution)

8. How to find all duplicate records from a table? (solution)

9. How do you copy all rows of a table using SQL query? (solution)

10. How do you join more than two tables in SQL query? (solution)

11. How to find 2nd highest salary without using a co-related subquery? (solution)

12. There exists an Order table and a Customer table, find all Customers who have never ordered (solution)

Don't scroll down to look at the solution until you try solving all the problems by yourself. Some of the questions are tricky, so please pay special attention to them. 

It's not a real interview you can take your time because all the hard work your mind will put now to find answers by its own will always remain there and that's the real learning you will get by doing this exercise.


Top 12 SQL Query Questions from Interviews for Practice with Solutions





SQL Script to create a table and Populate data
In this section, we'll see our SQL script for creating and populating the sample table required for running SQL queries. 

I have chosen Employee and Department tables to teach you how to write SQL queries because it is one of the most popular SQL query examples and most of the developers, data scientists, students, and technical guys are familiar with Employee and Department data model.

This is also the example many of you have used in your academics so it's quite easy to understand and correlate. 

Remember, understanding schema and data is very important not only to write correct SQL queries but also to verify that your SQL query is correct by looking at the output.

The SQL queries are written for Microsoft SQL Server database and tested on the same, but you can easily run on Oracle, MySQL, or any other database of your choice by removing T-SQL code e.g. the one which checks if a table already exists, and then drop and re-create it.

Most of the code is standard ANSI SQL, hence it will run as it is on any other database. If you still face any problems then you can also check this guide to migrate SQL Server queries to Oracle.




SQL scripts to create tables 
USE Test
GO

-- drop Employee table if already exists
IF OBJECT_ID('dbo.Employee', 'U') IS NOT NULL
BEGIN
  PRINT 'Employee Table Exists, dropping it now'
 DROP TABLE Employee;
END

-- drop Department table if already exists
IF OBJECT_ID('dbo.Department', 'U') IS NOT NULL
BEGIN
  PRINT 'Department Table Exists, dropping it now'
  DROP TABLE Department;
END

-- create table ddl statments
CREATE TABLE Employee(emp_id INTEGER PRIMARY KEY, dept_id INTEGER,
 mngr_id INTEGER, emp_name VARCHAR(20), salary INTEGER);
CREATE TABLE Department(dept_id INTEGER PRIMARY KEY, dept_name VARCHAR(20));

-- alter table to add foreign keys
ALTER TABLE Employee ADD FOREIGN KEY (mngr_id)
 REFERENCES Employee(emp_id);
ALTER TABLE Employee ADD FOREIGN KEY (dept_id) 
REFERENCES Department(dept_id);

-- populating department table with sample data
INSERT INTO Department (dept_id, dept_name) 
VALUES
(1, 'Finance'),
(2, 'Legal'),
(3, 'IT'),
(4, 'Admin'),
(5, 'Empty Department');

-- populating employee table with sample data
INSERT INTO Employee(emp_id, dept_id, mngr_id, emp_name, salary)
VALUES( 1, 1, 1, 'CEO', 100),
( 2, 3, 1, 'CTO', 95),
( 3, 2, 1, 'CFO', 100),
( 4, 3, 2, 'Java Developer', 90),
( 5, 3, 2, 'DBA', 90),
( 6, 4, 1, 'Adm 1', 20),
( 7, 4, 1, 'Adm 2', 110),
( 8, 3, 2, 'Web Developer', 50),
( 9, 3, 1, 'Middleware', 60),
( 10, 2, 3, 'Legal 1', 110),
( 11, 3, 3, 'Network', 80),
( 12, 3, 1, 'UNIX', 200);

This query runs on the Test database, if you don't have the Test database in your SQL Server instance then either create it or remove the "USE Test" to run on any database of your choice, you can also change the name of the database and keep the "USE".

When you run this script, it will create and populate the data the first time. When you run it again, it will drop and recreate the tables again, as shown in the following output:

Employee Table Exists, dropping it now
Department Table Exists, dropping it now

(5 row(s) affected)

(12 row(s) affected)
And, here is how our data looks like after setting up:


SQL query Practice Questions online


And, here is how our Department data will look like:

SQL query examples online



In this script, I have followed the naming convention and tricks which I discussed earlier in my article, a better way to write SQL queries.  All the keyword is on the capital case while table names and column names are in small and camel case. 

This improves the readability of SQL queries by clearing highlight which ones are keywords and which ones are object names even if syntax highlight is not available.

This example shows that just following some simple SQL best practices can seriously improve the queries you write. 




Solution of SQL Query Practice Interview Questions
Here is the solution of all SQL query problems discussed in the last section

1. SQL query to show Employee (names) who have a bigger salary than their manager?
In this problem, you need to compare employees' salaries to their manager's salary. To achieve this, you need two instances of the same table. Also in order to find a Manager you need to compare employee id with manager id, this is achieved by using the self-join in SQL, where two instances of the same table are compared.

-- Employees (names) who have a bigger salary than their manager
SELECT a.emp_name FROM Employee a JOIN Employee b
ON a.mngr_id = b.emp_id
WHERE a.salary > b.salary;
You can see that Admin 2, and UNIX has higher salary than their boss, CEO who just earn $100. They key here is use of self join, if you have to compare data from the same table then you can create two instance of same table and join them together using self join. An interesting technique to solve this kind of SQL query problem.

SQL Query questions for Tech Interviews




2. SQL query to find Employees who have the biggest salary in their Department?
This is a little bit complex problem to solve, you first need to find the maximum salary of each department, but the department doesn't have the salary, it is the employee who has the salary. 

So we need to create a virtual or temp table where we should have both department and salary. 

This can be achieved by joining both Employee and Department table on dept_id and then using GROUP by clause to group salary on dept_id.  Now, someone can question why we didn't use the self join?

Since we need to print the name of the employee who has the highest salary, we need to compare each employee's salary with the department's highest salary which we have just calculated. 

This can be done by keeping the result of the previous query in a temp table and then joining it again with the Employee table. 

-- Employees who have the biggest salary in their Department
SELECT a.emp_name, a.dept_id
FROM Employee a JOIN
(SELECT a.dept_id, MAX(salary) as max_salary
FROM Employee a JOIN Department b ON a.dept_id = b.dept_id
GROUP BY a.dept_id) b
ON a.salary = b.max_salary AND a.dept_id = b.dept_id;


SQL Query Problems for Tech Interviews


You can see that CEO, Adm 2, Legal 1, and UNIX has highest salary in their 
respective department. You can also print department name as an additional 
exercise. 


3.SQL query to list Departments that have less than 3 people in it?
This is a rather simple SQL query interview question to solve.
You just need to know how to use the COUNT() function and GROUP BY clause.
-- Departments that have less than 3 people in it
SELECT dept_id, COUNT(emp_name) as 'Number of Employee'
FROM Employee
GROUP BY dept_id
HAVING COUNT(emp_name) < 3;

Output:

SQL query GROUP BY and COUNT Example


4. SQL query to show all Departments along with the number of people there?
This is a tricky problem, candidates often use inner join to solve the problem, leaving out empty departments.
-- All Department along with the number of people there
SELECT b.dept_name, COUNT(a.dept_id) as 'Number of Employee'
FROM Employee a FULL OUTER JOIN Department b ON a.dept_id=b.dept_id
GROUP BY b.dept_name;

Output
SQL JOIN Query Examples


5.SQL query to show all Employees that don't have a manager
in the same department?
This is similar to the first SQL query interview question, where we have used self-join to solve the problem. There we compared the salary of employee and here we have compared their department.
-- Employees that don't have a manager in the same department
SELECT a.emp_name FROM Employee a JOIN Employee b
ON a.mngr_id = b.emp_id
WHERE a.dept_id != b.dept_id;

Output
SQL query for Practice



6.Can you write SQL query to list all Departments along with
the total salary of that department?
This problem is similar to the 4th question in this list. Here also you need to use OUTER JOIN instead of INNER join to include empty departments which should have no salaries.
-- All Department along with the total salary there
SELECT b.dept_name, SUM(a.salary) as 'Total Salary'
FROM Employee a FULL OUTER JOIN Department b ON a.dept_id = b.dept_id
GROUP BY b.dept_name;

Output:

SQL query examples for beginners



And, Here is the output of all these SQL queries when running from SQL Server Management Studio:

SQL Query  Interview Questions and Answers


Read more: https://javarevisited.blogspot.com/2017/02/top-6-sql-query-interview-questions-and-answers.html#ixzz8hih5ctlR

I'll show you 4 ways to solve this problem e.g. by using the correlated subquery, using ROW_NUMBER(), using TOP in SQL SERVER, and using LIMIT keyword in MySQL.

By the way, if you are new to Microsoft SQL Server and T-SQL then I also suggest you join a comprehensive course to learn SQL Server fundamentals and how to work with T-SQL. If you need a recommendation then I suggest you go through the Microsoft SQL for Beginners online course by Brewster Knowlton on Udemy. It's a great course to start with T-SQL and SQL queries in SQL Server.









Sample table and data for Nth Highest Salary Problem
Before solving this problem we need some sample data to visualize the problem better, let's create an employee table with some data.



Use below query to create a table and build schema:

-- creating Employee table in Oracle
CREATE TABLE Employee (name varchar(10), salary int);

-- inserting sample data into Employee table
INSERT INTO Employee VALUES ('Rick', 3000);
INSERT INTO Employee VALUES ('John', 4000);
INSERT INTO Employee VALUES ('Shane', 3000);
INSERT INTO Employee VALUES ('Peter', 5000);
INSERT INTO Employee VALUES ('Jackob', 7000);



Nth highest salary using a correlated subquery
How to find Nth Highest Salary in SQL
One of the most common ways to solve this problem of finding the Nth maximum salary from the Employee table is by using the correlated subquery. 

This is a special type of subquery where the subquery depends upon the main query and execute for every row returned by the main query.  It's slow but it can solve problems which are difficult to solve otherwise. Let's see the SQL query to find the Nth highest salary using the Correlated subquery.

SQL Query:
Here is the SQL query you can use to calculate the Nth salary :
SELECT name, salary 
FROM #Employee e1
WHERE N-1 = (SELECT COUNT(DISTINCT salary) FROM #Employee e2
WHERE e2.salary > e1.salary)

for the 2nd maximum you can replace N with 2, and for 3rd maximum replace N with 3, here is the output:

2nd highest salary:
And, here is an example to print second highest salary:
SELECT name, salary 
FROM #Employee e1
WHERE N-1 = (SELECT COUNT(DISTINCT salary) FROM #Employee e2
WHERE e2.salary > e1.salary)SELECT name, salary 
FROM #Employee e1
WHERE 2-1 = (SELECT COUNT(DISTINCT salary) FROM #Employee e2
WHERE e2.salary > e1.salary)

Result:
name salary
Peter 5000


3rd highest salary:
Here is an example to retrieve third highest salary: 
SELECT name, salary 
FROM #Employee e1
WHERE 3-1 = (SELECT COUNT(DISTINCT salary) FROM #Employee e2
WHERE e2.salary > e1.salary)

Result:
name salary
John 4000

Explanation :
The distinct keyword is there to deal with duplicate salaries in the table. In order to find the Nth highest salary, we are only considering unique salaries. The highest salary means no salary is higher than it, the Second highest means only one salary is higher than it, 3rd highest means two salaries are higher than it, similarly Nth highest salary means N-1 salaries are higher than it.

Pros :
1) The generic solution works in all databases including Oracle, MySQL, SQL SERVER, and PostgreSQL.

Cons :
1) Slow, because the inner query will run for every row processed by the outer query.

See SQL Puzzles and Answers book for more of such SQL queries for practicing and improving your SQL query skill.





The nth highest salary in SQL SERVER using TOP keyword
You can use the TOP keyword to find the Nth highest salary in SQL SERVER. This is also faster than the previous solution because here we are calculating Nth maximum salary without a subquery.

SELECT TOP 1 salary
FROM (
SELECT DISTINCT TOP N salary
FROM #Employee
ORDER BY salary DESC
) AS temp
ORDER BY salary

Explanation: 
By default ORDER BY clause print rows in ascending order, since we need the highest salary at the top, we have used ORDER BY DESC, which will display salaries in descending order. 

Again DISTINCT is used to remove duplicates. The outer query will then pick the topmost salary, which would be your Nth highest salary.

And, if you like books and just learning these queries from the interview's sake then I suggest you first read a good book on SQL like Head First SQL. It will help you to build your fundamentals.

3rd highest salary in SQL SERVER

SELECT TOP 1 salary
FROM (
SELECT DISTINCT TOP 3 salary
FROM #Employee
ORDER BY salary DESC
) AS temp
ORDER BY salary

Result:
salary
4000


Here is another example where we have used the TOP keyword to find the second highest salary in Microsoft SQL SERVER 2008.


Nth maximum salary in MySQL using LIMIT keyword
Similar to TOP, MySQL also supports a LIMIT keyword, which provides pagination capability. You can find the nth highest salary in MySQL without using subquery as shown below:

SELECT salary FROM Employee ORDER BY salary DESC LIMIT N-1, 1


2nd highest salary in MySQL without subquery:

SELECT salary FROM Employee ORDER BY salary DESC LIMIT 1,1
salary
5000

3rd highest salary in MySQL using LIMIT clause:

SELECT salary FROM Employee ORDER BY salary DESC LIMIT 2,1
salary
4000

Nth highest salary in MySQL using LIMIT clause:

SELECT salary FROM Employee  ORDER BY Salary DESC LIMIT n-1,1

Explanation :
The benefit of this approach is that it's faster than a correlated query approach but its vendor dependent. This solution will only work in a MySQL database.



Nth highest salary in Oracle using ROW_NUMBER() function

SELECT * FROM (
SELECT e.*, 
ROW_NUMBER() OVER (ORDER BY salary DESC) rn 
FROM Employee e
)
WHERE rn = N; /*N is the nth highest salary*/


Here is the 2nd highest salary in Oracle using ROW_NUMBER() window function:

SELECT * FROM (
SELECT e.*, 
ROW_NUMBER() OVER (ORDER BY salary DESC) rn 
FROM Employee e
)
WHERE rn = 2; 

Output
NAME   SALARY  RN
Peter   5000   2

and here is 3rd highest salary in Oracle:

SELECT * FROM (
SELECT e.*, 
ROW_NUMBER() OVER (ORDER BY salary DESC) rn 
FROM Employee e
)
WHERE rn = 3; 


By the above code has a problem. It is not handling duplicate salaries properly. For example, in our table we have two employees with salary 3000, that's our 4th highest salary, but above code will print the same salary, albeit different employee for both 4th and 5th maximum as shown below:

SELECT * FROM (
SELECT e.*, 
ROW_NUMBER() OVER (ORDER BY salary DESC) rn 
FROM Employee e
)
WHERE rn = 5;

Result: 
NAME    SALARY  RN
Shane   3000    5

In oracle, you can also use SQL statements to build schema and run sample SQL.

You can also do the same thing by using the RANK() window function in Oracle, but that's for another day. This is more than enough to answer the SQL interview question, the print nth highest salary of an employee in the Oracle.


That's all about how to find the nth highest salary in SQL. The easiest way to find nth maximum/minimum salary is by using the correlated subquery, but it's not the fastest way. Better ways are database dependent e.g. you cause TOP keyword in SQL SERVER, LIMIT keyword in MySQL, and ROW_NUMBER() window function in Oracle to calculate the nth highest salary. The normal subquery way is good for the second maximum but after that, it becomes really nested and cluttered.


Read more: https://javarevisited.blogspot.com/2016/01/4-ways-to-find-nth-highest-salary-in.html#ixzz8hiiJFWyl

Difference between row_number(), rank() and dense_rank() window functions in SQL

Though all three are ranking functions in SQL, also known as a window function in Microsoft SQL Server, the difference between rank(), dense_rank(), and row_number() comes when you have ties on ranking i.e. duplicate records. For example, if you are ranking employees by their salaries then what would be the rank of two employees of the same salaries? It depends on which ranking function you are using like row_number, rank, or dense_rank.
PauseUnmute
Fullscreen


The row_number() function always generates a unique ranking even with duplicate records i.e. if the ORDER BY clause cannot distinguish between two rows, it will still give them different rankings, though which record will come earlier or later is decided randomly like in our example two employees Shane and Rick have the same salary and has row number 4 and 5, this is random, if you run again, Shane might come 5th.



The rank() and dense_rank() will give the same ranking to rows that cannot be distinguished by the order by clause, but dense_rank will always generate a contiguous sequence of ranks like (1,2,3,...), whereas rank() will leave gaps after two or more rows with the same rank (think "Olympic Games": if two athletes win the gold medal, there is no second place, only third).  You can also see the  Querying Microsoft SQL Server course on Udemy to learn more about how to rank and dense_rank break ties.

Surprisingly all these functions behave similarly in Microsoft SQL Server and Oracle, at least at the high level, so if you have used them in MSSQL, you can also use it on Oracle 11g or other versions.



By the way, if you are new to Microsoft SQL Server and T-SQL then I also suggest you join a comprehensive course to learn SQL Server fundamentals and how to work with T-SQL. If you need a recommendation then I suggest you go through the Microsoft SQL for Beginners online course by Brewster Knowlton on Udemy. It's a great course to start with T-SQL and SQL queries in SQL Server.





SQL to build schema
Here is the SQL to create a table and insert some data into it for demonstration purpose:

IF OBJECT_ID( 'tempdb..#Employee' ) IS NOT NULL
DROP TABLE #Employee;

CREATE TABLE #Employee (name varchar(10), salary int);

INSERT INTO #Employee VALUES ('Rick', 3000);
INSERT INTO #Employee VALUES ('John', 4000);
INSERT INTO #Employee VALUES ('Shane', 3000);
INSERT INTO #Employee VALUES ('Peter', 5000);
INSERT INTO #Employee VALUES ('Jackob', 7000);
INSERT INTO #Employee VALUES ('Sid', 1000);

You can see that we have included two employees with the same salaries i.e. Shane and Rick, just to demonstrate the difference between row_number, rank, and dense_rank window function in the SQL server, which is obvious when there are ties in the ranking.

If you want to learn more about ranking function in SQL Server, I highly recommend this 70-461, 761: Querying Microsoft SQL Server with Transact-SQL course on Udemy. It's a great course to learn SQL Server in-depth and also become a certified SQL Server DBA.

Difference between row_number(), rank() and dense_rank() in SQL Server, Oracle.



ROW_NUMBER() Example
It always generates a unique value for each row, even if they are the same and the ORDER BY clause cannot distinguish between them. That's why it is used to solve problems like the second-highest salary or nth highest salary, we have seen earlier.

In the following example, we have two employees with the same salary and even though we have generated row numbers over the salary column it produces different row numbers for those two employees with the same salary.

select e.*, row_number() over (order by salary desc) row_number from #Employee e
result:
name    salary  row_number
Jackob  7000    1
Peter   5000    2
John    4000    3
Shane   3000    4
Rick    3000    5
Sid     1000    6

You can see in this example that we have ranked employees based upon their salaries and each of them has a unique rank even if their salaries are the same e.g. Shane and Rick have the same salary of 3000 but they got the unique rank 4th and 5th. It's worth knowing that in the case of a tie, ranks are assigned on a random basis, see Oracle Analytic Functions In-Depth & Advanced Oracle SQL course on Udemy to learn more about when to use the row_number() function in Oracle database.

Difference between row_number(), rank() and dense_rank() in SQL Server



RANK() Example
The rank() function will assign the same rank to the same values i.e. which are not distinguishable by ORDER BY. Also, the next different rank will not start from immediately next number but there will be a gap i.e. if 4th and 5th employees have the same salary then they will have the same rank 4, and 6th employee which has a different salary will have a new rank 6.

Here is the example to clarify the point:

select e.*, rank() over (order by salary desc) rank from #Employee e
result:
name    salary  rank
Jackob  7000    1
Peter   5000    2
John    4000    3
Shane   3000    4
Rick    3000    4
Sid     1000    6

You can see that both Shane and Rick have got the same rank 4th, but the Sid got the rank 6th, instead of 5 because it keeps the original ordering. If you want to learn more about Window Functions you can also check out The Complete SQL + Databases Bootcamp: Zero to Mastery [2020] course by ZTM Academy and Andrei, one of my favorite instructor. This is a comprehensive course to cover everything in SQL you need to know.

best SQL Courses for Beginners

Btw, you would need a ZTM membership to watch this course which costs around $29 per month but also provides access to many super engaging and useful courses like his Python course and JavaScript interview course.  

If you are a constant learner like me then I suggest you go for membership than buying a single course, you will not only save money but also it makes learning easy, as you don't need to buy courses every time you want to learn something new.


DENSE_RANK() Example
The dense_rank function is similar to the rank() window function i.e. same values will be assigned the same rank, but the next different value will have a rank which is just one more than the previous rank, i.e. if 4th and 5th employee has the same salary then they will have the same rank but 6th employee, which has different salary will have rank 5, unlike rank 6 as is the case with rank() function. 

There will be no gap in ranking in the case of dense_rank() as shown in the following example:

select e.*, dense_rank() over (order by salary desc) dense_rank from #Employee e
name    salary  dense_rank
Jackob  7000    1
Peter   5000    2
John    4000    3
Shane   3000    4
Rick    3000    4
Sid     1000    5

You can see that both Shane and Rick have the same ranking 4th, but Sid now has 5th rank which is different than 6th in the earlier example when we used the rank() function. Btw, if you are serious about master SQL, I strongly suggest reading Joe Celko's SQL for Smarties, one of the more advanced books in SQL.

rank vs dense_rank vs row_number in SQL Server and Oracle



Difference between row_number vs rank vs dense_rank
As I told, the difference between rank, row_number, and dense_rank is visible when there are duplicate records. Since in all our example we are ranking records on salary, if two records will have the same salary then you will notice the difference between these three ranking functions.

The row_number gives continuous numbers, while rank and dense_rank give the same rank for duplicates, but the next number in rank is as per continuous order so you will see a jump but in dense_rank doesn't have any gap in rankings.

-- difference between row_number(), rank(), and dense_rank()
-- will only visible when there were duplicates.
-- row_number gives consecutive ranking even with duplicate
-- rank and dense_rank give the same ranking but rank has a jump
-- while dense_rank doesn't have jump

select e.*,
row_number() over (order by salary desc) row_number, 
rank() over (order by salary desc) rank,
dense_rank() over (order by salary desc) as dense_rank 
from #Employee e

and here is the output which clearly shows the difference in the ranking generated by rank() and dense_rank() function. This will clear your doubt about rank, desnse_rank, and row_nubmer function, but if you want to learn more check out 70-461, 761: Querying Microsoft SQL Server with Transact-SQL course on Udemy.

Difference between rank and dense_rank and row_number in Java

You can see the employees Shane and Rick have the same salary 3000 hence their ranking is the same when you use the rank() and dense_rank() but the next ranking is 6 which is as per continuous ranking using rank() and 5 when you use dense_rank(). 

The row_number() doesn't break ties and always gives a unique number to each record.

Btw, I ran all three SQL queries on Oracle 11g R2 and, Oracle 12c and it gave me the same result. So, it seems both Oracle and SQL Server support these functions and they behave identically.


That's all about the difference between ROW_NUMBER(), RANK(), and DENSE_RANK() function in SQL SERVER. As I told, the difference boils down to the fact when ties happen. In the case of the tie, ROW_NUMBER() will give unique row numbers, the rank will give the same rank, but the next different rank will not be in sequence, there will be a gap.

In the case of dense_rank, both rows in the tie will have the same rank and there will be no gap. The next different rank will be in sequence.


Read more: https://javarevisited.blogspot.com/2016/07/difference-between-rownumber-rank-and-denserank-sql-server.html#ixzz8hiiVrVXa

Difference between Truncate and Delete in SQL? Example

Truncate and delete in SQL are two commands which are used to remove or delete data from a table. Though quite basic in nature both SQL commands can create a lot of trouble until you are familiar with details before using it. The difference between Truncate and delete are not just important to understand perspective but also a very popular SQL interview topic which in my opinion a definite worthy topic. What makes them tricky is the amount of data. Since most Electronic trading system stores, large amounts of transactional data, and some even maintain historical data, a good understanding of delete and the truncate command is required to effectively work in that environment.
PlayUnmute
Fullscreen



I have still seen people firing delete commands just to empty a table with millions of records which eventually lock the whole table for doing anything and take ages to complete or Simply blew log segment or hang the machine.

Most of the enterprise stock trading system maintains two kinds of database one transactional and other static. Transactional data is a day by day records that need to be purged at the end of data or moved to historical data so that the application can make a fresh start another day. 

If you need to work on such a large set of data, my advice is to get clear and complete knowledge of delete and truncate command, along with their differences and when to use which command to remove data or purge tables.

In this article, we will see where to use truncate in SQL and where to use delete in SQL, How to use truncate or delete and what danger or harm they can create if not used carefully along with the difference between truncate and delete in SQL.



What is the Truncate command in SQL?
Use the truncate table if you need to delete all rows since truncate doesn't allow you to specify the WHERE clause. truncate removes data by deallocating space used by a table which removes a lot of overhead in terms of logging and locking and that's why to truncate is faster than delete.

What you need to take care is a rollback, data deleted by truncate can not be rolled back until data server specifically supports it e.g. MSSQL Server which allows to commit or rollback truncate table statement transactionally. 

Another caveat with truncate table statement is that it doesn't fire a trigger and you can not truncate a table when a foreign key references any column to the table to be truncated. 

The only situation I see which is perfect for using truncate is purging tables with huge data, though there is another solution exists to drop table and recreated it if that makes sense.

And, if you like to understand difference in tabular format, here is a nice table which highlights difference not just truncate and delete but also drop command in SQL. 
Difference between truncate, drop, and delete in SQL



Example of truncate command in SQL
truncate table Orders;  //Order table shouldn't have a column which is foreign key on another table

Difference between truncate and delete command in sql


What is Delete command in SQL?
Delete is another SQL command available for removing records from the table. Delete is even more flexible than truncate like it provides support to WHERE Clause which can be used to remove selective data. 

It logs each row which allows an operation to be rolled back and it also fires triggers. One disadvantage of using delete is speed and locking. Delete acquires a lock on the table and its also very slow operation because of logging, which makes it unsuitable for removing records from large tables. 

One workaround for this is batch-delete in which you remove a batch of records instead on one record at a time. 

Delete is most suitable for removing selective data and use it where you want to roll back the transaction in the database. It’s not useful to purge a large amount of data from tables and should not be used, otherwise, it could lock the table for a very long time, blew log segment, and can take ages to complete.

Example of delete commands in SQL

delete  * from Orders; //delete all row from Orders, should not be used if Orders is large
delete  * from Orders where Symbol="MSFT.NQ" //delete all orders where symbol is MSFT.NQ


Difference between truncate and delete command in SQL
This is an important point to understand before using truncate or delete on the production environment, or writing any script which purges data from tables.

1. truncate is fast delete is slow.
2. truncate doesn't do logging delete logs on per row basis.
3. rollback is possible with delete not with truncate until specifically supported by the vendor.
4. truncate doesn't fire trigger, delete does.
5. Don't delete, truncate it when it comes to purge tables.
6. truncate reset identity column in table if any, delete doesn't.

7. truncate is DDL while delete is DML (use this when you are writing exam)
8. truncate doesn't support where clause, delete does.

So finally if you have table with huge data and want to empty it don’t Delete, truncate it


Interview questions on truncate and delete in SQL
Truncate and delete both are popular interview topics and there is always some question on these commands in SQL interview. Here I am listing some of SQL interview questions based on delete and truncate command in SQL, you can find the answer in this article itself or by google.

1) If you have a table which contains a large amount of data which command will you use for removing data, truncate or delete?

2) What are differences between truncate and delete?

3) Which one is fast truncate or delete?

4) What is the disadvantage of using truncate in SQL?

5) How will you delete data if truncate is not supported and log segment is also not big enough to support complete delete?

6) Is there any way to remove data other than truncate and delete in SQL?


Read more: https://javarevisited.blogspot.com/2011/10/how-to-use-truncate-and-delete-command.html#ixzz8hiipktYE

These queries test your SQL skill on Joins, both INNER and OUTER join, filtering records by using WHERE and HAVING clause, grouping records using GROUP BY clause, calculating the sum, average, and counting records using an aggregate function like AVG(), SUM(), and COUNT(), searching records using wildcards in LIKE operator, searching records in a bound using BETWEEN and IN clause, DATE and TIME queries, etc. 

If you have faced any interesting SQL query or you have any problem and searching for a solution, you can post it here for everyone's benefit.





20 Most Popular SQL Query Interview Questions and Answers
Without any further ado, here is a list of the most common SQL query Interview questions and answers from Programming Job interviews:


Question 1: SQL Query to find the second highest salary of Employee
Answer: There are many ways to find the second highest salary of an Employee in SQL, you can either use SQL Join or Subquery to solve this problem. Here is an SQL query using Subquery:

SELECT MAX(Salary) 
FROM Employee 
WHERE Salary NOT IN (select MAX(Salary) from Employee ); 

See How to find the second highest salary in SQL for more ways to solve this problem.


Question 2: SQL Query to find Max Salary from each department.
Answer: You can find the maximum salary for each department by grouping all records by DeptId and then using MAX() function to calculate the maximum salary in each group or each department.

SELECT DeptID, MAX(Salary) 
FROM Employee 
GROUP BY DeptID. 

These questions become more interesting if the Interviewer will ask you to print the department name instead of the department id, in that case, you need to join the Employee table with Department using the foreign key DeptID, make sure you do LEFT or RIGHT OUTER JOIN to include departments without any employee as well.  

Here is the query
SELECT DeptName, MAX(Salary) 
FROM Employee e RIGHT JOIN Department d 
ON e.DeptId = d.DeptID 
GROUP BY DeptName;

In this query, we have used RIGHT OUTER JOIN because we need the name of the department from the Department table which is on the right side of the JOIN clause, even if there is no reference of dept_id on the Employee table. 


10 Frequently asked SQL Query Interview Questions




Question 3: Write SQL Query to display the current date?
Answer: SQL has built-in function called GetDate() which returns the current timestamp. This will work in Microsoft SQL Server, other vendors like Oracle and MySQL also have equivalent functions.
SELECT GetDate(); 


Question 4: Write an SQL Query to check whether the date passed to Query is the date of the given format or not?
Answer: SQL has IsDate() function which is used to check passed value is a date or not of specified format, it returns 1(true) or 0(false) accordingly. Remember the ISDATE() is an MSSQL function and it may not work on Oracle, MySQL, or any other database but there would be something similar.

SELECT  ISDATE('1/08/13') AS "MM/DD/YY"; 

It will return 0 because the passed date is not in the correct format.


Question 5: Write an SQL Query to print the name of the distinct employee whose DOB is between 01/01/1960 to 31/12/1975.
Answer: This SQL query is tricky, but you can use BETWEEN clause to get all records whose dates fall between two dates.
SELECT DISTINCT EmpName 
FROM Employees 
WHERE DOB BETWEEN ‘01/01/1960’ AND ‘31/12/1975’;




Question 6: Write an SQL Query to find the number of employees according to gender whose DOB is between 01/01/1960 to 31/12/1975.
Answer : Here is teh sql query to find the number of employees according to gender and whose date of birth is between two given dates
SELECT COUNT(*), sex 
FROM Employees  
WHERE DOB BETWEEN '01/01/1960' AND '31/12/1975' 
GROUP BY sex;

Question 7: Write an SQL Query to find an employee whose salary is equal to or greater than 10000.
Answer : You can use WHERE clause with less than and equal to operator to solve this problem. Here is the sql query to find employees whose salary is equal to or greater than a given number
SELECT EmpName FROM  Employees WHERE  Salary>=10000;


Question 8: Write an SQL Query to find the name of an employee whose name Start with ‘M’
Answer :  You can use the Llike operator to find the name of all employees whose name start with letter "M", here is an exmaple:
SELECT * FROM Employees WHERE EmpName like 'M%';


Question 9: find all Employee records containing the word "Joe", regardless of whether it was stored as JOE, Joe, or joe.

Answer :You can use SQL function like UPPER()  and like operator to find all employees whose name contains a given word like "Joe" as shown in following example:
SELECT * from Employees  WHERE  UPPER(EmpName) like '%JOE%';


Question 10: Write an SQL Query to find the year from date.
Answer:  You can use the GETDATE() function to get the current date and then you can use the YEAR() function to extract the year from the date in SQL server. 

Here is how you can find Year from a Date in Microsoft SQL Server database 
SELECT YEAR(GETDATE()) as "Year";




Question 11: Write SQL Query to find duplicate rows in a database? and then write SQL query to delete them?
Answer: You can use the following query to select distinct records:
SELECT * FROM emp a 
WHERE rowid = (SELECT MAX(rowid) 
FROM EMP b 
WHERE a.empno=b.empno)

to Delete:
DELETE FROM emp a 
WHERE rowid != (SELECT MAX(rowid) FROM emp b WHERE a.empno=b.empno);


Question 12: There is a table which contains two columns Student and Marks, you need to find all the students, whose marks are greater than average marks i.e. list of above-average students.

Answer: This query can be written using subquery as shown below:
SELECT student, marks 
FROM table 
WHERE marks > SELECT AVG(marks) from table)

SQL Query Interview Questions and Answers



Question 13: How do you find all employees who are also managers?
You have given a standard employee table with an additional column mgr_id, which contains the employee id of the manager.

Employee department SQL Query question

Answer: You need to know about self-join to solve this problem. In Self Join, you can join two instances of the same table to find out additional details as shown below

SELECT e.name, m.name 
FROM Employee e, Employee m 
WHERE e.mgr_id = m.emp_id;

this will show employee name and manager name in two columns like

name  manager_name
John   David

One follow-up is to modify this query to include employees which don't have a manager. To solve that, instead of using the inner join, just use the left outer join, this will also include employees without managers. 

Another interesting problem which is based upon Self join is to find all employees who earn more than their managers, which is also asked as follow up question after this one. 



Question 14: You have a composite index of three columns, and you only provide the value of two columns in the WHERE clause of a select query? Will Index be used for this operation? 

For example, if Index is on EmpId, EmpFirstName, and EmpSecondName and you write a query like

SELECT * FROM Employee WHERE EmpId=2 and EmpFirstName='Radhe'

If the given two columns are secondary index columns then the index will not invoke, but if the given 2 columns contain the primary index(first column while creating index) then the index will invoke. In this case, the Index will be used because EmpId and EmpFirstName are primary columns.


Read more: https://www.java67.com/2013/04/10-frequently-asked-sql-query-interview-questions-answers-database.html#ixzz8hijJILmt

**How to use EXISTS and NOT Exists in SQL? Example Query and Tutorial

Hello Guys, you might have heard about how useful the EXISTS clause is helpful in writing sophisticated queries. Still, at the same time, I have also seen that many programmers struggle to understand and use EXISTS and NOT EXISTS clauses while writing SQL queries.  If you are one of them, then you have come to the right place. Today you will learn how to use the EXISTS clause in SQL by picking up a real-world example and an excellent SQL exercise from the LeetCode. Suppose that a website contains two tables, the Customers table, and the Orders table. Can you write an SQL query to find all customers who have never ordered anything?
PauseUnmute
Fullscreen


To solve this problem, you need to first think about data. For example, if a customer has never ordered anything means there won't be any record for him on the Orders table. Good job, half of the task is done.

Now the second half is how do you check if there is a record or not for a particular customer?  That's where EXISTS and NOT EXISTS clause will help you, and that's what you will learn in this article.

This is actually also a popular SQL Interview question, and you might have seen it already, but if you are not, that's fine. This question is not as popular as the second-largest salary query, but it is also one of the frequently asked SQL queries from a programming interview; you can see the full list here.

While I agree that this problem can be solved in a different way, but it is also a perfect example of how you can use the SQL EXISTS clause.

But, if you are new to the SQL world, it's better to start with a comprehensive SQL course like The Complete SQL Bootcamp course by Jose Portilla on Udemy. That will help you to learn SQL better and quicker, and these kinds of articles will also make more sense once you have some SQL knowledge under your belt.





SQL tables and Data for Query Example
Before looking at the query, let's see the schema, tables, and data to understand the problem better. We have two tables Customers and Orders. Customers contain two columns, Id and Name. The id is a numeric column while the Name is a text column, let's assume of type VARCHAR.

If any customer has ordered anything, then their CustomerId will exist in the Orders table, we will take advantage of this knowledge to solve this problem.

We have four customers with Id ranging from 1 to 4. Our second table, Orders, contains Id, which is a unique id for order, and CustomerId, which is the Id of the Customer who makes that order. If any Customer will place an order, then their Id will exist in the Orders table.


Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+

Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+

Using the above tables as an example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+


If you looking for some more SQL challenges, then you can try solving problems given in Joe Celko's classic book, SQL Puzzles, and Answers, the 2nd Edition. One of the best books to improve your SQL query skills.




How to Find Customers Who Never Order using EXISTS in SQL
One of the most common solutions to this problem is by using the SQL JOIN clause. You can use the LEFT OUTER JOIN to solve this problem, as shown below:

SELECT C.Name FROM Customers C
LEFT JOIN Orders O ON  C.Id = O.CustomerId
WHERE O.CustomerId is NULL

When you join two tables in SQL using a LEFT OUTER JOIN, then a big table will be created with NULL values in the column which don't exist in another table.

For example, the big table will have four columns C.Id, C.Name, O.Id, and O.CustomerId, for Customers who have never ordered anything, the O.CustomerId will be NULL.

Many programmers make the mistake of using != in the JOIN condition to solve this problem, with the assumption that if = returns matching rows, then != will return those ids which are not present in another table. So beware of that.

If you struggle to understand join, then I suggest you take a look at Jose Portilla's excellent SQL course The Complete SQL Bootcamp on Udemy. His teaching style is amazing and you will understand joins in no time.

Anyway, this problem is actually an excellent example of how and when to use EXISTS clause:

SELECT C.Name FROM Customers C 
WHERE NOT EXISTS (SELECT 1 FROM Orders O WHERE C.Id = O.CustomerId)

This is a correlated subquery, where the inner query will execute for each row of the outer query, and only those customers will be returned who have not ordered anything.

Btw, the most simple solution is by using the NOT IN Clause.

SELECT A.Name FROM Customers A
WHERE A.Id NOT IN (SELECT B.CustomerId FROMs Orders B)
And, here is a nice screenshot to remember how and when to use the EXISTS clause in SQL query:

How to use EXISTS Clause in SQL? A Real World SQL Query Example using EXISTS


That's all about how to use the EXISTS clause in SQL to find all customers who have never ordered. If you like to improve your SQL query skills, then you can also problems given in Joe Celko's classical book SQL Puzzles and Answers, the 2nd Edition. One of the best books with lots of challenging questions to test your SQL skill, and if you need some online courses to learn SQL in-depth or fill the gaps in your SQL knowledge, the following courses are a good place to start with.


Read more: https://javarevisited.blogspot.com/2016/01/sql-exists-example-customers-who-never-ordered.html#ixzz8hijkETZH

Difference between Self and Equi Join in SQL - INNER Join example MySQL

The main difference between Self Join and Equi Join is that In Self Join we join one table to itself rather than joining two tables. Both Self Join and Equi Join are types of INNER Join in SQL, but there is a subtle difference between the two. Any INNER Join with equal as join predicate is known as Equi Join. SQL Joins are the fundamental concept of SQL similar to correlated and noncorrelated subqueries or using group by clause and a good understanding of various types of SQL join is a must for any programmer.

PlayUnmute
Fullscreen
By the way, If you have written INNER join using where clause then using a comparison operator as = will be known as an equijoin. Equi joins or Self-join is not a formal JOIN or part of the syntax, instead, they are a just popular way to refer to certain join examples.

One of the best examples of Self Join, I have seen in an SQL query Interview questions is "How do you find all Employees who are Managers in Employee table", which is commonly asked along with another popular question how to find the second highest salary of employee or questions related to joining three tables in one SQL query.

In this SQL tutorial, we will learn to self-join by example while solving this SQL query. Btw, If you are new to SQL and don't understand fundamentals like JOINs or co-related sub-queries then I highly recommend you go through a comprehensive SQL course like The Complete SQL Bootcamp by Jose Portilla on Udemy. It's one of the best and also most affordable courses to learn SQL online.





Self Join Example in MySQL
In order to solve this query let's first see schema and data of the Employee table.

mysql> select * from employee;
+--------+----------+---------+--------+--------+
| emp_id | emp_name | dept_id | salary | mgr_id |
+--------+----------+---------+--------+--------+
|    103 | Jack     |       2 |   1400 |    104 |
|    104 | John     |       2 |   1450 |    104 |
|    105 | Johnny   |       3 |   1050 |    104 |
|    108 | Alan     |       3 |   1150 |    104 |
|    106 | Virat    |       4 |    850 |    105 |
|    107 | Vina     |       4 |    700 |    105 |
|    109 | joya     |       4 |    700 |    105 |
+--------+----------+---------+--------+--------+
7 rows in set (0.00 sec)


In above  table all employees who are managers has there emp_id as mgr_id in other employees and by using SELF JOIN  i.e. join two instances of employee table and comparing, we can find all employees who are managers. Here is the SELECT query example using self-join:

mysql> select distinct e.emp_id, e.emp_name from employee e join employee m on e.emp_id=m.mgr_id;
+--------+----------+
| emp_id | emp_name |
+--------+----------+
|    104 | John     |
|    105 | Johnny   |
+--------+----------+
2 rows in set (0.00 sec)


In this example of self join, we have joined employee table to itself by using two table aliases e and m. We have also used distinct keyword to remove duplicates here.

 You can also say this is an example of EQUI JOIN because in join predicate we have used = or equal condition. In fact, this one is an example of INNER Join, SELF Join, and EQUI Join at the same time.

If you are confused about syntax of all possible join in SQL, here is a handy diagram:

Difference between self join and equi join in SQL





Self Join vs Equi Join in SQL and MySQL
In the short major difference between Self Join and Equi Join in SQL is that Self Join requires only one table while most of Equi join is a condition used in join predicate. Since Equi Join is based on the condition for comparison, it can occur in any INNER, OUTER, or SELF join in SQL.


Read more: https://www.java67.com/2013/01/difference-between-self-and-equi-join-sql-example-inner-mysql.html#ixzz8hijzAeFw

Difference between Primary key vs Candidate Key in SQL Database? Example

Primary key vs Candidate Key
What is the difference between primary key and candidate key is another popular SQL and database interview question which appears in various programming interviews now and then? The concept of primary key and candidate key is not just important from the interview point of view but also in designing databases and normalization. By the way, this is my second post about primary keys, In the last one, we have seen a comparison of primary key vs unique key, which also happens to be one of the frequently asked database questions. 

By definition primary key is a column or collection of columns, which uniquely defines a row in a table. Candidate keys are keys that can be a primary key and also able to uniquely identify any row in the table.
PlayUnmute
Fullscreen

In simple terms, you may have a couple of Candidate keys and you have chosen one of them as a primary key.

This selection part is the most important skill in database design. Since only the primary key can have a clustered index in a table while unique keys can have a Nonclustered index, it's important to choose the right column or collection of columns as a primary key.

Often I select a column that is most frequently used in the Where clause of the SELECT query.

Btw, If you are new to SQL and don't understand fundamentals like primary key, normalization, and basic SQL queries then you can also join these free SQL courses to learn those SQL fundamentals. It's one of the best resources to learn SQL online.






Difference between Candidate Key vs Primary Key
 Before seeing the difference between a Candidate key and a Primary key let's see some similarities between them in bullets points.

1. Unique indentification
Both Primary and Candidate keys can uniquely identify records in a table on the database.

2. Constraints
Both Primary and Candidate keys have constraints UNIQUE and NOT NULL.

3. Structure
Primary key or Candidate keys can be either a single column or a combination of multiple columns in a table.

If you preparing for an SQL interview or looking for some good SQL interview questions then you can also check the difference between Correlated and Noncorrelated subqueries and  When to use truncate vs delete in SQL.


Now from the interview point of view here is the difference between a Candidate key and primary key in SQL table on point format for easy to remember :

1. Number of Keys
There can be multiple Candidate keys in a table in relation to the database e.g. Oracle, MySQL, Sybase, or MSSQL but only one primary key is permitted.

2. Example
An example of Primary key and Candidate key can be ID and SSN number in an Employee table, Since both can identify each employee uniquely they are candidate key and anyone can become the primary key.

Now if you have to choose between them as the primary key, I will go ID as a primary key because SSN is sensitive information and may not be allowed/not safe to use as String in queries as frequently as ID.

The second reason for choosing ID over SSN as a primary key can be the use of ID as a primary tracking ID within the organization and its frequent use all over the place.

Once you choose a primary key, All candidate keys are like unique keys.

Here is a nice table that explains a couple of candidate keys (columns that are eligible to become primary keys) and how other keys become alternate keys once a primary key is chosen. 

In this table Roll_No, Name, and Branch are candidate keys because they have unique values but in reality, Name can be duplicate and Branch can also become duplicate, but Roll_No will be unique, hence it is chosen as a primary key.   If you want to learn more about database design, I suggest you go through these Database and SQL courses. 

Difference between Primary key vs Candidate Key in SQL Database? Example


Read more: https://www.java67.com/2012/10/difference-between-primary-key-vs-candidate-keys-sql-database.html#ixzz8hikBO4u2

Difference between Primary key vs Unique key in SQL Database? Answer

primary key vs unique key in SQL
The primary key and unique key are two important concepts in a relational database and are used to uniquely identify a row in a table. Both primary key and unique keys can identify a row uniquely but there is some subtle difference between them which we will see in this article. In fact, primary key vs unique is a popular SQL interview question along with classics like truncate vs delete and  How to manage transactions in a database, mostly asked to fresher and 2 to 3 years experience guys in any programming language. SQL is not just limited to any DBA or PLSQL developer but it's an important skill even for Java programmers and you can expect SQL interview questions even in many Java interviews.
PlayUnmute
Fullscreen

Some time programmer also confuses between a unique key and a foreign key, which is the primary key of other tables in relation, hence questions like the difference between a primary and foreign key or a primary and unique key, or foreign and unique keys are asked to check their understanding.

The key thing to remember is that they help to keep data integrity in check. The unique key ensures that no duplicate values are inserted in the database, while a primary and foreign key is responsible for maintaining referential integrity.

They are also used to link two tables when you are joining them. Btw, there is a slight difference in unique key and unique key constraint, former is a concept while the latter is an implementation that ensures that no duplicate key is inserted into your tables.

Btw, If you are new to these concepts, I suggest you joining these free SQL and Database courses to get a full understanding of essential SQL and database concepts.




Difference between primary key and unique key in SQL
As I said both primary and unique key uniquely identifies each row in the table but there is some subtle difference between them. here are some of them :

1. Unique key in a table can be null, at least one but the primary key cannot be null in any table in a relational database like MySQL, Oracle, etc.

2. The unique key is represented using a unique constraint while a primary key is created using a primary key constraint in any table and it's automatically got a unique constraint. You can also see these Database and SQL courses from Udemy and from Pluralsight for more details on how unique key constraint works.

Difference between Primary key and Unique key in SQL



3. The primary key can be a combination of more than one unique key in the same table.

4. There can be only one primary key per table in relation to databases like MySQL, Oracle, PostgreSQL, SQLServer, or Sybase but there can be more than one unique key per table.

5. Many database engines automatically put a clustered index on the primary key and since you can only have one clustered index per table, it's not available to any other unique key at the same time. This is true for both Oracle and MySQL Server

Here is a nice summary of the difference between a primary key and a unique key in a table. These differences are valid on most of the relational databases like Oracle, MySQL, and SQL Server:

Difference between primary and unique key in table SQL


These were some of the differences between the primary key and the unique key in SQL or any table. It's's one of those SQL interview questions which you don't like to miss before going for any programming interview or any database, SQL interview.


Read more: https://www.java67.com/2012/10/difference-between-primary-vs-unique-key-table-sql.html#ixzz8hikKyRTZ

Difference between Primary and Foreign keys in SQL [Answer]

The database is a collection of tables and a table is the collection of rows or records. A primary key is the data to uniquely identify a row in the table. For example, if an Employee table has millions of rows and emp_id is a primary key then it can uniquely identify that row. You can use this primary key to retrieve (SELECT) the row, update the row, and delete the row. In SQL, a table can have only one primary key but it can contain more than one column. There are two types of primary key, a simple primary key, and a composite primary key.

PlayUnmute
Fullscreen
A simple primary key is made of just one column while a composite primary key is made of more than one column. The primary key also enforces some constraints like UNIQUE and NOT NULL, which means if you try to enter another record with the primary key already existing in the database then DBMS will reject it.

Similarly, a primary key cannot be NULL, it must have some value. On the other hand, the foreign key is just the primary key of another table. In a relational database, two tables can be related to each other like Employee and Department, in those cases, the primary key of one table becomes the foreign key of another table.

In this article, you will learn some key differences between the Primary and foreign keys in a table. This is also one of the most common SQL Interview questions for 1 to 2 years of experienced programmers.






Difference between Primary and Foreign key in a table
As I said, if two tables are in relation to each other than the primary key of one table becomes the foreign key of another table. Let's see some more differences between Primary and Foreign keys in SQL:

1. One of the major differences between these two keys is that the primary key enforces clustered index, which is the actual physical order of how data is stored in the disc. On the other hand, the Foreign key doesn't create a clustered index in the table.


2. The primary key is unique in the table. So a table cannot contain more than one row with the same primary key, but that's not required for a foreign key. You can have more than one row in a table with the same foreign key e.g. all employees will have a unique id but many of them working for the same department will have the same dept_id. This is one of the main differences between a unique key and a primary key.


3. Foreign key helps to maintain the integrity of related tables in the database. For example, it's not possible to delete a department, unless a single employee is referring that. So, an accidental delete of such a department will be prevented by database management systems like Oracle, MySQL, or SQL Server.  

You can further set up cascade actions with foreign keys like when a department is deleted, update the dept_id of all employees in the Employee table referring to this department. You can set up such an arrangement using the ON CASCADE clause.

Similarly, you cannot insert the data in the secondary table if a row with the primary key doesn't exist in the Primary key e.g. adding a non-existent department to an employee's profile. This is also known as referential integrity in the database.


4. Another key difference between the primary and foreign keys in a table is that the primary key cannot accept null, but the foreign key can accept multiple values.


5. The Primary key uniquely identifies a record in the table, but the foreign key can not be used for that purpose, it's just the primary key of the related table.

Here is a nice table of some key differences between the Primary and Foreign keys in the table:

Difference between Primary and foreign key in table


Read more: https://www.java67.com/2015/12/difference-between-primary-and-foreign.html#ixzz8hikcfvSO

Difference between Primary key vs Foreign key in table – SQL Tutorial Example

The main difference between the Primary key and the Foreign key in a table is that it’s the same column that behaves as the primary key in the parent table and as a foreign key in a child table. For example in the Customer and Order relationship, customer_id is the primary key in the Customer table but a foreign key in the Order table. By the way, what is a foreign key in a table and the difference between Primary and Foreign key are some of the popular SQL interview questions, much like truncate vs delete in SQL or difference between correlated and noncorrelated subquery? We have been learning key SQL concepts along with these frequently asked SQL questions and in this SQL tutorial, we will discuss what is a foreign key in SQL and the purpose of the foreign key in any table. 




By the way, this is the third article related to a primary key in SQL, the other being the difference between primary and unique key and How to find the second highest salary in SQL. If you are preparing for any technical job interview where you expect some SQL questions, check out these questions, they are worth preparing.

Difference between Primary key vs Foreign key in table – SQL Tutorial Example




What is the Foreign key in a table in the Database?
What is foreign key and difference between primary vs foreign key in SQLA Foreign key is a column in one table which is the primary key on another table. A foreign key and a Primary key are used to define the relationship between two tables in a relational database. For example in Employee and Department relationship, we have two tables Department(dept_id, dept_name) and  Employee (emp_id, emp_name, dept_id). dept_id is the primary key in the Department table and the foreign key in the Employee table. 

Though it’s not required that name of a foreign key must be the same with primary key, we have kept it the same as per standard SQL best practices. Foreign key in a table enforce Referential Integrity constraint, which can be used to implement business rules e.g. referential integrity can stop you from creating an Employee with a non existent department. 



This kind of check maintains integrity of data in a relationship. As discussed in our post What is referential integrity in MySQL database, we have seen that it's implemented as foreign key constraint and can allow CASCADE UPDATE and DELETE. These referential action delete or update matching column in child table ( foreign key table) when corresponding row from parent table (primary key table ) is deleted or updated to maintain integrity of data.




Difference between Primary key and Foreign key in SQL
Here is some important difference between primary and foreign keys in a table which is worth remembering both on SQL interview point of view and knowledge point of view.

1) Name of foreign key can be different than the name of primary key it represent in other table. For example in our Employee and Department relationship, Primary key in Department table is dept_id  and we have used same name in Employee table to create foreign key. It could have been different e.g. departmentId or departmentID t etc.

2) Another difference between primary and foreign key is that unlike primary key, a foreign key can be null e.g. in our example you can have an Employee record for which dept_id can be null, this shows that no corresponding record in Department table.


3) One more difference between primary key and foreign key is that foreign key can be duplicate opposite to primary key which is always unique.

4) By using foreign key constraints, we can introduce referential integrity in multiple table relationship in SQL. Referential integrity guarantees data integrity, see benefits of Referential Integrity in SQL to know more.

5) Foreign key mostly works as a link between two table when we join tables using INNER JOIN and OUTER JOIN. For example, when we INNER JOIN both Employee with Department table, we can use dept_id as joining column. See How to join three tables in SQL for more details.

6) Table on which a column is declared as a primary key is known as parent table in the relationship and foreign key table is known as child table in a relationship. For example in Employee and Department relationship, Department is parent table because dept_id is primary key there and Employee is child table because dept_id is a foreign key in this table.



Primary key and Foreign key Example in SQL
One of the best examples to understand the Primary key and Foreign key in a table is Employee and Department relationship or the Customer and Order relationship. You can create an Order and Customer table in MySQL as following to create primary and foreign keys :

CREATE TABLE Customer (cust_id   INT NOT NULL,
                       cust_name VARCHAR(256),                      
                       PRIMARY KEY (cust_id)) ENGINE=INNODB;

CREATE TABLE ORDER (order_id INT NOT NULL,
                    amount INT NOT NULL,
                    cust_id INT,
                    FOREIGN KEY (cust_id) REFERENCES Customer(cust_id)
                    ON DELETE CASCADE) ENGINE=INNODB;

Now, cust_id is primary key in Customer table and the foreign key in Order table. If we try to insert an Order for which cust_id is something that is invalid in Customer table, MySQL database will reject such INSERT or UPDATE. This is one of the benefit of using Referential Integrity. 

It also allow to CASCADE UPDATE and DELETE operation which first delete or update a row in parent table e.g. Customer and then delete or update all matching rows in child table e.g. Order table.

That's all on what is a foreign key in a table and the difference between primary and foreign key in SQL. I suggest to create some table by yourself and try to test foreign key constraint by violating it and see how database e.g. Oracle, MySQL or SQL Server  behaves. To understand more try ON DELETE CASCADE and ON DELETE UPDATE to see how database maintains foreign key constraint. You can also see my post on Referential Integrity example on MySQL database


Read more: https://javarevisited.blogspot.com/2012/12/foreign-key-vs-primary-key-table-sql-database-difference.html#ixzz8hikpDRYr

What is Referential Integrity in Database or SQL - MySQL Example Tutorial

Referential Integrity is a set of constraints applied to foreign keys which prevents entering a row in the child table (where you have the foreign key) for which you don't have any corresponding row in the parent table i.e. entering NULL or invalid foreign keys. Referential Integrity prevents your table from having incorrect or incomplete relationships e.g. If you have two tables Order and Customer where Customer is parent table with primary key customer_id and Order is child table with foreign key customer_id. Since as per business rules you can not have an Order without a Customer and this business rule can be implemented using referential integrity in SQL on a relational database.




Referential Integrity will cause failure on any INSERT or UPDATE SQL statement changing the value of customer_id in the child table If the value of customer_id is not present in the Customer table. 

By the way, What is Referential Integrity in SQL is also an important SQL question similar to finding the second highest salary in SQL or the difference between truncate and delete and should be prepared well before going for any job interview, where knowledge of SQL is one of the requirements.

But, if you are new to the SQL world, it's better to start with a comprehensive SQL course like The Complete SQL Bootcamp course by Jose Portilla on Udemy. That will help you to learn SQL better and quicker, and these kinds of articles will also make more sense once you have some SQL knowledge under your belt.

Referential Integrity example in MySQL tables
What is Refrential Integrity in SQL database with MySQL example
Another example of Referential Integrity is Employee and Department relationship. If we have dept_id as a foreign key in the Employee table then by using referential integrity constraints we can avoid creating  Employee without department or non-existing department. 

In short Referential Integrity makes primary key foreign key relationships viable. Let's first create Employee and Department table with a primary key, foreign key, and referential integrity constraints.



CREATE TABLE Department (dept_id INT NOT NULL,
                         dept_name VARCHAR(256),                      
                         PRIMARY KEY (dept_id)) ENGINE=INNODB;

CREATE TABLE Employee (emp_id INT NOT NULL,
                       emp_name VARCHAR(256),
                       dept_id INT,
                       FOREIGN KEY (dept_id) REFERENCES Department(dept_id)
                       ON DELETE CASCADE) ENGINE=INNODB;

Above SQL statements will create both Department and Employee tables. dept_id is now a foreign key in the Employee table. 

In this SQL, while creating a foreign key we have specified ON DELETE clause which tells, what needs to do when a record from the parent table is deleted. CASCADE referential action allows to delete or update all matching rows from the child table, after deleting a record in the parent table. This way Referential Integrity preserves data integrity of the relationship.

Let's see How Referential Integrity disallows INSERT and UPDATE for a record in the child table for which there is no matching record in the parent table. To check this Referential Integrity example execute the following MySQL queries :

INSERT INTO Department VALUES (1, "Sales");
INSERT INTO Employee VALUES (101, "Rajeev", 2)

mysql> INSERT INTO Employee VALUES (101, "Rajeev", 2)
    -> ;
ERROR 1452 (23000): Cannot ADD OR UPDATE a child row: a FOREIGN KEY constraint fails (`test`.`employee`, CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE)

When we inserted first record in Department table it ran fine but when we insert a record in Employee table with dept_id = 2 which is not present in Department i.e. parent table, failed to Referential integrity or foreign key constraint check.

If you modify your query and correct dept_id to 1, query will run fine, as shown below

mysql> INSERT INTO Employee VALUES (101, "Rajeev", 1);
Query OK, 1 row affected (0.05 sec)

Now let's delete our only record from Department table and see if matching records on child table is automatically deleted or not.

mysql> DELETE FROM Department;
Query OK, 1 row affected (0.05 sec)

mysql> SELECT * FROM Employee;
Empty SET (0.00 sec)
You see there is no record in the Employee table because of ON DELETE CASCADE, matching records in the child table are deleted. Similarly, you can use ON UPDATE CASCADE to automatically propagate UPDATE from the parent table to child tables.

Advantage of Referential Integrity in RDBMS and SQL
There are several benefit of Referential Integrity in relational database and maintaining integrity of data among parent and child tables. Here are some of the most noticed advantages of Referential Integrity in SQL:

1) Referential Integrity prevents inserting records with incorrect details in table. Any insert or update operation will fail if it doesn't satisfy referential integrity rule.


2) If a records from parent table is deleted, referential integrity allows to delete all related records from child table using cascade-delete functionality.

3) Similar to second advantage if a record i.e. customer_id of a customer is updated on parent table (Customer table) , Referential Integrity helps to update customer_id in child table (Order) using cascade-update.


Read more: https://javarevisited.blogspot.com/2012/12/what-is-referential-integrity-in-database-sql-mysql-example-tutorial.html#ixzz8hil5zIkv

Three tables JOIN Example SQL


Joining three tables in a single SQL query can be very tricky if you are not good with the concept of SQL Join. SQL Joins have always been tricky not only for new programmers but for many others,  who are in programming and SQL for more than 2 to 3 years. There are enough to confuse someone on SQL JOIN ranging from various types of SQL JOIN like INNER and OUTER join, LEFT and RIGHT outer join, CROSS join, etc. Between all of these fundamentals, What is most important about Join is, combining multiple tables. If you need data from multiple tables in one SELECT query you need to use either subquery or JOIN.

Most of the time we only join two tables like Employee and Department but sometimes you may require joining more than two tables and a popular case is joining three tables in SQL.

In the case of joining three tables table, 1 relates to table 2 and then table 2 relates to table 3. If you look it closely you find that table 2 is a joining table that contains the primary key from both table 1 and table 2. As I said it can be extremely confusing to understand the join of three or more tables.

I have found that understanding table relationships as the primary key and foreign key helps to alleviate confusion than the classical matching row paradigm.

SQL Join is also a very popular topic in SQL interviews and there are always been some questions from Joins, like the difference between INNER and OUTER JOIN,  SQL query with JOIN like Employee Department relationship and  Difference between LEFT and RIGHT OUTER JOIN, etc. In short, this is one of the most important topics in SQL both from experience and interview points of view.




Three table JOIN syntax in SQL
Here is a general SQL query syntax to join three or more tables. This SQL query should work in all major relational databases like MySQL, Oracle, Microsoft SQLServer, Sybase, and PostgreSQL:

SELECT t1.col, t3.col
FROM table1
JOIN table2 ON table1.primarykey = table2.foreignkey
JOIN table3 ON table2.primarykey = table3.foreignkey



We first join table 1 and table 2 which produce a temporary table with combined data from table1 and table2,  which is then joined to table3. This formula can be extended to more than 3 tables to N tables, You just need to make sure that the SQL query should have N-1 join statement in order to join N tables. for joining two tables, we require 1 join statement and for joining 3 tables we need 2 join statements.

Here is a nice diagram that also shows how does different types of JOINs e.g. inner, left outer, right outer and cross joins works in SQL:

How to join three tables in SQL with MySQL database example



SQL Query to JOIN three tables in MySQL
How to join three tables in SQL with Example - MySQL Oracle SQL ServerIn order to better understand the joining of 3 tables in the SQL query let's see an example.  Consider the popular example of Employee and Department schema. In our case, we have used a link table called Register which links or relates both Employee to Department. 

The primary key of the Employee table (emp_id) is a foreign key in Register and similarly, the primary key of the Department table (dept_id) is a foreign key in Register table.

Btw, the only way to master SQL join is doing as much exercise as possible. If you could solve most of SQL puzzles from Joe Celko's classic book, SQL Puzzles, and Answers, 2nd edition, you will more confident about dealing with SQL joins, whether it could be two, three or four tables.


In order to write an SQL query to print employee name and department name alongside we need to join 3 tables. First JOIN statement will join Employee and Register and create a temporary table which will have dept_id as another column. Now second JOIN statement will join this temp table with Department table on dept_id to get the desired result.

Here is the complete SELECT SQL query example to join 3 tables and it can be extended to join more than 3 or N tables.




mysql> SELECT * FROM Employee;
+--------+----------+--------+
| emp_id | emp_name | salary |
+--------+----------+--------+
| 1      | James    |   2000 |
| 2      | Jack     |   4000 |
| 3      | Henry    |   6000 |
| 4      | Tom      |   8000 |
+--------+----------+--------+
4 rows IN SET (0.00 sec)

mysql> SELECT * FROM Department;
+---------+-----------+
| dept_id | dept_name |
+---------+-----------+
| 101     | Sales     |
| 102     | Marketing |
| 103     | Finance   |
+---------+-----------+
3 rows IN SET (0.00 sec)

mysql> SELECT * FROM Register;
+--------+---------+
| emp_id | dept_id |
+--------+---------+
|      1 |     101 |
|      2 |     102 |
|      3 |     103 |
|      4 |     102 |
+--------+---------+
4 rows IN SET (0.00 sec)

mysql> SELECT emp_name, dept_name
       FROM Employee e
       JOIN Register r ON e.emp_id=r.emp_id
       JOIN Department d ON r.dept_id=d.dept_id;
+----------+-----------+
| emp_name | dept_name |
+----------+-----------+
| James    | Sales     |
| Jack     | Marketing |
| Henry    | Finance   |
| Tom      | Marketing |
+----------+-----------+
4 rows IN SET (0.01 sec)


If you want to understand it even better then try joining tables step by step. So instead of joining 3 tables in one go, first join 2 tables and see how the result table will look like. That’s all on How to join three tables in one SQL query in the relational database.

By the way, in this SQL JOIN Example, we have used ANSI SQL and it will work in another relational database as well like Oracle, SQL Server, Sybase, PostgreSQL, etc. Let us know if you face any issues while running this 3 table JOIN query in any other database.


Read more: https://javarevisited.blogspot.com/2012/11/how-to-join-three-tables-in-sql-query-mysql-sqlserver.html#ixzz8hilI6mVl

Difference between WHERE and HAVING clause in SQL? Example

The main difference between the WHERE and HAVING clauses comes when used together with the GROUP BY clause. In that case, WHERE is used to filter rows before grouping, and HAVING is used to exclude records after grouping. This is the most important difference, and if you remember this, it will help you write better SQL queries. This is also one of the important SQL concepts to understand, not just from an interview perspective but also from a day-to-day use perspective. I am sure you have used the WHERE clause because it's one of the most common clauses in SQL along with SELECT and used to specify filtering criteria or conditions.

You can even use the WHERE clause without HAVING or GROUP BY, as you have seen many times. On the other hand, HAVING can only be used if grouping has been performed using the GROUP BY clause in the SQL query. 

PlayUnmute
Fullscreen
Another worth noting thing about the WHERE and HAVING clause is that the WHERE clause cannot contain aggregate functions like COUNT(), SUM(), MAX(), MIN(), etc but the HAVING clause may contain aggregate functions.

Another worth noting the difference between WHERE and HAVING clause is that WHERE is used to impose filtering criterion on a SELECT, UPDATE, DELETE statement as well as single row function and used before group by clause but HAVING is always used after group by clause.

If you are starting with SQL, then these are some of the fundamentals you need to learn, and a good course can help you a lot. If you need a recommendation, I suggest you join any of these best SQL and database courses online. This list contains the best courses from Udmey, Coursera, Pluralsight, and other websites. 





Difference between WHERE vs. HAVING in SQL
1. WHERE clause is processed right after FROM clause in the logical order of query processing, which means it is processed before GROUP BY clause while HAVING clause is executed after groups are created.

2. If used in GROUP BY, You can refer to any column from a table in the WHERE clause, but you can only use columns that are not grouped or aggregated.

3. If you use the HAVING clause without group by, it can also refer to any column, but the index will not be used as opposed to the WHERE clause. For example, the following have the same result set, however "where" will use the id index and having will do a table scan
select * from table where id = 1
select * from the table having id = 1


4. You can use an aggregate function to filter rows with the HAVING clause. Because the HAVING clause is processed after the rows have been grouped, you can refer to an aggregate function in the logical expression. For example, the following query will display only courses which have more than 10 students :
SELECT Course, COUNT(Course) as NumOfStudent 
FROM Training 
GROUP BY Course 
HAVING COUNT(Course)> 10

5. Another key difference between WHERE and HAVING clause is that WHERE will use Index and HAVING will not; for example following two queries will produce an identical result, but WHERE will use Index and HAVING will do a table scan
SELECT * FROM Course WHERE Id = 101;
SELECT * FROM Course HAVING Id = 102;

6. Since the WHERE clause is evaluated before groups are formed, it evaluates for per row. On the other hand, the HAVING clause is evaluated after groups are formed; hence it evaluates per group. You can further see these free SQL online courses to learn more about it.

Difference between WHERE and HAVING clause in SQL?




When to use WHERE and HAVING clauses?
Though both are used to exclude rows from the result set, you should use the WHERE clause to filter rows before grouping and use the HAVING clause to filter rows after grouping. In other words, WHERE can be used to filter on table columns while HAVING can be used to filter on aggregate functions like count, sum, avg, min, and max.

If filtering can be done without aggregate function then you must do it on the WHERE clause because it improves performance because counting and sorting will be done on a much smaller set. If you filter the same rows after grouping, you unnecessarily bear the cost of sorting, which is not used.

For example, the following statement is syntactically correct and produce the same result, but the second one is more efficient than the first one because it filters rows before grouping :

SELECT Job, City, State, Count(Employee) from ... HAVING...
SELECT ..... from .. WHERE ..


Read more: https://www.java67.com/2019/06/difference-between-where-and-having-in-sql.html#ixzz8hilPgYQh

SQL is standard for querying, inserting, and modifying data in a relational database. It is categorized into DDL and DML and is powerful enough to create database objects e.g. table, view, stored procedure, and can perform CRUD operation (SELECT, INSERT, UPDATE, and DELETE) query.

On the other hand, T-SQL (Transact-SQL) is a dialect used by Microsoft SQL Server and Sybase. It is an extension of SQL and provides more functionality than SQL but at the same time confirming ANSI SQL standard as well. For example, you can use conditionals and loops in T-SQL to create a more sophisticated stored procedure that is not available in standard SQL.

Similarly, PL/SQL (Procedural language SEQUEL) is a dialect for Oracle database, which provides T-SQL like functionality e.g. conditionals, loops, and other elements for procedural programming. Both T-SQL and PL/SQL are the supersets of SQL because they not just confirm ANSI SQL standard but also provide additional functionality that is not available in the ANSI standard but helps a lot in database programming.

In this article, you will learn  a couple of more differences between SQL, T-SQL, and PL/SQL to understand them better.





Why do you need T-SQL or PL/SQL?
Though standard SQL is enough for inserting, retrieving, and modifying data from the database, they only provide set-based operations, which means there are a lot of tasks that you cannot do using plain SQL.

In order to make SQL more powerful and to expand its usage from simple querying to create complex stored procedures for report generation, XSLT transformation, and many other functionalities, various database vendors started adding proprietary features on SQL supported by their platform. 

These efforts created different SQL dialects e.g. T-SQL, which is a SQL dialect for Microsoft SQL Server, and Sybase, PL/SQL which is a SQL dialect for Oracle.

In fact, every database has its own SQL dialect, which comprises features and keywords only supported in their database e.g. MySQL has the LIMIT keyword which can be used for pagination or solving problems like second highest salary, but it will not work on Oracle or Microsoft SQL Server database. Similarly, PostgreSQL has some features which are not available to other databases.

It's always recommended to use standard ANSI SQL if it serves your purpose because query written in ANSI SQL is portable across different database vendors but if you use a proprietary keyword e.g. TOP in Microsoft SQL Server, LIMIT in MySQL then you need to change your query when your application migrate from one database to another.




Differences between SQL, T-SQL and PL/SQL
Here are a couple of more differences between SQL, PL/SQL, and T-SQL for interviews:

1. Full form
SQL stands for Structured Query language, T-SQL stands for Transact-SQL and PL/SQL stands for Procedural Language/SQL.

2. Supported Database
SQL is supported across all database vendors like Oracle, SQL Server, MySQL, PostgreSQL, IBM DB2, and even lightweight databases like SQLLite, but T-SQL is only supported in Microsoft SQL Server and Sybase, and PL/SQL is supported only in Oracle.


3. Performance
Another key difference between SQL and PL/SQL, T-SQL is the performance improvement by saving database roundtrip. Both PL/SQL and T-SQL allow grouping of SQL statements which means if your code has 4 SELECT SQL queries then instead of making four round trips to the database, they can be sent as one single unit to the database and their result will also come back as one unit. 

I suggest joining these best Oracle and PL/SQL online courses to learn more about PL/SQL programming. It covers versions through Oracle Database 12c.

difference between SQL vs T-SQL vs PL/SQL?

4. SQL Query Requirement
There is an interesting difference between SQL and T-SQL in terms of minimum SELECT query requirements. According to standard SQL, a SELECT query must have at minimum FROM and SELECT clauses, but you can create a SELECT query in T-SQL with just a SELECT clause, without FROM clause. 

For example, the following SQL query is invalid according to SQL standard but it works fine in T-SQL supported databases like Sybase and MSSQL:

SELECT 'Java' AS Language, 1 AS RANK;

The output of the query is a single row with attributes resulting from the expression with names assigned using the aliases e.g.

Language Rank
Java     1

If you want to learn more about T-SQL, I suggest joining these Microsoft SQL Server and T-SQL Fundamentals courses, a great reference to T-SQL but at the same time a very readable and clear explanation of key SQL concepts.



5. Data Types and Keyword
There are some data types which are supported only by PL/SQL and T-SQL e.g. TINYINT data type is only available in T-SQL and VARCHAR2 and NUMBER is only available in PL/SQL or Oracle database. Similarly, there are keywords which are only available in a particular SQL dialect like the LIMIT keyword which is only available in MySQL.

If you want to learn more about features, keyword, and data types supported by different vendors I strongly suggest joining these best SQL courses, it provides a great cross-platform syntax for SQL. Absolutely must-read for those programmers who work with multiple databases


Read more: https://javarevisited.blogspot.com/2017/03/difference-between-sql-tsql-and-plsql.html#ixzz8hilico1X

Difference between UNION vs UNION ALL in SQL? Example

Hello guys, what is the difference between UNION vs UNION ALL is one of the most popular SQL interview questions and often asked programmers during a telephonic round of interviews. Though both UNION and UNION ALL is used to combine results of two SELECT queries, the main difference between them is that UNION doesn't include duplicate record but UNION ALL does. Another difference between them is that UNION ALL is faster than UNION but may look slow because it returns more data which takes more time to travel via the network. The difference between UNION and UNION ALL can be a tricky SQL question, especially for developers, who have not used this useful keyword ever. 

Since the UNION clause is not as common as a SELECT clause in SQL, it's usually asked in a telephonic round of programming interviews to check whether the candidate is comfortable with SQL or not. It's in the same league of questions like clustered vs non-clustered index or primary vs unique key. UNION is very different than other SQL commands because it operates on data rather than columns.
PlayUnmute
Fullscreen

Anyway, the answer to this question is simple, though both UNION and UNION ALL are used to combine the result of two separate SQL queries on the same or different table,  UNION does not keep a duplicate record (a row is considered duplicate if the value of all columns is same), while UNION ALL does.



Since you mostly don't want duplicate rows,  UNION is preferred over UNION ALL in reporting and application development. By the way, you should keep in mind that UNION ALL performance better than UNION because it doesn't have to remove duplicates, so no extra work.

This keyword is very well supported by all major databases like Oracle, Microsoft SQL Server, MySQL, and PostgreSQL. Another thing to keep in mind is the amount of data returned by UNION ALL; if your database server is quite far away and you have limited bandwidth, UNION ALL may appear slower than UNION because of the number of duplicates it returned.

The cost of transferring duplicate rows can exceed the query execution benefits in many cases. We will see a couple of examples UNION and UNION ALL in SQL, but before that few things to keep in mind. In order to combine the results of two queries, they must contain the same number of columns.

For example, if one query contains 3 columns and the other contains 4 columns then you can not use UNION or UNION ALL. This is because a row will only be considered duplicated when all columns will have the same value, irrespective of the name of the columns themselves.

By the way, if you are just starting with SQL and not familiar with essential SQL concepts and commands then I highly recommend you to join an online SLQ course like SQL for Newbs: Data Analysis for Beginners on Udemy to start with. One of the highest-rated beginner SQL courses on Udemy and you can get it for just $10 on sales. 





UNION and UNION ALL Example in Microsoft SQL Server
Let's see one simple example of UNION and UNION ALL, this will not only show you how they work but also where you can use them. This example is from my sample database and the following screenshot is from SQL Server Management Studio.

 We have two tables, Employee and Customer. In order to use UNION and UNION ALL, I have kept the same persons as employee and customer, so you will see the same id on emp_id and customer_id, and the same name as well. 

If you look at the result of the first two select queries, you will see that the first query returns two rows and the second query returns three rows, where two rows have exactly the same data as the first query. 

Key things to note is that column names are different in both result sets, first one has emp_id and emp_name, while second data set has customer_id and customer_name, but most important both dataset has only two columns. This is a must in order to combine them using UNION and UNION ALL keywords. 

The third query is an example of how to use the UNION clause in SQL, you can see that the combined result has just three columns, all are unique. Duplicate columns from the second result set were not included. This is more like how you do UNION in Set theory, where the final result contains data from both sets. 

The fourth query is how you should use UNION ALL, it contains five rows, two from the first query and three from the second query. It has not removed duplicate rows from the second query, that's why you see Ken and Bob repeating twice. 

This example teaches us the core concept that the UNION doesn't depend upon the column name but the data. You can combine the result of as many queries as possible until the number of columns in all of them is the same and the data is from the same set.


Regarding performance, you need to run UNION and UNION ALL with a large database, containing millions of rows. There you can monitor how much time both takes and compare them. 

Theoretically, UNION ALL should take less time to execute but more time to transfer data to the client. By the way, if are new to SQL Server then I recommend you to go through an introductory course like Microsoft SQL for Beginners on Udemy. It's a great course to start learning SQL using MSSQL and tools. 


Difference between UNION ALL and UNION in SQL SERVER



Difference between UNION and UNION ALL command in SQL
Now we know how union and union all works and has some background by following the above examples, let's summarise the similarities and difference between them for quick revision :

1. Combining Results

Both UNION and UNION ALL are used to combine the results of two separate SQL queries, it could be on the same table or a different table but the data should be the same. For example, if product_id is used in two tables like Product and Order, then two SQL queries which pulls product_id from these two tables can be combined using UNION or UNION ALL.

2. Duplicates
The key difference between UNION and UNION ALL is that the former will remove duplicates but later will keep them. In other words, UNION is equal to running distinct on the output of UNION ALL. For example, if product_id 10 is returned by both SQL query then it will only appear once if you use UNION and appear twice if you use UNION ALL.

3. Execution time
Due to the above difference query execution time of UNION ALL is smaller than UNION, which means the former runs faster than the latter. So if you want faster output and don't care about duplicates use UNION ALL. 

This is something you can deduce from your existing SQL knowledge and that's where working on fundamentals pays off. If you want to improve your SQL skill or just want to revise SQL concepts then An Introductory Guide to SQL course on Educative, an interactive learning platform is a good place to start with. 

best interactive course to learn SQL

And, if you find the Educative platform and their interview courses like Grokking the System design useful then consider getting an Educative Subscription which provides access to their 100+ courses for just $14 per month. It's very cost-effective and great for preparing for coding interviews. 



4. Speed and Bandwith Usage
You should keep in mind that benefits gained by not removing duplicates can be easily wiped out by transferring more data over a poor bandwidth network connection. That's why in practice some time UNION ALL appears slower than UNION because it returns a lot of data with duplicates which require more time to travel from database server to client machine. To evaluate the performance of UNION and UNION ALL case by case.




5. Number of Columsn on ResultSet
Another worth noting thing while using UNION and UNION ALL is that all queries combined using a UNION, INTERSECT, or EXCEPT operator must have an equal number of expressions in their target lists. For example, if the result of query 1 has three columns and the result of query 2 has two columns then you cannot combine them using the UNION command.


That's all on the difference between the UNION and UNION ALL command in SQL. It's one of the useful commands to combine the result of two SELECT queries when they contain the same data. There are many practical scenarios where UNION is very useful, for example when you need to create a list out of different tables containing data from the same set. 

The main difference between UNION and UNION ALL is about duplicates, the former removes it while later keeps it, other differences between them on performance and networking bandwidth usage can be easily derived by knowing this difference. Also keep in mind that it is well supported big three databases like MySQL, Oracle, and SQL Server. Let us know if you have been asked this question in your SQL interview.


Read more: https://www.java67.com/2014/09/difference-between-union-vs-union-all-in-SQL.html#ixzz8hilvY4ue

Difference between WHERE vs HAVING clause in SQL - GROUP BY Comparison with Example

What is the difference between WHERE and  HAVING clause in SQL is one of the most popular questions asked on SQL and database interviews, especially to beginners? Since programming jobs, required more than one skill, it’s quite common to see a couple of SQL Interview questions in Java and .NET interviews. By the way unlike any other question, not many Java programmers or dot net developers, who are supposed to have knowledge of basic SQL, fail to answer this question. Though almost half of the programmer says that WHERE is used in any SELECT query, while HAVING clause is only used in SELECT queries, which contains aggregate function or group by clause, which is correct.
PauseUnmute
Fullscreen


Though both WHERE and HAVING clause is used to specify filtering condition in SQL, there is subtle difference between them. Real twist comes into interview, when they are asked to explain result of a SELECT query, which contains both WHERE and HAVING clause, I have seen many people getting confused there. 

Key point, which is also the main difference between WHERE and HAVING clause in SQL is that, condition specified in WHERE clause is used while fetching data (rows) from table, and data which doesn't pass the condition will not be fetched into result set, on the other hand HAVING clause is later used to filter summarized data or grouped data. 

In short if both WHERE and HAVING clause is used in a SELECT query with aggregate function or GROUP BY clause, it will execute before HAVING clause. This will be more clear, when we will see an example of WHERE, HAVING, JOIN and GROUP BY clause together.





WHERE vs HAVING Clause Example in SQL
Difference betwen WHERE and HAVING clause in SQL - Interview QuestionIn this example of the WHERE and HAVING clause, we have two tables Employee and Department. Employee contains details of employees e.g. id, name, age, salary and department id, while Department contains id and department name. In order to show, which employee works for which department we need to join two tables on DEPT_ID to get the department name. 

Our requirement is to find how many employees are working in each department and the average salary of the department. In order to use the WHERE clause, we will only include employees who are earning more than 5000. Before executing our query which contains WHERE HAVING, and GROUP BY clause, let see data from Employee and Department table:

SELECT * FROM Employee;
EMP_ID
EMP_NAME
EMP_AGE
EMP_SALARY
DEPT_ID
1
Virat
23
10000
1
2
Rohit
24
7000
2
3
Suresh
25
8000
3
4
Shikhar
27
6000
1
5
Vijay
28
5000
2


SELECT * FROM Department;
DEPT_ID
DEPT_NAME
1
Accounting
2
Marketing
3
Sales


SELECT d.DEPT_NAME, count(e.EMP_NAME) as NUM_EMPLOYEE, avg(e.EMP_SALARY) as AVG_SALARY FROM Employee e,
Department d WHERE e.DEPT_ID=d.DEPT_ID AND EMP_SALARY > 5000 GROUP BY d.DEPT_NAME;
DEPT_NAME
NUM_EMPLOYEE
AVG_SALARY
Accounting
1
8000
Marketing
1
7000
Sales
2
8000


From the number of employees (NUM_EMPLOYEE) column you can see that only Vijay who work for Marketing department is not included in result set because his earning 5000. This example shows that, condition in WHERE clause is used to filter rows before you aggregate them and then HAVING clause comes in picture for final filtering, which is clear from following query, now Marketing department is excluded because it doesn't pass condition in HAVING clause I mean AVG_SALARY > 7000

SELECT d.DEPT_NAME, count(e.EMP_NAME) as NUM_EMPLOYEE, avg(e.EMP_SALARY) as AVG_SALARY FROM Employee e,
Department d WHERE e.DEPT_ID=d.DEPT_ID AND EMP_SALARY > 5000 GROUP BY d.DEPT_NAME HAVING AVG_SALARY > 7000;
DEPT_NAME
NUM_EMPLOYEE
AVG_SALARY
Accounting
1
8000
Sales
2
8000




Difference between WHERE and HAVING in SQL
Apart from this key difference we have seen in this article, here are few more differences between WHERE and HAVING clause, which is worth remembering and can be used to compare both of them :

1) Apart from SELECT queries, you can use the WHERE clause with UPDATE and DELETE clause but the HAVING clause can only be used with SELECT query. For example following query, which involves WHERE clause will work but others which uses HAVING clause will not work :

update DEPARTMENT set DEPT_NAME="NewSales" WHERE DEPT_ID=1 ;  // works fine

update DEPARTMENT set DEPT_NAME="NewSales" HAVING DEPT_ID=1 ; // error
Incorrect syntax near the keyword 'HAVING'.: update DEPARTMENT set DEPT_NAME='NewSales' HAVING DEPT_ID=1

2) WHERE clause is used for filtering rows and it applies on each and every row, while HAVING clause is used to filter groups in SQL.

3) One syntax level difference between WHERE and HAVING clause is that, former is used before GROUP BY clause, while later is used after GROUP BY clause.

4) When WHERE and HAVING clause are used together in a SELECT query with aggregate function,  WHERE clause is applied first on individual rows and only rows which pass the condition is included for creating groups. Once group is created, HAVING clause is used to filter groups based upon condition specified.


Here is a list of difference between WHERE and HAVING clause in point format:

ifference between WHERE vs HAVING clause in SQL


That's all on the difference between WHERE and HAVING clause in SQL. As I said this is very popular question and you can't afford not to prepare it. Always remember key difference between WHERE and HAVING clause in SQL, if WHERE and HAVING clause is used together, first WHERE clause is applied to filter rows and only after grouping HAVING clause is applied.


Read more: https://javarevisited.blogspot.com/2013/08/difference-between-where-vs-having-clause-SQL-databse-group-by-comparision.html#ixzz8himKSi32

20+ ArrayList Questions with Answers from Java Interviews
So without wasting any more time, let's start with the questions. The questions are mainly divided into two categories, one is a fact-based question, which checks how much you know about ArrayList, and the other is the task-based question, which evaluates how good you are at doing things with ArrayList. In my list, I have combined both of them.


1. How to remove duplicates from ArrayList in Java?  (Answer)
This is a task-based question. Since the List interface allows duplicates, ArrayList also allowed it but if you remember Set interface doesn't allow duplicates, which means you can remove duplicates from ArrayList by converting it into a Set and then back to ArrayList, but how will you keep the order intact? See the answer for a more detailed explanation.


2. How to reverse ArrayList in Java? (Answer)
You can reverse ArrayList by using the Collections.reverse() method.  There are a couple of more ways like iterating through the list and copying elements into a new list. See the answer for more ways to do this task.


And if you want to learn more about ArrayList and other collection classes, you can also check out Java Fundamentals: Collections course by Richard Warburton on Pluralsight. Richard is a Java champion and this course is the best online course to learn the Collection framework in depth. 







3. Difference between an array and an ArrayList in Java? (Answer)
This is a fresher-level interview question, the main difference between array and ArrayList is that the former is static and the latter is dynamic. You cannot change the size of the array once created, but ArrayList can grow and increase its size automatically.


4. How to synchronize ArrayList in Java? (Answer)
This is a very good task-based question. If you remember, ArrayList is not thread-safe, its not synchronized either, which means you cannot share it between multiple threads if one of them modifies it. Don't worry, you can synchronize ArrayList by using Collections.synchronizedList() method. Check the answer to understand the steps.


5. When to use ArrayList and LinkedList in Java? (Answer)
This is by far the most popular ArrayList based question from Java Interviews and you can answer it very easily if you are familiar with two key data structures, array, and linked list. 


Since array provides constant-time search operation, it's better to use ArrayList if search outnumbers add and remove operation, otherwise use LinkedList which provides constant time add and remove operation. See the answer for a more detailed discussion on this topic.


Java ArrayList Interview Questions and Answers


6. Difference between ArrayList and HashSet in Java? (Answer)
One of the simplest questions you will ever see on a Java interview. The main difference is the former is List while the later is Set which means ArrayList allowed duplicates, keeps elements in order while HashSet doesn't allow duplicates and provides no ordering guarantee.


7. How to loop over ArrayList in Java? (Answer)
There are many ways to traverse over ArrayList, you can use classic for loop with index, or you can take iterator from ArrayList and can use while loop in conjunction with Iterator.hasNext() method, Or you can use the new foreach loop introduced in Java 5, which doesn't require an index. See the answer to live examples.


8. Difference between Vector and ArrayList in Java? (Answer)
This is the second most popular question based on ArrayList in Java. Though both Vector and ArrayList implement List interface, Vector is synchronized while ArrayList is not synchronized, which means the former is thread-safe and fast while the latter is not thread-safe and slow.


9. How to create and initialize ArrayList in one line? (Answer)
There is a nice little trick to do this by using the Arrays.asList() method, but remember the List returned by this class has some differences with ArrayList, please check the answer to understand what are those differences.


10. How to sort ArrayList in Java? (Answer)
Another task-based ArrayList interview question. You can easily sort the ArrayList by using Collections.sort() method, all you need to make sure is that elements implement either the Comparable or Comparator interface. The former is used to sort on natural order while the latter is used while sorting in the custom order.


11. Difference between HashMap and ArrayList in Java? (Answer)
There is a huge difference between HashMap and ArrayList, fundamental is former is a Map data structure that stores key-value pairs while the latter stores just an object. HashMap access object using key while ArrayList access elements using an index. Though both provide O(1) search performance, ArrayList's performance is guaranteed but HashMap can vary depending upon collision level.


12. How to use ArrayList in Java? (Answer)
Just see the article to learn different ways of using this popular class in Java.


13. How to convert ArrayList to String in Java? (Answer)
Simple, just call toString()  right? unfortunately, the String representation is not very helpful. If you are looking for a comma-separated String containing all elements of ArrayList then you can either use Java 8 String joiner or some older library method as shown in the answer page.


14. How to get a sublist from ArrayList in Java? (Answer)
This is another task-based question, but you can easily do it if you remember API. You can get a list of elements in a range by using the subList() method from the ArrayList class. This would be very helpful in case of a sorted list.


15. Difference between length() of array and size() of ArrayList in Java? (Answer)
This is one of the tricky questions, if you get the backed array and call the length() it will return how many elements you can store in this array, also known as capacity, but if you call the size() function of ArrayList class then it will return a total number of elements currently stored in ArrayList, which is always less than or equal to capacity.


16, What is CopyOnWriteArrayList in Java? (Answer)
It's a concurrent collection class that is introduced as an alternative to synchronized List in Java. This class takes advantage of the advanced thread-safety technique instead of locking. It's very efficient if ArrayList is mostly used for reading purposes because it allows multiple threads to read data without locking, which was not possible with synchronized ArrayList. See the answer to learn more about the CopyOnWriteArrayList class.


17. How to remove objects from ArrayList in Java? (Answer)
There are two ways to remove elements from ArrayList, first, you can call the remove(int index) method and pass on the index of the element you want to remove, and second, you can call the remove(Object obj) method and pass the element you want to remove. By the way, just be careful while working with ArrayList of integers because autoboxing can cause issues by creating an ambiguity between two remove methods. See the answer for a more detailed discussion on the topic.


18. How to make ArrayList read-only in Java? (Answer)
Another task and API-based interview question. You can answer it easily if you are about the Collections utility class, which provides several wrappers of the standard ArrayList class e.g. you can use Collections to create a synchronized version or read-only version of ArrayList in Java.


19. How to sort ArrayList in descending order in Java? (Answer)
This is the follow-up question of one of the previous questions related to sorting. By default, elements are sorted in increasing order as this is how their compareTo() or compare() method compares them. If you want to sort into descending order, just reverse the comparison logic using the Collections.reverseComparator() method.

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


30 Array Coding Problems for Programming Interviews
Ok, let's now start with my list of array interview questions, my solutions are in Java, but you are free to solve in any programming language of your choice.


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


Read more: https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html#ixzz8hioiCHLH

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

When to use ArrayList vs LinkedList in Java? [Answered]

When to use ArrayList or LinkedList in Java is one of the most popular Java interview questions and also asked as a difference between ArrayList and LinkedList. Earlier, I have shared common Java collections interview questions and in this article, I will explain the difference between them. ArrayList and LinkedList are two popular concrete implementations of the List interface from Java's popular Collection framework. Being List implementation both ArrayList and LinkedList are ordered, the index-based and allows duplicate. Despite being from the same type of hierarchy there are a lot of differences between these two classes which makes them popular among Java interviewers.


The main difference between ArrayList vs LinkedList is that the former is backed by an array while the latter is based upon the linked list data structure, which makes the performance of add(), remove(), contains(), and iterator() different for both ArrayList and LinkedList.
PlayUnmute
Fullscreen

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

PauseUnmute
Fullscreen
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

PauseUnmute
Fullscreen
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
PlayUnmute
Fullscreen

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
PlayUnmute
Fullscreen



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

PauseUnmute
Fullscreen
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

PauseUnmute
Fullscreen
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
PauseUnmute
Fullscreen

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
PlayUnmute
Fullscreen


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
PlayUnmute
Fullscreen


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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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
PlayUnmute
Fullscreen


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
PauseUnmute
Fullscreen


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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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


PlayUnmute
Fullscreen
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
PlayUnmute
Fullscreen

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

PauseUnmute
Fullscreen
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

PauseUnmute
Fullscreen
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

PauseUnmute
Fullscreen
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

PauseUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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

PauseUnmute
Fullscreen
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

PlayUnmute
Fullscreen

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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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

PauseUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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
PlayUnmute
Fullscreen

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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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

PlayUnmute
Fullscreen
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



PlayUnmute
Fullscreen




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
PauseUnmute
Fullscreen

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
 
PlayUnmute
Fullscreen
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
PlayUnmute
Fullscreen

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


PlayUnmute
Fullscreen
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




PlayUnmute
Fullscreen
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



PlayUnmute
Fullscreen



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
