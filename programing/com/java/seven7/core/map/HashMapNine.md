# com\java\seven7\core\map\HashMapNine.java

```java
package com.java.seven7.core.map;

import java.util.Collection;
import java.util.HashMap;

//How do you retrieve all the values present in a HashMap?

//Using values() method. This method returns Collection view of all the values present in a HashMap.
public class HashMapNine {
	public static void main(String[] args) {
		// Creating the HashMap
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// Adding key-value pairs to HashMap
		map.put(1, "AAA");
		map.put(2, "BBB");
		map.put(3, "CCC");
		map.put(4, "DDD");
		map.put(5, "EEE");
		// Retrieving the Collection view of values present in map
		Collection<String> values = map.values();
		for (String value : values) {
			System.out.println(value);
		}
	}
}
```
