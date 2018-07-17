package immutability;

import java.util.ArrayList;
import java.util.List;

public class CalculatorMemory {

    private List<CalculatorOperation> memory;

    public CalculatorMemory(){
        this.memory = new ArrayList<>();
    }

    public void addToMemory(int number, int result){
        this.memory.add(new CalculatorOperation(number, result));
    }

    public void replay() {
        for(CalculatorOperation operation : memory){
            System.out.println(operation);
        }
    }

    private class CalculatorOperation {
        private final int number;
        private final int result;

        private CalculatorOperation(int number, int result){
            this.number = number;
            this.result = result;
        }

        @Override
        public String toString() {
            return String.format("%d was added and gave the result %d", number, result);
        }
    }

}
