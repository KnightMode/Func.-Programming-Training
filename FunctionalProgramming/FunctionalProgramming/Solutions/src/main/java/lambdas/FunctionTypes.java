package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionTypes {

    public void greet(int times) {
        iterate(times, (x) -> System.out.println("Hello" + x));
        countDownTimer(times);
        System.out.println(factorial(25));
    }

    public double factorial(double value) {
        return factorial(value, 1);
    }

    private double factorial(double value, double acc) {
        if(value <= 1) {
            return acc;
        }
        return factorial(value - 1, value * acc) ;
    }

    public void countDownTimer(int howMuch) {
        iterate(howMuch, (times) -> System.out.println(times));
    }

    private void iterate(int times, Consumer<Integer> c) {
        if(times <= 0) {
            return;
        }
        c.accept(times);
        iterate(times-1, c);
    }

    /** Intermediate solution 1**/
//    public double square(double value) {
//        return Math.pow(value, 2);
//    }
//
//    public double cube(double value) {
//        return Math.pow(value, 3);
//    }
//
//    public double power(double value, double raiseTo) {
//        return Math.pow(value, raiseTo);
//    }

    /** Intermediate solution 2**/
//    public double square(double value) {
//        return power(value, 2);
//    }
//
//    public double cube(double value) {
//        return power(value, 3);
//    }
//
//    public double power(double value, double raiseTo) {
//        return Math.pow(value, raiseTo);
//    }

    BiFunction<Double, Double, Double> power = (value, raiseTo) -> Math.pow(value, raiseTo);
    Function<Double, Double> square = (value) -> power.apply(value, 2d);
    Function<Double, Double> cube = (value) -> power.apply(value, 3d);
}
