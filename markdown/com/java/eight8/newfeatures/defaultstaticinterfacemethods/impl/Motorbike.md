# com\java\eight8\newfeatures\defaultstaticinterfacemethods\impl\Motorbike.java

```java
package com.java.eight8.newfeatures.defaultstaticinterfacemethods.impl;

import com.java.eight8.newfeatures.defaultstaticinterfacemethods.interfaces.Vehicle;

public class Motorbike implements Vehicle {

    private final String brand;

    public Motorbike(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The motorbike is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The motorbike is slowing down.";
    }
}
```
