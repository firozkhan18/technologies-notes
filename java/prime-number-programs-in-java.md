# 10 Prime Number Programs In Java

Prime number programs are one of the frequently asked java interview programs for freshers. 
In this post, I have collected some of the important prime number programs in java and have tried to write the solution for them. I hope it will be helpful for you guys.


Before moving to prime number programs in java, let’s see what is prime number?

What Is Prime Number?
Prime number is a whole number which is greater than 1 and is divisible only by 1 and itself. In the other words, prime number has only two factors, 1 and itself.

Example : 2, 3, 5, 7, 11, 13, 17……

Note : 0 and 1 are not prime numbers.


Prime Number Programs In Java :
Below is the list of some of the prime number programs in java.

- 1) Write a java program to check whether given number is prime or not?
- 2) Write a java program to find initial 10 or 20 or 30 …… n) prime numbers?
- 3) Write a java program to find out 20 (or 30 or 40 …… n) prime numbers after 100 ( or after any given number)?
- 4) Write a java program to find out all prime numbers between two given numbers?
- 5) Write a java program to find the sum of initial ‘n‘ prime numbers?
- 6) Write a java program to find sum of all prime numbers between two given numbers?
- 7) Write a java program to print prime numbers between two given numbers in the reverse order?
- 8) Write a java program to find the twin prime numbers?
- 9) Write a java program to print twin prime numbers between two given numbers?
- 10) Write a java program to print a prime number which comes after three non-prime numbers?

## prime number programs in java

### Java Program To Check Given Number Is Prime Or Not :
Program :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter a number :");
         
        int inputNumber = sc.nextInt();
         
        boolean isItPrime = checkForPrime(inputNumber);
         
        if (isItPrime)
        {
            System.out.println(inputNumber+" is a prime number.");
        }
        else
        {
            System.out.println(inputNumber+" is not a prime number.");
        }
         
        sc.close();
    }
}
```
Output :

Enter a number :
11
11 is a prime number.

Enter a number :
15
15 is not a prime number.

### Java Program To Find Initial 10 or 20 or 30 or 40 … n Prime Numbers :
Program :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("How many initial prime numbers you want?");
         
        int n = sc.nextInt();
         
        int counter = 1;
         
        int inputNumber = 2;
         
        System.out.println("Initial "+n+" Prime Numbers :");
         
        while (counter <= n)
        {   
            if (checkForPrime(inputNumber))
            {
                System.out.println(inputNumber);
                 
                counter++;
                 
                inputNumber++;
            }
            else
            {
                inputNumber++;
            }
        }
         
        sc.close();
    }
}
```
Output :

### How many initial prime numbers you want?
10
Initial 10 Prime Numbers :
2
3
5
7
11
13
17
19
23
29

### Java Program To Find 10 or 20 or 30 …. n Prime Numbers After 100 (or after any given number) :
Program :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("How many prime numbers you want?");
         
        int n = sc.nextInt();
         
        System.out.println("After which number?");
         
        int start = sc.nextInt();
         
        int counter = 1;
         
        System.out.println("First "+n+" Prime Numbers after "+start+" :");
         
        int inputNumber = start + 1;
         
        while (counter <= n)
        {
            if (checkForPrime(inputNumber))
            {
                System.out.println(inputNumber);
                 
                counter++;
                 
                inputNumber++;
            }
            else
            {
                inputNumber++;
            }
        }
         
        sc.close();
    }
}
```
Output :

### How many prime numbers you want?
10
After which number?
100
First 10 Prime Numbers after 100 :
101
103
107
109
113
127
131
137
139
149

### Java Program To Find Out All Prime Numbers Between Two Given Numbers :
Program :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the start value :");
         
        int start = sc.nextInt();
         
        System.out.println("Enter the end value :");
         
        int end = sc.nextInt();
         
        System.out.println("Prime numbers between "+start+" and "+end+" : ");
         
        for (int i = start; i <= end; i++) 
        {
            if(checkForPrime(i))
            {
                System.out.println(i);
            }
        }
         
        sc.close();
    }
}
```
Output :

Enter the start value :
10
Enter the end value :
20
Prime numbers between 10 and 20 :
11
13
17
19

### Java Program To Find The Sum Of First n Prime Numbers :
Program :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the value for n :");
         
        int n = sc.nextInt();
         
        int counter = 1;
         
        int sum = 0;
         
        System.out.println("The sum of first "+n+" Prime Numbers :");
         
        int inputNumber = 2;
         
        while (counter <= n)
        {
            if (checkForPrime(inputNumber))
            {
                System.out.println(inputNumber);
                 
                sum = sum + inputNumber;
                 
                counter++;
                 
                inputNumber++;
            }
            else
            {
                inputNumber++;
            }
        }
         
        System.out.println("=======");
         
        System.out.println("Sum = "+sum);
 
        sc.close();
    }
}
```
Output :

Enter the value for n :
10
The sum of first 10 Prime Numbers :
2
3
5
7
11
13
17
19
23
29
=======
Sum = 129

### Java Program To Find The Sum Of All Prime Numbers Between Two Given Numbers :
Program :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the start value :");
         
        int start = sc.nextInt();
         
        System.out.println("Enter the end value :");
         
        int end = sc.nextInt();
         
        int sum = 0;
         
        System.out.println("The sum of all prime numbers between "+start+" and "+end+" :");
         
        for (int i = start; i <= end; i++) 
        {
            if(checkForPrime(i))
            {
                System.out.println(i);
                 
                sum = sum + i;
            }
        }
 
        System.out.println("==================");
         
        System.out.println("Sum = "+sum);
         
        sc.close();
    }
}
```
Output :

Enter the start value :
50
Enter the end value :
100
The sum of all prime numbers between 50 and 100 :
53
59
61
67
71
73
79
83
89
97
==================
Sum = 732

### Java Program To Print Prime Numbers Between Two Given Numbers In The Reverse Order :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the start value :");
         
        int start = sc.nextInt();
         
        System.out.println("Enter the end value :");
         
        int end = sc.nextInt();
         
        System.out.println("Prime numbers between "+start+" and "+end+" in reverse order : ");
         
        for (int i = end; i >= start; i--) 
        {
            if(checkForPrime(i))
            {
                System.out.println(i);
            }
        }
         
        sc.close();
    }
}
```
Output :

Enter the start value :
10
Enter the end value :
20
Prime numbers between 10 and 20 in reverse order :
19
17
13
11

### Java Program To Find The Twin Prime Numbers :
Twin prime numbers are the prime numbers whose difference is 2. For example : (3, 5), (5, 7), (11, 13)…
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the value for n : ");
         
        int n = sc.nextInt();
         
        int counter = 1;
         
        int first, second;
         
        System.out.println("The first "+n+" twin prime numbers :");
         
        int inputNumber = 2;
         
        while (counter <= n) 
        {
            first = inputNumber;
             
            second = inputNumber + 2;
             
            if(checkForPrime(first) && checkForPrime(second))
            {
                System.out.println("("+first+", "+second+")");
                 
                counter++;
                 
                inputNumber++;
            }
            else
            {
                inputNumber++;
            }
        }
         
        sc.close();
    }
}
```
Output :

Enter the value for n :
10
The first 10 twin prime numbers :
(3, 5)
(5, 7)
(11, 13)
(17, 19)
(29, 31)
(41, 43)
(59, 61)
(71, 73)
(101, 103)
(107, 109)

### Java Program To Find Twin Prime Numbers Between Two Given Numbers :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the start value : ");
         
        int start = sc.nextInt();
         
        System.out.println("Enter the end value : ");
         
        int end = sc.nextInt();
         
        int first, second;
         
        System.out.println("Twin prime numbers between "+start+" and "+end+" :");
         
        for (int i = start; i <= end; i++)
        {
            first = i;
             
            second = i + 2;
             
            if(checkForPrime(first) && checkForPrime(second))
            {
                System.out.println("("+first+", "+second+")");
            }
        }
         
        sc.close();
    }
}
```
Output :

Enter the start value :
10
Enter the end value :
100
Twin prime numbers between 10 and 100 :
(11, 13)
(17, 19)
(29, 31)
(41, 43)
(59, 61)
(71, 73)

### Java Program To Print n Prime Numbers Which Comes After 3 non-prime numbers :
```java
import java.util.Scanner;
 
public class PrimeNumberProgram 
{
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
         
        if(inputNumber <= 1) 
        {
            isItPrime = false;
             
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                     
                    break;
                }
            }
             
            return isItPrime;
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the value for n : ");
         
        int n = sc.nextInt();
         
        int counter = 1;
         
        int first, second;
         
        System.out.println("First "+n+" prime numbers which comes after three non-prime numbers :");
         
        int inputNumber = 2;
         
        while (counter <= n) 
        {
            first = inputNumber;
             
            second = inputNumber + 4;
             
            if(checkForPrime(first) && checkForPrime(second))
            {
                System.out.println(second);
                 
                counter++;
                 
                inputNumber++;
            }
            else
            {
                inputNumber++;
            }
        }
         
        sc.close();
    }
}
```
Output :

Enter the value for n :
10
First 10 prime numbers which comes after three non-prime numbers :
7
11
17
23
41
47
71
83
101
107
