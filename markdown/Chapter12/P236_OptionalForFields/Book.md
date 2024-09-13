# Chapter12\P236_OptionalForFields\Book.java

```java
package Chapter12.P236_OptionalForFields;

import java.util.Optional;

public class Book {

    // Avoid
    private Optional<String> title1;
    private Optional<String> subtitle1 = Optional.empty();

    // Prefer
    private String title2;
    private String subtitle2 = "";
}
```
