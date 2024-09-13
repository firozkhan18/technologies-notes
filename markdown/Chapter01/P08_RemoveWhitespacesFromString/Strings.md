# Chapter01\P08_RemoveWhitespacesFromString\Strings.java

```java
package Chapter01.P08_RemoveWhitespacesFromString;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String removeWhitespaces(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return str.replaceAll("\\s", "");
    }

}
```
