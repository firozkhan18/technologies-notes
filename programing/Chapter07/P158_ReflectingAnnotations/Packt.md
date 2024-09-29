# Chapter07\P158_ReflectingAnnotations\Packt.java

```java
package Chapter07.P158_ReflectingAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PACKAGE)

public @interface Packt {
}
```
