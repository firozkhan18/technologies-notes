# com\java\eight8\numbers\PrimeNumber.java

```java
package com.java.eight8.numbers;

import java.util.stream.IntStream;

//Check if a number is prime:
/**Use a loop to check if the number is divisible by any number from 2 to the square root of the number.
If the number is only divisible by 1 and itself, it is a prime number.
Example:
 
int num = 7;
boolean isPrime = true;
for (int i = 2; i <= Math.sqrt(num); i++) {
    if (num % i == 0) {
        isPrime = false;
        break;
    }
}
if (isPrime) {
    System.out.println(num + " is a prime number.");
} else {
    System.out.println(num + " is not a prime number.");
}*/
public class PrimeNumber {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int n = 17;
        System.out.println("Is " + n + " a prime number? " + isPrime(n));
        
        int num = 7;
        boolean isPrime = IntStream.rangeClosed(2, (int) Math.sqrt(num))
                                   .noneMatch(i -> num % i == 0);
        System.out.println("Is " + num + " a prime number? " + isPrime);
    }
}
```
