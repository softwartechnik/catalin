package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.BookingExtra;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.repository.BookingRepository;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.flogger.Flogger;

@Flogger
public class CatalinBookingService implements BookingService {

  private final BookingRepository bookingRepository;

  @Inject
  public CatalinBookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  @Override
  public Booking bookFlight(Person person, Flight flight, List<BookingExtra> extras) {

    log.atInfo()
        .log("%s %s booking a new flight to %s", person.getFirstName(), person.getLastName(),
            flight.getDestination().getName());

    Booking booking = new Booking(person, flight, extras);
    return bookingRepository.save(booking);
  }

  @Override
  public List<Booking> getBookings() {

    return bookingRepository.findAll();
  }
}
