package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Terminal;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class TerminalJPARepository extends AbstractJPARepository<Terminal> implements TerminalRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Terminal> ENTITY_CLAZZ = Terminal.class;

    @Inject
    public TerminalJPARepository(Provider<EntityManager> entityManagerProvider) {
        super(ENTITY_CLAZZ, entityManagerProvider);
    }
}
