package de.softwartechnik.catalin.gui.swing.view.flights;

import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewFlightsSidebarButtons extends JPanel {

    private final JButton deleteButton;

    public CatalinGUIViewFlightsSidebarButtons() {

        setLayout(new FlowLayout());

        deleteButton = new JButton("Löschen");
        add(deleteButton);
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
}
