# Table of content
<details><summary><b>[1 - What is Java]</b></summary>

### What is Java

Java is an internet based object oriented programing language. Oriented programing language is a programing methodology that helps to organized complex program through the use of Inheritance, encapsulation and polymorphism. 

Java derives much of its character from C and C++. This is by intent, the java designer knows that using the familiar syntax of C++ would make their language appealing to the legions of experienced C/C++ programmer.

In addition to the surface similarities java shares some of the other attributes that helped make C and C++ successful.

	1. Java was designed tested and refined by real working programmers. It is language grounded in the need and experience of the people who device it. Thus java is also a programmer’s language.
	2. Java is a cohesive and logically consistent.
	3. Except for those constraints imposed by the internet environment java gives you full control if your program reflect it. If your program poorly your program reflect that too.
 
The internet helped catapult of java to the forefront of programing and java. In turn has had a profound effect on the internet. The reason for this is quite simple:
Java expands the universe of objects that can be move about freely in cyberspace. In a network two very broad category of objects are transmitted between server and your personal computer.  

Passive information and dynamic active program for example if you read your mail you are viewing passive data even when you download a programs code is still only passive data until you execute it.

However a second type of object can be transmitted to your computer. A dynamic, self-executing programs, such a program is an active agent on a client computer yet is initiated by the server. For example, a program might be provided by the server to display properly the data that the server is sending.
Note: Java is a case sensitive language. 

Java is an object-oriented, class-based, concurrent, secured and general-purpose computer-programming language. It is a widely used robust technology.

Java is a programming language and a platform. Java is a high level, robust, object-oriented and secure programming language.

Java was developed by Sun Microsystems (which is now the subsidiary of Oracle) in the year 1995. James Gosling is known as the father of Java. Before Java, its name was Oak. Since Oak was already a registered company, so James Gosling and his team changed the Oak name to Java.

Platform: Any hardware or software environment in which a program runs, is known as a platform. Since Java has a runtime environment (JRE) and API, it is called a platform.

</details><details><summary><b>[2 - Types of Java Applications]</b></summary>

### Types of Java Applications

There are mainly 4 types of applications that can be created using Java programming:

1) Standalone Application
Standalone applications are also known as desktop applications or window-based applications. These are traditional software that we need to install on every machine. Examples of standalone application are Media player, antivirus, etc. AWT and Swing are used in Java for creating standalone applications.

2) Web Application
An application that runs on the server side and creates a dynamic page is called a web application. Currently, Servlet, JSP, Struts, Spring, Hibernate, JSF, etc. technologies are used for creating web applications in Java.

3) Enterprise Application
An application that is distributed in nature, such as banking applications, etc. is called enterprise application. It has advantages of the high-level security, load balancing, and clustering. In Java, EJB is used for creating enterprise applications.

4) Mobile Application
An application which is created for mobile devices is called a mobile application. Currently, Android and Java ME are used for creating mobile applications.
</details>

<details><summary><b>[3 - Java Platforms / Editions]</b></summary>

### Java Platforms / Editions

There are 4 platforms or editions of Java:

1) Java SE (Java Standard Edition)

It is a Java programming platform. It includes Java programming APIs such as java.lang, java.io, java.net, java.util, java.sql, java.math etc. It includes core topics like OOPs, String, Regex, Exception, Inner classes, Multithreading, I/O Stream, Networking, AWT, Swing, Reflection, Collection, etc.

2) Java EE (Java Enterprise Edition)
   
It is an enterprise platform which is mainly used to develop web and enterprise applications. It is built on the top of the Java SE platform. It includes topics like Servlet, JSP, Web Services, EJB, JPA, etc.

3) Java ME (Java Micro Edition)

It is a micro platform which is mainly used to develop mobile applications.

4) JavaFX
   
It is used to develop rich internet applications. It uses a light-weight user interface API.
</details>

<details><summary><b>[4 - Features of Java]</b></summary>

### Features of Java:

The primary objective of Java programming language creation was to make it portable, simple and secure programming language. Apart from this, there are also some excellent features which play an important role in the popularity of this language. The features of Java are also known as java buzzwords.
A list of most important features of Java language is given below.

<details><summary><b>[4.1 - Simple]</b></summary>

Java is very easy to learn, and its syntax is simple, clean and easy to understand. According to Sun, Java language is a simple programming language because:

- Java syntax is based on C++ (so easier for programmers to learn it after C++).
- Java has removed many complicated and rarely-used features, for example, explicit pointers, operator overloading, etc.
- There is no need to remove unreferenced objects because there is an Automatic Garbage Collection in Java.
  
</details>  
<details><summary><b>[4.2 - Object-oriented]</b></summary>

Java is an object-oriented programming language. Everything in Java is an object. Object-oriented means we organize our software as a combination of different types of objects that incorporates both data and behavior.

Object-oriented programming (OOPs) is a methodology that simplifies software development and maintenance by providing some rules.

Basic concepts of OOPs are:
	1. Object
	2. Class
	3. Inheritance
	4. Polymorphism
	5. Abstraction
	6. Encapsulation
</details>  
<details><summary><b>[4.3 - Platform Independent]</b></summary>

Java is platform independent because it is different from other languages like C, C++, etc. which are compiled into platform specific machines while Java is a write once, run anywhere language. A platform is the hardware or software environment in which a program runs.

There are two types of platforms software-based and hardware-based. Java provides a software-based platform.

The Java platform differs from most other platforms in the sense that it is a software-based platform that runs on the top of other hardware-based platforms. 

It has two components:

	1. Runtime Environment
	2. API(Application Programming Interface)
		
Java code can be run on multiple platforms, for example, Windows, Linux, Sun Solaris, Mac/OS, etc. Java code is compiled by the compiler and converted into bytecode. This bytecode is a platform-independent code because it can be run on multiple platforms, i.e., Write Once and Run Anywhere (WORA).
</details>  
<details><summary><b>[4.4 - Secured]</b></summary>   
	
The fact that a java program is interpreted also helps to make it secure. Because execution of every java program is under the control of JVM. The JVM can contain the programs and prevent it from generating side effect outside of the system. As you will see, safety is also enhanced by certain restrictions that exist in java language.

When program is interpreted it generally runs substantially slower than it would run if compiled to executable code. The use of bytecode enables the java runtime system to execute program much faster than you might expect.

Although java was designed for interpretation there is technically nothing about java that prevent on the fly compiled if bytecode into native code. Along this lines, sun supplies it’s just in time (JIT) compiler for bytecode which is include in the java 2 release. 

When you download the normal program you are risking of viral infection. Worries about infecting their system addition of virus another type of malicious program exist that must be guarded against java provides firewall between networked application and your computer.
		
Java is best known for its security. With Java, we can develop virus-free systems. Java is secured because:

- No explicit pointer
- Java Programs run inside a virtual machine sandbox
	
- Classloader: Classloader in Java is a part of the Java Runtime Environment (JRE) which is used to load Java classes into the Java Virtual Machine dynamically. It adds security by separating the package for the classes of the local file system from those that are imported from network sources.
- Bytecode Verifier: It checks the code fragments for illegal code that can violate access right to objects.  
- Security Manager: It determines what resources a class can access such as reading and writing to the local disk.

Java language provides these securities by default. Some security can also be provided by an application developer explicitly through SSL, JAAS, Cryptography, etc.
</details> 
<details><summary><b>[4.5 - Robust]</b></summary>   
  
Robust simply means strong. Java is robust because:
- It uses strong memory management.
- There is a lack of pointers that avoids security problems.
- There is automatic garbage collection in java which runs on the Java Virtual Machine to get rid of objects which are not being used by a Java application anymore.
- There are exception handling and the type checking mechanism in Java. All these points make Java robust.
</details> 
<details><summary><b>[4.6 - Architecture-neutral]</b></summary>   
  
Java is architecture neutral because there are no implementation dependent features, for example, the size of primitive types is fixed.

In C programming, int data type occupies 2 bytes of memory for 32-bit architecture and 4 bytes of memory for 64-bit architecture. However, it occupies 4 bytes of memory for both 32 and 64-bit architectures in Java.
</details> 
<details><summary><b>[4.7 - Portable]</b></summary>  
  
Remember, although the details of the java program were compiled to native code then different version of the same program would have to exist for each type of CPU connected to the internet. This is of course, not a feasible solution thus the interpretation of bytecode is the easiest way to create truly portable program.

Java is portable because it facilitates you to carry the Java bytecode to any platform. It doesn't require any implementation.
</details> 
<details><summary><b>[4.8 - High-performance]</b></summary>   
	
Java is faster than other traditional interpreted programming languages because Java bytecode is "close" to native code. It is still a little bit slower than a compiled language (e.g., C++). Java is an interpreted language that is why it is slower than compiled languages, e.g., C, C++, etc.
</details>
<details><summary><b>[4.9 - Distributed]</b></summary>

Java is distributed because it facilitates users to create distributed applications in Java. RMI and EJB are used for creating distributed applications. This feature of Java makes us able to access files by calling the methods from any machine on the internet.
</details>
<details><summary><b>[4.10 - Multi-threaded]</b></summary>

A thread is like a separate program, executing concurrently. We can write Java programs that deal with many tasks at once by defining multiple threads. The main advantage of multi-threading is that it doesn't occupy memory for each thread. It shares a common memory area. Threads are important for multi-media, Web applications, etc.
</details>
<details><summary><b>[4.11 - Dynamic]</b></summary>
  
Java is a dynamic language. It supports dynamic loading of classes. It means classes are loaded on demand. It also supports functions from its native languages, i.e., C and C++.
Java supports dynamic compilation and automatic memory management (garbage collection).
</details>
<details><summary><b>[4.12 - Bytecode]</b></summary>

The key allows java to solve both the security and portability problem just describe is that the output of java compiler is not executable code. Rather, it is bytecode.

Bytecode is highly optimized set of instructions designed to be executed by the java runtime system, which is called the java virtual machine (JVM) that is, in its standard form, the JVM is an interpreter for bytecode.

As you know, C++ is compiled to be executable code in fact most modern language are designed to be compiled not interpreted mostly because of performance concerns. However the fact that java program is executed by the JVM helps solve the major problem associated with downloading programs over the internet. 

Translating a java program into bytecode helps makes it much easier to run a program in a wide variety of environments. The reason is straight forward: - Only the JVM need to be implemented for each platform.

Once the runtime package exist for a given systems only java program can run on it.
</details>
<details><summary><b>[4.13 - Interpretation JIT (Just in Time)]</b></summary>

When the JIT is part of the JVM it compiles bytecode into executable code in real time on a piece by piece demand basis. It is important to understand that it is not possible to compile an entire java program into executable code all at once, because java performs various runtime checks that can be done only at runtime instead the JIT compiles code as it needed during execution.
</details>
</details>
<details><summary><b>[5 - Two Paradigm]</b></summary>

#### Two Paradigm
1.	Process Oriented Model
2.	Object Oriented Programming Model

All computer programs consists of two elements: code and data. Program can be conceptually organized around its code or around its data.

That is some programs are written around “what is happening” and others are written around “who is being affected”, these are the two paradigms that governs how program is constructed.
The first way is called the process oriented model. This approach characterized a program as a series of linear steps (that is code). 

The process oriented model can be thought of as code acting on data. Procedural language such as c employs this model to considerable success. Problem with this approaches appears as program grows larger and more complex.

To manage increasing complexity the second approach called object oriented programing was conceived.

Object oriented programing organizes a program around its data (that is objects) and a set of well-defined interfaces to that data. An object oriented program can be characterized as data controlling access to code.

<details>
<summary><b>[5.1 - Advantage of OOPs over Procedure-oriented programming language]</b></summary>

#### Advantage of OOPs over Procedure-oriented programming language
1) OOPs makes development and maintenance easier, whereas, in a procedure-oriented programming language, it is not easy to manage if code grows as project size increases.
2) OOPs provides data hiding, whereas, in a procedure-oriented programming language, global data can be accessed from anywhere.
 
Figure: Data Representation in Procedure-Oriented Programming

Figure: Data Representation in Object-Oriented Programming
3) OOPs provides the ability to simulate real-world event much more effectively. We can provide the solution of real word problem if we are using the Object-Oriented Programming language.
</details>
<details><summary><b>[5.2 - What is the difference between an object-oriented programming language and object-based programming language?]</b></summary>

Object-based programming language follows all the features of OOPs except Inheritance. JavaScript and VBScript are examples of object-based programming languages.
</details>
</details>
<details><summary><b>[6 - OOPs (Object-Oriented Programming System)]</b></summary>
 
#### OOPs (Object-Oriented Programming System)
Object means a real-world entity such as a pen, chair, table, computer, watch, etc. Object-Oriented Programming is a methodology or paradigm to design a program using classes and objects. It simplifies software development and maintenance by providing some concepts:
- Object
- Class
- Inheritance
- Polymorphism
- Abstraction
- Encapsulation
  
Apart from these concepts, there are some other terms which are used in Object-Oriented design:

- Coupling
- Cohesion
- Association
- Aggregation
- Composition
</details>
<details><summary><b>[7 - Class]</b></summary>

#### Class

Class is user defined templates. It defines a new datatypes.

We just mentioned that object contains data and code to manipulate that data. The entire set of data and code of an object can be made a user defined datatypes with the help of a class. Once class has been defined we can create any number of object is associated with the data of type class with which they are created.

A class is thus a collection of object of dissimilar types. The data or variables defined within the class are called instance variables. The code contained within method. Collectively the method and variables defined within a class are called member of the class.

Class is a combination of different datatypes which is used to create an object. Class is a templates of object. An object is an instance of class. In fact an object are variable of the type class. 
Collection of objects is called class. It is a logical entity.

A class can also be defined as a blueprint from which you can create an individual object. Class doesn't consume any space.

A class is a group of objects which have common properties. It is a template or blueprint from which objects are created. It is a logical entity. It can't be physical.

#### A class in Java can contain:

- Fields
- Methods
- Constructors
- Blocks
- Nested class and interface
 
Syntax to declare a class:
```java
class <class_name>{  
    field;  
method;  
}
```
</details>
<details><summary><b>[8 - Instance variable in Java]</b></summary>

#### Instance variable in Java
A variable which is created inside the class but outside the method is known as an instance variable. Instance variable doesn't get memory at compile time. It gets memory at runtime when an object or instance is created. That is why it is known as an instance variable.
</details>
<details><summary><b>[9 - Object]</b></summary>

#### Object
The data or variables defined within a class are called instance variable. The code is contained within methods collectively, the methods and variables defined within a class are called member of the class.

An Object can be defined as an instance of a class. An object contains an address and takes up some space in memory. Objects can communicate without knowing the details of each other's data or code. The only necessary thing is the type of message accepted and the type of response returned by the objects.

- Declaring Objects
As just explained, when you create a class, you are creating a new data type. You can use this type to declare objects of that type. However, obtaining objects of a class is a two-step process. 

First, you must declare a variable of the class type. This variable does not define an object. Instead, it is simply a variable that can refer to an object. 

Second, you must acquire an actual, physical copy of the object and assign it to that variable. You can do this using the new operator. The new operator dynamically allocates (that is, allocates at run time) memory for an object and returns a reference to it. This reference is, more or less, the address in memory of the object allocated by new. This reference is then stored in the variable. Thus, in Java, all class objects must be dynamically allocated.

The distinction between a class and an object. A class creates a new data type that can be used to create objects. That is, a class creates a logical framework that defines the relationship between its members. When you declare an object of a class, you are creating an instance of that class. Thus, a class is a logical construct. An object has physical reality. (That is, an object occupies space in memory.)

Example: A dog is an object because it has states like color, name, breed, etc. as well as behaviors like wagging the tail, barking, eating, etc.

An entity that has state and behavior is known as an object e.g., chair, bike, marker, pen, table, keyboard, car, etc. It can be physical or logical (tangible and intangible). The example of an intangible object is the banking system.
   
- An object has three characteristics:
o	State: represents the data (value) of an object.
o	Behavior: represents the behavior (functionality) of an object such as deposit, withdraw, etc.
o	Identity: An object identity is typically implemented via a unique ID. The value of the ID is not visible to the external user. However, it is used internally by the JVM to identify each object uniquely.
 
For Example, Pen is an object. Its name is Reynolds; color is white, known as its state. It is used to write, so writing is its behavior.

An object is an instance of a class. A class is a template or blueprint from which objects are created. So, an object is the instance (result) of a class.

- Object Definitions:
o	An object is a real-world entity.
o	An object is a runtime entity.
o	The object is an entity which has state and behavior.
o	The object is an instance of a class.

</details>
<details><summary><b>[10 - new keyword in Java]</b></summary>

#### new keyword in Java
The new keyword is used to allocate memory at runtime. All objects get memory in Heap memory area.

Object and Class Example: main within the class

In this example, we have created a Student class which has two data members id and name. We are creating the object of the Student class by new keyword and printing the object's value.

Here, we are creating a main() method inside the class.

File: Student.java

```java
//Java Program to illustrate how to define a class and fields  
//Defining a Student class.  
class Student{  
 //defining fields  
 int id;//field or data member or instance variable  
 String name;  
 //creating main method inside the Student class  
public static void main(String args[]){  
  //Creating an object or instance  
  Student s1=new Student();//creating an object of Student  
  //Printing values of the object  
  System.out.println(s1.id);//accessing member through reference variable  
  System.out.println(s1.name);  
 }  
}
``` 
> Test it Now
> Output:
> 0 
> null

Object and Class Example: main outside the class

In real time development, we create classes and use it from another class. It is a better approach than previous one. Let's see a simple example, where we are having main() method in another class.

We can have multiple classes in different Java files or single Java file. If you define multiple classes in a single Java source file, it is a good idea to save the file name with the class name which has main() method.

File: TestStudent1.java

```java
//Java Program to demonstrate having the main method in   
//another class  
//Creating Student class.  
class Student{  
 int id;  
 String name;  
}  
//Creating another class TestStudent1 which contains the main method  
class TestStudent1{  
 public static void main(String args[]){  
  Student s1=new Student();  
  System.out.println(s1.id);  
  System.out.println(s1.name);  
 }  
}
```
> Test it Now
> Output:
> 0 
> null

<details><summary><b>[10.1 - 3 Ways to initializing object]</b></summary>

#### 3 Ways to initializing object
There are 3 ways to initialize object in Java.
1.	By reference variable
2.	By method
3.	By constructor

1) Object and Class Example: Initialization through reference
Initializing an object means storing data into the object. Let's see a simple example where we are going to initialize the object through a reference variable.

File: TestStudent2.java

```java
class Student{  
 int id;  
 String name;  
}  
class TestStudent2{  
 public static void main(String args[]){  
  Student s1=new Student();  
  s1.id=101;  
  s1.name="Sonoo";  
  System.out.println(s1.id+" "+s1.name);//printing members with a white space  
 }  
}
```
> Test it Now
> Output:
> 101 Sonoo
We can also create multiple objects and store information in it through reference variable.

File: TestStudent3.java

```java
class Student{  
 int id;  
 String name;  
}  
class TestStudent3{  
 public static void main(String args[]){  
  //Creating objects  
  Student s1=new Student();  
  Student s2=new Student();  
//Initializing objects  
  s1.id=101;  
  s1.name="Sonoo";  
  s2.id=102;  
  s2.name="Amit";  
  //Printing data  
System.out.println(s1.id+" "+s1.name);  
  System.out.println(s2.id+" "+s2.name);  
 }  
}
```
> Test it Now
> Output:
> 101 Sonoo
> 102 Amit

2) Object and Class Example: Initialization through method

In this example, we are creating the two objects of Student class and initializing the value to these objects by invoking the insertRecord method. Here, we are displaying the state (data) of the objects by invoking the displayInformation() method.

File: TestStudent4.java

```java
class Student{  
 int rollno;  
 String name;  
 void insertRecord(int r, String n){  
  rollno=r;  
  name=n;  
 }  
void displayInformation(){System.out.println(rollno+" "+name);}  
}  
class TestStudent4{  
 public static void main(String args[]){  
Student s1=new Student();  
  Student s2=new Student();  
  s1.insertRecord(111,"Karan");  
  s2.insertRecord(222,"Aryan");  
  s1.displayInformation();  
  s2.displayInformation();  
 }  
}
```
> Test it Now
> Output:
> 111 Karan
> 222 Aryan
 
As you can see in the above figure, object gets the memory in heap memory area. The reference variable refers to the object allocated in the heap memory area. Here, s1 and s2 both are reference variables that refer to the objects allocated in memory.
________________________________________
3) Object and Class Example: Initialization through a constructor
We will learn about constructors in Java later.
________________________________________
Object and Class Example: Employee
Let's see an example where we are maintaining records of employees.
```java
File: TestEmployee.java
1.	class Employee{  
2.	    int id;  
3.	    String name;  
4.	    float salary;  
5.	    void insert(int i, String n, float s) {  
6.	        id=i;  
7.	        name=n;  
8.	        salary=s;  
9.	    }  
10.	    void display(){System.out.println(id+" "+name+" "+salary);}  
11.	}  
12.	public class TestEmployee {  
13.	public static void main(String[] args) {  
14.	    Employee e1=new Employee();  
15.	    Employee e2=new Employee();  
16.	    Employee e3=new Employee();  
17.	    e1.insert(101,"ajeet",45000);  
18.	    e2.insert(102,"irfan",25000);  
19.	    e3.insert(103,"nakul",55000);  
20.	    e1.display();  
21.	    e2.display();  
22.	    e3.display();  
23.	}  
24.	}
```
> Test it Now
> Output:
> 101 ajeet 45000.0
> 102 irfan 25000.0
> 103 nakul 55000.0

Object and Class Example: Rectangle

There is given another example that maintains the records of Rectangle class.
```java
File: TestRectangle1.java
1.	class Rectangle{  
2.	 int length;  
3.	 int width;  
4.	 void insert(int l, int w){  
5.	  length=l;  
6.	  width=w;  
7.	 }  
8.	 void calculateArea(){System.out.println(length*width);}  
9.	}  
10.	class TestRectangle1{  
11.	 public static void main(String args[]){  
12.	  Rectangle r1=new Rectangle();  
13.	  Rectangle r2=new Rectangle();  
14.	  r1.insert(11,5);  
15.	  r2.insert(3,15);  
16.	  r1.calculateArea();  
17.	  r2.calculateArea();  
18.	}  
19.	}
```
> Test it Now
> Output:
> 55 
> 45    
</details>
<details><summary><b>[10.2 - What are the different ways to create an object in Java?]</b></summary>

#### What are the different ways to create an object in Java?
There are many ways to create an object in java. They are:
o	By new keyword
o	By newInstance() method
o	By clone() method
o	By deserialization
o	By factory method etc.
We will learn these ways to create object later.
</details>
<details><summary><b>[10.3 - Anonymous Objects]</b></summary>

#### Anonymous Objects
Anonymous simply means nameless. An object which has no reference is known as an anonymous object. It can be used at the time of object creation only.
If you have to use an object only once, an anonymous object is a good approach. For example:
> 1.	new Calculation();//anonymous object

Calling method through a reference:
1.	Calculation c=new Calculation();  
2.	c.fact(5);
   
Calling method through an anonymous object
1.	new Calculation().fact(5);
   
Let's see the full example of an anonymous object in Java.
```java
1.	class Calculation{  
2.	 void fact(int  n){  
3.	  int fact=1;  
4.	  for(int i=1;i<=n;i++){  
5.	   fact=fact*i;  
6.	  }  
7.	 System.out.println("factorial is "+fact);  
8.	}  
9.	public static void main(String args[]){  
10.	 new Calculation().fact(5);//calling method with anonymous object  
11.	}  
12.	}
```
> Output:
> Factorial is 120
</details>
<details><summary><b>[10.4 - Creating multiple objects by one type only]</b></summary>
	
#### Creating multiple objects by one type only

We can create multiple objects by one type only as we do in case of primitives.

Initialization of primitive variables:
1.	int a=10, b=20;

Initialization of refernce variables:
1.	Rectangle r1=new Rectangle(), r2=new Rectangle();//creating two objects

Let's see the example:
```java
1.	//Java Program to illustrate the use of Rectangle class which  
2.	//has length and width data members  
3.	class Rectangle{  
4.	 int length;  
5.	 int width;  
6.	 void insert(int l,int w){  
7.	  length=l;  
8.	  width=w;  
9.	 }  
10.	 void calculateArea(){System.out.println(length*width);}  
11.	}  
12.	class TestRectangle2{  
13.	 public static void main(String args[]){  
14.	  Rectangle r1=new Rectangle(),r2=new Rectangle();//creating two objects  
15.	  r1.insert(11,5);  
16.	  r2.insert(3,15);  
17.	  r1.calculateArea();  
18.	  r2.calculateArea();  
19.	}  
20.	}
```
> Test it Now
> Output:
> 55 
> 45     
Real World Example: Account
```java
File: TestAccount.java
1.	//Java Program to demonstrate the working of a banking-system  
2.	//where we deposit and withdraw amount from our account.  
3.	//Creating an Account class which has deposit() and withdraw() methods  
4.	class Account{  
5.	int acc_no;  
6.	String name;  
7.	float amount;  
8.	//Method to initialize object  
9.	void insert(int a,String n,float amt){  
10.	acc_no=a;  
11.	name=n;  
12.	amount=amt;  
13.	}  
14.	//deposit method  
15.	void deposit(float amt){  
16.	amount=amount+amt;  
17.	System.out.println(amt+" deposited");  
18.	}  
19.	//withdraw method  
20.	void withdraw(float amt){  
21.	if(amount<amt){  
22.	System.out.println("Insufficient Balance");  
23.	}else{  
24.	amount=amount-amt;  
25.	System.out.println(amt+" withdrawn");  
26.	}  
27.	}  
28.	//method to check the balance of the account  
29.	void checkBalance(){System.out.println("Balance is: "+amount);}  
30.	//method to display the values of an object  
31.	void display(){System.out.println(acc_no+" "+name+" "+amount);}  
32.	}  
33.	//Creating a test class to deposit and withdraw amount  
34.	class TestAccount{  
35.	public static void main(String[] args){  
36.	Account a1=new Account();  
37.	a1.insert(832345,"Ankit",1000);  
38.	a1.display();  
39.	a1.checkBalance();  
40.	a1.deposit(40000);  
41.	a1.checkBalance();  
42.	a1.withdraw(15000);  
43.	a1.checkBalance();  
44.	}
}
```
> Test it Now
> Output:
> 832345 Ankit 1000.0
> Balance is: 1000.0
> 40000.0 deposited
> Balance is: 41000.0
> 15000.0 withdrawn
> Balance is: 26000.0
</details>
</details>

<details><summary><b>[11 - The Three OOP’s principles]</b></summary>
	
#### The Three OOP’s principles:
1.	Encapsulation
2.	Inheritance
3.	Polymorphism
<details><summary><b>[11.1 - Encapsulation in Java]</b></summary>

#### Encapsulation in Java
Encapsulation is mechanism that binds together code and data it manipulate and keep both safe from outside interference and misuse. One way to think about encapsulation is a protective wrapper that prevents code and data from being arbitrary accessed by the other code defined outside the wrapper. Access to the code and data inside the wrapper is tightly control through a well-defined interface.
An object has properties and behavior that are encapsulated inside the object. The service is offers to its client comprises its contract, only the contract defined by the object is available to the clients. The implementation of its properties and behaviors is not concern of the clients. Encapsulation helps make clear the distinction between an objects contract and implementation. This has major consequences for program development. This implementation of an object can change without implications for the client. Encapsulation also reduces complexity as the internals of an object are hidden from the clients who cannot influence (i.e. effect or impact) its implementation.

A java class is the example of encapsulation. Java bean is the fully encapsulated class because all the data members are private here.
Encapsulation in Java is a process of Binding (or wrapping) code and data together into a single unit, for example, a capsule, it is wrapped with different medicines.
 
We can create a fully encapsulated class in Java by making all the data members of the class private. Now we can use setter and getter methods to set and get the data in it.

The Java Bean class is the example of a fully encapsulated class.

#### Advantage of Encapsulation in Java

By providing only a setter or getter method, you can make the class read-only or write-only. In other words, you can skip the getter or setter methods.

It provides you the control over the data. Suppose you want to set the value of id which should be greater than 100 only, you can write the logic inside the setter method. You can write the logic not to store the negative numbers in the setter methods.
It is a way to achieve data hiding in Java because other class will not be able to access the data through the private data members.
The encapsulate class is easy to test. So, it is better for unit testing.

The standard IDE's are providing the facility to generate the getters and setters. So, it is easy and fast to create an encapsulated class in Java.

Simple Example of Encapsulation in Java

Let's see the simple example of encapsulation that has only one field with its setter and getter methods.
```java
File: Student.java
1.	//A Java class which is a fully encapsulated class.  
2.	//It has a private data member and getter and setter methods.  
3.	package com.javatpoint;  
4.	public class Student{  
5.	//private data member  
6.	private String name;  
7.	//getter method for name  
8.	public String getName(){  
9.	return name;  
10.	}  
11.	//setter method for name  
12.	public void setName(String name){  
13.	this.name=name  
14.	}  
15.	}  
File: Test.java
1.	//A Java class to test the encapsulated class.  
2.	package com.javatpoint;  
3.	class Test{  
4.	public static void main(String[] args){  
5.	//creating instance of the encapsulated class  
6.	Student s=new Student();  
7.	//setting value in the name member  
8.	s.setName("vijay");  
9.	//getting value of the name member  
10.	System.out.println(s.getName());  
11.	}  
12.	}
```
> Compile By: javac -d . Test.java
> Run By: java com.javatpoint.Test
> Output:
> vijay

Read-Only class
```java
1.	//A Java class which has only getter methods.  
2.	public class Student{  
3.	//private data member  
4.	private String college="AKG";  
5.	//getter method for college  
6.	public String getCollege(){  
7.	return college;  
8.	}  
9.	}
```
> Now, you can't change the value of the college data member which is "AKG".
> 1.	s.setCollege("KITE");//will render compile time error
> 2.	
Write-Only class
```java
1.	//A Java class which has only setter methods.  
2.	public class Student{  
3.	//private data member  
4.	private String college;  
5.	//getter method for college  
6.	public void setCollege(String college){  
7.	this.college=college;  
8.	}  
9.	}
```
> Now, you can't get the value of the college, you can only change the value of college data member.
> 1.	System.out.println(s.getCollege());//Compile Time Error, because there is no such method  
> 2.	System.out.println(s.college);//Compile Time Error, because the college data member is private.   
> 3.	//So, it can't be accessed from outside the class  

Another Example of Encapsulation in Java

Let's see another example of encapsulation that has only four fields with its setter and getter methods.
```java
File: Account.java
1.	//A Account class which is a fully encapsulated class.  
2.	//It has a private data member and getter and setter methods.  
3.	class Account {  
4.	//private data members  
5.	private long acc_no;  
6.	private String name,email;  
7.	private float amount;  
8.	//public getter and setter methods  
9.	public long getAcc_no() {  
10.	    return acc_no;  
11.	}  
12.	public void setAcc_no(long acc_no) {  
13.	    this.acc_no = acc_no;  
14.	}  
15.	public String getName() {  
16.	    return name;  
17.	}  
18.	public void setName(String name) {  
19.	    this.name = name;  
20.	}  
21.	public String getEmail() {  
22.	    return email;  
23.	}  
24.	public void setEmail(String email) {  
25.	    this.email = email;  
26.	}  
27.	public float getAmount() {  
28.	    return amount;  
29.	}  
30.	public void setAmount(float amount) {  
31.	    this.amount = amount;  
32.	}  
33.	  
34.	}
```
```java
File: TestAccount.java
1.	//A Java class to test the encapsulated class Account.  
2.	public class TestEncapsulation {  
3.	public static void main(String[] args) {  
4.	    //creating instance of Account class  
5.	    Account acc=new Account();  
6.	    //setting values through setter methods  
7.	    acc.setAcc_no(7560504000L);  
8.	    acc.setName("Sonoo Jaiswal");  
9.	    acc.setEmail("sonoojaiswal@javatpoint.com");  
10.	    acc.setAmount(500000f);  
11.	    //getting values through getter methods  
12.	    System.out.println(acc.getAcc_no()+" "+acc.getName()+" "+acc.getEmail()+" "+acc.getAmount());  
13.	}  
14.	}
```
> Test it Now
> Output:
> 7560504000 Sonoo Jaiswal sonoojaiswal@javatpoint.com 500000.0
</details>

<details><summary><b>[11.2 - Polymorphism in Java]</b></summary>

#### Polymorphism in Java
Polymorphism is another important concept. Polymorphism, a Greek terms means the ability to take more than one form. An operation may exhibits different behavior in different instance. The behavior depends upon the type of the objects used in the operation. Concept of polymorphism is often expressed by the phrase “one interface multiple methods”.
Polymorphism allows a reference to denote object of different types at different times during execution. A super type reference exhibits polymorphic behavior since it can denote object of its subtype.
Example of polymorphism is:
1.	Method overloading
2.	Method overriding
If one task is performed in different ways, it is known as polymorphism. For example: to convince the customer differently, to draw something, for example, shape, triangle, rectangle, etc.
In Java, we use method overloading and method overriding to achieve polymorphism.
Another example can be to speak something; for example, a cat speaks meow, dog barks woof, etc.
Polymorphism in Java is a concept by which we can perform a single action in different ways. Polymorphism is derived from 2 Greek words: poly and morphs. The word "poly" means many and "morphs" means forms. So polymorphism means many forms.
There are two types of polymorphism in Java: compile-time polymorphism and runtime polymorphism. We can perform polymorphism in java by method overloading and method overriding.
If you overload a static method in Java, it is the example of compile time polymorphism. Here, we will focus on runtime polymorphism in java.

<details><summary><b>[11.3 - Runtime Polymorphism in Java]</b></summary>

#### Runtime Polymorphism in Java
Runtime polymorphism or Dynamic Method Dispatch is a process in which a call to an overridden method is resolved at runtime rather than compile-time.
Method overriding forms the basis for one of Java’s most powerful concepts: dynamic method dispatch. Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than compile time.
Dynamic method dispatch is important because this is how Java implements run-time polymorphism.

A superclass reference variable can refer to a subclass object. Java uses this fact to resolve calls to overridden methods at run time. 

- Here is how. 

When an overridden method is called through a superclass reference, Java determines which version of that method to execute based upon the type of the object being referred to at the time the call occurs. Thus, this determination is made at run time. When different types of objects are referred to, different versions of an overridden method will be called.

In other words, it is the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed. Therefore, if a superclass contains a method that is overridden by a subclass, then when different types of objects are referred to through a superclass reference variable, different versions of the method are executed.

Here is an example that illustrates dynamic method dispatch:
```java
// Dynamic Method Dispatch
class A {
void callme() {
System.out.println("Inside A's callme method");
}
}
class B extends A {
// override callme()
void callme() {
System.out.println("Inside B's callme method");
}
}
class C extends A {
// override callme()
void callme() {
System.out.println("Inside C's callme method");
}
}
class Dispatch {
public static void main(String args[]) {
A a = new A(); // object of type A
B b = new B(); // object of type B
C c = new C(); // object of type C
A r; // obtain a reference of type A
r = a; // r refers to an A object
r.callme(); // calls A's version of callme
r = b; // r refers to a B object
r.callme(); // calls B's version of callme
r = c; // r refers to a C object
r.callme(); // calls C's version of callme
}
}
```
The output from the program is shown here:
> Inside A’s callme method
> Inside B’s callme method
> Inside C’s callme method

This program creates one superclass called A and two subclasses of it, called B and C.

Subclasses B and C override callme( ) declared in A. Inside the main( ) method, objects of type A, B, and C are declared. Also, a reference of type A, called r, is declared. The program then in turn assigns a reference to each type of object to r and uses that reference to invoke callme( ). As the output shows, the version of callme( ) executed is determined by the type of object being referred to at the time of the call. Had it been determined by the type of the reference variable, r, you would see three calls to A’s callme( ) method. 

</details>

<details><summary><b>[12 - Why Overridden Methods]</b></summary>
	
#### Why Overridden Methods?

The superclass provides all elements that a subclass can use directly. It also defines those methods that the derived class must implement on its own. This allows the subclass the flexibility to define its own methods, yet still enforces a consistent interface.

Thus, by combining inheritance with overridden methods, a superclass can define the general form of the methods that will be used by all of its subclasses.

In this process, an overridden method is called through the reference variable of a superclass. The determination of the method to be called is based on the object being referred to by the reference variable.
Let's first understand the upcasting before Runtime Polymorphism.

### Upcasting

If the reference variable of Parent class refers to the object of Child class, it is known as upcasting. For example:
```java
1.	class A{}  
2.	class B extends A{}  
1.	A a=new B();//upcasting  
For upcasting, we can use the reference variable of class type or an interface type. For Example:
1.	interface I{}  
2.	class A{}  
3.	class B extends A implements I{}
```
> Here, the relationship of B class would be:
> B IS-A A
> B IS-A I
> B IS-A Object
> Since Object is the root class of all classes in Java, so we can write B IS-A Object.

</details>

<details><summary><b>[13 - Example of Java Runtime Polymorphism]</b></summary>

#### Example of Java Runtime Polymorphism

In this example, we are creating two classes Bike and Splendor. Splendor class extends Bike class and overrides its run() method. We are calling the run method by the reference variable of Parent class. Since it refers to the subclass object and subclass method overrides the Parent class method, the subclass method is invoked at runtime.

Since method invocation is determined by the JVM not compiler, it is known as runtime polymorphism.

```java
1.	class Bike{  
2.	  void run(){System.out.println("running");}  
3.	}  
4.	class Splendor extends Bike{  
5.	  void run(){System.out.println("running safely with 60km");}  
6.	  
7.	  public static void main(String args[]){  
8.	    Bike b = new Splendor();//upcasting  
9.	    b.run();  
10.	  }  
11.	}
```
> Test it Now
> Output:
> running safely with 60km.
> Java Runtime Polymorphism Example: Bank
> Consider a scenario where Bank is a class that provides a method to get the rate of interest. However, the rate of interest may differ according to banks. For example, SBI, ICICI, and AXIS banks are providing 8.4%, 7.3%, and 9.7% rate of interest.
 
Note: This example is also given in method overriding but there was no upcasting.

```java
1.	class Bank{  
2.	float getRateOfInterest(){return 0;}  
3.	}  
4.	class SBI extends Bank{  
5.	float getRateOfInterest(){return 8.4f;}  
6.	}  
7.	class ICICI extends Bank{  
8.	float getRateOfInterest(){return 7.3f;}  
9.	}  
10.	class AXIS extends Bank{  
11.	float getRateOfInterest(){return 9.7f;}  
12.	}  
13.	class TestPolymorphism{  
14.	public static void main(String args[]){  
15.	Bank b;  
16.	b=new SBI();  
17.	System.out.println("SBI Rate of Interest: "+b.getRateOfInterest());  
18.	b=new ICICI();  
19.	System.out.println("ICICI Rate of Interest: "+b.getRateOfInterest());  
20.	b=new AXIS();  
21.	System.out.println("AXIS Rate of Interest: "+b.getRateOfInterest());  
22.	}  
23.	}
```
> Test it Now
> Output:
> SBI Rate of Interest: 8.4
> ICICI Rate of Interest: 7.3
> AXIS Rate of Interest: 9.7

Java Runtime Polymorphism Example: Shape
```java
1.	class Shape{  
2.	void draw(){System.out.println("drawing...");}  
3.	}  
4.	class Rectangle extends Shape{  
5.	void draw(){System.out.println("drawing rectangle...");}  
6.	}  
7.	class Circle extends Shape{  
8.	void draw(){System.out.println("drawing circle...");}  
9.	}  
10.	class Triangle extends Shape{  
11.	void draw(){System.out.println("drawing triangle...");}  
12.	}  
13.	class TestPolymorphism2{  
14.	public static void main(String args[]){  
15.	Shape s;  
16.	s=new Rectangle();  
17.	s.draw();  
18.	s=new Circle();  
19.	s.draw();  
20.	s=new Triangle();  
21.	s.draw();  
22.	}  
23.	}
```
> Test it Now
> Output:
> drawing rectangle...
> drawing circle...
> drawing triangle...
Java Runtime Polymorphism Example: Animal
```java
1.	class Animal{  
2.	void eat(){System.out.println("eating...");}  
3.	}  
4.	class Dog extends Animal{  
5.	void eat(){System.out.println("eating bread...");}  
6.	}  
7.	class Cat extends Animal{  
8.	void eat(){System.out.println("eating rat...");}  
9.	}  
10.	class Lion extends Animal{  
11.	void eat(){System.out.println("eating meat...");}  
12.	}  
13.	class TestPolymorphism3{  
14.	public static void main(String[] args){  
15.	Animal a;  
16.	a=new Dog();  
17.	a.eat();  
18.	a=new Cat();  
19.	a.eat();  
20.	a=new Lion();  
21.	a.eat();  
22.	}
}
```
> Test it Now
> Output:
> eating bread...
> eating rat...
> eating meat...

<details><summary><b>[13.1 - Java Runtime Polymorphism with Data Member]</b></summary>
	
#### Java Runtime Polymorphism with Data Member
A method is overridden, not the data members, so runtime polymorphism can't be achieved by data members.
In the example given below, both the classes have a data member speedlimit. We are accessing the data member by the reference variable of Parent class which refers to the subclass object. Since we are accessing the data member which is not overridden, hence it will access the data member of the Parent class always.

Rule: Runtime polymorphism can't be achieved by data members.
```java
1.	class Bike{  
2.	 int speedlimit=90;  
3.	}  
4.	class Honda3 extends Bike{  
5.	 int speedlimit=150;  
6.	  
7.	 public static void main(String args[]){  
8.	  Bike obj=new Honda3();  
9.	  System.out.println(obj.speedlimit);//90  
10.	}
```
> Test it Now
> Output:
> 90
</details>

<details><summary><b>[13.2 - Java Runtime Polymorphism with Multilevel Inheritance]</b></summary>
	
#### Java Runtime Polymorphism with Multilevel Inheritance
Let's see the simple example of Runtime Polymorphism with multilevel inheritance.
```java
1.	class Animal{  
2.	void eat(){System.out.println("eating");}  
3.	}  
4.	class Dog extends Animal{  
5.	void eat(){System.out.println("eating fruits");}  
6.	}  
7.	class BabyDog extends Dog{  
8.	void eat(){System.out.println("drinking milk");}  
9.	public static void main(String args[]){  
10.	Animal a1,a2,a3;  
11.	a1=new Animal();  
12.	a2=new Dog();  
13.	a3=new BabyDog();  
14.	a1.eat();  
15.	a2.eat();  
16.	a3.eat();  
17.	}  
18.	}
```
> Test it Now
> Output:
> eating
> eating fruits
> drinking Milk
________________________________________
Try for Output
```java
1.	class Animal{  
2.	void eat(){System.out.println("animal is eating...");}  
3.	}  
4.	class Dog extends Animal{  
5.	void eat(){System.out.println("dog is eating...");}  
6.	}  
7.	class BabyDog1 extends Dog{  
8.	public static void main(String args[]){  
9.	Animal a=new BabyDog1();  
10.	a.eat();  
11.	}
}
```
> Test it Now
> Output:
> Dog is eating
Since, BabyDog is not overriding the eat() method, so eat() method of Dog class is invoked.
</details>

</details>

</details>

</details>

<details><summary><b>[14 - Inheritance in java]</b></summary>

#### Inheritance in java
Inheritance is the process by which one object acquires the properties of another objects. This is important because it supports the concept of hierarchical classification.

In OOP’s the concept of inheritance provides the idea of reusability. This means that we can add additional features to an existing class without modifying it. This is possible by deriving a new class from an existing one.
The new class will have the combined features of both the class.

In terminology of java, a class that is inherited is called a superclass. The class does the inheriting is called subclass.
Therefore, a subclass is specialized version of a superclass. It traits all of the instance variable and methods defined by the superclass and adds its own unique elements.

Java does not support multiple inheritance. In java, to inherit a class, you simply incorporate the definition of one class into another by using the extends keyword.

When one object acquires all the properties and behaviors of a parent object, it is known as inheritance. It provides code reusability. It is used to achieve runtime polymorphism.
 
Inheritance is one of the corner stones of object-oriented programming because it allows the creation of hierarchical classifications. Using inheritance, you can create a general class that defines traits common to a set of related items. This class can then be inherited by other, more specific classes, each adding those things that are unique to it. In the terminology of Java, a class that is inherited is called a superclass. The class that does the inheriting is called a subclass. Therefore, a subclass is a specialized version of a superclass. It inherits all of the instance variables and methods defined by the superclass and adds its own, unique elements.

Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object. It is an important part of OOPs (Object Oriented programming system).

The idea behind inheritance in Java is that you can create new classes that are built upon existing classes. When you inherit from an existing class, you can reuse methods and fields of the parent class. Moreover, you can add new methods and fields in your current class also.

Inheritance represents the IS-A relationship which is also known as a parent-child relationship.

<details><summary><b>[14.1 - Why use inheritance in java]</b></summary>

#### Why use inheritance in java
o	For Method Overriding (so runtime polymorphism can be achieved).
o	For Code Reusability.
Terms used in Inheritance
o	Class: A class is a group of objects which have common properties. It is a template or blueprint from which objects are created.
o	Sub Class/Child Class: Subclass is a class which inherits the other class. It is also called a derived class, extended class, or child class.
o	Super Class/Parent Class: Superclass is the class from where a subclass inherits the features. It is also called a base class or a parent class.
o	Reusability: As the name specifies, reusability is a mechanism which facilitates you to reuse the fields and methods of the existing class when you create a new class. You can use the same fields and methods already defined in the previous class.
The syntax of Java Inheritance
```java
1.	class Subclass-name extends Superclass-name  
2.	{  
3.	   //methods and fields  
4.	}
```
The extends keyword indicates that you are making a new class that derives from an existing class. The meaning of "extends" is to increase the functionality.

In the terminology of Java, a class which is inherited is called a parent or superclass, and the new class is called child or subclass.
________________________________________
- Java Inheritance Example
 
As displayed in the above figure, Programmer is the subclass and Employee is the superclass. The relationship between the two classes is Programmer IS-A Employee. It means that Programmer is a type of Employee.
```java
1.	class Employee{  
2.	 float salary=40000;  
3.	}  
4.	class Programmer extends Employee{  
5.	 int bonus=10000;  
6.	 public static void main(String args[]){  
7.	   Programmer p=new Programmer();  
8.	   System.out.println("Programmer salary is:"+p.salary);  
9.	   System.out.println("Bonus of Programmer is:"+p.bonus);  
10.	}  
11.	}
```  
> Test it Now
> Programmer salary is:40000.0
> Bonus of programmer is:10000
In the above example, Programmer object can access the field of own class as well as of Employee class i.e. code reusability.
</details>
<details><summary><b>[14.2 - Types of inheritance in java]</b></summary>

#### Types of inheritance in java
On the basis of class, there can be three types of inheritance in java: single, multilevel and hierarchical.
In java programming, multiple and hybrid inheritance is supported through interface only. We will learn about interfaces later.
 
Note: Multiple inheritance is not supported in Java through class.
When one class inherits multiple classes, it is known as multiple inheritance. For Example:
 
________________________________________
- Single Inheritance Example
When a class inherits another class, it is known as a single inheritance. In the example given below, Dog class inherits the Animal class, so there is the single inheritance.
```java
File: TestInheritance.java
1.	class Animal{  
2.	void eat(){System.out.println("eating...");}  
3.	}  
4.	class Dog extends Animal{  
5.	void bark(){System.out.println("barking...");}  
6.	}  
7.	class TestInheritance{  
8.	public static void main(String args[]){  
9.	Dog d=new Dog();  
10.	d.bark();  
11.	d.eat();  
12.	}
}
```
> Output:
> barking...
> eating...
- Multilevel Inheritance Example
When there is a chain of inheritance, it is known as multilevel inheritance. As you can see in the example given below, BabyDog class inherits the Dog class which again inherits the Animal class, so there is a multilevel inheritance.
```java
File: TestInheritance2.java
1.	class Animal{  
2.	void eat(){System.out.println("eating...");}  
3.	}  
4.	class Dog extends Animal{  
5.	void bark(){System.out.println("barking...");}  
6.	}  
7.	class BabyDog extends Dog{  
8.	void weep(){System.out.println("weeping...");}  
9.	}  
10.	class TestInheritance2{  
11.	public static void main(String args[]){  
12.	BabyDog d=new BabyDog();  
13.	d.weep();  
14.	d.bark();  
15.	d.eat();  
16.	}
}
```
> Output:
> weeping...
> barking...
> eating...
- Hierarchical Inheritance Example
When two or more classes inherits a single class, it is known as hierarchical inheritance. In the example given below, Dog and Cat classes inherits the Animal class, so there is hierarchical inheritance.
```java
File: TestInheritance3.java
1.	class Animal{  
2.	void eat(){System.out.println("eating...");}  
3.	}  
4.	class Dog extends Animal{  
5.	void bark(){System.out.println("barking...");}  
6.	}  
7.	class Cat extends Animal{  
8.	void meow(){System.out.println("meowing...");}  
9.	}  
10.	class TestInheritance3{  
11.	public static void main(String args[]){  
12.	Cat c=new Cat();  
13.	c.meow();  
14.	c.eat();  
15.	//c.bark();//C.T.Error  
16.	}
}
```
> Output:
> meowing...
> eating...
</details>

<details><summary><b>[14.3 - Why multiple inheritance is not supported in java?]</b></summary>

#### Q) Why multiple inheritance is not supported in java?
To reduce the complexity and simplify the language, multiple inheritance is not supported in java.
Consider a scenario where A, B, and C are three classes. The C class inherits A and B classes. If A and B classes have the same method and you call it from child class object, there will be ambiguity to call the method of A or B class.
Since compile-time errors are better than runtime errors, Java renders compile-time error if you inherit 2 classes. So whether you have same method or different, there will be compile time error.
```java
1.	class A{  
2.	void msg(){System.out.println("Hello");}  
3.	}  
4.	class B{  
5.	void msg(){System.out.println("Welcome");}  
6.	}  
7.	class C extends A,B{//suppose if it were  
8.	   
9.	 public static void main(String args[]){  
10.	   C obj=new C();  
11.	   obj.msg();//Now which msg() method would be invoked?  
12.	}  
13.	}
```
> Test it Now
> Compile Time Error
</details>
</details>
<details><summary><b>[15 - Abstraction in Java]</b></summary>

#### Abstraction in Java
Abstraction refers to the act of representing essential features without including the background details or explanation. An essential feature of object oriented programing is abstraction.

A powerful way to manage abstraction is through the use of hierarchical classification. This allows you to layer the semantic of complex system breaking them into more manageable piece. The data from a traditional process oriented program can be transformed by abstraction into its component objects.

A sequence of process steps can become a collection of messages between these objects thus each of these objects describes own unique behavior. You can treat these objects as concrete entities that responds to messages telling them to do something. This is the essence of object oriented programing.

For example, once you have well defined objects and clean reliable interfaces to those object you can gracefully decommission or replace part of an older system without fear.

In other words, an abstraction denotes the essential properties and behaviors of an object that differentiate it from other objects.
A class denotes a category of objects and act as a blueprint for creating such objects. A class models an abstraction defining the properties and behaviors for the objects representing the abstraction. An object exhibits the property of an object of a class are also called attributes and are defined by field in java. A field in a class definition is a variable which can store a value that represents a particular property. The behaviors of an object of a class also known as operation, and are defined using methods in java. Fields and method in a class definition are collectively called members.

An important distribution is made between the contract and the implementation that class provides for its object. The contract defines what services and the implementation defines how these services are provided by the class. Clients (i.e. other objects) only need to know the contract of an object and not its implementation in order to avail themselves of the objects services. 
Abstraction is a process of hiding the implementation details and showing only functionality to the user.

Another way, it shows only essential things to the user and hides the internal details, for example, sending SMS where you type the text and send the message. You don't know the internal processing about the message delivery.

Hiding internal details and showing functionality is known as abstraction. For example phone call, we don't know the internal processing.

In Java, we use abstract class and interface to achieve abstraction.

Abstraction lets you focus on what the object does instead of how it does it.

<details><summary><b>[15.1 - Ways to achieve Abstraction]</b></summary>
	
#### Ways to achieve Abstraction
There are two ways to achieve abstraction in java
1.	Abstract class (0 to 100%)
2.	Interface (100%)
</details>
</details>
<details><summary><b>[16 - Aggregation in Java]</b></summary>

#### Aggregation in Java
Aggregation is a way to achieve Association. Aggregation represents the relationship where one object contains other objects as a part of its state. It represents the weak relationship between objects. It is also termed as a has-a relationship in Java. Like, inheritance represents the is-a relationship. It is another way to reuse objects.
If a class have an entity reference, it is known as Aggregation. Aggregation represents HAS-A relationship.
Consider a situation, Employee object contains many informations such as id, name, emailId etc. It contains one more object named address, which contains its own informations such as city, state, country, zipcode etc. as given below.
```java
1.	class Employee{  
2.	int id;  
3.	String name;  
4.	Address address;//Address is a class  
5.	...  
6.	}
```
In such case, Employee has an entity reference address, so relationship is Employee HAS-A address.

<details><summary><b>[16.1 - Why use Aggregation?]</b></summary>

#### Why use Aggregation?
o	For Code Reusability.
________________________________________
Simple Example of Aggregation
 
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
> Test it Now
> Output:78.5
</details>
<details><summary><b>[16.2 - When use Aggregation?]</b></summary>

#### When use Aggregation?
o	Code reuse is also best achieved by aggregation when there is no is-a relationship.
o	Inheritance should be used only if the relationship is-a is maintained throughout the lifetime of the objects involved; otherwise, aggregation is the best choice.
________________________________________
Understanding meaningful example of Aggregation

In this example, Employee has an object of Address, address object contains its own informations such as city, state, country etc. In such case relationship is Employee HAS-A address.
```java
Address.java
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
Emp.java
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
> Test it Now
> Output:111 varun
>        gzb UP india
>        112 arun
>        gno UP india  
</details>
</details>
<details><summary><b>[17 - Coupling]</b></summary>

#### Coupling
Coupling refers to the knowledge or information or dependency of another class. It arises when classes are aware of each other. If a class has the details information of another class, there is strong coupling. In Java, we use private, protected, and public modifiers to display the visibility level of a class, method, and field. You can use interfaces for the weaker coupling because there is no concrete implementation.
</details>
<details><summary><b>[18 - Cohesion]</b></summary>

#### Cohesion
Cohesion refers to the level of a component which performs a single well-defined task. A single well-defined task is done by a highly cohesive method. The weakly cohesive method will split the task into separate parts. The java.io package is a highly cohesive package because it has I/O related classes and interface. However, the java.util package is a weakly cohesive package because it has unrelated classes and interfaces.
</details>
<details><summary><b>[19 - Association]</b></summary>

#### Association
Association represents the relationship between the objects. Here, one object can be associated with one object or many objects. There can be four types of association between the objects:
o	One to One
o	One to Many
o	Many to One, and
o	Many to Many
Let's understand the relationship with real-time examples. For example, One country can have one prime minister (one to one), and a prime minister can have many ministers (one to many). Also, many MP's can have one prime minister (many to one), and many ministers can have many departments (many to many).
Association can be undirectional or bidirectional.
</details>
<details><summary><b>[20 - Composition]</b></summary>

#### Composition
The composition is also a way to achieve Association. The composition represents the relationship where one object contains other objects as a part of its state. There is a strong relationship between the containing object and the dependent object. It is the state where containing objects do not have an independent existence. If you delete the parent object, all the child objects will be deleted automatically.
</details>

<details><summary><b>[21 - Access Modifiers in Java]</b></summary>

#### Access Modifiers in Java
Access Control
Encapsulation links data with the code that manipulates it. However, encapsulation provides another important attribute: access control. Through encapsulation, you can control what parts of a program can access the members of a class. By controlling access, you can prevent misuse. For example, allowing access to data only through a well-defined set of methods, you can prevent the misuse of that data.

How a member can be accessed is determined by the access specifier that modifies its declaration. Java supplies a rich set of access specifiers. Some aspects of access control are related mostly to inheritance or packages. (A package is, essentially, a grouping of classes.)

Java’s access specifiers are public, private, and protected. Java also defines a default access level. 
There are two types of modifiers in Java: access modifiers and non-access modifiers.

The access modifiers in Java specifies the accessibility or scope of a field, method, constructor, or class. We can change the access level of fields, constructors, methods, and class by applying the access modifier on it.

There are four types of Java access modifiers:

1.	Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
When a member of a class is specified as private, then that member can only be accessed by other members of its class.
2.	Default: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
3.	Protected: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package. 
Protected applies only when inheritance is involved.
4.	Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.
When a member of a class is modified by the public specifier, then that member can be accessed by any other code. 
There are many non-access modifiers, such as static, abstract, synchronized, native, volatile, transient, etc. 
________________________________________
Understanding Java Access Modifiers

Let’s understand the access modifiers in Java by a simple table.
|Access Modifier|within class|within package|outside package by subclass only|outside package|
|---------------|-------|-------|-------|-------|
|Private	|Y	|N	|N	|N	|
|Default	|Y	|Y	|N	|N	|
|Protected	|Y	|Y	|Y	|N	|
|Public		|Y	|Y	|Y	|Y	|
________________________________________
1) Private
The private access modifier is accessible only within the class.
Simple example of private access modifier
In this example, we have created two classes A and Simple. A class contains private data member and private method. We are accessing these private members from outside the class, so there is a compile-time error.
```java
1.	class A{  
2.	private int data=40;  
3.	private void msg(){System.out.println("Hello java");}  
4.	}  
5.	  
6.	public class Simple{  
7.	 public static void main(String args[]){  
8.	   A obj=new A();  
9.	   System.out.println(obj.data);//Compile Time Error  
10.	   obj.msg();//Compile Time Error  
11.	   }  
12.	}
```
Role of Private Constructor
If you make any class constructor private, you cannot create the instance of that class from outside the class. For example:
```java
1.	class A{  
2.	private A(){}//private constructor  
3.	void msg(){System.out.println("Hello java");}  
4.	}  
5.	public class Simple{  
6.	 public static void main(String args[]){  
7.	   A obj=new A();//Compile Time Error  
8.	 }  
9.	}
```
> Note: A class cannot be private or protected except nested class.
________________________________________
2) Default
If you don't use any modifier, it is treated as default by default. The default modifier is accessible only within package. It cannot be accessed from outside the package. It provides more accessibility than private. But, it is more restrictive than protected, and public.

Example of default access modifier

In this example, we have created two packages pack and mypack. We are accessing the A class from outside its package, since A class is not public, so it cannot be accessed from outside the package.
```java
1.	//save by A.java  
2.	package pack;  
3.	class A{  
4.	  void msg(){System.out.println("Hello");}  
5.	}  
1.	//save by B.java  
2.	package mypack;  
3.	import pack.*;  
4.	class B{  
5.	  public static void main(String args[]){  
6.	   A obj = new A();//Compile Time Error  
7.	   obj.msg();//Compile Time Error  
8.	  }  
9.	}
``` 
In the above example, the scope of class A and its method msg() is default so it cannot be accessed from outside the package.
________________________________________
3) Protected
The protected access modifier is accessible within package and outside the package but through inheritance only.
The protected access modifier can be applied on the data member, method and constructor. It can't be applied on the class.
It provides more accessibility than the default modifer.
Example of protected access modifier
In this example, we have created the two packages pack and mypack. The A class of pack package is public, so can be accessed from outside the package. But msg method of this package is declared as protected, so it can be accessed from outside the class only through inheritance.
```java
1.	//save by A.java  
2.	package pack;  
3.	public class A{  
4.	protected void msg(){System.out.println("Hello");}  
5.	}  
1.	//save by B.java  
2.	package mypack;  
3.	import pack.*;  
4.	  
5.	class B extends A{  
6.	  public static void main(String args[]){  
7.	   B obj = new B();  
8.	   obj.msg();  
9.	  }  
10.	}
```
> Output:Hello
________________________________________
4) Public
The public access modifier is accessible everywhere. It has the widest scope among all other modifiers.
Example of public access modifier
```java
1.	//save by A.java  
2.	  
3.	package pack;  
4.	public class A{  
5.	public void msg(){System.out.println("Hello");}  
6.	}  
1.	//save by B.java  
2.	  
3.	package mypack;  
4.	import pack.*;  
5.	  
6.	class B{  
7.	  public static void main(String args[]){  
8.	   A obj = new A();  
9.	   obj.msg();  
10.	  }  
11.	}
```
> Output:Hello
________________________________________
Java Access Modifiers with Method Overriding
If you are overriding any method, overridden method (i.e. declared in subclass) must not be more restrictive.
```java
1.	class A{  
2.	protected void msg(){System.out.println("Hello java");}  
3.	}  
4.	  
5.	public class Simple extends A{  
6.	void msg(){System.out.println("Hello java");}//C.T.Error  
7.	 public static void main(String args[]){  
8.	   Simple obj=new Simple();  
9.	   obj.msg();  
10.	   }  
11.	}
```
The default modifier is more restrictive than protected. That is why, there is a compile-time error.


<details><summary><b>[21.1 - Access Control]</b></summary>
</details>
</details>
<details><summary><b>[22 - Methods in Java]</b></summary>

#### Methods in Java
A function (i.e. Method) is self-contained block of statements that performs a coherent task of some kind.

Function (i.e. Method) is a subprogram sometimes which returns a value. If the method does not return a value, its return type must be void. The name of the method is specified by name. This can be any legal identifier other than those already used by other items within the current scope. 

The parameter-list is a sequence of type and identifier pairs separated by commas. Parameters are essentially variables that receive the value of the arguments passed to the method when it is called. If the method has no parameters, then the parameter list will be empty.

- Returning a Value
There are two important things to understand about returning values:

• The type of data returned by a method must be compatible with the return type specified by the method. 

For example, if the return type of some method is boolean, you could not return an integer.

public int method() {
int a=10;
return a;
}

• The variable receiving the value returned by a method must also be compatible with the return type specified for the method.

Int aRef= method();
public int method() {
int a=10;
return a;
}

#### Difference between parameters and argument:

A parameter is a variable defined by a method that receives a value when the method is called. For example in a square (i), i is a parameter.

An argument is a value that is passed to method when the method is invoked. For example in a square (100), 100 is an argument.

In Java, a method is like a function which is used to expose the behavior of an object.
Advantage of Method
o	Code Reusability
o	Code Optimization

</details>
<details><summary><b>[23 - Using Command-Line Arguments]</b></summary>

#### Using Command-Line Arguments
Sometimes you will want to pass information into a program when you run it. This is accomplished by passing command-line arguments to main( ). A command-line argument is the information that directly follows the program’s name on the command line when it is executed. To access the command-line arguments inside a Java program is quite easy—We can store as strings in a String array passed to the args parameter of main( ). The first command-line argument is stored at args[0], the second at args[1], and so on. For example, the following program displays all of the command-line arguments that it is called with:

// Display all command-line arguments.
class CommandLine {
public static void main(String args[]) {
for(int i=0; i<args.length; i++)
System.out.println("args[" + i + "]: " +
args[i]);
}
}

Try executing this program, as shown here:
java CommandLine this is a test 100 -1
When you do, you will see the following output:
args[0]: this
args[1]: is
args[2]: a
args[3]: test
args[4]: 100
args[5]: -1

REMEMBER All command-line arguments are passed as strings. You must convert numeric values to their internal forms manually,
</details>
<details><summary><b>[24 - Instance Variable Hiding]</b></summary>

#### Instance Variable Hiding
It is illegal in Java to declare two local variables with the same name inside the same or enclosing scopes. Interestingly, you can have local variables, including formal parameters to methods, which overlap with the names of the class’ instance variables. However, when a local variable has the same name as an instance variable, the local variable hides the instance variable.

This lets you refer directly to the object, you can use it to resolve any name space collisions that might occur between instance variables and local variables. For example, here is another version of Box( ), which uses width, height, and depth for parameter names and then uses this to access the instance variables by the same name:

// Use this to resolve name-space collisions.
Box(double width, double height, double depth) {
this.width = width;
this.height = height;
this.depth = depth;
}
</details>
<details><summary><b>[25 - The Scope and Lifetime of Variables]</b></summary>

#### The Scope and Lifetime of Variables
Java allows variables to be declared within any block. A block is begun with an opening curly brace and ended by a closing curly brace. A block defines a scope. Thus, each time you start a new block, you are creating a new scope. A scope determines what objects are visible to other parts of your program. It also determines the lifetime of those objects.

Many other computer languages define two general categories of scopes: global and local. However, these traditional scopes do not fit well with Java’s strict, object-oriented model. While it is possible to create what amounts to being a global scope, it is by far the exception not the rule. In Java, the two major scopes are those defined by a class and those defined by a method.

However, since the class scope has several unique properties and attributes that do not apply to the scope defined by a method, this distinction makes some sense. Because of the differences, a discussion of class scope (and variables declared within it) is deferred. For now, we will only examine the scopes defined by or within a method.

The scope defined by a method begins with its opening curly brace. However, if that method has parameters, they too are included within the method’s scope. 

As a general rule, variables declared inside a scope are not visible (that is, accessible) to code that is defined outside that scope. Thus, when you declare a variable within a scope, you are localizing that variable and protecting it from unauthorized access and/or modification. Indeed, the scope rules provide the foundation for encapsulation.

Scopes can be nested. For example, each time you create a block of code, you are creating a new, nested scope. When this occurs, the outer scope encloses the inner scope. This means that objects declared in the outer scope will be visible to code within the inner scope. However, the reverse is not true. Objects declared within the inner scope will not be visible outside it.
</details>
<details><summary><b>[054 - Constructors in Java]</b></summary>

#### Constructors in Java
Java allows objects to initialize themselves when they are created. This automatic initialization is performed through the use of a constructor.

A constructor initializes an object immediately upon creation. It has the same name as the class in which it resides and is syntactically similar to a method. Once defined, the constructor is automatically called immediately after the object is created, before the new operator completes.

Constructors look a little strange because they have no return type, not even void. This is because the implicit return type of a class’ constructor is the class type itself. It is the constructor’s job to initialize the internal state of an object so that the code creating an instance will have a fully initialized, usable object immediately.

- Following types of constructors:
•	Parameterized Constructor
•	Default Constructor
In Java, a constructor is a block of codes similar to the method. It is called when an instance of the class is created. At the time of calling constructor, memory for the object is allocated in the memory.
It is a special type of method which is used to initialize the object.
Every time an object is created using the new() keyword, at least one constructor is called.
It calls a default constructor if there is no constructor available in the class. In such case, Java compiler provides a default constructor by default.
There are two types of constructors in Java: no-arg constructor, and parameterized constructor.
Note: It is called constructor because it constructs the values at the time of object creation. It is not necessary to write a constructor for a class. It is because java compiler creates a default constructor if your class doesn't have any.
- Rules for creating Java constructor
There are two rules defined for the constructor.
1.	Constructor name must be the same as its class name
2.	A Constructor must have no explicit return type
3.	A Java constructor cannot be abstract, static, final, and synchronized
Note: We can use access modifiers while declaring a constructor. It controls the object creation. In other words, we can have private, protected, public or default constructor in Java.
Types of Java constructors
There are two types of constructors in Java:
1.	Default constructor (no-arg constructor)
2.	Parameterized constructor
 
________________________________________
- Java Default Constructor
A constructor is called "Default Constructor" when it doesn't have any parameter.
Syntax of default constructor:
1.	<class_name>(){}  
Example of default constructor
In this example, we are creating the no-arg constructor in the Bike class. 
It will be invoked at the time of object creation.
1.	//Java Program to create and call a default constructor  
2.	class Bike1{  
3.	//creating a default constructor  
4.	Bike1(){System.out.println("Bike is created");}  
5.	//main method  
6.	public static void main(String args[]){  
7.	//calling a default constructor  
8.	Bike1 b=new Bike1();  
9.	}  
10.	}  
Test it Now
Output:
Bike is created
Rule: If there is no constructor in a class, compiler automatically creates a default constructor.
<details><summary><b>[25.1 - What is the purpose of a default constructor?]</b></summary>

#### Q) What is the purpose of a default constructor?
The default constructor is used to provide the default values to the object like 0, null, etc., depending on the type.
Example of default constructor that displays the default values
1.	//Let us see another example of default constructor  
2.	//which displays the default values  
3.	class Student3{  
4.	int id;  
5.	String name;  
6.	//method to display the value of id and name  
7.	void display(){System.out.println(id+" "+name);}  
8.	  
9.	public static void main(String args[]){  
10.	//creating objects  
11.	Student3 s1=new Student3();  
12.	Student3 s2=new Student3();  
13.	//displaying values of the object  
14.	s1.display();  
15.	s2.display();  
16.	}  
17.	}  
Test it Now
Output:
0 null
0 null
Explanation:In the above class,you are not creating any constructor so compiler provides you a default constructor. Here 0 and null values are provided by default constructor.
________________________________________
- Java Parameterized Constructor
A constructor which has a specific number of parameters is called a parameterized constructor.
Why use the parameterized constructor?
The parameterized constructor is used to provide different values to distinct objects. However, you can provide the same values also.
Example of parameterized constructor
In this example, we have created the constructor of Student class that have two parameters. We can have any number of parameters in the constructor.
1.	//Java Program to demonstrate the use of the parameterized constructor.  
2.	class Student4{  
3.	    int id;  
4.	    String name;  
5.	    //creating a parameterized constructor  
6.	    Student4(int i,String n){  
7.	    id = i;  
8.	    name = n;  
9.	    }  
10.	    //method to display the values  
11.	    void display(){System.out.println(id+" "+name);}  
12.	   
13.	    public static void main(String args[]){  
14.	    //creating objects and passing values  
15.	    Student4 s1 = new Student4(111,"Karan");  
16.	    Student4 s2 = new Student4(222,"Aryan");  
17.	    //calling method to display the values of object  
18.	    s1.display();  
19.	    s2.display();  
20.	   }  
21.	}  
Test it Now
Output:
111 Karan
222 Aryan
________________________________________
</details>
<details><summary><b>[26 - Why use the parameterized constructor?]</b></summary>

#### Constructor Overloading in Java
In Java, a constructor is just like a method but without return type. It can also be overloaded like Java methods.
Constructor overloading in Java is a technique of having more than one constructor with different parameter lists. They are arranged in a way that each constructor performs a different task. They are differentiated by the compiler by the number of parameters in the list and their types.
Example of Constructor Overloading
1.	//Java program to overload constructors  
2.	class Student5{  
3.	    int id;  
4.	    String name;  
5.	    int age;  
6.	    //creating two arg constructor  
7.	    Student5(int i,String n){  
8.	    id = i;  
9.	    name = n;  
10.	    }  
11.	    //creating three arg constructor  
12.	    Student5(int i,String n,int a){  
13.	    id = i;  
14.	    name = n;  
15.	    age=a;  
16.	    }  
17.	    void display(){System.out.println(id+" "+name+" "+age);}  
18.	   
19.	    public static void main(String args[]){  
20.	    Student5 s1 = new Student5(111,"Karan");  
21.	    Student5 s2 = new Student5(222,"Aryan",25);  
22.	    s1.display();  
23.	    s2.display();  
24.	   }  
25.	}  
Test it Now
Output:
111 Karan 0
222 Aryan 25
________________________________________

</details>
<details><summary><b>[27 - Difference between constructor and method in Java]</b></summary>

#### Difference between constructor and method in Java
There are many differences between constructors and methods. They are given below.
Java Constructor	Java Method
A constructor is used to initialize the state of an object.	A method is used to expose the behavior of an object.
A constructor must not have a return type.	A method must have a return type.
The constructor is invoked implicitly.	The method is invoked explicitly.
The Java compiler provides a default constructor if you don't have any constructor in a class.	The method is not provided by the compiler in any case.
The constructor name must be same as the class name.	The method name may or may not be same as the class name.
 
#### Java Copy Constructor
There is no copy constructor in Java. However, we can copy the values from one object to another like copy constructor in C++.
There are many ways to copy the values of one object into another in Java. They are:
o	By constructor
o	By assigning the values of one object into another
o	By clone() method of Object class
In this example, we are going to copy the values of one object into another using Java constructor.
```java
1.	//Java program to initialize the values from one object to another object.  
2.	class Student6{  
3.	    int id;  
4.	    String name;  
5.	    //constructor to initialize integer and string  
6.	    Student6(int i,String n){  
7.	    id = i;  
8.	    name = n;  
9.	    }  
10.	    //constructor to initialize another object  
11.	    Student6(Student6 s){  
12.	    id = s.id;  
13.	    name =s.name;  
14.	    }  
15.	    void display(){System.out.println(id+" "+name);}  
16.	   
17.	    public static void main(String args[]){  
18.	    Student6 s1 = new Student6(111,"Karan");  
19.	    Student6 s2 = new Student6(s1);  
20.	    s1.display();  
21.	    s2.display();  
22.	   }  
23.	}
```
Test it Now
Output:
111 Karan
111 Karan
________________________________________
- Copying values without constructor
We can copy the values of one object into another by assigning the objects values to another object. In this case, there is no need to create the constructor.
```java
1.	class Student7{  
2.	    int id;  
3.	    String name;  
4.	    Student7(int i,String n){  
5.	    id = i;  
6.	    name = n;  
7.	    }  
8.	    Student7(){}  
9.	    void display(){System.out.println(id+" "+name);}  
10.	   
11.	    public static void main(String args[]){  
12.	    Student7 s1 = new Student7(111,"Karan");  
13.	    Student7 s2 = new Student7();  
14.	    s2.id=s1.id;  
15.	    s2.name=s1.name;  
16.	    s1.display();  
17.	    s2.display();  
18.	   }  
19.	}
``` 
Test it Now
Output:
111 Karan
111 Karan
   	
</details>
<details><summary><b>[28 - Does constructor return any value?]</b></summary>

#### Q) Does constructor return any value?
Yes, it is the current class instance (You cannot use return type yet it returns a value).

</details>
<details><summary><b>[29 - Can constructor perform other tasks instead of initialization?]</b></summary>
	
#### Can constructor perform other tasks instead of initialization?
Yes, like object creation, starting a thread, calling a method, etc. You can perform any operation in the constructor as you perform in the method.
</details>
<details><summary><b>[30 - Is there Constructor class in Java?]</b></summary>
	
#### Is there Constructor class in Java?
Yes.
</details>
<details><summary><b>[31 - What is the purpose of Constructor class?]</b></summary>
	
#### What is the purpose of Constructor class?
Java provides a Constructor class which can be used to get the internal information of a constructor in the class. It is found in the java.lang.reflect package.
</details> 
</details>
<details><summary><b>[32 - this keyword in java]</b></summary>

 #### this keyword in java
Current object can be referenced in the body of the instance method by keyword this.

Sometimes a method will need to refer to the object that invoked it. To allow this java defines this keyword.

this can be used inside any method to refer to the current object. That is, this is always a reference to the object on which the method was invoked. You can use this anywhere a reference to an object of the current class’ type is permitted.

•	This is used to invoking the same class.
•	Super is used to invoking the parent class.
There can be a lot of usage of java this keyword. In java, this is a reference variable that refers to the current object.
 
- Usage of java this keyword
Here is given the 6 usage of java this keyword.
1.	this can be used to refer current class instance variable.
2.	this can be used to invoke current class method (implicitly)
3.	this() can be used to invoke current class constructor.
4.	this can be passed as an argument in the method call.
5.	this can be passed as argument in the constructor call.
6.	this can be used to return the current class instance from the method.
Suggestion: If you are beginner to java, lookup only three usage of this keyword.
 
________________________________________
1) this: to refer current class instance variable
The this keyword can be used to refer current class instance variable. If there is ambiguity between the instance variables and parameters, this keyword resolves the problem of ambiguity.
Understanding the problem without this keyword
Let's understand the problem if we don't use this keyword by the example given below:
1.	class Student{
2.	int rollno;
3.	String name;
4.	float fee;
5.	Student(int rollno,String name,float fee){
6.	rollno=rollno;
7.	name=name;
8.	fee=fee;
9.	}  
10.	void display(){System.out.println(rollno+" "+name+" "+fee);}  
11.	}  
12.	class TestThis1{  
13.	public static void main(String args[]){  
14.	Student s1=new Student(111,"ankit",5000f);  
15.	Student s2=new Student(112,"sumit",6000f);  
16.	s1.display();  
17.	s2.display();  
18.	}
19.	}  
Test it Now
Output:
0 null 0.0
0 null 0.0
In the above example, parameters (formal arguments) and instance variables are same. So, we are using this keyword to distinguish #### #### local variable and instance variable.
Solution of the above problem by this keyword
1.	class Student{  
2.	int rollno;  
3.	String name;  
4.	float fee;  
5.	Student(int rollno,String name,float fee){  
6.	this.rollno=rollno;  
7.	this.name=name;  
8.	this.fee=fee;  
9.	}  
10.	void display(){System.out.println(rollno+" "+name+" "+fee);}  
11.	}  
12.	  
13.	class TestThis2{  
14.	public static void main(String args[]){  
15.	Student s1=new Student(111,"ankit",5000f);  
16.	Student s2=new Student(112,"sumit",6000f);  
17.	s1.display();  
18.	s2.display();  
19.	}}  
Test it Now
Output:
111 ankit 5000
112 sumit 6000
If local variables (formal arguments) and instance variables are different, there is no need to use this keyword like in the following program:
Program where this keyword is not required
1.	class Student{  
2.	int rollno;  
3.	String name;  
4.	float fee;  
5.	Student(int r,String n,float f){  
6.	rollno=r;  
7.	name=n;  
8.	fee=f;  
9.	}  
10.	void display(){System.out.println(rollno+" "+name+" "+fee);}  
11.	}  
12.	  
13.	class TestThis3{  
14.	public static void main(String args[]){  
15.	Student s1=new Student(111,"ankit",5000f);  
16.	Student s2=new Student(112,"sumit",6000f);  
17.	s1.display();  
18.	s2.display();  
19.	}}  
Test it Now
Output:
111 ankit 5000
112 sumit 6000
It is better approach to use meaningful names for variables. So we use same name for instance variables and parameters in real time, and always use this keyword.
2) this: to invoke current class method
You may invoke the method of the current class by using the this keyword. If you don't use the this keyword, compiler automatically adds this keyword while invoking the method. Let's see the example
 
1.	class A{  
2.	void m(){System.out.println("hello m");}  
3.	void n(){  
4.	System.out.println("hello n");  
5.	//m();//same as this.m()  
6.	this.m();  
7.	}  
8.	}  
9.	class TestThis4{  
10.	public static void main(String args[]){  
11.	A a=new A();  
12.	a.n();  
13.	}}  
Test it Now
Output:
hello n
hello m
3) this() : to invoke current class constructor
The this() constructor call can be used to invoke the current class constructor. It is used to reuse the constructor. In other words, it is used for constructor chaining.
Calling default constructor from parameterized constructor:
1.	class A{  
2.	A(){System.out.println("hello a");}  
3.	A(int x){  
4.	this();  
5.	System.out.println(x);  
6.	}  
7.	}  
8.	class TestThis5{  
9.	public static void main(String args[]){  
10.	A a=new A(10);  
11.	}}  
Test it Now
Output:
hello a
10
Calling parameterized constructor from default constructor:
1.	class A{  
2.	A(){  
3.	this(5);  
4.	System.out.println("hello a");  
5.	}  
6.	A(int x){  
7.	System.out.println(x);  
8.	}  
9.	}  
10.	class TestThis6{  
11.	public static void main(String args[]){  
12.	A a=new A();  
13.	}}  
Test it Now
Output:
5
hello a
Real usage of this() constructor call
The this() constructor call should be used to reuse the constructor from the constructor. It maintains the chain between the constructors i.e. it is used for constructor chaining. Let's see the example given below that displays the actual use of this keyword.
1.	class Student{  
2.	int rollno;  
3.	String name,course;  
4.	float fee;  
5.	Student(int rollno,String name,String course){  
6.	this.rollno=rollno;  
7.	this.name=name;  
8.	this.course=course;  
9.	}  
10.	Student(int rollno,String name,String course,float fee){  
11.	this(rollno,name,course);//reusing constructor  
12.	this.fee=fee;  
13.	}  
14.	void display(){System.out.println(rollno+" "+name+" "+course+" "+fee);}  
15.	}  
16.	class TestThis7{  
17.	public static void main(String args[]){  
18.	Student s1=new Student(111,"ankit","java");  
19.	Student s2=new Student(112,"sumit","java",6000f);  
20.	s1.display();  
21.	s2.display();  
22.	}}  
Test it Now
Output:
111 ankit java null
112 sumit java 6000
Rule: Call to this() must be the first statement in constructor.
1.	class Student{  
2.	int rollno;  
3.	String name,course;  
4.	float fee;  
5.	Student(int rollno,String name,String course){  
6.	this.rollno=rollno;  
7.	this.name=name;  
8.	this.course=course;  
9.	}  
10.	Student(int rollno,String name,String course,float fee){  
11.	this.fee=fee;  
12.	this(rollno,name,course);//C.T.Error  
13.	}  
14.	void display(){System.out.println(rollno+" "+name+" "+course+" "+fee);}  
15.	}  
16.	class TestThis8{  
17.	public static void main(String args[]){  
18.	Student s1=new Student(111,"ankit","java");  
19.	Student s2=new Student(112,"sumit","java",6000f);  
20.	s1.display();  
21.	s2.display();  
22.	}}  
Test it Now
Compile Time Error: Call to this must be first statement in constructor
4) this: to pass as an argument in the method
The this keyword can also be passed as an argument in the method. It is mainly used in the event handling. Let's see the example:
1.	class S2{  
2.	  void m(S2 obj){  
3.	  System.out.println("method is invoked");  
4.	  }  
5.	  void p(){  
6.	  m(this);  
7.	  }  
8.	  public static void main(String args[]){  
9.	  S2 s1 = new S2();  
10.	  s1.p();  
11.	  }  
12.	}  
Test it Now
Output:
method is invoked
Application of this that can be passed as an argument:
In event handling (or) in a situation where we have to provide reference of a class to another one. It is used to reuse one object in many methods.
________________________________________
5) this: to pass as argument in the constructor call
We can pass the this keyword in the constructor also. It is useful if we have to use one object in multiple classes. Let's see the example:
1.	class B{  
2.	  A4 obj;  
3.	  B(A4 obj){  
4.	    this.obj=obj;  
5.	  }  
6.	  void display(){  
7.	    System.out.println(obj.data);//using data member of A4 class  
8.	  }  
9.	}  
10.	  
11.	class A4{  
12.	  int data=10;  
13.	  A4(){  
14.	   B b=new B(this);  
15.	   b.display();  
16.	  }  
17.	  public static void main(String args[]){  
18.	   A4 a=new A4();  
19.	  }  
20.	}  
Test it Now
Output:10
________________________________________
6) this keyword can be used to return current class instance
We can return this keyword as an statement from the method. In such case, return type of the method must be the class type (non-primitive). Let's see the example:
Syntax of this that can be returned as a statement
1.	return_type method_name(){  
2.	return this;  
3.	}  
Example of this keyword that you return as a statement from the method
1.	class A{  
2.	A getA(){  
3.	return this;  
4.	}  
5.	void msg(){System.out.println("Hello java");}  
6.	}  
7.	class Test1{  
8.	public static void main(String args[]){  
9.	new A().getA().msg();  
10.	}  
11.	}  
Test it Now
Output:
Hello java
Proving this keyword
Let's prove that this keyword refers to the current class instance variable. 
In this program, we are printing the reference variable and this, output of both variables are same.

1.	class A5{  
2.	void m(){  
3.	System.out.println(this);//prints same reference ID  
4.	}  
5.	public static void main(String args[]){  
6.	A5 obj=new A5();  
7.	System.out.println(obj);//prints the reference ID  
8.	obj.m();  
9.	}  
10.	}  
Test it Now
Output:
A5@22b3ea59
A5@22b3ea59
</details>
<details><summary><b>[33 - Garbage Collection]</b></summary>

#### Garbage Collection
Since objects are dynamically allocated by using the new operator, you might be wondering how such objects are destroyed and their memory released for later reallocation. In some languages, such as C++, dynamically allocated objects must be manually released by use of a delete operator. Java takes a different approach; it handles deallocation for you automatically. The technique that accomplishes this is called garbage collection. 

It works like this: when no references to an object exist, that object is assumed to be no longer needed, and the memory occupied by the object can be reclaimed. There is no explicit need to destroy objects as in C++. Garbage collection only occurs sporadically (if at all) during the execution of your program. It will not occur simply because one or more objects exist that are no longer used.


</details>
<details><summary><b>[34 - Finalize() method]</b></summary>

#### Finalize() method

By using finalization, you can define specific actions that will occur when an object is just about to be reclaimed by the garbage collector.

To add a finalizer to a class, you simply define the finalize( ) method. The Java run time calls that method whenever it is about to recycle an object of that class. Inside the finalize( ) method, you will specify those actions that must be performed before an object is destroyed.

The garbage collector runs periodically, checking for objects that are no longer referenced by any running state or indirectly through other referenced objects. Right before an asset is freed, the Java run time calls the finalize( ) method on the object.

The finalize( ) method has this general form:

protected void finalize( )
{
// finalization code here
}

Here, the keyword protected is a specifier that prevents access to finalize( ) by code defined outside its class. It is important to understand that finalize( ) is only called just prior to garbage collection. It is not called when an object goes out-of-scope.

When all references to an object are dropped, the object no longer required and become eligible for garbage collection. Before an object is garbage collected the runtime system is calls its finalize() method to release system resources such as open file or open socket before the object is collected.


</details>
<details><summary><b>[35 - Memory Management]</b></summary>

#### Memory Management
Although Java provides automatic garbage collection, sometimes you will want to know how large the object heap is and how much of it is left. You can use this information, for example, to check your code for efficiency or to approximate how many more objects of a certain type can be instantiated. To obtain these values, use the totalMemory( ) and freeMemory( ) methods.

Java’s garbage collector runs periodically to recycle unused objects. However, sometimes you will want to collect discarded objects prior to the collector’s next appointed rounds. You can run the garbage collector on demand by calling the gc( ) method. A good thing to try is to call gc( ) and then call freeMemory( ) to get a baseline memory usage. Next, execute your code and call freeMemory( ) again to see how much memory it is allocating.
</details>
<details><summary><b>[36 - Method Overloading in Java]</b></summary>

#### Method Overloading in Java
Method overloading is one of java’s most exciting and useful feature. 
When two or more methods within the same class that share the same name, as long as their parameter declarations are different. When this is the case, the methods are said to be overloaded, and the process is referred to as method overloading. Method overloading is one of the ways that Java supports polymorphism.
If a class has multiple methods having same name but different in parameters, it is known as Method Overloading.
If we have to perform only one operation, having same name of the methods increases the readability of the program.
Suppose you have to perform addition of the given numbers but there can be any number of arguments, if you write the method such as a(int, int) for two parameters, and b(int, int, int) for three parameters then it may be difficult for you as well as other programmers to understand the behavior of the method because its name differs.
So, we perform method overloading to figure out the program quickly.
 
- Advantage of method overloading
Method overloading increases the readability of the program.
Different ways to overload the method
There are two ways to overload the method in java
1.	By changing number of arguments
2.	By changing the data type
In java, Method Overloading is not possible by changing the return type of the method only.
________________________________________
1) Method Overloading: changing no. of arguments
In this example, we have created two methods, first add() method performs addition of two numbers and second add method performs addition of three numbers.
In this example, we are creating static methods so that we don't need to create instance for calling methods.
1.	class Adder{  
2.	static int add(int a,int b){return a+b;}  
3.	static int add(int a,int b,int c){return a+b+c;}  
4.	}  
5.	class TestOverloading1{  
6.	public static void main(String[] args){  
7.	System.out.println(Adder.add(11,11));  
8.	System.out.println(Adder.add(11,11,11));  
9.	}}  
Test it Now
Output:
22
33

________________________________________
2) Method Overloading: changing data type of arguments
In this example, we have created two methods that differs in data type. The first add method receives two integer arguments and second add method receives two double arguments.
1.	class Adder{  
2.	static int add(int a, int b){return a+b;}  
3.	static double add(double a, double b){return a+b;}  
4.	}  
5.	class TestOverloading2{  
6.	public static void main(String[] args){  
7.	System.out.println(Adder.add(11,11));  
8.	System.out.println(Adder.add(12.3,12.6));  
9.	}}  
Test it Now
Output:
22
24.9

<details><summary><b>[37 - Can we overload java main() method?]</b></summary>


</details>
<details><summary><b>[38 - Why Method Overloading is not possible by changing the return type of method only?]</b>
</summary>

#### Q) Why Method Overloading is not possible by changing the return type of method only?
In java, method overloading is not possible by changing the return type of the method only because of ambiguity. Let's see how ambiguity may occur:
1.	class Adder{  
2.	static int add(int a,int b){return a+b;}  
3.	static double add(int a,int b){return a+b;}  
4.	}  
5.	class TestOverloading3{  
6.	public static void main(String[] args){  
7.	System.out.println(Adder.add(11,11));//ambiguity  
8.	}}  
Test it Now
Output:
Compile Time Error: method add(int,int) is already defined in class Adder
System.out.println(Adder.add(11,11)); //Here, how can java determine which sum() method should be called?
Note: Compile Time Error is better than Run Time Error. So, java compiler renders compiler time error if you declare the same method having same parameters.
Can we overload java main() method?
Yes, by method overloading. You can have any number of main methods in a class by method overloading. But JVM calls main() method which receives string array as arguments only. Let's see the simple example:
1.	class TestOverloading4{  
2.	public static void main(String[] args){System.out.println("main with String[]");}  
3.	public static void main(String args){System.out.println("main with String");}  
4.	public static void main(){System.out.println("main without args");}  
5.	}  
Test it Now
Output:
main with String[]
</details>
<details><summary><b>[39 - Method Overloading and Type Promotion]</b></summary>

#### Method Overloading and Type Promotion
One type is promoted to another implicitly if no matching datatype is found. Let's understand the concept by the figure given below:
 
As displayed in the above diagram, byte can be promoted to short, int, long, float or double. The short datatype can be promoted to int, long, float or double. The char datatype can be promoted to int,long,float or double and so on.
Example of Method Overloading with TypePromotion
1.	class OverloadingCalculation1{  
2.	  void sum(int a,long b){System.out.println(a+b);}  
3.	  void sum(int a,int b,int c){System.out.println(a+b+c);}  
4.	  
5.	  public static void main(String args[]){  
6.	  OverloadingCalculation1 obj=new OverloadingCalculation1();  
7.	  obj.sum(20,20);//now second int literal will be promoted to long  
8.	  obj.sum(20,20,20);  
9.	  
10.	  }  
11.	}  
Test it Now
Output:40
       60

#### Example of Method Overloading with Type Promotion if matching found
If there are matching type arguments in the method, type promotion is not performed.
1.	class OverloadingCalculation2{  
2.	  void sum(int a,int b){System.out.println("int arg method invoked");}  
3.	  void sum(long a,long b){System.out.println("long arg method invoked");}  
4.	  
5.	  public static void main(String args[]){  
6.	  OverloadingCalculation2 obj=new OverloadingCalculation2();  
7.	  obj.sum(20,20);//now int arg sum() method gets invoked  
8.	  }  
9.	}  
Test it Now
Output:int arg method invoked
Example of Method Overloading with Type Promotion in case of ambiguity
If there are no matching type arguments in the method, and each method promotes similar number of arguments, there will be ambiguity.
1.	class OverloadingCalculation3{  
2.	  void sum(int a,long b){System.out.println("a method invoked");}  
3.	  void sum(long a,int b){System.out.println("b method invoked");}  
4.	  
5.	  public static void main(String args[]){  
6.	  OverloadingCalculation3 obj=new OverloadingCalculation3();  
7.	  obj.sum(20,20);//now ambiguity  
8.	  }  
9.	}  
Test it Now
Output:Compile Time Error
       
One type is not de-promoted implicitly for example double cannot be depromoted to any type implicitly.

#### Argument Passing

There are two ways that a computer language can pass an argument to a subroutine.

- The first way is call-by-value. 

This approach copies the value of an argument into the formal parameter of the subroutine. Therefore, changes made to the parameter of the subroutine have no effect on the argument. 

- The second way an argument can be passed is call-by-reference.

In this approach, a reference to an argument (not the value of the argument) is passed to the parameter. Inside the subroutine, this reference is used to access the actual argument specified in the call. This means that changes made to the parameter will affect the argument used to call the subroutine.
</details>
</details>
<details><summary><b>[40 - Recursion in Java]</b></summary>

 #### Recursion
Java supports recursion. Recursion is the process of defining something in terms of itself. As it relates to Java programming, recursion is the attribute that allows a method to call itself.
A method that calls itself is said to be recursive.

The classic example of recursion is the computation of the factorial of a number. The factorial of a number N is the product of all the whole numbers between 1 and N. For example, 3 factorial is 1 × 2 × 3, or 6. 

Here is how a factorial can be computed by use of a recursive method:
// A simple example of recursion.
class Factorial {
// this is a recursive method
int fact(int n) {
int result;
if(n==1) return 1;
result = fact(n-1) * n;
return result
}
}
class Recursion {
public static void main(String args[]) {
Factorial f = new Factorial();
System.out.println("Factorial of 3 is " + f.fact(3));
System.out.println("Factorial of 4 is " + f.fact(4));
System.out.println("Factorial of 5 is " + f.fact(5));
}
}
The output from this program is shown here:
Factorial of 3 is 6
Factorial of 4 is 24
Factorial of 5 is 120
</details>
<details><summary><b>[41 - Method Overriding in Java]</b></summary>

 #### Method Overriding in Java
When a method in a subclass has the same name and type signature as a method in its superclass, then the method in the subclass is said to override the method in the superclass. 
When an overridden method is called from within a subclass, it will always refer to the version of that method defined by the subclass. The version of the method defined by the superclass will be hidden.
Method overriding forms the basis for one of Java’s most powerful concepts: dynamic method dispatch. Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than compile time.
Dynamic method dispatch is important because this is how Java implements run-time polymorphism.

A superclass reference variable can refer to a subclass object. Java uses this fact to resolve calls to overridden methods at run time. 

Here is how. 

When an overridden method is called through a superclass reference, Java determines which version of that method to execute based upon the type of the object being referred to at the time the call occurs. Thus, this determination is made at run time. When different types of objects are referred to, different versions of an overridden method will be called.

In other words, it is the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed. Therefore, if a superclass contains a method that is overridden by a subclass, then when different types of objects are referred to through a superclass reference variable, different versions of the method are executed.

Here is an example that illustrates dynamic method dispatch:
// Dynamic Method Dispatch
class A {
void callme() {
System.out.println("Inside A's callme method");
}
}
class B extends A {
// override callme()
void callme() {
System.out.println("Inside B's callme method");
}
}
class C extends A {
// override callme()
void callme() {
System.out.println("Inside C's callme method");
}
}
class Dispatch {
public static void main(String args[]) {
A a = new A(); // object of type A
B b = new B(); // object of type B
C c = new C(); // object of type C
A r; // obtain a reference of type A
r = a; // r refers to an A object
r.callme(); // calls A's version of callme
r = b; // r refers to a B object
r.callme(); // calls B's version of callme
r = c; // r refers to a C object
r.callme(); // calls C's version of callme
}
}
The output from the program is shown here:
Inside A’s callme method
Inside B’s callme method
Inside C’s callme method

This program creates one superclass called A and two subclasses of it, called B and C.

Subclasses B and C override callme( ) declared in A. Inside the main( ) method, objects of type A, B, and C are declared. Also, a reference of type A, called r, is declared. The program then in turn assigns a reference to each type of object to r and uses that reference to invoke callme( ). As the output shows, the version of callme( ) executed is determined by the type of object being referred to at the time of the call. Had it been determined by the type of the reference variable, r, you would see three calls to A’s callme( ) method. 

<details><summary><b>[41.1 - Can we override static method?]</b></summary>

 #### Why Overridden Methods?

The superclass provides all elements that a subclass can use directly. It also defines those methods that the derived class must implement on its own. This allows the subclass the flexibility to define its own methods, yet still enforces a consistent interface.

Thus, by combining inheritance with overridden methods, a superclass can define the general form of the methods that will be used by all of its subclasses.
If subclass (child class) has the same method as declared in the parent class, it is known as method overriding in Java.
In other words, If a subclass provides the specific implementation of the method that has been declared by one of its parent class, it is known as method overriding.
Usage of Java Method Overriding
o	Method overriding is used to provide the specific implementation of a method which is already provided by its superclass.
o	Method overriding is used for runtime polymorphism
Rules for Java Method Overriding
1.	The method must have the same name as in the parent class
2.	The method must have the same parameter as in the parent class.
3.	There must be an IS-A relationship (inheritance).
  
Understanding the problem without method overriding
Let's understand the problem that we may face in the program if we don't use method overriding.
1.	//Java Program to demonstrate why we need method overriding  
2.	//Here, we are calling the method of parent class with child  
3.	//class object.  
4.	//Creating a parent class  
5.	class Vehicle{  
6.	  void run(){System.out.println("Vehicle is running");}  
7.	}  
8.	//Creating a child class  
9.	class Bike extends Vehicle{  
10.	  public static void main(String args[]){  
11.	  //creating an instance of child class  
12.	  Bike obj = new Bike();  
13.	  //calling the method with child class instance  
14.	  obj.run();  
15.	  }  
16.	}  
Test it Now
Output:
Vehicle is running
Problem is that I have to provide a specific implementation of run() method in subclass that is why we use method overriding.
________________________________________
Example of method overriding
In this example, we have defined the run method in the subclass as defined in the parent class but it has some specific implementation. The name and parameter of the method are the same, and there is IS-A relationship between the classes, so there is method overriding.
1.	//Java Program to illustrate the use of Java Method Overriding  
2.	//Creating a parent class.  
3.	class Vehicle{  
4.	  //defining a method  
5.	  void run(){System.out.println("Vehicle is running");}  
6.	}  
7.	//Creating a child class  
8.	class Bike2 extends Vehicle{  
9.	  //defining the same method as in the parent class  
10.	  void run(){System.out.println("Bike is running safely");}  
11.	  
12.	  public static void main(String args[]){  
13.	  Bike2 obj = new Bike2();//creating object  
14.	  obj.run();//calling method  
15.	  }  
16.	}  
Test it Now
Output:
Bike is running safely
________________________________________
A real example of Java Method Overriding
Consider a scenario where Bank is a class that provides functionality to get the rate of interest. However, the rate of interest varies according to banks. For example, SBI, ICICI and AXIS banks could provide 8%, 7%, and 9% rate of interest.
 
Java method overriding is mostly used in Runtime Polymorphism which we will learn in next pages.
1.	//Java Program to demonstrate the real scenario of Java Method Overriding  
2.	//where three classes are overriding the method of a parent class.  
3.	//Creating a parent class.  
4.	class Bank{  
5.	int getRateOfInterest(){return 0;}  
6.	}  
7.	//Creating child classes.  
8.	class SBI extends Bank{  
9.	int getRateOfInterest(){return 8;}  
10.	}  
11.	  
12.	class ICICI extends Bank{  
13.	int getRateOfInterest(){return 7;}  
14.	}  
15.	class AXIS extends Bank{  
16.	int getRateOfInterest(){return 9;}  
17.	}  
18.	//Test class to create objects and call the methods  
19.	class Test2{  
20.	public static void main(String args[]){  
21.	SBI s=new SBI();  
22.	ICICI i=new ICICI();  
23.	AXIS a=new AXIS();  
24.	System.out.println("SBI Rate of Interest: "+s.getRateOfInterest());  
25.	System.out.println("ICICI Rate of Interest: "+i.getRateOfInterest());  
26.	System.out.println("AXIS Rate of Interest: "+a.getRateOfInterest());  
27.	}  
28.	}  
Test it Now
Output:
SBI Rate of Interest: 8
ICICI Rate of Interest: 7
AXIS Rate of Interest: 9

#### Can we override static method?
No, a static method cannot be overridden. It can be proved by runtime polymorphism, so we will learn it later.

<details><summary><b>[41.2 - Why can we not override static method?]</b></summary>

#### Why can we not override static method?
It is because the static method is bound with class whereas instance method is bound with an object. Static belongs to the class area, and an instance belongs to the heap area.

</details>
<details><summary><b>[41.3 - Can we override java main method?]</b></summary>

#### Can we override java main method?
No, because the main is a static method.

</details>
<details><summary><b>[41.4 - Difference between method Overloading and Method Overriding in java]</b></summary>

#### Difference between method Overloading and Method Overriding in java
Click me for the difference between method overloading and overriding

</details>
</details>
<details><summary><b>[41.5 - Usage of Java Method Overriding]</b></summary>


</details>
</details>
<details><summary><b>[43 - Dynamic Method Dispatch]</b></summary>

#### Dynamic Method Dispatch
Method overriding forms the basis for one of Java’s most powerful concepts: dynamic method dispatch. Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than compile time.

Dynamic method dispatch is important because this is how Java implements run-time polymorphism.

A superclass reference variable can refer to a subclass object. Java uses this fact to resolve calls to overridden methods at run time. 

Here is how. 

When an overridden method is called through a superclass reference, Java determines which version of that method to execute based upon the type of the object being referred to at the time the call occurs. Thus, this determination is made at run time. When different types of objects are referred to, different versions of an overridden method will be called.

In other words, it is the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed. Therefore, if a superclass contains a method that is overridden by a subclass, then when different types of objects are referred to through a superclass reference variable, different versions of the method are executed.

Here is an example that illustrates dynamic method dispatch:
// Dynamic Method Dispatch
class A {
void callme() {
System.out.println("Inside A's callme method");
}
}
class B extends A {
// override callme()
void callme() {
System.out.println("Inside B's callme method");
}
}
class C extends A {
// override callme()
void callme() {
System.out.println("Inside C's callme method");
}
}
class Dispatch {
public static void main(String args[]) {
A a = new A(); // object of type A
B b = new B(); // object of type B
C c = new C(); // object of type C
A r; // obtain a reference of type A
r = a; // r refers to an A object
r.callme(); // calls A's version of callme
r = b; // r refers to a B object
r.callme(); // calls B's version of callme
r = c; // r refers to a C object
r.callme(); // calls C's version of callme
}
}
The output from the program is shown here:
Inside A’s callme method
Inside B’s callme method
Inside C’s callme method

This program creates one superclass called A and two subclasses of it, called B and C.

Subclasses B and C override callme( ) declared in A. Inside the main( ) method, objects of type A, B, and C are declared. Also, a reference of type A, called r, is declared. The program then in turn assigns a reference to each type of object to r and uses that reference to invoke callme( ). As the output shows, the version of callme( ) executed is determined by the type of object being referred to at the time of the call. Had it been determined by the type of the reference variable, r, you would see three calls to A’s callme( ) method. 

#### Why Overridden Methods?

The superclass provides all elements that a subclass can use directly. It also defines those methods that the derived class must implement on its own. This allows the subclass the flexibility to define its own methods, yet still enforces a consistent interface.

Thus, by combining inheritance with overridden methods, a superclass can define the general form of the methods that will be used by all of its subclasses.

</details>
<details><summary><b>[44 - Static Binding and Dynamic Binding]</b></summary>

 #### Static Binding and Dynamic Binding
 
Connecting a method call to the method body is known as binding.
There are two types of binding
1.	Static Binding (also known as Early Binding).
2.	Dynamic Binding (also known as Late Binding).
 
Understanding Type
Let's understand the type of instance.
1) variables have a type
Each variable has a type, it may be primitive and non-primitive.
1.	int data=30;  
Here data variable is a type of int.
2) References have a type
1.	class Dog{  
2.	 public static void main(String args[]){  
3.	  Dog d1;//Here d1 is a type of Dog  
4.	 }  
5.	}  
3) Objects have a type
An object is an instance of particular java class,but it is also an instance of its superclass.
1.	class Animal{}  
2.	  
3.	class Dog extends Animal{  
4.	 public static void main(String args[]){  
5.	  Dog d1=new Dog();  
6.	 }  
7.	}  
Here d1 is an instance of Dog class, but it is also an instance of Animal.
________________________________________
#### static binding
When type of the object is determined at compiled time(by the compiler), it is known as static binding.
If there is any private, final or static method in a class, there is static binding.
Example of static binding
1.	class Dog{  
2.	 private void eat(){System.out.println("dog is eating...");}  
3.	  
4.	 public static void main(String args[]){  
5.	  Dog d1=new Dog();  
6.	  d1.eat();  
7.	 }  
8.	}  
________________________________________
#### Dynamic binding
When type of the object is determined at run-time, it is known as dynamic binding.
Example of dynamic binding
1.	class Animal{  
2.	 void eat(){System.out.println("animal is eating...");}  
3.	}  
4.	  
5.	class Dog extends Animal{  
6.	 void eat(){System.out.println("dog is eating...");}  
7.	  
8.	 public static void main(String args[]){  
9.	  Animal a=new Dog();  
10.	  a.eat();  
11.	 }  
12.	}  
Test it Now
Output:dog is eating...
In the above example object type cannot be determined by the compiler, 
because the instance of Dog is also an instance of Animal.So compiler doesn't know its type, 
only its base type.
</details>
<details><summary><b>[45 - Java static keyword]</b></summary>

#### Java static keyword
1.	Static variable
2.	Program of the counter without static variable
3.	Program of the counter with static variable
4.	Static method
5.	Restrictions for the static method
6.	Why is the main method static?
7.	Static block
8.	Can we execute a program without main method?
When you will want to define a class member that will be used independently of any object of that class. 

Normally, a class member must be accessed only in conjunction with an object of its class. However, it is possible to create a member that can be used by itself, without reference to a specific instance. 

To create such a member, precede its declaration with the keyword static. 

When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object. You can declare both methods and variables to be static. 

The most common example of a static member is main( ). main( ) is declared as static because it must be called before any objects exist.

Instance variables declared as static are, essentially, global variables. When objects of its class are declared, no copy of a static variable is made. Instead, all instances of the class share the same static variable.

Methods declared as static have several restrictions:

• They can only call other static methods.
• They must only access static data.
• They cannot refer to this or super in any way. (The keyword super relates to inheritance.)

If you need to do computation in order to initialize your static variables, you can declare a static block that gets executed exactly once, when the class is first loaded.

The static keyword in Java is used for memory management mainly. We can apply static keyword with variables, methods, blocks and nested classes. The static keyword belongs to the class than an instance of the class.
The static can be:
1.	Variable (also known as a class variable)
2.	Method (also known as a class method)
3.	Block
4.	Nested class
 
1) Java static variable
If you declare any variable as static, it is known as a static variable.
o	The static variable can be used to refer to the common property of all objects (which is not unique for each object), for example, the company name of employees, college name of students, etc.
o	The static variable gets memory only once in the class area at the time of class loading.
Advantages of static variable
It makes your program memory efficient (i.e., it saves memory).
Understanding the problem without static variable
1.	class Student{  
2.	     int rollno;  
3.	     String name;  
4.	     String college="ITS";  
5.	}  
Suppose there are 500 students in my college, now all instance data members will get memory each time when the object is created. All students have its unique rollno and name, so instance data member is good in such case. Here, "college" refers to the common property of all objects. If we make it static, this field will get the memory only once.
Java static property is shared to all objects.
Example of static variable
1.	//Java Program to demonstrate the use of static variable  
2.	class Student{  
3.	   int rollno;//instance variable  
4.	   String name;  
5.	   static String college ="ITS";//static variable  
6.	   //constructor  
7.	   Student(int r, String n){  
8.	   rollno = r;  
9.	   name = n;  
10.	   }  
11.	   //method to display the values  
12.	   void display (){System.out.println(rollno+" "+name+" "+college);}  
13.	}  
14.	//Test class to show the values of objects  
15.	public class TestStaticVariable1{  
16.	 public static void main(String args[]){  
17.	 Student s1 = new Student(111,"Karan");  
18.	 Student s2 = new Student(222,"Aryan");  
19.	 //we can change the college of all objects by the single line of code  
20.	 //Student.college="BBDIT";  
21.	 s1.display();  
22.	 s2.display();  
23.	 }  
24.	}  
Test it Now
Output:
111 Karan ITS
222 Aryan ITS
 
________________________________________
Program of the counter without static variable
In this example, we have created an instance variable named count which is incremented in the constructor. Since instance variable gets the memory at the time of object creation, each object will have the copy of the instance variable. If it is incremented, it won't reflect other objects. So each object will have the value 1 in the count variable.
1.	//Java Program to demonstrate the use of an instance variable  
2.	//which get memory each time when we create an object of the class.  
3.	class Counter{  
4.	int count=0;//will get memory each time when the instance is created  
5.	  
6.	Counter(){  
7.	count++;//incrementing value  
8.	System.out.println(count);  
9.	}  
10.	  
11.	public static void main(String args[]){  
12.	//Creating objects  
13.	Counter c1=new Counter();  
14.	Counter c2=new Counter();  
15.	Counter c3=new Counter();  
16.	}  
17.	}  
Test it Now
Output:
1
1
1
________________________________________
Program of counter by static variable
As we have mentioned above, static variable will get the memory only once, if any object changes the value of the static variable, it will retain its value.
1.	//Java Program to illustrate the use of static variable which  
2.	//is shared with all objects.  
3.	class Counter2{  
4.	static int count=0;//will get memory only once and retain its value  
5.	  
6.	Counter2(){  
7.	count++;//incrementing the value of static variable  
8.	System.out.println(count);  
9.	}  
10.	  
11.	public static void main(String args[]){  
12.	//creating objects  
13.	Counter2 c1=new Counter2();  
14.	Counter2 c2=new Counter2();  
15.	Counter2 c3=new Counter2();  
16.	}  
17.	}  
Test it Now
Output:
1
2
3
________________________________________
2) Java static method
If you apply static keyword with any method, it is known as static method.
o	A static method belongs to the class rather than the object of a class.
o	A static method can be invoked without the need for creating an instance of a class.
o	A static method can access static data member and can change the value of it.
Example of static method
1.	//Java Program to demonstrate the use of a static method.  
2.	class Student{  
3.	     int rollno;  
4.	     String name;  
5.	     static String college = "ITS";  
6.	     //static method to change the value of static variable  
7.	     static void change(){  
8.	     college = "BBDIT";  
9.	     }  
10.	     //constructor to initialize the variable  
11.	     Student(int r, String n){  
12.	     rollno = r;  
13.	     name = n;  
14.	     }  
15.	     //method to display values  
16.	     void display(){System.out.println(rollno+" "+name+" "+college);}  
17.	}  
18.	//Test class to create and display the values of object  
19.	public class TestStaticMethod{  
20.	    public static void main(String args[]){  
21.	    Student.change();//calling change method  
22.	    //creating objects  
23.	    Student s1 = new Student(111,"Karan");  
24.	    Student s2 = new Student(222,"Aryan");  
25.	    Student s3 = new Student(333,"Sonoo");  
26.	    //calling display method  
27.	    s1.display();  
28.	    s2.display();  
29.	    s3.display();  
30.	    }  
31.	}  
Test it Now
Output:111 Karan BBDIT
       222 Aryan BBDIT
       333 Sonoo BBDIT
________________________________________
Another example of a static method that performs a normal calculation
1.	//Java Program to get the cube of a given number using the static method  
2.	  
3.	class Calculate{  
4.	  static int cube(int x){  
5.	  return x*x*x;  
6.	  }  
7.	  
8.	  public static void main(String args[]){  
9.	  int result=Calculate.cube(5);  
10.	  System.out.println(result);  
11.	  }  
12.	}  
Test it Now
Output:125

Restrictions for the static method

There are two main restrictions for the static method. They are:
1.	The static method can not use non static data member or call non-static method directly.
2.	this and super cannot be used in static context.
1.	class A{  
2.	 int a=40;//non static  
3.	   
4.	 public static void main(String args[]){  
5.	  System.out.println(a);  
6.	 }  
7.	}        
Test it Now
Output:Compile Time Error

<details><summary><b>[45.1 - Why is the Java main method static?]</b></summary>

#### Q) Why is the Java main method static?
Ans) It is because the object is not required to call a static method. If it were a non-static method, JVM creates an object first then call main() method that will lead the problem of extra memory allocation.
</details>

3) Java static block
o	Is used to initialize the static data member.
o	It is executed before the main method at the time of classloading.
Example of static block
1.	class A2{  
2.	  static{System.out.println("static block is invoked");}  
3.	  public static void main(String args[]){  
4.	   System.out.println("Hello main");  
5.	  }  
6.	}  
Test it Now
Output:static block is invoked
       Hello main
________________________________________
#### Q) Can we execute a program without main() method?
Ans) No, one of the ways was the static block, but it was possible till JDK 1.6. Since JDK 1.7, it is not possible to execute a Java class without the main method.
1.	class A3{  
2.	  static{  
3.	  System.out.println("static block is invoked");  
4.	  System.exit(0);  
5.	  }  
6.	}  
Test it Now
Output:
static block is invoked
Since JDK 1.7 and above, output would be:
Error: Main method not found in class A3, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application

</details>
<details><summary><b>[46 - Final Keyword in Java]</b></summary>

#### Final Keyword In Java
1.	Final variable
2.	Final method
3.	Final class
4.	Is final method inherited ?
5.	Blank final variable
6.	Static blank final variable
7.	Final parameter
8.	Can you declare a final constructor

A final variable of a primitive datatypes cannot change its value once it has been initialized.
A final variable of a reference types cannot change its value once it has been initialized, but the state of the object it denotes can still be changed.

The final modifier can be used with the variable and the methods when a variable is declared as final it acts as a constants and its contents cannot be modified.

A method is declared final by attaching the method definition with the final modifier in the beginning. It may so happen that you want method to retain its original definition or speaking otherwise, you do not want a method final the method is prevented from being overridden in its subsequent class.

The final keyword in java is used to restrict the user. The java final keyword can be used in many context. Final can be:
1.	variable
2.	method
3.	class

The final keyword can be applied with the variables, a final variable that have no value it is called blank final variable or uninitialized final variable. It can be initialized in the constructor only. The blank final variable can be static also which will be initialized in the static block only. We will have detailed learning of these. Let's first learn the basics of final keyword.
 
- 1) Java final variable
If you make any variable as final, you cannot change the value of final variable(It will be constant).

Example of final variable

There is a final variable speedlimit, we are going to change the value of this variable, but It can't be changed because final variable once assigned a value can never be changed.
1.	class Bike9{  
2.	 final int speedlimit=90;//final variable  
3.	 void run(){  
4.	  speedlimit=400;  
5.	 }  
6.	 public static void main(String args[]){  
7.	 Bike9 obj=new  Bike9();  
8.	 obj.run();  
9.	 }  
10.	}//end of class  
Test it Now
Output:Compile Time Error

- 2) Java final method
If you make any method as final, you cannot override it.
Example of final method
1.	class Bike{  
2.	  final void run(){System.out.println("running");}  
3.	}  
4.	     
5.	class Honda extends Bike{  
6.	   void run(){System.out.println("running safely with 100kmph");}  
7.	     
8.	   public static void main(String args[]){  
9.	   Honda honda= new Honda();  
10.	   honda.run();  
11.	   }  
12.	}  
Test it Now
Output:Compile Time Error

- 3) Java final class
If you make any class as final, you cannot extend it.
Example of final class
1.	final class Bike{}  
2.	  
3.	class Honda1 extends Bike{  
4.	  void run(){System.out.println("running safely with 100kmph");}  
5.	    
6.	  public static void main(String args[]){  
7.	  Honda1 honda= new Honda1();  
8.	  honda.run();  
9.	  }  
10.	}  
Test it Now
Output:Compile Time Error

<details><summary><b>[46.1 - Is final method inherited?]</b></summary>

Q) Is final method inherited?
Ans) Yes, final method is inherited but you cannot override it. For Example:
1.	class Bike{  
2.	  final void run(){System.out.println("running...");}  
3.	}  
4.	class Honda2 extends Bike{  
5.	   public static void main(String args[]){  
6.	    new Honda2().run();  
7.	   }  
8.	}  
Test it Now
Output:running...

</details>
<details><summary><b>[46.2 - What is blank or uninitialized final variable?]</b></summary>

Q) What is blank or uninitialized final variable?
A final variable that is not initialized at the time of declaration is known as blank final variable.
If you want to create a variable that is initialized at the time of creating object and once initialized may not be changed, it is useful. For example PAN CARD number of an employee.

It can be initialized only in constructor.

Example of blank final variable
1.	class Student{  
2.	int id;  
3.	String name;  
4.	final String PAN_CARD_NUMBER;  
5.	...  
6.	}  
</details>


Q) Can we initialize blank final variable?
Yes, but only in constructor. For example:
1.	class Bike10{  
2.	  final int speedlimit;//blank final variable  
3.	    
4.	  Bike10(){  
5.	  speedlimit=70;  
6.	  System.out.println(speedlimit);  
7.	  }  
8.	  
9.	  public static void main(String args[]){  
10.	    new Bike10();  
11.	 }  
12.	}  
Test it Now
Output: 70

static blank final variable
A static final variable that is not initialized at the time of declaration is known as static blank final variable. It can be initialized only in static block.
Example of static blank final variable
1.	class A{  
2.	  static final int data;//static blank final variable  
3.	  static{ data=50;}  
4.	  public static void main(String args[]){  
5.	    System.out.println(A.data);  
6.	 }  
7.	}  
<details><summary><b>[46.3 - What is final parameter?]</b></summary>
Q) What is final parameter?
If you declare any parameter as final, you cannot change the value of it.
1.	class Bike11{  
2.	  int cube(final int n){  
3.	   n=n+2;//can't be changed as n is final  
4.	   n*n*n;  
5.	  }  
6.	  public static void main(String args[]){  
7.	    Bike11 b=new Bike11();  
8.	    b.cube(5);  
9.	 }  
10.	}  
Test it Now
Output: Compile Time Error
________________________________________
</details>
<details><summary><b>[025 - Can we declare a constructor final?]</b></summary>

Q) Can we declare a constructor final?
No, because constructor is never inherited.
</details>
</details>
<details><summary><b>[47 - Super Keyword in Java]</b></summary>

#### Super Keyword in Java
There will be times when you will want to create a superclass that keeps the details of its implementation to itself (that is, that keeps its data members private).
In this case, there would be no way for a subclass to directly access or initialize superclass variables on its own. Since encapsulation is a primary attribute of OOP, it is not surprising that Java provides a solution to this problem. 

Whenever a subclass needs to refer to its immediate superclass, it can do so by use of the keyword super.

super has two general forms. 

The first calls the superclass’ constructor. 
The second is used to access a member of the superclass that has been hidden by a member of a subclass. 

Each use is examined here.

- Using super to Call Superclass Constructors

A subclass can call a constructor defined by its superclass by use of the following form of super:
super(arg-list);
Here, arg-list specifies any arguments needed by the constructor in the superclass. super( ) must always be the first statement executed inside a subclass’ constructor.

The key concepts behind super( ). When a subclass calls super( ), it is calling the constructor of its immediate superclass. Thus, super( ) always refers to the superclass immediately above the calling class. This is true even in a multileveled hierarchy. Also, super( ) must always be the first statement executed inside a subclass constructor.

- A Second Use for super

The second form of super acts somewhat like this, except that it always refers to the superclass of the subclass in which it is used. This usage has the following general form:
super.member
Here, member can be either a method or an instance variable.
This second form of super is most applicable to situations in which member names of a subclass hide members by the same name in the superclass.

The super keyword in Java is a reference variable which is used to refer immediate parent class object.
Whenever you create the instance of subclass, an instance of parent class is created implicitly which is referred by super reference variable.
- Usage of Java super Keyword
1.	super can be used to refer immediate parent class instance variable.
2.	super can be used to invoke immediate parent class method.
3.	super() can be used to invoke immediate parent class constructor.
 
1) super is used to refer immediate parent class instance variable.
We can use super keyword to access the data member or field of parent class. It is used if parent class and child class have same fields.
1.	class Animal{  
2.	String color="white";  
3.	}  
4.	class Dog extends Animal{  
5.	String color="black";  
6.	void printColor(){  
7.	System.out.println(color);//prints color of Dog class  
8.	System.out.println(super.color);//prints color of Animal class  
9.	}  
10.	}  
11.	class TestSuper1{  
12.	public static void main(String args[]){  
13.	Dog d=new Dog();  
14.	d.printColor();  
15.	}}  
Test it Now
Output:
black
white
In the above example, Animal and Dog both classes have a common property color. If we print color property, it will print the color of current class by default. To access the parent property, we need to use super keyword.
2) super can be used to invoke parent class method
The super keyword can also be used to invoke parent class method. It should be used if subclass contains the same method as parent class. In other words, it is used if method is overridden.
1.	class Animal{  
2.	void eat(){System.out.println("eating...");}  
3.	}  
4.	class Dog extends Animal{  
5.	void eat(){System.out.println("eating bread...");}  
6.	void bark(){System.out.println("barking...");}  
7.	void work(){  
8.	super.eat();  
9.	bark();  
10.	}  
11.	}  
12.	class TestSuper2{  
13.	public static void main(String args[]){  
14.	Dog d=new Dog();  
15.	d.work();  
16.	}}  
Test it Now
Output:
eating...
barking...
In the above example Animal and Dog both classes have eat() method if we call eat() method from Dog class, it will call the eat() method of Dog class by default because priority is given to local.
To call the parent class method, we need to use super keyword.
3) super is used to invoke parent class constructor.
The super keyword can also be used to invoke the parent class constructor. Let's see a simple example:
1.	class Animal{  
2.	Animal(){System.out.println("animal is created");}  
3.	}  
4.	class Dog extends Animal{  
5.	Dog(){  
6.	super();  
7.	System.out.println("dog is created");  
8.	}  
9.	}  
10.	class TestSuper3{  
11.	public static void main(String args[]){  
12.	Dog d=new Dog();  
13.	}}  
Test it Now
Output:
animal is created
dog is created
Note: super() is added in each class constructor automatically by compiler if there is no super() or this().
 
As we know well that default constructor is provided by compiler automatically if there is no constructor. But, it also adds super() as the first statement.
Another example of super keyword where super() is provided by the compiler implicitly.
1.	class Animal{  
2.	Animal(){System.out.println("animal is created");}  
3.	}  
4.	class Dog extends Animal{  
5.	Dog(){  
6.	System.out.println("dog is created");  
7.	}  
8.	}  
9.	class TestSuper4{  
10.	public static void main(String args[]){  
11.	Dog d=new Dog();  
12.	}}  
Test it Now
Output:
animal is created
dog is created
super example: real use
Let's see the real use of super keyword. Here, Emp class inherits Person class so all the properties of Person will be inherited to Emp by default. To initialize all the property, we are using parent class constructor from child class. In such way, we are reusing the parent class constructor.
1.	class Person{  
2.	int id;  
3.	String name;  
4.	Person(int id,String name){  
5.	this.id=id;  
6.	this.name=name;  
7.	}  
8.	}  
9.	class Emp extends Person{  
10.	float salary;  
11.	Emp(int id,String name,float salary){  
12.	super(id,name);//reusing parent constructor  
13.	this.salary=salary;  
14.	}  
15.	void display(){System.out.println(id+" "+name+" "+salary);}  
16.	}  
17.	class TestSuper5{  
18.	public static void main(String[] args){  
19.	Emp e1=new Emp(1,"ankit",45000f);  
20.	e1.display();  
21.	}}  
Test it Now
Output:
1 ankit 45000



</details>
<details><summary><b>[48 - Method Overriding]</b></summary>

#### Method Overriding
When a method in a subclass has the same name and type signature as a method in its superclass, then the method in the subclass is said to override the method in the superclass. 

When an overridden method is called from within a subclass, it will always refer to the version of that method defined by the subclass. The version of the method defined by the superclass will be hidden.
</details>
<details><summary><b>[49 - Abstract class in Java]</b></summary>

 #### Abstract class in Java

An abstract class is a class designed with implementation gaps for subclasses to fill in and is deliberately incomplete.
You can require that certain methods be overridden by subclasses by specifying the abstract type modifier. These methods are sometimes referred to as subclasser responsibility because they have no implementation specified in the superclass. Thus, a subclass must override them—it cannot simply use the version defined in the superclass. 

To declare an abstract method, use this general form:

abstract type name(parameter-list);

As you can see, no method body is present.

Any class that contains one or more abstract methods must also be declared abstract. To declare a class abstract, you simply use the abstract keyword in front of the class keyword at the beginning of the class declaration. There can be no objects of an abstract class. That is, an abstract class cannot be directly instantiated with the new operator. Such objects would be useless, because an abstract class is not fully defined. Also, you cannot declare abstract constructors, or abstract static methods. Any subclass of an abstract class must either implement all of the abstract methods in the superclass, or be itself declared abstract.
In an abstract class method have partially implementation.
A class which is declared with the abstract keyword is known as an abstract class in Java. It can have abstract and non-abstract methods (method with the body).
Before learning the Java abstract class, let's understand the abstraction in Java first.

#### Abstract class in Java
A class which is declared as abstract is known as an abstract class. It can have abstract and non-abstract methods. It needs to be extended and its method implemented. It cannot be instantiated.
Points to Remember
o	An abstract class must be declared with an abstract keyword.
o	It can have abstract and non-abstract methods.
o	It cannot be instantiated.
o	It can have constructors and static methods also.
o	It can have final methods which will force the subclass not to change the body of the method.
 
Example of abstract class
1.	abstract class A{}  

<details><summary><b>[49.1 - Abstract Method in Java]</b></summary>

#### Abstract Method in Java
A method which is declared as abstract and does not have implementation is known as an abstract method.
Example of abstract method
1.	abstract void printStatus();//no method body and abstract  

Example of Abstract class that has an abstract method

In this example, Bike is an abstract class that contains only one abstract method run. Its implementation is provided by the Honda class.

1.	abstract class Bike{  
2.	  abstract void run();  
3.	}  
4.	class Honda4 extends Bike{  
5.	void run(){System.out.println("running safely");}  
6.	public static void main(String args[]){  
7.	 Bike obj = new Honda4();  
8.	 obj.run();  
9.	}  
10.	}  
Test it Now
running safely
</details>

- Understanding the real scenario of Abstract class
  
In this example, Shape is the abstract class, and its implementation is provided by the Rectangle and Circle classes.
Mostly, we don't know about the implementation class (which is hidden to the end user), and an object of the implementation class is provided by the factory method.

A factory method is a method that returns the instance of the class. We will learn about the factory method later.
In this example, if you create the instance of Rectangle class, draw() method of Rectangle class will be invoked.

File: TestAbstraction1.java
1.	abstract class Shape{  
2.	abstract void draw();  
3.	}  
4.	//In real scenario, implementation is provided by others i.e. unknown by end user  
5.	class Rectangle extends Shape{  
6.	void draw(){System.out.println("drawing rectangle");}  
7.	}  
8.	class Circle1 extends Shape{  
9.	void draw(){System.out.println("drawing circle");}  
10.	}  
11.	//In real scenario, method is called by programmer or user  
12.	class TestAbstraction1{  
13.	public static void main(String args[]){  
14.	Shape s=new Circle1();//In a real scenario, object is provided through method, e.g., getShape() method  
15.	s.draw();  
16.	}  
17.	}  
Test it Now
drawing circle

Another example of Abstract class in java
File: TestBank.java
1.	abstract class Bank{    
2.	abstract int getRateOfInterest();    
3.	}    
4.	class SBI extends Bank{    
5.	int getRateOfInterest(){return 7;}    
6.	}    
7.	class PNB extends Bank{    
8.	int getRateOfInterest(){return 8;}    
9.	}    
10.	    
11.	class TestBank{    
12.	public static void main(String args[]){    
13.	Bank b;  
14.	b=new SBI();  
15.	System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
16.	b=new PNB();  
17.	System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
18.	}}    
Test it Now
Rate of Interest is: 7 %
Rate of Interest is: 8 %

- Abstract class having constructor, data member and methods

An abstract class can have a data member, abstract method, method body (non-abstract method), constructor, and even main() method.
File: TestAbstraction2.java
1.	//Example of an abstract class that has abstract and non-abstract methods  
2.	 abstract class Bike{  
3.	   Bike(){System.out.println("bike is created");}  
4.	   abstract void run();  
5.	   void changeGear(){System.out.println("gear changed");}  
6.	 }  
7.	//Creating a Child class which inherits Abstract class  
8.	 class Honda extends Bike{  
9.	 void run(){System.out.println("running safely..");}  
10.	 }  
11.	//Creating a Test class which calls abstract and non-abstract methods  
12.	 class TestAbstraction2{  
13.	 public static void main(String args[]){  
14.	  Bike obj = new Honda();  
15.	  obj.run();  
16.	  obj.changeGear();  
17.	 }  
18.	}  
Test it Now
       bike is created
       running safely..
       gear changed

Rule: If there is an abstract method in a class, that class must be abstract.
1.	class Bike12{  
2.	abstract void run();  
3.	}  
Test it Now
compile time error

Rule: If you are extending an abstract class that has an abstract method, you must either provide the implementation of the method or make this class abstract.

- Another real scenario of abstract class
  
The abstract class can also be used to provide some implementation of the interface. In such case, the end user may not be forced to override all the methods of the interface.

Note: If you are beginner to java, learn interface first and skip this example.

1.	interface A{  
2.	void a();  
3.	void b();  
4.	void c();  
5.	void d();  
6.	}  
7.	  
8.	abstract class B implements A{  
9.	public void c(){System.out.println("I am c");}  
10.	}  
11.	  
12.	class M extends B{  
13.	public void a(){System.out.println("I am a");}  
14.	public void b(){System.out.println("I am b");}  
15.	public void d(){System.out.println("I am d");}  
16.	}  
17.	  
18.	class Test5{  
19.	public static void main(String args[]){  
20.	A a=new M();  
21.	a.a();  
22.	a.b();  
23.	a.c();  
24.	a.d();  
25.	}}  
Test it Now
Output:I am a
       I am b
       I am c
       I am d
</details>
<details><summary><b>[50 - Interface in Java]</b></summary>

#### Interface in Java
1.	Interface
2.	Example of Interface
3.	Multiple inheritance by Interface
4.	Why multiple inheritance is supported in Interface while it is not supported in case of class.
5.	Marker Interface
6.	Nested Interface

Using the keyword interface, you can fully abstract a class’ interface from its implementation.

That is, using interface, you can specify what a class must do, but not how it does it. Interfaces are syntactically similar to classes, but they lack instance variables, and their methods are declared without any body. In practice, this means that you can define interfaces that don’t make assumptions about how they are implemented. Once it is defined, any number of classes can implement an interface. Also, one class can implement any number of interfaces.

To implement an interface, a class must create the complete set of methods defined by the interface. However, each class is free to determine the details of its own implementation.

By providing the interface keyword, Java allows you to fully utilize the “one interface, multiple methods” aspect of polymorphism.

Interfaces are designed to support dynamic method resolution at run time. Normally, in order for a method to be called from one class to another, both classes need to be present at compile time so the Java compiler can check to ensure that the method signatures are compatible.

NOTE:  Interfaces add most of the functionality that is required for many applications that would normally resort to using multiple inheritance in a language such as C++.

An interface in Java is a blueprint of a class. It has static constants and abstract methods.

The interface in Java is a mechanism to achieve abstraction. There can be only abstract methods in the Java interface, not method body. It is used to achieve abstraction and multiple inheritance in Java.

In other words, you can say that interfaces can have abstract methods and variables. It cannot have a method body.

Java Interface also represents the IS-A relationship.

It cannot be instantiated just like the abstract class.

Since Java 8, we can have default and static methods in an interface.

Since Java 9, we can have private methods in an interface.


<details><summary><b>[50.1 - Why use Java interface?]</b></summary>

 ### Why use Java interface?
There are mainly three reasons to use interface. They are given below.
o	It is used to achieve abstraction.
o	By interface, we can support the functionality of multiple inheritance.
o	It can be used to achieve loose coupling.
 
#### How to declare an interface?
An interface is declared by using the interface keyword. It provides total abstraction; means all the methods in an interface are declared with the empty body, and all the fields are public, static and final by default. A class that implements an interface must implement all the methods declared in the interface.
Syntax:
1.	interface <interface_name>{  
2.	      
3.	    // declare constant fields  
4.	    // declare methods that abstract   
5.	    // by default.  
6.	}  

#### The relationship between classes and interfaces
As shown in the figure given below, a class extends another class, an interface extends another interface, but a class implements an interface.

Java Interface Example
In this example, the Printable interface has only one method, and its implementation is provided in the A6 class.
1.	interface printable{  
2.	void print();  
3.	}  
4.	class A6 implements printable{  
5.	public void print(){System.out.println("Hello");}  
6.	  
7.	public static void main(String args[]){  
8.	A6 obj = new A6();  
9.	obj.print();  
10.	 }  
11.	}  
Test it Now
Output:
Hello

Java Interface Example: Drawable

In this example, the Drawable interface has only one method. Its implementation is provided by Rectangle and Circle classes. In a real scenario, an interface is defined by someone else, but its implementation is provided by different implementation providers. Moreover, it is used by someone else. The implementation part is hidden by the user who uses the interface.

File: TestInterface1.java
1.	//Interface declaration: by first user  
2.	interface Drawable{  
3.	void draw();  
4.	}  
5.	//Implementation: by second user  
6.	class Rectangle implements Drawable{  
7.	public void draw(){System.out.println("drawing rectangle");}  
8.	}  
9.	class Circle implements Drawable{  
10.	public void draw(){System.out.println("drawing circle");}  
11.	}  
12.	//Using interface: by third user  
13.	class TestInterface1{  
14.	public static void main(String args[]){  
15.	Drawable d=new Circle();//In real scenario, object is provided by method e.g. getDrawable()  
16.	d.draw();  
17.	}}  
Test it Now
Output:
drawing circle

Java Interface Example: Bank

Let's see another example of java interface which provides the implementation of Bank interface.

File: TestInterface2.java
1.	interface Bank{  
2.	float rateOfInterest();  
3.	}  
4.	class SBI implements Bank{  
5.	public float rateOfInterest(){return 9.15f;}  
6.	}  
7.	class PNB implements Bank{  
8.	public float rateOfInterest(){return 9.7f;}  
9.	}  
10.	class TestInterface2{  
11.	public static void main(String[] args){  
12.	Bank b=new SBI();  
13.	System.out.println("ROI: "+b.rateOfInterest());  
14.	}}  
Test it Now
Output:
ROI: 9.15

#### Multiple inheritance in Java by interface
If a class implements multiple interfaces, or an interface extends multiple interfaces, it is known as multiple inheritance.
 
1.	interface Printable{  
2.	void print();  
3.	}  
4.	interface Showable{  
5.	void show();  
6.	}  
7.	class A7 implements Printable,Showable{  
8.	public void print(){System.out.println("Hello");}  
9.	public void show(){System.out.println("Welcome");}  
10.	  
11.	public static void main(String args[]){  
12.	A7 obj = new A7();  
13.	obj.print();  
14.	obj.show();  
15.	 }  
16.	}  
Test it Now
Output:Hello
       Welcome
</details>
<details><summary><b>[51.1 - Multiple inheritance is not supported through class in java, but it is possible by an interface, why?]</b></summary>

#### Q) Multiple inheritance is not supported through class in java, but it is possible by an interface, why?
As we have explained in the inheritance chapter, multiple inheritance is not supported in the case of class because of ambiguity. However, it is supported in case of an interface because there is no ambiguity. It is because its implementation is provided by the implementation class. For example:
1.	interface Printable{  
2.	void print();  
3.	}  
4.	interface Showable{  
5.	void print();  
6.	}  
7.	  
8.	class TestInterface3 implements Printable, Showable{  
9.	public void print(){System.out.println("Hello");}  
10.	public static void main(String args[]){  
11.	TestInterface3 obj = new TestInterface3();  
12.	obj.print();  
13.	 }  
14.	}  
Test it Now
Output:
Hello

As you can see in the above example, Printable and Showable interface have same methods but its implementation is provided by class TestTnterface1, so there is no ambiguity.

Interface inheritance

A class implements an interface, but one interface extends another interface.
1.	interface Printable{  
2.	void print();  
3.	}  
4.	interface Showable extends Printable{  
5.	void show();  
6.	}  
7.	class TestInterface4 implements Showable{  
8.	public void print(){System.out.println("Hello");}  
9.	public void show(){System.out.println("Welcome");}  
10.	  
11.	public static void main(String args[]){  
12.	TestInterface4 obj = new TestInterface4();  
13.	obj.print();  
14.	obj.show();  
15.	 }  
16.	}  
Test it Now
Output:
Hello
Welcome
</details>
</details>
<details><summary><b>[51 - Java 8 Interface Improvement]</b></summary>

#### Java 8 Interface Improvement
Since Java 8, interface can have default and static methods which is discussed later.
Internal addition by the compiler
The Java compiler adds public and abstract keywords before the interface method. Moreover, it adds public, static and final keywords before data members.
In other words, Interface fields are public, static and final by default, and the methods are public and abstract.
</details>
<details><summary><b>[025 - Internal addition by the compiler]</b></summary>
</details>

<details><summary><b>[52 - Java 8 Default Method in Interface]</b></summary>

#### Java 8 Default Method in Interface
Since Java 8, we can have method body in interface. But we need to make it default method. Let's see an example:
File: TestInterfaceDefault.java
1.	interface Drawable{  
2.	void draw();  
3.	default void msg(){System.out.println("default method");}  
4.	}  
5.	class Rectangle implements Drawable{  
6.	public void draw(){System.out.println("drawing rectangle");}  
7.	}  
8.	class TestInterfaceDefault{  
9.	public static void main(String args[]){  
10.	Drawable d=new Rectangle();  
11.	d.draw();  
12.	d.msg();  
13.	}}  
Test it Now
Output:
drawing rectangle
default method
</details>
<details><summary><b>[53 - Java 8 Static Method in Interface]</b></summary>

#### Java 8 Static Method in Interface
Since Java 8, we can have static method in interface. Let's see an example:
File: TestInterfaceStatic.java
1.	interface Drawable{  
2.	void draw();  
3.	static int cube(int x){return x*x*x;}  
4.	}  
5.	class Rectangle implements Drawable{  
6.	public void draw(){System.out.println("drawing rectangle");}  
7.	}  
8.	  
9.	class TestInterfaceStatic{  
10.	public static void main(String args[]){  
11.	Drawable d=new Rectangle();  
12.	d.draw();  
13.	System.out.println(Drawable.cube(3));  
14.	}}  
Test it Now
Output:
drawing rectangle
27
</details>
<details><summary><b>[54 - What is marker or tagged interface?]</b></summary>

 #### Q) What is marker or tagged interface?
An interface which has no member is known as a marker or tagged interface, for example, Serializable, Cloneable, Remote, etc. They are used to provide some essential information to the JVM so that JVM may perform some useful operation.
1.	//How Serializable interface is written?  
2.	public interface Serializable{  
3.	}  
________________________________________
#### Nested Interface in Java
Note: An interface can have another interface which is known as a nested interface. We will learn it in detail in the nested classes chapter. For example:
1.	interface printable{  
2.	 void print();  
3.	 interface MessagePrintable{  
4.	   void msg();  
5.	 }  
6.	}  
#### Java Nested Interface
An interface i.e. declared within another interface or class is known as nested interface. The nested interfaces are used to group related interfaces so that they can be easy to maintain. The nested interface must be referred by the outer interface or class. It can't be accessed directly.

Points to remember for nested interfaces

There are given some points that should be remembered by the java programmer.

o	Nested interface must be public if it is declared inside the interface but it can have any access modifier if declared within the class.
o	Nested interfaces are declared static implicitely.
Syntax of nested interface which is declared within the interface
1.	interface interface_name{  
2.	 ...  
3.	 interface nested_interface_name{  
4.	  ...  
5.	 }  
6.	}   

Syntax of nested interface which is declared within the class

1.	class class_name{  
2.	 ...  
3.	 interface nested_interface_name{  
4.	  ...  
5.	 }  
6.	}   

Example of nested interface which is declared within the interface

In this example, we are going to learn how to declare the nested interface and how we can access it.
1.	interface Showable{  
2.	  void show();  
3.	  interface Message{  
4.	   void msg();  
5.	  }  
6.	}  
7.	class TestNestedInterface1 implements Showable.Message{  
8.	 public void msg(){System.out.println("Hello nested interface");}  
9.	  
10.	 public static void main(String args[]){  
11.	  Showable.Message message=new TestNestedInterface1();//upcasting here  
12.	  message.msg();  
13.	 }  
14.	}  
Test it Now
download the example of nested interface
Output:hello nested interface

As you can see in the above example, we are acessing the Message interface by its outer interface Showable because it cannot be accessed directly. It is just like almirah inside the room, we cannot access the almirah directly because we must enter the room first. In collection frameword, sun microsystem has provided a nested interface Entry. Entry is the subinterface of Map i.e. accessed by Map.Entry.

Internal code generated by the java compiler for nested interface Message

The java compiler internally creates public and static interface as displayed below:.

1.	public static interface Showable$Message  
2.	{  
3.	  public abstract void msg();  
4.	}  

Example of nested interface which is declared within the class

Let's see how can we define an interface inside the class and how can we access it.
1.	class A{  
2.	  interface Message{  
3.	   void msg();  
4.	  }  
5.	}  
6.	  
7.	class TestNestedInterface2 implements A.Message{  
8.	 public void msg(){System.out.println("Hello nested interface");}  
9.	  
10.	 public static void main(String args[]){  
11.	  A.Message message=new TestNestedInterface2();//upcasting here  
12.	  message.msg();  
13.	 }  
14.	}  
Test it Now
Output:hello nested interface

</details>
<details><summary><b>[55 - Can we define a class inside the interface?]</b></summary>
	
#### Can we define a class inside the interface?
Yes, If we define a class inside the interface, java compiler creates a static nested class. Let's see how can we define a class within the interface:
1.	interface M{  
2.	  class A{}  
3.	}  
</details>
<details><summary><b>[56 - Difference between abstract class and interface]</b></summary>

#### Difference between abstract class and interface
Abstract class and interface both are used to achieve abstraction where we can declare the abstract methods. Abstract class and interface both can't be instantiated.
But there are many differences between abstract class and interface that are given below.
Abstract class	Interface
1) Abstract class can have abstract and non-abstract methods.	Interface can have only abstract methods. 
Since Java 8, it can have default and static methods 
also.
2) Abstract class doesn't support multiple inheritance.	Interface supports multiple inheritance.
3) Abstract class can have final, non-final, static and non-static variables.	Interface has only static and final variables.
4) Abstract class can provide the implementation of interface.	Interface can't provide the implementation 
of abstract class.
5) The abstract keyword is used to declare abstract class.	The interface keyword is used to declare interface.
6) An abstract class can extend another Java class and implement multiple Java interfaces.	An interface can extend another Java interface only.
7) An abstract class can be extended using keyword "extends".	An interface can be implemented using 
keyword "implements".
8) A Java abstract class can have class members like private, protected, etc.	Members of a Java interface are public by default.
9)Example:
public abstract class Shape{
public abstract void draw();
}	Example:
public interface Drawable{
void draw();
}
Simply, abstract class achieves partial abstraction (0 to 100%) whereas interface achieves fully abstraction (100%).
Example of abstract class and interface in Java
Let's see a simple example where we are using interface and abstract class both.
1.	//Creating interface that has 4 methods  
2.	interface A{  
3.	void a();//bydefault, public and abstract  
4.	void b();  
5.	void c();  
6.	void d();  
7.	}  
8.	  
9.	//Creating abstract class that provides the implementation of one method of A interface  
10.	abstract class B implements A{  
11.	public void c(){System.out.println("I am C");}  
12.	}  
13.	  
14.	//Creating subclass of abstract class, now we need to provide the implementation of rest of the methods  
15.	class M extends B{  
16.	public void a(){System.out.println("I am a");}  
17.	public void b(){System.out.println("I am b");}  
18.	public void d(){System.out.println("I am d");}  
19.	}  
20.	  
21.	//Creating a test class that calls the methods of A interface  
22.	class Test5{  
23.	public static void main(String args[]){  
24.	A a=new M();  
25.	a.a();  
26.	a.b();  
27.	a.c();  
28.	a.d();  
29.	}}  
Test it Now
Output:
       I am a
       I am b
       I am c
       I am d

</details>
<details><summary><b>[57 - Java instanceof]</b></summary>

 #### Java instanceof
1.	java instanceof
2.	Example of instanceof operator
3.	Applying the instanceof operator with a variable the have null value
4.	Downcasting with instanceof operator
5.	Downcasting without instanceof operator
The java instanceof operator is used to test whether the object is an instance of the specified type (class or subclass or interface).
The instanceof in java is also known as type comparison operator because it compares the instance with type. It returns either true or false. If we apply the instanceof operator with any variable that has null value, it returns false.
Simple example of java instanceof
Let's see the simple example of instance operator where it tests the current class.
1.	class Simple1{  
2.	 public static void main(String args[]){  
3.	 Simple1 s=new Simple1();  
4.	 System.out.println(s instanceof Simple1);//true  
5.	 }  
6.	}  
Test it Now
Output:true
________________________________________
An object of subclass type is also a type of parent class. For example, if Dog extends Animal then object of Dog can be referred by either Dog or Animal class.
Another example of java instanceof operator
1.	class Animal{}  
2.	class Dog1 extends Animal{//Dog inherits Animal  
3.	  
4.	 public static void main(String args[]){  
5.	 Dog1 d=new Dog1();  
6.	 System.out.println(d instanceof Animal);//true  
7.	 }  
8.	}  
Test it Now
Output:true
________________________________________
instanceof in java with a variable that have null value
If we apply instanceof operator with a variable that have null value, it returns false. Let's see the example given below where we apply instanceof operator with the variable that have null value.
1.	class Dog2{  
2.	 public static void main(String args[]){  
3.	  Dog2 d=null;  
4.	  System.out.println(d instanceof Dog2);//false  
5.	 }  
6.	}  
Test it Now
Output:false
<details><summary><b>[006 - Downcasting]</b></summary>

- Downcasting with java instanceof operator
When Subclass type refers to the object of Parent class, it is known as downcasting. If we perform it directly, compiler gives Compilation error. If you perform it by typecasting, ClassCastException is thrown at runtime. But if we use instanceof operator, downcasting is possible.
1.	Dog d=new Animal();//Compilation error  
If we perform downcasting by typecasting, ClassCastException is thrown at runtime.
1.	Dog d=(Dog)new Animal();  
2.	//Compiles successfully but ClassCastException is thrown at runtime  
Possibility of downcasting with instanceof
Let's see the example, where downcasting is possible by instanceof operator.
1.	class Animal { }  
2.	  
3.	class Dog3 extends Animal {  
4.	  static void method(Animal a) {  
5.	    if(a instanceof Dog3){  
6.	       Dog3 d=(Dog3)a;//downcasting  
7.	       System.out.println("ok downcasting performed");  
8.	    }  
9.	  }  
10.	   
11.	  public static void main (String [] args) {  
12.	    Animal a=new Dog3();  
13.	    Dog3.method(a);  
14.	  }  
15.	    
16.	 }  
Test it Now
Output:ok downcasting performed
________________________________________
- Downcasting without the use of java instanceof
Downcasting can also be performed without the use of instanceof operator as displayed in the following example:
1.	class Animal { }  
2.	class Dog4 extends Animal {  
3.	  static void method(Animal a) {  
4.	       Dog4 d=(Dog4)a;//downcasting  
5.	       System.out.println("ok downcasting performed");  
6.	  }  
7.	   public static void main (String [] args) {  
8.	    Animal a=new Dog4();  
9.	    Dog4.method(a);  
10.	  }  
11.	}  
Test it Now
Output:ok downcasting performed
Let's take closer look at this, actual object that is referred by a, is an object of Dog class. So if we downcast it, it is fine. But what will happen if we write:
1.	Animal a=new Animal();  
2.	Dog.method(a);  
3.	//Now ClassCastException but not in case of instanceof operator
</details>
- Understanding Real use of instanceof in java
Let's see the real use of instanceof keyword by the example given below.
1.	interface Printable{}  
2.	class A implements Printable{  
3.	public void a(){System.out.println("a method");}  
4.	}  
5.	class B implements Printable{  
6.	public void b(){System.out.println("b method");}  
7.	}  
8.	  
9.	class Call{  
10.	void invoke(Printable p){//upcasting  
11.	if(p instanceof A){  
12.	A a=(A)p;//Downcasting   
13.	a.a();  
14.	}  
15.	if(p instanceof B){  
16.	B b=(B)p;//Downcasting   
17.	b.b();  
18.	}  
19.	  
20.	}  
21.	}//end of Call class  
22.	  
23.	class Test4{  
24.	public static void main(String args[]){  
25.	Printable p=new B();  
26.	Call c=new Call();  
27.	c.invoke(p);  
28.	}  
29.	}  
Test it Now
Output: b method
</details>

<details><summary><b>[58 - Covariant Return Type]</b></summary>

#### Covariant Return Type
The covariant return type specifies that the return type may vary in the same direction as the subclass.
Before Java5, it was not possible to override any method by changing the return type. But now, since Java5, it is possible to override method by changing the return type if subclass overrides any method whose return type is Non-Primitive but it changes its return type to subclass type. Let's take a simple example:
Note: If you are beginner to java, skip this topic and return to it after OOPs concepts.
________________________________________
Simple example of Covariant Return Type
1.	class A{  
2.	A get(){return this;}  
3.	}  
4.	  
5.	class B1 extends A{  
6.	B1 get(){return this;}  
7.	void message(){System.out.println("welcome to covariant return type");}  
8.	  
9.	public static void main(String args[]){  
10.	new B1().get().message();  
11.	}  
12.	}  
Test it Now
Output:welcome to covariant return type
As you can see in the above example, the return type of the get() method of A class is A but the return type of the get() method of B class is B. Both methods have different return type but it is method overriding. This is known as covariant return type.


<details><summary><b>[58.1 - How is Covariant return types implemented?]</b></summary>

#### How is Covariant return types implemented?
Java doesn't allow the return type based overloading but JVM always allows return type based overloading. JVM uses full signature of a method for lookup/resolution. Full signature means it includes return type in addition to argument types. i.e., a class can have two or more methods differing only by return type. javac uses this fact to implement covariant return types.
</details>
</details>
<details><summary><b>[60 - Why use instance initializer block?]</b></summary>

 #### Instance initializer block
1.	Instance initializer block
2.	Example of Instance initializer block
3.	What is invoked firstly instance initializer block or constructor?
4.	Rules for instance initializer block
5.	Program of instance initializer block that is invoked after super()
Instance Initializer block is used to initialize the instance data member. 
It run each time when object of the class is created.
The initialization of the instance variable can be done directly but there can be performed extra operations while initializing the instance variable in the instance initializer block.
Que) What is the use of instance initializer block while we can directly assign a value in instance data member? For example:
1.	class Bike{  
2.	    int speed=100;  
3.	}  
#### Why use instance initializer block?
Suppose I have to perform some operations while assigning value to instance data member 
e.g. a for loop to fill a complex array or error handling etc.
________________________________________
Example of instance initializer block
Let's see the simple example of instance initializer block that performs initialization.
1.	class Bike7{  
2.	    int speed;  
3.	      
4.	    Bike7(){System.out.println("speed is "+speed);}  
5.	   
6.	    {speed=100;}  
7.	       
8.	    public static void main(String args[]){  
9.	    Bike7 b1=new Bike7();  
10.	    Bike7 b2=new Bike7();  
11.	    }      
12.	}  
Test it Now
Output:speed is 100
       speed is 100
 
There are three places in java where you can perform operations:
1.	method
2.	constructor
3.	block
<details><summary><b>[60.1 - What is invoked first, instance initializer block or constructor?]</b></summary>

#### What is invoked first, instance initializer block or constructor?
1.	class Bike8{  
2.	    int speed;  
3.	      
4.	    Bike8(){System.out.println("constructor is invoked");}  
5.	   
6.	    {System.out.println("instance initializer block invoked");}  
7.	       
8.	    public static void main(String args[]){  
9.	    Bike8 b1=new Bike8();  
10.	    Bike8 b2=new Bike8();  
11.	    }      
12.	}  
Test it Now
Output:instance initializer block invoked
       constructor is invoked
       instance initializer block invoked
       constructor is invoked

In the above example, it seems that instance initializer block is firstly invoked but NO. Instance intializer block is invoked at the time of object creation. The java compiler copies the instance initializer block in the constructor after the first statement super(). So firstly, constructor is invoked. Let's understand it by the figure given below:
Note: The java compiler copies the code of instance initializer block in every constructor.
</details>
- Rules for instance initializer block :
There are mainly three rules for the instance initializer block. They are as follows:
1.	The instance initializer block is created when instance of the class is created.
2.	The instance initializer block is invoked after the parent class constructor is invoked (i.e. after super() constructor call).
3.	The instance initializer block comes in the order in which they appear.
Program of instance initializer block that is invoked after super()
1.	class A{  
2.	A(){  
3.	System.out.println("parent class constructor invoked");  
4.	}  
5.	}  
6.	class B2 extends A{  
7.	B2(){  
8.	super();  
9.	System.out.println("child class constructor invoked");  
10.	}  
11.	  
12.	{System.out.println("instance initializer block is invoked");}  
13.	  
14.	public static void main(String args[]){  
15.	B2 b=new B2();  
16.	}  
17.	}  
Test it Now
Output:parent class constructor invoked
       instance initializer block is invoked
       child class constructor invoked
________________________________________
Another example of instance block
1.	class A{  
2.	A(){  
3.	System.out.println("parent class constructor invoked");  
4.	}  
5.	}  
6.	  
7.	class B3 extends A{  
8.	B3(){  
9.	super();  
10.	System.out.println("child class constructor invoked");  
11.	}  
12.	  
13.	B3(int a){  
14.	super();  
15.	System.out.println("child class constructor invoked "+a);  
16.	}  
17.	  
18.	{System.out.println("instance initializer block is invoked");}  
19.	  
20.	public static void main(String args[]){  
21.	B3 b1=new B3();  
22.	B3 b2=new B3(10);  
23.	}  
24.	}  
Test it Now
Output:parent class constructor invoked
       instance initializer block is invoked
       child class constructor invoked
       parent class constructor invoked
       instance initializer block is invoked
       child class constructor invoked 10
</details>

<details><summary><b>[61 - Java Package]</b></summary>

 #### Java Package
1.	Java Package
2.	Example of package
3.	Accessing package
1)	By import packagename.*
2)	By import packagename.classname
3)	By fully qualified name
4.	Subpackage
5.	Sending class file to another directory
6.	-classpath switch
7.	4 ways to load the class file or jar file
8.	How to put two public class in a package
9.	Static Import
10.	Package class
A java package is a group of similar types of classes, interfaces and sub-packages.
Package in java can be categorized in two form, built-in package and user-defined package.
There are many built-in packages such as java, lang, awt, javax, swing, net, io, util, sql etc.
Here, we will have the detailed learning of creating and using user-defined packages.
- Advantage of Java Package
1) Java package is used to categorize the classes and interfaces so that they can be easily maintained.
2) Java package provides access protection.
3) Java package removes naming collision.
 
________________________________________
Simple example of java package
The package keyword is used to create a package in java.
1.	//save as Simple.java  
2.	package mypack;  
3.	public class Simple{  
4.	 public static void main(String args[]){  
5.	    System.out.println("Welcome to package");  
6.	   }  
7.	}  
How to compile java package
If you are not using any IDE, you need to follow the syntax given below:
1.	javac -d directory javafilename  
For example
1.	javac -d . Simple.java  
The -d switch specifies the destination where to put the generated class file. You can use any directory name like /home (in case of Linux), d:/abc (in case of windows) etc. If you want to keep the package within the same directory, you can use . (dot).
________________________________________
How to run java package program
You need to use fully qualified name e.g. mypack.Simple etc to run the class.
________________________________________
To Compile: javac -d . Simple.java
To Run: java mypack.Simple
Output:Welcome to package
The -d is a switch that tells the compiler where to put the class file i.e. it represents destination. 
The . represents the current folder.
________________________________________
#### How to access package from another package?
There are three ways to access the package from outside the package.
1.	import package.*;
2.	import package.classname;
3.	fully qualified name.
1) Using packagename.*
If you use package.* then all the classes and interfaces of this package will be accessible but not subpackages.
The import keyword is used to make the classes and interface of another package accessible to the current package.
Example of package that import the packagename.*
1.	//save by A.java  
2.	package pack;  
3.	public class A{  
4.	  public void msg(){System.out.println("Hello");}  
5.	}  
1.	//save by B.java  
2.	package mypack;  
3.	import pack.*;  
4.	  
5.	class B{  
6.	  public static void main(String args[]){  
7.	   A obj = new A();  
8.	   obj.msg();  
9.	  }  
10.	}  
Output:Hello
________________________________________
2) Using packagename.classname
If you import package.classname then only declared class of this package will be accessible.
Example of package by import package.classname
1.	//save by A.java  
2.	  
3.	package pack;  
4.	public class A{  
5.	  public void msg(){System.out.println("Hello");}  
6.	}  
1.	//save by B.java  
2.	package mypack;  
3.	import pack.A;  
4.	  
5.	class B{  
6.	  public static void main(String args[]){  
7.	   A obj = new A();  
8.	   obj.msg();  
9.	  }  
10.	}  
Output:Hello
________________________________________
3) Using fully qualified name
If you use fully qualified name then only declared class of this package will be accessible. Now there is no need to import. But you need to use fully qualified name every time when you are accessing the class or interface.
It is generally used when two packages have same class name e.g. java.util and java.sql packages contain Date class.
Example of package by import fully qualified name
1.	//save by A.java  
2.	package pack;  
3.	public class A{  
4.	  public void msg(){System.out.println("Hello");}  
5.	}  
1.	//save by B.java  
2.	package mypack;  
3.	class B{  
4.	  public static void main(String args[]){  
5.	   pack.A obj = new pack.A();//using fully qualified name  
6.	   obj.msg();  
7.	  }  
8.	}  
Output:Hello
Note: If you import a package, subpackages will not be imported.
If you import a package, all the classes and interface of that package will be imported excluding the classes and interfaces of the subpackages. Hence, you need to import the subpackage as well.

Note: Sequence of the program must be package then import then class.

<details><summary><b>[61.1 - Subpackage in java]</b></summary>

#### Subpackage in java
Package inside the package is called the subpackage. It should be created to categorize the package further.
Let's take an example, Sun Microsystem has definded a package named java that contains many classes like System, String, Reader, Writer, Socket etc. These classes represent a particular group e.g. Reader and Writer classes are for Input/Output operation, Socket and ServerSocket classes are for networking etc and so on. So, Sun has subcategorized the java package into subpackages such as lang, net, io etc. and put the Input/Output related classes in io package, Server and ServerSocket classes in net packages and so on.
The standard of defining package is domain.company.package e.g. com.javatpoint.bean or org.sssit.dao.
Example of Subpackage
1.	package com.javatpoint.core;  
2.	class Simple{  
3.	  public static void main(String args[]){  
4.	   System.out.println("Hello subpackage");  
5.	  }  
6.	}  
To Compile: javac -d . Simple.java
To Run: java com.javatpoint.core.Simple
Output:Hello subpackage

How to send the class file to another directory or drive?
There is a scenario, I want to put the class file of A.java source file in classes folder of c: drive. For example:
 
1.	//save as Simple.java  
2.	package mypack;  
3.	public class Simple{  
4.	 public static void main(String args[]){  
5.	    System.out.println("Welcome to package");  
6.	   }  
7.	}  
To Compile:
e:\sources> javac -d c:\classes Simple.java
To Run:
To run this program from e:\source directory, you need to set classpath of the directory 
where the class file resides.
e:\sources> set classpath=c:\classes;.;
e:\sources> java mypack.Simple
Another way to run this program by -classpath switch of java:
The -classpath switch can be used with javac and java tool.
To run this program from e:\source directory, you can use -classpath switch of java that tells where to look for class file. For example:
e:\sources> java -classpath c:\classes mypack.Simple
Output:Welcome to package

Ways to load the class files or jar files
There are two ways to load the class files temporary and permanent.
o	Temporary
o	By setting the classpath in the command prompt
o	By -classpath switch
o	Permanent
o	By setting the classpath in the environment variables
o	By creating the jar file, that contains all the class files, and copying the jar file in the jre/lib/ext folder.

Rule: There can be only one public class in a java source file and it must be saved by the public class name.
1.	//save as C.java otherwise Compilte Time Error  
2.	  
3.	class A{}  
4.	class B{}  
5.	public class C{}  
</details>
<details><summary><b>[61.2 - How to send the class file to another directory or drive?]</b></summary>

 
</details>
<details><summary><b>[61.3 - How to put two public classes in a package?]</b></summary>
	
#### How to put two public classes in a package?
If you want to put two public classes in a package, have two java source files containing one public class, but keep the package name same. For example:
1.	//save as A.java  
2.	  
3.	package javatpoint;  
4.	public class A{}  
1.	//save as B.java  
2.	  
3.	package javatpoint;  
4.	public class B{} 
</details>
</details>
<details><summary><b>[65 - What is static import feature of Java5?]</b></summary>
	
#### What is static import feature of Java5?
Click Static Import feature of Java5.
</details>

<details><summary><b>[66 - Java Thread]</b></summary>

#### Java Thread
Thread is an independent sequential path of execution within a program. It’s a smallest unit of dispatchble code. Java provides built-in support for multithreaded programming. A multithreaded program contains two or more parts that can run concurrently. Each part of such a program is called a thread, and each thread defines a separate path of execution. Thus, multithreading is a specialized form of multitasking.

There are two distinct types of multitasking: process-based and thread-based. It is important to understand the difference between the two. For most readers, process-based multitasking is the more familiar form. 

A process is, in essence, a program that is executing.Thus, process-based multitasking is the feature that allows your computer to run two or more programs concurrently. For example, process-based multitasking enables you to run the Java compiler at the same time that you are using a text editor. In process-based multitasking, a program is the smallest unit of code that can be dispatched by the scheduler. 

In a thread-based multitasking environment, the thread is the smallest unit of dispatchable code. This means that a single program can perform two or more tasks simultaneously. For instance, a text editor can format text at the same time that it is printing, as long as these two actions are being performed by two separate threads. Thus, process-based multitasking deals with the “big picture,” and thread-based multitasking handles the details.

Multitasking threads require less overhead than multitasking processes. 

Processes are heavyweight tasks that require their own separate address spaces. Interprocess communication is expensive and limited. Context switching from one process to another is also costly. 

Threads, on the other hand, are lightweight. They share the same address space and cooperatively share the same heavyweight process. Interthread communication is inexpensive, and context switching from one thread to the next is low cost. 

While Java programs make use of processbased multitasking environments, process-based multitasking is not under the control of Java. However, multithreaded multitasking is.

<details><summary><b>[66.1 - The Java Thread Model]</b></summary>
	
#### The Java Thread Model
The Java run-time system depends on threads for many things, and all the class libraries are designed with multithreading in mind. In fact, Java uses threads to enable the entire environment to be asynchronous. This helps reduce inefficiency by preventing the waste of CPU cycles. 

The value of a multithreaded environment is best understood in contrast to its counterpart. Single-threaded systems use an approach called an event loop with polling. In this model, a single thread of control runs in an infinite loop, polling a single event queue to decide what to do next. Once this polling mechanism returns with, say, a signal that a network file is ready to be read, then the event loop dispatches control to the appropriate event handler. Until this event handler returns, nothing else can happen in the system. This wastes CPU time. It can also result in one part of a program dominating the system and preventing any other events from being processed. In general, in a singled-threaded environment, when a thread blocks (that is, suspends execution) because it is waiting for some resource, the entire program stops running.

The benefit of Java’s multithreading is that the main loop/polling mechanism is eliminated. One thread can pause without stopping other parts of your program. For example, the idle time created when a thread reads data from a network or waits for user input can be utilized elsewhere. Multithreading allows animation loops to sleep for a second between each frame without causing the whole system to pause. When a thread blocks in a Java program, only the single thread that is blocked pauses. All other threads continue to run. 

Threads exist in several states. A thread can be running. It can be ready to run as soon as it gets CPU time. A running thread can be suspended, which temporarily suspends its activity. A suspended thread can then be resumed, allowing it to pick up where it left off. A thread can be blocked when waiting for a resource. At any time, a thread can be terminated, which halts its execution immediately. Once terminated, a thread cannot be resumed.

</details>
<details><summary><b>[66.2 - Thread Priorities]</b></summary>
	
#### Thread Priorities
Java assigns to each thread a priority that determines how that thread should be treated with respect to the others. Thread priorities are integers that specify the relative priority of one thread to another. As an absolute value, a priority is meaningless; a higher-priority thread doesn’t run any faster than a lower-priority thread if it is the only thread running. Instead, a thread’s priority is used to decide when to switch from one running thread to the next. This is called a context switch. The rules that determine when a context switch takes place are simple:

</details>
<details><summary><b>[66.3 - Java Thread Life Cycle and Thread States]</b></summary>
	
#### Java Thread Life Cycle and Thread States
A java thread can be in any of following thread states during its life cycle i.e. New, Runnable, Blocked, Waiting, Timed Waiting or Terminated. These are also called life cycle events of a thread in java. Let’s understand each state in more detail.
Java Thread Life Cycle States
 
1.	New
As soon as, you create new thread, it’s in NEW state. It remains in this state until the program starts the thread using it’s start() method.
At this point, thread is not alive and it’s a state internal to Java programming.
2.	Runnable
Calling start() method on thread put it in RUNNABLE state. At this point, execution control is passed to thread scheduler to finish its execution. Thread scheduler decide from this point that this thread should be executed (also known as dispatching the thread) or should be put on hold to give chance to other runnable threads.

Thread scheduling is platform dependent — the behavior of a multi-threaded program could vary across different Java implementations.
In most operating systems, each thread is given a small amount of processor time—called a quantum or timeslice—with which to perform its task. A task utilizing its quantum is said to be in RUNNING state. When its quantum expires, the thread returns to the RUNNABLE state, and the operating system assigns another thread to the processor.

The process that an operating system uses to determine which thread to dispatch is called thread scheduling and is dependent on thread priorities.
The operating system hide the RUNNABLE and RUNNING states from the Java Virtual Machine (JVM), which sees only the RUNNABLE state.
 
3.	Blocked
A RUNNABLE thread transitions to the BLOCKED state when it attempts to perform a task that cannot be completed immediately and it must temporarily wait until that task completes.

For example, when a thread issues an input/output request, the operating system blocks the thread from executing until that I/O request completes—at that point, the blocked thread transitions to the RUNNABLE state, so it can resume execution. A blocked thread cannot use a processor, even if one is available.
4.	Waiting
A thread can be put in waiting state for various reasons e.g. calling it’s wait() method. Usually program put a thread in WAIT state because something else needs to be done prior to what current thread is doing.
 
Once the thread wait state is over or it is, its state is changed to RUNNABLE and it’s moved back to thread pool.
5.	Timed Waiting
A RUNNABLE thread can transition to the TIMED WAITING state if it provides an optional wait interval when it’s waiting for another thread to perform a task. You can put a java thread in TIMED WAITING state by calling it’s sleep(long millis) method or wait(long millis) method.

Such a thread returns to the RUNNABLE state when it’s notified by another thread or when the timed interval expires—whichever comes first.

Timed waiting threads and waiting threads cannot use a processor, even if one is available.
6.	Terminated
A thread enters the TERMINATED state (sometimes called the dead state) when it successfully completes its task or otherwise terminated due to any error or even it was forcefully killed.

Please remember that though JVM and OS thread scheduler do their best yet sometimes threads can cause starvation or deadlock. This occurs when a waiting thread (let’s call this thread1) cannot proceed because it’s waiting (either directly or indirectly) for another thread (let’s call this thread2) to proceed, while simultaneously thread2 cannot proceed because it’s waiting (either directly or indirectly) for thread1 to proceed.

</details>
<details><summary><b>[66.4 - Difference between implements Runnable and extends Thread]</b></summary>
	
#### Difference between implements Runnable and extends Thread

Difference between “implements Runnable” and “extends Thread” in java
In java language, as we all know that there are two ways to create threads. One using Runnable interface and another by extending Thread class.
public class DemoRunnable implements Runnable {
    public void run() {
        //Code
    }
}
//with a "new Thread(demoRunnable).start()" call
 
public class DemoThread extends Thread {
    public DemoThread() {
        super("DemoThread");
    }
    public void run() {
        //Code
    }
}
//with a "demoThread.start()" call

There has been a good amount of debate on which is better way. Well, I also tried to find out and below is my learning:

1) Implementing Runnable is the preferred way to do it. Here, you’re not really specializing or modifying the thread’s behavior. You’re just giving the thread something to run. That means composition is the better way to go.
2) Java only supports single inheritance, so you can only extend one class.
3) Instantiating an interface gives a cleaner separation between your code and the implementation of threads.
4)  Implementing Runnable makes your class more flexible. If you extend thread then the action you’re doing is always going to be in a thread. However, if you extend Runnable it doesn’t have to be. You can run it in a thread, or pass it to some kind of executor service, or just pass it around as a task within a single threaded application.
5) By extending Thread, each of your threads has a unique object associated with it, whereas implementing Runnable, many threads can share the same runnable instance.
6) If you are working on JDK 4 or lesser, then there is bug :

http://bugs.java.com/bugdatabase/view_bug.do;jsessionid=5869e03fee226ffffffffc40d4fa881a86e3:WuuT?bug_id=4533087

It’s fixed in Java 1.5 but Sun doesn’t intend to fix it in 1.4.

The issue is that at construction time, a Thread is added to a list of references in an internal thread table. It won’t get removed from that list until its start() method has completed. As long as that reference is there, it won’t get garbage collected.

How to Work With wait(), notify() and notifyAll() in Java?

Multithreading in java is pretty complex topic and requires a lot of attention while writing application code dealing with multiple threads accessing one/more shared resources at any given time. 

Java 5, introduced some classes like BlockingQueue and Executors which take away some of the complexity by providing easy to use APIs. 
Programmers using these classes will feel a lot more confident than programmers directly handling synchronization stuff using wait() and notify() method calls.

I will also recommend to use these newer APIs over synchronization yourself, BUT many times we are required to do so for various reasons e.g. maintaining legacy code. A good knowledge around these methods will help you in such situation when arrived. 
In this tutorial, I am discussing some concepts around methods wait(), notify() and notifyAll().

</details>
<details><summary><b>[66.5 - What are wait(), notify() and notifyAll() methods?]</b></summary>
	
#### What are wait(), notify() and notifyAll() methods?

Before moving into concepts, let’s note down few very basic definitions involved for these methods.
The Object class in Java has three final methods that allow threads to communicate about the locked status of a resource. These are:

1.	wait() : It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify(). The wait() method releases the lock prior to waiting and reacquires the lock prior to returning from the wait() method. 
The wait() method is actually tightly integrated with the synchronization lock, using a feature not available directly from the synchronization mechanism. In other words, it is not possible for us to implement the wait() method purely in Java: it is a native method.
General syntax for calling wait() method is like this:
synchronized( lockObject )
{ 
    while( ! condition )
    { 
        lockObject.wait();
    }
     
    //take the action here;
}
2.	notify() : It wakes up one single thread that called wait() on the same object. It should be noted that calling notify() does not actually give up a lock on a resource. It tells a waiting thread that that thread can wake up. However, the lock is not actually given up until the notifier’s synchronized block has completed. So, if a notifier calls notify() on a resource but the notifier still needs to perform 10 seconds of actions on the resource within its synchronized block, the thread that had been waiting will need to wait at least another additional 10 seconds for the notifier to release the lock on the object, even though notify() had been called.

General syntax for calling notify() method is like this:

synchronized(lockObject) 
{
    //establish_the_condition;
 
    lockObject.notify();
     
    //any additional code if needed
}
3.	notifyAll() : It wakes up all the threads that called wait() on the same object. The highest priority thread will run first in most of the situation, though not guaranteed. Other things are same as notify() method above.
General syntax for calling notify() method is like this:

synchronized(lockObject) 
{
    establish_the_condition;
 
    lockObject.notifyAll();
}

In general, a thread that uses the wait() method confirms that a condition does not exist (typically by checking a variable) and then calls the wait() method. When another thread establishes the condition (typically by setting the same variable), it calls the notify() method. The wait-and-notify mechanism does not specify what the specific condition/ variable value is. It is on developer’s hand to specify the condition to be checked before calling wait() or notify().

</details>
<details><summary><b>[66.6 - How to Use with wait(), notify() and notifyAll() Methods]</b></summary>
	
#### How to Use with wait(), notify() and notifyAll() Methods

In this exercise, we will solve  producer consumer problem using wait() and notify() methods. To keep program simple and to keep focus on usage of wait() and notify() methods, we will involve only one producer and one consumer thread.
Other features of the program are :

1) Producer thread produce a new resource in every 1 second and put it in ‘taskQueue’.
2) Consumer thread takes 1 seconds to process consumed resource from ‘taskQueue’.
3) Max capacity of taskQueue is 5 i.e. maximum 5 resources can exist inside ‘taskQueue’ at any given time.
4) Both threads run infinitely.

- Designing Producer Thread

Below is the code for producer thread based on our requirements :

class Producer implements Runnable
{
   private final List<Integer> taskQueue;
   private final int           MAX_CAPACITY;
 
   public Producer(List<Integer> sharedQueue, int size)
   {
      this.taskQueue = sharedQueue;
      this.MAX_CAPACITY = size;
   }
 
   @Override
   public void run()
   {
      int counter = 0;
      while (true)
      {
         try
         {
            produce(counter++);
         } 
         catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
 
   private void produce(int i) throws InterruptedException
   {
      synchronized (taskQueue)
      {
         while (taskQueue.size() == MAX_CAPACITY)
         {
            System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
            taskQueue.wait();
         }
           
         Thread.sleep(1000);
         taskQueue.add(i);
         System.out.println("Produced: " + i);
         taskQueue.notifyAll();
      }
   }
}
1) Here “produce(counter++)” code has been written inside infinite loop so that producer keeps producing elements at regular interval.
2) We have written the produce() method code following the general guideline to write wait() method as mentioned in first section.
3) Once the wait() is over, producer add an element in taskQueue and called notifyAll() method. Because the last-time wait() method was called by consumer thread (that’s why producer is out of waiting state), consumer gets the notification.
4) Consumer thread after getting notification, if ready to consume the element as per written logic.
5) Note that both threads use sleep() methods as well for simulating time delays in creating and consuming elements.

- Designing Consumer Thread
Below is the code for consumer thread based on our requirements :
class Consumer implements Runnable
{
   private final List<Integer> taskQueue;
 
   public Consumer(List<Integer> sharedQueue)
   {
      this.taskQueue = sharedQueue;
   }
 
   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            consume();
         } catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
 
   private void consume() throws InterruptedException
   {
      synchronized (taskQueue)
      {
         while (taskQueue.isEmpty())
         {
            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
            taskQueue.wait();
         }
         Thread.sleep(1000);
         int i = (Integer) taskQueue.remove(0);
         System.out.println("Consumed: " + i);
         taskQueue.notifyAll();
      }
   }
}
1) Here “consume()” code has been written inside infinite loop so that consumer keeps consuming elements whenever it finds something in taskQueue..
2) Once the wait() is over, consumer removes an element in taskQueue and called notifyAll() method. Because the last-time wait() method was called by producer thread (that’s why producer is in waiting state), producer gets the notification.
3) Producer thread after getting notification, if ready to produce the element as per written logic.
   
- Test the Application

Now lets test producer and consumer threads.

public class ProducerConsumerExampleWithWaitAndNotify
{
   public static void main(String[] args)
   {
      List<Integer> taskQueue = new ArrayList<Integer>();
      int MAX_CAPACITY = 5;
      Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
      Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
      tProducer.start();
      tConsumer.start();
   }
}
 
Output:
 
Produced: 0
Consumed: 0
Queue is empty Consumer is waiting , size: 0
Produced: 1
Produced: 2
Consumed: 1
Consumed: 2
Queue is empty Consumer is waiting , size: 0
Produced: 3
Produced: 4
Consumed: 3
Produced: 5
Consumed: 4
Produced: 6
Consumed: 5
Consumed: 6
Queue is empty Consumer is waiting , size: 0
Produced: 7
Consumed: 7
Queue is empty Consumer is waiting , size: 0
I will suggest you to change the time taken by producer and consumer threads to different times, and check the different outputs in different scenario.

</details>
<details><summary><b>[66.7 - What happens when notify() is called and no thread is waiting?]</b></summary>

#### What happens when notify() is called and no thread is waiting?

In general practice, this will not be the case in most scenarios if these methods are used correctly. Though if the notify() method is called when no other thread is waiting, notify() simply returns and the notification is lost.

Since the wait-and-notify mechanism does not know the condition about which it is sending notification, it assumes that a notification goes unheard if no thread is waiting. A thread that later executes the wait() method has to wait for another notification to occur.

Can there be a race condition during the period that the wait() method releases OR reacquires the lock?

The wait() method is tightly integrated with the lock mechanism. The object lock is not actually freed until the waiting thread is already in a state in which it can receive notifications. It means only when thread state is changed such that it is able to receive notifications, lock is held. The system prevents any race conditions from occurring in this mechanism.

Similarly, system ensures that lock should be held by object completely before moving the thread out of waiting state.

If a thread receives a notification, is it guaranteed that the condition is set correctly?

Simply, no. Prior to calling the wait() method, a thread should always test the condition while holding the synchronization lock. Upon returning from the wait() method, the thread should always retest the condition to determine if it should wait again. This is because another thread can also test the condition and determine that a wait is not necessary — processing the valid data that was set by the notification thread.

This is a common case when multiple threads are involved in the notifications. More particularly, the threads that are processing the data can be thought of as consumers; they consume the data produced by other threads. There is no guarantee that when a consumer receives a notification that it has not been processed by another consumer. As such, when a consumer wakes up, it cannot assume that the state it was waiting for is still valid. It may have been valid in the past, but the state may have been changed after the notify() method was called and before the consumer thread woke up. Waiting threads must provide the option to check the state and to return back to a waiting state in case the notification has already been handled. This is why we always put calls to the wait() method in a loop.

</details>
<details><summary><b>[66.8 - What happens when more than one thread is waiting for notification? Which threads actually get the notification when the notify() method is called?]</b></summary>
	
#### What happens when more than one thread is waiting for notification? Which threads actually get the notification when the notify() method is called?
It depends on many factors.Java specification doesn’t define which thread gets notified. In runtime, which thread actually receives the notification varies based on several factors, including the implementation of the Java virtual machine and scheduling and timing issues during the execution of the program. There is no way to determine, even on a single processor platform, which of multiple threads receives the notification.
Just like the notify() method, the notifyAll() method does not allow us to decide which thread gets the notification: they all get notified. When all the threads receive the notification, it is possible to work out a mechanism for the threads to choose among themselves which thread should continue and which thread(s) should call the wait() method again.

</details>
<details><summary><b>[66.9 - Does the notifyAll() method really wake up all the threads?]</b></summary>
	
#### Does the notifyAll() method really wake up all the threads?
Yes and no. All of the waiting threads wake up, but they still have to reacquire the object lock. So the threads do not run in parallel: they must each wait for the object lock to be freed. Thus, only one thread can run at a time, and only after the thread that called the notifyAll() method releases its lock.

</details>
<details><summary><b>[66.10 - Why would you want to wake up all of the threads if only one is going to execute at all?]</b></summary>
	
#### Why would you want to wake up all of the threads if only one is going to execute at all?
There are a few reasons. For example, there might be more than one condition to wait for. Since we cannot control which thread gets the notification, it is entirely possible that a notification wakes up a thread that is waiting for an entirely different condition. By waking up all the threads, we can design the program so that the threads decide among themselves which thread should execute next. Another option could be when producers generate data that can satisfy more than one consumer. Since it may be difficult to determine how many consumers can be satisfied with the notification, an option is to notify them all, allowing the consumers to sort it out among themselves.

</details>
<details><summary><b>[66.11 - Difference between sleep() and wait()?]</b></summary>
	
#### Difference between sleep() and wait()?

sleep() is a method which is used to hold the process for few seconds or the time you wanted but in case of wait() method thread goes in waiting state and it won’t come back automatically until we call the notify() or notifyAll().

The major difference is that wait() releases the lock or monitor while sleep() doesn’t releases any lock or monitor while waiting. Wait is used for inter-thread communication while sleep is used to introduce pause on execution, generally.

Thread.sleep() sends the current thread into the “Not Runnable” state for some amount of time. The thread keeps the monitors it has acquired — i.e. if the thread is currently in a synchronized block or method no other thread can enter this block or method. If another thread calls t.interrupt() it will wake up the sleeping thread. Note that sleep is a static method, which means that it always affects the current thread (the one that is executing the sleep method). A common mistake is to call t.sleep() where t is a different thread; even then, it is the current thread that will sleep, not the t thread.

object.wait() sends the current thread into the “Not Runnable” state, like sleep(), but with a twist. Wait is called on an object, not a thread; we call this object the “lock object.” Before lock.wait() is called, the current thread must synchronize on the lock object; wait() then releases this lock, and adds the thread to the “wait list” associated with the lock. Later, another thread can synchronize on the same lock object and call lock.notify(). This wakes up the original, waiting thread. Basically, wait()/notify() is like sleep()/interrupt(), only the active thread does not need a direct pointer to the sleeping thread, but only to the shared lock object.

synchronized(LOCK) {   
    Thread.sleep(1000); // LOCK is held
}

synchronized(LOCK) {   
    LOCK.wait(); // LOCK is not held
}
Let categorize all above points :
Call on:
•	    wait(): Call on an object; current thread must synchronize on the lock object.
•	    sleep(): Call on a Thread; always currently executing thread.
Synchronized:
•	    wait(): when synchronized multiple threads access same Object one by one.
•	    sleep(): when synchronized multiple threads wait for sleep over of sleeping thread.
Hold lock:
•	    wait(): release the lock for other objects to have chance to execute.
•	    sleep(): keep lock for at least t times if timeout specified or somebody interrupt.
Wake-up condition:
•	    wait(): until call notify(), notifyAll() from object
•	    sleep(): until at least time expire or call interrupt().
Usage:
•	    sleep(): for time-synchronization and;
•	    wait(): for multi-thread-synchronization.

</details>
<details><summary><b>[66.12 - Writing a deadlock and resolving in java]</b></summary>
	
#### Writing a deadlock and resolving in java

In this post, I will write a piece of code which will create a deadlock situation and then I will discuss that way to resolve this scenario.

In my previous post, I written about Auto reload of configuration when any change happen, I discussed about refreshing your application configuration using a thread. As configurations are shared resources and when accessing via Threads, there is always chance of writing incorrect code and caught in deadlock situation.

In java, a deadlock is a situation where minimum two threads are holding lock on some different resource, and both are waiting for other’s resource to complete its task. And, none is able to leave the lock on resource it is holding. (See image below)
 
In above case, Thread- has A but need B to complete processing and Similarly Thread-2 has resource B but need A first.
Let write above scenario in java code:

package thread;
 
public class ResolveDeadLockTest {
 
    public static void main(String[] args) {
        ResolveDeadLockTest test = new ResolveDeadLockTest();
 
        final A a = test.new A();
        final B b = test.new B();
 
        // Thread-1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (a) {
                    try {
                        // Adding delay so that both threads can start trying to
                        // lock resources
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have A but need B also
                    synchronized (b) {
                        System.out.println("In block 1");
                    }
                }
            }
        };
 
        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (b) {
                    // Thread-2 have B but need A also
                    synchronized (a) {
                        System.out.println("In block 2");
                    }
                }
            }
        };
 
        new Thread(block1).start();
        new Thread(block2).start();
    }
 
    // Resource A
    private class A {
        private int i = 10;
 
        public int getI() {
            return i;
        }
 
        public void setI(int i) {
            this.i = i;
        }
    }
 
    // Resource B
    private class B {
        private int i = 20;
 
        public int getI() {
            return i;
        }
 
        public void setI(int i) {
            this.i = i;
        }
    }
}

Running above code will result in deadlock for very obvious reasons (explained above). Now we have to solve this issue.
I believe, solution to any problem lies in identifying the root of problem. In our case, it is the pattern of accessing A and B, is main issue. So, to solve it, we will simply re-order the statements where code is accessing shared resources.

After rewriting the code, it will look like this:
   // Thread-1
Runnable block1 = new Runnable() {
    public void run() {
        synchronized (b) {
            try {
                // Adding delay so that both threads can start trying to
                // lock resources
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread-1 have A but need B also
            synchronized (a) {
                System.out.println("In block 1");
            }
        }
    }
};
 

// Thread-2
Runnable block2 = new Runnable() {
    public void run() {
        synchronized (b) {
            // Thread-2 have B but need A also
            synchronized (a) {
                System.out.println("In block 2");
            }
        }
    }
};
Run again above class, and you will not see any deadlock kind of situation. I hope, it will help you in avoiding deadlocks, and if encountered, in resolving them.

ScheduledThreadPoolExecutor – Task Scheduling with Executors

The Java Executor Framework provides the ThreadPoolExecutorclass to execute Callable and Runnable tasks with a pool of threads, which avoid you writing lots of boiler plate complex code. The way executors work is when you send a task to the executor, it’s executed as soon as possible. But there may be used cases when you are not interested in executing a task as soon as possible. Rather You may want to execute a task after a period of time or to execute a task periodically. For these purposes, the Executor framework provides the 

ScheduledThreadPoolExecutorclass.

Task to be executed

Let’s write a very basic task which we can use for demo purpose.

class Task implements Runnable
{
    private String name;
 
    public Task(String name) {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
    @Override
    public void run() 
    {
        try {
            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

Execute a task after a period of time

package com.howtodoinjava.demo.multithreading;
 
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
public class ScheduledThreadPoolExecutorExample
{
    public static void main(String[] args) 
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Task task1 = new Task ("Demo Task 1");
        Task task2 = new Task ("Demo Task 2");
         
        System.out.println("The time is : " + new Date());
         
        executor.schedule(task1, 5 , TimeUnit.SECONDS);
        executor.schedule(task2, 10 , TimeUnit.SECONDS);
         
        try {
              executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
              e.printStackTrace();
        }
         
        executor.shutdown();
    }
}
 
Output:
 
The time is : Wed Mar 25 16:14:07 IST 2015
Doing a task during : Demo Task 1 - Time - Wed Mar 25 16:14:12 IST 2015
Doing a task during : Demo Task 2 - Time - Wed Mar 25 16:14:17 IST 2015

As with class ThreadPoolExecutor, to create a scheduled executor, Java recommends the utilization of the Executorsclass. In this case, you have to use the newScheduledThreadPool() method. You have passed the number 1 as a parameter to this method. This parameter is the number of threads you want to have in the pool.

To execute a task in this scheduled executor after a period of time, you have to use the schedule() method. This method receives the following three parameters:
•	The task you want to execute
•	The period of time you want the task to wait before its execution
•	The unit of the period of time, specified as a constant of the TimeUnit class

Also note that You can also use the Runnable interface to implement the tasks, because the schedule() method of the ScheduledThreadPoolExecutor class accepts both types of tasks.

Moreover ,although the ScheduledThreadPoolExecutor class is a child class of the ThreadPoolExecutor class and, therefore, inherits all its features, Java recommends the utilization of ScheduledThreadPoolExecutor only for scheduled tasks.

Finally, you can configure the behavior of the ScheduledThreadPoolExecutor class when you call the shutdown()method and there are pending tasks waiting for the end of their delay time. The default behavior is that those tasks will be executed despite the finalization of the executor. You can change this behavior using the setExecuteExistingDelayedTasksAfterShutdownPolicy() method of the ScheduledThreadPoolExecutor class. With false, at the time of shutdown(), pending tasks won’t get executed.

Execute a task periodically

Now let’s learn how to use ScheduledThreadPoolExecutor to schedule a periodic task.

public class ScheduledThreadPoolExecutorExample
{
    public static void main(String[] args) 
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Task task1 = new Task ("Demo Task 1");
         
        System.out.println("The time is : " + new Date());
         
        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task1, 2, 5, TimeUnit.SECONDS);
         
        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        executor.shutdown();
    }
}
 
Output:
 
The time is : Wed Mar 25 16:20:12 IST 2015
Doing a task during : Demo Task 1 - Time - Wed Mar 25 16:20:14 IST 2015
Doing a task during : Demo Task 1 - Time - Wed Mar 25 16:20:19 IST 2015
Doing a task during : Demo Task 1 - Time - Wed Mar 25 16:20:24 IST 2015
Doing a task during : Demo Task 1 - Time - Wed Mar 25 16:20:29 IST 2015

In this example, we have created ScheduledExecutorService instance just like above example using newScheduledThreadPool() method. Then we have used the scheduledAtFixedRate() method. This method accepts four parameters:
•	the task you want to execute periodically,
•	the delay of time until the first execution of the task,
•	the period between two executions,
•	and the time unit of the second and third parameters.

An important point to consider is that the period between two executions is the period of time between these two executions that begins. If you have a periodic task that takes 5 seconds to execute and you put a period of 3 seconds, you will have two instances of the task executing at a time.

ScheduledThreadPoolExecutor provides other methods to schedule periodic tasks. It is the scheduleWithFixedRate() method. It has the same parameters as the scheduledAtFixedRate() method, but there is a difference worth noticing. In the scheduledAtFixedRate() method, the third parameter determines the period of time between the starting of two executions. In the scheduledWithFixedRate() method, parameter determines the period of time between the end of an execution of the task and the beginning of the next execution.

You can also configure the behavior of an instance of the ScheduledThreadPoolExecutor class with the shutdown()method. The default behavior is that the scheduled tasks finish when you call that method. You can change this behavior using the setContinueExistingPeriodicTasksAfterShutdownPolicy() method of the ScheduledThreadPoolExecutor class with a true value. The periodic tasks won’t finish upon calling the shutdown()method.

Java Fixed Size Thread Pool Executor Example

In previous tutorial, we learned about basic thread pool executor with unlimited possible number of threads into the pool and it’s example usage. Now lets look example of fixed size thread pool executor which will help in improved performance and better system resource utilization by limiting the maximum number of threads in thread pool.

1) Create a task to execute

Obviously, first step is to have a task which you would like to execute using executors.

class Task implements Runnable 
{
    private String name;
 
    public Task(String name) 
    {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
    @Override
    public void run() 
    {
        try
        {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Doing a task during : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}

3) Execute tasks using Executors

Now all you have to do is to create an instance of ThreadPoolExecutor with fixed size and pass the tasks to be executed into it’s execute() method.

package com.howtodoinjava.demo.multithreading;
 
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class FixedThreadPoolExecutorExample 
{
    public static void main(String[] args) 
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) 
        {
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
        }
        System.out.println("Maximum threads inside pool " + executor.getMaximumPoolSize());
        executor.shutdown();
    }
}
 
Output:
 
A new task has been added : Task 0
A new task has been added : Task 1
A new task has been added : Task 2
A new task has been added : Task 3
A new task has been added : Task 4
A new task has been added : Task 5
A new task has been added : Task 6
A new task has been added : Task 7
Doing a task during : Task 0
Doing a task during : Task 2
Doing a task during : Task 1
A new task has been added : Task 8
Doing a task during : Task 3
A new task has been added : Task 9
 
Maximum threads inside pool 4
 
Doing a task during : Task 4
Doing a task during : Task 5
Doing a task during : Task 6
Doing a task during : Task 7
Doing a task during : Task 8
Doing a task during : Task 9
Important Points:

1) newFixedThreadPool() method creates an executor with a maximum number of threads at any time. If you send more tasks than the number of threads, the remaining tasks will be blocked until there is a free thread to process them This method receives the maximum number of threads as a parameter you want to have in your executor. In your case, you have created an executor with four threads.

2) The Executors class also provides the newSingleThreadExecutor() method. This is an extreme case of a fixed-size thread executor. It creates an executor with only one thread, so it can only execute one task at a time.

</details>
<details><summary><b>[66.13 - Object level Locking vs. Class level Locking in Java]</b></summary>
	
#### Object level Locking vs. Class level Locking in Java

Synchronization refers to multi-threading. A synchronized block of code can only be executed by one thread at a time.
Java supports multiple threads to be executed. This may cause two or more threads to access the same fields or objects. Synchronization is a process which keeps all concurrent threads in execution to be in synch. Synchronization avoids memory consistence errors caused due to inconsistent view of shared memory. When a method is declared as synchronized; the thread holds the monitor for that method’s object If another thread is executing the synchronized method, your thread is blocked until that thread releases the monitor.
Synchronization in java is achieved using synchronized keyword. You can use synchronized keyword in your class on defined methods or blocks. Keyword can not be used with variables or attributes in class definition.
Object level locking
Object level locking is mechanism when you want to synchronize a non-static method or non-static code block such that only one thread will be able to execute the code block on given instance of the class. This should always be done to make instance level data thread safe. This can be done as below :
public class DemoClass
{
    public synchronized void demoMethod(){}
}
 
or
 
public class DemoClass
{
    public void demoMethod(){
        synchronized (this)
        {
            //other thread safe code
        }
    }
}
 
or
 
public class DemoClass
{
    private final Object lock = new Object();
    public void demoMethod(){
        synchronized (lock)
        {
            //other thread safe code
        }
    }
}
- Class level locking
Class level locking prevents multiple threads to enter in synchronized block in any of all available instances on runtime. This means if in runtime there are 100 instances of  DemoClass, then only one thread will be able to execute demoMethod() in any one of instance at a time, and all other instances will be locked for other threads. This should always be done to make static data thread safe.
public class DemoClass
{
    public synchronized static void demoMethod(){}
}
 
or
 
public class DemoClass
{
    public void demoMethod(){
        synchronized (DemoClass.class)
        {
            //other thread safe code
        }
    }
}
 
or
 
public class DemoClass
{
    private final static Object lock = new Object();
    public void demoMethod(){
        synchronized (lock)
        {
            //other thread safe code
        }
    }
}
- Some Important notes
1.	Synchronization in java guarantees that no two threads can execute a synchronized method which requires same lock simultaneously or concurrently.
2.	Synchronized keyword can be used only with methods and code blocks. These methods or blocks can be static or non-static both.
3.	When ever a thread enters into java synchronized method or block it acquires a lock and whenever it leaves java synchronized method or block it releases the lock. Lock is released even if thread leaves synchronized method after completion or due to any Error or Exception.
4.	java synchronized keyword is re-entrant in nature it means if a java synchronized method calls another synchronized method which requires same lock then current thread which is holding lock can enter into that method without acquiring lock.
5.	Java Synchronization will throw NullPointerException if object used in java synchronized block is null. For example, in above code sample if lock is initialized as null, the synchronized (lock) will throw NullPointerException.
6.	Synchronized methods in Java put a performance cost on your application. So use synchronization when it is absolutely required. Also, consider using synchronized code blocks for synchronizing only critical section of your code.
7.	It’s possible that both static synchronized and non static synchronized method can run simultaneously or concurrently because they lock on different object.
8.	According to the Java language specification you can not use java synchronized keyword with constructor it’s illegal and result in compilation error.
9.	Do not synchronize on non final field on synchronized block in Java. Because reference of non final field may change any time and then different thread might synchronizing on different objects i.e. no synchronization at all. Best is to use String class, which is already immutable and declared final.

- ConcurrentLinkedDeque Example – Non-blocking Thread-safe List

In java, most used data structure is probably a list. A list has an undetermined number of elements and you can add, read, or remove the element of any position. Additionally, concurrent lists allow the various threads to add or remove elements in the list at a time without producing any data inconsistency. And non-blocking lists provide operations that, if the operation can’t be done immediately, lists throw an exception or return a null value, depending on the operation. Java 7 has introduced the ConcurrentLinkedDeque class that implements a non-blocking concurrent list and in this tutorial, we will learn to use this class.

ConcurrentLinkedDeque Example

In this example, we are going to implement an example with the following two different tasks:
1.	One that adds data to a list in large amount
2.	One that removes data from the same list in large amount

Let’s create the threads for each task.

package com.howtodoinjava.demo.multithreading.concurrentLinkedDequeExample;
 
import java.util.concurrent.ConcurrentLinkedDeque;
 
public class AddTask implements Runnable {
 
    private ConcurrentLinkedDeque<String> list;
 
    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }
}
and
package com.howtodoinjava.demo.multithreading.concurrentLinkedDequeExample;
 
import java.util.concurrent.ConcurrentLinkedDeque;
 
public class RemoveTask implements Runnable {
 
    private ConcurrentLinkedDeque<String> list;
 
    public RemoveTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }
 
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}
Now, let’s create 100 threads adding data into list and 100 threads for removing data from list. If the list is truly thread-safe and non-blocking, it will give you final result almost instantly. Moreover, list size in end will be zero.
package com.howtodoinjava.demo.multithreading.concurrentLinkedDequeExample;
 
import java.util.concurrent.ConcurrentLinkedDeque;
 
public class Main {
    public static void main(String[] args) 
    {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread threads[] = new Thread[100];
 
        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);
 
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
 
        for (int i = 0; i < threads.length; i++) {
            RemoveTask task = new RemoveTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d RemoveTask threads have been launched\n", threads.length);
 
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
    }
}
 
Output:
 
Main: 100 AddTask threads have been launched
Main: Size of the List: 1000000
Main: 100 RemoveTask threads have been launched
Main: Size of the List: 0

Let’s see how it all worked:

1.	First, you have executed 100 AddTask tasks to add elements to the list. Each one of those tasks inserts 10,000 elements to the list using the add() method. This method adds the new elements at the end of the list. When all those tasks have finished, you have written in the console the number of elements of the list. At this moment, the list has 1,000,000 elements.
2.	Then, you have executed 100 RemoveTask tasks to remove elements from the list. Each one of those tasks removes 10,000 elements of the list using the pollFirst() and pollLast() methods. The pollFirst() method returns and removes the first element of the list and the pollLast() method returns and removes the last element of the list. If the list is empty, these methods return a null value. When all those tasks have finished, you have written in the console the number of elements of the list. At this moment, the list has zero elements.
3.	To write the number of elements of the list, you have used the size() method. You have to take into account that this method can return a value that is not real, especially if you use it when there are threads adding or deleting data in the list. The method has to traverse the entire list to count the elements and the contents of the list can change for this operation. Only if you use them when there aren’t any threads modifying the list, you will have the guarantee that the returned result is correct.

Please note that ConcurrentLinkedDeque class provides more methods to get elements form the list:

•	getFirst() and getLast(): These methods return the first and last element from the list respectively. They don’t remove the returned element from the list. If the list is empty, these methods throw a NoSuchElementExcpetion exception.
•	peek(), peekFirst(), and peekLast(): These methods return the first and the last element of the list respectively. They don’t remove the returned element from the list. If the list is empty, these methods return a null value.
•	remove(), removeFirst(), removeLast(): These methods return the first and the last element of the list respectively. They remove the returned element from the list. If the list is empty, these methods throw a NoSuchElementException exception.
•	A ConcurrentLinkedDeque is an appropriate choice when many threads will share access to a common collection.
•	Like most other concurrent collection implementations, this class does not permit the use of null elements.
•	Iterators are weakly consistent, returning elements reflecting the state of the deque at some point at or since the creation of the iterator. They do not throw ConcurrentModificationException, and may proceed concurrently with other operations.

Throttling Task Submission Rate with ThreadPoolExecutor and Semaphore

If you may know that in web-servers you can configure the maximum number of concurrent connections to the server. If more connections than this limit come to server, they have to wait until some other connections are freed or closed. This limitation can be taken as throttling. Throttling is the capability of regulating the rate of input for a system where output rate is slower than input. It is necessary to stop the system from crashing or resource exhaustion.

In one of my previous post related to BlockingQueue and ThreadPoolExecutor, We learned about creating a CustomThreadPoolExecutor which had following capabilities:

1) Tasks being submitted to blocking queue
2) An executor which picks up the task from queue and execute them
3) Had overridden beforeExecute() and afterExecute() methods to perform some extra activities if needed
4) Attached a RejectedExecutionHandler which handle the task if it got rejected because the queue was full
Our approach was good enough already and capable of handling most of the practical scenarios. Now let’s add one more concept into it which may prove beneficial in some conditions. This concept is around throttling of task submission in queue.

In this example, throttling will help in keeping the number of tasks in queue in limit so that no task get rejected. It essentially removes the necessity of RejectedExecutionHandler as well.

Previous Solution Using CustomThreadPoolExecutor with RejectedExecutionHandler

In this solution, we had following classes:

DemoTask.java

public class DemoTask implements Runnable
{
   private String name = null;
 
   public DemoTask(String name) {
      this.name = name;
   }
 
   public String getName() {
      return this.name;
   }
 
   @Override
   public void run(){
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e){
         e.printStackTrace();
      }
      System.out.println("Executing : " + name);
   }
}

CustomThreadPoolExecutor.java

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class CustomThreadPoolExecutor extends ThreadPoolExecutor
{
   public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, 
                                    TimeUnit unit, BlockingQueue<Runnable> workQueue)
   {
      super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
   }
 
   @Override
   protected void beforeExecute(Thread t, Runnable r)
   {
      super.beforeExecute(t, r);
   }
 
   @Override
   protected void afterExecute(Runnable r, Throwable t)
   {
      super.afterExecute(r, t);
      if (t != null)
      {
         t.printStackTrace();
      }
   }
}

DemoExecutor.java

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class DemoExecutor
{
   public static void main(String[] args)
   {
      Integer threadCounter = 0;
      BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
      CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS, blockingQueue);
      executor.setRejectedExecutionHandler(new RejectedExecutionHandler()
         {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
            {
               System.out.println("DemoTask Rejected : " + ((DemoTask) r).getName());
               try
               {
                  Thread.sleep(1000);
               } catch (InterruptedException e)
               {
                  e.printStackTrace();
               }
               System.out.println("Lets add another time : " + ((DemoTask) r).getName());
               executor.execute(r);
            }
         });
      // Let start all core threads initially
      executor.prestartAllCoreThreads();
      while (true)
      {
         threadCounter++;
         // Adding threads one by one
         //System.out.println("Adding DemoTask : " + threadCounter);
         executor.execute(new DemoTask(threadCounter.toString()));
         if (threadCounter == 1000)
            break;
      }
   }
}
If we run the above program, we will get the output like below:
DemoTask Rejected : 71
Executing : 3
Executing : 5
...
...
There will be multiple occurrences of “DemoTask Rejected“. In next solution, we will put throttle technique so that no task should be rejected.

Throttling Task submission rate using ThreadPoolExecutor and Semaphore

In this solution, we will create a Semaphore with a number which must be equal to maximum number of tasks in blocking queue at any given point of time. So the approach works like this:

1) Before executing a task a lock in semaphore is requested
2) If lock is acquired then execution works normally; Otherwise retry will happen until lock is acquired
3) Once task is completed; lock is released to semaphore
Our new throttling enabled BlockingThreadPoolExecutor looks like below:

package threadpoolDemo;
 
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class BlockingThreadPoolExecutor extends ThreadPoolExecutor
{
   private final Semaphore semaphore;
 
   public BlockingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
   {
      super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
      semaphore = new Semaphore(corePoolSize + 50);
   }
 
   @Override
   protected void beforeExecute(Thread t, Runnable r)
   {
      super.beforeExecute(t, r);
   }
 
   @Override
   public void execute(final Runnable task)
   {
      boolean acquired = false;
      do
      {
         try
         {
            semaphore.acquire();
            acquired = true;
         } catch (final InterruptedException e)
         {
            //LOGGER.warn("InterruptedException whilst aquiring semaphore", e);
         }
      } while (!acquired);
      try
      {
         super.execute(task);
      } catch (final RejectedExecutionException e)
      {
         System.out.println("Task Rejected");
         semaphore.release();
         throw e;
      }
   }
 
   @Override
   protected void afterExecute(Runnable r, Throwable t)
   {
      super.afterExecute(r, t);
      if (t != null)
      {
         t.printStackTrace();
      }
      semaphore.release();
   }
}
Now test the code as below.
package threadpoolDemo;
 
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class DemoExecutor
{
   public static void main(String[] args)
   {
      Integer threadCounter = 0;
      BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
      BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS, blockingQueue);
      executor.setRejectedExecutionHandler(new RejectedExecutionHandler()
         {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
            {
               System.out.println("DemoTask Rejected : " + ((DemoTask) r).getName());
               try
               {
                  Thread.sleep(1000);
               } catch (InterruptedException e)
               {
                  e.printStackTrace();
               }
               System.out.println("Lets add another time : " + ((DemoTask) r).getName());
               executor.execute(r);
            }
         });
      // Let start all core threads initially
      executor.prestartAllCoreThreads();
      while (true)
      {
         threadCounter++;
         // Adding threads one by one
         System.out.println("Adding DemoTask : " + threadCounter);
         executor.execute(new DemoTask(threadCounter.toString()));
         if (threadCounter == 1000)
            break;
      }
   }
}
When you run the DemoExecutor program using BlockingThreadPoolExecutor in place of CustomThreadPoolExecutor, you will not see any task rejected and all tasks will be executed successfully.

You can control the number of tasks executing at any time parameter passes in Semaphore constructor.
That’s all for this post. You should read more posts on concurrency for better confidence.

- Java Executor Framework Tutorial and Best Practices

Executors framework (java.util.concurrent.Executor), released with the JDK 5 in package java.util.concurrent is used to run the Runnable objects without creating new threads every time and mostly re-using the already created threads.

We all know about that there are two ways to create a thread in java. If you want to read more about their comparison, read this post. Creating a thread in java is a very expensive process which includes memory overhead also. So, it’s a good idea if we can re-use these threads once created, to run our future runnables.

In this post, I will write some demo programs demonstrating the usage of Executor and then we will talk about some best practices which you need to keep in mind while designing your next multi-threaded application.
If you want read more about other multi-threading topics, follow this link.

- Basic usage demo application

In our demo application, we have two tasks running. Neither is expected to terminate, and both should run for the duration of the application’s life. I will try to write a main wrapper class such that:

If any task throws an exception, the application will catch it and restart the task.

If any task runs to completion, the application will notice and restart the task.

Below is the code sample of above required application:

package com.howtodoinjava.multiThreading.executors;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class DemoExecutorUsage {
 
    private static ExecutorService executor = null;
    private static volatile Future taskOneResults = null;
    private static volatile Future taskTwoResults = null;
 
    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(2);
        while (true)
        {
            try
            {
                checkTasks();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.err.println("Caught exception: " + e.getMessage());
            }
        }
    }
 
    private static void checkTasks() throws Exception {
        if (taskOneResults == null
                || taskOneResults.isDone()
                || taskOneResults.isCancelled())
        {
            taskOneResults = executor.submit(new TestOne());
        }
 
        if (taskTwoResults == null
                || taskTwoResults.isDone()
                || taskTwoResults.isCancelled())
        {
            taskTwoResults = executor.submit(new TestTwo());
        }
    }
}
 
class TestOne implements Runnable {
    public void run() {
        while (true)
        {
            System.out.println("Executing task one");
            try
            {
                Thread.sleep(1000);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
 
    }
}
 
class TestTwo implements Runnable {
    public void run() {
        while (true)
        {
            System.out.println("Executing task two");
            try
            {
                Thread.sleep(1000);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
Please do not forget to read best practices at the end of post.

- Executing multiple tasks in a single thread

It’s not necessary that each Runnable should be executed in a separate thread. Sometimes, we need to do multiple jobs in a single thread and each job is instance of Runnable. To design this type of solution, a multi runnable should be used. This multi runnable is nothing but a collection of runnables which needs to be executed. Only addition is that this multi runnable is also a Runnable itself.
Below is the list of tasks which needs to be executed in a single thread.

package com.howtodoinjava.multiThreading.executors;
 
public class TaskOne implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task One");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
public class TaskTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task Two");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
public class TaskThree implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task Three");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

Lets create out multi runnable wrapper of above Tasks.

package com.howtodoinjava.demo.multiThread;
 
import java.util.List;
 
public class MultiRunnable implements Runnable {
 
    private final List<Runnable> runnables;
 
    public MultiRunnable(List<Runnable> runnables) {
        this.runnables = runnables;
    }
 
    @Override
    public void run() {
        for (Runnable runnable : runnables) {
             new Thread(runnable).start();
        }
    }
}

Now above multi runnable can be executed this way as in below program:
package com.howtodoinjava.demo.multiThread;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class MultiTaskExecutor {
 
    public static void main(String[] args) {
         
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandelerImpl();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, worksQueue, rejectionHandler);
 
        executor.prestartAllCoreThreads();
         
        List<Runnable> taskGroup = new ArrayList<Runnable>();
        taskGroup.add(new TestOne());
        taskGroup.add(new TestTwo());
        taskGroup.add(new TestThree());
  
        worksQueue.add(new MultiRunnable(taskGroup));
    }
}
 
class RejectedExecutionHandelerImpl implements RejectedExecutionHandler
{
    @Override
    public void rejectedExecution(Runnable runnable,
            ThreadPoolExecutor executor)
    {
        System.out.println(runnable.toString() + " : I've been rejected ! ");
    }
}

- Best practices which must be followed

1.	Always run your java code against static analysis tools like PMD and FindBugs to look for deeper issues. They are very helpful in determining ugly situations which may arise in future.
2.	Always cross check and better plan a code review with senior guys to detect and possible deadlock or livelock in code during execution. Adding a health monitor in your application to check the status of running tasks is an excellent choice in most of the scenarios.
3.	In multi-threaded programs, make a habit of catching errors too, not just exceptions. Sometimes unexpected things happen and Java throws an error at you, apart from an exception.
4.	Use a back-off switch, so if something goes wrong and is non-recoverable, you don’t escalate the situation by eagerly starting another loop. Instead, you need to wait until the situation goes back to normal and then start again.
5.	Please note that the whole point of executors is to abstract away the specifics of execution, so ordering is not guaranteed unless explicitly stated.

</details>
</details>

<details><summary><b>[67 - Java ConcurrentHashMap Best Practices]</b></summary>
	
#### Java ConcurrentHashMap Best Practices

The ConcurrentHashMap is very similar to the HashMap class, except that ConcurrentHashMap offers internally maintained concurrency. It means you do not need to have synchronized blocks when accessing ConcurrentHashMap in multithreaded application.
//Initialize ConcurrentHashMap instance
ConcurrentHashMap<String, Integer> m = new ConcurrentHashMap<String, Integer>();
 
//Print all values stored in ConcurrentHashMap instance
for each (Entry<String, Integer> e : m.entrySet())
{
system.out.println(e.getKey()+"="+e.getValue());
}
Above code is reasonably valid in multi-threaded environment in your application. The reason, I am saying “reasonably valid” is that, above code yet provides thread safety, still it can decrease the performance of application. And ConcurrentHashMap was introduced to improve the performance while ensuring thread safety, right??

So, what is that we are missing here??

To understand that we need to understand the internal working of ConcurrentHashMap class. And the best way to start is look at the constructor arguments. Fully parametrized constructor of ConcurrentHashMap takes 3 parameters, initialCapacity, loadFactor and concurrencyLevel.
1) initialCapacity
2) loadFactor
3) concurrencyLevel

First two are fairly simple as their name implies but last one is tricky part. This denotes the number of shards. It is used to divide the ConcurrentHashMap internally into this number of partitions and equal number of threads are created to maintain thread safety maintained at shard level.

- ConcurrentHashMap
 
The default value of “concurrencyLevel” is 16. It means 16 shards whenever we create an instance of ConcurrentHashMap using default constructor, before even adding first key-value pair. It also means the creation of instances for various inner classes like ConcurrentHashMap$Segment, ConcurrentHashMap$HashEntry[] and ReentrantLock$NonfairSync.

In most cases in normal application, a single shard is able to handle multiple threads with reasonable count of key-value pairs. And performance will be also optimal. Having multiple shards just makes the things complex internally and introduces a lot of un-necessary objects for garbage collection, and all this for no performance improvement.

The extra objects created per concurrent hashmap using default constructor are normally in ratio of 1 to 50 i.e. for 100 such instance of ConcurrentHashMap, there will be 5000 extra objects created.

Based on above, I will suggest to use the constructor parameters wisely to reduce the number of unnecessary objects and improving the performance.

- A good approach can be having initialization like this:

ConcurrentHashMap<String, Integer> instance = new ConcurrentHashMap<String, Integer>(16, 0.9f, 1);
An initial capacity of 16 ensures a reasonably good number of elements before resizing happens. Load factor of 0.9 ensures a dense packaging inside ConcurrentHashMap which will optimize memory use. And concurrencyLevel set to 1 will ensure that only one shard is created and maintained.

Please note that if you are working on very high concurrent application with very high frequency of updates in ConcurrentHashMap, you should consider increasing the concurrencyLevel more than 1, but again it should be a well calculated number to get the best results.
Java Concurrency – Difference between yield() and join()

Multi-threading is very popular topic among interviewers from long time. Though I personally feel that very few of us get real chance to work on a complex multi-threaded application (I got only one chance in last 7 years), still it helps in having the concepts handy to boost your confidence ONLY. Previously, I discussed a similar question about difference between wait() and sleep() method, this time I am discussing difference between join() and yield() methods. Frankly speaking, I have not used any of both methods in practical so please make a argument if you feel otherwise at any point.

- A little background on java thread scheduling

A Java virtual machine is required to implement a preemptive, priority-based scheduler among its various threads. This means that each thread in a Java program is assigned a certain priority, a positive integer that falls within a well-defined range. This priority can be changed by the developer. The Java virtual machine never changes the priority of a thread, even if the thread has been running for a certain period of time.

The priority value is important because the contract between the Java virtual machine and the underlying operating system is that the operating system must generally choose to run the Java thread with the highest priority. That’s what we mean when we say that Java implements a priority-based scheduler. This scheduler is implemented in a preemptive fashion, meaning that when a higher-priority thread comes along, that thread interrupts (preempts) whatever lower-priority thread is running at the time. The contract with the operating system, however, is not absolute, which means that the operating system can sometimes choose to run a lower-priority thread. [I hate this about multi-threading.. nothing is guaranteed :-( ]
Also note that java does not mandate that its threads be time-sliced, but most operating systems do so. There is often some confusion in terminology here: preemption is often confused with time-slicing. In fact, preemption means only that a higher-priority thread runs instead of a lower-priority one, but when threads have the same priority, they do not preempt each other. They are typically subject to time-slicing, but that is not a requirement of Java.

- Understanding thread priorities

Understanding the Thread priorities is next important step in learning Multi-threading and specially how yield() works.
1.	Remember that all the threads carry normal priority when a priority is not specified.
2.	Priorities can be specified from 1 to 10. 10 being the highest, 1 being the lowest priority and 5 being the normal priority.
3.	Remember that the thread with highest priority will be given preference in execution. But there is no guarantee that it will be in running state the moment it starts.
4.	Always the currently executing thread might have the higher priority when compared to the threads in the pool who are waiting for their chance.
5.	It is the thread scheduler which decides what thread should be executed.
6.	t.setPriority() can be used to set the priorities for the threads.
7.	Remember that the priorities should be set before the threads start method is invoked.
8.	You can use the constants, MIN_PRIORITY,MAX_PRIORITY and NORM_PRIORITY for setting priorities.

Now when we have some basic understanding of thread scheduling and thread priorities, let’s jump into subject.

- yield() method

Theoretically, to ‘yield’ means to let go, to give up, to surrender. A yielding thread tells the virtual machine that it’s willing to let other threads be scheduled in its place. This indicates that it’s not doing something too critical. Note that it’s only a hint, though, and not guaranteed to have any effect at all.

yield() is defined as following in Thread.java.
/**
  * A hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore
  * this hint. Yield is a heuristic attempt to improve relative progression between threads that would otherwise over-utilize a CPU. 
  * Its use should be combined with detailed profiling and benchmarking to ensure that it actually has the desired effect. 
  */
 
public static native void yield();
Let’s list down important points from above definition:
•	Yield is a Static method and Native too.
•	Yield tells the currently executing thread to give a chance to the threads that have equal priority in the Thread Pool.
•	There is no guarantee that Yield will make the currently executing thread to runnable state immediately.
•	It can only make a thread from Running State to Runnable State, not in wait or blocked state.

- yield() method example usage

In below example program, I have created two threads named producer and consumer for no specific reason. Producer is set to minimum priority and consumer is set to maximum priority. I will run below code with/without commenting the line Thread.yield(). Without yield(), though the output changes sometimes, but usually first all consumer lines are printed and then all producer lines.
With using yield() method, both prints one line at a time and pass the chance to another thread, almost all the time.

package test.core.threads;
 
public class YieldExample
{
   public static void main(String[] args)
   {
      Thread producer = new Producer();
      Thread consumer = new Consumer();
       
      producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
      consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority
       
      producer.start();
      consumer.start();
   }
}
 
class Producer extends Thread
{
   public void run()
   {
      for (int i = 0; i < 5; i++)
      {
         System.out.println("I am Producer : Produced Item " + i);
         Thread.yield();
      }
   }
}
 
class Consumer extends Thread
{
   public void run()
   {
      for (int i = 0; i < 5; i++)
      {
         System.out.println("I am Consumer : Consumed Item " + i);
         Thread.yield();
      }
   }
}
Output of above program “without” yield() method
I am Consumer : Consumed Item 0
 I am Consumer : Consumed Item 1
 I am Consumer : Consumed Item 2
 I am Consumer : Consumed Item 3
 I am Consumer : Consumed Item 4
 I am Producer : Produced Item 0
 I am Producer : Produced Item 1
 I am Producer : Produced Item 2
 I am Producer : Produced Item 3
 I am Producer : Produced Item 4
Output of above program “with” yield() method added
I am Producer : Produced Item 0
 I am Consumer : Consumed Item 0
 I am Producer : Produced Item 1
 I am Consumer : Consumed Item 1
 I am Producer : Produced Item 2
 I am Consumer : Consumed Item 2
 I am Producer : Produced Item 3
 I am Consumer : Consumed Item 3
 I am Producer : Produced Item 4
 I am Consumer : Consumed Item 4

- join() method

The join() method of a Thread instance can be used to “join” the start of a thread’s execution to the end of another thread’s execution so that a thread will not start running until another thread has ended. If join() is called on a Thread instance, the currently running thread will block until the Thread instance has finished executing.
//Waits for this thread to die. 
 
- public final void join() throws InterruptedException

Giving a timeout within join(), will make the join() effect to be nullified after the specific timeout. When the timeout is reached, the main thread and taskThread are equally probable candidates to execute. However, as with sleep, join is dependent on the OS for timing, so you should not assume that join will wait exactly as long as you specify.

Like sleep, join responds to an interrupt by exiting with an InterruptedException.

join() method example usage

package test.core.threads;
 
public class JoinExample
{
   public static void main(String[] args) throws InterruptedException
   {
      Thread t = new Thread(new Runnable()
         {
            public void run()
            {
               System.out.println("First task started");
               System.out.println("Sleeping for 2 seconds");
               try
               {
                  Thread.sleep(2000);
               } catch (InterruptedException e)
               {
                  e.printStackTrace();
               }
               System.out.println("First task completed");
            }
         });
      Thread t1 = new Thread(new Runnable()
         {
            public void run()
            {
               System.out.println("Second task completed");
            }
         });
      t.start(); // Line 15
      t.join(); // Line 16
      t1.start();
   }
}
 
Output:
 
First task started
Sleeping for 2 seconds
First task completed
Second task completed
That’s all for this quite small but important concept. Let me know of your thoughts in comments section.

- Java Multi-threading Evolution and Topics

One of our reader, Anant, asked this extremely good question to elaborate / list down all related topics that we should know about multi-threading including changes made in java 8.( Beginner level to Advance level). All he wanted to know was evolution of Multi-threading Framework in Java from Simple Runnable interface to latest feature in Java 8. Let us solve his query.
I spent good amount of time in collecting all below information. So please feel free to suggest edit/update in below information if you think otherwise on any point.

- JDK release-wise multi-threading concepts

As per JDK 1.x release, there were only few classes present in this initial release. To be very specific, there classes/interfaces were:
•	java.lang.Thread
•	java.lang.ThreadGroup
•	java.lang.Runnable
•	java.lang.Process
•	java.lang.ThreadDeath
•	and some exception classes
e.g.
1.	java.lang.IllegalMonitorStateException
2.	java.lang.IllegalStateException
3.	java.lang.IllegalThreadStateException.

It also had few synchronized collections e.g. java.util.Hashtable.

JDK 1.2 and JDK 1.3 had no noticeable changes related to multi-threading. (Correct me if I have missed anything).

JDK 1.4, there were few JVM level changes to suspend/resume multiple threads with single call. But no major API changes were present.

JDK 1.5 was first big release after JDK 1.x; and it had included multiple concurrency utilities. Executor, semaphore, mutex, barrier, latches, concurrent collections and blocking queues; all were included in this release itself. The biggest change in java multi-threading applications cloud happened in this release.
 
JDK 1.6 was more of platform fixes than API upgrades. So new change was present in JDK 1.6.

JDK 1.7 added support for ForkJoinPool which implemented work-stealing technique to maximize the throughput. Also Phaser class was added.

JDK 1.8 is largely known for Lambda changes, but it also had few concurrency changes as well. Two new interfaces and four new classes were added in java.util.concurrent package e.g. CompletableFuture and CompletionException.

The Collections Framework has undergone a major revision in Java 8 to add aggregate operations based on the newly added streams facility and lambda expressions; resulting in large number of methods added in almost all Collection classes, and thus in concurrent collections as well.

</details>
<details><summary><b>[68 - Java Concurrency – Thread Safety?]</b></summary>
	
#### Java Concurrency – Thread Safety?

Defining thread safety is surprisingly tricky. A quick Google search turns up numerous “definitions” like these:
1.	Thread-safe code is code that will work even if many Threads are executing it simultaneously.
2.	A piece of code is thread-safe if it only manipulates shared data structures in a manner that guarantees safe execution by multiple threads at the same time.
And there are more similar definitions.

Don’t you think that definitions like above actually does not communicate anything meaningful and even add some more confusion. Though these definitions can’t be ruled out just like that, because they are not wrong. But the fact is they do not provide any practical help or perspective. How do we make a difference between a thread-safe class and an unsafe one? What do we even mean by “safe”?

- What is Correctness in thread safety?

At the heart of any reasonable definition of thread safety is the concept of correctness. So, before understanding the thread-safety we should understand first, this “correctness“.

Correctness means that a class conforms to its specification.

You will agree that a good class specification will have all information about a class’s state at any given time and it’s post condition if some operation is performed on it. Since we often don’t write adequate specifications for our classes, how can we possibly know they are correct? We can’t, but that doesn’t stop us from using them anyway once we’ve convinced ourselves that “the code works”. This “code confidence” is about as close as many of us get to correctness.

Having optimistically defined “correctness” as something that can be recognized, we can now define thread safety in a somewhat less circular way: a class is thread-safe when it continues to behave correctly when accessed from multiple threads.

A class is thread-safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling or interleaving of the execution of those threads by the runtime environment, and with no additional synchronization or other coordination on the part of the calling code.

If the loose use of “correctness” here bothers you, you may prefer to think of a thread-safe class as one that is no more broken in a concurrent environment than in a single-threaded environment. Thread-safe classes encapsulate any needed synchronization so that clients need not provide their own.

Example: A Stateless Servlet

A good example of thread safe class is java servlets which have no fields and references, no fields from other classes etc. They are stateless.
public class StatelessFactorizer implements Servlet 
{
    public void service(ServletRequest req, ServletResponse resp) 
    {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }
}
The transient state for a particular computation exists solely in local variables that are stored on the thread’s stack and are accessible only to the executing thread. One thread accessing a StatelessFactorizer cannot influence the result of another thread accessing the same StatelessFactorizer; because the two threads do not share state, it is as if they were accessing different instances. Since the actions of a thread accessing a stateless object cannot affect the correctness of operations in other threads, stateless objects are thread-safe.

That’s all for this small but important concept around What is Thread Safety?

</details>
<details><summary><b>[69 - Java ThreadLocal Variables – When and How to Use?]</b></summary>
	
#### Java ThreadLocal Variables – When and How to Use?

Today, one of the most critical aspects of a concurrent application is shared data. When you create thread that implements the Runnable interface and then start various Thread objects using the same Runnable object, all the threads share the same attributes that are defined inside the runnable object. This essentially means that if you change any attribute in a thread, all the threads will be affected by this change and will see the modified value by first thread. Sometimes it is desired behavior e.g. multiple threads increasing / decreasing the same counter variable; but sometimes you want to ensure that every thread MUST work on it’s own copy of thread instance and does not affect others data.
When to use ThreadLocal?
For example, consider you are working on a eCommerce application. You have a requirement to generate a unique transaction id for each and every customer request this controller process and you need to pass this transaction id to the business methods in manager/DAO classes for logging purpose. One solution could be passing this transaction id as a parameter to all the business methods. But this is not a good solution as the code is redundant and unnecessary.
To solve that, here you can use ThreadLocal variable. You can generate a transaction id in controller OR any pre-processor interceptor; and set this transaction id in the ThreadLocal. After this, whatever the methods, that this controller calls, they all can access this transaction id from the threadlocal. Also note that application controller will be servicing more that one request at a time and since each request is processed in separate thread at framework level, the transaction id will be unique to each thread and will be accessible from all over the thread’s execution path. 


<details><summary><b>[69.1 - Inside ThreadLocal Class?]</b></summary>
	
#### Inside ThreadLocal Class?
The Java Concurrency API provides a clean mechanism for thread-local variables using ThreadLocal class with a very good performance.
public class ThreadLocal<T> extends Object {...}
This class provides thread-local variables. These variables differ from their normal counterparts in that each thread that accesses one (via its get or set method) has its own, independently initialized copy of the variable. ThreadLocalinstances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or Transaction ID).
This class has following methods:
1.	get() : Returns the value in the current thread’s copy of this thread-local variable.
2.	initialValue() : Returns the current thread’s “initial value” for this thread-local variable.
3.	remove() : Removes the current thread’s value for this thread-local variable.
4.	set(T value) : Sets the current thread’s copy of this thread-local variable to the specified value.

</details>
<details><summary><b>[69.2 - How to use ThreadLocal?]</b></summary>
	
#### How to use ThreadLocal?
Below example uses two thread local variables i.e. threadId and startDate. Both have been defined as “private static” fields as recommended. ‘threadId‘ will be used to identify the thread which is currently running and ‘startDate‘ will be used to get the time when thread started it’s execution. Above information will be printed in console to verify that each thread has maintained it’s own copy of variables.
class DemoTask implements Runnable
{
   // Atomic integer containing the next thread ID to be assigned
   private static final AtomicInteger        nextId   = new AtomicInteger(0);
    
   // Thread local variable containing each thread's ID
   private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>()
                                                         {
                                                            @Override
                                                            protected Integer initialValue()
                                                            {
                                                               return nextId.getAndIncrement();
                                                            }
                                                         };
 
   // Returns the current thread's unique ID, assigning it if necessary
   public int getThreadId()
   {
      return threadId.get();
   }
   // Returns the current thread's starting timestamp
   private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>()
                                                 {
                                                    protected Date initialValue()
                                                    {
                                                       return new Date();
                                                    }
                                                 };
 
   
 
   @Override
   public void run()
   {
      System.out.printf("Starting Thread: %s : %s\n", getThreadId(), startDate.get());
      try
      {
         TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      System.out.printf("Thread Finished: %s : %s\n", getThreadId(), startDate.get());
   }
}
Now to verify that variables essentially are able to maintain their state irrespective of multiple initializations for multiple threads, let’s create three instances of this task; start the threads; and then verify the information they print in console.
Starting Thread: 0 : Wed Dec 24 15:04:40 IST 2014
Thread Finished: 0 : Wed Dec 24 15:04:40 IST 2014
 
Starting Thread: 1 : Wed Dec 24 15:04:42 IST 2014
Thread Finished: 1 : Wed Dec 24 15:04:42 IST 2014
 
Starting Thread: 2 : Wed Dec 24 15:04:44 IST 2014
Thread Finished: 2 : Wed Dec 24 15:04:44 IST 2014

In above output, sequence of printed statement will vary everytime. I have put them in sequence so that we can clearly identify that thread local values are kept safe for each thread instance; and never intermixed. Try yourself.

Most common use of thread local is when you have some object that is not thread-safe, but you want to avoid synchronizing access to that object using synchronized keyword/block. Instead, give each thread its own instance of the object to work with.

A good alternative to synchronization or threadlocal is to make the variable a local variable. Local variables are always thread safe. The only thing which may prevent you to do this is your application design constraints.

In wabapp server, it may be keep a thread pool, so a ThreadLocal var should be removed before response to the client, since current thread may be reused by next request. Also, if you do not clean up when you’re done, any references it holds to classes loaded as part of a deployed webapp will remain in the permanent heap and will never get garbage collected.
</details>
</details>
<details><summary><b>[72 - How to Use Locks in Java ]</b></summary>
	
How to Use Locks in Java | java.util.concurrent.locks.Lock Tutorial and Example

We are already aware of basic concepts around thread synchronization and various mechanisms using synchronized keyword. Java provides another mechanism for the synchronization of blocks of code based on the Lock interface and classes that implement it (such as ReentrantLock). In this tutorial, we will see a basic usage of Lock interface to solve printer queue problem.

Lock Interface

A java.util.concurrent.locks.Lock is a thread synchronization mechanism just like synchronized blocks. A Lock is, however, more flexible and more sophisticated than a synchronized block. Since Lock is an interface, you need to use one of its implementations to use a Lock in your applications. ReentrantLock is one such implementation of Lock interface.

Here is the simple use of Lock interface.

Lock lock = new ReentrantLock();
 
lock.lock();
 
//critical section
 
lock.unlock();
First a Lock is created. Then it’s lock() method is called. Now the Lock instance is locked. Any other thread calling lock() will be blocked until the thread that locked the lock calls unlock(). Finally unlock() is called, and the Lockis now unlocked so other threads can lock it.


<details><summary><b>[72.1 - Difference between Lock Interface and synchronized keyword]</b></summary>
	
#### Difference between Lock Interface and synchronized keyword
The main differences between a Lock and a synchronized block are:
1) Having a timeout trying to get access to a synchronized block is not possible. Using Lock.tryLock(long timeout, TimeUnit timeUnit), it is possible.
2) The synchronized block must be fully contained within a single method. A Lock can have it’s calls to lock() and unlock() in separate methods.
Simulating Printer Queue using Locks
In this example, program will simulate the behavior of a printer. You can submit a number of print jobs to printer during varying time interval or simultaneously. Printer will take a job from printer queue and print it. Rest of jobs will wait there for their turn. Once printer is done with print job in hand, it will pick another job from queue and start printing. Keep this happening in a loop.
PrintingJob.java
This class represents an independent printing which could be submitted to printer. This class implements Runnableinterface, so that printer can execute it when it’s turn come.
class PrintingJob implements Runnable
{
   private PrinterQueue printerQueue;
 
   public PrintingJob(PrinterQueue printerQueue)
   {
      this.printerQueue = printerQueue;
   }
 
   @Override
   public void run()
   {
      System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
      printerQueue.printJob(new Object());
   }
}
PrinterQueue.java
This class represent the printer queue/ printer. A lock is maintained by printer to start new print job as soon as current print job is finished.
class PrinterQueue
{
   private final Lock queueLock = new ReentrantLock();
 
   public void printJob(Object document)
   {
      queueLock.lock();
      try
      {
         Long duration = (long) (Math.random() * 10000);
         System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds :: Time - " + new Date());
         Thread.sleep(duration);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      } finally
      {
         System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
         queueLock.unlock();
      }
   }
}
Let’s test our printer program:
public class LockExample
{
   public static void main(String[] args)
   {
      PrinterQueue printerQueue = new PrinterQueue();
      Thread thread[] = new Thread[10];
      for (int i = 0; i < 10; i++)
      {
         thread[i] = new Thread(new PrintingJob(printerQueue), "Thread " + i);
      }
      for (int i = 0; i < 10; i++)
      {
         thread[i].start();
      }
   }
}
 
Output:
 
Thread 0: Going to print a document
Thread 9: Going to print a document
Thread 8: Going to print a document
Thread 7: Going to print a document
Thread 5: Going to print a document
Thread 6: Going to print a document
Thread 4: Going to print a document
Thread 3: Going to print a document
Thread 2: Going to print a document
Thread 1: Going to print a document
Thread 0: PrintQueue: Printing a Job during 8 seconds :: Time - Tue Jan 06 15:19:02 IST 2015
Thread 0: The document has been printed
Thread 9: PrintQueue: Printing a Job during 1 seconds :: Time - Tue Jan 06 15:19:11 IST 2015
Thread 9: The document has been printed
Thread 8: PrintQueue: Printing a Job during 8 seconds :: Time - Tue Jan 06 15:19:12 IST 2015
Thread 8: The document has been printed
Thread 7: PrintQueue: Printing a Job during 9 seconds :: Time - Tue Jan 06 15:19:21 IST 2015
Thread 7: The document has been printed
Thread 5: PrintQueue: Printing a Job during 7 seconds :: Time - Tue Jan 06 15:19:31 IST 2015
Thread 5: The document has been printed
Thread 6: PrintQueue: Printing a Job during 5 seconds :: Time - Tue Jan 06 15:19:39 IST 2015
Thread 6: The document has been printed
Thread 4: PrintQueue: Printing a Job during 2 seconds :: Time - Tue Jan 06 15:19:44 IST 2015
Thread 4: The document has been printed
Thread 3: PrintQueue: Printing a Job during 2 seconds :: Time - Tue Jan 06 15:19:46 IST 2015
Thread 3: The document has been printed
Thread 2: PrintQueue: Printing a Job during 5 seconds :: Time - Tue Jan 06 15:19:49 IST 2015
Thread 2: The document has been printed
Thread 1: PrintQueue: Printing a Job during 5 seconds :: Time - Tue Jan 06 15:19:54 IST 2015
Thread 1: The document has been printed

The key to the example is in the printJob() method of the PrinterQueue class. When we want to implement a critical section using locks and guarantee that only one execution thread runs a block of code, we have to create a ReentrantLock object. At the beginning of the critical section, we have to get the control of the lock using the lock() method.

At the end of the critical section, we have to use the unlock() method to free the control of the lock and allow the other threads to run this critical section. If you don’t call the unlock() method at the end of the critical section, the other threads that are waiting for that block will be waiting forever, causing a deadlock situation. If you use try-catch blocks in your critical section, don’t forget to put the sentence containing the unlock() method inside the finally section.

You have to be very careful with the use of Locks to avoid deadlocks . This situation occurs when two or more threads are blocked waiting for locks that never will be unlocked. For example, a thread (A) locks a Lock (X) and a thread (B) locks a Lock (Y). If now, the thread (A) tries to lock the Lock (Y) and the thread (B) simultaneously tries to lock the Lock (X), both threads will be blocked indefinitely, because they are waiting for locks that will never be liberated. Note that the problem occurs, because both threads try to get the locks in the opposite order.

Control concurrent access to multiple copies of a resource using Semaphore

In previous tutorial, we learned about binary semaphore which can be used to control access to single copy of a resource using the counter value either 0 or 1. However, semaphores can also be used when you need to protect various copies of a resource that can be executed by more than one thread at the same time. In this example, we will learn how to use a semaphore to protect more than one copy of a resource.

Let’s revisit semaphore concept before moving ahead.
</details>
</details>
<details><summary><b>[73 - How Semaphores Work?]</b></summary>
	
#### How Semaphores Work?
You can visualize a semaphore as counter which can be incremented or decremented. You initialize the semaphore with a number i.e. 5. Now this semaphore can be decremented maximum five times in a row until counter reaches to 0. Once counter is zero, you can increment it to maximum five times to make it 5. The counter value of semaphore MUST always be inside limit 0 >= n >= 5 (in our case).
Obviously, semaphores are more than just being counters. They are able to make threads wait when counter value is zero i.e. they act as Locks with counter functionality.
Talking in terms of multi-threading, when a thread wants to access one of shared resources (guarded by semaphore), first, it must acquire the semaphore. If the internal counter of the semaphore is greater than 0, the semaphore decrements the counter and allows access to the shared resource. Otherwise, if the counter of the semaphore is 0, the semaphore puts the thread to sleep until the counter is greater than 0. A value of 0 in the counter means all the shared resources are used by other threads, so the thread that wants to use one of them must wait until one is free.
When a thread has finished the use of the shared resource, it must release the semaphore so that the other threads can access the shared resource. That operation increases the internal counter of the semaphore.


<details><summary><b>[73.1 - How to use semaphore?]</b></summary>
	
#### How to use semaphore?
To demonstrate the concept, we will be using semaphore for controlling 3 printers which can print multiples documents simultaneously.
PrintingJob.java
This class represents an independent printing job which could be submitted to printer queue. And from queue, it can be picked up by any printer and performed printing job. This class implements Runnable interface, so that printer can execute it when it’s turn come.
class PrintingJob implements Runnable {
    private PrinterQueue printerQueue;
 
    public PrintingJob(PrinterQueue printerQueue) {
        this.printerQueue = printerQueue;
    }
 
    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread
                .currentThread().getName());
        printerQueue.printJob(new Object());
    }
}
PrinterQueue.java
This class represent the printer queue/ printer. This class has 3 main attributes which control the logic of selecting a free printer out of 3 printers and lock it for printing a job. After printing the document, printer is released so that it is again free and available for printing a new job from print queue.
This class has two methods getPrinter() and releasePrinter() which are responsible for acquiring a free printer and putting it back in free printers pool.
Another method printJob() actually does the core job i.e. acquiring a printer, execute print job and then release the printer.
It uses below two variables for doing the job:
semaphore : This variable keep track of no. of printers used at any point of time.
printerLock : Used for locking the printer pool before checking/acquiring a free printer out of three available printers.
class PrinterQueue 
{
    //This Semaphore will keep track of no. of printers used at any point of time.
    private final Semaphore semaphore;
     
    //While checking/acquiring a free printer out of three available printers, we will use this lock.
    private final Lock printerLock;
     
    //This array represents the pool of free printers.
    private boolean freePrinters[];
 
    public PrinterQueue() 
    {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        printerLock = new ReentrantLock();
    }
 
    public void printJob(Object document) 
    {
        try
        {
            //Decrease the semaphore counter to mark a printer busy
            semaphore.acquire();
             
            //Get the free printer
            int assignedPrinter = getPrinter();
             
            //Print the job
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName()
                    + ": Printer " + assignedPrinter
                    + " : Printing a Job during " + (duration / 1000)
                    + " seconds :: Time - " + new Date());
            Thread.sleep(duration);
             
            //Printing is done; Free the printer to be used by other threads.
            releasePrinter(assignedPrinter);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        } 
        finally {
            System.out.printf("%s: The document has been printed\n", Thread
                    .currentThread().getName());
             
            //Increase the semaphore counter back
            semaphore.release();
        }
    }
 
    //Acquire a free printer for printing a job
    private int getPrinter() 
    {
        int foundPrinter = -1;
        try {
            //Get a lock here so that only one thread can go beyond this at a time
            printerLock.lock();
             
            //Check which printer is free
            for (int i = 0; i < freePrinters.length; i++) 
            {
                //If free printer found then mark it busy
                if (freePrinters[i]) 
                {
                    foundPrinter = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            //Allow other threads to check for free priniter
            printerLock.unlock();
        }
        return foundPrinter;
    }
     
    //Release the printer
    private void releasePrinter(int i) {
        printerLock.lock();
        //Mark the printer free
        freePrinters[i] = true;
        printerLock.unlock();
    }
}
Let’s test our printer program:
public class SemaphoreExample 
{
    public static void main(String[] args) 
    {
        PrinterQueue printerQueue = new PrinterQueue();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) 
        {
            thread[i] = new Thread(new PrintingJob(printerQueue), "Thread " + i);
        }
        for (int i = 0; i < 10; i++) 
        {
            thread[i].start();
        }
    }
}
 
Output:
 
Thread 1: Going to print a document
Thread 4: Going to print a document
Thread 9: Going to print a document
Thread 8: Going to print a document
Thread 6: Going to print a document
Thread 7: Going to print a document
Thread 2: Going to print a document
Thread 5: Going to print a document
Thread 3: Going to print a document
Thread 0: Going to print a document
Thread 9: PrintQueue 2 : Printing a Job during 2 seconds :: Time - Tue Jan 13 16:28:58 IST 2015
Thread 4: PrintQueue 1 : Printing a Job during 7 seconds :: Time - Tue Jan 13 16:28:58 IST 2015
Thread 1: PrintQueue 0 : Printing a Job during 1 seconds :: Time - Tue Jan 13 16:28:58 IST 2015
Thread 1: The document has been printed
Thread 8: PrintQueue 0 : Printing a Job during 1 seconds :: Time - Tue Jan 13 16:29:00 IST 2015
Thread 9: The document has been printed
Thread 6: PrintQueue 2 : Printing a Job during 0 seconds :: Time - Tue Jan 13 16:29:01 IST 2015
Thread 6: The document has been printed
Thread 7: PrintQueue 2 : Printing a Job during 4 seconds :: Time - Tue Jan 13 16:29:01 IST 2015
Thread 8: The document has been printed
Thread 2: PrintQueue 0 : Printing a Job during 5 seconds :: Time - Tue Jan 13 16:29:02 IST 2015
Thread 7: The document has been printed
Thread 5: PrintQueue 2 : Printing a Job during 8 seconds :: Time - Tue Jan 13 16:29:05 IST 2015
Thread 4: The document has been printed
Thread 3: PrintQueue 1 : Printing a Job during 4 seconds :: Time - Tue Jan 13 16:29:06 IST 2015
Thread 2: The document has been printed
Thread 0: PrintQueue 0 : Printing a Job during 4 seconds :: Time - Tue Jan 13 16:29:08 IST 2015
Thread 3: The document has been printed
Thread 0: The document has been printed
Thread 5: The document has been printed
In above example, the Semaphore object is created using 3 as the parameter of the constructor. The first three threads that call the acquire() method will get the access to printers while the rest will be blocked. When a thread finishes the critical section and releases the semaphore, another thread will acquire it.
In the printJob() method, the thread gets the index of the printer assigned to print this job.
That’s all for this simple yet important concept. Drop me your questions and comments if any.
</details>
</details>
<details><summary><b>[76 - Concurrency vs. Parallelism]</b></summary>
	
#### Concurrency vs. Parallelism

Concurrency means multiple tasks which start, run, and complete in overlapping time periods, in no specific order. Parallelism is when multiple tasks OR several part of a unique task literally run at the same time, e.g. on a multi-core processor. Remember that Concurrency and parallelism are NOT the same thing.

Let’s understand more in detail that what I mean when I say Concurrency vs. Parallelism.

- Concurrency

Concurrency is essentially applicable when we talk about minimum two tasks or more. When an application is capable of executing two tasks virtually at same time, we call it concurrent application. Though here tasks run looks like simultaneously, but essentially they MAY not. They take advantage of CPU time-slicing feature of operating system where each task run part of its task and then go to waiting state. When first task is in waiting state, CPU is assigned to second task to complete it’s part of task.

Operating system based on priority of tasks, thus, assigns CPU and other computing resources e.g. memory; turn by turn to all tasks and give them chance to complete. To end user, it seems that all tasks are running in parallel. This is called concurrency.

- Parallelism

Parallelism does not require two tasks to exist. It literally physically run parts of tasks OR multiple tasks, at the same time using multi-core infrastructure of CPU, by assigning one core to each task or sub-task.
Parallelism requires hardware with multiple processing units, essentially. In single core CPU, you may get concurrency but NOT parallelism.

<details><summary><b>[76.1 - Differences between concurrency vs. parallelism]</b></summary>
	
#### Differences between concurrency vs. parallelism

Now let’s list down remarkable differences between concurrency and parallelism.

Concurrency is when two tasks can start, run, and complete in overlapping time periods. Parallelism is when tasks literally run at the same time, eg. on a multi-core processor.

Concurrency is the composition of independently executing processes, while parallelism is the simultaneous execution of (possibly related) computations.

Concurrency is about dealing with lots of things at once. Parallelism is about doing lots of things at once.
An application can be concurrent – but not parallel, which means that it processes more than one task at the same time, but no two tasks are executing at same time instant.

An application can be parallel – but not concurrent, which means that it processes multiple sub-tasks of a task in multi-core CPU at same time.

An application can be neither parallel – nor concurrent, which means that it processes all tasks one at a time, sequentially.
An application can be both parallel – and concurrent, which means that it processes multiple tasks concurrently in multi-core CPU at same time .

That’s all about Concurrency vs. Parallelism, a very important concept in java multi-threading concepts.

You may have faced this question in your interview that what is the difference between lock and a monitor? Well, to answer this question you must have good amount of understanding of how java multi-threading works under the hood.

Short answer, locks provide necessary support for implementing monitors. Long answer read below.

- Locks

A lock is kind of data which is logically part of an object’s header on the heap memory. Each object in a JVM has this lock (or mutex) that any program can use to coordinate multi-threaded access to the object. If any thread want to access instance variables of that object; then thread must “own” the object’s lock (set some flag in lock memory area). All other threads that attempt to access the object’s variables have to wait until the owning thread releases the object’s lock (unset the flag).
Once a thread owns a lock, it can request the same lock again multiple times, but then has to release the lock the same number of times before it is made available to other threads. If a thread requests a lock three times, for example, that thread will continue to own the lock until it has “released” it three times.
Please note that lock is acquired by a thread, when it explicitly ask for it. In Java, this is done with the synchronized keyword, or with wait and notify.
</details>
</details>
<details><summary><b>[78 - Monitors]</b></summary>
	
#### Monitors
Monitor is a synchronization construct that allows threads to have both mutual exclusion (using locks) and cooperation i.e. the ability to make threads wait for certain condition to be true (using wait-set).
In other words, along with data that implements a lock, every Java object is logically associated with data that implements a wait-set. Whereas locks help threads to work independently on shared data without interfering with one another, wait-sets help threads to cooperate with one another to work together towards a common goal e.g. all waiting threads will be moved to this wait-set and all will be notified once lock is released. This wait-set helps in building monitors with additional help of lock (mutex).

</details>
<details><summary><b>[79 - Mutual exclusion]</b></summary>
	
#### Mutual exclusion
Putting in very simple words, a monitor is like a building that contains one special room (object instance) that can be occupied by only one thread at a time. The room usually contains some data which needs to be protected from concurrent access. From the time a thread enters this room to the time it leaves, it has exclusive access to any data in the room. Entering the monitor building is called “entering the monitor.” Entering the special room inside the building is called “acquiring the monitor.” Occupying the room is called “owning the monitor,” and leaving the room is called “releasing the monitor.” Leaving the entire building is called “exiting the monitor.”

When a thread arrives to access protected data (enter the special room), it is first put in queue in building reception (entry-set). If no other thread is waiting (own the monitor), the thread acquires the lock and continues executing the protected code. When the thread finishes execution, it release the lock and exits the building (exiting the monitor).

If when a thread arrives and another thread is already owning the monitor, it must wait in reception queue (entry-set). When the current owner exits the monitor, the newly arrived thread must compete with any other threads also waiting in the entry-set. Only one thread will win the competition and own the lock.
There is no role of wait-set feature.

</details>
<details><summary><b>[80 - Cooperation]</b></summary>
	
#### Cooperation
In general, mutual exclusion is important only when multiple threads are sharing data or some other resource. If two threads are not working with any common data or resource, they usually can’t interfere with each other and needn’t execute in a mutually exclusive way. Whereas mutual exclusion helps keep threads from interfering with one another while sharing data, cooperation helps threads to work together towards some common goal.

Cooperation is important when one thread needs some data to be in a particular state and another thread is responsible for getting the data into that state e.g. producer/consumer problem where read thread needs the buffer to be in a “not empty” state before it can read any data out of the buffer. If the read thread discovers that the buffer is empty, it must wait. The write thread is responsible for filling the buffer with data. Once the write thread has done some more writing, the read thread can do some more reading. It is also sometimes called a “Wait and Notify” OR “Signal and Continue” monitor because it retains ownership of the monitor and continues executing the monitor region (the continue) if needed. At some later time, the notifying thread releases the monitor and a waiting thread is resurrected to own the lock.

This cooperation requires both i.e. entry-set and wait-set. Below given diagram will help you in understand this cooperation.
 
Above figure shows the monitor as three rectangles. In the center, a large rectangle contains a single thread, the monitor’s owner. On the left, a small rectangle contains the entry set. On the right, another small rectangle contains the wait set.

</details>
</details>
<details><summary><b>[81 - Java Concurrent Collections]</b></summary>
	
#### Java Concurrent Collections
java.util.concurrent package is to enable developers write better concurrent Java applications. This concurrent package includes some additions to the Java Collections Framework. These are called as Java Concurrent Collections.

I have been writing a tutorial series about those classes in the past few weeks. This article is a summary and index of those Java concurrent collection classes. Those collections classes can be classified as Queue based and Map based.
 
Java Concurrent Collection Classes

•	BlockingQueue – an interface that is at the base of all Queuebased concurrent collections. While adding an element to a BlockingQueue, if there is no space it can wait till it becomes available and when retrieving, it will wait till an element is available if it is empty.
•	ArrayBlockingQueue – a blocking queue class based on bounded Java Array. Once instantiated, cannot be resized.
•	SynchronousQueue – a blocking queue class with capacity of zero always.
•	PriorityBlockingQueue – a priority queue based blocking queue. It is an unbounded concurrent collection.
•	LinkedBlockingQueue – an optionally bounded Java concurrent collection. Orders elements based on FIFO order.
•	DelayQueue – a queue where only delay expired elements can be taken out. Its an unbounded concurrent collection.
•	BlockingDeque – an interface that extends BlockingQueueand adds the operations of Deque.
•	LinkedBlockingDeque – an implementation class of BlockingDequeue.
•	TransferQueue – a Java concurrent collection interface that extends BlockingQueue and adds method where the producer will wait for the consumer to receive elements.
•	LinkedTransferQueue – an implementation class of TransferQueue.
•	ConcurrentMap – a Java concurrent collection interface and a type of Map which provides thread safety and atomicity guarantees.
•	ConcurrentHashMap – an implementation class of ConcurrentMap.
•	ConcurrentNavigableMap – a Java concurrent collection interface that extends ConcurrentMap and adds operations of NavigableMap.
•	ConcurrentSkipListMap – an implementation class of ConcurrentNavigableMap.

<details><summary><b>[81.1 - Java BlockingQueue]</b></summary>
	
#### Java BlockingQueue
BlockingQueue Collection is a type of Java Queue. BlockingQueue is part of Java concurrent util package. It is best used in multi threading and producer-consumer scenarios. While adding an element to a a BlockingQueue, if there is no space it can wait till it becomes available. Similarly while retrieving, it will wait till an element is available if it is empty.
 
BlockingQueue Methods
	Throws exception	Returns value	Blocks	Timed
Insert	add(e)	offer(e)	put(e)	offer(e, time, unit)
Remove	remove()	poll()	take()	poll(time, unit)
Examine	element()	peek()	not applicable	not applicable
There are four types of methods available for each operations like insert, remove and examine in a BlockingQueue. The respective type of method has to be chosen according to our use case requirement.
1.	Throws exception – when an insert is performed if there is no space an exception is thrown.
2.	Returns value – returns a value like true or false. false means insufficient space and true means successful insertion
3.	Blocks – blocks the thread till the space is available
4.	Timed – waits for the specified amount of time
These methods are used in a multi-threaded scenario. BlockingQueue extends the Collection interface and so an implementation of a BlockingQueue will contain the standard collection methods as well. For example removing an element can be done using remove(index). BlockingQueue is always best used in a threaded scenario.
All these methods are guaranteed to be thread-safe. Other standard methods that are part of the collection may or may not be thread-safe and the choice is left to the implementation.

</details>
<details><summary><b>[81.2 - BlockingQueue Implementation in JDK]</b></summary>
	
#### BlockingQueue Implementation in JDK
BlockingQueue is an interface. Either we should go for custom implementation or choose the existing implementations from the Java JDK. Following the different implementations available for the BlockingQueue in Java.
•	ArrayBlockingQueue
•	DelayQueue
•	LinkedBlockingDeque
•	LinkedBlockingQueue
•	LinkedTransferQueue
•	PriorityBlockingQueue
•	SynchronousQueue
Following posts will have examples on implementing BlockingQueue using the above JDK BlockingQueue implementations and a custom implementation for BlockingQueue as well.
- Java ArrayBlockingQueue
This Java tutorial is to discuss about ArrayBlockingQueue which is an implementation for a Java BlockingQueue Collection. We will see a producer consumer based example using ArrayBlockingQueue to understand the BlockingQueue interface.
ArrayBlockingQueue is based on a bounded Java array. Bounded means it will have a fixed size, once created it cannot be resized. This fixed size collection can be understood using this Java List size puzzle.
ArrayBlockingQueue uses the “Blocking” type method from the four available types described in the Java BlockingQueue tutorial. Attempt to put into the empty ArrayBlockingQueue and take will be blocking the thread.
BlockingQueueProducer.java
This is a producer which produces three string values and put() to the BlockingQueue. These three elements are produced between varied intervals.
package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public BlockingQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	public void run() {
		try {
			Thread.sleep(500);			
			blockingQueue.put("Lion");
			Thread.sleep(1000);
			blockingQueue.put("Crocodile");
			Thread.sleep(2000);
			blockingQueue.put("Jaguar");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
BlockingQueueConsumer.java
This is a consumer which consumes string values by take() from the BlockingQueue. These elements are consumed based on their availability from the producer.
package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable {
	protected BlockingQueue<String> blockingQueue;

	public BlockingQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	public void run() {
		try {
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
BlockingQueueExample.java
package com.javapapers.java.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
	public static void main(String[] args) throws Exception {

		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1024);

		BlockingQueueProducer queueProducer = new BlockingQueueProducer(blockingQueue);
		BlockingQueueConsumer queueConsumer = new BlockingQueueConsumer(blockingQueue);

		new Thread(queueProducer).start();
		new Thread(queueConsumer).start();
	}
}
Example Program Output
Lion
Crocodile
Jaguar

</details>
<details><summary><b>[81.3 - Java DelayQueue]</b></summary>
	
#### Java DelayQueue
	 
Java DelayQueue is a collection and an implementation of BlockingQueue. Unlike ArrayBlockingQueue, DelayQueue is an unbounded collection. The BlockingQueue methods are implemented in such a way that only delay expired elements can be taken out of the queue. If the delay has not expired for any elements in the queue then the pollmethod will return null.
Element Expiry
Expiry of an element is decided using the getDelay() method of the element. When it returns a value less than or equal to zero that element is considered to be expired.
For this expiry based DelayQueue to work, elements stored should implement the Delayed interface which looks as below,
package java.util.concurrent;

public interface Delayed extends Comparable {

    long getDelay(TimeUnit unit);
}
Delayed interface extends the Comparable interface and so the elements can be compared with one another. They may be used to order the elements in the DelayQueue instance.
Delayed Element Example
package com.javapapers.java.collections;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayElement implements Delayed {
	private String element;
	private long expiryTime;

	public DelayElement(String element, long delay) {
		this.element = element;
		this.expiryTime = System.currentTimeMillis() + delay;
	}

	@Override
	public long getDelay(TimeUnit timeUnit) {
		long diff = expiryTime - System.currentTimeMillis();
		return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if (this.expiryTime < ((DelayElement) o).expiryTime) {
			return -1;
		}
		if (this.expiryTime > ((DelayElement) o).expiryTime) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return element + ": " + expiryTime;
	}
}
size() method returns the overall count of elements in the queue which includes the expired elements also. iterator() method of this class does not guarantee traversal of the queue in any particular order.
DelayQueue Producer
Following class a typical producer in a producer-consumer scenario which puts a delay element into a DelayQueue.
package com.javapapers.java.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayQueueProducer implements Runnable {

	protected BlockingQueue<DelayElement> blockingQueue;
	final Random random = new Random();

	public DelayQueueProducer(BlockingQueue<DelayElement> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int delay = random.nextInt(10000);
				DelayElement delayElement = new DelayElement(UUID.randomUUID()
						.toString(), delay);
				System.out.println("Put: "+ delayElement);
				blockingQueue.put(delayElement);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
DelayQueue Consumer
Following class a typical consumer in a producer-consumer scenario which takes elements from a DelayQueue.
package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;

public class DelayQueueConsumer implements Runnable {

	protected BlockingQueue<DelayElement> blockingQueue;

	public DelayQueueConsumer(BlockingQueue<DelayElement> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				DelayElement delayElement = blockingQueue.take();
				System.out.println(Thread.currentThread().getName()
						+ " take(): " + delayElement);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
DelayQueue Example
package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueExample {
	public static void main(String[] args) {
		final BlockingQueue<DelayElement> queue = new DelayQueue<DelayElement>();

		DelayQueueProducer queueProducer = new DelayQueueProducer(queue);
		new Thread(queueProducer).start();

		DelayQueueConsumer queueConsumer1 = new DelayQueueConsumer(queue);
		new Thread(queueConsumer1).start();

		DelayQueueConsumer queueConsumer2 = new DelayQueueConsumer(queue);
		new Thread(queueConsumer2).start();

	}
}
DelayQueue Example Output
Put: 24c502c6-40b9-43fa-8f75-12456a8fde61: 1412489289963
Put: 2eef0e9a-cffd-4110-ad53-d1d2afc0d22e: 1412489294635
Put: 110a210c-c7eb-46c8-bb0f-60f83b04024d: 1412489298572
Thread-1 take(): 24c502c6-40b9-43fa-8f75-12456a8fde61: 1412489289963
Put: 120c5cbe-ee74-41f7-82ec-b26e8819e076: 1412489297235
Put: aad3878e-02a7-4adb-ad0b-890860c1a7c8: 1412489294320
Put: a9a20938-b10b-4955-be85-6b9d88b85728: 1412489293823
Put: 218e8793-7a7f-4036-93eb-57ceaba56a53: 1412489299133
Put: 9a90c990-e0c9-4fc5-b461-746527b17387: 1412489299239
Put: 863b3455-48c4-496b-98f9-cfd12a8cafe9: 1412489296604
Put: a97b24c5-ac61-44a3-bdce-f5b88a87bda3: 1412489297165
Put: 6d8e8e3b-d3fa-469e-8efb-220255384787: 1412489297026
Thread-2 take(): a9a20938-b10b-4955-be85-6b9d88b85728: 1412489293823
Put: 9e698e44-d9d7-4aa3-8edc-ada120813a20: 141248929612

Java LinkedBlockingQueue

This Java tutorial is to learn about the collection LinkedBlockingQueue which is an implementation of Java BlockingQueue. 

LinkedBlockingQueue order elements first-in-first-out (FIFO). With respect to bounds of the LinkedBlockingQueue, it stands in between ArrayBlockingQueue and DelayQueue.
•	ArrayBlockingQueue is a bounded collection.
•	DelayQueue is an unbounded collection.
•	LinkedBlocingQueue is an optionally bounded collection.

LinkeBlockingQueue has an aditional constructor which provides the capability to instantiate with fixed capacity. If not the other regular argument-less constructor creates instance with Integer.MAX_VALUEcapacity.

poll and offer method behaves as defined in BlockingQueue. poll method without argument retrieves the head element from the queue. poll method with timeout argument removes the head element by waiting for the time specified if the element is not available.

LinkedBlocingQueue Example

We will see a standard producer-consumer scenario example to understand the LinkeBlockingQueue.

LinkedBlockingQueueProducer.java
package com.javapapers.java.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class LinkedBlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;
	final Random random = new Random();

	public LinkedBlockingQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

LinkedBlockingQueueConsumer.java

package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;

public class LinkedBlockingQueueConsumer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public LinkedBlockingQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = blockingQueue.take();
				System.out.println(Thread.currentThread().getName()
						+ " take(): " + data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

LinkedBlockingQueueExample.java

package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {
	public static void main(String[] args) {
		final BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();

		LinkedBlockingQueueProducer queueProducer = new LinkedBlockingQueueProducer(
				linkedBlockingQueue);
		new Thread(queueProducer).start();

		LinkedBlockingQueueConsumer queueConsumer1 = new LinkedBlockingQueueConsumer(
				linkedBlockingQueue);
		new Thread(queueConsumer1).start();

		LinkedBlockingQueueConsumer queueConsumer2 = new LinkedBlockingQueueConsumer(
				linkedBlockingQueue);
		new Thread(queueConsumer2).start();

	}
}
LinkedBlockingQueue Example Output
Put: f1ef7505-6fe5-436c-893a-dd6ab8ecdba4
Thread-1 take(): f1ef7505-6fe5-436c-893a-dd6ab8ecdba4
Put: 8c86787c-a7bf-4124-b0c4-c62a195f9096
Thread-2 take(): 8c86787c-a7bf-4124-b0c4-c62a195f9096
Put: c5248f9b-17c0-41f6-a071-fecaa1dd21d3
Thread-1 take(): c5248f9b-17c0-41f6-a071-fecaa1dd21d3
Put: 05e7243e-62d4-4f32-9c9b-4b811245c571
Thread-2 take(): 05e7243e-62d4-4f32-9c9b-4b811245c571
Put: 7848bb81-a0f4-423c-b093-21db9d4412b1
Thread-1 take(): 7848bb81-a0f4-423c-b093-21db9d4412b1

Java PriorityBlockingQueue

Java PriorityBlockingQueue is a concurrent collection and an implementation of BlockingQueue. PriorityBlockingQueue is an unbounded collection. Ordering of elements in the PriorityBlockingQueue is done same as in PriorityQueue.

We should see PriorityBlockingQueue as a PriorityQueuewith added operations for blocking retrieval. All the rules of PriorityQueue applies here like elements are ordered based on their priority level among the elements.

PriorityBlockingQueue Example

Let us have a look at a producer-consumer based example to understand the PriorityBlockingQueue.

PriorityBlockingQueueProducer.java

package com.javapapers.java.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class PriorityBlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;
	final Random random = new Random();

	public PriorityBlockingQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
PriorityBlockingQueueConsumer.java
package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;

public class PriorityBlockingQueueConsumer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public PriorityBlockingQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = blockingQueue.take();
				System.out.println(Thread.currentThread().getName()
						+ " take(): " + data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
PriorityBlockingQueueExample.java
package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PriorityBlockingQueueExample {
	public static void main(String[] args) {
		final BlockingQueue<String> priorityBlockingQueue = new LinkedBlockingQueue<String>();

		PriorityBlockingQueueProducer queueProducer = new PriorityBlockingQueueProducer(
				priorityBlockingQueue);
		new Thread(queueProducer).start();

		PriorityBlockingQueueConsumer queueConsumer1 = new PriorityBlockingQueueConsumer(
				priorityBlockingQueue);
		new Thread(queueConsumer1).start();

		PriorityBlockingQueueConsumer queueConsumer2 = new PriorityBlockingQueueConsumer(
				priorityBlockingQueue);
		new Thread(queueConsumer2).start();

	}
}
PriorityBlockingQueue Example Output
Put: ebc55884-84d7-4621-b3d7-2e7c9c428a13
Thread-1 take(): ebc55884-84d7-4621-b3d7-2e7c9c428a13
Put: 1f8e4b4e-03df-4068-a2e1-423f1f6091a1
Thread-2 take(): 1f8e4b4e-03df-4068-a2e1-423f1f6091a1
Put: 55a38169-24a1-459b-ad1a-51b0ba36a7b8
Thread-1 take(): 55a38169-24a1-459b-ad1a-51b0ba36a7b8
Put: 84af8597-2796-4050-8c19-711d68f8ce6b
Thread-2 take(): 84af8597-2796-4050-8c19-711d68f8ce6b
Put: 3cb2bcae-8a71-4d75-96bb-72549ffd6283
Thread-1 take(): 3cb2bcae-8a71-4d75-96bb-72549ffd6283

</details>
<details><summary><b>[81.4 - Java SynchronousQueue]</b></summary>
	
#### Java SynchronousQueue
This Java tutorial is to learn about the concurrent collection SynchronousQueue. It is an implementation of BlockingQueue. Among all Java concurrent collections, SynchronousQueue is different. Capacity of a synchrounous queue is always zero. It is because in SynchronousQueue an insert will wait for a remove operation by another thread and vice versa.
put() call to a SynchronousQueue will not return until there is a corresponding take() call.
•	peek is not possible with a SynchronousQueue
•	As there is no element iteration is also not possible.
•	Insert is not possible if there is a thread trying to remove it.
•	SynchronousQueue should be imagined like a baton in a relay race.
•	If there are more than one thread waiting for a  removal so that they can do insert then with fairness set to true, threads are granted access in FIFO order.
•	SynchronousQueue is the default BlockingQueue used for the Executors.newCachedThreadPool() methods.

SynchronousQueue Example

Let us have a look at a producer-consumer based example to understand the SynchronousQueue.

SynchronousQueueProducer.java

package com.javapapers.java.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class SynchronousQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;
	final Random random = new Random();

	public SynchronousQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

SynchronousQueueConsumer.java

package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;

public class SynchronousQueueConsumer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public SynchronousQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = blockingQueue.take();
				System.out.println(Thread.currentThread().getName()
						+ " take(): " + data);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

SynchronousQueueExample.java

package com.javapapers.java.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
	public static void main(String[] args) {
		final BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>();

		SynchronousQueueProducer queueProducer = new SynchronousQueueProducer(
				synchronousQueue);
		new Thread(queueProducer).start();

		SynchronousQueueConsumer queueConsumer1 = new SynchronousQueueConsumer(
				synchronousQueue);
		new Thread(queueConsumer1).start();

		SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(
				synchronousQueue);
		new Thread(queueConsumer2).start();

	}
}
SynchronousQueueExample Example Output
Put: 4c34138b-51dd-4c2c-9633-87a147253978
Thread-2 take(): 4c34138b-51dd-4c2c-9633-87a147253978
Put: 39682e81-9ba8-4b29-a37e-3dc4d5cdb1f7
Thread-1 take(): 39682e81-9ba8-4b29-a37e-3dc4d5cdb1f7
Put: e21dbfd2-d007-43d2-9733-cb10ce683d81
Thread-2 take(): e21dbfd2-d007-43d2-9733-cb10ce683d81
Put: 556c5584-7154-4117-a0f4-f52ec8dcfad8
Thread-1 take(): 556c5584-7154-4117-a0f4-f52ec8dcfad8
Put: 1da7f16c-c030-44ed-be02-8983b7387497
Thread-2 take(): 1da7f16c-c030-44ed-be02-8983b7387497

</details>
<details><summary><b>[81.5 - Java TransferQueue]</b></summary>
	
#### Java TransferQueue
This Java tutorial is to learn about TransferQueue which is concurrent collection. TransferQueue is an interface and a type of BlockingQueue. TransferQueue extends from BlockingQueue interface to add behavior to it. In a TransferQueue producers may wait for consumers to receive elements. TransferQueue was added in Java SE 7.
This is marginally similar to the SynchronousQueue. In a SynchronousQueue the producer will always wait for a consumer. Once there is a consumer ready, the producer will push the item into the SynchrounousQueue and the item will be immediately consumed. So at any instance the queue length will always be zero.
In the case of TransferQueue, the producer with wait for the consumer to receive elements. The limit can be specified. Here the item can stay in the queue. This queue is useful in messaging applications. TransferQueue can be used as a pipeline to pass messages between channels.
Difference between BlockingQueue and TransferQueue
•	In BlockingQueue, we can put element into the queue and block if the queue reaches its limit.
•	In TransferQueue, we can additionally block until a thread consumes the element using the transfer method.
•	TransferQueue extends the BlockingQueue.
LinkedTransferQueue is an unbounded TranserQueue implementation available with the SDK.

</details>
<details><summary><b>[81.6 - Java LinkedTransferQueue]</b></summary>
	
#### Java LinkedTransferQueue
This Java tutorial is to learn about the LinkedTransferQueue. It is an implementation of TransferQueue and available in the Java SE API. This class is part of the Java collections framework. LinkedTransferQueue is an unbounded TransferQueue based on linked nodes. A producer will wait for the consumer to consume the elements in this queue.
LinkedTransferQueue was introduced in Java SE7 along with the TransferQueue. This queue is one of the most capable implementation in the concurrent collections. TransferQueue entends the BlockingQueue thus the LinkedTransferQueue has additional methods of the TransferQueue also.


LinkedTransferQueue Example
Following example for LinkedTransferQueue is based on the classic producer consumer use case. Producer waits for the consumer and pushes the element to the LinkedTransferQueue and hence consumed.
LinkedTransferQueueProducer.java
package com.javapapers.java.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueProducer implements Runnable {

	protected TransferQueue<String> transferQueue;
	final Random random = new Random();

	public LinkedTransferQueueProducer(TransferQueue<String> queue) {
		this.transferQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				transferQueue.transfer(data);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
LinkedTransferQueueConsumer.java
package com.javapapers.java.collections;

import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueConsumer implements Runnable {

	protected TransferQueue<String> transferQueue;

	public LinkedTransferQueueConsumer(TransferQueue<String> queue) {
		this.transferQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = transferQueue.take();
				System.out.println(Thread.currentThread().getName()
						+ " take(): " + data);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
LinkedTransferQueueExample.java
package com.javapapers.java.collections;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueExample {
	public static void main(String[] args) {
		final TransferQueue<String> transferQueue = new LinkedTransferQueue<String>();

		LinkedTransferQueueProducer queueProducer = new LinkedTransferQueueProducer(
				transferQueue);
		new Thread(queueProducer).start();

		LinkedTransferQueueConsumer queueConsumer1 = new LinkedTransferQueueConsumer(
				transferQueue);
		new Thread(queueConsumer1).start();

		LinkedTransferQueueConsumer queueConsumer2 = new LinkedTransferQueueConsumer(
				transferQueue);
		new Thread(queueConsumer2).start();

	}
}
Example Output
Put: d9458fb8-ae52-499c-aac6-06f57cf2b4fd
Thread-2 take(): d9458fb8-ae52-499c-aac6-06f57cf2b4fd
Put: e29e0991-5def-46c8-bb09-2cf6fd55afed
Thread-1 take(): e29e0991-5def-46c8-bb09-2cf6fd55afed
Put: 6df9a70f-987c-4298-ba56-4d7fe3fa8e06
Thread-2 take(): 6df9a70f-987c-4298-ba56-4d7fe3fa8e06
Put: a1080f5f-8f33-43fe-905e-6b6c4e7cba1f
Thread-1 take(): a1080f5f-8f33-43fe-905e-6b6c4e7cba1f
Put: cd2af5c3-725c-40b6-b04a-b715187c9c1c
Thread-2 take(): cd2af5c3-725c-40b6-b04a-b715187c9c1c

</details>
<details><summary><b>[81.7 - Java BlockingDeque]</b></summary>
	
#### Java BlockingDeque
BlockingDeque is an interface that extends Deque and BlockingQueue. It combines both the operations of Deque and BlockingQueue.
A Deque is a double ended queue. It is a linear collection of elements wherein elements can be inserted and removed from both the ends.
BlockingQueue is a queue that supports blocking operations for that will wait for the queue to become non-empty when retrieving element from it and wait for space to become available when inserting elements.
BlockingDeque is a double ended queue that supports blocking operations as well.
BlockingDeque Operations
Following are the four types of operations available for each operations insert, remove and get for both ends of the queue.
Following table illustrates the head based operations on the Dequeue
	Throws exception	Returns value	Blocks	Timed
Insert	addFirst(e)	offerFirst(e)	putFirst(e)	offerFirst(e, time, unit)
Remove	removeFirst()	pollFirst()	takeFirst()	pollFirst(time, unit)
Examine	getFirst()	peekFirst()	not applicable	not applicable
Following table illustrates the tail based operations on the Dequeue
	Throws exception	Returns value	Blocks	Timed
Insert	addLast(e)	offerLast(e)	putLast(e)	offerLast(e, time, unit)
Remove	removeLast()	pollLast()	takeLast()	pollLast(time, unit)
Examine	getLast()	peekLast()	not applicable	not applicable
BlockingDeque implementation in JDK
BlockingDeque is an interface. Either we should write our own implementation or use an existing implementation from JDK. LinkedBlockingDeque is an implementation of BlockingDeque available in JDK. In the next Java tutorial we will see about LinkedBlockingDeque in detail.

</details>
<details><summary><b>[81.8 - Java LinkedBlockingDeque]</b></summary>
	
#### Java LinkedBlockingDeque
This Java tutorial is to learn about the concurrent collection LinkedBlockingDeque. It is an optionally bounded blocking double ended queue. LinkedBlockingDeque is an implementation of the interface Java BlockingDeque.
LinkedBlockingDeque provides a constructor which can be used to specify the capacity and limit the number of elements that can be added to the queue.
LinkedBlockingDeque Example
Following example for LinkedBlockingDeque is based on a producer consumer scenario.
LinkedBlockingDequeProducer.java
package com.javapapers.java.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingDeque;

public class LinkedBlockingDequeProducer implements Runnable {
    protected BlockingDeque<String> blockingDeque;
    final Random random = new Random();

    public LinkedBlockingDequeProducer(BlockingDeque<String> queue) {
        this.blockingDeque = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = UUID.randomUUID().toString();
                System.out.println("Put: " + data);
                blockingDeque.addFirst(data);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
LinkedBlockingDequeConsumer.java
package com.javapapers.java.collections;

import java.util.concurrent.BlockingDeque;

public class LinkedBlockingDequeConsumer implements Runnable {

    protected BlockingDeque<String> blockingDeque;

    public LinkedBlockingDequeConsumer(BlockingDeque<String> queue) {
        this.blockingDeque = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = blockingDeque.takeFirst();
                System.out.println(Thread.currentThread().getName()
                        + " take(): " + data);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
LinkedBlockingDequeExample.java
package com.javapapers.java.collections;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeExample {
    public static void main(String[] args) {
        final BlockingDeque<String> priorityBlockingQueue = new LinkedBlockingDeque<String>();

        LinkedBlockingDequeProducer queueProducer = new LinkedBlockingDequeProducer(
                priorityBlockingQueue);
        new Thread(queueProducer).start();

        LinkedBlockingDequeConsumer queueConsumer1 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer1).start();

        LinkedBlockingDequeConsumer queueConsumer2 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer2).start();
    }
}

LinkedBlockingDeque Example Output
Put: e4be54ce-096c-45ae-8af0-f4dd02520030
Thread-2 take(): e4be54ce-096c-45ae-8af0-f4dd02520030
Put: 4e82d8c5-acdd-4e4b-bc55-c5be05c9f665
Thread-1 take(): 4e82d8c5-acdd-4e4b-bc55-c5be05c9f665
Put: 9c983736-4376-4aea-b2d3-2e89f1895c37
Thread-2 take(): 9c983736-4376-4aea-b2d3-2e89f1895c37
Put: 1056baea-d7fa-48bb-99a7-899d17f5bf5f
Thread-1 take(): 1056baea-d7fa-48bb-99a7-899d17f5bf5f
Put: 89389158-5d9b-427f-a39c-b870f3d5cde7
Thread-2 take(): 89389158-5d9b-427f-a39c-b870f3d5cde7
Put: ea042179-4193-4716-86f3-dad9b6c2b8cb
Thread-1 take(): ea042179-4193-4716-86f3-dad9b6c2b8cb
Put: 48692ecc-2cbe-4b6d-950c-01ee7f0d4d15
Thread-2 take(): 48692ecc-2cbe-4b6d-950c-01ee7f0d4d15
Put: da78bb0a-9b4b-4256-b2f8-db7c3c0476b1
</details>
</details>
<details><summary><b>[82 - Java ConcurrentHashMap]</b></summary>
	
#### Java ConcurrentHashMap
This Java tutorial is part of our Java concurrent collections tutorial series. In this tutorial we will see about Java ConcurrentHashMap.
ConcurrentHashMap is a hash table which supports complete concurrency for retrievals and updates. ConcurrentHashMap follows the specifications of a Hashtable. ConcurrentHashMap does not lock the entire collection for synchronization. ConcurrentHashMap is a suited candidate collection when there are high number of updates and less number of read concurrently.
ConcurrentHashMap implements ConcurrentMap which lays the blue print for the concurrent operations. This was introduced part of the JDK 1.5 in the Java collections framework.


<details><summary><b>[82.1 - ConcurrentHashMap Initialization]</b></summary>
	
#### ConcurrentHashMap Initialization
ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)
ConcurrentHashMap comes with multiple constructors and above being one among them. initialCapacity is to fix the internal size of the collection. Hash table density is decided based on the loadFactor. Now this is new, concurrencyLevel. By default ConcurrentHashMap allows 16 number of concurrent threads. We can change this number using the concurrencyLevl argument. Most of the times 16 should be sufficient and playing with these number may cause undesirable performance issues. Know before you set these arguments.
Failsafe
ConcurrentHashMap does not throw ConcurrentModificationException if the underlying collection is modified during an iteration is in progress. Iterators may not reflect the exact state of the collection if it is being modified concurrently. It may reflect the state when it was created and at some moment later. The fail-safe property is given a guarantee based on this.
Which One is Best?
ConcurrentHashMap can be considered as an alternative to Hashtable. It is a better in comparison with a Hashtable and a synchronized Map. ConcurrentHashMap blocks only the parts as required and provides ultimate concurrency. ConcurrentHashMap by default is separated into 16 regions and locks are applied. This default number can be set while initializing a ConcurrentHashMap instance.
Key Points to Remember on ConcurrentHashMap
•	ConcurrentHashMap only locks a portion of the collection on update.
•	ConcurrentHashMap is better than Hashtable and synchronized Map.
•	ConcurrentHashMap is failsafe does not throws ConcurrentModificationException.
•	null is not allowed as a key or value in ConcurrentHashMap.
•	Level of concurrency can be chosen by the programmer on a ConcurrentHashMap while initializing it.

ConcurrentHashMap Example

package com.javapapers.java.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("A","Apple");
        concurrentHashMap.put("B","Blackberry");
        for (Map.Entry e : concurrentHashMap.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }
}
</details>
</details>
<details><summary><b>[83 - Java ConcurrentSkipListMap]</b></summary>
	
#### Java ConcurrentSkipListMap
This Java tutorial is to learn about the concurrent collection class ConcurrentSkipListMap. This is an implementation of ConcurrentNavigableMap interface.
ConcurrentNavigableMap Interface
This interface is a type of SortedMap that provides navigation methods that returns the closest match for given search targets. It has methods like lowerEntry, floorEntry, ceilingEntry, higherEntrywhich return Map.Entry instances based on the key passed respectively less than, less than or equal, greater than or equal and greater than. Similar set of methods available for returning keys too. These can be navigated by ascending or descending order too.
Combined with all the above operations of a NavigableMap it also extends the ConcurrentMap interface. So this is a super-dooper Map we get.


<details><summary><b>[83.1 - ConcurrentSkipListMap]</b></summary>
	
#### ConcurrentSkipListMap
ConcurrentSkipListMap is an implementation of ConcurrentNavigableMap provided in the JDK since 1.6. The elements are sorted based on their natural sorting order of keys. The order can be customized using a Comparator provided during the time of initialization.
Skip List
A skip list is a type of data structure that allows fast search in an ordered sequence of elements. This is built using multiple sequence of layers. The lowest layer linking all the elements by a linked list and subsequent layers above skips some elements in between the links. Thus the highest layer contains the least number of elements in the linked sequence. The elements that are to be sipped in between are chosen probabilistically.
Difference between ConcurrentHashMap and ConcurrentSkipListMap
•	By specification, ConcurrentHashMap does no guarantee the runtime of its operations. Wherein ConcurrentSkipListMap guarantees O(log(n)) performance for most of its operations.
•	ConcurrentHashMap allows to modify the number of threads to tune the concurrency behaviour wherein ConcurrentSkipListMap does not allow to modify the concurrent thread count.
•	ConcurrentHashMap is not NavigableMap and also not a SortedMap, But ConcurrentSkipListMap is both a NavigableMap and a SortedMap.
•	ConcurrentSkipListMap is a skip list and CocurrentHashMap is not.
From JDK Documentation
Most of the times, wherever critical we have good documentation in the JDK source itself. ConcurrentSkipListMap class is one good example. Following is a snap shot from openJDK source of ConcurrentSkipListMap class. What a cool documentation, read through it and you will enjoy it for sure.
 
ConcurrentSkipListMap Example
package com.javapapers.java.collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {
    public static void main(String[] args) {
        ConcurrentNavigableMap concurrentSkipListMap = new ConcurrentSkipListMap();
        concurrentSkipListMap.put("3", "Apple");
        concurrentSkipListMap.put("2", "Ball");
        concurrentSkipListMap.put("1", "Car");
        concurrentSkipListMap.put("5", "Doll");
        concurrentSkipListMap.put("4", "Elephant");

        System.out.println("ceilingEntry-2: " + concurrentSkipListMap.ceilingEntry("2"));
        NavigableSet navigableSet = concurrentSkipListMap.descendingKeySet();
        System.out.println("descendingKeySet: ");
        Iterator itr = navigableSet.iterator();
        while (itr.hasNext()) {
            String s = (String) itr.next();
            System.out.println(s);
        }
        System.out.println("firstEntry: " + concurrentSkipListMap.firstEntry());
        System.out.println("lastEntry: " + concurrentSkipListMap.lastEntry());
        System.out.println("pollFirstEntry: " + concurrentSkipListMap.pollFirstEntry());
        System.out.println("now firstEntry: " + concurrentSkipListMap.firstEntry());
        System.out.println("pollLastEntry: " + concurrentSkipListMap.pollLastEntry());
        System.out.println("now lastEntry: " + concurrentSkipListMap.lastEntry());
    }

}
ConcurrentSkipListMap Example Output
ceilingEntry-2: 2=Ball
descendingKeySet: 
5
4
3
2
1
firstEntry: 1=Car
lastEntry: 5=Doll
pollFirstEntry: 1=Car
now firstEntry: 2=Ball
pollLastEntry: 5=Doll
now lastEntry: 4=Elephant

</details>
</details>


#### Type Conversion and Casting
If you have previous programming experience, then you already know that it is fairly
common to assign a value of one type to a variable of another type. 
If the two types are compatible, then Java will perform the conversion automatically. 
For example, it is always possible to assign an int value to a long variable. 
However, not all types are compatible, and thus, not all type conversions are implicitly allowed. 
For instance, there is no automatic conversion defined from double to byte. 
Fortunately, it is still possible to obtain a conversion between incompatible types. 
To do so, you must use a cast, which performs an explicit conversion between incompatible types. 

#### Java’s Automatic Conversions
When one type of data is assigned to another type of variable, an automatic type 
conversion will take place 
if the following two conditions are met:
• The two types are compatible.
• The destination type is larger than the source type.
When these two conditions are met, a widening conversion takes place. For example, 
the int type is always large enough to hold all valid byte values, 
so no explicit cast statement is required.

For widening conversions, the numeric types, including integer and floating-point types, 
are compatible with each other. 
However, there are no automatic conversions from the numeric types to char or boolean. 
Also, char and boolean are not compatible with each other. 

Java also performs an automatic type conversion when storing a literal integer constant into 
variables of type byte, short, long, or char.

Casting Incompatible Types
Although the automatic type conversions are helpful, they will not fulfill all needs.
For example, what if you want to assign an int value to a byte variable? 
This conversion will not be performed automatically, because a byte is smaller than an int. 
This kind of conversion is sometimes called a narrowing conversion, since you are explicitly 
making the value narrower so that it will fit into the target type.
To create a conversion between two incompatible types, you must use a cast. 
A cast is simply an explicit type conversion. 
It has this general form:
(target-type) value

#### The transient and volatile Modifiers
Java defines two interesting type modifiers: transient and volatile. These modifiers are used to handle somewhat specialized situations.
When an instance variable is declared as transient, then its value need not persist when an object is stored. For example:
class T {
transient int a; // will not persist
int b; // will persist
}
Here, if an object of type T is written to a persistent storage area, the contents of a would not be saved, but the contents of b would.

The volatile modifier tells the compiler that the variable modified by volatile can be changed unexpectedly by other parts of your program. One of these situations involves multithreaded programs. In a multithreaded program, sometimes two or more threads share the same variable. For efficiency considerations, each thread can keep its own, private copy of such a shared variable. The real (or master) copy of the variable is updated at various times, such as when a synchronized method is entered. While this approach works fine, it may be inefficient at times. In some cases, all that really matters is that the master copy of a variable always reflects its current state. To ensure this, simply specify the variable as volatile, which tells the compiler that it must always use the master copy of a volatile variable (or, at least, always keep any private copies up-to-date with the master copy, and vice versa). Also, accesses to the master variable must be executed in the precise order in which they are executed on any private copy.

#### Native Methods
Although it is rare, occasionally you may want to call a subroutine that is written in a language other than Java. Typically, such a subroutine exists as executable code for the CPU and environment in which you are working—that is, native code. For example, you may want to call a native code subroutine to achieve faster execution time. Or, you may want to use a specialized, third-party library, such as a statistical package. However, because Java programs are compiled to bytecode, which is then interpreted (or compiled on-the-fly) by the Java run-time system, it would seem impossible to call a native code subroutine from within your Java program. Fortunately, this conclusion is false. 

Java provides the native keyword, which is used to declare native code methods. Once declared, these methods can be called from inside your Java program just as you call any other Java method.

To declare a native method, precede the method with the native modifier, but do not define anybody for the method. For example:

public native int meth() ;

- Problems with Native Methods
Native methods seem to offer great promise, because they enable you to gain access to an existing base of library routines, and they offer the possibility of faster run-time execution. But native methods also introduce two significant problems:
• Potential security risk Because a native method executes actual machine code, it can gain access to any part of the host system. That is, native code is not confined to the Java execution environment. This could allow a virus infection, for example. For this reason, applets cannot use native methods. Also, the loading of DLLs can be restricted, and their loading is subject to the approval of the security manager.
• Loss of portability Because the native code is contained in a DLL, it must be present on the machine that is executing the Java program. Further, because each native method is CPU- and operating system–dependent, each DLL is inherently non portable. Thus, a Java application that uses native methods will be able to run only on a machine for which a compatible DLL has been installed.

#### assert
Another relatively new addition to Java is the keyword assert. It is used during program development to create an assertion, which is a condition that should be true during the execution of the program. For example, you might have a method that should always return a positive integer value. You might test this by asserting that the return value is greater than zero using an assert statement. At run time, if the condition actually is true, no other action takes place. However, if the condition is false, then an AssertionError is thrown. Assertions are often used during testing to verify that some expected condition is actually met. They are not usually used for released code.
The assert keyword has two forms. The first is shown here:
assert condition;
Here, condition is an expression that must evaluate to a Boolean result. If the result is true, then the assertion is true and no other action takes place. If the condition is false, then the assertion fails and a default AssertionError object is thrown.
The second form of assert is shown here:
assert condition : expr;
In this version, expr is a value that is passed to the AssertionError constructor. This value is converted to its string format and displayed if an assertion fails. Typically, you will specify a string for expr, but any non-void expression is allowed as long as it defines a reasonable string conversion.

#### Varargs: Variable-Length Arguments

Beginning with JDK 5, Java has included a feature that simplifies the creation of methods that need to take a variable number of arguments. This feature is called varargs and it is short for variable-length arguments. A method that takes a variable number of arguments is called a variable-arity method, or simply a varargs method.
Situations that require that a variable number of arguments be passed to a method are not unusual. For example, a method that opens an Internet connection might take a user name, password, filename, protocol, and so on, but supply defaults if some of this information is not provided. In this situation, it would be convenient to pass only the arguments to which the defaults did not apply. Another example is the printf( ) method that is part of Java’s I/O library.It takes a variable number of arguments, which it formats and then outputs.

Prior to JDK 5, variable-length arguments could be handled two ways, neither of which was particularly pleasing. First, if the maximum number of arguments was small and known, then you could create overloaded versions of the method, one for each way the method could be called. Although this works and is suitable for some cases, it applies to only a narrow class of situations.
In cases where the maximum number of potential arguments was larger, or unknowable, a second approach was used in which the arguments were put into an array, and then the array was passed to the method. This approach is illustrated by the following program:
// Use an array to pass a variable number of
// arguments to a method. This is the old-style
// approach to variable-length arguments.
class PassArray {
static void vaTest(int v[]) {
System.out.print("Number of args: " + v.length +
" Contents: ");
for(int x : v)
System.out.print(x + " ");

System.out.println();
}
public static void main(String args[])
{
// Notice how an array must be created to
// hold the arguments.
int n1[] = { 10 };
int n2[] = { 1, 2, 3 };
int n3[] = { };
vaTest(n1); // 1 arg
vaTest(n2); // 3 args
vaTest(n3); // no args
}
}
The output from the program is shown here:
Number of args: 1 Contents: 10
Number of args: 3 Contents: 1 2 3
Number of args: 0 Contents:
In the program, the method vaTest( ) is passed its arguments through the array v. This old-style approach to variable-length arguments does enable vaTest( ) to take an arbitrary number of arguments. However, it requires that these arguments be manually packaged into an array prior to calling vaTest( ). Not only is it tedious to construct an array each time vaTest( ) is called, it is potentially error-prone. The varargs feature offers a simpler, better option.
A variable-length argument is specified by three periods (...). For example, here is how vaTest( ) is written using a vararg:
static void vaTest(int ... v) {
This syntax tells the compiler that vaTest( ) can be called with zero or more arguments. As a result, v is implicitly declared as an array of type int[ ]. Thus, inside vaTest( ), v is accessed using the normal array syntax. Here is the preceding program rewritten using a vararg:
// Demonstrate variable-length arguments.
class VarArgs {
// vaTest() now uses a vararg.
static void vaTest(int ... v) {
System.out.print("Number of args: " + v.length +
" Contents: ");
for(int x : v)
System.out.print(x + " ");
System.out.println();
}
public static void main(String args[])
{
// Notice how vaTest() can be called with a
// variable number of arguments.
vaTest(10); // 1 arg
vaTest(1, 2, 3); // 3 args
vaTest(); // no args
}
}
The output from the program is the same as the original version.
There are two important things to notice about this program. First, as explained, inside vaTest( ), v is operated on as an array. This is because v is an array. The ... syntax simply tells the compiler that a variable number of arguments will be used, and that these arguments will be stored in the array referred to by v. 
Second, in main( ), vaTest( ) is called with different numbers of arguments, including no arguments at all. The arguments are automatically put in an array and passed to v. In the case of no arguments, the length of the array is zero.
A method can have “normal” parameters along with a variable-length parameter. However, the variable-length parameter must be the last parameter declared by the method. For example, this method declaration is perfectly acceptable:
int doIt(int a, int b, double c, int ... vals) {}










________________________________________






#### Association, Composition and Aggregation in Java
 
- Association
Association is relation between two separate classes which establishes through their Objects. Association can be one-to-one, one-to-many, many-to-one, many-to-many.
In Object-Oriented programming, an Object communicates to other Object to use functionality and services provided by that object. Composition and Aggregation are the two forms of association.


filter_none
edit
play_arrow
brightness_4
// Java program to illustrate the  
// concept of Association 
import java.io.*; 
  
// class bank 
class Bank  
{ 
    private String name; 
      
    // bank name 
    Bank(String name) 
    { 
        this.name = name; 
    } 
      
    public String getBankName() 
    { 
        return this.name; 
    } 
}  
  
// employee class  
class Employee 
{ 
    private String name; 
      
    // employee name  
    Employee(String name)  
    { 
        this.name = name; 
    } 
      
    public String getEmployeeName() 
    { 
        return this.name; 
    }  
} 
  
// Association between both the  
// classes in main method 
class Association  
{ 
    public static void main (String[] args)  
    { 
        Bank bank = new Bank("Axis"); 
        Employee emp = new Employee("Neha"); 
          
        System.out.println(emp.getEmployeeName() +  
               " is employee of " + bank.getBankName()); 
    } 
} 
Output:
Neha is employee of Axis


In above example two separate classes Bank and Employee are associated through their Objects. Bank can have many employees, So it is a one-to-many relationship.
 
- Aggregation
 
Aggregation

It is a special form of Association where:
•	It represents Has-A relationship.
•	It is a unidirectional association i.e. a one way relationship. For example, department can have students but vice versa is not possible and thus unidirectional in nature.
•	In Aggregation, both the entries can survive individually which means ending one entity will not effect the other entity
filter_none
edit
play_arrow
brightness_4
// Java program to illustrate 
//the concept of Aggregation. 
import java.io.*; 
import java.util.*; 
  
// student class 
class Student  
{ 
    String name; 
    int id ; 
    String dept; 
      
    Student(String name, int id, String dept)  
    { 
          
        this.name = name; 
        this.id = id; 
        this.dept = dept; 
          
    } 
} 
  
/* Department class contains list of student 
Objects. It is associated with student 
class through its Object(s). */
class Department  
{ 
      
    String name; 
    private List<Student> students; 
    Department(String name, List<Student> students)  
    { 
          
        this.name = name; 
        this.students = students; 
          
    } 
      
    public List<Student> getStudents()  
    { 
        return students; 
    } 
} 
  
/* Institute class contains list of Department 
Objects. It is asoociated with Department 
class through its Object(s).*/
class Institute  
{ 
      
    String instituteName; 
    private List<Department> departments; 
      
    Institute(String instituteName, List<Department> departments) 
    { 
        this.instituteName = instituteName; 
        this.departments = departments; 
    } 
      
    // count total students of all departments 
    // in a given institute  
    public int getTotalStudentsInInstitute() 
    { 
        int noOfStudents = 0; 
        List<Student> students;  
        for(Department dept : departments) 
        { 
            students = dept.getStudents(); 
            for(Student s : students) 
            { 
                noOfStudents++; 
            } 
        } 
        return noOfStudents; 
    } 
      
}  
  
// main method 
class GFG 
{ 
    public static void main (String[] args)  
    { 
        Student s1 = new Student("Mia", 1, "CSE"); 
        Student s2 = new Student("Priya", 2, "CSE"); 
        Student s3 = new Student("John", 1, "EE"); 
        Student s4 = new Student("Rahul", 2, "EE"); 
      
        // making a List of  
        // CSE Students. 
        List <Student> cse_students = new ArrayList<Student>(); 
        cse_students.add(s1); 
        cse_students.add(s2); 
          
        // making a List of  
        // EE Students 
        List <Student> ee_students = new ArrayList<Student>(); 
        ee_students.add(s3); 
        ee_students.add(s4); 
          
        Department CSE = new Department("CSE", cse_students); 
        Department EE = new Department("EE", ee_students); 
          
        List <Department> departments = new ArrayList<Department>(); 
        departments.add(CSE); 
        departments.add(EE); 
          
        // creating an instance of Institute. 
        Institute institute = new Institute("BITS", departments); 
          
        System.out.print("Total students in institute: "); 
        System.out.print(institute.getTotalStudentsInInstitute()); 
    } 
} 
Output:
Total students in institute: 4
In this example, there is an Institute which has no. of departments like CSE, EE. Every department has no. of students. So, we make a Institute class which has a reference to Object or no. of Objects (i.e. List of Objects) of the Department class. That means Institute class is associated with Department class through its Object(s). And Department class has also a reference to Object or Objects (i.e. List of Objects) of Student class means it is associated with Student class through its Object(s).
It represents a Has-A relationship.
 
#### When do we use Aggregation ??
Code reuse is best achieved by aggregation.


- Composition
 
Composition
Composition is a restricted form of Aggregation in which two entities are highly dependent on each other.
•	It represents part-of relationship.
•	In composition, both the entities are dependent on each other.
•	When there is a composition between two entities, the composed object cannot exist without the other entity.
Lets take example of Library.


filter_none
edit
play_arrow
brightness_4
// Java program to illustrate  
// the concept of Composition 
import java.io.*; 
import java.util.*; 
  
// class book 
class Book  
{ 
  
    public String title; 
    public String author; 
      
    Book(String title, String author) 
    { 
          
        this.title = title; 
        this.author = author; 
    } 
} 
  
// Libary class contains  
// list of books. 
class Library  
{ 
  
    // reference to refer to list of books. 
    private final List<Book> books; 
      
    Library (List<Book> books) 
    { 
        this.books = books;  
    } 
      
    public List<Book> getTotalBooksInLibrary(){ 
          
       return books;   
    } 
      
} 
  
// main method 
class GFG  
{ 
    public static void main (String[] args)  
    { 
          
        // Creating the Objects of Book class. 
        Book b1 = new Book("EffectiveJ Java", "Joshua Bloch"); 
        Book b2 = new Book("Thinking in Java", "Bruce Eckel"); 
        Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt"); 
          
        // Creating the list which contains the  
        // no. of books. 
        List<Book> books = new ArrayList<Book>(); 
        books.add(b1); 
        books.add(b2); 
        books.add(b3); 
          
        Library library = new Library(books); 
          
        List<Book> bks = library.getTotalBooksInLibrary(); 
        for(Book bk : bks){ 
              
            System.out.println("Title : " + bk.title + " and " 
            +" Author : " + bk.author); 
        } 
    } 
} 
Output
Title : EffectiveJ Java and  Author : Joshua Bloch
Title : Thinking in Java and  Author : Bruce Eckel
Title : Java: The Complete Reference and  Author : Herbert Schildt
In above example a library can have no. of books on same or different subjects. So, If Library gets destroyed then All books within that particular library will be destroyed. i.e. book can not exist without library. That’s why it is composition.
#### Aggregation vs Composition
1.	Dependency: Aggregation implies a relationship where the child can exist independently of the parent. For example, Bank and Employee, delete the Bank and the Employee still exist. whereas Composition implies a relationship where the child cannot exist independent of the parent. Example: Human and heart, heart don’t exist separate to a Human
2.	Type of Relationship: Aggregation relation is “has-a” and composition is “part-of” relation.
3.	Type of association: Composition is a strong Association whereas Aggregation is a weak Association.
filter_none
edit
play_arrow
brightness_4
// Java program to illustrate the 
// difference between Aggregation 
// Composition. 
  
import java.io.*; 
  
// Engine class which will  
// be used by car. so 'Car' 
// class will have a field  
// of Engine type. 
class Engine  
{ 
    // starting an engine. 
    public void work() 
    { 
          
        System.out.println("Engine of car has been started "); 
          
    } 
      
} 
  
// Engine class 
final class Car  
{ 
      
    // For a car to move,  
    // it need to have a engine. 
    private final Engine engine; // Composition 
    //private Engine engine;     // Aggregation 
      
    Car(Engine engine) 
    { 
        this.engine = engine; 
    } 
      
    // car start moving by starting engine 
    public void move()  
    { 
          
        //if(engine != null) 
        { 
            engine.work(); 
            System.out.println("Car is moving "); 
        } 
    } 
} 
  
class GFG  
{ 
    public static void main (String[] args)  
    { 
          
        // making an engine by creating  
        // an instance of Engine class. 
        Engine engine = new Engine(); 
          
        // Making a car with engine. 
        // so we are passing a engine  
        // instance as an argument while 
        // creating instace of Car. 
        Car car = new Car(engine); 
        car.move(); 
          
    } 
} 
Output:
Engine of car has been started 
Car is moving 
In case of aggregation, the Car also performs its functions through an Engine. but the Engine is not always an internal part of the Car. An engine can be swapped out or even can be removed from the car. That’ why we make The Engine type field non-final.

#### Access and Non Access Modifiers in Java
Java provides a rich set of modifiers. They are used to control access mechanism and also provide information about class functionalities to JVM. They are divided into two categories : –
•	Access Modifiers : Java’s access modifiers are public, private, and protected. Java also defines a default access level (called package-private).
How they work?
public: When a member of a class is modified by public, then that member can be accessed by any other code.
private: When a member of a class is specified as private, then that member can only be accessed by other members of its class.
Now you can understand why main( ) has always been preceded by the public modifier. It is called by code that is outside the program—that is, by the Java run-time system. When no access modifier is used, then by default the member of a class is public within its own package, but cannot be accessed outside of its package. protected applies only when inheritance is involved.


Detailed article : Access Modifiers in Java
•	Non-access modifiers : In java, we have 7 non-access modifiers. They are used with classes, methods, variables, constructors etc to provide information about their behavior to JVM.They are
•	static
•	final
•	abstract
•	synchronized
•	transient
•	volatile
•	native


Access Modifiers in Java
As the name suggests access modifiers in Java helps to restrict the scope of a class, constructor , variable , method or data member. There are four types of access modifiers available in java:
1.	Default – No keyword required
2.	Private
3.	Protected
4.	Public
 
1.	Default: When no access modifier is specified for a class , method or data member – It is said to be having the default access modifier by default.


•	The data members, class or methods which are not declared using any access modifiers i.e. having default access modifier are accessible only within the same package.
In this example, we will create two packages and the classes in the packages will be having the default access modifiers and we will try to access a class from one package from a class of second package.
filter_none
edit
play_arrow
brightness_4
//Java program to illustrate default modifier 
package p1; 
  
//Class Geeks is having Default access modifier 
class Geek 
{ 
    void display() 
       { 
           System.out.println("Hello World!"); 
       } 
} 
filter_none
edit
play_arrow
brightness_4
//Java program to illustrate error while  
//using class from different package with 
//default modifier 
package p2; 
import p1.*; 
  
//This class is having default access modifier 
class GeekNew 
{ 
    public static void main(String args[]) 
       {   
          //accessing class Geek from package p1 
          Geeks obj = new Geek(); 
  
          obj.display(); 
       } 
} 
Output:
Compile time error
2.	Private: The private access modifier is specified using the keyword private.
•	The methods or data members declared as private are accessible only within the class in which they are declared.
•	Any other class of same package will not be able to access these members.
•	Top level Classes or interface can not be declared as private because
1.	private means “only visible within the enclosing class”.
2.	protected means “only visible within the enclosing class and any subclasses”
Hence these modifiers in terms of application to classes, they apply only to nested classes and not on top level classes
3.	In this example, we will create two classes A and B within same package p1. We will declare a method in class A as private and try to access this method from class B and see the result.
4.	filter_none
5.	edit
6.	play_arrow
7.	brightness_4
//Java program to illustrate error while  
//using class from different package with 
//private modifier 
package p1; 
  
class A 
{ 
   private void display() 
    { 
        System.out.println("GeeksforGeeks"); 
    } 
} 
  
class B 
{ 
   public static void main(String args[]) 
      { 
          A obj = new A(); 
          //trying to access private method of another class 
          obj.display(); 
      } 
} 
8.	Output:
9.	error: display() has private access in A
10.	        obj.display();
11.	protected: The protected access modifier is specified using the keyword protected.
•	The methods or data members declared as protected are accessible within same package or sub classes in different package.
In this example, we will create two packages p1 and p2. Class A in p1 is made public, to access it in p2. The method display in class A is protected and class B is inherited from class A and this protected method is then accessed by creating an object of class B.
filter_none
edit
play_arrow
brightness_4
//Java program to illustrate 
//protected modifier 
package p1; 
  
//Class A 
public class A 
{ 
   protected void display() 
    { 
        System.out.println("GeeksforGeeks"); 
    } 
} 
filter_none
edit
play_arrow
brightness_4
//Java program to illustrate 
//protected modifier 
package p2; 
import p1.*; //importing all classes in package p1 
  
//Class B is subclass of A 
class B extends A 
{ 
   public static void main(String args[]) 
   {   
       B obj = new B();   
       obj.display();   
   }   
      
} 
Output:
GeeksforGeeks
12.	public: The public access modifier is specified using the keyword public.
•	The public access modifier has the widest scope among all other access modifiers.
•	Classes, methods or data members which are declared as public are accessible from every where in the program. There is no restriction on the scope of a public data members.
filter_none
edit
play_arrow
brightness_4
//Java program to illustrate 
//public modifier 
package p1; 
public class A 
{ 
   public void display() 
      { 
          System.out.println("GeeksforGeeks"); 
      } 
} 
package p2; 
import p1.*; 
class B 
{ 
    public static void main(String args[]) 
      { 
          A obj = new A; 
          obj.display(); 
      } 
} 
Output:
GeeksforGeeks
Important Points:
•	If other programmers use your class, try to use the most restrictive access level that makes sense for a particular member. Use private unless you have a good reason not to.
•	Avoid public fields except for constants.


#### Association vs. Aggregation vs. Composition

- Association
Association is the most general type of relationship and it  includes other types as well. If the relationship doesn’t fall into a more specific type, like Aggregation or Composition, it can simply be referred to as an Association.
Example: When a Customer places an Order, the relationship is simply an Association.
 
 
- Aggregation
Aggregation is a more specific type of association. In an aggregation the children can also be shared with another owner at the same time, and even if the owner no longer exists, the children can still continue their lifetime.
Example: The relationship between a UserGroup and the Users, is an Aggregation. A User can still have meaning in the system even if it doesn’t belong to a UserGroup, so if you delete a UserGroup you won’t delete its Users. On the other hand, the Users can belong to several UserGroups at the same time.
 
 
- Composition
Composition is a more strict type of Aggregation. In an aggregation, the children cannot be shared with a different owner and it doesn’t make sense for the children to exist without their owner. So, you usually want to delete the children if you delete their owner.
Example: The relationship between an Order and the OrderDetails is a composition relationship. The OrderDetail items are valid only as long as there is an Order related to them. When you delete an Order you will delete it’s OrderDetails as well. An OrderDetail associated to a particular Order cannot belong to a different Order.
 
 
#### String vs StringBuffer vs StringBuilder in Java


#### What is Serialization and Deserialization in Java?
The process of serialization in Java is a process in which the object’s state is converted into a byte stream while deserialization is just the reverse of serialization in which we use the byte stream to convert into the original state of a Java object.
Do you know about What is Encapsulation in Java?
 
The classes which serialized should have the implementation java.io.Serializable interface. Serializable in Java is used to mark classes, so that they may get the certain capability, it is basically a marker interface.
Points to ponder
i. If serializable implement in a certain parent class then we don’t need to implement it in the child class, but the reverse is not applicable.
ii. Nonstatic data members are stored via this method and not static and transient data members.
iii. A constructor for an object is never called while deserialization.

#### How Java objects are stored in memory?

In Java, all objects are dynamically allocated on Heap. This is different from C++ where objects can be allocated memory either on Stack or on Heap. In C++, when we allocate the object using new(), the object is allocated on Heap, otherwise on Stack if not global or static.
In Java, when we only declare a variable of a class type, only a reference is created (memory is not allocated for the object). To allocate memory to an object, we must use new(). So the object is always allocated memory on heap (See this for more details).
For example, following program fails in the compilation. Compiler gives error “Error here because t is not initialized”.


filter_none
edit
play_arrow
brightness_4
class Test { 
  
// class contents 
void show() 
{ 
    System.out.println("Test::show() called"); 
} 
} 
  
public class Main { 
  
        // Driver Code 
    public static void main(String[] args)  
    { 
        Test t;  
          
        // Error here because t  
        // is not initialzed 
        t.show();  
    } 
} 
Allocating memory using new() makes above program work.
filter_none
edit
play_arrow
brightness_4
class Test { 
      
// class contents 
void show()  
{ 
    System.out.println("Test::show() called"); 
} 
} 
  
public class Main { 
      
    // Driver Code 
    public static void main(String[] args) 
    { 
          
        // all objects are dynamically  
        // allocated 
        Test t = new Test();  
        t.show(); // No error  
    } 
} 

A stack and a heap are used for memory allocation in Java. However, the stack is used for primitive data types, temporary variables, object addresses etc. The heap is used for storing objects in memory.
Stacks and heaps in Java are explained in more detail as follows:
Stack in Java
Stacks are used to store temporary variables, primitive data types etc. A block in the stack exists for a variable only as long as the variable exists. After that, the block data is erased and it can be used for storing another variable.

A static inner class can be instantiated without the need for an instance of the outer class. In general, an Inner class is a part of nested class, called Non-static nested classes in Java. The types of inner classes are member inner class, anonymous inner class, and local inner class.
We can instantiate a static inner class with reflection using InnerClass.class.newInstance(). If we need an instance of the outer class to instantiate a non-static inner class, we can specify it before a new operator.
Example
import java.lang.reflect.*;
public class InnerclassWithReflectionTest {
   public static void main(String args[]) {
      try {
         InnerClass inner = (InnerClass) InnerClass.class.newInstance();
         inner.test();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   // inner class
   static class InnerClass {
      public void test() {
         System.out.println("Welcome to TutorialsPoint !!!");
      }
   }
}

#### Shadowing of static functions in Java
In Java, if the name of a derived class static function is the same as a base class static function then the base class static function shadows (or conceals) the derived class static function. For example, the following Java code prints “A.fun()”
Note: Static method is a class property, so if a static method is called from a class name or object having a class container then the method of that class is called not the object’s method.
filter_none
edit
play_arrow
brightness_4
// file name: Main.java 
  
// Parent class 
class A { 
    static void fun() 
    { 
        System.out.println("A.fun()"); 
    } 
} 
  
// B is inheriting A 
// Base class 
class B extends A { 
    static void fun() 
    { 
        System.out.println("B.fun()"); 
    } 
} 
  
// Driver Method 
public class Main { 
    public static void main(String args[]) 
    { 
        A a = new B(); 
        a.fun(); // prints A.fun(); 
  
        // B a = new B(); 
        // a.fun(); // prints B.fun() 
  
        // the variable type decides the method 
        // being invoked, not the assigned object type 
    } 
} 
Output:
A.fun()
Note: If we make both A.fun() and B.fun() as non-static then the above program would print “B.fun()”. While both methods are static types, the variable type decides the method being invoked, not the assigned object type

#### The Initializer Block in Java
Initializer block contains the code that is always executed whenever an instance is created. It is used to declare/initialize the common part of various constructors of a class. For example,
filter_none
edit
play_arrow
brightness_4
import java.io.*; 
public class GFG 
{ 
    // Initializer block starts.. 
    { 
        // This code is executed before every constructor. 
        System.out.println("Common part of constructors invoked !!"); 
    } 
    // Initializer block ends 
  
    public GFG() 
    { 
        System.out.println("Default Constructor invoked"); 
    } 
    public GFG(int x) 
    { 
        System.out.println("Parametrized constructor invoked"); 
    } 
    public static void main(String arr[]) 
    { 
        GFG obj1, obj2; 
        obj1 = new GFG(); 
        obj2 = new GFG(0); 
    } 
} 
Output:
Common part of constructors invoked!!
Default Constructor invoked
Common part of constructors invoked!!
Parametrized constructor invoked 
We can note that the contents of initializer block are executed whenever any constructor is invoked (before the constructor’s contents)


The order of initialization constructors and initializer block doesn’t matter, initializer block is always executed before constructor. See this for example.
Refer below article for more details in instance initialization:
Instance Initialization Block (IIB) in Java
What if we want to execute some code once for all objects of a class?
We use Static Block in Java

Order of execution of Initialization blocks and Constructors in Java
Prerequisite : Static blocks, Initializer block, Constructor
In a Java program, operations can be performed on methods, constructors and initialization blocks.
Instance Initialization Blocks : IIB are used to initialize instance variables. IIBs are executed before constructors. They run each time when object of the class is created.
Initializer block : contains the code that is always executed whenever an instance is created. It is used to declare/initialize the common part of various constructors of a class.
Constructors : are used to initialize the object’s state. Like methods, a constructor also contains collection of statements(i.e. instructions) that are executed at time of Object creation.
Order of execution of Initialization blocks and constructor in Java
1.	Static initialization blocks will run whenever the class is loaded first time in JVM
2.	Initialization blocks run in the same order in which they appear in the program.
3.	Instance Initialization blocks are executed whenever the class is initialized and before constructors are invoked. They are typically placed above the constructors within braces.
filter_none
edit
play_arrow
brightness_4
// Java code to illustrate order of 
// execution of constructors, static 
// and initialization blocks 
class GFG { 
  
    GFG(int x) 
    { 
        System.out.println("ONE argument constructor"); 
    } 
  
    GFG() 
    { 
        System.out.println("No  argument constructor"); 
    } 
  
    static
    { 
        System.out.println("1st static init"); 
    } 
  
    { 
        System.out.println("1st instance init"); 
    } 
  
    { 
        System.out.println("2nd instance init"); 
    } 
  
    static
    { 
        System.out.println("2nd static init"); 
    } 
  
    public static void main(String[] args) 
    { 
        new GFG(); 
        new GFG(8); 
    } 
} 
Output



1st static init
2nd static init
1st instance init
2nd instance init
No  argument constructor
1st instance init
2nd instance init
ONE argument constructor
Note : If there are two or more static/initializer blocks then they are executed in the order in which they appear in the source code.
Now, predict the output of the following program-
filter_none
edit
play_arrow
brightness_4
// A tricky Java code to predict the output 
// based on order of  
// execution of constructors, static  
// and initialization blocks 
class MyTest { 
    static
    { 
        initialize(); 
    } 
      
    private static int sum; 
      
    public static int getSum() 
    { 
        initialize(); 
        return sum; 
    } 
  
    private static boolean initialized = false; 
  
    private static void initialize() 
    { 
        if (!initialized) { 
            for (int i = 0; i < 100; i++) 
                sum += i; 
            initialized = true; 
        } 
    } 
} 
  
public class GFG { 
    public static void main(String[] args) 
    { 
        System.out.println(MyTest.getSum()); 
    } 
} 
Output:
9900
Explanation:
•	Loop in initialize function goes from 0 to 99. With that in mind, you might think that the program prints the sum of the numbers from 0 to 99. Thus sum is 99 × 100 / 2, or 4, 950. The program, however, thinks otherwise. It prints 9900, fully twice this value.
•	To understand its behavior, let’s trace its execution.The GFG.main method invokes MyTest.getSum. Before the getSum method can be executed, the VM must initialize the class MyTest. Class initialization executes static initializers in the order they appear in the source.
•	The MyTest class has two static initializers: the static block at the top of the class and the initialization of the static field initialized. The block appears first. It invokes the method initialize, which tests the field initialized. Because no value has been assigned to this field, it has the default boolean value of false.
•	Similarly, sum has the default int value of 0. Therefore, the initialize method does what you’d expect, adding 4, 950 to sum and setting initialized to true. After the static block executes, the static initializer for the initialized field sets it back to false, completing the class initialization of MyTest. Unfortunately, sum now contains the 4950, but initialized contains false.
•	The main method in the GFG class then invokes MyTest.getSum, which in turn invokes initialize method. Because the initialized flag is false, the initializeIf method enters its loop, which adds another 4, 950 to the value of sum, increasing its value to 9, 900. The getSum method returns this value, and the program prints it


#### Literals in Java – Integral, Floating-Point, Char, String, Boolean
BY DATAFLAIR TEAM · UPDATED · AUGUST 29, 2019
Literals are number, text, or anything that represent a value. In other words, Literals in Java are the constant values assigned to the variable. It is also called a constant.
For example,
1.	int x = 100;
So, 100 is literal.
There are 5 types of Literals can be seen in Java. But before we start the discussion, you should revise the concept of Variables in Java.
Types of Literals in Java
 
1. Integral Literals in Java
We can specify the integer literals in 4 different ways –
•	Decimal (Base 10)
Digits from 0-9 are allowed in this form.
1.	Int x = 101;
•	Octal (Base 8)
Digits from 0 – 7 are allowed. It should always have a prefix 0.
1.	int x = 0146;
Don’t forget to check Datatypes in Java with examples
 
•	Hexa-Decimal (Base 16)
Digits 0-9 are allowed and also characters from a-f are allowed in this form. Furthermore, both uppercase and lowercase characters can be used, Java provides an exception here.
1.	int x = 0X123Face;
•	Binary
A literal in this type should have a prefix 0b and 0B, from 1.7 one can also specify in binary literals, i.e. 0 and 1.
1.	int x = 0b1111;
Example-
1.	package com.dataflair.literals;
2.	
3.	public class IntegralLiteral {
4.	public static void main(String[] args)
5.	{
6.	int decimalValue = 123; // decimal-form literal
7.	int octalValue = 01200; // octal-form literal
8.	int hexaDecimalValue = 0xAce; // Hexa-decimal form literal
9.	int binaryValue = 0b00101; // Binary literal
10.	
11.	System.out.println("Decimal form literal is "+decimalValue);
12.	System.out.println("Octal form literal is "+b);
13.	System.out.println("Hexa-decimal form literal is "+hexaDecimalValue);
14.	System.out.println("Binary literal is "+binaryValue);
15.	}
16.	}
Output-
 
We can specify explicitly as long type by suffixed with l or L but there is no way to specify byte and short, but if it’s in the range the compiler automatically treats it as a byte.
Do you know what is Java Abstract Data Types (ADT)?
2. Floating-Point Literals in Java
Here, datatypes can only be specified in decimal forms and not in octal or hexadecimal form.
•	Decimal (Base 10)
1.	package com.dataflair.literals;
2.	
3.	public class FloatingPointLiteral 
4.	{
5.	public static void main(String args[])
6.	{
7.	double decimalValue = 101.230; // decimal-form literal
8.	double decimalValue1 = 0123.222; // It also acts as decimal literal
9.	double hexaDecimalValue = 1.234e2; // Hexa-decimal form
10.	System.out.println("Decimal form literal is "+decimalValue);
11.	System.out.println("Second Decimal form literal is "+decimalValue1);
12.	System.out.println("Hexa decimal form literal is "+hexaDecimalValue);
13.	}
14.	}
Output – 
Every floating type is a double type and this the reason why we cannot assign it directly to float variable, to escape this situation we use f or F as suffix, and for double we use d or D.
Have you checked the Latest Career Opportunities of Java?
3. Char Literals in Java
These are the four types of char-
 
•	Single Quote
Java Literal can be specified to a char data type as a single character within a single quote.
1.	char ch = 'a';
•	Char as Integral 
A char literal in Java can specify as integral literal which also represents the Unicode value of a character.
Furthermore, an integer can specify in decimal, octal and even hexadecimal type, but the range is 0-65535.
1.	char ch = 062;
•	Unicode Representation
Char literals can specify in Unicode representation ‘\uxxxx’. Here XXXX represents 4 hexadecimal numbers.
1.	char ch = '\u0061';// Here /u0061 represent a.
•	Escape Sequence
Escape sequences can also specify as char literal.
1.	char ch = '\n';
Example-
1.	package com.dataflair.literals;
2.	
3.	public class CharacterLiteral {
4.	public static void main(String[] args)
5.	{
6.	char character = 'd';
7.	//char number = 0789; error: Integer number too large
8.	char unicodeCharacter = '\u0064';
9.	System.out.println(character);
10.	System.out.println(unicodeCharacter);
11.	System.out.println("\" is a symbol");
12.	}
13.	}
Output –
 
4. String Literals
Java String literals are any sequence of characters with a double quote.
1.	String s = "Hello";
They may not contain unescaped newline or linefeed characters.
However, the Java compiler will evaluate compile-time expressions.
Example-
1.	package com.dataflair.literals;
2.	
3.	public class StringLiteral {
4.	public static void main(String[] args) 
5.	{ 
6.	String myString = "Hello! Welcome to DataFlair"; 
7.	
8.	// If we assign without "" then it treats as a variable 
9.	// and causes compiler error 
10.	// String myString1 = Hello; 
11.	
12.	System.out.println(myString ); 
13.	
14.	} 
15.	
16.	}
Output – 
5. Boolean Literals
They allow only two values i.e. true and false.
1.	boolean b = true;
Example –
1.	package com.dataflair.literals;
2.	
3.	public class BooleanLiteral {
4.	public static void main(String[] args)
5.	{
6.	boolean boolVar1 = true;
7.	boolean boolVar2 = false;
8.	// boolean boolVar3 = 0; error: incompatible types: int cannot be converted to boolean
9.	// boolean boolVar1 = 1; error: incompatible types: int cannot be converted to boolean
10.	System.out.println(boolVar1);
11.	System.out.println(boolVar2);
12.	}
13.	}
Output –
 
Summary
Literals in Java are an important concept, which will help you to build your basics in programming. Now, you can implement 5 types of literals in your program.
Association In Java – Explore the Concepts of Composition & Aggregation
BY DATAFLAIR TEAM · UPDATED · AUGUST 14, 2019
Association in Java is a connection between two separate classes that is set up through their objects. Although, Java association can balance, one-to-one, one-to-many, and many-to-many relationships. It defines the multiplicity between objects.
There are two types of Association
1.	Aggregation
2.	Composition
Which we will discuss in the tutorial with examples. So, let’s start the journey!
 
#### Association in Java
The association relationship indicates that a class knows about another class. It can be described as a “has-a” relationship between classes. The relationship between the classes can be bi-directional.
Before moving further, you should revise the concept of Inheritance in Java
For example, if we talk about the association between a teacher and a student, multiple students can associate with a single teacher and a single student is also associated with multiple teachers but both can be created or deleted independently. So, when a teacher leaves the school, we don’t need to remove any students, and when a student leaves the school, we don’t need to remove any teachers.
 
So, in the above example, the teacher has many students and vice versa, connectes to various objects. Thus, we can say the association in Java follows a many-to-many relationship.
Java Association  Example –
1.	package com.dataflair.association;
2.	class Teacher
3.	{
4.	private String name;
5.	Teacher(String name)
6.	{
7.	this.name = name;
8.	}
9.	public String getTeacherName()
10.	{
11.	return this.name;
12.	}
13.	}
14.	class Student
15.	{
16.	private String name;
17.	Student(String name)
18.	{
19.	this.name = name;
20.	}
21.	public String getStudentName()
22.	{
23.	return this.name;
24.	}
25.	}
26.	class AssociationDemo
27.	{
28.	public static void main (String[] args)
29.	{
30.	Teacher teacherObj = new Teacher("Rahul Sir");
31.	Student studentObj = new Student("Renuka");
32.	System.out.println(studentObj.getStudentName() +
33.	" is Student of " + teacherObj.getTeacherName());
34.	}
35.	}
Output-
 
Do you know Java is an Object-Oriented Language or Not?
Types of Association in Java
There are two types of association in Java
 
 
#### Aggregation in Java
Now, Aggregation in Java is a special type of association. It has the following characteristics –
•	It represents the Has-A relationship.
•	Aggregation in Java follows a one-way or one-to-one relationship.
•	Ending one entity won’t affect another, both can be present independently.
Let’s take the example of a mobile phone and a battery. A single battery can belong to a mobile phone, but if the mobile phone stops working, and we delete it from our database. The phone battery will not be deleted because it may still be functional. So in aggregation, while there is ownership, objects have their own lifecycle.
 
1.	package com.dataflair.association;
2.	
3.	class Employees
4.	{
5.	String name;
6.	int id ;
7.	String dept;
8.	Employees(String name, int id, String dept)
9.	{
10.	this.name = name;
11.	this.id = id;
12.	this.dept = dept;
13.	System.out.println("Employee name is "+name+" Id is "+id+" Department is "+dept);
14.	}
15.	}
16.	class Department
17.	{
18.	String name, employees;
19.	Department(String name, String employees)
20.	{
21.	this.name = name;
22.	this.employees = employees;
23.	}
24.	
25.	}
26.	class Organization
27.	{
28.	String officeName,departments;
29.	Organization(String officeName, String departments)
30.	{
31.	this.officeName = officeName;
32.	this.departments = departments;
33.	}
34.	
35.	}
36.	
37.	public class AggregationDemo{
38.	public static void main (String[] args)
39.	{
40.	Employees s1 = new Employees("Mia", 1, "Sales");
41.	Employees s2 = new Employees("Priya", 2, "Marketing");
42.	Employees s3 = new Employees("John", 1, "IT");
43.	Employees s4 = new Employees("Rahul", 2, "Designing");
44.	}
45.	}
Output-
 
So, in this case, there is an organization that has a number of offices. Each office has a number of Departments. In this way, we influence an Organization to the class which has a reference to Object or number of Objects (i.e. Rundown of Objects) of the Department class. That implies Organization class is related to Department class through its Object(s). What’s more, Department class has likewise a reference to Object or Objects (i.e. Rundown of Objects) of Employees class implies it is related to Employees class through its Object(s). It speaks to a Has-A relationship. Code rescue can be best achieved by Aggregation in Java.
It’s time to explore the latest career opportunities in Java
 
#### Composition in Java
This is a restricted form of Java aggregation that is the quantities are highly dependent on each other. It represents a part-of relationship. One entity cannot exist without the other. Composition in Java represents a one-to-many relationship.
Suppose if we take an example of the relationship between questions and answers. Single questions can have multiple answers, but multiple answers can not have multiple questions. If we delete questions, answers will automatically be deleted. In this the entities are dependent.
 
1.	package com.dataflair.association;
2.	
3.	import java.util.*;
4.	class Book
5.	{
6.	public String title;
7.	public String author;
8.	Book(String title, String author)
9.	{
10.	this.title = title;
11.	this.author = author;
12.	}
13.	}
14.	class Library
15.	{
16.	private final List<Book> books;
17.	Library (List<Book> books)
18.	{
19.	this.books = books;
20.	}
21.	public List<Book> getTotalBooksInLibrary(){
22.	return books;
23.	}
24.	}
25.	public class CompositionDemo {
26.	
27.	public static void main (String[] args)
28.	{
29.	Book bookObj1 = new Book("Java:A Beginner's Guide","Herbert Schildt");
30.	Book bookObj2 = new Book("Core and Advanced Java", " Dreamtech Press");
31.	Book bookObj3 = new Book("Head First Java", "Kathy Sierra");
32.	List<Book> books = new ArrayList<Book>();
33.	books.add(bookObj1);
34.	books.add(bookObj2);
35.	books.add(bookObj3);
36.	Library library = new Library(books);
37.	List<Book> bks = library.getTotalBooksInLibrary();
38.	for(Book bk : bks){
39.	System.out.println("Title : " + bk.title + " and "
40.	+" Author : " + bk.author);
41.	}
42.	}
43.	}
Output-
 
Recommended Reading – Collections in Java 
Summary
In conclusion, we can say
1.	Association follows many-to-many relationships.
2.	Aggregation follows a one-to-one relationship.
3.	The Composition follows a one-to-many relationship.



#### Java 8 Interview Questions
1.	Why do we need change to Java again?
2.	Java SE 8 New Features?
3.	Advantages of Java SE 8 New Features?
4.	What is Lambda Expression?
5.	What are the three parts of a Lambda Expression? What is the type of Lambda Expression?
6.	What is a Functional Interface? What is SAM Interface?
7.	Is is possible to define our own Functional Interface? What is @FunctionalInterface? What are the rules to define a Functional Interface?
8.	Is @FunctionalInterface annotation mandatory to define a Functional Interface? What is the use of @FunctionalInterface annotation? Why do we need Functional Interfaces in Java?
9.	When do we go for Java 8 Stream API? Why do we need to use Java 8 Stream API in our projects?
10.	Explain Differences between Collection API and Stream API?
11.	What is Spliterator in Java SE 8?Differences between Iterator and Spliterator in Java SE 8?
12.	What is Optional in Java 8? What is the use of Optional?Advantages of Java 8 Optional?
13.	What is Type Inference? Is Type Inference available in older versions like Java 7 and Before 7 or it is available only in Java SE 8?
#### Java 8 Interview Questions and Answers
In this section, we will pickup each question from previous section and answer it with in-detailed description. If you need any more information and examples, please go through previous Java SE 8 posts available in JournalDEV.
Why do we need change to Java again?
Oracle Corporation has introduced a lot of new concepts in Java SE 8 to introduce the following benefits:
•	To Utilize Current Multi-Core CPUs Efficiently
Recently, we can observe drastic changes in Hardware. Now-a-days, all systems are using Multi-Core CPUs (2,4,8,16-Core etc.) to deploy and run their Applications. We need new Programming Constructs in Java to utilize these Multi-Core Processors efficiently to develop Highly Concurrently and Highly Scalable applications.
•	To Utilize FP Features
Oracle Corporation has introduced a lot of FP(Functional Programming) concepts as part of Java SE 8 to utilize the advantages of FP.
Java SE 8 New Features?
•	Lambda Expressions
•	Functional Interfaces
•	Stream API
•	Date and Time API
•	Interface Default Methods and Static Methods
•	Spliterator
•	Method and Constructor References
•	Collections API Enhancements
•	Concurrency Utils Enhancements
•	Fork/Join Framework Enhancements
•	Internal Iteration
•	Parallel Array and Parallel Collection Operations
•	Optional
•	Type Annotations and Repeatable Annotations
•	Method Parameter Reflection
•	Base64 Encoding and Decoding
•	IO and NIO2 Enhancements
•	Nashorn JavaScript Engine
•	javac Enhancements
•	JVM Changes
•	Java 8 Compact Profiles: compact1,compact2,compact3
•	JDBC 4.2
•	JAXP 1.6
•	Java DB 10.10
•	Networking
•	Security Changes
Advantages of Java SE 8 New Features?
We can get the following benefits from Java SE 8 New Features:
•	More Concise and Readable code
•	More Reusable code
•	More Testable and Maintainable Code
•	Highly Concurrent and Highly Scalable Code
•	Write Parallel Code
•	Write Database Like Operations
•	Better Performance Applications
•	More Productive code
#### What is Lambda Expression?
Lambda Expression is an anonymous function which accepts a set of input parameters and returns results.
Lambda Expression is a block of code without any name, with or without parameters and with or without results. This block of code is executed on demand.
What are the three parts of a Lambda Expression? What is the type of Lambda Expression?
A Lambda Expression contains 3 parts:
•	Parameter List
A Lambda Expression can contain zero or one or more parameters. It is optional.
•	Lambda Arrow Operator
“->” is known as Lambda Arrow operator. It separates parameters list and body.
•	Lambda Expression Body
The type of “Journal Dev” is java.lang.String. The type of “true” is Boolean. In the same way, what is the type of a Lambda Expression?
The Type of a Lambda Expression is a Functional Interface.
Example:- What is the type of the following Lambda Expression?

   () -> System.out.println("Hello World");
This Lambda Expression does not have parameters and does return any results. So it’s type is “java.lang.Runnable” Functional Interface.
#### What is a Functional Interface? What is SAM Interface?
A Functional Interface is an interface, which contains one and only one abstract method. Functional Interface is also know as SAM Interface because it contains only one abstract method.
SAM Interface stands for Single Abstract Method Interface. Java SE 8 API has defined many Functional Interfaces.
Is is possible to define our own Functional Interface? What is @FunctionalInterface? What are the rules to define a Functional Interface?
Yes, it is possible to define our own Functional Interfaces. We use Java SE 8’s @FunctionalInterface annotation to mark an interface as Functional Interface.
We need to follow these rules to define a Functional Interface:
•	Define an interface with one and only one abstract method.
•	We cannot define more than one abstract method.
•	Use @FunctionalInterface annotation in interface definition.
•	We can define any number of other methods like Default methods, Static methods.
•	If we override java.lang.Object class’s method as an abstract method, which does not count as an abstract method.
Is @FunctionalInterface annotation mandatory to define a Functional Interface? What is the use of @FunctionalInterface annotation? Why do we need Functional Interfaces in Java?
It is not mandatory to define a Functional Interface with @FunctionalInterface annotation. If we don’t want, We can omit this annotation. However, if we use it in Functional Interface definition, Java Compiler forces to use one and only one abstract method inside that interface.
Why do we need Functional Interfaces? The type of a Java SE 8’s Lambda Expression is a Functional Interface. Whereever we use Lambda Expressions that means we are using Functional Interfaces.
When do we go for Java 8 Stream API? Why do we need to use Java 8 Stream API in our projects?
When our Java project wants to perform the following operations, it’s better to use Java 8 Stream API to get lot of benefits:
•	When we want perform Database like Operations. For instance, we want perform groupby operation, orderby operation etc.
•	When want to Perform operations Lazily.
•	When we want to write Functional Style programming.
•	When we want to perform Parallel Operations.
•	When want to use Internal Iteration
•	When we want to perform Pipelining operations.
•	When we want to achieve better performance.
#### Explain Differences between Collection API and Stream API?
S.No.	Collection API	Stream API
1.	It’s available since Java 1.2	It is introduced in Java SE8
2.	It is used to store Data(A set of Objects).	It is used to compute data(Computation on a set of Objects).
3.	We can use both Spliterator and Iterator to iterate elements. We can use forEach to performs an action for each element of this stream.	We can’t use Spliterator or Iterator to iterate elements.
4.	It is used to store limited number of Elements.	It is used to store either Limited or Infinite Number of Elements.
5.	Typically, it uses External Iteration concept to iterate Elements such as Iterator.	Stream API uses internal iteration to iterate Elements, using forEach methods.
6.	Collection Object is constructed Eagerly.	Stream Object is constructed Lazily.
7.	We add elements to Collection object only after it is computed completely.	We can add elements to Stream Object without any prior computation. That means Stream objects are computed on-demand.
8.	We can iterate and consume elements from a Collection Object at any number of times.	We can iterate and consume elements from a Stream Object only once.
#### What is Spliterator in Java SE 8?Differences between Iterator and Spliterator in Java SE 8?
Spliterator stands for Splitable Iterator. It is newly introduced by Oracle Corporation as part Java SE 8.
Like Iterator and ListIterator, It is also one of the Iterator interface.
S.No.	Spliterator	Iterator
1.	It is introduced in Java SE 8.	It is available since Java 1.2.
2.	Splitable Iterator	Non-Splitable Iterator
3.	It is used in Stream API.	It is used for Collection API.
4.	It uses Internal Iteration concept to iterate Streams.	It uses External Iteration concept to iterate Collections.
5.	We can use Spliterator to iterate Streams in Parallel and Sequential order.	We can use Iterator to iterate Collections only in Sequential order.
6.	We can get Spliterator by calling spliterator() method on Stream Object.	We can get Iterator by calling iterator() method on Collection Object.
7.	Important Method: tryAdvance()	Important Methods: next(), hasNext()
What is Optional in Java 8? What is the use of Optional?Advantages of Java 8 Optional?
#### Optional:
Optional is a final Class introduced as part of Java SE 8. It is defined in java.util package.
It is used to represent optional values that is either exist or not exist. It can contain either one value or zero value. If it contains a value, we can get it. Otherwise, we get nothing.
It is a bounded collection that is it contains at most one element only. It is an alternative to “null” value.
Main Advantage of Optional is:
•	It is used to avoid null checks.
•	It is used to avoid “NullPointerException”.
#### What is Type Inference? Is Type Inference available in older versions like Java 7 and Before 7 or it is available only in Java SE 8?
Type Inference means determining the Type by compiler at compile-time.
It is not new feature in Java SE 8. It is available in Java 7 and before Java 7 too.
Before Java 7:-
Let us explore Java arrays. Define a String of Array with values as shown below:

String str[] = { "Java 7", "Java 8", "Java 9" };
Here we have assigned some String values at right side, but not defined it’s type. Java Compiler automatically infers it’s type and creates a String of Array.
- Java 7:-
Oracle Corporation has introduced “Diamond Operator” new feature in Java SE 7 to avoid unnecessary Type definition in Generics.

Map<String,List<Customer>> customerInfoByCity = new HashMap<>();
Here we have not defined Type information at right side, simply defined Java SE 7’s Diamond Operator “”.
- Java SE 8:-
Oracle Corporation has enhanced this Type Inference concept a lot in Java SE 8. We use this concept to define Lambda Expressions, Functions, Method References etc.

ToIntBiFunction<Integer,Integer> add = (a,b) -> a + b;
Here Java Compiler observes the type definition available at left-side and determines the type of Lambda Expression parameters a and b as Integers.
That’s it about Java 8 Interview Questions.
I have discussed some Java SE 8 Interview Questions in this post and will discuss some more Java SE 8 Interview Questions in my coming posts.


#### Java SE 8 Interview Questions
1.	What is Internal Iteration in Java SE 8?
2.	Differences between External Iteration and Internal Iteration?
3.	What are the major drawbacks of External Iteration?
4.	What are the major advantages of Internal Iteration over External Iteration?
5.	What is the major drawback of Internal Iteration over External Iteration?
6.	What is the major advantage of External Iteration over Internal Iteration?
7.	When do we need to use Internal Iteration? When do we need to use External Iteration?
8.	Differences between Intermediate Operations and Terminal Operations of Java 8’s Stream API?
9.	Is it possible to provide method implementations in Java Interfaces? If possible, how do we provide them?
10.	What is a Default Method? Why do we need Default methods in Java 8 Interfaces?
11.	What is a Static Method? Why do we need Static methods in Java 8 Interfaces?
12.	Differences between Functional Programming and Object-Oriented Programming?
13.	Explain issues of Old Java Date API? What are the advantages of Java 8’s Date and Time API over Old Date API and Joda Time API?
14.	Why do we need new Date and Time API in Java SE 8?Explain how Java SE 8 Data and Time API solves issues of Old Java Date API?
15.	What are the Differences between Java’s OLD Java Date API and Java 8’s Date and Time API?
16.	What is Multiple Inheritance? How Java 8 supports Multiple Inheritance?
17.	What is Diamond Inheritance Problem? How Java 8 Solves this problem?
Java SE 8 Interview Questions and Answers
What is Internal Iteration in Java SE 8?
Before Java 8, We don’t Internal Iteration concept. Java 8 has introduced a new feature known as “Internal Iteration”. Before Java 8, Java Language has only External Iteration to iterate elements of an Aggregated Object like Collections, Arrays etc.
Internal Iteration means “Iterating an Aggregated Object elements one by one internally by Java API”. Instead of Java Application do iteration externally, We ask Java API to do this job internally.
Differences between External Iteration and Internal Iteration?
S.No.	External Iteration	Internal Iteration
1.	Available before Java 8 too.	It is introduced in Java SE 8
2.	Iterating an Aggregated Object elements externally.	Iterating an Aggregated Object elements internally (background).
3.	Iterate elements by using for-each loop and Iterators like Enumeration, Iterator, ListIterator.	Iterate elements by using Java API like “forEach” method.
4.	Iterating elements in Sequential and In-Order only.	Not required to iterate elements in Sequential order.
5.	It follows OOP approach that is Imperative Style.	It follows Functional Programming approach that is Declarative Style.
6.	It does NOT separate responsibilities properly that is, it defines both “What is to be done” and “How it is to be done”.	It defines only “What is to be done”. No need to worry about “How it is to be done”. Java API takes care about “How to do”.
7.	Less Readable Code.	More Readable code.
What are the major drawbacks of External Iteration?
External Iteration has the following drawbacks:
•	We need to write code in Imperative Style.
•	There is no clear separation of Responsibilities. Tightly-Coupling between “What is to be done” and “How it is to be done” code.
•	Less Readable Code.
•	More Verbose and Boilerplate code.
•	We have to iterate elements in Sequential order only.
•	It does not support Concurrency and Parallelism properly.
What are the major advantages of Internal Iteration over External Iteration?
Compare to External Iteration, Internal Iteration has the following advantages:
•	As it follows Functional Programming style, we can write Declarative Code.
•	More Readable and concise code.
•	Avoids writing Verbose and Boilerplate code
•	No need to iterate elements in Sequential order.
•	It supports Concurrency and Parallelism properly.
•	We can write Parallel code to improve application performance.
•	Clear separation of Responsibilities. Loosely-Coupling between “What is to be done” and “How it is to be done” code.
•	We need to write code only about “What is to be done” and Java API takes care about “How it is to be done” code.
What is the major drawback of Internal Iteration over External Iteration?
Compare to External Iteration, Internal Iteration has one major drawback:
•	In Internal Iteration, as Java API takes care about Iterating elements internally, we do NOT have control over Iteration.
What is the major advantage of External Iteration over Internal Iteration?
Compare to Internal Iteration, External Iteration has one major advantage:
•	In External Iteration, as Java API does NOT take care about Iterating elements, we have much control over Iteration.
When do we need to use Internal Iteration? When do we need to use External Iteration?
We need to understand the situations to use either Internal Iteration or External Iteration.
•	When we need more control over Iteration, we can use External Iteration.
•	When we do NOT need more control over Iteration, we can use Internal Iteration.
•	When we need to develop Highly Concurrency and Parallel applications and we , we should use Internal Iteration.
Differences between Intermediate Operations and Terminal Operations of Java 8’s Stream API?
S.No.	Stream Intermediate Operations	Stream Terminal Operations
1.	Stream Intermediate operations are not evaluated until we chain it with Stream Terminal Operation.	Stream Terminal Operations are evaluated on it’s own. No need other operations help.
2.	The output of Intermediate Operations is another Stream.	The output of Intermediate Operations is Not a Stream. Something else other than a Stream.
3.	Intermediate Operations are evaluated Lazily.	Terminal Operations are evaluated Eagerly.
4.	We can chain any number of Stream Intermediate Operations.	We can NOT chain Stream Terminal Operations.
5.	We can use any number of Stream Intermediate Operations per Statement.	We can use only one Stream Terminal Operation per Statement.
Is it possible to provide method implementations in Java Interfaces? If possible, how do we provide them?
In Java 7 or earlier, It is not possible to provide method implementations in Interfaces. Java 8 on-wards, it is possible.
In Java SE 8, We can provide method implementations in Interfaces by using the following two new concepts:
•	Default Methods
•	Static Methods
What is a Default Method? Why do we need Default methods in Java 8 Interfaces?
A Default Method is a method which is implemented in an interface with “default” keyword. It’s new featured introduced in Java SE 8.
We need Default Methods because of the following reasons:
•	It allow us to provide method’s implementation in Interfaces.
•	To add new Functionality to Interface without breaking the Classes which implement that Interface.
•	To provide elegant Backwards Compatibility Feature.
•	To ease of extend the existing Functionality.
•	To ease of Maintain the existing Functionality.
What is a Static Method? Why do we need Static methods in Java 8 Interfaces?
A Static Method is an Utility method or Helper method, which is associated to a class (or interface). It is not associated to any object.
We need Static Methods because of the following reasons:
•	We can keep Helper or Utility methods specific to an interface in the same interface rather than in a separate Utility class.
•	We do not need separate Utility Classes like Collections, Arrays etc to keep Utility methods.
•	Clear separation of Responsibilities. That is we do not need one Utility class to keep all Utility methods of Collection API like Collections etc.
•	Easy to extend the API.
•	Easy to Maintain the API.
Differences between Functional Programming and Object-Oriented Programming?
Functional Programming	OOP
Does not exist State	Exists State
Uses Immutable data
Uses Mutable data
It follows Declarative Programming Model	It follows Imperative Programming Model
Stateless Programming Model	Stateful Programming Model
Main Fcous on: “What you are doing”	Main focus on “How you are doing”
Good for Parallel (Concurrency) Programming	Poor for Parallel (Concurrency) Programming
Good for BigData processing and analysis	NOT Good for BigData processing and analysis
Supports pure Encapsulation	It breaks Encapsulation concept
Functions with No-Side Effects	Methods with Side Effects
Functions are first-class citizens	Objects are first-class citizens
Primary Manipulation Unit is “Function”	Primary Manipulation Unit is Objects(Instances of Classes)
Flow Controls: Function calls, Function Calls with Recursion	Flow Controls: Loops, Conditional Statements
It uses “Recursion” concept to iterate Collection Data.	It uses “Loop” concept to iterate Collection Data. For example:-For-each loop in Java
Order of execution is less importance.	Order of execution is must and very important.
Supports both “Abstraction over Data” and “Abstraction over Behavior”.	Supports only “Abstraction over Data”.
We use FP when we have few Things with more operations.	We use OOP when we have few Operations with more Things. For example: Things are classes and Operations are Methods in Java.
NOTE:- For more information about FP, IP and OOP comparisons, Please go through my previous post at: “Compare FP, OOP(IP)”
Explain issues of Old Java Date API? What are the advantages of Java 8’s Date and Time API over Old Date API and Joda Time API?
Java’s OLD Java Date API means Date API available before Java SE 8 that is Date, Calendar, SimpleDateFormat etc.
Java’s Old Date API has the following Issues or Drawbacks compare to Java 8’s Date and Time API and Joda Time API.
•	Most of the API is deprecated.
•	Less Readability.
•	java.util.Date is Mutable and not Thread-Safe.
•	java.text.SimpleDateFormat is not Thread-Safe.
•	Less Performance.
Java SE 8’s Date and Time API has the following Advantages compare to Java’s OLD Date API.
•	Very simple to use.
•	Human Readable Syntax that is More Readability.
•	All API is Thread-Safe.
•	Better Performance.
Why do we need new Date and Time API in Java SE 8?Explain how Java SE 8 Data and Time API solves issues of Old Java Date API?
We need Java 8’s Date and Time API to develop Highly Performance, Thread-Safe and Highly Scalable Java Applications.
Java 8’s Date and Time API solves all Java’s Old Date API issues by following Immutability and Thread-Safety principles.
What are the Differences between Java’s OLD Java Date API and Java 8’s Date and Time API?
Differences between Java’s OLD Java Date API and Java 8’s Date and Time API:
S.No.	Java’s OLD Java Date API	Java 8’s Date and Time API
1.	Available before Java 8 too.	It is introduced in Java SE 8
2.	Not Thread Safe.	Thread Safe.
3.	Mutable API.	Immutable API.
4.	Less Performance.	Better Performance.
5.	Less Readability.	More Readability.
6.	It’s not recommended to use as its deprecated.	It’s always recommended to use.
7.	Not Extendable.	Easy to Extend.
8.	It defines months values from 0 to 11, that is January = 0.	It defines months values from 1 to 12, that is January = 1.
9.	It’s an old API.	It’s a new API.
#### What is Multiple Inheritance? How Java 8 supports Multiple Inheritance?
Multiple Inheritance means a class can inherit or extend characteristics and features from more than one parent class.
In Java 7 or Earlier, Multiple Inheritance is not possible because Java follows “A class should extend one and only one class or abstract class” Rule. However, it’s possible to provide Multiple Implementation Inheritance using Interface because Java follows “A class can extend any number of Interfaces” Rule.
However, Java 8 supports “Implementing Methods in Interfaces” by introducing new features: Default methods in Interface. Because of this feature, Java 8 supports Multiple Inheritance with some limitations.
#### What is Diamond Problem in Inheritance? How Java 8 Solves this problem?
A Diamond Problem is a Multiple Inheritance problem. In Java, It occurs when a Class extends more than one Interface which have same method implementation (Default method).
 
This above diagram shows Diamond Problem. To avoid this problem, Java 7 and Earlier versions does not support methods implementation in interface and also doesn’t support Multiple Inheritance. Java 8 has introduced new feature: Default methods to support Multiple Inheritance with some limitations.
Sample Java SE 8 Code to show this Diamond Problem:

public interface A{   
  default void display() { //code goes here }
}
public interface B extends A{ }
public interface C extends A{ }
public class D implements B,C{ }
In the above code snippet, class D gives compiltime errors because Java Compiler will get bit confusion about which display() has to provide in class D. Class D inherits display() method from both interfaces B and C. To solve this problem, Java SE 8 has given the following remedy:

public interface A{   
  default void display() { //code goes here }
}
public interface B extends A{ }
public interface C extends A{ }
public class D implements B,C{
  void display() { 
    B.super.display();       
  }
}
This B.super.display(); will solve this Diamond Problem.
That’s it all about Java 8 Interview Questions. We will discuss some more Java SE 8 Interview Questions in my coming posts.

#### Java Multithreading Interview Questions and Answers
1.	What is the difference between Process and Thread?
A process is a self contained execution environment and it can be seen as a program or application whereas Thread is a single task of execution within the process. Java runtime environment runs as a single process which contains different classes and programs as processes. Thread can be called lightweight process. Thread requires less resources to create and exists in the process, thread shares the process resources.
2.	What are the benefits of multi-threaded programming?
In Multi-Threaded programming, multiple threads are executing concurrently that improves the performance because CPU is not idle incase some thread is waiting to get some resources. Multiple threads share the heap memory, so it’s good to create multiple threads to execute some task rather than creating multiple processes. For example, Servlets are better in performance than CGI because Servlet support multi-threading but CGI doesn’t.
3.	What is difference between user Thread and daemon Thread?
When we create a Thread in java program, it’s known as user thread. A daemon thread runs in background and doesn’t prevent JVM from terminating. When there are no user threads running, JVM shutdown the program and quits. A child thread created from daemon thread is also a daemon thread.
4.	How can we create a Thread in Java?
There are two ways to create Thread in Java – first by implementing Runnable interface and then creating a Thread object from it and second is to extend the Thread Class. Read this post to learn more about creating threads in java.
5.	What are different states in lifecycle of Thread?
When we create a Thread in java program, its state is New. Then we start the thread that change it’s state to Runnable. Thread Scheduler is responsible to allocate CPU to threads in Runnable thread pool and change their state to Running. Other Thread states are Waiting, Blocked and Dead. Read this post to learn more about life cycle of thread.
6.	Can we call run() method of a Thread class?
Yes, we can call run() method of a Thread class but then it will behave like a normal method. To actually execute it in a Thread, we need to start it using Thread.start() method.
7.	How can we pause the execution of a Thread for specific time?
We can use Thread class sleep() method to pause the execution of Thread for certain time. Note that this will not stop the processing of thread for specific time, once the thread awake from sleep, it’s state gets changed to runnable and based on thread scheduling, it gets executed.
8.	What do you understand about Thread Priority?
Every thread has a priority, usually higher priority thread gets precedence in execution but it depends on Thread Scheduler implementation that is OS dependent. We can specify the priority of thread but it doesn’t guarantee that higher priority thread will get executed before lower priority thread. Thread priority is an int whose value varies from 1 to 10 where 1 is the lowest priority thread and 10 is the highest priority thread.
9.	What is Thread Scheduler and Time Slicing?
Thread Scheduler is the Operating System service that allocates the CPU time to the available runnable threads. Once we create and start a thread, it’s execution depends on the implementation of Thread Scheduler. Time Slicing is the process to divide the available CPU time to the available runnable threads. Allocation of CPU time to threads can be based on thread priority or the thread waiting for longer time will get more priority in getting CPU time. Thread scheduling can’t be controlled by java, so it’s always better to control it from application itself.
10.	What is context-switching in multi-threading?
Context Switching is the process of storing and restoring of CPU state so that Thread execution can be resumed from the same point at a later point of time. Context Switching is the essential feature for multitasking operating system and support for multi-threaded environment.
11.	How can we make sure main() is the last thread to finish in Java Program?
We can use Thread join() method to make sure all the threads created by the program is dead before finishing the main function. Here is an article about Thread join method.
12.	How does thread communicate with each other?
When threads share resources, communication between Threads is important to coordinate their efforts. Object class wait(), notify() and notifyAll() methods allows threads to communicate about the lock status of a resource. Check this post to learn more about thread wait, notify and notifyAll.
13.	Why thread communication methods wait(), notify() and notifyAll() are in Object class?
In Java every Object has a monitor and wait, notify methods are used to wait for the Object monitor or to notify other threads that Object monitor is free now. There is no monitor on threads in java and synchronization can be used with any Object, that’s why it’s part of Object class so that every class in java has these essential methods for inter thread communication.
14.	Why wait(), notify() and notifyAll() methods have to be called from synchronized method or block?
When a Thread calls wait() on any Object, it must have the monitor on the Object that it will leave and goes in wait state until any other thread call notify() on this Object. Similarly when a thread calls notify() on any Object, it leaves the monitor on the Object and other waiting threads can get the monitor on the Object. Since all these methods require Thread to have the Object monitor, that can be achieved only by synchronization, they need to be called from synchronized method or block.
15.	Why Thread sleep() and yield() methods are static?
Thread sleep() and yield() methods work on the currently executing thread. So there is no point in invoking these methods on some other threads that are in wait state. That’s why these methods are made static so that when this method is called statically, it works on the current executing thread and avoid confusion to the programmers who might think that they can invoke these methods on some non-running threads.
16.	How can we achieve thread safety in Java?
There are several ways to achieve thread safety in java – synchronization, atomic concurrent classes, implementing concurrent Lock interface, using volatile keyword, using immutable classes and Thread safe classes. Learn more at thread safety tutorial.
17.	What is volatile keyword in Java
When we use volatile keyword with a variable, all the threads read it’s value directly from the memory and don’t cache it. This makes sure that the value read is the same as in the memory.
18.	Which is more preferred – Synchronized method or Synchronized block?
Synchronized block is more preferred way because it doesn’t lock the Object, synchronized methods lock the Object and if there are multiple synchronization blocks in the class, even though they are not related, it will stop them from execution and put them in wait state to get the lock on Object.
19.	How to create daemon thread in Java?
Thread class setDaemon(true) can be used to create daemon thread in java. We need to call this method before calling start() method else it will throw IllegalThreadStateException.
20.	What is ThreadLocal?
Java ThreadLocal is used to create thread-local variables. We know that all threads of an Object share it’s variables, so if the variable is not thread safe, we can use synchronization but if we want to avoid synchronization, we can use ThreadLocal variables.
Every thread has its own ThreadLocal variable and they can use it gets () and set() methods to get the default value or change it’s value local to Thread. ThreadLocal instances are typically private static fields in classes that wish to associate the state with a thread. Check this post for small example program showing ThreadLocal Example.
21.	What is Thread Group? Why it’s advised not to use it?
ThreadGroup is a class which was intended to provide information about a thread group. ThreadGroup API is weak and it doesn’t have any functionality that is not provided by Thread. It has two main features – to get the list of active threads in a thread group and to set the uncaught exception handler for the thread. But Java 1.5 has added setUncaughtExceptionHandler(UncaughtExceptionHandler eh) method using which we can add uncaught exception handler to the thread. So ThreadGroup is obsolete and hence not advised to use anymore.

t1.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){

@Override
public void uncaughtException(Thread t, Throwable e) {
    System.out.println("exception occured:"+e.getMessage());
}
            
});
22.	What is Java Thread Dump, How can we get Java Thread dump of a Program?
A thread dump is a list of all the threads active in the JVM, thread dumps are very helpful in analyzing bottlenecks in the application and analyzing deadlock situations. There are many ways using which we can generate Thread dump – Using Profiler, Kill -3 command, jstack tool, etc. I prefer jstack tool to generate thread dump of a program because it’s easy to use and comes with JDK installation. Since it’s a terminal-based tool, we can create a script to generate thread dump at regular intervals to analyze it later on. Read this post to know more about generating thread dump in java.
23.	What is Deadlock? How to analyze and avoid deadlock situation?
Deadlock is a programming situation where two or more threads are blocked forever, this situation arises with at least two threads and two or more resources.
To analyze a deadlock, we need to look at the java thread dump of the application, we need to look out for the threads with state as BLOCKED and then the resources it’s waiting to lock, every resource has a unique ID using which we can find which thread is already holding the lock on the object.
Avoid Nested Locks, Lock Only What is Required and Avoid waiting indefinitely are common ways to avoid deadlock situation, read this post to learn how to analyze deadlock in java with a sample program.
24.	What is Java Timer Class? How to schedule a task to run after the specified interval?
java.util.Timer is a utility class that can be used to schedule a thread to be executed at a certain time in future. Java Timer class can be used to schedule a task to be run one-time or to be run at regular intervals.
java.util.TimerTask is an abstract class that implements Runnable interface and we need to extend this class to create our own TimerTask that can be scheduled using java Timer class.
Check this post for java Timer example.
25.	What is Thread Pool? How can we create Thread Pool in Java?
A thread pool manages the pool of worker threads, it contains a queue that keeps tasks waiting to get executed.
A thread pool manages the collection of Runnable threads and worker threads execute Runnable from the queue.
java.util.concurrent.Executors provide implementation of java.util.concurrent.Executor interface to create the thread pool in java. Thread Pool Example program shows how to create and use Thread Pool in java. Or read ScheduledThreadPoolExecutor Example to know how to schedule tasks after certain delay.
26.	What will happen if we don’t override Thread class run() method?
Thread class run() method code is as shown below.

public void run() {
    if (target != null) {
        target.run();
    }
}
Above target set in the init() method of Thread class and if we create an instance of Thread class as new TestThread(), it’s set to null. So nothing will happen if we don’t override the run() method. Below is a simple example demonstrating this.

public class TestThread extends Thread {

	//not overriding Thread.run() method
	
	//main method, can be in other class too
	public static void main(String args[]){
		Thread t = new TestThread();
		System.out.println("Before starting thread");
		t.start();
		System.out.println("After starting thread");
	}
}
It will print only below output and terminate.

Before starting thread
After starting thread
Java Concurrency Interview Questions and Answers
1.	What is atomic operation? What are atomic classes in Java Concurrency API?
Atomic operations are performed in a single unit of task without interference from other operations. Atomic operations are necessity in multi-threaded environment to avoid data inconsistency.
int++ is not an atomic operation. So by the time one thread read its value and increment it by one, another thread has read the older value leading to the wrong result.
To solve this issue, we will have to make sure that increment operation on count is atomic, we can do that using Synchronization but Java 5 java.util.concurrent.atomic provides wrapper classes for int and long that can be used to achieve this atomically without the usage of Synchronization. Go to this article to learn more about atomic concurrent classes.
2.	What is Lock interface in Java Concurrency API? What are its benefits over synchronization?
Lock interface provides more extensive locking operations than can be obtained using synchronized methods and statements. They allow more flexible structuring, may have quite different properties and may support multiple associated Condition objects.
The advantages of a lock are
•	it’s possible to make them fair
•	it’s possible to make a thread responsive to interruption while waiting on a Lock object.
•	it’s possible to try to acquire the lock, but return immediately or after a timeout if the lock can’t be acquired
•	it’s possible to acquire and release locks in different scopes, and in different orders
Read more at Java Lock Example.
3.	What is Executors Framework?
In Java 5, Executor framework was introduced with the java.util.concurrent.Executor interface.
The Executor framework is a framework for standardizing invocation, scheduling, execution, and control of asynchronous tasks according to a set of execution policies.
Creating a lot many threads with no bounds to the maximum threshold can cause the application to run out of heap memory. So, creating a ThreadPool is a better solution as a finite number of threads can be pooled and reused. Executors framework facilitate the process of creating Thread pools in java. Check out this post to learn with example code to create thread pool using Executors framework.
4.	What is BlockingQueue? How can we implement Producer-Consumer problem using Blocking Queue?
java.util.concurrent.BlockingQueue is a Queue that supports operations that wait for the queue to become non-empty when retrieving and removing an element, and wait for space to become available in the queue when adding an element.
BlockingQueue doesn’t accept null values and throw NullPointerException if you try to store null value in the queue.
BlockingQueue implementations are thread-safe. All queuing methods are atomic in nature and use internal locks or other forms of concurrency control.
BlockingQueue interface is part of the Java collections framework and it’s primarily used for implementing the producer-consumer problem.
Check this post for producer-consumer problem implementation using BlockingQueue.
5.	What is Callable and Future?
Java 5 introduced java.util.concurrent.Callable interface in concurrency package that is similar to Runnable interface but it can return any Object and able to throw Exception.
The Callable interface uses Generics to define the return type of Object. Executors class provide useful methods to execute Callable in a thread pool. Since callable tasks run in parallel, we have to wait for the returned Object. Callable tasks return java.util.concurrent.Future object. Using Future we can find out the status of the Callable task and get the returned Object. It provides the get() method that can wait for the Callable to finish and then return the result.
Check this post for Callable Future Example.
6.	What is FutureTask Class?
FutureTask is the base implementation class of Future interface and we can use it with Executors for asynchronous processing. Most of the time we don’t need to use FutureTask class but it comes real handy if we want to override some of the methods of Future interface and want to keep most of the base implementation. We can just extend this class and override the methods according to our requirements. Check out Java FutureTask Example post to learn how to use it and what are different methods it has.
7.	What are Concurrent Collection Classes?
Java Collection classes are fail-fast which means that if the Collection will be changed while some thread is traversing over it using iterator, the iterator.next() will throw ConcurrentModificationException.
Concurrent Collection classes support full concurrency of retrievals and adjustable expected concurrency for updates.
Major classes are ConcurrentHashMap, CopyOnWriteArrayList and CopyOnWriteArraySet, check this post to learn how to avoid ConcurrentModificationException when using iterator.
8.	What is Executors Class?
Executors class provide utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes.
Executors class can be used to easily create Thread Pool in java, also this is the only class supporting execution of Callable implementations.
9.	What are some of the improvements in Concurrency API in Java 8?
Some important concurrent API enhancements are:
•	ConcurrentHashMap compute(), forEach(), forEachEntry(), forEachKey(), forEachValue(), merge(), reduce() and search() methods.
•	CompletableFuture that may be explicitly completed (setting its value and status).
•	Executors newWorkStealingPool() method to create a work-stealing thread pool using all available processors as its target parallelism level.
Recommended Read: Java 8 Features
1.	What is Exception in Java?
Exception is an error event that can happen during the execution of a program and disrupts it’s normal flow. Exception can arise from different kind of situations such as wrong data entered by user, hardware failure, network connection failure etc.
Whenever any error occurs while executing a java statement, an exception object is created and then JRE tries to find exception handler to handle the exception. If suitable exception handler is found then the exception object is passed to the handler code to process the exception, known as catching the exception. If no handler is found then application throws the exception to runtime environment and JRE terminates the program.
Java Exception handling framework is used to handle runtime errors only, compile time errors are not handled by exception handling framework.
2.	What are the Exception Handling Keywords in Java?
There are four keywords used in java exception handling.
1.	throw: Sometimes we explicitly want to create exception object and then throw it to halt the normal processing of the program. throw keyword is used to throw exception to the runtime to handle it.
2.	throws: When we are throwing any checked exception in a method and not handling it, then we need to use throws keyword in method signature to let caller program know the exceptions that might be thrown by the method. The caller method might handle these exceptions or propagate it to it’s caller method using throws keyword. We can provide multiple exceptions in the throws clause and it can be used with main() method also.
3.	try-catch: We use try-catch block for exception handling in our code. try is the start of the block and catch is at the end of try block to handle the exceptions. We can have multiple catch blocks with a try and try-catch block can be nested also. catch block requires a parameter that should be of type Exception.
4.	finally: finally block is optional and can be used only with try-catch block. Since exception halts the process of execution, we might have some resources open that will not get closed, so we can use finally block. finally block gets executed always, whether exception occurrs or not.
3.	Explain Java Exception Hierarchy?
Java Exceptions are hierarchical and inheritance is used to categorize different types of exceptions. Throwable is the parent class of Java Exceptions Hierarchy and it has two child objects – Error and Exception. Exceptions are further divided into checked exceptions and runtime exception.
Errors are exceptional scenarios that are out of scope of application and it’s not possible to anticipate and recover from them, for example hardware failure, JVM crash or out of memory error.
Checked Exceptions are exceptional scenarios that we can anticipate in a program and try to recover from it, for example FileNotFoundException. We should catch this exception and provide useful message to user and log it properly for debugging purpose. Exception is the parent class of all Checked Exceptions.
Runtime Exceptions are caused by bad programming, for example trying to retrieve an element from the Array. We should check the length of array first before trying to retrieve the element otherwise it might throw ArrayIndexOutOfBoundException at runtime. RuntimeException is the parent class of all runtime exceptions.
 
4.	What are important methods of Java Exception Class?
Exception and all of it’s subclasses doesn’t provide any specific methods and all of the methods are defined in the base class Throwable.
1.	String getMessage() – This method returns the message String of Throwable and the message can be provided while creating the exception through it’s constructor.
2.	String getLocalizedMessage() – This method is provided so that subclasses can override it to provide locale specific message to the calling program. Throwable class implementation of this method simply use getMessage() method to return the exception message.
3.	synchronized Throwable getCause() – This method returns the cause of the exception or null id the cause is unknown.
4.	String toString() – This method returns the information about Throwable in String format, the returned String contains the name of Throwable class and localized message.
5.	void printStackTrace() – This method prints the stack trace information to the standard error stream, this method is overloaded and we can pass PrintStream or PrintWriter as argument to write the stack trace information to the file or stream.
5.	Explain Java 7 ARM Feature and multi-catch block?
If you are catching a lot of exceptions in a single try block, you will notice that catch block code looks very ugly and mostly consists of redundant code to log the error, keeping this in mind Java 7 one of the feature was multi-catch block where we can catch multiple exceptions in a single catch block. The catch block with this feature looks like below:

catch(IOException | SQLException | Exception ex){
     logger.error(ex);
     throw new MyException(ex.getMessage());
}
Most of the time, we use finally block just to close the resources and sometimes we forget to close them and get runtime exceptions when the resources are exhausted. These exceptions are hard to debug and we might need to look into each place where we are using that type of resource to make sure we are closing it. So java 7 one of the improvement was try-with-resources where we can create a resource in the try statement itself and use it inside the try-catch block. When the execution comes out of try-catch block, runtime environment automatically close these resources. Sample of try-catch block with this improvement is:

try (MyResource mr = new MyResource()) {
            System.out.println("MyResource created in try-with-resources");
        } catch (Exception e) {
            e.printStackTrace();
        }
Read more about this at Java 7 ARM.
6.	What is difference between Checked and Unchecked Exception in Java?
1.	Checked Exceptions should be handled in the code using try-catch block or else method should use throws keyword to let the caller know about the checked exceptions that might be thrown from the method. Unchecked Exceptions are not required to be handled in the program or to mention them in throws clause of the method.
2.	Exception is the super class of all checked exceptions whereas RuntimeException is the super class of all unchecked exceptions. Note that RuntimeException is the child class of Exception.
3.	Checked exceptions are error scenarios that requires to be handled in the code, or else you will get compile time error. For example, if you use FileReader to read a file, it throws FileNotFoundException and we must catch it in the try-catch block or throw it again to the caller method. Unchecked exceptions are mostly caused by poor programming, for example NullPointerException when invoking a method on an object reference without making sure that it’s not null. For example, I can write a method to remove all the vowels from the string. It’s the caller responsibility to make sure not to pass null string. I might change the method to handle these scenarios but ideally the caller should take care of this.
7.	What is difference between throw and throws keyword in Java?
throws keyword is used with method signature to declare the exceptions that the method might throw whereas throw keyword is used to disrupt the flow of program and handing over the exception object to runtime to handle it.
8.	How to write custom exception in Java?
We can extend Exception class or any of it’s subclasses to create our custom exception class. The custom exception class can have it’s own variables and methods that we can use to pass error codes or other exception related information to the exception handler.
A simple example of custom exception is shown below.

package com.journaldev.exceptions;

import java.io.IOException;

public class MyException extends IOException {

	private static final long serialVersionUID = 4664456874499611218L;
	
	private String errorCode="Unknown_Exception";
	
	public MyException(String message, String errorCode){
		super(message);
		this.errorCode=errorCode;
	}
	
	public String getErrorCode(){
		return this.errorCode;
	}
	

}
9.	What is OutOfMemoryError in Java?
OutOfMemoryError in Java is a subclass of java.lang.VirtualMachineError and it’s thrown by JVM when it ran out of heap memory. We can fix this error by providing more memory to run the java application through java options.
$>java MyProgram -Xms1024m -Xmx1024m -XX:PermSize=64M -XX:MaxPermSize=256m
10.	What are different scenarios causing “Exception in thread main”?
Some of the common main thread exception scenarios are:
•	Exception in thread main java.lang.UnsupportedClassVersionError: This exception comes when your java class is compiled from another JDK version and you are trying to run it from another java version.
•	Exception in thread main java.lang.NoClassDefFoundError: There are two variants of this exception. The first one is where you provide the class full name with .class extension. The second scenario is when Class is not found.
•	Exception in thread main java.lang.NoSuchMethodError: main: This exception comes when you are trying to run a class that doesn’t have main method.
•	Exception in thread “main” java.lang.ArithmeticException: Whenever any exception is thrown from main method, it prints the exception is console. The first part explains that exception is thrown from main method, second part prints the exception class name and then after a colon, it prints the exception message.
Read more about these at Java Exception in Thread main.
11.	What is difference between final, finally and finalize in Java?
final and finally are keywords in java whereas finalize is a method.
final keyword can be used with class variables so that they can’t be reassigned, with class to avoid extending by classes and with methods to avoid overriding by subclasses, finally keyword is used with try-catch block to provide statements that will always gets executed even if some exception arises, usually finally is used to close resources. finalize() method is executed by Garbage Collector before the object is destroyed, it’s great way to make sure all the global resources are closed.
Out of the three, only finally is related to java exception handling.
12.	What happens when exception is thrown by main method?
When exception is thrown by main() method, Java Runtime terminates the program and print the exception message and stack trace in system console.
13.	Can we have an empty catch block?
We can have an empty catch block but it’s the example of worst programming. We should never have empty catch block because if the exception is caught by that block, we will have no information about the exception and it wil be a nightmare to debug it. There should be at least a logging statement to log the exception details in console or log files.
14.	Provide some Java Exception Handling Best Practices?
Some of the best practices related to Java Exception Handling are:
•	Use Specific Exceptions for ease of debugging.
•	Throw Exceptions Early (Fail-Fast) in the program.
•	Catch Exceptions late in the program, let the caller handle the exception.
•	Use Java 7 ARM feature to make sure resources are closed or use finally block to close them properly.
•	Always log exception messages for debugging purposes.
•	Use multi-catch block for cleaner close.
•	Use custom exceptions to throw single type of exception from your application API.
•	Follow naming convention, always end with Exception.
•	Document the Exceptions Thrown by a method using @throws in javadoc.
•	Exceptions are costly, so throw it only when it makes sense. Else you can catch them and provide null or empty response.
Read more about them in detail at Java Exception Handling Best Practices.
15.	What is the problem with below programs and how do we fix it?
In this section, we will look into some programming questions related to java exceptions.
0.	What is the problem with below program?
1.	
2.	package com.journaldev.exceptions;
3.	
4.	import java.io.FileNotFoundException;
5.	import java.io.IOException;
6.	
7.	public class TestException {
8.	
9.		public static void main(String[] args) {
10.			try {
11.				testExceptions();
12.			} catch (FileNotFoundException | IOException e) {
13.				e.printStackTrace();
14.			}
15.		}
16.		
17.		
18.		
19.		public static void testExceptions() throws IOException, FileNotFoundException{
20.			
21.		}
22.	}
Above program won’t compile and you will get error message as “The exception FileNotFoundException is already caught by the alternative IOException”. This is because FileNotFoundException is subclass of IOException, there are two ways to solve this problem.
First way is to use single catch block for both the exceptions.

		try {
			testExceptions();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException  e) {
			e.printStackTrace();
		}
Another way is to remove the FileNotFoundException from multi-catch block.

		try {
			testExceptions();
		}catch (IOException  e) {
			e.printStackTrace();
		}
You can chose any of these approach based on your catch block code.
23.	What is the problem with below program?
24.	
25.	package com.journaldev.exceptions;
26.	
27.	import java.io.FileNotFoundException;
28.	import java.io.IOException;
29.	
30.	import javax.xml.bind.JAXBException;
31.	
32.	public class TestException1 {
33.	
34.		public static void main(String[] args) {
35.				try {
36.					go();
37.				} catch (IOException e) {
38.					e.printStackTrace();
39.				} catch (FileNotFoundException e) {
40.					e.printStackTrace();
41.				} catch (JAXBException e) {
42.					e.printStackTrace();
43.				}
44.		}
45.	
46.		public static void go() throws IOException, JAXBException, FileNotFoundException{
47.			
48.		}
49.	}
The program won’t compile because FileNotFoundException is subclass of IOException, so the catch block of FileNotFoundException is unreachable and you will get error message as “Unreachable catch block for FileNotFoundException. It is already handled by the catch block for IOException”.
You need to fix the catch block order to solve this issue.

			try {
				go();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
Notice that JAXBException is not related to IOException or FileNotFoundException and can be put anywhere in above catch block hierarchy.
50.	What is the problem with below program?
51.	
52.	package com.journaldev.exceptions;
53.	
54.	import java.io.IOException;
55.	
56.	import javax.xml.bind.JAXBException;
57.	
58.	public class TestException2 {
59.	
60.		public static void main(String[] args) {
61.			try {
62.				foo();
63.			} catch (IOException e) {
64.				e.printStackTrace();
65.			}catch(JAXBException e){
66.				e.printStackTrace();
67.			}catch(NullPointerException e){
68.				e.printStackTrace();
69.			}catch(Exception e){
70.				e.printStackTrace();
71.			}
72.		}
73.	
74.		public static void foo() throws IOException{
75.			
76.		}
77.	}
The program won’t compile because JAXBException is a checked exception and foo() method should throw this exception to catch in the calling method. You will get error message as “Unreachable catch block for JAXBException. This exception is never thrown from the try statement body”.
To solve this issue, you will have to remove the catch block of JAXBException.
Notice that catching NullPointerException is valid because it’s an unchecked exception.
78.	What is the problem with below program?
79.	
80.	package com.journaldev.exceptions;
81.	
82.	public class TestException3 {
83.	
84.		public static void main(String[] args) {
85.			try{
86.			bar();
87.			}catch(NullPointerException e){
88.				e.printStackTrace();
89.			}catch(Exception e){
90.				e.printStackTrace();
91.			}
92.			
93.			foo();
94.		}
95.	
96.		public static void bar(){
97.			
98.		}
99.		
100.		public static void foo() throws NullPointerException{
101.			
102.		}
103.	}
This is a trick question, there is no problem with the code and it will compile successfully. We can always catch Exception or any unchecked exception even if it’s not in the throws clause of the method.
Similarly if a method (foo) declares unchecked exception in throws clause, it is not mandatory to handle that in the program.
104.	What is the problem with below program?
105.	
106.	package com.journaldev.exceptions;
107.	
108.	import java.io.IOException;
109.	
110.	public class TestException4 {
111.	
112.		public void start() throws IOException{		
113.		}
114.		
115.		public void foo() throws NullPointerException{
116.			
117.		}
118.	}
119.	
120.	class TestException5 extends TestException4{
121.		
122.		public void start() throws Exception{
123.		}
124.		
125.		public void foo() throws RuntimeException{
126.			
127.		}
128.	}
The above program won’t compile because start() method signature is not same in subclass. To fix this issue, we can either change the method singnature in subclass to be exact same as superclass or we can remove throws clause from subclass method as shown below.

@Override
	public void start(){
	}
129.	What is the problem with below program?
130.	
131.	package com.journaldev.exceptions;
132.	
133.	import java.io.IOException;
134.	
135.	import javax.xml.bind.JAXBException;
136.	
137.	public class TestException6 {
138.	
139.		public static void main(String[] args) {
140.			try {
141.				foo();
142.			} catch (IOException | JAXBException e) {
143.				e = new Exception("");
144.				e.printStackTrace();
145.			}catch(Exception e){
146.				e = new Exception("");
147.				e.printStackTrace();
148.			}
149.		}
150.	
151.		public static void foo() throws IOException, JAXBException{
152.			
153.		}
154.	}
The above program won’t compile because exception object in multi-catch block is final and we can’t change it’s value. You will get compile time error as “The parameter e of a multi-catch block cannot be assigned”.
We have to remove the assignment of “e” to new exception object to solve this error.

https://www.journaldev.com/2389/java-8-features-with-examples

1. Generics in Java
Generics was added in Java 5 to provide compile-time type checking and removing risk of ClassCastException that was common while working with collection classes. The whole collection framework was re-written to use generics for type-safety. Let’s see how generics help us using collection classes safely.

List list = new ArrayList();
list.add("abc");
list.add(new Integer(5)); //OK

for(Object obj : list){
	//type casting leading to ClassCastException at runtime
    String str=(String) obj; 
}
Above code compiles fine but throws ClassCastException at runtime because we are trying to cast Object in the list to String whereas one of the element is of type Integer. After Java 5, we use collection classes like below.

List<String> list1 = new ArrayList<String>(); // java 7 ? List<String> list1 = new ArrayList<>(); 
list1.add("abc");
//list1.add(new Integer(5)); //compiler error

for(String str : list1){
     //no type casting needed, avoids ClassCastException
}
Notice that at the time of list creation, we have specified that the type of elements in the list will be String. So if we try to add any other type of object in the list, the program will throw compile-time error. Also notice that in for loop, we don’t need typecasting of the element in the list, hence removing the ClassCastException at runtime.
2. Java Generic Class
We can define our own classes with generics type. A generic type is a class or interface that is parameterized over types. We use angle brackets (<>) to specify the type parameter.
To understand the benefit, let’s say we have a simple class as:

package com.journaldev.generics;

public class GenericsTypeOld {

	private Object t;

	public Object get() {
		return t;
	}

	public void set(Object t) {
		this.t = t;
	}

        public static void main(String args[]){
		GenericsTypeOld type = new GenericsTypeOld();
		type.set("Pankaj"); 
		String str = (String) type.get(); //type casting, error prone and can cause ClassCastException
	}
}
Notice that while using this class, we have to use type casting and it can produce ClassCastException at runtime. Now we will use java generic class to rewrite the same class as shown below.

package com.journaldev.generics;

public class GenericsType<T> {

	private T t;
	
	public T get(){
		return this.t;
	}
	
	public void set(T t1){
		this.t=t1;
	}
	
	public static void main(String args[]){
		GenericsType<String> type = new GenericsType<>();
		type.set("Pankaj"); //valid
		
		GenericsType type1 = new GenericsType(); //raw type
		type1.set("Pankaj"); //valid
		type1.set(10); //valid and autoboxing support
	}
}
Notice the use of GenericsType class in the main method. We don’t need to do type-casting and we can remove ClassCastException at runtime. If we don’t provide the type at the time of creation, the compiler will produce a warning that “GenericsType is a raw type.
References to generic type GenericsType<T> should be parameterized”. When we don’t provide the type, the type becomes Object and hence it’s allowing both String and Integer objects. But, we should always try to avoid this because we will have to use type casting while working on raw type that can produce runtime errors.
Tip: We can use @SuppressWarnings("rawtypes") annotation to suppress the compiler warning, check out java annotations tutorial.
Also notice that it supports java autoboxing.
3. Java Generic Interface
Comparable interface is a great example of Generics in interfaces and it’s written as:

package java.lang;
import java.util.*;

public interface Comparable<T> {
    public int compareTo(T o);
}
In similar way, we can create generic interfaces in java. We can also have multiple type parameters as in Map interface. Again we can provide parameterized value to a parameterized type also, for example new HashMap<String, List<String>>(); is valid.
4. Java Generic Type
Java Generic Type Naming convention helps us understanding code easily and having a naming convention is one of the best practices of Java programming language. So generics also comes with its own naming conventions. Usually, type parameter names are single, uppercase letters to make it easily distinguishable from java variables. The most commonly used type parameter names are:
•	E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
•	K – Key (Used in Map)
•	N – Number
•	T – Type
•	V – Value (Used in Map)
•	S,U,V etc. – 2nd, 3rd, 4th types
5. Java Generic Method
Sometimes we don’t want the whole class to be parameterized, in that case, we can create java generics method. Since the constructor is a special kind of method, we can use generics type in constructors too.
Here is a class showing an example of a java generic method.

package com.journaldev.generics;

public class GenericsMethods {

	//Java Generic Method
	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){
		return g1.get().equals(g2.get());
	}
	
	public static void main(String args[]){
		GenericsType<String> g1 = new GenericsType<>();
		g1.set("Pankaj");
		
		GenericsType<String> g2 = new GenericsType<>();
		g2.set("Pankaj");
		
		boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);
		//above statement can be written simply as
		isEqual = GenericsMethods.isEqual(g1, g2);
		//This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets.
		//Compiler will infer the type that is needed
	}
}
Notice the isEqual method signature showing syntax to use generics type in methods. Also, notice how to use these methods in our java program. We can specify type while calling these methods or we can invoke them like a normal method. Java compiler is smart enough to determine the type of variable to be used, this facility is called type inference.
6. Java Generics Bounded Type Parameters
Suppose we want to restrict the type of objects that can be used in the parameterized type, for example in a method that compares two objects and we want to make sure that the accepted objects are Comparables. To declare a bounded type parameter, list the type parameter’s name, followed by the extends keyword, followed by its upper bound, similar like below method.

public static <T extends Comparable<T>> int compare(T t1, T t2){
		return t1.compareTo(t2);
	}
The invocation of these methods is similar to unbounded method except that if we will try to use any class that is not Comparable, it will throw compile-time error.
Bounded type parameters can be used with methods as well as classes and interfaces.
Java Generics supports multiple bounds also, i.e <T extends A & B & C>. In this case, A can be an interface or class. If A is class then B and C should be an interface. We can’t have more than one class in multiple bounds.
7. Java Generics and Inheritance
We know that Java inheritance allows us to assign a variable A to another variable B if A is subclass of B. So we might think that any generic type of A can be assigned to generic type of B, but it’s not the case. Let’s see this with a simple program.

package com.journaldev.generics;

public class GenericsInheritance {

	public static void main(String[] args) {
		String str = "abc";
		Object obj = new Object();
		obj=str; // works because String is-a Object, inheritance in java
		
		MyClass<String> myClass1 = new MyClass<String>();
		MyClass<Object> myClass2 = new MyClass<Object>();
		//myClass2=myClass1; // compilation error since MyClass<String> is not a MyClass<Object>
		obj = myClass1; // MyClass<T> parent is Object
	}
	
	public static class MyClass<T>{}

}
We are not allowed to assign MyClass<String> variable to MyClass<Object> variable because they are not related, in fact MyClass<T> parent is Object.
8. Java Generic Classes and Subtyping
We can subtype a generic class or interface by extending or implementing it. The relationship between the type parameters of one class or interface and the type parameters of another are determined by the extends and implements clauses.
For example, ArrayList<E> implements List<E> that extends Collection<E>, so ArrayList<String> is a subtype of List<String> and List<String> is subtype of Collection<String>.
The subtyping relationship is preserved as long as we don’t change the type argument, below shows an example of multiple type parameters.

interface MyList<E,T> extends List<E>{
}
The subtypes of List<String> can be MyList<String,Object>, MyList<String,Integer> and so on.
9. Java Generics Wildcards
Question mark (?) is the wildcard in generics and represent an unknown type. The wildcard can be used as the type of a parameter, field, or local variable and sometimes as a return type. We can’t use wildcards while invoking a generic method or instantiating a generic class. In the following sections, we will learn about upper bounded wildcards, lower bounded wildcards, and wildcard capture.
9.1) Java Generics Upper Bounded Wildcard
Upper bounded wildcards are used to relax the restriction on the type of variable in a method. Suppose we want to write a method that will return the sum of numbers in the list, so our implementation will be something like this.

public static double sum(List<Number> list){
		double sum = 0;
		for(Number n : list){
			sum += n.doubleValue();
		}
		return sum;
	}
Now the problem with above implementation is that it won’t work with List of Integers or Doubles because we know that List<Integer> and List<Double> are not related, this is when an upper bounded wildcard is helpful. We use generics wildcard with extends keyword and the upper bound class or interface that will allow us to pass argument of upper bound or it’s subclasses types.
The above implementation can be modified like the below program.

package com.journaldev.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		ints.add(3); ints.add(5); ints.add(10);
		double sum = sum(ints);
		System.out.println("Sum of ints="+sum);
	}

	public static double sum(List<? extends Number> list){
		double sum = 0;
		for(Number n : list){
			sum += n.doubleValue();
		}
		return sum;
	}
}
It’s similar like writing our code in terms of interface, in the above method we can use all the methods of upper bound class Number. Note that with upper bounded list, we are not allowed to add any object to the list except null. If we will try to add an element to the list inside the sum method, the program won’t compile.
9.2) Java Generics Unbounded Wildcard
Sometimes we have a situation where we want our generic method to be working with all types, in this case, an unbounded wildcard can be used. Its same as using <? extends Object>.

public static void printData(List<?> list){
		for(Object obj : list){
			System.out.print(obj + "::");
		}
	}
We can provide List<String> or List<Integer> or any other type of Object list argument to the printData method. Similar to upper bound list, we are not allowed to add anything to the list.
9.3) Java Generics Lower bounded Wildcard
Suppose we want to add Integers to a list of integers in a method, we can keep the argument type as List<Integer> but it will be tied up with Integers whereas List<Number> and List<Object> can also hold integers, so we can use a lower bound wildcard to achieve this. We use generics wildcard (?) with super keyword and lower bound class to achieve this.
We can pass lower bound or any supertype of lower bound as an argument, in this case, java compiler allows to add lower bound object types to the list.

public static void addIntegers(List<? super Integer> list){
		list.add(new Integer(50));
	}
10. Subtyping using Generics Wildcard

List<? extends Integer> intList = new ArrayList<>();
List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
11. Java Generics Type Erasure
Generics in Java was added to provide type-checking at compile time and it has no use at run time, so java compiler uses type erasure feature to remove all the generics type checking code in byte code and insert type-casting if necessary. Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime overhead.
For example, if we have a generic class like below;

public class Test<T extends Comparable<T>> {

    private T data;
    private Test<T> next;

    public Test(T d, Test<T> n) {
        this.data = d;
        this.next = n;
    }

    public T getData() { return this.data; }
}
The Java compiler replaces the bounded type parameter T with the first bound interface, Comparable, as below code:

public class Test {

    private Comparable data;
    private Test next;

    public Node(Comparable d, Test n) {
        this.data = d;
        this.next = n;
    }

    public Comparable getData() { return data; }
}
12. Generics FAQs
12.1) Why do we use Generics in Java?
Generics provide strong compile-time type checking and reduces risk of ClassCastException and explicit casting of objects.
12.2) What is T in Generics?
We use <T> to create a generic class, interface, and method. The T is replaced with the actual type when we use it.
12.3) How does Generics work in Java?
Generic code ensures type safety. The compiler uses type-erasure to remove all type parameters at the compile time to reduce the overload at runtime.
13. Generics in Java – Further Readings
•	Generics doesn’t support sub-typing, so List<Number> numbers = new ArrayList<Integer>(); will not compile, learn why generics doesn’t support sub-typing.
•	We can’t create generic array, so List<Integer>[] array = new ArrayList<Integer>[10] will not compile, read why we can’t create generic array?.

Java Stream
Before we look into Java Stream API Examples, let’s see why it was required. Suppose we want to iterate over a list of integers and find out sum of all the integers greater than 10.
Prior to Java 8, the approach to do it would be:

private static int sumIterator(List<Integer> list) {
	Iterator<Integer> it = list.iterator();
	int sum = 0;
	while (it.hasNext()) {
		int num = it.next();
		if (num > 10) {
			sum += num;
		}
	}
	return sum;
}
There are three major problems with the above approach:
1.	We just want to know the sum of integers but we would also have to provide how the iteration will take place, this is also called external iteration because client program is handling the algorithm to iterate over the list.
2.	The program is sequential in nature, there is no way we can do this in parallel easily.
3.	There is a lot of code to do even a simple task.
To overcome all the above shortcomings, Java 8 Stream API was introduced. We can use Java Stream API to implement internal iteration, that is better because java framework is in control of the iteration.
Internal iteration provides several features such as sequential and parallel execution, filtering based on the given criteria, mapping etc.
Most of the Java 8 Stream API method arguments are functional interfaces, so lambda expressions work very well with them. Let’s see how can we write above logic in a single line statement using Java Streams.

private static int sumStream(List<Integer> list) {
	return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
}
Notice that above program utilizes java framework iteration strategy, filtering and mapping methods and would increase efficiency.
First of all we will look into the core concepts of Java 8 Stream API and then we will go through some examples for understanding most commonly used methods.
Collections and Java Stream
A collection is an in-memory data structure to hold values and before we start using collection, all the values should have been populated. Whereas a java Stream is a data structure that is computed on-demand.
Java Stream doesn’t store data, it operates on the source data structure (collection and array) and produce pipelined data that we can use and perform specific operations. Such as we can create a stream from the list and filter it based on a condition.
Java Stream operations use functional interfaces, that makes it a very good fit for functional programming using lambda expression. As you can see in the above example that using lambda expressions make our code readable and short.
Java 8 Stream internal iteration principle helps in achieving lazy-seeking in some of the stream operations. For example filtering, mapping, or duplicate removal can be implemented lazily, allowing higher performance and scope for optimization.
Java Streams are consumable, so there is no way to create a reference to stream for future usage. Since the data is on-demand, it’s not possible to reuse the same stream multiple times.
Java 8 Stream support sequential as well as parallel processing, parallel processing can be very helpful in achieving high performance for large collections.
All the Java Stream API interfaces and classes are in the java.util.stream package. Since we can use primitive data types such as int, long in the collections using auto-boxing and these operations could take a lot of time, there are specific classes for primitive types – IntStream, LongStream and DoubleStream.
Functional Interfaces in Java 8 Stream
Some of the commonly used functional interfaces in the Java 8 Stream API methods are:
1.	Function and BiFunction: Function represents a function that takes one type of argument and returns another type of argument. Function<T, R> is the generic form where T is the type of the input to the function and R is the type of the result of the function.
For handling primitive types, there are specific Function interfaces – ToIntFunction, ToLongFunction, ToDoubleFunction, ToIntBiFunction, ToLongBiFunction, ToDoubleBiFunction, LongToIntFunction, LongToDoubleFunction, IntToLongFunction, IntToDoubleFunction etc.
Some of the Stream methods where Function or it’s primitive specialization is used are:
•	<R> Stream<R> map(Function<? super T, ? extends R> mapper)
•	IntStream mapToInt(ToIntFunction<? super T> mapper) – similarly for long and double returning primitive specific stream.
•	IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) – similarly for long and double
•	<A> A[] toArray(IntFunction<A[]> generator)
•	<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
2.	Predicate and BiPredicate: It represents a predicate against which elements of the stream are tested. This is used to filter elements from the java stream. Just like Function, there are primitive specific interfaces for int, long and double.
Some of the Stream methods where Predicate or BiPredicate specializations are used are:
•	Stream<T> filter(Predicate<? super T> predicate)
•	boolean anyMatch(Predicate<? super T> predicate)
•	boolean allMatch(Predicate<? super T> predicate)
•	boolean noneMatch(Predicate<? super T> predicate)
3.	Consumer and BiConsumer: It represents an operation that accepts a single input argument and returns no result. It can be used to perform some action on all the elements of the java stream.
Some of the Java 8 Stream methods where Consumer, BiConsumer or it’s primitive specialization interfaces are used are:
•	Stream<T> peek(Consumer<? super T> action)
•	void forEach(Consumer<? super T> action)
•	void forEachOrdered(Consumer<? super T> action)
4.	Supplier: Supplier represent an operation through which we can generate new values in the stream. Some of the methods in Stream that takes Supplier argument are:
•	public static<T> Stream<T> generate(Supplier<T> s)
•	<R> R collect(Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner)
java.util.Optional
Java Optional is a container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value. Stream terminal operations return Optional object. Some of these methods are:
•	Optional<T> reduce(BinaryOperator<T> accumulator)
•	Optional<T> min(Comparator<? super T> comparator)
•	Optional<T> max(Comparator<? super T> comparator)
•	Optional<T> findFirst()
•	Optional<T> findAny()
java.util.Spliterator
For supporting parallel execution in Java 8 Stream API, Spliterator interface is used. Spliterator trySplit method returns a new Spliterator that manages a subset of the elements of the original Spliterator.
Java Stream Intermediate and Terminal Operations
Java Stream API operations that returns a new Stream are called intermediate operations. Most of the times, these operations are lazy in nature, so they start producing new stream elements and send it to the next operation. Intermediate operations are never the final result producing operations. Commonly used intermediate operations are filter and map.
Java 8 Stream API operations that returns a result or produce a side effect. Once the terminal method is called on a stream, it consumes the stream and after that we can’t use stream. Terminal operations are eager in nature i.e they process all the elements in the stream before returning the result. Commonly used terminal methods are forEach, toArray, min, max, findFirst, anyMatch, allMatch etc. You can identify terminal methods from the return type, they will never return a Stream.
Java Stream Short Circuiting Operations
An intermediate operation is called short circuiting, if it may produce finite stream for an infinite stream. For example limit() and skip() are two short circuiting intermediate operations.
A terminal operation is called short circuiting, if it may terminate in finite time for infinite stream. For example anyMatch, allMatch, noneMatch, findFirst and findAny are short circuiting terminal operations.
Java Stream Examples
I have covered almost all the important parts of the Java 8 Stream API. It’s exciting to use this new API features and let’s see it in action with some java stream examples.
Creating Java Streams
There are several ways through which we can create a java stream from array and collections. Let’s look into these with simple examples.
1.	We can use Stream.of() to create a stream from similar type of data. For example, we can create Java Stream of integers from a group of int or Integer objects.
2.	
3.	Stream<Integer> stream = Stream.of(1,2,3,4);
4.	We can use Stream.of() with an array of Objects to return the stream. Note that it doesn’t support autoboxing, so we can’t pass primitive type array.
5.	
6.	Stream<Integer> stream = Stream.of(new Integer[]{1,2,3,4}); 
7.	//works fine
8.	
9.	Stream<Integer> stream1 = Stream.of(new int[]{1,2,3,4}); 
10.	//Compile time error, Type mismatch: cannot convert from Stream<int[]> to Stream<Integer>
11.	We can use Collection stream() to create sequential stream and parallelStream() to create parallel stream.
12.	
13.	List<Integer> myList = new ArrayList<>();
14.	for(int i=0; i<100; i++) myList.add(i);
15.			
16.	//sequential stream
17.	Stream<Integer> sequentialStream = myList.stream();
18.			
19.	//parallel stream
20.	Stream<Integer> parallelStream = myList.parallelStream();
21.	We can use Stream.generate() and Stream.iterate() methods to create Stream.
22.	
23.	Stream<String> stream1 = Stream.generate(() -> {return "abc";});
24.	Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
25.	Using Arrays.stream() and String.chars() methods.
26.	
27.	LongStream is = Arrays.stream(new long[]{1,2,3,4});
28.	IntStream is2 = "abc".chars();
Converting Java Stream to Collection or Array
There are several ways through which we can get a Collection or Array from a java Stream.
1.	We can use java Stream collect() method to get List, Map or Set from stream.
2.	
3.	Stream<Integer> intStream = Stream.of(1,2,3,4);
4.	List<Integer> intList = intStream.collect(Collectors.toList());
5.	System.out.println(intList); //prints [1, 2, 3, 4]
6.	
7.	intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
8.	Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
9.	System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}
10.	We can use stream toArray() method to create an array from the stream.
11.	
12.	Stream<Integer> intStream = Stream.of(1,2,3,4);
13.	Integer[] intArray = intStream.toArray(Integer[]::new);
14.	System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]
Java Stream Intermediate Operations
Let’s look into commonly used java Stream intermediate operations example.
1.	Stream filter() example: We can use filter() method to test stream elements for a condition and generate filtered list.
2.	
3.	List<Integer> myList = new ArrayList<>();
4.	for(int i=0; i<100; i++) myList.add(i);
5.	Stream<Integer> sequentialStream = myList.stream();
6.	
7.	Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); //filter numbers greater than 90
8.	System.out.print("High Nums greater than 90=");
9.	highNums.forEach(p -> System.out.print(p+" "));
10.	//prints "High Nums greater than 90=91 92 93 94 95 96 97 98 99 "
11.	Stream map() example: We can use map() to apply functions to an stream. Let’s see how we can use it to apply upper case function to a list of Strings.
12.	
13.	Stream<String> names = Stream.of("aBc", "d", "ef");
14.	System.out.println(names.map(s -> {
15.			return s.toUpperCase();
16.		}).collect(Collectors.toList()));
17.	//prints [ABC, D, EF]
18.	Stream sorted() example: We can use sorted() to sort the stream elements by passing Comparator argument.
19.	
20.	Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
21.	List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
22.	System.out.println(reverseSorted); // [ef, d, aBc, 123456]
23.	
24.	Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
25.	List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
26.	System.out.println(naturalSorted); //[123456, aBc, d, ef]
27.	Stream flatMap() example: We can use flatMap() to create a stream from the stream of list. Let’s see a simple example to clear this doubt.
28.	
29.	Stream<List<String>> namesOriginalList = Stream.of(
30.		Arrays.asList("Pankaj"), 
31.		Arrays.asList("David", "Lisa"),
32.		Arrays.asList("Amit"));
33.	//flat the stream from List<String> to String stream
34.	Stream<String> flatStream = namesOriginalList
35.		.flatMap(strList -> strList.stream());
36.	
37.	flatStream.forEach(System.out::println);
Java Stream Terminal Operations
Let’s look at some of the java stream terminal operations example.
1.	Stream reduce() example: We can use reduce() to perform a reduction on the elements of the stream, using an associative accumulation function, and return an Optional. Let’s see how we can use it multiply the integers in a stream.
2.	
3.	Stream<Integer> numbers = Stream.of(1,2,3,4,5);
4.			
5.	Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i*j;});
6.	if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get()); //120
7.	Stream count() example: We can use this terminal operation to count the number of items in the stream.
8.	
9.	Stream<Integer> numbers1 = Stream.of(1,2,3,4,5);
10.			
11.	System.out.println("Number of elements in stream="+numbers1.count()); //5
12.	Stream forEach() example: This can be used for iterating over the stream. We can use this in place of iterator. Let’s see how to use it for printing all the elements of the stream.
13.	
14.	Stream<Integer> numbers2 = Stream.of(1,2,3,4,5);
15.	numbers2.forEach(i -> System.out.print(i+",")); //1,2,3,4,5,
16.	Stream match() examples: Let’s see some of the examples for matching methods in Stream API.
17.	
18.	Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
19.	System.out.println("Stream contains 4? "+numbers3.anyMatch(i -> i==4));
20.	//Stream contains 4? true
21.	
22.	Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
23.	System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
24.	//Stream contains all elements less than 10? true
25.	
26.	Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
27.	System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));
28.	//Stream doesn't contain 10? true
29.	Stream findFirst() example: This is a short circuiting terminal operation, let’s see how we can use it to find the first string from a stream starting with D.
30.	
31.	Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa");
32.	Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
33.	if(firstNameWithD.isPresent()){
34.		System.out.println("First Name starting with D="+firstNameWithD.get()); //David
35.	}
Java 8 Stream API Limitations
Java 8 Stream API brings a lot of new stuffs to work with list and arrays, but it has some limitations too.
1.	Stateless lambda expressions: If you are using parallel stream and lambda expressions are stateful, it can result in random responses. Let’s see it with a simple program.
StatefulParallelStream.java

package com.journaldev.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StatefulParallelStream {

	public static void main(String[] args) {

		List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		List<Integer> result = new ArrayList<Integer>();
		 
		Stream<Integer> stream = ss.parallelStream();
		 
		stream.map(s -> {
		        synchronized (result) {
		          if (result.size() < 10) {
		            result.add(s);
		          }
		        }
				return s;
		    }).forEach( e -> {});
		 System.out.println(result);   
	}
}
If we run above program, you will get different results because it depends on the way stream is getting iterated and we don’t have any order defined for parallel processing. If we use sequential stream, then this problem will not arise.
2.	Once a Stream is consumed, it can’t be used later on. As you can see in above examples that every time I am creating a stream.
3.	There are a lot of methods in Stream API and the most confusing part is the overloaded methods. It makes the learning curve time taking.

Java composition is achieved by using instance variables that refers to other objects. For example, a Person has a Job. Let’s see this with a java composition example code.
Java Composition Example

package com.journaldev.composition;

public class Job {
    private String role;
    private long salary;
    private int id;
        
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
}

package com.journaldev.composition;

public class Person {

    //composition has-a relationship
    private Job job;
   
    public Person(){
        this.job=new Job();
        job.setSalary(1000L);
    }
    public long getSalary() {
        return job.getSalary();
    }

}
Here is a test class for java composition example that uses person object and get it’s salary.

package com.journaldev.composition;

public class TestPerson {

    public static void main(String[] args) {
        Person person = new Person();
        long salary = person.getSalary();
    }

}
Java Composition Benefits
Notice that above test program for composition in java is not affected by any change in the Job object. If you are looking for code reuse and the relationship between two classes is has-a then you should use composition rather than inheritance.
Benefit of using composition in java is that we can control the visibility of other object to client classes and reuse only what we need.
Also if there is any change in the other class implementation, for example getSalary returning String, we need to change Person class to accommodate it but client classes doesn’t need to change.
Composition allows creation of back-end class when it’s needed, for example we can change Person getSalary method to initialize the Job object at runtime when required.
Further Reading: Do you know one of the best practice in java programming is to use composition over inheritance, check out this post for detailed analysis of Composition vs Inheritance.
Java Composition Youtube Video
Recently I created a YouTube video to explain composition in java in detail, please watch it below.
That’s all for composition in java or java composition example. I hope you will find it useful in making informed decision when designing your application classes.

Spring Interview Questions and Answers
1.	What is Spring Framework?
Spring is one of the most widely used Java EE framework. Spring framework core concepts are “Dependency Injection” and “Aspect Oriented Programming”.
Spring framework can be used in normal java applications also to achieve loose coupling between different components by implementing dependency injection and we can perform cross-cutting tasks such as logging and authentication using spring support for aspect-oriented programming.
I like spring because it provides a lot of features and different modules for specific tasks such as Spring MVC and Spring JDBC. Since it’s an open source framework with a lot of online resources and active community members, working with the Spring framework is easy and fun at the same time.
Recommended Read: Spring Framework
2.	What are some of the important features and advantages of Spring Framework?
Spring Framework is built on top of two design concepts – Dependency Injection and Aspect Oriented Programming.
Some of the features of spring framework are:
•	Lightweight and very little overhead of using framework for our development.
•	Dependency Injection or Inversion of Control to write components that are independent of each other, spring container takes care of wiring them together to achieve our work.
•	Spring IoC container manages Spring Bean life cycle and project specific configurations such as JNDI lookup.
•	Spring MVC framework can be used to create web applications as well as restful web services capable of returning XML as well as JSON response.
•	Support for transaction management, JDBC operations, File uploading, Exception Handling etc with very little configurations, either by using annotations or by spring bean configuration file.
Some of the advantages of using Spring Framework are:
•	Reducing direct dependencies between different components of the application, usually Spring IoC container is responsible for initializing resources or beans and inject them as dependencies.
•	Writing unit test cases are easy in Spring framework because our business logic doesn’t have direct dependencies with actual resource implementation classes. We can easily write a test configuration and inject our mock beans for testing purposes.
•	Reduces the amount of boiler-plate code, such as initializing objects, open/close resources. I like JdbcTemplate class a lot because it helps us in removing all the boiler-plate code that comes with JDBC programming.
•	Spring framework is divided into several modules, it helps us in keeping our application lightweight. For example, if we don’t need Spring transaction management features, we don’t need to add that dependency on our project.
•	Spring framework support most of the Java EE features and even much more. It’s always on top of the new technologies, for example, there is a Spring project for Android to help us write better code for native Android applications. This makes spring framework a complete package and we don’t need to look after the different framework for different requirements.
3.	What do you understand by Dependency Injection?
Dependency Injection design pattern allows us to remove the hard-coded dependencies and make our application loosely coupled, extendable and maintainable. We can implement dependency injection pattern to move the dependency resolution from compile-time to runtime.
Some of the benefits of using Dependency Injection are Separation of Concerns, Boilerplate Code reduction, Configurable components, and easy unit testing.
Read more at Dependency Injection Tutorial. We can also use Google Guice for Dependency Injection to automate the process of dependency injection. But in most of the cases, we are looking for more than just dependency injection and that’s why Spring is the top choice for this.
4.	How do we implement DI in Spring Framework?
We can use Spring XML based as well as Annotation-based configuration to implement DI in spring applications. For better understanding, please read Spring Dependency Injection example where you can learn both the ways with JUnit test case. The post also contains a sample project zip file, that you can download and play around to learn more.
5.	What are the new features in Spring 5?
Spring 5 brought a massive update to Spring framework. Some of the new features in Spring 5 are:
0.	Spring 5 runs on Java 8+ and supports Java EE 7. So we can use lambda expressions and Servlet 4.0 features. It’s good to see Spring trying to support the latest versions.
1.	Spring Framework 5.0 comes with its own Commons Logging bridge; spring-jcl instead of standard Commons Logging.
2.	Support for providing spring components information through index file “META-INF/spring.components” rather than classpath scanning.
3.	Spring WebFlux brings reactive programming to the Spring Framework.
4.	Spring 5 also supports Kotlin programming now. This is a huge step towards supporting functional programming, just as Java is also moving towards functional programming.
5.	Support for JUnit 5 and parallel testing execution in the Spring TestContext Framework.
You can read about these features in more detail at Spring 5 Features.
6.	What is Spring WebFlux?
Spring WebFlux is the new module introduced in Spring 5. Spring WebFlux is the first step towards the reactive programming model in spring framework.
Spring WebFlux is the alternative to the Spring MVC module. Spring WebFlux is used to create a fully asynchronous and non-blocking application built on the event-loop execution model.
You can read more about it at Spring WebFlux Tutorial.
7.	What are the benefits of using Spring Tool Suite?
We can install plugins into Eclipse to get all the features of Spring Tool Suite. However, STS comes with Eclipse with some other important kinds of stuff such as Maven support, Templates for creating different types of Spring projects and tc server for better performance with Spring applications.
I like STS because it highlights the Spring components and if you are using AOP pointcuts and advice, then it clearly shows which methods will come under the specific pointcut. So rather than installing everything on our own, I prefer using STS when developing Spring-based applications.
8.	Name some of the important Spring Modules?
Some of the important Spring Framework modules are:
•	Spring Context – for dependency injection.
•	Spring AOP – for aspect oriented programming.
•	Spring DAO – for database operations using DAO pattern
•	Spring JDBC – for JDBC and DataSource support.
•	Spring ORM – for ORM tools support such as Hibernate
•	Spring Web Module – for creating web applications.
•	Spring MVC – Model-View-Controller implementation for creating web applications, web services etc.
9.	What do you understand by Aspect Oriented Programming?
Enterprise applications have some common cross-cutting concerns that are applicable to different types of Objects and application modules, such as logging, transaction management, data validation, authentication etc. In Object Oriented Programming, modularity of application is achieved by Classes whereas in AOP application modularity is achieved by Aspects and they are configured to cut across different classes methods.
AOP takes out the direct dependency of cross-cutting tasks from classes that are not possible in normal object-oriented programming. For example, we can have a separate class for logging but again the classes will have to call these methods for logging the data. Read more about Spring AOP support at Spring AOP Example.
10.	What is Aspect, Advice, Pointcut, JointPoint and Advice Arguments in AOP?
Aspect: Aspect is a class that implements cross-cutting concerns, such as transaction management. Aspects can be a normal class configured and then configured in Spring Bean configuration file or we can use Spring AspectJ support to declare a class as Aspect using @Aspect annotation.
Advice: Advice is the action taken for a particular join point. In terms of programming, they are methods that gets executed when a specific join point with matching pointcut is reached in the application. You can think of Advices as Spring interceptors or Servlet Filters.
Pointcut: Pointcut are regular expressions that are matched with join points to determine whether advice needs to be executed or not. Pointcut uses different kinds of expressions that are matched with the join points. Spring framework uses the AspectJ pointcut expression language for determining the join points where advice methods will be applied.
Join Point: A join point is a specific point in the application such as method execution, exception handling, changing object variable values etc. In Spring AOP a join point is always the execution of a method.
Advice Arguments: We can pass arguments in the advice methods. We can use args() expression in the pointcut to be applied to any method that matches the argument pattern. If we use this, then we need to use the same name in the advice method from where the argument type is determined.
These concepts seems confusing at first, but if you go through Spring Aspect, Advice Example then you can easily relate to them.
11.	What is the difference between Spring AOP and AspectJ AOP?
AspectJ is the industry-standard implementation for Aspect Oriented Programming whereas Spring implements AOP for some cases. Main differences between Spring AOP and AspectJ are:
•	Spring AOP is simpler to use than AspectJ because we don’t need to worry about the weaving process.
•	Spring AOP supports AspectJ annotations, so if you are familiar with AspectJ then working with Spring AOP is easier.
•	Spring AOP supports only proxy-based AOP, so it can be applied only to method execution join points. AspectJ support all kinds of pointcuts.
•	One of the shortcomings of Spring AOP is that it can be applied only to the beans created through Spring Context.
12.	What is Spring IoC Container?
Inversion of Control (IoC) is the mechanism to achieve loose-coupling between Objects dependencies. To achieve loose coupling and dynamic binding of the objects at runtime, the objects define their dependencies that are being injected by other assembler objects. Spring IoC container is the program that injects dependencies into an object and makes it ready for our use.
Spring Framework IoC container classes are part of org.springframework.beans and org.springframework.context packages and provides us different ways to decouple the object dependencies.
Some of the useful ApplicationContext implementations that we use are;
•	AnnotationConfigApplicationContext: For standalone java applications using annotations based configuration.
•	ClassPathXmlApplicationContext: For standalone java applications using XML based configuration.
•	FileSystemXmlApplicationContext: Similar to ClassPathXmlApplicationContext except that the xml configuration file can be loaded from anywhere in the file system.
•	AnnotationConfigWebApplicationContext and XmlWebApplicationContext for web applications.
13.	What is a Spring Bean?
Any normal java class that is initialized by Spring IoC container is called Spring Bean. We use Spring ApplicationContext to get the Spring Bean instance.
Spring IoC container manages the life cycle of Spring Bean, bean scopes and injecting any required dependencies in the bean.
14.	What is the importance of Spring bean configuration file?
We use Spring Bean configuration file to define all the beans that will be initialized by Spring Context. When we create the instance of Spring ApplicationContext, it reads the spring bean XML file and initializes all of them. Once the context is initialized, we can use it to get different bean instances.
Apart from Spring Bean configuration, this file also contains spring MVC interceptors, view resolvers and other elements to support annotations based configurations.
15.	What are different ways to configure a class as Spring Bean?
There are three different ways to configure Spring Bean.
0.	XML Configuration: This is the most popular configuration and we can use bean element in context file to configure a Spring Bean. For example:
1.	
2.	<bean name="myBean" class="com.journaldev.spring.beans.MyBean"></bean>
3.	Java Based Configuration: If you are using only annotations, you can configure a Spring bean using @Bean annotation. This annotation is used with @Configuration classes to configure a spring bean. Sample configuration is:
4.	
5.	@Configuration
6.	@ComponentScan(value="com.journaldev.spring.main")
7.	public class MyConfiguration {
8.	
9.		@Bean
10.		public MyService getService(){
11.			return new MyService();
12.		}
13.	}
To get this bean from spring context, we need to use following code snippet:

AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
		MyConfiguration.class);
MyService service = ctx.getBean(MyService.class);
14.	Annotation Based Configuration: We can also use @Component, @Service, @Repository and @Controller annotations with classes to configure them to be as spring bean. For these, we would need to provide base package location to scan for these classes. For example:
15.	
16.	<context:component-scan base-package="com.journaldev.spring" />
16.	What are different scopes of Spring Bean?
There are five scopes defined for Spring Beans.
0.	singleton: Only one instance of the bean will be created for each container. This is the default scope for the spring beans. While using this scope, make sure spring bean doesn’t have shared instance variables otherwise it might lead to data inconsistency issues because it’s not thread-safe.
1.	prototype: A new instance will be created every time the bean is requested.
2.	request: This is same as prototype scope, however it’s meant to be used for web applications. A new instance of the bean will be created for each HTTP request.
3.	session: A new bean will be created for each HTTP session by the container.
4.	global-session: This is used to create global session beans for Portlet applications.
Spring Framework is extendable and we can create our own scopes too, however most of the times we are good with the scopes provided by the framework.
To set spring bean scopes we can use “scope” attribute in bean element or @Scope annotation for annotation based configurations.
17.	What is Spring Bean life cycle?
Spring Beans are initialized by Spring Container and all the dependencies are also injected. When the context is destroyed, it also destroys all the initialized beans. This works well in most of the cases but sometimes we want to initialize other resources or do some validation before making our beans ready to use. Spring framework provides support for post-initialization and pre-destroy methods in spring beans.
We can do this by two ways – by implementing InitializingBean and DisposableBean interfaces or using init-method and destroy-method attribute in spring bean configurations. For more details, please read Spring Bean Life Cycle Methods.
18.	How to get ServletContext and ServletConfig object in a Spring Bean?
There are two ways to get Container specific objects in the spring bean.
0.	Implementing Spring *Aware interfaces, for these ServletContextAware and ServletConfigAware interfaces, for complete example of these aware interfaces, please read Spring Aware Interfaces
1.	Using @Autowired annotation with bean variable of type ServletContext and ServletConfig. They will work only in servlet container specific environment only though.
2.	
3.	@Autowired
4.	ServletContext servletContext;
19.	What is Bean wiring and @Autowired annotation?
The process of injection spring bean dependencies while initializing it called Spring Bean Wiring.
Usually, it’s best practice to do the explicit wiring of all the bean dependencies, but the spring framework also supports auto-wiring. We can use @Autowired annotation with fields or methods for autowiring byType. For this annotation to work, we also need to enable annotation-based configuration in spring bean configuration file. This can be done by context:annotation-config element.
For more details about @Autowired annotation, please read Spring Autowire Example.
20.	What are different types of Spring Bean autowiring?
There are four types of autowiring in Spring framework.
0.	autowire byName
1.	autowire byType
2.	autowire by constructor
3.	autowiring by @Autowired and @Qualifier annotations
Prior to Spring 3.1, autowire by autodetect was also supported that was similar to autowire by constructor or byType. For more details about these options, please read Spring Bean Autowiring.
21.	Does Spring Bean provide thread safety?
The default scope of Spring bean is singleton, so there will be only one instance per context. That means that all the having a class level variable that any thread can update will lead to inconsistent data. Hence in default mode spring beans are not thread-safe.
However, we can change spring bean scope to request, prototype or session to achieve thread-safety at the cost of performance. It’s a design decision and based on the project requirements.
22.	What is a Controller in Spring MVC?
Just like MVC design pattern, Controller is the class that takes care of all the client requests and send them to the configured resources to handle it. In Spring MVC, org.springframework.web.servlet.DispatcherServlet is the front controller class that initializes the context based on the spring beans configurations.
A Controller class is responsible to handle a different kind of client requests based on the request mappings. We can create a controller class by using @Controller annotation. Usually, it’s used with @RequestMapping annotation to define handler methods for specific URI mapping.
23.	What’s the difference between @Component, @Controller, @Repository & @Service annotations in Spring?
@Component is used to indicate that a class is a component. These classes are used for auto-detection and configured as bean when annotation based configurations are used.
@Controller is a specific type of component, used in MVC applications and mostly used with RequestMapping annotation.
@Repository annotation is used to indicate that a component is used as repository and a mechanism to store/retrieve/search data. We can apply this annotation with DAO pattern implementation classes.
@Service is used to indicate that a class is a Service. Usually, the business facade classes that provide some services are annotated with this.
We can use any of the above annotations for a class for auto-detection but different types are provided so that you can easily distinguish the purpose of the annotated classes.
24.	What is DispatcherServlet and ContextLoaderListener?
DispatcherServlet is the front controller in the Spring MVC application and it loads the spring bean configuration file and initialize all the beans that are configured. If annotations are enabled, it also scans the packages and configure any bean annotated with @Component, @Controller, @Repository or @Service annotations.
ContextLoaderListener is the listener to start up and shut down Spring’s root WebApplicationContext. It’s important functions are to tie up the lifecycle of ApplicationContext to the lifecycle of the ServletContext and to automate the creation of ApplicationContext. We can use it to define shared beans that can be used across different spring contexts.
25.	What is ViewResolver in Spring?
ViewResolver implementations are used to resolve the view pages by name. Usually we configure it in the spring bean configuration file. For example:

<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<beans:property name="prefix" value="/WEB-INF/views/" />
	<beans:property name="suffix" value=".jsp" />
</beans:bean>
InternalResourceViewResolver is one of the implementation of ViewResolver interface and we are providing the view pages directory and suffix location through the bean properties. So if a controller handler method returns “home”, view resolver will use view page located at /WEB-INF/views/home.jsp.
26.	What is a MultipartResolver and when it’s used?
MultipartResolver interface is used for uploading files – CommonsMultipartResolver and StandardServletMultipartResolver are two implementations provided by spring framework for file uploading. By default there are no multipart resolvers configured but to use them for uploading files, all we need to define a bean named “multipartResolver” with type as MultipartResolver in spring bean configurations.
Once configured, any multipart request will be resolved by the configured MultipartResolver and pass on a wrapped HttpServletRequest. Then it’s used in the controller class to get the file and process it. For a complete example, please read Spring MVC File Upload Example.
27.	How to handle exceptions in Spring MVC Framework?
Spring MVC Framework provides the following ways to help us achieving robust exception handling.
0.	Controller Based – We can define exception handler methods in our controller classes. All we need is to annotate these methods with @ExceptionHandler annotation.
1.	Global Exception Handler – Exception Handling is a cross-cutting concern and Spring provides @ControllerAdvice annotation that we can use with any class to define our global exception handler.
2.	HandlerExceptionResolver implementation – For generic exceptions, most of the times we serve static pages. Spring Framework provides HandlerExceptionResolver interface that we can implement to create global exception handler. The reason behind this additional way to define global exception handler is that Spring framework also provides default implementation classes that we can define in our spring bean configuration file to get spring framework exception handling benefits.
For a complete example, please read Spring Exception Handling Example.
28.	How to create ApplicationContext in a Java Program?
There are following ways to create spring context in a standalone java program.
0.	AnnotationConfigApplicationContext: If we are using Spring in standalone java applications and using annotations for Configuration, then we can use this to initialize the container and get the bean objects.
1.	ClassPathXmlApplicationContext: If we have spring bean configuration xml file in standalone application, then we can use this class to load the file and get the container object.
2.	FileSystemXmlApplicationContext: This is similar to ClassPathXmlApplicationContext except that the xml configuration file can be loaded from anywhere in the file system.
29.	Can we have multiple Spring configuration files?
For Spring MVC applications, we can define multiple spring context configuration files through contextConfigLocation. This location string can consist of multiple locations separated by any number of commas and spaces. For example;

<servlet>
	<servlet-name>appServlet</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
            <param-name>contextConfigLocation</param-name>
	    <param-value>/WEB-INF/spring/appServlet/servlet-context.xml,/WEB-INF/spring/appServlet/servlet-jdbc.xml</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup>
</servlet>
We can also define multiple root level spring configurations and load it through context-param. For example;

<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/spring/root-context.xml /WEB-INF/spring/root-security.xml</param-value>
</context-param>
Another option is to use import element in the context configuration file to import other configurations, for example:

<beans:import resource="spring-jdbc.xml"/>
30.	What is ContextLoaderListener?
ContextLoaderListener is the listener class used to load root context and define spring bean configurations that will be visible to all other contexts. It’s configured in web.xml file as:

<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/spring/root-context.xml</param-value>
</context-param>
	
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
31.	What are the minimum configurations needed to create Spring MVC application?
For creating a simple Spring MVC application, we would need to do the following tasks.
•	Add spring-context and spring-webmvc dependencies in the project.
•	Configure DispatcherServlet in the web.xml file to handle requests through spring container.
•	Spring bean configuration file to define beans, if using annotations then it has to be configured here. Also we need to configure view resolver for view pages.
•	Controller class with request mappings defined to handle the client requests.
Above steps should be enough to create a simple Spring MVC Hello World application.

32.	How would you relate Spring MVC Framework to MVC architecture?
As the name suggests Spring MVC is built on top of Model-View-Controller architecture. DispatcherServlet is the Front Controller in the Spring MVC application that takes care of all the incoming requests and delegate it to different controller handler methods.
The model can be any Java Bean in the Spring Framework, just like any other MVC framework Spring provides automatic binding of form data to java beans. We can set model beans as attributes to be used in the view pages.
View Pages can be JSP, static HTMLs etc. and view resolvers are responsible for finding the correct view page. Once the view page is identified, control is given back to the DispatcherServlet controller. DispatcherServlet is responsible for rendering the view and returning the final response to the client.
33.	How to achieve localization in Spring MVC applications?
Spring provides excellent support for localization or i18n through resource bundles. Basis steps needed to make our application localized are:
0.	Creating message resource bundles for different locales, such as messages_en.properties, messages_fr.properties etc.
1.	Defining messageSource bean in the spring bean configuration file of type ResourceBundleMessageSource or ReloadableResourceBundleMessageSource.
2.	For change of locale support, define localeResolver bean of type CookieLocaleResolver and configure LocaleChangeInterceptor interceptor. Example configuration can be like below:
3.	
4.	<beans:bean id="messageSource"
5.	class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
6.	<beans:property name="basename" value="classpath:messages" />
7.	<beans:property name="defaultEncoding" value="UTF-8" />
8.	</beans:bean>
9.	 
10.	<beans:bean id="localeResolver"
11.	    class="org.springframework.web.servlet.i18n.CookieLocaleResolver">
12.	    <beans:property name="defaultLocale" value="en" />
13.	    <beans:property name="cookieName" value="myAppLocaleCookie"></beans:property>
14.	    <beans:property name="cookieMaxAge" value="3600"></beans:property>
15.	</beans:bean>
16.	 
17.	<interceptors>
18.	    <beans:bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
19.	        <beans:property name="paramName" value="locale" />
20.	    </beans:bean>
21.	</interceptors>
22.	Use spring:message element in the view pages with key names, DispatcherServlet picks the corresponding value and renders the page in corresponding locale and return as response.
For a complete example, please read Spring Localization Example.
34.	How can we use Spring to create Restful Web Service returning JSON response?
We can use Spring Framework to create Restful web services that returns JSON data. Spring provides integration with Jackson JSON API that we can use to send JSON response in restful web service.
We would need to do following steps to configure our Spring MVC application to send JSON response:
0.	Adding Jackson JSON dependencies, if you are using Maven it can be done with following code:
1.	
2.	<!-- Jackson -->
3.	<dependency>
4.	    <groupId>com.fasterxml.jackson.core</groupId>
5.	    <artifactId>jackson-databind</artifactId>
6.	    <version>${jackson.databind-version}</version>
7.	</dependency>
8.	Configure RequestMappingHandlerAdapter bean in the spring bean configuration file and set the messageConverters property to MappingJackson2HttpMessageConverter bean. Sample configuration will be:
9.	
10.	<!-- Configure to plugin JSON as request and response in method handler -->
11.	<beans:bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
12.	    <beans:property name="messageConverters">
13.	        <beans:list>
14.	            <beans:ref bean="jsonMessageConverter"/>
15.	        </beans:list>
16.	    </beans:property>
17.	</beans:bean>
18.	     
19.	<!-- Configure bean to convert JSON to POJO and vice versa -->
20.	<beans:bean id="jsonMessageConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
21.	</beans:bean>
22.	In the controller handler methods, return the Object as response using @ResponseBody annotation. Sample code:
23.	
24.	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
25.	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
26.	    logger.info("Start getEmployee. ID="+empId);
27.	     
28.	    return empData.get(empId);
29.	}
30.	You can invoke the rest service through any API, but if you want to use Spring then we can easily do it using RestTemplate class.
For a complete example, please read Spring Restful Webservice Example.
35.	What are some of the important Spring annotations you have used?
Some of the Spring annotations that I have used in my project are:
•	@Controller – for controller classes in Spring MVC project.
•	@RequestMapping – for configuring URI mapping in controller handler methods. This is a very important annotation, so you should go through Spring MVC RequestMapping Annotation Examples
•	@ResponseBody – for sending Object as response, usually for sending XML or JSON data as response.
•	@PathVariable – for mapping dynamic values from the URI to handler method arguments.
•	@Autowired – for autowiring dependencies in spring beans.
•	@Qualifier – with @Autowired annotation to avoid confusion when multiple instances of bean type is present.
•	@Service – for service classes.
•	@Scope – for configuring scope of the spring bean.
•	@Configuration, @ComponentScan and @Bean – for java based configurations.
•	AspectJ annotations for configuring aspects and advices, @Aspect, @Before, @After, @Around, @Pointcut etc.
36.	Can we send an Object as the response of Controller handler method?
Yes we can, using @ResponseBody annotation. This is how we send JSON or XML based response in restful web services.
37.	How to upload file in Spring MVC Application?
Spring provides built-in support for uploading files through MultipartResolver interface implementations. It’s very easy to use and requires only configuration changes to get it working. Obviously we would need to write controller handler method to handle the incoming file and process it. For a complete example, please refer Spring File Upload Example.
38.	How to validate form data in Spring Web MVC Framework?
Spring supports JSR-303 annotation based validations as well as provide Validator interface that we can implement to create our own custom validator. For using JSR-303 based validation, we need to annotate bean variables with the required validations.
For custom validator implementation, we need to configure it in the controller class. For a complete example, please read Spring MVC Form Validation Example.
39.	What is Spring MVC Interceptor and how to use it?
Spring MVC Interceptors are like Servlet Filters and allow us to intercept client request and process it. We can intercept client request at three places – preHandle, postHandle and afterCompletion.
We can create spring interceptor by implementing HandlerInterceptor interface or by extending abstract class HandlerInterceptorAdapter.
We need to configure interceptors in the spring bean configuration file. We can define an interceptor to intercept all the client requests or we can configure it for specific URI mapping too. For a detailed example, please refer Spring MVC Interceptor Example.
40.	What is Spring JdbcTemplate class and how to use it?
Spring Framework provides excellent integration with JDBC API and provides JdbcTemplate utility class that we can use to avoid bolier-plate code from our database operations logic such as Opening/Closing Connection, ResultSet, PreparedStatement etc.
For JdbcTemplate example, please refer Spring JDBC Example.
41.	How to use Tomcat JNDI DataSource in Spring Web Application?
For using servlet container configured JNDI DataSource, we need to configure it in the spring bean configuration file and then inject it to spring beans as dependencies. Then we can use it with JdbcTemplate to perform database operations.
Sample configuration would be:

<beans:bean id="dbDataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    <beans:property name="jndiName" value="java:comp/env/jdbc/MyLocalDB"/>
</beans:bean>
For complete example, please refer Spring Tomcat JNDI Example.
42.	How would you achieve Transaction Management in Spring?
Spring framework provides transaction management support through Declarative Transaction Management as well as programmatic transaction management. Declarative transaction management is most widely used because it’s easy to use and works in most of the cases.
We use annotate a method with @Transactional annotation for Declarative transaction management. We need to configure the transaction manager for the DataSource in the spring bean configuration file.

<bean id="transactionManager"
    class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource" />
</bean>
43.	What is Spring DAO?
Spring DAO support is provided to work with data access technologies like JDBC, Hibernate in a consistent and easy way. For example we have JdbcDaoSupport, HibernateDaoSupport, JdoDaoSupport and JpaDaoSupport for respective technologies.
Spring DAO also provides consistency in exception hierarchy and we don’t need to catch specific exceptions.
44.	How to integrate Spring and Hibernate Frameworks?
We can use Spring ORM module to integrate Spring and Hibernate frameworks if you are using Hibernate 3+ where SessionFactory provides current session, then you should avoid using HibernateTemplate or HibernateDaoSupport classes and better to use DAO pattern with dependency injection for the integration.
Spring ORM provides support for using Spring declarative transaction management, so you should utilize that rather than going for Hibernate boiler-plate code for transaction management.
For better understanding you should go through following tutorials:
•	Spring Hibernate Integration Example
•	Spring MVC Hibernate Integration Example
45.	What is Spring Security?
Spring security framework focuses on providing both authentication and authorization in java applications. It also takes care of most of the common security vulnerabilities such as CSRF attack.
It’s very beneficial and easy to use Spring security in web applications, through the use of annotations such as @EnableWebSecurity. You should go through the following posts to learn how to use the Spring Security framework.
•	Spring Security in Servlet Web Application
•	Spring MVC and Spring Security Integration Example
46.	How to inject a java.util.Properties into a Spring Bean?
We need to define propertyConfigurer bean that will load the properties from the given property file. Then we can use Spring EL support to inject properties into other bean dependencies. For example;

<bean id="propertyConfigurer" 
  class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">
    <property name="location" value="/WEB-INF/application.properties" />
</bean> 

<bean class="com.journaldev.spring.EmployeeDaoImpl">
    <property name="maxReadResults" value="${results.read.max}"/>
</bean>
If you are using annotation to configure the spring bean, then you can inject property like below.

@Value("${maxReadResults}") 
private int maxReadResults;
47.	Name some of the design patterns used in Spring Framework?
Spring Framework is using a lot of design patterns, some of the common ones are:
0.	Singleton Pattern: Creating beans with default scope.
1.	Factory Pattern: Bean Factory classes
2.	Prototype Pattern: Bean scopes
3.	Adapter Pattern: Spring Web and Spring MVC
4.	Proxy Pattern: Spring Aspect Oriented Programming support
5.	Template Method Pattern: JdbcTemplate, HibernateTemplate etc
6.	Front Controller: Spring MVC DispatcherServlet
7.	Data Access Object: Spring DAO support
8.	Dependency Injection and Aspect Oriented Programming
48.	What are some of the best practices for Spring Framework?
Some of the best practices for Spring Framework are:
0.	Avoid version numbers in schema reference, to make sure we have the latest configs.
1.	Divide spring bean configurations based on their concerns such as spring-jdbc.xml, spring-security.xml.
2.	For spring beans that are used in multiple contexts in Spring MVC, create them in the root context and initialize with listener.
3.	Configure bean dependencies as much as possible, try to avoid autowiring as much as possible.
4.	For application-level properties, the best approach is to create a property file and read it in the spring bean configuration file.
5.	For smaller applications, annotations are useful but for larger applications, annotations can become a pain. If we have all the configuration in XML files, maintaining it will be easier.
6.	Use correct annotations for components for understanding the purpose easily. For services use @Service and for DAO beans use @Repository.
7.	Spring framework has a lot of modules, use what you need. Remove all the extra dependencies that get usually added when you create projects through Spring Tool Suite templates.
8.	If you are using Aspects, make sure to keep the join pint as narrow as possible to avoid advice on unwanted methods. Consider custom annotations that are easier to use and avoid any issues.
9.	Use dependency injection when there is an actual benefit, just for the sake of loose-coupling don’t use it because it’s harder to maintain.

Hibernate Interview Questions and Answers
1.	What is Hibernate Framework?
Object-relational mapping or ORM is the programming technique to map application domain model objects to the relational database tables. Hibernate is java based ORM tool that provides framework for mapping application domain objects to the relational database tables and vice versa.
Hibernate provides reference implementation of Java Persistence API, that makes it a great choice as ORM tool with benefits of loose coupling. We can use Hibernate persistence API for CRUD operations. Hibernate framework provide option to map plain old java objects to traditional database tables with the use of JPA annotations as well as XML based configuration.
Similarly hibernate configurations are flexible and can be done from XML configuration file as well as programmatically. For a quick overview of hibernate framework usage, you can go through Hibernate Beginners Tutorial.
2.	What is Java Persistence API (JPA)?
Java Persistence API (JPA) provides specification for managing the relational data in applications. Current JPA version 2.1 was started in July 2011 as JSR 338. JPA 2.1 was approved as final on 22 May 2013.
JPA specifications is defined with annotations in javax.persistence package. Using JPA annotation helps us in writing implementation independent code.
3.	What are the important benefits of using Hibernate Framework?
Some of the important benefits of using hibernate framework are:
1.	Hibernate eliminates all the boiler-plate code that comes with JDBC and takes care of managing resources, so we can focus on business logic.
2.	Hibernate framework provides support for XML as well as JPA annotations, that makes our code implementation independent.
3.	Hibernate provides a powerful query language (HQL) that is similar to SQL. However, HQL is fully object-oriented and understands concepts like inheritance, polymorphism and association.
4.	Hibernate is an open source project from Red Hat Community and used worldwide. This makes it a better choice than others because learning curve is small and there are tons of online documentations and help is easily available in forums.
5.	Hibernate is easy to integrate with other Java EE frameworks, it’s so popular that Spring Framework provides built-in support for integrating hibernate with Spring applications.
6.	Hibernate supports lazy initialization using proxy objects and perform actual database queries only when it’s required.
7.	Hibernate cache helps us in getting better performance.
8.	For database vendor specific feature, hibernate is suitable because we can also execute native sql queries.
Overall hibernate is the best choice in current market for ORM tool, it contains all the features that you will ever need in an ORM tool.
4.	What are the advantages of Hibernate over JDBC?
Some of the important advantages of Hibernate framework over JDBC are:
1.	Hibernate removes a lot of boiler-plate code that comes with JDBC API, the code looks more cleaner and readable.
2.	Hibernate supports inheritance, associations and collections. These features are not present with JDBC API.
3.	Hibernate implicitly provides transaction management, in fact most of the queries can’t be executed outside transaction. In JDBC API, we need to write code for transaction management using commit and rollback. Read more at JDBC Transaction Management.
4.	JDBC API throws SQLException that is a checked exception, so we need to write a lot of try-catch block code. Most of the times it’s redundant in every JDBC call and used for transaction management. Hibernate wraps JDBC exceptions and throw JDBCException or HibernateException un-checked exception, so we don’t need to write code to handle it. Hibernate built-in transaction management removes the usage of try-catch blocks.
5.	Hibernate Query Language (HQL) is more object oriented and close to java programming language. For JDBC, we need to write native sql queries.
6.	Hibernate supports caching that is better for performance, JDBC queries are not cached hence performance is low.
7.	Hibernate provide option through which we can create database tables too, for JDBC tables must exist in the database.
8.	Hibernate configuration helps us in using JDBC like connection as well as JNDI DataSource for connection pool. This is very important feature in enterprise application and completely missing in JDBC API.
9.	Hibernate supports JPA annotations, so code is independent of implementation and easily replaceable with other ORM tools. JDBC code is very tightly coupled with the application.
5.	Name some important interfaces of Hibernate framework?
Some of the important interfaces of Hibernate framework are:
1.	SessionFactory (org.hibernate.SessionFactory): SessionFactory is an immutable thread-safe cache of compiled mappings for a single database. We need to initialize SessionFactory once and then we can cache and reuse it. SessionFactory instance is used to get the Session objects for database operations.
2.	Session (org.hibernate.Session): Session is a single-threaded, short-lived object representing a conversation between the application and the persistent store. It wraps JDBC java.sql.Connection and works as a factory for org.hibernate.Transaction. We should open session only when it’s required and close it as soon as we are done using it. Session object is the interface between java application code and hibernate framework and provide methods for CRUD operations.
3.	Transaction (org.hibernate.Transaction): Transaction is a single-threaded, short-lived object used by the application to specify atomic units of work. It abstracts the application from the underlying JDBC or JTA transaction. A org.hibernate.Session might span multiple org.hibernate.Transaction in some cases.
6.	What is hibernate configuration file?
Hibernate configuration file contains database specific configurations and used to initialize SessionFactory. We provide database credentials or JNDI resource information in the hibernate configuration xml file. Some other important parts of hibernate configuration file is Dialect information, so that hibernate knows the database type and mapping file or class details.
7.	What is hibernate mapping file?
Hibernate mapping file is used to define the entity bean fields and database table column mappings. We know that JPA annotations can be used for mapping but sometimes XML mapping file comes handy when we are using third party classes and we can’t use annotations.
8.	Name some important annotations used for Hibernate mapping?
Hibernate supports JPA annotations and it has some other annotations in org.hibernate.annotations package. Some of the important JPA and hibernate annotations used are:
1.	javax.persistence.Entity: Used with model classes to specify that they are entity beans.
2.	javax.persistence.Table: Used with entity beans to define the corresponding table name in database.
3.	javax.persistence.Access: Used to define the access type, either field or property. Default value is field and if you want hibernate to use getter/setter methods then you need to set it to property.
4.	javax.persistence.Id: Used to define the primary key in the entity bean.
5.	javax.persistence.EmbeddedId: Used to define composite primary key in the entity bean.
6.	javax.persistence.Column: Used to define the column name in database table.
7.	javax.persistence.GeneratedValue: Used to define the strategy to be used for generation of primary key. Used in conjunction with javax.persistence.GenerationType enum.
8.	javax.persistence.OneToOne: Used to define the one-to-one mapping between two entity beans. We have other similar annotations as OneToMany, ManyToOne and ManyToMany
9.	org.hibernate.annotations.Cascade: Used to define the cascading between two entity beans, used with mappings. It works in conjunction with org.hibernate.annotations.CascadeType
10.	javax.persistence.PrimaryKeyJoinColumn: Used to define the property for foreign key. Used with org.hibernate.annotations.GenericGenerator and org.hibernate.annotations.Parameter
Here are two classes showing usage of these annotations.

package com.journaldev.hibernate.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "EMPLOYEE")
@Access(value=AccessType.FIELD)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long id;

	@Column(name = "emp_name")
	private String name;

	@OneToOne(mappedBy = "employee")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Address address;

	//getter setter methods
}

package com.journaldev.hibernate.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ADDRESS")
@Access(value=AccessType.FIELD)
public class Address {

	@Id
	@Column(name = "emp_id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = { @Parameter(name = "property", value = "employee") })
	private long id;

	@Column(name = "address_line1")
	private String addressLine1;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;

	//getter setter methods
}
9.	What is Hibernate SessionFactory and how to configure it?
SessionFactory is the factory class used to get the Session objects. SessionFactory is responsible to read the hibernate configuration parameters and connect to the database and provide Session objects. Usually an application has a single SessionFactory instance and threads servicing client requests obtain Session instances from this factory.
The internal state of a SessionFactory is immutable. Once it is created this internal state is set. This internal state includes all of the metadata about Object/Relational Mapping.
SessionFactory also provide methods to get the Class metadata and Statistics instance to get the stats of query executions, second level cache details etc.
10.	Hibernate SessionFactory is thread safe?
Internal state of SessionFactory is immutable, so it’s thread safe. Multiple threads can access it simultaneously to get Session instances.
11.	What is Hibernate Session and how to get it?
Hibernate Session is the interface between java application layer and hibernate. This is the core interface used to perform database operations. Lifecycle of a session is bound by the beginning and end of a transaction.
Session provide methods to perform create, read, update and delete operations for a persistent object. We can execute HQL queries, SQL native queries and create criteria using Session object.
12.	Hibernate Session is thread safe?
Hibernate Session object is not thread safe, every thread should get it’s own session instance and close it after it’s work is finished.
13.	What is difference between openSession and getCurrentSession?
Hibernate SessionFactory getCurrentSession() method returns the session bound to the context. But for this to work, we need to configure it in hibernate configuration file. Since this session object belongs to the hibernate context, we don’t need to close it. Once the session factory is closed, this session object gets closed.

<property name="hibernate.current_session_context_class">thread</property>
Hibernate SessionFactory openSession() method always opens a new session. We should close this session object once we are done with all the database operations. We should open a new session for each request in multi-threaded environment.
There is another method openStatelessSession() that returns stateless session, for more details with examples please read Hibernate openSession vs getCurrentSession.
14.	What is difference between Hibernate Session get() and load() method?
Hibernate session comes with different methods to load data from database. get and load are most used methods, at first look they seems similar but there are some differences between them.
1.	get() loads the data as soon as it’s called whereas load() returns a proxy object and loads data only when it’s actually required, so load() is better because it support lazy loading.
2.	Since load() throws exception when data is not found, we should use it only when we know data exists.
3.	We should use get() when we want to make sure data exists in the database.
For clarification regarding the differences, please read Hibernate get vs load.
15.	What is hibernate caching? Explain Hibernate first level cache?
As the name suggests, hibernate caches query data to make our application faster. Hibernate Cache can be very useful in gaining fast application performance if used correctly. The idea behind cache is to reduce the number of database queries, hence reducing the throughput time of the application.
Hibernate first level cache is associated with the Session object. Hibernate first level cache is enabled by default and there is no way to disable it. However hibernate provides methods through which we can delete selected objects from the cache or clear the cache completely.
Any object cached in a session will not be visible to other sessions and when the session is closed, all the cached objects will also be lost.
For better explanation, please read Hibernate First Level Cache.
16.	How to configure Hibernate Second Level Cache using EHCache?
EHCache is the best choice for utilizing hibernate second level cache. Following steps are required to enable EHCache in hibernate application.
•	Add hibernate-ehcache dependency in your maven project, if it’s not maven then add corresponding jars.
•	
•	<dependency>
•	        <groupId>org.hibernate</groupId>
•	        <artifactId>hibernate-ehcache</artifactId>
•	        <version>4.3.5.Final</version>
•	</dependency>
•	Add below properties in hibernate configuration file.
•	
•	<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
•	         
•	<!-- For singleton factory -->
•	<!-- <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory</property>
•	-->
•	          
•	<!-- enable second level cache and query cache -->
•	<property name="hibernate.cache.use_second_level_cache">true</property>
•	<property name="hibernate.cache.use_query_cache">true</property>
•	<property name="net.sf.ehcache.configurationResourceName">/myehcache.xml</property>
•	Create EHCache configuration file, a sample file myehcache.xml would look like below.
•	
•	<?xml version="1.0" encoding="UTF-8"?>
•	<ehcache xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
•	    xsi:noNamespaceSchemaLocation="ehcache.xsd" updateCheck="true"
•	    monitoring="autodetect" dynamicConfig="true">
•	 
•	    <diskStore path="java.io.tmpdir/ehcache" />
•	 
•	    <defaultCache maxEntriesLocalHeap="10000" eternal="false"
•	        timeToIdleSeconds="120" timeToLiveSeconds="120" diskSpoolBufferSizeMB="30"
•	        maxEntriesLocalDisk="10000000" diskExpiryThreadIntervalSeconds="120"
•	        memoryStoreEvictionPolicy="LRU" statistics="true">
•	        <persistence strategy="localTempSwap" />
•	    </defaultCache>
•	 
•	    <cache name="employee" maxEntriesLocalHeap="10000" eternal="false"
•	        timeToIdleSeconds="5" timeToLiveSeconds="10">
•	        <persistence strategy="localTempSwap" />
•	    </cache>
•	 
•	    <cache name="org.hibernate.cache.internal.StandardQueryCache"
•	        maxEntriesLocalHeap="5" eternal="false" timeToLiveSeconds="120">
•	        <persistence strategy="localTempSwap" />
•	    </cache>
•	 
•	    <cache name="org.hibernate.cache.spi.UpdateTimestampsCache"
•	        maxEntriesLocalHeap="5000" eternal="true">
•	        <persistence strategy="localTempSwap" />
•	    </cache>
•	</ehcache>
•	Annotate entity beans with @Cache annotation and caching strategy to use. For example,
•	
•	import org.hibernate.annotations.Cache;
•	import org.hibernate.annotations.CacheConcurrencyStrategy;
•	
•	@Entity
•	@Table(name = "ADDRESS")
•	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="employee")
•	public class Address {
•	
•	}
That’s it, we are done. Hibernate will use the EHCache for second level caching, read Hibernate EHCache Example for a complete example with explanation.
17.	What are different states of an entity bean?
An entity bean instance can exist is one of the three states.
0.	Transient: When an object is never persisted or associated with any session, it’s in transient state. Transient instances may be made persistent by calling save(), persist() or saveOrUpdate(). Persistent instances may be made transient by calling delete().
1.	Persistent: When an object is associated with a unique session, it’s in persistent state. Any instance returned by a get() or load() method is persistent.
2.	Detached: When an object is previously persistent but not associated with any session, it’s in detached state. Detached instances may be made persistent by calling update(), saveOrUpdate(), lock() or replicate(). The state of a transient or detached instance may also be made persistent as a new persistent instance by calling merge().
18.	What is use of Hibernate Session merge() call?
Hibernate merge can be used to update existing values, however this method create a copy from the passed entity object and return it. The returned object is part of persistent context and tracked for any changes, passed object is not tracked. For example program, read Hibernate merge.
19.	What is difference between Hibernate save(), saveOrUpdate() and persist() methods?
Hibernate save can be used to save entity to database. Problem with save() is that it can be invoked without a transaction and if we have mapping entities, then only the primary object gets saved causing data inconsistencies. Also save returns the generated id immediately.
Hibernate persist is similar to save with transaction. I feel it’s better than save because we can’t use it outside the boundary of transaction, so all the object mappings are preserved. Also persist doesn’t return the generated id immediately, so data persistence happens when needed.
Hibernate saveOrUpdate results into insert or update queries based on the provided data. If the data is present in the database, update query is executed. We can use saveOrUpdate() without transaction also, but again you will face the issues with mapped objects not getting saved if session is not flushed. For example usage of these methods, read Hibernate save vs persist.
20.	What will happen if we don’t have no-args constructor in Entity bean?
Hibernate uses Reflection API to create instance of Entity beans, usually when you call get() or load() methods. The method Class.newInstance() is used for this and it requires no-args constructor. So if you won’t have no-args constructor in entity beans, hibernate will fail to instantiate it and you will get HibernateException.
21.	What is difference between sorted collection and ordered collection, which one is better?
When we use Collection API sorting algorithms to sort a collection, it’s called sorted list. For small collections, it’s not much of an overhead but for larger collections it can lead to slow performance and OutOfMemory errors. Also the entity beans should implement Comparable or Comparator interface for it to work, read more at java object list sorting.
If we are using Hibernate framework to load collection data from database, we can use it’s Criteria API to use “order by” clause to get ordered list. Below code snippet shows you how to get it.

List<Employee> empList = session.createCriteria(Employee.class)
						.addOrder(Order.desc("id")).list();
Ordered list is better than sorted list because the actual sorting is done at database level, that is fast and doesn’t cause memory issues.
22.	What are the collection types in Hibernate?
There are five collection types in hibernate used for one-to-many relationship mappings.
0.	Bag
1.	Set
2.	List
3.	Array
4.	Map
23.	How to implement Joins in Hibernate?
There are various ways to implement joins in hibernate.
•	Using associations such as one-to-one, one-to-many etc.
•	Using JOIN in the HQL query. There is another form “join fetch” to load associated data simultaneously, no lazy loading.
•	We can fire native sql query and use join keyword.
24.	Why we should not make Entity Class final?
Hibernate use proxy classes for lazy loading of data, only when it’s needed. This is done by extending the entity bean, if the entity bean will be final then lazy loading will not be possible, hence low performance.
25.	What is HQL and what are it’s benefits?
Hibernate Framework comes with a powerful object-oriented query language – Hibernate Query Language (HQL). It’s very similar to SQL except that we use Objects instead of table names, that makes it more close to object oriented programming.
Hibernate query language is case-insensitive except for java class and variable names. So SeLeCT is the same as sELEct is the same as SELECT, but com.journaldev.model.Employee is not same as com.journaldev.model.EMPLOYEE.
The HQL queries are cached but we should avoid it as much as possible, otherwise we will have to take care of associations. However it’s a better choice than native sql query because of Object-Oriented approach. Read more at HQL Example.
26.	What is Query Cache in Hibernate?
Hibernate implements a cache region for queries resultset that integrates closely with the hibernate second-level cache.
This is an optional feature and requires additional steps in code. This is only useful for queries that are run frequently with the same parameters. First of all we need to configure below property in hibernate configuration file.

<property name="hibernate.cache.use_query_cache">true</property>
And in code, we need to use setCacheable(true) method of Query, quick example looks like below.

Query query = session.createQuery("from Employee");
query.setCacheable(true);
query.setCacheRegion("ALL_EMP");
27.	Can we execute native sql query in hibernate?
Hibernate provide option to execute native SQL queries through the use of SQLQuery object.
For normal scenarios, it is however not the recommended approach because we loose benefits related to hibernate association and hibernate first level caching. Read more at Hibernate Native SQL Query Example.
28.	What is the benefit of native sql query support in hibernate?
Native SQL Query comes handy when we want to execute database specific queries that are not supported by Hibernate API such as query hints or the CONNECT keyword in Oracle Database.
29.	What is Named SQL Query?
Hibernate provides Named Query that we can define at a central location and use them anywhere in the code. We can created named queries for both HQL and Native SQL.
Hibernate Named Queries can be defined in Hibernate mapping files or through the use of JPA annotations @NamedQuery and @NamedNativeQuery.
30.	What are the benefits of Named SQL Query?
Hibernate Named Query helps us in grouping queries at a central location rather than letting them scattered all over the code.
Hibernate Named Query syntax is checked when the hibernate session factory is created, thus making the application fail fast in case of any error in the named queries.
Hibernate Named Query is global, means once defined it can be used throughout the application.
However one of the major disadvantage of Named query is that it’s hard to debug, because we need to find out the location where it’s defined.
31.	What is the benefit of Hibernate Criteria API?
Hibernate provides Criteria API that is more object oriented for querying the database and getting results. We can’t use Criteria to run update or delete queries or any DDL statements. It’s only used to fetch the results from the database using more object oriented approach.
Some of the common usage of Criteria API are:
•	Criteria API provides Projection that we can use for aggregate functions such as sum(), min(), max() etc.
•	Criteria API can be used with ProjectionList to fetch selected columns only.
•	Criteria API can be used for join queries by joining multiple tables, useful methods are createAlias(), setFetchMode() and setProjection()
•	Criteria API can be used for fetching results with conditions, useful methods are add() where we can add Restrictions.
•	Criteria API provides addOrder() method that we can use for ordering the results.
Learn some quick examples at Hibernate Criteria Example.
32.	How to log hibernate generated sql queries in log files?
We can set below property for hibernate configuration to log SQL queries.

        <property name="hibernate.show_sql">true</property>
However we should use it only in Development or Testing environment and turn it off in production environment.
33.	What is Hibernate Proxy and how it helps in lazy loading?
Hibernate uses proxy object to support lazy loading. Basically when you load data from tables, hibernate doesn’t load all the mapped objects. As soon as you reference a child or lookup object via getter methods, if the linked entity is not in the session cache, then the proxy code will go to the database and load the linked object. It uses javassist to effectively and dynamically generate sub-classed implementations of your entity objects.
34.	How to implement relationships in hibernate?
We can easily implement one-to-one, one-to-many and many-to-many relationships in hibernate. It can be done using JPA annotations as well as XML based configurations. For better understanding, you should go through following tutorials.
0.	Hibernate One to One Mapping
1.	Hibernate One to Many Mapping
2.	Hibernate Many to Many Mapping
35.	How transaction management works in Hibernate?
Transaction management is very easy in hibernate because most of the operations are not permitted outside of a transaction. So after getting the session from SessionFactory, we can call session beginTransaction() to start the transaction. This method returns the Transaction reference that we can use later on to either commit or rollback the transaction.
Overall hibernate transaction management is better than JDBC transaction management because we don’t need to rely on exceptions for rollback. Any exception thrown by session methods automatically rollback the transaction.
36.	What is cascading and what are different types of cascading?
When we have relationship between entities, then we need to define how the different operations will affect the other entity. This is done by cascading and there are different types of it.
Here is a simple example of applying cascading between primary and secondary entities.

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

@OneToOne(mappedBy = "employee")
@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
private Address address;

}
Note that Hibernate CascadeType enum constants are little bit different from JPA javax.persistence.CascadeType, so we need to use the Hibernate CascadeType and Cascade annotations for mappings, as shown in above example.
Commonly used cascading types as defined in CascadeType enum are:
0.	None: No Cascading, it’s not a type but when we don’t define any cascading then no operations in parent affects the child.
1.	ALL: Cascades save, delete, update, evict, lock, replicate, merge, persist. Basically everything
2.	SAVE_UPDATE: Cascades save and update, available only in hibernate.
3.	DELETE: Corresponds to the Hibernate native DELETE action, only in hibernate.
4.	DETATCH, MERGE, PERSIST, REFRESH and REMOVE – for similar operations
5.	LOCK: Corresponds to the Hibernate native LOCK action.
6.	REPLICATE: Corresponds to the Hibernate native REPLICATE action.
37.	How to integrate log4j logging in hibernate application?
Hibernate 4 uses JBoss logging rather than slf4j used in earlier versions. For log4j configuration, we need to follow below steps.
•	Add log4j dependencies for maven project, if not maven then add corresponding jar files.
•	Create log4j.xml configuration file or log4j.properties file and keep it in the classpath. You can keep file name whatever you want because we will load it in next step.
•	For standalone projects, use static block to configure log4j using DOMConfigurator or PropertyConfigurator. For web applications, you can use ServletContextListener to configure it.
That’s it, our setup is ready. Create org.apache.log4j.Logger instance in the java classes and start logging. For complete example code, you should go through Hibernate log4j example and Servlet log4j example.
38.	How to use application server JNDI DataSource with Hibernate framework?
For web applications, it’s always best to allow servlet container to manage the connection pool. That’s why we define JNDI resource for DataSource and we can use it in the web application. It’s very easy to use in Hibernate, all we need is to remove all the database specific properties and use below property to provide the JNDI DataSource name.

<property name="hibernate.connection.datasource">java:comp/env/jdbc/MyLocalDB</property>
For a complete example, go through Hibernate JNDI DataSource Example.
39.	How to integrate Hibernate and Spring frameworks?
Spring is one of the most used Java EE Framework and Hibernate is the most popular ORM framework. That’s why Spring Hibernate combination is used a lot in enterprise applications. The best part with using Spring is that it provides out-of-box integration support for Hibernate with Spring ORM module. Following steps are required to integrate Spring and Hibernate frameworks together.
0.	Add hibernate-entitymanager, hibernate-core and spring-orm dependencies.
1.	Create Model classes and corresponding DAO implementations for database operations. Note that DAO classes will use SessionFactory that will be injected by Spring Bean configuration.
2.	If you are using Hibernate 3, you need to configure org.springframework.orm.hibernate3.LocalSessionFactoryBean or org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean in Spring Bean configuration file. For Hibernate 4, there is single class org.springframework.orm.hibernate4.LocalSessionFactoryBean that should be configured.
3.	Note that we don’t need to use Hibernate Transaction Management, we can leave it to Spring declarative transaction management using @Transactional annotation.
For complete example go through Spring Hibernate Integration and Spring MVC Hibernate Integration.
40.	What is HibernateTemplate class?
When Spring and Hibernate integration started, Spring ORM provided two helper classes – HibernateDaoSupport and HibernateTemplate. The reason to use them was to get the Session from Hibernate and get the benefit of Spring transaction management. However from Hibernate 3.0.1, we can use SessionFactory getCurrentSession() method to get the current session and use it to get the spring transaction management benefits. If you go through above examples, you will see how easy it is and that’s why we should not use these classes anymore.
One other benefit of HibernateTemplate was exception translation but that can be achieved easily by using @Repository annotation with service classes, shown in above spring mvc example. This is a trick question to judge your knowledge and whether you are aware of recent developments or not.
41.	How to integrate Hibernate with Servlet or Struts2 web applications?
Hibernate integration with Servlet or Struts2 needs to be done using ServletContextListener, a complete example can be found at Hibernate Struts2 Integration Example.
42.	Which design patterns are used in Hibernate framework?
Some of the design patterns used in Hibernate Framework are:
•	Domain Model Pattern – An object model of the domain that incorporates both behavior and data.
•	Data Mapper – A layer of Mappers that moves data between objects and a database while keeping them independent of each other and the mapper itself.
•	Proxy Pattern for lazy loading
•	Factory pattern in SessionFactory
43.	What are best practices to follow with Hibernate framework?
Some of the best practices to follow in Hibernate are:
•	Always check the primary key field access, if it’s generated at the database layer then you should not have a setter for this.
•	By default hibernate set the field values directly, without using setters. So if you want hibernate to use setters, then make sure proper access is defined as @Access(value=AccessType.PROPERTY).
•	If access type is property, make sure annotations are used with getter methods and not setter methods. Avoid mixing of using annotations on both filed and getter methods.
•	Use native sql query only when it can’t be done using HQL, such as using database specific feature.
•	If you have to sort the collection, use ordered list rather than sorting it using Collection API.
•	Use named queries wisely, keep it at a single place for easy debugging. Use them for commonly used queries only. For entity specific query, you can keep them in the entity bean itself.
•	For web applications, always try to use JNDI DataSource rather than configuring to create connection in hibernate.
•	Avoid Many-to-Many relationships, it can be easily implemented using bidirectional One-to-Many and Many-to-One relationships.
•	For collections, try to use Lists, maps and sets. Avoid array because you don’t get benefit of lazy loading.
•	Do not treat exceptions as recoverable, roll back the Transaction and close the Session. If you do not do this, Hibernate cannot guarantee that in-memory state accurately represents the persistent state.
•	Prefer DAO pattern for exposing the different methods that can be used with entity bean
•	Prefer lazy fetching for associations
44.	What is Hibernate Validator Framework?
Data validation is integral part of any application. You will find data validation at presentation layer with the use of Javascript, then at the server side code before processing it. Also data validation occurs before persisting it, to make sure it follows the correct format.
Validation is a cross cutting task, so we should try to keep it apart from our business logic. That’s why JSR303 and JSR349 provides specification for validating a bean by using annotations. Hibernate Validator provides the reference implementation of both these bean validation specs. Read more at Hibernate Validation Example.
45.	What is the benefit of Hibernate Tools Eclipse plugin?
Hibernate Tools plugin helps us in writing hibernate configuration and mapping files easily. The major benefit is the content assist to help us with properties or xml tags to use. It also validates them against the Hibernate DTD files, so we know any mistakes before hand. Learn how to install and use at Hibernate Tools Eclipse Plugin.

1.	What is a Web Service?
Web Services work on client-server model where client applications can access web services over the network. Web services provide endpoint URLs and expose methods that can be accessed over network through client programs written in java, shell script or any other different technologies.
Web services are stateless and doesn’t maintain user session like web applications.
2.	What are the advantages of Web Services?
Some of the advantages of web services are:
•	Interoperability: Web services are accessible over network and runs on HTTP/SOAP protocol and uses XML/JSON to transport data, hence it can be developed in any programming language. Web service can be written in java programming and client can be PHP and vice versa.
•	Reusability: One web service can be used by many client applications at the same time.
•	Loose Coupling: Web services client code is totally independent with server code, so we have achieved loose coupling in our application.
•	Easy to deploy and integrate, just like web applications.
•	Multiple service versions can be running at same time.
3.	What are different types of Web Services?
There are two types of web services:
0.	SOAP Web Services: Runs on SOAP protocol and uses XML technology for sending data.
1.	Restful Web Services: It’s an architectural style and runs on HTTP/HTTPS protocol almost all the time. REST is a stateless client-server architecture where web services are resources and can be identified by their URIs. Client applications can use HTTP GET/POST methods to invoke Restful web services.
4.	What is SOAP?
SOAP stands for Simple Object Access Protocol. SOAP is an XML based industry standard protocol for designing and developing web services. Since it’s XML based, it’s platform and language independent. So our server can be based on JAVA and client can be on .NET, PHP etc. and vice versa.
5.	What are advantages of SOAP Web Services?
SOAP web services have all the advantages that web services has, some of the additional advantages are:
•	WSDL document provides contract and technical details of the web services for client applications without exposing the underlying implementation technologies.
•	SOAP uses XML data for payload as well as contract, so it can be easily read by any technology.
•	SOAP protocol is universally accepted, so it’s an industry standard approach with many easily available open source implementations.
6.	What are disadvantages of SOAP Web Services?
Some of the disadvantages of SOAP protocol are:
•	Only XML can be used, JSON and other lightweight formats are not supported.
•	SOAP is based on the contract, so there is a tight coupling between client and server applications.
•	SOAP is slow because payload is large for a simple string message, since it uses XML format.
•	Anytime there is change in the server side contract, client stub classes need to be generated again.
•	Can’t be tested easily in browser
7.	What is WSDL?
WSDL stands for Web Service Description Language. WSDL is an XML based document that provides technical details about the web service. Some of the useful information in WSDL document are: method name, port types, service end point, binding, method parameters etc.
8.	What are different components of WSDL?
Some of the different tags in WSDL xml are:
•	xsd:import namespace and schemaLocation: provides WSDL URL and unique namespace for web service.
•	message: for method arguments
•	part: for method argument name and type
•	portType: service name, there can be multiple services in a wsdl document.
•	operation: contains method name
•	soap:address for endpoint URL.
9.	What is UDDI?
UDDI is acronym for Universal Description, Discovery and Integration. UDDI is a directory of web services where client applications can lookup for web services. Web Services can register to the UDDI server and make them available to client applications.
10.	What is difference between Top Down and Bottom Up approach in SOAP Web Services?
In Top Down approach first WSDL document is created to establish the contract between web service and client and then code is written, it’s also termed as contract first approach. This is hard to implement because classes need to be written to confirm the contract established in WSDL. Benefit of this approach is that both client and server code can be written in parallel.
In Bottom Up approach, first web service code is written and then WSDL is generated. It’s also termed as contract last approach. This approach is easy to implement because WSDL is generated based on code. In this approach client code have to wait for WSDL from server side to start their work.
11.	What is REST Web Services?
REST is the acronym for REpresentational State Transfer. REST is an architectural style for developing applications that can be accessed over the network. REST architectural style was brought in light by Roy Fielding in his doctoral thesis in 2000.
REST is a stateless client-server architecture where web services are resources and can be identified by their URIs. Client applications can use HTTP GET/POST methods to invoke Restful web services. REST doesn’t specify any specific protocol to use, but in almost all cases it’s used over HTTP/HTTPS. When compared to SOAP web services, these are lightweight and doesn’t follow any standard. We can use XML, JSON, text or any other type of data for request and response.
12.	What are advantages of REST web services?
Some of the advantages of REST web services are:
•	Learning curve is easy since it works on HTTP protocol
•	Supports multiple technologies for data transfer such as text, xml, json, image etc.
•	No contract defined between server and client, so loosely coupled implementation.
•	REST is a lightweight protocol
•	REST methods can be tested easily over browser.
13.	What are disadvantages of REST web services?
Some of the disadvantages of REST are:
•	Since there is no contract defined between service and client, it has to be communicated through other means such as documentation or emails.
•	Since it works on HTTP, there can’t be asynchronous calls.
•	Sessions can’t be maintained.
14.	What is a Resource in Restful web services?
Resource is the fundamental concept of Restful architecture. A resource is an object with a type, relationship with other resources and methods that operate on it. Resources are identified with their URI, HTTP methods they support and request/response data type and format of data.
15.	What are different HTTP Methods supported in Restful Web Services?
Restful web services supported HTTP methods are – GET, POST, PUT, DELETE and HEAD.
16.	Compare SOAP and REST web services?
SOAP	REST
SOAP is a standard protocol for creating web services.	REST is an architectural style to create web services.
SOAP is acronym for Simple Object Access Protocol.	REST is acronym for REpresentational State Transfer.
SOAP uses WSDL to expose supported methods and technical details.	REST exposes methods through URIs, there are no technical details.
SOAP web services and client programs are bind with WSDL contract	REST doesn’t have any contract defined between server and client
SOAP web services and client are tightly coupled with contract.	REST web services are loosely coupled.
SOAP learning curve is hard, requires us to learn about WSDL generation, client stubs creation etc.	REST learning curve is simple, POJO classes can be generated easily and works on simple HTTP methods.
SOAP supports XML data format only	REST supports any data type such as XML, JSON, image etc.
SOAP web services are hard to maintain, any change in WSDL contract requires us to create client stubs again and then make changes to client code.	REST web services are easy to maintain when compared to SOAP, a new method can be added without any change at client side for existing resources.
SOAP web services can be tested through programs or software such as Soap UI.	REST can be easily tested through CURL command, Browsers and extensions such as Chrome Postman.
17.	What are different ways to test web services?
SOAP web services can be tested programmatically by generating client stubs from WSDL or through software such as Soap UI.
REST web services can be tested easily with program, curl commands and through browser extensions. Resources supporting GET method can be tested with browser itself, without any program.
18.	Can we maintain user session in web services?
Web services are stateless so we can’t maintain user sessions in web services.
19.	What is difference between SOA and Web Services?
Service Oriented Architecture (SOA) is an architectural pattern where applications are designed in terms of services that can be accessed through communication protocol over network. SOA is a design pattern and doesn’t go into implementation.
Web Services can be thought of as Services in SOAP architecture and providing means to implement SOA pattern.
20.	What is the use of Accept and Content-Type Headers in HTTP Request?
These are important headers in Restful web services. Accept headers tells web service what kind of response client is accepting, so if a web service is capable of sending response in XML and JSON format and client sends Accept header as “application/xml” then XML response will be sent. For Accept header “application/json”, server will send the JSON response.
Content-Type header is used to tell server what is the format of data being sent in the request. If Content-Type header is “application/xml” then server will try to parse it as XML data. This header is useful in HTTP Post and Put requests.
21.	How would you choose between SOAP and REST web services?
Web Services work on client-server model and when it comes to choose between SOAP and REST, it all depends on project requirements. Let’s look at some of the conditions affecting our choice:
•	Do you know your web service clients beforehand? If Yes, then you can define a contract before implementation and SOAP seems better choice. But if you don’t then REST seems better choice because you can provide sample request/response and test cases easily for client applications to use later on.
•	How much time you have? For quick implementation REST is the best choice. You can create web service easily, test it through browser/curl and get ready for your clients.
•	What kind of data format are supported? If only XML then you can go with SOAP but if you think about supporting JSON also in future then go with REST.
22.	What is JAX-WS API?
JAX-WS stands for Java API for XML Web Services. JAX-WS is XML based Java API to build web services server and client application. It’s part of standard Java API, so we don’t need to include anything else which working with it. Refer to JAX-WS Tutorial for a complete example.
23.	Name some frameworks in Java to implement SOAP web services?
We can create SOAP web services using JAX-WS API, however some of the other frameworks that can be used are Apache Axis and Apache CXF. Note that they are not implementations of JAX-WS API, they are totally different framework that work on Servlet model to expose your business logic classes as SOAP web services. Read more at Java SOAP Web Service Eclipse example.
24.	Name important annotations used in JAX-WS API?
Some of the important annotations used in JAX-WS API are:
•	@WebService
•	@SOAPBinding
•	@WebMethod
25.	What is use of javax.xml.ws.Endpoint class?
Endpoint class provides useful methods to create endpoint and publish existing implementation as web service. This comes handy in testing web services before making further changes to deploy it on actual server.
26.	What is the difference between RPC Style and Document Style SOAP web Services?
RPC style generate WSDL document based on the method name and it’s parameters. No type definitions are present in WSDL document.
Document style contains type and can be validated against predefined schema. Let’s look at these with a simple program. Below is a simple test program where I am using Endpoint to publish my simple SOAP web service.
TestService.java

package com.journaldev.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class TestService {

	@WebMethod
	public String sayHello(String msg){
		return "Hello "+msg;
	}
	
	public static void main(String[] args){
		Endpoint.publish("https://localhost:8888/testWS", new TestService());
	}
}
When I run above program and then access the WSDL, it gives me below XML.
rpc.xml

<?xml version='1.0' encoding='UTF-8'?>
<!-- Published by JAX-WS RI (https://jax-ws.java.net). RI's version is JAX-WS RI 2.2.10 svn-revision#919b322c92f13ad085a933e8dd6dd35d4947364b. --><!-- Generated by JAX-WS RI (https://jax-ws.java.net). RI's version is JAX-WS RI 2.2.10 svn-revision#919b322c92f13ad085a933e8dd6dd35d4947364b. -->
<definitions xmlns:wsu="https://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsp="https://www.w3.org/ns/ws-policy" xmlns:wsp1_2="https://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsam="https://www.w3.org/2007/05/addressing/metadata" xmlns:soap="https://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="https://service.jaxws.journaldev.com/" xmlns:xsd="https://www.w3.org/2001/XMLSchema" xmlns="https://schemas.xmlsoap.org/wsdl/" targetNamespace="https://service.jaxws.journaldev.com/" name="TestServiceService">
<types/>
<message name="sayHello">
<part name="arg0" type="xsd:string"/>
</message>
<message name="sayHelloResponse">
<part name="return" type="xsd:string"/>
</message>
<portType name="TestService">
<operation name="sayHello">
<input wsam:Action="https://service.jaxws.journaldev.com/TestService/sayHelloRequest" message="tns:sayHello"/>
<output wsam:Action="https://service.jaxws.journaldev.com/TestService/sayHelloResponse" message="tns:sayHelloResponse"/>
</operation>
</portType>
<binding name="TestServicePortBinding" type="tns:TestService">
<soap:binding transport="https://schemas.xmlsoap.org/soap/http" style="rpc"/>
<operation name="sayHello">
<soap:operation soapAction=""/>
<input>
<soap:body use="literal" namespace="https://service.jaxws.journaldev.com/"/>
</input>
<output>
<soap:body use="literal" namespace="https://service.jaxws.journaldev.com/"/>
</output>
</operation>
</binding>
<service name="TestServiceService">
<port name="TestServicePort" binding="tns:TestServicePortBinding">
<soap:address location="https://localhost:8888/testWS"/>
</port>
</service>
</definitions>
Notice that types element is empty and we can’t validate it against any schema. Now just change the SOAPBinding.Style.RPC to SOAPBinding.Style.DOCUMENT and you will get below WSDL.
document.xml

<?xml version='1.0' encoding='UTF-8'?>
<!-- Published by JAX-WS RI (https://jax-ws.java.net). RI's version is JAX-WS RI 2.2.10 svn-revision#919b322c92f13ad085a933e8dd6dd35d4947364b. --><!-- Generated by JAX-WS RI (https://jax-ws.java.net). RI's version is JAX-WS RI 2.2.10 svn-revision#919b322c92f13ad085a933e8dd6dd35d4947364b. -->
<definitions xmlns:wsu="https://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsp="https://www.w3.org/ns/ws-policy" xmlns:wsp1_2="https://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsam="https://www.w3.org/2007/05/addressing/metadata" xmlns:soap="https://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="https://service.jaxws.journaldev.com/" xmlns:xsd="https://www.w3.org/2001/XMLSchema" xmlns="https://schemas.xmlsoap.org/wsdl/" targetNamespace="https://service.jaxws.journaldev.com/" name="TestServiceService">
<types>
<xsd:schema>
<xsd:import namespace="https://service.jaxws.journaldev.com/" schemaLocation="https://localhost:8888/testWS?xsd=1"/>
</xsd:schema>
</types>
<message name="sayHello">
<part name="parameters" element="tns:sayHello"/>
</message>
<message name="sayHelloResponse">
<part name="parameters" element="tns:sayHelloResponse"/>
</message>
<portType name="TestService">
<operation name="sayHello">
<input wsam:Action="https://service.jaxws.journaldev.com/TestService/sayHelloRequest" message="tns:sayHello"/>
<output wsam:Action="https://service.jaxws.journaldev.com/TestService/sayHelloResponse" message="tns:sayHelloResponse"/>
</operation>
</portType>
<binding name="TestServicePortBinding" type="tns:TestService">
<soap:binding transport="https://schemas.xmlsoap.org/soap/http" style="document"/>
<operation name="sayHello">
<soap:operation soapAction=""/>
<input>
<soap:body use="literal"/>
</input>
<output>
<soap:body use="literal"/>
</output>
</operation>
</binding>
<service name="TestServiceService">
<port name="TestServicePort" binding="tns:TestServicePortBinding">
<soap:address location="https://localhost:8888/testWS"/>
</port>
</service>
</definitions>
Open schemaLocation URL in browser and you will get below XML.
schemaLocation.xml

<?xml version='1.0' encoding='UTF-8'?>
<!-- Published by JAX-WS RI (https://jax-ws.java.net). RI's version is JAX-WS RI 2.2.10 svn-revision#919b322c92f13ad085a933e8dd6dd35d4947364b. -->
<xs:schema xmlns:tns="https://service.jaxws.journaldev.com/" xmlns:xs="https://www.w3.org/2001/XMLSchema" version="1.0" targetNamespace="https://service.jaxws.journaldev.com/">

<xs:element name="sayHello" type="tns:sayHello"/>

<xs:element name="sayHelloResponse" type="tns:sayHelloResponse"/>

<xs:complexType name="sayHello">
<xs:sequence>
<xs:element name="arg0" type="xs:string" minOccurs="0"/>
</xs:sequence>
</xs:complexType>

<xs:complexType name="sayHelloResponse">
<xs:sequence>
<xs:element name="return" type="xs:string" minOccurs="0"/>
</xs:sequence>
</xs:complexType>
</xs:schema>
So here WSDL document can be validated against the schema definintion.
27.	How to get WSDL file of a SOAP web service?
WSDL document can be accessed by appending ?wsdl to the SOAP endoint URL. In above example, we can access it at https://localhost:8888/testWS?wsdl location.
28.	What is sun-jaxws.xml file?
This file is used to provide endpoints details when JAX-WS web services are deployed in servlet container such as Tomcat. This file is present in WEB-INF directory and contains endpoint name, implementation class and URL pattern. For example;
sun-jaxws.xml

<?xml version="1.0" encoding="UTF-8"?>
<endpoints xmlns="https://java.sun.com/xml/ns/jax-ws/ri/runtime" version="2.0">
  <endpoint
     name="PersonServiceImpl"
     implementation="com.journaldev.jaxws.service.PersonServiceImpl"
     url-pattern="/personWS"/>
</endpoints>
29.	What is JAX-RS API?
Java API for RESTful Web Services (JAX-RS) is the Java API for creating REST web services. JAX-RS uses annotations to simplify the development and deployment of web services. JAX-RS is part of JDK, so you don’t need to include anything to use it’s annotations.
30.	Name some implementations of JAX-RS API?
There are two major implementations of JAX-RS API.
0.	Jersey: Jersey is the reference implementation provided by Sun. For using Jersey as our JAX-RS implementation, all we need to configure its servlet in web.xml and add required dependencies. Note that JAX-RS API is part of JDK not Jersey, so we have to add its dependency jars in our application.
1.	RESTEasy: RESTEasy is the JBoss project that provides JAX-RS implementation.
31.	What is wsimport utility?
We can use wsimport utility to generate the client stubs. This utility comes with standard installation of JDK. Below image shows an example execution of this utility for one of JAX-WS project.
 
32.	Name important annotations used in JAX-RS API?
Some of the important JAX-RS annotations are:
•	@Path: used to specify the relative path of class and methods. We can get the URI of a webservice by scanning the Path annotation value.
•	@GET, @PUT, @POST, @DELETE and @HEAD: used to specify the HTTP request type for a method.
•	@Produces, @Consumes: used to specify the request and response types.
•	@PathParam: used to bind the method parameter to path value by parsing it.
33.	What is the use of @XmlRootElement annotation?
XmlRootElement annotation is used by JAXB to transform java object to XML and vice versa. So we have to annotate model classes with this annotation.
34.	How to set different status code in HTTP response?
For setting HTTP status code other than 200, we have to use javax.ws.rs.core.Response class for response. Below are some of the sample return statements showing it’s usage.

return Response.status(422).entity(exception).build();
return Response.ok(response).build(); //200
For a complete example, please read RESTEasy Tutorial.


Java Heap Space
Java Heap space is used by java runtime to allocate memory to Objects and JRE classes. Whenever we create an object, it’s always created in the Heap space.
Garbage Collection runs on the heap memory to free the memory used by objects that don’t have any reference. Any object created in the heap space has global access and can be referenced from anywhere of the application.
Java Stack Memory
Java Stack memory is used for the execution of a thread. They contain method-specific values that are short-lived and references to other objects in the heap that is getting referred from the method.
Stack memory is always referenced in LIFO (Last-In-First-Out) order. Whenever a method is invoked, a new block is created in the stack memory for the method to hold local primitive values and reference to other objects in the method.
As soon as the method ends, the block becomes unused and becomes available for the next method.
Stack memory size is very less compared to Heap memory.
Heap and Stack Memory in Java Program
Let’s understand the Heap and Stack memory usage with a simple program.
package com.journaldev.test;

public class Memory {

	public static void main(String[] args) { // Line 1
		int i=1; // Line 2
		Object obj = new Object(); // Line 3
		Memory mem = new Memory(); // Line 4
		mem.foo(obj); // Line 5
	} // Line 9

	private void foo(Object param) { // Line 6
		String str = param.toString(); //// Line 7
		System.out.println(str);
	} // Line 8

}
The below image shows the Stack and Heap memory with reference to the above program and how they are being used to store primitive, Objects and reference variables.
 
Let’s go through the steps of the execution of the program.
•	As soon as we run the program, it loads all the Runtime classes into the Heap space. When the main() method is found at line 1, Java Runtime creates stack memory to be used by main() method thread.
•	We are creating primitive local variable at line 2, so it’s created and stored in the stack memory of main() method.
•	Since we are creating an Object in the 3rd line, it’s created in heap memory and stack memory contains the reference for it. A similar process occurs when we create Memory object in the 4th line.
•	Now when we call the foo() method in the 5th line, a block in the top of the stack is created to be used by the foo() method. Since Java is pass-by-value, a new reference to Object is created in the foo() stack block in the 6th line.
•	A string is created in the 7th line, it goes in the String Pool in the heap space and a reference is created in the foo() stack space for it.
•	foo() method is terminated in the 8th line, at this time memory block allocated for foo() in stack becomes free.
•	In line 9, main() method terminates and the stack memory created for main() method is destroyed. Also, the program ends at this line, hence Java Runtime frees all the memory and ends the execution of the program.
Difference between Java Heap Space and Stack Memory
Based on the above explanations, we can easily conclude the following differences between Heap and Stack memory.
1.	Heap memory is used by all the parts of the application whereas stack memory is used only by one thread of execution.
2.	Whenever an object is created, it’s always stored in the Heap space and stack memory contains the reference to it. Stack memory only contains local primitive variables and reference variables to objects in heap space.
3.	Objects stored in the heap are globally accessible whereas stack memory can’t be accessed by other threads.
4.	Memory management in stack is done in LIFO manner whereas it’s more complex in Heap memory because it’s used globally. Heap memory is divided into Young-Generation, Old-Generation etc, more details at Java Garbage Collection.
5.	Stack memory is short-lived whereas heap memory lives from the start till the end of application execution.
6.	We can use -Xms and -Xmx JVM option to define the startup size and maximum size of heap memory. We can use -Xss to define the stack memory size.
7.	When stack memory is full, Java runtime throws java.lang.StackOverFlowError whereas if heap memory is full, it throws java.lang.OutOfMemoryError: Java Heap Space error.
8.	Stack memory size is very less when compared to Heap memory. Because of simplicity in memory allocation (LIFO), stack memory is very fast when compared to heap memory.

Java 8 Functional Interface
An interface with exactly one abstract method is called Functional Interface. @FunctionalInterface annotation is added so that we can mark an interface as functional interface.
It is not mandatory to use it, but it’s best practice to use it with functional interfaces to avoid addition of extra methods accidentally. If the interface is annotated with @FunctionalInterface annotation and we try to have more than one abstract method, it throws compiler error.
The major benefit of java 8 functional interfaces is that we can use lambda expressions to instantiate them and avoid using bulky anonymous class implementation.
Java 8 Collections API has been rewritten and new Stream API is introduced that uses a lot of functional interfaces. Java 8 has defined a lot of functional interfaces in java.util.function package. Some of the useful java 8 functional interfaces are Consumer, Supplier, Function and Predicate.
You can find more detail about them in Java 8 Stream Example.
java.lang.Runnable is a great example of functional interface with single abstract method run().
Below code snippet provides some guidance for functional interfaces:

interface Foo { boolean equals(Object obj); }
// Not functional because equals is already an implicit member (Object class)

interface Comparator<T> {
 boolean equals(Object obj);
 int compare(T o1, T o2);
}
// Functional because Comparator has only one abstract non-Object method

interface Foo {
  int m();
  Object clone();
}
// Not functional because method Object.clone is not public

interface X { int m(Iterable<String> arg); }
interface Y { int m(Iterable<String> arg); }
interface Z extends X, Y {}
// Functional: two methods, but they have the same signature

interface X { Iterable m(Iterable<String> arg); }
interface Y { Iterable<String> m(Iterable arg); }
interface Z extends X, Y {}
// Functional: Y.m is a subsignature & return-type-substitutable

interface X { int m(Iterable<String> arg); }
interface Y { int m(Iterable<Integer> arg); }
interface Z extends X, Y {}
// Not functional: No method has a subsignature of all abstract methods

interface X { int m(Iterable<String> arg, Class c); }
interface Y { int m(Iterable arg, Class<?> c); }
interface Z extends X, Y {}
// Not functional: No method has a subsignature of all abstract methods

interface X { long m(); }
interface Y { int m(); }
interface Z extends X, Y {}
// Compiler error: no method is return type substitutable

interface Foo<T> { void m(T arg); }
interface Bar<T> { void m(T arg); }
interface FooBar<X, Y> extends Foo<X>, Bar<Y> {}
// Compiler error: different signatures, same erasure
Lambda Expression
Lambda Expression are the way through which we can visualize functional programming in the java object oriented world. Objects are the base of java programming language and we can never have a function without an Object, that’s why Java language provide support for using lambda expressions only with functional interfaces.
Since there is only one abstract function in the functional interfaces, there is no confusion in applying the lambda expression to the method. Lambda Expressions syntax is (argument) -> (body). Now let’s see how we can write above anonymous Runnable using lambda expression.

Runnable r1 = () -> System.out.println("My Runnable");
Let’s try to understand what is happening in the lambda expression above.
•	Runnable is a functional interface, that’s why we can use lambda expression to create it’s instance.
•	Since run() method takes no argument, our lambda expression also have no argument.
•	Just like if-else blocks, we can avoid curly braces ({}) since we have a single statement in the method body. For multiple statements, we would have to use curly braces like any other methods.
Why do we need Lambda Expression
1.	Reduced Lines of Code
One of the clear benefit of using lambda expression is that the amount of code is reduced, we have already seen that how easily we can create instance of a functional interface using lambda expression rather than using anonymous class.
2.	Sequential and Parallel Execution Support
Another benefit of using lambda expression is that we can benefit from the Stream API sequential and parallel operations support.
To explain this, let’s take a simple example where we need to write a method to test if a number passed is prime number or not.
Traditionally we would write it’s code like below. The code is not fully optimized but good for example purpose, so bear with me on this.

//Traditional approach
private static boolean isPrime(int number) {		
	if(number < 2) return false;
	for(int i=2; i<number; i++){
		if(number % i == 0) return false;
	}
	return true;
}
The problem with above code is that it’s sequential in nature, if the number is very huge then it will take significant amount of time. Another problem with code is that there are so many exit points and it’s not readable. Let’s see how we can write the same method using lambda expressions and stream API.

//Declarative approach
private static boolean isPrime(int number) {		
	return number > 1
			&& IntStream.range(2, number).noneMatch(
					index -> number % index == 0);
}
IntStream is a sequence of primitive int-valued elements supporting sequential and parallel aggregate operations. This is the int primitive specialization of Stream.
For more readability, we can also write the method like below.

private static boolean isPrime(int number) {
	IntPredicate isDivisible = index -> number % index == 0;
	
	return number > 1
			&& IntStream.range(2, number).noneMatch(
					isDivisible);
}
If you are not familiar with IntStream, it’s range() method returns a sequential ordered IntStream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1.
noneMatch() method returns whether no elements of this stream match the provided predicate. It may not evaluate the predicate on all elements if not necessary for determining the result.
3.	Passing Behaviors into methods
Let’s see how we can use lambda expressions to pass behavior of a method with a simple example. Let’s say we have to write a method to sum the numbers in a list if they match a given criteria. We can use Predicate and write a method like below.

public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
Sample usage:

//sum of all numbers
sumWithCondition(numbers, n -> true)
//sum of all even numbers
sumWithCondition(numbers, i -> i%2==0)
//sum of all numbers greater than 5
sumWithCondition(numbers, i -> i>5)
4.	Higher Efficiency with Laziness
One more advantage of using lambda expression is the lazy evaluation, for example let’s say we need to write a method to find out the maximum odd number in the range 3 to 11 and return square of it.
Usually we will write code for this method like this:

private static int findSquareOfMaxOdd(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
				max = i;
			}
		}
		return max * max;
	}
Above program will always run in sequential order but we can use Stream API to achieve this and get benefit of Laziness-seeking. Let’s see how we can rewrite this code in functional programming way using Stream API and lambda expressions.

public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
				.filter(NumberTest::isOdd) 		//Predicate is functional interface and
				.filter(NumberTest::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(NumberTest::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}
If you are surprised with the double colon (::) operator, it’s introduced in Java 8 and used for method references. Java Compiler takes care of mapping the arguments to the called method. It’s short form of lambda expressions i -> isGreaterThan3(i) or i -> NumberTest.isGreaterThan3(i).
Lambda Expression Examples
Below I am providing some code snippets for lambda expressions with small comments explaining them.

() -> {}                     // No parameters; void result

() -> 42                     // No parameters, expression body
() -> null                   // No parameters, expression body
() -> { return 42; }         // No parameters, block body with return
() -> { System.gc(); }       // No parameters, void block body

// Complex block body with multiple returns
() -> {
  if (true) return 10;
  else {
    int result = 15;
    for (int i = 1; i < 10; i++)
      result *= i;
    return result;
  }
}                          

(int x) -> x+1             // Single declared-type argument
(int x) -> { return x+1; } // same as above
(x) -> x+1                 // Single inferred-type argument, same as below
x -> x+1                   // Parenthesis optional for single inferred-type case

(String s) -> s.length()   // Single declared-type argument
(Thread t) -> { t.start(); } // Single declared-type argument
s -> s.length()              // Single inferred-type argument
t -> { t.start(); }          // Single inferred-type argument

(int x, int y) -> x+y      // Multiple declared-type parameters
(x,y) -> x+y               // Multiple inferred-type parameters
(x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
(x, int y) -> x+y          // Illegal: can't mix inferred and declared types
Method and Constructor References
A method reference is used to refer to a method without invoking it; a constructor reference is similarly used to refer to a constructor without creating a new instance of the named class or array type.
Examples of method and constructor references:

System::getProperty
System.out::println
"abc"::length
ArrayList::new
int[]::new

A stack and a heap are used for memory allocation in Java.
Java Heap Space
Java Heap space is used by java runtime to allocate memory to Objects and JRE classes. Whenever we create an object, it’s always created in the Heap space.
Garbage Collection runs on the heap memory to free the memory used by objects that don’t have any reference. Any object created in the heap space has global access and can be referenced from anywhere of the application.
Java Stack Memory
The stack is used for primitive data types, temporary variables, object addresses etc. The heap is used for storing objects in memory.
Stacks are used to store temporary variables, primitive data types etc. A block in the stack exists for a variable only as long as the variable exists. After that, the block data is erased and it can be used for storing another variable.
Java Stack memory is used for the execution of a thread. They contain method-specific values that are short-lived and references to other objects in the heap that is getting referred from the method.
Stack memory is always referenced in LIFO (Last-In-First-Out) order. Whenever a method is invoked, a new block is created in the stack memory for the method to hold local primitive values and reference to other objects in the method.
As soon as the method ends, the block becomes unused and becomes available for the next method.
Stack memory size is very less compared to Heap memory.

 

What are the advanced Java Topics?
Some of the advanced java concepts are:
•	Heap and Stack Memory
•	Garbage Collection
•	Reflection API
•	Thread Deadlock
•	Java ClassLoader
•	Java Logging API
•	Internationalization in Java
•	Java Module System

Java 8 Features
Some of the important Java 8 features are;
1.	forEach() method in Iterable interface
2.	default and static methods in Interfaces
3.	Functional Interfaces and Lambda Expressions
4.	Java Stream API for Bulk Data Operations on Collections
5.	Java Time API
6.	Collection API improvements
7.	Concurrency API improvements
8.	Java IO improvements
9.	Miscellaneous Core API improvements
Let’s have a brief look on these Java 8 features. I will provide some code snippets for better understanding, so if you want to run programs in Java 8, you will have to setup Java 8 environment by following steps.
•	Download JDK8 and install it. Installation is simple like other java versions. JDK installation is required to write, compile and run the program in Java.
•	Download latest Eclipse IDE, it provides support for java 8 now. Make sure your projects build path is using Java 8 library.
Learning Java? Nothing better than a video course trusted by over 1,70,000 students (yes, that many students). Follow this link to get heavy discount on the course.
1.	forEach() method in Iterable interface
Whenever we need to traverse through a Collection, we need to create an Iterator whose whole purpose is to iterate over and then we have business logic in a loop for each of the elements in the Collection. We might get ConcurrentModificationException if iterator is not used properly.
Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic only. forEach method takes java.util.function.Consumer object as argument, so it helps in having our business logic at a separate location that we can reuse. Let’s see forEach usage with simple example.
package com.journaldev.java8.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

public class Java8ForEachExample {

	public static void main(String[] args) {
		
		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
		
		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		
	}

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}


}
The number of lines might increase but forEach method helps in having the logic for iteration and business logic at separate place resulting in higher separation of concern and cleaner code.
2.	default and static methods in Interfaces
If you read forEach method details carefully, you will notice that it’s defined in Iterable interface but we know that interfaces can’t have method body. From Java 8, interfaces are enhanced to have method with implementation. We can use default and static keyword to create interfaces with method implementation. forEach method implementation in Iterable interface is:
	default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
We know that Java doesn’t provide multiple inheritance in Classes because it leads to Diamond Problem. So how it will be handled with interfaces now, since interfaces are now similar to abstract classes. The solution is that compiler will throw exception in this scenario and we will have to provide implementation logic in the class implementing the interfaces.
package com.journaldev.java8.defaultmethod;

@FunctionalInterface
public interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	//trying to override Object method gives compile-time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	default String toString(){
//		return "i1";
//	}
	
}
package com.journaldev.java8.defaultmethod;

@FunctionalInterface
public interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}
Notice that both the interfaces have a common method log() with implementation logic.
package com.journaldev.java8.defaultmethod;

public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
	}
	
}
As you can see that Interface1 has static method implementation that is used in MyClass.log() method implementation. Java 8 uses default and static methods heavily in Collection API and default methods are added so that our code remains backward compatible.
If any class in the hierarchy has a method with the same signature, then default methods become irrelevant. Since any class implementing an interface already has Object as a superclass, if we have equals(), hashCode() default methods in the interface, it will become irrelevant. That’s why for better clarity, interfaces are not allowed to have Object default methods.
For complete details of interface changes in Java 8, please read Java 8 interface changes.
3.	Functional Interfaces and Lambda Expressions
If you notice above interfaces code, you will notice @FunctionalInterface annotation. Functional interfaces are new concept introduced in Java 8. An interface with exactly one abstract method becomes Functional Interface. We don’t need to use @FunctionalInterface annotation to mark an interface as Functional Interface. @FunctionalInterface annotation is a facility to avoid accidental addition of abstract methods in the functional interfaces. You can think of it like @Override annotation and it’s best practice to use it. java.lang.Runnable with single abstract method run() is a great example of functional interface.
One of the major benefits of functional interface is the possibility to use lambda expressions to instantiate them. We can instantiate an interface with anonymous class but the code looks bulky.
Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("My Runnable");
			}};
Since functional interfaces have only one method, lambda expressions can easily provide the method implementation. We just need to provide method arguments and business logic. For example, we can write above implementation using lambda expression as:
Runnable r1 = () -> {
			System.out.println("My Runnable");
		};
If you have single statement in method implementation, we don’t need curly braces also. For example above Interface1 anonymous class can be instantiated using lambda as follows:
Interface1 i1 = (s) -> System.out.println(s);
		
i1.method1("abc");
So lambda expressions are a means to create anonymous classes of functional interfaces easily. There are no runtime benefits of using lambda expressions, so I will use it cautiously because I don’t mind writing a few extra lines of code.
A new package java.util.function has been added with bunch of functional interfaces to provide target types for lambda expressions and method references. Lambda expressions are a huge topic, I will write a separate article on that in the future.
You can read complete tutorial at Java 8 Lambda Expressions Tutorial.
 
4.	Java Stream API for Bulk Data Operations on Collections
A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the collection. Stream API will allow sequential as well as parallel execution. This is one of the best features for me because I work a lot with Collections and usually with Big Data, we need to filter out them based on some conditions.
Collection interface has been extended with stream() and parallelStream() default methods to get the Stream for sequential and parallel execution. Let’s see their usage with simple example.
package com.journaldev.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		
		//using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
		//using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel="+p));
		
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

	}

}
If you will run above example code, you will get output like this:
High Nums parallel=91
High Nums parallel=96
High Nums parallel=93
High Nums parallel=98
High Nums parallel=94
High Nums parallel=95
High Nums parallel=97
High Nums parallel=92
High Nums parallel=99
High Nums sequential=91
High Nums sequential=92
High Nums sequential=93
High Nums sequential=94
High Nums sequential=95
High Nums sequential=96
High Nums sequential=97
High Nums sequential=98
High Nums sequential=99
Notice that parallel processing values are not in order, so parallel processing will be very helpful while working with huge collections.
Covering everything about Stream API is not possible in this post, you can read everything about Stream API at Java 8 Stream API Example Tutorial.
5.	Java Time API
It has always been hard to work with Date, Time and Time Zones in java. There was no standard approach or API in java for date and time in Java. One of the nice addition in Java 8 is the java.time package that will streamline the process of working with time in java.
Just by looking at Java Time API packages, I can sense that it will be very easy to use. It has some sub-packages java.time.format that provides classes to print and parse dates and times and java.time.zone provides support for time-zones and their rules.
The new Time API prefers enums over integer constants for months and days of the week. One of the useful class is DateTimeFormatter for converting DateTime objects to strings.
For complete tutorial, head over to Java Date Time API Example Tutorial.
6.	Collection API improvements
We have already seen forEach() method and Stream API for collections. Some new methods added in Collection API are:
•	Iterator default method forEachRemaining(Consumer action) to perform the given action for each remaining element until all elements have been processed or the action throws an exception.
•	Collection default method removeIf(Predicate filter) to remove all of the elements of this collection that satisfy the given predicate.
•	Collection spliterator() method returning Spliterator instance that can be used to traverse elements sequentially or parallel.
•	Map replaceAll(), compute(), merge() methods.
•	Performance Improvement for HashMap class with Key Collisions
7.	Concurrency API improvements
Some important concurrent API enhancements are:
•	ConcurrentHashMap compute(), forEach(), forEachEntry(), forEachKey(), forEachValue(), merge(), reduce() and search() methods.
•	CompletableFuture that may be explicitly completed (setting its value and status).
•	Executors newWorkStealingPool() method to create a work-stealing thread pool using all available processors as its target parallelism level.
8.	Java IO improvements
Some IO improvements known to me are:
•	Files.list(Path dir) that returns a lazily populated Stream, the elements of which are the entries in the directory.
•	Files.lines(Path path) that reads all lines from a file as a Stream.
•	Files.find() that returns a Stream that is lazily populated with Path by searching for files in a file tree rooted at a given starting file.
•	BufferedReader.lines() that return a Stream, the elements of which are lines read from this BufferedReader.
9.	Miscellaneous Core API improvements
Some misc API improvements that might come handy are:
0.	ThreadLocal static method withInitial(Supplier supplier) to create instance easily.
1.	Comparator interface has been extended with a lot of default and static methods for natural ordering, reverse order etc.
2.	min(), max() and sum() methods in Integer, Long and Double wrapper classes.
3.	logicalAnd(), logicalOr() and logicalXor() methods in Boolean class.
4.	ZipFile.stream() method to get an ordered Stream over the ZIP file entries. Entries appear in the Stream in the order they appear in the central directory of the ZIP file.
5.	Several utility methods in Math class.
6.	jjs command is added to invoke Nashorn Engine.
7.	jdeps command is added to analyze class files
8.	JDBC-ODBC Bridge has been removed.
9.	PermGen memory space has been removed
Java 9 Modules
We will look into following topics about java 9 modules system.
1.	Introduction
2.	Java SE 9: Jigsaw Project
3.	Problems of Current Java System?
4.	Advantages of Java SE 9 Module System
5.	Compare JDK 8 and JDK 9
6.	What is Java 9 Module?
7.	Mother of Java 9 Module System
8.	Compare Java 8 and Java 9 Applications
Introduction
Oracle corp has postponed Java 9 release from March 2017 to September 2017.
As we know, Java SE 8 came with three big new features (plus few more enhancements and new features).
1.	Lambda Expressions
2.	Stream API
3.	Date API
In the same way, Java SE 9 is coming with three big features (plus few more enhancements and new features):
1.	Java Module System (Jigsaw Project)
2.	Java REPL
3.	Milling Project Coin
In this post, we will discuss Oracle Jigsaw project basics.
Java SE 9: Jigsaw Project
Jigsaw project is going to introduce completely new concept of Java SE 9: Java Module System.
It is very big and prestigious project from Oracle Corp in Java SE 9 release. Initially, they have started this project as part of Java SE 7 Release. However, with huge changes, it’s postponed to Java SE 8 then again postponed. Now it is about to release with Java SE 9 in September 2017.
Main Goals of Jigsaw Project:
•	The Modular JDK
As we know, Current JDK system is too big. So they have decided to divide JDK itself into small modules to get a number of benefits (We will discuss them soon in the coming sections).
•	Modular Source Code
Current source code jar files are too big, especially rt.jar is too big right. So they are going to divide Java Source code into smaller modules.
•	Modular Run-Time Images
The main goal of this Feature is “Restructure the JDK and JRE run-time images to accommodate modules”.
•	Encapsulate Most Internal APIs
The main goal of this feature is “Make most of the JDK’s internal APIs inaccessible by default but leave a few critical, widely-used internal APIs accessible”.
•	Java Platform Module System
The main goal of this Feature is “Allowing the user to create their modules to develop their applications”.
•	jlink: The Java Linker
The main goal of this jlink Tool is “Allowing the user to create executable to their applications”.
If you don’t understand these things clearly, do NOT worry. We will discuss these concepts in-depth with some useful examples in the coming sections and also in my coming posts.
Problems of Current Java System?
In this section, we will discuss “Why we need Java SE 9 Module System” that means the problems of Current Java System.
Java SE 8 or earlier systems have following problems in developing or delivering Java Based applications.
•	As JDK is too big, it is a bit tough to scale down to small devices. Java SE 8 has introduced 3 types of compact profiles to solve this problem: compact1, compact2, and compact3. But it does not solve this problem.
•	JAR files like rt.jar etc are too big to use in small devices and applications.
•	As JDK is too big, our applications or devices are not able to support better Performance.
•	There is no Strong Encapsulation in the current Java System because “public” access modifier is too open. Everyone can access it.
•	As JDK, JRE is too big, it is hard to Test and Maintain applications.
•	As the public is too open, They are not to avoid the accessing of some Internal Non-Critical APIs like sun.*, *.internal.* etc.
•	As User can access Internal APIs too, Security is also big issue.
•	Application is too big.
•	Its a bit tough to support Less Coupling between components.
To solve all these problems, Oracle Corp is going to release Java Module system in Java SE 9 Release.
Advantages of Java SE 9 Module System
Java SE 9 Module System is going to provide the following benefits
•	As Java SE 9 is going to divide JDK, JRE, JARs etc, into smaller modules, we can use whatever modules we want. So it is very easy to scale down the Java Application to Small devices.
•	Ease of Testing and Maintainability.
•	Supports better Performance.
•	As public is not just public, it supports very Strong Encapsulation. (Don’t worry its a big concept. we will explore it with some useful examples soon).
•	We cannot access Internal Non-Critical APIs anymore.
•	Modules can hide unwanted and internal details very safely, we can get better Security.
•	Application is too small because we can use only what ever modules we want.
•	Its easy to support Less Coupling between components.
•	Its easy to support Single Responsibility Principle (SRP).
We will explore all these concepts one by one soon.
Compare JDK 8 and JDK 9
We know what a JDK software contains. After installing JDK 8 software, we can see a couple of directories like bin, jre, lib etc in Java Home folder.
However, Oracle Corp has changed this folder structure a bit differently as shown below.
 
JDK 8 Folder Structure:
 
JDK 9 Folder Structure:
 
Here JDK 9 does NOT contain JRE. In JDK 9, JRE is separated into a separate distribution folder. JDK 9 software contains a new folder “jmods”. It contains a set of Java 9 Modules as shown below.
In JDK 9, No rt.jar and No tools.jar
 
NOTE:-
As of today, “jmods” contains 95 modules. It may increase in the final release.
“jmods” folder is available at ${JAVA_HOME}/jmods. These are known as JDK Modules.
What is Java 9 Module?
A Module is a self-describing collection of Code, Data, and some Resources. It is a set of related Packages, Types (classes, abstract classes, interfaces etc) with Code & Data and Resources.
Each Module contains only a set of related code and data to support Single Responsibility (Functionality) Principle (SRP).
 
The main goal of Java 9 Module System is to support Modular Programming in Java.
We will discuss on “What is a Module Descriptor” and “How to develop Java Modules” in my coming posts.
Mother of Java 9 Module System
As of now, Java 9 Module System has 95 modules in Early Access JDK. Oracle Corp has separated JDK jars and Java SE Specifications into two set of Modules.
•	All JDK Modules starts with “jdk.*”
•	All Java SE Specifications Modules starts with “java.*”
Java 9 Module System has a “java.base” Module. It’s known as Base Module. It’s an Independent module and does NOT dependent on any other modules. By default, all other Modules dependent on this module.
That’s why “java.base” Module is also known as The Mother of Java 9 Modules.
It’s default module for all JDK Modules and User-Defined Modules.
Compare Java 8 and Java 9 Applications
We have already developed many Java applications using Java 5, 6,7, or 8. We know how a Java 8 or earlier applications looks like and what it contains.
In brief, I have depicted a Java 8 applications in a diagram as shown below:
 
In a Java 8 or earlier applications, Top level component a Package. It groups a set related to types into a group. It also contains a set of resources.
Java 9 Applications does not have much difference with this. It just introduced a new component called “Module”, which is used to group a set of related Packages into a group. And one more new component that Module Descriptor (“module-info.java”). That’s it.
Rest of the application is same as earlier versions of applications as shown below.
 
Like Java 8 applications have Packages as a Top level components, Java 9 applications have Module as Top Level components.
NOTE:-
Each Java 9 Module have one and only one Module and one Module Descriptor. Unlike Java 8 Packages, We cannot create multiple modules into a single Module.
In brief I can say a Java 9 Module contains the following main components:
•	One Module
•	Module Name
•	Module Descriptor
•	Set of Packages
•	Set of Types and Resources
Here Resources may be module-info.java (Module Descriptor) or any other properties or XML.
1.	Java 8 Stream
2.	Collections and Java Stream
3.	Functional Interfaces in Java 8 Stream
1.	Function and BiFunction
2.	Predicate and BiPredicate
3.	Consumer and BiConsumer
4.	Supplier
4.	java.util.Optional
5.	java.util.Spliterator
6.	Java Stream Intermediate and Terminal Operations
7.	Java Stream Short Circuiting Operations
8.	Java Stream Examples
1.	Creating Java Streams
2.	Converting Java Stream to Collection or Array
3.	Java Stream Intermediate Operations
4.	Java Stream Terminal Operations
9.	Java 8 Stream API Limitations
Java Stream
Before we look into Java Stream API Examples, let’s see why it was required. Suppose we want to iterate over a list of integers and find out sum of all the integers greater than 10.
Prior to Java 8, the approach to do it would be:

private static int sumIterator(List<Integer> list) {
	Iterator<Integer> it = list.iterator();
	int sum = 0;
	while (it.hasNext()) {
		int num = it.next();
		if (num > 10) {
			sum += num;
		}
	}
	return sum;
}
There are three major problems with the above approach:
1.	We just want to know the sum of integers but we would also have to provide how the iteration will take place, this is also called external iteration because client program is handling the algorithm to iterate over the list.
2.	The program is sequential in nature, there is no way we can do this in parallel easily.
3.	There is a lot of code to do even a simple task.
To overcome all the above shortcomings, Java 8 Stream API was introduced. We can use Java Stream API to implement internal iteration, that is better because java framework is in control of the iteration.
Internal iteration provides several features such as sequential and parallel execution, filtering based on the given criteria, mapping etc.
Most of the Java 8 Stream API method arguments are functional interfaces, so lambda expressions work very well with them. Let’s see how can we write above logic in a single line statement using Java Streams.

private static int sumStream(List<Integer> list) {
	return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
}
Notice that above program utilizes java framework iteration strategy, filtering and mapping methods and would increase efficiency.
First of all we will look into the core concepts of Java 8 Stream API and then we will go through some examples for understanding most commonly used methods.
#### Collections and Java Stream
A collection is an in-memory data structure to hold values and before we start using collection, all the values should have been populated. Whereas a java Stream is a data structure that is computed on-demand.
Java Stream doesn’t store data, it operates on the source data structure (collection and array) and produce pipelined data that we can use and perform specific operations. Such as we can create a stream from the list and filter it based on a condition.
Java Stream operations use functional interfaces, that makes it a very good fit for functional programming using lambda expression. As you can see in the above example that using lambda expressions make our code readable and short.
Java 8 Stream internal iteration principle helps in achieving lazy-seeking in some of the stream operations. For example filtering, mapping, or duplicate removal can be implemented lazily, allowing higher performance and scope for optimization.
Java Streams are consumable, so there is no way to create a reference to stream for future usage. Since the data is on-demand, it’s not possible to reuse the same stream multiple times.
Java 8 Stream support sequential as well as parallel processing, parallel processing can be very helpful in achieving high performance for large collections.
All the Java Stream API interfaces and classes are in the java.util.stream package. Since we can use primitive data types such as int, long in the collections using auto-boxing and these operations could take a lot of time, there are specific classes for primitive types – IntStream, LongStream and DoubleStream.
Functional Interfaces in Java 8 Stream
Some of the commonly used functional interfaces in the Java 8 Stream API methods are:
1.	Function and BiFunction: Function represents a function that takes one type of argument and returns another type of argument. Function<T, R> is the generic form where T is the type of the input to the function and R is the type of the result of the function.
For handling primitive types, there are specific Function interfaces – ToIntFunction, ToLongFunction, ToDoubleFunction, ToIntBiFunction, ToLongBiFunction, ToDoubleBiFunction, LongToIntFunction, LongToDoubleFunction, IntToLongFunction, IntToDoubleFunction etc.
Some of the Stream methods where Function or it’s primitive specialization is used are:
•	<R> Stream<R> map(Function<? super T, ? extends R> mapper)
•	IntStream mapToInt(ToIntFunction<? super T> mapper) – similarly for long and double returning primitive specific stream.
•	IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) – similarly for long and double
•	<A> A[] toArray(IntFunction<A[]> generator)
•	<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
2.	Predicate and BiPredicate: It represents a predicate against which elements of the stream are tested. This is used to filter elements from the java stream. Just like Function, there are primitive specific interfaces for int, long and double.
Some of the Stream methods where Predicate or BiPredicate specializations are used are:
•	Stream<T> filter(Predicate<? super T> predicate)
•	boolean anyMatch(Predicate<? super T> predicate)
•	boolean allMatch(Predicate<? super T> predicate)
•	boolean noneMatch(Predicate<? super T> predicate)
3.	Consumer and BiConsumer: It represents an operation that accepts a single input argument and returns no result. It can be used to perform some action on all the elements of the java stream.
Some of the Java 8 Stream methods where Consumer, BiConsumer or it’s primitive specialization interfaces are used are:
•	Stream<T> peek(Consumer<? super T> action)
•	void forEach(Consumer<? super T> action)
•	void forEachOrdered(Consumer<? super T> action)
4.	Supplier: Supplier represent an operation through which we can generate new values in the stream. Some of the methods in Stream that takes Supplier argument are:
•	public static<T> Stream<T> generate(Supplier<T> s)
•	<R> R collect(Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner)
java.util.Optional
Java Optional is a container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value. Stream terminal operations return Optional object. Some of these methods are:
•	Optional<T> reduce(BinaryOperator<T> accumulator)
•	Optional<T> min(Comparator<? super T> comparator)
•	Optional<T> max(Comparator<? super T> comparator)
•	Optional<T> findFirst()
•	Optional<T> findAny()
java.util.Spliterator
For supporting parallel execution in Java 8 Stream API, Spliterator interface is used. Spliterator trySplit method returns a new Spliterator that manages a subset of the elements of the original Spliterator.
Java Stream Intermediate and Terminal Operations
Java Stream API operations that returns a new Stream are called intermediate operations. Most of the times, these operations are lazy in nature, so they start producing new stream elements and send it to the next operation. Intermediate operations are never the final result producing operations. Commonly used intermediate operations are filter and map.
Java 8 Stream API operations that returns a result or produce a side effect. Once the terminal method is called on a stream, it consumes the stream and after that we can’t use stream. Terminal operations are eager in nature i.e they process all the elements in the stream before returning the result. Commonly used terminal methods are forEach, toArray, min, max, findFirst, anyMatch, allMatch etc. You can identify terminal methods from the return type, they will never return a Stream.
Java Stream Short Circuiting Operations
An intermediate operation is called short circuiting, if it may produce finite stream for an infinite stream. For example limit() and skip() are two short circuiting intermediate operations.
A terminal operation is called short circuiting, if it may terminate in finite time for infinite stream. For example anyMatch, allMatch, noneMatch, findFirst and findAny are short circuiting terminal operations.
Java Stream Examples
I have covered almost all the important parts of the Java 8 Stream API. It’s exciting to use this new API features and let’s see it in action with some java stream examples.
Creating Java Streams
There are several ways through which we can create a java stream from array and collections. Let’s look into these with simple examples.
1.	We can use Stream.of() to create a stream from similar type of data. For example, we can create Java Stream of integers from a group of int or Integer objects.
2.	
3.	Stream<Integer> stream = Stream.of(1,2,3,4);
4.	We can use Stream.of() with an array of Objects to return the stream. Note that it doesn’t support autoboxing, so we can’t pass primitive type array.
5.	
6.	Stream<Integer> stream = Stream.of(new Integer[]{1,2,3,4}); 
7.	//works fine
8.	
9.	Stream<Integer> stream1 = Stream.of(new int[]{1,2,3,4}); 
10.	//Compile time error, Type mismatch: cannot convert from Stream<int[]> to Stream<Integer>
11.	We can use Collection stream() to create sequential stream and parallelStream() to create parallel stream.
12.	
13.	List<Integer> myList = new ArrayList<>();
14.	for(int i=0; i<100; i++) myList.add(i);
15.			
16.	//sequential stream
17.	Stream<Integer> sequentialStream = myList.stream();
18.			
19.	//parallel stream
20.	Stream<Integer> parallelStream = myList.parallelStream();
21.	We can use Stream.generate() and Stream.iterate() methods to create Stream.
22.	
23.	Stream<String> stream1 = Stream.generate(() -> {return "abc";});
24.	Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
25.	Using Arrays.stream() and String.chars() methods.
26.	
27.	LongStream is = Arrays.stream(new long[]{1,2,3,4});
28.	IntStream is2 = "abc".chars();
Converting Java Stream to Collection or Array
There are several ways through which we can get a Collection or Array from a java Stream.
1.	We can use java Stream collect() method to get List, Map or Set from stream.
2.	
3.	Stream<Integer> intStream = Stream.of(1,2,3,4);
4.	List<Integer> intList = intStream.collect(Collectors.toList());
5.	System.out.println(intList); //prints [1, 2, 3, 4]
6.	
7.	intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
8.	Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
9.	System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}
10.	We can use stream toArray() method to create an array from the stream.
11.	
12.	Stream<Integer> intStream = Stream.of(1,2,3,4);
13.	Integer[] intArray = intStream.toArray(Integer[]::new);
14.	System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]
Java Stream Intermediate Operations
Let’s look into commonly used java Stream intermediate operations example.
1.	Stream filter() example: We can use filter() method to test stream elements for a condition and generate filtered list.
2.	
3.	List<Integer> myList = new ArrayList<>();
4.	for(int i=0; i<100; i++) myList.add(i);
5.	Stream<Integer> sequentialStream = myList.stream();
6.	
7.	Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); //filter numbers greater than 90
8.	System.out.print("High Nums greater than 90=");
9.	highNums.forEach(p -> System.out.print(p+" "));
10.	//prints "High Nums greater than 90=91 92 93 94 95 96 97 98 99 "
11.	Stream map() example: We can use map() to apply functions to an stream. Let’s see how we can use it to apply upper case function to a list of Strings.
12.	
13.	Stream<String> names = Stream.of("aBc", "d", "ef");
14.	System.out.println(names.map(s -> {
15.			return s.toUpperCase();
16.		}).collect(Collectors.toList()));
17.	//prints [ABC, D, EF]
18.	Stream sorted() example: We can use sorted() to sort the stream elements by passing Comparator argument.
19.	
20.	Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
21.	List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
22.	System.out.println(reverseSorted); // [ef, d, aBc, 123456]
23.	
24.	Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
25.	List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
26.	System.out.println(naturalSorted); //[123456, aBc, d, ef]
27.	Stream flatMap() example: We can use flatMap() to create a stream from the stream of list. Let’s see a simple example to clear this doubt.
28.	
29.	Stream<List<String>> namesOriginalList = Stream.of(
30.		Arrays.asList("Pankaj"), 
31.		Arrays.asList("David", "Lisa"),
32.		Arrays.asList("Amit"));
33.	//flat the stream from List<String> to String stream
34.	Stream<String> flatStream = namesOriginalList
35.		.flatMap(strList -> strList.stream());
36.	
37.	flatStream.forEach(System.out::println);
Java Stream Terminal Operations
Let’s look at some of the java stream terminal operations example.
1.	Stream reduce() example: We can use reduce() to perform a reduction on the elements of the stream, using an associative accumulation function, and return an Optional. Let’s see how we can use it multiply the integers in a stream.
2.	
3.	Stream<Integer> numbers = Stream.of(1,2,3,4,5);
4.			
5.	Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i*j;});
6.	if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get()); //120
7.	Stream count() example: We can use this terminal operation to count the number of items in the stream.
8.	
9.	Stream<Integer> numbers1 = Stream.of(1,2,3,4,5);
10.			
11.	System.out.println("Number of elements in stream="+numbers1.count()); //5
12.	Stream forEach() example: This can be used for iterating over the stream. We can use this in place of iterator. Let’s see how to use it for printing all the elements of the stream.
13.	
14.	Stream<Integer> numbers2 = Stream.of(1,2,3,4,5);
15.	numbers2.forEach(i -> System.out.print(i+",")); //1,2,3,4,5,
16.	Stream match() examples: Let’s see some of the examples for matching methods in Stream API.
17.	
18.	Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
19.	System.out.println("Stream contains 4? "+numbers3.anyMatch(i -> i==4));
20.	//Stream contains 4? true
21.	
22.	Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
23.	System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
24.	//Stream contains all elements less than 10? true
25.	
26.	Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
27.	System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));
28.	//Stream doesn't contain 10? true
29.	Stream findFirst() example: This is a short circuiting terminal operation, let’s see how we can use it to find the first string from a stream starting with D.
30.	
31.	Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa");
32.	Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
33.	if(firstNameWithD.isPresent()){
34.		System.out.println("First Name starting with D="+firstNameWithD.get()); //David
35.	}
Java 8 Stream API Limitations
Java 8 Stream API brings a lot of new stuffs to work with list and arrays, but it has some limitations too.
1.	Stateless lambda expressions: If you are using parallel stream and lambda expressions are stateful, it can result in random responses. Let’s see it with a simple program.
StatefulParallelStream.java

package com.journaldev.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StatefulParallelStream {

	public static void main(String[] args) {

		List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		List<Integer> result = new ArrayList<Integer>();
		 
		Stream<Integer> stream = ss.parallelStream();
		 
		stream.map(s -> {
		        synchronized (result) {
		          if (result.size() < 10) {
		            result.add(s);
		          }
		        }
				return s;
		    }).forEach( e -> {});
		 System.out.println(result);   
	}
}
If we run above program, you will get different results because it depends on the way stream is getting iterated and we don’t have any order defined for parallel processing. If we use sequential stream, then this problem will not arise.
2.	Once a Stream is consumed, it can’t be used later on. As you can see in above examples that every time I am creating a stream.
3.	There are a lot of methods in Stream API and the most confusing part is the overloaded methods. It makes the learning curve time taking.

Some of the important java 9 features are;
1.	Java 9 REPL (JShell)
2.	Factory Methods for Immutable List, Set, Map and Map.Entry
3.	Private methods in Interfaces
4.	Java 9 Module System
5.	Process API Improvements
6.	Try With Resources Improvement
7.	CompletableFuture API Improvements
8.	Reactive Streams
9.	Diamond Operator for Anonymous Inner Class
10.	Optional Class Improvements
11.	Stream API Improvements
12.	Enhanced @Deprecated annotation
13.	HTTP 2 Client
14.	Multi-Resolution Image API
15.	Miscellaneous Java 9 Features
Oracle Corporation is going to release Java SE 9 around the end of March 2017. In this post, I’m going to discuss “Java 9 Features” briefly with some examples.
1.	Java 9 REPL (JShell)
Oracle Corp has introduced a new tool called “jshell”. It stands for Java Shell and also known as REPL (Read Evaluate Print Loop). It is used to execute and test any Java Constructs like class, interface, enum, object, statements etc. very easily.
We can download JDK 9 EA (Early Access) software from https://jdk9.java.net/download/

G:\>jshell
|  Welcome to JShell -- Version 9-ea
|  For an introduction type: /help intro


jshell> int a = 10
a ==> 10

jshell> System.out.println("a value = " + a )
a value = 10
If you want to know more about REPL tool, Please go through Java 9 REPL Basics (Part-1) and Java 9 REPL Features (Part-2).
2.	Factory Methods for Immutable List, Set, Map and Map.Entry
Oracle Corp has introduced some convenient factory methods to create Immutable List, Set, Map and Map.Entry objects. These utility methods are used to create empty or non-empty Collection objects.
In Java SE 8 and earlier versions, We can use Collections class utility methods like unmodifiableXXX to create Immutable Collection objects. For instance, if we want to create an Immutable List, then we can use Collections.unmodifiableList method.
However, these Collections.unmodifiableXXX methods are a tedious and verbose approach. To overcome those shortcomings, Oracle Corp has added a couple of utility methods to List, Set and Map interfaces.
List and Set interfaces have “of()” methods to create an empty or no-empty Immutable List or Set objects as shown below:
Empty List Example

List immutableList = List.of();
Non-Empty List Example

List immutableList = List.of("one","two","three");
The Map has two sets of methods: of() methods and ofEntries() methods to create an Immutable Map object and an Immutable Map.Entry object respectively.
Empty Map Example

jshell> Map emptyImmutableMap = Map.of()
emptyImmutableMap ==> {}
Non-Empty Map Example

jshell> Map nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three")
nonemptyImmutableMap ==> {2=two, 3=three, 1=one}
If you want to read more about these utility methods, please go through the following links:
•	Java 9 Factory Methods for Immutable List
•	Java 9 Factory Methods for Immutable Set
•	Java 9 Factory Methods for Immutable Map and Map.Entry
3.	Private methods in Interfaces
In Java 8, we can provide method implementation in Interfaces using Default and Static methods. However we cannot create private methods in Interfaces.
To avoid redundant code and more re-usability, Oracle Corp is going to introduce private methods in Java SE 9 Interfaces. From Java SE 9 onwards, we can write private and private static methods too in an interface using a ‘private’ keyword.
These private methods are like other class private methods only, there is no difference between them.

public interface Card{

  private Long createCardID(){
    // Method implementation goes here.
  }

  private static void displayCardDetails(){
    // Method implementation goes here.
  }

}
If you want to read more about this new feature, please go through this link: Java 9 Private methods in Interface.
4.	Java 9 Module System
One of the big changes or java 9 feature is the Module System. Oracle Corp is going to introduce the following features as part of Jigsaw Project.
•	Modular JDK
•	Modular Java Source Code
•	Modular Run-time Images
•	Encapsulate Java Internal APIs
•	Java Platform Module System
Before Java SE 9 versions, we are using Monolithic Jars to develop Java-Based applications. This architecture has a lot of limitations and drawbacks. To avoid all these shortcomings, Java SE 9 is coming with the Module System.
JDK 9 is coming with 92 modules (may change in final release). We can use JDK Modules and also we can create our own modules as shown below:
Simple Module Example

module com.foo.bar { }
Here we are using ‘module’ to create a simple module. Each module has a name, related code, and other resources.
To read more details about this new architecture and hands-on experience, please go through my original tutorials here:
•	Java 9 Module System Basics
•	Java 9 Module Examples using command prompt
•	Java 9 Hello World Module Example using Eclipse IDE
5.	Process API Improvements
Java SE 9 is coming with some improvements in Process API. They have added couple new classes and methods to ease the controlling and managing of OS processes.
Two new interfcase in Process API:
•	java.lang.ProcessHandle
•	java.lang.ProcessHandle.Info
Process API example

 ProcessHandle currentProcess = ProcessHandle.current();
 System.out.println("Current Process Id: = " + currentProcess.getPid());
6.	Try With Resources Improvement
We know, Java SE 7 has introduced a new exception handling construct: Try-With-Resources to manage resources automatically. The main goal of this new statement is “Automatic Better Resource Management”.
Java SE 9 is going to provide some improvements to this statement to avoid some more verbosity and improve some Readability.
Java SE 7 example

void testARM_Before_Java9() throws IOException{
 BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
 try (BufferedReader reader2 = reader1) {
   System.out.println(reader2.readLine());
 }
}
#### Java 9 example

void testARM_Java9() throws IOException{
 BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
 try (reader1) {
   System.out.println(reader1.readLine());
 }
}
To read more about this new feature, please go through my original tutorial at: Java 9 Try-With-Resources Improvements
7.	CompletableFuture API Improvements
In Java SE 9, Oracle Corp is going to improve CompletableFuture API to solve some problems raised in Java SE 8. They are going add to support some delays and timeouts, some utility methods and better sub-classing.

Executor exe = CompletableFuture.delayedExecutor(50L, TimeUnit.SECONDS);
Here delayedExecutor() is a static utility method used to return a new Executor that submits a task to the default executor after the given delay.
8.	Reactive Streams
Nowadays, Reactive Programming has become very popular in developing applications to get some beautiful benefits. Scala, Play, Akka, etc. Frameworks have already integrated Reactive Streams and getting many benefits. Oracle Corps is also introducing new Reactive Streams API in Java SE 9.
Java SE 9 Reactive Streams API is a Publish/Subscribe Framework to implement Asynchronous, Scalable and Parallel applications very easily using Java language.
Java SE 9 has introduced the following API to develop Reactive Streams in Java-based applications.
•	java.util.concurrent.Flow
•	java.util.concurrent.Flow.Publisher
•	java.util.concurrent.Flow.Subscriber
•	java.util.concurrent.Flow.Processor
Read more at Java 9 Reactive Streams.
9.	Diamond Operator for Anonymous Inner Class
We know, Java SE 7 has introduced one new feature: Diamond Operator to avoid redundant code and verbosity, to improve readability. However, in Java SE 8, Oracle Corp (Java Library Developer) has found that some limitations in the use of Diamond operator with Anonymous Inner Class. They have fixed those issues and going to release them as part of Java 9.

  public List getEmployee(String empid){
     // Code to get Employee details from Data Store
     return new List(emp){ };
  }
Here we are using just “List” without specifying the type parameter.
10.	Optional Class Improvements
In Java SE 9, Oracle Corp has added some useful new methods to java.util.Optional class. Here I’m going to discuss about one of those methods with some simple example: stream method
If a value present in the given Optional object, this stream() method returns a sequential Stream with that value. Otherwise, it returns an empty Stream.
They have added “stream()” method to work on Optional objects lazily as shown below:

Stream<Optional> emp = getEmployee(id)
Stream empStream = emp.flatMap(Optional::stream)
Here Optional.stream() method is used to convert a Stream of Optional of Employee object into a Stream of Employee so that we can work on this result lazily in the result code.
To understand more about this feature with more examples and to read more new methods added to Optional class, please go through my original tutorial at: Java SE 9: Optional Class Improvements
11.	Stream API Improvements
In Java SE 9, Oracle Corp has added four useful new methods to java.util.Stream interface. As Stream is an interface, all those new implemented methods are default methods. Two of them are very important: dropWhile and takeWhile methods
If you are familiar with Scala Language or any Functions programming language, you will definitely know about these methods. These are very useful methods in writing some functional style code. Let us discuss the takeWhile utility method here.
This takeWhile() takes a predicate as an argument and returns a Stream of the subset of the given Stream values until that Predicate returns false for the first time. If the first value does NOT satisfy that Predicate, it just returns an empty Stream.

jshell> Stream.of(1,2,3,4,5,6,7,8,9,10).takeWhile(i -> i < 5 )
                 .forEach(System.out::println);
To read more about takeWhile and dropWhile methods and other new methods, please go through my original tutorial at: Java SE 9: Stream API Improvements
12.	Enhanced @Deprecated annotation
In Java SE 8 and earlier versions, @Deprecated annotation is just a Marker interface without any methods. It is used to mark a Java API that is a class, field, method, interface, constructor, enum etc.
In Java SE 9, Oracle Corp has enhanced @Deprecated annotation to provide more information about deprecated API and also provide a Tool to analyze an application’s static usage of deprecated APIs. They have add two methods to this Deprecated interface: forRemoval and since to serve this information.
13.	HTTP 2 Client
In Java SE 9, Oracle Corp is going to release New HTTP 2 Client API to support HTTP/2 protocol and WebSocket features. As existing or Legacy HTTP Client API has numerous issues (like supports HTTP/1.1 protocol and does not support HTTP/2 protocol and WebSocket, works only in Blocking mode and lot of performance issues.), they are replacing this HttpURLConnection API with new HTTP client.
They are going to introduce a new HTTP 2 Client API under the “java.net.http” package. It supports both HTTP/1.1 and HTTP/2 protocols. It supports both Synchronous (Blocking Mode) and Asynchronous Modes. It supports Asynchronous Mode using the WebSocket API.
We can see this new API at https://download.java.net/java/jdk9/docs/api/java/net/http/package-summary.html
HTTP 2 Client Example

jshell> import java.net.http.*

jshell> import static java.net.http.HttpRequest.*

jshell> import static java.net.http.HttpResponse.*

jshell> URI uri = new URI("https://rams4java.blogspot.co.uk/2016/05/java-news.html")
uri ==> https://rams4java.blogspot.co.uk/2016/05/java-news.html

jshell> HttpResponse response = HttpRequest.create(uri).body(noBody()).GET().response()
response ==> java.net.http.HttpResponseImpl@79efed2d

jshell> System.out.println("Response was " + response.body(asString()))
Please go through my original tutorial at: Java SE 9: HTTP 2 Client to understand HTTP/2 protocol & WebSocket, Benefits of new API and Drawbacks of OLD API with some useful examples.
14.	Multi-Resolution Image API
In Java SE 9, Oracle Corp is going to introduce a new Multi-Resolution Image API. Important interface in this API is MultiResolutionImage . It is available in java.awt.image package.
MultiResolutionImage encapsulates a set of images with different Height and Widths (that is different resolutions) and allows us to query them with our requirements.
15.	Miscellaneous Java 9 Features
In this section, I will just list out some miscellaneous Java SE 9 New Features. I’m NOT saying these are less important features. They are also important and useful to understand them very well with some useful examples.
As of now, I did not get enough information about these features. That’s why I am going to list them here for a brief understanding. I will pick up these features one by one and add to the above section with a brief discussion and example. And finally write a separate tutorial later.
•	GC (Garbage Collector) Improvements
•	Stack-Walking API
•	Filter Incoming Serialization Data
•	Deprecate the Applet API
•	Indify String Concatenation
•	Enhanced Method Handles
•	Java Platform Logging API and Service
•	Compact Strings
•	Parser API for Nashorn
•	Javadoc Search
•	HTML5 Javadoc

Long Term Support Model
Starting 2017, Oracle & the Java community announced its shift to a new 6-month cadence for Java. It moved to a Long Term Support (LTS) model for Oracle Java SE products.
What does this mean?
LTS version of the products will offer premier and sustained support from Oracle and it will be targeted every 3 years.
Each Java release is modeled after one or two major feature, these features drive the release. Any obstacle postpones the release and late to market. Project Jigsaw was a major feature of Java 9, it pushed out the release dates a couple of times and the release was delayed by more than 1.5 years. 6 months cadence release will follow a release train. Release train will have a schedule every 6 months. Features which make the cut get boarded on the train; else they wait for the next scheduled train.
Oracle JDK vs Open JDK
In order to be more developer-friendly, Oracle & Java community now promotes the OpenJDK binaries as primary JDK going forward. This is a big relief from earlier days, where the JDK binaries were propriety and licensed by Oracle, which had various restrictions around redistribution. Oracle will, however, keep producing their JDK, but only for long term support releases. This is a move towards being more cloud & container friendly, as the open JDK binaries can be distributed as part of a container.
What does this mean?
Open JDK binaries will be released every 6 months, while Oracle JDK binaries will be released every 3 years (LTS version).
Which JDK binaries will be adopted?
Large organizations take time to move between the versions; they cling on to the version until they can. Industry adoption for Java 6 was more than Java 7 and then Industry is gradually moving to Java 8. In my opinion, the LTS version will be the most favored ones by the enterprises. However, whether it would be the LTS version of Oracle JDK or the Open JDK is yet to know, partly because there’s a lot going on the cloud space.
Java 9 & 10 are non-LTS release. Java 11 which is due in September 2018 will be a LTS release.
Java 10 Features
Let’s take a sneak peek of the features available in Java 10.
1.	Time-Based Release Versioning (JEP 322)
With the adoption of the time-based release cycle, Oracle changed the version-string scheme of the Java SE Platform and the JDK, and related versioning information, for present and future time-based release models.
The new pattern of the Version number is:
$FEATURE.$INTERIM.$UPDATE.$PATCH
$FEATURE: counter will be incremented every 6 months and will be based on feature release versions, e.g: JDK 10, JDK 11.
$INTERIM: counter will be incremented for non-feature releases that contain compatible bug fixes and enhancements but no incompatible changes. Usually, this will be zero, as there will be no interim release in a six month period. This kept for a future revision to the release model.
$UPDATE: counter will be incremented for compatible update releases that fix security issues, regressions, and bugs in newer features. This is updated one month after the feature release and every 3 months thereafter. The April 2018 release is JDK 10.0.1, the July release is JDK 10.0.2, and so forth
$PATCH: counter will be incremented for an emergency release to fix a critical issue.
New API’s have been added to get these counter values programmatically. Let’s take a look;

Version version = Runtime.version();
version.feature();
version.interim();
version.update();
version.patch();
Now, let us take a look at Java launcher which returns the version information:

$ java -version
java version "10" 2018-03-20
Java(TM) SE Runtime Environment 18.3 (build 10+46)
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10+46, mixed mode)
The version number format is “10” as there’s no other counter which is other than zero. The date of release is added. 18.3 can be read as the Year 2018 & 3rd Month, build 10+46 is 46th build for version 10. For a hypothetical build 93 of JDK 10.0.1, the build will be 10.0.1+93
2.	Local-Variable Type Inference (JEP 286)
Local-Variable Type Inference is the biggest new feature in Java 10 for developers. It adds type inference to declarations of local variables with initializers. Local type inference can be used only in the following scenarios:
1.	Limited only to Local Variable with initializer
2.	Indexes of enhanced for loop or indexes
3.	Local declared in for loop
Let’s take a look at its usage:

var numbers = List.of(1, 2, 3, 4, 5); // inferred value ArrayList<String>
// Index of Enhanced For Loop
for (var number : numbers) {
	System.out.println(number);
}
// Local variable declared in a loop
for (var i = 0; i < numbers.size(); i++) {
	System.out.println(numbers.get(i));
}
You can read more about it at our exclusive post on java 10 local variable type inference.
3.	Experimental Java-Based JIT Compiler (JEP 317)
This feature enables the Java-based JIT compiler, Graal, to be used as an experimental JIT compiler on the Linux/x64 platform. This is by far the most futuristic inclusion in the Java 10 feature list.
Graal was introduced in Java 9. It’s an alternative to the JIT compiler which we have been used to. It’s a plugin to the JVM, which means that the JIT compiler is not tied to JVM and it can be dynamically plugged in and replaced with any another plugin which JVMCI compliant (Java-Level JVM Compiler Interface). It also brings Ahead of Time (AOT) compilation in java world. It also supports polyglot language interpretation.
“A Java-based Just in Time Compiler written in Java to convert the java bytecode to machine code.” Is it confusing? If JVM is written in Java, then don’t you need a JVM to run the JVM? The JVM can be compiled AOT and then JIT compiler can be used within JVM it for enhancing performance through live code optimization.
Graal is a complete rewrite of the JIT compiler in Java from scratch. Previous JIT compiler was written in c++. It’s considered one for the final stage of evolution for any programming language.
You can switch to Graal with following jvm parameters:

-XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler
You can learn more about Graal from Chris Seaton presentation.
4.	Application Class-Data Sharing (JEP 310)
This feature helps in improving the startup footprint, extends the existing Class-Data Sharing (“CDS”) feature to allow application classes to be placed in the shared archive.
JVM while starting performs some preliminary steps, one of which is loading classes in memory. If there are several jars having multiple classes, then the lag in the first request is clearly visible. This becomes an issue with serverless architecture, where the boot time is critical. In order to bring down application startup time, Application class-data sharing can be used. The idea is to reduce footprint by sharing common class metadata across different Java processes. This can be achieved by the following 3 steps:
Determining the classes to archive: Use the java launcher to create a list of files to archive, this can be achieved by the following parameters:

$java -Xshare:off -XX:+UseAppCDS -XX:DumpLoadedClassList=hello.lst -cp hello.jar HelloWorld
Creating the AppCDS archive: Use java launcher to create the archive of the list of files to be used for Application CDS, this can be achieved by following parameters:

$java -Xshare:dump -XX:+UseAppCDS -XX:SharedClassListFile=hello.lst -XX:SharedArchiveFile=hello.jsa -cp hello.jar
Using the AppCDS archive: Use Java launcher with the following parameters to use Application CDS.

$java -Xshare:on -XX:+UseAppCDS -XX:SharedArchiveFile=hello.jsa -cp hello.jar HelloWorld
5.	Parallel Full GC for G1 (JEP 307)
G1 garbage collector was made default in JDK 9. G1 Garbage collector avoids any full garbage collection, but when concurrent threads for collection cannot revive the memory fast enough users experience is impacted.
This change improves the G1 worst-case latency by making the full GC parallel. The mark-sweep-compact algorithm from G1 collector is parallelized as part of this change and will be triggered when concurrent threads for collection can’t revive the memory fast enough.
6.	Garbage-Collector Interface (JEP 304)
This JEP is futuristic change. It improves the code isolation of different garbage collectors by introducing a common Garbage Collector Interface.
This change provides better modularity to the Internal GC Code. It will help in the future for adding new GC without changing existing codebase, also help in removing or housekeeping of the previous GC.
7.	Additional Unicode Language-Tag Extensions (JEP 314)
This feature enhances java.util.Locale and related APIs to implement additional Unicode extensions of BCP 47 language tags. As of Java SE 9, the supported BCP 47 U language-tag extensions are “ca” and “nu”. This JEP will add support for the following additional extensions:
0.	cu (currency type)
1.	fw (first day of week)
2.	rg (region override)
3.	tz (time zone)
In order to support these additional extensions, changes are made to various APIs to provide information based on U or additional extensions.

java.text.DateFormat::get*Instance
java.text.DateFormatSymbols::getInstance
java.text.DecimalFormatSymbols::getInstance
java.text.NumberFormat::get*Instance
java.time.format.DateTimeFormatter::localizedBy
java.time.format.DateTimeFormatterBuilder::getLocalizedDateTimePattern
java.time.format.DecimalStyle::of
java.time.temporal.WeekFields::of
java.util.Calendar::{getFirstDayOfWeek,getMinimalDaysInWeek}
java.util.Currency::getInstance
java.util.Locale::getDisplayName
java.util.spi.LocaleNameProvider
8.	Root Certificates (JEP 319)
In order to promote OpenJDK and make it more appealing to community users, this feature provides a default set of root Certification Authority (CA) certificates in the JDK. This will also mean that both Oracle & Open JDK binaries will be functionally the same.
Critical security components such as TLS will work by default in OpenJDK builds going forward.
9.	Thread-Local Handshakes (JEP 312)
This is an internal JVM feature to improve performance.
A handshake operation is a callback that is executed for each JavaThread while that thread is in a safepoint state. The callback is executed either by the thread itself or by the VM thread while keeping the thread in a blocked state.
This feature provides a way to execute a callback on threads without performing a global VM safepoint. Make it both possible and cheap to stop individual threads and not just all threads or none.
10.	Heap Allocation on Alternative Memory Devices (JEP 316)
Applications have become memory hungry, there’s an increase in cloud-native applications, in-memory databases, streaming applications. In order to cater to these services, there are various memory architectures available. This feature enhances the capability of HotSpot VM to allocate the Java object heap on an alternative memory device, such as an NV-DIMM, specified by the user.
This JEP targets alternative memory devices that have the same semantics as DRAM, including the semantics of atomic operations, and can, therefore, be used instead of DRAM for the object heap without any change to existing application code.
11.	Remove the Native-Header Generation Tool – javah (JEP 313)
This is a housekeeping change to remove javah tool from JDK. The tool functionality is added in javac as part of JDK 8, which provides ability to write native header files at the compile-time rendering javah useless.
12.	Consolidate the JDK Forest into a Single Repository (JEP 296)
Over the years there have been various Mercurial repositories in for JDK codebase. Different repositories do provide some advantage, but they also had various operational downsides. As part of this change, numerous repositories of the JDK forest are combined into a single repository in order to simplify and streamline development.
13.	API Changes
Java 10 has added and removed (Yes It’s not a Typo) API’s.
Java 9 introduced enhanced deprecation where certain API’s were marked to be removed in future releases.
API’s Removed: You can find the API’s removed here.
API’s Added: 73 new API’s was added in Java 10. You can find the API’s added along with comparison here.
Let’s go through a few additions:
0.	List, Map & Set Interfaces are added with a static copyOf(Collection) method. Its returns an unmodifiable List, Map or Set containing the entries provided. For a List, if the given List is subsequently modified, the returned List will not reflect such modifications.
1.	Optional & its primitive variations get a method orElseThrow(). This is exactly same as get(), however the java doc states that it is a preferred alternative then get()
2.	Collectors class gets various methods for collecting unmodifiable collections (Set, List, Map)

List<String> actors = new ArrayList<>();
actors.add("Jack Nicholson");
actors.add("Marlon Brando");
System.out.println(actors); // prints [Jack Nicholson, Marlon Brando]
// New API added - Creates an UnModifiable List from a List.
List<String> copyOfActors = List.copyOf(actors);
System.out.println(copyOfActors); // prints [Jack Nicholson, Marlon Brando]
// copyOfActors.add("Robert De Niro"); Will generate an
// UnsupportedOperationException
actors.add("Robert De Niro");
System.out.println(actors);// prints [Jack Nicholson, Marlon Brando, Robert De Niro]
System.out.println(copyOfActors); // prints [Jack Nicholson, Marlon Brando]
		
String str = "";
Optional<String> name = Optional.ofNullable(str);
// New API added - is preferred option then get() method
name.orElseThrow(); // same as name.get()  

// New API added - Collectors.toUnmodifiableList
List<String> collect = actors.stream().collect(Collectors.toUnmodifiableList());
// collect.add("Tom Hanks"); // Will generate an
// UnsupportedOperationException

Why is Java 11 important?
Java 11 is the second LTS release after Java 8. Since Java 11, Oracle JDK would no longer be free for commercial use.
You can use it in developing stages but to use it commercially, you need to buy a license. If you don’t, you can get an invoice bill from Oracle any day!
Java 10 was the last free Oracle JDK that could be downloaded.
Oracle stops Java 8 support from January 2019. You’ll need to pay for more support.
You can continue using it, but won’t get any patches/security updates.
Oracle will not be providing free long-term support (LTS) for any single Java version since Java 11.
While Oracle JDK is no longer free, you can always download the Open JDK builds from Oracle or other providers such as AdoptOpenJDK, Azul, IBM, Red Hat, etc. In my opinion, unless you are looking for Enterprise level usage with the appetite to pay for the support fees, you can use OpenJDK and upgrade them as and when necessary.
2. Which JDK build should I download and what are the benefits of each of them?
Since Oracle has created a release train in which a new version would come up every six months, if you are using the free Open JDK by Oracle, you will need to update it every six months, since Oracle won’t provide free updates once the new version is released. This can be challenging to adapt to a company.
Pay for commercial support to Oracle and migrate only from one LTS version to the next LTS version.
This way you’ll get all the updates and support for Java 11 till 2026. You can download Java 17 in 2022.
Stay on free Java version even after its support ends. Though you won’t get security updates and it can open up security loopholes.
Oracle won’t provide commercial support or updates for Java 9 and Java 10. You need to look for other alternative builds in order to keep using them for free.
Having understood the baggage Java 11 comes with, lets now analyze the important features in Java 11 for developers. We’ll discuss some important JEPs too.
Note: JavaFX will be available as a separate module and not tied to Java JDK’s 6-month release cycle schedule.
3. How to download Java 11 Free Version?
You can download production ready OpenJDK version from this link. The binaries are in tar or zip format, so just unzip them and set the environment variables to use java compiler and java commands.
4. Java 11 Features
Some of the important Java 11 features are:
•	Running Java File with single command
•	New utility methods in String class
•	Local-Variable Syntax for Lambda Parameters
•	Nested Based Access Control
•	JEP 321: HTTP Client
•	Reading/Writing Strings to and from the Files
•	JEP 328: Flight Recorder
Let’s discuss the new features introduced with Java 11 from the JEP Process.
4.1) Running Java File with single command
One major change is that you don’t need to compile the java source file with javac tool first. You can directly run the file with java command and it implicitly compiles.
This feature comes under JEP 330.
Following is a sneak peek at the new methods of Java String class introduced in Java 11:
4.2) Java String Methods
isBlank() – This instance method returns a boolean value. Empty Strings and Strings with only white spaces are treated as blank.
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        System.out.println(" ".isBlank()); //true
        
        String s = "Anupam";
        System.out.println(s.isBlank()); //false
        String s1 = "";
        System.out.println(s1.isBlank()); //true
    }
}

lines()
This method returns a stream of strings, which is a collection of all substrings split by lines.
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        
        String str = "JD\nJD\nJD"; 
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));
    }
}
The output of the above code is:
 
strip(), stripLeading(), stripTrailing()
strip() – Removes the white space from both, beginning and the end of string.
But we already have trim(). Then what’s the need of strip()?
strip() is “Unicode-aware” evolution of trim().
When trim() was introduced, Unicode wasn’t evolved. Now, the new strip() removes all kinds of whitespaces leading and trailing(check the method Character.isWhitespace(c) to know if a unicode is whitespace or not)
An example using the above three methods is given below:
public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        String str = " JD "; 
        System.out.print("Start");
        System.out.print(str.strip());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(str.stripLeading());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(str.stripTrailing());
        System.out.println("End");
    }
}
The output in the console from the above code is:
 
repeat(int)
The repeat method simply repeats the string that many numbers of times as mentioned in the method in the form of an int.
public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        String str = "=".repeat(2);
        System.out.println(str); //prints ==
    }
}
4.3) Local-Variable Syntax for Lambda Parameters
JEP 323, Local-Variable Syntax for Lambda Parameters is the only language feature release in Java 11.
In Java 10, Local Variable Type Inference was introduced. Thus we could infer the type of the variable from the RHS – var list = new ArrayList<String>();
JEP 323 allows var to be used to declare the formal parameters of an implicitly typed lambda expression.
We can now define :
(var s1, var s2) -> s1 + s2
This was possible in Java 8 too but got removed in Java 10. Now it’s back in Java 11 to keep things uniform.
But why is this needed when we can just skip the type in the lambda?
If you need to apply an annotation just as @Nullable, you cannot do that without defining the type.
Limitation of this feature – You must specify the type var on all parameters or none.
Things like the following are not possible:
(var s1, s2) -> s1 + s2 //no skipping allowed
(var s1, String y) -> s1 + y //no mixing allowed

var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
4.4) Nested Based Access Control
Before Java 11 this was possible:
public class Main {
 
    public void myPublic() {
    }
 
    private void myPrivate() {
    }
 
    class Nested {
 
        public void nestedPublic() {
            myPrivate();
        }
    }
}
private method of the main class is accessible from the above-nested class in the above manner.
But if we use Java Reflection, it will give an IllegalStateException.
Method method = ob.getClass().getDeclaredMethod("myPrivate");
method.invoke(ob);
Java 11 nested access control addresses this concern in reflection.
java.lang.Class introduces three methods in the reflection API: getNestHost(), getNestMembers(), and isNestmateOf().
4.5) JEP 309: Dynamic Class-File Constants
The Java class-file format now extends support a new constant pool form, CONSTANT_Dynamic. The goal of this JEP is to reduce the cost and disruption of developing new forms of materializable class-file constraints, by creating a single new constant-pool form that can be parameterized with user-provided behavior.
This enhances performance
4.6) JEP 318: Epsilon: A No-Op Garbage Collector
Unlike the JVM GC which is responsible for allocating memory and releasing it, Epsilon only allocates memory.
It allocates memory for the following things:
•	Performance testing.
•	Memory pressure testing.
•	VM interface testing.
•	Extremely short lived jobs.
•	Last-drop latency improvements.
•	Last-drop throughput improvements.
Now Elipson is good only for test environments. It will lead to OutOfMemoryError in production and crash the applications.
The benefit of Elipson is no memory clearance overhead. Hence it’ll give an accurate test result of performance and we can no longer GC for stopping it.
Note: This is an experimental feature.
4.7) JEP 320: Remove the Java EE and CORBA Modules
The modules were already deprecated in Java 9. They are now completely removed.
Following packages are removed: java.xml.ws, java.xml.bind, java.activation, java.xml.ws.annotation, java.corba, java.transaction, java.se.ee, jdk.xml.ws, jdk.xml.bind
4.8) JEP 328: Flight Recorder
Flight Recorder which earlier used to be a commercial add-on in Oracle JDK is now open-sourced since Oracle JDK is itself not free anymore.
JFR is a profiling tool used to gather diagnostics and profiling data from a running Java application.
Its performance overhead is negligible and that’s usually below 1%. Hence it can be used in production applications.
4.9) JEP 321: HTTP Client
Java 11 standardizes the Http CLient API.
The new API supports both HTTP/1.1 and HTTP/2. It is designed to improve the overall performance of sending requests by a client and receiving responses from the server. It also natively supports WebSockets.
4.10) Reading/Writing Strings to and from the Files
Java 11 strives to make reading and writing of String convenient.
It has introduced the following methods for reading and writing to/from the files:
•	readString()
•	writeString()
Following code showcases an example of this
Path path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on JD");
System.out.println(path);
String s = Files.readString(path);
System.out.println(s); //This was posted on JD
4.11) JEP 329: ChaCha20 and Poly1305 Cryptographic Algorithms
Java 11 provides ChaCha20 and ChaCha20-Poly1305 cipher implementations. These algorithms will be implemented in the SunJCE provider.
4.12) JEP 315: Improve Aarch64 Intrinsics
Improve the existing string and array intrinsics, and implement new intrinsics for the java.lang.Math sin, cos, and log functions, on AArch64 processors.
4.13) JEP 333: ZGC: A Scalable Low-Latency Garbage Collector (Experimental)
Java 11 has introduced a low latency GC. This is an experimental feature.
It’s good to see that Oracle is giving importance to GC’s.
4.14) JEP 335: Deprecate the Nashorn JavaScript Engine
Nashorn JavaScript script engine and APIs are deprecated thereby indicating that they will be removed in the subsequent releases.

Java 12 Features
Some of the important Java 12 features are;
1.	JVM Changes – JEP 189, JEP 346, JEP 344, and JEP 230.
2.	Switch Expressions
3.	File mismatch() Method
4.	Compact Number Formatting
5.	Teeing Collectors in Stream API
6.	Java Strings New Methods – indent(), transform(), describeConstable(), and resolveConstantDesc().
7.	JEP 334: JVM Constants API
8.	JEP 305: Pattern Matching for instanceof
9.	Raw String Literals is Removed From JDK 12.
Let’s look into all these Java 12 features one by one.
JVM Changes
1. JEP 189 – Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)
RedHat initiated Shenandoah Garbage Collector to reduce GC pause times. The idea is to run GC concurrently with the running Java threads.
It aims at consistent and predictable short pauses irrelevant of the heap size. So it does not matter if the heap size is 15 MB or 15GB.
It is an experimental feature in Java 12.
2. JEP 346 – Promptly Return Unused Committed Memory from G1
Stating Java 12, G1 will now check Java Heap memory during inactivity of application and return it to the operating system. This is a preemptive measure to conserve and use free memory.
3. JEP 344 : Abortable Mixed Collections for G1
Improvements in G1 efficiency include making G1 mixed collections abortable if they might exceed the defined pause target. This is done by splitting the mixed collection set into mandatory and optional.
Thus the G1 collector can prioritize on collecting the mandatory set first to meet the pause time goal.
4. JEP 230 and 344
Microbenchmark Suite, JEP 230 feature adds a basic suite of microbenchmarks to the JDK source code. This makes it easy for developers to run existing microbenchmarks and create new ones.
One AArch64 Port, Not Two, JEP 344, removes all of the sources related to the arm64 port while retaining the 32-bit ARM port and the 64-bit aarch64 port. This allows contributors to focus their efforts on a single 64-bit ARM implementation
5. JEP 341 Default CDS Archives
This enhances the JDK build process to generate a class data-sharing (CDS) archive, using the default class list, on 64-bit platforms. The goal is to improve startup time. From Java 12, CDS is by default ON.
To run your program with CDS turned off do the following:

java -Xshare:off HelloWorld.java
Now, this would delay the startup time of the program.
Language Changes And Features
Java 12 has introduced many language features. Let us look at a few with implementations.
1. Switch Expressions (Preview)
Java 12 has enhanced Switch expressions for Pattern matching.
Introduced in JEP 325, as a preview language feature, the new Syntax is L ->.
Following are some things to note about Switch Expressions:
•	The new Syntax removes the need for break statement to prevent fallthroughs.
•	Switch Expressions don’t fall through anymore.
•	Furthermore, we can define multiple constants in the same label.
•	default case is now compulsory in Switch Expressions.
•	break is used in Switch Expressions to return values from a case itself.
Classic switch statement:

String result = "";
        switch (day) {
            case "M":
            case "W":
            case "F": {
                result = "MWF";
                break;
            }
            case "T":
            case "TH":
            case "S": {
                result = "TTS";
                break;
            }
        };

        System.out.println("Old Switch Result:");
        System.out.println(result);
With the new Switch expression, we don’t need to set break everywhere thus prevent logic errors!

String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    break "Please insert a valid day.";
                else
                    break "Looks like a Sunday.";
            }

        };

        System.out.println(result);
Let’s run the below program containing the new Switch Expression using JDK 12.

public class SwitchExpressions {

    public static void main(String[] args)
    {
        System.out.println("New Switch Expression result:");
        executeNewSwitchExpression("M");
        executeNewSwitchExpression("TH");
        executeNewSwitchExpression("");
        executeNewSwitchExpression("SUN");
    }

    public static void executeNewSwitchExpression(String day){

        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    break "Please insert a valid day.";
                else
                    break "Looks like a Sunday.";
            }

        };

        System.out.println(result);
    }
}

Since this is a preview feature, please ensure that you have selected the Language Level as Java 12 preview.
To compile the above code run the following command:

javac -Xlint:preview --enable-preview -source 12 src/main/java/SwitchExpressions.java
After running the compiled program, we get the following in the console
 
Java Switch Expressions Program Output
Switch expressions is a preview language feature. This means that even though it is complete, it may not be confirmed in the future Java Release.
2. File.mismatch method
Java 12 added the following method to compare two files:

public static long mismatch(Path path, Path path2) throws IOException
This method returns the position of the first mismatch or -1L if there is no mismatch.
Two files can have a mismatch in the following scenarios:
•	If the bytes are not identical. In this case, the position of the first mismatching byte is returned.
•	File sizes are not identical. In this case, the size of the smaller file is returned.
Example code snippet from IntelliJ Idea is given below:

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMismatchExample {

    public static void main(String[] args) throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1,"JournalDev Test String");
        Files.writeString(filePath2,"JournalDev Test String");

        long mismatch = Files.mismatch(filePath1, filePath2);

        System.out.println("File Mismatch position... It returns -1 if there is no mismatch");

        System.out.println("Mismatch position in file1 and file2 is >>>>");
        System.out.println(mismatch);

        filePath1.toFile().deleteOnExit();
        filePath2.toFile().deleteOnExit();

        System.out.println();

        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3,"JournalDev Test String");
        Files.writeString(filePath4,"JournalDev.com Test String");

        long mismatch2 = Files.mismatch(filePath3, filePath4);

        System.out.println("Mismatch position in file3 and file4 is >>>>");
        System.out.println(mismatch2);

        filePath3.toFile().deleteOnExit();
        filePath4.toFile().deleteOnExit();



    }

}
The output when the above Java Program is compiled and run is:
 
Java File Mismatch Example Program Output
3. Compact Number Formatting

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatting {


    public static void main(String[] args)
    {
        System.out.println("Compact Formatting is:");
        NumberFormat upvotes = NumberFormat
                .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        upvotes.setMaximumFractionDigits(1);

        System.out.println(upvotes.format(2592) + " upvotes");


        NumberFormat upvotes2 = NumberFormat
                .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        upvotes2.setMaximumFractionDigits(2);
        System.out.println(upvotes2.format(2011) + " upvotes");
    }


}
 
Java Compact Number Formatting Program Output
4. Teeing Collectors
Teeing Collector is the new collector utility introduced in the Streams API.
This collector has three arguments – Two collectors and a Bi-function.
All input values are passed to each collector and the result is available in the Bi-function.

double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        summingDouble(i -> i),
                        counting(),
                        (sum, n) -> sum / n));

System.out.println(mean);
The output is 3.0.
5. Java Strings New Methods
4 new methods have been introduced in Java 12 which are:
•	indent(int n)
•	transform(Function f)
•	Optional describeConstable()
•	String resolveConstantDesc(MethodHandles.Lookup lookup)
To know about the above methods and there implementation in detail, refer to our Java 12 String Methods tutorial.
6. JEP 334: JVM Constants API
A new package java.lang.constant is introduced with this JEP. This is not that useful for those developers who don’t use constants pool.
7. JEP 305: Pattern Matching for instanceof (Preview)
Another Preview Language feature!
The old way to typecast a type to another type is:

if (obj instanceof String) {
    String s = (String) obj;
    // use s in your code from here
}
The new way is :

if (obj instanceof String s) {
    // can use s directly here
} 
This saves us some typecasting which were unnecessary.
Raw String Literals is Removed From JDK 12.

Java 13 Features
Some of the important Java 13 features are:
•	Text Blocks – JEP 355
•	New Methods in String Class for Text Blocks
•	Switch Expressions Enhancements – JEP 354
•	Reimplement the Legacy Socket API – JEP 353
•	Dynamic CDS Archive – JEP 350
•	ZGC: Uncommit Unused Memory – JEP 351
•	FileSystems.newFileSystem() Method
•	Support for Unicode 12.1
•	DOM and SAX Factories with Namespace Support
How to Enable Preview Features
Switch expressions and text blocks are preview features. So you will have to enable the preview-feature settings in your project.
If you are running a java program from the command line, you can enable it using the --enable-preview switch. You can use this switch to start JShell with preview features enabled.
$ jshell --enable-preview

$ java --enable-preview --source 13 Test.java
If you are using Eclipse IDE, you can enable the preview features from the project Java Compiler settings.
 
Eclipse Enable Preview Features
1. Text Blocks – JEP 355
This is a preview feature. It allows us to create multiline strings easily. The multiline string has to be written inside a pair of triple-double quotes.
The string object created using text blocks has no additional properties. It’s an easier way to create multiline strings. We can’t use text blocks to create a single-line string.
The opening triple-double quotes must be followed by a line terminator.
package com.journaldev.java13.examples;

public class TextBlockString {

	/**
	 * JEP 355: Preview Feature
	 */
	@SuppressWarnings("preview")
	public static void main(String[] args) {
		String textBlock = """
				Hi
				Hello
				Yes""";

		String str = "Hi\nHello\nYes";

		System.out.println("Text Block String:\n" + textBlock);
		System.out.println("Normal String Literal:\n" + str);

		System.out.println("Text Block and String Literal equals() Comparison: " + (textBlock.equals(str)));
		System.out.println("Text Block and String Literal == Comparison: " + (textBlock == str));
	}

}
Output:
Text Block String:
Hi
Hello
Yes
Normal String Literal:
Hi
Hello
Yes
Text Block and String Literal equals() Comparison: true
Text Block and String Literal == Comparison: true
It’s useful in easily creating HTML and JSON strings in our Java program.
String textBlockHTML = """
		<html>
		<head>
			<link href='/css/style.css' rel='stylesheet' />
		</head>
		<body>
                        <h1>Hello World</h1>
                </body>
                </html>""";

String textBlockJSON = """
		{
			"name":"Pankaj",
			"website":"JournalDev"
		}""";
2. New Methods in String Class for Text Blocks
There are three new methods in the String class, associated with the text blocks feature.
1.	formatted(Object… args): it’s similar to the String format() method. It’s added to support formatting with the text blocks.
2.	stripIndent(): used to remove the incidental white space characters from the beginning and end of every line in the text block. This method is used by the text blocks and it preserves the relative indentation of the content.
3.	translateEscapes(): returns a string whose value is this string, with escape sequences translated as if in a string literal.
package com.journaldev.java13.examples;

public class StringNewMethods {

	/***
	 * New methods are to be used with Text Block Strings
	 * @param args
	 */
	@SuppressWarnings("preview")
	public static void main(String[] args) {
		
		String output = """
			    Name: %s
			    Phone: %d
			    Salary: $%.2f
			    """.formatted("Pankaj", 123456789, 2000.5555);
		
		System.out.println(output);
		
		
		String htmlTextBlock = "<html>   \n"+
				                    "\t<body>\t\t \n"+
				                        "\t\t<p>Hello</p>  \t \n"+
				                    "\t</body> \n"+
				                "</html>";
		System.out.println(htmlTextBlock.replace(" ", "*"));
		System.out.println(htmlTextBlock.stripIndent().replace(" ", "*"));
		
		String str1 = "Hi\t\nHello' \" /u0022 Pankaj\r";
		System.out.println(str1);
		System.out.println(str1.translateEscapes());
		
	}

}
Output:
Name: Pankaj
Phone: 123456789
Salary: $2000.56

<html>***
	<body>		*
		<p>Hello</p>**	*
	</body>*
</html>
<html>
	<body>
		<p>Hello</p>
	</body>
</html>
Hi	
Hello' " /u0022 Pankaj
Hi	
Hello' " /u0022 Pankaj
3. Switch Expressions Enhancements – JEP 354
Switch expressions were added as a preview feature in Java 12 release. It’s almost same in Java 13 except that the “break” has been replaced with “yield” to return a value from the case statement.
package com.journaldev.java13.examples;

/**
 * JEP 354: Switch Expressions
 * https://openjdk.java.net/jeps/354
 * @author pankaj
 *
 */
public class SwitchEnhancements {

	@SuppressWarnings("preview")
	public static void main(String[] args) {
		int choice = 2;

		switch (choice) {
		case 1:
			System.out.println(choice);
			break;
		case 2:
			System.out.println(choice);
			break;
		case 3:
			System.out.println(choice);
			break;
		default:
			System.out.println("integer is greater than 3");
		}

		// from java 13 onwards - multi-label case statements
		switch (choice) {
		case 1, 2, 3:
			System.out.println(choice);
			break;
		default:
			System.out.println("integer is greater than 3");
		}

		// switch expressions, use yield to return, in Java 12 it was break
		int x = switch (choice) {
		case 1, 2, 3:
			yield choice;
		default:
			yield -1;
		};
		System.out.println("x = " + x);

	}

	enum Day {
		SUN, MON, TUE
	};

	@SuppressWarnings("preview")
	public String getDay(Day d) {
		String day = switch (d) {
		case SUN -> "Sunday";
		case MON -> "Monday";
		case TUE -> "Tuesday";
		};
		return day;
	}
}
4. Reimplement the Legacy Socket API – JEP 353
The underlying implementation of the java.net.Socket and java.net.ServerSocket APIs have been rewritten. The new implementation, NioSocketImpl, is a drop-in replacement for PlainSocketImpl.
It uses java.util.concurrent locks rather than synchronized methods. If you want to use the legacy implementation, use the java option -Djdk.net.usePlainSocketImpl.
5. Dynamic CDS Archive – JEP 350
This JEP extends the class-data sharing feature, which was introduced in Java 10. Now, the creation of CDS archive and using it is much easier.
$ java -XX:ArchiveClassesAtExit=my_app_cds.jsa -cp my_app.jar

$ java -XX:SharedArchiveFile=my_app_cds.jsa -cp my_app.jar
6. ZGC: Uncommit Unused Memory – JEP 351
This JEP has enhanced ZGC to return unused heap memory to the operating system. The Z Garbage Collector was introduced in Java 11. It adds a short pause time before the heap memory cleanup. But, the unused memory was not being returned to the operating system. This was a concern for devices with small memory footprint such as IoT and microchips. Now, it has been enhanced to return the unused memory to the operating system.
7. FileSystems.newFileSystem() Method
Three new methods have been added to the FileSystems class to make it easier to use file system providers, which treats the contents of a file as a file system.
1.	newFileSystem(Path)
2.	newFileSystem(Path, Map<String, ?>)
3.	newFileSystem(Path, Map<String, ?>, ClassLoader)
8. DOM and SAX Factories with Namespace Support
There are new methods to instantiate DOM and SAX factories with Namespace support.
1.	newDefaultNSInstance()
2.	newNSInstance()
3.	newNSInstance(String factoryClassName, ClassLoader classLoader)
//java 13 onwards
DocumentBuilder db = DocumentBuilderFactory.newDefaultNSInstance().newDocumentBuilder(); 

// before java 13
DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance(); 
dbf.setNamespaceAware(true); 
DocumentBuilder db = dbf.newDocumentBuilder();

Java 14 Features
Here’s the list of Java 14 features:
•	Switch Expressions (Standard) – JEP 361
•	Pattern Matching for instanceof (Preview) – JEP 305
•	Helpful NullPointerExceptions – JEP 358
•	Records (Preview) – JEP 359
•	Text Blocks (Second Preview) – JEP 368
•	Packaging Tool (Incubator) – JEP 343
•	NUMA-Aware Memory Allocation for G1 – JEP 345
•	JFR Event Streaming – JEP 349
•	Non-Volatile Mapped Byte Buffers – JEP 352
•	ZGC on macOS – JEP 364
•	ZGC on Windows – JEP 365
•	Foreign-Memory Access API (Incubator) – JEP 370
Java 14 Installation Setup on Mac OS
•	To get started with Java 14, download the JDK from here.
•	Copy and extract the tar file in the /Library/Java/JavaVirtualMachines as shown below:

$ cd /Library/Java/JavaVirtualMachines
 
$ sudo cp ~/Downloads/openjdk-14_osx-x64_bin.tar.gz /Library/Java/JavaVirtualMachines
 
$ sudo tar xzf openjdk-14_osx-x64_bin.tar.gz
 
$ sudo rm openjdk-14_osx-x64_bin.tar.gz
Once that’s done, open the bash_profile using any text editor. I’m using vim ~/.bash_profile. Set the path of Java14 to JAVA_HOME, save changes and do a source ~/.bash_profile to reflect the changes.
1	export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-14.jdk/Contents/Home
Finally, you’re ready to compile and run programs using Java 14. We’ll be using JShell, an interactive REPL command-line tool for quickly testing the new Java 14 features.
It’s important to note that many features released in Java 14 are in preview. This means that though they’re fully working right now, things may be modified in the future. Some could be made a standard or simply removed in the next release cycles. In order to test preview features, you need to explicitly set --enable-preview when running the JShell or Java Program as shown below:

jshell --enable-preview
 
javac --release 14 --enable-preview Author.java
In the next few sections, let’s discuss some of the language and JVM features.
1. Switch Expressions
Switch Expressions after staying a preview feature in the last two releases –Java 12 and Java 13 have finally attained permanent status in Java 14.
•	Java 12 introduced the lambda syntax for switch expressions thereby allowing multiple case labels for pattern matching as well as preventing fall-throughs which lead to verbose code. It also enforced exhaustive cases wherein a compilation error would be thrown if all the input cases aren’t covered.
•	Java 13, the second preview introduced yield statements instead of break for returning values from an expression.
Java 14 has finally made these features a standard now.

String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }
 
        };
System.out.println(result);
 Java 14 Switch Expressions
Note: Yield isn’t a new keyword in Java. It’s just used in switch expressions.
2. Pattern Matching for instanceof (Preview)
Ask any Java developer to show their codebase and you’ll a good use of instanceof conditions throughout the code. Specifically, an instanceof conditional check is generally followed by a typecasting.
Java 14, gets rid of this verbosity by making conditional extraction a lot more concise.
Before Java 14:

if (obj instanceof Journaldev) {
  Journaldev jd = (Journaldev) obj;
  System.out.println(jd.getAuthor());
}
Java 14 Onwards:

if (obj instanceof Journaldev jd) {
  System.out.println(jd.getAuthor());
}
In the above code, the instance jd would be only assigned if obj is of type Journaldev. The scope of the variable is limited to the conditional block only.
3. Helpful NullPointerExceptions
Null Pointer Exceptions are a nightmare for any developer. Previously, until Java 13, it was tricky to debug the infamous NPEs. Developers had to fall onto other debugging tools or manually figure the variable/method that was null since the stack trace would only show the line number.
Before Java 14:

String name = jd.getBlog().getAuthor()
 
//Stacktrace
Exception in thread "main" <a href="https://www.journaldev.com/14544/java-lang-nullpointerexception">java.lang.NullPointerException</a>
    at NullPointerExample.main(NullPointerExample.java:5)
Java 14 introduced a new JVM feature which gives better insights with a more descriptive stack as shown below:
1
2	Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Blog.getAuthor()" because the return value of "Journaldev.getBlog()" is null
    at NullPointerExample.main(NullPointerExample.java:4)
Note: The above feature is not a language feature. It’s an enhancement in the runtime environment.
4. Records (Preview)
A record is a data class that stores pure data. The idea behind introducing records is to quickly create simple and concise classes devoid of boilerplate code.
Normally a class in Java would require you to implement equals(), hashCode() , the getters and setters methods. While some IDEs support auto-generation of such classes, the code is still verbose. With a record you need to simply define a class in the following way.
1
2
3	record Author(){}
//or
record Author (String name, String topic) {}
The Java compiler will generate a constructor, private final fields, accessors, equals/hashCode and toString methods automatically. The auto-generated getter methods of the above class are name() and topic().
To look into the generated code, use javap Author after you’ve compiled the program using javac. The following illustration shows the generated class for record Author (String name, String topic) {}:
 Javap Records Java 14
The semantics of Records is similar to Data Classes in Kotlin
Furthermore, we can add additional fields, methods, and constructor to the record in the following way:

record Author (int id, String name, String topic) {
    static int followers;
 
    public static String followerCount() {
        return "Followers are "+ followers;
    }
 
    public String description(){
        return "Author "+ name + " writes on "+ topic;
    }
 
    public Author{
    if (id < 0) {
        throw new IllegalArgumentException( "id must be greater than 0.");
     }
   }
}
The additional constructor defined inside the record is called a Compact constructor. It doesn’t consist of any parameters and is just an extension of the canonical constructor.
A compact constructor wouldn’t be generated as a separate constructor by the compiler. Instead, it is used for validation cases and would be invoked at the start of the main constructor.
Few important things to note about Records:
•	A record can neither extend a class nor it can be extended by another class. It’s a final class.
•	Records cannot be abstract
•	Records cannot extend any other class and cannot define instance fields inside the body. Instance fields must be defined in the state description only
•	Declared fields are private and final
•	The body of a record allows static fields and methods
4.1) Values Inside Reference Fields Of A Record Can Be Mutated
It’s important to note that for fields defined which are objects, only the reference is immutable. The underlying values can be modified. The following illustration shows a record in which the ArrayList is modified. As you can see, the value is modified whenever the ArrayList is changed.
 Java 14 Records Mutable Values For References
4.2) Records Can Implement Interfaces
The following code shows an example of implementing an interface with records:

record Author(String name, String topic) implements Information {
  public String getFullName() {
    return "Author "+ name + " writes on " + topic;
  }
}
 
interface Information {
  String getFullName();
}
Here’s the output of the above code in action in a JShell:
 Java 14 Records With Interface
4.3) Records support multiple constructors
Records allow declaring multiple constructors with or without parameters as shown below:

record Author(String name, String topic) {
  public Author() {
 
    this("NA", "NA");
  }
 
  public Author(String name) {
 
    this(name, "NA");
  }
}
4.4) Records Allow Modifying Accessor Methods
Though records do generate public accessor methods for the fields defined in the state description, they also allow you to redefine the accessor methods in the body as shown below:

record Author(String name, String topic) {
  public String name() {
        return "This article was written by " + this.name;
    }
}
4.5) Check Record and its Components at Runtime
Records provide us with isRecord() and getRecordComponents() to check if the class is a record and also look into its fields and types. The following illustration shows how it is done:
 Java 14 Records Runtime Check
While we did add additional fields and methods to the record in the above code examples, make sure you don’t overdo this. Records are designed as plain data carriers and if you’re looking to implement a lot of additional methods, it’s better to fall back onto the normal class.
5. Text Blocks (Preview)
Text Blocks were introduced as a preview feature in Java 13 with the goal to allow easy creation of multiline string literals. It’s useful in easily creating HTML and JSON or SQL query strings.
In Java 14, Text Blocks are still in preview with some new additions. We can now use:
•	Backslash for displaying nice-looking multiline string blocks.
•	\s is used to consider trailing spaces which are by default ignored by the compiler. It preserves all the spaces present before it.

String text = """
                Did you know \
                Java 14 \
                has the most features among\
                all non-LTS versions so far\
                """;
 
String text2 = """
                line1
                line2 \s
                line3
                """;
 
 
String text3 = "line1\nline2 \nline3\n"
 
//text2 and text3 are equal.

