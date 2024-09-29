# com\java\eight8\newfeatures\lambda\TradersAndTransactions.java

```java
package com.java.eight8.newfeatures.lambda;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
public class TradersAndTransactions {
	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan  = new Trader("Alan",  "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = 
				Arrays.asList(
					new Transaction(brian, 2011, 300),
					new Transaction(raoul, 2012, 1000), 
					new Transaction(raoul, 2011, 400),
					new Transaction(mario, 2012, 710), 
					new Transaction(mario, 2012, 700), 
					new Transaction(alan,  2012, 950)
				);
		
		//System.out.println(transactions);
		
		//Find all transactions in 2011 and sort by value (small to high)
		List<Transaction> tra2011 =
				transactions.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))
				.collect(toList());
		System.out.println(tra2011);
//		What are all the unique cities where the traders work?
		Set<String> cities =
				transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.collect(toSet());
		System.out.println(cities);
		
		//Find all traders from Cambridge and sort them by name (by Method Reference)
				List<Trader> traders =
						transactions.stream()
						.map(transaction -> transaction.getTrader())
						.filter(trader -> trader.getCity().equals("Cambridge"))
						.distinct()
						.sorted(comparing(Trader::getName))
						.collect(toList());
				System.out.println(traders);
				
		//Find all traders from Cambridge and sort them by name
		List<Trader> traders1 =
				transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct()
				.sorted(comparing(Trader::getName))
				.collect(toList());
		System.out.println(traders1);
		//Return a string of all traders’ names sorted alphabetically
		String traders3 =
				transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (n1, n2)->n1+n2);
		System.out.println(traders3);
		
		String traderStr =
				transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.collect(joining());
		System.out.println(traderStr);
		//Are any traders based in Milan?
		boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().equals("Milan"));
		System.out.println(milanBased);
		//Print all transactions’ values from the traders living in Cambridge
		transactions.stream()
				.filter(trader -> trader.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.forEach(System.out::println);
		//What’s the highest value of all the transactions?
		Optional<Integer> maxValue= transactions.stream()
			.map(Transaction::getValue)
			.reduce(Integer::max);
		System.out.println(maxValue);
		//Find the transaction with the smallest value
		Optional<Transaction> smallestTransaction =
				transactions.stream()
				.reduce((t1,t2)-> t1.getValue() < t2.getValue() ? t1 : t2 );
		System.out.println(smallestTransaction);
//		You can do better. A stream supports the methods min and max that take a Comparator as
//		argument to specify which key to compare with when calculating the minimum or maximum:
		Optional<Transaction> smallestTransaction1 =
				transactions.stream()
				.min(comparing(Transaction::getValue));
		System.out.println(smallestTransaction1);
		
	}
}
```
