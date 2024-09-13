# Chapter08\P172_ObserverPattern\BrookhavenFireStation.java

```java
package Chapter08.P172_ObserverPattern;

public class BrookhavenFireStation implements FireObserver {

    @Override
    public void fire(String address) {
        if(address.contains("Brookhaven")) {
            System.out.println("Brookhaven fire station will go to this fire");
        }
    }
    
}
```
