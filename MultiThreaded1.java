class PrintEven implements Runnable {
    public void run() {
        for (int i = 0; i <= 50; i += 2) {
            System.out.println("Even=" + i + " ");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class PrintOdd implements Runnable {
    public void run() {
        for (int i = 1; i <= 50; i += 2) {
            System.out.print("Odd=" + i + " ");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class MultiThreaded1 {
    public static void main(String[] args) {
        PrintEven pe = new PrintEven();
        Thread t1 = new Thread(pe);
        t1.start();
        
        PrintOdd po = new PrintOdd();
        Thread t2 = new Thread(po);
        t2.start();
    }
}
