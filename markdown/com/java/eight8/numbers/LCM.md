# com\java\eight8\numbers\LCM.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

//Find the LCM (Least Common Multiple) of two numbers:
public class LCM {
    public static int findLCM(int a, int b) {
        return a * (b / findGCD(a, b));
    }
    
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
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + findLCM(num1, num2));
        
        int a = 12;
        int b = 18;
        int lcm = IntStream.iterate(Math.max(a, b), i -> i + Math.max(a, b))
                           .filter(i -> i % a == 0 && i % b == 0)
                           .findFirst()
                           .getAsInt();
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
```
