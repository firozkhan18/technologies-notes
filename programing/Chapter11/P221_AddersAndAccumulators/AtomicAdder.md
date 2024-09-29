# Chapter11\P221_AddersAndAccumulators\AtomicAdder.java

```java
package Chapter11.P221_AddersAndAccumulators;

import java.util.concurrent.atomic.LongAdder;

public class AtomicAdder implements Runnable {

    public static LongAdder count = new LongAdder();
    
    @Override
    public void run() {
        count.add(1);
    }

    public long getCount() {
        return count.sum();
    }        
}
```
