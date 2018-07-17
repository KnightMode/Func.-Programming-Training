import java.util.Random;
import java.util.function.Function;

public class Runner4 {
    static Function<Integer, Integer> random = max -> new Random().nextInt(max) + 1;

    static String names(String... names) {
        return names[random.apply(names.length) - 1];
    }

    public static void main(String[] args) {
        System.out.println(names("Brahma", "Mahesh", "Vishnu"));
        System.out.println(names("HEADS", "TAILS"));
    }
}
