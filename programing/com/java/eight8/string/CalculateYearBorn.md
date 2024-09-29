# com\java\eight8\string\CalculateYearBorn.java

```java
package com.java.eight8.string;

import java.util.Scanner;
//Create a Java program that takes user input for their age and then calculates and displays the year they were born in.

//This program takes the user's age as input, calculates the year they were born in, and then displays it to the user.
public class CalculateYearBorn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Ask user for age
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        
        // Calculate the year born
        int currentYear = 2022;
        int yearBorn = currentYear - age;
        
        // Display the year born
        System.out.println("You were born in the year: " + yearBorn);
        
        input.close();
    }
}
```
