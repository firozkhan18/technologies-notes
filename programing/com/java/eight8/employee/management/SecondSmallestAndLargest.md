# com\java\eight8\employee\management\SecondSmallestAndLargest.java

```java
package com.java.eight8.employee.management;

import java.util.Arrays;
import java.util.List;

public class SecondSmallestAndLargest {
	public static void main(String[] args) {
		List<Integer> nums8 = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
		System.out.println("List of numbers: " + nums8);
		// Find the second smallest element
		Integer secondSmallest = nums8.stream().distinct().sorted().skip(1).findFirst().orElse(null);

		// Find the second largest element
		Integer secondLargest1 = nums8.stream().distinct().sorted((a, b) -> Integer.compare(b, a)).skip(1).findFirst()
				.orElse(null);

		System.out.println("\nSecond smallest element: " + secondSmallest);
		System.out.println("\nSecond largest element: " + secondLargest1);
		
		int[] nums = {1, 5, 3, 9, 7};
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] != max) {
                secondMax = nums[i];
            }
        }
        System.out.println("Second largest number: " + secondMax);
        
        int arr[] = { 100,14, 46, 47, 94, 94, 52, 86, 36, 94, 89 };
        int largest = 0;
        int secondLargest = 0;
        System.out.println("The given array is:");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "\t");
        }
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] > secondLargest)
            {
                secondLargest = arr[i];
            }
        }
        System.out.println("\nSecond largest number is:" + secondLargest);
        System.out.println("Largest Number is: "  +largest);
	}
}
```
