     new Employee("Bob", 80000),
        new Employee("Charlie", 90000)
    );

    //How do you find the second highest salary of employee?
    Optional<Double> secondHighestSalary = employees.stream()
        .map(Employee::getSalary)
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst();

    secondHighestSalary.ifPresent(System.out::println);
  }
}
```
**DENSE_RANK()** is a window function in SQL that assigns ranks to rows within a partition of a result set. Unlike `RANK()`, which may produce gaps in rank values when there are ties, `DENSE_RANK()` does not leave gaps. This function is useful for ranking items when you want a consecutive ranking without gaps.

Here are some common interview questions related to `DENSE_RANK()` along with examples:

### **1. Basic Understanding**

**Q1: What does the `DENSE_RANK()` function do in SQL?**

**Answer:**
The `DENSE_RANK()` function assigns ranks to rows within a partition of a result set, with no gaps in the ranking values. It provides a ranking based on the order of a specified column or columns, and if there are ties, it assigns the same rank to the tied rows but does not skip rank numbers for subsequent rows.

**Example:**

Given the following table of `employees`:

| emp_id | emp_name | salary |
|--------|----------|--------|
| 1      | Alice    | 5000   |
| 2      | Bob      | 6000   |
| 3      | Charlie  | 6000   |
| 4      | David    | 4000   |
| 5      | Eve      | 3000   |

**SQL Query:**
```sql
SELECT emp_name, salary,
       DENSE_RANK() OVER (ORDER BY salary DESC) AS rank
FROM employees;
```

**Result:**

| emp_name | salary | rank |
|----------|--------|------|
| Bob      | 6000   | 1    |
| Charlie  | 6000   | 1    |
| Alice    | 5000   | 2    |
| David    | 4000   | 3    |
| Eve      | 3000   | 4    |

### **2. Partitioning Data**

**Q2: How can you use `DENSE_RANK()` with partitioning?**

**Answer:**
`DENSE_RANK()` can be used with the `PARTITION BY` clause to rank rows within partitions of the result set.

**Example:**

Suppose we have a table `sales` with regions and sales figures:

| region | salesperson | sales |
|--------|-------------|-------|
| East   | Alice       | 5000  |
| East   | Bob         | 6000  |
| West   | Charlie     | 7000  |
| West   | David       | 6000  |

**SQL Query:**
```sql
SELECT region, salesperson, sales,
       DENSE_RANK() OVER (PARTITION BY region ORDER BY sales DESC) AS rank
FROM sales;
```

**Result:**

| region | salesperson | sales | rank |
|--------|-------------|-------|------|
| East   | Bob         | 6000  | 1    |
| East   | Alice       | 5000  | 2    |
| West   | Charlie     | 7000  | 1    |
| West   | David       | 6000  | 2    |

### **3. Handling Ties**

**Q3: How does `DENSE_RANK()` handle ties in the data?**

**Answer:**
`DENSE_RANK()` assigns the same rank to tied rows and continues with the next rank without skipping any numbers.

**Example:**

Consider a table `students` with their scores:

| student_id | student_name | score |
|------------|--------------|-------|
| 1          | John         | 85    |
| 2          | Jane         | 90    |
| 3          | Alice        | 90    |
| 4          | Bob          | 80    |

**SQL Query:**
```sql
SELECT student_name, score,
       DENSE_RANK() OVER (ORDER BY score DESC) AS rank
FROM students;
```

**Result:**

| student_name | score | rank |
|--------------|-------|------|
| Jane         | 90    | 1    |
| Alice        | 90    | 1    |
| John         | 85    | 2    |
| Bob          | 80    | 3    |

### **4. Using DENSE_RANK() for Ranking Products**

**Q4: How can `DENSE_RANK()` be used to rank products by sales within each category?**

**Answer:**
You can use `DENSE_RANK()` to rank products based on their sales figures within each category using partitioning.

**Example:**

Suppose we have a table `products` with categories and sales:

| category | product_name | sales |
|----------|--------------|-------|
| Electronics | TV         | 5000  |
| Electronics | Radio      | 3000  |
| Clothing     | Shirt      | 2000  |
| Clothing     | Jacket     | 2500  |

**SQL Query:**
```sql
SELECT category, product_name, sales,
       DENSE_RANK() OVER (PARTITION BY category ORDER BY sales DESC) AS rank
FROM products;
```

**Result:**

| category    | product_name | sales | rank |
|-------------|--------------|-------|------|
| Electronics | TV           | 5000  | 1    |
| Electronics | Radio        | 3000  | 2    |
| Clothing    | Jacket       | 2500  | 1    |
| Clothing    | Shirt        | 2000  | 2    |

### **5. Calculating Top N Items**

**Q5: How can you use `DENSE_RANK()` to select the top N items in a category?**

**Answer:**
You can use `DENSE_RANK()` in a subquery to filter and select the top N items.

**Example:**

To get the top 2 products by sales in each category:

**SQL Query:**
```sql
WITH RankedProducts AS (
    SELECT category, product_name, sales,
           DENSE_RANK() OVER (PARTITION BY category ORDER BY sales DESC) AS rank
    FROM products
)
SELECT category, product_name, sales
FROM RankedProducts
WHERE rank <= 2;
```

**Result:**

| category    | product_name | sales |
|-------------|--------------|-------|
| Electronics | TV           | 5000  |
| Electronics | Radio        | 3000  |
| Clothing    | Jacket       | 2500  |
| Clothing    | Shirt        | 2000  |

### **Summary**

- **`DENSE_RANK()`** provides a ranking with no gaps in rank values.
- It can be used with `PARTITION BY` to rank data within specific partitions.
- Handles ties by assigning the same rank to tied rows and continues without gaps.
- Useful for generating rank-based reports and filtering top N results.

Understanding `DENSE_RANK()` and its usage can help you handle various ranking and reporting requirements effectively in SQL.

Here’s a detailed explanation and corrections to the SQL queries using `DENSE_RANK()` to ensure they work as intended:

### **1. Using `DENSE_RANK()` to Rank Employees and Join with Departments**

**Query:**
```sql
SELECT e.emp_name, d.dept_name, DENSE_RANK() OVER (ORDER BY e.emp_salary) as rank
FROM Emp e
LEFT JOIN Dept d ON e.dept_id = d.dept_id;
```

**Explanation:**
- **Purpose**: This query ranks employees based on their salary and includes their department names.
- **DENSE_RANK()**: Assigns ranks based on `e.emp_salary` in ascending order. The lowest salary gets rank 1, the next distinct salary gets rank 2, and so on.
- **LEFT JOIN**: Ensures that even if an employee does not belong to any department (i.e., `dept_id` is `NULL`), the employee's details are still included in the results with a `NULL` department name.

**Important Note**: The query assumes that the `Emp` table has columns `emp_name`, `emp_salary`, and `dept_id`, and the `Dept` table has `dept_id` and `dept_name`.

### **2. Ordering with `DENSE_RANK()`**

**Query:**
```sql
WITH RankedEmployees AS (
    SELECT e.emp_name, d.dept_name, DENSE_RANK() OVER (ORDER BY e.emp_salary DESC) as rank
    FROM Emp e
    LEFT JOIN Dept d ON e.dept_id = d.dept_id
)
SELECT emp_name, dept_name
FROM RankedEmployees
ORDER BY rank;
```

**Explanation:**
- **Common Table Expression (CTE)**: The `WITH` clause defines a CTE named `RankedEmployees` where `DENSE_RANK()` is calculated based on employee salaries in descending order (highest salary gets rank 1).
- **Ordering in the CTE**: `DENSE_RANK()` is calculated in the CTE, but the `ORDER BY` clause in the final `SELECT` query is used to order the results by the calculated rank.

**Details:**
- **Descending Order**: The `ORDER BY e.emp_salary DESC` within `DENSE_RANK()` assigns rank 1 to the highest salary.
- **Final Ordering**: The outer query orders the result set by the `rank` assigned in the CTE.

**Corrected Queries**:

1. **Rank Employees and Join with Departments**:
   ```sql
   SELECT e.emp_name, d.dept_name, DENSE_RANK() OVER (ORDER BY e.emp_salary DESC) AS rank
   FROM Emp e
   LEFT JOIN Dept d ON e.dept_id = d.dept_id;
   ```

2. **Order Results by Rank**:
   ```sql
   WITH RankedEmployees AS (
       SELECT e.emp_name, d.dept_name, DENSE_RANK() OVER (ORDER BY e.emp_salary DESC) AS rank
       FROM Emp e
       LEFT JOIN Dept d ON e.dept_id = d.dept_id
   )
   SELECT emp_name, dept_name
   FROM RankedEmployees
   ORDER BY rank;
   ```

### **Additional Examples of `DENSE_RANK()` Usage**

**Example 1: Rank Employees Within Each Department**

**Query:**
```sql
SELECT e.emp_name, d.dept_name, e.emp_salary,
       DENSE_RANK() OVER (PARTITION BY d.dept_name ORDER BY e.emp_salary DESC) AS rank
FROM Emp e
LEFT JOIN Dept d ON e.dept_id = d.dept_id;
```

**Explanation:**
- **PARTITION BY**: Divides the result set into partitions based on `dept_name`. Ranks are reset within each department.
- **ORDER BY**: Ranks employees within each department by salary in descending order.

**Example 2: Top N Employees Per Department**

**Query:**
```sql
WITH RankedEmployees AS (
    SELECT e.emp_name, d.dept_name, e.emp_salary,
           DENSE_RANK() OVER (PARTITION BY d.dept_name ORDER BY e.emp_salary DESC) AS rank
    FROM Emp e
    LEFT JOIN Dept d ON e.dept_id = d.dept_id
)
SELECT emp_name, dept_name, emp_salary
FROM RankedEmployees
WHERE rank <= 3;
```

**Explanation:**
- **CTE**: Ranks employees within each department.
- **Final Query**: Filters to return only the top 3 employees per department.

### **Conclusion**

- **DENSE_RANK()**: Useful for ranking items without gaps.
- **CTE and Final Query**: Calculations and filtering are done in two stages—first to compute ranks, then to select and order results.

Understanding and applying `DENSE_RANK()` helps in creating precise and efficient ranking-based queries in SQL.

To demonstrate the use of `DENSE_RANK()` with the `Emp` and `Dept` tables, let’s start by creating sample tables and inserting data into them. After that, I'll provide a query that uses `DENSE_RANK()` to rank employees based on their salaries and join the results with their respective departments.

### **1. Sample Table Definitions and Data**

**Create `Dept` Table:**
```sql
CREATE TABLE Dept (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);
```

**Insert Sample Data into `Dept`:**
```sql
INSERT INTO Dept (dept_id, dept_name) VALUES
(1, 'Sales'),
(2, 'Engineering'),
(3, 'Marketing');
```

**Create `Emp` Table:**
```sql
CREATE TABLE Emp (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    emp_salary DECIMAL(10, 2),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Dept(dept_id)
);
```

**Insert Sample Data into `Emp`:**
```sql
INSERT INTO Emp (emp_id, emp_name, emp_salary, dept_id) VALUES
(1, 'Alice', 5000, 1),
(2, 'Bob', 7000, 1),
(3, 'Charlie', 7000, 2),
(4, 'David', 6000, 2),
(5, 'Eve', 5500, 3),
(6, 'Frank', 4500, 3);
```

### **2. SQL Query Using `DENSE_RANK()`**

The following query ranks employees based on their salaries within each department and joins the results with the department names.

**Query:**
```sql
SELECT e.emp_name, d.dept_name, e.emp_salary,
       DENSE_RANK() OVER (PARTITION BY d.dept_name ORDER BY e.emp_salary DESC) AS rank
FROM Emp e
LEFT JOIN Dept d ON e.dept_id = d.dept_id;
```

**Explanation:**
- **`PARTITION BY d.dept_name`**: Resets the rank for each department.
- **`ORDER BY e.emp_salary DESC`**: Ranks employees by salary within each department in descending order.

### **3. Example Result**

Given the sample data, the output of the query would be:

| emp_name | dept_name   | emp_salary | rank |
|----------|-------------|------------|------|
| Bob      | Sales       | 7000       | 1    |
| Alice    | Sales       | 5000       | 2    |
| Charlie  | Engineering | 7000       | 1    |
| David    | Engineering | 6000       | 2    |
| Eve      | Marketing   | 5500       | 1    |
| Frank    | Marketing   | 4500       | 2    |

### **4. Additional Example Queries**

**Query to Find Top 2 Salaries in Each Department:**

```sql
WITH RankedEmployees AS (
    SELECT e.emp_name, d.dept_name, e.emp_salary,
           DENSE_RANK() OVER (PARTITION BY d.dept_name ORDER BY e.emp_salary DESC) AS rank
    FROM Emp e
    LEFT JOIN Dept d ON e.dept_id = d.dept_id
)
SELECT emp_name, dept_name, emp_salary
FROM RankedEmployees
WHERE rank <= 2;
```

**Explanation:**
- This query ranks employees within each department and selects only the top 2 employees based on their salary.

**Query to Find Highest Salary in Each Department:**

```sql
WITH RankedEmployees AS (
    SELECT e.emp_name, d.dept_name, e.emp_salary,
           DENSE_RANK() OVER (PARTITION BY d.dept_name ORDER BY e.emp_salary DESC) AS rank
    FROM Emp e
    LEFT JOIN Dept d ON e.dept_id = d.dept_id
)
SELECT emp_name, dept_name, emp_salary
FROM RankedEmployees
WHERE rank = 1;
```

**Explanation:**
- This query selects employees with the highest salary in each department.

### **Conclusion**

Using `DENSE_RANK()` allows you to effectively rank items without gaps and is particularly useful for generating rank-based reports and analyses. The queries provided illustrate how to apply this function in various scenarios, from simple ranking to more complex filtering of top-ranked records.
### SQL Queries

#### Using `DENSE_RANK()`
```sql
-- Using DENSE_RANK() to rank employees and join with departments
SELECT e.emp_name, d.dept_name, DENSE_RANK() OVER (ORDER BY e.emp_salary) as rank
FROM Emp e
LEFT JOIN Dept d ON e.dept_id = d.dept_id;
```

#### Ordering with `DENSE_RANK()`
```sql
-- To use ORDER BY with DENSE_RANK(), you should calculate DENSE_RANK() first
WITH RankedEmployees AS (
    SELECT e.emp_name, d.dept_name, DENSE_RANK() OVER (ORDER BY e.emp_salary) as rank
    FROM Emp e
    LEFT JOIN Dept d ON e.dept_id = d.dept_id
)
SELECT emp_name, dept_name
FROM RankedEmployees
ORDER BY rank;
```


The SQL query you provided uses the `LEAD()` window function to get the salary of the next employee in the list based on the order of salaries. Let’s break down the query to understand how it works:

### Query Explanation

```sql
SELECT emp_name, emp_salary,
       LEAD(emp_salary) OVER (ORDER BY emp_salary DESC) AS next_salary
FROM Emp;
```

#### Components of the Query

1. **`SELECT emp_name, emp_salary,`**
   - Selects the `emp_name` and `emp_salary` columns from the `Emp` table.

2. **`LEAD(emp_salary) OVER (ORDER BY emp_salary DESC) AS next_salary`**
   - `LEAD(emp_salary)` is a window function that returns the value of `emp_salary` from the subsequent row in the result set based on the specified ordering.
   - `OVER (ORDER BY emp_salary DESC)` specifies the window for the `LEAD()` function, meaning it looks at the next row in the order defined by `ORDER BY emp_salary DESC`.

3. **`FROM Emp`**
   - Indicates the table from which to retrieve the data.

### How `LEAD()` Works

- **`LEAD(column_name)`**: Retrieves the value of a column from the next row in the result set. By default, if there is no subsequent row, it returns `NULL`.
- **`ORDER BY emp_salary DESC`**: Defines the order in which rows are processed. In this case, rows are ordered by `emp_salary` in descending order, meaning the highest salary comes first.

### Detailed Example

Given the sample data:

| emp_id | emp_name | emp_salary | dept_id |
|--------|----------|------------|---------|
| 1      | Alice    | 5000       | 1       |
| 2      | Bob      | 7000       | 1       |
| 3      | Charlie  | 7000       | 2       |
| 4      | David    | 6000       | 2       |
| 5      | Eve      | 5500       | 3       |
| 6      | Frank    | 4500       | 3       |

When you execute the query:

```sql
SELECT emp_name, emp_salary,
       LEAD(emp_salary) OVER (ORDER BY emp_salary DESC) AS next_salary
FROM Emp;
```

#### Result:

| emp_name | emp_salary | next_salary |
|----------|------------|-------------|
| Bob      | 7000       | 7000        |
| Charlie  | 7000       | 6000        |
| David    | 6000       | 5500        |
| Eve      | 5500       | 4500        |
| Alice    | 5000       | NULL        |
| Frank    | 4500       | NULL        |

### Explanation of Results

- **Bob**: The highest salary is `7000`. The `LEAD()` function looks at the next row in the descending order of salaries. The next salary is `7000` (Charlie), as they are tied.
- **Charlie**: The next salary is `6000` (David).
- **David**: The next salary is `5500` (Eve).
- **Eve**: The next salary is `4500` (Frank).
- **Alice**: Since Alice has the lowest salary among the listed employees, the `LEAD()` function returns `NULL` as there is no subsequent row.
- **Frank**: Similarly, Frank has no next row, so `NULL` is returned.

### Summary

- The `LEAD()` function is useful for comparing a value with the next row’s value based on a specific ordering.
- If the `ORDER BY` clause specifies descending order, `LEAD()` provides the next lower salary for each employee.
- If there is no next row (i.e., the last row), `LEAD()` returns `NULL`.

This function is particularly handy in scenarios where you need to compare a value with its subsequent values in a dataset, such as in time series data or ordered lists.

Certainly! Here’s a comprehensive list of SQL interview questions with examples, covering various aspects like basic queries, joins, subqueries, ranking functions, and more.

### 1. Basic SQL Queries

**1.1 Select All Columns**

- **Question:** How do you select all columns from a table named `employees`?
  
  **Example:**
  ```sql
  SELECT * FROM employees;
  ```

**1.2 Select Specific Columns**

- **Question:** How do you select `first_name` and `last_name` from the `employees` table?
  
  **Example:**
  ```sql
  SELECT first_name, last_name FROM employees;
  ```

### 2. Filtering Data

**2.1 Simple WHERE Clause**

- **Question:** How do you find employees with a salary greater than $50,000?
  
  **Example:**
  ```sql
  SELECT * FROM employees
  WHERE salary > 50000;
  ```

**2.2 WHERE with Multiple Conditions**

- **Question:** How do you find employees in the 'IT' department with a salary greater than $60,000?
  
  **Example:**
  ```sql
  SELECT * FROM employees
  WHERE department = 'IT' AND salary > 60000;
  ```

### 3. Aggregation Functions

**3.1 Using `COUNT()`**

- **Question:** How do you count the number of employees in each department?
  
  **Example:**
  ```sql
  SELECT department, COUNT(*) AS num_employees
  FROM employees
  GROUP BY department;
  ```

**3.2 Using `AVG()`**

- **Question:** How do you find the average salary of all employees?
  
  **Example:**
  ```sql
  SELECT AVG(salary) AS average_salary
  FROM employees;
  ```

### 4. Joins

**4.1 Inner Join**

- **Question:** How do you perform an inner join between `employees` and `departments` on `department_id`?
  
  **Example:**
  ```sql
  SELECT e.first_name, d.department_name
  FROM employees e
  INNER JOIN departments d ON e.department_id = d.department_id;
  ```

**4.2 Left Join**

- **Question:** How do you get all employees and their departments, including those without a department?
  
  **Example:**
  ```sql
  SELECT e.first_name, d.department_name
  FROM employees e
  LEFT JOIN departments d ON e.department_id = d.department_id;
  ```

**4.3 Right Join**

- **Question:** How do you get all departments and the employees in them, including departments with no employees?
  
  **Example:**
  ```sql
  SELECT d.department_name, e.first_name
  FROM departments d
  RIGHT JOIN employees e ON d.department_id = e.department_id;
  ```

**4.4 Full Join**

- **Question:** How do you get all employees and departments, including those without a matching counterpart in the other table?
  
  **Example:**
  ```sql
  SELECT e.first_name, d.department_name
  FROM employees e
  FULL OUTER JOIN departments d ON e.department_id = d.department_id;
  ```

### 5. Subqueries

**5.1 Simple Subquery**

- **Question:** How do you find employees who have a salary greater than the average salary of all employees?
  
  **Example:**
  ```sql
  SELECT * FROM employees
  WHERE salary > (SELECT AVG(salary) FROM employees);
  ```

**5.2 Correlated Subquery**

- **Question:** How do you find employees who earn more than the highest salary in the 'IT' department?
  
  **Example:**
  ```sql
  SELECT * FROM employees e1
  WHERE salary > (SELECT MAX(salary) FROM employees e2 WHERE e2.department = 'IT');
  ```

### 6. Ranking Functions

**6.1 Using `ROW_NUMBER()`**

- **Question:** How do you rank employees by salary within their department?
  
  **Example:**
  ```sql
  SELECT first_name, salary, department,
         ROW_NUMBER() OVER (PARTITION BY department ORDER BY salary DESC) AS rank
  FROM employees;
  ```

**6.2 Using `DENSE_RANK()`**

- **Question:** How do you assign a rank to employees based on their salary, with no gaps in ranking values?
  
  **Example:**
  ```sql
  SELECT first_name, salary,
         DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_rank
  FROM employees;
  ```

**6.3 Using `RANK()`**

- **Question:** How do you assign a rank to employees by their salary, allowing for gaps in rank values when there are ties?
  
  **Example:**
  ```sql
  SELECT first_name, salary,
         RANK() OVER (ORDER BY salary DESC) AS rank
  FROM employees;
  ```

### 7. Window Functions

**7.1 Using `LEAD()`**

- **Question:** How do you get the salary of the next employee in the list?
  
  **Example:**
  ```sql
  SELECT first_name, salary,
         LEAD(salary) OVER (ORDER BY salary DESC) AS next_salary
  FROM employees;
  ```

**7.2 Using `LAG()`**

- **Question:** How do you get the salary of the previous employee in the list?
  
  **Example:**
  ```sql
  SELECT first_name, salary,
         LAG(salary) OVER (ORDER BY salary DESC) AS previous_salary
  FROM employees;
  ```

### 8. Common Table Expressions (CTEs)

**8.1 Basic CTE**

- **Question:** How do you use a CTE to find employees with salaries greater than $60,000?
  
  **Example:**
  ```sql
  WITH HighEarners AS (
      SELECT * FROM employees
      WHERE salary > 60000
  )
  SELECT * FROM HighEarners;
  ```

**8.2 Recursive CTE**

- **Question:** How do you use a recursive CTE to find all employees reporting to a manager with a specific `manager_id`?
  
  **Example:**
  ```sql
  WITH RECURSIVE EmployeeHierarchy AS (
      SELECT employee_id, manager_id, first_name
      FROM employees
      WHERE manager_id = 1 -- starting point
      UNION ALL
      SELECT e.employee_id, e.manager_id, e.first_name
      FROM employees e
      INNER JOIN EmployeeHierarchy eh ON e.manager_id = eh.employee_id
  )
  SELECT * FROM EmployeeHierarchy;
  ```

### 9. Example Queries Based on Sample Data

**9.1 Find Top 2 Salaries in Each Department**

- **Question:** How do you find the top 2 salaries within each department?
  
  **Example:**
  ```sql
  WITH RankedEmployees AS (
      SELECT e.emp_name, d.dept_name, e.emp_salary,
             DENSE_RANK() OVER (PARTITION BY d.dept_name ORDER BY e.emp_salary DESC) AS rank
      FROM Emp e
      LEFT JOIN Dept d ON e.dept_id = d.dept_id
  )
  SELECT emp_name, dept_name, emp_salary
  FROM RankedEmployees
  WHERE rank <= 2;
  ```

**9.2 Find Highest Salary in Each Department**

- **Question:** How do you find the highest salary in each department?
  
  **Example:**
  ```sql
  WITH RankedEmployees AS (
      SELECT e.emp_name, d.dept_name, e.emp_salary,
             DENSE_RANK() OVER (PARTITION BY d.dept_name ORDER BY e.emp_salary DESC) AS rank
      FROM Emp e
      LEFT JOIN Dept d ON e.dept_id = d.dept_id
  )
  SELECT emp_name, dept_name, emp_salary
  FROM RankedEmployees
  WHERE rank = 1;
  ```

**9.3 Find Employees with Salary Above the Average Salary of Their Department**

- **Question:** How do you find employees with a salary above the average salary of their department?
  
  **Example:**
  ```sql
  WITH DepartmentAvg AS (
      SELECT dept_id, AVG(emp_salary) AS avg_salary
      FROM Emp
      GROUP BY dept_id
  )
  SELECT e.emp_name, d.dept_name, e.emp_salary
  FROM Emp e
  JOIN Dept d ON e.dept_id = d.dept_id
  JOIN DepartmentAvg da ON e.dept_id = da.dept_id
  WHERE e.emp_salary > da.avg_salary;
  ```

These examples cover a wide range of SQL concepts and should help you prepare for SQL-related interview questions. If you have specific topics or queries you'd like to explore further, let me know!


Sure! Let's break down the SQL and MongoDB interview questions, covering common topics and examples for each.

### SQL Interview Questions and Examples

**1. Basic SQL Queries**

- **Question:** Write a query to select all columns from a table named `employees`.
  
  **Example:**
  ```sql
  SELECT * FROM employees;
  ```

- **Question:** How do you retrieve specific columns from a table?
  
  **Example:**
  ```sql
  SELECT first_name, last_name FROM employees;
  ```

**2. Filtering Data**

- **Question:** Write a query to select employees whose salary is greater than $50,000.
  
  **Example:**
  ```sql
  SELECT * FROM employees
  WHERE salary > 50000;
  ```

- **Question:** How can you select employees who were hired in the year 2023?
  
  **Example:**
  ```sql
  SELECT * FROM employees
  WHERE YEAR(hire_date) = 2023;
  ```

**3. Joins**

- **Question:** How do you perform an inner join between `employees` and `departments` on `department_id`?
  
  **Example:**
  ```sql
  SELECT employees.first_name, departments.department_name
  FROM employees
  INNER JOIN departments ON employees.department_id = departments.department_id;
  ```

- **Question:** What is the difference between an INNER JOIN and a LEFT JOIN?
  
  **Answer:** An INNER JOIN returns only the rows that have matching values in both tables. A LEFT JOIN (or LEFT OUTER JOIN) returns all rows from the left table and the matched rows from the right table. If there is no match, NULL values are returned for columns from the right table.

**4. Aggregation**

- **Question:** How do you find the average salary of employees?
  
  **Example:**
  ```sql
  SELECT AVG(salary) AS average_salary
  FROM employees;
  ```

- **Question:** Write a query to count the number of employees in each department.
  
  **Example:**
  ```sql
  SELECT department_id, COUNT(*) AS num_employees
  FROM employees
  GROUP BY department_id;
  ```

**5. Subqueries**

- **Question:** Write a query to find employees whose salary is higher than the average salary of all employees.
  
  **Example:**
  ```sql
  SELECT * FROM employees
  WHERE salary > (SELECT AVG(salary) FROM employees);
  ```

**6. Indexes**

- **Question:** What is an index in SQL, and why is it used?
  
  **Answer:** An index is a database object that improves the speed of data retrieval operations on a table. It works like an index in a book, allowing the database to find data without scanning the entire table.

**7. Transactions**

- **Question:** What is a transaction in SQL, and how do you use it?
  
  **Answer:** A transaction is a sequence of one or more SQL operations treated as a single unit. It ensures data integrity and consistency. Transactions are managed using commands like `BEGIN`, `COMMIT`, and `ROLLBACK`.

  **Example:**
  ```sql
  BEGIN;
  UPDATE accounts SET balance = balance - 100 WHERE account_id = 1;
  UPDATE accounts SET balance = balance + 100 WHERE account_id = 2;
  COMMIT;
  ```

### MongoDB Interview Questions and Configuration

**1. Basic Commands**

- **Question:** How do you insert a document into a collection in MongoDB?
  
  **Example:**
  ```javascript
  db.employees.insertOne({
    first_name: "John",
    last_name: "Doe",
    salary: 60000
  });
  ```

- **Question:** How do you retrieve all documents from a collection?
  
  **Example:**
  ```javascript
  db.employees.find({});
  ```

**2. Querying**

- **Question:** Write a query to find employees with a salary greater than $50,000.
  
  **Example:**
  ```javascript
  db.employees.find({ salary: { $gt: 50000 } });
  ```

- **Question:** How do you find a document by a specific field?
  
  **Example:**
  ```javascript
  db.employees.findOne({ first_name: "John" });
  ```

**3. Updating Documents**

- **Question:** How do you update a document in MongoDB?
  
  **Example:**
  ```javascript
  db.employees.updateOne(
    { first_name: "John" },
    { $set: { salary: 65000 } }
  );
  ```

- **Question:** Write a query to increment the salary of all employees by 10%.
  
  **Example:**
  ```javascript
  db.employees.updateMany(
    {},
    { $inc: { salary: salary * 0.10 } }
  );
  ```

**4. Aggregation**

- **Question:** How do you use the aggregation framework to find the average salary of employees?
  
  **Example:**
  ```javascript
  db.employees.aggregate([
    { $group: { _id: null, average_salary: { $avg: "$salary" } } }
  ]);
  ```

**5. Indexes**

- **Question:** What is an index in MongoDB, and how do you create one?
  
  **Answer:** An index in MongoDB improves query performance by allowing the database to quickly locate documents. It is similar to SQL indexes.

  **Example:**
  ```javascript
  db.employees.createIndex({ salary: 1 });
  ```

**6. Sharding**

- **Question:** What is sharding in MongoDB?
  
  **Answer:** Sharding is a method for distributing data across multiple servers to handle large datasets and high throughput operations. It involves dividing data into chunks and distributing them across shards.

**7. Replica Sets**

- **Question:** What is a replica set in MongoDB?
  
  **Answer:** A replica set is a group of MongoDB servers that maintain the same data set. It provides redundancy and high availability through automatic failover and data replication.

**8. Configuration**

- **Question:** How do you configure a MongoDB instance?
  
  **Answer:** MongoDB instances can be configured using the `mongod` command with various options, or through a configuration file (typically `mongod.conf`). Common configurations include setting the database path, network interfaces, and security settings.

  **Example of starting MongoDB with configuration file:**
  ```bash
  mongod --config /path/to/mongod.conf
  ```

  **Example of a basic `mongod.conf` file:**
  ```yaml
  storage:
    dbPath: /var/lib/mongodb
  net:
    bindIp: 127.0.0.1
    port: 27017
  ```

These questions and examples cover a broad range of topics for SQL and MongoDB interviews. Let me know if you need more details or have specific areas you’d like to dive into!


In the context of Spring Boot, MongoDB, and databases, sharding is a technique used to distribute data across multiple servers or clusters to handle large amounts of data and to improve performance and availability. Here’s a comprehensive guide on implementing sharding, focusing on MongoDB and how it integrates with Spring Boot.

### Sharding in MongoDB

MongoDB provides built-in support for sharding, which is ideal for horizontally scaling a database. 

#### **1. **Sharding Overview in MongoDB**

Sharding involves splitting a large dataset into smaller, more manageable pieces called shards. Each shard is a MongoDB instance or cluster, and together they form a sharded cluster.

**Key Components of MongoDB Sharding:**

- **Shard**: A single MongoDB instance or replica set that holds a subset of the data.
- **Config Servers**: Manage metadata and configuration settings for the sharded cluster.
- **Query Routers (mongos)**: Interface between client applications and the sharded cluster. They route queries to the appropriate shard based on the sharding key.

#### **2. **Setting Up Sharding in MongoDB**

**Step 1: Set Up Config Servers**

Config servers store metadata and configuration settings. You need at least three config servers for a production environment.

```shell
# Start config servers
mongod --configsvr --dbpath /data/configdb1 --port 27019 --replSet configReplSet
mongod --configsvr --dbpath /data/configdb2 --port 27020 --replSet configReplSet
mongod --configsvr --dbpath /data/configdb3 --port 27021 --replSet configReplSet
```

**Step 2: Set Up Shards**

Each shard can be a single MongoDB instance or a replica set. Start the shard instances.

```shell
# Start shard servers
mongod --shardsvr --dbpath /data/shard1 --port 27018
mongod --shardsvr --dbpath /data/shard2 --port 27019
mongod --shardsvr --dbpath /data/shard3 --port 27020
```

**Step 3: Set Up Query Routers**

Query routers (mongos) distribute client requests to the appropriate shards.

```shell
# Start mongos instances
mongos --configdb configReplSet/localhost:27019,localhost:27020,localhost:27021
```

**Step 4: Add Shards to the Cluster**

Connect to the mongos instance and add the shards.

```shell
use admin
sh.addShard("localhost:27018")
sh.addShard("localhost:27019")
sh.addShard("localhost:27020")
```

**Step 5: Enable Sharding for a Database**

Choose the database to shard and enable sharding.

```shell
use mydatabase
sh.enableSharding("mydatabase")
```

**Step 6: Choose a Shard Key**

The shard key determines how data is distributed. Choose a shard key and shard the collection.

```shell
sh.shardCollection("mydatabase.mycollection", { "customer_id": 1 })
```

### Spring Boot Integration with MongoDB Sharding

To integrate MongoDB sharding with a Spring Boot application, you need to configure your application to connect to the sharded MongoDB cluster.

#### **1. **Dependencies**

Add MongoDB dependencies to your `pom.xml` or `build.gradle`.

**Maven:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

**Gradle:**

```groovy
implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
```

#### **2. **Configuration**

Configure MongoDB in your `application.properties` or `application.yml` to connect to the mongos instance.

**application.properties:**

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/mydatabase
```

**application.yml:**

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/mydatabase
```

#### **3. **Repository**

Define a repository interface for your MongoDB collections.

```java
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // Custom queries if needed
}
```

#### **4. **Entity**

Define your MongoDB entity class with appropriate annotations.

```java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mycollection")
public class Order {
    
    @Id
    private String id;
    private Integer customerId;
    private Double amount;
    private String orderDate;

    // Getters and setters
}
```

### Best Practices and Considerations

1. **Choosing a Shard Key**: The choice of shard key is crucial. It should distribute the data evenly and avoid hotspots. A good shard key should be frequently used in queries and should have high cardinality.

2. **Monitoring**: Use MongoDB’s monitoring tools and logs to keep track of shard performance and health.

3. **Balancing**: MongoDB automatically balances data across shards. However, manual intervention may be required in some cases to rebalance data.

4. **Handling Failures**: Ensure that your application handles shard failures gracefully. Implement retry logic and monitor for shard failures.

5. **Indexing**: Ensure that you create indexes on the shard key to optimize query performance.

6. **Testing**: Thoroughly test sharding configurations in a staging environment before deploying to production.

By setting up and configuring sharding properly, you can achieve horizontal scaling for your MongoDB instance, handle large datasets more effectively, and ensure high availability for your application.

Scaling is the process of increasing the capacity of a system to handle a growing amount of work or traffic. In computing, there are two primary types of scaling: **horizontal scaling** and **vertical scaling**. Understanding these concepts is crucial for designing scalable applications and systems.

### **1. Horizontal Scaling**

**Horizontal scaling** (or **scaling out**) involves adding more instances or nodes to a system to distribute the load across multiple machines. This is often used to handle increased traffic or workload by spreading it over multiple servers.

**Characteristics of Horizontal Scaling:**

- **Scale Out/In**: You add more machines (scale out) or remove machines (scale in) as needed.
- **Load Balancing**: A load balancer is typically used to distribute incoming requests across the available nodes.
- **Stateless Design**: For effective horizontal scaling, applications are often designed to be stateless, meaning that each request is independent and does not rely on previous requests.
- **Fault Tolerance**: If one node fails, others can continue to handle the load, improving system reliability and fault tolerance.
- **Data Distribution**: Data can be distributed across nodes, such as in sharding databases.

**Example:**

Consider a web application that experiences increased traffic. To handle the load, you can deploy multiple web servers (instances) behind a load balancer. The load balancer distributes incoming HTTP requests among these servers, allowing the system to handle more traffic.

**Cloud Services Example:**

- **AWS Elastic Load Balancing**: Distributes incoming traffic across multiple Amazon EC2 instances.
- **Kubernetes**: Manages scaling of containerized applications by deploying multiple replicas of a pod.

### **2. Vertical Scaling**

**Vertical scaling** (or **scaling up**) involves increasing the capacity of a single machine by adding more resources such as CPU, memory, or storage. This method improves the performance of a single node.

**Characteristics of Vertical Scaling:**

- **Scale Up/Down**: You add more resources (scale up) or reduce resources (scale down) on a single machine.
- **Limited by Hardware**: There is a physical limit to how much you can scale up a single machine. Eventually, you may hit hardware limits.
- **Single Point of Failure**: If the machine fails, the entire system may be affected, making it a single point of failure.
- **Less Complex**: Vertical scaling is often simpler than horizontal scaling because it does not require distribution or load balancing.

**Example:**

If a database server is running slow due to high CPU usage, you might upgrade its hardware to a more powerful server with more CPU cores and memory. This upgrade helps the database handle more queries and perform better.

**Cloud Services Example:**

- **AWS EC2 Instances**: You can choose a larger instance type with more resources as your application needs grow.
- **Google Cloud SQL**: Allows you to vertically scale the resources (CPU, memory) of a managed database instance.

### **Comparing Horizontal and Vertical Scaling**

**Advantages of Horizontal Scaling:**
- **Elasticity**: Easily scales out by adding more nodes as demand grows and scales in by removing nodes when demand decreases.
- **Fault Tolerance**: Offers better fault tolerance since failure of a single node does not affect the overall system.
- **Cost**: Can be more cost-effective at very large scales since you can use commodity hardware.

**Disadvantages of Horizontal Scaling:**
- **Complexity**: Requires load balancing, distributed systems management, and often a stateless application design.
- **Data Consistency**: Managing consistency across multiple nodes can be complex, especially in databases.

**Advantages of Vertical Scaling:**
- **Simplicity**: Easier to implement and manage as it involves upgrading a single machine.
- **Consistency**: No need for complex data distribution or synchronization issues.

**Disadvantages of Vertical Scaling:**
- **Limits**: Limited by the maximum hardware capacity of a single machine.
- **Single Point of Failure**: A failure in the single machine can bring down the entire system.

### **When to Use Each Type of Scaling**

- **Horizontal Scaling**: Best for systems requiring high availability and reliability, or when the system needs to handle large volumes of data or traffic. Ideal for web applications, distributed databases, and microservices architectures.
  
- **Vertical Scaling**: Suitable for smaller-scale applications or when dealing with a single machine’s performance limitations. Useful for legacy systems where horizontal scaling is challenging.

### **Example Scenarios**

1. **E-Commerce Website**:
   - **Horizontal Scaling**: Use multiple web servers and a load balancer to handle high traffic during sales events.
   - **Vertical Scaling**: Upgrade the database server to handle complex queries and large datasets.

2. **Data Analytics Application**:
   - **Horizontal Scaling**: Distribute data processing tasks across multiple nodes to handle big data workloads.
   - **Vertical Scaling**: Increase the memory and CPU of an analytics server to speed up data processing.

By understanding and implementing both horizontal and vertical scaling, you can design systems that are robust, scalable, and able to handle varying loads efficiently.

**Scale Up** and **Scale Down** are terms used in the context of scaling computing resources to meet varying demands. These concepts are fundamental in cloud computing and infrastructure management. Here's a detailed explanation:

### **Scale Up (Vertical Scaling)**

**Scale Up** refers to increasing the resources of a single computing instance or server to handle more load or provide better performance. This involves upgrading the existing hardware or virtual machine to add more resources like CPU, RAM, or storage.

#### **How Scale Up Works:**
1. **Add More Resources**: Increase the CPU cores, memory, or storage of a single server or instance.
2. **Upgrade Hardware**: Replace the existing server with a more powerful one if you’re managing physical hardware.
3. **Modify Instance Type**: In cloud environments, you can switch to a larger instance type with more resources.

#### **When to Use Scale Up:**
- **Single Machine Limitations**: When a single machine is nearing its resource limits.
- **Simplicity**: When managing a single machine is easier than distributing workloads across multiple machines.
- **Stateful Applications**: When dealing with applications that require a large amount of local resources or are not easily distributed.

#### **Advantages of Scale Up:**
- **Simplicity**: Easier to implement, as it involves only upgrading a single machine or instance.
- **Consistency**: No need for complex data distribution or synchronization across multiple machines.

#### **Disadvantages of Scale Up:**
- **Limits**: You are limited by the maximum capacity of the hardware or instance type.
- **Single Point of Failure**: The failure of a single machine can impact the entire system.

#### **Example:**
- **Database Server**: If a database server is experiencing slow queries due to high CPU usage, upgrading to a server with more CPUs and RAM can help improve performance.

### **Scale Down (Vertical Scaling Down)**

**Scale Down** refers to reducing the resources of a computing instance or server when the demand decreases. This involves downgrading the existing hardware or virtual machine to save costs or optimize resource usage.

#### **How Scale Down Works:**
1. **Reduce Resources**: Decrease the number of CPU cores, memory, or storage of a server or instance.
2. **Downgrade Hardware**: Switch to a less powerful server if managing physical hardware.
3. **Modify Instance Type**: In cloud environments, you can switch to a smaller instance type with fewer resources.

#### **When to Use Scale Down:**
- **Decreased Load**: When the demand for resources decreases, and the current instance type is more than what is needed.
- **Cost Savings**: To reduce costs by using fewer resources when the application is not under heavy load.

#### **Advantages of Scale Down:**
- **Cost Efficiency**: Saves money by reducing resource usage when it's not needed.
- **Resource Optimization**: Ensures resources are used efficiently according to current demand.

#### **Disadvantages of Scale Down:**
- **Capacity Limitations**: May reduce the available capacity below what is needed if not done carefully.
- **Potential Downtime**: Downgrading resources might require a restart or reconfiguration, potentially causing temporary unavailability.

#### **Example:**
- **Web Application**: After a peak traffic period (e.g., a major sale), you might scale down from a high-performance instance to a smaller one to save costs when traffic returns to normal.

### **Horizontal Scaling (Scale Out/In)**

In addition to scaling up and down, **Horizontal Scaling** (or scaling out/in) involves adding or removing instances or nodes to handle varying loads. This involves distributing the load across multiple machines rather than upgrading a single machine.

#### **How Scale Out/In Works:**
1. **Scale Out**: Add more machines or instances to handle increased load.
2. **Scale In**: Remove machines or instances when the load decreases.

#### **When to Use Scale Out/In:**
- **High Availability**: To improve fault tolerance and availability by spreading the load across multiple instances.
- **Load Distribution**: When the application needs to handle a large number of requests or data.

#### **Example:**
- **Web Application**: During high traffic periods, you can scale out by adding more web servers behind a load balancer. After the peak period, scale in by reducing the number of web servers.

### **Summary**

- **Scale Up**: Increase resources of a single server or instance. Used when more power is needed for a single node.
- **Scale Down**: Decrease resources of a single server or instance. Used when less power is needed and to save costs.
- **Scale Out/In**: Add or remove instances or nodes. Used for handling larger loads by distributing across multiple machines.

Understanding these concepts helps in designing scalable systems that efficiently handle varying workloads and optimize resource usage.
