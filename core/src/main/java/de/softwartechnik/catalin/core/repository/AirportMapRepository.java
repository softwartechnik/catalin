package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airport;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;

import javax.inject.Inject;

public class AirportMapRepository extends AbstractMapRepository<Airport> implements AirportRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Airport> ENTITY_CLAZZ = Airport.class;

    @Inject
    public AirportMapRepository() {
        super(ENTITY_CLAZZ);
    }
}
