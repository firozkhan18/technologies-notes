# com\java\seven7\core\collections\GenericSetExample.java

```java
package com.java.seven7.core.collections;

import java.util.*;

public class GenericSetExample {
    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<Integer>();
        integerSet.add(Integer.valueOf(10));
        integerSet.add(Integer.valueOf(11));

        Set<String> stringSet = new HashSet<String>();
        stringSet.add("Hello World");
        stringSet.add("Hi World");

        // for loop
        for(Integer data: integerSet) {
            System.out.format("Integer Value: %d\n", data);
        }

        // iterator
        Iterator<String> stringIterator = stringSet.iterator();
        while(stringIterator.hasNext()) {
            System.out.format("String Value: %s\n", stringIterator.next());
        }
    }
}
```
