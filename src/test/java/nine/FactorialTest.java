package nine;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FactorialTest {

    @Test
    public void testWhen1Then1() {
        int expected = 1;
        int actual = Factorial.calculate(1);
        assertEquals(expected,actual);
    }
    @Test
    public void testWhen2Then2() {
        int expected = 2;
        int actual = Factorial.calculate(2);
        assertEquals(expected,actual);
    }
    @Test
    public void testWhen3Then6() {
        int expected = 6;
        int actual = Factorial.calculate(3);
        assertEquals(expected,actual);
    }
    @Test
    public void testWhen4Then24() {
        int expected = 24;
        int actual = Factorial.calculate(4);
        assertEquals(expected,actual);
    }
    @Test
    public void testWhen5Then120() {
        int expected = 120;
        int actual = Factorial.calculate(5);
        assertEquals(expected, actual);
    }
    @Test(expected = RuntimeException.class)
    public void testLessThan1ThrowsException() {
       Factorial.calculate(0);
    }
}
