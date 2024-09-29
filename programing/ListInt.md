# ListInt.java

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListInt {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//list.add(null);
		list.add("Australia");
		list.add("India");
		list.add("Africa");
		list.add("Indonesia");
		list.add("Malaysia");
		
		for(String s:list) {
			//System.out.println("list values"+s);
			if(s!=null && (s.startsWith("A"))) {
				s=s+"AA";
				System.out.println(s);
			}
		}
		
		Stream<String> stream = list.stream();
		
		// In one line display all records that start with 'a' in stream
		//System.out.println("1. Use stream for filtering and display:");
		stream.filter(s-> s!=null && s.startsWith("A")).forEach(System.out::println);
		//stream.filter(s-> s!=null && s.startsWith("A")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
	}

}
//output ={"AustraliaAA","AfricaAA"}
//AustraliaAA
//AfricaAA
```
