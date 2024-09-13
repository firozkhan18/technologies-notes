File Input/Output (I/O) in Java is a fundamental aspect of many applications. It allows you to read from and write to files on the file system. Java provides a rich set of classes and methods for handling file operations, primarily in the `java.io` and `java.nio.file` packages. Here’s a comprehensive overview of the concepts and classes you need to understand for complete file I/O in Java:

### 1. Basic Concepts

- **Streams**: Streams are sequences of data that can be read from or written to. Java uses two main types of streams:
  - **Byte Streams**: For reading and writing binary data. Examples include `FileInputStream` and `FileOutputStream`.
  - **Character Streams**: For reading and writing text data. Examples include `FileReader` and `FileWriter`.

- **Files**: Files are the physical data stored on disk. Java represents files using the `File` class.

### 2. Byte Streams

Byte streams handle data in byte form and are used for binary data such as images, audio, or serialized objects.

- **Input Stream**: Used to read data from a file.
  - `FileInputStream`: Reads bytes from a file.
  - `BufferedInputStream`: Adds buffering to an input stream, which can improve performance.
  - `DataInputStream`: Allows you to read Java primitive data types (e.g., `int`, `float`) from a file.

- **Output Stream**: Used to write data to a file.
  - `FileOutputStream`: Writes bytes to a file.
  - `BufferedOutputStream`: Adds buffering to an output stream.
  - `DataOutputStream`: Allows you to write Java primitive data types to a file.

### 3. Character Streams

Character streams handle data as characters, which is useful for text data.

- **Reader**: Used to read data from a file.
  - `FileReader`: Reads characters from a file.
  - `BufferedReader`: Adds buffering to a `FileReader`, improving performance and providing methods like `readLine()`.
  - `CharArrayReader`: Reads from a character array.

- **Writer**: Used to write data to a file.
  - `FileWriter`: Writes characters to a file.
  - `BufferedWriter`: Adds buffering to a `FileWriter`, which can improve performance and allows you to write text efficiently.
  - `PrintWriter`: Extends `BufferedWriter` and provides convenience methods for writing formatted text.

### 4. File Class

The `File` class in the `java.io` package represents a file or directory path. It does not contain methods for reading or writing file content but provides methods for file management.

- **Creation and Deletion**: `createNewFile()`, `delete()`, `mkdir()`, `mkdirs()`
- **Path Operations**: `getAbsolutePath()`, `getCanonicalPath()`, `renameTo(File dest)`
- **File Information**: `length()`, `lastModified()`, `isFile()`, `isDirectory()`, `listFiles()`

### 5. NIO (New I/O)

The `java.nio` package provides more advanced and flexible file I/O operations than `java.io`, introduced in Java 1.4.

- **Files**: The `Files` class in `java.nio.file` provides static methods for file operations.
  - `Files.readAllBytes(Path path)`: Reads the entire file content into a byte array.
  - `Files.readAllLines(Path path)`: Reads all lines from a file into a `List<String>`.
  - `Files.write(Path path, byte[] bytes)`: Writes byte array to a file.
  - `Files.copy(Path source, Path target)`: Copies a file from source to target.
  - `Files.move(Path source, Path target)`: Moves a file from source to target.

- **Paths**: The `Path` class represents a file or directory path.
  - `Paths.get(String first, String... more)`: Creates a `Path` object.

- **FileChannel**: Provides efficient file I/O operations.
  - `FileChannel` is used to read and write data in a file and provides methods such as `read()`, `write()`, and `transferTo()`.

### 6. Exceptions

File I/O operations can throw various exceptions, including:
- `IOException`: General I/O exception.
- `FileNotFoundException`: Thrown when a file is not found.
- `EOFException`: Thrown when the end of file is reached unexpectedly.
- `UnsupportedEncodingException`: Thrown when an unsupported encoding is used.

### 7. Example Code

Here's a simple example demonstrating file reading and writing using both `java.io` and `java.nio.file`:

**Using `java.io`:**

```java
import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        String fileName = "example.txt";
        
        // Writing to a file
        try (FileWriter writer = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from a file
        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Using `java.nio.file`:**

```java
import java.nio.file.*;
import java.io.IOException;

public class NioFileExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");
        
        // Writing to a file
        try {
            Files.write(filePath, "Hello, World!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from a file
        try {
            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Understanding these concepts will help you effectively manage file operations in Java, whether you’re dealing with simple text files or more complex binary data.

Java 8 introduced several enhancements to file I/O, especially with the `java.nio.file` package and the `java.nio.file.Files` class. While Java 8 did not significantly alter the foundational concepts of file I/O, it added powerful new features and utilities that simplify and streamline file operations. Here’s a detailed look at file I/O concepts in Java 8:

### 1. Java I/O Basics

- **Byte Streams**: Handle raw binary data. Examples: `FileInputStream`, `FileOutputStream`, `BufferedInputStream`, `BufferedOutputStream`.
- **Character Streams**: Handle text data. Examples: `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`.

### 2. `java.nio.file` Package

Java 7 introduced the `java.nio.file` package, and Java 8 continued to enhance its functionality. This package provides more efficient and flexible file operations than the traditional `java.io` classes.

#### Key Classes and Interfaces

- **`Files`**: Provides static methods for file operations.
- **`Path`**: Represents a file system path.
- **`Paths`**: Utility class for creating `Path` objects.
- **`FileSystems`**: Provides access to the default `FileSystem` and others.
- **`WatchService`**: Monitors changes to files and directories.

#### Common Operations with `Files`

- **Reading Files**

  ```java
  import java.nio.file.*;
  import java.io.IOException;
  import java.util.List;

  public class FilesExample {
      public static void main(String[] args) {
          Path path = Paths.get("example.txt");

          try {
              // Read all bytes
              byte[] bytes = Files.readAllBytes(path);
              System.out.println(new String(bytes));

              // Read all lines
              List<String> lines = Files.readAllLines(path);
              lines.forEach(System.out::println);

              // Read file content as a stream
              try (Stream<String> stream = Files.lines(path)) {
                  stream.forEach(System.out::println);
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

- **Writing Files**

  ```java
  import java.nio.file.*;
  import java.io.IOException;
  import java.util.List;

  public class FilesWriteExample {
      public static void main(String[] args) {
          Path path = Paths.get("example.txt");

          try {
              // Write bytes
              Files.write(path, "Hello, World!".getBytes());

              // Write lines
              List<String> lines = List.of("Hello", "World");
              Files.write(path, lines);

              // Append text
              Files.write(path, "\nAppended text.".getBytes(), StandardOpenOption.APPEND);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

- **Copying, Moving, and Deleting Files**

  ```java
  import java.nio.file.*;
  import java.io.IOException;

  public class FilesCopyMoveDeleteExample {
      public static void main(String[] args) {
          Path source = Paths.get("source.txt");
          Path target = Paths.get("target.txt");

          try {
              // Copy file
              Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

              // Move file
              Path movedTarget = Paths.get("movedTarget.txt");
              Files.move(target, movedTarget, StandardCopyOption.REPLACE_EXISTING);

              // Delete file
              Files.delete(movedTarget);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

- **File Attributes**

  ```java
  import java.nio.file.*;
  import java.io.IOException;
  import java.nio.file.attribute.BasicFileAttributes;

  public class FileAttributesExample {
      public static void main(String[] args) {
          Path path = Paths.get("example.txt");

          try {
              BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
              System.out.println("Creation Time: " + attrs.creationTime());
              System.out.println("Last Modified Time: " + attrs.lastModifiedTime());
              System.out.println("Size: " + attrs.size());
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

### 3. WatchService

The `WatchService` API allows you to monitor file and directory changes. This is useful for applications that need to react to changes in the filesystem.

```java
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.io.IOException;

public class WatchServiceExample {
    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == OVERFLOW) {
                        continue;
                    }

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path filename = ev.context();

                    System.out.printf("%s: %s\n", kind.name(), filename);
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 4. Additional Concepts

- **File System Providers**: The `java.nio.file` package supports various file system providers, allowing access to different file systems (e.g., local, network).

- **File Attributes**: Various file attributes can be accessed using `Files.readAttributes()`, including `BasicFileAttributes`, `PosixFileAttributes`, etc.

- **Memory-Mapped Files**: For large files, `FileChannel` provides memory-mapped file operations via `map()`.

### 5. Exception Handling

- **`IOException`**: Base exception for all file I/O errors.
- **`NoSuchFileException`**: Thrown when a file is not found.
- **`FileAlreadyExistsException`**: Thrown when trying to create a file that already exists.
- **`DirectoryNotEmptyException`**: Thrown when trying to delete a non-empty directory.

Understanding and utilizing these features will help you effectively manage file operations in Java 8 and beyond. The `java.nio.file` package offers a more modern and comprehensive approach compared to the traditional `java.io` package, enhancing performance and flexibility in file handling.

# List All Files In Directory – With Java 8 Examples

File handling is an important topic in java. You will face many questions on this topic in your interview. I have covered some of the questions asked in interview on File Handling – how to sort a text file, how to find most repeated word in a text file, count chars, words & lines in a text file,  append text to a file, comparing two text files, setting file permissions etc… You can go through more file handling programs here. Continuing from there, in this post, we will learn how to list all files in directory in java with some simple examples along with java 8 code.

java.io.File class has 5 different methods to get list of all files and directories in a directory. The below image describes those methods and when to use them. In Java 8, two more methods are introduced in java.nio.file.Files class. We will also see them at the end.

## How To List All Files In Directory In Java
Note : FileNameFilter uses just names of the files to filter them. If you want to filter the files using other properties like size of the file, use FileFilter.

Let’s see some of the examples on how to get list of all files and folders in a folder using above methods.

File.list() Method Example :
```java
import java.io.File;
 
public class MainClass
{
    public static void main(String[] args)
    {
        File folder = new File("F:/Path"); 
        String[] files = folder.list(); 
        for (String file : files)
        {
            System.out.println(file);
        }
    }
}
File.listFiles() Method Example :

import java.io.File;
 
public class MainClass
{
    public static void main(String[] args)
    {
        File folder = new File("F:/Path"); 
        File[] files = folder.listFiles(); 
        for (File file : files)
        {
            System.out.println(file.getName());
        }
    }
}
```
File.listFiles(FilenameFilter filter) Method Example :
```java
import java.io.File;
import java.io.FilenameFilter;
 
public class MainClass
{
    public static void main(String[] args)
    {
        File folder = new File("C:/Path"); 
        //Implementing FilenameFilter to retrieve only txt files 
        FilenameFilter txtFileFilter = new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                if(name.endsWith(".txt"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }; 
        //Passing txtFileFilter to listFiles() method to retrieve only txt files 
        File[] files = folder.listFiles(txtFileFilter); 
        for (File file : files)
        {
            System.out.println(file.getName());
        }
    }
}
```
File.listFiles(FileFilter filter) Method Example :
```java
import java.io.File;
import java.io.FileFilter;
 
public class MainClass
{
    public static void main(String[] args)
    {
        File folder = new File("C:/Path"); 
        //Implementing FileFilter to retrieve the files smaller than 10MB 
        FileFilter sizeFilter = new FileFilter()
        {
            @Override
            public boolean accept(File file)
            {
                if(file.length() < 10*1024*1024)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }; 
        //Passing sizeFilter to listFiles() method 
        File&#91;&#93; files = folder.listFiles(sizeFilter); 
        for (File file : files)
        {
            System.out.println(file.getName());
        }
    }
}
&#91;/java&#93;
<!-- /wp:shortcode -->
 
<!-- wp:paragraph -->
<p>Some other examples.....</p>
<!-- /wp:paragraph -->
 
<!-- wp:heading {"level":4} -->
<h4>How To List Only The Files In A Directory?</h4>
<!-- /wp:heading -->
 
<!-- wp:shortcode -->
[java]
import java.io.File;
 
public class MainClass
{
    public static void main(String[] args)
    {
        File folder = new File("F:/Path"); 
        File[] files = folder.listFiles(); 
        for (File file : files)
        {
            if (file.isFile())
            {
                System.out.println(file.getName());
            }
        }
    }
}
```
How to list only the sub directories in a directory?
```java
import java.io.File;
 
public class MainClass
{
    public static void main(String[] args)
    {
        File folder = new File("F:/Path"); 
        File[] files = folder.listFiles(); 
        for (File file : files)
        {
            if (file.isDirectory())
            {
                System.out.println(file.getName());
            }
        }
    }
}
```
How to list all files in directory and its sub directories recursively?
```java
import java.io.File;
 
public class MainClass
{
    private static void listFiles(String path)
    {
        File folder = new File(path);
         File[] files = folder.listFiles(); 
        for (File file : files)
        {
            if (file.isFile())
            {
                System.out.println(file.getName());
            }
            else if (file.isDirectory())
            {
                listFiles(file.getAbsolutePath());
            }
        }
    } 
    public static void main(String[] args)
    {
        listFiles("F:/Path");
    }
}
```
Java 8 Methods :
In Java 8, two more methods are introduced in java.nio.file.Files class to iterate over a file hierarchy and get list of all files and directory in it. They are – Files.walk() and Files.list(). The main difference between these two methods is, Files.walk() recursively traverses the given directory and it’s sub-directories to get list of all the files and folders in the hierarchy. Files.list() traverses only the current directory. Let’s see them in detail.


1) Stream<Path> Files.list(Path dir) throws IOException

This method returns a lazy Stream of Path objects where each object represents an entry in the directory. The listing is not recursive.

2) Stream<Path> Files.walk(Path start, FileVisitOption… options) throws IOException

This method returns a lazy Stream of Path objects by walking the file tree rooted at a given starting file start. The listing is recursive. That means this method recursively traverses the given directory and its sub-directories to get list of all the files.

Let’s see how to list files in directory using above java 8 methods.

Files.list() Java 8 Method Example : List All Files And Directories
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
 
public class Java8ListFilesInDirectory 
{
    public static void main(String[] args) throws IOException
    {
        Stream<Path> files = Files.list(Paths.get("F:\\Games"));         
        files.forEach(System.out::println);         
        files.close();
    }
}
```
Files.walk() Java 8 Method Example : List All Files And Directories
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
 
public class Java8ListFilesInDirectory 
{
    public static void main(String[] args) throws IOException
    {
        Stream<Path> files = Files.walk(Paths.get("F:\\Games"));         
        files.forEach(System.out::println);         
        files.close();
    }
}
```
Java 8 Coding Examples :
1 ) List Only Files
```java

//Using Files.list() method
         
Files.list(Paths.get("F:\\Games")).filter(Files::isRegularFile).forEach(System.out::println);
                 
//using Files.walk() method
                 
Files.walk(Paths.get("F:\\Games")).filter(Files::isRegularFile).forEach(System.out::println);
```
2) List Only Directories

```java
//Using Files.list() method
         
Files.list(Paths.get("F:\\Games")).filter(Files::isDirectory).forEach(System.out::println);
                 
//using Files.walk() method
                 
Files.walk(Paths.get("F:\\Games")).filter(Files::isDirectory).forEach(System.out::println);
```
3) List Only Text Files
```java
//Using Files.list() method
         
Files.list(Paths.get("F:\\Games")).filter(path -> path.toString().endsWith(".txt")).forEach(System.out::println);
                 
//using Files.walk() method
                 
Files.walk(Paths.get("F:\\Games")).filter(path -> path.toString().endsWith(".txt")).forEach(System.out::println);
```
4) List Only Hidden Files

```java
//Using Files.list() method
         
Files.list(Paths.get("F:\\Games")).filter(file -> {
    try {
        return Files.isHidden(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}).forEach(System.out::println);
                 
//using Files.walk() method
                 
Files.walk(Paths.get("F:\\Games")).filter(file -> {
    try {
        return Files.isHidden(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}).forEach(System.out::println);

```
