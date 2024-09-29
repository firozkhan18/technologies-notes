# com\java\seven7\core\linkedlist\CreateCloneOfLinkedList.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you create clone of a LinkedList?

//Using clone() method of LinkedList class. This method creates shallow copy of the original LinkedList.
public class CreateCloneOfLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
		// adding the elements to linkedList1
		linkedList1.add(10);
		linkedList1.add(20);
		linkedList1.add(30);
		linkedList1.add(40);
		linkedList1.add(50);
		// Printing the elements of linkedList1
		System.out.println(linkedList1); // Output : [10, 20, 30, 40, 50]
		// Creating another LinkedList
		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		// Cloning the linkedList1 into linkedList2
		linkedList2 = (LinkedList<Integer>) linkedList1.clone();
		// Printing the elements of linkedList2
		System.out.println(linkedList2); // Output : [10, 20, 30, 40, 50]
	}
}
```
