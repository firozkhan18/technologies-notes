# Chapter02\P53_CloningObjects\deep\copy\serialization\Radius.java

```java
package Chapter02.P53_CloningObjects.deep.copy.serialization;

import java.io.Serializable;

public class Radius implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }    
}
```
