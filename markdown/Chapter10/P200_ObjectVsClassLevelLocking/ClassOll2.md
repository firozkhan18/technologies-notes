# Chapter10\P200_ObjectVsClassLevelLocking\ClassOll2.java

```java
package Chapter10.P200_ObjectVsClassLevelLocking;

public class ClassOll2 {

    public void methodOll() {
        synchronized (this) {
            System.out.println("This is an OLL example");
        }
    }
}
```
