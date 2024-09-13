# GFG.java

```java
// Implementation of Stream.concat() 
// method in Java 8 with 2 Streams 
import java.util.stream.Stream; 
  
class GFG { 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        // Creating two Streams 
        Stream<String> stream1 = Stream.of("Geeks", "for"); 
        Stream<String> stream2 = Stream.of("GeeksQuiz", "GeeksforGeeks"); 
  
        // concatenating both the Streams 
        // with Stream.concat() function 
        // and displaying the result 
        Stream.concat(stream1, stream2) 
            .forEach(element -> System.out.println(element)); 
    } 
} 
```
