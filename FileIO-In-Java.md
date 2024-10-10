Here is a tabular representation of the Java I/O classes and interfaces defined in `java.io`, including deprecated classes and newly added classes in Java SE 6:

### **Java I/O Classes**

| **Class**                  | **Description**                                                                                                 |
|----------------------------|-----------------------------------------------------------------------------------------------------------------|
| **BufferedInputStream**    | Reads bytes from a file with buffering to improve performance.                                                  |
| **BufferedOutputStream**   | Writes bytes to a file with buffering to improve performance.                                                   |
| **BufferedReader**         | Reads text from a file with buffering to improve efficiency.                                                    |
| **BufferedWriter**         | Writes text to a file with buffering to improve efficiency.                                                     |
| **ByteArrayInputStream**   | Reads bytes from a byte array.                                                                                   |
| **ByteArrayOutputStream**  | Writes bytes to a byte array, which can be retrieved later.                                                       |
| **CharArrayReader**        | Reads characters from a character array.                                                                        |
| **CharArrayWriter**        | Writes characters to a character array, which can be retrieved later.                                             |
| **Console**                | Provides access to the system console for reading input and writing output (added in Java SE 6).                 |
| **DataInputStream**        | Reads Java primitive data types from a binary stream.                                                            |
| **DataOutputStream**       | Writes Java primitive data types to a binary stream.                                                             |
| **File**                  | Represents a file or directory path in the filesystem.                                                           |
| **FileDescriptor**         | Represents an open file descriptor.                                                                             |
| **FileInputStream**        | Reads bytes from a file.                                                                                         |
| **FileOutputStream**       | Writes bytes to a file.                                                                                        |
| **FileReader**             | Reads characters from a file.                                                                                     |
| **FileWriter**             | Writes characters to a file.                                                                                      |
| **FilterInputStream**      | A superclass for classes that filter input streams.                                                               |
| **FilterOutputStream**     | A superclass for classes that filter output streams.                                                              |
| **FilterReader**           | A superclass for classes that filter character input streams.                                                     |
| **FilterWriter**           | A superclass for classes that filter character output streams.                                                    |
| **InputStream**            | Abstract class for reading byte streams.                                                                        |
| **InputStreamReader**      | Bridges byte streams to character streams.                                                                       |
| **LineNumberReader**       | A subclass of `BufferedReader` that keeps track of line numbers.                                                 |
| **ObjectInputStream**      | Deserializes objects from a stream.                                                                            |
| **ObjectOutputStream**     | Serializes objects to a stream.                                                                                  |
| **ObjectStreamClass**      | Encapsulates the metadata about a serializable class.                                                            |
| **ObjectStreamField**      | Represents a field in a serializable class.                                                                     |
| **ObjectStreamConstants**  | Defines constants used in object serialization.                                                                 |
| **OutputStream**           | Abstract class for writing byte streams.                                                                        |
| **OutputStreamWriter**     | Bridges byte streams to character streams.                                                                       |
| **PipedInputStream**       | Receives data from a piped output stream.                                                                        |
| **PipedOutputStream**      | Allows for writing data to a piped input stream.                                                                 |
| **PipedReader**            | Receives data from a piped writer.                                                                              |
| **PipedWriter**            | Allows for writing data to a piped reader.                                                                       |
| **PrintStream**            | Provides methods to write formatted representations of objects to text output streams.                         |
| **PrintWriter**            | Extends `Writer` to provide convenience methods for writing formatted text.                                      |
| **PushbackInputStream**    | Reads bytes from a stream and allows for pushing bytes back into the stream.                                    |
| **PushbackReader**         | Reads characters from a stream and allows pushing characters back into the stream.                              |
| **RandomAccessFile**       | Provides random access to a file by allowing movement to any part of the file.                                  |
| **Reader**                 | Abstract class for reading character streams.                                                                   |
| **SequenceInputStream**    | Concatenates multiple input streams into one.                                                                    |
| **SerializablePermission** | Represents the permission to serialize objects.                                                                  |
| **Serializable**           | Marks a class as serializable, so its instances can be serialized.                                               |
| **StreamTokenizer**        | Tokenizes input streams.                                                                                         |
| **StringReader**           | Reads characters from a string.                                                                                  |
| **StringWriter**           | Writes characters to a string.                                                                                   |
| **Writer**                 | Abstract class for writing character streams.                                                                    |

### **Java I/O Interfaces**

| **Interface**              | **Description**                                                                                                 |
|----------------------------|-----------------------------------------------------------------------------------------------------------------|
| **Closeable**              | Represents a resource that can be closed.                                                                       |
| **DataInput**              | Reads Java primitive data types from an input stream.                                                            |
| **DataOutput**             | Writes Java primitive data types to an output stream.                                                            |
| **Externalizable**         | Allows custom serialization of objects.                                                                         |
| **FileFilter**             | Filters files based on a specific criterion.                                                                     |
| **FilenameFilter**         | Filters file names based on a specific criterion.                                                                |
| **Flushable**              | Represents a resource that can be flushed.                                                                       |
| **ObjectInput**            | Reads Java objects from an input stream.                                                                         |
| **ObjectOutput**           | Writes Java objects to an output stream.                                                                         |
| **ObjectInputValidation**  | Provides a mechanism to validate objects after deserialization.                                                  |
| **ObjectStreamConstants**  | Defines constants used in object serialization.                                                                 |
| **Serializable**           | Marks a class as serializable, so its instances can be serialized.                                               |

### Deprecated Classes (Not for New Code)

| **Deprecated Class**       | **Reason for Deprecation**                                                                                       |
|----------------------------|-----------------------------------------------------------------------------------------------------------------|
| **LineNumberInputStream**  | Deprecated due to the introduction of more flexible and powerful APIs.                                          |
| **StringBufferInputStream**| Deprecated due to the introduction of more efficient character stream classes.                                  |

These tables provide a comprehensive overview of the Java I/O classes and interfaces, their descriptions, and key methods, reflecting the evolution of I/O handling from earlier Java versions to more recent enhancements.


# Input/Output: Exploring java.io

This chapter explores java.io, which provides support for I/O operations. In Chapter 13, we presented an overview of Java’s I/O system. Here, we will examine the Java I/O
system in greater detail.

As all programmers learn early on, most programs cannot accomplish their goals without accessing external data. Data is retrieved from an input source. The results of a program are
sent to an output destination. In Java, these sources or destinations are defined very broadly. For example, a network connection, memory buffer, or disk file can be manipulated by the
Java I/O classes. Although physically different, these devices are all handled by the same abstraction: the stream. A stream, as explained in Chapter 13, is a logical entity that either
produces or consumes information. A stream is linked to a physical device by the Java I/O system. All streams behave in the same manner, even if the actual physical devices they are
linked to differ.

NOTE In addition to the I/O capabilities discussed here, Java provides further I/O support in the java.nio package, which is described in Chapter 27.

## The Java I/O Classes and Interfaces
The I/O classes defined by java.io are listed here:

|                            |                              |                                    |
|----------------------------|------------------------------|------------------------------------|
|BufferedInputStream |FileWriter |PipedOutputStream|
|BufferedOutputStream| FilterInputStream| PipedReader|
|BufferedReader| FilterOutputStream| PipedWriter|
|BufferedWriter| FilterReader| PrintStream|
|ByteArrayInputStream| FilterWriter| PrintWriter|
|ByteArrayOutputStream| InputStream| PushbackInputStream|
|CharArrayReader| InputStreamReader| PushbackReader|
|CharArrayWriter| LineNumberReader| RandomAccessFile|
|Console| ObjectInputStream| Reader|
|DataInputStream |ObjectInputStream.GetField| SequenceInputStream|
|DataOutputStream |ObjectOutputStream |SerializablePermission|
|File |ObjectOutputStream.PutField |StreamTokenizer|
|FileDescriptor| ObjectStreamClass| StringReader|
|FileInputStream |ObjectStreamField| StringWriter|
|FileOutputStream |OutputStream |Writer|
|FilePermission |OutputStreamWriter||
|FileReader |PipedInputStream||

Console was added by Java SE 6.
The java.io package also contains two deprecated classes that are not shown in the preceding table: LineNumberInputStream and StringBufferInputStream. These classes
should not be used for new code.

The following interfaces are defined by java.io:
|                            |                              |                                    |
|----------------------------|------------------------------|------------------------------------|
|Closeable |FileFilter |ObjectInputValidation|
|DataInput |FilenameFilter |ObjectOutput|
|DataOutput |Flushable |ObjectStreamConstants|
|Externalizable |ObjectInput| Serializable|

As you can see, there are many classes and interfaces in the java.io package. These include byte and character streams, and object serialization (the storage and retrieval of objects). This chapter examines several of the most commonly used I/O components. The new Console class is also examined. We begin our discussion with one of the most distinctive I/O classes: File.
### File
Although most of the classes defined by java.io operate on streams, the File class does not. It deals directly with files and the file system. That is, the File class does not specify how information is retrieved from or stored in files; it describes the properties of a file itself. A File object is used to obtain or manipulate the information associated with a disk file, such as the permissions, time, date, and directory path, and to navigate subdirectory hierarchies.

Files are a primary source and destination for data within many programs. Although there are severe restrictions on their use within applets for security reasons, files are still a
central resource for storing persistent and shared information. A directory in Java is treated simply as a File with one additional property—a list of filenames that can be examined by
the list( ) method.

The following constructors can be used to create File objects:

- File(String directoryPath)
- File(String directoryPath, String filename)
- File(File dirObj, String filename)
- File(URI uriObj)

Here, directoryPath is the path name of the file, filename is the name of the file or subdirectory, dirObj is a File object that specifies a directory, and uriObj is a URI object that describes a file.

The following example creates three files: f1, f2, and f3. The first File object is constructed with a directory path as the only argument. The second includes two arguments—the path
and the filename. The third includes the file path assigned to f1 and a filename; f3 refers to the same file as f2.
```
File f1 = new File("/");
File f2 = new File("/","autoexec.bat");
File f3 = new File(f1,"autoexec.bat");
```
NOTE Java does the right thing with path separators between UNIX and Windows conventions.

If you use a forward slash (/) on a Windows version of Java, the path will still resolve correctly.
Remember, if you are using the Windows convention of a backslash character (\), you will need to use its escape sequence (\\) within a string.

File defines many methods that obtain the standard properties of a File object. For example, getName( ) returns the name of the file, getParent( ) returns the name of the parent directory, and exists( ) returns true if the file exists, false if it does not. The File class, however, is not symmetrical. By this, we mean that there are a few methods that allow you to examine the properties of a simple file object, but no corresponding function exists to change those attributes.

The following example demonstrates several of the File methods:
```java
// Demonstrate File.
import java.io.File;
class FileDemo {
static void p(String s) {
System.out.println(s);
}
public static void main(String args[]) {
File f1 = new File("/java/COPYRIGHT");
p("File Name: " + f1.getName());
p("Path: " + f1.getPath());
p("Abs Path: " + f1.getAbsolutePath());
p("Parent: " + f1.getParent());
p(f1.exists() ? "exists" : "does not exist");
p(f1.canWrite() ? "is writeable" : "is not writeable");
p(f1.canRead() ? "is readable" : "is not readable");
p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
p(f1.isFile() ? "is normal file" : "might be a named pipe");
p(f1.isAbsolute() ? "is absolute" : "is not absolute");
p("File last modified: " + f1.lastModified());
p("File size: " + f1.length() + " Bytes");
}
}
```
When you run this program, you will see something similar to the following:
```
File Name: COPYRIGHT
Path: /java/COPYRIGHT
Abs Path: /java/COPYRIGHT
Parent: /java
exists
is writeable
is readable
is not a directory
is normal file
is absolute
File last modified: 812465204000
File size: 695 Bytes
```
Most of the File methods are self-explanatory. isFile( ) and isAbsolute( ) are not. isFile( ) returns true if called on a file and false if called on a directory. Also, isFile( ) returns false for some special files, such as device drivers and named pipes, so this method can be used to make sure the file will behave as a file. The isAbsolute( ) method returns true if the file has an absolute path and false if its path is relative.

File also includes two useful utility methods. The first is renameTo( ), shown here:

boolean renameTo(File newName)

Here, the filename specified by newName becomes the new name of the invoking File object.
It will return true upon success and false if the file cannot be renamed (if you either attempt to rename a file so that it moves from one directory to another or use an existing filename, for example).
The second utility method is delete( ), which deletes the disk file represented by the path of the invoking File object. It is shown here:

boolean delete( )

You can also use delete( ) to delete a directory if the directory is empty. delete( ) returns true if it deletes the file and false if the file cannot be removed.
Here are some other File methods that you will find helpful.

| Method | Description |
|----------------------------------------|---------------------------------------------|
|void deleteOnExit( )| Removes the file associated with the invoking object when the Java Virtual Machine terminates.|
|long getFreeSpace( )| Returns the number of free bytes of storage available on the partition associated with the invoking object. (Added by Java SE 6.)|
|long getTotalSpace( )| Returns the storage capacity of the partition associated with the invoking object. (Added by Java SE 6.)|
|long getUsableSpace( )| Returns the number of usable free bytes of storage available on the partition associated with the invoking object. (Added by Java SE 6.)|
|boolean isHidden( ) |Returns true if the invoking file is hidden. Returns false otherwise.|
|boolean setLastModified(long millisec) |Sets the time stamp on the invoking file to that specified by millisec, which is the number of milliseconds from January 1, 1970, Coordinated Universal Time (UTC).|
|boolean setReadOnly( ) |Sets the invoking file to read-only.|

Methods also exist to mark files as readable, writable, and executable. Because File implements the Comparable interface, the method compareTo( ) is also supported.

### Directories
A directory is a File that contains a list of other files and directories. When you create a File object and it is a directory, the isDirectory( ) method will return true. In this case, you can call list( ) on that object to extract the list of other files and directories inside. It has two forms.

The first is shown here:

String[ ] list( )

The list of files is returned in an array of String objects.
The program shown here illustrates how to use list( ) to examine the contents of a directory:
```java
// Using directories.
import java.io.File;
class DirList {
public static void main(String args[]) {
String dirname = "/java";
File f1 = new File(dirname);
if (f1.isDirectory()) {
System.out.println("Directory of " + dirname);
String s[] = f1.list();
for (int i=0; i < s.length; i++) {
File f = new File(dirname + "/" + s[i]);
if (f.isDirectory()) {
System.out.println(s[i] + " is a directory");
} else {
System.out.println(s[i] + " is a file");
}
}
} else {
System.out.println(dirname + " is not a directory");
}
}
}
```
Here is sample output from the program. (Of course, the output you see will be different, based on what is in the directory.)
```
Directory of /java
bin is a directory
lib is a directory
demo is a directory
COPYRIGHT is a file
README is a file
index.html is a file
include is a directory
src.zip is a file
src is a directory
```
### Using FilenameFilter
You will often want to limit the number of files returned by the list( ) method to include only those files that match a certain filename pattern, or filter. To do this, you must use a
second form of list( ), shown here:

String[ ] list(FilenameFilter FFObj)

In this form, FFObj is an object of a class that implements the FilenameFilter interface.

FilenameFilter defines only a single method, accept( ), which is called once for each file in a list. Its general form is given here:

boolean accept(File directory, String filename)

The accept( ) method returns true for files in the directory specified by directory that should be included in the list (that is, those that match the filename argument), and returns false for those files that should be excluded.

The OnlyExt class, shown next, implements FilenameFilter. It will be used to modify the preceding program so that it restricts the visibility of the filenames returned by list( )
to files with names that end in the file extension specified when the object is constructed.

```java
import java.io.*;
public class OnlyExt implements FilenameFilter {
String ext;
public OnlyExt(String ext) {
this.ext = "." + ext;
}
public boolean accept(File dir, String name) {
return name.endsWith(ext);
}
}
The modified directory listing program is shown here. Now it will only display files that use
the .html extension.
// Directory of .HTML files.
import java.io.*;
class DirListOnly {
public static void main(String args[]) {
String dirname = "/java";
File f1 = new File(dirname);
FilenameFilter only = new OnlyExt("html");
String s[] = f1.list(only);
for (int i=0; i < s.length; i++) {
System.out.println(s[i]);
}
}
}
```
### The listFiles( ) Alternative
There is a variation to the list( ) method, called listFiles( ), which you might find useful.
The signatures for listFiles( ) are shown here:

- File[ ] listFiles( )
- File[ ] listFiles(FilenameFilter FFObj)
- File[ ] listFiles(FileFilter FObj)

These methods return the file list as an array of File objects instead of strings. The first method returns all files, and the second returns those files that satisfy the specified FilenameFilter.

Aside from returning an array of File objects, these two versions of listFiles( ) work like their equivalent list( ) methods.
The third version of listFiles( ) returns those files with path names that satisfy the specified FileFilter. FileFilter defines only a single method, accept( ), which is called once for each file in a list. Its general form is given here:

boolean accept(File path)

The accept( ) method returns true for files that should be included in the list (that is, those that match the path argument), and false for those that should be excluded.
### Creating Directories
Another two useful File utility methods are mkdir( ) and mkdirs( ). The mkdir( ) method creates a directory, returning true on success and false on failure. Failure indicates that the
path specified in the File object already exists, or that the directory cannot be created because the entire path does not exist yet. To create a directory for which no path exists, use the mkdirs( ) method. It creates both a directory and all the parents of the directory.

### The Closeable and Flushable Interfaces

Recently (with the release of JDK 5), two interfaces were added to java.io: Closeable and Flushable. The interfaces are implemented by several of the I/O classes. Their inclusion
does not add new functionality to the stream classes. They simply offer a uniform way of specifying that a stream can be closed or flushed.

Objects of a class that implements Closeable can be closed. It defines the close( ) method, shown here:

void close( ) throws IOException

This method closes the invoking stream, releasing any resources that it may hold. This interface is implemented by all of the I/O classes that open a stream that can be closed.
Objects of a class that implements Flushable can force buffered output to be written to the stream to which the object is attached. It defines the flush( ) method, shown here:

void flush( ) throws IOException

Flushing a stream typically causes buffered output to be physically written to the underlying device. This interface is implemented by all of the I/O classes that write to a stream.
## The Stream Classes 
Java’s stream-based I/O is built upon four abstract classes: InputStream, OutputStream, Reader, and Writer. These classes were briefly discussed in Chapter 13. They are used to
create several concrete stream subclasses. Although your programs perform their I/O operations through concrete subclasses, the top-level classes define the basic functionality
common to all stream classes.

InputStream and OutputStream are designed for byte streams. Reader and Writer are designed for character streams. The byte stream classes and the character stream classes
form separate hierarchies. In general, you should use the character stream classes when working with characters or strings, and use the byte stream classes when working with
bytes or other binary objects.

In the remainder of this chapter, both the byte- and character-oriented streams are examined.
## The Byte Streams
The byte stream classes provide a rich environment for handling byte-oriented I/O. A byte stream can be used with any type of object, including binary data. This versatility makes
byte streams important to many types of programs. Since the byte stream classes are topped by InputStream and OutputStream, our discussion will begin with them.
### InputStream
InputStream is an abstract class that defines Java’s model of streaming byte input. It implements the Closeable interface. Most of the methods in this class will throw an IOException on error conditions. (The exceptions are mark( ) and markSupported( ).) Table 19-1 shows the methods in InputStream.
### OutputStream
OutputStream is an abstract class that defines streaming byte output. It implements the Closeable and Flushable interfaces. Most of the methods in this class return void and throw
an IOException in the case of errors. (The exceptions are mark( ) and markSupported( ).)

Table 19-2 shows the methods in OutputStream.

NOTE Most of the methods described in Tables 19-1 and 19-2 are implemented by the subclasses of InputStream and OutputStream. The mark( ) and reset( ) methods are exceptions; notice their use or lack thereof by each subclass in the discussions that follow.

|Method |Description|
|------------|-------------------|
|int available( ) |Returns the number of bytes of input currently available for reading.|
|void close( ) |Closes the input source. Further read attempts will generate an IOException.|
|void mark(int numBytes) |Places a mark at the current point in the input stream that will remain valid until numBytes bytes are read.|
|boolean markSupported( ) |Returns true if mark( )/reset( ) are supported by the invoking stream.|
|int read( ) |Returns an integer representation of the next available byte of input. –1 is returned when the end of the file is encountered.|
|int read(byte buffer[ ]) |Attempts to read up to buffer.length bytes into buffer and returns the actual number of bytes that were successfully read. –1 is returned when the end of the file is encountered.|
|int read(byte buffer[ ], int offset, int numBytes) | Attempts to read up to numBytes bytes into buffer starting at buffer[offset], returning the number of bytes successfully read. –1 is returned when the end of the file is encountered.|
|void reset( ) |Resets the input pointer to the previously set mark.|
|long skip(long numBytes)| Ignores (that is, skips) numBytes bytes of input, returning the number of bytes actually ignored.|

TABLE 19-1 The Methods Defined by InputStream

|Method |Description|
|------------|-------------------|
|void close( ) |Closes the output stream. Further write attempts will generate an IOException.|
|void flush( ) |Finalizes the output state so that any buffers are cleared.That is, it flushes the output buffers.|
|void write(int b) |Writes a single byte to an output stream. Note that the parameter is an int, which allows you to call write( ) with expressions without having to cast them back to byte.|
|void write(byte buffer[ ]) Writes a complete array of bytes to an output stream.|
|void write(byte buffer[ ], int offset, int numBytes)| Writes a subrange of numBytes bytes from the array buffer, beginning at buffer[offset].|

TABLE 19-2 The Methods Defined by OutputStream

### FileInputStream
The FileInputStream class creates an InputStream that you can use to read bytes from a file.

Its two most common constructors are shown here:

- FileInputStream(String filepath)
- FileInputStream(File fileObj)

Either can throw a FileNotFoundException. Here, filepath is the full path name of a file, and fileObj is a File object that describes the file.

The following example creates two FileInputStreams that use the same disk file and each of the two constructors:
```
FileInputStream f0 = new FileInputStream("/autoexec.bat")
File f = new File("/autoexec.bat");
FileInputStream f1 = new FileInputStream(f);
```
Although the first constructor is probably more commonly used, the second allows us to closely examine the file using the File methods, before we attach it to an input stream. When
a FileInputStream is created, it is also opened for reading. FileInputStream overrides six of the methods in the abstract class InputStream. The mark( ) and reset( ) methods are not
overridden, and any attempt to use reset( ) on a FileInputStream will generate an IOException.

The next example shows how to read a single byte, an array of bytes, and a subrange array of bytes. It also illustrates how to use available( ) to determine the number of bytes
remaining, and how to use the skip( ) method to skip over unwanted bytes. The program reads its own source file, which must be in the current directory.
```java
// Demonstrate FileInputStream.
import java.io.*;
class FileInputStreamDemo {
public static void main(String args[]) throws IOException {
int size;
InputStream f =
new FileInputStream("FileInputStreamDemo.java");
System.out.println("Total Available Bytes: " +
(size = f.available()));
int n = size/40;
System.out.println("First " + n +
" bytes of the file one read() at a time");
for (int i=0; i < n; i++) {
System.out.print((char) f.read());
}
System.out.println("\nStill Available: " + f.available());
System.out.println("Reading the next " + n +
" with one read(b[])");
byte b[] = new byte[n];
if (f.read(b) != n) {
System.err.println("couldn't read " + n + " bytes.");
}
System.out.println(new String(b, 0, n));
System.out.println("\nStill Available: " + (size = f.available()));
System.out.println("Skipping half of remaining bytes with skip()");
Chapter 19: Input/Output: Exploring java.io 565
f.skip(size/2);
System.out.println("Still Available: " + f.available());
System.out.println("Reading " + n/2 + " into the end of array");
if (f.read(b, n/2, n/2) != n/2) {
System.err.println("couldn't read " + n/2 + " bytes.");
}
System.out.println(new String(b, 0, b.length));
System.out.println("\nStill Available: " + f.available());
f.close();
}
}
```
Here is the output produced by this program:
```
Total Available Bytes: 1433
First 35 bytes of the file one read() at a time
// Demonstrate FileInputStream.
im
Still Available: 1398
Reading the next 35 with one read(b[])
port java.io.*;
class FileInputS
Still Available: 1363
Skipping half of remaining bytes with skip()
Still Available: 682
Reading 17 into the end of array
port java.io.*;
read(b) != n) {
S
Still Available: 665
```
This somewhat contrived example demonstrates how to read three ways, to skip input, and to inspect the amount of data available on a stream.

NOTE The preceding example (and the other examples in this chapter) handle any I/O exceptions that might occur by throwing IOException out of main( ), which means that they are handled
by the JVM. This is fine for simple demonstration programs (and for small utility programs that you write for your own use), but commercial applications will normally need to handle I/O
exceptions within the program.

### FileOutputStream

FileOutputStream creates an OutputStream that you can use to write bytes to a file. Its most commonly used constructors are shown here:

- FileOutputStream(String filePath)
- FileOutputStream(File fileObj)
- FileOutputStream(String filePath, boolean append)
- FileOutputStream(File fileObj, boolean append)

They can throw a FileNotFoundException. Here, filePath is the full path name of a file, and fileObj is a File object that describes the file. If append is true, the file is opened in append mode.

Creation of a FileOutputStream is not dependent on the file already existing.

FileOutputStream will create the file before opening it for output when you create the object. In the case where you attempt to open a read-only file, an IOException will be
thrown.

The following example creates a sample buffer of bytes by first making a String and then using the getBytes( ) method to extract the byte array equivalent. It then creates three
files. The first, file1.txt, will contain every other byte from the sample. The second, file2.txt, will contain the entire set of bytes. The third and last, file3.txt, will contain only the last quarter.

```java
// Demonstrate FileOutputStream.
import java.io.*;
class FileOutputStreamDemo {
public static void main(String args[]) throws IOException {
String source = "Now is the time for all good men\n"
+ " to come to the aid of their country\n"
+ " and pay their due taxes.";
byte buf[] = source.getBytes();
OutputStream f0 = new FileOutputStream("file1.txt");
for (int i=0; i < buf.length; i += 2) {
f0.write(buf[i]);
}
f0.close();
OutputStream f1 = new FileOutputStream("file2.txt");
f1.write(buf);
f1.close();
OutputStream f2 = new FileOutputStream("file3.txt");
f2.write(buf,buf.length-buf.length/4,buf.length/4);
f2.close();
}
}
```
Here are the contents of each file after running this program. First, file1.txt:
```
Nwi h iefralgo e
t oet h i ftercuty n a hi u ae.
Next, file2.txt:
Now is the time for all good men
to come to the aid of their country
and pay their due taxes.
Finally, file3.txt:
nd pay their due taxes.
```

### ByteArrayInputStream

ByteArrayInputStream is an implementation of an input stream that uses a byte array as the source. This class has two constructors, each of which requires a byte array to provide the
data source:

- ByteArrayInputStream(byte array[ ])
- ByteArrayInputStream(byte array[ ], int start, int numBytes)

Here, array is the input source. The second constructor creates an InputStream from a subset of your byte array that begins with the character at the index specified by start and
is numBytes long.

The following example creates a pair of ByteArrayInputStreams, initializing them with the byte representation of the alphabet:

```java
// Demonstrate ByteArrayInputStream.
import java.io.*;
class ByteArrayInputStreamDemo {
public static void main(String args[]) throws IOException {
String tmp = "abcdefghijklmnopqrstuvwxyz";
byte b[] = tmp.getBytes();
ByteArrayInputStream input1 = new ByteArrayInputStream(b);
ByteArrayInputStream input2 = new ByteArrayInputStream(b,0,3);
}
}
```
The input1 object contains the entire lowercase alphabet, while input2 contains only the first three letters.

A ByteArrayInputStream implements both mark( ) and reset( ). However, if mark( ) has not been called, then reset( ) sets the stream pointer to the start of the stream—which in this
case is the start of the byte array passed to the constructor. The next example shows how to use the reset( ) method to read the same input twice. In this case, we read and print the letters “abc” once in lowercase and then again in uppercase.

```java
import java.io.*;
class ByteArrayInputStreamReset {
public static void main(String args[]) throws IOException {
String tmp = "abc";
byte b[] = tmp.getBytes();
ByteArrayInputStream in = new ByteArrayInputStream(b);
for (int i=0; i<2; i++) {
int c;
while ((c = in.read()) != -1) {
if (i == 0) {
System.out.print((char) c);
} else {
System.out.print(Character.toUpperCase((char) c));
}
}
System.out.println();
in.reset();
Chapter 19: Input/Output: Exploring java.io 567
}
}
}
```
This example first reads each character from the stream and prints it as-is, in lowercase.
It then resets the stream and begins reading again, this time converting each character to uppercase before printing. Here’s the output:

abc
ABC

### ByteArrayOutputStream

ByteArrayOutputStream is an implementation of an output stream that uses a byte array as the destination. ByteArrayOutputStream has two constructors, shown here:

- ByteArrayOutputStream( )
- ByteArrayOutputStream(int numBytes)

In the first form, a buffer of 32 bytes is created. In the second, a buffer is created with a size equal to that specified by numBytes. The buffer is held in the protected buf field
of ByteArrayOutputStream. The buffer size will be increased automatically, if needed.

The number of bytes held by the buffer is contained in the protected count field of ByteArrayOutputStream.

The following example demonstrates ByteArrayOutputStream:
```java
// Demonstrate ByteArrayOutputStream.
import java.io.*;
class ByteArrayOutputStreamDemo {
public static void main(String args[]) throws IOException {
ByteArrayOutputStream f = new ByteArrayOutputStream();
String s = "This should end up in the array";
byte buf[] = s.getBytes();
f.write(buf);
System.out.println("Buffer as a string");
System.out.println(f.toString());
System.out.println("Into array");
byte b[] = f.toByteArray();
for (int i=0; i<b.length; i++) {
System.out.print((char) b[i]);
}
System.out.println("\nTo an OutputStream()");
OutputStream f2 = new FileOutputStream("test.txt");
f.writeTo(f2);
f2.close();
System.out.println("Doing a reset");
f.reset();
for (int i=0; i<3; i++)
f.write('X');
System.out.println(f.toString());
}
}
```

When you run the program, you will create the following output. Notice how after the call to reset( ), the three X’s end up at the beginning.
Buffer as a string
This should end up in the array
Into array
This should end up in the array
To an OutputStream()
Doing a reset
XXX

This example uses the writeTo( ) convenience method to write the contents of f to test.txt.
Examining the contents of the test.txt file created in the preceding example shows the result we expected:

This should end up in the array

### Filtered Byte Streams

Filtered streams are simply wrappers around underlying input or output streams that transparently provide some extended level of functionality. These streams are typically
accessed by methods that are expecting a generic stream, which is a superclass of the filtered streams. Typical extensions are buffering, character translation, and raw data
translation. The filtered byte streams are FilterInputStream and FilterOutputStream. Their constructors are shown here:

- FilterOutputStream(OutputStream os)
- FilterInputStream(InputStream is)

The methods provided in these classes are identical to those in InputStream and OutputStream.

### Buffered Byte Streams

For the byte-oriented streams, a buffered stream extends a filtered stream class by attaching a memory buffer to the I/O streams. This buffer allows Java to do I/O operations on more
than a byte at a time, hence increasing performance. Because the buffer is available, skipping, marking, and resetting of the stream become possible. The buffered byte stream classes are BufferedInputStream and BufferedOutputStream. PushbackInputStream also implements a buffered stream.

### BufferedInputStream

Buffering I/O is a very common performance optimization. Java’s BufferedInputStream class allows you to “wrap” any InputStream into a buffered stream and achieve this performance
improvement.

BufferedInputStream has two constructors:

- BufferedInputStream(InputStream inputStream)
- BufferedInputStream(InputStream inputStream, int bufSize)

The first form creates a buffered stream using a default buffer size. In the second, the size of the buffer is passed in bufSize. Use of sizes that are multiples of a memory page, a disk 570 Part II: The Java Library block, and so on, can have a significant positive impact on performance. This is, however, implementation-dependent. An optimal buffer size is generally dependent on the host operating system, the amount of memory available, and how the machine is configured.

To make good use of buffering doesn’t necessarily require quite this degree of sophistication.

A good guess for a size is around 8,192 bytes, and attaching even a rather small buffer to an I/O stream is always a good idea. That way, the low-level system can read blocks of data
from the disk or network and store the results in your buffer. Thus, even if you are reading the data a byte at a time out of the InputStream, you will be manipulating fast memory
most of the time.

Buffering an input stream also provides the foundation required to support moving backward in the stream of the available buffer. Beyond the read( ) and skip( ) methods
implemented in any InputStream, BufferedInputStream also supports the mark( ) and reset( ) methods. This support is reflected by BufferedInputStream.markSupported( )
returning true.

The following example contrives a situation where we can use mark( ) to remember where we are in an input stream and later use reset( ) to get back there. This example is
parsing a stream for the HTML entity reference for the copyright symbol. Such a reference begins with an ampersand (&) and ends with a semicolon (;) without any intervening
whitespace. The sample input has two ampersands to show the case where the reset( ) happens and where it does not.
```java
// Use buffered input.
import java.io.*;
class BufferedInputStreamDemo {
public static void main(String args[]) throws IOException {
String s = "This is a &copy; copyright symbol " +
"but this is &copy not.\n";
byte buf[] = s.getBytes();
ByteArrayInputStream in = new ByteArrayInputStream(buf);
BufferedInputStream f = new BufferedInputStream(in);
int c;
boolean marked = false;
while ((c = f.read()) != -1) {
switch(c) {
case '&':
if (!marked) {
f.mark(32);
marked = true;
} else {
marked = false;
}
break;
case ';':
if (marked) {
marked = false;
System.out.print("(c)");
} else
System.out.print((char) c);
break;
Chapter 19: Input/Output: Exploring java.io 571
case ' ':
if (marked) {
marked = false;
f.reset();
System.out.print("&");
} else
System.out.print((char) c);
break;
default:
if (!marked)
System.out.print((char) c);
break;
}
}
}
}
```
Notice that this example uses mark(32), which preserves the mark for the next 32 bytes read (which is enough for all entity references). Here is the output produced by this program:
This is a (c) copyright symbol but this is &copy not.

### BufferedOutputStream

A BufferedOutputStream is similar to any OutputStream with the exception of an added flush( ) method that is used to ensure that data buffers are physically written to the actual
output device. Since the point of a BufferedOutputStream is to improve performance by reducing the number of times the system actually writes data, you may need to call flush( )
to cause any data that is in the buffer to be immediately written.

Unlike buffered input, buffering output does not provide additional functionality. 

Buffers for output in Java are there to increase performance. Here are the two available constructors:

- BufferedOutputStream(OutputStream outputStream)
- BufferedOutputStream(OutputStream outputStream, int bufSize)

The first form creates a buffered stream using the default buffer size. In the second form, the size of the buffer is passed in bufSize.

### PushbackInputStream

One of the novel uses of buffering is the implementation of pushback. Pushback is used on an input stream to allow a byte to be read and then returned (that is, “pushed back”) to the
stream. The PushbackInputStream class implements this idea. It provides a mechanism to “peek” at what is coming from an input stream without disrupting it.

PushbackInputStream has the following constructors:

- PushbackInputStream(InputStream inputStream)
- PushbackInputStream(InputStream inputStream, int numBytes)

The first form creates a stream object that allows one byte to be returned to the input stream. The second form creates a stream that has a pushback buffer that is numBytes long.
This allows multiple bytes to be returned to the input stream. 

Beyond the familiar methods of InputStream, PushbackInputStream provides unread( ), shown here:

- void unread(int ch)
- void unread(byte buffer[ ])
- void unread(byte buffer, int offset, int numChars)

The first form pushes back the low-order byte of ch. This will be the next byte returned by a subsequent call to read( ). The second form returns the bytes in buffer. The third form pushes back numChars bytes beginning at offset from buffer. An IOException will be thrown if there is an attempt to return a byte when the pushback buffer is full.

Here is an example that shows how a programming language parser might use a PushbackInputStream and unread( ) to deal with the difference between the = = operator for comparison and the = operator for assignment:
```java
// Demonstrate unread().
import java.io.*;
class PushbackInputStreamDemo {
public static void main(String args[]) throws IOException {
String s = "if (a == 4) a = 0;\n";
byte buf[] = s.getBytes();
ByteArrayInputStream in = new ByteArrayInputStream(buf);
PushbackInputStream f = new PushbackInputStream(in);
int c;
while ((c = f.read()) != -1) {
switch(c) {
case '=':
if ((c = f.read()) == '=')
System.out.print(".eq.");
else {
System.out.print("<-");
f.unread(c);
}
break;
default:
System.out.print((char) c);
break;
}
}
}
}
```
Here is the output for this example. Notice that = = was replaced by “.eq.” and = was replaced by “<–”.

if (a .eq. 4) a <- 0;

CAUTION PushbackInputStream has the side effect of invalidating the mark( ) or reset( ) methods of the InputStream used to create it. Use markSupported( ) to check any stream
on which you are going to use mark( )/reset( ).

### SequenceInputStream

The SequenceInputStream class allows you to concatenate multiple InputStreams. The construction of a SequenceInputStream is different from any other InputStream. A
SequenceInputStream constructor uses either a pair of InputStreams or an Enumeration of InputStreams as its argument:

- SequenceInputStream(InputStream first, InputStream second)
- SequenceInputStream(Enumeration <? extends InputStream> streamEnum)

Operationally, the class fulfills read requests from the first InputStream until it runs out and then switches over to the second one. In the case of an Enumeration, it will continue through all of the InputStreams until the end of the last one is reached.

Here is a simple example that uses a SequenceInputStream to output the contents of two files:

```java
// Demonstrate sequenced input.
import java.io.*;
import java.util.*;
class InputStreamEnumerator implements Enumeration<FileInputStream> {
private Enumeration<String> files;
public InputStreamEnumerator(Vector<String> files) {
this.files = files.elements();
}
public boolean hasMoreElements() {
return files.hasMoreElements();
}
public FileInputStream nextElement() {
try {
return new FileInputStream(files.nextElement().toString());
} catch (IOException e) {
return null;
}
}
}
class SequenceInputStreamDemo {
public static void main(String args[])
throws IOException {
int c;
Vector<String> files = new Vector<String>();
files.addElement("/autoexec.bat");
files.addElement("/config.sys");
InputStreamEnumerator e = new InputStreamEnumerator(files);
InputStream input = new SequenceInputStream(e);
while ((c = input.read()) != -1) {
System.out.print((char) c);
}
input.close();
}
}
```
This example creates a Vector and then adds two filenames to it. It passes that vector of names to the InputStreamEnumerator class, which is designed to provide a wrapper on the
vector where the elements returned are not the filenames but rather, open FileInputStreams on those names. The SequenceInputStream opens each file in turn, and this example prints
the contents of the two files.

### PrintStream

The PrintStream class provides all of the output capabilities we have been using from the System file handle, System.out, since the beginning of the book. This makes PrintStream
one of Java’s most often used classes. It implements the Appendable, Closeable, and Flushable interfaces.
PrintStream defines several constructors. The ones shown next have been specified from the start:

- PrintStream(OutputStream outputStream)
- PrintStream(OutputStream outputStream, boolean flushOnNewline)
- PrintStream(OutputStream outputStream, boolean flushOnNewline, String charSet)

Here, outputStream specifies an open OutputStream that will receive output. The flushOnNewline parameter controls whether the output buffer is automatically flushed every time a newline
(\n) character or a byte array is written, or when println( ) is called. If flushOnNewline is true, flushing automatically takes place. If it is false, flushing is not automatic. The first constructor does not automatically flush. You can specify a character encoding by passing its name in charSet.

The next set of constructors give you an easy way to construct a PrintStream that writes its output to a file.

- PrintStream(File outputFile) throws FileNotFoundException
- PrintStream(File outputFile, String charSet) throws FileNotFoundException, UnsupportedEncodingException
- PrintStream(String outputFileName) throws FileNotFoundException
- PrintStream(String outputFileName, String charSet) throws FileNotFoundException, UnsupportedEncodingException

These allow a PrintStream to be created from a File object or by specifying the name of a file. In either case, the file is automatically created. Any preexisting file by the same name is destroyed. Once created, the PrintStream object directs all output to the specified file. You can specify a character encoding by passing its name in charSet.

PrintStream supports the print( ) and println( ) methods for all types, including Object.

If an argument is not a primitive type, the PrintStream methods will call the object’s toString( ) method and then display the result.

Recently (with the release of JDK 5), the printf( ) method was added to PrintStream. It allows you to specify the precise format of the data to be written. The printf( ) method uses
the Formatter class (described in Chapter 18) to format data. It then writes this data to the invoking stream. Although formatting can be done manually, by using Formatter directly,
printf( ) streamlines the process. It also parallels the C/C++ printf( ) function, which makes it easy to convert existing C/C++ code into Java. Frankly, printf( ) is a much welcome addition to the Java API because it greatly simplifies the output of formatted data to the console.

The printf( ) method has the following general forms:

- PrintStream printf(String fmtString, Object ... args)
- PrintStream printf(Locale loc, String fmtString, Object ... args)

The first version writes args to standard output in the format specified by fmtString, using the default locale. The second lets you specify a locale. Both return the invoking PrintStream.

In general, printf( ) works in a manner similar to the format( ) method specified by Formatter. The fmtString consists of two types of items. The first type is composed of
characters that are simply copied to the output buffer. The second type contains format specifiers that define the way the subsequent arguments, specified by args, are displayed.

For complete information on formatting output, including a description of the format specifiers, see the Formatter class in Chapter 18.

Because System.out is a PrintStream, you can call printf( ) on System.out. Thus, printf( ) can be used in place of println( ) when writing to the console whenever formatted output
is desired. For example, the following program uses printf( ) to output numeric values in various formats. In the past, such formatting required a bit of work. With the addition of
printf( ), this now becomes an easy task.

```java
// Demonstrate printf().
class PrintfDemo {
public static void main(String args[]) {
System.out.println("Here are some numeric values " +
"in different formats.\n");
System.out.printf("Various integer formats: ");
System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
System.out.println();
System.out.printf("Default floating-point format: %f\n",
1234567.123);
System.out.printf("Floating-point with commas: %,f\n",
1234567.123);
System.out.printf("Negative floating-point default: %,f\n",
-1234567.123);
System.out.printf("Negative floating-point option: %,(f\n",
-1234567.123);
System.out.println();
System.out.printf("Line up positive and negative values:\n");
System.out.printf("% ,.2f\n% ,.2f\n",
1234567.123, -1234567.123);
}
}
```
The output is shown here:
Here are some numeric values in different formats.
Various integer formats: 3 (3) +3 00003
Default floating-point format: 1234567.123000
Floating-point with commas: 1,234,567.123000
Negative floating-point default: -1,234,567.123000
Negative floating-point option: (1,234,567.123000)

Line up positive and negative values:

1,234,567.12
-1,234,567.12

- PrintStream also defines the format( ) method. It has these general forms:
- PrintStream format(String fmtString, Object ... args)
- PrintStream format(Locale loc, String fmtString, Object ... args)

It works exactly like printf( ).

### DataOutputStream and DataInputStream

DataOutputStream and DataInputStream enable you to write or read primitive data to or from a stream. They implement the DataOutput and DataInput interfaces, respectively.
These interfaces define methods that convert primitive values to or from a sequence of bytes. These streams make it easy to store binary data, such as integers or floating-point
values, in a file. Each is examined here.

DataOutputStream extends FilterOutputStream, which extends OutputStream.

DataOutputStream defines the following constructor:

- DataOutputStream(OutputStream outputStream)

Here, outputStream specifies the output stream to which data will be written.
DataOutputStream supports all of the methods defined by it superclasses. However, it is the methods defined by the DataOutput interface, which it implements, that make it
interesting. DataOutput defines methods that convert values of a primitive type into a byte sequence and then writes it to the underlying stream. Here is a sampling of these methods:

- final void writeDouble(double value) throws IOException
- final void writeBoolean(boolean value) throws IOException
- final void writeInt(int value) throws IOException

Here, value is the value written to the stream.

DataInputStream is the complement of DataOuputStream. It extends FilterInputStream, which extends InputStream, and it implements the DataInput interface. Here is its only
constructor:

- DataInputStream(InputStream inputStream)

Here, inputStream specifies the input stream from which data will be read.
Like DataOutputStream, DataInputStream supports all of the methods of its superclasses, but it is the methods defined by the DataInput interface that make it unique. These methods
read a sequence of bytes and convert them into values of a primitive type. Here is a sampling of these methods:

- double readDouble( ) throws IOException
- boolean readBoolean( ) throws IOException
- int readInt( ) throws IOException

The following program demonstrates the use of DataOutputStream and DataInputStream:
```java
import java.io.*;
class DataIODemo {
public static void main(String args[])
throws IOException {
FileOutputStream fout = new FileOutputStream("Test.dat");
DataOutputStream out = new DataOutputStream(fout);
out.writeDouble(98.6);
out.writeInt(1000);
out.writeBoolean(true);
out.close();
FileInputStream fin = new FileInputStream("Test.dat");
DataInputStream in = new DataInputStream(fin);
double d = in.readDouble();
int i = in.readInt();
boolean b = in.readBoolean();
System.out.println("Here are the values: " +
d + " " + i + " " + b);
in.close();
}
}
```
The output is shown here:
Here are the values: 98.6 1000 true

### RandomAccessFile
RandomAccessFile encapsulates a random-access file. It is not derived from InputStream or OutputStream. Instead, it implements the interfaces DataInput and DataOutput, which
define the basic I/O methods. It also implements the Closeable interface. RandomAccessFile is special because it supports positioning requests—that is, you can position the file pointer
within the file. It has these two constructors:

- RandomAccessFile(File fileObj, String access) throws FileNotFoundException
- RandomAccessFile(String filename, String access) throws FileNotFoundException

In the first form, fileObj specifies the name of the file to open as a File object. In the second form, the name of the file is passed in filename. In both cases, access determines what type of file access is permitted. If it is “r”, then the file can be read, but not written. If it is “rw”, then the file is opened in read-write mode. If it is “rws”, the file is opened for read-write operations and every change to the file’s data or metadata will be immediately written to the physical device. If it is “rwd”, the file is opened for read-write operations and every change to the file’s data will be immediately written to the physical device.

The method seek( ), shown here, is used to set the current position of the file pointer within the file:

void seek(long newPos) throws IOException

Here, newPos specifies the new position, in bytes, of the file pointer from the beginning of the file. After a call to seek( ), the next read or write operation will occur at the new file position.

RandomAccessFile implements the standard input and output methods, which you can use to read and write to random access files. It also includes some additional methods. One
is setLength( ). It has this signature:

void setLength(long len) throws IOException

This method sets the length of the invoking file to that specified by len. This method can be used to lengthen or shorten a file. If the file is lengthened, the added portion is undefined.

## The Character Streams

While the byte stream classes provide sufficient functionality to handle any type of I/O operation, they cannot work directly with Unicode characters. Since one of the main purposes
of Java is to support the “write once, run anywhere” philosophy, it was necessary to include direct I/O support for characters. In this section, several of the character I/O classes are
discussed. As explained earlier, at the top of the character stream hierarchies are the Reader and Writer abstract classes. We will begin with them.
NOTE As discussed in Chapter 13, the character I/O classes were added by the 1.1 release of Java.
Because of this, you may still find legacy code that uses byte streams where character streams would be more appropriate. When working on such code, it is a good idea to update it.

### Reader

Reader is an abstract class that defines Java’s model of streaming character input. It implements the Closeable and Readable interfaces. All of the methods in this class
(except for markSupported( )) will throw an IOException on error conditions. Table 19-3 provides a synopsis of the methods in Reader.

### Writer
Writer is an abstract class that defines streaming character output. It implements the Closeable, Flushable, and Appendable interfaces. All of the methods in this class throw an IOException in the case of errors. Table 19-4 shows a synopsis of the methods in Writer.

### FileReader
The FileReader class creates a Reader that you can use to read the contents of a file. Its two most commonly used constructors are shown here:

- FileReader(String filePath)
- FileReader(File fileObj)

Either can throw a FileNotFoundException. Here, filePath is the full path name of a file, and fileObj is a File object that describes the file.
The following example shows how to read lines from a file and print these to the standard output stream. It reads its own source file, which must be in the current directory.
```java
// Demonstrate FileReader.
import java.io.*;
class FileReaderDemo {
public static void main(String args[]) throws IOException {
FileReader fr = new FileReader("FileReaderDemo.java");
BufferedReader br = new BufferedReader(fr);
String s;
while((s = br.readLine()) != null) {
System.out.println(s);
}
fr.close();
}
}
```
### FileWriter
FileWriter creates a Writer that you can use to write to a file. Its most commonly used constructors are shown here:

FileWriter(String filePath)
FileWriter(String filePath, boolean append)
FileWriter(File fileObj)
FileWriter(File fileObj, boolean append)

They can throw an IOException. Here, filePath is the full path name of a file, and fileObj is a File object that describes the file. If append is true, then output is appended to the end of the file.

|Method |Description|
|------------------------|-------------------------------|
|abstract void close( )| Closes the input source. Further read attempts will generate an IOException.|
|void mark(int numChars)| Places a mark at the current point in the input stream that will remain valid until numChars characters are read.|
|boolean markSupported( )| Returns true if mark( )/reset( ) are supported on this stream.|
|int read( ) |Returns an integer representation of the next available character from the invoking input stream. –1 is returned when the end of the file is encountered.|
|int read(char buffer[ ]) |Attempts to read up to buffer.length characters into buffer and returns the actual number of characters that were successfully read. –1 is returned when the end of the file is encountered.|
|abstract int read(char buffer[ ], int offset, int numChars)| Attempts to read up to numChars characters into buffer starting at buffer[offset], returning the number of characters successfully read. –1 is returned when the end of the file is encountered.|
|boolean ready( )| Returns true if the next input request will not wait. Otherwise, it returns false.|
|void reset( )| Resets the input pointer to the previously set mark.|
|long skip(long numChars) |Skips over numChars characters of input, returning the number of characters actually skipped.|

TABLE 19-3 The Methods Defined by Reader

|Method |Description|
|------------------------|-------------------------------|
|Writer append(char ch)| Appends ch to the end of the invoking output stream. Returns a reference to the invoking stream.|
|Writer append(CharSequence chars) |Appends chars to the end of the invoking output stream. Returns a reference to the invoking stream.|
|Writer append(CharSequence chars, int begin, int end)|Appends the subrange of chars specified by begin and end–1 to the end of the invoking ouput stream. Returns a reference to the invoking stream.|
|abstract void close( ) |Closes the output stream. Further write attempts will generate an IOException.|
|abstract void flush( ) |Finalizes the output state so that any buffers are cleared. That is, it flushes the output buffers.|
|void write(int ch) |Writes a single character to the invoking output stream. Note that the parameter is an int, which allows you to call write with expressions without having to cast them back to char.|

TABLE 19-4 The Methods Defined by Writer

Creation of a FileWriter is not dependent on the file already existing. FileWriter will create the file before opening it for output when you create the object. In the case where you
attempt to open a read-only file, an IOException will be thrown.

The following example is a character stream version of an example shown earlier when FileOutputStream was discussed. This version creates a sample buffer of characters by
first making a String and then using the getChars( ) method to extract the character array equivalent. It then creates three files. The first, file1.txt, will contain every other character from the sample. The second, file2.txt, will contain the entire set of characters. Finally, the third, file3.txt, will contain only the last quarter.

```java
// Demonstrate FileWriter.
import java.io.*;
class FileWriterDemo {
public static void main(String args[]) throws IOException {
String source = "Now is the time for all good men\n"
+ " to come to the aid of their country\n"
+ " and pay their due taxes.";
char buffer[] = new char[source.length()];
source.getChars(0, source.length(), buffer, 0);
FileWriter f0 = new FileWriter("file1.txt");
for (int i=0; i < buffer.length; i += 2) {
f0.write(buffer[i]);
}
f0.close();
FileWriter f1 = new FileWriter("file2.txt");
f1.write(buffer);
f1.close();
FileWriter f2 = new FileWriter("file3.txt");
f2.write(buffer,buffer.length-buffer.length/4,buffer.length/4);
f2.close();
}
}
```
|Method |Description|
|------------------------|-------------------------------|
|void write(char buffer[ ]) |Writes a complete array of characters to the invoking output stream.|
|abstract void write(char buffer[ ], int offset, int numChars)|Writes a subrange of numChars characters from the array buffer, beginning at buffer[offset] to the invoking output stream.
|void write(String str) Writes str to the invoking output stream.|
|void write(String str, int offset, int numChars)| Writes a subrange of numChars characters from the string str, beginning at the specified offset.|

TABLE 19-4 The Methods Defined by Writer (continued)

### CharArrayReader
CharArrayReader is an implementation of an input stream that uses a character array as the source. This class has two constructors, each of which requires a character array to provide
the data source:

- CharArrayReader(char array[ ])
- CharArrayReader(char array[ ], int start, int numChars)

Here, array is the input source. The second constructor creates a Reader from a subset of your character array that begins with the character at the index specified by start and is numChars long.

The following example uses a pair of CharArrayReaders:
```java
// Demonstrate CharArrayReader.
import java.io.*;
public class CharArrayReaderDemo {
public static void main(String args[]) throws IOException {
String tmp = "abcdefghijklmnopqrstuvwxyz";
int length = tmp.length();
char c[] = new char[length];
tmp.getChars(0, length, c, 0);
CharArrayReader input1 = new CharArrayReader(c);
CharArrayReader input2 = new CharArrayReader(c, 0, 5);
int i;
System.out.println("input1 is:");
while((i = input1.read()) != -1) {
System.out.print((char)i);
}
System.out.println();
System.out.println("input2 is:");
while((i = input2.read()) != -1) {
System.out.print((char)i);
}
System.out.println();
}
}
```
The input1 object is constructed using the entire lowercase alphabet, while input2 contains only the first five letters. 

Here is the output:

input1 is:

abcdefghijklmnopqrstuvwxyz

input2 is:

abcde

### CharArrayWriter

CharArrayWriter is an implementation of an output stream that uses an array as the destination.
CharArrayWriter has two constructors, shown here:

- CharArrayWriter( )
- CharArrayWriter(int numChars)

In the first form, a buffer with a default size is created. In the second, a buffer is created with a size equal to that specified by numChars. The buffer is held in the buf field of CharArrayWriter.

The buffer size will be increased automatically, if needed. The number of characters held by the buffer is contained in the count field of CharArrayWriter. Both buf and count are protected fields.

The following example demonstrates CharArrayWriter by reworking the sample program shown earlier for ByteArrayOutputStream. It produces the same output as the previous version.
```java
// Demonstrate CharArrayWriter.
import java.io.*;
class CharArrayWriterDemo {
public static void main(String args[]) throws IOException {
CharArrayWriter f = new CharArrayWriter();
String s = "This should end up in the array";
char buf[] = new char[s.length()];
s.getChars(0, s.length(), buf, 0);
f.write(buf);
System.out.println("Buffer as a string");
System.out.println(f.toString());
System.out.println("Into array");
char c[] = f.toCharArray();
for (int i=0; i<c.length; i++) {
System.out.print(c[i]);
}
System.out.println("\nTo a FileWriter()");
FileWriter f2 = new FileWriter("test.txt");
f.writeTo(f2);
f2.close();
System.out.println("Doing a reset");
f.reset();
for (int i=0; i<3; i++)
f.write('X');
System.out.println(f.toString());
}
}
```
### BufferedReader
BufferedReader improves performance by buffering input. It has two constructors:

- BufferedReader(Reader inputStream)
- BufferedReader(Reader inputStream, int bufSize)

The first form creates a buffered character stream using a default buffer size. In the second, the size of the buffer is passed in bufSize.

As is the case with the byte-oriented stream, buffering an input character stream also provides the foundation required to support moving backward in the stream within the
available buffer. To support this, BufferedReader implements the mark( ) and reset( ) methods, and BufferedReader.markSupported( ) returns true.

The following example reworks the BufferedInputStream example, shown earlier, so that it uses a BufferedReader character stream rather than a buffered byte stream. As before,
it uses mark( ) and reset( ) methods to parse a stream for the HTML entity reference for the copyright symbol. Such a reference begins with an ampersand (&) and ends with a semicolon
(;) without any intervening whitespace. The sample input has two ampersands, to show the case where the reset( ) happens and where it does not. Output is the same as that shown
earlier.

```java
// Use buffered input.
import java.io.*;
class BufferedReaderDemo {
public static void main(String args[]) throws IOException {
String s = "This is a &copy; copyright symbol " +
"but this is &copy not.\n";
char buf[] = new char[s.length()];
s.getChars(0, s.length(), buf, 0);
CharArrayReader in = new CharArrayReader(buf);
BufferedReader f = new BufferedReader(in);
int c;
boolean marked = false;
while ((c = f.read()) != -1) {
switch(c) {
case '&':
if (!marked) {
f.mark(32);
marked = true;
} else {
marked = false;
}
break;
case ';':
if (marked) {
marked = false;
System.out.print("(c)");
} else
System.out.print((char) c);
break;
case ' ':
if (marked) {
marked = false;
f.reset();
System.out.print("&");
} else
System.out.print((char) c);
break;
Chapter 19: Input/Output: Exploring java.io 585
default:
if (!marked)
System.out.print((char) c);
break;
}
}
}
}
```
### BufferedWriter
A BufferedWriter is a Writer that buffers ouput. Using a BufferedWriter can increase performance by reducing the number of times data is actually physically written to the
output stream.

A BufferedWriter has these two constructors:

- BufferedWriter(Writer outputStream)
- BufferedWriter(Writer outputStream, int bufSize)

The first form creates a buffered stream using a buffer with a default size. In the second, the size of the buffer is passed in bufSize.

### PushbackReader
The PushbackReader class allows one or more characters to be returned to the input stream.
This allows you to look ahead in the input stream. Here are its two constructors:

- PushbackReader(Reader inputStream)
- PushbackReader(Reader inputStream, int bufSize)

The first form creates a buffered stream that allows one character to be pushed back. In the second, the size of the pushback buffer is passed in bufSize.
PushbackReader provides unread( ), which returns one or more characters to the invoking input stream. It has the three forms shown here:

- void unread(int ch)
- void unread(char buffer[ ])
- void unread(char buffer[ ], int offset, int numChars)

The first form pushes back the character passed in ch. This will be the next character returned by a subsequent call to read( ). The second form returns the characters in buffer. The third form pushes back numChars characters beginning at offset from buffer. An IOException will be thrown if there is an attempt to return a character when the pushback buffer is full.
The following program reworks the earlier PushBackInputStream example by replacing PushBackInputStream with a PushbackReader. As before, it shows how a programming language parser can use a pushback stream to deal with the difference between the == operator for comparison and the = operator for assignment.

```java
// Demonstrate unread().
import java.io.*;
class PushbackReaderDemo {
public static void main(String args[]) throws IOException {
String s = "if (a == 4) a = 0;\n";

char buf[] = new char[s.length()];
s.getChars(0, s.length(), buf, 0);
CharArrayReader in = new CharArrayReader(buf);
PushbackReader f = new PushbackReader(in);
int c;
while ((c = f.read()) != -1) {
switch(c) {
case '=':
if ((c = f.read()) == '=')
System.out.print(".eq.");
else {
System.out.print("<-");
f.unread(c);
}
break;
default:
System.out.print((char) c);
break;
}
}
}
}
```
### PrintWriter
PrintWriter is essentially a character-oriented version of PrintStream. It implements the Appendable, Closeable, and Flushable interfaces. PrintWriter has several constructors.
The following have been supplied by PrintWriter from the start:

- PrintWriter(OutputStream outputStream)
- PrintWriter(OutputStream outputStream, boolean flushOnNewline)
- PrintWriter(Writer outputStream)
- PrintWriter(Writer outputStream, boolean flushOnNewline)

Here, outputStream specifies an open OutputStream that will receive output. The flushOnNewline parameter controls whether the output buffer is automatically flushed every time println( ), printf( ), or format( ) is called. If flushOnNewline is true, flushing automatically takes place. If false, flushing is not automatic. Constructors that do not specify the flushOnNewline parameter do not automatically flush.

The next set of constructors give you an easy way to construct a PrintWriter that writes its output to a file.

- PrintWriter(File outputFile) throws FileNotFoundException
- PrintWriter(File outputFile, String charSet) throws FileNotFoundException, UnsupportedEncodingException
- PrintWriter(String outputFileName) throws FileNotFoundException
- PrintWriter(String outputFileName, String charSet) throws FileNotFoundException, UnsupportedEncodingException

These allow a PrintWriter to be created from a File object or by specifying the name of a file.

In either case, the file is automatically created. Any preexisting file by the same name is destroyed. Once created, the PrintWriter object directs all output to the specified file. You
can specify a character encoding by passing its name in charSet.

PrintWriter supports the print( ) and println( ) methods for all types, including Object.

If an argument is not a primitive type, the PrintWriter methods will call the object’s toString( ) method and then output the result.

PrintWriter also supports the printf( ) method. It works the same way it does in the PrintStream class described earlier: it allows you to specify the precise format of the data.

Here is how printf( ) is declared in PrintWriter:

- PrintWriter printf(String fmtString, Object ... args)
- PrintWriter printf(Locale loc, String fmtString, Object ... args)

The first version writes args to standard output in the format specified by fmtString, using the default locale. The second lets you specify a locale. Both return the invoking PrintWriter.

The format( ) method is also supported. It has these general forms:

- PrintWriter format(String fmtString, Object ... args)
- PrintWriter format(Locale loc, String fmtString, Object ... args)

It works exactly like printf( ).

### The Console Class
Java SE 6 adds the Console class. It is used to read from and write to the console, if one exists.

It implements the Flushable interface. Console is primarily a convenience class because most of its functionality is available through System.in and System.out. However, its use can
simplify some types of console interactions, especially when reading strings from the console.

Console supplies no constructors. Instead, a Console object is obtained by calling System.console( ), which is shown here:

static Console console( )

If a console is available, then a reference to it is returned. Otherwise, null is returned. A console will not be available in all cases. Thus, if null is returned, no console I/O is possible.

Console defines the methods shown in Table 19-5. Notice that the input methods, such as readLine( ), throw IOError if an input error occurs. IOError is a new exception added by Java
SE 6, and it is a subclass of Error. It indicates an I/O failure that is beyond the control of your program. Thus, you will not normally catch an IOError. Frankly, if an IOError is thrown while accessing the console, it usually means that there has been a catastrophic system failure.

Also notice the readPassword( ) methods. These methods let your application read a password without echoing what is typed. When reading passwords, you should “zero-out”
both the array that holds the string entered by the user and the array that holds the password that the string is tested against. This reduces the chance that a malicious program will be able to obtain a password by scanning memory.

Here is an example that demonstrates the Console class:
```java
// Demonstrate Console.
import java.io.*;
class ConsoleDemo {
public static void main(String args[]) {
String str;
Console con;
// Obtain a reference to the console.
con = System.console();
```
|Method |Description|
|------------------------|-------------------------------|
|void flush( ) |Causes buffered output to be written physically to the console.|
|Console format(String fmtString, Object...args)|Writes args to the console using the format specified by fmtString.|
|Console printf(String fmtString, Object...args)|Writes args to the console using the format specified by fmtString.|
|Reader reader( ) |Returns a reference to a Reader connected to the console.|
|String readLine( ) |Reads and returns a string entered at the keyboard.Input stops when the user presses ENTER. If the end of the console input stream has been reached, null is returned. An IOError is thrown on failure.|
|String readLine(String fmtString,Object...args)|Displays a prompting string formatted as specified by fmtString and args, and then reads and returns a string entered at the keyboard. Input stops when the user presses ENTER. If the end of the console input stream has been reached, null is returned. An IOError is thrown on failure.|
|char[ ] readPassword( ) |Reads a string entered at the keyboard. Input stops when the user presses ENTER. The string is not displayed. If the end of the console input stream has been reached, null is returned. An IOError is thrown on failure.|
|char[ ] readPassword(String fmtString, Object... args)| Displays a prompting string formatted as specified by fmtString and args, and then reads a string entered at the keyboard. Input stops when the user presses ENTER. The string is not displayed. If the end of the console input stream has been reached, null is returned. An IOError is thrown on failure.|
|PrintWriter writer( )| Returns a reference to a Writer connected to the console.|

TABLE 19-5 The Methods Defined by Console

```java
// If no console available, exit.
if(con == null) return;
// Read a string and then display it.
str = con.readLine("Enter a string: ");
con.printf("Here is your string: %s\n", str);
}
}
```
Here is sample output:
Enter a string: This is a test.
Here is your string: This is a test.

### Using Stream I/O
The following example demonstrates several of Java’s I/O character stream classes and methods. This program implements the standard wc (word count) command. The program
has two modes: If no filenames are provided as arguments, the program operates on the standard input stream. If one or more filenames are specified, the program operates on
each of them.
```java
// A word counting utility.
import java.io.*;
class WordCount {
public static int words = 0;
public static int lines = 0;
public static int chars = 0;
public static void wc(InputStreamReader isr)
throws IOException {
int c = 0;
boolean lastWhite = true;
String whiteSpace = " \t\n\r";
while ((c = isr.read()) != -1) {
// Count characters
chars++;
// Count lines
if (c == '\n') {
lines++;
}
// Count words by detecting the start of a word
int index = whiteSpace.indexOf(c);
if(index == -1) {
if(lastWhite == true) {
++words;
}
lastWhite = false;
}
else {
lastWhite = true;

}
}
if(chars != 0) {
++lines;
}
}
public static void main(String args[]) {
FileReader fr;
try {
if (args.length == 0) { // We're working with stdin
wc(new InputStreamReader(System.in));
}
else { // We're working with a list of files
for (int i = 0; i < args.length; i++) {
fr = new FileReader(args[i]);
wc(fr);
}
}
}
catch (IOException e) {
return;
}
System.out.println(lines + " " + words + " " + chars);
}
}
```
The wc( ) method operates on any input stream and counts the number of characters, lines, and words. It tracks the parity of words and whitespace in the lastNotWhite variable.
When executed with no arguments, WordCount creates an InputStreamReader object using System.in as the source for the stream. This stream is then passed to wc( ), which does
the actual counting. When executed with one or more arguments, WordCount assumes that these are filenames and creates FileReaders for each of them, passing the resultant FileReader
objects to the wc( ) method. In either case, it prints the results before exiting. 

### Improving wc( ) Using a StreamTokenizer
An even better way to look for patterns in an input stream is to use another of Java’s I/O classes: StreamTokenizer. Similar to StringTokenizer from Chapter 18, StreamTokenizer
breaks up the input stream into tokens that are delimited by sets of characters. It has this constructor:

StreamTokenizer(Reader inStream)

Here, inStream must be some form of Reader.
StreamTokenizer defines several methods. In this example, we will use only a few. To reset the default set of delimiters, we will employ the resetSyntax( ) method. The default set
of delimiters is finely tuned for tokenizing Java programs and is thus too specialized for this example. We declare that our tokens, or “words,” are any consecutive string of visible characters delimited on both sides by whitespace.
We use the eolIsSignificant( ) method to ensure that newline characters will be delivered as tokens, so we can count the number of lines as well as words. It has this general form:

void eolIsSignificant(boolean eolFlag)

If eolFlag is true, the end-of-line characters are returned as tokens. If eolFlag is false, the endof-line characters are ignored.
The wordChars( ) method is used to specify the range of characters that can be used in
words. Its general form is shown here:

void wordChars(int start, int end)

Here, start and end specify the range of valid characters. In this program, characters in the range 33 to 255 are valid word characters.

The whitespace characters are specified using whitespaceChars( ). It has this general form:

void whitespaceChars(int start, int end)

Here, start and end specify the range of valid whitespace characters.

The next token is obtained from the input stream by calling nextToken( ). It returns the type of token.

StreamTokenizer defines four int constants: TT_EOF, TT_EOL, TT_NUMBER, and TT_WORD. There are three instance variables. nval is a public double used to hold the values of numbers as they are recognized. sval is a public String used to hold the value of any words as they are recognized. ttype is a public int indicating the type of token that has
just been read by the nextToken( ) method. If the token is a word, ttype equals TT_WORD.

If the token is a number, ttype equals TT_NUMBER. If the token is a single character, ttype contains its value. If an end-of-line condition has been encountered, ttype equals TT_EOL.
(This assumes that eolIsSignificant( ) was invoked with a true argument.) If the end of the stream has been encountered, ttype equals TT_EOF.

The word count program revised to use a StreamTokenizer is shown here:

```java
// Enhanced word count program that uses a StreamTokenizer
import java.io.*;
class WordCount {
public static int words=0;
public static int lines=0;
public static int chars=0;
public static void wc(Reader r) throws IOException {
StreamTokenizer tok = new StreamTokenizer(r);
tok.resetSyntax();
tok.wordChars(33, 255);
tok.whitespaceChars(0, ' ');
tok.eolIsSignificant(true);
while (tok.nextToken() != tok.TT_EOF) {
switch (tok.ttype) {
case StreamTokenizer.TT_EOL:
lines++;
chars++;
break;
case StreamTokenizer.TT_WORD:
words++;
Chapter 19: Input/Output: Exploring java.io 591
default: // FALLSTHROUGH
chars += tok.sval.length();
break;
}
}
}
public static void main(String args[]) {
if (args.length == 0) { // We're working with stdin
try {
wc(new InputStreamReader(System.in));
System.out.println(lines + " " + words + " " + chars);
} catch (IOException e) {};
} else { // We're working with a list of files
int twords = 0, tchars = 0, tlines = 0;
for (int i=0; i<args.length; i++) {
try {
words = chars = lines = 0;
wc(new FileReader(args[i]));
twords += words;
tchars += chars;
tlines += lines;
System.out.println(args[i] + ": " +
lines + " " + words + " " + chars);
} catch (IOException e) {
System.out.println(args[i] + ": error.");
}
}
System.out.println("total: " +
tlines + " " + twords + " " + tchars);
}
}
}
```
## Serialization
Serialization is the process of writing the state of an object to a byte stream. This is useful when you want to save the state of your program to a persistent storage area, such as a file.
At a later time, you may restore these objects by using the process of deserialization.
Serialization is also needed to implement Remote Method Invocation (RMI). RMI allows a Java object on one machine to invoke a method of a Java object on a different machine. An
object may be supplied as an argument to that remote method. The sending machine serializes the object and transmits it. The receiving machine deserializes it. (More information about
RMI appears in Chapter 27.)
Assume that an object to be serialized has references to other objects, which, in turn, have references to still more objects. This set of objects and the relationships among them
form a directed graph. There may also be circular references within this object graph. That is, object X may contain a reference to object Y, and object Y may contain a reference back to object X. Objects may also contain references to themselves. The object serialization and deserialization facilities have been designed to work correctly in these scenarios. If you
attempt to serialize an object at the top of an object graph, all of the other referenced objects are recursively located and serialized. Similarly, during the process of deserialization, all of these objects and their references are correctly restored.

An overview of the interfaces and classes that support serialization follows.

### Serializable
Only an object that implements the Serializable interface can be saved and restored by the serialization facilities. The Serializable interface defines no members. It is simply used to
indicate that a class may be serialized. If a class is serializable, all of its subclasses are also serializable.
Variables that are declared as transient are not saved by the serialization facilities. Also, static variables are not saved.
### Externalizable
The Java facilities for serialization and deserialization have been designed so that much of the work to save and restore the state of an object occurs automatically. However, there are cases in which the programmer may need to have control over these processes. For example, it may be desirable to use compression or encryption techniques. The Externalizable interface is designed for these situations.

The Externalizable interface defines these two methods:

- void readExternal(ObjectInput inStream) throws IOException, ClassNotFoundException
- void writeExternal(ObjectOutput outStream) throws IOException

In these methods, inStream is the byte stream from which the object is to be read, and outStream is the byte stream to which the object is to be written.

### ObjectOutput
The ObjectOutput interface extends the DataOutput interface and supports object serialization.
It defines the methods shown in Table 19-6. Note especially the writeObject( ) method. This is called to serialize an object. All of these methods will throw an IOException on error conditions.
### ObjectOutputStream
The ObjectOutputStream class extends the OutputStream class and implements the ObjectOutput interface. It is responsible for writing objects to a stream. A constructor of
this class is

ObjectOutputStream(OutputStream outStream) throws IOException

The argument outStream is the output stream to which serialized objects will be written.
Several commonly used methods in this class are shown in Table 19-7. They will throw an IOException on error conditions. There is also an inner class to ObjectOuputStream
called PutField. It facilitates the writing of persistent fields, and its use is beyond the scope of this book.


|Method |Description|
|------------|-------------------|
|void close( ) |Closes the invoking stream. Further write attempts will generate an IOException.|
|void flush( ) |Finalizes the output state so that any buffers are cleared. That is, it flushes the output buffers.|
|void write(byte buffer[ ])| Writes an array of bytes to the invoking stream.|
|void write(byte buffer[ ], int offset, int numBytes)| Writes a subrange of numBytes bytes from the array buffer,
beginning at buffer[offset].|
|void write(int b)| Writes a single byte to the invoking stream. The byte written is the low-order byte of b.|
|void writeObject(Object obj)| Writes object obj to the invoking stream.|

TABLE 19-6 The Methods Defined by ObjectOutput

|Method |Description|
|------------|-------------------|
|void close( ) |Closes the invoking stream. Further write attempts will generate an IOException.|
|void flush( ) |Finalizes the output state so that any buffers are cleared. That is, it flushes the output buffers.|
|void write(byte buffer[ ]) |Writes an array of bytes to the invoking stream.|
|void write(byte buffer[ ], int offset, int numBytes) |Writes a subrange of numBytes bytes from the array buffer, beginning at buffer[offset].|
|void write(int b) |Writes a single byte to the invoking stream. The byte written is the low-order byte of b.|
|void writeBoolean(boolean b) |Writes a boolean to the invoking stream.|
|void writeByte(int b) |Writes a byte to the invoking stream. The byte written is the low-order byte of b.|
|void writeBytes(String str) |Writes the bytes representing str to the invoking stream.|
|void writeChar(int c) |Writes a char to the invoking stream.|
|void writeChars(String str) |Writes the characters in str to the invoking stream.|
|void writeDouble(double d)| Writes a double to the invoking stream.|
|void writeFloat(float f )| Writes a float to the invoking stream.|
|void writeInt(int i) |Writes an int to the invoking stream.|
|void writeLong(long l) |Writes a long to the invoking stream.|
|final void writeObject(Object obj) |Writes obj to the invoking stream.|
|void writeShort(int i)| Writes a short to the invoking stream.|

TABLE 19-7 Commonly Used Methods Defined by ObjectOutputStream

### ObjectInput
The ObjectInput interface extends the DataInput interface and defines the methods shown in Table 19-8. It supports object serialization. Note especially the readObject( ) method. This
is called to deserialize an object. All of these methods will throw an IOException on error conditions. The readObject( ) method can also throw ClassNotFoundException.
### ObjectInputStream
The ObjectInputStream class extends the InputStream class and implements the ObjectInput interface. ObjectInputStream is responsible for reading objects from a stream. A constructor of
this class is 

ObjectInputStream(InputStream inStream) throws IOException

The argument inStream is the input stream from which serialized objects should be read.

Several commonly used methods in this class are shown in Table 19-9. They will throw an IOException on error conditions. The readObject( ) method can also throw
ClassNotFoundException. There is also an inner class to ObjectInputStream called GetField.
It facilitates the reading of persistent fields, and its use is beyond the scope of this book.

### A Serialization Example

The following program illustrates how to use object serialization and deserialization. It begins
by instantiating an object of class MyClass. This object has three instance variables that are of
types String, int, and double. This is the information we want to save and restore.

|Method |Description|
|------------|-------------------|
|int available( )| Returns the number of bytes that are now available in the input buffer.|
|void close( ) |Closes the invoking stream. Further read attempts will generate an IOException.|
|int read( )| Returns an integer representation of the next available byte of input. –1 is returned when the end of the file is encountered.|
|int read(byte buffer[ ])| Attempts to read up to buffer.length bytes into buffer, returning the number of bytes that were successfully read. –1 is returned when the end of the file is encountered.|
|int read(byte buffer[ ], int offset, int numBytes) |Attempts to read up to numBytes bytes into buffer starting at buffer[offset], returning the number of bytes that were successfully read. –1 is returned when the end of the file is encountered.|
|Object readObject( )| Reads an object from the invoking stream.|
|long skip(long numBytes) Ignores (that is, skips)| numBytes bytes in the invoking stream, returning the number of bytes actually ignored.|

TABLE 19-8 The Methods Defined by ObjectInput

A FileOutputStream is created that refers to a file named “serial,” and an ObjectOutputStream is created for that file stream. The writeObject( ) method of ObjectOutputStream is then used to serialize our object. The object output stream is flushed and closed.

A FileInputStream is then created that refers to the file named “serial,” and an ObjectInputStream is created for that file stream. The readObject( ) method of ObjectInputStream is then used to deserialize our object. The object input stream is then closed.

Note that MyClass is defined to implement the Serializable interface. If this is not done, a NotSerializableException is thrown. Try experimenting with this program by

|Method |Description|
|------------|-------------------|
|int available( ) |Returns the number of bytes that are now available in the input buffer.|
|void close( ) |Closes the invoking stream. Further read attempts will generate an IOException.|
|int read( ) |Returns an integer representation of the next available byte of input. –1 is returned when the end of the file is encountered.|
|int read(byte buffer[ ], int offset,int numBytes) |Attempts to read up to numBytes bytes into buffer starting at buffer[offset], returning the number of bytes successfully read. –1 is returned when the end of the file is encountered.|
|boolean readBoolean( ) |Reads and returns a boolean from the invoking stream.|
|byte readByte( ) |Reads and returns a byte from the invoking stream.|
|char readChar( )| Reads and returns a char from the invoking stream.|
|double readDouble( )| Reads and returns a double from the invoking stream.|
|float readFloat( )| Reads and returns a float from the invoking stream.|
|void readFully(byte buffer[ ]) |Reads buffer.length bytes into buffer. Returns only when all bytes have been read.|
|void readFully(byte buffer[ ],int offset, int numBytes) |Reads numBytes bytes into buffer starting at buffer[offset]. Returns only when numBytes have been read.|
|int readInt( ) |Reads and returns an int from the invoking stream.|
|long readLong( ) |Reads and returns a long from the invoking stream.|
|final Object readObject( ) |Reads and returns an object from the invoking stream.v
|short readShort( )| Reads and returns a short from the invoking stream.|
|int readUnsignedByte( )| Reads and returns an unsigned byte from the invoking stream.|
|int readUnsignedShort( )| Reads and returns an unsigned short from the invoking stream.|

TABLE 19-9 Commonly Used Methods Defined by ObjectInputStream declaring some of the MyClass instance variables to be transient. That data is then not saved during serialization.

```java
import java.io.*;
public class SerializationDemo {
public static void main(String args[]) {
// Object serialization
try {
MyClass object1 = new MyClass("Hello", -7, 2.7e10);
System.out.println("object1: " + object1);
FileOutputStream fos = new FileOutputStream("serial");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(object1);
oos.flush();
oos.close();
}
catch(IOException e) {
System.out.println("Exception during serialization: " + e);
System.exit(0);
}
// Object deserialization
try {
MyClass object2;
FileInputStream fis = new FileInputStream("serial");
ObjectInputStream ois = new ObjectInputStream(fis);
object2 = (MyClass)ois.readObject();
ois.close();
System.out.println("object2: " + object2);
}
catch(Exception e) {
System.out.println("Exception during deserialization: " + e);
System.exit(0);
}
}
}
class MyClass implements Serializable {
String s;
int i;
double d;
public MyClass(String s, int i, double d) {
this.s = s;
this.i = i;
this.d = d;
}
public String toString() {
return "s=" + s + "; i=" + i + "; d=" + d;
}
}
```

This program demonstrates that the instance variables of object1 and object2 are identical.

The output is shown here:
```
object1: s=Hello; i=-7; d=2.7E10
object2: s=Hello; i=-7; d=2.7E10
```
## Stream Benefits

The streaming interface to I/O in Java provides a clean abstraction for a complex and often cumbersome task. The composition of the filtered stream classes allows you to dynamically
build the custom streaming interface to suit your data transfer requirements. Java programs written to adhere to the abstract, high-level InputStream, OutputStream, Reader, and
Writer classes will function properly in the future even when new and improved concrete stream classes are invented. As you will see in the next chapter, this model works very well
when we switch from a file system–based set of streams to the network and socket streams. Finally, serialization of objects plays an important role in many types of Java programs.
Java’s serialization I/O classes provide a portable solution to this sometimes tricky task.

### Java I/O Classes and Interfaces

#### **Classes**

| **Class**                  | **Description**                                                                                                 | **Key Methods**                                                                                                      | **Example Code**                                                                                                         |
|----------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **`BufferedInputStream`**  | Reads bytes from a file with buffering to improve performance.                                                  | `read()`, `read(byte[] b)`, `close()`                                                                                 | ```java<br>BufferedInputStream bis = new BufferedInputStream(new FileInputStream("example.txt"));<br>int b;<br>while ((b = bis.read()) != -1) { System.out.print((char) b); }<br>bis.close();``` |
| **`BufferedOutputStream`** | Writes bytes to a file with buffering to improve performance.                                                   | `write(int b)`, `write(byte[] b)`, `close()`                                                                          | ```java<br>BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("example.txt"));<br>bos.write("Hello, BufferedOutputStream!".getBytes());<br>bos.close();``` |
| **`FileWriter`**           | Writes characters to a file.                                                                                     | `write(int c)`, `write(char[] cbuf)`, `close()`                                                                       | ```java<br>FileWriter fw = new FileWriter("example.txt");<br>fw.write("Hello, FileWriter!");<br>fw.close();``` |
| **`PipedOutputStream`**    | Allows for the writing of data to a piped input stream.                                                         | `write(int b)`, `write(byte[] b)`, `flush()`, `close()`                                                               | ```java<br>PipedOutputStream pos = new PipedOutputStream();<br>pos.write("Hello, PipedOutputStream!".getBytes());<br>pos.close();``` |
| **`BufferedReader`**       | Reads text from a file with buffering to improve efficiency.                                                    | `read()`, `readLine()`, `close()`                                                                                      | ```java<br>BufferedReader br = new BufferedReader(new FileReader("example.txt"));<br>String line;<br>while ((line = br.readLine()) != null) { System.out.println(line); }<br>br.close();``` |
| **`BufferedWriter`**       | Writes text to a file with buffering to improve efficiency.                                                     | `write(int c)`, `write(char[] cbuf)`, `write(String str)`, `close()`                                                  | ```java<br>BufferedWriter bw = new BufferedWriter(new FileWriter("example.txt"));<br>bw.write("Hello, BufferedWriter!");<br>bw.close();``` |
| **`PrintStream`**          | Provides methods to write formatted representations of objects to text output streams.                         | `print()`, `println()`, `printf()`, `close()`                                                                         | ```java<br>PrintStream ps = new PrintStream(new FileOutputStream("example.txt"));<br>ps.println("Hello, PrintStream!");<br>ps.close();``` |
| **`ByteArrayInputStream`** | Reads bytes from a byte array.                                                                                   | `read()`, `read(byte[] b)`, `close()`                                                                                 | ```java<br>ByteArrayInputStream bais = new ByteArrayInputStream("Hello, ByteArrayInputStream!".getBytes());<br>int b;<br>while ((b = bais.read()) != -1) { System.out.print((char) b); }<br>bais.close();``` |
| **`ByteArrayOutputStream`**| Writes bytes to a byte array, which can be retrieved later.                                                       | `write(int b)`, `toByteArray()`, `close()`                                                                            | ```java<br>ByteArrayOutputStream baos = new ByteArrayOutputStream();<br>baos.write("Hello, ByteArrayOutputStream!".getBytes());<br>System.out.println(new String(baos.toByteArray()));<br>baos.close();``` |
| **`CharArrayReader`**      | Reads characters from a character array.                                                                        | `read()`, `read(char[] cbuf)`, `close()`                                                                             | ```java<br>CharArrayReader car = new CharArrayReader("Hello, CharArrayReader!".toCharArray());<br>int c;<br>while ((c = car.read()) != -1) { System.out.print((char) c); }<br>car.close();``` |
| **`CharArrayWriter`**      | Writes characters to a character array, which can be retrieved later.                                             | `write(int c)`, `toCharArray()`, `close()`                                                                            | ```java<br>CharArrayWriter caw = new CharArrayWriter();<br>caw.write("Hello, CharArrayWriter!");<br>System.out.println(caw.toCharArray());<br>caw.close();``` |
| **`File`**                | Represents a file or directory path in the filesystem.                                                           | `createNewFile()`, `delete()`, `exists()`, `length()`, `lastModified()`, `renameTo(File dest)`                       | ```java<br>File file = new File("example.txt");<br>if (file.createNewFile()) { System.out.println("File created"); }``` |
| **`FileDescriptor`**       | Represents an open file descriptor.                                                                            | `sync()`                                                                                                           | ```java<br>FileDescriptor fd = new FileOutputStream("example.txt").getFD();<br>fd.sync();``` |
| **`FileInputStream`**      | Reads bytes from a file.                                                                                         | `read()`, `read(byte[] b)`, `close()`                                                                                 | ```java<br>FileInputStream fis = new FileInputStream("example.txt");<br>int b;<br>while ((b = fis.read()) != -1) { System.out.print((char) b); }<br>fis.close();``` |
| **`FileOutputStream`**     | Writes bytes to a file.                                                                                        | `write(int b)`, `write(byte[] b)`, `close()`                                                                         | ```java<br>FileOutputStream fos = new FileOutputStream("example.txt");<br>fos.write("Hello, FileOutputStream!".getBytes());<br>fos.close();``` |
| **`FileReader`**          | Reads characters from a file.                                                                                     | `read()`, `read(char[] cbuf)`, `close()`                                                                             | ```java<br>FileReader fr = new FileReader("example.txt");<br>int c;<br>while ((c = fr.read()) != -1) { System.out.print((char) c); }<br>fr.close();``` |
| **`FileWriter`**          | Writes characters to a file.                                                                                      | `write(int c)`, `write(char[] cbuf)`, `close()`                                                                       | ```java<br>FileWriter fw = new FileWriter("example.txt");<br>fw.write("Hello, FileWriter!");<br>fw.close();``` |
| **`PipedInputStream`**    | Receives data from a piped output stream.                                                                         | `read()`, `read(byte[] b)`, `close()`                                                                                 | ```java<br>PipedInputStream pis = new PipedInputStream();<br>PipedOutputStream pos = new PipedOutputStream(pis);<br>new Thread(() -> { try { pos.write("Hello, PipedInputStream!".getBytes()); pos.close(); } catch (IOException e) { e.printStackTrace(); } }).start();<br>int b;<br>while ((b = pis.read()) != -1) { System.out.print((char) b); }<br>pis.close();``` |
| **`PipedOutputStream`**    | Allows for writing data to a piped input stream.                                                                  | `write(int b)`, `write(byte[] b)`, `flush()`, `close()`                                                               | ```java<br>PipedOutputStream pos = new PipedOutputStream();<br>pos.write("Hello, PipedOutputStream!".getBytes());<br>pos.close();``` |
| **`PrintStream`**          | Provides methods to write formatted text and objects to an output stream.                                       | `print()`, `println()`, `printf()`, `close()`                                                                         | ```java<br>PrintStream ps = new PrintStream(new FileOutputStream("example.txt"));<br>ps.println("Hello, PrintStream!");<br>ps.close();``` |
| **`PrintWriter`**         | Extends `Writer` to provide convenience methods for writing formatted text.                                      | `print()`, `println()`, `printf()`, `close()`                                                                         | ```java<br>PrintWriter pw = new PrintWriter(new FileWriter("example.txt"));<br>pw.println("Hello, PrintWriter!");<br>pw.close();``` |
| **`PushbackInputStream`**  | Reads bytes from a stream and allows for pushing bytes back into the stream.                                    | `read()`, `unread(int b)`, `close()`                                                                                | ```java<br>PushbackInputStream pbis = new PushbackInputStream(new FileInputStream("example.txt"));<br>int b;<br>while ((b = pbis.read()) != -1) { System.out.print((char) b); }<br>pbis.close();``` |
| **`PushbackReader`**       | Reads characters from a stream and allows pushing characters back into the stream.                              | `read()`, `unread(int c)`, `close()`                                                                                | ```java<br>PushbackReader pbr = new PushbackReader(new FileReader("example.txt"));<br>int c;<br>while ((c = pbr.read()) != -1) { System.out.print((char) c); }<br>pbr.close();``` |
| **`RandomAccessFile`**     | Provides random access to a file by allowing movement to any part of the file.                                  | `seek(long pos)`, `read()`, `write()`, `close()`                                                                     | ```java<br>RandomAccessFile raf = new RandomAccessFile("example.txt", "rw");<br>raf.seek(10);<br>raf.write("Hello".getBytes());<br>raf.close();``` |
| **`Console`**              | Provides access to the system console for reading input and writing output.                                     | `readLine()`, `readPassword()`, `printf()`                                                                            | ```java<br>Console console = System.console();<br>String userInput = console.readLine("Enter something: ");<br>console.printf("You entered: %s%n", userInput);``` |
| **`ObjectInputStream`**    | Deserializes objects from a stream.                                                                            | `readObject()`, `close()`                                                                                             | ```java<br>ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.obj"));<br>MyObject obj = (MyObject) ois.readObject();<br>ois.close();``` |
| **`ObjectOutputStream`**   | Serializes objects to a stream.                                                                              | `writeObject(Object obj)`, `close()`                                                                                   | ```java<br>ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example.obj"));<br>oos.writeObject(new MyObject());<br>oos.close();``` |
| **`DataInputStream`**      | Reads Java primitive data types from a binary stream.                                                          | `readInt()`, `readDouble()`, `readBoolean()`, `close()`                                                               | ```java<br>DataInputStream dis = new DataInputStream(new FileInputStream("example.dat"));<br>int value = dis.readInt();<br>dis.close();``` |
| **`DataOutputStream`**     | Writes Java primitive data types to a binary stream.                                                            | `writeInt(int v)`, `writeDouble(double v)`, `writeBoolean(boolean v)`, `close()`                                      | ```java<br>DataOutputStream dos = new DataOutputStream(new FileOutputStream("example.dat"));<br>dos.writeInt(123);<br>dos.close();``` |

#### **Interfaces**

| **Interface**              | **Description**                                                                                                 | **Key Methods**                                                                                                      | **Example Code**                                                                                                         |
|----------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **`Closeable`**            | Represents a resource that can be closed.                                                                       | `close()`                                                                                                           | ```java<br>try (FileInputStream fis = new FileInputStream("example.txt")) { /* use fis */ }<br>catch (IOException e) { e.printStackTrace(); }``` |
| **`DataInput`**            | Reads Java primitive data types from an input stream.                                                            | `readBoolean()`, `readByte()`, `readChar()`, `readInt()`, `readDouble()`, etc.                                      | ```java<br>DataInputStream dis = new DataInputStream(new FileInputStream("example.dat"));<br>int value = dis.readInt();<br>dis.close();``` |
| **`DataOutput`**           | Writes Java primitive data types to an output stream.                                                             | `writeBoolean(boolean v)`, `writeByte(int v)`, `writeChar(int v)`, `writeInt(int v)`, `writeDouble(double v)`, etc. | ```java<br>DataOutputStream dos = new DataOutputStream(new FileOutputStream("example.dat"));<br>dos.writeInt(123);<br>dos.close();``` |
| **`Externalizable`**       | Allows custom serialization of objects.                                                                         | `writeExternal(ObjectOutput out)`, `readExternal(ObjectInput in)`                                                     | ```java<br>public class MyObject implements Externalizable { public void writeExternal(ObjectOutput out) { /* custom serialization */ }<br> public void readExternal(ObjectInput in) { /* custom deserialization */ }<br>} ``` |
| **`FileFilter`**           | Filters files based on a specific criterion.                                                                     | `accept(File file)`                                                                                                 | ```java<br>File dir = new File("directory");<br>FileFilter filter = file -> file.isFile() && file.getName().endsWith(".txt");<br>File[] files = dir.listFiles(filter);``` |
| **`FilenameFilter`**       | Filters file names based on a specific criterion.                                                                | `accept(File dir, String name)`                                                                                    | ```java<br>File dir = new File("directory");<br>FilenameFilter filter = (dir1, name) -> name.endsWith(".txt");<br>File[] files = dir.listFiles(filter);``` |
| **`Flushable`**            | Represents a resource that can be flushed.                                                                       | `flush()`                                                                                                           | ```java<br>BufferedWriter bw = new BufferedWriter(new FileWriter("example.txt"));<br>bw.write("Hello");<br>bw.flush();<br>bw.close();``` |
| **`ObjectInput`**          | Reads Java objects from an input stream.                                                                         | `readObject()`                                                                                                      | ```java<br>ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.obj"));<br>MyObject obj = (MyObject) ois.readObject();<br>ois.close();``` |
| **`ObjectOutput`**         | Writes Java objects to an output stream.                                                                         | `writeObject(Object obj)`                                                                                             | ```java<br>ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example.obj"));<br>oos.writeObject(new MyObject());<br>oos.close();``` |
| **`Serializable`**         | Marks a class as serializable, so its instances can be serialized.                                               | (No methods)                                                                                                        | ```java<br>public class MyObject implements Serializable { private static final long serialVersionUID = 1L; }``` |
| **`ObjectInputValidation`**| Provides a mechanism to validate objects after deserialization.                                                  | `validateObject()`                                                                                                  | ```java<br>ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.obj"));<br>ois.registerValidation(new ObjectInputValidation() { public void validateObject() throws InvalidObjectException { /* validation code */ } }, 0);<br>MyObject obj = (MyObject) ois.readObject();<br>ois.close();``` |
| **`ObjectStreamConstants`**| Defines constants used in object serialization.                                                                 | (Constants)                                                                                                        | ```java<br>int serialVersionUID = ObjectStreamConstants.STREAM_MAGIC;``` |

### Summary

- **Java 7 I/O Classes**: The `java.io` package provides classes for handling various types of I/O operations, including byte and character streams, and object serialization.
- **Java 8 Enhancements**: Java 8 introduced new APIs in `java.nio.file` for more modern and efficient file handling, but the traditional `java.io` classes remain in use.


Here's a summary of how to read and write files using the various classes and interfaces you mentioned in Java. Each class or interface serves a specific purpose related to file handling and stream processing.

### Reading Files

1. **BufferedInputStream**
   ```java
   try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file.txt"))) {
       int data;
       while ((data = bis.read()) != -1) {
           // Process data
       }
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

2. **BufferedReader**
   ```java
   try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
       String line;
       while ((line = br.readLine()) != null) {
           // Process line
       }
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

3. **ByteArrayInputStream**
   ```java
   byte[] data = ...; // some byte data
   try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {
       int byteData;
       while ((byteData = bais.read()) != -1) {
           // Process byteData
       }
   }
   ```

4. **CharArrayReader**
   ```java
   char[] data = ...; // some char data
   try (CharArrayReader car = new CharArrayReader(data)) {
       int charData;
       while ((charData = car.read()) != -1) {
           // Process charData
       }
   }
   ```

5. **FileInputStream**
   ```java
   try (FileInputStream fis = new FileInputStream("file.txt")) {
       int data;
       while ((data = fis.read()) != -1) {
           // Process data
       }
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

6. **FileReader**
   ```java
   try (FileReader fr = new FileReader("file.txt")) {
       int data;
       while ((data = fr.read()) != -1) {
           // Process data
       }
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

7. **InputStreamReader**
   ```java
   try (InputStreamReader isr = new InputStreamReader(new FileInputStream("file.txt"))) {
       int data;
       while ((data = isr.read()) != -1) {
           // Process data
       }
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

8. **PipedInputStream**
   ```java
   // Example with PipedOutputStream in a different thread
   PipedInputStream pipedInputStream = new PipedInputStream();
   PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);

   // Reading from PipedInputStream
   new Thread(() -> {
       try (PipedInputStream pis = pipedInputStream) {
           int data;
           while ((data = pis.read()) != -1) {
               // Process data
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }).start();
   ```

9. **PushbackInputStream**
   ```java
   try (PushbackInputStream pbis = new PushbackInputStream(new FileInputStream("file.txt"))) {
       int data;
       while ((data = pbis.read()) != -1) {
           // Process data
       }
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

10. **PushbackReader**
    ```java
    try (PushbackReader pbr = new PushbackReader(new FileReader("file.txt"))) {
        int data;
        while ((data = pbr.read()) != -1) {
            // Process data
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

11. **RandomAccessFile**
    ```java
    try (RandomAccessFile raf = new RandomAccessFile("file.txt", "r")) {
        raf.seek(0); // Move to the start of the file
        String line;
        while ((line = raf.readLine()) != null) {
            // Process line
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

12. **StringReader**
    ```java
    try (StringReader sr = new StringReader("example string")) {
        int data;
        while ((data = sr.read()) != -1) {
            // Process data
        }
    }
    ```

### Writing Files

1. **BufferedOutputStream**
   ```java
   try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file.txt"))) {
       bos.write("Hello, World!".getBytes());
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

2. **BufferedWriter**
   ```java
   try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))) {
       bw.write("Hello, World!");
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

3. **ByteArrayOutputStream**
   ```java
   try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
       baos.write("Hello, World!".getBytes());
       byte[] data = baos.toByteArray();
       // Use data
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

4. **CharArrayWriter**
   ```java
   try (CharArrayWriter caw = new CharArrayWriter()) {
       caw.write("Hello, World!");
       char[] data = caw.toCharArray();
       // Use data
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

5. **FileOutputStream**
   ```java
   try (FileOutputStream fos = new FileOutputStream("file.txt")) {
       fos.write("Hello, World!".getBytes());
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

6. **FileWriter**
   ```java
   try (FileWriter fw = new FileWriter("file.txt")) {
       fw.write("Hello, World!");
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

7. **OutputStreamWriter**
   ```java
   try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("file.txt"))) {
       osw.write("Hello, World!");
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

8. **PipedOutputStream**
   ```java
   // Example with PipedInputStream in a different thread
   PipedOutputStream pipedOutputStream = new PipedOutputStream();
   PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

   // Writing to PipedOutputStream
   new Thread(() -> {
       try (PipedOutputStream pos = pipedOutputStream) {
           pos.write("Hello, World!".getBytes());
       } catch (IOException e) {
           e.printStackTrace();
       }
   }).start();
   ```

9. **PrintStream**
   ```java
   try (PrintStream ps = new PrintStream(new FileOutputStream("file.txt"))) {
       ps.println("Hello, World!");
   } catch (IOException e) {
       e.printStackTrace();
   }
   ```

10. **PrintWriter**
    ```java
    try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt"))) {
        pw.println("Hello, World!");
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

11. **StringWriter**
    ```java
    try (StringWriter sw = new StringWriter()) {
        sw.write("Hello, World!");
        String result = sw.toString();
        // Use result
    }
    ```

### Additional Notes

- **DataInputStream** and **DataOutputStream** are used for reading and writing Java primitive data types.
- **ObjectInputStream** and **ObjectOutputStream** are used for object serialization and deserialization.
- **File** represents file or directory paths but does not handle actual reading/writing.
- **Console** provides methods for interacting with the console, typically used for user input.

Ensure to handle exceptions and close streams properly to avoid resource leaks.
