# Chapter07\P156_NestBasedAccessControl\Main.java

```java
package Chapter07.P156_NestBasedAccessControl;

public class Main {

    public static void main(String[] args) 
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        Car car = Car.newCar("BMW", "200 hp"); 
        System.out.println(car);
    }
}
```
