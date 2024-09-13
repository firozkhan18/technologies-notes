# com\java\eight8\employee\management\GreetingService.java

```java
package com.java.eight8.employee.management;

/**
 * A service that greets you.
 */
public interface GreetingService {

    static String greet() {
        return "Hello World!";
    }

    public static void main(String[] args) {
		System.out.println(greet());
	}
}
```
