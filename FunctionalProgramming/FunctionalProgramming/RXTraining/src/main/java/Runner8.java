import java.util.Arrays;
import java.util.stream.Stream;

public class Runner8 {
    public static void main(String[] args) {
        String name = "All mimsy were the borogroves and the momeraths";
        StringBuilder capitalizedSentence = new StringBuilder();
        //USING STREAMS
        Arrays.stream(name.split(" "))
                .parallel()
                .filter(c -> c.length() < 4)
                .map(String::toUpperCase)
                .peek(e -> System.out.println(Thread.currentThread()))
                .forEachOrdered(capitalizedWord -> {
                    System.out.println(Thread.currentThread());
                    // capitalizedSentence.append(capitalizedWord).append(" ");
                });
        //.reduce("", (acc, word) -> acc + " " + word);  //Reduce takes in the identity and
        System.out.println("Processors" + Runtime.getRuntime().availableProcessors());
        int sum = Stream.iterate(1, x -> (x + 1)).limit(3).reduce(1, (acc, elem) -> acc * elem);
        System.out.println(sum);
        //System.out.println(result);
    }
}
