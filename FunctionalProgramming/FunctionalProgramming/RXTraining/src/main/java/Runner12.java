import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner12 {
    public static void main(String[] args) {
        System.out.println(indexed("All...."));
        System.out.println(factors(37));
        System.out.println(isPrime(5));
        System.out.println(fibonnaci(10));

//        Stream.iterate(1, x -> x + 1)
//                .flatMap(x -> Stream.iterate(1, y -> y + 1)
//                        .flatMap(y -> Stream.iterate(1, z -> z + 1))
//                        .filter(z -> x * x + y * y == z * z)
//                        .collect(Collectors.toList());
////                        .forEach(System.out::println);
//        List<Integer> listofIntegers = Stream.iterate(1, x -> x + 1)
//                .limit(10)
//                .parallel()
//                .min()
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        System.out.println(listofIntegers);
    }

    static List<Integer> factors(int number) {
        return Stream.iterate(1, x -> x + 1)
                .limit(number)
                .filter(x -> number % x == 0)
                .collect(Collectors.toList());
    }

    static Boolean isPrime(int number) {
        return factors(number).size() == 2;
    }

    static List<?> indexed(String str) {
        return Stream.iterate(0, x -> x + 1)
                .limit(str.length())
                .map(n -> Arrays.asList(n, str.charAt(n)))
                .collect(Collectors.toList());
    }

    static List<?> fibonnaci(int number) {
        return Stream.iterate(Arrays.asList(0, 1), list -> {
            int first = list.get(0);
            int second = list.get(1);
            return Arrays.asList(second, first + second);
        }).limit(number)
                .map(list -> list.get(0))
                .collect(Collectors.toList());
    }
}
