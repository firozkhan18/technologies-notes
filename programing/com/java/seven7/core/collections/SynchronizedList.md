# com\java\seven7\core\collections\SynchronizedList.java

```java
package com.java.seven7.core.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//How To Synchronize ArrayList In Java?

//To synchronize ArrayList, we use Collections.synchronizedList() method. 
//This method returns synchronized list backed by the specified list. 
//There is an advise from javadocs that while iterating over the synchronized list, you must use it in a synchronized block. 
//Failed to do so may result in non-deterministic behavior.

public class SynchronizedList {
	public static void main(String[] args) {
		// Creating non synchronized ArrayList object
		ArrayList<String> list = new ArrayList<String>();
		// Adding elements to list
		list.add("JAVA");
		list.add("STRUTS");
		list.add("JSP");
		list.add("SERVLETS");
		list.add("JSF");
		// Getting synchronized list
		List<String> synchronizedList = Collections.synchronizedList(list);
		// you must use synchronized block while iterating over synchronizedList
		synchronized (synchronizedList) {
			Iterator<String> it = synchronizedList.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}
}
```
