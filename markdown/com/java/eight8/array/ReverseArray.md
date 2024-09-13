# com\java\eight8\array\ReverseArray.java

```java
package com.java.eight8.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ReverseArray {
  public static void main(final String[] args) {
    // 1
    String[] array = {"A", "B", "C", "D", "E"};
    Collections.reverse(Arrays.asList(array));
    System.out.println(Arrays.toString(array));

    // 2
    array = new String[]{"A", "B", "C", "D", "E"};
    for (int i = 0; i < array.length / 2; i++) {
      String temp = array[i];
      array[i] = array[array.length - 1 - i];
      array[array.length - 1 - i] = temp;
    }
    System.out.println(Arrays.toString(array));

    final String[] arr = {"A", "B", "C", "D", "E"};
    Object[] reversedArr = IntStream.rangeClosed(1, array.length)
        .mapToObj(i -> arr[arr.length - i])
        .toArray();
    System.out.println(Arrays.toString(reversedArr));

    //3
    ArrayUtils.reverse(arr);
    System.out.println(Arrays.toString(arr));
    
    
    int[] array1 = {1, 2, 3, 4, 5};

    for (int i = 0; i < array1.length / 2; i++) {
        int temp = array1[i];
        array1[i] = array1[array1.length - i - 1];
        array1[array1.length - i - 1] = temp;
    }

    System.out.print("Reversed array: ");
    for (int num : array1) {
        System.out.print(num + " ");
    }
    
    int[] array2 = {1, 2, 3, 4, 5};
    int[] reversedArray = IntStream.range(0, array2.length)
            .map(i -> array2[array2.length - i - 1])
            .toArray();
    System.out.print("Reversed array: "+reversedArray);
  }
}
```
