# Java Exercises Search

### 1. Write a Java program to find a specified element in a given array of elements using Binary Search.

Write a Java program to find a specified element in a given array of elements using Binary Search.

Sample Solution:

Java Code:
```java
public class Main {
     public static int binarySearch(int[] nums, int flag) {
        int hi_num = nums.length - 1;
        int lo_num = 0;
        while (hi_num >= lo_num) {
            int guess = (lo_num + hi_num) >>> 1;   
            if (nums[guess] > flag) {
                hi_num = guess - 1;
            } else if (nums[guess] < flag) {
                lo_num = guess + 1;
            } else {
                return guess;
            }
        }
        return -1;
    }
 
    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7, 8, 11};
        int search_num = 7;
        int index = binarySearch(nums, search_num);
        if (index == -1) {
            System.out.println(search_num + " is not in the array");
        } else {
            System.out.println(search_num + " is at index " + index);
        }
    }
}
```
Sample Output:

7 is at index 3
### 2. Write a Java program to find a specified element in a given array of elements using Linear Search.

Write a Java program to find a specified element in a given array of elements using Linear Search.

Sample Solution:

Java Code:
```java
public class Main {
	static int [] nums;

	public static void main(String[] args) {
		nums = new int[]{3,2,4,5,6,6,7,8,9,9,0,9};
		int result = Linear_Search(nums, 6);
		if(result == -1)
		{
			System.out.print("Not present in the array!");			
		}
		else
		System.out.print("Number found at index "+result);	
	}
	
	private static int Linear_Search(int [] nums,int search)
	{
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==search)
			{
				return i;
				
			}			
		}
		return -1;
		
	}
}
```
Sample Output:

Number found at index 4

### 3. Write a Java program to find a specified element in a given sorted array of elements using Jump Search.
From Wikipedia, in  computer science, a jump search or block search refers to a search algorithm for ordered lists. It works by first checking all items Lkm, where ℜ ∈ ℵ and m is the block size, until an item is found that is larger than the search key. To find the exact position of the search key in the list a linear search is performed on the sublist L[(k-1)m, km].

Write a Java program to find a specified element in a given sorted array of elements using Jump Search.

From Wikipedia, in computer science, a jump search or block search refers to a search algorithm for ordered lists. It works by first checking all items Lkm, where ℜ ∈ ℵ and m is the block size, until an item is found that is larger than the search key. To find the exact position of the search key in the list a linear search is performed on the sublist L[(k-1)m, km].
Algorithm:
Input: An ordered list L, its length n and a search key s.
Output: The position of s in L, or nothing if s is not in L.

  a ← 0
  b ← [√n]

  while Lmin(b,n)-1 < s do
    a ← b
    b ← b + [√n]
    if a ≥ n then
      return nothing

  while La < s do
    a ← a + 1
    if a = min(b,n)
      return nothing

  if La = s then
    return a
  else
    return nothing
Sample Solution:

Java Code:
```java
public class Main {

	public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 21, 34, 45, 91, 120, 130, 456, 564};
        int search_num = 120;

       // Find the index of searched item
       int index_result = jumpSearch(nums, search_num);

       System.out.println(search_num + " is found at index " + index_result);

	}
	
	    public static int jumpSearch(int[] nums, int item)	    {
	        
	    	int array_size = nums.length;
	 
	        // Find block size to be jumped
	        int block_size = (int)Math.floor(Math.sqrt(array_size));
	 
	        // If the element is present find the block where element is present
	        int prev_item = 0;
	        while (nums[Math.min(block_size, array_size)-1] < item)
	        {
	            prev_item = block_size;
	            block_size += (int)Math.floor(Math.sqrt(array_size));
	            if (prev_item >= array_size)
	                return -1;
	        }
	 
	        // Using a linear search for element in block beginning with previous item
	        while (nums[prev_item] < item)
	        {
	            prev_item++;
	            if (prev_item == Math.min(block_size, array_size))
	                return -1;
	        }
	 
	        // If element is found
	        if (nums[prev_item] == item)
	            return prev_item;
	 
	        return -1;
	    } 	    
}
```
Sample Output:

120 is found at index 12

### 4. Write a Java program to find a specified element in a given array of elements using Interpolation Search.
From Wikipedia, Interpolation search is an algorithm for searching for a key in an array that has been ordered by numerical values assigned to the keys (key values). It was first described by W. W. Peterson in 1957. Interpolation search resembles the method by which people search a telephone directory for a name (the key value by which the book's entries are ordered): in each step the algorithm calculates where in the remaining search space the sought item might be, based on the key values at the bounds of the search space and the value of the sought key, usually via a linear interpolation. The key value actually found at this estimated position is then compared to the key value being sought. If it is not equal, then depending on the comparison, the remaining search space is reduced to the part before or after the estimated position. This method will only work if calculations on the size of differences between key values are sensible.

Write a Java program to find a specified element in a given sorted array of elements using Jump Search.

From Wikipedia, in computer science, a jump search or block search refers to a search algorithm for ordered lists. It works by first checking all items Lkm, where ℜ ∈ ℵ and m is the block size, until an item is found that is larger than the search key. To find the exact position of the search key in the list a linear search is performed on the sublist L[(k-1)m, km].
Algorithm:
Input: An ordered list L, its length n and a search key s.
Output: The position of s in L, or nothing if s is not in L.

  a ← 0
  b ← [√n]

  while Lmin(b,n)-1 < s do
    a ← b
    b ← b + [√n]
    if a ≥ n then
      return nothing

  while La < s do
    a ← a + 1
    if a = min(b,n)
      return nothing

  if La = s then
    return a
  else
    return nothing
Sample Solution:

Java Code:
```java
public class Main {

	public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 21, 34, 45, 91, 120, 130, 456, 564};
        int search_num = 120;

       // Find the index of searched item
       int index_result = jumpSearch(nums, search_num);

       System.out.println(search_num + " is found at index " + index_result);

	}
	
	    public static int jumpSearch(int[] nums, int item)	    {
	        
	    	int array_size = nums.length;
	 
	        // Find block size to be jumped
	        int block_size = (int)Math.floor(Math.sqrt(array_size));
	 
	        // If the element is present find the block where element is present
	        int prev_item = 0;
	        while (nums[Math.min(block_size, array_size)-1] < item)
	        {
	            prev_item = block_size;
	            block_size += (int)Math.floor(Math.sqrt(array_size));
	            if (prev_item >= array_size)
	                return -1;
	        }
	 
	        // Using a linear search for element in block beginning with previous item
	        while (nums[prev_item] < item)
	        {
	            prev_item++;
	            if (prev_item == Math.min(block_size, array_size))
	                return -1;
	        }
	 
	        // If element is found
	        if (nums[prev_item] == item)
	            return prev_item;
	 
	        return -1;
	    } 	    
}
```
Sample Output:

120 is found at index 12

### 5. Write a Java program to find a specified element in a given sorted array of elements using Exponential search.

From Wikipedia, in  computer science, an exponential search (also called doubling search or galloping search or Struzik search) is an algorithm, created by Jon Bentley and Andrew Chi-Chih Yao in 1976, for searching sorted, unbounded/infinite lists. There are numerous ways to implement this with the most common being to determine a range that the search key resides in and performing a binary search within that range. This takes O(log i) where i is the position of the search key in the list, if the search key is in the list, or the position where the search key should be, if the search key is not in the list.

Write a Java program to find a specified element in a given sorted array of elements using Exponential search.

From Wikipedia, in computer science, an exponential search (also called doubling search or galloping search or Struzik search) is an algorithm, created by Jon Bentley and Andrew Chi-Chih Yao in 1976, for searching sorted, unbounded/infinite lists. There are numerous ways to implement this with the most common being to determine a range that the search key resides in and performing a binary search within that range. This takes O(log i) where i is the position of the search key in the list, if the search key is in the list, or the position where the search key should be, if the search key is not in the list.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
public class abc {
	public static void main(String[] args) {
		int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 21, 34, 45, 91, 120, 130, 456, 564};
        int search_num = 120;
		
		// Find the index of searched item
       int index_result = exponentialSearch(nums, search_num);

       System.out.println(search_num + " is found at index " + index_result);		
		
	}

	private static int exponentialSearch(int[] arr, int i) {
		int start_num = 0;
		
		if(arr[start_num] == i)
			return start_num;
		start_num =1;
		while(start_num < arr.length && arr[start_num] <= i) {
			start_num*=2;
		}
		return Arrays.binarySearch(arr, start_num/2, Math.min(start_num, arr.length), i);
	}
}
```
Sample Output:

120 is found at index 12

### 6. Write a Java program to find a specified element in a given array of elements using Ternary search.

From Wikipedia, a ternary search algorithm is a technique in  computer science for finding the minimum or maximum of a unimodal function. A ternary search determines either that the minimum or maximum cannot be in the first third of the domain or that it cannot be in the last third of the domain, then repeats on the remaining two thirds. A ternary search is an example of a divide and conquer algorithm.

Write a Java program to find a specified element in a given array of elements using Ternary search.

From Wikipedia, a ternary search algorithm is a technique in computer science for finding the minimum or maximum of a unimodal function. A ternary search determines either that the minimum or maximum cannot be in the first third of the domain or that it cannot be in the last third of the domain, then repeats on the remaining two thirds. A ternary search is an example of a divide and conquer algorithm.

Sample Solution:

Java Code:
```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[]{0,1,2,3,5,7,9,12,15,17,18,21,25,32,52,54,75,89,90,93,97,104,120};
		System.out.println("Original array:");
		System.out.println(Arrays.toString(nums));
        System.out.println("Input an element to search:");
        int val = scan.nextInt();
        int position = ternary_search(nums, val, 0, nums.length-1);
        if(position == -1)
            System.out.println("\n" +val+ " Element not found");
        else
            System.out.println("\n"+ val +" element found at position "+ position);

    }

 static int ternary_search(int[] nums, int val, int first_element, int last_element)
    {
        if(first_element > last_element)
        {
            return -1;
        }
        int mid1_element = first_element + (last_element - first_element) / 3;
        int mid2_element = first_element + 2*(last_element - first_element) / 3;
        if(val == nums[mid1_element])
        {
            return mid1_element;
        }
        else if(val == nums[mid2_element])
        {
            return mid2_element;
        }
        else if(val > nums[mid1_element])
        {
            first_element = mid1_element+1;
        }
        else if(val < nums[mid2_element])
        {
            last_element = mid2_element-1;
        }
        return ternary_search(nums, val, first_element, last_element);
    }
}
```
Sample Output:

Original array:
[0, 1, 2, 3, 5, 7, 9, 12, 15, 17, 18, 21, 25, 32, 52, 54, 75, 89, 90, 93, 97, 104, 120]
Input an element to search:
 25

25 element found at position 12

### 7. Given is a 2-dimensional integer array [0..m-1, 0..n-1], each row and column of which is in ascending order (see example)
Find the row, column position of a specified number in a given 2-dimensional array
Write a Java program to find the row, column position of a specified number (row, column position) in a given 2-dimensional array.

Given is a 2-dimensional integer array [0..m-1, 0..n-1], each row and column of which is in ascending order (see example).

Example:

Find the row, column position of a specified number in a given 2-dimensional array
Write a Java program to find the row, column position of a specified number (row, column position) in a given 2-dimensional array.

Sample Solution:

Java Code:
```java
import java.util.*;
public class abc {

  public static void main(String[] args) {
   int nums[][] = {{12, 20, 30, 40}, 
                  {15, 25, 35, 45}, 
                  {24, 29, 39, 51}, 
                  {35, 30, 39, 50}, 
                  {50, 60, 75, 72}}; 
			   
	 int rows = 5;    
	 int search_element = 39;		   
     int ans[] = Saddleback(nums, rows - 1, 0, search_element);
        System.out.println("Position of "+search_element+" in the matrix is ("+ans[0] + "," + ans[1]+")");			   
    } 

    /**
     * @param nums, the matrix.  
     * @param row the current row.
     * @param col the current column.
     * @param search_element  the element that we want to search for.
     * @return value: If found the index(row and column) of the element.
     *  else return (-1 -1).
     */
    private static int[] Saddleback(int nums[][], int row, int col, int search_element) {

        //numsay to store the row and column of the searched element
        int element_pos[] = {-1, -1};
        if (row < 0 || col >= nums[row].length) {
            return element_pos;
        }
        if (nums[row][col] == search_element) {
            element_pos[0] = row;
            element_pos[1] = col;
            return element_pos;
        }
        //move up if the current element is greater than the given element  
        else if (nums[row][col] > search_element) {
            return Saddleback(nums, row - 1, col, search_element);
        }
        //otherwise move right
        return Saddleback(nums, row, col + 1, search_element);
    }

    /**
     * Main method
     *
     * @param args Command line arguments
     */
  
}
```
Sample Output:

Position of 39 in the matrix is (3,2)


### **Searching Algorithms**

1. **Linear Search**
   - **Concept**: A simple search algorithm that checks each element of the list one by one until the desired element is found or the list is exhausted.
   - **Steps**:
     1. Start from the first element of the array.
     2. Compare the target element with each element of the array.
     3. If the target element is found, return its index.
     4. If the end of the list is reached without finding the target, return an indication that the element is not found.
   - **Complexity**: O(n).

   ```java
   public class LinearSearch {
       public static int linearSearch(int[] arr, int target) {
           for (int i = 0; i < arr.length; i++) {
               if (arr[i] == target) {
                   return i;
               }
           }
           return -1;
       }
   }
   ```

2. **Binary Search**
   - **Concept**: A more efficient search algorithm for sorted arrays. It repeatedly divides the search interval in half.
   - **Steps**:
     1. Start with the middle element of the array.
     2. If the middle element is equal to the target, return its index.
     3. If the target is smaller than the middle element, search in the left half.
     4. If the target is larger, search in the right half.
   - **Complexity**: O(log n).

   ```java
   public class BinarySearch {
       public static int binarySearch(int[] arr, int target) {
           int left = 0;
           int right = arr.length - 1;
           while (left <= right) {
               int mid = left + (right - left) / 2;
               if (arr[mid] == target) {
                   return mid;
               }
               if (arr[mid] < target) {
                   left = mid + 1;
               } else {
                   right = mid - 1;
               }
           }
           return -1;
       }
   }
   ```

3. **Jump Search**
   - **Concept**: An improvement over linear search for sorted arrays. It jumps ahead by fixed steps and performs a linear search in the block where the target might be found.
   - **Steps**:
     1. Jump ahead by a fixed step size (√n).
     2. Perform linear search in the block where the target could be.
   - **Complexity**: O(√n).

   ```java
   public class JumpSearch {
       public static int jumpSearch(int[] arr, int target) {
           int n = arr.length;
           int step = (int) Math.sqrt(n);
           int prev = 0;
           while (arr[Math.min(step, n) - 1] < target) {
               prev = step;
               step += (int) Math.sqrt(n);
               if (prev >= n) {
                   return -1;
               }
           }
           for (int i = prev; i < Math.min(step, n); i++) {
               if (arr[i] == target) {
                   return i;
               }
           }
           return -1;
       }
   }
   ```

4. **Interpolation Search**
   - **Concept**: An improvement of binary search for uniformly distributed data. It estimates the position of the target based on the values at the ends of the search range.
   - **Steps**:
     1. Compute the probable position of the target using interpolation.
     2. Check if the target is at the estimated position.
     3. Adjust the search range based on whether the target is less than or greater than the value at the estimated position.
   - **Complexity**: O(log log n) on average, but can degrade to O(n) in the worst case.

   ```java
   public class InterpolationSearch {
       public static int interpolationSearch(int[] arr, int target) {
           int low = 0;
           int high = arr.length - 1;
           while (low <= high && target >= arr[low] && target <= arr[high]) {
               if (low == high) {
                   if (arr[low] == target) {
                       return low;
                   }
                   return -1;
               }
               int pos = low + ((target - arr[low]) * (high - low) / (arr[high] - arr[low]));
               if (arr[pos] == target) {
                   return pos;
               }
               if (arr[pos] < target) {
                   low = pos + 1;
               } else {
                   high = pos - 1;
               }
           }
           return -1;
       }
   }
   ```

These algorithms cover a wide range of sorting and searching tasks. They each have their own strengths and weaknesses, and the choice of algorithm depends on the specific requirements of the problem, such as the size of the dataset and whether the data is already sorted.
