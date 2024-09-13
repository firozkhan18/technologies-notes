# Java Exercises Sorting

### 1. Write a Java program to sort an array of given integers using the Quick sort algorithm.
Quick sort is a comparison sort, meaning it can sort items of any type for which a "less-than" relation (formally, a total order) is defined.

Write a Java program to sort an array of given integers using the Quick sort algorithm.

Quick sort is a comparison sort, meaning it can sort items of any type for which a "less-than" relation (formally, a total order) is defined.


Pictorial presentation - Quick Sort algorithm :

PHP Quick sort pictorial presentation
c # Quick sort part-2
Sample Solution:

Java Code:
```java
import java.util.Arrays;
public class QuickSort {
     
    private int temp_array[];
    private int len;
 
    public void sort(int[] nums) {
         
        if (nums == null || nums.length == 0) {
            return;
        }
        this.temp_array = nums;
        len = nums.length;
        quickSort(0, len - 1);
    }
     private void quickSort(int low_index, int high_index) {
         
        int i = low_index;
        int j = high_index;
        // calculate pivot number 
        int pivot = temp_array[low_index+(high_index-low_index)/2];
        // Divide into two arrays
        while (i <= j) {
               while (temp_array[i] < pivot) {
                i++;
            }
            while (temp_array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (low_index < j)
            quickSort(low_index, j);
        if (i < high_index)
            quickSort(i, high_index);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = temp_array[i];
        temp_array[i] = temp_array[j];
        temp_array[j] = temp;
    }
     
     // Method to test above
    public static void main(String args[])
    {
        QuickSort ob = new QuickSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.sort(nums);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array
[-5, 0, 1, 2, 3, 7, 45]
### 2. Write a Java program to sort an array of given integers using the Bubble Sorting Algorithm.
According to Wikipedia "Bubble sort, sometimes called sinking sort, is a simple sorting algorithm that repeatedly steps through the list to be sorted. It compares each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates the list is in order. The algorithm, which is a comparison sort, is named for the way smaller elements "bubble" to the top of the list. Although the algorithm is simple, it is too slow and impractical for most problems even compared to an insertion sort. It can be practical if the input is usually in sort order but occasionally has some out-of-order elements nearly in position."

Write a Java program to sort an array of given integers using the Bubble Sorting Algorithm.

According to Wikipedia "Bubble sort, sometimes called sinking sort, is a simple sorting algorithm that repeatedly steps through the list to be sorted. It compares each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates the list is in order. The algorithm, which is a comparison sort, is named for the way smaller elements "bubble" to the top of the list. Although the algorithm is simple, it is too slow and impractical for most problems even compared to an insertion sort. It can be practical if the input is usually in sort order but occasionally has some out-of-order elements nearly in position."


Sample Solution:

Java Code:
```java
import java.util.Arrays;
class BubbleSort
{
    void bubbleSort(int nums[])
    {
        int n = nums.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (nums[j] > nums[j+1])
                {
                    // swap temp and nums[i]
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
    }
 
    // Method to test above
    public static void main(String args[])
    {
        BubbleSort ob = new BubbleSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.bubbleSort(nums);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array
[-5, 0, 1, 2, 3, 7, 45]


### 3. Write a Java program to sort an array of given integers using the Radix sort algorithm.
According to Wikipedia "In computer science, radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping keys by the individual digits that share the same significant position and value".

Write a Java program to sort an array of given integers using the Radix sort algorithm.

According to Wikipedia "In computer science, radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping keys by the individual digits that share the same significant position and value".


Sample Solution:

Java Code:
```java
//https://bit.ly/2MJHo7J
import java.util.Arrays;
public class RadixSort {
    public static void sort(int[] array) {
        RadixSort.sort(array, 10);
    }

    public static void sort(int[] array, int radix) {
        if (array.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // Perform counting sort on each exponent/digit, starting at the least
        // significant digit
        int exponent = 1;
        while ((maxValue - minValue) / exponent >= 1) {
            RadixSort.countingSortByDigit(array, radix, exponent, minValue);
            exponent *= radix;
        }
    }

    private static void countingSortByDigit(
            int[] array, int radix, int exponent, int minValue) {
        int bucketIndex;
        int[] buckets = new int[radix];
        int[] output = new int[array.length];

        // Initialize bucket
        for (int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }

        // Count frequencies
        for (int i = 0; i < array.length; i++) {
            bucketIndex = (int)(((array[i] - minValue) / exponent) % radix);
            buckets[bucketIndex]++;
        }

        // Compute cumulates
        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        // Move records
        for (int i = array.length - 1; i >= 0; i--) {
            bucketIndex = (int)(((array[i] - minValue) / exponent) % radix);
            output[--buckets[bucketIndex]] = array[i];
        }

        // Copy back
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
	// Method to test above
    public static void main(String args[])
    {
        RadixSort ob = new RadixSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.sort(nums);
         System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(nums));
        }        
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array:
[-5, 0, 1, 2, 3, 7, 45]

### 4. Write a Java program to sort an array of given integers using the Merge Sort Algorithm.
According to Wikipedia "Merge sort (also commonly spelled mergesort) is an O (n log n) comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output."

Write a Java program to sort an array of given integers using the Merge Sort Algorithm.

According to Wikipedia "Merge sort (also commonly spelled mergesort) is an O (n log n) comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output."

Algorithm:

Conceptually, a merge sort works as follows :

Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.
An example of merge sort:

JavaScript, Merge Sort animation

Merge Sort: Pictorial Presentation

 Merge sort

Sample Solution:

Java Code:
```java
import java.util.Arrays;  
class MergeSort
{
    void merge(int nums[], int left, int m, int right)
    {
        int n1 = m - left + 1;
        int n2 = right - m;
 
        int Left_part_arra[] = new int [n1];
        int Right_part_arra[] = new int [n2];
 
        for (int i=0; i<n1; ++i)
            Left_part_arra[i] = nums[left + i];
        for (int j=0; j<n2; ++j)
            Right_part_arra[j] = nums[m + 1+ j];

        int i = 0, j = 0;
 
        int k = left;
        while (i < n1 && j < n2)
        {
            if (Left_part_arra[i] <= Right_part_arra[j])
            {
                nums[k] = Left_part_arra[i];
                i++;
            }
            else
            {
                nums[k] = Right_part_arra[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            nums[k] = Left_part_arra[i];
            i++;
            k++;
        }
 
        while (j < n2)
        {
            nums[k] = Right_part_arra[j];
            j++;
            k++;
        }
    }
 
    // merge()
    void sort(int nums[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int m = (left+right)/2;
 
            // Sort first halve
            sort(nums, left, m);
			// Sort second halve
            sort(nums , m+1, right);
 
            // Merge the sorted halves
            merge(nums, left, m, right);
        }
    }
 
	// Method to test above
    public static void main(String args[])
    {
        MergeSort ob = new MergeSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.sort(nums, 0, nums.length-1);
         System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(nums));
        }    
    
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array:
[-5, 0, 1, 2, 3, 7, 45]

### 5. Write a Java program to sort an array of given integers using the Heap sort algorithm.

In computer science heapsort (invented by J. W. J. Williams in 1964) is a comparison-based sorting algorithm. Heapsort can be thought of as an improved selection sort: like that algorithm, it divides its input into a sorted and an unsorted region, and it interactively shrinks the unsorted region by extracting the largest element and moving that to the sorted region. The improvement consists of the use of a heap data structure rather than a linear-time search to find the maximum. Although somewhat slower in practice on most machines than a well-implemented quicksort, it has the advantage of a more favorable worst-case O(n log n) runtime. Heapsort is an in-place algorithm, but not a stable sort.

Write a Java program to sort an array of given integers using the Heap sort algorithm.

In computer science heapsort (invented by J. W. J. Williams in 1964) is a comparison-based sorting algorithm. Heapsort can be thought of as an improved selection sort: like that algorithm, it divides its input into a sorted and an unsorted region, and it interactively shrinks the unsorted region by extracting the largest element and moving that to the sorted region. The improvement consists of the use of a heap data structure rather than a linear-time search to find the maximum. Although somewhat slower in practice on most machines than a well-implemented quicksort, it has the advantage of a more favorable worst-case O(n log n) runtime. Heapsort is an in-place algorithm, but not a stable sort.

A run of the heapsort algorithm sorting an array of randomly permuted values. In the first stage of the algorithm the array elements are reordered to satisfy the heap property. Before the actual sorting takes place, the heap tree structure is shown briefly for illustration.

Heapsort sorting
Animation credits : RolandH

Pseudocode:

// Ref.: https://bit.ly/2DBQsFI
function heapSort(a, count) is
   input: an unordered array a of length count
 
   (first place a in max-heap order)
   heapify(a, count)
 
   end := count - 1
   while end > 0 do
      (swap the root(maximum value) of the heap with the
       last element of the heap)
      swap(a[end], a[0])
      (decrement the size of the heap so that the previous
       max value will stay in its proper place)
      end := end - 1
      (put the heap back in max-heap order)
      siftDown(a, 0, end)
function heapify(a,count) is
   (start is assigned the index in a of the last parent node)
   start := (count - 2) / 2
   
   while start ≥ 0 do
      (sift down the node at index start to the proper place
       such that all nodes below the start index are in heap
       order)
      siftDown(a, start, count-1)
      start := start - 1
   (after sifting down the root all nodes/elements are in heap order)
 
function siftDown(a, start, end) is
   (end represents the limit of how far down the heap to sift)
   root := start

   while root * 2 + 1 ≤ end do       (While the root has at least one child)
      child := root * 2 + 1           (root*2+1 points to the left child)
      (If the child has a sibling and the child's value is less than its sibling's...)
      if child + 1 ≤ end and a[child] < a[child + 1] then
         child := child + 1           (... then point to the right child instead)
      if a[root] < a[child] then     (out of max-heap order)
         swap(a[root], a[child])
         root := child                (repeat to continue sifting down the child now)
      else
         return
Sample Solution:

Java Code:
```java
public class HeapSort
{
public static void heapSort(int[] a){
	int count = a.length;
	//first place a in max-heap order
	heapify(a, count);
	int end = count - 1;
	while(end > 0){
		//swap the root(maximum value) of the heap with the
		//last element of the heap
		int tmp = a[end];
		a[end] = a[0];
		a[0] = tmp;
		//put the heap back in max-heap order
		siftDown(a, 0, end - 1);
		//decrement the size of the heap so that the previous
		//max value will stay in its proper place
		end--;
	}
}
public static void heapify(int[] a, int count){
	//start is assigned the index in a of the last parent node
	int start = (count - 2) / 2; //binary heap
	while(start >= 0){
		//sift down the node at index start to the proper place
		//such that all nodes below the start index are in heap
		//order
		siftDown(a, start, count - 1);
		start--;
	}
	//after sifting down the root all nodes/elements are in heap order
}
public static void siftDown(int[] a, int start, int end){
	//end represents the limit of how far down the heap to sift
	int root = start;
	while((root * 2 + 1) <= end){      //While the root has at least one child
		int child = root * 2 + 1;           //root*2+1 points to the left child
		//if the child has a sibling and the child's value is less than its sibling's...
		if(child + 1 <= end && a[child] < a[child + 1])
			child = child + 1;           //... then point to the right child instead
		if(a[root] < a[child]){     //out of max-heap order
			int tmp = a[root];
			a[root] = a[child];
			a[child] = tmp;
			root = child;                //repeat to continue sifting down the child now
		}else
			return;
	}
}
// Driver program
	public static void main(String args[])
	{
		int arr[] = {7, -5, 3, 2, 1, 0, 45};
		int n = arr.length;
		HeapSort ob = new HeapSort();
		ob.heapSort(arr);
		System.out.println("Sorted array:");
		 for (int element: arr) {
            System.out.print(" "+element);
        }
	}
}
```
Sample Output:

Sorted array:
 -5 0 1 2 3 7 45

### 6. Write a Java program to sort an array of given integers using the Selection Sort Algorithm.

Wikipedia says "In computer science, selection sort is a sorting algorithm, specifically an in-place comparison sort. It has O(n2) time complexity, making it inefficient on large lists, and generally performs less efficiently than the similar insertion sort".

Write a Java program to sort an array of given integers using the Selection Sort Algorithm.

Wikipedia says "In computer science, selection sort is a sorting algorithm, specifically an in-place comparison sort. It has O(n2) time complexity, making it inefficient on large lists, and generally performs less efficiently than the similar insertion sort".

Note:
a) To find maximum of elements
b) To swap two elements


Pictorial presentation - Selection search algorithm :

Java programming Selection sort algorithm

Sample Solution:

Java Code:
```java
import  java.util.Arrays;
  public class  SelectionSort {
  public static void sort(int[] nums)
  {
  for(int currentPlace = 0;currentPlace<nums.length-1;currentPlace++){
  int smallest =  Integer.MAX_VALUE;
  int smallestAt =  currentPlace+1;
  for(int check =  currentPlace; check<nums.length;check++){
  if(nums[check]<smallest){
  smallestAt  = check;
  smallest  = nums[check];
  }
  }
  int temp =  nums[currentPlace];
  nums[currentPlace]  = nums[smallestAt];
  nums[smallestAt]  = temp;
  }
  }
  // Method to test above
  public static void main(String args[])
  {
  SelectionSort ob = new SelectionSort();
  int nums[] = {7, -5, 3, 2, 1, 0, 45};
  System.out.println("Original  Array:");
  System.out.println(Arrays.toString(nums));
  ob.sort(nums);
  System.out.println("Sorted  Array:");
  System.out.println(Arrays.toString(nums));
  }        
  }
  ```
Sample Output:

Original  Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted  Array:
[-5, 0, 1, 2, 3, 7, 45]

### 7. Write a Java program to sort an array of given integers using the Insertion sort algorithm.

Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than other algorithms such as quicksort, heapsort, or merge sort.


Write a Java program to sort an array of given integers using the Insertion sort algorithm.

Note:
Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than other algorithms such as quicksort, heapsort, or merge sort.


Pictorial presentation - Insertion search algorithm :

Java programming Insertion sort algorithm

Sample Solution:

Java Code:
```java
import java.util.Arrays;

public class InsertionSort {
  void InsertionSort(int[] nums){
  for(int i = 1; i < nums.length; i++){
    int value = nums[i];
    int j = i - 1;
    while(j >= 0 && nums[j] > value){
      nums[j + 1] = nums[j];
      j = j - 1;
    }
    nums[j + 1] = value;
  }
}
    
	// Method to test above
    public static void main(String args[])
    {
        InsertionSort ob = new InsertionSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.InsertionSort(nums);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }
}
```
Sample Output:

[7, -5, 3, 2, 1, 0, 45]
Sorted Array
[-5, 0, 1, 2, 3, 7, 45]

### 8. Write a Java program to sort an array of positive integers using the Bead Sort Algorithm.
According to Wikipedia "Bead sort, also called gravity sort, is a natural sorting algorithm, developed by Joshua J. Arulanandham, Cristian S. Calude and Michael J. Dinneen in 2002, and published in The Bulletin of the European Association for Theoretical Computer Science. Both digital and analog hardware implementations of bead sort can achieve a sorting time of O(n); however, the implementation of this algorithm tends to be significantly slower in software and can only be used to sort lists of positive integers. Also, it seems that even in the best case, the algorithm requires O(n2) space".

Write a Java program to sort an array of positive integers using the Bead Sort Algorithm.

According to Wikipedia "Bead sort, also called gravity sort, is a natural sorting algorithm, developed by Joshua J. Arulanandham, Cristian S. Calude and Michael J. Dinneen in 2002, and published in The Bulletin of the European Association for Theoretical Computer Science. Both digital and analog hardware implementations of bead sort can achieve a sorting time of O(n); however, the implementation of this algorithm tends to be significantly slower in software and can only be used to sort lists of positive integers. Also, it seems that even in the best case, the algorithm requires O(n2) space".

Sample Solution:

Java Code:
```java
public class BeadSort 
{
	public static void main(String[] args)
	{
		BeadSort now=new BeadSort();
		int[] arr=new int[(int)(Math.random()*11)+5];
		for(int i=0;i<arr.length;i++)
			arr[i]=(int)(Math.random()*10);
		System.out.print("Unsorted: ");
		now.display1D(arr);
 
		int[] sort=now.beadSort(arr);
		System.out.print("Sorted: ");
		now.display1D(sort);
	}
	int[] beadSort(int[] arr)
	{
		int max=0;
		for(int i=0;i<arr.length;i++)
			if(arr[i]>max)
				max=arr[i];
 
		//Set up abacus
		char[][] grid=new char[arr.length][max];
		int[] levelcount=new int[max];
		for(int i=0;i<max;i++)
		{
			levelcount[i]=0;
			for(int j=0;j<arr.length;j++)
				grid[j][i]='_';
		}
		/*
		display1D(arr);
		display1D(levelcount);
		display2D(grid);
		*/
 
		//Drop the beads
	
		for(int i=0;i<arr.length;i++)
		{
			int num=arr[i];
			for(int j=0;num>0;j++)
			{
				grid[levelcount[j]++][j]='*';
				num--;
			}
			
		}
		
		System.out.println();
		display2D(grid);
		//Count the beads
		int[] sorted=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			int putt=0;
			for(int j=0;j<max&&grid[arr.length-1-i][j]=='*';j++)
				putt++;
			sorted[i]=putt;
		}
 
		return sorted;
	}
	void display1D(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	void display1D(char[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	void display2D(char[][] arr)
	{
		for(int i=0;i<arr.length;i++)
			display1D(arr[i]);
		System.out.println();
	}
}
```
Sample Output:

Unsorted: 8 2 2 3 4 6 7 8 4 0 8 

* * * * * * * * 
* * * * * * * * 
* * * * * * * * 
* * * * * * * _ 
* * * * * * _ _ 
* * * * _ _ _ _ 
* * * * _ _ _ _ 
* * * _ _ _ _ _ 
* * _ _ _ _ _ _ 
* * _ _ _ _ _ _ 
_ _ _ _ _ _ _ _ 

Sorted: 0 2 2 3 4 4 6 7 8 8 8 

### 9. Write a Java program to sort an array of positive integers using the BogoSort Sort Algorithm.

In computer science, Bogosort is a particularly ineffective sorting algorithm based on the generate and test paradigm. The algorithm successively generates permutations of its input until it finds one that is sorted. It is not useful for sorting but may be used for educational purposes, to contrast it with other more realistic algorithms.

Write a Java program to sort an array of positive integers using the BogoSort Sort Algorithm.

In computer science, Bogosort is a particularly ineffective sorting algorithm based on the generate and test paradigm. The algorithm successively generates permutations of its input until it finds one that is sorted. It is not useful for sorting but may be used for educational purposes, to contrast it with other more realistic algorithms.

Sample Solution:

Java Code:
```java
public class BogoSort 
{
	public static void main(String[] args)
	{
		//Enter array to be sorted here
		int[] arr={4,5,6,0,7,8,9,1,2,3};
 
		BogoSort now=new BogoSort();
		System.out.print("Unsorted: ");
		now.display1D(arr);
 
		now.bogo(arr);
 
		System.out.print("Sorted: ");
		now.display1D(arr);
	}
	void bogo(int[] arr)
	{
		//Keep a track of the number of shuffles
		int shuffle=1;
		for(;!isSorted(arr);shuffle++)
			shuffle(arr);
		//Boast
		System.out.println("This took "+shuffle+" shuffles.");
	}
	void shuffle(int[] arr)
	{
		//Standard Fisher-Yates shuffle algorithm
		int i=arr.length-1;
		while(i>0)
			swap(arr,i--,(int)(Math.random()*i));
	}
	void swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	boolean isSorted(int[] arr)
	{
 
		for(int i=1;i<arr.length;i++)
			if(arr[i]<arr[i-1])
				return false;
		return true;
	}
	void display1D(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	} 
}
```
Sample Output:

Unsorted: 4 5 6 0 7 8 9 1 2 3 
This took 3067022 shuffles.
Sorted: 0 1 2 3 4 5 6 7 8 9 

### 10. Write a Java program to sort an array of positive integers using the Cocktail sort algorithm.

Cocktail shaker sort (also known as bidirectional bubble sort, cocktail sort, shaker sort, ripple sort, shuffle sort, or shuttle sort ) is a variation of bubble sort that is both a stable sorting algorithm and a comparison sort. The algorithm differs from a bubble sort in that it sorts in both directions on each pass through the list. This sorting algorithm is only marginally more difficult to implement than a bubble sort and solves the problem of turtles in bubble sorts. It provides only marginal performance improvements, and does not improve asymptotic performance; like the bubble sort, it is not of practical interest, though it finds some use in education.

Write a Java program to sort an array of positive integers using the Cocktail sort algorithm.

Cocktail shaker sort (also known as bidirectional bubble sort, cocktail sort, shaker sort, ripple sort, shuffle sort, or shuttle sort ) is a variation of bubble sort that is both a stable sorting algorithm and a comparison sort. The algorithm differs from a bubble sort in that it sorts in both directions on each pass through the list. This sorting algorithm is only marginally more difficult to implement than a bubble sort and solves the problem of turtles in bubble sorts. It provides only marginal performance improvements, and does not improve asymptotic performance; like the bubble sort, it is not of practical interest, though it finds some use in education.

Visualization of shaker sort :

Sorting shaker sort animation

Sample Solution:

Java Code:
```java
import java.util.Arrays;
class cocktailSort
{
    void cocktailSort(int nums[])
    {
	  boolean swapped;
	  do {
		swapped = false;
		for (int i =0; i<=  nums.length  - 2;i++) {
			if (nums[ i ] > nums[ i + 1 ]) {
				//test if two elements are in the wrong order
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1]=temp;
				swapped = true;
			}
		}
		if (!swapped) {
			break;
		}
		swapped = false;
		for (int i= nums.length - 2;i>=0;i--) {
			if (nums[ i ] > nums[ i + 1 ]) {
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1]=temp;
				swapped = true;
			}
		}
	} while (swapped);
}
    // Method to test above
    public static void main(String args[])
    {
        cocktailSort ob = new cocktailSort();
        int nums[] = {7, 5, 3, 2, 1, 12, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.cocktailSort(nums);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }
}
```
Sample Output:

Original Array:
[7, 5, 3, 2, 1, 12, 45]
Sorted Array
[1, 2, 3, 5, 7, 12, 45]  

### 11. Write a Java program to sort an array of given integers using the CombSort algorithm.

The Comb Sort is a variant of the Bubble Sort. Like the Shell sort, the Comb Sort increases the gap used in comparisons and exchanges. Some implementations use the insertion sort once the gap is less than a certain amount. The basic idea is to eliminate turtles, or small values near the end of the list, since in a bubble sort these slow the sorting down tremendously. Rabbits, large values around the beginning of the list do not pose a problem in a bubble sort.

Write a Java program to sort an array of given integers using the CombSort algorithm.

The Comb Sort is a variant of the Bubble Sort. Like the Shell sort, the Comb Sort increases the gap used in comparisons and exchanges. Some implementations use the insertion sort once the gap is less than a certain amount. The basic idea is to eliminate turtles, or small values near the end of the list, since in a bubble sort these slow the sorting down tremendously. Rabbits, large values around the beginning of the list do not pose a problem in a bubble sort.
In bubble sort, when any two elements are compared, they always have a gap of 1. The basic idea of comb sort is that the gap can be much more than 1.

Visualization of comb sort :

JavaScript: Comb sort demo

Animation credits : Jerejesse

Sample Solution:

Java Code:
```java
import java.util.Arrays;
class CombSort {
        void CombSort(int nums[]){
        int gap_length = nums.length;
        float shrinkFactor = 1.3f;
        boolean swapped = false;

        while (gap_length > 1 || swapped) {
            if (gap_length > 1) {
                gap_length = (int)(gap_length / shrinkFactor);
            }

            swapped = false;

            for (int i = 0; gap_length + i < nums.length; i++) {
                if (nums[i] > nums[i + gap_length]) {
                    swap(nums, i, i + gap_length);
                    swapped = true;
                }
            }
        }
    }
     private static void swap(int nums[], int x, int y) {
        Integer temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    // Method to test above
    public static void main(String args[])
    {
        CombSort ob = new CombSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.CombSort(nums);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array
[-5, 0, 1, 2, 3, 7, 45] 

### 12. Write a Java program to sort an array of given integers using the CountingSort algorithm.

According to Wikipedia "In computer science, counting sort is an algorithm for sorting a collection of objects according to keys that are small integers; that is, it is an integer sorting algorithm. It operates by counting the number of objects that have each distinct key value. It uses arithmetic on those counts to determine the positions of each key value in the output sequence. Its running time is linear based on the number of items and the difference between the maximum and minimum key values, so it is only suitable for direct use in situations where the variation in keys is not significantly wider than the number of items. However, it is often used as a subroutine in another sorting algorithm, radix sort, which handles larger keys more efficiently".

Write a Java program to sort an array of given integers using the CountingSort algorithm.

According to Wikipedia "In computer science, counting sort is an algorithm for sorting a collection of objects according to keys that are small integers; that is, it is an integer sorting algorithm. It operates by counting the number of objects that have each distinct key value. It uses arithmetic on those counts to determine the positions of each key value in the output sequence. Its running time is linear based on the number of items and the difference between the maximum and minimum key values, so it is only suitable for direct use in situations where the variation in keys is not significantly wider than the number of items. However, it is often used as a subroutine in another sorting algorithm, radix sort, which handles larger keys more efficiently".

The algorithm loops over the items, computing a histogram of the number of times each key occurs within the input collection. It then performs a prefix sum computation (a second loop, over the range of possible keys) to determine, for each key, the starting position in the output array of the items having that key. Finally, it loops over the items again, moving each item into its sorted position in the output array.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
class countingSort {
    void countingSort(int[] nums, int min, int max){
	  int[] ctr = new int[max - min + 1];
	  for(int number : nums){
		ctr[number - min]++;
    	}
	  int z= 0;
	  for(int i= min;i <= max;i++){
		 while(ctr[i - min] > 0){
		 	nums[z]= i;
		 	z++;
			ctr[i - min]--;
		   }
	   }
  }
  
    // Method to test above
    public static void main(String args[])
    {
        countingSort ob = new countingSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        int minValue = -5, maxValue = 45;
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.countingSort(nums,minValue,maxValue);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array
[-5, 0, 1, 2, 3, 7, 45] 

### 13. Write a Java program to sort an array of given integers using the Gnome sort algorithm.

Gnome sort is a sorting algorithm originally proposed by Dr. Hamid Sarbazi-Azad (Professor of Computer Engineering at Sharif University of Technology) in 2000 and called "stupid sort" (not to be confused with bogosort), and then later described by Dick Grune and named "gnome sort".
The algorithm always finds the first place where two adjacent elements are in the wrong order, and swaps them. It takes advantage of the fact that swapping can introduce a new out-of-order adjacent pair only next to the two swapped elements.

Write a Java program to sort an array of given integers using the Gnome sort algorithm.

Gnome sort is a sorting algorithm originally proposed by Dr. Hamid Sarbazi-Azad (Professor of Computer Engineering at Sharif University of Technology) in 2000 and called "stupid sort" (not to be confused with bogosort), and then later described by Dick Grune and named "gnome sort".
The algorithm always finds the first place where two adjacent elements are in the wrong order, and swaps them. It takes advantage of the fact that swapping can introduce a new out-of-order adjacent pair only next to the two swapped elements.

A visualization of the gnome sort:

javaScript: gnome sort animation
Sample Solution:

Java Code:
```java
import java.util.Arrays;
class gnomeSort {
 void gnomeSort(int[] nums)
  {
  int i=1;
  int j=2;
 
  while(i < nums.length) {
    if ( nums[i-1] <= nums[i] ) 
	{
      i = j; j++;
    } else {
      int tmp = nums[i-1];
      nums[i-1] = nums[i];
      nums[i--] = tmp;
      i = (i==0) ? j++ : i;
    }
  }
}
  
    // Method to test above
    public static void main(String args[])
    {
        gnomeSort ob = new gnomeSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.gnomeSort(nums);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array
[-5, 0, 1, 2, 3, 7, 45]

### 14. Write a Java program to sort an array of given integers using the Pancake sort algorithm.

Pancake sorting is the colloquial term for the mathematical problem of sorting a disordered stack of pancakes in order of size. This is when a spatula can be inserted at any point in the stack and used to flip all pancakes above it. Pancake numbers are the minimum number of flips required for a given number of pancakes. The problem was first discussed by American geometer Jacob E. Goodman. It is a variation of the sorting problem in which the only allowed operation is to reverse the elements of some prefix of the sequence.

Write a Java program to sort an array of given integers using the Pancake sort algorithm.

Pancake sorting is the colloquial term for the mathematical problem of sorting a disordered stack of pancakes in order of size. This is when a spatula can be inserted at any point in the stack and used to flip all pancakes above it. Pancake numbers are the minimum number of flips required for a given number of pancakes. The problem was first discussed by American geometer Jacob E. Goodman. It is a variation of the sorting problem in which the only allowed operation is to reverse the elements of some prefix of the sequence.

Sample Solution:

Java Code:
```java
import java.util.Arrays;  

public class PancakeSort
{
   int[] heap;
 
   public String toString() {
      String info = "";
      for (int x: heap)
         info += x + " ";
      return info;
   }
 
   public void flip(int n) {
      for (int i = 0; i < (n+1) / 2; ++i) {
         int tmp = heap[i];
         heap[i] = heap[n-i];
         heap[n-i] = tmp;
      }      
     // System.out.println("flip(0.." + n + "): " + toString());
   }
 
   public int[] minmax(int n) {
      int xm, xM;
      xm = xM = heap[0];
      int posm = 0, posM = 0;
 
      for (int i = 1; i < n; ++i) {
         if (heap[i] < xm) {
            xm = heap[i];
            posm = i;
         }
         else if (heap[i] > xM) {
            xM = heap[i];
            posM = i;
         }
      }
      return new int[] {posm, posM};
   }
 
   public void sort(int n, int dir) {
      if (n == 0) return;
 
      int[] mM = minmax(n);
      int bestXPos = mM[dir];
      int altXPos = mM[1-dir];
      boolean flipped = false;
 
      if (bestXPos == n-1) {
         --n;
      }
      else if (bestXPos == 0) {
         flip(n-1);
         --n;
      }
      else if (altXPos == n-1) {
         dir = 1-dir;
         --n;
         flipped = true;
      }
      else {
         flip(bestXPos);      }
      sort(n, dir);
 
      if (flipped) {
         flip(n);
      }
   }
 
   PancakeSort(int[] numbers) {
      heap = numbers;
      sort(numbers.length, 1);
   } 
 
   public static void main(String[] args) {
      int numbers[] = {7, -5, 3, 2, 1, 0, 45};
      System.out.println("Original Array:");
      System.out.println(Arrays.toString(numbers));
      PancakeSort pancakes = new PancakeSort(numbers);
      System.out.println("Sorted Array:");
      System.out.println(Arrays.toString(numbers));
   }
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array:
[-5, 0, 1, 2, 3, 7, 45]]

### 15. Write a Java program to sort an array of given integers using the Permutation sort algorithm.

Implement a permutation sort, which generates the possible permutations of the input array/list until discovering the sorted one.

Write a Java program to sort an array of given integers using the Permutation sort algorithm.

Implement a permutation sort, which generates the possible permutations of the input array/list until discovering the sorted one.

Sample Solution:

Java Code:
```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
 
public class PermutationSort 
{
	public static void main(String[] args)
	{
		int[] a={7, -5, 3, 2, 1, 0, 45};
		System.out.println("Unsorted: " + Arrays.toString(a));
		a=pSort(a);
		System.out.println("Sorted: " + Arrays.toString(a));
	}
	public static int[] pSort(int[] a)
	{
		List<int[]> list=new ArrayList<int[]>();
		permute(a,a.length,list);
		for(int[] x : list)
			if(isSorted(x))
				return x;
		return a;
	}
	private static void permute(int[] a, int n, List<int[]> list) 
	{
		if (n == 1) 
		{
			int[] b=new int[a.length];
			System.arraycopy(a, 0, b, 0, a.length);
			list.add(b);
		    return;
		}
		for (int i = 0; i < n; i++) 
		{
		        swap(a, i, n-1);
		        permute(a, n-1, list);
		        swap(a, i, n-1);
		 }
	}
	private static boolean isSorted(int[] a)
	{
		for(int i=1;i<a.length;i++)
			if(a[i-1]>a[i])
				return false;
		return true;
	}
	private static void swap(int[] arr,int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
```
Sample Output:

Unsorted: [7, -5, 3, 2, 1, 0, 45]
Sorted: [-5, 0, 1, 2, 3, 7, 45]

### 16. Write a Java program to sort an array of given integers Shell Sort Algorithm.

According to Wikipedia "Shell sort or Shell's method, is an in-place comparison sort. It can be seen as either a generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort). The method starts by sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be compared. Starting with far apart elements can move some out-of-place elements into position faster than a simple nearest neighbor exchange."

Write a Java program to sort an array of given integers Shell Sort Algorithm.

According to Wikipedia "Shell sort or Shell's method, is an in-place comparison sort. It can be seen as either a generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort). The method starts by sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be compared. Starting with far apart elements can move some out-of-place elements into position faster than a simple nearest neighbor exchange."


Sample Solution:

Java Code:
```java
import java.util.Arrays;
public class ShellSort {   
    public static void shell(int[] a) {
	int increment = a.length / 2;
	while (increment > 0) {
		for (int i = increment; i < a.length; i++) {
			int j = i;
			int temp = a[i];
			while (j >= increment && a[j - increment] > temp) {
				a[j] = a[j - increment];
				j = j - increment;
			}
			a[j] = temp;
		}
		if (increment == 2) {
			increment = 1;
		} else {
			increment *= (5.0 / 11);
		}
	}
    }

	// Method to test above
    public static void main(String args[])
    {
        ShellSort ob = new ShellSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.shell(nums);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(nums));
        }        
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array:
[-5, 0, 1, 2, 3, 7, 45]

### 17. Write a Java program to sort an array of given non-negative integers using the Sleep Sort Algorithm.

Sleep sort works by starting a separate task for each item to be sorted. Each task sleeps for an interval corresponding to the item's sort key, then emits the item. Items are then collected sequentially in time.
Write a Java program to sort an array of given non-negative integers using the Sleep Sort Algorithm.

Sleep sort works by starting a separate task for each item to be sorted. Each task sleeps for an interval corresponding to the item's sort key, then emits the item. Items are then collected sequentially in time.

Sample Solution:

Java Code:
```java
import java.util.concurrent.CountDownLatch;
 
public class SleepSort {
	public static void sleepSortAndPrint(int[] nums) {
		final CountDownLatch doneSignal = new CountDownLatch(nums.length);
		for (final int num : nums) {
			new Thread(new Runnable() {
				public void run() {
					doneSignal.countDown();
					try {
						doneSignal.await();
 
						//using straight milliseconds produces unpredictable
						//results with small numbers
						//using 1000 here gives a nifty demonstration
						Thread.sleep(num * 500);
						System.out.println(num);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	public static void main(String[] args) {
		int[] nums ={7, 3, 2, 1, 0, 5};
		for (int i = 0; i < args.length; i++)
			nums[i] = Integer.parseInt(args[i]);
		sleepSortAndPrint(nums);
	}
}
```
Sample Output:

0
1
2
3
5
7

### 18. Write a Java program to sort an array of given non-negative integers using the Stooge Sort Algorithm.

Stooge sort is a recursive sorting algorithm with a time complexity of O(nlog 3 / log 1.5 ) = O(n2.7095...). The running time of the algorithm is thus slower than efficient sorting algorithms, such as Merge sort, and is even slower than Bubble sort.

Write a Java program to sort an array of given non-negative integers using the Stooge Sort Algorithm.

Stooge sort is a recursive sorting algorithm with a time complexity of O(nlog 3 / log 1.5 ) = O(n2.7095...). The running time of the algorithm is thus slower than efficient sorting algorithms, such as Merge sort, and is even slower than Bubble sort.

Sample Solution:

Java Code:
```java
import java.util.Arrays;
 public class Stooge {
    public static void main(String[] args) {
      System.out.println("Original Array:");
        int[] nums = {7, -5, 3, 2, 1, 0, 45};
        System.out.println(Arrays.toString(nums));
        stoogeSort(nums);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(nums));
    }
 
    public static void stoogeSort(int[] L) {
        stoogeSort(L, 0, L.length - 1);
    }
 
    public static void stoogeSort(int[] L, int i, int j) {
        if (L[j] < L[i]) {
            int tmp = L[i];
            L[i] = L[j];
            L[j] = tmp;
        }
        if (j - i > 1) {
            int t = (j - i + 1) / 3;
            stoogeSort(L, i, j - t);
            stoogeSort(L, i + t, j);
            stoogeSort(L, i, j - t);
        }
    }
}
```
Sample Output:

Original Array:
[7, -5, 3, 2, 1, 0, 45]
Sorted Array:
[-5, 0, 1, 2, 3, 7, 45]

### 19. Write a Java program to sort an array of given integers using the Bucket Sort Algorithm.

Bucket sort is a sorting algorithm that distributes the elements of an array into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm, or by recursively applying the bucket sorting algorithm. It is a distribution sort, a generalization of pigeonhole sort, and a cousin of radix sort in the most-to-least significant digit flavor.

Write a Java program to sort an array of given integers using the Bucket Sort Algorithm.

Bucket sort is a sorting algorithm that distributes the elements of an array into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm, or by recursively applying the bucket sorting algorithm. It is a distribution sort, a generalization of pigeonhole sort, and a cousin of radix sort in the most-to-least significant digit flavor.

Sample Solution:

Java Code:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
/*Ref. https://bit.ly/3mAyUj3 */
/** Wikipedia: https://en.wikipedia.org/wiki/Bucket_sort */
public class Main {
  public static void main(String[] args) {
    int[] arr = new int[10];
    /* generate 10 random numbers from -50 to 49 */
    Random random = new Random();
    for (int i = 0; i < arr.length; ++i) {
      arr[i] = random.nextInt(100) - 50;
    }
    System.out.println("Original Array: "+Arrays.toString(arr));
    bucketSort(arr);
    /* check array is sorted or not */
    for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
         assert arr[i] <= arr[i + 1];
       }
    System.out.println("Sorted array: "+Arrays.toString(arr));
  }
  /**
   * BucketSort algorithms implements
   *
   * @param arr the array contains elements
   */
  private static void bucketSort(int[] arr) {
    /* get max value of arr */
    int max = max(arr);
    /* get min value of arr */
    int min = min(arr);
    /* number of buckets */
    int numberOfBuckets = max - min + 1;
    List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
    /* init buckets */
    for (int i = 0; i < numberOfBuckets; ++i) {
      buckets.add(new ArrayList<>());
    }
    /* store elements to buckets */
    for (int value : arr) {
      int hash = hash(value, min, numberOfBuckets);
      buckets.get(hash).add(value);
    }
    /* sort individual bucket */
    for (List<Integer> bucket : buckets) {
      Collections.sort(bucket);
    }
    /* concatenate buckets to origin array */
    int index = 0;
    for (List<Integer> bucket : buckets) {
      for (int value : bucket) {
        arr[index++] = value;
      }
    }
  }
  /**
   * Get index of bucket which of our elements gets placed into it.
   *
   * @param elem the element of array to be sorted
   * @param min min value of array
   * @param numberOfBucket the number of bucket
   * @return index of bucket
   */
  private static int hash(int elem, int min, int numberOfBucket) {
    return (elem - min) / numberOfBucket;
  }
  /**
   * Calculate max value of array
   *
   * @param arr the array contains elements
   * @return max value of given array
   */
  public static int max(int[] arr) {
    int max = arr[0];
    for (int value : arr) {
      if (value > max) {
        max = value;
      }
    }
    return max;
  }
  /**
   * Calculate min value of array
   *
   * @param arr the array contains elements
   * @return min value of given array
   */
  public static int min(int[] arr) {
    int min = arr[0];
    for (int value : arr) {
      if (value < min) {
        min = value;
      }
    }
    return min;
  }
}
```
Sample Output:

Original Array: [14, -15, 15, 17, 32, -4, 33, -42, 38, -36]
Sorted array: [-42, -36, -15, -4, 14, 15, 17, 32, 33, 38]

Sorting and searching are fundamental operations in computer science. Here, we’ll cover several popular sorting and searching algorithms in Java, explaining each concept and their steps.

### **Sorting Algorithms**

1. **Bubble Sort**
   - **Concept**: A simple comparison-based sorting algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.
   - **Steps**:
     1. Compare the first element with the next element.
     2. If the first element is greater, swap them.
     3. Move to the next pair and repeat until the end of the list.
     4. Repeat the process for the entire list, reducing the range with each pass.
   - **Complexity**: O(n²) (where n is the number of elements).

   ```java
   public class BubbleSort {
       public static void bubbleSort(int[] arr) {
           int n = arr.length;
           for (int i = 0; i < n - 1; i++) {
               for (int j = 0; j < n - i - 1; j++) {
                   if (arr[j] > arr[j + 1]) {
                       int temp = arr[j];
                       arr[j] = arr[j + 1];
                       arr[j + 1] = temp;
                   }
               }
           }
       }
   }
   ```

2. **Selection Sort**
   - **Concept**: This algorithm divides the input list into two parts: the sorted part and the unsorted part. It repeatedly selects the smallest (or largest) element from the unsorted part and moves it to the end of the sorted part.
   - **Steps**:
     1. Start with the first element and find the smallest element in the unsorted part.
     2. Swap it with the first unsorted element.
     3. Move the boundary between sorted and unsorted parts.
     4. Repeat until the entire list is sorted.
   - **Complexity**: O(n²).

   ```java
   public class SelectionSort {
       public static void selectionSort(int[] arr) {
           int n = arr.length;
           for (int i = 0; i < n - 1; i++) {
               int minIndex = i;
               for (int j = i + 1; j < n; j++) {
                   if (arr[j] < arr[minIndex]) {
                       minIndex = j;
                   }
               }
               int temp = arr[minIndex];
               arr[minIndex] = arr[i];
               arr[i] = temp;
           }
       }
   }
   ```

3. **Insertion Sort**
   - **Concept**: Builds the final sorted list one item at a time. It takes each element from the input and finds the appropriate position for it in the already sorted part of the list.
   - **Steps**:
     1. Take the second element and compare it with the first element.
     2. Insert it into the correct position in the sorted part.
     3. Move to the next element and repeat the process.
   - **Complexity**: O(n²) in the worst case, O(n) in the best case (when the array is already sorted).

   ```java
   public class InsertionSort {
       public static void insertionSort(int[] arr) {
           int n = arr.length;
           for (int i = 1; i < n; i++) {
               int key = arr[i];
               int j = i - 1;
               while (j >= 0 && arr[j] > key) {
                   arr[j + 1] = arr[j];
                   j--;
               }
               arr[j + 1] = key;
           }
       }
   }
   ```

4. **Merge Sort**
   - **Concept**: A divide-and-conquer algorithm that divides the list into halves, sorts each half, and then merges the sorted halves back together.
   - **Steps**:
     1. Divide the list into two halves.
     2. Recursively sort each half.
     3. Merge the two sorted halves.
   - **Complexity**: O(n log n).

   ```java
   public class MergeSort {
       public static void mergeSort(int[] arr, int left, int right) {
           if (left < right) {
               int mid = (left + right) / 2;
               mergeSort(arr, left, mid);
               mergeSort(arr, mid + 1, right);
               merge(arr, left, mid, right);
           }
       }

       private static void merge(int[] arr, int left, int mid, int right) {
           int n1 = mid - left + 1;
           int n2 = right - mid;
           int[] leftArr = new int[n1];
           int[] rightArr = new int[n2];

           System.arraycopy(arr, left, leftArr, 0, n1);
           System.arraycopy(arr, mid + 1, rightArr, 0, n2);

           int i = 0, j = 0;
           int k = left;
           while (i < n1 && j < n2) {
               if (leftArr[i] <= rightArr[j]) {
                   arr[k++] = leftArr[i++];
               } else {
                   arr[k++] = rightArr[j++];
               }
           }
           while (i < n1) {
               arr[k++] = leftArr[i++];
           }
           while (j < n2) {
               arr[k++] = rightArr[j++];
           }
       }
   }
   ```

5. **Quick Sort**
   - **Concept**: Another divide-and-conquer algorithm that selects a 'pivot' element and partitions the array around the pivot. The array is then sorted recursively.
   - **Steps**:
     1. Choose a pivot element from the array.
     2. Partition the array into two sub-arrays: elements less than the pivot and elements greater than the pivot.
     3. Recursively apply the same process to the sub-arrays.
   - **Complexity**: O(n log n) on average, O(n²) in the worst case.

   ```java
   public class QuickSort {
       public static void quickSort(int[] arr, int low, int high) {
           if (low < high) {
               int pi = partition(arr, low, high);
               quickSort(arr, low, pi - 1);
               quickSort(arr, pi + 1, high);
           }
       }

       private static int partition(int[] arr, int low, int high) {
           int pivot = arr[high];
           int i = low - 1;
           for (int j = low; j < high; j++) {
               if (arr[j] <= pivot) {
                   i++;
                   int temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }
           }
           int temp = arr[i + 1];
           arr[i + 1] = arr[high];
           arr[high] = temp;
           return i + 1;
       }
   }
   ```

6. **Heap Sort**
   - **Concept**: Builds a heap from the input data and then repeatedly extracts the maximum element from the heap to get the sorted array.
   - **Steps**:
     1. Build a max heap from the input data.
     2. Swap the root of the heap with the last element of the heap.
     3. Heapify the root of the tree.
     4. Repeat the process for the reduced heap.
   - **Complexity**: O(n log n).

   ```java
   public class HeapSort {
       public static void heapSort(int[] arr) {
           int n = arr.length;
           for (int i = n / 2 - 1; i >= 0; i--) {
               heapify(arr, n, i);
           }
           for (int i = n - 1; i >= 0; i--) {
               int temp = arr[0];
               arr[0] = arr[i];
               arr[i] = temp;
               heapify(arr, i, 0);
           }
       }

       private static void heapify(int[] arr, int n, int i) {
           int largest = i;
           int left = 2 * i + 1;
           int right = 2 * i + 2;
           if (left < n && arr[left] > arr[largest]) {
               largest = left;
           }
           if (right < n && arr[right] > arr[largest]) {
               largest = right;
           }
           if (largest != i) {
               int temp = arr[i];
               arr[i] = arr[largest];
               arr[largest] = temp;
               heapify(arr, n, largest);
           }
       }
   }
   ```

7. **Counting Sort**
   - **Concept**: A non-comparison-based sorting algorithm that counts the occurrences of each unique element and then computes the positions of each element in the sorted output.
   - **Steps**:
     1. Determine the range of input values.
     2. Count the occurrences of each element.
     3. Calculate the position of each element in the sorted array.
     4. Construct the sorted output based on these positions.
   - **Complexity**: O(n + k), where k is the range of input values.

   ```java
   public class CountingSort {
       public static void countingSort(int[] arr) {
           int max = Arrays.stream(arr).max().getAsInt();
           int[] count = new int[max + 1];
           int[] output = new int[arr.length];

           for (int num : arr) {
               count[num]++;
           }
           for (int i = 1; i <= max; i++) {
               count[i] += count[i - 1];
           }
           for (int i = arr.length - 1; i >= 0; i--) {
               output[count[arr[i]] - 1] = arr[i];
               count[arr[i]]--;
           }
           System.arraycopy(output, 0, arr, 0, arr.length);
       }
   }
   ```

