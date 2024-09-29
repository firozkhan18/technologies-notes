# com\java\eight8\newfeatures\lambda\JLEExampleSingleParameter.java

```java
package com.java.eight8.newfeatures.lambda;

interface Printable{

	void print(String msg);
}

public class JLEExampleSingleParameter {

	public static void main(String[] args) {
		
		// without lambda expression
		
		Printable printable = new Printable() {
			@Override
			public void print(String msg) {
				System.out.println(msg);
			}
		};
		printable.print(" Print message to console....");
		
		// with lambda expression
		Printable withLambda = (msg) -> System.out.println(msg);
		withLambda.print(" Print message to console....");
	}
	
}
```
