# Java Exercises Thread

In computer science, a thread of execution is the smallest sequence of programmed instructions that can be managed independently by a scheduler, which is typically a part of the  operating system. The implementation of threads and  processes differs between  operating systems.

A thread is a thread of execution in a program. The  Java Virtual Machine allows an application to have multiple threads of execution running concurrently.

Every thread has a priority. Threads with higher priority are executed in preference to threads with lower priority. Each thread may or may not also be marked as a daemon. When code running in some thread creates a new Thread object, the new thread has its priority initially set equal to the priority of the creating thread, and is a daemon thread if and only if the creating thread is a daemon.


### 1. Write a Java program to create a basic Java thread that prints " Hello, World!" when executed.
```java
public class Hello_world_thread extends Thread {
  @Override
  public void run() {
    System.out.println("Hello, World!");
  }
  public static void main(String[] args) {
    Hello_world_thread thread = new Hello_world_thread();
    thread.start();
  }
}
```
Explanation:

In the above exercise,

In the main method, an instance of the Hello_world_thread class is created, and the start() method is called on that instance. This starts the thread's execution, which invokes the over ridden run() method.


When the program is executed, it creates another thread and runs it, causing " Hello, World!" to be printed to the console.

### 2. Write a Java program that creates two threads to find and print even and odd numbers from 1 to 20.

Write a Java program that creates two threads to find and print even and odd numbers from 1 to 20.

Sample Solution:

Java Code:
```java
public class Find_Even_Odd_Number {
  private static final int MAX_NUMBER = 20;
  private static Object lock = new Object();
  private static boolean isEvenTurn = true;

  public static void main(String[] args) {
    Thread evenThread = new Thread(() -> {
      for (int i = 2; i <= MAX_NUMBER; i += 2) {
        synchronized(lock) {
          while (!isEvenTurn) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("Even Number from evenThread: " + i);
          isEvenTurn = false;
          lock.notify();
        }
      }
    });

    Thread oddThread = new Thread(() -> {
      for (int i = 1; i <= MAX_NUMBER; i += 2) {
        synchronized(lock) {
          while (isEvenTurn) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("Odd Number from oddThread: " + i);
          isEvenTurn = true;
          lock.notify();
        }
      }
    });

    evenThread.start();
    oddThread.start();
  }
}
```
Sample Output:

 Even Number from evenThread: 2
Odd Number from oddThread: 1
Even Number from evenThread: 4
Odd Number from oddThread: 3
Even Number from evenThread: 6
Odd Number from oddThread: 5
Even Number from evenThread: 8
Odd Number from oddThread: 7
Even Number from evenThread: 10
Odd Number from oddThread: 9
Even Number from evenThread: 12
Odd Number from oddThread: 11
Even Number from evenThread: 14
Odd Number from oddThread: 13
Even Number from evenThread: 16
Odd Number from oddThread: 15
Even Number from evenThread: 18
Odd Number from oddThread: 17
Even Number from evenThread: 20
Odd Number from oddThread: 19
Java Thread Exercises: Find and Print Even-Odd Numbers with Threads

Explanation:

The evenThread prints even numbers. It starts with 2 and increments by 2 in each iteration until it reaches MAX_NUMBER (which is 20 in this case). It uses a synchronized block with a while loop to check if it's its turn to print. If not, it waits by calling lock.wait(). When it's its turn, it prints the even number and notifies the oddThread by calling lock.notify().


The oddThread prints odd numbers. It starts with 1 and increments by 2 in each iteration until it reaches MAX_NUMBER. Similar to the evenThread, it uses a synchronized block with a while loop to check if it's its turn to print. If not, it waits by calling lock.wait(). When it's its turn, it prints the odd number and notifies the evenThread by calling lock.notify().

### 3. Write a Java program that sorts an array of integers using multiple threads.

Write a Java program that sorts an array of integers using multiple threads.

The program divides the sorting task among multiple threads and perform parallel sorting to improve the performance of sorting large arrays.

Sample Solution:

Java Code:
```java
import java.util.Arrays;

public class ParallelSort {
  private static final int ARRAY_SIZE = 400;
  private static final int NUM_THREADS = 4;

  public static void main(String[] args) {
    int[] array = createArray();
    System.out.println("Before sorting: " + Arrays.toString(array));

    Thread[] threads = new Thread[NUM_THREADS];
    int segmentSize = ARRAY_SIZE / NUM_THREADS;

    for (int i = 0; i < NUM_THREADS; i++) {
      int startIndex = i * segmentSize;
      int endIndex = (i == NUM_THREADS - 1) ? ARRAY_SIZE - 1 : (startIndex + segmentSize - 1);
      threads[i] = new Thread(new SortTask(array, startIndex, endIndex));
      threads[i].start();
    }

    for (Thread thread: threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    mergeSort(array, 0, ARRAY_SIZE - 1);

    System.out.println("After sorting: " + Arrays.toString(array));
  }

  private static int[] createArray() {
    int[] array = new int[ARRAY_SIZE];
    for (int i = 0; i < ARRAY_SIZE; i++) {
      array[i] = (int)(Math.random() * 400); // Generate random numbers between 0 and 400
    }
    return array;
  }

  private static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
  }

  private static void merge(int[] array, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
      if (array[i] <= array[j]) {
        temp[k++] = array[i++];
      } else {
        temp[k++] = array[j++];
      }
    }

    while (i <= mid) {
      temp[k++] = array[i++];
    }

    while (j <= right) {
      temp[k++] = array[j++];
    }

    System.arraycopy(temp, 0, array, left, temp.length);
  }

  static class SortTask implements Runnable {
    private int[] array;
    private int startIndex;
    private int endIndex;

    public SortTask(int[] array, int startIndex, int endIndex) {
      this.array = array;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }

    @Override
    public void run() {
      Arrays.sort(array, startIndex, endIndex + 1);
    }
  }
}
```
Sample Output:

Before sorting: [317, 153, 98, 262, 171, 100, 371, 350, 386, 162, 139, 160, 69, 59, 331, 305, 12, 312, 190, 385, 355, 259, 9, 96, 217, 340, 313, 46, 47, 213, 200, 121, 94, 79, 64, 47, 91, 113, 192, 268, 135, 362, 256, 72, 299, 181, 22, 174, 360, 217, 149, 238, 67, 226, 261, 91, 26, 17, 292, 300, 107, 314, 389, 75, 222, 322, 129, 186, 133, 356, 129, 134, 313, 276, 376, 133, 352, 95, 205, 50, 152, 303, 296, 4, 281, 328, 282, 110, 16, 359, 70, 266, 143, 226, 353, 69, 395, 291, 197, 395, 171, 188, 346, 177, 179, 146, 319, 202, 71, 105, 399, 182, 367, 398, 396, 30, 170, 251, 390, 361, 75, 127, 39, 334, 294, 92, 157, 272, 120, 112, 323, 383, 122, 29, 397, 291, 392, 290, 87, 390, 39, 359, 299, 223, 88, 325, 35, 232, 46, 264, 69, 247, 392, 147, 56, 39, 345, 138, 223, 299, 114, 207, 74, 27, 160, 234, 0, 125, 44, 101, 49, 263, 216, 351, 169, 341, 346, 316, 27, 318, 27, 154, 389, 109, 141, 351, 73, 100, 17, 230, 184, 374, 214, 152, 387, 48, 235, 74, 309, 68, 185, 337, 23, 138, 281, 130, 146, 32, 82, 337, 322, 114, 399, 253, 129, 258, 256, 123, 74, 183, 158, 328, 229, 195, 177, 54, 332, 385, 88, 26, 84, 340, 252, 319, 68, 87, 76, 8, 31, 238, 196, 304, 21, 392, 86, 171, 0, 117, 310, 344, 110, 341, 37, 245, 145, 297, 185, 19, 365, 274, 168, 145, 367, 177, 198, 25, 161, 234, 141, 365, 389, 350, 102, 2, 282, 193, 15, 30, 167, 257, 293, 336, 32, 170, 330, 304, 75, 310, 248, 116, 98, 16, 245, 151, 51, 318, 322, 280, 384, 358, 362, 354, 147, 131, 382, 305, 129, 253, 179, 194, 270, 135, 92, 103, 126, 57, 214, 93, 155, 130, 107, 54, 149, 63, 128, 9, 354, 399, 392, 253, 13, 394, 306, 311, 289, 122, 338, 96, 367, 128, 8, 301, 347, 334, 269, 278, 250, 134, 158, 121, 265, 373, 39, 145, 107, 183, 83, 212, 190, 33, 83, 254, 296, 229, 66, 259, 56, 159, 45, 84, 385, 219, 32, 393, 258, 98, 139, 167, 266, 122, 14, 377, 280, 146, 157, 376, 190, 342, 145, 161, 44, 4, 296, 222, 142, 10, 1, 117, 40, 382]
After sorting: [0, 0, 1, 2, 4, 4, 8, 8, 9, 9, 10, 12, 13, 14, 15, 16, 16, 17, 17, 19, 21, 22, 23, 25, 26, 26, 27, 27, 27, 29, 30, 30, 31, 32, 32, 32, 33, 35, 37, 39, 39, 39, 39, 40, 44, 44, 45, 46, 46, 47, 47, 48, 49, 50, 51, 54, 54, 56, 56, 57, 59, 63, 64, 66, 67, 68, 68, 69, 69, 69, 70, 71, 72, 73, 74, 74, 74, 75, 75, 75, 76, 79, 82, 83, 83, 84, 84, 86, 87, 87, 88, 88, 91, 91, 92, 92, 93, 94, 95, 96, 96, 98, 98, 98, 100, 100, 101, 102, 103, 105, 107, 107, 107, 109, 110, 110, 112, 113, 114, 114, 116, 117, 117, 120, 121, 121, 122, 122, 122, 123, 125, 126, 127, 128, 128, 129, 129, 129, 129, 130, 130, 131, 133, 133, 134, 134, 135, 135, 138, 138, 139, 139, 141, 141, 142, 143, 145, 145, 145, 145, 146, 146, 146, 147, 147, 149, 149, 151, 152, 152, 153, 154, 155, 157, 157, 158, 158, 159, 160, 160, 161, 161, 162, 167, 167, 168, 169, 170, 170, 171, 171, 171, 174, 177, 177, 177, 179, 179, 181, 182, 183, 183, 184, 185, 185, 186, 188, 190, 190, 190, 192, 193, 194, 195, 196, 197, 198, 200, 202, 205, 207, 212, 213, 214, 214, 216, 217, 217, 219, 222, 222, 223, 223, 226, 226, 229, 229, 230, 232, 234, 234, 235, 238, 238, 245, 245, 247, 248, 250, 251, 252, 253, 253, 253, 254, 256, 256, 257, 258, 258, 259, 259, 261, 262, 263, 264, 265, 266, 266, 268, 269, 270, 272, 274, 276, 278, 280, 280, 281, 281, 282, 282, 289, 290, 291, 291, 292, 293, 294, 296, 296, 296, 297, 299, 299, 299, 300, 301, 303, 304, 304, 305, 305, 306, 309, 310, 310, 311, 312, 313, 313, 314, 316, 317, 318, 318, 319, 319, 322, 322, 322, 323, 325, 328, 328, 330, 331, 332, 334, 334, 336, 337, 337, 338, 340, 340, 341, 341, 342, 344, 345, 346, 346, 347, 350, 350, 351, 351, 352, 353, 354, 354, 355, 356, 358, 359, 359, 360, 361, 362, 362, 365, 365, 367, 367, 367, 371, 373, 374, 376, 376, 377, 382, 382, 383, 384, 385, 385, 385, 386, 387, 389, 389, 389, 390, 390, 392, 392, 392, 392, 393, 394, 395, 395, 396, 397, 398, 399, 399, 399]
Java Thread Exercises: Multithreaded Java Program: Sorting an Array of Integers

Explanation:

In the above exercise,

The ParallelSort class is defined to perform parallel sorting.
The program begins by defining the array size (ARRAY_SIZE) and the number of threads to use (NUM_THREADS).
The main() method is the program's entry point. It first creates an array of integers using the createArray() method, which generates random numbers between 0 and 400.
The array's initial state isrinted using Arrays.toString().
An array of threads, threads, is created to handle sorting. The array is divided into segments, and each thread is assigned a specific segment to sort. The size of each segment is determined by dividing the array size by the number of threads.
Loops create and start each thread. The SortTask class represents the sorting task performed by each thread. It takes the array, start index, and end index as input parameters and uses Arrays.sort() to sort the assigned segment of the array.
Another loop waits for all threads to complete execution using join().
After the parallel sorting operation is complete, the entire array is sorted using the mergeSort() method, which implements the merge sort algorithm. The merge() method is a helper method used in the merge sort algorithm to merge two sorted subarrays.
Finally, the sorted array is printed using Arrays.toString().

### 4. Write a Java program that performs matrix multiplication using multiple threads.

Write a Java program that performs matrix multiplication using multiple threads.

Sample Solution:

Java Code:
```java
public class MatrixMultiplication {
  private static final int MATRIX_SIZE = 3;
  private static final int NUM_THREADS = 2;

  public static void main(String[] args) {
    int[][] matrix1 = {
      {
        1,
        2,
        3
      },
      {
        4,
        5,
        6
      },
      {
        7,
        8,
        9
      }
    };

    int[][] matrix2 = {
      {
        9,
        8,
        7
      },
      {
        6,
        5,
        4
      },
      {
        3,
        2,
        1
      }
    };

    int[][] result = new int[MATRIX_SIZE][MATRIX_SIZE];

    Thread[] threads = new Thread[NUM_THREADS];
    int segmentSize = MATRIX_SIZE / NUM_THREADS;

    for (int i = 0; i < NUM_THREADS; i++) {
      int startIndex = i * segmentSize;
      int endIndex = (i == NUM_THREADS - 1) ? MATRIX_SIZE - 1 : (startIndex + segmentSize - 1);
      threads[i] = new Thread(new MultiplicationTask(matrix1, matrix2, result, startIndex, endIndex));
      threads[i].start();
    }

    for (Thread thread: threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Print the result matrix
    System.out.println("Result:");
    for (int[] row: result) {
      for (int element: row) {
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }

  static class MultiplicationTask implements Runnable {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;
    private int startIndex;
    private int endIndex;

    public MultiplicationTask(int[][] matrix1, int[][] matrix2, int[][] result, int startIndex, int endIndex) {
      this.matrix1 = matrix1;
      this.matrix2 = matrix2;
      this.result = result;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }

    @Override
    public void run() {
      int cols = matrix2[0].length;

      for (int i = startIndex; i <= endIndex; i++) {
        for (int j = 0; j < cols; j++) {
          for (int k = 0; k < MATRIX_SIZE; k++) {
            result[i][j] += matrix1[i][k] * matrix2[k][j];
          }
        }
      }
    }
  }
}
```
Sample Output:

 Result:
78 96 114
186 240 294
294 384 474
Java Thread Exercises: Multithreaded Java Program: Matrix Multiplication

Explanation:

In the above exercise,

The Matrix_Multiplication class performs matrix multiplication operation.
The program begins by defining the size of the matrix (MATRIX_SIZE) and the number of threads to use (NUM_THREADS).
Two input matrices, matrix1 and matrix2, are declared and initialized with their respective values.
An empty result matrix is created to store the matrix multiplication result.
An array of threads, threads, is created to handle matrix multiplication. The number of rows in the matrixes is divided into segments based on the number of threads. Each thread multiplies a specific segment of the matrix.
In a loop, the start and end indexes are calculated for each thread based on the segment size. The threads are created and started, with each thread executing the Multiplication_Task class.
Another loop waits for all threads to complete their execution using the join() method.
The result matrix is printed by iterating through its rows and columns.
The Multiplication_Task class represents the matrix multiplication task performed by each thread. It takes input matrices, the result matrix, start index, and end index as input parameters. In the run() method, each thread performs matrix multiplication for the rows in the result matrix. It uses nested loops to iterate through the rows and columns of the matrices and calculates the corresponding element of the result matrix.

### 5. Write a Java program that calculates the sum of all prime numbers up to a given limit using multiple threads.

Write a Java program that calculates the sum of all prime numbers up to a given limit using multiple threads.

Sample Solution:

Java Code:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prime_Sum {
  private static final int NUM_THREADS = 4;

  public static void main(String[] args) {
    int limit = 10000000;

    Thread[] threads = new Thread[NUM_THREADS];
    PrimeSumTask[] tasks = new PrimeSumTask[NUM_THREADS];

    int segmentSize = limit / NUM_THREADS;
    int start = 2;
    int end = segmentSize;

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < NUM_THREADS; i++) {
      if (i == NUM_THREADS - 1) {
        // Last thread takes care of remaining numbers
        end = limit;
      }

      tasks[i] = new PrimeSumTask(start, end);
      threads[i] = new Thread(tasks[i]);
      threads[i].start();

      start = end + 1;
      end += segmentSize;
    }

    long sum = 0;

    for (int i = 0; i < NUM_THREADS; i++) {
      try {
        threads[i].join();
        sum += tasks[i].getSum();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    long endTime = System.currentTimeMillis();

    System.out.println("Sum of prime numbers up to " + limit + ": " + sum);
    System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
  }

  static class PrimeSumTask implements Runnable {
    private int start;
    private int end;
    private long sum;

    public PrimeSumTask(int start, int end) {
      this.start = start;
      this.end = end;
      this.sum = 0;
    }

    public long getSum() {
      return sum;
    }

    private boolean isPrime(int number) {
      if (number < 2) {
        return false;
      }

      for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
          return false;
        }
      }

      return true;
    }

    @Override
    public void run() {
      for (int i = start; i <= end; i++) {
        if (isPrime(i)) {
          sum += i;
        }
      }
    }
  }
}
```
Sample Output:

Sum of prime numbers up to 10000000: 3203324994356
Time taken: 1800 milliseconds
Pictorial Presentation:

Multithreaded Java Program: Sum of Prime Numbers
Explanation:

In the above exercise,

The Prime_Sum class is the main class of the program.
The NUM_THREADS constant is set to 4, indicating the number of threads to be used for parallel processing.
The main method is the program entry point. It starts by setting the limit variable, which determines the upper limit of the prime number range.
An array of threads and tasks are created, both with NUM_THREADS. These arrays will store the threads and tasks responsible for calculating the prime number sum.
The segmentSize variable is calculated by dividing the limit by the number of threads. This determines the size of each segment of numbers to be processed by each thread.
Two variables, start and end, are initialized to specify the range of numbers to be processed by each thread. Initially, start is set to 2, which is the smallest prime number.
Loops create and start threads. Each thread is assigned a segment of numbers to process. The last thread handles the remaining numbers that do not fit evenly into the segments. The PrimeSumTask class defines the thread's task.
Inside the loop, PrimeSumTask objects are created with the corresponding start and end values. The threads are initialized with these tasks and started.
After starting all the threads, a sum variable is initialized to hold the cumulative sum of prime numbers.
Another loop waits for all threads to finish execution using the join() method. Within this loop, the sum of each task is accumulated in the sum variable.
The program measures execution time by recording start and end times using System.currentTimeMillis().
Finally, the total sum of prime numbers and the execution time are printed to the console.
The PrimeSumTask class implements the Runnable interface and represents the thread's task. It takes the segment start and end values as parameters.
The getSum() method provides access to the sum calculated by each task.
The isPrime() method checks if a number is prime. It returns true if the number is prime, and false otherwise.
The run() method defines the execution logic of each task. It iterates through each segment of numbers and checks if each number is prime. If a number is prime, it adds it to the sum variable.

### 6. Write a Java program to implement a concurrent web crawler that crawls multiple websites simultaneously using threads.

Write a Java program to implement a concurrent  web crawler that crawls multiple websites simultaneously using threads.

Note:

 jsoup: Java HTML Parser

 jsoup is a Java library for working with real-world HTML. It provides a very convenient API for fetching URLs and extracting and manipulating data, using the best of HTML5 DOM methods and CSS selectors.

Download and install jsoup from here.

Sample Solution:

Java Code:
```java
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Web_Crawler {
  private static final int MAX_DEPTH = 2; // Maximum depth for crawling
  private static final int MAX_THREADS = 4; // Maximum number of threads

  private final Set < String > visitedUrls = new HashSet < > ();

  public void crawl(String url, int depth) {
    if (depth > MAX_DEPTH || visitedUrls.contains(url)) {
      return;
    }

    visitedUrls.add(url);
    System.out.println("Crawling: " + url);

    try {
      Document document = Jsoup.connect(url).get();
      processPage(document);

      Elements links = document.select("a[href]");
      for (Element link: links) {
        String nextUrl = link.absUrl("href");
        crawl(nextUrl, depth + 1);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void processPage(Document document) {
    // Process the web page content as needed
    System.out.println("Processing: " + document.title());
  }

  public void startCrawling(String[] seedUrls) {
    ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

    for (String url: seedUrls) {
      executor.execute(() -> crawl(url, 0));
    }

    executor.shutdown();

    try {
      executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Crawling completed.");
  }

  public static void main(String[] args) {
    // Add URLs here
    String[] seedUrls = {
      "https://example.com",
      "https://www.wikipedia.org"
    };

    Web_Crawler webCrawler = new Web_Crawler();
    webCrawler.startCrawling(seedUrls);
  }
}
```
Sample Output:
```
Crawling: https://www.wikipedia.org
Crawling: https://example.com
Processing: Wikipedia
Crawling: https://en.wikipedia.org/
Processing: Example Domain
Crawling: https://www.iana.org/domains/example
Processing: Wikipedia, the free encyclopedia
Crawling: https://en.wikipedia.org/wiki/Main_Page#bodyContent
Processing: Wikipedia, the free encyclopedia
Crawling: https://en.wikipedia.org/wiki/Main_Page
Processing: Wikipedia, the free encyclopedia
Crawling: https://en.wikipedia.org/wiki/Wikipedia:Contents
Processing: Wikipedia:Contents - Wikipedia
Crawling: https://en.wikipedia.org/wiki/Portal:Current_events
Processing: Portal:Current events - Wikipedia
Crawling: https://en.wikipedia.org/wiki/Special:Random
Processing: IANA-managed Reserved Domains
Crawling: http://www.iana.org/
Processing: Papilio birchallii - Wikipedia
Crawling: https://en.wikipedia.org/wiki/Wikipedia:About
Processing: Wikipedia:About - Wikipedia
Crawling: https://en.wikipedia.org/wiki/Wikipedia:Contact_us
Processing: Internet Assigned Numbers Authority
Crawling: http://www.iana.org/domains
Processing: Wikipedia:Contact us - Wikipedia
Crawling: https://donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en
Processing: Domain Name Services
Crawling: http://www.iana.org/protocols
Processing: Make your donation now - Wikimedia Foundation
Crawling: https://en.wikipedia.org/wiki/Help:Contents
Processing: Help:Contents - Wikipedia
Crawling: https://en.wikipedia.org/wiki/Help:Introduction
Processing: Help:Introduction - Wikipedia
```
Pictorial Presentation:

Java thread Programming - Simultaneous Website Crawling
Explanation:

In the above exercise,

The  Web_Crawler class crawls web pages. It has two constants:
MAX_DEPTH: Represents the maximum depth to which the crawler explores links on a web page.
MAX_THREADS: Represents the maximum number of threads to use for crawling.
The class maintains a Set<String> called visitedUrls to keep track of the URLs visited during crawling.
The crawl(String url, int depth) method crawls a given URL up to a specified depth. If the current depth exceeds MAX_DEPTH or if the URL has already been visited, the method returns. Otherwise, it adds the URL to the visitedUrls set. It prints a message indicating that the URL is being crawled, and retrieves the web page using the  Jsoup library.
The processPage(Document document) method represents web page processing. In this example, it simply prints the document title. You can customize this method to perform specific operations on web page content.
The startCrawling(String[] seedUrls) method initiates the crawling process. It creates a fixed-size thread pool using ExecutorService and Executors.newFixedThreadPool() with a maximum number of threads specified by MAX_THREADS. It then submits crawl tasks for each seed URL in the seedUrls array to the thread pool for concurrent execution.
After submitting all the tasks, the method shuts down the executor, waits for all the tasks to complete using executor.awaitTermination(), and prints a completion message.

### 7. Write a Java program that creates a bank account with concurrent deposits and withdrawals using threads.
Write a Java program that creates a bank account with concurrent deposits and withdrawals using threads.

Sample Solution:

Java Code:
```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
  private double balance;
  private Lock lock;

  public BankAccount() {
    balance = 0.0;
    lock = new ReentrantLock();
  }

  public void deposit(double amount) {
    lock.lock();
    try {
      balance += amount;
      System.out.println("Deposit: " + amount);
      System.out.println("Balance after deposit: " + balance);
    } finally {
      lock.unlock();
    }
  }

  public void withdraw(double amount) {
    lock.lock();
    try {
      if (balance >= amount) {
        balance -= amount;
        System.out.println("Withdrawal: " + amount);
        System.out.println("Balance after withdrawal: " + balance);
      } else {
        System.out.println("Try to Withdraw: " + amount);
        System.out.println("Insufficient funds. Withdrawal cancelled.");
      }
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    BankAccount account = new BankAccount();

    Thread depositThread1 = new Thread(() -> account.deposit(1000));
    Thread depositThread2 = new Thread(() -> account.deposit(300));
    Thread withdrawalThread1 = new Thread(() -> account.withdraw(150));
    Thread withdrawalThread2 = new Thread(() -> account.withdraw(1200));

    depositThread1.start();
    depositThread2.start();
    withdrawalThread1.start();
    withdrawalThread2.start();
  }
}
```
Sample Output:

Deposit: 1000.0
Balance after deposit: 1000.0
Withdrawal: 150.0
Balance after withdrawal: 850.0
Deposit: 300.0
Balance after deposit: 1150.0
Try to Withdraw: 1200.0
Insufficient funds. Withdrawal cancelled.
Pictorial Presentation:

Concurrent Bank Account in Java: Thread-Safe Deposits and Withdrawals
Explanation:

In the above exercise, the BankAccount class represents a bank account with a balance. For deposit and withdrawal methods, it uses a "ReentrantLock" to synchronize access, so that different threads can execute them concurrently without conflict.


In the deposit method, the lock is acquired before updating the balance with the deposited amount. The lock is acquired in the withdraw method before checking the balance and completing the withdrawal.

The main method creates an instance of BankAccount and starts four threads: two for deposits and two for withdrawals. Each thread invokes the corresponding method on the BankAccount instance, simulating concurrent deposits and withdrawals.
