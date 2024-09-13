# com\java\seven7\core\linkedlist\RetrieveButNotRemoveElementsOfLinkedListBothEnds.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you retrieve but not remove the elements of a LinkedList from both the ends?

//To retrieve but not remove an element from the head of a LinkedList, 
//use element() or getFirst() or peek() or peekFirst() 
//methods and to retrieve the elements from the tail of a LinkedList, use getLast() or peekLast() methods.
public class RetrieveButNotRemoveElementsOfLinkedListBothEnds {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		// Adding elements at the end of the list
		list.add("FIRST");
		list.add("SECOND");
		list.add("THIRD");
		list.add("FOURTH");
		list.add("FIFTH");
		// Printing the elements of list
		System.out.println(list); // Output : [FIRST, SECOND, THIRD, FOURTH, FIFTH]
		// Retrieving the elements from the head
		System.out.println(list.element()); // Output : FIRST
		System.out.println(list.getFirst()); // Output : FIRST
		System.out.println(list.peek()); // Output : FIRST
		System.out.println(list.peekFirst()); // Output : FIRST
		// Retrieving the elements from the tail
		System.out.println(list.peekLast()); // Output : FIFTH
		System.out.println(list.getLast()); // Output : FIFTH
	}
}
```
