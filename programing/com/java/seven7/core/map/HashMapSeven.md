# com\java\seven7\core\map\HashMapSeven.java

```java
package com.java.seven7.core.map;

import java.util.HashMap;

//How do you remove all key-value pairs from a HashMap? OR How do you clear the HashMap for reuse?

//using clear() method.
public class HashMapSeven {
	public static void main(String[] args) {
		// Creating the HashMap
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		// Adding key-value pairs to HashMap
		map.put(111, 111.111);
		map.put(222, 222.222);
		map.put(333, 333.333);
		map.put(444, 444.444);
		map.put(555, 555.555);
		// Retrieving the number of key-value pairs
		System.out.println(map.size()); // Output : 5
		// Clearing the map
		map.clear();
		// Checking the number of key-value pairs after clearing the map
		System.out.println(map.size()); // Output : 0
	}
}
```
