# com\java\eight8\numbers\ConvertDecimalToBinary.java

```java
package com.java.eight8.numbers;

import java.util.Scanner;

public class ConvertDecimalToBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking input from the user

		System.out.println("Enter The Decimal Number : ");

		int inputNumber = sc.nextInt();

		// Copying inputNumber into copyOfInputNumber

		int copyOfInputNumber = inputNumber;

		// Initializing binary to empty string

		String binary = "";

		// Defining rem to store remainder

		int rem = 0;

		// See the below explanation to know how this loop works

		while (inputNumber > 0) {
			rem = inputNumber % 2;

			binary = rem + binary;

			inputNumber = inputNumber / 2;
		}

		System.out.println("Binary Equivalent of " + copyOfInputNumber + " is " + binary);
	}
}

//Output :
//
//Enter The Decimal Number :
//50
//Binary Equivalent of 50 is 110010
//
//Explanation :
//
//Let inputNumber = 50.
//
//
//1st Iteration :
//As 50 > 0 (inputNumber > 0)
//
//rem = inputNumber%2 = 50%2 = 0
//
//binary = rem+binary = 0 + “” = “0”
//
//inputNumber = inputNumber/2 = 50/2 = 25
//
//2nd Iteration :
//As 25 > 0 (inputNumber > 0)
//
//rem = inputNumber%2 = 25%2 = 1
//
//binary = rem+binary = 1 + “0” = “10”
//
//inputNumber = inputNumber/2 = 25/2 = 12
//
//3rd Iteration :
//As 12 > 0 (inputNumber > 0)
//
//rem = inputNumber%2 = 12%2 = 0
//
//
//binary = rem+binary = 0 + “10” = “010”
//
//inputNumber = inputNumber/2 = 12/2 = 6
//
//4th Iteration :
//As 6 > 0 (inputNumber > 0)
//
//rem = inputNumber%2 = 6%2 = 0
//
//binary = rem+binary = 0 + “010” = “0010”
//
//inputNumber = inputNumber/2 = 6/2 = 3
//
//5th Iteration :
//As 3 > 0 (inputNumber > 0)
//
//rem = inputNumber%2 = 3%2 = 1
//
//binary = rem+binary = 1 + “0010” = “10010”
//
//inputNumber = inputNumber/2 = 3/2 = 1
//
//6th Iteration :
//As 1 > 0 (inputNumber > 0)
//
//rem = inputNumber%2 = 1%2 = 1
//
//binary = rem+binary = 1 + “10010” = “110010”
//
//inputNumber = inputNumber/2 = 1/2 = 0
//
//7th Iteration :
//As 0 == 0 (inputNumber = 0)
//
//Exit The Loop
//
//So, Binary Equivalent of 50 is 110010
```
