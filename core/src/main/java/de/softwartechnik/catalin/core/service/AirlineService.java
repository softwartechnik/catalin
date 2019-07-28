package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Plane;
import java.util.List;

public interface AirlineService {

  /**
   * Create a new airline with the given name.
   *
   * @param name The name.
   * @return The airline.
   */
  Airline createAirline(String name);

  /**
   * Add the given plane to the given airline.
   *
   * @param airline The airline.
   * @param name The planes name.
   * @return The plane.
   */
  Plane addPlane(Airline airline, String name);

  /**
   * Get the airline with the given id.
   *
   * @param airlineId The id of the airline.
   * @return The airline.
   */
  Airline getAirline(long airlineId);

  /**
   * Remove the given airline.
   *
   * @param airline The airline.
   * @return The airline.
   */
  Airline removeAirline(Airline airline);

  /**
   * Get all airlines.
   *
   * @return The airlines.
   */
  List<Airline> getAirlines();
}
