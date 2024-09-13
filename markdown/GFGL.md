# GFGL.java

```java
// Implementation of Stream.concat() 
// method in Java 8 with LongStream 
import java.util.stream.LongStream; 
  
class GFGL { 
  
    // Driver code 
    public static void main(String[] args) 
    { 
  
        // Creating two Streams 
        LongStream Stream1 = LongStream.of(1520, 1620); 
        LongStream Stream2 = LongStream.of(1720, 1820); 
  
        // concatenating both the Streams and 
        // displaying the result 
        LongStream.concat(Stream1, Stream2) 
            .forEach(element -> System.out.println(element)); 
    } 
} 
```
