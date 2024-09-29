Java 8 Merge Two Maps With Same Keys
Problem :
Write a Java 8 program or function which merge two maps with same keys. Your program should take two maps (which may have same keys) as input and merge them into single map. The values of same keys must be result of an applied merging function like adding values or concatenating values or selecting smallest or largest value if two keys are found same.


How To Merge Two Maps With Same Keys In Java 8?
There are four different Java 8 methods you can use for this problem. They are,

Map.merge()
Stream.concat()
Stream.of() And flatMap()
Using Stream() Pipeline
Also Read : 60+ Java 8 Interview Questions And Answers

Java 8 Merge Two Maps With Same Keys
Let’s see these methods in detail.

1) Map.merge() :
merge() method is added to java.util.Map from Java 8 to facilitate merging of two maps. Map.merge() takes three arguments – key, value and remappingFunction which decides the value if two keys are found same.


The following program merges two subjectToStudentCount maps using Map.merge(). If any two keys are found same, their values are added.

import java.util.HashMap;
 
public class Java8MergeTwoMaps 
{
    public static void main(String[] args) 
    {
        //Map-1
         
        HashMap<String, Integer> subjectToStudentCountMap1 = new HashMap<>();
         
        subjectToStudentCountMap1.put("Maths", 45);
        subjectToStudentCountMap1.put("Physics", 57);
        subjectToStudentCountMap1.put("Chemistry", 52);
        subjectToStudentCountMap1.put("History", 41);
         
        //Map-2
         
        HashMap<String, Integer> subjectToStudentCountMap2 = new HashMap<>();
         
        subjectToStudentCountMap2.put("Economics", 49);
        subjectToStudentCountMap2.put("Maths", 42);
        subjectToStudentCountMap2.put("Biology", 41);
        subjectToStudentCountMap2.put("History", 55);
         
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, their values are added
         
        HashMap<String, Integer> subjectToStudentCountMap3 = new HashMap<>(subjectToStudentCountMap1);
         
        subjectToStudentCountMap2.forEach((key, value) -> subjectToStudentCountMap3.merge(key, value, (v1, v2) -> v1+v2));
         
        //Printing map1, map2 and map3
         
        System.out.println("Map 1 : "+subjectToStudentCountMap1);
         
        System.out.println("Map 2 : "+subjectToStudentCountMap2);
         
        System.out.println("Map 3 : "+subjectToStudentCountMap3);
    }
}
Output :

Map 1 : {Maths=45, Chemistry=52, History=41, Physics=57}
Map 2 : {Economics=49, Maths=42, Biology=41, History=55}
Map 3 : {Economics=49, Maths=87, Biology=41, Chemistry=52, History=96, Physics=57}

Also Read : 50+ Java Threads Interview Questions And Answers

2) Stream.concat() :
Another method you can use to merge two maps is Stream.concat(). Pass the two input maps to concat() after converting their entrySet to Stream (map.entrySet().stream()) and collect the result into new HashMap using Collectors.toMap() method which takes four arguments – keyMapper, valueMapper, mergeFunction which decides what to do when two keys are found same and mapSupplier to hold the merged map.

In the below example, two subjectToStudentCount maps are merged using Stream.concat() and if any two keys are found same, their largest value is selected.

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class Java8MergeTwoMaps 
{
    public static void main(String[] args) 
    {
        //Map-1
         
        HashMap<String, Integer> subjectToStudentCountMap1 = new HashMap<>();
         
        subjectToStudentCountMap1.put("Maths", 45);
        subjectToStudentCountMap1.put("Physics", 57);
        subjectToStudentCountMap1.put("Chemistry", 52);
        subjectToStudentCountMap1.put("History", 41);
         
        //Map-2
         
        HashMap<String, Integer> subjectToStudentCountMap2 = new HashMap<>();
         
        subjectToStudentCountMap2.put("Economics", 49);
        subjectToStudentCountMap2.put("Maths", 42);
        subjectToStudentCountMap2.put("Biology", 41);
        subjectToStudentCountMap2.put("History", 55);
         
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, largest value will be selected
         
        HashMap<String, Integer> subjectToStudentCountMap3 = 
                Stream.concat(subjectToStudentCountMap1.entrySet().stream(), subjectToStudentCountMap2.entrySet().stream())
                      .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1>v2 ? v1 : v2, HashMap::new));
         
        //Printing map1, map2 and map3
         
        System.out.println("Map 1 : "+subjectToStudentCountMap1);
         
        System.out.println("Map 2 : "+subjectToStudentCountMap2);
         
        System.out.println("Map 3 : "+subjectToStudentCountMap3);
    }
}
Output :

Map 1 : {Maths=45, Chemistry=52, History=41, Physics=57}
Map 2 : {Economics=49, Maths=42, Biology=41, History=55}
Map 3 : {Economics=49, Maths=45, Chemistry=52, Biology=41, History=55, Physics=57}

Also Read : 60+ Java Strings Quiz Questions

3) Stream.of() and flatMap() :
Other Java 8 methods which can also be used to merge two maps are Stream.of() and Stream.flatMap(). Pass the two input maps to Stream.of() and pass the combined stream to flatMap() method and collect the result into new HashMap using Collectors.toMap() which takes four arguments – keyMapper, valueMapper, mergeFunction and mapSupplier.


The following program merges two subjectToStudentCount maps using Stream.of() and if any two keys are found same, the values are added using method reference Integer::sum.

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class Java8MergeTwoMaps 
{
    public static void main(String[] args) 
    {
        //Map-1
         
        HashMap<String, Integer> subjectToStudentCountMap1 = new HashMap<>();
         
        subjectToStudentCountMap1.put("Maths", 45);
        subjectToStudentCountMap1.put("Physics", 57);
        subjectToStudentCountMap1.put("Chemistry", 52);
        subjectToStudentCountMap1.put("History", 41);
         
        //Map-2
         
        HashMap<String, Integer> subjectToStudentCountMap2 = new HashMap<>();
         
        subjectToStudentCountMap2.put("Economics", 49);
        subjectToStudentCountMap2.put("Maths", 42);
        subjectToStudentCountMap2.put("Biology", 41);
        subjectToStudentCountMap2.put("History", 55);
         
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, their values are added using method reference : Integer::sum
         
        HashMap<String, Integer> subjectToStudentCountMap3 = 
                Stream.of(subjectToStudentCountMap1, subjectToStudentCountMap2)
                      .flatMap(map -> map.entrySet().stream())
                      .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Integer::sum, HashMap::new));
         
        //Printing map1, map2 and map3
         
        System.out.println("Map 1 : "+subjectToStudentCountMap1);
         
        System.out.println("Map 2 : "+subjectToStudentCountMap2);
         
        System.out.println("Map 3 : "+subjectToStudentCountMap3);
    }
}
Output :

Map 1 : {Maths=45, Chemistry=52, History=41, Physics=57}
Map 2 : {Economics=49, Maths=42, Biology=41, History=55}
Map 3 : {Economics=49, Maths=87, Chemistry=52, Biology=41, History=96, Physics=57}

Also Read : 300+ Java Interview Questions And Answers

4) Using Stream() Pipeline :
The following program first converts entrySet of subjectToStudentCountMap2 to Stream using stream() and collect the result into new HashMap using Collectors.toMap() after passing four arguments – keyMapper, valueMapper, mergeFunction and mapSupplier which is already initialized with subjectToStudentCountMap1. If any two keys are same, smallest value is selected.

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
 
public class Java8MergeTwoMaps 
{
    public static void main(String[] args) 
    {
        //Map-1
         
        HashMap<String, Integer> subjectToStudentCountMap1 = new HashMap<>();
         
        subjectToStudentCountMap1.put("Maths", 45);
        subjectToStudentCountMap1.put("Physics", 57);
        subjectToStudentCountMap1.put("Chemistry", 52);
        subjectToStudentCountMap1.put("History", 41);
         
        //Map-2
         
        HashMap<String, Integer> subjectToStudentCountMap2 = new HashMap<>();
         
        subjectToStudentCountMap2.put("Economics", 49);
        subjectToStudentCountMap2.put("Maths", 42);
        subjectToStudentCountMap2.put("Biology", 41);
        subjectToStudentCountMap2.put("History", 55);
         
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, smallest value is selected
         
        HashMap<String, Integer> subjectToStudentCountMap3 = 
                subjectToStudentCountMap2.entrySet()
                                         .stream()
                                         .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1<v2 ? v1 : v2, () -> new HashMap<>(subjectToStudentCountMap1)));
         
        //Printing map1, map2 and map3
         
        System.out.println("Map 1 : "+subjectToStudentCountMap1);
         
        System.out.println("Map 2 : "+subjectToStudentCountMap2);
         
        System.out.println("Map 3 : "+subjectToStudentCountMap3);
    }
}
Output :

Map 1 : {Maths=45, Chemistry=52, History=41, Physics=57}
Map 2 : {Economics=49, Maths=42, Biology=41, History=55}
Map 3 : {Economics=49, Maths=42, Biology=41, Chemistry=52, History=41, Physics=57}
