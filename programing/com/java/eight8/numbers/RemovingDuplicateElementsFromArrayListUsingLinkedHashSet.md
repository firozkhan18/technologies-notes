# com\java\eight8\numbers\RemovingDuplicateElementsFromArrayListUsingLinkedHashSet.java

```java
package com.java.eight8.numbers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
//In this method, we use LinkedHashSet to remove duplicate elements from ArrayList. As you know that LinkedHashSet doesn’t allow duplicate elements and also maintains the insertion order of elements. Both these properties of LinkedHashSet is used here in order to remove duplicate elements from ArrayList and also maintain the insertion order of elements. 
public class RemovingDuplicateElementsFromArrayListUsingLinkedHashSet {
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

		// Constructing LinkedHashSet using listWithDuplicateElements

		LinkedHashSet<String> set = new LinkedHashSet<String>(listWithDuplicateElements);

		// Constructing listWithoutDuplicateElements using set

		ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set);

		// Printing listWithoutDuplicateElements

		System.out.print("ArrayList After Removing Duplicate Elements :");

		System.out.println(listWithoutDuplicateElements);
	}
}
```
