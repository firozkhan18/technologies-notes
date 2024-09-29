# com\java\seven7\concurrency\inheritable\ChildThread.java

```java
package com.java.seven7.concurrency.inheritable;

public class ChildThread extends Thread {
    public void run(){
        // child data
        System.out.println("Child Thread Value: " + ParentThread.itl_p.get());
    }
}
```
