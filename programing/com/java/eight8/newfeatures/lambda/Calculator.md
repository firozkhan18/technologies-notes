# com\java\eight8\newfeatures\lambda\Calculator.java

```java
package com.java.eight8.newfeatures.lambda;

public class Calculator {
    public int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operate(a, b);
    }
}
```
