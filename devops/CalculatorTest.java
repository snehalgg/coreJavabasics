package devops;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        int result = calculator.add(5, 7);
        assertEquals(12, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 3);
        assertEquals(7, result);
    }

    @Test
    public void testMultiplication() {
        int result = calculator.multiply(6, 8);
        assertEquals(48, result);
    }

    @Test
    public void testDivision() {
        double result = calculator.divide(15, 3);
        assertEquals(5.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }
}
