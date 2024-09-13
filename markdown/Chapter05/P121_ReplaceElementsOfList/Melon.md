# Chapter05\P121_ReplaceElementsOfList\Melon.java

```java
package Chapter05.P121_ReplaceElementsOfList;

public class Melon {

    private final String type;
    private final int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }
}
```
