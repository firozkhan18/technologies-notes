# com\java\eight8\array\SecondSmallest.java

```java
package com.java.eight8.array;

import java.util.Arrays;

//Find the second smallest element in an array:
public class SecondSmallest {
    public static int findSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }
        
        return secondSmallest;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 9, 7};
        System.out.println("Second smallest element in the array is: " + findSecondSmallest(arr));
        
        int[] numbers = {5, 3, 8, 2, 9};
        int secondSmallest = Arrays.stream(numbers)
                                   .distinct()
                                   .sorted()
                                   .skip(1)
                                   .findFirst()
                                   .getAsInt();
        
        System.out.println("Second smallest element in the array is: " + secondSmallest);
    }
}
```
