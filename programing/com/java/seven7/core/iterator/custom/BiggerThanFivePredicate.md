# com\java\seven7\core\iterator\custom\BiggerThanFivePredicate.java

```java
package com.java.seven7.core.iterator.custom;

import java.util.function.Predicate;

public class BiggerThanFivePredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer val) {

        Integer five = 5;

        return val > five;
    }
}
```
