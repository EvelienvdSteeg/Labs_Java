package com.infosupport.shopping.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AgeCalculatorTest {

    @Test
    public void Calculate_ReferenceIsBeforeDateOfBirth_ThrowsArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> AgeCalculator.calculate(LocalDate.MAX, LocalDate.MIN));
    }

    @Test
    public void Calculate_OneMonthBefore32ndBirthDate_Returns31() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 8, 27));
        assertEquals(31, age);
    }

    @Test
    public void Calculate_DayBefore32ndBirthDate_Returns31() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 9, 26));
        assertEquals(31, age);
    }

    @Test
    public void Calculate_On32ndBirthDay_Returns32() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 9, 27));
        assertEquals(32, age);
    }

    @Test
    public void Calculate_OneMonthAfter32ndBirthDay_Returns32() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 10, 27));
        assertEquals(32, age);
    }

}
