package lambdas;

import java.util.function.BiFunction;

public class Lambdafied {

    private interface Incrementor {
        int increment(int x);
    }

    private interface Calculation<T, U, V> {
        V calc(T x, U y);
    }

    public int increment(int x) {
        Incrementor incrementor = x1 -> x1 + 1;
        return incrementor.increment(2);
    }

    private interface Adder {
        public int add(int x, int y);
    }

    public int addnos() {
        Adder adder = (x, y) -> x + y;
        return adder.add(3, 5);
    }

    private interface Subtracter {
        public int sub(int x, int y);
    }

    BiFunction<Integer,Integer, Integer> adder = (x,y) -> x+y;

    Subtracter subtracter = (x, y) -> x - y;

    public int subtractNumbers(int x, int y) {
        return subtracter.sub(x, y);
    }
}
