# Java Exercises Method

### 1. Write a Java method to find the smallest number among three numbers.
Test Data:
Input the first number: 25
Input the Second number: 37
Input the third number: 29
Expected Output:

The smallest value is 25.0
```java
import java.util.Scanner;
public class Exercise1 {

 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        double x = in.nextDouble();
        System.out.print("Input the Second number: ");
        double y = in.nextDouble();
        System.out.print("Input the third number: ");
        double z = in.nextDouble();
        System.out.print("The smallest value is " + smallest(x, y, z)+"\n" );
    }

   public static double smallest(double x, double y, double z)
    {
        return Math.min(Math.min(x, y), z);
    }
}
```
Sample Output:

Input the first number: 25                                                                                    
Input the Second number: 37                                                                                   
Input the third number: 29                                                                                    
The smallest value is 25.0

### 2. Write a Java method to compute the average of three numbers.
Test Data:
Input the first number: 25
Input the second number: 45
Input the third number: 65
Expected Output:

The average value is 45.0
```java
import java.util.Scanner;
public class Exercise2 {

 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        double x = in.nextDouble();
        System.out.print("Input the second number: ");
        double y = in.nextDouble();
        System.out.print("Input the third number: ");
        double z = in.nextDouble();
        System.out.print("The average value is " + average(x, y, z)+"\n" );
    }

  public static double average(double x, double y, double z)
    {
        return (x + y + z) / 3;
    }
}
```
Sample Output:

Input the first number: 25                                                                                    
Input the second number: 45                                                                                   
Input the third number: 65                                                                                    
The average value is 45.0

### 3. Write a Java method to display the middle character of a string.
Note: a) If the length of the string is odd there will be two middle characters.
b) If the length of the string is even there will be one middle character.
Test Data:
Input a string: 350
Expected Output:
                                                                          
The middle character in the string: 5
```java
import java.util.Scanner;
public class Exercise3 {
  public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        System.out.print("The middle character in the string: " + middle(str)+"\n");
    }
 public static String middle(String str)
    {
        int position;
        int length;
        if (str.length() % 2 == 0)
        {
            position = str.length() / 2 - 1;
            length = 2;
        }
        else
        {
            position = str.length() / 2;
            length = 1;
        }
        return str.substring(position, position + length);
    }
}
```
Sample Output:

Input a string: 350                                                                                           
The middle character in the string: 5

### 4. Write a Java method to count all vowels in a string.
Test Data:
Input the string: w3resource
Expected Output:

Number of  Vowels in the string: 4
```java
import java.util.Scanner;
public class Exercise4 {
  public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the string: ");
        String str = in.nextLine();

        System.out.print("Number of  Vowels in the string: " + count_Vowels(str)+"\n");
    }
 public static int count_Vowels(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u')
            {
                count++;
            }
        }
        return count;
    }
}
```
Sample Output:

Input the string: w3resource                                                                                  
Number of  Vowels in the string: 4

### 5. Write a Java method to count all the words in a string.
Test Data:
Input the string: The quick brown fox jumps over the lazy dog.
Expected Output:

Number of words in the string: 9
```java
import java.util.Scanner;
public class Exercise5 {

  public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the string: ");
        String str = in.nextLine();

        System.out.print("Number of words in the string: " + count_Words(str)+"\n");
    }

 public static int count_Words(String str)
    {
       int count = 0;
        if (!(" ".equals(str.substring(0, 1))) || !(" ".equals(str.substring(str.length() - 1))))
        {
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == ' ')
                {
                    count++;
                }
            }
            count = count + 1; 
        }
        return count; // returns 0 if string starts or ends with space " ".
    }
 }
```
Sample Output:

Input the string: The quick brown fox jumps over the lazy dog                                                  
Number of words in the string: 9 

### 6. Write a Java method to compute the sum of digits in an integer.
Test Data:
Input an integer: 25
Expected Output:

The sum is 7 
```java
import java.util.Scanner;
public class Exercise6 {

  public static void main(String[] args)
    {
      Scanner in = new Scanner(System.in);
      System.out.print("Input an integer: ");
      int digits = in.nextInt();
	  System.out.println("The sum is " + sumDigits(digits));
    }

 public static int sumDigits(long n) {
		int result = 0;
		
		while(n > 0) {
			result += n % 10;
			n /= 10;
		}
		
		return result;
	}
	
 }
```
Sample Output:

Input an integer: 25                                                                                          
The sum is 7

### 7. Write a Java method to display the first 50 pentagonal numbers.
Note: A pentagonal number is a figurate number that extends the concept of triangular and square numbers to the pentagon, but, unlike the first two, the patterns involved in the construction of pentagonal numbers are not rotationally symmetrical.
Expected Output:


1     5     12    22    35    51    70    92    117   145
176   210   247   287   330   376   425   477   532   590
651   715   782   852   925   1001  1080  1162  1247  1335
1426  1520  1617  1717  1820  1926  2035  2147  2262  2380
2501  2625  2752  2882  3015  3151  3290  3432  3577  3725 
```java
import java.util.Scanner;
public class Exercise7 {
public static void main(String[] args) {
   		int count = 1;
		for(int i = 1; i <= 50; i++){
			System.out.printf("%-6d",getPentagonalNumber(i));
			if(count % 10 == 0) System.out.println();
			count++;
		}
    }
  public static int getPentagonalNumber(int i) {
		return (i * (3 * i - 1))/2;
	}
}
```
Sample Output:

1     5     12    22    35    51    70    92    117   145                                                     
176   210   247   287   330   376   425   477   532   590                                                     
651   715   782   852   925   1001  1080  1162  1247  1335                                                    
1426  1520  1617  1717  1820  1926  2035  2147  2262  2380                                                    
2501  2625  2752  2882  3015  3151  3290  3432  3577  3725

### 8. Write a Java method to compute the future investment value at a given interest rate for a specified number of years.
Sample data (Monthly compounded) and Output:
Input the investment amount: 1000
Input the rate of interest: 10
Input number of years: 5

Expected Output:

Years    FutureValue                                     
1            1104.71                                     
2            1220.39                                     
3            1348.18                                     
4            1489.35                                     
5            1645.31
```java
import java.util.Scanner;
public class Exercise8 {
 
 public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 
    System.out.print("Input the investment amount: ");
 	double investment = in.nextDouble();
 	System.out.print("Input the rate of interest: ");
	double rate = in.nextDouble();
	System.out.print("Input number of years: ");
	int year = in.nextInt();
	
	rate *= 0.01;
	
	System.out.println("Years    FutureValue");
	for(int i = 1; i <= year; i++) {
    	int formatter = 19;
	    if (i >= 10) formatter = 18;
		System.out.printf(i + "%"+formatter+".2f\n", futureInvestmentValue(investment, rate/12, i));
       }
	 }
 
 public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
		return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
	}
}
```
Sample Output:

Input the investment amount: 1000                                                                             
Input the rate of interest: 10                                                                                
Input number of years: 5                                                                                      
Years    FutureValue                                                                                          
1            1104.71                                                                                          
2            1220.39                                                                                          
3            1348.18                                                                                          
4            1489.35                                                                                          
5            1645.31
### 9. Write a Java method to print characters between two characters (i.e. A to P).
Note: Prints 20 characters per line

Expected Output:

( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ;                  
< = > ? @ A B C D E F G H I J K L M N O                  
P Q R S T U V W X Y Z [ \ ] ^ _ ` a b c                  
d e f g h i j k l m n o p q r s t u v w                  
x y z
```java
public class Exercise9 {
   public static void main(String[] args) {
        print_Chars('(', 'z', 20);
    }
 public static void print_Chars(char char1, char char2, int n) {
        for (int ctr = 1; char1 <= char2; ctr++, char1++) {
            System.out.print(char1 + " ");
            if (ctr % n == 0) System.out.println("");
        }
		System.out.print("\n");
    }
}
```
Sample Output:

( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ;                                                                       
< = > ? @ A B C D E F G H I J K L M N O                                                                       
P Q R S T U V W X Y Z [ \ ] ^ _ ` a b c                                                                       
d e f g h i j k l m n o p q r s t u v w                                                                       
x y z
### 10. Write a Java method to check whether a year (integer) entered by the user is a leap year or not.

Expected Output:

Input a year: 2017                                                                        
false
```java
import java.util.Scanner;

public class Exercise10 {
 
 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a year: ");
        int year = in.nextInt();

        System.out.println(is_LeapYear(year));
    }
 
 public static boolean is_LeapYear(int y)
    {
        boolean a = (y % 4) == 0;
        boolean b = (y % 100) != 0;
        boolean c = ((y % 100 == 0) && (y % 400 == 0));

        return a && (b || c);
    }
}
```
Sample Output:

Input a year: 2017                                                                                            
false
### 11. Write a Java method to check whether a string is a valid password.
Password rules:
A password must have at least ten characters.
A password consists of only letters and digits.
A password must contain at least two digits.

Expected Output:

1. A password must have at least eight characters.                                             
2. A password consists of only letters and digits.                                         
3. A password must contain at least two digits                                        
Input a password (You are agreeing to the above Terms and Conditions.): abcd1234           
Password is valid: abcd1234 
```java
import java.util.Scanner;

public class Exercise11 {
    
public static final int PASSWORD_LENGTH = 8;

public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print(
                "1. A password must have at least eight characters.\n" +
                "2. A password consists of only letters and digits.\n" +
                "3. A password must contain at least two digits \n" +
                "Input a password (You are agreeing to the above Terms and Conditions.): ");
        String s = input.nextLine();

        if (is_Valid_Password(s)) {
            System.out.println("Password is valid: " + s);
        } else {
            System.out.println("Not a valid password: " + s);
        }

    }

    public static boolean is_Valid_Password(String password) {

        if (password.length() < PASSWORD_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }

}
```
Sample Output:

1. A password must have at least eight characters.                                                            
2. A password consists of only letters and digits.                                                            
3. A password must contain at least two digits                                                                
Input a password (You are agreeing to the above Terms and Conditions.): abcd1234                              
Password is valid: abcd1234 
### 12. Write a Java method (takes n as input) to display an n-by-n matrix.

Expected Output:

Input a number: 10                                                                         
1 0 0 1 1 0 0 0 1 1                                                                       
0 0 1 0 1 0 1 0 0 0                                                                        
0 1 0 1 0 0 0 0 0 1                                                                       
1 1 1 0 0 0 0 1 1 1                                                                        
1 1 0 1 1 1 0 1 0 0                                                                      
1 0 0 0 1 1 0 0 0 0                                                                       
0 0 1 0 0 0 0 1 1 1                                                                      
1 1 0 1 0 1 0 0 1 0                                                                       
0 0 1 0 0 0 0 1 1 0                                                        
1 1 1 0 0 1 1 1 1 0
```java
import java.util.Scanner;

public class Exercise12 {
 
public static void main(String[] args)
    {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int n = in.nextInt();
        printMatrix(n);
    }
 
 public static void printMatrix(int n) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print((int)(Math.random() * 2) + " ");
            }
            System.out.println();
        }
    }
}
```
Sample Output:

Input a number: 10                                                                                            
1 0 0 1 1 0 0 0 1 1                                                                                           
0 0 1 0 1 0 1 0 0 0                                                                                           
0 1 0 1 0 0 0 0 0 1                                                                                           
1 1 1 0 0 0 0 1 1 1                                                                                           
1 1 0 1 1 1 0 1 0 0                                                                                           
1 0 0 0 1 1 0 0 0 0                                                                                           
0 0 1 0 0 0 0 1 1 1                                                                                           
1 1 0 1 0 1 0 0 1 0                                                                                           
0 0 1 0 0 0 0 1 1 0                                                                                           
1 1 1 0 0 1 1 1 1 0

### 13. Write Java methods to calculate triangle area.

Expected Output:

Input Side-1: 10                                                                               
Input Side-2: 15                                                                               
Input Side-3: 20                                                                              
The area of the triangle is 72.6184377413890
```java
import java.util.Scanner;
public class Exercise13 {
  public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
         System.out.print("Input Side-1: ");
         double side1 = in.nextDouble();
         System.out.print("Input Side-2: ");
         double side2 = in.nextDouble();
         System.out.print("Input Side-3: ");
         double side3 = in.nextDouble();
         System.out.println( is_Valid(side1, side2,side3) ?
                "The area of the triangle is " + area_triangle(side1, side2, side3) : "Invalid triangle" );
    }

  public static boolean is_Valid(double side1, double side2, double side3) {
        if( side1 + side2 > side3 &&
                side2 + side3 > side1 &&
                side1 + side3 > side2) return true;
        else return false;
    }
   public static double area_triangle(double side1, double side2, double side3) {
        double area = 0;
        double s = (side1 + side2 + side3)/2;
        area = Math.sqrt(s*(s - side1)*(s - side2)*(s - side3));
        return area;
    }
}
```
Sample Output:

Input Side-1: 10                                                                                              
Input Side-2: 15                                                                                              
Input Side-3: 20                                                                                              
The area of the triangle is 72.61843774138907 
### 14. Write a Java method to create a pentagon's area.

Expected Output:

Input the number of sides: 5                             
Input the side: 6                                        
The area of the pentagon is 61.93718642120281
```java
import java.util.Scanner;
public class Exercise14 {
 
  public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of sides: ");
        int n = input.nextInt();
        System.out.print("Input the side: ");
        double side = input.nextDouble();

        System.out.println("The area of the pentagon is " + pentagon_area(n, side));
    }

    public static double pentagon_area(int n, double s) {
        return  (n * s * s) / (4 * Math.tan(Math.PI/n));
    }
}
```
Sample Output:

Input the number of sides: 5                                                                                  
Input the side: 6                                                                                             
The area of the pentagon is 61.93718642120281
### 15. Write a Java method to display the current date and time.

Expected Output:

Current date and time: Wednesday January 25, 2017 7:47:43
```java
import java.util.Scanner;
public class Exercise15 {
 
 public static void main(String[] args) {

        // Obtain the total milliseconds since midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();

        // Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = totalMilliseconds / 1000;

        // Compute the current second in the minute in the hour
        long currentSecond = (int)(totalSeconds % 60);

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute in the hour
        long currentMinute = (int)(totalMinutes % 60);

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        long currentHour = (int)(totalHours % 24);

        long totalDays = totalHours / 24;

        // current year
        int currentYear = (int)(totalDays / 365) + 1970;


        long daysInCurrentYear = (totalDays - numberOfLeapYearsSince1970(currentYear)) % 365;
        if (currentHour > 0) daysInCurrentYear++; // add today

        // get current month number
        int currentMonthNum = getMonthFromDays(currentYear, (int) daysInCurrentYear);

        // getting current month name
        String month = getMonthName(currentMonthNum);

        // getting day of current month
        int daysTillCurrentMonth = getNumOfDaysToReachThatMonth(currentYear, currentMonthNum);

        int startDay = getStartDay(currentYear, currentMonthNum);
        int today = (int) daysInCurrentYear - daysTillCurrentMonth;
        String dayOfWeek = dayNameOfWeek( ((startDay + today) % 7));

        // Display results
        System.out.println("Current date and time: " + dayOfWeek + " " + month + " " + today +", " + currentYear
        +" " + currentHour + ":"
                + currentMinute + ":" + currentSecond );

    }

    public static String dayNameOfWeek(int dayOfWeek) {

        switch (dayOfWeek) {
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            case 7: return "Saturday";
            case 1: return "Sunday";
            default: return null;
        }
    }

    public static int numberOfLeapYearsSince1970(long year) {

        int count = 0;
        for (int i = 1970; i <= year; i++) {
            if (isLeapYear(i))count++;
        }
        return count;
    }


    public static int getMonthFromDays(int year, int days) {
        int dayTracker = 0;
        for (int i = 1; i <= 12; i++) {

            dayTracker += getNumberOfDaysInMonth(year, i);

            if (dayTracker > days) return i;
        }
        return 12;
    }

    public static int getNumOfDaysToReachThatMonth(int year, int month) {
        int dayTracker = 0;
        for (int i = 1; i < month; i++) {

            dayTracker += getNumberOfDaysInMonth(year, i);


        }
        return dayTracker;
    }

    /** Get the start day of month/1/year */
    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        // Get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        // Return the start day for month/1/year
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /** Get the total number of days since January 1, 1800 */
    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        // Get the total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;

        // Add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);

        return total;
    }

    /** Get the number of days in a month */
    public static int getNumberOfDaysInMonth(int year, int month) {

        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0; // If month is incorrect
    }

    /** Determine if it is a leap year */
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }


    /** Get the English name for the month 1-12 */
    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";
        }

        return monthName;
    }

}
```
Sample Output:

Current date and time: Thursday June 22, 2017 7:5:36
### 16. Write a Java method to find all twin prime numbers less than 100.

Expected Output:

(3, 5)                                                   
(5, 7)                                                   
(11, 13)                                                 
(17, 19)                                                 
(29, 31)                                                 
(41, 43)                                                 
(59, 61)                                                 
(71, 73) 
```java
import java.util.Scanner;
public class Exercise16 {
 
 public static void main(String[] args) {

        for (int i = 2; i < 100; i++) {

            if (is_Prime(i) && is_Prime(i + 2)) {
                System.out.printf("(%d, %d)\n", i, i + 2);
            }
        }
    }

    public static boolean is_Prime(long n) {

        if (n < 2) return false;

        for (int i = 2; i <= n / 2; i++) {

            if (n % i == 0) return false;
        }
        return true;
    }

}
```
Sample Output:

(3, 5)                                                                                                  
(5, 7)                                                                                                  
(11, 13)                                                                                                  
(17, 19)                                                                                                  
(29, 31)                                                                                                  
(41, 43)                                                                                                  
(59, 61)                                                                                                  
(71, 73)

### 17. Write a Java method to count the number of digits in an integer with the value 2. The integer may be assumed to be non-negative.

Expected Output:

Input a number:  12541
1
```java
import java.util.Scanner;
public class Main {
 public static void main(String[] args)
   {
       Scanner in = new Scanner(System.in);
       System.out.print("Input a number: ");
       int n = in.nextInt();
       if (n>0)
       {
       System.out.println(test(n));
       }
   }
 public static int test(int num)
   {
    int ctr = 0;
    int n = num;
    do{
      if (n % 10 == 2){
          ctr ++;
      }
      n /= 10;
     }while(n > 0);
      return ctr;
   }
}
```
Sample Output:

Input a number:  12541
1
### 18. Write a Java method that accepts three integers and checks whether they are consecutive or not. Returns true or false.

Expected Output:

Input the first number:  15
Input the second number:  16
Input the third number:  17
Check whether the three said numbers are consecutive or not!true
```java
import java.util.Scanner;
public class Main { 
 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int x = in.nextInt();
        System.out.print("Input the second number: ");
        int y = in.nextInt();
        System.out.print("Input the third number: ");
        int z = in.nextInt();
        System.out.print("Check whether the three said numbers are consecutive or not!");
        System.out.println(test(x,y,z));
        }

 public static boolean test(int x, int y, int z){
    int max_num = Math.max(x, Math.max(y, z));
    int min_num = Math.min(x, Math.min(y, z));
    int middle_num = x+y+z - max_num - min_num;
    return (max_num - middle_num) == 1 && (middle_num - min_num == 1);
  }
} 
```
Sample Output:

Input the first number:  15
Input the second number:  16
Input the third number:  17
Check whether the three said numbers are consecutive or not!true

### 19. Write a Java method that accepts three integers and returns true if one is the middle point between the other two integers, otherwise false.

Expected Output:

Input the first number:  2
Input the second number:  4
Input the third number:  6
Check whether the three said numbers has a midpoint!
true
```java
import java.util.Scanner;
public class Main { 
 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int x = in.nextInt();
        System.out.print("Input the second number: ");
        int y = in.nextInt();
        System.out.print("Input the third number: ");
        int z = in.nextInt();
        System.out.print("Check whether the three said numbers has a midpoint!\n");
        System.out.print(test(x,y,z));
        }

 public static boolean test(int x, int y, int z){
    int max = Math.max(x, Math.max(y,z));
    int min = Math.min(x, Math.min(y,z));
    double mid_point1 = (max + min) / 2.0;
    int mid_point2 = x + y + z - max - min;
    return (mid_point1 == mid_point2);
  }
}
```
Sample Output:

Input the first number:  2
Input the second number:  4
Input the third number:  6
Check whether the three said numbers has a midpoint!
true
### 20. Write a Java method for extracting the first digit from a positive or negative integer.

Expected Output:

Input an integer(positive/negative): 1234
Extract the first digit from the said integer:
1
```java
import java.util.Scanner;
public class Main { 
 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an integer(positive/negative):");
        int n = in.nextInt();
        System.out.print("Extract the first digit from the said integer:\n");
        System.out.print(test(n));
        }

public static int test(int n){
       int fact_num = 10;
       while(n / fact_num != 0){
        fact_num *= 10;
    }
    return Math.abs(n / (fact_num/10));
  }
}
```
Sample Output:

Input an integer(positive/negative): 1234
Extract the first digit from the said integer:
1

### 21. Write a Java method to display the factors of 3 in a given integer.

Expected Output:

Input an integer(positive/negative): 81

Factors of 3 of the said integer:
81 = 3 * 3 * 3 * 3 * 1
```java
import java.util.Scanner;
public class Main { 
 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an integer(positive/negative):");
        int n = in.nextInt();
        System.out.print("\nFactors of 3 of the said integer:\n");
        test(n);
        }

public static void test(int n){
    System.out.print(n + " = ");
    int result = n;
    while (result % 3 == 0){
        System.out.print("3 * ");
        result = result / 3;
    }
    System.out.print(result);
}
}
```
Sample Output:

Input an integer(positive/negative): 81

Factors of 3 of the said integer:
81 = 3 * 3 * 3 * 3 * 1

### 22. Write a Java method to check whether every digit of a given integer is even. Return true if every digit is odd otherwise false.

Expected Output:

Input an integer: 8642
Check whether every digit of the said integer is even or not!
true
```java
import java.util.Scanner;
public class Main { 
 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an integer:");
        int n = in.nextInt();
        System.out.print("Check whether every digit of the said integer is even or not!\n");
        System.out.print(test(n));
        }

  public static boolean test(int n){
    final int f = 10;
    if (n == 0){
        return false;
    }
    while(n != 0){
        if((n % f) % 2 != 0){
            return false;
        }
        n /= 10;
    }
     return true;
   }
}
```
Sample Output:

Input an integer: 8642
Check whether every digit of the said integer is even or not!
true
### 23. Write a Java method that checks whether all the characters in a given string are vowels (a, e,i,o,u) or not. Return true if each character in the string is a vowel, otherwise return false.

Expected Output:

Input a string:  AIEEE
Check all the characters of the said string are vowels or not!
true
```java
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input a string: ");
    String str = sc.nextLine();
    System.out.print("Check all the characters of the said string are vowels or not!\n");
    System.out.print(test(str));
  }

  public static boolean test(String input) {
    String str_vowels = "aeiou";
    String phrase = input.toLowerCase();
    for (int i = 0; i < phrase.length(); i++) {
      if (str_vowels.indexOf(phrase.charAt(i)) == -1)
        return false;
    }
    return true;
  }
}
```
Sample Output:

Input a string:  AIEEE
Check all the characters of the said string are vowels or not!
true

