# com\java\eight8\array\MissingNumberInArray.java

```java
package com.java.eight8.array;

//How do you find a missing number in an array of integers if it contains elements from 1 to n where n is the number of elements?
public class MissingNumberInArray {
	// Method to calculate sum of 'n' numbers

	static int sumOfNnumbers(int n) {
		int sum = (n * (n + 1)) / 2;

		return sum;
	}

	// Method to calculate sum of all elements of array

	static int sumOfElements(int[] array) {
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int n = 8;

		int[] a = { 1, 4, 5, 3, 7, 8, 6 };

		// Step 1

		int sumOfNnumbers = sumOfNnumbers(n);

		// Step 2

		int sumOfElements = sumOfElements(a);

		// Step 3

		int missingNumber = sumOfNnumbers - sumOfElements;

		System.out.println("Missing Number is = " + missingNumber);
	}
}
```
