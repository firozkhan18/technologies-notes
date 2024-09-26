Table Of Contents
1 Introduction
2 Getting Started
3 Working with Collections
4 Advanced Querying
5 Data Management
6 Monitoring and Troubleshooting
7 Conclusion

## Introduction
Welcome to the ‘MongoDB Shell Commands: The Complete Cheat Sheet’, an exhaustive guide for both beginners and advanced developers who interact with MongoDB, the popular NoSQL database. Whether you are just getting started, or are looking for a quick reference, this guide aims to provide you with all the commands you need to work with MongoDB effectively.

Before diving in, make sure you have MongoDB installed on your system and that the mongosh command-line tool is available. This tutorial assumes you’re using MongoDB version 4.4 or later.

Please note that many MongoDB Shell commands need to be executed in a specific context such as within a database or a collection. Pay attention to the examples provided to understand where each command should be executed.

## Getting Started
First, let’s look at how you can establish a connection to your MongoDB server through the shell.

mongosh "mongodb://localhost:27017"
This will connect you to a MongoDB instance running locally on the default port 27017.

Once connected, you can show all databases using:

show dbs
To use a specific database:

use database_name
For example, to switch to the ‘test’ database:

use test

Let’s see how to view collections within the current database:

show collections
## Working with Collections
Collections in MongoDB are equivalent to tables in relational databases. They hold the data documents. Below are basic operations you might want to perform on collections.

### To create a new collection:

db.createCollection("myNewCollection")
To remove an existing collection:

db.myNewCollection.drop()
To insert a new document into a collection:

db.myCollection.insertOne({name: 'Alice', age: 30})
If you want to insert multiple documents:

db.myCollection.insertMany([{name: 'Bob', age: 25}, {name: 'Charlie', age: 35}])
To find documents within a collection:

db.myCollection.find()
You can provide query filters to locate specific documents:

db.myCollection.find({name: 'Alice'})
For updating documents, you will use:

db.myCollection.updateOne({name: 'Alice'}, {$set:{age: 31}})
To update multiple documents:

db.myCollection.updateMany({}, {$set: {status: 'active'}})
To delete a document:

db.myCollection.deleteOne({name: 'Alice'})
Similarly, to delete multiple documents:

db.myCollection.deleteMany({status: 'inactive'})
## Advanced Querying
Beyond simple CRUD (Create, Read, Update, and Delete) operations, MongoDB provides a powerful querying language.

### To sort fetched documents:

db.myCollection.find().sort({age: 1}) // Sorts by age, ascending
To limit the number of documents to return:

db.myCollection.find().limit(5)
To skip a certain number of documents in the result set:

db.myCollection.find().skip(10)
And to chain these operations:

db.myCollection.find().sort({age: -1}).limit(5).skip(10)
With indexing, you can improve the performance of queries. To create an index:

db.myCollection.createIndex({age: 1}) // Index on age, ascending
Aggregation is another powerful feature:

db.myCollection.aggregate([{$match: {status: 'active'}}, {$group: {_id: 'averageAge', averageAge: {$avg: 'age'}}}])

## Data Management
Occasionally, you’ll want to perform administrative tasks in the shell.

### To backup data using the mongodump tool:

mongodump --db database_name --out /path/to/folder
Correspondingly, to restore data with mongorestore:

mongorestore /path/to/folder
Users can be managed through the shell:

db.createUser({user: 'myUser', pwd: 'passwordHere', roles: ['readWrite']})
To change user password:

db.changeUserPassword('myUser', 'newPasswordHere')
## Monitoring and Troubleshooting

Useful commands for monitoring include gaining insights into the current operations:

db.currentOp()
To check on server status and health:

db.serverStatus()
To view the most recent entries in the log:

db.adminCommand({getLog: 'global'})
