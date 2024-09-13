# com\java\eight8\array\EqualityOfTwoArrays.java

```java
package com.java.eight8.array;

import java.util.Arrays;

//Write a Java program to check the equality of two arrays?


public class EqualityOfTwoArrays
{
    public static void main(String[] args)
    {   
    	//First Method : Using Iterative Method
//    	first we check length of two given arrays. 
//    	If the length of both arrays is same, then we compare corresponding pairs of elements of both the arrays. 
//    	If all corresponding pairs of elements are equal, then given arrays will be considered as equal. 
//    	This method will be time consuming if the arrays have lots of elements. 
//    	This method is not recommended to check the equality of two arrays if the arrays are big in size. 
//    	But in the interview, interviewer may ask you to compare two arrays without using in-built functions. 
//    	In that time, this method may help you.
        int[] arrayOne = {2, 5, 1, 7, 4};          
        int[] arrayTwo = {2, 5, 1, 7, 4};
          
        boolean equalOrNot = true;
          
        if(arrayOne.length == arrayTwo.length)
        {
            for (int i = 0; i < arrayOne.length; i++)
            {
                if(arrayOne[i] != arrayTwo[i])
                {
                    equalOrNot = false;
                }
            }
        }
        else
        {
            equalOrNot = false;
        }
          
        if (equalOrNot)
        {
            System.out.println("Two Arrays Are Equal");
        }
        else
        {
            System.out.println("Two Arrays Are Not equal");
        }
        
        //Second Method : Using Arrays.equals() Method
		// Using Arrays.equals() Method :
		// In this method, we use in-built equals() method of Arrays class to check the equality of two arrays. 
		// This method takes two arrays as parameters and returns true if both the arrays have same number of elements and corresponding pairs of elements of both arrays are equal.
        String[] s1 = {"java", "j2ee", "struts", "hibernate"};        
        String[] s2 = {"jsp", "spring", "jdbc", "hibernate"};
        String[] s3 = {"java", "j2ee", "struts", "hibernate"};
        System.out.println(Arrays.equals(s1, s2));      //Output : false
        System.out.println(Arrays.equals(s1, s3));      //Output : true
        
		// If you want to compare two arrays which have same number of elements and same set of elements 
		// but in different positions, 
		// then first sort both arrays using Arrays.sort() method and then compare using Arrays.equals() method.
        String[] s4 = {"java", "swings", "j2ee", "struts", "jsp", "hibernate"};        
        String[] s5 = {"java", "struts", "j2ee", "hibernate", "swings", "jsp"}; 
        Arrays.sort(s4); 
        Arrays.sort(s5); 
        System.out.println(Arrays.equals(s4, s5));       //Output : true
        
        //Using Arrays.deepEquals() Method :
        //If you are checking multidimensional arrays for equality, then use deepEquals() method of Arrays class instead of equals() method. 
        //Because, deepEquals() performs deep comparison of both the arrays.
        
        String[][] s6 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} };        
        String[][] s7 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} }; 
        System.out.println(Arrays.deepEquals(s6, s7));     //Output : true         
        //Calling equals() method on same arrays will return false         
        System.out.println(Arrays.equals(s6, s7));        //Output : false         
        //That's why use deepEquals() method to compare multidimensional arrays
    }    
    
}
```
