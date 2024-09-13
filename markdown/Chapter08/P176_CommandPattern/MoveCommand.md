# Chapter08\P176_CommandPattern\MoveCommand.java

```java
package Chapter08.P176_CommandPattern;

public class MoveCommand implements Command {

    private final IODevice action;

    public MoveCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.move();
    }

}
```
