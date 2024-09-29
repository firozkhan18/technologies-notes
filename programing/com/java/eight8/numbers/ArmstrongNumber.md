# com\java\eight8\numbers\ArmstrongNumber.java

```java
package com.java.eight8.numbers;

//Check if a number is an Armstrong number:
public class ArmstrongNumber {
    public static boolean isArmstrongNumber(int n) {
        int originalNumber, remainder, result = 0, digits = 0;
        originalNumber = n;

        while (originalNumber != 0) {
            originalNumber = originalNumber / 10;
            digits++;
        }

        originalNumber = n;

        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, digits);
            originalNumber = originalNumber / 10;
        }

        return result == n;
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println(n + " is an Armstrong number: " + isArmstrongNumber(n));
        
        int num = 153;
        int sumOfPowersOfDigits = String.valueOf(num).chars()
                                  .map(Character::getNumericValue)
                                  .map(digit -> (int) Math.pow(digit, String.valueOf(num).length()))
                                  .sum();
        boolean isArmstrong = sumOfPowersOfDigits == num;
        
        System.out.println(num + " is an Armstrong number: " + isArmstrong);
    }
}
```
