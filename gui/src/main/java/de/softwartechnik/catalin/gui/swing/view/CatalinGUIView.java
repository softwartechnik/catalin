package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.core.model.Person;
import de.softwartechnik.catalin.gui.swing.view.bookings.CatalinGUIViewBookingsPanel;
import de.softwartechnik.catalin.gui.swing.view.employees.CatalinGUIViewEmployeesPanel;
import de.softwartechnik.catalin.gui.swing.view.flights.CatalinGUIViewFlightsPanel;
import de.softwartechnik.catalin.gui.swing.view.overview.CatalinGUIViewOverviewPanel;
import de.softwartechnik.catalin.gui.swing.view.persons.CatalinGUIViewPersonsPanel;

import javax.swing.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalinGUIView extends JFrame {

    private static final String TITLE = "Catalin Flughafenverwaltung";

    private Logger logger = Logger.getLogger(CatalinGUIView.TITLE);

    private final CatalinGUIViewNavigation navigation;
    private final JPanel contentPane;

    public CatalinGUIView() {

        // Setup content
        setTitle(TITLE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        contentPane = new CatalinGUIViewPanel();
        setContentPane(contentPane);

        // Setup components
        navigation = new CatalinGUIViewNavigation();
        setJMenuBar(navigation);

        setVisible(true);
    }

    public void showOverview() {

        logger.log(Level.INFO, "Showing overview.");

        contentPane.removeAll();
        JPanel panel = new CatalinGUIViewOverviewPanel();
        contentPane.add(panel);

        setVisible(true);
    }

    public void showEmployees(List<Employee> employees) {

        logger.log(Level.INFO, "Showing employees.");

        contentPane.removeAll();
        JPanel panel = new CatalinGUIViewEmployeesPanel(employees);
        contentPane.add(panel);

        setVisible(true);
    }


    public void showBookings(List<Booking> bookings) {

        logger.log(Level.INFO, "Showing Bookings");

        contentPane.removeAll();
        JPanel panel = new CatalinGUIViewBookingsPanel(bookings);
        contentPane.add(panel);

        setVisible(true);
    }

    public CatalinGUIViewFlightsPanel showFlights(List<Flight> flights) {

        logger.log(Level.INFO, "Showing flights.");

        contentPane.removeAll();
        CatalinGUIViewFlightsPanel panel = new CatalinGUIViewFlightsPanel(flights);
        contentPane.add(panel);

        setVisible(true);
        return panel;
    }

    public CatalinGUIViewNavigation getNavigation() {
        return navigation;
    }

    public CatalinGUIViewPersonsPanel showPersons(List<Person> persons) {

        logger.log(Level.INFO, "Showing Persons.");

        contentPane.removeAll();
        CatalinGUIViewPersonsPanel panel = new CatalinGUIViewPersonsPanel(persons);
        contentPane.add(panel);

        setVisible(true);

        return panel;
    }
}
