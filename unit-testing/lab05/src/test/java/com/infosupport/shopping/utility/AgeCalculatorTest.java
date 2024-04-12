package com.infosupport.shopping.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AgeCalculatorTest {

    @Test
    public void calculate_referenceIsBeforeDateOfBirth_throwsArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> AgeCalculator.calculate(LocalDate.MAX, LocalDate.MIN));
    }

    @Test
    public void calculate_oneMonthBefore32ndBirthDate_returns31() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 8, 27));
        assertEquals(31, age);
    }

    @Test
    public void calculate_dayBefore32ndBirthDate_returns31() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 9, 26));
        assertEquals(31, age);
    }

    @Test
    public void calculate_on32ndBirthDay_returns32() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 9, 27));
        assertEquals(32, age);
    }

    @Test
    public void calculate_oneMonthAfter32ndBirthDay_returns32() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 10, 27));
        assertEquals(32, age);
    }

    @Test
    public void constructor_whenCalled_throwsError() {
        var actualException = assertThrows(InvocationTargetException.class, () -> {
            var constructor = AgeCalculator.class.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            constructor.newInstance((Object[]) null);
        });
        assertInstanceOf(InstantiationException.class, actualException.getTargetException());
        assertEquals("Instances of com.infosupport.shopping.utility.AgeCalculator are forbidden.",
                actualException.getTargetException().getMessage());
    }

}
