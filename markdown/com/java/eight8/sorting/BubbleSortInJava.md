# com\java\eight8\sorting\BubbleSortInJava.java

```java
package com.java.eight8.sorting;

import java.util.Arrays;

public class BubbleSortInJava {
	static int[] bubbleSort(int[] inputArray) {
		int temp;

		for (int i = 0; i < inputArray.length - 1; i++) {
			for (int j = 0; j < inputArray.length - i - 1; j++) {
				if (inputArray[j] > inputArray[j + 1]) {
					temp = inputArray[j];
					inputArray[j] = inputArray[j + 1];
					inputArray[j + 1] = temp;
				}
			}
		}

		return inputArray;
	}

	public static void main(String[] args) {
		int inputArray[] = new int[] { 7, 4, 9, 2, 5 };

		System.out.println("Input Array : " + Arrays.toString(inputArray));

		int sortedArray[] = bubbleSort(inputArray);

		System.out.println("Sorted Array : " + Arrays.toString(sortedArray));
	}
}
```
