# Chapter10\P200_ObjectVsClassLevelLocking\OllCllAndNoLock.java

```java
package Chapter10.P200_ObjectVsClassLevelLocking;

public class OllCllAndNoLock {

    public void notSynchronizedMethod() {
        System.out.println("notSynchronizedMethod(): " + Thread.currentThread().getName());
        while (true) {
        }
    }

    public synchronized void nonStaticMethod() {
        System.out.println("nonStaticMethod(): " + Thread.currentThread().getName());
        while (true) {
        }
    }

    public synchronized static void staticMethod() {
        System.out.println("staticMethod(): " + Thread.currentThread().getName());
        while (true) {
        }
    }

}
```
