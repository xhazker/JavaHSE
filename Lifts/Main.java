import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int lifts=1;
        int floors=3;
        System.out.println(Thread.currentThread().getName());
        Skyscraper s = new Skyscraper(5,3);

        Runnable task = () -> {
            s.callLift(5, 1);
            s.callLift(2, -1);
            s.callLift(3, -1);
//            s.callLift(3, 1);
            s.callLift(4, -1);
        };
        Thread th1 = new Thread(task);
        th1.start();

        while(true) {
            System.out.println(s);
            System.out.println("");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}