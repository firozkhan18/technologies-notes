# com\java\eight8\array\FindMissingNumberInAnArray.java

```java
package com.java.eight8.array;

//Java Puzzle :
//If ‘n’ is the positive number and ‘a’ is an array of integers of length n-1 containing elements from 1 to n. Then find the missing number in ‘a’ in the range from 1 to n. Occurrence of each element is only once. i.e ‘a’ does not contain duplicates.
//
//Example :
//If n = 8, then array ‘a’ will have 7 elements in the range from 1 to 8. For example {1, 4, 5, 3, 7, 8, 6}. One number will be missing in ‘a’ (2 in this case). You have to find out that missing number.
//
//Solution :
//Step 1 : First we find out sum of ‘n’ numbers by using formula n*(n+1)/2.
//
//Step 2 : Then we will find sum of all elements of array ‘a’.
//
//Step 3 : Missing_Number = (Sum of 1 to ‘n’ numbers) – (Sum of elements of array ‘a’)
public class FindMissingNumberInAnArray {
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
