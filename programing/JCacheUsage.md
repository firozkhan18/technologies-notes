# JCacheUsage.java

```java
import java.util.UUID;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

public class JCacheUsage{
    public static void main(String[] args){
        //bootstrap the JCache Provider
        CachingProvider jcacheProvider = Caching.getCachingProvider();
        CacheManager jcacheManager = jcacheProvider.getCacheManager();
        //configure cache
        MutableConfiguration<String, Integer> jcacheConfig = new MutableConfiguration<>();
        jcacheConfig.setTypes(String.class, MyPreciousObject.class);
        //create cache
        Cache<String, MyPreciousObject> cache = jcacheManager.createCache("PreciousObjectCache", jcacheConfig);
        //play around
        String key = UUID.randomUUID().toString();
        cache.put(key, new MyPreciousObject());
        MyPreciousObject inserted = cache.get(key);
        cache.remove(key);
        cache.get(key); //will throw javax.cache.CacheException since the key does not exist
    }
}
```
