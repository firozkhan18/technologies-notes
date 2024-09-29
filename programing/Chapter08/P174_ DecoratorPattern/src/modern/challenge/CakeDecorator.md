# Chapter08\P174_ DecoratorPattern\src\modern\challenge\CakeDecorator.java

```java
package modern.challenge;

public class CakeDecorator implements Cake {

    private final Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }        
    
    @Override
    public String decorate() {
        return cake.decorate();
    }
    
}
```
