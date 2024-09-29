# com\java\seven7\concurrency\thread\ThreadExample.java

```java
package com.java.seven7.concurrency.thread;

public class ThreadExample {
    public static void main(String[] args)
    {
        // Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        // Runnable interface
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
```
