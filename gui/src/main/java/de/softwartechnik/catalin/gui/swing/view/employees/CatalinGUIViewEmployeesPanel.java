package de.softwartechnik.catalin.gui.swing.view.employees;

import de.softwartechnik.catalin.core.model.Employee;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewEmployeesPanel extends JPanel {

    private final CatalinGUIViewEmployeesTable employeesTable = new CatalinGUIViewEmployeesTable();

    @Inject
    public CatalinGUIViewEmployeesPanel() {

        setLayout(new GridLayout(0, 2));

        // Add table
        JScrollPane scrollPane = new JScrollPane(employeesTable);
        add(scrollPane);
    }

    public CatalinGUIViewEmployeesTable getEmployeesTable() {
        return employeesTable;
    }
}
