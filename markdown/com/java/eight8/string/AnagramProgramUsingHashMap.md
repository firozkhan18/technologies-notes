# com\java\eight8\string\AnagramProgramUsingHashMap.java

```java
package com.java.eight8.string;

import java.util.HashMap;

//Anagram Program In Java Using HashMap
//In this method, we construct one HashMap object with character as Key and character occurrences as Value. We increment character count by 1 if the character is present in first string and decrement it by 1 if that character is present in second string. At last, we check character count for each character in the map. If any count is not equal to 0, then given strings are not anagrams.
public class AnagramProgramUsingHashMap {
	static void isAnagram(String s1, String s2) {
		// Removing white spaces from s1 and s2 and converting case to lower case

		String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();

		String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();

		// Initially setting status as true

		boolean status = true;

		if (copyOfs1.length() != copyOfs2.length()) {
			// Setting status as false if copyOfs1 and copyOfs2 doesn't have same length

			status = false;
		} else {
			// Constructing a map containing character as a key and character occurrences as
			// a value

			HashMap<Character, Integer> map = new HashMap<Character, Integer>();

			for (int i = 0; i < copyOfs1.length(); i++) {
				// Getting char from copyOfs1

				char charAsKey = copyOfs1.charAt(i);

				// Initializing char count to 0

				int charCountAsValue = 0;

				// Checking whether map contains this char

				if (map.containsKey(charAsKey)) {
					// If contains, retrieving it's count

					charCountAsValue = map.get(charAsKey);
				}

				// Putting char and it's count to map with pre-incrementing char count

				map.put(charAsKey, ++charCountAsValue);

				// Getting char from copyOfs2

				charAsKey = copyOfs2.charAt(i);

				// Initializing char count to 0

				charCountAsValue = 0;

				// Checking whether map contains this char

				if (map.containsKey(charAsKey)) {
					// If contains, retrieving it's count

					charCountAsValue = map.get(charAsKey);
				}

				// Putting char and it's count to map with pre-decrementing char count

				map.put(charAsKey, --charCountAsValue);
			}

			// Checking each character and it's count

			for (int value : map.values()) {
				if (value != 0) {
					// If character count is not equal to 0, then setting status as false

					status = false;
				}
			}

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
