# com\java\eight8\numbers\PerfectSquare.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

//Check if a number is a perfect square:
public class PerfectSquare {
    public static boolean isPerfectSquare(int n) {
        long x = n;
        while (x * x > n) {
            x = (x + n / x) / 2;
        }
        
        return x * x == n;
    }
    
    public static void main(String[] args) {
        int n = 16;
        System.out.println(n + " is a perfect square: " + isPerfectSquare(n));
        
//        int num = 16;
//        boolean isPerfectSquare = IntStream.iterate(0, i -> i < num, i -> i + 1)
//                                           .mapToDouble(i -> i)
//                                           .anyMatch(i -> i * i == num);
    }
}
```
