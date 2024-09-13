# MainClass.java

```java
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

public class MainClass {

	public static void main(String[] args) {
		CachingProvider cachingProvider = Caching.getCachingProvider();
		// Create a cache manager using the default caching provider
		CacheManager cacheManager = cachingProvider.getCacheManager();
		// Configure the cache
		MutableConfiguration<String, String> config = new MutableConfiguration<>();
// Create a simple but typesafe configuration for the cache.
//        CompleteConfiguration<String, String> config =
//                new MutableConfiguration<String, String>()
//                        .setTypes( String.class, String.class );

		//config.setStoreByValue(false);
		// Create a cache with the specified name and configuration
		Cache<String, String> cache = cacheManager.createCache("JDKCodeNames", config);
		// Get the cache
		//cacheManager.getCache("JDKCodeNames", String.class, String.class);
		cacheManager.getCache("JDKCodeNames", Object.class, Object.class);		
		
//		Cache<Object, Object> cache = cacheManager
//		    .getCache( "default", Object.class, Object.class );
		
		// Put an entry into the cache
		cache.put("JDK1.5", "Tiger");
		cache.put("JDK1.6", "Mustang");
		cache.put("JDK1.7", "Dolphin");
		// Get the entry from the cache
		String jdk7CodeName = cache.get("JDK1.7");		
		System.out.println("Value from cache: " + jdk7CodeName);
		// Close the cache manager when done
		cacheManager.close();
	}
}
```
