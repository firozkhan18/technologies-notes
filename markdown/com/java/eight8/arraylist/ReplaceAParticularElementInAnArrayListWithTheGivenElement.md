# com\java\eight8\arraylist\ReplaceAParticularElementInAnArrayListWithTheGivenElement.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you replace a particular element in an ArrayList with the given element?
//
//set() method replaces a particular element in an Arraylist with the given element. This method takes two arguments. One is the index of the element to be replaced and another one is the element to be placed at that position.

public class ReplaceAParticularElementInAnArrayListWithTheGivenElement
{
   public static void main(String[] args)
   {
       ArrayList<Integer> list = new ArrayList<Integer>();

       list.add(111);

       list.add(222);

       list.add(333);

       list.add(444);

       System.out.println(list);     //Output : [111, 222, 333, 444]

       //Replacing the element at index 1 with '000'

       list.set(1, 000);

       //Replacing the element at index 3 with '000'

       list.set(3, 000);

       System.out.println(list);   //Output : [111, 0, 333, 0]
   }
}
```
