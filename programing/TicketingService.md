# TicketingService.java

```java
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

@CacheDefaults(cacheName = "TicketsCache")
public class TicketingService {

    @CachePut
    public void persistTicket(long ticketID, @CacheValue TicketDetails details){
        // domain logic to persist ticket information
    }

    @CacheResult
    public TicketDetails findTicket(@CacheKey long ticketID){
        TicketDetails details = null;
        // execute domain logic to find ticket information
        return details;
    }

    @CacheRemove
    public void deleteTicket(@CacheKey long ticketID){
        // domain logic to delete ticket information
    }

    @CacheRemoveAll
    public void deleteAllTickets(){
        // domain logic to delete all ticket information
    }
}
```
