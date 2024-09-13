# com\java\eight8\numbers\Factorial.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

//Find the factorial of a number:

/**Use a loop to multiply each number from 1 to the given number to calculate the factorial.
Example:

int num = 5;
int factorial = 1;
for (int i = 1; i <= num; i++) {
    factorial *= i;
}
System.out.println("Factorial of " + num + " is " + factorial);*/
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));
        
        int num = 5;
        int factorial = IntStream.rangeClosed(1, num).reduce(1, (x, y) -> x * y);
        System.out.println("Factorial" + factorial);
    }
}
```
