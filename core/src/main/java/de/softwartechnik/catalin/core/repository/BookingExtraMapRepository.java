package de.softwartechnik.catalin.core.repository;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.BookingExtra;
import de.softwartechnik.catalin.core.repository.map.AbstractMapRepository;

import javax.inject.Inject;

public class BookingExtraMapRepository extends AbstractMapRepository<BookingExtra> implements BookingExtraRepository {

    /**
     * The class of the entity.
     */
    private static final Class<BookingExtra> ENTITY_CLAZZ = BookingExtra.class;

    @Inject
    public BookingExtraMapRepository() {
        super(ENTITY_CLAZZ);
    }
}
