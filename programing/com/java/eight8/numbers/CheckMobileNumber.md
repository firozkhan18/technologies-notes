# com\java\eight8\numbers\CheckMobileNumber.java

```java
package com.java.eight8.numbers;

import java.util.Scanner;

//Below is the program which checks whether mobile number entered by user has 10 digits only.
//While developing the real time applications, many times you need to check whether the user input is number or not. For example is mobile Number. You have to check whether mobile number entered by user contains only digits or not. Those who have developed some real time applications, they may have come across this requirement.
//In this post, I have tried to write a java program which checks whether user input is number or not.
//
//
//You all know that java.lang.Integer class has parsing method. This method is used to parse the string into integer value. This method takes string type as an argument and returns integer value of that string. If the passed string is not a valid number then it throws NumberFormatException. We will use this technique to check whether the given input is number or not.
//
//Let’s define one method called “numberOrNot”. Pass one string type argument to this method. Try to parse this string to integer value by using parseInt() method of Integer class.
//
//boolean numberOrNot(String input)
//{
//    try
//    {
//        Integer.parseInt(input);
//    }
//    catch(NumberFormatException ex)
//    {
//        return false;
//    }
//    return true;
//}
//You can notice that I have kept parsing statement (Integer.parse(input)) in try block. If ‘input‘ is a number then this method will return true. If ‘input‘ is not a number then NumberFormatException will be raised and catch statement will return false. Now, you can use this method where ever you want to check the user input is a number or not.
//It is the best coding practice to define frequently used operations like fetching the data from database and displaying them in a table or checking whether the given input is number or not in separate methods in a class say “Utility” class. Then where ever you want those functionalities, you just give call to those methods instead of writing the whole code again and again.
class Utility {
	static boolean numberOrNot(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}

public class CheckMobileNumber {
	public static void main(String[] args) {
		System.out.println("Enter your mobile number");

		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		if (Utility.numberOrNot(input) && (input.length() == 10)) {
			System.out.println("Good!!! You have entered valid mobile number");
		} else {
			System.out.println("Sorry!!!! You have entered invalid mobile number. Try again...");
		}
	}
}
```
