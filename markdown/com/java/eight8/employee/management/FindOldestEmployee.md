# com\java\eight8\employee\management\FindOldestEmployee.java

```java
package com.java.eight8.employee.management;

//File: FindOldestEmployee.java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindOldestEmployee {
 public static void main(String[] args) {
     List<Employee> employees = Arrays.asList(
         new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai",0),
         new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore",0),
         new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai",0),
         new Employee(4, "Lakshmi", 45, 150000, "F", "HR", "Bangalore",0)
     );

     Employee oldest = employees.stream()
                                .max(Comparator.comparingInt(Employee::getAge))
                                .orElse(null);

     if (oldest != null) {
         System.out.println("Oldest employee: " + oldest);
     } else {
         System.out.println("No employees found.");
     }
 }
}
```
