package de.softwartechnik.catalin.gui.swing.view.employees;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewEmployeesTableModel;

import javax.swing.*;
import java.util.List;

public class CatalinGUIViewEmployeesTable extends JTable {

    private final CatalinGUIViewEmployeesTableModel tableModel = new CatalinGUIViewEmployeesTableModel();

    public CatalinGUIViewEmployeesTable() {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);

        setModel(tableModel);
    }

    public void setEmployees(List<Employee> employees) {

        tableModel.clear();
        tableModel.addEntities(employees);
    }
}
