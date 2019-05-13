package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.model.Terminal;

import java.util.List;

public interface FlightService {

    /**
     * Create a flight with the given title from the given start to the given stop with the given plane.
     *
     * @param title The title.
     * @param start The start.
     * @param stop The stop.
     * @param plane The plane.
     * @return The flight.
     */
    Flight createFlight(String title, Terminal start, Terminal stop, Plane plane);

    /**
     * Get all flights.
     *
     * @return The flights.
     */
    List<Flight> getFlights();

    /**
     * Cancel the given flight.
     *
     * @param id The id.
     */
    void cancelFlight(long id);
}
