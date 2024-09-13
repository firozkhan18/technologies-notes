# Chapter11\P221_AtomicAction\AtomicIncrementator.java

```java
package Chapter11.P221_AtomicAction;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIncrementator implements Runnable {

    public static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
```
