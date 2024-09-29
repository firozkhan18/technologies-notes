# Optional in Java

Java 8 has introduced a new class Optional in java.util package. It is used to represent a value is present or absent. The main advantage of this new construct is that No more too many null checks and NullPointerException. It avoids any runtime NullPointerExceptions and supports us in developing clean and neat Java APIs or Applications. Like Collections and arrays, it is also a Container to hold at most one value. Let us explore this new construct with some useful examples.

## What is Optional?

`Optional` is a container object that may or may not contain a non-null value. It was introduced in Java 8 as part of the `java.util` package to represent optional values and to deal with the problem of null references in a more effective and expressive way.

## Why Optional?

Prior to the introduction of `Optional` in Java 8, handling null values often led to NullPointerExceptions (NPEs), which could be difficult to debug and manage. `Optional` provides a more explicit and safer way to handle the absence of a value, reducing the likelihood of NPEs and improving code clarity and robustness.

## Before Optional

Before the introduction of `Optional`, developers commonly used null references to represent the absence of a value. This approach often resulted in code that was hard to read, maintain, and debug. Null checks were required everywhere, leading to verbose and error-prone code. Additionally, it was not always clear whether a method could return null or not, making it challenging to reason about the behavior of the code.

## Problems Solved by Optional

### 1. Null Pointer Safety
- `Optional` provides a safer alternative to null references, reducing the risk of NullPointerExceptions and improving code reliability.

### 2. Improved Code Readability
- By using `Optional`, code becomes more expressive and self-documenting, as it clearly indicates whether a value may be absent or present.

### 3. Forced Null Checking
- `Optional` encourages developers to explicitly handle the case of a missing value, either by providing a default value or performing an alternative action, thus promoting defensive programming practices.

### Advantages of Java 8 Optional:

- Null checks are not required.
- No more NullPointerException at run-time.
- We can develop clean and neat APIs.
- No more Boiler plate code

## Basic Methods

### Creation:
- `Optional.of(T value)`: Creates an `Optional` with the specified non-null value, throwing a NullPointerException if the value is null.
- `Optional.ofNullable(T value)`: Creates an `Optional` with the specified value, which may be null.

### Checking for Presence:
- `isPresent()`: Returns true if the `Optional` contains a non-null value.
- `isEmpty()`: Returns true if the `Optional` is empty.

### Getting the Value:
- `get()`: Returns the value if present, otherwise throws a NoSuchElementException.

### Conditional Retrieval:
- `orElse(T other)`: Returns the value if present, otherwise returns the specified default value.
- `orElseGet(Supplier<? extends T> other)`: Returns the value if present, otherwise invokes the specified supplier and returns its result.
- `orElseThrow()`: Returns the value if present, otherwise throws the specified exception.

### Mapping and Filtering:
- `map(Function<? super T, ? extends U> mapper)`: Applies the specified mapping function to the value if present.
- `flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)`: Applies the specified mapping function to the value if present and returns the result.
- `filter(Predicate<? super T> predicate)`: If a value is present, applies the given predicate to it, and returns an `Optional` describing the value if the predicate returns true.

### Utility Methods:
- `ifPresent(Consumer<? super T> consumer)`: If a value is present, performs the given action with the value.
- `ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)`: If a value is present, performs the given action with the value, otherwise performs the specified empty action.
- `equals(Object obj)`: Indicates whether some other object is "equal to" this Optional.

### 1. Optional Basic example
Optional.ofNullable() method returns a Non-empty Optional if a value present in the given object. Otherwise returns empty Optional.

Optional.empty() method is useful to create an empty Optional object.

OptionalBasicExample.java
```java
import java.util.Optional;

public class OptionalBasicExample {

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
        
        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
    }
}

Output


Non-Empty Optional:Optional[MALE]
Non-Empty Optional: Gender value : MALE
Empty Optional: Optional.empty

ofNullable on Non-Empty Optional: Optional[Yes]
ofNullable on Empty Optional: Optional.empty

Exception in thread "main" java.lang.NullPointerException
	at java.util.Objects.requireNonNull(Objects.java:203)
	at java.util.Optional.<init>(Optional.java:96)
	at java.util.Optional.of(Optional.java:108)
	//...
```
### 2. Optional.map and flatMap
OptionalMapFlapMapExample.java
```java

import java.util.Optional;

public class OptionalMapFlapMapExample {

    public static void main(String[] args) {

        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOtionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender -> gender.map(String::toUpperCase)));        
    }
}

Output

Non-Empty Optional:: Optional[MALE]
Empty Optional    :: Optional.empty
Optional value   :: Optional[Optional[male]]
Optional.map     :: Optional[Optional[MALE]]
Optional.flatMap :: Optional[MALE]
```
### 3. Optional.filter
OptionalFilterExample.java
```java
import java.util.Optional;

public class OptionalFilterExample {

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        //Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty
    }
}

Output

Optional.empty
Optional[MALE]
Optional.empty
```
### 4. Optional isPresent and ifPresent
Optional.isPresent() returns true if the given Optional object is non-empty. Otherwise it returns false.

Optional.ifPresent() performs given action if the given Optional object is non-empty. Otherwise it returns false.

OptionalIfPresentExample.java
```java
import java.util.Optional;

public class OptionalIfPresentExample {

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        if (gender.isPresent()) {
            System.out.println("Value available.");
        } else {
            System.out.println("Value not available.");
        }

        gender.ifPresent(g -> System.out.println("In gender Option, value available."));

        //condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
    }
}

Output

Value available.
In gender Option, value available.
```

### 5. Optional orElse methods
It returns the value if present in Optional Container. Otherwise returns given default value.

OptionalOrElseExample.java
```java

import java.util.Optional;

public class OptionalOrElseExample {

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        System.out.println(gender.orElse("<N/A>")); //MALE
        System.out.println(emptyGender.orElse("<N/A>")); //<N/A>

        System.out.println(gender.orElseGet(() -> "<N/A>")); //MALE
        System.out.println(emptyGender.orElseGet(() -> "<N/A>")); //<N/A>
    }
}

Output

MALE
<N/A>
MALE
<N/A>
```
### 6. Without Java 8 Optional
As everyone is familiar with Online Shopping. Let us assume that we want to implement a Mobile Product Module for a famous e-Commerce website.

Let us implement Mobile Domain module Without Java 8 Optional.

ScreenResolution.java
```java

public class ScreenResolution {

	private int width;
	private int height;
	
	public ScreenResolution(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}	
}
```
DisplayFeatures.java
```java
public class DisplayFeatures {

	private String size; // In inches
	private ScreenResolution resolution;
	
	public DisplayFeatures(String size, ScreenResolution resolution){
		this.size = size;
		this.resolution = resolution;
	}
	
	public String getSize() {
		return size;
	}
	public ScreenResolution getResolution() {
		return resolution;
	}
}
```
Mobile.java
```java

public class Mobile {

	private long id;
	private String brand;
	private String name;
	private DisplayFeatures displayFeatures;
	// Likewise we can see Memory Features, Camera Features etc.
	
	public Mobile(long id, String brand, String name, 
                            DisplayFeatures displayFeatures){
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.displayFeatures = displayFeatures;
	}
	public long getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public String getName() {
		return name;
	}
	public DisplayFeatures getDisplayFeatures() {
		return displayFeatures;
	}	
}
```
Here if we observe getMobileScreenWidth() method, it has lot of boiler plate code with lots null checks. Before Java 8, we should do all these non-sense stuff to avoid Runtime NullPointerExceptions.

MobileService.java
```java

public class MobileService {
	
	public int getMobileScreenWidth(Mobile mobile){

		if(mobile != null){
			DisplayFeatures dfeatures = mobile.getDisplayFeatures();
			if(dfeatures != null){
				ScreenResolution resolution = dfeatures.getResolution();
				if(resolution != null){
					return resolution.getWidth();
				}
			}
		}
		return 0;
	}
}
```
Develop one test application to test these Domain objects.

MobileTesterWithoutOptional.java
```java

public class MobileTesterWithoutOptional {
	
	public static void main(String[] args) {

		ScreenResolution resolution = new ScreenResolution(750,1334);
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", resolution);
		Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", dfeatures);
		
		MobileService mService = new MobileService();
		
		int mobileWidth = mService.getMobileScreenWidth(mobile);
		System.out.println("Apple iPhone 6s Screen Width = " + mobileWidth);
		
		ScreenResolution resolution2 = new ScreenResolution(0,0);
		DisplayFeatures dfeatures2 = new DisplayFeatures("0", resolution2);
		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", dfeatures2);		
		int mobileWidth2 = mService.getMobileScreenWidth(mobile2);
		System.out.println("Apple iPhone 16s Screen Width = " + mobileWidth2);

	}
}

Output

Apple iPhone 6s Screen Width = 750
Apple iPhone 16s Screen Width = 0
```
### 7. With Java 8 Optional
Now develop same domain models using Java 8 Optional construct with clean and neat way.

P.S ScreenResolution.java no change. Please refer above section.

DisplayFeatures.java
```java
package com.mkyong.with.optional;

import java.util.Optional;

public class DisplayFeatures {

	private String size; // In inches
	private Optional&lt;ScreenResolution&gt; resolution;
	
	public DisplayFeatures(String size, Optional<ScreenResolution> resolution){
		this.size = size;
		this.resolution = resolution;
	}
	
	public String getSize() {
		return size;
	}
	public Optional<ScreenResolution> getResolution() {
		return resolution;
	}	
}
```
Mobile.java
```java
package com.mkyong.with.optional;

import java.util.Optional;

public class Mobile {

	private long id;
	private String brand;
	private String name;
	private Optional&lt;DisplayFeatures&gt; displayFeatures;
	// Like wise we can see MemoryFeatures, CameraFeatures etc.
	// For simplicity, using only one Features
	
	public Mobile(long id, String brand, String name, Optional&lt;DisplayFeatures&gt; displayFeatures){
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.displayFeatures = displayFeatures;
	}

	public long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getName() {
		return name;
	}

	public Optional&lt;DisplayFeatures&gt; getDisplayFeatures() {
		return displayFeatures;
	}	
}
```
Here we can observe that how clean our getMobileScreenWidth() API without null checks and boiler plate code. We don not worry about NullPointerExceptions at run-time.

MobileService.java
```java

import java.util.Optional;

public class MobileService {

  public Integer getMobileScreenWidth(Optional<Mobile> mobile){
	return mobile.flatMap(Mobile::getDisplayFeatures)
		 .flatMap(DisplayFeatures::getResolution)
		 .map(ScreenResolution::getWidth)
		 .orElse(0);

  }
}
```
Now develop one test component

MobileTesterWithOptional.java
```java

import java.util.Optional;

public class MobileTesterWithOptional {
	
  public static void main(String[] args) {
	ScreenResolution resolution = new ScreenResolution(750,1334);
	DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
	Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
		
	MobileService mService = new MobileService();
		
	int width = mService.getMobileScreenWidth(Optional.of(mobile));
	System.out.println("Apple iPhone 6s Screen Width = " + width);

	Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());		
	int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
	System.out.println("Apple iPhone 16s Screen Width = " + width2);
  }
}

Output

Apple iPhone 6s Screen Width = 750
Apple iPhone 16s Screen Width = 0
```
### 8. Where does Java Optional fits?
If we observe above real-time Retail Domain use-case, we should know that Java Optional construct is useful at the following places.

#### 8.1 Method Parameter
```java
public void setResolution(Optional<ScreenResolution> resolution) {
	this.resolution = resolution;
}
```
#### 8.2 Method Return Type
```java
public Optional<ScreenResolution> getResolution() {
	return resolution;
}
```
#### 8.3 Constructor Parameter
```java
public DisplayFeatures(String size, Optional<ScreenResolution> resolution){
	this.size = size;
	this.resolution = resolution;
}
```
#### 8.4 Variable Declaration
```java
private Optional<ScreenResolution> resolution;
```
#### 8.5 Class Level
```java
public class B

public class A<T extends Optional<B>> { }
```

### Real Time Example

```java
import java.util.List;
import java.util.Optional;

public class Customer {

    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;

    public Customer() {
    }

    public Customer(int id, String name, String email, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
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

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
```

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDataBase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }
}
```
```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = EkartDataBase.getAll();
       return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(()->new Exception("no customer present with this email id"));
    }

    public static void main(String[] args) throws Exception {

        Customer customer=new Customer(101, "john", "test@gmail.com", Arrays.asList("397937955", "21654725"));

        //empty
        //of
        //ofNullable

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        //Optional<String> emailOptional = Optional.of(customer.getEmail());
        //System.out.println(emailOptional);

        Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
       /* if(emailOptional2.isPresent()){
            System.out.println(emailOptional2.get());
        }*/
       // System.out.println(emailOptional2.orElse("default@email.com"));

       // System.out.println(emailOptional2.orElseThrow(()->new IllegalArgumentException("email not present")));

        System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()->"default email..."));

        getCustomerByEmailId("pqr");
    }
}
```
## Conclusion

`Optional` provides a more structured and reliable approach to handling optional values in Java, addressing common pitfalls associated with null references. By encouraging explicit handling of absent values and providing a rich set of methods for working with optionals, `Optional` improves code clarity, safety, and maintainability.


### Null Handling : Before & After Java 8
Null represents an absence of a value. Before Java 8, if-constructs are used to handle the null values. For example, have a look at the below code.

```java
class Person
{
    House house;
     
    public House getHouse() 
    {
        return house;
    }
}
 
class House
{
    HouseLoan houseLoan;
     
    public HouseLoan getHouseLoan() 
    {
        return houseLoan;
    }
}
 
class HouseLoan
{
    String houseLoanDetails;
     
    public String getHouseLoanDetails() 
    {
        return houseLoanDetails;
    }
}
```
In the above example, if Person doesn’t own a House, then the value of house will be absent. If Person owns a House and that House is not built with HouseLoan, then the value of houseLoan will be absent.

Below code shows how the absence of values are handled using if-constructs to avoid NullPointerException.
```java

Person person = new Person();
         
        //Null check for person
         
        if (person != null)
        {
            House house = person.getHouse();
             
            //Null check for house
             
            if (house != null)
            {
                HouseLoan houseLoan = house.getHouseLoan();
                 
                //Null check for houseLoan
                 
                if (houseLoan != null) 
                {
                    System.out.println(houseLoan.getHouseLoanDetails());
                }
            }
        }
```
You can notice that for each null check, an extra if-construct is required. It makes code more imprecise and less readable. And it also doesn’t solve the NullPointerException. It just hides it and transfers it to the next level.

Java 8 provides most efficient way to handle the absence of a value. What you have to do is, whenever you feel that a particular property may not contain a value, you declare it as Optional.

For example, in the above example, house property of Person class may not contain a value, then you have to declare it as an Optional of House type. And same applies to houseLoan property of House class.

Below is the modified code with Java 8 Optional class.

```java

class Person
{
    //house declared as an Optional
     
    Optional<House> house;     
     
    public Optional<House> getHouse() 
    {
        return house;
    }
}
 
class House
{
    //houseLoan declared as an Optional
     
    Optional<HouseLoan> houseLoan;
     
    public Optional<HouseLoan> getHouseLoan() 
    {
        return houseLoan;
    }
}
 
class HouseLoan
{
    String houseLoanDetails;
     
    public String getHouseLoanDetails() 
    {
        return houseLoanDetails;
    }
}
```
## Working With Java 8 Optional Class :

### 1) Instantiation :

**Optional.empty()** : It creates an empty optional object.

> Optional<House> house = Optional.empty();

**Optional.of()** : It creates an Optional object with specified non-null value.

> Optional<House> house = Optional.of(new House());

**Optional.ofNullable()** : It creates an Optional object with specified value if the value is non-null. If the value is null, it returns an empty Optional.

> House house = new House();
> 
> Optional<House> optionalHouse = Optional.ofNullable(house);


### 2) Extraction :

**get()** : This method returns the value present in the Optional object. If the value is absent, throws NoSuchElementException.

> Optional<House> optionalHouse = Optional.of(new House());
> 
> optionalHouse.get();

**orElse()** : It Returns the value present in the Optional object. If the value is absent, returns the supplied value.

> Optional<House> optionalHouse = Optional.of(new House());
> 
> optionalHouse.orElse(new House());

**ifPresent()** : Performs the specified action if the value is present, otherwise no action taken.

> Optional<House> optionalHouse = Optional.of(new House());
> 
> optionalHouse.ifPresent((House house) -> house.getHouseLoan());

**isPresent()** : Returns true if the value is present, otherwise returns false.

> Optional<House> optionalHouse = Optional.ofNullable(new House());
> 
> System.out.println(optionalHouse.isPresent()); //Output : true

**orElseGet()** : Returns the value if the value is present, otherwise returns result of specified supplier.

> Optional<House> optionalHouse = Optional.ofNullable(new House());
> 
> optionalHouse.orElseGet(() -> new House());

**orElseThrow()** : Returns the value if the value is present, otherwise throws an exception created by the specified supplier.

> Optional<House> optionalHouse = Optional.ofNullable(new House());
> 
> optionalHouse.orElseThrow(() -> new NoSuchElementException());

### 3) Mapping & Filtering :

**map()** : If the value is present, applies given mapping function to it and if the result is null, returns empty Optional. Otherwise returns Optional containing the result.

> Optional<House> optionalHouse = Optional.ofNullable(new House());
> 
> optionalHouse.map((House house) -> house.getHouseType());

**flatMap()** : This method is similar to above map() method. But, it is used when mapper function returns another Optional as a result and you don’t want to wrap it in another Optional.

> Optional<House> optionalHouse = Optional.ofNullable(new House());
> 
> optionalHouse.flatMap(House::getHouseLoan).map(HouseLoan::getHouseLoanDetails);

**filter()** : If the value is present and that value matches with the given predicate, then it returns Optional containing the result. Otherwise returns empty Optional.

> Optional<House> optionalHouse = Optional.ofNullable(new House());
> 
> optionalHouse.filter((House house) -> house.getHouseType() == “Heritage”)
> 
> .flatMap(House::getHouseLoan)
> 
> .map(HouseLoan::getHouseLoanDetails);
