# com\java\eight8\array\LargestElement.java

```java
package com.java.eight8.array;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 7, 2};
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Largest element in the array: " + max);
        
        int max1 = Arrays.stream(array).max().getAsInt();

        System.out.println("Largest element in array: " + max1);
    }
}
```
