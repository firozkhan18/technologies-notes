# com\java\seven7\core\map\hashmap\JavaHashMapExampleEleven.java

```java
package com.java.seven7.core.map.hashmap;

//11) How do you remove a key-value pair from the HashMap?

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
 
public class JavaHashMapExampleEleven 
{    
    public static void main(String[] args) 
    {
        //Creating the HashMap 
         
        HashMap<String, String> map = new HashMap<String, String>();
         
        //Adding key-value pairs to HashMap
         
        map.put("ONE", "AAA");
         
        map.put("TWO", "BBB");
         
        map.put("THREE", "CCC");
         
        map.put("FOUR", "DDD");
         
        map.put("FIVE", "EEE");
         
        //Printing key-value pairs
         
        System.out.println("HashMap Before Remove :");
         
        Set<Entry<String, String>> keyValueSet = map.entrySet();
         
        for (Entry<String, String> entry : keyValueSet) 
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
         
        System.out.println("---------------------");
         
        //Removing the mapping for the key 'ONE'
         
        map.remove("ONE");
         
        System.out.println("HashMap After Remove :");
         
        for (Entry<String, String> entry : keyValueSet) 
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }   
}
```
