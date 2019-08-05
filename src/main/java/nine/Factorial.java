package nine;

public class Factorial {
    public static int calculate(int i) {
        if(i<1)
            throw new RuntimeException("The number has to be greater than 0");
        int result = 1;
        for(int j = 1 ; j<=i; j++){
            result = result * j;

        }
        return result;
    }
}
