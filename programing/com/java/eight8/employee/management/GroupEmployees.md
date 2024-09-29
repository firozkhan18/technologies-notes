# com\java\eight8\employee\management\GroupEmployees.java

```java
package com.java.eight8.employee.management;

//File: GroupEmployees.java
import java.util.*;
import java.util.stream.Collectors;

public class GroupEmployees {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 34, 130000, "M", "Tech", "Bangalore",0),
         new Employee(3, "Vishal", 28, 110000, "M", "Tech", "Mumbai",0),
         new Employee(4, "Lakshmi", 45, 150000, "F", "HR", "Bangalore",0)
     );

     Map<String, List<Employee>> groupedByCity = employees.stream()
         .collect(Collectors.groupingBy(Employee::getCity));

     groupedByCity.forEach((city, empList) -> {
         System.out.println("City: " + city);
         empList.forEach(System.out::println);
     });
 }
}
```
