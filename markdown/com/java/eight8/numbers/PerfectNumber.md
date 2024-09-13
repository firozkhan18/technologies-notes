# com\java\eight8\numbers\PerfectNumber.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

//Check if a number is a perfect number:
public class PerfectNumber {
    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        
        return sum == n;
    }
    
    public static void main(String[] args) {
        int n = 28;
        System.out.println("Is " + n + " a perfect number? " + isPerfectNumber(n));
        
        int num = 28;
        boolean isPerfect = IntStream.range(1, num)
                                      .filter(i -> num % i == 0)
                                      .sum() == num;
        System.out.println("Is " + num + " a perfect number? " + isPerfect);
        
    }
}
```
