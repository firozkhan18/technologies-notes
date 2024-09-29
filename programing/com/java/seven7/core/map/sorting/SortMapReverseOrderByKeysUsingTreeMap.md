# com\java\seven7\core\map\sorting\SortMapReverseOrderByKeysUsingTreeMap.java

```java
package com.java.seven7.core.map.sorting;

//Sorting HashMap in natural reverse order of keys using TreeMap with Comparator :
//
//The following program sorts HashMap in natural reverse order of keys by passing Collections.reverseOrder() to TreeMap

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class SortMapReverseOrderByKeysUsingTreeMap
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
                 
        Map<String, Integer> sortedStudentMap = new TreeMap<>(Collections.reverseOrder());
                 
        sortedStudentMap.putAll(studentMap);
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
