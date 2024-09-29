# com\java\eight8\arraylist\IncreaseTheCurrentCapacityOfAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you increase the current capacity of an ArrayList?
//
//ensureCapacity() method is used to increase the current capacity of an ArrayList. However, capacity of an ArrayList is automatically increased when we try to add more elements than the current capacity. To manually increase the current capacity, ensureCapacity() method is used.

public class IncreaseTheCurrentCapacityOfAnArrayList
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
 
        //Now 'list' can hold 10 elements (Default Initial Capacity)
 
        list.ensureCapacity(20);
 
        //Now 'list' can hold 20 elements.
    }
}
```
