package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlowingWithStreams {

    public List<Integer> firstNaturals(int howMany) {
        return naturals(howMany).collect(Collectors.toList());
    }

    public Stream<Integer> naturals(int howMany) {
        return Stream.iterate(1, (x) -> x + 1).limit(10);
    }

    public void random(int howMany) {
        Stream.generate(() -> new Random().nextInt()).limit(howMany).forEach(System.out::println);
    }

    public List<List<Integer>> pythoGoreans(int howMany) {
        return naturals(howMany).
                flatMap(x -> naturals(howMany)
                        .flatMap(y -> naturals(howMany).peek(System.out::println).filter(z -> (x * x) + (y * y) == z * z)))
                .map(z -> Arrays.asList(x, y, z))
                .collect(Collectors.toList());
    }

    public void expensiveOp() {
        timer(Arrays.asList(1, 2, 3, 4, 5, 6).stream());
    }

    private void timer(Stream<Integer> stream) {
        long startTime = System.nanoTime();
        stream.map(x -> expensiveSquare(x)).collect(Collectors.toList());
        long timetaken = System.nanoTime() - startTime;
        System.out.println("Time taken " + timetaken / 1000 + " nano seconds");
    }

    private int expensiveSquare(int x) {
        try {
            Thread.sleep(x * 100);
        } catch (Exception e) {
        }
        int square = x * x;
        System.out.println("Square called. Result:" + square);
        return square;
    }

    public void a1B2() {
        Arrays.stream(new String[]{"A", "B"})
                .flatMap(str -> Arrays.stream(new Integer[]{1, 2})
                        .map(integer -> Arrays.asList(str, x)))
                .forEach(x -> System.out.println(x));
    }
}
