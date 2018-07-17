import java.util.Arrays;
import java.util.stream.Collectors;

public class Runner15 {
    public static void main(String[] args) {
        String[] array1 = {"a", "b"};
        String[] array2 = {"1", "2"};
        Arrays.stream(array1)
                .map(arrayA -> Arrays.stream(array2).map(arrayb -> Arrays.asList(arrayA, arrayb))
                        .collect(Collectors.toList())).forEach(System.out::println);

        //FlatMap
    }
}
