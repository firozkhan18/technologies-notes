# Chapter02\BONUS_2_SpringAndJavaRecordsInjection\record\Book.java

```java
package Chapter02.BONUS_2_SpringAndJavaRecordsInjection.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Book(@JsonProperty("title") String title, 
@JsonProperty("isbn") String isbn) {}
```
