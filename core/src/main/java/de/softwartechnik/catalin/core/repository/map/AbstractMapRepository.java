package de.softwartechnik.catalin.core.repository.map;

import com.google.common.collect.Maps;
import de.softwartechnik.catalin.core.model.CatalinModel;
import de.softwartechnik.catalin.core.repository.base.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AbstractMapRepository<EntityType extends CatalinModel> implements Repository<EntityType> {

    private final AtomicInteger idCounter = new AtomicInteger();
    private final Map<Long, EntityType> storage;
    private final Class<EntityType> entityClazz;

    public AbstractMapRepository(Class<EntityType> entityClazz) {
        this(Maps.newHashMap(), entityClazz);
    }

    public AbstractMapRepository(Map<Long, EntityType> storage, Class<EntityType> entityClazz) {
        this.storage = storage;
        this.entityClazz = entityClazz;
    }

    @Override
    public EntityType save(EntityType entity) {

        if (entity.getId() == 0) {
            entity.setId(idCounter.incrementAndGet());
        }

        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public EntityType find(long entityId) {

        return storage.get(entityId);
    }

    @Override
    public List<EntityType> findAll() {

        return new ArrayList<>(storage.values());
    }

    @Override
    public void remove(EntityType entity) {

        storage.values().remove(entity);
    }

    @Override
    public Class<EntityType> getEntityClass() {

        return entityClazz;
    }
}
