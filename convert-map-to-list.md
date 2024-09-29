HashMap and ArrayList are two most used data structures in java.

Both classes inherit from different hierarchies. 

HashMap is inherited from Map interface which represents the data in the form of key-value pairs. 

ArrayList is inherited from List interface which arranges the data in the sequential manner. 

Conversion of HashMap to ArrayList has also become a regular question in the java interviews as there is no direct methods in HashMap which converts the HashMap to ArrayList. 

In this document, we will see how to convert HashMap to ArrayList in java with examples. 

At the end, we will also see java 8 code to convert map to list in java.

## How To Convert HashMap To ArrayList In Java?

As HashMap contains key-value pairs, there are three ways you can convert given HashMap to ArrayList. 
You can convert HashMap keys into ArrayList or you can convert HashMap values into ArrayList or you can convert key-value pairs into ArrayList. Let’s see these three methods in detail.

### a) Conversion Of HashMap Keys Into ArrayList :

For this, we use keySet() method of HashMap which returns the Set containing all keys of the HashMap. And then we pass this Set while constructing the ArrayList.
```java
//Creating a HashMap object 
         
HashMap<String, String> map = new HashMap<String, String>();          
//Getting Set of keys from HashMap          
Set<String> keySet = map.keySet();          
//Creating an ArrayList of keys by passing the keySet 
         
ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
```
### b) Conversion Of HashMap Values Into ArrayList :

For this, we use values() method of HashMap which returns the Collection containing all values of the HashMap. 
Then we use this Collection to create the ArrayList of values.
```java
//Creating a HashMap object 
         
HashMap<String, String> map = new HashMap<String, String>();          
//Getting Collection of values from HashMap          
Collection<String> values = map.values();          
//Creating an ArrayList of values          
ArrayList<String> listOfValues = new ArrayList<String>(values);
```
### c) Conversion Of HashMap’s Key-Value Pairs Into ArrayList :

For this, we use entrySet() method of HashMap which returns the Set of Entry<K, V> objects where each Entry object represents one key-value pair. We pass this Set to create the ArrayList of key-value pairs.

```java
//Creating a HashMap object 
         
HashMap<String, String> map = new HashMap<String, String>();                   
//Getting Set of entries from HashMap                   
Set<Entry<String, String>> entrySet = map.entrySet();                   
//Creating an ArrayList of Entry objects                   
ArrayList<Entry<String, String>> listOfEntry = new ArrayList<Entry<String, String>>(entrySet);

```
## Java 8 – Convert Map To List

### a) Java 8 – Convert Map Keys To List
```java
//Creating a Map object
         
Map<String, Integer> map = new HashMap<String, Integer>();
         
//Java 8 code to convert map keys to list
         
List<String> listOfKeys = map.keySet().stream().collect(Collectors.toList());
         
//Java 8 code to print List elements
         
listOfKeys.forEach(System.out::println);
```
### b) Java 8 – Convert Map Values To List
```java
//Creating a Map object
         
Map<String, Integer> map = new HashMap<String, Integer>();
         
//Java 8 code to convert map values to list
         
List<Integer> listOfValues = map.values().stream().collect(Collectors.toList());
         
//Java 8 code to print List elements
         
listOfValues.forEach(System.out::println);
```
### c) Java 8 – Sort And Convert Map Keys To List
```java
//Creating a Map object
         
Map<String, Integer> map = new HashMap<String, Integer>();
             
//Java 8 code to sort and convert map keys to list
                 
List<String> listOfKeys = map.keySet().stream().sorted().collect(Collectors.toList());
                 
//Java 8 code to print List elements
                 
listOfKeys.forEach(System.out::println);
```
### d) Java 8 – Sort And Convert Map Values To List
```java
//Creating a Map object
         
Map<String, Integer> map = new HashMap<String, Integer>();
             
//Java 8 code to sort and convert map values to list
                 
List<Integer> listOfValues = map.values().stream().sorted().collect(Collectors.toList());
                 
//Java 8 code to print List elements
                 
listOfValues.forEach(System.out::println);
```
Note : You can also provide Comparator to sorted() method to sort the keys or values as you wish.
