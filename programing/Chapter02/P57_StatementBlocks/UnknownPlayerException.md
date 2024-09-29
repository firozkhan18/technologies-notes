# Chapter02\P57_StatementBlocks\UnknownPlayerException.java

```java
package Chapter02.P57_StatementBlocks;

public class UnknownPlayerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnknownPlayerException() {
        super();
    }

    public UnknownPlayerException(String message) {
        super(message);
    }

    public UnknownPlayerException(Throwable cause) {
        super(cause);
    }

    public UnknownPlayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
```
