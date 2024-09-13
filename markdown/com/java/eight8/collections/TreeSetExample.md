# com\java\eight8\collections\TreeSetExample.java

```java
package com.java.eight8.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//
//TreeSet is another popular implementation of Set interface along with HashSet and LinkedHashSet. All these implementations of Set interface are required in different scenarios. If you don’t want any order of elements, then you can use HashSet. If you want insertion order of elements to be maintained, then use LinkedHashSet. If you want elements to be ordered according to some Comparator, then use TreeSet. The common thing of these three implementations is that they don’t allow duplicate elements.
//
//
//In this article, I have tried to explain two examples of Java TreeSet. One example doesn’t use Comparator and another example uses Comparator to order the elements. You can go through some basic properties of TreeSet class here.
//
//Java TreeSet Example With No Comparator :
//You already know that if you don’t pass any comparator while creating a TreeSet, elements will be placed in their natural ascending order. In this example, we create a TreeSet of Integers without supplying any Comparator like this,
//
//TreeSet<Integer> set = new TreeSet<Integer>();
//Let’s add some integer elements to it.
//
//set.add(23);      
// 
//set.add(11);    
// 
//set.add(41);      
// 
//set.add(7);
// 
//set.add(69);
// 
//set.add(18);
// 
//set.add(38);
//Print these elements and observe the output.
//
//System.out.println(set);      //Output : [7, 11, 18, 23, 38, 41, 69]
//You can notice that elements are placed in the ascending order.
//
//The whole code for this example is,
//
//public class TreeSetExample
//{
//    public static void main(String[] args)
//    {
//        //Creating a TreeSet without supplying any Comparator
// 
//        TreeSet<Integer> set = new TreeSet<Integer>();
// 
//        //Adding elements to TreeSet
// 
//        set.add(23);      
// 
//        set.add(11);    
// 
//        set.add(41);      
// 
//        set.add(7);
// 
//        set.add(69);
// 
//        set.add(18);
// 
//        set.add(38);
// 
//        //printing elements of TreeSet
// 
//        System.out.println(set);      //Output : [7, 11, 18, 23, 38, 41, 69]
//    }
//}
//Java TreeSet Example With Comparator :
//In this example, we create one TreeSet by supplying a customized Comparator. In this example, we will try to create a TreeSet of Student objects ordered in the descending order of the percentage of marks they have obtained. That means, student with highest marks will be placed at the top.
//
//Let’s create ‘Student’ class with three fields – id, name and perc_Of_Marks_Obtained.
//
//class Student
//{
//    int id;
// 
//    String name;
// 
//    int perc_Of_Marks_Obtained;
// 
//    public Student(int id, String name, int perc_Of_Marks_Obtained)
//    {
//        this.id = id;
// 
//        this.name = name;
// 
//        this.perc_Of_Marks_Obtained = perc_Of_Marks_Obtained;
//    }
// 
//    @Override
//    public String toString()
//    {
//        return id+" : "+name+" : "+perc_Of_Marks_Obtained;
//    }
//}
//Let’s define our own Comparator class “MyComparator” which compares the marks of two students.
//
//class MyComparator implements Comparator<Student>
//{
//    @Override
//    public int compare(Student s1, Student s2)
//    {
//        if(s1.id == s2.id)
//        {
//            return 0;
//        }
//        else
//        {
//            return s2.perc_Of_Marks_Obtained - s1.perc_Of_Marks_Obtained;
//        }
//    }
//}
//Important Note : TreeSet doesn’t use hashCode() and equals() methods to compare it’s elements. It uses compare() (or compareTo()) method to determine the equality of two elements. Therefore, I have kept the code which compares two Student objects based on their id in compare method itself. This removes possible duplicate elements (elements having same id) from the TreeSet.
//
//Create one TreeSet of ‘Student‘ objects with ‘MyComparator‘ as a Comparator.
//
////Instantiating MyComparator
// 
//MyComparator comparator = new MyComparator();
// 
////Creating TreeSet with 'MyComparator' as Comparator.
// 
//TreeSet<Student> set = new TreeSet<Student>(comparator);
//Add some elements of type ‘Student‘ to this TreeSet.
//
//set.add(new Student(121, "Santosh", 85));
// 
//set.add(new Student(231, "Cherry", 71));
// 
//set.add(new Student(417, "David", 82));
// 
//set.add(new Student(562, "Praveen", 91));
// 
//set.add(new Student(231, "Raj", 61));         //Duplicate element
// 
//set.add(new Student(458, "John", 76));
// 
//set.add(new Student(874, "Peter", 83));
// 
//set.add(new Student(231, "Hari", 52));       //Duplicate element
// 
//set.add(new Student(568, "Daniel", 89));
//Iterate through the TreeSet.
//
////Iterating through TreeSet
// 
//Iterator<Student> it = set.iterator();
// 
//while (it.hasNext())
//{
//    System.out.println(it.next());
//}
//Output will be,
//
//562 : Praveen : 91
//568 : Daniel : 89
//121 : Santosh : 85
//874 : Peter : 83
//417 : David : 82
//458 : John : 76
//231 : Cherry : 71
//You can notice that student with highest percentage of marks is placed at the top and also duplicate elements are not allowed in the TreeSet.
//
//Below is the whole code of the above example.

// Student Class
 
class Student1
{
    int id;
 
    String name;
 
    int perc_Of_Marks_Obtained;
 
    public Student1(int id, String name, int perc_Of_Marks_Obtained)
    {
        this.id = id;
 
        this.name = name;
 
        this.perc_Of_Marks_Obtained = perc_Of_Marks_Obtained;
    }
 
    @Override
    public String toString()
    {
        return id+" : "+name+" : "+perc_Of_Marks_Obtained;
    }
}
 
//MyComparator Class
 
class MyComparator1 implements Comparator<Student1>
{
    @Override
    public int compare(Student1 s1, Student1 s2)
    {
        if(s1.id == s2.id)
        {
            return 0;
        }
        else
        {
            return s2.perc_Of_Marks_Obtained - s1.perc_Of_Marks_Obtained;
        }
    }
}
 
//MainClass
 
public class TreeSetExample
{
    public static void main(String[] args)
    {
        //Instantiating MyComparator
 
        MyComparator1 comparator = new MyComparator1();
 
        //Creating TreeSet with 'MyComparator' as Comparator.
 
        TreeSet<Student1> set = new TreeSet<Student1>(comparator);
 
        //Adding elements to TreeSet
 
        set.add(new Student1(121, "Santosh", 85));
 
        set.add(new Student1(231, "Cherry", 71));
 
        set.add(new Student1(417, "David", 82));
 
        set.add(new Student1(562, "Praveen", 91));
 
        set.add(new Student1(231, "Raj", 61));         //Duplicate element
 
        set.add(new Student1(458, "John", 76));
 
        set.add(new Student1(874, "Peter", 83));
 
        set.add(new Student1(231, "Hari", 52));       //Duplicate element
 
        set.add(new Student1(568, "Daniel", 89));
 
        //Iterating though TreeSet
 
        Iterator<Student1> it = set.iterator();
 
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
```
