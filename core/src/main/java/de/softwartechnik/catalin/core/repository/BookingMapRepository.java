package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;

import javax.inject.Inject;

public class BookingMapRepository extends AbstractMapRepository<Booking> implements BookingRepository {

    /**
     * The class of the entity.
     */
    private static final Class<Booking> ENTITY_CLAZZ = Booking.class;

    @Inject
    public BookingMapRepository() {
        super(ENTITY_CLAZZ);
    }
}
