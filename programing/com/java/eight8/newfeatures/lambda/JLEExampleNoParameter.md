# com\java\eight8\newfeatures\lambda\JLEExampleNoParameter.java

```java
package com.java.eight8.newfeatures.lambda;

interface Sayable {
	public String say();
}
public class JLEExampleNoParameter {
	public static void main(String[] args) {
		// without lambda expression
		Sayable sayable = new Sayable() {
			@Override
			public String say() {
				return "Return something ..";
			}
		};
		sayable.say();

		// with lambda expression
		Sayable withLambda = () -> {
			return "Return something ..";
		};
		withLambda.say();
	}
}
```
