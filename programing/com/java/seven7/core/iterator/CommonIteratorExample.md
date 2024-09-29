# com\java\seven7\core\iterator\CommonIteratorExample.java

```java
package com.java.seven7.core.iterator;

import com.java.seven7.core.iterator.custom.CommonIterator;
import com.java.seven7.core.iterator.custom.SortedIterator;

public class CommonIteratorExample {
    public static void main(String args[]){
        SortedIterator itr1 = new SortedIterator(new int[]{1,3,5,7,9});
        SortedIterator itr2 = new SortedIterator(new int[]{2,3,4,8,9});
        CommonIterator iterator = new CommonIterator(itr1, itr2);

        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }
    }
}
```
