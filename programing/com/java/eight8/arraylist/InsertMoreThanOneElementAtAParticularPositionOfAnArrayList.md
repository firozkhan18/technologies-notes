# com\java\eight8\arraylist\InsertMoreThanOneElementAtAParticularPositionOfAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you insert more than one element at a particular position of an ArrayList?
//
//Another version of addAll() method which takes two arguments, one is index and another one is Collection type, can be used for this requirement. This method inserts all of the elements of passed collection at a specified position of an ArrayList.

public class InsertMoreThanOneElementAtAParticularPositionOfAnArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();

		list1.add(111);

		list1.add(222);

		list1.add(333);

		list1.add(444);

		System.out.println(list1); // Output : [111, 222, 333, 444]

		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list2.add(555);

		list2.add(666);

		list2.add(777);

		list2.add(888);

		System.out.println(list2); // Output : [555, 666, 777, 888]

		// Inserting all elements of list2 at index 2 of list1

		list1.addAll(2, list2);

		System.out.println(list1); // Output : [111, 222, 555, 666, 777, 888, 333, 444]
	}
}
```
