[Go Back To - Java Exercises Collection](java-basic-exercises-020-Collection.md)

# ArrayList:

In Java, an ArrayList is a resizable array implementation of the List interface provided by the Java Collections Framework. It's part of the java.util package. Unlike arrays, which have a fixed size, ArrayList can dynamically grow and shrink in size as elements are added or removed. This makes it a more flexible data structure for handling collections of objects.

### 1. Write a Java program to create an array list, add some colors (strings) and print out the collection.
```java
import java.util.*;
public class Exercise1 {
  public static void main(String[] args) {
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  System.out.println(list_Strings);
 }
}
```
Sample Output:

Note: Exercise1.java uses unchecked or unsafe operations.              
Note: Recompile with -Xlint:unchecked for details.                     
[Red, Green, Orange, White, Black]

### 2. Write a Java program to iterate through all elements in an array list.
```java
mport java.util.*;
  public class Exercise2 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  // Print the list
  for (String element : list_Strings) {
    System.out.println(element);
    }
 }
}
```
Sample Output:

Red                                                                    
Green                                                                  
Orange                                                                 
White                                                                  
Black 

### 3. Write a Java program to insert an element into the array list at the first position.
```java
import java.util.*;
  public class Exercise3 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  // Print the list
  System.out.println(list_Strings);
  // Now insert a color at the first and last position of the list
  list_Strings.add(0, "Pink");
  list_Strings.add(5, "Yellow");
  // Print the list
  System.out.println(list_Strings);
 }
}
```
Sample Output:

Note: Exercise3.java uses unchecked or unsafe operations.              
Note: Recompile with -Xlint:unchecked for details.                     
[Red, Green, Orange, White, Black]                                     
[Pink, Red, Green, Orange, White, Yellow, Black] 

### 4. Write a Java program to retrieve an element (at a specified index) from a given array list.
```java
import java.util.*;
  public class Exercise4 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  // Print the list
  System.out.println(list_Strings);
  // Retrive the first and third element
  String element = list_Strings.get(0);
  System.out.println("First element: "+element);
  element = list_Strings.get(2);
  System.out.println("Third element: "+element);
 }
}
```
Sample Output:

[Red, Green, Orange, White, Black]                                     
First element: Red                                                     
Third element: Orange

### 5. Write a Java program to update an array element by the given element.
```java
import java.util.*;
  public class Exercise5 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  // Print the list
  System.out.println(list_Strings);
  // Update the third element with "Yellow"
  list_Strings.set(2, "Yellow");
   // Print the list again
  System.out.println(list_Strings);
 }
}
```
Sample Output:

[Red, Green, Orange, White, Black]                                     
[Red, Green, Yellow, White, Black] 

### 6. Write a Java program to remove the third element from an array list.
```java
import java.util.*;
  public class Exercise6 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  // Print the list
  System.out.println(list_Strings);
  // Remove the third element from the list.
  list_Strings.remove(2);
  // Print the list again
  System.out.println("After removing third element from the list:\n"+list_Strings);
 }
}
```
Sample Output:

[Red, Green, Orange, White, Black]                                     
After removing third element from the list:                            
[Red, Green, White, Black] 

### 7. Write a Java program to search for an element in an array list.
```java
import java.util.*;
  public class Exercise7 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  // Search the value Red
    if (list_Strings.contains("Red")) {
    System.out.println("Found the element");
    } else {
    System.out.println("There is no such element");
    }
 }
}
```
Sample Output:

Found the element

### 8. Write a Java program to sort a given array list.
```java
import java.util.*;
  public class Exercise8 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  System.out.println("List before sort: "+list_Strings);
  Collections.sort(list_Strings);
  System.out.println("List after sort: "+list_Strings);    
 }
}
```
Sample Output:

List before sort: [Red, Green, Orange, White, Black]                   
List after sort: [Black, Green, Orange, Red, White]

### 9. Write a Java program to copy one array list into another.
```java
import java.util.*;
  public class Exercise9 {
  public static void main(String[] args) {
  List<String> List1 = new ArrayList<String>();
  List1.add("1");
  List1.add("2");
  List1.add("3");
  List1.add("4");
  System.out.println("List1: " + List1);
  List<String> List2 = new ArrayList<String>();
  List2.add("A");
  List2.add("B");
  List2.add("C");
  List2.add("D");
  System.out.println("List2: " + List2);
  // Copy List2 to List1
  Collections.copy(List1, List2);
  System.out.println("Copy List to List2,\nAfter copy:");
  System.out.println("List1: " + List1);
  System.out.println("List2: " + List2);
 }
}
```
Sample Output:

List1: [1, 2, 3, 4]                                                    
List2: [A, B, C, D]                                                    
Copy List to List2,                                                    
After copy:                                                            
List1: [A, B, C, D]                                                    
List2: [A, B, C, D]

### 10. Write a Java program to shuffle elements in an array list.
```java
import java.util.*;
  public class Exercise10 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  System.out.println("List before shuffling:\n" + list_Strings);  
  Collections.shuffle(list_Strings);
  System.out.println("List after shuffling:\n" + list_Strings); 
 }
}
```
Sample Output:

List before shuffling:                                                 
[Red, Green, Orange, White, Black]                                     
List after shuffling:                                                  
[White, Orange, Black, Red, Green]

### 11. Write a Java program to reverse elements in an array list.
```java
import java.util.*;
  public class Exercise11 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  System.out.println("List before reversing :\n" + list_Strings);  
  Collections.reverse(list_Strings);
  System.out.println("List after reversing :\n" + list_Strings); 
 }
}
```
Sample Output:

List before reversing :                                                
[Red, Green, Orange, White, Black]                                     
List after reversing :                                                 
[Black, White, Orange, Green, Red]  

### 12. Write a Java program to extract a portion of an array list.
```java
import java.util.*;
  public class Exercise12 {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Red");
  list_Strings.add("Green");
  list_Strings.add("Orange");
  list_Strings.add("White");
  list_Strings.add("Black");
  System.out.println("Original list: " + list_Strings);
  List<String> sub_List = list_Strings.subList(0, 3);
  System.out.println("List of first three elements: " + sub_List);
 }
}
```
Sample Output:

Original list: [Red, Green, Orange, White, Black]                      
List of first three elements: [Red, Green, Orange]

### 13. Write a Java program to compare two array lists.
```java
import java.util.*;
  public class Exercise13 {
  public static void main(String[] args) {
   ArrayList<String> c1= new ArrayList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");

          ArrayList<String> c2= new ArrayList<String>();
          c2.add("Red");
          c2.add("Green");
          c2.add("Black");
          c2.add("Pink");

          //Storing the comparison output in ArrayList<String>
          ArrayList<String> c3 = new ArrayList<String>();
          for (String e : c1)
             c3.add(c2.contains(e) ? "Yes" : "No");
          System.out.println(c3);
         
     }
}
```
Sample Output:

[Yes, Yes, Yes, No, Yes]

### 14. Write a Java program that swaps two elements in an array list.
```java
import java.util.ArrayList;
import java.util.Collections;
  public class Exercise14 {
  public static void main(String[] args) {
   ArrayList<String> c1= new ArrayList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");

          System.out.println("Array list before Swap:");
          for(String a: c1){
          System.out.println(a);
        }
          //Swapping 1st(index 0) element with the 3rd(index 2) element
         Collections.swap(c1, 0, 2);
          System.out.println("Array list after swap:");
          for(String b: c1){
          System.out.println(b);
         }
     }
}
```
Sample Output:

Array list before Swap:                                                
Red                                                                    
Green                                                                  
Black                                                                  
White                                                                  
Pink                                                                   
Array list after swap:                                                 
Black                                                                  
Green                                                                  
Red                                                                    
White                                                                  
Pink 

### 15. Write a Java program to join two array lists.
```java
import java.util.ArrayList;
import java.util.Collections;
  public class Exercise15 {
  public static void main(String[] args) {
   ArrayList<String> c1= new ArrayList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("List of first array: " + c1);
          ArrayList<String> c2= new ArrayList<String>();
          c2.add("Red");
          c2.add("Green");
          c2.add("Black");
          c2.add("Pink");
          System.out.println("List of second array: " + c2);
         
      // Let join above two list
        ArrayList<String> a = new ArrayList<String>();
        a.addAll(c1);
        a.addAll(c2);
        System.out.println("New array: " + a);
        

     }
}
```
Sample Output:

List of first array: [Red, Green, Black, White, Pink]                  
List of second array: [Red, Green, Black, Pink]                        
New array: [Red, Green, Black, White, Pink, Red, Green, Black, Pink]

### 16. Write a Java program to clone an array list to another array list.
```java
import java.util.ArrayList;
import java.util.Collections;
  public class Exercise16 {
  public static void main(String[] args) {
          ArrayList<String> c1= new ArrayList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original array list: " + c1);
          ArrayList<String> newc1 = (ArrayList<String>)c1.clone();
          System.out.println("Cloned array list: " + newc1);       
}
}
```
Sample Output:

Note: Exercise16.java uses unchecked or unsafe operations.              
Note: Recompile with -Xlint:unchecked for details.                     
Original array list: [Red, Green, Black, White, Pink]                  
Cloned array list: [Red, Green, Black, White, Pink]

### 17. Write a Java program to empty an array list.
```java
import java.util.ArrayList;
import java.util.Collections;
  public class Exercise17 {
  public static void main(String[] args) {
          ArrayList<String> c1= new ArrayList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original array list: " + c1);
          c1.removeAll(c1);
          System.out.println("Array list after remove all elements "+c1);   
   }
}
```
Sample Output:

Original array list: [Red, Green, Black, White, Pink]                  
Array list after remove all elements []

### 18. Write a Java program to test whether an array list is empty or not.
```java
import java.util.ArrayList;
import java.util.Collections;
  public class Exercise18 {
  public static void main(String[] args) {
          ArrayList<String> c1= new ArrayList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original array list: " + c1);
          System.out.println("Checking the above array list is empty or not! "+c1.isEmpty());
          c1.removeAll(c1);
          System.out.println("Array list after remove all elements "+c1);   
          System.out.println("Checking the above array list is empty or not! "+c1.isEmpty());
   }
}
```
Sample Output:

Original array list: [Red, Green, Black, White, Pink]                  
Checking the above array list is empty or not! false                   
Array list after remove all elements []                                
Checking the above array list is empty or not! true

### 19. Write a Java program for trimming the capacity of an array list.
```java
import java.util.ArrayList;
import java.util.Collections;
  public class Exercise19 {
  public static void main(String[] args) {
          ArrayList<String> c1= new ArrayList<String>();
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          c1.add("White");
          c1.add("Pink");
          System.out.println("Original array list: " + c1);
          System.out.println("Let trim to size the above array: ");
          c1.trimToSize();
          System.out.println(c1);
   }
}
```
Sample Output:

Original array list: [Red, Green, Black, White, Pink]                  
Let trim to size the above array:                                      
[Red, Green, Black, White, Pink] 

### 20. Write a Java program to increase an array list size.
```java
import java.util.ArrayList;
import java.util.Collections;
  public class Exercise20 {
  public static void main(String[] args) {
          ArrayList<String> c1= new ArrayList<String>(3);
          c1.add("Red");
          c1.add("Green");
          c1.add("Black");
          System.out.println("Original array list: " + c1);
          //Increase capacity to 6
          c1.ensureCapacity(6);
          c1.add("White");
          c1.add("Pink");
          c1.add("Yellow");
          System.out.println("New array list: " + c1);
   }
}
```
Sample Output:

Original array list: [Red, Green, Black]                               
New array list: [Red, Green, Black, White, Pink, Yellow]

### 21. Write a Java program to replace the second element of an ArrayList with the specified element.
```java
import java.util.ArrayList;
  public class Exercise21 {
    public static void main(String[] args){
  ArrayList<String>  color = new ArrayList<String>();

  color.add("Red");
  color.add("Green");

  System.out.println("Original array list: " + color);
  String new_color = "White";
  color.set(1,new_color);

  int num=color.size();
  System.out.println("Replace second element with 'White'."); 
  for(int i=0;i<num;i++)
  System.out.println(color.get(i));
  }
}
```
Sample Output:

Original array list: [Red, Green]                                      
Replace second element with 'White'.                                   
Red                                                                    
White

### 22. Write a Java program to print all the elements of an ArrayList using the elements' position.
```java
import java.util.ArrayList;
  public class Exercise22 {
    public static void main(String[] args) {
  ArrayList <String> c1 = new ArrayList <String> ();
  c1.add("Red");
  c1.add("Green");
  c1.add("Black");
  c1.add("White");
  c1.add("Pink");
  System.out.println("\nOriginal array list: " + c1);
  System.out.println("\nPrint using index of an element: ");
  int no_of_elements = c1.size();
  for (int index = 0; index < no_of_elements; index++)
   System.out.println(c1.get(index));
 }
}
```
Sample Output:

Original array list: [Red, Green, Black, White, Pink]                  
                                                                       
Print using index of an element:                                       
Red                                                                    
Green                                                                  
Black                                                                  
White                                                                  
Pink 
