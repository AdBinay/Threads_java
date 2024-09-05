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

class Meow extends Thread {
    public void run () {
        System.out.println(" /\\_/\\  ");
        System.out.println("( o.o ) ");
        System.out.println(" > ^ <  ");
        System.out.println("Meow, Meow meow Meow!\n"); 
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        PrintEven pe = new PrintEven();
        PrintOdd po = new PrintOdd();
        Meow meow = new Meow();

        meow.setPriority(1);
        po.setPriority(2);  // Set priority of PrintOdd thread to MIN_PRIORITY
        pe.setPriority(10); // Set priority of PrintEven thread to MAX_PRIORITY

        meow.start();
        po.start();
        pe.start();
    }
}
