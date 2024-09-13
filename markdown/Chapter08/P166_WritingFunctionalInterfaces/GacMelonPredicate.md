# Chapter08\P166_WritingFunctionalInterfaces\GacMelonPredicate.java

```java
package Chapter08.P166_WritingFunctionalInterfaces;

public class GacMelonPredicate implements MelonPredicate {

    @Override
    public boolean test(Melon melon) {    
        return "gac".equalsIgnoreCase(melon.getType());
    }

}
```
