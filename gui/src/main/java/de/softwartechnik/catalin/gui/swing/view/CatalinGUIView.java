package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewFlightsTableModel;
import de.softwartechnik.catalin.gui.swing.view.employees.CatalinGUIViewEmployeesPanel;
import de.softwartechnik.catalin.gui.swing.view.flights.CatalinGUIViewFlightsPanel;
import de.softwartechnik.catalin.gui.swing.view.overview.CatalinGUIViewOverviewPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIView extends JFrame {

    private static final String TITLE = "Catalin Flughafenverwaltung";

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

        contentPane.removeAll();
        JPanel panel = new CatalinGUIViewOverviewPanel();
        contentPane.add(panel);
    }

    public void showEmployees() {

        contentPane.removeAll();
        JPanel panel = new CatalinGUIViewEmployeesPanel();
        contentPane.add(panel);
    }


    public void showBookings(List<Booking> bookings) {

        contentPane.removeAll();
        // TODO
    }

    public void showFlights(List<Flight> flights) {

        contentPane.removeAll();
        JPanel panel = new CatalinGUIViewFlightsPanel(flights);
        contentPane.add(panel);
    }

    public CatalinGUIViewNavigation getNavigation() {
        return navigation;
    }
}
