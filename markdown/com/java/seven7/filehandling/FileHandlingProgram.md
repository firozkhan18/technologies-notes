# com\java\seven7\filehandling\FileHandlingProgram.java

```java
package com.java.seven7.filehandling;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.filechooser.FileSystemView;

public class FileHandlingProgram {
	public static void main(String[] args) {

		  // Creating String Stream
        Stream stringStream = Stream.of("java", "program", "to", ".com");
        // converting String's Stream to List
        List strList = (List) stringStream.collect(Collectors.toList());
        // printing each value from list.
        System.out.println("List values are : ");
        strList.forEach(value -> System.out.println(value));
        
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File[] drives = File.listRoots();
		if (drives.length > 0 && drives != null) {
			for (File drive : drives) {
				System.out.println("====================");
				System.out.println("Drive Name : " + drive);
				System.out.println("Type Of Drive : " + fsv.getSystemTypeDescription(drive));
				System.out.println("Total Space : " + drive.getTotalSpace() / (1024 * 1024 * 1024) + " GB");
				System.out.println("Free Space : " + drive.getFreeSpace() / (1024 * 1024 * 1024) + " GB");
				System.out.println("Usable Space : " + drive.getUsableSpace() / (1024 * 1024 * 1024) + " GB");
			}
		}
	}
}
```
