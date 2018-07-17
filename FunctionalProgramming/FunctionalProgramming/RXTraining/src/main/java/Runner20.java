import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner20 {
    public static void main(String[] args) {
        Random random = new Random();
        Stream.iterate(1, x -> x + 1)
                .limit(3)
                .flatMap(playerNumber ->
                        Stream.generate(random::nextInt).limit(1)
                                .map(diceThrow -> Arrays.asList(diceThrow, playerNumber)))
                .collect(Collectors.toList());
    }
}
