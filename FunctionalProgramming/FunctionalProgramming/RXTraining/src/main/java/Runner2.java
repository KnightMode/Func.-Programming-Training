//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//
////for loop implementation in FP
////For getting the current Index use the Consumer to pass the Sysout Block
////subsume if then else -> Predicate , RUmmable,Runnable
//public class Runner2 {
//    //T->()
//    private static void iterate(int howMany, Predicate<Integer> condition, Function<Integer, Integer> incDec, Consumer<Integer> block) {
//        if (condition.test(howMany))
//            return;
//        block.accept(howMany);
//        iterate(incDec.apply(howMany), condition, incDec, block);
//    }
//
//    public static void main(String[] args) {
//        iterate(1, i -> i > 5, i -> i + 1, (i) -> System.out.println("Hello" + i));  //logic of splitting is not clients concern and hence encapsulation,Declarative style of Prog.
//    }
//}
