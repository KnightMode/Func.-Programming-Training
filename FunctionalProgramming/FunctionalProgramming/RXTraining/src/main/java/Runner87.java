import java.util.function.Function;

public class Runner87 {
    static <T, U, R> Function<T, R> compose(Function<T, U> f, Function<U, R> g) {
        return x -> g.apply(f.apply(x));
    }

    public static void main(String[] args) {
        Function<Double, Double> square = x -> x * x;
        Function<Double, Double> cube = x -> Math.pow(x,3);
        //System.out.println(compose(s));
    }
}
