# com\java\eight8\arraylist\WaysOfConstructingAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//1) Explain the different ways of constructing an ArrayList?
//
//
//ArrayList can be created in 3 ways.
//
//a) ArrayList() —> It creates an empty ArrayList with initial capacity of 10.
//
//b) ArrayList(int initialCapacity) —> It creates an empty ArrayList with supplied initial capacity.
//
//c) ArrayList(Collection c) —> It creates an ArrayList containing the elements of the supplied collection.

public class WaysOfConstructingAnArrayList
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();            //First Method
 
        ArrayList<String> list2 = new ArrayList<String>(20);         //Second Method
 
        ArrayList<Integer> list3 = new ArrayList<Integer>(list1);      //Third Method
    }
}

```
