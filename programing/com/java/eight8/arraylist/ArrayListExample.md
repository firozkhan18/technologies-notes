# com\java\eight8\arraylist\ArrayListExample.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {

    public static void main(String[] args) {
        // Initialize an ArrayList in Java
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Add elements to the ArrayList
        arrayList.add(1);
        arrayList.add(2);
        
        // Difference between ArrayList and LinkedList
        // ArrayList: Implemented as a resizable array, fast access
        // LinkedList: Implemented as a doubly linked list, fast element insertion and deletion
        
        // Add an element to an ArrayList
        arrayList.add(3);
        
        // Remove an element from an ArrayList
        arrayList.remove(Integer.valueOf(2));
        
        // Iterate over an ArrayList
        for (int num : arrayList) {
            System.out.println(num);
        }
        
        // Check if an element exists in an ArrayList
        System.out.println(arrayList.contains(3));
        
        // Sort an ArrayList
        Collections.sort(arrayList);
        
        // Reverse an ArrayList
        Collections.reverse(arrayList);
        
        // Copy elements from one ArrayList to another
        ArrayList<Integer> newArray = new ArrayList<>(arrayList);
        
        // Find the index of an element in an ArrayList
        int index = arrayList.indexOf(1);
        System.out.println("Index of 1: " + index);
    }
}
```
