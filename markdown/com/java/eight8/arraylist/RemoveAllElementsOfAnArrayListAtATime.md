# com\java\eight8\arraylist\RemoveAllElementsOfAnArrayListAtATime.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you remove all elements of an ArrayList at a time?
//
//clear() method removes all elements of an ArrayList. ArrayList will be empty after this method is executed.

public class RemoveAllElementsOfAnArrayListAtATime
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
 
        list.add("AAA");
 
        list.add("BBB");
 
        list.add("AAA");
 
        list.add("CCC");
 
        list.add("BBB");
 
        System.out.println(list);     //Output : [AAA, BBB, AAA, CCC, BBB]
 
        //Removing all elements of the list
 
        list.clear();
 
        System.out.println(list);    //Output : []
    }
}
```
