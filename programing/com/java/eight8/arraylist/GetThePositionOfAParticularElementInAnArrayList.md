# com\java\eight8\arraylist\GetThePositionOfAParticularElementInAnArrayList.java

```java
package com.java.eight8.arraylist;

import java.util.ArrayList;

//How do you get the position of a particular element in an ArrayList?
//
//We can use indexOf() and lastIndexOf() methods to find out the position of a given element in an ArrayList. indexOf() method returns index of first occurrence of a specified element where as lastIndexOf() method returns index of last occurrence of a specified element in an ArrayList. If element is not found, they will return -1.

public class GetThePositionOfAParticularElementInAnArrayList
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
 
        list.add("JAVA");
 
        list.add("J2EE");
 
        list.add("JSP");
 
        list.add("JAVA");
 
        list.add("SERVLETS");
 
        list.add("JAVA");
 
        list.add("STRUTS");
 
        System.out.println(list);     //Output : [JAVA, J2EE, JSP, JAVA, SERVLETS, JAVA, STRUTS]
 
        //Getting the index of first occurrence of "JAVA"
 
        System.out.println(list.indexOf("JAVA"));     //Output : 0
 
        //Getting the index of last occurrence of "JAVA"
 
        System.out.println(list.lastIndexOf("JAVA"));    //Output : 5
    }
}
```
