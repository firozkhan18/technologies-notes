# Chapter01\P16_CheckStringContainsSubstring\Strings.java

```java
package Chapter01.P16_CheckStringContainsSubstring;

import java.util.regex.Pattern;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }
        
    public static boolean containsV1(String text, String subtext) {

        if (text == null || subtext == null 
                || text.isEmpty() || subtext.isEmpty()) {
            // or throw IllegalArgumentException            
            return false;
        }

        return text.matches("(?i).*" + Pattern.quote(subtext) + ".*");
    }

    public static boolean containsV2(String text, String subtext) {

        if (text == null || subtext == null 
                || text.isEmpty() || subtext.isEmpty()) {
            // or throw IllegalArgumentException            
            return false;
        }

        return text.indexOf(subtext) != -1; // or lastIndexOf()
    }
}
```
