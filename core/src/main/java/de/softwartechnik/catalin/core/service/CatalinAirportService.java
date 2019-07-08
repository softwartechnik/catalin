package de.softwartechnik.catalin.core.service;

import de.softwartechnik.catalin.core.model.Airport;
import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Terminal;
import de.softwartechnik.catalin.core.repository.AirportRepository;
import de.softwartechnik.catalin.core.repository.EmployeeRepository;
import de.softwartechnik.catalin.core.repository.TerminalRepository;
import lombok.extern.flogger.Flogger;

import javax.inject.Inject;
import java.util.List;

@Flogger
public class CatalinAirportService implements AirportService {

    private final AirportRepository airportRepository;
    private final TerminalRepository terminalRepository;
    private final EmployeeRepository employeeRepository;

    @Inject
    public CatalinAirportService(AirportRepository airportRepository, TerminalRepository terminalRepository, EmployeeRepository employeeRepository) {
        this.airportRepository = airportRepository;
        this.terminalRepository = terminalRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Airport getAirport(long id) {

        return airportRepository.find(id);
    }

    @Override
    public List<Airport> getAirports() {

        return airportRepository.findAll();
    }

    @Override
    public Terminal addTerminal(Airport airport, String name) {

        Terminal terminal = new Terminal(name, airport);
        airport.getTerminals().add(terminal);

        airportRepository.save(airport);
        terminalRepository.save(terminal);

        return terminal;
    }

    @Override
    public Employee addEmployee(Airport airport, String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName, airport);
        airport.getEmployees().add(employee);

        airportRepository.save(airport);
        employeeRepository.save(employee);

        return employee;
    }

    @Override
    public Airport createAirport(String name) {

        log.atInfo().log("Creating new airport named %s.", name);

        Airport airport = new Airport(name);
        return airportRepository.save(airport);
    }
}
