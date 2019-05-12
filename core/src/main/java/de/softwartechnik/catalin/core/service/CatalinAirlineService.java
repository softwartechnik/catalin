package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.repository.AirlineRepository;
import de.softwartechnik.catalin.core.repository.PlaneRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CatalinAirlineService implements AirlineService {

    private final AirlineRepository airlineRepository;
    private final PlaneRepository planeRepository;

    @Inject
    public CatalinAirlineService(AirlineRepository airlineRepository, PlaneRepository planeRepository) {
        this.airlineRepository = airlineRepository;
        this.planeRepository = planeRepository;
    }

    @Override
    public Airline createAirline(String name) {

        Airline airline = new Airline(name, new ArrayList<>());
        return airlineRepository.save(airline);
    }

    @Override
    public Plane addPlane(Airline airline, String name) {

        Plane plane = new Plane(name);
        airline.getPlanes().add(plane);
        airlineRepository.save(airline);
        planeRepository.save(plane);

        return plane;
    }

    @Override
    public Airline getAirline(long airlineId) {

        return airlineRepository.find(airlineId);
    }

    @Override
    public Airline removeAirline(Airline airline) {

        airlineRepository.remove(airline);
        return airline;
    }

    @Override
    public List<Airline> getAirlines() {

        return airlineRepository.findAll();
    }
}
