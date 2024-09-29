# Chapter12\P235_OptionalForGettingValue\Main.java

```java
package Chapter12.P235_OptionalForGettingValue;

public class Main {

    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        System.out.println(book.findStatusAvoid());

        // Prefer
        System.out.println(book.findStatusPrefer());
    }

}
```
