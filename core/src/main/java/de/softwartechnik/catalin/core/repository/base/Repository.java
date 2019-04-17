package de.softwartechnik.catalin.core.repository.base;

/**
 * A simple CRUD repository.
 *
 * @param <EntityType> The type of the entity.
 */
public interface Repository<EntityType> {

    /**
     * Save the given entity.
     *
     * @param entity The entity.
     *
     * @return The entity.
     */
    EntityType save(EntityType entity);

    /**
     * Find an entity by its primary id.
     *
     * @param entityId The id of the entity.
     *
     * @return The entity.
     */
    EntityType find(long entityId);

    /**
     * Delete an entity.
     *
     * @param entity The entity.
     */
    void remove(EntityType entity);

    /**
     * Get the class of the managed entity.
     *
     * @return The class of the managed entity.
     */
    Class<EntityType> getEntityClass();
}
