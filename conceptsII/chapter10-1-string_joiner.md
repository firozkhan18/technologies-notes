# Java StringJoiner

Java String class
Java String
Learn to use StringJoiner class (introduced in Java 8) to join strings in different ways. We can use it to join strings with a delimiter, and use prefix and/or suffix characters around the final string.

### 1. Creating StringJoiner
We can create an instance of StringJoiner in two ways. The first constructor takes only the delimiter, and the second constructor takes the additional prefix and suffix strings.
>
    String DELIMITER = ",";
    String PREFIX = "[";
    String SUFFIX = "]";

    StringJoiner stringJoinerWithDelimiter = new StringJoiner(DELIMITER);
    StringJoiner stringJoinerWithPrefixSuffix = new StringJoiner(DELIMITER, PREFIX, SUFFIX);

We cannot pass NULL arguments, they will result in NullPointerException.
>
Assertions.assertThrows(NullPointerException.class, () -> {
  new StringJoiner(null);
});

### 2. Default Values
By default, if we do not add any string to the joiner, it returns a default empty string. The empty string depends on the constructor used to create the StringJoiner instance.

If only the delimiter is used, the default value is an empty string.
If prefix and suffix have been used, the default value is a string joined by prefix + suffix.
>  
Assertions.assertEquals("", stringJoinerWithDelimiter.toString());
Assertions.assertEquals("[]", stringJoinerWithPrefixSuffix.toString());

We can change the default string using the setEmptyValue() method.

stringJoinerWithDelimiter.setEmptyValue("BLANK");

Assertions.assertEquals("BLANK", stringJoinerWithDelimiter.toString());

The default prefix and suffix values are empty strings.

### 3. Adding Strings
We can use the StringJoiner.add() method to add strings that need to be joined.

stringJoinerWithDelimiter.add("alex");
stringJoinerWithDelimiter.add("brian");
stringJoinerWithDelimiter.add("charles");

Assertions.assertEquals("alex,brian,charles", stringJoinerWithDelimiter.toString());

If the prefix and suffix have been used, then the final string will contain them appended.

stringJoinerWithPrefixSuffix.add("alex");
stringJoinerWithPrefixSuffix.add("brian");
stringJoinerWithPrefixSuffix.add("charles");

Assertions.assertEquals("[alex,brian,charles]", stringJoinerWithPrefixSuffix.toString());

### 4. Merging StringJoiner Instances
It is possible that two parts of the application joined the strings, and now those need to be combined. Use StringJoiner.merge() method to merge two instances of StringJoiner to produce a single result.

When we merge two joiners using joiner1.merge(joiner2) –

The content of joiner2 is appended to joiner1.
Prefix and suffix are used for the joiner1.
Both joiners persist their delimiters.
Let us understand the merging process with an example. In the following Java program, we are creating two StringJoiner objects with different delimiters, prefixes and suffixes. The merged StringJoiner has prefix and suffix from the first joiner and delimiters from both joiners.

StringJoiner joiner1 = new StringJoiner(",", "[", "]");
StringJoiner joiner2 = new StringJoiner("-", "{", "}");

joiner1.add("a");
joiner1.add("b");

joiner2.add("1");
joiner2.add("2");

StringJoiner finalJoiner = joiner1.merge(joiner2);

Assertions.assertEquals("[a,b,1-2]", finalJoiner.toString());

### 5. StringJoiner in Collectors.joining()
The Collectors.joining() API is part of Java 8 Streams. It joins a stream of strings (or stream of primitives with their string value). The Collectors.joining() internally uses the StringJoiner class.

String result = Stream.of("a", "b", "c").collect(Collectors.joining(",", "[", "]"));

Assertions.assertEquals("[a,b,c]", result);

### 6. Difference between StringJoiner and StringBuilder
Using StringBuilder, we will append each string and delimiter in an alternate sequence.

StringBuilder builder = new StringBuilder();
String result = builder.append("a").append(",").append("b").append(",").append("c").toString();

Using StringJoiner with delimiter in the constructor, we only need to focus on strings to add. Delimiter will be added automatically.

stringJoinerWithDelimiter.add("a").add("b").add("c");

Overall, StringJoiner makes joining strings easy, as compared to StringBuilder.

### 7. Conclusion

In this Java 8 StringJoiner, we learned to create StringJoiner using constructors and merge it with another StringJoiner instance. We learned to join strings using the delimiters only, and with prefix and suffix strings. We also saw how the StringJoiner has been used in Stream API with Collectors.joining() method.

Overall, StringJoiner is much like StringBuilder and StringBuffer classes but with a more robust API for adding delimited strings, but it is unsuitable for other formatting tasks.
