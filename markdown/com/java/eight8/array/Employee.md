# com\java\eight8\array\Employee.java

```java
package com.java.eight8.array;

import java.time.LocalDate;

class Employee {
    private String name;
    private String gender;
    private int age;
    private LocalDate dateOfJoining;
    private String department;
    private double salary;

    public Employee(String name, String gender, int age, LocalDate dateOfJoining, String department, double salary) {
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

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dateOfJoining=" + dateOfJoining +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
```
