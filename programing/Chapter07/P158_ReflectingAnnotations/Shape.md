# Chapter07\P158_ReflectingAnnotations\Shape.java

```java
package Chapter07.P158_ReflectingAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.METHOD, ElementType.PARAMETER})

public @interface Shape {
    public String value() default "slice";   
}
```
