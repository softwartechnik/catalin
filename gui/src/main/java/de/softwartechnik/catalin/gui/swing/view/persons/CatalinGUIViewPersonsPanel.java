package de.softwartechnik.catalin.gui.swing.view.persons;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewPersonsPanel extends JPanel {

    private final CatalinGUIViewPersonsTable table;
    private final CatalinGUIViewPersonsSidebar sidebar;

    @Inject
    public CatalinGUIViewPersonsPanel(CatalinGUIViewPersonsTable table, CatalinGUIViewPersonsSidebar sidebar) {
        this.table = table;
        this.sidebar = sidebar;

        setLayout(new BorderLayout());

        add(this.table, BorderLayout.CENTER);
        add(this.sidebar, BorderLayout.EAST);
    }

    public CatalinGUIViewPersonsSidebar getSidebar() {
        return sidebar;
    }

    public CatalinGUIViewPersonsTable getTable() {
        return table;
    }
}
