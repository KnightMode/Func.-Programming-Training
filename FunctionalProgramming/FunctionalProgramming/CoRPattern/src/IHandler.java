public interface IHandler {
    public void setNextChain(IHandler iHandler);
    public void calculate(Numbers numbers);
}
