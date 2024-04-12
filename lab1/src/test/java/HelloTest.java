import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloTest {
    @Test
    void testOfSomKlopt() {
        int som = Hello.som(2, 4);
        assertEquals(6, som);

    }

}