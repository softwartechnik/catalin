package de.softwartechnik.catalin.gui.swing.view.employees;

import de.softwartechnik.catalin.core.model.Employee;
import de.softwartechnik.catalin.gui.swing.model.CatalinGUIViewEmployeesTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.List;

public class CatalinGUIViewEmployeesTable extends JTable {

    public CatalinGUIViewEmployeesTable(List<Employee> employees) {

        getTableHeader().setReorderingAllowed(true);
        getTableHeader().setResizingAllowed(true);

        TableModel model = new CatalinGUIViewEmployeesTableModel(employees);
        setModel(model);
    }
}
