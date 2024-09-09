import java.util.List;

interface Calculator {
    Number calculate(Operation operation, Number num1, Number num2);
    Number chain(Number initialValue, List<CalculationStep> steps);
}
