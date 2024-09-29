# com\java\eight8\array\AllPairOfSum.java

```java
package com.java.eight8.array;

import java.util.List;

//Finding all pairs of elements in an array that add up to a specified sum in Java:
//Use nested loops to iterate through each pair of elements in the array and check if their sum equals the specified sum.
//Example:
public class AllPairOfSum {
	public static void main(String[] args) {
	int[] array = {1, 2, 3, 4, 5};
	int sum = 7;
	for (int i = 0; i < array.length; i++) {
	    for (int j = i + 1; j < array.length; j++) {
	        if (array[i] + array[j] == sum) {
	            System.out.println(array[i] + " + " + array[j] + " = " + sum);
	        }
	    }
	}
	
//	int[] numbers = {1, 2, 3, 4, 5};
//	int sum1 = 6;
//	List<String> pairs = IntStream.range(0, numbers.length)
//	                              .boxed()
//	                              .flatMap(i -> IntStream.range(i + 1, numbers.length)
//	                              .mapToObj(j -> new int[]{numbers[i], numbers[j]})
//	                              .filter(pair -> pair[0] + pair[1] == sum1)
//	                              .map(pair -> pair[0] + ", " + pair[1])
//	                              .collect(Collectors.toList());
	}
}
```
