package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticUnitTesting {

    ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    @Test
    public void testMultiply() {
        assertEquals(100, arithmeticOperations.multiply(10, 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMUltiplyWithSingleNegative() {
        arithmeticOperations.multiply(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMUltiplyWithBothNegative() {
        arithmeticOperations.multiply(-10, -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void largeNumber() {
        arithmeticOperations.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void multiplyWithZero(){
        assertEquals(0, arithmeticOperations.multiply(10, 0));
    }
}
