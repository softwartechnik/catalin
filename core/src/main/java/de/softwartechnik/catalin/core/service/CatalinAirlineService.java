package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.repository.AirlineRepository;

import javax.inject.Inject;
import java.util.List;

public class CatalinAirlineService implements AirlineService {

    private final AirlineRepository airlineRepository;

    @Inject
    public CatalinAirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline createAirline(String name) {

        Airline airline = new Airline(name);
        return airlineRepository.save(airline);
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
