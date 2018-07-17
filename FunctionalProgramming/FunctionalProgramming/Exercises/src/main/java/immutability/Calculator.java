package immutability;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Calculator {

    private final int memory;

    public Calculator(int memory) {
        this.memory = memory;
    }

    public int add(int a, int b) {

        return a + b;
    }

    public int getMemory() {
        return memory;
    }

    public Calculator addWithMemory(int number) {
        return new Calculator(memory + number);
    }

    @Override
    public String toString() {
        return "Memory"+this.getMemory();
    }
}
