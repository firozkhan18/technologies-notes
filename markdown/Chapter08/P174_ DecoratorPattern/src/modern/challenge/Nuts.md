# Chapter08\P174_ DecoratorPattern\src\modern\challenge\Nuts.java

```java
package modern.challenge;

public class Nuts extends CakeDecorator {

    public Nuts(Cake cake) {
        super(cake);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithNuts();
    }

    private String decorateWithNuts() {
        return "with Nuts ";
    }

}
```
