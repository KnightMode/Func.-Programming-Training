import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Runner34 {
    static int expensiveSquare(int x) {
        try {
            //Thread.sleep(500);
            System.out.println(Thread.currentThread() + "Expensive square op------");
            //throw new RuntimeException("Errrr");
            return x * x;
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

//    static CompletableFuture<String> expensiveString(Integer x) {
//        try {
//            //Thread.sleep(1000);
//            System.out.println(Thread.currentThread() + "Expensive square op------");
//            CompletableFuture<String> future = new CompletableFuture<String>();
//            Thread.sleep(2000);
//
//            //return x * x;
//        } catch (Exception e) {
//            throw new RuntimeException("Error");
//        }
//    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        System.out.println(Thread.currentThread());
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + "Supply Async on:");
            return expensiveSquare(2);
        }, forkJoinPool);

        System.out.println("Fired Request on:" + Thread.currentThread());
        future.thenApply(x -> x * 100)
                .exceptionally(t -> -1)
                .thenAccept(x -> System.out.println(Thread.currentThread() + " " + x));
        System.out.println("DONE");
    }
}
