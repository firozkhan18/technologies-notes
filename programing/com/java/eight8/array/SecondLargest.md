# com\java\eight8\array\SecondLargest.java

```java
package com.java.eight8.array;
//Write a Java program to find second largest element in an array of integers?

//Logic Used To Find Second Largest Number In An Integer Array :
//First, we compare the first two elements of the given array. 
//The largest among these two elements will be assigned to ‘firstLargest‘ 
//and smallest will be assigned to ‘secondLargest‘. 
//We iterate the remaining elements through for loop. 
//If any element of the remaining elements is greater than the ‘firstLargest‘, 
//then we assign that element to ‘firstLargest‘ and current value of ‘firstLargest‘ 
//will be assigned to ‘secondLargest‘. If any element is smaller than ‘firstLargest‘ 
//and greater than ‘secondLargest‘, 
//then we assign that element to ‘secondLargest‘.
public class SecondLargest {
	static int secondLargest(int[] input) {
		int firstLargest, secondLargest;
		// Checking first two elements of input array
		if (input[0] > input[1]) {
			// If first element is greater than second element
			firstLargest = input[0];
			secondLargest = input[1];
		} else {
			// If second element is greater than first element
			firstLargest = input[1];
			secondLargest = input[0];
		}

		// Checking remaining elements of input array
		for (int i = 2; i < input.length; i++) {
			if (input[i] > firstLargest) {
				// If element at 'i' is greater than 'firstLargest'
				secondLargest = firstLargest;
				firstLargest = input[i];
			} else if (input[i] < firstLargest && input[i] > secondLargest) {
				// If element at 'i' is smaller than 'firstLargest' and greater than
				// 'secondLargest'
				secondLargest = input[i];
			}
		}

		return secondLargest;
	}

	public static void main(String[] args) {
		System.out.println(secondLargest(new int[] { 45, 51, 28, 75, 49, 42 }));
		System.out.println(secondLargest(new int[] { 985, 521, 975, 831, 479, 861 }));
		System.out.println(secondLargest(new int[] { 9459, 9575, 5692, 1305, 1942, 9012 }));
		System.out.println(secondLargest(new int[] { 47498, 14526, 74562, 42681, 75283, 45796 }));
	}
}
```
