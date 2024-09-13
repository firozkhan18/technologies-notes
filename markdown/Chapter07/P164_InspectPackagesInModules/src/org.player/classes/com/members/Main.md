# Chapter07\P164_InspectPackagesInModules\src\org.player\classes\com\members\Main.java

```java
package com.members;

import com.management.Manager;
import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        Manager mgt = new Manager();
        
        Set<String> packages = mgt.getClass().getModule().getPackages();
        System.out.println("Packages: " + packages);
        
        Class<?> clazz = Class.forName(mgt.getClass().getModule(), "com.management.Manager");
        System.out.println("Clazz: " + clazz);          
    }
}
```
