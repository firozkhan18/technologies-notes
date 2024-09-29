# com\java\eight8\array\EmployeeListDemo.java

```java
package com.java.eight8.array;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee1 {
    private String name;
    String gender;
    int age;
    private LocalDate dateOfJoining;
    private String department;
    private double salary;

    public Employee1(String name, String gender, int age, LocalDate dateOfJoining, String department, double salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    
    public double getAge() {
        return age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dateOfJoining=" + dateOfJoining +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeListDemo {

    public static void main(String[] args) {
        List<Employee1> employees = new ArrayList<>();
        employees.add(new Employee1("John Doe", "Male", 30, LocalDate.of(2015, 5, 15), "IT", 50000));
        employees.add(new Employee1("Jane Smith", "Female", 25, LocalDate.of(2018, 8, 20), "HR", 60000));
        employees.add(new Employee1("Tom Brown", "Male", 35, LocalDate.of(2010, 3, 10), "Finance", 70000));

        // Display all employees in the list
        employees.forEach(System.out::println);

        // Calculate the average salary of all employees in the list
        double averageSalary = employees.stream().mapToDouble(Employee1::getSalary).average().orElse(0);
        System.out.println("Average Salary: " + averageSalary);

        // Find the employee with the highest salary in the list
        Employee1 maxSalaryEmployee = employees.stream().max(Comparator.comparing(Employee1::getSalary)).orElse(null);
        System.out.println("Employee with the highest salary: " + maxSalaryEmployee);

        // Sort employees in the list based on their salaries in ascending order
        employees.sort(Comparator.comparing(Employee1::getSalary));
        System.out.println("Employees sorted by salary:");
        employees.forEach(System.out::println);

        // Find all employees who joined the company before a specified date
        LocalDate specifiedDate = LocalDate.of(2016, 1, 1);
        List<Employee1> employeesBeforeDate = employees.stream()
                .filter(e -> e.getDateOfJoining().isBefore(specifiedDate)).collect(Collectors.toList());
        System.out.println("Employees who joined before " + specifiedDate + ":");
        employeesBeforeDate.forEach(System.out::println);

        // Calculate the total number of male and female employees in the list
        long maleCount = employees.stream().filter(e -> e.gender.equals("Male")).count();
        long femaleCount = employees.stream().filter(e -> e.gender.equals("Female")).count();
        System.out.println("Total number of Male Employees: " + maleCount);
        System.out.println("Total number of Female Employees: " + femaleCount);

        // Calculate the average age of employees in each department
//        employees.stream()
//                .collect(
//                        Collectors.groupingBy(Employee1::getDepartment,
//                                Collectors.averagingInt(Employee1::getAge)))
//                .forEach((department, averageAge) -> System.out.println(department + ": " + averageAge));

        // Find the employee with the longest tenure in the company
        Employee1 longestTenureEmployee = employees.stream()
                .min(Comparator.comparing(Employee1::getDateOfJoining))
                .orElse(null);
        System.out.println("Employee with the longest tenure: " + longestTenureEmployee);
    }
}
```
