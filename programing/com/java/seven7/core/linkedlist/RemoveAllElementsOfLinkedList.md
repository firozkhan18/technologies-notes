# com\java\seven7\core\linkedlist\RemoveAllElementsOfLinkedList.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you remove all elements of a LinkedList?

//Using clear() method. This method removes all elements of a LinkedList.
public class RemoveAllElementsOfLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		// adding the elements to LinkedList
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);
		// Printing the elements of LinkedList
		System.out.println(linkedList); // Output : [10, 20, 30, 40, 50]
		// Removing all elements of linkedList
		linkedList.clear();
		// Printing the elements of LinkedList
		System.out.println(linkedList); // Output : []
	}
}
```
