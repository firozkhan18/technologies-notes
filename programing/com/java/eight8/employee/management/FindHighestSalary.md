# com\java\eight8\employee\management\FindHighestSalary.java

```java
package com.java.eight8.employee.management;

//File: FindHighestSalary.java
import java.util.*;

public class FindHighestSalary {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai", 1995),
         new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore", 2000),
         new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai", 1998),
         new Employee(4, "Lakshmi", 28, 150000, "F", "HR", "Bangalore", 1992),
         new Employee(5, "Priya", 24, 90000, "F", "Marketing", "Delhi", 2005)
     );
     
//     3. The stream().mapToLong().max() pattern is employed to extract the salary attribute from each employee and find the maximum value.
//
//     4. The result is printed, showing the highest salary within the organization. If no employees are found or all have a salary of zero, it defaults to zero due to the use of orElse.

     long highestSalary = employees.stream()
                                   .mapToLong(Employee::getSalary)
                                   .max()
                                   .orElse(0);

     System.out.println("The highest salary in the organization is: " + highestSalary);
 }
}
```
