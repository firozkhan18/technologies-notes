# com\java\seven7\core\linkedlist\RemoveOccurrencesInLinkedList.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you remove the first occurrence and last occurrence of a given element in a LinkedList?

//Use the removeFirstOccurrence(Object 0) to remove the first occurrence of a given element 
//and use removeLastOccurrence(Object 0) to remove last occurrence of a given element in a LinkedList.
public class RemoveOccurrencesInLinkedList {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		// Adding elements at the end of the list
		list.add("JAVA");
		list.add("J2EE");
		list.add("JSP");
		list.add("J2EE");
		list.add("JDBC");
		// Printing the elements of list
		System.out.println(list); // Output : [JAVA, J2EE, JSP, J2EE, JDBC]
		// Removing the first occurrence of "J2EE"
		list.removeFirstOccurrence("J2EE");
		// Printing the elements of list
		System.out.println(list); // Output : [JAVA, JSP, J2EE, JDBC]
		// Removing the last occurrence of "J2EE"
		list.removeLastOccurrence("J2EE");
		// Printing the elements of list
		System.out.println(list); // Output : [JAVA, JSP, JDBC]
	}
}
```
