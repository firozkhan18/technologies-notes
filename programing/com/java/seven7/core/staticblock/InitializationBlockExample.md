# com\java\seven7\core\staticblock\InitializationBlockExample.java

```java
package com.java.seven7.core.staticblock;

public class InitializationBlockExample {
    {
        System.out.println("This is Initialization Block!");
    }
    public InitializationBlockExample() {
        System.out.println("Hi, I'm Constructor!");
    }

    public static void main(String[] args) {
        InitializationBlockExample object1 = new InitializationBlockExample();
    }
}
```
