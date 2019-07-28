package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.PersonRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.flogger.Flogger;

@Flogger
public class CatalinPersonService implements PersonService {

  private final PersonRepository personRepository;

  @Inject
  public CatalinPersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person savePerson(Person person) {

    log.atInfo().log("Saving person %d.", person.getId());

    return personRepository.save(person);
  }

  @Override
  public Person createPerson(String firstName, String lastName, Date birthday) {

    log.atInfo().log("Creating new person named %s %s.", firstName, lastName);

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

  @Override
  public List<Person> getPersons() {

    return personRepository.findAll();
  }
}
