# Chapter04\P80_ImplicitTypeCastingAndCodeMaintainability\Main.java

```java
package Chapter04.P80_ImplicitTypeCastingAndCodeMaintainability;

public class Main {

    public static void main(String[] args) {

        boolean paid = purchaseCart(1L);
        System.out.println("Success: " + paid);
    }

    public static boolean purchaseCart(long customerId) {

        var price = ShoppingAddicted.fetchBestPriceAsInt(new String[0]);
        var paid = ShoppingAddicted.debitCardAsInt(price);

        return paid;
    }
}
```
