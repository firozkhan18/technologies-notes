# com\java\seven7\core\interfaceabstract\CircleImp.java

```java
package com.java.seven7.core.interfaceabstract;

public class CircleImp extends BaseShape {
    private double radius;

    public CircleImp(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle...");
    }

    @Override
    public double area() {
        return this.radius * this.radius * Math.PI;
    }
}
```
