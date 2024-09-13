# Chapter09\P198_DefaultMethods\Polygon.java

```java
package Chapter09.P198_DefaultMethods;

import java.util.Arrays;

public interface Polygon {

    public double area();

    default double perimeter(double... segments) {

        return Arrays.stream(segments)
                .sum();
    }
}
```
