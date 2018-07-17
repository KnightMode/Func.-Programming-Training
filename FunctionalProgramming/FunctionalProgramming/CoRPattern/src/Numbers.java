public class Numbers {
    private Integer n1, n2;
    private String operation;

    public Numbers(Integer n1, Integer n2, String operation) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
    }

    public Integer getN1() {
        return n1;
    }

    public Integer getN2() {
        return n2;
    }

    public String getOperation() {
        return operation;
    }
}
