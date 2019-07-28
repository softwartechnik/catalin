package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airport;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class AirportJPARepository extends AbstractJPARepository<Airport> implements
    AirportRepository {

  /**
   * The class of the entity.
   */
  private static final Class<Airport> ENTITY_CLAZZ = Airport.class;

  @Inject
  public AirportJPARepository(Provider<EntityManager> entityManagerProvider) {
    super(ENTITY_CLAZZ, entityManagerProvider);
  }
}
