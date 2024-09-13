# com\java\eight8\arraylist\CheckWhetherTheGivenElementIsPresentInAnArrayListOrNot.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you check whether the given element is present in an ArrayList or not?
//
//Using contains() method of ArrayList, we can examine whether the ArrayList contains the given element or not. This method returns true if ArrayList has that element otherwise returns false.

public class CheckWhetherTheGivenElementIsPresentInAnArrayListOrNot
{
    public static void main(String[] args)
    {
        ArrayList<Double> list = new ArrayList<Double>();
 
        list.add(1.1);
 
        list.add(11.11);
 
        list.add(111.111);
 
        list.add(1111.1111);
 
        //Checking whether list conatins '111.1111'
 
        System.out.println(list.contains(111.1111));    //Output : false
    }
}
```
