# com\java\seven7\core\map\sorting\SortMapByKeys.java

```java
package com.java.seven7.core.map.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//How To Sort HashMap By Keys Using TreeMap (Before Java 8)?
//One of the easiest and traditional method of sorting HashMap is that inserting HashMap elements into TreeMap. It will sort the elements according to supplied Comparator or in natural order if no Comparator is supplied.

//Sorting HashMap according to natural order of keys using TreeMap without Comparator :
public class SortMapByKeys
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap = new TreeMap<>(studentMap);
                 
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
