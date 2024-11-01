
# Database

# Table of Contents

- [What is a "database"?](#what-is-a-database)
- [What is a "database management system"?](#what-is-a-database-management-system)
- [What is a "relational data model"?](#what-is-a-relational-data-model)
- [Define the terms "simple," "composite," "candidate," and "alternate."](##define-the-terms-simple-composite-candidate-and-alternate)
- [What is a "primary key"? What are the criteria for choosing it?](#what-is-a-primary-key-what-are-the-criteria-for-choosing-it)
- [What is a "foreign key"?](#what-is-a-foreign-key)
- [What is "normalization"?](#what-is-normalization)
- [What are the normal forms?](#what-are-the-normal-forms)
- [What is "denormalization"? What is it used for?](#what-is-denormalization-what-is-it-used-for)
- [What are the different types of relationships in a database? Give examples.](#what-are-the-different-types-of-relationships-in-a-database-give-examples)
- [What are "indices"? What are they used for? What are their advantages and disadvantages?](#what-are-indices-what-are-they-used-for-what-are-their-advantages-and-disadvantages)
- [What types of indices are there?](#what-types-of-indices-are-there)
- [What is the difference between clustered and non-clustered indexes?](#what-is-the-difference-between-clustered-and-non-clustered-indexes)
- [Does it make sense to index data that has a small number of possible values?](#does-it-make-sense-to-index-data-that-has-a-small-number-of-possible-values)
- [When is a full dataset scan more cost-effective than index access?](#when-is-a-full-dataset-scan-more-cost-effective-than-index-access)
- [What is a "transaction"?](#what-is-a-transaction)
- [What are the main properties of the transaction?](#what-are-the-main-properties-of-the-transaction)
- [What are the levels of transaction isolation?](#what-are-the-levels-of-transaction-isolation)
- [What are the problems with transactional concurrent access?](#what-are-the-problems-with-transactional-concurrent-access)


## What is a "database"?
A database is a set of information organized and adapted for processing by a computer system.

## What is a "database management system"?
A database management system (DBMS) is a set of general-purpose or special-purpose tools that provide the creation, access to materials, and management of a database.

**The main functions of DBMS:**
- Data management
- Logging of data changes
- Data backup and recovery
- Support for a language for defining and manipulating data.

## What is a "relational data model"?
A relational data model is a logical data model and an applied theory for building relational databases.

A relational data model includes the following components:
- **Structural aspect** – data is a set of relationships.
- **Integrity aspect** - Relationships meet specific integrity conditions: domain (data type) level, relationship level, and database level.
- **Processing (manipulation) aspect** - support for relationship manipulation operators (relational algebra, relational calculus).

Normal form is a property of a relationship in a relational data model that characterizes it in terms of redundancy and is defined as a set of requirements that a relation must satisfy.

## Define the terms "simple," "composite," "candidate," and "alternate."
A simple key consists of a single attribute (field). Composite - of two or more.

A potential key is a simple or composite key that uniquely identifies each record in a data set. At the same time, the potential key must have a non-redundancy criterion: when any of the fields is deleted, the set of fields ceases to uniquely identify the record.

From the set of all potential keys in the data set, the primary key is selected, and all other keys are called alternate keys.

## What is a "primary key"? What are the criteria for choosing it?
In a relational data model, a primary key is one of the potential keys of a relationship, selected as the primary key (the default key).

If there is a single potential key in a relationship, it is also a primary key. If there are multiple potential keys, one of them is chosen as the primary key, and the others are called "alternates."

As the primary key, the one that is most convenient is usually chosen. Therefore, the primary key is usually the one that has the smallest size (of physical storage) and/or includes the fewest attributes. Another criterion for choosing a primary key is to preserve its uniqueness over time.

## What is a "foreign key"?
A foreign key is a subset of the attributes of a relation A whose values must match the values of some potential key of a relation B.

## What is "normalization"?
Normalization is the process of transforming database relationships to a normal-form view (the step-by-step, reversible process of replacing the original schema with another schema in which the datasets have a simpler and more logical structure).

Normalization is designed to bring the database structure to a form that provides minimal logical redundancy, and is not intended to reduce or increase performance, or to decrease or increase the physical size of the database. The ultimate goal of normalization is to reduce the potential inconsistency of the information stored in the database.

## What are the normal forms?
- **First Normal Form (1NF)** - A ratio is in 1NF if the values of all its attributes are atomic (indivisible).
- **Second Normal Form (2NF)** - A relation is in 2NF if it is in 1NF, and all non-key attributes depend only on the key as a whole, not on any part of it.
- **Third Normal Form (3NF)** – A ratio is in 3NF if it is in 2NF and all non-key attributes are independent of each other.
- **Fourth Normal Form (4NF)** - A relation is in 4NF if it is in 3NF and does not contain independent groups of attributes between which there is a many-to-many relationship.
- **Fifth Normal Form (5NF)** - A relationship is in 5NF when each non-trivial dependency of a connection in it is defined by the potential key(s) of that relationship.
- **Sixth Normal Form (6NF)** - A ratio is in 6NF when it satisfies all non-trivial junction dependencies, i.e., when it is irreducible, i.e., cannot be further decomposed without loss. Every ratio variable that is in 6NF is also in 5NF.
- **Boyce-Codd Normal Form (BCNF)** - The relationship is in the BCNF when each of its non-trivial and irreducible functional dependencies on the left has some potential key as its determinant.
- **Domain-Key Normal Form (DKNF)** - A relationship is found in DKNF when each constraint imposed on it is a logical consequence of domain constraints and key constraints imposed on that relationship.

## What is "denormalization"? What is it used for?
Database denormalization is the process of consciously bringing a database to a form where it won't conform to normalization rules. This is usually necessary to improve the performance and speed of data retrieval by increasing data redundancy.

## What are the different types of relationships in a database? Give examples.
- **One-to-one**: Only one value of attribute B corresponds to any value of attribute A, and vice versa.  
  Example: Each university has 1 rector: 1 university → 1 rector.
  
- **One-to-many**: Any value of attribute A corresponds to 0, 1, or more values of attribute B.  
  Example: Each university has several faculties: 1 university → many faculties.
  
- **Many-to-many**: Any value of attribute A corresponds to 0, 1, or more values of attribute B, and any value of attribute B corresponds to 0, 1, or more values of attribute A.  
  Example: 1 professor can teach in several faculties, and several professors can teach in 1 faculty: Several professors ↔ Several faculties.

## What are "indices"? What are they used for? What are their advantages and disadvantages?
An index is a database object that is created to improve data fetching performance.

Datasets can have a large number of records stored in random order, and it can take a long time to find them by looking at the dataset record by record. An index is formed from the values of one or more fields and pointers to the corresponding records in the dataset, thus achieving a significant increase in the speed of sampling from this data.

**Advantages:**
- Speed up search and sorting by a specific field or set of fields.
- Ensuring the uniqueness of data.

**Disadvantages:**
- Requires additional disk and RAM space; the larger/longer the key, the larger the index size.
- Slowing down inserts, updates, and deletions of records because you have to update the indexes themselves.

**Indices are preferable for:**
- Counter fields, to avoid repetition of values.
- Fields by which the data is sorted.
- Fields that frequently join datasets.
- A field declared as a primary key.
- A field in which data is selected from a range.

**The use of indices is impractical for:**
- Fields that are rarely used in queries.
- Fields that contain only two or three values (e.g., male/female).

## What types of indices are there?
- **By sort order**: 
  - Ordered (increasing, decreasing)
  - Unordered
- **By data source**: 
  - Indices by view
  - Indices by expressions
- **By impact on data source**: 
  - Clustered index
  - Non-clustered index
- **By structure**: 
  - B* trees
  - B+ Trees
  - B-trees
  - Hashes
- **By quantitative composition**: 
  - Simple index
  - Composite index
  - Column-enabled index
  - Master index
- **By content characteristics**: 
  - Unique index
  - Dense index
  - Sparse index
  - Spatial index
  - Composite spatial index
  - Full-text index
  - Hash index
  - Bitmap index
  - Reverse index
  - Function-based index
  - Primary index
  - Secondary index
  - XML index
- **By update mechanism**: 
  - Fully rebuildable
  - Replenished (balanced)
- **By Coverage of Indexed Content**: 
  - Fully Covering Index
  - Partial index
  - Incremental index
  - Real-time index
- **Indexes in clustered systems**: 
  - Global index
  - Segment Index
  - Local index

## What is the difference between clustered and non-clustered indexes?
Non-clustered indexes: Data is physically randomly arranged but logically ordered according to the index. This type of index is suitable for a frequently changing dataset.

With clustered indexing, the data is physically ordered, which greatly improves the speed of data retrieval (but only in the case of sequential data access). Only one clustered index can be created for a single dataset.

## Does it make sense to index data that has a small number of possible values?
An approximate rule is that if the amount of information (in bytes) that does NOT satisfy the sampling condition is less than the size of the index (in bytes) for this sampling condition, then optimization will lead to a slowdown in sampling.

## When is a full dataset scan more cost-effective than index access?
A full scan is performed by multi-block reads, while a scan by index is single-block. If the total cost of all required single-block reads is greater than the cost of a full multi-block read, then a full scan is more cost-effective.
