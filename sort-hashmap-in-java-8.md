# Java 8 Sort HashMap By Keys

HashMap, LinkedHashMap and TreeMap are three most popular Map types. LinkedHashMap maintains insertion order i.e elements are stored as they are inserted. TreeMap stores the elements according to supplied Comparator or in natural order if you don’t supply any Comparator. HashMap doesn’t guarantee any order. There are different methods to sort HashMap either by keys or values. In this post, we will see how to sort HashMap by keys using Java 8 comparingByKey() method.

Before moving on to Java 8 code, let’s see how to sort HashMap by keys using TreeMap.

### How To Sort HashMap By Keys Using TreeMap (Before Java 8)?
One of the easiest and traditional method of sorting HashMap is that inserting HashMap elements into TreeMap. It will sort the elements according to supplied Comparator or in natural order if no Comparator is supplied.

Sorting HashMap according to natural order of keys using TreeMap without Comparator :
```java
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class SortMapByKeysProgram
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap = new TreeMap<>(studentMap);
                 
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
Output :
Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Arunkumar=86, Jyous=87, Klusener=82, Lisa=89, Narayan=95, Xiangh=91}

### Sorting HashMap in natural reverse order of keys using TreeMap with Comparator :

The following program sorts HashMap in natural reverse order of keys by passing Collections.reverseOrder() to TreeMap.
```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class SortMapReverseOrderByKeysUsingTreeMap
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap = new TreeMap<>(Collections.reverseOrder());
                 
        sortedStudentMap.putAll(studentMap);
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
Output :

Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Xiangh=91, Narayan=95, Lisa=89, Klusener=82, Jyous=87, Arunkumar=86}

### Sorting HashMap by keys using TreeMap with customized Comparator :

In the below example, HashMap with strings as keys is sorted in increasing order of length of keys by passing customized Comparator to TreeMap.
```java
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeysUsingTreeMapCostomizedComparator {
	public static void main(String[] args) {
		Map<String, Integer> studentMap = new HashMap<String, Integer>();

		studentMap.put("Jyous", 87);
		studentMap.put("Klusener", 82);
		studentMap.put("Xiangh", 91);
		studentMap.put("Lisa", 89);
		studentMap.put("Narayan", 95);
		studentMap.put("Arunkumar", 86);

		Map<String, Integer> sortedStudentMap = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		sortedStudentMap.putAll(studentMap);

		System.out.println("Before Sorting : ");

		System.out.println(studentMap);

		System.out.println("After Sorting : ");

		System.out.println(sortedStudentMap);
	}
}
```
Output :

Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Lisa=89, Jyous=87, Xiangh=91, Narayan=95, Klusener=82, Arunkumar=86}

### To sort the same HashMap in decreasing order of length of keys, use either Collections.reverseOrder() or else return o2.length() - o1.length() instead of o1.length() - o2.length() as in the below program.
```java
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class SortMapByKeysProgram
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap = new TreeMap<>(new Comparator<String>() 
        {
            @Override
            public int compare(String o1, String o2) 
            {
                return o2.length() - o1.length();
            }
        });
                 
//      OR
         
//      Map<String, Integer> sortedStudentMap = new TreeMap<>(Collections.reverseOrder(new Comparator<String>() 
//      {
//          @Override
//          public int compare(String o1, String o2) 
//          {
//              return o1.length() - o2.length();
//          }
//      }));
         
        sortedStudentMap.putAll(studentMap);
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
Output :

Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Arunkumar=86, Klusener=82, Narayan=95, Xiangh=91, Jyous=87, Lisa=89}

### How To Sort HashMap By Keys Using Java 8 comparingByKey()?
From Java 8, two new methods are introduced into Map.Entry class to facilitate the sorting of Map objects by keys and by values. They are – comparingByKey() and comparingByValue(). In this post, we will just focus on comparingByKey() method.

Below image describes steps involved in sorting HashMap by keys using Java 8 comparingByKey()

Java 8 sort HashMap by keys in natural order :
```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
 
public class SortMapByKeysProgram
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap 
                    = studentMap.entrySet()
                                .stream()
                                .sorted(Entry.comparingByKey())
                                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
Output :

Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Arunkumar=86, Jyous=87, Klusener=82, Lisa=89, Narayan=95, Xiangh=91}


### Java 8 sorting HashMap in natural reverse order of keys :

To sort the same HashMap in the reverse order of keys, use either Collections.reverseOrder() or Java 8 Comparator.reverseOrder().
```java
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
 
public class SortMapByKeysProgram
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap 
                        = studentMap.entrySet()
                                    .stream()
                                    .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                                     
                                //  OR
                                // .sorted(Entry.comparingByKey(Comparator.reverseOrder()))
                                     
                                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
Output :

Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Xiangh=91, Narayan=95, Lisa=89, Klusener=82, Jyous=87, Arunkumar=86}

###Java 8 sort HashMap by keys using customized Comparator :

The below program uses Java 8 comparingByKey() method with customized Comparator to sort HashMap in increasing order of length of keys.
```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
 
public class SortMapByKeysProgram
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap 
                                = studentMap.entrySet()
                                            .stream()
                                            .sorted(Entry.comparingByKey((o1, o2) -> o1.length() - o2.length()))
                                            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
Output :

Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Lisa=89, Jyous=87, Xiangh=91, Narayan=95, Klusener=82, Arunkumar=86}

### To sort the same HashMap in decreasing order of length of keys, use either Collections.reverseOrder() or else return o2.length() - o1.length() instead of o1.length() - o2.length() as in the below program.
```java
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
 
public class SortMapByKeysProgram
{
    public static void main(String[] args) 
    {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
                 
        Map<String, Integer> sortedStudentMap 
                                = studentMap.entrySet()
                                            .stream()
                                            .sorted(Entry.comparingByKey((o1, o2) -> o2.length() - o1.length()))
                                                           
                                         //  OR
                                        //  .sorted(Collections.reverseOrder(Entry.comparingByKey((o1, o2) -> o1.length() - o2.length())))
                                             
                                            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
         
        System.out.println("Before Sorting : ");
         
        System.out.println(studentMap);
         
        System.out.println("After Sorting : ");
         
        System.out.println(sortedStudentMap);
    }
}
```
Output :

Before Sorting :
{Xiangh=91, Klusener=82, Narayan=95, Arunkumar=86, Jyous=87, Lisa=89}
After Sorting :
{Arunkumar=86, Klusener=82, Narayan=95, Xiangh=91, Jyous=87, Lisa=89}
