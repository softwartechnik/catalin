package de.softwartechnik.catalin.gui.swing.view.bookings;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.gui.swing.view.employees.CatalinGUIViewEmployeesTable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewBookingsPanel extends JPanel {

    private JPanel sidepanel;
    public CatalinGUIViewBookingsPanel(List<Booking> bookings) {

        setLayout(new GridLayout(0, 2));
        sidepanel = new CatalinGUIViewBookingsSidebar();

        // Add table
        JTable table = new CatalinGUIViewBookingsTable(bookings);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        add(sidepanel);
    }
}
