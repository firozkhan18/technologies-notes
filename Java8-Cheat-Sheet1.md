Sure! Here's a detailed table outlining the key methods for `IntStream`, `LongStream`, `DoubleStream`, `IntSummaryStatistics`, `LongSummaryStatistics`, and `DoubleSummaryStatistics`, along with examples for each:

| **Class**                  | **Method**                     | **Description**                                                                                       | **Example**                                                                                                                                              |
|----------------------------|--------------------------------|-------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| **IntStream**              | `of(int... values)`            | Creates an `IntStream` from a sequence of `int` values.                                               | `IntStream.of(1, 2, 3).forEach(System.out::println);`                                                                                                      |
|                            | `range(int startInclusive, int endExclusive)` | Creates an `IntStream` with a range of values from `startInclusive` to `endExclusive - 1`.           | `IntStream.range(1, 4).forEach(System.out::println); // prints 1, 2, 3`                                                                                 |
|                            | `rangeClosed(int startInclusive, int endInclusive)` | Creates an `IntStream` with a range of values from `startInclusive` to `endInclusive`.                | `IntStream.rangeClosed(1, 4).forEach(System.out::println); // prints 1, 2, 3, 4`                                                                       |
|                            | `mapToDouble(IntToDoubleFunction mapper)` | Converts each `int` value to a `double` and returns a `DoubleStream`.                                | `IntStream.of(1, 2, 3).mapToDouble(i -> i * 0.5).forEach(System.out::println); // prints 0.5, 1.0, 1.5`                                              |
|                            | `mapToLong(IntToLongFunction mapper)` | Converts each `int` value to a `long` and returns a `LongStream`.                                    | `IntStream.of(1, 2, 3).mapToLong(i -> i * 10).forEach(System.out::println); // prints 10, 20, 30`                                                     |
|                            | `average()`                     | Returns an `OptionalDouble` describing the average value of elements.                               | `IntStream.of(1, 2, 3, 4, 5).average().ifPresent(System.out::println); // prints 3.0`                                                                   |
|                            | `count()`                       | Returns the count of elements in the stream.                                                         | `IntStream.of(1, 2, 3).count(); // returns 3`                                                                                                           |
|                            | `max()`                         | Returns an `OptionalInt` describing the maximum value of elements.                                   | `IntStream.of(1, 2, 3).max().ifPresent(System.out::println); // prints 3`                                                                             |
|                            | `min()`                         | Returns an `OptionalInt` describing the minimum value of elements.                                   | `IntStream.of(1, 2, 3).min().ifPresent(System.out::println); // prints 1`                                                                             |
|                            | `sum()`                         | Returns the sum of elements.                                                                         | `IntStream.of(1, 2, 3).sum(); // returns 6`                                                                                                               |
|                            | `reduce(int identity, IntBinaryOperator op)` | Performs a reduction on the elements using an associative accumulation function.                    | `IntStream.of(1, 2, 3).reduce(0, (a, b) -> a + b); // returns 6`                                                                                      |
| **LongStream**             | `of(long... values)`           | Creates a `LongStream` from a sequence of `long` values.                                               | `LongStream.of(1L, 2L, 3L).forEach(System.out::println);`                                                                                                 |
|                            | `range(long startInclusive, long endExclusive)` | Creates a `LongStream` with a range of values from `startInclusive` to `endExclusive - 1`.            | `LongStream.range(1L, 4L).forEach(System.out::println); // prints 1, 2, 3`                                                                              |
|                            | `rangeClosed(long startInclusive, long endInclusive)` | Creates a `LongStream` with a range of values from `startInclusive` to `endInclusive`.                | `LongStream.rangeClosed(1L, 4L).forEach(System.out::println); // prints 1, 2, 3, 4`                                                                    |
|                            | `mapToDouble(LongToDoubleFunction mapper)` | Converts each `long` value to a `double` and returns a `DoubleStream`.                               | `LongStream.of(1L, 2L, 3L).mapToDouble(l -> l * 0.5).forEach(System.out::println); // prints 0.5, 1.0, 1.5`                                           |
|                            | `mapToInt(LongToIntFunction mapper)` | Converts each `long` value to an `int` and returns an `IntStream`.                                    | `LongStream.of(1L, 2L, 3L).mapToInt(l -> (int) l * 10).forEach(System.out::println); // prints 10, 20, 30`                                              |
|                            | `average()`                     | Returns an `OptionalDouble` describing the average value of elements.                               | `LongStream.of(1L, 2L, 3L, 4L, 5L).average().ifPresent(System.out::println); // prints 3.0`                                                             |
|                            | `count()`                       | Returns the count of elements in the stream.                                                         | `LongStream.of(1L, 2L, 3L).count(); // returns 3`                                                                                                       |
|                            | `max()`                         | Returns an `OptionalLong` describing the maximum value of elements.                                  | `LongStream.of(1L, 2L, 3L).max().ifPresent(System.out::println); // prints 3`                                                                          |
|                            | `min()`                         | Returns an `OptionalLong` describing the minimum value of elements.                                  | `LongStream.of(1L, 2L, 3L).min().ifPresent(System.out::println); // prints 1`                                                                          |
|                            | `sum()`                         | Returns the sum of elements.                                                                         | `LongStream.of(1L, 2L, 3L).sum(); // returns 6`                                                                                                         |
|                            | `reduce(long identity, LongBinaryOperator op)` | Performs a reduction on the elements using an associative accumulation function.                    | `LongStream.of(1L, 2L, 3L).reduce(0L, (a, b) -> a + b); // returns 6`                                                                                  |
| **DoubleStream**           | `of(double... values)`         | Creates a `DoubleStream` from a sequence of `double` values.                                           | `DoubleStream.of(1.0, 2.0, 3.0).forEach(System.out::println);`                                                                                           |
|                            | `range(double startInclusive, double endExclusive)` | Creates a `DoubleStream` with a range of values from `startInclusive` to `endExclusive`.               | Not directly available; use `IntStream` or `LongStream` and map to `DoubleStream`.                                                                      |
|                            | `rangeClosed(double startInclusive, double endInclusive)` | Creates a `DoubleStream` with a range of values from `startInclusive` to `endInclusive`.               | Not directly available; use `IntStream` or `LongStream` and map to `DoubleStream`.                                                                      |
|                            | `mapToInt(DoubleToIntFunction mapper)` | Converts each `double` value to an `int` and returns an `IntStream`.                                  | `DoubleStream.of(1.0, 2.0, 3.0).mapToInt(d -> (int) d).forEach(System.out::println); // prints 1, 2, 3`                                                 |
|                            | `mapToLong(DoubleToLongFunction mapper)` | Converts each `double` value to a `long` and returns a `LongStream`.                                  | `DoubleStream.of(1.0, 2.0, 3.0).mapToLong(d -> (long) d).forEach(System.out::println); // prints 1, 2, 3`                                              |
|                            | `average()`                     | Returns an `OptionalDouble` describing the average value of elements.                               | `DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).average().ifPresent(System.out::println); // prints 3.0`                                                     |
|                            | `count()`                       | Returns the count of elements in the stream.                                                         | `DoubleStream.of(1.0, 2.0, 3.0).count(); // returns 3`                                                                                                 |
|                            | `max()`                         | Returns an `OptionalDouble` describing the maximum value of elements.                                | `DoubleStream.of(1.0, 2.0, 3.0).max().ifPresent(System.out::println); // prints 3.0`                                                                    |
|                            | `min()`                         | Returns an `OptionalDouble` describing the minimum value of elements.                                | `DoubleStream.of(1.0, 2.0, 3.0).min().ifPresent(System.out::println); // prints 1.0`                                                                    |
|                            | `sum()`                         | Returns the sum of elements.                                                                         | `DoubleStream.of(1.0, 2.0, 3.0).sum(); // returns 6.0`                                                                                                 |
|                            | `reduce(double identity, DoubleBinaryOperator op)` | Performs a reduction on the elements using an associative accumulation function.                    | `DoubleStream.of(1.0, 2.0, 3.0).reduce(0.0, (a, b) -> a + b); // returns 6.0`                                                                          |
| **IntSummaryStatistics**   | `accept(int value)`            | Accepts an `int` value for this statistics collector.                                                  | `IntSummaryStatistics stats = new IntSummaryStatistics(); stats.accept(1); stats.accept(2); stats.accept(3); System.out.println(stats); // prints stats`|
|                            | `combine(IntSummaryStatistics other)` | Combines the statistics from another `IntSummaryStatistics` instance.                                | `IntSummaryStatistics stats1 = new IntSummaryStatistics(); stats1.accept(1); stats1.accept(2); IntSummaryStatistics stats2 = new IntSummaryStatistics(); stats2.accept(3); stats1.combine(stats2); System.out.println(stats1); // prints stats` |
|                            | `count()`                       | Returns the count of elements.                                                                       | `IntSummaryStatistics stats = new IntSummaryStatistics(); stats.accept(1); stats.accept(2); System.out.println(stats.getCount()); // prints 2`             |
|                            | `sum()`                         | Returns the sum of elements.                                                                         | `IntSummaryStatistics stats = new IntSummaryStatistics(); stats.accept(1); stats.accept(2); System.out.println(stats.getSum()); // prints 3`                |
|                            | `min()`                         | Returns the minimum value.                                                                          | `IntSummaryStatistics stats = new IntSummaryStatistics(); stats.accept(1); stats.accept(2); System.out.println(stats.getMin()); // prints 1`                |
|                            | `max()`                         | Returns the maximum value.                                                                          | `IntSummaryStatistics stats = new IntSummaryStatistics(); stats.accept(1); stats.accept(2); System.out.println(stats.getMax()); // prints 2`                |
|                            | `average()`                     | Returns the average value.                                                                          | `IntSummaryStatistics stats = new IntSummaryStatistics(); stats.accept(1); stats.accept(2); System.out.println(stats.getAverage()); // prints 1.5`          |
| **LongSummaryStatistics**  | `accept(long value)`           | Accepts a `long` value for this statistics collector.                                                 | `LongSummaryStatistics stats = new LongSummaryStatistics(); stats.accept(1L); stats.accept(2L); stats.accept(3L); System.out.println(stats); // prints stats` |
|                            | `combine(LongSummaryStatistics other)` | Combines the statistics from another `LongSummaryStatistics` instance.                               | `LongSummaryStatistics stats1 = new LongSummaryStatistics(); stats1.accept(1L); stats1.accept(2L); LongSummaryStatistics stats2 = new LongSummaryStatistics(); stats2.accept(3L); stats1.combine(stats2); System.out.println(stats1); // prints stats` |
|                            | `count()`                       | Returns the count of elements.                                                                       | `LongSummaryStatistics stats = new LongSummaryStatistics(); stats.accept(1L); stats.accept(2L); System.out.println(stats.getCount()); // prints 2`          |
|                            | `sum()`                         | Returns the sum of elements.                                                                         | `LongSummaryStatistics stats = new LongSummaryStatistics(); stats.accept(1L); stats.accept(2L); System.out.println(stats.getSum()); // prints 3`           |
|                            | `min()`                         | Returns the minimum value.                                                                          | `LongSummaryStatistics stats = new LongSummaryStatistics(); stats.accept(1L); stats.accept(2L); System.out.println(stats.getMin()); // prints 1`           |
|                            | `max()`                         | Returns the maximum value.                                                                          | `LongSummaryStatistics stats = new LongSummaryStatistics(); stats.accept(1L); stats.accept(2L); System.out.println(stats.getMax()); // prints 2`           |
|                            | `average()`                     | Returns the average value.                                                                          | `LongSummaryStatistics stats = new LongSummaryStatistics(); stats.accept(1L); stats.accept(2L); System.out.println(stats.getAverage()); // prints 1.5`       |
| **DoubleSummaryStatistics**| `accept(double value)`         | Accepts a `double` value for this statistics collector.                                                | `DoubleSummaryStatistics stats = new DoubleSummaryStatistics(); stats.accept(1.0); stats.accept(2.0); stats.accept(3.0); System.out.println(stats); // prints stats`|
|                            | `combine(DoubleSummaryStatistics other)` | Combines the statistics from another `DoubleSummaryStatistics` instance.                              | `DoubleSummaryStatistics stats1 = new DoubleSummaryStatistics(); stats1.accept(1.0); stats1.accept(2.0); DoubleSummaryStatistics stats2 = new DoubleSummaryStatistics(); stats2.accept(3.0); stats1.combine(stats2); System.out.println(stats1); // prints stats` |
|                            | `count()`                       | Returns the count of elements.                                                                       | `DoubleSummaryStatistics stats = new DoubleSummaryStatistics(); stats.accept(1.0); stats.accept(2.0); System.out.println(stats.getCount()); // prints 2`       |
|                            | `sum()`                         | Returns the sum of elements.                                                                         | `DoubleSummaryStatistics stats = new DoubleSummaryStatistics(); stats.accept(1.0); stats.accept(2.0); System.out.println(stats.getSum()); // prints 3.0`      |
|                            | `min()`                         | Returns the minimum value.                                                                          | `DoubleSummaryStatistics stats = new DoubleSummaryStatistics(); stats.accept(1.0); stats.accept(2.0); System.out.println(stats.getMin()); // prints 1.0`      |
|                            | `max()`                         | Returns the maximum value.                                                                          | `DoubleSummaryStatistics stats = new DoubleSummaryStatistics(); stats.accept(1.0); stats.accept(2.0); System.out.println(stats.getMax()); // prints 2.0`      |
|                            | `average()`                     | Returns the average value.                                                                          | `DoubleSummaryStatistics stats = new DoubleSummaryStatistics(); stats.accept(1.0); stats.accept(2.0); System.out.println(stats.getAverage()); // prints 1.5`   |

This table provides a comprehensive overview of the methods available for each of these classes, including their purpose and examples of usage.

Certainly! Here’s a detailed table for the methods available in the `Stream` interface, including intermediate and terminal operations, as well as methods in the `Optional` class:

### **Stream Methods**

#### **Stream Interface**

| **Method**                  | **Description**                                                                                         | **Example**                                                                                                                                                     |
|-----------------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `of(T... values)`           | Creates a `Stream` from a sequence of values.                                                           | `Stream.of(1, 2, 3).forEach(System.out::println); // prints 1, 2, 3`                                                                                         |
| `empty()`                   | Returns an empty `Stream`.                                                                             | `Stream.<String>empty().forEach(System.out::println); // prints nothing`                                                                                     |
| `concat(Stream<? extends T> a, Stream<? extends T> b)` | Concatenates two streams.                                                                         | `Stream.concat(Stream.of(1, 2), Stream.of(3, 4)).forEach(System.out::println); // prints 1, 2, 3, 4`                                                        |
| `builder()`                 | Returns a `Stream.Builder` for creating a `Stream`.                                                     | `Stream.<Integer>builder().add(1).add(2).add(3).build().forEach(System.out::println); // prints 1, 2, 3`                                                      |
| `generate(Supplier<T> s)`   | Creates a `Stream` where each element is generated by the provided supplier.                           | `Stream.generate(() -> "Hello").limit(3).forEach(System.out::println); // prints "Hello" three times`                                                         |
| `iterate(T seed, UnaryOperator<T> f)` | Creates an infinite sequential `Stream` where each element is generated by applying the unary operator to the previous element. | `Stream.iterate(1, n -> n + 2).limit(5).forEach(System.out::println); // prints 1, 3, 5, 7, 9`                                                              |
| `range(int startInclusive, int endExclusive)` | Creates an `IntStream` with a range of values.                                                    | `IntStream.range(1, 4).forEach(System.out::println); // prints 1, 2, 3`                                                                                       |
| `rangeClosed(int startInclusive, int endInclusive)` | Creates an `IntStream` with a range of values, including both endpoints.                           | `IntStream.rangeClosed(1, 4).forEach(System.out::println); // prints 1, 2, 3, 4`                                                                             |
| `of(Object... values)`      | Creates a `Stream` from a sequence of values.                                                           | `Stream.of("a", "b", "c").forEach(System.out::println); // prints a, b, c`                                                                                   |

#### **Intermediate Operations**

| **Method**                  | **Description**                                                                                         | **Example**                                                                                                                                                     |
|-----------------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `filter(Predicate<? super T> predicate)` | Returns a `Stream` with elements that match the given predicate.                                      | `Stream.of(1, 2, 3, 4).filter(n -> n % 2 == 0).forEach(System.out::println); // prints 2, 4`                                                                |
| `map(Function<? super T, ? extends R> mapper)` | Returns a `Stream` with elements transformed by applying the given function.                           | `Stream.of(1, 2, 3).map(n -> n * n).forEach(System.out::println); // prints 1, 4, 9`                                                                         |
| `flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)` | Flattens the stream of streams into a single `Stream`.                                                 | `Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(Collection::stream).forEach(System.out::println); // prints 1, 2, 3, 4`                        |
| `distinct()`                | Returns a `Stream` with duplicate elements removed.                                                     | `Stream.of(1, 2, 2, 3).distinct().forEach(System.out::println); // prints 1, 2, 3`                                                                           |
| `sorted()`                  | Returns a sorted `Stream` based on natural ordering or a provided comparator.                          | `Stream.of(3, 1, 4, 2).sorted().forEach(System.out::println); // prints 1, 2, 3, 4`                                                                         |
| `peek(Consumer<? super T> action)` | Returns a `Stream` with each element passed through the provided action.                               | `Stream.of(1, 2, 3).peek(System.out::println).map(n -> n * n).forEach(System.out::println); // prints 1, 2, 3, 1, 4, 9`                                      |
| `limit(long maxSize)`       | Returns a `Stream` with elements truncated to the specified size.                                       | `Stream.of(1, 2, 3, 4, 5).limit(3).forEach(System.out::println); // prints 1, 2, 3`                                                                        |
| `skip(long n)`              | Returns a `Stream` with the first `n` elements skipped.                                                | `Stream.of(1, 2, 3, 4, 5).skip(3).forEach(System.out::println); // prints 4, 5`                                                                             |
| `takeWhile(Predicate<? super T> predicate)` | Returns a `Stream` consisting of elements taken while the predicate is true.                           | `Stream.of(1, 2, 3, 4, 5).takeWhile(n -> n < 4).forEach(System.out::println); // prints 1, 2, 3`                                                            |
| `dropWhile(Predicate<? super T> predicate)` | Returns a `Stream` with elements dropped until the predicate is false.                                | `Stream.of(1, 2, 3, 4, 5).dropWhile(n -> n < 4).forEach(System.out::println); // prints 4, 5`                                                               |
| `mapToInt(ToIntFunction<? super T> mapper)` | Converts each element to an `IntStream`.                                                                 | `Stream.of(1.1, 2.2, 3.3).mapToInt(d -> (int) d).forEach(System.out::println); // prints 1, 2, 3`                                                            |
| `mapToLong(ToLongFunction<? super T> mapper)` | Converts each element to a `LongStream`.                                                                 | `Stream.of(1.1, 2.2, 3.3).mapToLong(d -> (long) d).forEach(System.out::println); // prints 1, 2, 3`                                                          |
| `mapToDouble(ToDoubleFunction<? super T> mapper)` | Converts each element to a `DoubleStream`.                                                               | `Stream.of(1, 2, 3).mapToDouble(i -> i * 0.5).forEach(System.out::println); // prints 0.5, 1.0, 1.5`                                                        |
| `boxed()`                   | Converts an `IntStream`, `LongStream`, or `DoubleStream` to a `Stream` of the corresponding wrapper type. | `IntStream.of(1, 2, 3).boxed().forEach(System.out::println); // prints 1, 2, 3`                                                                            |

#### **Terminal Operations**

| **Method**                  | **Description**                                                                                         | **Example**                                                                                                                                                     |
|-----------------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `forEach(Consumer<? super T> action)` | Performs an action for each element of the `Stream`.                                                   | `Stream.of(1, 2, 3).forEach(System.out::println); // prints 1, 2, 3`                                                                                         |
| `toArray()`                 | Returns an array containing the elements of the `Stream`.                                               | `Stream.of(1, 2, 3).toArray(); // returns [1, 2, 3]`                                                                                                        |
| `reduce(T identity, BinaryOperator<T> accumulator)` | Performs a reduction on the elements using an associative accumulation function.                     | `Stream.of(1, 2, 3).reduce(0, Integer::sum); // returns 6`                                                                                                 |
| `collect(Collector<? super T, A, R> collector)` | Performs a mutable reduction operation on the elements using a `Collector`.                            | `Stream.of(1, 2, 3).collect(Collectors.toList()); // returns [1, 2, 3]`                                                                                   |
| `count()`                   | Returns the count of elements in the `Stream`.                                                           | `Stream.of(1, 2, 3).count(); // returns 3`                                                                                                                   |
| `min(Comparator<? super T> comparator)` | Returns the minimum element of the `Stream` according to the provided comparator.                      | `Stream.of(1, 2, 3).min(Integer::compareTo).ifPresent(System.out::println); // prints 1`                                                                   |
| `max(Comparator<? super T> comparator)` | Returns the maximum element of the `Stream` according to the provided comparator.                      | `Stream.of(1, 2, 3).max(Integer::compareTo).ifPresent(System.out::println); // prints 3`                                                                   |
| `findFirst()`               | Returns an `Optional` describing the first element of the `Stream`, or an empty `Optional` if the `Stream` is empty. | `Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println); // prints 1`                                                                             |
| `findAny()`                 | Returns an `Optional` describing any element of the `Stream`, or an empty `Optional` if the `Stream` is empty. | `Stream.of(1, 2, 3).findAny().ifPresent(System.out::println); // prints 1 (or any element)`                                                               |
| `allMatch(Predicate<? super T> predicate)` | Returns `true` if all elements of the `Stream` match the given predicate.                                | `Stream.of(1, 2, 3).allMatch(n -> n > 0); // returns true`                                                                                                  |
| `anyMatch(Predicate<? super T> predicate)` | Returns `true` if any element of the `Stream` matches the given predicate.                              | `Stream.of(1, 2, 3).anyMatch(n -> n > 2); // returns true`                                                                                                  |
| `noneMatch(Predicate<? super T> predicate)` | Returns `true` if no elements of the `Stream` match the given predicate.                               | `Stream.of(1, 2, 3).noneMatch(n -> n > 3); // returns true`                                                                                                 |
| `iterator()`                | Returns an `Iterator` over the elements of the `Stream`.                                                 | `Stream.of(1, 2, 3).iterator().forEachRemaining(System.out::println); // prints 1, 2, 3`                                                                   |

### **Optional Methods**

#### **Optional Class**

| **Method**                  | **Description**                                                                                         | **Example**                                                                                                                                                     |
|-----------------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `of(T value)`               | Returns an `Optional` with the specified non-null value.                                                | `Optional.of("Hello").ifPresent(System.out::println); // prints "Hello"`                                                                                       |
| `ofNullable(T value)`       | Returns an `Optional` describing the specified value, or an empty `Optional` if the value is `null`.   | `Optional.ofNullable(null).ifPresent(System.out::println); // prints nothing`                                                                                |
| `empty()`                   | Returns an empty `Optional`.                                                                           | `Optional.empty().ifPresent(System.out::println); // prints nothing`                                                                                          |
| `get()`                     | Returns the value if present, otherwise throws `NoSuchElementException`.                               | `Optional.of("Hello").get(); // returns "Hello"`                                                                                                                |
| `isPresent()`               | Returns `true` if there is a value present, otherwise `false`.                                          | `Optional.of("Hello").isPresent(); // returns true`                                                                                                           |
| `ifPresent(Consumer<? super T> action)` | Executes the given action if a value is present.                                                      | `Optional.of("Hello").ifPresent(System.out::println); // prints "Hello"`                                                                                       |
| `orElse(T other)`           | Returns the value if present, otherwise returns the specified other value.                             | `Optional.ofNullable(null).orElse("Default"); // returns "Default"`                                                                                           |
| `orElseGet(Supplier<? extends T> other)` | Returns the value if present, otherwise returns the result of the provided supplier.                   | `Optional.ofNullable(null).orElseGet(() -> "Generated"); // returns "Generated"`                                                                             |
| `orElseThrow(Supplier<? extends X> exceptionSupplier)` | Returns the value if present, otherwise throws an exception created by the provided supplier.          | `Optional.ofNullable(null).orElseThrow(() -> new IllegalStateException("Value not present")); // throws exception`                                          |
| `map(Function<? super T, ? extends U> mapper)` | Transforms the value if present using the provided function.                                            | `Optional.of("Hello").map(String::toUpperCase).ifPresent(System.out::println); // prints "HELLO"`                                                             |
| `flatMap(Function<? super T, Optional<U>> mapper)` | Transforms the value if present using the provided function that returns an `Optional`.                | `Optional.of("Hello").flatMap(val -> Optional.of(val.length())).ifPresent(System.out::println); // prints 5`                                                 |
| `filter(Predicate<? super T> predicate)` | Returns an `Optional` describing the value if it matches the given predicate, otherwise an empty `Optional`. | `Optional.of(10).filter(n -> n > 5).ifPresent(System.out::println); // prints 10`                                                                           |
| `toString()`                | Returns a string representation of the `Optional` object.                                               | `Optional.of("Hello").toString(); // returns "Optional[Hello]"`                                                                                               |

This table provides a comprehensive overview of `Stream` methods, including both intermediate and terminal operations, as well as methods in the `Optional` class, complete with descriptions and examples.

Sure! Here's a detailed table summarizing the common Java functional interfaces and their methods, including examples:

### **Common Functional Interfaces**

#### **`Function<T, R>`**

| **Method**                       | **Description**                                                                              | **Example**                                                                                                        |
|----------------------------------|----------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| `R apply(T t)`                   | Applies this function to the given argument.                                                | `Function<String, Integer> lengthFunction = String::length; lengthFunction.apply("Hello"); // returns 5`          |
| `default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)` | Returns a composed function that first applies this function and then applies the `after` function. | `Function<String, Integer> lengthFunction = String::length; Function<Integer, String> toStringFunction = Object::toString; lengthFunction.andThen(toStringFunction).apply("Hello"); // returns "5"` |
| `default <V> Function<V, R> compose(Function<? super V, ? extends T> before)` | Returns a composed function that first applies the `before` function and then applies this function. | `Function<String, Integer> lengthFunction = String::length; Function<Integer, Integer> addFiveFunction = n -> n + 5; lengthFunction.compose(addFiveFunction).apply("Hello"); // returns 10` |

#### **`Predicate<T>`**

| **Method**                        | **Description**                                                                  | **Example**                                                                                      |
|-----------------------------------|----------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `boolean test(T t)`               | Evaluates this predicate on the given argument.                                  | `Predicate<String> isEmpty = String::isEmpty; isEmpty.test(""); // returns true`                  |
| `default Predicate<T> and(Predicate<? super T> other)` | Returns a composed predicate that represents a short-circuiting logical AND of this predicate and another. | `Predicate<String> isEmpty = String::isEmpty; Predicate<String> isNull = s -> s == null; isEmpty.and(isNull).test(""); // returns false` |
| `default Predicate<T> or(Predicate<? super T> other)`  | Returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.  | `Predicate<String> isEmpty = String::isEmpty; Predicate<String> isNull = s -> s == null; isEmpty.or(isNull).test(""); // returns true` |
| `default Predicate<T> negate()`    | Returns a predicate that represents the logical negation of this predicate.        | `Predicate<String> isEmpty = String::isEmpty; isEmpty.negate().test("Hello"); // returns true`   |

#### **`Supplier<T>`**

| **Method**                       | **Description**                                              | **Example**                                                                                          |
|----------------------------------|--------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| `T get()`                        | Gets a result.                                               | `Supplier<String> supplier = () -> "Hello"; supplier.get(); // returns "Hello"`                       |

#### **`Consumer<T>`**

| **Method**                       | **Description**                                                                                   | **Example**                                                                                      |
|----------------------------------|---------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `void accept(T t)`               | Performs this operation on the given argument.                                                     | `Consumer<String> printConsumer = System.out::println; printConsumer.accept("Hello"); // prints "Hello"` |
| `default Consumer<T> andThen(Consumer<? super T> after)` | Returns a composed `Consumer` that performs, in sequence, this operation followed by the `after` operation. | `Consumer<String> printConsumer = System.out::println; Consumer<String> upperCaseConsumer = s -> System.out.println(s.toUpperCase()); printConsumer.andThen(upperCaseConsumer).accept("Hello"); // prints "Hello" and then "HELLO"` |

#### **`UnaryOperator<T>`** (extends `Function<T, T>`)

| **Method**                       | **Description**                                                | **Example**                                                                                      |
|----------------------------------|----------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `T apply(T t)`                   | Applies this operator to the given operand.                   | `UnaryOperator<String> toUpperCase = String::toUpperCase; toUpperCase.apply("Hello"); // returns "HELLO"` |
| `default UnaryOperator<T> andThen(UnaryOperator<? super T> after)` | Returns a composed `UnaryOperator` that first applies this operator and then applies the `after` operator. | `UnaryOperator<String> toUpperCase = String::toUpperCase; UnaryOperator<String> addExclamation = s -> s + "!"; toUpperCase.andThen(addExclamation).apply("Hello"); // returns "HELLO!"` |
| `default UnaryOperator<T> compose(UnaryOperator<T> before)` | Returns a composed `UnaryOperator` that first applies the `before` operator and then applies this operator. | `UnaryOperator<String> toUpperCase = String::toUpperCase; UnaryOperator<String> addPrefix = s -> "Mr. " + s; toUpperCase.compose(addPrefix).apply("Hello"); // returns "MR. HELLO"` |

#### **`BinaryOperator<T>`** (extends `BiFunction<T, T, T>`)

| **Method**                       | **Description**                                                   | **Example**                                                                                      |
|----------------------------------|-------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `T apply(T t1, T t2)`            | Applies this operator to the given operands.                      | `BinaryOperator<Integer> add = (a, b) -> a + b; add.apply(2, 3); // returns 5`                  |
| `default BinaryOperator<T> andThen(BinaryOperator<? super T> after)` | Returns a composed `BinaryOperator` that first applies this operator and then applies the `after` operator. | `BinaryOperator<Integer> add = (a, b) -> a + b; BinaryOperator<Integer> multiply = (a, b) -> a * b; add.andThen(multiply).apply(2, 3); // returns 15` |
| `default BinaryOperator<T> compose(BinaryOperator<? super T> before)` | Returns a composed `BinaryOperator` that first applies the `before` operator and then applies this operator. | `BinaryOperator<Integer> add = (a, b) -> a + b; BinaryOperator<Integer> multiply = (a, b) -> a * b; add.compose(multiply).apply(2, 3); // returns 5` |

#### **`BiFunction<T, U, R>`**

| **Method**                       | **Description**                                                               | **Example**                                                                                     |
|----------------------------------|-------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------|
| `R apply(T t, U u)`              | Applies this function to the given arguments.                                 | `BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b; multiply.apply(2, 3); // returns 6` |
| `default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after)` | Returns a composed function that first applies this function and then applies the `after` function. | `BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b; Function<Integer, String> toString = Object::toString; multiply.andThen(toString).apply(2, 3); // returns "6"` |
| `default <V> BiFunction<T, U, V> compose(BiFunction<? super T, ? super U, ? extends R> before)` | Returns a composed function that first applies the `before` function and then applies this function. | `BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b; BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b; multiply.compose(add).apply(2, 3); // returns 11` |

#### **`Consumer<T>`**

| **Method**                       | **Description**                                                                                   | **Example**                                                                                      |
|----------------------------------|---------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `void accept(T t)`               | Performs this operation on the given argument.                                                   | `Consumer<String> printConsumer = System.out::println; printConsumer.accept("Hello"); // prints "Hello"` |
| `default Consumer<T> andThen(Consumer<? super T> after)` | Returns a composed `Consumer` that performs, in sequence, this operation followed by the `after` operation. | `Consumer<String> printConsumer = System.out::println; Consumer<String> upperCaseConsumer = s -> System.out.println(s.toUpperCase()); printConsumer.andThen(upperCaseConsumer).accept("Hello"); // prints "Hello" and then "HELLO"` |

### **Summary**

This table provides a comprehensive overview of Java’s commonly used functional interfaces and their methods, complete with descriptions and examples. Each functional interface encapsulates a particular kind of function or operation, making it easier to use lambda expressions and method references in Java streams and other functional programming contexts.

Certainly! Here's a detailed table for `Comparator` and `Collectors` interfaces, including their methods and examples:

### **Comparator Interface**

| **Method**                                          | **Description**                                                                                      | **Example**                                                                                                                    |
|-----------------------------------------------------|------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| `int compare(T o1, T o2)`                          | Compares two objects of type `T` and returns an integer indicating their order.                       | `Comparator<String> comparator = String::compareTo; int result = comparator.compare("apple", "banana"); // returns negative` |
| `default Comparator<T> reversed()`                 | Returns a comparator that reverses the order of this comparator.                                    | `Comparator<String> reversed = String::compareTo.reversed(); int result = reversed.compare("apple", "banana"); // returns positive` |
| `default Comparator<T> thenComparing(Comparator<? super T> other)` | Returns a comparator that first compares using this comparator, and then compares using the `other` comparator if the first comparison is zero. | `Comparator<String> byLength = Comparator.comparingInt(String::length); Comparator<String> byAlphabet = String::compareTo; Comparator<String> combined = byLength.thenComparing(byAlphabet);` |
| `default <U> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator)` | Returns a comparator that first compares using this comparator, and then compares using the `keyComparator` on the `keyExtractor` of each element if the first comparison is zero. | `Comparator<String> combined = Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder());` |
| `static <T> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator)` | Returns a comparator that compares `T` by applying the `keyExtractor` function and then comparing the result using `keyComparator`. | `Comparator<String> comparator = Comparator.comparing(String::length, Comparator.reverseOrder());` |
| `static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)` | Returns a comparator that compares `T` by applying the `keyExtractor` function, which returns an `int`. | `Comparator<String> comparator = Comparator.comparingInt(String::length);` |
| `static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor)` | Returns a comparator that compares `T` by applying the `keyExtractor` function, which returns a `double`. | `Comparator<String> comparator = Comparator.comparingDouble(String::length);` |
| `static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor)` | Returns a comparator that compares `T` by applying the `keyExtractor` function, which returns a `long`. | `Comparator<String> comparator = Comparator.comparingLong(String::length);` |
| `static <T> Comparator<T> naturalOrder()`           | Returns a comparator that compares elements in their natural order.                                | `Comparator<String> naturalOrder = Comparator.naturalOrder();`                                                                 |
| `static <T> Comparator<T> reverseOrder()`           | Returns a comparator that compares elements in reverse natural order.                              | `Comparator<String> reverseOrder = Comparator.reverseOrder();`                                                                 |

### **Collectors Class**

| **Method**                                            | **Description**                                                                                         | **Example**                                                                                                                  |
|-------------------------------------------------------|---------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| `static <T, A, R> Collector<T, A, R> of(Collectors.Collector<T, A, R> collector)` | Creates a `Collector` based on the given `Collector`.                                                     | `List<String> list = Arrays.asList("apple", "banana", "cherry"); String result = list.stream().collect(Collectors.joining(", ")); // returns "apple, banana, cherry"` |
| `static <T> Collector<T, ?, List<T>> toList()`        | Returns a `Collector` that accumulates elements into a `List`.                                           | `List<String> list = Stream.of("apple", "banana", "cherry").collect(Collectors.toList()); // returns [apple, banana, cherry]` |
| `static <T> Collector<T, ?, Set<T>> toSet()`          | Returns a `Collector` that accumulates elements into a `Set`.                                           | `Set<String> set = Stream.of("apple", "banana", "cherry").collect(Collectors.toSet()); // returns [apple, banana, cherry]` |
| `static <T> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)` | Returns a `Collector` that groups elements by a classifier function.                                     | `Map<Integer, List<String>> groupedByLength = Stream.of("apple", "banana", "cherry").collect(Collectors.groupingBy(String::length));` |
| `static <T> Collector<T, ?, Map<K, Long>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, ?, Long> downstream)` | Returns a `Collector` that groups elements by a classifier function and counts them.                     | `Map<Integer, Long> lengthCounts = Stream.of("apple", "banana", "cherry").collect(Collectors.groupingBy(String::length, Collectors.counting()));` |
| `static <T, K> Collector<T, ?, Map<K, T>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, ?, T> downstream)` | Returns a `Collector` that groups elements by a classifier function and applies a downstream collector. | `Map<Integer, String> longestByLength = Stream.of("apple", "banana", "cherry").collect(Collectors.groupingBy(String::length, Collectors.maxBy(Comparator.comparingInt(String::length))));` |
| `static <T> Collector<T, ?, Optional<T>> reducing(BinaryOperator<T> op)` | Returns a `Collector` that performs a reduction on the elements of the stream using an associative accumulation function. | `Optional<String> concatenated = Stream.of("a", "b", "c").collect(Collectors.reducing(String::concat)); // returns "abc"` |
| `static <T> Collector<T, ?, T> reducing(T identity, BinaryOperator<T> op)` | Returns a `Collector` that performs a reduction on the elements of the stream, starting with the given identity value. | `String concatenated = Stream.of("a", "b", "c").collect(Collectors.reducing("", String::concat)); // returns "abc"` |
| `static <T> Collector<T, ?, String> joining()`        | Returns a `Collector` that concatenates the elements of the stream into a single `String`.               | `String result = Stream.of("a", "b", "c").collect(Collectors.joining(", ")); // returns "a, b, c"`                   |
| `static <T> Collector<T, ?, String> joining(CharSequence delimiter)` | Returns a `Collector` that concatenates the elements of the stream into a single `String`, with a specified delimiter. | `String result = Stream.of("a", "b", "c").collect(Collectors.joining(", ")); // returns "a, b, c"`                   |
| `static <T> Collector<T, ?, String> joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)` | Returns a `Collector` that concatenates the elements of the stream into a single `String`, with a specified delimiter, prefix, and suffix. | `String result = Stream.of("a", "b", "c").collect(Collectors.joining(", ", "[", "]")); // returns "[a, b, c]"` |
| `static <T> Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(ToDoubleFunction<? super T> mapper)` | Returns a `Collector` that summarizes the elements of the stream using a `ToDoubleFunction`.             | `DoubleSummaryStatistics stats = Stream.of("a", "bb", "ccc").collect(Collectors.summarizingDouble(String::length)); // returns DoubleSummaryStatistics{count=3, sum=6.0, min=1.0, average=2.0, max=3.0}` |
| `static <T> Collector<T, ?, IntSummaryStatistics> summarizingInt(ToIntFunction<? super T> mapper)` | Returns a `Collector` that summarizes the elements of the stream using a `ToIntFunction`.                | `IntSummaryStatistics stats = Stream.of("a", "bb", "ccc").collect(Collectors.summarizingInt(String::length)); // returns IntSummaryStatistics{count=3, sum=6, min=1, average=2.0, max=3}` |
| `static <T> Collector<T, ?, LongSummaryStatistics> summarizingLong(ToLongFunction<? super T> mapper)` | Returns a `Collector` that summarizes the elements of the stream using a `ToLongFunction`.               | `LongSummaryStatistics stats = Stream.of("a", "bb", "ccc").collect(Collectors.summarizingLong(String::length)); // returns LongSummaryStatistics{count=3, sum=6, min=1, average=2, max=3}` |
| `static Collector<CharSequence, ?, String> mapping(Function<? super T, ? extends R> mapper, Collector<? super R, A, D> downstream)` | Returns a `Collector` that applies a mapping function and then collects the results using another collector. | `List<String> result = Stream.of("a", "bb", "ccc").collect(Collectors.mapping(String::toUpperCase, Collectors.toList())); // returns [A, BB, CCC]` |
| `static <T> Collector<T, ?, Map<K, List<T>>> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper)` | Returns a `Collector` that accumulates elements into a `Map` using provided key and value mappers.       | `Map<Integer, String> map = Stream.of("apple", "banana", "cherry").collect(Collectors.toMap(String::length, Function.identity())); // returns {5=apple, 6=banana, 6=cherry}` |

### **Summary**

This table provides a comprehensive overview of the `Comparator` and `Collectors` interfaces in Java. `Comparator` is used for comparing objects, while `Collectors` is used to aggregate data from streams into various types of collections or other forms of summary statistics. Each method comes with a brief description and an example to illustrate its usage.


Sure! Here's a detailed overview of the Java Collection Framework, including key interfaces and classes, along with their primary methods and examples.

### **Collection Framework Overview**

#### **1. Collection Interface**

**Description:** The root interface of the Java Collection Framework. It is the parent of other collection interfaces such as `List`, `Set`, and `Queue`.

| **Method**                     | **Description**                                                              | **Example**                                                                                      |
|--------------------------------|------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `int size()`                   | Returns the number of elements in the collection.                              | `Collection<String> coll = Arrays.asList("a", "b", "c"); int size = coll.size(); // returns 3` |
| `boolean isEmpty()`            | Returns `true` if the collection is empty.                                     | `Collection<String> coll = Arrays.asList(); boolean empty = coll.isEmpty(); // returns true`    |
| `boolean contains(Object o)`   | Returns `true` if the collection contains the specified element.                | `Collection<String> coll = Arrays.asList("a", "b", "c"); boolean contains = coll.contains("b"); // returns true` |
| `Iterator<E> iterator()`       | Returns an iterator over the elements in the collection.                        | `Collection<String> coll = Arrays.asList("a", "b", "c"); Iterator<String> it = coll.iterator(); while (it.hasNext()) { System.out.println(it.next()); }` |
| `Object[] toArray()`           | Returns an array containing all the elements in the collection.                 | `Collection<String> coll = Arrays.asList("a", "b", "c"); String[] arr = coll.toArray(new String[0]); // returns ["a", "b", "c"]` |
| `boolean add(E e)`             | Adds the specified element to the collection.                                    | `Collection<String> coll = new ArrayList<>(); coll.add("a"); // coll contains ["a"]`            |
| `boolean remove(Object o)`     | Removes the specified element from the collection if it is present.             | `Collection<String> coll = new ArrayList<>(Arrays.asList("a", "b")); coll.remove("a"); // coll contains ["b"]` |
| `boolean containsAll(Collection<?> c)` | Returns `true` if the collection contains all elements of the specified collection. | `Collection<String> coll1 = Arrays.asList("a", "b", "c"); Collection<String> coll2 = Arrays.asList("b", "c"); boolean containsAll = coll1.containsAll(coll2); // returns true` |
| `boolean addAll(Collection<? extends E> c)` | Adds all elements from the specified collection to the collection.             | `Collection<String> coll1 = new ArrayList<>(Arrays.asList("a", "b")); Collection<String> coll2 = Arrays.asList("c", "d"); coll1.addAll(coll2); // coll1 contains ["a", "b", "c", "d"]` |
| `boolean removeAll(Collection<?> c)` | Removes from the collection all elements that are in the specified collection.   | `Collection<String> coll1 = new ArrayList<>(Arrays.asList("a", "b", "c")); Collection<String> coll2 = Arrays.asList("b", "c"); coll1.removeAll(coll2); // coll1 contains ["a"]` |
| `boolean retainAll(Collection<?> c)` | Retains only the elements in the collection that are contained in the specified collection. | `Collection<String> coll1 = new ArrayList<>(Arrays.asList("a", "b", "c")); Collection<String> coll2 = Arrays.asList("b", "c"); coll1.retainAll(coll2); // coll1 contains ["b", "c"]` |
| `void clear()`                 | Removes all elements from the collection.                                         | `Collection<String> coll = new ArrayList<>(Arrays.asList("a", "b", "c")); coll.clear(); // coll is empty` |

#### **2. List Interface** (extends Collection)

**Description:** An ordered collection that allows duplicate elements. It maintains the order in which elements are inserted.

| **Method**                    | **Description**                                                                 | **Example**                                                                                               |
|-------------------------------|---------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| `E get(int index)`            | Returns the element at the specified position in the list.                        | `List<String> list = Arrays.asList("a", "b", "c"); String element = list.get(1); // returns "b"`         |
| `E set(int index, E element)` | Replaces the element at the specified position with the specified element.       | `List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c")); list.set(1, "z"); // list is ["a", "z", "c"]` |
| `void add(int index, E element)` | Inserts the specified element at the specified position.                         | `List<String> list = new ArrayList<>(Arrays.asList("a", "b")); list.add(1, "c"); // list is ["a", "c", "b"]` |
| `E remove(int index)`         | Removes the element at the specified position.                                     | `List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c")); list.remove(1); // list is ["a", "c"]` |
| `int indexOf(Object o)`       | Returns the index of the first occurrence of the specified element.               | `List<String> list = Arrays.asList("a", "b", "c"); int index = list.indexOf("b"); // returns 1`         |
| `int lastIndexOf(Object o)`   | Returns the index of the last occurrence of the specified element.                | `List<String> list = Arrays.asList("a", "b", "c", "b"); int index = list.lastIndexOf("b"); // returns 3` |
| `List<E> subList(int fromIndex, int toIndex)` | Returns a view of the portion of the list between `fromIndex` (inclusive) and `toIndex` (exclusive). | `List<String> list = Arrays.asList("a", "b", "c", "d"); List<String> subList = list.subList(1, 3); // subList is ["b", "c"]` |

#### **3. Set Interface** (extends Collection)

**Description:** A collection that does not allow duplicate elements. Sets are unordered collections.

| **Method**                    | **Description**                                                                 | **Example**                                                                                               |
|-------------------------------|---------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| `boolean add(E e)`            | Adds the specified element to the set if it is not already present.              | `Set<String> set = new HashSet<>(); set.add("a"); // set contains ["a"]`                                |
| `boolean remove(Object o)`    | Removes the specified element from the set if it is present.                      | `Set<String> set = new HashSet<>(Arrays.asList("a", "b")); set.remove("a"); // set contains ["b"]`        |
| `boolean contains(Object o)`  | Returns `true` if the set contains the specified element.                         | `Set<String> set = new HashSet<>(Arrays.asList("a", "b")); boolean contains = set.contains("b"); // returns true` |
| `Set<E> union(Set<? extends E> other)` | Creates a new set that is the union of this set and the specified set.       | `Set<String> set1 = new HashSet<>(Arrays.asList("a", "b")); Set<String> set2 = new HashSet<>(Arrays.asList("b", "c")); Set<String> union = new HashSet<>(set1); union.addAll(set2); // union contains ["a", "b", "c"]` |
| `Set<E> intersection(Set<? extends E> other)` | Creates a new set that is the intersection of this set and the specified set. | `Set<String> set1 = new HashSet<>(Arrays.asList("a", "b")); Set<String> set2 = new HashSet<>(Arrays.asList("b", "c")); Set<String> intersection = new HashSet<>(set1); intersection.retainAll(set2); // intersection contains ["b"]` |

#### **4. Queue Interface** (extends Collection)

**Description:** A collection used to hold elements prior to processing. It typically represents a first-in-first-out (FIFO) data structure.

| **Method**                     | **Description**                                                                      | **Example**                                                                                             |
|--------------------------------|--------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `boolean offer(E e)`           | Inserts the specified element into the queue if possible.                            | `Queue<String> queue = new LinkedList<>(); queue.offer("a"); // queue contains ["a"]`                  |
| `E poll()`                     | Retrieves and removes the head of the queue, or returns `null` if the queue is empty. | `Queue<String> queue = new LinkedList<>(Arrays.asList("a", "b")); String head = queue.poll(); // head is "a", queue contains ["b"]` |
| `E peek()`                     | Retrieves, but does not remove, the head of the queue, or returns `null` if the queue is empty. | `Queue<String> queue = new LinkedList<>(Arrays.asList("a", "b")); String head = queue.peek(); // head is "a", queue contains ["a", "b"]` |
| `E remove()`                   | Retrieves and removes the head of the queue.                                          | `Queue<String> queue = new LinkedList<>(Arrays

.asList("a", "b")); String head = queue.remove(); // head is "a", queue contains ["b"]` |

#### **5. Map Interface**

**Description:** An object that maps keys to values. It does not extend the `Collection` interface.

| **Method**                      | **Description**                                                                                       | **Example**                                                                                             |
|---------------------------------|-------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `V get(Object key)`             | Returns the value associated with the specified key.                                                | `Map<String, Integer> map = new HashMap<>(); map.put("a", 1); Integer value = map.get("a"); // returns 1` |
| `V put(K key, V value)`         | Associates the specified value with the specified key in the map.                                    | `Map<String, Integer> map = new HashMap<>(); map.put("a", 1); // map contains {a=1}`                    |
| `V remove(Object key)`          | Removes the mapping for a key from the map if present.                                               | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b", 2)); map.remove("a"); // map contains {b=2}` |
| `boolean containsKey(Object key)`| Returns `true` if the map contains a mapping for the specified key.                                 | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); boolean contains = map.containsKey("a"); // returns true` |
| `boolean containsValue(Object value)`| Returns `true` if the map maps one or more keys to the specified value.                           | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); boolean contains = map.containsValue(1); // returns true` |
| `Set<K> keySet()`               | Returns a `Set` view of the keys contained in the map.                                                | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); Set<String> keys = map.keySet(); // keys contains ["a"]` |
| `Collection<V> values()`        | Returns a `Collection` view of the values contained in the map.                                      | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b", 2)); Collection<Integer> values = map.values(); // values contains [1, 2]` |
| `Set<Map.Entry<K, V>> entrySet()`| Returns a `Set` view of the mappings contained in the map.                                           | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b", 2)); Set<Map.Entry<String, Integer>> entries = map.entrySet(); // entries contains [{a=1}, {b=2}]` |

### **Collection Framework Classes**

#### **1. ArrayList**

**Description:** A resizable-array implementation of the `List` interface.

| **Method**               | **Description**                                                               | **Example**                                                                                              |
|--------------------------|-------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `ArrayList<E>()`         | Constructs an empty list with an initial capacity of 10.                        | `List<String> list = new ArrayList<>();`                                                                 |
| `ArrayList<E>(Collection<? extends E> c)` | Constructs a list containing the elements of the specified collection.    | `List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));`                                      |
| `boolean add(E e)`       | Appends the specified element to the end of the list.                           | `List<String> list = new ArrayList<>(); list.add("a"); // list contains ["a"]`                           |
| `E get(int index)`       | Returns the element at the specified position.                                 | `List<String> list = Arrays.asList("a", "b", "c"); String element = list.get(1); // returns "b"`        |

#### **2. HashSet**

**Description:** A collection that does not allow duplicate elements and is backed by a hash table.

| **Method**               | **Description**                                                               | **Example**                                                                                             |
|--------------------------|-------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `HashSet<E>()`           | Constructs an empty set with an initial capacity of 16 and load factor of 0.75. | `Set<String> set = new HashSet<>();`                                                                    |
| `HashSet<E>(Collection<? extends E> c)` | Constructs a set containing the elements of the specified collection. | `Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));`                                        |
| `boolean add(E e)`       | Adds the specified element to the set if it is not already present.             | `Set<String> set = new HashSet<>(); set.add("a"); // set contains ["a"]`                               |
| `boolean contains(Object o)` | Returns `true` if the set contains the specified element.                      | `Set<String> set = new HashSet<>(Arrays.asList("a", "b")); boolean contains = set.contains("b"); // returns true` |

#### **3. LinkedList**

**Description:** A doubly-linked list implementation of the `List` and `Deque` interfaces.

| **Method**               | **Description**                                                               | **Example**                                                                                              |
|--------------------------|-------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `LinkedList<E>()`        | Constructs an empty list.                                                        | `LinkedList<String> list = new LinkedList<>();`                                                           |
| `LinkedList<E>(Collection<? extends E> c)` | Constructs a list containing the elements of the specified collection.    | `LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "b", "c"));`                             |
| `boolean add(E e)`       | Appends the specified element to the end of the list.                           | `LinkedList<String> list = new LinkedList<>(); list.add("a"); // list contains ["a"]`                   |
| `E remove()`             | Removes and returns the first element of the list.                              | `LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "b")); String element = list.remove(); // returns "a", list contains ["b"]` |

#### **4. TreeSet**

**Description:** A NavigableSet that uses a Red-Black tree to store elements in a sorted order.

| **Method**               | **Description**                                                                | **Example**                                                                                             |
|--------------------------|--------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `TreeSet<E>()`           | Constructs an empty set that is sorted in natural order or by a specified comparator. | `Set<String> set = new TreeSet<>();`                                                                      |
| `TreeSet<E>(Collection<? extends E> c)` | Constructs a set containing the elements of the specified collection.    | `Set<String> set = new TreeSet<>(Arrays.asList("c", "b", "a")); // set contains ["a", "b", "c"]`         |
| `boolean add(E e)`       | Adds the specified element to the set if it is not already present.            | `Set<String> set = new TreeSet<>(); set.add("a"); // set contains ["a"]`                               |
| `E first()`              | Returns the first (lowest) element currently in the set.                        | `Set<String> set = new TreeSet<>(Arrays.asList("c", "b", "a")); String first = set.first(); // returns "a"` |

#### **5. LinkedHashMap**

**Description:** A hash table and linked list implementation of the `Map` interface, with predictable iteration order.

| **Method**                     | **Description**                                                                        | **Example**                                                                                              |
|--------------------------------|----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `LinkedHashMap<K, V>()`         | Constructs an empty LinkedHashMap with the specified initial capacity and load factor. | `Map<String, Integer> map = new LinkedHashMap<>();`                                                        |
| `LinkedHashMap<K, V>(Map<? extends K, ? extends V> m)` | Constructs a LinkedHashMap with the same mappings as the specified map.             | `Map<String, Integer> map = new LinkedHashMap<>(Map.of("a", 1, "b", 2));`                               |
| `boolean containsKey(Object key)` | Returns `true` if the map contains a mapping for the specified key.                 | `Map<String, Integer> map = new LinkedHashMap<>(Map.of("a", 1)); boolean contains = map.containsKey("a"); // returns true` |
| `boolean containsValue(Object value)` | Returns `true` if the map maps one or more keys to the specified value.            | `Map<String, Integer> map = new LinkedHashMap<>(Map.of("a", 1)); boolean contains = map.containsValue(1); // returns true` |

#### **6. HashMap**

**Description:** A hash table-based implementation of the `Map` interface that allows `null` values and keys.

| **Method**                     | **Description**                                                                        | **Example**                                                                                              |
|--------------------------------|----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `HashMap<K, V>()`               | Constructs an empty HashMap with the default initial capacity and load factor.         | `Map<String, Integer> map = new HashMap<>();`                                                             |
| `HashMap<K, V>(Map<? extends K, ? extends V> m)` | Constructs a HashMap with the same mappings as the specified map.                   | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b",

 2));`                                     |
| `boolean containsKey(Object key)` | Returns `true` if the map contains a mapping for the specified key.                 | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); boolean contains = map.containsKey("a"); // returns true` |
| `boolean containsValue(Object value)` | Returns `true` if the map maps one or more keys to the specified value.            | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); boolean contains = map.containsValue(1); // returns true` |

#### **7. TreeMap**

**Description:** A Red-Black tree-based implementation of the `NavigableMap` interface, which provides a sorted map.

| **Method**                     | **Description**                                                                        | **Example**                                                                                              |
|--------------------------------|----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `TreeMap<K, V>()`               | Constructs an empty TreeMap with natural ordering of keys or using a specified comparator. | `Map<String, Integer> map = new TreeMap<>();`                                                            |
| `TreeMap<K, V>(Map<? extends K, ? extends V> m)` | Constructs a TreeMap with the same mappings as the specified map.                   | `Map<String, Integer> map = new TreeMap<>(Map.of("c", 3, "a", 1, "b", 2));`                             |
| `K firstKey()`                 | Returns the first (lowest) key currently in the map.                                    | `Map<String, Integer> map = new TreeMap<>(Map.of("c", 3, "a", 1)); String firstKey = map.firstKey(); // returns "a"` |
| `K lastKey()`                  | Returns the last (highest) key currently in the map.                                   | `Map<String, Integer> map = new TreeMap<>(Map.of("a", 1, "c", 3)); String lastKey = map.lastKey(); // returns "c"` |

### **Summary**

This table provides an overview of the primary interfaces and classes in the Java Collection Framework, including `Collection`, `List`, `Set`, `Queue`, and `Map`, as well as concrete implementations like `ArrayList`, `HashSet`, `LinkedList`, `TreeSet`, `LinkedHashMap`, `HashMap`, and `TreeMap`. Each method is described along with an example to illustrate its use. This should help in understanding the functionality and usage of these core collection classes and interfaces.

Certainly! Here’s a detailed summary of some of the most commonly used interfaces and classes in the Java Collection Framework, including their key methods and examples.

### **Collection Framework Interfaces and Classes**

#### **Collection Interface**

| **Method**                 | **Description**                                                                                     | **Example**                                                                                           |
|----------------------------|-----------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| `int size()`               | Returns the number of elements in the collection.                                                   | `Collection<String> collection = Arrays.asList("a", "b", "c"); int size = collection.size(); // returns 3` |
| `boolean isEmpty()`        | Returns `true` if the collection is empty.                                                           | `Collection<String> collection = Arrays.asList(); boolean empty = collection.isEmpty(); // returns true` |
| `boolean contains(Object o)` | Returns `true` if the collection contains the specified element.                                   | `Collection<String> collection = Arrays.asList("a", "b", "c"); boolean contains = collection.contains("b"); // returns true` |
| `Iterator<E> iterator()`   | Returns an iterator over the elements in the collection.                                           | `Collection<String> collection = Arrays.asList("a", "b", "c"); Iterator<String> iterator = collection.iterator(); while (iterator.hasNext()) { System.out.println(iterator.next()); }` |
| `Object[] toArray()`       | Returns an array containing all of the elements in the collection.                                | `Collection<String> collection = Arrays.asList("a", "b", "c"); String[] array = collection.toArray(new String[0]); // returns ["a", "b", "c"]` |
| `boolean add(E e)`         | Adds the specified element to the collection.                                                        | `Collection<String> collection = new ArrayList<>(); collection.add("a"); // collection contains ["a"]` |
| `boolean remove(Object o)` | Removes the specified element from the collection.                                                  | `Collection<String> collection = new ArrayList<>(Arrays.asList("a", "b")); collection.remove("a"); // collection contains ["b"]` |
| `boolean containsAll(Collection<?> c)` | Returns `true` if the collection contains all of the elements in the specified collection.         | `Collection<String> collection1 = Arrays.asList("a", "b", "c"); Collection<String> collection2 = Arrays.asList("b", "c"); boolean containsAll = collection1.containsAll(collection2); // returns true` |
| `boolean addAll(Collection<? extends E> c)` | Adds all of the elements in the specified collection to the collection.                            | `Collection<String> collection1 = new ArrayList<>(Arrays.asList("a", "b")); Collection<String> collection2 = Arrays.asList("c", "d"); collection1.addAll(collection2); // collection1 contains ["a", "b", "c", "d"]` |
| `boolean removeAll(Collection<?> c)` | Removes from the collection all of its elements that are contained in the specified collection.    | `Collection<String> collection1 = new ArrayList<>(Arrays.asList("a", "b", "c")); Collection<String> collection2 = Arrays.asList("b", "c"); collection1.removeAll(collection2); // collection1 contains ["a"]` |
| `boolean retainAll(Collection<?> c)` | Retains only the elements in the collection that are contained in the specified collection.        | `Collection<String> collection1 = new ArrayList<>(Arrays.asList("a", "b", "c")); Collection<String> collection2 = Arrays.asList("b", "c"); collection1.retainAll(collection2); // collection1 contains ["b", "c"]` |
| `void clear()`             | Removes all elements from the collection.                                                           | `Collection<String> collection = new ArrayList<>(Arrays.asList("a", "b", "c")); collection.clear(); // collection is empty` |

#### **List Interface** (extends Collection)

| **Method**                  | **Description**                                                                                       | **Example**                                                                                  |
|-----------------------------|-------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| `E get(int index)`          | Returns the element at the specified position in the list.                                             | `List<String> list = Arrays.asList("a", "b", "c"); String element = list.get(1); // returns "b"` |
| `E set(int index, E element)` | Replaces the element at the specified position in the list with the specified element.                | `List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c")); list.set(1, "z"); // list is ["a", "z", "c"]` |
| `void add(int index, E element)` | Inserts the specified element at the specified position in the list.                                 | `List<String> list = new ArrayList<>(Arrays.asList("a", "b")); list.add(1, "c"); // list is ["a", "c", "b"]` |
| `E remove(int index)`       | Removes the element at the specified position in the list.                                             | `List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c")); list.remove(1); // list is ["a", "c"]` |
| `int indexOf(Object o)`     | Returns the index of the first occurrence of the specified element in the list.                        | `List<String> list = Arrays.asList("a", "b", "c"); int index = list.indexOf("b"); // returns 1` |
| `int lastIndexOf(Object o)` | Returns the index of the last occurrence of the specified element in the list.                         | `List<String> list = Arrays.asList("a", "b", "c", "b"); int index = list.lastIndexOf("b"); // returns 3` |
| `List<E> subList(int fromIndex, int toIndex)` | Returns a view of the portion of the list between `fromIndex`, inclusive, and `toIndex`, exclusive. | `List<String> list = Arrays.asList("a", "b", "c", "d"); List<String> subList = list.subList(1, 3); // subList is ["b", "c"]` |

#### **Set Interface** (extends Collection)

| **Method**                  | **Description**                                                                                         | **Example**                                                                               |
|-----------------------------|---------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| `boolean add(E e)`          | Adds the specified element to the set if it is not already present.                                     | `Set<String> set = new HashSet<>(); set.add("a"); // set contains ["a"]`                  |
| `boolean remove(Object o)`  | Removes the specified element from the set if it is present.                                            | `Set<String> set = new HashSet<>(Arrays.asList("a", "b")); set.remove("a"); // set contains ["b"]` |
| `boolean contains(Object o)`| Returns `true` if the set contains the specified element.                                               | `Set<String> set = new HashSet<>(Arrays.asList("a", "b")); boolean contains = set.contains("b"); // returns true` |
| `Set<E> union(Set<? extends E> other)` | Creates a new set that is the union of this set and the specified set.                              | `Set<String> set1 = new HashSet<>(Arrays.asList("a", "b")); Set<String> set2 = new HashSet<>(Arrays.asList("b", "c")); Set<String> union = new HashSet<>(set1); union.addAll(set2); // union contains ["a", "b", "c"]` |
| `Set<E> intersection(Set<? extends E> other)` | Creates a new set that is the intersection of this set and the specified set.                        | `Set<String> set1 = new HashSet<>(Arrays.asList("a", "b")); Set<String> set2 = new HashSet<>(Arrays.asList("b", "c")); Set<String> intersection = new HashSet<>(set1); intersection.retainAll(set2); // intersection contains ["b"]` |

#### **Queue Interface** (extends Collection)

| **Method**                   | **Description**                                                                                   | **Example**                                                                                     |
|------------------------------|---------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------|
| `boolean offer(E e)`         | Inserts the specified element into the queue if possible.                                        | `Queue<String> queue = new LinkedList<>(); queue.offer("a"); // queue contains ["a"]`         |
| `E poll()`                   | Retrieves and removes the head of the queue, or returns `null` if the queue is empty.             | `Queue<String> queue = new LinkedList<>(Arrays.asList("a", "b")); String head = queue.poll(); // head is "a", queue contains ["b"]` |
| `E peek()`                   | Retrieves, but does not remove, the head of the queue, or returns `null` if the queue is empty.   | `Queue<String> queue = new LinkedList<>(Arrays.asList("a", "b")); String head = queue.peek(); // head is "a", queue contains ["a", "b"]` |
| `E remove()`                 | Retrieves and removes the head of the queue.                                                      | `Queue<String> queue = new LinkedList<>(Arrays.asList("a", "b")); String head = queue.remove(); // head is "a", queue contains ["b"]` |

#### **Map Interface**

| **Method**                       | **Description**                                                                                         | **Example**                                                                                         |
|----------------------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| `V get(Object key)`              | Returns the value associated with the specified key.                                                    | `Map<String, Integer> map = new HashMap<>(); map.put("a", 1); Integer value = map.get("a"); // returns 1` |
| `V put(K key, V value)`          | Associates the specified value with the specified key in the map.                                       | `Map<String, Integer> map = new HashMap<>(); map.put("a", 1); // map contains {a=1}`                |
| `V remove(Object key)`           | Removes the mapping for a key from the map if present.                                                  | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b", 2)); map.remove("a"); // map contains {b=2}` |
| `boolean containsKey(Object key)` | Returns `true` if the map contains a mapping for the specified key.                                    | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); boolean contains = map.containsKey("a"); // returns true` |
| `boolean containsValue(Object value)` | Returns `true` if the map maps one or more keys to the specified value.                               | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); boolean contains = map.containsValue(1); // returns true` |
| `Set<K> keySet()`                | Returns a `Set` view of the keys contained in the map.                                                  | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1)); Set<String> keys = map.keySet(); // keys contains ["a"]` |
| `Collection<V> values()`         | Returns a `Collection` view of the values contained in the map.                                        | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b", 2)); Collection<Integer> values = map.values(); // values contains [1, 2]` |
| `Set<Map.Entry<K, V>> entrySet()`| Returns a `Set` view of the mappings contained in the map.                                             | `Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b", 2)); Set<Map.Entry<String, Integer>> entries = map.entrySet(); // entries contains [{a=1}, {b=2}]` |

### **Summary**

This table provides an overview of the primary interfaces and classes in the Java Collection Framework, including `Collection`, `List`, `Set`, `Queue`, and `Map`. Each method is described along with an example to illustrate its use. This should help in understanding the functionality and usage of these core collection classes and interfaces.
