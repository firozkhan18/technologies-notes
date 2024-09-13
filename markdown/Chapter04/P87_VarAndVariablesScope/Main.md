# Chapter04\P87_VarAndVariablesScope\Main.java

```java
package Chapter04.P87_VarAndVariablesScope;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        // Prefer
        var stack = new Stack<String>();
        stack.push("John");
        stack.push("Martin");
        stack.push("Anghel");
        stack.push("Christian");        
        
        // John, Martin, Anghel, Christian
        stack.forEach(System.out::println);
        
        // 50 lines of code that doesn't use stack
    }
}
```
