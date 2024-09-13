# com\java\eight8\array\FindCommonElementsBetweenTwoArraysRetainAll.java

```java
package com.java.eight8.array;

import java.util.Arrays;
import java.util.HashSet;

//Using retainAll() Method :

//This is one of the easiest method to find the common elements from two arrays. In this method, we create two HashSets using given two arrays and then use reatinAll() method of HashSet to retain only common elements from the two sets.
public class FindCommonElementsBetweenTwoArraysRetainAll {

	public static void main(String[] args) {
		Integer[] i1 = { 1, 2, 3, 4, 5, 4 };

		Integer[] i2 = { 3, 4, 5, 6, 7, 4 };

		HashSet<Integer> set1 = new HashSet<>(Arrays.asList(i1));

		HashSet<Integer> set2 = new HashSet<>(Arrays.asList(i2));

		set1.retainAll(set2);

		System.out.println(set1); // Output : [3, 4, 5]
	}
}
```
