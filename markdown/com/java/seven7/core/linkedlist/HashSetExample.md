# com\java\seven7\core\linkedlist\HashSetExample.java

```java
package com.java.seven7.core.linkedlist;

import java.util.HashSet;
import java.util.Iterator;

//Java HashSet is very powerful Collection type when you want a collection of unique objects. HashSet doesn’t allow duplicate elements. HashSet also gives constant time performance for insertion, removal and retrieval operations. It is also important to note that HashSet doesn’t maintain any order. So, It is recommended to use HashSet if you want a collection of unique elements and order of elements is not so important. If you want your elements to be ordered in some way, you can use LinkedHashSet or TreeSet.
//
//
//In this Java article, we will see one real time example of HashSet.
//
//
//Let’s create one HashSet of Student records where each Student record contains three fields – name, rollNo and department. In these, rollNo will be unique for all students.
//
//Let’s create Student class with three fields – name, rollNo and department.
//
//class Student
//{
//    String name;
// 
//    int rollNo;
// 
//    String department;
// 
//    public Student(String name, int rollNo, String department)
//    {
//        this.name = name;
// 
//        this.rollNo = rollNo;
// 
//        this.department = department;
//    }
// 
//    @Override
//    public int hashCode()
//    {
//        return rollNo;
//    }
// 
//    @Override
//    public boolean equals(Object obj)
//    {
//        Student student = (Student) obj;
// 
//        return (rollNo == student.rollNo);
//    }
// 
//    @Override
//    public String toString()
//    {
//        return rollNo+", "+name+", "+department;
//    }
//}
//You can notice that hashCode() and equals() methods are overrided in the above class so that two Students objects will be compared solely based on rollNo. That means, two Student objects having same rollNo will be considered as duplicates irrespective of other fields.
//
//
//Create one HashSet object containing elements of Student type.
//
//HashSet<Student> set = new HashSet<Student>();
//Add some elements to this HashSet.
//
//set.add(new Student("Avinash", 121, "ECE"));
// 
//set.add(new Student("Bharat", 101, "EEE"));
// 
//set.add(new Student("Malini", 151, "Civil"));
// 
//set.add(new Student("Suresh", 200, "IT"));
// 
//set.add(new Student("Vikram", 550, "CS"));
// 
//set.add(new Student("Bharat", 301, "IT"));
// 
//set.add(new Student("Amit", 301, "IT"));           //duplicate element
// 
//set.add(new Student("Bhavya", 872, "ECE"));
// 
//set.add(new Student("Naman", 301, "CS"));        //duplicate element
// 
//set.add(new Student("Samson", 565, "Civil"));
//Iterate through this HashSet.
//
//Iterator<Student> it = set.iterator();
// 
//while (it.hasNext())
//{
//    Student student = (Student) it.next();
// 
//    System.out.println(student);
//}
//Output will be,
//
//550, Vikram, CS
//565, Samson, Civil
//101, Bharat, EEE
//200, Suresh, IT
//872, Bhavya, ECE
//301, Bharat, IT
//121, Avinash, ECE
//151, Malini, Civil
//You can notice that duplicate elements are not added to HashSet.
//
//Here is the whole program.

class Student
{
    String name;
 
    int rollNo;
 
    String department;
 
    public Student(String name, int rollNo, String department)
    {
        this.name = name;
 
        this.rollNo = rollNo;
 
        this.department = department;
    }
 
    @Override
    public int hashCode()
    {
        return rollNo;
    }
 
    @Override
    public boolean equals(Object obj)
    {
        Student student = (Student) obj;
 
        return (rollNo == student.rollNo);
    }
 
    @Override
    public String toString()
    {
        return rollNo+", "+name+", "+department;
    }
}
 
public class HashSetExample
{
    public static void main(String[] args)
    {
        HashSet<Student> set = new HashSet<Student>();
 
        //Adding elements to HashSet
 
        set.add(new Student("Avinash", 121, "ECE"));
 
        set.add(new Student("Bharat", 101, "EEE"));
 
        set.add(new Student("Malini", 151, "Civil"));
 
        set.add(new Student("Suresh", 200, "IT"));
 
        set.add(new Student("Vikram", 550, "CS"));
 
        set.add(new Student("Bharat", 301, "IT"));
 
        set.add(new Student("Amit", 301, "IT"));           //duplicate element
 
        set.add(new Student("Bhavya", 872, "ECE"));
 
        set.add(new Student("Naman", 301, "CS"));        //duplicate element
 
        set.add(new Student("Samson", 565, "Civil"));
 
        //Iterating through HashSet
 
        Iterator<Student> it = set.iterator();
 
        while (it.hasNext())
        {
            Student student = (Student) it.next();
 
            System.out.println(student);
        }
    }
}
```
