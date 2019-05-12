package de.softwartechnik.catalin.gui.swing.view.bookings;

import de.softwartechnik.catalin.gui.swing.view.flights.CatalinGUIViewFlightsSidebarButtons;

import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewBookingsSidebar extends JPanel{


    private final JPanel sidebarSearch;

    public CatalinGUIViewBookingsSidebar() {

        setLayout(new BorderLayout());

        sidebarSearch= new CatalinGUIViewBookingsSidebarSearch();
        add(sidebarSearch, BorderLayout.NORTH);
    }

}
