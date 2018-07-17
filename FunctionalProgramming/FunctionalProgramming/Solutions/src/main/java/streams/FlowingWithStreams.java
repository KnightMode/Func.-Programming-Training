package streams;

import javax.naming.NamingException;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlowingWithStreams {

    public List<Integer> firstNaturals(int howMany) {
        return naturals(1, howMany).collect(Collectors.toList());
    }

    private Stream<Integer> naturals(int from, int howMany) {
        return Stream.iterate(from, x -> x + 1).limit(howMany);
    }

    public void random(int howMany) {
        Stream.generate( () -> Math.random()).limit(howMany).forEach(System.out::println);
    }
    public List<List<Integer>> pythoGoreans(int howMany) {
        return naturals(1, howMany)
                .flatMap( x -> naturals(1, howMany)
                                .flatMap( y -> naturals(1, howMany)
                                .map(z -> Arrays.asList(x,y,z))))
                .filter(items -> {
                    int first = items.get(0);
                    int second = items.get(1);
                    int third = items.get(2);
                    return square(first) +square (second)==square(third);
                }).collect(Collectors.toList());
    }

    static int square(int x){
        return x*x;
    }
}
