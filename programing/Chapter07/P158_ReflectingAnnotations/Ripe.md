# Chapter07\P158_ReflectingAnnotations\Ripe.java

```java
package Chapter07.P158_ReflectingAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})

public @interface Ripe {
    public boolean value() default false;   
}
```
