# Chapter07\P158_ReflectingAnnotations\Unit.java

```java
package Chapter07.P158_ReflectingAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface Unit {  
    public String value() default "grams";
}
```
