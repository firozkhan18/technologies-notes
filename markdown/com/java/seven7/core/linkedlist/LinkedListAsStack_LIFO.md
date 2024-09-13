# com\java\seven7\core\linkedlist\LinkedListAsStack_LIFO.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

// How do you use LinkedList as Stack (LIFO)?

//LinkedList has pop() and push() methods which make LinkedList to function as a Stack.
public class LinkedListAsStack_LIFO {
	public static void main(String[] args){
        LinkedList<Integer> stack = new LinkedList<Integer>(); 
        //pushing the elements into the stack 
        stack.push(10); 
        stack.push(20); 
        stack.push(30); 
        stack.push(40); 
        //Printing the elements of stack 
        System.out.println(stack);      //Output : [40, 30, 20, 10] 
        //Poping out the elements from the stack 
        System.out.println(stack.pop());    //Output : 40 
        System.out.println(stack.pop());    //Output : 30
    }
}
```
