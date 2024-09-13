# com\java\eight8\employee\management\FindSecondHighestSalary.java

```java
package com.java.eight8.employee.management;

// File: FindSecondHighestSalary.java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSecondHighestSalary {
    public static void main(String[] args) {    	
    	//2. a list of Employee objects is created, which includes potentially duplicate salary values.    	
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai", 1995),
            new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore", 2000),
            new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai", 1998),
            new Employee(4, "Lakshmi", 28, 150000, "F", "HR", "Bangalore", 1992),
            new Employee(5, "Priya", 24, 90000, "F", "Marketing", "Delhi", 2005),
            new Employee(6, "Rohit", 29, 150000, "M", "Engineering", "Bangalore", 1999)
        );
        //3. The stream().mapToLong().boxed() chain converts long salaries to Long objects, allowing them to be collected into a list that is then sorted in descending order and made distinct.
        long secondHighestSalary = employees.stream()
                                            .mapToLong(Employee::getSalary)
                                            .boxed()
                                            .distinct()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
        //4. The skip(1) method is used to bypass the highest salary, and findFirst() fetches the second highest.
                                            .findFirst()
        //5. The second highest salary is printed to the console. If not enough unique salaries exist, it defaults to zero.
                                            .orElse((long) 0);
        System.out.println("The second highest salary in the organization is: " + secondHighestSalary);
    }
}

```
