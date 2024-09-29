# com\java\seven7\core\linkedlist\RemoveOccurrencesInArray.java

```java
package com.java.seven7.core.linkedlist;

import java.util.Arrays;
//How do you remove the first occurrence and last occurrence of a given element in a Array?

//To remove the first occurrence and last occurrence of a given element in an array, 
//you can loop through the array and find the indices of the first and last occurrences of the element. 
//Then, you can remove those elements by creating a new array without them.
public class RemoveOccurrencesInArray {
	public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 6, 2, 7};
        int elementToRemove = 2;
        
        int firstIndex = -1;
        int lastIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementToRemove) {
                if (firstIndex == -1) {
                    firstIndex = i;
                }
                lastIndex = i;
            }
        }
        
        int[] newArr = new int[arr.length - (lastIndex - firstIndex + 1)];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < firstIndex || i > lastIndex) {
                newArr[index] = arr[i];
                index++;
            }
        }
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Element to remove: " + elementToRemove);
        System.out.println("New Array: " + Arrays.toString(newArr));
    }
}
```
