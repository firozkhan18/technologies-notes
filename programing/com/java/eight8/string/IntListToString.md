# com\java\eight8\string\IntListToString.java

```java
package com.java.eight8.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//Convert a list of integers to a comma-separated string:
public class IntListToString {
    public static String listToString(List<Integer> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(","));
    }
    
    public static void main(String[] args) {
        //List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(listToString(list));
    }
}
```
