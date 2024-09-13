# Chapter08\P174_LambdaBasedDecoratorPattern\CakeDecorator.java

```java
package Chapter08.P174_LambdaBasedDecoratorPattern;

import java.util.function.Function;
import java.util.stream.Stream;

public class CakeDecorator {

    private Function<Cake, Cake> decorator;

    public CakeDecorator(Function<Cake, Cake>... decorations) {
        reduceDecorations(decorations);
    }    

    public Cake decorate(Cake cake) {
        return decorator.apply(cake);
    }

    private void reduceDecorations(Function<Cake, Cake>... decorations) {
        decorator = Stream.of(decorations)
                .reduce(Function.identity(), Function::andThen);        
    }
}
```
