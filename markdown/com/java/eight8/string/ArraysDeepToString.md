# com\java\eight8\string\ArraysDeepToString.java

```java
package com.java.eight8.string;

import java.util.Arrays;

//java.util.Arrays class has many useful methods to perform the operations on the arrays. deepToString() method is one such method. Arrays.deepToString() method is used to get the string representation of multidimensional arrays. This method returns the deep contents of the specified array. If the specified array contains other arrays as it’s elements then it returns the contents of those arrays also.
//
//
//
//Below example shows how to use deepToString() method to print the contents of the multidimensional arrays.

public class ArraysDeepToString
{
    public static void main(String[] args)
    {
        //One Dimensional Array
 
        String[] oneDArray = new String[] {"ONE", "TWO", "THREE", "FOUR", "FIVE"};
 
        System.out.println("One Dimensional Array : ");
 
        //Printing one dimensional array contents using deepToString() method
 
        System.out.println(Arrays.deepToString(oneDArray));
 
        //Two Dimensional Array
 
        String[][] twoDArray = new String[][] {
                                                    {"ONE", "TWO", "THREE", "FOUR"},
                                                    {"FIVE", "SIX", "SEVEN"},
                                                    {"EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE"}
                                                };
 
        System.out.println("Two Dimensional Array : ");
 
        //Printing two dimensional array contents using deepToString() method
 
        System.out.println(Arrays.deepToString(twoDArray));
 
        //Three Dimensional Array
 
        String[][][] threeDArray = new String[][][] {
                                                        {
                                                            {"ONE", "TWO", "THREE"},
                                                            {"FOUR", "FIVE", "SIX", "SEVEN"}
                                                        },
                                                        {
                                                            {"EIGHT", "NINE", "TEN", "ELEVEN"},
                                                            {"TWELVE", "THIRTEEN", "FOURTEEN"}
                                                        },
                                                        {
                                                            {"FIFTEEN", "SIXTEEN"} ,
                                                            {"SEVENTEEN", "EIGHTEEN", "NINETEEN"},
                                                            {"TWENTY", "TWENTY ONE"}
                                                        }
                                                    };
 
        System.out.println("Three Dimensional Array : ");
 
        //Printing three dimensional array contents using deepToString() method
 
        System.out.println(Arrays.deepToString(threeDArray));
    }
}
//If you want to print the contents of one dimensional arrays, then use Arrays.toString() method or normal for loop or enhanced for loop. You can also use Arrays.deepToString() method to print the contents of one dimensional arrays. But, If you want to print the contents of multidimensional arrays, instead of nesting multiple for loops, use Arrays.deepToString() method. It is the easiest method to print the contents of multidimensional arrays.
```
