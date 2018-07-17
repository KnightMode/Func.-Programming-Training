package HOF;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


public class SimpleHOF {


    static final Function<Integer, Integer> calcsum = n -> {
        if (n == 0)
            return 0;
        return n + SimpleHOF.calcsum.apply(n - 1);
    };

    //Rent
    public static Function<Integer, Integer> chennaiRent = sqft -> ((15 * sqft) + 500);

    public static Function<Integer, Integer> bengaluruRentFunction = sqft -> ((12 * sqft) + 200);

    public static Function<Integer, Integer> mumbaiRentFunction = sqft -> ((30 * sqft) + 300);

    public static Function<Integer, Integer> delhiRentFunction = sqft -> ((30 * sqft) + 1000);

    //Grocery
    public static Function<Integer, Integer> chennaiGroceryFunction = nop -> ((1000 * nop) + 200);

    public static Function<Integer, Integer> bengaluruGroceryFunction = nop -> ((1200 * nop) - 200);

    public static Function<Integer, Integer> mumbaiGroceryFunction = nop -> ((1100 * nop) + 300);

    public static Function<Integer, Integer> delhiGroceryFunction = nop -> ((1500 * nop) - 1000);

//    public static BiFunction<Integer, Integer, Integer> chennaiCoL = (x, y) -> {
//        return SimpleHOF.chennaiRent.apply(x) + SimpleHOF.chennaiGroceryFunction.apply(y);
//    };
//
//    public static BiFunction<Integer, Integer, Integer> BengaluruCoL = (x, y) -> {
//        return SimpleHOF.chennaiRent.apply(x) + SimpleHOF.chennaiGroceryFunction.apply(y);
//    };
//
//    public static BiFunction<Integer, Integer, Integer> mumbaiCoL = (x, y) -> {
//        return SimpleHOF.chennaiRent.apply(x) + SimpleHOF.chennaiGroceryFunction.apply(y);
//    };
//
//    public static BiFunction<Integer, Integer, Integer> delhiCoL = (x, y) -> {
//        return SimpleHOF.chennaiRent.apply(x) + SimpleHOF.chennaiGroceryFunction.apply(y);
//    };
//
//    public static BiFunction<String, Integer, Integer> rentFor = (cityName, sqft) -> {
//        switch (cityName) {
//            case "Chennai":
//                return SimpleHOF.chennaiRent.apply(sqft);
//            case "Mumbai":
//                return SimpleHOF.mumbaiRentFunction.apply(sqft);
//            case "Delhi":
//                return SimpleHOF.mumbaiRentFunction.apply(sqft);
//            case "Bengaluru":
//                return SimpleHOF.mumbaiRentFunction.apply(sqft);
//            default:
//                return 0;
//        }
//    };
//    public static BiFunction<String, Integer, Integer> groceryFor = (cityname, nop) -> {
//        switch (cityname) {
//            case "Chennai":
//                return SimpleHOF.chennaiGroceryFunction.apply(nop);
//
//            case "Delhi":
//                return SimpleHOF.chennaiGroceryFunction.apply(nop);
//
//            case "Mumbai":
//                return SimpleHOF.chennaiGroceryFunction.apply(nop);
//
//            case "Bengaluru":
//                return SimpleHOF.chennaiGroceryFunction.apply(nop);
//            default:
//                return 0;
//        }
//    };

//    public static BiFunction<String, Pair<Integer, Integer>, Integer> CoL = (city, bundle) -> {
//        return rentFor.apply(city, bundle.getValue()) + groceryFor.apply(city, bundle.getValue());
//    };

    public static final Map<String, Function<Integer, Integer>> rentFunctions;

    public static final Map<String, Function<Integer, Integer>> groceryFunctions;

    static {
        rentFunctions = new HashMap<>();
        rentFunctions.put("Chennai", chennaiRent);
        rentFunctions.put("Bengaluru", bengaluruRentFunction);
        rentFunctions.put("Mumbai", mumbaiRentFunction);
        rentFunctions.put("Delhi", delhiRentFunction);

        groceryFunctions = new HashMap<>();
        groceryFunctions.put("Chennai", chennaiGroceryFunction);
        groceryFunctions.put("Bengaluru", bengaluruGroceryFunction);
        groceryFunctions.put("Mumbai", mumbaiGroceryFunction);
        groceryFunctions.put("Delhi", delhiGroceryFunction);
    }

    public static BiFunction<String, Integer, Integer> rentFunc = (cityname, size) -> rentFunctions.get(cityname).apply(size);
    public static BiFunction<String, Integer, Integer> groceryFunc = (cityname, nop) -> groceryFunctions.get(cityname).apply(nop);
}