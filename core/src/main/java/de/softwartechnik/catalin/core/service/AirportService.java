package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Airport;
import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Terminal;
import java.util.List;

public interface AirportService {

  /**
   * Get the airport with the given id.
   *
   * @param id The id.
   * @return The airport.
   */
  Airport getAirport(long id);

  /**
   * Get all airports.
   *
   * @return The airports.
   */
  List<Airport> getAirports();

  /**
   * Add a terminal to the given airport.
   *
   * @param airport The airport.
   * @param name The name of the terminal
   * @return The terminal.
   */
  Terminal addTerminal(Airport airport, String name);

  /**
   * Add a new employee to this airport.
   *
   * @param firstName The first name of the employee.
   * @param lastName The last name of the employee.
   * @return The employee.
   */
  Employee addEmployee(Airport airport, String firstName, String lastName);

  /**
   * Create an airport with the given name.
   *
   * @param name The name.
   * @return The airport.
   */
  Airport createAirport(String name);
}
