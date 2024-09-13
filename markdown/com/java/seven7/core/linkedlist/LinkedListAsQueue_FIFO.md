# com\java\seven7\core\linkedlist\LinkedListAsQueue_FIFO.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//Write a Java program which implements LinkedList as a Queue (FIFO)?
//Use the offer() and poll() methods which make LinkedList to work as a Queue.
public class LinkedListAsQueue_FIFO {
	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// adding the elements into the queue
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		// Printing the elements of queue
		System.out.println(queue); // Output : [10, 20, 30, 40]
		// Removing the elements from the queue
		System.out.println(queue.poll()); // Output : 10
		System.out.println(queue.poll()); // Output : 20
	}
}
```
