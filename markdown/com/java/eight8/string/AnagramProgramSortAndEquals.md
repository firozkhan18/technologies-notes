# com\java\eight8\string\AnagramProgramSortAndEquals.java

```java
package com.java.eight8.string;

import java.util.Arrays;

//Anagram Program In Java Using sort() and equals() Methods
//First we clean the input by removing all white spaces from the given two strings and change the case of all characters of both the strings to lower case so that case of both input strings will be ignored. After cleaning the input strings, we convert them to character array and sort them using sort() method of java.util.Arrays class. After sorting, we compare both the arrays using equals() method of same Arrays class.This method will return true if both arrays have same set of characters. Below is the complete anagram program using sort() and equals() methods.
public class AnagramProgramSortAndEquals {
	static void isAnagram(String s1, String s2) {
		// Removing all white spaces from s1 and s2

		String copyOfs1 = s1.replaceAll("\\s", "");

		String copyOfs2 = s2.replaceAll("\\s", "");

		// Initially setting status as true

		boolean status = true;

		if (copyOfs1.length() != copyOfs2.length()) {
			// Setting status as false if copyOfs1 and copyOfs2 doesn't have same length

			status = false;
		} else {
			// Changing the case of characters of both copyOfs1 and copyOfs2 and converting
			// them to char array

			char[] s1Array = copyOfs1.toLowerCase().toCharArray();

			char[] s2Array = copyOfs2.toLowerCase().toCharArray();

			// Sorting both s1Array and s2Array

			Arrays.sort(s1Array);

			Arrays.sort(s2Array);

			// Checking whether s1Array and s2Array are equal

			status = Arrays.equals(s1Array, s2Array);
		}

		// Output

		if (status) {
			System.out.println(s1 + " and " + s2 + " are anagrams");
		} else {
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		}
	}

	public static void main(String[] args) {
		isAnagram("Mother In Law", "Hitler Woman");

		isAnagram("keEp", "peeK");

		isAnagram("SiLeNt CAT", "LisTen AcT");

		isAnagram("Debit Card", "Bad Credit");

		isAnagram("School MASTER", "The ClassROOM");

		isAnagram("DORMITORY", "Dirty Room");

		isAnagram("ASTRONOMERS", "NO MORE STARS");

		isAnagram("Toss", "Shot");

		isAnagram("joy", "enjoy");
	}
}
```
