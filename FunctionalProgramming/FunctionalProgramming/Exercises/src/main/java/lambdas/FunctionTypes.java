package lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTypes {

    public void greet(int times) {
//        for (int i = 0; i < times; i++) {//Mutability violation
//            System.out.print("Hello");
        // }
        //}
        if (times == 0)
            return;
        System.out.println("Test");
        greet(times - 1);
    }

    static final Function<Integer, Integer> factorial = integer -> {
        if (integer == 0)
            return 1;
        return integer * FunctionTypes.factorial.apply(integer - 1);
    };

//    static final BiFunction<Integer,Integer,Integer> tailRecursion = (integer, integer2) -> {
//      return FunctionTypes.factorial.
//    };

    Function<Double, Double> cubeit = (x) -> Math.pow(x, 3);
    Function<Double, Double> squareit = (x) -> Math.pow(x, 2);

    BiFunction<Double, Double, Double> raisethis = (x, y) -> Math.pow(x, y);

    public Double raisepower(int x, int y) {
        return raisethis.apply(3.0, 2.0);
    }

    public int Factorial(int n) {
        return factorial.apply(n);
    }
}

