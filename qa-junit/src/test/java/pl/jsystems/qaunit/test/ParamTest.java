package pl.jsystems.qaunit.test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.jsystems.qajunit.GamePlay;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Paramatrized test")
public class ParamTest {


    @ParameterizedTest
    @DisplayName("First Parametrized test")
    @ValueSource(ints = {0, 15, 25})
    public void paramaterizedTest(int number) {
        assertTrue( number%5 == 0);

    }

    @ParameterizedTest
    @DisplayName("Second Parametrized test")
    @ValueSource(strings = {"Hello", "Hello unit"})
    public void paramaterizedTest(String text) {
        assertTrue( text.contains("Hello"));

    }
    @ParameterizedTest
    @DisplayName("Third Parametrized test")
    @CsvSource(delimiter = ',', value = {"Hello, 5","HelloJunit 5, 15", "'Hello, Jumit 5!', 25"})
    public void param2Test (String param1, int param2) {
        assertTrue( param1.contains("Hello"));
        assertTrue(param2 % 5 ==0);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/test", delimiter = ',')
    public void param3test (String param1, int param2) {
        assertTrue( param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }

    @Test
    public void exceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
            GamePlay.play( 0);
        }
        );
    }
}
