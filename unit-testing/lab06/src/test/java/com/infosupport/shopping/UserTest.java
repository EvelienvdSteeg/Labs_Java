package com.infosupport.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void user_withData_hasFunctionalGetters() {
        var sut = new User("foo", LocalDate.of(2010, 1, 1), "123");
        assertEquals("foo", sut.name());
        assertEquals(LocalDate.of(2010, 1, 1), sut.dateOfBirth());
    }

    @Test
    public void user_birthDate18YearsAgo_hasAge18() {
        var now = LocalDate.now();
        var sut = new User("foo", now.withYear(now.getYear() - 18), "123");
        assertEquals(18, sut.getAge());
    }

}
