# com\java\eight8\employee\management\EmployeeDepartmentCount.java

```java
package com.java.eight8.employee.management;

//File: EmployeeDepartmentCount.java
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDepartmentCount {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore",0),
         new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai",0),
         new Employee(4, "Lakshmi", 45, 150000, "F", "HR", "Bangalore",0)
     );
//How do you get the number of employees in each department if you have given a list of employees?
     Map<String, Long> departmentCount = employees.stream()
                                                  .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

     departmentCount.forEach((deptName, count) -> System.out.println("Department: " + deptName + ", Number of Employees: " + count));
 }
}

```
