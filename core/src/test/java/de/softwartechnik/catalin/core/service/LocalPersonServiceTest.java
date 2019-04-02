package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LocalPersonServiceTest {

    private static final Person TEST_PERSON_LUKE = new Person(1, "Luke", "Skywalker", new Date());
    private static final Person TEST_PERSON_LEIA = new Person(2, "Leia", "Organa", new Date());
    private static final Person TEST_PERSON_ANIKAN = new Person(3, "Anikan", "Skywalker", new Date());

    private static final long TEST_EXPECTED_ID = 0;
    private static final String TEST_FIRSTNAME = "Obi Wan";
    private static final String TEST_LASTNAME = "Kenobi";
    private static final Date TEST_BIRTHDAY = new Date();

    private static Map<Long, Person> PERSONS;

    private PersonService personService;

    @BeforeEach
    void setUp() {

        PERSONS = new HashMap<Long, Person>() {{
            put(TEST_PERSON_LUKE.getId(), TEST_PERSON_LUKE);
            put(TEST_PERSON_LEIA.getId(), TEST_PERSON_LEIA);
            put(TEST_PERSON_ANIKAN.getId(), TEST_PERSON_ANIKAN);
        }};
        personService = new LocalPersonService(PERSONS);
    }

    @Test
    void testCreatePerson() {

        Person person = personService.createPerson(TEST_FIRSTNAME, TEST_LASTNAME, TEST_BIRTHDAY);
        assertEquals(TEST_EXPECTED_ID, person.getId(), "ID should be 0.");
        assertEquals(TEST_FIRSTNAME, person.getFirstName(), "First name doesn't match.");
        assertEquals(TEST_LASTNAME, person.getLastName(), "Last name doesn't match.");
        assertEquals(TEST_BIRTHDAY, person.getBirthday(), "Birthday doesn't match.");

        assertTrue(PERSONS.containsKey(person.getId()), "Persons should contain the new person.");
        assertEquals(4, PERSONS.size(), "There should be four persons now.");
    }

    @Test
    void testGetPerson() {

        Person person = personService.getPerson(TEST_PERSON_LUKE.getId());
        assertNotNull(person, "Loaded person shouldn't be null.");
        assertEquals(TEST_PERSON_LUKE, person, "Loaded person doesn't match.");
    }

    @Test
    void testGetPersonNull() {

        Person person = personService.getPerson(-1);
        assertNull(person, "Person with ID -1 should be null.");
    }

    @Test
    void testRemovePersonNullKey() {

        assertEquals(3, PERSONS.size(), "There should be three persons at the moment");
        Person person = personService.removePerson(null);
        assertNull(person, "Removed person with null key should be null too.");
        assertEquals(3, PERSONS.size(), "There should be three persons at the moment");
    }

    @Test
    void testRemovePerson() {

        assertEquals(3, PERSONS.size(), "There should be three persons at the moment");
        Person person = personService.removePerson(TEST_PERSON_LEIA);
        assertEquals(TEST_PERSON_LEIA, person, "Removed person should be leia.");

        assertFalse(PERSONS.containsKey(TEST_PERSON_LEIA.getId()), "Persons should not contain leia anymore.");
        assertEquals(2, PERSONS.size(), "There should be three persons at the moment");
    }
}
