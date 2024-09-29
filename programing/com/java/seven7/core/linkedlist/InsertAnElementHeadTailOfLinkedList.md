# com\java\seven7\core\linkedlist\InsertAnElementHeadTailOfLinkedList.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you insert an element at the head and tail of a LinkedList?

//You can use add() or addLast() or offer() or offerLast() to add the elements at the tail of a LinkedList 
//and to add the elements at the head of a LinkedList, use either addFirst() or offerFirst().
public class InsertAnElementHeadTailOfLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		// Adding elements at the end of the list
		list.add(10);
		list.addLast(20);
		list.offer(30);
		list.offerLast(40);
		// Printing the elements of list
		System.out.println(list); // Output : [10, 20, 30, 40]
		// Adding elements at the beginning of the list
		list.offerFirst(1);
		list.addFirst(2);
		// Printing the elements of list
		System.out.println(list); // Output : [2, 1, 10, 20, 30, 40]
	}
}
```
