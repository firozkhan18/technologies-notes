# com\java\eight8\threads\ThreadsInJava.java

```java
package com.java.eight8.threads;

//How To Detect The Deadlocked Threads In Java
//pramodbabladPRAMODBABLADJULY 31, 2014THREADS6 COMMENTS
//In the previous article, we have seen what is the deadlock and why it occurs. Deadlock is the condition which occurs when two or more threads wait for each other forever.
//
//
//Programmatically, You can detect the threads which have entered into deadlock condition and also you can retrieve the details about them. This can be done using ThreadMXBean interface of java.lang.Management package. You can go through the oracle docs of ThreadMXBean interface here.
//
//First, you have to get an instance of ThreadMXBean using getThreadMXBean() method of ManagementFactory, like this.
//

//ThreadMXBean bean = ManagementFactory.getThreadMXBean();
//After getting an instance of ThreadMXBean, call findMonitorDeadlockedThreads() method on it. It returns an array of type long containing ids of all currently deadlocked threads.
//

//long ids[] = bean.findMonitorDeadlockedThreads();
//After getting the ids of deadlocked threads, pass these ids to getThreadInfo() method of ThreadMXBean. It will return an array of ThreadInfo objects, where one ThreadInfo object contains the details of one deadlocked thread.
//
//

//ThreadInfo threadInfo[] = bean.getThreadInfo(ids);
//Iterate the ThreadInfo array to get the details of individual deadlocked thread.
//

//for (ThreadInfo threadInfo1 : threadInfo)
//{
//    System.out.println(threadInfo1.getThreadName());    //Prints the name of deadlocked thread
//}
//
//
//Here are the some methods of ThreadInfo class which are useful to retrieve the details of deadlocked threads.
//
//getThreadId()               —>    Returns the ID of a deadlocked thread.
//
//getThreadName()         —>     Returns the name of a deadlocked thread.
//
//getBlockedTime()          —>    Returns the elapsed time in milli seconds that a thread is in deadlock condition.
//
//getLockName()             —>    Returns string representation of an object for which thread has been waiting.
//
//getLockOwnerId()         —>    Returns ID of a thread that currently owns the object lock.
//
//getLockOwnerName()    —>    Returns the name of a thread that currently owns the object lock.
//
//Here is yesterday’s example that has been modified to get the details of deadlocked threads.

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
 
class Shared
{
    synchronized void methodOne(Shared s)
    {
        Thread t = Thread.currentThread();
 
        System.out.println(t.getName()+"is executing methodOne...");
 
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
 
        System.out.println(t.getName()+"is calling methodTwo...");
 
        s.methodTwo(this);
 
        System.out.println(t.getName()+"is finished executing methodOne...");
    }
 
    synchronized void methodTwo(Shared s)
    {
        Thread t = Thread.currentThread();
 
        System.out.println(t.getName()+"is executing methodTwo...");
 
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
 
        System.out.println(t.getName()+"is calling methodOne...");
 
        s.methodOne(this);
 
        System.out.println(t.getName()+"is finished executing methodTwo...");
    }
}
 
public class ThreadsInJava
{
    public static void main(String[] args)
    {
        final Shared s1 = new Shared();
 
        final Shared s2 = new Shared();
 
        Thread t1 = new Thread()
        {
            public void run()
            {
                s1.methodOne(s2);
            }
        };
 
        Thread t2 = new Thread()
        {
            @Override
            public void run()
            {
                s2.methodTwo(s1);
            }
        };
 
        t1.start();
 
        t2.start();
 
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
 
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
 
        long ids[] = bean.findMonitorDeadlockedThreads();
 
        if(ids != null)
        {
            ThreadInfo threadInfo[] = bean.getThreadInfo(ids);
 
            for (ThreadInfo threadInfo1 : threadInfo)
            {
                System.out.println(threadInfo1.getThreadId());    //Prints the ID of deadlocked thread
 
                System.out.println(threadInfo1.getThreadName());  //Prints the name of deadlocked thread
 
                System.out.println(threadInfo1.getLockName());    //Prints the string representation of an object for which thread has entered into deadlock.
 
                System.out.println(threadInfo1.getLockOwnerId());  //Prints the ID of thread which currently owns the object lock
 
                System.out.println(threadInfo1.getLockOwnerName());  //Prints name of the thread which currently owns the object lock.
            }
        }
        else
        {
            System.out.println("No Deadlocked Threads");
        }
    }
}
```
