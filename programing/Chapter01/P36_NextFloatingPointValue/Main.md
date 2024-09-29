# Chapter01\P36_NextFloatingPointValue\Main.java

```java
package Chapter01.P36_NextFloatingPointValue;

public class Main {

    public static void main(String[] args) {

        float f = 0.1f;        
        float nextdownf = Math.nextDown(f);
        float nextupf = Math.nextUp(f);
                 
        System.out.println("float " + f + " next down is " + nextdownf);
        System.out.println("float " + f + " next up is " + nextupf);

        double d = 0.1d;
        double nextdownd = Math.nextDown(d);
        double nextupd = Math.nextUp(d);

        System.out.println("double " + d + " next down is " + nextdownd);
        System.out.println("double " + d + " next up is " + nextupd);
    }

}
```
