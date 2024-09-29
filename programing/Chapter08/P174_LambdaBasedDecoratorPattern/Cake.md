# Chapter08\P174_LambdaBasedDecoratorPattern\Cake.java

```java
package Chapter08.P174_LambdaBasedDecoratorPattern;

public class Cake {

    private final String decorations;

    public Cake(String decorations) {
        this.decorations = decorations;
    }

    public Cake decorate(String decoration) {
        return new Cake(getDecorations() + decoration);
    }

    public String getDecorations() {
        return decorations;
    }
}
```
