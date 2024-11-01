# Interview Questions for Java Developer


+ [OOP](#OOP) ![icon][done]
+ [Java Core](#java-core) ![icon][done]
+ [Java Collections Framework](#java-collections) ![icon][done]
+ [Java 8](#java-8) ![icon][done]
+ [I/O Streams in Java](#I-O-Streams-in-Java) ![icon][done]
+ [Serialization](#serialization) ![icon][done]
+ [Multithreading](#multithreading) ![icon][done]
+ [Servlets, JSP, JSTL](#servlets-jsp-jstl) ![icon][done]
+ [Databases](#databases) ![icon][done]
+ [SQL](#sql) ![icon][done]
+ [JDBC](#jdbc) ![icon][done]
+ [Testing](#testing) ![icon][done]
+ [Logging](#logging) ![icon][done]
+ [UML](#uml) ![icon][done]
+ [XML](#xml) ![icon][done]
+ [Design Patterns](#design-patterns) ![icon][done]
+ [Basics of HTML](#basics-of-html) ![icon][done]
+ [Basics of CSS](#basics-of-css) ![icon][done]
+ [Basics of Web](#basics-of-web) ![icon][done]
+ [Additional Materials](#additional-materials) ![icon][done]

[done]:done.png

## OOP
+ [What is _OOP_?](oop.md#What-is-OOP)
+ [Name the main principles of _OOP_.](oop.md#Name-the-main-principles-of-OOP)
+ [What is _“encapsulation”?](oop.md#What-is-encapsulation)
+ [What is _“inheritance”?](oop.md#What-is-inheritance)
+ [What is _“polymorphism”?](oop.md#What-is-polymorphism)
+ [What is _“abstraction”?](oop.md#What-is-abstraction)
+ [What does _“message passing”_ represent?](oop.md#What-does-message-passing-represent)
+ [Discuss the main concepts of OOP: _“class”_, _“object”_, _“interface”_.](oop.md#Discuss-the-main-concepts-of-OOP-class-object-interface)
+ [What are the advantages and disadvantages of the object-oriented approach in programming?](oop.md#What-are-the-advantages-and-disadvantages-of-the-object-oriented-approach-in-programming)
+ [What do the terms _“is a”_ and _“has a”_ imply in the context of OOP principles?](oop.md#What-do-the-terms-is-a-and-has-a-imply-in-the-context-of-OOP-principles)
+ [What is the difference between _composition_ and _aggregation_?](oop.md#What-is-the-difference-between-composition-and-aggregation)
+ [What is _static_ and _dynamic binding_?](oop.md#What-is-static-and-dynamic-binding)

[Back to Table of Contents](#Interview-Questions-for-Java-Developer)

Java Core
Here’s your table of contents with navigation, formatted without numbers:

---

# **Table of Contents**

- [What is the difference between JRE, JVM, and JDK?](#what-is-the-difference-between-jre-jvm-and-jdk)
- [What are the different access modifiers?](#what-are-the-different-access-modifiers)
- [What does the final keyword mean?](#what-does-the-final-keyword-mean)
- [What are the default variable initialization values?](#what-are-the-default-variable-initialization-values)
- [What do you know about the main() function?](#what-do-you-know-about-the-main-function)
- [What logical operations and operators do you know?](#what-logical-operations-and-operators-do-you-know)
- [What is a ternary selection operator?](#what-is-a-ternary-selection-operator)
- [What bitwise operations do you know?](#what-bitwise-operations-do-you-know)
- [Where and why is the abstract modifier used?](#where-and-why-is-the-abstract-modifier-used)
- [Define the concept of "interface". What default modifiers do interface fields and methods have?](#define-the-concept-of-interface-what-default-modifiers-do-interface-fields-and-methods-have)
- [How is an abstract class different from an interface? When should you use an abstract class and when should you use an interface?](#how-is-an-abstract-class-different-from-an-interface-when-should-you-use-an-abstract-class-and-when-should-you-use-an-interface)
- [Why don't some interfaces define methods at all?](#why-dont-some-interfaces-define-methods-at-all)
- [Why can't I declare an interface method with a final modifier?](#why-cant-i-declare-an-interface-method-with-a-final-modifier)
- [Which has a higher level of abstraction – a class, an abstract class, or an interface?](#which-has-a-higher-level-of-abstraction-a-class-an-abstract-class-or-an-interface)
- [Can an object access a class private variable? If so, how?](#can-an-object-access-a-class-private-variable-if-so-how)
- [What is the order in which constructors and initialization blocks are invoked based on the class hierarchy?](#what-is-the-order-in-which-constructors-and-initialization-blocks-are-invoked-based-on-the-class-hierarchy)
- [Why are initialization blocks needed and what are the types?](#why-are-initialization-blocks-needed-and-what-are-the-types)
- [To which Java constructs does the static modifier apply?](#to-which-java-constructs-does-the-static-modifier-apply)
- [Why does Java use static initialization blocks?](#why-does-java-use-static-initialization-blocks)
- [What happens if an exception occurs in the initialization block?](#what-happens-if-an-exception-occurs-in-the-initialization-block)
- [What exception is thrown when an error occurs in the class initialization block?](#what-exception-is-thrown-when-an-error-occurs-in-the-class-initialization-block)
- [Can a static method be overridden or overloaded?](#can-a-static-method-be-overridden-or-overloaded)
- [Can non-static methods overwhelm static methods?](#can-non-static-methods-overwhelm-static-methods)
- [Is it possible to narrow the access level/return type when overriding a method?](#is-it-possible-to-narrow-the-access-levelreturn-type-when-overriding-a-method)
- [Is it possible to change the following when overriding a method: access modifier; return type; the type of argument or their number; argument names or their order; remove, add, or change the order of the elements in the throws section?](#is-it-possible-to-change-the-following-when-overriding-a-method-access-modifier-return-type-the-type-of-argument-or-their-number-argument-names-or-their-order-remove-add-or-change-the-order-of-the-elements-in-the-throws-section)
- [How do I access the overridden methods of the parent class?](#how-do-i-access-the-overridden-methods-of-the-parent-class)
- [Is it possible to declare a method abstract and static at the same time?](#is-it-possible-to-declare-a-method-abstract-and-static-at-the-same-time)
- [What is the difference between an instance member of a class and a static member of a class?](#what-is-the-difference-between-an-instance-member-of-a-class-and-a-static-member-of-a-class)
- [Where is initialization of static/non-static fields allowed?](#where-is-initialization-of-staticnon-static-fields-allowed)
- [What types of classes are there in Java?](#what-types-of-classes-are-there-in-java)
- [Tell us about nested classes. In what cases are they used?](#tell-us-about-nested-classes-in-what-cases-are-they-used)
- [What is a "static class"?](#what-is-a-static-class)
- [What are the features of using nested classes: static and internal? What is the difference between them?](#what-are-the-features-of-using-nested-classes-static-and-internal-what-is-the-difference-between-them)
- [What is a "local class"? What are its features?](#what-is-a-local-class-what-are-its-features)
- [What are "anonymous classes"? Where are they used?](#what-are-anonymous-classes-where-are-they-used)
- [How do I access an external class field from a nested class?](#how-do-i-access-an-external-class-field-from-a-nested-class)
- [What is the assert operator used for?](#what-is-the-assert-operator-used-for)
- [What is a garbage collector for?](#what-is-a-garbage-collector-for)
- [How does the garbage collector work?](#how-does-the-garbage-collector-work)
- [What types of garbage collectors are implemented in the HotSpot virtual machine?](#what-types-of-garbage-collectors-are-implemented-in-the-hotspot-virtual-machine)
- [Describe the algorithm of some garbage collector implemented in the HotSpot virtual machine.](#describe-the-algorithm-of-some-garbage-collector-implemented-in-the-hotspot-virtual-machine)
- [What is finalize()? Why is it needed?](#what-is-finalize-why-is-it-needed)
- [What happens to the garbage collector if the finalize() method takes a significant amount of time to run, or if an exception is thrown during execution?](#what-happens-to-the-garbage-collector-if-the-finalize-method-takes-a-significant-amount-of-time-to-run-or-if-an-exception-is-thrown-during-execution)
- [What is the difference between final, finally, and finalize()?](#what-is-the-difference-between-final-finally-and-finalize)
- [What is Heap and Stack memory in Java? What is the difference between them?](#what-is-heap-and-stack-memory-in-java-what-is-the-difference-between-them)
- [Is it true that primitive data types are always stored on the stack and instances of reference data types are on the heap?](#is-it-true-that-primitive-data-types-are-always-stored-on-the-stack-and-instances-of-reference-data-types-are-on-the-heap)
- [How are variables passed to methods, by value or by reference?](#how-are-variables-passed-to-methods-by-value-or-by-reference)
- [Tell us about type conversion. What is Downgrade and Type Upgrade?](#tell-us-about-type-conversion-what-is-downgrade-and-type-upgrade)
- [When can a ClassCastException be thrown in an application?](#when-can-a-classcastexception-be-thrown-in-an-application)
- [What is autoboxing in Java and what are the rules for wrapping primitive types into wrapper classes?](#what-is-autoboxing-in-java-and-what-are-the-rules-for-wrapping-primitive-types-into-wrapper-classes)
- [What are the features of the String class?](#what-are-the-features-of-the-string-class)
- [What is a "string pool"?](#what-is-a-string-pool)
- [Why is String an immutable and finalized class?](#why-is-string-an-immutable-and-finalized-class)
- [Why is char[] preferable to String for storing a password?](#why-is-char-preferable-to-string-for-storing-a-password)
- [Why is a string a popular key in a HashMap in Java?](#why-is-a-string-a-popular-key-in-a-hashmap-in-java)
- [What does the intern() method do in the String class?](#what-does-the-intern-method-do-in-the-string-class)
- [Can strings be used in a switch construct?](#can-strings-be-used-in-a-switch-construct)
- [What is the main difference between String, StringBuffer, StringBuilder?](#what-is-the-main-difference-between-string-stringbuffer-stringbuilder)
- [What is the Object class? What methods does it have?](#what-is-the-object-class-what-methods-does-it-have)
- [Tell us about cloning objects.](#tell-us-about-cloning-objects)
- [What is the difference between shallow and deep cloning?](#what-is-the-difference-between-shallow-and-deep-cloning)
- [Which cloning method is preferable?](

#which-cloning-method-is-preferable)
- [Why is the clone() method declared in the Object class and not in the Cloneable interface?](#why-is-the-clone-method-declared-in-the-object-class-and-not-in-the-cloneable-interface)
- [Define the concept of "constructor".](#define-the-concept-of-constructor)
- [What is the "default constructor"?](#what-is-the-default-constructor)
- [What is the difference between the default constructors, the copy constructor, and the parameter constructor?](#what-is-the-difference-between-the-default-constructors-the-copy-constructor-and-the-parameter-constructor)
- [Where and how can you use a private builder?](#where-and-how-can-you-use-a-private-builder)
- [Tell us about loader classes and dynamic class loading.](#tell-us-about-loader-classes-and-dynamic-class-loading)
- [What is Reflection?](#what-is-reflection)
- [Why do we need equals(). How is it different from ==?](#why-do-we-need-equals-how-is-it-different-from)
- [equals() gives rise to an equivalence relation. What are the properties of such a relation?](#equals-gives-rise-to-an-equivalence-relation-what-are-the-properties-of-such-a-relation)
- [If you want to override equals(), what conditions should be met for the overridden method?](#if-you-want-to-override-equals-what-conditions-should-be-met-for-the-overridden-method)
- [Rules for overriding the Object.equals() method.](#rules-for-overriding-the-objectequals-method)
- [What is the relationship between hashCode() and equals()?](#what-is-the-relationship-between-hashcode-and-equals)
- [If equals() is overridden, are there any other methods that should be overridden?](#if-equals-is-overridden-are-there-any-other-methods-that-should-be-overridden)
- [What happens if I override equals() without overriding hashCode()? What problems can arise?](#what-happens-if-i-override-equals-without-overriding-hashcode-what-problems-can-arise)
- [How are the hashCode() and equals() methods implemented in the Object class?](#how-are-the-hashcode-and-equals-methods-implemented-in-the-object-class)
- [What is the hashCode() method for?](#what-is-the-hashcode-method-for)
- [Rules for overriding the Object.hashCode() method.](#rules-for-overriding-the-objecthashcode-method)
- [Are there any guidelines on which fields should be used when calculating hashCode()?](#are-there-any-guidelines-on-which-fields-should-be-used-when-calculating-hashcode)
- [Can different objects have the same hashCode()?](#can-different-objects-have-the-same-hashcode)
- [If the Point{int x, y;} class implements the equals(Object that) {(return this.x == that.x && this.y == that.y)} method, but makes the hash code in the form of int hashCode() {return x;}, will such points be placed and retrieved from the HashSet correctly?](#if-the-pointint-x-y-class-implements-the-equalsobject-that-return-thisx--thatx--thisy--thaty-method-but-makes-the-hash-code-in-the-form-of-int-hashcode-return-x-will-such-points-be-placed-and-retrieved-from-the-hashset-correctly)
- [Can different objects (ref0 != ref1) have ref0.equals(ref1) == true?](#can-different-objects-ref0-ref1-have-ref0equalsref1--true)
- [Can different references to the same object (ref0 == ref1) have ref0.equals(ref1) == false?](#can-different-references-to-the-same-object-ref0-ref1-have-ref0equalsref1--false)
- [Is it possible to implement the equals(Object that) method {return this.hashCode() == that.hashCode()}?](#is-it-possible-to-implement-the-equalsobject-that-method-return-this-hashcode--that-hashcode)
- [In equals(), you need to check that the equals(Object that) argument is of the same type as the object itself. What's the difference between this.getClass() == that.getClass() and that instanceof MyClass?](#in-equals-you-need-to-check-that-the-equalsobject-that-argument-is-of-the-same-type-as-the-object-itself-whats-the-difference-between-thisgetclass--thatgetclass-and-that-instanceof-myclass)
- [Is it possible to implement the equals() method of the MyClass class like this: class MyClass {public boolean equals(MyClass that) {return this == that;}}?](#is-it-possible-to-implement-the-equals-method-of-the-myclass-class-like-this-class-myclass-public-boolean-equalsmyclass-that-return-this--that)
- [There is a class called Point{int x, y;}. Why is a hash code of 31 * x + y preferable to x + y?](#there-is-a-class-called-pointint-x-y-why-is-a-hash-code-of-31--x--y-preferable-to-x--y)
- [Describe the hierarchy of exceptions.](#describe-the-hierarchy-of-exceptions)
- [What types of exceptions do you know in Java, how do they differ?](#what-types-of-exceptions-do-you-know-in-java-how-do-they-differ)
- [What is a checked and unchecked exception?](#what-is-a-checked-and-unchecked-exception)
- [Which operator allows you to force an exception to be thrown?](#which-operator-allows-you-to-force-an-exception-to-be-thrown)
- [What does the throws keyword mean?](#what-does-the-throws-keyword-mean)
- [How do you write your own ("user") exception?](#how-do-you-write-your-own-user-exception)
- [What are the unchecked exceptions?](#what-are-the-unchecked-exceptions)
- [What is Error?](#what-is-error)
- [What do you know about OutOfMemoryError?](#what-do-you-know-about-outofmemoryerror)
- [Describe how the try-catch-finally block works.](#describe-how-the-try-catch-finally-block-works)
- [What is the try-with-resources mechanism?](#what-is-the-try-with-resources-mechanism)
- [Is it possible to use a try-finally block (without catch)?](#is-it-possible-to-use-a-try-finally-block-without-catch)
- [Can a single catch block catch multiple exceptions at once?](#can-a-single-catch-block-catch-multiple-exceptions-at-once)
- [Is the finally block always executed?](#is-the-finally-block-always-executed)
- [Are there situations where a finally block will fail?](#are-there-situations-where-a-finally-block-will-fail)
- [Can the main method throw an exception outside and, if so, where will the exception be handled?](#can-the-main-method-throw-an-exception-outside-and-if-so-where-will-the-exception-be-handled)
- [Suppose there is a method that can throw IOException and FileNotFoundException, in what sequence should the catch blocks go? How many catch blocks will be executed?](#suppose-there-is-a-method-that-can-throw-ioexception-and-filenotfoundexception-in-what-sequence-should-the-catch-blocks-go-how-many-catch-blocks-will-be-executed)
- [What are generics?](#what-are-generics)
- [What is "internationalization" and "localization"?](#what-is-internationalization-and-localization)

---

### Java Collections

- [What is a "collection"?](#what-is-a-collection)
- [Name the main JCF interfaces and their implementations.](#main-jcf-interfaces)
- [Arrange the following interfaces in a hierarchy: List, Set, Map, SortedSet, SortedMap, Collection, Iterable, Iterator, NavigableSet, NavigableMap.](#interface-hierarchy)
- [Why is Map not Collection while List and Set are Collection?](#map-vs-collection)
- [What is the difference between the java.util.Collection and java.util.Collections classes?](#collection-vs-collections)
- [What is "fail-fast behavior"?](#fail-fast-behavior)
- [What is the difference between fail-fast and fail-safe?](#fail-fast-vs-fail-safe)
- [Give examples of iterators that implement fail-safe behavior.](#fail-safe-iterators)
- [What is the difference between Enumeration and Iterator?](#enumeration-vs-iterator)
- [How are Iterable and Iterator related?](#iterable-and-iterator)
- [How are Iterable, Iterator and "for-each" related?](#iterable-iterator-for-each)
- [Compare Iterator and ListIterator.](#iterator-vs-listiterator)
- [What happens if I call Iterator.next() without first calling Iterator.hasNext()?](#iterator-next-without-hasnext)
- [How many elements will be skipped if Iterator.next() is called after 10 calls to Iterator.hasNext()?](#elements-skipped)
- [How will the collection behave if you call iterator.remove()?](#iterator-remove)
- [How will an already instantiated iterator for collection behave if collection.remove() is called?](#instantiated-iterator)
- [How do I avoid a ConcurrentModificationException during a collection iteration?](#avoiding-concurrent-modification-exception)
- [Which collection implements the FIFO service discipline?](#fifo-collection)
- [Which collection implements the FILO service discipline?](#filo-collection)
- [What is the difference between ArrayList and Vector?](#arraylist-vs-vector)
- [Why did you add an ArrayList if you already had a Vector?](#reason-for-arraylist)
- [What is the difference between ArrayList and LinkedList? In which cases is it better to use the first and in which the second?](#arraylist-vs-linkedlist)
- [Which is faster, ArrayList or LinkedList?](#faster-arraylist-or-linkedlist)
- [What is the worst run time of the contains() method for an item that is on the LinkedList?](#contains-worst-time-linkedlist)
- [What's the worst run time of the contains() method for an item that's in the ArrayList?](#contains-worst-time-arraylist)
- [What is the worst add() method run time for LinkedList?](#add-worst-time-linkedlist)
- [What is the worst time to use the add() method for ArrayList?](#add-worst-time-arraylist)
- [You need to add 1 million elements, what structure do you use?](#adding-1-million-elements)
- [How do I remove items from the ArrayList? How does the size of the ArrayList change in this case?](#removing-items-arraylist)
- [Propose an efficient algorithm for removing multiple adjacent items from the middle of the list implemented by the ArrayList.](#removing-adjacent-items)
- [How much additional memory do I need when calling ArrayList.add()?](#memory-add-arraylist)
- [How much additional memory is allocated when calling LinkedList.add()?](#memory-add-linkedlist)
- [Estimate the amount of memory to store a single byte primitive in LinkedList?](#memory-byte-primitive-linkedlist)
- [Estimate the amount of memory to store a single byte primitive in the ArrayList?](#memory-byte-primitive-arraylist)
- [For ArrayList or for LinkedList, is the add element to the middle operation (list.add(list.size()/2, newElement)) slower?](#add-to-middle)
- [The implementation of the ArrayList class has the following fields: Object[] elementData, int size. Explain why store a separate size when you can always take elementData.length?](#separate-size)
- [Compare the Queue and Deque interfaces.](#queue-vs-deque)
- [Who extends whom: Queue extends Deque, or Deque extends Queue?](#queue-vs-deque-extends)
- [Why does LinkedList implement both List and Deque?](#linkedlist-implements-list-deque)
- [Is a LinkedList a single-linked, double-linked, or four-linked list?](#linkedlist-type)
- [How do I iterate over LinkedList items in reverse order without using slow get(index)?](#reverse-iteration-linkedlist)
- [What does PriorityQueue do?](#priorityqueue)
- [Stack is considered "deprecated." What is recommended to replace it with? Why?](#stack-deprecation)
- [Why do I need a HashMap if I have a Hashtable?](#hashmap-vs-hashtable)
- [What is the difference between a HashMap and an IdentityHashMap? What is IdentityHashMap for?](#hashmap-vs-identityhashmap)
- [What is the difference between a HashMap and a WeakHashMap? What is WeakHashMap used for?](#hashmap-vs-weakhashmap)
- [WeakHashMap uses WeakReferences. Why not create a SoftHashMap on SoftReferences?](#weakhashmap-vs-softhashmap)
- [WeakHashMap uses WeakReferences. Why not create a PhantomHashMap on PhantomReferences?](#weakhashmap-vs-phantomhashmap)
- [LinkedHashMap - what's in it from LinkedList and what's from HashMap?](#linkedhashmap)
- [How does the "sorting" of SortedMap manifest itself, except that toString() prints all the elements in order?](#sortedmap-sorting)
- [How does the HashMap work?](#how-hashmap-works)
- [According to Knuth and Corman, there are two main implementations of the hash table: open-addressing and chain-based. How is the HashMap implemented? Why do you think this particular implementation was chosen? What are the pros and cons of each approach?](#hashmap-implementation)
- [How does a HashMap work when trying to store two elements in it by keys with the same hashCode(), but for which equals() == false?](#hashmap-same-hashcode)
- [What is the initial number of buckets in the HashMap?](#initial-buckets-hashmap)
- [What is the estimate of the temporal complexity of operations on elements from the HashMap? Does the HashMap guarantee the specified sampling complexity of the item?](#temporal-complexity-hashmap)
- [Is it possible that the HashMap will degenerate into a list even with keys that have different hashCode()?](#hashmap-degenerate)
- [In what case can an element be lost in the HashMap?](#element-loss-hashmap)
- [Why can't byte[] be used as a key in the HashMap?](#byte-key-hashmap)
- [What is the role of equals() and hashCode() in a HashMap?](#equals-hashcode-hashmap)
- [What is the maximum number of hashCode() values?](#maximum-hashcode-values)
- [What is the worst get(key) method run time for a key that is not in the HashMap?](#worst-get-not-in-hashmap)
- [What is the worst get(key) method time for a key that is in the HashMap?](#worst-get-in-hashmap)
- [How many hops occur when HashMap.get(key) is called on a key that is in the table?](#hops-hashmap)
- [How many new features are created when you add a new item to the HashMap?](#new-features-hashmap)
- [How and when does the increase in the number of buckets in the HashMap occur?](#increase-buckets-hashmap)
- [Explain the meaning of the parameters in the HashMap constructor(int initialCapacity, float loadFactor).](#hashmap-parameters)
- [Will the HashMap work if all the keys you add have the same hashCode()?](#same-hashcode-hashmap)
- [How do I iterate over all Map keys?](#iterate-map-keys)
- [How do you iterate over all Map values?](#iterate-map-values)
- [How do you iterate over all key-value pairs in Map?](#iterate-map-key-value)
- [What is the difference between TreeSet and HashSet?](#treeset-vs-hashset)
- [What happens if I add elements to a TreeSet in ascending order?](#adding-to-treeset)
- [How is LinkedHashSet different from HashSet?](#linkedhashset-vs-hashset)
- [There is a special java.util.EnumSet class for Enum. What for? Why were the authors not satisfied with HashSet or TreeSet?](#enumset)
- [What are the ways to iterate through list items?](#ways-to-iterate-list)
- [How can I get synchronized standard collection objects?](#synchronized-collections)
- [How do I get a read-only collection?](#readonly-collection)
- [Write a single-threaded

 program that causes the collection to throw a ConcurrentModificationException.](#concurrent-modification-exception)
- [Give an example where a collection throws an UnsupportedOperationException.](#unsupported-operation-exception)
- [Implement the symmetric difference between the two collections using the Collection methods (addAll(...), removeAll(...), retainAll(...)).](#symmetric-difference)
- [How do I use LinkedHashMap to make a cache with an "invalidation policy"?](#linkedhashmap-cache)
- [How do you copy the elements of any collection into an array with a single line?](#copy-collection-to-array)
- [How to get a List with all elements except the first and last 3 with one call from List?](#list-except-first-last)
- [How do I convert a HashSet to an ArrayList in a single line?](#convert-hashset-to-arraylist)
- [How do I convert an ArrayList to a HashSet in a single line?](#convert-arraylist-to-hashset)
- [Make a HashSet from the HashMap keys.](#hashset-from-hashmap-keys)
- [Make a HashMap from HashSet<Map.Entry<K, V>>.](#hashmap-from-hashset-entries)

---

Java 8
What are the new features in Java 8 and JDK 8?
What is "lambda"? What is the structure and features of using a lambda expression?
What variables do lambda expressions have access to?
How do I sort a list of strings using a lambda expression?
What is a "method reference"?
What kinds of method references do you know?
Explain the expression System.out::p rintln.
What are "functional interfaces"?
What are the Function<T, R>, DoubleFunction<R>, IntFunction<R>, and LongFunction<R> functional interfaces for?
What are the functional interfaces UnaryOperator<T>, DoubleUnaryOperator, IntUnaryOperator and LongUnaryOperator for?
What are the functional interfaces BinaryOperator<T>, DoubleBinaryOperator, IntBinaryOperator and LongBinaryOperator for?
What are the Predicate<T>, DoublePredicate, IntPredicate, and LongPredicate functional interfaces for?
What are the Consumer<T>, DoubleConsumer, IntConsumer, and LongConsumer functional interfaces for?
What are the Supplier<T>, BooleanSupplier, DoubleSupplier, IntSupplier and LongSupplier functional interfaces for?
What is the functional interface of BiConsumer<T,U>?
What is the functional interface of BiFunction<T,U,R>?
What is the functional interface of BiPredicate<T,U>?
What are functional interfaces of the _To_Function type for?
What are the ToDoubleBiFunction<T,U>, ToIntBiFunction<T,U> and ToLongBiFunction<T,U> functional interfaces for?
What are the ToDoubleFunction<T>, ToIntFunction<T>, and ToLongFunction<T> functional interfaces for?
What are the ObjDoubleConsumer<T>, ObjIntConsumer<T> and ObjLongConsumer<T> functional interfaces for?
What is a StringJoiner?
What are default interface methods?
How do you call the default method of an interface in a class that implements that interface?
What is a static interface method?
How do I call a static interface method?
What is Optional?
What is Stream?
What are the different ways to create a stream?
What is the difference between Collection and Stream?
What is the collect() method for in streams?
What are the forEach() and forEachOrdered() methods used for in streams?
What are the map() and mapToInt(), mapToDouble(), and mapToLong() methods used for in streams?
What is the purpose of the filter() method in streams?
What is the limit() method used for in streams?
What is the sorted() method used for in streams?
What are the flatMap(), flatMapToInt(), flatMapToDouble(), flatMapToLong() methods used for in streams?
Talk about parallel processing in Java 8.
What are the final methods of working with streams?
What intermediate methods of working with streams do you know?
How do you display 10 random numbers using forEach()?
How can I display unique squares of numbers using the map() method?
How do I display the number of blank lines using the filter() method?
How do I display 10 random numbers in ascending order?
How do you find the maximum number in a set?
How do I find the minimum number in a set?
How do you get the sum of all the numbers in a set?
How do you get the average of all numbers?
What additional methods for working with associative arrays (maps) have been introduced in Java 8?
What is LocalDateTime?
What is ZonedDateTime?
How do I get the current date using the Date Time API from Java 8?
How do I add 1 week, 1 month, 1 year, 10 years to the current date using the Date Time API?
How do I get next Tuesday using the Date Time API?
How do I get the second Saturday of the current month using the Date Time API?
How do I get the current time to the millisecond using the Date Time API?
How do I get the current local time to the millisecond using the Date Time API?
How do I identify repeatable annotation?
What is Nashorn?
What is jjs?
What class did Java 8 introduce for data encoding/decoding?
How to create a Base64 encoder and decoder?
Back To Top

Java I/O Threads
What is the difference between IO and NIO?
What features of NIO do you know?
What are "channels"?
What are the different types of I/O streams?
What are the main classes of I/O streams?
In which packets are the I/O stream classes located?
Which subclasses of the InputStream class do you know what they are for?
What is PushbackInputStream used for?
What is SequenceInputStream used for?
Which class allows you to read data from the input bytestream in the format of primitive data types?
Which subclasses of the OutputStream class do you know what they are for?
Which subclasses of the Reader class do you know what they are for?
Which subclasses of the Writer class do you know what they do?
What is the difference between the PrintWriter class and PrintStream?
What is the difference and what do InputStream, OutputStream, Reader, Writer have in common?
Which classes allow you to convert byte streams to character streams and vice versa?
Which classes allow you to speed up read/write by using a buffer?
Which class is designed to work with file system elements?
What methods of the File class do you know?
What do you know about the FileFilter interface?
How do I select all items in a specific catalog by criterion (for example, with a specific extension)?
What do you know about RandomAccessFile?
What file access modes does RandomAccessFile have?
Which classes support reading and writing compressed streams?
Is there a way to redirect standard I/O streams?
Which character is the separator when specifying a path in the file system?
What is the "absolute path" and the "relative path"?
What is a "symbolic link"?
Back To Top

Serialization
What is "serialization"?
Describe the serialization/deserialization process using Serializable.
How do I change the default serialization/deserialization behavior?
How do I exclude fields from serialization?
What does the keyword transient mean?
How do static and final field modifiers affect serializability?
How to prevent serialization?
How do I create my own serialization protocol?
What is the role of the serialVersionUID field in serialization?
When should I change the value of the serialVersionUID field?
What is the problem with serialization of Singleton?
What are the ways to control the values of a deserialized object?
Back To Top

Multithreading
Tell us about the Java memory model?
What is "thread safety"?
What is the difference between "competition" and "parallelism"?
What is "cooperative multitasking"? What type of multitasking does Java use? What is the reason for this choice?
What is ordering, as-if-serial semantics, sequential consistency, visibility, atomicity, happens-before, mutual exclusion, safe publication?
What is the difference between a process and a flow?
What are "green streams" and are they in Java?
How can I create a flow?
What is the difference between Thread and Runnable?
What is the difference between the start() and run() methods?
How do I force a flow to start?
What is a "monitor" in Java?
Define the concept of "synchronization".
What are the different ways to synchronize in Java?
What states can a thread be in?
Can I create new instances of a class while the static synchronized method is running?
Why do you need a private mutex?
How do the wait() and notify()/notifyAll() methods work?
What is the difference between notify() and notifyAll()?
Why are the wait() and notify() methods called only in a synchronized block?
What is the difference between the wait() method with and without the parameter?
What is the difference between the Thread.sleep() and Thread.yield() methods?
How does the Thread.join() method work?
What is deadlock?
What is livelock?
How do I check if a thread is holding a monitor for a specific resource?
On which object does synchronization occur when the static synchronized method is called?
What is the keyword volatile, synchronized, transient, native used for?
What are the differences between volatile and atomic variables?
What are the differences between java.util.concurrent.Atomic*.compareAndSwap() and java.util.concurrent.Atomic*.weakCompareAndSwap().
What does "flow priority" mean?
What are "demon flows"?
Can I make the main thread of a program a daemon?
What does it mean to "put to sleep" the stream?
What is the difference between the two Runnable and Callable interfaces?
What is FutureTask?
What are the differences between CyclicBarrier and CountDownLatch?
What is a race condition?
Is there a way to solve the race condition problem?
How to stop the flow?
Why is it not recommended to use the Thread.stop() method?
What happens when an exception is thrown in a thread?
What is the difference between interrupted() and isInterrupted()?
What is a "thread pool"?
What size should a thread pool be?
What happens if the thread pool queue is already full, but a new task is submitted?
What is the difference between the submit() and execute() methods of a thread pool?
What are the differences between a stack and a heap in terms of multithreading?
How do I share data between two streams?
What JVM startup option is used to control the size of a thread's stack?
How do I get a stream dump?
What is a ThreadLocal variable?
What are the differences between synchronized and ReentrantLock?
What is ReadWriteLock?
What is the "blocking method"?
What is a "Fork/Join framework"?
What is Semaphore?
What is a double checked locking Singleton?
How do I create a thread-safe Singleton?
Why are immutable objects useful?
What is a busy spin?
List the principles you follow in multithreaded programming?
Which of the following statements about flows is incorrect?
Are there 3 streams T1, T2 and T3? How to implement execution in the sequence T1, T2, T3?
Write a minimum non-blocking stack (there are only two methods, push() and pop()).
Write a minimal non-blocking stack (there are only two methods, push() and pop()) using Semaphore.
Write a minimal non-blocking ArrayList (there are four methods in total: add(), get(), remove(), size()).
Write a thread-safe implementation of the class with a non-blocking BigInteger next() method that returns sequence elements: [1, 2, 4, 8, 16, ...].
Write the simplest multithreaded bounded buffer using synchronized.
Write the simplest multithreaded bounded buffer using ReentrantLock.
Back To Top

Servlets, JSP, JSTL
What is a "servlet"?
What are the advantages of servlet technology over CGI (Common Gateway Interface)?
What is the structure of a web project?
What is a "servlet container"?
Why do I need application servers if I have servlet containers?
How does the servlet container manage the servlet lifecycle, when and what methods are called?
What is a "deployment descriptor"?
What steps do I need to do when creating servlets?
When do you want to override the service() method?
Does it make sense to define a constructor for the servlet? What is the best way to initialize data?
Why is it necessary to override only the init() method with no arguments?
What are the most common tasks performed in a servlet container?
What do you know about servlet filters?
Why do servlets use different listeners?
When should you use servlet filters and when should you use listeners?
How to implement the launch of the servlet at the same time as the launch of the application?
How do I handle exceptions thrown by another servlet in my application?
What is ServletConfig?
What is ServletContext?
What's the difference between ServletContext and ServletConfig?
What is the ServletResponse interface for?
What is the ServletRequest interface for?
What is a Request Dispatcher?
How do you call another servlet from one servlet?
What is the difference between sendRedirect() and forward()?
What are servlet attributes used for and how do you work with them?
How can you allow deadlock in the servlet?
How do I get the real location of the servlet on the server?
How do I get server information from a servlet?
How do I get the client's IP address on the server?
What servlet wrapper classes do you know?
What is the difference between GenericServlet and HttpServlet?
Why is the HttpServlet class declared as abstract?
What are the main methods in the HttpServlet class?
Should I worry about multithreaded security when working with servlets?
Which HTTP method is not immutable?
What are the methods for sending data from the client to the server?
What is the difference between the GET and POST methods?
What is the difference between PrintWriter and ServletOutputStream?
Can I use PrintWriter and ServletOutputStream in a servlet at the same time?
Talk about the SingleThreadModel interface.
What does URL encoding mean? How do you do this in Java?
What are the different methods of session management in servlets that you know?
What are cookies?
What are the methods for working with cookies in servlets?
What is URL Rewriting?
Why are encodeURL() and encodeRedirectURL() methods needed and what is the difference?
What is a "session"?
How do I notify an object in a session that the session is invalid or has ended?
What is an effective way to make sure that all servlets are available only to the user with the correct session?
How can we provide transport layer security for our web application?
How to organize a connection to the database, provide logging in the servlet?
What are the main features of the Servlet 3 specification?
What authentication methods are available to the servlet?
What is Java Server Pages (JSP)?
Why do you need a JSP?
Describe how JSP pages are processed, from the request to the server to the response to the user.
Tell us about the stages (phases) of the JSP life cycle.
Talk about JSP lifecycle methods.
Which JSP lifecycle methods can be overridden?
How can I prevent direct access to a JSP page from a browser?
What is the difference between dynamic and static JSP content?
How do I comment out code in JSP?
What are the main types of JSP tags?
What do you know about JSP actions (Action tag and JSP Action Elements).
JSP - servlet - JSP interaction.
What variable scopes exist in JSP?
What implicit, internal objects and methods are there on a JSP page?
What implicit objects are not available in a regular JSP page?
What do you know about PageContext and what are the benefits of using it?
How do I configure the initialization parameters for JSP?
Why is it not recommended to use scripts in JSP?
Is it possible to define a class inside a JSP page?
What do you know about the JSP Expression Language (EL)?
What types of EL operators do you know?
Name implicit, internal JSP EL objects and how they differ from JSP objects.
How do I disable the ability to use EL in JSP?
How do I find out the type of HTTP method using JSP EL?
What is JSTL (JSP Standard tag library)?
What are the tag groups that make up the JSTL library?
What's the difference between <c:set> and <jsp:useBean>?
What's the difference between <c:import> and <jsp:include> and the <%@include%> directive?
How can I extend the functionality of JSP?
How much do you know about writing custom JSP tags?
Give an example of using custom tags.
How do I break a line in HTML using JSP?
Why don't I need to configure standard JSP tags in web.xml?
How can JSP page errors be handled?
How does JSTL handle errors?
How JSP is configured in the deployment descriptor.
Can I use Javascript on a JSP page?
Is a session object always created on a JSP page, is it possible to disable its creation?
What is the difference between JSPWriter and Servlet PrintWriter?
Describe general JSP best practices.
Back To Top

Database
What is a "database"?
What is a "database management system"?
What is a "relational data model"?
Define the terms "simple," "composite," "candidate," and "alternate."
What is a "primary key"? What are the criteria for choosing him?
What is a "foreign key"?
What is "normalization"?
What are the normal forms?
What is "denormalization"? What is it used for?
What are the different types of relationships in a database? Give examples.
What are "indices"? What are they used for? What are their advantages and disadvantages?
What types of indices are there?
What is the difference between clustered and non-clustered indexes?
Does it make sense to index data that has a small number of possible values?
When is a full dataset scan more cost-effective than index access?
What is a "transaction"?
What are the main properties of the transaction?
What are the levels of transaction isolation?
What are the problems with transactional concurrent access?
Back To Top

SQL
What is SQL?
What are the different types of SQL statements?
What does NULL mean in SQL?
What is a "temporary table"? What is it used for?
What is a "view" and what is it used for?
What is the general syntax of the SELECT statement?
What is JOIN?
What are the different types of JOINs?
Is it better to use JOINs or subqueries?
What is the HAVING operator used for?
What's the difference between HAVING and WHERE statements?
What is the ORDER BY operator used for?
What is the GROUP BY operator used for?
How does GROUP BY handle null?
What is the difference between GROUP BY and DISTINCT operators?
List the main aggregate functions.
What is the difference between COUNT(*) and COUNT({column})?
What does the EXISTS operator do?
What are the IN, BETWEEN, LIKE operators used for?
What is the UNION keyword used for?
What are the integrity constraints in SQL?
What are the differences between the PRIMARY and UNIQUE limits?
Can a value in a column that has a FOREIGN KEY constraint be null?
How do I create an index?
What does the MERGE statement do?
What's the difference between DELETE and TRUNCATE?
What is a "stored procedure"?
What is a "trigger"?
What is a "cursor"?
Describe the difference between the DATETIME and TIMESTAMP data types.
For which numeric types is it unacceptable to use addition/subtraction operations?
What is the purpose of the PIVOT and UNPIVOT operators in Transact-SQL?
Tell us about the main ranking functions in Transact-SQL.
What are the INTERSECT and EXCEPT statements used for in Transact-SQL?
Write a request...
Back To Top

JDBC
What is JDBC?
What are the benefits of using JDBC?
What is a JDBC URL?
What are the parts of JDBC?
List the main data types used in JDBC. How are they related to Java types?
Describe the main steps in working with a database using JDBC.
How do I register a JDBC driver?
How do I establish a database connection?
What levels of transaction isolation are supported in JDBC?
How are database queries generated?
What is the difference between a Statement and a PreparedStatement?
How is the database queried and the results processed?
How do I call a stored procedure?
How do I close the database connection?
Back To Top

Testing
What is "unit testing"?
What is "integration testing"?
How is integration testing different from unit testing?
What are the different types of test objects?
How is stub different from mock?
What are "fixtures"?
What fixture annotations are there at JUnit?
What does JUnit use @Ignore annotation for?
Back To Top

Logging
What are the different types of logs?
What are the parts of a log4j logging system?
What is Logger in log4j?
What is Appender in log4j?
What is Layout in log4j?
List logging levels in log4j? Name the order of their priority.
What are the different ways to configure log4j?
Back To Top

UML
What is UML?
What are "diagram", "notation" and "metamodel" in UML?
What are the different types of charts?
What kinds of relationships exist in a structural class diagram?
Back To Top

XML
What is XML?
What is a DTD?
How is well-formed XML different from valid XML?
What is a "namespace" in XML?
What is XSD? What are its advantages over the XML DTD?
What types are there in XSD?
What methods of reading XML do you know? Describe the strengths and weaknesses of each method.
When should you use DOM and when should you use SAX, StAX analyzers?
What ways do you know how to write XML?
What is JAXP?
What is XSLT?
Back To Top

Design patterns
What is a "design pattern"?
What are the main characteristics of templates?
Types of design patterns.
Give examples of key design patterns.
Give examples of generative design patterns.
Give examples of structural design patterns.
Give examples of behavioral design patterns.
What is an "anti-pattern"? What anti-patterns do you know?
What is Dependency Injection?
Back To Top

HTML Basics
What is "HTML"?
What is "XHTML"?
What is DOCTYPE and why do I need it?
What is the <head> tag for?
What is the difference between <div> and <span>?
How are comments labeled in HTML?
How do I set the address of the document to which I should go?
How do I link to an email address?
What is the <em> tag for?
What are <ol>, <ul>, <li> tags for?
What are <dl>, <dt>, <dd> tags for?
What are <tr>, <th>, <td> tags for?
Is it necessary to write the alt attribute in the <img> tag?
What is the best case to write HTML code in?
What is an "entity"?
Back To Top

CSS Basics
What is "CSS"?
How are comments labeled in CSS?
What is a "selector"?
List the main types of selectors.
What is a pseudoclass?
What are the attribute selectors?
What is the difference between #my and .my?
What is the difference between margin and padding?
What is the difference between the values of 0 and auto in the margin property?
What property sets the background color?
How do I remove underscores for all links on a page?
What is the clear property used for?
How do I make text bold in all elements <p>?
How do I set the red color for all elements that have the red class?
Back To Top

Basics WEB
What is WWW?
What is W3C?
What are the different layers of the OSI model?
What is TCP/IP?
What is UDP?
What is the difference between TCP and UDP?
What is a data transfer protocol? What protocols do you know?
What are HTTP and HTTPS? How do they differ?
What is FTP?
What is the difference between the GET and POST methods?
What is a MIME type?
What is a Web server?
What is Web application?
What is Application server?
What is the difference between Web server and Application server?
What is AJAX? How does this technology work in principle?
What is WebSocket?
What is JSON?
What is a JSON schema?
What are cookies?
What is a "session"?
What are "authorization" and "authentication"? How do they differ?
Back To Top

Further reading
4 sensible Youtube channels about technical interviews
A list of fancy questions I've been asked during the interviews I had
Job interview in English: how to prepare and what to answer
Senior Engineer in search of a job. About tasks at technical interviews and theoretical questions
What to ask an interviewer during a tech interview
Spring Boot Interview Questions
Top Spring Framework Interview Questions
Back To Top

Sources
Junior Java Developer Interview Questions


