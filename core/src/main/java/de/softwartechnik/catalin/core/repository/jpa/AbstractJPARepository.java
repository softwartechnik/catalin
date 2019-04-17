package de.softwartechnik.catalin.core.repository.jpa;

import de.softwartechnik.catalin.core.repository.base.AbstractRepository;

import javax.persistence.EntityManager;

/**
 * The {@link AbstractRepository} using a JPA {@link EntityManager} for persistence.
 *
 * @param <EntityType> The generic type of the entity.
 */
public abstract class AbstractJPARepository<EntityType> extends AbstractRepository<EntityType> {

    /**
     * The JPA entity manager.
     */
    private final EntityManager entityManager;

    /**
     * Create a new repository by the managed entities class and the JPA entity manager.
     *
     * @param entityClazz   The class of the managed entity.
     * @param entityManager The JPA entity manager.
     */
    public AbstractJPARepository(Class<EntityType> entityClazz, EntityManager entityManager) {
        super(entityClazz);
        this.entityManager = entityManager;
    }

    @Override
    public EntityType save(EntityType entity) {

        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }

    @Override
    public EntityType find(long entityId) {

        return entityManager.find(getEntityClass(), entityId);
    }

    @Override
    public void remove(EntityType entity) {

        entityManager.remove(entity);
    }
}
