package immutability;

public class Calculator {

    private final int memory;

    private Calculator(final int intitalMemory) {
        memory = intitalMemory;
    }

    public Calculator() {
        memory = 0;
    }

    public int add(int a, int b){
        return a + b;
    }

    public Calculator addWithMemory(int number) {
        return new Calculator(add(memory, number));
    }

    public int currentMemory() {
        return memory;
    }
}
