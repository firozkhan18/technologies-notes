What is MongoDB?
 MongoDB is a free and open-source cross-platform  document-oriented database. Classified as a  NoSQL  database, MongoDB avoids the traditional table-based relational database structure in favor of JSON-like documents with dynamic schemas, making the integration of data in certain types of applications easier and faster.

The best way we learn anything is by practice and exercise questions. We have started this section for those (beginner to intermediate) who are familiar with NoSQL and MongoDB. Hope, these exercises help you to improve your MongoDB query skills. Currently, following exercises are available based on collection :

restaurants collection [ 87 Exercises]
listingAndReviews collection [ 50 Exercises]
Movies collection [ 28 Exercises]
MongoDB Query Exercises and Solution [ 87 Exercises]
Structure of 'restaurants' collection:

```json
{
  "address": {
     "building": "1007",
     "coord": [ -73.856077, 40.848447 ],
     "street": "Morris Park Ave",
     "zipcode": "10462"
  },
  "borough": "Bronx",
  "cuisine": "Bakery",
  "grades": [
     { "date": { "$date": 1393804800000 }, "grade": "A", "score": 2 },
     { "date": { "$date": 1378857600000 }, "grade": "A", "score": 6 },
     { "date": { "$date": 1358985600000 }, "grade": "A", "score": 10 },
     { "date": { "$date": 1322006400000 }, "grade": "A", "score": 9 },
     { "date": { "$date": 1299715200000 }, "grade": "B", "score": 14 }
  ],
  "name": "Morris Park Bake Shop",
  "restaurant_id": "30075445"
}
```
You may download the compressed file and uncompress it to find the collection used in our exercises. The collection comprises of 3772 documents.

https://www.mongodb.com/docs/atlas/sample-data/sample-restaurants/

Sure! Here are the MongoDB queries formatted with `<details>` tags:

<details><summary><b>1. Write a MongoDB query to display all the documents in the collection restaurants.</b></summary>
 
```javascript
db.restaurants.find({})
```
</details>

<details><summary><b>2. Write a MongoDB query to display the fields restaurant_id, name, borough, and cuisine for all the documents in the collection restaurant.</b></summary>
 
```javascript
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>3. Write a MongoDB query to display the fields restaurant_id, name, borough, and cuisine, but exclude the field _id for all the documents in the collection restaurant.</b></summary>
 
```javascript
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1, _id: 0 })
```
</details>

<details><summary><b>4. Write a MongoDB query to display the fields restaurant_id, name, borough, and zip code, but exclude the field _id for all the documents in the collection restaurant.</b></summary>
 
```javascript
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, zip_code: 1, _id: 0 })
```
</details>

<details><summary><b>5. Write a MongoDB query to display all the restaurants which are in the borough Bronx.</b></summary>
 
```javascript
db.restaurants.find({ borough: "Bronx" })
```
</details>

<details><summary><b>6. Write a MongoDB query to display the first 5 restaurants which are in the borough Bronx.</b></summary>
 
```javascript
db.restaurants.find({ borough: "Bronx" }).limit(5)
```
</details>

<details><summary><b>7. Write a MongoDB query to display the next 5 restaurants after skipping the first 5 which are in the borough Bronx.</b></summary>
 
```javascript
db.restaurants.find({ borough: "Bronx" }).skip(5).limit(5)
```
</details>

<details><summary><b>8. Write a MongoDB query to find the restaurants who achieved a score more than 90.</b></summary>
 
```javascript
db.restaurants.find({ "grades.score": { $gt: 90 } })
```
</details>

<details><summary><b>9. Write a MongoDB query to find the restaurants that achieved a score, more than 80 but less than 100.</b></summary>
 
```javascript
db.restaurants.find({ "grades.score": { $gt: 80, $lt: 100 } })
```
</details>

<details><summary><b>10. Write a MongoDB query to find the restaurants which locate in latitude value less than -95.754168.</b></summary>
 
```javascript
db.restaurants.find({ "address.coord.0": { $lt: -95.754168 } })
```
</details>

<details><summary><b>11. Write a MongoDB query to find the restaurants that do not prepare any cuisine of 'American' and their grade score more than 70 and latitude less than -65.754168.</b></summary>
 
```javascript
db.restaurants.find({
    cuisine: { $ne: "American" },
    "grades.score": { $gt: 70 },
    "address.coord.0": { $lt: -65.754168 }
})
```
</details>

<details><summary><b>12. Write a MongoDB query to find the restaurants which do not prepare any cuisine of 'American' and achieved a score more than 70 and located in the longitude less than -65.754168. Note: Do this query without using $and operator.</b></summary>
 
```javascript
db.restaurants.find({
    cuisine: { $ne: "American" },
    "grades.score": { $gt: 70 },
    "address.coord.1": { $lt: -65.754168 }
})
```
</details>

<details><summary><b>13. Write a MongoDB query to find the restaurants which do not prepare any cuisine of 'American' and achieved a grade point 'A' not belongs to the borough Brooklyn. The document must be displayed according to the cuisine in descending order.</b></summary>
 
```javascript
db.restaurants.find({
    cuisine: { $ne: "American" },
    "grades.grade": "A",
    borough: { $ne: "Brooklyn" }
}).sort({ cuisine: -1 })
```
</details>

<details><summary><b>14. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'Wil' as first three letters for its name.</b></summary>
 
```javascript
db.restaurants.find({ name: /^Wil/ }, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>15. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'ces' as last three letters for its name.</b></summary>
 
```javascript
db.restaurants.find({ name: /ces$/ }, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>16. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'Reg' as three letters somewhere in its name.</b></summary>
 
```javascript
db.restaurants.find({ name: /Reg/ }, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>17. Write a MongoDB query to find the restaurants which belong to the borough Bronx and prepared either American or Chinese dish.</b></summary>
 
```javascript
db.restaurants.find({
    borough: "Bronx",
    cuisine: { $in: ["American", "Chinese"] }
})
```
</details>

<details><summary><b>18. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which belong to the borough Staten Island or Queens or Bronx or Brooklyn.</b></summary>
 
```javascript
db.restaurants.find({
    borough: { $in: ["Staten Island", "Queens", "Bronx", "Brooklyn"] }
}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>19. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which are not belonging to the borough Staten Island or Queens or Bronx or Brooklyn.</b></summary>
 
```javascript
db.restaurants.find({
    borough: { $nin: ["Staten Island", "Queens", "Bronx", "Brooklyn"] }
}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>20. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which achieved a score which is not more than 10.</b></summary>
 
```javascript
db.restaurants.find({
    "grades.score": { $lte: 10 }
}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>21. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which prepared dish except 'American' and 'Chinese' or restaurant's name begins with letter 'Wil'.</b></summary>
 
```javascript
db.restaurants.find({
    $or: [
        { cuisine: { $nin: ["American", "Chinese"] } },
        { name: /^Wil/ }
    ]
}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
```
</details>

<details><summary><b>22. Write a MongoDB query to find the restaurant Id, name, and grades for those restaurants which achieved a grade of "A" and scored 11 on an ISODate "2014-08-11T00:00:00Z" among many of survey dates.</b></summary>
 
```javascript
db.restaurants.find({
    "grades.grade": "A",
    "grades.score": 11,
    "grades.date": new Date("2014-08-11T00:00:00Z")
}, { restaurant_id: 1, name: 1, grades: 1 })
```
</details>

<details><summary><b>23. Write a MongoDB query to find the restaurant Id, name and grades for those restaurants where the 2nd element of grades array contains a grade of "A" and score 9 on an ISODate "2014-08-11T00:00:00Z".</b></summary>
 
```javascript
db.restaurants.find({
    "grades.1.grade": "A",
    "grades.1.score": 9,
    "grades.1.date": new Date("2014-08-11T00:00:00Z")
}, { restaurant_id: 1, name: 1, grades: 1 })
```
</details>

<details><summary><b>24. Write a MongoDB query to find the restaurant Id, name, address and geographical location for those restaurants where the 2nd element of coord array contains a value which is more than 42 and up to 52.</b></summary>

```javascript
db.restaurants.find({
    "address.coord.1": { $gt: 42, $lte: 52 }
}, { restaurant_id: 1, name: 1, address: 1, "address.coord": 1 })
```
</details>

<details><summary><b>25. Write a MongoDB query to arrange the name of the restaurants in ascending order along with all the columns.</b></summary>
 
```javascript
db.restaurants.find({}).sort({ name: 1 })
```
</details>

<details><summary><b>26. Write a MongoDB query to arrange the name of the restaurants in descending order along with all the columns.</b></summary>
 
```javascript
db.restaurants.find({}).sort({ name: -1 })
```
</details>

<details><summary><b>27. Write a MongoDB query to arrange the name of the cuisine in ascending order and for that same cuisine borough should be in descending order.</b></summary>
 
```javascript
db.restaurants.find({}).sort({ cuisine: 1, borough: -1 })
```
</details>

<details><summary><b>28. Write a MongoDB query to know whether all the addresses contain the street or not.</b></summary>
 
```javascript
db.restaurants.find({ "address.street": { $exists: true } })
```
</details>
<details><summary><b>29. Select all documents in the restaurants collection where the coord field value is of type Double.</b></summary>
 
```javascript
db.restaurants.find({
  "coord": { $type: "double" }
})
```
</details>

<details><summary><b>30. Select the restaurant Id, name, and grades for those restaurants where the score returns 0 as a remainder after dividing by 7.</b></summary>
 
```javascript
db.restaurants.find(
  { "grades.score": { $mod: [7, 0] } },
  { "restaurant_id": 1, "name": 1, "grades": 1, _id: 0 }
)
```
</details>

<details><summary><b>31. Find the restaurant name, borough, longitude, latitude, and cuisine for those restaurants which contain 'mon' as three letters somewhere in its name.</b></summary>
 
```javascript
db.restaurants.find(
  { "name": /mon/ },
  { "name": 1, "borough": 1, "address.coord": 1, "cuisine": 1, _id: 0 }
)
```
</details>

<details><summary><b>32. Find the restaurant name, borough, longitude, latitude, and cuisine for those restaurants which contain 'Mad' as the first three letters of its name.</b></summary>
 
```javascript
db.restaurants.find(
  { "name": /^Mad/ },
  { "name": 1, "borough": 1, "address.coord": 1, "cuisine": 1, _id: 0 }
)
```
</details>

<details><summary><b>33. Find the restaurants that have at least one grade with a score of less than 5.</b></summary>
 
```javascript
db.restaurants.find(
  { "grades.score": { $lt: 5 } }
)
```
</details>

<details><summary><b>34. Find the restaurants that have at least one grade with a score of less than 5 and that are located in the borough of Manhattan.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades.score": { $lt: 5 },
    "borough": "Manhattan"
  }
)
```
</details>

<details><summary><b>35. Find the restaurants that have at least one grade with a score of less than 5 and that are located in the borough of Manhattan or Brooklyn.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades.score": { $lt: 5 },
    "borough": { $in: ["Manhattan", "Brooklyn"] }
  }
)
```
</details>

<details><summary><b>36. Find the restaurants that have at least one grade with a score of less than 5, located in the borough of Manhattan or Brooklyn, and their cuisine is not American.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades.score": { $lt: 5 },
    "borough": { $in: ["Manhattan", "Brooklyn"] },
    "cuisine": { $ne: "American" }
  }
)
```
</details>

<details><summary><b>37. Find the restaurants that have at least one grade with a score of less than 5, located in the borough of Manhattan or Brooklyn, and their cuisine is not American or Chinese.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades.score": { $lt: 5 },
    "borough": { $in: ["Manhattan", "Brooklyn"] },
    "cuisine": { $nin: ["American", "Chinese"] }
  }
)
```
</details>

<details><summary><b>38. Find the restaurants that have a grade with a score of 2 and a grade with a score of 6.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $all: [
        { $elemMatch: { "score": 2 } },
        { $elemMatch: { "score": 6 } }
      ]
    }
  }
)
```
</details>

<details><summary><b>39. Find the restaurants that have a grade with a score of 2 and a grade with a score of 6 and are located in the borough of Manhattan.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $all: [
        { $elemMatch: { "score": 2 } },
        { $elemMatch: { "score": 6 } }
      ]
    },
    "borough": "Manhattan"
  }
)
```
</details>

<details><summary><b>40. Find the restaurants that have a grade with a score of 2 and a grade with a score of 6 and are located in the borough of Manhattan or Brooklyn.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $all: [
        { $elemMatch: { "score": 2 } },
        { $elemMatch: { "score": 6 } }
      ]
    },
    "borough": { $in: ["Manhattan", "Brooklyn"] }
  }
)
```
</details>

<details><summary><b>41. Find the restaurants that have a grade with a score of 2 and a grade with a score of 6 and are located in the borough of Manhattan or Brooklyn, and their cuisine is not American.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $all: [
        { $elemMatch: { "score": 2 } },
        { $elemMatch: { "score": 6 } }
      ]
    },
    "borough": { $in: ["Manhattan", "Brooklyn"] },
    "cuisine": { $ne: "American" }
  }
)
```
</details>

<details><summary><b>42. Find the restaurants that have a grade with a score of 2 and a grade with a score of 6 and are located in the borough of Manhattan or Brooklyn, and their cuisine is not American or Chinese.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $all: [
        { $elemMatch: { "score": 2 } },
        { $elemMatch: { "score": 6 } }
      ]
    },
    "borough": { $in: ["Manhattan", "Brooklyn"] },
    "cuisine": { $nin: ["American", "Chinese"] }
  }
)
```
</details>

<details><summary><b>43. Find the restaurants that have a grade with a score of 2 or a grade with a score of 6.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "score": { $in: [2, 6] } }
    }
  }
)
```
</details>

<details><summary><b>44. Find the restaurants that have a grade with a score of 2 or a grade with a score of 6 and are located in the borough of Manhattan.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "score": { $in: [2, 6] } }
    },
    "borough": "Manhattan"
  }
)
```
</details>

<details><summary><b>45. Find the restaurants that have a grade with a score of 2 or a grade with a score of 6 and are located in the borough of Manhattan or Brooklyn.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "score": { $in: [2, 6] } }
    },
    "borough": { $in: ["Manhattan", "Brooklyn"] }
  }
)
```
</details>

<details><summary><b>46. Find the restaurants that have a grade with a score of 2 or a grade with a score of 6, are located in the borough of Manhattan or Brooklyn, and their cuisine is not American.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "score": { $in: [2, 6] } }
    },
    "borough": { $in: ["Manhattan", "Brooklyn"] },
    "cuisine": { $ne: "American" }
  }
)
```
</details>

<details><summary><b>47. Find the restaurants that have a grade with a score of 2 or a grade with a score of 6, are located in the borough of Manhattan or Brooklyn, and their cuisine is not American or Chinese.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "score": { $in: [2, 6] } }
    },
    "borough": { $in: ["Manhattan", "Brooklyn"] },
    "cuisine": { $nin: ["American", "Chinese"] }
  }
)
```
</details>

<details><summary><b>48. Find the restaurants that have all grades with a score greater than 5.</b></summary>
 
```javascript
db.restaurants.find(
 { 
    "grades": { 
      $not: { $elemMatch: { "score": { $lte: 5 } } }
    }
  }
)
```
</details>

<details><summary><b>49. Find the restaurants that have all grades with a score greater than 5 and are located in the borough of Manhattan.</b></summary>

```javascript
db.restaurants.find(
  { 
    "grades": { 
      $not: { $elemMatch: { "score": { $lte: 5 } } }
    },
    "borough": "Manhattan"
  }
)
```
</details>

<details><summary><b>50. Find the restaurants that have all grades with a score greater than 5 and are located in the borough of Manhattan or Brooklyn.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $not: { $elemMatch: { "score": { $lte: 5 } } }
    },
    "borough": { $in: ["Manhattan", "Brooklyn"] }
  }
)
```
</details>

<details><summary><b>51. Find the average score for each restaurant.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$restaurant_id", avgScore: { $avg: "$grades.score" } } }
])
```
</details>

<details><summary><b>52. Find the highest score for each restaurant.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$restaurant_id", highestScore: { $max: "$grades.score" } } }
])
```
</details>

<details><summary><b>53. Find the lowest score for each restaurant.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$restaurant_id", lowestScore: { $min: "$grades.score" } } }
])
```
</details>

<details><summary><b>54. Find the count of restaurants in each borough.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $group: { _id: "$borough", count: { $sum: 1 } } }
])
```
</details>

<details><summary><b>55. Find the count of restaurants for each cuisine.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $group: { _id: "$cuisine", count: { $sum: 1 } } }
])
```
</details>

<details><summary><b>56. Find the count of restaurants for each cuisine and borough.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $group: { _id: { cuisine: "$cuisine", borough: "$borough" }, count: { $sum: 1 } } }
])
```
</details>

<details><summary><b>57. Find the count of restaurants that received a grade of 'A' for each cuisine.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "A" } },
  { $group: { _id: "$cuisine", count: { $sum: 1 } } }
])
```
</details>

<details><summary><b>58. Find the count of restaurants that received a grade of 'A' for each borough.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "A" } },
  { $group: { _id: "$borough", count: { $sum: 1 } } }
])
```
</details>
<details><summary><b>59. Write a MongoDB query to find the count of restaurants that received a grade of 'A' for each cuisine and borough.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "A" } },
  { $group: { _id: { cuisine: "$cuisine", borough: "$borough" }, count: { $sum: 1 } } }
])
```
</details>
<details><summary><b>60. Write a MongoDB query to find the number of restaurants that have been graded in each month of the year.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $project: { month: { $month: "$grades.date" } } },
  { $group: { _id: "$month", count: { $sum: 1 } } }
])
```
</details>
<details><summary><b>61. Write a MongoDB query to find the average score for each cuisine.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$cuisine", avgScore: { $avg: "$grades.score" } } }
])
```
</details>
<details><summary><b>62. Write a MongoDB query to find the highest score for each cuisine.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$cuisine", highestScore: { $max: "$grades.score" } } }
])
```
</details>
<details><summary><b>63. Write a MongoDB query to find the lowest score for each cuisine.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$cuisine", lowestScore: { $min: "$grades.score" } } }
])
```
</details>
<details><summary><b>64. Write a MongoDB query to find the average score for each borough.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$borough", avgScore: { $avg: "$grades.score" } } }
])
```
</details>
<details><summary><b>65. Write a MongoDB query to find the highest score for each borough.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$borough", highestScore: { $max: "$grades.score" } } }
])
```
</details>
<details><summary><b>66. Write a MongoDB query to find the lowest score for each borough.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$borough", lowestScore: { $min: "$grades.score" } } }
])
```
</details>
<details><summary><b>67. Write a MongoDB query to find the name and address of the restaurants that received a grade of 'A' on a specific date.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades.grade": "A",
    "grades.date": new Date("specific_date_here")
  },
  { "name": 1, "address": 1, _id: 0 }
)
```
</details>
<details><summary><b>68. Write a MongoDB query to find the name and address of the restaurants that received a grade of 'B' or 'C' on a specific date.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades.grade": { $in: ["B", "C"] },
    "grades.date": new Date("specific_date_here")
  },
  { "name": 1, "address": 1, _id: 0 }
)
```
</details>
<details><summary><b>69. Write a MongoDB query to find the name and address of the restaurants that have at least one 'A' grade and one 'B' grade.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $all: [
        { $elemMatch: { "grade": "A" } },
        { $elemMatch: { "grade": "B" } }
      ]
    }
  },
  { "name": 1, "address": 1, _id: 0 }
)
```
</details>
<details><summary><b>70. Write a MongoDB query to find the name and address of the restaurants that have at least one 'A' grade and no 'B' grades.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "grade": "A" },
      $not: { $elemMatch: { "grade": "B" } }
    }
  },
  { "name": 1, "address": 1, _id: 0 }
)
```
</details>
<details><summary><b>71. Write a MongoDB query to find the name, address, and grades of the restaurants that have at least one 'A' grade and no 'C' grades.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "grade": "A" },
      $not: { $elemMatch: { "grade": "C" } }
    }
  },
  { "name": 1, "address": 1, "grades": 1, _id: 0 }
)
```
</details>
<details><summary><b>72. Write a MongoDB query to find the name, address, and grades of the restaurants that have at least one 'A' grade, no 'B' grades, and no 'C' grades.</b></summary>
 
```javascript
db.restaurants.find(
  { 
    "grades": { 
      $elemMatch: { "grade": "A" },
      $not: { $elemMatch: { "grade": { $in: ["B", "C"] } } }
    }
  },
  { "name": 1, "address": 1, "grades": 1, _id: 0 }
)
```
</details>
<details><summary><b>73. Write a MongoDB query to find the name and address of the restaurants that have the word 'coffee' in their name.</b></summary>
 
```javascript
db.restaurants.find(
  { "name": /coffee/i },
  { "name": 1, "address": 1, _id: 0 }
)
```
</details>
<details><summary><b>74. Write a MongoDB query to find the name and address of the restaurants that have a zipcode that starts with '10'.</b></summary>
 
```javascript
db.restaurants.find(
  { "address.zipcode": /^10/ },
  { "name": 1, "address": 1, _id: 0 }
)
```
</details>
<details><summary><b>75. Write a MongoDB query to find the name and address of the restaurants that have a cuisine that starts with the letter 'B'.</b></summary>
 
```javascript
db.restaurants.find(
  { "cuisine": /^B/ },
  { "name": 1, "address": 1, _id: 0 }
)
```
</details>
<details><summary><b>76. Write a MongoDB query to find the name, address, and cuisine of the restaurants that have a cuisine that ends with the letter 'y'.</b></summary>
 
```javascript
db.restaurants.find(
  { "cuisine": /y$/ },
  { "name": 1, "address": 1, "cuisine": 1, _id: 0 }
)
```
</details>
<details><summary><b>77. Write a MongoDB query to find the name, address, and cuisine of the restaurants that have a cuisine that contains the word 'Pizza'.</b></summary>
 
```javascript
db.restaurants.find(
  { "cuisine": /Pizza/i },
  { "name": 1, "address": 1, "cuisine": 1, _id: 0 }
)
```
</details>
<details><summary><b>78. Write a MongoDB query to find the restaurants that achieved the highest average score.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$restaurant_id", avgScore: { $avg: "$grades.score" } } },
  { $sort: { avgScore: -1 } },
  { $limit: 1 }
])
```
</details>
<details><summary><b>79. Write a MongoDB query to find all the restaurants with the highest number of "A" grades.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "A" } },
  { $group: { _id: "$restaurant_id", aCount: { $sum: 1 } } },
  { $sort: { aCount: -1 } },
  { $limit: 1 }
])
```
</details>
<details><summary><b>80. Write a MongoDB query to find the cuisine type that is most likely to receive a "C" grade.</b></summary>
 
```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "C" } },
  { $group: { _id: "$cuisine", cCount: { $sum: 1 } } },
  { $sort: { cCount: -1 } },
  { $limit: 1 }
])
```
</details>
<details><summary><b>81. Write a MongoDB query to find the restaurant that has the highest average score for the cuisine "Turkish".</b></summary>

```javascript
db.restaurants.aggregate([
  { $match: { "cuisine": "Turkish" } },
  { $unwind: "$grades" },
  { $group: { _id: "$restaurant_id", avgScore: { $avg: "$grades.score" } } },
  { $sort: { avgScore: -1 } },
  { $limit: 1 }
])
```
</details>
<details><summary><b>82. Write a MongoDB query to find the restaurants that achieved the highest total score.</b></summary>

```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: "$restaurant_id", totalScore: { $sum: "$grades.score" } } },
  { $sort: { totalScore: -1 } },
  { $limit: 1 }
])
```
</details>
<details><summary><b>83. Write a MongoDB query to find all the Chinese restaurants in Brooklyn.</b></summary>

```javascript
db.restaurants.find(
  { 
    "cuisine": "Chinese",
    "borough": "Brooklyn"
  }
)
```
</details>
<details><summary><b>84. Write a MongoDB query to find the restaurant with the most recent grade date.</b></summary>

```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $sort: { "grades.date": -1 } },
  { $group: { _id: "$restaurant_id", mostRecentDate: { $first: "$grades.date" } } },
  { $sort: { mostRecentDate: -1 } },
  { $limit: 1 }
])
```
</details>
<details><summary><b>85. Write a MongoDB query to find the top 5 restaurants with the highest average score for each cuisine type, along with their average scores.</b></summary>

```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $group: { _id: { cuisine: "$cuisine", restaurant_id: "$restaurant_id" }, avgScore: { $avg: "$grades.score" } } },
  { $sort: { "_id.cuisine": 1, avgScore: -1 } },
  { $group: { _id: "$_id.cuisine", topRestaurants: { $push: { restaurant_id: "$_id.restaurant_id", avgScore: "$avgScore" } } } },
  { $project: { topRestaurants: { $slice: ["$topRestaurants", 5] } } }
])
```
</details>
<details><summary><b>86. Write a MongoDB query to find the top 5 restaurants in each borough with the highest number of "A" grades.</b></summary>

```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "A" } },
  { $group: { _id: { borough: "$borough", restaurant_id: "$restaurant_id" }, aCount: { $sum: 1 } } },
  { $sort: { "_id.borough": 1, aCount: -1 } },
  { $group: { _id: "$_id.borough", topRestaurants: { $push: { restaurant_id: "$_id.restaurant_id", aCount: "$aCount" } } } },
  { $project: { topRestaurants: { $slice: ["$topRestaurants", 5] } } }
])
```
</details>
<details><summary><b>87. Write a MongoDB query to find the borough with the highest number of restaurants that have a grade of "A" and a score greater than or equal to 90.</b></summary>

```javascript
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "A", "grades.score": { $gte: 90 } } },
  { $group: { _id: "$borough", count: { $sum: 1 } } },
  { $sort: { count: -1 } },
  { $limit: 1 }
])
```
</details>

MongoDB Exercises: listingsAndReviews collection
Last update on May 29 2023 20:36:23 (UTC/GMT +8 hours)

MongoDB Query Exercises and Solution : listingsAndReviews collection - 50 Exercises

Sample document of 'listingsAndReviews' collection:

```javascript
  {
    _id: '10059872',
    listing_url: 'https://www.airbnb.com/rooms/10059872',
    name: 'Soho Cozy, Spacious and Convenient',
    summary: 'Clean, fully furnish, Spacious 1 bedroom flat just off the escalator in Mid Levels. 2 minutes From Soho Bar and Restaurants. Located in a quiet alley 1 minute from Sun Yat Sen',
    space: '',
    description: 'Clean, fully furnish, Spacious 1 bedroom flat just off the escalator in Mid Levels. 2 minutes From Soho Bar and Restaurants. Located in a quiet alley 1 minute from Sun Yat Sen',
    neighborhood_overview: '',
    notes: '',
    transit: '',
    access: '',
    interaction: '',
    house_rules: '',
    property_type: 'Apartment',
    room_type: 'Entire home/apt',
    bed_type: 'Real Bed',
    minimum_nights: '4',
    maximum_nights: '20',
    cancellation_policy: 'flexible',
    last_scraped: ISODate("2019-03-11T04:00:00.000Z"),
    calendar_last_scraped: ISODate("2019-03-11T04:00:00.000Z"),
    first_review: ISODate("2015-12-19T05:00:00.000Z"),
    last_review: ISODate("2018-03-27T04:00:00.000Z"),
    accommodates: 3,
    bedrooms: 1,
    beds: 2,
    number_of_reviews: 3,
    bathrooms: Decimal128("1.0"),
    amenities: [
      'Air conditioning',
      'Kitchen',
      'Smoking allowed',
      'Doorman',
      'Elevator',
      'Heating',
      'Family/kid friendly',
      'Essentials',
      '24-hour check-in',
      'translation missing: en.hosting_amenity_50'
    ],
    price: Decimal128("699.00"),
    weekly_price: Decimal128("5000.00"),
    extra_people: Decimal128("0.00"),
    guests_included: Decimal128("1"),
    images: {
      thumbnail_url: '',
      medium_url: '',
      picture_url: 'https://a0.muscache.com/im/pictures/4533a1dc-6fd8-4167-938d-391c6eebbc19.jpg?aki_policy=large',
      xl_picture_url: ''
    },
    host: {
      host_id: '51624384',
      host_url: 'https://www.airbnb.com/users/show/51624384',
      host_name: 'Giovanni',
      host_location: 'Hong Kong, Hong Kong',
      host_about: '',
      host_thumbnail_url: 'https://a0.muscache.com/im/pictures/264b82a7-756f-4da8-b607-dc9759e2a10f.jpg?aki_policy=profile_small',
      host_picture_url: 'https://a0.muscache.com/im/pictures/264b82a7-756f-4da8-b607-dc9759e2a10f.jpg?aki_policy=profile_x_medium',
      host_neighbourhood: 'Soho',
      host_is_superhost: false,
      host_has_profile_pic: true,
      host_identity_verified: false,
      host_listings_count: 1,
      host_total_listings_count: 1,
      host_verifications: [ 'email', 'phone', 'reviews', 'jumio', 'government_id' ]
    },
    address: {
      street: 'Hong Kong, Hong Kong Island, Hong Kong',
      suburb: 'Central & Western District',
      government_area: 'Central & Western',
      market: 'Hong Kong',
      country: 'Hong Kong',
      country_code: 'HK',
      location: {
        type: 'Point',
        coordinates: [ 114.15027, 22.28158 ],
        is_location_exact: true
      }
    },
    availability: {
      availability_30: 0,
      availability_60: 0,
      availability_90: 0,
      availability_365: 0
    },
    review_scores: {
      review_scores_accuracy: 10,
      review_scores_cleanliness: 10,
      review_scores_checkin: 10,
      review_scores_communication: 10,
      review_scores_location: 10,
      review_scores_value: 8,
      review_scores_rating: 100
    },
    reviews: [
      {
        _id: '56904633',
        date: ISODate("2015-12-19T05:00:00.000Z"),
        listing_id: '10059872',
        reviewer_id: '5302612',
        reviewer_name: 'Octavio',
        comments: 'The host canceled this reservation 11 days before arrival. This is an automated posting.'
      },
      {
        _id: '223175530',
        date: ISODate("2018-01-01T05:00:00.000Z"),
        listing_id: '10059872',
        reviewer_id: '48436743',
        reviewer_name: 'Ross',
        comments: 'Giovanni was very helpful and responsive to my questions. This is a great apartment that is very convenient for exploring Hong Kong.'
      },
      {
        _id: '247251577',
        date: ISODate("2018-03-27T04:00:00.000Z"),
        listing_id: '10059872',
        reviewer_id: '111288273',
        reviewer_name: 'Christian',
        comments: 'The host canceled this reservation 8 days before arrival. This is an automated posting.'
      }
    ]
  },
```

You may download the compressed file and uncompress it to find the collection used in our exercises. The collection comprises of 2000 documents.
<details><summary><b>1. Find the price per night of the first record in the listingsAndReviews collection.</b></summary> 
 
```javascript 
db.listingsAndReviews.findOne({}, { "price": 1, _id: 0 }).price
``` 

</details> <details><summary><b>2. Retrieve the cleaning fee of the first record in the listingsAndReviews collection.</b></summary> 
  
```javascript 
db.listingsAndReviews.findOne({}, { "cleaning_fee": 1, _id: 0 }).cleaning_fee
``` 
</details> <details><summary><b>3. Find the host_name, host_location, and host_about of the first record in the listingsAndReviews collection.</b></summary>
  
```javascript 
db.listingsAndReviews.findOne({}, { "host.host_name": 1, "host.host_location": 1, "host.host_about": 1, _id: 0 })
``` 
</details> <details><summary><b>4. Retrieve the number of bedrooms in the first record in the listingsAndReviews collection.</b></summary> 
   
```javascript 
db.listingsAndReviews.findOne({}, { "bedrooms": 1, _id: 0 }).bedrooms
``` 
</details> <details><summary><b>5. Retrieve the number of guests included in the first record in the listingsAndReviews collection.</b></summary> 
    
 ```javascript 
 db.listingsAndReviews.findOne({}, { "guests_included": 1, _id: 0 }).guests_included
``` 
</details> <details><summary><b>6. Write a MongoDB query to check whether the host has a profile picture in the first record in the listingsAndReviews collection.</b></summary> 
    
```javascript
db.listingsAndReviews.findOne({}, { "host.host_picture_url": 1, _id: 0 }).host.host_picture_url !== undefined 
``` 
</details> 
<details><summary><b>7. Write a MongoDB query to check whether the host's identity has been verified in the first record in the listingsAndReviews collection.</b></summary> 
    
```javascript
db.listingsAndReviews.findOne({}, { "host.host_verifications": 1, _id: 0 }).host.host_verifications && db.listingsAndReviews.findOne({}, { "host.host_verifications": 1, _id: 0 }).host.host_verifications.length > 0 
``` 
</details> 
<details><summary><b>8. Write a MongoDB query to find how many listings the host has in the first record in the listingsAndReviews collection.</b></summary> 
 
```javascript 
db.listingsAndReviews.findOne({}, { "host.host_total_listings_count": 1, _id: 0 }).host.host_total_listings_count
``` 
</details> 
<details><summary><b>9. Write a MongoDB query to find the street address of the first record in the listingsAndReviews collection.</b></summary> 
  
```javascript 
db.listingsAndReviews.findOne({}, { "address.street": 1, _id: 0 }).address.street
``` 
</details> 
<details><summary><b>10. Find all the listings in the listingsAndReviews collection where the property_type field is set to "House".</b></summary> 
 
 ```javascript 
 db.listingsAndReviews.find({ "property_type": "House" })
``` 
</details> 
<details><summary><b>11. Find all the listings in the listingsAndReviews collection with listing_url, name, host_name, host_location, reviewer_name, and price that have a nightly price greater than $500.</b></summary> 
   
```javascript 
db.listingsAndReviews.find( { "price": { $gt: 500 } }, { "listing_url": 1, "name": 1, "host.host_name": 1, "host.host_location": 1, "reviews.reviewer_name": 1, "price": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>12. Find all the listings in the listingsAndReviews collection that are located in Brazil and have a review score rating of at least 9. Return name, address, and review_scores_rating.</b></summary> 
    
 ```javascript 
 db.listingsAndReviews.find( { "address.country": "Brazil", "review_scores.review_scores_rating": { $gte: 9 } }, { "name": 1, "address": 1, "review_scores.review_scores_rating": 1, _id: 0 } )
```
</details> 
<details><summary><b>13. Find all the listings with name, address, reviewer_name, and review_scores_rating in the listingsAndReviews collection that have a "hot tub" amenity and are located in the United States.</b></summary> 
    
 ```javascript 
 db.listingsAndReviews.find( { "address.country": "United States", "amenities": "hot tub" }, { "name": 1, "address": 1, "reviews.reviewer_name": 1, "review_scores.review_scores_rating": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>14. Find all the listings with name, amenities, and price in the listingsAndReviews collection that have a "pool" amenity and a nightly price between $200 and $400.</b></summary> 
    
```javascript
db.listingsAndReviews.find( { "amenities": "pool", "price": { $gte: 200, $lte: 400 } }, { "name": 1, "amenities": 1, "price": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>15. Find all the listings with name, amenities, and address in the listingsAndReviews collection that have a "Washer" amenity and are located in either Canada or Mexico.</b></summary> 
    
```javascript 
db.listingsAndReviews.find( { "amenities": "Washer", "address.country": { $in: ["Canada", "Mexico"] } }, { "name": 1, "amenities": 1, "address": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>16. Find the top 10 most reviewed listings with listing_url, name, country, review_scores in the listingsAndReviews collection.</b></summary> 
    
```javascript 
db.listingsAndReviews.aggregate([ { $unwind: "$reviews" }, { $group: { _id: "$listing_url", name: { $first: "$name" }, country: { $first: "$address.country" }, review_scores: { $first: "$review_scores" }, review_count: { $sum: 1 } } }, { $sort: { review_count: -1 } }, { $limit: 10 }, { $project: { listing_url: 1, name: 1, country: 1, review_scores: 1, _id: 0 } } ])
``` 
</details> 
<details><summary><b>17. Find all the listings with listing_url, name, address, and review_scores in the listingsAndReviews collection that have a "fireplace" amenity and a review score rating of at least 8.</b></summary> 
    
```javascript 
db.listingsAndReviews.find( { "amenities": "fireplace", "review_scores.review_scores_rating": { $gte: 8 } }, { "listing_url": 1, "name": 1, "address": 1, "review_scores": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>18. Find all the listings with listing_url, name, address, amenities, and review_scores in the listingsAndReviews collection that have a "washer" amenity and are located in either Italy or Spain.</b></summary> 
    
```javascript 
db.listingsAndReviews.find( { "amenities": "washer", "address.country": { $in: ["Italy", "Spain"] } }, { "listing_url": 1, "name": 1, "address": 1, "amenities": 1, "review_scores": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>19. Find the listings with listing_url, name, address, amenities, price, and review_scores in the listingsAndReviews collection that have the highest nightly prices.</b></summary> 
    
```javascript 
db.listingsAndReviews.find().sort({ "price": -1 }).limit(1).project({ "listing_url": 1, "name": 1, "address": 1, "amenities": 1, "price": 1, "review_scores": 1, _id: 0 }) ``` 
</details> 
<details><summary><b>20. Find the listings with listing_url, name, address, amenities, price, and review_scores in the listingsAndReviews collection that have the lowest nightly prices.</b></summary> 
    
```javascript
db.listingsAndReviews.find().sort({ "price": 1 }).limit(1).project({ "listing_url": 1, "name": 1, "address": 1, "amenities": 1, "price": 1, "review_scores": 1, _id: 0 }) ``` 
</details>
<details><summary><b>21. Retrieve all documents with name, address, reviewer_name, and review_scores_rating in the listingsAndReviews collection that have a number_of_reviews field equal to 0.</b></summary> 
    
```javascript
db.listingsAndReviews.find( { "number_of_reviews": 0 }, { "name": 1, "address": 1, "reviews.reviewer_name": 1, "review_scores.review_scores_rating": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>22. Retrieve all documents with name, address, host, reviewer_name, and review_scores_rating in the listingsAndReviews collection where the host_is_superhost field is equal to true.</b></summary> 
    
```javascript 
db.listingsAndReviews.find( { "host.host_is_superhost": true }, { "name": 1, "address": 1, "host": 1, "reviews.reviewer_name": 1, "review_scores.review_scores_rating": 1, _id: 0 } )
``` 
</details> 
<details><summary><b>23. Retrieve all documents with name, address, host, bed_type, bed, and review_scores_rating from the listingsAndReviews collection where the beds field is greater than or equal to 2.</b></summary>
    
```javascript 
db.listingsAndReviews.find( { "beds": { $gte: 2 } }, { "name": 1, "address": 1, "host": 1, "bed_type": 1, "beds": 1, "review_scores.review_scores_rating": 1, _id: 0 } ) ``` 
</details> 
<details><summary><b>24. Find all listings with name, address, host in the listingsAndReviews collection that have a host with a host_name containing the word "Livia".</b></summary> 
    
```javascript
db.listingsAndReviews.find( { "host.host_name": /Livia/ }, { "name": 1, "address": 1, "host": 1, _id: 0 } )
```
</details> 
<details><summary><b>25. Find all listings with name, address, host in the listingsAndReviews collection that have a host with a host_location of "Brazil".</b></summary> 
    
```javascript 
db.listingsAndReviews.find( { "host.host_location": "Brazil" }, { "name": 1, "address": 1, "host": 1, _id: 0 } )
``` 
</details>
Sure! Here are the queries formatted in the requested style:

<details><summary><b>26. Find all listings with name, address, host in the listingsAndReviews collection that have a host with a host_location of "Brazil".</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "host.host_location": "Brazil" },
  { "name": 1, "address": 1, "host": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>27. Retrieve all documents with name, address, host, availability in the listingsAndReviews collection where the availability_365 field is greater than 300.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "availability_365": { $gt: 300 } },
  { "name": 1, "address": 1, "host": 1, "availability_365": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>28. Retrieve all documents with listing_url, name, bedrooms, price in the listingsAndReviews collection where the bedrooms field is equal to 1.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "bedrooms": 1 },
  { "listing_url": 1, "name": 1, "bedrooms": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>29. Retrieve all documents with listing_url, name, bedrooms, cleaning_fee, and price in the listingsAndReviews collection where the cleaning_fee field is not null.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "cleaning_fee": { $ne: null } },
  { "listing_url": 1, "name": 1, "bedrooms": 1, "cleaning_fee": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>30. Retrieve all documents with listing_url, name, bedrooms, price in the listingsAndReviews collection where the price field is between $600 and $900.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "price": { $gte: 600, $lte: 900 } },
  { "listing_url": 1, "name": 1, "bedrooms": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>31. Retrieve all documents with listing_url, name, host, price in the listingsAndReviews collection where the host_verifications array contains "email".</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "host.host_verifications": "email" },
  { "listing_url": 1, "name": 1, "host": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>32. Retrieve all documents with listing_url, name, amenity, host in the listingsAndReviews collection where the amenities array contains both "TV" and "Wifi".</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "amenities": { $all: ["TV", "Wifi"] } },
  { "listing_url": 1, "name": 1, "amenities": 1, "host": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>33. Find all listings with listing_url, name, amenities, host in the listingsAndReviews collection that have a host with a Jumio verification and a about section.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "host.host_verifications": "jumio", "host.host_about": { $exists: true } },
  { "listing_url": 1, "name": 1, "amenities": 1, "host": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>34. Retrieve all documents with listing_url, name, host, price in the listingsAndReviews collection where the host_total_listings_count field is greater than 1.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "host.host_total_listings_count": { $gt: 1 } },
  { "listing_url": 1, "name": 1, "host": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>35. Retrieve all documents with listing_url, name, property_type, bed, price in the listingsAndReviews collection where the property_type field is equal to "Apartment" and the beds field is greater than or equal to 2.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "property_type": "Apartment", "beds": { $gte: 2 } },
  { "listing_url": 1, "name": 1, "property_type": 1, "beds": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>36. Find all listings with listing_url, name, property_type, bed, bathrooms, price in the listingsAndReviews collection that have a minimum of 2 bathrooms.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "bathrooms": { $gte: 2 } },
  { "listing_url": 1, "name": 1, "property_type": 1, "beds": 1, "bathrooms": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>37. Find all listings with listing_url, name, property_type, bed, price, guests_included in the listingsAndReviews collection that have a maximum of 5 guests included in the price.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "guests_included": { $lte: 5 } },
  { "listing_url": 1, "name": 1, "property_type": 1, "beds": 1, "price": 1, "guests_included": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>38. Find all listings with listing_url, name, property_type, bed, price, security_deposit in the listingsAndReviews collection that have a price greater than $500 and a security deposit of $1000 or more.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "price": { $gt: 500 }, "security_deposit": { $gte: 1000 } },
  { "listing_url": 1, "name": 1, "property_type": 1, "beds": 1, "price": 1, "security_deposit": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>39. Find all listings with listing_url, name, property_type, bed, price, cancellation_policy in the listingsAndReviews collection that have a cancellation policy of "flexible".</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "cancellation_policy": "flexible" },
  { "listing_url": 1, "name": 1, "property_type": 1, "beds": 1, "price": 1, "cancellation_policy": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>40. Find all listings with listing_url, name, property_type, bed_type, amenities, price in the listingsAndReviews collection that have a real bed as the bed type and a kitchen amenity.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "bed_type": "Real Bed", "amenities": "kitchen" },
  { "listing_url": 1, "name": 1, "property_type": 1, "bed_type": 1, "amenities": 1, "price": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>41. Find all listings with listing_url, name, address, amenities in the listingsAndReviews collection that have a 24-hour check-in amenity and are located in Brazil.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "amenities": "24-hour check-in", "address.country": "Brazil" },
  { "listing_url": 1, "name": 1, "address": 1, "amenities": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>42. Find all listings with listing_url, name, address, reviews in the listingsAndReviews collection that have at least one review.</b></summary>
 
```javascript
db.listingsAndReviews.find(
  { "reviews": { $exists: true, $ne: [] } },
  { "listing_url": 1, "name": 1, "address": 1, "reviews": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>43. Find the number of documents that have a blank medium picture URL in the listingsAndReviews collection.</b></summary>
 
```javascript
db.listingsAndReviews.countDocuments({ "medium_picture_url": "" })
``` 
</details>

<details><summary><b>44. Find all listings with listing_url, name, address, availability_30 in the listingsAndReviews collection that have an availability of at least 30 days.</b></summary>

```javascript
db.listingsAndReviews.find(
  { "availability_30": { $gte: 30 } },
  { "listing_url": 1, "name": 1, "address": 1, "availability_30": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>45. Find all listings with listing_url, name, address in the listingsAndReviews collection that have a suburb of "Lagoa".</b></summary>

```javascript
db.listingsAndReviews.find(
  { "address.suburb": "Lagoa" },
  { "listing_url": 1, "name": 1, "address": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>46. Find all listings with listing_url, name, address, host in the listingsAndReviews collection that have a host who is a superhost and has at least 2 listings.</b></summary>

```javascript
db.listingsAndReviews.find(
  { "host.host_is_superhost": true, "host.host_total_listings_count": { $gte: 2 } },
  { "listing_url": 1, "name": 1, "address": 1, "host": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>47. Find all listings with listing_url, name, address, host in the listingsAndReviews collection that have a host who has a profile pic and has been identity verified.</b></summary>

```javascript
db.listingsAndReviews.find(
  { "host.host_picture_url": { $exists: true }, "host.host_verifications": { $exists: true, $ne: [] } },
  { "listing_url": 1, "name": 1, "address": 1, "host": 1, _id: 0 }
)
``` 
</details>

<details><summary><b>48. Write a MongoDB query to find the listing_url, name, address, host_verifications, and size of host_verifications under the host subdocument in the listingsAndReviews collection.</b></summary>

```javascript
db.listingsAndReviews.aggregate([
  { $project: { listing_url: 1, name: 1, address: 1, "host_verifications": "$host.host_verifications", "verification_count": { $size: "$host.host_verifications" }, _id: 0 } }
])
``` 
</details>

<details><summary><b>49. Find all listings with listing_url, name, address, and host_picture_url in the listingsAndReviews collection that have a host with a picture URL.</b></summary>

```javascript
db.listingsAndReviews.find(
  { "host.host_picture_url": { $exists: true } },
  { "listing_url": 1, "name": 1, "address": 1, "host.host_picture_url": 1, _id: 0 }
)
``` 
</details>
MongoDB Exercises: Movies collection
Last update on December 01 2023 05:35:11 (UTC/GMT +8 hours)

 MongoDB Query Exercises and Solution : Movie collection - 28 Exercises

Sample document of 'movies' collection:

```javascript
  {
    _id: ObjectId("573a1390f29313caabcd42e8"),
plot: 'A group of bandits stage a brazen train hold-up, only to find a determined posse hot on their heels.',
genres: [ 'Short', 'Western' ],
runtime: 11,
cast: [
      'A.C. Abadie',
      "Gilbert M. 'Broncho Billy' Anderson",
      'George Barnes',
      'Justus D. Barnes'
    ],
poster: 'https://m.media-amazon.com/images/M/MV5BMTU3NjE5NzYtYTYyNS00MDVmLWIwYjgtMmYwYWIxZDYyNzU2XkEyXkFqcGdeQXVyNzQzNzQxNzI@._V1_SY1000_SX677_AL_.jpg',
title: 'The Great Train Robbery',
fullplot: "Among the earliest existing films in American cinema - notable as the first film that presented a narrative story to tell - it depicts a group of cowboy outlaws who hold up a train and rob the passengers. They are then pursued by a Sheriff's posse. Several scenes have color included - all hand tinted.",
languages: [ 'English' ],
released: ISODate("1903-12-01T00:00:00.000Z"),
directors: [ 'Edwin S. Porter' ],
rated: 'TV-G',
awards: { wins: 1, nominations: 0, text: '1 win.' },
lastupdated: '2015-08-13 00:27:59.177000000',
year: 1903,
imdb: { rating: 7.4, votes: 9847, id: 439 },
countries: [ 'USA' ],
type: 'movie',
tomatoes: {
viewer: { rating: 3.7, numReviews: 2559, meter: 75 },
fresh: 6,
critic: { rating: 7.6, numReviews: 6, meter: 100 },
rotten: 0,
lastUpdated: ISODate("2015-08-08T19:16:10.000Z")
    }
```

You may download the compressed file and uncompress it to find the collection used in our exercises. The collection comprises of 2000 documents.

<details><summary><b>1. Find all movies with full information from the 'movies' collection that released in the year 1893.</b></summary>
 
```javascript
db.movies.find(
  { "released": { $regex: "^1893" } }
)
```
</details>

<details><summary><b>2. Find all movies with full information from the 'movies' collection that have a runtime greater than 120 minutes.</b></summary>
 
```javascript
db.movies.find(
  { "runtime": { $gt: 120 } }
)
```
</details>

<details><summary><b>3. Find all movies with full information from the 'movies' collection that have "Short" genre.</b></summary>
 
```javascript
db.movies.find(
  { "genres": "Short" }
)
```
</details>

<details><summary><b>4. Retrieve all movies from the 'movies' collection that were directed by "William K.L. Dickson" and include complete information for each movie.</b></summary>
 
```javascript
db.movies.find(
  { "directors": "William K.L. Dickson" }
)
```
</details>

<details><summary><b>5. Retrieve all movies from the 'movies' collection that were released in the USA and include complete information for each movie.</b></summary>
 
```javascript
db.movies.find(
  { "countries": "USA" }
)
```
</details>

<details><summary><b>6. Retrieve all movies from the 'movies' collection that have complete information and are rated as "UNRATED".</b></summary>
 
```javascript
db.movies.find(
  { "rating": "UNRATED" }
)
```
</details>

<details><summary><b>7. Retrieve all movies from the 'movies' collection that have complete information and have received more than 1000 votes on IMDb.</b></summary>
 
```javascript
db.movies.find(
  { "votes": { $gt: 1000 } }
)
```
</details>

<details><summary><b>8. Retrieve all movies from the 'movies' collection that have complete information and have an IMDb rating higher than 7.</b></summary>
 
```javascript
db.movies.find(
  { "imdb.rating": { $gt: 7 } }
)
```
</details>

<details><summary><b>9. Retrieve all movies from the 'movies' collection that have complete information and have a viewer rating higher than 4 on Tomatoes.</b></summary>
 
```javascript
db.movies.find(
  { "tomatoes.viewer.rating": { $gt: 4 } }
)
```
</details>

<details><summary><b>10. Retrieve all movies from the 'movies' collection that have received an award.</b></summary>
 
```javascript
db.movies.find(
  { "awards": { $exists: true, $ne: "" } }
)
```
</details>

<details><summary><b>11. Find all movies with title, languages, released, directors, writers, awards, year, genres, runtime, cast, countries from the 'movies' collection in MongoDB that have at least one nomination.</b></summary>
 
```javascript
db.movies.find(
  { "awards.nominations": { $exists: true, $ne: [] } },
  { "title": 1, "languages": 1, "released": 1, "directors": 1, "writers": 1, "awards": 1, "year": 1, "genres": 1, "runtime": 1, "cast": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>12. Find all movies with title, languages, released, directors, writers, awards, year, genres, runtime, cast, countries from the 'movies' collection in MongoDB with cast including "Charles Kayser".</b></summary>
 
```javascript
db.movies.find(
  { "cast": "Charles Kayser" },
  { "title": 1, "languages": 1, "released": 1, "directors": 1, "writers": 1, "awards": 1, "year": 1, "genres": 1, "runtime": 1, "cast": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>13. Retrieve all movies with title, languages, released, directors, writers, countries from the 'movies' collection in MongoDB that released on May 9, 1893.</b></summary>
 
```javascript
db.movies.find(
  { "released": "1893-05-09" },
  { "title": 1, "languages": 1, "released": 1, "directors": 1, "writers": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>14. Retrieve all movies with title, languages, released, directors, writers, countries from the 'movies' collection in MongoDB that have a word "scene" in the title.</b></summary>
 
```javascript
db.movies.find(
  { "title": /scene/i },
  { "title": 1, "languages": 1, "released": 1, "directors": 1, "writers": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>15. Find all movies with title, languages, released, directors, viewer, writers, countries from the 'movies' collection in MongoDB that have a viewer rating of at least 3 and less than 4 on Tomatoes.</b></summary>
 
```javascript
db.movies.find(
  { "tomatoes.viewer.rating": { $gte: 3, $lt: 4 } },
  { "title": 1, "languages": 1, "released": 1, "directors": 1, "writers": 1, "tomatoes.viewer.rating": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>16. Retrieve all movies with title, languages, released, year, directors, writers, countries from the 'movies' collection in MongoDB that released before the year 1900.</b></summary>
 
```javascript
db.movies.find(
  { "year": { $lt: 1900 } },
  { "title": 1, "languages": 1, "released": 1, "year": 1, "directors": 1, "writers": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>17. Find all movies with title, languages, fullplot, released, directors, writers, countries from the 'movies' collection in MongoDB that have a fullplot containing the word "fire".</b></summary>
 
```javascript
db.movies.find(
  { "fullplot": /fire/i },
  { "title": 1, "languages": 1, "fullplot": 1, "released": 1, "directors": 1, "writers": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>18. Return all movies with title, languages, plot, released, directors, writers, and countries from the 'movies' collection in MongoDB where the word "beer" mentioned in the plot.</b></summary>
 
```javascript
db.movies.find(
  { "plot": /beer/i },
  { "title": 1, "languages": 1, "plot": 1, "released": 1, "directors": 1, "writers": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>19. Return all movies with title, languages, fullplot, released, directors, writers, and countries from the 'movies' collection in MongoDB where the word "metal" mentioned in the fullplot.</b></summary>
 
```javascript
db.movies.find(
  { "fullplot": /metal/i },
  { "title": 1, "languages": 1, "fullplot": 1, "released": 1, "directors": 1, "writers": 1, "countries": 1, _id: 0 }
)
```
</details>

<details><summary><b>20. Find all movies with title, languages, released, runtime, directors, writers, countries from the 'movies' collection in MongoDB that have a runtime between 60 and 90 minutes.</b></summary>
 
```javascript
db.movies.find(
  { "runtime": { $gte: 60, $lte: 90 } },
  { "title": 1, "languages": 1, "released": 1, "runtime": 1, "directors": 1, "writers": 1, "countries": 1, _id: 0 }
)
 ```
</details>

<details><summary><b>21. Find all movies with title, languages, released, runtime, directors, writers, countries, imdb from the 'movies' collection in MongoDB for the top 5 movies with the highest IMDb ratings.</b></summary>
 
```javascript
db.movies.find(
  {},
  { "title": 1, "languages": 1, "released": 1, "runtime": 1, "directors": 1, "writers": 1, "countries": 1, "imdb": 1 }
).sort({ "imdb.rating": -1 }).limit(5)
```
</details>

<details><summary><b>22. Find all movies from the 'movies' collection in MongoDB with the average runtime of movies released in each country.</b></summary>
 
```javascript
db.movies.aggregate([
  { $group: { _id: "$countries", average_runtime: { $avg: "$runtime" } } }
])
```
</details>

<details><summary><b>23. Find the most common genre among the movies from the 'movies' collection in MongoDB.</b></summary>
 
```javascript
db.movies.aggregate([
  { $unwind: "$genres" },
  { $group: { _id: "$genres", count: { $sum: 1 } } },
  { $sort: { count: -1 } },
  { $limit: 1 }
])
```
</details>

<details><summary><b>24. Find the movies released in the year with the highest average IMDb rating from the 'movies' collection in MongoDB.</b></summary>
 
```javascript
db.movies.aggregate([
  { $group: { _id: "$year", average_rating: { $avg: "$imdb.rating" } } },
  { $sort: { average_rating: -1 } },
  { $limit: 1 },
  { $lookup: {
      from: "movies",
      localField: "_id",
      foreignField: "year",
      as: "movies"
    }
  },
  { $unwind: "$movies" },
  { $replaceRoot: { newRoot: "$movies" } }
])
```
</details>

<details><summary><b>25. Find the top 10 directors with the most movies from the 'movies' collection in MongoDB.</b></summary>
 
```javascript
db.movies.aggregate([
  { $unwind: "$directors" },
  { $group: { _id: "$directors", count: { $sum: 1 } } },
  { $sort: { count: -1 } },
  { $limit: 10 }
])
```
</details>

<details><summary><b>26. Write a query in MongoDB to find the average IMDb rating for movies with different ratings (e.g., 'PG', 'R', 'G') from the 'movies' collection.</b></summary>
 
```javascript
db.movies.aggregate([
  { $group: { _id: "$rating", average_rating: { $avg: "$imdb.rating" } } }
])
```
</details>

<details><summary><b>27. Write a query in MongoDB to find the oldest movie with an award win from the 'movies' collection.</b></summary>
 
```javascript
db.movies.find(
  { "awards": { $exists: true, $ne: "" } }
).sort({ "released": 1 }).limit(1)
```
</details>

<details><summary><b>28. Write a query in MongoDB to find the movie with the highest IMDb rating and viewer rating on Tomatoes from the 'movies' collection.</b></summary>
 
```javascript
db.movies.find().sort({ "imdb.rating": -1, "tomatoes.viewer.rating": -1 }).limit(1)
```
</details>
