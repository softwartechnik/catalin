package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.BookingExtra;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.BookingRepository;

import javax.inject.Inject;
import java.util.List;

public class CatalinBookingService implements BookingService {

    private final BookingRepository bookingRepository;

    @Inject
    public CatalinBookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking bookFlight(Person person, Flight flight, List<BookingExtra> extras) {

        Booking booking = new Booking(person, flight, extras);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookings() {

        return bookingRepository.findAll();
    }
}
