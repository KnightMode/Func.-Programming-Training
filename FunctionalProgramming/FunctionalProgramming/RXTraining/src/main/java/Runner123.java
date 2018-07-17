import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class Runner123 {
    public static void main(String[] args) {
        String sentence = "All mimsy were the borogroves";
        Function<String, Stream<String>> toWords = sentene -> Arrays.asList(sentene.split(" ")).stream();
        Function<Stream<String>, Stream<String>> filter = words -> words.filter(word -> word.length() < 4);
        Function<Stream<String>,Stream<String>> capitalizedWords = lessThan -> lessThan.map(String::toUpperCase);
        //Function<Stream<String>,String> collector = caps -> (Collectors.toList());

    }
}
