package com.springboot.microservice.service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.microservice.model.Employee;

@Service
public class ExternalService {
		
	private final String BASE_URL = "http://localhost:8080/employees"; // Change this to your actual API endpoint

	private final RestTemplate restTemplate;
	
	public ExternalService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	// 1. Group by city
	public Map<String, List<Employee>> groupByCity() {
		return restTemplate.getForObject(BASE_URL + "/groupByCity", Map.class);
	}

	// 2. Group by age
	public Map<Integer, List<Employee>> groupByAge() {
		return restTemplate.getForObject(BASE_URL + "/groupByAge", Map.class);
	}

	// 3. Count by gender
	public Map<String, Long> countByGender() {
		return restTemplate.getForObject(BASE_URL + "/countByGender", Map.class);
	}

	// 4. Distinct department names
	public List<String> getDistinctDepartments() {
		return restTemplate.getForObject(BASE_URL + "/distinctDepartments", List.class);
	}

	// 5. Employees older than specified age
	public List<Employee> employeesOlderThan(int age) {
		return restTemplate.getForObject(BASE_URL + "/olderThan/" + age, List.class);
	}

	// 6. Maximum age of employee
	public OptionalInt maxAge() {
		return restTemplate.getForObject(BASE_URL + "/maxAge", OptionalInt.class);
	}

	// 7. Average age of Male and Female Employees
	public Map<String, Double> averageAgeByGender() {
		return restTemplate.getForObject(BASE_URL + "/averageAgeByGender", Map.class);
	}

	// 8. Count of employees in each department
	public Map<String, Long> countByDepartment() {
		return restTemplate.getForObject(BASE_URL + "/countByDepartment", Map.class);
	}

	// 9. Find oldest employee
	public Optional<Employee> oldestEmployee() {
		return restTemplate.getForObject(BASE_URL + "/oldestEmployee", Optional.class);
	}

	// 10. Find youngest female employee
	public Optional<Employee> youngestFemaleEmployee() {
		return restTemplate.getForObject(BASE_URL + "/youngestFemaleEmployee", Optional.class);
	}

	// 11. Partition employees by age
	public Map<Boolean, List<Employee>> partitionEmployeesByAge() {
		return restTemplate.getForObject(BASE_URL + "/partitionByAge", Map.class);
	}

	// 12. Department with highest number of employees
	public Map.Entry<String, Long> departmentWithMostEmployees() {
		return restTemplate.getForObject(BASE_URL + "/departmentWithMostEmployees", Map.Entry.class);
	}

	// 13. Check if any employees from HR department
	public Optional<Employee> anyEmployeeFromHR() {
		return restTemplate.getForObject(BASE_URL + "/anyEmployeeFromHR", Optional.class);
	}

	// 14. Department names with more than 3 employees
	public List<String> departmentsWithMoreThan3Employees() {
		return restTemplate.getForObject(BASE_URL + "/departmentsWithMoreThan3Employees", List.class);
	}

	// 15. Distinct department names
	public List<String> distinctDepartmentNames() {
		return restTemplate.getForObject(BASE_URL + "/distinctDepartmentNames", List.class);
	}

	// 16. Employees in 'Blore', sorted by name
	public List<String> employeesInBlore() {
		return restTemplate.getForObject(BASE_URL + "/employeesInBlore", List.class);
	}

	// 17. Total number of employees
	public long totalEmployees() {
		return restTemplate.getForObject(BASE_URL + "/totalEmployees", Long.class);
	}

	// 18. Employee count in every department
	public Map<String, Long> employeeCountInDepartments() {
		return restTemplate.getForObject(BASE_URL + "/employeeCountInDepartments", Map.class);
	}

	// 19. Department with highest number of employees
	public Optional<Map.Entry<String, Long>> departmentWithHighestEmployees() {
		return restTemplate.getForObject(BASE_URL + "/departmentWithHighestEmployees", Optional.class);
	}

	// 20. Sorting employees by name and age
	public List<Employee> sortEmployeesByNameAndAge() {
		return restTemplate.getForObject(BASE_URL + "/sortByNameAndAge", List.class);
	}

	// 21. Highest experienced employee
	public Optional<Employee> highestExperienceEmployee() {
		return restTemplate.getForObject(BASE_URL + "/highestExperienceEmployee", Optional.class);
	}

	// 22. Average and total salary
	public DoubleSummaryStatistics salaryStatistics() {
		return restTemplate.getForObject(BASE_URL + "/salaryStatistics", DoubleSummaryStatistics.class);
	}

	// 23. Average salary by department
	public Map<String, Double> averageSalaryByDepartment() {
		return restTemplate.getForObject(BASE_URL + "/averageSalaryByDepartment", Map.class);
	}

	// 24. Highest salary in the organization
	public Optional<Employee> highestSalaryEmployee() {
		return restTemplate.getForObject(BASE_URL + "/highestSalaryEmployee", Optional.class);
	}

	// 25. Second highest salary in the organization
	public Optional<Employee> secondHighestSalaryEmployee() {
		return restTemplate.getForObject(BASE_URL + "/secondHighestSalaryEmployee", Optional.class);
	}

	// 26. Nth highest salary
	public Optional<Employee> nthHighestSalaryEmployee(int n) {
		return restTemplate.getForObject(BASE_URL + "/nthHighestSalary/" + n, Optional.class);
	}

	// 27. Highest paid salary by gender
	public Map<String, Optional<Employee>> highestPaidByGender() {
		return restTemplate.getForObject(BASE_URL + "/highestPaidByGender", Map.class);
	}

	// 28. Lowest paid salary by gender
	public Map<String, Optional<Employee>> lowestPaidByGender() {
		return restTemplate.getForObject(BASE_URL + "/lowestPaidByGender", Map.class);
	}

	// 29. Sort salaries in ascending order
	public List<Employee> sortSalariesAscending() {
		return restTemplate.getForObject(BASE_URL + "/sortSalariesAscending", List.class);
	}

	// 30. Sort salaries in descending order
	public List<Employee> sortSalariesDescending() {
		return restTemplate.getForObject(BASE_URL + "/sortSalariesDescending", List.class);
	}

	// 31. Highest salary by department
	public Map<String, Optional<Employee>> highestSalaryByDepartment() {
		return restTemplate.getForObject(BASE_URL + "/highestSalaryByDepartment", Map.class);
	}

	// 32. Second highest salary by department
	public Map<String, Optional<Employee>> secondHighestSalaryByDepartment() {
		return restTemplate.getForObject(BASE_URL + "/secondHighestSalaryByDepartment", Map.class);
	}

	// 33. Sort employees' salaries in each department in ascending order
	public Map<String, List<Employee>> sortSalariesAscByDepartment() {
		return restTemplate.getForObject(BASE_URL + "/sortSalariesAscByDepartment", Map.class);
	}

	// 34. Sort employees' salaries in each department in descending order
	public Map<String, List<Employee>> sortSalariesDescByDepartment() {
		return restTemplate.getForObject(BASE_URL + "/sortSalariesDescByDepartment", Map.class);
	}
}
