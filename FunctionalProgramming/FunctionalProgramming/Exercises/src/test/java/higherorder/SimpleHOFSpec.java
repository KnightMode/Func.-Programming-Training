package higherorder;

import HOF.SimpleHOF;
import javafx.util.Pair;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleHOFSpec {

    SimpleHOF simpleHOF = new SimpleHOF();
    // 1. Implement Sigma
    //    @Test
    //    public void ableToCalculateSigma() {
    //        assertThat(SimpleHOF.calcSigma(5)).isEqualTo(15);
    //    }

    //2.House Rent Calculator
    @Test
    public void givenChennaiCalculateRent() {
        assertThat(simpleHOF.chennaiRent.apply(1000)).isEqualTo(15500);
    }

    @Test
    public void givenBengaluruCalculateRent() {
        assertThat(simpleHOF.bengaluruRentFunction.apply(1000)).isEqualTo(12200);
    }

    @Test
    public void givenDelhiCalculateRent() {
        assertThat(simpleHOF.delhiRentFunction.apply(1000)).isEqualTo(31000);
    }

    @Test
    public void givenMumbaiCalculateRent() {
        assertThat(simpleHOF.mumbaiRentFunction.apply(1000)).isEqualTo(30300);
    }

    @Test
    public void ableToCalculateGroceryinChennai() {
        assertThat(simpleHOF.chennaiGroceryFunction.apply(2)).isEqualTo(2200);
    }

    @Test
    public void ableToCalculateGroceryinBengaluru() {
        assertThat(simpleHOF.bengaluruGroceryFunction.apply(2)).isEqualTo(2200);
    }

//    @Test
//    public void ableToCalculateGroceryinMumbai() {
//        assertThat(simpleHOF.mumbaiGroceryFunction.apply(2)).isEqualTo(360);
//    }

    @Test
    public void ableToCalculateGroceryinDelhi() {
        assertThat(simpleHOF.delhiGroceryFunction.apply(2)).isEqualTo(2000);
    }

//    @Test
//    public void abletoCalculateExpensesinMumbai() {
//        assertThat(simpleHOF.chennaiCoL.apply(1000,10)).isEqualTo(25700);
//    }
//
//    @Test
//    public void abletoCalculateRentForAGivenCity() {
//        assertThat(simpleHOF.rentFor.apply("Chennai",1000)).isEqualTo(15500);
//    }

   // @Test
//    public void abletoCalculateGroceriesForAGivenCity() {
//        assertThat(simpleHOF.groceryFor.apply("Chennai",2)).isEqualTo(2200);
//    }
//
//    @Test
//    public void ableToCalculateCostofLivingforAGivenCity() {
//        assertThat(simpleHOF.CoL.apply("Chennai",new Pair<Integer,Integer>(1000,10))).isEqualTo(25700);
//    }

//    @Test
//    public void calcRentForAGivenCity() {
//        assertThat()
//    }
}
