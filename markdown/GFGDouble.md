# GFGDouble.java

```java
// Implementation of Stream.concat() 
// method in Java 8 with DoubleStream 
import java.util.stream.DoubleStream; 
  
class GFGDouble { 
  
    // Driver code 
    public static void main(String[] args) 
    { 
  
        // Creating two Streams 
        DoubleStream Stream1 = DoubleStream.of(1520, 1620); 
        DoubleStream Stream2 = DoubleStream.of(1720, 1820); 
  
        // concatenating both the Streams and 
        // displaying the result 
        DoubleStream.concat(Stream1, Stream2) 
            .forEach(element -> System.out.println(element)); 
    } 
} 
```
