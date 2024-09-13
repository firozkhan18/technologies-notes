# Chapter08\P170_StrategyPattern\WhitespacesRemover.java

```java
package Chapter08.P170_StrategyPattern;

public class WhitespacesRemover implements RemoveStrategy {

    @Override
    public String execute(String s) {
        return s.replaceAll("\\s", "");
    }

}
```
