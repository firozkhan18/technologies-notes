# TicketCacheLoaderWriter.java

```java

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.cache.Cache;
import javax.cache.integration.CacheLoader;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriter;
import javax.cache.integration.CacheWriterException;

public class TicketCacheLoaderWriter implements CacheLoader<Long, TicketDetails>, CacheWriter<Long, TicketDetails> {

    @Override
    public TicketDetails load(Long ticketID) throws CacheLoaderException {
        return getTicketDetails(ticketID);
    }

    @Override
    public Map<Long, TicketDetails> loadAll(Iterable<? extends Long> ticketIDs) throws CacheLoaderException {
        Map<Long, TicketDetails> tickets = new HashMap<>();
        for(Long ticketID : ticketIDs){
            tickets.put(ticketID, getTicketDetails(ticketID));
        }
        return Collections.unmodifiableMap(tickets);
    }

    private TicketDetails getTicketDetails(Long ticketID){
        TicketDetails details = null;
        // business logic to fetch ticket information
        return details;
    }

    @Override
    public void write(Cache.Entry<? extends Long, ? extends TicketDetails> ticketEntry) throws CacheWriterException {
        writeTicketDetails(ticketEntry.getKey(), ticketEntry.getValue());
    }

    @Override
    public void writeAll(Collection<Cache.Entry<? extends Long, ? extends TicketDetails>> ticketEntries) throws CacheWriterException {
        for(Cache.Entry ticketEntry : ticketEntries) {
            writeTicketDetails((Long) ticketEntry.getKey(), (TicketDetails) ticketEntry.getValue());
        }
    }

    @Override
    public void delete(Object ticketID) throws CacheWriterException {
        deleteTicket((Long) ticketID);
    }

    @Override
    public void deleteAll(Collection<?> ticketIds) throws CacheWriterException {
        for(Object ticketID : ticketIds) {
            deleteTicket((Long) ticketID);
        }
    }

    private void writeTicketDetails(Long ticketID, TicketDetails ticketDetails){
        // business logic to write ticket information
    }

    private void deleteTicket(Long ticketID){
        // business logic to delete ticket information
    }
}


```
