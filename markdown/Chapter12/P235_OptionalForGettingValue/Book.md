# Chapter12\P235_OptionalForGettingValue\Book.java

```java
package Chapter12.P235_OptionalForGettingValue;

import java.util.Optional;

public class Book {

    public static final String BOOK_STATUS = "UNKNOWN";

    // Avoid
    public String findStatusAvoid() {

        // fetch a status prone to null
        String status = null;

        return Optional.ofNullable(status).orElse(BOOK_STATUS);
    }

    // Prefer
    public String findStatusPrefer() {

        // fetch a status prone to null
        String status = null;

        return status == null ? BOOK_STATUS : status;
    }
}
```
