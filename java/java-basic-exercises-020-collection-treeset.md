[Go Back To - Java Exercises Collection](java-basic-exercises-020-Collection.md)

# TreeSet:

In Java, TreeSet is an implementation of the SortedSet interface provided by the Java Collections Framework. It's part of the java.util package.

### 1. Write a Java program to create a tree set, add some colors (strings) and print out the tree set.
```java
import java.util.TreeSet;
public class Exercise1 {
  public static void main(String[] args) {
  TreeSet<String> tree_set = new TreeSet<String>();
  tree_set.add("Red");
  tree_set.add("Green");
  tree_set.add("Orange");
  tree_set.add("White");
  tree_set.add("Black");
  System.out.println("Tree set: ");
  System.out.println(tree_set);
 }
}
```
Sample Output:

Tree set:                                                              
[Black, Green, Orange, Red, White] 

### 2. Write a Java program to iterate through all elements in a tree set.
```java
import java.util.TreeSet;
public class Exercise2 {
  public static void main(String[] args) {
  TreeSet<String> tree_set = new TreeSet<String>();
  tree_set.add("Red");
  tree_set.add("Green");
  tree_set.add("Orange");
  tree_set.add("White");
  tree_set.add("Black");
  // Print the tree list
  for (String element : tree_set) {
    System.out.println(element);
    }
 }
}
```
Sample Output:

Black                                                                  
Green                                                                  
Orange                                                                 
Red                                                                    
White 

### 3. Write a Java program to add all the elements of a specified tree set to another tree set.
```java
import java.util.TreeSet;
public class Exercise3 {
  public static void main(String[] args) {
  TreeSet<String> tree_set1 = new TreeSet<String>();
  tree_set1.add("Red");
  tree_set1.add("Green");
  tree_set1.add("Orange");
  System.out.println("Tree set1: "+tree_set1);
  TreeSet<String> tree_set2 = new TreeSet<String>();
  tree_set2.add("Pink");
  tree_set2.add("White");
  tree_set2.add("Black");
  System.out.println("Tree set2: "+tree_set2);
   // adding treetwo to treeone
   tree_set1.addAll(tree_set2);
   System.out.println("Tree set1: "+tree_set1);
 }
}
```
Sample Output:

Tree set1: [Green, Orange, Red]                                        
Tree set2: [Black, Pink, White]                                        
Tree set1: [Black, Green, Orange, Pink, Red, White] 
### 4. Write a Java program to create a reverse order view of the elements contained in a given tree set.
```java
import java.util.TreeSet;
import java.util.Iterator;
  public class Exercise4 {
  public static void main(String[] args) {
    // create an empty tree set
     TreeSet<String> t_set = new TreeSet<String>();
   // use add() method to add values in the tree set
          t_set.add("Red");
          t_set.add("Green");
          t_set.add("Black");
          t_set.add("Pink");
          t_set.add("orange");
     // print original list
   System.out.println("Original tree set:" + t_set);  
     Iterator it = t_set.descendingIterator();
     // Print list elements in reverse order
     System.out.println("Elements in Reverse Order:");
     while (it.hasNext()) {
        System.out.println(it.next());
     }
  }
}
```
Sample Output:

Original tree set:[Black, Green, Pink, Red, orange]                    
Elements in Reverse Order:                                             
orange                                                                 
Red                                                                    
Pink                                                                   
Green                                                                  
Black

### 5. Write a Java program to get the first and last elements in a tree set.
```java
import java.util.TreeSet;
  public class Exercise5 {
  public static void main(String[] args) {
  TreeSet<String> tree_set = new TreeSet<String>();
  tree_set.add("Red");
  tree_set.add("Green");
  tree_set.add("Orange");
  tree_set.add("White");
  tree_set.add("Black");
  System.out.println("Tree set: ");
  System.out.println(tree_set);

   // Find first element of the tree set
    Object first_element = tree_set.first();
    System.out.println("First Element is: "+first_element);
 
    // Find last element of the tree set
    Object last_element = tree_set.last();
    System.out.println("Last Element is: "+last_element);
 }
}
```
Sample Output:

Tree set:                                                              
[Black, Green, Orange, Red, White]                                     
First Element is: Black                                                
Last Element is: White 

### 6. Write a Java program to clone a tree set list to another tree set.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise6 {
  public static void main(String[] args) {
    // create an empty tree set
     TreeSet<String> t_set = new TreeSet<String>();
   // use add() method to add values in the tree set
          t_set.add("Red");
          t_set.add("Green");
          t_set.add("Black");
          t_set.add("Pink");
          t_set.add("orange");
     
   System.out.println("Original tree set:" + t_set);  
    TreeSet<String> new_t_set = (TreeSet<String>)t_set.clone();
          System.out.println("Cloned tree list: " + t_set);      
     }
 }
```
Sample Output:

Note: Exercise6.java uses unchecked or unsafe operations.              
Note: Recompile with -Xlint:unchecked for details.                     
Original tree set:[Black, Green, Pink, Red, orange]                    
Cloned tree list: [Black, Green, Pink, Red, orange] 

### 7. Write a Java program to get the number of elements in a tree set.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise7 {
  public static void main(String[] args) {
    // create an empty tree set
     TreeSet<String> t_set = new TreeSet<String>();
   // use add() method to add values in the tree set
          t_set.add("Red");
          t_set.add("Green");
          t_set.add("Black");
          t_set.add("Pink");
          t_set.add("orange");
     System.out.println("Original tree set: " + t_set);
    System.out.println("Size of the tree set: " + t_set.size());
   }
}
```
Sample Output:

Original tree set: [Black, Green, Pink, Red, orange]                   
Size of the tree set: 5 

### 8. Write a Java program to compare two tree sets.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise8 {
  public static void main(String[] args) {
  // Create a empty tree set
        TreeSet<String> t_set1 = new TreeSet<String>();
     // use add() method to add values in the tree set
          t_set1.add("Red");
          t_set1.add("Green");
          t_set1.add("Black");
          t_set1.add("White");
          System.out.println("Free Tree set: "+t_set1);

          TreeSet<String> t_set2 = new TreeSet<String>();
          t_set2.add("Red");
          t_set2.add("Pink");
          t_set2.add("Black");
          t_set2.add("Orange");
          System.out.println("Second Tree set: "+t_set2);
          //comparison output in tree set
          TreeSet<String> result_set = new TreeSet<String>();
         for (String element : t_set1){
             System.out.println(t_set2.contains(element) ? "Yes" : "No");
          }      
     }
}
```
Sample Output:

Free Tree set: [Black, Green, Red, White]                              
Second Tree set: [Black, Orange, Pink, Red]                            
Yes                                                                    
No                                                                     
Yes                                                                    
No 

### 9. Write a Java program to find numbers less than 7 in a tree set.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise9 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(1);
   tree_num.add(2);
   tree_num.add(3);
   tree_num.add(5);
   tree_num.add(6);
   tree_num.add(7);
   tree_num.add(8);
   tree_num.add(9);
   tree_num.add(10);
     
   // Find numbers less than 7
 treeheadset = (TreeSet)tree_num.headSet(7);  

   // create an iterator
   Iterator iterator;
   iterator = treeheadset.iterator();
     
   //Displaying the tree set data
   System.out.println("Tree set data: ");     
   while (iterator.hasNext()){
   System.out.println(iterator.next() + " ");
   }
   }    
}
```
Sample Output:

Note: Exercise9.java uses unchecked or unsafe operations.              
Note: Recompile with -Xlint:unchecked for details.                     
Tree set data:                                                         
1                                                                      
2                                                                      
3                                                                      
5                                                                      
6 

### 10. Write a Java program to get the element in a tree set which is greater than or equal to the given element.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise10 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(10);
   tree_num.add(22);
   tree_num.add(36);
   tree_num.add(25);
   tree_num.add(16);
   tree_num.add(70);
   tree_num.add(82);
   tree_num.add(89);
   tree_num.add(14);
   
   System.out.println("Greater than or equal to 86 : "+tree_num.ceiling(86));
   System.out.println("Greater than or equal to 29 : "+tree_num.ceiling(29));
   }    
}
```
Sample Output:

Greater than or equal to 86 : 89                                       
Greater than or equal to 29 : 36

### 11. Write a Java program to get the element in a tree set less than or equal to the given element.
```java
import java.util.TreeSet;
import java.util.Iterator;
  public class Exercise11 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(10);
   tree_num.add(22);
   tree_num.add(36);
   tree_num.add(25);
   tree_num.add(16);
   tree_num.add(70);
   tree_num.add(82);
   tree_num.add(89);
   tree_num.add(14);
   
   System.out.println("Less than or equal to 86 : "+tree_num.floor(86));
   System.out.println("Less than or equal to 29 : "+tree_num.floor(29));
   }    
}
```
Sample Output:

Less than or equal to 86 : 82                                          
Less than or equal to 29 : 25

### 12. Write a Java program to get the element in a tree set strictly greater than or equal to the given element.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise12 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(10);
   tree_num.add(22);
   tree_num.add(36);
   tree_num.add(25);
   tree_num.add(16);
   tree_num.add(70);
   tree_num.add(82);
   tree_num.add(89);
   tree_num.add(14);
   
   System.out.println("Strictly greater than 76 : "+tree_num.higher(76));
   System.out.println("Strictly greater than 31 : "+tree_num.higher(31));
   }    
}
```
Sample Output:

Strictly greater than 76 : 82                                          
Strictly greater than 31 : 36

### 13. Write a Java program to get an element in a tree set that has a lower value than the given element.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise13 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(10);
   tree_num.add(22);
   tree_num.add(36);
   tree_num.add(25);
   tree_num.add(16);
   tree_num.add(70);
   tree_num.add(82);
   tree_num.add(89);
   tree_num.add(14);
   
   System.out.println("Strictly less than 69 : "+tree_num.lower(69));
   System.out.println("Strictly less than 12 : "+tree_num.lower(12));
   }    
}
```
Sample Output:

Strictly less than 69 : 36                                             
Strictly less than 12 : 10

### 14. Write a Java program to retrieve and remove the first element of a tree set.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise14 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(10);
   tree_num.add(22);
   tree_num.add(36);
   tree_num.add(25);
   tree_num.add(16);
   tree_num.add(70);
   tree_num.add(82);
   tree_num.add(89);
   tree_num.add(14);
   System.out.println("Original tree set: "+tree_num);
   System.out.println("Removes the first(lowest) element: "+tree_num.pollFirst());
   System.out.println("Tree set after removing first element: "+tree_num);
   }    
}
```
Sample Output:

Original tree set: [10, 14, 16, 22, 25, 36, 70, 82, 89]                
Removes the first(lowest) element: 10                                  
Tree set after removing first element: [14, 16, 22, 25, 36, 70, 82, 89]

### 15. Write a Java program to retrieve and remove the last element of a tree set.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise15 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(10);
   tree_num.add(22);
   tree_num.add(36);
   tree_num.add(25);
   tree_num.add(16);
   tree_num.add(70);
   tree_num.add(82);
   tree_num.add(89);
   tree_num.add(14);
   System.out.println("Original tree set: "+tree_num);
   System.out.println("Removes the last element: "+tree_num.pollLast());
   System.out.println("Tree set after removing last element: "+tree_num);
   }    
}
```
Sample Output:

Original tree set: [10, 14, 16, 22, 25, 36, 70, 82, 89]                
Removes the last element: 89                                           
Tree set after removing last element: [10, 14, 16, 22, 25, 36, 70, 82]

### 16. Write a Java program to remove a given element from a tree set.
```java
import java.util.TreeSet;
import java.util.Iterator;

  public class Exercise16 {
  public static void main(String[] args) {
 // creating TreeSet 
   TreeSet <Integer>tree_num = new TreeSet<Integer>();
   TreeSet <Integer>treeheadset = new TreeSet<Integer>();
     
   // Add numbers in the tree
   tree_num.add(10);
   tree_num.add(22);
   tree_num.add(36);
   tree_num.add(25);
   tree_num.add(16);
   tree_num.add(70);
   tree_num.add(82);
   tree_num.add(89);
   tree_num.add(14);
   System.out.println("Original tree set: "+tree_num);
   System.out.println("Removes 70 from the list: "+tree_num.remove(70));
   System.out.println("Tree set after removing last element: "+tree_num);
   }    
}
```
Sample Output:

Original tree set: [10, 14, 16, 22, 25, 36, 70, 82, 89]                
Removes 70 from the list: true                                         
Tree set after removing last element: [10, 14, 16, 22, 25, 36, 82, 89]
