# com\java\eight8\array\ArrayOperations.java

```java
package com.java.eight8.array;

import java.util.Arrays;

public class ArrayOperations {

	// Find the missing number in an array of consecutive numbers
	public static int findMissingNumber(int[] arr) {
		int n = arr.length + 1;
		int sumOfAllNumbers = Arrays.stream(arr).sum();
		int sumOfConsecutiveNumbers = (n * (n + 1)) / 2;
		return sumOfConsecutiveNumbers - sumOfAllNumbers;
	}

	// Find the maximum and minimum elements in an array
	public static void findMinMax(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int num : arr) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		System.out.println("Minimum number: " + min);
		System.out.println("Maximum number: " + max);
	}

	// Remove duplicates from an array
	public static int[] removeDuplicates(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		int index = 0;

		for (int i = 0; i < n; i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				result[index++] = arr[i];
			}
		}

		return Arrays.copyOf(result, index);
	}

	// Find the subarray with the maximum sum
	public static int maxSubArraySum(int[] arr) {
		int maxSoFar = arr[0];
		int maxEndingHere = arr[0];

		for (int i = 1; i < arr.length; i++) {
			maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}

	// Rotate an array to the right by a given number of steps
	public static void rotateArray(int[] arr, int steps) {
		int n = arr.length;
		steps = steps % n;
		reverseArray(arr, 0, n - 1);
		reverseArray(arr, 0, steps - 1);
		reverseArray(arr, steps, n - 1);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	// Check if a given array is a palindrome
	public static boolean isPalindrome(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] != arr[end]) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

	// Sort an array of integers in ascending order using bubble sort
	public static void bubbleSort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Implement binary search algorithm to find a given element in a sorted array
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	// Reverse an array in place without using additional memory
	public static void reverseArrayInPlace(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	// Merge two sorted arrays into a single sorted array
	public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] mergedArray = new int[n + m];
		int i = 0, j = 0, k = 0;

		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				mergedArray[k++] = arr1[i++];
			} else {
				mergedArray[k++] = arr2[j++];
			}
		}

		while (i < n) {
			mergedArray[k++] = arr1[i++];
		}

		while (j < m) {
			mergedArray[k++] = arr2[j++];
		}

		return mergedArray;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 6, 7, 8 };

		System.out.println("Missing number: " + findMissingNumber(arr));

		int[] arr2 = { 9, 4, 6, 2, 5, 1, 8 };
		findMinMax(arr2);

		System.out.println("Array with duplicates removed: " + Arrays.toString(removeDuplicates(arr2)));

		int[] arr3 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum sum of subarray: " + maxSubArraySum(arr3));

		int[] arr4 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		rotateArray(arr4, 3);
		System.out.println("Array after rotating: " + Arrays.toString(arr4));

		int[] arr5 = { 1, 2, 3, 2, 1 };
		System.out.println("Is array a palindrome: " + isPalindrome(arr5));

		int[] arr6 = { 9, 2, 5, 1, 7, 3, 6, 4 };
		bubbleSort(arr6);
		System.out.println("Sorted array using bubble sort: " + Arrays.toString(arr6));

		int[] arr7 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Index of element found using binary search: " + binarySearch(arr7, 5));

		int[] arr8 = { 1, 2, 3, 4, 5, 6 };
		reverseArrayInPlace(arr8);
		System.out.println("Reversed array in place: " + Arrays.toString(arr8));

		int[] arr9 = { 1, 3, 5, 7, 9 };
		int[] arr10 = { 2, 4, 6, 8, 10 };
		int[] mergedArray = mergeSortedArrays(arr9, arr10);
		System.out.println("Merged sorted array: " + Arrays.toString(mergedArray));
	}
}
```
