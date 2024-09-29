# com\java\eight8\employee\management\FindLargestDepartment.java

```java
package com.java.eight8.employee.management;

//File: FindLargestDepartment.java
import java.util.*;
import java.util.stream.Collectors;

public class FindLargestDepartment {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore",0),
         new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai",0),
         new Employee(4, "Lakshmi", 28, 150000, "F", "HR", "Bangalore",0),
         new Employee(5, "Priya", 24, 90000, "F", "Marketing", "Delhi",0)
     );

     Map<String, Long> departmentCounts = employees.stream()
         .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

//     Optional<Map.Entry<String, Long>> maxDept = departmentCounts.entrySet()
//         .stream()
//         .max(Map.Entry.comparingByValue());
//
//     if (maxDept.isPresent()) {
//         System.out.println("Department with the most employees: " + maxDept.get().getKey() +
//                            " (" + maxDept.get().getValue() + " employees)");
//     } else {
//         System.out.println("No departments found.");
//     }


         long maxCount = departmentCounts.values().stream().max(Long::compare).orElse(0L);

         System.out.println("Departments with the most employees:");
         departmentCounts.entrySet()
             .stream()
             .filter(entry -> entry.getValue() == maxCount)
             .forEach(entry -> System.out.println(entry.getKey() + " (" + entry.getValue() + " employees)"));
 }
}
```
