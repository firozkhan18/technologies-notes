# com\java\eight8\arraylist\ConvertAnArrayListToArray.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you convert an ArrayList to Array?
//
//Using toArray() method of ArrayList class. toArray() method returns an array containing all elements of the ArrayList. This method acts as a bridge between normal arrays and collection framework in java.

public class ConvertAnArrayListToArray
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
 
        list.add("JAVA");
 
        list.add("J2EE");
 
        list.add("JSP");
 
        list.add("SERVLETS");
 
        list.add("STRUTS");
 
        System.out.println(list);      //Output : [JAVA, J2EE, JSP, SERVLETS, STRUTS]
 
        //getting an array containing all elements of the list.
 
        Object[] array = list.toArray();
 
        //Printing the elements of the returned array.
 
        for (Object object : array)
        {
            System.out.println(object);
        }
 
//      Output :
 
//      JAVA
//      J2EE
//      JSP
//      SERVLETS
//      STRUTS
    }
}
```
