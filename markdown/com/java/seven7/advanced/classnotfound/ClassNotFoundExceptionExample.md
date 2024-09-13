# com\java\seven7\advanced\classnotfound\ClassNotFoundExceptionExample.java

```java
package com.java.seven7.advanced.classnotfound;

public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
