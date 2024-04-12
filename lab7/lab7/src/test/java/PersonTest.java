import Persons.Gender;
import Persons.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPerson() {
        Person p = new Person();
        p.setName("Jan");
        p.setAge(45);
        assertEquals(Gender.UNKNOWN, p.getGender());
        p.setGender(Gender.MALE);
        assertEquals(Gender.MALE, p.getGender());
        p.haveBirthday(); // person gets one year older
        assertEquals(46,  p.getAge());
        assertEquals("All humans are created equal", Person.universalRights());
    }

}