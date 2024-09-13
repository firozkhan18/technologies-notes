# com\java\eight8\numbers\SumOfAllDigitsOfANumberUsingRecursive.java

```java
package com.java.eight8.numbers;

public class SumOfAllDigitsOfANumberUsingRecursive {
	// Initializing sum to 0

	int sum = 0;

	// Recursive function to calculate sum of all digits of a number

	int sumOfAllDigits(int inputNumber) {
		if (inputNumber == 0) {
			// if input number is 0, returning sum

			return sum;
		} else {
			// Getting last digit of input number

			int lastDigit = inputNumber % 10;

			// Adding last digit to sum

			sum = sum + lastDigit;

			// Removing last digit from input number

			inputNumber = inputNumber / 10;

			// Calling the function recursively

			sumOfAllDigits(inputNumber);
		}

		return sum;
	}

	public static void main(String[] args) {
		SumOfAllDigitsOfANumberUsingRecursive mainClass = new SumOfAllDigitsOfANumberUsingRecursive();

		System.out.println(mainClass.sumOfAllDigits(416872));
	}
}
```
