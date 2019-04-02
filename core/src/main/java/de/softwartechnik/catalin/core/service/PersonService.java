package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Person;

import java.util.Date;

public interface PersonService {

    /**
     * Create and persist a new person.
     *
     * @param firstName The first name.
     * @param lastName  The last name.
     * @param birthday  The birthday.
     *
     * @return The created person with an assigned id.
     */
    Person createPerson(String firstName, String lastName, Date birthday);

    /**
     * Get a person by its unique id.
     *
     * @param personId The id.
     *
     * @return The person.
     */
    Person getPerson(long personId);

    /**
     * Delete the given person.
     *
     * @return The deleted person.
     */
    Person removePerson(Person person);
}
