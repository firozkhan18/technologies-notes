# com\java\seven7\core\map\HashMapThirteen.java

```java
package com.java.seven7.core.map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

//How do you replace a value associated with a given key in the HashMap?
//
//replace() method replaces the value associated with the specified key if the key is currently mapped to some value.
public class HashMapThirteen {
	public static void main(String[] args) {
		// Creating the HashMap
		HashMap<String, String> map = new HashMap<String, String>();
		// Adding key-value pairs to HashMap
		map.put("ONE", "AAA");
		map.put("TWO", "BBB");
		map.put("THREE", "CCC");
		map.put("FOUR", "DDD");
		map.put("FIVE", "EEE");
		// Printing Key-value pairs
		System.out.println("HashMap Before Replace :");
		Set<Entry<String, String>> keyValueSet = map.entrySet();
		for (Entry<String, String> entry : keyValueSet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("------------------");
		// Replacing the value associated with 'THREE' to '333'
		map.replace("THREE", "333");
		System.out.println("HashMap After Replace :");
		for (Entry<String, String> entry : keyValueSet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
```
