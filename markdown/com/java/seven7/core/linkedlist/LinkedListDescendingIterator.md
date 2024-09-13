# com\java\seven7\core\linkedlist\LinkedListDescendingIterator.java

```java
package com.java.seven7.core.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDescendingIterator {
	
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>(); 
        //Adding elements at the end of the list 
        list.add("JAVA"); 
        list.add("J2EE"); 
        list.add("JSP"); 
        list.add("SERVLETS"); 
        list.add("JDBC"); 
        //Printing the elements of list 
        System.out.println(list);      //Output : [JAVA, J2EE, JSP, SERVLETS, JDBC] 
        //Getting the Iterator object using descendingIterator() method 
        Iterator<String> it = list.descendingIterator(); 
        //printing the elements of list in reverse order 
        while (it.hasNext()){
            System.out.println(it.next());
        }

    // To reverse a list in a stream, you can use the reduce method with a LinkedList or an ArrayList in Java. 
    // Here is an example code snippet using a LinkedList:
        
    // This code will reverse the list using the reduce method in a stream and then print out both the original and reversed lists. 
    // You can modify the code to use an ArrayList instead of a LinkedList if needed.
      LinkedList<String> reversedList = list.stream()
                .reduce(new LinkedList<>(), (result, element) -> {
                    result.addFirst(element);
                    return result;
                }, (result1, result2) -> {
                    result1.addAll(result2);
                    return result1;
                });
        
        System.out.println("Original List: " + list);
        System.out.println("Reversed List: " + reversedList);
        
        
      LinkedList<Integer> list1 = new LinkedList<>();
      list1.add(1);
      list1.add(2);
      list1.add(3);
      
      LinkedList<Integer> reversedList1 = list1.stream()
              .reduce(new LinkedList<>(), (result, element) -> {
                  result.addFirst(element);
                  return result;
              }, (result1, result2) -> {
                  result1.addAll(result2);
                  return result1;
              });
      
      System.out.println("Original Integer List: " + list1);
      System.out.println("Reversed Integer List: " + reversedList1);
    }
}
```
