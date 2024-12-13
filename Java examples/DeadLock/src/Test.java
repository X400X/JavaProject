import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        runner.finished();
    }
}

class Runner {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while(true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) return;
                if (firstLockTaken) lock1.unlock();
                if (secondLockTaken) lock2.unlock();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();

        for(int i = 0; i < 10000; i++) {
            takeLocks(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();

        for(int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);

            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalans());
        System.out.println(account2.getBalans());
        System.out.println("Total balance " + (account1.getBalans() + account2.getBalans()));

    }
}

class Account {
    private int balans = 10000;

    public void deposit(int acount) {
        balans += acount;
    }

    public void withdraw(int acount) {
        balans -= acount;
    }

    public int getBalans() {
        return balans;
    }

    public  static void transfer(Account ac1, Account ac2, int a) {
        ac1.withdraw(a);
        ac2.deposit(a);
    }
}
