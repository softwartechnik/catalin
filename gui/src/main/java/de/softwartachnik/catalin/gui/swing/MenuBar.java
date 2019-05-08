package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuBar extends JMenuBar{

    public static final String STAFF = "Personal";
    public static final String SCHEDULE = "Dienstpläne";
    public static final String STAFF_OVERVIEW= "Übersicht Angestellte";
    public static final String BOOKINGS = " Buchungen";
    public static final String FLIGHTS = " Flüge";

    public MenuBar(){

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


        this.add(staff);
        this.add(bookings);
        this.add(flights);
    }

}
