package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;
import javax.inject.Inject;

public class AirlineMapRepository extends AbstractMapRepository<Airline> implements
    AirlineRepository {

  /**
   * The class of the entity.
   */
  private static final Class<Airline> ENTITY_CLAZZ = Airline.class;

  @Inject
  public AirlineMapRepository() {
    super(ENTITY_CLAZZ);
  }
}
