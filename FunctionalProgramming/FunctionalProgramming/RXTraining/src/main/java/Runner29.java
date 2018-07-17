import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Runner29 {
    static Double capitalize(String s) throws Exception {
        if (null == s)
            throw new Exception("Wrong Ticker Value");
        return 100.0;
    }

    interface FuncThrowsException<T, R, E extends Throwable> {
        R apply(T t) throws E;
    }

    static class Try {
        static <T, R> Function<T, R> with(FuncThrowsException<T, R, Throwable> fte) {
            return t -> {
                try {
                    return fte.apply(t);
                } catch (Throwable e) {
                    //throw new RuntimeException("Not found");
                    throw new RuntimeException(e);
                }
            };
        }
    }

    public static void main(String[] args) {
        List<Double> prices = Stream.of("AAPL", null, "YAHOO").collect(ArrayList::new, (acc, ticker) -> {
            Double price = Try.with(Runner29::capitalize).apply(ticker);
            acc.add(price);
        }, ArrayList::addAll);
        System.out.println(prices);
    }
}
