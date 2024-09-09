class PrintEven extends Thread {
    public void run() {
        for (int i = 0; i <= 50; i = i + 2) {
            System.out.println("Even=" + i + "");
            try {
                Thread.sleep(100); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class PrintOdd extends Thread {
    public void run() {
        for (int i = 1; i <= 50; i = i + 2) {
            System.out.println("Odd=" + i + "");
            try {
                Thread.sleep(100); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class AHHHHHHH extends Thread {
    public void run(){
        for(int i =2; i<=50; i = i+2){
            System.out.println("AHHHHHHHHHHHHHH");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }}

public class MultiThreaded {
    public static void main(String[] args) {
        PrintEven pe = new PrintEven();
        pe.start();
        
        PrintOdd po = new PrintOdd();
        po.start();

        AHHHHHHH ah = new AHHHHHHH();
        ah.start();
    }
}
