package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.core.model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewPersonsPanel extends JPanel {

    private final CatalinGUIViewPersonsTable table;
    private final CatalinGUIViewPersonsSidebar sidebar;

    public CatalinGUIViewPersonsPanel(List<Person> persons) {

        setLayout(new GridLayout(1, 2));

        table = new CatalinGUIViewPersonsTable(persons);
        sidebar = new CatalinGUIViewPersonsSidebar();

        add(table);
        add(sidebar);
    }

    public CatalinGUIViewPersonsSidebar getSidebar() {
        return sidebar;
    }

    public CatalinGUIViewPersonsTable getTable() {
        return table;
    }
}