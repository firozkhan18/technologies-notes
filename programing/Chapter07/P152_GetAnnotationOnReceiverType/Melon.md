# Chapter07\P152_GetAnnotationOnReceiverType\Melon.java

```java
package Chapter07.P152_GetAnnotationOnReceiverType;

public class Melon {

    private final String type;
    private final int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public void eat(Chapter07.P152_GetAnnotationOnReceiverType.Melon this) {        
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
