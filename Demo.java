class MyThread extends Thread {
    public void run() {  // this is overridden method of Thread Class
        System.out.println("New thread Created");
    }
}
public class Demo {
    public static void main(String args[]) {
        MyThread t = new MyThread();
        t.start();
    }
}


