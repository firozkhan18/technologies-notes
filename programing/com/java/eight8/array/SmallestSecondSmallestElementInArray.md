# com\java\eight8\array\SmallestSecondSmallestElementInArray.java

```java
package com.java.eight8.array;

//How do you find smallest and second smallest element in an integer array?
import java.util.Arrays;

//How To Find Smallest And Second Smallest Element In An Array?
//Step 1 : Let inputArray be an integer array.
//Step 2 : Initialize smallest and secondSmallest to first element of inputArray.

//int smallest = inputArray[0];
//int secondSmallest = inputArray[0];

//Step 3 : Go on traversing each element of inputArray.

//If any element is smaller than smallest, then assign smallest to secondSmallest and that element to smallest.

//if (inputArray[i] < smallest)
//{
// secondSmallest = smallest;
// smallest = inputArray[i];
//}

//If any element is smaller than secondSmallest and greater than smallest, then assign that element to secondSmallest.

//else if (inputArray[i] > smallest && inputArray[i] < secondSmallest)
//{
// secondSmallest = inputArray[i];
//}

//Step 4 : Print smallest and secondSmallest.

public class SmallestSecondSmallestElementInArray {
	private static void getSmallestAndSecondSmallestElement(int[] inputArray) {
		int smallest = inputArray[0];
		int secondSmallest = inputArray[0];
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < smallest) {
				secondSmallest = smallest;
				smallest = inputArray[i];
			} else if (inputArray[i] > smallest && inputArray[i] < secondSmallest) {
				secondSmallest = inputArray[i];
			}
		}
		System.out.println("Input Array : " + Arrays.toString(inputArray));
		System.out.println("Smallest Element : " + smallest);
		System.out.println("Second Smallest Element : " + secondSmallest);
	}

	public static void main(String[] args) {
		getSmallestAndSecondSmallestElement(new int[] { 17, 11, 23, 64, 41, 88, 35 });
		System.out.println("===============================");
		getSmallestAndSecondSmallestElement(new int[] { -9, 3, 36, -25, -9, 71, 0 });
		System.out.println("===============================");
		getSmallestAndSecondSmallestElement(new int[] { 21, 21, -18, -4, -11, 85, 7 });
	}
}
```
