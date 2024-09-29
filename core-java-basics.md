#### What is String literal pool?
How to create a String
There are two ways to create a String object in Java:
•	Using the new operator. For example, 
String str = new String("Hello");.
•	Using a string literal or constant expression). For example,
String str="Hello"; (string literal) or
String str="Hel" + "lo"; (string constant expression).

#### What is difference between these String's creations? 

In Java, the equals method can be considered to perform a deep comparison of the value of an object, whereas the == operator performs a shallow comparison. The equals method compares the content of two objects rather than two objects' references. The == operator with reference types (i.e., Objects) evaluates as true if the references are identical - point to the same object. With value types (i.e., primitives) it evaluates as true if the value is identical. The equals method is to returntrue if two objects have identical content - however, the equals method in the java.lang.Object class - the default equals method if a class does not override it - returns trueonly if both references point to the same object.

Let's use the following example to see what difference between these creations of string:
```java
public class DemoStringCreation {

  public static void main (String args[]) {
    String str1 = "Hello";  
    String str2 = "Hello"; 
    System.out.println("str1 and str2 are created by using string literal.");    
    System.out.println("    str1 == str2 is " + (str1 == str2));  
    System.out.println("    str1.equals(str2) is " + str1.equals(str2));  

    
    String str3 = new String("Hello");  
    String str4 = new String("Hello"); 
    System.out.println("str3 and str4 are created by using new operator.");    
    System.out.println("    str3 == str4 is " + (str3 == str4));  
    System.out.println("    str3.equals(str4) is " + str3.equals(str4));  
    
    String str5 = "Hel"+ "lo";  
    String str6 = "He" + "llo"; 
    System.out.println("str5 and str6 are created by using string 
constant expression.");    
    System.out.println("    str5 == str6 is " + (str5 == str6));  
    System.out.println("    str5.equals(str6) is " + str5.equals(str6));

    String s = "lo";
    String str7 = "Hel"+ s;  
    String str8 = "He" + "llo"; 
    System.out.println("str7 is computed at runtime.");		
    System.out.println("str8 is created by using string constant 
expression.");    
    System.out.println("    str7 == str8 is " + (str7 == str8));  
    System.out.println("    str7.equals(str8) is " + str7.equals(str8));
    
  }
}
```
The output result is:
```
str1 and str2 are created by using string literal.
    str1 == str2 is true
    str1.equals(str2) is true
str3 and str4 are created by using new operator.
    str3 == str4 is false
    str3.equals(str4) is true
str5 and str6 are created by using string constant expression.
    str5 == str6 is true
    str5.equals(str6) is true
str7 is computed at runtime.
str8 is created by using string constant expression.
    str7 == str8 is false
    str7.equals(str8) is true
```
The creation of two strings with the same sequence of letters without the use of the newkeyword will create pointers to the same String in the Java String literal pool. The String literal pool is a way Java conserves resources.
 
#### String Literal Pool
String allocation, like all object allocation, proves costly in both time and memory. The JVM performs some trickery while instantiating string literals to increase performance and decrease memory overhead. To cut down the number of String objects created in the JVM, the String class keeps a pool of strings. Each time your code create a string literal, the JVM checks the string literal pool first. If the string already exists in the pool, a reference to the pooled instance returns. If the string does not exist in the pool, a new String object instantiates, then is placed in the pool. Java can make this optimization since strings are immutable and can be shared without fear of data corruption. For example
```java
public class Program
{
    public static void main(String[] args)
    {
       String str1 = "Hello";  
       String str2 = "Hello"; 
       System.out.print(str1 == str2);
    }
}
```
The result is
true
 
Unfortunately, when you use
String a=new String("Hello");
a String object is created out of the String literal pool, even if an equal string already exists in the pool. Considering all that, avoid new String unless you specifically know that you need it! For example
```java
public class Program
{
    public static void main(String[] args)
    {
       String str1 = "Hello";  
       String str2 = new String("Hello");
       System.out.print(str1 == str2 + " ");
       System.out.print(str1.equals(str2));
    }
}
```
The result is
false true
 
A JVM has a string pool where it keeps at most one object of any String. String literals always refer to an object in the string pool. String objects created with the new operator do not refer to objects in the string pool but can be made to using String's intern() method. Thejava.lang.String.intern() returns an interned String, that is, one that has an entry in the global String pool. If the String is not already in the global String pool, then it will be added. For example
```java
public class Program
{
    public static void main(String[] args)
    {
        // Create three strings in three different ways.
        String s1 = "Hello";
        String s2 = new StringBuffer("He").append("llo").toString();
        String s3 = s2.intern();

        // Determine which strings are equivalent using the ==
        // operator
        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s1 == s3? " + (s1 == s3));
    }
}
```
The output is
s1 == s2? false
s1 == s3? true
There is a table always maintaining a single reference to each unique String object in the global string literal pool ever created by an instance of the runtime in order to optimize space. That means that they always have a reference to String objects in string literal pool, therefore, the string objects in the string literal pool not eligible for garbage collection.
 
String Literals in the Java Language Specification Third Edition
 
Each string literal is a reference to an instance of class String. String objects have a constant value. String literals-or, more generally, strings that are the values of constant expressions-are "interned" so as to share unique instances, using the method String.intern.
Thus, the test program consisting of the compilation unit:
```java
package testPackage;
class Test {
        public static void main(String[] args) {
                String hello = "Hello", lo = "lo";
                System.out.print((hello == "Hello") + " ");
                System.out.print((Other.hello == hello) + " ");
                System.out.print((other.Other.hello == hello) + " ");
                System.out.print((hello == ("Hel"+"lo")) + " ");
                System.out.print((hello == ("Hel"+lo)) + " ");
                System.out.println(hello == ("Hel"+lo).intern());
        }
}
class Other { static String hello = "Hello"; }
and the compilation unit:
package other;
public class Other { static String hello = "Hello"; }
```
produces the output:
true true true true false true
This example illustrates six points:
•	Literal strings within the same class in the same package represent references to the same String object.
•	Literal strings within different classes in the same package represent references to the same String object.
•	Literal strings within different classes in different packages likewise represent references to the same String object.
•	Strings computed by constant expressions are computed at compile time and then treated as if they were literals.
•	Strings computed by concatenation at run time are newly created and therefore distinct.
The result of explicitly interning a computed string is the same string as any pre-existing literal string with the same contents.

#### Why String is Immutable in Java ?

This is an old yet still popular question. There are multiple reasons that String is designed to be immutable in Java. A good answer depends on good understanding of memory, synchronization, data structures, etc. In the following, I will summarize some answers.
- 1. Requirement of String Pool
String pool (String intern pool) is a special storage area in Java heap. When a string is created and if the string already exists in the pool, the reference of the existing string will be returned, instead of creating a new object and returning its reference.
The following code will create only one string object in the heap.
view source
print?
1.String string1 = "abcd";
2.String string2 = "abcd";
Here is how it looks:
 
If string is not immutable, changing the string with one reference will lead to the wrong value for the other references.
- 2. Allow String to Cache its Hashcode
The hashcode of string is frequently used in Java. For example, in a HashMap. Being immutable guarantees that hashcode will always the same, so that it can be cashed without worrying the changes.That means, there is no need to calculate hashcode every time it is used. This is more efficient.
- 3. Security
String is widely used as parameter for many java classes, e.g. network connection, opening files, etc. Were String not immutable, a connection or file would be changed and lead to serious security threat. The method thought it was connecting to one machine, but was not. Mutable strings could cause security problem in Reflection too, as the parameters are strings.
Here is a code example:
view source
print?
```java
boolean connect(string s){
if (!isSecure(s)) {
throw new SecurityException();
}
//here will cause problem, if s is changed before this by using other references.   
causeProblem(s);
}
```
In summary, the reasons include design, efficiency, and security

#### STRING LITERAL POOL

There are slight differences between the various methods of creating a String object. String allocation, like all object allocation, proves costly in both time and memory. The JVM performs some trickery while instantiating string literals/objects to increase performance and decrease memory overhead. To cut down the number of String objects created, JVM maintains a special memory called“String literal pool” or “String constant pool”.
Each time your code creates a string literal, the JVM checks the string literal pool first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string does not exist in the pool, a new String object is created and placed in the pool. JVM keeps at most one object of any String in this pool. String literals always refer to an object in the string pool.
For example,
Direct Method of creating String object
1	String s1 = "iByteCode";
#### How this works?
	JVM checks the String constant pool first and if the string does not exist, it creates a new String object “iByteCode” and a reference is maintained in the pool. The variable ‘s1′ also refers the same object.
	This statement creates one String object “iByteCode”.
	Now, let’s see what happens if we have a statement like this:
1	String s2 = "iByteCode";
	JVM checks the String constant pool first and since the string already exists, a reference to the pooled instance is returned to s2.
	This statement does not create any String object in the memory and ‘s2′ refers the same object as ‘s1′.
	To check this, you can compare two String references using == operator to check whether two references are referring to the same String object in the memory.
String s1 = "iByteCode";
String s2 = "iByteCode";
if(s1 == s2)
    System.out.println("s1 and s2 referring to the same object.");
s1 and s2 referring to the same object.
 
Java can make this optimization since strings are immutable and can be shared without fear of data corruption. For example, if several reference variables refer to the same String object then it would be bad if any of them changes the String’s value. This is the reason for making String objects as immutable.
- Creating String using constructor
1	String s = new String("iByteCode");
In this case, because we used ‘new’ keyword a String object is created in the heap memory even if an equal string object already exists in the pool and ‘s’ will refer to the newly created one.
```java
String str1 = "iByteCode";
String str2 = new String("iByteCode");
System.out.println(str1 == str2);
```
false
String objects created with the new operator do not refer to objects in the string pool but can be made to using String’s intern() method. The java.lang.String.intern() returns an interned String, that is, one that has an entry in the global String literal pool. If the String is not already in the global String literal pool, then it will be added. For example,
```java
String s1 = new String("iByteCode");
String s2 = s1.intern();
String s3 = "iByteCode";
System.out.println(s2 == s3);
```
true
In the above example, if the change the statement 2 as,
1	String s2 = s1;
Reference variable ‘s2′ will refer to the string object in the heap instead of string literal pool and s1 == s2 will print true.
An object is eligible for garbage collection when it is no longer referenced from an active part of the application. In the case of String literals, they always have a reference to them from the String Literal Pool and are, therefore, not eligible for garbage collection.
All the string literals are created and their references are placed in the pool while JVM loads the class. So, even before a statement like this String s1 = new String(“iByteCode”); is executed, the string literal pool contains a reference to “iByteCode”.

#### Immutable String in Java
In java, string objects are immutable. Immutable simply means unmodifiable or unchangeable.
Once string object is created its data or state can't be changed but a new string object is created.
Let's try to understand the immutability concept by the example given below:
```java
	class Simple{  
	 public static void main(String args[]){  
	   String s="Sachin";  
	   s.concat(" Tendulkar");//concat() method appends the string at the end  
	   System.out.println(s);//will print Sachin because strings are immutable objects  
	 }  
	}  
```
Now it can be understood by the diagram given below. Here Sachin is not changed but a new object is created with sachintendulkar. That is why string is known as immutable.
 
As you can see in the above figure that two objects are created but s reference variable still refers to "Sachin" not to "Sachin Tendulkar".
But if we explicitely assign it to the reference variable, it will refer to "Sachin Tendulkar" object.For example:
```java
	class Simple{  
	 public static void main(String args[]){  
	   String s="Sachin";  
	   s=s.concat(" Tendulkar");  
	   System.out.println(s);  
	 }  
	}  
```
In such case, s points to the "Sachin Tendulkar". Please notice that still sachin object is not modified.
________________________________________
#### Why string objects are immutable in java?
Because java uses the concept of string literal.Suppose there are 5 reference variables,all referes to one object "sachin".If one reference variable changes the value of the object, it will be affected to all the reference variables. That is why string objects are immutable in java.
#### String comparison in Java
 
We can compare two given strings on the basis of content and reference.
It is used in authentication (by equals() method),sorting (by compareTo() method), reference matching (by == operator) etc.
There are three ways to compare String objects:
	By equals() method
	By = = operator
	By compareTo() method
1) By equals() method
- equals() method compares the original content of the string.It compares values of string for equality.String class provides two methods:
•	public boolean equals(Object another){} compares this string to the specified object.
•	public boolean equalsIgnoreCase(String another){} compares this String to another String, ignoring case.
```java
 class Simple{  
	 public static void main(String args[]){  
	   
	   String s1="Sachin";  
	   String s2="Sachin";  
	   String s3=new String("Sachin");  
	   String s4="Saurav";  
	  
	   System.out.println(s1.equals(s2));//true  
	   System.out.println(s1.equals(s3));//true  
	   System.out.println(s1.equals(s4));//false  
	 }  
	}  
 ```
```java
	//Example of equalsIgnoreCase(String) method  
	class Simple{  
	 public static void main(String args[]){  
	   
	   String s1="Sachin";  
	   String s2="SACHIN";  
	  
	   System.out.println(s1.equals(s2));//false  
	   System.out.println(s1.equalsIgnoreCase(s3));//true  
	 }  
	}  
 ```
________________________________________
- 2) By == operator
The = = operator compares references not values.
	//<b><i>Example of == operator</i></b>  
```java	  
	class Simple{  
	 public static void main(String args[]){  
	   
	   String s1="Sachin";  
	   String s2="Sachin";  
	   String s3=new String("Sachin");  
	  
	   System.out.println(s1==s2);//true (because both refer to same instance)  
	   System.out.println(s1==s3);//false(because s3 refers to instance created in nonpool)  
	 }  
	}  
```
_______________________________________
- 3) By compareTo() method:
compareTo() method compares values and returns an int which tells if the values compare less than, equal, or greater than.
Suppose s1 and s2 are two string variables.If:
•	s1 == s2 :0
•	s1 > s2   :positive value
•	s1 < s2   :negative value
	//<b><i>Example of compareTo() method:</i></b>  
```java	  
	class Simple{  
	 public static void main(String args[]){  
	   
	   String s1="Sachin";  
	   String s2="Sachin";  
	   String s3="Ratan";  
	  
	   System.out.println(s1.compareTo(s2));//0  
	   System.out.println(s1.compareTo(s3));//1(because s1>s3)  
	   System.out.println(s3.compareTo(s1));//-1(because s3 < s1 )  
	 }  
	}  
```
#### How to create Immutable class?
There are many immutable classes like String, Boolean, Byte, Short, Integer, Long, Float, Double etc. In short, all the wrapper classes and String class is immutable. We can also create immutable class by creating final class that have final data members as the example given below:
Example to create Immutable class
In this example, we have created a final class named Employee. It have one final datamember, a parameterized constructor and getter method.
```java
 public final class Employee{  
	final String pancardNumber;  
	  
	public Employee(String pancardNumber){  
	this.pancardNumber=pancardNumber;  
	}  
	  
	public String getPancardNumber(){  
	return pancardNumber;  
	}    
	}
```
________________________________________
The above class is immutable because:
•	The instance variable of the class is final i.e. we cannot change the value of it after creating an object.
•	The class is final so we cannot create the subclass.
•	There is no setter methods i.e. we have no option to change the value of the instance variable.
These points makes this class as immutable.
#### Java Reflection API
Reflection is the process of examining or modifying the runtime behaviour of a class at runtime.
The java.lang.Class class provides many methods that can be used to get metadata, examine and change the runtime behaviour of a class.
#### Where is it used?
The Reflection API is mainly used in:
•	IDE (Integreted Development Environment) e.g. Eclipse, MyEclipse, NetBeans etc.
•	Debugger
•	Test Tools etc.

Do You Know ?
•	How many ways we can get the instance of Class class ?
•	How to create the javap tool ?
•	How to create the appletviewer tool ?
•	How to access the private method from outside the class ?
________________________________________
#### java.lang.Class class
The java.lang.Class class performs mainly two tasks:
•	provides methods to get the metadata of a class at runtime.
•	provides methods to examine and change the runtime behaviour of a class.
________________________________________
#### Commonly used methods of Class class:
Method	Description
1) public String getName()	returns the class name
2) public static Class forName(String className)throws ClassNotFoundException	loads the class and returns the reference of Class class.
3) public Object newInstance()throws InstantiationException,IllegalAccessException	creates new instance.
4) public boolean isInterface()	checks if it is interface.
5) public boolean isArray()	checks if it is array.
6) public boolean isPrimitive()	checks if it is primitive.
7) public Class getSuperclass()	returns the superclass class reference.
8) public Field[] getDeclaredFields()throws SecurityException	returns the total number of fields of this class.
9) public Method[] getDeclaredMethods()throws SecurityException	returns the total number of methods of this class.
10) public Constructor[] getDeclaredConstructors()throws SecurityException	returns the total number of constructors of this class.
11) public Method getDeclaredMethod(String name,Class[] parameterTypes)throws NoSuchMethodException,SecurityException	returns the method class instance.
________________________________________
#### How to get the object of Class class?
There are 3 ways to get the instance of Class class. They are as follows:
•	forName() method of Class class
•	getClass() method of Object class
•	the .class syntax
- 1) forName() method of Class class
•	is used to load the class dynamically.
•	returns the instance of Class class.
•	It should be used if you know the fully qualified name of class.This cannot be used for primitive types.
Let's see the simple example of forName() method.
```java
class Simple{}  
	  
	class Test{  
	 public static void main(String args[]){  
	  Class c=Class.forName("Simple");  
	  System.out.println(c.getName());  
	 }  
	}
```
Output:Simple
________________________________________
- 2) getClass() method of Object class
It returns the instance of Class class. It should be used if you know the type. Moreover, it can be used with primitives.
```java
1.	class Simple{}  
2.	  
3.	class Test{  
4.	  void printName(Object obj){  
5.	  Class c=obj.getClass();    
6.	  System.out.println(c.getName());  
7.	  }  
8.	  public static void main(String args[]){  
9.	   Simple s=new Simple();  
10.	   
11.	   Test t=new Test();  
12.	   t.printName(s);  
13.	 }  
14.	}  
15.
```
Output:Simple
________________________________________
- 3) The .class syntax
If a type is available but there is no instance then it is possible to obtain a Class by appending ".class" to the name of the type.It can be used for primitive data type also.
```java
1.	class Test{  
2.	  public static void main(String args[]){  
3.	   Class c = boolean.class;   
4.	   System.out.println(c.getName());  
5.	  
6.	   Class c2 = Test.class;   
7.	   System.out.println(c2.getName());  
8.	 }  
9.	}
```
Output:boolean
       Test
________________________________________
#### Determining the class object
Following methods of Class class is used to determine the class object:
1) public boolean isInterface(): determines if the specified Class object represents an interface type.
2) public boolean isArray(): determines if this Class object represents an array class.
3) public boolean isPrimitive(): determines if the specified Class object represents a primitive type.
Let's see the simple example of reflection api to determine the object type.
```java
1.	class Simple{}  
2.	interface My{}  
3.	  
4.	class Test{  
5.	 public static void main(String args[]){  
6.	  try{  
7.	   Class c=Class.forName("Simple");  
8.	   System.out.println(c.isInterface());  
9.	     
10.	   Class c2=Class.forName("My");  
11.	   System.out.println(c2.isInterface());  
12.	    
13.	  }catch(Exception e){System.out.println(e);}  
14.	  
15.	 }  
16.	}
```
Output:false
       true
#### Comparable interface
Comparable interface is used to order the objects of user-defined class.This interface is found in java.lang package and contains only one method named compareTo(Object).It provide only single sorting sequence i.e. you can sort the elements on based on single datamember only.For instance it may be either rollno,name,age or anything else.
Syntax:
public int compareTo(Object obj): is used to compare the current object with the specified object.
________________________________________
We can sort the elements of:
1.	String objects
2.	Wrapper class objects
3.	User-defined class objects
Collections class provides static methods for sorting the elements of collection.If collection elements are of Set type, we can use TreeSet.But We cannot sort the elements of List.Collections class provides methods for sorting the elements of List type elements.
Method of Collections class for sorting List elements
public void sort(List list): is used to sort the elements of List.List elements must be of Comparable type.
Note: String class and Wrapper classes implements the Comparable interface.So if you store the objects of string or wrapper classes, it will be Comparable.
________________________________________
Example of Sorting the elements of List that contains user-defined class objects on age basis
Student.java
```java
1.	class Student implements Comparable{  
2.	int rollno;  
3.	String name;  
4.	int age;  
5.	Student(int rollno,String name,int age){  
6.	this.rollno=rollno;  
7.	this.name=name;  
8.	this.age=age;  
9.	}  
10.	  
11.	public int compareTo(Object obj){  
12.	Student st=(Student)obj;  
13.	if(age==st.age)  
14.	return 0;  
15.	else if(age>st.age)  
16.	return 1;  
17.	else  
18.	return -1;  
19.	}  
20.	  
21.	}
```
Simple.java
```java
1.	import java.util.*;  
2.	import java.io.*;  
3.	  
4.	class Simple{  
5.	public static void main(String args[]){  
6.	  
7.	ArrayList al=new ArrayList();  
8.	al.add(new Student(101,"Vijay",23));  
9.	al.add(new Student(106,"Ajay",27));  
10.	al.add(new Student(105,"Jai",21));  
11.	  
12.	Collections.sort(al);  
13.	Iterator itr=al.iterator();  
14.	while(itr.hasNext()){  
15.	Student st=(Student)itr.next();  
16.	System.out.println(st.rollno+""+st.name+""+st.age);  
17.	  }  
18.	}  
19.	}
```
Output:105 Jai 21
       101 Vijay 23
       106 Ajay 27
#### Comparator interface
Comparator interface is used to order the objects of user-defined class.
This interface is found in java.util package and contains 2 methods compare(Object obj1,Object obj2) and equals(Object element).
It provides multiple sorting sequence i.e. you can sort the elements based on any data member. For instance it may be on rollno, name, age or anything else.
Syntax of compare method
public int compare(Object obj1,Object obj2): compares the first object with second object.
________________________________________
Collections class provides static methods for sorting the elements of collection. If collection elements are of Set type, we can use TreeSet. But We cannot sort the elements of List. Collections class provides methods for sorting the elements of List type elements.
Method of Collections class for sorting List elements
public void sort(List list,Comparator c): is used to sort the elements of List by the given comparator.
________________________________________
Example of sorting the elements of List that contains user-defined class objects on the basis of age and name
In this example, we have created 4 java classes:
•  Student.java
•  AgeComparator.java
•  NameComparator.java
•  Simple.java
Student.java
This class contains three fields rollno, name and age and a parameterized constructor.
```java
1.	class Student{  
2.	int rollno;  
3.	String name;  
4.	int age;  
5.	Student(int rollno,String name,int age){  
6.	this.rollno=rollno;  
7.	this.name=name;  
8.	this.age=age;  
9.	}  
10.	}
```
AgeComparator.java
This class defines comparison logic based on the age. If age of first object is greater than the second, we are returning positive value, it can be any one such as 1, 2 , 10 etc. If age of first object is less than the second object, we are returning negative value, it can be any negative value and if age of both objects are equal, we are returning 0.
```java
1.	import java.util.*;  
2.	class AgeComparator implements Comparator{  
3.	public int Compare(Object o1,Object o2){  
4.	Student s1=(Student)o1;  
5.	Student s2=(Student)o2;  
6.	  
7.	if(s1.age==s2.age)  
8.	return 0;  
9.	else if(s1.age>s2.age)  
10.	return 1;  
11.	else  
12.	return -1;  
13.	}  
14.	}
```
NameComparator.java
This class provides comparison logic based on the name. In such case, we are using the compareTo() method of String class, which internally provides the comparison logic.
```java
1.	import java.util.*;  
2.	class NameComparator implements Comparator{  
3.	public int Compare(Object o1,Object o2){  
4.	Student s1=(Student)o1;  
5.	Student s2=(Student)o2;  
6.	  
7.	return s1.name.compareTo(s2.name);  
8.	}  
9.	}
```
Simple.java
In this class, we are printing the objects values by sorting on the basis of name and age.
```java
1.	import java.util.*;  
2.	import java.io.*;  
3.	  
4.	class Simple{  
5.	public static void main(String args[]){  
6.	  
7.	ArrayList al=new ArrayList();  
8.	al.add(new Student(101,"Vijay",23));  
9.	al.add(new Student(106,"Ajay",27));  
10.	al.add(new Student(105,"Jai",21));  
11.	  
12.	System.out.println("Sorting by Name...");  
13.	  
14.	Collections.sort(al,new NameComparator());  
15.	Iterator itr=al.iterator();  
16.	while(itr.hasNext()){  
17.	Student st=(Student)itr.next();  
18.	System.out.println(st.rollno+" "+st.name+" "+st.age);  
19.	}  
20.	  
21.	System.out.println("sorting by age...");  
22.	  
23.	Collections.sort(al,new AgeComparator());  
24.	Iterator itr2=al.iterator();  
25.	while(itr2.hasNext()){  
26.	Student st=(Student)itr2.next();  
27.	System.out.println(st.rollno+" "+st.name+" "+st.age);  
28.	}  
29.	  
30.	  
31.	}  
32.	}
```
Output:Sorting by Name...
       106 Ajay 27
       105 Jai 21
       101 Vijay 23
       Sorting by age...       
       105 Jai 21
       101 Vijay 23
       106 Ajay 27
#### Serialization
1.	Serialization
2.	Serializable Interface
3.	ObjectOutputStream class
4.	Example of Serialization
5.	Deserialization
6.	ObjectInputStream class
7.	Example of Deserialization
8.	Serialization with Inheritance
9.	Externalizable interface
10.	Serialization and static datamember
11.	Serializing the array or collection objects
12.	Serializing the object of a class that has non-serialzable object
13.	Deserializing the class object that have parameterized constructor only
Serialization is a machanism of writing the state of an object into a byte stream. It is mainly used in Hibernate, JPA, EJB etc. The reverse operation of the serialization is called deserialization. The String class and all the wrapper classes implements Serializable interface bydefault.
#### Advantage of Serialization
It is mainly used to travel object's state on the network.
________________________________________
#### About Serializable interface
Serializable is a marker interface(have no body). It is just used to "mark" Java classes which support a certain capability. It must be implemented by the class whose object you want to persist. Let's see the example given below:
```java
1.	import java.io.Serializable;  
2.	  
3.	public class Student implements Serializable{  
4.	 int id;  
5.	 String name;  
6.	 public Student(int id, String name) {  
7.	  this.id = id;  
8.	  this.name = name;  
9.	 }  
10.	}
```
________________________________________
ObjectOutputStream class:
An ObjectOutputStream is used to write primitive data types and Java objects to an OutputStream.Only objects that support the java.io.Serializable interface can be written to streams.
- Commonly used Constructors:
1) public ObjectOutputStream(OutputStream out) throws IOException {}creates an ObjectOutputStream that writes to the specified OutputStream.
- Commonly used Methods:
1) public final void writeObject(Object obj) throws IOException {}write the specified object to the ObjectOutputStream.
2) public void flush() throws IOException {}flushes the current output stream.
________________________________________
- Example of Serialization
In this example, we are going to serialize the object of Student class. The writeObject() method of ObjectOutputStream class provides the functionality to serialize the object. We are saving the state of the object in the file named f.txt.
```java
1.	import java.io.*;  
2.	class Persist{  
3.	 public static void main(String args[])throws Exception{  
4.	  Student s1 =new Student(211,"ravi");  
5.	  
6.	  FileOutputStream fout=new FileOutputStream("f.txt");  
7.	  ObjectOutputStream out=new ObjectOutputStream(fout);  
8.	  
9.	  out.writeObject(s1);  
10.	  out.flush();  
11.	  
12.	  System.out.println("success");  
13.	 }  
14.	}
```
1.	<strong>Output:</strong>success  
download this example of serialization
________________________________________
#### Deserilization:
Deserialization is the process of reconstructing the object from the serialized state.It is the reverse operation of serialization.
ObjectInputStream class:
An ObjectInputStream deserializes objects and primitive data written using an ObjectOutputStream.
- Commonly used Constructors:
1) public ObjectInputStream(InputStream in) throws IOException {}creates an ObjectInputStream that reads from the specified InputStream.
- Commonly used Methods:
1) public final Object readObject() throws IOException, ClassNotFoundException{}reads an object from the input stream.
________________________________________
- Example of Deserialization:
```java
1.	import java.io.*;  
2.	class Depersist{  
3.	 public static void main(String args[])throws Exception{  
4.	    
5.	  ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
6.	  Student s=(Student)in.readObject();  
7.	  System.out.println(s.id+" "+s.name);  
8.	  
9.	  in.close();  
10.	 }  
11.	}
```
1.	<strong>Output:</strong>211 ravi  
download this example of deserialization
________________________________________
#### Serialization with Inheritance
If a class implements Serilizable then all its subclasses will also be serilizable. Let's see the example given below:
```java
1.	import java.io.Serializable;  
2.	  
3.	class Person implements Serializable{  
4.	 int id;  
5.	 String name;  
6.	 Person(int id, String name) {  
7.	  this.id = id;  
8.	  this.name = name;  
9.	 }  
10.	}  
1.	class Student extends Person{  
2.	 String course;  
3.	 int fee;  
4.	 public Student(int id, String name, String course, int fee) {  
5.	  super(id,name);  
6.	  this.course=course;  
7.	  this.fee=fee;  
8.	 }  
9.	}
```
Now you can serialize the Student class object that extends the Person class which is Serializable.Parent class properties are inherited to subclasses so if parent class is Serializable, subclass would also be.
________________________________________
#### Externalizable interface:
The Externalizable interface provides the facility of writing the state of an object into a byte stream in compress format. It is not a marker interface.
The Externalizable interface provides two methods:
•	public void writeExternal(ObjectOutput out) throws IOException
•	public void readExternal(ObjectInput in) throws IOException
________________________________________
#### Serialization with Static datamember
Note: If there is any static data member in a class, it will not be serialized because static is related to class not to instance.
```java
1.	class Employee implements Serializable{  
2.	 int id;  
3.	 String name;  
4.	 static String companyName="IBM";//it won't be serialized  
5.	 public Student(int id, String name) {  
6.	  this.id = id;  
7.	  this.name = name;  
8.	 }  
9.	}
```
________________________________________
Rule: In case of array or collection, all the objects of array or collection must be serializable,if any object is not serialiizable then serialization will be failed.
#### The transient keyword
The transient keyword is used in serialization. If you define any data member as transient, it will not be serialized. Let's take an example, I have declared a class as Student, it has three data members id, name and age. If you serialize the object, all the values will be serialized but I don't want to serialize one value, e.g. age then we can declare the age datamember as transient.
- Example of transient keyword
In this example, we have created the two classes Student and Persist. One data member of the Student class is declared as transient, it value will not be serialized. If you deserialize the object, it will return the default value for transient variable.
```java
1.	import java.io.Serializable;  
2.	  
3.	public class Student implements Serializable{  
4.	 int id;  
5.	 String name;  
6.	 transient int age;//Now it will not be serialized  
7.	 public Student(int id, String name,int age) {  
8.	  this.id = id;  
9.	  this.name = name;  
10.	  this.age=age;  
11.	 }  
12.	}  
1.	import java.io.*;  
2.	class Persist{  
3.	 public static void main(String args[])throws Exception{  
4.	  Student s1 =new Student(211,"ravi",22);  
5.	  
6.	  FileOutputStream f=new FileOutputStream("f.txt");  
7.	  ObjectOutputStream out=new ObjectOutputStream(f);  
8.	  
9.	  out.writeObject(s1);  
10.	  out.flush();  
11.	  
12.	  System.out.println("success");  
13.	 }  
14.	}
```
1.	<strong>Output:</strong>succss  
#### Synchronization
Synchronization is the capabilility of control the access of multiple threads to any shared resource. Synchronization is better in case we want only one thread can access the shared resource at a time.
#### Why use Synchronization?
The synchronization is mainly used to
1.	To prevent thread interference.
2.	To prevent consistency problem.
________________________________________
#### Types of Synchronization
There are two types of synchronization
1.	Process Synchronization
2.	Thread Synchronization
Here, we will discuss only thread synchronization.
#### Thread Synchronization
There are two types of thread synchronization mutual exclusive and inter-thread communication.
•	Mutual Exclusive
1.	Synchronized method.
2.	Synchronized block.
3.	static synchronization.
•	Cooperation (Inter-thread communication)
________________________________________
#### Mutual Exclusive
Mutual Exclusive helps keep threads from interfering with one another while sharing data. This can be done by three ways in java:
1.	by synchronized method
2.	by synchronized block
3.	by static synchronization
#### Understanding the concept of Lock
Synchronization is built around an internal entity known as the lock or monitor.Every object has an lock associated with it. By convention, a thread that needs consistent access to an object's fields has to acquire the object's lock before accessing them, and then release the lock when it's done with them.
From Java 5 the package java.util.concurrent.locks contains several lock implementations.
#### Understanding the problem without Synchronization
In this example, there is no synchronization, so output is inconsistent. Let's see the example:
```java
1.	Class Table{  
2.	  
3.	void printTable(int n){//method not synchronized  
4.	   for(int i=1;i<=5;i++){  
5.	     System.out.println(n*i);  
6.	     try{  
7.	      Thread.sleep(400);  
8.	     }catch(Exception e){System.out.println(e);}  
9.	   }  
10.	  
11.	 }  
12.	}  
13.	  
14.	class MyThread1 extends Thread{  
15.	Table t;  
16.	MyThread1(Table t){  
17.	this.t=t;  
18.	}  
19.	public void run(){  
20.	t.printTable(5);  
21.	}  
22.	  
23.	}  
24.	class MyThread2 extends Thread{  
25.	Table t;  
26.	MyThread2(Table t){  
27.	this.t=t;  
28.	}  
29.	public void run(){  
30.	t.printTable(100);  
31.	}  
32.	}  
33.	  
34.	class Use{  
35.	public static void main(String args[]){  
36.	Table obj = new Table();//only one object  
37.	MyThread1 t1=new MyThread1(obj);  
38.	MyThread2 t2=new MyThread2(obj);  
39.	t1.start();  
40.	t2.start();  
41.	}  
42.	}
```
________________________________________

#### Solution by synchronized method

•	If you declare any method as synchronized, it is known as synchronized method.
•	Synchronized method is used to lock an object for any shared resource.
•	When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the method returns.
```java
1.	<b><i>//Program of synchronized method</i></b>  
2.	  
3.	Class Table{  
4.	  
5.	 synchronized void printTable(int n){//synchronized method  
6.	   for(int i=1;i<=5;i++){  
7.	     System.out.println(n*i);  
8.	     try{  
9.	      Thread.sleep(400);  
10.	     }catch(Exception e){System.out.println(e);}  
11.	   }  
12.	  
13.	 }  
14.	}  
15.	  
16.	class MyThread1 extends Thread{  
17.	Table t;  
18.	MyThread1(Table t){  
19.	this.t=t;  
20.	}  
21.	public void run(){  
22.	t.printTable(5);  
23.	}  
24.	  
25.	}  
26.	class MyThread2 extends Thread{  
27.	Table t;  
28.	MyThread2(Table t){  
29.	this.t=t;  
30.	}  
31.	public void run(){  
32.	t.printTable(100);  
33.	}  
34.	}  
35.	  
36.	class Use{  
37.	public static void main(String args[]){  
38.	Table obj = new Table();//only one object  
39.	MyThread1 t1=new MyThread1(obj);  
40.	MyThread2 t2=new MyThread2(obj);  
41.	t1.start();  
42.	t2.start();  
43.	}  
}
```
________________________________________

#### Same Example of synchronized method by using annonymous class

In this program, we have created the two threads by annonymous class, so less coding is required.
```java
1.	<b><i>//Program of synchronized method by using annonymous class</i></b>  
2.	  
3.	Class Table{  
4.	  
5.	 synchronized void printTable(int n){//synchronized method  
6.	   for(int i=1;i<=5;i++){  
7.	     System.out.println(n*i);  
8.	     try{  
9.	      Thread.sleep(400);  
10.	     }catch(Exception e){System.out.println(e);}  
11.	   }  
12.	  
13.	 }  
14.	}  
15.	  
16.	class Use{  
17.	public static void main(String args[]){  
18.	final Table obj = new Table();//only one object  
19.	  
20.	MyThread1 t1=new MyThread1(){  
21.	public void run(){  
22.	obj.printTable(5);  
23.	}  
24.	};  
25.	MyThread1 t2=new MyThread1(){  
26.	public void run(){  
27.	obj.printTable(100);  
28.	}  
29.	};  
30.	  
31.	t1.start();  
32.	t2.start();  
33.	}  
}
```
#### Synchronized block

Synchronized block can be used to perform synchronization on any specific resouce of the method.
Suppose you have 50 lines of code in your method, but you want to synchronize only 5 lines, you can use synchronized block.
If you put all the codes of the method in the synchronized block, it will work same as the synchronized method.
Points to remember for Synchronized block
•	Synchronized block is used to lock an object for any shared resource.
•	Scope of synchronized block is smaller than the method.
Syntax to use synchronized block
1.	synchronized (object reference expression) {   
2.	  //code block   
3.	}
4.	
#### Example of synchronized block

Let's see the simple example of synchronized block.
```java
1.	<b><i>//Program of synchronized block</i></b>  
2.	  
3.	class Table{  
4.	  
5.	 void printTable(int n){  
6.	   synchronized(this){//synchronized block  
7.	     for(int i=1;i<=5;i++){  
8.	      System.out.println(n*i);  
9.	      try{  
10.	       Thread.sleep(400);  
11.	      }catch(Exception e){System.out.println(e);}  
12.	     }  
13.	   }  
14.	 }//end of the method  
15.	}  
16.	  
17.	class MyThread1 extends Thread{  
18.	Table t;  
19.	MyThread1(Table t){  
20.	this.t=t;  
21.	}  
22.	public void run(){  
23.	t.printTable(5);  
24.	}  
25.	  
26.	}  
27.	class MyThread2 extends Thread{  
28.	Table t;  
29.	MyThread2(Table t){  
30.	this.t=t;  
31.	}  
32.	public void run(){  
33.	t.printTable(100);  
34.	}  
35.	}  
36.	  
37.	class Use{  
38.	public static void main(String args[]){  
39.	Table obj = new Table();//only one object  
40.	MyThread1 t1=new MyThread1(obj);  
41.	MyThread2 t2=new MyThread2(obj);  
42.	t1.start();  
43.	t2.start();  
44.	}  
45.	}
```
________________________________________

#### Same Example of synchronized block by using annonymous class:

```java
1.	<b><i>//Program of synchronized block by using annonymous class</i></b>  
2.	  
3.	class Table{  
4.	  
5.	void printTable(int n){  
6.	   synchronized(this){//synchronized block  
7.	     for(int i=1;i<=5;i++){  
8.	      System.out.println(n*i);  
9.	      try{  
10.	       Thread.sleep(400);  
11.	      }catch(Exception e){System.out.println(e);}  
12.	     }  
13.	   }  
14.	}//end of the method  
15.	}  
16.	  
17.	class Use{  
18.	public static void main(String args[]){  
19.	final Table obj = new Table();//only one object  
20.	  
21.	Thread t1=new Thread(){  
22.	public void run(){  
23.	obj.printTable(5);  
24.	}  
25.	};  
26.	Thread t2=new Thread(){  
27.	public void run(){  
28.	obj.printTable(100);  
29.	}  
30.	};  
31.	  
32.	t1.start();  
33.	t2.start();  
34.	}  
35.	}
```
#### Static synchronization

If you make any static method as synchronized, the lock will be on the class not on object.
 
#### Problem without static synchronization

Suppose there are two objects of a shared class(e.g. Table) named object1 and object2.In case of synchonized method and synchronized block there cannot be inteference between t1 and t2 or t3 and t4 because t1 and t2 both refers to a common object that have a single lock.But there can be interference between t1 and t3 or t2 and t4 because t1 acquires another lock and t3 acquires another lock.I want no interference between t1 and t3 or t2 and t4.Static synchronization solves this problem.
Example of static synchronization
In this example we are applying synchronized keyword on the static method to perform statis synchrnization.
```java
1.	class Table{  
2.	  
3.	 synchronized static void printTable(int n){  
4.	   for(int i=1;i<=10;i++){  
5.	     System.out.println(n*i);  
6.	     try{  
7.	       Thread.sleep(400);  
8.	     }catch(Exception e){}  
9.	   }  
10.	 }  
11.	}  
12.	  
13.	class MyThread1 extends Thread{  
14.	public void run(){  
15.	Table.printTable(1);  
16.	}  
17.	}  
18.	  
19.	class MyThread2 extends Thread{  
20.	public void run(){  
21.	Table.printTable(10);  
22.	}  
23.	}  
24.	  
25.	class MyThread3 extends Thread{  
26.	public void run(){  
27.	Table.printTable(100);  
28.	}  
29.	}  
30.	  
31.	  
32.	  
33.	  
34.	class MyThread4 extends Thread{  
35.	public void run(){  
36.	Table.printTable(1000);  
37.	}  
38.	}  
39.	  
40.	class Use{  
41.	public static void main(String t[]){  
42.	MyThread1 t1=new MyThread1();  
43.	MyThread2 t2=new MyThread2();  
44.	MyThread3 t3=new MyThread3();  
45.	MyThread4 t4=new MyThread4();  
46.	t1.start();  
47.	t2.start();  
48.	t3.start();  
49.	t4.start();  
50.	}  
51.	}  
```
________________________________________

#### Same example of static synchronization by annonymous class

In this example, we are using annonymous class to create the threads.
```java
1.	class Table{  
2.	  
3.	 synchronized static  void printTable(int n){  
4.	   for(int i=1;i<=10;i++){  
5.	     System.out.println(n*i);  
6.	     try{  
7.	       Thread.sleep(400);  
8.	     }catch(Exception e){}  
9.	   }  
10.	 }  
11.	}  
12.	  
13.	public class Test {  
14.	public static void main(String[] args) {  
15.	      
16.	    Thread t1=new Thread(){  
17.	        public void run(){  
18.	            Table.printTable(1);  
19.	        }  
20.	    };  
21.	      
22.	    Thread t2=new Thread(){  
23.	        public void run(){  
24.	            Table.printTable(10);  
25.	        }  
26.	    };  
27.	      
28.	    Thread t3=new Thread(){  
29.	        public void run(){  
30.	            Table.printTable(100);  
31.	        }  
32.	    };  
33.	      
34.	    Thread t4=new Thread(){  
35.	        public void run(){  
36.	            Table.printTable(1000);  
37.	        }  
38.	    };  
39.	    t1.start();  
40.	    t2.start();  
41.	    t3.start();  
42.	    t4.start();  
43.	      
44.	}  
45.	}  
```
________________________________________

#### Synchronized block on a class lock:

The block synchronizes on the lock of the object denoted by the reference .class name .class. A static synchronized method printTable(int n) in class Table is equivalent to the following declaration:
1.	static void printTable(int n) {  
2.	    synchronized (Table.class) {       // Synchronized block on class A  
3.	        // ...  
4.	    }  
5.	}
6.	
#### Deadlock:

Deadlock can occur in a situation when a thread is waiting for an object lock, that is acquired by another thread and second thread is waiting for an object lock that is acquired by first thread. Since, both threads are waiting for each other to release the lock, the condition is called daedlock.
 
Example of Deadlock in java:
```java
1.	public class DeadlockExample {  
2.	  public static void main(String[] args) {  
3.	    final String resource1 = "ratan jaiswal";  
4.	    final String resource2 = "vimal jaiswal";  
5.	    // t1 tries to lock resource1 then resource2  
6.	    Thread t1 = new Thread() {  
7.	      public void run() {  
8.	          synchronized (resource1) {  
9.	           System.out.println("Thread 1: locked resource 1");  
10.	  
11.	           try { Thread.sleep(100);} catch (Exception e) {}  
12.	  
13.	           synchronized (resource2) {  
14.	            System.out.println("Thread 1: locked resource 2");  
15.	           }  
16.	         }  
17.	      }  
18.	    };  
19.	  
20.	    // t2 tries to lock resource2 then resource1  
21.	    Thread t2 = new Thread() {  
22.	      public void run() {  
23.	        synchronized (resource2) {  
24.	          System.out.println("Thread 2: locked resource 2");  
25.	  
26.	          try { Thread.sleep(100);} catch (Exception e) {}  
27.	  
28.	          synchronized (resource1) {  
29.	            System.out.println("Thread 2: locked resource 1");  
30.	          }  
31.	        }  
32.	      }  
33.	    };  
34.	  
35.	      
36.	    t1.start();  
37.	    t2.start();  
38.	  }  
39.	}  
40.
```

#### Inter-thread communication in Java

Inter-thread communication or Co-operation is all about allowing synchronized threads to communicate with each other.
Cooperation (Inter-thread communication) is a mechanism in which a thread is paused running in its critical section and another thread is allowed to enter (or lock) in the same critical section to be executed.It is implemented by following methods of Object class:
•	wait()
•	notify()
•	notifyAll()
________________________________________
- 1) wait() method
Causes current thread to release the lock and wait until either another thread invokes the notify() method or the notifyAll() method for this object, or a specified amount of time has elapsed.
The current thread must own this object's monitor, so it must be called from the synchronized method only otherwise it will throw exception.
Method	Description
public final void wait()throws InterruptedException	waits until object is notified.
public final void wait(long timeout)throws InterruptedException	waits for the specified amount of time.
________________________________________
- 2) notify() method
Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, one of them is chosen to be awakened. The choice is arbitrary and occurs at the discretion of the implementation. Syntax:
public final void notify()
________________________________________
3) notifyAll() method
Wakes up all threads that are waiting on this object's monitor. Syntax:
public final void notifyAll()
________________________________________

#### Understanding the process of inter-thread communication
 
The point to point explanation of the above diagram is as follows:
1.	Threads enter to acquire lock.
2.	Lock is acquired by on thread.
3.	Now thread goes to waiting state if you call wait() method on the object. Otherwise it releases the lock and exits.
4.	If you call notify() or notifyAll() method, thread moves to the notified state (runnable state).
5.	Now thread is available to acquire lock.
6.	After completion of the task, thread releases the lock and exits the monitor state of the object.
________________________________________

#### Why wait(), notify() and notifyAll() methods are defined in Object class not Thread class?

It is because they are related to lock and object has a lock.
________________________________________

#### Difference between wait and sleep?

Let's see the important differences between wait and sleep methods.
wait()	sleep()
wait() method releases the lock	sleep() method doesn't release the lock.
is the method of Object class	is the method of Thread class
is the non-static method	is the static method
is the non-static method	is the static method
should be notified by notify() or notifyAll() methods	after the specified amount of time, sleep is completed.
________________________________________

#### Example of inter thread communication in java

Let's see the simple example of inter thread communication.
```java
1.	class Customer{  
2.	int amount=10000;  
3.	  
4.	synchronized void withdraw(int amount){  
5.	System.out.println("going to withdraw...");  
6.	  
7.	if(this.amount<amount){  
8.	System.out.println("Less balance; waiting for deposit...");  
9.	try{wait();}catch(Exception e){}  
10.	}  
11.	this.amount-=amount;  
12.	System.out.println("withdraw completed...");  
13.	}  
14.	  
15.	synchronized void deposit(int amount){  
16.	System.out.println("going to deposit...");  
17.	this.amount+=amount;  
18.	System.out.println("deposit completed... ");  
19.	notify();  
20.	}  
21.	}  
22.	  
23.	class Test{  
24.	public static void main(String args[]){  
25.	final Customer c=new Customer();  
26.	new Thread(){  
27.	public void run(){c.withdraw(15000);}  
28.	}.start();  
29.	new Thread(){  
30.	public void run(){c.deposit(10000);}  
31.	}.start();  
32.	  
33.	}}  
```
#### Interrupting a Thread:

If any thread is in sleeping or waiting state (i.e. sleep() or wait() is invoked), calling the interrupt() method on the thread, breaks out the sleeping or waiting state throwing InterruptedException. If the thread is not in the sleeping or waiting state, calling the interrupt() method performs normal behaviour and doesn't interrupt the thread but sets the interrupt flag to true. Let's first see the methods provided by the Thread class for thread interruption.
________________________________________

#### The 3 methods provided by the Thread class for interrupting a thread

•	public void interrupt()
•	public static boolean interrupted()
•	public boolean isInterrupted()
________________________________________

#### Example of interrupting a thread that stops working

In this example, after interrupting the thread, we are propagating it, so it will stop working. If we don't want to stop the thread, we can handle it where sleep() or wait() method is invoked. Let's first see the example where we are propagating the exception.
```java
1.	class A extends Thread{  
2.	public void run(){  
3.	try{  
4.	Thread.sleep(1000);  
5.	System.out.println("task");  
6.	}catch(InterruptedException e){  
7.	throw new RuntimeException("Thread interrupted..."+e);  
8.	}  
9.	  
10.	}  
11.	  
12.	public static void main(String args[]){  
13.	A t1=new A();  
14.	t1.start();  
15.	try{  
16.	t1.interrupt();  
17.	}catch(Exception e){System.out.println("Exception handled "+e);}  
18.	  
19.	}  
20.	}
```
download this example
1.	<strong>Output:</strong>Exception in thread-0    
2.	       java.lang.RuntimeException: Thread interrupted...  
3.	       java.lang.InterruptedException: sleep interrupted  
4.	       at A.run(A.java:7)  
________________________________________

#### Example of interrupting a thread that doesn't stop working

In this example, after interrupting the thread, we handle the exception, so it will break out the sleeping but will not stop working.
```java
1.	class A extends Thread{  
2.	public void run(){  
3.	try{  
4.	Thread.sleep(1000);  
5.	System.out.println("task");  
6.	}catch(InterruptedException e){  
7.	System.out.println("Exception handled "+e);  
8.	}  
9.	System.out.println("thread is running...");  
10.	}  
11.	  
12.	public static void main(String args[]){  
13.	A t1=new A();  
14.	t1.start();  
15.	  
16.	t1.interrupt();  
17.	  
18.	}  
19.	}
```
download this example
1.	<strong>Output:</strong>Exception handled    
2.	       java.lang.InterruptedException: sleep interrupted  
3.	       thread is running...  
________________________________________

#### Example of interrupting thread that behaves normally

If thread is not in sleeping or waiting state, calling the interrupt() method sets the interrupted flag to true that can be used to stop the thread by the java programmer later.
```java
1.	class A extends Thread{  
2.	  
3.	public void run(){  
4.	for(int i=1;i<=5;i++)  
5.	System.out.println(i);  
6.	}  
7.	  
8.	public static void main(String args[]){  
9.	A t1=new A();  
10.	t1.start();  
11.	  
12.	t1.interrupt();  
13.	  
14.	}  
15.	}
```
1.	<strong>Output:</strong>1  
2.	       2  
3.	       3  
4.	       4   
5.	       5  
________________________________________

#### What about isInterrupted and interrupted method?

The isInterrupted() method returns the interrupted flag either true or false. The static interrupted() method returns the interrupted flag afterthat it sets the flag to false if it is true.
```java
1.	class InterruptedDemo extends Thread{  
2.	  
3.	public void run(){  
4.	for(int i=1;i<=2;i++){  
5.	if(Thread.interrupted()){  
6.	System.out.println("code for interrupted thread");  
7.	}  
8.	else{  
9.	System.out.println("code for normal thread");  
10.	}  
11.	  
12.	}//end of for loop  
13.	}  
14.	  
15.	public static void main(String args[]){  
16.	  
17.	InterruptedDemo t1=new InterruptedDemo();  
18.	InterruptedDemo t2=new InterruptedDemo();  
19.	  
20.	t1.start();  
21.	t1.interrupt();  
22.	  
23.	t2.start();  
24.	  
25.	}  
26.	}
```
1.	<strong>Output:</strong>Code for interrupted thread  
2.	       code for normal thread  
3.	       code for normal thread  
4.	       code for normal thread  

#### Reentrant Monitor in Java

According to Sun Microsystems, Java monitors are reentrant means java thread can reuse the same monitor for different synchronized methods if method is called from the method.
________________________________________

#### Advantage of Reentrant Monitor

It eliminates the possibility of single thread deadlocking
________________________________________
Let's understand the java reentrant monitor by the example given below:
```java
1.	class Reentrant {  
2.	    public synchronized void m() {  
3.	    n();  
4.	    System.out.println("this is m() method");  
5.	    }  
6.	    public synchronized void n() {  
7.	    System.out.println("this is n() method");  
8.	    }  
9.	}
```
In this class, m and n are the synchronized methods. The m() method internally calls the n() method.
Now let's call the m() method on a thread. In the class given below, we are creating thread using annonymous class.
```java
1.	class ReentrantExample{  
2.	public static void main(String args[]){  
3.	final Reentrant re=new Reentrant();  
4.	  
5.	Thread t1=new Thread(){  
6.	public void run(){  
7.	re.m();//calling method of Reentrant class  
8.	}  
9.	};  
10.	t1.start();  
11.	}}  
```
#### Thread Pooling in Java

Thread pool represents a group of worker threads that are waiting for the job. Here, threads are executed whenever they get the job.
In case of thread pool, a group of fixed size threads are created. A thread from the thread pool is pulled out and assigned a job by the service provider. After completion of the job, thread is contained in the thread pool again.

#### Advantage of Thread Pool

Better performance It saves time because there is no need to create new thread.
Where is it used?
It is used in Servlet and JSP where container creates a thread pool to process the request.

#### Example of Java Thread Pool

Let's see a simple example of java thread pool using executors and ThreadPoolExecutor.
```java
1.	import java.util.concurrent.ExecutorService;  
2.	import java.util.concurrent.Executors;  
3.	class WorkerThread implements Runnable {  
4.	    private String message;  
5.	    public WorkerThread(String s){  
6.	        this.message=s;  
7.	    }  
8.	   
9.	    public void run() {  
10.	        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
11.	        processmessage();  
12.	        System.out.println(Thread.currentThread().getName()+" (End)");  
13.	    }  
14.	  
15.	    private void processmessage() {  
16.	        try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
17.	    }  
18.	}  
19.	  
20.	public class SimpleThreadPool {  
21.	     public static void main(String[] args) {  
22.	        ExecutorService executor = Executors.newFixedThreadPool(5);  
23.	        for (int i = 0; i < 10; i++) {  
24.	            Runnable worker = new WorkerThread("" + i);  
25.	            executor.execute(worker);  
26.	          }  
27.	        executor.shutdown();  
28.	        while (!executor.isTerminated()) {   }  
29.	  
30.	        System.out.println("Finished all threads");  
31.	    }  
32.	   
33.	}
```
download this example
Output:
1.	pool-1-thread-1 (Start) message = 0  
2.	pool-1-thread-2 (Start) message = 1  
3.	pool-1-thread-3 (Start) message = 2  
4.	pool-1-thread-5 (Start) message = 4  
5.	pool-1-thread-4 (Start) message = 3  
6.	pool-1-thread-2 (End)  
7.	pool-1-thread-2 (Start) message = 5  
8.	pool-1-thread-1 (End)  
9.	pool-1-thread-1 (Start) message = 6  
10.	pool-1-thread-3 (End)  
11.	pool-1-thread-3 (Start) message = 7  
12.	pool-1-thread-4 (End)  
13.	pool-1-thread-4 (Start) message = 8  
14.	pool-1-thread-5 (End)  
15.	pool-1-thread-5 (Start) message = 9  
16.	pool-1-thread-2 (End)  
17.	pool-1-thread-1 (End)  
18.	pool-1-thread-4 (End)  
19.	pool-1-thread-3 (End)  
20.	pool-1-thread-5 (End)  
21.	Finished all threads

#### Can we start a thread twice?

No. After staring a thread, it can never be started again. If you does so, an IllegalThreadStateException is thrown. For Example:
```java
1.	class Multi extends Thread{  
2.	 public void run(){  
3.	   System.out.println("running...");  
4.	 }  
5.	 public static void main(String args[]){  
6.	  Multi t1=new Multi();  
7.	  t1.start();  
8.	  t1.start();  
9.	 }  
10.	}
```
1.	<strong>Output:</strong>running  
2.	       Exception in thread "main" java.lang.IllegalThreadStateException
3.	    
#### What if we call run() method directly instead start() method?

•	Each thread starts in a separate call stack.
•	Invoking the run() method from main thread, the run() method goes onto the current call stack rather than at the beginning of a new call stack.
```java
1.	class Multi extends Thread{  
2.	 public void run(){  
3.	   System.out.println("running...");  
4.	 }  
5.	 public static void main(String args[]){  
6.	  Multi t1=new Multi();  
7.	  t1.run();//fine, but does not start a separate call stack  
8.	 }  
9.	}
```
1.	<strong>Output:</strong>running...

#### The join() method:

The join() method waits for a thread to die. In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task.
Syntax:
public void join()throws InterruptedException
public void join(long miliseconds)throws InterruptedException
```java
1.	//<b><i>Example of join() method</i></b>  
2.	  
3.	class Multi extends Thread{  
4.	 public void run(){  
5.	  for(int i=1;i<=5;i++){  
6.	   try{  
7.	    Thread.sleep(500);  
8.	   }catch(Exception e){System.out.println(e);}  
9.	  System.out.println(i);  
10.	  }  
11.	 }  
12.	public static void main(String args[]){  
13.	 Multi t1=new Multi();  
14.	 Multi t2=new Multi();  
15.	 Multi t3=new Multi();  
16.	 t1.start();  
17.	 try{  
18.	  t1.join();  
19.	 }catch(Exception e){System.out.println(e);}  
20.	  
21.	 t2.start();  
22.	 t3.start();  
23.	 }  
24.	}  
```
As you can see in the above example,when t1 completes its task then t2 and t3 starts executing.
```java
1.	//<b><i>Example of join(long miliseconds) method</i></b>  
2.	  
3.	class Multi extends Thread{  
4.	 public void run(){  
5.	  for(int i=1;i<=5;i++){  
6.	   try{  
7.	    Thread.sleep(500);  
8.	   }catch(Exception e){System.out.println(e);}  
9.	  System.out.println(i);  
10.	  }  
11.	 }  
12.	public static void main(String args[]){  
13.	 Multi t1=new Multi();  
14.	 Multi t2=new Multi();  
15.	 Multi t3=new Multi();  
16.	 t1.start();  
17.	 try{  
18.	  t1.join(1500);  
19.	 }catch(Exception e){System.out.println(e);}  
20.	  
21.	 t2.start();  
22.	 t3.start();  
23.	 }  
24.	}  
```
In the above example,when t1 is completes its task for 1500 miliseconds(3 times) then t2 and t3 starts executing.
________________________________________

#### getName(),setName(String) and getId() method:

public String getName()
public void setName(String name)
public long getId()
```java
1.	class Multi6 extends Thread{  
2.	  public void run(){  
3.	   System.out.println("running...");  
4.	  }  
5.	 public static void main(String args[]){  
6.	  Multi6 t1=new Multi6();  
7.	  Multi6 t2=new Multi6();  
8.	  System.out.println("Name of t1:"+t1.getName());  
9.	  System.out.println("Name of t2:"+t2.getName());  
10.	  System.out.println("id of t1:"+t1.getId());  
11.	  
12.	  t1.start();  
13.	  t2.start();  
14.	  
15.	  t1.setName("Sonoo Jaiswal");  
16.	  System.out.println("After changing name of t1:"+t1.getName());  
17.	 }  
18.	}  
```
________________________________________

#### The currentThread() method:
The currentThread() method returns a reference to the currently executing thread object.
Syntax:
public static Thread currentThread()
```java
1.	//<b><i>Example of currentThread() method</i></b>  
2.	  
3.	class Multi6 extends Thread{  
4.	 public void run(){  
5.	  System.out.println(Thread.currentThread().getName());  
6.	 }  
7.	 }  
8.	 public static void main(String args[]){  
9.	  Multi6 t1=new Multi6();  
10.	  Multi6 t2=new Multi6();  
11.	  
12.	  t1.start();  
13.	  t2.start();  
14.	 }  
15.	}  
```
#### Garbage Collection:

In java, garbage means unreferenced objects.
Garbage Collection is process of reclaiming the runtime unused memory automatically.
Advantage of Garbage Collection:
•	It makes java memory efficient because garbage collector removes the unreferenced objects from heap memory.
•	It is automatically done by the garbage collector so we don't need to make extra efforts.
________________________________________

#### How can an object be unreferenced?

There are many ways:
•	By nulling the reference
•	By assigning a reference to another
•	By annonymous object etc.
1) By nulling a reference:
1.	Employee e=new Employee();  
2.	e=null;  
2) By assigning a reference to another:
1.	Employee e1=new Employee();  
2.	Employee e2=new Employee();  
3.	  
4.	e1=e2;//now the first object refered by e1 is available for garbage collection  
3) By annonymous object:
1.	new Employee();  
________________________________________

#### finalize() method:

The finalize() method is invoked each time before the object is garbage collected. This method can be used to perform cleanup processing. This method is defined in System class as:
1.	protected void finalize(){}  
Note: The Garbage collector of JVM collects only those objects that are created by new keyword. So if you have created any object without new, you can use finalize method to perform cleanup processing (destroying remaining objects).
________________________________________

#### gc() method:

The gc() method is used to invoke the garbage collector to perform cleanup processing. The gc() is found in System and Runtime classes.
1.	public static void gc(){}  
Note: Garbage collection is performed by a daemon thread called Garbage Collector(GC). This thread calls the finalize() method before object is garbage collected.
________________________________________

#### Simple Example of garbage collection:

```java
1.	class Simple{  
2.	  
3.	 public void finalize(){System.out.println("object is garbage collected");}  
4.	  
5.	 public static void main(String args[]){  
6.	  Simple s1=new Simple();  
7.	  Simple s2=new Simple();  
8.	  s1=null;  
9.	  s2=null;  
10.	  System.gc();  
11.	 }  
12.	}  
``` 
Note: Neither finalization nor garbage collection is guaranteed.

#### Aggregation in Java

If a class have an entity reference, it is known as Aggregation. Aggregation represents HAS-A relationship.
Consider a situation, Employee object contains many informations such as id, name, emailId etc. It contains one more object named address, which contains its own informations such as city, state, country, zipcode etc. as given below.
1.	class Employee{  
2.	int id;  
3.	String name;  
4.	Address address;//Address is a class  
5.	...  
6.	}  
In such case, Employee has an entity reference address, so relationship is Employee HAS-A address.
Why use Aggregation?
•	For Code Reusability.
________________________________________
#### Simple Example of Aggregation
 
In this example, we have created the reference of Operation class in the Circle class.
```java
1.	class Operation{  
2.	 int square(int n){  
3.	  return n*n;  
4.	 }  
5.	}  
6.	  
7.	class Circle{  
8.	 Operation op;//aggregation  
9.	 double pi=3.14;  
10.	    
11.	 double area(int radius){  
12.	   op=new Operation();  
13.	   int rsquare=op.square(radius);//code reusability (i.e. delegates the method call).  
14.	   return pi*rsquare;  
15.	 }  
16.	  
17.	     
18.	    
19.	 public static void main(String args[]){  
20.	   Circle c=new Circle();  
21.	   double result=c.area(5);  
22.	   System.out.println(result);  
23.	 }  
24.	}
```
Output:78.5
      
#### When use Aggregation?

•	Code reuse is also best achieved by aggregation when there is no is-a relationship.
•	Inheritance should be used only if the relationship is-a is maintained throughout the lifetime of the objects involved; otherwise, aggregation is the best choice.
________________________________________

#### Understanding meaningful example of Aggregation

In this example, Employee has an object of Address, address object contains its own informations such as city, state, country etc. In such case relationship is Employee HAS-A address.
Address.java
```java
1.	public class Address {  
2.	String city,state,country;  
3.	  
4.	public Address(String city, String state, String country) {  
5.	    this.city = city;  
6.	    this.state = state;  
7.	    this.country = country;  
8.	}  
9.	  
10.	}
```
Emp.java
```java
1.	public class Emp {  
2.	int id;  
3.	String name;  
4.	Address address;  
5.	  
6.	public Emp(int id, String name,Address address) {  
7.	    this.id = id;  
8.	    this.name = name;  
9.	    this.address=address;  
10.	}  
11.	  
12.	void display(){  
13.	System.out.println(id+" "+name);  
14.	System.out.println(address.city+" "+address.state+" "+address.country);  
15.	}  
16.	  
17.	public static void main(String[] args) {  
18.	Address address1=new Address("gzb","UP","india");  
19.	Address address2=new Address("gno","UP","india");  
20.	  
21.	Emp e=new Emp(111,"varun",address1);  
22.	Emp e2=new Emp(112,"arun",address2);  
23.	      
24.	e.display();  
25.	e2.display();  
26.	      
27.	}  
28.	}
```
Output:111 varun
       gzb UP india
       112 arun
       gno UP india      
       
#### Inheritance in Java

1.	Inheritance
2.	Types of Inheritance
3.	Why multiple inheritance is not possible in java in case of class?
Inheritance is a mechanism in which one object acquires all the properties and behaviours of parent object.
The idea behind inheritance is that you can create new classes that are built upon existing classes. When you inherit from an existing class, you reuse (or inherit) methods and fields, and you add new methods and fields to adapt your new class to new situations.
Inheritance represents the IS-A relationship.

#### Why use Inheritance?

•	For Method Overriding (So Runtime Polymorphism).
•	For Code Reusability.
Syntax of Inheritance
1.	class Subclass-name extends Superclass-name  
2.	{  
3.	   //methods and fields  
4.	}  
The keyword extends indicates that you are making a new class that derives from an existing class. In the terminology of Java, a class that is inherited is called a superclass. The new class is called a subclass.
________________________________________
#### Understanding the simple example of inheritance
 
As displayed in the above figure, Programmer is the subclass and Employee is the superclass. Relationship between two classes is Programmer IS-A Employee.It means that Programmer is a type of Employee.
```java
1.	class Employee{  
2.	 float salary=40000;  
3.	}  
4.	  
5.	class Programmer extends Employee{  
6.	 int bonus=10000;  
7.	    
8.	 public static void main(String args[]){  
9.	   Programmer p=new Programmer();  
10.	   System.out.println("Programmer salary is:"+p.salary);  
11.	   System.out.println("Bonus of Programmer is:"+p.bonus);  
12.	}  
13.	}
```
Output:Programmer salary is:40000.0
       Bonus of programmer is:10000
      
In the above example,Programmer object can access the field of own class as well as of Employee class i.e. code reusability.
#### Types of Inheritance

On the basis of class, there can be three types of inheritance: single, multilevel and hierarchical.
Multiple and Hybrid is supported through interface only. We will learn about interfaces later.
 
Multiple inheritance is not supported in java in case of class.
When a class extends multiple classes i.e. known as multiple inheritance. For Example:
 
#### Que) Why multiple inheritance is not supported in java?

•	To reduce the complexity and simplify the language, multiple inheritance is not supported in java. For example:
```java
1.	class A{  
2.	void msg(){System.out.println("Hello");}  
3.	}  
4.	  
5.	class B{  
6.	void msg(){System.out.println("Welcome");}  
7.	}  
8.	  
9.	class C extends A,B{//suppose if it were  
10.	   
11.	 Public Static void main(String args[]){  
12.	   C obj=new C();  
13.	   obj.msg();//Now which msg() method would be invoked?  
14.	}  
15.	}
``` 
#### Object class in Java

The Object class is the parent class of all the classes in java bydefault. In other words, it is the topmost class of java.
The Object class is beneficial if you want to refer any object whose type you don't know. Notice that parent class reference variable can refer the child class object, know as upcasting.
Let's take an example, there is getObject() method that returns an object but it can be of any type like Employee,Student etc, we can use Object class reference to refer that object. For example:
1.	Object obj=getObject();//we don't what object would be returned from this method  
The Object class provides some common behaviours to all the objects such as object can be compared, object can be cloned, object can be notified etc.
 
#### Methods of Object class

The Object class provides many methods. They are as follows:
Method	Description
public final Class getClass()	returns the Class class object of this object. The Class class can further be used to get the metadata of this class.
public int hashCode()	returns the hashcode number for this object.
public boolean equals(Object obj)	compares the given object to this object.
protected Object clone() throws CloneNotSupportedException	creates and returns the exact copy (clone) of this object.
public String toString()	returns the string representation of this object.
public final void notify()	wakes up single thread, waiting on this object's monitor.
public final void notifyAll()	wakes up all the threads, waiting on this object's monitor.
public final void wait(long timeout)throws InterruptedException	causes the current thread to wait for the specified milliseconds, until another thread notifies (invokes notify() or notifyAll() method).
public final void wait(long timeout,int nanos)throws InterruptedException	causes the current thread to wait for the specified miliseconds and nanoseconds, until another thread notifies (invokes notify() or notifyAll() method).
public final void wait()throws InterruptedException	causes the current thread to wait, until another thread notifies (invokes notify() or notifyAll() method).
protected void finalize()throws Throwable	is invoked by the garbage collector before object is being garbage collected.

#### Object Cloning in Java

 The object cloning is a way to create exact copy of an object. For this purpose, clone() method of Object class is used to clone an object.
The java.lang.Cloneable interface must be implemented by the class whose object clone we want to create. If we don't implement Cloneable interface, clone() method generatesCloneNotSupportedException.
The clone() method is defined in the Object class. Syntax of the clone() method is as follows:
1.	protected Object clone() throws CloneNotSupportedException  
Why use clone() method ?
The clone() method saves the extra processing task for creating the exact copy of an object. If we perform it by using the new keyword, it will take a lot of processing to be performed that is why we use object cloning.

#### Advantage of Object cloning

Less processing task.
Example of clone() method (Object cloning)
Let's see the simple example of object cloning
```java
1.	class Student implements Cloneable{  
2.	int rollno;  
3.	String name;  
4.	  
5.	Student(int rollno,String name){  
6.	this.rollno=rollno;  
7.	this.name=name;  
8.	}  
9.	  
10.	public Object clone()throws CloneNotSupportedException{  
11.	return super.clone();  
12.	}  
13.	  
14.	public static void main(String args[]){  
15.	try{  
16.	Student s1=new Student(101,"amit");  
17.	  
18.	Student s2=(Student)s1.clone();  
19.	  
20.	System.out.println(s1.rollno+" "+s1.name);  
21.	System.out.println(s2.rollno+" "+s2.name);  
22.	  
23.	}catch(CloneNotSupportedException c){}  
24.	  
25.	}  
26.	}
```
Output:101 amit
       101 amit
#### download the example of object cloning

As you can see in the above example, both reference variables have the same value. Thus, the clone() copies the values of an object to another. So we don't need to write explicit code to copy the value of an object to another.
If we create another object by new keyword and assign the values of another object to this one, it will require a lot of processing on this object. So to save the extra processing task we use clone() method.
#### Exception Handling in Java

1.	Exception Handling
2.	Advantage of Exception Handling
3.	Hierarchy of Exception classes
4.	Types of Exception
1.	Checked Exception
2.	Unchecked Exception
3.	Error
5.	Scenarios where exception may occur
The exception handling is one of the powerful mechanism provided in java. It provides the mechanism to handle the runtime errors so that normal flow of the application can be maintained.
In this page, we will know about exception, its type and the difference between checked and unchecked exceptions.

#### Exception

•	Dictionary Meaning:Exception is an abnormal condition.
•	In java, exception is an event that disrupts the normal flow of the program. It is an object which is thrown at runtime.
#### Exception Handling

Exception Handling is a mechanism to handle runtime errors.
#### Advantage of Exception Handling

The core advantage of exception handling is that normal flow of the application is maintained. Exception normally disrupts the normal flow of the application that is why we use exception handling. Let's take a scenario:
1.	statement 1;  
2.	statement 2;  
3.	statement 3;  
4.	statement 4;  
5.	statement 5;  
6.	statement 6;  
7.	statement 7;  
8.	statement 8;  
9.	statement 9;  
10.	statement 10;  
Suppose there is 10 statements in your program and there occurs an exception at statement 5, rest of the code will not be executed i.e. statement 6 to 10 will not run. If we perform exception handling, rest of the exception will be executed. That is why we use exception handling.

#### Do You Know ?

•	What is the difference between checked and unchecked exceptions ?
•	What happens behind the code int data=50/0; ?
•	Why use multiple catch block ?
•	Is there any possibility when finally block is not executed ?
•	What is exception propagation ?
•	What is the difference between throw and throws keyword ?
•	What are the 4 rules for using exception handling with method overriding ?
Hierarchy of Exception classes
 
________________________________________
#### Types of Exception:

There are mainly two types of exceptions: checked and unchecked where error is considered as unchecked exception. The sun microsystem says there are three types of exceptions:
1.	Checked Exception
2.	Unchecked Exception
3.	Error
________________________________________
#### What is the difference between checked and unchecked exceptions ?

- 1)Checked Exception
The classes that extend Throwable class except RuntimeException and Error are known as checked exceptions e.g.IOException, SQLException etc. Checked exceptions are checked at compile-time.
- 2)Unchecked Exception
The classes that extend RuntimeException are known as unchecked exceptions e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc. Unchecked exceptions are not checked at compile-time rather they are checked at runtime.
- 3)Error
Error is irrecoverable e.g. OutOfMemoryError, VirtualMachineError, AssertionError etc.
________________________________________
#### Common scenarios of Exception Handling where exceptions may occur

There are given some scenarios where unchecked exceptions can occur. They are as follows:
- 1) Scenario where ArithmeticException occurs
If we divide any number by zero, there occurs an ArithmeticException.
1.	int a=50/0;//ArithmeticException  
________________________________________
- 2) Scenario where NullPointerException occurs
If we have null value in any variable, performing any operation by the variable occurs an NullPointerException.
1.	String s=null;  
2.	System.out.println(s.length());//NullPointerException  
________________________________________
- 3) Scenario where NumberFormatException occurs
The wrong formatting of any value, may occur NumberFormatException. Suppose I have a string variable that have characters, converting this variable into digit will occur NumberFormatException.
1.	String s="abc";  
2.	int i=Integer.parseInt(s);//NumberFormatException  
________________________________________
- 4) Scenario where ArrayIndexOutOfBoundsException occurs
If you are inserting any value in the wrong index, it would result ArrayIndexOutOfBoundsException as shown below:
1.	int a[]=new int[5];  
2.	a[10]=50; //ArrayIndexOutOfBoundsException

#### Nested classes in Java

1.	Nested classes
2.	Advantage of Nested classes
3.	Difference between nested class and inner class
4.	Types of Nested classes
A class declared inside a class is known as nested class. We use nested classes to logically group classes in one place so that it can be more readable and maintainable code. Moreover, it can access all the members of outer class including private members.
Syntax of Nested class
1.	class Outer_class_Name{  
2.	 ...  
3.	 class Nested_class_Name{  
4.	  ...  
5.	 }  
6.	 ...  
7.	}  
#### Advantage of nested classes

There are basically three advantages of nested classes. They are
•	Nested classes represent a special type of relationship that is it can access all the members (data members and methods) of outer class including private.
•	Nested classes can lead to more readable and maintainable code because it logically group classes in one place only.
•	Code Optimization as we need less code to write.
#### Do You Know ?

•	What is the internal code generated by the compiler for member inner class ?
•	What are the two ways to create annonymous inner class ?
•	Can we access the non-final local variable inside the local inner class ?
•	How to access the static nested class ?
•	Can we define an interface within the class ?
•	Can we define a class within the interface ?
Que) What is the difference between nested class and inner class?
Inner class is a part of nested class. Non-static nested classes are known as nested classes.
________________________________________
#### Types of Nested class:

There are two types of nested classes non-static and static nested classes.The non-static nested classes are also known as inner classes.
1.	non-static nested class(inner class)
o	a)Member inner class
o	b)Annomynous inner class
o	c)Local inner class
2.	static nested class
  
#### What we will learn in Nested classes ?

•	Nested class
•	Member inner class
•	Annonymous inner class
•	Local Inner class
•	static nested class
•	Nested interface
- 1)Member inner class
A class that is declared inside a class but outside a method is known as member inner class.
Invocation of Member Inner class
1.	From within the class
2.	From outside the class
Example of member inner class that is invoked inside a class
In this example, we are invoking the method of member inner class from the display method of Outer class.
```java
1.	class Outer{  
2.	 private int data=30;  
3.	 class Inner{  
4.	  void msg(){System.out.println("data is "+data);}  
5.	 }  
6.	   
7.	 void display(){  
8.	  Inner in=new Inner();  
9.	  in.msg();  
10.	 }  
11.	 public static void main(String args[]){  
12.	  Outer obj=new Outer();  
13.	  obj.display();  
14.	 }  
15.	}  
```
________________________________________
#### Internal code generated by the compiler for member inner class:

The java compiler creates a class file named Outer$Inner in this case. The Member inner class have the reference of Outer class that is why it can access all the data members of Outer class including private.
```java
1.	import java.io.PrintStream;  
2.	  
3.	class Outer$Inner  
4.	{  
5.	    final Outer this$0;  
6.	    Outer$Inner()  
7.	    {   super();  
8.	        this$0 = Outer.this;  
9.	    }  
10.	  
11.	    void msg()  
12.	    {  
13.	        System.out.println((new StringBuilder()).append("data is ")  
14.	                    .append(Outer.access$000(Outer.this)).toString());  
15.	    }  
16.	  
17.	 }  
```
________________________________________
#### Example of member inner class that is invoked outside a class

In this example, we are invoking the msg() method of Inner class from outside the outer class i.e. Test class.
```java
1.	<b><i>//Program of member inner class that is invoked outside a class</i></b>  
2.	  
3.	class Outer{  
4.	  private int data=30;  
5.	  class Inner{  
6.	   void msg(){System.out.println("data is"+data);}  
7.	  }  
8.	}  
9.	  
10.	class Test{  
11.	 public static void main(String args[]){  
12.	  Outer obj=new Outer();  
13.	  Outer.Inner in=obj.new Inner();  
14.	  in.msg();  
15.	  }  
16.	}  
```
- 2)Annonymous inner class
A class that have no name is known as annomymous inner class.
#### Annonymous class can be created by:

1.	Class (may be abstract class also).
2.	Interface
Program of annonymous inner class by abstract class
```java
1.	abstract class Person{  
2.	  abstract void eat();  
3.	}  
4.	  
5.	class Emp{  
6.	 public static void main(String args[]){  
7.	  Person p=new Person(){  
8.	  void eat(){System.out.println("nice fruits");}  
9.	  };  
10.	  
11.	  p.eat();  
12.	 }  
13.	}  
```
________________________________________
#### What happens behind this code?

```java
1.	  Person p=new Person(){  
2.	  void eat(){System.out.println("nice fruits");}  
3.	  };  
4.	  
5.	 }  
6.	}
```
1.	A class is created but its name is decided by the compiler which extends the Person class and provides the implementation of the eat() method.
2.	An object of Annonymous class is created that is reffered by p reference variable of Person type. As you know well that Parent class reference variable can refer the object of Child class.

The internal code generated by the compiler for annonymous inner class
```java
1.	import java.io.PrintStream;  
2.	static class Emp$1 extends Person  
3.	{  
4.	   Emp$1(){}  
5.	  
6.	   void eat()  
7.	    {  
8.	        System.out.println("nice fruits");  
9.	    }  
10.	}
```
________________________________________
#### Program of annonymous inner class by interface

```java
1.	interface Eatable{  
2.	 void eat();  
3.	}  
4.	  
5.	class Emp{  
6.	 public static void main(String args[]){  
7.	   
8.	 Eatable e=new Eatable(){  
9.	  public void eat(){System.out.println("nice fruits");}  
10.	 };  
11.	 e.eat();  
12.	 }  
13.	}  
```
#### What does the compiler for annonymous inner class created by interface

It performs two main tasks behind this code:
1.	  Eatable p=new Eatable(){  
2.	  void eat(){System.out.println("nice fruits");}  
3.	  };  
4.	  
5.	 }  
6.	}  
1.	A class is created but its name is decided by the compiler which implements the Eatable interface and provides the implementation of the eat() method.
2.	An object of Annonymous class is created that is reffered by p reference variable of Eatable type. As you know well that Parent class reference variable can refer the object of Child class.
The internal code generated by the compiler for annonymous inner class created by interface
```java
1.	import java.io.PrintStream;  
2.	static class Emp$1 implements Eatable  
3.	{  
4.	Emp$1(){}  
5.	  
6.	void eat(){System.out.println("nice fruits");}  
7.	}
```
- 3)Local inner class
A class that is created inside a method is known as local inner class. If you want to invoke the methods of local inner class, you must instantiate this class inside the method.
Program of local inner class
```java
1.	class Simple{  
2.	 private int data=30;//instance variable  
3.	 void display(){  
4.	  class Local{  
5.	   void msg(){System.out.println(data);}  
6.	  }  
7.	  Local l=new Local();  
8.	  l.msg();  
9.	 }  
10.	 public static void main(String args[]){  
11.	  Simple obj=new Simple();  
12.	  obj.display();  
13.	 }  
14.	}  
```
________________________________________
#### Internal code generated by the compiler for local inner class

In such case, compiler creates a class named Simple$1Local that have the reference of the outer class.
```java
1.	import java.io.PrintStream;  
2.	class Simple$1Local  
3.	{  
4.	    final Simple this$0;  
5.	  
6.	    Simple$1Local()  
7.	    {     
8.	        super();  
9.	        this$0 = Simple.this;  
10.	    }  
11.	    void msg()  
12.	    {  
13.	        System.out.println(Simple.access$000(Simple.this));  
14.	    }  
15.	   
16.	}
```
Rule: Local variable can't be private, public or protected.
________________________________________
#### Rules for Local Inner class

1) Local inner class cannot be invoked from outside the method.
2) Local inner class cannot access non-final local variable.
Program of accessing non-final local variable in local inner class
```java
1.	class Simple{  
2.	 private int data=30;//instance variable  
3.	 void display(){  
4.	  int value=50;//local variable must be final  
5.	  class Local{  
6.	   void msg(){System.out.println(value);}//C.T.Error  
7.	  }  
8.	  Local l=new Local();  
9.	  l.msg();  
10.	 }  
11.	 public static void main(String args[]){  
12.	  Simple obj=new Simple();  
13.	  obj.display();  
14.	 }  
15.	}  
```
#### Program of accessing final local variable in local inner class

```java
1.	class Simple{  
2.	 private int data=30;//instance variable  
3.	 void display(){  
4.	  final int value=50;//local variable must be final  
5.	  class Local{  
6.	   void msg(){System.out.println(data+" "+value);}//ok  
7.	  }  
8.	  Local l=new Local();  
9.	  l.msg();  
10.	 }  
11.	 public static void main(String args[]){  
12.	  Simple obj=new Simple();  
13.	  obj.display();  
14.	 }  
15.	}
```
- 4)static nested class
A static class that is created inside a class is known as static nested class. It cannot access the non-static members.
•	It can access static data members of outer class including private.
•	static nested class cannot access non-static (instance) data member or method.
Program of static nested class that have instance method
```java
1.	class Outer{  
2.	  static int data=30;  
3.	  
4.	  static class Inner{  
5.	   void msg(){System.out.println("data is "+data);}  
6.	  }  
7.	   
8.	  public static void main(String args[]){  
9.	  Outer.Inner obj=new Outer.Inner();  
10.	  obj.msg();  
11.	  }  
12.	}  
```
In this example, you need to create the instance of static nested class because it has instance method msg(). But you don't need to create the object of Outer class because nested class is static and static properties, methods or classes can be accessed without object.
________________________________________
#### Internal code generated by the compiler for static nested class

```java
1.	import java.io.PrintStream;  
2.	  
3.	static class Outer$Inner  
4.	{  
5.	Outer$Inner(){}  
6.	  
7.	void msg(){  
8.	System.out.println((new StringBuilder()).append("data is ")  
9.	.append(Outer.data).toString());  
10.	}  
11.	      
12.	}
```
________________________________________
#### Program of static nested class that have static method

```java
1.	class Outer{  
2.	  static int data=30;  
3.	  
4.	  static class Inner{  
5.	   static void msg(){System.out.println("data is "+data);}  
6.	  }  
7.	   
8.	  public static void main(String args[]){  
9.	  Outer.Inner.msg();//no need to create the instance of static nested class  
10.	  }  
11.	}  
```
#### Nested Interface

An interface which is declared within another interface or class is known as nested interface. The nested interfaces are used to group related interfaces so that they can be easy to maintain. The nested interface must be referred by the outer interface or class. It can't be accessed directly.
Points to remember for nested interfaces
There are given some points that should be remembered by the java programmer.
•	Nested interface must be public if it is declared inside the interface but it can have any access modifier if declared within the class.
•	Nested interfaces are declared static implicitely.
Syntax of nested interface which is declared within the interface
```java
1.	interface interface_name{  
2.	 ...  
3.	 interface nested_interface_name{  
4.	  ...  
5.	 }  
6.	}  
7.
```
Syntax of nested interface which is declared within the class
```java
1.	class class_name{  
2.	 ...  
3.	 interface nested_interface_name{  
4.	  ...  
5.	 }  
6.	}  
7.
```
________________________________________
#### Example of nested interface which is declared within the interface

In this example, we are going to learn how to declare the nested interface and how we can access it.
```java
1.	interface Showable{  
2.	  void show();  
3.	  interface Message{  
4.	   void msg();  
5.	  }  
6.	}  
7.	  
8.	class Test implements Showable.Message{  
9.	 public void msg(){System.out.println("Hello nested interface");}  
10.	  
11.	 public static void main(String args[]){  
12.	  Showable.Message message=new Test();//upcasting here  
13.	  message.msg();  
14.	 }  
15.	}
```
download the example of nested interface
 
As you can see in the above example, we are acessing the Message interface by its outer interface Showable because it cannot be accessed directly. It is just like almirah inside the room, we cannot access the almirah directly because we must enter the room first. In collection frameword, sun microsystem has provided a nested interface Entry. Entry is the subinterface of Map i.e. accessed by Map.Entry.
________________________________________
#### Internal code generated by the java compiler for nested interface Message

The java compiler internally creates public and static interface as displayed below:.
1.	public static interface Showable$Message  
2.	{  
3.	  public abstract void msg();  
4.	}  
________________________________________
#### Example of nested interface which is declared within the class

Let's see how can we define an interface inside the class and how can we access it.
```java
1.	class A{  
2.	  interface Message{  
3.	   void msg();  
4.	  }  
5.	}  
6.	  
7.	class Test implements A.Message{  
8.	 public void msg(){System.out.println("Hello nested interface");}  
9.	  
10.	 public static void main(String args[]){  
11.	  A.Message message=new Test();//upcasting here  
12.	  message.msg();  
13.	 }  
14.	}  
```
________________________________________
#### Can we define a class inside the interface ?

Yes, Ofcourse! If we define a class inside the interface, java compiler creates a static nested class. Let's see how can we define a class within the interface:
1.	interface M{  
2.	  class A{}  
3.	}  
How to call private method from another class in java
You can call the private method from outside the class by changing the runtime behaviour of the class.
By the help of java.lang.Class class and java.lang.reflect.Method class, we can call private method from any other class.
________________________________________
#### Required methods of Method class

1) public void setAccessible(boolean status) throws SecurityException sets the accessibility of the method.
2) public Object invoke(Object method, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException is used to invoke the method.
________________________________________
#### Required method of Class class

1) public Method getDeclaredMethod(String name,Class[] parameterTypes)throws NoSuchMethodException,SecurityException: returns a Method object that reflects the specified declared method of the class or interface represented by this Class object.
________________________________________
#### Example of calling private method from another class

Let's see the simple example to call private method from another class.
File: A.java
1.	public class A {  
2.	  private void message(){System.out.println("hello java"); }  
3.	}  
File: MethodCall.java
1.	import java.lang.reflect.Method;  
2.	public class MethodCall{  
3.	public static void main(String[] args)throws Exception{  
4.	  
5.	    Class c = Class.forName("A");  
6.	    Object o= c.newInstance();  
7.	    Method m =c.getDeclaredMethod("message", null);  
8.	    m.setAccessible(true);  
9.	    m.invoke(o, null);  
10.	}  
11.	}  
Output:hello java
Another example to call parameterized private method from another class
Let's see the example to call parameterized private method from another class
File: A.java
1.	class A{  
2.	private void cube(int n){System.out.println(n*n*n);}  
3.	}  
File: M.java
1.	import java.lang.reflect.*;  
2.	class M{  
3.	public static void main(String args[])throws Exception{  
4.	Class c=A.class;  
5.	Object obj=c.newInstance();  
6.	  
7.	Method m=c.getDeclaredMethod("cube",new Class[]{int.class});  
8.	m.setAccessible(true);  
9.	m.invoke(obj,4);  
10.	}}  
Output:64


#### 1) Strings are not null terminated in Java.

Unlike C and C++, String in Java doesn't terminate with null character. Instead String are Object in Java and backed by character array. You can get the character array used to represent String in Java by calling toCharArray() method of java.lang.String class of JDK.

#### 2) Strings are immutable and final in Java

Strings are immutable in Java it means once created you cannot modify content of String. If you modify it by using toLowerCase(), toUpperCase() or any other method,  It always result in new String. Since String is final there is no way anyone can extend String or override any of String functionality. Now if you are puzzled why String is immutable or final in Java. checkout the link.

#### 3) Strings are maintained in String Pool

As I Said earlier String is special class in Java and all String literal e.g. "abc"  (anything which is inside double quotes are String literal in Java) are maintained in a separate String pool, special memory location inside Java memory, more precisely inside PermGen Space. Any time you create a new String object using String literal, JVM first checks String pool and if an object with similar content available, than it returns that and doesn't create a new object. JVM doesn't perform String pool check if you create object using new operator.

You may face subtle issues if you are not aware of this String behaviour , here is an example

String name = "Scala"; //1st String object
String name_1 = "Scala"; //same object referenced by name variable
String name_2 = new String("Scala") //different String object

//this will return true
if(name==name_1){
System.out.println("both name and name_1 is pointing to same string object");
}

//this will return false
if(name==name_2){
System.out.println("both name and name_2 is pointing to same string object");
}

if you compare name and name_1 using equality operator "==" it will return true because both are pointing to same object. While name==name_2 will return false because they are pointing to different string object. It's worth remembering that equality "==" operator compares object memory location and not characters of String. By default Java puts all string literal into string pool, but you can also put any string into pool by calling intern()method of java.lang.String class, like string created using new() operator.

#### 4) Use Equals methods for comparing String in Java

String class overrides equals method and provides a content equality, which is based on characters, case and order. So if you want to compare two String object, to check whether they are same or not, always use equals() method instead of equality operator. Like in earlier example if  we use equals method to compare objects, they will be equal to each other because they all contains same contents. Here is example of comparing String using equals method.
String name = "Java"; //1st String object
String name_1 = "Java"; //same object referenced by name variable
String name_2 = new String("Java") //different String object

if(name.equals(name_1)){
System.out.println("name and name_1 are equal String by equals method");
}

//this will return false
if(name==name_2){
System.out.println("name_1 and name_2 are equal String by equals method");
}

You can also check my earlier post difference between equals() method and == operator for more detail discussion on consequences of comparing two string using == operator in Java.

#### 5) Use indexOf() and lastIndexOf() or matches(String regex) method to search inside String

String class in Java provides convenient method to see if a character or sub-string or a pattern exists in current String object. You can use indexOf() which will return position of character or String, if that exist in current String object or -1 if character doesn't exists in String. lastIndexOf is similar but it searches from end. String.match(String regex) is even more powerful, which allows you to search for a regular expression patterninside String. here is examples of indexOf, lastIndexOf and matches method from java.lang.String class.

String str = "Java is best programming language";

if(str.indexOf("Java") != -1){
     System.out.println("String contains Java at index :" + str.indexOf("Java"));
}

if(str.matches("J.*")){
     System.out.println("String Starts with J");
}

str ="Do you like Java ME or Java EE";

if(str.lastIndexOf("Java") != -1){
      System.out.println("String contains Java lastly at: " + str.lastIndexOf("Java"));
}

As expected indexOf will return 0 because characters in String are indexed from zero. lastIndexOf returns index of second “Java”, which starts at 23 and matches will return true because J.* pattern is any String starting with character J followed by any character because of dot(.) and any number of time due to asterick (*).

Remember matches() is tricky and some time non-intuitive. If you just put "Java" in matches it will return false because String is not equals to "Java" i.e. in case of plain text it behaves like equals method. See here for more examples of String matches() method.

Apart from indexOf(), lastIndexOf() and matches(String regex) String also has methods like startsWith() and endsWidth(), which can be used to check an String if it starting or ending with certain character or String.

#### 6) Use SubString to get part of String in Java

Java String provides another useful method called substring(), which can be used to get parts of String. basically you specify start and end index and substring() method returns character from that range. Index starts from 0 and goes till String.length()-1. By the way String.length() returns you number of characters in String, including white spaces like tab, space. One point which is worth remembering here is that substring is also backed up by character array, which is used by original String. This can be dangerous if original string object is very large and substring is very small, because even a small fraction can hold reference of complete array and prevents it from being garbage collected even if there is no other reference for that particular String. Read How Substring works in Java for more details. Here is an example of using SubString in Java:

String str = "Java is best programming language";
    
//this will return part of String str from index 0 to 12
String subString = str.substring(0,12);
    
System.out.println("Substring: " + subString);

#### 7) "+" is overloaded for String concatenation
Java doesn't support Operator overloading but String is special and + operator can be used to concatenate two Strings. It can even used to convert int, char, long or double to convert into String by simply concatenating with empty string "". internally + is implemented using StringBuffer prior to Java 5 and StringBuilder from Java 5 onwards. This also brings point of using StringBuffer or StringBuilder for manipulating String. Since both represent mutable object they can be used to reduce string garbage created because of temporary String. Read more about StringBuffer vs StringBuilder here.
     
#### 8) Use trim() to remove white spaces from String
String in Java provides trim() method to remove white space from both end of String. If trim() removes white spaces it returns a new String otherwise it returns same String. Along with trim() String also provides replace() and replaceAll() method for replacing characters from String. replaceAll method even support regular expression. Read more about How to replace String in Java here.

#### 9) Use split() for splitting String using Regular expression
String in Java is feature rich. it has methods like split(regex) which can take any String in form of regular expression and split the String based on that. particularly useful if you dealing with comma separated file (CSV) and wanted to have individual part in a String array. There are other methods also available related to splitting String, see this Java tutorial to split string for more details.

#### 10) Don't store sensitive data in String
String pose security threat if used for storing sensitive data like passwords, SSN or any other sensitive information. Since String is immutable in Java there is no way you can erase contents of String and since they are kept in String pool (in case of String literal) they stay longer on Java heap ,which exposes risk of being seen by anyone who has access to Java memory, like reading from memory dump. Instead char[] should be used to store password or sensitive information. See Why char[] is more secure than String for storing passwords in Java for more details.

#### 11) Character Encoding and String
Apart from all these 10 facts about String in Java, the most critical thing to know is what encoding your String is using. It does not make sense to have a String without knowing what encoding it uses. There is no way to interpret an String if you don't know the encoding it used. You can not assume that "plain" text is ASCII. If you have a String, in memory or stored in file, you must know what encoding it is in, or you cannot display it correctly. By default Java uses platform encoding i.e. character encoding of your server, and believe me this can cause huge trouble if you are handling Unicode data, especially if you are converting byte array to XML String. I have faced instances where our program fail to interpret Strings from European language e.g. German, French etc. because our server was not using Unicode encodings like UTF-8 or UTF-16. Thankfully, Java allows you to specify default character encoding for your application using system property file.encoding. See here to read more about character encoding in Java

#### What is Marker interfaces in Java and why required
Marker interface in Java is interfaces with no field or methods or in simple word empty interface in java is called marker interface. Example of market interface is Serializable, Clonnable and Remote interface. Now if marker interface doesn't have any field or method or behavior they why would Java needs it? This was asked to my friend in one of hiscore java interview and then I thought to touch based on it. In this article we will see couple of reason on what marker interface do in Java and what is use of marker interface in Java. Marker interface are also called tag interface in Java.

#### What is Marker interfaces in Java and why required
Why Marker or Tag interface do in Java
1) Looking carefully on marker interface in Java e.g. Serializable, Clonnable and Remote it looks they are used to indicate something to compiler or JVM. So if JVM sees a Class is Serializable it done some special operation on it, similar way if JVM sees one Class is implement Clonnable it performs some operation to support cloning. Same is true for RMI and Remote interface. So in short Marker interface indicate, signal or a command to Compiler or JVM.

This is pretty standard answer of question about marker interface and once you give this answer most of the time interviewee definitely asked "Why this indication can not be done using a flag inside a class?” this make sense right? Yes this can be done by using a boolean flag or a String but doesn't marking a class like Serializable or Clonnable makes it more readable and it also allows to take advantage of Polymorphism in Java.

#### Where Should I use Marker interface in Java
Apart from using built in marker interface for making a class Serializable or Clonnable. One can also develop his own marker interface. Marker interface is a good way to classify code. You can create marker interface to logically divide your code and if you have your own tool than you can perform some pre-processing operation on those classes. Particularly useful for developing API and framework likeSpring or Struts.
After introduction of Annotation on Java5, Annotation is better choice than marker interface and JUnit is a perfect example of using Annotation e.g. @Test for specifying a Test Class. Same can also be achieved by using Test marker interface.

#### Another use of marker interface in Java

One more use of marker interface in Java can be commenting. a marker interface called Thread Safe can be used to communicate other developers that classes implementing this marker interface gives thread-safe guarantee and any modification should not violate that. Marker interface can also help code coverage or code review tool to find bugs based on specified behavior of marker interfaces.
Again Annotations are better choice @ThreadSafe looks lot better than implementing ThraedSafe marker interface.

#### what is Marker interface in java with example

One of the useful technique in java is marker interface. What is Marker interface? Why and when it is required?. Can you create your  custom (own)  marker interface?  These are  some of the questions about marker interface  asked in core java interviews.  Before start with  marker interface , let us brief about interface.  As we know, an interface is a named set of method definitions  (and/or constant data elements) for which an implementer must provide code.  Methods defined in an inlterface have no method body. The  implementer of the interface is responsible for providing the method body.Marker interface is  an interface that does not contain any method declarations and constants at all (i.e. interface with no members) but  to mark a class that implements the interface as legal to do special operation on that object OR to indicate a class  as having certain desirable properties.  As marker interface has no method declarations  , no need to write any extra methods in a class that implements the  empty interface. 

#### marker  interface is defined as given below

public interface  interfaceName {
}

You can understand very well by going through some of the below examples of the application of marker interfaces from the Java programming language.
1. Serializable
2. java.util.RandomAccess
3. Cloneable
4. EventListner
5. SingleThreadModel
6. Remote

#### Before going to the examples  , let us answer the following questions?
1. Can you  serialize the state of an object  for its particular class which is not Serializable using writeObject() method  of  ObjectOutputStream class ?
2. Can you clone (shallow copy)  a  object which is not marked as Cloneable  using the clone() method of object?

The answer is no. The concerned classes are need to be marked or indicated  as legal for those methods to do the specified operation.  How to mark those objects as legal?. The best way is to  implement the class  with the special interface called marker  interface . The methods (for e.g. clone() and writeObject() )  that do the special operations (cloning , serialization)  will do  the check whether the object of the class is marked as legal (i.e. whether the object is  instance of marker Interface type or  instance of the class that implements the marker interface) .  If it is not marked as legal , then the method throws errors.   for eg.   NotSerializableException is thrown by writeObject()  method,  CloneNotSupportedException is thrown by the clone() method.

- 1. Let us take the Serializable interface  

public interface Serializable {}
One of the example of the application of marker interfaces from the Java programming language  is  Serializable interface.  By implementing this interface, a class indicates that its non-transient data members can be written to an ObjectOutputStream .    The  method writeObject() of ObjectOutputStream class will do  many instanceof  checks  as given below  to determine writabilty, one of which checks  for the Serializable interface. If any of  these tests fails, the method throws a NotSerializableException. That means an attempt to call ObjectOutputStream.writeObject()  on an object that doesn’t implement Serializable will fail  at runtime,

        ............

        else if (obj instanceof Enum) {     writeEnum((Enum) obj, desc, unshared);  }

        else if (obj instanceof Serializable) {   writeOrdinaryObject(obj, desc, unshared); }

         else          throw  NotSerializableException exception 


  - 2.    Cloneable - a Marker interface
       public interface Cloneable {}
                    A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for shallow copy  ( to make a field-for-field copy of instances of that class) and  CloneNotSupportedException  is thrown to indicate that the clone() method has been called to clone an object, but that the object's class does not implement the Cloneable interface

Many classes in  Java (such as  Date and Calendar)   implement Cloneable as given below
                          public abstract class Calendar extends Object implements Serializable, Cloneable
               Thus, the instances of these classes can be cloned. For example, the following code clones a calender object.
          Calendar rightNow = Calendar.getInstance();  //    getInstance method returns a Calendar object whose time fields have been initialized with the current date and time:
         Calendar calender_Clone1 = (Calendar)rightNow.clone();
        

- 3.  java.util.RandomAccess is also a Marker interface
public interface RandomAccess { }
           RandomAccess Marker interface is implemented by  Lists (For e.g. ArrayList) to indicate that they support  random access. Java provides many Lists that  may be either random  or sequential access lists.  Both requires different algorithms  to provide good performance for manipulating  the lists.  The best algorithms for manipulating random access lists (such as ArrayList) may give poor performance when applied to sequential access lists (such as LinkedList).
                 So to write generic algorithms , it is required to check whether the given list supports  fast random access  or sequential access .  For this purpose, RandomAccess marker interface is created and  it is assumed that a List that implements this interface supports  random access.  Now the generic algorithms can be written  by checking the given list is an instanceof RandomAccess interface before  applying an algorithm.

- 4.  EventListner :
                        All event listener types are interfaces that extend the java.util.EventListener interface. This tagging / marker  interface  does not declare any methods but you can use the instanceof operator to distinguish event listeners from other object types.

- 5.  SingleThreadModel :
                     The marker interface, meaning  does not declare any methods but  it  indicates to the servlet container that the servlet is not thread-safe, and to  handle only one request at a time in its service( ) method.

#### Create  marker interface for your application :
                     You can create your own marker interface which is suitable for your application.  Let us create our own very simple marker interface as given below

```java
 interface Allowable{ }  //marker interface
class CheckAndAllow{
 void allow(Object obj) throws NotAllowableException{
     if(obj instanceof Allowable){
      System.out.println(obj.getClass() + "  that implements Allowable interface  is allowed to do the operation" );
           //do specific operation
           }
      else {
      throw new NotAllowableException();
     }
  }
}
 class  Test implements Allowable {
           int uid;
          String name;  
}
class NotAllowableException extends Exception {
     public NotAllowableException() {     }
     public NotAllowableException(String msg) { super(msg);  }
}
public class MITest{
    public static void main(String args[]) {
         CheckAndAllow ca=new CheckAndAllow();
        try{
 Test test=new Test();
         ca.allow(test);
         System.out.println("Success");
           }catch( NotAllowableException na){System.out.println(na);}
 }
} 
```
In the above example code ,  allow method of CheckAndAllow class accepts only  the object of the class that implements the Allowable interface. If you send the object's class does not implement the Allowable interface, NotAllowableException  exception is thrown.

#### Is Marker interface  obsolete? 
     You may heard that marker annotation is the replacement for marker interface. There is no reason  to say that marker interface is obsolete. Both have merits and demerits. Although java annotation is a useful and powerful feature introduced in java 5.0 , marker interfaces are still used by still frameworks such as Spring , Struts.  For eg. Spring framework provides many marker interfaces  to change the behavior of your bean in the BeanFactory.  Some of the below good reasons make marker interface still alive. 

1. Marker interface  makes the code more readablilty and understandability where as so many annotations may lead to poor code readability and understandability.

2. If you define a reference variable whose type is an interface / marker interface , any object you assign to it must be an instance of a class / marked class that implements the interface. Assigning other objects of class that does not implement the interface , throws compile time errors. 

3. With marker interface , a simple  "instanceof"  check is required to check the class is marked by  interface as we seen in the code of own marker interface.   But with annotation , you need  to use reflection or  similar  mechanism to check the class has the desired @annotation. 

#### What is Marker interface? How is it used in Java?
The marker interface is a design pattern, used with languages that provide run-time type information about objects. It provides a way to associate metadata with a class where the language does not have explicit support for such metadata. To use this pattern, a class implements a marker interface, and code that interact with instances of that class test for the existence of the interface. Whereas a typical interface specifies functionality (in the form of method declarations) that an implementing class must support, a marker interface need not do so. The mere presence of such an interface indicates specific behavior on the part of the implementing class. There can be some hybrid interfaces, which both act as markers and specify required methods, are possible but may prove confusing if improperly used. Java utilizes this pattern very well and the example interfaces are

- java.io.Serializable - Serializability of a class is enabled by the class implementing the java.io.Serializable interface. Classes that do not implement this interface will not have any of their state serialized or deserialized. All subtypes of a serializable class are themselves serializable. The serialization interface has no methods or fields and serves only to identify the semantics of being serializable.
- java.rmi.Remote - The Remote interface serves to identify interfaces whose methods may be invoked from a non-local virtual machine. Any object that is a remote object must directly or indirectly implement this interface. Only those methods specified in a "remote interface", an interface that extends java.rmi.Remote are available remotely.
- java.lang.Cloneable - A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for that method to make a field-for-field copy of instances of that class. Invoking Object's clone method on an instance that does not implement the Cloneable interface results in the exception CloneNotSupportedException being thrown.
- javax.servlet.SingleThreadModel - Ensures that servlets handle only one request at a time. This interface has no methods.
- java.util.EvenListener - A tagging interface that all event listener interfaces must extend.

- The "instanceof" keyword in java can be used to test if an object is of a specified type. So this keyword in combination with Marker interface can be used to take different actions based on type of interface an object implements.

Marker Interface in Java: what, why, uses, etc.

#### What are Marker Interfaces in Java?
An empty interface having no methods or fields/constants is called a marker interface or a tag interface. This of course means if the interface is extending other interfaces (directly or indirectly) then the super interfaces must not have any inheritable member (method or field/constant) as otherwise the definition of the marker interface (an entirely empty interface) would not be met. Since members of any interface are by default ‘public’ so all members will be inheritable and hence we can say for an interface to be a marker interface, all of its direct or indirect super interfaces should also be marker. (Thanks marco for raising the point. I thought it was obvious, but mentioning all this explicitly would probably help our readers.)
There are few Java supplied marker interfaces like Cloneable, Serializable, etc. One can create their own marker interfaces the same way as they create any other interface in Java.
#### Purpose of having marker interfaces in Java i.e., why to have marker interfaces?
The main purpose to have marker interfaces is to create special types in those cases where the types themselves have no behavior particular to them. If there is no behavior then why to have an interface? Because the implementor of the class might only need to flag that it belongs to that particular type and everything else is handled/done by some other unit – either internal to Java (as in the case of Java supplied standard marker interfaces) or an app specific external unit.
Let’s understand this by two examples – one in which we will discuss the purpose of a standard Java interface (Cloneable) and then another user-created marker interface.

#### What purpose does the Cloneable interface serve?
When JVM sees a clone() method being invoked on an object, it first verifies if the underlying class has implemented the ‘Cloneable’ interface or not. If not, then it throws the exception CloneNotSupportedException. Assuming the underlying class has implemented the ‘Cloneable’ interface, JVM does some internal work (maybe by calling some method) to facilitate the cloning operation. Cloneable is a marker interface and having no behavior declared in it for the implementing class to define because the behavior is to be supported by JVM and not the implementing classes (maybe because it’s too tricky, generic, or low-level at the implementing class level). So, effectively marker interfaces kind of send out a signal to the corresponding external/internal entity (JVM in case of Cloneable) for them to arrange for the necessary functionality.
How does JVM support the ‘cloning’ functionality – probably by using a native method call as cloning mechanism involves some low-level tasks which are probably not possible with using a direct Java method. So, a possible ‘Object.clone’ implementation would be something like this:-
```java
public Object clone() throws CloneNotSupportedException {
 if (this implements Cloneable)
 return nativeCloneImpl();
 else
 throw new CloneNotSupportedException();
}
``` 
Anyone wondered as to why and when do we get ‘CloneNotSupportedException’ exception at compile-time itself? Well… that’s no trick. If you see the signature of the ‘Object.clone()’ method carefully, you will see a throws clause associated with it. I’m sure how can you get rid of it: (i) by wrapping the clone-invocation code within appropriate try-catch (ii) throwing the CloneNotSupportedException from the calling method.
What purpose does a user-defined marker interface serve? It can well serve the same purpose as by any standard marker interface, but in that case the container (the module controlling the execution of the app) has to take the onus of making sure that whenever a class implements that interface it does the required work to support the underlying behavior – the way JVM does for Cloneable or any other standard marker interface for that matter.

#### Defining an user-defined marker interface in Java

Let’s define a user-defined marker interface. Let’s say there is an app suporting a medical store inventory and suppose you need a reporting showing the sale, revenue, profit, etc. of three types of medicines – allopathic, homeopathic, and ayurvedic separately. Now all you need is to define three marker interfaces and make your products (medicines) implement the corresponding ones.
```java
public interface Allopathic{}
public interface Homeopathic{}
public interface Ayurvedic{}
In your reporting modules, you can probably get the segregation using something similar to below:-
for (Medicine medicine : allMedicines) {
if (medicine instanceof Allopathic) {
//... update stats accordingly
}
else if (medicine instanceof Homeopathic) {
//... update stats accordingly
}
else if (medicine instanceof Ayurvedic) {
//... update stats accordingly
}
else {
//... handle stats for general items
}
}
```
As you can see the medicines themselves don’t need to implement any specific behavior based on whether they are allopathic, homeopathic, or ayurvedic. All they need is to have a way of reflecting which category they belong to, which will in turn help the reporting modules to prepare the stats accordingly.
Now this can be done by having a flag as well… yeah, sure it can be. But, don’t you think tagging a class makes it more readable than having a flag indicating the same. You kind of make it an implementation-independent stuff for the consumers of your classes. If your class implements an interface, it becomes part of the class signature of the published API. Otherwise, you would probably handle the situation by having a public final field having the flag set up at the time of instantiation – final because you would not like others to change it. I guess going the marker interface way would probably make more sense in many such situations.
Another advantage of going via marker interface way is that at any point of time you can easily cast the objects of the implementing classes. Again it’s not that if you go via public final approach, you can’t do that. You can very well do, but casting might look a cleaner approach in many situations.
The bottom-line is there will hardly be any enforced need for a designer/developer to go via that way as there can be possible alternatives, but marker interfaces can surely be a preferred choice for some in some cases.

#### How do I find duplicate values in a table in Oracle?
```sql
select column_name, count(column_name)
from table
group by column_name
having count (column_name) > 1;

Simplest I can think of:
select job_number, count(*)
from jobs
group by job_number
having count(*) > 1;

Another way:
SELECT *
FROM TABLE A
WHERE EXISTS (
  SELECT 1 FROM TABLE
  WHERE COLUMN_NAME = A.COLUMN_NAME
  AND ROWID < A.ROWID
)
```
Works fine (quick enough) when there is index on column_name. And it's better way to delete or update duplicate rows.

You don't need to even have the count in the returned columns if you don't need to know the actual number of duplicates. e.g.
```sql
SELECT column_name
FROM table
GROUP BY column_name
HAVING COUNT(*) > 1

How about:
SELECT <column>, count(*)
FROM <table>
GROUP BY <column> HAVING COUNT(*) > 1;
To answer the example above, it would look like:
SELECT job_number, count(*)
FROM jobs
GROUP BY job_number HAVING COUNT(*) > 1;

Doing
select count(j1.job_number), j1.job_number, j1.id, j2.id
from   jobs j1 join jobs j2 on (j1.job_numer = j2.job_number)
where  j1.id != j2.id
group by j1.job_number
will give you the duplicated rows' ids.
In case where multiple columns identify unique row (e.g relations table ) there you can use following
Use row id e.g. emp_dept(empid, deptid, startdate, enddate) suppose empid and deptid are unique and identify row in that case
select oed.empid, count(oed.empid) 
from emp_dept oed 
where exists ( select * 
               from  emp_dept ied 
                where oed.rowid <> ied.rowid and 
                       ied.empid = oed.empid and 
                      ied.deptid = oed.deptid )  
        group by oed.empid having count(oed.empid) > 1 order by count(oed.empid);
```
and if such table has primary key then use primary key instead of rowid, e.g id is pk then
```sql
select oed.empid, count(oed.empid) 
from emp_dept oed 
where exists ( select * 
               from  emp_dept ied 
                where oed.id <> ied.id and 
                       ied.empid = oed.empid and 
                      ied.deptid = oed.deptid )  
        group by oed.empid having count(oed.empid) > 1 order by count(oed.empid);
```
#### Find duplicate rows in Oracle table

You are an Oracle DBA or developer and want to determine the location of duplicate rows in an Oracle table. You need it for example before attempting to place a unique index on the table. See below how can this be done.

Oracle tables always have one guaranteed unique column, the rowid column. If you use a min/max function against your rowid and then select against the proposed primary key you can squeeze out the rowids of the duplicate rows pretty quick. For example:
```sql
SELECT * FROM customers o
WHERE rowid > (SELECT min(rowid) FROM customers i
WHERE o.city = i.city and o.rating = i.rating)
In the situation where multiple columns make up the proposed key,
they must all be used in the WHERE clause.
Here is another simple and dirty way to accomplish the same:
SELECT city, rating, count(*)
FROM customers
GROUP BY city, rating
HAVING count(*) > 1


SELECT * FROM emp a
WHERE rowid = (SELECT max(rowid) FROM emp
WHERE empno = a.empno 
GROUP BY empno
HAVING count(*) >1)
```
#### Delete and truncate command in SQL
Truncate and delete in SQL are two commands which is used to remove or delete data from table. Though quite basic in nature both sql commands can create lot of trouble until you are familiar with details before using it. Difference between Truncate and delete are not just important to understand perspective but also a very popular SQL interview topic which in my opinion a definite worthy topic. What makes them tricky is amount of data. Since most of Electronic trading system stores large amount of transactional data and some even maintain historical data, good understanding of delete and truncate command is required to effectively work on those environment.I have still seen people firing delete command just to empty a table with millions of records which eventually lock the whole table for doing anything and take ages to complete or Simply blew log segment or hang the machine.

 
Most of enterprise stock trading system maintains two kind of database one transactional and other static. Transactional data is for day by day records which need to be purge at end of data or moved to historical data so that application can make a fresh start another day. If you need to work on such large set of data, my advice is to get clear andcomplete knowledge of delete and truncate command, along with there differences and when to use which command to remove data or purge tables.

In this article we will see where to use truncate in SQL and where to use delete in SQL, How to use truncate or delete and what danger or harm they can create if not used carefully along with difference between truncate and delete in SQL.

#### What is Truncate command in SQL
Use truncate table if you need to delete all rows, since truncate doesn't allow you to specify WHERE clause. truncate removes data by deallocating space used by table which removes lot of overhead in terms of logging and locking and that's why truncate is faster than delete.What you need to take care is rollback, data deleted by truncate can not be rolled back until data server specifically supports it e.g. MSSQL Server which allows to commit or rollback truncate table statement transactional. Another caveat with truncate table statement is that it doesn't fire a trigger and you can not truncate a table when a foreign key references any column to the table to be truncated. Only situation I see which is perfect for using truncate is purging tables with huge data, though there is another solution exists to drop table and recreated it if that make sense.

#### Example of truncate command in SQL

truncate table Orders;  //Order table shouldn't have a column which is foreign key on other table

#### What is Delete command in SQL
Delete is another sql command available for removing records from table. Delete is even more flexible than truncate like it provides support to WHERE Clause which can be use to remove selective data. It logs each row which allows operation to be rolled back and it also fires triggers. One disadvantage of using delete is speed and locking. Delete acquires lock on table and its also very slow operation because of logging, which makes it unsuitable for removing records from large tables. One workaround for this is batch-delete in which you remove batch of records instead on one record at a time. Delete is most suitable fore removing selective data and use it where you want to rollback transaction in database. It’s not useful to purge large amount of data from tables and should not be used, otherwise it could lock the table for very long time, blew log segment and can take ages to complete.

#### Example of delete command in SQL

delete  * from Orders; //delete all row from Orders, should not be used if Orders is large
delete  * from Orders where Symbol="MSFT.NQ" //delete all orders where symbol is MSFT.NQ


#### Difference between truncate and delete command in SQL
This is an important point to understand before using truncate or delete on production environment, or writing any script which purges data from tables.

1. truncate is fast delete is slow.
2. truncate doesn't do logging delete logs on per row basis.
3. rollback is possible with delete not with truncate until specifically supported by vendor.
4. truncate doesn't fire trigger, delete does.
5. Don't delete, truncate it when it comes to purge tables.
6. truncate reset identity column in table if any, delete doesn't.
7. truncate is DDL while delete is DML (use this when you are writing exam)
8. truncate doesn't support where clause, delete does.

So finally if you have table with huge data and want to empty it don’t Delete, truncate it

#### Interview questions on truncate and delete in SQL
Truncate and delete both are popular interview topics and there is always some question on these commands in SQL interview. Here I am listing some of SQL interview questions based on delete and truncate command in SQL, you can find answer in this article itself or by google.

1) If you have table which contains large amount of data which command will you use for removing data, truncate or delete?

2) What are differences between truncate and delete?

3) Which one is fast truncate or delete?

4) What is disadvantage of using truncate in sql?

5) How will you delete data if truncate is not supported and log segment is also not big enough to support complete delete?

6) Is there any way to remove data other than truncate and delete in SQL?

#### Database Transaction Tutorial in SQL with Example for Beginners
Database transaction is an important concept to understand while working in database and SQL. Transaction in database is required to protect data and keep it consistent when multiple users access the database at same time.  In this database transaction tutorial we will learn what is transaction in database, why do you need transaction in database, ACID properties of database transaction and an example of database transaction along with commit and rollback.   Almost all vendors like Oracle, MySQL, SQL Server or Sybase provide transaction facility though MySQL only provide it for certain storage engine like InnoDB and BDB and not for MyISAM.
#### What is transaction in database?
 Database transaction is collection of SQL queries which forms a logical one task. For transaction to be completed successfully all SQL queries has to run successfully. Database transaction executes either all or none, so for example if your database transaction contains 4 SQL queries and one of them fails then change made by other 3 queries will be rolled back. This way your database always remain consistent whether transaction succeeded or failed. Transaction is implemented in database using SQL keyword transaction, commit and rollback. Commit writes the changes made by transaction into database and rollback removes temporary changes logged in transaction log by database transaction.

#### Database Transaction tutorial
Why transaction is required in database
Database is used to store data required by real life application e.g. Banking, Healthcare, Finance etc. All your money stored in banks is stored in database, all your shares of DMAT account is stored in database and many application constantly work on these data. In order to protect data and keep it consistent any changes in this data needs to be done in transaction so that even in case of failure data remain in previous state before start of transaction. Consider a Classical example of ATM (Automated Tailor Machine); we all use to withdraw and transfer money by using ATM. If you break withdrawal operation into individual steps you will find:

1) Verify account details.
2) Accept withdrawal request
3) Check balance
4) Update balance
4) Dispense money

Suppose your account balance is 1000$ and you make a withdrawal request of 900$. At fourth step your balance is updated to 900$ and ATM machine stops working due to power outage
Once power comes back and you again tried to withdraw money you surprised by seeing your balance just 100$ instead of 1000$. This is not acceptable by any person in the world :) so we need transaction to perform such task. If SQL statements would have been executed inside transaction in database balance would be either 100$ until money has been dispensed or 1000$ if money has not been dispensed.

#### ACID Properties of database transaction
There are four important properties of database transactions these are represented by acronym ACID and also called ACID properties or database transaction where:

- A stands for Atomicity, Atom is considered to be smallest particle which can not be broken into further pieces.database transaction has to be atomic means either all steps of transaction completes or none of them.

- C stands for Consistency, transaction must leave database in consistent state even if it succeed or rollback.

- I is for Isolation
Two database transactions happening at same time should not affect each other and has consistent view of database. This is achieved by using isolation levels in database.

- D stands for Durability
Data has to be persisted successfully in database once transaction completed successfully and it has to be saved from power outage or other threats. This is achieved by saving data related to transaction in more than one places along with database.

#### When to use database transaction
Whenever any operation falls under ACID criteria you should use transactions. Many real world scenarios require transaction mostly in banking, finance and trading domain.

#### How to implement transaction in SQL
Database transaction is implemented in SQL using three keywords start transaction, commit and rollback.once you type start transaction, database starts a transaction and execute all subsequent SQL statements in transaction and keep track of all of them to either commit or rollback changes. Commit keywords saves then changes made by transaction into database and after commit change is normally visible to other transaction though is subject to isolation level. In case you encountered any error while executing individual sql statements inside database transaction, you can rollback all your changes by executing "rollback" command.

#### Database Transaction Example
To understand database transaction better let's see a real life example of transaction in database. For this example we will assume we have an Account table which represent a Bank Account and we will transfer money from one account to another account

Request: transfer 900$ from Account 9001 to 9002

start transaction
select balance from Account where Account_Number='9001';
select balance from Account where Account_Number='9002';
update Account set balance=balance-900 here Account_Number='9001' ;
update Account set balance=balance+900 here Account_Number='9002' ;
commit; //if all sql queries succed
rollback; //if any of Sql queries failed or error


#### Database transaction in MySQL
In my previous mysql command tutorials I have talked aobut different databse storage engines available in mysql e.g. myISAM or InnoDB. Not all mysql engines supports transaction in order to make transaction works in mysql you either need to use InnoDB or BDB Engine. You can specify engige while creating table in mysql or you can also change your engine in mysql by using ALTER keyword. For example "ALTER TABLE tablename TYPE=InnoDB;

#### Important point about database transaction
1. Database transaction is nothing but a set of SQL statement.

2. Transaction in database is either all or none means either all SQL statement success or none.

3. Its good practice to execute sql query inside transaction and commit or rollback based on result but you need to be little careful with transaction log. To faciliate rollback and commit every sql query which executed inside database transaction is written into transaction log and size of transaction log can grow significantly if don't commit or rollback for longtime.

4. Effect of two simulteneous database transaction into data is controlled by using Isolation level. Isolation level is used to separate one database transaction with other and currently there are four databse isolation levels:
- 1) Read Uncommited
This is lowest level of databse isolation level in this one database transaction can see changes made by other databse transaction which is not yet commited. This can allow you dirty read so quite dangerous.
- 2) Read Commited
This is sligltly better where one database transaction only sees commited changes by other database transaction. But this is also not safe and can lead you to non-repeatable reads problem.
- 3) Repeatable Reads
- 4) Serializable
Highest level of database isolation level. In this all database transactions are totally isolated with other database transaction.though this is safe but this safety can cause significant performance hit.

- 5. MyISAM storage engine in MySQL doesn't support transaction. In order to make transaction works in MySQL use InnoDB.

- 6. Databse transaction should follow ACID properties.

That’s all for now on database transaction tutorial, I will add more useful points about transaction in databse as I come across or recall, you can also provide your input and issues face during transaction in database on different RDBMS e.g. Oracle, MySQL, MSSQL Server or Sybase etc.


Read more: http://javarevisited.blogspot.com/2011/11/database-transaction-tutorial-example.html#ixzz2q09FQdbf


What is Java Class?
Java class is nothing but a template for object you are going to create or it’s a blue print by using this we create an object. In simple word we can say it’s a specification or a pattern which we define and every object we define will follow that pattern.
What does Java Class Consist?
          When we create class in java the first step is keyword class and then name of the class or identifier we can say.
          Next is class body which starts with curly braces {} and between this all things related with that class means their property and method will come here.
Template is:
Class (name of the class) {
(Here define member of class)
}
Access level of class:
Java class has mainly two type of access level:
Default: class objects are accessible only inside the package.
Public: class objects are accessible in code in any package.
What are members of Class?
When we create a class its totally incomplete without defining any member of this class same like we can understand one family is incomplete if they have no members.
Field: field is nothing but the property of the class or object which we are going to create .for example if we are creating a class called computer then they have property like model, mem_size, hd_size, os_type etc
Method: method is nothing but the operation that an object can perform it define the behavior of object how an object can interact with outside world .startMethod (), shutdownMethod ().
Access Level of members: Access level is nothing but where we can use that members of the class.
Each field and method has an access level:
•	private: accessible only in this class
•	package or default: accessible only in this package
•	protected: accessible only in this package and in all subclasses of this class
•	public: accessible everywhere this class is available
Real world example of Class in Java Programming:
In real world if we want to understand about the class everything of same quality  can be visualize as a class e.g. men,women,birds ,bicycles ,cars or  we can say vehicle .
The entire vehicle will make one class they have the property like no_of_wheels, color, model, brand etc.now we can think changeGear () and speedOfvehicle (), applyBreak () etc as a method on that class. Similarly all human being also can be one class now their member will be a men ,women ,child.,isAlive() ,isDeath() can be their method or behavior of that class .again we can make Men or women a separate class and define their property and method accordingly,
In short in java every problem we get solution can be think in terms of class and object.
One Java class example:
Class Stock {
Public commodity;
Public price;
Public void buy (int no_of commodity) {}
Public boolean sale () {}
}
In this example Stock is called Class and commodity, price are field and buy() and sale() are two methods defined inside class. To access elements of Class you need to create an instance of class Stock. You can create instance of Class using keyword new as shown below
Stock highBetaStock = new Stock();
For calling method of Stock just call by using instance.
highBetaStock.buy(1000);
highBetaStock.sell();
Summary:
In short in java everything must be thinking in terms of java class its nothing but a template they have their own members and methods for accessing those members. The entire member has their own visibility which is decided by the developer where they want to use those objects.
How to make Thread-Safe Code in Java
Example of Non Thread Safe Code in Java
Here is an example of non thread-safe code, look at the code and find out why this code is not thread safe?
/*
 * Non Thread-Safe Class in Java
 */
public class Counter {  
    private int count;  
    /*
     * This method is not thread-safe because ++ is not an atomic operation
     */
    public int getCount(){
        return count++;
    }
}
Above example is not thread-safe because ++ (increment operator) is not an atomic operation and can be broken down into read, update and write operation. if multiple thread call getCount() approximately same time each of these three operation may coincide or overlap with each other for example while thread 1 is updating value , thread 2 reads and still gets old value, which eventually let thread 2 override thread 1 increment and one count is lost because multiple thread called it concurrently.
How to make code Thread-Safe in Java
There are multiple ways to make this code thread safe in Java:
1) Use synchronized keyword in Java and lock the getCount() method so that only one thread can execute it at a time which removes possibility of coinciding or interleaving.
2) Use Atomic Integer, which makes this ++ operation atomic and since atomic operations are thread-safe and saves cost of external synchronization.
Here is a thread-safe version of Counter class in Java:

/*
 * Thread-Safe Example in Java
 */
public class Counter {
    private int count;
    AtomicInteger atomicCount = new AtomicInteger( 0 );
    /*
     * This method thread-safe now because of locking and synchornization
     */
    public synchronized int getCount(){
        return count++;
    }  
    /*
     * This method is thread-safe because count is incremented atomically
     */
    public int getCountAtomically(){
        return atomicCount.incrementAndGet();
    }
}

Important points about Thread-Safety in Java
Here are some points worth remembering to write thread safe code in Java, this knowledge also helps you to avoid some serious concurrency issues in Java like race condition or deadlock in Java:

1) Immutable objects are by default thread-safe because there state cannot be modified once created. Since String is immutable in Java, its inherently thread-safe.
2) Read only or final variables in Java are also thread-safe in Java.
3) Locking is one way of achieving thread-safety in Java.
4) Static variables if not synchronized properly become major cause of thread-safety issues.

5) Example of thread-safe class in Java: Vector, Hashtable, ConcurrentHashMap, String etc.
6) Atomic operations in Java are thread-safe e.g. reading a 32 bit int from memory because it’s an atomic operation it can't interleave with other thread.
7) local variables are also thread-safe because each thread has their own copy and using local variables is good way to writing thread-safe code in Java.
8) In order to avoid thread-safety issue minimize sharing of objects between multiple thread.
9) Volatile keyword in Java can also be used to instruct thread not to cache variables and read from main memory and can also instruct JVM not to reorder or optimize code from threading perspective.

2 ways to find if thread holds lock on object in Java
Here I am giving my answer and what I had discovered after interview

1)I thought about IllegalMonitorStateException which wait() and notify() methods throw when they get called from non-synchronized context so I said I would call newspaper.wait() and if this call throws exception it means thread in java is not holding lock, otherwise thread holds lock.

2)Later I discovered that thread is a static method called holdsLock(Object obj) which returns true or false based on whether threads holds lock on object passed.

Wait vs Sleep vs Yield in Java
Difference between Wait and Sleep in Java
Main difference between wait and sleep is that wait() method release the acquired monitor when thread is waiting while Thread.sleep() method keeps the lock or monitor even if thread is waiting. Also wait method in java should be called from synchronized method or block while there is no such requirement for sleep() method. Another difference is Thread.sleep() method is a static method and applies on current thread, while wait() is an instance specific method and only got wake up if some other thread calls notify method on same object. also in case of sleep, sleeping thread immediately goes to Runnable state after waking up while in case of wait, waiting thread first acquires the lock and then goes into Runnable state. So based upon your need if you require a specified second of pause use sleep() method or if you want to implement inter-thread communication use wait method.

Here is list of difference between wait and sleep in Java :

1) wait is called from synchronized context only while sleep can be called without synchronized block. see Why wait and notify needs to call from synchronized method for more detail.

2) wait is called on Object while sleep is called on Thread. see Why wait and notify are defined in object class instead of Thread.

3) waiting thread can be awake by calling notify and notifyAll while sleeping thread can not be awaken by calling notify method.

4) wait is normally done on condition, Thread wait until a condition is true while sleep is just to put your thread on sleep.
5) wait release lock on object while waiting while sleep doesn’t release lock while waiting.
Difference between yield and sleep in java
Major difference between yield and sleep in Java is that yield() method pauses the currently executing thread temporarily for giving a chance to the remaining waiting threads of the same priority to execute. If there is no waiting thread or all the waiting threads have a lower priority then the same thread will continue its execution. The yielded thread when it will get the chance for execution is decided by the thread scheduler whose behavior is vendor dependent. Yield method doesn’t guarantee  that current thread will pause or stop but it guarantee that CPU will be relinquish by current Thread as a result of call to Thread.yield() method in java.
Sleep method in Java has two variants one which takes millisecond as sleeping time while other which takes both mill and nano second for sleeping duration.
sleep(long millis)
or
sleep(long millis,int nanos)
Cause the currently executing thread to sleep for the specified number of milliseconds plus the specified number of nanoseconds.
Example of Thread Sleep method in Java
Here is sample code example of Sleep Thread in Java. In this example we have put Main thread in Sleep for 1 second.
/*
 * Example of Thread Sleep method in Java
 */
public class SleepTest {
      
       public static void main(String... args){
              System.out.println(Thread.currentThread().getName() + " is going to sleep for 1 Second");
              try {
                     Thread.currentThread().sleep(1000);
              } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
              System.out.println("Main Thread is woken now");
       }

}

Output:
main is going to sleep for 1 Second
Main Thread is woken now
10 points about Thread sleep() method in Java
I have listed down some important and worth to remember points about Sleep() method of Thread Class in Java:
1) Thread.sleep() method is used to pause the execution, relinquish the CPU and return it to thread scheduler.
2) Thread.sleep() method is a static method and always puts current thread on sleep.
3) Java has two variants of sleep method in Thread class one with one argument which takes milliseconds as duration for sleep and other method with two arguments one is millisecond and other is nanosecond.
4) Unlike wait() method in Java, sleep() method of Thread class doesn't relinquish the lock it has acquired.
5) sleep() method throws Interrupted Exception if another thread interrupt a sleeping thread in java.
6) With sleep() in Java its not guaranteed that when sleeping thread woke up it will definitely get CPU, instead it will go to Runnable state and fight for CPU with other thread.
7) There is a misconception about sleep method in Java that calling t.sleep() will put Thread "t" into sleeping state, that's not true because Thread.sleep method is a static method it always put current thread into Sleeping state and not thread "t".
NoClassDefFoundError vs ClassNotFoundException
Before seeing the differences between ClassNotFoundException and NoClassDefFoundError let's see some similarities which are main reason of confusion between these two errors:

1) Both NoClassDefFoundError and ClassNotFoundException are related to unavailability of a class at run-time.
2) Both ClassNotFoundException and NoClassDefFoundError are related to java classpath.

Now let's see the difference between NoClassDefFoundError and ClassNotFoundException:

1) ClassNotFoundException comes in java if we try to load a class at run-time using with Class.forName() or ClassLoader.loadClass() or ClassLoader.findSystemClass() method and requested class is not available in Java. the most of the time it looks like that we have the class in classpath but eventually it turns out to be issue related to classpath and application may not be using classpath what we think it was using e.g. classpath defined in jar's manifest file will take precedence over CLASSPATH or -cp option, for more details see How classpath works in java. On the other hand NoClassDefFoundError is little different than ClassNotFoundException, in this case culprit class was present during compile time and let's application to compile successfully and linked successfully but not available during run-time due to various reason.

2) ClassNotFoundException is a checked Exception derived directly from java.lang.Exception class and you need to provide explicit handling for it while NoClassDefFoundError is an Error derived from LinkageError.

3) If you are using ClassLoader in Java and have two classloaders then if a ClassLoader tries to access a class which is loaded by another classloader will result in ClassNoFoundException.

4) ClassNotFoundException comes up when there is an explicit loading of class is involved by providing name of class at runtime using ClassLoader.loadClass, Class.forName while NoClassDefFoundError is a result of implicit loading of class because of a method call from that class or any variable access.

Comparators and comparable in Java are two interfaces which is used to implement sorting in Java. It’s often required to sort objects stored in any collection classes like ArrayList, HashSet or in Array and that time we need to use either  compare() or  compareTo() method defined in java.util.Comparator and java.lang.Comparable.

Comparator vs Comparable in Java
Here are some of the common differences, which is worth remembering to answer this question if asked during a telephonic or face to face interview:
1) Comparator in Java is defined in java.util package while Comparable interface in Java is defined in java.lang package, which very much says that Comparator should be used as an utility to sort objects which Comparable should be provided by default.
2) Comparator interface in Java has method public int compare (Object o1, Object o2) which returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second. While Comparable interface has method public int compareTo(Object o) which returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
3) If you see then logical difference between these two is Comparator in Java compare two objects provided to him, while Comparable interface compares "this" reference with the object specified. I have shared lot of tips on how to override compareTo() method and avoid some common mistakes programmer makes while implementing Comparable interface.
4) Comparable in Java is used to implement natural ordering of object. In Java API String, Date and wrapper classes implements Comparable interface.Its always good practice to override compareTo() for value objects.
5) If any class implement Comparable interface in Java then collection of that object either List or Array can be sorted automatically by using  Collections.sort() or Arrays.sort() method and object will be sorted based on there natural order defined by CompareTo method.
6)Objects which implement Comparable in Java  can be used as keys in a SortedMap like TreeMap or elements in a SortedSet  for example TreeSet, without specifying any Comparator.
These were combination of some theoretical and practical differences between Comparator and Comparator interface in Java. It does help you to decide when to use Comparator vs Comparable but things will be more clear when we some best practices around using both of these interfaces. Now let’s see an example of Comparator in Java:
Example of using Comparator and Comparable in Java
So in Summary if you want to sort objects based on natural order then use Comparable in Java and if you want to sort on some other attribute of object then use Comparator in Java. Now to understand these concepts lets see an example or real life coding:
1) There is class called Person, sort the Person based on person_id, which is primary key in database
2) Sort the Person based on there name.
For a Person class, sorting based on person_id can be treated as natural order sorting and sorting based on name field can be implemented using Comparator interface. To sort based on person_id we need to implement compareTo() method.
public class Person implements Comparable {
    private int person_id;
    private String name;
    
    /**
     * Compare current person with specified person
     * return zero if person_id for both person is same 
     * return negative if current person_id is less than specified one
     * return positive if specified person_id is greater than specified one
     */
    @Override 
    public int compareTo(Object o) {
        Person p = (Person) o; 
        return this.person_id - o.person_id ;
    }
    ….
}

Generally you should not use difference of integers to decide output of compareTo method as result of integer subtraction can overflow but if you are sure that both operands are positive then its one of the quickest way to compare two objects. See my post things to remember while overriding compareTo in Java for more tips on compareTo.
And for sorting based on person name we can implement compare(Object o1, Object o2) method of Java Comparator class.
/**
 * Comparator implementation which sorts Person objects on person_id field
 */
public class SortByPerson_ID implements Comparator{

    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o;
        Person p2 = (Person) o; 
        return p1.getPersonId() - p2.getPersonId();
    }
}
Similar guidelines applies while implementing compare() method as well and instead of using subtraction operator, its better to use logical operator to compare whether two integers are equal to, less than or greater than. You can write several types of Java Comparator based upon your need for example  reverseComparator , ANDComparator , ORComparator etc which will return negative or positive number based upon logical results. String in Java even provides an special comparator called CASE_INSENSITIVE_ORDER, to perform case insensitive comparison of String objects.
How to Compare String in Java
String is immutable in Java and one of the most used value class. For comparing String in Java we should not be worrying because String implements Comparable interface and provides a lexicographic implementation for CompareTo method which compare two strings based on contents of characters or you can say in lexical order. You just need to call String.compareTo(AnotherString) and Java will determine whether specified String is greater than , equal to or less than current object. See my post 4 example to compare String in Java for alternatives ways of comparing String.
How to Compare Dates in Java
Dates are represented by java.util.Date class in Java and like String,  Date also implements Comparable in Java so they will be automatically sorted based on there natural ordering if they got stored in any sorted collection like TreeSet or TreeMap. If you explicitly wants to compare two dates in Java you can call Date.compareTo(AnotherDate) method in Java and it will tell whether specified date is greater than , equal to or less than current String. See my post 3 ways to compare Dates in Java for more alternatives of comparing two dates.
When to use Comparator and Comparable in Java
At last let’s see some best practices and recommendation on when to use Comparator or Comparable in Java:
1) If there is a natural or default way of sorting Object already exist during development of Class than use Comparable. This is intuitive and you given the class name people should be able to guess it correctly like Strings are sorted chronically, Employee can be sorted by there Id etc. On the other hand if an Object can be sorted on multiple ways and client is specifying on which parameter sorting should take place than use Comparator interface. for example Employee can again be sorted on name, salary or department and clients needs an API to do that. Comparator implementation can sort out this problem.
2) Some time you write code to sort object of a class for which you are not the original author, or you don't have access to code. In these cases you can not implement Comparable and Comparator is only way to sort those objects.
3) Beware with the fact that How those object will behave if stored in SorteSet or SortedMap like TreeSet and TreeMap. If an object doesn't implement Comparable than while putting them into SortedMap, always provided corresponding Comparator which can provide sorting logic.
4) Order of comparison is very important while implementing Comparable or Comparator interface. for example if you are sorting object based upon name than you can compare first name or last name on any order, so decide it judiciously. I have shared more detailed tips on compareTo on my post how to implement CompareTo in Java.
5) Comparator has a distinct advantage of being self descriptive  for example if you are writing Comparator to compare two Employees based upon there salary than name that comparator as SalaryComparator, on the other hand compareTo().
Observer design Pattern Java Code Example
What is Observer design Pattern?
Observer design pattern in Java is very important pattern and as name suggest it’s used to observe things. Suppose you want to notify for change in a particular object than you observer that object and changes are notified to you. Object which is being observed is refereed as Subject and classes which observe subject are called Observer. This is beautiful pattern and used heavily along with Model View Controller Design pattern where change in model is propagated to view so that it can render it with modified information. Observer pattern is also a very popular Java interview questions and mostly asked on Senior or mid senior level.
Problem which is solved by Observer Pattern:
If we have requirement that if particular object change its state and on depending upon
This changes some or group of objects automatically change their state we need to implement observer pattern it will reduce coupling between objects.
In real world if try to find example see when we subscribe for New Phone connection whenever customer is registered with that company all other departments are notified accordingly and then depending upon the state the do their jobs like do the verification of their address then if customer state is verified then dispatch the welcome kit etc.
How Observer Design Pattern is implemented in Java;
For implementation of this pattern java makes our task very easy, developer need not to do so much for implementing this pattern .In java.util package we can find interfaces ,classes and methods for implementing this pattern.
Public Interface Observer:
Any class who implements this interface must be notified when subject or observable object change its status.
Update (Observable Ob, Object arg): This method is called when subject is changed.
Class Observable:
It’s a subject to whom observer wants to observe.
Some Important Method:
addObserver(Observer o):add Observers in the set of observers for this subject or observalbel object.
deleteObserver(Observer o): delete Observers in the set of observers .
hasChanged():check if object has changed.
clearChanged():this method will indicate that subject has no changes or all the observers has been notified when changes is made.
notifyObservers(): notify all the observers if object has changed .
Code Example of Observer design pattern in Java:
Observer Design pattern is generic than how it is implemented in Java. You are free to choose java.util.Observable or java.util.Observer or writing your own Subject and Observer interface. I prefer having my own Subject and Observer interface and this is how I am going to write my Code Example of Observer design Pattern in java. Mine Example is very Simple you have a Loan on which interest rate is subject to change and when it changes, Loan notifies to Newspaper or Internet media to display new loan interest rate. To implement this we have a Subject interface which contains methods for adding, removing and notifying Observers and an Observer interface which contains update(int interest) method which will be called by Subject implementation when interest rate changes.
import java.util.ArrayList;

interface Observer {
       public void update(float interest);
}
interface Subject {
       public void registerObserver(Observer observer);

       public void removeObserver(Observer observer);

       public void notifyObservers();
}
class Loan implements Subject {
       private ArrayList<Observer> observers = new ArrayList<Observer>();
       private String type;
       private float interest;
       private String bank;
       public Loan(String type, float interest, String bank) {
              this.type = type;
              this.interest = interest;
              this.bank = bank;
       }
       public float getInterest() {
              return interest;
       }
       public void setInterest(float interest) {
              this.interest = interest;
              notifyObservers();
       }
       public String getBank() {
              return this.bank;
       }

       public String getType() {
              return this.type;
       }
       @Override
       public void registerObserver(Observer observer) {
              observers.add(observer);
       }
       @Override
       public void removeObserver(Observer observer) {
              observers.remove(observer);
       }
       @Override
       public void notifyObservers() {
              for (Observer ob : observers) {
                     System.out
                                  .println("Notifying Observers on change in Loan interest rate");
                     ob.update(this.interest);
              }
       }
}
class Newspaper implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Newspaper: Interest Rate updated, new Rate is: "
                           + interest);
       }
}
class Internet implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Internet: Interest Rate updated, new Rate is: "
                           + interest);
       }
}
public class ObserverTest {
       public static void main(String args[]) {
              // this will maintain all loans information
              Newspaper printMedia = new Newspaper();
              Internet onlineMedia = new Internet();
              Loan personalLoan = new Loan("Personal Loan", 12.5f,
                           "Standard Charterd");
              personalLoan.registerObserver(printMedia);
              personalLoan.registerObserver(onlineMedia);
              personalLoan.setInterest(3.5f);
       }
}

Advantage of Observer Design Pattern in Java: 
Main advantage is loose coupling between objects called observer and observable. The subject only know the list of observers it don’t care about how they have their implementation.All the observers are notified by subject in a single event call as Broadcast communication
Disadvantage of Observer Design Pattern in Java: 
·          The disadvantage is that the sometime if any problem comes, debugging becomes very difficult because flow of control is implicitly between observers and observable we can predict that now observer is going to fire and if there is chain between observers then debugging become more complex.
·          Another issue is Memory management because subject will hold all the reference of all the observers if we not unregister the object it can create the memory issue.
What problem Builder pattern solves in Java
As I said earlier Builder pattern is a creational design pattern it means its solves problem related to object creation. Constructors in Java are used to create object and can take parameters required to create object. Problem starts when an Object can be created with lot of parameters, some of them may be mandatory and others may be optional. Consider a class which is used to create Cake, now you need number of item like egg, milk, flour to create cake. many of them are mandatory and some  of them are optional like cherry, fruits etc. If we are going to have overloaded constructor for different kind of cake then there will be many constructor and even worst they will accept many parameter.
Problems:
1) too many constructors to maintain.
2) error prone because many fields has same type e.g. sugar and and butter are in cups so instead of 2 cup sugar if you pass 2 cup butter, your compiler will not complain but will get a buttery cake with almost no sugar with high cost of wasting butter.
You can partially solve this problem by creating Cake and then adding ingredients but that will impose another problem of leaving Object on inconsistent state during building, ideally cake should not be available until its created. Both of these problem can be solved by using Builder design pattern in Java. Builder design pattern not only improves readability but also reduces chance of error by adding ingredients explicitly and making object available once fully constructed. 
By the way there are many design pattern tutorial already there in Javarevisited like Decorator pattern tutorial and  Observer pattern in Java. If you haven’t read them already then its worth looking.
Example of Builder Design pattern in Java
We will use same example of creating Cake using Builder design pattern in Java. here we have static nested builder class inside Cake which is used to create object.
Guidelines for Builder design pattern in Java
1) Make a static nested class called Builder inside the class whose object will be build by Builder. In this example its Cake.
2) Builder class will have exactly same set of fields as original class.
3) Builder class will expose method for adding ingredients e.g. sugar() in this example. each method will return same Builder object. Builder will be enriched with each method call.
4) Builder.build() method will copy all builder field values into actual class and return object of Item class.
5) Item class (class for which we are creating Builder) should have private constructor to create its object from build() method and prevent outsider to access its constructor.
public class BuilderPatternExample {
  
    public static void main(String args[]) {
      
        //Creating object using Builder pattern in java
        Cake whiteCake = new Cake.Builder().sugar(1).butter(0.5).  eggs(2).vanila(2).flour(1.5). bakingpowder(0.75).milk(0.5).build();
      
        //Cake is ready to eat :)
        System.out.println(whiteCake);
    }
}

class Cake {

    private final double sugar;   //cup
    private final double butter;  //cup
    private final int eggs;
    private final int vanila;     //spoon
    private final double flour;   //cup
    private final double bakingpowder; //spoon
    private final double milk;  //cup
    private final int cherry;

    public static class Builder {

        private double sugar;   //cup
        private double butter;  //cup
        private int eggs;
        private int vanila;     //spoon
        private double flour;   //cup
        private double bakingpowder; //spoon
        private double milk;  //cup
        private int cherry;

        //builder methods for setting property
        public Builder sugar(double cup){this.sugar = cup; return this; }
        public Builder butter(double cup){this.butter = cup; return this; }
        public Builder eggs(int number){this.eggs = number; return this; }
        public Builder vanila(int spoon){this.vanila = spoon; return this; }
        public Builder flour(double cup){this.flour = cup; return this; }
        public Builder bakingpowder(double spoon){this.sugar = spoon; return this; }
        public Builder milk(double cup){this.milk = cup; return this; }
        public Builder cherry(int number){this.cherry = number; return this; }
      
      
        //return fully build object
        public Cake build() {
            return new Cake(this);
        }
    }

    //private constructor to enforce object creation through builder
    private Cake(Builder builder) {
        this.sugar = builder.sugar;
        this.butter = builder.butter;
        this.eggs = builder.eggs;
        this.vanila = builder.vanila;
        this.flour = builder.flour;
        this.bakingpowder = builder.bakingpowder;
        this.milk = builder.milk;
        this.cherry = builder.cherry;       
    }

    @Override
    public String toString() {
        return "Cake{" + "sugar=" + sugar + ", butter=" + butter + ", eggs=" + eggs + ", vanila=" + vanila + ", flour=" + flour + ", bakingpowder=" + bakingpowder + ", milk=" + milk + ", cherry=" + cherry + '}';

    } 
  
}

Output:
Cake{sugar=0.75, butter=0.5, eggs=2, vanila=2, flour=1.5, bakingpowder=0.0, milk=0.5, cherry=0}
Builder design pattern in Java – Pros and Cons
Live everything Builder pattern also has some disadvantages, but if you look at below, advantages clearly outnumber disadvantages of Builder design pattern. Any way here are few advantages and disadvantage of Builder design pattern for creating objects in Java.
Advantages:
1) more maintainable if number of fields required to create object is more than 4 or 5.
2) less error-prone as user will know what they are passing because of explicit method call.
3) more robust as only fully constructed object will be available to client.
Disadvantages:
1) verbose and code duplication as Builder needs to copy all fields from Original or Item class.
When to use Builder Design pattern in Java
Builder Design pattern is a creational pattern and should be used when number of parameter required in constructor is more than manageable usually 4 or at most 5. Don't confuse with Builder and Factory pattern there is an obvious difference between Builder and Factory pattern, as Factory can be used to create different implementation of same interface but Builder is tied up with its Container class and only returns object of Outer class.
What is static factory method or factory design pattern
Factory design pattern is used to create objects or Class in Java and it provides loose coupling and high cohesion. Factory pattern encapsulate object creation logic which makes it easy to change it later when you change how object gets created or you can even introduce new object with just change in one class. In GOF pattern list Factory pattern is listed as Creation design pattern. Factory should be an interface and clients first either creates factory or get factory which later used to create objects.
Example of static factory method in JDK
 Best Example of Factory method design pattern is valueOf() method which is there in String and wrapper classes like Integer and Boolean and used for type conversion i.e. from converting String to Integer or String to double in java..
Some more examples of factory method design pattern from JDK is :
valueOf() method which returns object created by factory equivalent to value of parameter passed.
getInstance() method which creates instance of Singleton class.
newInstance() method which is used to create and return new instance from factory method every time called.
getType() and newType() equivalent of getInstance() and newInstance() factory method but used when factory method resides in separate class.
Problem which is solved by Factory method Pattern in Java
Whenever we talk about object oriented language it will based upon some concept like abstraction, polymorphism etc and on that encapsulation and delegation are important concept any design will be called good if task are delegated to different object and some kind of encapsulation is there.
Sometime our application or framework will not know that what kind of object it has to create at run-time it knows only the interface or abstract class and as we know we cannot create object of interface or abstract class so main problem is frame work knows when it has to create but don’t know what kind of object.
Whenever we create object using new() we violate principle of programming for interface rather than implementation which eventually result in inflexible code and difficult to change in maintenance. By using Factory design pattern in Java we get rid of this problem.
Another problem we can face is class needs to contain objects of other classes or class hierarchies within it; this can be very easily achieved by just using the new keyword and the class constructor. The problem with this approach is that it is a very hard coded approach to create objects as this creates dependency between the two classes.
So factory pattern solve this problem very easily by model an interface for creating an object which at creation time can let its subclasses decide which class to instantiate, Factory Pattern promotes loose coupling by eliminating the need to bind application-specific classes into the code. The factory methods are typically implemented as virtual methods, so this pattern is also referred to as the “Virtual Constructor”. These methods create the objects of the products or target classes.
When to use Factory design pattern in Java
•	Static Factory methods are common in frameworks where library code needs to create objects of types which may be sub classed by applications using the framework.        
•	Some or all concrete products can be created in multiple ways, or we want to leave open the option that in the future there may be new ways to create the concrete product.
•	Factory method is used when Products don't need to know how they are created.
•	We  can use factory pattern where we have to create an object of any one of sub-classes depending on the data provided
Code Example of Factory Design Pattern in Java:
Let’s see an example of how factory pattern is implemented in Code. We have requirement to create multiple currency e.g. INR, SGD, USD and code should be extensible to accommodate new Currency as well. Here we have made Currency as interface and all currency would be concrete implementation of Currency interface. Factory Class will create Currency based upon country and return concrete implementation which will be stored in interface type. This makes code dynamic and extensible.
Here is complete code example of Factory pattern in Java:

interface Currency {
       String getSymbol();
}
// Concrete Rupee Class code
class Rupee implements Currency {
       @Override
       public String getSymbol() {
              return "Rs";
       }
}
// Concrete SGD class Code
class SGDDollar implements Currency {
       @Override
       public String getSymbol() {
              return "SGD";
       }
}
// Concrete US Dollar code
class USDollar implements Currency {
       @Override
       public String getSymbol() {
              return "USD";
       }
}

// Factroy Class code
class CurrencyFactory {
       public static Currency createCurrency (String country) {
       if (country. equalsIgnoreCase ("India")){
              return new Rupee();
       }else if(country. equalsIgnoreCase ("Singapore")){
              return new SGDDollar();
       }else if(country. equalsIgnoreCase ("US")){
              return new USDollar();
        }
       throw new IllegalArgumentException("No such currency");
       }
}
// Factory client code
public class Factory {
       public static void main(String args[]) {
              String country = args[0];
              Currency rupee = CurrencyFactory.createCurrency(country);
              System.out.println(rupee.getSymbol());
       }
}
Advantage of Factory method Pattern in Java:
Factory pattern in Java is heavily used everywhere including JDK, open source library and other frameworks.In following are main advantages of using Factory pattern in Java:
1) Factory method design pattern decouples the calling class from the target class, which result in less coupled and highly cohesive code?
E.g.: JDBC is a good example for this pattern; application code doesn't need to know what database it will be used with, so it doesn't know what database-specific driver classes it should use. Instead, it uses factory methods to get Connections, Statements, and other objects to work with. Which gives you flexibility to change your back-end database without changing your DAO layer in case you are using ANSI SQL features and not coded on DBMS specific feature?
2) Factory pattern in Java enables the subclasses to provide extended version of an object, because creating an object inside factory is more flexible than creating an object directly in the client. Since client is working on interface level any time you can enhance the implementation and return from Factory.
3) Another benefit of using Factory design pattern in Java is that it encourages consistency in Code since every time object is created using Factory rather than using different constructor at different client side.
4) Code written using Factory design pattern in Java is also easy to debug and troubleshoot because you have a centralized method for object creation and every client is getting object from same place.
Some more advantages of factory method design pattern is:
1. Static factory method used in factory design pattern enforces use of Interface than implementation which itself a good practice. for example:
Map synchronizedMap = Collections.synchronizedMap(new HashMap());
2. Since static factory method have return type as Interface, it allows you to replace implementation with better performance version in newer release.
3. Another advantage of static factory method pattern is that they can cache frequently used object and eliminate duplicate object creation. Boolean.valueOf() method is good example which caches true and false boolean value.
4. Factory method pattern is also recommended by Joshua Bloch in Effective Java.
5 Factory method pattern offers alternative way of creating object.
6. Factory pattern can also be used to hide information related to creation of object.
Java Decorator Design Pattern
In this Java tutorial we will see:
What is decorator pattern in Java?
When to use decorator pattern in Java?
How to use decorator pattern in Java?
Example of decorator design pattern
Advantage and Disadvantage of decorator pattern in Java
What is decorator design pattern in Java?

·          Decorator design pattern is used to enhance the functionality of a particular object at run-time or dynamically.
·          At the same time other instance of same class will not be affected by this so individual object gets the new behavior.
·          Basically we wrap the original object through decorator object.
·          Decorator design pattern is based on abstract classes and we derive concrete implementation from that classes,
·          It’s a structural design pattern and most widely used.
I prefer to answer What is decorator design pattern in point format just to stress on important point like this pattern operator at individual object level. This question also asked in many Core Java interviews in Investment banks

Problem which is solved by Decorator Pattern:
Now the question is why this pattern has came into existence what is the problem with existing system, so the answer is if anyone wants to add some functionality to individual object or change the state of particular object at run time it is not possible what the possible is we can provide the specific behavior to all the object of that class at design time by the help of inheritance or using subclass, but Decorator pattern makes possible that we provide individual object of same class a specific behavior or state at run time. This doesn’t affect other object of same Class in Java.
When to use Decorator pattern in Java
·          When sub classing is become impractical and we need large number of different possibilities to make independent object or we can say we have number of combination for an object.
·          Secondly when we want to add functionality to individual object not to all object at run-time we use decorator design pattern.
Code Example of decorator design pattern:
To better understand concept of decorator design pattern let see a code example using Decorator Pattern in Java. You can also look inside JDK and find what are classes and packages which are using decorator pattern.
// Component on Decorator design pattern
public abstract class Currency {
 String description = "Unknown currency";
 public String getCurrencyDescription() {
  return description;
 }

 public abstract double cost(double value);
}
// Concrete Component
public class Rupee extends Currency {
double value;
 public Rupee() {
  description = "indian rupees";
 }
 public double cost(double v){
  value=v;
  return value;
 }
}
//Another Concrete Component
public class Dollar extends Currency{
double value;
 public Dollar () {
  description = "Dollar”;
 }
public double cost(double v){
 value=v;
  return value;
 }
}
// Decorator
public abstract class Decorator extends Currency{
 public abstract String getDescription();
}
// Concrete Decorator
public class USDDecorator extends Decorator{
 Currency currency; 
 public USDDecorator(Currency currency){
  this.currency = currency;
 }
 public String getDescription(){
  return currency.getDescription()+" ,its US Dollar";
 }
}
//Another Concrete Decorator
public class SGDDecorator extends Decorator{
 Currency currency;
 public SGDDecorator(Currency currency){
  this.currency = currency;
 }
 public String getDescription(){
  return currency.getDescription()+" ,its singapore Dollar";
 }
}

Now its time to check currency.

public class CurrencyCheck {
 public static void main(String[] args) {
  // without adding decorators
  Currency curr = new Dollar();
  System.out.println(curr.getDescription() +" dollar. "+curr.cost(2.0));  
  //adding decorators
  Currency curr2 = new USDDecorator(new Dollar());
  System.out.println(curr2.getDescription() +" dollar. "+curr2.cost(4.0));

Currency curr3 = new SGDDecorator(new Dollar());
  System.out.println(curr3.getDescription() +" dollar. "+curr3.cost(4.0));
}
Explanation of the code:
We can understand this in following term;
1.      Component Interface: In our example Currency interface is component which used on its own or we need decorator for that.
2.      Concrete Component: it implements Component and we add new behavior to this object at dynamically. Dollar and Rupee are the concrete implementation of currency.
3.      Decorator: Decorator contains a HAS a Relationship in simple word we can say it has a instance variable that holds reference for component they implement same component which they are going to decorate. Here a Decorator is an abstract class which extends the currency.
4.      Concrete Decorator: it’s an implementation of Decorator So USD Dollar and SGD Dollar are the implementation of Decorator contains instance variable for component interface or the thing which they are going to decorate.
Advantage of Decorator design Pattern in Java
In brief we see what the main advantages of using decorator design patterns are.
1.      Decorator Pattern is flexible than inheritance because inheritance add responsibilities at compile time and it will add at run-time.
2.      Decorator pattern enhance or modify the object functionality
Disadvantage
Main disadvantage of using Decorator Pattern in Java is that the code maintenance can be a problem as it provides a lot of similar kind of small objects (each decorator).
Differences between String, StringBuffer and StringBuilder in Java
String in Java
Before looking difference between String and StringBuffer or StringBuilder let’s see some fundamental properties of String Class in Java

1) String is immutable in Java:  String is by design immutable in Java you can check this post for reason. Immutability offers lot of benefit to the String class e.g. his hashcode value can be cached which makes it a faster hashmap key and one of the reason why String is a popular key in HashMap. Because String is final it can be safely shared between multiple threads  without any extrasynchronization. 
2)when we represent string in double quotes like "abcd" they are referred as String literal and String literals are created in String pools. When you compare two String literals using equality operator "==" it returns true because they are actually same instance of String. Anyway comparing object with equality operator is bad practice in Java and you should always use equals method to check equality.
3) "+" operator is overloaded for String and used to concatenated two string. Internally "+" operation is implemented using either StringBuffer or StringBuilder.
4) Strings are backed up by character Array and represented in UTF-16 format. By the way this behavior can cause memory leak in String because same character array is shared between source String and SubString which can prevent source String from being garbage collected. See How SubString works in Java for more details.
5) String class overrides equals() and hashcode() method and two Strings are considered to be equal if they contain exactly same character in same order and in same case. If you want ignore case comparison of two strings consider using equalsIgnoreCase() method. See  how to correctly override equals method in Java  to learn more about best practices on equals method. Another worth noting point is that equals method must be consistent with compareTo() method for String because SortedSet and SortedMap e.g. TreeMap uses compareTo method to compare String in Java.
7) toString() method provides String representation of any object and its declared in Object class and its recommended for other class to implement this and provide String representation.
8) String is represented using UTF-16 format in Java.
9) In Java you can create String from char array, byte array, another string, from StringBuffer or from StringBuilder. Java String class provides constructor for all of these.

Problem with String in Java
One of its biggest strength Immutability is also biggest problem of Java String if not used correctly. many a times we create a String and then perform a lot of operation on them e.g. converting string into uppercase, lowercase , getting substring out of it , concatenating with other string etc. Since String is an immutable class every time a new String is created and older one is discarded which creates lots of temporary garbage in heap. If String are created using String literal they remain in String pool. To resolve this problem Java provides us two Classes StringBuffer and StringBuilder. String Buffer is an older class but StringBuilder is relatively new and added in JDK 5.

Differences between String and StringBuffer in Java
Main difference between String and StringBuffer is String is immutable while StringBuffer is mutable means you can modify a StringBuffer object once you created it without creating any new object. This mutable property makes StringBuffer an ideal choice for dealing with Strings in Java. You can convert a StringBuffer into String by its toString() method. String vs StringBuffer or what is differencebetween StringBuffer and String is one of the popular Java interview questions for either phone interview or first round. Now days they also include StringBuilder and ask String vs StringBuffer vs StringBuilder. So be preparing for that. In the next section we will see difference between StringBuffer and StringBuilder in Java.

Difference between StringBuilder and StringBuffer in Java
StringBuffer is very good with mutable String but it has one disadvantage all its public methods are synchronized which makes it thread-safe but same time slow. In JDK 5 they provided similar class called StringBuilder in Java which is a copy of StringBuffer but without synchronization. Try to use StringBuilder whenever possible it performs better in most of cases than StringBuffer class. You can also use "+" for concatenating two string because "+" operation is internal implemented using either StringBuffer or StringBuilder in Java. If you see StringBuilder vs StringBuffer you will find that they are exactly similar and all API methods applicable to StringBuffer are also applicable to StringBuilder in Java. On the other hand String vs StringBuffer is completely different and there API is also completely different, same is true for StringBuilder vs String.
Summary
In summary here are list of difference between StringBuffer, String and StringBuilder in Java :
1) String is immutable while StringBuffer and StringBuilder is mutable object.
2) StringBuffer is synchronized while StringBuilder is not which makes StringBuilder faster than StringBuffer.
3) Concatenation operator "+" is internal implemented using either StringBuffer or StringBuilder.
4) Use String if you require immutability, use Stringbuffer in java if you need mutable + thread-safety and use StringBuilder in Java if you require mutable + without thread-safety.
Reason Why Wait , Notify and NotifyAll are in Object Class.
Here are some thoughts on why they should not be in Thread class which make sense to me :
1) Wait and notify is not just normal methods or synchronization utility, more than that they are communication mechanism between two threads in Java. And Object class is correct place to make them available for every object if this mechanism is not available via any java keyword like synchronized. Remember synchronized and wait notify are two different area and don’t confuse that they are same or related. Synchronized is to provide mutual exclusion and ensuring thread safety of Java class like race condition while wait and notify are communication mechanism between two thread.
2 )Locks are made available on per Object basis, which is another reason wait and notify is declared in Object class rather then Thread class.
3) In Java in order to enter critical section of code, Threads needs lock and they wait for lock, they don't know which threads holds lock instead they just know the lock is hold by some thread and they should wait for lock instead of knowing which thread is inside the synchronized block and asking them to release lock. this analogy fits with wait and notify being on object class rather than thread in Java.
Why wait notify and notifyAll called from synchronized block or method in Java

We use wait () and notify () or notifyAll () method mostly for inter-thread communication. One thread is waiting after checking a condition e.g. In Producer Consumer example Producer Thread is waiting if buffer is full and Consumer thread notify Producer thread after he creates a space in buffer by consuming an element. calling notify() or notifyAll() issues a notification to a single or multiple thread that a condition has changed and once notification thread leaves synchronized block , all the threads which are waiting fight for object lock on which they are waiting and lucky thread returns from wait() method after reacquiring the lock and proceed further. Let’s divide this whole operation in steps to see a possibility of race condition between wait () and notify () method in Java, we will use Produce Consumer thread example to understand the scenario better:
   1. The Producer thread tests the condition (buffer is full or not) and confirms that it must wait (after finding buffer is full).
   2. The Consumer thread sets the condition after consuming an element from buffer.
   3. The Consumer thread calls the notify () method; this goes unheard since the Producer thread is not yet waiting.
   4. The Producer thread calls the wait () method and goes into waiting state.

So due to race condition here we potential lost a notification and if we use buffer or just one element Produce thread will be waiting forever and your program will hang.

Now let's think how does this potential race condition get resolved? This race condition is resolved by using synchronized keyword and locking provided by java. In order to call the wait (), notify () or notifyAll () methods in Java, we must have obtained the lock for the object on which we're calling the method. Since the wait () method in Java also releases the lock prior to waiting and reacquires the lock prior to returning from the wait () method, we must use this lock to ensure that checking the condition (buffer is full or not) and setting the condition (taking element from buffer) is atomic which can be achieved by using synchronized method or block in Java.

I am not sure if this is what interviewer was actually expecting but this what I thought would at least make sense, please correct me If I wrong and let us know if there is any other convincing reason of calling wait(), notify() or notifyAll method in Java.


Just to summarize we call wait (), notify () or notifyAll method in Java from synchronized method or synchronized block in Java to avoid:
1) IllegalMonitorStateException in Java which will occur if we don't call wait (), notify () or notifyAll () method from synchronized context.
2) Any potential race condition between wait and notify method in Java.

What is the difference between Enumeration and Iterator?

Only major difference between Enumeration and iterator is Iterator has a remove() method while Enumeration doesn't. Enumeration acts as Read-only interface, because it has the methods only to traverse and fetch the objects, where as by using Iterator we can manipulate the objects like adding and removing the objects from collection e.g. Arraylist.
Also Iterator is more secure and safe as compared to Enumeration because it  does not allow other thread to modify the collection object while some thread is iterating over it and throws ConcurrentModificationException. This is by far most important fact for me for deciding between Iterator vs Enumeration in Java.

In Summary both Enumeration and Iterator will give successive elements, but Iterator is new and improved version where method names are shorter, and has new method called remove. Here is a short comparison:

Enumeration
hasMoreElement()
nextElement()
N/A

Iterator
hasNext()
next()
remove()

So Enumeration is used whenever we want to make Collection objects as Read-only.

Difference between fail-fast Iterator vs fail-safe Iterator in Java
fail-fast Iterators in Java
As name suggest fail-fast Iterators fail as soon as they realized that structure of Collection has been changed since iteration has begun. Structural changes mean adding, removing or updating any element from collection while one thread is Iterating over that collection. fail-fast behaviour is implemented by keeping a modification count and if iteration thread realizes the change in modification count it throws ConcurrentModificationException.
Java doc says this is not a guaranteed behavior instead its done of "best effort basis", So application programming cannot rely on this behavior. Also since multiple threads are involved while updating and checking modification count and this check is done without synchronization, there is a chance that Iteration thread still sees a stale value and might not be able to detect any change done by parallel threads. Iterators returned by most of JDK1.4 collection are fail-fast including Vector, ArrayList, HashSet etc. to read more about Iterator see my post what is Iterator in Java.
fail-safe Iterator in java
Contrary to fail-fast Iterator, fail-safe iterator doesn't throw any Exception if Collection is modified structurally while one thread is Iterating over it because they work on clone of Collection instead of original collection and that’s why they are called as fail-safe iterator. Iterator of CopyOnWriteArrayList is an example of fail-safe Iterator also iterators written by ConcurrentHashMap keySet is also fail-safe iterator and never throw ConcurrentModificationException in Java.
How HashMap works in Java
How HashMap works in Java or sometime how get method work in HashMap is common questions on Java interviews now days. Almost everybody who worked in Java knows about HashMap, where to use HashMap or difference between Hashtable and HashMap then why this interview question becomes so special? Because of the depth it offers. It has become very popular java interview question in almost any senior or mid-senior level Java interviews. Investment banksmostly prefer to ask this question and sometime even ask to implement your own HashMap based upon your coding aptitude. Introduction of ConcurrentHashMap and other concurrent collections has also made these questions as starting point to delve into more advanced feature. Let’s start the journey.

Questions start with simple statement 

"Have you used HashMap before" or”What is HashMap? Why do we use it “
Almost everybody answers this with yes and then interviewee keep talking about common facts about HashMap like HashMap accept null while Hashtable doesn't, HashMap is not synchronized, HashMap is fast and so on along with basics like its stores key and value pairs etc. This shows that person has used HashMap and quite familiar with the functionality HashMap offers but interview takes a sharp turn from here and next set of follow-up questions gets more detailed about fundamentals involved with HashMap in Java. Interviewer struck back with questions like

"Do you Know how HashMap works in Java” or "How does get () method of HashMap works in Java"
And then you get answers like I don't bother its standard Java API, you better look code on Java source or Open JDK; I can find it out in Google at any time etc. But some interviewee definitely answer this and will say "HashMap works on principle of hashing, we have put(key, value) and get(key) method for storing and retrieving Objects from HashMap. When we pass Key and Value object to put() method on Java HashMap, HashMap implementation callshashCode method on Key object and applies returned hashcode into its own hashing function to find a bucket location for storing Entry object, important point to mention is that HashMap in Java stores both key and value object as Map.Entry in bucket which is essential to understand the retrieving logic. If people fails to recognize this and say it only stores Value in the bucket they will fail to explain the retrieving logic of any object stored in Java HashMap. This answer is very much acceptable and does make sense that interviewee has fair bit of knowledge on how hashing works and how HashMap works in Java. But this is just start of story and confusion increases when you put interviewee on scenarios faced by Java developers on day by day basis. Next question could be about collision detection and collision resolution in Java HashMap e.g. 

"What will happen if two different objects have same hashcode?”
Now from here onwards real confusion starts, Sometime candidate will say that since hashcode is equal, both objects are equal and HashMap  will throw exception or not store them again etc, Then you might want to remind them about equals() and hashCode() contract  that two unequal object in Java can have same hashcode. Some will give up at this point and few will move ahead and say "Since hashcode is same, bucket location would be same and collision will occur in HashMap, Since HashMap use LinkedList to store object, this entry (object of Map.Entry comprise key and value) will be stored in LinkedList. Great this answer makes sense though there are many collision resolution methods available this is simplest and HashMap in Java does follow this. But story does not end here and interviewer asks

"How will you retrieve Value object if two Keys will have same hashcode?”
Interviewee will say we will call get() method and then HashMap uses Key Object's hashcode to find out bucket location and retrieves Value object but then you need to remind him that there are two Value objects are stored in same bucket , so they will say about traversal in LinkedList until we find the value object , then you ask how do you identify value object because you don't  have value object to compare ,Until they know that HashMap  stores both Key and Value in LinkedList node or as Map.Entry they won't be able to resolve this issue and will try and fail.

But those bunch of people who remember this key information will say that after finding bucket location , we will call keys.equals() method to identify correct node in LinkedList and return associated value object for that key in Java HashMap . Perfect this is the correct answer.

In many cases interviewee fails at this stage because they get confused between hashCode() and equals() or keys and values object in Java HashMap  which is pretty obvious because they are dealing with the hashcode() in all previous questions and equals() come in picture only in case of retrieving value object from HashMap in Java. Some good developer point out here that using immutable, final object with proper equals() and hashcode() implementation would act as perfect Java HashMap  keys and improve performance of Java HashMap  by reducing collision. Immutability also allows caching there hashcode of different keys which makes overall retrieval process very fast and suggest that String and various wrapper classes e.g. Integer very good keys in Java HashMap.

Now if you clear this entire Java HashMap interview, you will be surprised by this very interesting question "What happens On HashMap in Java if the size of the HashMap exceeds a given threshold defined by load factor?” Until you know how HashMap works exactly you won't be able to answer this question. If the size of the Map exceeds a given threshold defined by load-factor e.g. if load factor is .75 it will act to re-size the map once it filled 75%. Similar to other collection classes like ArrayList, Java HashMap re-size itself by creating a new bucket array of size twice of previous size of HashMap, and then start putting every old element into that new bucket array. This process is called rehashing because it also applies hash function to find new bucket location. 

If you manage to answer this question on HashMap in Java you will be greeted by "do you see any problem with resizing of HashMap in Java”, you might not be able to pick the context and then he will try to give you hint about multiple thread accessing the Java HashMap and potentially looking for race condition on HashMap in Java. 

So the answer is Yes there is potential race condition exists while resizing HashMap in Java, if two thread at the same time found that now HashMap needs resizing and they both try to resizing. on the process of resizing of HashMap in Java , the element in bucket which is stored in linked list get reversed in order during their migration to new bucket because java HashMap  doesn't append the new element at tail instead it append new element at head to avoid tail traversing. If race condition happens then you will end up with an infinite loop. Though this point you can potentially argue that what the hell makes you think to use HashMap in multi-threaded environment to interviewer :)

Few more question on HashMap in Java which is contributed by readers of Javarevisited blog:
1) Why String, Integer and other wrapper classes are considered good keys?
String, Integer and other wrapper classes are natural candidates of HashMap key, and String is most frequently used key as well because final, and overrides equals and hashcode() method. Other wrapper class also shares similar property. Immutabiility is required, in order to prevent changes on fields used to calculate hashCode() because if key object return different hashCode during insertion and retrieval than it won't be possible to get object from HashMap. Immutability is best as it offers other advantages as well like thread-safety, if you can keep your hashCode same by only making certain fields final, then you go for that as well. Since equals() and hashCode() method is used during reterival of value object from HashMap, it’s important that key object correctly override these methods and follow contact. If unequal object return different hashcode than chances of collision will be less which subsequently improve performance of HashMap.

2) Can we use any custom object as key in HashMap?
This is an extension of previous questions. Ofcourse you can use any Object as key in Java HashMap provided it follows equals and hashCode contract and its hashCode should not vary once the object is inserted into Map. If custom object is Immutable than this will be already taken care because you cannot change it once created.

3) Can we use ConcurrentHashMap in place of Hashtable?
This is another question which getting popular due to increasing popularity of ConcurrentHashMap. Since we know Hashtable is synchronized but ConcurrentHashMap provides better concurrency by only locking portion of map determined by concurrency level. ConcurrentHashMap is certainly introduced as Hashtable and can be used in place of it but Hashtable provide stronger thread-safety than ConcurrentHashMap. See my post difference between Hashtable and ConcurrentHashMap for more details.

Personally, I like this question because of its depth and number of concept it touches indirectly, if you look at questions asked during interview this HashMap questions has verified
•	Concept of hashing
•	Collision resolution in HashMap
•	Use of equals () and hashCode () and there importance in HashMap?
•	Benefit of immutable object?
•	Race condition on HashMap  in Java
•	Resizing of Java HashMap
Just to summarize here are the answers which does makes sense for above questions

How HashMap works in Java
HashMap  works on principle of hashing, we have put() and get() method for storing and retrieving object form HashMap .When we pass an both key and value to put() method to store on HashMap , it uses key object hashcode() method to calculate hashcode and they by applying hashing on that hashcode it identifies bucket location for storing value object. While retrieving it uses key object equals method to find out correct key value pair and return value object associated with that key. HashMap uses linked list in case of collision and object will be stored in next node of linked list.
Also HashMap stores both key+value tuple in every node of linked list.

What will happen if two different HashMap key objects have same hashcode?
They will be stored in same bucket but no next node of linked list. And keys equals () method will be used to identify correct key value pair in HashMap.

In terms of usage Java HashMap is very versatile and I have mostly used HashMap as cache in electronic trading application I have worked. Since finance domain used Java heavily and due to performance reason we need caching HashMap and ConcurrentHashMap comes as very handy there. You can also check following articles form Javarevisited to learn more about HashMap and Hashtable in Java:

GET and POST method in HTTP and HTTPS Protocol
GET and POST method in HTTP and HTTPS are two most popular methods used to transfer data from client to server using HTTP (Hyper Text Transfer Protocol) protocol. Both GET and POST can be used to send request and receive response but there are significant difference between them. Difference between GET and POST in HTTP or HTTPS is also a popular interview question in JSP and any web programming interview. Since HTML is independent of any web server technology like Java, ASP or PHP and HTTP is core protocol in space of internet, importance of clear understanding of GET and POST method cannot be ignored. In this tutorial we will what is GET HTTP Request, What is POST HTTP Request, when to use GET and POST HTTP method and finally some difference between GET and POST method in HTTP protocol.
What is GET HTTP Request in http
HTTP protocol supports several request method you can use while sending request using HTTP or HTTPS protocol. GET is one of them. As the name suggests GET method is to retrieve a page from HTTP Server. You can identify a GET request by looking method attribute on HTTP Request part. If you are using Netbeans IDE for Java web development you can enable HTTP Server monitor which can capture HTTP request and show details of request parameters, headers and other useful information. for GET HTTP request method will be GET for example almost all the URL which is accessible using link are accessed using HTTP Request. One important property of GET request is that any request parameter or query parameter is passed as URL encoded string, appended using "?" character which makes it non secure because whatever information you pass in URL String is visible to everybody. Though GET method has some very interesting and powerful use cases which we will see in next section: When to use GET HTTP Request?
When to use HTTP GET request
As I said GET method is not secure and hence not a suitable choice for transferring confidential data but GET method is extremely useful for retrieving static content from web server. Here are some examples where using GET methods make sense:
1) There is no side effect of repeated request. For example clicking a link which points to another page. It doesn't matter if you click the link twice or thrice, this also gives chance browser of server to catch the response for faster retrieval.
2) You are not passing any sensitive and confidential information. Instead you just pass some configuration data or session id.
3) You want URL pointed by HTTP GET request to be bookmark-able.
4) Data requires to be sent to Server is not large and can safely accommodated in maximum length of URL supported by all browser. In general different browser has different character limit for URL length but having it under limit is good choice.
What is POST HTTP method
POST HTTP request is denoted by method: POST in HTTP request. In POST method data is not sent as part of URL string to server instead in POST, data is sent as part of message body. Almost all authentication requests are sent via POST method in HTTP world. POST method is secure because data is not visible in URL String and can be safely encrypted using HTTPS for further security. All sensitive and confidential information sent to be server must go on POST request and via HTTPS (HTTP with SSL). POST method is also used for submitting information to server, any information which can alter state of application like adding item into shopping cart, making payments etc. here are some examples where you should consider using POST method in HTTP request:
1) Use POST if you are sending large data which cannot be fit into URL in case of GET.
2) Use POST method if you are passing sensitive and confidential information to server e.g. user_id, password, account number etc.
3) Use POST method if you are submitting data which can alter state of application e.g. adding items into cart for passing that cart for payment processing.
4) Use POST if you are writing secure application and don't want to show query parameters in URL.
Difference between GET and POST method in HTTP Protocol
Most of the difference between GET and POST has been already discussed in their respective section. It all depends upon requirement when you want to choose GET and POST and knowledge of these differences help you to make that decision.
1) GET method passes request parameter in URL String while POST method passes request parameter in request body.
2) GET request can only pass limited amount of data while POST method can pass large amount of data to server.
3) GET request can be bookmarked and cached unlike POST requests.
4) GET is mostly used for view purpose (e.g. SQL SELECT) while POST is mainly use for update purpose (e.g. SQL INSERT or UPDATE).
Difference between Thread and Runnable interface in Java
Thread vs Runnable in Java
Here are some of my thoughts on whether I should use Thread or Runnable for implementing task in Java, though you have another choice as "Callable" for implementing thread which we will discuss later.
1) Java doesn't support multiple inheritances, which means you can only extend one class in Java so once you extended Thread class you lost your chance and cannot extend or inherit another class in Java.
2) In Object oriented programming extending a class generally means adding new functionality, modifying or improving behaviours. If we are not making any modification on Thread than use Runnable interface instead.
3) Runnable interface represent a Task which can be executed by either plain Thread or Executors or any other means. So logical separation of Task as Runnable than Thread is good design decision.
4) Separating task as Runnable means we can reuse the task and also has liberty to execute it from different means. Since you cannot restart a Thread once it completes. Again Runnable vs Thread for task, Runnable are winner.
5) Java designer recognizes this and that's why Executors accept Runnable as Task and they have worker thread which executes those task.
6) Inheriting all Thread methods are additional overhead just for representing a Task which can be done easily with Runnable.
Why Java doesn't support multiple inheritance
1) First reason is ambiguity around Diamond problem, consider a class A has foo() method and then B and C derived from A and has their own foo() implementation and now class D derive from B and C using multiple inheritance and if we refer just foo() compiler will not be able to decide which foo() it should invoke. This is also called Diamond problem because structure on this inheritance scenario is similar to 4 edge diamond, see below

         A foo()
           / \
          /   \
   foo() B     C foo()
          \   /
           \ /
            D
           foo()

In my opinion even if we remove the top head of diamond class A and allow multiple inheritances we will see this problem of ambiguity.

Sometimes if you give this reason to interviewer he asks if C++ can support multiple inheritance than why not Java. Hmmmmm in that case I would try to explain him the second reason which I have given below that it’s not because of technical difficulty but more too maintainable and clearer design was driving factor though this can only be confirmed by any of java designer and we can just speculate. Wikipedia link has some good explanation on how different language address problem arises due to diamond problem while using multiple inheritances.

2) Second and more convincing reason to me is that multiple inheritances does complicate the design and creates problem during casting, constructor chaining etc. and given that there are not many scenario on which you need multiple inheritance its wise decision to omit it for the sake of simplicity. Also java avoids this ambiguity by supporting single inheritance with interfaces. Since interface only have method declaration and doesn't provide any implementation there will only be just one implementation of specific method hence there would not be any ambiguity.

What is Synchronization in Java
Synchronization in Java is an important concept since Java is a multi-threaded language where multiple threads run in parallel to complete program execution. In multi-threaded environment synchronization of Java object or synchronization of Java class becomes extremely important. Synchronization in Java is possible by using Java keywords "synchronized" and "volatile”. Concurrent access of shared objects in Java introduces to kind of errors: thread interference and memory consistency errors and to avoid these errors you need to properly synchronize your Java object to allow mutual exclusive access of critical section to two threads. By the way This Java Synchronization tutorial is in continuation of my article How HashMap works in Java  and difference between HashMap and Hashtable in Java  if you haven’t read already you may find some useful information based on my experience in Java Collections.
Why do we need Synchronization in Java?
If your code is executing in multi-threaded environment, you need synchronization for objects, which are shared among multiple threads, to avoid any corruption of state or any kind of unexpected behavior. Synchronization in Java will only be needed if shared object is mutable. if your shared object is either read only or immutable object, than you don't need synchronization, despite running multiple threads. Same is true with what threads are doing with object if all the threads are only reading value then you don't require synchronization in Java. JVM guarantees that Java synchronized code will only be executed by one thread at a time. In Summary Java synchronized Keyword provides following functionality essential for concurrent programming : 

1) synchronized keyword in Java provides locking, which ensures mutual exclusive access of shared resource and prevent data race.

2) synchronized keyword also prevent reordering of code statement by compiler which can cause subtle concurrent issue if we don't use synchronized or volatile keyword.

3) synchronized keyword involve locking and unlocking. before entering into synchronized method or block thread needs to acquire the lock, at this point it reads data from main memory than cache and when it release the lock, it flushes write operation into main memory which eliminates memory inconsistency errors.
Synchronized keyword in Java
Prior to Java 1.5 synchronized keyword was only way to provide synchronization of shared object in Java. Any code written by using  synchronized block or enclosed inside synchronized method will be mutually exclusive, and can only be executed by one thread at a time. You can have both static synchronized method and non static synchronized method and synchronized blocks in Java but we can not have synchronized variable in java. Using synchronized keyword with variable is illegal and will result in compilation error. Instead of synchronized variable in Java, you can have java volatile variable, which will instruct JVM threads to read value of volatile variable from main memory and don’t cache it locally. Block synchronization in Java is preferred over method synchronization in Java because by using block synchronization, you only need to lock the critical section of code instead of whole method. Since synchronization in Java comes with cost of performance, we need to synchronize only part of code which absolutely needs to be synchronized.
Example of Synchronized Method in Java
Using synchronized keyword along with method is easy just apply synchronized keyword in front of method. What we need to take care is that static synchronized method locked on class object lock and non static synchronized method locks on current object (this). So it’s possible that both static and non static java synchronized method running in parallel.  This is the common mistake a naive developer do while writing Java synchronized code.
public class Counter{

  private static int count = 0;

  public static synchronized int getCount(){
    return count;
  }

  public synchoronized setCount(int count){
     this.count = count;
  }

}

In this example of Java synchronization code is not properly synchronized because both getCount() and setCount() are not getting locked on same object and can run in parallel which may results in incorrect count. Here getCount() will lock in Counter.class object while setCount() will lock on current object (this). To make this code properly synchronized in Java you need to either make both method static or non static or use java synchronized block instead of java synchronized method.By the way this is one of the common mistake Java developers make while synchronizing their code.
Example of Synchronized Block in Java
Using synchronized block in java is also similar to using synchronized keyword in methods. Only important thing to note here is that if object used to lock synchronized block of code, Singleton.class in below example is null then Java synchronized block will throw a NullPointerException.
public class Singleton{

private static volatile Singleton _instance;

public static Singleton getInstance(){
   if(_instance == null){
            synchronized(Singleton.class){
              if(_instance == null)
              _instance = new Singleton();
            }
   }
   return _instance;
}

This is a classic example of double checked locking in Singleton. In this example of Java synchronized code, we have made only critical section (part of code which is creating instance of singleton) synchronized and saved some performance. If you make whole method synchronized than every call of this method will be blocked, while you only need blocking to create singleton instance on first call. By the way, this is not the only way to write thread-safe singleton in Java. You can use Enum, or lazy loading to avoid thread-safety issue during instantiation. Even above code will not behave as expected because prior to Java 1.5, double checked locking was broker and even with volatile variable you can view half initialized object. Introduction of Java memory model and happens before guarantee in Java 5 solves this issue. To read more about Singleton in Java see that.

Important points of synchronized keyword in Java
1. Synchronized keyword in Java is used to provide mutual exclusive access of a shared resource with multiple threads in Java. Synchronization in Java guarantees that, no two threads can execute a synchronized method which requires same lock simultaneously or concurrently.
2. You can use java synchronized keyword only on synchronized method or synchronized block.
3. Whenever a thread enters into java synchronized method or block it acquires a lock and whenever it leaves java synchronized method or block it releases the lock. Lock is released even if thread leaves synchronized method after completion or due to any Error or Exception.
4. Java Thread acquires an object level lock when it enters into an instance synchronized java method and acquires a class level lock when it enters into static synchronized java method.
5. Java synchronized keyword is re-entrant in nature it means if a java synchronized method calls another synchronized method which requires same lock then current thread which is holding lock can enter into that method without acquiring lock.
6. Java Synchronization will throw NullPointerException if object used in java synchronized block is null e.g. synchronized (myInstance) will throws java.lang.NullPointerException if myInstance is null.
7. One Major disadvantage of Java synchronized keyword is that it doesn't allow concurrent read, which can potentially limit scalability. By using concept of lock stripping and using different locks for reading and writing, you can overcome this limitation of synchronized in Java. You will be glad to know that java.util.concurrent.locks.ReentrantReadWriteLock provides ready made implementation of ReadWriteLock in Java.
8. One more limitation of java synchronized keyword is that it can only be used to control access of shared object within the same JVM. If you have more than one JVM and need to synchronized access to a shared file system or database, the Java synchronized keyword is not at all sufficient. You need to implement a kind of global lock for that.
9. Java synchronized keyword incurs performance cost. Synchronized method in Java is very slow and can degrade performance. So use synchronization in java when it absolutely requires and consider using java synchronized block for synchronizing critical section only.
10. Java synchronized block is better than java synchronized method in Java because by using synchronized block you can only lock critical section of code and avoid locking whole method which can possibly degrade performance. A good example of java synchronization around this concept is getInstance() method Singleton class. See here.
11. it’s possible that both static synchronized and non-static synchronized method can run simultaneously or concurrently because they lock on different object.
12. From java 5 after change in Java memory model reads and writes are atomic for all variables declared using volatile keyword (including long and double variables) and simple atomic variable access is more efficient instead of accessing these variables via synchronized java code. But it requires more care and attention from the programmer to avoid memory consistency errors.
13. Java synchronized code could result in deadlock or starvation while accessing by multiple thread if synchronization is not implemented correctly. To know how to avoid deadlock in java see here.
14. According to the Java language specification you cannot use Java synchronized keyword with constructor it’s illegal and result in compilation error. So you cannot synchronize constructor in Java which seems logical because other threads cannot see the object being created until the thread creating it has finished it.
15. You cannot apply java synchronized keyword with variables and cannot use java volatile keyword with method.
16. Java.util.concurrent.locks extends capability provided by java synchronized keyword for writing more sophisticated programs since they offer more capabilities e.g. Reentrancy and interruptible locks.
17. Java synchronized keyword also synchronizes memory. In fact java synchronized synchronizes the whole of thread memory with main memory.
18. Important method related to synchronization in Java are wait(), notify() and notifyAll() which is defined in Object class. Do you know why they are defined in java.lang.object class instead of java.lang.Thread? You can find some reasons, which make sense.

19. Do not synchronize on non-final field on synchronized block in Java. Because reference of non-final field may change any time and then different thread might synchronizing on different objects i.e. no synchronization at all. Example of synchronizing on non-final field:
private String lock = new String("lock");
synchronized(lock){
System.out.println("locking on :"  + lock);
}

any if you write synchronized code like above in java you may get warning "Synchronization on non-final field"  in IDE like Netbeans and InteliJ

20. Its not recommended to use String object as lock in java synchronized block because string is immutable object and literal string and interned string gets stored in String pool. so by any chance if any other part of code or any third party library used same String as there lock then they both will be locked on same object despite being completely unrelated which could result in unexpected behaviour and bad performance. Instead of String object its advised to use new Object() for Synchronization in Java on synchronized block.

private static final String LOCK = "lock";   //not recommended
private static final Object OBJ_LOCK = new Object(); //better

public void process() {
   synchronized(LOCK) {
      ........
   }
}

21. From Java library Calendar and SimpleDateFormat classes are not thread-safe and requires external synchronization in Java to be used in multi-threaded environment.  

Probably most important point about Synchronization in Java is that, in the absence of synchronized keyword or other construct e.g. volatile variable or atomic variable, compiler, JVM and hardware are free to make optimization, assumption, reordering or caching of code and data, which can cause subtle concurrency bugs in code. By introducing synchronization by using volatile, atomic variable or synchronized keyword, we instruct compiler and JVM to not to do that.
Update 1: Recently I have been reading several Java Synchronization and Concurrency articles in internet and I come across jeremymanson's blog which works in google and has worked on JSR 133 Java Memory Model, I would recommend some of this blog post for every java developer, he has covered certain details about concurrent programming , synchronization and volatility in simple and easy to understand language, here is the link atomicity, visibility and ordering. 

Update 2:  I am grateful to my readers, who has left some insightful comments on this post. They have shared lots of good information and experience and to provide them more exposure, I am including some of there comments on main article, to benefit new readers. 

@Vikas wrote
Good comprehensive article about synchronized keyword in Java. to be honest I have never read all these details about synchronized block or method at one place. you may want to highlight some limitation of synchronized keyword in Java which is addressed by explicit locking using new concurrent package and Lock interface :

1. synchronized keyword doesn't allow separate locks for reading and writing. as we know that multiple thread can read without affecting thread-safety of class, synchronized keyword suffer performance due to contention in case of multiple reader and one or few writer.

 2. If one thread is waiting for lock then there is no way to time out, thread can wait indefinitely for lock.
 3. on similar note if thread is waiting for lock to acquire there is no way to interrupt the thread.
 
All these limitation of synchronized keyword is addressed and resolved by using ReadWriteLock and ReentrantLock in Java 5. 

@George wrote
Just my 2 cents on your great list of Java Synchronization facts and best practices :
 
1) synchronized keyword in internally implemented using two byte code instructions MonitorEnter and MonitorExit, this is generated by compiler. Compiler also ensures that there must be a MonitorExit for every MonitorEnter in different code path e.g. normal execution and abrupt execution, because of Exception.
2) java.util.concurrent package different locking mechanism than provided by synchronized keyword, they mostly used ReentrantLock, which internally use CAS operations, volatile variables and atomic variables to get better performance.
3) With synchronized keyword, you have to leave the lock, once you exist a synchronized method or block; there is no way you can take the lock to other method. java.util.concurrent.locks.ReentrantLock solves this problem by providing control for acquiring and releasing lock, which means you can acquire lock in method A and can release in method B, if they both needs to be locked in same object lock. Though this could be risky as compiler will neither check nor warn you about any accidental leak of locks. Which means, this can potentially block other threads, which are waiting for same lock?
4) Prefer ReentrantLock over synchronized keyword, it provides more control on lock acquisition, lock release and better performance compared to synchronized keyword.
 
5) Any thread trying to acquire lock using synchronized method will block indefinitely, until lock is available. Instead this, tryLock() method of java.util.concurrent.locks.ReentrantLock will not block if lock is not available.

What is Encapsulation in Java
Encapsulation is nothing but protecting anything which is prone to change. Rational behind encapsulation is that if any functionality which is well encapsulated in code i.e. maintained in just one place and not scattered around code is easy to change. This can be better explained with a simple example of encapsulation in Java. We all know that constructor is used to create object in Java and constructor can accept argument. Suppose we have a class Loan has a constructor and then in various classes you have created instance of loan by using this constructor. Now requirements change and you need to include age of borrower as well while taking loan. Since this code is not well encapsulated i.e. not confined in one place you need to change everywhere you are calling this constructor i.e. for one change you need to modify several file instead of just one file which is more error prone and tedious, though it can be done with refactoring feature of advanced IDE wouldn't it be better if you only need to make change at one place? Yes that is possible if we encapsulate Loan creation logic in one method say createLoan() and client code call this method and this method internally crate Loan object. in this case you only need to modify this method instead of all client code.
Example of Encapsulation in Java
class Loan{
    private int duration;  //private variables examples of encapsulation
    private String loan;
    private String borrower;
    private String salary;
   
    //public constructor can break encapsulation instead use factory method
    private Loan(int duration, String loan, String borrower, String salary){
        this.duration = duration;
        this.loan = loan;
        this.borrower = borrower;
        this.salary = salary;
    }
   
    //no argument consustructor omitted here
    
   // create loan can encapsulate loan creation logic
    public Loan createLoan(String loanType){
  
     //processing based on loan type and than returning loan object
      return loan;
    }
   
}
In this same example of Encapsulation in Java you see all member variables are made private so they are well encapsulated you can only change or access this variable directly inside this class. if you want to allow outside world to access these variables is better creating a getter and setter e.g. getLoan() that allows you to do any kind of validation, security check before return loan so it gives you complete control of whatever you want to do and single channel of access for client which is controlled and managed.
Advantage of Encapsulation in Java and OOPS
Here are few advantages of using Encapsulation while writing code in Java or any Object oriented programming language:
1. Encapsulated Code is more flexible and easy to change with new requirements.
2. Encapsulation in Java makes unit testing easy.
3. Encapsulation in Java allows you to control who can access what.
4. Encapsulation also helps to write immutable class in Java which are a good choice in multi-threading environment.
5. Encapsulation reduce coupling of modules and increase cohesion inside a module because all piece of one thing are encapsulated in one place.
6. Encapsulation allows you to change one part of code without affecting other part of code.
What should you encapsulate in code?
Anything which can be change and more likely to change in near future is candidate of Encapsulation. This also helps to write more specific and cohesive code. Example of this is object creation code, code which can be improved in future like sorting and searching logic.
Design Pattern based on Encapsulation in Java
Many design pattern in Java uses encapsulation concept, one of them is Factory pattern which is used to create objects. Factory pattern is better choice than new operator for creating object of those classes whose creation logic can vary and also for creating different implementation of same interface. BorderFactory class of JDK is a good example of encapsulation in Java which creates different types of Border and encapsulates creation logic of Border. Singleton pattern in Java also encapsulate how you create instance by providing getInstance() method. Since object is created inside one class and not from any other place in code you can easily change how you create object without affect other part of code.
Important point’s about encapsulation in Java.
1. "Whatever changes encapsulate it" is a famous design principle.
2. Encapsulation helps in loose coupling and high cohesion of code.
3. Encapsulation in Java is achieved using access modifier private, protected and public.
4. Factory pattern, Singleton pattern in Java makes good use of Encapsulation.
What is polymorphism in Java
Polymorphism is an Oops concept which advice use of common interface instead of concrete implementation while writing code. When we program for interface our code is capable of handling any new requirement or enhancement arise in near future due to new implementation of our common interface. If we don't use common interface and rely on concrete implementation, we always need to change and duplicate most of our code to support new implementation. It’s not only Java but other object oriented language like C++ also supports polymorphism and it comes as fundamental along with other OOPS concepts like Encapsulation , Abstraction and Inheritance.
How Polymorphism supported in Java
Java has excellent support of polymorphism in terms of Inheritance, method overloading and method overriding. Method overriding allows Java to invoke method based on a particular object at run-time instead of declared type while coding. To get hold of concept let's see an example of polymorphism in Java:
public class TradingSystem{
   public String getDescription(){
      return "electronic trading system";
   }
}
public class DirectMarketAccessSystem extends TradingSystem{
   public String getDescription(){
     return "direct market access system";
   }
}
public class CommodityTradingSystem extends TradingSystem{
   public String getDescription(){
     return "Futures trading system";
   }
}
Here we have a super class called TradingSystem and there two implementation DirectMarketAccessSystem and CommodityTradingSystem and here we will write code which is flexible enough to work with any future implementation of TradingSystem we can achieve this by using Polymorphism in Java which we will see in further example.

Where to use Polymorphism in code
Probably this is the most important part of this Java Polymorphism tutorial and It’s good to know where you can use Polymorphism in Java while writing code. Its common practice to always replace concrete implementation with interface it’s not that easy and comes with practice but here are some common places where I check for polymorphism:
1) Method argument:
Always use super type in method argument that will give you leverage to pass any implementation while invoking method. For example:
public void showDescription(TradingSystem tradingSystem){
   tradingSystem.description();
}
If you have used concrete implementation e.g. CommodityTradingSystem or DMATradingSystem then that code will require frequent changes whenever you add new Trading system.
2) Variable names:
Always use Super type while you are storing reference returned from any Factory method in Java, This gives you flexibility to accommodate any new implementation from Factory. Here is an example of polymorphism while writing Java code which you can use retrieving reference from Factory:
String systemName = Configuration.getSystemName();
TradingSystem system = TradingSystemFactory.getSystem(systemName);

3) Return type of method
Return type of any method is another place where you should be using interface to take advantage of Polymorphism in Java. In fact this is a requirement of Factory design pattern in Java to use interface as return type for factory method.
public TradingSystem getSystem(String name){
   //code to return appropriate implementation
}
Method overloading and method overriding in Java
Method overloading and method overriding uses concept of Polymorphism in Java where method name remains same in two classes but actual method called by JVM depends upon object at run time and done by dynamic binding in Java. Java supports both overloading and overriding of methods. In case of overloading method signature changes while in case of overriding method signature remains same and binding and invocation of method is decided on runtime based on actual object. This facility allows Java programmer to write very flexibly and maintainable code using interfaces without worrying about concrete implementation. One disadvantage of using Polymorphism in code is that while reading code you don't know the actual type which annoys while you are looking to find bugs or trying to debug program. But if you do Java debugging in IDE you will definitely be able to see the actual object and the method call and variable associated with it.
Parametric Polymorphism in Java
Java started to support parametric polymorphism with introduction of Generic in JDK1.5. Collection classes in JDK 1.5 are written using Generic Type which allows Collections to hold any type of object in run time without any change in code and this has been achieved by passing actual Type as parameter. For example see the below code of a parametric cache written using Generic which shows use of parametric polymorphism in Java. Read how to create Generic class and methods in Java for more details.

interface cache{
  public void put(K key, V value);
  public V get(K key);
}

What is abstract class in Java
An abstract class is something which is incomplete and you cannot create instance of abstract class. If you want to use it you need to make it complete or concrete by extending it. A class is called concrete if it does not contain any abstract method and implements all abstract method inherited from abstract class or interface it has implemented or extended. By the way Java has concept of abstract classes, abstract method but a variable cannot be abstract in Java. Popular example of abstract class in Java is ActionListener which has abstract method called actionPerformed(ActionEvent ae). This method is called when an ActionEvent is fired like when you click on JButton. Its common in java to attach ActionListener with JButton by implementing abstract method actionPerformed(ActionEvent ae) using Anonymous class, as shown in belowExample :
JButton  ok = new JButton("OK");
ok.addActionListener(new ActionListener(){
           public void  actionPerformed(ActionEvent ae){
               //code to handle event
           }
});


An abstract method in Java doesn't have body, it’s just a declaration. In order to use abstract method you need to override that method in SubClass.

So when do you use abstraction? (Most important in my view)
When you know something needs to be there but not sure how exactly it should look like.

E.g. when I am creating a class called Vehicle, I know there should be methods like start() and Stop() but don't know start and stop mechanism of every vehicle since they could have different start and stop mechanism e.g. some can be started by kick or some can be by pressing buttons .

The same concepts apply to interface in Java  also, which we will discuss in some other post.

So implementation of those start() and stop() methods should be left to their concrete implementation e.g. Scooter , MotorBike , Car etc.

In Java Interface is an another way of providing abstraction, Interfaces are by default abstract and only contains public static, final constant or abstract methods. It’s very common interview question is that where should we use abstract class and where should we use Java Interfaces in my view this is important to understand to design better Java application, you can go for java interface if you only know the name of methods your class should have e.g. for Server it should have start() and stop() method but we don't know how exactly these start and stop method will work. If you know some of the behaviours while designing class and that would remain common across all subclasses add that into abstract class. Interface like Runnable are good example of abstraction in Java which is used to abstract task executed by multiple thread.

In Summary
1) Use abstraction if you know something needs to be in class but implementation of that varies.
2) In Java you cannot create instance of abstract class, its compiler error.
3) abstract is a keyword in java.
4) a class automatically becomes abstract class when any of its method declared as abstract.
5) abstract method doesn't have method body.
6) Variable cannot be made abstract, its only behaviour or methods which would be abstract.
7) If a class extends an abstract class or interface it has to provide implementation to all its abstract method to be a concrete class. Alternatively this class can also be abstract.

Key Points about Interface in Java
In last section we saw what an interface in Java is and learned that interface provides abstraction in Java and its only way to achieve multiple inheritances at type level in Java. In this section we will see some important properties of interface in Java.

1. Interface in java is declared using keyword interface and it represent a Type like any Class in Java. A reference variable of type interface can point to any implementation of that interface in Java. It’s also a good Object oriented design principle to "program for interfaces than implementation" because when you use interface to declare reference variable, method return type or method argument you are flexible enough to accept any future implementation of that interface which could be much better and high performance alternative of current implementation. Similarly calling any method on interface doesn't tie you with any particular implementation and you can leverage benefit of better or improved implementation over time. This maintenance aspect of interface is also sought in various software design interview questions in Java.
2) All variables declared inside interface is implicitly public final variable or constants. which brings a useful case of using Interface for declaring Constants. We have used both Class and interface for storing application wide constants and advantage of using Interface was that you can implement interface and can directly access constants without referring them with class name which was the case earlier when Class is used for storing Constants. Though after introduction of static imports in Java 5 this approach doesn't offer any benefit over Class approach.
3) All methods declared inside Java Interfaces are implicitly public and abstract, even if you don't use public or abstract keyword. You cannot define any concrete method in interface. That's why interface is used to define contracts in terms of variables and methods and you can rely on its implementation for performing job.
4) In Java it’s legal for an interface to extend multiple interface. for example following code will run without any compilation error:
interface Session extends Serializable, Clonnable{ }
Here Session interface in Java is also a Serializable and Clonnable. This is not true for Class in Java and one Class can only extend at most another Class. In Java one Class can implement multiple interfaces. They are required to provide implementation of all methods declared inside interface or they can declare themselves as abstract class.
Example of interface in Java
Java standard library itself has many inbuilt interfaces like Serializable, Clonnable, Runnable or Callable interface in Java.  Declaring interface is easy but making it correct in first attempt is hard but if you are in business of designing API then you need to get it right in first attempt because it’s not possible to modify interface once it released without breaking all its implementation. Here is an example of declaring interface in Java:
 interface SessionIDCreator extends Serializable, Cloneable{
        String TYPE = "AUTOMATIC";
        int createSessionId();
    }
  
    class SerialSessionIDCreator implements SessionIDCreator{

        private int lastSessionId;
       
 @Override
        public int createSessionId() {
            return lastSessionId++;
        }
      
    }

In above example of interface in Java, SessionIDCreator is an interface while SerialSessionIDCreator is a implementation of interface. @Override annotation can be used on interface method from Java 6 onwards, so always try to use it. It’s one of those coding practice which should be in your code review checklist.
When to use interface in Java
Interface is best choice for Type declaration or defining contract between multiple parties. If multiple programmers are working in different module of project they still use each other’s API by defining interface and not waiting for actual implementation to be ready. This brings us lot of flexibility and speed in terms of coding and development. Use of Interface also ensures best practices like "programming for interfaces than implementation" and results in more flexible and maintainable code. Though interface in Java is not the only one who provides higher level abstraction, you can also use abstract class but choosing between Interface in Java and abstract class is a skill.
How do you detect deadlock in Java?
Though this could have many answers, my version is first I would look the code if I see nested synchronized block or calling one synchronized method from other or trying to get lock on different object then there is good chance of deadlock if developer is not very careful.

Other way is to find it when you actually get locked while running the application, try to take thread dump, in Linux you can do this by command "kill -3”, this will print status of all the thread in application log file and you can see which thread is locked on which object.

Other way is to use jconsole, jconsole will show you exactly which threads are getting locked and on which object.

Once you answer this, they may ask you to write code which will result in deadlock?
here is one of my version

public void method1(){
synchronized(String.class){
System.out.println("Aquired lock on String.class object");

synchronized (Integer.class) {
System.out.println("Aquired lock on Integer.class object");
}
}
}

public void method2(){
synchronized(Integer.class){
System.out.println("Aquired lock on Integer.class object");

synchronized (String.class) {
System.out.println("Aquired lock on String.class object");
}
}
}

If method1() and method2() both will be called by two or many threads , there is a good chance of deadlock because if thead 1 aquires lock on Sting object while executing method1() and thread 2 acquires lock on Integer object while executing method2() both will be waiting for each other to release lock on Integer and String to proceed further which will never happen.

Now interviewer comes to final part, one of the most important in my view, How to fix deadlock? Or How to avoid deadlock in Java?

If you have looked above code carefully you may have figured out that real reason for deadlock is not multiple threads but the way they access lock, if you provide an ordered access then problem will be resolved, here is
the fixed version.

public void method1(){
synchronized(Integer.class){
System.out.println("Aquired lock on Integer.class object");

synchronized (String.class) {
System.out.println("Aquired lock on String.class object");
}
}
}

public void method2(){
synchronized(Integer.class){
System.out.println("Aquired lock on Integer.class object");

synchronized (String.class) {
System.out.println("Aquired lock on String.class object");
}
}
}

Now there would not be any deadlock because both method is accessing lock on Integer and String object in same order . so if thread A acquires lock on Integer object , thread B will not proceed until thread A releases Integer lock , same way thread A will not be blocked even if thread B holds String lock because now thread B will not expect thread A to release Integer lock to proceed further.

Difference between SendRedirect() and Forward() in JSP Servlet
SendRedirect ():  
This method is declared in HttpServletResponse Interface.
Signature: void sendRedirect(String url)
This method is used to redirect client request to some other location for further processing, the new location is available on different server or different context. Our web container handles this and transfers the request using browser, and this request is visible in browser as a new request. Sometime this is also called as client side redirect.
Forward():
This method is declared in RequestDispatcher Interface.
Signature: forward(ServletRequest request, ServletResponse response)
This method is used to pass the request to another resource for further processing within the same server, another resource could be any servlet, jsp page any kind of file.This process is taken care by web container when we call forward method request is sent to another resource without the client being informed, which resource will handle the request it has been mention on requestDispatcher object which we can get by two ways either using ServletContext or Request. This is also called server side redirect.
RequestDispatcher rd = request.getRequestDispatcher("pathToResource");
  rd.forward(request, response);
Or
RequestDispatcher rd = servletContext.getRequestDispatcher("/pathToResource");
  rd.forward(request, response);
Difference between SendRedirect and Forward
Now let’s see some difference between these two methods of servlet API in tabular format.
Forward()	SendRediret()
When we use forward method request is transfer to other resource within the same server for further processing.	In case of sendRedirect request is transfer to another resource to different domain or different server for futher processing.
In case of forward Web container handle all process internally and client or browser is not involved.
	When you use SendRedirect container transfers the request to client or browser so url given inside the sendRedirect method is visible as a new request to the client.
When forward is called on requestdispatherobject we pass request and response object so our old request object is present on new resource which is going to process our request	In case of SendRedirect call old request and response object is lost because it’s treated as new request by the browser.
Visually we are not able to see the forwarded address, it is transparent	In address bar we are able to see the new redirected address it’s not transparent.
Using forward () method is faster then send redirect.	SendRedirect is slower because one extra round trip is required because completely new request is created and old request object is lost. Two browser request required.
When we redirect using forward and we want to use same data in new resource we can use request.setAttribute () as we have request object available.	But in sendRedirect if we want to use we have to store the data in session or pass along with the URL.

Example of forward and SendRedirect in JSP Servlet:
Any kind of online payment when we use merchant site will redirect us to net banking site which is completely new request it process our request and again redirect to merchant site?
In Banking Application when we do login normally we use forward method. In case of online banking we are asked for username and password if it’s a correct some another servlet or resource will handle the request otherwise request has been forwarded to error page.
Which one is good?
Its depends upon the scenario that which method is more useful.
If you want control is transfer to new server or context and it is treated as completely new task then we go for Send Redirect.
Normally forward should be used if the operation can be safely repeated upon a browser reload of the web page will not affect the result.
Creating dynamic number of threads concurrently
You can certainly create an array of threads using a loop:
 Thread[] threads = new Thread[10];
 for (int i = 0; i < threads.length; i++) {
     threads[i] = new Thread(new Runnable() {
         public void run() {
             // some code to run in parallel
         }
     });
     threads[i].start();
 }
But I would recommend using the builtin Java Executors. They do all of this for you are are easier to manage:
 // create a pool of threads, 10 max jobs will execute in parallel
 ExecutorService threadPool = Executors.newFixedThreadPool(10);
 // submit jobs to be executing by the pool
 for (int i = 0; i < NUM_JOBS_TO_CREATE; i++) {
    threadPool.submit(new Runnable() {
         public void run() {
             // some code to run in parallel
         }
     });
 }
 threadPool.shutdown();

A thread pool is a group of threads initially created that waits for jobs and executes them. The idea is to have the threads always existing, so that we won't have to pay overhead time for creating them every time. They are appropriate when we know there's a stream of jobs to process, even though there could be some time when there are no jobs.
Here's a nice diagram from Wikipedia:  
Java Thread Pool Example using Executors and ThreadPoolExecutor
by Pankaj Kumar on January 18th, 2013 | Filed in: Core Java Tags: Concurrency
A thread pool manages the pool of worker threads, it contains a queue that keeps tasks waiting to get executed. A thread pool manages the collection of Runnable threads and worker threads execute Runnable from the queue.java.util.concurrent.Executors provide implementation ofjava.util.concurrent.Executor interface to create the thread pool in java.
Let’s write a simple program to explain it’s working.
 
 
 
 
 
 
First we need to have a Runnable class.
01	package com.journaldev.threadpool;
02	 
03	public class WorkerThread implements Runnable {
04	 
05	    private String command;
06	 
07	    public WorkerThread(String s){
08	        this.command=s;
09	    }
10	 
11	    @Override
12	    public void run() {
13	        System.out.println(Thread.currentThread().getName()+' Start. Command = '+command);
14	        processCommand();
15	        System.out.println(Thread.currentThread().getName()+' End.');
16	    }
17	 
18	    private void processCommand() {
19	        try {
20	            Thread.sleep(5000);
21	        } catch (InterruptedException e) {
22	            e.printStackTrace();
23	        }
24	    }
25	 
26	    @Override
27	    public String toString(){
28	        return this.command;
29	    }
30	}
Here is the test program where we are creating fixed thread pool from Executors framework.
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.ExecutorService;
04	import java.util.concurrent.Executors;
05	 
06	public class SimpleThreadPool {
07	 
08	    public static void main(String[] args) {
09	        ExecutorService executor = Executors.newFixedThreadPool(5);
10	        for (int i = 0; i < 10; i++) {
11	            Runnable worker = new WorkerThread('' + i);
12	            executor.execute(worker);
13	          }
14	        executor.shutdown();
15	        while (!executor.isTerminated()) {
16	        }
17	        System.out.println('Finished all threads');
18	    }
19	 
20	}
In above program, we are creating fixed size thread pool of 5 worker threads. Then we are submitting 10 jobs to this pool, since the pool size is 5, it will start working on 5 jobs and other jobs will be in wait state, as soon as one of the job is finished, another job from the wait queue will be picked up by worker thread and get’s executed.
Here is the output of the above program.
01	pool-1-thread-2 Start. Command = 1
02	pool-1-thread-4 Start. Command = 3
03	pool-1-thread-1 Start. Command = 0
04	pool-1-thread-3 Start. Command = 2
05	pool-1-thread-5 Start. Command = 4
06	pool-1-thread-4 End.
07	pool-1-thread-5 End.
08	pool-1-thread-1 End.
09	pool-1-thread-3 End.
10	pool-1-thread-3 Start. Command = 8
11	pool-1-thread-2 End.
12	pool-1-thread-2 Start. Command = 9
13	pool-1-thread-1 Start. Command = 7
14	pool-1-thread-5 Start. Command = 6
15	pool-1-thread-4 Start. Command = 5
16	pool-1-thread-2 End.
17	pool-1-thread-4 End.
18	pool-1-thread-3 End.
19	pool-1-thread-5 End.
20	pool-1-thread-1 End.
21	Finished all threads
The output confirms that there are five threads in the pool named from “pool-1-thread-1? to “pool-1-thread-5? and they are responsible to execute the submitted tasks to the pool.
Executors class provide simple implementation of ExecutorService using ThreadPoolExecutor but ThreadPoolExecutor provides much more feature than that. We can specify the number of threads that will be alive when we create ThreadPoolExecutor instance and we can limit the size of thread pool and create our own RejectedExecutionHandler implementation to handle the jobs that can’t fit in the worker queue.
Here is our custom implementation of RejectedExecutionHandler interface.
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.RejectedExecutionHandler;
04	import java.util.concurrent.ThreadPoolExecutor;
05	 
06	public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
07	 
08	    @Override
09	    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
10	        System.out.println(r.toString() + ' is rejected');
11	    }
12	 
13	}
ThreadPoolExecutor provides several methods using which we can find out the current state of executor, pool size, active thread count and task count. So I have a monitor thread that will print the executor information at certain time interval.
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.ThreadPoolExecutor;
04	 
05	public class MyMonitorThread implements Runnable
06	{
07	    private ThreadPoolExecutor executor;
08	 
09	    private int seconds;
10	 
11	    private boolean run=true;
12	 
13	    public MyMonitorThread(ThreadPoolExecutor executor, int delay)
14	    {
15	        this.executor = executor;
16	        this.seconds=delay;
17	    }
18	 
19	    public void shutdown(){
20	        this.run=false;
21	    }
22	 
23	    @Override
24	    public void run()
25	    {
26	        while(run){
27	                System.out.println(
28	                    String.format('[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s',
29	                        this.executor.getPoolSize(),
30	                        this.executor.getCorePoolSize(),
31	                        this.executor.getActiveCount(),
32	                        this.executor.getCompletedTaskCount(),
33	                        this.executor.getTaskCount(),
34	                        this.executor.isShutdown(),
35	                        this.executor.isTerminated()));
36	                try {
37	                    Thread.sleep(seconds*1000);
38	                } catch (InterruptedException e) {
39	                    e.printStackTrace();
40	                }
41	        }
42	 
43	    }
44	}
Here is the thread pool implementation example using ThreadPoolExecutor.
01	package com.journaldev.threadpool;
02	 
03	import java.util.concurrent.ArrayBlockingQueue;
04	import java.util.concurrent.Executors;
05	import java.util.concurrent.ThreadFactory;
06	import java.util.concurrent.ThreadPoolExecutor;
07	import java.util.concurrent.TimeUnit;
08	 
09	public class WorkerPool {
10	 
11	    public static void main(String args[]) throws InterruptedException{
12	        //RejectedExecutionHandler implementation
13	        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
14	        //Get the ThreadFactory implementation to use
15	        ThreadFactory threadFactory = Executors.defaultThreadFactory();
16	        //creating the ThreadPoolExecutor
17	        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, newArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
18	        //start the monitoring thread
19	        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
20	        Thread monitorThread = new Thread(monitor);
21	        monitorThread.start();
22	        //submit work to the thread pool
23	        for(int i=0; i<10; i++){
24	            executorPool.execute(new WorkerThread('cmd'+i));
25	        }
26	 
27	        Thread.sleep(30000);
28	        //shut down the pool
29	        executorPool.shutdown();
30	        //shut down the monitor thread
31	        Thread.sleep(5000);
32	        monitor.shutdown();
33	 
34	    }
35	}
Notice that while initializing the ThreadPoolExecutor, we are keeping initial pool size as 2, maximum pool size to 4 and work queue size as 2. So if there are 4 running tasks and more tasks are submitted, the work queue will hold only 2 of them and rest of them will be handled by RejectedExecutionHandlerImpl.
Here is the output of above program that confirms above statement.
01	pool-1-thread-1 Start. Command = cmd0
02	pool-1-thread-4 Start. Command = cmd5
03	cmd6 is rejected
04	pool-1-thread-3 Start. Command = cmd4
05	pool-1-thread-2 Start. Command = cmd1
06	cmd7 is rejected
07	cmd8 is rejected
08	cmd9 is rejected
09	[monitor] [0/2] Active: 4, Completed: 0, Task: 6, isShutdown: false, isTerminated: false
10	[monitor] [4/2] Active: 4, Completed: 0, Task: 6, isShutdown: false, isTerminated: false
11	pool-1-thread-4 End.
12	pool-1-thread-1 End.
13	pool-1-thread-2 End.
14	pool-1-thread-3 End.
15	pool-1-thread-1 Start. Command = cmd3
16	pool-1-thread-4 Start. Command = cmd2
17	[monitor] [4/2] Active: 2, Completed: 4, Task: 6, isShutdown: false, isTerminated: false
18	[monitor] [4/2] Active: 2, Completed: 4, Task: 6, isShutdown: false, isTerminated: false
19	pool-1-thread-1 End.
20	pool-1-thread-4 End.
21	[monitor] [4/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
22	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
23	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
24	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
25	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
26	[monitor] [2/2] Active: 0, Completed: 6, Task: 6, isShutdown: false, isTerminated: false
27	[monitor] [0/2] Active: 0, Completed: 6, Task: 6, isShutdown: true, isTerminated: true
28	[monitor] [0/2] Active: 0, Completed: 6, Task: 6, isShutdown: true, isTerminated: true
Notice the change in active, completed and total completed task count of the executor. We can invoke shutdown() method to finish execution of all the submitted tasks and terminate the thread pool.


How to create Thread Pools using Java 1.5 Executor Framework - Example Tutorial
Java 1.5 introduced Thread pool in Java in form of Executor framework, which allows Java programmer to decouple submission of task to execution of task. If you are doing server side programming in Java than Thread pool is an important concept to maintain scalability, robustness and stability of system. For those, who are not familiar with thread pool in Java or concept of thread pool here is one liner, Thread pool in Java is pool of worker threads, which is ready to perform any task given to them, mostly in form of implementation of Runnable or Callable interface. Since Java supports multithreading in programming language itself, it allows multiple thread to run concurrently and perform parallel processing of task. In this article we will learn following things about thread pool in Java :
1.	What is Thread pool in Java?
2.	Why do we need Thread pool in Java ?
3.	What is Executor framework in Java 5?
4.	How to create fixed size thread pool using Executor framework in Java?
5.	Benefits of using Thread Pool in Java?

What is Thread Pool in Java and why we need it
 
As I said Thread pool is pool of already created worker thread ready to do the job. Thread pool is one of essential facility any multi-threaded server side Java application requires. One example of using thread pool is creating a web server, which process client request. If you are familiar with socket programming than you know that ServerSocket.accept() is blocking method and blocks until a socket connection made. If only one thread is used to process client request, than it subsequently limit how many client can access server concurrently. In order to support large number of clients, you may decide to use one thread per request paradigm, in which each request is processed by separate Thread, but this require Thread to be created, when request arrived.  Since creation of Thread is time consuming process, it delays request processing. It also limits number of clients based upon how many thread per JVM is allowed, which is obviously a limited number. Thread pool solves this problem for you, It creates Thread and manage them. Instead of creating Thread and discarding them once task is done, thread-pool reuses threads in form of worker thread. Since Thread are usually created and pooled when application starts, your server can immediately start request processing, which can further improve server’s response time. Apart from this, there are several other benefits of using Thread pool in Java applications, which we will see in subsequent section. In short, we need thread pools to better mange threads and decoupling task submission from execution. Thread pool and Executor framework introduced in Java 5 is an excellent thread pool provided by library.

Java Thread Pool - Executor Framework in Java 5
Java 5 introduced several useful features like Enum, Generics, Variable arguments and several concurrency collections and utilities like ConcurrentHashMap and BlockingQueue etc, It also introduced a full feature built-in Thread Pool framework commonly known as Executor framework. Core of this thread pool framework is Executor interface which defines abstraction of task execution with method execute(Runnable task) and ExecutorService which extends Executor to add various life-cycle and thread pool management facilities like shutting down thread pool. Executor framework also provides an static utility class called Executors ( similar to Collections) which provides several static factory method to create various type of Thread Pool implementation in Java e.g. fixed size thread pool, cached thread pool and scheduled thread pool. Runnable and Callable interface are used to represent task executed by worker thread managed in these Thread pools. Interesting point about Executor framework is that, it is based on Producer consumer design pattern, where application thread produces task and worker thread consumers or execute those task, So it also suffers with limitation of Producer consumer task like if production speed is substantially higher than consumption than you may run OutOfMemory because of queued task, of course only if your queue is unbounded.

How to create fixed size thread pool using Executor framework in Java?
Creating fixed size thread pool using Java 5 Executor framework is pretty easy because of static factory methods provided by Executors class. All you need to do is define your task which you want to execute concurrently and than submit that task to ExecutorService. from them Thread pool will take care of how to execute that task, it can be executed by any free worker thread and if you are interested in result you can query Future object returned by submit()method. Executor framework also provides different kind of Thread Pool e.g. SingleThreadExecutor which creates just one worker thread or CachedThreadPool which creates worker threads as and when necessary. You can also check  Java documentation of Executor Framework for complete details of services provided by this API. Java concurrency in Practice also has couple of chapters dedicated to effective use of Java 5 Executor framework, which is worth reading for any senior Java developer.

Example of Thread Pool in Java
Here is an example of Thread pool in Java, which uses Executor framework of Java 5 to create a fixed thread pool with number of worker thread as 10. It will then create task and submit that to Thread pool for execution:

public class ThreadPoolExample {

    public static void main(String args[]) {
       ExecutorService service = Executors.newFixedThreadPool(10);
       for (int i =0; i<100; i++){
           service.submit(new Task(i));
       }
    }
  
}

final class Task implements Runnable{
    private int taskId;
  
    public Task(int id){
        this.taskId = id;
    }
  
    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId +" performed by " 
                           + Thread.currentThread().getName());
    }
  
}

Output:
Task ID : 0 performed by pool-1-thread-1
Task ID : 3 performed by pool-1-thread-4
Task ID : 2 performed by pool-1-thread-3
Task ID : 1 performed by pool-1-thread-2
Task ID : 5 performed by pool-1-thread-6
Task ID : 4 performed by pool-1-thread-5

If you look at output of this Java example you will find different threads from thread pool are executing tasks.


Benefits of Thread Pool in Java
Thread Pool offers several benefit to Java application, biggest of them is separating submission of task to execution of task ,which result if more loose coupled and flexible design than tightly coupled create and execute pattern. Here are some more benefits of using Thread pool in Java:

1) Use of Thread Pool reduces response time by avoiding thread creation during request or task processing.
2) Use of Thread Pool allows you to change your execution policy as you need. you can go from single thread to multiple thread by just replacing ExecutorService implementation.

3) Thread Pool in Java application increases stability of system by creating a configured number of threads decided based on system load and available resource.

4) Thread Pool frees application developer from thread management stuff and allows to focus on business logic.

That's all on Thread pool in Java 5. we have seen what is thread pool in Java, what is executor framework in java 5, how to create thread pool in Java and some benefits of using thread pool in Java application. no doubt knowledge of thread pool is essential for a server side core Java developer and I suggest reading Java Threads and Concurrency Practice in Java to learn more about concurrency and thread pool. 
Java Concurrency Tutorial: Thread Pools
06.26.2008
 | 53117 views | 
inShare
Thread Pools are useful when you need to limit the number of threads running in your application at the same time. There is a performance overhead associated with starting a new thread, and each thread is also allocated some memory for its stack etc.
Instead of starting a new thread for every task to execute concurrently, the task can be passed to a thread pool. As soon as the pool has any idle threads the task is assigned to one of them and executed. Internally the tasks are inserted into a Blocking Queue which the threads in the pool are dequeuing from. When a new task is inserted into the queue one of the idle threads will dequeue it successfully and execute it. The rest of the idle threads in the pool will be blocked waiting to dequeue tasks.
Thread pools are often used in multi threaded servers. Each connection arriving at the server via the network is wrapped as a task and passed on to a thread pool. The threads in the thread pool will process the requests on the connections concurrently. A later trail will get into detail about implementing multithreaded servers in Java.
Java 5 comes with built in thread pools in the java.util.concurrent package, so you don't have to implement your own thread pool. Still it can be useful to know a bit about the implementation of a thread pool anyways.
Here is a simple thread pool implementation:
view source
print?
01.public class ThreadPool {
02. 
03.private BlockingQueue taskQueue = null;
04.private List<PoolThread> threads = new ArrayList<PoolThread>();
05.private boolean isStopped = false;
06. 
07.public ThreadPool(int noOfThreads, int maxNoOfTasks){
08.taskQueue = new BlockingQueue(maxNoOfTasks);
09. 
10.for(int i=0; i<noOfThreads; i++){
11.threads.add(new PoolThread(taskQueue));
12.}
13.for(PoolThread thread : threads){
14.thread.start();
15.}
16.}
17. 
18.public void synchronized execute(Runnable task){
19.if(this.isStopped) throw
20.new IllegalStateException("ThreadPool is stopped");
21. 
22.this.taskQueue.enqueue(task);
23.}
24. 
25.public synchronized void stop(){
26.this.isStopped = true;
27.for(PoolThread thread : threads){
28.thread.stop();
29.}
30.}
31. 
32.}
view source
print?
01.public class PoolThread extends Thread {
02. 
03.private BlockingQueue taskQueue = null;
04.private boolean       isStopped = false;
05. 
06.public PoolThread(BlockingQueue queue){
07.taskQueue = queue;
08.}
09. 
10.public void run(){
11.while(!isStopped()){
12.try{
13.Runnable runnable = (Runnable) taskQueue.dequeue();
14.runnable.run();
15.} catch(Exception e){
16.//log or otherwise report exception,
17.//but keep pool thread alive.
18.}
19.}
20.}
21. 
22.public synchronized void stop(){
23.isStopped = true;
24.this.interrupt(); //break pool thread out of dequeue() call.
25.}
26. 
27.public synchronized void isStopped(){
28.return isStopped;
29.}
30.}
The thread pool implementation consists of two parts. A ThreadPool class which is the public interface to the thread pool, and a PoolThread class which implements the threads that execute the tasks.
To execute a task the method ThreadPool.execute(Runnable r) is called with a Runnableimplementation as parameter. The Runnable is enqueued in the blocking queue internally, waiting to be dequeued.
The Runnable will be dequeued by an idle PoolThread and executed. You can see this in thePoolThread.run() method. After execution the PoolThread loops and tries to dequeue a task again, until stopped.
To stop the ThreadPool the method ThreadPool.stop() is called. The stop called is noted internally in the isStopped member. Then each thread in the pool is stopped by calling PoolThread.stop(). Notice how the execute() method will throw an IllegalStateException if execute() is called after stop() has been called.
The threads will stop after finishing any task they are currently executing. Notice the this.interrupt() call in PoolThread.stop(). This makes sure that a thread blocked in a wait() call inside thetaskQueue.dequeue() call breaks out of the wait() call, and leaves the dequeue() method call with anInterruptedException thrown. This exception is caught in the PoolThread.run() method, reported, and then the isStopped variable is checked. Since isStopped is now true, the PoolThread.run() will exit and the thread dies.

Life Cycle of Thread – Understanding Thread States in Java
Pankaj December 25, 2012 Java
Understanding Life Cycle of Thread and Thread States are very important when you are working with Threads and programming for multi-threaded environment.
As we learned in last tutorial, we can create a java thread class by implementing Runnable interface or by extending Thread class, but to start a java thread, we first have to create the Thread object and call it’s start() method to execute run() method as a thread.
Thread States
Below diagram shows different states of thread in java, note that we can create a thread in java and start it but how the thread states change from Runnable to Running to Blocked depends on the OS implementation of thread scheduler and java doesn’t have full control on that.
 
New
When we create a new Thread object using new operator, thread state is New Thread. At this point, thread is not alive and it’s a state internal to Java programming.
Runnable
When we call start() function on Thread object, it’s state is changed to Runnable and the control is given to Thread scheduler to finish it’s execution. Whether to run this thread instantly or keep it in runnable thread pool before running it depends on the OS implementation of thread scheduler.
Running
When thread is executing, it’s state is changed to Running. Thread scheduler picks one of the thread from the runnable thread pool and change it’s state to Running and CPU starts executing this thread. A thread can change state to Runnable, Dead or Blocked from running state depends on time slicing, thread completion of run() method or waiting for some resources.
Blocked/Waiting
A thread can be waiting for other thread to finish using thread join or it can be waiting for some resources to available, for example producer consumer problem or waiter notifier implementation or IO resources, then it’s state is changed to Waiting. Once the thread wait state is over, it’s state is changed to Runnable and it’s moved back to runnable thread pool.
Dead
Once the thread finished executing, it’s state is changed to Dead and it’s considered to be not alive.
Above are the different states of thread and it’s good to know them and how thread changes it’s state.

Java Daemon Thread Example
Pankaj December 31, 2012 Java
When we create a Thread in java, by default it’s a user thread and if it’s running JVM will not terminate the program. When a thread is marked as daemon thread, JVM doesn’t wait it to finish and as soon as all the user threads are finished, it terminates the program as well as all the associated daemon threads.
Thread.setDaemon(true) can be used to create a daemon thread in java. Let’s see a small example of java daemon thread.
JavaDaemonThread
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34	package com.journaldev.threads;
 
public class JavaDaemonThread {
 
    public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new DaemonThread(), "dt");
        dt.setDaemon(true);
        dt.start();
        //continue program
        Thread.sleep(30000);
        System.out.println("Finishing program");
    }
 
}
 
class DaemonThread implements Runnable{
 
    @Override
    public void run() {
        while(true){
            processSomething();
        }
    }
 
    private void processSomething() {
        try {
            System.out.println("Processing daemon thread");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
}
When we execute this program, JVM creates first user thread with main() function and then a daemon thread. When main function is finished, the program terminates and daemon thread is also shut down by JVM.
Here is the output of the above program.
1
2
3
4
5
6
7	Processing daemon thread
Processing daemon thread
Processing daemon thread
Processing daemon thread
Processing daemon thread
Processing daemon thread
Finishing program
If we don’t set the thread to be run as daemon thread, the program will never terminate even after main thread is finished it’s execution. Try commenting the statement to set thread as daemon thread and run the program.
Usually we create a daemon thread for functionalities that are not critical to system, for example logging thread or monitoring thread to capture the system resource details and their state.

Dependency Injection Design Pattern in Java Example Tutorial
Pankaj December 14, 2013 Design Patterns, Java
Dependency Injection design pattern allows us to remove the hard-coded dependencies and make our application loosely coupled, extendable and maintainable. We can implement dependency injection pattern to move the dependency resolution from compile-time to runtime.
Dependency injection pattern seems hard to grasp with theory, so I would take a simple example and then we will see how to use dependency injection pattern to achieve loose coupling and extendability in the application.
Let’s say we have an application where we consume EmailService to send emails. Normally we would implement this like below.
EmailService.java
1
2
3
4
5
6
7
8
9	package com.journaldev.java.legacy;
 
public class EmailService {
 
    public void sendEmail(String message, String receiver){
        //logic to send email
        System.out.println("Email sent to "+receiver+ " with Message="+message);
    }
}
EmailService class holds the logic to send email message to the recipient email address. Our application code will be like below.
MyApplication.java
1
2
3
4
5
6
7
8
9
10
11	package com.journaldev.java.legacy;
 
public class MyApplication {
 
    private EmailService email = new EmailService();
     
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.email.sendEmail(msg, rec);
    }
}
Our client code that will use MyApplication class to send email messages will be like below.
MyLegacyTest.java
1
2
3
4
5
6
7
8
9
10	package com.journaldev.java.legacy;
 
public class MyLegacyTest {
 
    public static void main(String[] args) {
        MyApplication app = new MyApplication();
        app.processMessages("Hi Pankaj", "pankaj@abc.com");
    }
 
}
At first look, there seems nothing wrong with above implementation. But above code logic has certain limitations.
•	MyApplication class is responsible to initialize the email service and then use it. This leads to hard-coded dependency. If we want to switch to some other advanced email service in future, it will require code changes in MyApplication class. This makes our application hard to extend and if email service is used in multiple classes then that would be even more harder.
•	If we want to extend our application to provide additional messaging feature, such as SMS or Facebook message then we would need to write another application for that. This will involve code changes in application classes and in client classes too.
•	Testing the application will be very difficult since our application is directly creating the email service instance. There is no way we can mock these objects in our test classes.
One can argue that we can remove the email service instance creation from MyApplication class by having a constructor that requires email service as argument.
MyApplication.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15	package com.journaldev.java.legacy;
 
public class MyApplication {
 
    private EmailService email = null;
     
    public MyApplication(EmailService svc){
        this.email=svc;
    }
     
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.email.sendEmail(msg, rec);
    }
}
But in this case, we are asking client applications or test classes to initializing the email service that is not a good design decision.
Now let’s see how we can apply dependency injection pattern to solve all the problems with above implementation. Dependency Injection pattern requires at least following:
1.	Service components should be designed with base class or interface. It’s better to prefer interfaces or abstract classes that would define contract for the services.
2.	Consumer classes should be written in terms of service interface.
3.	Injector classes that will initialize the services and then the consumer classes.
Service Components
For our case, we can have MessageService that will declare the contract for service implementations.
MessageService.java
1
2
3
4
5
6	package com.journaldev.java.dependencyinjection.service;
 
public interface MessageService {
 
    void sendMessage(String msg, String rec);
}
Now let’s say we have Email and SMS services that implement above interfaces.
EmailServiceImpl.java
1
2
3
4
5
6
7
8
9
10
11	package com.journaldev.java.dependencyinjection.service;
 
public class EmailServiceImpl implements MessageService {
 
    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send email
        System.out.println("Email sent to "+rec+ " with Message="+msg);
    }
 
}
SMSServiceImpl.java
1
2
3
4
5
6
7
8
9
10
11	package com.journaldev.java.dependencyinjection.service;
 
public class SMSServiceImpl implements MessageService {
 
    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send SMS
        System.out.println("SMS sent to "+rec+ " with Message="+msg);
    }
 
}
Our services are ready and now we can write our consumer class.
Service Consumer
We are not required to have base interfaces for consumer classes but I will have a Consumer interface declaring contract for consumer classes.
Consumer.java
1
2
3
4
5
6	package com.journaldev.java.dependencyinjection.consumer;
 
public interface Consumer {
 
    void processMessages(String msg, String rec);
}
My consumer class implementation is like below.
MyDIApplication.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19	package com.journaldev.java.dependencyinjection.consumer;
 
import com.journaldev.java.dependencyinjection.service.MessageService;
 
public class MyDIApplication implements Consumer{
 
    private MessageService service;
     
    public MyDIApplication(MessageService svc){
        this.service=svc;
    }
     
    @Override
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }
 
}
Notice that our application class is just using the service. It does not initialize the service that leads to better “separation of concerns“. Also use of service interface allows us to easily test the application by mocking the MessageService and bind the services at runtime rather than compile time.
Now we are ready to write injector classes that will initialize the service and also consumer classes.
Injectors Classes
Let’s have an interface MessageServiceInjector with method declaration that returns the Consumer class.
MessageServiceInjector.java
1
2
3
4
5
6
7
8	package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
 
public interface MessageServiceInjector {
 
    public Consumer getConsumer();
}
Now for every service, we will have to create injector classes like below.
EmailServiceInjector.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14	package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.service.EmailServiceImpl;
 
public class EmailServiceInjector implements MessageServiceInjector {
 
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }
 
}
SMSServiceInjector.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14	package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.service.SMSServiceImpl;
 
public class SMSServiceInjector implements MessageServiceInjector {
 
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }
 
}
Now let’s see how our client applications will use the application with a simple program.
MyMessageDITest.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28	package com.journaldev.java.dependencyinjection.test;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.injector.EmailServiceInjector;
import com.journaldev.java.dependencyinjection.injector.MessageServiceInjector;
import com.journaldev.java.dependencyinjection.injector.SMSServiceInjector;
 
public class MyMessageDITest {
 
    public static void main(String[] args) {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        String phone = "4088888888";
        MessageServiceInjector injector = null;
        Consumer app = null;
         
        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);
         
        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }
 
}
As you can see that our application classes are responsible only for using the service. Service classes are created in injectors. Also if we have to further extend our application to allow facebook messaging, we will have to write Service classes and injector classes only.
So dependency injection implementation solved the problem with hard-coded dependency and helped us in making our application flexible and easy to extend. Now let’s see how easily we can test our application class by mocking the injector and service classes.
JUnit Test Case with Mock Injector and Service
MyDIApplicationJUnitTest.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46	package com.journaldev.java.dependencyinjection.test;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.injector.MessageServiceInjector;
import com.journaldev.java.dependencyinjection.service.MessageService;
 
public class MyDIApplicationJUnitTest {
 
    private MessageServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = new MessageServiceInjector() {
             
            @Override
            public Consumer getConsumer() {
                //mock the message service
                return new MyDIApplication(new MessageService() {
                     
                    @Override
                    public void sendMessage(String msg, String rec) {
                        System.out.println("Mock Message Service implementation");
                         
                    }
                });
            }
        };
    }
     
    @Test
    public void test() {
        Consumer consumer = injector.getConsumer();
        consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
    }
     
    @After
    public void tear(){
        injector = null;
    }
 
}
As you can see that I am using anonymous classes to mock the injector and service classes and I can easily test my application methods. I am using JUnit 4 for above test class, so make sure it’s in your project build path if you are running above test class.
We have used constructors to inject the dependencies in the application classes, another way is to use setter method to inject dependencies in application classes. For setter method dependency injection, our application class will be implemented like below.
MyDIApplication.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22	package com.journaldev.java.dependencyinjection.consumer;
 
import com.journaldev.java.dependencyinjection.service.MessageService;
 
public class MyDIApplication implements Consumer{
 
    private MessageService service;
     
    public MyDIApplication(){}
 
    //setter dependency injection   
    public void setService(MessageService service) {
        this.service = service;
    }
 
    @Override
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }
 
}
EmailServiceInjector.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16	package com.journaldev.java.dependencyinjection.injector;
 
import com.journaldev.java.dependencyinjection.consumer.Consumer;
import com.journaldev.java.dependencyinjection.consumer.MyDIApplication;
import com.journaldev.java.dependencyinjection.service.EmailServiceImpl;
 
public class EmailServiceInjector implements MessageServiceInjector {
 
    @Override
    public Consumer getConsumer() {
        MyDIApplication app = new MyDIApplication();
        app.setService(new EmailServiceImpl());
        return app;
    }
 
}
One of the best example of setter dependency injection is Struts2 Servlet API Aware interfaces.
Whether to use Constructor based dependency injection or setter based is a design decision and depends on your requirements. For example, if my application can’t work at all without the service class then I would prefer constructor based DI or else I would go for setter method based DI to use it only when it’s really needed.
Dependency Injection is a way to achieve Inversion of control (IoC) in our application by moving objects binding from compile time to runtime. We can achieve IoC through Factory Pattern, Template Method Design Pattern, Strategy Pattern and Service Locator pattern too.
Spring, Google Guice and Java EE CDI frameworks facilitate the process of dependency injection through use of Java Reflection API and java annotations. All we need is to annotate the field, constructor or setter method and configure them in configuration xml files or classes.
Benefits of Dependency Injection
Some of the benefits of using Dependency Injection are:
•	Separation of Concerns
•	Boilerplate Code reduction in application classes because all work to initialize dependencies is handled by the injector component
•	Configurable components makes application easily extendable
•	Unit testing is easy with mock objects
Disadvantages of Dependency Injection
Dependency injection has some disadvantages too:
•	If overused, it can lead to maintenance issues because effect of changes are known at runtime.
•	Dependency injection hides the service class dependencies that can lead to runtime errors that would have been caught at compile time.

Spring IoC Container and Spring Bean Example Tutorial
Pankaj December 29, 2013 Spring
Spring Framework is built on the Inversion of Control (IOC) principle. Dependency injection is the technique to implement IoC in applications. This article is aimed to explain core concepts of Spring IoC container and Spring Bean with example programs.
1.	Spring IoC Container
2.	Spring Bean
3.	Spring Bean Scopes
4.	Spring Bean Configuration
5.	Spring IoC and Bean Example Project
A.	XML Based Bean Configuration
B.	Annotation Based Bean Configuration
C.	Java Based Bean Configuration
Spring IoC Container
Inversion of Control is the mechanism to achieve loose-coupling between Objects dependencies. To achieve loose coupling and dynamic binding of the objects at runtime, the objects define their dependencies that are being injected by other assembler objects. Spring IoC container is the program thatinjects dependencies into an object and make it ready for our use. We have already looked how we can use Spring Dependency Injection to implement IoC in our applications.
Spring Framework IoC container classes are part of org.springframework.beans andorg.springframework.context packages and provides us different ways to decouple the object dependencies.
BeanFactory is the root interface of Spring IoC container. ApplicationContext is the child interface ofBeanFactory interface that provide Spring’s AOP features, internationalization etc. Some of the useful child-interfaces of ApplicationContext are ConfigurableApplicationContext and WebApplicationContext. Spring Framework provides a number of useful ApplicationContext implementation classes that we can use to get the context and then the Spring Bean.
Some of the useful ApplicationContext implementations that we use are;
•	AnnotationConfigApplicationContext: If we are using Spring in standalone java applications and using annotations for Configuration, then we can use this to initialize the container and get the bean objects.
•	ClassPathXmlApplicationContext: If we have spring bean configuration xml file in standalone application, then we can use this class to load the file and get the container object.
•	FileSystemXmlApplicationContext: This is similar to ClassPathXmlApplicationContext except that the xml configuration file can be loaded from anywhere in the file system.
•	AnnotationConfigWebApplicationContext and XmlWebApplicationContext for web applications.
Usually if you are working on Spring MVC application and your application is configured to use Spring Framework, Spring IoC container gets initialized when application starts and when a bean is requested, the dependencies are injected automatically.
However for standalone application, you need to initialize the container somewhere in the application and then use it to get the spring beans.
Spring Bean
Spring Bean is nothing special, any object in the Spring framework that we initialize through Spring container is called Spring Bean. Any normal Java POJO class can be a Spring Bean if it’s configured to be initialized via container by providing configuration metadata information.
Spring Bean Scopes
There are five scopes defined for Spring Beans.
1.	singleton – Only one instance of the bean will be created for each container. This is the default scope for the spring beans. While using this scope, make sure bean doesn’t have shared instance variables otherwise it might lead to data inconsistency issues.
2.	prototype – A new instance will be created every time the bean is requested.
3.	request – This is same as prototype scope, however it’s meant to be used for web applications. A new instance of the bean will be created for each HTTP request.
4.	session – A new bean will be created for each HTTP session by the container.
5.	global-session – This is used to create global session beans for Portlet applications.
Spring Framework is extendable and we can create our own scopes too, however most of the times we are good with the scopes provided by the framework.
Spring Bean Configuration
Spring Framework provide three ways to configure beans to be used in the application.
1.	Annotation Based Configuration – By using @Service or @Component annotations. Scope details can be provided with @Scope annotation.
2.	XML Based Configuration – By creating Spring Configuration XML file to configure the beans. If you are using Spring MVC framework, the xml based configuration can be loaded automatically by writing some boiler plate code in web.xml file.
3.	Java Based Configuration – Starting from Spring 3.0, we can configure Spring beans using java programs. Some important annotations used for java based configuration are @Configuration, @ComponentScan and @Bean.
Spring IoC and Bean Example Project
Let’s look at the different aspects of Spring IoC container and Spring Bean configurations with a simple Spring project.
For my example, I am creating Spring MVC project in Spring Tool Suite. If you are new to Spring Tool Suite and Spring MVC, please read Spring MVC Tutorial with Spring Tool Suite.
The final project structure looks like below image.
 
Let’s look at different components one by one.
XML Based Bean Configuration
MyBean is a simple Java POJO class.
MyBean.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14	package com.journaldev.spring.beans;
 
public class MyBean {
 
    private String name;
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     
}
Spring Configuration XML File
servlet-context.xml
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28	<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
 
    <!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
     
    <!-- Enables the Spring MVC @Controller programming model -->
    <annotation-driven />
 
    <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
    <resources mapping="/resources/**" location="/resources/" />
 
    <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
    <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <beans:property name="prefix" value="/WEB-INF/views/" />
        <beans:property name="suffix" value=".jsp" />
    </beans:bean>
     
    <context:component-scan base-package="com.journaldev.spring" />
     
    <beans:bean name="myBean" class="com.journaldev.spring.beans.MyBean" scope="singleton" ></beans:bean>
     
</beans:beans>
Notice that MyBean is configured using bean element with scope as singleton.
Annotation Based Bean Configuration
MyAnnotatedBean.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21	package com.journaldev.spring.beans;
 
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
 
@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MyAnnotatedBean {
 
    private int empId;
 
    public int getEmpId() {
        return empId;
    }
 
    public void setEmpId(int empId) {
        this.empId = empId;
    }
     
}
MyAnnotatedBean is configured using @Service and scope is set to Request.
Controller Class
HomeController class will handle the HTTP requests for the home page of the application. We will inject our Spring beans to this controller class through WebApplicationContext container.
HomeController.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53	package com.journaldev.spring.controller;
 
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.journaldev.spring.beans.MyAnnotatedBean;
import com.journaldev.spring.beans.MyBean;
 
@Controller
@Scope("request")
public class HomeController {
         
    private MyBean myBean;
     
    private MyAnnotatedBean myAnnotatedBean;
 
    @Autowired
    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }
 
    @Autowired
    public void setMyAnnotatedBean(MyAnnotatedBean obj) {
        this.myAnnotatedBean = obj;
    }
     
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("MyBean hashcode="+myBean.hashCode());
        System.out.println("MyAnnotatedBean hashcode="+myAnnotatedBean.hashCode());
         
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
         
        String formattedDate = dateFormat.format(date);
         
        model.addAttribute("serverTime", formattedDate );
         
        return "home";
    }
     
}
Deployment Descriptor
We need to configure our application for Spring Framework, so that the configuration metadata will get loaded and context will be initialized.
web.xml
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33	<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
 
    <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/root-context.xml</param-value>
    </context-param>
     
    <!-- Creates the Spring Container shared by all Servlets and Filters -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
 
    <!-- Processes application requests -->
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
         
    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
 
</web-app>
Almost all the configuration above is boiler-plate code generated by STS tool automatically.
Run the Web Application
Now when you will launch the web application, the home page will get loaded and in the console following logs will be printed when you refresh the page multiple times.
1
2
3
4
5
6	MyBean hashcode=118267258
MyAnnotatedBean hashcode=1703899856
MyBean hashcode=118267258
MyAnnotatedBean hashcode=1115599742
MyBean hashcode=118267258
MyAnnotatedBean hashcode=516457106
Notice that MyBean is configured to be singleton, so the container is always returning the same instance and hashcode is always same. Similarly for each request, a new instance of MyAnnotatedBean is created with different hashcode.
Java Based Bean Configuration
For standalone applications, we can use annotation based as well as xml based configuration. The only requirement is to initialize the context somewhere in the program before we use it.
MyService.java
1
2
3
4
5
6
7
8
9
10	package com.journaldev.spring.main;
 
import java.util.Date;
 
public class MyService {
 
    public void log(String msg){
        System.out.println(new Date()+"::"+msg);
    }
}
MyService is a simple java class with some methods.
MyConfiguration.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15	package com.journaldev.spring.main;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@ComponentScan(value="com.journaldev.spring.main")
public class MyConfiguration {
 
    @Bean
    public MyService getService(){
        return new MyService();
    }
}
The annotation based configuration class that will be used to initialize the Spring container.
MyMainClass.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21	package com.journaldev.spring.main;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
public class MyMainClass {
 
    public static void main(String[] args) {
         
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                MyConfiguration.class);
        MyService service = ctx.getBean(MyService.class);
         
        service.log("Hi");
         
        MyService newService = ctx.getBean(MyService.class);
        System.out.println("service hashcode="+service.hashCode());
        System.out.println("newService hashcode="+newService.hashCode());
        ctx.close();
    }
 
}
A simple test program where we are initializing the AnnotationConfigApplicationContext context and then using getBean() method to get the instance of MyService.
Notice that I am calling getBean method two times and printing the hashcode. Since there is no scope defined for MyService, it should be singleton and hence hashcode should be the same for both the instances.
When we run the above application, we get following console output confirming our understanding.
1
2
3	Sat Dec 28 22:49:18 PST 2013::Hi
service hashcode=678984726
newService hashcode=678984726
If you are looking for XML based configuration, just create the Spring XML config file and then initialize the context with following code snippet.
1
2
3	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        MyService app = context.getBean(MyService.class);
That’s all for the Spring IoC container and Spring Bean Scopes and Configuration details. We will look into some more features of Spring Beans in future posts. Download the Spring Bean example project from below link and play around with it for better understanding.
Java Serialization Example Tutorial, Serializable, serialVersionUID
Pankaj December 27, 2013 Java
Java Serialization was introduced in JDK 1.1 and it is one of the important feature of Core Java.
Java Serialization API allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage. Deserialization is the process of converting Object stream to actual Java Object to be used in our program. Java Synchronization process seems very easy to use at first but it comes with some trivial security and integrity issues that we will look in the later part of this article. We will look into following topics in this tutorial.
1.	Java Serializable Interface
2.	Class Refactoring with Serialization and serialVersionUID
3.	Java Externalizable Interface
4.	Java Serialization Methods
5.	Serialization with Inheritance
6.	Serialization Proxy Pattern
Java Serializable Interface
If you want a class object to be serializable, all you need to do it implement the java.io.Serializableinterface. Serializable is a marker interface and has no fields or methods to implement. It’s like an Opt-In process through which we make our classes serializable.
Serialization process is implemented by ObjectInputStream and ObjectOutputStream, so all we need is a wrapper over them to either save it to file or send it over the network. Let’s see a simple Serialization example.
Employee.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52	package com.journaldev.serialization;
 
import java.io.Serializable;
 
public class Employee implements Serializable {
 
//  private static final long serialVersionUID = -6470090944414208496L;
     
    private String name;
    private int id;
    transient private int salary;
//  private String password;
     
    @Override
    public String toString(){
        return "Employee{name="+name+",id="+id+",salary="+salary+"}";
    }
     
    //getter and setter methods
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getSalary() {
        return salary;
    }
 
    public void setSalary(int salary) {
        this.salary = salary;
    }
 
//  public String getPassword() {
//      return password;
//  }
//
//  public void setPassword(String password) {
//      this.password = password;
//  }
     
}
Notice that it’s a simple java bean with some properties and getter-setter methods. If you want an object property to be not serialized to stream, you can use transient keyword like I have done with salary variable.
Now suppose we want to write our objects to file and then deserialize it from the same file. So we need utility methods that will use ObjectInputStream and ObjectOutputStream for serialization purposes.
SerializationUtil.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37	package com.journaldev.serialization;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
/**
 * A simple class with generic serialize and deserialize method implementations
 * 
 * @author pankaj
 * 
 */
public class SerializationUtil {
 
    // deserialize to Object from given file
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
 
    // serialize the given object and save it to file
    public static void serialize(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
 
        fos.close();
    }
 
}
Notice that the method arguments work with Object that is the base class of any java object. It’s written in this way to be generic in nature.
Now let’s write a test program to see Java Serialization in action.
SerializationTest.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34	package com.journaldev.serialization;
 
import java.io.IOException;
 
public class SerializationTest {
     
    public static void main(String[] args) {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);
         
        //serialize to file
        try {
            SerializationUtil.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
         
        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
         
        System.out.println("emp Object::"+emp);
        System.out.println("empNew Object::"+empNew);
    }
 
 
}
When we run above test program, we get following output.
1
2	emp Object::Employee{name=Pankaj,id=100,salary=5000}
empNew Object::Employee{name=Pankaj,id=100,salary=0}
Since salary is a transient variable, it’s value was not saved to file and hence not retrieved in the new object. Similarly static variable values are also not serialized since they belongs to class and not object.
Class Refactoring with Serialization and serialVersionUID
Java Serialization permits some changes in the java class if they can be ignored. Some of the changes in class that will not affect the deserialization process are:
•	Adding new variables to the class
•	Changing the variables from transient to non-transient, for serialization it’s like having a new field.
•	Changing the variable from static to non-static, for serialization it’s like having a new field.
But for all these changes to work, the java class should have serialVersionUID defined for the class. Let’s write a test class just for deserialization of the already serialized file from previous test class.
DeserializationTest.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22	package com.journaldev.serialization;
 
import java.io.IOException;
 
public class DeserializationTest {
 
    public static void main(String[] args) {
 
        String fileName="employee.ser";
        Employee empNew = null;
         
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
         
        System.out.println("empNew Object::"+empNew);
         
    }
 
}
Now uncomment the “password” variable and it’s getter-setter methods from Employee class and run it. You will get below exception;
1
2
3
4
5
6
7
8
9
10	java.io.InvalidClassException: com.journaldev.serialization.Employee; local class incompatible: stream classdesc serialVersionUID = -6470090944414208496, local class serialVersionUID = -6234198221249432383
    at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:604)
    at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1601)
    at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1514)
    at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1750)
    at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1347)
    at java.io.ObjectInputStream.readObject(ObjectInputStream.java:369)
    at com.journaldev.serialization.SerializationUtil.deserialize(SerializationUtil.java:22)
    at com.journaldev.serialization.DeserializationTest.main(DeserializationTest.java:13)
empNew Object::null
The reason is clear that serialVersionUID of the previous class and new class are different. Actually if the class doesn’t define serialVersionUID, it’s getting calculated automatically and assigned to the class. Java uses class variables, methods, class name, package etc to generate this unique long number. If you are working with any IDE, you will automatically get a warning that “The serializable class Employee does not declare a static final serialVersionUID field of type long”.
We can use java utility “serialver” to generate the class serialVersionUID, for Employee class we can run it with below command.
1	SerializationExample/bin$serialver -classpath . com.journaldev.serialization.Employee
Note that it’s not required that the serial version is generated from this program itself, we can assign this value as we want. It just need to be there to let deserialization process know that the new class is the new version of the same class and should be deserialized of possible.
For example, uncomment only the serialVersionUID field from the Employee class and runSerializationTest program. Now uncomment the password field from Employee class and run theDeserializationTest program and you will see that the object stream is deserialized successfully because the change in Employee class is compatible with serialization process.
Java Externalizable Interface
If you notice the serialization process, it’s done automatically. Sometimes we want to obscure the object data to maintain it’s integrity. We can do this by implementing java.io.Externalizable interface and provide implementation of writeExternal() and readExternal() methods to be used in serialization process.
Person.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62	package com.journaldev.externalization;
 
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
 
public class Person implements Externalizable{
 
    private int id;
    private String name;
    private String gender;
     
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name+"xyz");
        out.writeObject("abc"+gender);
    }
 
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        id=in.readInt();
        //read in the same order as written
        name=(String) in.readObject();
        if(!name.endsWith("xyz")) throw new IOException("corrupted data");
        name=name.substring(0, name.length()-3);
        gender=(String) in.readObject();
        if(!gender.startsWith("abc")) throw new IOException("corrupted data");
        gender=gender.substring(3);
    }
 
    @Override
    public String toString(){
        return "Person{id="+id+",name="+name+",gender="+gender+"}";
    }
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
}
Notice that I have changed the field values before converting it to Stream and then while reading reversed the changes. In this way, we can maintain data integrity of some sorts. We can throw exception if after reading the stream data, the integrity checks fail. Let’s write a test program to see it in action.
ExternalizationTest.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42	package com.journaldev.externalization;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class ExternalizationTest {
 
    public static void main(String[] args) {
         
        String fileName = "person.ser";
        Person person = new Person();
        person.setId(1);
        person.setName("Pankaj");
        person.setGender("Male");
         
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person p = (Person)ois.readObject();
            ois.close();
            System.out.println("Person Object Read="+p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
         
    }
 
}
When we run above program, we get following output.
1	Person Object Read=Person{id=1,name=Pankaj,gender=Male}
So which one is better to be used for serialization purpose. Actually it’s better to use Serializable interface and by the time we reach at the end of article, you will know why.
Java Serialization Methods
We have seen that java serialization is automatic and all we need is implementing Serializable interface. The implementation is present in the ObjectInputStream and ObjectOutputStream classes. But what if we want to change the way we are saving data, for example we have some sensitive information in the object and before saving/retrieving we want to encrypt/decrypt it. That’s why there are four methods that we can provide in the class to change the serialization behavior.
If these methods are present in the class, they are used for serialization purposes.
1.	readObject(ObjectInputStream ois): If this method is present in the class, ObjectInputStream readObject() method will use this method for reading the object from stream.
2.	writeObject(ObjectOutputStream oos): If this method is present in the class, ObjectOutputStream writeObject() method will use this method for writing the object to stream. One of the common usage is to obscure the object variables to maintain data integrity.
3.	Object writeReplace(): If this method is present, then after serialization process this method is called and the object returned is serialized to the stream.
4.	Object readResolve(): If this method is present, then after deserialization process, this method is called to return the final object to the caller program. One of the usage of this method is to implement Singleton pattern with Serialized classes. Read more at Serialization and Singleton.
Usually while implementing above methods, it’s kept as private so that subclasses can’t override them. They are meant for serialization purpose only and keeping them private avoids any security issue.
Serialization with Inheritance
Sometimes we need to extend a class that doesn’t implement Serializable interface. If we rely on the automatic serialization behavior and the superclass has some state, then they will not be converted to stream and hence not retrieved later on.
This is one place, where readObject() and writeObject() methods really help. By providing their implementation, we can save the super class state to the stream and then retrieve it later on. Let’s see this in action.
SuperClass.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22	package com.journaldev.serialization.inheritance;
 
public class SuperClass {
 
    private int id;
    private String value;
     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
     
     
}
SuperClass is a simple java bean but it’s not implementing Serializable interface.
SubClass.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53	package com.journaldev.serialization.inheritance;
 
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
public class SubClass extends SuperClass implements Serializable, ObjectInputValidation{
 
    private static final long serialVersionUID = -1322322139926390329L;
 
    private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
     
    @Override
    public String toString(){
        return "SubClass{id="+getId()+",value="+getValue()+",name="+getName()+"}";
    }
     
    //adding helper method for serialization to save/initialize super class state
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
        ois.defaultReadObject();
         
        //notice the order of read and write should be same
        setId(ois.readInt());
        setValue((String) ois.readObject());
         
    }
     
    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
         
        oos.writeInt(getId());
        oos.writeObject(getValue());
    }
 
    @Override
    public void validateObject() throws InvalidObjectException {
        //validate the object here
        if(name == null || "".equals(name)) throw new InvalidObjectException("name can't be null or empty");
        if(getId() <=0) throw new InvalidObjectException("ID can't be negative or zero");
    }
     
}
Notice that order of writing and reading the extra data to the stream should be same. We can put some logic in reading and writing data to make it secure.
Also notice that the class is implementing ObjectInputValidation interface. By implementingvalidateObject() method, we can put some business validations to make sure that the data integrity is not harmed.
Let’s write a test class and see if we can retrieve the super class state from serialized data or not.
InheritanceSerializationTest.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32	package com.journaldev.serialization.inheritance;
 
import java.io.IOException;
 
import com.journaldev.serialization.SerializationUtil;
 
public class InheritanceSerializationTest {
 
    public static void main(String[] args) {
        String fileName = "subclass.ser";
         
        SubClass subClass = new SubClass();
        subClass.setId(10);
        subClass.setValue("Data");
        subClass.setName("Pankaj");
         
        try {
            SerializationUtil.serialize(subClass, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
         
        try {
            SubClass subNew = (SubClass) SerializationUtil.deserialize(fileName);
            System.out.println("SubClass read = "+subNew);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
 
}
When we run above class, we get following output.
1	SubClass read = SubClass{id=10,value=Data,name=Pankaj}
So in this way, we can serialize super class state even though it’s not implementing Serializable interface. This strategy comes handy when the super class is a third-party class that we can’t change.
Serialization Proxy Pattern
Java Serialization comes with some serious pitfalls such as;
•	The class structure can’t be changed a lot without breaking the serialization process. So even though we don’t need some variables later on, we need to keep them just for backward compatibility.
•	Serialization causes huge security risks, an attacker can change the stream sequence and cause harm to the system. For example, user role is serialized and an attacker change the stream value to make it admin and run malicious code.
Serialization Proxy pattern is a way to achieve greater security with Serialization. In this pattern, an inner private static class is used as a proxy class for serialization purpose. This class is designed in the way to maintain the state of the main class. This pattern is implemented by properly implementing readResolve()and writeReplace() methods.
Let us first write a class which implements serialization proxy pattern and then we will analyze it for better understanding.
Data.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60	package com.journaldev.serialization.proxy;
 
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
 
public class Data implements Serializable{
 
    private static final long serialVersionUID = 2087368867376448459L;
 
    private String data;
     
    public Data(String d){
        this.data=d;
    }
 
    public String getData() {
        return data;
    }
 
    public void setData(String data) {
        this.data = data;
    }
     
    @Override
    public String toString(){
        return "Data{data="+data+"}";
    }
     
    //serialization proxy class
    private static class DataProxy implements Serializable{
     
        private static final long serialVersionUID = 8333905273185436744L;
         
        private String dataProxy;
        private static final String PREFIX = "ABC";
        private static final String SUFFIX = "DEFG";
         
        public DataProxy(Data d){
            //obscuring data for security
            this.dataProxy = PREFIX + d.data + SUFFIX;
        }
         
        private Object readResolve() throws InvalidObjectException {
            if(dataProxy.startsWith(PREFIX) && dataProxy.endsWith(SUFFIX)){
            return new Data(dataProxy.substring(3, dataProxy.length() -4));
            }else throw new InvalidObjectException("data corrupted");
        }
         
    }
     
    //replacing serialized object to DataProxy object
    private Object writeReplace(){
        return new DataProxy(this);
    }
     
    private void readObject(ObjectInputStream ois) throws InvalidObjectException{
        throw new InvalidObjectException("Proxy is not used, something fishy");
    }
}
•	Both Data and DataProxy class should implement Serializable interface.
•	DataProxy should be able to maintain the state of Data object.
•	DataProxy is inner private static class, so that other classes can’t access it.
•	DataProxy should have a single constructor that takes Data as argument.
•	Data class should provide writeReplace() method returning DataProxy instance. So when Data object is serialized, the returned stream is of DataProxy class. However DataProxy class is not visible outside, so it can’t be used directly.
•	DataProxy class should implement readResolve() method returning Data object. So when Data class is deserialized, internally DataProxy is deserialized and when it’s readResolve() method is called, we get Data object.
•	Finally implement readObject() method in Data class and throw InvalidObjectException to avoid hackers attack trying to fabricate Data object stream and parse it.
Let’s write a small test to check whether implementation works or not.
SerializationProxyTest.java
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28	package com.journaldev.serialization.proxy;
 
import java.io.IOException;
 
import com.journaldev.serialization.SerializationUtil;
 
public class SerializationProxyTest {
 
    public static void main(String[] args) {
        String fileName = "data.ser";
         
        Data data = new Data("Pankaj");
         
        try {
            SerializationUtil.serialize(data, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            Data newData = (Data) SerializationUtil.deserialize(fileName);
            System.out.println(newData);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
 
}
When we run above class, we get below output in console.
1	Data{data=Pankaj}
If you will open the data.ser file, you can see that DataProxy object is saved as stream in the file.
http://www.journaldev.com/2452/java-serialization-example-tutorial-serializable-serialversionuid
http://www.journaldev.com/2461/spring-ioc-container-and-spring-bean-example-tutorial
http://www.journaldev.com/2394/dependency-injection-design-pattern-in-java-example-tutorial

Why String is immutable or final in Java
Pankaj November 29, 2012 Java
String is one of the most used classes in any programming language. As we know that String is immutable and final in java and java runtime maintains a String pool that makes it a special class.
String immutable Benefits
1. String pool is possible only because String is immutable in java, this way Java Runtime saves a lot of java heap space because different String variables can refer to same String variable in the pool. If String would not have been immutable, then String interning would not have been possible because if any variable would have changed the value, it would have been reflected to other variables also.
2. If String is not immutable then it would cause severe security threat to the application. For example, database username, password are passed as String to get database connection and in socket programming host and port details passed as String. Since String is immutable it’s value can’t be changed otherwise any hacker could change the referenced value to cause security issues in the application.
3. Since String is immutable, it is safe for multithreading and a single String instance can be shared across different threads. This avoid the usage of synchronization for thread safety, Strings are implicitly thread safe.
4. Strings are used in java classloader and immutability provides security that correct class is getting loaded by Classloader. For example, think of an instance where you are trying to load java.sql.Connection class but the referenced value is changed to myhacked.Connection class that can do unwanted things to your database.
5. Since String is immutable, its hashcode is cached at the time of creation and it doesn’t need to be calculated again. This makes it a great candidate for key in a Map and it’s processing is fast than other HashMap key objects. This is why String is mostly used Object as HashMap keys.
Above are some of the reasons I could think of that shows benefits of String immutability. It’s a great feature of Java String class and makes it special.
http://www.journaldev.com/1016/java-thread-example-extending-thread-class-and-implementing-runnable-interface


