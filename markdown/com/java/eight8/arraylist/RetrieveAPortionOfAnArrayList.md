# com\java\eight8\arraylist\RetrieveAPortionOfAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;
import java.util.List;

//How do you retrieve a portion of an ArrayList?
//
//Using subList() method of ArrayList, we can retrieve a portion of an ArrayList. subList() method returns a view of a portion of an ArrayList in the given range. The returned subList is backed by original ArrayList. That means any changes made to subList will be reflected in original ArrayList or Vice-Versa.

public class RetrieveAPortionOfAnArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(111);

		list.add(222);

		list.add(333);

		list.add(444);

		list.add(555);

		list.add(666);

		System.out.println(list); // Output : [111, 222, 333, 444, 555, 666]

		// Retrieving a SubList

		List<Integer> subList = list.subList(1, 4);

		System.out.println(subList); // Output : [222, 333, 444]

		// Modifying the list

		list.set(2, 000);

		// Changes will be reflected in subList

		System.out.println(subList); // Output : [222, 0, 444]

		// Modifying the subList

		subList.set(2, 000);

		// Changes will be reflected in list

		System.out.println(list); // Output : [111, 222, 0, 0, 555, 666]
	}
}
```
