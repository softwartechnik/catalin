package de.softwartechnik.catalin.core.repository.jpa;

import de.softwartechnik.catalin.core.repository.base.AbstractRepository;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * The {@link AbstractRepository} using a JPA {@link EntityManager} for persistence.
 *
 * @param <EntityType> The generic type of the entity.
 */
public abstract class AbstractJPARepository<EntityType> extends AbstractRepository<EntityType> {

    /**
     * The JPA entity manager.
     */
    private final Provider<EntityManager> entityManager;

    /**
     * Create a new repository by the managed entities class and the JPA entity manager.
     *
     * @param entityClazz   The class of the managed entity.
     * @param entityManagerProvider The JPA entity manager provider.
     */
    public AbstractJPARepository(Class<EntityType> entityClazz, Provider<EntityManager> entityManagerProvider) {
        super(entityClazz);
        entityManager = entityManagerProvider;
    }

    @Override
    @Transactional
    public EntityType save(EntityType entity) {

        entityManager.get().persist(entity);
        entityManager.get().flush();

        return entity;
    }

    @Override
    public EntityType find(long entityId) {

        return entityManager.get().find(getEntityClass(), entityId);
    }

    @Override
    public void remove(EntityType entity) {

        entityManager.get().getTransaction().begin();
        entityManager.get().remove(entity);
        entityManager.get().getTransaction().commit();
    }
}
