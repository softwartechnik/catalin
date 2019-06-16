package de.softwartechnik.catalin.gui.swing.controller;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.service.BookingService;
import de.softwartechnik.catalin.core.service.EmployeeService;
import de.softwartechnik.catalin.core.service.FlightService;
import de.softwartechnik.catalin.core.service.PersonService;
import de.softwartechnik.catalin.gui.swing.model.BookingsTableModel;
import de.softwartechnik.catalin.gui.swing.model.EmployeesTableModel;
import de.softwartechnik.catalin.gui.swing.model.FlightsTableModel;
import de.softwartechnik.catalin.gui.swing.model.PersonsTableModel;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIBookingsView;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIEmployeesView;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIFlightsView;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIMainView;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIPersonsView;
import de.softwartechnik.catalin.gui.swing.view.navigation.CatalinGUIViewNavigation;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsDetails;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsPanel;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsTable;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.xml.transform.sax.SAXSource;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.List;

public class CatalinGUIController {

    private final CatalinGUIMainView view;

    private final PersonService personService;
    private final BookingService bookingService;
    private final FlightService flightService;
    private final EmployeeService employeeService;

    private final CatalinGUIFlightsView flightsView;
    private final CatalinGUIBookingsView bookingsView;
    private final CatalinGUIEmployeesView employeesView;
    private final CatalinGUIPersonsView personsView;

    @Inject
    public CatalinGUIController(CatalinGUIMainView view, PersonService personService, BookingService bookingService, FlightService flightService, EmployeeService employeeService, CatalinGUIFlightsView flightsView, CatalinGUIBookingsView bookingsView, CatalinGUIEmployeesView employeesView, CatalinGUIPersonsView personsView) {
        this.view = view;
        this.personService = personService;
        this.bookingService = bookingService;
        this.flightService = flightService;
        this.employeeService = employeeService;
        this.flightsView = flightsView;
        this.bookingsView = bookingsView;
        this.employeesView = employeesView;
        this.personsView = personsView;

        setupListeners();
    }

    private void setupListeners() {

        CatalinGUIViewNavigation navigation = view.getNavigation();

        navigation.setPersonsMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                showPersons();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        navigation.setBookingsMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                showBookings();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        navigation.setEmployeesMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                showEmployees();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        navigation.setFlightsMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                showFlights();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        personsView.setAddButtonListener(click -> {
            String firstName = personsView.getFormFirstName();
            String lastName = personsView.getFormLastName();
            Date birthday = personsView.getFormBirthday();

            Person person = personService.createPerson(firstName, lastName, birthday);
            personsView.getPersonsModel().addPerson(person);

            personsView.resetForm();
        });

        personsView.setEditButtonListener(click -> {
            CatalinGUIViewPersonsPanel myPanel = (CatalinGUIViewPersonsPanel)personsView.getComponent();
            if(myPanel.getTable().getSelectedRow() != -1){

                /*
                Nur zum Ausprobieren, hier muss die ausgewählte Person eingefügt werden,
                oder direkt in CatalinGUIViewPersonsDetails injected werden.
                 */
                Person meinePerson = new Person();
                meinePerson.setFirstName("Mein Vorname");
                meinePerson.setLastName("Mein Nachname");
                meinePerson.setBirthday(new Date());
                CatalinGUIViewPersonsDetails det = new CatalinGUIViewPersonsDetails(meinePerson);

                det.getSave().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Hier die Änderungen speichern
                    }
                });
            }
        });


        flightsView.setDeleteButtonListener(click -> {

            int selectedFlight = flightsView.getSelectedFlight();

            FlightsTableModel flightsModel = flightsView.getFlightsModel();
            long flightId = (long) flightsModel.getValueAt(selectedFlight, 0);

            flightService.cancelFlight(flightId);
            flightsModel.removeFlight(selectedFlight);
        });

        bookingsView.setSearchButtonListener(click -> {

            String searchWord = bookingsView.getSearchWord();

            RowFilter rowFilter = new CatalinRowFilter(searchWord);

            bookingsView.filterTable(rowFilter);
        });
    }

    public void showOverview() {

    }

    public void showFlights() {

        List<Flight> flights = flightService.getFlights();
        FlightsTableModel flightsTableModel = new FlightsTableModel(flights);

        flightsView.setFlightsModel(flightsTableModel);

        view.setView(flightsView);
    }

    public void showBookings() {

        List<Booking> bookings = bookingService.getBookings();
        BookingsTableModel bookingsTableModel = new BookingsTableModel(bookings);

        bookingsView.setBookingsModel(bookingsTableModel);

        view.setView(bookingsView);
    }

    public void showEmployees() {

        List<Employee> employees = employeeService.getEmployees();
        EmployeesTableModel employeesTableModel = new EmployeesTableModel(employees);

        employeesView.setEmployeesModel(employeesTableModel);

        view.setView(employeesView);
    }

    public void showPersons() {

        List<Person> persons = personService.getPersons();
        PersonsTableModel personsTableModel = new PersonsTableModel(persons);

        personsView.setPersonsModel(personsTableModel);
        view.setView(personsView);
    }
}
