package de.softwartechnik.catalin.gui.swing.view.flights;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewFlightsSidebar extends JPanel {


    private final CatalinGUIViewFlightsSidebarButtons sidebarButtons;

    @Inject
    public CatalinGUIViewFlightsSidebar(CatalinGUIViewFlightsSidebarButtons sidebarButtons) {
        this.sidebarButtons = sidebarButtons;

        setLayout(new BorderLayout());
        add(this.sidebarButtons, BorderLayout.NORTH);
    }

    public CatalinGUIViewFlightsSidebarButtons getSidebarButtons() {
        return sidebarButtons;
    }
}
