package immutability;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSpec {

    @Test
    public void addTwoNumbersReturnsTheSum() {
        Calculator calculator = new Calculator(5);
        int result = calculator.add(2, 3);
    }

    @Test
    public void ableToAddTwoNumbersWithMemory() {
        Calculator calculator = new Calculator(5);

        assertThat(calculator.addWithMemory(3)).isEqualTo(new Calculator(8));
        assertThat(calculator.addWithMemory(6)).isEqualTo(new Calculator(11));
    }

    // Implement the same with immutable objects
    @Test
    public void ableToTwoAddNumbersUsingImmutableCalculator() {

    }

    @Test
    public void ableToAddNumbersWithMemory() {
    }

    @Test
    public void ableToReplayHistoryOfCalculations() {

    }
}
