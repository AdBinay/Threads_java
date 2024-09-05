// public class concurrecy extends Thread{
//     public static int amount = 0;
    
//     public static void main(String[] args) {
//         concurrecy thread = new concurrecy();
//         thread.start();
//         System.out.println(amount);
//         amount++;
//         System.out.println(amount);

//     }

//     public void run(){
//         amount++;
//     }
// } 
    
public class concurrecy extends Thread{
    public static int amount = 0;

    public static void main(String[] args) {
        concurrecy thread  = new concurrecy();
        thread.start();

        while(thread.isAlive()){
            System.out.println("Waiting.......");
        }

        System.out.println("Concurecy:" + amount);
        amount++;
        System.out.println("Concurecy:" +amount);
    }
    public void run(){
        amount++;
    }
}
