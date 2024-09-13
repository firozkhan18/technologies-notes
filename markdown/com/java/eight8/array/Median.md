# com\java\eight8\array\Median.java

```java
package com.java.eight8.array;

import java.util.Arrays;
import java.util.stream.IntStream;
//Find the median of an array:
public class Median {
    public static double findMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        if (n % 2 == 0) {
            return (double)(arr[n/2] + arr[n/2 - 1]) / 2;
        } else {
            return (double)arr[n/2];
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 5, 9};
        System.out.println("Median of the array is: " + findMedian(arr));
        
        int[] numbers = {5, 2, 7, 1, 9};
        double median;
        if (numbers.length % 2 == 0) {
            median = IntStream.of(numbers)
                              .sorted()
                              .skip(numbers.length / 2 - 1)
                              .limit(2)
                              .average()
                              .getAsDouble();
        } else {
            median = IntStream.of(numbers)
                              .sorted()
                              .skip(numbers.length / 2)
                              .findFirst()
                              .getAsInt();
        }
        
        System.out.println("Median of the array is: " + median);
    }
}
```
