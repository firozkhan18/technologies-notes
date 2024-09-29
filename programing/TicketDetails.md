# TicketDetails.java

```java

public class TicketDetails {
	private String ticketName;
    private String status;
    private int priority;

    public TicketDetails(String ticketName, String status, int priority) {
        this.ticketName = ticketName;
        this.status = status;
        this.priority = priority;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
```
