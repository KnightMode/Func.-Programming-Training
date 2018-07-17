package immutability;

public class CalculatorMutable {

    private int memory = 0;

    public int add(int a, int b){
        return a + b;
    }

    public int addWithMemory(int number) {
        memory += number;
        return memory;
    }
}
