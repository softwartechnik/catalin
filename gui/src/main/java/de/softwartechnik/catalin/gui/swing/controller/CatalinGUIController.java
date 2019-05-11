package de.softwartechnik.catalin.gui.swing.controller;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.service.BookingService;
import de.softwartechnik.catalin.core.service.FlightService;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIView;
import de.softwartechnik.catalin.gui.swing.view.CatalinGUIViewNavigation;

import javax.inject.Inject;
import java.util.List;

public class CatalinGUIController {

    private final CatalinGUIView view;

    private final BookingService bookingService;
    private final FlightService flightService;

    @Inject
    public CatalinGUIController(CatalinGUIView view, BookingService bookingService, FlightService flightService) {
        this.view = view;
        this.bookingService = bookingService;
        this.flightService = flightService;

        setupListeners();
    }


    public void showOverview() {

        List<Flight> flights = flightService.getFlights();
        view.showFlights(flights);
    }

    /**
     * Setup all action listeners
     */
    private void setupListeners() {

        // Setup navigation
        CatalinGUIViewNavigation navigation = view.getNavigation();

        navigation.getMenuFlights().addActionListener(click -> view.showFlights(flightService.getFlights()));
        navigation.getMenuBookings().addActionListener(click -> view.showBookings(bookingService.getBookings()));
        navigation.getMenuEmployees().addActionListener(click -> view.showEmployees());
    }
}
