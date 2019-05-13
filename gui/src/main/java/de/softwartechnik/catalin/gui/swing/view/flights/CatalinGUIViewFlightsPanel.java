package de.softwartechnik.catalin.gui.swing.view.flights;

import de.softwartechnik.catalin.core.model.Flight;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewFlightsPanel extends JPanel {

    private final CatalinGUIViewFlightsTable table;
    private final CatalinGUIViewFlightsSidebar sidebar;

    @Inject
    public CatalinGUIViewFlightsPanel() {

        setLayout(new BorderLayout());

        // Add table
        table = new CatalinGUIViewFlightsTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Add sidebar
        sidebar = new CatalinGUIViewFlightsSidebar();
        add(sidebar, BorderLayout.EAST);
    }

    public CatalinGUIViewFlightsSidebar getSidebar() {
        return sidebar;
    }

    public CatalinGUIViewFlightsTable getTable() {
        return table;
    }
}
