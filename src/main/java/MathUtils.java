public final class MathUtils {
    public static double square(double number) {
        return number * number;
    }

    public static boolean isPrime(double number) {
        boolean isPremier = true;
        if (number < 0) {
            isPremier = false;
        } else if (number != 0 && number != 1) {
            for (int i = 2; i <= number/2; i++) {
                if (number != i && number % i == 0) {
                    isPremier = false;
                    break;
                }
            }
        }
        return isPremier;
    }
    static long factorial(int n) throws Exception {
        if(n < 0)
            throw new Exception("C est mort t sous le 0");
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }
}
