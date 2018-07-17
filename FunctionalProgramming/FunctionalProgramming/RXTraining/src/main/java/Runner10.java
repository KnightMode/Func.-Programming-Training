import java.util.stream.Stream;

public class Runner10 {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4); //Lazy allocation
        integerStream.filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .forEach(System.out::println);
    }
}
