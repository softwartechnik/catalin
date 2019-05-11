package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * The {@link PersonRepository} implementation based on JPA.
 */
public class PersonJPARepository extends AbstractJPARepository<Person> implements PersonRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Person> ENTITY_CLAZZ = Person.class;

    @Inject
    public PersonJPARepository(Provider<EntityManager> entityManager) {
        super(ENTITY_CLAZZ, entityManager);
    }
}
