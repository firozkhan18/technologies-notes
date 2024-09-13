# com\java\eight8\array\CommonElements.java

```java
package com.java.eight8.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//How do you find the intersection of two arrays in Java?
//Below is the code to find the common elements or intersection of two arrays in Java.

public class CommonElements
{
    public static void main(String[] args)
    {
    	//1) Using Iterative Method
    	//we iterate both the given arrays and compare each element of one array with elements of other array. 
    	//If the elements are found to be equal, we will add that element into HashSet. 
    	//This method also works for those arrays which contain duplicate elements.
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
        
       // 2) Using retainAll() Method :
       //This is one of the easiest method to find the common elements from two arrays. 
       //In this method, we create two HashSets using given two arrays and then use reatinAll() method of HashSet to retain only common elements from the two sets.
        
        Integer[] i1 = {1, 2, 3, 4, 5, 4};        
        Integer[] i2 = {3, 4, 5, 6, 7, 4};
 
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(i1)); 
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(i2));
 
        set1.retainAll(set2);
 
        System.out.println(set1);     //Output : [3, 4, 5]
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        HashSet<Integer> set3 = new HashSet<>();

        for(int i=0; i<arr1.length; i++) {
            set3.add(arr1[i]);
        }

        System.out.print("Common elements in the two arrays: ");
        for(int i=0; i<arr2.length; i++) {
            if(set3.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
            }
        }
        
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        List<Integer> commonElements = Arrays.stream(array1)
                .filter(i -> Arrays.stream(array2).anyMatch(j -> j == i))
                .boxed()
                .collect(Collectors.toList());
        
        System.out.print("Common elements in the two arrays: "+commonElements);
   }
}	
```
