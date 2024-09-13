[Go Back To - Java Exercises Collection](java-basic-exercises-020-Collection.md)
# LinkedList:

In Java, LinkedList is another implementation of the List interface provided by the Java Collections Framework. It's part of the java.util package. Unlike ArrayList, which is backed by an array, LinkedList is implemented as a doubly-linked list.

### 1. Write a Java program to append the specified element to the end of a linked list.
```java
import java.util.LinkedList;
  public class Exercise1 {
  public static void main(String[] args) {
     // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("White");
          l_list.add("Pink");
          l_list.add("Yellow");
	
   // print the list
   System.out.println("The linked list: " + l_list);
   }
}
```
Sample Output:

The linked list: [Red, Green, Black, White, Pink, Yellow]

### 2. Write a Java program to iterate through all elements in a linked list.
```java
import java.util.LinkedList;
  public class Exercise2 {
  public static void main(String[] args) {
    // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("White");
          l_list.add("Pink");
         // Print the linked list
  for (String element : l_list) {
    System.out.println(element);
    }
 }
}
```
Sample Output:

Red                                                                    
Green                                                                  
Black                                                                  
White                                                                  
Pink 

### 3. Write a Java program to iterate through all elements in a linked list starting at the specified position.
```java
import java.util.LinkedList;
import java.util.Iterator;
  public class Exercise3 {
  public static void main(String[] args) {
    // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("White");
          l_list.add("Pink");
// set Iterator at specified index
   Iterator p = l_list.listIterator(1);

   // print list from second position
   while (p.hasNext()) {
   System.out.println(p.next());
   }
   }
}
```
Sample Output:

Green                                                                  
Black                                                                  
White                                                                  
Pink

### 4. Write a Java program to iterate a linked list in reverse order.
```java
import java.util.LinkedList;
import java.util.Iterator;
  public class Exercise4 {
  public static void main(String[] args) {
    // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("Pink");
          l_list.add("orange");
      
        // print original list
   System.out.println("Original linked list:" + l_list);  
 
    Iterator it = l_list.descendingIterator();

     // Print list elements in reverse order
     System.out.println("Elements in Reverse Order:");
     while (it.hasNext()) {
        System.out.println(it.next());
     }
  }
}
```
Sample Output:

Original linked list:[Red, Green, Black, Pink, orange]                 
Elements in Reverse Order:                                             
orange                                                                 
Pink                                                                   
Black                                                                  
Green                                                                  
Red 

### 5. Write a Java program to insert the specified element at the specified position in the linked list.
```java
import java.util.LinkedList;
public class Exercise5 {
	public static void main(String[] args) {
		// create an empty linked list
		LinkedList <String> l_list = new LinkedList <String> ();
		// use add() method to add values in the linked list
		l_list.add("Red");
		l_list.add("Green");
		l_list.add("Black");
		l_list.add("White");
		l_list.add("Pink");
		System.out.println("Original linked list: ");
		System.out.println("Let add the Yellow color after the Red Color: " + l_list);
		l_list.add(1, "Yellow");
		// print the list
		System.out.println("The linked list:" + l_list);
	}
}
```
Sample Output:

Original linked list:                                                  
Let add the Yellow color after the Red Color: [Red, Green, Black, White
, Pink]                                                                
The linked list:[Red, Yellow, Green, Black, White, Pink]

### 6. Write a Java program to insert elements into the linked list at the first and last positions.
```java
import java.util.LinkedList;
  public class Exercise6 {
  public static void main(String[] args) {
   // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
     System.out.println("Original linked list:" + l_list);    
   // Add an element at the beginning 
    l_list.addFirst("White");
 
   // Add an element at the end of list 
    l_list.addLast("Pink");
     System.out.println("Final linked list:" + l_list);  
 }
}
```
Sample Output:

Original linked list:[Red, Green, Black]                               
Final linked list:[White, Red, Green, Black, Pink]

### 7. Write a Java program to insert the specified element at the front of a linked list.
```java
import java.util.LinkedList;
  public class Exercise7 {
  public static void main(String[] args) {
   // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
     System.out.println("Original linked list:" + l_list);    
  // Add an element to front of LinkedList
     l_list.offerFirst("Pink");
     System.out.println("Final linked list:" + l_list);  
 }	
}
```
Sample Output:

Original linked list:[Red, Green, Black]                               
Final linked list:[Pink, Red, Green, Black]

### 8. Write a Java program to insert the specified element at the end of a linked list.
```java
import java.util.LinkedList;
  public class Exercise8 {
  public static void main(String[] args) {
   // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
     System.out.println("Original linked list:" + l_list);    
  // Add an element at the end of a linked list
     l_list.offerLast("Pink");
     System.out.println("Final linked list:" + l_list);  
 }
}
```
Sample Output:

Original linked list:[Red, Green, Black]                               
Final linked list:[Red, Green, Black, Pink]

### 9. Write a Java program to insert some elements at the specified position into a linked list.
```java
import java.util.LinkedList;
public class Exercise9 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> l_list = new LinkedList <String> ();
  // use add() method to add values in the linked list
  l_list.add("Red");
  l_list.add("Green");
  l_list.add("Black");

  // print original list
  System.out.println("Original linked list:" + l_list);

  // create a new collection and add some elements

  LinkedList <String> new_l_list = new LinkedList <String> ();
  new_l_list.add("White");
  new_l_list.add("Pink");

  // Add the collection in the second position of the existing linked list
  l_list.addAll(1, new_l_list);

  // print the new list
  System.out.println("LinkedList:" + l_list);
 }
}
```
Sample Output:

Original linked list:[Red, Green, Black]                               
LinkedList:[Red, White, Pink, Green, Black]

### 10. Write a Java program to get the first and last occurrence of the specified elements in a linked list.
```java
import java.util.LinkedList;
import java.util.Iterator;
  public class Exercise10 {
  public static void main(String[] args) {
    // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("Pink");
          l_list.add("orange");
      
      // print original list
   System.out.println("Original linked list:" + l_list);  
 
   // Find first element of the List
    Object first_element = l_list.getFirst();
    System.out.println("First Element is: "+first_element);
 
    // Find last element of the List
    Object last_element = l_list.getLast();
    System.out.println("Last Element is: "+last_element);
 }
}
```
Sample Output:

Original linked list:[Red, Green, Black, Pink, orange]                 
First Element is: Red                                                  
Last Element is: orange

### 11. Write a Java program to display elements and their positions in a linked list.
```java
import java.util.LinkedList;
import java.util.Iterator;
  public class Exercise1 {
  public static void main(String[] args) {
    // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("Pink");
          l_list.add("orange");
      
      // print original list
   System.out.println("Original linked list:" + l_list);  
  for(int p=0; p < l_list.size(); p++)
   {
      System.out.println("Element at index "+p+": "+l_list.get(p));
    } 
 }
}
```
Sample Output:

Original linked list:[Red, Green, Black, Pink, orange]                 
Element at index 0: Red                                                
Element at index 1: Green                                              
Element at index 2: Black                                              
Element at index 3: Pink                                               
Element at index 4: orange

### 12. Write a Java program to remove a specified element from a linked list.
```java
import java.util.*;

public class Exercise12 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> l_list = new LinkedList <String> ();
  // use add() method to add values in the linked list
  l_list.add("Red");
  l_list.add("Green");
  l_list.add("Black");
  l_list.add("Pink");
  l_list.add("orange");

  // print the list
  System.out.println("The Original linked list: " + l_list);

  // Remove the element in third position from the said linked list
  l_list.remove(2);
  System.out.println("The New linked list: " + l_list);
 }
}
```
Sample Output:

The Original linked list: [Red, Green, Black, Pink, orange]            
The New linked list: [Red, Green, Pink, orange] 

### 13. Write a Java program to remove the first and last elements from a linked list.
```java
import java.util.*;

  public class Exercise13 {
  public static void main(String[] args) {
    // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("Pink");
          l_list.add("orange");
      
     // print the list
   System.out.println("The Original linked list: " + l_list);

  // Remove the first element
    Object firstElement = l_list.removeFirst();
    System.out.println("Element removed: "+ firstElement);
 
  // Remove the last element
    Object lastElement = l_list.removeLast();
    System.out.println("Element removed: "+ lastElement);
    System.out.println("The New linked list: " + l_list);
  }
}
```
Sample Output:

The Original linked list: [Red, Green, Black, Pink, orange]            
Element removed: Red                                                   
Element removed: orange                                                
The New linked list: [Green, Black, Pink]

### 14. Write a Java program to remove all elements from a linked list.
```java
import java.util.*;
  public class Exercise14 {
  public static void main(String[] args) {
    // create an empty linked list
     LinkedList<String> l_list = new LinkedList<String>();
   // use add() method to add values in the linked list
          l_list.add("Red");
          l_list.add("Green");
          l_list.add("Black");
          l_list.add("Pink");
          l_list.add("orange");
      
     // print the list
   System.out.println("The Original linked list: " + l_list);

  // Removing all the elements from the linked list
    l_list.clear();
 
    System.out.println("The New linked list: " + l_list);
  }
}
```
Sample Output:

The Original linked list: [Red, Green, Black, Pink, orange]            
The New linked list: []

### 15. Write a Java program that swaps two elements in a linked list.
```java
import java.util.*;

public class Exercise15 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> l_list = new LinkedList <String> ();
  // use add() method to add values in the linked list
  l_list.add("Red");
  l_list.add("Green");
  l_list.add("Black");
  l_list.add("Pink");
  l_list.add("orange");
  // print the list
  System.out.println("The Original linked list: " + l_list);
  
   //Swapping 1st(index 0) element(Red) with the 3rd(index 2) element (Black)
    Collections.swap(l_list, 0, 2);
    System.out.println("The New linked list after swap: " + l_list);
 }
}
```
Sample Output:

The Original linked list: [Red, Green, Black, Pink, orange]            
The New linked list after swap: [Black, Green, Red, Pink, orange]

### 16. Write a Java program to shuffle elements in a linked list.
```java
import java.util.*;

public class Exercise16 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> l_list = new LinkedList <String> ();
  // use add() method to add values in the linked list
  l_list.add("Red");
  l_list.add("Green");
  l_list.add("Black");
  l_list.add("Pink");
  l_list.add("orange");
  // print the list
  System.out.println("Linked list before shuffling:\n" + l_list);  
  Collections.shuffle(l_list);
  System.out.println("Linked list after shuffling:\n" + l_list); 
  }
}
```
Sample Output:

Linked list before shuffling:                                          
[Red, Green, Black, Pink, orange]                                      
Linked list after shuffling:                                           
[orange, Pink, Red, Black, Green]

### 17. Write a Java program to join two linked lists.
```java
import java.util.*;
public class Exercise17 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> c1 = new LinkedList <String> ();
  
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("List of first linked list: " + c1);
         LinkedList <String> c2 = new LinkedList <String> ();
          c2.add("Red");
          c2.add("Green");
          c2.add("Black");
          c2.add("Pink");
          System.out.println("List of second linked list: " + c2);
        
      // Let join above two list
        LinkedList <String> a = new LinkedList <String> ();
        a.addAll(c1);
        a.addAll(c2);
        System.out.println("New linked list: " + a);
             }
}
```
Sample Output:

List of first linked list: [Red, Green, Black, White, Pink]            
List of second linked list: [Red, Green, Black, Pink]                  
New linked list: [Red, Green, Black, White, Pink, Red, Green, Black, Pink]

### 18. Write a Java program to copy a linked list to another linked list.
```java
import java.util.*;
public class Exercise18 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> c1 = new LinkedList <String> ();
            c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original linked  list: " + c1);
           LinkedList <String> newc1 = new LinkedList <String> ();
                newc1 = (LinkedList)c1.clone();
          System.out.println("Cloned linked list: " + newc1);       
}
}
```
Sample Output:

Note: Exercise18.java uses unchecked or unsafe operations.             
Note: Recompile with -Xlint:unchecked for details.                     
Original linked  list: [Red, Green, Black, White, Pink]                
Cloned linked list: [Red, Green, Black, White, Pink]

### 19. Write a Java program to remove and return the first element of a linked list.
```java
import java.util.*;
public class Exercise19 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> c1 = new LinkedList <String> ();
            c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original linked  list: " + c1);
           
     System.out.println("Removed element: "+c1.pop());
     
     System.out.println("Linked list after pop operation: "+c1);
  }
}
```
Sample Output:

Original linked  list: [Red, Green, Black, White, Pink]                
Removed element: Red                                                   
Linked list after pop operation: [Green, Black, White, Pink]
### 20. Write a Java program to retrieve, but not remove, the first element of a linked list.
```java
import java.util.*;

public class Exercise20 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> c1 = new LinkedList <String> ();
            c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original linked list: " + c1); 
     // Retrieve but does not remove, the first element of a linked list
    String x = c1.peekFirst();
    System.out.println("First element in the list: " + x);
    System.out.println("Original linked list: " + c1);   
 }
}
``` 
Sample Output:

Original linked list: [Red, Green, Black, White, Pink]                 
First element in the list: Red                                         
Original linked list: [Red, Green, Black, White, Pink]

### 21. Write a Java program to retrieve, but not remove, the last element of a linked list.
```java
import java.util.*;

public class Exercise21 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> c1 = new LinkedList <String> ();
            c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original linked list: " + c1);    
     // Retrieve but does not remove, the last element of a linked list
        String x = c1.peekLast();
    System.out.println("Last element in the list: " + x);
    System.out.println("Original linked list: " + c1);
    
 }
}
```
Sample Output:

Original linked list: [Red, Green, Black, White, Pink]                 
Last element in the list: Pink                                         
Original linked list: [Red, Green, Black, White, Pink]

### 22. Write a Java program to check if a particular element exists in a linked list.
```java
import java.util.*;
public class Exercise22 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> c1 = new LinkedList <String> ();
            c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original linked list: " + c1);
           
     // Checks whether the color "Green" exists or not.
    if (c1.contains("Green")) {
       System.out.println("Color Green is present in the linked list.");
    } else {
       System.out.println("Color Green is not present in the linked list.");
     }
    
     // Checks whether the color "Orange" exists or not.
    if (c1.contains("Orange")) {
       System.out.println("Color Orange is present in the linked list.");
    } else {
       System.out.println("Color Orange is not present in the linked list.");
     }
    
 }
}
```
Sample Output:

Original linked list: [Red, Green, Black, White, Pink]                 
Color Green is present in the linked list.                             
Color Orange is not present in the linked list.

### 23. Write a Java program to convert a linked list to an array list.
```java
import java.util.*;

public class Exercise23 {
 public static void main(String[] args) {
  // create an empty linked list
  LinkedList <String> linked_list = new LinkedList <String> ();
            linked_list.add("Red");
          linked_list.add("Green");
          linked_list.add("Black");
          linked_list.add("White");
          linked_list.add("Pink");
          System.out.println("Original linked list: " + linked_list);
   
      //Convert a linked list to array list    
     List<String> list = new ArrayList<String>(linked_list);

    for (String str : list){
      System.out.println(str);
    }
 }
}
```
Sample Output:

Original linked list: [Red, Green, Black, White, Pink]                 
Red                                                                    
Green                                                                  
Black                                                                  
White                                                                  
Pink

### 24. Write a Java program to compare two linked lists.
```java
import java.util.*;
  public class Exercise24 {
  public static void main(String[] args) {
   LinkedList<String> c1= new LinkedList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");

          LinkedList<String> c2= new LinkedList<String>();
          c2.add("Red");
          c2.add("Green");
          c2.add("Black");
          c2.add("Orange");

          //comparison output in linked list
          LinkedList<String> c3 = new LinkedList<String>();
          for (String e : c1)
             c3.add(c2.contains(e) ? "Yes" : "No");
          System.out.println(c3);         
     }
}
```
Sample Output:

[Yes, Yes, Yes, No, No]

### 25. Write a Java program to check if a linked list is empty or not.
```java
import java.util.LinkedList;
import java.util.Collections;
  public class Exercise25 {
  public static void main(String[] args) {
          LinkedList<String> c1= new LinkedList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original linked list: " + c1);
          System.out.println("Check the above linked list is empty or not! "+c1.isEmpty());
          c1.removeAll(c1);
          System.out.println("Linked list after remove all elements "+c1);   
          System.out.println("Check the above linked list is empty or not! "+c1.isEmpty());
   }
}
```
Sample Output:

Original linked list: [Red, Green, Black, White, Pink]                 
Check the above linked list is empty or not! false                     
Linked list after remove all elements []                               
Check the above linked list is empty or not! true 

### 26. Write a Java program to replace an element in a linked list.
```java
import java.util.LinkedList;
import java.util.Collections;
  public class Exercise18 {
  public static void main(String[] args) {
          LinkedList<String> c1= new LinkedList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original linked list: " + c1);
          // Replacing 2nd element with new value
          c1.set(1, "Orange");
          System.out.println("The value of second element changed.");
          System.out.println("New linked list: " + c1);
   }
}
```
Sample Output:

Original linked list: [Red, Green, Black, White, Pink]                 
The value of second element changed.                                   
New linked list: [Red, Orange, Black, White, Pink] 
