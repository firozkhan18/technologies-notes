# com\java\eight8\numbers\RemovingDuplicateElementsFromArrayListUsingHashSet.java

```java
package com.java.eight8.numbers;

import java.util.ArrayList;
import java.util.HashSet;

//In this method, we use HashSet to remove duplicate elements from an ArrayList. As you know, HashSet doesn’t allow duplicate elements. We use this property of HashSet to remove duplicate elements from already constructed ArrayList. But, there is one disadvantage of this method. That is, it erases the insertion order of ArrayList elements. That means, after removing the duplicate elements, elements will not be in the insertion order. 
public class RemovingDuplicateElementsFromArrayListUsingHashSet {
	public static void main(String[] args) {
		// Constructing An ArrayList

		ArrayList<String> listWithDuplicateElements = new ArrayList<String>();

		listWithDuplicateElements.add("JAVA");

		listWithDuplicateElements.add("J2EE");

		listWithDuplicateElements.add("JSP");

		listWithDuplicateElements.add("SERVLETS");

		listWithDuplicateElements.add("JAVA");

		listWithDuplicateElements.add("STRUTS");

		listWithDuplicateElements.add("JSP");

		// Printing listWithDuplicateElements

		System.out.print("ArrayList With Duplicate Elements :");

		System.out.println(listWithDuplicateElements);

		// Constructing HashSet using listWithDuplicateElements

		HashSet<String> set = new HashSet<String>(listWithDuplicateElements);

		// Constructing listWithoutDuplicateElements using set

		ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set);

		// Printing listWithoutDuplicateElements

		System.out.print("ArrayList After Removing Duplicate Elements :");

		System.out.println(listWithoutDuplicateElements);
	}
	
	//You notice the output of the above example. Elements are shuffled after duplicate elements are removed. They are not in the insertion order. If you want insertion order of elements to be maintained even after removing the duplicate elements, then this method is not recommended. There is another method exist which doesn’t alter the insertion order of elements even after removing the duplicate elements. That is using LinkedHashSet.
}
```
