# Chapter12\P229_NonExistentDefaultValue\Main.java

```java
package Chapter12.P229_NonExistentDefaultValue;

public class Main {

    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        System.out.println(book.findStatusAvoid() + "\n");

        // Also avoid
        System.out.println(book.findStatusAlsoAvoid() + "\n");
        
        // Prefer
        System.out.println(book.findStatusPrefer());
    }

}
```
