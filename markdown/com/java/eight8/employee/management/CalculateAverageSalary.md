# com\java\eight8\employee\management\CalculateAverageSalary.java

```java
package com.java.eight8.employee.management;

//File: CalculateAverageSalary.java
import java.util.*;
import java.util.stream.Collectors;

public class CalculateAverageSalary {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore",0),
         new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai",0),
         new Employee(4, "Lakshmi", 28, 150000, "F", "HR", "Bangalore",0),
         new Employee(5, "Priya", 24, 90000, "F", "Marketing", "Delhi",0)
     );

//     Map<String, Double> averageSalaries = employees.stream()
//         .collect(Collectors.groupingBy(Employee::getDeptName,
//                                        Collectors.averagingDouble(Employee::getSalary)));
//
//     averageSalaries.forEach((dept, avgSalary) ->
//         System.out.println("Department: " + dept + ", Average Salary: " + avgSalary));
     
     employees.stream()
     .collect(Collectors.groupingBy(Employee::getDeptName,
                                    Collectors.averagingDouble(Employee::getSalary)))
     .forEach((dept, avgSalary) -> System.out.println("Department: " + dept + ", Average Salary: " + avgSalary));
     
     System.out.println("============================================================================");
     
     Map<String, Double> avgSalaryPerDept = employees.stream()
    		    .collect(Collectors.groupingBy(
    		        Employee::getDeptName,
    		        Collectors.averagingDouble(Employee::getSalary)
    		    ));
     
     Map<String, Double> avgSalaryMap = avgSalaryPerDept.entrySet()
    		    .stream()
    		    .collect(Collectors.toMap(
    		        Map.Entry::getKey,
    		        Map.Entry::getValue
    		    ));
     
     avgSalaryMap.forEach((dept, avgSalary) -> 
     System.out.println("Department: " + dept + ", Average Salary: " + avgSalary));

 }
}
```
