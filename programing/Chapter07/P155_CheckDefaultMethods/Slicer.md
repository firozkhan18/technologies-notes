# Chapter07\P155_CheckDefaultMethods\Slicer.java

```java
package Chapter07.P155_CheckDefaultMethods;

public interface Slicer {

    public void type();

    default void slice() {
        System.out.println("slice");
    }
}
```
