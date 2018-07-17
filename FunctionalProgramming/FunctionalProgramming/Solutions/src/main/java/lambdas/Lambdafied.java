package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lambdafied {

    Function<Integer, Integer> incrementor = v -> v + 1;
    BiFunction<Integer, Integer, Integer> adder = (v1, v2) -> v1 + v2;
    public int increment(int x) {
        return incrementor.apply(x);
    }

    public int add(int x, int y) {

        return adder.apply(x, y);
    }

    public List<Integer> square(List<Integer> integers) {
        return integers.stream().map(x -> x * x).collect(Collectors.toList());
    }

    /** Intermediate solution 1 **/

//    public int increment(int x) {
//        Incrementor incrementor = new Incrementor() {
//            @Override
//            public int increment(int x) {
//                return x + 1;
//            }
//        };
//        return incrementor.increment(x);
//    }
//
//    public int add(int x, int y) {
//        Adder adder = new Adder() {
//            @Override
//            public int add(int x, int y) {
//                return x + y;
//            }
//        };
//        return adder.add(x, y);
//    }

    /** Intermediate solution 2 **/
//    private interface Incrementor {
//        int increment(int x);
//    }
//
//    private interface Adder {
//        int add(int x, int y);
//    }
//
//    public int increment(int x) {
//        Incrementor incrementor = v -> v + 1;
//        return incrementor.increment(x);
//    }
//
//    public int add(int x, int y) {
//        Adder adder = (v1, v2) -> v1 + v2;
//        return adder.add(x, y);
//    }
}
