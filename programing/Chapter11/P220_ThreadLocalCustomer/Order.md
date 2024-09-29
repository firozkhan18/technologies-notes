# Chapter11\P220_ThreadLocalCustomer\Order.java

```java
package Chapter11.P220_ThreadLocalCustomer;

public class Order {

    private final int customerId;

    public Order(int customerId) {
        this.customerId = customerId;
    }   

    public int getCustomerId() {
        return customerId;
    }   
    
    @Override
    public String toString() {
        return "Order{" + "customerId=" + customerId + '}';
    }
    
}
```
