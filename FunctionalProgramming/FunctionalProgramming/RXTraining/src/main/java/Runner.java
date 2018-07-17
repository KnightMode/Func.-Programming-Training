//import java.util.Random;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//
//interface TriFunction<T1, T2, T3, R> {
//    R apply(T1 t1, T2 t2, T3 t3);
//}
//interface Linkable {
//
//    Object select (String selector);
//
//    Linkable Nil = new Linkable(){
//        public Object select (String selector){
//            return this;
//        }
//    };
//
//    static Linkable link(Object value, Linkable next){
//        return selector -> {
//            switch (selector) {
//                case "first":
//                    return value;
//                case "next":
//                    return next;
//                default:
//                    return Nil;
//            }
//        };
//    }
//
//    private StringBuilder makeString0(StringBuilder acc,Linkable linkable){
//        if(linkable == Nil){
//            return acc;}
//        Object value = linkable.select("first");//BaseCase is Nil
//        Linkable next = (Linkable) linkable.select("next");
//        return makeString0(acc,next);
//    }
//
//
//    default String makeString() {
//        StringBuilder result = new StringBuilder();
//        makeString0(result,this);
//        return result.toString();
//    }
//}
//
//@FunctionalInterface
//interface Bool {
//    Bool choose(Bool x, Bool y);
//
//    Bool True = (x, y) -> x;
//
//    Bool False = (x, y) -> y;
//
//    Function<Bool, Bool> not = (x) -> x == True ? False : True;
//
//    //Function<Bool,Bool> and = (x,y) -> return other.choose(other.choose(x, y), False);
//}
//
//public class Runner {
//    public static void main(String[] args) {
//
//        //T->R
//        Function<Double, Double> inverse = x -> 1 / x;
//        System.out.println(inverse.apply(2.0));
//        Random random = new Random();
//
//        //()->R
//        Supplier<Integer> rnd = random::nextInt;
//        System.out.println(rnd.get());
//
//        //T->()
//        Consumer<Double> gov = System.out::println;
//        gov.accept(10.0);
//
//        //T->Boolean
//        Predicate<String> yesOrNo = str -> str.equals("yes");
//        System.out.println(yesOrNo.test("yes"));
//
//        //()->()
//        new Thread(() -> System.out.println("RAN")).start();
//
//        TriFunction<Double, Double, Double, Double> add = (x, y, z) -> x + y + z;
//
//        add.apply(3.0, 4.0, 5.0);
//
//        System.out.println(Bool.not.apply(Bool.True));
//
//        System.out.println(Linkable.Nil.makeString());
//    }
//}
