### 1. What is an immutable class in Java?
An immutable class in Java is a class whose instances cannot be modified once they are created. Once an immutable object is instantiated, its state remains constant throughout its lifetime. This means that the values of its fields cannot be changed, and any attempt to modify them results in the creation of a new object.

### 2. What are the advantages of using immutable classes?

**Thread Safety**: Immutable objects inherently guarantee thread safety by disallowing state modification after creation, removing the necessity for synchronization mechanisms.

**Consistent State**: Immutable objects maintain a constant state throughout their existence, facilitating clearer understanding of program behavior and minimizing unexpected state alterations.

**Secure Sharing**: Immutable objects permit secure sharing across multiple threads or components, ensuring code reusability and seamless interoperability without the risk of unintended modification.

**Concurrency Control**: Immutable objects alleviate the need for intricate concurrency control mechanisms, leading to more straightforward and scalable concurrent programming models.

### 3. Can you provide some examples of immutable classes from the Java standard library?

i. java.lang.String

ii. java.lang.Integer, java.lang.Double, java.lang.Boolean etc

iii. java.lang.Character

iv. java.time.LocalDate, java.time.LocalDateTime, java.time.LocalTime

v. java.time.Duration, java.time.Period

vi. java.math.BigInteger, java.math.BigDecimal

vii. java.awt.Color

### 4. What are the potential drawbacks of using immutable classes?

While immutable classes offer benefits like thread safety and predictable behavior, they may have drawbacks. These include increased memory usage and performance impact due to creating new instances for each modification. Immutability can also add complexity to the codebase and limit flexibility in certain scenarios. Additionally, defensive copying overhead and garbage collection issues may arise. However, the advantages of immutability often outweigh these drawbacks in many programming scenarios.

### 5. Can you discuss scenarios where immutability might not be suitable?

Immutability might not be suitable in scenarios where frequent modifications to object state are necessary for performance or functionality reasons. For example, in applications dealing with real-time data processing, such as video streaming or gaming, where constant updates to mutable state are required for responsiveness. Additionally, in scenarios involving large-scale data manipulation or complex algorithms, immutability may lead to increased memory usage and performance overhead. Similarly, when interoperability with libraries or frameworks that expect mutable objects is essential, immutability might not be the best choice.

### 6. What precautions should you take while designing an immutable class?

i. Declare the Class as Final: Make the class final to prevent subclassing, ensuring that the behavior of the class cannot be altered.

ii. Declare Fields as Final: Declare all fields as final to ensure they cannot be modified after object creation.

iii. Make Fields Private: Encapsulate fields by making them private, allowing controlled access through getter methods only.

iv. Do Not Provide Setter Methods: Avoid providing setter methods that modify the state of the object, as this would violate immutability.

v. Ensure Deep Immunity: Ensure that the class maintains immutability even if it contains references to mutable objects. Implement defensive copying or use immutable versions of referenced objects if needed.

vi. Override Equals and HashCode: Implement proper equals() and hashCode() methods based on the object’s state to ensure correct behavior in collections and comparisons.

### 7. Write a Java class that implements the concept of immutability.

```java
 public final class BankAccount {
 
 private final String accountNumber;
 private final String accountHolderName;
 private final double balance;
 
 public BankAccount(String accountNumber, String accountHolderName, double balance) {
 
 this.accountNumber = accountNumber;
 this.accountHolderName = accountHolderName;
 this.balance = balance;
 }
 
 public String getAccountNumber() {
 return accountNumber;
 }
 
 public String getAccountHolderName() {
 return accountHolderName;
 }
 
 public double getBalance() {
 return balance;
 }
 
 }
```
### 8. How do you ensure immutability in an immutable class with mutable fields like Date?

```java
 import java.util.Date;
 
 public final class ImmutableWithMutableField {
 
 private final int id;
 private final Date date;
 
 public ImmutableWithMutableField(int id, Date date) {
 
 this.id = id;
 this.date = new Date(date.getTime());
 }
 
 public int getId() {
 return id;
 }
 
 public Date getDate() {
 return new Date(date.getTime());
 }
 
 @Override
 public String toString() {
 return "ImmutableWithMutableField [id=" + id + ", date=" + date + "]";
 }
 
 // testing
 
 public static void main(String[] args) throws InterruptedException {
 
 ImmutableWithMutableField a = new ImmutableWithMutableField(1, new Date());
 
 System.out.println(a);
 Thread.sleep(3000);
 System.out.println(a);
 Thread.sleep(1000);
 ImmutableWithMutableField a1 = new ImmutableWithMutableField(1, new Date());
 System.out.println(a1);
 Thread.sleep(1000);
 ImmutableWithMutableField a2 = new ImmutableWithMutableField(1, new Date());
 System.out.println(a2);
 
 }
 
 }
```
Result:


### 9. How would you handle mutable collections in an immutable class?

```java
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;
 
 public final class ImmutableWithMutableCollection {
 
 private final int id;
 private final List<String> mutableList;
 
 public ImmutableWithMutableCollection(int id, List<String> mutableList) {
 
 this.id = id;
 this.mutableList = new ArrayList<>(mutableList);
 }
 
 public int getId() {
 return id;
 }
 
 public List<String> getMutableList() {
 return Collections.unmodifiableList(mutableList);
 }
 
 }
```
### 10. How would you handle mutable objects reference in an immutable class?

```java
 public class MutableClass {
 private String name;
 
 public MutableClass(String name) {
 this.name = name;
 }
 
 public String getName() {
 return name;
 }
 
 public void setName(String name) {
 this.name = name;
 }
 
 @Override
 public String toString() {
 return "MutableClass [name=" + name + "]";
 }
 
 }
 public final class ImmutableClass {
 
 private final MutableClass mutable;
 private final String city;
 
 public ImmutableClass(MutableClass mutable, String city) {
 
 this.mutable = new MutableClass(mutable.getName());
 this.city = city;
 }
 
 public MutableClass getMutable() {
 return mutable;
 }
 
 public String getCity() {
 return city;
 }
 
 @Override
 public String toString() {
 return "ImmutableClass [mutable=" + mutable + ", city=" + city + "]";
 }
 
 public static void main(String[] args) {
 
 MutableClass m = new MutableClass("Abhishek");
 ImmutableClass i = new ImmutableClass(m, "Mumbai");
 
 System.out.println(i);
 m.setName("Appu");
 System.out.println(i);
 
 }
 
 }
```
Result

### 11. Explain defensive copying.

Defensive copying is a programming technique used to protect against unintended modifications to mutable objects by creating copies of them. When dealing with mutable data structures or objects, defensive copying involves creating a duplicate instance of the object and working with the copy instead of the original. This ensures that changes made to the copy do not affect the original object’s state, maintaining data integrity and preventing unexpected side effects. Defensive copying is commonly employed in scenarios where immutability is desired or when sharing data between different parts of a program to maintain consistency and prevent concurrency issues.

### 12 . What are stateless objects ? How are they different from immutable objects ? Which of these two is thread safe ?

Stateless objects are the objects without instance fields (instance variables). The class may have compile time constants i.e static final fields .Immutable objects are the objects which have state but the state cannot be changed after initialization. Both are Thread safe.

### 13. What makes immutable objects advantageous as keys in HashMaps?

Immutable objects are advantageous as keys in HashMaps due to their inherent stability. Since their state cannot be modified after creation, their hash code remains constant throughout their lifecycle. This property ensures that the key’s hash code remains consistent, making it reliable for hashing and efficient retrieval of values from the HashMap. Additionally, immutability guarantees that the key’s state won’t change unexpectedly, preventing issues such as key collisions or unexpected behavior in hash-based data structures like HashMaps. This stability and predictability make immutable objects ideal for ensuring the integrity and efficiency of HashMaps.
