# com\java\eight8\arraylist\FindOutWhetherTheGivenArrayListIsEmptyOrNot.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you find out whether the given ArrayList is empty or not?
//
//isEmpty() method of ArrayList is used to check whether the given ArrayList is empty or not. This method returns true if an ArrayList contains no elements otherwise returns false.

public class FindOutWhetherTheGivenArrayListIsEmptyOrNot
{
    public static void main(String[] args)
    {
        ArrayList<Double> list = new ArrayList<Double>();
 
        System.out.println(list.isEmpty());    //Output : true
    }
}
//Note : You can also use size() method to check whether the given ArrayList is empty or not. size() method returns ‘0’ if an ArrayList is empty.
```
