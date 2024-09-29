# com\java\eight8\arraylist\DecreaseTheCurrentCapacityOfAnArrayListToTheCurrentSize.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//trimToSize() method is used to trim the capacity of arrayList to the current size of ArrayList. Developers use this method to minimize the storage area of an ArrayList.

public class DecreaseTheCurrentCapacityOfAnArrayListToTheCurrentSize {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		// Now 'list' can hold 10 elements (Default Initial Capacity)

		list.ensureCapacity(20);

		// Now 'list' can hold 20 elements.

		list.add("ONE");

		list.add("TWO");

		list.add("THREE");

		list.add("FOUR");

		// reducing the current capacity to current size of an ArrayList.

		list.trimToSize();
	}
}
```
