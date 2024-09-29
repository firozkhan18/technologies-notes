# Chapter04\P82_VarAndLackOfInformation\Bins.java

```java
package Chapter04.P82_VarAndLackOfInformation;

import java.io.File;

public final class Bins {

    private Bins() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static File fetchBinContent() {
        return new File(".");
    }
}
```
