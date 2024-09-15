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

### Solving Real Time Queries Using Java 8 Features -Employee Management System

Let’s try to solve some of the real time queries faced in the Employee Management System using Java 8 features.

We will be using following Employee class and employeeList as example while solving the queries.

### 1) Employee Class :

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

### 2) List Of Employees : employeeList

```java

List<Employee> employeeList = new ArrayList<Employee>();
         
employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

```

## 3) Real Time Queries On employeeList
Solving Real Time Queries Using Java 8 Features - Employee Management System
### Query 3.1 : How many male and female employees are there in the organization?

For queries such as above where you need to group the input elements, use the Collectors.groupingBy() method. In this query, we use Collectors.groupingBy() method which takes two arguments. We pass Employee::getGender as first argument which groups the input elements based on gender and Collectors.counting() as second argument which counts the number of entries in each group.

```java

Map<String, Long> noOfMaleAndFemaleEmployees=
employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
         
System.out.println(noOfMaleAndFemaleEmployees);

```
```
Output :

{Male=11, Female=6}

```

### Query 3.2 : Print the name of all departments in the organization?

Use distinct() method after calling map(Employee::getDepartment) on the stream. It will return unique departments.

```java

employeeList.stream()
            .map(Employee::getDepartment)
            .distinct()
            .forEach(System.out::println);
```
```
Output :

HR
Sales And Marketing
Infrastructure
Product Development
Security And Transport
Account And Finance

```

### Query 3.3 : What is the average age of male and female employees?

Use same method as query 3.1 but pass Collectors.averagingInt(Employee::getAge) as the second argument to Collectors.groupingBy().

```java

Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
         
System.out.println(avgAgeOfMaleAndFemaleEmployees);
Output :

{Male=30.181818181818183, Female=27.166666666666668}

```

### Query 3.4 : Get the details of highest paid employee in the organization?

Use Collectors.maxBy() method which returns maximum element wrapped in an Optional object based on supplied Comparator.

```java

Optional<Employee> highestPaidEmployeeWrapper=
employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
         
Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
         
System.out.println("Details Of Highest Paid Employee : ");
         
System.out.println("==================================");
         
System.out.println("ID : "+highestPaidEmployee.getId());
         
System.out.println("Name : "+highestPaidEmployee.getName());
         
System.out.println("Age : "+highestPaidEmployee.getAge());
         
System.out.println("Gender : "+highestPaidEmployee.getGender());
         
System.out.println("Department : "+highestPaidEmployee.getDepartment());
         
System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
         
System.out.println("Salary : "+highestPaidEmployee.getSalary());

```
```
Output :

Details Of Highest Paid Employee :
==================================
ID : 277
Name : Anuj Chettiar
Age : 31
Gender : Male
Department : Product Development
Year Of Joining : 2012
Salary : 35700.0
```

### Query 3.5 : Get the names of all employees who have joined after 2015?

For such queries which require filtering of input elements, use Stream.filter() method which filters input elements according to supplied Predicate.

```java

employeeList.stream()
            .filter(e -> e.getYearOfJoining() > 2015)
            .map(Employee::getName)
            .forEach(System.out::println);
```
```
Output :

Iqbal Hussain
Amelia Zoe
Nitin Joshi
Nicolus Den
Ali Baig

```

### Query 3.6 : Count the number of employees in each department?

This query is same as query 3.1 but here we are grouping the elements by department.

```java

Map<String, Long> employeeCountByDepartment=
employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
         
Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
         
for (Entry<String, Long> entry : entrySet)
{
    System.out.println(entry.getKey()+" : "+entry.getValue());
}
```
```
Output :

Product Development : 5
Security And Transport : 2
Sales And Marketing : 3
Infrastructure : 3
HR : 2
Account And Finance : 2
```

### Query 3.7 : What is the average salary of each department?

Use the same method as in the above query 3.6, but here pass Collectors.averagingDouble(Employee::getSalary) as second argument to Collectors.groupingBy() method.

```java

Map<String, Double> avgSalaryOfDepartments=
employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
         
Set<Entry<String, Double>> entrySet = avgSalaryOfDepartments.entrySet();
         
for (Entry<String, Double> entry : entrySet) 
{
    System.out.println(entry.getKey()+" : "+entry.getValue());
}
```

```
Output :

Product Development : 31960.0
Security And Transport : 10750.25
Sales And Marketing : 11900.166666666666
Infrastructure : 15466.666666666666
HR : 23850.0
Account And Finance : 24150.0
```

### Query 3.8 : Get the details of youngest male employee in the product development department?

For this query, use Stream.filter() method to filter male employees in product development department and to find youngest among them, use Stream.min() method.

```java

Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper=
employeeList.stream()
            .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
            .min(Comparator.comparingInt(Employee::getAge));
         
Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();
         
System.out.println("Details Of Youngest Male Employee In Product Development");
         
System.out.println("----------------------------------------------");
         
System.out.println("ID : "+youngestMaleEmployeeInProductDevelopment.getId());
         
System.out.println("Name : "+youngestMaleEmployeeInProductDevelopment.getName());
         
System.out.println("Age : "+youngestMaleEmployeeInProductDevelopment.getAge());
         
System.out.println("Year Of Joinging : "+youngestMaleEmployeeInProductDevelopment.getYearOfJoining());
         
System.out.println("Salary : "+youngestMaleEmployeeInProductDevelopment.getSalary());
```

```
Output :

Details Of Youngest Male Employee In Product Development :
———————————————-
ID : 222
Name : Nitin Joshi
Age : 25
Year Of Joinging : 2016
Salary : 28200.0
```

### Query 3.9 : Who has the most working experience in the organization?

For this query, sort employeeList by yearOfJoining in natural order and first employee will have most working experience in the organization. To solve this query, we will be using sorted() and findFirst() methods of Stream.

```java

Optional<Employee> seniorMostEmployeeWrapper=
employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
         
Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();
         
System.out.println("Senior Most Employee Details :");
         
System.out.println("----------------------------");
         
System.out.println("ID : "+seniorMostEmployee.getId());
         
System.out.println("Name : "+seniorMostEmployee.getName());
         
System.out.println("Age : "+seniorMostEmployee.getAge());
         
System.out.println("Gender : "+seniorMostEmployee.getGender());
         
System.out.println("Age : "+seniorMostEmployee.getDepartment());
         
System.out.println("Year Of Joinging : "+seniorMostEmployee.getYearOfJoining());
         
System.out.println("Salary : "+seniorMostEmployee.getSalary());
```

```
Output :

Senior Most Employee Details :
—————————-
ID : 177
Name : Manu Sharma
Age : 35
Gender : Male
Age : Account And Finance
Year Of Joinging : 2010
Salary : 27000.0
```

### Query 3.10 : How many male and female employees are there in the sales and marketing team?

This query is same as query 3.1, but here use filter() method to filter sales and marketing employees.

```java

Map<String, Long> countMaleFemaleEmployeesInSalesMarketing=
employeeList.stream()
            .filter(e -> e.getDepartment()=="Sales And Marketing")
            .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
 
System.out.println(countMaleFemaleEmployeesInSalesMarketing);
```
```
Output :

{Female=1, Male=2}

```

### Query 3.11 : What is the average salary of male and female employees?

This query is same as query 3.3 where you have found average age of male and female employees. Here, we will be finding average salary of male and female employees.

```java

Map<String, Double> avgSalaryOfMaleAndFemaleEmployees=
employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
         
System.out.println(avgSalaryOfMaleAndFemaleEmployees);
```
```
Output :

{Male=21300.090909090908, Female=20850.0}

```
### Query 3.12 : List down the names of all employees in each department?

For this query, we will be using Collectors.groupingBy() method by passing Employee::getDepartment as an argument.

```java

Map<String, List<Employee>> employeeListByDepartment=
employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
         
Set<Entry<String, List<Employee>>> entrySet = employeeListByDepartment.entrySet();
         
for (Entry<String, List<Employee>> entry : entrySet) 
{
    System.out.println("--------------------------------------");
             
    System.out.println("Employees In "+entry.getKey() + " : ");
             
    System.out.println("--------------------------------------");
             
    List<Employee> list = entry.getValue();
             
    for (Employee e : list) 
    {
        System.out.println(e.getName());
    }
}
```
```
Output :

————————————–
Employees In Product Development :
————————————–
Murali Gowda
Wang Liu
Nitin Joshi
Sanvi Pandey
Anuj Chettiar
————————————–
Employees In Security And Transport :
————————————–
Iqbal Hussain
Jaden Dough
————————————–
Employees In Sales And Marketing :
————————————–
Paul Niksui
Amelia Zoe
Nicolus Den
————————————–
Employees In Infrastructure :
————————————–
Martin Theron
Jasna Kaur
Ali Baig
————————————–
Employees In HR :
————————————–
Jiya Brein
Nima Roy
————————————–
Employees In Account And Finance :
————————————–
Manu Sharma
Jyothi Reddy

```

### Query 3.13 : What is the average salary and total salary of the whole organization?

For this query, we use Collectors.summarizingDouble() on Employee::getSalary which will return statistics of the employee salary like max, min, average and total.

```java

DoubleSummaryStatistics employeeSalaryStatistics=
employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
         
System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
         
System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());

```

```
Output :

Average Salary = 21141.235294117647
Total Salary = 359401.0

```

### Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

For this query, we will be using Collectors.partitioningBy() method which separates input elements based on supplied Predicate.

```java

Map<Boolean, List<Employee>> partitionEmployeesByAge=
employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
         
Set<Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();
         
for (Entry<Boolean, List<Employee>> entry : entrySet) 
{
    System.out.println("----------------------------");
             
    if (entry.getKey()) 
    {
        System.out.println("Employees older than 25 years :");
    }
    else
    {
        System.out.println("Employees younger than or equal to 25 years :");
    }
             
    System.out.println("----------------------------");
             
    List<Employee> list = entry.getValue();
             
    for (Employee e : list) 
    {
        System.out.println(e.getName());
    }
}
```
```
Output :

—————————-
Employees younger than or equal to 25 years :
—————————-
Paul Niksui
Amelia Zoe
Nitin Joshi
Nicolus Den
Ali Baig
—————————-
Employees older than 25 years :
—————————-
Jiya Brein
Martin Theron
Murali Gowda
Nima Roy
Iqbal Hussain
Manu Sharma
Wang Liu
Jaden Dough
Jasna Kaur
Jyothi Reddy
Sanvi Pandey
Anuj Chettiar

```
### Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?

```java

Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
         
Employee oldestEmployee = oldestEmployeeWrapper.get();
         
System.out.println("Name : "+oldestEmployee.getName());
         
System.out.println("Age : "+oldestEmployee.getAge());
         
System.out.println("Department : "+oldestEmployee.getDepartment());

```
```
Output :

Name : Iqbal Hussain
Age : 43
Department : Security And Transport
```
