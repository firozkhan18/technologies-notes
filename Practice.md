# Collection framework examples

Sure! Let's explore various ways to create and initialize arrays and collections for `int`, `Integer`, and `String` types in Java. We’ll also look at ways to work with these types in streams.

### Arrays

#### `int` Arrays

1. **Direct Initialization**:
   ```java
   int[] intArray = {1, 2, 3, 4};
   ```

2. **Using `new` Keyword**:
   ```java
   int[] intArray = new int[]{1, 2, 3, 4};
   ```

3. **Using `Arrays.fill()`**:
   ```java
   int[] intArray = new int[4];
   Arrays.fill(intArray, 1); // All elements set to 1
   ```

4. **Using `Array.newInstance()`**:
   ```java
   int[] intArray = (int[]) Array.newInstance(int.class, 4);
   intArray[0] = 1;
   intArray[1] = 2;
   intArray[2] = 3;
   intArray[3] = 4;
   ```

#### `Integer` Arrays

1. **Direct Initialization**:
   ```java
   Integer[] integerArray = {1, 2, 3, 4};
   ```

2. **Using `new` Keyword**:
   ```java
   Integer[] integerArray = new Integer[]{1, 2, 3, 4};
   ```

3. **Using `Arrays.asList()`**:
   ```java
   List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
   Integer[] integerArray = integerList.toArray(new Integer[0]);
   ```

4. **Using `Stream.of()`**:
   ```java
   Integer[] integerArray = Stream.of(1, 2, 3, 4)
                                   .toArray(Integer[]::new);
   ```

#### `String` Arrays

1. **Direct Initialization**:
   ```java
   String[] stringArray = {"a", "b", "c", "d"};
   ```

2. **Using `new` Keyword**:
   ```java
   String[] stringArray = new String[]{"a", "b", "c", "d"};
   ```

3. **Using `Arrays.asList()`**:
   ```java
   List<String> listOfString = Arrays.asList("a", "b", "c", "d");
   String[] stringArray = stringList.toArray(new String[0]);
   ```

4. **Using `Stream.of()`**:
   ```java
   String[] streamLstOfString = Stream.of("a", "b", "c", "d")
                                 .toArray(String[]::new);
   Or

   Stream<String> streamLstOfString = Stream.of("a", "b", "c", "d");
   ```
1. **Direct Initialization**:

    ```java
   char[] charArray= {'a', 'b', 'c', 'd'};
    ```
3. **Using `new` Keyword**:

    ```java
   char[] charArray1= new char[]{'a', 'b', 'c', 'd'};
    ```
5. **Using `Arrays.asList()`**:

   ```java
   List<Character> listOfCharacter = Arrays.asList('a', 'b', 'c', 'd');
   ```      
7. **Using `Stream.of()`**:

    ```java
   Stream<Character> streamListOfCharacter = Stream.of('a', 'b', 'c', 'd');
   ```

### Collections

#### `int` Values in Collections

Since `int` is a primitive type, you cannot use it directly in collections like `List` or `Set`. You must use `Integer`, the wrapper class.

1. **Using `Arrays.asList()`** (Note: Requires boxing):
   ```java
   List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
   ```

2. **Using `List.of()` (Java 9 and above)**:
   ```java
   List<Integer> integerList = List.of(1, 2, 3, 4);
   ```

#### `Integer` Values in Collections

1. **Using `Arrays.asList()`**:
   ```java
   List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
   ```

2. **Using `List.of()` (Java 9 and above)**:
   ```java
   List<Integer> integerList = List.of(1, 2, 3, 4);
   ```

3. **Using `Collections.singletonList()`**:
   ```java
   List<Integer> singletonList = Collections.singletonList(1);
   ```

#### `String` Values in Collections

1. **Using `Arrays.asList()`**:
   ```java
   List<String> stringList = Arrays.asList("a", "b", "c", "d");
   ```

2. **Using `List.of()` (Java 9 and above)**:
   ```java
   List<String> stringList = List.of("a", "b", "c", "d");
   ```

3. **Using `Collections.singletonList()`**:
   ```java
   List<String> singletonList = Collections.singletonList("a");
   ```

### Streams

#### `int` Values in Streams

1. **Using `IntStream.of()`**:
   ```java
   IntStream intStream = IntStream.of(1, 2, 3, 4);
   ```

2. **Generating an IntStream**:
   ```java
   IntStream intStream = IntStream.range(1, 5); // Generates 1, 2, 3, 4
   ```

#### `Integer` Values in Streams

1. **Using `Stream.of()`**:
   ```java
   Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
   ```

2. **Generating a Stream**:
   ```java
   Stream<Integer> integerStream = Stream.iterate(1, n -> n + 1).limit(4);
   ```

#### `String` Values in Streams

1. **Using `Stream.of()`**:
   ```java
   Stream<String> stringStream = Stream.of("a", "b", "c", "d");
   ```

2. **Generating a Stream**:
   ```java
   Stream<String> stringStream = Stream.iterate("a", s -> String.valueOf((char) (s.charAt(0) + 1)))
                                       .limit(4);
   ```

### Summary

You have various methods for initializing and working with arrays and collections in Java, whether using primitive types like `int`, wrapper types like `Integer`, or objects like `String`. For each type, you can use direct initialization, utility methods from `Arrays` and `Collections`, and streams for more flexible and functional-style operations.

Certainly! Converting between `int`, `char`, `String`, and `Integer` arrays in Java using streams involves several common operations. Below, I'll show you how to perform these conversions with examples.

### 1. **Converting `int` to `Integer` Array**

To convert an `int` array to an `Integer` array using streams:

```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class IntToIntegerConversion {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4};

        // Convert int[] to Integer[]
        Integer[] integerArray = Arrays.stream(intArray)
                                       .boxed()  // Convert int to Integer
                                       .toArray(Integer[]::new);

        System.out.println(Arrays.toString(integerArray));
    }
}
```

### 2. **Converting `Integer` to `int` Array**

To convert an `Integer` array to an `int` array:

```java
import java.util.Arrays;

public class IntegerToIntConversion {
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4};

        // Convert Integer[] to int[]
        int[] intArray = Arrays.stream(integerArray)
                               .mapToInt(Integer::intValue)  // Convert Integer to int
                               .toArray();

        System.out.println(Arrays.toString(intArray));
    }
}
```

### 3. **Converting `char` to `String` Array**

To convert a `char` array to a `String` array:

```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class CharToStringConversion {
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd'};

        // Convert char[] to String[]
        String[] stringArray = new String(charArray.length);
        for (int i = 0; i < charArray.length; i++) {
            stringArray[i] = String.valueOf(charArray[i]);
        }

        System.out.println(Arrays.toString(stringArray));
    }
}
```

### 4. **Converting `String` to `char` Array**

To convert a `String` array to a `char` array:

```java
import java.util.Arrays;

public class StringToCharConversion {
    public static void main(String[] args) {
        String[] stringArray = {"a", "b", "c", "d"};

        // Convert String[] to char[]
        char[] charArray = Arrays.stream(stringArray)
                                 .collect(Collectors.joining())  // Concatenate all strings
                                 .toCharArray();  // Convert to char array

        System.out.println(Arrays.toString(charArray));
    }
}
```

### 5. **Converting `String` to `Integer` Array**

To convert a `String` array to an `Integer` array:

```java
import java.util.Arrays;

public class StringToIntegerConversion {
    public static void main(String[] args) {
        String[] stringArray = {"1", "2", "3", "4"};

        // Convert String[] to Integer[]
        Integer[] integerArray = Arrays.stream(stringArray)
                                       .map(Integer::parseInt)  // Convert String to Integer
                                       .toArray(Integer[]::new);

        System.out.println(Arrays.toString(integerArray));
    }
}
```

### 6. **Converting `Integer` to `String` Array**

To convert an `Integer` array to a `String` array:

```java
import java.util.Arrays;

public class IntegerToStringConversion {
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4};

        // Convert Integer[] to String[]
        String[] stringArray = Arrays.stream(integerArray)
                                     .map(String::valueOf)  // Convert Integer to String
                                     .toArray(String[]::new);

        System.out.println(Arrays.toString(stringArray));
    }
}
```

### Summary

In summary:

- **`int[]` to `Integer[]`**: Use `boxed()` to convert primitive `int` to `Integer`.
- **`Integer[]` to `int[]`**: Use `mapToInt(Integer::intValue)` to extract primitive values.
- **`char[]` to `String[]`**: Convert each `char` to `String` individually.
- **`String[]` to `char[]`**: Concatenate all `String` elements and then convert to `char[]`.
- **`String[]` to `Integer[]`**: Parse each `String` to `Integer`.
- **`Integer[]` to `String[]`**: Convert each `Integer` to `String`.

These methods leverage Java streams to perform conversions efficiently and concisely.

Converting an `int` to different number systems (binary, octal, and hexadecimal) in Java can be done easily using built-in methods from the `Integer` class. Here's how you can perform these conversions:

### 1. **Binary Conversion**

To convert an `int` to a binary string:

```java
public class IntToBinary {
    public static void main(String[] args) {
        int number = 42;
        
        // Convert int to binary string
        String binaryString = Integer.toBinaryString(number);
        
        System.out.println("Binary representation of " + number + ": " + binaryString);
    }
}
```

**Output:**

```
Binary representation of 42: 101010
```

### 2. **Octal Conversion**

To convert an `int` to an octal string:

```java
public class IntToOctal {
    public static void main(String[] args) {
        int number = 42;
        
        // Convert int to octal string
        String octalString = Integer.toOctalString(number);
        
        System.out.println("Octal representation of " + number + ": " + octalString);
    }
}
```

**Output:**

```
Octal representation of 42: 52
```

### 3. **Hexadecimal Conversion**

To convert an `int` to a hexadecimal string:

```java
public class IntToHexadecimal {
    public static void main(String[] args) {
        int number = 42;
        
        // Convert int to hexadecimal string
        String hexString = Integer.toHexString(number);
        
        System.out.println("Hexadecimal representation of " + number + ": " + hexString);
    }
}
```

**Output:**

```
Hexadecimal representation of 42: 2a
```

### **Summary of Methods**

- **Binary**: `Integer.toBinaryString(int)`
- **Octal**: `Integer.toOctalString(int)`
- **Hexadecimal**: `Integer.toHexString(int)`

### **Additional Formatting Options**

If you want to include leading zeros or format the output in a specific way, you can use `String.format()`. For example:

```java
public class IntToFormattedConversions {
    public static void main(String[] args) {
        int number = 42;

        // Binary with leading zeros to ensure 8-bit representation
        String binaryString = String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0');
        
        // Octal with leading zeros to ensure 4-digit representation
        String octalString = String.format("%4s", Integer.toOctalString(number)).replace(' ', '0');
        
        // Hexadecimal with leading zeros to ensure 2-digit representation
        String hexString = String.format("%2s", Integer.toHexString(number)).toUpperCase().replace(' ', '0');
        
        System.out.println("Binary representation: " + binaryString);
        System.out.println("Octal representation: " + octalString);
        System.out.println("Hexadecimal representation: " + hexString);
    }
}
```

**Output:**

```
Binary representation: 00101010
Octal representation: 0052
Hexadecimal representation: 2A
```

In this example:
- `%8s` ensures an 8-bit binary representation.
- `%4s` ensures a 4-digit octal representation.
- `%2s` ensures a 2-digit hexadecimal representation.

You can adjust the format specifiers as needed for different representations and padding requirements.

Certainly! You can manually convert an `int` to its binary, octal, and hexadecimal representations without using Java's predefined methods. Here’s how you can achieve these conversions using custom logic:

### 1. **Binary Conversion**

To convert an `int` to a binary string manually, you can repeatedly divide the number by 2 and track the remainders:

```java
public class IntToBinaryManual {
    public static void main(String[] args) {
        int number = 42;
        String binaryString = intToBinary(number);
        System.out.println("Binary representation of " + number + ": " + binaryString);
    }

    public static String intToBinary(int number) {
        if (number == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.insert(0, number % 2);
            number /= 2;
        }
        return binary.toString();
    }
}
```

### 2. **Octal Conversion**

To convert an `int` to an octal string manually, you can repeatedly divide the number by 8 and track the remainders:

```java
public class IntToOctalManual {
    public static void main(String[] args) {
        int number = 42;
        String octalString = intToOctal(number);
        System.out.println("Octal representation of " + number + ": " + octalString);
    }

    public static String intToOctal(int number) {
        if (number == 0) return "0";
        StringBuilder octal = new StringBuilder();
        while (number > 0) {
            octal.insert(0, number % 8);
            number /= 8;
        }
        return octal.toString();
    }
}
```

### 3. **Hexadecimal Conversion**

To convert an `int` to a hexadecimal string manually, you can repeatedly divide the number by 16 and use an array of hex digits for conversion:

```java
public class IntToHexadecimalManual {
    public static void main(String[] args) {
        int number = 42;
        String hexString = intToHexadecimal(number);
        System.out.println("Hexadecimal representation of " + number + ": " + hexString);
    }

    public static String intToHexadecimal(int number) {
        if (number == 0) return "0";
        char[] hexDigits = "0123456789ABCDEF".toCharArray();
        StringBuilder hex = new StringBuilder();
        while (number > 0) {
            hex.insert(0, hexDigits[number % 16]);
            number /= 16;
        }
        return hex.toString();
    }
}
```

### **Summary of Manual Conversion Methods**

- **Binary**: Divide by 2, collect remainders.
- **Octal**: Divide by 8, collect remainders.
- **Hexadecimal**: Divide by 16, collect remainders, use hex digit mapping.

These methods construct the desired representation by building the result from the least significant to the most significant digit. They manually handle the conversion process and can be adapted to include additional features, such as leading zeros or specific formatting if needed.

Certainly! Here are a few additional types of conversions and formatting you might find useful, extending beyond simple numerical bases:

### 1. **Conversion Between Primitive Types**

#### **`double` to `int`**

```java
public class DoubleToInt {
    public static void main(String[] args) {
        double doubleValue = 45.67;
        int intValue = (int) doubleValue; // Truncates the decimal part
        System.out.println("Double to int: " + intValue);
    }
}
```

#### **`int` to `float`**

```java
public class IntToFloat {
    public static void main(String[] args) {
        int intValue = 42;
        float floatValue = (float) intValue; // Simple casting
        System.out.println("Int to float: " + floatValue);
    }
}
```

### 2. **String to Date/Time**

Using `java.time` classes to convert `String` to `LocalDate` or `LocalDateTime`:

#### **String to LocalDate**

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDate {
    public static void main(String[] args) {
        String dateString = "2024-09-17";
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("String to LocalDate: " + date);
    }
}
```

#### **String to LocalDateTime**

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTime {
    public static void main(String[] args) {
        String dateTimeString = "2024-09-17T10:15:30";
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("String to LocalDateTime: " + dateTime);
    }
}
```

### 3. **Date/Time to String**

Converting `LocalDate` or `LocalDateTime` to a formatted `String`:

#### **LocalDate to String**

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateToString {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("LocalDate to String: " + formattedDate);
    }
}
```

#### **LocalDateTime to String**

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToString {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("LocalDateTime to String: " + formattedDateTime);
    }
}
```

### 4. **Object to JSON**

Using libraries like Jackson to convert an object to JSON:

#### **Object to JSON**

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {
    public static void main(String[] args) throws Exception {
        Person person = new Person("John", 30);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(person);
        System.out.println("Object to JSON: " + jsonString);
    }

    static class Person {
        private String name;
        private int age;

        // Constructors, getters, setters
        public Person() {}
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }
}
```

### 5. **JSON to Object**

Using libraries like Jackson to convert JSON to an object:

#### **JSON to Object**

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObject {
    public static void main(String[] args) throws Exception {
        String jsonString = "{\"name\":\"John\",\"age\":30}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(jsonString, Person.class);
        System.out.println("JSON to Object: " + person.getName() + ", " + person.getAge());
    }

    static class Person {
        private String name;
        private int age;

        // Constructors, getters, setters
        public Person() {}
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }
}
```

### 6. **Conversion Between Byte Arrays and Strings**

#### **String to Byte Array**

```java
public class StringToByteArray {
    public static void main(String[] args) {
        String text = "Hello, World!";
        byte[] byteArray = text.getBytes();
        System.out.println("String to Byte Array: " + java.util.Arrays.toString(byteArray));
    }
}
```

#### **Byte Array to String**

```java
public class ByteArrayToString {
    public static void main(String[] args) {
        byte[] byteArray = {72, 101, 108, 108, 111};
        String text = new String(byteArray);
        System.out.println("Byte Array to String: " + text);
    }
}
```

### 7. **Base64 Encoding and Decoding**

#### **String to Base64**

```java
import java.util.Base64;

public class StringToBase64 {
    public static void main(String[] args) {
        String text = "Hello, World!";
        String base64Encoded = Base64.getEncoder().encodeToString(text.getBytes());
        System.out.println("String to Base64: " + base64Encoded);
    }
}
```

#### **Base64 to String**

```java
import java.util.Base64;

public class Base64ToString {
    public static void main(String[] args) {
        String base64Encoded = "SGVsbG8sIFdvcmxkIQ==";
        byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
        String text = new String(decodedBytes);
        System.out.println("Base64 to String: " + text);
    }
}
```

### Summary

These examples cover various types of conversions and formatting options:

- **Primitive Types**: `double` to `int`, `int` to `float`
- **Date/Time**: `String` to `LocalDate`, `LocalDate` to `String`, etc.
- **Object to/from JSON**: Using Jackson library
- **Byte Arrays**: `String` to byte array and vice versa
- **Base64 Encoding/Decoding**: For encoding and decoding Base64 strings

These conversions can help with many data processing and formatting tasks in Java.

Certainly! Apart from binary, octal, and hexadecimal, there are other numeral systems and formats you might find useful. Here are a few additional formats and conversions you can perform manually:

### 1. **Custom Base Conversion**

If you need to convert an `int` to a number in a custom base (e.g., base 5 or base 12), you can adapt the basic method used for binary, octal, and hexadecimal conversions:

#### Custom Base Conversion Method

```java
public class IntToCustomBase {
    public static void main(String[] args) {
        int number = 123;
        int base = 7; // For example, base 7
        
        String customBaseString = intToCustomBase(number, base);
        System.out.println("Number " + number + " in base " + base + ": " + customBaseString);
    }

    public static String intToCustomBase(int number, int base) {
        if (number == 0) return "0";
        
        // Characters to represent values beyond 9
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder result = new StringBuilder();
        
        while (number > 0) {
            result.insert(0, digits[number % base]);
            number /= base;
        }
        
        return result.toString();
    }
}
```

### 2. **Roman Numerals**

Converting an `int` to Roman numerals can be done using a predefined mapping of integer values to Roman numeral symbols:

```java
public class IntToRoman {
    public static void main(String[] args) {
        int number = 1994;
        String romanNumeral = intToRoman(number);
        System.out.println("Roman numeral of " + number + ": " + romanNumeral);
    }

    public static String intToRoman(int number) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        String roman = thousands[number / 1000] +
                       hundreds[(number % 1000) / 100] +
                       tens[(number % 100) / 10] +
                       ones[number % 10];
        
        return roman;
    }
}
```

### 3. **Scientific Notation**

Converting an `int` to scientific notation involves representing the number as a product of a coefficient and a power of 10:

```java
public class IntToScientificNotation {
    public static void main(String[] args) {
        int number = 123456;
        String scientificNotation = intToScientificNotation(number);
        System.out.println("Scientific notation of " + number + ": " + scientificNotation);
    }

    public static String intToScientificNotation(int number) {
        if (number == 0) return "0E0";
        
        int exponent = (int) Math.floor(Math.log10(number));
        double coefficient = number / Math.pow(10, exponent);
        
        return String.format("%.2fE%d", coefficient, exponent);
    }
}
```

### 4. **Percentages**

Converting an `int` to a percentage string is useful for displaying relative values:

```java
public class IntToPercentage {
    public static void main(String[] args) {
        int number = 45;
        String percentage = intToPercentage(number);
        System.out.println("Percentage representation of " + number + ": " + percentage);
    }

    public static String intToPercentage(int number) {
        return number + "%";
    }
}
```

### 5. **Time Format (HH:MM:SS)**

Converting an `int` representing seconds to a time format (hours, minutes, seconds):

```java
public class IntToTimeFormat {
    public static void main(String[] args) {
        int seconds = 3661; // Example value
        String timeFormat = intToTimeFormat(seconds);
        System.out.println("Time format of " + seconds + " seconds: " + timeFormat);
    }

    public static String intToTimeFormat(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
```

### Summary

These are just a few examples of how you can convert an `int` to various formats beyond the usual binary, octal, and hexadecimal representations. Each conversion requires its own approach and can be tailored to fit different needs and numeral systems.
### Add to in Array

```java
import java.util.Arrays;

public class JavaArrayToAddExample {

	public static void main(String[] args) {

		int[] values = new int[5];

		values[0] = 0;
		values[1] = 1;
		values[2] = 2;
		values[3] = 3;
		values[4] = 4;

		int[] newArray = new int[5 + 1];

		for (int i = 0; i < values.length; i++) {
			newArray[i] = values[i];
		}

		int newValue = 5;
		int newArraylength = newArray.length;
		newArray[newArraylength - 1] = newValue;
		
		System.out.println("Existing array values  " + Arrays.toString(values));
		System.out.println("New array values  " + Arrays.toString(newArray));

	}

}
```
Output:

```
Existing array values  [0, 1, 2, 3, 4]
New array values  [0, 1, 2, 3, 4, 5]

```
### Using ArrayList

```

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaArrayToAddInList {

	public static void main(String[] args) {

		Integer[] array = { 10, 20, 30, 40, 30, 40 };

		System.out.println("Initial array values " + Arrays.toString(array));

		List<Integer> integers = new ArrayList<>();

		for (int a : array) {
			integers.add(a);
		}

		int newValue = 50;

		integers.add(newValue);

		array = integers.toArray(array);

		System.out.println("Array after adding 50 value " + Arrays.toString(array));

	}
}
```

Output:

```
Initial array values [10, 20, 30, 40, 30, 40]
Array after adding 50 value [10, 20, 30, 40, 30, 40, 50] //list allows duplicate but element stored in insertion order

```

```java

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JavaArrayToAddInSet {

	public static void main(String[] args) {

		Integer[] array = { 10, 20, 30, 40, 30, 40 };

		System.out.println("Initial array values " + Arrays.toString(array));

		Set<Integer> integers = new HashSet<>();

		for (int a : array) {
			integers.add(a);
		}
		System.out.println("After adding in set values " + integers);

		int newValue = 50;

		integers.add(newValue);

		array = integers.toArray(array);

		System.out.println("Array after adding 50 value " + Arrays.toString(array));

	}
}
```
Output:

```
Initial array values [10, 20, 30, 40, 30, 40]
After adding in set values [20, 40, 10, 30] //set removed duplicate but no guarantee of order
Array after adding 50 value [50, 20, 40, 10, 30, null]

```

In Java, the behavior you’re seeing with the `HashSet` not maintaining the order of elements is expected and intentional. Here’s a detailed explanation of why this happens:

### Why Order is Not Maintained

1. **HashSet Characteristics**:
   - **No Order Guarantee**: A `HashSet` is a collection that does not guarantee any specific order of its elements. It uses a hash table for storage, which means that elements are placed into the set based on their hash codes.
   - **Hash-Based Storage**: When you add elements to a `HashSet`, they are stored in a way that optimizes lookup time rather than maintaining the order they were added in. The internal structure of the `HashSet` is a hash table, which does not preserve insertion order.

2. **Hash Function**:
   - The position of an element in the `HashSet` is determined by its hash code, which is derived from the element's `hashCode()` method. The ordering of elements in the set is based on these hash codes and not on the order of insertion.

### Example Explanation

Here’s your code for reference:
```java
Integer[] array = { 10, 20, 30, 40, 30, 40 };

System.out.println("Initial array values " + Arrays.toString(array));

Set<Integer> integers = new HashSet<>();

for (int a : array) {
    integers.add(a);
}
System.out.println("After adding in set values " + integers);
```

**Output**:
```
Initial array values [10, 20, 30, 40, 30, 40]
After adding in set values [20, 40, 10, 30]
```

- **Initial Array Values**: The original array has duplicate values and a specific insertion order.
- **Set Values**: When you add these values to a `HashSet`, the duplicates are removed (since `HashSet` does not allow duplicates), but the order in which the remaining unique elements are printed is not guaranteed.

### Alternative Collections for Order Preservation

If you need to maintain the order of insertion or any specific ordering, consider using the following alternatives:

1. **LinkedHashSet**:
   - **Maintains Insertion Order**: A `LinkedHashSet` maintains the order of elements as they are inserted. It uses a linked list internally to preserve the order.
   - **Usage Example**:
     ```java
     Set<Integer> integers = new LinkedHashSet<>(Arrays.asList(array));
     System.out.println("After adding in LinkedHashSet values " + integers);
     ```
   - This will preserve the order `[10, 20, 30, 40]`.

2. **TreeSet**:
   - **Sorted Order**: If you want the elements to be sorted according to their natural order (or a custom comparator), use a `TreeSet`.
   - **Usage Example**:
     ```java
     Set<Integer> integers = new TreeSet<>(Arrays.asList(array));
     System.out.println("After adding in TreeSet values " + integers);
     ```
   - This will sort the elements and output `[10, 20, 30, 40]`.

### Summary

- **`HashSet`** does not maintain any specific order of elements and uses a hash table for fast access.
- **`LinkedHashSet`** maintains the order of insertion.
- **`TreeSet`** sorts elements based on their natural order or a specified comparator.

Choose the appropriate set implementation based on whether you need order preservation or sorted order.


```java

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MergeAndRemoveDuplicates {
    public static void main(String[] args) {
        // Define the input arrays
        int[] arr1 = {3, 2, 1, 4, 5, 6, 8, 7, 6, 9};
        int[] arr2 = {8, 9, 10, 11, 12, 13, 15, 14, 15, 14, 16, 17};
        
        // Merge arrays
        int[] mergedArray = mergeArrays(arr1, arr2);
        
        // Remove duplicates
        int[] uniqueArray = removeDuplicates(mergedArray);
        
        // Print the result
        System.out.println("Merged and unique array: " + Arrays.toString(uniqueArray));
        
     // Merge arrays and remove duplicates using streams
        int[] uniqueArray1 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                                  .distinct()
                                  .sorted()
                                  .toArray();
        
        // Print the result
        System.out.println("Merged and unique array1: " + Arrays.toString(uniqueArray1));
    }

    // Method to merge two arrays
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // Create a new array with length equal to the sum of the two arrays
        int[] mergedArray = new int[arr1.length + arr2.length];
        
        // Copy the first array into the merged array
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        
        // Copy the second array into the merged array
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        
        return mergedArray;
    }

    // Method to remove duplicates from an array
    public static int[] removeDuplicates(int[] array) {
        // Create a Set to hold unique elements
        Set<Integer> set = new HashSet<>();
        
        // Add each element of the array to the Set
        for (int value : array) {
            set.add(value);
        }
        
        // Convert the Set back to an array
        int[] uniqueArray = new int[set.size()];
        int index = 0;
        for (int value : set) {
            uniqueArray[index++] = value;
        }
        
        return uniqueArray;
    }
}
```

### Boolean array

```java
public class BooleanArrayExample {

	public static void main(String[] args) {
		
		boolean[] array1 = {};

		boolean[] array2 = { false, true, true };

		boolean[] array3 = new boolean[5];

		System.out.println("array1 value - " + Arrays.toString(array1));
		System.out.println("array2 value - " + Arrays.toString(array2));
		System.out.println("array3 value - " + Arrays.toString(array3));
	}
}

```
Output:

```
array1 value - []
array2 value - [false, true, true]
array3 value - [false, false, false, false, false]//All intial values are false
```

```java

import java.util.Arrays;

public class BooleanArrayExample2 {

	public static void main(String[] args) {

		// way 1
		boolean[] array1 = { false, true, true };

		// way 2
		boolean[] array2 = new boolean[4];

		array2[0] = true;
		array2[1] = false;
		array2[2] = true;
		array2[3] = false;

		// way 3
		boolean[] array3 = new boolean[5];

		for (int i = 0; i < array3.length; i++) {
			array3[i] = i % 2 == 0;
		}

		System.out.println("array1 value - " + Arrays.toString(array1));
		System.out.println("array2 value - " + Arrays.toString(array2));
		System.out.println("array3 value - " + Arrays.toString(array3));

		System.out.println("array1[0] value - " + array1[0]);
		System.out.println("array2[1] value - " + array2[1]);
		System.out.println("array3 last index value - " + array3[array3.length - 1]);
		
		System.out.println("\nboolean array 3 all values using foreach ");
		for(boolean b : array3) {
			System.out.println(b);
		}

		boolean[] array4 = new boolean[4];

		System.out.println("Checking the default values of boolean array 4 with for each loop");
		for (boolean b : array4) {
			System.out.println(b);
		}

		boolean[] array5 = new boolean[5];

		System.out.println("Default value of array5 at index 1 is - " + array5[1]);

		System.out.println("Setting to true for all indexes of array 5 using simple for loop");
		for (int i = 0; i < array5.length; i++) {
			array5[i] = true;
		}
		System.out.println("Now Default value of array5 at index 1 is - " + array5[1]);

		boolean[] array6 = new boolean[5];

		System.out.println("Default values of array5 are " + Arrays.toString(array6));

		Arrays.fill(array6, true);

		System.out.println("New Default values of array5 are " + Arrays.toString(array6));
	}
}
```
Output:
```
array1 value - [false, true, true]
array2 value - [true, false, true, false]
array3 value - [true, false, true, false, true]

array1[0] value - false
array2[1] value - false
array3 last index value - true

boolean array 3 all values using foreach 
true
false
true
false
true

Checking the default values of boolean array 4 with for each loop
false
false
false
false

Default values of array5 are [false, false, false, false, false]
New Default values of array5 are [true, true, true, true, true]
```

```java

import java.util.Arrays;

public class BooleanArrayExample3 {

	public static void main(String[] args) {

		boolean[] array1 = {};
		System.out.println("array1 length - " + array1.length);

		boolean[] array2 = new boolean[2];
		System.out.println("array2 values - " + Arrays.toString(array2));

		for (int i = 0; i < array2.length; i++) {
			array2[i] = true;
		}

		System.out.println("New array2 values - " + Arrays.toString(array2));

		System.out.println("Acccessing array values by index - " + array2[1]);

		boolean[] array7 = new boolean[5];

		System.out.println("Default values of array7 are " + Arrays.toString(array7));

		Arrays.fill(array7, true);

		System.out.println("New Default values of array7 are " + Arrays.toString(array7));
	}
}
```
Output:

```
array1 length - 0
array2 values - [false, false]
New array2 values - [true, true]
Acccessing array values by index - true
Default values of array7 are [false, false, false, false, false]
New Default values of array7 are [true, true, true, true, true]
```

### Array Sort

```java

package com.javaprogramto.models;

public class Employee {

    private int id;
    private String fullName;
    private int age;

    public Employee(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
```
```java
package com.javaprogramto.arrays.comparator;

import java.util.Arrays;

import com.Employee;

public class ArraysSortComparatorExample {

	public static void main(String[] args) {

		Employee[] empArray = new Employee[5];

		empArray[0] = new Employee(100, "Malik Mona", 30);
		empArray[1] = new Employee(105, "A Z", 35);
		empArray[2] = new Employee(102, "B Z", 33);
		empArray[3] = new Employee(103, "C Z", 31);
		empArray[4] = new Employee(104, "D Z", 34);

		System.out.println("emp array before sort - ");
		Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

		Arrays.sort(empArray);

		System.out.println("emp array after sort - ");
		Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

	}

}
```
Output:

```
emp array before sort - 
Employee{id=100, fullName='Malik Mona', age=30}
Employee{id=105, fullName='A Z', age=35}
Employee{id=102, fullName='B Z', age=33}
Employee{id=103, fullName='C Z', age=31}
Employee{id=104, fullName='D Z', age=34}
Exception in thread "main" java.lang.ClassCastException: class com.javaprogramto.models.Employee cannot be cast to class java.lang.Comparable (com.javaprogramto.models.Employee is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	at java.base/java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
	at java.base/java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
	at java.base/java.util.Arrays.sort(Arrays.java:1041)
	at com.javaprogramto.arrays.comparator.ArraysSortComparatorExample.main(ArraysSortComparatorExample.java:22)

```
//Implementing Comparable: The Employee class must implement Comparable<Employee>, and you override the compareTo method to provide the logic for comparing Employee objects. In this example, the natural ordering is based on the age field.
//
//Using Comparator: Instead of modifying the Employee class, you can define a Comparator to sort Employee objects based on specific fields. In the example provided, we used Comparator.comparingInt to sort by the age field.
```
The `ClassCastException` you're encountering occurs because the `Employee` class does not implement the `Comparable` interface, and you’re trying to use a sorting method that requires the objects to be comparable. Here's a detailed explanation of why this happens and how to resolve it:

### Understanding the Error

The `ClassCastException` indicates that the sorting method you’re using expects objects to be comparable, but your `Employee` class does not implement `Comparable`.

- **`java.lang.Comparable`**: This interface is used to define a natural ordering for objects of a class. If a class implements `Comparable`, it must override the `compareTo` method to provide a way to compare instances of the class.
- **`Arrays.sort()`**: When you use `Arrays.sort()` without providing a comparator, it relies on the objects being `Comparable`. Since `Employee` does not implement `Comparable`, this method cannot determine how to sort the `Employee` objects.

### Solution

There are two main ways to resolve this issue:

1. **Implement the `Comparable` Interface in `Employee` Class**:
   Implement the `Comparable<Employee>` interface in your `Employee` class and override the `compareTo` method to define the natural ordering of `Employee` objects.

   ```java
   public class Employee implements Comparable<Employee> {
       private int id;
       private String fullName;
       private int age;

       // Constructor, getters, setters

       @Override
       public int compareTo(Employee other) {
           // Define the natural ordering; for example, by age
           return Integer.compare(this.age, other.age);
       }

       @Override
       public String toString() {
           return "Employee{id=" + id + ", fullName='" + fullName + "', age=" + age + "}";
       }
   }
   ```

   Then you can sort the array of `Employee` objects using `Arrays.sort()` without a custom comparator:

   ```java
   Employee[] empArray = {
       new Employee(100, "Malik Mona", 30),
       new Employee(105, "A Z", 35),
       new Employee(102, "B Z", 33),
       new Employee(103, "C Z", 31),
       new Employee(104, "D Z", 34)
   };

   System.out.println("Before sort: " + Arrays.toString(empArray));

   Arrays.sort(empArray);

   System.out.println("After sort: " + Arrays.toString(empArray));
   ```

2. **Provide a Comparator**:
   If you do not want to modify the `Employee` class or need custom sorting that doesn't fit into the natural ordering, you can use a `Comparator` instead. This is useful for one-off sorts or different sorting criteria.

   ```java
   Employee[] empArray = {
       new Employee(100, "Malik Mona", 30),
       new Employee(105, "A Z", 35),
       new Employee(102, "B Z", 33),
       new Employee(103, "C Z", 31),
       new Employee(104, "D Z", 34)
   };

   System.out.println("Before sort: " + Arrays.toString(empArray));

   Arrays.sort(empArray, Comparator.comparingInt(Employee::getAge));

   System.out.println("After sort: " + Arrays.toString(empArray));
   ```

   In this example, `Comparator.comparingInt(Employee::getAge)` creates a comparator that sorts employees by age.

### Summary

- **Implementing `Comparable`**: Modify the `Employee` class to implement `Comparable<Employee>` if you want a natural ordering for sorting.
- **Using `Comparator`**: Use `Comparator` if you need custom sorting criteria without modifying the `Employee` class.

Both approaches are valid, and the choice depends on whether you want to define a natural order for `Employee` objects or need specific sorting logic.

```java

public class Employee implements Comparable<Employee> {
    private int id;
    private String fullName;
    private int age;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	

    public Employee(int id, String fullName, int age) {
	this.id = id;
	this.fullName = fullName;
	this.age = age;
    }

    @Override
    public String toString() {
	return "Employee{id=" + id + ", fullName='" + fullName + "', age=" + age + "}";
    }

    @Override
    public int compareTo(Employee1 other) {
	// Define the natural ordering based on age
	return Integer.compare(this.age, other.age);
    }

    // Getters and setters (if needed)
}
```
```java

import java.util.Arrays;
import java.util.Comparator;//Using Comparator

public class ArraysSortComparatorExample {

    public static void main(String[] args) {
        Employee1[] empArray = new Employee1[5];

        empArray[0] = new Employee(100, "Malik Mona", 30);
        empArray[1] = new Employee(105, "A Z", 35);
        empArray[2] = new Employee(102, "B Z", 33);
        empArray[3] = new Employee(103, "C Z", 31);
        empArray[4] = new Employee(104, "D Z", 34);

        System.out.println("emp array before sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

        Arrays.sort(empArray);

        System.out.println("emp array after sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));
        
        System.out.println("emp array before sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));

        // Sort by age using Comparator -1
        Arrays.sort(empArray, Comparator.comparingInt(emp -> emp.getAge()));
        
        // Sort by age using Comparator and getter method -2
        // Arrays.sort(empArray, Comparator.comparingInt(Employee::getAge));

        System.out.println("emp array after sort - ");
        Arrays.stream(empArray).forEach(emp -> System.out.println(emp));
    }
}
```
Output:
```
emp array before sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=105, fullName='A Z', age=35}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=104, fullName='D Z', age=34}
emp array after sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=104, fullName='D Z', age=34}
Employee1{id=105, fullName='A Z', age=35}
emp array before sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=104, fullName='D Z', age=34}
Employee1{id=105, fullName='A Z', age=35}
emp array after sort - 
Employee1{id=100, fullName='Malik Mona', age=30}
Employee1{id=103, fullName='C Z', age=31}
Employee1{id=102, fullName='B Z', age=33}
Employee1{id=104, fullName='D Z', age=34}
Employee1{id=105, fullName='A Z', age=35}
```

```java

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraySortReverse {

	public static void main(String[] args) {

		// Array Integers

		Integer[] ints = new Integer[5];
		ints[0] = 20;
		ints[1] = 50;
		ints[2] = 40;
		ints[3] = 10;
		ints[4] = 30;

		System.out.println("Integer array before sort - " + Arrays.toString(ints));
		
		Arrays.sort(ints, Collections.reverseOrder());

		System.out.println("Integer array after sort - " + Arrays.toString(ints));

               // Array Int Primitive

		int[] ints1 = new int[5];
		ints1[0] = 20;
		ints1[1] = 50;
		ints1[2] = 40;
		ints1[3] = 10;
		ints1[4] = 30;
		
		List<Integer> stream= IntStream.of(ints1).boxed()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		System.out.println("Integer array after sort - " + stream.toString());
		Stream<Integer> stream1= IntStream.of(ints1).boxed()
				.distinct()
				.sorted(Comparator.reverseOrder());
		
		stream1.forEach(e->System.out.println(e));

		//String Array

		String[] stringArray = new String[5];
		stringArray[0] = "G";
		stringArray[1] = "Z";
		stringArray[2] = "A";
		stringArray[3] = "N";
		stringArray[4] = "I";

		System.out.println("String array before sort - " + Arrays.toString(stringArray));
		Arrays.sort(stringArray, Collections.reverseOrder());

		System.out.println("String array after sort - " + Arrays.toString(stringArray));
		
		String[] stringArray1 = {"G","Z","A","N","I"};
		
		System.out.println("String array before sort - " + Arrays.toString(stringArray1));
		Arrays.sort(stringArray1, Collections.reverseOrder());

		System.out.println("String array after sort - " + Arrays.toString(stringArray1));

		//Array Of Custom Object
		Employee[] empArray = new Employee[5];
		empArray[0] = new Employee(500, "A", "2000");
		empArray[1] = new Employee(300, "B", "2001");
		empArray[2] = new Employee(200, "C", "2002");
		empArray[3] = new Employee(400, "D", "2003");
		empArray[4] = new Employee(100, "E", "2004");

		System.out.println("Employee array before sort ");
		for (Employee e : empArray) {
			System.out.println(e);
		}
		Arrays.sort(empArray, Collections.reverseOrder());

		System.out.println("\n" + "Employee array after sort");
		for (Employee e : empArray) {
			System.out.println(e);
		}
	}
}

class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String dateOfJoin;

	public Employee(int id, String name, String dateOfJoin) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfJoin = dateOfJoin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfJoin=" + dateOfJoin + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.getId()).compareTo(o.getId());
	}

}
```
