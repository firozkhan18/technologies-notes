# Chapter11\P220_ThreadLocal\Main.java

```java
package Chapter11.P220_ThreadLocal;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        ThreadSafeStringBuilder threadSafe = new ThreadSafeStringBuilder();

        for (int i = 0; i < 3; i++) {
            new Thread(threadSafe, "thread-" + i).start();            
        }                
    }

}
```
