# com\java\eight8\employee\management\EmployeeOrganizationCount.java

```java
package com.java.eight8.employee.management;

import java.util.Arrays;
import java.util.List;

public class EmployeeOrganizationCount {

    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
            new Employee1("Rahul Gupta", "Male", "Infosys"),
            new Employee1("Priya Patil", "Female", "Infosys"),
            new Employee1("Amit Raj", "Male", "TCS"),
            new Employee1("Deepika Sharma", "Female", "TCS"),
            new Employee1("Vijay Kumar", "Male", "Infosys")
        );

        long malesInInfosys = employees.stream()
            .filter(e -> "Male".equals(e.getGender()) && "Infosys".equals(e.getOrganization()))
            .count();
        long femalesInInfosys = employees.stream()
            .filter(e -> "Female".equals(e.getGender()) && "Infosys".equals(e.getOrganization()))
            .count();
        long malesInTCS = employees.stream()
            .filter(e -> "Male".equals(e.getGender()) && "TCS".equals(e.getOrganization()))
            .count();
        long femalesInTCS = employees.stream()
            .filter(e -> "Female".equals(e.getGender()) && "TCS".equals(e.getOrganization()))
            .count();

        System.out.println("Male employees in Infosys: " + malesInInfosys);
        System.out.println("Female employees in Infosys: " + femalesInInfosys);
        System.out.println("Male employees in TCS: " + malesInTCS);
        System.out.println("Female employees in TCS: " + femalesInTCS);
    }
}

    class Employee1 {
        private String name;
        private String gender;
        private String organization;

        Employee1(String name, String gender, String organization) {
            this.name = name;
            this.gender = gender;
            this.organization = organization;
        }

        public String getGender() {
            return gender;
        }

        public String getOrganization() {
            return organization;
        }
    }
```
