# Chapter08\P176_CommandPattern\DeleteCommand.java

```java
package Chapter08.P176_CommandPattern;

public class DeleteCommand implements Command {

    private final IODevice action;

    public DeleteCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.delete();
    }

}
```
