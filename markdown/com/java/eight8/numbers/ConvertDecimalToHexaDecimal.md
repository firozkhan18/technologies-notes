# com\java\eight8\numbers\ConvertDecimalToHexaDecimal.java

```java
package com.java.eight8.numbers;

import java.util.Scanner;

public class ConvertDecimalToHexaDecimal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking input from the user

		System.out.println("Enter The Decimal Number : ");

		int inputNumber = sc.nextInt();

		// Copying inputNumber into copyOfInputNumber

		int copyOfInputNumber = inputNumber;

		// Initializing hexa to empty string

		String hexa = "";

		// Digits in HexaDecimal Number System

		char hexaDecimals[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// Defining rem to store remainder

		int rem = 0;

		// See the below explanation to know how this loop works

		while (inputNumber > 0) {
			rem = inputNumber % 16;

			hexa = hexaDecimals[rem] + hexa;

			inputNumber = inputNumber / 16;
		}

		System.out.println("HexaDecimal Equivalent of " + copyOfInputNumber + " is " + hexa);
	}
}
//Output :
//
//Enter The Decimal Number :
//2000
//HexaDecimal Equivalent of 2000 is 7D0
//
//Explanation :
//
//Let inputNumber = 2000
//
//1st Iteration :
//As 2000 > 0 (inputNumber > 0)
//
//rem = inputNumber%16 = 2000%16 = 0
//
//hexa = hexaDecimals[rem]+hexa = 0 + “” = “0”
//
//inputNumber = inputNumber/16 = 2000/16 = 125
//
//2nd Iteration :
//As 125 > 0 (inputNumber > 0)
//
//rem = inputNumber%16 = 125%16 = 13
//
//hexa = hexaDecimals[rem]+hexa = D + “0” = “D0”
//
//inputNumber = inputNumber/16 = 125/16 = 7
//
//3rd Iteration :
//As 7 > 0 (inputNumber > 0)
//
//rem = inputNumber%16 = 7%16 = 7
//
//hexa = hexaDecimals[rem]+hexa = 7 + “D0” = “7D0”
//
//inputNumber = inputNumber/16 = 7/16 = 0
//
//4th Iteration :
//As 0 == 0 (inputNumber == 0)
//
//Exit The Loop
//
//So, HexaDecimal equivalent of 2000 is 7D0
```
