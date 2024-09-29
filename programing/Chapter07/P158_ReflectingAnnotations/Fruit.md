# Chapter07\P158_ReflectingAnnotations\Fruit.java

```java
package Chapter07.P158_ReflectingAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface Fruit {
    public String name();
    public String value();
}
```
