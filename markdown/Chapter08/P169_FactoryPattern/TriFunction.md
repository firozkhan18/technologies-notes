# Chapter08\P169_FactoryPattern\TriFunction.java

```java
package Chapter08.P169_FactoryPattern;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);
}
```
