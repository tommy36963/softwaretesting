package eight;

public class FizzBuzz {
    public static String print(int i) {
        if (i < 1 || i > 100) {
            throw new RuntimeException("Input range is 1-100");
        }

        if (i % 15 == 0) {
            return "FizzBuzz";
        }

        if (i % 3 == 0) {
            return "Fizz";

        } else if (i % 5 == 0) {
            return "Buzz";
        }
        return Integer.toString(i);
    }
}
