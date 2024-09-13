# com\java\seven7\core\map\sorting\SortMapByKeyInDecreasingOrderOfLengthOfKeys2InJava8.java

```java
package com.java.seven7.core.map.sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
//To sort the same HashMap in decreasing order of length of keys, use either Collections.reverseOrder() or else return o2.length() - o1.length() instead of o1.length() - o2.length() as in the below program.
public class SortMapByKeyInDecreasingOrderOfLengthOfKeys2InJava8
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
                 
        Map<String, Integer> sortedStudentMap 
                                = studentMap.entrySet()
                                            .stream()
                                            //.sorted(Entry.comparingByKey((o1, o2) -> o2.length() - o1.length()))
                                                           
                                         //  OR
                                          .sorted(Collections.reverseOrder(Entry.comparingByKey((o1, o2) -> o1.length() - o2.length())))
                                             
                                            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
