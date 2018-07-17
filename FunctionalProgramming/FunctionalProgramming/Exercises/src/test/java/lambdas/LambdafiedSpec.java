package lambdas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LambdafiedSpec {
    private final Lambdafied lambdas = new Lambdafied();

    // 1. Create an instance of Incrementor and use it in this place
    // 2. Replace them with lambda
    @Test
    public void incrementBy1(){
        assertThat(lambdas.increment(5)).isEqualTo(6);
    }

    // 3. Create an adder similar to the incrementor and use it here
    // 4. Replace them with lambda
//    @Test
//    public void addTwoNumbersReturnsTheSum(){
//        assertThat(lambdas.add(5, 6)).isEqualTo(11);
//    }
//
//    @Test
//    public void subtractTwoNumbersAndReturnTheSame() {
//        assertThat(lambdas.subtractNumbers()).isEqualTo(1);
//    }

    /** Nice to do **/
    // 5. Create a list of integers. And square each element in the list
}
