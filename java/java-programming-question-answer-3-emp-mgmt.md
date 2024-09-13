### Questions from 47 to 53 depends on the following Student class.
```java
class Student
{
    String name;      
    int id;      
    String subject;      
    double percentage;
      
    public Student(String name, int id, String subject, double percentage) 
    {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }
      
    public String getName() 
    {
        return name;
    }
      
    public int getId() 
    {
        return id;
    }
      
    public String getSubject() 
    {
        return subject;
    }
      
    public double getPercentage() 
    {
        return percentage;
    }
      
    @Override
    public String toString() 
    {
        return name+"-"+id+"-"+subject+"-"+percentage;
    }
}
```
### 47) Given a list of students, write a Java 8 code to partition the students who got above 60% from those who didn’t?
```java
Map<Boolean, List<Student>> studentspartionedByPercentage = studentList.stream()
                                                            .collect(Collectors.partitioningBy(student -> student.getPercentage() > 60.0));
```
### 48) Given a list of students, write a Java 8 code to get the names of top 3 performing students?
```java
List<Student> top3Students = studentList.stream()
                                        .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                                        .limit(3)
                                        .collect(Collectors.toList());
```
### 49) Given a list of students, how do you get the name and percentage of each student?
```java
Map<String, Double> namePercentageMap = studentList.stream()
                                                   .collect(Collectors.toMap(Student::getName, Student::getPercentage));
```
### 50) Given a list of students, how do you get the subjects offered in the college?
```java
Set<String> subjects = studentList.stream()
                                  .map(Student::getSubject).collect(Collectors.toSet());
```
### 51) Given a list of students, write a Java 8 code to get highest, lowest and average percentage of students?
```java
DoubleSummaryStatistics studentStats = studentList.stream()
                                                  .collect(Collectors.summarizingDouble(Student::getPercentage));
          
System.out.println("Highest Percentage : "+studentStats.getMax());          
System.out.println("Lowest Percentage : "+studentStats.getMin());          
System.out.println("Average Percentage : "+studentStats.getAverage());
```
### 52) How do you get total number of students from the given list of students?
```java
Long studentCount = studentList.stream().collect(Collectors.counting());
```
### 53) How do you get the students grouped by subject from the given list of students?
```java
Map<String, List<Student>> studentsGroupedBySubject = studentList.stream()
                                                                .collect(Collectors.groupingBy(Student::getSubject));
```
### Questions from 54 to 61 are on the following Employee class.
```java
class Employee
{
    int id;      
    String name;      
    int age;      
    String gender;      
    String department;      
    int yearOfJoining;      
    double salary;
      
    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
      
    public int getId() 
    {
        return id;
    }
      
    public String getName() 
    {
        return name;
    }
      
    public int getAge() 
    {
        return age;
    }
      
    public String getGender() 
    {
        return gender;
    }
      
    public String getDepartment() 
    {
        return department;
    }
      
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
      
    public double getSalary() 
    {
        return salary;
    }
      
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
}
```
### 54) Given a list of employees, write a Java 8 code to count the number of employees in each department?
```java
Map<String, Long> employeeCountByDepartment = 
employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
```
### 55) Given a list of employees, find out the average salary of male and female employees?
```java
Map<String, Double> avgSalaryOfMaleAndFemaleEmployees=
                employeeList.stream()
                            .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
```
### 56) Write a Java 8 code to get the details of highest paid employee in the organization from the given list of employees?
```java
Optional<Employee> highestPaidEmployeeWrapper=
employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
```
### 57) Write the Java 8 code to get the average age of each department in an organization?
```java
Map<String, Double> avgAgeOfEachDepartment =
                employeeList.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)));
```
### 58) Given a list of employees, how do you find out who is the senior most employee in the organization?
```java
Optional<Employee> seniorMostEmployeeWrapper=
                                employeeList.stream()
                                            .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
```
### 59) Given a list of employees, get the details of the most youngest employee in the organization?
```java
Optional<Employee> youngestEmployee =
                employeeList.stream().min(Comparator.comparingInt(Employee::getAge));
```
### 60) How do you get the number of employees in each department if you have given a list of employees?
```java
Map<String, Long> employeeCountByDepartment=
                                            employeeList.stream()
                                                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
```
### 61) Given a list of employees, find out the number of male and female employees in the organization?
```java
Map<String, Long> noOfMaleAndFemaleEmployees=
                                            employeeList.stream()
                                                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
```
See More : Solving Real Time Queries Using Java 8 Features -Employee Management System

### 62) What will be the output of the following statement?
```java
System.out.println(IntStream.range(0, 5).sum());
```
10
