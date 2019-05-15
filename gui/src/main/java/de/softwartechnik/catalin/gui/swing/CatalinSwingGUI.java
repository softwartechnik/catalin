package de.softwartechnik.catalin.gui.swing;

import com.google.common.collect.Lists;
import de.softwartechnik.catalin.core.config.CatalinCoreConfig;
import de.softwartechnik.catalin.core.config.CatalinPersistenceMode;
import de.softwartechnik.catalin.core.model.Airline;
import de.softwartechnik.catalin.core.model.Airport;
import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.model.Plane;
import de.softwartechnik.catalin.core.model.Terminal;
import de.softwartechnik.catalin.core.service.AirlineService;
import de.softwartechnik.catalin.core.service.AirportService;
import de.softwartechnik.catalin.core.service.BookingService;
import de.softwartechnik.catalin.core.service.EmployeeService;
import de.softwartechnik.catalin.core.service.FlightService;
import de.softwartechnik.catalin.core.service.PersonService;
import de.softwartechnik.catalin.gui.CatalinGUI;
import de.softwartechnik.catalin.gui.swing.controller.CatalinGUIController;

import javax.inject.Inject;
import java.util.Date;

public class CatalinSwingGUI implements CatalinGUI {

    private final CatalinCoreConfig catalinCoreConfig;
    private final CatalinGUIController controller;

    private final PersonService personService;
    private final AirlineService airlineService;
    private final BookingService bookingService;
    private final AirportService airportService;
    private final FlightService flightService;

    @Inject
    public CatalinSwingGUI(CatalinCoreConfig catalinCoreConfig, CatalinGUIController controller, PersonService personService, AirlineService airlineService, BookingService bookingService, AirportService airportService, EmployeeService employeeService, FlightService flightService) {
        this.catalinCoreConfig = catalinCoreConfig;
        this.controller = controller;
        this.personService = personService;
        this.airlineService = airlineService;
        this.bookingService = bookingService;
        this.airportService = airportService;
        this.flightService = flightService;
    }

    @Override
    public void initialize() {
        if (catalinCoreConfig.getPersistenceMode() == CatalinPersistenceMode.SQL) {
            initMocks();
        }

        controller.showOverview();
    }

    private void initMocks() {

        // Create airlines
        Airline lufthansa = airlineService.createAirline("Lufthansa");
        Airline condor = airlineService.createAirline("Condor");

        // Create Planes
        Plane planeEnterprise = airlineService.addPlane(lufthansa, "Enterprises");
        Plane planeExcelsior = airlineService.addPlane(lufthansa, "Excelsior");

        Plane planeLocutus = airlineService.addPlane(condor, "Locutus");
        Plane planeUschi = airlineService.addPlane(condor, "Gorch Fock");

        // Create Airports
        Airport berlin = airportService.createAirport("Berlin");
        Airport ffm = airportService.createAirport("FFM");
        Airport london = airportService.createAirport("London");
        Airport munich = airportService.createAirport("Munich");

        // Create Employees
        Employee berlinEmployeeUschi = airportService.addEmployee(berlin, "Uschi", "Vondue");
        Employee ffmEmployeeDetlef = airportService.addEmployee(ffm, "Detlef", "King");
        Employee londonEmployeeChurchill = airportService.addEmployee(london, "Adolfus", "Chruchill");
        Employee munichEmployeeAlex = airportService.addEmployee(munich, "Alexander", "Der Große");

        // Create Terminals
        Terminal berlin1 = airportService.addTerminal(berlin, "Berlin 1");
        Terminal berlinVIPs = airportService.addTerminal(berlin, "VIPs");

        Terminal ffmInternational = airportService.addTerminal(ffm, "International");

        Terminal londonVIPs = airportService.addTerminal(london, "VIPs");
        Terminal londonRoyal = airportService.addTerminal(london, "Royals");
        Terminal londonCasual = airportService.addTerminal(london, "Casual");

        Terminal munichBS = airportService.addTerminal(munich, "Weißwurscht");

        // Create Flights
        Flight berlinLondon = flightService.createFlight("Flug 312", berlin1, londonVIPs, planeLocutus);
        Flight ffmMunich = flightService.createFlight("Flug sweet", ffmInternational, munichBS, planeUschi);
        Flight londonBerlin = flightService.createFlight("Flug Kamikaze", londonCasual, berlinVIPs, planeExcelsior);
        Flight londonMunich = flightService.createFlight("Flug", londonRoyal, munichBS, planeEnterprise);

        // Create Persons
        Person personFelix = personService.createPerson("Felix", "Klauke", new Date());
        Person personLena = personService.createPerson("Lena", "Weiß", new Date());
        Person personNiklas = personService.createPerson("Niklas", "Wirths", new Date());
        Person personLeonie = personService.createPerson("Leonie", "Arm", new Date());
        Person personLukas = personService.createPerson("Lukas", "Kluk", new Date());

        // Create Bookings
        Booking bookingFelixLondon = bookingService.bookFlight(personFelix, berlinLondon, Lists.newArrayList());
        Booking bookingLenaMunich = bookingService.bookFlight(personLena, ffmMunich, Lists.newArrayList());
        Booking bookingNiklasMunich = bookingService.bookFlight(personNiklas, ffmMunich, Lists.newArrayList());
        Booking bookingLeonieBerlin = bookingService.bookFlight(personLeonie, londonBerlin, Lists.newArrayList());
        Booking bookingLukasMunich = bookingService.bookFlight(personLukas, londonMunich, Lists.newArrayList());
    }
}
