import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Runner11 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1)
                .limit(10)
                .peek(x -> System.out.println(Thread.currentThread() + "for" + x));

        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        System.out.println(forkJoinPool);
    }
}
