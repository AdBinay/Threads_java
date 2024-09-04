class PrintEven extends Thread {
    public void run() {
        try {
            for (int i = 0; i <= 10; i = i + 2) {
                System.out.println("Even=" + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class PrintOdd extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 10; i = i + 2) {
                System.out.println("Odd=" + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        PrintEven pe = new PrintEven();
        PrintOdd po = new PrintOdd();

        po.setPriority(1);  // Set priority of PrintOdd thread to MIN_PRIORITY
        pe.setPriority(10); // Set priority of PrintEven thread to MAX_PRIORITY

        po.start();
        pe.start();
    }
}
