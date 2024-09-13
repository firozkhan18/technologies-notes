# com\java\seven7\core\collections\SynchronizedHashSet.java

```java
package com.java.seven7.core.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//How To Synchronize HashSet In Java?

//We use Collections.synchronizedSet() method to synchronize HashSet. 
//This method returns synchronized set backed by the specified set. 
//There is also an advice from javadocs that you must use this synchronized set in a synchronized block while iterating over it. 
//If you don’t do this, it may result in non-deterministic behavior.

public class SynchronizedHashSet {
	public static void main(String[] args) {
		// Creating non synchronized HashSet object
		HashSet<String> set = new HashSet<String>();
		// Adding elements to set
		set.add("JAVA");
		set.add("STRUTS");
		set.add("JSP");
		set.add("SERVLETS");
		set.add("JSF");
		// Getting synchronized set
		Set<String> synchronizedSet = Collections.synchronizedSet(set);
		// you must use synchronized block while iterating over synchronizedSet
		synchronized (synchronizedSet) {
			Iterator<String> it = synchronizedSet.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}
}
```
