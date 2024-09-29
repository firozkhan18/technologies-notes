# com\java\eight8\numbers\ConvertDecimalToOctal.java

```java
package com.java.eight8.numbers;

import java.util.Scanner;

//Java Program To Convert Decimal To Octal :
public class ConvertDecimalToOctal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking input from the user

		System.out.println("Enter The Decimal Number : ");

		int inputNumber = sc.nextInt();

		// Copying inputNumber into copyOfInputNumber

		int copyOfInputNumber = inputNumber;

		// Initializing octal to empty string

		String octal = "";

		// Defining rem to store remainder

		int rem = 0;

		// See the below explanation to know how this loop works

		while (inputNumber > 0) {
			rem = inputNumber % 8;

			octal = rem + octal;

			inputNumber = inputNumber / 8;
		}

		System.out.println("Octal Equivalent of " + copyOfInputNumber + " is " + octal);
	}
}
// Output :
//
// Enter The Decimal Number :
// 1000
// Octal Equivalent of 1000 is 1750
//
// Explanation :
//
// Let inputNumber = 1000.
//
// 1st Iteration :
// As 1000 > 0 (inputNumber > 0)
//
// rem = inputNumber%8 = 1000%8 = 0
//
// octal = rem+octal = 0 + “” = “0”
//
// inputNumber = inputNumber/8 = 1000/8 = 125
//
// 2nd Iteration :
// As 125 > 0 (inputNumber > 0)
//
// rem = inputNumber%8 = 125%8 = 5
//
// octal = rem+octal = 5 + “0” = “50”
//
// inputNumber = inputNumber/8 = 125/8 = 15
//
// 3rd Iteration :
// As 15 > 0 (inputNumber > 0)
//
// rem = inputNumber%8 = 15%8 = 7
//
// octal = rem+octal = 7 + “50” = “750”
//
// inputNumber = inputNumber/8 = 15/8 = 1
//
// 4th Iteration :
// As 1 > 0 (inputNumber > 0)
//
// rem = inputNumber%8 = 1%8 = 1
//
// octal = rem+octal = 1 + “750” = “1750”
//
// inputNumber = inputNumber/8 = 1/8 = 0
//
// 5th Iteration :
// As 0 == 0 (inputNumber = 0)
//
// Exit The Loop
//
// So, octal equivalent of 1000 is 1750.
```
