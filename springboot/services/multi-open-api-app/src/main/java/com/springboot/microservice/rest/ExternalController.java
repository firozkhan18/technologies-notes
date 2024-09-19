package com.springboot.microservice.rest;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.microservice.model.Employee;
import com.springboot.microservice.service.ExternalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee Rest Template API", description = "Rest Template Endpoints for Employee Management Operations")
@RestController
@RequestMapping("/api/v2")
public class ExternalController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/groupByCity")
    @Operation(summary = "Fetches employees group by city") // Use @Operation instead of @ApiOperation
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved data"), // Use responseCode instead of code
        @ApiResponse(responseCode = "500", description = "Internal server error") // Use responseCode instead of code
    })
    public Map<String, List<Employee>> groupByCity() {
        return externalService.groupByCity();
    }

    @GetMapping("/groupByAge")
    public Map<Integer, List<Employee>> groupByAge() {
        return externalService.groupByAge();
    }

    @GetMapping("/countByGender")
    public Map<String, Long> countByGender() {
        return externalService.countByGender();
    }

    @GetMapping("/distinctDepartments")
    public List<String> getDistinctDepartments() {
        return externalService.getDistinctDepartments();
    }

    @GetMapping("/olderThan/{age}")
    public List<Employee> employeesOlderThan(@PathVariable int age) {
        return externalService.employeesOlderThan(age);
    }

    @GetMapping("/maxAge")
    public OptionalInt maxAge() {
        return externalService.maxAge();
    }

    @GetMapping("/averageAgeByGender")
    public Map<String, Double> averageAgeByGender() {
        return externalService.averageAgeByGender();
    }

    @GetMapping("/countByDepartment")
    public Map<String, Long> countByDepartment() {
        return externalService.countByDepartment();
    }

    @GetMapping("/oldestEmployee")
    public Optional<Employee> oldestEmployee() {
        return externalService.oldestEmployee();
    }

    @GetMapping("/youngestFemaleEmployee")
    public Optional<Employee> youngestFemaleEmployee() {
        return externalService.youngestFemaleEmployee();
    }

    @GetMapping("/partitionByAge")
    public Map<Boolean, List<Employee>> partitionEmployeesByAge() {
        return externalService.partitionEmployeesByAge();
    }

    @GetMapping("/departmentWithMostEmployees")
    public Map.Entry<String, Long> departmentWithMostEmployees() {
        return externalService.departmentWithMostEmployees();
    }

    @GetMapping("/anyEmployeeFromHR")
    public Optional<Employee> anyEmployeeFromHR() {
        return externalService.anyEmployeeFromHR();
    }

    @GetMapping("/departmentsWithMoreThan3Employees")
    public List<String> departmentsWithMoreThan3Employees() {
        return externalService.departmentsWithMoreThan3Employees();
    }

    @GetMapping("/distinctDepartmentNames")
    public List<String> distinctDepartmentNames() {
        return externalService.distinctDepartmentNames();
    }

    @GetMapping("/employeesInBlore")
    public List<String> employeesInBlore() {
        return externalService.employeesInBlore();
    }

    @GetMapping("/totalEmployees")
    public long totalEmployees() {
        return externalService.totalEmployees();
    }

    @GetMapping("/employeeCountInDepartments")
    public Map<String, Long> employeeCountInDepartments() {
        return externalService.employeeCountInDepartments();
    }

    @GetMapping("/departmentWithHighestEmployees")
    public Optional<Map.Entry<String, Long>> departmentWithHighestEmployees() {
        return externalService.departmentWithHighestEmployees();
    }

    @GetMapping("/sortByNameAndAge")
    public List<Employee> sortEmployeesByNameAndAge() {
        return externalService.sortEmployeesByNameAndAge();
    }

    @GetMapping("/highestExperienceEmployee")
    public Optional<Employee> highestExperienceEmployee() {
        return externalService.highestExperienceEmployee();
    }

    @GetMapping("/salaryStatistics")
    public DoubleSummaryStatistics salaryStatistics() {
        return externalService.salaryStatistics();
    }

    @GetMapping("/averageSalaryByDepartment")
    public Map<String, Double> averageSalaryByDepartment() {
        return externalService.averageSalaryByDepartment();
    }

    @GetMapping("/highestSalaryEmployee")
    public Optional<Employee> highestSalaryEmployee() {
        return externalService.highestSalaryEmployee();
    }

    @GetMapping("/secondHighestSalaryEmployee")
    public Optional<Employee> secondHighestSalaryEmployee() {
        return externalService.secondHighestSalaryEmployee();
    }

    @GetMapping("/nthHighestSalary/{n}")
    public Optional<Employee> nthHighestSalaryEmployee(@PathVariable int n) {
        return externalService.nthHighestSalaryEmployee(n);
    }

    @GetMapping("/highestPaidByGender")
    public Map<String, Optional<Employee>> highestPaidByGender() {
        return externalService.highestPaidByGender();
    }

    @GetMapping("/lowestPaidByGender")
    public Map<String, Optional<Employee>> lowestPaidByGender() {
        return externalService.lowestPaidByGender();
    }

    @GetMapping("/sortSalariesAscending")
    public List<Employee> sortSalariesAscending() {
        return externalService.sortSalariesAscending();
    }

    @GetMapping("/sortSalariesDescending")
    public List<Employee> sortSalariesDescending() {
        return externalService.sortSalariesDescending();
    }

    @GetMapping("/highestSalaryByDepartment")
    public Map<String, Optional<Employee>> highestSalaryByDepartment() {
        return externalService.highestSalaryByDepartment();
    }

    @GetMapping("/secondHighestSalaryByDepartment")
    public Map<String, Optional<Employee>> secondHighestSalaryByDepartment() {
        return externalService.secondHighestSalaryByDepartment();
    }

    @GetMapping("/sortSalariesAscByDepartment")
    public Map<String, List<Employee>> sortSalariesAscByDepartment() {
        return externalService.sortSalariesAscByDepartment();
    }

    @GetMapping("/sortSalariesDescByDepartment")
    public Map<String, List<Employee>> sortSalariesDescByDepartment() {
        return externalService.sortSalariesDescByDepartment();
    }
}

