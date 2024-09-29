# com\java\eight8\arraylist\AppendAnElementAtTheEndOfAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you append an element at the end of an ArrayList?
//
//add() method appends an element at the end of an ArrayList.

public class AppendAnElementAtTheEndOfAnArrayList
{
   public static void main(String[] args)
   {
       ArrayList<String> list = new ArrayList<String>();

       list.add("ONE");

       list.add("TWO");

       list.add("THREE");

       list.add("FOUR");

       System.out.println(list);     //Output : [ONE, TWO, THREE, FOUR]
   }
}
```
