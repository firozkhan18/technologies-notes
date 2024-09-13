# com\java\seven7\core\map\sorting\SortMapByKeysUsingCostomizedComparatorIncreasingOrderOfLengthOfKeysInJava8.java

```java
package com.java.seven7.core.map.sorting;

//Java 8 sort HashMap by keys using customized Comparator :
//
//The below program uses Java 8 comparingByKey() method with customized Comparator to sort HashMap in increasing order of length of keys.
//
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortMapByKeysUsingCostomizedComparatorIncreasingOrderOfLengthOfKeysInJava8 {
	public static void main(String[] args) {
		Map<String, Integer> studentMap = new HashMap<String, Integer>();

		studentMap.put("Jyous", 87);
		studentMap.put("Klusener", 82);
		studentMap.put("Xiangh", 91);
		studentMap.put("Lisa", 89);
		studentMap.put("Narayan", 95);
		studentMap.put("Arunkumar", 86);

		Map<String, Integer> sortedStudentMap = studentMap.entrySet().stream()
				.sorted(Entry.comparingByKey((o1, o2) -> o1.length() - o2.length()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		System.out.println("Before Sorting : ");

		System.out.println(studentMap);

		System.out.println("After Sorting : ");

		System.out.println(sortedStudentMap);
	}
}
```
