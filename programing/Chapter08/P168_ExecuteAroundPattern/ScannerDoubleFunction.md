# Chapter08\P168_ExecuteAroundPattern\ScannerDoubleFunction.java

```java
package Chapter08.P168_ExecuteAroundPattern;

import java.io.IOException;
import java.util.Scanner;

@FunctionalInterface
public interface ScannerDoubleFunction {
    
    double readDouble(Scanner scanner) throws IOException;
}
```
