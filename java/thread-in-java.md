How To Stop A Thread In Java?

How do you stop a thread in java? now-a-days, this has been the popular question in the java interviews. 
Because, stop() method has been deprecated for some safety reasons. 
As stop() method has been deprecated, interviewer will be interested in what logic you will be using to stop a thread. 
There are two ways through which you can stop a thread in java. 
One is using boolean variable and second one is using interrupt() method. 
In this post, we will discuss both of these methods.

How To Stop A Thread In Java Using A boolean Variable?
In this method, we declare one boolean variable called flag in a thread. 
Initially we set this flag as true. Keep the task to be performed in while loop inside the run() method by passing this flag. 
This will make thread continue to run until flag becomes false. 
We have defined stopRunning() method. 
This method will set the flag as false and stops the thread. 
Whenever you want to stop the thread, just call this method. 
Also notice that we have declared flag as volatile.
This will make thread to read its value from the main memory, thus making sure that thread always gets its updated value.

class MyThread extends Thread
{
    //Initially setting the flag as true     
    private volatile boolean flag = true;     
    //This method will set flag as false     
    public void stopRunning(){
        flag = false;
    }     
    @Override
    public void run(){
        //Keep the task in while loop         
        //This will make thread continue to run until flag becomes false         
        while (flag){
            System.out.println("I am running....");
        }         
        System.out.println("Stopped Running....");
    }
}
 
public class MainClass 
{   
    public static void main(String[] args) 
    {
        MyThread thread = new MyThread();         
        thread.start();         
        try {
            Thread.sleep(100);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }         
        //call stopRunning() method whenever you want to stop a thread         
        thread.stopRunning();
    }   
}
Output :

I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
Stopped Running….

How To Stop A Thread In Java Using interrupt() Method?

In this method, we use interrupt() method to stop a thread. 
Whenever you call interrupt() method on a thread, it sets the interrupted status of a thread. 
This status can be obtained by interrupted() method. 

This status is used in a while loop to stop a thread.

class MyThread extends Thread
{   
    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            System.out.println("I am running....");
        }         
        System.out.println("Stopped Running.....");
    }
}
 
public class MainClass 
{   
    public static void main(String[] args) 
    {
        MyThread thread = new MyThread();         
        thread.start();         
        try
        {
            Thread.sleep(100);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }         
        //interrupting the thread         
        thread.interrupt();
    }   
}
Output :

I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
I am running….
Stopped Running…..
