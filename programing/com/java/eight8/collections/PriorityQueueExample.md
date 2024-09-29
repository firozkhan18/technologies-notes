# com\java\eight8\collections\PriorityQueueExample.java

```java
package com.java.eight8.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
//If you are a Java developer, you wouldn’t have developed a single application without using collections in your code. Java collections are of great use when you are dealing with a group of objects. Some times you need to process the group of objects on a priority basis. You may need to order them on a particular criteria. For example, you may want to order employee records in the ascending order of their salaries or you may want to order the customers on their id’s. In such scenarios, PriorityQueue is of great help.
//
//
//In this particular article, we will discuss two examples of PriorityQueue – One with the default Comparator and another one with the customized comparator. You can go through the some basic definitions and properties of PriorityQueue here.
//
//Java PriorityQueue Example With Default Comparator :
//You already know that if you don’t supply the Comparator while creating a PriorityQueue, elements will be ordered in natural ascending order. In this example, we create a PriorityQueue of Integers without supplying a Comparator like this,
//

//PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
//As we are not passing any Comparator, elements of ‘pQueue‘ will be placed in the ascending order. Let’s add some elements to this PriorityQueue.
//

//pQueue.offer(21);
// 
//pQueue.offer(17);
// 
//pQueue.offer(37);
// 
//pQueue.offer(41);
// 
//pQueue.offer(9);
// 
//pQueue.offer(67);
// 
//pQueue.offer(31);
//You know that head element of the PriorityQueue always will be the least element. Let’s remove the elements of ‘pQueue’ one by one using poll() method ( poll() method removes the head of the queue ).
//

//System.out.println(pQueue.poll());     //Output : 9
// 
//System.out.println(pQueue.poll());     //Output : 17
// 
//System.out.println(pQueue.poll());     //Output : 21
// 
//System.out.println(pQueue.poll());     //Output : 31
// 
//System.out.println(pQueue.poll());     //Output : 37
// 
//System.out.println(pQueue.poll());     //Output : 41
// 
//System.out.println(pQueue.poll());     //Output : 67
//You can notice that always the least element is removed from the ‘pQueue’. That means elements in the ‘pQueue’ are placed in the ascending order. The whole example can be written like this,
//

//public class PriorityQueueExample
//{
//    public static void main(String[] args)
//    {
//        //Creating a PriorityQueue with default Comparator.
// 
//        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
// 
//        //Inserting elements into pQueue.
// 
//        pQueue.offer(21);
// 
//        pQueue.offer(17);
// 
//        pQueue.offer(37);
// 
//        pQueue.offer(41);
// 
//        pQueue.offer(9);
// 
//        pQueue.offer(67);
// 
//        pQueue.offer(31);
// 
//        //Removing the head elements
// 
//        System.out.println(pQueue.poll());     //Output : 9
// 
//        System.out.println(pQueue.poll());     //Output : 17
// 
//        System.out.println(pQueue.poll());     //Output : 21
// 
//        System.out.println(pQueue.poll());     //Output : 31
// 
//        System.out.println(pQueue.poll());     //Output : 37
// 
//        System.out.println(pQueue.poll());     //Output : 41
// 
//        System.out.println(pQueue.poll());     //Output : 67
//    }
//}
//Java PriorityQueue Example With Customized Comparator :
//In this example, we create a PriorityQueue with our own Comparator. We try to create a PriorityQueue of ‘Employee‘ objects ordered in the ascending order of their salaries. That means head element always will be an ‘Employee‘ object with lowest salary.
//
//Let’s define ‘Employee’ class with two attributes –  ‘name’ and ‘salary’.
//

//class Employee
//{
//    String name;
// 
//    int salary;
// 
//    //Constructor Of Employee
// 
//    public Employee(String name, int salary)
//    {
//        this.name = name;
// 
//        this.salary = salary;
//    }
// 
//    @Override
//    public String toString()
//    {
//        return name+" : "+salary;
//    }
//}
//In the above class, toString() method is overrided so that it returns the contents of the object.
//
//Let’s define our own Comparator class ‘MyComparator‘ which compares the salary of two Employees.
//
//1
//2
//3
//4
//5
//6
//7
//8
//class MyComparator implements Comparator<Employee>
//{
//    @Override
//    public int compare(Employee e1, Employee e2)
//    {
//        return e1.salary - e2.salary;
//    }
//}
//Let’s create a PriorityQueue of ‘Employee’ objects with ‘MyComparator‘ as a Comparator.
//
//1
//2
//3
//MyComparator comparator = new MyComparator();
// 
//PriorityQueue<Employee> pQueue = new PriorityQueue<Employee>(7, comparator);
//Let’s insert some ‘Employee’ objects into ‘pQueue’.
//
//1
//2
//3
//4
//5
//6
//7
//8
//9
//10
//11
//12
//13
//pQueue.offer(new Employee("AAA", 15000));
// 
//pQueue.offer(new Employee("BBB", 12000));
// 
//pQueue.offer(new Employee("CCC", 7500));
// 
//pQueue.offer(new Employee("DDD", 17500));
// 
//pQueue.offer(new Employee("EEE", 21500));
// 
//pQueue.offer(new Employee("FFF", 29000));
// 
//pQueue.offer(new Employee("GGG", 14300));
//Let’s remove the head elements of the ‘pQueue’ one by one.
//
//System.out.println(pQueue.poll());       //Output --> CCC : 7500
// 
//System.out.println(pQueue.poll());       //Output --> BBB : 12000
// 
//System.out.println(pQueue.poll());       //Output --> GGG : 14300
// 
//System.out.println(pQueue.poll());       //Output --> AAA : 15000
// 
//System.out.println(pQueue.poll());       //Output --> DDD : 17500
// 
//System.out.println(pQueue.poll());       //Output --> EEE : 21500
// 
//System.out.println(pQueue.poll());       //Output --> FFF : 29000
//You can notice that always an Employee of lowest salary is removed. That means, head element always contains Employee object with lowest salary. ‘Employee‘ objects in ‘pQueue‘ are placed in the ascending order of their salary.
//
//Here is the whole code of the above example.
//Employee Class

class Employee {
	String name;

	int salary;

	// Constructor Of Employee

	public Employee(String name, int salary) {
		this.name = name;

		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + " : " + salary;
	}
}

// MyComparator Class

class MyComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.salary - e2.salary;
	}
}

public class PriorityQueueExample {
	public static void main(String[] args) {
		// Instantiating MyComaparator

		MyComparator comparator = new MyComparator();

		// Creating PriorityQueue of Employee objects with MyComparator as Comparator

		PriorityQueue<Employee> pQueue = new PriorityQueue<Employee>(7, comparator);

		// Adding Employee objects to pQueue

		pQueue.offer(new Employee("AAA", 15000));

		pQueue.offer(new Employee("BBB", 12000));

		pQueue.offer(new Employee("CCC", 7500));

		pQueue.offer(new Employee("DDD", 17500));

		pQueue.offer(new Employee("EEE", 21500));

		pQueue.offer(new Employee("FFF", 29000));

		pQueue.offer(new Employee("GGG", 14300));

		// Removing the head elements

		System.out.println(pQueue.poll()); // Output --> CCC : 7500

		System.out.println(pQueue.poll()); // Output --> BBB : 12000

		System.out.println(pQueue.poll()); // Output --> GGG : 14300

		System.out.println(pQueue.poll()); // Output --> AAA : 15000

		System.out.println(pQueue.poll()); // Output --> DDD : 17500

		System.out.println(pQueue.poll()); // Output --> EEE : 21500

		System.out.println(pQueue.poll()); // Output --> FFF : 29000
	}
}
```
