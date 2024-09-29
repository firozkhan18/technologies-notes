# Chapter10\P200_ObjectVsClassLevelLocking\ClassCll2.java

```java
package Chapter10.P200_ObjectVsClassLevelLocking;

public class ClassCll2 {

    public void method() {
        synchronized (ClassCll2.class) {
            System.out.println("This is an CLL example");
        }
    }
}
```
