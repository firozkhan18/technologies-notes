# Java Exercises Numbers

### 1. Write a Java program to check whether a given number is ugly.
In number system, ugly numbers are positive numbers whose only prime factors are 2, 3 or 5. First 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12. By convention, 1 is included.
Test Date:Input an integer number: 235
Expected Output :
It is not an ugly number.
```java
import java.util.Scanner;
public class Exercise1 {
       public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input an integer number: ");
        int n = in.nextInt();  		
        if (n <= 0) {
            System.out.print("Input a correct number.");
        }
		int x = 0;
        while (n != 1) {
            if (n % 5 == 0) {
                n /= 5;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                System.out.print("It is not an ugly number.");
				x = 1;
				break;
            }
        }
        if (x==0)
		System.out.print("It is an ugly number.");
		System.out.print("\n");
	    }
}
```
Sample Output:

Input an integer number: 235                                                                                  
It is not an ugly number.

### 2. Write a Java program that categorizes integers between 1 and 10,000 as Abundant, Deficient, and Perfect.
In number theory, an abundant number is a number for which the sum of its proper divisors is greater than the number itself.
Example :
The first few abundant numbers are:
12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60, 66, 70, 72, 78, 80, 84, 88, 90, 96, 100, 102,…
The integer 12 is the first abundant number. Its proper divisors are 1, 2, 3, 4 and 6 for a total of 16.
Deficient number: In number theory, a deficient number is a number n for which the sum of divisors σ(n)<2n, or, equivalently, the sum of proper divisors (or aliquot sum) s(n)<n. The value 2n − σ(n) (or n − s(n)) is called the number's deficiency.
As an example, divisors of 21 are 1, 3 and 7, and their sum is 11. Because 11 is less than 21, the number 21 is deficient. Its deficiency is 2 × 21 − 32 = 10.
The first few deficient numbers are:
1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 19, 21, 22, 23, 25, 26, 27, 29, 31, 32, 33, …….
Perfect number: In number system, a perfect number is a positive integer that is equal to the sum of its proper positive divisors, that is, the sum of its positive divisors excluding the number itself.
Equivalently, a perfect number is a number that is half the sum of all of its positive divisors (including itself) i.e. σ1(n) = 2n.
The first perfect number is 6. Its proper divisors are 1, 2, and 3, and 1 + 2 + 3 = 6. Equivalently, the number 6 is equal to half the sum of all its positive divisors: ( 1 + 2 + 3 + 6 ) / 2 = 6. The next perfect number is 28 = 1 + 2 + 4 + 7 + 14. This is followed by the perfect numbers 496 and 8128.
Expected Output :
Number Counting [(integers) between 1 to 10,000]:
Deficient number: 7508
Perfect number: 4
Abundant number: 2488
```java
import static java.util.stream.LongStream.rangeClosed;
public class Exercise2 {
    
   public static void main(String[] args) {
        int count_Deficient_no = 0;
        int count_Perfect_no = 0;
        int count_Abundant_no = 0;
 
        for (long i = 1; i <= 10_000L; i++) {
            long sum = proper_Divs_Sum(i);
            if (sum < i)
                count_Deficient_no++;
            else if (sum == i)
                count_Perfect_no++;
            else
                count_Abundant_no++;
        }
        System.out.println("Number Counting [(integers) between 1 to 10,000]: ");
        System.out.println("Deficient number: " + count_Deficient_no);
        System.out.println("Perfect number: " + count_Perfect_no);
        System.out.println("Abundant number: " + count_Abundant_no);
    }
     public static Long proper_Divs_Sum(long num) {
        return rangeClosed(1, (num + 1) / 2).filter(i -> num % i == 0 && num != i).sum();
    }
}
```
Sample Output:

Number Counting [(integers) between 1 to 10,000]:                                                             
Deficient number: 7508                                                                                        
Perfect number: 4                                                                                             
Abundant number: 2488

### 3. Write a Java program to generate random integers in a specific range.
```java
import java.util.Scanner;
public class Example3  {

      public static void main( String args[] ){ 
	    Scanner sc = new Scanner( System.in ); 
        System.out.print("Input the starting number of the range: "); 
        int rsnum = sc.nextInt(); 
        System.out.print("Input the ending number of the range: "); 
        int renum = sc.nextInt(); 
	    int random_num = rsnum + (int)(Math.random() * ((renum - rsnum) + 1));
	    System.out.println(random_num);
     }  
}
```
Sample Output:

Input the starting number of the range: 5                                                                     
Input the ending number of the range: 25                                                                      
10 

### 4. Write a Java program to generate and show all Kaprekar numbers less than 1000.
Expected Output :


1       1         0 + 1                                  
9       81        8 + 1                                  
45      2025      20 + 25                                
55      3025      30 + 25                                
99      9801      98 + 01                                
297     88209     88 + 209                               
703     494209    494 + 209                              
999     998001    998 + 001                              
8 Kaprekar numbers.  
```java
public class Example4 {
      public static void main(String[] args){
        int ctr = 0;
        int base = (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        for(long n = 1; n <= 1000; n++){
            String sqr_Str = Long.toString(n * n, base);
            for(int j = 0; j < sqr_Str.length() / 2 + 1; j++){
                String[] parts = split_num(sqr_Str, j);
                long first_Num = Long.parseLong(parts[0], base);
                long sec_Num = Long.parseLong(parts[1], base);
                if(sec_Num == 0) break;
                if(first_Num + sec_Num == n){
                    System.out.println(Long.toString(n, base) +
                            "\t" + sqr_Str + "\t  " + parts[0] + " + " + parts[1]);
                    ctr++;
                    break;
                }
            }
        }
        System.out.println(ctr + " Kaprekar numbers.");
    }
     private static String[] split_num(String str, int idx){
        String[] ans1 = new String[2];
        ans1[0] = str.substring(0, idx);
        if(ans1[0].equals("")) ans1[0] = "0"; 
        ans1[1] = str.substring(idx);
        return ans1;
    }	
}
```
Sample Output:

1       1         0 + 1                                                                                       
9       81        8 + 1                                                                                       
45      2025      20 + 25                                                                                     
55      3025      30 + 25                                                                                     
99      9801      98 + 01                                                                                     
297     88209     88 + 209                                                                                    
703     494209    494 + 209                                                                                   
999     998001    998 + 001                                                                                   
8 Kaprekar numbers. 
### 5. Write a Java program to find the number of seed Lychrel number candidates and related numbers for n in the range 1..10000 inclusive. (With a 500-iteration limit).
A Lychrel number is a natural number that cannot form a palindrome through the iterative process of repeatedly reversing its digits and adding the resulting numbers. This process is sometimes called the 196-algorithm, after the most famous number associated with the process.
The first few Lychrel numbers are 196, 295, 394, 493, 592, 689, 691, 788, 790, 879, 887, ... .
Expected Output :
5 Lychrel seeds: [196, 879, 1997, 7059, 9999]
244 Lychrel related
5 Lychrel palindromes: [196, 879, 1997, 7059, 9999]
```java
// https://rosettacode.org/
import java.math.BigInteger;
import java.util.*;
 public class Example5 {
     static Map<BigInteger, Tuple> cache = new HashMap<>();
     static class Tuple {
        final Boolean flag;
        final BigInteger bi;
 
        Tuple(boolean f, BigInteger b) {
            flag = f;
            bi = b;
        }
    }
     static BigInteger rev(BigInteger bi) {
        String s = new StringBuilder(bi.toString()).reverse().toString();
        return new BigInteger(s);
    }
     static Tuple lychrel(BigInteger n) {
        Tuple res;
        if ((res = cache.get(n)) != null)
            return res;
 
        BigInteger r = rev(n);
        res = new Tuple(true, n);
        List<BigInteger> seen = new ArrayList<>();
         for (int i = 0; i < 500; i++) {
            n = n.add(r);
            r = rev(n);
 
            if (n.equals(r)) {
                res = new Tuple(false, BigInteger.ZERO);
                break;
            }
             if (cache.containsKey(n)) {
                res = cache.get(n);
                break;
            }
             seen.add(n);
        }
         for (BigInteger bi : seen)
            cache.put(bi, res);
         return res;
    }
     public static void main(String[] args) {
         List<BigInteger> seeds = new ArrayList<>();
        List<BigInteger> related = new ArrayList<>();
        List<BigInteger> palin = new ArrayList<>();
 
        for (int i = 1; i <= 10_000; i++) {
            BigInteger n = BigInteger.valueOf(i);
             Tuple t = lychrel(n);
             if (!t.flag)
                continue;
             if (n.equals(t.bi))
                seeds.add(t.bi);
            else
                related.add(t.bi);
 
            if (n.equals(t.bi))
                palin.add(t.bi);
        }
         System.out.printf("%d Lychrel seeds: %s%n", seeds.size(), seeds);
        System.out.printf("%d Lychrel related%n", related.size());
        System.out.printf("%d Lychrel palindromes: %s%n", palin.size(), palin);
    }
}
```
Sample Output:

5 Lychrel seeds: [196, 879, 1997, 7059, 9999]                                                                 
244 Lychrel related                                                                                           
5 Lychrel palindromes: [196, 879, 1997, 7059, 9999]

### 6. Write a Java program to generate and show the first 15 narcissistic decimal numbers.
Expected Output :

0 1 2 3 4 5 6 7 8 9 153 370 371 407 1634
```java
// https://rosettacode.org/
public class Example6 {
	public static void main(String[] args){
		for(long n = 0, ctr = 0; ctr < 15; n++){
			if(is_narc_dec_num(n)){
				System.out.print(n + " ");
				ctr++;
			}
		}
		System.out.println();
	}
    public static boolean is_narc_dec_num(long n){
		if(n < 0) return false;
 
		String str1 = Long.toString(n);
		int x = str1.length();
		long sum_num = 0;
 
		for(char c : str1.toCharArray()){
			sum_num += Math.pow(Character.digit(c, 10), x);
		}
		return sum_num == n;
	}
 	
}
```
Sample Output:

0 1 2 3 4 5 6 7 8 9 153 370 371 407 1634

### 7. Write a Java program to display the first 10 lucus numbers.
The Lucas numbers or series are an integer sequence named after the mathematician François Édouard Anatole Lucas, who studied both that sequence and the closely related Fibonacci numbers. Lucas numbers and Fibonacci numbers form complementary instances of Lucas sequences.


The sequence of Lucas numbers is: 2, 1, 3, 4, 7, 11, 18, 29, ….
Expected Output :

   First ten Lucas a numbers:                                              
2                                                                       
1                                                                       
3                                                                       
4                                                                       
7                                                                       
11                                                                      
18                                                                      
29                                                                      
47                                                                      
76
```java
import java.util.Scanner;
public class Example7 {
   public static void main(String[] args) { 

     System.out.print("\nFirst ten Lucas a numbers: "); 
     int n = 10;
     int n1 = 2, n2 = 1, n3;
        if (n > 1){
            System.out.println("\n2\n1");
            for(int i = 2; i < n; ++i){
                n3 = n2;
                n2 += n1;
                n1 = n3;
                System.out.println(n2);
            }
        }
        else if (n == 1)
            System.out.println("\n2");

        else
            System.out.println("Input a positive number.");
    }
 }
```
Sample Output:

First ten Lucas a numbers:                                                                                    
2                                                                                                  
1                                                                                                  
3                                                                                                  
4                                                                                                  
7                                                                                                  
11                                                                                                  
18                                                                                                  
29                                                                                                  
47                                                                                                  
76
### 8.Write a Java program to print out the first 10 Catalan numbers by extracting them from Pascal's triangle.
In combinatorial  mathematics, the Catalan numbers form a sequence of natural numbers that occur in various counting problems, often involving recursively-defined objects. They are named after the Belgian mathematician Eugène Charles Catalan.
The first Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190, 6564120420, 24466267020, 91482563640, 343059613650, 1289904147324, 4861946401452,

List 10 Catalan numbers:-                                               
                                                                        
1                                                                       
2                                                                       
5                                                                       
14                                                                      
42                                                                      
132                                                                     
429                                                                     
1430                                                                    
4862                                                                    
16796  
```java
import java.util.Scanner;
public class Example8 {
   public static void main(String[] args) {
        int num = 10;
        int[] t = new int[num + 2];
        t[1] = 1;
        System.out.printf("\nList 10 Catalan numbers:-\n"); 
        for (int i = 1; i <= num; i++) {
 
            for (int j = i; j > 1; j--)
                t[j] = t[j] + t[j - 1];
 
            t[i + 1] = t[i];
            
            for (int j = i + 1; j > 1; j--)
                t[j] = t[j] + t[j - 1];
             System.out.printf("\n%d ", t[i + 1] - t[i]);
        }
		System.out.printf("\n"); 
    }
}
```
Sample Output:

List 10 Catalan numbers:-                                                                                                  
1                                                                                                  
2                                                                                                  
5                                                                                                  
14                                                                                                  
42                                                                                                  
132                                                                                                  
429                                                                                                  
1430                                                                                                  
4862                                                                                                  
16796 
### 9. Write a Java program to find and print the first 10 happy numbers.
Happy number: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1, or it loops endlessly in a cycle which does not include 1.
Example: 19 is a happy number
12 + 92=82
82 + 22=68
62 + 82=100
12 + 02 + 02=1

Expected Output

First 10 Happy numbers:                                                 
1                                                                       
7                                                                       
10                                                                      
13                                                                      
19                                                                      
23                                                                      
28                                                                      
31   
```java
import java.util.HashSet;
public class Example9 {
public static void main(String[] args){
	System.out.println("First 10 Happy numbers:");
       for(long num = 1,count = 0;count<8;num++){
           if(happy_num(num)){
               System.out.println(num);
               count++;
           }
       }
}
   public static boolean happy_num(long num){
       long m = 0;
       int digit = 0;
       HashSet<Long> cycle = new HashSet<Long>();
	   while(num != 1 && cycle.add(num)){
           m = 0;
           while(num > 0){
               digit = (int)(num % 10);
               m += digit*digit;
               num /= 10;
           }
           num = m;
       }
       return num == 1;
   }   
 }
```
Sample Output:

First 10 Happy numbers:                                                                                       
1                                                                                                  
7                                                                                                  
10                                                                                                  
13                                                                                                  
19                                                                                                  
23                                                                                                  
28                                                                                                  
31

### 10. Write a Java program to check whether a given number is a happy number or unhappy number.
Happy number: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1, or it loops endlessly in a cycle which does not include 1.
An unhappy number is a number that is not happy.
The first few unhappy numbers are 2, 3, 4, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17, 18, 20.

Expected Output

Input a number: 5                                                       
Unhappy Number
```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Example10 {

    public static boolean isHappy_number(int num)
    {
        Set<Integer> unique_num = new HashSet<Integer>();

        while (unique_num.add(num))
        {
            int value = 0;
            while (num > 0)
            {
                value += Math.pow(num % 10, 2);
                num /= 10;
            }
            num = value;
        }

        return num == 1;
    }

    public static void main(String[] args)
    {
        System.out.print("Input a number: ");
        int num = new Scanner(System.in).nextInt();
        System.out.println(isHappy_number(num) ? "Happy Number" : "Unhappy Number");
    }
}
```
Sample Output:

Input a number: 5                                                                                             
Unhappy Number
### 11. Write a Java program to check whether a given number is a Disarium number or an unhappy number.
A Disarium number is a number defined by the following process :
Sum of its digits powered with their respective position is equal to the original number.
For example 175 is a Disarium number :
As 11+32+53 = 135
Some other DISARIUM are 89, 175, 518 etc.
A number will be called Disarium if the sum of its digits powered with their respective position is equal with the number itself. Sample Input: 135.
Expected Output

Input a number : 25                                                     
Not a Disarium Number.
```java
import java.util.Scanner;

public class Example11 {

    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input a number : ");
            int num = sc.nextInt();
            int copy = num, d = 0, sum = 0;
            String s = Integer.toString(num);  
            int len = s.length();  
             
            while(copy>0)
            {
                d = copy % 10;  
                sum = sum + (int)Math.pow(d,len);
                len--;
                copy = copy / 10;
            }
             
            if(sum == num)
                System.out.println("Disarium Number.");
            else
                System.out.println("Not a Disarium Number.");
        }
    }
```
Sample Output:

Input a number : 25                                                                                           
Not a Disarium Number.
### 12. Write a Java program to check whether a number is a Harshad Number or not.
In recreational  mathematics, a harshad number in a given number base, is an integer that is divisible by the sum of its digits when written in that base.
Example: Number 200 is a Harshad Number because the sum of digits 2 and 0 and 0 is 2(2+0+0) and 200 is divisible by 2. Number 171 is a Harshad Number because the sum of digits 1 and 7 and 1 is 9(1+7+1) and 171 is divisible by 9.
Expected Output

Input a number : 353  
                                                  
353 is not a Harshad Number.
```java
import java.util.Scanner;
public class Example12 {

     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.print("Input a number : ");
        int num = sc.nextInt();
        int x = num, y, sum = 0;
         
       while(x>0)
        {
            y = x%10;
            sum = sum + y;
            x = x/10;
        }
         
        if(num%sum == 0)
            System.out.println(num+" is a Harshad Number.");
        else
            System.out.println(num+" is not a Harshad Number.");      
    }
}
```
Sample Output:

Input a number : 353                                                                                          
353 is not a Harshad Number.
### 13. Write a Java program to check whether a number is a Pronic or Heteromecic Number or not.
A pronic number is a number which is the product of two consecutive integers, that is, a number of the form n(n + 1).
The first few pronic numbers are:
0, 2, 6, 12, 20, 30, 42, 56, 72, 90, 110, 132, 156, 182, 210, 240, 272, 306, 342, 380, 420, 462 … etc.

Expected Output
Input a number : 110
Pronic Number.
```java
import java.util.Scanner;

public class Example13 {

    public static void main(String args[])
       {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number : ");
        int num = sc.nextInt();
        int ans = 0;
    
        for(int i=0; i<num; i++)
        {
            if(i*(i+1) == num)
            {
                ans = 1;
                break;
            }
        }
         
        if(ans == 1)
            System.out.println("Pronic Number.");
        else
            System.out.println("Not a Pronic Number.");      
    }
}
```
Sample Output:

Input a number : 110                                                                                          
Pronic Number. 

### 14. Write a Java program to check whether a number is an automorphic number or not.
In  mathematics, an automorphic number is a number whose square "ends" in the same digits as the number itself. For example, 52 = 25, 62 = 36, 762 = 5776, and 8906252 = 793212890625, so 5, 6, 76 and 890625 are all automorphic numbers.
Expected Output

Input a number : 76                                                   
Automorphic Number.
```java
import java.util.Scanner;
public class Example14 {

    public static void main(String args[])
       {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number : ");
        int num = sc.nextInt();
        int sq_num = num*num;  
 
        String str_num = Integer.toString(num);  
        String square = Integer.toString(sq_num);  
 
        if(square.endsWith(str_num))  
            System.out.println("Automorphic Number.");
        else
            System.out.println("Not an Automorphic Number.");
    }
}
```
Sample Output:

Input a number : 76                                                                                           
Automorphic Number.
### 15. Write a Java program to check whether a number is a Duck Number or not.
Note: A Duck number is a number which has zeroes present in it, but there should be no zero present in the beginning of the number. For example 3210, 7056, 8430709 are all duck numbers whereas 08237, 04309 are not.
Expected Output

Input a number : 3210                                                   
Duck number
 
```java
import java.util.Scanner;

public class Example15  {

    public static void main(String args[])
       {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number : ");
        String nstr = sc.nextLine();
 
        int l = nstr.length();  
        int ctr = 0;  
        char chr;
 
        for(int i=1;i<l;i++)
        {
            chr = nstr.charAt(i); 
            if(chr=='0')
                ctr++;
        }
 
        char f = nstr.charAt(0); 
 
        if(ctr>0 && f!='0')
            System.out.println("Duck number");
        else
            System.out.println("Not a duck number");
    }
}
```
Sample Output:

Input a number : 3210                                                                                         
Duck number
### 16. Write a Java program to check two numbers are Amicable numbers or not.
Amicable numbers are two different numbers so related that the sum of the proper divisors of each is equal to the other number.
The first ten amicable pairs are: (220, 284), (1184, 1210), (2620, 2924), (5020, 5564), (6232, 6368), (10744, 10856), (12285, 14595), (17296, 18416), (63020, 76084), and (66928, 66992).
Expected Output

Input the first number: 220                                             
Input the second number: 284                                            
These numbers are amicable.
```java
import java.util.Scanner;

public class Example16
    {
      public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input the first number: ");
            int num1 = in.nextInt();
            System.out.print("Input the second number: ");
            int num2 = in.nextInt();
            int sum_num1 = 0, sum_num2 = 0;
            for (int i = 1; i <= num1; i++) {
                if (num1 % i == 0)
                    sum_num1 += i;
            }
            for (int i = 1; i <= num2; i++) {
                if (num2 % i == 0)
                    sum_num2 += i;
            }
            if (sum_num1 == sum_num2)
                System.out.println("These numbers are amicable.");
            else
                System.out.println("These numbers are not amicable.");
				System.out.println("\n");			
    }
}
```
Sample Output:

Input the first number: 220                                                                                   
Input the second number: 284                                                                                  
These numbers are amicable.
### 17. Write a Java program to check if a given number is a circular prime or not.
Circular Prime : A circular prime is a prime number with the property that the number generated at each intermediate step when cyclically permuting its (base 10) digits will be prime.
For example, 1193 is a circular prime, since 1931, 9311 and 3119 all are also prime. A circular prime with at least two digits can only consist of combinations of the digits 1, 3, 7 or 9, because having 0, 2, 4, 6 or 8 as the last digit makes the number divisible by 2, and having 0 or 5 as the last digit makes it divisible by 5.
Input Data:
Input a number: 35
Expected Output

It is not a Circular Prime number.
```java
import java.util.Scanner;
public class Example17  {

       public static void main( String args[] ){ 
        int num; 
        Scanner sc = new Scanner( System.in ); 
        System.out.print("Input a number: "); 
        num = sc.nextInt(); 
        int num_of_digits = 0, divisor_part=1, circular_num = num; 
        boolean allPrime = true; 
        for( int i = num; i > 0; i /= 10 ){
            num_of_digits++;
            divisor_part *=10;
        }
        divisor_part /=10;
        do{
            circular_num = circulate_func( circular_num, divisor_part );
            if( !isPrime( circular_num ) ) allPrime=false;
        }while( circular_num != num );
        if( allPrime ) System.out.println("It is Circular Prime number." );
        else System.out.println("It is not a Circular Prime number." );
    }


	public static boolean isPrime( int n ){
        int factorCount = 0;
        if( n < 2 ) return false;
        else if( n == 2 ) return true;
        else if( n % 2 == 0 ) return false;
        else{
            int num = (int) Math.sqrt( n );
            for( int i = 3 ; i <= num; i+=2 ){
                if( n %i == 0 ){
                    return false;
                }
            }
        }
        return true;
    }
    public static int circulate_func( int n, int divisor_part ){
         if( n < 10 ) return n; 
         else return ( n % divisor_part ) * 10 + n / divisor_part; 
   } 
  
}
```
Sample Output:

Input a number: 35                                                                                            
It is not a Circular Prime number.
### 18. Write a Java program to check if a number is a cube or not.
In arithmetic and algebra, the cube of a number n is its third power: the result of the number multiplied by itself twice:
n3 = n × n × n.
Input Data:
Input a number: 8
Expected Output

Number is a cube.
```java
import java.util.Scanner;
public class Example18 {

      public static void main( String args[] ){ 
        Scanner sc = new Scanner( System.in ); 
        System.out.print("Input a number: "); 
        int num = sc.nextInt(); 
       int n = (int) Math.round(Math.pow(num, 1.0/3.0));
        if((num == n * n * n))
			{
			   System.out.print("Number is a cube.");
            }
		   else
			{
				System.out.print("Number is not a cube.");
			}
				System.out.println("\n");
        }
     }
```
Sample Output:

Input a number: 8                                                                                             
Number is a cube.
### 19. Write a Java program to check if a number is cyclic or not.
A cyclic number is an integer in which cyclic permutations of the digits are successive multiples of the number. The most widely known are 142857:
142857 × 1 = 142857
142857 × 2 = 285714
142857 × 3 = 428571
142857 × 4 = 571428
142857 × 5 = 714285
142857 × 6 = 857142
Input Data:
Input a number: 142857
Expected Output

It is a cyclic number.
```java
import java.util.Scanner;
import java.math.BigInteger;
public class Example19 {

      public static void main( String args[] ){ 
            Scanner sc = new Scanner( System.in ); 
            System.out.print("Input a number: "); 
            String strnum = sc.nextLine().trim();
            BigInteger n = new BigInteger(strnum);
            int len = strnum.length()+1;
            String str = String.valueOf(len);
            BigInteger n1 = new BigInteger(str);
            StringBuilder buf = new StringBuilder();
            for(int i = 0 ; i < (len-1); i++) {
                buf.append('9');
            }
            BigInteger total = new BigInteger(buf.toString());
            if(n.multiply(n1).equals(total)) {
                System.out.println("It is a cyclic number.");
            }
            else {
                System.out.println("Not a cyclic number.");
            }                    
        }
    }
```
Sample Output:

Input a number: 142857                                                                                        
It is a cyclic number. 
### 20. Write a Java program to display the first 10 Fermat numbers.
In  mathematics, a Fermat number is a positive integer of the form
Fermat Number
where n is a nonnegative integer.
The first few Fermat numbers are:
3, 5, 17, 257, 65537, 4294967297, 18446744073709551617, …
Expected Output

3.0                                                                     
5.0                                                                     
17.0                                                                    
257.0                                                                   
65537.0                                                                 
4.294967297E9                                                           
1.8446744073709552E19                                                   
3.4028236692093846E38                                                   
1.157920892373162E77                                                    
1.3407807929942597E154                                                  
Infinity   
```java
import java.util.Scanner;
public class Example20 {
      
public static void main( String args[] ){ 
        int n = 0;        
        double result;
        
        while (n <= 10) {
            result= Math.pow (2, Math.pow(2, n)) + 1;
            n++;
            System.out.println (result);
        }
     }  
}
```
Sample Output:

3.0                                                                                                  
5.0                                                                                                  
17.0                                                                                                  
257.0                                                                                                  
65537.0                                                                                                  
4.294967297E9                                                                                                 
1.8446744073709552E19                                                                                         
3.4028236692093846E38                                                                                         
1.157920892373162E77                                                                                          
1.3407807929942597E154                                                                                        
Infinity 
### 21. Write a Java program to find any number between 1 and n that can be expressed as the sum of two cubes in two (or more) different ways.

http://introcs.cs.princeton.edu/java/13flow/Ramanujan.java.html

Here are some examples of Ramanujan numbers :
1729 = 1^3 + 12^3 = 9^3 + 10^3
* 10000
1729 = 1^3 + 12^3 = 9^3 + 10^3
4104 = 2^3 + 16^3 = 9^3 + 15^3
* 100000
1729 = 1^3 + 12^3 = 9^3 + 10^3
4104 = 2^3 + 16^3 = 9^3 + 15^3
13832 = 2^3 + 24^3 = 18^3 + 20^3
39312 = 2^3 + 34^3 = 15^3 + 33^3
46683 = 3^3 + 36^3 = 27^3 + 30^3
32832 = 4^3 + 32^3 = 18^3 + 30^3
40033 = 9^3 + 34^3 = 16^3 + 33^3
20683 = 10^3 + 27^3 = 19^3 + 24^3
65728 = 12^3 + 40^3 = 31^3 + 33^3
64232 = 17^3 + 39^3 = 26^3 + 36^3

Expected Output
1729 = 1^3 + 12^3 = 9^3 + 10^3                                          
4104 = 2^3 + 16^3 = 9^3 + 15^3                                          
13832 = 2^3 + 24^3 = 18^3 + 20^3                                        
39312 = 2^3 + 34^3 = 15^3 + 33^3                                        
46683 = 3^3 + 36^3 = 27^3 + 30^3                                        
32832 = 4^3 + 32^3 = 18^3 + 30^3                                        
40033 = 9^3 + 34^3 = 16^3 + 33^3                                        
20683 = 10^3 + 27^3 = 19^3 + 24^3                                       
65728 = 12^3 + 40^3 = 31^3 + 33^3                                       
64232 = 17^3 + 39^3 = 26^3 + 36^3
```java
import java.util.Scanner;
public class Example21  {

   public static void main(String[] args) { 

         int n = 100000;
        // for each a, b, c, d, check whether a^3 + b^3 = c^3 + d^3
        for (int a = 1; a <= n; a++) {
            int a3 = a*a*a;
            if (a3 > n) break;

            for (int b = a; b <= n; b++) {
                int b3 = b*b*b;
                if (a3 + b3 > n) break;

                 for (int c = a + 1; c <= n; c++) {
                    int c3 = c*c*c;
                    if (c3 > a3 + b3) break;

                    for (int d = c; d <= n; d++) {
                        int d3 = d*d*d;
                        if (c3 + d3 > a3 + b3) break;

                        if (c3 + d3 == a3 + b3) {
                            System.out.print((a3+b3) + " = ");
                            System.out.print(a + "^3 + " + b + "^3 = "); 
                            System.out.print(c + "^3 + " + d + "^3"); 
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
```
Sample Output:

1729 = 1^3 + 12^3 = 9^3 + 10^3                                                                                
4104 = 2^3 + 16^3 = 9^3 + 15^3                                                                                
13832 = 2^3 + 24^3 = 18^3 + 20^3                                                                              
39312 = 2^3 + 34^3 = 15^3 + 33^3                                                                              
46683 = 3^3 + 36^3 = 27^3 + 30^3                                                                              
32832 = 4^3 + 32^3 = 18^3 + 30^3                                                                              
40033 = 9^3 + 34^3 = 16^3 + 33^3                                                                              
20683 = 10^3 + 27^3 = 19^3 + 24^3                                                                             
65728 = 12^3 + 40^3 = 31^3 + 33^3                                                                             
64232 = 17^3 + 39^3 = 26^3 + 36^3
### 22. Write a program to check if a number is a Mersenne number or not.
In  mathematics, a Mersenne number is a number that can be written in the form M(n) = 2n − 1 for some integer n.
The first four Mersenne primes are 3, 7, 31, and 127

Expected Output

Input a number: 127                                                     
127 is a Mersenne number.
```java
import java.util.Scanner;
import java.math.BigInteger;
public class Example22 {

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int n = in.nextInt();
        int n1 = n + 1;

        int power = 0;
        int ans = 0;
        for(int i=0;;i++)
        {
            power=(int)Math.pow(2,i);
            if(power>n1)
            {
                break;
            }
            else if(power==n1)
            {
               System.out.println(n+" is a Mersenne number.");
               ans=1;
            }
        }
  if(ans==0)
  {
   System.out.println(n+" is not a Mersenne number.");
  }
    }
}
```
Sample Output:

Input a number: 127                                                                                           
127 is a Mersenne number. 
### 23. Write a Java program to find all narcissistic numbers between 1 and 1000.
In number theory, a narcissistic number is a number that is the sum of its own digits each raised to the power of the number of digits.
For example:
153 = 13 + 53 + 33

Expected Output
1                                                      
2                                                      
3                                                      
4                                                      
5                                                      
6                                                      
7                                                      
8                                                      
9                                                      
153                                                    
370                                                    
371                                                    
407
```java
import java.util.LinkedList;
public class Example23  {

    public static void main(String args[])
    {
        for (int i = 1; i < 1000; i++) {
            int n = i;
            LinkedList<Integer> data = new LinkedList<>();
            while (n > 0) {
                data.push( n % 10 );
                n = n / 10;
            }
            int n1 = 0;
            for(Integer num : data) {
                n1 += Math.pow(num, data.size());
            }
            if(i == n1) {
                System.out.println(i);
            }
        }
    }
}
```
Sample Output:

1                                                                                                 
2                                                                                                 
3                                                                                                 
4                                                                                                 
5                                                                                                 
6                                                                                                 
7                                                                                                 
8                                                                                                 
9                                                                                                 
153                                                                                                 
370                                                                                                 
371                                                                                                 
407 
### 24. Write a Java program to check if a number is a palindrome or not.
In number system a palindromic number is a number that is the same when written forwards or backwards, i.e., of the form .
The first few palindromic numbers are therefore are 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, …

Expected Output
Input a number: 5                                                       
It is a Palindrome number. 

Write a Java program to check if a number is a palindrome or not.

In number system a palindromic number is a number that is the same when written forwards or backwards, i.e., of the form.
The first few palindromic numbers are therefore are 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, …

Test Data
Input a number: 5

Pictorial Presentation:

Java: Check if a number is palindrome or not.
Sample Solution:

Java Code:
```java
import java.util.Scanner;
public class Example24  {

    public static void main(String args[])
    {
	 Scanner in = new Scanner(System.in);
     System.out.print("Input a number: ");
     int n = in.nextInt();
     int sum = 0, r;
	 int temp = n;    
     while(n>0)
	   {    
        r = n % 10;   
        sum = (sum*10)+r;    
        n = n/10;    
       }    
      if(temp==sum)    
        System.out.println("It is a Palindrome number.");    
      else    
        System.out.println("Not a palindrome");    
     }  
}
```
Sample Output:

Input a number: 5                                                                                             
It is a Palindrome number.
### 25. Write a Java program to print the first 15 numbers of the Pell series.
In  mathematics, the Pell numbers are an infinite sequence of integers. The sequence of Pell numbers starts with 0 and 1, and then each Pell number is the sum of twice the previous Pell number and the Pell number before that.:
thus, 70 is the companion to 29, and 70 = 2 × 29 + 12 = 58 + 12.
The first few terms of the sequence are :
0, 1, 2, 5, 12, 29, 70, 169, 408, 985, 2378, 5741, 13860,…

Expected Output
First 20 Pell numbers:                                                  
1 2 5 12 29 70 169 408 985 2378 5741 13860 33461 80782 195025 470832 113
6689 2744210 6625109 15994428
```java
import java.util.Scanner;
public class Example25  {

    public static void main(String args[])
    {
	int n,a=1,b=0,c;
    System.out.println("First 20 Pell numbers: ");
    for(n=1; n<=20; n++)
     {
      c= a + 2*b;
      System.out.print(c+" ");
      a = b;
      b = c;
     }
   }
 }
```
Sample Output:

First 20 Pell numbers:                                                                                      
1 2 5 12 29 70 169 408 985 2378 5741 13860 33461 80782 195025 470832 1136689 2744210 6625109 15994428
### 26. Write a Java program to check whether a number is a Keith Number or not.
In recreational  mathematics, a Keith number or repfigit number (short for repetitive Fibonacci-like digit) is a number in the following integer sequence:
14, 19, 28, 47, 61, 75, 197, 742, 1104, 1537, 2208, 2580, 3684, 4788, 7385, 7647, 7909, 31331, 34285, 34348, 55604, 62662, 86935, 93993, 120284, 129106, 147640, 156146, 174680, 183186, 298320, 355419, 694280, 925993,

Expected Output
Input a number: 75                                                         
Keith Number
```java
import java.util.Scanner;
public class Example26  {

   public static void main(String[] args) { 

     Scanner sc = new Scanner( System.in ); 
     System.out.print("Input a number: "); 
     int n = sc.nextInt(); 
     int n1 = n;
     String s = Integer.toString(n);
     int d=s.length();
     int arr[]=new int[n];
     int i, sum; 
     for(i=d-1; i>=0; i--)
     {
         arr[i]=n1 % 10;
         n1=n1/10;
          
     }
      
     i=d; sum=0;
     while(sum<n)
     {
         sum = 0;
         for(int j=1; j<=d; j++)
         {
             sum=sum+arr[i-j];
         }
         arr[i]=sum;
         i++;
     }
 
    if(sum==n)
        System.out.println("Keith Number");
     else
        System.out.println("Not a Keith Number");
    }
}
```
Sample Output:

Input a number: 75                                                                                        
Keith Number 

### 27. Write a Java program to create the first twenty Hamming numbers.
In  computer science, regular numbers are often called Hamming numbers, Hamming Numbers are numbers whose only prime factors are 2, 3 and 5.
The first few hamming numbers are :
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30, 32

Expected Output
First Twenty Hamming numbers: 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 27
 30 32 36
```java
// https://rosettacode.org/
import java.math.BigInteger; 
public class Exercise28 {

    public static void main(String args[])
    {
        Stream hamming = makeHamming();
        System.out.print("First Twenty Hamming numbers: ");
        for (int i=0; i<20; i++) {
            System.out.print(hamming.value());
            System.out.print(" ");
            hamming = hamming.advance();
        }
        System.out.println();
     }
 
    public interface Stream
    {
        BigInteger value();
        Stream advance();
    }
 
    public static class MultStream implements Stream
    {
        MultStream(int mult)
        { m_mult = BigInteger.valueOf(mult); }
        MultStream setBase(Stream s)
        { m_base = s; return this; }
        public BigInteger value()
        { return m_mult.multiply(m_base.value()); }
        public Stream advance()
        { return setBase(m_base.advance()); }
 
        private final BigInteger m_mult;
        private Stream m_base;
    }
 
    private final static class RegularStream implements Stream
    {
        RegularStream(Stream[] streams, BigInteger val)
        {
            m_streams = streams;
            m_val = val;
        }
        public BigInteger value()
        { return m_val; }
 
        public Stream advance()
        {
            // memoized value for the next stream instance.
            if (m_advance != null) { return m_advance; }
 
            int minidx = 0 ;
            BigInteger next = nextStreamValue(0);
            for (int i=1; i<m_streams.length; i++) {
                BigInteger v = nextStreamValue(i);
                if (v.compareTo(next) < 0) {
                    next = v;
                    minidx = i;
                }
            }
            RegularStream ret = new RegularStream(m_streams, next);
            // memoize the value!
            m_advance = ret;
            m_streams[minidx].advance();
            return ret;
        }
        private BigInteger nextStreamValue(int streamidx)
        {
            // skip past duplicates in the streams we're merging.
            BigInteger ret = m_streams[streamidx].value();
            while (ret.equals(m_val)) {
                m_streams[streamidx] = m_streams[streamidx].advance();
                ret = m_streams[streamidx].value();
            }
            return ret;
        }
        private final Stream[] m_streams;
        private final BigInteger m_val;
        private RegularStream m_advance = null;
    }
 
    private final static Stream makeHamming()
    {
        MultStream nums[] = new MultStream[] {
            new MultStream(2),
            new MultStream(3),
            new MultStream(5)
        };
        Stream ret = new RegularStream(nums, BigInteger.ONE);
        for (int i=0; i<nums.length; i++) {
            nums[i].setBase(ret);
        }
        return ret;
    }
}
```
Sample Output:

First Twenty Hamming numbers: 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 27 30 32 36
### 28. Write a Java program to check whether a number is an Armstrong Number or not.
Armstrong (Michael F. Armstrong) number is a number that is equal to the sum of cubes of its digits. For example 0, 1, 153, 370, 371 and 407 are the Armstrong numbers
Expected Output

Input an integer:  153
Is Armstrong number? true

Write a Java program to check whether a number is an Armstrong Number or not.

Armstrong (Michael F. Armstrong) number is a number that is equal to the sum of cubes of its digits. For example 0, 1, 153, 370, 371 and 407 are the Armstrong numbers

Sample Solution:

Java Code:
```java
import java.util.*;
public class solution {	
 public static boolean is_Amstrong(int n) {
        int remainder, sum = 0, temp = 0;
        temp = n;
        while (n > 0) {
            remainder = n % 10;
            sum = sum + (remainder * remainder * remainder);
            n = n / 10;
        }
        return sum == temp;
    }  

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input an integer: ");
		String input = scanner.nextLine();
		int number = Integer.parseInt(input); 
		System.out.println("Is Armstrong number? "+is_Amstrong(number));		
		}
 }
```
Sample Output:

Input an integer:  153
Is Armstrong number? true

### 29. Write a Java program to check whether a number is a Luck number or not.
Expected Output

Input an integer:  25
Is Lucky number? true
```java
import java.util.*;
public class solution {	
 public static boolean isLucky(int n) {
         //Create an array of size 10 to initialize all elements as 
		 //false to check if a digit is already seen or not. 
    boolean temp[]=new boolean[10]; 
        for (int i = 0; i < 10; i++) 
            temp[i] = false; 
        while (n > 0) 
        { 
         // Find the last digit 
            int digit = n % 10;       
            // Return false if digit is already seen,  
            if (temp[digit]) 
            return false;       
            temp[digit] = true;            
			n = n / 10; 
        } 
        return true; 
 }	

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input an integer: ");
		String input = scanner.nextLine();
		int number = Integer.parseInt(input); 
		System.out.println("Is Lucky number? "+isLucky(number));		
		}
 }
```
Sample Output:

Input an integer:  25
Is Lucky number? true
