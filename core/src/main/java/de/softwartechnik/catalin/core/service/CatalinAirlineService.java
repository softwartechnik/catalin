package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.repository.AirlineRepository;
import de.softwartechnik.catalin.core.repository.PlaneRepository;
import lombok.extern.flogger.Flogger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Flogger
public class CatalinAirlineService implements AirlineService {

    /**
     * The air line repository.
     */
    private final AirlineRepository airlineRepository;

    /**
     * The plane repository.
     */
    private final PlaneRepository planeRepository;

    /**
     * Create a new air line service by the underlying repositories.
     *
     * @param airlineRepository The air line repository.
     * @param planeRepository The plane repository.
     */
    @Inject
    public CatalinAirlineService(AirlineRepository airlineRepository, PlaneRepository planeRepository) {
        this.airlineRepository = airlineRepository;
        this.planeRepository = planeRepository;
    }

    @Override
    public Airline createAirline(String name) {

        log.atFine().log("Creating new airline named %s.", name);

        Airline airline = new Airline(name, new ArrayList<>());
        return airlineRepository.save(airline);
    }

    @Override
    public Plane addPlane(Airline airline, String name) {

        log.atFine().log("Adding plane named %s to airline %s", name, airline.getName());

        Plane plane = new Plane(name);
        airline.getPlanes().add(plane);
        airlineRepository.save(airline);
        planeRepository.save(plane);

        return plane;
    }

    @Override
    public Airline getAirline(long airlineId) {

        log.atFine().log("Loading airline with id %s.", airlineId);

        return airlineRepository.find(airlineId);
    }

    @Override
    public Airline removeAirline(Airline airline) {

        log.atFine().log("Deleting airline with id %s.", airline.getId());

        airlineRepository.remove(airline);
        return airline;
    }

    @Override
    public List<Airline> getAirlines() {

        log.atFine().log("Loading all airlines.");

        return airlineRepository.findAll();
    }
}
