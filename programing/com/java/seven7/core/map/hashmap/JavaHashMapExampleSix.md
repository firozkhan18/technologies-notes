# com\java\seven7\core\map\hashmap\JavaHashMapExampleSix.java

```java
package com.java.seven7.core.map.hashmap;

//6) How do you find out the number of key-value mappings present in a HashMap?
//
//Using size() method.

import java.util.HashMap;
 
public class JavaHashMapExampleSix 
{    
    public static void main(String[] args) 
    {
        //Creating the HashMap 
         
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
         
        //Adding key-value pairs to HashMap
         
        map.put(111, 111.111);
         
        map.put(222, 222.222);
         
        map.put(333, 333.333);
         
        map.put(444, 444.444);
         
        map.put(555, 555.555);
         
        //Retrieving the number of key-value pairs present in map
         
        System.out.println(map.size());      //Output : 5
    }   
}
```
