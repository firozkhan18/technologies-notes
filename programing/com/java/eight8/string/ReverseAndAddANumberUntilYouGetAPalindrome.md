# com\java\eight8\string\ReverseAndAddANumberUntilYouGetAPalindrome.java

```java
package com.java.eight8.string;

import java.util.Scanner;

//Problem :
//
//
//Take number from the user, reverse it and add it to itself. If the sum is not a palindrome then repeat the procedure until you get a palindrome.
//
//For example, If 7325 is input number, then
//
//7325 (Input Number) + 5237 (Reverse Of Input Number) = 12562
//
//12562 + 26521 = 39083
//
//
//39083 + 38093 = 77176
//
//77176 + 67177 = 144353
//
//144353 + 353441 = 497794 (Palindrome)
//
//In this particular case, we got a palindrome (497794) after 5th addition. This method gives palindrome in few steps for almost all of the integers.
//
//Note : Palindrome number is a number which remains the same when its digits are reversed. For example, 121, 7227, 45654.
public class ReverseAndAddANumberUntilYouGetAPalindrome {
	//Method To Reverse A Number
    
    static int reverseNumber(int number)
    {
        int reverse = 0;
         
        int rem = 0;
         
        while (number != 0)
        {
            rem = number % 10;
             
            reverse = (reverse*10) + rem;
             
            number = number/10;
        }
         
        return reverse;
    }
     
    //Method To Check For Palindrome
     
    static boolean checkPalindrome(int number)
    {
        int reverse = reverseNumber(number);
         
        if(reverse == number)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
     
    //Method To Reverse And Add Given Number Until You Get A Palindrome
     
    static void reverseAndAdd(int number)
    {
        if(checkPalindrome(number))
        {
            System.out.println("Given Number is already a palindrome");
        }
        else
        {
            while (!checkPalindrome(number))
            {
                int reverse = reverseNumber(number);
                 
                int sum = number + reverse;
                 
                System.out.println(number+" + "+reverse+" = "+sum);
                 
                number = sum;
            }
        }
    }
     
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter Number : ");
         
        int inputNumber = sc.nextInt();
         
        reverseAndAdd(inputNumber);
    }
}

// How It Works?
//
// Let 7325 be inputNumber,
//
//
// 1st Iteration :
//
// As number = 7325 is not a palindrome
//
// reverse = reverseNumber(7325) = 5237
//
// sum = number + reverse = 7325 + 5237 = 12562
//
// number = sum = 12562
//
// 2nd Iteration :
//
// As number = 12562 is not a palindrome
//
// reverse = reverseNumber(12562) = 26521
//
// sum = number + reverse = 12562 + 26521 = 39083
//
// number = sum = 39083
//
// 3rd Iteration :
//
// As number = 39083 is not a palindrome
//
// reverse = reverseNumber(39083) = 38093
//
// sum = number + reverse = 39083 + 38093 = 77176
//
// number = sum = 77176
//
// 4th Iteration :
//
// As number = 77176 is not a palindrome
//
// reverse = reverseNumber(77176) = 67177
//
// sum = number + reverse = 77176 + 67177 = 144353
//
// number = sum = 144353
//
// 5th Iteration :
//
// As number = 144353 is not a palindrome
//
// reverse = reverseNumber(144353) = 353441
//
// sum = number + reverse = 144353 + 353441 = 497794
//
// number = sum = 497794
//
// 6th Iteration :
//
// As number = 497794 is a palindrome
//
// Exit loop.
```
