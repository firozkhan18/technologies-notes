# Chapter12\P234_ChainingLambdas\Author.java

```java
package Chapter12.P234_ChainingLambdas;

import java.util.List;

public final class Author {
    
    private final String name;
    private final List<Book> books;

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }            
}
```
