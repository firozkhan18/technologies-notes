# com\java\eight8\newfeatures\defaultstaticinterfacemethods\interfaces\Alarm.java

```java
package com.java.eight8.newfeatures.defaultstaticinterfacemethods.interfaces;

public interface Alarm {
	default String turnAlarmOn() {
		return "Turning the alarm on.";
	}

	default String turnAlarmOff() {
		return "Turning the alarm off.";
	}
}
```
