[Go Back To - Java Exercises Collection](java-basic-exercises-020-Collection.md)

# TreeMap:

In Java, TreeMap is an implementation of the SortedMap interface provided by the Java Collections Framework. It's part of the java.util package.

### 1. Write a Java program to associate the specified value with the specified key in a Tree Map.
```java
import java.util.*;  
public class Example1 {  
  public static void main(String args[]){  
   // Create a tree map
   TreeMap<Integer,String> tree_map=new TreeMap<Integer,String>();      
  // Put elements to the map 
  tree_map.put(1, "Red");
  tree_map.put(2, "Green");
  tree_map.put(3, "Black");
  tree_map.put(4, "White");
  tree_map.put(5, "Blue");
    
   for (Map.Entry<Integer,String> entry : tree_map.entrySet())
   {
    System.out.println(entry.getKey() + "=>" + entry.getValue());
   }
 }  
}
```
Sample Output:

1=>Red                                                                 
2=>Green                                                               
3=>Black                                                               
4=>White                                                               
5=>Blue

### 2. Write a Java program to copy Tree Map's content to another Tree Map.
```java
import java.util.*;  
public class Example2 {  
   public static void main(String args[]){  
  
  // Create a tree map
   TreeMap<String,String> tree_map1=new TreeMap<String,String>();      
  
  // Put elements to the map 
  tree_map1.put("C1", "Red");
  tree_map1.put("C2", "Green");
  tree_map1.put("C3", "Black");
  tree_map1.put("C4", "White");
  tree_map1.put("C5", "Blue");
   System.out.println("Tree Map 1: "+tree_map1);
   TreeMap<String,String> tree_map2 = new TreeMap<String,String>();
   tree_map2.put("A1", "Orange");
   tree_map2.put("A2", "Pink");
   System.out.println("Tree Map 2: "+tree_map2);
   tree_map1.putAll(tree_map2);
   System.out.println("After coping map2 to map1: "+tree_map1);   
 }  
}
```
Sample Output:

Tree Map 1: {C1=Red, C2=Green, C3=Black, C4=White, C5=Blue}            
Tree Map 2: {A1=Orange, A2=Pink}                                       
After coping map2 to map1: {A1=Orange, A2=Pink, C1=Red, C2=Green, C3=Bl
ack, C4=White, C5=Blue}

### 3. Write a Java program to search for a key in a Tree Map.
```java
import java.util.*;  
public class Example3 {  
   public static void main(String args[]){  
  
  // Create a tree map
   TreeMap<String,String> tree_map1=new TreeMap<String,String>();      
  
  // Put elements to the map 
  tree_map1.put("C1", "Red");
  tree_map1.put("C2", "Green");
  tree_map1.put("C3", "Black");
  tree_map1.put("C4", "White"); 
    
  System.out.println(tree_map1);
        if(tree_map1.containsKey("C1")){
            System.out.println("The Tree Map contains key C1");
        } else {
            System.out.println("The Tree Map does not contain key C1");
        }
        if(tree_map1.containsKey("C5")){
            System.out.println("The Tree Map contains key C5");
        } else {
            System.out.println("The TreeMap does not contain key C5");
        }
    }
}
```
Sample Output:

{C1=Red, C2=Green, C3=Black, C4=White}                                 
The Tree Map contains key C1                                           
The TreeMap does not contain key C5

### 4. Write a Java program to search for a value in a Tree Map.
```java
import java.util.*;  
public class Example4 {  
   public static void main(String args[]){  
  
  // Create a tree map
   TreeMap<String,String> tree_map1=new TreeMap<String,String>();      
  
  // Put elements to the map 
  tree_map1.put("C1", "Red");
  tree_map1.put("C2", "Green");
  tree_map1.put("C3", "Black");
  tree_map1.put("C4", "White"); 
    
 if(tree_map1.containsValue("Green")){
            System.out.println("The TreeMap contains value Green");
        } else {
            System.out.println("The TreeMap does not contain value Green");
        }
        if(tree_map1.containsValue("Pink")){
            System.out.println("The TreeMap contains value Pink");
        } else {
            System.out.println("The TreeMap does not contain value Pink");
        }
    }
}
```
Sample Output:

The TreeMap contains value Green                                       
The TreeMap does not contain value Pink

### 5. Write a Java program to get all keys from a Tree Map.
```java
import java.util.*;  
public class Example5 {  
   public static void main(String args[]){  
   // Create a tree map
   TreeMap<String,String> tree_map1=new TreeMap<String,String>();      
   // Put elements to the map 
  tree_map1.put("C1", "Red");
  tree_map1.put("C2", "Green");
  tree_map1.put("C3", "Black");
  tree_map1.put("C4", "White"); 
    
 Set<String> keys = tree_map1.keySet();
        for(String key: keys){
            System.out.println(key);
        }
    }
}
```
Sample Output:

C1                                                                     
C2                                                                     
C3                                                                     
C4

### 6. Write a Java program to delete all elements from a Tree Map.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example6 {  
    public static void main(String args[]){  
    // Create a tree map
   TreeMap<String,String> tree_map1 = new TreeMap<String,String>();      
    // Put elements to the map 
  tree_map1.put("C1", "Red");
  tree_map1.put("C2", "Green");
  tree_map1.put("C3", "Black");
  tree_map1.put("C4", "White"); 
    
  System.out.println("Orginal TreeMap content: "+tree_map1);
  tree_map1.clear();
  System.out.println("The New map: "+tree_map1);
 }
}
```
Sample Output:

Orginal TreeMap content: {C1=Red, C2=Green, C3=Black, C4=White}        
The New map: {}

### 7. Write a Java program to sort keys in a Tree Map by using a comparator.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example7 {  
    public static void main(String args[]){  
  TreeMap<String,String> tree_map1 = new TreeMap<String,String>(new sort_key());
   // Put elements to the map 
  tree_map1.put("C2", "Red");
  tree_map1.put("C4", "Green");
  tree_map1.put("C3", "Black");
  tree_map1.put("C1", "White"); 
  System.out.println(tree_map1); 
    }
}
 class sort_key implements Comparator<String>{
     @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
     
}
```
Sample Output:

{C1=White, C2=Red, C3=Black, C4=Green} 

### 8. Write a Java program to get a  key-value mapping associated with the greatest key and the least key in a map.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example8 {  
     public static void main(String args[]) {

  // Create a tree map
  TreeMap <String,String> tree_map1 = new TreeMap <String,String> ();

  // Put elements to the map 
  tree_map1.put("C1", "Red");
  tree_map1.put("C2", "Green");
  tree_map1.put("C3", "Black");
  tree_map1.put("C4", "White");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Greatest key: " + tree_map1.firstEntry());
  System.out.println("Least key: " + tree_map1.lastEntry());
 }
}
```
Sample Output:

Orginal TreeMap content: {C1=Red, C2=Green, C3=Black, C4=White}        
Greatest key: C1=Red                                                   
Least key: C4=White 

### 9. Write a Java program to get the first (lowest) key and the last (highest) key currently in a map.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example9 {  
     public static void main(String args[]) {

  // Create a tree map
  TreeMap <String,String> tree_map1 = new TreeMap <String,String> ();

  // Put elements to the map 
  tree_map1.put("C2", "Red");
  tree_map1.put("C1", "Green");
  tree_map1.put("C4", "Black");
  tree_map1.put("C3", "White");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Greatest key: " + tree_map1.firstKey());
  System.out.println("Least key: " + tree_map1.lastKey());
 }
}
```
Sample Output:

Orginal TreeMap content: {C1=Green, C2=Red, C3=White, C4=Black}        
Greatest key: C1                                                       
Least key: C4

### 10. Write a Java program to get a reverse order view of the keys contained in a given map.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example10 {  
     public static void main(String args[]) {

  // Create a tree map
  TreeMap <String,String> tree_map1 = new TreeMap <String,String> ();

  // Put elements to the map 
  tree_map1.put("C2", "Red");
  tree_map1.put("C1", "Green");
  tree_map1.put("C4", "Black");
  tree_map1.put("C3", "White");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Reverse order view of the keys: " + tree_map1.descendingKeySet());
 }
}
```
Sample Output:

Orginal TreeMap content: {C1=Green, C2=Red, C3=White, C4=Black}        
Reverse order view of the keys: [C4, C3, C2, C1]

### 11. Write a Java program to get a  key-value mapping associated with the greatest key less than or equal to the given key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example11 {  
     public static void main(String args[]) {
  // Create a tree map
  TreeMap < Integer, String > tree_map1 = new TreeMap < Integer, String > ();
  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White");
  tree_map1.put(60, "Pink");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Checking the entry for 10: ");
  System.out.println("Value is: " + tree_map1.floorEntry(10));
  System.out.println("Checking the entry for 30: ");
  System.out.println("Value is: " + tree_map1.floorEntry(30));
  System.out.println("Checking the entry for 70: ");
  System.out.println("Value is: " + tree_map1.floorEntry(70));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Checking the entry for 10:                                             
Value is: 10=Red                                                       
Checking the entry for 30:                                             
Value is: 20=Green                                                     
Checking the entry for 70:                                             
Value is: 60=Pink

### 12. Write a Java program to get the greatest key less than or equal to the given key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example12 {  
      public static void main(String args[]) {
  // Create a tree map
  TreeMap < Integer, String > tree_map1 = new TreeMap < Integer, String > ();
  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White");
  tree_map1.put(60, "Pink");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Checking the entry for 10: ");
  System.out.println("Key is: " + tree_map1.floorKey(10));
  System.out.println("Checking the entry for 30: ");
  System.out.println("Key is: " + tree_map1.floorKey(30));
  System.out.println("Checking the entry for 70: ");
  System.out.println("Key is: " + tree_map1.floorKey(70));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Checking the entry for 10:                                             
Key is: 10                                                             
Checking the entry for 30:                                             
Key is: 20                                                             
Checking the entry for 70:                                             
Key is: 60

### 13. Write a Java program to get the portion of a map whose keys are strictly less than a given key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example13 {  
       public static void main(String args[]) {

  // Create a tree map
  TreeMap < Integer, String > tree_map1 = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White");
  tree_map1.put(60, "Pink");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Checking the entry for 10: ");
  System.out.println("Key(s): " + tree_map1.headMap(10));
  System.out.println("Checking the entry for 30: ");
  System.out.println("Key(s): " + tree_map1.headMap(30));
  System.out.println("Checking the entry for 70: ");
  System.out.println("Key(s): " + tree_map1.headMap(70));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Checking the entry for 10:                                             
Key(s): {}                                                             
Checking the entry for 30:                                             
Key(s): {10=Red, 20=Green}                                             
Checking the entry for 70:                                             
Key(s): {10=Red, 20=Green, 40=Black, 50=White, 60=Pink}

### 14. Write a Java program to get the portion of this map whose keys are less than (or equal to, if inclusive is true) a given key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example14 {  
       public static void main(String args[]) {

  // Create a tree map
  TreeMap < Integer, String > tree_map1 = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White");
  tree_map1.put(60, "Pink");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Checking the entry for 10: ");
  System.out.println("Key(s): " + tree_map1.headMap(10, true));
  System.out.println("Checking the entry for 20: ");
  System.out.println("Key(s): " + tree_map1.headMap(20, true));
  System.out.println("Checking the entry for 70: ");
  System.out.println("Key(s): " + tree_map1.headMap(70, true));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Checking the entry for 10:                                             
Key(s): {10=Red}                                                       
Checking the entry for 20:                                             
Key(s): {10=Red, 20=Green}                                             
Checking the entry for 70:                                             
Key(s): {10=Red, 20=Green, 40=Black, 50=White, 60=Pink}

### 15. Write a Java program to get the least key strictly greater than the given key. Return null if there is no such key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example15 {  
       public static void main(String args[]){  
  
    // Create a tree map
   TreeMap< Integer, String > tree_map1 = new TreeMap< Integer, String >();      
  
  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White"); 
  tree_map1.put(60, "Pink"); 
    
      System.out.println("Orginal TreeMap content: "+tree_map1);
	  System.out.println("Checking the entry for 10: ");
      System.out.println("Key(s): "+tree_map1.higherEntry(10));  
	  System.out.println("Checking the entry for 20: ");
      System.out.println("Key(s): "+tree_map1.higherEntry(20));  
	  System.out.println("Checking the entry for 70: ");
      System.out.println("Key(s): "+tree_map1.higherEntry(70));  
    }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Checking the entry for 10:                                             
Key(s): 20=Green                                                       
Checking the entry for 20:                                             
Key(s): 40=Black                                                       
Checking the entry for 70:                                             
Key(s): null

### 16. Write a Java program to get a  key-value mapping associated with the greatest key strictly less than the given key. Return null if there is no such key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example16 {  
       public static void main(String args[]){  
  
    // Create a tree map
   TreeMap< Integer, String > tree_map1 = new TreeMap< Integer, String >();      
  
  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White"); 
  tree_map1.put(60, "Pink"); 
    
      System.out.println("Orginal TreeMap content: "+tree_map1);
	  System.out.println("Checking the entry for 10: ");
      System.out.println("Key(s): "+tree_map1.lowerEntry(10));  
	  System.out.println("Checking the entry for 20: ");
      System.out.println("Key(s): "+tree_map1.lowerEntry(20));  
	  System.out.println("Checking the entry for 70: ");
      System.out.println("Key(s): "+tree_map1.lowerEntry(70));  
    }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Checking the entry for 10:                                             
Key(s): null                                                           
Checking the entry for 20:                                             
Key(s): 10=Red                                                         
Checking the entry for 70:                                             
Key(s): 60=Pink

### 17. Write a Java program to get the greatest key strictly less than the given key. Return null if there is no such key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example17 {  
         public static void main(String args[]) {

  // Create a tree map
  TreeMap < Integer, String > tree_map1 = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White");
  tree_map1.put(60, "Pink");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Checking the entry for 10: ");
  System.out.println("Key(s): " + tree_map1.lowerKey(10));
  System.out.println("Checking the entry for 20: ");
  System.out.println("Key(s): " + tree_map1.lowerKey(20));
  System.out.println("Checking the entry for 70: ");
  System.out.println("Key(s): " + tree_map1.lowerKey(70));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Checking the entry for 10:                                             
Key(s): null                                                           
Checking the entry for 20:                                             
Key(s): 10                                                             
Checking the entry for 70:                                             
Key(s): 60

### 18. Write a Java program to get a NavigableSet view of keys in a map.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example18 {  
         public static void main(String args[]) {

  // Create a tree map
  TreeMap < Integer, String > tree_map1 = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map1.put(10, "Red");
  tree_map1.put(20, "Green");
  tree_map1.put(40, "Black");
  tree_map1.put(50, "White");
  tree_map1.put(60, "Pink");

  System.out.println("Orginal TreeMap content: " + tree_map1);
  System.out.println("Orginal TreeMap content: " + tree_map1.navigableKeySet());

 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Orginal TreeMap content: [10, 20, 40, 50, 60]

### 19. Write a Java program to remove and get a  key-value mapping associated with the least key in a map.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example19 {  
         public static void main(String args[]) {

  // Create a tree map
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(40, "Black");
  tree_map.put(50, "White");
  tree_map.put(60, "Pink");

  // polling first entry
  System.out.println("Value before poll: " + tree_map);
  System.out.println("Value returned: " + tree_map.pollFirstEntry());
  System.out.println("Value after poll: " + tree_map);
 }
}
```
Sample Output:

Value before poll: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink}     
Value returned: 10=Red                                                 
Value after poll: {20=Green, 40=Black, 50=White, 60=Pink}

### 20. Write a Java program to remove and get a key-value mapping associated with the greatest key in this map.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example20 {  
          public static void main(String args[]) {

  // Create a tree map
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(40, "Black");
  tree_map.put(50, "White");
  tree_map.put(60, "Pink");

  // polling first entry
  System.out.println("Value before poll: " + tree_map);
  System.out.println("Value returned: " + tree_map.pollLastEntry());
  System.out.println("Value after poll: " + tree_map);
 }
}
```
Sample Output:

Value before poll: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink}     
Value returned: 60=Pink                                                
Value after poll: {10=Red, 20=Green, 40=Black, 50=White} 

### 21. Write a Java program to get the portion of a map whose keys range from a given key (inclusive) to another key (exclusive).
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example21 {  
          public static void main(String args[]) {

  // Declare tree maps
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();
  SortedMap < Integer, String > sub_tree_map = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(30, "Black");
  tree_map.put(40, "White");
  tree_map.put(50, "Pink");
  System.out.println("Orginal TreeMap content: " + tree_map);
  sub_tree_map = tree_map.subMap(20, 40);
  System.out.println("Sub map key-values: " + sub_tree_map);
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 30=Black, 40=White, 50=Pink
}                                                                      
Sub map key-values: {20=Green, 30=Black}
### 22. Write a Java program to get the portion of a map whose keys range from a given key to another key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example22 {  
           public static void main(String args[]) {

  // Declare tree maps
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();
  SortedMap < Integer, String > sub_tree_map = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(30, "Black");
  tree_map.put(40, "White");
  tree_map.put(50, "Pink");
  System.out.println("Orginal TreeMap content: " + tree_map);
  sub_tree_map = tree_map.subMap(20, true, 40, true);
  System.out.println("Sub map key-values: " + sub_tree_map);
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 30=Black, 40=White, 50=Pink
}                                                                      
Sub map key-values: {20=Green, 30=Black, 40=White}

### 23. Write a Java program to get a portion of a map whose keys are greater than or equal to a given key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example23 {  
           public static void main(String args[]) {

  // Declare tree maps
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(30, "Black");
  tree_map.put(40, "White");
  tree_map.put(50, "Pink");
  System.out.println("Orginal TreeMap content: " + tree_map);
  System.out.println("Keys are greater than or equal to 20: " + tree_map.tailMap(20));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 30=Black, 40=White, 50=Pink
}                                                                      
Keys are greater than or equal to 20: {20=Green, 30=Black, 40=White, 50
=Pink}

### 24. Write a Java program to get a portion of a map whose keys are greater than a given key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example24 {  
           public static void main(String args[]) {

  // Declare tree maps
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();

  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(30, "Black");
  tree_map.put(40, "White");
  tree_map.put(50, "Pink");
  System.out.println("Orginal TreeMap content: " + tree_map);
  System.out.println("Keys are greater than 20: " + tree_map.tailMap(20, false));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 30=Black, 40=White, 50=Pink
}                                                                      
Keys are greater than 20: {30=Black, 40=White, 50=Pink}

### 25. Write a Java program to get a  key-value mapping associated with the least key greater than or equal to the given key. Return null if there is no such key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example25 {  
           public static void main(String args[]) {
  // Declare tree maps
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();
  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(30, "Black");
  tree_map.put(40, "White");
  tree_map.put(50, "Pink");
  System.out.println("Orginal TreeMap content: " + tree_map);
  System.out.println("Keys greater than or equal to 20: " + tree_map.ceilingEntry(20));
  System.out.println("Keys greater than or equal to 40: " + tree_map.ceilingEntry(40));
  System.out.println("Keys greater than or equal to 50: " + tree_map.ceilingEntry(50));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 30=Black, 40=White, 50=Pink
}                                                                      
Keys greater than or equal to 20: 20=Green                             
Keys greater than or equal to 40: 40=White                             
Keys greater than or equal to 50: 50=Pink

### 26. Write a Java program to get the least key greater than or equal to the given key. Returns null if there is no such key.
```java
import java.util.*;
import java.util.Map.Entry;  
public class Example26 {  
          public static void main(String args[]) {
  // Declare tree maps
  TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();
  // Put elements to the map 
  tree_map.put(10, "Red");
  tree_map.put(20, "Green");
  tree_map.put(40, "Black");
  tree_map.put(50, "White");
  tree_map.put(60, "Pink");
  System.out.println("Orginal TreeMap content: " + tree_map);
  System.out.println("Keys greater than or equal to 20: " + tree_map.ceilingKey(20));
  System.out.println("Keys greater than or equal to 30: " + tree_map.ceilingKey(30));
  System.out.println("Keys greater than or equal to 50: " + tree_map.ceilingKey(50));
 }
}
```
Sample Output:

Orginal TreeMap content: {10=Red, 20=Green, 40=Black, 50=White, 60=Pink
}                                                                      
Keys greater than or equal to 20: 20                                   
Keys greater than or equal to 30: 40                                   
Keys greater than or equal to 50: 50 
