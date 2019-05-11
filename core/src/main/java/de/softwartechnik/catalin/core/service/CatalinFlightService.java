package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.model.Terminal;
import de.softwartechnik.catalin.core.repository.FlightRepository;

import javax.inject.Inject;

public class CatalinFlightService implements FlightService {

    private final FlightRepository flightRepository;

    @Inject
    public CatalinFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight createFlight(String title, Terminal start, Terminal stop, Plane plane) {

        Flight flight = new Flight(title, start, stop, plane);
        return flightRepository.save(flight);
    }
}
