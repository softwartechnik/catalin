package de.softwartechnik.catalin.gui.swing.view.flights;

import de.softwartechnik.catalin.core.model.Flight;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewFlightsPanel extends JPanel {

    private final CatalinGUIViewFlightsTable table;
    private final CatalinGUIViewFlightsSidebar sidebar;

    public CatalinGUIViewFlightsPanel(List<Flight> flights) {

        setLayout(new GridLayout(0, 2));

        // Add table
        table = new CatalinGUIViewFlightsTable(flights);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        // Add sidebar
        sidebar = new CatalinGUIViewFlightsSidebar();
        add(sidebar);
    }

    public CatalinGUIViewFlightsSidebar getSidebar() {
        return sidebar;
    }

    public CatalinGUIViewFlightsTable getTable() {
        return table;
    }
}