# com\java\eight8\numbers\GCD.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

//Find the GCD (Greatest Common Divisor) of two numbers:
public class GCD {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
    
    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 36;
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2));
        
        int a = 12;
        int b = 18;
        int gcd = IntStream.rangeClosed(1, Math.min(a, b))
                           .filter(i -> a % i == 0 && b % i == 0)
                           .max()
                           .getAsInt();
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
    }
}
```
