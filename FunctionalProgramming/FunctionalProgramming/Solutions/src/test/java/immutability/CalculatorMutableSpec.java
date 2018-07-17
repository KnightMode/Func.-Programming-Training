package immutability;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorMutableSpec {

    private CalculatorMutable calculator = new CalculatorMutable();


    @Test
    public void addTwoNumbersReturnsTheSum(){
        assertThat(calculator.add(3, 4)).isEqualTo(7);
        assertThat(calculator.add(9, 10)).isEqualTo(19);
        assertThat(calculator.add(3, 4)).isEqualTo(7);
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    public void ableToAddTwoNumbersWithMemory() {
        assertThat(calculator.addWithMemory(2)).isEqualTo(2);
        assertThat(calculator.addWithMemory(5)).isEqualTo(7);
        assertThat(calculator.addWithMemory(7)).isEqualTo(14);
        assertThat(calculator.addWithMemory(2)).isEqualTo(16);
    }


    // Implement the same with immutable objects
    @Test
    public void ableToTwoAddNumbersUsingImmutableCalculator() {
        CalculatorImmutable calculator = new CalculatorImmutable(0);
        assertThat(calculator.add(3, 4)).isEqualTo(new CalculatorImmutable(7));
        assertThat(calculator.add(9, 10)).isEqualTo(new CalculatorImmutable(19));
        assertThat(calculator.add(3, 4)).isEqualTo(new CalculatorImmutable(7));
        assertThat(calculator.add(2, 3)).isEqualTo(new CalculatorImmutable(5));
    }

    @Test
    public void ableToAddNumbersWithMemory() {
        CalculatorImmutable calculator = new CalculatorImmutable();
        assertThat(calculator.addWithMemory(2).hasLastResult(2)).isTrue();
        assertThat(calculator.addWithMemory(5).hasLastResult(5)).isTrue();
        assertThat(calculator.addWithMemory(7).hasLastResult(7)).isTrue();
        assertThat(calculator.addWithMemory(2).hasLastResult(2)).isTrue();


        assertThat(calculator.addWithMemory(2)
                    .addWithMemory(5)
                    .addWithMemory(7)
                    .addWithMemory(2)).isEqualTo(new CalculatorImmutable(16));

    }

    @Test
    public void ableToReplayHistoryOfCalculations() {
        CalculatorMemory memory = new CalculatorMemory();
        CalculatorImmutable calculator = new CalculatorImmutable();
        assertThat(calculator.addWithReplay(2, memory)
                .addWithReplay(5, memory)
                .addWithReplay(7,  memory)
                .addWithReplay(2, memory).hasLastResult(16)).isTrue();

        memory.replay();
    }
}
