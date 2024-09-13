# Chapter12\P226_InitializingOptional\Main.java

```java
package Chapter12.P226_InitializingOptional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Avoid
        Optional<Book> book1 = null;

        // Prefer
        Optional<Book> book2 = Optional.empty();
    }
}
```
