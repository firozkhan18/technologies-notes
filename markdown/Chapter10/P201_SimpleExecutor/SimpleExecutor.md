# Chapter10\P201_SimpleExecutor\SimpleExecutor.java

```java
package Chapter10.P201_SimpleExecutor;

import java.util.concurrent.Executor;

public class SimpleExecutor implements Executor {

    @Override
    public void execute(Runnable r) {
        (new Thread(r)).start();
    }

}
```
