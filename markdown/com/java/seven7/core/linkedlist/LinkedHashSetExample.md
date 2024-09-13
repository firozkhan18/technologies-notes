# com\java\seven7\core\linkedlist\LinkedHashSetExample.java

```java
package com.java.seven7.core.linkedlist;

import java.util.Iterator;
import java.util.LinkedHashSet;

//As you already know, LinkedHashSet is an ordered version of HashSet. That means, HashSet doesn’t maintain any order where as LinkedHashSet maintains insertion order of the elements. LinkedHashSet uses doubly linked list internally to maintain the insertion order of it’s elements. We have seen this in How LinkedHashSet Works Internally In Java?. As LinkedHashSet maintains doubly linked list (along with HashMap), the performance of LinkedHashSet is slightly slower than the HashSet. But, LinkedHashSet will be very useful when you need a collection of elements placed in the order they have inserted. We will see one such example of LinkedHashSet in this article.
//
//Let’s consider that you want to create a pool of customers placed in the order they have arrived. Assume that it is also mandatory that duplicate customers must not be allowed. For such requirements, LinkedHashSet is the best suitable. In this article, we will try to implement this example using LinkedHashSet class.
//
//Let’s create Customer class with two fields – name and id.
//
//class Customer
//{
//    String name;
// 
//    int id;
// 
//    public Customer(String name, int id)
//    {
//        this.name = name;
// 
//        this.id = id;
//    }
// 
//    @Override
//    public int hashCode()
//    {
//        return id;
//    }
// 
//    @Override
//    public boolean equals(Object obj)
//    {
//        Customer customer = (Customer) obj;
// 
//        return (id == customer.id);
//    }
// 
//    @Override
//    public String toString()
//    {
//        return id+" : "+name;
//    }
//}
//You might have observed that equals() and hashCode() methods in the above class are overrided so that Customer objects will be compared solely based on id. That means two Customer objects having same id will be considered as duplicates and they will not be allowed in the pool.
//
//Create one LinkedHashSet object containing elements of Customer type.
//
//LinkedHashSet<Customer> set = new LinkedHashSet<Customer>();
//Add some elements to this set.
//
//set.add(new Customer("Jack", 021));
// 
//set.add(new Customer("Peter", 105));
// 
//set.add(new Customer("Ramesh", 415));    
// 
//set.add(new Customer("Julian", 814));
// 
//set.add(new Customer("Avinash", 105));      //Duplicate Element
// 
//set.add(new Customer("Sapna", 879));
// 
//set.add(new Customer("John", 546));
// 
//set.add(new Customer("Moni", 254));
// 
//set.add(new Customer("Ravi", 105));        //Duplicate Element
//Iterate through this LinkedHashSet.
//
//Iterator<Customer> it = set.iterator();
// 
//while (it.hasNext())
//{
//    Customer customer = (Customer) it.next();
// 
//    System.out.println(customer);
//}
//Output will be,
//
//17 : Jack
//105 : Peter
//415 : Ramesh
//814 : Julian
//879 : Sapna
//546 : John
//254 : Moni
//You can notice that Customer objects are placed in the order they are inserted into the set and also duplicate elements are avoided.
//
//Below is the code for the whole program.

class Customer {
	String name;

	int id;

	public Customer(String name, int id) {
		this.name = name;

		this.id = id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		Customer customer = (Customer) obj;

		return (id == customer.id);
	}

	@Override
	public String toString() {
		return id + " : " + name;
	}
}

public class LinkedHashSetExample {
	public static void main(String[] args) {
		// Creating LinkedHashSet

		LinkedHashSet<Customer> set = new LinkedHashSet<Customer>();

		// Adding elements to LinkedHashSet

		set.add(new Customer("Jack", 021));

		set.add(new Customer("Peter", 105));

		set.add(new Customer("Ramesh", 415));

		set.add(new Customer("Julian", 814));

		set.add(new Customer("Avinash", 105)); // Duplicate Element

		set.add(new Customer("Sapna", 879));

		set.add(new Customer("John", 546));

		set.add(new Customer("Moni", 254));

		set.add(new Customer("Ravi", 105)); // Duplicate Element

		// Getting Iterator object

		Iterator<Customer> it = set.iterator();

		while (it.hasNext()) {
			Customer customer = (Customer) it.next();

			System.out.println(customer);
		}
	}
}
```
