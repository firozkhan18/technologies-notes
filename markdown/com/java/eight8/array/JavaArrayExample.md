# com\java\eight8\array\JavaArrayExample.java

```java
package com.java.eight8.array;

import java.util.Arrays;

//How do you sort the array elements?
//
//You can sort the array elements using Arrays.sort() method. 
//This method internally uses quick sort algorithm to sort the array elements.
public class JavaArrayExample
{
    public static void main(String[] args)
    {
        int[] a = new int[]{45, 12, 78, 34, 89, 21};
 
        Arrays.sort(a);
 
        System.out.println(Arrays.toString(a));
 
        //Output : [12, 21, 34, 45, 78, 89]
    }
}
```
