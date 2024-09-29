# Chapter12\P242_OptionalOfAndOfNullable\Bookstore.java

```java
package Chapter12.P242_OptionalOfAndOfNullable;

import java.util.Optional;

public class Bookstore {

    // Avoid
    public Optional<String> isbnAvoid(String bookId) {

        // the fetched "isbn" can be null for the given "bookId"
        String isbn = null;

        return Optional.of(isbn); // this throws NPE if "isbn" is null :(
    }

    // Prefer
    public Optional<String> isbnPrefer(String bookId) {

        // the fetched "isbn" can be null for the given "bookId"
        String isbn = null;

        return Optional.ofNullable(isbn); 
    }
}
```
