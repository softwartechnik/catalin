package de.softwartechnik.catalin.gui.swing.view.flights;

import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewFlightsSidebar extends JPanel {


    private final CatalinGUIViewFlightsSidebarButtons sidebarButtons;

    public CatalinGUIViewFlightsSidebar() {

        setLayout(new BorderLayout());

        sidebarButtons = new CatalinGUIViewFlightsSidebarButtons();
        add(sidebarButtons, BorderLayout.NORTH);
    }

    public CatalinGUIViewFlightsSidebarButtons getSidebarButtons() {
        return sidebarButtons;
    }
}
