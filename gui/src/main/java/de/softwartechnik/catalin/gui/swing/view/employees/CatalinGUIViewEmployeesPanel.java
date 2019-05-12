package de.softwartechnik.catalin.gui.swing.view.employees;

import de.softwartechnik.catalin.core.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CatalinGUIViewEmployeesPanel extends JPanel {


    public CatalinGUIViewEmployeesPanel(List<Employee> employees) {

        setLayout(new GridLayout(0, 2));

        // Add table
        JTable table = new CatalinGUIViewEmployeesTable(employees);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
