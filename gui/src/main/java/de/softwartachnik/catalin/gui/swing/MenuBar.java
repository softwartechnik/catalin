package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

class MenuBar extends JMenuBar {

    private static final String STAFF = "Personal";
    private static final String SCHEDULE = "Dienstpläne";
    private static final String STAFF_OVERVIEW = "Übersicht Angestellte";
    private static final String BOOKINGS = " Buchungen";
    private static final String FLIGHTS = " Flüge";

    MenuBar() {

        //border with color
        Border border = new LineBorder(Color.black);
        this.setBorder(border);

        //create Menus and Items
        JMenu staff = new JMenu(STAFF);
        JMenuItem schedule = new JMenuItem(SCHEDULE);
        schedule.setName("TESTNAME");
        JMenuItem staff_overview = new JMenuItem(STAFF_OVERVIEW);
        staff.add(schedule);
        staff.add(staff_overview);
        JMenu bookings = new JMenu(BOOKINGS);
        JMenu flights = new JMenu(FLIGHTS);


        add(staff);
        add(bookings);
        add(flights);
    }
}
