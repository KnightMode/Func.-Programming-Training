public class SubClass implements IHandler {

    private IHandler iHandler;

    @Override
    public void setNextChain(IHandler iHandler) {
        this.iHandler = iHandler;
    }

    @Override
    public void calculate(Numbers numbers) {
        if (numbers.getOperation().equalsIgnoreCase("Sub"))
            System.out.println(numbers.getN1() - numbers.getN2());
        else
            System.out.println("Operation not supported");
    }
}
