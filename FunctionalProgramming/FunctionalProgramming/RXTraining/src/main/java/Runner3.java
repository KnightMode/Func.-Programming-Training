//Function returing a Function

//Breaking a lambda into nested Lambdas to different scope ....differ the invocation till i give the last parameter,This is called currying on Reshaping the function
//Subsume Factory Methods

import java.util.function.Function;

interface Dependancy {
    String returnValue();
}

class Runner {
    Function<Dependancy, String> retValue() {
        return Dependancy::returnValue;
    }
}

public class Runner3 {
    static Function<Double, Function<Double, Double>> power = (number -> (raiseTo -> Math.pow(number, raiseTo)));
    //static Function<Double, Double> square = power.apply(2.0);
    //static Function<Double, Double> cube = power.apply(3.0);

    public static void main(String[] args) {
        Runner runner = new Runner();
        Dependancy depend = () -> "Hello";
        System.out.println(runner.retValue().apply(depend));
        System.out.println(power.apply(3.0).apply(4.0));
        System.out.println(power.apply(2.0).apply(2.0));
    }
}
