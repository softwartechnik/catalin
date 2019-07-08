package de.softwartechnik.catalin.gui.swing.view.navigation;

import de.softwartechnik.catalin.gui.service.LanguageService;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuListener;
import java.awt.*;

public class CatalinGUIViewNavigation extends JMenuBar {

    private final LanguageService languageService;

    private final JMenu menuEmployees;
    private final JMenu menuBookings;
    private final JMenu menuFlights;
    private final JMenu menuPersons;

    @Inject
    public CatalinGUIViewNavigation(LanguageService languageService) {
        this.languageService = languageService;
        Border border = new LineBorder(Color.BLACK);
        setBorder(border);

        menuEmployees = new JMenu(languageService.translate("navigation.employees"));
        menuBookings = new JMenu(languageService.translate("navigation.bookings"));
        menuFlights = new JMenu(languageService.translate("navigation.flights"));
        menuPersons = new JMenu(languageService.translate("navigation.persons"));

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
