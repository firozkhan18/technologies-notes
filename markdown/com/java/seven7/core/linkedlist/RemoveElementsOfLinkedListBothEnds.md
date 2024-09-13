# com\java\seven7\core\linkedlist\RemoveElementsOfLinkedListBothEnds.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you remove the elements of a LinkedList from both the ends?
//You can use pollLast() and removeLast() to remove the elements from the tail of a 
//LinkedList and to remove the elements from the head of a 
//LinkedList, use poll() or pollFirst() or remove() or removeFirst().
public class RemoveElementsOfLinkedListBothEnds {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		// Adding elements at the end of the list
		list.add("ONE");
		list.add("TWO");
		list.add("THREE");
		list.add("FOUR");
		list.add("FIVE");
		list.add("SIX");
		list.add("SEVEN");
		// Printing the elements of list
		System.out.println(list); // Output : [ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN]
		// Removing the elements from the head of the LinkedList
		list.poll();
		list.pollFirst();
		list.remove();
		System.out.println(list);
		list.removeFirst();
		// Printing the elements of list
		System.out.println(list); // Output : [FIVE, SIX, SEVEN]
		// Removing elements from the end of the LinkedList
		list.pollLast();
		list.removeLast();
		// Printing the elements of list
		System.out.println(list); // Output : [FIVE]
	}
}
```
