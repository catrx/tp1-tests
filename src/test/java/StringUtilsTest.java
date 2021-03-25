import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv", delimiter = ';')
    @DisplayName("Simple isPalindrome should work")
    void isPalindrome(String string, Boolean expected) {
        boolean test = StringUtils.isPalindrome(string);
        assertEquals(expected, test,
                "Regular isPalindrome does not work");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cesar.csv", delimiter = ';')
    @DisplayName("Simple encodeCesar should work")
    void encodeCesar(String alphabet, int decalage, String expected) {
        String test = StringUtils.encodeCesar(alphabet, decalage);
        assertEquals(expected, test,
                "Regular encodeCesar does not work");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cesar.csv", delimiter = ';')
    @DisplayName("Simple decodeCesar should work")
    void decodeCesar(String expected, int decalage, String encode) {

        String test = StringUtils.decodeCesar(encode, decalage);
        assertEquals(expected, test,
                "Regular decodeCesar does not work");
    }

    @Test
    @DisplayName("Capitalize method test")
    void capitalize() {
        String expected = "Lol";
        String capitalize = StringUtils.capitalize("lol");

        assertEquals(expected, capitalize, "Capitalize does not work");
    }
}
