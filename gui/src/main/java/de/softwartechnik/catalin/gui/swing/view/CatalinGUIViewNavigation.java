package de.softwartechnik.catalin.gui.swing.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CatalinGUIViewNavigation extends JMenuBar {

    private final JMenu menuEmployees = new JMenu("Angestellte");
    private final JMenu menuBookings = new JMenu("Buchungen");
    private final JMenu menuFlights = new JMenu("Flüge");
    private final JMenu menuPersons = new JMenu("Personen");

    CatalinGUIViewNavigation() {

        Border border = new LineBorder(Color.BLACK);
        setBorder(border);

        add(menuEmployees);
        add(menuBookings);
        add(menuFlights);
        add(menuPersons);
    }

    public JMenu getMenuBookings() {

        return menuBookings;
    }

    public JMenu getMenuEmployees() {

        return menuEmployees;
    }

    public JMenu getMenuFlights() {

        return menuFlights;
    }

    public JMenu getMenuPersons() {

        return menuPersons;
    }
}