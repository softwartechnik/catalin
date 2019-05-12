package de.softwartechnik.catalin.gui.swing.controller;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.service.BookingService;
import de.softwartechnik.catalin.core.service.EmployeeService;
import de.softwartechnik.catalin.core.service.FlightService;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIView;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIViewNavigation;

import javax.inject.Inject;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.util.List;

public class CatalinGUIController {

    private final CatalinGUIView view;

    private final BookingService bookingService;
    private final FlightService flightService;
    private final EmployeeService employeeService;

    @Inject
    public CatalinGUIController(CatalinGUIView view, BookingService bookingService, FlightService flightService, EmployeeService employeeService) {
        this.view = view;
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
                view.showFlights(flightService.getFlights());
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
    }
}
