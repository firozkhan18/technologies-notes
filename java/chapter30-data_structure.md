```mermaid
classDiagram
  class Collection {
    <<interface>>
  }

  class List {
    <<interface>>
  }

  class Set {
    <<interface>>
  }

  class Queue {
    <<interface>>
  }

  class Map {
    <<interface>>
  }

  class ArrayList {
    <<class>>
  }

  class LinkedList {
    <<class>>
  }

  class Vector {
    <<class>>
  }

  class Stack {
    <<class>>
  }

  class HashSet {
    <<class>>
  }

  class LinkedHashSet {
    <<class>>
  }

  class TreeSet {
    <<class>>
  }

  class PriorityQueue {
    <<class>>
  }

  class Deque {
    <<interface>>
  }

  class ArrayDeque {
    <<class>>
  }

  class HashMap {
    <<class>>
  }

  class LinkedHashMap {
    <<class>>
  }

  class TreeMap {
    <<class>>
  }

  class Hashtable {
    <<class>>
  }

  Collection <|-- List
  Collection <|-- Set
  Collection <|-- Queue
  Collection <|-- Map

  List <|-- ArrayList
  List <|-- LinkedList
  List <|-- Vector
  List <|-- Stack

  Set <|-- HashSet
  Set <|-- LinkedHashSet
  Set <|-- TreeSet

  Queue <|-- PriorityQueue
  Queue <|-- Deque

  Deque <|-- ArrayDeque
  Deque <|-- LinkedList

  Map <|-- HashMap
  Map <|-- LinkedHashMap
  Map <|-- TreeMap
  Map <|-- Hashtable



In Java, there are already plenty of data structures already available
there are grouped under the name the collection API.

Lists are not the only data structure in Java, you also have set, queue and map
- a set is set where you can not store the same object twice
  (object are the same is equals() return true)
- a queue add or remove object at the head or at the tail of the queue
  (so a stack is a queue, a FIFO is a queue, etc)
- a map is a dictionary that associate a key (which is unique) to a value

so to create an unmodifiable set, using the static method of()
```java
var authors = Set.of("J.R.R. Tolkien", "Philip K. Dick", "George R.R. Martin");
System.out.println(authors);
```

elements inside a set are organized in a way that make `contains` fast
```java
System.out.println(authors.contains("Philip K. Dick"));
```

there are 3 modifiable sets
- HashSet
- LinkedHashSet, as fast as set
- TreeSet, elements are sorted

a set has no order by default, apart if you create a LinkedHashSet




