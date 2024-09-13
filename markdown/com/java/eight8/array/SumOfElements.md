# com\java\eight8\array\SumOfElements.java

```java
package com.java.eight8.array;

public class SumOfElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println("Sum of all elements in the array: " + sum);
    }
}
```
