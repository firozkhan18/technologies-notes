# com\java\eight8\numbers\CheckWhetherTheGivenNumberIsBinaryOrNot.java

```java
package com.java.eight8.numbers;

//We check each and every digit of a given number. If any digit is greater than 1, then the given number is not a binary number. In this program, we use two simple operators – % and /, to extract the digits from the given number. You may know that, if we divide any number by 10 i.e number/10, it will remove last digit from the given number and if you use remainder operator like number%10, it will give last digit of the given number. For example, if 456 is the number, then 456/10 will result 45 and 456%10 will give 6. We use these two techniques to extract the digits from the given number one by one and we will check whether this extracted digit is greater than 1. If the extracted digit is greater than 1, then we will conclude that the given number is not a binary number.
public class CheckWhetherTheGivenNumberIsBinaryOrNot {
	static void isBinaryOrNot(int number)
    {
        boolean isBinary = true;
 
        int copyOfNumber = number;
 
        while (copyOfNumber != 0)
        {
            int temp = copyOfNumber%10;   //Gives last digit of the number
 
            if(temp > 1)
            {
                isBinary = false;
                break;
            }
            else
            {
                copyOfNumber = copyOfNumber/10;    //Removes last digit from the number
            }
        }
 
        if (isBinary)
        {
            System.out.println(number+" is a binary number");
        }
        else
        {
            System.out.println(number+" is not a binary number");
        }
    }
 
    public static void main(String[] args)
    {
        isBinaryOrNot(128956);
 
        isBinaryOrNot((101110));
 
        isBinaryOrNot((42578));
 
        isBinaryOrNot((10110101));
    }
    
//  1st Iteration —> As 10111 != 0, temp = 10111%10 = 1. temp is not greater than 1, so copyOfNumber = 10111/10 = 1011.
//
//	2nd Iteration —> As 1011 != 0, temp = 1011%10 = 1. temp is not greater than 1, so copyOfNumber = 1011/10 = 101.
//
//	3rd Iteration —> As 101 != 0, temp = 101%10 = 1. temp is not greater than 1, so copyOfNumber = 101/10 = 10.
//
//	4th Iteration —> As 10 != 0, temp = 10%10 = 0. temp is not greater than 1, so copyOfNumber = 10/10 = 1.
//
//	5th Iteration —> As 1 != 0, temp = 1%10 = 1. temp is not greater than 1, so copyOfNumber = 1/10 = 0.
//
//	6th Iteration —> As 0 == 0, breaks the loop.
}
```
