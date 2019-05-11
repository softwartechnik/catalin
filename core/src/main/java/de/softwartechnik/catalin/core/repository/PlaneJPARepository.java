package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class PlaneJPARepository extends AbstractJPARepository<Plane> implements PlaneRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Plane> ENTITY_CLAZZ = Plane.class;

    @Inject
    public PlaneJPARepository(Provider<EntityManager> entityManagerProvider) {
        super(ENTITY_CLAZZ, entityManagerProvider);
    }
}
