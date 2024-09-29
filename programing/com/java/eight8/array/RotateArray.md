# com\java\eight8\array\RotateArray.java

```java
package com.java.eight8.array;

import java.util.stream.IntStream;

//Rotate elements of an array to the right by a given number of positions:
public class RotateArray {
    public static void rotateArray(int[] arr, int rotateBy) {
        int n = arr.length;
        int[] temp = new int[n];
        
        for (int i = 0; i < n; i++) {
            temp[(i + rotateBy) % n] = arr[i];
        }
        
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int rotateBy = 2;
        rotateArray(arr, rotateBy);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        int[] numbers = {1, 2, 3, 4, 5};
        int rotateBy1 = 2;
        int[] rotatedNumbers = IntStream.range(0, numbers.length)
                                  .mapToObj(i -> numbers[(i - rotateBy1 + numbers.length) % numbers.length])
                                  .mapToInt(Integer::intValue)
                                  .toArray();
        System.out.println(rotatedNumbers);
    }
}
```
