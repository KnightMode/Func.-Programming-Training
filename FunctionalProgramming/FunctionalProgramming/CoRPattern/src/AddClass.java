public class AddClass implements IHandler {

    private IHandler iHandler;

    @Override
    public void setNextChain(IHandler iHandler) {
        this.iHandler = iHandler;
    }

    @Override
    public void calculate(Numbers numbers) {
        if (numbers.getOperation().equalsIgnoreCase("add"))
            System.out.println(numbers.getN1() + numbers.getN2());
        else
            iHandler.calculate(numbers);
    }
}
