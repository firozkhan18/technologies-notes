# com\java\eight8\predicate\BiggerThanFivePredicate.java

```java
package com.java.eight8.predicate;

import java.util.function.Predicate;

public class BiggerThanFivePredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer val) {

        Integer five = 5;

        return val > five;
    }
}
```
