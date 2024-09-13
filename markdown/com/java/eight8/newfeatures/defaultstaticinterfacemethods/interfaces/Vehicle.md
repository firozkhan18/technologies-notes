# com\java\eight8\newfeatures\defaultstaticinterfacemethods\interfaces\Vehicle.java

```java
package com.java.eight8.newfeatures.defaultstaticinterfacemethods.interfaces;

public interface Vehicle {
	String getBrand();

	String speedUp();

	String slowDown();

	default String turnAlarmOn() {
		return "Turning the vehice alarm on.";
	}

	default String turnAlarmOff() {
		return "Turning the vehicle alarm off.";
	}

	static int getHorsePower(int rpm, int torque) {
		return (rpm * torque) / 5252;
	}
}
```
