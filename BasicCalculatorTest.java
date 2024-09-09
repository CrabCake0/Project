import org.junit.jupiter.api.Test;
import java.util.Arrays;
import javax.accessibility.AccessibleRelationSet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {

    @Test
    void testBasicOperations() {
        BasicCalculator calculator = new BasicCalculator();
        
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3));
        assertEquals(1.0, calculator.calculate(Operation.SUBTRACT, 3, 2));
        assertEquals(6.0, calculator.calculate(Operation.MULTIPLY, 2, 3));
        assertEquals(2.0, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    void testChainingOperations() {
        BasicCalculator calculator = new BasicCalculator();
        Number result = calculator.chain(5, Arrays.asList(
            new CalculationStep(Operation.ADD, 3),
            new CalculationStep(Operation.MULTIPLY, 2)
        ));
        
        assertEquals(16.0, result);
    }

    @Test
    void testDivisionByZero() {
        BasicCalculator calculator = new BasicCalculator();
        
        assertThrows(ArithmeticException.class, () -> calculator.calculate(Operation.DIVIDE, 1, 0));
    }

    @Test
    void testUnsupportedOperation() {
        BasicCalculator calculator = new BasicCalculator();
        
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(Operation.valueOf("MOD"), 1, 2));
    }
}