package com.springboot.microservice.service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.microservice.model.Employee;
import com.springboot.microservice.model.EmployeeList;

import reactor.core.publisher.Mono;

@Service
public class ApiService {
	
	 private final String BASE_URL = "http://localhost:8080/employees"; // Change this to your actual API endpoint

    private final WebClient webClient;

    public ApiService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(BASE_URL).build();
    }

//    public Mono<Map<String, List<Employee>>> getEmployeesGroupedByCity() {
//        return webClient.get()
//                .uri("/group-by-city")
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<Map<String, List<Employee>>>() {});
//    }      

    // 1. Group by city
    public Mono<Map<String, List<EmployeeList>>> groupByCity() {
        return webClient.get()
                .uri("/groupByCity")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, List<EmployeeList>>>() {});
    }

    // 2. Group by age
    public Mono<Map<Integer, List<EmployeeList>>> groupByAge() {
        return webClient.get()
                .uri("/groupByAge")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<Integer, List<EmployeeList>>>() {});
    }

    // 3. Count by gender
    public Mono<Map<String, Long>> countByGender() {
        return webClient.get()
                .uri("/countByGender")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Long>>() {});
    }

    // 4. Distinct department names
    public Mono<List<String>> getDistinctDepartments() {
        return webClient.get()
                .uri("/distinctDepartments")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {});
    }

    // 5. Employees older than specified age
    public Mono<List<EmployeeList>> employeesOlderThan(int age) {
        return webClient.get()
                .uri("/olderThan/{age}", age)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EmployeeList>>() {});
    }

    // 6. Maximum age of employee
    public Mono<OptionalInt> maxAge() {
        return webClient.get()
                .uri("/maxAge")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<OptionalInt>() {});
    }

    // 7. Average age of Male and Female Employees
    public Mono<Map<String, Double>> averageAgeByGender() {
        return webClient.get()
                .uri("/averageAgeByGender")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Double>>() {});
    }

    // 8. Count of employees in each department
    public Mono<Map<String, Long>> countByDepartment() {
        return webClient.get()
                .uri("/countByDepartment")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Long>>() {});
    }

    // 9. Find oldest employee
    public Mono<Optional<EmployeeList>> oldestEmployee() {
        return webClient.get()
                .uri("/oldestEmployee")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<EmployeeList>>() {});
    }

    // 10. Find youngest female employee
    public Mono<Optional<EmployeeList>> youngestFemaleEmployee() {
        return webClient.get()
                .uri("/youngestFemaleEmployee")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<EmployeeList>>() {});
    }

    // 11. Partition employees by age
    public Mono<Map<Boolean, List<EmployeeList>>> partitionEmployeesByAge() {
        return webClient.get()
                .uri("/partitionByAge")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<Boolean, List<EmployeeList>>>() {});
    }

    // 12. Department with highest number of employees
    public Mono<Map.Entry<String, Long>> departmentWithMostEmployees() {
        return webClient.get()
                .uri("/departmentWithMostEmployees")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map.Entry<String, Long>>() {});
    }

    // 13. Check if any employees from HR department
    public Mono<Optional<EmployeeList>> anyEmployeeFromHR() {
        return webClient.get()
                .uri("/anyEmployeeFromHR")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<EmployeeList>>() {});
    }

    // 14. Department names with more than 3 employees
    public Mono<List<String>> departmentsWithMoreThan3Employees() {
        return webClient.get()
                .uri("/departmentsWithMoreThan3Employees")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {});
    }

    // 15. Distinct department names
    public Mono<List<String>> distinctDepartmentNames() {
        return webClient.get()
                .uri("/distinctDepartmentNames")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {});
    }

    // 16. Employees in 'Blore', sorted by name
    public Mono<List<String>> employeesInBlore() {
        return webClient.get()
                .uri("/employeesInBlore")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {});
    }

    // 17. Total number of employees
    public Mono<Long> totalEmployees() {
        return webClient.get()
                .uri("/totalEmployees")
                .retrieve()
                .bodyToMono(Long.class);
    }

    // 18. Employee count in every department
    public Mono<Map<String, Long>> employeeCountInDepartments() {
        return webClient.get()
                .uri("/employeeCountInDepartments")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Long>>() {});
    }

    // 19. Department with highest number of employees
    public Mono<Optional<Map.Entry<String, Long>>> departmentWithHighestEmployees() {
        return webClient.get()
                .uri("/departmentWithHighestEmployees")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<Map.Entry<String, Long>>>() {});
    }

    // 20. Sorting employees by name and age
    public Mono<List<EmployeeList>> sortEmployeesByNameAndAge() {
        return webClient.get()
                .uri("/sortByNameAndAge")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EmployeeList>>() {});
    }

    // 21. Highest experienced employee
    public Mono<Optional<EmployeeList>> highestExperienceEmployee() {
        return webClient.get()
                .uri("/highestExperienceEmployee")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<EmployeeList>>() {});
    }

    // 22. Average and total salary
    public Mono<DoubleSummaryStatistics> salaryStatistics() {
        return webClient.get()
                .uri("/salaryStatistics")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<DoubleSummaryStatistics>() {});
    }

    // 23. Average salary by department
    public Mono<Map<String, Double>> averageSalaryByDepartment() {
        return webClient.get()
                .uri("/averageSalaryByDepartment")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Double>>() {});
    }

    // 24. Highest salary in the organization
    public Mono<Optional<EmployeeList>> highestSalaryEmployee() {
        return webClient.get()
                .uri("/highestSalaryEmployee")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<EmployeeList>>() {});
    }

    // 25. Second highest salary in the organization
    public Mono<Optional<EmployeeList>> secondHighestSalaryEmployee() {
        return webClient.get()
                .uri("/secondHighestSalaryEmployee")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<EmployeeList>>() {});
    }

    // 26. Nth highest salary
    public Mono<Optional<EmployeeList>> nthHighestSalaryEmployee(int n) {
        return webClient.get()
                .uri("/nthHighestSalary/{n}", n)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Optional<EmployeeList>>() {});
    }

    // 27. Highest paid salary by gender
    public Mono<Map<String, Optional<EmployeeList>>> highestPaidByGender() {
        return webClient.get()
                .uri("/highestPaidByGender")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Optional<EmployeeList>>>() {});
    }

    // 28. Lowest paid salary by gender
    public Mono<Map<String, Optional<EmployeeList>>> lowestPaidByGender() {
        return webClient.get()
                .uri("/lowestPaidByGender")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Optional<EmployeeList>>>() {});
    }

    // 29. Sort salaries in ascending order
    public Mono<List<EmployeeList>> sortSalariesAscending() {
        return webClient.get()
                .uri("/sortSalariesAscending")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EmployeeList>>() {});
    }

    // 30. Sort salaries in descending order
    public Mono<List<EmployeeList>> sortSalariesDescending() {
        return webClient.get()
                .uri("/sortSalariesDescending")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EmployeeList>>() {});
    }

    // 31. Highest salary by department
    public Mono<Map<String, Optional<EmployeeList>>> highestSalaryByDepartment() {
        return webClient.get()
                .uri("/highestSalaryByDepartment")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Optional<EmployeeList>>>() {});
    }

    // 32. Second highest salary by department
    public Mono<Map<String, Optional<EmployeeList>>> secondHighestSalaryByDepartment() {
        return webClient.get()
                .uri("/secondHighestSalaryByDepartment")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Optional<EmployeeList>>>() {});
    }

    // 33. Sort employees' salaries in each department in ascending order
    public Mono<Map<String, List<EmployeeList>>> sortSalariesAscByDepartment() {
        return webClient.get()
                .uri("/sortSalariesAscByDepartment")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, List<EmployeeList>>>() {});
    }

    // 34. Sort employees' salaries in each department in descending order
    public Mono<Map<String, List<EmployeeList>>> sortSalariesDescByDepartment() {
        return webClient.get()
                .uri("/sortSalariesDescByDepartment")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, List<EmployeeList>>>() {});
    }
}

