# Chapter11\P219_Cancellation\Main.java

```java
package Chapter11.P219_Cancellation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        RandomList rl = new RandomList();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(rl);
        }

        Thread.sleep(100);
        rl.cancel();

        System.out.println(rl.getRandoms());

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

}
```
