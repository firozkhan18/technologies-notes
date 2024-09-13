# com\java\seven7\core\linkedlist\ReplaceElementSpecificPositionOfLinkedListWithGivenElement.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you replace an element at a specific position of a LinkedList with the given element?

//To replace an element at specific position of a LinkedList , use set() method.
public class ReplaceElementSpecificPositionOfLinkedListWithGivenElement {
	public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>(); 
        //Adding elements at the end of the list 
        list.add("ONE"); 
        list.add("TWO"); 
        list.add("THREE"); 
        list.add("FOUR"); 
        //Printing the elements of list 
        System.out.println(list);      //Output : [ONE, TWO, THREE, FOUR] 
        //Replacing an element at index 2 with "ZERO" 
        list.set(2, "ZERO"); 
        System.out.println(list);     //Output : [ONE, TWO, ZERO, FOUR]
    }
}
```
