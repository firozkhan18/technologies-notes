# Java Collections

Java Collections is one of the most important areas where you will be tested in junior or senior positions. The scope of questions is so broad that it is almost impossible to cover all the questions. Yet based on my previous interviews, I am attempting to put as many as possible good interview questions.

I am aiming for beginners and senior-level interviews, so bear with me if you find some questions too basic because they might be helpful for other junior developers.

## Java Collections Framework Questions

### 1. What is Java Collections framework? What are its advantages?
By definition, a Collection is an object that can store a group of objects. Like in set theory, a set is a group of elements. Easy enough !!

Before JDK 1.2, JDK had some utility classes such as Vector and HashTable, and there was no concept of the Collection framework. Later from JDK 1.2 onwards, JDK developers felt the need to have consistent support for reusable data structures. Finally, the collections framework was designed and developed primarily by Joshua Bloch, and was introduced in JDK 1.2.

The Collections framework is a unified architecture for representing and manipulating collections, manipulating collections independently of implementation details.

The framework provides classes and interfaces for representing different types of collections, such as Set, List, and Map. Besides providing basic implementations, it also provides other special-purpose implementations as well, for example, concurrent collections (ConcurrentMap, BlockingQueue, etc) and convenience implementations (Arrays.asList(), Collections.emptySet(), Collections.singleton(), etc)

We can list the most noticeable benefits of Java collections as:

Reduced programming effort due to ready to use code
Increased performance because of high-performance implementations of data structures and algorithms
Provides interoperability between unrelated APIs by establishing a common language to pass collections back and forth
Easy to learn APIs by learning only some top level interfaces and supported operations
### 2. What is Collections Hierarchy?
Java Collection Hierarchy
Java Collection Hierarchy
As shown in the above image, the collection framework has one interface at the top i.e. Collection. Set, List and Queue interfaces extend it. Then there are many other classes in these three branches.

Remember the signature of Collection interface. It will help you with many questions.

public interface Collection extends Iterable {
//method definitions
}

The framework also consists of Map interface, which is part of the collection framework but does not extend the Collection interface.

### 3. Why Collection does not extend Cloneable and Serializable interface?
Well, the most straightforward answer is “there is no need to do it”. Extending an interface means that you are creating a subtype of the interface, in other words, a more specialized behavior and Collection classes are not expected to do what Cloneable and Serializable interfaces do.

Another reason is that not everybody will have a reason to create Cloneable collections because if it may contain huge data, then every unnecessary clone operation will consume a significant memory. Beginners might use it without knowing the consequences.

Another reason is that Cloneable and Serializable are very specialized behavior and so should be implemented only when required. For example, many concrete classes in Collection implement these interfaces. So if you want this feature, use these collection classes; otherwise, use their alternative classes.

### 4. Why Map interface does not extend Collection interface?
An excellent answer to this interview question is “because they are incompatible“.

The Collection interface has a method add(Object o). The Map can not have such a method because it needs key-value pair. There are other reasons also such as Map supports EntrySet etc. Collection classes do not have such views.

Due to such big differences, the Map interface was not included in the Collection framework hierarchy, and it was built in a separate hierarchy.

# List Interface Questions
### 5. What is a List? What are Core Classes implementing List?
List is index-based and an ordered collection of elements. The ordering is a zero-based index.
List allows the duplicate items.
Apart from methods defined in Collection interface, it does have its own methods also which are to manipulate the List based on the index location of the item. These methods can be grouped as search, get, iteration and range view. All above operations support index locations.
The main classes implementing the List interface are Stack, Vector, ArrayList and LinkedList.

### 6. How to Convert from Array to List?
This is a coding-related question that can be asked at the beginner level. The question intends to check the knowledge of applicants in Collection utility classes.

For now, let us learn that there are two utility classes in the Collection framework which are mostly seen in interviews:

Collections
Arrays
Collections class provides static functions to perform specific operations on various collection types. And Arrays provide utility functions to be performed on array types.

//String array
String[] words = {"ace", "boom", "crew", "dog", "eon"};

//Use Arrays utility class

List wordList = Arrays.asList(words);
//Now you can iterate over the list

Please note that this function is not specific to the String class. This can return a List of items of any class type.

### 7. How to Reverse a List?
This question is just like above to test your knowledge of Collections utility class. Use Collections.reverse() method to reverse the List.

Collections.reverse(list);

# Set Interface Questions
### 8. What is a Set? What are Core Classes Implementing Set Interface?
A Set models the mathematical set in set theory. The Set interface is similar to List interface but with some differences.

Unlike List, A Set does not have index-based operations. It only has methods that are inherited by the Collection interface.
A Set is not an ordered collection. So no ordering is preserved while adding or removing elements.
A Set guarantees the “uniqueness of elements”. It does not store duplicate elements.
Set also adds a stronger contract on the behavior of the equals() and hashCode() operations, allowing two Set instances to be compared meaningfully even if their implementation types differ. Two Set instances are equal if they contain the same elements.

Main classes implementing Set interface are : EnumSet, HashSet, LinkedHashSet, TreeSet.

### 9. How HashSet Store Unique Items?
We must know that a HashMap stores key-value pairs, with one condition that keys will be unique. HashSet uses unique keys feature of the Map to ensure the uniqueness of items it stores. In HashSet class, a map declaration is as below:

private transient HashMap<E,Object> map;

//This is added as value for each key
private static final Object PRESENT = new Object();

So when we store an item in HashSet, item is stored as key in Map and the existing object as the value.

public boolean add(E e) {
     return map.put(e, PRESENT)==null;
}

I will highly suggest you read this post: How HashMap works? This post will help you answer all the HashMap related questions very comfortably.

### 10. Can We Add a Null to a TreeSet or HashSet?
As you see, there is no null check in add() method in the previous question. And HashMap also allows one null key, so HashSet allows one “null” item.

TreeSet uses the same concept as HashSet for internal logic but uses NavigableMap for storing the elements.

private transient NavigableMap<E,Object> m;

// Dummy value to associate with an Object in the backing Map
private static final Object PRESENT = new Object();

NavigableMap is a subtype of SortedMap which does not allow null keys. So essentially, TreeSet does not support null items. It will throw NullPointerException if you add a null element in TreeSet.

# Map Interface Questions
### 11. What is a Map? What are Core Classes Implementing Map Interface?
A Map interface is a special type of collection that is used to store key-value pairs.
Map does not extend Collection interface.
Map interface provides methods to add, remove, search or iterate over various views of Map.
The main classes implementing Map interface are HashMap, Hashtable, EnumMap, IdentityHashMap, LinkedHashMap and Properties.

### 12. What are IdentityHashMap and WeakHashMap?
IdentityHashMap is similar to HashMap except that it uses reference equality when comparing elements.

IdentityHashMap class is not a widely used Map implementation. While this class implements the Map interface, it intentionally violates Map’s general contract, which mandates using the equals() method when comparing objects. IdentityHashMap is designed only in rare cases wherein reference-equality semantics are required.

WeakHashMap implements the Map interface that stores only weak references to its keys.

Storing only weak references allows a key-value pair to be garbage collected when its key is no longer referenced outside of the WeakHashMap. This class is primarily used with key objects whose equals() methods test for object identity using the == operator. Once such a key is discarded, it can never be recreated, so it is impossible to look up that key in a WeakHashMap at some later time and be surprised that its entry has been removed.

### 13. What is ConcurrentHashMap? How Does It Maintain Concurrency?
ConcurrentHashMap is an alternative to HashMap class to be safely used in the concurrent environment.

A ConcurrentHashMap is a Hashtable supporting full concurrency of retrievals and adjustable expected concurrency for updates.

ConcurrentHashMap class obeys the same functional specification as Hashtable and includes versions of methods corresponding to each method of Hashtable. However, even though all operations are thread-safe, retrieval operations do not entail locking, and there is not any support for locking the entire table in a way that prevents all access.

ConcurrentHashMap class is fully interoperable with Hashtable in programs that rely on its thread safety but not on its synchronization details.

Read More: ConcurrentHashMap Interview Questions.

### 14. How Hashmap Works?
This question is the most important and is most likely to be asked at every job interview level. You must be very clear on this topic., not only because it is the most asked question but also it will open up your mind to further questions related to Collection APIs.

The answer to this question is very large, and you should read my post: How HashMap works? For now, let us remember that HashMap works on the principle of Hashing.

A map, by definition is: “An object that maps keys to values”. To store such a structure, it uses an inner class Entry.

static class Entry implements Map.Entry
{
	final K key;
	V value;

	Entry next;
	
	final int hash;
	...//More code goes here
}

Here key and value variables are used to store key-value pairs. The whole Entry object is stored in an array. The index of the array is calculated based on the hashcode of Key object.

/**
* The table, re-sized as necessary. Length MUST Always be a power of two.
*/
transient Entry[] table;

### 15. How to Design a Good Key for HashMap?
Another good question that is usually followed up after answering how hashmap works. The most important constraint in a Map is that we must be able to fetch the ‘Value‘ object back in the future using the ‘Key‘ object. Otherwise, there is no use of having such a data structure.

If we understand the working of HashMap, we will find it largely depends on hashCode() and equals() methods of the Key instances.

So a good key object must provide the same hashCode() again and again, no matter how many times it is fetched.
Similarly, the same keys must return true when compared with equals() method and different keys must return false.
For this reason, immutable classes are considered the best candidates for HashMap keys.

Read more: How to design a good key for HashMap?

### 16. What are Different Views provided by Map Interface?
Map interface provides 3 views of key-value pairs stored in it:

KeySet view – A Set of all the keys stored in the Map.
ValueSet view – A Set of all the values stored in the Map.
EntrySet view – A Set of all the key-value pairs stored in the Map.
All these views can be navigated using iterators.

### 17. When to Use HashMap and TreeMap?
HashMap stores unordered key-value pairs and allows to perform many get/put operations on such key-value pairs.

TreeMap is a particular form of HashMap. TreeMap maintains the ordering of keys. This ordering is by default “natural ordering”. We can override the default order by providing an instance of the Comparator class, whose compare() method will be used to maintain the ordering of keys.

Please note that all keys inserted into the TreeMap must implement the Comparable interface (this is necessary to decide the ordering).

Furthermore, all TreeMap keys must be mutually comparable i.e. k1.compareTo(k2) must not throw a ClassCastException for any keys k1 and k2 in the Map.

If the user attempts to put a key into the TreeMap that violates this constraint (for example, the user attempts to put a String key into a map whose other keys are Integer types), the put() call will throw a ClassCastException.

# ‘Tell the Difference’ Questions
### 18. Difference between Set and List?
The most noticeable differences are :

Set is unordered collection where List is ordered collection based on zero based index.
List allow duplicate elements but Set does not allow duplicates.
List does not prevent inserting null elements (as many you like), but Set will allow only one null element.
### 19. Difference between List and Map?
A List is a collection of elements, whereas a Map is a collection of key-value pairs.

List and Map, both. have separate top-level interfaces, a separate set of generic methods, different supported methods and different views of the Collection.

### 20. Difference between HashMap and HashTable?
There are several differences between HashMap and Hashtable in Java:

Hashtable is synchronized, whereas HashMap is not.
Hashtable does not allow null keys or values. HashMap allows one null key and any number of null values.
The third significant difference between HashMap vs Hashtable is that Iterator in the HashMap is a fail-fast iterator while the enumerator for the Hashtable is not.
### 21. Difference between Vector and ArrayList?
Let us note down the differences:

All the methods of Vector is synchronized. But, the methods of ArrayList is not synchronized.
Vector is a Legacy class added in first release of JDK. ArrayList was part of JDK 1.2, when collection framework was introduced in java.
By default, Vector doubles the size of its array when it is re-sized internally. But, ArrayList increases by half of its size when it is re-sized.
### 22. Difference between Iterator and Enumeration?
Iterators differ from enumerations in three ways:

Iterators allow the caller to remove elements from the underlying collection during the iteration with its remove() method. You can not add/remove elements from a collection when using enumerator.
Enumeration is available in legacy classes i.e Vector/Stack etc. whereas Iterator is available in all modern collection classes.
Another minor difference is that Iterator has improved method names e.g. Enumeration.hasMoreElement() has become Iterator.hasNext(), Enumeration.nextElement() has become Iterator.next() etc.
### 23. Difference between HashMap and HashSet?
HashMap is a collection of key-value pairs, whereas HashSet is an unordered collection of unique elements.

That’s it. No need to describe further.

### 24. Difference between Iterator and ListIterator?
There are three Differences are there:

We can use Iterator to traverse Set and List and also Map type of Objects. But List Iterator can be used to traverse for List type Objects, but not for Set type of Objects.
By using Iterator we can retrieve the elements from Collection Object in forward direction only whereas List Iterator, which allows you to traverse in either directions using hasPrevious() and previous() methods.
ListIterator allows you modify the list using add() remove() methods. Using Iterator you can not add, only remove the elements.
### 25. Difference between TreeSet and SortedSet?
SortedSet is an interface that TreeSet implements.

TreeSet stores elements that are ordered using their natural ordering.

SortedSet provides a total ordering on its elements. The elements are ordered using their natural arrangement, or by a Comparator typically provided at sorted set creation time. 

### 26. Difference between ArrayList and LinkedList?
LinkedList store elements within a doubly-linked list data structure. ArrayList store elements within a dynamically resizing array.
LinkedList allows for constant-time insertions or removals, but only sequential access of elements. In other words, you can walk the list forwards or backwards, but grabbing an element in the middle takes time proportional to the size of the list. ArrayLists, on the other hand, allow random access, so you can grab any element in constant time. But adding or removing from anywhere but the end requires shifting all the latter elements over, either to make an opening or fill the gap.
LinkedList has more memory overhead than ArrayList because in ArrayList each index only holds actual object (data) but in case of LinkedList each node holds both data and address of next and previous node.
# Expert Level Collections Interview Questions
### 27. How to Create Read-only Collections?
Use the following methods:

Collections.unmodifiableList( list );
Collections.unmodifiableSet( set );
Collections.unmodifiableMap( map );
These methods take a collection parameter and return a new read-only collection with the same elements as the original Collection.

### 28. How to Create Thread-safe Collections?
Use the below methods:

Collections.synchronizedList( list );
Collections.synchronizedSet( set );
Collections.synchronizedMap( map );
The above methods take the Collection as a parameter and return the same type of Collection that is synchronized and thread-safe.

The other solution is to use concurrent collections. For example, ConcurrentHashMap or BlockingQueue.

### 29. Why Iterator doesn’t have add() Method?
The sole purpose of an Iterator is to enumerate through a collection.

All collections contain the add() method to serve the purpose. There would be no point in adding to an Iterator because the Collection may or may not be ordered. And Iterator.add() method can not have the same implementation for ordered and unordered collections.

### 30. What are Different Ways to Iterate a List?
You can iterate over a list using the following ways:

Iterator
For loop
For-each loop
While loop
Stream.forEach()
### 31. What is a Fail-fast Iterator?
Fail-fast Iterators fail as soon as they detect that structure of the Collection has been changed since iteration has begun.

Structural changes mean adding, removing or updating items from the Collection while one thread is Iterating over that Collection.

Fail-fast behavior is implemented by keeping a modification count, and if the iteration thread realizes the change in modification count it throws ConcurrentModificationException.

### 32. Difference between Fail-fast and Fail-safe Iterators?
We have understood the fail-fast iterators in the previous question.

Fail-safe iterators are just the opposite of fail-fast. A Fail-safe iterator does not fail if we modify the underlying Collection on which they are iterating because they work on a clone of Collection instead of the original Collection and that’s why they are called a fail-safe iterator.

Iterator of CopyOnWriteArrayList is an example of a fail-safe Iterator. Also, the iterator returned by ConcurrentHashMap keySet is a fail-safe iterator and never throw ConcurrentModificationException.

### 33. How to Avoid ConcurrentModificationException while Iterating a Collection?
We should first try to find another alternative iterator that is fail-safe. For example, if you are using List and you can use ListIterator. If it is a legacy collection, you can use enumeration.

If the above solutions are not possible, then you can use one of three changes:

If you are using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes. It is the recommended approach.
You can convert the list to an array and then iterate on the array.
You can lock the list while iterating by putting it in a synchronized block.
Please note that the last two approaches will cause a performance hit.

### 34. What is UnsupportedOperationException?
This exception is thrown on invoked methods that are not supported by the actual collection type.

For example, if you make a read-only list using “Collections.unmodifiableList(list)” and then call add() or remove() method, what should happen. It should clearly throw UnsupportedOperationException.

### 35. Which Collections Provide Random Access to the Items?
Index-based List classes and Map classes provide such access.

ArrayList, HashMap, TreeMap, Hashtable classes provide random access to its items.

### 36. What is BlockingQueue?
A BlockingQueue is a Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.

BlockingQueue methods come in four overrides:

one throws an exception,
the second returns a special value (either null or false, depending on the operation),
the third blocks the current thread indefinitely until the operation can succeed,
and the fourth blocks for only a given maximum time limit before giving up.
Read more: How to use BlockingQueue?


### 37. What is Queue and Stack. Tell the Differences?
A Queue is a collection designed for holding elements before processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations.

Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner. Use a queue if you want to process a stream of incoming items in the order received. Good for work lists and handling requests.

A Stack is also a form of Queue, but it is LIFO (last-in-first-out). Use a stack if you want to push and pop from the top of the stack only. Good for recursive algorithms.

Whatever the ordering used, the head of the queue is that element that would be removed by a call to remove() or poll().

Also, note that Stack and Vector are both synchronized.

### 38. What is Comparable and Comparator interfaces?
In Java, all collection classes that have features of automatic sorting use compare() methods to ensure the correct sorting of elements. For example,TreeSet, TreeMap etc.

To support sorting of its instances, a class needs to implement Comparable interface. That’s why all wrapper classes like Integer, Double and String class implements Comparable interface.

Comparable helps in preserving default natural sorting, whereas Comparator helps in sorting the elements in some special sorting pattern.

The instance of Comparator is passed usually as the sort() method argument in the supporting collections.

### 39. What are Collections and Arrays Classes?
Collections and Arrays classes are special utility classes to support collection framework core classes.

Collections provide utility functions to get read-only/synchronized collections, sort the Collection in various ways etc.

Arrays help to convert arrays into collection objects. Arrays also have some functions which help in copying or working in part of array objects.


# Intoduction to Java Collections

A collection, as the name implies, is a group of objects. Java Collections framework consists of interfaces and classes that help work with different collection types such as lists, sets, maps, stacks and queues etc.

These ready-to-use collection classes solve lots of common problems where we need to deal with groups of homogeneous and heterogeneous objects. The common operations involved are add, remove, update, sort, search and more complex algorithms. These collection classes provide very transparent support for all such operations using Collections APIs.

## 1. Java Collections Hierarchy
The Collections framework is better understood with the help of core interfaces. The collections classes implement these interfaces and provide concrete functionalities.

Java Collections Hierarchy
Java Collections Hierarchy
### 1.1. Collection
Collection interface is at the root of the hierarchy. Collection interface provides all general purpose methods which all collections classes must support (or throw UnsupportedOperationException). It extends Iterable interface that adds support for iterating over collection elements using the “for-each loop” statement.

All other collection interfaces and classes (except Map) either extend or implement this interface. For example, List (indexed, ordered) and Set (sorted) interfaces implement this collection.

### 1.2. List
Lists represent an ordered collection of elements. Using lists, we can access elements by their integer index (position in the list), and search for elements in the list. index starts with 0, just like an array.

Some useful classes which implement List interface are – ArrayList, CopyOnWriteArrayList, LinkedList, Stack and Vector.

### 1.3. Set
Sets represent a collection of unique elements. Sets do not allow duplicate elements. Set interface does not provides a guarantee to return the elements in any predictable order; though some Set implementations store elements in their natural ordering and guarantee this order.

Some useful classes which implement Set interface are – ConcurrentSkipListSet, CopyOnWriteArraySet, EnumSet, HashSet, LinkedHashSet and TreeSet.

### 1.4. Map
The Map interface enables us to store data in key-value pairs (keys should be immutable). A Map cannot contain duplicate keys; each key can map to at most one value.

The Map interface provides three collection views, which allow a map’s contents to be viewed as a set of keys, collection of values, or set of key-value mappings. Some map implementations, like the TreeMap class, make specific guarantees as to their order; others, like the HashMap class, do not.

Some useful classes which implement Map interface are – ConcurrentHashMap, ConcurrentSkipListMap, EnumMap, HashMap, Hashtable, IdentityHashMap, LinkedHashMap, Properties, TreeMap and WeakHashMap.

### 1.5. Stack
The Java Stack interface represents a classical stack data structure, where elements can be pushed to last-in-first-out (LIFO) stack of objects. In Stack, we push an element to the top of the stack, and popped off from the top of the stack again later.

### 1.6. Queue
A queue data structure is intended to hold the elements (put by producer threads) prior to consumer thread(s) processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations.

Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner. One such exception is the priority queue which orders elements according to a supplied Comparator, or the elements’ natural ordering.

In general, queues do not support blocking insertion or retrieval operations. Blocking queue implementations classes implement BlockingQueue interface.

Some useful classes which implement Queue interface are – ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue and SynchronousQueue.

### 1.7. Deque
A double-ended queue (pronounced “deck“) that supports element insertion and removal at both ends. When a deque is used as a queue, FIFO (First-In-First-Out) behavior results. When a deque is used as a stack, LIFO (Last-In-First-Out) behavior results.

This interface should be used in preference to the legacy Stack class. When a deque is used as a stack, elements are pushed and popped from the beginning of the deque.

Some commonly known classes implementing this interface are ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque and LinkedList.

## 2. Java Collections and Generics
By purpose, generics provide type safety. It detects the incompatible types (in method arguments) and prevents ClassCastException in runtime. We can also define a collection class in Java collections to store only a certain type of object. All other types should be disallowed. This is done via generics.

The first two add() methods are allowed in the given example. The third one will not compile and will give error – “The method put(Integer, String) in the type HashMap<Integer,String> is not applicable for the arguments (String, String)”. It helps in detecting incompatible types early to prevent unpredictable behavior in runtime.

Generic HashMap
HashMap<Integer, String> map = new HashMap<>();
         
map.put(1, "A");  //allowed
map.put(2, "B");  //allowed
 
map.put("3", "C");  //NOT allowed - Key is string

## 3. The equals() and hashCode() Methods
Many collection classes provide specific functionalities such as sorted elements, no duplicate elements etc. To implement this behavior, the added elements (objects) must implement the equals() and hashCode() methods correctly.

All Java wrapper classes and String class override these functions with their specific implementation, so they behave correctly in such collections. We also need to ensure that these functions are overridden correctly in our user-defined custom classes.

SortedSet<Integer> sortedSet = new TreeSet<>();
 
sortedSet.add(2);
 
sortedSet.add(1);
sortedSet.add(1);
 
sortedSet.add(3);
 
System.out.println(sortedSet);  //[1,2,3]

## 4. Java 8 Changes
Java 8 was a major release that introduced lambda style of programming in Java. Collections classes were also improved as a result. For example, we can iterate over collections in a single line and perform an action on all elements of the collection using forEach statement.

ArrayList<Integer> list = new ArrayList<>();
         
list.add(1);
list.add(2);
list.add(3);
 
list.forEach(System.out::print);

## 5. Benefits of Java Collections
### 5.1. Consistent and Reusable APIs
This is what a framework does. It provides a consistent set of class methods that can be used to solve a similar set of problems over and over, without getting unpredictable results. The Java collections framework also consistently helps solve common problems related to a group of objects.

All collection classes have consistent implementation and provide some common methods like add, get, put, remove etc. No matter what kind of data structure you are dealing with, these methods work according to underlying implementation and perform actions transparently.

### 5.2. Less Development Time
A common and predictable framework always decreases the development time and helps in writing application programs in a speedy manner. Java collection also helps in performing some most repeated common tasks with objects and collections and thus improves the time factor.

### 5.3. Performance
The Java collection APIs are written by some most brilliant minds in the industry, and their performance is top-notch in most scenarios. Ongoing development work by Oracle and a very enthusiastic Java developer community help in making it better.
