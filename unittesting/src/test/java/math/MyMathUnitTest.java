package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMathUnitTest {
    MyMath myMath = new MyMath();

    @Test(expected = IllegalArgumentException.class)
    public void factorialLowInput() {
        myMath.factorial(-1);
    }
    @Test
    public void primeEdgeCaseTest() {
        // 4 is divisible by 2, and 2 is n / 2 — so this catches the <= boundary
        assertEquals(false, myMath.isPrime(4));
    }

    @Test
    public void factorialCheck() {
        assertEquals(479001600, myMath.factorial(12));
    }

    @Test
    public void factorialZero() {
        assertEquals(1, myMath.factorial(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialHighInput() {
        myMath.factorial(13);
    }

    @Test
    public void primeTest() {
        assertEquals(true, myMath.isPrime(13));
    }

    @Test
    public void nonPrimeTest() {
        assertEquals(false, myMath.isPrime(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkLowInput() {
        myMath.isPrime(1);
    }

    @Test
    public void largePrimeTest() {
        assertEquals(false, myMath.isPrime(999999998));
    }


}
