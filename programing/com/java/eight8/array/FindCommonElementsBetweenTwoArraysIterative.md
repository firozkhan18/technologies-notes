# com\java\eight8\array\FindCommonElementsBetweenTwoArraysIterative.java

```java
package com.java.eight8.array;

import java.util.HashSet;

//This is also one of the most asked java interview program for freshers as well as for 1 or 2 years experienced java professionals. In this post, we will discuss couple of methods to find common elements between two arrays.
//1) Using Iterative Method

//In this method, we iterate both the given arrays and compare each element of one array with elements of other array. If the elements are found to be equal, we will add that element into HashSet. This method also works for those arrays which contain duplicate elements.
public class FindCommonElementsBetweenTwoArraysIterative {
	public static void main(String[] args)
    {
        String[] s1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
 
        String[] s2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};
 
        HashSet<String> set = new HashSet<String>();
 
        for (int i = 0; i < s1.length; i++)
        {
            for (int j = 0; j < s2.length; j++)
            {
                if(s1[i].equals(s2[j]))
                {
                    set.add(s1[i]);
                }
            }
        }
 
        System.out.println(set);     //OUTPUT : [THREE, FOUR, FIVE]
    }
}
```
