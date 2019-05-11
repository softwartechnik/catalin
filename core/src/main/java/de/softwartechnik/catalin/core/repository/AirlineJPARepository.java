package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class AirlineJPARepository extends AbstractJPARepository<Airline> implements AirlineRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Airline> ENTITY_CLAZZ = Airline.class;

    @Inject
    public AirlineJPARepository(Provider<EntityManager> entityManagerProvider) {
        super(ENTITY_CLAZZ, entityManagerProvider);
    }
}
