package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class FlightJPARepository extends AbstractJPARepository<Flight> implements FlightRepository {

  /**
   * The class of the entity.
   */
  private static final Class<Flight> ENTITY_CLAZZ = Flight.class;

  @Inject
  public FlightJPARepository(Provider<EntityManager> entityManagerProvider) {
    super(ENTITY_CLAZZ, entityManagerProvider);
  }
}
