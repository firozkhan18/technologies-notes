# Chapter02\BONUS_1_SpringAndJavaRecords\record\Book.java

```java
package Chapter02.BONUS_1_SpringAndJavaRecords.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Book(@JsonProperty("title") String title, 
@JsonProperty("isbn") String isbn) {}
```
