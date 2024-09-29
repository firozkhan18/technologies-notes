# com\java\seven7\core\map\HashMapThree.java

```java
package com.java.seven7.core.map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

//How do you add given key-value pair to HashMap if and only if it is not present in the HashMap?

//Using putIfAbsent() method.
public class HashMapThree {
	public static void main(String[] args) {
		// Creating HashMap with default initial capacity and load factor
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// Adding key-value pairs
		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THREE", 3);
		map.put("FOUR", 4);
		// Adds key-value pair 'ONE-111' only if it is not present in map
		map.putIfAbsent("ONE", 111);
		// Adds key-value pair 'FIVE-5' only if it is not present in map
		map.putIfAbsent("FIVE", 5);
		// Printing key-value pairs of map
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
```
