package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.BookingExtra;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class BookingExtraJPARepository extends AbstractJPARepository<BookingExtra> implements BookingExtraRepository {

    /**
     * The class of the entity.
     */
    private static final Class<BookingExtra> ENTITY_CLAZZ = BookingExtra.class;

    @Inject
    public BookingExtraJPARepository(Provider<EntityManager> entityManagerProvider) {
        super(ENTITY_CLAZZ, entityManagerProvider);
    }
}
