public class CalculationStep {
    private Operation operation;
    private Number number;

    public CalculationStep(Operation operation, Number number) {
        this.operation = operation;
        this.number = number;
    }

    public Operation getOperation() {
        return operation;
    }

    public Number getNumber() {
        return number;
    }
}
