# com\java\eight8\numbers\SumOfAllDigitsOfANumber.java

```java
package com.java.eight8.numbers;

public class SumOfAllDigitsOfANumber {
	static void sumOfAllDigits(int inputNumber) {
		// Creating a copy of input number

		int copyOfInputNumber = inputNumber;

		// Initializing sum to 0

		int sum = 0;

		while (copyOfInputNumber != 0) {
			// Getting last digit of the input number

			int lastDigit = copyOfInputNumber % 10;

			// Adding last digit to sum

			sum = sum + lastDigit;

			// Removing last digit from the input number

			copyOfInputNumber = copyOfInputNumber / 10;
		}

		// Printing sum

		System.out.println("Sum Of All Digits In " + inputNumber + " = " + sum);
	}

	public static void main(String[] args) {
		sumOfAllDigits(47862);

		sumOfAllDigits(416872);

		sumOfAllDigits(5674283);

		sumOfAllDigits(475496215);
		
		int number = 12345;
		int sumOfDigits = String.valueOf(number).chars()
		        .map(Character::getNumericValue)
		        .sum();
	}
}
```
