[Go Back To - Java Exercises Collection](java-basic-exercises-020-Collection.md)

# PriorityQueue:

In Java, PriorityQueue is an implementation of the Queue interface provided by the Java Collections Framework. It's part of the java.util package.

### 1. Write a Java program to create a priority queue, add some colors (strings) and print out the elements of the priority queue.
```java
import java.util.PriorityQueue;
public class Exercise1 {
  public static void main(String[] args) {
  PriorityQueue<String> queue=new PriorityQueue<String>();  
  queue.add("Red");
  queue.add("Green");
  queue.add("Orange");
  queue.add("White");
  queue.add("Black");
  System.out.println("Elements of the Priority Queue: ");
  System.out.println(queue);
 }
}
```
Sample Output:

Elements of the Priority Queue:                                        
[Black, Green, Orange, White, Red] 

### 2. Write a Java program to iterate through all elements in the priority queue.
```java
import java.util.PriorityQueue;
public class Exercise2 {
  public static void main(String[] args) {
    PriorityQueue<String> pq = new PriorityQueue<String>();  
  pq.add("Red");
  pq.add("Green");
  pq.add("Orange");
  pq.add("White");
  pq.add("Black");
  System.out.println("Elements of the Priority Queue: ");
  // iterate the Priority Queue
  for (String element : pq) {
    System.out.println(element);
    }
 }
}
```
Sample Output:

Elements of the Priority Queue:                                        
Black                                                                  
Green                                                                  
Orange                                                                 
White                                                                  
Red

### 3. Write a Java program to add all the elements of a priority queue to another priority queue.
```java
import java.util.PriorityQueue;
public class Exercise3 {
public static void main(String[] args) {
  PriorityQueue<String> queue1 = new PriorityQueue<String>();  
  queue1.add("Red");
  queue1.add("Green");
  queue1.add("Orange");
  System.out.println("Priority Queue1: "+queue1);
  PriorityQueue<String> queue2 = new PriorityQueue<String>();  
  queue2.add("Pink");
  queue2.add("White");
  queue2.add("Black");
  System.out.println("Priority Queue2: "+queue2);
    // adding queue2 to queue1
   queue1.addAll(queue2);
   System.out.println("New Priority Queue1: "+queue1);
 }
}
```
Sample Output:

Priority Queue1: [Green, Red, Orange]                                  
Priority Queue2: [Black, White, Pink]                                  
New Priority Queue1: [Black, Green, Orange, Red, White, Pink]

### 4. Write a Java program to insert a given element into a priority queue.
```java
import java.util.PriorityQueue;

  public class Example4 {
  public static void main(String[] args) {

   // Create Priority Queue
           PriorityQueue<String> pq1 = new PriorityQueue<String>();  
   // use add() method to add values in the Priority Queue
          pq1.add("Red");
          pq1.add("Green");
          pq1.add("Black");
          pq1.add("White");
    System.out.println("Original Priority Queue: "+pq1);
   
   // Inserts the specified element into this priority queue.
    pq1.offer("Blue");
 
    System.out.println("The New Priority Queue: " + pq1);
  } 
}
```
Sample Output:

Original Priority Queue: [Black, Red, Green, White]                    
The New Priority Queue: [Black, Blue, Green, White, Red]

### 5. Write a Java program to remove all elements from a priority queue.
```java
import java.util.*;
  public class Example5 {
  public static void main(String[] args) {
   // Create Priority Queue
           PriorityQueue<String> pq1 = new PriorityQueue<String>();  
   // use add() method to add values in the Priority Queue
          pq1.add("Red");
          pq1.add("Green");
          pq1.add("Black");
          pq1.add("White");
    System.out.println("Original Priority Queue: "+pq1);
   
   // Removing all the elements from the Priority Queue
    pq1.clear();
 
    System.out.println("The New Priority Queue: " + pq1);
  } 
}
```
Sample Output:

Original Priority Queue: [Black, Red, Green, White]                    
The New Priority Queue: []

### 6. Write a Java program to count the number of elements in a priority queue.
```java
import java.util.PriorityQueue;
  public class Exercise6 {
  public static void main(String[] args) {
    // create an empty Priority Queue
    PriorityQueue<String> pq = new PriorityQueue<String>();  
   // use add() method to add values in the Priority Queue
          pq.add("Red");
          pq.add("Green");
          pq.add("Black");
          pq.add("Pink");
          pq.add("orange");
     System.out.println("Priority Queue: " + pq);
    System.out.println("Size of the Priority Queue: " + pq.size());
   }
}
```
Sample Output:

Priority Queue: [Black, Pink, Green, Red, orange]                      
Size of the Priority Queue: 5

### 7. Write a Java program to compare two priority queues.
```java
import java.util.PriorityQueue;
  public class Exercise7 {
  public static void main(String[] args) {
  // Create a empty Priority Queue
        PriorityQueue<String> pq1 = new PriorityQueue<String>();  
     // use add() method to add values in the Priority Queue
          pq1.add("Red");
          pq1.add("Green");
          pq1.add("Black");
          pq1.add("White");
          System.out.println("First Priority Queue: "+pq1);
          PriorityQueue<String> pq2 = new PriorityQueue<String>();  
          pq2.add("Red");
          pq2.add("Pink");
          pq2.add("Black");
          pq2.add("Orange");
          System.out.println("Second Priority Queue: "+pq2);
          //comparison output in Priority Queue
         for (String element : pq1){
             System.out.println(pq2.contains(element) ? "Yes" : "No");
          }      
     }
}
```
Sample Output:

First Priority Queue: [Black, Red, Green, White]                       
Second Priority Queue: [Black, Orange, Pink, Red]                      
Yes                                                                    
Yes                                                                    
No                                                                     
No

### 8. Write a Java program to retrieve the first element of the priority queue.
```java
import java.util.PriorityQueue;
  public class Example8 {
  public static void main(String[] args) {

   // Create Priority Queue
      PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();  
      PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();  
        
   // Add numbers in the Queue
   pq1.add(10);
   pq1.add(22);
   pq1.add(36);
   pq1.add(25);
   pq1.add(16);
   pq1.add(70);
   pq1.add(82);
   pq1.add(89);
   pq1.add(14);
   System.out.println("Original Priority Queue: "+pq1);
   System.out.println("The first element of the Queue: "+pq1.peek());
   }    
}
```
Sample Output:

Original Priority Queue: [10, 14, 36, 16, 22, 70, 82, 89, 25]          
The first element of the Queue: 10

### 9. Write a Java program to retrieve and remove the first element.
```java
import java.util.PriorityQueue;

  public class Exercise9 {
  public static void main(String[] args) {
   // Create Priority Queue
      PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();  
      PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();     
   // Add numbers in the Priority Queue
   pq1.add(10);
   pq1.add(22);
   pq1.add(36);
   pq1.add(25);
   pq1.add(16);
   pq1.add(70);
   pq1.add(82);
   pq1.add(89);
   pq1.add(14);
   System.out.println("Original Priority Queue: "+pq1);
   System.out.println("Removes the first element: "+pq1.poll());
   System.out.println("Priority Queue after removing first element: "+pq1);
   }    
}
```
Sample Output:

Original Priority Queue: [10, 14, 36, 16, 22, 70, 82, 89, 25]          
Removes the first element: 10                                          
Priority Queue after removing first element: [14, 16, 36, 25, 22, 70, 8
2, 89] 
### 10. Write a Java program to convert a priority queue to an array containing all its elements.
```java
import java.util.*;

  public class Example10 {
  public static void main(String[] args) {

   // Create Priority Queue
           PriorityQueue<String> pq1 = new PriorityQueue<String>();  
   // use add() method to add values in the Priority Queue
          pq1.add("Red");
          pq1.add("Green");
          pq1.add("Black");
          pq1.add("White");
    System.out.println("Original Priority Queue: "+pq1);
   
   //Convert a linked list to array list    
   List<String> array_list = new ArrayList<String>(pq1);
   System.out.println("Array containing all of the elements in the queue: "+array_list);
    
   }    
}
```
Sample Output:

Original Priority Queue: [Black, Red, Green, White]                    
Array containing all of the elements in the queue: [Black, Red, Green, 
White] 
### 11. Write a Java program to convert a Priority Queue element to string representations.
```java
import java.util.*;
  public class Example11 {
  public static void main(String[] args) {

   // Create Priority Queue
           PriorityQueue<String> pq1 = new PriorityQueue<String>();  
   // use add() method to add values in the Priority Queue
          pq1.add("Red");
          pq1.add("Green");
          pq1.add("Black");
          pq1.add("White");
    System.out.println("Original Priority Queue: "+pq1);
   
   //Convert Priority Queue to a string representation
   String str1;
   str1 = pq1.toString();
   System.out.println("String representation of the Priority Queue: "+str1);    
  }
}
```
Sample Output:

Original Priority Queue: [Black, Red, Green, White]                    
String representation of the Priority Queue: [Black, Red, Green, White]

### 12. Write a Java program to change priorityQueue to maximum priority queue.
```java
import java.util.*;
  public class Example12 {
  public static void main(String[] args) {
  PriorityQueue<Integer> pq1 = new PriorityQueue<>(10, Collections.reverseOrder());
      
   // Add numbers in the Queue
   pq1.add(10);
   pq1.add(22);
   pq1.add(36);
   pq1.add(25);
   pq1.add(16);
   pq1.add(70);
   pq1.add(82);
   pq1.add(89);
   pq1.add(14);
   System.out.println("\nOriginal Priority Queue: "+pq1);

System.out.print("\nMaximum Priority Queue: ");
Integer val = null;
while( (val = pq1.poll()) != null) {
    System.out.print(val+"  ");
      }
	  System.out.print("\n");
  }
}
```
Sample Output:

Original Priority Queue: [89, 82, 70, 25, 16, 22, 36, 10, 14]          
                                                                       
Maximum Priority Queue: 89  82  70  36  25  22  16  14  10
