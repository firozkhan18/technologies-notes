# com\java\eight8\numbers\RandomNumbers.java

```java
package com.java.eight8.numbers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//What Is Random Number?
//“Randomness” is something which is totally unpredictable and unbiased. Random number is a number picked randomly from the given set of numbers. There will be no relation or dependency between the two successively picked numbers.
//
//
//Random Number Generator :
//An ideal Random Number Generator is the one which generates a series of numbers in the given range where,
//
//Each possible number have equal probability of picking up.
//There will be no relation or dependency between the previously generated number and the present one.
//How To Generate Random Numbers In Java?
//Java provides two ways to generate random numbers. One is using java.util.Random class and another one is using Math.random() method. There is one more method introduced in JAVA 7. It is using ThreadLocalRandom class. We will discuss all three methods in this article.
//
//Generating Random Numbers Using java.util.Random Class :
//Using java.util.Random class, you can generate random integers, doubles, floats, longs and booleans. Below is the program which generates random integers, doubles and booleans using java.util.Random class.

public class RandomNumbers
{
    public static void main(String[] args)
    {
        Random random = new Random();
 
        //Generating random integers using Random class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Integers : "+random.nextInt());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random doubles using Random class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Doubles : "+random.nextDouble());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random booleans using Random class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random booleans : "+random.nextBoolean());
        }
    }
}


//Note : Integers generated are in the range of -231 and 231-1. Generated doubles are in the range from 0.0 to 1.0.
//
//Generating Random Numbers Using Math.random() :
//Using Math.random() method, you can generate only random doubles.

public class MainClass
{
    public static void main(String[] args)
    {
        //Generating random doubles using Math.random()
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Doubles : "+Math.random());
        }
    }
}
//Generating Random Numbers Using ThreadLocalRandom Class :
//java.util.concurrent.ThreadLocalRandom class is introduced in Java 7. Below program shows how to generate random integers, doubles and booleans using ThreadLocalRandom class.

public class MainClass
{
    public static void main(String[] args)
    {
        //Generating random integers using ThreadLocalRandom class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Integers : "+ThreadLocalRandom.current().nextInt());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random doubles using ThreadLocalRandom class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Doubles : "+ThreadLocalRandom.current().nextDouble());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random booleans using ThreadLocalRandom class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random booleans : "+ThreadLocalRandom.current().nextBoolean());
        }
    }
}

//Generating Random Numbers In The Given Range :
//Below is the java program which generates random integers in the range from 0 to 50 using all three methods – Random class, Math.random() and ThreadLocalRandom class.

public class MainClass
{
    public static void main(String[] args)
    {
        //Generating random integers between 0 and 50 using Random class
 
        System.out.println("Random integers between 0 and 50 using Random class :");
 
        Random random = new Random();
 
        for (int i = 0; i < 5; i++)
        {
            System.out.println(random.nextInt(50));
        }
 
        //Generating random integers between 0 and 50 range using Math.random()
 
        System.out.println("Random integers between 0 and 50 using Math.random() :");
 
        for (int i = 0; i < 5; i++)
        {
            System.out.println((int)(Math.random() * 50));
        }
 
        //Generating random integers between 0 and 50 using ThreadLoclaRandom
 
        System.out.println("Random integers between 0 and 50 using ThreadLocalRandom :");
 
        for (int i = 0; i < 5; i++)
        {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 50));
        }
    }
}
```
