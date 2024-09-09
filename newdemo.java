class newthread extends Thread{
    public void run(){
        System.out.println("This is a new thread by alphabeta");
    }
}

public class newdemo{
    public static void main(String[] args) {
        newthread nt = new newthread();
        nt.start();
    }
}