[Go Back To - Java Exercises Collection](java-basic-exercises-020-Collection.md)

# HashSet:

In Java, HashSet is an implementation of the Set interface provided by the Java Collections Framework. It's part of the java.util package.

### 1. Write a Java program to append the specified element to the end of a hash set.
```java
import java.util.HashSet;
  public class Exercise1 {
  public static void main(String[] args) {
     // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");

   // print the hash set
   System.out.println("The Hash Set: " + h_set);
   }
}
```
Sample Output:

The Hash Set: [Red, White, Pink, Yellow, Black, Green]

### 2. Write a Java program to iterate through all elements in a hash list.
```java
import java.util.*;
import java.util.Iterator;
  public class Exercise2 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");

  // set Iterator 
    Iterator<String> p = h_set.iterator();
  // Iterate the hash set
   while (p.hasNext()) {
   System.out.println(p.next());
   }
   }
}
```
Sample Output:

Red                                                                    
White                                                                  
Pink                                                                   
Yellow                                                                 
Black                                                                  
Green

### 3. Write a Java program to get the number of elements in a hash set.
```java
import java.util.*;
import java.util.Iterator;
  public class Exercise3 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");
    System.out.println("Original Hash Set: " + h_set);
    System.out.println("Size of the Hash Set: " + h_set.size());
   }
}
```
Sample Output:

Original Hash Set: [Red, White, Pink, Yellow, Black, Green]            
Size of the Hash Set: 6 

### 4. Write a Java program to empty an hash set.
```java
import java.util.*;

  public class Exercise4 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");
    System.out.println("Original Hash Set: " + h_set);
    // Remove all elements
    h_set.removeAll(h_set);
    System.out.println("Hash Set after removing all the elements "+h_set);   
   }
}
```
Sample Output:

Original Hash Set: [Red, White, Pink, Yellow, Black, Green]            
Hash Set after removing all the elements [] 

### 5. Write a Java program to test if a hash set is empty or not.
```java
import java.util.*;

  public class Exercise5 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");
    System.out.println("Original Hash Set: " + h_set);
    System.out.println("Checking the above array list is empty or not! "+h_set.isEmpty());
    System.out.println("Remove all the elements from a Hash Set: ");
    h_set.removeAll(h_set);
    System.out.println("Hash Set after removing all the elements "+h_set);   
   }
}
```
Sample Output:

Original Hash Set: [Red, White, Pink, Yellow, Black, Green]            
Checking the above array list is empty or not! false                   
Remove all the elements from a Hash Set:                               
Hash Set after removing all the elements [] 
### 6. Write a Java program to clone a hash set to another hash set.
```java
import java.util.*;

  public class Exercise6 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");
    System.out.println("Original Hash Set: " + h_set);
    HashSet <String> new_h_set = new HashSet <String> ();
          new_h_set = (HashSet)h_set.clone();
          System.out.println("Cloned Hash Set: " + new_h_set);         
   }
}
```
Sample Output:

Note: Exercise6.java uses unchecked or unsafe operations.              
Note: Recompile with -Xlint:unchecked for details.                     
Original Hash Set: [Red, White, Pink, Yellow, Black, Green]            
Cloned Hash Set: [Red, White, Pink, Yellow, Black, Green] 

### 7. Write a Java program to convert a hash set to an array.
```java
import java.util.*;
  public class Exercise7 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");
      System.out.println("Original Hash Set: " + h_set);
      // Creating an Array
      String[] new_array = new String[h_set.size()];
      h_set.toArray(new_array);
 
     // Displaying Array elements
     System.out.println("Array elements: ");
      for(String element : new_array){
        System.out.println(element);
     }
   }
}
```
Sample Output:

Original Hash Set: [Red, White, Pink, Yellow, Black, Green]            
Array elements:                                                        
Red                                                                    
White                                                                  
Pink                                                                   
Yellow                                                                 
Black                                                                  
Green

### 8. Write a Java program to convert a hash set to a tree set.
```java
import java.util.*;
  public class Exercise8 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");
      System.out.println("Original Hash Set: " + h_set);
    
     // Creat a TreeSet of HashSet elements
     Set<String> tree_set = new TreeSet<String>(h_set);
 
     // Display TreeSet elements
     System.out.println("TreeSet elements: ");
     for(String element : tree_set){
        System.out.println(element);
     }
  }
}
```
Sample Output:

Original Hash Set: [Red, White, Pink, Yellow, Black, Green]            
TreeSet elements:                                                      
Black                                                                  
Green                                                                  
Pink                                                                   
Red                                                                    
White                                                                  
Yellow

### 9. Write a Java program to find numbers less than 7 in a tree set.
```java
import java.util.*;

  public class Exercise9 {
  public static void main(String[] args) {
         // Create a empty hash set
     HashSet<String> h_set = new HashSet<String>();
   // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
          h_set.add("Pink");
          h_set.add("Yellow");
      System.out.println("Original Hash Set: " + h_set);
    
    // Create a List from HashSet elements
     List<String> list = new ArrayList<String>(h_set);
 
     // Display ArrayList elements
     System.out.println("ArrayList contains: "+ list);
  }
}
```
Sample Output:

Original Hash Set: [Red, White, Pink, Yellow, Black, Green]            
ArrayList contains: [Red, White, Pink, Yellow, Black, Green]
### 10. Write a Java program to compare two hash set.
```java
import java.util.*;
  public class Exercise10 {
  public static void main(String[] args) {
     // Create a empty hash set
        HashSet<String> h_set = new HashSet<String>();
     // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");

          HashSet<String>h_set2 = new HashSet<String>();
          h_set2.add("Red");
          h_set2.add("Pink");
          h_set2.add("Black");
          h_set2.add("Orange");
          //comparison output in hash set
          HashSet<String>result_set = new HashSet<String>();
         for (String element : h_set){
             System.out.println(h_set2.contains(element) ? "Yes" : "No");
          }      
     }
}
```
Sample Output:

Yes                                                                    
No                                                                     
Yes                                                                    
No 

### 11. Write a Java program to compare two sets and retain elements that are the same.
```java
import java.util.*;
  public class Exercise11 {
  public static void main(String[] args) {
     // Create a empty hash set
        HashSet<String> h_set1 = new HashSet<String>();
     // use add() method to add values in the hash set
          h_set1.add("Red");
          h_set1.add("Green");
          h_set1.add("Black");
          h_set1.add("White");
          System.out.println("Frist HashSet content: "+h_set1);
          HashSet<String>h_set2 = new HashSet<String>();
          h_set2.add("Red");
          h_set2.add("Pink");
          h_set2.add("Black");
          h_set2.add("Orange");
          System.out.println("Second HashSet content: "+h_set2);
          h_set1.retainAll(h_set2);
          System.out.println("HashSet content:");
          System.out.println(h_set1);
     }
}
```
Sample Output:

Frist HashSet content: [Red, White, Black, Green]                      
Second HashSet content: [Red, Pink, Black, Orange]                     
HashSet content:                                                       
[Red, Black]

### 12. Write a Java program to remove all elements from a hash set.
```java
import java.util.*;
  public class Exercise12 {
  public static void main(String[] args) {
     // Create a empty hash set
        HashSet<String> h_set = new HashSet<String>();
     // use add() method to add values in the hash set
          h_set.add("Red");
          h_set.add("Green");
          h_set.add("Black");
          h_set.add("White");
           System.out.println("Original hash set contains: "+ h_set);
      //  clear() method removes all the elements from a hash set
      // and the set becomes empty.
          h_set.clear();
 
     // Display original hash set content again
          System.out.println("HashSet content: "+h_set);
     }
}
```
Sample Output:

Original hash set contains: [Red, White, Black, Green]                 
HashSet content: []
