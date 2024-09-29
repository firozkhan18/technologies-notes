# com\java\seven7\core\map\sorting\SortMapByKeyInDecreasingOrderOfLengthOfKeys1.java

```java
package com.java.seven7.core.map.sorting;

//To sort the same HashMap in decreasing order of length of keys, 
//use either Collections.reverseOrder() 
//or else return o2.length() - o1.length() instead of o1.length() - o2.length() as in the below program.

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeyInDecreasingOrderOfLengthOfKeys1 {
	public static void main(String[] args) {
		Map<String, Integer> studentMap = new HashMap<String, Integer>();

		studentMap.put("Jyous", 87);
		studentMap.put("Klusener", 82);
		studentMap.put("Xiangh", 91);
		studentMap.put("Lisa", 89);
		studentMap.put("Narayan", 95);
		studentMap.put("Arunkumar", 86);

		Map<String, Integer> sortedStudentMap = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		// OR

		// Map<String, Integer> sortedStudentMap = new
		// TreeMap<>(Collections.reverseOrder(new Comparator<String>()
		// {
		// @Override
		// public int compare(String o1, String o2)
		// {
		// return o1.length() - o2.length();
		// }
		// }));

		sortedStudentMap.putAll(studentMap);

		System.out.println("Before Sorting : ");

		System.out.println(studentMap);

		System.out.println("After Sorting : ");

		System.out.println(sortedStudentMap);
	}
}
```
