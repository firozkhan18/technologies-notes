# GFG3.java

```java
// Implementation of Stream.concat() 
// method in Java 8 and removing 
// the duplicates 
import java.util.stream.Stream; 
  
class GFG3 { 
  
    // Driver code 
    public static void main(String[] args) 
    { 
  
        // Creating two Streams 
        Stream<String> stream1 = Stream.of("Geeks", "for", "GeeksforGeeks"); 
        Stream<String> stream2 = Stream.of("GeeksQuiz", "GeeksforGeeks", "for"); 
  
        // concatenating both the Streams 
        // with Stream.concat() function 
        // and displaying the result after 
        // removing the duplicates 
        Stream.concat(stream1, stream2).distinct().forEach(element -> System.out.println(element)); 
    } 
} 
```
