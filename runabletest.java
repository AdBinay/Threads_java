class MyRunnable implements Runnable{
    public void run(){
        System.out.println("java runnable thread");
    }
}

public class runabletest{
    public static void main(String args[]){
        MyRunnable threadobj = new MyRunnable();
        Thread MyThread = new Thread(threadobj);
        MyThread.start();
    }
}