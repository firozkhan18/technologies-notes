# com\java\eight8\string\FindPercentageOfUppercaseLettersLowercaseLettersDigitsAndSpecialCharactersInString.java

```java
package com.java.eight8.string;

import java.text.DecimalFormat;

//Problem :
//Write a java program to find the percentage of uppercase letters, lowercase letters, digits and other special characters(including space) in the given string. For example, In “Tiger Runs @ The Speed Of 100 km/hour.”,
//
//Number of uppercase letters is 5. So percentage is 13.16%
//Number of lowercase letters is 20. So percentage is 52.63%
//Number of digits is 3. So percentage is 7.89%
//Number of other characters is 10. So percentage is 26.32%
//
//
//Percentage Of Uppercase Letters, Lowercase Letters, Digits And Special Characters In String
//
//How To Find Percentage Of Uppercase Letters, Lowercase Letters, Digits And Special Characters In String?
//We use 3 important methods of java.lang.Character class to find the percentage of uppercase letters, lowercase letters, digits and other special characters. They are,
//
//Character.isUpperCase(ch) –> This method checks whether ‘ch’ is in uppercase or not.
//
//
//Character.isLowerCase(ch) –> This method checks whether ‘ch’ is in lowercase or not.
//
//Character.isDigit(ch) –> This method checks whether ‘ch’ is a digit or not.
//
//Below is the complete code to find out the percentage of uppercase letters, lowercase letters, digits and other special characters in the given string.
public class FindPercentageOfUppercaseLettersLowercaseLettersDigitsAndSpecialCharactersInString {
	static void characterPercentage(String inputString) {
		// Getting total no of characters in the given string

		int totalChars = inputString.length();

		// Initializing upperCaseLetters, lowerCaseLetters, digits and others with 0

		int upperCaseLetters = 0;

		int lowerCaseLetters = 0;

		int digits = 0;

		int others = 0;

		// Iterating through each character of inputString

		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);

			// If ch is in uppercase, then incrementing upperCaseLetters

			if (Character.isUpperCase(ch)) {
				upperCaseLetters++;
			}

			// If ch is in lowercase, then incrementing lowerCaseLetters

			else if (Character.isLowerCase(ch)) {
				lowerCaseLetters++;
			}

			// If ch is a digit, then incrementing digits

			else if (Character.isDigit(ch)) {
				digits++;
			}

			// If ch is a special character then incrementing others

			else {
				others++;
			}
		}

		// Calculating percentage of uppercase letters, lowercase letters, digits and
		// other characters

		double upperCaseLetterPercentage = (upperCaseLetters * 100.0) / totalChars;

		double lowerCaseLetterPercentage = (lowerCaseLetters * 100.0) / totalChars;

		double digitsPercentage = (digits * 100.0) / totalChars;

		double otherCharPercentage = (others * 100.0) / totalChars;

		DecimalFormat formatter = new DecimalFormat("##.##");

		// Printing percentage of uppercase letters, lowercase letters, digits and other
		// characters

		System.out.println("In '" + inputString + "' : ");

		System.out.println("Uppercase letters are " + formatter.format(upperCaseLetterPercentage) + "% ");

		System.out.println("Lowercase letters are " + formatter.format(lowerCaseLetterPercentage) + "%");

		System.out.println("Digits Are " + formatter.format(digitsPercentage) + "%");

		System.out.println("Other Characters Are " + formatter.format(otherCharPercentage) + "%");

		System.out.println("-----------------------------");
	}

	public static void main(String[] args) {
		characterPercentage("Tiger Runs @ The Speed Of 100 km/hour.");

		characterPercentage("My e-mail : eMail_Address321@anymail.com");

		characterPercentage("AUS : 123/3, 21.2 Overs");
	}
}
```
