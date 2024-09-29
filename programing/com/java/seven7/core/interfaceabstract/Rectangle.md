# com\java\seven7\core\interfaceabstract\Rectangle.java

```java
package com.java.seven7.core.interfaceabstract;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle...");
    }

    @Override
    public double area() {
        return this.height * this.width;
    }
}
```
