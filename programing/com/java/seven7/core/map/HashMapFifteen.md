# com\java\seven7\core\map\HashMapFifteen.java

```java
package com.java.seven7.core.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//How do you get synchronized HashMap in java?
//
//Using Collections.synchronizedMap() method.
public class HashMapFifteen {
	public static void main(String[] args) {
		// Creating the HashMap
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// Getting synchronized Map
		Map<String, Integer> syncMap = Collections.synchronizedMap(map);
	}
}
```
