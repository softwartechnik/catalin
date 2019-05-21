package de.softwartechnik.catalin.gui.swing.view.persons;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewPersonsPanel extends JPanel {

    private final CatalinGUIViewPersonsTable table;
    private final CatalinGUIViewPersonsSidebar sidebar;

    @Inject
    public CatalinGUIViewPersonsPanel() {

        setLayout(new BorderLayout());

        table = new CatalinGUIViewPersonsTable();
        sidebar = new CatalinGUIViewPersonsSidebar();

        add(table, BorderLayout.CENTER);
        add(sidebar, BorderLayout.EAST);
    }

    public CatalinGUIViewPersonsSidebar getSidebar() {
        return sidebar;
    }

    public CatalinGUIViewPersonsTable getTable() {
        return table;
    }
}
