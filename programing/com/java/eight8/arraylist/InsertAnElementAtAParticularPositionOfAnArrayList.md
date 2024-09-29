# com\java\eight8\arraylist\InsertAnElementAtAParticularPositionOfAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you insert an element at a particular position of an ArrayList?
//
//add() method which takes index and an element as arguments can be used to insert an element at a particular position of an ArrayList. The elements at the right side of that position are shifted one position right i.e indices of right side elements of that position are increased by 1.

public class InsertAnElementAtAParticularPositionOfAnArrayList
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
 
        list.add("ONE");
 
        list.add("TWO");
 
        list.add("THREE");
 
        list.add("FOUR");
 
        System.out.println(list);     //Output : [ONE, TWO, THREE, FOUR]
 
        //Inserting "AAA" at index 1
 
        list.add(1, "AAA");
 
        //Inserting "BBB" at index 3
 
        list.add(3, "BBB");
 
        System.out.println(list);    //Output : [ONE, AAA, TWO, BBB, THREE, FOUR]
    }
}
```
