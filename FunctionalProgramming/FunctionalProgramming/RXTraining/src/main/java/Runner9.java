import java.util.function.Supplier;

class Eager<T> {
    private final T value;

    Eager(T value) {
        System.out.println("INSIDE EAGER...");
        this.value = value;
    }

    T get() {
        System.out.println("Returning Eager");
        return value;
    }
}

class Lazy<T> {
    private final Supplier<T> supplier;

    Lazy(Supplier<T> supplier) {
        System.out.println("Inside Lazy");
        this.supplier = supplier;
    }

    T get() {
        System.out.println("Redirect to static method....");
        return supplier.get();
    }
}

public class Runner9 {
    public static void main(String[] args) {
        //Eager<Double> eagerVal = new Eager<>(twice(2.0));
        Lazy<Double> lazyVal = new Lazy<>(() -> twice(2.0));
        //System.out.println(eagerVal.get());
        System.out.println("*****Lazy Eval******");
        System.out.println(lazyVal.get());
    }

    private static Double twice(double v) {
        System.out.println("Inside Twice");
        return 2 * v;
    }
}
