# Chapter09\P198_DefaultMethods\Square.java

```java
package Chapter09.P198_DefaultMethods;

public class Square implements Polygon {

    private final double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return Math.pow(perimeter(edge, edge, edge, edge) / 4, 2);
    }
}
```
