package com.springboot.microservice.rest;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.model.EmployeeList;
import com.springboot.microservice.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee Rest API", description = "Rest Endpoints for Employee Management Operations")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/groupByCity")
	@Operation(summary = "Fetches employees group by city") // Use @Operation instead of @ApiOperation
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved data"), // Use responseCode instead of code
        @ApiResponse(responseCode = "500", description = "Internal server error") // Use responseCode instead of code
    })
	public Map<String, List<EmployeeList>> getEmployeesGroupedByCity() {
		return employeeService.groupByCity();
	}

	@GetMapping("/groupByAge")
	public Map<Integer, List<EmployeeList>> getEmployeesGroupedByAge() {
		return employeeService.groupByAge();
	}

	@GetMapping("/countByGender")
	public Map<String, Long> getCountByGender() {
		return employeeService.countByGender();
	}

	@GetMapping("/distinctDepartments")
	public List<String> getDistinctDepartments() {
		return employeeService.getDistinctDepartments();
	}

	@GetMapping("/olderThan/{age}")
	public List<EmployeeList> getEmployeesOlderThan(@PathVariable int age) {
		return employeeService.employeesOlderThan(age);
	}

	// 6. Maximum age of employee
	@GetMapping("/maxAge")
	public OptionalInt maxAge() {
		return employeeService.maxAge();
	}

	// 7. Average age of Male and Female Employees
	@GetMapping("/averageAgeByGender")
	public Map<String, Double> averageAgeByGender() {
		return employeeService.averageAgeByGender();
	}

	// 8. Count of employees in each department
	@GetMapping("/countByDepartment")
	public Map<String, Long> countByDepartment() {
		return employeeService.countByDepartment();
	}

	// 9. Find oldest employee
	@GetMapping("/oldestEmployee")
	public Optional<EmployeeList> oldestEmployee() {
		return employeeService.oldestEmployee();
	}

	// 10. Find youngest female employee
	@GetMapping("/youngestFemaleEmployee")
	public Optional<EmployeeList> youngestFemaleEmployee() {
		return employeeService.youngestFemaleEmployee();
	}

	// 11. Partition employees by age
	@GetMapping("/partitionByAge")
	public Map<Boolean, List<EmployeeList>> partitionEmployeesByAge() {
		return employeeService.partitionEmployeesByAge();
	}

	// 12. Department with highest number of employees
	@GetMapping("/departmentWithMostEmployees")
	public Map.Entry<String, Long> departmentWithMostEmployees() {
		return employeeService.departmentWithMostEmployees();
	}

	// 13. Check if any employees from HR department
	@GetMapping("/anyEmployeeFromHR")
	public Optional<EmployeeList> anyEmployeeFromHR() {
		return employeeService.anyEmployeeFromHR();
	}

	// 14. Department names with more than 3 employees
	@GetMapping("/departmentsWithMoreThan3Employees")
	public List<String> departmentsWithMoreThan3Employees() {
		return employeeService.departmentsWithMoreThan3Employees();
	}

	// 15. Distinct department names
	@GetMapping("/distinctDepartmentNames")
	public List<String> distinctDepartmentNames() {
		return employeeService.distinctDepartmentNames();
	}

	// 16. Employees in 'Blore', sorted by name
	@GetMapping("/employeesInBlore")
	public List<String> employeesInBlore() {
		return employeeService.employeesInBlore();
	}

	// 17. Total number of employees
	@GetMapping("/totalEmployees")
	public long totalEmployees() {
		return employeeService.totalEmployees();
	}

	// 18. Employee count in every department
	@GetMapping("/employeeCountInDepartments")
	public Map<String, Long> employeeCountInDepartments() {
		return employeeService.employeeCountInDepartments();
	}

	// 19. Department with highest number of employees
	@GetMapping("/departmentWithHighestEmployees")
	public Optional<Map.Entry<String, Long>> departmentWithHighestEmployees() {
		return employeeService.departmentWithHighestEmployees();
	}

	// 20. Sorting employees by name and age
	@GetMapping("/sortByNameAndAge")
	public List<EmployeeList> sortEmployeesByNameAndAge() {
		return employeeService.sortEmployeesByNameAndAge();
	}

	// 21. Highest experienced employee
	@GetMapping("/highestExperienceEmployee")
	public Optional<EmployeeList> highestExperienceEmployee() {
		return employeeService.highestExperienceEmployee();
	}

	// 22. Average and total salary
	@GetMapping("/salaryStatistics")
	public DoubleSummaryStatistics salaryStatistics() {
		return employeeService.salaryStatistics();
	}

	// 23. Average salary by department
	@GetMapping("/averageSalaryByDepartment")
	public Map<String, Double> averageSalaryByDepartment() {
		return employeeService.averageSalaryByDepartment();
	}

	// 24. Highest salary in the organization
	@GetMapping("/highestSalaryEmployee")
	public Optional<EmployeeList> highestSalaryEmployee() {
		return employeeService.highestSalaryEmployee();
	}

	// 25. Second highest salary in the organization
	@GetMapping("/secondHighestSalaryEmployee")
	public Optional<EmployeeList> secondHighestSalaryEmployee() {
		return employeeService.secondHighestSalaryEmployee();
	}

	// 26. Nth highest salary
	@GetMapping("/nthHighestSalary/{n}")
	public Optional<EmployeeList> nthHighestSalaryEmployee(@PathVariable int n) {
		return employeeService.nthHighestSalaryEmployee(n);
	}

	// 27. Highest paid salary by gender
	@GetMapping("/highestPaidByGender")
	public Map<String, Optional<EmployeeList>> highestPaidByGender() {
		return employeeService.highestPaidByGender();
	}

	// 28. Lowest paid salary by gender
	@GetMapping("/lowestPaidByGender")
	public Map<String, Optional<EmployeeList>> lowestPaidByGender() {
		return employeeService.lowestPaidByGender();
	}

	// 29. Sort salaries in ascending order
	@GetMapping("/sortSalariesAscending")
	public List<EmployeeList> sortSalariesAscending() {
		return employeeService.sortSalariesAscending();
	}

	// 30. Sort salaries in descending order
	@GetMapping("/sortSalariesDescending")
	public List<EmployeeList> sortSalariesDescending() {
		return employeeService.sortSalariesDescending();
	}

	// 31. Highest salary by department
	@GetMapping("/highestSalaryByDepartment")
	public Map<String, Optional<EmployeeList>> highestSalaryByDepartment() {
		return employeeService.highestSalaryByDepartment();
	}

	// 32. Second highest salary by department
	@GetMapping("/secondHighestSalaryByDepartment")
	public Map<String, Optional<EmployeeList>> secondHighestSalaryByDepartment() {
		return employeeService.secondHighestSalaryByDepartment();
	}

	// 33. Sort employees' salaries in each department in ascending order
	@GetMapping("/sortSalariesAscByDepartment")
	public Map<String, List<EmployeeList>> sortSalariesAscByDepartment() {
		return employeeService.sortSalariesAscByDepartment();
	}

	// 34. Sort employees' salaries in each department in descending order
	@GetMapping("/sortSalariesDescByDepartment")
	public Map<String, List<EmployeeList>> sortSalariesDescByDepartment() {
		return employeeService.sortSalariesDescByDepartment();
	}

//    @GetMapping("/employees/age_greater_than_50")
//    public List<Employee> getEmployeesOver50() {
//        return employeeRepository.findByAgeGreaterThan(50);
//    }

//    @GetMapping("/employees/age_greater_than_50")
//    public List<Employee> getEmployeesOver50(@RequestParam String apiUrl) {
//        return employeeService.getEmployeesOver50(apiUrl);
//    }
//    
//    @GetMapping("/group-by-city")
//    public Map<String, List<Employee>> groupByCity() {
//        return employeeService.groupByCity();
//    }
//
//    @GetMapping("/group-by-age")
//    public Map<Integer, List<Employee>> groupByAge() {
//        return employeeService.groupByAge();
//    }
//
//    @GetMapping("/count-by-gender")
//    public Map<String, Long> countByGender() {
//        return employeeService.countByGender();
//    }
//
//    @GetMapping("/distinct-departments")
//    public List<String> getDistinctDepartments() {
//        return employeeService.getDistinctDepartments();
//    }
//
//    @GetMapping("/above-age/{age}")
//    public List<Employee> getEmployeesAboveAge(@PathVariable int age) {
//        return employeeService.getEmployeesAboveAge(age);
//    }
//
//    @GetMapping("/max-age")
//    public OptionalInt getMaxAge() {
//        return employeeService.getMaxAge();
//    }
//
//    @GetMapping("/average-age-by-gender")
//    public Map<String, Double> averageAgeByGender() {
//        return employeeService.averageAgeByGender();
//    }
//
//    // Additional endpoints for all operations...
//
//    
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return empList;
//    }
//
//    @GetMapping("/groupByCity")
//    public Map<String, List<Employee>> getEmployeesByCity() {
//        return empList.stream().collect(Collectors.groupingBy(Employee::getCity));
//    }
//
//    @GetMapping("/groupByAge")
//    public Map<Integer, List<Employee>> getEmployeesByAge() {
//        return empList.stream().collect(Collectors.groupingBy(Employee::getAge));
//    }
//
//    @GetMapping("/genderCount")
//    public Map<String, Long> getGenderCount() {
//        return empList.stream()
//                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//    }
//
//    @GetMapping("/departments")
//    public Set<String> getAllDepartments() {
//        return empList.stream().map(Employee::getDeptName).collect(Collectors.toSet());
//    }
//
//    @GetMapping("/ageGreaterThan/{age}")
//    public List<Employee> getEmployeesOlderThan(@PathVariable int age) {
//        return empList.stream().filter(e -> e.getAge() > age).collect(Collectors.toList());
//    }
//
//    @GetMapping("/maxAge")
//    public Optional<Integer> getMaxAge() {
//        return empList.stream().mapToInt(Employee::getAge).max();
//    }
//
//    // Additional methods can be implemented similarly...
//
//    // Example using RestTemplate to call an external API
//    @GetMapping("/external/{id}")
//    public Employee getExternalEmployee(@PathVariable int id) {
//        return restTemplate.getForObject("https://api.example.com/employees/" + id, Employee.class);
//    }
//
//    // Example using WebClient to call an external API
//    @GetMapping("/webclient/external/{id}")
//    public Mono<Employee> getExternalEmployeeWebClient(@PathVariable int id) {
//        return webClient.get()
//                .uri("https://api.example.com/employees/{id}", id)
//                .retrieve()
//                .bodyToMono(Employee.class);
//    }
}
