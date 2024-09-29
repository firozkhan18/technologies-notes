# com\java\eight8\string\LaunchExternalApplicationsThroughJavaProgram.java

```java
package com.java.eight8.string;

public class LaunchExternalApplicationsThroughJavaProgram {

}

//For every java application, there is a one and only one java.lang.Runtime object associated with it. This Runtime objcet is used to interact with the environment in which application is running. Application itself can’t create an instance of Runtime. But, You can retrieve Runtime object associated with the appliaction using getRuntime() method of java.lang.Runtime class. Like below,
//
//
//Runtime runtime = Runtime.getRuntime();
//
//You can use thus obtained Runtime object to interact with runtime environment of that application.
//
//There is one method in java.lang.Runtime class called exec() method. This method executes the specified system command in a separate process. You can use this method to launch external applications like notepad, browser or any media player through your java program. For example if you pass “notepad.exe” to this method, it opens new instance of notepad application.
//
//There are total 6 versions of exec() method available in Runtime class. You can follow all those methods here. We will discuss two widely used exec() methods in this post. They are,
//
//
//1) public Process exec(String command) throws IOException
//
//—>This method takes system command in the form of string.
//
//2) public Process exec(String[] command) throws IOException
//
//—> This method takes system command in the form of string array.
//
//Here is the java program which opens a new instance of notepad using exec() method which takes system command as a string.

public class LaunchingExternalApps
{
    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object
 
        try
        {
            runtime.exec("notepad.exe");        //opens new notepad instance
 
            //OR runtime.exec("notepad");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
//You can also open a particular file in notepad using the same exec() method.

public class LaunchingExternalApps
{
    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object
 
        try
        {
            runtime.exec("notepad I:\\sample.txt");        //opens "sample.txt" in notepad
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
//Please notice that file name is specified along with it’s path (I:\sample.txt).
//
//You can also open an URL in any browser using exec() method which takes command as string array. First element of string array must be the path of .exe file of installed browser and second element must be URL to open.
//
//Here is a java program which opens “https://javaconceptoftheday.com/” in chrome browser.

public class LaunchingExternalApps
{
    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object
 
        String[] s = new String[] {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "https://javaconceptoftheday.com/"};
 
        try
        {
            runtime.exec(s);        //opens "https://javaconceptoftheday.com/" in chrome browser
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
//Here is an example which opens “sample.mp3” file in VLC Media Player.

public class LaunchingExternalApps
{
    public static void main(String[] args) throws Exception
    {
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object
 
        String[] s = new String[] {"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe", "F:\\sample.mp3"};
 
        Process process = runtime.exec(s);        //opens "sample.mp3" in VLC Media Player
    }
}
//You can also close the launched applications using destroy() method of Process class. Just call the destroy() method on the process object returned by the exec() method.
//
//Here is the java program which opens the notepad instance and closes it after 5 seconds.

public class LaunchingExternalApps
{
    public static void main(String[] args) throws Exception
    {
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object
 
        Process process = runtime.exec("notepad I:\\sample.txt");        //opens "sample.txt" in notepad
 
        Thread.sleep(5000);
 
        process.destroy();
    }
}
```
