package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.PersonRepository;

import javax.inject.Inject;
import java.util.Date;

public class CatalinPersonService implements PersonService {

    private final PersonRepository personRepository;

    @Inject
    public CatalinPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(String firstName, String lastName, Date birthday) {

        Person person = new Person(firstName, lastName, birthday);
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(long personId) {

        return personRepository.find(personId);
    }

    @Override
    public Person removePerson(Person person) {

        personRepository.remove(person);
        return person;
    }
}
