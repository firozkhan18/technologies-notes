# How To Stop A Thread In Java?

How do you stop a thread in Java? This has become a popular question in Java interviews, especially since the `stop()` method has been deprecated for safety reasons. Interviewers are often interested in the logic you will use to stop a thread. There are two main ways to stop a thread in Java:

1. Using a boolean variable
2. Using the `interrupt()` method

In this post, we will discuss both methods.

## How To Stop A Thread In Java Using A Boolean Variable

In this method, we declare a boolean variable called `flag` in the thread. Initially, we set this flag to `true`. We keep the task to be performed in a `while` loop inside the `run()` method, which continues to run until the flag becomes `false`. We define a `stopRunning()` method that sets the flag to `false`, effectively stopping the thread. Additionally, we declare the flag as `volatile` to ensure that the thread reads its value from main memory, ensuring it always gets the updated value.

```java
class MyThread extends Thread {
    // Initially setting the flag as true
    private volatile boolean flag = true;

    // This method will set flag to false
    public void stopRunning() {
        flag = false;
    }

    @Override
    public void run() {
        // Keep the task in while loop
        // This will make the thread continue to run until flag becomes false
        while (flag) {
            System.out.println("I am running....");
        }
        System.out.println("Stopped Running....");
    }
}

public class MainClass {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Call stopRunning() method whenever you want to stop the thread
        thread.stopRunning();
    }
}
```

### Output:

```
I am running….
I am running….
...
I am running….
Stopped Running….
```

## How To Stop A Thread In Java Using the `interrupt()` Method

In this method, we use the `interrupt()` method to stop a thread. Whenever you call the `interrupt()` method on a thread, it sets the interrupted status of the thread. This status can be checked using the `interrupted()` method. The status is then used in a `while` loop to stop the thread.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("I am running....");
        }
        System.out.println("Stopped Running.....");
    }
}

public class MainClass {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Interrupting the thread
        thread.interrupt();
    }
}
```

### Output:

```
I am running….
I am running….
...
I am running….
Stopped Running….
``` 

Both methods provide effective ways to manage thread lifecycle in Java, but using `interrupt()` is generally preferred in modern Java programming practices.
