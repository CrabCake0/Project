import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicCalculator implements Calculator {
    
    private final Map<Operation, CalculationStrategy> strategies = new HashMap<>();

    public BasicCalculator() {
        // Register default strategies
        strategies.put(Operation.ADD, (num1, num2) -> num1.doubleValue() + num2.doubleValue());
        strategies.put(Operation.SUBTRACT, (num1, num2) -> num1.doubleValue() - num2.doubleValue());
        strategies.put(Operation.MULTIPLY, (num1, num2) -> num1.doubleValue() * num2.doubleValue());
        strategies.put(Operation.DIVIDE, (num1, num2) -> {
            if (num2.doubleValue() == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }
            return num1.doubleValue() / num2.doubleValue();
        });
    }

    @Override
    public Number calculate(Operation operation, Number num1, Number num2) {
        if (!strategies.containsKey(operation)) {
            throw new UnsupportedOperationException("Operation not supported.");
        }
        return strategies.get(operation).calculate(num1, num2);
    }

    @Override
    public Number chain(Number initialValue, List<CalculationStep> steps) {
        Number result = initialValue;
        for (CalculationStep step : steps) {
            result = calculate(step.getOperation(), result, step.getNumber());
        }
        return result;
    }

    public void addOperation(Operation operation, CalculationStrategy strategy) {
        strategies.put(operation, strategy);
    }
}