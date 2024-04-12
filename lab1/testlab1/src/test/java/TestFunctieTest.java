import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFunctieTest {
    @Test
    void testAbsoluut() {
        int output = TestFunctie.absoluut(-2);
        assertEquals(2, output);

    }
}