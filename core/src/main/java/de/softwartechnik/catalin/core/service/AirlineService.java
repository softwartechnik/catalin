package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Airline;

import java.util.List;

public interface AirlineService {

    Airline createAirline(String name);

    Airline getAirline(long airlineId);

    Airline removeAirline(Airline airline);

    List<Airline> getAirlines();
}
