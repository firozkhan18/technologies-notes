# com\java\seven7\advanced\webservice\server\HelloService.java

```java
package com.java.seven7.advanced.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {

    @WebMethod
    public String helloWorld();

    @WebMethod
    public String hi(String name);
}
```
