# com\java\eight8\stream\program\Streams9.java

```java
package com.java.eight8.stream.program;

import java.util.Arrays;

/**
 * @author Benjamin Winterberg
 */
public class Streams9 {

    public static void main(String[] args) {
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);

        // C1
        // C2
    }
}
```
