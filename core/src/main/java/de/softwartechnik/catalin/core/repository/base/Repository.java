package de.softwartechnik.catalin.core.repository.base;

import de.softwartechnik.catalin.core.model.CatalinModel;

import java.util.List;

/**
 * A simple CRUD repository.
 *
 * @param <EntityType> The type of the entity.
 */
public interface Repository<EntityType extends CatalinModel> {

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
     * Find all entities.
     *
     * @return The entities.
     */
    List<EntityType> findAll();

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
