import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();

    }
}

class MyThread extends Thread {
    private volatile boolean runner = true;

    public void run() {
        int i = 0;
        while(runner) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void shutdown() {
        this.runner = false;
    }
}
