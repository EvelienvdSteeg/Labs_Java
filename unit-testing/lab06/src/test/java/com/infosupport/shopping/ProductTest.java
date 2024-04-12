package com.infosupport.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void product_withData_hasFunctionalGetters() {
        var sut = new Product("Cowboy doll", BigDecimal.TEN);
        assertEquals("Cowboy doll", sut.name());
        assertEquals(BigDecimal.TEN, sut.price());
    }
}
