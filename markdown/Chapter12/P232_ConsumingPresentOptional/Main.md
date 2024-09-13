# Chapter12\P232_ConsumingPresentOptional\Main.java

```java
package Chapter12.P232_ConsumingPresentOptional;

public class Main {

    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        book.displayStatusAvoid();
        book.displayStatusAlsoAvoid();

        // Prefer
        book.displayStatusPrefer();
        book.displayStatusAlsoPrefer();
    }

}
```
