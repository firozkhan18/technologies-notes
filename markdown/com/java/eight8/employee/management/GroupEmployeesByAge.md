# com\java\eight8\employee\management\GroupEmployeesByAge.java

```java
package com.java.eight8.employee.management;

//File: GroupEmployeesByAge.java
import java.util.*;
import java.util.stream.Collectors;

public class GroupEmployeesByAge {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 34, 130000, "M", "Tech", "Bangalore",0),
         new Employee(3, "Vishal", 34, 110000, "M", "Tech", "Mumbai",0),
         new Employee(4, "Lakshmi", 45, 150000, "F", "HR", "Bangalore",0)
     );

     Map<Integer, List<Employee>> groupedByAge = employees.stream()
         .collect(Collectors.groupingBy(Employee::getAge));

     groupedByAge.forEach((age, empList) -> {
         System.out.println("Age: " + age);
         empList.forEach(System.out::println);
     });
 }
}
```
