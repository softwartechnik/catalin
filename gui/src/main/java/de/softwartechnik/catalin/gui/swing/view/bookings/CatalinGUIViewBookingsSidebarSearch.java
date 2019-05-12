package de.softwartechnik.catalin.gui.swing.view.bookings;

import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewBookingsSidebarSearch extends JPanel {

    private JTextField searchfield;
    private JButton searchbutton;

    public CatalinGUIViewBookingsSidebarSearch(){

        setLayout(new FlowLayout());

        searchfield = new JTextField();
        searchfield.setColumns(25);
        searchbutton = new JButton("Suche");

        add(searchfield);
        add(searchbutton);
    }
}
