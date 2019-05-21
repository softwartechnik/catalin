package de.softwartechnik.catalin.gui.swing.view.bookings;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewBookingsPanel extends JPanel {

    private CatalinGUIViewBookingsTable bookingsTable = new CatalinGUIViewBookingsTable();
    private CatalinGUIViewBookingsSidebar sidepanel;

    @Inject
    public CatalinGUIViewBookingsPanel() {

        setLayout(new BorderLayout());
        sidepanel = new CatalinGUIViewBookingsSidebar();

        // Add table

        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        add(scrollPane, BorderLayout.CENTER);

        add(sidepanel, BorderLayout.EAST);
    }

    public CatalinGUIViewBookingsTable getBookingsTable() {
        return bookingsTable;
    }

    public CatalinGUIViewBookingsSidebar getSidepanel() {
        return sidepanel;
    }
}
