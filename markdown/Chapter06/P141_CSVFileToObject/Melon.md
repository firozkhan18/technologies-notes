# Chapter06\P141_CSVFileToObject\Melon.java

```java
package Chapter06.P141_CSVFileToObject;

public class Melon {

    private String type;
    private int weight;    

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

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
        
    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }
}
```
