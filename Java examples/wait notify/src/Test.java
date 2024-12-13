import com.sun.jdi.ThreadReference;

import javax.swing.plaf.TableHeaderUI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ProduserConsumer w = new ProduserConsumer();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    w.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    w.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
    }
}

class ProduserConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object object = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while(true) {
             synchronized (object) {
                 while(queue.size() == LIMIT) {
                     object.wait();
                 }

                 queue.offer(value++);
                 object.notify();
             }
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (object) {
                while (queue.size() == 0) {
                    object.wait();
                }

                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size is " + queue.size());
                object.notify();
            }

            Thread.sleep(1000);
        }
    }
}