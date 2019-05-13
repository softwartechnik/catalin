package de.softwartechnik.catalin.gui.swing.view.navigation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuListener;
import java.awt.*;

public class CatalinGUIViewNavigation extends JMenuBar {

    private final JMenu menuEmployees = new JMenu("Angestellte");
    private final JMenu menuBookings = new JMenu("Buchungen");
    private final JMenu menuFlights = new JMenu("Flüge");
    private final JMenu menuPersons = new JMenu("Personen");

    public CatalinGUIViewNavigation() {

        Border border = new LineBorder(Color.BLACK);
        setBorder(border);

        add(menuEmployees);
        add(menuBookings);
        add(menuFlights);
        add(menuPersons);
    }

    public void setPersonsMenuListener(MenuListener menuListener) {
        menuPersons.addMenuListener(menuListener);
    }

    public void setBookingsMenuListener(MenuListener menuListener) {
        menuBookings.addMenuListener(menuListener);
    }

    public void setEmployeesMenuListener(MenuListener menuListener) {
        menuEmployees.addMenuListener(menuListener);
    }

    public void setFlightsMenuListener(MenuListener menuListener) {
        menuFlights.addMenuListener(menuListener);
    }
}
