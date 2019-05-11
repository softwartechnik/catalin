package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.jpa.AbstractJPARepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class BookingJPARepository extends AbstractJPARepository<Booking> implements BookingRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Booking> ENTITY_CLAZZ = Booking.class;

    @Inject
    public BookingJPARepository(Provider<EntityManager> entityManagerProvider) {
        super(ENTITY_CLAZZ, entityManagerProvider);
    }
}
