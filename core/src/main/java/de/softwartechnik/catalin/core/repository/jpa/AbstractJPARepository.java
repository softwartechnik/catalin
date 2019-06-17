package de.softwartechnik.catalin.core.repository.jpa;

import de.softwartechnik.catalin.core.model.CatalinModel;
import de.softwartechnik.catalin.core.repository.base.AbstractRepository;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * The {@link AbstractRepository} using a JPA {@link EntityManager} for persistence.
 *
 * @param <EntityType> The generic type of the entity.
 */
public abstract class AbstractJPARepository<EntityType extends CatalinModel> extends AbstractRepository<EntityType> {

    /**
     * The JPA entity manager.
     */
    private final Provider<EntityManager> entityManager;

    /**
     * Create a new repository by the managed entities class and the JPA entity manager.
     *
     * @param entityClazz           The class of the managed entity.
     * @param entityManagerProvider The JPA entity manager provider.
     */
    public AbstractJPARepository(Class<EntityType> entityClazz, Provider<EntityManager> entityManagerProvider) {
        super(entityClazz);
        entityManager = entityManagerProvider;
    }

    /**
     * Get the entity manager out of the provider.
     *
     * @return The entity manager.
     */
    EntityManager getEntityManager() {

        return entityManager.get();
    }

    @Override
    @Transactional
    public EntityType save(EntityType entity) {

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();

        return entity;
    }

    @Override
    public EntityType find(long entityId) {

        return getEntityManager().find(getEntityClass(), entityId);
    }

    @Override
    public boolean exists(long entityId) {

        return getEntityManager().getReference(getEntityClass(), entityId) != null;
    }

    @Override
    public List<EntityType> findAll() {

        CriteriaQuery<EntityType> query = getEntityManager()
                .getCriteriaBuilder()
                .createQuery(getEntityClass());
        Root<EntityType> entityTypeRoot = query.from(getEntityClass());
        CriteriaQuery<EntityType> findAllQuery = query.select(entityTypeRoot);

        return getEntityManager().createQuery(findAllQuery).getResultList();
    }

    @Override
    public void remove(EntityType entity) {

        getEntityManager().getTransaction().begin();
        getEntityManager().remove(entity);
        getEntityManager().getTransaction().commit();
    }
}
