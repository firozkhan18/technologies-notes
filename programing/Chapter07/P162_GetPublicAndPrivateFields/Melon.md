# Chapter07\P162_GetPublicAndPrivateFields\Melon.java

```java
package Chapter07.P162_GetPublicAndPrivateFields;

public class Melon {

    private String type;
    private int weight;    
    public Peeler peeler;
    public Juicer juicer;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
   
    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }
}
```
