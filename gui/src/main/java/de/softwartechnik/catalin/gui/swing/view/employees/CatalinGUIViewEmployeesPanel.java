package de.softwartechnik.catalin.gui.swing.view.employees;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

public class CatalinGUIViewEmployeesPanel extends JPanel {

    private final CatalinGUIViewEmployeesTable employeesTable = new CatalinGUIViewEmployeesTable();

    @Inject
    public CatalinGUIViewEmployeesPanel() {

        setLayout(new GridLayout(0, 1));

        // Add table
        JScrollPane scrollPane = new JScrollPane(employeesTable);
        add(scrollPane);
    }

    public CatalinGUIViewEmployeesTable getEmployeesTable() {
        return employeesTable;
    }
}
