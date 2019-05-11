package de.softwartechnik.catalin.core.repository.base;

import de.softwartechnik.catalin.core.model.CatalinModel;

/**
 * Part implementation of the {@link Repository} that can store the entity class.
 *
 * @param <EntityType> The generic type of the entity.
 */
public abstract class AbstractRepository<EntityType extends CatalinModel> implements Repository<EntityType> {

    /**
     * The class of the managed entity.
     */
    private final Class<EntityType> entityClazz;

    /**
     * Create a new repository by the managed entities class.
     *
     * @param entityClazz The class of the managed entity.
     */
    public AbstractRepository(Class<EntityType> entityClazz) {
        this.entityClazz = entityClazz;
    }

    @Override
    public Class<EntityType> getEntityClass() {

        return entityClazz;
    }
}
