package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;

import javax.inject.Inject;

public class PlaneMapRepository extends AbstractMapRepository<Plane> implements PlaneRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Plane> ENTITY_CLAZZ = Plane.class;

    @Inject
    public PlaneMapRepository() {
        super(ENTITY_CLAZZ);
    }
}
