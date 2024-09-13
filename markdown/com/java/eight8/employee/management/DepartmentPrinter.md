# com\java\eight8\employee\management\DepartmentPrinter.java

```java
package com.java.eight8.employee.management;

import java.util.Arrays;
import java.util.List;

public class DepartmentPrinter {
	static class Employee {
        String name;
        int age;
        String gender;
        String department;
        String organization;

        Employee(String name, int age, String gender, String department, String organization) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.organization = organization;
        }

        public String getDepartment() {
            return department;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Amit Singh", 34, "Male", "Finance", "Infosys"),
            new Employee("Deepa Patil", 29, "Female", "IT", "TCS"),
            new Employee("Rajesh Kumar", 42, "Male", "Finance", "Infosys"),
            new Employee("Lalitha Bhatt", 28, "Female", "HR", "Wipro"),
            new Employee("Suresh Raina", 30, "Male", "IT", "TCS"),
            new Employee("Gita Saxena", 31, "Female", "Marketing", "Infosys")
        );

        employees.stream()
                 .map(Employee::getDepartment)
                 .distinct()
                 .forEach(System.out::println);
    }
}
```
