package de.softwartechnik.catalin.gui.swing.view.flights;

import de.softwartechnik.catalin.core.model.Flight;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewFlightsPanel extends JPanel {

    public CatalinGUIViewFlightsPanel(List<Flight> flights) {

        setLayout(new GridLayout(0, 1));

        // Add table
        JTable table = new CatalinGUIViewFlightsTable(flights);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
