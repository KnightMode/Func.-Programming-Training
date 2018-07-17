package immutability;

import org.junit.Ignore;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorSpec {

    private Calculator calculator = new Calculator();


    @Test
    public void addTwoNumbersReturnsTheSum(){
        assertThat(calculator.add(3, 4)).isEqualTo(7);
        assertThat(calculator.add(9, 10)).isEqualTo(19);
        assertThat(calculator.add(3, 4)).isEqualTo(7);
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Ignore("Theis spec is no longer valid for a referrentially transparent Calculator")
    @Test
    public void ableToAddTwoNumbersWithMemory() {
        assertThat(calculator.addWithMemory(2).currentMemory()).isEqualTo(2);
        assertThat(calculator.addWithMemory(5).currentMemory()).isEqualTo(7);
        assertThat(calculator.addWithMemory(7).currentMemory()).isEqualTo(14);
        assertThat(calculator.addWithMemory(2).currentMemory()).isEqualTo(16);
    }

    /**
     * 1. Reimplement the above with immutable Calculator
     **/
    @Test
    public void ableToAddTwoNumbersWithMemoryUsingImmutableCalculator() {
        assertThat(calculator.addWithMemory(2).currentMemory()).isEqualTo(2);
        assertThat(calculator.addWithMemory(2).addWithMemory(5).currentMemory()).isEqualTo(7);
        assertThat(calculator.addWithMemory(2).addWithMemory(5).addWithMemory(7).currentMemory()).isEqualTo(14);
        assertThat(calculator.addWithMemory(2).addWithMemory(5).addWithMemory(7).addWithMemory(2).currentMemory()).isEqualTo(16);
    }

}
