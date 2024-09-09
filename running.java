// public class running extends Thread{
//     public static void main(String[] args) {
//         running thread = new running();
//         thread.start();
//         System.out.println("This is thread running");
//     }
//     public void run(){
//         System.out.println("Runn thread runnnnnn");
//     }
// }

public class running implements Runnable{
    public static void main(String[] args) {
        running obj = new running();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("This outside of the thread");
    }
    public void run (){
        System.out.println("Runn outside thread runnn");
    }

}