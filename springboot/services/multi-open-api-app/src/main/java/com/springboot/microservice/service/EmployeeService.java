package com.springboot.microservice.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.microservice.model.EmployeeList;

@Service
public class EmployeeService {

    //private final RestTemplate restTemplate;

    private final List<EmployeeList> empList = new ArrayList<>();
    
//    public EmployeeService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
    

    // Initializing the employee list
    public EmployeeService() {
        empList.add(new EmployeeList(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new EmployeeList(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new EmployeeList(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new EmployeeList(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new EmployeeList(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new EmployeeList(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new EmployeeList(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new EmployeeList(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new EmployeeList(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
    }

    // 1. Group by city
    public Map<String, List<EmployeeList>> groupByCity() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getCity));
    }

    // 2. Group by age
    public Map<Integer, List<EmployeeList>> groupByAge() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getAge));
    }

    // 3. Count by gender
    public Map<String, Long> countByGender() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getGender, Collectors.counting()));
    }

    // 4. Distinct department names
    public List<String> getDistinctDepartments() {
        return empList.stream().map(EmployeeList::getDeptName).distinct().collect(Collectors.toList());
    }

    // 5. Employees older than 28
    public List<EmployeeList> employeesOlderThan(int age) {
        return empList.stream().filter(e -> e.getAge() > age).collect(Collectors.toList());
    }

 // 6. Maximum age of employee
    public OptionalInt maxAge() {
        return empList.stream().mapToInt(EmployeeList::getAge).max();
    }

    // 7. Average age of Male and Female Employees
    public Map<String, Double> averageAgeByGender() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getGender, Collectors.averagingInt(EmployeeList::getAge)));
    }

    // 8. Count of employees in each department
    public Map<String, Long> countByDepartment() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName, Collectors.counting()));
    }

    // 9. Find oldest employee
    public Optional<EmployeeList> oldestEmployee() {
        return empList.stream().max(Comparator.comparingInt(EmployeeList::getAge));
    }

    // 10. Find youngest female employee
    public Optional<EmployeeList> youngestFemaleEmployee() {
        return empList.stream().filter(e -> "F".equals(e.getGender())).min(Comparator.comparingInt(EmployeeList::getAge));
    }

    // 11. Partition employees by age
    public Map<Boolean, List<EmployeeList>> partitionEmployeesByAge() {
        return empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
    }

    // 12. Department with highest number of employees
    public Map.Entry<String, Long> departmentWithMostEmployees() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
    }

    // 13. Check if any employees from HR department
    public Optional<EmployeeList> anyEmployeeFromHR() {
        return empList.stream().filter(e -> "HR".equalsIgnoreCase(e.getDeptName())).findAny();
    }

    // 14. Department names with more than 3 employees
    public List<String> departmentsWithMoreThan3Employees() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 3)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    // 15. Distinct department names
    public List<String> distinctDepartmentNames() {
        return empList.stream().map(EmployeeList::getDeptName).distinct().collect(Collectors.toList());
    }

    // 16. Employees in 'Blore', sorted by name
    public List<String> employeesInBlore() {
        return empList.stream()
                .filter(e -> "Blore".equalsIgnoreCase(e.getCity()))
                .sorted(Comparator.comparing(EmployeeList::getName))
                .map(EmployeeList::getName)
                .collect(Collectors.toList());
    }

    // 17. Total number of employees
    public long totalEmployees() {
        return empList.size();
    }

    // 18. Employee count in every department
    public Map<String, Long> employeeCountInDepartments() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName, Collectors.counting()));
    }

    // 19. Department with highest number of employees
    public Optional<Map.Entry<String, Long>> departmentWithHighestEmployees() {
        return employeeCountInDepartments().entrySet().stream().max(Map.Entry.comparingByValue());
    }

    // 20. Sorting employees by name and age
    public List<EmployeeList> sortEmployeesByNameAndAge() {
        return empList.stream()
                .sorted(Comparator.comparing(EmployeeList::getName).thenComparingInt(EmployeeList::getAge))
                .collect(Collectors.toList());
    }

    // 21. Highest experienced employee
    public Optional<EmployeeList> highestExperienceEmployee() {
        return empList.stream().min(Comparator.comparingInt(EmployeeList::getYearOfJoining));
    }

    // 22. Average and total salary
    public DoubleSummaryStatistics salaryStatistics() {
        return empList.stream().collect(Collectors.summarizingDouble(EmployeeList::getSalary));
    }

    // 23. Average salary by department
    public Map<String, Double> averageSalaryByDepartment() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName, Collectors.averagingDouble(EmployeeList::getSalary)));
    }

    // 24. Highest salary in the organization
    public Optional<EmployeeList> highestSalaryEmployee() {
        return empList.stream().max(Comparator.comparingDouble(EmployeeList::getSalary));
    }

    // 25. Second highest salary in the organization
    public Optional<EmployeeList> secondHighestSalaryEmployee() {
        return empList.stream().sorted(Comparator.comparingDouble(EmployeeList::getSalary).reversed()).skip(1).findFirst();
    }

    // 26. Nth highest salary
    public Optional<EmployeeList> nthHighestSalaryEmployee(int n) {
        return empList.stream().sorted(Comparator.comparingDouble(EmployeeList::getSalary).reversed()).skip(n - 1).findFirst();
    }

    // 27. Highest paid salary by gender
    public Map<String, Optional<EmployeeList>> highestPaidByGender() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getGender,
                Collectors.maxBy(Comparator.comparingDouble(EmployeeList::getSalary))));
    }

    // 28. Lowest paid salary by gender
    public Map<String, Optional<EmployeeList>> lowestPaidByGender() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getGender,
                Collectors.minBy(Comparator.comparingDouble(EmployeeList::getSalary))));
    }

    // 29. Sort salaries in ascending order
    public List<EmployeeList> sortSalariesAscending() {
        return empList.stream().sorted(Comparator.comparingDouble(EmployeeList::getSalary)).collect(Collectors.toList());
    }

    // 30. Sort salaries in descending order
    public List<EmployeeList> sortSalariesDescending() {
        return empList.stream().sorted(Comparator.comparingDouble(EmployeeList::getSalary).reversed()).collect(Collectors.toList());
    }

    // 31. Highest salary by department
    public Map<String, Optional<EmployeeList>> highestSalaryByDepartment() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().max(Comparator.comparingDouble(EmployeeList::getSalary)))));
    }

    // 32. Second highest salary by department
    public Map<String, Optional<EmployeeList>> secondHighestSalaryByDepartment() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparingDouble(EmployeeList::getSalary).reversed()).skip(1).findFirst())));
    }

    // 33. Sort employees' salaries in each department in ascending order
    public Map<String, List<EmployeeList>> sortSalariesAscByDepartment() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName,
                Collectors.mapping(e -> e, Collectors.toList())));
    }

    // 34. Sort employees' salaries in each department in descending order
    public Map<String, List<EmployeeList>> sortSalariesDescByDepartment() {
        return empList.stream().collect(Collectors.groupingBy(EmployeeList::getDeptName,
                Collectors.mapping(e -> e, Collectors.toList())));
    }
    // Other functionalities can be similarly added...

//    public List<Employee> getEmployeesOver50(String apiUrl) {
//        Employee[] employees = restTemplate.getForObject(apiUrl, Employee[].class);
//        return Arrays.stream(employees)
//                .filter(employee -> employee.getAge() > 50)
//                .collect(Collectors.toList());
//    }
//    
//    public Map<String, List<Employee>> getEmployeesGroupedByCity() {
//        return restTemplate.getForObject("http://localhost:8080/api/employees/group-by-city", Map.class);
//    }
}
