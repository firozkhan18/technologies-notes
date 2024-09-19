package com.springboot.microservice.rest;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.model.Employee;
import com.springboot.microservice.model.EmployeeList;
import com.springboot.microservice.service.ApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import reactor.core.publisher.Mono;

@Tag(name = "Employee Web Client API", description = "Web Client Endpoints for Employee Management Operations")
@RestController
@RequestMapping("/api/v1")
//@Api(value = "Employee API", tags = "Employee Management")
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/groupByCity")
    @Operation(summary = "Fetches employees group by city") // Use @Operation instead of @ApiOperation
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved data"), // Use responseCode instead of code
        @ApiResponse(responseCode = "500", description = "Internal server error") // Use responseCode instead of code
    })
    public Mono<Map<String, List<EmployeeList>>> groupByCity() {
        return apiService.groupByCity();
    }

    @GetMapping("/groupByAge")
    public Mono<Map<Integer, List<EmployeeList>>> groupByAge() {
        return apiService.groupByAge();
    }

    @GetMapping("/countByGender")
    public Mono<Map<String, Long>> countByGender() {
        return apiService.countByGender();
    }

    @GetMapping("/distinctDepartments")
    public Mono<List<String>> getDistinctDepartments() {
        return apiService.getDistinctDepartments();
    }

    @GetMapping("/olderThan/{age}")
    public Mono<List<EmployeeList>> employeesOlderThan(@PathVariable int age) {
        return apiService.employeesOlderThan(age);
    }

    @GetMapping("/maxAge")
    public Mono<OptionalInt> maxAge() {
        return apiService.maxAge();
    }

    @GetMapping("/averageAgeByGender")
    public Mono<Map<String, Double>> averageAgeByGender() {
        return apiService.averageAgeByGender();
    }

    @GetMapping("/countByDepartment")
    public Mono<Map<String, Long>> countByDepartment() {
        return apiService.countByDepartment();
    }

    @GetMapping("/oldestEmployee")
    public Mono<Optional<EmployeeList>> oldestEmployee() {
        return apiService.oldestEmployee();
    }

    @GetMapping("/youngestFemaleEmployee")
    public Mono<Optional<EmployeeList>> youngestFemaleEmployee() {
        return apiService.youngestFemaleEmployee();
    }

    @GetMapping("/partitionByAge")
    public Mono<Map<Boolean, List<EmployeeList>>> partitionEmployeesByAge() {
        return apiService.partitionEmployeesByAge();
    }

    @GetMapping("/departmentWithMostEmployees")
    public Mono<Map.Entry<String, Long>> departmentWithMostEmployees() {
        return apiService.departmentWithMostEmployees();
    }

    @GetMapping("/anyEmployeeFromHR")
    public Mono<Optional<EmployeeList>> anyEmployeeFromHR() {
        return apiService.anyEmployeeFromHR();
    }

    @GetMapping("/departmentsWithMoreThan3Employees")
    public Mono<List<String>> departmentsWithMoreThan3Employees() {
        return apiService.departmentsWithMoreThan3Employees();
    }

    @GetMapping("/distinctDepartmentNames")
    public Mono<List<String>> distinctDepartmentNames() {
        return apiService.distinctDepartmentNames();
    }

    @GetMapping("/employeesInBlore")
    public Mono<List<String>> employeesInBlore() {
        return apiService.employeesInBlore();
    }

    @GetMapping("/totalEmployees")
    public Mono<Long> totalEmployees() {
        return apiService.totalEmployees();
    }

    @GetMapping("/employeeCountInDepartments")
    public Mono<Map<String, Long>> employeeCountInDepartments() {
        return apiService.employeeCountInDepartments();
    }

    @GetMapping("/departmentWithHighestEmployees")
    public Mono<Optional<Map.Entry<String, Long>>> departmentWithHighestEmployees() {
        return apiService.departmentWithHighestEmployees();
    }

    @GetMapping("/sortByNameAndAge")
    public Mono<List<EmployeeList>> sortEmployeesByNameAndAge() {
        return apiService.sortEmployeesByNameAndAge();
    }

    @GetMapping("/highestExperienceEmployee")
    public Mono<Optional<EmployeeList>> highestExperienceEmployee() {
        return apiService.highestExperienceEmployee();
    }

    @GetMapping("/salaryStatistics")
    public Mono<DoubleSummaryStatistics> salaryStatistics() {
        return apiService.salaryStatistics();
    }

    @GetMapping("/averageSalaryByDepartment")
    public Mono<Map<String, Double>> averageSalaryByDepartment() {
        return apiService.averageSalaryByDepartment();
    }

    @GetMapping("/highestSalaryEmployee")
    public Mono<Optional<EmployeeList>> highestSalaryEmployee() {
        return apiService.highestSalaryEmployee();
    }

    @GetMapping("/secondHighestSalaryEmployee")
    public Mono<Optional<EmployeeList>> secondHighestSalaryEmployee() {
        return apiService.secondHighestSalaryEmployee();
    }

    @GetMapping("/nthHighestSalary/{n}")
    public Mono<Optional<EmployeeList>> nthHighestSalaryEmployee(@PathVariable int n) {
        return apiService.nthHighestSalaryEmployee(n);
    }

    @GetMapping("/highestPaidByGender")
    public Mono<Map<String, Optional<EmployeeList>>> highestPaidByGender() {
        return apiService.highestPaidByGender();
    }

    @GetMapping("/lowestPaidByGender")
    public Mono<Map<String, Optional<EmployeeList>>> lowestPaidByGender() {
        return apiService.lowestPaidByGender();
    }

    @GetMapping("/sortSalariesAscending")
    public Mono<List<EmployeeList>> sortSalariesAscending() {
        return apiService.sortSalariesAscending();
    }

    @GetMapping("/sortSalariesDescending")
    public Mono<List<EmployeeList>> sortSalariesDescending() {
        return apiService.sortSalariesDescending();
    }

    @GetMapping("/highestSalaryByDepartment")
    public Mono<Map<String, Optional<EmployeeList>>> highestSalaryByDepartment() {
        return apiService.highestSalaryByDepartment();
    }

    @GetMapping("/secondHighestSalaryByDepartment")
    public Mono<Map<String, Optional<EmployeeList>>> secondHighestSalaryByDepartment() {
        return apiService.secondHighestSalaryByDepartment();
    }

    @GetMapping("/sortSalariesAscByDepartment")
    public Mono<Map<String, List<EmployeeList>>> sortSalariesAscByDepartment() {
        return apiService.sortSalariesAscByDepartment();
    }

    @GetMapping("/sortSalariesDescByDepartment")
    public Mono<Map<String, List<EmployeeList>>> sortSalariesDescByDepartment() {
        return apiService.sortSalariesDescByDepartment();
    }
    
}

