# com\java\seven7\advanced\webservice\server\HelloServiceImpl.java

```java
package com.java.seven7.advanced.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.java.seven7.advanced.webservice.server.HelloService")
public class HelloServiceImpl implements HelloService {
    @WebMethod
    public String helloWorld() {
        return "Hello World";
    }

    @WebMethod
    public String hi(String name) {
        return "Hi " + name;
    }
}
```
