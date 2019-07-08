package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.model.Terminal;
import de.softwartechnik.catalin.core.repository.FlightRepository;
import lombok.extern.flogger.Flogger;

import javax.inject.Inject;
import java.util.List;

@Flogger
public class CatalinFlightService implements FlightService {

    private final FlightRepository flightRepository;

    @Inject
    public CatalinFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight createFlight(String title, Terminal start, Terminal stop, Plane plane) {

        log.atInfo().log("Creating new flight %s from %s to %s with plane %d.", title, start.getName(), stop.getName(), plane.getId());

        Flight flight = new Flight(title, start, stop, plane);
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getFlights() {

        return flightRepository.findAll();
    }

    @Override
    public void cancelFlight(long id) {

        Flight flight = flightRepository.find(id);

        log.atInfo().log("Cancelling flight %s.", flight.getTitle());

        flightRepository.remove(flight);
    }
}
