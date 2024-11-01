# SQL Documentation

## Table of Contents
1. [What is SQL?](#what-is-sql)
2. [What are the different types of SQL statements?](#what-are-the-different-types-of-sql-statements)
3. [What does NULL mean in SQL?](#what-does-null-mean-in-sql)
4. [What is a "temporary table"? What is it used for?](#what-is-a-temporary-table-what-is-it-used-for)
5. [What is a "view" and what is it used for?](#what-is-a-view-and-what-is-it-used-for)
6. [What is the general syntax of the SELECT statement?](#what-is-the-general-syntax-of-the-select-statement)
7. [What is JOIN?](#what-is-join)
8. [What are the different types of JOINs?](#what-are-the-different-types-of-joins)
9. [Is it better to use JOINs or subqueries?](#is-it-better-to-use-joins-or-subqueries)
10. [What is the HAVING operator used for?](#what-is-the-having-operator-used-for)
11. [What's the difference between HAVING and WHERE statements?](#whats-the-difference-between-having-and-where-statements)
12. [What is the ORDER BY operator used for?](#what-is-the-order-by-operator-used-for)
13. [What is the GROUP BY operator used for?](#what-is-the-group-by-operator-used-for)
14. [How does GROUP BY handle null?](#how-does-group-by-handle-null)
15. [What is the difference between GROUP BY and DISTINCT operators?](#what-is-the-difference-between-group-by-and-distinct-operators)
16. [List the main aggregate functions.](#list-the-main-aggregate-functions)
17. [What is the difference between COUNT(*) and COUNT({column})?](#what-is-the-difference-between-count-and-countcolumn)
18. [What does the EXISTS operator do?](#what-does-the-exists-operator-do)
19. [What are the IN, BETWEEN, LIKE operators used for?](#what-are-the-in-between-like-operators-used-for)
20. [What is the UNION keyword used for?](#what-is-the-union-keyword-used-for)
21. [What are the integrity constraints in SQL?](#what-are-the-integrity-constraints-in-sql)
22. [What are the differences between the PRIMARY and UNIQUE constraints?](#what-are-the-differences-between-the-primary-and-unique-constraints)
23. [Can a value in a column that has a FOREIGN KEY constraint be null?](#can-a-value-in-a-column-that-has-a-foreign-key-constraint-be-null)
24. [How do I create an index?](#how-do-i-create-an-index)
25. [What does the MERGE statement do?](#what-does-the-merge-statement-do)
26. [What's the difference between DELETE and TRUNCATE?](#whats-the-difference-between-delete-and-truncate)
27. [What is a "stored procedure"?](#what-is-a-stored-procedure)
28. [What is a "trigger"?](#what-is-a-trigger)
29. [What is a "cursor"?](#what-is-a-cursor)
30. [Describe the difference between the DATETIME and TIMESTAMP data types.](#describe-the-difference-between-the-datetime-and-timestamp-data-types)
31. [For which numeric types is it unacceptable to use addition/subtraction operations?](#for-which-numeric-types-is-it-unacceptable-to-use-additionsubtraction-operations)
32. [What is the purpose of the PIVOT and UNPIVOT operators in Transact-SQL?](#what-is-the-purpose-of-the-pivot-and-unpivot-operators-in-transact-sql)
33. [Tell us about the main ranking functions in Transact-SQL.](#tell-us-about-the-main-ranking-functions-in-transact-sql)
34. [What are the INTERSECT and EXCEPT statements used for in Transact-SQL?](#what-are-the-intersect-and-except-statements-used-for-in-transact-sql)
35. [SQL Queries Examples](#sql-queries-examples)

---

## What is SQL?
SQL, Structured Query Language, is a formal, non-procedural programming language used to create, modify, and manipulate data in an arbitrary relational database managed by an appropriate database management system (DBMS).

## What are the different types of SQL statements?
### Data Definition Language (DDL) operators:
- **CREATE**: creates a database object (database, table, view, user, etc.)
- **ALTER**: modifies the object
- **DROP**: deletes the object

### Data Manipulation Language (DML) operators:
- **SELECT**: selects data that meets the specified conditions
- **INSERT**: adds new data
- **UPDATE**: modifies existing data
- **DELETE**: deletes data

### Data Control Language (DCL) operators:
- **GRANT**: grants the user (group) permissions for certain operations
- **REVOKE**: revoke previously issued permits
- **DENY**: specifies a ban that takes precedence over permission.

### Transaction Control Language (TCL) operators:
- **COMMIT**: applies the transaction
- **ROLLBACK**: rolls back all changes made in the context of the current transaction
- **SAVEPOINT**: splits the transaction into smaller ones.

## What does NULL mean in SQL?
NULL - A special value (pseudo-value) that can be written to a field in a database table. NULL corresponds to the concept of an "empty field," that is, "a field that does not contain any value." 

NULL means the absence, the unknownness of information. A value is not a value in the full sense of the word: by definition, it means no meaning and does not belong to any data type.

## What is a "temporary table"? What is it used for?
A temporary table is a database object that is stored and managed by a database system on a temporary basis. They can be local or global. Used to save the results of a stored procedure call, reduce the number of rows in joins, aggregate data from different sources, or replace cursors and parameterized views.

## What is a "view" and what is it used for?
A view is a virtual table that represents data from one or more tables in an alternate manner. In reality, a view is just the result of the execution of a statement that is stored in a memory structure that resembles an SQL table. Views enhance data management capabilities and provide controlled access to specific data.

## What is the general syntax of the SELECT statement?
The SELECT statement has the following structure:

```sql
SELECT 
       [DISTINCT | DISTINCTROW | ALL]
       select_expression,...
   FROM table_references
     [WHERE where_definition]
     [GROUP BY {unsigned_integer | column | formula}]
     [HAVING where_definition]
     [ORDER BY {unsigned_integer | column | formula} [ASC | DESC], ...]
```

## What is JOIN?
JOIN is a SQL operator that allows data to be sampled from two tables and included in a single result set. The result schema includes columns of both source tables, and each row of the result table is a "concatenation" of a row from one operand table with a row of the second operand table.

```sql
SELECT
  field_name [,... n]
FROM
  Table1
  {INNER | {LEFT | RIGHT | FULL} OUTER | CROSS } JOIN
  Table2
    {ON <condition> | USING (field_name [,... n])}
```

## What are the different types of JOINs?
- **INNER JOIN**: Selects records that are common to both tables.
- **LEFT (OUTER) JOIN**: Selects all records in the first table and matching records in the second.
- **RIGHT (OUTER) JOIN**: Selects all records in the second table and matching records in the first.
- **FULL (OUTER) JOIN**: Selects all records that are present in either table.
- **CROSS JOIN**: Produces a Cartesian product of the two tables, combining each row in one table with every row in the other.

## Is it better to use JOINs or subqueries?
It is usually better to use JOINs, as they are often more understandable and better optimized by the DBMS. However, subqueries are useful for calculating aggregate values for comparisons.

## What is the HAVING operator used for?
HAVING is used to filter the results of a GROUP BY operation based on specified logical conditions.

## What's the difference between HAVING and WHERE statements?
HAVING is used after GROUP BY and operates on aggregate values, while WHERE is used to filter records before grouping.

## What is the ORDER BY operator used for?
ORDER BY organizes the query output according to the values in specified columns, allowing for ascending or descending order.

## What is the GROUP BY operator used for?
GROUP BY is used to aggregate result records by specified attributes.

## How does GROUP BY handle null?
When GROUP BY is used, all NULL values are considered equal.

## What is the difference between GROUP BY and DISTINCT operators?
DISTINCT returns unique column values, while GROUP BY creates groups of records for aggregate functions. 

## List the main aggregate functions.
SQL provides several aggregate functions:
- **COUNT**: counts records that meet the query condition
- **SUM**: calculates the arithmetic sum of all column values
- **AVG**: calculates the arithmetic mean of all values
- **MAX**: determines the highest of all selected values


- **MIN**: determines the lowest of all selected values

## What is the difference between COUNT(*) and COUNT({column})?
COUNT(*) returns the total number of records, including NULLs, while COUNT({column}) counts only non-null values for the specified column.

## What does the EXISTS operator do?
EXISTS checks whether a subquery returns any records, returning TRUE if it does and FALSE if it doesn't.

## What are the IN, BETWEEN, LIKE operators used for?
- **IN**: checks if a value matches any value within a specified list.
- **BETWEEN**: filters records within a specified range.
- **LIKE**: searches for a specified pattern in a column.

## What is the UNION keyword used for?
UNION combines the result sets of two or more SELECT queries, eliminating duplicates by default.

## What are the integrity constraints in SQL?
Integrity constraints ensure the accuracy and consistency of data in a relational database. Common types include:
- **NOT NULL**: ensures a column cannot contain NULL values
- **UNIQUE**: ensures all values in a column are different
- **PRIMARY KEY**: ensures a column can uniquely identify a record
- **FOREIGN KEY**: establishes a relationship between two tables

## What are the differences between the PRIMARY and UNIQUE constraints?
A PRIMARY KEY constraint ensures uniqueness and does not allow NULL values, while a UNIQUE constraint allows for a single NULL value.

## Can a value in a column that has a FOREIGN KEY constraint be null?
Yes, a column with a FOREIGN KEY constraint can contain NULL values.

## How do I create an index?
To create an index, you can use the following syntax:

```sql
CREATE INDEX index_name ON table_name (column_name);
```

## What does the MERGE statement do?
The MERGE statement performs insert, update, or delete operations in a single statement, based on a match between two tables.

## What's the difference between DELETE and TRUNCATE?
DELETE removes rows one at a time and can be rolled back, while TRUNCATE removes all rows from a table without logging individual row deletions and cannot be rolled back.

## What is a "stored procedure"?
A stored procedure is a precompiled collection of SQL statements that can be executed as a single unit. It can take parameters and return values.

## What is a "trigger"?
A trigger is a special type of stored procedure that automatically executes in response to certain events on a particular table.

## What is a "cursor"?
A cursor is a database object that allows you to retrieve, manipulate, and navigate through a result set one row at a time.

## Describe the difference between the DATETIME and TIMESTAMP data types.
DATETIME stores a date and time value without timezone information, while TIMESTAMP includes timezone support, making it more suitable for tracking changes across different time zones.

## For which numeric types is it unacceptable to use addition/subtraction operations?
Addition and subtraction are unacceptable for numeric types like `DECIMAL` and `NUMERIC` when they exceed the precision defined during column creation.

## What is the purpose of the PIVOT and UNPIVOT operators in Transact-SQL?
PIVOT transforms rows into columns, while UNPIVOT transforms columns into rows, allowing for more flexible reporting.

## Tell us about the main ranking functions in Transact-SQL.
The main ranking functions include:
- **ROW_NUMBER()**: assigns a unique sequential integer to rows within a partition.
- **RANK()**: assigns a unique rank to rows with the same values, allowing for gaps in ranking.
- **DENSE_RANK()**: similar to RANK, but without gaps in ranking.

## What are the INTERSECT and EXCEPT statements used for in Transact-SQL?
INTERSECT returns distinct rows from two queries that appear in both result sets, while EXCEPT returns distinct rows from the first query that are not in the second.

## SQL Queries Examples
Here are some SQL query examples for common operations:

### SELECT Query Example
```sql
SELECT first_name, last_name
FROM employees
WHERE department = 'Sales';
```

### JOIN Query Example
```sql
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.id;
```

### INSERT Query Example
```sql
INSERT INTO employees (first_name, last_name, department_id)
VALUES ('John', 'Doe', 2);
```

### UPDATE Query Example
```sql
UPDATE employees
SET department_id = 3
WHERE last_name = 'Doe';
```

### DELETE Query Example
```sql
DELETE FROM employees
WHERE last_name = 'Doe';
```

### Aggregate Query Example
```sql
SELECT COUNT(*) AS employee_count, department_id
FROM employees
GROUP BY department_id;
```

### Subquery Example
```sql
SELECT first_name, last_name
FROM employees
WHERE department_id IN (SELECT id FROM departments WHERE location = 'New York');
``` 

---

This SQL documentation provides a comprehensive overview of essential SQL concepts, statements, and practices, suitable for both beginners and experienced users looking to reinforce their knowledge.
