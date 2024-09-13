# com\java\eight8\array\FindAllTheLeadersInAnIntegerArray.java

```java
package com.java.eight8.array;

import java.util.Arrays;

//Problem :
//Given an integer array, you have to find all the leader elements in this array. An element is said to be leader if all the elements on it’s right side are smaller than it. Rightmost element is always a leader. For example, if {14, 9, 11, 7, 8, 5, 3} is the given array then {14, 11, 8, 5, 3} are the leaders in this array.
//Logic Used To Find All The Leaders In An Integer Array :
//We go on traversing the given array from right to left. Initially, we assume the last element as highest and we store it in a variable called ‘max‘. We print the last element as it is always a leader. If we find any element greater than ‘max‘, we print that element and update the ‘max‘ variable. We continue this until we traverse all the elements in the given array.
public class FindAllTheLeadersInAnIntegerArray {
	static void findTheLeaders(int inputArray[]) {
		// Getting the length of input array

		int inputArrayLength = inputArray.length;

		// Assuming the last element as max

		int max = inputArray[inputArrayLength - 1];

		System.out.println("The leaders in " + Arrays.toString(inputArray) + " are : ");

		// Printing the last element as it is always a leader

		System.out.println(inputArray[inputArrayLength - 1]);

		// Traversing the remaining elements from right to left

		for (int i = inputArray.length - 2; i >= 0; i--) {
			// If the element is greater than max

			if (inputArray[i] > max) {
				// Printing the element

				System.out.println(inputArray[i]);

				// Updating the max

				max = inputArray[i];
			}
		}
	}

	public static void main(String[] args) {
		findTheLeaders(new int[] { 12, 9, 7, 14, 8, 6, 3 });

		findTheLeaders(new int[] { 8, 23, 19, 21, 15, 6, 11 });

		findTheLeaders(new int[] { 55, 67, 71, 57, 51, 63, 38 });

		findTheLeaders(new int[] { 21, 58, 44, 14, 51, 36, 23 });
	}
}
```
