public class Test {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        MyThread myThread = new MyThread();
//        MyThread myThread1 = new MyThread();
//        myThread.start();
//        myThread1.start();
        Thread thread = new Thread(new Runner());
        thread.start();
        Thread thread1 = new Thread(new Runner());
        thread1.start();

//        for ( int i = 0; i < 100; i ++) {
//            System.out.println("Hello");
//        }


    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for ( int i = 0; i < 100; i ++) {
            System.out.println("Hello from my thread!" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    public void run () {
        for ( int i = 0; i < 100; i ++) {
            System.out.println("Hello from my thread!" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}