import java.util.Random;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(() -> {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

            Random random = new Random();
            int randomValue = random.nextInt(10);

            if(randomValue < 5)
                throw new Exception("Something bad happened");

            return randomValue;
        });

        executorService.shutdown();

        try {
            int result = future.get();
            System.out.println(result);
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}


//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Starting");
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Finished");
//                result = 5;
//            }
//        });
//
//        executorService.shutdown();
//
//        try {
//            executorService.awaitTermination(1, TimeUnit.DAYS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(result);
//    }
