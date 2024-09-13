# com\java\seven7\core\map\hashmap\JavaHashMapExampleFourteen.java

```java
package com.java.seven7.core.map.hashmap;

//14) How do you replace a value associated with the given key if and only if it is currently mapped to given value?
//
//Another version of replace() method which takes three arguments, replaces the value associated with the given key only if it is currently mapped to given value.

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
 
public class JavaHashMapExampleFourteen 
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
         
        //Printing Key-value pairs
         
        System.out.println("HashMap Before Replace :");
                 
        Set<Entry<String, String>> keyValueSet = map.entrySet();
                 
        for (Entry<String, String> entry : keyValueSet) 
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
                 
        System.out.println("------------------");
         
        //Replacing the value associated with 'FOUR' to '444' only if it is currently mapped to 'DDD'
         
        map.replace("FOUR", "DDD", "444");
         
        System.out.println("HashMap After Replace :");
                 
        for (Entry<String, String> entry : keyValueSet) 
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }   
}
```
