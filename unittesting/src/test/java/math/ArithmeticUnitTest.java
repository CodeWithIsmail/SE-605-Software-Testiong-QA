package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticUnitTest {

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

//    @Test(expected =  IllegalArgumentException.class)
//    public void multiplyWithZero() {
//        arithmeticOperations.multiply(10, 0);
//    }
    @Test(expected = IllegalArgumentException.class)
    public void multiplyBothNegative() {
        arithmeticOperations.multiply(-1, -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void multiplySecNegative() {
        arithmeticOperations.multiply(1, -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void multiplyFirstNegative() {
        arithmeticOperations.multiply(-1, -1);
    }

    @Test
    public void testDivide() {
        assertEquals(10.0, arithmeticOperations.divide(100.0, 10.0), 0.00001);
    }

    @Test
    public void testDivideWithNegative() {
        assertEquals(-5.0, arithmeticOperations.divide(10.0, -2.0), 0.00001);
    }

    @Test
    public void testDivideBothNegative() {
        assertEquals(5.0, arithmeticOperations.divide(-10.0, -2.0), 0.00001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideWithZero() {
        arithmeticOperations.divide(10, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void multiplyOverflow() {
        arithmeticOperations.multiply(Integer.MAX_VALUE, 2);
    }
    @Test
    public void testDivideZero() {
        assertEquals(0, arithmeticOperations.divide(0, 10), 0.00001);
    }
//    @Test(expected = IllegalArgumentException.class)
//    public void multiplyBothZero() {
//        arithmeticOperations.multiply(0, 0);
//    }
}
