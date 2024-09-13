# Chapter02\BONUS_1_SpringAndJavaRecords\controller\BookstoreController.java

```java
package Chapter02.BONUS_1_SpringAndJavaRecords.controller;

import java.util.List;
import modern.challenge.service.BookstoreService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import modern.challenge.record.Author;

@RestController
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authors")
    public List<Author> fetchAuthors() {

        return bookstoreService.fetchAuthors();
    }

}
```
