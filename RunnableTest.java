class MyRunnable implements Runnable 
{
    public void run()  // this is abstract method of Runnable interface
    {
        System.out.println("New Thread Created");
    }
}

public class RunnableTest 
{
    public static void main(String args[]) 
    {
        MyRunnable threadobj = new MyRunnable();
        Thread MyThread = new Thread(threadobj);
        MyThread.start();
    }
}
//javac RunnableTest.java
//java RunnableTest