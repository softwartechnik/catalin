package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;

import javax.inject.Inject;

public class PersonMapRepository extends AbstractMapRepository<Person> implements PersonRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Person> ENTITY_CLAZZ = Person.class;

    @Inject
    public PersonMapRepository() {
        super(ENTITY_CLAZZ);
    }
}
