# com\java\eight8\collections\LinkedListInJava8.java

```java
package com.java.eight8.collections;

import java.util.LinkedList;

public class LinkedListInJava8 {
    
    public static void main(String[] args) {
        
        LinkedList<String> list = new LinkedList<String>();
        
        // Adding elements at the end of the list
        list.add("JAVA");
        list.add("J2EE");
        list.add("JSP");
        list.add("SERVLETS");
        list.add("JDBC");
        
        // Printing the elements of list
        list.forEach(System.out::println); // Output : JAVA J2EE JSP SERVLETS JDBC

        String s = "JSP";

        // Checking whether list contains "JSP"
        boolean containsJSP = list.stream().anyMatch(element -> element.equals(s));

        if (containsJSP) {
            // If list contains "JSP", printing it's index
            System.out.println(list.indexOf(s)); // Output : 2
        }

        String s1 = "STRUTS";
        // Checking whether list contains "STRUTS"
        boolean containsSTRUTS = list.stream().anyMatch(element -> element.equals(s1));

        if (containsSTRUTS) {
            // If list contains "STRUTS", printing it's index
            System.out.println(list.indexOf(s1));
        }
    }
}
```
