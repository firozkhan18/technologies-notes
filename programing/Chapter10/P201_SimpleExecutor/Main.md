# Chapter10\P201_SimpleExecutor\Main.java

```java
package Chapter10.P201_SimpleExecutor;

public class Main {
    
    public static void main(String[] args) {
        
        SimpleExecutor se = new SimpleExecutor();
        se.execute(() -> {
            System.out.println("Simple task executed via Executor interface");
        });
    }
    
}
```
