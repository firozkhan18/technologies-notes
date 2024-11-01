# Table of Contents
- [What is the difference between IO and NIO?](#what-is-the-difference-between-io-and-nio)
- [What features of NIO do you know?](#what-features-of-nio-do-you-know)
- [What are "channels"?](#what-are-channels)
- [What are the different types of I/O streams?](#what-are-the-different-types-of-io-streams)
- [What are the main classes of I/O streams?](#what-are-the-main-classes-of-io-streams)
- [In which packets are the I/O stream classes located?](#in-which-packets-are-the-io-stream-classes-located)
- [Which subclasses of the InputStream class do you know and what are they for?](#which-subclasses-of-the-inputstream-class-do-you-know-and-what-are-they-for)
- [What is PushbackInputStream used for?](#what-is-pushbackinputstream-used-for)
- [What is SequenceInputStream used for?](#what-is-sequenceinputstream-used-for)
- [Which class allows you to read data from the input byte stream in the format of primitive data types?](#which-class-allows-you-to-read-data-from-the-input-byte-stream-in-the-format-of-primitive-data-types)
- [Which subclasses of the OutputStream class do you know and what are they for?](#which-subclasses-of-the-outputstream-class-do-you-know-and-what-are-they-for)
- [Which subclasses of the Reader class do you know and what are they for?](#which-subclasses-of-the-reader-class-do-you-know-and-what-are-they-for)
- [Which subclasses of the Writer class do you know and what do they do?](#which-subclasses-of-the-writer-class-do-you-know-and-what-do-they-do)
- [What is the difference between the PrintWriter class and PrintStream?](#what-is-the-difference-between-the-printwriter-class-and-printstream)
- [What are the differences and what do InputStream, OutputStream, Reader, and Writer have in common?](#what-are-the-differences-and-what-do-inputstream-outputstream-reader-and-writer-have-in-common)
- [Which classes allow you to convert byte streams to character streams and vice versa?](#which-classes-allow-you-to-convert-byte-streams-to-character-streams-and-vice-versa)
- [Which classes allow you to speed up read/write by using a buffer?](#which-classes-allow-you-to-speed-up-readwrite-by-using-a-buffer)
- [Which class is designed to work with file system elements?](#which-class-is-designed-to-work-with-file-system-elements)
- [What methods of the File class do you know?](#what-methods-of-the-file-class-do-you-know)
- [What do you know about the FileFilter interface?](#what-do-you-know-about-the-filefilter-interface)
- [How do I select all items in a specific catalog by criterion (for example, with a specific extension)?](#how-do-i-select-all-items-in-a-specific-catalog-by-criterion-for-example-with-a-specific-extension)
- [What do you know about RandomAccessFile?](#what-do-you-know-about-randomaccessfile)
- [What file access modes does RandomAccessFile have?](#what-file-access-modes-does-randomaccessfile-have)
- [Which classes support reading and writing compressed streams?](#which-classes-support-reading-and-writing-compressed-streams)
- [Is there a way to redirect standard I/O streams?](#is-there-a-way-to-redirect-standard-io-streams)
- [Which character is the separator when specifying a path in the file system?](#which-character-is-the-separator-when-specifying-a-path-in-the-file-system)
- [What is the "absolute path" and the "relative path"?](#what-is-the-absolute-path-and-the-relative-path)
- [What is a "symbolic link"?](#what-is-a-symbolic-link)

## What is the difference between IO and NIO?
Java IO (input-output) is thread-oriented, while Java NIO (New IO) is buffer-oriented. Thread-oriented I/O involves reading/writing from and to a stream one or more bytes per unit of time in turn, without caching information. This limits the ability to move forward or backward along the data stream arbitrarily. In contrast, NIO reads data into a buffer, allowing for greater flexibility in data processing.

I/O threads in Java IO are blocking, meaning that when a method call occurs, it locks until data is read or written. The executing thread cannot perform other tasks during this wait. NIO's non-blocking mode enables a thread to request data from a channel and receive only what is currently available, allowing the thread to perform other operations if no data is ready.

Java NIO also introduces selectors, which allow a single thread to monitor multiple input channels, enabling efficient management of I/O operations.

## What features of NIO do you know?
- **Channels and Selectors**: NIO supports different types of channels that provide an abstraction for I/O operations. Channels facilitate high-rate data transfer and can be non-blocking. Selectors allow a single thread to manage multiple channels.

- **Buffers**: Buffers are used for all primitive wrapper classes (except Boolean). They provide operations such as clear, flip, and mark.

- **Encodings**: NIO introduces encoders and decoders to handle the conversion between bytes and characters, supporting Unicode.

## What are "channels"?
Channels are logical portals that abstract lower-level objects in the file system (like memory-mapped files). They serve as conduits through which data is transmitted between byte buffers and I/O services. When data is sent, it is placed in a buffer and then passed to the channel; for incoming data, it is read from the channel into a pre-provided buffer.

Channels provide a streamlined mechanism for efficient data transport, allowing for minimal overhead in accessing system I/O services.

## What are the different types of I/O streams?
There are two primary types of I/O streams in Java:
- **Byte streams**: These are represented by `java.io.InputStream` and `java.io.OutputStream`.
- **Character streams**: These are represented by `java.io.Reader` and `java.io.Writer`.

## What are the main classes of I/O streams?
- **Byte Streams**:
  - `InputStream`: Abstract class for input byte streams.
  - `OutputStream`: Abstract class for output byte streams.

- **Character Streams**:
  - `Reader`: Abstract class for reading character streams.
  - `Writer`: Abstract class for writing character streams.

## In which packets are the I/O stream classes located?
The main I/O stream classes are located in the `java.io` package. For working with compressed data streams, classes from the `java.util.zip` package are used.

## Which subclasses of the InputStream class do you know and what are they for?
- `BufferedInputStream`: Buffered input stream for efficient reading.
- `ByteArrayInputStream`: Allows reading from a byte array.
- `DataInputStream`: Input stream for reading Java primitive data types.
- `FileInputStream`: Reads data from a file.
- `FilterInputStream`: Abstract class for filtering input streams.
- `ObjectInputStream`: Reads objects from an input stream.
- `PushbackInputStream`: Allows bytes to be pushed back into the stream.
- `SequenceInputStream`: Merges multiple input streams into one.

## What is PushbackInputStream used for?
`PushbackInputStream` allows the last read byte to be returned to the stream, enabling a mechanism to "look" ahead in the input stream without removing data. This is useful for scenarios where you may need to reconsider or re-read the last byte.

## What is SequenceInputStream used for?
`SequenceInputStream` allows concatenating multiple input streams into one. It takes either a pair of input streams or an enumeration of input streams and reads them sequentially, closing the streams when finished.

## Which class allows you to read data from the input byte stream in the format of primitive data types?
The `DataInputStream` class is designed for reading primitive data types from an input byte stream. It includes methods for reading various types, such as `readInt()`, `readDouble()`, `readBoolean()`, etc.

## Which subclasses of the OutputStream class do you know and what are they for?
- `BufferedOutputStream`: Buffered output stream for efficient writing.
- `ByteArrayOutputStream`: All data is written to a byte array in memory.
- `DataOutputStream`: Output stream for writing primitive data types.
- `FileOutputStream`: Writes data to a file.
- `FilterOutputStream`: Abstract class for filtering output streams.
- `ObjectOutputStream`: Writes objects to an output stream.
- `PipedOutputStream`: Implements the concept of an output channel.

## Which subclasses of the Reader class do you know and what are they for?
- `BufferedReader`: Buffered character input stream for efficient reading.
- `CharArrayReader`: Reads from a character array.
- `FileReader`: Reads character data from a file.
- `FilterReader`: Abstract class for filtering character input streams.
- `InputStreamReader`: Converts byte streams to character streams.
- `LineNumberReader`: Keeps track of line numbers while reading.
- `PipedReader`: Implements the concept of an input channel.
- `PushbackReader`: Allows characters to be pushed back into the stream.
- `StringReader`: Reads from a string.

## Which subclasses of the Writer class do you know and what do they do?
- `BufferedWriter`:

 Buffered character output stream for efficient writing.
- `CharArrayWriter`: Writes to a character array.
- `FileWriter`: Writes character data to a file.
- `FilterWriter`: Abstract class for filtering character output streams.
- `OutputStreamWriter`: Converts character streams to byte streams.
- `PipedWriter`: Implements the concept of an output channel.
- `PrintWriter`: Provides methods for printing formatted representations of objects.
- `StringWriter`: Writes to a string.

## What is the difference between the PrintWriter class and PrintStream?
The `PrintWriter` class is designed for writing formatted text with support for Unicode, while `PrintStream` is more focused on byte output. `PrintWriter` has a mechanism for controlling buffer flushing, while `PrintStream` flushes the buffer automatically upon certain method calls. Additionally, `PrintWriter` methods can throw exceptions, whereas `PrintStream` methods typically do not.

## What are the differences and what do InputStream, OutputStream, Reader, and Writer have in common?
- **InputStream** and its subclasses: A set for obtaining byte data from various sources.
- **OutputStream** and its subclasses: A set of classes that define streaming byte output.
- **Reader** and its subclasses: Define the streaming input of Unicode characters.
- **Writer** and its subclasses: Define the streaming output of Unicode characters.

All these classes are part of the Java I/O system and provide mechanisms for data input and output.

## Which classes allow you to convert byte streams to character streams and vice versa?
- `OutputStreamWriter`: Converts character output to byte streams.
- `InputStreamReader`: Converts byte input to character streams.

## Which classes allow you to speed up read/write by using a buffer?
- `BufferedInputStream`: For buffered input streams.
- `BufferedOutputStream`: For buffered output streams.
- `BufferedReader`: For buffered character input streams.
- `BufferedWriter`: For buffered character output streams.

## Which class is designed to work with file system elements?
The `File` class is designed to represent and work with file system elements, allowing you to create new files/directories, and retrieve information such as file size, modification time, and directory contents.

## What methods of the File class do you know?
- `boolean createNewFile()`: Attempts to create a new file.
- `boolean delete()`: Attempts to delete a directory or file.
- `boolean mkdir()`: Attempts to create a new directory.
- `boolean renameTo(File dest)`: Attempts to rename a file or directory.
- `boolean exists()`: Checks if a file or directory exists.
- `String getAbsolutePath()`: Returns the absolute path.
- `String getName()`: Returns the name of the file or directory.
- `String getParent()`: Returns the name of the parent directory.
- `boolean isDirectory()`: Checks if the path is a directory.
- `boolean isFile()`: Checks if the path is a file.
- `boolean isHidden()`: Checks if the file or directory is hidden.
- `long length()`: Returns the size of the file in bytes.
- `long lastModified()`: Returns the last modification time.
- `String[] list()`: Returns an array of files and directories in the directory.
- `File[] listFiles()`: Returns an array of files and subdirectories in the directory.

## What do you know about the FileFilter interface?
The `FileFilter` interface is used to determine whether a file meets certain criteria. It contains a single method, `accept(File pathname)`, which should be implemented to define the filtering condition.

```java
public boolean accept(final File file) {
    return file.exists() && file.isDirectory();
}
```

## How do I select all items in a specific catalog by criterion (for example, with a specific extension)?
You can use the `File.listFiles()` method, passing a `FileFilter` implementation that specifies your criteria (e.g., file extension) to filter the items in a directory.

## What do you know about RandomAccessFile?
`RandomAccessFile` allows for reading and writing data at any location in a file. It is not part of the standard I/O classes and has its own methods. It allows moving forward and backward in the file, and its methods include `getFilePointer()`, `seek()`, `length()`, `setLength()`, and `getChannel()` for file channel operations.

## What file access modes does RandomAccessFile have?
- `"r"`: Opens a read-only file.
- `"rw"`: Opens the file for reading and writing, creating it if it does not exist.
- `"rws"`: Opens for reading and writing, synchronously writing changes to physical media.
- `"rwd"`: Similar to `"rw"`, but only synchronously writes changes to the content.

## Which classes support reading and writing compressed streams?
- `DeflaterOutputStream`: Compresses data in Deflate format.
- `Deflater`: Compresses data in ZLIB format.
- `ZipOutputStream`: Compresses data into Zip format.
- `GZIPOutputStream`: Compresses data into GZIP format.
- `InflaterInputStream`: Decompresses data in Deflate format.
- `Inflater`: Decompresses data in ZLIB format.
- `ZipInputStream`: Decompresses data in Zip format.
- `GZIPInputStream`: Decompresses data in GZIP format.

## Is there a way to redirect standard I/O streams?
Yes, the `System` class allows you to redirect the standard input, output, and error output streams using:
- `setIn(InputStream)`: For standard input.
- `setOut(PrintStream)`: For standard output.
- `setErr(PrintStream)`: For standard error output.

## Which character is the separator when specifying a path in the file system?
The path separator varies by operating system: `\` for Windows and `/` for Linux. In Java, the separator can be obtained using `File.separator`.

## What is the "absolute path" and the "relative path"?
- **Absolute Path**: A path that points to a specific location in the file system, starting from the root directory.
- **Relative Path**: A path that is relative to the current working directory of the user or application.

## What is a "symbolic link"?
A symbolic link is a special type of file that contains a reference to another file or directory. It allows access to the target file or directory through an alternative name. Symbolic links facilitate file organization by enabling multiple names for a single file or directory and can reference files across different file systems.
