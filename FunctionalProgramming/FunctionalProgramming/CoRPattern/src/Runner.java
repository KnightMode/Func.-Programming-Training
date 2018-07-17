public class Runner {
    public static void main(String[] args) {
        Numbers numbers = new Numbers(4, 5, "sub");
        IHandler addClass = new AddClass();
        IHandler subClass = new SubClass();
        addClass.setNextChain(subClass);
        addClass.calculate(numbers);
    }
}
