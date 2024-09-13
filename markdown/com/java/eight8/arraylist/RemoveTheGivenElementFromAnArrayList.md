# com\java\eight8\arraylist\RemoveTheGivenElementFromAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you remove the given element from an ArrayList?
//
//remove(Object obj) method removes the first occurrence of the specified element ‘obj‘. If that element doesn’t exist, ArrayList will be unchanged.

public class RemoveTheGivenElementFromAnArrayList
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
 
        //Removing first occurrence of "AAA"
 
        list.remove("AAA");
 
        System.out.println(list);    //Output : [BBB, AAA, CCC, BBB]
 
        //Removing first occurrence of "BBB"
 
        list.remove("BBB");
 
        System.out.println(list);   //Output : [AAA, CCC, BBB]
    }
}
```
