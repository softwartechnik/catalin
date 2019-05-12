package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.model.Terminal;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;

import javax.inject.Inject;
import java.util.Map;

public class FlightMapRepository extends AbstractMapRepository<Flight> implements FlightRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Flight> ENTITY_CLAZZ = Flight.class;

    @Inject
    public FlightMapRepository() {
        super(ENTITY_CLAZZ);
    }
}
