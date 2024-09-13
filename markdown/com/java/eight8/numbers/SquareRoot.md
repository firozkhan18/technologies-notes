# com\java\eight8\numbers\SquareRoot.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

//Find the square root of a number:
public class SquareRoot {
    public static double squareRoot(int n) {
        double x = n;
        double y = 1;
        double e = 0.000001; // The accuracy level
        
        while (x - y > e) {
            x = (x + y) / 2;
            y = n / x;
        }
        
        return x;
    }
    
    public static void main(String[] args) {
        int n = 25;
        System.out.println("Square root of " + n + " is: " + squareRoot(n));
        
//        double num = 25;
//        double sqrt = DoubleStream.iterate(0, i -> i < num, i -> i + 1)
//                               .mapToDouble(i -> i)
//                               .filter(i -> i * i >= num)
//                               .findFirst()
//                               .getAsDouble();
//        
//        System.out.println("Square root of " + num + " is: " + sqrt);
    }
}
```
