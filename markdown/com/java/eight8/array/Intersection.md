# com\java\eight8\array\Intersection.java

```java
package com.java.eight8.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

public class Intersection {

  public static void main(String[] args) {
    Integer[] array1 = new Integer[]{1, 2, 3, 4, 5};
    Integer[] array2 = new Integer[]{4, 5, 6, 7};

    //1

    HashSet<Integer> set = new HashSet<>();
    set.addAll(Arrays.asList(array1));
    set.retainAll(Arrays.asList(array2));

    Assertions.assertEquals(Set.of(4, 5), set);

    //convert to array, if needed
    Integer[] intersection = set.toArray(new Integer[0]);

    Assertions.assertArrayEquals(new Integer[]{4, 5}, intersection);

    //2

    intersection = Arrays.stream(array1)
        .distinct()
        .filter(x -> Arrays.asList(array2).contains(x))
        .toArray(Integer[]::new);

    Assertions.assertArrayEquals(new Integer[]{4, 5}, intersection);
    
    int[] array3 = {1, 2, 3};
    int[] array4 = {3, 4, 5};
    int[] intersection1 = Arrays.stream(array3)
            .filter(value -> Arrays.stream(array4).anyMatch(val -> val == value))
            .toArray();
  }
}
```
