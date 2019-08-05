package one;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testExamplesOfUsage() {
        assertEquals(64, 2 * 32);
        assertEquals("Tom", "Tom");
        assertTrue("Tom".startsWith("T"));
        assertFalse(9 != 9);
    }

    @Test
    public void testAddFirst5Seconds3Returns8() {
        Calculator calculator = new Calculator();

        int actual = calculator.add(5, 3);
        int expected = 8;
        assertTrue(actual == expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddFirst3Seconds5Returns8() {
        Calculator calculator = new Calculator();

        int actual = calculator.add(3, 5);
        int expected = 8;
        assertTrue(actual == expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddFirstNegativeBiggerSecondPositiveSmallerReturnsNegative() {
        Calculator calculator = new Calculator();
        int actual = calculator.add(-5, 3);
        int expected = -2;
        assertTrue(actual == expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testDivideFirst4Second2Returns2() {
        Calculator calculator = new Calculator();
        int actual = calculator.divide(4, 2);
        int expected = 2;
        assertTrue(actual == expected);
        assertEquals(expected, actual);

    }

    @Test
    public void testDivideFirst2Second4Returns0() {
        Calculator calculator = new Calculator();
        int actual = calculator.divide(2, 4);
        int expected = 0;
        assertTrue(actual == expected);
        assertEquals(expected, actual);

    }

    @Test
    public void testDivideFirst0Second4Returns0() {
        Calculator calculator = new Calculator();
        int actual = calculator.divide(0, 4);
        int expected = 0;
        assertTrue(actual == expected);
        assertEquals(expected, actual);

    }

    @Test (expected = ArithmeticException.class)
    public void testDivideFirst2Second0Returns0 (){
        Calculator calculator = new Calculator();
        calculator.divide(2,0);
    }

    @Test
    @Ignore
    public void name() {
    }
}
