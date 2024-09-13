# com\java\eight8\employee\management\CheckHRDepartment.java

```java
package com.java.eight8.employee.management;

//File: CheckHRDepartment.java
import java.util.*;

public class CheckHRDepartment {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore",0),
         new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai",0),
         new Employee(4, "Lakshmi", 28, 150000, "F", "HR", "Bangalore",0),
         new Employee(5, "Priya", 24, 90000, "F", "Marketing", "Delhi",0)
     );

     boolean hasHREmployees = employees.stream()
                                       .anyMatch(e -> "HR".equals(e.getDeptName()));

     System.out.println("Are there any HR department employees? " + (hasHREmployees ? "Yes" : "No"));
 }
}
```
