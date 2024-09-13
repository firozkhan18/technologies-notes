# com\java\eight8\streams\core\distinct\DistinctPrimitivesAndStrings.java

```java
package com.java.eight8.streams.core.distinct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctPrimitivesAndStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

        // Get collection without duplicate i.e. distinct only
        List<String> distinctItems =
                list.stream().distinct().collect(Collectors.toList());

        // Let's verify distinct elements
        System.out.println(distinctItems);
    }
}
```
