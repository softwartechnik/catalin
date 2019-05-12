package de.softwartechnik.catalin.gui.swing.view.flights;

import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewFlightsSidebar extends JPanel {

    private final JButton deleteButton;

    public CatalinGUIViewFlightsSidebar() {

        setLayout(new BorderLayout());

        deleteButton = new JButton("Löschen");
        add(deleteButton);
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
