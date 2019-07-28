package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Terminal;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;
import javax.inject.Inject;

public class TerminalMapRepository extends AbstractMapRepository<Terminal> implements
    TerminalRepository {

  /**
   * The class of the entity.
   */
  private static final Class<Terminal> ENTITY_CLAZZ = Terminal.class;

  @Inject
  public TerminalMapRepository() {
    super(ENTITY_CLAZZ);
  }
}
