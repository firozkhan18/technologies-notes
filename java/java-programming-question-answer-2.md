
<details>
<summary><b> 1. Java program to find the sum of all elements in an array:</b></summary>
    
```java
public class SumOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        for(int num : arr) {
            sum += num;
        }

        System.out.println("Sum of all elements in the array: " + sum);
    }
}
```

- Using Lambda:

```java
int[] array = {1, 2, 3, 4, 5};

int sum = Arrays.stream(array).sum();

System.out.println("Sum of all elements in the array: " + sum);
```
</details>
<details>
<summary><b> 2. Java program to find the largest element in an array:</b></summary>
    
```java
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        int largest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("Largest element in the array: " + largest);
    }
}
```
- Using Lambda:


```java
int[] array = {1, 2, 3, 4, 5};

int max = Arrays.stream(array).max().getAsInt();

System.out.println("Largest element in the array: " + max);
```
</details>
<details>
<summary><b> 3. Java program to find the second largest element in an array:</b></summary>
    
```java
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        int firstLargest = arr[0];
        int secondLargest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if(arr[i] > secondLargest && arr[i] != firstLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Second largest element in the array: " + secondLargest);
    }
}
```

- Using Lambda:

```java
int[] array = {1, 3, 4, 2, 5};

int secondLargest = Arrays.stream(array)
        .boxed()
        .sorted(Collections.reverseOrder())
        .distinct()
        .skip(1)
        .findFirst()
        .get();

System.out.println("Second largest element in the array: " + secondLargest);
```
</details>
<details>
<summary><b> 4. Java program to find the smallest element in an array:</b></summary>
    
```java
public class SmallestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        int smallest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        System.out.println("Smallest element in the array: " + smallest);
    }
}
```
- Using Lambda:

```java
int[] array = {5, 2, 3, 1, 4};

int min = Arrays.stream(array).min().getAsInt();

System.out.println("Smallest element in the array: " + min);
```
</details>
<details>
<summary><b> 5. Java program to find the second smallest element in an array:</b></summary>

```java
public class SecondSmallestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        int firstSmallest = arr[0];
        int secondSmallest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = arr[i];
            } else if(arr[i] < secondSmallest && arr[i] != firstSmallest) {
                secondSmallest = arr[i];
            }
        }

        System.out.println("Second smallest element in the array: " + secondSmallest);
    }
}
```
- Using Lambda:

```java
int[] array = {5, 3, 1, 4, 2};

int secondSmallest = Arrays.stream(array)
        .boxed()
        .sorted()
        .distinct()
        .skip(1)
        .findFirst()
        .get();

System.out.println("Second smallest element in the array: " + secondSmallest);
```
</details>
<details>
<summary><b> 6. Java program to reverse an array:</b></summary>
    
```java
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        
        for(int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }

        System.out.print("Reversed array: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```
- Using Lambda:

```java
int[] array = {1, 2, 3, 4, 5};

int[] reversedArray = IntStream.rangeClosed(1, array.length)
        .map(i -> array[array.length - i])
        .toArray();

System.out.println("Reversed array: " + Arrays.toString(reversedArray));
```
</details>
<details>
<summary><b> 7. Java program to check if an array is sorted in ascending order:</b></summary>
    
```java
public class ArrayAscendingOrder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        boolean ascending = true;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                ascending = false;
                break;
            }
        }

        if(ascending){
            System.out.println("The array is sorted in ascending order.");
        } else {
            System.out.println("The array is not sorted in ascending order.");
        }
    }
}
```
- Using Lambda:

```java
int[] array = {1, 2, 3, 4, 5};

boolean isSorted = Arrays.stream(array)
        .sorted()
        .boxed()
        .collect(Collectors.toList())
        .equals(Arrays.stream(array).boxed().collect(Collectors.toList()));

System.out.println("Is the array sorted in ascending order? " + isSorted);
```
</details>
<details>
<summary><b> 8. Java program to check if an array is sorted in descending order:</b></summary>
    
```java
public class ArrayDescendingOrder {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        boolean descending = true;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]) {
                descending = false;
                break;
            }
        }

        if(descending){
            System.out.println("The array is sorted in descending order.");
        } else {
            System.out.println("The array is not sorted in descending order.");
        }
    }
}
```
- Using Lambda:

```java
int[] array = {5, 4, 3, 2, 1};

boolean isSorted = Arrays.stream(array)
        .sorted(Collections.reverseOrder())
        .boxed()
        .collect(Collectors.toList())
        .equals(Arrays.stream(array).boxed().collect(Collectors.toList()));

System.out.println("Is the array sorted in descending order? " + isSorted);
```
</details>
<details>
<summary><b> 9. Java program to remove duplicate elements from an array:</b></summary>
    
```java
import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4, 5};
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int num : arr) {
            set.add(num);
        }

        int[] newArr = new int[set.size()];
        int index = 0;

        for(int num : set) {
            newArr[index++] = num;
        }

        System.out.println("Array with duplicates removed: " + Arrays.toString(newArr));
    }
}
```
- Using Lambda:

```java
int[] array = {1, 2, 2, 3, 4, 4, 5};

int[] uniqueArray = Arrays.stream(array)
        .distinct()
        .toArray();

System.out.println("Array with duplicates removed: " + Arrays.toString(uniqueArray));
```
</details>
<details>
<summary><b> 10. Java program to find the frequency of each element in an array:</b></summary>
    
```java
import java.util.HashMap;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4, 5};
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for(int key : frequencyMap.keySet()) {
            System.out.println("Frequency of " + key + ": " + frequencyMap.get(key));
        }
    }
}
```
- Using Lambda:

```java
int[] array = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

Map<Integer, Long> frequencyMap = Arrays.stream(array)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println("Frequency of each element in the array: " + frequencyMap);
```
</details>
