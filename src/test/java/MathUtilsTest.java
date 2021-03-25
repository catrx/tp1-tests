import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;



import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @DisplayName("Simple square should work")
    @ParameterizedTest
    @ValueSource(ints = {1, -3, 5})
    void square(double number) {
        double test = MathUtils.square(number);
        assertEquals(number * number, test,
                "Regular square should work");

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/is-prime.csv", delimiter = ';')
    @DisplayName("Simple isPrime should work")
    void isPrime(int number, boolean expected) {
        boolean test = MathUtils.isPrime(number);
        assertEquals(expected, test,
                "Regular square should work");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/factorial.csv", delimiter = ';')
    @DisplayName("Simple facto should work")
    void factorial(int number, long expected) throws Exception {
        long test = MathUtils.factorial(number);
        assertEquals(expected, test,
                "Regular factorial should work");
    }

    @Test
    @DisplayName("Simple facto exo2 should work")
    void factorialDeux() throws Exception {
        String actualMessage = "C est mort t sous le 0";
        int prime = -2;
        Exception exception = assertThrows(Exception.class, ()-> MathUtils.factorial(prime));
        assertTrue(actualMessage.contains(exception.getMessage()));
    }

}
