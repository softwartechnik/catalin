package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.BookingExtra;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Person;
import java.util.List;

public interface BookingService {

  /**
   * Book a flight for the given person.
   *
   * @param person The person.
   * @param flight The flight.
   * @return The booking.
   */
  Booking bookFlight(Person person, Flight flight, List<BookingExtra> extras);

  /**
   * Get all bookings.
   *
   * @return The bookings.
   */
  List<Booking> getBookings();
}
