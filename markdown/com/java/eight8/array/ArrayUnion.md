# com\java\eight8\array\ArrayUnion.java

```java
package com.java.eight8.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//To find the union of two arrays:
public class ArrayUnion {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {4, 5, 6, 7, 8};

        Set<Integer> unionSet = new HashSet<>(Arrays.asList(arr1));
        unionSet.addAll(Arrays.asList(arr2));

        Integer[] unionArray = unionSet.toArray(new Integer[0]);

        System.out.println("Union of the two arrays: " + Arrays.toString(unionArray));
    }
}
```
