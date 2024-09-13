# Chapter10\P200_ObjectVsClassLevelLocking\ClassOll3.java

```java
package Chapter10.P200_ObjectVsClassLevelLocking;

public class ClassOll3 {

    private final Object ollLock = new Object();

    public void methodOll() {
        synchronized (ollLock) {
            System.out.println("This is an OLL example");
        }
    }

}
```
