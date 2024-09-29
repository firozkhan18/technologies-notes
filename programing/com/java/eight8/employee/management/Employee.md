# com\java\eight8\employee\management\Employee.java

```java
package com.java.eight8.employee.management;

import java.util.Calendar;

// File: Employee.java
public class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender, String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    
    public long getSalary() {
        return salary;
    }
    public String getCity() {
        return city;
    }
    
    public int getExperience() {
        return Calendar.getInstance().get(Calendar.YEAR) - yearOfJoining;
    }
    
    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", salary=" + salary +
               ", gender='" + gender + '\'' +
               ", deptName='" + deptName + '\'' +
               ", city='" + city + '\'' +
               ", yearOfJoining=" + yearOfJoining +
               '}';
    }
}
```
