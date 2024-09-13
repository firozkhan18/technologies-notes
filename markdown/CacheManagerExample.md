# CacheManagerExample.java

```java

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

public class CacheManagerExample {

	public static void main(String[] args) {
		// Get the default caching provider
		CachingProvider cachingProvider = Caching.getCachingProvider();

		// Create a cache manager using the default caching provider
		CacheManager cacheManager = cachingProvider.getCacheManager();

		// Configure the cache
		MutableConfiguration<String, String> config = new MutableConfiguration<>();
		config.setStoreByValue(false);

		// Create a cache with the specified name and configuration
		cacheManager.createCache("exampleCache", config);

		// Get the cache
		javax.cache.Cache<String, String> cache = cacheManager.getCache("exampleCache", String.class, String.class);

		// Put an entry into the cache
		cache.put("key", "value");

		// Get the entry from the cache
		String value = cache.get("key");
		System.out.println("Value from cache: " + value);

		// Close the cache manager when done
		cacheManager.close();
	}
}
```
