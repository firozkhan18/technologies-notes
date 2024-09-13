# com\java\eight8\numbers\FindContinuousSubArrayInArrayWhoseSumIsEqualToNumber2.java

```java
package com.java.eight8.numbers;

import java.util.Arrays;
//This method is less efficient than the above method. Time complexity of this method is O(n^2). In this method, We try out all the possible continuous sub arrays of the given array. If any sub array is found with sum equal to given number, we print that sub array.
public class FindContinuousSubArrayInArrayWhoseSumIsEqualToNumber2 {
	static void findSubArray(int[] inputArray, int inputNumber) {
		// Initializing 'sum' to 0

		int sum = 0;

		// Iterating through 'inputArray'

		for (int i = 0; i < inputArray.length; i++) {
			// Assigning inputArray[i] to 'sum'

			sum = inputArray[i];

			for (int j = i + 1; j < inputArray.length; j++) {
				// Adding inputArray[j] to 'sum'

				sum = sum + inputArray[j];

				// If 'sum' is equal to 'inputNumber' then printing the sub array

				if (sum == inputNumber) {
					System.out.println("Continuous sub array of " + Arrays.toString(inputArray) + " whose sum is "
							+ inputNumber + " is ");

					for (int k = i; k <= j; k++) {
						System.out.print(inputArray[k] + " ");
					}

					System.out.println();
				}

				// if 'sum' is smaller than 'inputNumber', continue the loop

				else if (sum < inputNumber) {
					continue;
				}

				// if 'sum' is greater than 'inputNumber', then break the loop

				else if (sum > inputNumber) {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		findSubArray(new int[] { 42, 15, 12, 8, 6, 32 }, 26);

		findSubArray(new int[] { 12, 5, 31, 13, 21, 8 }, 49);

		findSubArray(new int[] { 15, 51, 7, 81, 5, 11, 25 }, 41);
	}
}
```
