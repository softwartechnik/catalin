package de.softwartechnik.catalin.core.service;

import com.google.common.collect.Maps;
import de.softwartechnik.catalin.core.model.Person;

import java.util.Date;
import java.util.Map;

/**
 * A simple {@link PersonService} that stores all data locally using a {@link Map}.
 */
public class LocalPersonService implements PersonService {

    /**
     * The local person storage.
     */
    private final Map<Long, Person> persons;
    /**
     * The counter to enumerate person ids.
     */
    private long personIdCounter = 0;

    /**
     * Create a new person service with predefined persons.
     *
     * @param persons The persons.
     */
    public LocalPersonService(Map<Long, Person> persons) {

        this.persons = persons;
    }

    /**
     * Create a new person service without any pre defined data.
     */
    public LocalPersonService() {

        this(Maps.newHashMap());
    }

    @Override
    public Person createPerson(String firstName, String lastName, Date birthday) {

        Person person = new Person(personIdCounter++, firstName, lastName, birthday);
        persons.put(person.getId(), person);
        return person;
    }

    @Override
    public Person getPerson(long personId) {

        return persons.get(personId);
    }

    @Override
    public Person removePerson(Person person) {

        boolean remove = persons.values().remove(person);
        return remove ? person : null;
    }
}
