
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("To jest klasa testowa")
public class JunitTest {

    @RepeatedTest(2)
    @Test
    @DisplayName("To jest pierwszy test")
    public void firstTest() {
        System.out.println(0.2 * 0.2);
     //   assertTrue((0.2 * 0.2) == 0.04);
       assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue()==0.04);
    }

    String testowyString="testowyString";


    @BeforeEach
    void before() {
        System.out.println("Before==========================================");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll==========================================");
    }


    @Test
    public void testStringa() {
        assertEquals("testowyString", testowyString);

        assertThat(testowyString, containsString("Strin"));
        assertThat(testowyString, equalTo( "testowyString"));
        assertThat(testowyString, endsWith("ing"));
    }

    @AfterEach
    void after() {
        System.out.println("After==========================================");
    }

}