package de.softwartechnik.catalin.gui.swing.controller;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.core.service.BookingService;
import de.softwartechnik.catalin.core.service.EmployeeService;
import de.softwartechnik.catalin.core.service.FlightService;
import de.softwartechnik.catalin.core.service.PersonService;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIView;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIViewNavigation;
import de.softwartechnik.catalin.gui.swing.view.flights.CatalinGUIViewFlightsPanel;
import de.softwartechnik.catalin.gui.swing.view.flights.CatalinGUIViewFlightsTable;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsPanel;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsSidebar;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CatalinGUIController {

    private final CatalinGUIView view;

    private final PersonService personService;
    private final BookingService bookingService;
    private final FlightService flightService;
    private final EmployeeService employeeService;

    @Inject
    public CatalinGUIController(CatalinGUIView view, PersonService personService, BookingService bookingService, FlightService flightService, EmployeeService employeeService) {
        this.view = view;
        this.personService = personService;
        this.bookingService = bookingService;
        this.flightService = flightService;
        this.employeeService = employeeService;

        setupListeners();
    }

    public void showOverview() {

        view.showOverview();
    }

    /**
     * Setup all action listeners
     */
    private void setupListeners() {

        // Setup navigation
        CatalinGUIViewNavigation navigation = view.getNavigation();

        navigation.getMenuFlights().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                List<Flight> flights = flightService.getFlights();
                view.showFlights(flights);
            }
            @Override
            public void menuDeselected(MenuEvent e) { }
            @Override
            public void menuCanceled(MenuEvent e) { }
        });

        navigation.getMenuBookings().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                view.showBookings(bookingService.getBookings());
            }
            @Override
            public void menuDeselected(MenuEvent e) { }
            @Override
            public void menuCanceled(MenuEvent e) { }
        });

        navigation.getMenuEmployees().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                view.showEmployees(employeeService.getEmployees());
            }
            @Override
            public void menuDeselected(MenuEvent e) { }
            @Override
            public void menuCanceled(MenuEvent e) { }
        });;

        navigation.getMenuPersons().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                List<Person> persons = personService.getPersons();

                CatalinGUIViewPersonsPanel catalinGUIViewPersonsPanel = view.showPersons(persons);
                CatalinGUIViewPersonsSidebar sidebar = catalinGUIViewPersonsPanel.getSidebar();

                JButton buttonAdd = sidebar.getButtonAdd();
                buttonAdd.addActionListener(click -> {
                    try {
                        personService.createPerson(sidebar.getTextFieldFirstName().getText(),
                                sidebar.getTextFieldLastName().getText(), new SimpleDateFormat().parse(sidebar.getTextFieldDate().getText()));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                });
            }
            @Override
            public void menuDeselected(MenuEvent e) { }
            @Override
            public void menuCanceled(MenuEvent e) { }
        });
    }
}
