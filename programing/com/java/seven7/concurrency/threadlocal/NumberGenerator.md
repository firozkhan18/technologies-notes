# com\java\seven7\concurrency\threadlocal\NumberGenerator.java

```java
package com.java.seven7.concurrency.threadlocal;

import java.util.Random;

public class NumberGenerator {
    private Random random;

    public NumberGenerator() {
        random = new Random();
    }

    public int random(int i){
        return random.nextInt(i);
    }
}
```
