# com\java\eight8\arraylist\FindTheNumberOfElementsPresentInAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;
// How do you find the number of elements present in an ArrayList?
//Using size() method. size() method returns number of elements present in an ArrayList.

public class FindTheNumberOfElementsPresentInAnArrayList {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>();

		list.add(1.1);

		list.add(2.2);

		list.add(3.3);

		list.add(4.4);

		list.add(5.5);

		System.out.println(list); // Output : [1.1, 2.2, 3.3, 4.4, 5.5]

		System.out.println("Size Of ArrayList = " + list.size()); // Output : Size Of ArrayList = 5
	}
}
```
