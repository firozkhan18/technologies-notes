# Chapter13\P256_ConnectionAuthentication\Main.java

```java
package Chapter13.P256_ConnectionAuthentication;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ViaBody vb = new ViaBody();
        vb.bodyExample();
        
        ViaHeaderBearer vhb = new ViaHeaderBearer();
        vhb.bearerExample();
    }

}
```
