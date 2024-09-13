# Chapter02\BONUS_2_SpringAndJavaRecordsInjection\controller\BookstoreController.java

```java
package Chapter02.BONUS_2_SpringAndJavaRecordsInjection.controller;

import java.util.List;
import modern.challenge.service.BookstoreService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import modern.challenge.record.Author;

@RestController
public record BookstoreController(BookstoreService bookstoreService) {

    @GetMapping("/authors")
    public List<Author> fetchAuthors() {

        return bookstoreService.fetchAuthors();
    }

}
```
