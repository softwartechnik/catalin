package de.softwartechnik.catalin.gui.swing.view.bookings;

import de.softwartechnik.catalin.core.model.Booking;
import de.softwartechnik.catalin.gui.swing.view.employees.CatalinGUIViewEmployeesTable;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewBookingsPanel extends JPanel {

    private CatalinGUIViewBookingsTable bookingsTable = new CatalinGUIViewBookingsTable();
    private CatalinGUIViewBookingsSidebar sidepanel;

    @Inject
    public CatalinGUIViewBookingsPanel() {

        setLayout(new GridLayout(0, 2));
        sidepanel = new CatalinGUIViewBookingsSidebar();

        // Add table

        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        add(scrollPane);

        add(sidepanel);
    }

    public CatalinGUIViewBookingsTable getBookingsTable() {
        return bookingsTable;
    }

    public CatalinGUIViewBookingsSidebar getSidepanel() {
        return sidepanel;
    }
}
