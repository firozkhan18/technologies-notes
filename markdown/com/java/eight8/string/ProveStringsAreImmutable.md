# com\java\eight8\string\ProveStringsAreImmutable.java

```java
package com.java.eight8.string;

public class ProveStringsAreImmutable {

}
//One more interesting thing about String objects in java is that they are immutable. That means once you create a string object, you can’t modify the contents of that object. If you try to modify the contents of string object, a new string object is created with modified content.
//
//In this article, We will discuss the examples which prove that strings are immutable.
//
//
//An Example To Prove Strings Are Immutable :
//First, create one string object ‘s1’ using string literal “JAVA”.
//
//String s1 = "JAVA";
//Create one more string object ‘s2’ using the same string literal “JAVA”.
//
//String s2 = "JAVA";
//We have seen in the previous article that string objects created using string literal are stored in the String Constant Pool and any two objects in the pool can’t have same content. Here s1 and s2 are created using same literal. Therefore, they will be pointing to same object in the pool. Then s1 == s2 should return true.
//
//System.out.println(s1 == s2);       //Output : true
//Now, I want to make little modification to this object through ‘s1’ reference. I want to append “J2EE” at end of this string through ‘s1’. That can be done like below,
//
//s1 =s1 + "J2EE";
//This statement appends “J2EE” to the object to which s1 is pointing and re-assigns reference of that object back to s1.
//
//Now, compare physical address of s1 and s2 using “==” operator. This time it will return false.
//
//System.out.println(s1 == s2);       //Output : false
//That means now both s1 and s2 are pointing to two different objects in the pool. Before modifications they are pointing to same object. Once we tried to change the content of the object using ‘s1’, a new object is created in the pool with “JAVAJ2EE” as it’s content and it’s reference is assigned to s1. If the strings are mutable, both s1 and s2 should point to same object even after modification. That never happened here. That proves the string objects are immutable in java.
//
//The whole program can be written like this,

public class StringExamples
{
    public static void main(String[] args)
    {
        String s1 = "JAVA";
 
        String s2 = "JAVA";
 
        System.out.println(s1 == s2);         //Output : true
 
        s1 = s1 + "J2EE";
 
        System.out.println(s1 == s2);         //Output : false
    }
}
//This is how it looks like in the memory.
//strings are immutable
//
//is new String() also immutable?
//After seeing the above example, one more question may left in your mind. Are string objects created using new operator also immutable? The answer is Yes. String objects created using new operator are also immutable although they are stored in the heap memory. This can be also proved with help of an example.
//

public class StringExamples
{
    public static void main(String[] args)
    {
        String s1 = new String("JAVA");
 
        System.out.println(s1);         //Output : JAVA
 
        s1.concat("J2EE");
 
        System.out.println(s1);         //Output : JAVA
    }
}
//In this example, a string object is created with “JAVA” as it’s content using new operator and it’s reference is assigned to s1. I have tried to change the contents of this object using concat() method. But, these changes are not reflected in the object as seen in Line 11. Even after the concatenation, content of the object is same as before. This is because the strings are immutable. Once I tried to concatenate “J2EE” to an existing string “JAVA”, a new string object is created with “JAVAJ2EE” as it’s content. But we don’t have reference to that object in this program.
//
//Conclusion :
//Immutability is the fundamental property of string objects. In whatever way you create the string objects, either using string literals or using new operator, they are immutable.
```
