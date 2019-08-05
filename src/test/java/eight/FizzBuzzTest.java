package eight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void testWhen1Then1() {
        String expected = "1";
        String actual = FizzBuzz.print(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testWhen2Then2() {
        String expected = "2";
        String actual = FizzBuzz.print(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testWhen3ThenFizz() {
        String expected = "Fizz";
        String actual = FizzBuzz.print(3);
        assertEquals(expected, actual);
    }

    @Test
    public void testWhen5ThenBuzz() {
        String expected = "Buzz";
        String actual = FizzBuzz.print(5);
        assertEquals(expected, actual);
    }
    @Test
    public void testWhen6ThenFizz() {
        String expected = "Fizz";
        String actual = FizzBuzz.print(6);
        assertEquals(expected, actual);
    }
    @Test
    public void testWhen10ThenBuzz() {
        String expected = "Buzz";
        String actual = FizzBuzz.print(10);
        assertEquals(expected, actual);
    }
    @Test
    public void testWhen15ThenFizzBuzz() {
        String expected = "FizzBuzz";
        String actual = FizzBuzz.print(15);
        assertEquals(expected, actual);
    }
    @Test
    public void testWhen45ThenFizzBuzz() {
        String expected = "FizzBuzz";
        String actual = FizzBuzz.print(45);
        assertEquals(expected, actual);
    }
    @Test(expected = RuntimeException.class)
    public void testWhenLessThan1ThenThrowsException() {
        FizzBuzz.print(0);
    }
    @Test(expected = RuntimeException.class)
    public void testWhenGreaterThan100ThenThrowsException() {
        FizzBuzz.print(101);
    }
}
