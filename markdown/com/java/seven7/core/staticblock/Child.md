# com\java\seven7\core\staticblock\Child.java

```java
package com.java.seven7.core.staticblock;

// Child Class
public class Child extends Parent {
    {
        System.out.println("This is child block!");
    }

    public Child() {
        super();
        System.out.println("Child Constructor is Called.");
    }
}
```
