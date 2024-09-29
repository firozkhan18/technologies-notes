# com\java\seven7\core\comparator\SalaryComparator.java

```java
package com.java.seven7.core.comparator;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}
```
