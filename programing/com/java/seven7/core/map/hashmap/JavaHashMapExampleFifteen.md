# com\java\seven7\core\map\hashmap\JavaHashMapExampleFifteen.java

```java
package com.java.seven7.core.map.hashmap;

//15) How do you get synchronized HashMap in java?
//
//Using Collections.synchronizedMap() method.

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
  
public class JavaHashMapExampleFifteen 
{    
    public static void main(String[] args) 
    {
        //Creating the HashMap 
         
        HashMap<String, Integer> map = new HashMap<String, Integer>();
         
        //Getting synchronized Map
         
        Map<String, Integer> syncMap = Collections.synchronizedMap(map);
    }   
}
```
