# com\java\eight8\employee\management\FilterEmployeesByAge.java

```java
package com.java.eight8.employee.management;

//File: FilterEmployeesByAge.java
import java.util.*;

public class FilterEmployeesByAge {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 25, 130000, "M", "Tech", "Bangalore",0),
         new Employee(3, "Vishal", 34, 110000, "M", "Tech", "Mumbai",0),
         new Employee(4, "Lakshmi", 45, 150000, "F", "HR", "Bangalore",0)
     );

     employees.stream()
              .filter(emp -> emp.getAge() > 28)
              .forEach(System.out::println);
 }
}
```
