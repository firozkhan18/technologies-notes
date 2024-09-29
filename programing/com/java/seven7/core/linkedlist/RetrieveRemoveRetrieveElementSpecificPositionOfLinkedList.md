# com\java\seven7\core\linkedlist\RetrieveRemoveRetrieveElementSpecificPositionOfLinkedList.java

```java
package com.java.seven7.core.linkedlist;

import java.util.LinkedList;

//How do you retrieve and remove and only retrieve an element from specific position of a LinkedList?

//You can use remove(int index) to retrieve and remove an element from specific position of a LinkedList. 
//To only retrieve an element, ust get(int index) method.

public class RetrieveRemoveRetrieveElementSpecificPositionOfLinkedList {
	public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>(); 
        //Adding elements at the end of the list 
        list.add("JAVA"); 
        list.add("J2EE"); 
        list.add("JSP"); 
        list.add("SERVLETS"); 
        list.add("JDBC"); 
        //Printing the elements of list 
        System.out.println(list);      //Output : [JAVA, J2EE, JSP, SERVLETS, JDBC] 
        //Retrieving and removing an element at index 2 of the list 
        System.out.println(list.remove(2));     //Output : JSP 
        //Printing the elements of list 
        System.out.println(list);     //Output : [JAVA, J2EE, SERVLETS, JDBC] 
        //Only retrieving an element at index 2 of the list 
        System.out.println(list.get(2));     //Output : SERVLETS
    }
}
```
