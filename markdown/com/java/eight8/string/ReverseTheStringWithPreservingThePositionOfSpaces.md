# com\java\eight8\string\ReverseTheStringWithPreservingThePositionOfSpaces.java

```java
package com.java.eight8.string;

//Problem :
//Write a java program to reverse a string with preserving the position of spaces. For example, if “I Am Not String” is the given string then the reverse of this string with preserving the position of spaces is “g ni rtS toNmAI”. Notice that the position of spaces in the original string are maintained in the reversed string also. That means, if the given string has a space at index 3, then there should be also a space in the reversed string at index 3.

//Logic Used To Reverse The String With Preserving The Position Of Spaces :
//First, we convert the given ‘inputstring’ to char array and call it as ‘inputStringArray’. We define one more char array called ‘resultArray’ with the same size as ‘inputStringArray’. In the first for loop, for every space in the ‘inputStringArray’, we insert space in the ‘resultArray’ at the corresponding positions. In the second for loop, we copy non-space characters of ‘inputStringArray’ starting from first to last into the ‘resultArray’ at ‘j’ position where ‘j’ will have value from length of resultArray to 0. Before copying, we check whether the ‘resultArray’ already contains a space at index ‘j’ or not. If it contains, we copy the character in the next position. See the below image for more clarity.
public class ReverseTheStringWithPreservingThePositionOfSpaces {
	static void reverseString(String inputString) {
		// Converting inputString to char array 'inputStringArray'

		char[] inputStringArray = inputString.toCharArray();

		// Defining a new char array 'resultArray' with same size as inputStringArray

		char[] resultArray = new char[inputStringArray.length];

		// First for loop :
		// For every space in the 'inputStringArray',
		// we insert spaces in the 'resultArray' at the corresponding positions

		for (int i = 0; i < inputStringArray.length; i++) {
			if (inputStringArray[i] == ' ') {
				resultArray[i] = ' ';
			}
		}

		// Initializing 'j' with length of resultArray

		int j = resultArray.length - 1;

		// Second for loop :
		// we copy every non-space character of inputStringArray
		// from first to last at 'j' position of resultArray

		for (int i = 0; i < inputStringArray.length; i++) {
			if (inputStringArray[i] != ' ') {
				// If resultArray already has space at index j then decrementing 'j'

				if (resultArray[j] == ' ') {
					j--;
				}

				resultArray[j] = inputStringArray[i];

				j--;
			}
		}

		System.out.println(inputString + " ---> " + String.valueOf(resultArray));
	}

	public static void main(String[] args) {
		reverseString("I Am Not String");

		reverseString("JAVA JSP ANDROID");

		reverseString("1 22 333 4444 55555");
	}
}
```
