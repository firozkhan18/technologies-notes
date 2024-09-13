# com\java\eight8\arraylist\RetrieveAnElementFromAParticularPositionOfAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you retrieve an element from a particular position of an ArrayList?
//
//get() method returns an element from a specified position of an ArrayList. This method takes index of the element as an argument.

public class RetrieveAnElementFromAParticularPositionOfAnArrayList
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
 
        list.add(111);
 
        list.add(222);
 
        list.add(333);
 
        list.add(444);
 
        System.out.println(list);     //Output : [111, 222, 333, 444]
 
        //Getting element at index 3
 
        System.out.println(list.get(3));    //Output : 444
 
        //Getting element at index 1
 
        System.out.println(list.get(1));    //Output : 222
    }
}
```
