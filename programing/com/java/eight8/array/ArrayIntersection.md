# com\java\eight8\array\ArrayIntersection.java

```java
package com.java.eight8.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//To find the intersection of two arrays:
public class ArrayIntersection {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {4, 5, 6, 7, 8};

        Set<Integer> intersectionSet = new HashSet<>(Arrays.asList(arr1));
        intersectionSet.retainAll(Arrays.asList(arr2));

        Integer[] intersectionArray = intersectionSet.toArray(new Integer[0]);

        System.out.println("Intersection of the two arrays: " + Arrays.toString(intersectionArray));
    }
}
```
