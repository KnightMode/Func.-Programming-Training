package immutability;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CalculatorImmutable {

    private final int lastResult;

    public CalculatorImmutable() {
        this(0);
    }

    public CalculatorImmutable(int memory){
        this.lastResult = memory;
    }

    public CalculatorImmutable add(int a, int b){
        return new CalculatorImmutable(a+b);
    }

    public CalculatorImmutable addWithMemory(int val) {
        return new CalculatorImmutable(lastResult + val);
    }

    public  CalculatorImmutable addWithReplay(int val, CalculatorMemory memory){
        memory.addToMemory(val, this.lastResult+ val);
        return new CalculatorImmutable(lastResult + val);
    }

    public boolean hasLastResult(int val) {
        return lastResult == val;
    }
}
